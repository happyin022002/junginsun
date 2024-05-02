/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1162.js
 *@FileTitle : ESM_BKG_1162
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.04
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2013.07.04 경종윤
 * 1.0 Creation
 * ------------------------------------------------------
 * history 
 *
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
 * @class ESM_BKG_1162 : ESM_BKG_1162 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1162() {
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
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var bkgNo = "";
var state = "";

var intervalId;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, document.form, IBSEARCH);
			break;

		case "btn_new":
			document.form.reset();
			sheetObject.RemoveAll();
			formObject.vvd.focus();
			break;

		case "btn_downExcel":
			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
		case "btn_downXML":
			doActionIBSheet(sheetObject, formObject, MULTI01);
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

function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
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
	}

	initControl();

}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	// ** Date 구분자 **/
	DATE_SEPARATOR = "-";

	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('blur', 'obj_deactivate', formObject); // - 포커스
	// 나갈때
	axon_event.addListenerFormat('focus', 'obj_activate', formObject); // - 포커스
	// 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	// 키보드
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	ComBtnDisable("btn_downExcel");
	ComBtnDisable("btn_downXML");

//	doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	document.form.vvd.focus()
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "uppernum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "upper":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "uppernum2":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyAlphabetNChar('uppernum');
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
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
			style.height = 260;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)
			
			// 틀고정 설정
			//FrozenCols = 14;

			var HeadTitle1 = "ibflag|cntr_no2|Seq.|Container No.|" +
					"TP|Seal No.|Kind/Code|Kind/Code|W/O|WGT|WGT (T)|E.WGT (T)|" +
					"PKG|PKG|B/L No.|POR|POR|POR|" +
					"A/POL|A/POL|A/POL|A/POD|A/POD|A/POD|B/POL|B/POL|B/POL|B/POD|B/POD|B/POD|DEL|DEL|DEL|" +
					"BS|R|D|TS|CTP|Hot|Special Cargo|Special Cargo";

			var headCount = ComCountHeadTitle(HeadTitle1);	
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 15, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 	0, daCenter, true, "cntr_no2", false, "", dfNone, 0, false, true, false);
			InitDataProperty(0, cnt++, dtSeq, 		40, daCenterTop, true, "seq", false, "", dfNone, 0, false, true, false);
//			InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, false, "sel");
			InitDataProperty(0, cnt++, dtData, 		90, daCenter, false, "cntr_no", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "cntr_tpsz_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_seal_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "seal_knd_cd", false, "", dfNone, 0, false, true, 1);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "seal_pty_tp_cd", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "wo_flg", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtData, 60, daRight, false, "a_cntr_wgt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "cntr_wgt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 50, daRight, false, "e_cntr_wgt", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 40, daRight, false, "pck_qty", false, "", dfNullInteger, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daRight, false, "pck_tp_cd", false, "", dfNone, 0, false, true);
			InitDAtaProperty(0, cnt++, dtData, 95, daLeft, false, "bl_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 45, daCenter, false, "por_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "por_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "por_nm");
			
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "pol_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "bpol_nm");

			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, false, "pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 25, daCenter, false, "pod_yd_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "bpod_nm");
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "a_pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "pol_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "apol_nm");
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "a_pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "pod_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "apod_nm");
			
			InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "del_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 25, daCenter, false, "del_nod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "del_nm");

			InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "blck_stwg_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "rcv_term_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 20, daCenter, false, "de_term_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "ts_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "bkg_cgo_tp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "hot_de_flg", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "spcl_cgo_desc_type", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 200, daCenter, false, "spcl_cgo_desc", false, "", dfNone, 0, false, true);

			ShowButtonImage = 1;
//			CountPosition = 0;
		}
		break;

	case "sheet2": // backendjob 용
		with (sheetObj) {

			// 높이 설정
			style.height = 20;
			// 전체 너비 설정
			SheetWidth = 300;
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
			var HeadTitle1 = "f_text1"
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 ROW ,COL ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME
			// ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
			InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "f_text1", false, "", dfNone, 0);

			// var idx = sheet2.DataInsert();

			RequestTimeOut = 6000;
			Visible = false; // backendjob 용으로 같이씀 참고 : 0015

		}
		break;
		
    case "sheet3":      //sheet1 init
        with (sheetObj) {

            // 높이 설정
            style.height = 220;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false)

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 2, 100);

            var HeadTitle = "XML";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,			"down_xml",	false,			"",      dfNone,	0,		false,		false);
			
			UseUTF8  = true;
								
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
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;

			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);

			var sXml = sheetObj.GetSearchXml("ESM_BKG_1162GS.do", FormQueryString(formObj));

			var key = ComGetEtcData(sXml, "KEY");
			
			// top.document.body.scrollTop = 0;
			intervalId = setInterval("doActionValidationResult(sheetObjects[1], '" + key + "');", 3000);

		}
		break;

	case IBDOWNEXCEL:
		var noRows = "";
		if (validateForm(sheetObj, formObj, sAction)) {
			for ( var i = 1; i <= sheetObj.RowCount + 1; i++) {
				// if( sheetObj.CellValue(i, "cntr_tpsz_cd") == "" ||
				// sheetObj.CellValue(i, "del_chk") == 0 )
				if (sheetObj.CellValue(i, "cntr_tpsz_cd") == "") {
					noRows = noRows + i + "|";
				}
			}

			// var noRows2 = "";
			if (noRows.length > 0)
				noRows = noRows.substring(0, noRows.length - 1);

//			sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "ibflag|cntr_no2|sel|meas_qty", noRows);
			sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "ibflag|cntr_no2|meas_qty", noRows);
		}
		break;

	case MULTI01: // Down XML
		if (!validateForm(sheetObj, formObj, sAction)) {
			return;
		}
		

		
		if(!ComShowConfirm(ComGetMsg("BKG95003", "Down XML"))) {
        	// sel 조회시 상태로 초기화
//			sheetObj.CheckAll2("sel") = 0;
			return false;
        }
		
		if (sheetObjects[2].RowCount > 0) {
			sheetObjects[2].RemoveAll() 
		} 
		sheetObjects[2].DataInsert(1);
		
		var savedFileName = formObj.vvd.value + ".xml";

		sheetObjects[2].WaitImageVisible = false;
		ComOpenWait(true);
		
		var rowCnt = sheetObj.RowCount;
		
