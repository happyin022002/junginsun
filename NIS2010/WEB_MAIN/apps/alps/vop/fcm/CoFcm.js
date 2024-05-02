//*************** FCM START ***************// 

//FCM COMMON MESSAGE
msgs["FCM00001"] = "Do you want to delete ?";
msgs["FCM00002"] = '({?msg1}) Mandatory field is missing. Please try again.';
msgs["FCM00003"] = 'Data ({?msg1}) format is wrong. Please check it again!';
msgs["FCM00004"] = 'There is no changed data.';
msgs["FCM00005"] = 'Please check period. The maximum period is {?msg1}.';
msgs["FCM00006"] = '({?msg1}) Mandatory field is missing. Please try again.';
msgs["FCM00007"] = 'Please select the check box of Not Received report.';

//FCM COMMON PROPERTY
//선택시 배경색 R
var SelectBackColorR = '240';
//선택시 배경색 G 
var SelectBackColorG = '255';
//선택시 배경색 B
var SelectBackColorB = '255';

//IBSheet 디폴트 배경색 R (수정불가모드)
var SheetNoEditBackColorR = '239';
//IBSheet 디폴트 배경색 G (수정불가모드)
var SheetNoEditBackColorG = '235';
//IBSheet 디폴트 배경색 B (수정불가모드) 
var SheetNoEditBackColorB = '239';

//IBSheet 디폴트 배경색 R (수정가능모드)
var SheetEditBackColorR = '255';    
//IBSheet 디폴트 배경색 G (수정가능모드)
var SheetEditBackColorG = '255';     
//IBSheet 디폴트 배경색 B (수정가능모드) 
var SheetEditBackColorB = '255';     

//FCM COMMON FUNCUTION  
/**
 * XML 에서 루트 노드를 구한다.
 */
function FcmGetXmlRootNode(xmlStr) {
	if(xmlStr == null  || xmlStr == "") return;
	try{
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);
        
        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;
        return xmlRoot;
        
	} catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * XML 에서 이름으로 특정 노드 리스트를 구한다.
 */
function FcmGetXmlNode(xmlStr, nodeName) {
	if(xmlStr == null  || xmlStr == "" || nodeName == null || nodeName == "") return;
	try{
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);
        
        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;
        
        var nodeList = xmlRoot.getElementsByTagName(nodeName);
        return nodeList;
        
	} catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * XML 에서 주어진 노드명의 CDATA Node 값을 구한다.
 */
