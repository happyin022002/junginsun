/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_mnr_0153.js 
 *@FileTitle : Disposal Planning by Headquarter
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.02
 *@LastModifier : WanGyu Kim
 *@LastVersion : 1.0
 * 2009.09.02 WanGyu Kim
 * 1.0 Creation
 * =========================================================
 * 2011.03.02 남궁진호 [CHM-201108450-01] 
 *            Plan작성이 월-> 분기 변경에 따른 분기List Box생성로직 추가
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
 * @class ees_mnr_0153 : ees_mnr_0153 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_mnr_0153() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* ********* General Functions ************* */
// 공통전역변수
var comboObjects = new Array();
var comboCnt = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
// TS타입일 경우 타입사이즈 배열 eq_type 별 3가지 모두 틀림
var uTpSz = new Array();
var gTpSz = new Array();
var zTpSz = new Array();
var disPlayTpSz = new Array();
// 로그인 유저의 Office 레벨 : HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴 (CoMnr.js에서
// MnrOfficeLevel 함수에 의해 셋팅)
var strMnrOfficeLevel = "";
// 조회 클릭시 상태를 저장
var retrieveClick = 0;
// 저장 타입을 저장
var saveType = 1;
// EQ Type 값을 저장
var comboValue = "";
// Month 값을 저장
var comboValue2 = "";
//Plan Year 값을 저장
var mnrPlnYrCal = ""; 
var mnrPlnYr1 = ""; 
var mnrPlnYr2 = ""; 
//Sheet Combo List
var comboListGrid = new Array();
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

