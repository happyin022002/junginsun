/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0106.js
 *@FileTitle : Break Bulk Cargo Application
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.10
 *@LastModifier : 이병규
 *@LastVersion : 1.0
 * 2009.06.10 이병규
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.10.12 김영철 [CHM-201006332-01] PSA AUTO EDI 수정 요청 (Special Cargo 정보 자동 전송 및 WARNING 메세지 추가)
 2012.02.01 변종건 [CHM-201215892-01] DG Remark 추가 에러 사항 개선 요청
 2012.02.28 변종건 [CHM-201216422-01] SPECIAL CARGO 기능 보완 요청
 2013.05.03 최문환 [CHM-201324134]Split 01-VOP-SCG] B.Bulk Cargo application상 Loading/Discharging Method 강제사항으로 변경 요청
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class esm_bkg_0106 : esm_bkg_0106 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0106() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}
 
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var reqFlag = "";
var cancelFlg = "";
var retFlag = "";
var cmdtFlg = "";
var messageFlg = "";
var chkFlg = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	var sheetObject5 = sheetObjects[4];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName != "btn_splitPop") {
			if (layList.style.display == "") {
				layList.style.display = "none";
			}
		}
		switch (srcName) {

		case "btn_splitPop":
			doActionIBSheet(sheetObject1, formObject, COMMAND04);
			break;

		case "btn_cntr_add":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				cntrAdd();
			}
			break;

		case "btn_cntr_delete":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				cntrDelete();
			}
			break;

		case "btn_cargo_add":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				cargoAdd();
			}
			break;

		case "btn_cargo_delete":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				cargoDelete();
			}
			break;

		case "btn_cmdt":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("ESM_BKG_0653.do?cmdt_cd=" + formObject.cmdt_cd.value, 820, 690, "getCOM_CMDT_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0653");
			}
			break;

		case "dg_container_seq":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var cnt = 0;
				for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
					if (sheetObjects[2].CellValue(i, "ibflag") != "D") {
						cnt++;
					}
				}
				if (cnt == "0") {
					ComShowMessage(ComGetMsg("BKG00624"));
				} else {
					var bkgNo = document.getElementById("bkg_no").value;
					var cntrNo = document.getElementById("temp_cntr_no").value;
					var url = "ESM_BKG_0754.do?modalFlg=Y&bkgNo=" + bkgNo + "&cntrNo=" + cntrNo;
					ComOpenWindowCenter(url, "ESM_BKG_0754", 805, 330, true);
				}
			}
			break;

		case "btn_pol_cd":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var pol_cd = document.getElementById("pol_cd").value;
				if (pol_cd == "") {
				} else {
					ComOpenPopup("VOP_VSK_0509.do?loc_cd=" + pol_cd, 1020, 670, "", '0,0', true);
				}
			}
			break;

		case "btn_pod_cd":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var pod_cd = document.getElementById("pod_cd").value;
				if (pod_cd == "") {
				} else {
					ComOpenPopup("VOP_VSK_0509.do?loc_cd=" + pod_cd, 1020, 670, "", '0,0', true);
				}
			}
			break;

		case "btn_Copy":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url = "ESM_BKG_0720.do";
				ComOpenWindowCenter(url, "ESM_BKG_0720", 320, 180, true);
			}
			break;

		case "btn_Remark":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url = "ESM_BKG_0757.do";
				ComOpenWindowCenter(url, "ESM_BKG_0757", 420, 350, true);
			}
			break;

		case "btn_Retrieve":
			if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break;

		case "btn_Save":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				messageFlg = "save";
				reqFlag = "Y";
				retFlag = "";
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);

				if (retFlag == "Y") {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
			}
			break;

		case "btn_attach_file":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("ESM_BKG_0207.do?bkg_no=" + document.getElementById("bkg_no").value + "&ridr_tp_cd=B", 525, 520, "", "0,0,1,1,1,1,1", true);
			}
			break;

		case "btn_Request":
			document.getElementById("button").value = "N";
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				chkFlg = "N";
				messageFlg = "request";
				reqFlag = "N";
				retFlag = "";
				var iCnt1 = 0;
				var uCnt1 = 0;
				var dCnt1 = 0;
				var iCnt2 = 0;
				var uCnt2 = 0;
				var dCnt2 = 0;

				var reqCnt = 0;
				for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
					if (sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") != "C") {
						reqCnt++;
					}
				}
				if (reqCnt < 1) {

					ComShowMessage(ComGetMsg("BKG08107"));
					return;
				}

				if (sheetObjects[3].CellValue(1, "bdr_flg") == "Y" && sheetObjects[3].CellValue(1, "corr_no") != "") {
					ComShowMessage(ComGetMsg("BKG08076"));
					return;
				}
				iCnt1 = sheetObjects[1].FindText("ibflag", "I", 0, 2);
				uCnt1 = sheetObjects[1].FindText("ibflag", "U", 0, 2);
				dCnt1 = sheetObjects[1].FindText("ibflag", "D", 0, 2);
				iCnt2 = sheetObjects[2].FindText("ibflag", "I", 0, 2);
				uCnt2 = sheetObjects[2].FindText("ibflag", "U", 0, 2);
				dCnt2 = sheetObjects[2].FindText("ibflag", "D", 0, 2);
				if (iCnt1 > 0 || uCnt1 > 0 || dCnt1 > 0 || iCnt2 > 0 || uCnt2 > 0 || dCnt2 > 0) {
					if (sheetObjects[3].CellValue(1, "bdr_flg") != "Y" && sheetObjects[3].CellValue(1, "corr_no") == "") {
						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
						//}else{
						//	return;
						//} 					 				
					}
					if (sheetObjects[3].CellValue(1, "bdr_flg") == "Y" && sheetObjects[3].CellValue(1, "corr_no") == "" && sheetObjects[3].CellValue(1, "vsl_pre_pst_cd") != "") {
						ComShowMessage(ComGetMsg("BKG08074"));
						return;
					}
					if (sheetObjects[3].CellValue(1, "bdr_flg") == "Y" && sheetObjects[3].CellValue(1, "corr_no") == "" && sheetObjects[3].CellValue(1, "vsl_pre_pst_cd") == "") {
						ComShowMessage(ComGetMsg("BKG08075"));
						return;
					}
				}

				if (chkFlg != "Y") {
					var rowCnt = 0;
					for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
						if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
							rowCnt++;
						}
					}
					document.getElementById("row_cnt").value = rowCnt;
					var ncCnt = 0;
					var rCnt = 0;
					var yCnt = 0;
					for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
						if (sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "P") {
							ComShowMessage(ComGetMsg("BKG00500"));
							return;
						}
						if (sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "C") {
							ncCnt++;
						}
						if (sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "R") {
							rCnt++;
						}
						if (sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "Y") {
							yCnt++;
						}
						
						if (sheetObjects[2].CellValue(i, "cgo_lodg_mzd_cd") == "") {
							ComShowMessage(ComGetMsg("BKG00404","Loading Method","Loading Method"));
							return;
						}
						
						if (sheetObjects[2].CellValue(i, "cgo_dchg_mzd_cd") == "") {
							ComShowMessage(ComGetMsg("BKG00404","Discharging Method","Discharging Method"));
							return;
						}
						if (sheetObjects[2].CellValue(i, "cgo_dchg_sd_cd") == "") {
							ComShowMessage(ComGetMsg("BKG00404","Disch.side","Disch.side"));
							return;
						}
						if (sheetObjects[2].CellValue(i, "cgo_lodg_sd_cd") == "") {
							ComShowMessage(ComGetMsg("BKG00404","Load.side","Load.side"));
							return;
						}
					}
					if (ComGetObjValue(document.form.ovr_void_slt_qty) == "") {
						ComShowMessage(ComGetMsg("BKG00404","Void space","Void space"));
						return;
					}
					if (ncCnt > 0) {
						if (ComShowConfirm(ComGetMsg("BKG00521"))) {
						} else {
							return;
						}
					}
					if (rCnt > 0) {
						if (ComShowConfirm(ComGetMsg("BKG00522", document.getElementById("bkg_no").value))) {
						} else {
							return;
						}
					}
					if (yCnt > 0) {
						if (ComShowConfirm(ComGetMsg("BKG00523", document.getElementById("bkg_no").value))) {
						} else {
							return;
						}
					}

					for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
						if (sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") != "C") {
							sheetObjects[2].CellValue2(i, "apro_cd") = "R";
						}
					}

					doActionIBSheet(sheetObjects[0], document.form, COMMAND01);

					if (retFlag == "Y") {
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}
				}
			}
			break;

		case "btn_RequestCancel":
			
			document.getElementById("button").value = "Y";
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				chkFlg = "N";
				messageFlg = "requestCancel";
				reqFlag = "N";
				retFlag = "";
				var iCnt1 = 0;
				var uCnt1 = 0;
				var dCnt1 = 0;
				var iCnt2 = 0;
				var uCnt2 = 0;
				var dCnt2 = 0;
				if (cancelFlg == "Y") {
					return;
				}
				if (sheetObjects[3].CellValue(1, "bdr_flg") == "Y" && sheetObjects[3].CellValue(1, "corr_no") != "") {
					ComShowMessage(ComGetMsg("BKG08076"));
					return;
				}
				iCnt1 = sheetObjects[1].FindText("ibflag", "I", 0, 2);
				uCnt1 = sheetObjects[1].FindText("ibflag", "U", 0, 2);
				dCnt1 = sheetObjects[1].FindText("ibflag", "D", 0, 2);
				iCnt2 = sheetObjects[2].FindText("ibflag", "I", 0, 2);
				uCnt2 = sheetObjects[2].FindText("ibflag", "U", 0, 2);
				dCnt2 = sheetObjects[2].FindText("ibflag", "D", 0, 2);
				if (iCnt1 > 0 || uCnt1 > 0 || dCnt1 > 0 || iCnt2 > 0 || uCnt2 > 0 || dCnt2 > 0) {
					if (sheetObjects[3].CellValue(1, "bdr_flg") != "Y" && sheetObjects[3].CellValue(1, "corr_no") == "") {
						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
						//}else{
						//	return;
						//} 					 				
					}
					if (sheetObjects[3].CellValue(1, "bdr_flg") == "Y" && sheetObjects[3].CellValue(1, "corr_no") == "" && sheetObjects[3].CellValue(1, "vsl_pre_pst_cd") != "") {
						ComShowMessage(ComGetMsg("BKG08074"));
						return;
					}
					if (sheetObjects[3].CellValue(1, "bdr_flg") == "Y" && sheetObjects[3].CellValue(1, "corr_no") == "" && sheetObjects[3].CellValue(1, "vsl_pre_pst_cd") == "") {
						ComShowMessage(ComGetMsg("BKG08075"));
						return;
					}
				}
				if (chkFlg != "Y") {
					if (ComShowConfirm(ComGetMsg("BKG00613", sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "Seq")))) {
						var rowCnt = 0;
						for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
							if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
								rowCnt++;
							}
						}
						document.getElementById("row_cnt").value = rowCnt;
						/*
						for(var i=2; i<=sheetObjects[2].RowCount+1; i++){		  		 						  		  
							if(sheetObjects[2].CellValue(i,"spcl_cgo_apro_cd") != "C"){
								sheetObjects[2].CellValue2(i,"apro_cd") = "R";
							}else{
								sheetObjects[2].CellValue2(i,"apro_cd") = "C";
							}
						}
						 */
						sheetObjects[2].CellValue2(sheetObjects[2].SelectRow, "apro_cd") = "C";
						//cancel request시에는 request하지 않음
						doActionIBSheet(sheetObjects[0], document.form, COMMAND02);

						if (retFlag == "Y") {
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						}
					} else {
						return;
					}
				}
			}
			break;

		case "btn_approval":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("VOP_SCG_1017.do?scg_flg=BB&bkg_no=" + formObject.bkg_no.value, 1000, 490, "", '0,0', true);
			}
			break;

		case "btn_terminal_information":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("VOP_VSK_0509.do", 1020, 670, "", '0,0', true);
			}
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}

	//------------------------------------------------>
	//setInquiryDisableButton 이벤트 호출
	if (ComGetObjValue(document.form.isInquiry) == "Y") {
		setInquiryDisableButton();
	}
	initControl();
}

