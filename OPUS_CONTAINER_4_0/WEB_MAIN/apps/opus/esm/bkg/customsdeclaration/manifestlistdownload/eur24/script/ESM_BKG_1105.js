/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1105.js
*@FileTitle  : Europe Advanced Manifest - Diversion Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var comboObjects=new Array();
var comboCnt=0;
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 *  registering Combo Object as list
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj; 
}
  /**
 * Combo Object Initialization
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo){
    switch(comboObj.id){
    }
}
// Event handler processing by button name */
function processButtonClick(){
	/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try{
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName){
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_new":
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;  
			case "btn_transmit":
				doActionIBSheet(sheetObject1, formObject, MULTI01);
				break;
			case "btn_viewMsg":
				var row=sheetObject1.GetSelectRow();
				var edi_rcv_dt_msg=sheetObject1.GetCellValue(row, "edi_rcv_dt_msg");
				ComOpenWindowCenter(	"/opuscntr/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" +  edi_rcv_dt_msg + "&edi_rcv_seq=" + sheetObject1.GetCellValue(row, "edi_rcv_seq"), "1105", 600, 620, false);
				break;   	
		} // end switch
	}catch(e){
		if( e == "[object Error]"){
			ComShowMessage(OBJECT_ERROR);
		} else{
			ComShowMessage(e.message);
		}
	}
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage(){
	var formObj=document.form;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(i=0; i < comboObjects.length; i++ ){
		initCombo(comboObjects[i], i+1);
	}
	//The required events on the screen
//	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
//	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_change', document.form); // change
	SetButtonStatus();
	sheet1_OnLoadFinish(sheet1);
}

function obj_ComKeyEnter(event){
    if( ComGetEvent("keycode") != 13){return;}
    var obj=ComGetEvent();
    var formObj=document.form;
    switch ( obj.name ){
       case "form_vvd":
    	   if (ComChkObjValid(formObj.form_vvd, true, false, false))
    	   {
    		   doActionIBSheet(sheetObjects[0],formObj,SEARCH03);
    	   }
           break;
    }
}
 /**
  * Processing loading when the button on the screen
  */
function SetButtonStatus(){
	if(document.form.vvd.value == ''){
		ComBtnDisable("btn_transmit");
	}else{
		if(document.form.form_crr_cd.value == ConstantMgr.getCompanyCode()){
			if(document.form.form_dvs_rqst_edi_svc_flg.value == 'Y'){
				ComBtnEnable("btn_transmit");
			}else{
				ComBtnDisable("btn_transmit");
			}
    	 }else{
    		 ComBtnDisable("btn_transmit");
    	 }
     }
} 
/**
 * Event  after loading 
 * @param sheetObj
 * @return
 */
