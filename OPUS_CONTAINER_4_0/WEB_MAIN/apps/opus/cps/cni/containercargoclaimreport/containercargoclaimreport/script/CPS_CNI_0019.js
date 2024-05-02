/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0019.js
*@FileTitle  : [CPS_CNI_0019] Status Inquiry by Class Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/26
=========================================================*/
/**
 * [CPS_CNI_0019] Status Inquiry by Class Popup 
 * 
 * @extends
 * @classStatus Inquiry by Class Popup 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

function cps_cni_0019() {
	this.processButtonClick=processButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
// common global variables
//IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
var sheet2=null;
//HTML Form
var frm=null;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn1_OK":
				var vHeadTitle="";
				for ( var idx=1; idx <= sheet2.RowCount(); idx++) {
					vHeadTitle += "|" + sheet2.GetCellValue(idx, "savename")
				}
				//ComDebug(vHeadTitle);
				setTemplate(vHeadTitle);
				break;
			case "btn1_Close":
				ComClosePopup(); 
				break;
			case "btns_Add":
				var vSelectPos=sheet1.GetSelectRow();
				if (vSelectPos == 1) {
					ComShowCodeMessage("CNI00037" ,"add");
					//alert("SEQ는 추가할 수 없는 컬럼입니다.");
					return;
				}
				var vPos=sheet1.GetCellValue(vSelectPos, "pos");
				var vHeadTitle=sheet1.GetCellValue(vSelectPos, "headtitle");
				var vColName=sheet1.GetCellValue(vSelectPos, "colname");
				var vSaveName=sheet1.GetCellValue(vSelectPos, "savename")
				var find=sheet2.FindText("headtitle", vHeadTitle);
				if (find > 0) {
					alert(vHeadTitle + " is already selected column");
					return;
				}
				// sheet1.RowDelete(vSelectPos, false);
				var Row=sheet2.DataInsert(vPos);
				// sheet2.RowBackColor(Row) = "#C0C0C0";
				sheet2.SetCellValue(Row, "pos",vPos,0);
				sheet2.SetCellValue(Row, "headtitle",vHeadTitle,0);
				sheet2.SetCellValue(Row, "colname",vColName,0);
				sheet2.SetCellValue(Row, "savename",vSaveName,0);
				break;
			case "btns_Del":
				var vSelectPos=sheet2.GetSelectRow();
				if (vSelectPos == 1) {
					ComShowCodeMessage("CNI00037" ,"delete");
					//alert("SEQ는 삭제할 수 없는 컬럼입니다.");
					return;
				}
				sheet2.RowDelete(vSelectPos, false);
				break;
			case "btns_Up":
				var vSelectPos=sheet2.GetSelectRow();
				if (vSelectPos == 1) {
					ComShowCodeMessage("CNI00037" ,"move");
					//alert("SEQ는 이동할 수 없는 컬럼입니다.");
					return;
				}
				if (vSelectPos == 2) {
					return;
				}
				var vPos=sheet2.GetCellValue(vSelectPos, "pos");
				var vHeadTitle=sheet2.GetCellValue(vSelectPos, "headtitle");
				var vColName=sheet2.GetCellValue(vSelectPos, "colname");
				var vSaveName=sheet2.GetCellValue(vSelectPos, "savename");
				var Row=sheet2.DataInsert(vSelectPos - 1);
				sheet2.SetCellValue(Row, "pos",vPos,0);
				sheet2.SetCellValue(Row, "headtitle",vHeadTitle,0);
				sheet2.SetCellValue(Row, "colname",vColName,0);
				sheet2.SetCellValue(Row, "savename",vSaveName,0);
				sheet2.RowDelete(vSelectPos + 1, false);
				sheet2.SetSelectRow(vSelectPos - 1);
				break;
			case "btns_Down":
				var vSelectPos=sheet2.GetSelectRow();
				if (vSelectPos == 1) {
					ComShowCodeMessage("CNI00037" ,"move");
					//alert("SEQ는 이동할 수 없는 컬럼입니다.");
					return;
				}
				if (vSelectPos == sheet2.RowCount()) {
					alert("No more column down");
					return;
				}
				var vPos=sheet2.GetCellValue(vSelectPos, "pos");
				var vHeadTitle=sheet2.GetCellValue(vSelectPos, "headtitle");
				var vColName=sheet2.GetCellValue(vSelectPos, "colname");
				var vSaveName=sheet2.GetCellValue(vSelectPos, "savename");
				var Row=sheet2.DataInsert(vSelectPos + 2);
				sheet2.SetCellValue(Row, "pos",vPos,0);
				sheet2.SetCellValue(Row, "headtitle",vHeadTitle,0);
				sheet2.SetCellValue(Row, "colname",vColName,0);
				sheet2.SetCellValue(Row, "savename",vSaveName,0);
				sheet2.RowDelete(vSelectPos, false);
				sheet2.SetSelectRow(vSelectPos + 1);
				break;
			case "btns_Get":
				template_class_onchange();
				break;
		} // end switch
	} catch (e) {
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet body 태그의 onLoad 
 * 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 **/
