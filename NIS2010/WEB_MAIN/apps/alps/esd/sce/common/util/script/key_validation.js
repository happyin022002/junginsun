jsLEng  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
jsSEng  = "abcdefghijklmnopqrstuvwxyz" ;
jsEng   = jsLEng + jsSEng ;
jsNum   = "0123456789";
jsSChar = "!@#$%^&*()_+=-,./<>?;':\"{}[]" ;
 
/**
 * 필드 유혀성 체크
 * 
 * @param obj Field Object
 * @param type Check type
 * @param upper 대문자 변환여부
 * @param maxLen 최대길이 
 * @param pchar 허용 문자
 * @param format Format
 */
 
function chkField(obj, type, upper, maxLen, pchar, format){
	switch (type) {
		case "eng_num" :
			chkEngNumObj(obj, upper, maxLen) ;
			break;
		case "eng" :
			chkEngObj(obj, upper, maxLen) ;
			break ;
		case "leng" :
			chkLEngObj(obj, upper, maxLen) ;
			break ;
		case "seng" :
			chkSEngObj(obj, upper, maxLen) ;
			break ;
		case "num" :
			chkNumObj(obj, maxLen, format) ;
			break ;
		case "custmoer" :
			chkCharObj(obj, pchar, upper, maxLen) ;
			break ;
		case "date" :
			dateFormatObj(obj, format) ;
		default:
			break;
	}
}

function chkEngObj(obj, upper, maxLen){
	chkCharObj(obj, jsEng, upper, maxLen) ;
}

function chkLEngObj(obj, upper, maxLen){
	chkCharObj(obj, jsLEng, upper, maxLen) ;
}

function chkSEngObj(obj, upper, maxLen){
	chkCharObj(obj, jsSEng, upper, maxLen) ;
}

function chkEngNumObj(obj, upper, maxLen){
	chkCharObj(obj, jsEng+jsNum, upper, maxLen) ;
}

function chkNumObj(obj, upper, maxLen){
	chkCharObj(obj, jsNum, upper, maxLen) ;
}

function chkCharObj(obj, pchar, upper, maxLen){
	obj.value = chkCharValue(obj.value, pchar, upper, maxLen) ;
}

function chkCharValue(value, pchar, upper, maxLen){
	var newValue = "" ;
	var oneChar  = null ;
	
	for(i=0;i<value.length; i++){
		oneChar = value.charAt(i) ;
		if(pchar.indexOf(oneChar)!=-1 && (maxLen==null || newValue.length<maxLen)){
			newValue += oneChar ;
		}
	}
	
	newValue = upper ? newValue.toUpperCase() : newValue ;
	
	return newValue ;
}

function dateFormatObj(obj, format){
	var value = obj.value ;
	obj.value = dateFormatValue(value, format)
}

function dateFormatValue(value, format) {
	var oldValue = chkCharValue(value, jsNum, false) ;
	var newValue = "" ;
	var chkValue = "" ;
	var oneChar  = null ;
	var maxLen   = 8 + (format.length*2)
	
	for(i=0; i<oldValue.length; i++){
		oneChar = oldValue.charAt(i) ;
		
		if(newValue.length<maxLen){
			if(i==4){
				if(oneChar>1){
					newValue = newValue + format + "0" + oneChar ;
				}
				else{
					newValue = newValue + format + oneChar ;
				}
			}
			else if(i==6){
				if(oneChar>3){
					newValue = newValue + format + "0" + oneChar ;
				}
				else{
					newValue = newValue + format + oneChar ;
				}
			}
			else {
				newValue += oneChar ;
			}
		}
	}
	
	chkValue = oldValue.substring(0,8) ;
	if(!chkDateValue(chkValue)){
		newValue = newValue.substring(0, newValue.length-1) ;
	}
		
	return newValue ;
}


function chkDateValue(value){
	var yyyy = value.substring(0,4) ;
	var mm   = value.substring(4,6) ;
	var dd   = value.substring(6) ;
	
	var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) ;
	
	// 월체크
	if(mm>12) {
		return false ;
	}
	
	// 윤달
	if(mm==2){
		daysInMonth[1] = yyyy%400==0 || ((yyyy%4==0) && (yyyy%100!=0)) ? 29 : 28 ; 
	}

	// 일체크
	if(dd!="" && mm!="" && dd>daysInMonth[mm-1]){
		return false ;
	}
	
	return true ;
}

/**
 * 컨테이너 번호 Check Digit 계산 함수.
 */

function cntrCheckDigit(obj){
   var cntrNo = obj.value;
 if (cntrNo.length != 10){
  return cntrNo;

 } 
 var sum = 0;
 cntrNo = cntrNo.toUpperCase();
 for(var i=0;i<10;i++){
  sum = sum + productValue( cntrNo.charAt(i),i);

 }
 var mod = sum % 11;

 if (mod == 10) mod =0;
 
 if (isNaN(mod)) return cntrNo;

 return cntrNo+mod;

 

}

/**
 * 컨테이너 번호 Check Digit 계산 함수 -product Value 계산 하는 로직을 포함한 메소드
 */
 
function productValue(str,position){

 var strMap = new Array("10","12","13","14","15","16","17","18","19","20","21","23","24","25","26","27","28","29","30","31","32","34","35","36","37","38");

 

 var num = new Number(str);

 if (isNaN(num)){

  var index = new Number(str.charCodeAt(0)-65) ;

  var strNum = strMap[index];


  return strNum * Math.pow(2, position);

 } else {

  return num* Math.pow(2, position);

 }

}

