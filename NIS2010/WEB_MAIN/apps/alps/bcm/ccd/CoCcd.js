/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoCcd.js
*@FileTitle  : CCD 공통 자바스크립트
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
 
/**
* IBMulti Combo Item Setting
* param : comboObj ==> Combo Object  
* param : arrStrNm ==> Combo Item Name Array
* param : arrStrCd ==> Combo Item Code Array
*/

	if(msgs == undefined){
		msgs = new Array();
	}
msgs['CCD00001'] = 'Mandatory field is missing.  Please enter [{?msg1}].';
msgs['CCD00002'] = 'There is no data.';
msgs['CCD00003'] = 'When Activity Type is \'T\', [{?msg1}] can not be blank.';
msgs['CCD00004'] = 'Duplicate data exist in [{?msg1}], Please check it again.';
msgs['CCD00005'] = '[{?msg1}] should be later than [{?msg2}]';
msgs['CCD00006'] = 'This data alreay exists';
msgs['CCD00007'] = 'It is not an e-mail address format. Please check it again.';
msgs['CCD00008'] = 'There should be one Primary Check Flag.';
msgs['CCD00009'] = 'Customer Code has only one Primary Flag.';
msgs['CCD00010'] = 'Selected [{?msg1}] does not match Type Size Code.';
msgs['CCD00011'] = "Data count:[{?msg1}] \nDo you want to down excel?";
msgs['CCD00012'] = "Do you want to delete data?";
msgs['CCD00013'] = 'The location of "{?msg1}" is not defined in location table. Please check location code.';
msgs['CCD00014'] = 'The Code already exist in lease company yard master codes. Please check again.';
msgs['CCD00015'] = 'SCC is not found! If you want to update EQ SCC, please advise MDA administrator.';
msgs['CCD00016'] = 'This code is using in other EQ location hierarchy.\nPlease check this again in the EQ location hierarchy.';
msgs['CCD00017'] = 'This code is using as SCC code of specific Location code(s).\nIf you want to delete this SCC code, SCC of the Location code(s) should be changed first.\nPlease check this again in the Location  area.';
msgs['CCD00018'] = 'This code is using as SCC code of specific Yard code(s).\nIf you want to delete this SCC code, SCC of the Yard code(s) should be changed first.\nPlease check this again in the Yard  area.';
msgs['CCD00019'] = 'There is no data to save.';
msgs['CCD00020'] = 'As SCC code is aleady exist, data was saved partially. Please check this again.';
msgs['CCD00021'] = 'SCC code is aleady exist. Please check this again.';
msgs['CCD00022'] = 'Character and Port flag is unmatched. Please check again.';
msgs['CCD00023'] = 'Do you want to {?msg1}?';
msgs['CCD00024'] = 'The Code already exist in yard master codes. Please check again.';
msgs['CCD00025'] = 'Region is not defined. Please enter Region code.';
msgs['CCD00026'] = 'Request was approved.';
msgs['CCD00027'] = 'Please input \"Reject reason\" into comments.';
msgs['CCD00028'] = 'Your reject message was transmitted.';
msgs['CCD00029'] = 'Do you want to really {?msg1}?';
msgs['CCD00030'] = 'Do you want to request Code Creation to Master Data Steward?';
msgs['CCD00031'] = 'Your request was transmitted!';
msgs['CCD00032'] = 'Do you want to {?msg1}?';
msgs['CCD00033'] = "{?msg1} doesn't exist.";
msgs['CCD00034'] = "{?msg1} doesn't exist. Do you want to create this code?";
msgs['CCD00035'] = "Do you want to create this Location Code?";
msgs['CCD00036'] = 'Rejected request was deleted.';
msgs['CCD00037'] = 'This data is waiting approval.';
msgs['CCD00038'] = 'Please input {?msg1}.';
msgs['CCD00039'] = 'Customer Code format is incorrect (Alphabet 2 digit + Numeric 1 digit over).';
msgs['CCD00040'] = 'There is no credit information of this customer.';
msgs['CCD00041'] = 'SCC is not found. If you want to update EQ SCC, please register SCC first.';
msgs['CCD00042'] = 'SCC is missing! If you want to update Yard Code, please go to Location and enter EQ SCC.';
msgs['CCD00043'] = 'At least 1 item among {?msg1} is needed';
msgs['CCD00044'] = 'Vessel Code must be 4 digit code';
msgs['CCD00045'] = 'Legacy Code(SAP ID) is not unique.';
msgs['CCD00046'] = 'Check process status, Request has been approved. Request No.: {?msg1}';
msgs['CCD00047'] = 'There is a restriction on typing address when selected control office is in Japan.';
msgs['CCD00048'] = 'It is deleted data, so change the delete flag first.';
msgs['CCD00049'] = 'VIP Code must be 3 digit code';
msgs['CCD00050'] = 'This customer code is already being used, so you can not delete.';
msgs['CCD00051'] = 'Country code is not matched with Location Code.';
msgs['CCD00052'] = 'Customer cannot be deleted. It is used in {?msg1}.';
msgs['CCD00053'] = 'The Code already exist in location codes. Please check again.';
msgs['CCD00054'] = 'Creating {?msg1} has been canceled.';
msgs['CCD00055'] = '{?msg1} must be less than {?msg2}.';
msgs['CCD00056'] = 'The Code already exist in Zone codes. Please check again.';
msgs['CCD00057'] = '{?msg1} must be {?msg2} digit code.';
msgs['CCD00058'] = "Data was saved successfully. \nFor generating vendor code in MDM, process next step \"Approval Request\".";
msgs['CCD00059'] = "The Request is already approved or rejected.";
msgs['CCD00060'] = "Data was {?msg1} successfully."	;
msgs['CCD00061'] = "Do you want to create this Yard Code?";
msgs['CCD00062'] = "Do you want to create this Zone Code?";
msgs['CCD00063'] = "Please select row.";
msgs['CCD00064'] = "There is no yard code in master yard. Please check again.";
msgs['CCD00065'] = "Please make a request first."	;
msgs['CCD00066'] = "{?msg1} can only contain {?msg2} decimal places.";	
msgs['CCD00067'] = "Integer part of {?msg1} can not be entered more than {?msg2} digits.";
msgs['CCD00068'] = 'There should be one Primary Check Flag in {?msg1} rows.';
msgs['CCD00069'] = 'The Code already exist in prd node. Please check again.';
msgs['CCD00070'] = "DST is not registered in your country & year. \nPlease register DST area first.";
msgs['CCD00071'] = 'The Code already exist in Leasing yard. Please check again.';
msgs['CCD00072'] = 'The Code already exist in {?msg1}. Please check again.';
msgs['CCD00073'] = 'In case of Transport Action Type, only the {?msg1} letter of the Activity Code is can be the letter {?msg2}.';
msgs['CCD00074'] = 'In case of Document Action Type, Activity Code must consist of 3 digits.';
msgs['CCD00075'] = 'Do you want to create this {?msg1} Code?';