//no support[check again]CLT 
function sheet1_OnLoadFinish(sheetObj){
	var formObj=document.form;
	initSheetData(sheetObjects[0], formObj);
	ComSetFocus(formObj.form_vvd_cd);
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form;

	if(sheetObj.RowCount()== 0) {
		ComShowCodeMessage("BKG00889"); // No Data Found
		form_first_eu_port.SetBackColor("#FFFFFF");
		sheetObj.DataInsert(-1);
		formObj.form_rvis_n1st_clpt_cd.style.backgroundColor="white";
		IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
		formObj.form_vvd.value = formObj.p_vvd_cd.value;
		formObj.form_vvd.focus();
	}
	else
	{
		if(sheetObj.RowCount()== 1){
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
		}
		if(comboObjects[0].GetSelectCode()!= '' && formObj.form_rvis_n1st_clpt_cd.value == ''){
			formObj.form_rvis_n1st_clpt_cd.value=comboObjects[0].GetSelectCode();
		}
		if(formObj.form_rvis_n1st_clpt_cd.value != ''){
			formObj.form_rvis_n1st_clpt_cd_old.value=formObj.form_rvis_n1st_clpt_cd.value;
		}
		if(formObj.form_rvis_n1st_clpt_cd.value != '' && formObj.form_rvis_n1st_clpt_cd.value != comboObjects[0].GetSelectCode()){
			formObj.form_rvis_n1st_clpt_cd.style.backgroundColor="red";
		}else{
			formObj.form_rvis_n1st_clpt_cd.style.backgroundColor="white";
		}
		if(formObj.form_crr_cd.value == ConstantMgr.getCompanyCode()){
			formObj.form_dvs_rqst_smt_flg.disabled=true;
		}else{
			formObj.form_dvs_rqst_smt_flg.disabled=false;
		}
		if(sheetObjects[0].GetCellValue(1, "dvs_rqst_smt_flg") == 'Y'){
			formObj.form_dvs_rqst_smt_flg.checked=true;
		}else{
			formObj.form_dvs_rqst_smt_flg.checked=false;
		}
		doActionIBSheet(sheetObjects[0],formObj,SEARCH03);
		SetButtonStatus();
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo){
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID){
		case "sheet1":
			with(sheetObj){
			
				var HeadTitle1="| |vvd|cvy_ref_no|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|lloyd_no|piclb_desc|cstms_port_cd|n1st_port_ofc_cd|rvis_n1st_clpt_cd|n1st_port_ofc_cd_new|eta_dt|lst_clpt_cd|nxt_clpt_cd|cre_usr_id|cre_dt|upd_usr_id|upd_dt|upd_dt_gmt|snd_usr_id|snd_dt|snd_dt_gmt|snd_ofc_cd|first_eu_port|ack|result|cstms_yd_cd|edi_rcv_dt|edi_rcv_seq|rvis_cstms_yd_cd|crr_cd|dvs_rqst_smt_flg|upd_ofc_cd|edi_rcv_dt_gmt|edi_rcv_dt_msg|init_eta_dt|dvs_edi_svc_flg|dvs_rqst_edi_svc_flg";
				var headCount=ComCountHeadTitle(HeadTitle1);
				//(headCount, 0, 0, true);
	
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cvy_ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cvy_ref_no_hidden",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lloyd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"piclb_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_port_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"n1st_port_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rvis_n1st_clpt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"n1st_port_ofc_cd_new",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"eta_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lst_clpt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"nxt_clpt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_dt_gmt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_dt_gmt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"first_eu_port",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ack",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"result",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rvis_cstms_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"crr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dvs_rqst_smt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_dt_gmt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_dt_msg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"init_eta_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dvs_edi_svc_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dvs_rqst_edi_svc_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				 
				InitColumns(cols);
	
				SetEditable(1);
				SetCountPosition(0);
				SetWaitImageVisible(0);
				SetSheetHeight(302);
			}


			break;
	}
}
/**
 * Sheet handling process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj,formObj,sAction){
	sheetObj.ShowDebugMsg(false);
	switch(sAction){
		case IBSEARCH :	//Retrieve
			if(!validateForm(sheetObj,formObj,sAction))return false;
//			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			formObj.vvd.value=formObj.form_vvd.value;
//			formObj.cvy_ref_no.value=formObj.form_cvy_ref_no.value;
			formObj.cstms_port_cd.value=comboObjects[0].GetSelectCode();
			var cstms_yd_cd=formObj.form_cstms_yd_cd.value;
			formObj.cstms_yd_cd.value=formObj.form_cstms_yd_cd.value;
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_1105GS.do", FormQueryString(formObj));
			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
			if (sheetObj.RowCount()== 1) {
				IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
				if (cstms_yd_cd != '' && cstms_yd_cd != undefined){
					formObj.form_cstms_yd_cd.value=cstms_yd_cd;
				}
			}
			ComOpenWait(false);
			break;
		case IBINSERT :	
			formObj.p_vvd_cd.value = "";
			initSheetData(sheetObj, formObj);
			ComSetFocus(formObj.form_vvd);
			break;
		case IBSAVE :	
			if(!validateForm(sheetObj,formObj,sAction))return;
			IBS_CopyFormToRow(formObj, sheetObj, 1, "form_");
			sheetObj.SetCellValue(1,"cstms_port_cd",comboObjects[0].GetSelectCode());
			if(formObj.form_dvs_rqst_smt_flg.checked){
				formObj.dvs_rqst_smt_flg.value='Y';
			}else{
				formObj.dvs_rqst_smt_flg.value='N';
			}
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			formObj.rvis_cstms_yd_cd.value=comboObjects[1].GetSelectCode();
			sheetObj.SetCellValue(1,"rvis_cstms_yd_cd",comboObjects[1].GetSelectCode());
			sheetObj.DoSave("ESM_BKG_1105GS.do", FormQueryString(formObj));
			formObj.form_rvis_n1st_clpt_cd_old.value=formObj.form_rvis_n1st_clpt_cd.value
			ComOpenWait(false);
			break;
		case MULTI01:
			if(!validateForm(sheetObj,formObj,sAction)) return;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI01;
			formObj.vvd.value=formObj.form_vvd.value;
//			formObj.cvy_ref_no.value=formObj.form_cvy_ref_no.value;
			sheetObj.SetCellValue(1,"rvis_cstms_yd_cd",comboObjects[1].GetSelectCode());
			if(location.href.indexOf('opusdev') != -1 && formObj.form_ibflag.value == 'I'){
				ComShowCodeMessage("BKG01129");//Please Save First!
//				if(formObj.form_cstms_port_cd.value == ''){
//					ComShowCodeMessage("BKG01128");//No ENS data Found!
//				}else{
//				}
			}else{
				if(formObj.form_rvis_n1st_clpt_cd_old.value != formObj.form_rvis_n1st_clpt_cd.value){
					ComShowCodeMessage("BKG01129");//Please Save First!
				}else{
//parameter changed[check again]CLT 					
					var sXml=sheetObj.GetSearchData("ESM_BKG_1105GS.do", FormQueryString(formObj));
					var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
					if(State == "S"){
						ComShowCodeMessage("BKG00101"); // Data Transmitted Successfully!!
					}else{
						ComShowCodeMessage("BKG00099"); // Failed to transmit ED!!
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			}
			ComOpenWait(false);
			break;
		case SEARCH02: // VVD Combo setting
			formObj.f_cmd.value=SEARCH02;
			formObj.p_vvd_cd.value=formObj.form_vvd.value;
			var sXml=sheetObj.GetSearchData("ESM_BKG_1105GS.do", FormQueryString(formObj));
			if (ComGetTotalRows(sXml) > 0) {

				ComBkgXml2ComboItem(sXml, comboObjects[0], "eu_1st_port", "eu_1st_port|eu_1st_port_yd_cd", true);
				var arr=new Array();
				arr=ComBkgXml2ComboString(sXml, "eu_1st_port", "eu_1st_port");
				if(arr == undefined || arr == ''){
					ComShowCodeMessage("BKG00889"); // No Data Found
					return;
				}
				arr=ComBkgXml2ComboString(sXml, "eu_1st_port_yd_cd", "eu_1st_port_yd_cd");
				eu_1st_port_yd_cd=arr[0].split("|");
				formObj.form_cstms_yd_cd.value=eu_1st_port_yd_cd[0].substring(5);
				comboObjects[0].SetSelectIndex(0);
				
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
			else{
				ComShowCodeMessage("BKG00889"); // No Data Found
				doActionIBSheet(sheetObjects[0],formObj,IBINSERT);
				return ;
			}
		break;
		case SEARCH03: // YARD Combo setting
			
			formObj.f_cmd.value=SEARCH03;
			formObj.rvis_n1st_clpt_cd.value=formObj.form_rvis_n1st_clpt_cd.value;
//parameter changed[check again]CLT 			
			var sXml=sheetObj.GetSearchData("ESM_BKG_1105GS.do", FormQueryString(formObj));
//			alert(sXml);
			if (ComGetTotalRows(sXml) > 0) {
				ComBkgXml2ComboItem(sXml, comboObjects[1], "tml_cd", "tml_cd|n1st_port_ofc_cd_new", true);
				var arr=new Array();
				arr=ComBkgXml2ComboString(sXml, "tml_cd", "tml_cd");
				if(arr == undefined || arr == ''){
					//ComShowCodeMessage("BKG00889"); // No Data Found
					formObj.form_n1st_port_ofc_cd_new.value='';
					n1st_port_ofc_cd_new=new Array();
					ComBkgXml2ComboItem('', comboObjects[1], "tml_cd", "tml_cd|n1st_port_ofc_cd_new", true);
					return;
				}else{
					var ydIndex=0;
					if(formObj.form_rvis_cstms_yd_cd.value == ''){
						comboObjects[1].SetSelectIndex(0);
					}else{
						arr=ComBkgXml2ComboString(sXml, "tml_cd", "tml_cd");
						rvis_cstms_yd_cd=arr[0].split("|");
						for(var i=0; i < rvis_cstms_yd_cd.length; i++){
							if(rvis_cstms_yd_cd[i] == formObj.form_rvis_cstms_yd_cd.value) ydIndex=i;
						}
						comboObjects[1].SetSelectIndex(ydIndex);
					}
					arr=ComBkgXml2ComboString(sXml, "n1st_port_ofc_cd_new", "n1st_port_ofc_cd_new");
					n1st_port_ofc_cd_new=arr[0].split("|");
					formObj.form_n1st_port_ofc_cd_new.value=n1st_port_ofc_cd_new[ydIndex];
				}
			}
			else {
				ComShowCodeMessage("BKG00889"); // No Data Found
				return false;
			}
		break;
	}
}
var eu_1st_port_yd_cd=new Array();
var n1st_port_ofc_cd_new=new Array();
var rvis_cstms_yd_cd=new Array();
// Sheet data initialization
function initSheetData(sheetObj, formObj){
	sheetObj.RemoveAll();
	form_first_eu_port.RemoveAll();
	form_first_eu_port.SetSelectText("");
	form_first_eu_port.SetBackColor("#FFFFFF");
	
	sheetObj.RemoveAll();
	sheetObj.DataInsert(-1);
	formObj.form_rvis_n1st_clpt_cd.style.backgroundColor="white";
	IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
	formObj.form_vvd.value = formObj.p_vvd_cd.value;
	formObj.form_vvd.focus();
}
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case IBSEARCH:{ 
			if(formObj.form_vvd.value == "") {
				ComShowCodeMessage("BKG00251");
				ComSetFocus(formObj.form_vvd);
				return false;
			}
			break;
		}
		case IBSAVE:{ 
			//Check the default format
			if(formObj.form_rvis_n1st_clpt_cd.value == ""){
				ComShowCodeMessage('BKG00715', "New Country & Port");
				ComSetFocus(formObj.form_rvis_n1st_clpt_cd);
				return false;
			}
			//if(formObj.form_n1st_port_ofc_cd_new.value == ""){
			//	ComShowCodeMessage('BKG00715', "New First Office");
			//	ComSetFocus(formObj.form_n1st_port_ofc_cd_new);
			//	return false;
			//}
			//if(formObj.form_n1st_port_ofc_cd.value == formObj.form_n1st_port_ofc_cd_new.value){
			//	ComShowCodeMessage('BKG01132');
			//	ComSetFocus(formObj.form_cstms_port_cd);
			//	return false;
			//}
			if(!ComChkValid(formObj))return false;
			//alert(comboObjects[0].Code + " : " + port);
			if(formObj.form_vvd.value == ""){
				ComShowCodeMessage('BKG00715', "VSL Code");
				ComSetFocus(formObj.form_vvd);
				return false;
			}
			var port=comboObjects[0].GetSelectCode();
			if(port != undefined && port != ''){
				port=port.substring(0,2);
			}
			if(port == 'NL' && formObj.form_cvy_ref_no.value == ""){
				ComShowCodeMessage('BKG00715', "CRN No.");
				ComSetFocus(formObj.form_cvy_ref_no);
				return false;
			}
			break;
		}
		case REMOVE :{ 
			//Check the default format
			if(!ComChkValid(formObj))return false;
			if(sheetObj.RowCount()== 0){
				ComShowCodeMessage('BKG00889');
				return false;
			}
			if(sheetObj.RowCount()== 1){
				if(sheetObj.GetCellValue(1,"vvd_cd")== "" || sheetObj.GetCellValue(1,"pod_cd")== ""){
					ComShowCodeMessage('BKG00889');
					return false;
				}
			}
			break;
		}
		case MULTI01:{
			//Check the default format
			if(!ComChkValid(formObj)) return false;
			var port=comboObjects[0].GetSelectCode();
			if(port != undefined && port != ''){
				port=port.substring(0,2);
			}
			if(port == 'NL' && formObj.form_cvy_ref_no.value == ""){
				ComShowCodeMessage('BKG00715', "CRN No.");
				ComSetFocus(formObj.form_cvy_ref_no);
				return false;
			}
			if(formObj.form_cstms_port_cd.value == ""){
				ComShowCodeMessage('BKG01128', "Original Port doen't exist. Pleas register.");
				ComSetFocus(formObj.form_cstms_port_cd);
				return false;
			}
			if(formObj.form_n1st_port_ofc_cd_new.value == "" || formObj.form_n1st_port_ofc_cd.value == ""){
				ComShowCodeMessage('BKG01131');
				ComSetFocus(formObj.form_n1st_port_ofc_cd_new);
				return false;
			}
			if(formObj.form_n1st_port_ofc_cd.value == formObj.form_n1st_port_ofc_cd_new.value){
				ComShowCodeMessage('BKG01132');
				ComSetFocus(formObj.form_cstms_port_cd);
				return false;
			}			
		}
	} // end switch
	return true;
 }
/**
 * Events after Save
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg){

	if(ErrMsg == ""){
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	} 
}

/**
 * Change the form field events
 * 
 * @return
 */
