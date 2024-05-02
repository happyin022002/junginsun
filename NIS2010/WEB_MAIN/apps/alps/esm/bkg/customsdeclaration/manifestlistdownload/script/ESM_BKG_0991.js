/*=========================================================
 *Copyright(c) 2017 Hi-Plus Card
 *@FileName : Esm_bkg_0991.js
 *@FileTitle : ESM_BKG-0991
 *Open Issues :
 *Change history :
 *	2017.08.04 하대성 2017 Renewal Version Transmit 반영
 *@LastModifyDate : 2017.08.04
 *@LastModifier : 하대성
 *@LastVersion : 1.0
 * 2009.06.03 김승민
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_BKG-0991 : ESM_BKG-0991 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0991() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn1_Close":
			//alert(opener);  
			if (!opener.closed)
				try {
					opener.retrieve();
				} catch (ex) {
				}
			window.close();
			break;

		case "btn2_CMF02":
			doActionIBSheet(sheetObjects[0], document.form, MULTI03);
			break;

		case "btn2_CMF01":
			doActionIBSheet(sheetObjects[0], document.form, MULTI02);
			break;

		case "btn2_MFR":
			doActionIBSheet(sheetObjects[0], document.form, MULTI01);
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

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param sheet_obj IBSheet Object
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

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		
		initControl();
	}

}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1": // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 225;
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
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(8, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "Flag|bl_no|vvd_cd|pod_cd||||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "bl_number");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "in_vvd_cd");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "in_pod_cd");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
					"in_pod_split_cd");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "in_msg_tp");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
					"in_msg_flag");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true,
			"in_mfr_gubun");
		}
		break;

	}
}

/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
/**
 * Sheet관련 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	// 2017 Renewal ver.
	if(formObj.form_action.value == COMMAND08) {
		switch (sAction) {
			
		case MULTI01: // 조회
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.RemoveAll();
			sheetObj.DataInsert(-1);
			formObj.f_cmd.value = MULTI11;
			formObj.form1_in_msg_tp.value = "MFR";
			formObj.form1_in_msg_flag.value = "9";
			formObj.form1_in_mfr_gubun.value = "N";
			IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
			sheetObj.DoAllSave("ESM_BKG_0991GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			break;

		case MULTI02: // 조회
			// alert("test");
			if (validateForm(sheetObj, formObj, sAction)) {
				if(!ComChkValid(frmObj)) return;
				//alert("test2");
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.RemoveAll();
				sheetObj.DataInsert(-1);
				formObj.f_cmd.value = MULTI11;
				formObj.form1_in_msg_tp.value = "CMF01";
				if(formObj.CMF01Checked(0).checked == true) {
					chvalue = "5";
					cmf_cd = "";
					cmf_reason = "";
				} else {
					chvalue = "1";
					cmf_cd = formObj.del_cd.value; 
					cmf_reason = formObj.del_reason.value;
				}
				formObj.form1_in_msg_flag.value = chvalue;
				formObj.cmf_cd.value = cmf_cd;
				formObj.cmf_reason.value = cmf_reason;
				formObj.form1_in_mfr_gubun.value = "Y";
				IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
				sheetObj.DoAllSave("ESM_BKG_0991GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}
			break;

		case MULTI03: // 저장
			if (validateForm(sheetObj, formObj, sAction)) {
				if(!ComChkValid(frmObj)) return;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.RemoveAll();
				sheetObj.DataInsert(-1);
				formObj.f_cmd.value = MULTI11;
				formObj.form1_in_msg_tp.value = "CMF02";
				if (formObj.CMF02Checked(0).checked == true) {
					chvalue = "2";
					cmf_cd = formObj.add_cd.value;
					cmf_reason = formObj.add_reason.value;
				} else if (formObj.CMF02Checked(1).checked == true) {
					chvalue = "5";
					cmf_cd = formObj.cor_cd.value;
					cmf_reason = formObj.cor_reason.value;
				} else {
					chvalue = "1";
					cmf_cd = formObj.del_cd.value;
					cmf_reason = formObj.del_reason.value;
				}	
				formObj.form1_in_msg_flag.value = chvalue;
				formObj.cmf_cd.value = cmf_cd;
				formObj.cmf_reason.value = cmf_reason; 
				formObj.form1_in_mfr_gubun.value = "Y";
				IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
				sheetObj.DoAllSave("ESM_BKG_0991GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}

			break;
		}
	//기존버전
	} else {
		switch (sAction) {

		case MULTI01: // 조회
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.RemoveAll();
			sheetObj.DataInsert(-1);
			formObj.f_cmd.value = MULTI;
			formObj.form1_in_msg_tp.value = "MFR";
			formObj.form1_in_msg_flag.value = "9";
			formObj.form1_in_mfr_gubun.value = "N";
			IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
			sheetObj.DoAllSave("ESM_BKG_0991GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			break;

		case MULTI02: // 조회
			// alert("test");
			if (validateForm(sheetObj, formObj, sAction)) {
				if(!ComChkValid(frmObj)) return;
				//alert("test2");
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.RemoveAll();
				sheetObj.DataInsert(-1);
				formObj.f_cmd.value = MULTI;
				formObj.form1_in_msg_tp.value = "CMF01";
				if(formObj.CMF01Checked(0).checked == true) {
					chvalue = "5";
				} else {
					chvalue = "1";
				}
				formObj.form1_in_msg_flag.value = chvalue;
				formObj.form1_in_mfr_gubun.value = "Y";
				IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
				sheetObj.DoAllSave("ESM_BKG_0991GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}
			break;

		case MULTI03: // 저장
			if (validateForm(sheetObj, formObj, sAction)) {
				if(!ComChkValid(frmObj)) return;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.RemoveAll();
				sheetObj.DataInsert(-1);
				formObj.f_cmd.value = MULTI;
				formObj.form1_in_msg_tp.value = "CMF02";
				if (formObj.CMF02Checked(0).checked == true) {
					chvalue = "2";
				} else if (formObj.CMF02Checked(1).checked == true) {
					chvalue = "5";
				} else {
					chvalue = "1";
				}	
				formObj.form1_in_msg_flag.value = chvalue;
				formObj.form1_in_mfr_gubun.value = "Y";
				IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
				sheetObj.DoAllSave("ESM_BKG_0991GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}

			break;
		}
	}

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * @param sheetObj Sheet
 * @param formObj form객체
 * @param sAction 작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case MULTI02:
		if (formObj.CMF01Checked(0).checked == false
				&& formObj.CMF01Checked(1).checked == false) {
			ComShowCodeMessage('BKG00676');
			// formObj.in_vvd_cd.focus();
			return false;
		}

		return true;
		break;
	case MULTI03:
		if (formObj.CMF02Checked(0).checked == false
				&& formObj.CMF02Checked(1).checked == false
				&& formObj.CMF02Checked(2).checked == false) {
			ComShowCodeMessage('BKG00676');
			// formObj.in_vvd_cd.focus();
			return false;
		}

		return true;
		break;
	}
}

/**
 * gubun값에 의한 radiobutton 초기화
 * @param gubun gubun
 */
