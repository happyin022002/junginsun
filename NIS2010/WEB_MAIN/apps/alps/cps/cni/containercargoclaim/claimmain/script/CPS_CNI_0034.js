/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0034.js
 *@FileTitle : [CPS_CNI_0034] View-Contract of Carriage-Main
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.23
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.11.23 박제성
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0034] View-Contract of Carriage-Main
 * 
 * @extends
 * @class Contract of Carriage-Main 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function cps_cni_0034() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initControl = initControl;
	this.validateForm = validateForm;
	this.t1sheet1_OnClick = t1sheet1_OnClick;
}

// =============================================================
// #Form Command          #IBSheet Action                
// INIT = 0; IBSEARCH = 0; // 조회
// ADD = 1; IBSEARCHAPPEND = 1; // 페이징 조회
// SEARCH = 2; IBSAVE = 2; // 저장
// SEARCHLIST = 3; IBINSERT = 3; // 삽입
// MODIFY = 4; IBCLEAR = 4; // 초기화
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
// 전역변수 추상함수
// ===================================================================================

var tabObjects = new Array();
var tabCnt = 0;
var beforetab1 = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
var sheet2 = null;
var sheet3 = null;

//IBmultiCombo
var comboObjects = new Array();
var comboCnt = 0;

// html form
var frm = null;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}
 
 /**
 * IBCombo Object를 배열에 등록
 * @param comboObj
 **/
function setComboObject(comboObj){
	comboObjects[comboCnt++] = comboObj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	frm = document.form;
	sheet1 = sheetObjects[0];
	sheet2 = sheetObjects[1];
	sheet3 = sheetObjects[2];
	sheetCnt = sheetObjects.length;

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

		doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	
	
	// IBMultiCombo초기화
	comboCnt = comboObjects.length;

	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}

	initComboBox();

	//Form 이벤트 등록
	initControl();
	
	if(frm.cgo_clm_no.value != ""){
		doActionIBSheet(SEARCHLIST01);
	}
	ComSetFocus(frm.cgo_clm_no);
}

/**
 * Form 이벤트 등록
 */
function initControl() {
	//keypress
	axon_event.addListenerForm('keypress', 'obj_keypress', frm);
	// keydown
	axon_event.addListenerForm('keydown', 'obj_keydown', frm);
	//key up
	axon_event.addListenerForm('keyup', 'obj_keyup', frm); 
	// focus in
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	// focus out
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
}

 /**
 * 초기 콤보 설정
 **/
function initComboBox() {

	setMultiComboBox("clm_ofrt_term_cd" ); 
	setMultiComboBox("clm_ofrt_flg" ); 	
}

/**
* IBMultiComboBox 설정<br>
* @param {select box} 콤보 객체
* @param {xml} code , name의 xml
* @param {String} 초기 선택 Code 
*/
function setMultiComboBox(comboId) {
	var vComboObj      = null; // IBMultiComboBox
	var vArrayListData = ""; 
	var vListData      = "";
	var vCaptionText   = "";
	
	vComboObj = getComboObject(comboId);
	
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
	
	vComboObj.Enable = false;

}


/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return
 **/
