/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0016.js
*@FileTitle  : [CPS_GEM_0016] Insurance Recovery by VVD 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23

=========================================================*/
/**
 * [CPS_CNI_0016] Insurance Recovery by VVD
 * @extends
 * @class Insurance Recovery by VVD 대상 검색 및 금액 입력화면
 */

// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
// Main Code Inquiry 팝업 타입
var type="";
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
function loadPage(year) {
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
    //registering initial event 
    initControl();
    if (!ComIsNull(frm.trnk_ref_vvd_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    }	
    // ==================================
    // 본사관리자 만 관리 
    // ==================================
//	ComBtnDisable("btn1_Save");
//	ComBtnDisable("btn1_FileUpload");  
//    if (equalsRole("03") || equalsRole("93")) {
//    	ComBtnEnable("btn1_Save");
//    	ComBtnEnable("btn1_FileUpload");
//    }     
    var sXml2=document.form2.sXml.value;	
 	var arrXml=sXml2.split("|$$|");
 	
 	var dataCount=ComGetTotalRows(arrXml[1]);
	if (dataCount > 0) {
		var list=SheetXml2ListMap(arrXml[1]);	
	 	var listVO=list[0];
	 	clmAreaCd=listVO["clm_area_cd"];
	 	ComSetObjValue(frm.clm_area_cd,clmAreaCd );
	} else {
		var popwin=popupClientDefault(); //calling setup display not existing Area Code
		popwin.focus();
	}
    frm.trnk_ref_vvd_no.focus();
}
/**
* registering initial event 
*/
function initControl() {
//	axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
//	axon_event.addListener ('keyup', 'keyupTrnkRefVvdNo', 'trnk_ref_vvd_no');
//	axon_event.addListener ('keydown', 'keydownEnter', 'form');
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
		        var HeadTitleHidden="|cgo_clm_stl_locl_curr_cd|cgo_clm_stl_xch_rt|clm_area_cd|hdlr_ofc_cd|hdlr_usr_id";
		        var HeadTitle1="|Seq.|STS|Claim No.|Claimed (USD)|Claimed (USD)|Settled (USD)|Settled (USD)|LP Recovered Amount (USD)|LP Recovered Amount (USD)|Net Settled\nAmount(USD)|INS Claimed (USD)|INS Claimed (USD)|INS Recovered (USD)|INS Recovered (USD)" + HeadTitleHidden ;
		        var HeadTitle2="|Seq.|STS|Claim No.|Amount|DOF|Amount|DOS|Amount|LP DOR|Net Settled\nAmount(USD)|Amount|INS DOF|Amount|INS DOR"  + HeadTitleHidden ;
		        var headCount=ComCountHeadTitle(HeadTitle1);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		               {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"data_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_sts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"clmt_usd_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fmal_clm_rcv_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"cgo_clm_stl_usd_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_stl_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"AutoSum",   Hidden:0, Width:97,   Align:"Right",   ColMerge:1,   SaveName:"labl_pty_rcvr_usd_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:77,   Align:"Center",  ColMerge:1,   SaveName:"labl_pty_rcvr_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"rcvr_usd_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"insur_dmnd_usd_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"insur_fmal_clm_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"insur_rcvr_usd_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"insur_rcvr_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_stl_locl_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_stl_xch_rt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"clm_area_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"hdlr_ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"hdlr_usr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
	
		        SetEditable(1);
		   //     InitViewFormat(0, "fmal_clm_rcv_dt", "yyyy-mm-dd");
		   //     InitViewFormat(0, "cgo_clm_stl_dt", "yyyy-mm-dd");
		   //     InitViewFormat(0, "insur_fmal_clm_dt", "yyyy-mm-dd");
		   //     InitViewFormat(0, "insur_rcvr_dt", "yyyy-mm-dd");
		        SetSheetHeight(440);
			break;		
		}
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
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {
		case "btn1_Retrieve":
			if(ComChkValid(frm)) {
				doActionIBSheet(SEARCHLIST01);
			}
			break;	
	    case "btn1_New":
	    	//msgs["CNI00015"] = "Do you want to initialize?";
	    	if (ComShowCodeConfirm("CNI00015")) {
	    		ComResetAll();
	    		frm.trnk_ref_vvd_no.value="";
	    	}	    	
	        break;	
		case "btn1_Save":
			frm.f_cmd.value=MULTI;		
			if(ComChkValid(frm)) {
				//CNI00012(Do you want to save changes?)
				if (ComShowCodeConfirm("CNI00012")) {
					doActionIBSheet(MULTI);
				}
			}			
	        break;
		case "btn1_FileUpload":
			var trnkRefVvdNo=frm.trnk_ref_vvd_no.value;
			if (ComIsNull(trnkRefVvdNo) || trnkRefVvdNo.length != 9) {
				//msgs["CNI00009"] = "Please input {?msg1},";
				ComShowCodeMessage("CNI00009" , "VVD");
				return;
			}
			popupFileUpload("001601" ,trnkRefVvdNo);
	        break;	    	        
		case "btn1_close":
			ComClosePopup(); 
	        break;	  	        
		case "btn1_Print":
			if (sheet1.RowCount()< 1) {
				//msgs["CNI00024"] = "There is no data to print.";
				ComShowCodeMessage("CNI00024");
				frm.trnk_ref_vvd_no.focus();
				return;
			}			
			doActionIBSheet(PRINT);
	        break; 		        
	}
}
/**
 * HTML Control KeyPress event
 */
//function keypressFormat() {
//	if (event.keyCode >= 37 && event.keyCode <= 40) return;
// 	var obj=event.srcElement;
//	if(obj.dataformat == null) return;
//	window.defaultStatus=obj.dataformat;
//    switch(ComGetEvent("name")) {    
//    case "trnk_ref_vvd_no":    
//    	KeyOnlyUpper();
//    	break;
//	}
//}
// /**
//  * HTML Control KeyPress event
//  */
// function keyupTrnkRefVvdNo() {
//  	var obj=event.srcElement;
//     switch(ComGetEvent("name")) {    
//     case "trnk_ref_vvd_no":    
//     	if(obj.value.length == 9) {
//			doActionIBSheet(SEARCHLIST01);		    	
//		}
//     	break;
// 	}
// } 
// /**
//  * HTML Control KeyDown event
//  */
// function keydownEnter() {
// 	if (event.keyCode != 13) {
// 		return;
// 	}
// 	var obj=event.srcElement;
//    switch(ComGetEvent("name")) {    
//    case "trnk_ref_vvd_no":    	
//    	if(ComChkValid(frm)) {
//			doActionIBSheet(SEARCHLIST01);		    	
//		}
//    	break;          	
//	}	  
// } 
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
* The function called when OnDbClick event on Sheet1 triggered 
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
*/
function sheet1_OnDblClick(sheet, row, col) {	
	if (row < 1 || col  > 9) {
		return;
	}	
	var cgoClmNo=sheet.GetCellValue(row, "cgo_clm_no");
	popupClaimMainView(cgoClmNo);
 //	var sUrl="/opuscntr/opusMain.screen?parentPgmNo=CPS_CNI_M001&pgmUrl=^opus^CPS_CNI_0033.do&mainPage=true&pgmNo=CPS_CNI_0033&cgo_clm_no="+cgoClmNo;
 //	var winName="CPS_CNI_0033";
 // 	var reqWin=ComOpenWindow(sUrl,winName,"width=1024,height=700, resizable=yes, scrollbars=yes, status=no");
	
 	/*var url = "CPS_CNI_0033_01.do?popupYn=Y&cgo_clm_no=" + cgoClmNo;
 	var winName = "CPS_CNI_0033";
 	var reqWin = ComOpenWindow(url,winName,"width=1280,height=700, resizable=yes, scrollbars=yes, status=no");	*/
} 
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST01) {		
		frm.f_cmd.value=SEARCHLIST01;		
		var sXml=sheet1.GetSearchData("CPS_CNI_0016GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// List 정보 설정
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Sync:1} );
			for(var i=0 ; i < sheet1.RowCount(); i++ ) {
				var row=sheet1.HeaderRows()+ i ;
				var cgoClmStsCd=sheet1.GetCellValue(row , "cgo_clm_sts_cd");
				if (cgoClmStsCd == "C" || cgoClmStsCd == "X") {
					sheet1.SetRowEditable(row,0);
				}	
			}
			if (sheet1.RowCount()== 0) {
				frm.trnk_ref_vvd_no.value="";
			}
        }
		// ------------------------------------------------------------
		// Entry Status Vo
		// ------------------------------------------------------------
		if (arrXml.length > 1) {
			var list=SheetXml2ListMap(arrXml[1]);
			if (list.length > 0) {
				var vo=list[0];
				frm.insur_clm_pty_no.value=vo["insur_clm_pty_no"]; 
				frm.insur_clm_pty_abbr_nm.value=vo["insur_clm_pty_abbr_nm"];
				frm.insur_pty_nm.value=vo["insur_pty_nm"];
				frm.insur_vsl_oshp_cd.value=vo["insur_vsl_oshp_cd"];
				frm.insur_plcy_yr.value=vo["insur_plcy_yr"];
				frm.ddct_cgo_amt.value=ComAddComma(vo["ddct_cgo_amt"]);
			}
		}
		
		sheet1.SetSumText(1, "TOTAL");
	} else if (sAction == MULTI) {
		// -----------------------------------------------------------------
		// VVD는 본사 사용자만 보험관련 처리이므로 별도의 setting authority은 필요하지 않음
		// -----------------------------------------------------------------
		var ddct_cgo_amt=frm.ddct_cgo_amt.value;	
		if (ComIsNull(ddct_cgo_amt)) {
			 //msgs["CNI00105"] = "No Deductible. Please update Insurance Entry Status!";
			ComShowCodeMessage("CNI00105");
			return;
		}
		/*
		var insurAmt=0;
		var rcvrAmt=0;
		for ( var i=0; i < sheet1.RowCount(); i++) {
			var row=sheet1.HeaderRows()+ i;
var cgoClmStsCd=sheet1.GetCellValue(row , "cgo_clm_sts_cd");
			if (cgoClmStsCd == "C" || cgoClmStsCd == "X") {
				continue;
			}			
		}
		*/
		frm.f_cmd.value=MULTI;
		var param=FormQueryString(frm);		
		var saveString=sheet1.GetSaveString();
		if (sheet1.IsDataModified()&& ComIsNull(saveString))  {
			return;
		}
		if (ComIsNull(saveString))  {	
			 //msgs["CNI00022"] = "There is no contents to save.";
			ComShowCodeMessage("CNI00022");
			return;
		}
		saveString=ComSetPrifix(saveString, "sheet1_");
		param += "&" + saveString;		
		var sXml=sheet1.GetSaveData("CPS_CNI_0016GS.do", param);
		sheet1.LoadSaveData(sXml);
		doActionIBSheet(SEARCHLIST01);
	} else if (sAction == PRINT) {
		frm.f_cmd.value=PRINT;
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0094.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]";
		var rpaper="/rpaper [A4]";		 
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]trnk_ref_vvd_no["+ frm.trnk_ref_vvd_no.value+"]" +
		         " insur_clm_pty_abbr_nm[" + frm.insur_clm_pty_abbr_nm.value+"]" +
		         " insur_plcy_yr[" + frm.insur_plcy_yr.value + "]" +
		         " ddct_cgo_amt["+ frm.ddct_cgo_amt.value +"]";		
		frm.com_mrdArguments.value=rf + " " + rpost +  " " + rpaper +  " " + rv  ;
		frm.com_mrdTitle.value="Insurance Recovery by VVD Status Report";
		frm.com_mrdBodyTitle.value="Insurance Recovery by VVD";
		frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaim/insurancerecovery/report/CPS_CNI_0094.mrd";
		var feature="resizable=yes,width=1000,height=600"
		popupRd(1000,600);
	} 
}
