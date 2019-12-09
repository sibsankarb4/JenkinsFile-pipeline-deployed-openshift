pipeline {
    agent any

    stages {
    
    	stage('Git Checkout'){
    		git 'https://github.com/sibsankarb4/spring-boot-openshift-exam'
    	}
    	
        stage ('Compile Stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Packaging Stage') {
            steps {
                withMaven(maven : 'maven_3_6_3') {
                    sh 'mvn clean package'
                }
            }
        }
    }
}