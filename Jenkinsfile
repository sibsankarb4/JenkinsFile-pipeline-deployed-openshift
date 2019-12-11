pipeline {
    agent any

	environment{
	PATH="/usr/local/apache-maven/apache-maven-3.0.5/bin:$PATH"
	PATH="/usr/local/bin:$PATH"	
	}
    
	stages {
    
	stage("Env Variables") {
            steps {
                sh "printenv"
            }
        }
	    
    	stage('Git Checkout'){
            steps{
    		    git 'https://github.com/sibsankarb4/Jenkinsfile-openshift-example'
             }
    	}
    	
        stage ('Compile Stage') {
            steps {
               
                    sh 'mvn clean compile'
               }
        }

        stage ('Testing Stage') {

            steps {
              
                    sh 'mvn test'
              }
        }


        stage ('Packaging Stage') {
            steps {
               
                    sh 'mvn clean package'
              
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
