/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0032.js
*@FileTitle  : [CPS_CNI_0032] Incident-Claim Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/**
 * [CPS_CNI_0032] Incident-Claim Inquiry
 * @extends
 * @class Find 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */

// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // initializing       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
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
function loadPage() {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
	//초기값세팅
	if(frm.popupYn.value != "Y"){//팝업으로 열릴때는 inci_no를 받으므로.
		frm.cgo_clm_inci_no.value="INCID"+frm.schToStrGmt.value;
	}
    //registering initial event 
    initControl();
//	ComSetFocus(cgo_clm_inci_no);
	if(frm.popupYn.value == "Y"){
		doActionIBSheet(SEARCHLIST01);	
	}
}
/**
* registering initial event 
*/
function initControl() {
//   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
//   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
 //  axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
 //  axon_event.addListenerFormat('beforeactivate', 'obj_activate',    frm);
//   axon_event.addListenerForm('keyup', 'obj_keyup',frm);
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with(sheetObj){
		              var HeadTitle1="Seq.|CL|Claim No.|A|HOFC|STS|LIT|DOC|NOPC|DOF|DOU|Claimant|VVD|B/L No.|CNTR No.|Term|POR|POL|POD|DEL|DDL|FVD|PRE_POT|ON_POT|Cargo|TOC|Claim Amount|TOS|DOS|Settled Amount|Surveyor|DOSV|Survey Fee|cgo_clm_inci_no|inci_a|inci_rgofc|inci_register|inci_dorg|inci_update|inci_poi|inci_vvd|inci_location|inci_doi|inci_subject";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount, 3, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_div_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"smns_sve_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cs_clz_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prlm_clm_ntc_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fmal_clm_rcv_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt1",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pty_nm1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trnk_ref_vvd_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_ref_bl_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_ref_cntr_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"crr_term_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"de_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"n1st_pre_ref_vvd_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pre_ts_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n1st_pst_ts_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cgo_qlty_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"clmt_locl_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_stl_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_stl_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cgo_clm_stl_usd_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"pty_nm2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svey_inp_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"svyr_fee_usd_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_inci_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inci_plc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inci_ref_vvd_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inci_loc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inci_occr_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"inci_subj_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		              SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		              SetSheetHeight(402);
              }
                break;
        }
    }
// ===================================================================================
// Private function
// ===================================================================================
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn1_Retrieve":
				var cgoClmInciNo=frm.cgo_clm_inci_no.value;
				if (ComIsNull(cgoClmInciNo) || cgoClmInciNo.length != 13) {
					//msgs["CNI00009"] = "Please input {?msg1}";
					ComShowCodeMessage("CNI00009" , "Incident No 13 characters");
					ComSetFocus(frm.cgo_clm_inci_no);
					return;
				}
				sheet1.RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);			
				break;	
			case "btn1_New":
				ComResetAll();
				frm.cgo_clm_inci_no.value="INCID"+frm.schToStrGmt.value;
				ComSetFocus(frm.cgo_clm_inci_no);
				break;
			case "btn1_Print":
				if (sheet1.RowCount()<= 0 ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 
			case "btn1_Down_Excel":
				if(sheet1.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
					sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
				}	
                break;
			case "btn1_close":
				ComClosePopup(); 
	    		break;	
		} // end switch
}
/**
 * HTML Control KeyPress event
 */
//function obj_keypress() {
//    switch (ComGetEvent("name")) {    
//		case "cgo_clm_inci_no":  
//			ComKeyOnlyAlphabet('uppernum');
//			break;
//	}
//}
/**
 * HTML Control KeyDowm event
 */
function obj_keydown() {
	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;     
    if (event.keyCode != 13) {
	  		 return;
	}
    switch (ComGetEvent("name")) {    
		case "cgo_clm_inci_no":
			var cgoClmInciNo=frm.cgo_clm_inci_no.value;
			if (cgoClmInciNo.length != 13) {
				//msgs["CNI00009"] = "Please input {?msg1}";
				ComShowCodeMessage("CNI00009" , "Incident No 13 characters");
				ComSetFocus(frm.cgo_clm_inci_no);
				return;
			}
			if (frm.cgo_clm_inci_no.value.length == 13) {
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;
	}
}
/**
 * HTML Control KeyUp event
 */
//function obj_keyup() {
//	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;  
//    switch (ComGetEvent("name")) {    
//		case "cgo_clm_inci_no":
//			if(frm.cgo_clm_inci_no.value.length == 13){
//				sheet1.RemoveAll();//append mode이므로 remove 해야함.
//				frm.page_no.value="1";
//				doActionIBSheet(SEARCHLIST01);
//			}
//			break;
//	}
//}
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm=document.form;
	switch (ComGetEvent("name")) {
	default:
		ComChkObjValid(ComGetEvent());
	}
}
/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(ComGetEvent());
}
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================

/**
 * row double click 시 CPS_CNI_0003 화면전환
 * @param {IBSheet} sheet
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
 */
function sheet1_OnDblClick(sheet, row, col) {
	var cgoClmNo = sheet1.GetCellValue(row , "cgo_clm_no");
	location.href = "CPS_CNI_0003.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0003&cgo_clm_no=" + cgoClmNo;	
}

function sheet1_OnSearchEnd(sheet, ErrMsg) {
	if(sheet.RowCount()<= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}
	else {
		sheet.SetSumText(0, "Total");
	}
}
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {		
	frm.page_no.value=PageNo;  
	doActionIBSheet(SEARCHLIST01);
}   
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;
	if (sAction == SEARCHLIST01) {
		
		frm.f_cmd.value=SEARCHLIST01;	
 		var sXml=sheet1.GetSearchData("CPS_CNI_0032GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Append:1 , Sync:1} );
			var list=SheetXml2ListMap(arrXml[0]);
			if (list.length > 0) {
				for(var j=0;j<list.length;j++){
					if(list[j]!=undefined){
						var vo=list[j];
						break;
					}
				}
				frm.clm_area_cd2.value=vo["clm_area_cd2"];
				frm.cre_ofc_cd.value=vo["cre_ofc_cd"];
				frm.cre_usr_id.value=vo["cre_usr_id"];
				frm.cre_dt.value=vo["cre_dt"];
				frm.upd_dt2.value=vo["upd_dt2"];
				frm.inci_plc_tp_cd.value=vo["inci_plc_tp_cd"];
				frm.inci_ref_vvd_no.value=vo["inci_ref_vvd_no"];
				frm.inci_loc_cd.value=vo["inci_loc_cd"];
				frm.inci_occr_dt.value=vo["inci_occr_dt"];
				frm.inci_subj_nm.value=vo["inci_subj_nm"];
			}
		}
	} else if (sAction == PRINT) {		
		frm.f_cmd.value=PRINT;
		frm.page_no.value="";//전건조회를 위해 실처리는 DAO 에서 함.
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0087.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]";
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+frm.jsession.value+"] cgo_clm_inci_no["+frm.cgo_clm_inci_no.value+"]";
		frm.com_mrdArguments.value=rf + " " + rv + " " + rpost + " " + rpaper;
		frm.com_mrdBodyTitle.value="Incident-Claim Inquiry-Print";		
		frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaim/incidentsurvey/report/CPS_CNI_0087.mrd";
		popupRd(1000,600);
	} 
}
function cgo_clm_inci_no_onblur(){
	if(frm.cgo_clm_inci_no.value.length == 13){
		doActionIBSheet(SEARCHLIST01);
	}
}
/**
 * handling process for input validation
 */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }
        return true;
    }
    