function FcmGetXmlNodeValue(xmlStr, nodeName) {
	if(xmlStr == null  || xmlStr == "" || nodeName == null || nodeName == "") return "";
	try{
		
		var nodeList = FcmGetXmlNode(xmlStr, nodeName);
		if(nodeList == null || nodeList.length == 0) return "";
		
		var node = nodeList.item(0);
        if(node == null) return "";
        
        var childNodes = node.childNodes;
        if(childNodes == null) return "";
        
        for(var i=0; i<childNodes.length; i++) {
        	if(childNodes[i].nodeType==4){
        		return childNodes[i].nodeValue;
        	}
        }
        
        
	} catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * XML 에서 주어진 노드명의 Text 값을 찾아 반환한다.
 * 
 * @param xmlStr
 * @param nodeName
 * @return
 * @author jinwoo
 */
function FcmGetXmlSelectSingleNodeText(xmlStr, nodeName) {
	if(xmlStr == null  || xmlStr == "" || nodeName == null || nodeName == "") return "";
	try{
		var xmlRoot = FcmGetXmlRootNode(xmlStr);
		var dataNode = xmlRoot.selectSingleNode("//"+nodeName);
		if(dataNode){
			return dataNode.text;
		}else{
			return "";
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * XML이 오류정보를 담고있는지 확인한다.
 * 루트노드가 ERROR인 경우 true, 그렇지 않은경우 false를 리턴한다.
 */
function FcmGetErrorXml(xmlStr) {
	if(xmlStr == null  || xmlStr == "") return false;
	try{
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);
        
        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return false;
        
        if(xmlRoot.nodeName == "ERROR"){
        	return true;
        }
        
        return false;
        
	} catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
 * IBMultiCombo의 item으로 insert 해준다.<br>
 * <b>Example :</b>
 * 
 * <pre>
 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
 * var arrData = ComPriXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
 * 
 * </pre>
 * 
 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
 * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
 * @param {string} codeCol 필수, Combo의 Code컬럼명.
 * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
 * @return 없음.
  * @author by PRI박성수
  * @version 2009.04.22
 */
function ComFcmXml2ComboItem(xmlStr, cmbObj, codeCol, textCol) {
	if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}

	try {
		cmbObj.RemoveAll();
		
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		
		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		var dataChildNodes = dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		
		var colListIdx = Array();
		var arrText = textCol.split("|");
		for ( var i = 0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0] = i;
			}
			for (var j = 0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j+1] = i;
				}
			}
		}
		
		for ( var i = 0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
			
			var item = "";
			for (var j = 1; j < colListIdx.length; j++) {
				item += arrData[colListIdx[j]];
				if (j < colListIdx.length - 1) {
					item += "|";
				}
			}
			cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * 인자로 받은 HTML태그(Object)의 사용 가능/불가능 상태를 변경한다. <br>
 * 
 * @param obj
 * @param bEnable readonly여부(true:readonly false, false:readonly true)
 * @param bCondi 필수여부
 * @return
 * @author jinwoo
 */
function FcmEnableObjectControl(obj, bEnable, bCondi)
{
    try {
    	//disabled나 readOnly 설정하기
        switch( obj.type ) {
            case "password" :
            case "text" :
            	obj.readOnly = !bEnable;
                break;
            default:
                obj.disabled = !bEnable;
        }

		//설정에 따라 css 처리하기
        switch( obj.type ) {
            case "select-one" :
            case "text" :
                if (bEnable){
                	if (bCondi){
                		obj.className = "input1";    //Sky-Blue 바탕
                	} else {
                		obj.className = "input";    //흰색바탕
                	}
                } else {
                	if (bCondi){
                		obj.className = "input1";    //Sky-Blue 바탕
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
 * 숫자 및 사용자가 정의한 문자만 입력가능하게 막음.
 * 
 * @param obj
 * @param sSubChar
 * @return
 * @author jinwoo
 */
function FcmKeyOnlyNumber(obj, sSubChar){
    try {
        var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

        if(keyValue >= 48 && keyValue <= 57) {//숫자
        	// Caption에 정의 된 소숫점 자리수까지만 입력되도록 막음(1자리 더 입력 가능하게).
        	if(obj.value.indexOf(".") >= 0){
        		var oLen = obj.value.length;
        		var dPos = obj.value.indexOf(".");
        		var oCapLen = obj.caption.length;
        		var dCapPos = obj.caption.indexOf(".");
        		if(dCapPos > -1){
	        		if((oLen - dPos) > (oCapLen - dCapPos)){
	        			event.returnValue = false;
	        			return;
	        		}
        		}else{
        			event.returnValue = false;
        			return;
        		}
        	}
            event.returnValue = true;
        } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
        	//"."는 한번만 수용가능
        	if(keyValue == ".".charCodeAt()){
        		if(obj.value.indexOf(".") >= 0){
        			event.returnValue = false;
        			return;
        		}
        	}
        	
        	//SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
        	for(var i=0; i<sSubChar.length; i++) {
        		if (keyValue == sSubChar.charCodeAt(i)) {
	                event.returnValue = true;
	                return;
        		}
        	}
            event.returnValue = false;
        } else {
            event.returnValue = false;
        }
    } catch(err) { ComFuncErrMsg(err.message); }
}

/**
 * 사용자가 Caption 에 정의한 소숫점까지만 입력되도록 막음.
 * @param obj
 * @return
 * @author jinwoo
 */
function FcmKeyNumberPointVaild(obj){
	var objValue = obj.value;
	var objCaption = obj.caption;
	var rtnVal = objValue;

	var oLen = objValue.length;
	var dPos = objValue.indexOf(".");
	var oCapLen = objCaption.length;
	var dCapPos = objCaption.indexOf(".");
	var pointLvl = oCapLen - dCapPos;

	
	if(dPos > -1){
		// 소수점이 있는 경우.
		if(oLen - dPos == 1){
//			rtnVal = objValue.substring(0, dPos);
		}else{
			var iVal = objValue.substring(0, dPos);
			var fVal = objValue.substring(dPos, oLen);
			
			if(fVal.length >= pointLvl){
				fVal = fVal.substring(0, pointLvl);
			}
			rtnVal = iVal + fVal;
		}
	}
	
	// (2010.04.30 임창빈)Caption 지정값보다 입력값에 작게 입력되도록 확인.
	
	var iCapLen = objCaption.substring(dCapPos + 1, oCapLen).length;	// Caption 소수점 이하 자리수 반환
	var iObjValue = objValue.substring(dPos + 1, oLen).length;			// 입력값 소수점 이하 자리수 반환
	var repObjCaption = objCaption.replace("," , "");
	var repObjValue	= objValue.replace("," , "");
	 
	if(dPos > -1){
		// 소수점이 있는 경우.
		var bVal = objValue.substring(dPos + 1, oLen);
		
		if (bVal.length <= 0){
			// 아직 소수점 이하에 값이 없고, 소수점이 입력된 경우 소수점을 무시한다.
			repObjValue	= objValue.replace("." , "");
		}
	}
	
	var fRepObjCaption = parseFloat(repObjCaption);
	var fRepObjValue = parseFloat(repObjValue);
	var i=0;
	
	if (fRepObjCaption < fRepObjValue) {
		// 입력값이 Caption 값 보다 값이  클경우 초기 설정값을 반환한다.
		rtnVal = "0";
		
		if (dCapPos > -1){
			// Data Format 이 Float 일 경우.
			// Caption 에 소수점 이하에 자리수 확인.
			for (i=0;i < iCapLen;i++){
				if (i == 0){rtnVal += "." };
				
				rtnVal += "0"
			}
		}
	}
//	else if(dPos > -1 && (iCapLen > iObjValue)){
//		//Caption 이 소수점 이하이고, 입력값이 Caption 에 소수점 자리수 보다 작을 경우.
//		//Caption 과 동일하게 소수점 이하를 Formatting 한다.
//		
//		for (i=iObjValue;i < iCapLen;i++){
//			rtnVal += "0"
//		}
//	}
	
	obj.value = rtnVal;
}

/**
 * Null 이면 true 반환, Not Null 이면 false 반환.
 * 
 * @param value
 * @return
 */
function FcmIsNull(value){
	if(value == null || value == undefined || value == ""){
		return true;
	}
	return false;
}

/**
 * Null 이면 false 반환, Not Null 이면 true 반환.
 * 
 * @param value
 * @return
 */
function FcmIsNotNull(value){
	if(value == null || value == undefined || value == ""){
		return false;
	}
	return true;
}

/**
 * Null(0 포함) 이면 true 반환, Not Null 이면 false 반환.
 * 
 * @param value
 * @return
 */
function FcmIsNullZero(value){
	if(value == null || value == undefined || value == "" || Number(value) == 0){
		return true;
	}
	return false;
}

/**
 * Null(0 포함) 이면 false 반환, Not Null 이면 true 반환.
 * 
 * @param value
 * @return
 */
function FcmIsNotNullZero(value){
	if(value == null || value == undefined || value == "" || Number(value) == 0){
		return false;
	}
	return true;
}

/**
 * 주어진 기간이 해당 기간이 맞는지 검사.
 * 
 * @param fmDtObj
 * @param toDtObj
 * @param periodType	D : 일, M : 월, Y : 년
 * @return
 */
function FcmCheckPeriod(fmDtObj, toDtObj, periodType){
	var fmDt = ComReplaceStr(fmDtObj.value, "-", "");
	var toDt = ComReplaceStr(toDtObj.value, "-", "");
	var tmpDt = ComGetDateAdd(fmDt, periodType, 1);
	
	if(ComChkPeriod(toDt, tmpDt) == 1){
		return true;
	}else{
		return false;
	}
}

/**
 * 화면상(Form)에 보여줄 Date 형으로 변환하여 반환.
 * 
 * @param sFullDate
 * @return
 */
function FcmReplaceUserDate(sFullDate){
	var usrDate = "";
	
	if(FcmIsNotNull(sFullDate)){
		var ymd = ComGetMaskedValue(sFullDate.substring(0, 8), "ymd");
    	var hm = FcmIsNullToTime(ComGetMaskedValue(sFullDate.substring(8, 12), "hm"));
    	usrDate = ymd + " " + hm;
	}
	
    return usrDate;
}

/**
 * 시간이 Null 일 경우 '00:00' 으로 변환하여 반환.
 * 
 * @param sTime
 * @return
 */
function FcmIsNullToTime(sTime){
	if(FcmIsNull(sTime)){
		sTime = "00:00";
	}
	return sTime;
}

/**
 * RD 프린트 시간을 생성한다.
 * @return
 */
function FcmRdPrintDate(){
	var months = new Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct" ,"Nov", "Dec");
	var year = ComLpad(ComGetNowInfo("yy"), 2, "0");
	var month = months[ComGetNowInfo("mm") - 1];
	var day = ComLpad(ComGetNowInfo("dd"), 2, "0");
	var hour = ComLpad(ComGetNowInfo("hh"), 2, "0");
	var minute = ComLpad(ComGetNowInfo("mi"), 2, "0");
	var this_time = day + "-" + month + "-" + year + " " + hour + ":" + minute;
	return this_time
}

/**
 * 주어진 ID값을 갖는 IBSHEET를 찾는다.
 * @param id
 * @return
 */
function findSheetObj(sheetObjects, id){
	var sheetObj = null;
	for(var i=0; i<sheetObjects.length; i++){
		if(id==sheetObjects[i].id){
			sheetObj = sheetObjects[i];
			break;
		}
	}
	return sheetObj;
}

 //spd - foc 계산 뿐만 아니라, x값을 4번째 인자로 넘겨서 y를 return한다.
function calcFoc(coef2, coef, cons, spd){
	if(coef2==""||coef==""||cons==""||spd==""){
		return "";
	}
	var nCoef2 = 0;
	var nCoef = 0;
	var nCons = 0;
	var nSpd = 0;
	
	if(coef2){
		nCoef2 = Number(coef2);
	}
	
	if(coef){
		nCoef = Number(coef);
	}
	
	if(cons){
		nCons = Number(cons);
	}
	
	if(spd){
		nSpd = Number(spd);
	}
		
	return (nCoef2 * Math.pow(nSpd, 2)) + (nCoef * nSpd) + nCons;
}

//근의 공식(extract the value)
function quadraticFormula(coef2, coef, cons, y){
	if(coef2==""||coef==""||cons==""||y==""){
		return "";
	}
	var nCoef2 = 0;
	var nCoef = 0;
	var nCons = 0;
	var nY = 0;
	
	if(coef2){
		nCoef2 = Number(coef2);
	}
	
	if(coef){
		nCoef = Number(coef);
	}
	
	if(cons){
		nCons = Number(cons);
	}
	
	if(y){
		nY = Number(y);
	}
	
	var discriminant = Math.pow(nCoef,2)-4*nCoef2*(nCons-nY);
	if(discriminant<0){
		ComShowMessage("Cannot Find Speed with Inputted Value.")
		return "";
	}
	
	var rtnValue1 = (-nCoef + Math.sqrt(discriminant))/(2*nCoef2); //2차계수가 +면 큰 해, -면 작은 해
	var rtnValue2 = (-nCoef - Math.sqrt(discriminant))/(2*nCoef2); //반대

	//2차계수가 +일때는 큰 해를 return하고, -일 때는 작은 해를 return한다. 즉 무조건 rtnValue1
//	if(nCoef2>0){
		return rtnValue1;
//	}else{
//		return rtnValue2;
//	}
}


function round(val, precision){
	if(!(val instanceof Number)){
		val = Number(val);
	}
	val = val * Math.pow(10, precision);
	val = Math.round(val);
	return val/Math.pow(10, precision);
}