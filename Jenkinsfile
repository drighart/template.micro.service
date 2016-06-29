node {
    echo 'Hello from Pipeline'
	
	stage "Checkout"
	git url: "https://github.com/drighart/template.micro.service"
	
	stage "Build"
      sh 'chmod 755 gradlew'
      sh './gradlew clean build'
//    archiveUnitTestResults()
//    archiveCheckstyleResults()

	stage "Code analysis"

	stage "Build docker image"
	
	stage "Integration tests"

}

def archiveUnitTestResults() {
    step([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
}

def archiveCheckstyleResults() {
    step([$class: "CheckStylePublisher",
          canComputeNew: false,
          defaultEncoding: "",
          healthy: "",
          pattern: "build/reports/checkstyle/main.xml",
          unHealthy: ""])
}
