/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0079_09.js
 *@FileTitle  : Cancel Issue Release
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/28
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
 * @author CLT
 */
/**
 * @extends
 * @class ESM_BKG_0079_09 : business script for ESM_BKG_0079_09
 */
// Common global variable
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var prefix1="t11sheet1_";
var prefix2="t11sheet2_";
var prefix3="t11sheet3_";
var prefix4="";
var sheetNames=new Array("t11sheet1");
var tab_alert_msg=false;
// Event handler processing by button click event */
document.onclick=checkLoad;
function checkLoad(){	//'target' undefined error
	var readyState = document.readyState;
	if(readyState != 'interactive' && readyState != 'complete') {
		setTimeout("checkLoad()", 100);
	}
	else {
		processButtonClick();
	}
}
//Event handler processing by button name */


/**
 * initializing sheet implementing onLoad event handler in body tag 
 * adding first-served functions after loading screen.
 */
function loadPage() {
	//------------------------------------------------>
	// ------------------------------------------------>
    // IBMultiCombo initialization
    for(var j=0;j<comboObjects.length;j++){
        initCombo(comboObjects[j],j+1);
    }
    //------------------------------------------------>
	//  Preferences change the name of the function to start
    for(i=0;i<sheetNames.length;i++){
		ComConfigSheet (sheetObjects[sheetNames[i]] );
		initSheet(sheetObjects[sheetNames[i]],i+1);
	    ComEndConfigSheet(sheetObjects[sheetNames[i]]);	//  The final configuration functions added
	}
	//------------------------------------------------>
	// combo box Setting the Value
	setComboDefault();
	
	// initialization control
	initControl();

	// ------------------------------------------------>
	var formObj=document.form;
	if(formObj.bkg_no.value != ""){ 
		ComSetObjValue(formObj.frm_t11sheet1_bkg_no ,formObj.bkg_no.value);
		doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
	}
	//------------------------------------------------>
	// setInquiryDisableButton event call
	if(ComGetObjValue(formObj.isInquiry) == "Y"){
		setInquiryDisableButton();
	}
	
	// checkHtml5RDPass

	ComSetUIItem(sheetObjects['t11sheet1'],document.form, "BKG","ESM_BKG_0079_09");
}
function setComboDefault() {  
	var formObj=document.form;
	var sXml=document.frm.sXml.value;
	var arrXml=sXml.split("|$$|");    
	if (arrXml.length > 0){
		ComBkgXml2ComboItem(arrXml[0], on_board_type, "val", "name");
	}
	if (arrXml.length > 1){
		ComBkgXml2ComboItem(arrXml[1], bl_ready_type, "val", "name");			
	}  	
	if (arrXml.length > 2){
		ComBkgXml2ComboItem(arrXml[3], move_type, "val", "name");			
	}
	if (arrXml.length > 3){
		ComBkgXml2ComboItem(arrXml[4], bl_issuebl_type, "val", "name");			
	}
}
/**
* set the initial control
**/
var bkgMAP=null;
function initControl() {
	//** Date Delimiter **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObj); //
	//axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //
	axon_event.addListenerForm('keydown', 'check_Enter', formObj);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj);
	axon_event.addListenerForm('blur', 'bkg007909_blur',  formObj); //- out  focus
	bl_ready_type.SetColWidth(0, "30");
	bl_ready_type.SetColWidth(1, "100);//B/LREADY(Type");
	on_board_type.SetColWidth(0, "30");
	on_board_type.SetColWidth(1, "200);//ONBOARD(Type");
	move_type.SetColWidth(0, "30");
	move_type.SetColWidth(1, "170);//Move Type");
	
	/**
	 * separate processing paths disabled menu  ComBtnDisable("btn_t11Save");
	 * ComBtnDisable("btn_t11Issuer_Set");
	 */
	buttonDisabledAll();
	/*
	 * The default setting (SELECT ATTR_CTNT1,ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT WHERE
	 * HRD_CDG_ID = 'OBL_RCV_TP_CD')
	 */
	bkgMAP=new fnBkgJsMap();
	bkgMAP.put('B', 'Original B/L');
	bkgMAP.put('W', 'Seaway Bill');
	bkgMAP.put('L', 'LG/LOI');
	applyShortcut();
	
	//btn_t11FtpSend 버튼 셋팅
//	if(formObj.inetFtpAuthFlg.value=="Y"){
//		ComBtnEnable("btn_t11FtpSend");
//	}
}
//registering IBCombo Object as list
function setComboObject(combo_obj){
   comboObjects[comboCnt++]=combo_obj;
}
/**
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
*/
function setSheetObject(sheet_obj) {
	 sheetObjects[sheet_obj.id]=sheet_obj;
}
/**
* Setting up the initial initCombo
**/
function initCombo(comboObj, comboNo) {
    comboObj.RemoveAll();
    comboObj.SetUseEdit(1);
    comboObj.IMEMODE=0;			// IMEMODE=English
    comboObj.SetMaxLength(30);
    // comboObj.FontColor = "red";
}
 /**
 * All buttons on the screen non-activated.
 **/
 function buttonDisabledAll(){
	var formObj=document.form;
//	ComBtnDisable("btn_t11OBLRelease");
	ComBtnDisable("btn_t11BLRelease");
	ComBtnDisable("btn_t11CancelRelease");
//	ComBtnDisable("btn_t11SWBRelease");
	ComBtnDisable("btn_t11SWBEmail");
	ComBtnDisable("btn_t11OBLSurrender");
	ComBtnDisable("btn_t11Issue");	
	ComBtnDisable("btn_t11InternetAUTH");
	ComBtnDisable("btn_t11CancelAUTH");
	ComBtnDisable("btn_t11FtpSend");
 }
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	try {
		switch (sheetID) {
			case "t11sheet1": //t1sheet1 init
				with(sheetObj){
					var HeadTitle1="|||||||||||||||||||||||||||||||||||||||";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"tvvd" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_sts" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bdr" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"shpr_name" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"shpr_address" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"f_fwd_name" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"f_fwd_address" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"vessel_direction" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pre_carriage_by" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"por_code" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"por_name" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pol_code" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pol_name" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pod_code" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pod_name" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"del_code" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"del_name" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"move_type" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"final_dest" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ppd_rcv" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ppd_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ppd_by" },
					 {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"ppd_date",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ppd_confirm" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_ppd_rcv" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_ppd_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_ppd_by" },
					 {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"trd_ppd_date",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_ppd_confirm" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cct_rcv" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cct_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cct_by" },
					 {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"cct_date",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cct_confirm" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_cct_rcv" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_cct_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_cct_by" },
					 {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"trd_cct_date",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_cct_confirm" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_ready_checkbox" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_ready_by" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_ready_date" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_ready_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_ready_type" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"doc_proc_modyflg" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"doc_proc_type" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"doc_proc_seq" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_proofbyshipper_checkbox" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_proofbyshipper_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_proofbyshipper_by" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_proofbyshipper_date" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"on_board_type" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"on_board_date" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_issuebl_type" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_iss_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_issue_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_cpy_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_issue_date" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_issue_release" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_issue_at" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_issue_by" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"issued" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"released" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"o_blreceive_type" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"o_blreceive_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"o_blreceive_date" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"o_blreceive_at" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"o_blreceive_by" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"surrender" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"do_issue_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"do_issue_date" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"do_issue_at" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"do_issue_by" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"print_option" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"doc_request_flag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"auth_flag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"internet_auth" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"tpb_indicator" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"tpb_status" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"black_customer_flag" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"pol_etd_dt" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"flg_rate" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"flg_md" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"flg_ppd" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"flg_to_order" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"flg_do" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_prn_flg" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cust_to_ord_flg" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ppd_rcv_user_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ppd_rcv_user_id" },
					 {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"ppd_rcv_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_ppd_rcv_user_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_ppd_rcv_user_id" },
					 {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"trd_ppd_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cct_rcv_user_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cct_rcv_user_id" },
					 {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"cct_rcv_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_cct_rcv_user_office" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"trd_cct_rcv_user_id" },
					 {Type:"Date",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix1+"trd_cct_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cntc_pson_eml" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_iss_rmk" }, 
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"inet_ctrl_pty_nm" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"inet_ctrl_pty_no" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"inet_ctrl_pty_cust_nm" }, 
		             {Type:"Text", 		Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_mv_tp_prn_flg"},
		             {Type:"Text",  	Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rcv_de_term_prn_flg"},
		             {Type:"Text",  	Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rqst_bl_tp_cd"},
					{Type:"Text",  	Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"iss_save_flg"}];
					   
					InitColumns(cols);
					SetVisible(0);
					SetEditable(1);
				}
			break;
		}
	} catch (ex) {
		fnBkgErrorAlert('initSheet', ex);
	}
}
 /**
 * btn_Authorize Event
 * param :
 */
function btn_Authorize(){
	var sheetObj=sheetObjects['t11sheet1'];	


//	doActionIBSheet(sheetObj, document.form, MULTI01);
	//2014.11.28 change the command code to show in-process image
	doActionIBSheet(sheetObj, document.form, MULTI02);

}
 var isShowOrgBlNo=true;
 var returnValue ;
// Event handler processing by button name */
function processButtonClick() {
	var formObj=document.form;
	var sheetObject1=sheetObjects['t11sheet1'];	
	var obj = event.target || event.srcElement;
	   if ($(obj).prop('disabled')) {
	 return;
	 }
	var srcName=ComGetEvent("name");
	try {
		ComSetObjValue(formObj.buttonType, srcName); 
		//Validation Check
		if(!processValidate(srcName)) return; 
		if("btn_t11CancelRelease" != srcName 
			&& "btn_t11OBLSurrender" != srcName 
			&& "btn_t11CancelAUTH" != srcName
			&& "btn_t11InternetAUTH" != srcName
//			&& "btn_t11OBLRelease" != srcName	
			&& "btn_t11BLRelease" != srcName
		){
			processStatus(srcName);
			fnBlIssueButton() ;
		}
		ComSetObjValue(formObj.f_cmd, SEARCH);
		ComSetObjValue(formObj.setupfocoblflag, '');
		if(srcName != "btn_splitPop"){
    		if(layList.style.display != "none"){
    			layList.style.display="none";
    		}    	    			
		}
		switch (srcName) {
		/** * POP UP BL ISSUE (S) ** */
		case "btn_splitPop":
			doActionIBSheet(sheetObject1,formObj,COMMAND03);					
			break;           
//		case "btn_OrgBlPop":
//			if(isShowOrgBlNo){
//				blNoSet();
//				isShowOrgBlNo=false;
//			}else{
//				blNoHide();
//				isShowOrgBlNo=true;
//			}					
//			break;	
		case "pop_on_board_date":
			var cal=new ComCalendar();
			cal.select(formObj.frm_t11sheet1_on_board_date, 'yyyy-MM-dd');
			break;
		case "pop_bl_issue_date":
			var _cal=new ComCalendar();
			_cal.select(formObj.frm_t11sheet1_bl_issue_date, 'yyyy-MM-dd');
			break;
		case "pop_bl_ready_date":
			var _cal=new ComCalendar();
			_cal.select(formObj.frm_t11sheet1_bl_ready_date, 'yyyy-MM-dd');
			break;
		case "pop_bl_proofbyshipper_date":
			var _cal=new ComCalendar();
			_cal.select(formObj.frm_t11sheet1_bl_proofbyshipper_date, 'yyyy-MM-dd');
			break;			
		case "pop_bkg_no":
			fnSetSelectNumberBox('span_bkg_no', 'text_bkg_no');
			break;
		case "pop_bl_no":
			fnSetSelectNumberBox('span_bl_no', 'text_bl_no');
			break;
		case "pop_pol":
			/*1. MDM_LOCATION Content change as POL_CD name 
			 */
			fnSearchMdmLocName('pol');
			break;
		case "pop_pod":
			/* 1. MDM_LOCATION Content change as POD_CD name 
			 */
			fnSearchMdmLocName('pod');
			break;
		case "pop_por":
			/*1. MDM_LOCATION Content change as POR_CD name 
			 */
			fnSearchMdmLocName('por');
			break;
		case "pop_del":
			/* 1. MDM_LOCATION Content change as DEL_CD name 
			 */
			fnSearchMdmLocName('del');
			break;
		case "pop_tpb":
			/*BKG No. RHQ(User  office RHQ),  3rd Party Type ?쏞ustomer??/
	/*
	 * var otsStsCd = ""; if (document.form.tpb_status.value == "1") { otsStsCd =
	 * "P"; } else { otsStsCd = "T"; }
	 * 
	 * var pgmNo = "&pgmNo=ESD_TPB_0116" var param =
	 * "s_bkg_no_all="+ComGetObjValue(formObj.bkg_no) +"&s_ots_sts_cd="+
	 * otsStsCd +"&s_state=BKG" +"&s_n3pty_src_sub_sys_cd=TRS"
	 * +"&s_n3pty_src_sub_sys_cd_check=TRS" ; var url = "ESD_TPB_0116.do?" +
	 * param + pgmNo; ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" +
	 * _Width + "px; dialogHeight:" + _Height + "px", true);
	 */
	// pop up UI
			var _Width='1024';
			var _Height='468';
			var param='s_state=BKG'+'&s_bkg_no_all=' + ComGetObjValue(formObj.bkg_no)+ '&s_ots_sts_cd=T&pgmNo=ESD_TPB_0134';
			// var url = "ESM_BKG_0292_02.do?" + param;			
			var url="ESD_TPB_0134.do?" + param;
			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
			break;
		/** * Btn BL ISSUE (S) ** */
		case "btn_t11Doc_Requirement":
			/*Pop-up result value B/L Type setting*/
			var param='bkg_no=' + ComGetObjValue(formObj.bkg_no)+"&bl_iss_tp_cd="+ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd);
			var url="ESM_BKG_0059.do?" + param;
			var rValue = ComOpenPopup(url, 470, 500, "getBKG_0059","1,0", true);
			getBKG_0059(rValue);
			break;
		case "btn_t11TS_Route":
			/*TS Route  : 1. running Pop-up */
			var param='bkg_no=' + ComGetObjValue(formObj.bkg_no);
			var url="ESM_BKG_0650.do?" + param;
			ComOpenPopup(url, 740, 330, "","1,0", true);
			break;
		case "btn_t11Issuer_Set":
			//1. B/L Issue -> 'Date/At/By'  Set the current user's information
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_by, ComGetObjValue(formObj.strUsr_id));
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_at, ComGetObjValue(formObj.strOfc_cd));
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_date, ComGetNowInfo());
			break;
		case "btn_t11Issue":
			var blIssTpCd = formObj.frm_t11sheet1_bl_iss_tp_cd.value;
			var rqstBlTpCd = sheetObjects['t11sheet1'].GetCellValue(1,prefix1+"rqst_bl_tp_cd");
			if(rqstBlTpCd == "O" || rqstBlTpCd == "S"){
				rqstBlTpCd = "B";
			}
			if(rqstBlTpCd != blIssTpCd && !ComIsNull(rqstBlTpCd)){
				if (!ComShowConfirm(ComGetMsg("BKG01189"))) {//"B/L Type is different from B/L Type of Doc Req.\nWould you like to continue this?";
					ComBtnEnable("btn_t11Issue");
					return;
				}
			}
			var result = validateToyotaBl();
			if(result == "N"){
				return false;
			}
			doActionIBSheet(sheetObject1, document.form, MULTI01);
			break;
		case "btn_t11Retrieve":
			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			ComSetFocus(formObj.frm_t11sheet1_bkg_no);
			break;
		case "btn_t11New":
			ComResetAll();
			ComSetObjValue(document.getElementById("frm_t11sheet1_bkg_no"),"");
//			eval('DIV_btn_t11InternetAUTH').style.display = 'block';
//			eval('DIV_btn_t11CancelAUTH').style.display = 'none';
			document.all.btn_t11InternetAUTH.style.display="";
			document.all.btn_t11CancelAUTH.style.display="none";
			
			try{
				parent.initIssueCAControl("", "N", "N", "N", "");
			}catch(e){}
//			ComSetFocus(frm_t11sheet1_bkg_no);
			document.getElementById("frm_t11sheet1_bkg_no").focus();
			break;
		case "btn_t11Save":
			var blIssTpCd = formObj.frm_t11sheet1_bl_iss_tp_cd.value;
			var rqstBlTpCd = sheetObjects['t11sheet1'].GetCellValue(1,prefix1+"rqst_bl_tp_cd");
			if(rqstBlTpCd == "O" || rqstBlTpCd == "S"){
				rqstBlTpCd = "B";
			}
			if(rqstBlTpCd != blIssTpCd && !ComIsNull(rqstBlTpCd)){
				if (!ComShowConfirm(ComGetMsg("BKG01189"))) {//"B/L Type is different from B/L Type of Doc Req.\nWould you like to continue this?";
					return;
				}
			}
			if(ComGetBtnDisable("btn_t11Save")){
				return false;
			}
			
			tab_alert_msg=true;
			doActionIBSheet(sheetObject1, document.form, IBSAVE);
			break;
		case "btn_t11BLPreview":
			if(ComGetBtnDisable("btn_t11BLPreview")){
				return false;
			}
			var _Width='540';
			var _Height='530';
			var bl_iss_tp_cd=ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd);
			if ("B"==bl_iss_tp_cd) bl_iss_tp_cd="D";
			var param='bkg_no='+ComGetObjValue(formObj.bkg_no)+'&bl_no='+ComGetObjValue(formObj.bl_no)+'&bl_iss_tp_cd='+bl_iss_tp_cd; 
			ComOpenWindow("/opuscntr/ESM_BKG_0927.do?" + param, "PopupEsmBkg0927", "width=916, height=750, scrollbars=no", false);
			break;
		case "btn_t11BLRelease":
			var blIssTpCd = formObj.frm_t11sheet1_bl_iss_tp_cd.value;
			var rqstBlTpCd = sheetObjects['t11sheet1'].GetCellValue(1,prefix1+"rqst_bl_tp_cd");
			if(rqstBlTpCd == "O" || rqstBlTpCd == "S"){
				rqstBlTpCd = "B";
			}
			if(rqstBlTpCd != blIssTpCd && !ComIsNull(rqstBlTpCd)){
				if (!ComShowConfirm(ComGetMsg("BKG01189"))) {//"B/L Type is different from B/L Type of Doc Req.\nWould you like to continue this?";
					return;
				}
			}
			if(ComGetBtnDisable("btn_t11BLRelease")){
				return false;
			}
			ComSetObjValue(formObj.setupfocoblflag, 'Y');
			doActionIBSheet(sheetObject1, document.form, MULTI01);
			break;
			
//		case "btn_t11OBLRelease":
//			if(ComGetBtnDisable("btn_t11OBLRelease")){
//				return false;
//			}
//			ComSetObjValue(formObj.setupfocoblflag, 'Y');
//			doActionIBSheet(sheetObject1, document.form, MULTI01);
//			break;
		case "btn_t11FtpSend":
			if(ComGetBtnDisable("btn_t11FtpSend")){
				return false;
			}
//			doActionIBSheet(sheetObject1, document.form, MULTI03);
			doActionIBSheet(sheetObject1, document.form, COMMAND11);
			break;
		case "btn_t11InternetAUTH":
			ComSetObjValue(formObj.setupfocoblflag, 'Y');// by 추가요청
			if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_black_customer_flag)) {
				ComShowCodeMessage("BKG01036");
			}
			
			if ('R' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)
			) {	
				ComShowCodeMessage("BKG00468");
			}
			
			/*
			 * 			var _Width='1024';
			var _Height='468';
			var param='s_state=BKG'+'&s_bkg_no_all=' + ComGetObjValue(formObj.bkg_no)+ '&s_ots_sts_cd=T&pgmNo=ESD_TPB_0134';
			// var url = "ESM_BKG_0292_02.do?" + param;			
			var url="ESD_TPB_0134.do?" + param;
			ComOpenWindow(url, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);

			 */
			var _Width = '1020';
			var _Height = '800';
			var param = "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&bl_no=" + ComGetObjValue(formObj.bl_no);
			var pgmNo = "&pgmNo=ESM_BKG_1074";
			var url = "ESM_BKG_1074.do?" + param + pgmNo;
			
			ComOpenPopup(url, _Width, _Height, "","1,0", true);

			break;

		case "btn_t11CancelAUTH":
			ComSetObjValue(formObj.setupfocoblflag, 'Y');// by 추가요청
			/* 1. 변경된 정보가 있을 경우 저장 호출 */
			var param = 'bl_no=' + ComGetObjValue(formObj.frm_t11sheet1_bl_no);
			param += "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
			param += "&isPopUp=Y";
			param += "&frm_t11sheet1_surrender=" + ComGetObjValue(formObj.frm_t11sheet1_surrender);
			param += "&frm_t11sheet1_issued=" + ComGetObjValue(formObj.frm_t11sheet1_issued);
			param += "&frm_t11sheet1_flg_do=" + ComGetObjValue(formObj.frm_t11sheet1_flg_do);
			param += "&frm_t11sheet1_bl_issue_no=" + ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no);
			
			var url = "ESM_BKG_0649_POP.do?" + param;
			ComOpenPopup(url, "850", "500", 'getBKG_0649', '0,0', true, true, 0,"", 1);
			
