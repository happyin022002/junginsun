/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0155.js
*@FileTitle  : Disposal Buyer Management 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
		  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* developer job	*/
/* ********* General Functions ************* */
//common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var MnrPrnrStsCode="";
var saveTextIndex=0;
var nowLoad=0;
var strMnrOfficeLevel="";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		var obj = event.target || event.srcElement;
		   if ($(obj).prop('disabled')) {
		 return;
		 }
		switch(srcName) {
		case "btn_retrieve":
			saveTextIndex="";
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			break;
		case "btn_new":
			doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
			break;
		case "btn_save":
			MnrPrnrStsCode="S";
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;
		case "btn_remove":
			doActionIBSheet(sheetObjects[0],document.form,REMOVE);
			break;
		case "btn_reject":
			MnrPrnrStsCode="J";
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;
		case "btn_confirm":
			MnrPrnrStsCode="C";
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;
		case "btn_expire":
			MnrPrnrStsCode="X";
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			break;
		case "btn_rowadd":
			doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
			break;
		case "btn_delete":
			doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
			break;
		case "btn_customer":
			ComOpenPopup("COM_ENS_041.do", 780, 520, 'setPopUpParam_COM_ENS_041', '1,0,1,1,1,1,1', true);
			break;
		case "btn_calendar":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
			break;
		case "btn_calendar2":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
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
function initControl() {
	//Axon handling event1. event catch
	var formObject=document.form;
	axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  
//	axon_event.addListenerFormat('focus',    'obj_activate',    formObject);                       
	axon_event.addListenerFormat('change',	 'obj_change',	formObject); 
}
//Axon handling event2. handling event
function obj_deactivate(){
	ComChkObjValid(ComGetEvent());
}
function obj_activate(){
	ComClearSeparator(ComGetEvent());
}
function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if(sheetObj.RowCount()<=0 &&(obj.name!="mnr_prnr_cnt_cd" && obj.name!="mnr_prnr_seq")) return;
	if ( ComTrim(obj.value) != "" )
	{
		switch(ComGetEvent("name"))
		{
		case "mnr_prnr_cnt_cd":
			setCustomerName();
			break;
		case "mnr_prnr_seq":
			setCustomerName();
			break;
		}
	}
}
function setPopUpParam_COM_ENS_041(array) {
	if(array == null)return;
	var formObj=document.form;
	var str=array + "";
	var arr=str.split(",");
	formObj.mnr_prnr_cnt_cd.value=arr[3].substring(0,2);
	formObj.mnr_prnr_seq.value=arr[3].substring(2);
	formObj.mnr_prnr_cnt_nm.value=arr[4];
	var sheetObj=sheetObjects[0];
	if(sheetObj.RowCount()> 0)
	{
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"sheet1_mnr_prnr_cnt_cd",formObj.mnr_prnr_cnt_cd.value,0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"sheet1_mnr_prnr_seq",formObj.mnr_prnr_seq.value,0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"sheet1_mnr_prnr_cnt_nm",formObj.mnr_prnr_cnt_nm.value,0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"sheet1_mnr_prnr_cnt_cd_seq",formObj.mnr_prnr_cnt_cd.value + "" + formObj.mnr_prnr_seq.value,0);
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
 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
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
//	MnrWaitControl(true);
	initControl();
	for(i=0;i<sheetObjects.length;i++){
		//
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i + 1);
		//
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
//	MnrWaitControl(false);
}
function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
	 ComResizeSheet(sheetObjects[1]);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //t1sheet1 init
	    with(sheetObj){
	      var HeadTitle1="|Sel|Seq|Buyer Code|Buyer Name|Customer Code|Req. DT|Buyer Type|Status|Update User|Update Date";
	      HeadTitle1 += "|mnr_prnr_cre_seq";
	      HeadTitle1 += "|mnr_grp_tp_cd";
	      HeadTitle1 += "|mnr_prnr_tp_cd";
	      HeadTitle1 += "|ctrl_ofc_cd";
	      HeadTitle1 += "|mnr_prnr_knd_dtl_cd";
	      HeadTitle1 += "|mnr_prnr_sts_cd";
	      HeadTitle1 += "|mnr_prnr_cnt_cd";
	      HeadTitle1 += "|mnr_prnr_seq";
	      HeadTitle1 += "|edi_id";
	      HeadTitle1 += "|mnr_prnr_locl_lang_nm";
	      HeadTitle1 += "|mnr_prnr_addr";
	      HeadTitle1 += "|bzet_addr";
	      HeadTitle1 += "|mnr_bil_to_nm";
	      HeadTitle1 += "|eff_dt";
	      HeadTitle1 += "|exp_dt";
	      HeadTitle1 += "|bank_nm";
	      HeadTitle1 += "|bank_acct_no";
	      HeadTitle1 += "|pay_mzd_cd";
	      HeadTitle1 += "|pay_term_dys";
	      HeadTitle1 += "|zip_cd";
	      HeadTitle1 += "|ownr_nm";
	      HeadTitle1 += "|bzct_nm";
	      HeadTitle1 += "|bztp_nm";
	      HeadTitle1 += "|biz_rgst_no";
	      HeadTitle1 += "|mnr_shop_flg";
	      HeadTitle1 += "|mnr_payr_cnt_cd";
	      HeadTitle1 += "|mnr_payr_seq";
	      HeadTitle1 += "|mnr_prnr_capi_amt";
	      HeadTitle1 += "|empe_knt";
	      HeadTitle1 += "|dpt_desc";
	      HeadTitle1 += "|mnr_prnr_abbr_nm";
	      HeadTitle1 += "|intl_phn_no";
	      HeadTitle1 += "|intl_fax_no";
	      HeadTitle1 += "|fax_no";
	      HeadTitle1 += "|mnr_prnr_rmk";
	      HeadTitle1 += "|trsm_mod_cd";
	      HeadTitle1 += "|file_seq";
	      HeadTitle1 += "|cre_usr_id";
	      HeadTitle1 += "|cre_dt";
//	      HeadTitle1 += "|upd_usr_id";
//	      HeadTitle1 += "|upd_dt";
	      HeadTitle1 += "|mnr_prnr_cnt_nm";
	      HeadTitle1 += "|mnr_swift_no";
	      HeadTitle1 += "|disp_cnt";
	      HeadTitle1 += "|btn_flg";
	      HeadTitle1 += "|disp_proc_cnt";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      (headCount, 0, 0, true);
	      var prefix="sheet1_";
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	             {Type:"Radio",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"checkbox",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",    ColMerge:1,   SaveName:prefix+"mnr_prnr_cre_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",    ColMerge:1,   SaveName:prefix+"mnr_prnr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_cnt_cd_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",    ColMerge:1,   SaveName:prefix+"mnr_prnr_knd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",    ColMerge:1,   SaveName:prefix+"mnr_prnr_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:100,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:100,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"phn_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"mnr_prnr_eml",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_grp_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ctrl_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_knd_dtl_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_locl_lang_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bzet_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_bil_to_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bank_acct_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_mzd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_term_dys",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"zip_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ownr_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bzct_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bztp_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"biz_rgst_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_shop_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_payr_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_payr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_capi_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"empe_knt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"dpt_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_abbr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"intl_phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"intl_fax_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"trsm_mod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"file_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_cnt_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_swift_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"disp_cnt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"btn_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"disp_proc_cnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	       
	      InitColumns(cols);
	
	      SetEditable(1);
	      SetColHidden(prefix+"checkbox",1);
	      SetShowButtonImage(0);
//	      SetSheetHeight(565);
	      resizeSheet();
      }
	break;
	case 2:
	    with(sheetObj){
        	var HeadTitle1="|Sel|Seq.|CTRL Office|Buyer Name|Buyer Phone|Buyer Email|aply_flg|mnr_prnr_cre_seq|prmry_chk_flg|Interested Location";
      		var headCount=ComCountHeadTitle(HeadTitle1);
      		(headCount, 0, 0, true);
      		var prefix="sheet2_";

      		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

      		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      		InitHeaders(headers, info);

		    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mnr_cntc_prnr_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1000 },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"mnr_prnr_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"aply_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_prnr_cre_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"prmry_chk_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 } ];
		       
      		InitColumns(cols);
      		SetColProperty(0 , prefix+"ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
      		SetEditable(1);
            SetColHidden(prefix+"aply_flg",1);
//            SetSheetHeight(120);
            resizeSheet();
      	}
		break;
	}
}
/**
 * initializing multi Combo
 * @return
 */