/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = ComXmlString(xmlStr, nm);
 * 
 * </pre>
 * 
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {string} Text컬럼명.
 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
  * @author 박성수
  * @version 2009.04.22
 */
function _ComGetValueForCombo(obj) {
	if (Object.prototype.toString.call(obj) === '[object Array]') {
	  var str = obj[0];
	  return str;
	  }
	  return obj;
  }   

//이메일 주소 유효성 체크
function isEmailAddr(event){
    eventElement=ComGetEvent();
	if(eventElement.value.length > 0) {
		if(!ComIsEmailAddr(eventElement)) {
			ComShowCodeMessage("COM131501");
		}
	}
}



/**
 * null을 blank("")로 변경<br>
 * @param   String
 * @return  String
 * @author  이남경
 * @version 2009.05.21
 */
  function nullToBlank(val) {
    return (val==null) ? "" : val;
 }
  
/**
 * Mdm History 팝업 호출<br>
 * <br><b>Example :</b>
 * <pre>
 *     comMdmCallPop(tblNm, mstKey);
 * </pre>
 * @param  tblNm, mstKey
 * @return 없음
 * @author 이남경
 * @version 2009.08.04
 */
function comMdmCallPop(tblNm, mstKey){
    var param = "?pgmNo=BCM_CCD_2004&tbl_nm="+tblNm+"&mst_key="+mstKey;
    var sUrl  = "BCM_CCD_2004.do"+param;
    //ComOpenPopup('ESM_BKG_0566.do'+param, 900, 550, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1', true);  //false
    //ComOpenWindowCenter(sUrl, "BCM_CCD_2004", 1024,710, true);
    ComOpenWindowCenter(sUrl, "BCM_CCD_2004", 1024, 680, true);
}