var initflag = false; 

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH);
				break;
	
			case "btn_New":
				doActionIBSheet(sheetObject1, document.form, IBCLEAR, 1);
				break;
	
			case "btn_Save":
				saveType = 1;
				doActionIBSheet(sheetObject1, document.form, IBSAVE, 1);
				break;
	
			case "btn_Delete":
				saveType = 3;
				doActionIBSheet(sheetObject1, document.form, IBSAVE, 3);
				break;
	
			case "btn_Confirm":
				saveType = 2;
				doActionIBSheet(sheetObject1, document.form, IBSAVE, 2);
				break;
	
			case "btn_Calendar": // calender button
				var cal = new ComCalendar();
				cal.setDisplayType('year');
				cal.select(formObject.mnr_pln_yr, 'yyyy');
				mnrPlnYrCal = document.form.mnr_pln_yr.value;
				break;
	
			case "btn_RowAdd":
				doActionIBSheet(sheetObject2, document.form, IBINSERT);
				break;
	
			case "btn_RowDel":
				ComRowHideDelete(sheetObject2, "del_chk");
				break;
	
			case "btn_DownExcel":
				doActionIBSheet(sheetObject1, document.form, IBDOWNEXCEL);
				break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	// 버튼 설정
	MnrWaitControl(true);

	// Office Level 조회 및 전역변수(strMnrOfficeLevel)에 세팅
	MnrOfficeLevel(currOfcCd, rhqOfcCd);
	
	// Sheet 의 컬럼명 조회, 설정
	getSheetColumnName();

	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	// IBSheet 초기화
	setInitSheet("U");

	// Axon이벤트 초기화
	initControl();
	
	//화면초기화
	initflag = true;  
	doActionIBSheet(sheetObjects[1], document.form, IBCLEAR, 0);
	initflag = false;  
}
/**
 * IBCombo 기본 설정
 * 
 * @param {IBCombo}
 *            comboObj 초기설정될 콤보오브젝트
 * @param {Number}
 *            comboNo 콤보오브젝트 태그의 아이디에 붙인 일련번호
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	var formObject = document.form

	switch (comboNo) {
	case 1:
	case 2:
		with (comboObj) {
			SetColAlign("left|left");
			SetColWidth("25|75")
		}
		break;
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, eqKndCd) {
	var cnt = 0;
	// 컬럼 정보 설정전에 미리 루핑
	if (eqKndCd == 'U') {
		disPlayTpSz = uTpSz;
	} else if (eqKndCd == 'G') {
		disPlayTpSz = gTpSz;
	} else if (eqKndCd == 'Z') {
		disPlayTpSz = zTpSz;
	}
	
	switch (sheetObj.id) {
	case "sheet1": // sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 42;
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
			InitRowInfo(1, 1, 10, 100);

			var HeadTitle = "";
			HeadTitle = "||Seq.|Office|";
			for ( var i = 0; i < disPlayTpSz.length; i++) {
				HeadTitle += disPlayTpSz[i] + "|";
			}
			HeadTitle += "Total";

			var headCount = ComCountHeadTitle(HeadTitle) + 7;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 4, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW,COL,DATATYPE,WIDTH,D
			// ATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,"ibflag");
			InitDataProperty(0, cnt++, dtData, 1, daCenter, true,"");
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtData, 94, daCenter, true,"ctrl_ofc_cd", true, "", dfEngUpKey, 0, false, false);
			// TP/SZ 컬럼 생성 시작-------------------------------------------------//
			var calCulSum = "";
			for ( var i = 0; i < disPlayTpSz.length; i++) {
				if (strMnrOfficeLevel == "L2" || strMnrOfficeLevel == "L3") {
					InitDataProperty(0, cnt++, dtData, 50, daRight, false,"cntr" + (i + 1) + "_chg_val", false, "",dfNullInteger, 0, false, false);
				} else {
					InitDataProperty(0, cnt++, dtData, 50, daRight, false,"cntr" + (i + 1) + "_chg_val", false, "",dfNullInteger, 0, true, true,	6);
				}
				if(i == 0) {
					calCulSum += "|"+(i+4)+"|";
				} else {
					calCulSum += "+|"+(i+4)+"|";
				}
			}
			// TP/SZ 컬럼 생성 끝-------------------------------------------------//
			InitDataProperty(0, cnt++, dtData, 50, daRight, true, "total",false, calCulSum, dfNullInteger, 0, false, false);
			// Hidden 컬럼
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true,"cre_usr_id", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true,"cre_dt",false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true,"mnr_pln_seq", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true,"mnr_pln_flg", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true,"mnr_pln_ofc_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true,"mnr_pln_grp_no", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true,"sheet_gubn", false, "", dfNone);

			CountPosition = 0;

			if(strMnrOfficeLevel == "L1") {
				// Summary Office 설정
				setSummaryRowOffice();
			}
		}
		break;

	case "sheet2": // sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 322;
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
			InitRowInfo(1, 1, 10, 100);

			var HeadTitle = "|Sel|Seq.|Office|";
			for ( var i = 0; i < disPlayTpSz.length; i++) {
				HeadTitle += disPlayTpSz[i] + "|";
			}
			HeadTitle += "Total"

			var headCount = ComCountHeadTitle(HeadTitle) + 4;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 4, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,SAVENAME,KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,"ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true,"del_chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtComboEdit, 60, daCenter, true,"ctrl_ofc_cd", true, "", dfEngUpKey, 0, true, true, 6,false);
			// TP/SZ 컬럼 생성 시작-------------------------------------------------//
			var calCulSum = "";
			for ( var i = 0; i < disPlayTpSz.length; i++) {
				InitDataProperty(0, cnt++, dtAutoSumEx, 50, daRight, false,"cntr" + (i + 1) + "_chg_val", false, "",dfNullInteger, 0, true, true,	6);
			
				if(i == 0) {
					calCulSum += "|"+(i+4)+"|";
				} else {
					calCulSum += "+|"+(i+4)+"|";
				}
			}
			// TP/SZ 컬럼 생성 끝-------------------------------------------------//
			InitDataProperty(0, cnt++, dtAutoSumEx, 50, daRight, true, "total",false, calCulSum, dfNullInteger, 0, false, false);
			// Hidden 컬럼
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true,"mnr_pln_seq", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true,"mnr_pln_dtl_seq", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true,"mnr_pln_flg", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true,"sheet_gubn", false, "", dfNone);

			SelectionMode = smSelectionRow;
			SelectHighLight = true;
			SelectFontBold = false;
			SelectBackColor = RgbColor(SelectBackColorR, SelectBackColorG,SelectBackColorB);

			CountPosition = 0;
			// 기본설정을 변경한다. 원래는 첫번째 col의 "TOTAL"이라고 찍히는 property
			messageText("Sum") = "";
			// 쉬트 콤보 데이터 조회 및 설정
			setSheetCombo();
		}
		break;
	}

}

/**
 * IBCombo Object를 배열로 등록
 * 
 * @param {IBCombo}
 *            combo_obj 배열로 등록될 IBCombo Object
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 */
function initControl() {
	axon_event.addListenerForm('blur', 'obj_blur', document.form); // - 포커스 나갈때
	axon_event.addListenerFormat('focus', 'obj_focus', document.form); // - 포커스들어갈때
	axon_event.addListenerForm('keypress', 'obj_keypress', document.form); // -키입력할때
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur() {
	ComChkObjValid(event.srcElement);
	obj = event.srcElement;
	if(obj.name == "mnr_pln_yr") {
		mnrPlnYr2 = obj.value;
		//Plan Year 수정시
		if(mnrPlnYr1 != mnrPlnYr2) {
			//조회후면
			if(retrieveClick == 1) {
				//Header 초기화 의사 확인
				if(!ComShowCodeConfirm("MNR00192")) {
					document.form.mnr_pln_yr.value = mnrPlnYr1;
					return;
				}
			}
			// 모든 쉬트를 초기화
			for (i = 0; i < sheetObjects.length; i++) {
				sheetObjects[i].RemoveAll();
			}
			// Summary Office 설정
			if(strMnrOfficeLevel == "L1") {
				setSummaryRowOffice();
			}
			//쉬트 Edit 설정
			setGridEdit();
			//조회상태
			retrieveClick = 0;
		}
	}
}

/**
 * HTML Control의 focus이벤트에서 Validation을 체크한다. <br>
 */
function obj_focus() {
	ComClearSeparator(event.srcElement);
	obj = event.srcElement;
	if(obj.name == "mnr_pln_yr") {
		mnrPlnYr1 = obj.value;
		if(mnrPlnYrCal != "") {
			//버튼으로 수정
			if(mnrPlnYrCal != mnrPlnYr1){
				//조회후면
				if(retrieveClick == 1) {
					//Header 초기화 의사 확인
					if(!ComShowCodeConfirm("MNR00192")) {
						document.form.mnr_pln_yr.value = mnrPlnYrCal;
						return;
					}
				}
				// 모든 쉬트를 초기화
				for (i = 0; i < sheetObjects.length; i++) {
					sheetObjects[i].RemoveAll();
				}
				// Summary Office 설정
				if(strMnrOfficeLevel == "L1") {
					setSummaryRowOffice();
				}
				//쉬트 Edit 설정
				setGridEdit();
				//조회상태
				retrieveClick = 0;
			}
		}
	}
}

/**
 * HTML Control의 onkeypress 이벤트에서 Validation을 체크한다. <br>
 */
function obj_keypress() {
	obj = event.srcElement;
	if (obj.dataformat == null) {return;}
	window.defaultStatus = obj.dataformat;
	switch (obj.dataformat) {
		case "yyyy":
			ComKeyOnlyNumber(event.srcElement);
			break;
	}
}

/**
 * COMBO 변경 이벤트 EQ_Type 변경시 Sheet 컬럼 재설정
 * 
 * @param {IBMultiCombo}comboObj 변경한 콤보 오브젝트
 * @param {Number}Index_Code 변경한 콤보의 코드
 * @param {String}Text 변경한 콤보의 명
 */
function eq_knd_cd_OnChange(comboObj, Index_Code, Text) {
	if(initflag == false){
		 
		//변경된 Data 존재하는데 다시 조회할건지에 대한 메시지 표시
		if(sheetObjects[0].IsDataModified == true || sheetObjects[1].IsDataModified == true) {
			if(!ComShowCodeConfirm("MNR00232")) {
				document.form.eq_knd_cd.Code2 = comboValue;
				return;
			}
		}
		var eqKndCd = ComGetObjValue(comboObj);
		setInitSheet(eqKndCd); //IBSheet 초기화
		retrieveClick = 0;
	}
	comboValue = ComGetObjValue(comboObj);
}
/**
 * COMBO 변경 이벤트 Month 변경시 조회클릭변수 재설정
 * 
 * @param {IBMultiCombo}comboObj 변경한 콤보 오브젝트
 * @param {Number}Index_Code 변경한 콤보의 코드
 * @param {String}Text 변경한 콤보의 명
 */
function mnr_pln_grp_no_OnChange(comboObj, Index_Code, Text) {
	if(initflag == false){
		if(retrieveClick == 1) {
			if(!ComShowCodeConfirm("MNR00192")) {
				document.form.mnr_pln_grp_no.Code2 = comboValue2;
				return;
			}
		}
		// 모든 쉬트를 초기화
		for (i = 0; i < sheetObjects.length; i++) {
			sheetObjects[i].RemoveAll();
		}
		// Summary Office 설정
		if(strMnrOfficeLevel == "L1") {
			setSummaryRowOffice();
		}
		//쉬트 Edit 설정
		setGridEdit();
        //조회상태
		retrieveClick = 0;
	}
	comboValue2 = ComGetObjValue(comboObj);
}
/**
 * 조회 완료 이벤트 조회후 조건부의 ReadOnly 항목(PlanDate, PlanUser, Status) 값 설정
 * 
 * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
 * @param {String}errMsg 조회 후 메시지
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	// 조회된 값이 없을 때
	if (sheetObj.SearchRows == 0) {
		setBtnEnDisable("")		//버튼 재설정
		if(strMnrOfficeLevel == "L1") {
			// Summary Office 설정
			setSummaryRowOffice();
		}
		return;
	}
	//조회된 Header 가  2건 이상 일때  
    if(sheetObj.SearchRows > 1) {
    	for(i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
   		    var mnrPlnOfcCd = sheetObj.CellValue(i, "mnr_pln_ofc_cd");
   		    var ctrlOfcCd   = sheetObj.CellValue(i, "ctrl_ofc_cd");
   		    if(ctrlOfcCd != mnrPlnOfcCd) {
   			     sheetObj.RowDelete(i, false);
   		    }
    	}
    }
	// 조건부 값 설정
	var formObj = document.form;
	var creDt 		= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "cre_dt");
	var creUsrId 	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "cre_usr_id");
	var mnrPlnFlg 	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "mnr_pln_flg");
	var mnrPlnOfcCd	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "mnr_pln_ofc_cd");
	var ctrlOfcCd 	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "ctrl_ofc_cd");

	// Status Name 설정
	var statusNm = "";
	if (mnrPlnFlg == "N") {
		statusNm = "Saved";
		setBtnEnDisable("N");

	} else if (mnrPlnFlg == "Y") {
		statusNm = "Confirmed";
		setBtnEnDisable("Y");

	} else {
		statusNm = "New"
		setBtnEnDisable("");
	}

	
	if(strMnrOfficeLevel == "L2" && (mnrPlnOfcCd!=ctrlOfcCd)) {
		formObj.cre_dt.value 		= ComGetNowInfo("ymd");	// Plan Date
		formObj.cre_usr_id.value	= currOfcCd; 			// Plan User
		formObj.status.value 		= "New"; 				// Status
	} else {
		formObj.cre_dt.value 		= creDt; 				// Plan Date
		formObj.cre_usr_id.value	= creUsrId;				// Plan User
		formObj.status.value 		= statusNm; 			// Status
	}
	
	setGridEdit(); //Grid Edit 설정
}

/**
 * 저장후 결과메세지 표시
 * 
 * @param {IBSheet}sheetObj 저장이벤트의 시트 오브젝트
 * @param {String}ErrMsg 에러메세지
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg == "") {
		//Save
		if(saveType==1) {			
			ComShowCodeMessage("MNR00023");	//Data saved successfully
		//Confirm
		} else if (saveType==2) {
			ComShowCodeMessage("MNR00313");	//Data was confirmed successfully
		//Delete
		} else if (saveType==3) {
			// Detail 쉬트를 초기화
			sheetObjects[1].RemoveAll();
			ComShowCodeMessage("MNR00020");	//Data deleted successfully
		} else {
			ComShowCodeMessage("MNR00023");
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	} else {
		ComShowCodeMessage("MNR00008", ErrMsg);
	}
}

/** 
 * sheet1 셀의 값 변경시 발생하는 Event
 *     Disposal Planning summary Data 입력시 
 *     Summary Qty 와 Detail Qty 를 체크하여 Detail Qty 가 많을때 리턴
 * @param	{IBSheet}	sheetObj	시트오브젝트
 * @param	{Int}		Row			Row
 * @param	{String}	Col			Column Index
 * @param	{String}	Val			Value
 */
function sheet1_OnChange(sheetObj,Row, Col, Value){
	//Data 입력체크
	checkSetTpSzQty(sheetObj,Row, Col);
}

/** 
 * sheet2 셀의 값 변경시 발생하는 Event
 *     Disposal Planning Detail Data 입력시 
 *     Summary Qty 와 Detail Qty 를 체크하여 Detail Qty 가 많을때 리턴
 * @param	{IBSheet}	sheetObj	시트오브젝트
 * @param	{Int}		Row			Row
 * @param	{String}	Col			Column Index
 * @param	{String}	Val			Value
 */
function sheet2_OnChange(sheetObj,Row, Col, Value){
	//Data 입력체크
	checkSetTpSzQty(sheetObj,Row, Col); 
	//Office 입력체크
	with(sheetObj) {
		var colname = ColSaveName(Col);
		if(colname=="ctrl_ofc_cd") {
	 		for(var j = 0; j < comboListGrid[0].length;j++){ 
				var tempText = comboListGrid[0][j].split("|");
				//존재하는 코드
				if(tempText[0]==Value) {return ;}   
			}
			//존재하지 않는 코드
			ComShowCodeMessage("MNR00165",Value);
			sheetObj.CellValue2(Row,Col) ="";
			sheetObj.SelectCell(Row,Col, true);
		}
	}
	
}

/**
 * Sheet1관련 프로세스 처리
 * 
 * @param {IBSheet}sheetObj 프로세스 처리될 시트오브젝트
 * @param {Form}formObj 프로세스 처리될 폼오브젝트
 * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
 */
function doActionIBSheet(sheetObj, formObj, sAction, sActionIdx) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	// 초기화
	case IBCLEAR:
		// 버튼 , 프로그레스바 설정 시작
		sheetObj.WaitImageVisible = false;
		MnrWaitControl(true);

		// 모든 쉬트를 초기화
		for (i = 0; i < sheetObjects.length; i++) {
			sheetObjects[i].RemoveAll();
		}
		// Only Loading
		if (sActionIdx == 0) {
			// 조건부 콤보데이타 초기화
			for ( var i = 0; i < comboObjects.length; i++) {
				comboObjects[i].RemoveAll();
			}
			// (EQ Type)콤보데이타 조회
			var sCondition = new Array (
				new Array("MnrGenCd","CD00094", "COMMON"),		//QTA
				new Array("MnrGenCd","SELHO","CUSTOM9") //EQ Type
			)             
			var comboList = MnrComSearchCombo(sheetObj,sCondition);
			
			//콤보데이타에 값을 세팅함        
			//*** EQ_TYPE	
			if(comboList[1] != null){	
				for(var j = 0; j < comboList[1].length;j++){ 
					var tempText = comboList[1][j].split("|");	  
					formObj.eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
						
					if(j == 0){	 	
						comboDefValue = tempText[0];  
					}	 
				}				    
			}	 	
			formObj.eq_knd_cd.Code = comboDefValue; 
			
			// (Month)콤보데이타 값을 세팅함
				if(comboList[0] != null){ 	       
					for(var j = 0; j < comboList[0].length;j++){ 
						var tempText = comboList[0][j].split("|");  
						formObj.mnr_pln_grp_no.InsertItem(j, tempText[1] ,tempText[0]);
						if(j == 0){	 	
							comboDefValue2 = tempText[0];
						}	  	 		 
					}     			  	    
				}  		
				formObj.mnr_pln_grp_no.Code = comboDefValue2; 
		}
		// 초기값 설정
		formObj.eq_knd_cd.Code = "U"; // EQ Type
		formObj.mnr_pln_yr.value = ComGetNowInfo("yy"); // Plan Year
//		formObj.mnr_pln_grp_no.Code2 = ComGetNowInfo("mm"); // Month
		formObj.mnr_pln_grp_no.Code2 = comboDefValue2; // Month
		formObj.cre_dt.value = ComGetNowInfo("ymd"); // Plan Date
		formObj.status.value = "New"; // Status

		//쉬트 Edit 설정
		setGridEdit(); 
		
		// 조회 클릭 상태값
		retrieveClick = 0;

		// 버튼 , 프로그레스바 설정 끝
		MnrWaitControl(false);
		sheetObj.WaitImageVisible = true;

		if(strMnrOfficeLevel == "L1") {
			// Summary Office 설정
			setSummaryRowOffice();
		}
		
		break;

	// 조회
	case IBSEARCH:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			formObj.mnr_office_level.value = strMnrOfficeLevel;
			formObj.cntr_tpsz_cd_seq.value = disPlayTpSz;
			var sXml = sheetObj.GetSearchXml("EES_MNR_0152GS.do",FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			for ( var i = 0; i < arrXml.length; i++) {
				sheetObjects[i].LoadSearchXml(arrXml[i]);
			}

			retrieveClick = 1;
		}
		break;

	// 저장
	case IBSAVE:
		if (validateForm(sheetObj, formObj, sAction, sActionIdx)) {
			if(strMnrOfficeLevel == "L1") {
				//이미 저장된 데이터가 있는지 체크 조회
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("EES_MNR_0152GS.do",FormQueryString(formObj));
				var strCnt = ComGetEtcData(sXml, "cnt");
				var intCnt = ComParseInt(strCnt); 
				if(retrieveClick == 0 && intCnt > 0) {
					ComShowCodeMessage("MNR00236");
					return;
				}
			}
			// OfficeLevel == L2(SELHO)
			if (strMnrOfficeLevel == 'L2') {
				var mnrPlnOfcCd = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "mnr_pln_ofc_cd"); // mnr_pln_ofc_cd
				var ctrlOfcCd = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "ctrl_ofc_cd"); // ctrl_ofc_cd
				if (ctrlOfcCd != mnrPlnOfcCd) {
					// Header 신규 재설정
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"mnr_pln_seq") = ""; // mnr_pln_seq
					sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"mnr_pln_ofc_cd") = ctrlOfcCd; // mnr_pln_ofc_cd
				}
			}
			//Save
			if(sActionIdx == 1) {
				sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"mnr_pln_flg") = "N"; // Status
			}
			// Confirm
			if (sActionIdx == 2) {
				sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"mnr_pln_flg") = "Y"; // Status
			}
			// Delete
			if (sActionIdx == 3) {
				// ibflag
				sheetObjects[0].RowStatus(sheetObjects[0].HeaderRows) = "D"; // Header
				for ( var i = sheetObjects[1].HeaderRows; i < sheetObjects[1].LastRow; i++) { // Detail
					sheetObjects[1].RowStatus(i) = "D";
				}
			}

			formObj.f_cmd.value = MULTI;
			formObj.cntr_tpsz_cd_seq.value = disPlayTpSz;
			var sParam = ComGetSaveString(sheetObjects);
			if (sParam == "")
				return;
			sParam += "&" + FormQueryString(formObj);
			var sXml = sheetObjects[0].GetSaveXml("EES_MNR_0152GS.do", sParam);
			sheetObjects[0].LoadSaveXml(sXml);
			sheetObjects[1].LoadSaveXml(sXml);
		}
		break;

	// Row Add
	case IBINSERT:
		if (validateForm(sheetObj, formObj, sAction)) {
			var Row = sheetObj.DataInsert(-1);
			var mnrPlnSeq = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "mnr_pln_seq");
			var mnrPlnOfcCd = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "mnr_pln_ofc_cd");
			var ctrlOfcCd = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "ctrl_ofc_cd");
			if (strMnrOfficeLevel == 'L2' && (ctrlOfcCd != mnrPlnOfcCd)) {
				mnrPlnSeq = "";
			}
			sheetObj.CellValue(Row, "mnr_pln_seq") = mnrPlnSeq;
		}
		break;

	// Down Excel
	case IBDOWNEXCEL:
		if (validateForm(sheetObj, formObj, sAction)) {
			//sheetObjects[0].Down2Excel(-1);
			sheetObjects[0].SpeedDown2Excel(-1);
			if(sheetObjects[1].RowCount > 0) {
				//sheetObjects[1].Down2Excel(-1, true);
				sheetObjects[1].SpeedDown2Excel(-1, true);
			}
		}
		break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * 
 * @param {IBSheet}sheetObj 유효성을 검증할 시트오브젝트
 * @param {Form}formObj 유효성을 검증할 폼오브젝트
 * @param {Number}sAction 분기처리될 액션의 상수값(CoObject.js에 정의)
 */
