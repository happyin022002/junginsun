/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0055.js
 *@FileTitle : Awakward Cargo Application
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
 2011.05.03 이재위 [CHM-201108912] [Booking] AWK 화물의 weight Check 로직 생성 요청
 2011.05.11 변종건 [CHM-201110122-01][AK, RF] CNTR#부재상태의 Approval Pending시 CNTR#입력가능
 2012.02.01 변종건 [CHM-201215892-01] DG Remark 추가 에러 사항 개선 요청
 2012.02.10 변종건 [CHM-201216124-01] BKG/DOC AK Seq 정리 요청
 2012.02.28 변종건 [CHM-201216422-01] SPECIAL CARGO 기능 보완 요청
 2012.10.15 조정민 [CHM-201220509] [Special Cargo Application] Email기능 추가 - RF,AK (DG기존재)
 2013.12.05 신규정 [CHM-201327524] AK APPLICATION 화면에 E-MAIL 1, 2 추가 요청
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
 * @class esm_bkg_0055 : esm_bkg_0055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0055() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var ttlCnt = 0;
var reqFlag = "";
var cancelFlg = "";
var retFlag = "";
var cmdtFlg = "";
var messageFlg = "";
var chkFlg = "";
var pendingSaveFlg = "Y"	//Approval이 Pending 상태일 때는 Container No를 제외한 나머지 모든 값은 신규 또는 수정이 되지 않게 상태 확인하는 Flag
var endFlg = "";


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

	//------------------------------------------------>
	//setInquiryDisableButton 이벤트 호출
	if (ComGetObjValue(document.form.isInquiry) == "Y") {
		setInquiryDisableButton();
	}
	initControl();
}

function initControl() {
	//Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('blur', 'obj_blur', form);
	axon_event.addListenerForm('click', 'obj_click', form);
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('keydown', 'obj_keydown', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); //- 포커스 나갈때
	applyShortcut();
}

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
	var sheetObject6 = sheetObjects[5];
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
		// bkg_split_no 조회시...
		case "btn_splitPop":
			doActionIBSheet(sheetObject1, formObject, COMMAND04);
			break;

		// 조회시...
		case "btn_Retrieve":
			if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break;

		// 저장시...
		case "btn_Save":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				messageFlg = "save";
				
				//reqFlag = N일 경우 request 로직을 탄다.IBSAVE
				reqFlag = "Y";

				//retFlag = Y일 경우 조회 로직을 탄다.
				retFlag = ""; 

				//저장로직...
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);

				// 2017.08.04 iylee Approval 이 'Y'인 경우, 자동Request 한다.
				if (document.getElementById("auth_cd").value == "Y"){
					document.getElementById('btn_Request').click();					
				} else {
					//저장이 완료되고, 다시 조회할 경우...
					if (retFlag == "Y") {
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}
				}
			}
			break;

		// Request시...
		case "btn_Request":
			document.form.button.value = "N";
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				messageFlg = "request";
				chkFlg = "N";
				var iCnt = 0;
				var uCnt = 0;
				var dCnt = 0;

				//reqFlag = N일 경우 request 로직을 탄다.
				reqFlag = "N";

				//retFlag = Y일 경우 조회 로직을 탄다.
				retFlag = "";

				var reqCnt = 0;
				for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") != "C") {
						reqCnt++;
					}
				}

				if (reqCnt < 1) {
					ComShowMessage(ComGetMsg("BKG08107"));
					return;
				}
				
				var cntR = 0;
				for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
					if (sheetObjects[1].CellValue(i, "ibflag") != "R") {
						cntR++;
					}
				}
				
				for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
					if (sheetObjects[3].CellValue(i, "ibflag") != "R") {
						cntR++;
					}
				}

				if (cntR > 0 && sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") != "") {
					ComShowMessage(ComGetMsg("BKG08076"));
					return;
				}

				//insert된 데이터의 존재 여부
				iCnt = sheetObjects[1].FindText("ibflag", "I", 0, 2);
				//update된 데이터의 존재 여부
				uCnt = sheetObjects[1].FindText("ibflag", "U", 0, 2);
				//delete된 데이터의 존재 여부
				dCnt = sheetObjects[1].FindText("ibflag", "D", 0, 2);

				//insert, update, delete 데이터가 존재할경우...
				if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
					if (sheetObjects[2].CellValue(1, "bdr_flg") != "Y" && sheetObjects[2].CellValue(1, "corr_no") == "") {
						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
						//저장로직...	 					 						
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
						if ( endFlg == "Y"){
							return;
						}
						//}else{
						//return;
						//} 					 				
					}
					if (sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "vsl_pre_pst_cd") != "") {
						ComShowMessage(ComGetMsg("BKG08074"));
						return;
					}

					if (sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "vsl_pre_pst_cd") == "") {
						ComShowMessage(ComGetMsg("BKG08075"));
						return;
					}
				}else{
					voidSpaceCheck();
					if(endFlg == "Y"){
						return;
					}
				}

				var ncCnt = 0;
				var rCnt = 0;
				var yCnt = 0;
				for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "P") {
						ComShowMessage(ComGetMsg("BKG00500"));
						return;
					}
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "C") {
						//appr.의 값이 N이거나 P일경우... ncCnt의 값을 1씩 더한다.
						ncCnt++;
					}
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "R") {
						//appr.의 값이 R일경우... rCnt의 값을 1씩 더한다.
						rCnt++;
					}
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "Y") {
						//appr.의 값이 Y일경우... yCnt의 값을 1씩 더한다.
						yCnt++;
					}
				}

				if (chkFlg != "Y") {
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

					//저장로직이 정상적으로 완료되었거나, 저장할 데이터가 없을 경우, saveEnd = Y이다.
					for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
						//appr.의 값이 C가 이닐 경우 apro_cd에 R을 셋팅한다.
						if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") != "C") {
							sheetObjects[1].CellValue2(i, "apro_cd") = "R";
						}
					}

					doActionIBSheet(sheetObjects[0], document.form, COMMAND02);

					//request가 정상적으로 완료되면 조회로직을 탄다.
					if (retFlag == "Y") {
						
						// 조회로직...
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}
				}
			}
			break;

		//request cancel시...
		case "btn_RequestCancel":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				chkFlg = "N";
				messageFlg = "requestCancel";

				//reqFlag = N일 경우 request 로직을 탄다.
				reqFlag = "N";

				//retFlag = Y일 경우 조회 로직을 탄다.
				retFlag = "";

				var iCnt = 0;
				var uCnt = 0;
				var dCnt = 0;

				if (cancelFlg == "Y") {
					return;
				}

				if (sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") != "") {
					ComShowMessage(ComGetMsg("BKG08076"));
					return;
				}

				//insert된 데이터의 존재 여부
				iCnt = sheetObjects[1].FindText("ibflag", "I", 0, 2);

				//update된 데이터의 존재 여부
				uCnt = sheetObjects[1].FindText("ibflag", "U", 0, 2);

				//delete된 데이터의 존재 여부
				dCnt = sheetObjects[1].FindText("ibflag", "D", 0, 2);

				//insert, update, delete 데이터가 존재할경우...
				if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
					if (sheetObjects[2].CellValue(1, "bdr_flg") != "Y" && sheetObjects[2].CellValue(1, "corr_no") == "") {
						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
						//}else{
						//return;
						//} 					 				
					}
					if (sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "vsl_pre_pst_cd") != "") {
						ComShowMessage(ComGetMsg("BKG08074"));
						return;

					}

					if (sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "vsl_pre_pst_cd") == "") {
						ComShowMessage(ComGetMsg("BKG08075"));
						return;
					}
				}
				if (chkFlg != "Y") {
					if (ComShowConfirm(ComGetMsg("BKG00613", sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "seq")))) {
						/*
						for(var i=1; i <= sheetObjects[1].RowCount; i++){							
							//appr.의 값이 C가 이닐 경우 apro_cd에 R을 셋팅한다.
							if(sheetObjects[1].CellValue(i,"spcl_cgo_apro_cd") != "C"){
								sheetObjects[1].CellValue2(i,"apro_cd") = "R";							
								//appr.의 값이 C일 경우 apro_cd에 C를 셋팅한다.	
							}else{
								sheetObjects[1].CellValue2(i,"apro_cd") = "C";
							}
						}
						*/

						//선택된 row의 apro_cd에 C를 셋팅한다.
						sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "apro_cd") = "C";

						//request cancel로직...
						doActionIBSheet(sheetObjects[0], document.form, COMMAND03);

						//request cancel로직이 정상적으로 완료되면 조회로직을 탄다.
						if (retFlag == "Y") {
							//조회로직...
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
						}
					} else {
						return;
					}
				}
			}
			break;

		// 첨부화일 팝업...
		case "btn_attach":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				//awk일 경우... ridr_tp_cd의 값은 A로 넘긴다. 
				ComOpenPopup("ESM_BKG_0207.do?bkg_no=" + document.getElementById("bkg_no").value + "&ridr_tp_cd=A", 525, 520, "", "0,0,1,1,1,1,1", true);
			}
			break;			
			
		//e-mail 전송
		case "btn_email":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				sendMail();
			}
			break;

		// 선택된 sheet 데이터 row copy 팝업...
		case "btn_Copy":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				
				if (document.getElementById("auth_cd").value == "P"){
					ComShowMessage(ComGetMsg("BKG00500"));
					return;
				}				
				copyRowPopup();
			}
			break;

		//remark 입력 팝업...
		case "btn_Remark":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url = "ESM_BKG_0757.do";
				ComOpenWindowCenter(url, "ESM_BKG_0757", 420, 350, true);
			}
			break;

		//pol_cd 팝업...
		case "btn_pol_cd":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var pol_cd = document.getElementById("pol_cd").value;
				if (pol_cd == "") {
				} else {
					ComOpenPopup("VOP_VSK_0509.do?loc_cd=" + pol_cd, 1020, 670, "", '0,0', true);
				}
			}
			break;

		//pod_cd 팝업...
		case "btn_pod_cd":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var pod_cd = document.getElementById("pod_cd").value;
				if (pod_cd == "") {
				} else {
					ComOpenPopup("VOP_VSK_0509.do?loc_cd=" + pod_cd, 1020, 670, "", '0,0', true);
				}
			}
			break;

		//add 버튼 클릭시...
		case "add_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {				
				if (document.getElementById("auth_cd").value == "P"){
					ComShowMessage(ComGetMsg("BKG00500"));
					return;
				}				
				checkAdd();
			}
			break;

		//package type 팝업...
		case "pck_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				comBkgCallModal0696("callbackPckTp", formObject.frm_pck_tp_cd.value);

			}
			break;

		// comodity 코드 검색 팝업...
		case "cmdt_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("ESM_BKG_0653.do?cmdt_cd=" + formObject.cmdt_cd.value, 820, 690, "getCOM_CMDT_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0653");
			}
			break;

		// del 버튼 클릭시...
		case "del_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				deleteRows();
			}
			break;

		// criteria 팝업...
		case "criteria_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url = "ESM_BKG_0057.do";
				ComOpenWindowCenter(url, "ESM_BKG_0057", 610, 460, true);
			}
			break;

		//details 버튼 클릭시 ... dimension 값 입력/수정/삭제 팝업
		case "details_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url = "ESM_BKG_0756.do?modalFlg=Y&sheetRow=" + sheetObject2.SelectRow;
				ComOpenWindowCenter(url, "ESM_BKG_0756", 460, 300, true);
				//ComOpenWindowCenter("ESM_BKG_0756.do?bkgNo=SHAZSX00018&awkCgoSeq=1", "ESM_BKG_0756", 400, 300, true);
			}
			break;

		//approval 조회 팝업...
		case "btn_approval":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("VOP_SCG_1016.do?scg_flg=AK&bkg_no=" + formObject.bkg_no.value, 1000, 490, "", '0,0', true);
			}
			break;

		// DG container 조회 팝업...
		case "dg_container_seq":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var cnt = 0;
				for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
					if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
						cnt++;
					}
				}
				if (cnt == "0") {
					ComShowMessage(ComGetMsg("BKG00624"));
				} else {
					var bkgNo = document.getElementById("bkg_no").value;
					var cntrNo = document.getElementById("temp_cntr_no").value;
					var cntrTpszCd = document.getElementById("cntr_tpsz_cd").value;
					var url = "ESM_BKG_0754.do?modalFlg=Y&bkgNo=" + bkgNo + "&cntrNo=" + cntrNo + "&cntrTpszCd=" + cntrTpszCd;
					ComOpenWindowCenter(url, "ESM_BKG_0754", 805, 330, true);
					//ComOpenWindowCenter("ESM_BKG_0754.do?bkgNo="+bkgNo+"&cntrNo="+cntrNo+"&cntrTpszCd="+cntrTpszCd, "ESM_BKG_0754", 805, 310, true);
				}
			}
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

// comodity 팝업에서 선택한 데이터 값 셋팅 function....
function getCOM_CMDT_POPUP(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	formObject.cmdt_cd.value = colArray[3];
	sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cmdt_cd") = colArray[3];
	formObject.cmdt_nm.value = colArray[4];
	sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cmdt_nm") = colArray[4];
	sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "modifyaproflg") = "Y";
}

// bkg_split_no의 값 선택시 bkg_no에 셋팅하는  function...
function bkgSplitNoList(split_list) {
	document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
	layList.style.display = "none";
}

// package type code 팝업에서 선택한 데이터 값 셋팅 function...
function callbackPckTp(returnVal) {
	document.form.frm_pck_tp_cd.value = returnVal[0][3];
	sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "pck_tp_cd") = returnVal[0][3];
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

