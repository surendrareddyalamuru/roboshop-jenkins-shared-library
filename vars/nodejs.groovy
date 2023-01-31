def call() {
    node {

        if (! env.TAG_NAME ) {
            env.TAG_NAME = ""
        }

            sh 'env'
            common.codequality()

            if ( BRANCH_NAME == "main" || TAG_NAME ==~ ".*") {
                stage('Style Checks') {
                    echo 'style checks'
                }
            }



//            stage('unit tests') {
//                when {
//                    anyOf{
//                        branch 'main'
//                        tag "*"
//                    }
//                }
//                steps {
//                    echo 'unit tests'
//                }
//
//            }
//
//
//            stage('Download Dependencies') {
//                when { tag "*" }
//                steps {
//                    echo 'download dependencies'
//                }
//
//            }
//
//
//            stage('Prepare Artifacts') {
//                when { tag "*" }
//                steps {
//                    echo 'prepare artifacts'
//                }
//
//            }
//
//
//            stage('Publish Artifacts') {
//                when { tag "*" }
//                steps {
//                    echo 'publish artifacts'
//                }
//
//            }

    }
}