function initCombo() {
	var formObj=document.form
	with (combo_in_mnr_prnr_knd_cd) {
		SetMultiSeparator("|");
		SetColAlign(0, "left");
		SetColWidth(0, "100");
		SetDropHeight(86);
		SetSelectIndex(0);
	}
	with (combo_in_mnr_prnr_sts_cd) {
		SetMultiSeparator("|");
		SetColAlign(0, "left");
		SetColWidth(0, "80");
		SetDropHeight(129);
		SetSelectIndex(1);
	}
	with (combo_mnr_prnr_knd_cd) {
		SetMultiSeparator("|");
		SetColAlign(0, "left");
		SetColWidth(0, "140");
		SetDropHeight(65);
	}
	with (combo_mnr_prnr_knd_dtl_cd) {
		SetMultiSeparator("|");
		SetColAlign(0, "left");
		SetColWidth(0, "100");
		SetDropHeight(43);
	}
	with (combo_pay_mzd_cd) {
		SetMultiSeparator("|");
		SetColAlign(0, "left");
		SetColWidth(0, "100");
		SetDropHeight(200);
	}
	with (combo_dpt_desc) {
		SetMultiSeparator("|");
		SetColAlign(0, "left");
		SetColWidth(0, "200");
		SetDropHeight(107);
	}
	var sheetObj=sheetObjects[0];
	//retrieving Combo
	var sCondition=new Array (
			new Array("MnrGenCd"  ,"CD00034", "COMMON") //Buyer Type _MNR_PRNR_KND_CD and Buyer Type Infomation 부문 _MNR_PRNR_KND_CD2
			,new Array("MnrGenCd" ,"CD00054", "COMMON")  //Buyer Detail Type _mnr_prnr_knd_dtl_cd
			,new Array("MnrGenCd" ,"CD00053", "COMMON")  //Buyer Status MNR_PRNR_STS_CD
			,new Array("ComIntgCd","CD00809", "COMMON")  //P.Method
			,new Array("MnrGenCd" ,"CD00070", "COMMON")	 //Deposit Info
	)
	var comboList=MnrComSearchCombo(sheetObj,sCondition);
	//setting sheet
	var sheetComboText="";
	var sheetComboCode="";
	var sheetComboCodeText="";
	var sheetComboDefault="";
	for(var i=0; i < comboList.length;i++){
		//initializing sheetCombo
		sheetComboText="";
		sheetComboCode="";
		sheetComboCodeText="";
		sheetComboDefault="";
		if(comboList[i] != null){
			if(i==0)
			{
				combo_in_mnr_prnr_knd_cd.InsertItem(0, "All", " ");
			}else if (i==2) {
				combo_in_mnr_prnr_sts_cd.InsertItem(0, "All", " ");
			}
			for(var j=0; j < comboList[i].length;j++){
				var tempText=comboList[i][j].split("|");
				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
				if(j ==0){
					sheetComboDefault=tempText[0];
				}
				if(i==0) {
					combo_in_mnr_prnr_knd_cd.InsertItem(j+1, tempText[1] ,tempText[0]);
					combo_mnr_prnr_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}else if (i==1) {
					combo_mnr_prnr_knd_dtl_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}else if (i==2) {
					combo_in_mnr_prnr_sts_cd.InsertItem(j+1, tempText[1] ,tempText[0]);
				}else if (i==3) {
					combo_pay_mzd_cd.InsertItem(j, tempText[1] ,tempText[0]);
				}else if (i==4) {
					combo_dpt_desc.InsertItem(j, tempText[1], tempText[0]);
				}
			}
			if(i==0){
				combo_in_mnr_prnr_knd_cd.SetSelectCode("-1",false);
				combo_mnr_prnr_knd_cd.SetSelectCode("L",false);
			}else if(i==1){
				combo_mnr_prnr_knd_dtl_cd.SetSelectCode("");
			}else if(i==2){
				combo_in_mnr_prnr_sts_cd.SetSelectCode(" ");
			}else if(i==3){
				combo_pay_mzd_cd.SetSelectIndex(1);
			}else if(i==4){
				combo_dpt_desc.SetSelectCode("-1",false);
			}
			//setting sheet combo
			if(i == 0) {
				sheetObjects[0].SetColProperty(0,"sheet1_mnr_prnr_knd_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
			}
		}
	}
}
//[2:56:25 PM] Tuấn Lực Dương: OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
function combo_mnr_prnr_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	formObj.mnr_prnr_knd_cd.value=combo_mnr_prnr_knd_cd.GetSelectCode();
	form.combo_mnr_prnr_knd_cd_text.value = comboObj.GetText(parseInt(newIndex), 0);
}
	