// 기존 ComXmlString (S) 
/*
function ComXmlString(xmlStr, codeCol) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}
	if (codeCol == null || codeCol == "") {
		return rtnArr;
	}
	try {
		 var xmlDoc = ComGetXmlDoc(xmlStr);
	     if (xmlDoc == null) return;
	    
	     var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return rtnArr;
		}

		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
//		if (dataNode == null || dataNode.attributes.length < 3) {
		if (dataNode == null) {
			return rtnArr;
		}
		var col=dataNode.getAttribute("COLORDER");
		if(col == null || col =="" || col == "null" ){
			return rtnArr;
		}
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return rtnArr;
		}
		var colListIdx=Array();
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
		}
		var sCode="";
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			sCode += arrData[colListIdx[0]];
			if (i != dataChildNodes.length - 1) {
				sCode += "|";
			}
		}

		if(sCode.length > 0 &&  sCode.slice(-1) == "|"){
			sCode = sCode.substring(0,sCode.length-1)
		}
		rtnArr.push(sCode);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return _ComGetValueForCombo(rtnArr);
}
*/
// 기존 ComXmlString (E)

// 새로운 ComXmlString (S)
function ComXmlString(xmlStr, codeCol) {
 	var rtnArr = new Array();
 	
 	if (xmlStr == null || xmlStr == "") {
 		return rtnArr;
 	}
 	
 	if (codeCol == null || codeCol == "") {
 		return rtnArr;
 	}

 	try {
 		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
 		xmlDoc.loadXML(xmlStr);

 		var xmlRoot = xmlDoc.documentElement;
 		if (xmlRoot == null) {
 			return rtnArr;
 		}

 		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
 		if (dataNode == null || dataNode.attributes.length < 3) {
 			return rtnArr;
 		}

 		var col = dataNode.getAttribute("COLORDER");
 		var colArr = col.split("|");
 		var sep = dataNode.getAttribute("COLSEPARATOR");
 		var total = dataNode.getAttribute("TOTAL");

 		var dataChildNodes = dataNode.childNodes;
 		if (dataChildNodes == null) {
 			return rtnArr;
 		}
 		
 		var colListIdx = Array();
 		for ( var i = 0; i < colArr.length; i++) {
 			if (colArr[i] == codeCol) {
 				colListIdx[0] = i;
 			}
 		}
 		
 		var sCode = "";
 		for ( var i = 0; i < dataChildNodes.length; i++) {
 			if (dataChildNodes[i].nodeType != 1) {
 				continue;
 			}
 			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
 			
 			sCode += arrData[colListIdx[0]];
 			
 			if (i != dataChildNodes.length - 1) {
 				sCode += "|";
 			}
 		}
 		rtnArr.push(sCode);
 	} catch (err) {
 		ComFuncErrMsg(err.message);
 	}

 	return rtnArr;
 }
// 새로운 ComXmlString (E)

/**
 * DATE 값이 변경 되었을 때 값의 유효성을 체크
 */
function checkDateValue(obj) {
	if (!ComIsDate(obj.value)) {
		ComShowCodeMessage("COM12179");
		obj.focus();
		return false;
	}
	return true;
}
/**
 * DATE 값이 변경 되었을 때 값의 유효성을 체크
 */
function checkEmailValue(obj) {
	if (!ComIsEmailAddr(obj.value)) {
		ComShowCodeMessage("CCD00007");
 		obj.focus();
 		return false;
 	}
 	return true;
}
/**
 * DATE 값이 변경 되었을 때 값의 유효성을 체크
 */
function checkDateForm(obj) {
	ComKeyOnlyNumber(obj);
	var srcValue=obj.value;
 	if (srcValue.length == 4) {
 		obj.value=srcValue.substring(0,4) + "-"
 	}
 	if (srcValue.length == 7) {
 		obj.value=srcValue.substring(0,7) + "-"
 	}
}


/**
 * 키보드가 눌릴 때 dataformat으로 세팅하고 엔터키를 누를때 조회한다.
* @author  김민정
 */
