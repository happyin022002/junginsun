// @name: isObject
// @desc: to test if object is an object or not
// @exception: none
// @param: object - object to test
// @depending: none 
function isObject(o) {
  return (typeof(o)=="object");
}

// @name: isArray
// @desc: to test if object is an array or not
// @exception: none
// @param: object - object to test
// @depending: none 
function isArray(o) {
  return (isObject(o) && (o.length) &&(!isString(o)));
}

// @name: isFunction
// @desc: to test if object is a function or not
// @exception: none
// @param: object - object to test
// @depending: none 
function isFunction(o) {
  return (typeof(o)=="function");
}

// @name: isString
// @desc: to test if object is a string or not
// @exception: none
// @param: object - object to test
// @depending: none 
function isString(o) {
  return (typeof(o)=="string");
}

// @name: arrayToUrlString
// @desc: to transform an array to url form with differents parameters of the array
// @exception: if the parameter object isn't an array
// @param: array - array to transform to url form
// @depending: none 
// @example: var tab = new Array(3); |tab['param1']='val1';|tab['param2']='val2';|tab['param3']='val3';|<a href=' ' onClick='var tab = new Array(3);tab[\'param1\']=\'val1\';tab[\'param2\']=\'val2\';tab[\'param3\']=\'val3\';alert(arrayToUrlString(tab));return false;'>alert(arrayToUrlString(tab));</a>
// @version: 1.0
// @author: E.Qu&eacute;sada
function arrayToUrlString(o){
	alert("param make..");
  if (isArray(o)) {
	var paramStr;
	isFirst = true;
	for (var x in o){
		if (o[x] != null)
		{
			if (isFirst)
			{						
				isFirst = false;
				paramStr=x+'='+o[x];
			} else
				paramStr+='&'+x+'='+o[x];
		}
	}
	return paramStr;
  } else {
	alert( 'easyTools.js:function arrayToUrlString() - The object is not an Array');
	throw 'easyTools.js:function arrayToUrlString() - The object is not an Array';
  }
}