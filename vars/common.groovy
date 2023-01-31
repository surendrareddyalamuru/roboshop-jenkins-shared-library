def codequality() {
    stage('Code quality') {
        echo 'Code Quality'
    }
}

def stylechecks() {
    if ( BRANCH_NAME == "main" || TAG_NAME ==~ ".*") {
        stage('Style Checks') {
            echo 'style checks'
        }
    }
}