function combo_in_mnr_prnr_sts_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	//mnr_prnr_knd_dtl_cd.value=combo_mnr_prnr_knd_dtl_cd.GetSelectCode();
	formObj.combo_in_mnr_prnr_sts_cd_text.value = comboObj.GetText(parseInt(newIndex), 0);
}

function combo_in_mnr_prnr_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	//mnr_prnr_knd_dtl_cd.value=combo_mnr_prnr_knd_dtl_cd.GetSelectCode();
	formObj.in_mnr_prnr_knd_cd.value=combo_mnr_prnr_knd_cd.GetSelectCode();
	form.combo_in_mnr_prnr_knd_cd_text.value = comboObj.GetText(parseInt(newIndex), 0);
}

function combo_mnr_prnr_knd_dtl_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	//alert(newIndex);
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	formObj.mnr_prnr_knd_dtl_cd.value=combo_mnr_prnr_knd_dtl_cd.GetSelectCode();
	form.combo_mnr_prnr_knd_dtl_cd_text.value = comboObj.GetText(parseInt(newIndex), 0);
	
}
function combo_pay_mzd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	if(sheetObj.RowCount()>0)
	{
		pay_mzd_cd.value=combo_pay_mzd_cd.GetSelectCode();
	}
	form.combo_pay_mzd_cd_text.value = comboObj.GetText(parseInt(newIndex), 0);
}
function combo_dpt_desc_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	formObj.dpt_desc.value=combo_dpt_desc.GetSelectCode();
	form.combo_dpt_desc_text.value = comboObj.GetText(parseInt(newIndex), 0);
}
// handling process for sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBCLEAR:  //NEW
		MnrWaitControl(true);
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
//		sheetObj.RemoveAll();
		clearFormObjectValues();
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
		//initializing combo
		for(var i=0; i < comboObjects.length;i++){
			comboObjects[i].SetSelectCode("-1");
			comboObjects[i].RemoveAll();
		}
		initCombo();
		formObj.ctrl_ofc_cd.value=currOfcCd;
		combo_pay_mzd_cd.SetSelectIndex(1);
		//combo_mnr_prnr_knd_cd.SetSelectIndex(1);
		combo_in_mnr_prnr_knd_cd.SetSelectIndex(0);
		combo_in_mnr_prnr_sts_cd.SetSelectIndex(0);
		formObj.pay_term_dys.value="0";
		formObj.tocal.value=ComGetNowInfo();
		formObj.fromcal.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -90);
		formObj.cre_dt.value=ComGetNowInfo();
		ComEnableObject(formObj.mnr_prnr_lgl_eng_nm,true);
		formObj.mnr_prnr_lgl_eng_nm.className="input1";
		combo_mnr_prnr_knd_cd.SetSelectCode("L",false);
		combo_mnr_prnr_knd_cd.SetEnable(0);
		formObj.mnr_prnr_knd_cd.value=combo_mnr_prnr_knd_cd.GetSelectCode();
		ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
		MnrWaitControl(false);
		
//		if(strMnrOfficeLevel!="L1"){
//			ComBtnDisable("btn_remove");
//			ComBtnDisable("btn_reject");
//			ComBtnDisable("btn_confirm");
//			ComBtnDisable("btn_expire");
//		}
		
		break;
	case IBSEARCH:      //retrieving
		if(!validateForm(sheetObj,formObj,sAction))return;
		nowLoad=1;
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObj.RemoveAll();
		//sheetObjects[0].getStatus
		formObj.f_cmd.value=SEARCH;
		formObj.in_mnr_prnr_knd_cd.value=combo_in_mnr_prnr_knd_cd.GetSelectCode();
		formObj.in_mnr_prnr_sts_cd.value=combo_in_mnr_prnr_sts_cd.GetSelectCode();
		formObj.ctrl_ofc_cd.value=""; //setting empty in case of retrieving pure list
		formObj.mnr_prnr_tp_cd.value=""; //setting empty in case of retrieving pure list
		formObj.mnr_prnr_cnt_cd.value=""; //setting empty in case of retrieving pure list
		formObj.mnr_prnr_seq.value=""; //setting empty in case of retrieving pure list
		var sParam="";
		var aryPrefix=new Array("sheet1_", "sheet2_");
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
		var sXml=sheetObj.GetSearchData("EES_MNR_0155GS.do", sParam);
		arrDataSearchDbXml=sXml.split("|$$|");
		for ( var i=0; i < arrDataSearchDbXml.length; i++) {
			sheetObjects[i].RenderSheet(0);
			sheetObjects[i].WaitImageVisible = false;
			sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:0} );
			sheetObjects[i].RenderSheet(1);
		}
		break;
	case COMMAND02:      //retrieving DTL
		nowLoad=1;
		sheetObjects[1].RemoveAll();
		formObj.f_cmd.value=SEARCH;
		var aryPrefix=new Array("sheet1_", "sheet2_");
		var sParam="";
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("EES_MNR_0155GS.do", sParam);
		arrDataSearchDbXml=sXml.split("|$$|");
		for ( var i=1; i < arrDataSearchDbXml.length; i++) {
			sheetObjects[1].RenderSheet(0);
			sheetObjects[1].WaitImageVisible = false;
			sheetObjects[1].LoadSearchData(arrDataSearchDbXml[i],{Sync:0} );
			sheetObjects[1].RenderSheet(1);
		}
		break;
	case IBSAVE:        //saving
		if(nowLoad != 0) return;
		if(!validateForm(sheetObj,formObj,sAction))return;
		nowLoad=1;
		formObj.f_cmd.value=MULTI;
		if(sheetObj.RowCount()>0)
		{
			saveTextIndex=formObj.mnr_prnr_cre_seq.value;
		}else{
			saveTextIndex="";
		}