//add 버튼 클릭시 라인 추가
function checkAdd() {
	//awk_cgo_seq의 max값을 구한다.
	var seqVal = Number(sheetObjects[1].CellValue(1, "awk_cgo_seq"));
	for ( var k = 1; k <= sheetObjects[1].RowCount; k++) {
		if (seqVal < Number(sheetObjects[1].CellValue(k, "awk_cgo_seq"))) {
			seqVal = sheetObjects[1].CellValue(k, "awk_cgo_seq");
		}
	}

	//bkg_no의 값이  빈 값이 아니면 row를 추가한다.
	if (document.getElementById("bkg_no").value != "") {
		document.getElementById("temp_cntr_no").value = "";
		var Row = sheetObjects[1].DataInsert(-1);

		//row 추가후 각각의 항목에 default값을 셋팅한다.
		sheetObjects[1].CellValue2(Row, "cntr_no") = "";
		sheetObjects[1].CellValue2(Row, "bkg_no") = document.getElementById("bkg_no").value;

		//max값으로 구한 seqVal에 1을 더하여 값을 셋팅한다.
		sheetObjects[1].CellValue2(Row, "awk_cgo_seq") = Number(seqVal) + 1;

		sheetObjects[1].CellValue2(Row, "cntr_vol_qty") = "1";
		sheetObjects[1].CellValue2(Row, "in_ga_flg") = "Y";
		sheetObjects[1].CellValue2(Row, "rcv_term_cd") = sheetObjects[2].CellValue(1, "rcv_term_cd");
		sheetObjects[1].CellValue2(Row, "de_term_cd") = sheetObjects[2].CellValue(1, "de_term_cd");
		sheetObjects[1].CellValue2(Row, "cmdt_cd") = sheetObjects[2].CellValue(1, "cmdt_cd");
		sheetObjects[1].CellValue2(Row, "cmdt_nm") = sheetObjects[2].CellValue(1, "cmdt_nm");

		//html과 ibsheet와 synch를 맞춘다.
		//htmlSheetSync();

		//ibsheet의 cntr_no항목의 selectbox 값을 셋팅한다.
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

		//추가한 row에 selectbox 값을 셋팅한 부분...
		var checkCntr = sheetObjects[4].FindText("DelChk", "0", 0, 2);
		if (checkCntr > 0) {
			sheetObjects[1].CellComboItem(Row, "cntr_no", " |" + cntr_name, " |" + cntr_val);
		} else {
			sheetObjects[1].CellComboItem(Row, "cntr_no", " ", " ");
		}
	}

	//모든 값의 셋팅이 끝난후 ibsheet 시퀀스 값을 다시 넘버링한다.
	var cnt = 0;
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
			cnt++;
			sheetObjects[1].CellValue(i, "seq") = cnt;
		}
	}
	htmlSheetSync();
}

//ibsheet의 체크박스 체크후 del버튼 클릭시...
function deleteRows() {
	for ( var k = 1; k <= sheetObjects[1].RowCount; k++) {
		//체크한 항목이 있을 경우...
		if (sheetObjects[1].CellValue(k, "DelChk") == "1") {
			//Appr. 항목의 값이 P, R, Y, N일 경우 삭제작업을 중단한다. 
			if (sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "P" || sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "R" || sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "Y" || sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "N") {
				ComShowMessage(ComGetMsg("BKG00525"));
				return;
			}
		}
	}

	var find_row = 0;
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		//체크된 항목이 있을 경우...
		if (sheetObjects[1].CellValue(i, "DelChk") == "1") {
			//삭제될 항목의 cntr_no 값을 temp_cntr_no에 담아서...
			var temp_cntr_no = sheetObjects[1].CellValue(i, "cntr_no");
			//sheetObjects[4]의 cntr_no값이 있는 row의 값을 구한다.
			var temp_find_row = sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);

			//temp_cntr_no값이 빈값이 아니면...
			if (temp_cntr_no != "") {
				//sheetObjects[4]의 cntr_no의  row를 구한 값(temp_find_row)으로 sheetObjects[4]의 체크를 푼다.
				sheetObjects[4].CellValue(temp_find_row, "DelChk") = "0";
			}

			// AWK_CGO_DIM Delete
			var temp_awk_cgo_seq = sheetObjects[1].CellValue(i, "awk_cgo_seq");

			for ( var k = sheetObjects[3].RowCount; k > 0; k--) {
				if (temp_awk_cgo_seq == sheetObjects[3].CellValue(k, "awk_cgo_seq")) {
					sheetObjects[3].RowDelete(k, false);
				}
			}
		}
	}
	
	//삭제하기 위해 체크된 row를 삭제한다.
	var drow = ComRowHideDelete(sheetObjects[1], "DelChk");

	//삭제된 항목들의 cntr_no값을 다시 구한다.
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
	var cntr_no = "";

	// 다시 구한 cntr_no값을 각 row의 cntr_no selectbox 값에 셋팅한다.
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		cntr_no = sheetObjects[1].CellValue(i, "cntr_no");
		sheetObjects[1].CellComboItem(i, "cntr_no", " |" + cntr_no + "|" + cntr_name, " |" + cntr_no + "|" + cntr_val);
		sheetObjects[1].CellValue2(i, "cntr_no") = cntr_no;
		if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
			cnt++;
			sheetObjects[1].CellValue2(i, "seq") = cnt;
		}
	}

	//ibsheet rowcount가 삭제된 항목의 값을 제대로 구하지 못하므로 for문을 돌려서 실제 남아있는 row 수를 구한다.
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
			sheetObjects[1].SelectCell(i, 0, false);
			htmlSheetSync();
			return;
		} else {
			find_row++;
		}
	}
	// 실제 row가 0인 경우... html의 값을 모두 빈 값으로 셋팅한다.
	if (find_row == sheetObjects[1].RowCount) {
		document.getElementById("frm_pck_qty").innerText = "";
		document.getElementById("frm_grs_wgt").innerText = "";
		document.getElementById("frm_net_wgt").innerText = "";
		document.getElementById("temp_grs_wgt").value = "";
		document.getElementById("temp_net_wgt").value = "";
		document.getElementById("ttl_dim_len").value = "";
		document.getElementById("ttl_dim_wdt").value = "";
		document.getElementById("ttl_dim_hgt").value = "";
		document.getElementById("ovr_fwrd_len").value = "";
		document.getElementById("ovr_bkwd_len").value = "";
		document.getElementById("ovr_lf_len").value = "";
		document.getElementById("ovr_rt_len").value = "";
		document.getElementById("ovr_hgt").value = "";
		document.getElementById("ovr_void_slt_qty").value = "";
		document.getElementById("rcv_term_cd").value = "";
		document.getElementById("de_term_cd").value = "";
		document.getElementById("wgt_ut_cd1").value = "";
		document.getElementById("wgt_ut_cd2").value = "";
		document.getElementById("crn_pst_sts_cd").value = "";
		document.getElementById("pst_lck_pin_flg").value = "";
		document.getElementById("temp_cntr_no").value = "";
		document.getElementById("cntr_tpsz_cd").value = "";
		document.getElementById("frm_seq").value = "";
		document.getElementById("frm_pck_tp_cd").value = "";
		document.getElementById("cmdt_cd").value = "";
		document.getElementById("cmdt_nm").value = "";
		document.getElementById("aply_no").value = "";
	}
}

// copy 버튼 클릭시...
function copyRowPopup() {
	var url = "ESM_BKG_0720.do";
	ComOpenWindowCenter(url, "ESM_BKG_0720", 320, 180, true);
}

// ESM_BKG_0720.js에서 opener로 function을 호출한다.
function copyCnt(copyCnt) {
	for (i = 1; i <= copyCnt; i++) {
		var seqVal = Number(sheetObjects[1].CellValue(1, "awk_cgo_seq"));
		for ( var k = 1; k <= sheetObjects[1].RowCount; k++) {
			if (seqVal < Number(sheetObjects[1].CellValue(k, "awk_cgo_seq"))) {
				seqVal = sheetObjects[1].CellValue(k, "awk_cgo_seq");
			}
		}

		var selRow = sheetObjects[1].SelectRow;
		var Row = sheetObjects[1].DataInsert(-1);

		for ( var ic = 0; ic <= sheetObjects[1].LastCol; ic++) {
			if (sheetObjects[1].ColSaveName(ic) == "ibflag" || sheetObjects[1].ColSaveName(ic) == "seq")
				continue;
			sheetObjects[1].CellValue2(Row, ic) = sheetObjects[1].CellValue(selRow, ic);
		}

		sheetObjects[1].CellValue2(Row, "cntr_no") = "";
		sheetObjects[1].CellValue2(Row, "awk_cgo_seq") = Number(seqVal) + 1;
		sheetObjects[1].CellValue2(Row, "spcl_cgo_apro_cd") = "";
		sheetObjects[1].CellValue2(Row, "DelChk") = "0";

		//copy한 항목의 cntr_no 값의 selectbox 값을 셋팅한다.
		var cntr_name = "";
		var cntr_val = "";
		var temp_cntr_no = sheetObjects[1].CellValue(Row, "cntr_no");
		var temp_find_row = sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);

		for ( var j = 1; j <= sheetObjects[4].RowCount; j++) {
			if (sheetObjects[4].CellValue(j, "DelChk") == "0") {
				cntr_name += sheetObjects[4].CellValue(j, "name") + "|";
				cntr_val += sheetObjects[4].CellValue(j, "val") + "|";
			}
		}

		cntr_val = cntr_val.substr(0, cntr_val.length - 1);
		cntr_name = cntr_name.substr(0, cntr_name.length - 1);
		sheetObjects[1].CellComboItem(Row, "cntr_no", " |" + cntr_name, " |" + cntr_val);
	}

	var rowCnt = 0;
	for ( var i = 2; i <= sheetObjects[1].RowCount + 1; i++) {
		if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
			rowCnt++;
			sheetObjects[1].CellValue2(i, "seq") = rowCnt;
		}
	}
}


function obj_click() {
	var row = sheetObjects[1].SelectRow;
	switch (event.srcElement.name) {
		case "und_deck_top_flg":
			if (document.getElementById("und_deck_top_flg").checked == true) {	
				sheetObjects[1].CellValue2(row, "und_deck_top_flg") = "Y";
			} else {	
				sheetObjects[1].CellValue2(row, "und_deck_top_flg") = "N";	
				if (document.getElementById("ovr_hgt").value > 0 && document.getElementById("ovr_void_slt_qty").value == "0") {
					ComAlertFocus(document.getElementById("ovr_void_slt_qty"), ComGetMsg("BKG00494"));
					voidSpaceValue(sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), sheetObjects[1].SelectRow, 1);
					if (document.getElementById("ovr_void_slt_qty").value == "0") {
						document.getElementById("inGauge").checked = true;
						sheetObjects[1].CellValue2(row, "in_ga_flg") = "Y";
					} else {
						document.getElementById("inGauge").checked = false;
						sheetObjects[1].CellValue2(row, "in_ga_flg") = "N";
					}
				}
			}
			break;
	
		case "frm_net_wgt":	
			if (sheetObjects[1].CellValue(row, "net_wgt") == "0") {	
				document.getElementById("frm_net_wgt").value = "";	
			}
			break;
	
		case "frm_grs_wgt":	
			if (sheetObjects[1].CellValue(row, "grs_wgt") == "0") {	
				document.getElementById("frm_grs_wgt").value = "";	
			}
			break;
	
		case "ttl_dim_len":	
			if (sheetObjects[1].CellValue(row, "ttl_dim_len") == "0") {	
				document.getElementById("ttl_dim_len").value = "";	
			}
			break;
	
		case "ttl_dim_wdt":	
			if (sheetObjects[1].CellValue(row, "ttl_dim_wdt") == "0") {	
				document.getElementById("ttl_dim_wdt").value = "";	
			}
			break;
	
		case "ttl_dim_hgt":	
			if (sheetObjects[1].CellValue(row, "ttl_dim_hgt") == "0") {	
				document.getElementById("ttl_dim_hgt").value = "";	
			}
			break;
	
		case "ovr_fwrd_len":	
			if (sheetObjects[1].CellValue(row, "ovr_fwrd_len") == "0") {	
				document.getElementById("ovr_fwrd_len").value = "";	
			}
			break;
	
		case "ovr_bkwd_len":	
			if (sheetObjects[1].CellValue(row, "ovr_bkwd_len") == "0") {	
				document.getElementById("ovr_bkwd_len").value = "";	
			}
			break;
	
		case "ovr_lf_len":	
			if (sheetObjects[1].CellValue(row, "ovr_lf_len") == "0") {	
				document.getElementById("ovr_lf_len").value = "";	
			}
			break;
	
		case "ovr_rt_len":	
			if (sheetObjects[1].CellValue(row, "ovr_rt_len") == "0") {	
				document.getElementById("ovr_rt_len").value = "";	
			}
			break;
	
		case "ovr_hgt":	
			if (sheetObjects[1].CellValue(row, "ovr_hgt") == "0") {
				document.getElementById("ovr_hgt").value = "";	
			}
			break;	
		case "crn_pst_sts_cd":
			//A5 타입일 때, Coner Post Status에서 5 feet Extension은 고르지 못하도록 처리
			if(sheetObjects[1].CellValue(Row, "cntr_tpsz_cd") == 'A5'){
				document.getElementById("feet_5").disabled = true;
				document.getElementById("feet_5").className = "input2"
			} else {
				document.getElementById("feet_5").disabled = false;
				document.getElementById("feet_5").className = ""
			}
			break;
	}
}

function obj_deactivate() {
	var row = sheetObjects[1].SelectRow;
	switch (event.srcElement.name) {
		//cmdt_cd 값을 입력후, 마우스가 다른 곳을 클릭시, cmdt_nm에 값을 셋팅한다.
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
					sheetObjects[1].CellValue2(row, "cmdt_cd") = cmdt_cd;
				}
				if (cmdtFlg == "") {
					doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
				}
			}
	
		case "ovr_lf_len":
			if (document.getElementById("ovr_lf_len").value == "") {
				document.getElementById("ovr_lf_len").value = "0";
			}else{
				document.getElementById("ovr_lf_len").value = Math.round(parseFloat(document.getElementById("ovr_lf_len").value)) ;
			}			
			break;
	
		case "ovr_rt_len":
			if (document.getElementById("ovr_rt_len").value == "") {
				document.getElementById("ovr_rt_len").value = "0";
			}else{
				document.getElementById("ovr_rt_len").value = Math.round(parseFloat(document.getElementById("ovr_rt_len").value)) ;
			}	
			break;
	
		case "ovr_fwrd_len":
			if (document.getElementById("ovr_fwrd_len").value == "") {
				document.getElementById("ovr_fwrd_len").value = "0";
			}else{
				document.getElementById("ovr_fwrd_len").value = Math.round(parseFloat(document.getElementById("ovr_fwrd_len").value)) ;
			}
			break;
	
		case "ovr_bkwd_len":
			if (document.getElementById("ovr_bkwd_len").value == "") {
				document.getElementById("ovr_bkwd_len").value = "0";
			}else{
				document.getElementById("ovr_bkwd_len").value = Math.round(parseFloat(document.getElementById("ovr_bkwd_len").value)) ;
			}
			break;
	
		case "ovr_hgt":
			if (document.getElementById("ovr_hgt").value == "") {
				document.getElementById("ovr_hgt").value = "0";
			}else{
				document.getElementById("ovr_hgt").value = Math.round(parseFloat(document.getElementById("ovr_hgt").value)) ;
			}			
			break;
	}
}