//			returnValue = ComOpenPopup(url, _Width, _Height, 'getBKG_0649', '0,0', true, true, 0,"", 1);
//			getBKGreturnValue(returnValue,srcName);

			break;				
		case "btn_t11CancelRelease":
			if(ComGetBtnDisable("btn_t11CancelRelease")){
				return false;
			}
			ComSetObjValue(formObj.setupfocoblflag, 'Y');
			var do_value='Y'
				if("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do) 
				|| "L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type)){
					do_value='N'
				}
			var param='bl_no=' + ComGetObjValue(formObj.frm_t11sheet1_bl_no);
			param += "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
			param += "&isPopUp=Y";
			param += "&frm_t11sheet1_surrender=" + ComGetObjValue(formObj.frm_t11sheet1_surrender);
			param += "&frm_t11sheet1_issued=" + ComGetObjValue(formObj.frm_t11sheet1_issued);
			param += "&frm_t11sheet1_released=" + ComGetObjValue(formObj.frm_t11sheet1_released);
			param += "&frm_t11sheet1_flg_do=" + ComGetObjValue(formObj.frm_t11sheet1_flg_do);
			//param += "&frm_t11sheet1_flg_do=" + do_value;
			param += "&frm_t11sheet1_bl_issue_no=" + ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no);
			var url="ESM_BKG_0649_POP.do?" + param;
			ComOpenPopup(url, "850", "500", 'getBKG_0649', '0,0', true, true, 0,"", 1);
//			getBKGreturnValue(returnValue,srcName);
			break;
//		case "btn_t11SWBRelease":
//			ComSetObjValue(formObj.setupfocoblflag, 'Y');
//			doActionIBSheet(sheetObject1, document.form, MULTI01);
//			break;
		case "btn_t11SWBEmail":
			var param='bkg_no=' + ComGetObjValue(formObj.bkg_no) + '&docType=W';
			var url="ESM_BKG_0095.do?" + param;
			ComOpenPopup(url, 990, 700, "","1,0", true);
			break;
		case "btn_t11OBLSurrender":
			/*
			1. Black Customer Flag -> 'Y'-> Message[BKG01036]
			2. Open Pop-Up
			(
			 * Surrender  'Y' check
			 * Button and Flag setting
			)"
			 */
			if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_black_customer_flag)) {
				ComShowCodeMessage("BKG01036");
			}
			var param='bkg_no=' + ComGetObjValue(formObj.bkg_no);
			param += "&isPopUp=Y";
			var url="ESM_BKG_0400_POP.do?" + param;
			ComOpenPopup(url, 900, 350, "","1,0", true);
			break;
		case "btn_t11BLPrint":
			/*	
			1. Release Flag 
			2. Script a common reference
			 */
			if(ComGetBtnDisable("btn_t11BLPrint")){
				return false;
			}
//			var _Width='650';
//			var _Height='800';
			var param="bkg_no=" + ComGetObjValue(formObj.bkg_no) +"&bl_no="+ ComGetObjValue(formObj.bl_no);
			var url="ESM_BKG_0743.do?" + param;
			ComOpenWindowCenter(url, "ESM_BKG_0743", 650, 450, true);
		break;
		case "btn_inetCtrlPtyNo":
			var custCntCd = formObj.frm_t11sheet1_inet_ctrl_pty_nm.value;
			var custSeq = formObj.frm_t11sheet1_inet_ctrl_pty_no.value;
			var custNm = "";
			var custAddr = "";
			if(ComChkLen(formObj.frm_t11sheet1_inet_ctrl_pty_cust_nm) != 1){
				custNm=ComGetObjValue(formObj.frm_t11sheet1_inet_ctrl_pty_cust_nm).substring(0,10);
			}else{
				custNm=ComGetObjValue(formObj.frm_t11sheet1_inet_ctrl_pty_cust_nm);
			}
			var url="ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr=";    					
			ComOpenPopup(url,970, 655, "callBackIc0192","0,0,1,1,1", true);
			break;   
		case "btn_t11Remark":
			if ('' == ComGetObjValue(formObj.frm_t11sheet1_bkg_no)) {
				ComShowCodeMessage("BKG01036");
				return;
			}
			if ('' == ComGetObjValue(formObj.frm_t11sheet1_por_code)) {
				ComShowCodeMessage("BKG06133","POR");
				return;
			}
			if ('' == ComGetObjValue(formObj.frm_t11sheet1_pol_code)) {
				ComShowCodeMessage("BKG06133","POL");
				return;
			}
			if ('' == ComGetObjValue(formObj.frm_t11sheet1_pod_code)) {
				ComShowCodeMessage("BKG06133","POD");
				return;
			}
			if ('' == ComGetObjValue(formObj.frm_t11sheet1_del_code)) {
				ComShowCodeMessage("BKG06133","DEL");
				return;
			}
			
			var param = "?func=callbackRemark&bkg_no="+formObj.frm_t11sheet1_bkg_no.value
			          + "&por_cd="+formObj.frm_t11sheet1_por_code.value
			          + "&pol_cd="+formObj.frm_t11sheet1_pol_code.value
			          + "&pod_cd="+formObj.frm_t11sheet1_pod_code.value
			          + "&del_cd="+formObj.frm_t11sheet1_del_code.value
			          ;
			var url="ESM_BKG_0179.do"+param;

			ComOpenWindow(url, "ESM_BKG_0179", "dialogWidth:700px;dialogHeight:500px;", true);
			break;
			
		} // end switch
	} catch (e) {
//		if (e == "[object Error]") {
//			ComShowMessage(OBJECT_ERROR);
//			fnBkgErrorAlert('processButtonClick', e);
//		} else {
//			fnBkgErrorAlert('processButtonClick', e);
//		}
		if( e.name == "TypeError") {
			return false;
		}else{
    		ComShowMessage(e.message);
		}
	}
}

function callbackRemark(retVal){
	var formObj = document.form;
	var old_rmk = ComGetObjValue(formObj.frm_t11sheet1_obl_iss_rmk);
	
	if(old_rmk != retVal){
		ComSetObjValue(formObj.frm_t11sheet1_obl_iss_rmk, retVal);
		document.form.modify_flag.value="Y";	//변경사항 체크
	}
}

function getBKG_0649(returnVal){
	var formObj=document.form;
	var srcName = ComGetObjValue(formObj.buttonType);
	if(returnVal==null) return false;
	if(returnVal.msg == "OK"){
//		if(processStatus("btn_t11CancelRelease")){
		if(processStatus(srcName)){
			ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, '');
			ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, '');
			doActionIBSheet(sheetObjects['t11sheet1'], document.form, MULTI01);
		}
	}
}
/**
 * processValidate Event
 * param :comObj
 */
function processValidate(_action){
	var formObj=document.form;
	if(_action == null) return;
	if(
		!(_action == "frm_t11sheet1_bkg_no" 
		|| _action == "frm_t11sheet1_bl_no"
		|| _action == "pop_bl_no"
		)
	){
/*
		if(ComIsEmpty(formObj.frm_t11sheet1_bkg_no.value)){
			ComShowCodeMessage("BKG08019");
			return false;
		}
*/	
	}
	switch (_action) {
		case "btn_t11Save":
			if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date) && 
				'' != ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date) &&
				(ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date) < ComGetObjValue(formObj.frm_t11sheet1_on_board_date))){
				ComShowCodeMessage("BKG00476");// Issue Date should be later than
												// On-Board Date.
				ComSetFocus(formObj.frm_t11sheet1_bl_issue_date);
				return; 
			}
			var mnd_cnt=ComGetObjValue(formObj.mnd_cnt);
			var rate_cnt=ComGetObjValue(formObj.rate_cnt);
			var cntr_cnt=ComGetObjValue(formObj.cntr_cnt);
			var cust_cnt=ComGetObjValue(formObj.cust_cnt);
			// check box : bl_ready_checkbox
			if (formObj.bl_ready_checkbox.checked) {
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "Y");
			} else {
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "N");
			}
			if((ComGetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox)== "Y") && 
				(mnd_cnt == 0||rate_cnt == 0||cntr_cnt == 0||mnd_cnt == 0||cust_cnt == 0)){
				formObj.bl_ready_checkbox.checked=false
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_office, "");
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_by, "");
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_date, "");
				ComSetFocus(formObj.frm_t11sheet1_bl_ready_checkbox);
				ComShowCodeMessage("BKG08145");// "B/L is not completed."
				return false;
			}	
			
			//2015.04.07 kimtaekyun checking input length
        	if( ComChkLenByByte(ComGetObjValue(formObj.frm_t11sheet1_obl_iss_rmk), 3500) == 0){
                ComShowCodeMessage("COM12142","Remarks(s)","3500");
                return false;
            }
			
			// check logic -- B/L DATA COMPLETE - ISSUE 할때만 처리 하는 걸로 변경함.
