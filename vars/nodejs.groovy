def call() {
    node {

            if (! env.TAG_NAME ) {
                env.TAG_NAME = ""
            }
            sh 'env'
            common.codequality()
            common.codechecks()

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