//		for(var i=1; i<=rowCnt; i++) {
//			
//			if(sheetObj.CellValue(i, "sel") == 1) {
//				sheetObj.RowStatus(i) = "I";
//
//			} else {
//				sheetObj.RowStatus(i) = "";
//			}
//		} // end for(i)
		
		formObj.f_cmd.value = MULTI01;
//		var sParam = "";
//		
//		var sParamSheet = sheetObj.GetSaveString();
//
//		if (sParamSheet != "") {
//			sParam += "&" + sParamSheet;
//		}
//		
//		sParam += "&" + FormQueryString(formObj);
		
		ComOpenWait(true);
		var sXml = sheetObjects[2].GetSaveXml("ESM_BKG_1162GS.do", FormQueryString(formObj));

//		state = sheetObjects[2].EtcData("TRANS_RESULT_KEY");
		state = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		
		if (state == "S") {
			sheetObjects[2].CellText(1, "down_xml") = ComGetEtcData(sXml, "down_xml");
			sheetObjects[2].Down2Text("", "", "", savedFileName, "c:\\down_xml\\", "", false, false, true);
		} else {
			ComShowCodeMessage("BKG01021","XML");
		}
		
		ComOpenWait(false);		
		
		break;		
	}
}

/**
 * BackEndJob 처리
 * @param sheetObj Sheet
 * @param sKey sKey
 */
function doActionValidationResult(sheetObj, sKey) {

	// top.document.body.scrollTop = 0;
	var formObj = document.form;
	// sheetObjects[0].WaitImageVisble = false;
	// ComOpenWait(true);
	// top.document.body.scrollTop = 0;
	var sXml = sheetObj.GetSearchXml("ESM_BKG_1162GS.do?f_cmd=" + SEARCH01 + "&key=" + sKey + "&formCommand=" + formObj.f_cmd.value);
	// ComOpenWait(true);
	var arrXml = sXml.split("|$$|");
	var sJbStsFlg = ComGetEtcData(arrXml[0], "jb_sts_flg");
	

	// top.document.body.scrollTop = 0;
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, arrXml[0])) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {

		clearInterval(intervalId);
		ComOpenWait(false);
		// 성공메시지 보여주고
		// ComShowCodeMessage('BKG00166');
		// ComShowMessage(ComResultMessage(sXml));
		// sheet1, sheet2 다시 조회
		// var selRow = sheetObjects[0].SelectRow;
		if (document.form.f_cmd.value == "2") {
			sheetObjects[0].LoadSearchXml(arrXml[0]);
//			sheetObjects[4].LoadSearchXml(arrXml[1]);
			state = sheetObjects[0].EtcData("TRANS_RESULT_KEY");

			if (state == "S") {
				
				var rowCnt = sheetObjects[0].RowCount;
				// alert(rowCnt);
				if (rowCnt == 0) {
					ComBtnDisable("btn_downExcel");
					ComBtnDisable("btn_downXML");
				} else {
					ComBtnEnable("btn_downExcel");
					ComBtnEnable("btn_downXML");
				}
//				sheetObj.CheckAll("sel") = 0;				
			}
			
		} else {
			//alert("test");
			ComShowMessage(ComResultMessage(arrXml[0]));
		}
		return;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(intervalId);
		ComOpenWait(false);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(arrXml[0]));
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
	case IBSEARCH: // 조회
		
		//기본포멧체크
		if (!ComChkValid(formObj)) return false;

		return true;
		break;

	case MULTI01 : // down xml
		
		if(sheetObj == 0) {
    		ComShowCodeMessage("BKG01096");
    		return false;
		}
		
		//기본포멧체크
		if (!ComChkValid(formObj)) return false;

		
	case IBDOWNEXCEL:
		if(sheetObj.RowCount == 0) {
    		ComShowCodeMessage('BKG00109');
    		return false;
		}
		
		break;
		
		
	}

	return true;
}

/**
 * Sheet에서 클랙했을시 체크박스 처리
 * @param sheetObj Sheet
 * @param row row
 * @param col col
 */
function sheet1_OnClick(sheetObj, row, col) {

	var rowCnt = sheetObj.RowCount;
	var check = sheetObj.CellValue(row, "sel");
	var keyCntrNo = sheetObj.CellValue(row, "cntr_no");
	var colSaveName = sheetObj.ColSaveName(col);

	for (i = 1; i <= rowCnt + 2; i++) {

		if (colSaveName == "sel") {

			if (check == 0) {

				if (i == row)
					continue;

				if (keyCntrNo == sheetObj.CellValue(i, "cntr_no")) {
					sheetObj.CellValue(i, "sel") = 1;
				}

			} else if (check == 1) {

				if (i == row)
					continue;

				if (keyCntrNo == sheetObj.CellValue(i, "cntr_no")) {
					sheetObj.CellValue(i, "sel") = 0;
				}

			}
		}

	} // end for(i)

}


/* 개발자 작업 끝 */