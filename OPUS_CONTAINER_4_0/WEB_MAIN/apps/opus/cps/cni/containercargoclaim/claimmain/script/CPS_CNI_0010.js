/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0010.js
*@FileTitle  : [CPS_CNI_0010] Contract of Carriage-Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
/**
 * [CPS_CNI_0010] Contract of Carriage-Main
 * 
 * @extends
 * @class Contract of Carriage-Main 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
// =============================================================
// #Form Command          #IBSheet Action                
// INIT = 0; IBSEARCH = 0; // 조회
// ADD = 1; IBSEARCHAPPEND = 1; // 페이징 조회
// SEARCH = 2; IBSAVE = 2; // 저장
// SEARCHLIST = 3; IBINSERT = 3; // 삽입
// MODIFY = 4; IBCLEAR = 4; // initializing
// REMOVE = 5; IBDOWNEXCEL = 5; // 엑셀 다운로드
// REMOVELIST = 6; IBLOADEXCEL = 6; // 엑셀 업로드
// MULTI = 7; IBCOPYROW = 7; // 행복사
// PRINT = 8; IBDELETE = 8; // 삭제
// REPLY = 9; RDPRINT = 9; // RD 연결
// IBROWSEARCH = 10; // Row 조회
// IBCREATE = 11; // Create
// IBRESET = 12; // Reset
// IBBATCH = 13; // Batch
// =============================================================
// ===================================================================================
// common global variables
// ===================================================================================
var tabObjects=new Array();
var tabCnt=0;
var beforetab1=1;
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
var sheet2=null;
var sheet3=null;
//IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
// html form
var frm=null;
var locObj=null;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBTab Object as list 
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
 /**
 * registering IBCombo Object as list
 * @param comboObj
 **/
function setComboObject(comboObj){
	comboObjects[comboCnt++]=comboObj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	frm=document.form;
	sheet1=sheetObjects[0];
	sheet2=sheetObjects[1];
	sheet3=sheetObjects[2];
	sheetCnt=sheetObjects.length;
	for (i=0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	}
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	// IBMultiComboinitializing
	comboCnt=comboObjects.length;
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}
	initComboBox();	
	initControl();
    //ClaimNo 가 없을경우 권한
	setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save");
    if(frm.cgo_clm_no.value.length == 10){
		doActionIBSheet(SEARCHLIST01);
	}
}
 /**
 * registering initial event 
 */
 function initControl() {
    //keypress
//    axon_event.addListenerForm('keypress', 'obj_keypress', frm);
    //keydown
//    axon_event.addListenerForm ('keydown', 'obj_keydown', frm);
    //key up
    axon_event.addListenerForm('keyup', 'obj_keyup', frm); 
    // focus in
//    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
    // focus out
//    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
 }
 /**
 * 초기 콤보 설정
 **/
function initComboBox() {
	 setMultiComboBox("clm_ofrt_term_cd"  ); //40 report_by [1]
     setMultiComboBox("clm_ofrt_flg" ); 
     
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
}
/**
* setting IBMultiComboBox
* @param {select box} combo object
* @param {xml} code , name xml
* @param {String} selected initial Code 
*/ 

function setMultiComboBox(comboId) {
	var vComboObj=null; // IBMultiComboBox
	var vArrayListData=""; 
	var vListData="";
	var vCaptionText="";
	vComboObj=getComboObject(comboId);
	if (vComboObj == null ) {
		return;
	}	
	if(comboId=="clm_ofrt_term_cd") {
		vComboObj.InsertItem(0, "PPD", "P");
		vComboObj.InsertItem(1, "CCT", "C");
	}
	if(comboId=="clm_ofrt_flg") {
		vComboObj.InsertItem(0, "Yes", "Y");
		vComboObj.InsertItem(1, "No", "N");
	}	
}
/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return
 **/
