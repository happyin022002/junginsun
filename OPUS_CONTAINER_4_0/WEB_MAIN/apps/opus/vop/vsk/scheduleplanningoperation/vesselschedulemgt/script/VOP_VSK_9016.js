/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_9016.jsp
*@FileTitle  : Vessel Rename Information(Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btn_Close":
			ComClosePopup(); 
			break;
		case "btn_Ok":
			doActionIBSheet(sheetObj,formObj,COMMAND01);
			break;
		case "btn_Cancel":
			doActionIBSheet(sheetObj,formObj,COMMAND02);
			break;			
		case "btns_search1":
			var vsl_cd=formObj.vsl_renm_old_vsl_cd.value;
			var sUrl="/opuscntr/VOP_VSK_0219.do?vsl_cd="+vsl_cd;
			ComOpenPopup(sUrl, 464, 450, "getVslCdData1", "0,0", true);
			break;
		case "btns_search2":
			var vsl_cd=formObj.vsl_renm_new_vsl_cd.value;
			var sUrl="/opuscntr/VOP_VSK_0219.do?vsl_cd="+vsl_cd;
			ComOpenPopup(sUrl, 464, 450, "getVslCdData2", "0,0", true);
			break;			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('change', 'obj_change', formObj);
 }

/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	
	initControl();
	
	if(formObj.vsl_renm_old_vsl_cd.value == "" &&  formObj.vsl_renm_new_vsl_cd.value ==""){
		ComBtnDisable("btn_Cancel");
	}else{
		ComBtnEnable("btn_Cancel");
	}
	
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
		      tabIndex=-1;
		        
		      var HeadTitle="|vsl_renm_old_vsl_cd|vsl_renm_old_vsl_eng_nm|vsl_renm_new_vsl_cd|vsl_renm_new_vsl_eng_nm|skd_cng_sts_cd|";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_renm_old_vsl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_renm_old_vsl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_renm_new_vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_renm_new_vsl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"skd_cng_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(0);
		      SetVisible(false);
            }

		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
		case IBSEARCH: // Retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1") {
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj);
					sheetObj.DoSearch("VOP_VSK_9016GS.do", sParam );
				}
			}
			break;
		case COMMAND01: // Ok
			if (validateForm(sheetObj, formObj, sAction)) {
				var obj={};
				obj.vsl_renm_old_vsl_cd     = formObj.vsl_renm_old_vsl_cd.value;
				obj.vsl_renm_old_vsl_eng_nm = formObj.vsl_renm_old_vsl_eng_nm.value;
				obj.vsl_renm_new_vsl_cd     = formObj.vsl_renm_new_vsl_cd.value;
				obj.vsl_renm_new_vsl_eng_nm = formObj.vsl_renm_new_vsl_eng_nm.value;
				obj.skd_cng_sts_cd          = "R";

				ComPopUpReturnValue(obj);
			}
			break;
		case COMMAND02: // Cancel
			var obj={};
			obj.vsl_renm_old_vsl_cd     = "";
			obj.vsl_renm_old_vsl_eng_nm = "";
			obj.vsl_renm_new_vsl_cd     = "";
			obj.vsl_renm_new_vsl_eng_nm = "";

			if(formObj.skd_cng_sts_cd.value == "R"){
				obj.skd_cng_sts_cd  = "";
			}else{
				obj.skd_cng_sts_cd  = formObj.skd_cng_sts_cd.value;	
			}
			
			ComPopUpReturnValue(obj);

			break;			
        case SEARCH02: // Old Vessel Code Retrieve
        	ComOpenWait(true);
    		formObj.f_cmd.value=SEARCH;
    		var sParam="f_cmd=" + SEARCH + "&vsl_cd=" +formObj.vsl_renm_old_vsl_cd.value;
     		var sXml=sheetObj.GetSearchData("VOP_VSK_0044GS.do", sParam);
    		ComOpenWait(false);
    		return sXml;
    		break;					
        case SEARCH03: // New Vessel Code Retrieve
        	ComOpenWait(true);
    		formObj.f_cmd.value=SEARCH;
    		var sParam="f_cmd=" + SEARCH + "&vsl_cd=" +formObj.vsl_renm_new_vsl_cd.value;
     		var sXml=sheetObj.GetSearchData("VOP_VSK_0044GS.do", sParam);
    		ComOpenWait(false);
    		return sXml;
    		break;			
		default:
	}
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
	ComOpenWait(false);
	var i=1;
	var formObj = document.form;
	formObj.vsl_renm_old_vsl_cd.value = getSheetVal(sheetObj, 1, i++);
	formObj.vsl_renm_old_vsl_eng_nm.value = getSheetVal(sheetObj, 1, i++);
	formObj.vsl_renm_new_vsl_cd.value = getSheetVal(sheetObj, 1, i++); 
	formObj.vsl_renm_new_vsl_eng_nm.value = getSheetVal(sheetObj, 1, i++);
	
	if(formObj.vsl_renm_old_vsl_cd.value == "" &&  formObj.vsl_renm_new_vsl_cd.value ==""){
		ComBtnDisable("btn_Cancel");
	}else{
		ComBtnEnable("btn_Cancel");
	}
}

