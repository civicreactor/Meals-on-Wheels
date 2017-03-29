# Meals-on-Wheels

## Running the app
### First time
* "npm install" on parent folder, client and server
* "npm install -g gulp @angular/cli@latest"
* "gulp build" on parent folder ("npm install -g gulp" if you don't have it)

### After first time
* "gulp" on parent folder, it will start the server, the watchers and open the browser for you

## Homework (do before starting to work on the project)
* Read the README in server and client

## Gulp
Running "gulp" will do the following:
* set a watcher on "./client/src", which will automatically build the project and reload the browser on changes
* start the server with a similar watcher
* start browser-sync (this will automatically open your browser)
