/*
 * 불필요한 ascii 코드 삭제 (NGO => NGO)
 * param str : string
 * return :  string
 */ 
function VopAsciiRemove(str){
	var retValue = "";
	
	retValue =  str.replace(/[\u0000-\u0008\u000B-\u000C\u000E-\u001F\uD800-\uDB7F\uDB80-\uDBFF\uDC00-\uDFFF\uFFFE\uFFFF]/g, "");
	
	return retValue;
	
}