//			if(ComGetObjValue(formObj.frm_t11sheet1_issued) != ""){
//				if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_flg_md) &&
//					'Y' == ComGetObjValue(formObj.frm_t11sheet1_flg_rate) &&
//					'' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date)) 
//				{
//					if(ComIsEmpty(formObj.frm_t11sheet1_bl_ready_office.value) 
//						|| ComIsEmpty(formObj.frm_t11sheet1_bl_ready_by)
//						|| ComIsEmpty(formObj.frm_t11sheet1_bl_ready_date)
//						|| ComIsEmpty(formObj.frm_t11sheet1_bl_ready_type))
//					{
//						ComShowCodeMessage("BKG00445","\"B/L DATA COMPLETE\"");	//Please input {?msg1}.
//						return false;
//					}
//				}
//			}
			
			break;
		case "btn_t11Issue": 
			if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date) && 
				'' != ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date) &&
				(ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date) < ComGetObjValue(formObj.frm_t11sheet1_on_board_date))){
				ComShowCodeMessage("BKG00476");// Issue Date should be later than
												// On-Board Date.
				ComSetFocus(formObj.frm_t11sheet1_bl_issue_date);
				return; 
			}
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
				ComShowCodeMessage("BKG08077");// M&D data is not Ready
				return false;
			}
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
				ComShowCodeMessage("BKG08078");// Rate Data is not Ready
				return false;
			}
			if(ComIsEmpty(formObj.frm_t11sheet1_bl_ready_office.value)){
				ComShowCodeMessage("BKG08320");// "B/L Data Complete information is not 
				                               // ready";
				ComSetFocus(formObj.frm_t11sheet1_bl_ready_office);
				return;
			}
			if(ComIsEmpty(formObj.frm_t11sheet1_bl_ready_by.value)){
				ComShowCodeMessage("BKG08320");// "B/L Data Complete information is not 
											   // ready";
				ComSetFocus(formObj.frm_t11sheet1_bl_ready_by);
				return;
			}
			if(ComIsEmpty(formObj.frm_t11sheet1_bl_ready_date.value)){
				ComShowCodeMessage("BKG08320");// "B/L Data Complete information is not 
				                               // ready";
				ComSetFocus(formObj.frm_t11sheet1_bl_ready_date);
				return;
			}

			if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_by.value)){
				ComShowCodeMessage("BKG08072");// "B/L Issue information is not
												// ready";
				ComSetFocus(formObj.frm_t11sheet1_bl_issue_by);
				return;
			}
			if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_at.value)){
				ComShowCodeMessage("BKG08072");// "B/L Issue information is not
												// ready";
				ComSetFocus(formObj.frm_t11sheet1_bl_issue_at);
				return;
			}
			if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_date.value)){
				ComShowCodeMessage("BKG08072");// "B/L Issue information is not
												// ready";
				ComSetFocus(formObj.frm_t11sheet1_bl_issue_date);
				return;
			}
			if(ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)=="B"&&(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_no.value)|| 0 == ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no))){
				ComShowCodeMessage("BKG08109");// Please check No. of B/L
				ComSetFocus(formObj.frm_t11sheet1_bl_issue_no);
				return;
			}else if(ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)=="W"&&ComIsEmpty(formObj.frm_t11sheet1_bl_issue_no.value)){
				ComShowCodeMessage("BKG08109");// Please check No. of B/L
				ComSetFocus(formObj.frm_t11sheet1_bl_issue_no);
				return;
			}
			//issue  (AT/BY/DATE)
			if ('A' == ComGetObjValue(formObj.frm_t11sheet1_bkg_sts)||'X' == ComGetObjValue(formObj.frm_t11sheet1_bkg_sts)||'W' == ComGetObjValue(formObj.frm_t11sheet1_bkg_sts)) {
				ComShowCodeMessage("BKG08073");// Not allowed to issue for
												// advanced/cancelled booking
				return;
			}
			if('' == ComGetObjValue(formObj.frm_t11sheet1_on_board_date)){
				ComShowCodeMessage("COM12193","ON BOARD Date");
				ComSetFocus(formObj.frm_t11sheet1_on_board_date);
				return; 
			}
			var mnd_cnt=ComGetObjValue(formObj.mnd_cnt);
			var rate_cnt=ComGetObjValue(formObj.rate_cnt);
			var cntr_cnt=ComGetObjValue(formObj.cntr_cnt);
			var cust_cnt=ComGetObjValue(formObj.cust_cnt);
			
			// check box : bl_ready_checkbox
			if (formObj.bl_ready_checkbox.checked) {
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "Y");
			} else {
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "N");
			}
			if((mnd_cnt == 0||rate_cnt == 0||cntr_cnt == 0||mnd_cnt == 0||cust_cnt == 0)){
				formObj.bl_ready_checkbox.checked=false
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_office, "");
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_by, "");
				ComSetObjValue(formObj.frm_t11sheet1_bl_ready_date, "");
				ComSetFocus(formObj.frm_t11sheet1_bl_ready_checkbox);
				ComShowCodeMessage("BKG08145");// "B/L is not completed."
				return;
			}

			break;
//		case "btn_t11OBLRelease": 
		case "btn_t11BLRelease":
			if(!fnBlNotReady()){   return;}
			//SEAWAY BILL
			if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_cust_to_ord_flg && 'W' == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd))) {
				ComShowCodeMessage("BKG00469"); 
				return false;
			}
			//Rate=Y,	M&D=Y, Fare Recovery=Y
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
				ComShowCodeMessage("BKG08078"); 
				return false;
			}
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
				ComShowCodeMessage("BKG08077");
				return false;
			}
			if (ComGetObjValue(formObj.chg_ppd_ind) > 0 && ('N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))
				||(ComGetObjValue(formObj.chg_ppd_third_ind) > 0 && 'N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))) {
//				ComShowCodeMessage("BKG08079") 
//				return false;
				if (!ComShowConfirm(ComGetMsg("BKG01175"))){// PPD Data is not Ready Do you want to continue?
					return false;
				}				
			}
			if(!fnExistBlackListedCustomer()){
				//return false; 
			}
			// Do not compare date null
			if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date)){
				if(
					('L' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	|| 'S' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type))
					&&	
					(ComGetObjValue(formObj.frm_t11sheet1_pol_etd_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )
				) {
						if (!ComShowConfirm(ComGetMsg("BKG00467"))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
								return false;
						}
					}
				else if(		
					'R' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	
					&&	
					(ComGetObjValue(formObj.frm_t11sheet1_cgo_rcv_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )				
				){
					if (!ComShowConfirm(ComGetMsg("BKG08137"))){// On board Date is not same as cargo receiving date. Do you want to continue?";
							return false;
					}
				}
			}
			//ORIGINAL B/L
			if((ComIsEmpty(formObj.frm_t11sheet1_bl_issue_no.value) || '0' == ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no))
					&& "B" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)){
				ComShowCodeMessage("BKG08109");// Please check No. of B/L
				ComSetFocus(formObj.frm_t11sheet1_bl_issue_no);
				return false;
			}		
			break;
		case "btn_t11CancelRelease":
			// CHG_READY = 0 or MK_READY = 0 -> ERROR
			var chg_ready=ComGetObjValue(formObj.chg_ready);
			var mk_ready=ComGetObjValue(formObj.mk_ready);
			// if(chg_ready == 0 || mk_ready == 0){
			// ComShowCodeMessage("BKG08066");// "B/L is not Ready.";
			// return false;
			// }
					// Issue=Y,
			// if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_issued)) {
			// ComShowCodeMessage("BKG08080");
			// return false;
			// }
			break;
//		case "btn_t11SWBRelease":
//			if(!fnBlNotReady()){   return;}
//			if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_cust_to_ord_flg)) {
//				ComShowCodeMessage("BKG00469"); 
//				return false;
//			}	
//			//Rate=Y,	M&D=Y, Fare Recovery =Y
//			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
//				ComShowCodeMessage("BKG08078"); 
//				return false;
//			}
//			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
//				ComShowCodeMessage("BKG08077");
//				return false;
//			}
//			if (ComGetObjValue(formObj.chg_ppd_ind) > 0 && ('N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))
//				||(ComGetObjValue(formObj.chg_ppd_third_ind) > 0 && 'N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))) {
////				ComShowCodeMessage("BKG08079") 
////				return false;
//				if (!ComShowConfirm(ComGetMsg("BKG01175"))){// PPD Data is not Ready Do you want to continue?
//					return false;
//				}				
//			}
//			if(!fnExistBlackListedCustomer()){
//				//return false; 
//			}
//			// Do not compare date null
//			if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date)){
//				if(
//					('L' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	|| 'S' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type))
//					&&	
//					(ComGetObjValue(formObj.frm_t11sheet1_pol_etd_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )
//				) {
//						if (!ComShowConfirm(ComGetMsg("BKG00467"))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
//								return false;
//						}
//					}
//				else if(		
//					'R' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	
//					&&	
//					(ComGetObjValue(formObj.frm_t11sheet1_cgo_rcv_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )				
//				){
//					if (!ComShowConfirm(ComGetMsg("BKG08137"))){// On board Date is not same as cargo receiving date. Do you want to continue?";
//							return false;
//					}
//				}
//			}
//			break;
		case "btn_t11OBLSurrender": 
			if(!fnBlNotReady()){   return;}
			//Rate=Y, M&D=Y, Fare Recovery =Y,Issue=Y,Released=Y
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
				ComShowCodeMessage("BKG08078"); 
				return false;
			}
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
				ComShowCodeMessage("BKG08077");
				return false;
			}
			if (ComGetObjValue(formObj.chg_ppd_ind) > 0 && ('N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))
				||(ComGetObjValue(formObj.chg_ppd_third_ind) > 0 && 'N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))) {
//				ComShowCodeMessage("BKG08079") 
//				return false;
				if (!ComShowConfirm(ComGetMsg("BKG01175"))){// PPD Data is not Ready Do you want to continue?
					return false;
				}
			}	
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_issued)) {
				ComShowCodeMessage("BKG08080"); 
				return false;
			}
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_released)) {
				ComShowCodeMessage("BKG08081"); 
				return false;
			}		
			if ('B' != ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)) {
				ComShowCodeMessage("BKG08082"); 
				return false;
			}
			break;
		case "btn_t11OSurrenderCancel":
			//Surrender=Y,
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_surrender)) {
				ComShowCodeMessage("BKG08083"); 
				return false;
			}
			break;
		case "btn_t11InternetAUTH":
			if(!fnBlNotReady()){   return;}
			//Rate=Y,	M&D=Y, 운임회수=Y
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_rate)) {
				ComShowCodeMessage("BKG08078"); 
				return false;
			}
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_flg_md)) {
				ComShowCodeMessage("BKG08077");
				return false;
			}
			if (ComGetObjValue(formObj.chg_ppd_ind) > 0 && ('N' == ComGetObjValue(formObj.frm_t11sheet1_flg_ppd))
				||(ComGetObjValue(formObj.chg_ppd_third_ind) > 0 && 'N' == ComGetObjValue(formObj.frm_t11sheet1_trd_flg_ppd))) {
//				ComShowCodeMessage("BKG08079");
//				return false;
				if (!ComShowConfirm(ComGetMsg("BKG01175"))){// PPD Data is not Ready Do you want to continue?
					return false;
				}
			}		
			if (!ComIsEmpty(formObj.frm_t11sheet1_do_issue_date.value)&& 'L' != ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type)) {
				ComShowCodeMessage("BKG00434");
				return false;
			}
			//20091130 OBL release와 동일 validation추가 by jy.shin
			if(!fnExistBlackListedCustomer()){
				//return false; // 경고표시만 하고 진행하도록 수정
			}
			// date가 null인  경우는  비교하지말것 
			if('' != ComGetObjValue(formObj.frm_t11sheet1_on_board_date)){
				if(
					('L' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	|| 'S' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type))
					&&	
					(ComGetObjValue(formObj.frm_t11sheet1_pol_etd_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )
				) {
						if (!ComShowConfirm(ComGetMsg("BKG00467"))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
								return false;
						}
					}
				else if(		
					'R' == ComGetObjValue(formObj.frm_t11sheet1_on_board_type)	
					&&	
					(ComGetObjValue(formObj.frm_t11sheet1_cgo_rcv_dt)!= ComGetObjValue(formObj.frm_t11sheet1_on_board_date) )				
				){
					if (!ComShowConfirm(ComGetMsg("BKG08137"))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
							return false;
					}
				}
			}
			//장수 check 추가 2009.12.23 by cateshin requested by emily
			if(ComIsEmpty(formObj.frm_t11sheet1_bl_issue_no.value) || '0' == ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no)){
				ComShowCodeMessage("BKG08109");// Please check No. of B/L
				ComSetFocus(formObj.frm_t11sheet1_bl_issue_no);
				return false;
			}
			
			break;
		
		case "btn_t11CancelAUTH":
			if(!fnBlNotReady()){   return;}
			//Issue=Y,Released=Y,
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_issued)) {
				ComShowCodeMessage("BKG08080"); 
				return false;
			}
			if ('Y' != ComGetObjValue(formObj.frm_t11sheet1_released)) {
				ComShowCodeMessage("BKG08081"); 
				return false;
			}		
			if ('B' != ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)) {
				ComShowCodeMessage("BKG08082"); 
				return false;
			}
			
			break;			
	}
	return true;
}
/**
* fnBlNotReady  validation Check
* param :comObj
*/
function fnBlNotReady(_check){
	var formObj=document.form;
	// 1 :CHG_READY = 0 or MK_READY = 0 -> ERROR
	var chg_ready=ComGetObjValue(formObj.chg_ready);
	var mk_ready=ComGetObjValue(formObj.mk_ready);
	if(chg_ready == 0 || mk_ready == 0){
		ComShowCodeMessage("BKG08066");// "B/L is not Ready.";
		return false;
	}
	
	//Cancel Auth, O.B/L Surrender skip
	var buttonType = ComGetObjValue(formObj.buttonType);
	if(buttonType == "btn_t11CancelAUTH" || buttonType == "btn_t11OBLSurrender"){
		return true;
	}

	var mnd_cnt=ComGetObjValue(formObj.mnd_cnt);
	var rate_cnt=ComGetObjValue(formObj.rate_cnt);
	var cntr_cnt=ComGetObjValue(formObj.cntr_cnt);
	var cust_cnt=ComGetObjValue(formObj.cust_cnt);
	if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_released)) {
		//2 : (if CHG_PPD_IND > 0 & PPD = 'N') or (CHG_PPD_THIRD_IND > 0 & PPD Third = 'N') -> ERROR
		// message : PPD Data is not Ready.
		var chg_ppd_ind=ComGetObjValue(formObj.chg_ppd_ind);
		var chg_ppd_third_ind=ComGetObjValue(formObj.chg_ppd_third_ind);
		var frm_t11sheet1_ppd_confirm=ComGetObjValue(formObj.frm_t11sheet1_ppd_confirm);
		var frm_t11sheet1_trd_ppd_confirm=ComGetObjValue(formObj.frm_t11sheet1_trd_ppd_confirm);
		if(( parseInt(chg_ppd_ind)> 0 && frm_t11sheet1_ppd_confirm == 'N') 
		|| ( parseInt(chg_ppd_third_ind) > 0 && frm_t11sheet1_trd_ppd_confirm == 'N')){
			if (!ComShowConfirm(ComGetMsg("BKG01175"))){// PPD Data is not Ready Do you want to continue?
				return false;
			}
		}		
	}
	return true;
}
/**
* processStatus Event
* param :comObj
*/
function processStatus(_action){
	var formObj=document.form;
	switch (_action) {
		case "btn_t11Issue": 
			//B/L type = '' , Issued = Y , Released = N, Internet Auth = N
//			ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'B');	
			ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
			ComSetObjValue(formObj.frm_t11sheet1_released, 'N');
			ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');	
		break;
//		case "btn_t11OBLRelease": 
//			//B/L type = B , Issued = Y , Released = Y, Internet Auth = N
//			ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'B');	
//			ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
//			ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
//			ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');
		case "btn_t11BLRelease": 
			if("B" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)){
				//B/L type =  , Issued = Y , Released = Y, Internet Auth = N
				ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'B');	
				ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
				ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
				ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');
			}else if("W" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)){
				//B/L type = W , Issued = Y , Released = Y, Internet Auth = N
				ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'W');	
				ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, 'W');	
				ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
				ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
				ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');	
				ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_no, '1');
				ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, '1');
			}
		break;
		case "btn_t11CancelRelease":
			//B/L type = '' , Issued = N , Released = N, Internet Auth = N
			/*
			 * ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'B');
			 * ComSetObjValue(formObj.frm_t11sheet1_issued, 'N');
			 * ComSetObjValue(formObj.frm_t11sheet1_released, 'N');
			 * ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');
			 */
		break;
