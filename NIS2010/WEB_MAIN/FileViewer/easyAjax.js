// @name: getXhr
// @desc: to get a new object xmlHttpRequest
// @exception: if it can't create an XMLHTTP instance
// @param: none
// @depending: none
function getXhr(){
	var xhr = false;
	if (window.XMLHttpRequest) { // Mozilla, Safari,...
		xhr = new XMLHttpRequest();
		if (xhr.overrideMimeType) {
			xhr.overrideMimeType('text/xml');
		}
	} else if (window.ActiveXObject) { // IE
		try {
			xhr = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
	if (!xhr) {
		throw "easyAjax.js:function getXhr() - Cannot create an XMLHTTP instance";
	}
	return xhr;
}

// @name: checkFileExists
// @desc: to check if a file exists or not <b>on the server</b>
// @exception: if the navigator can't create an xmlHttpRequest object instance | if the response status code of the page is unknowed
// @param: string - url of the page that you will check the existency
// @depending: none
// @example: <a href=' ' onClick='if (checkFileExists(\'easyAjax.js\')) alert(\'easyAjax.js exists\');else alert(\'easyAjax.js not exists\');return false;'>if (checkFileExists('easyAjax.js'))</a>|&nbsp;&nbsp;&nbsp;&nbsp;alert('easyAjax.js exists');|else|&nbsp;&nbsp;&nbsp;&nbsp;alert('easyAjax.js not exists');|<a href=' ' onClick='if (checkFileExists(\'nothing.php\')) alert(\'nothing.php exists\');else alert(\'nothing.php not exists\');return false;'>if (checkFileExists('nothing.php'))</a>|&nbsp;&nbsp;&nbsp;&nbsp;alert('nothing.php exists');|else|&nbsp;&nbsp;&nbsp;&nbsp;alert('nothing.php not exists');
// @version: 1.0
// @author: E.Qu&eacute;sada
function checkFileExists(url)
{
	var xmlhttp = null;
	try {
		xmlhttp = getXhr();
	}catch (e) {
		throw "easyAjax.js:function checkFileExists() - Cannot create an xmlHttpRequest object instance instance"; 
	}
 	xmlhttp.open("HEAD",url,false);
 	xmlhttp.send(null); 	
 	if (xmlhttp.readyState==4) 
   	if (xmlhttp.status==404)
   		return false;
   	else if (xmlhttp.status==200)
   		return true; 
   	else
   		throw "easyAjax.js:function checkFileExists() - unknowed status code "+xmlhttp.status; 
} 

// internal use
function onReadyStateChange (func,obj){
	if(obj.readyState == 4)
		if (obj.status == 200) {
			try {
				func(obj);
			} catch (e) {
				throw "easyAjax.js:function "+func.name+"() - "+e; 
			}
		}
		else 
			throw "easyAjax.js:function onReadyStateChange() - The file has send an unknow status";
}

// @name: execute
// @desc: to execute a php page in background, you can call a function when the execution is finished
// @exception: if it can't create an XMLHTTP instance | if the file in first argument doesn't exist | if first argument doesn't correspond at xxx.php | if the second argument is present but isn't a function
// @param: string - path of the php file | [function] - function(XmlXttpRequestObject) to call when the php file has returned
// @depending: easyTools.js - isFunction() | [xxx.js] - functionToCall() 
function execute(file,fn) {
	if (!checkFileExists(file))
		throw "easyAjax.js:function execute() - The first argument must to be a accessible and existing file";
	if ((fn != null)&&(!isFunction(fn)))
		throw "easyAjax.js:function execute() - The second argument must to be a function";
	var xmlhttp = null;
	try {
		xmlhttp = getXhr();
	} catch (e) {
		throw "easyAjax.js:function execute() - Cannot create an XMLHTTP instance"; 
	}
	if (fn != null)
	{
		var func = fn;
		xmlhttp.onreadystatechange = function () {onReadyStateChange(func,xmlhttp);};
	}
	if (fn != null)
		xmlhttp.open("GET", file, true);
	else
		xmlhttp.open("HEAD", file, true);
	xmlhttp.send(null);	
}

// @name: executeInXml
// @desc: to get a xml file in background and call a function when the file has got back
// @exception: if it can't create an XMLHTTP instance | if the file in first argument doesn't exist | if first argument doesn't correspond at xxx.xml | if the second argument isn't a function
// @param: string - path of the xml file | function - function(XmlXttpRequestObject) to call when the xml file has got back
// @depending: easyTools.js - isFunction() | xxx.js - functionToCall() 
function executeInXml(file,fn) {
	if (!checkFileExists(file))
		throw "easyAjax.js:function executeInXml() - The first argument must to be a accessible and existing file";
	if (!file.match(/\.xml$/))
		throw "easyAjax.js:function executeInXml() - The first argument must to be a file as xxx.xml";
	if (!isFunction(fn))
		throw "easyAjax.js:function executeInXml() - The second argument must to be a function";
	var xmlhttp = null;
	try {
		xmlhttp = getXhr();
	} catch (e) {
		throw "easyAjax.js:function executeInXml() - Cannot create an XMLHTTP instance"; 
	}
	var func = fn;
	xmlhttp.onreadystatechange = function () {onReadyStateChange(func,xmlhttp);};
	xmlhttp.open("GET", file, true);
	xmlhttp.send(null);	
}

// @name: executeInGet
// @desc: to execute a php file in background with parameters in get, you can call a function when the file has returned
// @exception: if it can't create an XMLHTTP instance | if the file in first argument doesn't exist | if first argument doesn't correspond at xxx.php | if the second argument isn't an array | if the second argument is present but isn't a function
// @param: string - path of the xml file | array - parameters to give in GET | [function] - function(XmlXttpRequestObject) to call when the php file has returned
// @depending: easyTools.js - isFunction() isArray() arrayToUrlString() | xxx.js - functionToCall() 
function executeInGet(file,param,fn) {
	if (!checkFileExists(file))
		throw "easyAjax.js:function executeInGet() - The first argument must to be a accessible and existing file";
	if (!isArray(param))
		throw "easyAjax.js:function executeInGet() - The second argument must to be an array";
	if ((fn != null)&&(!isFunction(fn)))
		throw "easyAjax.js:function executeInGet() - The third argument must to be a function";
	var xmlhttp = null;
	try {
		xmlhttp = getXhr();
	} catch (e) {
		throw "easyAjax.js:function executeInGet() - Cannot create an XMLHTTP instance"; 
	}
	if (fn != null)
	{
		var func = fn;
		xmlhttp.onreadystatechange = function () {onReadyStateChange(func,xmlhttp);};
	}	
	xmlhttp.open("GET", file+'?'+arrayToUrlString(param), true);
	xmlhttp.send(null);	
}

// @name: executeInPost
// @desc: to execute a php file in background with parameters in post, you can call a function when the file has returned
// @exception: if it can't create an XMLHTTP instance | if the file in first argument doesn't exist | if first argument doesn't correspond at xxx.php | if the second argument isn't an array | if the second argument is present but isn't a function
// @param: string - path of the xml file | array - parameters to give in POST | [function] - function(XmlXttpRequestObject) to call when the php file has returned
// @depending: easyTools.js - isFunction() isArray() arrayToUrlString() | xxx.js - functionToCall() 
function executeInPost(file,param,fn) {
	if (!checkFileExists(file))
		throw "easyAjax.js:function executeInPost() - The first argument must to be a accessible and existing file";
	if (!isArray(param))
		throw "easyAjax.js:function executeInPost() - The second argument must to be an array";
	if ((fn != null)&&(!isFunction(fn)))
		throw "easyAjax.js:function executeInPost() - The third argument must to be a function";
	var xmlhttp = null;
	try {
		xmlhttp = getXhr();
	} catch (e) {
		throw "easyAjax.js:function executeInPost() - Cannot create an XMLHTTP instance"; 
	}
	if (fn != null)
	{
		
		var func = fn;
		xmlhttp.onreadystatechange = function () {onReadyStateChange(func,xmlhttp);};
	}
	alert("request...");
	xmlhttp.open("POST", file,true);
	xmlhttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	xmlhttp.send(arrayToUrlString(param));	
}