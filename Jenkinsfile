// #!/user/bin/env groovy
// @Library("jenkins-shared-library")_
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
    stage ("incrementing the jar file"){
      steps{
        script{
          echo "incrementing the iamge"
          sh 'mvn build-helper:parse-version versions:set -DnewVersion=${parsedVersion.majorVersion}.${parsedVersion.minorVersion}.${parsedVersion.nextIncrementalVersion} versions:commit'
          def matcher=readFile('pom.xml')=~ '<version>(.+)</version>
          def version=matcher[0][1]
          env.Image_Name="&version-&BUILD_NUMBER"
           }
      }
    }
    stage("build jar file"){
      steps{
        script{
        echo 'building the image'
          sh 'mvn clean package'
        }
        
      }
    }
    stage("build image"){
      steps{
        script{
         buildImage 'asifhanif01/java-maven-app:jma-1.5'
          dockerLogin()
          dockerPush 'asifhanif01/java-maven-app:jma-1.5'
          }
          
        }
        
      }
  }
}

