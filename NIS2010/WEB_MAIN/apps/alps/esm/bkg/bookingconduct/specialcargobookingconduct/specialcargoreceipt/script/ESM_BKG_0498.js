/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0498.js
 *@FileTitle : Reefer Cargo Application
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
 2011.03.28 변종건 [CHM-201109427-01] [BKG] BKG Main 화면에서 Special(Reefer) cargo 변경 시 PSA로 변경 내용 I/F 요청
 2011.05.11 변종건 [CHM-201110122-01][AK, RF] CNTR#부재상태의 Approval Pending시 CNTR#입력가능
 2012.02.01 변종건 [CHM-201215892-01] DG Remark 추가 에러 사항 개선 요청
 2012.02.28 변종건 [CHM-201216422-01] SPECIAL CARGO 기능 보완 요청
 2012.09.25 조정민 [CHM-201220178-01] BKG의 RF Application 화면의 RF 온도 관련 request 시  Alert 메세지 요청
 2012.10.15 조정민 [CHM-201220509] [Special Cargo Application] Email기능 추가 - RF,AK (DG기존재)
 2013.02.13 류대영 [CHM-201322998] ALPS BKG Reefer 화면 Pop-Up Message 설정 요청
 2013.12.05 김보배 [CHM-201327753] "At Risk" RF Booking Validation 추가 요청
 2014.06.23 김보배 [CHM-201430716] At Risk container Validation 철회
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
 * @class esm_bkg_0498 : esm_bkg_0498 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0498() {
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
var tempVentChangeFlag = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
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
				// IBSAVE 에서 해당 booking 번호에 대한 쿼리 실행 후 CLL_VVD 가 존재하면 모든 Opertaion 종료.
				bReturn = doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				if (bReturn == false) return;
				if (retFlag == "Y") {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
			}
			break;

		case "btn_Request":
			document.getElementById("button").value = "N";
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				chkFlg = "N";
				messageFlg = "request";
				reqFlag = "N";
				retFlag = "";
				var tempFlg = "N";
				var iCnt = 0;
				var uCnt = 0;
				var dCnt = 0;
				var ncCnt = 0;
				var rCnt = 0;
				var yCnt = 0;
				var reqCnt = 0;
				var cntR = 0;
				for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
					if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") != "C") {
						reqCnt++;
					}
				}
				if (reqCnt < 1) {
					ComShowMessage(ComGetMsg("BKG08107"));
					return;
				}
				
				for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
					if (sheetObjects[1].CellValue(i, "ibflag") != "R") {
						cntR++;
					}

					if(sheetObjects[1].CellValue(i, "cdo_temp") <= -30){
						tempFlg = "Y";
					}
				}
				
				if (tempFlg == "Y")
					ComShowMessage(ComGetMsg("BKG02206"));

				if (cntR > 0 && sheetObjects[2].CellValue(1, "bdr_flg") == "Y" && sheetObjects[2].CellValue(1, "corr_no") != "") {
					ComShowMessage(ComGetMsg("BKG08076"));
					return;
				}
				
				iCnt = sheetObjects[1].FindText("ibflag", "I", 0, 2);
				uCnt = sheetObjects[1].FindText("ibflag", "U", 0, 2);
				dCnt = sheetObjects[1].FindText("ibflag", "D", 0, 2);
				if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
					if (sheetObjects[2].CellValue(1, "bdr_flg") != "Y" && sheetObjects[2].CellValue(1, "corr_no") == "") {
						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
						// IBSAVE 에서 해당 booking 번호에 대한 쿼리 실행 후 CLL_VVD 가 존재하면 모든 Opertaion 종료.
						bReturn = doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
						if (bReturn == false) return;
						//}else{
						//	return;
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
					for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
						if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "P") {
							ComShowMessage(ComGetMsg("BKG00500"));
							return;
						}
						if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "N" || sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "C") {
							ncCnt++;
						}
						if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "R") {
							rCnt++;
						}
						if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "Y") {
							yCnt++;
						}
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

					for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
						if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") != "C") {
							sheetObjects[1].CellValue2(i, "apro_cd") = "R";
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
				messageFlg = "requestCancel";
				reqFlag = "N";
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
				iCnt = sheetObjects[1].FindText("ibflag", "I", 0, 2);
				uCnt = sheetObjects[1].FindText("ibflag", "U", 0, 2);
				dCnt = sheetObjects[1].FindText("ibflag", "D", 0, 2);
				if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
					if (sheetObjects[2].CellValue(1, "bdr_flg") != "Y" && sheetObjects[2].CellValue(1, "corr_no") == "") {
						//if(ComShowConfirm(ComGetMsg("BKG00824"))){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
						//}else{
						//	return;
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

				if (ComShowConfirm(ComGetMsg("BKG00613", sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "Seq")))) {
					/*
					for(var i=1; i<=sheetObjects[1].RowCount; i++){				 		  		  
						  if(sheetObjects[1].CellValue(i,"spcl_cgo_apro_cd") != "C"){
							  sheetObjects[1].CellValue2(i,"apro_cd") = "R";
						  }else{
							  sheetObjects[1].CellValue2(i,"apro_cd") = "C";
						  }
					}	
					 */
					sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "apro_cd") = "C";

					doActionIBSheet(sheetObjects[0], document.form, COMMAND02);

					if (retFlag == "Y") {
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}
				} else {
					return;
				}
			}
			break;

		case "btn_Copy":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				if (document.getElementById("auth_cd").value == "P"){
					ComShowMessage(ComGetMsg("BKG00500"));
					return;
				}
				
				var url = "ESM_BKG_0720.do";
				ComOpenWindowCenter(url, "ESM_BKG_0720", 320, 180, true);
			}
			break;
			
			//e-mail 전송
		case "btn_email":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				sendMail();
			}
			break;

		case "btn_Remark":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				var url = "ESM_BKG_0757.do";
				ComOpenWindowCenter(url, "ESM_BKG_0757", 420, 350, true);
			}
			break;

		case "btn_add":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				if (document.getElementById("auth_cd").value == "P"){
					ComShowMessage(ComGetMsg("BKG00500"));
					return;
				}				
				checkAdd();
			}
			break;

		case "btn_delete":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				deleteRows();
			}
			break;

		case "cmdt_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("ESM_BKG_0653.do?cmdt_cd=" + formObject.cmdt_cd.value, 820, 690, "getCOM_CMDT_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0653");
			}
			break;

		case "pck_button":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				comBkgCallModal0696("callbackPckTp", formObject.pck_tp_cd.value);
			}
			break;

		case "btn_approval":
			if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("VOP_SCG_1018.do?scg_flg=RF&bkg_no=" + formObject.bkg_no.value, 1000, 490, "", '0,0', true);
			}
			break;

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
					ComOpenWindowCenter(url, "ESM_BKG_0754", 800, 320, true);
				}
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

	//------------------------------------------------>
	//setInquiryDisableButton 이벤트 호출
	if (ComGetObjValue(document.form.isInquiry) == "Y") {
		setInquiryDisableButton();
	}
	initControl();
}

function bkgSplitNoList(split_list) {
	document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
	layList.style.display = "none";
}

function getCOM_CMDT_POPUP(rowArray) {
	var formObject = document.form;
	var colArray = rowArray[0];
	formObject.cmdt_cd.value = colArray[3];
	sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cmdt_cd") = colArray[3];
	formObject.cmdt_nm.value = colArray[4];
	sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "cmdt_desc") = colArray[4];
	sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "modifyaproflg") = "Y";
}

function callbackPckTp(returnVal) {
	document.form.pck_tp_cd.value = returnVal[0][2];
	sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "pck_tp_cd") = returnVal[0][2];
}

function checkAdd() {
	if (sheetObjects[1].RowCount > 0) {
		var seqVal = Number(sheetObjects[1].CellValue(1, "rc_seq"));
	} else {
		var seqVal = 0;
	}

	for ( var k = 1; k <= sheetObjects[1].RowCount; k++) {
		if (seqVal < Number(sheetObjects[1].CellValue(k, "rc_seq"))) {
			seqVal = sheetObjects[1].CellValue(k, "rc_seq");
		}
	}

	var Row = sheetObjects[1].DataInsert(-1);
	sheetObjects[1].CellValue2(Row, "rc_seq") = Number(seqVal) + 1;
	sheetObjects[1].CellValue2(Row, "bkg_no") = document.getElementById("bkg_no").value;
	sheetObjects[1].CellValue2(Row, "ctrl_atms_flg") = "N";
	sheetObjects[1].CellValue2(Row, "modi_atms_flg") = "N";
	sheetObjects[1].CellValue2(Row, "humid_ctrl_flg") = "N";
	sheetObjects[1].CellValue2(Row, "atfc_atms_flg") = "N";
//  2010.07.23 수정-화면 Default삭제(CHM-201004544-01)
//	sheetObjects[1].CellValue2(Row, "cdo_temp") = "0";  
//	sheetObjects[1].CellValue2(Row, "fdo_temp") = "32";
//	document.getElementById("cdo_temp").value = "0";
//	document.getElementById("fdo_temp").value = "32";
	sheetObjects[1].CellValue2(Row, "cdo_temp") = "";
	sheetObjects[1].CellValue2(Row, "fdo_temp") = "";
	document.getElementById("cdo_temp").value = "";
	document.getElementById("fdo_temp").value = "";
	sheetObjects[1].CellValue2(Row, "cmdt_cd") = sheetObjects[2].CellValue(1, "cmdt_cd");
	sheetObjects[1].CellValue2(Row, "cmdt_desc") = sheetObjects[2].CellValue(1, "cmdt_nm");
	sheetObjects[1].CellValue2(Row, "cntr_vent_tp_cd") = "P";
	document.getElementById("cntr_vent_tp_cd").value = "P";
	sheetObjects[1].CellValue2(Row, "vent_rto") = "";
	document.getElementById("vent_rto").value = "";
	sheetObjects[1].CellValue2(Row, "vltg_no") = "0";

	var row = 0;
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
			row++;
			sheetObjects[1].CellValue2(i, "Seq") = row;
		}
	}

	htmlSheetSync();

	var cntr_name = "";
	var cntr_val = "";
	for ( var j = 1; j <= sheetObjects[3].RowCount; j++) {
		if (sheetObjects[3].CellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[3].CellValue(j, "name") + "|";
			cntr_val += sheetObjects[3].CellValue(j, "val") + "|";
		}
	}
	cntr_val = cntr_val.substr(0, cntr_val.length - 1);
	cntr_name = cntr_name.substr(0, cntr_name.length - 1);
	sheetObjects[1].CellComboItem(Row, "cntr_no", " |" + cntr_name, " |" + cntr_val);
}