//		if(formObj.mnr_prnr_sts_cd.value=="C")
//		{
//			MnrPrnrStsCode="C";
//		}else{
		formObj.mnr_prnr_sts_cd.value=MnrPrnrStsCode;
//		}
		var aryPrefix=new Array("sheet1_", "sheet2_");
		var sParam1=ComGetSaveString(sheetObjects, true, true);
		var sParam=FormQueryString(formObj) + "&" + sParam1 + "&" + FormQueryString(formObj)+ "&"
		+ ComGetPrefixParam(aryPrefix);
		//ComDebug(sParam);
		var sXml=sheetObj.GetSaveData("EES_MNR_0155GS.do", sParam);
		sheetObjects[0].LoadSaveData(sXml);
		break;
	case REMOVE:        //deleting
		if(nowLoad != 0) return;
		if(!validateForm(sheetObj,formObj,sAction))return;
		MnrWaitControl(true);
		nowLoad=1;
		formObj.f_cmd.value=REMOVE;
		var aryPrefix=new Array("sheet1_", "sheet2_");
		var sParam1=ComGetSaveString(sheetObjects, true, true);
		if (sParam1 == "")
		{
			MnrWaitControl(false);
			return false;
		}
		var sParam=FormQueryString(formObj) + "&"+ sParam1 + "&"
					+ ComGetPrefixParam(aryPrefix);
		var sXml=sheetObj.GetSaveData("EES_MNR_0155GS.do", sParam);
		sheetObjects[0].LoadSaveData(sXml);
	break;
	//adding row
	case IBINSERT:
		if(!validateForm(sheetObj,formObj,sAction))return;
		var Row=sheetObj.DataInsert(-1);
		sheetObj.SetCellValue(Row, "sheet2_aply_flg","1",0);//Apply
			if(sheetObjects[0].RowCount()>0)
			{
				sheetObj.SetCellValue(Row, "sheet2_mnr_prnr_cre_seq",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_mnr_prnr_cre_seq"),0);
		}
		sheetObj.SetCellValue(Row, "sheet2_ofc_cd",currOfcCd,0);
		sheetObj.SetCellValue(Row, "sheet2_mnr_cntc_prnr_nm",formObj.mnr_prnr_cnt_nm.value,0);
		sheetObj.SetCellValue(Row, "sheet2_prmry_chk_flg","N",0);
		sheetObj.SetCellValue(Row, "sheet2_cnt_cd","",0);
		//set Focus
		sheetObj.SelectCell(Row, "sheet2_ofc_cd");
		break;
		//deleting row
	case IBDELETE:
		if(validateForm(sheetObj,formObj,sAction)) {
			ComRowHideDelete(sheetObj, "del_chk");
		}
		break;
		
	}
}
function setCustomerName(){
	MnrWaitControl(true);
	nowLoad=1;
	sheetObj=sheetObjects[0];
	sheetObj.SetEnable(0);
	var Row=sheetObj.GetSelectRow()
	var formObj=document.form;
	var CustCd=ComTrimAll(formObj.mnr_prnr_cnt_cd.value," ");
	var CustSeq=ComTrimAll(formObj.mnr_prnr_seq.value," ");
	if(CustCd =="" || CustSeq =="" )
	{
		nowLoad=0;
		sheetObjects[0].SetEnable(1);
		MnrWaitControl(false);
		return;
	}
	var	sXml=MnrComCustomerInfoSearch(sheetObjects[0],CustCd,CustSeq);
	var arrResult=MnrXmlToArray(sXml);
	if(arrResult != null){
		for(var i=0; i < arrResult.length;i ++){
			formObj.mnr_prnr_seq.value=ComLpad(formObj.mnr_prnr_seq, 6, "0");
			formObj.mnr_prnr_cnt_nm.value=arrResult[i][10];
			formObj.mnr_prnr_cnt_nm.title=arrResult[i][10];
			break;
		}
	}else{
		ComShowCodeMessage("MNR00121");
		formObj.mnr_prnr_cnt_cd.value="";
		formObj.mnr_prnr_seq.value="";
		formObj.mnr_prnr_cnt_nm.value="";
		formObj.mnr_prnr_cnt_nm.title="";
		ComSetFocus(formObj.mnr_prnr_cnt_cd);
	}
	sheetObjects[0].SetEnable(1);
	MnrWaitControl(false);
	nowLoad=0;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	
		// in case of adding
			if(sAction==IBINSERT)
			{
				if(sheetObj.GetCellValue(1, "Seq")=="0" )
				{
					sheetObj.RemoveAll();
				}
				if(sheetObjects[1].GetCellValue(1, "Seq")=="0")
			{
				sheetObjects[1].RemoveAll();
			}
			var checkValue=ComTrimAll(formObj.mnr_prnr_lgl_eng_nm.value," ");
			if(checkValue=="")
			{
				nowLoad=0;
				ComShowCodeMessage("MNR00003");
				ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
				return false;
			}
			var checkValue=ComTrimAll(formObj.mnr_prnr_cnt_cd.value," ");
			if(checkValue=="")
			{
				nowLoad=0;
				ComShowCodeMessage("MNR00003");
				ComSetFocus(formObj.mnr_prnr_cnt_cd);
				return false;
			}
			var checkValue=ComTrimAll(formObj.mnr_prnr_seq.value," ");
			if(checkValue=="")
			{
				nowLoad=0;
				ComShowCodeMessage("MNR00003");
				ComSetFocus(formObj.mnr_prnr_seq);
				return false;
			}
			var checkValue=ComTrimAll(combo_mnr_prnr_knd_cd.GetSelectCode()," ");
			if(checkValue=="")
			{
				nowLoad=0;
				ComShowCodeMessage("MNR00003");
				ComSetFocus(combo_mnr_prnr_knd_cd);
				return false;
			}
			var checkValue=ComTrimAll(combo_mnr_prnr_knd_dtl_cd.GetSelectCode()," ");
			if(checkValue=="")
			{
				nowLoad=0;
				ComShowCodeMessage("MNR00003");
				ComSetFocus(combo_mnr_prnr_knd_dtl_cd);
				return false;
			}
			for(var i=sheetObjects[1].HeaderRows();i<=sheetObjects[1].LastRow();i++)
			{
				//2. in case of Office is empty
				var strCostDtlCD=ComTrimAll(sheetObjects[1].GetCellValue(i, "sheet2_ofc_cd")," ");
				if(strCostDtlCD=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00172","Office");
					sheetObjects[1].SelectCell(i, "sheet2_ofc_cd",true);
					return false;
				}
				//2. in case of BuyerName is empty
				var strCostDtlCD=ComTrimAll(sheetObjects[1].GetCellValue(i, "sheet2_mnr_cntc_prnr_nm")," ");
				if(strCostDtlCD=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00172","Name");
					sheetObjects[1].SelectCell(i, "sheet2_mnr_cntc_prnr_nm",true);
					return false;
				}
			}
		}
		//retrieving
		else if(sAction==IBSEARCH)
		{
			var sRow=sheetObj.FindStatusRow("I|U|D");  // checking sheet status
			if(sRow != "") // in case of existing edits
			{
				if(!ComShowCodeConfirm("MNR00007"))
				{
					nowLoad=0;
					return false;
				}
			}
		}
		// saving in case of confirmed
			else if(sAction==IBSAVE) {
				nowLoad=1;
				var sheetObj=sheetObjects[0];
				if(sheetObj.RowCount()==1)
				{
					if(sheetObj.GetCellValue(1, "Seq")=="0" )
					{
						sheetObj.RemoveAll();
					}
				}
				var checkValue=ComTrimAll(formObj.mnr_prnr_lgl_eng_nm.value," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
					return false;
				}
				var checkValue=ComTrimAll(formObj.mnr_prnr_cnt_cd.value," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.mnr_prnr_cnt_cd);
					return false;
				}
				var checkValue=ComTrimAll(formObj.mnr_prnr_seq.value," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(formObj.mnr_prnr_seq);
					return false;
				}
				var checkValue=ComTrimAll(combo_mnr_prnr_knd_cd.GetSelectCode()," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(combo_mnr_prnr_knd_cd);
					return false;
				}
				var checkValue=ComTrimAll(combo_mnr_prnr_knd_dtl_cd.GetSelectCode()," ");
				if(checkValue=="")
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00003");
					ComSetFocus(combo_mnr_prnr_knd_dtl_cd);
					return false;
				}
				//setting default value to '0' in case of Pay Term is empty
				var checkValue=ComTrimAll(formObj.pay_term_dys.value," ");
				if(checkValue=="")
				{
					formObj.pay_term_dys.value="0";
				}
				if(!sheet1_mnr_prnr_seq_UniqueCheck(sheetObj,formObj))
				{
					nowLoad=0;
					formObj.mnr_prnr_cnt_cd.value="";
					formObj.mnr_prnr_seq.value="";
					formObj.mnr_prnr_cnt_nm.value="";
					formObj.mnr_prnr_cnt_nm.title="";
					ComSetFocus(formObj.mnr_prnr_cnt_cd);
					ComShowCodeMessage("MNR00006","Customer.");
					ComSetFocus(formObj.mnr_prnr_cnt_cd);
					return false;
				}
				var sheetObj=sheetObjects[1];
				if(sheetObj.GetCellValue(1, "Seq")=="0")
				{
					sheetObj.RemoveAll();
				}
				for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
				{
					//1. in case of Office is empty
					var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(i, "sheet2_ofc_cd")," ");
					if(strCostDtlCD=="")
					{
						nowLoad=0;
						ComShowCodeMessage("MNR00172","Office");
						sheetObj.SelectCell(i, "sheet2_ofc_cd",true);
						return false;
					}
					//2. in case of BuyerName is empty
					var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(i, "sheet2_mnr_cntc_prnr_nm")," ");
					if(strCostDtlCD=="")
					{
						nowLoad=0;
						ComShowCodeMessage("MNR00172","Name");
						sheetObj.SelectCell(i, "sheet2_mnr_cntc_prnr_nm",true);
						return false;
					}
				}
				//3.checking duplicate Control Office
				var Row=sheetObjects[1].ColValueDup("sheet2_ofc_cd",false);
				if(sheetObjects[1].IsDataModified()){
					if(Row>0){
						nowLoad=0;
						ComShowCodeMessage("MNR00006","CTRL Office of " + (Row) + " row");
						sheetObjects[1].SelectCell(Row, "sheet2_ofc_cd", true);
						return false;
					}
				}
				var rowCnt = sheetObjects[1].RowCount("R")+sheetObjects[1].RowCount("I")+sheetObjects[1].RowCount("U");
				if(rowCnt < 1)
				{
					nowLoad=0;
					ComShowCodeMessage("MNR00348");
					return false;
				}
				
				if(MnrPrnrStsCode == "X"){
					var findRow=sheetObj.FindText("sheet1_mnr_prnr_cre_seq", formObj.mnr_prnr_cre_seq.value, 0);
					if(sheetObj.GetCellValue(findRow,"sheet1_disp_proc_cnt") != "0"){
						nowLoad=0;
						ComShowCodeMessage("MNR00391");
						return false;
					}
				}
				
				if(formObj.mnr_prnr_cre_seq.value == ""){
					formObj.f_cmd.value=SEARCH01;
					var aryPrefix=new Array("sheet1_", "sheet2_");
					var sParam1=ComGetSaveString(sheetObjects, true, true);
					var sParam=FormQueryString(formObj) + "&" + sParam1 + "&" + FormQueryString(formObj)+ "&"
					+ ComGetPrefixParam(aryPrefix);
					//ComDebug(sParam);
					var sXml=sheetObj.GetSaveData("EES_MNR_0155GS.do", sParam);
					var status = ComGetEtcData(sXml,"status");
					
					if(status != ""){
						ComShowCodeMessage("MNR00388", formObj.mnr_prnr_cnt_cd.value+formObj.mnr_prnr_seq.value, status);
						return false;
					}
				}
				nowLoad=0;
				return true;
		}
		//deleting
		else if (sAction==REMOVE) {
			//1. checking row in Grid Main whether one or more
			if(sheetObj.FindCheckedRow("sheet1_checkbox") == ""){
				nowLoad=0;
				ComShowCodeMessage("MNR00038","DELETE ");
				return false;
			}
			var findRow=sheetObj.FindText("sheet1_mnr_prnr_cre_seq", formObj.mnr_prnr_cre_seq.value, 0);
			if(sheetObj.GetCellValue(findRow,"sheet1_disp_cnt") != "0"){
				nowLoad=0;
				ComShowCodeMessage("MNR00320");
				return false;
			}
			if(!ComShowCodeConfirm("MNR00026"))
			{
				nowLoad=0;
				return false;
			}
		}
		//copy
		else if (sAction=="COPY") {
			//grid whether or not
			if(!checkIsDetailRow()) {nowLoad=0;return false;}
		}
		//in case of deleting row
		else if (sAction==IBDELETE) {
			if(sheetObj.FindCheckedRow("del_chk") == ""){
				nowLoad=0;
				ComShowCodeMessage("MNR00038","DELETE ");
				return false;
			}
		}
		//in case of copying row
		else if (sAction==IBCOPYROW) {
			//grid whether or not
			if(!checkIsDetailRow()) {return false;}
		}
		//Load Excel
		else if (sAction==IBLOADEXCEL) {
			//checking status of Tariff
			if(!checkTariffStatus()) {return false;}
		}
	
	return true;
}