function initControl() {
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('click', 'obj_click', form);
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('keydown', 'obj_keydown', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); //- 포커스 나갈때
	applyShortcut();
}

function obj_deactivate() {
	var row = sheetObjects[1].SelectRow;
	switch (event.srcElement.name) {

	case "cmdt_cd":
		if (document.getElementById("bkg_no").value != "") {
			if (document.getElementById("cmdt_cd").value.length < 6) {
				var cmdt_cd = "";
				var len = 6 - Number(document.getElementById("cmdt_cd").value.length);
				cmdt_cd = document.getElementById("cmdt_cd").value;
				for ( var i = 1; i <= len; i++) {
					cmdt_cd = "0" + cmdt_cd;
				}
				document.getElementById("cmdt_cd").value = cmdt_cd;
				sheetObjects[2].CellValue2(row, "cmdt_cd") = cmdt_cd;
			}
			if (cmdtFlg == "") {
				doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
			}
		}
		break;
	}
}

function bkgSplitNoList(split_list) {
	document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
	layList.style.display = "none";
}

function obj_keyup() {
	var row = sheetObjects[2].SelectRow;
	switch (event.srcElement.name) {

	case "cmdt_cd":
		sheetObjects[2].CellValue2(row, "cmdt_cd") = document.getElementById("cmdt_cd").value;
		break;

	case "cmdt_nm":
		sheetObjects[2].CellValue2(row, "cmdt_nm") = document.getElementById("cmdt_nm").value;
		break;

	case "grav_ctr_desc":
		sheetObjects[2].CellValue2(row, "grav_ctr_desc") = document.getElementById("grav_ctr_desc").value;
		break;

	case "pck_dtl_desc":
		sheetObjects[2].CellValue2(row, "pck_dtl_desc") = document.getElementById("pck_dtl_desc").value;
		break;

	case "scr_dng_ctnt":
		sheetObjects[2].CellValue2(row, "scr_dng_ctnt") = document.getElementById("scr_dng_ctnt").value;
		break;

	case "spcl_rqst_desc":
		sheetObjects[2].CellValue2(row, "spcl_rqst_desc") = document.getElementById("spcl_rqst_desc").value;
		break;

	case "bb_dcgo_seq":
		sheetObjects[2].CellValue2(row, "cntr_cgo_seq") = document.getElementById("bb_dcgo_seq").value;
		sheetObjects[2].CellValue2(row, "bb_dcgo_seq") = document.getElementById("bb_dcgo_seq").value;
		break;

	}
}

