/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CPS_CNI_0048.jsp
 *@FileTitle : CSR Manager
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/**
 * [CPS_CNI_0048] CSR Manager
 * @extends
 * @class 
 */

// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
var sheet2=null;
var sheet3=null;
//IBMultiCombo
var comboObjects=new Array();
var combo1=null
var comboCnt=0;
// html form
var frm=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBCombo Object as list
 * @param comboObj
 **/
function setComboObject(comboObj){
	comboObjects[comboCnt++]=comboObj;
}
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage(year) {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];   
    sheet2=sheetObjects[1];
    sheet3=sheetObjects[2];
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    //registering initial event 
    initControl();
	// IBMultiComboinitializing
	combo1=comboObjects[0];
	comboCnt=comboObjects.length;
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}    
    /* from a month ago ~ to today */
    var sXml=frm.sXml.value;    
    var arrXml=sXml.split("|$$|");
 	// Area
    var areaList = new Array();
    areaList=SheetXml2ListMap(arrXml[0]);
	combo1.InsertItem(0, "All", "");	
	for (i=1; i < areaList.length + 1; i = i+2) {
//		var vo = new Array();
//		vo=areaList[i-1];
		text=areaList[i].code + "|" + areaList[i].name;
		combo1.InsertItem(i, text, areaList[i].code);
	}
	combo1.SetSelectIndex(0);
	// Setting Date
	frm.fm_eff_dt.value=ComGetEtcData(arrXml[0], "FM_EFF_DT");
	frm.to_eff_dt.value=ComGetEtcData(arrXml[0], "TO_EFF_DT");
    // retrieving
    doActionIBSheet(SEARCHLIST01);
    frm.ofc_cd.focus();
}
/**
* registering initial event 
*/
function initControl() {
//	axon_event.addListener('keypress', 'keypressFormat', 'form');	
//	axon_event.addListener('keyup', 'keypressCgoClmNo', 'cgo_clm_no');
//	axon_event.addListener ('keydown', 'keydownEnter', 'form');
	// focus out
    axon_event.addListenerForm('blur', 'obj_deactivate',  frm);    
    // focus in
 //   axon_event.addListenerFormat('focus',   'obj_activate',    frm);
}
/**
* Combobox Initialize, Header Definition 
* @param {object} comboObj Mandatory, IBMultiCombo Object
* @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
**/
function initCombo(comboObj, comboNo) {
	with (comboObj) {
		comboObj.SetMultiSelect(0);
//no support[check again]CLT 		comboObj.UseCode=true;
//no support[check again]CLT 		comboObj.LineColor="#ffffff";
		comboObj.SetBackColor("#ffffff");
		comboObj.SetColAlign(0, "center");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(190);
	}
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
            // setting height
			
			var HeadTitle1="|Seq.|CSR No.|Area|Invoice\nOffice|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error\nReason|No. of\n Invoice|Currency|Total\nAmount|Payment\nDue Date|Payment\nGroup|attr_ctnt2|iss_dt|rcv_dt|vndr_term_nm|aft_act_flg|if_flg|rcv_err_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|apro_rqst_no|cost_ofc_cd" ;
			var headCount=ComCountHeadTitle(HeadTitle1);
			(headCount, 8, 0, true);
			FrozenCols=3;

			SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"" },
			             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"inv_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"if_status",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"if_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"if_err_rsn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"no_of_inv",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"csr_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"csr_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"due_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"pay_grp_lu_cd",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"attr_ctnt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"vndr_term_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"aft_act_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"if_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"rcv_err_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			 
			InitColumns(cols);
			SetSheetHeight(420);
			SetEditable(0);
			break;			
		case "sheet2" :
			// setting height
            //no support[check again]CLT style.height=GetSheetHeight(13);
            //setting width
		    (24, 1, 0, true);
		    var HeadTitle="csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt|pay_curr_cd|pay_amt|apro_step|title|chk_addr1|chk_addr2|chk_addr3|chk_cty_nm|chk_ste_cd|chk_zip_cd|chk_cnt_cd" ;

		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    InitHeaders(headers, info);

		    var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"pre_csr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_office",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_prpd_dy",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_to",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_csr_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_group",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_evi_tp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_due_date",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_asa_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_inv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"apro_step",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_title",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_addr1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_addr2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_addr3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_cty_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_ste_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_zip_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		     
		    InitColumns(cols);

		    SetEditable(1);
		   
			break;
		case "sheet3" :
            // setting height
            //no support[check again]CLT style.height=GetSheetHeight(13);
            //setting width