function obj_blur() {
	var row = sheetObjects[1].SelectRow;
	switch (event.srcElement.name) {
		case "frm_pck_qty":
			if (document.getElementById("bkg_no").value != "") {
				document.getElementById("frm_pck_qty").value = sheetObjects[1].CellText(row, "pck_qty");
			}
			break;
	
		case "frm_net_wgt":
			if (document.getElementById("bkg_no").value != "") {
				document.getElementById("frm_net_wgt").value = sheetObjects[1].CellText(row, "net_wgt");
				if (Number(document.getElementById("frm_grs_wgt").value.replaceStr(",")) < Number(document.getElementById("frm_net_wgt").value.replaceStr(","))) {
					ComAlertFocus(document.getElementById("frm_net_wgt"), ComGetMsg("BKG00491"));
					document.getElementById("frm_net_wgt").value = document.getElementById("temp_net_wgt").value;
					sheetObjects[1].CellValue(row, "net_wgt") = document.getElementById("temp_net_wgt").value;
				} else {
					document.getElementById("temp_net_wgt").value = sheetObjects[1].CellText(row, "net_wgt");
				}
				sheetObjects[1].CellValue2(row, "modifyaproflg") = "Y";
			}
			break;
	
		case "frm_grs_wgt":
			if (document.getElementById("bkg_no").value != "") {
				document.getElementById("frm_grs_wgt").value = sheetObjects[1].CellText(row, "grs_wgt");
				if (Number(document.getElementById("frm_grs_wgt").value.replaceStr(",")) < Number(document.getElementById("frm_net_wgt").value.replaceStr(","))) {
					ComAlertFocus(document.getElementById("frm_grs_wgt"), ComGetMsg("BKG00491"));
					document.getElementById("frm_grs_wgt").value = document.getElementById("temp_grs_wgt").value;
					sheetObjects[1].CellValue(row, "grs_wgt") = document.getElementById("temp_grs_wgt").value;
				} else {
					document.getElementById("temp_grs_wgt").value = sheetObjects[1].CellText(row, "grs_wgt")
				}
				sheetObjects[1].CellValue2(row, "modifyaproflg") = "Y";
			}
			break;	
	}
}

function obj_keyup() {
	pendingSaveFlg = "N"; //Approval이 Pending 상태일 때는 Container No를 제외한 나머지 모든 값은 신규 또는 수정이 되지 않게 상태 확인하는 Flag
	
	var row = sheetObjects[1].SelectRow;
	switch (event.srcElement.name) {
		case "frm_pck_qty":
			sheetObjects[1].CellValue2(row, "pck_qty") = document.getElementById("frm_pck_qty").value;
			break;
	
		case "frm_pck_tp_cd":
			sheetObjects[1].CellValue2(row, "pck_tp_cd") = document.getElementById("frm_pck_tp_cd").value;
			break;
	
		case "frm_grs_wgt":
			if (document.getElementById("frm_grs_wgt").value.length > 7) {
				if (document.getElementById("frm_grs_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("frm_grs_wgt").value = document.getElementById("frm_grs_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[1].CellValue2(row, "grs_wgt") = document.getElementById("frm_grs_wgt").value;
			break;
	
		case "frm_net_wgt":
			if (document.getElementById("frm_net_wgt").value.length > 7) {
				if (document.getElementById("frm_net_wgt").value.indexOf(".") > -1) {
				} else {
					document.getElementById("frm_net_wgt").value = document.getElementById("frm_net_wgt").value.substr(0, 7);
				}
			}
			sheetObjects[1].CellValue2(row, "net_wgt") = document.getElementById("frm_net_wgt").value;
			break;
	
		case "cmdt_cd":
			sheetObjects[1].CellValue2(row, "cmdt_cd") = document.getElementById("cmdt_cd").value;
			break;
	
		case "cmdt_nm":
			sheetObjects[1].CellValue2(row, "cmdt_nm") = document.getElementById("cmdt_nm").value;
			break;
	
		case "frm_xtd_ovr_qty":
			sheetObjects[1].CellValue2(row, "xtd_ovr_qty") = document.getElementById("frm_xtd_ovr_qty").value;
			break;
	
		case "frm_grav_ctr_desc":
			sheetObjects[1].CellValue2(row, "grav_ctr_desc") = document.getElementById("frm_grav_ctr_desc").value;
			break;
	
		case "frm_stwg_rqst_desc":
			sheetObjects[1].CellValue2(row, "stwg_rqst_desc") = document.getElementById("frm_stwg_rqst_desc").value;
			break;
	
		case "ttl_dim_len":
			sheetObjects[1].CellValue2(row, "ttl_dim_len") = document.getElementById("ttl_dim_len").value;
			break;
	
		case "ttl_dim_wdt":
			sheetObjects[1].CellValue2(row, "ttl_dim_wdt") = document.getElementById("ttl_dim_wdt").value;
			break;
	
		case "ttl_dim_hgt":
			sheetObjects[1].CellValue2(row, "ttl_dim_hgt") = document.getElementById("ttl_dim_hgt").value;
			break;	
	
		case "ovr_fwrd_len":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_fwrd_len").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_fwrd_len").value	= s_value;
			sheetObjects[1].CellValue2(row, "ovr_fwrd_len") = s_value;			
			break;
	
		case "ovr_bkwd_len":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_bkwd_len").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_bkwd_len").value	= s_value;
			sheetObjects[1].CellValue2(row, "ovr_bkwd_len") = s_value;		
			break;
	
		case "ovr_lf_len":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_lf_len").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_lf_len").value		= s_value;
			sheetObjects[1].CellValue2(row, "ovr_lf_len") 	= s_value;			
			break;
	
		case "ovr_rt_len":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_rt_len").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_rt_len").value		= s_value;
			sheetObjects[1].CellValue2(row, "ovr_rt_len") 	= s_value;
			break;
			
		case "ovr_hgt":
			var s_value =Math.round(parseFloat(document.getElementById("ovr_hgt").value)) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_hgt").value= s_value;
			sheetObjects[1].CellValue2(row, "ovr_hgt") = s_value;		
			break;
	
		case "ovr_void_slt_qty":
			var s_value =parseFloat(document.getElementById("ovr_void_slt_qty").value) ;
			//if (!ComIsNumber(s_value)) return;
			//document.getElementById("ovr_void_slt_qty").value= s_value;
			sheetObjects[1].CellValue2(row, "ovr_void_slt_qty") = s_value;	
			break;
	
		case "frm_cntr_cgo_seq":
			sheetObjects[1].CellValue2(row, "cntr_cgo_seq") = document.getElementById("frm_cntr_cgo_seq").value;
			sheetObjects[1].CellValue2(row, "awk_dcgo_seq") = document.getElementById("frm_cntr_cgo_seq").value;
			break;
	}
}

