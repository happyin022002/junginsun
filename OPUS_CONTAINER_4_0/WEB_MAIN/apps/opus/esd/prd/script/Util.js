document.onkeypress = processEnterKey; 
jsLEng  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ;
jsSEng  = "abcdefghijklmnopqrstuvwxyz" ;
jsEng   = jsLEng + jsSEng ;
jsNum   = "0123456789";
jsSChar = "!@#$%^&*()_+=-,./<>?;':\"{}[]" ;

prdToolTipId_1 = "Delevery due date";
prdToolTipId_2 = "Return CY";
sheet1 ="sheet1";
sheet2 ="sheet2";
sheet3 ="sheet3";


/**
 *  enterKey 처리
 */
function processEnterKey() {
    try {
            var srcObj=window.event.srcElement.nodeName;
			var keyObj=window.event.keyCode;
            if((srcObj =='INPUT'|| srcObj =='SELECT')&& keyObj ==13) {

                processButtonClick()
            }    
    }catch(e) {
    }            
}

function onEnterKey(srcName) {
		// 버튼이 disable 인지 확인한다.
        if(srcName != null && !isEmpty2(srcName)) {
            var btnDis  = eval("document.form."+srcName+".disabled");
            if (btnDis) return;
        }
        /****************************
         enterKey 처리
        *****************************/
        var srcObj=window.event.srcElement.nodeName;
        var keyObj=window.event.keyCode;
        if(srcObj =='INPUT' && keyObj ==13) {
            validateData = eval('document.form.'+srcName+'.value');
            eval('document.form.'+srcName+'.value=\''+validateData.toUpperCase()+'\'' );                
            srcName ='btn_retrieve';
        }
        return srcName;
        /****************************/    
}
 /**
  * 대상 Img Object를 enable 시킨다.
  * @param  obj   대상 폼태그(Object)
  * @return
  */
function bntImgEnable(obj, gb) {
         
  var objNm = obj.name;
  var btnStyle = eval("document."+objNm+".style");
  
  if (gb){
       obj.disabled = false;
       btnStyle.cursor = "hand";
       btnStyle.filter="";
  } else {
       obj.disabled = true;
       btnStyle.cursor = "default";
       btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
  }
}	

 /**
  * 대상 같은 이름의 Img Object를 enable,disable 시킨다.
  * @param  obj   대상 폼태그(Object)
  * @param  idx   같은 이름의 이미지 인덱스 , 9999 일때 전체 적용 
  * @param  gb    true, false 로 true 일때 활성화  
  * ex:  bntImgEnable2(document.form.ib_org_loc_btn[1], 0, true);
  * @return
  */
function bntImgEnable2(obj, idx, gb) {
   
//  alert(obj[0].name);
  var objNm = obj[0].name;
  //alert(document.getElementsByName(objNm).length);
  var aInput = document.getElementsByName(objNm);
  var btnStyle;
  if(idx!= 9999){
      btnStyle =  aInput[idx].style;
  }
//  var btnStyle = eval("document."+objNm[idx]+".style");
  
  if (gb){
       if(idx== 9999){
           aInput.disabled = false;
           for(var index=0; index<aInput.length; index++) {
               btnStyle =  aInput[index].style;
           	   btnStyle.cursor = "hand";
           	   btnStyle.filter="";
           }           
       } else {
           aInput[idx].disabled = false;
           btnStyle.cursor = "hand";
           btnStyle.filter="";           
       }

  } else {
       if(idx== 9999){
           aInput.disabled = true;
           for(var index=0; index<aInput.length; index++) {
               btnStyle =  aInput[index].style;
           	   btnStyle.cursor = "default";
           	   btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
           }
       } else {
           aInput[idx].disabled = true;
           btnStyle.cursor = "default";
           btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
       }      
//       aInput[idx].disabled = true;
//       btnStyle.cursor = "none";
//       btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
  }
}	

/**
 * 왼쪽에 ch 문자 채우기
 */   
function lpad(newValue, len, ch){
 
     var strlen = trim(newValue).length;
     var ret = "";
     var alen = len - strlen;
     var astr = ""; 
     
     //부족한 숫자만큼  len 크기로 ch 문자로 채우기
     for (i=0; i<alen; ++i)
     {
      astr = astr + ch;
     }
     
     ret = astr + trim(newValue); //앞에서 채우기
     return ret;
}

function inputUpper(obj) {
	var objNm = obj.name;
    var objVal = eval('document.form.'+objNm+'.value');
    var objEle = eval('document.form.'+objNm);    
    validateData = objVal.toUpperCase();
    eval('document.form.'+objNm+'.value=\''+validateData+'\'' );    
}

/**
 * 입력된값을 대문자로 바꾸고
 */  