function loadPage() {
	//setting Variables
	frm=document.form;
	sheet1=sheetObjects[0];
	sheet2=sheetObjects[1];
	sheetCnt=sheetObjects.length;
	// sheet initial
	for ( var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//registering initial event 
	initControl();
	sheet1.SetWaitImageVisible(0);
	setSheetData(sheet1,0);
	sheet2.SetWaitImageVisible(0);
	setSheetData(sheet2, 1);
}
/**
* registering initial event 
**/
function initControl() {
	axon_event.addListenerForm('keypress',        'obj_keypress', frm);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	axon_event.addListenerForm('keyup',			   'obj_keyup', frm); 
	axon_event.addListener('change', 'template_class_onchange', 'template_class', '');		// Template
}
/**
* The function called when OnLoad event of page has finished 
* @param {ibsheet} sheet  sheet
*/
 function sheet1_OnLoadFinish(sheet) {
	sheet.SetWaitImageVisible(0);
	setSheetData(sheet,0);
 // sheet.WaitImageVisible = true;
} 
/**
* The function called when OnLoad event of page has finished 
* @param {ibsheet} sheet  sheet
*/
 function sheet2_OnLoadFinish(sheet) {
	sheet.SetWaitImageVisible(0);
	setSheetData(sheet, 1);
	//sheet.WaitImageVisible = true;
} 
/**
 * HTML Control KeyPress event
 */
function obj_keyup() {
	switch (event.srcElement.name) {    
	   case "sheet1autofind":
		   var searchdata=frm.sheet1autofind.value;
		   var sRow=sheet1.FindText("headtitle", searchdata,0,0,false);
		   if (sRow > 0 ) {
			   sheet1.SetTopRow(sRow);
			   sheet1.SetSelectRow(sRow);
		   }
		   break; 
	   case "sheet2autofind":
		   var searchdata=frm.sheet2autofind.value;
		   var sRow=sheet2.FindText("headtitle", searchdata,0,0,false);
		   if (sRow > 0 ) {
			   sheet2.SetTopRow(sRow);
			   sheet2.SetSelectRow(sRow);
		   }
		   break;    
	}
}
/**
 * setting sheet initial values and header
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * adding case as numbers of counting sheets
 **/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
    	case "sheet1": //sheet1 init
			with(sheetObj){
		
		
		 var HeadTitle1="|pos|Column Name|Save Name";
		 var headCount=ComCountHeadTitle(HeadTitle1);
		
		 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		 InitHeaders(headers, info);
		
		 var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"pos",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		     {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"headtitle",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		     {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"savename",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		  
		 InitColumns(cols);
		
		 SetEditable(0);
		 SetSheetHeight(302);
    	}
		 break;
    case "sheet2": //sheet1 init
		 with(sheetObj){
		
		var HeadTitle1="|pos|Column Name|Save Name";
		var headCount=ComCountHeadTitle(HeadTitle1);
		
		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);
		
		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		  {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"pos",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		  {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"headtitle",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		  {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"savename",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		
		InitColumns(cols);
		
		SetEditable(0);
		SetSheetHeight(302);
    	}
		break;
	}
}
// Handling Sheet's process
function doActionIBSheet(sheetObj,formObj,sAction) {
}
/**
 * handling process for input validation
 **/
function validateForm(sheetObj,formObj,sAction){
}
//===================================================================================
//  Private function
//===================================================================================
/* template을 선택하면 sheet2에 해당 값을 Load
 * 
 */
function template_class_onchange(){
	var vSelectIndex=frm.template_class.options.selectedIndex;
	setSheetData(sheet2,vSelectIndex + 1);
	ComSetObjValue(frm.sheet1autofind,"");
	ComSetObjValue(frm.sheet2autofind,"");
}
/* 화면의 IBsheet에 값을 Load
 * @param sheetObj Sheet Object(sheet1, sheet2) 
 * @param pSelectIndex  Class별 배열 위치
 */
function setSheetData(sheetObj, pSelectIndex){
	// 해쉬테이블 생성(HashTable Function 참조)
	var sheetHash=new HashTable();
	// 전체 항목을 해쉬테이블에 담는다.	
	sheetHash.put("SEQ"               ,  "seq");
	sheetHash.put("Class"             ,  "cgo_clm_div_cd");
	sheetHash.put("Claim NO."         ,  "cgo_clm_no");
	sheetHash.put("A"                 ,  "clm_area_cd");
	sheetHash.put("HOFC"              ,  "hdlr_ofc_cd");
	sheetHash.put("ROFC"              ,  "fmal_clm_rcv_ofc_cd");
	sheetHash.put("Handler"           ,  "hdlr_usr_id1");
	sheetHash.put("Manager"           ,  "hdlr_usr_id2");
	sheetHash.put("STS"               ,  "cgo_clm_sts_cd");
	sheetHash.put("LIT"               ,  "lit");
	sheetHash.put("DOC"               ,  "cs_clz_dt");
	sheetHash.put("HPD"               ,  "hpd");
	sheetHash.put("NHP"               ,  "nhp");
	sheetHash.put("DON"               ,  "prlm_clm_ntc_dt");
	sheetHash.put("DOF"               ,  "fmal_clm_rcv_dt");
	sheetHash.put("DOU"           ,  "upd_dt");
	sheetHash.put("T"                 ,  "clmt_clm_tp_cd");
	sheetHash.put("Claimant"          ,  "clm_pty_abbr_nm1");
	sheetHash.put("Claimant’s Agent"  ,  "clm_pty_abbr_nm2");
	sheetHash.put("Lane"              ,  "slan_cd");
	sheetHash.put("VVD"               ,  "trnk_ref_vvd_no");
	sheetHash.put("B/L No."           ,  "cgo_clm_ref_bl_no");
	sheetHash.put("CNTR NO."          ,  "cgo_clm_ref_cntr_no");
	sheetHash.put("TP/SZ"             ,  "tp_sz");
	sheetHash.put("CNT"               ,  "cnt");
	sheetHash.put("CT"                ,  "crr_term_cd");
	sheetHash.put("POR"               ,  "por_cd");
	sheetHash.put("DOR"               ,  "rct_dt");
	sheetHash.put("POL"               ,  "pol_cd");
	sheetHash.put("POD"               ,  "pod_cd");
	sheetHash.put("DEL"               ,  "del_cd");
	sheetHash.put("DDL"               ,  "de_dt");
	sheetHash.put("DOTB"              ,  "clm_tm_bar_dt");
	sheetHash.put("LP DOTB"           ,  "labl_tm_bar_dt");
	sheetHash.put("FVD"               ,  "fvd");
	sheetHash.put("PRE_POT"           ,  "n1st_pre_ts_loc_cd");
	sheetHash.put("ON_POT"            ,  "n1st_pst_ts_loc_cd");
	sheetHash.put("Cargo"             ,  "clm_cgo_tp_nm");
	sheetHash.put("TOC"               ,  "cgo_clm_tp_cd");
	sheetHash.put("CODL1"             ,  "mjr_clm_dmg_lss_cd");
	sheetHash.put("CODL2"             ,  "minr_clm_dmg_lss_cd");
	sheetHash.put("Claim Amount"      ,  "clmt_usd_amt");
    sheetHash.put("DOAK"              ,  "cgo_clm_acknak_dt");
    sheetHash.put("DOFF"              ,  "fact_fnd_dt"); 
	sheetHash.put("TOS"               ,  "cgo_clm_stl_tp_cd");
	sheetHash.put("DOS"               ,  "cgo_clm_stl_dt");
	sheetHash.put("Settled Amount"    ,  "cgo_clm_stl_usd_amt");
	sheetHash.put("POI"               ,  "inci_plc_tp_cd");
	sheetHash.put("Liable Party"      ,  "labl_clm_pty_no");
	sheetHash.put("LP HOFC"           ,  "hndl_ofc_cd");
	sheetHash.put("LP DOF"            ,  "labl_pty_fmal_clm_dt");
	sheetHash.put("LP CAMT"           ,  "labl_pty_dmnd_amt");
	sheetHash.put("LP DOR"            ,  "labl_pty_rcvr_dt");
	sheetHash.put("LP RAMT"           ,  "labl_pty_rcvr_usd_amt");
	sheetHash.put("Insurer"           ,  "insur_pty_abbr_nm");
	sheetHash.put("INS DOF"           ,  "insur_fmal_clm_dt");
	sheetHash.put("INS CAMT"          ,  "insur_dmnd_amt");
	sheetHash.put("INS DOR"           ,  "ins_dor");
	sheetHash.put("INS RAMT"          ,  "insur_rcvr_amt");
	sheetHash.put("Surveyor"          ,  "svey_clm_pty_abbr_nm");
	sheetHash.put("DOSV"              ,  "svey_inp_dt");
	sheetHash.put("Survey Fee"        ,  "svyr_fee_usd_amt");
	sheetHash.put("Salvager"          ,  "slaver_clm_pty_abbr_nm");
	sheetHash.put("DOSL"              ,  "slv_dt");
	sheetHash.put("SL Amount"         ,  "slv_usd_amt");
	sheetHash.put("Applicant"         ,  "applicant");
	sheetHash.put("APOFC"             ,  "apofc");
	sheetHash.put("DOAP"              ,  "doap");
	sheetHash.put("Approver"          ,  "approver");
	sheetHash.put("AVSTS"             ,  "avsts");
	sheetHash.put("AVOFC"             ,  "avofc");
	sheetHash.put("DOAV"              ,  "doav");
	sheetHash.put("Approval No."      ,  "approval_no");
	sheetHash.put("Plaintiff"         ,  "plt_nm");
	sheetHash.put("PL Attorney"       ,  "agn_clm_pty_abbr_nm");
	sheetHash.put("Court"             ,  "crt_nm");
	sheetHash.put("Case No."          ,  "crt_cs_no");
	sheetHash.put("DOSSV"             ,  "smns_sve_dt");
	sheetHash.put("Defendant"         ,  "deft_nm");
	sheetHash.put("Def. Attorney"     ,  "clm_pty_abbr_nm3");
	sheetHash.put("DODAA"             ,  "deft_atty_apnt_dt");
	sheetHash.put("Legal Costs"       ,  "legal_costs");
	sheetHash.put("INC No."           ,  "cgo_clm_inci_no");
	sheetHash.put("VOC No."           ,  "crm_voc_no");
	sheetHash.put("Period 1"          ,  "period1");
	sheetHash.put("Period 2"          ,  "period2");
	sheetHash.put("Period 3"          ,  "period3");
	sheetHash.put("Period 4"          ,  "period4");
	sheetHash.put("Period 5"          ,  "period5");
	sheetHash.put("Period 6"          ,  "period6");
	// Status 템플릿의 각 항목 정의
	// vTemplateClass[0] = 전체 항목
	// vTemplateClass[1] = By Area
	// vTemplateClass[2] = By HOFC
	// vTemplateClass[3] = By Handler
	// vTemplateClass[4] = By Surveyor
	// vTemplateClass[5] = By Liable Party
	// vTemplateClass[6] = By VVD
	// vTemplateClass[7] = By Container
	// vTemplateClass[8] = By Claim Amount
	// vTemplateClass[9] = By Application
	// vTemplateClass[10] = By Settled Amount
	// vTemplateClass[11] = By Litigation
	// vTemplateClass[12] = By Insurer
	// vTemplateClass[13] = By Handling Period
    var vTemplateClass=[
                          "SEQ, Class, Claim NO., A, HOFC, ROFC, Handler, Manager, STS, LIT, DOC, HPD, NHP, DON, DOF, DOU, T, Claimant, Claimant’s Agent, Lane, VVD, B/L No., CNTR NO., TP/SZ, CT, POR, POL, POD, DEL, DDL, DOTB, LP DOTB, FVD, PRE_POT, ON_POT, Cargo, TOC, CODL1, CODL2, Claim Amount, DOAK, DOFF, TOS, DOS, Settled Amount, POI, Liable Party, LP HOFC, LP DOF, LP CAMT, LP DOR, LP RAMT, Insurer, INS DOF, INS CAMT, INS DOR, INS RAMT, Surveyor, DOSV, Survey Fee, Salvager, DOSL, SL Amount, Applicant, APOFC, DOAP, Approver, AVSTS, AVOFC, DOAV, Approval No., Plaintiff, PL Attorney, Court, Case No., DOSSV, Defendant, Def. Attorney, DODAA, Legal Costs, INC No., VOC No., Period 1, Period 2, Period 3, Period 4, Period 5, Period 6" 
                         ,"SEQ, Class, Claim NO., A, HOFC, STS, LIT, Handler, HPD, NHP, DON, DOF, DOU, T, Claimant, VVD, B/L No., CT, POR, POL, POD, DEL, FVD, PRE_POT, ON_POT, Cargo, TOC, CODL1, CODL2, Claim Amount, TOS, DOS, Settled Amount, LP RAMT"
                         ,"SEQ, Class, Claim NO., A, Handler, STS, LIT, HPD, NHP, DON, DOF, DOU, ROFC, T, Claimant, Lane, VVD, B/L No., POR, DEL, DDL, DOTB, LP DOTB, Cargo, TOC, CODL1, CODL2, Claim Amount, TOS, DOS, Settled Amount, Liable Party, LP RAMT, INC No., VOC No."
	                     ,"SEQ, Class, Claim NO., A, ROFC, Manager, STS, LIT, DOC, HPD, NHP, DON, DOF, DOU, T, Claimant, VVD, B/L No., CT, POR, DEL, DDL, DOTB, LP DOTB, Cargo, TOC, CODL1, CODL2, Claim Amount, TOS, DOS, Settled Amount, Liable Party, Surveyor, DOSV"
	                     ,"SEQ, Class, Claim NO., A, HOFC, STS, DON, DOU, T, Claimant, VVD, B/L No., CT, POR, POL, POD, DEL, DDL, FVD, PRE_POT, ON_POT, Cargo, TOC, CODL1, CODL2, Claim Amount, POI, Liable Party, Surveyor, DOSV, Survey Fee, Salvager, DOSL, SL Amount, Insurer"
	                     ,"SEQ, Class, Claim NO., A, HOFC, STS, LIT, DON, DOF, DOU, T, Claimant, VVD, B/L No., CT, POR, DEL, DDL, DOTB, LP DOTB, Cargo, TOC, Claim Amount, TOS, DOS, Settled Amount, POI, Liable Party, LP HOFC, LP DOF, LP CAMT, LP DOR, LP RAMT"
	                     ,"SEQ, Claim NO., A, HOFC, STS, LIT, DOC, DON, DOF, DOU, T, Claimant, Lane, VVD, B/L No., CT, POR, POL, POD, DEL, DDL, FVD, PRE_POT, ON_POT, Cargo, TOC, CODL1, CODL2, Claim Amount, Settled Amount, LP RAMT, Insurer, INS RAMT"
	                     ,"SEQ, Claim NO., A, HOFC, STS, LIT, DON, DOF, T, Claimant, Lane, VVD, B/L No., CNTR NO., TP/SZ, CNT, CT, POR, POL, POD, DEL, DDL, FVD, PRE_POT, ON_POT, Cargo, TOC, CODL1, CODL2, Claim Amount, Settled Amount, POI, LP RAMT, INS RAMT"
	                     ,"SEQ, Claim NO., A, HOFC, STS, LIT, HPD, NHP, DON, DOF, T, Claimant, Claimant’s Agent, VVD, B/L No., CT, POR, POL, POD, DEL, FVD, PRE_POT, ON_POT, Cargo, TOC, CODL1, CODL2, Claim Amount, Settled Amount, LP RAMT, Insurer, INS RAMT"
	                     ,"SEQ, Claim NO., A, HOFC, Handler, STS, LIT, HPD, NHP, DON, DOF, T, Claimant, VVD, B/L No., DEL, DDL, Cargo, TOC, Claim Amount, TOS, DOS, Settled Amount, Applicant, APOFC, DOAP, Approver, AVSTS, AVOFC, DOAV, Approval No."
	                     ,"SEQ, Claim NO., A, HOFC, STS, LIT, HPD, NHP, DON, DOF, T, Claimant, Claimant’s Agent, VVD, B/L No., CT, POR, POL, POD, DEL, FVD, PRE_POT, ON_POT, Cargo, TOC, CODL1, CODL2, Claim Amount, TOS, DOS, Settled Amount, LP RAMT, Insurer, INS RAMT"
	                     ,"SEQ, Claim NO., A, HOFC, Handler, STS, LIT, DOC, HPD, NHP, DON, DOF, DOU, DDL, Cargo, TOC, CODL1, CODL2, Plaintiff, PL Attorney, Defendant, Def. Attorney, Court, Case No., DOSSV, DODAA, Claim Amount, Settled Amount, Legal Costs"
	                     ,"SEQ, Claim NO., A, HOFC, STS, LIT, DOC, DON, DOF, DOU, VVD, B/L No., POR, DEL, DDL, DOTB, LP DOTB, Cargo, TOC, CODL1, CODL2, Claim Amount, DOS, Settled Amount, LP DOR, LP RAMT, Insurer, INS DOF, INS CAMT, INS DOR, INS RAMT"
	                     ,"SEQ, Claim NO., A, HOFC, STS, LIT, HPD, NHP, DON, Period 1, DOF, Period 2, DOAK, Period 3, DOFF, Period 4, TOS, DOS, Period 5, LP DOR, Period 6, INS DOR, T, Claimant, VVD, B/L No., Cargo, TOC, CODL1, CODL2, Claim Amount, Settled Amount, LP RAMT, INS RAMT"
	                     ]; 
    //구분자(',')를 기준으로 배열로 담는다
	var vColName=vTemplateClass[pSelectIndex].split(',');
    var vColCount=vColName.length;
    // XML 문자열 생성 Start
	sXml="<SHEET>";
	sXml=sXml + "<DATA COLORDER='ibflag|pos|headtitle|savename'  COLSEPARATOR='☜☞' TOTAL=' " + vColCount + "'>";
    for (var j=0; j<vColCount; j++){
    	var vHeadName=vColName[j].trim();//반드시 공백 삭제
    	var vSaveName=sheetHash.get(vHeadName);
		if (typeof(vSaveName)== "undefined") vSaveName="";
    	sXml=sXml + "<TR><![CDATA[☜☞" + j + "☜☞" + vHeadName + "☜☞" + vSaveName + "]]></TR>\n";
    }
    sXml=sXml + "</DATA></SHEET>";
    //ComDebug(sXml);
    // XML 문자열 생성 End
    sheetObj.LoadSearchData(sXml,{Sync:1} );
}
/**
* Parent Call
*/
function setTemplate(sheetHeadTitle) { 
	//ComDebug(sheetHeadTitle);
	var report_id=ComGetObjValue(frm.template_class);
	var report_title=ComGetObjText(frm.template_class);
	opener.setTemplate(report_id, report_title, sheetHeadTitle);
  ComClosePopup(); 
}
/**
 * 해쉬테이블 함수
 * @return
 */
function HashTable () {
    var m_objHash=new Object();
    this.put=function (key, value)
    {
        m_objHash[key]=value;
    }
    this.get=function (key)
    {
        return m_objHash[key];
    }
    this.remove=function (key)
    {
        var temp=m_objHash[key];
        delete m_objHash[key];
        return temp;
    }
    this.getKeys=function ()
    {
        var keys=new Array();
        for (var key in m_objHash)
        {
            keys.push(key);
        }
        return keys;
    }
}
