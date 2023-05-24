def runNpmTests(){
    //install the necessary dependencies              
    sh """
        npm install
        npm run test
    """
}