function validateForm(sheetObj, formObj, sAction, sActionIdx) {
	with (formObj) {
		// 조회시 체크
		if (sAction == IBSEARCH) {
			// Dataformat
			if (!ComChkValid(formObj)) {
				return false;
			}
		}
		// 저장시 체크
		else if (sAction == IBSAVE) {
			if(strMnrOfficeLevel == "L2") {
				// 조회후 저장 메세지
				if (retrieveClick == 0) {
					var saveTypeName = "저장";
					if (sActionIdx == 1) {
						saveTypeName = "저장";
					} else if (sActionIdx == 2) {
						saveTypeName = "확정";
					} else if (sActionIdx == 3) {
						saveTypeName = "삭제";
					} else {
						saveTypeName = "저장";
					}
					ComShowCodeMessage("MNR00199", saveTypeName,"Disposal Planning ");
					return false;
				}
				// 조회값이 존재 하지 않으면
				if(sheetObjects[0].RowCount < 1) {
					ComShowCodeMessage("MNR00204");
					return false;
				}
			}
			//TP/SZ 값이 하나도 입력 안됐을때
			var tpszSum = 0;
			tpszSum = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "total");
			if(tpszSum == 0) {
				ComShowCodeMessage("MNR00238");
				return false;
			}
			
			// Dataformat
			if (!ComChkValid(formObj)) {
				return false;
			}

			// 중복체크(save, confirm)
			if (sActionIdx == 1 || sActionIdx == 2) {
				var Row = sheetObjects[1].ColValueDup("ctrl_ofc_cd");
				if (sheetObjects[1].IsDataModified) {
					if (Row > 0) {
						ComShowCodeMessage("MNR00006", (Row) + " row ");
						sheetObjects[1].SelectCell(Row, "ctrl_ofc_cd", true);
						return false;
					}
				}
			}
			// Confirm 
			if (sActionIdx == 2) {
				//의사 확인
				if (!ComShowCodeConfirm("MNR00197")) {
					return false
				}
			}
			// Delete 
			if (sActionIdx == 3) {
				//저장할 값이 없을때
				
				//의사 확인
				if (!ComShowCodeConfirm("MNR00026")) {
					return false
				}
			}
		}
		// Row Add 시 체크
		else if (sAction == IBINSERT) {
			if (strMnrOfficeLevel == "L2") {
				// 조회후 저장 메세지
				if (retrieveClick == 0) {
					ComShowCodeMessage("MNR00199", "Row Add","Disposal Planning Summary");
					return false;
				}
				// 조회값이 존재 하지 않으면
				if(sheetObjects[0].RowCount < 1) {
					ComShowCodeMessage("MNR00204");
					return false;
				}
			}
		}
		// Down Excel 시 체크
		else if (sAction == IBDOWNEXCEL) {
			// 조회후 저장 메세지
			if (retrieveClick == 0) {
				ComShowCodeMessage("MNR00199", "Down Excel","Disposal Planning Summary");
				return false;
			}
			
		}
	}
	return true;
}