function getComboObject(pComboObjId){
	var vCnt=comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].options.id== pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_BLGet":
			doActionIBSheet(MULTI01);
			setRefBlNo();
			var blNo=frm.cgo_clm_ref_bl_no.value;
			if (blNo == "") {
				ComShowMessage("Please use after retrieve ");		
				return false;
			}
			doActionIBSheet(SEARCHLIST04);
			break;
		// Booking Preview	
		case "btn_BLPreview":
			var blNo=frm.cgo_clm_ref_bl_no.value;
			if (blNo == "") {
				ComShowMessage("Please use after retrieve ");		
				return false;
			}
			doActionIBSheet(SEARCHLIST03);
			var bkgNo=frm.bkg_no.value;
			if (bkgNo == "") {
				ComShowCodeMessage("CNI00013");
				return false;
			}
			rdOpen(bkgNo);			
        	break;	
		case "btn2_RowAdd":
			var row=sheet1.DataInsert(-1);
			sheet1.SelectCell(row, "cgo_clm_ref_bl_no", true);
			chkInsertSheet1(row);
			break;
		case "btn2_RowDelete":
			SheetRowDelete(sheet1, sheet1.GetSelectRow());
			break;
		case "btn2_RowCopy":
			var row=sheet1.DataCopy();
			sheet1.SetRowStatus(row,"I");
			chkInsertSheet1(row);
			break;
		case "btn2_RowAdd2":
			var row=sheet2.DataInsert(-1);
			sheet2.SelectCell(row, "cgo_clm_ref_cntr_no", true);
			var blNo=sheet1.GetCellValue(sheet1.GetSelectRow(), "cgo_clm_ref_bl_no");
			if(blNo!='') sheet2.SetCellValue(row , "cgo_clm_ref_bl_no",blNo,0);
			break;
		case "btn2_RowDelete2":
			SheetRowDelete(sheet2, sheet2.GetSelectRow());
			break;
		case "btn2_RowCopy2":
			var row=sheet2.DataCopy();
			sheet2.SetRowStatus(row,"I");
			break;
		case "btn_Movement":
			var cntrNo=sheet2.GetCellValue(sheet2.GetSelectRow(), "cgo_clm_ref_cntr_no");
			var cntrTpSzCd=sheet2.GetCellValue(sheet2.GetSelectRow(), "cgo_clm_ref_bl_no");
			
			if (cntrNo != "" && cntrTpSzCd != "") {
				cntrNo=sheet2.GetCellValue(sheet2.GetSelectRow(), "cgo_clm_ref_cntr_no").substr(0,10);
				var checkDigit=sheet2.GetCellValue(sheet2.GetSelectRow(), "cgo_clm_ref_cntr_no").substr(10,11);
				paramVal="?p_cntrno=" + cntrNo + "&check_digit=" + checkDigit + "&ctnr_tpsz_cd=" + cntrTpSzCd;
				ComOpenPopup('EES_CTM_0408_POP.do' + paramVal, 1036, 680, "getInqMVMT", "1,0,1,1,1,1,1", false);
			}
			break;
		case "btn1_Retrieve":
			var cgoClmNo=frm.cgo_clm_no.value;
			if (ComIsNull(cgoClmNo)) {
				//msgs["CNI00018"] = "Please select {?msg1}";
				ComShowCodeMessage("CNI00009", "Claim No");
				ComSetFocus(frm.cgo_clm_no);
				return;
			}
			doActionIBSheet(SEARCHLIST01);
			break;
		case "btn1_New":
			if (ComShowCodeConfirm("CNI00015")) {
				ComResetAll();
				resetHiddenField(frm);
				frm.cgo_clm_no.value="";
				ComSetFocus(frm.cgo_clm_no);
			}
			break;
		case "btn1_Save":
			if (ComChkValid(frm)) {
				//CNI00012(Do you want to save changes?)
				if (ComShowCodeConfirm("CNI00012")) {
					doActionIBSheet(MULTI);
				}
			}
			break;
		case "btn1_Handler":
			var cgoClmNo=frm.cgo_clm_no.value;	
			popupHandlerHistory(cgoClmNo);
			break;
		// -----------------[btns Start]------------------//
		case "btns_por_cd":
		case "btns_pol_cd":
		case "btns_pod_cd":
		case "btns_del_cd":		
			break;
		// -----------------[btns End]------------------//
		// -----------------[File_Upload Start]------------------//
		case "btn2_Upload_01":
		case "btn2_Upload_02":	
		case "btn2_Upload_03":
		case "btn2_Upload_04":
		case "btn2_Upload_05":
		case "btn2_Upload_06":
		case "btn2_Upload_07":		
			var cgoClmNo=frm.cgo_clm_no.value;
			if (ComIsNull(cgoClmNo)) {
				//ComShowCodeMessage("CNI00009" , "Claim No.");
				ComShowMessage("Please use after retrieve or save");//CNI00103
			}else{
				popupFileUploadCall(srcName, cgoClmNo);
			}
			break;	
		// -----------------[File_Upload End]------------------//
		// -----------------[Location Start]------------------//
		case "btns_n1st_pre_ts_loc_cd":
		case "btns_n2nd_pre_ts_loc_cd":
		case "btns_n3rd_pre_ts_loc_cd":
		case "btns_n1st_pst_ts_loc_cd":
		case "btns_n2nd_pst_ts_loc_cd":
		case "btns_n3rd_pst_ts_loc_cd":
			locationDisplay(srcName);
			break;
		// -----------------[Location End]------------------//	
		// -----------------[달력 버튼 Start]------------------//
		case "btns_rct_dt":
		case "btns_dchg_dt":
		case "btns_n1st_pre_ts_dt":
		case "btns_n2nd_pre_ts_dt":
		case "btns_n3rd_pre_ts_dt":
		case "btns_n1st_pst_ts_dt":
		case "btns_n2nd_pst_ts_dt":
		case "btns_n3rd_pst_ts_dt":
			calendarDisplay(srcName);
			break;
		// -----------------[달력 버튼 End]------------------//
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}