function inputChkUpper(obj, e, cmd) {
	var objNm = obj.name;
    var objVal = eval('document.form.'+objNm+'.value');
    var objEle = eval('document.form.'+objNm);
	re = /^[a-zA-Z0-9]+$/; 
	te = /\t/;
    validateData = objVal.toUpperCase();
    eval('document.form.'+objNm+'.value=\''+validateData+'\'' );
	if(e==9) {
	    if(objVal.length>0) {
	        // port code check
	        if(cmd =='SEARCH01') { 
    		    doActionIBSheet(sheetObjects[0],document.form,SEARCH01);    

            // location search
		    }else if(cmd =='SEARCH02') { 
    		    doActionIBSheet(sheetObjects[0],document.form,SEARCH02);    
            // node search
		    }else if(cmd =='SEARCH04' && objVal.length ==7) { 
    		    doActionIBSheet(sheetObjects[0],document.form,SEARCH04);   
            // Terminal search
		    } else if(cmd =='SEARCH05') { 
    		    doActionIBSheet(sheetObjects[0],document.form,SEARCH05);    

            // country code check
		    } else if(cmd =='SEARCH06') { 
    		    doActionIBSheet(sheetObjects[0],document.form,SEARCH06);    

            // lane code check	
		    } else if(cmd =='SEARCH07') { 
    		    doActionIBSheet(sheetObjects[0],document.form,SEARCH07);    
            // Calling Tml Mtx lane code check	
		    } else if(cmd =='SEARCH10') { 
    		    doActionIBSheet(sheetObjects[0],document.form,SEARCH10);    

            // S/P check	
		    } else if(cmd =='SEARCH08') { 
    		    doActionIBSheet(sheetObjects[0],document.form,SEARCH08);    

		    } else {
        	    // 다음 포커스로 이동 
                tmp = GetObjectByTabIndex(document.form,objEle.tabIndex+1); 
                if (tmp == null) tmp = GetObjectByTabIndex(document.form,1); 
                if (tmp != null) tmp.focus(); 
                //objEle.focus()    		        
		    }
	        if(retValidate < 1 && cmd !="") {
                objEle.focus();
                objEle.select();
                return false;
        	} else if(cmd !="") { // 어떤 command를 수행후 정상일때 
        	    // 다음 포커스로 이동 
                tmp = GetObjectByTabIndex(document.form,objEle.tabIndex+1); 
                if (tmp == null) tmp = GetObjectByTabIndex(document.form,1);
                if (tmp != null) {
                    if(tmp.type =='select-one') {
                        tmp.selectedIndex ;
                    }else {
                        
                        tmp.select();
                    }
                    tmp.focus();
                //objEle.focus();    
                }
                return false;
        	}
			
	        
	    } else {
        	    // 다음 포커스로 이동 
                tmp = GetObjectByTabIndex(document.form,objEle.tabIndex+1); 
                if (tmp == null) tmp = GetObjectByTabIndex(document.form,1); 
                
                if (tmp != null) {
                    tmp.select(); 		        
                    tmp.focus(); 		        
                }
                return false;
	    }

	} else 
	if (e==8 || e==46 || (e>=37 && e<=40)){
	} else {
	    if(objVal.length>0) {
		    //대문자로 변경, 알파벳,숫자인지 체크 
			if(re.test(objVal)) {
			    objEle.value  = objVal.toUpperCase();
                return false;
			} else {
			    ComShowMessage(getMsg('PRD90016'));
			}		        
	    }

	}
}
     
/**
 * 입력된값을 대문자로 바꾸고 validation check 
 */     
function inputChkUpper2(obj, e) {
	var objNm = obj.name;
    var objVal = eval('document.form.'+objNm+'.value');
    var objEle = eval('document.form.'+objNm);
	re = /^[a-zA-Z0-9]+$/; 
	te = /\t/;
    validateData = objVal.toUpperCase();
	if(e==9) {
		//validation check 
		doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
		if(retValidate < 1) {
            objEle.focus();
    	} 
    	else {
    	    // 다음 포커스로 이동 
            tmp = GetObjectByTabIndex(document.form,objEle.tabIndex+1); 
            if (tmp == null) tmp = GetObjectByTabIndex(1); 
            if (tmp != null) tmp.focus(); 
    	    
            //objEle.focus();    
    	}
	} else if (e==8 || e==46 || (e>=37 && e<=40)){
		//('bs del 방향키 무시 ');
	} else {
		if(re.test(objVal)) {
		    objEle.value  = objVal.toUpperCase();
		} else {
		    ComShowMessage(getMsg('PRD90016'));
		}
	}
}    
	
/**
 * 입력한 tabIndex로 객체리턴
 */	