function deleteRows() {
	for ( var k = 1; k <= sheetObjects[1].RowCount; k++) {
		if (sheetObjects[1].CellValue(k, "DelChk") == "1") {
			if (sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "P" || sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "R" || sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "Y" || sheetObjects[1].CellValue(k, "spcl_cgo_apro_cd") == "N") {
				ComShowMessage(ComGetMsg("BKG00525"));
				return;
			}
		}
	}

	var find_row = 0;
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "DelChk") == "1") {
			var temp_cntr_no = sheetObjects[1].CellValue(i, "cntr_no");
			var temp_find_row = sheetObjects[3].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[3].CellValue(temp_find_row, "DelChk") = "0";
			}
		}
	}

	var drow = ComRowHideDelete(sheetObjects[1], "DelChk");
	var cntr_name = "";
	var cntr_val = "";
	for ( var j = 1; j <= sheetObjects[3].RowCount; j++) {
		if (sheetObjects[3].CellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[3].CellValue(j, "name") + "|";
			cntr_val += sheetObjects[3].CellValue(j, "val") + "|";
		}
	}

	cntr_val = cntr_val.substr(0, cntr_val.length - 1);
	cntr_name = cntr_name.substr(0, cntr_name.length - 1);
	var cnt = 0;
	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		sheetObjects[1].CellComboItem(i, "cntr_no", sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_name + "| ", sheetObjects[1].CellValue(i, "cntr_no") + "|" + cntr_val + "| ");
		if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
			cnt++;
			sheetObjects[1].CellValue2(i, "Seq") = cnt;
		}
	}

	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
			sheetObjects[1].SelectCell(i, 0, false);
			htmlSheetSync();
			return;
		} else {
			find_row++;
		}
	}

	if (find_row == sheetObjects[1].RowCount) {
		document.getElementById("seq").value = "0";
		document.getElementById("cmdt_cd").value = "";
		document.getElementById("cmdt_nm").value = "";
		document.getElementById("cdo_temp").value = "";
		document.getElementById("fdo_temp").value = "";
		document.getElementById("vent_rto").value = "";
		document.getElementById("humid_no").value = "0";
		document.getElementById("pck_qty").value = "0";
		document.getElementById("grs_wgt").value = "0";
		document.getElementById("net_wgt").value = "0";
		document.getElementById("wgt_ut_cd1").value = "KGS";
		document.getElementById("wgt_ut_cd2").value = "KGS";
		document.getElementById("ctrl_atms_flg").checked = false;
		document.getElementById("modi_atms_flg").checked = false;
		document.getElementById("humid_ctrl_flg").checked = false;
		document.getElementById("atfc_atms_flg").checked = false;
		document.getElementById("cntr_drn_cd").value = "N";
		document.getElementById("clng_tp_cd").value = "";
		document.getElementById("aply_no").value = "";
	}
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
				sheetObjects[1].CellValue2(row, "cmdt_cd") = cmdt_cd;
			}
			if (cmdtFlg == "") {
				doActionIBSheet(sheetObjects[0], document.form, COMMAND05);
				// cmdt_cd에서 tab으로 하여 name바꿀 경우 변경되지 않는 문제가 있어 추가
				// 2010.06.08 cateshin
				sheetObjects[1].CellValue2(row, "cmdt_desc") = document.getElementById("cmdt_nm").value;
			}
		}
		break;
	}
}