function obj_keydown() {
	if (event.keyCode == 13) { // Enter Key 			
		switch (event.srcElement.name) {

		case "bkg_no":
			document.getElementById("bkg_no").value = (document.getElementById("bkg_no").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "bl_no":
			document.getElementById("bl_no").value = (document.getElementById("bl_no").value).toUpperCase();
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		}
	}
}

function obj_change() {
	var row = sheetObjects[2].SelectRow;
	switch (event.srcElement.name) {

	case "rcv_term_cd":
		sheetObjects[2].CellValue2(row, "rcv_term_cd") = document.getElementById("rcv_term_cd").value;
		break;

	case "de_term_cd":
		sheetObjects[2].CellValue2(row, "de_term_cd") = document.getElementById("de_term_cd").value;
		break;

	case "slng_pnt_flg":
		sheetObjects[2].CellValue2(row, "slng_pnt_flg") = document.getElementById("slng_pnt_flg").value;
		break;

	case "cgo_lodg_mzd_cd":
		sheetObjects[2].CellValue2(row, "cgo_lodg_mzd_cd") = document.getElementById("cgo_lodg_mzd_cd").value;
		break;

	case "wgt_ut_cd":
		for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
			sheetObjects[2].CellValue2(i, "wgt_ut_cd") = document.getElementById("wgt_ut_cd").value;
		}
		break;

	case "ovr_void_slt_qty":
		if (document.getElementById("bkg_no").value != "") {
			for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
				sheetObjects[2].CellValue2(i, "modifyaproflg") = "Y";
//				sheetObjects[2].CellValue2(i, "ibflag") = "U";
			}
		}
		break;
		
	case "cgo_dchg_mzd_cd":
		sheetObjects[2].CellValue2(row, "cgo_dchg_mzd_cd") = document.getElementById("cgo_dchg_mzd_cd").value;
		break;
		
	case "cgo_dchg_sd_cd":
		sheetObjects[2].CellValue2(row, "cgo_dchg_sd_cd") = document.getElementById("cgo_dchg_sd_cd").value;
		break;
		
	case "cgo_lodg_sd_cd":
		sheetObjects[2].CellValue2(row, "cgo_lodg_sd_cd") = document.getElementById("cgo_lodg_sd_cd").value;
		break;	
	}
}

function cntrAdd() {
	document.getElementById("temp_cntr_no").value = "";
	var rowCount = Number(sheetObjects[1].RowCount) - Number(sheetObjects[1].RowCount("D"));
	if (rowCount < sheetObjects[4].RowCount) {
		var Row = sheetObjects[1].DataInsert(-1);
		var cntr_name = "";
		var cntr_val = "";
		var rowCnt = 0;
		for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
			if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
				rowCnt++;
				sheetObjects[1].CellValue2(i, "Seq") = rowCnt;
			}
		}
		for ( var j = 1; j <= sheetObjects[4].RowCount; j++) {
			if (sheetObjects[4].CellValue(j, "DelChk") == "0") {
				cntr_name += sheetObjects[4].CellValue(j, "name") + "|";
				cntr_val += sheetObjects[4].CellValue(j, "val") + "|";
			}
		}
		cntr_val = cntr_val.substr(0, cntr_val.length - 1);
		cntr_name = cntr_name.substr(0, cntr_name.length - 1);
		sheetObjects[1].CellComboItem(Row, "cntr_no", cntr_name, cntr_val);
	} else {
		ComShowMessage(ComGetMsg("BKG08085"));
	}
}

function cntrDelete() {
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "DelChk") == "1") {
			var temp_cntr_no = sheetObjects[1].CellValue(i, "cntr_no");
			var temp_find_row = sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].CellValue(temp_find_row, "DelChk") = "0";
			}
		}
	}
	var drow = ComRowHideDelete(sheetObjects[1], "DelChk");
	var rowCnt = 0;
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
			rowCnt++;
			sheetObjects[1].CellValue2(i, "Seq") = rowCnt;
		}
	}
	var cntr_name = "";
	var cntr_val = "";
	for ( var j = 1; j <= sheetObjects[4].RowCount; j++) {
		if (sheetObjects[4].CellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[4].CellValue(j, "name") + "|";
			cntr_val += sheetObjects[4].CellValue(j, "val") + "|";
		}
	}
	cntr_val = cntr_val.substr(0, cntr_val.length - 1);
	cntr_name = cntr_name.substr(0, cntr_name.length - 1);
	var cnt = 0;
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		sheetObjects[1].CellComboItem(i, "cntr_no", sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_name, sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_val);
	}
}

function cargoAdd() {
	var cnt = sheetObjects[2].CellValue(2, "bb_cgo_seq");
	for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
		if (cnt < Number(sheetObjects[2].CellValue(i, "bb_cgo_seq"))) {
			cnt = Number(sheetObjects[2].CellValue(i, "bb_cgo_seq"));
		}
	}
	var Row = sheetObjects[2].DataInsert(-1);
	sheetObjects[2].CellValue2(Row, "bkg_no") = document.getElementById("bkg_no").value;
	sheetObjects[2].CellValue2(Row, "pck_qty") = "1";
	sheetObjects[2].CellValue2(Row, "bb_cgo_seq") = Number(cnt) + 1;
	sheetObjects[2].CellValue2(Row, "rcv_term_cd") = sheetObjects[3].CellValue(1, "rcv_term_cd");
	sheetObjects[2].CellValue2(Row, "de_term_cd") = sheetObjects[3].CellValue(1, "de_term_cd");
	sheetObjects[2].CellValue2(Row, "slng_pnt_flg") = "N";
	sheetObjects[2].CellValue2(Row, "cgo_lodg_mzd_cd") = "";
	sheetObjects[2].CellValue2(Row, "wgt_ut_cd") = document.getElementById("wgt_ut_cd").value;
	sheetObjects[2].CellValue2(Row, "cmdt_cd") = sheetObjects[3].CellValue(1, "cmdt_cd");
	sheetObjects[2].CellValue2(Row, "cmdt_nm") = sheetObjects[3].CellValue(1, "cmdt_nm");
	sheetObjects[2].CellValue2(Row, "cgo_dchg_mzd_cd") = "";
	sheetObjects[2].CellValue2(Row, "cgo_dchg_sd_cd") = "";
	sheetObjects[2].CellValue2(Row, "cgo_lodg_sd_cd") = "";
	var rowCnt = 0;
	for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
		if (sheetObjects[2].CellValue(i, "ibflag") != "D") {
			rowCnt++;
			sheetObjects[2].CellValue2(i, "Seq") = rowCnt;
		}
	}
	htmlSheetSync();
}

function cargoDelete() {
	for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
		if (sheetObjects[2].CellValue(i, "DelChk") == "1") {
			if (sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "P" || sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "R" || sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "Y" || sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "N") {
				ComShowMessage(ComGetMsg("BKG00525"));
				return;
			}
		}
	}
	var drow = ComRowHideDelete(sheetObjects[2], "DelChk");
	var rowCnt = 0;
	var rCnt = 0;
	for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
		if (sheetObjects[2].CellValue(i, "ibflag") != "D") {
			rowCnt++;
			rCnt++;
			sheetObjects[2].CellValue2(i, "Seq") = rowCnt;
		}
	}
	if (rCnt < 1) {
		document.getElementById("Seq").value = "";
		document.getElementById("bb_dcgo_seq").value = "";
		document.getElementById("rcv_term_cd").value = "";
		document.getElementById("de_term_cd").value = "";
		document.getElementById("slng_pnt_flg").value = "";
		document.getElementById("grav_ctr_desc").value = "";
		document.getElementById("cmdt_cd").value = "";
		document.getElementById("cmdt_nm").value = "";
		document.getElementById("pck_dtl_desc").value = "";
		document.getElementById("cgo_lodg_mzd_cd").value = "";
		document.getElementById("scr_dng_ctnt").value = "";
		document.getElementById("spcl_rqst_desc").value = "";
		document.getElementById("temp_grs_wgt").value = "";
		document.getElementById("temp_net_wgt").value = "";
		document.getElementById("diff_rmk").value = "";
		document.getElementById("aply_no").value = "";
		document.getElementById("btn_Remark").style.color = "";
		document.getElementById("cgo_dchg_mzd_cd").value = "";
		document.getElementById("cgo_dchg_sd_cd").value = "";
		document.getElementById("cgo_lodg_sd_cd").value = "";
	}
}

