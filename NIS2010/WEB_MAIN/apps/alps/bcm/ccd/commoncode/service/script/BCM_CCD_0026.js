/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
 *@FileName   : BCM_CCD_0026.js
 *@FileTitle  : Movement status
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/03
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
			   MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
			   THER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------From here the common JavaScript function is defined.     ------------------*/
/** Common global variable */
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
/** Event handler processing by button click event */
document.onclick=processButtonClick;
/** Event handler processing by button name */
function processButtonClick(){
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");

		switch(srcName) {
			case "btn_History":
	        	var tblNo = 'MDM_MVMT_STS';
	        	var mstKey = formObj.mvmt_sts_cd.value;
				if (mstKey == "") {
					ComShowCodeMessage("CCD00038", "Movement Status Code");
					return false;
				}
	        	comMdmCallPop(tblNo, mstKey);
	    		break;				
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
				break;
			case "btn_New":
				doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObjects[0],formObj,MULTI01);
				break;
			case "btn_Create": //Sequence generation
				doActionIBSheet(sheetObjects[0],formObj,IBCREATE);
				break;     
			case "btn_mvmt_sts_search":
				if(ComGetEvent().style.cursor == "default") return;
				var sUrl="/hanjin/COM_COM_0010.do?mvmt_sts_cd=" + formObj.mvmt_sts_cd.value +"&mdm_yn="+ formObj.mdm_yn.value+"&main_page=false";
				var rVal=ComOpenPopup(sUrl, 770, 440, "get_mvmtStsCd", "1,0,1", true);
				break;
	        case "btn_History":
	        	var tblNo = 'MDM_MVMT_STS';
	        	var mvmtStsCd = formObj.mvmt_sts_cd.value;
	        	var mstKey = nullToBlank(mvmtStsCd);
				if (mstKey == "") {
					ComShowCodeMessage("CCD00038", "Movement Status Code");
					return false;
				}
	        	comMdmCallPop(tblNo, mstKey);
	    		break;  
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj){	     
	comboObjects[comboCnt++]=combo_obj;  
} 

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
	}
	initControl();
	doActionIBCombo(sheetObjects[0],formObj,SEARCH01);
	doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
	// auth_tp_cd retrieve
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //sheet1 init
		with(sheetObj){
	        var HeadTitle="";
	        var prefix="sheet1_";
			initRowInfo(1, 1, 2, 100);
	        InitColumnInfo(1, 0, 0, false);
	        InitHeadRow(0, HeadTitle, true);
	        InitDataProperty(0, cnt++, dtHiddenStatus ,  30, daCenter, false, "ibflag");
	        Editable = false;
	        WaitImageVisible = false;
	        sheetObj.Visible = false;
		}
		break;
	}
}

/**
 * All the combo box query
 */
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
	switch (sAction) {
		case SEARCH01: // load page 
			var sXml=sheetObj.GetSearchXml("BCM_CCD_0026GS.do", "f_cmd=" + SEARCH01);
			var rtnValue=sXml.split("|$$|");
			for(var i=0; i<rtnValue.length; i++){
				var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
				var cdName=comboXml[0].split("|");
				var cdValue=comboXml[1].split("|");
				for (var j=0; j < cdName.length; j++) {
					if(cdName[j] == "IB") {
						cdName[j] = "Inbound";
					} else if(cdName[j] == "OB") {
						cdName[j] = "Outbound";
					}
					comboObjects[i].InsertItem(j, cdValue[j]+"|"+cdName[j], cdValue[j]);
				}
			}
			comboObjects[0].SetColWidth("20|80");
			break;
	}
}