//		case "btn_t11SWBRelease": 
//			//B/L type = W , Issued = Y , Released = Y, Internet Auth = N
//			ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, 'W');	
//			ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, 'W');	
//			ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
//			ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
//			ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');	
//			ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_no, '0');
//			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, '0');
//		break;
		case "btn_t11OBLSurrender": 
			//B/L type = 'B' , Issued = Y , Released = Y, Surrender = Y
			ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'B');	
			ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
			ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
			ComSetObjValue(formObj.frm_t11sheet1_surrender, 'Y');	
		break;
		case "btn_t11OSurrenderCancel":
			//B/L type = 'B' , Issued = Y , Released = Y, Surrender = N
			ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'B');	
			ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
			ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
			ComSetObjValue(formObj.frm_t11sheet1_surrender, 'N');	
		break;
		case "btn_t11BLPrint":
			//B/L type = 'B' , Issued = Y 
			// ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'B');
			// ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');
		break;
		
		case "btn_t11InternetAUTH":
			//B/L type = B , Issued = Y , Released = Y, Internet Auth = Y
		ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'B');	
		ComSetObjValue(formObj.frm_t11sheet1_issued, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_released, 'Y');	
		ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'Y');	
			
			break;
		case "btn_t11CancelAUTH": 
			//B/L type = '' , Issued = N , Released = N, Internet Auth = N
		ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'B');	
		ComSetObjValue(formObj.frm_t11sheet1_issued, 'N');	
		ComSetObjValue(formObj.frm_t11sheet1_released, 'N');	
		ComSetObjValue(formObj.frm_t11sheet1_internet_auth, 'N');	
			
		break;
		
	}
	// Change color by  Status
	setChangeColor();
	return true;

}
/**
* fnBlIssueButton Event
* param : r_obj
*/
function fnBlIssueButton() {
	var formObj=document.form;
	/**
	 * separate processing paths disabled menu
	 */
	buttonDisabledAll();
	/**
	 * [Issue Button activation conditions] ( 1. Issued = 'N', 2. Released = 'N', 3. not Surrender
	 * (BKG_BL_ISS.OBL_SRND_FLG = 'N') , 4. DO not Issue)
	 */
	 if("N" == ComGetObjValue(formObj.frm_t11sheet1_issued)
	  //&&"N" == ComGetObjValue(formObj.frm_t11sheet1_released)
	  //&&"N" == ComGetObjValue(formObj.frm_t11sheet1_surrender)
	  &&("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do)||"L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type))
	 ){
		 ComBtnEnable("btn_t11Issue");
	 } 
	 
	 
	/**
	 *[O/BL Release, SWB Release activation conditions ]
	 *(1. Issued = 'Y', 2. Released = 'N', 3. not Surrender (BKG_BL_ISS.OBL_SRND_FLG = 'N') , 4. DO not Issue)
	 */
	 if("Y" == ComGetObjValue(formObj.frm_t11sheet1_issued)
	  &&"N" == ComGetObjValue(formObj.frm_t11sheet1_released)
	  &&"N" == ComGetObjValue(formObj.frm_t11sheet1_surrender)
	  &&("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do)||"L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type))
	 ){
//		 ComBtnEnable("btn_t11OBLRelease");
//		 ComBtnEnable("btn_t11SWBRelease");
		 ComBtnEnable("btn_t11BLRelease");
		 
		 /**
	 	  * [Internet Auth activation conditions ] ( 1. Issued = 'Y', 2. BKG_BL_ISS.OBL_INET_FLG =
		  * 'N', 3. USR_ID is exists in BKG_INET_AUTH, 4.B/L Type = 'B')
		 */
		 if("N" == ComGetObjValue(formObj.frm_t11sheet1_internet_auth)
			&&"Y" == ComGetObjValue(formObj.frm_t11sheet1_auth_flag)
			&&"B" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)
		 ){
				document.all.btn_t11InternetAUTH.style.display="";
				document.all.btn_t11CancelAUTH.style.display="none";
				ComBtnEnable("btn_t11InternetAUTH");
				var obj =  document.getElementById('web_print_approved');
				obj.innerHTML = '';
		 }		 
	 }
	/**
	 * [Cancel Release,   ]
	 * ( 1. Issued = 'Y' or 2. Released = 'Y' , 4. DO not Issue) 
	 */
	 if( ("Y" == ComGetObjValue(formObj.frm_t11sheet1_issued)|| "Y" == ComGetObjValue(formObj.frm_t11sheet1_released))
		&&("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do) ||"L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type))
	 ){

		 ComBtnEnable("btn_t11CancelRelease");
		 if("Y" == ComGetObjValue(formObj.frm_t11sheet1_internet_auth)
			&&"Y" == ComGetObjValue(formObj.frm_t11sheet1_auth_flag)
		  ){
				
				document.all.btn_t11InternetAUTH.style.display="none";
				document.all.btn_t11CancelAUTH.style.display="";
	 
				ComBtnEnable("btn_t11CancelAUTH");
				var obj =  document.getElementById('web_print_approved');
				obj.innerHTML = 'WEB B/L Print Approved'; 
		 }
	 }
	 
	 /**
	 * [O/BL Surrender  ]
	 * ( 1. Issued = 'Y', 2. Released = 'Y', 3. not Surrender (BKG_BL_ISS.OBL_SRND_FLG = 'N') , 4. DO not Issue) 
	 */
	 if("Y" == ComGetObjValue(formObj.frm_t11sheet1_issued) && "Y" == ComGetObjValue(formObj.frm_t11sheet1_released)
		&&("N" == ComGetObjValue(formObj.frm_t11sheet1_flg_do)||"L" == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type))
		&&("B" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd))){
		 ComBtnEnable("btn_t11OBLSurrender");
		 if("Y" == ComGetObjValue(formObj.frm_t11sheet1_internet_auth)
					&&"Y" == ComGetObjValue(formObj.frm_t11sheet1_auth_flag)
				  ){
						document.all.btn_t11InternetAUTH.style.display="none";
						document.all.btn_t11CancelAUTH.style.display="";
			 
						ComBtnEnable("btn_t11CancelAUTH");
						var obj =  document.getElementById('web_print_approved');
						obj.innerHTML = 'WEB B/L Print Approved'; 
				 }
	 }
	 //* SWB E-mail	B/L type = 'W'	Released = 'Y'
	if("W" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)
		&& "Y" == ComGetObjValue(formObj.frm_t11sheet1_released)){
		ComBtnEnable("btn_t11SWBEmail");
	}
	/**
	Surrender='Y' or D/O='Y'
	**/
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_flg_do)
			&&"L" != ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type)
	// || "Y" == ComGetObjValue(formObj.frm_t11sheet1_surrender)
	){
		ComBtnDisable("btn_t11Issue");
		ComBtnDisable("btn_t11InternetAUTH");
//		ComBtnDisable("btn_t11OBLRelease");
		ComBtnDisable("btn_t11BLRelease");
		ComBtnDisable("btn_t11CancelRelease");
//		ComBtnDisable("btn_t11SWBRelease");
		ComBtnDisable("btn_t11OBLSurrender");
	}
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_internet_auth)){
		var obj=document.getElementById('web_print_approved');
		obj.innerHTML='WEB B/L Print Approved'; 		
	}
	
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_issued) && "Y" == ComGetObjValue(formObj.inetFtpAuthFlg)){
		ComBtnEnable("btn_t11FtpSend");
	}
	//save踰꾪듉 泥섎━..jsy
	if(ComGetObjValue(formObj.isInquiry) == "Y"){
		setInquiryDisableButton();
	}
	
	//btn_t11SWBRelease 버튼 제어
//	if(ComGetObjValue(formObj.frm_t11sheet1_obl_prn_flg) == "Y"){
//		ComBtnDisable("btn_t11BLRelease");
//	}


}
/**
 * select_vessel_direction_OnBlur Event
 * param :comObj
 */
function select_vessel_direction_OnBlur(comObj){
	var formObj=document.form;
	var text=comObj.GetSelectText();
	text = chekcSpecialValue(text);	//특수문자 제외 로직
	comObj.SetSelectText(text, 0)
	
	//if( text != "" && text != comObj.Code)
	if( text != comObj.GetSelectCode()){
		var finded=comObj.FindItem(comObj.GetSelectText() , 0);
		ComSetObjValue(formObj.vessel_direction, text);
		UserComXmlComboItem(arrXml_vessel_direction, select_vessel_direction, "t11sheet3_name", "t11sheet3_name","vessel_direction");	
		select_vessel_direction.SetSelectCode(ComGetObjValue(formObj.vessel_direction));
	}
}
/**
* select_pre_carriage_by_OnBlur Event
* param : comObj
*/
function select_pre_carriage_by_OnBlur(comObj){
	var formObj=document.form;
	var text=comObj.GetSelectText();
	text = chekcSpecialValue(text);	//특수문자 제외 로직
	comObj.SetSelectText(text, 0)
	
	if( text != comObj.GetSelectCode()){
		var finded=comObj.FindItem(comObj.GetSelectText() , 0);
		ComSetObjValue(formObj.pre_carriage_by, text);
		UserComXmlComboItem(arrXml_pre_carriage_by, select_pre_carriage_by, "t11sheet2_name", "t11sheet2_name","pre_carriage_by");
		select_pre_carriage_by.SetSelectCode(ComGetObjValue(formObj.pre_carriage_by));
	}
}
function bl_ready_type_OnChange(comObj,index,text){	
	ComSetObjValue(document.form.modify_flag, "Y");
}
function on_board_type_OnChange(comObj,index,text){	
	ComSetObjValue(document.form.modify_flag, "Y");
}
function move_type_OnChange(comObj,index,text){	
	ComSetObjValue(document.form.modify_flag, "Y");
}
function bl_issuebl_type_OnChange(comObj,index,value, oldValue){	
	var formObj = document.form;
	ComSetObjValue(formObj.modify_flag, "Y");
//	ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, formObj.bl_issuebl_type.value);
	ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, formObj.bl_issuebl_type.value);
	ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, formObj.bl_issuebl_type.value);
	if(value != oldValue){
		if("B" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)){
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, "3");
//			ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_no, "3");
		}else if("W" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)){
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, "1");
//			ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_no, "1");
		}	
	}
}
/**
* select_vessel_direction_OnChange Event
* param :comObj,index,text
*/
function select_vessel_direction_OnChange(obj,oldindex, oldtext, oldcode , newindex, newtext , newcode){
	newtext = chekcSpecialValue(newtext);	//특수문자 제외 로직
	obj.SetSelectText(newtext, 0)

	var formObj=document.form;
	if(newtext!=""){
		ComSetObjValue(formObj.vessel_direction, newtext);
	}else{
		ComSetObjValue(formObj.vessel_direction, newcode);
	}
	ComSetObjValue(document.form.modify_flag, "Y");
}



/**
* select_pre_carriage_by_OnChange Event
* param :comObj,index,text
*/
function select_pre_carriage_by_OnChange(obj,oldindex, oldtext, oldcode , newindex, newtext , newcode){	
	newtext = chekcSpecialValue(newtext);	//특수문자 제외 로직
	obj.SetSelectText(newtext, 0)

	var formObj=document.form;
	if(newtext!=""){
		ComSetObjValue(formObj.pre_carriage_by, newtext);
	}else{
		ComSetObjValue(formObj.pre_carriage_by, newcode);
	}
	ComSetObjValue(document.form.modify_flag, "Y");
}

