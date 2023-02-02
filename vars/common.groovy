def codequality() {
    stage('Code quality') {
        withCredentials([usernamePassword(credentialsId: 'SONAR', passwordVariable: 'sonarPass', usernameVariable: 'sonarUser')]) {
        sh '''
        
         sonar-scanner -Dsonar.host.url=http://172.31.5.208:9000 -Dsonar.login=${sonarUser} -Dsonar.password=${sonarPass} -Dsonar.projectkey=${COMPONENT} -Dsonar.qualitygate.wait=true
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
    if ( env.TAG_NAME ==~ ".*") {

        stage('Download dependencies') {
            echo 'download dependencies'
        }
        stage('prepare Artifacts') {
            echo 'prepare artifacts'
        }
        stage('publish Artifacts') {
            echo 'publish artifacts'
        }
    }
}