function getSheetVal(sheetObj, row, col) {
	return sheetObj.GetCellValue(row, col) == -1 ? "" : sheetObj.GetCellValue(row, col);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if(ComTrim(formObj.vsl_renm_old_vsl_cd) == "" && ComTrim(formObj.vsl_renm_old_vsl_eng_nm) == "" && ComTrim(formObj.vsl_renm_new_vsl_cd) == "" && ComTrim(formObj.vsl_renm_new_vsl_eng_nm) == ""){
			 ComShowCodeMessage("COM130201", "Vessel Info");
			return false;
		}else if((ComTrim(formObj.vsl_renm_old_vsl_cd) == "" && ComTrim(formObj.vsl_renm_old_vsl_eng_nm) != "") || (ComTrim(formObj.vsl_renm_old_vsl_cd) != "" && ComTrim(formObj.vsl_renm_old_vsl_eng_nm) == "")){
			ComShowCodeMessage("COM130201", "Old Vessel Info");
			return false;
		}else if((ComTrim(formObj.vsl_renm_new_vsl_cd) == "" && ComTrim(formObj.vsl_renm_new_vsl_eng_nm) != "") || (ComTrim(formObj.vsl_renm_new_vsl_cd) != "" && ComTrim(formObj.vsl_renm_new_vsl_eng_nm) == "")){
			ComShowCodeMessage("COM130201", "New Vessel Info");
			return false;
		}
	}
	return true;
}


function obj_change(){
 	var formObj=document.form;
    var sheetObject1=sheetObjects[0];
    var prefix1="sheet1_";
    var obj=event.srcElement;
     /*******************************************************/
 	try {
 		var srcName=ComGetEvent("name");
        switch(srcName) {
        	case "vsl_renm_old_vsl_cd":
        		var cnt=formObj.vsl_renm_old_vsl_cd.value;
				cnt=cnt.length;
				if(cnt == 4){
					var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
					var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
		    		if(!vsl_eng_nm){
		    			ComShowCodeMessage('VSK00021', formObj.vsl_renm_old_vsl_cd.value);
		    			formObj.vsl_renm_old_vsl_cd.value='';
		    			formObj.vsl_renm_old_vsl_cd.focus();
		    		}else{
		    			formObj.vsl_renm_old_vsl_eng_nm.value = vsl_eng_nm;
		    		}
				}
        	case "vsl_renm_new_vsl_cd":
        		var cnt=formObj.vsl_renm_new_vsl_cd.value;
				cnt=cnt.length;
				if(cnt == 4){
					var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
					var vsl_eng_nm=ComGetEtcData(sXml, "vsl_eng_nm");
		    		if(!vsl_eng_nm){
		    			ComShowCodeMessage('VSK00021', formObj.vsl_renm_new_vsl_cd.value);
		    			formObj.vsl_renm_new_vsl_cd.value='';
		    			formObj.vsl_renm_new_vsl_cd.focus();
		    		}else{
		    			formObj.vsl_renm_new_vsl_eng_nm.value = vsl_eng_nm;
		    		}
				}				
       		break;
        }
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage('VSK00011');
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
 } 

function getVslCdData1(rtnObjs) {
	var formObj = document.form;
	formObj.vsl_renm_old_vsl_cd.value = rtnObjs[0][1];
	formObj.vsl_renm_old_vsl_eng_nm.value = rtnObjs[0][2];
}

function getVslCdData2(rtnObjs) {
	var formObj = document.form;
	formObj.vsl_renm_new_vsl_cd.value = rtnObjs[0][1];
	formObj.vsl_renm_new_vsl_eng_nm.value = rtnObjs[0][2];
}