/* ********* User Functions ************* */
/**
 * EQ_Type 에 따른 쉬트의 컬럼명을 구한다.
 */
function getSheetColumnName() {
	var arrXml = MnrComSearchGrid2(sheetObjects[0], "DSPTypeSize");
	if (arrXml != null) {
		for ( var i = 0; i < arrXml.length; i++) {
			if (i == 0) {
				uTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
			} else if (i == 1) {
				zTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
			} else if (i == 2) {
				gTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
			}
		}
	}
}

/**
 * Summray Office 값 설정
 */
function setSummaryRowOffice() {
	//버튼설정
	setBtnEnDisable("");
	//조건부 ReadOnly 항목 재설정
	var formObj = document.form;
	formObj.cre_dt.value		= ComGetNowInfo("ymd");	// Plan Date
	formObj.cre_usr_id.value	= strUsrId;				// Plan User
	formObj.status.value 		= "New"; 				// Status
	//Header 값 설정
	var mnrPlnGrpNo = ComGetObjValue(form.document.mnr_pln_grp_no); // Month
	var mnrPlnOfcCd = "";
	if (strMnrOfficeLevel == "L1") {
		mnrPlnOfcCd = currOfcCd;
	} else {
		mnrPlnOfcCd = rhqOfcCd;
	}
	sheetObjects[0].RemoveAll();
	sheetObjects[0].DataInsert(-1);
	sheetObjects[0].CellValue2(sheetObjects[0].HeaderRows, "ctrl_ofc_cd") 		= currOfcCd; 	// Office
	sheetObjects[0].CellValue2(sheetObjects[0].HeaderRows, "mnr_pln_ofc_cd") 	= mnrPlnOfcCd; 	// mnr_pln_ofc_cd
	sheetObjects[0].CellValue2(sheetObjects[0].HeaderRows, "sheet_gubn") 		= "sheet1"; 	// Sheet
	sheetObjects[0].CellValue2(sheetObjects[0].HeaderRows, "mnr_pln_grp_no")	= mnrPlnGrpNo; 	// Month
	sheetObjects[0].CellValue2(sheetObjects[0].HeaderRows, "mnr_pln_seq")		= ""; 			// mnr_pln_seq
	sheetObjects[0].RowStatus(sheetObjects[0].HeaderRows)= "R";
}