function copyCnt(copyCnt) {
	for ( var i = 1; i <= copyCnt; i++) {
		var seqVal = Number(sheetObjects[1].CellValue(1, "rc_seq"));
		for ( var k = 1; k <= sheetObjects[1].RowCount; k++) {
			if (seqVal < Number(sheetObjects[1].CellValue(k, "rc_seq"))) {
				seqVal = sheetObjects[1].CellValue(k, "rc_seq");
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
		sheetObjects[1].CellValue2(Row, "rc_seq") = Number(seqVal) + 1;
		sheetObjects[1].CellValue2(Row, "spcl_cgo_apro_cd") = "";
		sheetObjects[1].CellValue2(Row, "DelChk") = "0";
		var rows = 0;
		for ( var m = 1; m <= sheetObjects[1].RowCount; m++) {
			if (sheetObjects[1].CellValue(m, "ibflag") != "D") {
				rows++;
				sheetObjects[1].CellValue2(m, "Seq") = rows;
			}
		}
		var cntr_name = "";
		var cntr_val = "";
		var temp_cntr_no = sheetObjects[1].CellValue(Row, "cntr_no");
		var temp_find_row = sheetObjects[3].FindText("name", temp_cntr_no, 0, 2);
		for ( var j = 1; j <= sheetObjects[3].RowCount; j++) {
			if (sheetObjects[3].CellValue(j, "DelChk") == "0") {
				cntr_name += sheetObjects[3].CellValue(j, "name") + "|";
				cntr_val += sheetObjects[3].CellValue(j, "val") + "|";
			}
		}
		cntr_val = cntr_val.substr(0, cntr_val.length - 1);
		cntr_name = cntr_name.substr(0, cntr_name.length - 1);
		sheetObjects[1].CellComboItem(Row, "cntr_no", " |" + cntr_name, " |" + cntr_val);
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

function obj_keypress() {
	switch (event.srcElement.name) {

	case "pck_qty":
		ComKeyOnlyNumber(event.srcElement);
		break;

	case "grs_wgt":
		ComKeyOnlyNumber(event.srcElement, "-.");
		break;

	case "net_wgt":
		ComKeyOnlyNumber(event.srcElement, "-.");
		break;

	case "cdo_temp":
		ComKeyOnlyNumber(event.srcElement, ".");
		break;

	case "fdo_temp":
		ComKeyOnlyNumber(event.srcElement, ".");
		break;

	case "cmdt_cd":
		ComKeyOnlyNumber(event.srcElement);
		break;
		
    case "vent_rto":
        ComKeyOnlyNumber(event.srcElement, ".");
        break;

	case "humid_no":
		ComKeyOnlyNumber(event.srcElement);
		break;

	case "rf_dcgo_seq":
		ComKeyOnlyNumber(event.srcElement);
		break;
	}
}

function obj_keyup() {
	pendingSaveFlg = "N"; //Approval이 Pending 상태일 때는 Container No를 제외한 나머지 모든 값은 신규 또는 수정이 되지 않게 상태 확인하는 Flag
	
	var row = sheetObjects[1].SelectRow;
	switch (event.srcElement.name) {

	case "grs_wgt":
		if (document.getElementById("grs_wgt").value.length > 7) {
			if (document.getElementById("grs_wgt").value.indexOf(".") > -1) {
			} else {
				document.getElementById("grs_wgt").value = document.getElementById("grs_wgt").value.substr(0, 7);
			}
		}
		sheetObjects[1].CellValue2(row, "grs_wgt") = document.getElementById("grs_wgt").value;
		break;

	case "net_wgt":
		if (document.getElementById("net_wgt").value.length > 7) {
			if (document.getElementById("net_wgt").value.indexOf(".") > -1) {
			} else {
				document.getElementById("net_wgt").value = document.getElementById("net_wgt").value.substr(0, 7);
			}
		}
		sheetObjects[1].CellValue2(row, "net_wgt") = document.getElementById("net_wgt").value;
		break;

	case "cmdt_cd":
		sheetObjects[1].CellValue2(row, "cmdt_cd") = document.getElementById("cmdt_cd").value;
		break;

	case "cmdt_nm":
		sheetObjects[1].CellValue2(row, "cmdt_desc") = document.getElementById("cmdt_nm").value;
		break;

	case "cdo_temp":
		sheetObjects[1].CellValue2(row, "cdo_temp") = document.getElementById("plusMinus1").value+document.getElementById("cdo_temp").value;
		break;

	case "fdo_temp":
		sheetObjects[1].CellValue2(row, "fdo_temp") = document.getElementById("plusMinus2").value+document.getElementById("fdo_temp").value;
		break;

	case "vent_rto":
		if (sheetObjects[1].CellValue(row, "cntr_vent_tp_cd") == "P") {
			sheetObjects[1].CellValue2(row, "vent_rto") = document.getElementById("vent_rto").value;
		} else {
			sheetObjects[1].CellValue2(row, "cbm_per_hr_qty") = document.getElementById("vent_rto").value;
		}
		break;

	case "pck_tp_cd":
		sheetObjects[1].CellValue2(row, "pck_tp_cd") = document.getElementById("pck_tp_cd").value;
		break;

	case "humid_no":
		sheetObjects[1].CellValue2(row, "humid_no") = document.getElementById("humid_no").value;
		break;

	case "pck_qty":
		sheetObjects[1].CellValue2(row, "pck_qty") = document.getElementById("pck_qty").value;
		break;

	case "pck_tp_cd":
		sheetObjects[1].CellValue2(row, "pck_tp_cd") = document.getElementById("pck_tp_cd").value;
		break;

	case "rf_dcgo_seq":
		sheetObjects[1].CellValue2(row, "cntr_cgo_seq") = document.getElementById("rf_dcgo_seq").value;
		sheetObjects[1].CellValue2(row, "rf_dcgo_seq") = document.getElementById("rf_dcgo_seq").value;
		break;

	}
}

function obj_blur() {
	var row = sheetObjects[1].SelectRow;
	switch (event.srcElement.name) {

	case "net_wgt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("net_wgt").value = sheetObjects[1].CellText(row, "net_wgt");
			if (Number(document.getElementById("grs_wgt").value.replaceStr(",")) < Number(document.getElementById("net_wgt").value.replaceStr(","))) {
				ComAlertFocus(document.getElementById("net_wgt"), ComGetMsg("BKG00491"));
				document.getElementById("net_wgt").value = document.getElementById("temp_net_wgt").value;
				sheetObjects[1].CellValue(row, "net_wgt") = document.getElementById("temp_net_wgt").value;
			} else {
				document.getElementById("temp_net_wgt").value = sheetObjects[1].CellText(row, "net_wgt");
			}
			sheetObjects[1].CellValue2(row, "modifyaproflg") = "Y";
		}
		break;

	case "grs_wgt":
		if (document.getElementById("bkg_no").value != "") {
			document.getElementById("grs_wgt").value = sheetObjects[1].CellText(row, "grs_wgt");
			if (Number(document.getElementById("grs_wgt").value.replaceStr(",")) < Number(document.getElementById("net_wgt").value.replaceStr(","))) {
				ComAlertFocus(document.getElementById("grs_wgt"), ComGetMsg("BKG00491"));
				document.getElementById("grs_wgt").value = document.getElementById("temp_grs_wgt").value;
				sheetObjects[1].CellValue(row, "grs_wgt") = document.getElementById("temp_grs_wgt").value;
			} else {
				document.getElementById("temp_grs_wgt").value = sheetObjects[1].CellText(row, "grs_wgt")
			}
			sheetObjects[1].CellValue2(row, "modifyaproflg") = "Y";
		}
		break;
	}
}

function obj_change() {
	var row = sheetObjects[1].SelectRow;
	var temp = 0;
	switch (event.srcElement.name) {
	
	case "vent_rto":
		tempVentChangeFlag = "Y";
		break;
		
	case "cntr_vent_tp_cd":
		sheetObjects[1].CellValue(Row, "cntr_vent_tp_cd") = document.getElementById("cntr_vent_tp_cd").value;
		if (sheetObjects[1].CellValue(Row, "cntr_vent_tp_cd") == "P") {
			sheetObjects[1].CellValue2(row, "vent_rto") = document.getElementById("vent_rto").value;
			sheetObjects[1].CellValue2(row, "cbm_per_hr_qty") = "";
		} else {
			sheetObjects[1].CellValue2(row, "cbm_per_hr_qty") = document.getElementById("vent_rto").value;
			sheetObjects[1].CellValue2(row, "vent_rto") = "";
		}
		tempVentChangeFlag = "Y";
		break;

	case "wgt_ut_cd1":
		document.getElementById("wgt_ut_cd2").value = document.getElementById("wgt_ut_cd1").value;
		sheetObjects[1].CellValue2(row, "wgt_ut_cd") = document.getElementById("wgt_ut_cd1").value;
		break;

	case "cntr_drn_cd":
		sheetObjects[1].CellValue2(row, "cntr_drn_cd") = document.getElementById("cntr_drn_cd").value;
		break;

	case "pck_tp_cd":
		sheetObjects[1].CellValue2(row, "pck_tp_cd") = (document.getElementById("pck_tp_cd").value).toUpperCase();
		document.getElementById("pck_tp_cd").value = sheetObjects[1].CellValue(row, "pck_tp_cd");
		break;

	case "clng_tp_cd":
		sheetObjects[1].CellValue2(row, "clng_tp_cd") = document.getElementById("clng_tp_cd").value;
		break;

	case "plusMinus1":
		if (document.getElementById("plusMinus1").value == "-") {
			sheetObjects[1].CellValue2(row, "cdo_temp") = document.getElementById("plusMinus1").value + document.getElementById("cdo_temp").value;
		} else {
			sheetObjects[1].CellValue2(row, "cdo_temp") = document.getElementById("cdo_temp").value;
		}
		if (document.getElementById("cdo_temp").value == "0") {
			sheetObjects[1].CellValue2(row, "cdo_temp") = document.getElementById("cdo_temp").value;
		}
		if (document.getElementById("plusMinus1").value == "-") {
			temp = document.getElementById("plusMinus1").value + document.getElementById("cdo_temp").value;
		} else {
			temp = document.getElementById("cdo_temp").value;
		}
		
		var fdo_temp = (9 / 5) * parseFloat(temp) + 32; 
		
		if (String(fdo_temp).indexOf("-") > -1) {
			document.getElementById("plusMinus2").value = "-";
			sheetObjects[1].CellValue2(row, "fdo_temp") = fdo_temp;
			document.getElementById("fdo_temp").value = sheetObjects[1].CellValue(row, "fdo_temp").replace("-", "");
		} else {
			document.getElementById("plusMinus2").value = "+";
			sheetObjects[1].CellValue2(row, "fdo_temp") = fdo_temp;
			document.getElementById("fdo_temp").value = sheetObjects[1].CellValue(row, "fdo_temp");
		}
		tempVentChangeFlag = "Y";
		break;

	case "plusMinus2":
		if (document.getElementById("plusMinus2").value == "-") {
			sheetObjects[1].CellValue2(row, "fdo_temp") = document.getElementById("plusMinus2").value + document.getElementById("fdo_temp").value;
		} else {
			sheetObjects[1].CellValue2(row, "fdo_temp") = document.getElementById("fdo_temp").value;
		}
		if (document.getElementById("fdo_temp").value == "0") {
			sheetObjects[1].CellValue2(row, "fdo_temp") = document.getElementById("fdo_temp").value;
		}
		if (document.getElementById("plusMinus2").value == "-") {
			temp = document.getElementById("plusMinus2").value + document.getElementById("fdo_temp").value;
		} else {
			temp = document.getElementById("fdo_temp").value;
		}
		
		var cdo_temp = ((5 * parseFloat(temp) ) - 160) / 9; 
		
		if (String(cdo_temp).indexOf("-") > -1) {
			document.getElementById("plusMinus1").value = "-";
			sheetObjects[1].CellValue2(row, "cdo_temp") = cdo_temp;
			document.getElementById("cdo_temp").value = sheetObjects[1].CellValue(row, "cdo_temp").replace("-", "");
		} else {
			document.getElementById("plusMinus1").value = "+";
			sheetObjects[1].CellValue2(row, "cdo_temp") = cdo_temp;
			document.getElementById("cdo_temp").value = sheetObjects[1].CellValue(row, "cdo_temp");
		}
		tempVentChangeFlag = "Y";
		break;

	case "cdo_temp":
		if (document.getElementById("plusMinus1").value == "-") {
			sheetObjects[1].CellValue2(row, "cdo_temp") = document.getElementById("plusMinus1").value + document.getElementById("cdo_temp").value;
		} else {
			sheetObjects[1].CellValue2(row, "cdo_temp") = document.getElementById("cdo_temp").value;
		}
		if (document.getElementById("cdo_temp").value == "0") {
			sheetObjects[1].CellValue2(row, "cdo_temp") = document.getElementById("cdo_temp").value;
		}
		if (document.getElementById("plusMinus1").value == "-") {
			temp = document.getElementById("plusMinus1").value + document.getElementById("cdo_temp").value;
		} else {
			temp = document.getElementById("cdo_temp").value;
		}
		
		var fdo_temp = (9 / 5) * parseFloat(temp) + 32;  
	  
		if (String(fdo_temp).indexOf("-") > -1) {
			document.getElementById("plusMinus2").value = "-";
			sheetObjects[1].CellValue2(row, "fdo_temp") = fdo_temp;
			document.getElementById("fdo_temp").value = sheetObjects[1].CellValue(row, "fdo_temp").replace("-", "");
		} else {
			document.getElementById("plusMinus2").value = "+";
			sheetObjects[1].CellValue2(row, "fdo_temp") = fdo_temp;
			document.getElementById("fdo_temp").value = sheetObjects[1].CellValue(row, "fdo_temp");
		}
		tempVentChangeFlag = "Y";
		break;

	case "fdo_temp":
		if (document.getElementById("plusMinus2").value == "-") {
			sheetObjects[1].CellValue2(row, "fdo_temp") = document.getElementById("plusMinus2").value + document.getElementById("fdo_temp").value;
		} else {
			sheetObjects[1].CellValue2(row, "fdo_temp") = document.getElementById("fdo_temp").value;
		}
		if (document.getElementById("fdo_temp").value == "0") {
			sheetObjects[1].CellValue2(row, "fdo_temp") = document.getElementById("fdo_temp").value;
		}
		if (document.getElementById("plusMinus2").value == "-") {
			temp = document.getElementById("plusMinus2").value + document.getElementById("fdo_temp").value;
		} else {
			temp = document.getElementById("fdo_temp").value;
		}
		
		var cdo_temp = ((5 * parseFloat(temp)) - 160) / 9; 
	
		if (String(cdo_temp).indexOf("-") > -1) {
			document.getElementById("plusMinus1").value = "-";
			sheetObjects[1].CellValue2(row, "cdo_temp") = cdo_temp
			document.getElementById("cdo_temp").value = sheetObjects[1].CellValue(row, "cdo_temp").replace("-", "");
		} else {
			document.getElementById("plusMinus1").value = "+";
			sheetObjects[1].CellValue2(row, "cdo_temp") = cdo_temp;
			document.getElementById("cdo_temp").value = sheetObjects[1].CellValue(row, "cdo_temp");
		}
		tempVentChangeFlag = "Y";
		break;
	}
}

function obj_click() {
	var row = sheetObjects[1].SelectRow;
	switch (event.srcElement.name) {

	case "ctrl_atms_flg":
		if (document.getElementById("ctrl_atms_flg").checked == true) {
			sheetObjects[1].CellValue(row, "ctrl_atms_flg") = "Y";
		} else {
			sheetObjects[1].CellValue(row, "ctrl_atms_flg") = "N";
		}
		break;

	case "modi_atms_flg":
		if (document.getElementById("modi_atms_flg").checked == true) {
			sheetObjects[1].CellValue(row, "modi_atms_flg") = "Y";
		} else {
			sheetObjects[1].CellValue(row, "modi_atms_flg") = "N";
		}
		break;

	case "humid_ctrl_flg":
		if (document.getElementById("humid_ctrl_flg").checked == true) {
			sheetObjects[1].CellValue(row, "humid_ctrl_flg") = "Y";
		} else {
			sheetObjects[1].CellValue(row, "humid_ctrl_flg") = "N";
		}
		break;

	case "atfc_atms_flg":
		if (document.getElementById("atfc_atms_flg").checked == true) {
			sheetObjects[1].CellValue(row, "atfc_atms_flg") = "Y";
		} else {
			sheetObjects[1].CellValue(row, "atfc_atms_flg") = "N";
		}
		break;
		
	case "grs_wgt":
		if (sheetObjects[1].CellValue(row, "grs_wgt") == "0") {
			document.getElementById("grs_wgt").value = "";
		}
		break;

	case "net_wgt":
		if (sheetObjects[1].CellValue(row, "net_wgt") == "0") {
			document.getElementById("net_wgt").value = "";
		}
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
			var HeadTitle1 = "TP/SZ|BKG Q'ty|RF Q'ty";
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtData, 110, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daRight, true, "op_cntr_qty", false, "", dfFloat, 2, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daRight, false, "rf_cgo_qty", false, "", dfFloat, 2, false, true);
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
			InitRowInfo(1, 1, 4, 100);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(43, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false, false)
			var HeadTitle1 = "|ibflag|Seq.|Container No.|TS|Vol.|Genset|Volt|Appr.|bkg_no|rc_seq|cmdt_cd|cmdt_nm|cdo_temp|" + "fdo_temp|clng_tp_cd|cntr_vent_tp_cd|vent_rto|cbm_per_hr_qty|humid_no|pck_qty|grs_wgt|pck_tp_cd|net_wgt|wgt_ut_cd|" + "rf_dcgo_seq|ctrl_atms_flg|modi_atms_flg|humid_ctrl_flg|atfc_atms_flg|cntr_drn_cd|diff_rmk|modifyaproflg|por_cd|del_cd|rcv_term_cd|de_term_cd|apro_cd|vvd|eq_tpsz";
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtDummyCheck, 20, daCenter, false, "DelChk");
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtCombo, 95, daCenter, true, "cntr_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, true, true, 2, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "cntr_vol_qty", false, "", dfFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 65, daCenter, false, "pwr_spl_cbl_flg", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 35, daCenter, false, "vltg_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "spcl_cgo_apro_cd", false, "", dfNone, 0, false);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "bkg_no", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "rc_seq", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "cmdt_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "cmdt_desc", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "cdo_temp", false, "", dfFloat, 1, true); 
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "fdo_temp", false, "", dfFloat, 1, true); 
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "clng_tp_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "cntr_vent_tp_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "vent_rto", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "cbm_per_hr_qty", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "humid_no", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "pck_qty", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "grs_wgt", false, "", dfFloat, 3, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "pck_tp_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "net_wgt", false, "", dfFloat, 3, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "wgt_ut_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "rf_dcgo_seq", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "ctrl_atms_flg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "modi_atms_flg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "humid_ctrl_flg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "atfc_atms_flg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "cntr_drn_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "diff_rmk", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "modifyaproflg", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "cntr_cgo_seq", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "por_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "del_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "rcv_term_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "de_term_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "apro_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "rqst_usr_id", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "aply_no", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, false, "vsl_cd", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtHidden, 20, daCenter, true, "eq_tpsz", false, "", dfNone, 0, false, true);
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
			InitColumnInfo(21, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, false, true, false, false)
			var HeadTitle1 = "bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|rcv_term_cd|de_term_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|corr_no|vessel_nm";
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
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "cmdt_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "cmdt_nm", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "vsl_pre_pst_cd", false, "", dfNone, 2, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "vessel_nm", false, "", dfNone, 2, true, true);
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

 /**
 * fnCheckFdoTemp 함수호출 .<br>
 * @param _val
 * @return string
 */