function obj_keypress() {
	switch (event.srcElement.name) {
		case "frm_pck_qty":
			ComKeyOnlyNumber(event.srcElement);
			break;
	
		case "frm_grs_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "frm_net_wgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "cmdt_cd":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "ttl_dim_len":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "ttl_dim_wdt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "ttl_dim_hgt":
			ComKeyOnlyNumber(event.srcElement, "-.");
			break;
	
		case "ovr_fwrd_len":
			ComKeyOnlyNumber(event.srcElement, "-."); 	
			break;
	
		case "ovr_bkwd_len":
			ComKeyOnlyNumber(event.srcElement, "-.");			
			break;
	
		case "ovr_lf_len":
			ComKeyOnlyNumber(event.srcElement, "-.");			
			break;
	
		case "ovr_rt_len":
			ComKeyOnlyNumber(event.srcElement, "-.");		
			break;
	
		case "ovr_hgt":
			ComKeyOnlyNumber(event.srcElement, "-.");			
			break;
	
		case "ovr_void_slt_qty":
			ComKeyOnlyNumber(event.srcElement, "-.");	
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
	var row = sheetObjects[1].SelectRow;
	switch (event.srcElement.name) {
		case "wgt_ut_cd1":
			sheetObjects[1].CellValue2(row, "wgt_ut_cd") = document.getElementById("wgt_ut_cd1").value;
			document.getElementById("wgt_ut_cd2").value = document.getElementById("wgt_ut_cd1").value;
			break;
	
		case "crn_pst_sts_cd":
			sheetObjects[1].CellValue2(row, "crn_pst_sts_cd") = document.getElementById("crn_pst_sts_cd").value;
			if (sheetObjects[1].CellValue(row, "crn_pst_sts_cd") != "E" && sheetObjects[1].CellValue(row, "crn_pst_sts_cd") != "F" && sheetObjects[1].CellValue(row, "crn_pst_sts_cd") != "") {
				document.getElementById("frm_xtd_ovr_qty").disabled = false;
			} else {
				document.getElementById("frm_xtd_ovr_qty").disabled = true;
			}
			break;
	
		case "pst_lck_pin_flg":
			if (document.getElementById("pst_lck_pin_flg").value == "") {
				ComAlertFocus(document.getElementById("pst_lck_pin_flg"), ComGetMsg("BKG08025"));
				document.getElementById("pst_lck_pin_flg").value = sheetObjects[1].CellValue(row, "pst_lck_pin_flg");
			} else {
				sheetObjects[1].CellValue2(row, "pst_lck_pin_flg") = document.getElementById("pst_lck_pin_flg").value;
			}
			break;
	
		case "rcv_term_cd":
			sheetObjects[1].CellValue2(row, "rcv_term_cd") = document.getElementById("rcv_term_cd").value;
			break;
	
		case "de_term_cd":
			sheetObjects[1].CellValue2(row, "de_term_cd") = document.getElementById("de_term_cd").value;
			break;
	
		case "ttl_dim_len":	
			overDimensionSettingLength(document.getElementById("ttl_dim_len").value, sheetObjects[1].SelectRow, 1, 5);
			break;
	
		case "ttl_dim_wdt":	
			overDimensionSettingWidth(document.getElementById("ttl_dim_wdt").value, sheetObjects[1].SelectRow, 1, 5);
			break;
	
		case "ttl_dim_hgt":
			overDimensionSettingHeight(document.getElementById("ttl_dim_hgt").value, sheetObjects[1].SelectRow, 1, 5);
			break;
	
		case "ovr_lf_len":
			voidSpaceValue(sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), sheetObjects[1].SelectRow, 1);
			break;
	
		case "ovr_rt_len":
			voidSpaceValue(sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), sheetObjects[1].SelectRow, 1);

			break;
	
		case "ovr_hgt":
			voidSpaceValue(sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), sheetObjects[1].SelectRow, 1);
			cornerPostStatus();
			break;
	
		case "ovr_void_slt_qty":
			if (document.getElementById("ovr_hgt").value > 0 && document.getElementById("ovr_void_slt_qty").value == "0" && document.getElementById("und_deck_top_flg").checked == false) {
				ComAlertFocus(document.getElementById("ovr_void_slt_qty"), ComGetMsg("BKG00494"));
				document.getElementById("ovr_void_slt_qty").value = sheetObjects[1].CellValue(row, "temp_ovr_void_qty");
			} else {
				sheetObjects[1].CellValue(row, "temp_ovr_void_qty") = document.getElementById("ovr_void_slt_qty").value;
			}
			if (document.getElementById("ovr_void_slt_qty").value == "0") {
				document.getElementById("inGauge").checked = true;
				sheetObjects[1].CellValue2(row, "in_ga_flg") = "Y";
			} else {
				document.getElementById("inGauge").checked = false;
				sheetObjects[1].CellValue2(row, "in_ga_flg") = "N";
			}
			sheetObjects[1].CellValue(row, "modifyaproflg") = "Y";
			break;
	
		case "frm_stwg_rqst_desc":
			sheetObjects[1].CellValue(row, "modifyaproflg") = "Y";
			break;
	
		case "bkg_no":
			document.getElementById("bkg_no").value = (document.getElementById("bkg_no").value).toUpperCase();
			break;
	
		case "bl_no":
			document.getElementById("bl_no").value = (document.getElementById("bl_no").value).toUpperCase();
			break;
	
		case "frm_pck_tp_cd":
			document.getElementById("frm_pck_tp_cd").value = (document.getElementById("frm_pck_tp_cd").value).toUpperCase();
			sheetObjects[1].CellValue2(row, "pck_tp_cd") = document.getElementById("frm_pck_tp_cd").value;
			break;
			
		case "awk_cgo_rqst_grp_eml1":
			sheetObjects[1].CellValue2(row, "awk_cgo_rqst_grp_eml1") = document.getElementById("awk_cgo_rqst_grp_eml1").value;
			break;
		case "awk_cgo_rqst_grp_eml2":
			sheetObjects[1].CellValue2(row, "awk_cgo_rqst_grp_eml2") = document.getElementById("awk_cgo_rqst_grp_eml2").value;
			break;
			
	}
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
				style.height = 102;
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
				InitColumnInfo(3, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false, false)
				var HeadTitle1 = "TP/SZ|BKG Q'ty|AK Q'ty";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 70, daRight, true, "op_cntr_qty", false, "", dfFloat, 2, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "awk_cgo_qty", false, "", dfFloat, 2, false, true);
				CountPosition = 0;
			}
			break;
	
		case 2: //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = 125;
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
				InitRowInfo(1, 1, 4, 100);
				
			
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false)
//				var HeadTitle1 = "Sel.|Seq||Container No.|TS|Vol.|Appr.||bkg_no|rcv_term_cd|de_term_cd|pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|net_wgt|cmdt_cd|cmdt_nm|awk_dcgo_seq" + "|ttl_dim_len|ttl_dim_wdt|ttl_dim_hgt|ovr_fwrd_len|ovr_bkwd_len|ovr_lf_len|ovr_rt_len|ovr_hgt|in_ga_flg|ovr_void_slt_qty|crn_pst_sts_cd|xtd_ovr_qty|pst_lck_pin_flg|grav_ctr_desc"
//						+ "|stwg_rqst_desc|diff_rmk|modifyAproFlg|cntr_cgo_seq|por_cd|del_cd|apro_cd|und_deck_top_flg|aply_no|eq_tpsz|awk_cgo_rqst_grp_eml1|awk_cgo_rqst_grp_eml2";
				var HeadTitle1 = "Sel.|Seq|ibflag|Container No.|TS|Vol.|Appr.|awk_cgo_seq|bkg_no|rcv_term_cd|de_term_cd|pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|net_wgt|cmdt_cd|cmdt_nm|awk_dcgo_seq" + "|ttl_dim_len|ttl_dim_wdt|ttl_dim_hgt|ovr_fwrd_len|ovr_bkwd_len|ovr_lf_len|ovr_rt_len|ovr_hgt|in_ga_flg|ovr_void_slt_qty|crn_pst_sts_cd|xtd_ovr_qty|pst_lck_pin_flg|grav_ctr_desc"
				+ "|stwg_rqst_desc|diff_rmk|modifyAproFlg|temp_ovr_void_qty|cntr_cgo_seq|por_cd|del_cd|apro_cd|und_deck_top_flg|aply_no|eq_tpsz|awk_cgo_rqst_grp_eml1|awk_cgo_rqst_grp_eml2|bkg_cntr_wgt|over_wgt_flg";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "DelChk");
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHiddenStatus, 20, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, "cntr_no", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, true, true, 2);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_vol_qty", false, "", dfFloat, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "spcl_cgo_apro_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "awk_cgo_seq");
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bkg_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "rcv_term_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "de_term_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "pck_qty", false, "", dfNullInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "pck_tp_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "grs_wgt", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "wgt_ut_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "net_wgt", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cmdt_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cmdt_nm", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "awk_dcgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ttl_dim_len", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ttl_dim_wdt", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ttl_dim_hgt", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ovr_fwrd_len", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ovr_bkwd_len", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ovr_lf_len", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ovr_rt_len", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ovr_hgt", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "in_ga_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "ovr_void_slt_qty", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "crn_pst_sts_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "xtd_ovr_qty", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "pst_lck_pin_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "grav_ctr_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "stwg_rqst_desc", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "diff_rmk", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "modifyaproflg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "temp_ovr_void_qty", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "cntr_cgo_seq", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "por_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "del_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "apro_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "und_deck_top_flg", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "aply_no", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "eq_tpsz", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "awk_cgo_rqst_grp_eml1", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, "awk_cgo_rqst_grp_eml2", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "bkg_cntr_wgt", false, "", dfFloat, 3, false, true);
				InitDataProperty(0, cnt++, dtHidden, 30, daCenter, false, "over_wgt_flg", false, "", dfNone, 0, false, true);
				CountPosition = 0;
			}
			break;
	
		case 3: //sheet1 init
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
				InitColumnInfo(28, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false, false)
				var HeadTitle1 = "bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|rcv_term_cd|de_term_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|pck_qty|pck_tp_cd|grs_wgt|grs_ut_cd|act_wgt|wgt_ut_cd|vessel_nm|pol_nm|pod_nm|stwg_cd|xter_si_ref_no";
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
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "corr_no", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "bdr_flg", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pck_qty", false, "", dfInteger, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pck_tp_cd", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "grs_wgt", false, "", dfFloat, 3, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "wgt_ut_cd", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "cmdt_cd", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "cmdt_nm", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "vsl_pre_pst_cd", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "act_wgt", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "wgt_ut_cd", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "img_flg", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "vessel_nm", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pol_nm", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pod_nm", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "stwg_cd", false, "", dfNone, 2, true, true);
				InitDataProperty(0, cnt++, dtData, 40, daRight, false, "xter_si_ref_no", false, "", dfNone, 2, true, true);
				
				CountPosition = 0;
			}
			break;
	
		//dimension 팝업을 클릭할 경우... 항목에 맞는 sheet값을 구하여 팝업으로 넘긴다.
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
				MergeSheet = msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				var HeadTitle1 = "|||Length(CM)|Width(CM)|Height(CM)|Weight|awk_cgo_seq|bkg_no|dim_seq";
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false, false);
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, false, "DelChk");
				InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq");
				InitDataProperty(0, cnt++, dtStatus, 30, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtData, 105, daCenter, true, "dim_len", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "dim_wdt", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dim_hgt", false, "", dfNone, 0, true, true);
				InitDataProperty(0,	cnt++, dtData, 100,	daCenter, true,	"indiv_pck_wgt", false, "",	dfFloat, 3, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "awk_cgo_seq", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bkg_no", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "dim_seq", false, "", dfNone, 0, true, true);
			}
			break;

		//cntr_no의 select 값을 셋팅하기 위한 hidden sheet... 체크되지 않은 row의 값을 구하여 cntr_no에 값을 셋팅한다.
		case 5: //sheet5 init
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
				var HeadTitle1 = "|value|name|TpszCd|Vol.|rcvTerm|deTerm|cntrWgt";
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);
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
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "rcv_term_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "de_term_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "cntr_wgt", false, "", dfNone, 0, true, true);
			}
			break;

		//Awkward Cgo Criteria 값	
		case 6: //sheet6 init
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
				var HeadTitle1 = "|EQ Type/Size|Length|Width|Height|Length|Width|Height|Tare Weight";
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(9, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false, false);
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, false, "DelChk");
				InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "attr_ctnt1", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt2", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt3", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt4", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt5", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt6", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt7", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "attr_ctnt8", false, "", dfNone, 0, true, true);
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
				sheetObjects[0].WaitImageVisible = true;
			formObj.f_cmd.value = SEARCH;
	
			var resultXml = sheetObj.GetSearchXml("ESM_BKG_0055GS.do", FormQueryString(formObj));	
			var arrXml = resultXml.split("|$$|");

			if (arrXml.length == 6) {
				var etcXml = arrXml[0];
	
				if (ComGetEtcData(etcXml, "rqst_dt") == "null" || ComGetEtcData(etcXml, "rqst_dt") == "") {
					document.getElementById("rqst_dt").innerText = "";
					document.getElementById("rqst_gdt").innerText = "";
					document.getElementById("rqst_usr_id").innerText = "";
				} else {
					document.getElementById("rqst_dt").innerText = ComGetEtcData(etcXml, "rqst_dt");
					document.getElementById("rqst_gdt").innerText = ComGetEtcData(etcXml, "rqst_gdt");
					document.getElementById("rqst_usr_id").innerText = ComGetEtcData(etcXml, "rqst_usr_id");
				}
				//ibsheet combo 부분... 								
				if (arrXml[3].indexOf("TOTAL='0'") < 1) {
					var arrCombo = ComXml2ComboString(arrXml[3], "val", "name");
					sheetObjects[1].InitDataCombo(0, "cntr_no", arrCombo[0], arrCombo[1], "");
				}
	
				//조회된 xml 값을 각각의 sheet에 셋팅한다.
				sheetObjects[0].LoadSearchXml(arrXml[1], false);
				sheetObjects[1].LoadSearchXml(arrXml[0], false);
				sheetObjects[2].LoadSearchXml(arrXml[2], false);
				sheetObjects[3].LoadSearchXml(arrXml[4], false);
				sheetObjects[4].LoadSearchXml(arrXml[3], false);
				sheetObjects[5].LoadSearchXml(arrXml[5], false);
	
				//de_term_cd이 M일 경우 readOnly
				if (sheetObjects[2].CellValue(1, "de_term_cd") == "M") {
					//document.getElementById("de_term_cd").disabled = false; 								   							   
				} else {
					//document.getElementById("de_term_cd").disabled = true;
				}
	
				//rcv_term_cd이 M일 경우 readOnly
				if (sheetObjects[2].CellValue(1, "rcv_term_cd") == "M") {
					document.getElementById("rcv_term_cd").disabled = false;
				} else {
					document.getElementById("rcv_term_cd").disabled = true;
				}
	
				for ( var i = 1; i <= sheetObjects[3].RowCount; i++) {
					sheetObjects[3].CellValue(i, "ibflag") = "I";
				}
	
				if (document.getElementById("bkg_no").value == "") {
					document.getElementById("bkg_no").value = sheetObjects[1].CellValue(1, "bkg_no");
				}
				document.getElementById("bl_no").value = sheetObjects[2].CellValue(1, "bl_no");
				document.getElementById("tvvd").innerText = sheetObjects[2].CellValue(1, "vsl_cd");
				document.getElementById("pol_cd").innerText = sheetObjects[2].CellValue(1, "pol_cd");
				document.getElementById("pol_nod_cd").innerText = sheetObjects[2].CellValue(1, "pol_nod_cd");
				document.getElementById("pod_cd").innerText = sheetObjects[2].CellValue(1, "pod_cd");
				document.getElementById("pod_nod_cd").innerText = sheetObjects[2].CellValue(1, "pod_nod_cd");
				document.getElementById("package_sum").innerText = sheetObjects[2].CellValue(1, "pck_qty");
				document.getElementById("pck_tp_cd").innerText = sheetObjects[2].CellValue(1, "pck_tp_cd");
				document.getElementById("weight_sum").innerText = sheetObjects[2].CellText(1, "grs_wgt");
				document.getElementById("wgt_ut_cd").innerText = sheetObjects[2].CellValue(1, "wgt_ut_cd");
				document.getElementById("vessel_nm").value = sheetObjects[2].CellValue(1, "vessel_nm");
				document.getElementById("stwg_cd").value = sheetObjects[2].CellValue(1, "stwg_cd");

				document.getElementById("awk_cgo_rqst_grp_eml1").value = sheetObjects[1].CellValue(1, "awk_cgo_rqst_grp_eml1");
				document.getElementById("awk_cgo_rqst_grp_eml2").value = sheetObjects[1].CellValue(1, "awk_cgo_rqst_grp_eml2");

				var overWgtCnt = 0;
				
				for ( var j = 1; j <= sheetObjects[1].RowCount; j++) {
					//조회된  cntr_no의 값을 sheetObjects[4]에서 체크함.
					if (sheetObjects[1].CellValue(j, "cntr_no") != "") {
						var cntr_no = sheetObjects[1].CellValue(j, "cntr_no");
						var find_row = sheetObjects[4].FindText("name", cntr_no, 0, 2);
						sheetObjects[4].CellValue(find_row, "DelChk") = "1";
					}
	
					//appr.이 N일 경우 굵고 빨간색으로 변경...
					if (sheetObjects[1].CellValue(j, "spcl_cgo_apro_cd") == "N") {
						sheetObjects[1].CellFontColor(j, "spcl_cgo_apro_cd") = sheetObjects[1].RgbColor(255, 0, 0);
						sheetObjects[1].CellFont("FontBold", j, "spcl_cgo_apro_cd") = true;
					}
					
					// 2017.09.29 iylee S/I 이후에만 체크 Booking Container내에 Container Weight 와 Awkward Container Weight 가 20% 이상이면 빨간색 표시.
					var newCntrNo = sheetObjects[1].CellValue(j, "cntr_no");
					var newCntrGrsWgt = sheetObjects[1].CellValue(j, "grs_wgt");
					var oldCntrGrsWgt = sheetObjects[1].CellValue(j, "bkg_cntr_wgt");
					var overWgtFlg = checkGrsWgtOver(newCntrNo, newCntrGrsWgt, oldCntrGrsWgt);
					
					if(sheetObjects[2].CellValue(1, "xter_si_ref_no") != "" && overWgtFlg){
						sheetObjects[1].CellFontColor(j, "cntr_no") = sheetObjects[1].RgbColor(255,0,0);
						sheetObjects[1].CellValue2(j, "over_wgt_flg") = "1";
						document.getElementById("frm_grs_wgt").style.color = "red";
						overWgtCnt++;
					} else {
						sheetObjects[1].CellFontColor(j, "cntr_no") = sheetObjects[1].RgbColor(0,0,0);
						sheetObjects[1].CellValue2(j, "over_wgt_flg") = "0";
						document.getElementById("frm_grs_wgt").style.color = "black";						
					}
				}
				
		    	if(sheetObjects[2].CellValue(1, "xter_si_ref_no") != "" && overWgtCnt > 0){
		    		ComShowMessage(ComGetMsg("BKG95131"));
		    	}
	
				var cnt = 0;
	
				// appr.의 값에 따라서 auth_cd의 값을 셋팅한다. N일 경우 굵은 red로, 그 외에는 굵은 검은색...
				var tpszN = sheetObjects[1].FindText("spcl_cgo_apro_cd", "N", 0, 2);
				var tpszP = sheetObjects[1].FindText("spcl_cgo_apro_cd", "P", 0, 2);
				var tpszR = sheetObjects[1].FindText("spcl_cgo_apro_cd", "R", 0, 2);
				var tpszY = sheetObjects[1].FindText("spcl_cgo_apro_cd", "Y", 0, 2);
	
				if (tpszN > 0) {
					document.getElementById("auth_cd").value = "N";
					document.getElementById("auth_cd").style.color = "red";
					document.getElementById("auth_cd").style.fontWeight = "bold";
				} else if (tpszP > 0 && tpszN < 0) {
					document.getElementById("auth_cd").style.color = "black";
					document.getElementById("auth_cd").value = "P";
					document.getElementById("auth_cd").style.fontWeight = "bold";
					
					for(var idx=1;idx<=sheetObjects[1].RowCount;idx++){
						if(sheetObjects[1].CellValue(idx,"cntr_no") != ""){
							sheetObjects[1].CellEditable(idx, "cntr_no") = false;
						}
					}					
				} else if (tpszR > 0 && tpszN < 0 && tpszP < 0) {
					document.getElementById("auth_cd").style.color = "black";
					document.getElementById("auth_cd").value = "R";
					document.getElementById("auth_cd").style.fontWeight = "bold";
				} else if (tpszY > 0 && tpszR < 0 && tpszN < 0 && tpszP < 0) {
					document.getElementById("auth_cd").style.color = "black";
					document.getElementById("auth_cd").value = "Y";
					document.getElementById("auth_cd").style.fontWeight = "bold";
				} else {
					document.getElementById("auth_cd").style.color = "";
					document.getElementById("auth_cd").value = "";
					document.getElementById("auth_cd").style.fontWeight = "bold";
				}
	
				for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
					sheetObjects[1].CellValue2(i, "seq") = i;
	//				if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "") {
						sheetObjects[1].CellValue2(i, "ibflag") = "R";
	//				}
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "Y") {
						cnt++;
					}
				}
				
				//htmlSheetSync();	
				//sheetObjects[0]에서 D7이 있는지 조회한다.
				var d7Type = sheetObjects[0].FindText("cntr_tpsz_cd", "D7", 0, 2);
	
				//rowcount가 0이고 D7이 있을 경우 row를 추가하여 아래와 같이 값을 셋팅한다.
				if (sheetObjects[1].RowCount < 1 && d7Type > 0 && document.getElementById("bl_no").value != "") {
					document.getElementById("auth_cd").value = "";
					checkAdd();
					sheetObjects[1].CellValue2(1, "cntr_tpsz_cd") = "D7";
					document.getElementById("cntr_tpsz_cd").value = "D7";
					sheetObjects[1].CellValue2(1, "grs_wgt") = sheetObjects[2].CellValue(1, "act_wgt");
					sheetObjects[1].CellValue2(1, "net_wgt") = sheetObjects[2].CellValue(1, "act_wgt");
					sheetObjects[1].CellValue2(1, "wgt_ut_cd") = sheetObjects[2].CellValue(1, "wgt_ut_cd");
					sheetObjects[1].CellValue2(1, "in_ga_flg") = "Y";
					document.getElementById("inGauge").checked = true;
					//htmlSheetSync();	
				} else if (sheetObjects[1].RowCount < 1 && d7Type < 1 && document.getElementById("bl_no").value != "") {
					document.getElementById("auth_cd").value = "";
					checkAdd();
				} else if (sheetObjects[1].RowCount < 1 && document.getElementById("bl_no").value == "") {
					ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
					return;
				}	
				htmlSheetSync();
				document.getElementById("frm_seq").value = sheetObjects[1].CellValue(1, "seq");
			}
	
			//------------------------------------------------>
			//setInquiryDisableButton 이벤트 호출
			if (ComGetObjValue(document.form.isInquiry) == "Y") {
				setInquiryDisableButton();
			}			
			pendingSaveFlg = "Y";	//조회 시 Flag 초기화	
			break;
	
		//이거는 사용 안하는데 일단 만들었음...
		case COMMAND01: //조회 					
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value = SEARCH01;
			var resultXml = sheetObj.GetSearchXml("ESM_BKG_0055GS.do", FormQueryString(formObj));
			sheetObjects[3].LoadSearchXml(resultXml, false);
			break;
	
		// bkg_split_no 조회 및 셋팅... ESM_BKG_0079_01.js 소스를 카피했음.
		case COMMAND04: //booking split no조회 
			formObj.f_cmd.value = COMMAND03;
			var param = "&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
			var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
			bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 20);	
			break;
	
		//저장시 로직...
		case IBSAVE:
			if (validateForm(sheetObj, formObj, sAction)){
				if (sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "bdr_flg") == "Y") {
					ComShowMessage(ComGetMsg("BKG00004"));
					chkFlg = "Y";
					return;
				}			
			}
			
			//저장 validation 체크부분...
			var r_row = 0;
			var d_row = 0;
			var voidSpaceSum = 0;
			var bkg0520Cnt = 0;
			var requestCnt = 0;
			var awkChkFlg = "N";
			var cntrNo = "";
			var oldCntrNo = "";
			var jXml = null;
			var wgtPass = "";
			var cntrTpSzPass = "";
			var cntrTpSzWgt = "";
			var overWgtCnt = 0;
	
			formObj.f_cmd.value = COMMAND04;
	
			for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
				//삭제일 경우 Validate Skip
				if(sheetObjects[1].RowHidden(i)||sheetObjects[1].CellValue(i, "ibflag") == "D"){
					continue;
				}
				//if (sheetObjects[1].CellValue(i, "ibflag") == "D") continue;
	
				var jParam = "f_cmd="+COMMAND04;
				jParam = jParam+"&bkg_no="+sheetObjects[1].CellValue(i,"bkg_no")
						  +"&cntr_no="+sheetObjects[1].CellValue(i,"cntr_no")
						  +"&grs_wgt="+sheetObjects[1].CellValue(i,"grs_wgt")
				          +"&cntr_tpsz_cd="+sheetObjects[1].CellValue(i,"cntr_tpsz_cd")
						  +"&wgt_ut_cd="+formObj.wgt_ut_cd1.value;
				jXml = sheetObj.GetSearchXml("ESM_BKG_0055GS.do", jParam);
				wgtPass = ComGetEtcData(jXml, "wgt_pass");
				cntrTpSzPass = ComGetEtcData(jXml, "cntr_tp_sz_pass");
				cntrTpSzWgt  = ComGetEtcData(jXml, "cntr_tp_sz_wgt");
				if (wgtPass == 'N') {
					if (!ComShowConfirm(ComGetMsg("BKG06130"))){
						return;
					}
				}
				if (cntrTpSzPass == 'N'){
					if(!ComShowConfirm(ComGetMsg("BKG06131",i,cntrTpSzWgt)))
						return;
				}
				if (sheetObjects[1].CellValue(i, "apro_cd") != "C" || sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") != "") {	
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "P" && pendingSaveFlg == "N") {
						ComShowMessage(ComGetMsg("BKG00500"));
						chkFlg = "Y";
						return;
					}
					if (sheetObjects[1].CellValue(i, "ibflag") == "R") {
						r_row++;
					}
					if (sheetObjects[1].CellValue(i, "ibflag") == "D") {
						d_row++;
					}
					if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
						voidSpaceSum += Number(sheetObjects[1].CellValue(i, "ovr_void_slt_qty"));
					}
					if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == "") {
						ComShowMessage(ComGetMsg("BKG08126"));
						chkFlg = "Y";
						sheetObjects[1].SelectCell(i, "cntr_tpsz_cd");
						return;
					}
					if (sheetObjects[1].CellValue(i, "ttl_dim_len") == "" || sheetObjects[1].CellValue(i, "ttl_dim_wdt") == "" || sheetObjects[1].CellValue(i, "ttl_dim_hgt") == "" || sheetObjects[1].CellValue(i, "ttl_dim_len") == "0" || sheetObjects[1].CellValue(i, "ttl_dim_wdt") == "0" || sheetObjects[1].CellValue(i, "ttl_dim_hgt") == "0") {
						ComShowMessage(ComGetMsg("BKG08026"));
						chkFlg = "Y";
						return;
					}
					if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "D7") {
						if (sheetObjects[1].CellValue(i, "pck_qty") == "0") {
							ComShowMessage(ComGetMsg("BKG00504"));
							chkFlg = "Y";
							return;
						}
						if (sheetObjects[1].CellValue(i, "pck_tp_cd") == "") {
							ComShowMessage(ComGetMsg("BKG00505"));
							chkFlg = "Y";
							return;
						}
						if (sheetObjects[1].CellValue(i, "grs_wgt") == "" || sheetObjects[1].CellValue(i, "grs_wgt") == "0") {
							ComShowMessage(ComGetMsg("BKG00506"));
							chkFlg = "Y";
							return;
						}
						if (sheetObjects[1].CellValue(i, "wgt_ut_cd") == "") {
							ComShowMessage(ComGetMsg("BKG00507"));
							chkFlg = "Y";
							return;
						}
						if (sheetObjects[1].CellValue(i, "net_wgt") == "" || sheetObjects[1].CellValue(i, "net_wgt") == "0") {
							ComShowMessage(ComGetMsg("BKG00508"));
							chkFlg = "Y";
							return;
						}
						if (sheetObjects[1].CellValue(i, "cmdt_cd") == "") {
							ComShowMessage(ComGetMsg("BKG00510"));
							chkFlg = "Y";
							return;
						}
						if (sheetObjects[1].CellValue(i, "ttl_dim_len") == "" || sheetObjects[1].CellValue(i, "ttl_dim_len") == 0 || sheetObjects[1].CellValue(i, "ttl_dim_wdt") == "" || sheetObjects[1].CellValue(i, "ttl_dim_wdt") == 0 || sheetObjects[1].CellValue(i, "ttl_dim_hgt") == "" || sheetObjects[1].CellValue(i, "ttl_dim_hgt") == 0) {
							ComShowMessage(ComGetMsg("BKG00511"));
							chkFlg = "Y";
							return;
						}
	/*					if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd").indexOf("F") > -1) {
	//						if (sheetObjects[1].CellValue(i, "crn_pst_sts_cd") != "E" && sheetObjects[1].CellValue(i, "crn_pst_sts_cd") != "F") {
	//							ComShowMessage(ComGetMsg("BKG00515"));
	//							chkFlg = "Y";
	//							return;
	//						}
						}*/
						if (sheetObjects[1].CellValue(i, "crn_pst_sts_cd") != "" && sheetObjects[1].CellValue(i, "crn_pst_sts_cd") != "E" && sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "P4" && sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "P2" && sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "F4" && sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "F2"
							&& sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "A5" && sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "A4" && sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "A2" && sheetObjects[1].CellValue(i, "cntr_tpsz_cd") != "F5") {
							ComShowMessage(ComGetMsg("BKG00516"));
							chkFlg = "Y";
							return;
						}
	
						if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd").indexOf("A") > -1 && sheetObjects[1].CellValue(i, "crn_pst_sts_cd") == "") {
							ComShowMessage(ComGetMsg("BKG00517"));
							chkFlg = "Y";
							return;
						}
	
						if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd").indexOf("A") > -1 && sheetObjects[1].CellValue(i, "pst_lck_pin_flg") == "") {
							if (sheetObjects[1].CellValue(i, "crn_pst_sts_cd") != "E" && sheetObjects[1].CellValue(i, "crn_pst_sts_cd") != "F" && sheetObjects[1].CellValue(i, "crn_pst_sts_cd") != "") {
								ComShowMessage(ComGetMsg("BKG00519"));
								chkFlg = "Y";
								return;
							}
						}
						
						// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
						cntrNo = sheetObjects[1].CellValue(i, "cntr_no");
						oldCntrNo = sheetObjects[1].CellSearchValue(i, "cntr_no");
						if ( awkChkFlg == "N" && cntrNo != oldCntrNo ) {
							awkChkFlg = "Y";
						}
					}
				}
				
				// 2017.09.29 iylee S/I 이후에만 체크, Booking Container내에 Container Weight 와 Awkward Container Weight 가 10% 이상이면 빨간색 표시.
				var newCntrNo = sheetObjects[1].CellValue(i, "cntr_no");
				var newCntrGrsWgt = sheetObjects[1].CellValue(i, "grs_wgt");
				var oldCntrGrsWgt = sheetObjects[1].CellValue(i, "bkg_cntr_wgt");
				var overWgtFlg = checkGrsWgtOver(newCntrNo, newCntrGrsWgt, oldCntrGrsWgt);
				
				if(sheetObjects[2].CellValue(1, "xter_si_ref_no") != "" && overWgtFlg){
					sheetObjects[1].CellFontColor(i, "cntr_no") = sheetObjects[1].RgbColor(255,0,0);
					sheetObjects[1].CellValue2(i, "over_wgt_flg") = "1";
					document.getElementById("frm_grs_wgt").style.color = "red";
					overWgtCnt++;
				} else {
					sheetObjects[1].CellFontColor(i, "cntr_no") = sheetObjects[1].RgbColor(0,0,0);
					sheetObjects[1].CellValue2(i, "over_wgt_flg") = "0";
					document.getElementById("frm_grs_wgt").style.color = "black";						
				}
			}
			
			var o_cnt = 0;
			for ( var j = 1; j <= sheetObjects[0].RowCount; j++) {
				if (sheetObjects[0].CellValue(j, "cntr_tpsz_cd") == "Q2") {
					o_cnt += Number(sheetObjects[0].CellValue(j, "awk_cgo_qty")) / 2;
				}
				if (sheetObjects[0].CellValue(j, "cntr_tpsz_cd") == "Q4") {
					o_cnt += Number(sheetObjects[0].CellValue(j, "awk_cgo_qty"));
				}
				if (sheetObjects[0].CellValue(j, "awk_cgo_qty") == 0 && d_row > 0) {
					ComShowCodeMessage("BKG00502", "AK");
					chkFlg = "Y";
					return;
				}
	
				var cnt = 0;
				var rcnt = 0;
				var find_tpsz_cd = "";
				for ( var m = 1; m <= sheetObjects[1].RowCount; m++) {
					// Cancel 되거나 삭제된 행 제외
					if (sheetObjects[1].CellValue(m, "apro_cd") != "C" && sheetObjects[1].CellValue(m, "spcl_cgo_apro_cd") != "C" && sheetObjects[1].CellValue(m, "ibflag") != "D") {
						if (sheetObjects[1].CellValue(m, "cntr_tpsz_cd").indexOf("Q") > -1) {
							ComShowMessage(ComGetMsg("BKG08023"));
							chkFlg = "Y";
							return;
						}
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
				var find_tpsz_cd = sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[0].CellValue(j, "cntr_tpsz_cd"), 0, 2);
				if (find_tpsz_cd > 0) {
					if (Number(sheetObjects[0].CellValue(j, "awk_cgo_qty")) > cnt) {
						if (ComShowConfirm(ComGetMsg("BKG00678", "AK"))) {	
							cnt = 0;
						} else {
							chkFlg = "Y";
							return;
						}
					}
					if (Number(sheetObjects[0].CellValue(j, "awk_cgo_qty")) < cnt) {
						ComShowCodeMessage("BKG00679", "AK");
						chkFlg = "Y";
						return;
					}
				}
			}
			
			// 2017.08.04 iylee Type Size = 'A4' 를 포함하는 경우 Corner Post Status에 대한 문구를 표시한다.
	    	var findA4 = sheetObjects[1].FindText("cntr_tpsz_cd","A4",0,2);
	    	if(findA4 > -1){
				ComShowMessage(ComGetMsg("BKG43049"));
	    	}
	    	
	    	if(sheetObjects[2].CellValue(1, "xter_si_ref_no") != "" && overWgtCnt > 0){
	    		ComShowMessage(ComGetMsg("BKG95131"));
	    		return;
	    	}
	
			var dimRow = sheetObjects[3].RowCount("R");
			if (sheetObjects[1].RowCount == r_row && sheetObjects[3].RowCount == dimRow) {
				//if(reqFlag != "N"){
				ComShowMessage(ComGetMsg("BKG00501"));
				chkFlg = "Y";
				//}
				return;	
			}			
			
			var rCnt = 0;
			for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
				if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "R") {
					//appr.의 값이 R일경우... rCnt의 값을 1씩 더한다.
					rCnt++;
				}
			}
			
			var rypCnt = 0;
			for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
				if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "R" ||sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "Y"||sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "P") {
					//appr.의 값이 R일경우... rCnt의 값을 1씩 더한다.
					rypCnt++;
				}
			}
			
			
