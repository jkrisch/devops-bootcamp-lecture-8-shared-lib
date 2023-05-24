def call(String credentialsId, String repoUrl){
    withCredentials([string(credentialsId: "${credentialsId}",variable:'TOKEN')]){
        def newRepoUrl = $repoUrl.replace("https://","https://$TOKEN@")
        sh """
        git config --global user.email jenkins@myexample.com
        git config --global user.name jenkins

        git remote set-url origin $newRepoUrl
        git add .
        git commit -m 'version upgrade to ${env.NEW_VERSION}'
        git push origin HEAD:new-version
        """
    }
}