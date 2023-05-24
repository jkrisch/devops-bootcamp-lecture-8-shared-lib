def call(){
    //install the necessary dependencies              
    sh """
        npm install
        npm run test
    """
}