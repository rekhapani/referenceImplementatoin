node {
   def mvnHome
   def projName = 'JenkinsDocker'
  // def gitRepo = ''//params.GitRepoNamem
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/rekhapani/referenceImplementatoin.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'Maven'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore  -f ${projName}/pom.xml clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore -f ${projName}\pom.xml clean install/)
      }
   }
   stage('Build Docker Image')
   {
       sh 'docker build -t rekhapani/order-service:1.0.0 ./JenkinsDocker'
   }
   stage('Push Docker Image')
   {
       sh 'docker login -u rekhapani -p susan184L'
       sh 'docker push rekhapani/order-service:1.0.0'
   }
   stage('Run Docker')
   {
       sh 'docker run -p 8082:8082 -d rekhapani/order-service:1.0.0'
   }
   
}