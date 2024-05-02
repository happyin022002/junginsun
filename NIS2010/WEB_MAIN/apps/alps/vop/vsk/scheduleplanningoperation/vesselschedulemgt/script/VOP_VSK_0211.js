/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0211.js
 *@FileTitle : VSL Voyage Check
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.02.16
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2009.07.08 유혁
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
 * @classVOP_VSK_0211 : VOP_VSK_0211 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0211() {
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

var sheetObjects = new Array();
var sheetCnt = 0;

var bkgVVDs = new Array(); // 해당 VVD에 Booking이 걸린경우
var virVVDs = new Array(); // 해당 VVD의 Virtual Port에 Booking이 걸린 경우
var bkgVirVVDs = new Array(); // 해당 VVD와 Virtual Port 모두에 Booking이 걸린 경우
var nonBkgVVDs = new Array(); // 어떤한 Booking이 걸리지 않은 경우

// 소트구분변수
var sortFlag = new Array();
sortFlag[0] = 'ASC';
sortFlag[1] = 'ASC';

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObj = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_simulation":
			// doActionIBSheet(sheetObj,formObject,IBSEARCH)
			var returnObj = new Object();

			for ( var i = 1; i <= sheetObj.RowCount; i++) {

				var vvd = new Object(); // VVD 정보
				vvd.vslSlanCd = sheetObj.CellValue(i, "vsl_slan_cd");
				vvd.vslCd = sheetObj.CellValue(i, "vsl_cd");
				vvd.skdVoyNo = sheetObj.CellValue(i, "skd_voy_no");
				vvd.skdDirCd = sheetObj.CellValue(i, "skd_dir_cd");
				vvd.turnSkdVoyNo = sheetObj.CellValue(i, "turn_skd_voy_no");
				vvd.turnSkdDirCd = sheetObj.CellValue(i, "turn_skd_dir_cd");

				if (sheetObj.CellValue(i, "bkg_status") == "Booking" &&
						(sheetObj.CellValue(i, "vir_bkg_status") == "BKG" || sheetObj.CellValue(i, "vir_bkg_status") == "BKGNOD")) {
					bkgVirVVDs.push(vvd);
				} else if (sheetObj.CellValue(i, "bkg_status") == "Booking") {
					bkgVVDs.push(vvd);
				} else if (sheetObj.CellValue(i, "vir_bkg_status") == "BKG"
						|| sheetObj.CellValue(i, "vir_bkg_status") == "BKGNOD") {
					virVVDs.push(vvd);
				} else {
					nonBkgVVDs.push(vvd);
				}
			}

			returnObj.bkgVVDs = bkgVVDs;
			returnObj.bkgVirVVDs = bkgVirVVDs;
			returnObj.virVVDs = virVVDs;
			returnObj.nonBkgVVDs = nonBkgVVDs;

			window.returnValue = returnObj;
			comPopupOK();
			break;

		case "btn_close":
			window.close();
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);

		doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
	}
	// doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 277;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false);

			var HeadTitle = "Seq|Lane CD|Vessel|Voyage No.|Direction|Booking Status|Start ETA||||||";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtSeq,		10,	daCenter,	false,	"seq",			false,	"",		dfNone,			0,			true,		true);
            InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	false,	"vsl_slan_cd",			false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	false,	"vsl_cd",			false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	false,	"skd_voy_no",			false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	false,	"skd_dir_cd",				false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"bkg_status",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	false,	"start_eta",			false,	"",		dfDateYmd,	0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	false,	"vir_bkg_status",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	false,	"update_flag",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	false,	"act_skd_input_flg",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	false,	"turn_skd_voy_no",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	false,	"turn_skd_dir_cd",		false,	"",		dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	false,	"ruse_prohi_flg",		false,	"",		dfNone,			0,			true,		true);
			
			ColHidden("seq") = true;
			SelectHighLight = false;

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {

	case IBSEARCH: // 조회

		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj) + "&" + ComGetSaveString(sheetObjects);
			
			//alert('sParam >> '+sParam);
			
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0211GS.do", sParam);
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
			
			var remark = ComGetEtcData(sXml, "remark");
			if (remark != "") {
				formObj.remark.value = remark;
			}
			break;

		}

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}

function sheet1_OnMouseDown(sheetObj, Button, Shift, Row, Col) {
	if (Button == 1 && sheetObj.MouseRow == 0) { // 헤더를 왼쪽버튼으로 클릭한 경우
		switch (sheetObj.MouseCol) {
		case 4:
			sheetObj.ColumnSort("bkg_status", sortFlag[0]);
			if (sortFlag[0] == 'DESC') {
				sortFlag[0] = 'ASC';
			} else {
				sortFlag[0] = 'DESC';
			}
			break;
		default:
			sheetObj.ColumnSort("seq", sortFlag[1]);
		}
	}
}

function sheet1_OnSearchEnd(sheetObj) {
	var dataRows = sheetObj.RowCount;
	var enableDelete = true;
	for ( var i = sheetObj.HeaderRows; i < dataRows + sheetObj.HeaderRows; i++) {

		// if(sheetObj.CellValue(i, "bkg_status")=="Booking" &&
		// sheetObj.CellValue(i, "update_flag")=="NO"){
			
		//::2013-07-02:ActualSchedule존재시 삭제불가능하도록 수정:://
	    if(sheetObj.CellValue(i, "act_skd_input_flg") == "Y") {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 128, 0); // Actual Schedule 존재 - 지우지 못하는 VVD
			enableDelete = false;
	    } else if (sheetObj.CellValue(i, "update_flag") == "NO") {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 168, 80); // 지우지 못하는 Booking VVD
			enableDelete = false;
		} else if (sheetObj.CellValue(i, "bkg_status") == "Booking") {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 153); // 지울수 있는 Booking VVD
		} else if (sheetObj.CellValue(i, "vir_bkg_status") == "BKGNOD"
				|| sheetObj.CellValue(i, "vir_bkg_status") == "BKG") {
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 255, 153); // Virtual Port에 Booking이 잡힌경우
		}

	}

	if (enableDelete) {
		ComBtnEnable("btn_simulation");
	} else {
		ComBtnDisable("btn_simulation");
	}

}