function getComboObject(pComboObjId){
	var vCnt = comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].id == pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {

		// Booking Preview	
		case "btn_BLPreview":
			
			//frm.cgo_clm_ref_bl_no.value = 'LAXA00974401';
			
			var blNo  = frm.cgo_clm_ref_bl_no.value;
			
			if (blNo == "") {
				ComShowMessage("Please use after retrieve ");		
				return false;
			}
							
			doActionIBSheet(SEARCHLIST03);
			
			var bkgNo = frm.bkg_no.value;
			
			if (bkgNo == "") {
				ComShowCodeMessage("CNI00013");
				return false;
			}
					
			rdOpen(bkgNo);							
        	break;	

		case "btn_Movement":
			var cntrNo = sheet2.CellValue(sheet2.SelectRow, "cgo_clm_ref_cntr_no");
			var cntrTpSzCd = sheet2.CellValue(sheet2.SelectRow, "bl_tp_cd");
					
			if (cntrNo != "" && cntrTpSzCd != "") {
				paramVal = "?p_cntrno=" + cntrNo + "&ctnr_tpsz_cd=" + cntrTpSzCd;
				ComOpenPopup('EES_CTM_0408.do' + paramVal, 1036, 680, "getInqMVMT", "1,0,1,1,1,1,1", true);
			}
			break;
			
		case "btn1_Retrieve":

			var cgoClmNo = frm.cgo_clm_no.value;
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
				frm.cgo_clm_no.value = "";
				ComSetFocus(frm.cgo_clm_no);
			}
			break;
			
		case "btn1_Handler":
			var cgoClmNo = frm.cgo_clm_no.value;	
			popupHandlerHistory(cgoClmNo);
			break;
			
		// -----------------[btns Start]------------------//
		case "btns_por_cd":
		case "btns_pol_cd":
		case "btns_pod_cd":
		case "btns_del_cd":		
			alert(srcName);
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
			var cgoClmNo = frm.cgo_clm_no.value;
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


		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
	case "sheet3": //sheet3 init
			with (sheetObj) {
			if (location.hostname != "") {
			 	WaitImageVisible = false; 
			 	InitHostInfo(location.hostname, location.port, page_path);
			}
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);
	
			var HeadTitle1 = "";
	
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	       
	        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	        InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
			
	        CountPosition = 0;
		}
		break;

	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 102;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|B/L No.|cgo_clm_no";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtDataSeq, 0, daCenter, true, "seq",
					false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true,
					"cgo_clm_ref_bl_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++ , dtHidden, 0, daCenter, true, "cgo_clm_no");

			CountPosition = 0;
		}
		break;

	case "sheet2": //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 102;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|CNTR No.|TP/SZ|B/L No.|cgo_clm_no";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag");

			InitDataProperty(0, cnt++, dtDataSeq, 0, daCenter, true, "seq",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true,
					"cgo_clm_ref_cntr_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, "tp", false,
					"", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 0, daCenter, true,
					"cgo_clm_ref_bl_no", true, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++ , dtHidden, 0, daCenter, true, "cgo_clm_no");

			CountPosition = 0;
		}
		break;
	}
}
 
 /**
  * Combo 기본 설정 
  * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  **/
 function initCombo(comboObj, comboNo) {

 	with (comboObj) {
 		comboObj.MultiSelect = false;
 		comboObj.UseCode = true;
 		comboObj.LineColor = "#ffffff";
 		//comboObj.BackColor = "#CCFFFD";
 		comboObj.SetColAlign("center|left");
 		comboObj.MultiSeparator = ",";
 		comboObj.DropHeight = 190;
 	}
 } 

