def call() {
    pipeline {

        agent any

        stages {

            stage('Code quality') {
                steps {
                    echo 'Code Quality'
                }

            }



            stage('Style Checks') {
                when {
                    anyOf{
                        branch 'main'
                        tag "*"
                    }
                }
                steps {
                    echo 'Code Quality'
                    sh 'env'
                }

            }


            stage('unit tests') {
                when {
                    anyOf{
                        branch 'main'
                        tag "*"
                    }
                }
                steps {
                    echo 'unit tests'
                }

            }

            stage('Prepare Artifacts') {
                when { tag "*" }
                steps {
                    echo 'prepare artifacts'
                }

            }


            stage('Publish Artifacts') {
                when { tag "*" }
                steps {
                    echo 'publish artifacts'
                }

            }

        }
    }
}