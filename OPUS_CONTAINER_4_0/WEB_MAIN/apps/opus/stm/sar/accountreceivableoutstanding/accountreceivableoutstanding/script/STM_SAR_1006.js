/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAR_1006.js
*@FileTitle  : Payment Request Letter by Customer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
var comboObjects=new Array();        
var comboCnt=0;
var gCurRow=0;
var prefix="sheet1_";
var otsTpXcld="";
/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
document.onclick=processButtonClick;
function processButtonClick() {  
	var sheetObject1=sheetObjects[0];
	var formObj=document.form;
	try {
		
		var srcName=ComGetEvent("name");		
		if (ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		    case "btn_close":
	        	ComClosePopup();
	            break;     
			case "btn_print":
				var formObj=document.form;
				var rdParam='/rp  ['+formObj.eml_seq.value+']';
		      	  rdParam +=     '['+formObj.ar_ofc_cd.value+']';
		      	  rdParam +=     '['+formObj.cust_code.value+']';
		      	  rdParam +=     '['+formObj.fax.value+']';
		      	  rdParam +=     '['+ComReplaceStr(formObj.email.value,";","☞")+']';    
		      	  rdParam +=     '[]';
		      	  rdParam +=     '[]';
		      	  rdParam +=     '['+formObj.cnsd_cust_flg.value+']';
		      	  
		        if (formObj.ots_smry_cd.value == "INV") {
		        	if(formObj.ar_ofc_cd.value == "SAOBB"){
			      		var strPath="apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1009.mrd";
			      	} else {
			      		var strPath="apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1007.mrd";     		
			      	}
		        } else {
		      	   if(formObj.ar_ofc_cd.value == "SAOBB"){
		      		   var strPath="apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1008.mrd";
		      	   } else {
		      		   var strPath="apps/opus/stm/sar/accountreceivableoutstanding/accountreceivableoutstanding/report/STM_SAR_1006.mrd";
		      	   }
		        }
	
		        formObj.com_mrdPath.value=strPath;
		        formObj.com_mrdArguments.value=rdParam; 
		        ComOpenRDPopupModal("width=1000px,height=650px,status=0,resizable=1"); 
	            break;
			case "btn_send":
				sendMail(sheetObj, formObj);
				break;    
			case "btn_pop_cust_cd":
				var cust_cnt_cd=formObj.rct_cust_cnt_cd.value;
				var cust_seq=formObj.rct_cust_seq.value;
				var classId="STM_SAR_9003";  
				var param='?cust_cnt_cd='+cust_cnt_cd+'&cust_seq='+cust_seq+'&pop_yn=Y&classId='+classId;
				ComOpenPopup('/opuscntr/STM_SAR_9003.do' + param, 900, 450, 'getSTM_SAR_9003', '0,0', false, false);
				break;	
			case "btn_pop_credit_cust":
				var formObject=document.form; 
				if(formObject.rct_cust_cnt_cd.value != "" && formObject.rct_cust_seq.value != "") {
					var param='?cust_cnt_cd='+formObject.rct_cust_cnt_cd.value+'&cust_seq='+formObject.rct_cust_seq.value+'&pop_yn=Y&ret_yn=Y';
					ComOpenPopup('/opuscntr/STM_SAR_9002.do' + param, 1300, 650, 'getPopData', '0,0', false, false, "", "", 0);
				}	
			} // end switch
	} catch (e) {
		/*
        자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
        물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
        */
		if (e == "[object Error]") {
			ComShowCodeMessage('SAP00001');
		} else {
			ComShowMessage(e.message); 
		}
	}
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
/**
 * Sheet 기본 설정 및 초기화 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    initControl(); 
}
/**
 * loading HTML Control event <br>
 * {@link #loadPage} function call this. so IBSheet Object is initialized. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence number in sheetObjects array
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
    //handling Axon event. event catch
//	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- handling code when OnBeforeDeactivate(blur) event
//	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);            //- handling code when OnBeforeActivate event in case of existing dataformat property
//  axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//  axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
//	axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- handling code when onkeypress event in case of existing dataformat property
//  axon_event.addListenerFormat('keyup'           , 'obj_keyup'   , formObj);
    axon_event.addListenerFormat('change'          , 'obj_onchange', formObj);
    axon_event.addListener('click', 'change_event_combo', 'send_type');
}
function obj_onchange(){
		var formObj=document.form;
		var sheetObject=sheetObjects[0];
		switch(ComGetEvent("name")){
			case "rct_cust_seq":
				if (formObj.rct_cust_cnt_cd.value != '' && formObj.rct_cust_seq.value != '') {
					var valueCustSeq=formObj.rct_cust_seq.value;
					formObj.rct_cust_seq.value=ComLpad(valueCustSeq,6,"0");
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC02);
				}
				break;
		}
}

function change_event_combo(){
	var formObject=document.form;
	if (formObject.send_type[1].selected == true){
		formObject.email.readOnly=false;
		formObject.email.style.backgroundColor="#FFFFFF";
		formObject.fax.readOnly=true;
		formObject.fax.style.backgroundColor="#E8E7EC";
	} else if (formObject.send_type[2].selected == true){
		formObject.email.readOnly=true;
		formObject.email.style.backgroundColor="#E8E7EC";
		formObject.fax.readOnly=false;
		formObject.fax.style.backgroundColor="#FFFFFF";
	} else {
		formObject.email.readOnly=false;
		formObject.email.style.backgroundColor="#FFFFFF";
		formObject.fax.readOnly=false;
		formObject.fax.style.backgroundColor="#FFFFFF";
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
   }
   break;
	}
}
// handling sheet process Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	if (!validateForm(sheetObj, formObj, sAction))
//		return;
	switch (sAction) {
		case IBSEARCH_ASYNC02:	//Search Customer Info
			formObj.f_cmd.value=SEARCH06;
			formObj.cust_cnt_cd.value=formObj.rct_cust_cnt_cd.value;
			formObj.cust_seq.value=formObj.rct_cust_seq.value;  
			var sXml=sheetObj.GetSearchData("SARCommonGS.do", FormQueryString(formObj));
			if(SarShowXmlMessage(sXml) != "") {
					ComShowMessage(SarShowXmlMessage(sXml));
					ComClearObject(formObj.rct_cust_cnt_cd);
					ComClearObject(formObj.rct_cust_seq);
					ComClearObject(formObj.cust_nm);
					formObj.rct_cust_cnt_cd.focus();
				}else{
				formObj.cust_nm.value=ComGetEtcData(sXml,"cust_nm");
				}
			break;
		/*case IBSEARCH: //retrieve
			formObj.f_cmd.value=SEARCH;			
			var sXml=sheetObj.GetSearchData("STM_SAR_1006GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			break;*/
		case COMMAND01:	// btn_mail_send
			formObj.f_cmd.value = COMMAND01;
			formObj.cust_cnt_cd.value=formObj.rct_cust_cnt_cd.value;
			formObj.cust_seq.value=formObj.rct_cust_seq.value;  
			var sXml  = sheetObj.GetSaveData("STM_SAR_1006GS.do", FormQueryString(formObj));	
			
			if(SarShowXmlMessage(sXml) != "") {
 				ComShowMessage(SarShowXmlMessage(sXml));
 				return; 
 			}else{
 				var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
 				formObj.state.value = state;
 				var sndNm = ComGetEtcData(sXml, "SEND_NUMBER");
 				if(sndNm != ""){
 					if(sndNm == "supy"){
 						ComShowMessage("Failed to send , check suppress payment letter option");
 					} else {
 						ComShowCodeMessage("SAR00053");
 					}
 					ComClosePopup(); 
 				} else {
 					ComShowCodeMessage('SAR00057');
 				}
 				return;
 			}
			break;		
	}
}
/**
 * handling process for input validation 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var formObject=document.form;
	var prefix="sheet1_";
    //var sail_arr_dt = formObject.sail_arr_dt.value;
	switch (sAction) {
		case IBSEARCH: //retrieve			
			if (formObj.ar_ofc_cd.value ==null || formObj.ar_ofc_cd.value ==""){
			    ComShowCodeMessage('COM130403','Office');
				ComSetFocus(formObj.ar_ofc_cd);
				return false;
			}	
			if (formObj.cust_cd.value ==null || formObj.cust_cd.value ==""){
				ComShowCodeMessage('COM130403','Customer');
				ComSetFocus(formObj.cust_cd);
				return false;
			}				
		break;
	default:
		break;
	}
	return true;
}

/** 
 * call method when select event on popup(FNS_INV_0086)<br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param  {array} rowArray   
 * @return none
 * @see #
 * @author Park sung yong
 * @version 2014.03.24
 */
function getSTM_SAR_9003(rowArray) {
	var colArray=rowArray[0];
	var formObj=document.form;
	formObj.rct_cust_cnt_cd.value=colArray[8];
	formObj.rct_cust_seq.value=ComLpad(colArray[9], 6, '0');
	formObj.cust_nm.value=colArray[4];
}

/**
 * Trnasmitting mail
 * 
 * @param sheetObj
 * @param formObj
 * @return
 */
function sendMail(sheetObj, formObj){
	var rdFile = "";
	if (formObj.ots_smry_cd.value == "INV") {
    	if(formObj.ar_ofc_cd.value == "SAOBB"){
    		rdFile="STM_SAR_1009.mrd";
      	} else {
      		rdFile="STM_SAR_1007.mrd";     		
      	}
    } else {
  	   if(formObj.ar_ofc_cd.value == "SAOBB"){
  		   rdFile="STM_SAR_1008.mrd";
  	   } else {
  		   rdFile="STM_SAR_1006.mrd";
  	   }
    }
	
	formObj.rd_name.value = rdFile;		
	doActionIBSheet(sheetObj, formObj, COMMAND01);	

}