function copyCnt(copyCnt) {
	for (i = 1; i <= copyCnt; i++) {
		var seqVal = Number(sheetObjects[2].CellValue(2, "bb_cgo_seq"));
		for ( var k = 2; k <= sheetObjects[2].RowCount + 1; k++) {
			if (seqVal < Number(sheetObjects[2].CellValue(k, "bb_cgo_seq"))) {
				seqVal = sheetObjects[2].CellValue(k, "bb_cgo_seq");
			}
		}
		var selRow = sheetObjects[2].SelectRow;
		var Row = sheetObjects[2].DataInsert(-1);
		for ( var ic = 0; ic <= sheetObjects[2].LastCol; ic++) {
			if (sheetObjects[2].ColSaveName(ic) == "ibflag" || sheetObjects[2].ColSaveName(ic) == "seq")
				continue;
			sheetObjects[2].CellValue2(Row, ic) = sheetObjects[2].CellValue(selRow, ic);
		}
		sheetObjects[2].CellValue2(Row, "bb_cgo_seq") = Number(seqVal) + 1;
		sheetObjects[2].CellValue2(Row, "DelChk") = "0";
		sheetObjects[2].CellValue2(Row, "spcl_cgo_apro_cd") = "";
	}
	var rowCnt = 0;
	for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
		if (sheetObjects[2].CellValue(i, "ibflag") != "D") {
			rowCnt++;
			sheetObjects[2].CellValue2(i, "Seq") = rowCnt;
		}
	}
}

function callbackPckTp(returnVal) {
	sheetObjects[2].CellValue2(sheetObjects[2].SelectRow, "pck_tp_cd") = returnVal[0][2];
}