/**
 * 쉬트 콤보 데이터 조회 및 설정
 */
function setSheetCombo() {
	if (strMnrOfficeLevel != 'L2') {
		ComShowCodeMessage("MNR00010", "Authority");
		MnrWaitControl(true);
		return;
	}

	var sCondition = new Array (
		new Array("MdmOrganization","SEARCH",currOfcCd) 
	)
	comboListGrid = MnrComSearchCombo(sheetObjects[0],sCondition);
	
	var sheetComboText = "";
	var sheetComboCode = "";
	var sheetComboDefault = "";
	if (comboListGrid != null) {
		for ( var i = 0; i < comboListGrid[0].length; i++) {
			var tempText = comboListGrid[0][i].split("|");
			sheetComboText += tempText[1] + "|";
			sheetComboCode += tempText[0] + "|";
		}
		sheetObjects[1].InitDataCombo(0, "ctrl_ofc_cd", sheetComboCode,sheetComboCode, sheetComboDefault);
	}
}

/**
 * Status 와 권한에 따른 버튼 Disable/Enable 설정
 * @param	{String}	strGb	Status 상태값
 */
function setBtnEnDisable(strGb) {
	var mnrPlnOfcCd	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"mnr_pln_ofc_cd");
	var ctrlOfcCd 	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"ctrl_ofc_cd");

	//Status:Saved
	if(strGb == "N") {
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_Confirm");
		ComBtnEnable("btn_RowAdd");
		ComBtnEnable("btn_RowDel");
		ComBtnEnable("btn_DownExcel");
	//Status:Confirmed
	} else if (strGb == "Y") {
		//Level:1
		if(strMnrOfficeLevel == "L1") {
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_Confirm");
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_RowDel");

		//Level:2
		} else {
			//자신의 값이 아닐때
			if(mnrPlnOfcCd != ctrlOfcCd) {
				ComBtnDisable("btn_Delete");
			} else {
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Delete");
				ComBtnDisable("btn_Confirm");
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_RowDel");
			}
		}
		ComBtnEnable("btn_DownExcel");
	//Status:Etc
	} else {
		ComBtnEnable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnEnable("btn_Confirm");
		ComBtnEnable("btn_RowAdd");
		ComBtnEnable("btn_RowDel");
		ComBtnDisable("btn_DownExcel");
	}
}

