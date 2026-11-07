def gv
pipeline{
  agent any
  tools{
    maven 'maven'
  }
  stages{
     stage("init"){
      steps{
        script{
        gv=load 'script.groovy'
        }
        
      }
    }
    stage("build jar file"){
      when{
    expression{
      env.GIT_BRANCH=="new"
    }
  }
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
}

