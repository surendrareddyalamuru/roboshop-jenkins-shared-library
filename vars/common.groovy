def codeCheckout() {
    stage('Code Checkout') {
        sh 'find . | sed 1d |xargs rm -rf'
        git branch: 'main', url: "https://github.com/surendrareddyalamuru/${COMPONENT}.git"
    }
}

def codequality() {
    stage('Code quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
        sh '''
        
         #sonar-scanner -Dsonar.host.url=http://172.31.5.208:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectKey=${COMPONENT} -Dsonar.qualitygate.wait=true ${SONAR_EXTRA_OPTS}
         echo ok
        '''
      }
    }
}

def codechecks() {
    if ( env.BRANCH_NAME == "main" || env.TAG_NAME ==~ ".*") {
        stage('Style Checks') {
            echo 'style checks'
        }
        stage('unit tests') {
            echo 'unit tests'
        }
    }
}

def artifacts() {
    if ( env.TAG_NAME ==~ ".*" ) {

    stage('Prepare Artifacts') {
        if (env.APPTYPE == "nodejs") {
            sh '''
          npm install 
          zip -r ${COMPONENT}-${TAG_NAME}.zip node_modules server.js 
        '''
        }
        if (env.APPTYPE == "java") {
            sh '''
          mvn clean package 
          mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar 
          zip -r ${COMPONENT}-${TAG_NAME}.zip ${COMPONENT}.jar
        '''
        }
        if (env.APPTYPE == "python") {
            sh '''
          zip -r ${COMPONENT}-${TAG_NAME}.zip *.py ${COMPONENT}.ini requirements.txt
        '''
        }
        if (env.APPTYPE == "nginx") {
            sh '''
              cd static
              zip -r ../${COMPONENT}-${TAG_NAME}.zip *
        '''
        }
    }

        stage('publish Artifacts') {
            echo 'publish artifacts'
        }
    }
}