/**
* UserComXmlComboItem Event
* param : xmlStr, cmbObj, codeCol, textCol, typeValue
*/
var isExist=false;
function UserComXmlComboItem(xmlStr, cmbObj, codeCol, textCol, typeValue) {
	isExist=false;
	if (xmlStr == null || codeCol == "" || cmbObj == null || textCol == "") {
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
		if (dataChildNodes == null) { return;	}
		var colListIdx=Array();
		var arrText=textCol.split("|");
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
			for ( var j=0; j < arrText.length; j++) {
				if (colArr[i] == arrText[j]) {
					colListIdx[j + 1]=i;
				}
			}
		}
		var compareValue=ComGetObjValue(eval('document.form.'+typeValue));
		for ( var i=1; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			var item="";
			var tempItem="";
			for ( var j=1; j < colListIdx.length; j++) {
				tempItem=arrData[colListIdx[j]];
				if(tempItem == compareValue){
					isExist=true;
				}else{
					isExist=false;
				}
				item += tempItem;
				if (j < colListIdx.length - 1) {
					item += "|";
				}
			}
			cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
		}
		if(!isExist){
			cmbObj.InsertItem(-1, compareValue, compareValue);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return true;
}
var arrXml_vessel_direction;
var arrXml_pre_carriage_by ;
// Sheet handling process
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = 1;
	var formObj=document.form;
	initFrist=true;
	var State ;
	var aryPrefix=new Array(prefix1,prefix2, prefix3,prefix4);
	if (!validateForm(sheetObj, formObj, sAction)) {
		return;
	}
	switch (sAction) {		
	case IBSEARCH: //Retrieve
		ComSetObjValue(formObj.f_cmd, SEARCH);
		document.form.frm_t11sheet1_bkg_sts.style.color='';
		document.getElementById('btn_t11Doc_Requirement').style.color="";
		var obj=document.getElementById('web_print_approved');
		obj.innerHTML='';    
		if(ComGetObjValue(formObj.isInquiry) == "Y"){
			setInquiryDisableButton();
		}
		try{
			parent.initIssueCAControl("", "N", "N", "N", "");
		}catch(e){}

		try{
			ComOpenWait(true); 
			var parm="f_cmd=" 				+ SEARCH 
						+ "&bkg_no=" 			+ formObj.bkg_no.value
						+ "&bl_no=" 			+ formObj.bl_no.value 
						+ "&setupfocoblflag" 	+ formObj.setupfocoblflag.value;	
			var sXml=sheetObj.GetSearchData("ESM_BKG_0079_09GS.do", parm + "&" + ComGetPrefixParam(aryPrefix));
			// fnClearForm();
			var arrXml=sXml.split("|$$|");
			arrXml[0] = "<?xml version='1.0' ?>" + arrXml[0];		//by kimtaekyun 2016.04.22 ('?>' modify error) 
			var State=ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");

			if ( State == "S" ) {
				// form_text
				sheetObjects['t11sheet1'].LoadSearchData(arrXml[0],{Sync:1} );
				// pre_carriage_by
				arrXml_pre_carriage_by=arrXml[1];
				// vessel_direction
				arrXml_vessel_direction=arrXml[2];
				if(arrXml_pre_carriage_by.length == '45'){
					arrXml_pre_carriage_by="<SHEET><DATA COLORDER='t11sheet2_val|t11sheet2_ibflag|t11sheet2_desc|t11sheet2_name|t11sheet2_comboCd|t11sheet2_pagerows|' COLSEPARATOR='☜☞' TOTAL='0'></DATA></SHEET>";
				}
				if (sheetObj.GetTotalRows()== 0){
					ComResetAll();
					try{
						parent.initIssueCAControl("", "N", "N", "N", "");
					}catch(e){}
					return;
				}
				UserComXmlComboItem(arrXml_pre_carriage_by, select_pre_carriage_by, "t11sheet2_name", "t11sheet2_name","frm_t11sheet1_pre_carriage_by");
				UserComXmlComboItem(arrXml_vessel_direction, select_vessel_direction, "t11sheet3_name", "t11sheet3_name","frm_t11sheet1_vessel_direction");
				// select box : vessel_direction / pre_carriage_by
				
				select_vessel_direction.SetSelectCode(fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_vessel_direction), ""),false);
				select_pre_carriage_by.SetSelectCode(fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_pre_carriage_by), ""),false);
				
	//			ComSetObjValue(select_vessel_direction, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_vessel_direction), ""));		
	//			ComSetObjValue(select_pre_carriage_by, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_pre_carriage_by), ""));
				// hidden value :
				ComSetObjValue(formObj.vessel_direction, ComGetObjValue(formObj.frm_t11sheet1_vessel_direction));
				ComSetObjValue(formObj.pre_carriage_by, ComGetObjValue(formObj.frm_t11sheet1_pre_carriage_by));
				ComSetObjValue(formObj.docRqstTtl, ComGetEtcData(arrXml[0],"docRqstTtl"));
				
				if('F' == ComGetEtcData(arrXml[0], "vesselVoyageDirectionEqual")){
					comboObjects[0].SetFontColor("red");
				}else{
					comboObjects[0].SetFontColor("gray");
				}
		        if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
		            document.getElementById("tpb_status").value=ComGetEtcData(arrXml[0], "tpbStatus");
		            tpbImgSet(document.getElementById("tpb_status").value);
		        }
		        changeObjectColor(ComGetEtcData(arrXml[0], "docReqButton"), "Y", "btn_t11Doc_Requirement", "blue", "btn2");
		        var blNoReady=ComGetEtcData(arrXml[0], "blNoReady");
		    	var ready_val=blNoReady.split("|");
		    	
		    	ComSetObjValue(formObj.chg_ready, ready_val[0]);
		    	ComSetObjValue(formObj.mk_ready, ready_val[1]);
		    	ComSetObjValue(formObj.chg_ppd_ind, ready_val[2]);
		    	ComSetObjValue(formObj.chg_ppd_third_ind, ready_val[3]);
		    	ComSetObjValue(formObj.mnd_cnt, ready_val[4]);
		    	ComSetObjValue(formObj.rate_cnt, ready_val[5]);
		    	ComSetObjValue(formObj.cntr_cnt, ready_val[6]);
		    	ComSetObjValue(formObj.cust_cnt, ready_val[7]);
		    	ComSetObjValue(formObj.caflag			, ComGetEtcData(arrXml[0], "caflag"));
				ComSetObjValue(formObj.bdrflag			, ComGetEtcData(arrXml[0], "bdrflag"));
				ComSetObjValue(formObj.ca_exist_flg		, ComGetEtcData(arrXml[0], "ca_exist_flg"));
				//2015.10.23. 첫번째 tab 이동시 caFalg,bdrflag,ca_exits_flg 값 미셋팅으로 버튼처리 오류 수정
				try{
					// C/A button  Control 
					parent.initIssueCAControl(ComGetObjValue(formObj.bkg_no),ComGetObjValue(formObj.caflag),	ComGetObjValue(formObj.bdrflag),ComGetObjValue(formObj.ca_exist_flg),ComGetObjValue(formObj.bl_no));
				}catch(e){}
			}else{
				//2014.08.29. 김태균 BL Issue Cancel Auth Error - 조회에러메시지 처리 및 초기화
				ComBkgErrMessage(sheetObj, sXml);
				
				ComResetAll();
				ComSetObjValue(formObj.frm_t11sheet1_bkg_no,"");
	//			eval('DIV_btn_t11InternetAUTH').style.display = 'block';
	//			eval('DIV_btn_t11CancelAUTH').style.display = 'none';
				document.all.btn_t11InternetAUTH.style.display="";
				document.all.btn_t11CancelAUTH.style.display="none";
				
				try{
					parent.initIssueCAControl("", "N", "N", "N", "");
				}catch(e){}
				ComSetFocus(formObj.frm_t11sheet1_bkg_no);
				
	//			fnExceptionMessage(sXml);
			}
		}catch(e){
		}finally{
			ComOpenWait(false);
	    	if(ComGetObjValue(formObj.isInquiry) == "Y"){
	    		setInquiryDisableButton();
	    	}
		}
		ComSetFocus(formObj.frm_t11sheet1_bkg_no);
		break;
	case IBSAVE: //Save
		ComSetObjValue(formObj.f_cmd, MULTI);
		
		//특수문자 제거 로직 추가
		var v_frm_t11sheet1_obl_iss_rmk = chekcSpecialValue(ComGetObjValue(formObj.frm_t11sheet1_obl_iss_rmk));
		ComSetObjValue(formObj.frm_t11sheet1_obl_iss_rmk, v_frm_t11sheet1_obl_iss_rmk);
		
		SetSaveData(sheetObj, formObj);
		// After storage and processing results
		var sParam=ComGetSaveString(sheetObjects['t11sheet1']);
		sParam += "&" + FormQueryString(formObj); // hidden param value String
		sParam += "&" + ComGetPrefixParam(prefix1);// prefix String array
		if (!ComShowConfirm(ComGetMsg("BKG00350"))) {//"Do you want to Save your Changes?";
			return;
		}
		ComOpenWait(true);
		
		//2014.11.28 Maeda Add setTimeout to show waiting image
		setTimeout( function(){
			
		// Save
		var sXml=sheetObj.GetSaveData("ESM_BKG_0079_09GS.do", sParam);
		// After storage and processing results
		 State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			ComShowMessage(ComGetMsg("BKG06071"));
			sheetObj.LoadSaveData(sXml,{Sync:1});
		}else{
			//2014.08.29. 김태균 BL Issue Cancel Auth Error - 에러메시지 처리
			ComShowMessage(ComResultMessage(sXml));
			
//			fnExceptionMessage(sXml);
		}
		if(tab_alert_msg){
			doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
		}
		}, 100);
		
		break;
	case MULTI01:
		ComOpenWait(true);
		
		//2014.11.28 Maeda Add setTimeout to show waiting image
		setTimeout( function(){
			
		ComSetObjValue(formObj.f_cmd, MULTI01);
		SetSaveData(sheetObj, formObj);
		var sParam=ComGetSaveString(sheetObjects['t11sheet1']);
		if (sParam == "")
			return;
		sParam += "&" + FormQueryString(formObj); // hidden param value String
		sParam += "&" + ComGetPrefixParam(prefix1);// prefix String array
		var sXml=sheetObj.GetSaveData("ESM_BKG_0079_09GS.do", sParam);
		 State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			//ComShowMessage(ComGetMsg("BKG06071"));
			sheetObj.LoadSaveData(sXml,{Sync:1});
		}else{
			ComShowMessage(ComResultMessage(sXml));
//			fnExceptionMessage(sXml);
		}
		doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);

		}, 100);
		
		break;

	//[Authorize] at Internet O.B/L Print Authorize screen(ESM_BKG_1074) not to use setTimeout function
	case MULTI02:
		ComOpenWait(true);
		ComSetObjValue(formObj.f_cmd, MULTI01);
		SetSaveData(sheetObj, formObj);
		var sParam=ComGetSaveString(sheetObjects['t11sheet1']);
		if (sParam == "")
			return;
		sParam += "&" + FormQueryString(formObj); // hidden param value String
		sParam += "&" + ComGetPrefixParam(prefix1);// prefix String array
		var sXml=sheetObj.GetSaveData("ESM_BKG_0079_09GS.do", sParam);
		 State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			//ComShowMessage(ComGetMsg("BKG06071"));
			sheetObj.LoadSaveData(sXml,{Sync:1});
		}else{
			ComShowMessage(ComResultMessage(sXml));
//			fnExceptionMessage(sXml);
		}
		doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
		break;
	case COMMAND11:
		
		
		
		var sParam="f_cmd="+ COMMAND11+"&bkg_no="+formObj.bkg_no.value;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_09GS.do", sParam + "&" + ComGetPrefixParam(prefix1));
		if(ComGetEtcData(sXml, "chk_rcv_ftp") == "Y"){			//ftp 전송 정보가 존재할때...
			if(ComGetEtcData(sXml, "exist_pagecnt") == "Y"){	//KNN
				if(ComGetEtcData(sXml, "chk_ffrefno") == "Y"){	//FFREFNO validation check.
					ComShowCodeMessage("BKG08369");		//Reference number is invalid for the BL hence it is not FTP to customer, please check with the customer
					return;
				}else{
					rdOpenStart(formObj);
				}
			}else{
				doActionIBSheet(sheetObjects['t11sheet1'], formObj, MULTI03);
			}
		}else{
			ComShowCodeMessage("BKG08366");
		}

		break;
	case MULTI03:
		// ftp 전송한다.
		ComSetObjValue(formObj.f_cmd, MULTI03);
		SetSaveData(sheetObj, formObj);
		sParam=ComGetSaveString(sheetObjects['t11sheet1']);
		if (sParam == "")
			return;
		
		sParam += "&" + FormQueryString(formObj);
		sParam += "&" + ComGetPrefixParam(prefix1);
		if (!ComShowConfirm(ComGetMsg("BKG08365"))) {//"Do you want to transmit FTP?";
			return;
		}
		var sXml=sheetObj.GetSaveData("ESM_BKG_0079_09GS.do", sParam);
		State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			ComShowMessage(ComGetMsg("BKG08367"));
		}else{
			ComShowMessage(ComResultMessage(sXml));
		}
		break;		
	// [O/BL Release] btn_t11OBLRelease
	case COMMAND02:
		ComOpenWait(true); 
		ComSetObjValue(formObj.f_cmd, MULTI01);
		SetSaveData(sheetObj, formObj);
		var sParam=ComGetSaveString(sheetObjects['t11sheet1']);
		if (sParam == "")
			return;
		sParam += "&" + FormQueryString(formObj); // hidden param value String
		sParam += "&" + ComGetPrefixParam(prefix1);// prefix String array
		var sXml=sheetObj.GetSaveData("ESM_BKG_0079_09GS.do", sParam);
		 State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			//ComShowMessage(ComGetMsg("BKG06071"));
			sheetObj.LoadSaveData(sXml,{Sync:1});
			doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
		}else{
//			fnExceptionMessage(sXml);
			ComShowMessage(ComResultMessage(sXml));
		}
		break;
	case COMMAND03:
		formObj.f_cmd.value=COMMAND03;
		var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_t11sheet1_bkg_no);
		var sXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
	 	var bkg_split_no_list=ComGetEtcData(sXml, "bkg_split_no_list");
	 	bkgSplitNoListPop(formObj.frm_t11sheet1_bkg_no,bkg_split_no_list,-15); 
		break;
	// [Cancel Release] btn_t11CancelRelease
	case COMMAND04:
		ComSetObjValue(formObj.f_cmd, MULTI01);
		SetSaveData(sheetObj, formObj);
		var sParam=ComGetSaveString(sheetObjects['t11sheet1']);
		if (sParam == "")
			return;
		sParam += "&" + FormQueryString(formObj); // hidden param value String
		sParam += "&" + ComGetPrefixParam(prefix1);// prefix String array
		if (!ComShowConfirm(ComGetMsg("BKG00498"))) {
			return;
		}
		var sXml=sheetObj.GetSaveData("ESM_BKG_0079_09GS.do", sParam);
		 State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {	
			//ComShowMessage(ComGetMsg("BKG06071"));
			sheetObj.LoadSaveData(sXml,{Sync:1});
			doActionIBSheet(sheetObjects['t11sheet1'], formObj, IBSEARCH);
		}else{
//			fnExceptionMessage(sXml);
			ComShowMessage(ComResultMessage(sXml));
		}
		break;
	}	
	// button setting 
	if ( State == "S" ) {	
		fnBlIssueButton() ;
		State='';
	}
	ComSetObjValue(document.form.modify_flag, "N");
	ComOpenWait(false); 
}
//function myTimeoutFunction()
//{
//    doStuff();
//    setTimeout(myTimeoutFunction, 3000);
//}


//전체 페이지 숫자를 알기위해 formMainOnly='N'로 하여 Face를 실행 한다.
//function rdOpenStart(formObject, RiderYn, HBYn) {
function rdOpenStart(formObject) {
	var rdParam_Face = "";
	var strFacePath = "";
	var bkgNo = formObject.bkg_no.value; // bkg_no
	var formUserId = formObject.strUsr_id.value; // form_usrId
	var por_cd = formObject.frm_t11sheet1_por_code.value;
	
	if (por_cd.indexOf("US")) {
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
	}else{
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
	}
	rdParam_Face = "/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
	rdParam_Face += "form_type[2] "; // form_type
	rdParam_Face += "form_dataOnly[N] "; // form_dataOnly
	rdParam_Face += "form_manifest[N] "; // form_manifest
	rdParam_Face += "form_usrId[" + formUserId + "] "; // form_usrId
	rdParam_Face += "form_mainOnly[N] "; // form_mainOnly
	rdParam_Face += "form_hiddeData[N] "; // form_hiddeData
	rdParam_Face += "form_level[(1)] "; // form_level
	rdParam_Face += "form_remark[] "; // form_remark
	rdParam_Face += "form_Cntr[1] "; // form_Cntr
	rdParam_Face += "form_CorrNo[] "; // form_CorrNo
	rdParam_Face += "form_his_cntr[BKG_CONTAINER] "; // form_his_cntr
	rdParam_Face += "form_his_bkg[BKG_BOOKING] "; // form_his_bkg
	rdParam_Face += "form_his_mkd[BKG_BL_MK_DESC] "; // form_his_mkd
	rdParam_Face += "form_his_xpt[BKG_XPT_IMP_LIC] "; // form_his_xpt
	rdParam_Face += "form_his_bl[BKG_BL_DOC] "; // form_his_bl
	rdParam_Face += "form_rqst_via_cd[] "; // form_rqst_via_cd
	rdParam_Face += "form_his_bl_mkd[BKG_BL_ISS] "; // form_his_bl_mkd
	rdParam_Face += "form_path[" + getFileDownPath() + "] "; // form_path
	rdParam_Face += "form_esig[] "; // form_esig
	rdParam_Face += "form_cpy_esig[] "; // form_cpy_esig
	rdParam_Face += "form_knt_flg[] "; // form_knt_flg
	rdParam_Face += "form_count[] "; // form_count
	rdParam_Face += "/rp [] "; // form_caYn
	rdParam_Face += "/riprnmargin /rmatchprndrv [3]";
	
	viewer.openFile(strFacePath, RDServer + rdParam_Face, {timeout:3000});
	
	viewer.bind('report-finished', function(e){ 
		ComSetObjValue(formObject.totalpage, leadingZeros(e.totalPage, 2));
		rdOpenDocType(formObject, "6");
	});	
	
}

