def call() {
    env.APPTYPE = "nodejs"
    node {
            sh 'env'
            common.codeCheckout()
            common.codequality()
            common.codechecks()
            common.artifacts()

    }
}