/**
 * setting sheet initial values and header
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
        with(sheetObj){
			if (location.hostname != "")
			var HeadTitle1="|Seq.|B/L No.|cgo_clm_no|mn_bl_flg";
			var headCount=ComCountHeadTitle(HeadTitle1);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			{Type:"Seq",       Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_ref_bl_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no" },
			{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mn_bl_flg" } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetCountPosition(0);
			SetSheetHeight(102);
			}
		break;
	case "sheet2": //sheet2 init
        with(sheetObj){
        	if (location.hostname != "")
				var HeadTitle1="|Seq.|CNTR No.|TP/SZ|B/L No.|cgo_clm_no|mn_cntr_flg";
				var headCount=ComCountHeadTitle(HeadTitle1);
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				{Type:"Seq",       Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_ref_cntr_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bl_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_ref_bl_no",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no" },
				{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mn_cntr_flg" } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetSheetHeight(102);                   
			}			
		break;
	case "sheet3": //sheet3 init
	    with(sheetObj){
        	if (location.hostname != "") { }
        	var HeadTitle1="";
        	var headCount=ComCountHeadTitle(HeadTitle1);

        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
       
        	InitColumns(cols);
        	SetWaitImageVisible(0);
        	SetEditable(1);
        }
		break;
	}
}
 /**
  * Combobox Initialize, Header Definition 
  * @param {object} comboObj Mandatory, IBMultiCombo Object
  * @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
  **/
 function initCombo(comboObj, comboNo) {
 	with (comboObj) {
 		comboObj.SetMultiSelect(0);
 		comboObj.SetColAlign(0, "center");
 		comboObj.SetColAlign(1, "left");
 		comboObj.SetMultiSeparator(",");
 		comboObj.SetDropHeight(190);
 	}
 } 