//			if (o_cnt != voidSpaceSum) {
//				ComShowMessage(ComGetMsg("BKG00964"));
//			}
			
			//AK Application 이 1개이상 request 상태이면, void space 업데이트시 MAIN의 Q 합과 Void FEU 합을 비교해서 VOID가 크면 불가토록 BLOCK
			//request시에는 Q 합 과 Void space Feu값을 비교해서 Void가 크면 저장 불가
			//즉, request 된 상태가 아니라면 저장은 가능하지만 request는 불가
			if (o_cnt < voidSpaceSum && rypCnt > 0) {
				ComShowMessage(ComGetMsg("BKG95083"));
				endFlg = "Y";
				return;	
			} else if(o_cnt < voidSpaceSum && messageFlg == "request") {	
				ComShowMessage(ComGetMsg("BKG95083"));
				endFlg = "Y";
				return;	
			}else{
				if (o_cnt != voidSpaceSum) {
					ComShowMessage(ComGetMsg("BKG00964"));
				}				
			}		
			
			//var find_row = sheetObjects[1].FindText("modifyaproflg", "Y", 0, 2);	
			
			//2012.02.09 변종건 --2012.02.10 변종건 [CHM-201216124-01] BKG/DOC AK Seq 정리 요청(Start)---------
			for( var idx=0+parseInt(sheetObjects[1].HeaderRows); idx<sheetObjects[1].RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
				if( sheetObjects[1].CellValue(idx,"rcv_term_cd") == "" && sheetObjects[2].CellValue(parseInt(sheetObjects[1].HeaderRows),"rcv_term_cd") != "M" ){
					sheetObjects[1].CellValue2(idx,"rcv_term_cd") = sheetObjects[2].CellValue(parseInt(sheetObjects[1].HeaderRows),"rcv_term_cd");
				}
				
				if( sheetObjects[1].CellValue(idx,"de_term_cd") == "" && sheetObjects[2].CellValue(parseInt(sheetObjects[1].HeaderRows),"de_term_cd") != "M" ){
					sheetObjects[1].CellValue2(idx,"de_term_cd") = sheetObjects[2].CellValue(parseInt(sheetObjects[1].HeaderRows),"de_term_cd");
				}
			}
			//2012.02.09 변종건 --2012.02.10 변종건 [CHM-201216124-01] BKG/DOC AK Seq 정리 요청(End)-----------
			
			formObj.f_cmd.value = MULTI;
			var sParam = FormQueryString(formObj);
			//alert(sParam);
			
			// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
			sParam = sParam + "&" + "awk_chk_flg=" + awkChkFlg;
			
			//저장되어야 할 sheet가 2개이다. 
			var sParamSheet1 = sheetObjects[1].GetSaveString();
			var sParamSheet2 = sheetObjects[3].GetSaveString();
	
			if (sParamSheet1 != "") {
				sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
			}
			if (sParamSheet2 != "") {																																			
				sParam = sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
			} else {
				// sParamSheet2 == ""일 경우 저장로직을 안 탈 수 있으므로 강제로 row를 생성하여 임의로 sheet를 날린다. sheet가 hidden이므로 로직상 문제는 없다.
				var Row = sheetObjects[3].DataInsert(-1);
				sheetObjects[3].CellValue2(Row, "DelChk") = "0";
				sheetObjects[3].CellValue2(Row, "ibflag") = "U";
				sheetObjects[3].CellValue2(Row, "dim_len") = "0";
				sheetObjects[3].CellValue2(Row, "dim_wdt") = "0";
				sheetObjects[3].CellValue2(Row, "dim_hgt") = "0";
				sheetObjects[3].CellValue2(Row, "indiv_pck_wgt") = "0";
				sheetObjects[3].CellValue2(Row, "awk_cgo_seq") = "0";
				sheetObjects[3].CellValue2(Row, "bkg_no") = document.getElementById("bkg_no").value;
				sheetObjects[3].CellValue2(Row, "dim_seq") = "1";
				var sParamSheet3 = sheetObjects[3].GetSaveString();
				sParam = sParam + "&sheet2_" + sParamSheet3.replace(/&/g, '&sheet2_');
			}
	
			var rXml = sheetObj.GetSaveXml("ESM_BKG_0055GS.do", sParam);
			var rMsg = ComResultMessage(rXml);
			var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
			// AK 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
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
			
			if (State == "S") {
				ComShowMessage(ComGetMsg("BKG00166"));
				//정상적으로 저장이 완료된 후... retFlag가 Y이어야 화면이 다시 조회된다. 
				retFlag = "Y";
			} else if (rMsg == '' && reqFlag == "N") {
				ComShowMessage(ComGetMsg("BKG00167"));
				return false;
			} else if (State == undefined) {
				ComShowMessage(ComGetMsg("BKG00167"));
				return false;
			} else {
				sheetObj.LoadSearchXml(rXml);
				return false;
			}	
			break;
	
		//request 버튼을 눌렀을 경우...
		case COMMAND02: //request...										
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value = COMMAND02;
		
			//2012.02.10 변종건 --2012.02.10 변종건 [CHM-201216124-01] BKG/DOC AK Seq 정리 요청(Start)---------
			for( var idx=0+parseInt(sheetObjects[1].HeaderRows); idx<sheetObjects[1].RowCount+parseInt(sheetObj.HeaderRows); idx++ ){
				if( sheetObjects[1].CellValue(idx,"rcv_term_cd") == "" && sheetObjects[2].CellValue(parseInt(sheetObjects[1].HeaderRows),"rcv_term_cd") != "M" ){
					sheetObjects[1].CellValue2(idx,"rcv_term_cd") = sheetObjects[2].CellValue(parseInt(sheetObjects[1].HeaderRows),"rcv_term_cd");
				}
				
				if( sheetObjects[1].CellValue(idx,"de_term_cd") == "" && sheetObjects[2].CellValue(parseInt(sheetObjects[1].HeaderRows),"de_term_cd") != "M" ){
					sheetObjects[1].CellValue2(idx,"de_term_cd") = sheetObjects[2].CellValue(parseInt(sheetObjects[1].HeaderRows),"de_term_cd");
				}
			}
			
			//2012.02.09 변종건 --2012.02.10 변종건 [CHM-201216124-01] BKG/DOC AK Seq 정리 요청(End)-----------		
			var sParam = FormQueryString(formObj);
			var sParamSheet1 = sheetObjects[1].GetSaveString();
			if (sParamSheet1 != "") {
				sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
			}
			var rXml = sheetObj.GetSaveXml("ESM_BKG_0055GS.do", sParam);
			var rMsg = ComResultMessage(rXml);
			var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
	
			// AK 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
			if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
				var errMsg01 = ComGetEtcData(rXml,"psaValCode");
		    	var rmsg = errMsg01.split("<||>");
		    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
		    		ComShowCodeMessage("BKG06125");
		    	}else if ( rmsg[1] != "BKG95025" ){
		    		ComShowMessage(rmsg[3]);
		    	}
			}
			
			if (rMsg == '' && messageFlg == "save") {
				//ComShowMessage(ComGetMsg("BKG00166"));
				//정상적으로 저장이 완료된 후... retFlag가 Y이어야 화면이 다시 조회된다. 
				retFlag = "Y";
			} else if (rMsg == '' && messageFlg == "request") {
				ComShowMessage(ComGetMsg("BKG08102"));
				retFlag = "Y";
			} else if (rMsg == '' && messageFlg == "requestCancel") {
				ComShowMessage(ComGetMsg("BKG08103"));
				retFlag = "Y";
			} else {
				sheetObj.LoadSearchXml(rXml);
				return false;
			}
			break;
	
		//request cancel을 눌렀을 경우...
		case COMMAND03: //request cancel...		
			formObj.button.value = "Y";
			//cancel request시에 재 request막음
			if (validateForm(sheetObj, formObj, sAction))
				formObj.f_cmd.value = COMMAND02;
			var sParam = FormQueryString(formObj);
			var sParamSheet1 = sheetObjects[1].GetSaveString();
			if (sParamSheet1 != "") {
				sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
			}
			var rXml = sheetObj.GetSaveXml("ESM_BKG_0055GS.do", sParam);
			var rMsg = ComResultMessage(rXml);
			var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
			if (rMsg == '' && messageFlg == "save") {
				//ComShowMessage(ComGetMsg("BKG00166"));
				//정상적으로 저장이 완료된 후... retFlag가 Y이어야 화면이 다시 조회된다. 
				retFlag = "Y";
			} else if (rMsg == '' && messageFlg == "request") {
				ComShowMessage(ComGetMsg("BKG08102"));
				retFlag = "Y";
			} else if (rMsg == '' && messageFlg == "requestCancel") {
				ComShowMessage(ComGetMsg("BKG08103"));
				retFlag = "Y";
			} else {
				sheetObj.LoadSearchXml(rXml);
				return false;
			}
			break;
	
		//cmdt_cd 값을 이용하여 조회후, cmdt_nm에 값 셋팅...
		case COMMAND05:
			if (validateForm(sheetObj, formObj, sAction)) {
				sheetObj.WaitImageVisible = false;
				cmdtFlg = "1";	
				formObj.f_cmd.value = COMMAND05;
				var rXml = sheetObj.GetSearchXml("ESM_BKG_0498GS.do", FormQueryString(formObj));	
				var cmdt_nm = ComGetEtcData(rXml, "cmdt_nm");
	
				document.getElementById("cmdt_nm").value = cmdt_nm;
				sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cmdt_nm") = cmdt_nm;
				sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "modifyaproflg") = "Y";
				sheetObj.WaitImageVisible = true;
				cmdtFlg = "";
			} else {
				return false;
			}	
			break;
	}
}