function getCOM_CMDT_POPUP(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	formObject.cmdt_cd.value = colArray[3];
	sheetObjects[2].CellValue2(sheetObjects[2].SelectRow, "cmdt_cd") = colArray[3];
	formObject.cmdt_nm.value = colArray[4];
	sheetObjects[2].CellValue2(sheetObjects[2].SelectRow, "cmdt_nm") = colArray[4];
	sheetObjects[2].CellValue2(sheetObjects[2].SelectRow, "modifyaproflg") = "Y";
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 82;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(3, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false);
			var HeadTitle1 = "TP/SZ|BKG Q'ty|BB Q'ty";
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 75, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 75, daRight, true, "op_cntr_qty", false, "", dfFloat, 2, false, true);
			InitDataProperty(0, cnt++, dtData, 75, daRight, false, "bb_cgo_qty", false, "", dfFloat, 2, false, false);
			CountPosition = 0;
		}
		break;

	case 2: //sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 122;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(8, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false);
			var HeadTitle1 = "|Sel.|Seq|Container List|TS|Vol.|bb_cgo_flg|bkg_no";
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true, "DelChk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "Seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 95, daLeft, true, "cntr_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, true, "cntr_vol_qty", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bb_cgo_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "bkg_no", false, "", dfNone, 0, true, true);
			CountPosition = 0;
		}
		break;

	case 3: //sheet3 init
		with (sheetObj) {
			// 높이 설정
			style.height = 162;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 2, 100);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(35, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false);
			var HeadTitle1 = "||Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|cgo_dchg_sd_cd";
			var HeadTitle2 = "|Sel.|Seq.|Length|Width|Height|Grs Weight|Net Weight|Unit.|PKG|Appr.|Load.side|Disch.side|bb_dcgo_seq|rcv_term_cd|de_term_cd|cmdt_cd|cmdt_nm|slng_pnt_flg|grav_ctr_desc|pck_dtl_desc|cgo_lodg_mzd_cd|scr_dng_ctnt|spcl_rqst_desc|diff_rmk|modifyaproflg|bkg_no|bb_cgo_seq|pck_qty|por_cd|del_cd|apro_cd|cgo_dchg_mzd_cd";
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 45, daCenter, false, "DelChk");
			InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "Seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 58, daRight, true, "dim_len", false, "", dfInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 58, daRight, true, "dim_wdt", false, "", dfInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 58, daRight, true, "dim_hgt", false, "", dfInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 87, daRight, true, "grs_wgt", false, "", dfFloat, 3, true, true, 11);
			InitDataProperty(0, cnt++, dtHidden, 77, daRight, true, "net_wgt", false, "", dfFloat, 3, true, true, 11);
			InitDataProperty(0, cnt++, dtData, 39, daLeft, false, "wgt_ut_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtPopupEdit, 45, daLeft, true, "pck_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, false, "spcl_cgo_apro_cd", false, "", dfNone, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, "cgo_lodg_sd_cd", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daRight, true, "cgo_dchg_sd_cd", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "bb_dcgo_seq", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "rcv_term_cd", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "de_term_cd", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "cmdt_cd", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "cmdt_nm", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "slng_pnt_flg", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "grav_ctr_desc", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "pck_dtl_desc", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "cgo_lodg_mzd_cd", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "scr_dng_ctnt", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "spcl_rqst_desc", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "diff_rmk", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "modifyaproflg", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "bkg_no", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "bb_cgo_seq", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "pck_qty", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "cntr_cgo_seq", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "por_cd", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "del_cd", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "apro_cd", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "aply_no", false, "", dfNone, 3, true, true);
			InitDataProperty(0, cnt++, dtHidden, 80, daRight, true, "cgo_dchg_mzd_cd", false, "", dfNone, 3, true, true);
			
			
			InitDataValid(0, "pck_tp_cd", vtEngUpOnly, "");
			CountPosition = 0;
		}
		break;

	case 4: //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 4, 100);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(22, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)
			var HeadTitle1 = "bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|rcv_term_cd|de_term_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|corr_no|ovr_void_slt_qty";
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, false);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "bkg_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "bl_no", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "vsl_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pol_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pol_nod_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pod_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pod_nod_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "rcv_term_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "de_term_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "bkg_sts_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "corr_n1st_dt", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "bdr_flg", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pck_qty", false, "", dfInteger, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pck_tp_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "grs_wgt", false, "", dfFloat, 3, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "wgt_ut_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "corr_no", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "ovr_void_slt_qty", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "cmdt_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "cmdt_nm", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "vsl_pre_pst_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "img_flg", false, "", dfNone, 2, true, true);
			CountPosition = 0;
		}
		break;

	case 5: //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			var HeadTitle1 = "|value|name|TpszCd";
			var headCount = ComCountHeadTitle(HeadTitle1);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(5, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false);
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, false, "DelChk");
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "val", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "name", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_tpsz_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_vol_qty", false, "", dfNone, 0, true, true);
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value = SEARCH;
		var resultXml = sheetObj.GetSearchXml("ESM_BKG_0106GS.do", FormQueryString(formObj));
		var arrXml = resultXml.split("|$$|");
		if (arrXml.length == 5) {
			var etcXml = arrXml[0];
			if (ComGetEtcData(etcXml, "rqst_dt") == "null" || ComGetEtcData(etcXml, "rqst_dt") == "") {
				document.getElementById("rqst_dt").innerText = "";
				document.getElementById("rqst_usr_id").innerText = "";
				document.getElementById("rqst_gdt").innerText = "";
			} else {
				document.getElementById("rqst_dt").innerText = ComGetEtcData(etcXml, "rqst_dt");
				document.getElementById("rqst_gdt").innerText = ComGetEtcData(etcXml, "rqst_gdt");
				document.getElementById("rqst_usr_id").innerText = ComGetEtcData(etcXml, "rqst_usr_id");
			}
			if (arrXml[4].indexOf("TOTAL='0'") < 1) {
				var arrCombo = ComXml2ComboString(arrXml[4], "val", "name");
				sheetObjects[1].InitDataCombo(0, "cntr_no", " |" + arrCombo[0], " |" + arrCombo[1], "");
			}
			sheetObjects[0].LoadSearchXml(arrXml[1], false);
			sheetObjects[1].LoadSearchXml(arrXml[3], false);
			sheetObjects[2].LoadSearchXml(arrXml[0], false);
			sheetObjects[3].LoadSearchXml(arrXml[2], false);
			sheetObjects[4].LoadSearchXml(arrXml[4], false);
			if (sheetObjects[3].CellValue(1, "de_term_cd") == "M") {
				document.getElementById("de_term_cd").disabled = false;
			} else {
				document.getElementById("de_term_cd").disabled = true;
			}
			if (sheetObjects[3].CellValue(1, "rcv_term_cd") == "M") {
				document.getElementById("rcv_term_cd").disabled = false;
			} else {
				document.getElementById("rcv_term_cd").disabled = true;
			}
			if (document.getElementById("bkg_no").value == "") {
				document.getElementById("bkg_no").value = sheetObjects[3].CellValue(1, "bkg_no");
			}
			document.getElementById("bl_no").value = sheetObjects[3].CellValue(1, "bl_no");
			document.getElementById("tvvd").value = sheetObjects[3].CellValue(1, "vsl_cd");
			document.getElementById("pol_cd").value = sheetObjects[3].CellValue(1, "pol_cd");
			document.getElementById("pod_cd").value = sheetObjects[3].CellValue(1, "pod_cd");
			document.getElementById("pol_nod_cd").value = sheetObjects[3].CellValue(1, "pol_nod_cd");
			document.getElementById("pod_nod_cd").value = sheetObjects[3].CellValue(1, "pod_nod_cd");
			document.getElementById("weight_sum").value = sheetObjects[3].CellText(1, "grs_wgt");
			document.getElementById("wgt_ut_cd").value = sheetObjects[3].CellValue(1, "wgt_ut_cd");
			document.getElementById("ovr_void_slt_qty").value = sheetObjects[3].CellValue(1, "ovr_void_slt_qty");
			for ( var j = 1; j <= sheetObjects[1].RowCount; j++) {
				var cntr_no = sheetObjects[1].CellValue(j, "cntr_no");
				var find_row = sheetObjects[4].FindText("name", cntr_no, 0, 2);
				sheetObjects[4].CellValue2(find_row, "DelChk") = "1";
			}
			/* by 이진서  memory lose
			var cntr_name = "";
			var cntr_val = "";														
			for (var j=1; j<=sheetObjects[4].RowCount; j++){	 																					
				if(sheetObjects[4].CellValue(j, "DelChk") == "0"){								
					cntr_name += sheetObjects[4].CellValue(j, "name")+"|";
					cntr_val += sheetObjects[4].CellValue(j, "val")+"|";	 										
				} 									
			}						
			cntr_val = cntr_val.substr(0,cntr_val.length-1);	
			cntr_name = cntr_name.substr(0,cntr_name.length-1);					    					  
			for (var i=1; i<=sheetObjects[1].RowCount; i++){							   						   
			   if(sheetObjects[1].CellValue(i, "cntr_no") != ""){							  
				   sheetObjects[1].CellComboItem(i, "cntr_no", sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_name, sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_val);
				   sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = false;
				   sheetObjects[1].CellEditable(i,"cntr_vol_qty") = false;
			   }else{							   
				  sheetObjects[1].CellComboItem(i, "cntr_no", " |"+cntr_name, " |"+cntr_val);
				  sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = true;
				  sheetObjects[1].CellEditable(i,"cntr_vol_qty") = true;
			   } 							  
			}	
			 */
			var tpszN = sheetObjects[2].FindText("spcl_cgo_apro_cd", "N", 0, 2);
			var tpszP = sheetObjects[2].FindText("spcl_cgo_apro_cd", "P", 0, 2);
			var tpszR = sheetObjects[2].FindText("spcl_cgo_apro_cd", "R", 0, 2);
			var tpszY = sheetObjects[2].FindText("spcl_cgo_apro_cd", "Y", 0, 2);
			if (tpszN > 0) {
				document.getElementById("auth_cd").value = " N";
				document.getElementById("auth_cd").style.color = "red";
				document.getElementById("auth_cd").style.fontWeight = "bold";
			} else if (tpszP > 0 && tpszN < 0) {
				document.getElementById("auth_cd").style.color = "black";
				document.getElementById("auth_cd").value = " P";
				document.getElementById("auth_cd").style.fontWeight = "bold";
			} else if (tpszR > 0 && tpszN < 0 && tpszP < 0) {
				document.getElementById("auth_cd").style.color = "black";
				document.getElementById("auth_cd").value = " R";
				document.getElementById("auth_cd").style.fontWeight = "bold";
			} else if (tpszY > 0 && tpszR < 0 && tpszN < 0 && tpszP < 0) {
				document.getElementById("auth_cd").style.color = "black";
				document.getElementById("auth_cd").value = " Y";
				document.getElementById("auth_cd").style.fontWeight = "bold";
			} else {
				document.getElementById("auth_cd").style.color = "";
				document.getElementById("auth_cd").value = "";
				document.getElementById("auth_cd").style.fontWeight = "";
			}
			for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
				sheetObjects[1].CellValue2(i, "Seq") = i;
				sheetObjects[1].CellValue2(i, "ibflag") = "R";
			}
			for ( var i = 2; i <= sheetObjects[2].RowCount + 1; i++) {
				if (sheetObjects[2].CellValue(i, "spcl_cgo_apro_cd") == "N") {
					sheetObjects[2].CellFontColor(i, "spcl_cgo_apro_cd") = sheetObjects[2].RgbColor(255, 0, 0);
					sheetObjects[2].CellFont("FontBold", i, "spcl_cgo_apro_cd") = true;
				}
				sheetObjects[2].CellValue2(i, "Seq") = i - 1;
				sheetObjects[2].CellValue2(i, "ibflag") = "R";
			}
			htmlSheetSync();
			if (sheetObjects[2].RowCount < 1 && document.getElementById("bl_no").value != "") {
				document.getElementById("auth_cd").value = "";
				cargoAdd();
			} else if (sheetObjects[2].RowCount < 1 && document.getElementById("bl_no").value == "") {
				ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
				return;
			}
		}
		//------------------------------------------------>
		//setInquiryDisableButton 이벤트 호출
		if (ComGetObjValue(document.form.isInquiry) == "Y") {
			setInquiryDisableButton();
		}
		break;

	case COMMAND04: //booking split no조회 
		formObj.f_cmd.value = COMMAND03;
		var param = "&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
		var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
		bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 25);

		break;

	case IBSAVE: //저장
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value = MULTI;
		
		if (sheetObjects[3].CellValue(1, "corr_no") == "" && sheetObjects[3].CellValue(1, "bdr_flg") == "Y") {
			ComShowMessage(ComGetMsg("BKG00004"));
			chkFlg = "Y";
			return;
		}
		
		var retCnt1 = 0;
		var retCnt2 = 0;
		var delCnt = 0;
		var iudCnt = 0;
		var cntrNo = "";
		var oldCntrNo = "";
		var bbChkFlg = "N";
		
		for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
			if (sheetObjects[1].CellValue(i, "ibflag") == "R") {
				retCnt1++;
			}
			if (sheetObjects[1].CellValue(i, "ibflag") == "I" || sheetObjects[1].CellValue(i, "ibflag") == "U" || sheetObjects[1].CellValue(i, "ibflag") == "D") {
				iudCnt++;
			}
			if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == "") {
				ComShowMessage(ComGetMsg("BKG00502", "BB"));
				chkFlg = "Y";
				return;
			}
			// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
			cntrNo = sheetObjects[1].CellValue(i, "cntr_no");
			oldCntrNo = sheetObjects[1].CellSearchValue(i, "cntr_no");
			if ( bbChkFlg == "N" && cntrNo != oldCntrNo ) {
				bbChkFlg = "Y";
			}
		}
		if (iudCnt > 0) {
			for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
				if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
					sheetObjects[1].CellValue(i, "ibflag") = "I"
				}
			}
		}
		for ( var k = 2; k <= sheetObjects[2].RowCount + 1; k++) {
			//if(sheetObjects[2].CellValue(k, "spcl_cgo_apro_cd") != "C" || sheetObjects[2].CellValue(k, "apro_cd") != "C"){					
			if (sheetObjects[2].CellValue(k, "ibflag") == "R") {
				retCnt2++;
			}
			if (sheetObjects[2].CellValue(k, "ibflag") != "D") {
				delCnt++;
			}
			if (sheetObjects[2].CellValue(k, "spcl_cgo_apro_cd") == "P") {
				ComShowMessage(ComGetMsg("BKG00500"));
				chkFlg = "Y";
				return;
			}
			if (sheetObjects[2].CellValue(k, "grs_wgt") == "" || sheetObjects[2].CellValue(k, "grs_wgt") == "0") {
				ComShowMessage(ComGetMsg("BKG00506"));
				chkFlg = "Y";
				return;
			}
			if (sheetObjects[2].CellValue(k, "wgt_ut_cd") == "") {
				ComShowMessage(ComGetMsg("BKG00509"));
				chkFlg = "Y";
				return;
			}
			if (sheetObjects[2].CellValue(k, "cmdt_cd") == "") {
				ComShowMessage(ComGetMsg("BKG00510"));
				chkFlg = "Y";
				return;
			}

			if (ComGetObjValue(formObj.ovr_void_slt_qty) == "") {
				ComShowMessage(ComGetMsg("BKG00404","Void space","Void space"));
				chkFlg = "Y";
				return;
			}
			
			if (sheetObjects[2].CellValue(k, "cgo_lodg_mzd_cd") == "") {
				ComShowMessage(ComGetMsg("BKG00404","Loading Method","Loading Method"));
				chkFlg = "Y";
				return;
			}
			
			if (sheetObjects[2].CellValue(k, "cgo_dchg_mzd_cd") == "") {
				ComShowMessage(ComGetMsg("BKG00404","Discharging Method","Discharging Method"));
				chkFlg = "Y";
				return;
			}
			
			if (sheetObjects[2].CellValue(k, "cgo_dchg_sd_cd") == "") {
				ComShowMessage(ComGetMsg("BKG00404","Disch.side","Disch.side"));
				chkFlg = "Y";
				return;
			}
			
			if (sheetObjects[2].CellValue(k, "cgo_lodg_sd_cd") == "") {
				ComShowMessage(ComGetMsg("BKG00404","Load.side","Load.side"));
				chkFlg = "Y";
				return;
			}
			
			//}
		}
		var sum = 0;
		if (sheetObjects[0].RowCount > 0) {
			sum = sheetObjects[0].ComputeSum("|2|");
		}
		if (sum == "0") {
			if (delCnt > 0) {
				ComShowMessage(ComGetMsg("BKG00502", "BB"));
				chkFlg = "Y";
				return;
			}
		}
		if (retCnt1 == sheetObjects[1].RowCount && retCnt2 == sheetObjects[2].RowCount + 1) {
			if (reqFlag != "N") {
				ComShowMessage(ComGetMsg("BKG00501"));
				chkFlg = "Y";
				return;
			}
		}
		for ( var j = 1; j <= sheetObjects[0].RowCount; j++) {
			var cnt = 0;
			var rcnt = 0;
			var find_tpsz_cd = "";
			for ( var m = 1; m <= sheetObjects[1].RowCount; m++) {
				// Cancel 되거나 삭제된 행 제외
				if (sheetObjects[1].CellValue(m, "spcl_cgo_apro_cd") != "C" && sheetObjects[1].CellValue(m, "ibflag") != "D") {
					if (sheetObjects[0].CellValue(j, "cntr_tpsz_cd") == sheetObjects[1].CellValue(m, "cntr_tpsz_cd")) {
						cnt += Number(sheetObjects[1].CellValue(m, "cntr_vol_qty"));
						cnt = parseFloat(cnt.toFixed(2));
					}
					var find_tpsz_row = sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].CellValue(m, "cntr_tpsz_cd"), 0, 2);
					if (find_tpsz_row < 0) {
						rcnt++;
						find_tpsz_cd += sheetObjects[1].CellValue(m, "cntr_tpsz_cd") + ",";
					}
				}
			}
			if (rcnt > 0) {
				find_tpsz_cd = find_tpsz_cd.substr(0, find_tpsz_cd.length - 1);
				ComShowCodeMessage("BKG08023", find_tpsz_cd);
				chkFlg = "Y";
				return;
			}
			var cntr_tpsz_cd = sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[0].CellValue(j, "cntr_tpsz_cd"), 0, 2);
			if (cntr_tpsz_cd > 0 || cntr_tpsz_cd == "-1") {
				if (Number(sheetObjects[0].CellValue(j, "bb_cgo_qty")) > cnt) {
					if (ComShowConfirm(ComGetMsg("BKG00678", "BB"))) {
						cnt = 0;
					} else {
						chkFlg = "Y";
						return;
					}
				}
				if (Number(sheetObjects[0].CellValue(j, "bb_cgo_qty")) < cnt) {
					ComShowCodeMessage("BKG00679", "BB");
					chkFlg = "Y";
					return;
				}
			}
		}

		var sParam = FormQueryString(formObj);
		// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
		sParam = sParam + "&" + "bb_chk_flg=" + bbChkFlg;
		
		var sParamSheet1 = sheetObjects[1].GetSaveString();
		var sParamSheet2 = sheetObjects[2].GetSaveString();
		if (sParamSheet1 != "") {
			sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		}
		if (sParamSheet2 != "") {
			sParam = sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
		}
		var rXml = sheetObj.GetSaveXml("ESM_BKG_0106GS.do", sParam);
		var rMsg = ComResultMessage(rXml);
		var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		// BB 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
		if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
			var errMsg01 = ComGetEtcData(rXml,"psaValCode");
			

			/*
			 * 2010.10.13 경종윤 추가 
			 * null 문제
			 * if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") { }
			 */
			if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {
				var rmsg = errMsg01.split("<||>");
		    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
		    		ComShowCodeMessage("BKG06125");
		    	}else if ( rmsg[1] != "BKG95025" ){
		    		ComShowMessage(rmsg[3]);
		    	}
			}
		}
		if (rMsg == '' && reqFlag == "Y") {
			ComShowMessage(ComGetMsg("BKG00166"));
			retFlag = "Y";
		} else if (rMsg == '' && reqFlag == "N") {
		} else {
			sheetObj.LoadSearchXml(rXml);
			return false;
		}

		break;

	case COMMAND01:
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value = COMMAND01;
		var sParam = FormQueryString(formObj);
		var sParamSheet1 = sheetObjects[2].GetSaveString();
		if (sParamSheet1 != "") {
			sParam = sParam + "&sheet2_" + sParamSheet1.replace(/&/g, '&sheet2_');
		}
		var rXml = sheetObj.GetSaveXml("ESM_BKG_0106GS.do", sParam);
		var rMsg = ComResultMessage(rXml);
		var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		// BB 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
		if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
			var errMsg01 = ComGetEtcData(rXml,"psaValCode");
	    	var rmsg = errMsg01.split("<||>");
	    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
	    		ComShowCodeMessage("BKG06125");
	    	}else if ( rmsg[1] != "BKG95025" ){
	    		ComShowMessage(rmsg[3]);
	    	}	
		}
		if (rMsg == '' && reqFlag == "N" && messageFlg == "save") {
			//ComShowMessage(ComGetMsg("BKG00166"));
			retFlag = "Y";
		} else if (rMsg == '' && reqFlag == "N" && messageFlg == "request") {
			ComShowMessage(ComGetMsg("BKG08102"));
			retFlag = "Y";
		} else if (rMsg == '' && reqFlag == "Y") {
		} else {
			sheetObj.LoadSearchXml(rXml);
			return;
		}
		break;

	case COMMAND02:
		if (validateForm(sheetObj, formObj, sAction))
			formObj.f_cmd.value = COMMAND01;
		var sParam = FormQueryString(formObj);
		var sParamSheet1 = sheetObjects[2].GetSaveString();
		if (sParamSheet1 != "") {
			sParam = sParam + "&sheet2_" + sParamSheet1.replace(/&/g, '&sheet2_');
		}
		var rXml = sheetObj.GetSaveXml("ESM_BKG_0106GS.do", sParam);
		var rMsg = ComResultMessage(rXml);
		var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		if (rMsg == '' && reqFlag == "N" && messageFlg == "save") {
			//ComShowMessage(ComGetMsg("BKG00166"));
			retFlag = "Y";
		} else if (rMsg == '' && reqFlag == "N" && messageFlg == "requestCancel") {
			ComShowMessage(ComGetMsg("BKG08103"));
			retFlag = "Y";
		} else if (rMsg == '' && reqFlag == "Y") {
		} else {
			sheetObj.LoadSearchXml(rXml);
			return;
		}
		break;

	case COMMAND05: //booking split no조회 
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			cmdtFlg = "1";
			formObj.f_cmd.value = COMMAND05;
			var rXml = sheetObj.GetSearchXml("ESM_BKG_0498GS.do", FormQueryString(formObj));
			var cmdt_nm = ComGetEtcData(rXml, "cmdt_nm");
			document.getElementById("cmdt_nm").value = cmdt_nm;
			sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "cmdt_nm") = cmdt_nm;
			sheetObjects[2].CellValue2(sheetObjects[2].SelectRow, "modifyaproflg") = "Y";
			sheetObj.WaitImageVisible = true;
			cmdtFlg = "";
		} else {
			return false;
		}
		break;
	}
}
//조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet4_OnSearchEnd(sheetObj, ErrMsg){
	with (sheetObj) {
		if(sheetObjects[3].RowCount > 0 ){
			/* Image Storage 에 BB 항목에 해당 image 가 한건이라도 첨부 되어 있으면 버튼 색상 변경 추가 */
			if(sheetObjects[3].CellValue(1,"img_flg") == "Y"){
				document.getElementById('btn_attach_file').style.color = 'blue';
			}else{
				document.getElementById('btn_attach_file').style.color = '';
			}
		}
	}
}
function htmlSheetSync() {
	Row = sheetObjects[2].SelectRow;
	document.getElementById("Seq").value = sheetObjects[2].CellValue(Row, "Seq");
	document.getElementById("bb_dcgo_seq").value = sheetObjects[2].CellValue(Row, "bb_dcgo_seq");
	document.getElementById("rcv_term_cd").value = sheetObjects[2].CellValue(Row, "rcv_term_cd");
	document.getElementById("de_term_cd").value = sheetObjects[2].CellValue(Row, "de_term_cd");
	document.getElementById("slng_pnt_flg").value = sheetObjects[2].CellValue(Row, "slng_pnt_flg");
	document.getElementById("grav_ctr_desc").value = sheetObjects[2].CellValue(Row, "grav_ctr_desc");
	document.getElementById("cmdt_cd").value = sheetObjects[2].CellValue(Row, "cmdt_cd");
	document.getElementById("cmdt_nm").value = sheetObjects[2].CellValue(Row, "cmdt_nm");
	document.getElementById("pck_dtl_desc").value = sheetObjects[2].CellValue(Row, "pck_dtl_desc");
	document.getElementById("cgo_lodg_mzd_cd").value = sheetObjects[2].CellValue(Row, "cgo_lodg_mzd_cd");
	document.getElementById("scr_dng_ctnt").value = sheetObjects[2].CellValue(Row, "scr_dng_ctnt");
	document.getElementById("spcl_rqst_desc").value = sheetObjects[2].CellValue(Row, "spcl_rqst_desc");
	document.getElementById("temp_grs_wgt").value = sheetObjects[2].CellValue(Row, "grs_wgt");
	document.getElementById("temp_net_wgt").value = sheetObjects[2].CellValue(Row, "net_wgt");
	document.getElementById("diff_rmk").value = sheetObjects[2].CellValue(Row, "diff_rmk");
	document.getElementById("aply_no").value = sheetObjects[2].CellValue(Row, "aply_no");
	document.getElementById("cgo_dchg_mzd_cd").value = sheetObjects[2].CellValue(Row, "cgo_dchg_mzd_cd");
	document.getElementById("cgo_dchg_sd_cd").value = sheetObjects[2].CellValue(Row, "cgo_dchg_sd_cd");
	document.getElementById("cgo_lodg_sd_cd").value = sheetObjects[2].CellValue(Row, "cgo_lodg_sd_cd");
	if (sheetObjects[2].RowCount > 0 && sheetObjects[2].CellValue(Row, "diff_rmk").length > 0) {
		document.getElementById("btn_Remark").style.color = "blue";
	} else {
		document.getElementById("btn_Remark").style.color = "";
	}
	if (sheetObjects[2].CellValue(Row, "spcl_cgo_apro_cd") == "C" || sheetObjects[2].CellValue(Row, "spcl_cgo_apro_cd") == "") {
		document.getElementById("btn_RequestCancel").className = "btn2_1";
		cancelFlg = "Y";
	} else {
		document.getElementById("btn_RequestCancel").className = "btn2";
		cancelFlg = "N";
	}
}