// Handling Sheet's process
function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;
		sheet2.RemoveAll();
 		var sXml=sheet3.GetSearchData("CPS_CNI_0010GS.do",FormQueryString(frm),"",true);
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			var list=SheetXml2ListMap(arrXml[0]);
			if (list.length > 0) {
				for (var j=0;j<list.length;j++)
				{
					if(list[j]!=undefined){
						var dataVO=list[j];
						break;
					}
				}
				frm.clm_area_cd.value=dataVO["clm_area_cd"];
				frm.hdlr_ofc_cd.value=dataVO["hdlr_ofc_cd"];
				frm.hdlr_usr_id.value=dataVO["hdlr_usr_id"];
				frm.upd_dt.value=dataVO["upd_dt"];
				frm.cgo_clm_inci_no.value=dataVO["cgo_clm_inci_no"];
				frm.crm_voc_no.value=dataVO["crm_voc_no"];
				frm.clm_misc_cd.value=dataVO["clm_misc_cd"];
				frm.clm_misc_nm.value=dataVO["clm_misc_nm"];
				frm.hpc.value=dataVO["hpc"];
				frm.nhp.value=dataVO["nhp"];
				frm.cgo_clm_stl_tp_cd.value=dataVO["cgo_clm_stl_tp_cd"];
				frm.cs_clz_dt.value=dataVO["cs_clz_dt"];
				frm.clm_tm_bar_dt.value=dataVO["clm_tm_bar_dt"];
				frm.smns_sve_dt.value=dataVO["smns_sve_dt"];
				frm.clmt_clm_pty_no.value=dataVO["clmt_clm_pty_no"];
				frm.clm_pty_abbr_nm.value=dataVO["clm_pty_abbr_nm"];
				frm.pty_nm.value=dataVO["pty_nm"];
				frm.clmt_clm_tp_cd.value=dataVO["clmt_clm_tp_cd"];
				frm.fmal_clm_rcv_ofc_cd.value=dataVO["fmal_clm_rcv_ofc_cd"];
				frm.fmal_clm_rcv_dt.value=dataVO["fmal_clm_rcv_dt"];
				frm.cgo_clm_tp_cd.value=dataVO["cgo_clm_tp_cd"];
				frm.mjr_clm_dmg_lss_cd.value=dataVO["mjr_clm_dmg_lss_cd"];
				frm.minr_clm_dmg_lss_cd.value=dataVO["minr_clm_dmg_lss_cd"];
				frm.inci_plc_tp_cd.value=dataVO["inci_plc_tp_cd"];
				frm.inci_occr_dt.value=dataVO["inci_occr_dt"];
				frm.clmt_usd_amt.value=ComAddComma2( dataVO["clmt_usd_amt"],"#,###.00");
				frm.trnk_ref_vvd_no.value=dataVO["trnk_ref_vvd_no"];
				frm.slan_cd.value=dataVO["slan_cd"];
				frm.crr_term_cd.value=dataVO["crr_term_cd"];
				frm.por_cd.value=dataVO["por_cd"];
				frm.rct_dt.value=dataVO["rct_dt"];
				frm.pol_cd.value=dataVO["pol_cd"];
				frm.lodg_dt.value=dataVO["lodg_dt"];
				frm.pod_cd.value=dataVO["pod_cd"];
				frm.dchg_dt.value=dataVO["dchg_dt"];
				frm.del_cd.value=dataVO["del_cd"];
				frm.de_dt.value=dataVO["de_dt"];
				frm.shpr_nm.value=dataVO["shpr_nm"];
				frm.cnee_nm.value=dataVO["cnee_nm"];
				frm.ntfy_nm.value=dataVO["ntfy_nm"];
				frm.clm_cgo_tp_cd.value=dataVO["clm_cgo_tp_cd"];
				frm.cgo_qlty_desc.value=dataVO["cgo_qlty_desc"];
				frm.clm_ofrt_amt.value=ComAddComma2( dataVO["clm_ofrt_amt"],"#,###.00");
				ComSetObjValue(clm_ofrt_term_cd, dataVO["clm_ofrt_term_cd"]);
				ComSetObjValue(clm_ofrt_flg, dataVO["clm_ofrt_flg"]);
				frm.n1st_pre_ref_vvd_no.value=dataVO["n1st_pre_ref_vvd_no"];
				frm.n2nd_pre_ref_vvd_no.value=dataVO["n2nd_pre_ref_vvd_no"];
				frm.n3rd_pre_ref_vvd_no.value=dataVO["n3rd_pre_ref_vvd_no"];
				frm.n1st_pre_ts_loc_cd.value=dataVO["n1st_pre_ts_loc_cd"];
				frm.n1st_pre_ts_dt.value=dataVO["n1st_pre_ts_dt"];
				frm.n2nd_pre_ts_loc_cd.value=dataVO["n2nd_pre_ts_loc_cd"];
				frm.n2nd_pre_ts_dt.value=dataVO["n2nd_pre_ts_dt"];
				frm.n3rd_pre_ts_loc_cd.value=dataVO["n3rd_pre_ts_loc_cd"];
				frm.n3rd_pre_ts_dt.value=dataVO["n3rd_pre_ts_dt"];
				frm.n1st_pst_ref_vvd_no.value=dataVO["n1st_pst_ref_vvd_no"];
				frm.n2nd_pst_ref_vvd_no.value=dataVO["n2nd_pst_ref_vvd_no"];
				frm.n3rd_pst_ref_vvd_no.value=dataVO["n3rd_pst_ref_vvd_no"];
				frm.n1st_pst_ts_loc_cd.value=dataVO["n1st_pst_ts_loc_cd"];
				frm.n1st_pst_ts_dt.value=dataVO["n1st_pst_ts_dt"];
				frm.n2nd_pst_ts_loc_cd.value=dataVO["n2nd_pst_ts_loc_cd"];
				frm.n2nd_pst_ts_dt.value=dataVO["n2nd_pst_ts_dt"];
				frm.n3rd_pst_ts_loc_cd.value=dataVO["n3rd_pst_ts_loc_cd"];
				frm.n3rd_pst_ts_dt.value=dataVO["n3rd_pst_ts_dt"];
				setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save");
			} else {
				ComResetAll();// 조회건이 없으면 form reset.
				if (frm.cgo_clm_no.value == "") {
					//msgs["CNI00013"] = "There is no data to search.";
					ComShowCodeMessage("CNI00013");
				}
			}
		}
		// ------------------------------------------------------------
		// B/L sheet
		// ------------------------------------------------------------
		if (arrXml.length > 1) {
			sheet1.LoadSearchData(arrXml[1],{Sync:1} );
			var blno=sheet1.GetCellValue(1, 2);
			if (blno != "") {
				frm.cgo_clm_ref_bl_no.value=blno;				
				// CNTR
				doActionIBSheet(SEARCHLIST02);
			}
		}
	} else if (sAction == SEARCHLIST02) {
		frm.f_cmd.value=SEARCHLIST02;
 		var sXml=sheet2.GetSearchData("CPS_CNI_0010GS.do",
				FormQueryString(frm),"",true);
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// sheet 설정
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet2.LoadSearchData(arrXml[0],{Sync:1} );
		} else {
			ComShowCodeMessage("CNI00013");
		}
	} else if (sAction == SEARCHLIST03) {
		frm.f_cmd.value=SEARCHLIST03;
 		var sXml=sheet3.GetSearchData("CPS_CNI_0010GS.do", FormQueryString(frm),"",true);
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// Booking No 설정
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			var list=SheetXml2ListMap(arrXml[0]);	
			if (list.length > 0) {
				for(var j=0; j<list.length;j++)
				{
					if(list[j]!=undefined)
					{
						var dataVO=list[j];
						break;
					}
				}
				frm.bkg_no.value=dataVO["bkg_no"];					
			}
		} else {
			frm.bkg_no.value='';
			//ComShowCodeMessage("CNI00013");
		}
	} else if (sAction == SEARCHLIST04) {
		frm.f_cmd.value=SEARCHLIST04;		
 		var sXml=sheet3.GetSearchData("CPS_CNI_0010GS.do",FormQueryString(frm),"",true);
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			var list=SheetXml2ListMap(arrXml[0]);
			if (list.length > 0) {
				for(var j=0; j<list.length;j++)
				{
					if(list[j]!=undefined)
					{
						var dataVO=list[j];
						break;
					}
				}
				
				frm.trnk_ref_vvd_no.value=dataVO["trnk_ref_vvd_no"];
				frm.slan_cd.value=dataVO["slan_cd"];
				frm.crr_term_cd.value=dataVO["crr_term_cd"];
				frm.por_cd.value=dataVO["por_cd"];				
				frm.pol_cd.value=dataVO["pol_cd"];				
				frm.pod_cd.value=dataVO["pod_cd"];				
				frm.del_cd.value=dataVO["del_cd"];		
				frm.shpr_nm.value=dataVO["shpr_nm"];
				frm.cnee_nm.value=dataVO["cnee_nm"];
				frm.ntfy_nm.value=dataVO["ntfy_nm"];
				frm.cgo_qlty_desc.value=dataVO["cgo_qlty_desc"];
				frm.clm_ofrt_amt.value=ComAddComma2( dataVO["clm_ofrt_amt"],"#,###.00");
				ComSetObjValue(frm.clm_ofrt_term_cd, dataVO["clm_ofrt_term_cd"]);				
				frm.n1st_pre_ref_vvd_no.value=dataVO["n1st_pre_ref_vvd_no"];
				frm.n2nd_pre_ref_vvd_no.value=dataVO["n2nd_pre_ref_vvd_no"];
				frm.n3rd_pre_ref_vvd_no.value=dataVO["n3rd_pre_ref_vvd_no"];
				frm.n1st_pre_ts_loc_cd.value=dataVO["n1st_pre_ts_loc_cd"];
				frm.n2nd_pre_ts_loc_cd.value=dataVO["n2nd_pre_ts_loc_cd"];				
				frm.n3rd_pre_ts_loc_cd.value=dataVO["n3rd_pre_ts_loc_cd"];				
				frm.n1st_pst_ref_vvd_no.value=dataVO["n1st_pst_ref_vvd_no"];
				frm.n2nd_pst_ref_vvd_no.value=dataVO["n2nd_pst_ref_vvd_no"];
				frm.n3rd_pst_ref_vvd_no.value=dataVO["n3rd_pst_ref_vvd_no"];
				frm.n1st_pst_ts_loc_cd.value=dataVO["n1st_pst_ts_loc_cd"];				
				frm.n2nd_pst_ts_loc_cd.value=dataVO["n2nd_pst_ts_loc_cd"];				
				frm.n3rd_pst_ts_loc_cd.value=dataVO["n3rd_pst_ts_loc_cd"];	
			} else {
				//ComResetAll();
				if (frm.cgo_clm_no.value == "") {
					//msgs["CNI00013"] = "There is no data to search.";
					ComShowCodeMessage("CNI00013");
				}
			}
		}
		// ------------------------------------------------------------
		// CNTR sheet
		// ------------------------------------------------------------
		if (arrXml.length > 1) {
			sheet2.LoadSearchData(arrXml[1],{Sync:1} );
		}
	} else if (sAction == MULTI) {
		frm.f_cmd.value=MULTI;
		setSheetCgoClmNo();
		setCntrflg();
		frm.rct_dt.value=ComReplaceStr(frm.rct_dt, '-', '');		
		frm.lodg_dt.value=ComReplaceStr(frm.lodg_dt, '-', '');
		frm.dchg_dt.value=ComReplaceStr(frm.dchg_dt, '-', '');
		frm.de_dt.value=ComReplaceStr(frm.de_dt, '-', '');
		frm.n1st_pre_ts_dt.value=ComReplaceStr(frm.n1st_pre_ts_dt, '-', '');
		frm.n2nd_pre_ts_dt.value=ComReplaceStr(frm.n2nd_pre_ts_dt, '-', '');
		frm.n3rd_pre_ts_dt.value=ComReplaceStr(frm.n3rd_pre_ts_dt, '-', '');
		frm.n1st_pst_ts_dt.value=ComReplaceStr(frm.n1st_pst_ts_dt, '-', '');
		frm.n2nd_pst_ts_dt.value=ComReplaceStr(frm.n2nd_pst_ts_dt, '-', '');
		frm.n3rd_pst_ts_dt.value=ComReplaceStr(frm.n3rd_pst_ts_dt, '-', '');
		frm.clm_ofrt_amt.value=ComReplaceStr(frm.clm_ofrt_amt, ',','');	
		// amt 디폴트값세팅
		if (frm.clm_ofrt_amt.value == "") {
			frm.clm_ofrt_amt.value="0";
		}
		var param="";
		param += FormQueryString(frm);
		var saveString1=sheet1.GetSaveString();
		var saveString2=sheet2.GetSaveString();
		// if (sheet1.IsDataModified && ComIsNull(saveString)) {
		// return;
		// }
		saveString1=ComSetPrifix(saveString1, "sheet1_");
		saveString2=ComSetPrifix(saveString2, "sheet2_");
		param += "&" + saveString1 + "&" + saveString2;
 		var sXml=sheet3.GetSaveData("CPS_CNI_0010GS.do", param);
 		sheet3.LoadSaveData(sXml);
		// main에 없는 clm_no 를 입력하려고 할경우 에러처리하고 재조회하지 않는다.
		var manageStr="";
		manageStr=ComGetEtcData(sXml, "MANAGE_STR");
		if (manageStr == "N") {
			ComResetAll();
		}
		if (manageStr == "Y") {
			//재조회
			doActionIBSheet(SEARCHLIST01);
		}
	} else if (sAction == MULTI01) {
		frm.f_cmd.value=MULTI01;
		setSheetCgoClmNo();
		var param="";
		param += FormQueryString(frm);
		var saveString1=sheet1.GetSaveString();
		saveString1=ComSetPrifix(saveString1, "sheet1_");
		param += "&" + saveString1 ;
 		var sXml=sheet3.GetSaveData("CPS_CNI_0010GS.do", param);
 		sheet3.LoadSaveData(sXml);
		var manageStr="";
		manageStr=ComGetEtcData(sXml, "MANAGE_STR");
		if (manageStr == "Y") {
			//재조회
			doActionIBSheet(SEARCHLIST01);
		}
	} 
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//            if (!isNumber(formObj.iPage)) {
		//                return false;
		// }
	}
	return true;
}
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Main(Trunk)", "");
			InsertItem( "Pre/On-Carriage", "");
		}
		break;
	}
}
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab1].style.display="none";
	// --------------- 요기가 중요 --------------------------//
	objs[beforetab1].style.zIndex=objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab1=nItem;
}
 /**
 * HTML Control KeyDowm event
 */