function obj_change() {
	console.log("============================================================^^^^^^^^^^^^^^^^^^^^^^^^^^change");
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");
	var srcValue=ComGetEvent("value");
	if(srcName == "form_rvis_n1st_clpt_cd"){
		if(formObj.form_rvis_n1st_clpt_cd.value != comboObjects[0].GetSelectCode()){
//			$('#form_rvis_n1st_clpt_cd').removeClass('input2').addClass('importantRed');
			formObj.form_rvis_n1st_clpt_cd.style.backgroundColor="red";
			doActionIBSheet(sheetObjects[0],document.form,SEARCH03);
		}else{
//			$('#form_rvis_n1st_clpt_cd').removeClass('importantRed').addClass('input2');
			formObj.form_rvis_n1st_clpt_cd.style.backgroundColor="white";
		}
	}
	else if(srcName == "form_vvd"){
		formObj.p_vvd_cd.value=formObj.form_vvd.value;

		if (srcValue.length == srcMaxLength)
		{
			doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
		}
		else
		{
			doActionIBSheet(sheetObjects[0],formObj,IBINSERT); // form_vvd reset
		}
	}
	else if(srcName == "form_rvis_n1st_clpt_cd"){
		doActionIBSheet(sheetObjects[0],formObj,SEARCH03);
	}
}
 /**
  * Container List combo change event
  * @param comboObj
  * @param value
  * @param text
  * @return
  */
 function form_first_eu_port_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){//(comboObj,value,text) {
		var formObj=document.form;
	 	var index=comboObj.GetSelectIndex();
	 	formObj.form_cstms_yd_cd.value=eu_1st_port_yd_cd[index];
 }
 /**
  * Container List combo change event
  * @param comboObj
  * @param value
  * @param text
  * @return
  */
 function form_tml_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode){//(comboObj, value, text) {
	var formObj=document.form;
 	var index=comboObj.GetSelectIndex();
 	if(index < 0){
 		formObj.form_n1st_port_ofc_cd_new.value='';
 		return;
 	}
 	formObj.form_n1st_port_ofc_cd_new.value=n1st_port_ofc_cd_new[index];
 } 
