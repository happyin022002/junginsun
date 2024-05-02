/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0025.js
*@FileTitle  : activity
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    		   MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     		   OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class BCM_CCD_0025 : BCM_CCD_0025 on the screen for creating the script defines the task using.
     */
function BCM_CCD_0025() {
	this.processButtonClick=tprocessButtonClick;
    this.setSheetObject=setSheetObject;
    this.loadPage=loadPage;
    this.initSheet=initSheet;
    this.initControl=initControl;
    this.doActionIBSheet=doActionIBSheet;
    this.setTabObject=setTabObject;
    this.validateForm=validateForm;
}

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
	        	var tblNo = 'MDM_ACTIVITY';
	        	var mstKey = formObj.act_cd.value;
				if (mstKey == "") {
					ComShowCodeMessage("CCD00038", "Activity Code");
					return false;
				}
	        	comMdmCallPop(tblNo, mstKey);
        		break;					
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
				break;
            case "btn_New":
            	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
            	break;
            case "btn_Save":
            	doActionIBSheet(sheetObjects[0], formObj, MULTI01);
            	break;
            case "btn_Create":
            	doActionIBSheet(sheetObjects[0], formObj, IBCREATE);
            	break;
			case "btns_search1":
				if(ComGetEvent().style.cursor == "default") return;
			   	var formObj=document.form;
  			   	var sUrl="/hanjin/COM_COM_0009.do?mdm_yn="+formObj.mdm_yn.value+"&act_cd="+formObj.act_cd.value;			    
				ComOpenPopup(sUrl, 660, 440, 'getAct_Cd', "1,0,1,1,1", true);
				break;
        }
	} catch(e) {
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
	
	for(var k=0;k<comboObjects.length;k++) {
		initCombo(comboObjects[k]);
	}
	
	initControl();
	doActionIBCombo(sheetObjects[0], formObj, SEARCH01);
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	// auth_tp_cd retrieve
//	doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
//	if(G_MDAA_CHK == 'Y') {
		//ComEnableObject(formObj.delt_flg, true);
		formObj.delt_flg.enable=true;
		ComSetDisplay('btn_save',1);
//	} else {
		//ComEnableObject(formObj.delt_flg, false);
//		formObj.delt_flg.enable=false;
//		ComSetDisplay('btn_save',0);
//	}
}

/**
* The default setting Combo
* If the number of combo a combo by adding the number of case sheets to initialize the module configuration. 
*/ 
function initCombo(comboObj, comboNo) {
	var formObject = document.form;
	switch(comboObj.id) {
		case "full_mty_cd":
			with (comboObj) {
				UseCode = true;
				SetColAlign("left");
				SetColWidth("20|120");
				DropHeight = 100;
			}
			break;
		case "bnd_vskd_seq_cd":
			with (comboObj) {
				UseCode = true;
				SetColAlign("left");
				SetColWidth("20|100");
				DropHeight = 100;
			}
			break;
		case "nod_tp_cd":
			with (comboObj) {
				UseCode = true;
				SetColAlign("left");
				SetColWidth("20|120");
				DropHeight = 100;
			}
			break;
		case "act_op_tp_cd":
			with (comboObj) {
				UseCode = true;
				SetColAlign("left");
				SetColWidth("20|100");
				DropHeight = 100;
			}
			break;			
		case "trsp_mod_cd":
			with (comboObj) {
				UseCode = true;
				SetColAlign("left");
				SetColWidth("30|110");
				DropHeight = 100;
			}
			break;
		case "org_dest_cd":
			with (comboObj) {
				UseCode = true;
				SetColAlign("left");
				SetColWidth("20|80");
				DropHeight = 100;
			}
			break;			
	}
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
			with (sheetObj) {
            
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
			var sXml=sheetObj.GetSearchXml("BCM_CCD_0025GS.do", "f_cmd=" + SEARCH01);
			var rtnValue=sXml.split("|$$|");
			for(var i=0; i<rtnValue.length; i++){
				var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
				var cdName=comboXml[0].split("|");
				var cdValue=comboXml[1].split("|");
				for (var j=0; j<cdName.length; j++) {
					comboObjects[i].InsertItem(j, cdValue[j]+"|"+cdName[j], cdValue[j]);
		        }
			}
			break;
	}
}