function obj_KeyPress(){
  var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
  var srcName = event.srcElement.getAttribute("name");
  var srcValue = event.srcElement.getAttribute("value");
  switch(event.srcElement.dataformat) {

      case "ymd":
        ComKeyOnlyNumber(event.srcElement);
    	 if (srcValue.length == 4) {
    	    document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
    	 }
    	 if (srcValue.length > 4 && srcValue.indexOf('-') < 0) {
    		return;
    	 }
    	 if (srcValue.length == 7) {
    		document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
    	 }
          break;
      case "ymdhm":
    	  ComKeyOnlyNumber(event.srcElement);
    	  if (srcValue.length == 4) {
    		  document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
    	  }
    	  if (srcValue.length == 7) {
    		  document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
    	  }
    	  if (srcValue.length == 10) {
    		  document.form.elements[srcName].value = srcValue.substring(0,10) + " "
    	  }
    	  if (srcValue.length == 13) {
    		  document.form.elements[srcName].value = srcValue.substring(0,13) + ":"
    	  }
          break;
      case "ym":
          ComKeyOnlyNumber(event.srcElement);
          if (srcValue.length == 4) {
            document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
          }
          break;
      case "yw":
      case "jumin":
      case "saupja":  //숫자 + "-"
          ComKeyOnlyNumber(event.srcElement, "-"); break;
      case "hms":
          ComKeyOnlyNumber(event.srcElement, ":");
          if (srcValue.length == 2) {
        	  document.form.elements[srcName].value = srcValue.substring(0,2) + ":"
          }
          if (srcValue.length == 5) {
        	  document.form.elements[srcName].value = srcValue.substring(0,5) + ":"
          }
          break;
      case "hm":    //숫자 + ":"
          ComKeyOnlyNumber(event.srcElement, ":");
          if (srcValue.length == 2) {
       		  document.form.elements[srcName].value = srcValue.substring(0,2) + ":"
          }
          break;
      case "yy":    //숫자 + "0"
          ComKeyOnlyNumber(event.srcElement, "0"); break;
      case "int":    //숫자
          ComKeyOnlyNumber(event.srcElement);  break;
      case "float":  //숫자+"."
          ComKeyOnlyNumber(event.srcElement, "."); break;
      case "signedfloat":  //숫자+".-"
        ComKeyOnlyNumber(event.srcElement, ".-"); break;
      case "commafloat":  //숫자+",-"
            ComKeyOnlyNumber(event.srcElement, ",-"); break;
      case "dashfloat":  //숫자+",-"
        ComKeyOnlyNumber(event.srcElement, "-"); break;
      case "eng":    //영문 + 숫자
        // 영문은 기본 대문자로 한다.(포멧에 대소문자 구분 + 숫자가 없음)
          ComKeyOnlyAlphabet('uppernum'); break;
      case "engup":  //영문대문자
          ComKeyOnlyAlphabet('upper'); break;
      case "engdn":  //영문소문자
          ComKeyOnlyAlphabet('upper'); break;
      case "engupnum"://숫자+"영문대분자"입력하기
      	  ComKeyOnlyAlphabet('uppernum'); break;
      case "engnum"://숫자+"영문대소"입력하기
  	  	  ComKeyOnlyAlphabet('num'); break;
      case "engupspace": //영문대문자 + Space
          if(event.keyCode != 32) {
              ComKeyOnlyAlphabet('uppernum');
          }
      case "engupspace2": //영문대문자 + Space
          if(event.keyCode != 32) {
        	 ComKeyOnlyAlphabet('upper');
          }
          break;
      case "engupspecial": // 영문대문자 + Space + &-,.
          ComKeyOnlyAlphabet('uppernum', "32|38|45|44|46");
          break;
      case "etc": //모든 문자 가능하지만 영문은 대문자로
          if(keyValue >= 97 && keyValue <= 122) {//소문자
              event.keyCode = keyValue + 65 - 97;
          }
      	  break;
      case "all":
    	  break;
      default:     //영문 + 숫자
          ComKeyOnlyAlphabet('uppernum'); break;
    }
}