// Sheet관련 프로세스 처리
function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;
	if (sAction == SEARCHLIST01) {

		frm.f_cmd.value = SEARCHLIST01;
		

		var sXml = sheet3.GetSearchXml("CPS_CNI_0034GS.do",
				FormQueryString(frm),"",true);
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			var list = SheetXml2ListMap(arrXml[0]);

			if (list.length > 0) {
				var dataVO = list[0];
				frm.cgo_clm_no.value = dataVO["cgo_clm_no"];
				frm.clm_area_cd.value = dataVO["clm_area_cd"];
				frm.hdlr_ofc_cd.value = dataVO["hdlr_ofc_cd"];
				frm.hdlr_usr_id.value = dataVO["hdlr_usr_id"];
				frm.upd_dt.value = dataVO["upd_dt"];
				frm.cgo_clm_inci_no.value = dataVO["cgo_clm_inci_no"];
				frm.crm_voc_no.value = dataVO["crm_voc_no"];
				frm.clm_misc_cd.value = dataVO["clm_misc_cd"];
				frm.clm_misc_nm.value = dataVO["clm_misc_nm"];
				frm.hpc.value = dataVO["hpc"];
				frm.nhp.value = dataVO["nhp"];
				frm.cgo_clm_stl_tp_cd.value = dataVO["cgo_clm_stl_tp_cd"];
				frm.cs_clz_dt.value = dataVO["cs_clz_dt"];
				frm.clm_tm_bar_dt.value = dataVO["clm_tm_bar_dt"];
				frm.smns_sve_dt.value = dataVO["smns_sve_dt"];
				frm.clmt_clm_pty_no.value = dataVO["clmt_clm_pty_no"];
				frm.clm_pty_abbr_nm.value = dataVO["clm_pty_abbr_nm"];
				frm.pty_nm.value = dataVO["pty_nm"];
				frm.clmt_clm_tp_cd.value = dataVO["clmt_clm_tp_cd"];

				frm.fmal_clm_rcv_ofc_cd.value = dataVO["fmal_clm_rcv_ofc_cd"];
				frm.fmal_clm_rcv_dt.value = dataVO["fmal_clm_rcv_dt"];
				frm.cgo_clm_tp_cd.value = dataVO["cgo_clm_tp_cd"];
				frm.mjr_clm_dmg_lss_cd.value = dataVO["mjr_clm_dmg_lss_cd"];
				frm.n3rd_labl_pty_cd.value = dataVO["n3rd_labl_pty_cd"];
				frm.inci_plc_tp_cd.value = dataVO["inci_plc_tp_cd"];
				frm.inci_occr_dt.value = dataVO["inci_occr_dt"];
								
				frm.clmt_usd_amt.value =
					  ComAddComma2( dataVO["clmt_usd_amt"],"#,###.00");

				frm.trnk_ref_vvd_no.value = dataVO["trnk_ref_vvd_no"];
				frm.slan_cd.value = dataVO["slan_cd"];
				frm.crr_term_cd.value = dataVO["crr_term_cd"];
				frm.por_cd.value = dataVO["por_cd"];
				frm.rct_dt.value = dataVO["rct_dt"];
				frm.pol_cd.value = dataVO["pol_cd"];
				frm.lodg_dt.value = dataVO["lodg_dt"];
				frm.pod_cd.value = dataVO["pod_cd"];
				frm.dchg_dt.value = dataVO["dchg_dt"];
				frm.del_cd.value = dataVO["del_cd"];
				frm.de_dt.value = dataVO["de_dt"];

				frm.shpr_nm.value = dataVO["shpr_nm"];
				frm.cnee_nm.value = dataVO["cnee_nm"];
				frm.ntfy_nm.value = dataVO["ntfy_nm"];
				frm.clm_cgo_tp_cd.value = dataVO["clm_cgo_tp_cd"];
				frm.cgo_qlty_desc.value = dataVO["cgo_qlty_desc"];
				frm.clm_ofrt_amt.value = 
							ComAddComma2( dataVO["clm_ofrt_amt"],"#,###.00");
				
				ComSetObjValue(frm.clm_ofrt_term_cd, dataVO["clm_ofrt_term_cd"]);
				ComSetObjValue(frm.clm_ofrt_flg, dataVO["clm_ofrt_flg"]);

				frm.n1st_pre_ref_vvd_no.value = dataVO["n1st_pre_ref_vvd_no"];
				frm.n2nd_pre_ref_vvd_no.value = dataVO["n2nd_pre_ref_vvd_no"];
				frm.n3rd_pre_ref_vvd_no.value = dataVO["n3rd_pre_ref_vvd_no"];
				frm.n1st_pre_ts_loc_cd.value = dataVO["n1st_pre_ts_loc_cd"];
				frm.n1st_pre_ts_dt.value = dataVO["n1st_pre_ts_dt"];
				frm.n2nd_pre_ts_loc_cd.value = dataVO["n2nd_pre_ts_loc_cd"];
				frm.n2nd_pre_ts_dt.value = dataVO["n2nd_pre_ts_dt"];
				frm.n3rd_pre_ts_loc_cd.value = dataVO["n3rd_pre_ts_loc_cd"];
				frm.n3rd_pre_ts_dt.value = dataVO["n3rd_pre_ts_dt"];
				frm.n1st_pst_ref_vvd_no.value = dataVO["n1st_pst_ref_vvd_no"];
				frm.n2nd_pst_ref_vvd_no.value = dataVO["n2nd_pst_ref_vvd_no"];
				frm.n3rd_pst_ref_vvd_no.value = dataVO["n3rd_pst_ref_vvd_no"];
				frm.n1st_pst_ts_loc_cd.value = dataVO["n1st_pst_ts_loc_cd"];
				frm.n1st_pst_ts_dt.value = dataVO["n1st_pst_ts_dt"];
				frm.n2nd_pst_ts_loc_cd.value = dataVO["n2nd_pst_ts_loc_cd"];
				frm.n2nd_pst_ts_dt.value = dataVO["n2nd_pst_ts_dt"];
				frm.n3rd_pst_ts_loc_cd.value = dataVO["n3rd_pst_ts_loc_cd"];
				frm.n3rd_pst_ts_dt.value = dataVO["n3rd_pst_ts_dt"];
				
				
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

			sheet1.LoadSearchXml(arrXml[1]);
			
			var blno = sheet1.cellValue(1, 2);
			if (blno != "") {
				
				frm.cgo_clm_ref_bl_no.value = blno;				
				// CNTR
				doActionIBSheet(SEARCHLIST02);
			}
		}

	} else if (sAction == SEARCHLIST02) {

		frm.f_cmd.value = SEARCHLIST02;
		var sXml = sheet2.GetSearchXml("CPS_CNI_0010GS.do",
				FormQueryString(frm),"",true);
		var arrXml = sXml.split("|$$|");

		// ------------------------------------------------------------
		// sheet 설정
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet2.LoadSearchXml(arrXml[0]);
		} else {
			ComShowCodeMessage("CNI00013");
		}
		
	} else if (sAction == SEARCHLIST03) {
		
		frm.f_cmd.value = SEARCHLIST03;
		var sXml = sheet3.GetSearchXml("CPS_CNI_0010GS.do", FormQueryString(frm),"",true);		
				
		var arrXml = sXml.split("|$$|");

		// ------------------------------------------------------------
		// Booking No 설정
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			var list = SheetXml2ListMap(arrXml[0]);	
			
			if (list.length > 0) {
				var dataVO = list[0];					
				frm.bkg_no.value = dataVO["bkg_no"];					
			}
			
		} else {
			frm.bkg_no.value = '';
			//ComShowCodeMessage("CNI00013");
		}	

	} 

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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
			var cnt = 0;
			InsertTab(cnt++, "Main(Trunk)", -1);
			InsertTab(cnt++, "Pre/On-Carriage", -1);
		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer1");

	objs[nItem].style.display = "Inline";
	objs[beforetab1].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab1].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab1 = nItem;
}

 /**
 * HTML Control KeyDowm 이벤트 호출
 */
 function obj_keydown() {
	 if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;  
	 switch (event.srcElement.name) {    
			case "cgo_clm_no":
				if (frm.cgo_clm_no.length == 10 && event.keyCode == 13) {
					doActionIBSheet(SEARCHLIST01);
				}

				break;
		}
	}
 
 /**
  * HTML Control KeyUp 이벤트 호출
  */
 function obj_keyup() {
	  if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;
	  switch (event.srcElement.name) {    
 		case "cgo_clm_no":
 			if(frm.cgo_clm_no.value.length == 10){
 				doActionIBSheet(SEARCHLIST01);
 			}
 			break;
 	}
 }
  
  /**
   * HTML Control Focus out
   **/

  function obj_deactivate() {	 
  	var frm = document.form;
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

		//var str = sheet1SellValue(row, col);
		if (value != "") {
			frm.cgo_clm_ref_bl_no.value = value;
			doActionIBSheet(SEARCHLIST02);
		}
	}

}