function obj_keydown() {	 
	if((ComGetEvent("keycode") >= 37)&&(ComGetEvent("keycode") <= 40)) return;
    switch (ComGetEvent("name")) {    
		case "cgo_clm_no":
			if (frm.cgo_clm_no.length == 10 && event.keyCode == 13) {
				doActionIBSheet(SEARCHLIST01);
			}
			break;
	}
}
 /**
  * HTML Control KeyUp event
  */
 function obj_keyup() {
	 if((ComGetEvent("keycode") >= 37)&&(ComGetEvent("keycode") <= 40)) return;
     switch (ComGetEvent("name")) {       
     	case "cgo_clm_no":
 			if(frm.cgo_clm_no.value.length == 10){ 				
 				doActionIBSheet(SEARCHLIST01);
 			}
 			break;
 	}
 }
  function obj_keypress() {
	    switch (event.srcElement.name) {
			case "n1st_pre_ts_loc_cd":
			case "n2nd_pre_ts_loc_cd":
			case "n3rd_pre_ts_loc_cd":
			case "n1st_pst_ts_loc_cd":
			case "n2nd_pst_ts_loc_cd":
			case "n3rd_pst_ts_loc_cd":	
				ComKeyOnlyAlphabet('uppernum');
				break;
		}
	} 
  /**
   * HTML Control Focus out
   **/
  function obj_deactivate() {	 
  	var frm=document.form;
  	switch (event.srcElement.name) {
  	case "clm_ofrt_amt":	
  		ComAddSeparator(frm.clm_ofrt_amt,"float");
  		break;
  	default:
  		ComChkObjValid(event.srcElement);
  	}
  }
  /**
   * HTML Control Foucs in
   */
