# README #

## What is this repository for? ###

The repository contains the source code for the core-apis (digital twin model with all its APIs)

## How do I get set up? ##

### As a core-api developer ###

In order to run/debug the project locally using an In Memory Database, you need:

* Java SDK 11 (for example from [AdoptOpenJDK](https://adoptopenjdk.net/))
* [Maven Build Tool](https://maven.apache.org/)

### As a Pilot Application developer ###


* To run the latest version of the development branch:
  * Follow the usage instructions on the [K4R infrastructure project](https://gitlab.com/knowledge4retail/k4r-core-infrastructure)
  * run `docker-compose pull k4r-core`
  * run `docker-compose up k4r-core`
  * **No build step is needed**

* To run a specific feature branch:

  * Look for the Image Tag of the feature branch in the [GitLab container registry](<https://gitlab.com/knowledge4retail/k4r-core-api/container_registry/1498010>): e.g. `feature-tnk4r-165-shoppingbasketamendments`
  * change the tag of the image in the docker-compose file to: `feature-tnk4r-165-shoppingbasketamendments`

  ```yaml
    k4r-core:
    environment:
      spring.profiles.active: docker
    image: registry.gitlab.com/knowledge4retail/k4r-core-api/core:feature-tnk4r-165-shoppingbasketamendments
  ```

### API Documentation ###

* Swagger documentation of the api endpoints is available under:
`{url://ofTheRunningApiInstance}/k4r-core/swagger-ui.html`
* A [Postman](https://www.postman.com/) collection with example requests for some of the api end-points [can be found here](https://gitlab.com/knowledge4retail/k4r-core-api/-/tree/develop/k4r-applications/k4r-core/src/test/resources/postman)
or in the following directory in your local repository folder:
`./k4r-applications/k4r-core/src/test/resources/postman`

### Contributions ###

Merge requests to enhance the documentation, code or functionality are _highly welcomed & appreciated_
