def call(String credentialsId){
    withCredentials([usernamePassword(credentialsId: "${credentialsId}",usernameVariable:'USERNAME', passwordVariable:'PASSWORD')]){
        sh """
        echo ${PASSWORD} | docker login -u ${USERNAME} --password-stdin
        docker build -t ${USERNAME}/node-js-app:${env.IMAGE_VERSION} .
        docker push ${USERNAME}/node-js-app:${env.IMAGE_VERSION}
        """
    }
}