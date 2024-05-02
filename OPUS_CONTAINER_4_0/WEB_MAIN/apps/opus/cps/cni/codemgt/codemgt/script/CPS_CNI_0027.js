/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0027.js
*@FileTitle  : [CPS_GEM_0027] Main Code View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/**
 * [CPS_CNI_0027] Main Code View
 * @extends
 * @class business script for Main Code View
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
    //retrieving in case of existing claim party no
    if (!ComIsNull(frm.clm_pty_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    }	
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo sheetNo
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
        	case "sheet1":
	            var HeadTitle1="|Seq.|Contact Person|Tel|Tel|Fax|Fax|E-Mail|Remark(s)|cntc_pnt_no";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                   {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                   {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"intl_phn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_phn_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
	                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"intl_fax_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_fax_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
	                   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
	                   {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1300 },
	                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntc_pnt_no" } ];
	             
	            InitColumns(cols);
	            SetEditable(0);
	                  //no support[check again]CLT 			PopupImage="img/btns_note.gif";
	            SetShowButtonImage(1);
	 			SetColProperty(0 ,"intl_phn_no" , {AcceptKeys:"N|[-]"});
	 			SetColProperty(0 ,"cntc_pnt_phn_no" , {AcceptKeys:"N|[-]"});
	 			SetColProperty(0 ,"intl_fax_no" , {AcceptKeys:"N|[-]"});
	 			SetColProperty(0 ,"cntc_pnt_fax_no" , {AcceptKeys:"N|[-]"});
	 			SetColProperty(0 ,"cntc_pnt_eml", {AcceptKeys:"E|N|[.-/,() &]"});
	            if (frm.popupYn.value == "Y") {
	            	SetSheetHeight(150);
	        	} else {
	        		SetSheetHeight(250);
	        	}
            break;


		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
/**
 * setting Main Code Inquiry
 */
function setMainCodeInquiry(partyVo) {	
	frm.clm_pty_no.value=partyVo.clm_pty_no;
	frm.clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
	doActionIBSheet(SEARCHLIST01);	
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
		case "btn1_Retrieve":
			var clm_pty_abbr_nm=frm.clm_pty_abbr_nm.value;
			if (ComIsNull(clm_pty_abbr_nm)) {
				//msgs["CNI00018"] = "Please select {?msg1}";
				ComShowCodeMessage("CNI00018" , "Code");
				return;
			}
			doActionIBSheet(SEARCHLIST01);			
			break;	
	    case "btn1_New":
	    	//msgs["CNI00015"] = "Do you want to initialize?";
	    	//if (ComShowCodeConfirm("CNI00015")) {
	    	//	ComResetAll();
	    	//}
	    	ComResetAll();
	        break;	
	    case "btn1_Code":
	    	popupMainCodeInquiry(); 
	        break;
	    case "btn1_close":
	    	ComClosePopup(); 
	    	break;	        
	}
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;		
		var sXml=sheet1.GetSearchData("CPS_CNI_0025GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// setting party information
		// ------------------------------------------------------------
		if (arrXml.length > 0) {			
			var list=SheetXml2ListMap(arrXml[0]);			
			if (list.length > 0) {
				var partyVO=list[0];
				frm.clm_pty_abbr_nm.value=partyVO["clm_pty_abbr_nm"];
				frm.prnt_clm_pty_no.value=partyVO["prnt_clm_pty_no"];
				frm.clm_pty_clr_cd.value=partyVO["clm_pty_clr_cd"];
				frm.prnt_clm_pty_abbr_nm.value=partyVO["prnt_clm_pty_abbr_nm"];
				frm.pty_nm.value=partyVO["pty_nm"];
				frm.intl_phn_no.value=partyVO["intl_phn_no"];
				frm.phn_no.value=partyVO["phn_no"];
				frm.intl_fax_no.value=partyVO["intl_fax_no"];
				frm.fax_no.value=partyVO["fax_no"];
				frm.pty_eml.value=partyVO["pty_eml"];
				frm.pty_addr.value=partyVO["pty_addr"];
				frm.pty_rmk.value=partyVO["pty_rmk"];
				frm.loc_cd.value=partyVO["loc_cd"];
				frm.zip_cd_ctnt.value=partyVO["zip_cd_ctnt"];
				frm.cnt_cd.value=partyVO["cnt_cd"];
				frm.cust_seq.value=partyVO["cust_seq"];
				frm.cust_nm.value=partyVO["cust_nm"];
				frm.vndr_seq.value=partyVO["vndr_seq"];
				frm.clm_pty_clr_no.value=partyVO["clm_pty_clr_no"];			
				frm.clm_pty_clr_cd.value=partyVO["clm_pty_clr_cd"];
				frm.cre_ofc_cd.value=partyVO["cre_ofc_cd"];
				frm.cre_usr_id.value=partyVO["cre_usr_id"];				
				frm.upd_dt.value=partyVO["upd_dt"];
				frm.clm_area_cd.value=partyVO["clm_area_cd"];
				frm.tpb_cd.value=partyVO["vndr_seq"];
				var delt_flg=partyVO["delt_flg"];				
				if (delt_flg == "N") {
					frm.delt_flg[0].checked=true;
					frm.delt_flg[1].checked=false;
				} else {
					frm.delt_flg[0].checked=false;
					frm.delt_flg[1].checked=true;					
				}
			}
        }
		// ------------------------------------------------------------
		//setting contact point
		// ------------------------------------------------------------
		if (arrXml.length > 1) {
			sheet1.LoadSearchData(arrXml[1],{Sync:1} );
		}
	}
}
