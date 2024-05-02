/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0025.js
*@FileTitle  : [CPS_GEM_0025] Main Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/**
 * [CPS_CNI_0025] Main Code Creation
 * @extends
 * @class business script for Main Code Creation
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
// Main Code Inquiry Popup type
var type="";
var duplicateFlag="";
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
    //retrieving in case of existing claim party no
    if (!ComIsNull(frm.clm_pty_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    }	
}
/**
* registering initial event 
*/
function initControl() {
	//axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
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
          
            //no support[check again]CLT 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            var HeadTitle1="|Seq.|Contact Person|Tel|Tel|Fax|Fax|E-Mail|Remark|cntc_pnt_no|clm_pty_no|clm_cntc_pnt_seq";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                   {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                   {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"intl_phn_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_phn_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"intl_fax_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_fax_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                   {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_eml",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
                   {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"cntc_pnt_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1300 },
                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntc_pnt_no" },
                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"clm_pty_no" },
                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"clm_cntc_pnt_seq" } ];
             
            InitColumns(cols);
            SetSheetHeight(200);
            SetEditable(1);
                  //no support[check again]CLT 			PopupImage="img/btns_note.gif";
            SetShowButtonImage(1);
 			SetColProperty(0 ,"intl_phn_no" , {AcceptKeys:"N|[-]"});
 			SetColProperty(0 ,"intl_fax_no" , {AcceptKeys:"N|[-]"});
 			SetColProperty(0 ,"cntc_pnt_eml", {AcceptKeys:"E|N|[._;@]"});
            break;


		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
/**
 * Setting Main Code Inquiry
 */
function setMainCodeInquiry(partyVo) {
	// Code
	if (type == "C") {
		frm.clm_pty_no.value=partyVo.clm_pty_no;
		frm.clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
		doActionIBSheet(SEARCHLIST01);
	// Same Code
	} else if (type == "S") {
		frm.clm_pty_clr_no.value=partyVo.clm_pty_no;
		frm.clm_pty_clr_cd.value=partyVo.clm_pty_abbr_nm;			
    // Principal
	} else if (type == "P") {
		frm.prnt_clm_pty_no.value=partyVo.clm_pty_no;
		frm.prnt_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
	}
}
/**
* Setting Main Code Popup 
*/
function setMainCodePopup() {
	duplicateFlag="N";
	doActionIBSheet(MULTI);
}

function setMainViewPopup(partyVo) {
	var clmPtyNo = partyVo.clm_pty_no;
	location.href = "CPS_CNI_0027.do?parentPgmNo=CPS_CNI_M001&pgmNo=CPS_CNI_0027&clm_pty_no=" + clmPtyNo;	
}