/**
 * Sheet관련 컬럼 fnCntrComboItem 엑션 이벤트 처리 
 * @param sheetObj, Row, Col, Value
 */
function fnCntrComboItem(sheetObj, row, col, val) {
	var cntr_name = "";
	var cntr_val = "";
	for ( var j = 1; j <= sheetObjects[4].RowCount; j++) {
		if (sheetObjects[4].CellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[4].CellValue(j, "name") + "|";
			cntr_val += sheetObjects[4].CellValue(j, "val") + "|";
		}
	}
	cntr_val = cntr_val.substr(0, cntr_val.length - 1);
	cntr_name = cntr_name.substr(0, cntr_name.length - 1);
	var checkCntr = sheetObjects[4].FindText("DelChk", "0", 0, 2);
	var i = row;
	if (checkCntr > 0) {
		if (val != "") {
			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_name, " |" + sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_val);
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = false;
			sheetObjects[1].CellEditable(i, "cntr_vol_qty") = false;
		} else {
			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + cntr_name, " |" + cntr_val);
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = true;
			sheetObjects[1].CellEditable(i, "cntr_vol_qty") = true;
		}
	} else {
		if (val != "") {
			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].CellValue(i, "cntr_no"), " |" + sheetObjects[1].CellValue(i, "cntr_no"));
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = false;
			sheetObjects[1].CellEditable(i, "cntr_vol_qty") = false;
		} else {
			sheetObjects[1].CellComboItem(i, "cntr_no", " ", " ");
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = true;
			sheetObjects[1].CellEditable(i, "cntr_vol_qty") = true;
		}
	}
}