function clearFormObjectValues(){
	var formObj=document.form;
	formObj.mnr_prnr_cre_seq.value="";
	formObj.mnr_prnr_lgl_eng_nm.value="";
	formObj.mnr_prnr_lgl_eng_nm.title="";
	formObj.mnr_prnr_cnt_cd.value="";
	formObj.mnr_prnr_cnt_nm.title=""
	formObj.mnr_prnr_seq.value="";
	formObj.mnr_prnr_cnt_nm.value="";
	formObj.mnr_prnr_knd_cd.value="L";
	combo_mnr_prnr_knd_cd.SetSelectCode("L",false);
	formObj.mnr_prnr_knd_dtl_cd.value="";
	combo_mnr_prnr_knd_dtl_cd.SetSelectCode("",false);
	formObj.mnr_shop_flg.checked=false;
	formObj.mnr_prnr_sts_cd.value="";
	formObj.mnr_prnr_sts_nm.value="";
	formObj.bzct_nm.value="";
	formObj.bztp_nm.value="";
	formObj.empe_knt.value="";
	formObj.ownr_nm.value="";
	formObj.biz_rgst_no.value="";
	formObj.zip_cd.value="";
	formObj.phn_no.value="";
	formObj.fax_no.value="";
	formObj.mnr_prnr_eml.value="";
	formObj.mnr_bil_to_nm.value="";
	formObj.mnr_prnr_addr.value="";
	formObj.eff_dt.value="";
	formObj.exp_dt.value="";
	formObj.bank_nm.value="";
	formObj.bank_acct_no.value="";
	formObj.pay_term_dys.value="0";
	combo_pay_mzd_cd.SetSelectCode("CHK",false);
	formObj.pay_mzd_cd.value="";
	formObj.mnr_prnr_rmk.value="";
	combo_dpt_desc.SetSelectCode(" ",false);
	formObj.dpt_desc.value="";
	formObj.mnr_swift_no.value="";
	formObj.upd_dt.value="";
	formObj.ctrl_ofc_cd.value=currOfcCd;
	formObj.mnr_prnr_tp_cd.value="";
	formObj.edi_id.value="";
	formObj.mnr_prnr_locl_lang_nm.value="";
	formObj.bzet_addr.value="";
	formObj.mnr_payr_cnt_cd.value="";
	formObj.mnr_payr_seq.value="";
	formObj.mnr_prnr_capi_amt.value="";
	formObj.mnr_prnr_abbr_nm.value="";
	formObj.intl_phn_no.value="";
	formObj.intl_fax_no.value="";
	formObj.trsm_mod_cd.value="";
	formObj.file_seq.value="";
}