function fnCheckFdoTemp(_val) {
	var r_fvalue = (9 / 5) * parseFloat(_val) + 32; 
 	return r_fvalue;
}
 
function fnCheckCdoTemp(_val) {
	var r_fvalue = ((5 * parseFloat(_val) ) - 160) / 9; 
 	return r_fvalue;
}
 
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = SEARCH;
		}
		var resultXml = sheetObj.GetSearchXml("ESM_BKG_0498GS.do", FormQueryString(formObj));
		var arrXml = resultXml.split("|$$|");
		if (arrXml.length == 4) {
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

			if (arrXml[3].indexOf("TOTAL='0'") < 1) {
				var arrCombo = ComXml2ComboString(arrXml[3], "val", "name");
				sheetObjects[1].InitDataCombo(0, "cntr_no", " |" + arrCombo[0], " |" + arrCombo[1], "");
			}

			sheetObjects[0].LoadSearchXml(arrXml[1], false);
			sheetObjects[1].LoadSearchXml(arrXml[0], false);
			sheetObjects[2].LoadSearchXml(arrXml[2], false);
			sheetObjects[3].LoadSearchXml(arrXml[3], false);
			
			formObj.kr_flag.value = ComGetEtcData(arrXml[0], "kr_flag") ;
			formObj.cmdt_flag.value = ComGetEtcData(arrXml[0], "cmdt_flag") ;
			formObj.desc_flag.value = ComGetEtcData(arrXml[0], "desc_flag") ;
			formObj.co_flag.value = ComGetEtcData(arrXml[0], "co_flag") ;

			if (document.getElementById("bkg_no").value == "") {
				document.getElementById("bkg_no").value = sheetObjects[1].CellValue(1, "bkg_no");
			}

			document.getElementById("bl_no").value = sheetObjects[2].CellValue(1, "bl_no");
			document.getElementById("tvvd").value = sheetObjects[2].CellValue(1, "vsl_cd");
			document.getElementById("pol_cd").value = sheetObjects[2].CellValue(1, "pol_cd");
			document.getElementById("pod_cd").value = sheetObjects[2].CellValue(1, "pod_cd");
			document.getElementById("pol_nod_cd").value = sheetObjects[2].CellValue(1, "pol_nod_cd");
			document.getElementById("pod_nod_cd").value = sheetObjects[2].CellValue(1, "pod_nod_cd");
			document.getElementById("package_sum").value = sheetObjects[2].CellText(1, "pck_qty");
			document.getElementById("pck_type_cd").value = sheetObjects[2].CellValue(1, "pck_tp_cd");
			document.getElementById("weight_sum").value = sheetObjects[2].CellText(1, "grs_wgt");
			document.getElementById("wgt_ut").value = sheetObjects[2].CellValue(1, "wgt_ut_cd");

			for ( var j = 1; j <= sheetObjects[1].RowCount; j++) {
				if (sheetObjects[1].CellValue(j, "spcl_cgo_apro_cd") == "N") {
					sheetObjects[1].CellFontColor(j, "spcl_cgo_apro_cd") = sheetObjects[1].RgbColor(255, 0, 0);
					sheetObjects[1].CellFont("FontBold", j, "spcl_cgo_apro_cd") = true;
				}
				sheetObjects[1].CellValue2(j, "Seq") = j;
				sheetObjects[1].CellValue2(j, "ibflag") = "R";
				if (sheetObjects[1].CellValue(j, "cntr_no") != "") {
					var cntr_no = sheetObjects[1].CellValue(j, "cntr_no");
					var find_row = sheetObjects[3].FindText("name", cntr_no, 0, 2);
					sheetObjects[3].CellValue2(find_row, "DelChk") = "1";
				}
			}

			htmlSheetSync();
			/*
			var cntr_name = "";
			var cntr_val = "";														
			for (var j=1; j<=sheetObjects[3].RowCount; j++){	 																								
				if(sheetObjects[3].CellValue(j, "DelChk") == "0"){									
					cntr_name += sheetObjects[3].CellValue(j, "name")+"|";
					cntr_val += sheetObjects[3].CellValue(j, "val")+"|";	 										
				} 									
			}							
			
			cntr_val = cntr_val.substr(0,cntr_val.length-1);	
			cntr_name = cntr_name.substr(0,cntr_name.length-1);							    
			var checkCntr = sheetObjects[3].FindText("DelChk", "0", 0, 2);						  
			for (var i=1; i<=sheetObjects[1].RowCount; i++){							   
			   if(checkCntr > 0) {
				   if(sheetObjects[1].CellValue(i, "cntr_no") != ""){									  
					   sheetObjects[1].CellComboItem(i, "cntr_no", " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_name, " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_val);
					   sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = false;
					   sheetObjects[1].CellEditable(i,"cntr_vol_qty") = false;
				   }else{									   
					  sheetObjects[1].CellComboItem(i, "cntr_no", " |"+cntr_name, " |"+cntr_val);
					  sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = true;
					  sheetObjects[1].CellEditable(i,"cntr_vol_qty") = true;
				   }
			   }else{
				   if(sheetObjects[1].CellValue(i, "cntr_no") != ""){										  
					   sheetObjects[1].CellComboItem(i, "cntr_no", " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_name, " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_val);
					   sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = false;
					   sheetObjects[1].CellEditable(i,"cntr_vol_qty") = false;
				   }else{									   
					  sheetObjects[1].CellComboItem(i, "cntr_no", " |"+cntr_name, " |"+cntr_val);
					  sheetObjects[1].CellEditable(i,"cntr_tpsz_cd") = true;
					  sheetObjects[1].CellEditable(i,"cntr_vol_qty") = true;
				   }								   
			   }
			}						   
			 */
			var tpszN = sheetObjects[1].FindText("spcl_cgo_apro_cd", "N", 0, 2);
			var tpszP = sheetObjects[1].FindText("spcl_cgo_apro_cd", "P", 0, 2);
			var tpszR = sheetObjects[1].FindText("spcl_cgo_apro_cd", "R", 0, 2);
			var tpszY = sheetObjects[1].FindText("spcl_cgo_apro_cd", "Y", 0, 2);
			if (tpszN > 0) {
				document.getElementById("auth_cd").value = " N";
				document.getElementById("auth_cd").style.color = "red";
				document.getElementById("auth_cd").style.fontWeight = "bold";
			} else if (tpszP > 0 && tpszN < 0) {
				document.getElementById("auth_cd").style.color = "black";
				document.getElementById("auth_cd").value = " P";
				document.getElementById("auth_cd").style.fontWeight = "bold";
				
				for(var idx=1;idx<=sheetObjects[1].RowCount;idx++){
					if(sheetObjects[1].CellValue(idx,"cntr_no") != ""){
						sheetObjects[1].CellEditable(idx, "cntr_no") = false;
					}
				}
				
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

			if (sheetObjects[1].RowCount < 1 && document.getElementById("bl_no").value != "") {
				document.getElementById("auth_cd").value = "";
				checkAdd();
			} else if (sheetObjects[1].RowCount < 1 && document.getElementById("auth_cd").value == "") {
				ComShowCodeMessage("BKG00183", document.getElementById("bkg_no").value);
				return;
			}
		}
		//------------------------------------------------>
		//setInquiryDisableButton 이벤트 호출
		if (ComGetObjValue(document.form.isInquiry) == "Y") {
			setInquiryDisableButton();
		}
		
		pendingSaveFlg = "Y";	//조회 시 Flag 초기화
		tempVentChangeFlag = "N";
			
		break;

	case COMMAND04: //booking split no조회 
		formObj.f_cmd.value = COMMAND03;
		var param = "&f_cmd=" + COMMAND03 + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
		var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
		bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, 20);

		break;

	case IBSAVE: //저장	
		if (validateForm(sheetObj, formObj, sAction)){
			if (sheetObjects[2].CellValue(1, "corr_no") == "" && sheetObjects[2].CellValue(1, "bdr_flg") == "Y") {
				ComShowMessage(ComGetMsg("BKG00004"));
				chkFlg = "Y";
				return;
			}
		}
		var r_cnt = 0;
		var d_cnt = 0;
		var chilled_cnt = 0;
		var frozen_cnt = 0;
		var fresh_cnt = 0;
		var cdo_temp = 0;
		var fdo_temp = 0;
		var chilled_seq = 0;
		var frozen_seq = 0;
		var fresh_seq = 0;
		var cntrNo = "";
		var oldCntrNo = "";
		var rfChkFlg = "N";
		var oldCdoTemp = "";
		var oldFdoTemp = "";
		var oldVentRto = "";
		var oldCntrVentTpCd = "";
		var oldHumidNo = "";
		var cdoTemp = "";
		var fdoTemp = "";
		var ventRto = "";
		var cntrVentTpCd = "";
		var humidNo = "";
		
		for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {			
			//삭제일 경우 Validate Skip
			if( sheetObjects[1].RowHidden(i) || sheetObjects[1].CellValue(i, "ibflag") == "D"){
				continue;
			}
			
			if (sheetObjects[1].CellValue(i, "apro_cd") != "C" || sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") != "C") {
				var seq = sheetObjects[1].CellValue(i, "Seq");
				if (sheetObjects[1].CellValue(i, "ibflag") == "R") {
					r_cnt++;
				}
				if (sheetObjects[1].CellValue(i, "ibflag") != "D") {
					d_cnt++;
				}
				if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") == "P" && pendingSaveFlg == "N") {
					ComShowMessage(ComGetMsg("BKG00500"));
					chkFlg = "Y";
					return;
				}
				if (sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == "") {
					ComShowCodeMessage("BKG08126", "[" + seq + "]");
					chkFlg = "Y";
					sheetObjects[1].SelectCell(i, "cntr_tpsz_cd");
					return;
				}
				if (sheetObjects[1].CellValue(i, "cmdt_cd") == "") {
					ComShowCodeMessage("BKG00510", "[" + seq + "]");
					chkFlg = "Y";
					return;
				}
				if (sheetObjects[1].CellValue(i, "cdo_temp") == "" || sheetObjects[1].CellValue(i, "fdo_temp") == "" 
					|| (sheetObjects[1].CellValue(i, "cdo_temp") == "0" && sheetObjects[1].CellValue(i, "fdo_temp") == "0")) {
					ComShowCodeMessage("BKG00611", "[" + seq + "]");
					chkFlg = "Y";
					return;
				}

				if (ComTrim(sheetObjects[1].CellValue(i, "vent_rto")," ") == "" && ComTrim(sheetObjects[1].CellValue(i, "cbm_per_hr_qty")," ") == "")  {
                    ComShowCodeMessage("BKG02089", "[Seq: " + seq + "] "); 
                    chkFlg = "Y";
                    return;
				}
				
				if (sheetObjects[1].CellValue(i, "clng_tp_cd") == "") {
					ComShowCodeMessage("BKG00612", "[" + seq + "]");
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
				if (sheetObjects[1].CellValue(i, "clng_tp_cd") == "C" && Number(sheetObjects[1].CellValue(i, "cdo_temp")) < -5 && Number(sheetObjects[1].CellValue(i, "cdo_temp")) > 5) {
					chilled_cnt++;
					chilled_cdo_temp = Number(sheetObjects[1].CellValue(i, "cdo_temp"));
					chilled_fdo_temp = Number(sheetObjects[1].CellValue(i, "fdo_temp"));
					chilled_seq = seq;
				}
				if (sheetObjects[1].CellValue(i, "clng_tp_cd") == "F" && Number(sheetObjects[1].CellValue(i, "cdo_temp")) > -5) {
					frozen_cnt++;
					frozen_cdo_temp = Number(sheetObjects[1].CellValue(i, "cdo_temp"));
					frozen_fdo_temp = Number(sheetObjects[1].CellValue(i, "fdo_temp"));
					frozen_seq = seq;
				}
				if (sheetObjects[1].CellValue(i, "clng_tp_cd") == "S" && Number(sheetObjects[1].CellValue(i, "cdo_temp")) < 0) {
					fresh_cnt++;
					fresh_cdo_temp = Number(sheetObjects[1].CellValue(i, "cdo_temp"));
					fresh_fdo_temp = Number(sheetObjects[1].CellValue(i, "fdo_temp"));
					fresh_seq = seq;
				}
			}

//			 Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )			
			oldCdoTemp = sheetObjects[1].CellSearchValue(i, "cdo_temp");
			oldFdoTemp = sheetObjects[1].CellSearchValue(i, "fdo_temp");
			oldVentRto = sheetObjects[1].CellSearchValue(i, "vent_rto");
			oldCntrVentTpCd = sheetObjects[1].CellSearchValue(i, "cntr_vent_tp_cd");
			oldHumidNo = sheetObjects[1].CellSearchValue(i, "humid_no");
			
			cdoTemp = sheetObjects[1].CellValue(i, "cdo_temp");
			fdoTemp = sheetObjects[1].CellValue(i, "fdo_temp");
			ventRto = sheetObjects[1].CellValue(i, "vent_rto");
			cntrVentTpCd = sheetObjects[1].CellValue(i, "cntr_vent_tp_cd");
			humidNo = sheetObjects[1].CellValue(i, "humid_no");
			
			cntrNo = sheetObjects[1].CellValue(i, "cntr_no");
			oldCntrNo = sheetObjects[1].CellSearchValue(i, "cntr_no");
			if ( rfChkFlg == "N" && ( cntrNo != oldCntrNo || cdoTemp != oldCdoTemp|| fdoTemp != oldFdoTemp || ventRto != oldVentRto || cntrVentTpCd != oldCntrVentTpCd || humidNo != oldHumidNo) ) {
				rfChkFlg = "Y";
			}
		}
		
		if (r_cnt == sheetObjects[1].RowCount) {
			if (reqFlag != "N") {
				ComShowMessage(ComGetMsg("BKG00501"));
			}
			chkFlg = "Y";
			return;
		}
		if (chilled_cnt > 0) {
			ComShowCodeMessage("BKG00615", chilled_cdo_temp, chilled_fdo_temp, "[" + chilled_seq + "]");
			chkFlg = "Y";
			return;
		}
		if (frozen_cnt > 0) {
			ComShowCodeMessage("BKG00616", frozen_cdo_temp, frozen_fdo_temp, "[" + frozen_seq + "]");
			chkFlg = "Y";
			return;
		}
		if (fresh_cnt > 0) {
			ComShowCodeMessage("BKG00617", fresh_cdo_temp, fresh_fdo_temp, "[" + fresh_seq + "]");
			chkFlg = "Y";
			return;
		}
		for ( var j = 1; j <= sheetObjects[0].RowCount; j++) {
			var cnt = 0;
			var rcnt = 0;
			var find_tpsz_cd = "";
			for ( var m = 1; m <= sheetObjects[1].RowCount; m++) {
				// Cancel 되거나 삭제된 행 제외
				if (sheetObjects[1].CellValue(m, "apro_cd") != "C" && sheetObjects[1].CellValue(m, "spcl_cgo_apro_cd") != "C"
						&& sheetObjects[1].CellValue(m, "ibflag") != "D") {
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
				if(sheetObjects[1].CellValue(m, "ibflag") == "D"){
					rfChkFlg = "Y";
				}
			}
			if (rcnt > 0) {
				find_tpsz_cd = find_tpsz_cd.substr(0, find_tpsz_cd.length - 1);
				ComShowCodeMessage("BKG08023", find_tpsz_cd);
				chkFlg = "Y";
				return;
			}
			var cntr_tpsz_cd = sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[0].CellValue(j, "cntr_tpsz_cd"), 0, 2);
			if (cntr_tpsz_cd > 0) {
				if (Number(sheetObjects[0].CellValue(j, "rf_cgo_qty")) > cnt) {
					if (ComShowConfirm(ComGetMsg("BKG00678", "RF"))) {
						cnt = 0;
					} else {
						chkFlg = "Y";
						return;
					}
				}
				if (Number(sheetObjects[0].CellValue(j, "rf_cgo_qty")) < cnt) {
					ComShowCodeMessage("BKG00679", "RF");
					chkFlg = "Y";
					return;
				}
			}
		}
		var sum = 0;
		if (sheetObjects[0].RowCount > 0) {
			sum = sheetObjects[0].ComputeSum("|2|");
		}
		if (sum == "0") {
			if (d_cnt > 0) {
				ComShowMessage(ComGetMsg("BKG00502", "RF"));
				chkFlg = "Y";
				return;
			}
		}
		/*
		//var find_row = sheetObjects[1].FindText("modifyaproflg", "Y", 0, 2); 
		var requestCnt = 0;
		for(var c=1; c <= sheetObjects[1].RowCount; c++){		 																 						
			if(sheetObjects[1].CellValue(c, "spcl_cgo_apro_cd") != "P" && sheetObjects[1].CellValue(c, "spcl_cgo_apro_cd") != "C" && sheetObjects[1].CellValue(c, "spcl_cgo_apro_cd") != ""){									
				if(sheetObjects[1].CellValue(c, "modifyaproflg") == "Y"){										
					requestCnt++; 	
				}
			}
		}  							
		if(requestCnt > 0 && reqFlag == "Y"){								
			if(ComShowConfirm(ComGetMsg("BKG00532"))){		 										 					
				reqFlag = "N";
			}else{	
				chkFlg = "Y";
				return;
			}
		}
		 */
		
		//by 2010.05.07  전성진 : 0498에 저장할 때 섭씨와 화씨 온도를 비교하는 로직을 추가해야 합니다. 
		//섭씨 온도를 기준으로 화씨로 제대로 변환 되었는지 확인해서 다를 경우 에러로 처리해야 합니다.		
		var r_value_c =0;
		var r_value_f =0;
		var r_fdo_temp =0;
		var r_cdo_temp =0;
		var r_cnt = sheetObjects[1].RowCount;

		if(r_cnt>0){
			for(var c=1; c <= r_cnt; c++){
				r_fdo_temp = sheetObjects[1].CellValue(c, "fdo_temp");
				r_cdo_temp = sheetObjects[1].CellValue(c, "cdo_temp");
				r_value_f = fnCheckFdoTemp(r_cdo_temp);
				r_value_c = fnCheckCdoTemp(r_fdo_temp);
		
			//	if(Math.round(r_fdo_temp) != Math.round(r_value) ){
  			  	if( (roundXL(r_fdo_temp, 1) != roundXL(r_value_f, 1)) && (roundXL(r_cdo_temp, 1) != roundXL(r_value_c, 1)) ){
					ComShowCodeMessage("BKG08177", r_fdo_temp, r_value_f, "[" + c + "]");
					return ;
				}
				
				sheetObjects[1].CellValue2(c,"vsl_cd") = sheetObjects[2].CellValue(1,"vsl_cd"); //2011.03.28 변종건 [CHM-201109427-01]
			 }
		}
		if(tempVentChangeFlag == "Y"){
			if(ComShowConfirm(ComGetMsg("BKG08256"))){				
			} else {
				return;
			}
		}
		
		
		// ALPS RF Cargo Application Pop-Up Warning MSG 기능 설정 요청 (RD 취급 사고건 관련)
		// 쿼리 실행 후 CLL_VVD 가 값이 있을 경우 Warning Message 보여줌.
		var cllVvd = doActionIBSheet(sheetObjects[0], document.form, COMMAND06);
		if (cllVvd != "" && cllVvd != null) {
			if ( !ComShowConfirm(ComGetMsg("BKG08332", cllVvd)) ) return false; 						
		}
		
