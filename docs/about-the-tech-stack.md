# About the tech stack

The repo containing this solution is divided in two projects. The _monorepo_ approach is adopted here because it usually
means that both projects are compatible in the same repo version. Also it is easier to set up.

The web project is written in modern javascript and relies on [npm](https://www.npmjs.com/) to manage the dependencies
and build steps.

The service project is written in modern java and relies on [gradle](https://gradle.org/) to manage dependencies and
build.

This solution was mainly developed on mac os and fedora linux using
[visual studio code](https://code.visualstudio.com/), with latest
[node.js LTS version](https://nodejs.org), [gradle 5.0](https://gradle.org/) and
[java SDK 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
