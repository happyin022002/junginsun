/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0493.js
*@FileTitle  : Vessel Registeration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* Developer Work */
// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;

// Event handler processing by button click event */
document.onclick=processButtonClick;

// Event handler processing by button name */
function processButtonClick(){
	 /***** using extra sheet valuable if there are more 2 sheets *****/
	 var sheetObject1=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
				case "btn_ViewResponse":
					var sUrl="/opuscntr/ESM_BKG_0492.do?pgmNo=ESM_BKG_0492&sr_sts_cd="+formObject.sr_sts_cd.value+"&rgst_dt="+formObject.rgst_dt.value
					+"&rjct_dt="+formObject.rjct_dt.value+"&vsl_auth_no="+formObject.vsl_auth_no.value+"&sr_sts_desc="+escape(formObject.sr_sts_desc.value)
					+"&sr_cmt_desc="+escape(formObject.sr_cmt_desc.value)+"&decl_bl_qty="+formObject.decl_bl_qty.value;
					ComOpenWindowCenter(sUrl, "ESM_BKG_0492", 450, 400, false);
					break;
				case "btn_Transmit":
					doActionIBSheet(sheetObject1,document.form,COMMAND01);
					break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initSheetData(sheetObjects[0], formObj);
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
	formObj.frm_vvd_number.focus();
}

// sheet data Initialization
function initSheetData(sheetObj, formObj) {
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);
	IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
}

/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
			with(sheetObj){
				var HeadTitle1="|| |vsl_call_ref_no|vvd_number|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|dem_free_dt|brth_ctnt|ntfy_ltr_ctnt|cre_usr_id|cre_dt|vps_eta_dt|vvd_number|user_ofc_cd|||";
				var headCount=ComCountHeadTitle(HeadTitle1);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_rgst_no",      Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt",       Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt_time",  Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vps_etd_dt",       Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vps_etd_dt_time",  Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",       Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_rgst_cnt_cd",  Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cap_nm",           Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"depature_port",    Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"arrival_port",     Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_nm",           Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_nm2",          Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_auth_no",      Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vessel_reg_no",    Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_cd",           Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_voy_no",       Edit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_dir_cd",       Edit:0 } ];

				InitColumns(cols);

				SetEditable(1);
				SetCountPosition(0);
				SetSheetHeight(302);
			}

			break;
	}
}

/**
 *
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
			formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
			formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);
			formObj.call_port.value=formObj.frm_call_port_cd.value;
			for(var i=1; i<=rowCnt; i++) {
				sheetObj.SetCellValue(i,"vsl_cd",formObj.frm_vvd_number.value.substring(0,4),0);
				sheetObj.SetCellValue(i,"skd_voy_no",formObj.frm_vvd_number.value.substring(4,8),0);
				sheetObj.SetCellValue(i,"skd_dir_cd",formObj.frm_vvd_number.value.substring(8),0);
			}
			var sXml=sheetObj.GetSearchData("ESM_BKG_0493GS.do", FormQueryString(formObj)  );
			sheetObj.LoadSearchData(sXml,{Sync:1} );

			if(sheetObj.RowCount()== 1){
				IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
				formObj.frm_depature_port.value=formObj.frm_call_port_cd.value;
				if(formObj.frm_vsl_nm.value.length == 0)
					formObj.frm_vsl_nm.value=ConstantMgr.getCompanyName();
				if(formObj.frm_vsl_nm2.value.length == 0)
					formObj.frm_vsl_nm2.value=ConstantMgr.getCompanyName();
			}
			ComEtcDataToForm(formObj, sheetObj);
			ComOpenWait(false);
		break;
		case IBSAVE:
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var rowCnt=sheetObj.RowCount();

			for(var i=1; i<=rowCnt; i++) {
				sheetObj.SetCellValue(i,"vsl_cd",formObj.frm_vvd_number.value.substring(0,4),0);
				sheetObj.SetCellValue(i,"skd_voy_no",formObj.frm_vvd_number.value.substring(4,8),0);
				sheetObj.SetCellValue(i,"skd_dir_cd",formObj.frm_vvd_number.value.substring(8),0);
			}

			if(formObj.frm_arrival_port.value.length < 5)
				formObj.frm_arrival_port.value=formObj.pod_cd.value;

			IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");

			sheetObj.DoSave("ESM_BKG_0493GS.do", FormQueryString(formObj));

			formObj.f_cmd.value=SEARCH;
			formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
			formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
			formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);
			formObj.call_port.value=formObj.frm_call_port_cd.value;

			for(var i=1; i<=rowCnt; i++) {
				sheetObj.SetCellValue(i,"vsl_cd",formObj.frm_vvd_number.value.substring(0,4),0);
				sheetObj.SetCellValue(i,"skd_voy_no",formObj.frm_vvd_number.value.substring(4,8),0);
				sheetObj.SetCellValue(i,"skd_dir_cd",formObj.frm_vvd_number.value.substring(8),0);
			}

			var sXml=sheetObj.GetSearchData("ESM_BKG_0493GS.do", FormQueryString(formObj)  );
			sheetObj.LoadSearchData(sXml,{Sync:1} );

			if(sheetObj.RowCount()== 1){
				IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
				formObj.frm_depature_port.value=formObj.frm_call_port_cd.value;
				if(formObj.frm_vsl_nm.value.length == 0)
					formObj.frm_vsl_nm.value=ConstantMgr.getCompanyName();
				if(formObj.frm_vsl_nm2.value.length == 0)
					formObj.frm_vsl_nm2.value=ConstantMgr.getCompanyName();
			}

			ComEtcDataToForm(formObj, sheetObj);
			//ComOpenWait(false);
			break;
		//EDI transmission
		case COMMAND01:
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI01;
			var rowCnt=sheetObj.RowCount();
			for(var i=1; i<=rowCnt; i++) {
				sheetObj.SetCellValue(i,"vsl_cd",formObj.frm_vvd_number.value.substring(0,4),0);
				sheetObj.SetCellValue(i,"skd_voy_no",formObj.frm_vvd_number.value.substring(4,8),0);
				sheetObj.SetCellValue(i,"skd_dir_cd",formObj.frm_vvd_number.value.substring(8),0);
			}
			sheetObj.SetCellValue(1, "ibflag","I",0);
			formObj.vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
			formObj.skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
			formObj.skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);
			formObj.pol_cd.value=formObj.pod_cd.value;
			sheetObj.DoSave("ESM_BKG_0493GS.do", FormQueryString(formObj));
			ComEtcDataToForm(formObj, sheetObj);
			//ComOpenWait(false);
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}

/**
* control KeyBoard.
**/
function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (ComChkLen(srcValue, srcMaxLength) == "2" && srcName != "frm_call_port_cd" ) {
			ComSetNextFocus();
		}
}