//사용 안하는 로직... 처음에는 사용하였으나 로직이 변경되면서 사용 안함.
function initCombo() {
	var formObject = document.form;
	var sXml = sheetObjects[3].GetSearchXml("ESM_BKG_0055GS.do", FormQueryString(formObject));
	var arrXml = sXml.split(iterator);
	if (arrXml[1].length > 0) {
		var arrCombo = ComXml2ComboString(arrXml[0], "val", "name");
		sheetObjects[0].InitDataCombo(0, prefix1 + "cntr_no", "|" + arrCombo[0], "|" + arrCombo[1], "Y");
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

//sheet 클릭시 html에 클릭한 row의 sheet 데이터를 셋팅함. 
function htmlSheetSync() {
	var formObject = document.form;
	Row = sheetObjects[1].SelectRow;
	IBS_CopyRowToForm(sheetObjects[1], form, Row);

	document.getElementById("frm_pck_qty").value = sheetObjects[1].CellText(Row, "pck_qty");
	document.getElementById("frm_grs_wgt").value = sheetObjects[1].CellText(Row, "grs_wgt");
	document.getElementById("frm_net_wgt").value = sheetObjects[1].CellText(Row, "net_wgt");
	document.getElementById("temp_grs_wgt").value = sheetObjects[1].CellText(Row, "grs_wgt");
	document.getElementById("temp_net_wgt").value = sheetObjects[1].CellText(Row, "net_wgt");
	document.getElementById("temp_cntr_no").value = sheetObjects[1].CellValue(Row, "cntr_no");
	document.getElementById("rcv_term_cd").value = sheetObjects[1].CellValue(Row, "rcv_term_cd");
	document.getElementById("de_term_cd").value = sheetObjects[1].CellValue(Row, "de_term_cd");
	document.getElementById("frm_cntr_cgo_seq").value = sheetObjects[1].CellValue(Row, "awk_dcgo_seq");
	document.getElementById("cmdt_cd").value = sheetObjects[1].CellValue(Row, "cmdt_cd");
	document.getElementById("cmdt_nm").value = sheetObjects[1].CellValue(Row, "cmdt_nm");
	document.getElementById("aply_no").value = sheetObjects[1].CellValue(Row, "aply_no");
	document.getElementById("awk_cgo_rqst_grp_eml1").value = sheetObjects[1].CellValue(Row, "awk_cgo_rqst_grp_eml1");
	document.getElementById("awk_cgo_rqst_grp_eml2").value = sheetObjects[1].CellValue(Row, "awk_cgo_rqst_grp_eml2");

	if (sheetObjects[1].CellValue(Row, "cntr_no") != "") {
		document.getElementById("de_term_cd").disabled = true;
		document.getElementById("rcv_term_cd").disabled = true;
		sheetObjects[1].CellEditable(Row, "cntr_vol_qty") = false;
	} else {
		sheetObjects[1].CellEditable(Row, "cntr_vol_qty") = true;
		if (sheetObjects[2].CellValue(1, "de_term_cd") == "M") {
			document.getElementById("de_term_cd").disabled = false;
		} else {
			document.getElementById("de_term_cd").disabled = true;
		}
		if (sheetObjects[2].CellValue(1, "rcv_term_cd") == "M") {
			document.getElementById("rcv_term_cd").disabled = false;
		} else {
			document.getElementById("rcv_term_cd").disabled = true;
		}
	}
	
	//by 전성진 원상태를 임의로 저장한다..
	var v_ibflag = sheetObjects[1].CellValue(Row, "ibflag");
		
	//type/size의 값이 D7일 경우, html과 sheet에 아래의 값을 default로 셋팅.
	if (sheetObjects[1].CellValue(Row, "cntr_tpsz_cd") == "D7") {
		if(sheetObjects[1].CellValue(Row, "ttl_dim_len") == 0){
			document.getElementById("ttl_dim_len").value = "1317.6";
		}else{	
			document.getElementById("ttl_dim_len").value = sheetObjects[1].CellValue(Row, "ttl_dim_len");
		}

		if(sheetObjects[1].CellValue(Row, "ttl_dim_wdt") == 0){
			document.getElementById("ttl_dim_wdt").value = "243.8";
		}else{	
			document.getElementById("ttl_dim_wdt").value = sheetObjects[1].CellValue(Row, "ttl_dim_wdt");
		}

		if(sheetObjects[1].CellValue(Row, "ttl_dim_hgt") == 0){
			document.getElementById("ttl_dim_hgt").value = "289.6";
		}else{	
			document.getElementById("ttl_dim_hgt").value = sheetObjects[1].CellValue(Row, "ttl_dim_hgt");
		}

		if(sheetObjects[1].CellValue(Row, "ovr_fwrd_len") == 0){
			document.getElementById("ovr_fwrd_len").value = "0";
		}else{	
			document.getElementById("ovr_fwrd_len").value = sheetObjects[1].CellValue(Row, "ovr_fwrd_len");
		}

		if(sheetObjects[1].CellValue(Row, "ovr_bkwd_len") == 0){
			document.getElementById("ovr_bkwd_len").value = "0";
		}else{	
			document.getElementById("ovr_bkwd_len").value = sheetObjects[1].CellValue(Row, "ovr_bkwd_len");
		}

		if(sheetObjects[1].CellValue(Row, "ovr_lf_len") == 0){
			document.getElementById("ovr_lf_len").value = "0";
		}else{	
			document.getElementById("ovr_lf_len").value = sheetObjects[1].CellValue(Row, "ovr_lf_len");
		}

		if(sheetObjects[1].CellValue(Row, "ovr_rt_len") == 0){
			document.getElementById("ovr_rt_len").value = "0";
		}else{	
			document.getElementById("ovr_rt_len").value = sheetObjects[1].CellValue(Row, "ovr_rt_len");
		}

		if(sheetObjects[1].CellValue(Row, "ovr_hgt") == 0){
			document.getElementById("ovr_hgt").value = "0";
		}else{	
			document.getElementById("ovr_hgt").value = sheetObjects[1].CellValue(Row, "ovr_hgt");
		}

		if(sheetObjects[1].CellValue(Row, "ovr_void_slt_qty") == 0){
			document.getElementById("ovr_void_slt_qty").value = "0";
		}else{	
			document.getElementById("ovr_void_slt_qty").value = sheetObjects[1].CellValue(Row, "ovr_void_slt_qty");
		}

		sheetObjects[1].CellValue2(Row, "ttl_dim_len") = Math.round(parseFloat(document.getElementById("ttl_dim_len").value)) ;
		sheetObjects[1].CellValue2(Row, "ttl_dim_wdt") = Math.round(parseFloat(document.getElementById("ttl_dim_wdt").value)) ;
		sheetObjects[1].CellValue2(Row, "ttl_dim_hgt") = Math.round(parseFloat(document.getElementById("ttl_dim_hgt").value)) ;
		sheetObjects[1].CellValue2(Row, "ovr_fwrd_len") = document.getElementById("ovr_fwrd_len").value;
		sheetObjects[1].CellValue2(Row, "ovr_bkwd_len") = document.getElementById("ovr_bkwd_len").value;
		sheetObjects[1].CellValue2(Row, "ovr_lf_len") = document.getElementById("ovr_lf_len").value;
		sheetObjects[1].CellValue2(Row, "ovr_rt_len") = document.getElementById("ovr_rt_len").value;
		sheetObjects[1].CellValue2(Row, "ovr_hgt") = document.getElementById("ovr_hgt").value;
		sheetObjects[1].CellValue2(Row, "ovr_void_slt_qty") = document.getElementById("ovr_void_slt_qty").value;		
	} else {
		document.getElementById("ttl_dim_len").value 	= Math.round(parseFloat(sheetObjects[1].CellValue(Row, "ttl_dim_len"))) ;
		document.getElementById("ttl_dim_wdt").value 	= Math.round(parseFloat(sheetObjects[1].CellValue(Row, "ttl_dim_wdt"))) ; 
		document.getElementById("ttl_dim_hgt").value 	= Math.round(parseFloat(sheetObjects[1].CellValue(Row, "ttl_dim_hgt"))) ; 
		document.getElementById("ovr_fwrd_len").value 	= Math.round(parseFloat(sheetObjects[1].CellValue(Row, "ovr_fwrd_len"))) ;
		document.getElementById("ovr_bkwd_len").value	= Math.round(parseFloat(sheetObjects[1].CellValue(Row, "ovr_bkwd_len"))) ;
		document.getElementById("ovr_lf_len").value 	= Math.round(parseFloat(sheetObjects[1].CellValue(Row, "ovr_lf_len"))) ; 
		document.getElementById("ovr_rt_len").value 	= Math.round(parseFloat(sheetObjects[1].CellValue(Row, "ovr_rt_len"))) ; 
		document.getElementById("ovr_hgt").value 		= Math.round(parseFloat(sheetObjects[1].CellValue(Row, "ovr_hgt"))) ; 
		document.getElementById("ovr_void_slt_qty").value = sheetObjects[1].CellValue(Row, "ovr_void_slt_qty");
		sheetObjects[1].CellValue2(Row, "temp_ovr_void_qty") = sheetObjects[1].CellValue(Row, "ovr_void_slt_qty");
	}
	
	//by 전성진 원상태로 변경한다.
	sheetObjects[1].CellValue2(Row, "ibflag") = v_ibflag;
	document.getElementById("wgt_ut_cd1").value = sheetObjects[1].CellValue(Row, "wgt_ut_cd");
	document.getElementById("wgt_ut_cd2").value = sheetObjects[1].CellValue(Row, "wgt_ut_cd");
	document.getElementById("crn_pst_sts_cd").value = sheetObjects[1].CellValue(Row, "crn_pst_sts_cd");
	document.getElementById("pst_lck_pin_flg").value = sheetObjects[1].CellValue(Row, "pst_lck_pin_flg");
	document.getElementById("temp_cntr_no").value = sheetObjects[1].CellValue(Row, "cntr_no");
	document.getElementById("cntr_tpsz_cd").value = sheetObjects[1].CellValue(Row, "cntr_tpsz_cd");

	if (sheetObjects[1].CellValue(Row, "in_ga_flg") == "Y") {
		document.getElementById("inGauge").checked = true;
	} else {
		document.getElementById("inGauge").checked = false;
	}

	if (sheetObjects[1].CellValue(Row, "und_deck_top_flg") == "Y") {
		document.getElementById("und_deck_top_flg").checked = true;
	} else {
		document.getElementById("und_deck_top_flg").checked = false;
	}

	/*
	if(sheetObjects[1].CellValue(Row, "ovr_void_slt_qty") == "0"){	
		document.getElementById("inGauge").checked = true;
		sheetObjects[1].CellValue2(Row, "in_ga_flg") = "Y";
	}else{
		document.getElementById("inGauge").checked = false;
		sheetObjects[1].CellValue2(Row, "in_ga_flg") = "N"
	}	
	 */

	var awk_cgo_seq = sheetObjects[1].CellValue(Row, "awk_cgo_seq")
	var findDetail = sheetObjects[3].FindText("awk_cgo_seq", awk_cgo_seq, 0, 2);

	if (sheetObjects[1].RowCount > 0 && findDetail > 0) {
		document.getElementById("details_button").style.color = "blue";
	} else {
		document.getElementById("details_button").style.color = "";
	}
	if (sheetObjects[1].RowCount > 0 && sheetObjects[1].CellValue(Row, "diff_rmk").length > 1) {
		document.getElementById("btn_Remark").style.color = "blue";
	} else {
		document.getElementById("btn_Remark").style.color = "";
	}

	if (document.getElementById("crn_pst_sts_cd").value == "E" || document.getElementById("crn_pst_sts_cd").value == "F") {
		document.getElementById("frm_xtd_ovr_qty").disabled = "true";
	} else {
		document.getElementById("frm_xtd_ovr_qty").enabled = "true";
	}

	if (sheetObjects[1].CellValue(Row, "cntr_tpsz_cd").indexOf("A") > -1) {
		document.getElementById("crn_pst_sts_cd").disabled = false;
		document.getElementById("pst_lck_pin_flg").disabled = false;
	} else if (sheetObjects[1].CellValue(Row, "cntr_tpsz_cd").indexOf("F") > -1) {
		document.getElementById("crn_pst_sts_cd").disabled = false;
		document.getElementById("pst_lck_pin_flg").disabled = true;
	} else {
		document.getElementById("crn_pst_sts_cd").disabled = true;
		document.getElementById("pst_lck_pin_flg").disabled = true;
	}
	
	if (sheetObjects[1].CellValue(Row, "spcl_cgo_apro_cd") == "C" || sheetObjects[1].CellValue(Row, "spcl_cgo_apro_cd") == "") {
		document.getElementById("btn_RequestCancel").className = "btn2_1";
		cancelFlg = "Y";
	} else {
		document.getElementById("btn_RequestCancel").className = "btn2";
		cancelFlg = "N";
	}
	
	// 2017.10.11 iylee Bkg Container의 Weight와 Awk Container Weight가 10% 이상 차이가 나는 경우 빨간색으로 표시.
	if(sheetObjects[1].CellValue(Row, "over_wgt_flg") == "1"){
		sheetObjects[1].CellFontColor(Row, "cntr_no") = sheetObjects[1].RgbColor(255,0,0);
		document.getElementById("frm_grs_wgt").style.color = "red";
	}else{
		sheetObjects[1].CellFontColor(Row, "cntr_no") = sheetObjects[1].RgbColor(0,0,0);
		document.getElementById("frm_grs_wgt").style.color = "black";
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
		} else {
			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + cntr_name, " |" + cntr_val);
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = true;
		}
	} else {
		if (val != "") {
			sheetObjects[1].CellComboItem(i, "cntr_no", " |" + sheetObjects[1].CellValue(i, "cntr_no"), " |" + sheetObjects[1].CellValue(i, "cntr_no"));
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = false;
		} else {
			sheetObjects[1].CellComboItem(i, "cntr_no", " ", " ");
			sheetObjects[1].CellEditable(i, "cntr_tpsz_cd") = true;
		}
	}
}

