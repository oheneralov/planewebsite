var express = require('express');

var app = express();

app.set('view engine', 'jade');

//app.use(express.static('public'));

app.get('/', function(req, res){
	res.sendFile(__dirname + '/src/index.html');
	
});

app.get('/:page', function(req, res){
	res.sendFile(__dirname + '/src/' + req.params.page + '.html');
	
});

/*
app.get('/', function (req, res) {
  res.render('index', { title: 'Hey', message: 'Hello there!'});
});
*/

var server = app.listen(8080, function(){
	var address = server.address().address;
	var port = server.address().port;
	console.log("listening at %s : %d", address, port);
});