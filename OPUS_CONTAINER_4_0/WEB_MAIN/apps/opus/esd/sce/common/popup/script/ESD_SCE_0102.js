/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0102.jsp
*@FileTitle  : Send Mail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var selCol=0;
var selOfc="";
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //조회
			// 
			formObj.f_cmd.value=SEARCH10;
			//
 		 	var sXml=sheetObj.GetSearchData("ESD_SCE_0102GS.do", SceFrmQryString(formObj));
		 	formObj.send_eml2.value=GetEtcData(sXml, "send_eml2");
			formObj.contents1.value=GetEtcData(sXml, "contents1");
			formObj.contents2.value=GetEtcData(sXml, "contents1");
			break;
	   case IBDOWNEXCEL:        
 		  sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		  break;
	}
}
   /**
    * registering IBSheet Object as list
    * ComSheetObject(id) from Call
    * adding process for list in case of needing batch processing with other items
    * defining list on the top of source
    */
   function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
   }
/* Event handler processing by button click event */
   document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var sheetNum=0;
	var formObject=document.form;
//	try{
		var srcName=ComGetEvent("name");
		if( formObject.selection[0].checked) {
			sheetObject=sheetObjects[0];
			sheetObj=sheetObjects[0];
			sheetNum=0;
		} else {
			sheetObject=sheetObjects[1];
			sheetObj=sheetObjects[1];
			sheetNum=1;
		}
		switch(srcName) {
			case "selection":
				if( formObject.selection[0].checked) {
					document.getElementById("location").style.display="";
					document.getElementById("node").style.display="none";
				} else if( formObject.selection[1].checked) {
					document.getElementById("node").style.display="";
					document.getElementById("location").style.display="none";
				}
				break;			
			case "btn_send" :
				if( validateForm(formObject,sheetNum)) {
					if( !ComShowConfirm( "Do you really want to send Email ?")) {
						return false;
					}
						if( sheetNum == 0) {
							formObject.send_eml3.value=formObject.send_eml1.value;
							formObject.subject.value=formObject.subject1.value;
							formObject.contents.value=formObject.contents1.value;
							formObject.attachnm.value=formObject.attachNm1.value;	
							formObject.f_cmd.value=MODIFY01 ;
						 	formObject.action="ESD_SCE_0102.do" ;
	    	           	 	formObject.submit() ;													
						} else if ( sheetNum == 1) {
							formObject.send_eml3.value=formObject.send_eml2.value;
							formObject.subject.value=formObject.subject2.value;
							formObject.contents.value=formObject.contents2.value;
							formObject.attachnm.value=formObject.attachNm2.value;	
							//alert(formObject.attachNm.value);
							formObject.f_cmd.value=MODIFY01 ;
							//sheetObj.DoSearch4Post("ESD_SCE_0102.do", SceFrmQryString(formObject));
	    	            	formObject.action="ESD_SCE_0102.do" ;
	    	           	 	formObject.submit() ;															
						}
				}
				break;
			case "btn_close" :
				ComClosePopup(); 
				break;
//			case "btn_search" :
//				window.showModelessDialog('COM_ENS_091.do?usr_nm='+formObj.disname.value, window, "scroll:no;status:no;help:no;dialogWidth:620px;dialogHeight:450px");
//				break;
//			case "btn_attach" :
//				break;
		}
/*	
	}catch(e){
		if( e == "[object Error]") {
			ComShowMessage(getMsg('COM12111')) ;
		} else {
			ComShowMessage(e.message);
		}
*/
}
/**
 * SStaaf common functions that are called from the pop-up
 *
 * @param rowArray result
 */
function setValFromStaffArray_new(collArray, gubun, i){
//	var idlist  = document.getElementById("send_id");
//	var namelist  = document.getElementById("send_nm");
	var emllist=document.getElementById("send_eml");
//	var uid = collArray[4];
	var uname=collArray[5];
	var eml=collArray[6];
	if( eml.length > 1 && check_duplicate(eml, emllist.value)) {
//안쓴답니다 .
//		idlist.value = idlist.value+uid+";";
//		namelist.value = namelist.value+uname+";";
		emllist.value=emllist.value+eml+";";
	} else if (eml.length <= 0) {
		alert( "USER '" + uname + "' Have no Email Address ");
	}
 }
function check_duplicate( umail, list) {
	var token=list.split(";");
	for( var i=0; i < token.length; i++) {
		if (umail == token[i]) {
			return false;
		}
	}
	return true;
}
/**
 * handling process for input validation
 */
function validateForm(formObject,sheetNum){
	if( sheetNum == 0) {
		if( ComIsEmpty( formObject.send_eml1)) {
			alert( "Please Insert Email Address");
			return false;
		}
		if ( ComIsEmpty( formObject.subject1)) {
			alert( "Please Insert Email Subject");
			return false;
		}
		if ( ComIsEmpty( formObject.contents1)) {
			alert( "Please Insert Email Contents");
			return false;
		}
		if( ComIsEmpty ( formObject.attachNm1)) {
			alert( "Please Insert Email Contents");
			return false;
		}
		if( formObject.send_eml.value.match("[',', '|']") != null) {
			alert( "Please divide ';' character between email address ");
			return false;
		}
		return true;		
	} else if ( sheetNum == 1) {
		if( ComIsEmpty( formObject.send_eml2)) {
			alert( "Please Insert Email Address22");
			return false;
		}
		if ( ComIsEmpty( formObject.subject2)) {
			alert( "Please Insert Email Subject");
			return false;
		}
		if ( ComIsEmpty( formObject.contents2)) {
			alert( "Please Insert Email Contents");
			return false;
		}
		if( ComIsEmpty ( formObject.attachNm2)) {
			alert( "Please Insert Email Contents");
			return false;
		}
		if( formObject.send_eml.value.match("[',', '|']") != null) {
			alert( "Please divide ';' character between email address ");
			return false;
		}
		return true;		
	}
}
