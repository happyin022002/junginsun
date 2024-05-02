/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESM_BKG_0446.js
 *@FileTitle : Queue List Set Serarch
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.04.07
 *@LastModifier : 김기종
 *@LastVersion : 1.0
 * 2011.04.07 김기종
 * 1.0 Creation
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
 * @class ESM_BKG_0446 : ESM_BKG_0446 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0446() {
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
var currRows = 0;
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

			case "btn_add":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			case "btn_delete":
				if (!validateForm(sheetObject, formObject, IBDELETE)) {
					return false;
				}
				ComRowHideDelete(sheetObject, "del_chk");
				break;
			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btn_close":
				window.close();
				break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111");
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
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}

function initControl() {
	applyShortcut();
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
				style.height = 195;
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
				InitRowInfo(2, 1, 3, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				//   InitColumnInfo(17, 0, 0, true);
				InitColumnInfo(15, 0, 0, true);
		

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				var HeadTitle1 = "|Del.|Sel.|POL|DOC Type|Origin\nCountry|Delivery\nContinent|Hadling\nOffice|Customer|Customer|Customer|Customer|Sales\nRep.|SetSubSeq|Lane";
				var HeadTitle2 = "|Del.|Sel.|POL|DOC Type|Origin\nCountry|Delivery\nContinent|Hadling\nOffice|Type|Code|Code|Name|Sales\nRep.|SetSubSeq|Lane";
				

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "del_chk");
				InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "set_slct_flg");
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pol_cd", false, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtHidden, 80, daLeft, true, "doc_tp_cd", false, "", dfNone, 0, true, true);

				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "org_cnt_cd", false, "", dfNone, 0, true, true, 2);
				InitDataProperty(0, cnt++, dtCombo, 70, daLeft, true, "del_conti_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "hndl_ofc_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo, 50, daLeft, true, "bkg_cust_tp_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 35, daCenter, true, "cust_cnt_cd", false, "", dfNone, 0, true, true, 2);

				InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "cust_seq", false, "", dfNone, 0, true, true, 6);
				InitDataProperty(0, cnt++, dtData, 100, daLeft, true, "cust_nm", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "srep_cd", false, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtHidden, 0, daLeft, false, "set_sub_seq");
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "lane", false, "", dfNone, 0, true, true, 3);

				InitDataValid(0, "pol_cd", vtEngUpOnly);
				InitDataValid(0, "org_cnt_cd", vtEngUpOnly);
				InitDataValid(0, "hndl_ofc_cd", vtEngUpOnly);
				InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
				InitDataValid(0, "cust_seq", vtNumericOnly);
				InitDataValid(0, "lane", vtEngUpOnly);
			}
			break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회

			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = SEARCH;
				// (PageUrl, [CondParam], [PageParam], [IsAppend], [AppendRow])                	
				var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0446GS.do", FormQueryString(formObj));

				var arrXml = sXml.split(iterator);
				
				if (arrXml[0].length > 0) {
					arrXml[0] = ComReplaceStr(arrXml[0], "val|multidesc|ibflag|desc|name|", "cd|multidesc|ibflag|desc|nm|");
					ComSetIBCombo(sheetObjects[0], arrXml[0], "bkg_cust_tp_cd", true, "", "", "", "cd");
				}
				if (arrXml[1].length > 0) {
					arrXml[1] = ComReplaceStr(arrXml[1], "val|multidesc|ibflag|desc|name|", "cd|multidesc|ibflag|desc|nm|");
					ComSetIBCombo(sheetObjects[0], arrXml[1], "del_conti_cd", true, "", "", "", "cd");
				}

				if (arrXml[2].length > 0) {
					sheetObjects[0].LoadSearchXml(arrXml[2]);
					sheetObjects[0].Redraw = true;
				}
			}

			break;

		case IBSAVE: //저장
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}//end if
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value = MULTI;
				var params = FormQueryString(formObj);
				params = params + "&" + ComSetPrifix(sheetObj.GetSaveString(true));
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0446GS.do", params);
				sheetObj.LoadSearchXml(sXml);
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComBkgSaveCompleted();
				}
			}
			break;

		case IBINSERT: // 입력
			sheetObj.DataInsert(-1);
			sheetObj.CellValue2(sheetObj.LastRow, "doc_tp_cd") = "D";
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBDELETE:
			if (sheetObj.CheckedRows("del_chk") == 0) {
				ComShowMessage(msgs['COM12189']);
				return false;
			} else if (sheetObj.CheckedRows("del_chk") > 0) {
				ComShowMessage(msgs['COM12188']);
				return true;
			}
			break;

		case IBSAVE: // 조회
			for ( var i = 2; i <= sheetObj.RowCount + 1; i++) {
				if (sheetObj.CellValue(i, "org_cnt_cd") != "" && (sheetObj.CellValue(i, "org_cnt_cd")).length == 1) {
					ComShowMessage(msgs['BKG00465']);
					return false;
				}
				if (sheetObj.CellValue(i, "cust_cnt_cd") != "" && (sheetObj.CellValue(i, "cust_cnt_cd")).length == 1) {
					ComShowMessage(msgs['BKG00458']);
					return false;
				}
				if ((sheetObj.CellValue(i, "cust_seq")).length > 0) {
					if (sheetObj.CellValue(i, "cust_cnt_cd") == "" || (sheetObj.CellValue(i, "cust_cnt_cd")).length == 0) {
						ComShowMessage(msgs['BKG00458']);
						return false;
					}
				}
			}
			break;
	}

	return true;
}

/* 개발자 작업  끝 */