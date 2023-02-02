def call() {
    node {
            sh 'env'
            common.codeCheckout()
            common.codequality()
            common.codechecks()
            common.artifacts()

    }
}