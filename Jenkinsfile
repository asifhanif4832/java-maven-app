def gv
pipeline{
  agent any
  tools{
    maven 'maven'
  }
  stages{
    //  stage("init"){
    //   steps{
    //     script{
    //     gv=load 'script.groovy'
    //     }
        
    //   }
    // }
    stage("build jar file"){
      steps{
        script{
        echo "building the jar file"
        }
        
      }
    }
    stage("build image"){
      steps{
        script{
          echo "building the image"
          }
          
        }
        
      }
    stage("deploy the image"){
      steps{
        script{
          def dockerCMD='docker run -d -p 3080:3080 asifhanif01/react-nodejs-example:1.0'
          sshagent(credentials: ['ec2-server-key'], executable: '') {
          sh "ssh -o StrictHostKeyChecking=no ec2-user@16.178.244.173 ${dockerCMD}"
          
}
          }
          
        }
        
      }
  }
}