//		alert(rfChkFlg);
		formObj.f_cmd.value = MULTI;
		var sParam = FormQueryString(formObj);
		// Cntr No가 수정이 되면 Vender 301이 전송되도록 하기 위하여 Flg를 만들었음. ( 경종윤 수석님 요청 - 2010.08.26 )
		sParam = sParam + "&" + "rf_chk_flg=" + rfChkFlg;
		var sParamSheet1 = sheetObjects[1].GetSaveString();
		sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		var rXml = sheetObj.GetSaveXml("ESM_BKG_0498GS.do", sParam);
		var rMsg = ComResultMessage(rXml);
		var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		
		
		// At Risk에 해당하는 장비이면 validation메시지 팝업(Reefer)
       	// 조건: POD = US, POD= CA,  US Frob의 경우
       	var rskFlg = ComGetEtcData(rXml,"rskFlg");
       	//alert("rskFlg >>> " + rskFlg);
       	if(rskFlg =="Y"){
       		// 2014년 6월 13일 남기황 차장님 요청으로 At Risk 관련 validation 걷어냄
       		// ComShowMessage(ComGetMsg("BKG08275"));
       	}
		
		// RF 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
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

	case COMMAND01: //request
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = COMMAND01;
		}
		var sParam = FormQueryString(formObj);
		var sParamSheet1 = sheetObjects[1].GetSaveString();
		if (sParamSheet1 != "") {
			sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		}
		
		
		var krFlag = formObj.kr_flag.value;
		var cmdtFlag = formObj.cmdt_flag.value;
		var descFlag = formObj.desc_flag.value;
		var coFlag = formObj.co_flag.value;
		
		if(krFlag =="Y"){
			if(cmdtFlag =="Y"|| descFlag=="Y"  ){
				if(coFlag =="N"){
					 if(ComShowConfirm(ComGetMsg("BKG08303"))) {
						 ComShowCodeMessage("BKG08304");
						 messageFlg = "save";
							reqFlag = "Y";
							retFlag = "";
							doActionIBSheet(sheetObjects[0], document.form, IBSAVE);

							if (retFlag == "Y") {
								doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
							}
						 return false;
					 }
				}
				
			}
		}
		
		var rXml = sheetObj.GetSaveXml("ESM_BKG_0498GS.do", sParam);
		var rMsg = ComResultMessage(rXml);
		var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		
		// RF 저장시에 PSA 전송되도록 수정함. [CHM-201006332-01]
		if(ComGetEtcData(rXml, "psaValCode") != "Y" && ComGetEtcData(rXml, "psaValCode") != undefined){						
			var errMsg01 = ComGetEtcData(rXml,"psaValCode");
	    	var rmsg = errMsg01.split("<||>");
	    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
	    		ComShowCodeMessage("BKG06125");
	    	}else if ( rmsg[1] != "BKG95025" ){
	    		ComShowMessage(rmsg[3]);
	    	}	
		}
		if (rMsg == '' && reqFlag == "N" && messageFlg == "request") {
			ComShowMessage(ComGetMsg("BKG08102"));
			retFlag = "Y";
		} else if (rMsg == '' && reqFlag == "N" && messageFlg == "save") {
			//ComShowMessage(ComGetMsg("BKG00166"));
			retFlag = "Y";
		} else if (rMsg == '' && reqFlag == "Y") {
		} else {
			sheetObj.LoadSearchXml(rXml);
		}
		break;

	case COMMAND02: // request cancel
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = COMMAND01;
		}
		var sParam = FormQueryString(formObj);
		var sParamSheet1 = sheetObjects[1].GetSaveString();
		if (sParamSheet1 != "") {
			sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
		}
		var rXml = sheetObj.GetSaveXml("ESM_BKG_0498GS.do", sParam);
		var rMsg = ComResultMessage(rXml);
		var State = ComGetEtcData(rXml, ComWebKey.Trans_Result_Key);
		if (rMsg == '' && reqFlag == "N" && messageFlg == "requestCancel") {
			ComShowMessage(ComGetMsg("BKG08103"));
			retFlag = "Y";
		} else if (rMsg == '' && reqFlag == "N" && messageFlg == "save") {
			//ComShowMessage(ComGetMsg("BKG00166"));
			retFlag = "Y";
		} else if (rMsg == '' && reqFlag == "Y") {
		} else {
			sheetObj.LoadSearchXml(rXml);
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
			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "cmdt_nm") = cmdt_nm;
			sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "modifyaproflg") = "Y";
			sheetObj.WaitImageVisible = true;
			cmdtFlg = "";
		} else {
			return false;
		}
		break;
	
	case COMMAND06: // CLL VVD Value 값 조회
		
		formObj.f_cmd.value = COMMAND06;
		var rXml = sheetObj.GetSearchXml("ESM_BKG_0498GS.do", FormQueryString(formObj));
		var cllVvd = ComGetEtcData(rXml, "cll_vvd");
			
		return cllVvd;
			
		break;
	}
}

