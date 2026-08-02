pipeline {

    agent any

    parameters {
        string(name: 'BRANCH_NAME',
               defaultValue: 'main',
               description: 'Git branch to build')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: "${params.BRANCH_NAME}",
                    url: 'https://github.com/Manoj-NS/AutomationLeaf.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean test'
            }
        }

    }

    post {

        always {
            echo 'Pipeline Finished'
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }

    }

}