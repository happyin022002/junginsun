/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoVsk.js
*@FileTitle  : VSK 공통 자바스크립트
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/


if(msgs == undefined){
	msgs = new Array();
}
msgs["VSK00001"]="Same port which has already received actual schedule exists between inputed data and next calling ports. This position can't process additional calling.";
msgs['VSK00002']="Data ({?msg1}) is duplicated.";
msgs['VSK00003']="Date format is wrong. Please enter a valid date format.";
msgs['VSK00004']="Time format is wrong. Please enter a valid time format.";
msgs['VSK00005']="Do you want to delete ?";
msgs['VSK00006']="VVD has been inputted actual schedule. Please go to coastal simulation window.";
msgs["VSK00007"]="VVD made reference to Booking Data. \n Please go to coastal simulation window.";
msgs["VSK00008"]="If direction changes, port count should be over two.";
msgs["VSK00009"]="If direction is two types, turn port count should be over one.";
msgs['VSK00010']="There is no selected marking, Please check it again.";
msgs['VSK00011']="Unexpected system error took place during data processing. Please try again.({?msg1})";
msgs['VSK00012']="There is no updated data to save.";
msgs["VSK00013"]="End date is larger than vessel schedule start ETA.";
msgs["VSK00014"]='Do you want to change VVD as open status ?';
msgs["VSK00015"]="Please select a active status VVD!";
msgs["VSK00016"]="Please select a closed status VVD!";
msgs["VSK00017"]="If it input many kinds of vessel code, frequency (value) should be input as mandatory field.";
msgs["VSK00018"]="In case of EGSCA port, period should be set within three months.";
msgs["VSK00019"]="Only PAPCA is available";
msgs['VSK00020']="You didn't select any row, Please select a row.";
msgs['VSK00021']="({?msg1}) doesn't exist.";
msgs['VSK00022']='More than {?msg1} letters are required in at least one of ({?msg2}) fields.'
msgs["VSK00023"]="Same port which has already received actual schedule exists between inputed data and next calling ports. This position can't process reverse calling.";
msgs["VSK00024"]="This position can't process reverse calling.";
msgs['VSK00025']='({?msg1}) must be later than ({?msg2}).';
msgs['VSK00026']='Port ({?msg1}) has been already inputted Actual SKD. Please try again.';
msgs['VSK00027']='({?msg1}) Mandatory field is missing. Please try again.';
msgs['VSK00028']="VVD({?msg1}) doesn't exist.";
msgs['VSK00029']="Port({?msg1}) doesn't exist.";
msgs['VSK00030']='Mandatory Items are missing. You should select one among E, W, S, N.';
msgs['VSK00031']='VVD({?msg1}) is duplicated.';
msgs['VSK00032']='Port ({?msg1}) - Please input the correct ETA, ETB, ETD.';
msgs['VSK00033']='Port ({?msg1}) - Mandatory field is missing. Please try again.';
msgs['VSK00034']='Port ({?msg1}) - Turning Port information on this port are mismatched. Please check again.';
msgs['VSK00035']="Selected ports must be included the first or last port. Please select port again."; 
msgs['VSK00036']='There is no content to simulate.';
msgs['VSK00037']="Only consecutive ports are available. Please select port again.";
msgs['VSK00038']='Do you want to overwrite this data ?';
msgs['VSK00039']='Please input a feeder code.';
msgs['VSK00040']='This lane has been already selected in R/Lane.';
msgs['VSK00041']="Please input either '0' or '1'.";
msgs["VSK00042"]="{?msg1} have no ability to execute.";
msgs['VSK00043']='There is no data to search.';
msgs['VSK00045']='Please remark within 500 bytes.';
msgs['VSK00047']='Date format is wrong. Please enter a valid date format(YYYY-MM-DD HH:MM).';
msgs['VSK00048']="({?msg1}) ETB cannot be larger than ETD.";
msgs['VSK00049']='({?msg1}) Day is invalid.';
msgs['VSK00050']='({?msg1}) ETB (-1 Hour) of current port must be larger than ETD of previous port.';
msgs['VSK00051']="Only Lane code of Trunk is allowed.";
msgs['VSK00052']="Unable to input Same VVD on turn port information colume.";
msgs['VSK00053']="Only vessel code of trunk is allowed.";
msgs['VSK00054']="This proforma type is using in vessel schedule.\n Please check it and try again.";
msgs['VSK00055']="ETA ({?msg1}) is earlier than ETD of previous VVD.";
msgs['VSK00056']="ETB ({?msg1}) is earlier than ETA ({?msg2}).";
msgs['VSK00057']="ETD ({?msg1}) is earlier than ETB ({?msg2}).";
msgs['VSK00058']="ETD ({?msg1}) is earlier than ETA ({?msg2}).";
msgs['VSK00059']="Please input port code.";
msgs['VSK00060']="This port is not the added calling port."
msgs['VSK00061']="Please select VVD for deletion.";
msgs['VSK00062']="Do you want to delete VVD ({?msg1})?";
msgs['VSK00063']="This port schedule is not phase out schedule.";
msgs['VSK00064']="Unable to find the updated data.";
msgs["VSK00065"]="Service provider code ({?msg1}) doesn't exist.";
msgs["VSK00066"]="Please input a delay reason.";
msgs["VSK00067"]="Lane code is missing !";
msgs["VSK00068"]="One year(Jan.~Dec.) in term of reference is not.";
msgs["VSK00069"]="Please input from date or to date.";
msgs["VSK00070"]="Please input previous port code.";	
msgs["VSK00071"]="Please input next port code.";	
msgs["VSK00072"]="Direction ({?msg2}) doesn't exist on service lane ({?msg1}).";
msgs["VSK00073"]="It was exceeded the scope of the time to input.";
msgs["VSK00074"]="Actual schedule is missing, please check it again.";
msgs["VSK00075"]="Delay reason code must have delay hour where is bigger than '0'.";
msgs["VSK00076"]="If any delay hour, Please be sure to input delay reason.";
msgs["VSK00077"]="Vessel count must be smaller than {?msg1}.";
msgs["VSK00078"]="The selected data is not able to use.";
msgs["VSK00079"]="It is not 'Phase In' schedule.";
msgs["VSK00080"]="Please choose the target schedule.";
msgs["VSK00081"]="Because actual schedule was already inputted, This position can't input additional calling.";
msgs['VSK00082']="Voyage number ({?msg1}) doesn't exist.";
msgs["VSK00083"]="This proforma schedule is using in vessel schedule.";
msgs["VSK00084"]="First port/terminal code should be same last port/terminal code.";
msgs["VSK00085"]="This vessel code was already entered. Please input other vessel code.";
msgs["VSK00086"]="The added port can't be dealt with skip.";
msgs["VSK00087"]='Do you want to change VVD as holding status ?';
msgs["VSK00088"]='Do you want to delete VVD ?';
msgs["VSK00089"]="Do you want to create a new simulation No. ?";
msgs["VSK00090"]="Do you want to send your information ?";
msgs["VSK00091"]="The inputted proforma schedule has been already used at vessel schedule.";
msgs["VSK00092"]="The inputted proforma schedule already exist.";
msgs["VSK00093"]="End date should be always bigger than sysdate.\nPlease check a end date!";
msgs["VSK00094"]="Total duration should be always bigger than difference of (Last port ETB - First port ETB).";
msgs["VSK00095"]="Total duration and difference(Last port ETB - First port ETB) should be same.";
msgs["VSK00096"]="Please check data ({?msg1}) of proforma schedule.";
msgs["VSK00097"]="Between ({?msg1}) of Head and ({?msg1}) on Excel file is mismatched.";
msgs["VSK00098"]='({?msg1}) row(s), VVD({?msg2}) - Please input the correct ETA, ETB, ETD.';
msgs["VSK00099"]='Vessel class ({?msg1}) is duplicated.\nPlease check again.';
msgs["VSK00100"]="This Vessel Schedule was already Closed. Please contact a vessel operator.";
msgs["VSK00101"]="Start voyage can't use number(0000). Please input over (0000).";
msgs["VSK00102"]="Please input positive number.";
msgs["VSK00103"]="Do you want to change VVD as closing status ?";
msgs["VSK00104"]="If direction is two types, port count should be over two.";
msgs["VSK00105"]="Please check period. The maximum period is {?msg1}.";
msgs["VSK00106"]="Please input Service provider code.";
msgs['VSK01017']='({?msg1}) field is missing. Please check again!';
msgs['VSK01018']='Data ({?msg1}) format is wrong. Please check it again!';
msgs['VSK01019']='Data ({?msg1}) lengths were exceeded. Please check it again!';
msgs['VSK01020']='Do you want to send EDI?';
// VOSI이전관련 OPF UI메시지 변환
msgs['VSK50004']='Do you want to cancel ?';
msgs['VSK50008']='Please input port code !';
msgs['VSK50009']='({?msg1})\n\nThere is changed data. Do you want to save ?';	
msgs['VSK50010']='({?msg1}) Record ({?msg2})is mandatory item.';
msgs['VSK50011']='There is no relevant data.';
msgs['VSK50012']='There is changed data. Do you want to process ?';
msgs['VSK50013']='Please input vessel code !';
msgs['VSK50014']='Port Code should be 5 letters length.';
msgs['VSK50015']="Port Code doesn't exist.";	
msgs['VSK50016']='This code was already creatd.';
msgs['VSK50018']='Terminal Code should be 7 letters length.';
msgs['VSK50020']="Terminal Code doesn't exist.";	
msgs['VSK50022']='Vessel Code should be 4 letters length.';
msgs['VSK50023']="Vessel Code doesn't exist.";
msgs['VSK50024']='Total value must be 100%.';
msgs['VSK50025']='Port Code should be 5 letters length.';
msgs['VSK50026']="Port Code doesn't exist.";
msgs['VSK50027']='Lane Code should be 3 letters length.';
msgs['VSK50028']="Lane Code doesn't exist.";
msgs['VSK50029']='Carrier Code should be 3 letters length.';
msgs['VSK50030']="Carrier Code doesn't exist.";
msgs['VSK50031']='Please enter a valid date format for(Date) : ({?msg1})';
msgs['VSK50303']='The data is duplicated ! ({?msg1})/ ({?msg2}) rows.';
msgs['VSK50304']='The date is duplicated.';
msgs['VSK57015']="\'({?msg1})\' should be above or equal to \'({?msg2})\'.";
msgs['VSK57100']="Turing Port VVD must be different with Selected VVD";
msgs['VSK57101']='({?msg1}) must be earlier than ({?msg2}).';
//NYK 추가 MSG
msgs['VSK55001'] = 'Actual {?msg1} date/time is(are) in the future.';
msgs['VSK55002'] = 'Actual Arrival date/time is earlier than Previous Port Departure date/time : ({?msg1}).';
msgs['VSK55003'] = "There is more than 10 hours difference between Actual {?msg1} date/time and Estimate {?msg1} date/time. Please input 'Delay Reason'.";
msgs['VSK55004'] = 'There is more than 10 hours difference between Actual {?msg1} date/time and Estimate {?msg1} date/time. Please check.';
msgs['VSK55005'] = 'Seleted VVD is {?msg1}. Do you want to apply?';
msgs['VSK55006'] = 'Cannot phase out because of the following actual schedule.\nIn order to phase out, must delete actual schedule first.\n{?msg1}';
msgs['VSK55007'] = "You can't use this function since Proforma schedule doesn't exist. Please use manual creation function instead.";
msgs['VSK55008'] = "Select limited to {?msg1} Row.";
msgs['VSK55009'] = "P/F SKD Type must be less than 4 type";
msgs['VSK55010'] = "  {?msg1} must be earlier than Next Port ETA";
msgs['VSK55011'] = "It cannot be turning port because [{?msg1}] is virtual add calling port";
msgs['VSK55012'] = "Cannot input own vessel operator.";

