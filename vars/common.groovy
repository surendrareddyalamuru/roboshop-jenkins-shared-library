def codequality() {
    stage('Code quality') {
        echo 'Code Quality'
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