function goCheck(gubun) {
	frmObj = document.form;
	if (gubun == "CMF01") {
		frmObj.CMF02Checked(0).checked = false;
		frmObj.CMF02Checked(1).checked = false;
		frmObj.CMF02Checked(2).checked = false;
		if(frmObj.form_action.value == COMMAND08) {
			if (frmObj.CMF01Checked(0).checked) {
				document.getElementById("row0").style.display="block";
				document.getElementById("row1").style.display="none";
				document.getElementById("row2").style.display="none";
				document.getElementById("row3").style.display="none";
				frmObj.del_cd.removeAttribute("required");
				frmObj.add_cd.removeAttribute("required");
				frmObj.cor_cd.removeAttribute("required");
				frmObj.del_reason.removeAttribute("required");
				frmObj.add_reason.removeAttribute("required");
				frmObj.cor_reason.removeAttribute("required");
			} else if (frmObj.CMF01Checked(1).checked) {
				document.getElementById("row0").style.display="none";
				document.getElementById("row1").style.display="block";
				document.getElementById("row2").style.display="none";
				document.getElementById("row3").style.display="none";
				frmObj.del_cd.setAttribute("required", "");
				frmObj.add_cd.removeAttribute("required");
				frmObj.cor_cd.removeAttribute("required");
				frmObj.add_reason.removeAttribute("required");
				frmObj.cor_reason.removeAttribute("required");
				if (frmObj.del_cd.value == "5") {
					frmObj.del_reason.setAttribute("required", "");
				}
			}
		}	
	} else if (gubun == "CMF02") {
		frmObj.CMF01Checked(0).checked = false;
		frmObj.CMF01Checked(1).checked = false;
		if(frmObj.form_action.value == COMMAND08) {
			if (frmObj.CMF02Checked(0).checked) {
				document.getElementById("row0").style.display="none";
				document.getElementById("row1").style.display="none";
				document.getElementById("row2").style.display="block";
				document.getElementById("row3").style.display="none";
				frmObj.add_cd.setAttribute("required", "");
				frmObj.cor_cd.removeAttribute("required");
				frmObj.del_cd.removeAttribute("required");
				frmObj.del_reason.removeAttribute("required");
				frmObj.cor_reason.removeAttribute("required");
				if (frmObj.add_cd.value == "6") {
					frmObj.add_reason.setAttribute("required", "");
				}
			} else if (frmObj.CMF02Checked(1).checked) {
				document.getElementById("row0").style.display="none";
				document.getElementById("row1").style.display="none";
				document.getElementById("row2").style.display="none";
				document.getElementById("row3").style.display="block";
				frmObj.cor_cd.setAttribute("required", "");
				frmObj.del_cd.removeAttribute("required");
				frmObj.add_cd.removeAttribute("required");
				frmObj.del_reason.removeAttribute("required");
				frmObj.add_reason.removeAttribute("required");
				if (frmObj.cor_cd.value == "6") {
					frmObj.cor_reason.setAttribute("required", "");
				}
			} else if (frmObj.CMF02Checked(2).checked) {
				document.getElementById("row0").style.display="none";
				document.getElementById("row1").style.display="block";
				document.getElementById("row2").style.display="none";
				document.getElementById("row3").style.display="none";
				frmObj.del_cd.setAttribute("required", "");
				frmObj.add_cd.removeAttribute("required");
				frmObj.cor_cd.removeAttribute("required");
				frmObj.add_reason.removeAttribute("required");
				frmObj.cor_reason.removeAttribute("required");
				if (frmObj.del_cd.value == "5") {
					frmObj.del_reason.setAttribute("required", "");
				}
			}
		}	
	}
}