// /handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	switch(sAction) {
		case SEARCH02:				//query
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH02;
				ComOpenWait(true);
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchXml("BCM_CCD_0026GS.do", sParam);
				var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				if(sav != "S" ){
					ComOpenWait(false);
					return;
				}
				if(ComIsBtnEnable("btn_Create")) {
					if(ComXmlString(sXml, "delt_flg") == null || ComXmlString(sXml, "delt_flg") == ""){
						ComOpenWait(false);
						// showing message when data not exists
						if (ComShowCodeConfirm("CCD00034", "Movement Status Code")) {
							formObj.ibflag.value="I";
							ComBtnDisable("btn_Create");
							ComBtnDisable("btn_Retrieve");
							ComBtnEnable("btn_Save");
							ComEnableObject(formObj.btn_mvmt_sts_search, false);
							formObj.mvmt_sts_nm.focus();
						} else {
							doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
						}
						return;
					}
					formObj.ibflag.value="U";
		
					formObj.mvmt_sts_nm.value = ComXmlString(sXml, "mvmt_sts_nm");
					formObj.dest_yd_flg.value = ComXmlString(sXml, "dest_yd_flg");
					formObj.io_bnd_cd.Code(ComXmlString(sXml, "io_bnd_cd"));
					formObj.delt_flg.valeu = ComXmlString(sXml, "delt_flg");
					formObj.cre_usr_id.value = ComXmlString(sXml, "cre_usr_id");
					formObj.cre_dt.value = ComXmlString(sXml, "cre_dt");
					formObj.upd_usr_id.value = ComXmlString(sXml, "upd_usr_id");
					formObj.upd_dt.value = ComXmlString(sXml, "upd_dt");
					ComBtnEnable("btn_Save");
					ComOpenWait(false);
					formObj.mvmt_sts_cd.readOnly=true;
				} else {
					if(ComXmlString(sXml, "delt_flg") == null || ComXmlString(sXml, "delt_flg") == ""){
						ComOpenWait(false);
					} else {
						ComOpenWait(false);
	            		ComShowCodeMessage("CCD00024");
	            		ComResetAll();
	            		return false;
					}
				}
			}
			break;
		case MULTI01:				//save
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=MULTI01;
				if(ComShowConfirm(ComGetMsg("COM130101", "Data"))){
					ComOpenWait(true);
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSaveXml("BCM_CCD_0026GS.do", sParam);
					var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if(sav == "S" ){					//Saved after a successful re-viewed
						ComShowCodeMessage("COM130102", "Data");
						ComBtnEnable("btn_Create");
						ComBtnEnable("btn_Retrieve");
						doActionIBSheet(sheetObj,formObj,SEARCH02);
					}else{
						ComShowCodeMessage("COM132103", "Data");
					}
					ComOpenWait(false);
				}
			}
			break;
		case IBCREATE:
			doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			formObj.ibflag.value="I";
			ComBtnDisable("btn_Create");
			ComBtnDisable("btn_Retrieve");
			ComBtnEnable("btn_Save");
			ComEnableObject(formObj.btn_mvmt_sts_search, false);
			break;
		case IBCLEAR:
			ComResetAll();
			formObj.mvmt_sts_cd.readOnly=false;			
			ComBtnEnable("btn_Create");
			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_Save");
			ComEnableObject(formObj.btn_mvmt_sts_search, true);
			break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case SEARCH02:
			if(formObj.mvmt_sts_cd.value == "" || formObj.mvmt_sts_cd.value == null){
				ComShowCodeMessage("CCD00001", "Movement Status Code");
				formObj.mvmt_sts_cd.focus();
				return false;
			}
			break;
		case MULTI01:
			if(formObj.mvmt_sts_cd.value == "" || formObj.mvmt_sts_cd.value == null){
				ComShowCodeMessage("CCD00001", "Movement Status Code");
				formObj.mvmt_sts_cd.focus();
				return false;
			}
			if(formObj.mvmt_sts_nm.value == "" || formObj.mvmt_sts_nm.value == null){
				ComShowCodeMessage("CCD00001", "Name");
				formObj.mvmt_sts_nm.focus();
				return false;
			}
			break;
	}
	return true;
}

function delt_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	if(comboObj.GetSelectCode()== "Y"){
		if(!ComShowCodeConfirm("COM130301", "data")) comboObj.SetSelectCode("N",false);
	}
}

function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('change', 'obj_change', form); 	
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', form);
}

/**
 * If the data field to be the CHANGE Event
 */
function obj_change(){
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "mvmt_sts_cd":
				if(formObj.mvmt_sts_cd.value.length>0){
					doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
				}
				break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function get_mvmtStsCd(rowArray) {
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	var colArray=rowArray[0];
	formObj.mvmt_sts_cd.value=colArray[2];
	if(formObj.mvmt_sts_cd.value != ""){
		doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
	}
}

