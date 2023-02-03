def call() {
    env.APPTYPE = "python"
    node {
        sh 'env'
        common.codeCheckout()
        common.codequality()
        common.codechecks()
        common.artifacts()

    }
}