/**
 * Sheet관련 컬럼 sheet2_OnClick 엑션 이벤트 처리 
 * @param sheetObj, Row, Col, Value
 */
function sheet2_OnClick(sheetObj, row, col, val) {

	var col_name = sheetObj.ColSaveName(col);
	switch (col_name) {
	case "cntr_no":
		document.getElementById("temp_cntr_no").value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "cntr_no");
		fnCntrComboItem(sheetObj, row, col, val);
		break;
	}
}

function sheet2_OnChange(sheetObj, row, col, val) {
	var col_name = sheetObj.ColSaveName(col);
	switch (col_name) {

	case "cntr_no":
		if (sheetObjects[1].CellValue(row, "cntr_no") != "") {
			var temp_cntr_no = document.getElementById("temp_cntr_no").value;
			var temp_find_row = sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].CellValue(temp_find_row, "DelChk") = "0";
			}
			var cntr_no = sheetObjects[1].CellValue(row, "cntr_no");
			var find_row = sheetObjects[4].FindText("name", cntr_no, 0, 2);
			if (sheetObjects[1].CellValue(row, "cntr_no") != "" && sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != "" && sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd")) {
				if (ComShowConfirm(ComGetMsg("BKG00570"))) {
					sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
				} else {
					sheetObjects[1].CellValue2(row, "cntr_no") = "";
					cntr_no = "";
				}
			} else if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd") == "") {
				sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
			}
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = sheetObjects[4].CellValue(find_row, "cntr_vol_qty");
			if (cntr_no != "") {
				sheetObjects[4].CellValue2(find_row, "DelChk") = "1";
			}
			document.getElementById("temp_cntr_no").value = cntr_no;

			/*
			var cntr_name = "";
			var cntr_val = "";									 						
			for (var j=1; j<=sheetObjects[4].RowCount; j++){	 									 																
				if(sheetObjects[4].CellValue(j, "DelChk") == "0"){ 									
					cntr_name += sheetObjects[4].CellValue(j, "name")+"|";
					cntr_val += sheetObjects[4].CellValue(j, "val")+"|";	 										
				} 									
			}							 					
			cntr_val = cntr_val.substr(0,cntr_val.length-1);	
			cntr_name = cntr_name.substr(0,cntr_name.length-1); 					
			for (var i=1; i<=sheetObjects[1].RowCount; i++){					 						
				if(sheetObjects[1].CellValue(i, "cntr_no") != ""){ 							   
					sheetObjects[1].CellComboItem(i, "cntr_no", sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_name, sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_val);							   
					sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = false;
					sheetObjects[1].CellEditable(i,"cntr_vol_qty") = false; 							   
				}else{ 							 
					sheetObjects[1].CellComboItem(i, "cntr_no", " |"+cntr_name, " |"+cntr_val);							  
					sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = true;
					sheetObjects[1].CellEditable(i,"cntr_vol_qty") = true;
				} 												   
			}	
			 */

		} else {
			var temp_cntr_no = document.getElementById("temp_cntr_no").value;
			var temp_find_row = sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].CellValue(temp_find_row, "DelChk") = "0";
			}
			document.getElementById("temp_cntr_no").value = "";

			/*
			var cntr_name = "";
			var cntr_val = "";							 						
			for (var j=1; j<=sheetObjects[4].LastRow; j++){	 									 																
				if(sheetObjects[4].CellValue(j, "DelChk") == "0"){ 									
					cntr_name += sheetObjects[4].CellValue(j, "name")+"|";
					cntr_val += sheetObjects[4].CellValue(j, "val")+"|";	 										
				} 									
			}
			cntr_val = cntr_val.substr(0,cntr_val.length-1);	
			cntr_name = cntr_name.substr(0,cntr_name.length-1);										 					
			for (var i=1; i<=sheetObjects[1].RowCount; i++){						 												
				if(sheetObjects[1].CellValue(i, "cntr_no") != ""){ 							   
					   sheetObjects[1].CellComboItem(i, "cntr_no", sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_name, sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_val);							   
					   sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = false;
					   sheetObjects[1].CellEditable(i,"cntr_vol_qty") = false; 						
				}else{ 							 
					  sheetObjects[1].CellComboItem(i, "cntr_no", " |"+cntr_name, " |"+cntr_val);							  
					  sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = true;
					  sheetObjects[1].CellEditable(i,"cntr_vol_qty") = true;
				}													
			}
			 */
		}
		break;
	}
}

