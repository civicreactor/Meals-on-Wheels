var gulp = require('gulp');
var exec = require('child_process').exec;
var watch = require('gulp-watch');
var nodemon = require('gulp-nodemon');
var browserSync = require('browser-sync').create();



gulp.task("watch", function () {
    watch(["client/src/**"], function () {
        gulp.start("build");
    });
});

gulp.task('build', function (cb) {
    exec('ng build', { maxBuffer: 1024 * 500, cwd: "./client" }, function (err, stdout, stderr) {
        browserSync.reload();
        console.log(stdout);
        console.log(stderr);
        cb(err);
    });
})

gulp.task('browser-sync', function () {
    browserSync.init({
        port: 8080,
        ui: {
            port: 8090
        },
        proxy: {
            // Redirige el target a (8080)
            target: "localhost:3000",
            ws: true
        },
    });
});

gulp.task('server', function () {
    var stream = nodemon({
        script: './server/index.js',
        ext: 'js',
        ignore: ['public'],
        env: { 'NODE_ENV': 'development' },
        watch: [
            "server"
        ]
    })

    stream
        .on('restart', function () {
            browserSync.reload();
            console.log('restarted!')
        })
        .on('crash', function () {
            console.error('Application has crashed!\n')
            stream.emit('restart', 5)
        })
})

gulp.task('default', ["watch", "server", "browser-sync"])