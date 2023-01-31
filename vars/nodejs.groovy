def call() {
    node {

            if (! env.TAG_NAME ) {
                env.TAG_NAME = ""
            }
            sh 'env'
            common.codequality()
            common.codechecks()
            common.artifacts()

    }
}