//sheet 클릭시...
function sheet2_OnClick(sheetObj, row, col, val) {
	var col_name = sheetObj.ColSaveName(col);
	htmlSheetSync();
	switch (col_name) {
	case "cntr_no":
		fnCntrComboItem(sheetObj, row, col, val);
		break;
	}
}

//sheet의 값 변경시...
function sheet2_OnChange(sheetObj, row, col, val) {
	var col_name = sheetObj.ColSaveName(col);
	switch (col_name) {

	//cntr_no 변경시
	case "cntr_no":
		if (sheetObjects[1].CellValue(row, "cntr_no") != "") {
			var temp_cntr_no = document.getElementById("temp_cntr_no").value;
			var temp_find_row = sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);

			//hidden sheet에서 같은 cntr_no가 값이 있을경우, cntr_no를 찾아서 체크를 풀어준다.
			if (temp_cntr_no != "") {
				sheetObjects[4].CellValue(temp_find_row, "DelChk") = "0";
			}
			var cntr_no = sheetObjects[1].CellValue(row, "cntr_no");
			var find_row = sheetObjects[4].FindText("name", cntr_no, 0, 2);
			
			if (sheetObjects[1].CellValue(row, "cntr_no") != "" && sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != "" && sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd")) {
				if (ComShowConfirm(ComGetMsg("BKG00570"))) {
					sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
					document.getElementById("cntr_tpsz_cd").value = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
				} else {
					sheetObjects[1].CellValue2(row, "cntr_no") = "";
					cntr_no = "";
				}
			} else if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd") == "") {
				sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
				document.getElementById("cntr_tpsz_cd").value = sheetObjects[4].CellValue(find_row, "cntr_tpsz_cd");
			}
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = sheetObjects[4].CellValue(find_row, "cntr_vol_qty");
			sheetObjects[1].CellValue2(row, "rcv_term_cd") = sheetObjects[4].CellValue(find_row, "rcv_term_cd");
			sheetObjects[1].CellValue2(row, "de_term_cd") = sheetObjects[4].CellValue(find_row, "de_term_cd");
			sheetObjects[1].CellValue2(row, "bkg_cntr_wgt") = sheetObjects[4].CellValue(find_row, "cntr_wgt");
			document.getElementById("rcv_term_cd").value = sheetObjects[4].CellValue(find_row, "rcv_term_cd");
			document.getElementById("de_term_cd").value = sheetObjects[4].CellValue(find_row, "de_term_cd");
			document.getElementById("de_term_cd").disabled = true;
			document.getElementById("rcv_term_cd").disabled = true;
			
			if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd").indexOf("A") > -1) {
				document.getElementById("crn_pst_sts_cd").disabled = false;
				document.getElementById("pst_lck_pin_flg").disabled = false;
			} else if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd").indexOf("F") > -1) {
				document.getElementById("crn_pst_sts_cd").value = "E";
				document.getElementById("pst_lck_pin_flg").value = "";
				sheetObjects[1].CellValue2(row, "crn_pst_sts_cd") = "E";
				sheetObjects[1].CellValue2(row, "pst_lck_pin_flg") = "";
				document.getElementById("crn_pst_sts_cd").disabled = false;
				document.getElementById("pst_lck_pin_flg").disabled = true;
			} else {
				document.getElementById("crn_pst_sts_cd").value = "";
				document.getElementById("pst_lck_pin_flg").value = "";
				sheetObjects[1].CellValue2(row, "crn_pst_sts_cd") = "";
				sheetObjects[1].CellValue2(row, "pst_lck_pin_flg") = "";
				document.getElementById("crn_pst_sts_cd").disabled = true;
				document.getElementById("pst_lck_pin_flg").disabled = true;
			}
			
			if (cntr_no != "") {
				sheetObjects[4].CellValue2(find_row, "DelChk") = "1";
			}
			//document.getElementById("temp_cntr_no").value = cntr_no;					

			/**
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
			
			var checkCntr = sheetObjects[4].FindText("DelChk", "0", 0, 2);				
								
			for (var i=1; i<=sheetObjects[1].RowCount; i++){	
				
				if(checkCntr > 0){
					if(sheetObjects[1].CellValue(i, "cntr_no") != ""){							   
						sheetObjects[1].CellComboItem(i, "cntr_no", " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_name, " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_val);							   
						sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = false;							   
					}else{							 
						sheetObjects[1].CellComboItem(i, "cntr_no", " |"+cntr_name, " |"+cntr_val);							  
						sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = true;									
					}
				}else{
					if(sheetObjects[1].CellValue(i, "cntr_no") != ""){							   
						sheetObjects[1].CellComboItem(i, "cntr_no", " |"+sheetObjects[1].CellValue(i, "cntr_no"), " |"+sheetObjects[1].CellValue(i, "cntr_no"));							   
						sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = false;							   
					}else{							 
						sheetObjects[1].CellComboItem(i, "cntr_no", " |", " |");							  
						sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = true;									
					}							
				}
			}	
			 */
		} else {
			var temp_cntr_no = document.getElementById("temp_cntr_no").value;
			var temp_find_row = sheetObjects[4].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[4].CellValue(temp_find_row, "DelChk") = "0";
			}

			if (sheetObjects[2].CellValue(1, "de_term_cd") == "M") {
				document.getElementById("de_term_cd").disabled = false;
			} else {
				document.getElementById("de_term_cd").disabled = true;
			}
			if (sheetObjects[2].CellValue(1, "rcv_term_cd") == "M") {
				document.getElementById("rcv_term_cd").disabled = false;
			} else {
				document.getElementById("rcv_term_cd").disabled = true;
			}
			document.getElementById("temp_cntr_no").value = "";

			/**	
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
				
				var checkCntr = sheetObjects[4].FindText("DelChk", "0", 0, 2);
				
				for (var i=1; i<=sheetObjects[1].RowCount; i++){
					
					if(checkCntr > 0) {
						if(sheetObjects[1].CellValue(i, "cntr_no") != ""){							   
							   sheetObjects[1].CellComboItem(i, "cntr_no", " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_name, " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_val);							   
							   sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = false;						
						}else{							 
							  sheetObjects[1].CellComboItem(i, "cntr_no", " |"+cntr_name, " |"+cntr_val);							  
							  sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = true;							  
						}		
					}else{
						if(sheetObjects[1].CellValue(i, "cntr_no") != ""){							   
							   sheetObjects[1].CellComboItem(i, "cntr_no", " |"+sheetObjects[1].CellValue(i, "cntr_no"), " |"+sheetObjects[1].CellValue(i, "cntr_no"));							   
							   sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = false;						
						}else{							 
							  sheetObjects[1].CellComboItem(i, "cntr_no", " ", " ");							  
							  sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = true;							  
						}
					}
				}	*/

		}
		document.getElementById("frm_cntr_cgo_seq").value = "";
		sheetObjects[1].CellValue(row, "awk_dcgo_seq") = "";
		sheetObjects[1].CellValue(row, "cntr_cgo_seq") = "";
		break;

	case "cntr_tpsz_cd":
		sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = (sheetObjects[1].CellValue(row, "cntr_tpsz_cd")).toUpperCase();
		document.getElementById("cntr_tpsz_cd").value = sheetObjects[1].CellValue(row, "cntr_tpsz_cd");
		var find_row = sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), 0, 2);
		if (find_row > 0) {
			var cntrVolQty = Number(sheetObjects[0].CellValue(find_row, "awk_cgo_qty"));
		} else {
			var cntrVolQty = "0";
		}
		if (cntrVolQty >= 1) {
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = "1";
		} else if (cntrVolQty > 0 && cntrVolQty < 1) {
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = cntr_vol_qty;
		} else {
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = "0";
		}
		
		if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd").indexOf("A") > -1) {
			document.getElementById("crn_pst_sts_cd").disabled = false;
			document.getElementById("pst_lck_pin_flg").disabled = false;
		} else if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd").indexOf("F") > -1) {
			document.getElementById("crn_pst_sts_cd").value = "E";
			document.getElementById("pst_lck_pin_flg").value = "";
			sheetObjects[1].CellValue2(row, "crn_pst_sts_cd") = "E";
			sheetObjects[1].CellValue2(row, "pst_lck_pin_flg") = "";
			document.getElementById("crn_pst_sts_cd").disabled = false;
			document.getElementById("pst_lck_pin_flg").disabled = true;
		} else {
			document.getElementById("crn_pst_sts_cd").value = "";
			document.getElementById("pst_lck_pin_flg").value = "";
			sheetObjects[1].CellValue2(row, "crn_pst_sts_cd") = "";
			sheetObjects[1].CellValue2(row, "pst_lck_pin_flg") = "";
			document.getElementById("crn_pst_sts_cd").disabled = true;
			document.getElementById("pst_lck_pin_flg").disabled = true;
		}
		
		if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd") == "D7") {
			if(sheetObjects[1].CellValue(row, "ttl_dim_len") == 0){
				document.getElementById("ttl_dim_len").value = "1317.6";
			}else{	
				document.getElementById("ttl_dim_len").value = sheetObjects[1].CellValue(row, "ttl_dim_len");
			}

			if(sheetObjects[1].CellValue(row, "ttl_dim_wdt") == 0){
				document.getElementById("ttl_dim_wdt").value = "243.8";
			}else{	
				document.getElementById("ttl_dim_wdt").value = sheetObjects[1].CellValue(row, "ttl_dim_wdt");
			}

			if(sheetObjects[1].CellValue(row, "ttl_dim_hgt") == 0){
				document.getElementById("ttl_dim_hgt").value = "289.6";
			}else{	
				document.getElementById("ttl_dim_hgt").value = sheetObjects[1].CellValue(row, "ttl_dim_hgt");
			}

			if(sheetObjects[1].CellValue(row, "ovr_fwrd_len") == 0){
				document.getElementById("ovr_fwrd_len").value = "0";
			}else{	
				document.getElementById("ovr_fwrd_len").value = sheetObjects[1].CellValue(row, "ovr_fwrd_len");
			}

			if(sheetObjects[1].CellValue(row, "ovr_bkwd_len") == 0){
				document.getElementById("ovr_bkwd_len").value = "0";
			}else{	
				document.getElementById("ovr_bkwd_len").value = sheetObjects[1].CellValue(row, "ovr_bkwd_len");
			}

			if(sheetObjects[1].CellValue(row, "ovr_lf_len") == 0){
				document.getElementById("ovr_lf_len").value = "0";
			}else{	
				document.getElementById("ovr_lf_len").value = sheetObjects[1].CellValue(row, "ovr_lf_len");
			}

			if(sheetObjects[1].CellValue(row, "ovr_rt_len") == 0){
				document.getElementById("ovr_rt_len").value = "0";
			}else{	
				document.getElementById("ovr_rt_len").value = sheetObjects[1].CellValue(row, "ovr_rt_len");
			}

			if(sheetObjects[1].CellValue(row, "ovr_hgt") == 0){
				document.getElementById("ovr_hgt").value = "0";
			}else{	
				document.getElementById("ovr_hgt").value = sheetObjects[1].CellValue(row, "ovr_hgt");
			}

			if(sheetObjects[1].CellValue(row, "ovr_void_slt_qty") == 0){
				document.getElementById("ovr_void_slt_qty").value = "0";
			}else{	
				document.getElementById("ovr_void_slt_qty").value = sheetObjects[1].CellValue(row, "ovr_void_slt_qty");
			}
			
			sheetObjects[1].CellValue2(row, "ttl_dim_len") = Math.round(parseFloat(document.getElementById("ttl_dim_len").value)) ;
			sheetObjects[1].CellValue2(row, "ttl_dim_wdt") = Math.round(parseFloat(document.getElementById("ttl_dim_wdt").value)) ;
			sheetObjects[1].CellValue2(row, "ttl_dim_hgt") = Math.round(parseFloat(document.getElementById("ttl_dim_hgt").value)) ;
			sheetObjects[1].CellValue2(row, "ovr_fwrd_len") = document.getElementById("ovr_fwrd_len").value;
			sheetObjects[1].CellValue2(row, "ovr_bkwd_len") = document.getElementById("ovr_bkwd_len").value;
			sheetObjects[1].CellValue2(row, "ovr_lf_len") = document.getElementById("ovr_lf_len").value;
			sheetObjects[1].CellValue2(row, "ovr_rt_len") = document.getElementById("ovr_rt_len").value;
			sheetObjects[1].CellValue2(row, "ovr_hgt") = document.getElementById("ovr_hgt").value;
			sheetObjects[1].CellValue2(row, "ovr_void_slt_qty") = document.getElementById("ovr_void_slt_qty").value;			
		}
		overDimensionSettingLength(document.getElementById("ttl_dim_len").value, sheetObjects[1].SelectRow, 1, 5);
		overDimensionSettingWidth(document.getElementById("ttl_dim_wdt").value, sheetObjects[1].SelectRow, 1, 5);
		overDimensionSettingHeight(document.getElementById("ttl_dim_hgt").value, sheetObjects[1].SelectRow, 1, 5);
		break;

	case "cntr_vol_qty":
		if (Number(sheetObjects[1].CellValue(row, "cntr_vol_qty")) > 1) {
			ComShowMessage(ComGetMsg("BKG08013"));
		}
		var find_row = sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), 0, 2);
		if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != "" && find_row > 0) {
			var cntrVolQty = Number(sheetObjects[0].CellValue(find_row, "awk_cgo_qty"));
		} else {
			var cntrVolQty = "0";
		}
		if (cntrVolQty > 0) {
			if (Number(sheetObjects[1].CellValue(row, "cntr_vol_qty")) > 0 && Number(sheetObjects[1].CellValue(row, "cntr_vol_qty")) <= 1) {
			} else {
				sheetObjects[1].CellValue2(row, "cntr_vol_qty") = "1";
			}
		} else {
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = "0";
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		//             if (!isNumber(formObj.iPage)) {
		//                 return false;
		//             }
	}
	return true;
}

