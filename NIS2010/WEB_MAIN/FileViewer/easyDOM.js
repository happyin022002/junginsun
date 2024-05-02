// @name: getElement
// @desc: to get an element without check the navigator
// @exception: none
// @param: string - the id of the element
// @depending: none 
function getElement(elementId) {
	if (document.getElementById) // IE5+, Netscape 6, Mozilla
		return document.getElementById(elementId);
	else if (document.all) // IE4
		return document.all[elementId];
	else if (document.layers) // Netscape 4
		return document[elementId];
	else 
		return null;
}

// @name: changeElemContent
// @desc: to change the content of an element from his id
// @exception: none
// @param: string - the id of the element | string - the new content
// @depending: none 
// @example: <a href=' ' onClick='changeElemContent(\'content\',\'test of the function changeElemContent()\');return false;'>changeElemContent('content','test of the function changeElemContent()');</a>
// @version: 1.0
// @author: E.Qu&eacute;sada
function changeElemContent(id,newContent){
	var elem = document.getElementById(id);
	elem.innerHTML = newContent;	
}

// @name: showElement
// @desc: to show an element from his id
// @exception: none
// @param: string - the id of the element
// @depending: none 
function showElement(elementId) {
	var element=getElement(elementId);
	element.style.visibility = "visible";
}

// @name: hideElement
// @desc: to hide an element from his id but the element take always place Note that when an item is hidden, it doesn't receive events
// @exception: none
// @param: string - the id of the element
// @depending: none 
function hideElement(elementId) {
	var element=getElement(elementId);
	element.style.visibility = "hidden";
}

// @name: displayDivSpanElement
// @desc: to display an element from his id
// @exception: none
// @param: string - the id of the element
// @depending: none 
function displayDivSpanElement(elementId) {
	var element=getElement(elementId);
	element.style.display = "block";
}

// @name: removeDivSpanElement
// @desc: to hide an element from his id
// @exception: none
// @param: string - the id of the element
// @depending: none 
function removeDivSpanElement(elementId) {
	var element=getElement(elementId);
	element.style.display = "none";
}

// @name: inlineDivSpanElement
// @desc: to put all elements of the div/span inside.
// @exception: none
// @param: string - the id of the element
// @depending: none 
function inlineDivSpanElement(elementId) {
	var element=getElement(elementId);
	element.style.display = "inline";
}

function isChild(s,d) {
	while(s) {
		if (s==d)
			return true;
		s=s.parentNode;
	}
	return false;
}
