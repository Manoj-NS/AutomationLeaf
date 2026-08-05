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

    	stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'reports/**', 
		fingerprint: true,
		allowEmptyArchive: true

                archiveArtifacts artifacts: 'screenshots/**', 
		fingerprint: true,
		allowEmptyArchive: true
            }
        }

    	stage('Publish Extent Report') {
            steps {
                publishHTML([
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'reports',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Report'
                ])
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