//File Upload
function popupFileUploadCall(btnName, cgoClmNo) {
	var seq = btnName.replace("btn2_Upload_", "");
	seq = "0034"+seq;	
	popupFileUpload(seq, cgoClmNo);
}

//Locaion 표시 공통  함수
function locationDisplay(pInputObjName) {
	var result = pInputObjName.replace("btns_", "");
	locObj = eval("frm." + result);
	var locCd = locObj.value;
	popupLocation(locCd);

}

/**
* Location 설정
*/
function setLocation(rowArray) { 
	locObj.value = rowArray[0][3];
}

// 달력 화면 표시 공통  함수
function calendarDisplay(pInputObjName) {
	var result = pInputObjName.replace("btns_", "");
	calObj = eval("frm." + result);
	var vCal = new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(calObj, 'yyyy-MM-dd');
}

function rdOpen(strBkgNo){    

	rdUrl = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"; 
	rdFile = "ESM_BKG_0109_DBL.mrd";	
	rdParam = "/rv form_bkgNo[( '" + strBkgNo + "') ]"
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
		
	frm.com_mrdTitle.value = "Hanjin Shipping Draft B/L Copies";
	frm.com_mrdPath.value = rdUrl+rdFile;
	frm.com_mrdArguments.value = rdParam + " /rwait";
	frm.com_mrdBodyTitle.value="Hanjin Shipping Draft B/L Copies";
		
	ComOpenRDPopup('resizable=yes, width=900, height=800');
}