/** 
 * Disposal Planning Data 입력시 
 *     Summary Qty 와 Detail Qty 를 체크하여 Detail Qty 가 많을때 리턴
 * @param	{IBSheet}	sheetObj	시트오브젝트
 * @param	{Int}		Row			Row
 * @param	{String}	Col			Column Index
 */
function checkSetTpSzQty(sheetObj,Row, Col){
	var colname = sheetObj.ColSaveName(Col); 
	var headerValue		= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, colname);
	var detailSumValue	= sheetObjects[1].SumValue(0, colname);
	if(headerValue < detailSumValue) {
		ComShowCodeMessage("MNR00231", "Detail Qty", "Header Qty");
		sheetObj.CellValue2(Row, Col) = "";
		sheetObj.ReturnCellData(Row, Col);
		sheetObj.SelectCell(Row, Col);
	}
}

/**
 * Status 따른 Sheet Editable 설정
 * @param	{String}	statusGubn	Status 상태값
 */
function setGridEdit() {
	var mnrPlnFlg 	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "mnr_pln_flg");
	if(mnrPlnFlg == "Y") {
		sheetObjects[0].Editable = false;
		var mnrPlnOfcCd	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"mnr_pln_ofc_cd");
		var ctrlOfcCd 	= sheetObjects[0].CellValue(sheetObjects[0].HeaderRows,"ctrl_ofc_cd");
        if(mnrPlnOfcCd == ctrlOfcCd) {
        	sheetObjects[1].Editable = false;
        } else {
        	sheetObjects[1].Editable = true;
        }
		
	} else {
		sheetObjects[0].Editable = true;
		sheetObjects[1].Editable = true;
	}
}

/**
 * IBSheet 의 초기화
 * @param	{String} eqKndCd	EQType코드
 */
function setInitSheet(eqKndCd) {
	for (i = 0; i < sheetObjects.length; i++) {
		sheetObjects[i].Reset();
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], eqKndCd);
		ComEndConfigSheet(sheetObjects[i]);
	}

}
