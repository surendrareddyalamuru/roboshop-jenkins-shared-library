def call() {
    pipeline {
            sh 'env'
            common.codequality()

//            stage('Style Checks') {
//                when {
//                    anyOf{
//                        branch 'main'
//                        tag "*"
//                    }
//                }
//                steps {
//                    echo 'Code Quality'
//                    sh 'env'
//                }
//
//            }
//
//
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
//
    }
}