function setFormObjectValues(NewRow){
	if(nowLoad != 0) return;
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	if(sheetObj.RowCount()<=0) return;
	formObj.mnr_prnr_cre_seq.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_cre_seq");
	formObj.mnr_prnr_lgl_eng_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_lgl_eng_nm");
	formObj.mnr_prnr_lgl_eng_nm.title=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_lgl_eng_nm");
	formObj.mnr_prnr_cnt_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_cnt_cd");
	formObj.mnr_prnr_seq.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_seq");
	formObj.mnr_prnr_cnt_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_cnt_nm");
	formObj.mnr_prnr_cnt_nm.title=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_cnt_nm");
	formObj.mnr_prnr_knd_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_knd_cd");
	combo_mnr_prnr_knd_cd.SetSelectCode(sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_knd_cd"));
//	combo_mnr_prnr_knd_cd.SetSelectIndex("0");
	formObj.mnr_prnr_knd_dtl_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_knd_dtl_cd");
	combo_mnr_prnr_knd_dtl_cd.SetSelectCode(sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_knd_dtl_cd"));
	if(sheetObj.GetCellValue(NewRow,"sheet1_mnr_shop_flg")=="Y")
		formObj.mnr_shop_flg.checked=true;
	else if(sheetObj.GetCellValue(NewRow,"sheet1_mnr_shop_flg")=="N")
		formObj.mnr_shop_flg.checked=false;
	else
		formObj.mnr_shop_flg.checked=false;
	formObj.mnr_prnr_sts_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_sts_cd");
	formObj.mnr_prnr_sts_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_sts_nm");
	formObj.bzct_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_bzct_nm");
	formObj.bztp_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_bztp_nm");
	formObj.empe_knt.value=sheetObj.GetCellValue(NewRow,"sheet1_empe_knt");
	formObj.ownr_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_ownr_nm");
	formObj.biz_rgst_no.value=sheetObj.GetCellValue(NewRow,"sheet1_biz_rgst_no");
	formObj.zip_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_zip_cd");
	formObj.phn_no.value=sheetObj.GetCellValue(NewRow,"sheet1_phn_no");
	formObj.fax_no.value=sheetObj.GetCellValue(NewRow,"sheet1_fax_no");
	formObj.mnr_prnr_eml.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_eml");
	formObj.mnr_bil_to_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_bil_to_nm");
	formObj.mnr_prnr_addr.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_addr");
	formObj.eff_dt.value=sheetObj.GetCellValue(NewRow,"sheet1_eff_dt");
	formObj.exp_dt.value=sheetObj.GetCellValue(NewRow,"sheet1_exp_dt");
	formObj.bank_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_bank_nm");
	formObj.bank_acct_no.value=sheetObj.GetCellValue(NewRow,"sheet1_bank_acct_no");
	if(sheetObj.GetCellValue(NewRow,"sheet1_pay_term_dys")=="")
	{
	formObj.pay_term_dys.value="0";
	}else{
		formObj.pay_term_dys.value=sheetObj.GetCellValue(NewRow,"sheet1_pay_term_dys");
	}
	formObj.pay_mzd_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_pay_mzd_cd");
	combo_pay_mzd_cd.SetSelectCode(sheetObj.GetCellValue(NewRow,"sheet1_pay_mzd_cd"),false);
	formObj.mnr_prnr_rmk.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_rmk");
	formObj.dpt_desc.value=sheetObj.GetCellValue(NewRow,"sheet1_dpt_desc");
	combo_dpt_desc.SetSelectCode(sheetObj.GetCellValue(NewRow,"sheet1_dpt_desc"),false);
	formObj.mnr_swift_no.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_swift_no");
	formObj.upd_dt.value=sheetObj.GetCellValue(NewRow,"sheet1_upd_dt");
	formObj.ctrl_ofc_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_ctrl_ofc_cd");
	formObj.mnr_prnr_tp_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_tp_cd");
	formObj.edi_id.value=sheetObj.GetCellValue(NewRow,"sheet1_edi_id");
	formObj.mnr_prnr_locl_lang_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_locl_lang_nm");
	formObj.bzet_addr.value=sheetObj.GetCellValue(NewRow,"sheet1_bzet_addr");
	formObj.mnr_payr_cnt_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_payr_cnt_cd");
	formObj.mnr_payr_seq.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_payr_seq");
	formObj.mnr_prnr_capi_amt.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_capi_amt");
	formObj.mnr_prnr_abbr_nm.value=sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_abbr_nm");
	formObj.intl_phn_no.value=sheetObj.GetCellValue(NewRow,"sheet1_intl_phn_no");
	formObj.intl_fax_no.value=sheetObj.GetCellValue(NewRow,"sheet1_intl_fax_no");
	formObj.trsm_mod_cd.value=sheetObj.GetCellValue(NewRow,"sheet1_trsm_mod_cd");
	formObj.file_seq.value=sheetObj.GetCellValue(NewRow,"sheet1_file_seq");
	nowLoad=0;	
	//A
	if(sheetObj.GetCellValue(NewRow,"sheet1_btn_flg") == "A"){
		ComBtnEnable("btn_retrieve");
		ComBtnEnable("btn_new");
		
		if(sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_sts_cd") == "C"){
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_remove");
			ComBtnDisable("btn_confirm");
			ComBtnEnable("btn_expire");
		}else{
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_remove");
			ComBtnEnable("btn_confirm");
			ComBtnEnable("btn_expire");
		}
		
		//B
	} else if(sheetObj.GetCellValue(NewRow,"sheet1_btn_flg") == "B"){
		ComBtnEnable("btn_retrieve");
		ComBtnEnable("btn_new");
		if(sheetObj.GetCellValue(NewRow,"sheet1_mnr_prnr_sts_cd") == "C"){
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_remove");
			ComBtnDisable("btn_confirm");
			ComBtnEnable("btn_expire");
		}else{
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_remove");
			ComBtnEnable("btn_confirm");
			ComBtnEnable("btn_expire");
		}
		//C
	} else {
		ComBtnEnable("btn_retrieve");
		ComBtnEnable("btn_new");
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_remove");
		ComBtnDisable("btn_confirm");
		ComBtnDisable("btn_expire");
	}
}

function setRowCreDtChange(){
	var formObj=document.form;
	var Row=sheetObjects[0].GetSelectRow();
	formObj.cre_dt.value=sheetObjects[0].GetCellValue(Row,"sheet1_cre_dt");
}

function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH) {
	if(nowLoad==1)return;
	var formObj=document.form;
	var sRow=sheetObjects[1].FindStatusRow("I|U|D");  // checking sheet status
	if(sRow != "") // in case of existing edits
	{
		if(!ComShowCodeConfirm("MNR00007"))
		{
			sheetObj.SelectCell(OldRow,OldCol,false);
			sheetObj.SetEnable(0);
			return false;
		}
	}
	sheetObj.SetEnable(0);
	setFormObjectValues(Row);
	formObj.f_gubuns.value="DTL";
	formObj.mnr_prnr_cre_seq.value=sheetObjects[0].GetCellValue(Row,"sheet1_mnr_prnr_cre_seq");
	doActionIBSheet(sheetObjects[1],document.form,COMMAND02);
}
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj=document.form;
	var prefix="sheet1_";
	if(sheetObjects[0].RowCount()<= 0)
	{
		ComShowCodeMessage("MNR00005", "Disposal Partner");
		ComEnableObject(formObj.mnr_prnr_lgl_eng_nm,true);
		ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
		formObj.mnr_prnr_lgl_eng_nm.className="input1";
		sheetObjects[0].RemoveAll();
		clearFormObjectValues();
	} else {
		nowLoad=0;
		var orgIbflag=sheetObj.GetCellValue(1,"sheet1_ibflag");
		sheetObj.SetCellValue(1,"sheet1_checkbox","1",0);
		sheetObj.SetCellValue(1,"sheet1_ibflag",orgIbflag,0);
		setFormObjectValues(1);
		ComEnableObject(formObj.mnr_prnr_lgl_eng_nm,false);
		formObj.mnr_prnr_lgl_eng_nm.className="input2";
	}
	var Row=sheetObj.FindText("sheet1_mnr_prnr_cre_seq", saveTextIndex);
	if(Row > 0)
	{
		sheetObj.SetSelectRow(Row);
		sheetObj.SetCellValue(Row,"sheet1_checkbox","1",0);
		sheetObj.SetCellValue(Row,"sheet1_ibflag","R",0);
		setFormObjectValues(Row);
		formObj.f_gubuns.value="DTL";
		formObj.mnr_prnr_cre_seq.value=sheetObjects[0].GetCellValue(Row,"sheet1_mnr_prnr_cre_seq");
		doActionIBSheet(sheetObjects[1],document.form,COMMAND02);
	}
	nowLoad=0;
	sheetObj.SetEnable(1);
}
function sheet1_OnChange(sheetObj,Row, Col, Value)
{
	if(nowLoad == 0)
	{
		if(sheetObj.ColSaveName(Col) == "sheet1_cre_dt")
		{
			var formObj=document.form;
			formObj.cre_dt.value=Value;
		}
	}
}
function sheet2_OnChange(sheetObj,Row, Col, Value)
{
	if(nowLoad == 0)
	{
		if(sheetObj.ColSaveName(Col) == "sheet2_ofc_cd")
		{
			//checking whether ofc_cd exists or not
			var retArray=null;
			if (Value!="")
			{
				retArray=MnrGeneralCodeCheck(sheetObj,"OFC",Value);
				if(retArray == null)
				{
					ComShowCodeMessage("MNR00165",Value);
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col,true);
				}
			}
		}
	}
}
function sheet2_OnSearchEnd(sheetObj, errMsg) {
	var formObj=document.form;
	var prefix="sheet2_";
	if(sheetObjects[0].RowCount()<=0)
	{
		ComEnableObject(formObj.mnr_prnr_lgl_eng_nm,true);
		ComSetFocus(formObj.mnr_prnr_lgl_eng_nm);
		formObj.mnr_prnr_lgl_eng_nm.className="input1";
		sheetObjects[1].RemoveAll();
	}
	formObj.f_gubuns.value="";
	nowLoad=0;
	sheetObjects[0].SetEnable(1);
}
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj=document.form;
	if(formObj.f_cmd.value == MULTI)
	{
		if (errMsg == "") {
			if(MnrPrnrStsCode=="S")
				ComShowCodeMessage("MNR00122");
			else if(MnrPrnrStsCode=="J")
				ComShowCodeMessage("MNR00267"); //reject
			else if(MnrPrnrStsCode=="C")
				ComShowCodeMessage("MNR00124");
			else if(MnrPrnrStsCode=="X")
				ComShowCodeMessage("MNR00269"); //expire
		} else {
			if(MnrPrnrStsCode=="S")
				ComShowCodeMessage("MNR00008",ErrMsg);
			else if(MnrPrnrStsCode=="J")
				ComShowCodeMessage("MNR00268",ErrMsg); //reject
			else if(MnrPrnrStsCode=="C")
				ComShowCodeMessage("MNR00025",ErrMsg);
			else if(MnrPrnrStsCode=="X")
				ComShowCodeMessage("MNR00270",ErrMsg); //expire
		}
	}
	else if(formObj.f_cmd.value == REMOVE)
	{
		if (errMsg == "") {
			ComShowCodeMessage("MNR00127");
		} else {
			ComShowCodeMessage("MNR00027",ErrMsg);
		}
	}
	MnrPrnrStsCode="";
	nowLoad=0;
	MnrWaitControl(false);
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}
function sheet1_OnPopupClick(sheetObj, Row,Col){
	if (sheetObj.ColSaveName(Col) != "sheet1_cre_dt")
	{
		return;
	}
	var cal=new ComCalendarGrid();
	cal.setEndFunction("setRowCreDtChange");
	cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
}
/**
 * verification Uniqueness for Customer Code
 */