/**
 * 인자로 받은 HTML태그(Object)의 사용 가능/불가능 상태를 변경한다. <br>
 * &lt;input type="text"&gt;와 &lt;input type="password"&gt;의 경우 readOnly속성과 backgroundColor,color를 변경하고,  <br>
 * &lt;img&gt;의 경우 disable속성과  cursor,filter를 변경한다. <br>
 * 그외 HTML태그(Object) disable속성을 변경한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     ComEnableObject(txtName,  true);   // 결과 : &lt;input type="text" name="txtName"&gt;을 enable 상태로 설정한다.
 *     ComEnableObject(txtName,  false);  // 결과 : &lt;input type="text" name="txtName"&gt;을 disable 상태로 설정한다.
 *     ComEnableObject(btn_save, true);   // 결과 : &lt;img name="btn_save"&gt;을 enable 상태로 설정한다.
 *     ComEnableObject(btn_save, false);  // 결과 : &lt;img name="btn_save"&gt;을 disable 상태로 설정한다.
 * </pre>
 * @param {object} obj     필수,대상 HTML태그(Object)
 * @param {bool}   bEnable 필수,사용 가능/불가능 여부를 true/false로 설정한다.
 * @return 없음
 * @see #ComEnableManyObjects
 */
function ComEnableObject(obj, bEnable, necessary)
{
    try {
    	//disabled나 readOnly 설정하기
        switch( obj.type ) {
            case "password" :
            case "text" :
            	obj.readOnly = !bEnable;
                break;
            default:
                 if(obj.tagName != "OBJECT")  //20150127 Ibsheet exit
                            obj.disabled = !bEnable;
//                obj.disabled = !bEnable;
        }

		//설정에 따라 css 처리하기
        switch( obj.type ) {
            case "select-one" :
            case "text" :
                if (bEnable){
                    if (obj.className=="input2_1"){	//회색바탕 - 필수입력 빨강색
                    	obj.className = "input2";	//흰색바탕 - 필수입력 빨강색
                    } else if (obj.className=="input2" && necessary) {
                    	obj.className = "input1";
                    } else {
                    	obj.className = "input";    //흰색바탕
                    }
                } else {
                    if (obj.className=="input2"){	//희색바탕 - 필수입력 빨강색
                    	obj.className = "input2_1";	//회색바탕 - 필수입력 빨강색
                    } else {
                    	obj.className = "input2";   //회색바탕
                    }
                } 
                break;

            case "textarea":
                if (bEnable){
                	obj.className = "textarea";
                } else {
                	obj.className = "textarea2";
                }
                break;

			default :
                if (obj.tagName=="IMG") {
                    if (bEnable){
                        obj.style.cursor = "hand";
                        obj.style.filter="";
                    } else {
                        obj.style.cursor = "default";
                        obj.style.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
                    }
                }
        }

    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * 
 * MDM Yard 화면의 Gate time 항목에 24:00까지 입력을 위해 수정하여 추가 
 * 입력된 문자열이 시간 Format인지 여부를 확인한다. 문자열 내의 시간구분자(":")는 제거되고 비교한다.<br>
 * sFlag 설정값을 다음과 같다.<br>
 * sFlag="hms" : "hh:mm:ss" 포멧인 경우<br>
 * sFlag="hm"  : "hh:mm" 포멧인 경우<br>
 * sFlag=없음  : 기본적으로 설정하지 않으면 "hms"로 인식한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     ret = ComIsTime("231011")      // 결과 : true
 *     ret = ComIsTime("23:10:11")    // 결과 : true
 *     ret = ComIsTime("23:44:60")    // 결과 : false
 *     ret = ComIsTime("23:46", "hm") // 결과 : true
 *     ret = ComIsTime(txtTime)       // 결과 : true, txtTime="01:00:00"인 경우
 * </pre>
 * @param {string,object} obj   필수,시간 문자열 또는 HTML태그(Object)
 * @param {string}        sFlag 선택,시간 포멧 구분, default="hms"
 * @returns bool <br>
 *          true  : 시간 포멧에 맞는 경우<br>
 *          false : 시간 포멧에 맞지 않는 경우
 * @see #ComIsDate
 * @see #ComIsDateTime
 * @see #ComGetNowInfo
 */
function ComIsGateTime(obj, sFlag) {
    try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var sVal = getArgValue(obj);

        //시간구분자로 사용될수 있는 ":"를 제거되고 비교한다.
        sVal = ComReplaceStr(sVal, ":");

        if (!ComIsNumber(sVal)) return false;
        if (sFlag==undefined || sFlag==null) sFlag = "hms";

        var hh, mm, ss;

        switch(sFlag.toLowerCase()) {
            case "hm":  //시분
                if (sVal.length != 4) return false;
                ss  = 0;
                break;
            default:   //시분
                if (sVal.length != 6) return false;
                ss = ComParseInt(sVal.substr(4,2));
        }
        hh = ComParseInt(sVal.substr(0,2));
        mm = ComParseInt(sVal.substr(2,2));

        if (hh <0 || hh > 24) return false;
        if (hh==24&& mm > 0 ) return false;
        if (mm <0 || mm > 59) return false;
        if (ss <0 || ss > 59) return false;

        return true;
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * MDM Yard 화면의 Gate time 항목에 24:00까지 조회를 위해 수정하여 추가 
 * 인자값이 Validation에 맞는 값인지 확인하고, 포멧에 맞게 구분자를 포함한 문자열을 반환한다. <br>
 * Validation에 맞지 않는 경우 함수의 결과는 ""을 리턴한다. <br>
 * sFormat 인자값은 다음 중 선택하여 설정한다. <br>
 * sFormat="ymd"    : 년월일 형태인 "yyyy-mm-dd" 포멧인 경우<br>
 * sFormat="ym"     : 년월   형태인 "yyyy-mm" 포멧인 경우<br>
 * sFormat="yw"     : 년주   형태인 "yyyy-ww" 포멧인 경우<br>
 * sFormat="hms"    : 시분초 형태인 "hh:mm:ss" 포멧인 경우<br>
 * sFormat="hm"     : 시분   형태인 "hh:mm" 포멧인 경우<br>
 * sFormat="int"    : 정수   형태인 "#,###" 포멧인 경우, {@link #ComAddComma} 함수와 동일하다<br>
 * sFormat="float"  : 실수   형태인 "#,###.##" 포멧인 경우, {@link #ComAddComma} 함수와 동일하다<br>
 * sFormat="jumin"  : 주민등록번호   형태인 "######-#######" 포멧인 경우<br>
 * sFormat="saupja" : 사업자등록번호 형태인 "###-##-#####" 포멧인 경우<br>
 * sFormat="han"    : 한글+숫자 입력 가능<br>
 * sFormat="eng"    : 영문+숫자 입력 가능<br>
 * sFormat="engup"  : 영문대문자<br>
 * sFormat="engdn"  : 영문소문자<br>
 * <br><b>Example :</b>
 * <pre>
 *     ret = ComGetMaskedValue("20080909", "ymd")         //결과 : "2008-09-09"
 *     ret = ComGetMaskedValue("200809",   "ym")          //결과 : "2008-09"
 *     ret = ComGetMaskedValue("201059",   "hms")         //결과 : "20:10:59"
 *     ret = ComGetMaskedValue("2010",     "hm")          //결과 : "20:10"
 *     ret = ComGetMaskedValue("12345678", "int")         //결과 : "12,345,678"
 *     ret = ComGetMaskedValue("123456.78", "float")      //결과 : "123,456.78"
 *     ret = ComGetMaskedValue("7701011234561", "jumin")  //결과 : "", 주민등록번호가 올바르지 않아서 ""을 리턴했음
 *     ret = ComGetMaskedValue("7701011234562", "jumin")  //결과 : "770101-1234562"
 *     ret = ComGetMaskedValue("1234567891",    "saupja") //결과 : "123-45-67891"
 *     ret = ComGetMaskedValue("가나다라", "han")         //결과 : "가나다라"
 *     ret = ComGetMaskedValue("abcd", "eng")             //결과 : "abcd"
 *     ret = ComGetMaskedValue("abcd", "engup")           //결과 : "ABCD"
 *     ret = ComGetMaskedValue("ABCD", "engdn")           //결과 : "abcd"
 * </pre>
 * @param {string, object} obj      필수,문자열 또는 HTML태그(Object)
 * @param {string}        sFormat   필수,포멧구분 문자열
 * @param {string}        sDelim    선택,포멧구분, default=sFormat 인자값에 따라 결정
 * @returns string  -Format에 맞게 Mask가 포함된 문자열<br>
 *          공백("")-포멧에 맞지않는값이거나, 인자값이 올바르지 않는 경우<br>
 * @see #ComAddComma
 * @see #ComAddComma2
 * @see #ComGetUnMaskedValue
 */    
function ComGetMaskedGateValue(obj, sFormat, sDelim) {
    try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var sVal = String(getArgValue(obj));

        if (ComIsEmpty(sVal)) return "";

        var sRegExp         = "";
        var sReplaceText    = "";
        var sResultVal      = "";

        var sDelim = getFormatDelim(sFormat, sDelim);

        switch(sFormat) {
            case "ymd":     //yyyy-mm-dd
                sVal = ComTrimAll(sVal, "-", "/", ".");
                if (!ComIsDate(sVal)) break;
                var re      = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])');
                sResultVal  = sVal.replace(re,'$1' + sDelim + '$2' + sDelim + '$3');
                break;
            case "ymdhms":     //yyyy-mm-dd hh:mm:ss
                sVal = ComTrimAll(sVal, "-", ":"," ");
                if (!ComIsDateTime2(sVal,sFormat)) break;
                var re      = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])');
                sResultVal  = sVal.replace(re,'$1' + sDelim + '$2' + sDelim + '$3'+' '+'$4' + ':' + '$5' + ':' + '$6');
                break;
            case "ymdhm":     //yyyy-mm-dd hh:mm
                sVal = ComTrimAll(sVal, "-", ":"," ");
                if (!ComIsDateTime2(sVal,sFormat)) break;
                var re      = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])');
                sResultVal  = sVal.replace(re,'$1' + sDelim + '$2' + sDelim + '$3'+' '+'$4' + ':' + '$5');
                break;
            case "ym":      //yyyy-mm
            case "yw":      //yyyy-ww
                sVal = ComTrimAll(sVal, "-", "/", ".");
                if (!ComIsDate(sVal, sFormat)) break;
                var re      = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])');
                sResultVal  = sVal.replace(re,'$1' + sDelim + '$2');
                break;   
			case "yyyy":
				if (!ComIsDate(sVal,"yyyy")) break;
                sResultVal = sVal;  
				break;	   
            case "hms":     //hh:mm:ss
                sVal = ComTrimAll(sVal, ":");
                if (!ComIsTime(sVal)) break;
                var re      = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9])');
                sResultVal  = sVal.replace(re,'$1' + sDelim + '$2' + sDelim + '$3');
                break;
            case "hm":      //hh:mm
                sVal = ComTrimAll(sVal, ":");
                if (!ComIsGateTime(sVal, "hm")) break;
                var re      = new RegExp('([0-9][0-9])([0-9][0-9])');
                sResultVal  = sVal.replace(re,'$1' + sDelim + '$2');
                break;
            case "int":     //정수
                if (!ComIsMoneyNumber(sVal, false, true, true)) break;
                sResultVal  = ComAddComma(sVal);
                break;
            case "float":     //실수
                if (!ComIsMoneyNumber(sVal, true, true, true)) break;
                sResultVal  = ComAddComma(sVal);
                break;
            case "jumin":   //######-#######
                sVal = ComTrimAll(sVal, "-");
                if (!ComIsNumber(sVal) || !ComIsJuminNo(sVal)) break;
                var re      = new RegExp('([0-9][0-9][0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
                sResultVal  = sVal.replace(re,'$1' + sDelim + '$2');
                break;
            case "saupja":  //###-##-#####
                sVal = ComTrimAll(sVal, "-");
                if (!ComIsNumber(sVal) || !ComIsSaupjaNo(sVal)) break;
                var re      = new RegExp('([0-9][0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9][0-9])');
                sResultVal  = sVal.replace(re,'$1' + sDelim + '$2' + sDelim + '$3');
                break;
            case "han": 
            case "eng":
                sResultVal = sVal;  break;
            case "engup":
                sResultVal = sVal.toUpperCase();    break;
            case "engdn":
                sResultVal = sVal.toLowerCase();    break;
            default :
                return "";
        }

        return sResultVal;
    } catch(err) { ComFuncErrMsg(err.message); }
} 