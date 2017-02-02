node {
       try {
       
  	      		sh 'java -version'
  	          // Mark the code checkout 'stage'....
                stage 'Checkout'
                // Checkout code from repository
                checkout scm
                stage 'Build'
                sh 'mvn clean install -Dmaven.test.skip'
                
                stage 'Unit Test'
				sh 'mvn test '
				
				 stage 'Sonar'
				sh 'mvn sonar:sonar '
			
  	      
         } catch (ex) {
           sh "echo $ex"
           throw ex
        }
}
    