//VSK COMMON PROPERTY
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

/**
 * 자동포커스 처리
 * 
 * 사용예 : axon_event.addListener ('keyup', "VskKeyFocus", 'form');
 */
function VskKeyFocus() {
	try {
		var keyValue= ComGetEvent("keycode"); 
		var iMaxLen= ComGetEvent("maxLength");
        var sValue= ComGetEvent("value");
        var bFocusProcess=false;
        //iMaxLen 속성이 없거나 Value 속성이 없는것들은 처리하지 않는다.
        if(iMaxLen!=null && sValue!=null) {
        	if(iMaxLen==sValue.lengthByte()){
                if (!((keyValue>=8   && keyValue<=40)  ||  //BackSpace~아래방향키키
                      (keyValue>=45  && keyValue<=46)  ||  //Insert,Delete키
                      (keyValue>=91  && keyValue<=93)  ||  //기능키
                      (keyValue>=112 && keyValue<=123) ||  //F1~F12키
                      (keyValue>=144 && keyValue<=145) )) {//NumLock,ScrollLock
		            bFocusProcess=true;
                }
            } 
        }
        //포커스를 다음 컨트롤로 옮기는 처리를 해야 하는 경우
        if (bFocusProcess)  ComSetNextFocus();
	} catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * 엔터키 처리
 * 
 *  버튼객체에서 엔터키를 누르면 버튼에 연결된 onclick 이벤트가 발생.
 *  버튼이 아닌 객체에서 엔터키를 누르면 id가 'objname'인 객체의 onclick 이벤트를 발생.
 *  objname이 null인 경우는 btn_Retrieve 객체를 대상으로 함.
 */
function VskKeyEnter(objname) {
	try{
		var btnObj=false;
		var prefix='';
		var keyValue= ComGetEvent("keycode"); 
    	if(keyValue != 13) return;
    	var obj=ComGetEvent();
    	var buttonObj=null;
    	var name=obj.name;
    	if(name!=null && name.length>4){
    		prefix=name.substring(0, 4);
    		if(prefix == 'btn_' || prefix == 'btns'){
    			btnObj=true;
    			buttonObj=obj;
    		}
    	}
    	if(buttonObj){
    		buttonObj.click();;
    	}else{
    		if (objname==undefined || objname==null || objname.constructor!=String || objname.trim() == ""){
    			objname="btn_Retrieve";
    		}
    		obj=document.getElementById(objname);
    		if(obj) obj.click(); //obj.fireEvent("onclick");
    	}
    	if(keyValue == 13){
    		event.keyCode=9;
    	}
	} catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * XML 에서 루트 노드를 구한다.
 */
function VskGetXmlRootNode(xmlStr) {
	if(xmlStr == null  || xmlStr == "") return;
	try{
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		
        return xmlRoot;
	} catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * XML 에서 이름으로 특정 노드 리스트를 구한다.
 */
function VskGetXmlNode(xmlStr, nodeName) {
	if(xmlStr == null  || xmlStr == "" || nodeName == null || nodeName == "") return;
	try{
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		
        var nodeList=xmlRoot.getElementsByTagName(nodeName);
        return nodeList;
	} catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * XML 에서 주어진 노드명의 CDATA Node 값을 구한다.
 */
function VskGetXmlNodeValue(xmlStr, nodeName) {
	if(xmlStr == null  || xmlStr == "" || nodeName == null || nodeName == "") return "";
	try{
		var nodeList=VskGetXmlNode(xmlStr, nodeName);
		if(nodeList == null || nodeList.length == 0) return "";
		var node=nodeList.item(0);
        if(node == null) return "";
        var childNodes=node.childNodes;
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
function VskGetXmlSelectSingleNodeText(xmlStr, nodeName) {
	if(xmlStr == null  || xmlStr == "" || nodeName == null || nodeName == "") return "";
	try{
		var xmlRoot=VskGetXmlRootNode(xmlStr);
//		var dataNode=xmlRoot.selectSingleNode("//"+nodeName);
		xmlDoc = $.parseXML(xmlRoot);
		$xml = $(xmlDoc);
		var dataNode = $xml.find(nodeName).text(); 
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
function VskGetErrorXml(xmlStr) {
	if(xmlStr == null  || xmlStr == "") return false;
	try{
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		
        if(xmlRoot.nodeName == "ERROR"){
        	return true;
        }
        return false;
	} catch(err) { ComFuncErrMsg(err.message); }
}
function setToday( obj, format )
{
  var today=new Date();
  var year=today.getFullYear();
  var month=today.getMonth()+1;
  if( (''+month).charAt(1) == '' ) month='0' + month;
  var date=today.getDate();
  if( (''+date).charAt(1) == '' ) date='0' + date;
  var hour=today.getHours();
  if( (''+hour).charAt(1) == '' ) hour='0' + hour;
  var minute=today.getMinutes();
  if( (''+minute).charAt(1) == '' ) minute='0' + minute;
  var sec=today.getSeconds();
  if( (''+sec).charAt(1) == '' ) sec='0' + sec;
  var theDay=year
  switch(format){
	  case "y" : 
		  theDay;
		  break;
	  case "ym" : 
		  theDay += '-' + month;
		  break;
	  case "ymd" :
		  theDay += '-' + month + '-' + date;
		  break;
	  default :
		  theDay += '-' + month + '-' + date;
	  	  break;
  }
  obj.value=theDay;
  return;  
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
function ComVskXml2ComboItem(xmlStr, cmbObj, codeCol, textCol) {
	if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}
	try {
		cmbObj.RemoveAll();
		var xmlDoc = ComGetXmlDoc(xmlStr);
		if (xmlDoc == null) return;
		var xmlRoot = xmlDoc.documentElement;
		
		if (xmlRoot == null) {
			return;
		}
		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var colListIdx=Array();
		var arrText=textCol.split("|");
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
			for (var j=0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j+1]=i;
				}
			}
		}
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			var item="";
			for (var j=1; j < colListIdx.length; j++) {
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
function VskEnableObjectControl(obj, bEnable, bCondi)
{
    try {
    	//disabled나 readOnly 설정하기
        switch( obj.type ) {
            case "password" :
            case "text" :
            	obj.readOnly=!bEnable;
                break;
            default:
                obj.disabled=!bEnable;
        }
		//설정에 따라 css 처리하기
        switch( obj.type ) {
            case "select-one" :
            case "text" :
                if (bEnable){
                	if (bCondi){
                		obj.className="input1";    //Sky-Blue 바탕
                	} else {
                		obj.className="input";    //흰색바탕
                	}
                } else {
                	if (bCondi){
                		obj.className="input1";    //Sky-Blue 바탕
                	} else {
                		obj.className="input2";   //회색바탕
                	}
                }
                break;
            case "textarea":
                if (bEnable){
                	obj.className="textarea";
                } else {
                	obj.className="textarea2";
                }
                break;
			default :
                if (obj.tagName=="IMG") {
                    if (bEnable){
                        obj.style.cursor="hand";
                        obj.style.filter="";
                    } else {
                        obj.style.cursor="default";
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
function VskKeyOnlyNumber(obj, sSubChar){
    try {
        var keyValue=ComGetEvent("keycode"); 
        if(keyValue >= 48 && keyValue <= 57) {//숫자
        	// Caption에 정의 된 소숫점 자리수까지만 입력되도록 막음(1자리 더 입력 가능하게).
        	if(obj.value.indexOf(".") >= 0){
        		var oLen=obj.value.length;
        		var dPos=obj.value.indexOf(".");
        		var oCapLen=obj.caption.length;
        		var dCapPos=obj.caption.indexOf(".");
        		if(dCapPos > -1){
	        		if((oLen - dPos) > (oCapLen - dCapPos)){
	        			event.returnValue=false;
	        			return;
	        		}
        		}else{
        			event.returnValue=false;
        			return;
        		}
        	}
            event.returnValue=true;
        } else if(sSubChar != undefined && sSubChar != null && sSubChar.constructor==String && sSubChar.length > 0) {
        	//"."는 한번만 수용가능
        	if(keyValue == ".".charCodeAt()){
        		if(obj.value.indexOf(".") >= 0){
        			event.returnValue=false;
        			return;
        		}
        	}
        	//SubChar가 여러개 설정된 경우 여러개 글자 모두 처리한다.
        	for(var i=0; i<sSubChar.length; i++) {
        		if (keyValue == sSubChar.charCodeAt(i)) {
	                event.returnValue=true;
	                return;
        		}
        	}
            event.returnValue=false;
        } else {
            event.returnValue=false;
        }
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * 사용자가 Caption 에 정의한 소숫점까지만 입력되도록 막음.
 * @param obj
 * @return
 * @author jinwoo
 */
function VskKeyNumberPointVaild(obj){
	var objValue=obj.value;
	var objCaption=obj.caption;
	var rtnVal=objValue;
	var oLen=objValue.length;
	var dPos=objValue.indexOf(".");
	var oCapLen=objCaption.length;
	var dCapPos=objCaption.indexOf(".");
	var pointLvl=oCapLen - dCapPos;
	if(dPos > -1){
		// 소수점이 있는 경우.
		if(oLen - dPos == 1){
//			rtnVal = objValue.substring(0, dPos);
		}else{
			var iVal=objValue.substring(0, dPos);
			var fVal=objValue.substring(dPos, oLen);
			if(fVal.length >= pointLvl){
				fVal=fVal.substring(0, pointLvl);
			}
			rtnVal=iVal + fVal;
		}
	}
	// (2010.04.30 임창빈)Caption 지정값보다 입력값에 작게 입력되도록 확인.
	var iCapLen=objCaption.substring(dCapPos + 1, oCapLen).length;	// Caption 소수점 이하 자리수 반환
	var iObjValue=objValue.substring(dPos + 1, oLen).length;			// 입력값 소수점 이하 자리수 반환
	var repObjCaption=objCaption.replace("," , "");
	var repObjValue=objValue.replace("," , "");
	if(dPos > -1){
		// 소수점이 있는 경우.
		var bVal=objValue.substring(dPos + 1, oLen);
		if (bVal.length <= 0){
			// 아직 소수점 이하에 값이 없고, 소수점이 입력된 경우 소수점을 무시한다.
			repObjValue=objValue.replace("." , "");
		}
	}
	var fRepObjCaption=parseFloat(repObjCaption);
	var fRepObjValue=parseFloat(repObjValue);
	var i=0;
	if (fRepObjCaption < fRepObjValue) {
		// 입력값이 Caption 값 보다 값이  클경우 초기 설정값을 반환한다.
		rtnVal="0";
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
	obj.value=rtnVal;
}
/**
 * Null 이면 true 반환, Not Null 이면 false 반환.
 * 
 * @param value
 * @return
 */
function VskIsNull(value){
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
function VskIsNotNull(value){
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
function VskIsNullZero(value){
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
function VskIsNotNullZero(value){
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
function VskCheckPeriod(fmDtObj, toDtObj, periodType){
	var fmDt=ComReplaceStr(fmDtObj.value, "-", "");
	var toDt=ComReplaceStr(toDtObj.value, "-", "");
	var tmpDt=ComGetDateAdd(fmDt, periodType, 1);
	if(ComChkPeriod(toDt, tmpDt) == 1){
		return true;
	}else{
		return false;
	}
}
/**
 * ETA, ETB, ETD 정합성(날짜 포맷) 체크
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function VskIsDateValid(sheetObj, Row, Col){
	var prefix=sheetObj.id + "_";
	var colName=sheetObj.ColSaveName(Col);
	var errMsg="";
	if(colName == prefix+"vps_eta_dt"){
		//ETA 에러 메세지
		errMsg="(ETA-"+sheetObj.GetCellValue(Row, Col)+")";
	}else if(colName == prefix+"vps_etb_dt"){
		//ETB 에러 메세지
		errMsg="(ETB-"+sheetObj.GetCellValue(Row, Col)+")";
	}else if(colName == prefix+"vps_etd_dt"){
		//ETD 에러 메세지
		errMsg="(ETD-"+sheetObj.GetCellValue(Row, Col)+")";
	}else if(colName == prefix+"free_tm_dt"){
		//ETD 에러 메세지
		errMsg="(Free Time-"+sheetObj.GetCellValue(Row, Col)+")";
	}
	//ETA, ETB, ETD 날짜 포맷 검사.
	if(sheetObj.GetCellValue(Row, Col).length < 12){
		ComShowCodeMessage("VSK01018", errMsg);
		sheetObj.SelectCell(Row, Col);
		return false;
	}else{
		if(!ComIsDate(sheetObj.GetCellValue(Row, Col).substring(0,8))){
			ComShowCodeMessage("VSK01018", errMsg);
			sheetObj.SelectCell(Row, Col);
			return false
		}
		if(!ComIsTime(sheetObj.GetCellValue(Row, Col).substring(8,12), "hm")){
			ComShowCodeMessage("VSK01018", errMsg);
			sheetObj.SelectCell(Row, Col);
			return false
		}
	}
	return true;
}
/**
 * 화면상(Form)에 보여줄 Date 형으로 변환하여 반환.
 * 
 * @param sFullDate
 * @return
 */
function VskReplaceUserDate(sFullDate){
	var usrDate="";
	if(VskIsNotNull(sFullDate)){
		var ymd=ComGetMaskedValue(sFullDate.substring(0, 8), "ymd");
    	var hm=VskIsNullToTime(ComGetMaskedValue(sFullDate.substring(8, 12), "hm"));
    	usrDate=ymd + " " + hm;
	}
    return usrDate;
}
/**
 * 시간이 Null 일 경우 '00:00' 으로 변환하여 반환.
 * 
 * @param sTime
 * @return
 */
function VskIsNullToTime(sTime){
	if(VskIsNull(sTime)){
		sTime="00:00";
	}
	return sTime;
}
/**
 * RD 프린트 시간을 생성한다.
 * @return
 */
function VskRdPrintDate(){
	var months=new Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct" ,"Nov", "Dec");
	var year=ComLpad(ComGetNowInfo("yy"), 2, "0");
	var month=months[ComGetNowInfo("mm") - 1];
	var day=ComLpad(ComGetNowInfo("dd"), 2, "0");
	var hour=ComLpad(ComGetNowInfo("hh"), 2, "0");
	var minute=ComLpad(ComGetNowInfo("mi"), 2, "0");
	var this_time=day + "-" + month + "-" + year + " " + hour + ":" + minute;
	return this_time
}

/**
 * Calculating base time + some minutes
 * 
 * @param sBaseTime
 * @param mins
 * @param isRound
 * @return yyyyMMddHHmm
 */
function VskGetAddedTimeByMin(sBaseTime, mins, isRound){
	var ttime = sBaseTime.replace(/\/|\-|\.|\:|\ /g,"");  
	var oBaseTime=getDateObj(ttime);
	var targetTime=new Date(ttime.substr(0,4), Number(ttime.substr(4,2))-1, ttime.substr(6,2),ttime.substr(8,2), eval(Number(ttime.substr(10,2)) + mins), ttime.substr(12,2));
	
	if(!isRound){
		return targetTime.getFullYear()
			+ ComLpad(targetTime.getMonth()+1, 2, "0")
			+ ComLpad(targetTime.getDate(), 2, "0")
			+ ComLpad(targetTime.getHours(), 2, "0")
			+ ComLpad(targetTime.getMinutes(), 2, "0");
	}else{
		mins=targetTime.getMinutes();
		var result="";
		if(mins>30){
			result=targetTime.getFullYear()
					+ ComLpad(targetTime.getMonth()+1, 2, "0")
					+ ComLpad(targetTime.getDate(), 2, "0")
					+ ComLpad(targetTime.getHours()+1, 2, "0")
					+ ComLpad(0, 2, "0");
		} else if(mins<30){
			result=targetTime.getFullYear()
					+ ComLpad(targetTime.getMonth()+1, 2, "0")
					+ ComLpad(targetTime.getDate(), 2, "0")
					+ ComLpad(targetTime.getHours(), 2, "0")
					+ ComLpad(0, 2, "0");
		} else {
			result=targetTime.getFullYear()
			+ ComLpad(targetTime.getMonth()+1, 2, "0")
			+ ComLpad(targetTime.getDate(), 2, "0")
			+ ComLpad(targetTime.getHours(), 2, "0")
			+ "30";
		}
		return result;
	}
}