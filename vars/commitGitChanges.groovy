def call(credentialsId, repoUrl){
    withCredentials([string(credentialsId: $credentialsId,variable:'TOKEN')]){
        sh """
        git config --global user.email jenkins@myexample.com
        git config --global user.name jenkins

        git remote set-url origin $repoUrl.replace("https://","https://$TOKEN@")
        git add .
        git commit -m 'version upgrade to ${env.NEW_VERSION}'
        git push origin HEAD:new-version
        """
    }
}