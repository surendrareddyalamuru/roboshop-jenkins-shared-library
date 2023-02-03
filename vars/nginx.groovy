def call() {
    env.APPTYPE = "nginx"
    node {
        sh 'env'
        common.codeCheckout()
        common.codequality()
        common.codechecks()
        common.artifacts()

    }
}