function voidSpaceCheck(){
	var voidSpaceSum = 0;
	var  o_cnt = 0;
	
	for ( var j = 1; j <= sheetObjects[0].RowCount; j++) {
		if (sheetObjects[0].CellValue(j, "cntr_tpsz_cd") == "Q2") {
			o_cnt += Number(sheetObjects[0].CellValue(j, "awk_cgo_qty")) / 2;
		}
		if (sheetObjects[0].CellValue(j, "cntr_tpsz_cd") == "Q4") {
			o_cnt += Number(sheetObjects[0].CellValue(j, "awk_cgo_qty"));
		}
		
	}
		

	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "apro_cd") != "C" || sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") != "") {	
			if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
				voidSpaceSum += Number(sheetObjects[1].CellValue(i, "ovr_void_slt_qty"));
			}	
			
		}	
	}
	
	if(o_cnt < voidSpaceSum){
		ComShowMessage(ComGetMsg("BKG95083"));
		endFlg = "Y";
		return;	
	}
	
	
}

// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColBackColor("RFQTY") = RgbColor(204, 255, 253);
	}
}

//조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		/* Image Storage 에 AK 항목에 해당 image 가 한건이라도 첨부 되어 있으면 버튼 색상 변경 추가 */
		if(sheetObjects[2].RowCount > 0 ){
			if(sheetObjects[2].CellValue(1,"img_flg") == 'Y'){
				document.getElementById('btn_attach').style.color = 'blue';
			}else{
				document.getElementById('btn_attach').style.color = '';
			}
		}
	}
}

function sheet2_OnLoadFinish(sheetObj) {
	if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

/**
 * setInquiryDisableButton 이벤트 호출 .<br>
 * ComBtnDisable 을 했을경우 비활성화
 * @param 
 */
function setInquiryDisableButton() {
	ComBtnDisable("btn_attach");
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_Request");
}

function sendMail() {
	var iCnt = sheetObjects[1].FindText("ibflag", "I", 0, 2);
	var uCnt = sheetObjects[1].FindText("ibflag", "U", 0, 2);
	var dCnt = sheetObjects[1].FindText("ibflag", "D", 0, 2);
	var dim_seq = "";
	if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
		ComShowMessage(ComGetMsg("BKG00178"));
		return;
	}
	var sNow = sheetObjects[1].EvalNow();
//	var date = new Date();
	var content = "";
	content = "SM Line<br><br>[ Awkward Cargo ]<br><br>"
			+ "Date:" + sNow.substring(0, 16)
			+ "<br><br>[NE6] Awkward Cargo"
			+ "<br>Booking Number : " 
			+ document.getElementById("bkg_no").value 
			+ "<br>POL : " 
			+ document.getElementById("pol_cd").value + "&nbsp;(" + sheetObjects[2].CellValue(1, "pol_nm") + ")"
			+ "<br>POD : " 
			+ document.getElementById("pod_cd").value + "&nbsp;(" + sheetObjects[2].CellValue(1, "pod_nm") + ")"
			+ "<br>VVD/VESSEL NAME : " 
			+ document.getElementById("tvvd").value + " ( "
			+ document.getElementById("vessel_nm").value + "&nbsp;"
			+ document.getElementById("tvvd").value.substring(4, 9) + " ) "
			+ "<br>----------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";

	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		var crn_pst_sts = "";
		var cntr_seq = "";
		if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") != "C") {
			if (sheetObjects[1].CellValue(i, "seq") == "1"){
				cntr_seq = "st";
			} else if (sheetObjects[1].CellValue(i, "seq") == "2"){
				cntr_seq = "nd";
			} else if (sheetObjects[1].CellValue(i, "seq") == "3"){
				cntr_seq = "rd";
			} else {
				cntr_seq = "th";
			}
			content += "1. Container SEQ           : " + sheetObjects[1].CellValue(i, "seq") + cntr_seq + " CNTR of&nbsp;" 
														+ sheetObjects[1].RowCount + "&nbsp;CNTR(s)<br>";
			content += "2. EQ Type/Size            : " + sheetObjects[1].CellValue(i, "eq_tpsz") + "<br>";
			content += "3. Commodity               : " + sheetObjects[1].CellValue(i, "cmdt_nm") + "<br>";
			content += "4. Gross Weight            : " + sheetObjects[1].CellText(i, "grs_wgt") + sheetObjects[1].CellValue(i, "wgt_ut_cd") + "<br>";
			content += "5. Net Weight              : " + sheetObjects[1].CellText(i, "net_wgt") + sheetObjects[1].CellValue(i, "wgt_ut_cd") + "<br>";
			content += "6. Overall Dimension(in cm): " + " (Length x Width x Height)<br>" 
													   + "&nbsp;&nbsp;1)Total: " + sheetObjects[1].CellValue(i, "ttl_dim_len") + "X"
													   + sheetObjects[1].CellValue(i, "ttl_dim_wdt") + "X"
													   + sheetObjects[1].CellValue(i, "ttl_dim_hgt")
													   + "<br>&nbsp;&nbsp;2)Detail:&nbsp;";
			if(sheetObjects[3].RowCount > 0){
				for ( var j = 1; j <= sheetObjects[3].RowCount; j++){
					if(sheetObjects[3].CellValue(j, "awk_cgo_seq") == i){
						dim_seq = sheetObjects[3].CellValue(j, "dim_seq");
						if(dim_seq != "1")
							content += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						content += String.fromCharCode(+dim_seq+64) + ".&nbsp;" + sheetObjects[3].CellValue(j, "dim_len") + 
								   "X" + sheetObjects[3].CellValue(j, "dim_wdt") + "X" + sheetObjects[3].CellValue(j, "dim_hgt") + 
								   ",&nbsp;&nbsp;"+ sheetObjects[3].CellText(j, "indiv_pck_wgt") + 
								   sheetObjects[1].CellValue(i, "wgt_ut_cd") + "<br>";
					}
				}
			}else {
				content += "<br>";
			}
			
			content += "7. Over Dimension (in cm)  : " + "<br>&nbsp;&nbsp;1) Forward:" + sheetObjects[1].CellValue(i, "ovr_fwrd_len") 
													   + "<br>&nbsp;&nbsp;2) After: " + sheetObjects[1].CellValue(i, "ovr_bkwd_len")
													   + "<br>&nbsp;&nbsp;3) Height:" + sheetObjects[1].CellValue(i, "ovr_hgt")
													   + "<br>&nbsp;&nbsp;4) Left (Port Side):" + sheetObjects[1].CellValue(i, "ovr_lf_len")
													   + "<br>&nbsp;&nbsp;5) Right (Starboard): " + sheetObjects[1].CellValue(i, "ovr_rt_len") + "<br>";
			if( sheetObjects[1].CellValue(i, "crn_pst_sts_cd") == "E" ){
				crn_pst_sts = "Erect-No Extension";
			} else if( sheetObjects[1].CellValue(i, "crn_pst_sts_cd") == "F" ){
				crn_pst_sts = "FOLDING";
			} else {
				crn_pst_sts += sheetObjects[1].CellValue(i, "crn_pst_sts_cd") + " Feet Extension"; 
			}
			
			content += "8. Corner Post Status      : " + crn_pst_sts + "<br>";
			content += "9. Over Height after Extension : " + sheetObjects[1].CellValue(i, "xtd_ovr_qty") + "<br>";
			content += "10. Special Stowage Requirement : " + document.getElementById("stwg_cd").value +"("+sheetObjects[1].CellValue(i, "stwg_rqst_desc") + ")<br>";
			content += "11. Remarks                 : " + sheetObjects[1].CellText(i, "diff_rmk") + "<br>";
			content += "<br>----------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";
		}
	}
	document.form.com_content.value = content;
	ComSendMailModal();
}

/* 개발자 작업  끝 */