function sheet1_mnr_prnr_seq_UniqueCheck(sheetObj,formObj){
	var mnr_prnr_cnt_cd=formObj.mnr_prnr_cnt_cd.value; //setting empty in case of retrieving pure list
	var mnr_prnr_seq=formObj.mnr_prnr_seq.value; //setting empty in case of retrieving pure list
	var sParam="";
	var aryPrefix=new Array("sheet1_");
	sParam += ComGetPrefixParam(aryPrefix)+ "&" + "f_cmd="+SEARCH+"&f_gubuns=EXIST&mnr_grp_tp_cd=DSP&mnr_prnr_cnt_cd="+ mnr_prnr_cnt_cd + "&mnr_prnr_seq="+mnr_prnr_seq;
	var sXml=sheetObj.GetSearchData("EES_MNR_0155GS.do", sParam);
	arrDataSearchDbXml=sXml.split("|$$|");
	var Slength=arrDataSearchDbXml[0].indexOf("TOTAL='");
	var intSize=arrDataSearchDbXml[0].substring(Slength + 7,Slength + 8);
	if(intSize>0 )
	{
		var retValue=MnrXml2ComboString(sXml, "sheet1_mnr_prnr_cre_seq", "sheet1_vndr_seq");
		if (retValue != null)
		{
			if(retValue[0].split("|")[0]!=formObj.mnr_prnr_cre_seq.value)
			{
				return false;
			}
		}
	}
	if(intSize>1 )
	{
		return false;
	}
	return true;
}