/**
 * Form의 Conrol 초기화 및 초기 이벤트 등록
 */
function initControl() {
	axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);    // 기본 OnKeyPress 이벤트 (키입력)  - CoBkg.js에 정의
	axon_event.addListenerForm("change", "frmObj_OnChange", document.form);
}

/**
 * Form Element의 OnChange 이벤트
 */
function frmObj_OnChange() {
	var elementName = window.event.srcElement.getAttribute("name");
	with (document.form) {
		switch (elementName) {

			case "del_cd":
				if (del_cd.value == "5") {    // CMR(Del) 선택시
					document.getElementById("row1_1").style.display = "none";
					document.getElementById("row1_2").style.display = "block";
					 
					del_reason.setAttribute("required", "");
					add_reason.removeAttribute("required");
					cor_reason.removeAttribute("required");
						
				} else {
					document.getElementById("row1_1").style.display = "block";
					document.getElementById("row1_2").style.display = "none";
					del_reason.removeAttribute("required");
				}
			break;
			
			case "add_cd":
				if(add_cd.value == "6") {
					document.getElementById("row2_1").style.display = "none";
					document.getElementById("row2_2").style.display = "block";
					add_reason.setAttribute("required", "");
					del_reason.removeAttribute("required");
					cor_reason.removeAttribute("required");
				} else {
					document.getElementById("row2_1").style.display = "block";
					document.getElementById("row2_2").style.display = "none";
				}
			break;
			
			case "cor_cd":
				if(cor_cd.value == "6") {
					document.getElementById("row3_1").style.display = "none";
					document.getElementById("row3_2").style.display = "block";
					cor_reason.setAttribute("required", "");
					del_reason.removeAttribute("required");
					add_reason.removeAttribute("required");
				}
				else {
					document.getElementById("row3_1").style.display = "block";
					document.getElementById("row3_2").style.display = "none";
				}
		}
	}
}

/* 개발자 작업 끝 */