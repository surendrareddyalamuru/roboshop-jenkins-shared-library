def codequality() {
    stage('Code quality') {
        echo 'Code Quality'
    }
}

def codechecks() {
    if ( BRANCH_NAME == "main" || TAG_NAME ==~ ".*") {
        stage('Style Checks') {
            echo 'style checks'
        }
        stage('unit tests') {
            echo 'unit tests'
        }
    }
}