function rdOpenDocType(formObject, level) {
	var rdParam_Face = "";
	var strFacePath = "";
	var bkgNo = formObject.bkg_no.value; // bkg_no
	var formUserId = formObject.strUsr_id.value; // form_usrId
	var por_cd = formObject.frm_t11sheet1_por_code.value;
	
	if (por_cd.indexOf("US")) {
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_LETTER.mrd";
	}else{
		strFacePath = RD_path + "apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0109_OBL_A4.mrd";
	}
	rdParam_Face = "/rv form_bkgNo[( '" + bkgNo + "' )] "; // bkg_no
	rdParam_Face += "form_type[2] "; // form_type
	rdParam_Face += "form_dataOnly[N] "; // form_dataOnly
	rdParam_Face += "form_manifest[N] "; // form_manifest
	rdParam_Face += "form_usrId[" + formUserId + "] "; // form_usrId
	rdParam_Face += "form_mainOnly[N] "; // form_mainOnly
	rdParam_Face += "form_hiddeData[N] "; // form_hiddeData
	rdParam_Face += "form_level[("+level+")] "; // form_level
	rdParam_Face += "form_remark[] "; // form_remark
	rdParam_Face += "form_Cntr[1] "; // form_Cntr
	rdParam_Face += "form_CorrNo[] "; // form_CorrNo
	rdParam_Face += "form_his_cntr[BKG_CONTAINER] "; // form_his_cntr
	rdParam_Face += "form_his_bkg[BKG_BOOKING] "; // form_his_bkg
	rdParam_Face += "form_his_mkd[BKG_BL_MK_DESC] "; // form_his_mkd
	rdParam_Face += "form_his_xpt[BKG_XPT_IMP_LIC] "; // form_his_xpt
	rdParam_Face += "form_his_bl[BKG_BL_DOC] "; // form_his_bl
	rdParam_Face += "form_rqst_via_cd[] "; // form_rqst_via_cd
	rdParam_Face += "form_his_bl_mkd[BKG_BL_ISS] "; // form_his_bl_mkd
	rdParam_Face += "form_path[" + getFileDownPath() + "] "; // form_path
	rdParam_Face += "form_esig[] "; // form_esig
	rdParam_Face += "form_cpy_esig[] "; // form_cpy_esig
	rdParam_Face += "form_knt_flg[] "; // form_knt_flg
	rdParam_Face += "form_count[] "; // form_count
	rdParam_Face += "/rp [] "; // form_caYn
	rdParam_Face += "/riprnmargin /rmatchprndrv [3]";
	
	viewer.openFile(strFacePath, RDServer + rdParam_Face, {timeout:3000});
	
	viewer.bind('report-finished', function(e){ 
		ComSetObjValue(formObject.totalunrated, leadingZeros(e.totalPage, 2));
		doActionIBSheet(sheetObjects['t11sheet1'], formObject, MULTI03);
	});	
	
}

 /**
  * ComEnableManyIBCombo all Enable/Disable handling  
  */
 function ComEnableManyIBCombo(bEnable, objs) {
 	try {
 	    var args=arguments;
 	    if (args.length < 2) return;
 	    for(var i=1; i<args.length; i++) {
	 		if (args[i].tagName != undefined) {
	 			args[i].SetEnable(bEnable);
	 		}
 	    } 
 	} catch(err) { ComFuncErrMsg(err.message); }
 }
 /**
  * ComEnableManyObjects_loc all Enable/Disable handling  
  */
 function ComEnableManyObjects_loc(bEnable, objs) {
 	try {
 	    var args=arguments;
 	    if (args.length < 2) return;
 	    for(var i=1; i<args.length; i++) {
 		if (args[i].tagName != undefined) ComEnableObject_loc(args[i], bEnable);
 	    }
 	} catch(err) { ComFuncErrMsg(err.message); }
 }
 /**
  * ComEnableObject_loc all Enable/Disable handling
  */   
 function ComEnableObject_loc(obj, bEnable){
	 try {
	 //disabled or readOnly 
	   switch( obj.type ) {
	 	case "password" :
	 	case "text" :
	 		obj.readOnly=!bEnable;
	 	    break;
	 	default:
	 	    obj.disabled=!bEnable;
	   }
	 //Css processing, depending on the setting
	  switch( obj.type ) {
	 	case "select-one" :
	 	case "text" :
	 	    if (bEnable){
		 		if (obj.className=="input2_2"){		//background color gray 
		 			obj.className="input1";	// background color white 
		 		} else if (obj.className=="input2"){	//background color white
		 			obj.className="input";	// background color white
		 		}
	 	    } else {
		 		if (obj.className=="input1"){		
		 			obj.className="input2_2";	// background color gray
		 		} else if (obj.className=="input"){	//background color white
		 			obj.className="input2";	// background color gray
		 		} else if (obj.className=="noinput"){	//background color white
		 			obj.className="noinput2";	// background color gray
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
	 	    if (obj.tagName=="IMG" || obj.tagName=="img") {
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
   * Change the background color combo
   */
function setComboBackColor(comboObj) {
   	if ("" != comboObj.GetSelectText()) {
		comboObj.SetBackColor("#E8E7EC");
		//comboObj.fontcolor = "#ffffff";
	} else {
		comboObj.SetBackColor("#ffffff");
		comboObj.fontcolor="#606060";
	} 
}
/**
* Data setting
*/
function SetSaveData(sheetObj, formObj) {

	// check box : frm_t11sheet1_bdr
	if (formObj.check_bdr.checked) {
		ComSetObjValue(formObj.frm_t11sheet1_bdr, "Y");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bdr, "N");
	}
	// check box :  bl_ready_checkbox
	if (formObj.bl_ready_checkbox.checked) {
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "Y");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_checkbox, "N");
	}
	// check box :  bl_proofbyshipper_checkbox
	if (formObj.bl_proofbyshipper_checkbox.checked) {
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_checkbox, "Y");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_checkbox, "N");
	}
	ComSetObjValue(formObj.frm_t11sheet1_vessel_direction	, ComGetObjValue(formObj.vessel_direction));
	ComSetObjValue(formObj.frm_t11sheet1_pre_carriage_by	, ComGetObjValue(formObj.pre_carriage_by));
	ComSetObjValue(formObj.frm_t11sheet1_on_board_type		, ComGetObjValue(on_board_type));
	ComSetObjValue(formObj.frm_t11sheet1_bl_ready_type		, ComGetObjValue(bl_ready_type));
	ComSetObjValue(formObj.frm_t11sheet1_move_type			, ComGetObjValue(move_type));
	ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd	, ComGetObjValue(bl_issuebl_type));
	
	// 2.Parameter settings
	if (IBS_CopyFormToRow(formObj, sheetObjects['t11sheet1'], 1, "frm_")) {};
	// 3. Date variable:separator  remove
	sheetObj.SetCellValue(1, prefix1 + "bl_issue_date",ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date).split('-').join("")+"000000",0);
	sheetObj.SetCellValue(1, prefix1 + "bl_proofbyshipper_date",ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_date).split('-').join("")+"000000",0);
	sheetObj.SetCellValue(1, prefix1 + "on_board_date",ComGetObjValue(formObj.frm_t11sheet1_on_board_date).split('-').join("")+"000000",0);
	sheetObj.SetCellValue(1, prefix1 + "bl_ready_date",ComGetObjValue(formObj.frm_t11sheet1_bl_ready_date).split('-').join("")+"000000",0);
	// frm_t11sheet1_rcv_de_term_prn_flg, frm_t11sheet1_bl_mv_tp_prn_flg setting
	if(sheetObj.GetCellValue(1, prefix1 + "rcv_de_term_prn_flg") == "1")	sheetObj.SetCellValue(1, prefix1 + "rcv_de_term_prn_flg","Y",0);
	else																	sheetObj.SetCellValue(1, prefix1 + "rcv_de_term_prn_flg","N",0);
	if(sheetObj.GetCellValue(1, prefix1 + "bl_mv_tp_prn_flg") == "1")		sheetObj.SetCellValue(1, prefix1 + "bl_mv_tp_prn_flg","Y",0);
	else																	sheetObj.SetCellValue(1, prefix1 + "bl_mv_tp_prn_flg","N",0);
	
	return true;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	/* 
	 * Script Common
	 4. [Retrieve exception]BKG Status 
	 5. [Retrieve exception]D/O Check
	 6. [Retrieve exception] BKG no Check
	 */
	switch (sAction) {
	case IBSEARCH: // search   
		if (ComGetObjValue(formObj.frm_t11sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_t11sheet1_bl_no) == '') {
			//ComShowCodeMessage("BKG00425");
			ComSetFocus(formObj.frm_t11sheet1_bkg_no);
			return false;
		}
		ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.frm_t11sheet1_bkg_no));
		ComSetObjValue(formObj.bl_no, ComGetObjValue(formObj.frm_t11sheet1_bl_no));
		formObj.IssuerSet_checkbox.checked=false;	
		formObj.date_set_checkbox.checked=false;
		formObj.bl_ready_checkbox.checked = false;

		break;
	case IBSAVE: // save
		if (ComGetObjValue(formObj.bkg_no) == '' && ComGetObjValue(formObj.bl_no) == '') {
			if(tab_alert_msg){
				ComShowCodeMessage("BKG00425");
			}
			ComSetFocus(formObj.frm_t11sheet1_bkg_no);
			return false;
		}
		if(ComGetObjValue(formObj.frm_t11sheet1_bkg_no) != ComGetObjValue(formObj.bkg_no)
		|| ComGetObjValue(formObj.frm_t11sheet1_bl_no) != ComGetObjValue(formObj.bl_no)	
		){
			if(tab_alert_msg){
				ComShowCodeMessage("BKG01053");
			}
			return false;
		}
		break;
	case MULTI01: //  
		break;
	case COMMAND02: // [O/BL Release]  btn_t11OBLRelease   
		break;
	case COMMAND03: // [SWB Release]  btn_t11SWBRelease   
		break;
	case COMMAND04: // [Cancel Release]  btn_t11CancelRelease 
		break;
	case COMMAND11: // btn_t11FtpSend
		var ttl = parseInt(ComGetObjValue(formObj.docRqstTtl));
		if (ttl==0){
			ComShowCodeMessage("BKG00068", "Doc requirement");
			return false;
		}
		break;
	}
	return true;
}
 /**
  * t11sheet1_OnSaveEnd Event
  * param :sheetObj, ErrMsg
  */
 function t11sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		initFrist=false;
 }
/**
 * t10sheet1_OnSearchEnd:retrieve after Event
 * param :sheetObj, ErrMsg
 */
function t11sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	
	var formObj=document.form;
	try {

		//FORM VALUE BINDING 
		if (IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_")) {
		}
		
		
//		IBS_CopyRowToForm(sheetobj, formobj, row, prefix)
		ComSetObjValue(formObj.bkg_no 			, ComGetObjValue(formObj.frm_t11sheet1_bkg_no));
		ComSetObjValue(formObj.bl_no 			, ComGetObjValue(formObj.frm_t11sheet1_bl_no));
		ComSetObjValue(on_board_type	, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_on_board_type), "L"));
		ComSetObjValue(bl_ready_type	, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_bl_ready_type), "U"));
		ComSetObjValue(move_type		, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_move_type), "1"));
		ComSetObjValue(bl_issuebl_type		, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd), "B"));
		
		ComSetObjValue(formObj.frm_t11sheet1_ppd_rcv_dt	, ComGetMaskedValue(ComGetObjValue(formObj.frm_t11sheet1_ppd_rcv_dt), "ymd"));
		ComSetObjValue(formObj.frm_t11sheet1_trd_ppd_rcv_dt	, ComGetMaskedValue(ComGetObjValue(formObj.frm_t11sheet1_trd_ppd_rcv_dt), "ymd"));
		ComSetObjValue(formObj.frm_t11sheet1_cct_rcv_dt	, ComGetMaskedValue(ComGetObjValue(formObj.frm_t11sheet1_cct_rcv_dt), "ymd"));
		ComSetObjValue(formObj.frm_t11sheet1_trd_cct_rcv_dt	, ComGetMaskedValue(ComGetObjValue(formObj.frm_t11sheet1_trd_cct_rcv_dt), "ymd"));
		// check box : frm_t11sheet1_bdr
		if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_bdr)) {
			formObj.check_bdr.checked=true;
		}else{
			formObj.check_bdr.checked=false;
		}
		if ('Y' == ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_checkbox)) {
			formObj.bl_proofbyshipper_checkbox.checked=true;
		}else{
			formObj.bl_proofbyshipper_checkbox.checked=false;
		}
		ComSetObjValue(formObj.f_fwd_name, ComGetObjValue(formObj.frm_t11sheet1_f_fwd_name)+ComGetObjValue(formObj.frm_t11sheet1_f_fwd_address));
		// issued -> Y :Disabled
		if('Y' == ComGetObjValue(formObj.frm_t11sheet1_issued)){
			formObj.IssuerSet_checkbox.disabled=true;	
			formObj.bl_ready_checkbox.disabled = true;
			ComEnableObject_loc(formObj.frm_t11sheet1_bl_ready_office, false);	//color change....
			ComEnableObject_loc(formObj.frm_t11sheet1_bl_ready_by, false);		//color change....
			ComEnableObject_loc(formObj.frm_t11sheet1_bl_ready_date, false);	//color change....
			bl_ready_type.SetEnable(false);
			bl_issuebl_type.SetEnable(false);
			ComBtnDisable("pop_bl_ready_date");
		}else{
			formObj.IssuerSet_checkbox.disabled=false;
			formObj.bl_ready_checkbox.disabled = false;
			ComEnableObject_loc(formObj.frm_t11sheet1_bl_ready_office, true);
			ComEnableObject_loc(formObj.frm_t11sheet1_bl_ready_by, true);
			ComEnableObject_loc(formObj.frm_t11sheet1_bl_ready_date, true);
			ComEnableObject_loc(formObj.frm_t11sheet1_bl_ready_type, true);
			bl_ready_type.SetEnable(true);
			bl_issuebl_type.SetEnable(true);
			ComBtnEnable("pop_bl_ready_date");
		}
		ComSetObjValue(formObj.frm_t11sheet1_issued, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_issued), "N"));
		ComSetObjValue(formObj.frm_t11sheet1_released, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_released), "N"));
		ComSetObjValue(formObj.frm_t11sheet1_surrender, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_surrender), "N"));
		ComSetObjValue(formObj.frm_t11sheet1_obl_prn_flg, fnNullToBlank(ComGetObjValue(formObj.frm_t11sheet1_obl_prn_flg), "N"));
		if (sheetObj.GetCellValue(1, prefix1 + "iss_save_flg")== "N") {
			ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, "B");
			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, "3");
		}
		if('' == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)){
			ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, 'B');		
		}
