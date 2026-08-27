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
                publishHTML(target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'reports',
                    reportFiles: 'LeafTap.html',
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

            mail(
                to: 'manoj.u2907@gmail.com',
                subject: "SUCCESS: Jenkins Build #${env.BUILD_NUMBER}",
                body: """
		
		Hello,

		Your Jenkins build was SUCCESSFUL.

		Job Name: ${env.JOB_NAME}
		Build Number: ${env.BUILD_NUMBER}
		Build URL: ${env.BUILD_URL}

		Regards,
		Jenkins
		"""
            )
        }

        failure {
            echo 'Build Failed'

            mail(
                to: 'manoj.u2907@gmail.com',
                subject: "FAILED: Jenkins Build #${env.BUILD_NUMBER}",
                body: """
		
		Hello,

		Your Jenkins build has FAILED. 

		Job Name: ${env.JOB_NAME}
		Build Number: ${env.BUILD_NUMBER}
		Build URL: ${env.BUILD_URL}

		Please check the Jenkins Console Output.

		Regards,
		Jenkins
		"""
            )
        }

    }

}