//			(10, 1, 0, true);
			var HeadTitle="char of account|account name|gl date|city|inv no|desc|debit|credit|debit2|credit2" ;

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_chart_of_account",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_account_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pre_gl_date",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_city",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_debit",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_credit",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"pre_debit2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"pre_credit2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			 
			InitColumns(cols);

			SetEditable(1);	
			break;
		}
	}
}
/**
 * setting Location
 */
function setLocation(rowArray) { 
   frm.loc_cd.value=rowArray[0][3];
}
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {	
		case "btng_retrieve":
			if (ComChkValid(frm)) {
				doActionIBSheet(SEARCHLIST01);
			}
			break;
		case "btng_new":
    		ComResetAll();
    		combo1.SetSelectIndex(0);
    		// setting date
    	    var sXml=frm.sXml.value;    
    	    var arrXml=sXml.split("|$$|");
    		frm.fm_eff_dt.value=ComGetEtcData(arrXml[0], "FM_EFF_DT");
    		frm.to_eff_dt.value=ComGetEtcData(arrXml[0], "TO_EFF_DT");			
			frm.ofc_cd.focus();
			break;
		case "btng_csrformat":
			if (sheet1.RowCount()<= 0){
				//msgs['CNI25006'] = 'There is no data retrieved.' ;
				ComShowCodeMessage("CNI25006");
				return false;
			}
			if (sheet1.GetSelectRow()==undefined || sheet1.GetSelectRow()==null || sheet1.GetSelectRow()==0) {
				//msgs['CNI21908'] = 'There is no row selected.';
				ComShowCodeMessage("CNI21908");
				return false;
			}
			if (sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no')==undefined ||
					sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no')==null ||
					sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no').trim()==''){
				//msgs["CNI40048"] = "There is no CSR No. on selected row." ;
				ComShowCodeMessage("CNI40048");
				return false;
			}
			sheet2.RemoveAll();
			sheet3.RemoveAll();
			doActionIBSheet1(sheet2,frm,IBSEARCH);
			break;			
		case "btns_Calendar2" :		// Agreement Date (To Date)
	 		var cal=new ComCalendarFromTo();
	        cal.select(frm.fm_eff_dt,  frm.to_eff_dt,  'yyyy-MM-dd');
	 		break;   			
		case "btng_invoicelistinquiry":
			if (sheet1.RowCount()<= 0){
				//msgs['CNI25006'] = 'There is no data retrieved.' ;
				ComShowCodeMessage("CNI25006");
				return false;
			}
			if (sheet1.GetSelectRow()==undefined || sheet1.GetSelectRow()==null || sheet1.GetSelectRow()==0){
				//msgs['CNI21908'] = 'There is no row selected.';
				ComShowCodeMessage("CNI21908");
				return false;
			}
			if (sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no')==undefined ||
					sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no')==null ||
					sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no').trim()==''){
				//msgs["CNI40048"] = "There is no CSR No. on selected row." ;
				ComShowCodeMessage("CNI40048");
				return false;
			}
			var csrNo=sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no');
			var costOfcCd=sheet1.GetCellValue(sheet1.GetSelectRow(),'cost_ofc_cd');
			var currCd=sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_curr_cd');
			var invSubSysCd=document.form.inv_sub_sys_cd.value;
			 ComOpenWindow("COM_CSR_0011.do?csr_no="+csrNo+"&cost_ofc_cd="+costOfcCd+"&inv_sub_sys_cd="+invSubSysCd+"&curr_cd="+currCd,  window,  "dialogWidth:820px; dialogHeight:500px; help:no; status:no; scroll:no; resizable:no;" , true);
			break;
		case "btng_viewapprovalstep":
			if (sheet1.RowCount()<= 0){
				//msgs['CNI25006'] = 'There is no data retrieved.' ;
				ComShowCodeMessage("CNI25006");
				return false;
			}
			if (sheet1.GetSelectRow()==undefined || sheet1.GetSelectRow()==null || sheet1.GetSelectRow()==0){
				//msgs['CNI21908'] = 'There is no row selected.';
				ComShowCodeMessage("CNI21908");
				return false;
			}
			if (sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no')==undefined ||
					sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no')==null ||
					sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no').trim()==''){
				//msgs["CNI40048"] = "There is no CSR No. on selected row." ;
				ComShowCodeMessage("CNI40048");
				return false;
			}
			var apro_rqst_no=sheet1.GetCellValue(sheet1.GetSelectRow(), "apro_rqst_no");
			if (apro_rqst_no==undefined || apro_rqst_no==null || apro_rqst_no.trim()==''){
				//msgs["CNI40041"] = "{?msg1} has been omitted." ;
				ComShowCodeMessage("CNI40041","Approval Request No");
				return false;
			}
			//var url = "/clt/COM_ENS_0W1.do?apro_rqst_no="+apro_rqst_no;
			//window.showModalDialog(url, window, "dialogWidth:640px; dialogHeight:310px; help:no; status:no; resizable:yes;");
			var param="?apro_rqst_no="+apro_rqst_no;
				ComOpenPopup('COM_ENS_0W1.do' + param, 640, 470, '', 'none', true);
			break;
		case "btng_print":
 			//sheet1.Down2Excel();
 			if(sheet1.RowCount() < 1){//no data
                ComShowCodeMessage("COM132501");
           }else{
        	   sheet1.Down2Excel({ HiddenColumn:true});
           }
			break;
	}
}
/**
 * HTML Control KeyPress event
 */