function sheet3_OnChange(sheetObj, row, col, val) {
	var col_name = sheetObj.ColSaveName(col);
	switch (col_name) {

	case "grs_wgt":
		if (Number(sheetObjects[2].CellValue(row, "grs_wgt")) < Number(sheetObjects[2].CellValue(row, "net_wgt"))) {
			sheetObjects[2].CellValue(row, "grs_wgt") = document.getElementById("temp_grs_wgt").value;
			ComShowMessage(ComGetMsg("BKG00491"));
		}
		sheetObjects[2].CellValue2(row, "modifyaproflg") = "Y";
		sheetObjects[3].CellValue2(1, "grs_wgt") = sheetObjects[2].ComputeSum("|6|");
		document.getElementById("weight_sum").value = sheetObjects[3].CellText(1, "grs_wgt")
		break;

	case "net_wgt":
		if (Number(sheetObjects[2].CellValue(row, "grs_wgt")) < Number(sheetObjects[2].CellValue(row, "net_wgt"))) {
			sheetObjects[2].CellValue(row, "net_wgt") = document.getElementById("temp_net_wgt").value;
			ComShowMessage(ComGetMsg("BKG00491"));
		}
		sheetObjects[2].CellValue2(row, "modifyaproflg") = "Y";
		break;
	}
}

function sheet3_OnClick(sheetObj, Row, Col, Value) {
	htmlSheetSync();
}

function sheet3_OnPopupClick(sheetObj, row, col, Value) {
	var col_name = sheetObj.ColSaveName(col);
	switch (col_name) {

	case "pck_tp_cd":
		sheetObjects[2].CellValue2(row, "pck_tp_cd") = (sheetObjects[2].CellValue(row, "pck_tp_cd")).toUpperCase();
		comBkgCallModal0696("callbackPckTp", sheetObjects[2].CellValue(row, "pck_tp_cd"));
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
/**
 * setInquiryDisableButton 이벤트 호출 .<br>
 * ComBtnDisable 을 했을경우 비활성화
 * @param 
 */
function setInquiryDisableButton() {
	ComBtnDisable("btn_attach_file");
	ComBtnDisable("btn_terminal_information");
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_Request");

}
