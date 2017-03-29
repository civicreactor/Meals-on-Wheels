# MealsOnWheels

## Running the app
* since the server needs to be running in order for this to work, follow the instructions in the parent folder

## Workflow
* to keep the coding standards, run "ng lint" before committing your changes and fix the issues

## Read
* Bootstrap 4. [The grid](https://v4-alpha.getbootstrap.com/layout/grid/) is the most important part
* Angular2
* angular-cli (specially creating components and services with it)

## Modules
* The app has different modules. Parent module is "app", childs are "admin" and "client"
* If developing something only the "admin" module will use, do all the imports/declarations in "admin.module.ts".
* Routes for a child module go in its specific module, not in the "app.module"
* There is a "shared" module for things all the other modules will use

## Coding
* Follow the coding style. You can read more about it [here](https://github.com/Microsoft/TypeScript/wiki/Coding-guidelines) and [here](https://angular.io/styleguide). It's the same one angular-cli and VSCode follow by default
* If you are thinking about using jQuery or similar libraries, Angular2 probably has a way to do it

## Views
* We are using Bootstrap 4, ng-bootstrap and other dependecies that help with the styling. If you want to add something new to the view, look for the functionality inside those libraries first
* ng-bootstrap mixes Bootstrap with Angular2, reducing the code you would need to write.
* Use the spinners while waiting for a response (HTTP requests), so that the users know something is going on
* Show errors on the view when possible/informative

# Dependencies
* [Bootstrap 4](https://v4-alpha.getbootstrap.com/getting-started/introduction/)
* [ng-bootstrap](https://ng-bootstrap.github.io/#/getting-started)
* [ng2-spin-kit](https://www.npmjs.com/package/ng2-spin-kit) [old examples](http://jsfiddle.net/Urigo/638AA/18/)

# Spinners

The basic spinners are:

* circle-spinner
* three-bounce-spinner

# Tips:

* Add new components/services using the angular-cli, it will do the declarations in the closest module automatically