// Sheet processing-related processes
function doActionIBSheet(sheetObj,formObj,sAction) {
	switch(sAction) {
		case SEARCH01: // MDM AUTH_TP_CD query
	    	var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=MDAA';
 	    	var sXml=sheetObj.GetSearchXml("BCM_CCD_2002GS.do", sParam);
	    	// global var setting
	    	G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
	    	G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
    	break;
    	case SEARCH02:				//retrieve
    		if (validateForm(sheetObj, formObj, sAction)) {
    			formObj.f_cmd.value=SEARCH02;
    			ComOpenWait(true);
    			var sParam=FormQueryString(formObj);
    			var sXml=sheetObj.GetSearchXml("BCM_CCD_0025GS.do", sParam);
    			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
    			if(sav != "S" ) {
	        		ComOpenWait(false);
	        		return;
	    		}
    			if(ComIsBtnEnable("btn_Create")) {
    	    		if(ComXmlString(sXml, "delt_flg") == null || ComXmlString(sXml, "delt_flg") == "") {
    	    			ComOpenWait(false);
           				// showing message when data not exists
           				if (ComShowCodeConfirm("CCD00034", "Activity Code")) {
           					formObj.ibflag.value="I";
           					ComBtnDisable("btn_Create");
           					ComBtnDisable("btn_Retrieve");
           					ComBtnEnable("btn_Save");
           					ComEnableObject(formObj.btns_search1, false);
           		    		formObj.act_nm.focus();
           				} else {
           					doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
           				}
    	    			return;
    	    		}
    	    		
    	    		formObj.ibflag.value="U";	
    	    		formObj.act_nm.value = ComXmlString(sXml, "act_nm");
    	    		formObj.act_desc.value = ComXmlString(sXml, "act_desc");
    	    		formObj.act_tp_cd.Code(ComXmlString(sXml, "act_tp_cd"));
    	    		formObj.full_mty_cd.Code(ComXmlString(sXml, "full_mty_cd"));
    	    		formObj.bnd_vskd_seq_cd.Code(ComXmlString(sXml, "bnd_vskd_seq_cd"));
    	    		formObj.nod_tp_cd.Code(ComXmlString(sXml, "nod_tp_cd"));
    	    		formObj.act_op_tp_cd.Code(ComXmlString(sXml, "act_op_tp_cd"));
    	    		formObj.trsp_mod_cd.Code(ComXmlString(sXml, "trsp_mod_cd"));
    	    		formObj.org_dest_cd.Code(ComXmlString(sXml, "org_dest_cd"));
    	    		formObj.act_flg.value = ComXmlString(sXml, "act_flg");
    	    		formObj.act_stnd_edi_sts_cd.value = ComXmlString(sXml, "act_stnd_edi_sts_cd");
    	    		formObj.cop_skd_lgc_no.value = ComXmlString(sXml, "cop_skd_lgc_no");
    	    		//OnChange()를 발생시키지 않는다. 
    	    		formObj.delt_flg.value = ComXmlString(sXml, "delt_flg");
    	    		formObj.cre_usr_id.value = ComXmlString(sXml, "cre_usr_id");
    	    		formObj.cre_dt.value = ComXmlString(sXml, "cre_dt");
    	    		formObj.upd_usr_id.value = ComXmlString(sXml, "upd_usr_id");
    	    		formObj.upd_dt.value = ComXmlString(sXml, "upd_dt");
    	    		ComOpenWait(false);
    	    		act_tp_cd_OnChange();
    	    		formObj.act_cd.readOnly=true;    
    	    		ComBtnEnable("btn_Save");
    			} else {
    	    		if(ComXmlString(sXml, "delt_flg") == null || ComXmlString(sXml, "delt_flg") == "") {
    	    			ComOpenWait(false);
    	    		} else {
    	    			ComOpenWait(false);
    	    			ComShowCodeMessage("CCD00072", "Activity");
    	    			ComResetAll();
    	    			formObj.act_tp_cd.Code = "T";
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
 		    		var sXml=sheetObj.GetSaveXml("BCM_CCD_0025GS.do", sParam);
		    		var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		    		if(sav == "S" ){					//Saved after a successful re-viewed
		    			ComShowCodeMessage("COM130102", "Data");
						ComBtnEnable("btn_Create");
						ComBtnEnable("btn_Retrieve");
		    			doActionIBSheet(sheetObj,formObj,SEARCH02);
		        	}else{
		        		ComShowCodeMessage("COM130103", "Data");
		        	}
		    		ComOpenWait(false);
	    		}
    		}
		break;
    	case IBCREATE:
    		doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
			formObj.ibflag.value="I";
			ComBtnDisable("btn_Create");
			ComBtnDisable("btn_Retrieve");
			ComBtnEnable("btn_Save");
			ComEnableObject(formObj.btns_search1, false);
		break;
    	case IBCLEAR:
    		ComResetAll();
    		formObj.reset();
    		formObj.act_cd.readOnly = false;
    		formObj.ibflag.value = "I";
    		formObj.act_tp_cd.Code = "T";
    		formObj.full_mty_cd.Code = "";
    		formObj.act_op_tp_cd.Code = "";
    		formObj.org_dest_cd.Code = "";
    		formObj.nod_tp_cd.Code = "";
    		formObj.act_flg.value = "Y";
    		formObj.delt_flg.value = "N";
			ComBtnEnable("btn_Create");
			ComBtnDisable("btn_Save");
			ComBtnEnable("btn_Retrieve");
			ComEnableObject(formObj.btns_search1, true);
		break;
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
    	case SEARCH02:
    		if(formObj.act_cd.value == "" || formObj.act_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Activity Code");
    			formObj.act_cd.focus();
    			return false;
    		}
		break;
    	case MULTI01:
    		if(formObj.act_cd.value == "" || formObj.act_cd.value == null){
    			ComShowCodeMessage("CCD00001", "Activity Code");
    			formObj.act_cd.focus();
    			return false;
    		}
    		if(formObj.act_nm.value == "" || formObj.act_nm.value == null){
    			ComShowCodeMessage("CCD00001", "Name");
    			formObj.act_nm.focus();
    			return false;
    		}
    				
//    		if(formObj.act_desc.value == "" || formObj.act_desc.value == null){
//    			ComShowCodeMessage("CCD00001", "Description");
//    			formObj.act_desc.focus();
//    			return false;
//    		}
    		if(formObj.act_tp_cd.Code == "T"){
        		var firstDigit = /[M|F]/;
        		var secondDigit = /[O|I|R|L|T|U|D]/;
        		var thirdDigit = /[T|R|W|V]/;
        		var forthDigit = /[Z|S|Y|M|R]/;
        		var fifthDigit = /[A|B|D|L|U]/;
        		var sixthDigit = /[O|D]/;
        		
        		if(!firstDigit.test(formObj.act_cd.value.substr(0,1))) {
        			ComShowCodeMessage("CCD00073", "1st", "M, F");
        			ComSetFocus(formObj.act_cd);
        			return false;
        		}
        		if(!secondDigit.test(formObj.act_cd.value.substr(1,1))) {
        			ComShowCodeMessage("CCD00073", "2nd", "O, I, R, L, T, U, D");
        			ComSetFocus(formObj.act_cd);
        			return false;
        		}
        		if(!thirdDigit.test(formObj.act_cd.value.substr(2,1))) {
        			ComShowCodeMessage("CCD00073", "3rd", "T, R, W, V");
        			ComSetFocus(formObj.act_cd);
        			return false;
        		}
        		if(!forthDigit.test(formObj.act_cd.value.substr(3,1))) {
        			ComShowCodeMessage("CCD00073", "4th", "Z, S, Y, M, R");
        			ComSetFocus(formObj.act_cd);
        			return false;
        		}
        		if(!fifthDigit.test(formObj.act_cd.value.substr(4,1))) {
        			ComShowCodeMessage("CCD00073", "5th", "A, B, D, L, U");
        			ComSetFocus(formObj.act_cd);
        			return false;
        		}
        		if(!sixthDigit.test(formObj.act_cd.value.substr(5,1))) {
        			ComShowCodeMessage("CCD00073", "6th", "O, D");
        			ComSetFocus(formObj.act_cd);
        			return false;
        		}
//    			if(formObj.full_mty_cd.Code == "" || formObj.full_mty_cd.Code == null){
//    				ComShowCodeMessage("CCD00003", "Full/Empty");
//        			return false;
//    			}
//    			if(formObj.bnd_vskd_seq_cd.Code == "" || formObj.bnd_vskd_seq_cd.Code == null){
//    				ComShowCodeMessage("CCD00003", "BND / SKD Seq.");
//        			return false;
//    			}
//    			if(formObj.nod_tp_cd.Code == "" || formObj.nod_tp_cd.Code == null){
//    				ComShowCodeMessage("CCD00003", "Node Type");
//    				return false;
//    			}
//    			if(formObj.act_op_tp_cd.Code == "" || formObj.act_op_tp_cd.Code== null){
//    				ComShowCodeMessage("CCD00003", "Operation Type");
//        			return false;
//    			}
//    			if(formObj.trsp_mod_cd.Code == "" || formObj.trsp_mod_cd.Code == null){
//    				ComShowCodeMessage("CCD00003", "Trans. Mode");
//        			return false;
//    			}
//    			if(formObj.org_dest_cd.Code == "" || formObj.org_dest_cd.Code == null){
//    				ComShowCodeMessage("CCD00003", "ORG/DST");
//        			return false;
//    			}
    		} else {
    			if(formObj.act_cd.value.length != 3) {
        			ComShowCodeMessage("CCD00074");
        			ComSetFocus(formObj.act_cd);
        			return false;
    			}
    		}
		break;
	}
	return true;
}
	
/**
 * Change the combo box based on combo box linked to enable / disable
 */
function act_tp_cd_OnChange(){
	var formObj=document.form;
	if(formObj.act_tp_cd.Code == "D"){
		formObj.full_mty_cd.Code = "";
		formObj.bnd_vskd_seq_cd.Code = "";
		formObj.nod_tp_cd.Code = "";
		formObj.act_op_tp_cd.Code = "";
		formObj.trsp_mod_cd.Code = "";
		formObj.org_dest_cd.Code = "";			
		
		formObj.full_mty_cd.Enable = false;//formObj.full_mty_cd.SetEnable=false;
		formObj.bnd_vskd_seq_cd.Enable = false;
		formObj.nod_tp_cd.Enable = false;			
		formObj.act_op_tp_cd.Enable = false;
		formObj.trsp_mod_cd.Enable =  false;
		formObj.org_dest_cd.Enable =  false;
		formObj.act_cd.maxLength = 3;
		
	}else{			
		formObj.full_mty_cd.Enable = true;//formObj.full_mty_cd.SetEnable=true;
		formObj.bnd_vskd_seq_cd.Enable = true;
		formObj.nod_tp_cd.Enable = true;
		formObj.act_op_tp_cd.Enable = true;
		formObj.trsp_mod_cd.Enable = true;
		formObj.org_dest_cd.Enable = true;
		formObj.act_cd.maxLength = 6;
	}
}

function delt_flg_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){
	if(comboObj.GetSelectCode()== "Y"){
		if(!ComShowCodeConfirm("COM130301", "data")) comboObj.SetSelectCode("N",false);
	}
}

function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
	axon_event.addListenerForm('change', 'obj_change', formObj); 		
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
	/*axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
	axon_event.addListenerForm('keyup', 'obj_keyup', form); 		
	axon_event.addListenerForm('keydown', 'obj_keydown', form); 	
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);*/
	axon_event.addListenerForm("propertychange", "obj_propertychange", formObj);
}

/**
 * HTML Object  OnKeyUp event handling
 */
//   function obj_keypress(event) {
//     	obj=event.srcElement;
//     	keyValidation(obj);
//    }

/**
 * If the data field to be the change Event
 */
function obj_change(){
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
        	case "act_cd":
        		if(formObj.act_cd.value.length>0){
        			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
        		}
        	break;
        } // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
    	}
    }
}	

function getAct_Cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.act_cd.value=colArray[2];
    doActionIBSheet(sheetObj, formObj, SEARCH02);
}

function getValueForCombo(obj) {
	if (Object.prototype.toString.call(obj) === '[object Array]') {
		var str = obj[0];
		return str.split('|')[0];
	}
	return obj;
}