/**
 * setting Location
 */
 function setLocation(rowArray) { 
    frm.loc_cd.value=rowArray[0][3];
 }
 /**
  * Setting customer
  */
  function setCustomer(rowArray) {
	 for(var i=0; i < rowArray[0].length; i++ ) {
		 var custCode=rowArray[0][3];
		 frm.cnt_cd.value=custCode.substring(0,2);
		 var cust_seq=parseInt(custCode.substring(2),10);		 
		 frm.cust_seq.value=cust_seq;		 
		 var clm_pty_no=frm.clm_pty_no.value;
		 frm.cust_nm.value=rowArray[0][4];	
		 frm.pty_nm.value=rowArray[0][4];			 		 
		 frm.pty_addr.value=rowArray[0][6];
		 frm.zip_cd_ctnt.value=rowArray[0][8];
		 frm.loc_cd.value=rowArray[0][9];
		 frm.vndr_seq.value=rowArray[0][12];			 
	 }
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
		case "btn2_Row_Add":
			var row=sheet1.DataInsert(-1);
			sheet1.SelectCell(row,"cntc_pnt_nm",true);
			break;	
	    case "btn2_Row_Copy":	    	
	    	var row=sheet1.DataCopy();
	    	sheet1.SetRowStatus(row,"I");
			break;
		case "btn2_Row_Delete":			
			SheetRowDelete(sheet1,sheet1.GetSelectRow());
	        break; 	
		case "btn2_Save":					
			if(ComChkValid(frm)) {
				//msgs["CNI00012"] = "Data was changed. Do you want to save it?";
				if (ComShowCodeConfirm("CNI00012")) {
					doActionIBSheet(MULTI);
				} 
			}	
			break;	        
		case "btn1_Retrieve":
			var clm_pty_abbr_nm=frm.clm_pty_abbr_nm.value;
			if (ComIsNull(clm_pty_abbr_nm)) {
				duplicateFlag="Y";
				//msgs["CNI00018"] = "Please select {?msg1}";
				ComShowCodeMessage("CNI00018" , "Code");
				return;
			}
			doActionIBSheet(SEARCHLIST01);			
			break;	
	    case "btn1_New":
	    	//msgs["CNI00015"] = "Do you want to initialize?";
	    	if (ComShowCodeConfirm("CNI00015")) {
				duplicateFlag="Y";
	    		ComResetAll();
	    		resetHiddenField(frm);
	    	}	    	
	        break;	
		case "btn1_Save":
			frm.f_cmd.value=MULTI;		
			if(ComChkValid(frm)) {
				//CNI00012(Do you want to save changes?)
				if (ComShowCodeConfirm("CNI00012")) {
					duplicateFlag="Y";
					doActionIBSheet(MULTI);	
				}
			}			
	        break;
		case "btn1_Delete":
			var clm_pty_no=frm.clm_pty_no.value;
			if (ComIsNull(clm_pty_no)) {
				 //msgs["CNI00023"] = "There is no contents to delete.";
				ComShowCodeMessage("CNI00023");
				return;
			}
			//msgs["CNI00016"] = "Do you want to delete it?";
			if (ComShowCodeConfirm("CNI00016")) {
				doActionIBSheet(REMOVE);
			}
	        break;
		case "btn1_Code":
			type="C";
			popupMainCodeInquiry(); 
	        break;	        
		case "btns_location":
			//calling Location common popup 
			var locCd=frm.loc_cd.value;
			popupLocation(locCd);
	        break;	     
		case "btns_same_code":
			type="S";
			popupMainCodeInquiry(); 
	        break;	    
		case "btns_mdm_code":
			//calling Customer common popup
			var cntCd=frm.cnt_cd.value;
			var custSeq=frm.cust_seq.value;
			popupCustomer(cntCd , custSeq);
	        break;	    
		case "btns_principal":
			type="P";
			popupMainCodeInquiry(); 
	        break;	    	        
	}
}
/**
 * HTML Control KeyPress event
 */
function keypressFormat() {
 	var obj=event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus=obj.dataformat;
    switch(ComGetEvent("name")) {    
    case "intl_phn_no":    
    	ComKeyOnlyNumber(obj);
    	break;
    case "intl_fax_no":
    	ComKeyOnlyNumber(obj);
		break;
	}
}
/**
 * Calling function in case of OnPopupClick event
 * calling popup window <br>
 * @param {IBSheet} sheet
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
 */
function sheet1_OnPopupClick(sheet, row, col) {
    //
    if (sheet.ColSaveName(col) == "cntc_pnt_rmk") {
		ComShowMemoPad(sheet);
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
		duplicateFlag="Y";
	} else if (sAction == MULTI) {
		frm.f_cmd.value=MULTI;
		var param=FormQueryString(frm);		
		var saveString=sheet1.GetSaveString();
			
		if (ComIsNull(saveString)&&sheet1.RowCount() == 0)  {
			 //msgs["CNI00022"] = "There is no contents to save.";
			ComShowCodeMessage("CNI00116");
			return;
		}
		saveString=ComSetPrifix(saveString, "sheet1_");
		param += "&" + saveString;
		param += "&duplicate_flag=" + duplicateFlag;
 		var sXml=sheet1.GetSaveData("CPS_CNI_0025GS.do", param);
		var clmPtyNo=ComGetEtcData(sXml, "CLM_PTY_NO");	
		if ( clmPtyNo == "Y" ) {
			var clmPtyAbbrNm=frm.clm_pty_abbr_nm.value;
			var ptyNm=frm.pty_nm.value;
			var param="clm_pty_abbr_nm=" + clmPtyAbbrNm;
				param += "&pty_nm=" + ptyNm;
			var url="CPS_CNI_0095.do?"+param;
			var winName="CPS_CNI_0095";		
			ComOpenWindowCenter(url,winName,835,500, false);	
		}else {
			//setting claim party no
 			sheet1.LoadSaveData(sXml);
			frm.clm_pty_no.value=ComGetEtcData(sXml, "CLM_PTY_NO");		
			//retrieving
			doActionIBSheet(SEARCHLIST01);
		}
	} else if (sAction == REMOVE) {		
		frm.f_cmd.value=REMOVE;		
 		var sXml=sheet1.GetSearchData("CPS_CNI_0025GS.do", FormQueryString(frm));
		sheet1.LoadSearchData(sXml,{Sync:1} );
		ComResetAll();
	}  
}
