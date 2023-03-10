def call() {
    env.SONAR_EXTRA_OPTS = "-Dsonar.java.binaries=./target"
    env.APPTYPE = "java"
    node {
        sh 'env'
        common.codeCheckout()
        stage('Compile Code') {
            sh 'mvn compile'
        }
        common.codequality()
        common.codechecks()
        common.artifacts()

    }
}