function GetObjectByTabIndex(formObj,index){ 

    for (i = 0; i < formObj.length; i++){ 
        tmp = formObj.elements[i]; 
        if (tmp.tabIndex == index){ 
            return tmp; 
        } 
    } 
    return null; 
} 	

/**
 * 탭 이동 
 */    
function move_next_tab(obj) {
    var objNm = obj.name;
    var objVal = eval('document.form.'+objNm+'.value');
    var objEle = eval('document.form.'+objNm);
    // 다음 포커스로 이동 
    tmp = GetObjectByTabIndex(document.form,objEle.tabIndex+1); 
    if (tmp == null) tmp = GetObjectByTabIndex(document.form,1); 
//   alert(tmp.name);
   
    if (tmp != null) {
        tmp.focus(); 		        
        if(tmp.type =='select-one') {
            tmp.selectedIndex ;
        }else {
            
            tmp.select();
        }         
    }
//    return false;    
}
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
    
function toolTip() {

	oObj = document.forms[0].elements;
	for(i=0;i< oObj.length;i++){
		atr1=oObj[i];
        if(atr1.id != '')
		eval('document.all.'+atr1.id+'.title='+atr1.id  );
	}

}


/**
 * max 입력길이만큼 입력시 다음 항목으로 
 * 
 * @param size max 입력길이
 */    
function go_next(size){


	var  el = event.srcElement;
	var i=0
   while (el != el.form.elements[i] )  i++

	
	next_pos = i + 1;
	value = el.form.elements[i].value;

	len = value.length;
	is_num = Number(value);

//체크 사항 필요시 추가 
//	if(!is_num) {
//		if((len > 0) && (value != '0') && (value != '00') && (value != '000')) {
//			alert('숫자를 넣어주세요');
//			el.form.elements[i].select();
//			el.form.elements[i].focus();
//			return false;
//		}
//	}

	if(len == size){
		el.form.elements[next_pos].focus();
		return true;
	}
}

    
/**
* ToolTip
*/

function balloonHint(Id)
{
    balloonHint.layerId = Id;

    document.addEventListener('mouseover', balloonHint.Show, false);
    document.addEventListener('mouseout', balloonHint.Hide, false);
}
balloonHint.layerId = null;
balloonHint.Show = function (evt) {
    if (typeof evt == "undefined" || typeof evt.target == "undefined") {
        (evt=event).target = event.srcElement;
    }
	var hint = eval(event.srcElement.id);
    //var hint = evt.target.getAttribute("hint");
    if (hint == null || hint.length == 0 || hint == "undefined") return;
    if (balloonHint.layer == null) balloonHint.makeLayer();

    with (balloonHint.layer) {
        innerHTML = sourceHTML.replace("{{hint}}", hint);
        show(evt.clientX, evt.clientY);
    }
}

balloonHint.Hide = function (evt) {
    if (typeof evt == "undefined" || typeof evt.target == "undefined") {
        (evt=event).target = event.srcElement;
    }

    var hint = evt.target.getAttribute("hint");
    if (hint == null || hint.length == 0) return;

    balloonHint.layer.hide();
}

balloonHint.makeLayer = function()
{
    if (typeof document.body == "undefined") {
        document.body = document.getElementsByTagName("BODY")[0];
    }

    balloonHint.layer = document.getElementById(balloonHint.layerId);
    balloonHint.layer.sourceHTML = balloonHint.layer.innerHTML;
    balloonHint.layer.style.position = "absolute";

    if (typeof window.createPopup == "undefined") {
        balloonHint.layer.show = function(x, y) {
            balloonHint.layer.style.display = "block";
            balloonHint.layer.style.left = (x+document.body.scrollLeft+1) + "px";
            balloonHint.layer.style.top = (y+document.body.scrollTop+1) + "px";
        }
        balloonHint.layer.hide = function() {
            balloonHint.layer.style.display = "none";
        }
    } else {
        balloonHint.layer.popup = window.createPopup();
        balloonHint.layer.show = function(x, y) {
            with (balloonHint.layer) {
                style.display = "block";
                var w = offsetWidth, h = offsetHeight;
                style.display = "none";
                popup.document.body.innerHTML = innerHTML;
                popup.show(x, y, w+55, h+55, document.body);
            }
        }
        balloonHint.layer.hide = function() {
            balloonHint.layer.popup.hide();
        }
    }
}

if (typeof document.addEventListener == "undefined") {
    if (typeof document.attachEvent != "undefined") {
        document.addEventListener = function (eventType, listener) {
            document.attachEvent("on"+eventType, listener);
        }
        document.removeEventListener = function (eventType, listener) {
            document.detachEvent("on"+eventType, listener);
        }
    }
}