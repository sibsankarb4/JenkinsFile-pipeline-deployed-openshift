pipeline {
    agent any

    stages {
    
    	stage('Git Checkout'){
            steps{
    		    git 'https://github.com/sibsankarb4/Jenkinsfile-openshift-example'
             }
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
    
	stage('OC Build') {
      when {
        expression {
          openshift.withCluster() {
            return !openshift.selector('bc', 'Jenkinsfile-openshift-example').exists();
          }
        }
      }
      steps {
        script {
          openshift.withCluster() {
            openshift.newApp('redhat-openjdk18-openshift:1.1~https://github.com/sibsankarb4/Jenkinsfile-openshift-example.git')
          }
        }
      }
    }
	
 }
}