function obj_activate(){
  ComClearSeparator(event.srcElement);
}
function sheet1_OnClick(sheetObj, row, col, value) {
	if (sheetObj.ColSaveName(col) == "cgo_clm_ref_bl_no") {
		//var str = sheet1ellValue(row, col);
		if (value != "") {
			frm.cgo_clm_ref_bl_no.value=value;
			//doActionIBSheet(SEARCHLIST02);
		}
	}
}
function sheet1_OnChange(sheetObj, row, col, value) {
	if (sheetObj.ColSaveName(col) == "cgo_clm_ref_bl_no") {
		var lastRow=row - 1 ;
		for( var i=0 ; i <= lastRow ; i++ ) {			
			if (sheet1.GetCellValue(i, "cgo_clm_ref_bl_no") == value) {
				ComShowCodeMessage("CNI00002" , "B/L No.( "+ value + " )");
				sheet1.SetCellValue(row, "cgo_clm_ref_bl_no","");
			}
		}
	}
}
//File Upload
function popupFileUploadCall(btnName, cgoClmNo) {
	var seq=btnName.replace("btn2_Upload_", "");
	seq="0010"+seq;	
	popupFileUpload(seq, cgoClmNo);
}
// 달력 화면 표시 공통  함수
function calendarDisplay(pInputObjName) {
	var result=pInputObjName.replace("btns_", "");
	calObj=eval("frm." + result);
	var vCal=new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(calObj, 'yyyy-MM-dd');
}
//Locaion 표시 공통  함수
function locationDisplay(pInputObjName) {
	var result=pInputObjName.replace("btns_", "");
	locObj=eval("frm." + result);
	var locCd=locObj.value;
	popupLocation(locCd);
}
/**
* setting Location
*/
function setLocation(rowArray) { 
	locObj.value=rowArray[0][3];
}
function setSheetCgoClmNo() {
	var ccno=frm.cgo_clm_no.value;
	for(var row=0; row<=sheet1.LastRow(); row++) {
if (sheet1.GetRowStatus(row) == "I")  {
			sheet1.SetCellValue(row , "cgo_clm_no",ccno,0);
		}
	}
	for(var row=0; row<=sheet2.LastRow(); row++) {
if (sheet2.GetRowStatus(row) == "I")  {
			sheet2.SetCellValue(row , "cgo_clm_no",ccno,0);
		}
	}
}
function chkInsertSheet1(row) {
	var cnt=sheet1.RowCount();
	if(cnt>1){
		sheet1.SetCellValue(row,"mn_bl_flg","N",0);
	}else if(cnt==1){
		sheet1.SetCellValue(row,"mn_bl_flg","Y",0);
	}
}
function rdOpen(strBkgNo){    
	rdUrl="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"; 
	rdFile="ESM_BKG_0109_DBL.mrd";	
	rdParam="/rv form_bkgNo[( '" + strBkgNo + "') ]"
		  + "  form_type[2]"
	      + " form_dataOnly[N]"
	      + " form_manifest[N]"
	      + " form_usrId[" +frm.usr_id.value+"] "
	      + " form_hiddeData[N]"
	      + " form_level[(3)]"
		  + " form_remark[]"
		  + " form_Cntr[1]"
		  + " form_mainOnly[N]"
		  + " form_CorrNo[]"
		  + " form_his_cntr[BKG_CONTAINER]"
		  + " form_his_bkg[BKG_BOOKING]"
		  + " form_his_mkd[BKG_BL_MK_DESC]"
		  + " form_his_xpt[BKG_XPT_IMP_LIC]"
		  + " form_his_bl[BKG_BL_DOC]"
		  + " isEncode[Y]"
		  + " /rp []"
		  + " /riprnmargin";
	frm.com_mrdTitle.value="OPUS Container Draft B/L Copies";
	frm.com_mrdPath.value=rdUrl+rdFile;
	frm.com_mrdArguments.value=rdParam + " /rwait";
	frm.com_mrdBodyTitle.value="OPUS Container Draft B/L Copies";
	ComOpenRDPopup('resizable=yes, width=900, height=800');
}
function chkCntrflg() {
	var sign=false;
	var flg='';
	for(var row=0; row<=sheet2.LastRow(); row++) {
		flg=sheet2.GetCellValue(row , "mn_cntr_flg");
		if(flg=='Y'){
			sign=true;
			return sign;
		}
	}
	return sign;
}
function setCntrflg() {
	if(!chkCntrflg()){		
		for(var row=0; row<=sheet2.LastRow(); row++) {
if (sheet2.GetRowStatus(row) == "I")  {
				sheet2.SetCellValue(row,"mn_cntr_flg",'Y',0);
				return;
			}
		}
	}
}
function setRefBlNo(){
	var flg='';
	for(var row=0; row<=sheet1.LastRow(); row++) {
		flg=sheet1.GetCellValue(row , "mn_bl_flg");
		if(flg=='Y'){
			frm.cgo_clm_ref_bl_no.value=sheet1.GetCellValue(row, "cgo_clm_ref_bl_no");
			return;
		}
	}
}