function htmlSheetSync() {
	Row = sheetObjects[1].SelectRow;
	document.getElementById("temp_cntr_no").value = sheetObjects[1].CellValue(Row, "cntr_no");
	document.getElementById("seq").value = sheetObjects[1].CellValue(Row, "Seq");
	document.getElementById("cmdt_cd").value = sheetObjects[1].CellValue(Row, "cmdt_cd");
	document.getElementById("cmdt_nm").value = sheetObjects[1].CellValue(Row, "cmdt_desc");
	document.getElementById("cntr_tpsz_cd").value = sheetObjects[1].CellValue(Row, "cntr_tpsz_cd");
	document.getElementById("aply_no").value = sheetObjects[1].CellValue(Row, "aply_no");
	
	if (sheetObjects[1].CellValue(Row, "cdo_temp").indexOf("-") == 0) {
		document.getElementById("cdo_temp").value = sheetObjects[1].CellValue(Row, "cdo_temp").replace("-", "");
		document.getElementById("plusMinus1").value = "-";
	} else {
		document.getElementById("cdo_temp").value = sheetObjects[1].CellValue(Row, "cdo_temp");
		document.getElementById("plusMinus1").value = "+";
	}
	
	if (sheetObjects[1].CellValue(Row, "fdo_temp").indexOf("-") == 0) {
		document.getElementById("fdo_temp").value = sheetObjects[1].CellValue(Row, "fdo_temp").replace("-", "");
		document.getElementById("plusMinus2").value = "-";
	} else {
		document.getElementById("fdo_temp").value = sheetObjects[1].CellValue(Row, "fdo_temp");
		document.getElementById("plusMinus2").value = "+";
	}
	
	// 2010.07.27 수정-화면 Default삭제(CHM-201004544-01) by KHH	
	if (sheetObjects[1].CellValue(Row, "cdo_temp") == "0" && sheetObjects[1].CellValue(Row, "fdo_temp") == "0") {
		document.getElementById("cdo_temp").value = "";
		document.getElementById("fdo_temp").value = "";
	} 		

	document.getElementById("clng_tp_cd").value = sheetObjects[1].CellValue(Row, "clng_tp_cd");
	document.getElementById("cntr_vent_tp_cd").value = sheetObjects[1].CellValue(Row, "cntr_vent_tp_cd");

	if (sheetObjects[1].CellValue(Row, "cntr_vent_tp_cd") == "P") {
		document.getElementById("vent_rto").value = sheetObjects[1].CellValue(Row, "vent_rto");
	} else {
		document.getElementById("vent_rto").value = sheetObjects[1].CellValue(Row, "cbm_per_hr_qty");
	}

	if (sheetObjects[1].CellValue(Row, "ctrl_atms_flg") == "Y") {
		document.getElementById("ctrl_atms_flg").checked = true;
	} else {
		document.getElementById("ctrl_atms_flg").checked = false;
	}

	if (sheetObjects[1].CellValue(Row, "modi_atms_flg") == "Y") {
		document.getElementById("modi_atms_flg").checked = true;
	} else {
		document.getElementById("modi_atms_flg").checked = false;
	}

	if (sheetObjects[1].CellValue(Row, "humid_ctrl_flg") == "Y") {
		document.getElementById("humid_ctrl_flg").checked = true;
	} else {
		document.getElementById("humid_ctrl_flg").checked = false;
	}

	if (sheetObjects[1].CellValue(Row, "atfc_atms_flg") == "Y") {
		document.getElementById("atfc_atms_flg").checked = true;
	} else {
		document.getElementById("atfc_atms_flg").checked = false;
	}
	
	if (sheetObjects[1].CellValue(Row, "ctrl_atms_flg") == "Y") {
		document.getElementById("ctrl_atms_flg").checked = true;
	} else {
		document.getElementById("ctrl_atms_flg").checked = false;
	}

	if (sheetObjects[1].CellValue(Row, "modi_atms_flg") == "Y") {
		document.getElementById("modi_atms_flg").checked = true;
	} else {
		document.getElementById("modi_atms_flg").checked = false;
	}

	if (sheetObjects[1].CellValue(Row, "humid_ctrl_flg") == "Y") {
		document.getElementById("humid_ctrl_flg").checked = true;
	} else {
		document.getElementById("humid_ctrl_flg").checked = false;
	}

	document.getElementById("humid_no").value = sheetObjects[1].CellValue(Row, "humid_no");
	document.getElementById("pck_qty").value = sheetObjects[1].CellValue(Row, "pck_qty");
	document.getElementById("pck_tp_cd").value = sheetObjects[1].CellValue(Row, "pck_tp_cd");

	document.getElementById("grs_wgt").value = sheetObjects[1].CellText(Row, "grs_wgt");
	document.getElementById("temp_grs_wgt").value = sheetObjects[1].CellText(Row, "grs_wgt");
	document.getElementById("net_wgt").value = sheetObjects[1].CellText(Row, "net_wgt");
	document.getElementById("temp_net_wgt").value = sheetObjects[1].CellText(Row, "net_wgt");

	document.getElementById("wgt_ut_cd1").value = sheetObjects[1].CellValue(Row, "wgt_ut_cd");
	document.getElementById("wgt_ut_cd2").value = sheetObjects[1].CellValue(Row, "wgt_ut_cd");
	document.getElementById("rf_dcgo_seq").value = sheetObjects[1].CellValue(Row, "rf_dcgo_seq");
	document.getElementById("cntr_drn_cd").value = sheetObjects[1].CellValue(Row, "cntr_drn_cd");
	document.getElementById("diff_rmk").value = sheetObjects[1].CellValue(Row, "diff_rmk");
	document.getElementById("vessel_nm").value = sheetObjects[2].CellValue(1, "vessel_nm");

	if (sheetObjects[1].RowCount > 0 && sheetObjects[1].CellValue(Row, "diff_rmk").length > 0) {
		document.getElementById("btn_Remark").style.color = "blue";
	} else {
		document.getElementById("btn_Remark").style.color = "";
	}

	if (sheetObjects[1].CellValue(Row, "spcl_cgo_apro_cd") == "C" || sheetObjects[1].CellValue(Row, "spcl_cgo_apro_cd") == "") {
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
	for ( var j = 1; j <= sheetObjects[3].RowCount; j++) {
		if (sheetObjects[3].CellValue(j, "DelChk") == "0") {
			cntr_name += sheetObjects[3].CellValue(j, "name") + "|";
			cntr_val += sheetObjects[3].CellValue(j, "val") + "|";
		}
	}
	cntr_val = cntr_val.substr(0, cntr_val.length - 1);
	cntr_name = cntr_name.substr(0, cntr_name.length - 1);
	var checkCntr = sheetObjects[3].FindText("DelChk", "0", 0, 2);
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
	htmlSheetSync();
	switch (col_name) {
	case "cntr_no":
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
			var temp_find_row = sheetObjects[3].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[3].CellValue(temp_find_row, "DelChk") = "0";
			}
			var cntr_no = sheetObjects[1].CellValue(row, "cntr_no");
			var find_row = sheetObjects[3].FindText("name", cntr_no, 0, 2);
			if (sheetObjects[1].CellValue(row, "cntr_no") != "" && sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != "" && sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != sheetObjects[3].CellValue(find_row, "cntr_tpsz_cd")) {
				if (ComShowConfirm(ComGetMsg("BKG00570"))) {
					sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[3].CellValue(find_row, "cntr_tpsz_cd");
					document.getElementById("cntr_tpsz_cd").value = sheetObjects[3].CellValue(find_row, "cntr_tpsz_cd");
				} else {
					sheetObjects[1].CellValue2(row, "cntr_no") = "";
					cntr_no = "";
				}
			} else if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd") == "") {
				sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = sheetObjects[3].CellValue(find_row, "cntr_tpsz_cd");
				document.getElementById("cntr_tpsz_cd").value = sheetObjects[3].CellValue(find_row, "cntr_tpsz_cd");
			}
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = sheetObjects[3].CellValue(find_row, "cntr_vol_qty");
			if (cntr_no != "") {
				sheetObjects[3].CellValue2(find_row, "DelChk") = "1";
			}
			document.getElementById("temp_cntr_no").value = cntr_no;

			/*
			var cntr_name = "";
			var cntr_val = "";															
			for (var j=1; j<=sheetObjects[3].RowCount; j++){	 																									
				if(sheetObjects[3].CellValue(j, "DelChk") == "0"){									
					cntr_name += sheetObjects[3].CellValue(j, "name")+"|";
					cntr_val += sheetObjects[3].CellValue(j, "val")+"|";	 										
				} 									
			}											
			cntr_val = cntr_val.substr(0,cntr_val.length-1);	
			cntr_name = cntr_name.substr(0,cntr_name.length-1);					
			for (var i=1; i<=sheetObjects[1].RowCount; i++){												
				if(sheetObjects[1].CellValue(i, "cntr_no") != ""){							   
					sheetObjects[1].CellComboItem(i, "cntr_no", " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_name, " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_val);							   
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
			var temp_find_row = sheetObjects[3].FindText("name", temp_cntr_no, 0, 2);
			if (temp_cntr_no != "") {
				sheetObjects[3].CellValue(temp_find_row, "DelChk") = "0";
			}
			document.getElementById("temp_cntr_no").value = "";

			/*
			var cntr_name = "";
			var cntr_val = "";															
			for (var j=1; j<=sheetObjects[3].LastRow; j++){	 																									
				if(sheetObjects[3].CellValue(j, "DelChk") == "0"){									
					cntr_name += sheetObjects[3].CellValue(j, "name")+"|";
					cntr_val += sheetObjects[3].CellValue(j, "val")+"|";	 										
				} 									
			}															
								
			cntr_val = cntr_val.substr(0,cntr_val.length-1);	
			cntr_name = cntr_name.substr(0,cntr_name.length-1);														
			for (var i=1; i<=sheetObjects[1].RowCount; i++){																		
				if(sheetObjects[1].CellValue(i, "cntr_no") != ""){							   
					   sheetObjects[1].CellComboItem(i, "cntr_no", " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_name, " |"+sheetObjects[1].CellValue(i, "cntr_no")+"|"+cntr_val);							   
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

	case "cntr_tpsz_cd":
		sheetObjects[1].CellValue2(row, "cntr_tpsz_cd") = (sheetObjects[1].CellValue(row, "cntr_tpsz_cd")).toUpperCase();
		document.getElementById("cntr_tpsz_cd").value = sheetObjects[1].CellValue(row, "cntr_tpsz_cd");
		var find_row = sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), 0, 2);
		if (find_row > 0) {
			var cntrVolQty = Number(sheetObjects[0].CellValue(find_row, "rf_cgo_qty"));
		} else {
			var cntrVolQty = "0";
		}
		if (cntrVolQty >= 1) {
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = "1";
		} else if (cntrVolQty > 0 && cntrVolQty < 1) {
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = cntrVolQty;
		} else {
			sheetObjects[1].CellValue2(row, "cntr_vol_qty") = "0";
		}
		break;

	case "cntr_vol_qty":
		if (Number(sheetObjects[1].CellValue(row, "cntr_vol_qty")) > 1) {
			ComShowMessage(ComGetMsg("BKG08013"));
		}
		var find_row = sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].CellValue(row, "cntr_tpsz_cd"), 0, 2);
		if (sheetObjects[1].CellValue(row, "cntr_tpsz_cd") != "" && find_row > 0) {
			var cntrVolQty = Number(sheetObjects[0].CellValue(find_row, "rf_cgo_qty"));
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
		//            if (!isNumber(formObj.iPage)) {
		//                return false;
		//            }
	}
	return true;
}

// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColBackColor("RFQTY") = RgbColor(204, 255, 253);
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
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_Request");
}
 
 /**
  * 실수(n)를 지정한 소수점(digit) 이하에서 반올림 .<br>
  */
 function roundXL(n, digits) {
      if(digits >=0){ 
    	  var num = parseFloat(n);
    	  return parseFloat(num.toFixed(digits));
      }; // 소수부 반올림
      digits = Math.pow(10, digits); // 정수부 반올림

      var t = Math.round(num * digits) / digits;
      return parseFloat(t.toFixed(0));
 }
  
function sendMail() {
	var iCnt = sheetObjects[1].FindText("ibflag", "I", 0, 2);
	var uCnt = sheetObjects[1].FindText("ibflag", "U", 0, 2);
	var dCnt = sheetObjects[1].FindText("ibflag", "D", 0, 2);

	if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
		ComShowMessage(ComGetMsg("BKG00178"));
		return;
	}

	var date = new Date();
	var content = "";
	content = "SM Line<br><br>[ Reefer Cargo ]<br><br>"
			+ date.toString()
			+ "<br>Booking Number : " 
			+ document.getElementById("bkg_no").value 
			+ "<br>B/L Number : " 
			+ document.getElementById("bl_no").value 
			+ "<br>POL : " 
			+ document.getElementById("pol_cd").value 
			+ "<br>POD : " 
			+ document.getElementById("pod_cd").value 
			+ "<br>VVD/VESSEL NAME : " 
			+ document.getElementById("tvvd").value + " / "
			+ document.getElementById("vessel_nm").value 
			+ "<br>----------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";

	for ( var i = 1; i <= sheetObjects[1].RowCount; i++) {
		if (sheetObjects[1].CellValue(i, "spcl_cgo_apro_cd") != "C") {
			content += "1.  Container SEQ           : " + sheetObjects[1].CellValue(i, "rc_seq") + "<br>";
			content += "2.  Container No.           : " + sheetObjects[1].CellValue(i, "cntr_no") + "<br>";
			content += "3.  EQ Type/Size            : " + sheetObjects[1].CellValue(i, "eq_tpsz").substr(0,4)+ "<br>";
			content += "4.  Cargo SEQ               : " + sheetObjects[1].CellValue(i, "cntr_cgo_seq") + "<br>";
			content += "5.  Commodity               : " + sheetObjects[1].CellValue(i, "cmdt_desc") + "<br>";
			content += "6.  Temperature             : " + sheetObjects[1].CellValue(i, "cdo_temp") + "&ordm;C&nbsp;"
														+ sheetObjects[1].CellValue(i, "fdo_temp") + "&ordm;F<br>"; 
			content += "7.  Ventilation             : " + sheetObjects[1].CellValue(i, "vent_rto");
		
			if(sheetObjects[1].CellText(i, "cntr_vent_tp_cd") == "P"){
				content += "% Open<br>";
			} else {
				content += "CMH<br>";
			}
		
			content += "8.  Nature                  : " ;
			if(sheetObjects[1].CellValue(i, "clng_tp_cd") == "C"){
				content += "Chilled<br>";
			} else if(sheetObjects[1].CellValue(i, "clng_tp_cd") == "F"){
				content += "Frozen<br>";
			} else if(sheetObjects[1].CellValue(i, "clng_tp_cd") == "S"){
				content += "Fresh<br>"
			}		
					
			content += "9.  Humidity                : ";
			if(sheetObjects[1].CellValue(i, "humid_no") != ""){
				content += sheetObjects[1].CellValue(i, "humid_no") + "%<br>";					
			} else {
				content += "<br>";
			}
			content += "10. Package                 : " + sheetObjects[1].CellValue(i, "pck_qty") + sheetObjects[1].CellValue(i, "pck_tp_cd") + "<br>";	
			content += "11.  Net WGT/KG             : " + sheetObjects[1].CellText(i, "net_wgt") + sheetObjects[1].CellValue(i, "wgt_ut_cd") + "<br>";
			content += "12.  Grs WGT/KG             : " + sheetObjects[1].CellText(i, "grs_wgt") + sheetObjects[1].CellValue(i, "wgt_ut_cd") + "<br>";
			content += "13.  DG Container SEQ       : " + sheetObjects[1].CellValue(i, "rf_dcgo_seq") + "<br>";
			content += "14.  Approval Ref No.       : " + sheetObjects[1].CellValue(i, "aply_no") + "<br>";
			content += "15.  Others                 : ";
			if(sheetObjects[1].CellValue(i, "ctrl_atms_flg") == "Y"){
				content += "Control Atmosphere (CA).&nbsp;";
			}
			if(sheetObjects[1].CellValue(i, "modi_atms_flg") == "Y"){
				content += "Modified CA (MA).&nbsp;";
			}
			if(sheetObjects[1].CellValue(i, "humid_ctrl_flg") == "Y"){
				content += "Humidity Control (HM).&nbsp;";
			}
			if(sheetObjects[1].CellValue(i, "atfc_atms_flg") == "Y"){
				content += "Artificial Atmosphere (AA).&nbsp;";
			}
			content += "<br>"
			content += "16.  Drain       : " ;
			if(sheetObjects[1].CellValue(i, "cntr_drn_cd") == "O"){
				content += "Open";
			} else if(sheetObjects[1].CellValue(i, "cntr_drn_cd") == "C"){
				content += "Close";
			} else if(sheetObjects[1].CellValue(i, "cntr_drn_cd") == "N"){
				content += "N/A";
			}
			content += "<br>";	
			content += "17.  Remarks        : " + sheetObjects[1].CellValue(i, "diff_rmk") + "<br>";
			content += "<br>----------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";
		}
	}
	document.form.com_content.value = content;

	ComSendMailModal();
}  