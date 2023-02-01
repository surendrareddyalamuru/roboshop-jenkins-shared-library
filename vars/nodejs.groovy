def call() {
    node {

            sh 'env'
            common.codequality()
            common.codechecks()
            common.artifacts()

    }
}