dev gv
pipeline{
  agent any
  tools{
    maven 'maven'
  }
  stages{
     stage("init"){
      steps{
        script{
        gv=load 'scripts.groovy'
        }
        
      }
    }
    stage("build jar file"){
      steps{
        script{
        gv.buildJar()
        }
        
      }
    }
    stage("build image"){
      steps{
        script{
          gv.buildImage()
          }
          
        }
        
      }
    }
    stage("test"){
      steps{
        echo 'testing the application'
      }
    }
    stage("deploy"){
      steps{
        echo 'deploying the application'
      }
    }
  }
}