//		if("0" == ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no)){
//			if("B" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)){
//				ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, "3");
//			}else if("W" == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)){
//				ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, "1");
//			}
//		}		
		if('L' == ComGetObjValue(formObj.frm_t11sheet1_o_blreceive_type)){
			ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, 'L');	
		}else if('' == ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)){
			ComSetObjValue(formObj.frm_t11sheet1_o_blreceive_type, 'B');
		}
		if("Y" == ComGetObjValue(formObj.frm_t11sheet1_internet_auth)){
//			eval('DIV_btn_t11InternetAUTH').style.display = 'none';
//			eval('DIV_btn_t11CancelAUTH').style.display = 'block';
			document.all.btn_t11InternetAUTH.style.display="none";
			document.all.btn_t11CancelAUTH.style.display="";
		}else{
//			eval('DIV_btn_t11InternetAUTH').style.display = 'block';
//			eval('DIV_btn_t11CancelAUTH').style.display = 'none';
			document.all.btn_t11InternetAUTH.style.display="";
			document.all.btn_t11CancelAUTH.style.display="none";
			document.getElementById('web_print_approved').innerHTML = '';
		}
		setChangeColor();
		try{
			// C/A button  Control 
			parent.initIssueCAControl(ComGetObjValue(formObj.bkg_no),ComGetObjValue(formObj.caflag),	ComGetObjValue(formObj.bdrflag),ComGetObjValue(formObj.ca_exist_flg),ComGetObjValue(formObj.bl_no));
		}catch(e){}
		
		if(ComGetObjValue(formObj.isInquiry) == "Y"){
			setInquiryDisableButton();
		}else{
			if(formObj.frm_t11sheet1_bkg_sts.value == "X"){
				ComBtnDisable("btn_t11BLPrint");
			}else{
				ComBtnEnable("btn_t11BLPrint");
			}
		}
	} catch (ex) {
		fnBkgErrorAlert('t11sheet1_OnSearchEnd', ex);
		return false;
	}
	initFrist=false;
}
 /**
 * setChangeColor
 * color change
 * param : 
 */
 function setChangeColor() {
	var formObj=document.form;
	// Error: color change
	if ('E' == ComGetObjValue(formObj.frm_t11sheet1_bkg_sts)) {
		formObj.frm_t11sheet1_bkg_sts.style.color='red';
	}else{
		formObj.frm_t11sheet1_bkg_sts.style.color='';
	}
	// frm_t11sheet1_issued Color 
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_issued)){
		document.getElementById('frm_t11sheet1_issued').style.color="red";
		document.getElementById('frm_t11sheet1_issued').style.fontWeight="bold";
	}else{
		document.getElementById('frm_t11sheet1_issued').style.color="";
		document.getElementById('frm_t11sheet1_issued').style.fontWeight="";
	}
	// frm_t11sheet1_released Color 
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_released)){
		document.getElementById('frm_t11sheet1_released').style.color="red";
		document.getElementById('frm_t11sheet1_released').style.fontWeight="bold";
	}else{
		document.getElementById('frm_t11sheet1_released').style.color="";
		document.getElementById('frm_t11sheet1_released').style.fontWeight="";
	}
	// frm_t11sheet1_obl_prn_flg Color 
	if("Y" == ComGetObjValue(formObj.frm_t11sheet1_obl_prn_flg)){
		document.getElementById('frm_t11sheet1_obl_prn_flg').style.color="red";
		document.getElementById('frm_t11sheet1_obl_prn_flg').style.fontWeight="bold";
	}else{
		document.getElementById('frm_t11sheet1_obl_prn_flg').style.color="";
		document.getElementById('frm_t11sheet1_obl_prn_flg').style.fontWeight="";
	}
 }
/**
* tpbImgSet
* TPB -> Image configuration and code set values
* param : tpbStatus
*/
function tpbImgSet(tpbStatus) {
	if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;
    if(document.getElementById("tpb_status").value == 1){
        document.getElementById("tpb_icon").src="img/btng_icon_green.gif";
        document.getElementById("tpb_cd").value='C';
    }else if(document.getElementById("tpb_status").value == 0){
        document.getElementById("tpb_icon").src="img/btng_icon_r.gif";
        document.getElementById("tpb_cd").value='P';
    }else{
        document.getElementById("tpb_icon").src="img/btng_icon_g.gif";
        document.getElementById("tpb_cd").value='';
    }
}
/**
 * fnBlReadyCheckbox
 * param : r_obj
 */
var tmp_bl_ready_by="" ;
var tmp_bl_ready_office="" ;
var tmp_bl_ready_date="" ;
function fnBlReadyCheckbox(r_obj) {
	var formObj=document.form;
	if (r_obj.checked) {
		/*	1. B/L Ready  By, Date, Office : the information set to the current User 
		 */
		tmp_bl_ready_by=ComGetObjValue(formObj.frm_t11sheet1_bl_ready_by);
		tmp_bl_ready_office=ComGetObjValue(formObj.frm_t11sheet1_bl_ready_office);
		tmp_bl_ready_date=ComGetObjValue(formObj.frm_t11sheet1_bl_ready_date);
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_by	, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_office, ComGetObjValue(formObj.strOfc_cd));
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_date	, ComGetNowInfo());	
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_by	, tmp_bl_ready_by);
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_office, tmp_bl_ready_office);
		ComSetObjValue(formObj.frm_t11sheet1_bl_ready_date	, tmp_bl_ready_date);
	}
}
/**
 * fnBlProofbyshipperCheckbox
 * param : s_obj
 */
var tmp_bl_proofbyshipper_by='' ;
var tmp_bl_proofbyshipper_office='';
var tmp_bl_proofbyshipper_date='' ;
function fnBlProofbyshipperCheckbox(s_obj) {
	var formObj=document.form;
	if (s_obj.checked) {
		/*1. B/L PROOF BY SHIPPER  By, Date ->the information set to the current User 
		2. docPrcModyFlg -> 'Y' setting
		 */
		tmp_bl_proofbyshipper_by=ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_by);
		tmp_bl_proofbyshipper_office=ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_office);
		tmp_bl_proofbyshipper_date=ComGetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_date);
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_by, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_office, ComGetObjValue(formObj.strOfc_cd));
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_date, ComGetNowInfo());
		ComSetObjValue(formObj.frm_t11sheet1_doc_proc_modyflg, "Y");
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_by , tmp_bl_proofbyshipper_by);
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_office, tmp_bl_proofbyshipper_office);
		ComSetObjValue(formObj.frm_t11sheet1_bl_proofbyshipper_date, tmp_bl_proofbyshipper_date);
		ComSetObjValue(formObj.frm_t11sheet1_doc_proc_modyflg, "N");
	}
}
function fnDateSetCheckbox(r_obj) {
	var formObj=document.form;
	if (r_obj.checked) {
		tmp_pol_etd_dt=ComGetObjValue(formObj.frm_t11sheet1_pol_etd_dt);
		ComSetObjValue(formObj.frm_t11sheet1_on_board_date	, tmp_pol_etd_dt);
	} else {
		tmp_on_board_date='';
		ComSetObjValue(formObj.frm_t11sheet1_on_board_date	, tmp_on_board_date);
	}
}
/**
* fnIssuerSetCheckbox
* param : s_obj
*/
var tmp_bl_issue_by='';
var tmp_bl_issue_at='';
var tmp_bl_issue_date='';
var tmp_bl_iss_tp_cd='';
var tmp_bl_issue_no='';
function fnIssuerSetCheckbox(s_obj) {
	var formObj=document.form;
	if (s_obj.checked) {
		tmp_bl_issue_by=ComGetObjValue(formObj.frm_t11sheet1_bl_issue_by);
		tmp_bl_issue_at=ComGetObjValue(formObj.frm_t11sheet1_bl_issue_at);
		tmp_bl_issue_date=ComGetObjValue(formObj.frm_t11sheet1_bl_issue_date);
//		tmp_bl_issuebl_type=ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd);
		tmp_bl_issue_no=ComGetObjValue(formObj.frm_t11sheet1_bl_issue_no);
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_by, ComGetObjValue(formObj.strUsr_id));
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_at, ComGetObjValue(formObj.strOfc_cd));
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_date, ComGetNowInfo());
//		if("B" == ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type)){
////			ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, "B");
//			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, "3");
//		}else if("W" == ComGetObjValue(formObj.frm_t11sheet1_bl_issuebl_type)){
////			ComSetObjValue(formObj.frm_t11sheet1_bl_issuebl_type, "W");
//			ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, "1");
//		}	
	} else {
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_by, tmp_bl_issue_by);
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_at, tmp_bl_issue_at);
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_date, tmp_bl_issue_date);
//		ComSetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd, tmp_bl_iss_tp_cd);
		ComSetObjValue(formObj.frm_t11sheet1_bl_issue_no, tmp_bl_issue_no);
	}
}
/**
 * fnRadioCheck
 * param : v_obj, v_value
 */
function fnRadioCheck(v_obj, v_value) {
	var radio=document.getElementsByName(v_obj);
	if (radio == null)
		return;
	for ( var i=0; i < radio.length; i++) {
		if (radio[i].value == v_value) {
			radio[i].checked=true;
			break;
		}
	}
}
/**
 * fnNullToBlank
 * param : xval,yval
 */
function fnNullToBlank(xval, yval) {
	return (xval != null && xval != "") ? xval : yval;
}
/**
 * fnExistBlackListedCustomer  
 * param :_val
 */
function fnExistBlackListedCustomer() {
	var formObj=document.form;
	var sheetObj=sheetObjects['t11sheet1'];
	var param="&f_cmd=" + COMMAND02 + "&input_text=" + ComGetObjValue(formObj.frm_t11sheet1_bkg_no);
	var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
	var output_text=ComGetEtcData(sXml, "output_text");
	if (output_text != '') {
		ComShowMessage(ComGetMsg("BKG08099", output_text ));
		return false;// Y-> error
	}
	return true;
}
/**
 * fnSearchMdmLocName  
 * Search condition:LOC_CD Retrieve result: LOC_NM
 * param :sheetObj, ErrMsg
 */
function fnSearchMdmLocName(ltype) {
	var formObj=document.form;
	var sheetObj=sheetObjects['t11sheet1'];
	var objCode=eval('document.form.frm_t11sheet1_' + ltype + '_code');
	var objName=eval('document.form.frm_t11sheet1_' + ltype + '_name');
	var tmp_objCode=objCode.value;
	var tmp_objName=objName.value;
	try {
		var param=param + "&f_cmd=" + SEARCHLIST17 + "&input_text=" + ComGetObjValue(document.getElementById("frm_t11sheet1_" + ltype + "_code"));
		var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
		var output_text=ComGetEtcData(sXml, "output_text");
		if (output_text == '' || output_text == null) {
			ComShowCodeMessage("BKG00061");
			ComSetObjValue(objName, '');
		} else {
			ComSetObjValue(objName, output_text.toUpperCase());
		}
	} catch (ex) {
		fnBkgErrorAlert('fnSetSelectNumberBox', ex);
	}
}

/**
* bkgSplitNoList BKG_List Event
* param :split_list
*/
function bkgSplitNoList(split_list){
	document.form.frm_t11sheet1_bkg_no.value=split_list.options[split_list.selectedIndex].value;
	span_bkg_no.style.display="none";
}
/**
* blSplitNoList BKG_List Event 
* param :split_list
*/
function blSplitNoList(split_list){
	document.form.frm_t11sheet1_bl_no.value=split_list.options[split_list.selectedIndex].value;
	span_bl_no.style.display="none";
}
var Select_Bkg_No_Html=null;
var Select_Bl_No_Html=null;
/**
 * fnSetSelectNumberBox table Generation Event. param :formObj_id,
 * formObj_value=Variable, a value of data, data, two values
 */
function fnSetSelectNumberBox(_name, _type) {
	var vobj=eval("document.all." + _name); 
	var sheetObj=sheetObjects['t11sheet1'];
	var formObj=document.form;
	var html="";
	try {
		switch (_type) {
		case 'text_bkg_no': //text
				if(ComIsEmpty(formObj.frm_t11sheet1_bkg_no.value)){
					ComShowMessage(ComGetMsg("BKG08019"));
					formObj.frm_t11sheet1_bkg_no.focus();
					return false;
				}
				if (null == Select_Bkg_No_Html || ComGetObjValue(formObj.bkg_no) != ComGetObjValue(formObj.frm_t11sheet1_bkg_no)) {
					var param="&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.frm_t11sheet1_bkg_no);
					var rXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", param);
					Select_Bkg_No_Html=ComGetEtcData(rXml, "bkg_split_no_list");
					if(Select_Bkg_No_Html.indexOf("<option") < 0) return false;
				}
				var obj=formObj.frm_t11sheet1_bkg_no;
				var top=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight + 10;
				var left=document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft + 10;
				vobj.innerHTML=Select_Bkg_No_Html;
				vobj.style.top=top;					
				vobj.style.left=left;
				vobj.style.display="inline";
		return;
			break; 
		case 'text_bl_no': //text
				if(ComIsEmpty(formObj.frm_t11sheet1_bl_no.value)){
					ComShowMessage(ComGetMsg("BKG00609"));
					formObj.frm_t11sheet1_bl_no.focus();
					return false;
				}
				if (null == Select_Bl_No_Html || ComGetObjValue(formObj.bl_no) != ComGetObjValue(formObj.frm_t11sheet1_bl_no)) {
					fnSetBlNoStringCheck(ComGetObjValue(formObj.frm_t11sheet1_bl_no));
					var param=param + "&f_cmd=" + SEARCHLIST15 + "&input_text=" + ComGetObjValue(formObj.bl_no);
					var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
					var output_text=ComGetEtcData(sXml, "output_text");
					output_text=output_text + '^' + output_text;
					Select_Bl_No_Html=fnSetSelectString('fnSetBlNo', output_text);
				}
				var obj=formObj.frm_t11sheet1_bl_no;
				var top=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight + 10;
				var left=document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft + 10;
				vobj.innerHTML=Select_Bl_No_Html;
				vobj.style.top=top;					
				vobj.style.left=left;
				vobj.style.display="inline";
			break;
		}
	} catch (ex) {
		fnBkgErrorAlert('fnSetSelectNumberBox', ex);
	}
}
/**
* fnSetBlNoStringCheck BL_Number Check
* ComGetObjValue(formObj.frm_t11sheet1_bl_no)
* param :
*/
function fnSetBlNoStringCheck(t_bl_no) {
	var formObj=document.form;
	if ('W' != ComGetObjValue(formObj.frm_t11sheet1_bl_iss_tp_cd)) {
		if(t_bl_no.length>12){
			 ComSetObjValue(formObj.bl_no, t_bl_no.substr(0,12));
		}else{
			ComSetObjValue(formObj.bl_no, t_bl_no);
		}
	}else{
		ComSetObjValue(formObj.bl_no, t_bl_no);
	}
}
/**
 * fnSetSelectString table Generation Event
 * param :formObj_id, formObj_value=Variable, a value of data, data, two values
 */
