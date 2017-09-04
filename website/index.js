var express = require('express');

var app = express();

app.set('view engine', 'pug');
app.set('views', './views');

app.use(express.static('public'));


app.get('/', function (req, res) {
  res.render('index', { title: 'Home', content: 'Home'});
});

app.get('/simulator', function (req, res) {
  res.render('simulator', { title: 'simulator', content: 'simulator'});
});

app.get('/theory', function (req, res) {
  res.render('theory', { title: 'theory', content: 'theory'});
});


var server = app.listen(8080, function(){
	var address = server.address().address;
	var port = server.address().port;
	console.log("listening at %s : %d", address, port);
});