//function keypressCgoClmNo() {
// 	var obj=event.srcElement;
//    switch(ComGetEvent("name")) {    
//    case "cgo_clm_no":
//    	if (obj.value.length == 10) {    		
//    		doActionIBSheet(SEARCHLIST01);
//    	}
//    	break;
//	}
//}
 /**
  * HTML Control KeyPress event
  */
 function keypressFormat() {
  	var obj=event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus=obj.dataformat;
     switch(ComGetEvent("name")) {
     case "ofc_cd":
     case "search_csr_no":
     	KeyOnlyUpper();
      	break;      	
 	}
 }
  /**
   * HTML Control KeyDown event
   */
  function keydownEnter() {
  	if (event.keyCode != 13) {
  		return;
  	}
  	var obj=event.srcElement;
     switch(ComGetEvent("name")) {    
     case "ofc_cd":     	
     	if (obj == null || 
     			obj.value.length < 5 ||  obj.value.length > 6 ) {
     		return;
     	}
 		doActionIBSheet(SEARCHLIST01);
     	break;          	
     case "search_csr_no":     	
      	if (obj == null || obj.value.length < 3  ) {
      		return;
      	}
  		doActionIBSheet(SEARCHLIST01);
      	break;
     }	  
  } 
   /**
    * HTML Control Foucs in
    */
   function obj_activate(){
       ComClearSeparator(event.srcElement);    
   }
   /**
    * HTML Control Focus out
    **/
   function obj_deactivate() {
   	switch (event.srcElement.name) {
   	case "fm_eff_dt":   		
   	case "to_eff_dt":
   		ComChkObjValid(event.srcElement);
   		break;
   	}
   } 
  //===================================================================================
  //Calling function in case of Onchange Event
  //===================================================================================
  /**
  * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
  * @param {int} code Mandatory
  * @param {int} text Mandatory
  * @return
  */
  function combo1_OnChange(comboObj, code, text) {
	frm.clm_area_cd.value="";
	if (code != -1 ) {
	  	frm.clm_area_cd.value=code;
	  	frm.ofc_cd.focus();
	}
  }	 
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;		
 		var sXml=sheet1.GetSearchData("CPS_CNI_0048GS.do", FormQueryString(frm));
		sheet1.LoadSearchData(sXml,{Sync:1} );
	}
}
function doActionIBSheet1(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:
			formObj.f_cmd.value=SEARCH02;
			formObj.csr_no.value=sheet1.GetCellValue(sheet1.GetSelectRow(),'csr_no');
 			var sXml=sheet3.GetSearchData("COM_CSR_00081GS.do", FormQueryString(formObj),"",true);
			var arrXml=sXml.split("|$$|");
			sheet2.LoadSearchData(arrXml[0],{Sync:1} );
			sheet3.LoadSearchData(arrXml[1],{Sync:1} );
       break;
    }
}
function sheet1_OnSearchEnd(sheet1, ErrMsg){
	if (sheet1.RowCount()> 0){
		for (var i=1; i<=sheet1.RowCount(); i++){
if (sheet1.GetCellValue(i,'aft_act_flg')!=null && (sheet1.GetCellValue(i,'aft_act_flg')=='N' || sheet1.GetCellValue(i,'aft_act_flg')=='X')){
				sheet1.SetRowBackColor(i,"#FF9999");
			}
		}
	}
}
function sheet1_OnSaveEnd(sheet1, ErrMsg){
	if (sheet1.RowCount()> 0){
		for (var i=1; i<=sheet1.RowCount(); i++){
if (sheet1.GetCellValue(i,'aft_act_flg')!=null && (sheet1.GetCellValue(i,'aft_act_flg')=='N' || sheet1.GetCellValue(i,'aft_act_flg')=='X')){
				sheet1.SetRowBackColor(i,"#FF9999");
			}
		}
	}
}
function sheet3_OnSearchEnd(sheetObj,errMsg){
 	var srcName=ComGetEvent("name");
    var previewFlg="";
var pre_csr_no=sheet2.GetCellValue(1,"pre_csr_no") 	 ;
var pre_prpd_dy=sheet2.GetCellValue(1,"pre_prpd_dy")  ;
var pre_pay_to=sheet2.GetCellValue(1,"pre_pay_to") 	 ;
var pre_csr_type=sheet2.GetCellValue(1,"pre_csr_type") ;
var pre_desc=sheet2.GetCellValue(1,"pre_desc") 		 ;
var pre_pay_group=sheet2.GetCellValue(1,"pre_pay_group");
var pre_evi_tp=sheet2.GetCellValue(1,"pre_evi_tp") 	 ;
var pre_due_date=sheet2.GetCellValue(1,"pre_due_date") ;
var pre_asa_no=sheet2.GetCellValue(1,"pre_asa_no") 	 ;
var pre_inv_dt=sheet2.GetCellValue(1,"pre_inv_dt") 	 ;
var pre_curr_cd=sheet2.GetCellValue(1,"pre_curr_cd")  ;
var pre_amt=sheet2.GetCellValue(1,"pre_amt") 		 ;
var pre_pay_curr_cd=sheet2.GetCellValue(1,"pre_pay_curr_cd")  ;
var pre_pay_amt=sheet2.GetCellValue(1,"pre_pay_amt") 		 ;
var pre_title=sheet2.GetCellValue(1,"pre_title") 	 ;
var apro_step=sheet2.GetCellValue(1,"apro_step") 	 ;
var chk_addr1=sheet2.GetCellValue(1,"chk_addr1") 	 ;
var chk_addr2=sheet2.GetCellValue(1,"chk_addr2") 	 ;
var chk_addr3=sheet2.GetCellValue(1,"chk_addr3") 	 ;
var chk_cty_nm=sheet2.GetCellValue(1,"chk_cty_nm") 	 ;
var chk_ste_cd=sheet2.GetCellValue(1,"chk_ste_cd") 	 ;
var chk_zip_cd=sheet2.GetCellValue(1,"chk_zip_cd") 	 ;
var chk_cnt_cd=sheet2.GetCellValue(1,"chk_cnt_cd") 	 ;
var ofc_cd=sheet1.GetCellValue(sheet1.GetSelectRow(),'cost_ofc_cd');
	var pre_evi_tp_count="";
	var pre_title="CONSULTATION SLIP";
	var pre_evi_tp;
	if(cnt_cd =="KR"){
		pre_evi_tp_count="1";
		pre_evi_tp=pre_evi_tp;
	}else{
		var sRow=sheet1.FindCheckedRow(1);
		var arrRow=sRow.split("|");
		pre_evi_tp_count=arrRow.length-1;
pre_evi_tp_count=sheet1.GetCellValue(sheet1.GetSelectRow(),'no_of_inv');
		pre_evi_tp=pre_evi_tp+"/"+pre_evi_tp_count;
	} 
	if(pre_curr_cd=="KRW" || pre_curr_cd=="JPY" || pre_curr_cd=="TWD"){
     	previewFlg="krjp";
     	pre_amt=csr_chkAmtFmt(pre_amt,pre_curr_cd);
     	pre_pay_amt=csr_chkAmtFmt(pre_pay_amt,pre_curr_cd);
    }else{
    	pre_amt=csr_chkAmtFmt(pre_amt);
    	pre_pay_amt=csr_chkAmtFmt(pre_pay_amt);
    }
    sheet2.RemoveAll();
	sheet2.DataInsert(-1);
    sheet2.SetCellValue(1,"pre_csr_no",pre_csr_no   );
    sheet2.SetCellValue(1,"pre_prpd_dy",pre_prpd_dy  );
    sheet2.SetCellValue(1,"pre_pay_to",pre_pay_to   );
    sheet2.SetCellValue(1,"pre_csr_type",pre_csr_type );
    sheet2.SetCellValue(1,"pre_desc",pre_desc     );
    sheet2.SetCellValue(1,"pre_pay_group",pre_pay_group);
    sheet2.SetCellValue(1,"pre_evi_tp",pre_evi_tp   );
    sheet2.SetCellValue(1,"pre_due_date",pre_due_date );
    sheet2.SetCellValue(1,"pre_asa_no",pre_asa_no   );
    sheet2.SetCellValue(1,"pre_inv_dt",pre_inv_dt   );
    sheet2.SetCellValue(1,"pre_curr_cd",pre_curr_cd  );
    sheet2.SetCellValue(1,"pre_amt",ComReplaceStr(pre_amt,",",""));
    sheet2.SetCellValue(1,"pre_pay_curr_cd",pre_pay_curr_cd  );
    sheet2.SetCellValue(1,"pre_pay_amt",ComReplaceStr(pre_pay_amt,",",""));
    sheet2.SetCellValue(1,"pre_title",pre_title    );
    sheet2.SetCellValue(1,"apro_step",apro_step    );
    sheet2.SetCellValue(1,"pre_office",ofc_cd);
    sheet2.SetCellValue(1,"chk_addr1",chk_addr1    );
    sheet2.SetCellValue(1,"chk_addr2",chk_addr2    );
    sheet2.SetCellValue(1,"chk_addr3",chk_addr3    );
    sheet2.SetCellValue(1,"chk_cty_nm",chk_cty_nm   );
    sheet2.SetCellValue(1,"chk_ste_cd",chk_ste_cd   );
    sheet2.SetCellValue(1,"chk_zip_cd",chk_zip_cd   );
    sheet2.SetCellValue(1,"chk_cnt_cd",chk_cnt_cd   );
	var v_apro_step='';
	if (sheet1.RowCount()> 0 &&
			(sheet1.GetCellValue(sheet1.GetSelectRow(),'if_status')!='Approval Requested' && sheet1.GetCellValue(sheet1.GetSelectRow(),'if_status')!='Disapproved'))
	{
	}else{
	}
	 ComOpenWindow("COM_CSR_0006.do?previewFlg="+previewFlg+"&previewFlgYN=N",  window,  "dialogWidth:775px; dialogHeight:750px; help:no; status:no; scroll:no; resizable:no;" , true);
}
function csr_chkAmtFmt(src, curr_cd){
	src=new String(src);
	if (src==undefined || src==null || src.trim()==''){
		return '';
	}
	src=csr_deleteComma(src);
	if (curr_cd!=undefined && curr_cd!=null && tes_isNoDecimalPointCurrCD(curr_cd)){
		if (src.indexOf('.') != -1){
			src=src.substring(0,src.indexOf('.'));
		}
		src=csr_addComma(src);
	} else {
		if (src.indexOf('.') == -1){
			src=csr_addComma(src) + '.00'
		} else {
			var temp=src.split(".");
			if (temp.length == 2){
				if (temp[1]==null || temp[1].trim()==''){temp[1]='00';}
				if (temp[1].length == 1){temp[1]=temp[1] + '0';
				} else if (temp[1].length == 2){
				} else if (temp[1].length > 2){temp[1]=temp[1].substring(0,2);
				}
				src=csr_addComma(temp[0])+'.'+temp[1];
			} else if (temp.length > 2){
				var tmp_str='';
				for (var i=1; i<temp.length; i++){
					tmp_str=tmp_str + new String(temp[i]).trim();
				}
				if (tmp_str==null || tmp_str.trim()==''){tmp_str='00';}
				if (tmp_str.length == 1){tmp_str=tmp_str + '0';
				} else if (tmp_str.length == 2){
				} else if (tmp_str.length > 2){tmp_str=tmp_str.substring(0,2);
				}
				src=csr_addComma(temp[0])+'.'+tmp_str;
			} else {
				//showErrMessage('ERR!');
				return false;
			}
		}
	}
	return src;
}
function csr_deleteComma(src){
	// deleting comma
	var src=String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	return src.replace(/,/gi,'');
}
function csr_addComma(src){
	// inputting comma 3-digit
	var src=String(src);
	if (src==null || ComTrim(src)==''){
		return '';
	}
	var re=/(-?\d+)(\d{3})/;
	while (re.test(src)) {
		src=src.replace(re, "$1,$2");
	}
	return  src;
}