/**
 * Enter event
 * @return
 */
function obj_ComKeyEnter() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	if(srcName == "frm_vvd_number" || srcName == "pod_cd" || srcName == "frm_call_port_cd") {
		ComKeyEnter();
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	 switch (sAction) {
		case IBSEARCH: // Retrieve
		if (formObj.frm_vvd_number.value.length == 0) {
			ComShowCodeMessage('BKG00203');
			formObj.frm_vvd_number.focus();
			return false;
		}
		if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
			ComShowCodeMessage('BKG00203');
			formObj.frm_vvd_number.focus();
			return false;
		}
		if (formObj.frm_call_port_cd.value.length == 0) {
			ComShowCodeMessage('BKG00207');
			formObj.frm_call_port_cd.focus();
			return false;
		}
		if (formObj.frm_call_port_cd.value.length > 0 && formObj.frm_call_port_cd.value.length < 5) {
			ComShowCodeMessage('BKG00207');
			formObj.frm_call_port_cd.focus();
			return false;
		}
		return true;
		break;
		case COMMAND01: //
		if (formObj.frm_vvd_number.value.length == 0) {
			ComShowCodeMessage('BKG00203');
			formObj.frm_vvd_number.focus();
			return false;
		}
		if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
			ComShowCodeMessage('BKG00203');
			formObj.frm_vvd_number.focus();
			return false;
		}
		if (formObj.frm_call_port_cd.value.length == 0) {
			ComShowCodeMessage('BKG00207');
			formObj.frm_call_port_cd.focus();
			return false;
		}
		if (formObj.frm_call_port_cd.value.length > 0 && formObj.frm_call_port_cd.value.length < 5) {
			ComShowCodeMessage('BKG00207');
			formObj.frm_call_port_cd.focus();
			return false;
		}
		return true;
		break;
		case IBSAVE: // save
		if (formObj.frm_vvd_number.value.length == 0) {
			ComShowCodeMessage('BKG00203');
			formObj.frm_vvd_number.focus();
			return false;
		}
		if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
			ComShowCodeMessage('BKG00203');
			formObj.frm_vvd_number.focus();
			return false;
		}
		if(formObj.frm_vps_eta_dt.value.length > 0 && !ComIsDate(formObj.frm_vps_eta_dt.value, "ymd"))
		{
			ComShowCodeMessage('BKG00377');
			formObj.frm_vps_eta_dt.focus();
			return false;
		}
		if(formObj.frm_vps_etd_dt.value.length > 0 && !ComIsDate(formObj.frm_vps_etd_dt, "ymd"))
		{
			ComShowCodeMessage('BKG00377');
			formObj.frm_vps_etd_dt.focus();
			return false;
		}
		if(formObj.frm_vps_eta_dt_time.value.length > 0 &&!ComIsTime(formObj.frm_vps_eta_dt_time.value, "hms"))
		{
			ComShowMessage("올바른 시간형식이 아닙니다. (HH:MM:SS)");
			formObj.frm_vps_eta_dt_time.focus();
			return false;
		}
		if(formObj.frm_vps_etd_dt_time.value.length > 0 &&!ComIsTime(formObj.frm_vps_etd_dt_time.value, "hms"))
		{
			ComShowMessage("올바른 시간형식이 아닙니다. (HH:MM:SS)");
			formObj.frm_vps_etd_dt_time.focus();
			return false;
		}
		return true;
		break;
	}
}