function fnSetSelectString(_name, _value) {
	var html="";
	try {
		var aList=_value.split("^");
		var aCode, aName;
		var aCode=aList[0].split("$");
		var aName=aList[1].split("$");
		var len=aCode.length;
		if (len == 0)
			return;
		html="<select style='width:110;' class='input' size=5 multiple onChange='javascript:blSplitNoList(this);' name='" + _name + "'>"
		for ( var z=0; z < len; z++) {
			html += "<option value='" + aCode[z] + "'>" + aName[z] + "</option>";
		}
		html += "</table>";
	} catch (ex) {
		fnBkgErrorAlert('fnSetSelectString', ex);
	}
	return html;
}
/**
 * Validation of HTML Control onblur Event <br>
 **/
 var temp_value='';
function obj_activate() {
	//Input Validation to check
	switch (event.srcElement.name) {
	case "frm_t11sheet1_on_board_date":
		ComClearSeparator(ComGetEvent());
		break;
	case "frm_t11sheet1_bl_issue_date":
		ComClearSeparator(ComGetEvent());
		break;
	case "frm_t11sheet1_bl_proofbyshipper_date":
		ComClearSeparator(ComGetEvent());
		break;
	case "frm_t11sheet1_bl_ready_date":
		ComClearSeparator(ComGetEvent());
		break;		
	}
	 if(eval('document.form.'+ ComGetEvent("name")).value.length > 0){
		 temp_value=eval('document.form.'+ ComGetEvent("name")).value;
	 }
}
/**
 * Validation of HTML Control onblur Event <br>
 **/
function obj_deactivate() {
	 var formObj=document.form;
	 
	 //frm_t11sheet1_obl_iss_rmk 변경체크로직 수정
	 if(ComGetEvent("name") == "frm_t11sheet1_obl_iss_rmk") return;
	 
	 if(eval('document.form.'+ ComGetEvent("name")).value.length > 0){
		 if(temp_value != "" && temp_value != eval('document.form.'+ ComGetEvent("name")).value){
			 ComSetObjValue(formObj.modify_flag, "Y");	 
		 }
	}
	// Input Validation to check
	switch (event.srcElement.name) {
		case "frm_t11sheet1_on_board_date":
			ComAddSeparator(ComGetEvent());
			break;
		case "frm_t11sheet1_bl_issue_date":
			ComAddSeparator(ComGetEvent());
			break;
		case "frm_t11sheet1_bl_proofbyshipper_date":
			ComAddSeparator(ComGetEvent());
			break;
		case "frm_t11sheet1_bl_ready_date":
			ComAddSeparator(ComGetEvent());
			break;
//		case "frm_t11sheet1_bkg_no":
//		case "frm_t11sheet1_bl_no":
//			var srcName=ComGetEvent("name");
//			var srcValue=window.event.srcElement.getAttribute("value");
//			formObj.elements[srcName].value=srcValue.toUpperCase();
//			break;

	}
}
function check_Enter() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (event.keyCode == 13) {
		if(ComGetEvent("name") == "frm_t11sheet1_obl_iss_rmk") return;
		if(ComGetEvent("name") == "frm_t11sheet1_bkg_no" || ComGetEvent("name") == "frm_t11sheet1_bl_no" ){
			//fnClearForm(); 
			doActionIBSheet(sheetObjects['t11sheet1'], document.form, IBSEARCH);
		}
	}
}
/**
 * fngBkgToolTipMove Event
 * Move Tooltips
 * param :evt
 */
function fngBkgToolTipMove(event) {
	if (navigator.appName == "Netscape") {
		helpbox.style.left = (event.pageX + 10) + "px";
		helpbox.style.top = (event.pageY + 20) + "px";
	} else {
		helpbox.style.posLeft=event.x + 10 + document.body.scrollLeft;
		helpbox.style.posTop=event.y + 20 + document.body.scrollTop;
	}
}
/**
 * fngBkgToolTipView Event
 * Show Tooltips
 * param :str
 */
function fngBkgToolTipView(_name) {
	var obj=eval("document.all." + _name); 
	var str=bkgMAP.get(ComGetObjValue(obj));
	if(str == null || str == 'undefined') return;
	var text;
	if("B" == obj.value){
		helpbox.style.width = "80px"
	}else{
		helpbox.style.width = "80px"
	}
	
	text='<table align="center" border="1" cellpadding="10" cellspacing="0" style="border-width:3; border-color:black; background-color:#eaf3ff ;border-style:solid;font-size:9pt;">';
	text += '<tr><td align=center>' + str + '</td></tr></table>';
	helpbox.innerHTML=text;
}
/**
 * fngBkgToolTipHide Event
 * Hide Tooltips 
 * param :
 */
function fngBkgToolTipHide() {
	helpbox.innerHTML='';
}
/**
 * fnBkgJsMap  
 * javascript Array Map
 * param :
 */
function fnBkgJsMap() {
	this._array=new Array();// Map array
	this.pointer=0;
	this._getIndexByKey=function(key) {
		for ( var i=0; i < this._array.length; i++) {
			if (key == this._array[i][0]) {
				return i;
			}
		}
		return -1;
	}
	this.put=function(key, value) {
		var index=this._getIndexByKey(key)
		if (index == -1) {
			var newArray=new Array();// key,value array
			newArray[0]=key;
			newArray[1]=value;
			this._array[this._array.length]=newArray;
		} else {
			this._array[index][1]=value;
		}
	}
	this.get=function(key) {
		for ( var i=0; i < this._array.length; i++) {
			if (this._array[i][0] == key)
				return this._array[i][1];
		}
	}
	this.containsKey=function(key) {
		for ( var i=0; i < this._array.length; i++) {
			if (this._array[i][0] == key)
				return true;
		}
		return false;
	}
	this.isNext=function() {
		var result;
		if (this._array.length > this.pointer) {
			result=true;
		} else {
			result=false;
		}
		this.pointer++;
		return result;
	}
	this.getKeyString=function(_type) {
		var _result='';
		if (_type == null)
			_type='|';
		for ( var i=0; i < this._array.length; i++) {
			_result=_result + _type + this._array[i][0];
		}
		return _result;
	}
	this.size=function() {
		return this._array.length;
	}
	this.nowKey=function() {
		return this._array[this.pointer - 1][0];
	}
	this.nowValue=function() {
		return this._array[this.pointer - 1][1];
	}
}
/**
* BlNo Information (Balloons Help)
* param : 
*/
function blNoSet(){
	var obj=document.form.frm_t11sheet1_bl_no;
	orgBlNo.style.left="300px";
	orgBlNo.style.top="57px";	
	orgBlNo.style.width = "110px"
	var strMsg=document.form.frm_t11sheet1_bl_no.value;
	if(strMsg != ""){
		text='<table  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 13px;"><tr><td>' + strMsg + '</td></tr></table>';
		orgBlNo.innerHTML=text;
	}
}
/**
* blNoHide
* param : 
*/ 
function blNoHide(){
	orgBlNo.innerHTML='';
}	
/**
* booking split no 
* param : splitno
* @version 2009.06.29
*/
function bkgSplitSet(splitno){
  document.form.frm_t11sheet1_bkg_no.value=splitno;
  document.form.frm_t11sheet1_bkg_no.focus();
  layList.style.display="none";
  isSplitNoOpen=false;
}
/**
 * bkg_error_alert 
 */
function fnBkgErrorAlert(msg, ex) {
	alert('[ ' + msg + ' ]=[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}
/**
* fnExceptionMessage 
*/
function fnExceptionMessage(rXml){
	var rMsg=ComGetEtcData(rXml,"Exception")
	var rmsg=rMsg.split("<||>");
	if(rmsg[3] != undefined && rmsg[3].length > 0) {
		ComShowMessage(rmsg[3]);
	}else{
		sheetObjects[0].LoadSaveData(rXml);
	}
}
/**
* checkModify: tab move save
* param : 
* 0079 running
*/
function checkModify(){
	var formObj=document.form;
	if(ComGetObjValue(formObj.isInquiry) == "Y") return;
	if(ComGetObjValue(formObj.modify_flag) == "Y"){
		tab_alert_msg=false;
		var sheetObj=sheetObjects['t11sheet1'];
		if(!processValidate("btn_t11Save")) return; 
		doActionIBSheet(sheetObj, document.form, IBSAVE);		
	}
}
/**
* searchData : tab move search
* bkgNo : 
* 0079 running
*/
function searchData(bkgNo){
	var formObj=document.form;
	var sheetObj=sheetObjects['t11sheet1'];
	ComSetObjValue(formObj.frm_t11sheet1_bkg_no ,bkgNo);
	ComSetObjValue(formObj.modify_flag,"N");
	doActionIBSheet(sheetObj, formObj, IBSEARCH);       
}  
/**
* setInquiryDisableButton event call .<br>
* ComBtnDisable -> Disabled
* @param 
*/
function setInquiryDisableButton(){
//	ComBtnDisable("btn_t11New");
	ComBtnDisable("btn_t11Save");
	ComBtnDisable("btn_t11BLPreview");	
	ComBtnDisable("btn_t11BLPrint");
	ComBtnDisable("btn_t11SWBEmail");
//	ComBtnDisable("btn_t11OBLRelease");
	ComBtnDisable("btn_t11BLRelease");
	ComBtnDisable("btn_t11FtpSend");
	ComBtnDisable("btn_t11CancelRelease");
//	ComBtnDisable("btn_t11SWBRelease");
	ComBtnDisable("btn_t11OBLSurrender");
	ComBtnDisable("btn_t11InternetAUTH");
	ComBtnDisable("btn_t11CancelAUTH");
	
}
/**
 * Mouse out Event
 */
function bkg007909_blur() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");
	var srcValue=ComGetEvent("value");
//	 if(srcName == "frm_t11sheet1_inet_ctrl_pty_nm" || srcName == "frm_t11sheet1_inet_ctrl_pty_no"){    		
//		if(ComIsNull(srcValue)){
//			formObject.frm_t11sheet1_inet_ctrl_pty_cust_nm.value="";
//		}else{
//			formObject.frm_t11sheet1_inet_ctrl_pty_no.value=ComLpad(srcValue,6,"0");    			
//			if(ComChkLen(formObject.frm_t11sheet1_inet_ctrl_pty_nm.value, 2) == "2"){
//    			searchMdmCustNm(sheetObjects['t11sheet1'],formObject,"IC",formObject.frm_t11sheet1_inet_ctrl_pty_nm.value,formObject.frm_t11sheet1_inet_ctrl_pty_no.value);        					
//			}	
//		}   		
//	}
	if(srcName == "frm_t11sheet1_bl_issue_at"){
		if(!ComIsNull(srcValue)){
			formObject.f_cmd.value=COMMAND02;
    		var param="f_cmd="+ COMMAND02 + "&ofc_cd=" + srcValue;
    		var sXml=sheetObjects['t11sheet1'].GetSearchData("ESM_BKG_0079_09GS.do", param);
    		var chkOfcCd = ComGetEtcData(sXml,"chk_ofc_cd");
    		if(chkOfcCd == "N"){
    			ComShowCodeMessage("BKG01107")
    			formObject.frm_t11sheet1_bl_issue_at.value = "";
    			formObject.frm_t11sheet1_bl_issue_at.focus();
    		}
		}
	}
}

function searchMdmCustNm(sheetObject,formObj,custTp,custCntCd,custSeq){
	ComSetObjValue(formObj.f_cmd,SEARCHLIST11);
	var sXml=sheetObject.GetSearchData("ESM_BKG_0079_05GS.do", "f_cmd="+SEARCHLIST11+"&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq);
	var custNm=ComGetEtcData(sXml,"cust_nm");
	var custAddr=ComGetEtcData(sXml,"cust_addr");
	var custTpCd=ComGetEtcData(sXml,"rvis_cntr_cust_tp_cd")
	if ("IC"==custTp) {
		ComSetObjValue(formObj.frm_t11sheet1_inet_ctrl_pty_cust_nm, custNm ? custNm : "");
	}
}

/**
 * From 'Customer' received value Save <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBackIc0192(rArray, rArray2);
 * </pre>
 * @param Popup -> received values
 * @return 
 * @author 
 * @version 2009.05.14
 */
function callBackIc0192(rArray, rArray2) {
	var formObj=document.form;
	if (rArray2) {
		if (!ComIsNull(formObj.frm_t11sheet1_inet_ctrl_pty_cust_nm)) {
			if (!ComShowCodeConfirm("BKG00343")) return;
		}
		ComSetObjValue(formObj.frm_t11sheet1_inet_ctrl_pty_nm      , rArray2[1]);
		ComSetObjValue(formObj.frm_t11sheet1_inet_ctrl_pty_no         , ComLpad(rArray2[2],6,"0"));
	}else{
		ComSetObjValue(formObj.frm_t11sheet1_inet_ctrl_pty_nm      , rArray[0]);
		ComSetObjValue(formObj.frm_t11sheet1_inet_ctrl_pty_no         , ComLpad(rArray[1],6,"0"));
		ComSetObjValue(formObj.frm_t11sheet1_inet_ctrl_pty_cust_nm         , rArray[7]);
	}
}

/*
 * KEY UP 이벤트 처리
 */
function checkUpdate(obj){
	var updateString = checkSpecial(obj);	//특수문자 제외 로직
	if(obj.value != updateString){
		document.form.modify_flag.value="Y";	//변경사항 체크
	}
}

/*
 * MOUSE PASTE 이벤트
 */
function mousePaste(obj){
	setTimeout(function(){
    	var updateString = checkSpecial(obj);	//특수문자 제외 로직
    	if(obj.value != updateString){
    		document.form.modify_flag.value="Y";	//변경사항 체크
    	}
	}, 100)
}
/*
 * Validate BL if Toyota or General?
 */
function validateToyotaBl(){
	var formObj = document.form;
	var blNo = ComGetObjValue(formObj.bl_no);
	var result = "Y";
	var sXml=sheetObjects['t11sheet1'].GetSearchData("ESM_BKG_0079_09GS.do", "f_cmd="+COMMAND01+"&bkg_no="+ComGetObjValue(formObj.bkg_no));
	var arrXml=sXml.split("|$$|");
	var checkToyota=ComGetEtcData(arrXml[0],"Toyota");
	if(checkToyota == "Y" && blNo.length == 12){
		if(!ComShowConfirm('This B/L may be Toyota B/L.\nWould you like to continue B/L Issue?')){
			result = "N";
			ComSetObjValue(formObj.frm_t11sheet1_issued, 'N');	
			document.getElementById('frm_t11sheet1_issued').style.color="";
			document.getElementById('frm_t11sheet1_issued').style.fontWeight="";
		}		
	}else if(checkToyota == "N"	&& blNo.length == 10){
		if(!ComShowConfirm('This B/L may NOT be Toyota B/L.\nWould you like to continue B/L Issue?')){
			result = "N";
			ComSetObjValue(formObj.frm_t11sheet1_issued, 'N');
			document.getElementById('frm_t11sheet1_issued').style.color="";
			document.getElementById('frm_t11sheet1_issued').style.fontWeight="";
		}
	}
	return result
}

/**
 * call back function after BKG_0700
 * @param _val
 * @return
 */
function getBKG_0059(_val) {
	var formObj = document.form;
	if (_val == null) return;// return in case of null
	var obj=_val;
	
	var iDocRqstTtl = 0;
	
	var oblttl = ComNullToZero(obj.obl_ttl_knt);
	var cpyttl = ComNullToZero(obj.cpy_ttl_knt);
	
	iDocRqstTtl = oblttl + cpyttl; 
	ComSetObjValue(formObj.docRqstTtl, iDocRqstTtl);
}

