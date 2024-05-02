/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0192.js
 *@FileTitle : B/L CUSTOMER
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.21 김경섭
 * 1.0 Creation
===============================================================================
 History
 2011.01.04 이일민 [CHM-201008007-01] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정)
 2012.03.29 전성진 [CHM-201217014] 악성 화주 선택시 Warning Message 변경 요청
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
 * @extends 
 * @class esm_bkg_0192  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0192() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var prefix = "sheet1_";//IBSheet 구분자
var prefix2 = "sheet2_";//IBSheet 구분자

var rowsPerPage = 50;
/*********************** EDTITABLE MULIT COMBO START ********************/
var comboCnt = 0;
var comboObjects = new Array();
/*********************** EDTITABLE MULIT COMBO END ********************/

var isValidateFail = false;

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (var i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// Consignee 일 경우에만 Individual Person Flag를 활성화 한다.
	if(form.indiv_dp_flg.value == "Y"){

		document.all.indiv_display.style.display = "";
		
		// Individual Person Flag CheckBox 제어
		if(form.indiv_pson_flg.value == "Y"){
			form.indiv_pson_flg.checked = true;
		} else {
			form.indiv_pson_flg.checked = false;
		}
		
		delCneeCd();
	}

	initControl();
	if (form.cust_cnt_cd.value != "" && form.cust_seq.value != "") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	form.cust_cnt_cd.focus();
	
	if(document.form.cust_cnt_cd.value !="US"){
			document.form.area_cd.className = "input2";
			document.form.area_cd.readOnly = true;
		}else{
			document.form.area_cd.className = "input";
			document.form.area_cd.readOnly = false;
		}
}

function initControl() {
	var formObject = document.form;
	axon_event.addListenerFormat('keypress', 'bkg_keypress', formObject); //- 키보드 입력할때
	axon_event.addListenerForm('beforedeactivate', 'bkg_deactivate', formObject); //- 포커스 나갈때     
	axon_event.addListenerFormat('beforeactivate', 'bkg_activate', formObject); //- 포커스 들어갈때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change'				, 'cust_cnt_cd_OnChange'	, form);
}

/*********************** KEY EVENT START ********************/
function bkg_keypress() {
	switch (event.srcElement.dataformat) {
	case "engup":  //영문대문자
		ComKeyOnlyAlphabet('upper');
		break;
	case "engupnum":  //숫자+"영문대분자"입력하기
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "custname":  //숫자+"영문대분자"입력하기
		ComKeyOnlyAlphabet('uppernum', '32');
		break;
	case "engdnnum":  //숫자+"영문대분자"입력하기
		ComKeyOnlyAlphabet('lowernum');
		break;
	case "num":  //숫자 입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "address":  //숫자+"영문대분자"입력하기
		ComKeyOnlyAlphabet('uppernum', '40|41|46|44|32|42|38|35|45');
		break;
	case "num":
	case "zipcode":  //숫자 입력하기
		ComKeyOnlyAlphabet('uppernum', '45|32');
		break;
	default:
	}
}

/**
 * HTML Control의 onBlur을 제어한다.
 **/
function bkg_deactivate() {

	var formObj = document.form;
	switch (event.srcElement.getAttribute("name")) {
	case "from_dt":
		ComAddSeparator(event.srcElement);
		break;
	case "to_dt":
		ComAddSeparator(event.srcElement);
		break;
	default:
		break;
	}
}

/**
 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
 **/
function bkg_activate() {
	var formObj = document.form;
	switch (event.srcElement.getAttribute("name")) {
	case "from_dt":
		ComClearSeparator(event.srcElement);
		break;
	case "to_dt":
		ComClearSeparator(event.srcElement);
		break;
	default:
		break;
	}
}

/*********************** KEY EVENT END ********************/

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var comboObject1 = comboObjects[0];
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			case "btn_RowAdd":
				doActionIBSheet(sheetObject2, formObject, IBINSERT);
				break;
			case "btn_RowDelete":
				if (0==sheetObject2.CheckedRows(prefix2 + "del_chk")) {
					ComShowCodeMessage("COM12189");
					return;
				}
				var chkRows = sheetObject2.FindCheckedRow(prefix2 + "del_chk").split("|");
				var chkRow;
				for (var i=0; i<chkRows.length-1; i++) {
					chkRow = parseInt(chkRows[i]);
					sheetObject2.RowHidden(chkRows[i])= true;
					sheetObject2.RowStatus(chkRows[i])= "D";
					sheetObject2.CellValue2(chkRows[i] < (sheetObject2.HeaderRows+sheetObject2.TotalRows) ? parseInt(chkRows[i])+1 : sheetObject2.LastRow-1, prefix2 + "del_chk") = 1;
				}
				break;
			case "btn_Copy":
				if (0==sheetObject1.RowCount || !isUsable(sheetObject1)) return;
				setCopyData();
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject2, formObject, IBSAVE);
				break;
			case "btn_Select":
				custPopupOK();
				break;
			case "btn_Close":
				self.close();
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col, PageNo) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.curr_page.value = 1;//PageNo를 초기화 하기 위함
		pagedMaxCnt = sheetObj.HeaderRows;//사용여부가 N인 데이타 색상 변경을 위한 변수 초기화

		formObj.f_cmd.value = SEARCH;

		var sXml = sheetObj.GetSearchXml("ESM_BKG_0192GS.do",
				FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

		sheetObj.Redraw = false;
		sheetObj.WaitImageVisible = false;
		sheetObj.LoadSearchXml(sXml);
		sheetObj.Redraw = true;

		sheetObjects[1].RemoveAll();

		if (sheetObjects[0].RowCount > 0) {
			doActionIBSheet(sheetObjects[1], formObj, SEARCH01, sheetObjects[0].FindCheckedRow(prefix + "radio").split("|")[0], 1);
		}
		break;

	case SEARCH01: //조회

		formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0192GS.do", "cust_cnt_cd="
				+ sheetObjects[0].CellValue(Row, prefix + "cust_cnt_cd")
				+ "&cust_seq="
				+ sheetObjects[0].CellValue(Row, prefix + "cust_seq")
				+ "&f_cmd=" + SEARCH01 + "&" + ComGetPrefixParam(prefix2));

		sheetObj.Redraw = false;
		sheetObj.WaitImageVisible = false;
		sheetObj.LoadSearchXml(sXml);
		sheetObj.Redraw = true;
		break;

	case IBSEARCHAPPEND: // 페이징 조회
		formObj.f_cmd.value = SEARCH;
		formObj.curr_page.value = PageNo;
		selectVal = FormQueryString(formObj);
		sheetObj.DoSearch4Post("ESM_BKG_0192GS.do", selectVal + "&"
				+ ComGetPrefixParam(prefix), "iPage=" + PageNo, true);
		break;

	case IBINSERT: // 입력
		var fromSheet = sheetObjects[0];
		var toSheet = sheetObjects[1];
		var toRow = toSheet.RowCount + 1;
		var row = toSheet.DataInsert(toRow);
		var chkRow = fromSheet.FindCheckedRow(prefix + "radio").split("|")[0];
		toSheet.CellValue(row, prefix2 + "cust_cnt_cd") = fromSheet.CellValue(chkRow, prefix + "cust_cnt_cd");
		toSheet.CellValue(row, prefix2 + "cust_seq") = fromSheet.CellValue(chkRow, prefix + "cust_seq");
		break;

	case IBSAVE: //저장
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		if (!sheetObj.IsDataModified && sParam == "") return;
		isValidateFail = false;
		formObj.f_cmd.value = MULTI;
		var sParam = sheetObj.GetSaveString() + "&" + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0192GS.do", sParam);
		if (!isValidateFail) {
			sheetObj.LoadSaveXml(sXml);
		}
		break;
	case IBDOWNEXCEL: // 엑셀다운로드
		sheetObj.SpeedDown2Excel(1);
		break;
	}
}

/**
 * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 Event <br>
 */
function sheet1_OnScrollNext(sheet, CondParam, PageNo, OnePageRows) {
	//alert("PageNo:"+PageNo);
	// TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
	doActionIBSheet(sheet, document.form, IBSEARCHAPPEND, true, true, PageNo);
}

/*
 *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
 * 초기값은 쉬트 헤더 개수
 */
var pagedMaxCnt = 2;
/**
 * 조회후  이벤트 처리 >>> 폰트 칼라변경
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var redColor = RgbColor(255, 0, 0);
		for ( var i = pagedMaxCnt; i <= sheetObj.LastRow; i++) {
			if (i == HeaderRows) {
				CellValue(i, prefix + "radio") = 1;
				var formObject = document.form;
			}
			setCelColor(CellValue(i, prefix + "delt_flg"), sheetObj, i, prefix + "delt_flg", redColor);
		}
	}

	pagedMaxCnt = sheetObj.LastRow;
}

function sheet1_OnDblClick(sheetObj, rowIdx, colIdx) {
	if (!isUsable(sheetObj)) return;
	sheetObjects[0].CellValue(rowIdx, prefix + "radio") = 1;
	doActionIBSheet(sheetObjects[1], document.form, SEARCH01, rowIdx, colIdx)
}

function sheet1_OnClick(sheetObj, rowIdx, colIdx) {
	with (sheetObj) {
		if (colIdx == SaveNameCol(prefix + "radio")) {
			doActionIBSheet(sheetObjects[1], document.form, SEARCH01, rowIdx, colIdx)
		}
	}
}

function setCopyData() {
	var fromSheet = sheetObjects[0];
	var toSheet = sheetObjects[1];
	var toRow = toSheet.RowCount + 1;
	var row = toSheet.DataInsert(toRow);
	var chkRow = fromSheet.FindCheckedRow(prefix + "radio").split("|")[0];
	toSheet.CellValue(row, prefix2 + "cust_cnt_cd") = fromSheet.CellValue(chkRow, prefix + "cust_cnt_cd");
	toSheet.CellValue(row, prefix2 + "cust_seq") = fromSheet.CellValue(chkRow, prefix + "cust_seq");
	toSheet.CellValue(row, prefix2 + "cust_nm") = fromSheet.CellValue(chkRow, prefix + "cust_nm");
	toSheet.CellValue(row, prefix2 + "cust_addr") = fromSheet.CellValue(chkRow, prefix + "cust_addr");
	toSheet.CellValue(row, prefix2 + "cust_cty_nm") = fromSheet.CellValue(chkRow, prefix + "cty_nm");
	toSheet.CellValue(row, prefix2 + "cust_ste_cd") = fromSheet.CellValue(chkRow, prefix + "ste_cd");
	toSheet.CellValue(row, prefix2 + "cust_zip_cd") = fromSheet.CellValue(chkRow, prefix + "zip_cd");
}

/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnClick(sheetObj, Row, Col) {

	var colSaveName = sheetObj.ColSaveName(Col);

	switch (colSaveName) {

	case prefix2 + "cust_nm":
		ComShowMemoPad2(sheetObj, Row, Col, false, 270, 80, 2, 35);
		break;
	case prefix2 + "cust_addr":
		ComShowMemoPad2(sheetObj, Row, Col, false, 270, 80, 3, 35);
		break;
	} // end switch()

}

var memoSheet = null, memoRow, memoCol;

/**
 * 글자수 제한을 두기 위해 공통 ComShowMemoPad를 사용할 수 없어<br>
 * 이화면에서만 사용하는 ComShowMemoPad2를 재정의해 사용함<br>
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param bReadOnly
 * @param iWidth
 * @param iHeight
 * @param iMax
 * @return
 */
function ComShowMemoPad2(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax) {
	try {
		//함수의 인자 default 값 설정하기			
		if (row == undefined || row == null) row = sheetObj.SelectRow;
		if (col == undefined || col == null) col = sheetObj.SelectCol;
		if (bReadOnly == undefined || bReadOnly == null) bReadOnly = false;
		if (iWidth == undefined || iWidth == null) iWidth = 200;
		if (iHeight == undefined || iHeight == null) iHeight = 200;
		if (iMax == undefined || iMax == null) iMax = 4000;
		// 메모를 위한 IBSheet 정보의 Validation 확인하기
		if (sheetObj.CellEditable(row, col)) {
			return ComShowMessage("[ComShowMemoPad] " + sheetObj.id + "(" + row + "," + col + ") 셀은 편집불가능이어야 합니다.");
		}
		//메모를 위한 IBSheet 정보 받기
		if (!ComIsNumber(col)) col = sheetObj.SaveNameCol(col);
		memoSheet = sheetObj;
		memoRow = row;
		memoCol = col;
		// 메모메드 만들기
		if (!initMemoPad2(iMax)) return;
		// 메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft,
		// AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
		var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col) + 2;
		var iTop = AnchorPosition_getPageOffsetTop(sheetObj) + sheetObj.RowTop(row) + 2;
		if (sheetObj.CountPosition != 0) iTop += 16; // 건수정보가 표시될 때 표시위치를 조금 내린다.
		// 현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
		if (top.document != document && window.frameElement.scrolling == "no") {
			//높이초과
			if (iTop + iHeight > document.body.clientHeight) {
				iBottom = iTop + sheetObj.RowHeight(row);
				if (iBottom > document.body.clientHeight) iBottom = document.body.clientHeight;
				iTop = iBottom - iHeight;
				if (iTop < 0) iTop = 0
			}
			//넓이초과
			if (iLeft + iWidth > document.body.clientWidth) {
				iLeft = document.body.clientWidth - iWidth;
				if (iLeft < 0) iLeft = 0;
			}
		}
		var _divMemo = document.getElementById(MEMO_DIV_NAME);
		var _frameDoc = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
		_frameDoc.getElementById("btn_apply").style.display = (bReadOnly) ? "none" : "inline";
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor = bReadOnly ? "#E8E7EC" : "";
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily = "Courier New";
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize = 11;
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight - 25;
		_frameDoc.getElementById(MEMO_TEXT_NAME).value = sheetObj.CellText(row, col);
		_frameDoc.getElementById(MEMO_TEXT_NAME).readOnly = bReadOnly;
		_divMemo.style.width = iWidth;
		_divMemo.style.height = iHeight;
		_divMemo.style.top = iTop;
		_divMemo.style.left = iLeft;
		_divMemo.style.visibility = "visible";
		_divMemo.focus();
		ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/**
 * MemoPad를 위한 DIV안에 iFrame을 만들고, iFrame안에 Textarea와 버튼을 생성한다. <br>
 * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
 */
function initMemoPad2(iMax) {
	try {
		//메모용 Div가 없으면 생성한다.
		if (document.getElementById(MEMO_DIV_NAME) != null)
			return true;

		//메모용 Div 만들기	        
		var _divMemo = document
				.createElement("<div id='"
						+ MEMO_DIV_NAME
						+ "' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
		document.body.insertBefore(_divMemo);

		//메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
		var _frameMemo = document
				.createElement("<IFRAME id='"
						+ MEMO_FRAME_NAME
						+ "' src='' frameborder=0 marginHeight=0 marginWidth=0 width=100% height=100% />");
		_divMemo.appendChild(_frameMemo);

		var _FrameDoc = _frameMemo.contentWindow.document;

		//iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
		var _FrameDiv = _FrameDoc
				.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
		_FrameDoc.appendChild(_FrameDiv);

		//Div안에 Textarea 만들기
		var _area = _FrameDoc
				.createElement("<textarea id='"
						+ MEMO_TEXT_NAME
						+ "' style='border:#7F9DB9 1px solid; font-family:Courier New; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
		_FrameDiv.appendChild(_area);

		//Div 안에 center 태그 만들기(버튼을 가운데 놓기 위함)
		var _centerTag = _FrameDoc.createElement("<center>");
		_FrameDiv.appendChild(_centerTag);

		//Apply 버튼 만들기
		var _button1 = _FrameDoc
				.createElement("<span id='btn_apply' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setMemoValue2(document.getElementById(\""
						+ MEMO_TEXT_NAME + "\").value," + iMax + ");'/>");
		_button1.innerHTML = "Apply";
		_centerTag.appendChild(_button1);

		//Close 버튼 만들기
		var _button2 = _FrameDoc
				.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
		_button2.innerHTML = "Close";
		_centerTag.appendChild(_button2);

		//메모용 iFrame 자동 닫기 처리
		if (document.onmouseup == null
				|| document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {
			//Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
			window.popupMemoOldEventListener = document.onmouseup;
			if (window.popupMemoOldEventListener != null) {
				//alert("CoObject \n" + window.popupMemoOldEventListener.toString());
				//기존에 document.onmouseup에  정의된 함수가 있는 경우
				document.onmouseup = new Function(
						"window.popupMemoOldEventListener(); ComHideMemoPad();");
			} else {
				//기존에 document.onmouseup에  정의된 함수가 없는 경우
				document.onmouseup = ComHideMemoPad;
			}

			//ActiveX에 포커스가 갔을때 메모DiV 닫기
			var objs = document.getElementsByTagName("OBJECT")
			window.popupMemoOldObjEventListener = new Array(objs.length);
			for ( var i = 0; i < objs.length; i++) {
				window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
				if (window.popupMemoOldObjEventListener[i] != null) {
					//기존에 document.onmouseup에  정의된 함수가 있는 경우
					objs[i].onfocus = new Function(
							"window.popupMemoOldObjEventListener[" + i
									+ "](); ComHideMemoPad();");
				} else {
					//기존에 document.onmouseup에  정의된 함수가 없는 경우
					objs[i].onfocus = ComHideMemoPad;
				}
			}
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
		return false;
	}
	return true;
}

function setMemoValue2(sValue, iMax) {
	try {
		if (!validateCols2(sValue)) {
			return;
		} else {
			ComHideMemoPad(true);
		}
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}

/*
 * TextArea 글자수,Row수 제한 Validation 체크
 * @param rows : 최대Row수
 * @param cols : 한Row에 표시될 최대글자수
 * @param obj : Textarea Object
 * @author 김병규
 * @version 2009.09.01
 */
function validateCols2(str) {
	var displayText;
	var iCols = 35;
	var iRows = 2;
	if (sheetObjects[1].ColSaveName(sheetObjects[1].SelectCol) == "sheet2_cust_addr")
		iRows = 3;
	var parseCols = parseInt(iCols);
	var rowArr = str.split("\n");

	for ( var i = 0; i < rowArr.length; i++) {
		if (countLineBreaks(rowArr[i]) > 0) {
			if (rowArr[i].length > parseCols + 1) {
				var loopCnt;
				if (rowArr[i].length % parseCols > 0) {
					loopCnt = rowArr[i].length / parseCols + 1;
				} else {
					loopCnt = rowArr[i].length / parseCols;
				}
				for ( var j = 0; j < Math.floor(loopCnt); j++) {
					if (i < 1) {
						if (j < 1) {
							displayText = rowArr[i].substring(0, parseCols
									* (j + 1));
						} else {
							//                             displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
							displayText = displayText
									+ rowArr[i].substring(parseCols * j,
											parseCols * (j + 1));
						}
					} else {
						//                         displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
						displayText = displayText
								+ rowArr[i].substring(parseCols * j, parseCols
										* (j + 1));
					}
				}
				if (countLineBreaks(displayText) > 0) {
					displayText = displayText.substring(0,
							displayText.length - 1);
				}
			} else {
				if (i < 1) {
					displayText = rowArr[i];
				} else {
					//                     displayText = displayText + "\n" + rowArr[i];
					displayText = displayText + rowArr[i];
				}
			}
		} else {
			if (rowArr[i].length > parseCols) {
				var loopCnt;
				if (rowArr[i].length % parseCols > 0) {
					loopCnt = rowArr[i].length / parseCols + 1;
				} else {
					loopCnt = rowArr[i].length / parseCols;
				}
				for ( var j = 0; j < Math.floor(loopCnt); j++) {
					if (i < 1) {
						if (j < 1) {
							displayText = rowArr[i].substring(0, parseCols
									* (j + 1));
						} else {
							//                             displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
							displayText = displayText
									+ rowArr[i].substring(parseCols * j,
											parseCols * (j + 1));
						}
					} else {
						//                         displayText = displayText + "\n" + rowArr[i].substring(parseCols*j,parseCols*(j+1));
						displayText = displayText
								+ rowArr[i].substring(parseCols * j, parseCols
										* (j + 1));
					}
				}
			} else {
				if (i < 1) {
					displayText = rowArr[i];
				} else {
					//                     displayText = displayText + "\n" + rowArr[i];
					displayText = displayText + rowArr[i];
				}
			}
		}
	}
	var enterCnt = countLineBreaks(displayText);
	if (iRows - 1 < enterCnt) {
		ComShowCodeMessage("BKG02006", '', iRows);
		return false;
	} else {
		memoSheet.CellValue2(memoRow, memoCol) = displayText;
	}
	return true;
}

/**
 * OnSaveEnd 이벤트 발생시 호출되는 function <br>
 * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @version 2009.05.17
 */
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	sheetObj.RemoveAll();
	doActionIBSheet(sheetObj, document.form, SEARCH01, sheetObjects[0].FindCheckedRow(prefix + "radio").split("|")[0], "");
}

/**
 * Save시 유효성 체크 function <br>
 * 유효하지 않으면 처리를 중단한다. <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} rowIdx 행 인덱스
 * @param {int} colIdx 열 인덱스
 * @param String value  값
 * @return 없음
 * @version 2009.05.17
 */
function sheet2_OnValidation(sheetObj, rowIdx, colIdx, value) {
	if ("D"==sheetObj.CellValue(rowIdx, prefix2 + "ibflag")) return;
	if (colIdx == sheetObj.SaveNameCol(prefix2 + "cust_phn_no")) {
		if (!ComIsNull(value) && !ComIsNumber(value, "-")) {
			ComShowCodeMessage("BKG95001", " enter correct 'Tel No'", "(Format:123-1234-1234)");
			sheetObj.ValidateFail = true;
			isValidateFail = true;
			sheetObj.SelectCell(rowIdx, colIdx);
		}
	} else if (colIdx == sheetObj.SaveNameCol(prefix2 + "cust_fax_no")) {
		if (!ComIsNull(value) && !ComIsNumber(value, "-")) {
			ComShowCodeMessage("BKG95001", " enter correct 'Fax No'", "(Format:123-1234-1234)");
			sheetObj.ValidateFail = true;
			isValidateFail = true;
			sheetObj.SelectCell(rowIdx, colIdx);
		}
	} else if (colIdx == sheetObj.SaveNameCol(prefix2 + "cust_eml")) {
		if (!ComIsNull(value) && !ComIsEmailAddr(value)) {
			ComShowCodeMessage("BKG95001", " enter correct 'Email Address'", "");
			sheetObj.ValidateFail = true;
			isValidateFail = true;
			sheetObj.SelectCell(rowIdx, colIdx);
		}
	}

}

/*
 * 사용여부가 N확인 
 * */
function isUsable(sheetObj) {
	if (sheetObj.CellValue(sheetObj.FindCheckedRow(prefix + "radio").split("|")[0], prefix + "delt_flg") == 'N') {
		ComShowCodeMessage("BKG02004",
			sheetObj.CellValue(sheetObj.FindCheckedRow(prefix + "radio").split("|")[0], prefix + "cust_cnt_cd") +
			sheetObj.CellValue(sheetObj.FindCheckedRow(prefix + "radio").split("|")[0], prefix + "cust_seq")
		   ,sheetObj.CellValue(sheetObj.FindCheckedRow(prefix + "radio").split("|")[0], prefix + "no_use_rsn"));
		return false;
	}
	return true;
}

function setCelColor(flag, obj, idx, celName, color) {
	if (flag == "N")
		obj.CellFontColor(idx, celName) = color;

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (ComIsNull(formObj.cust_cnt_cd)) {
			ComShowCodeMessage('BKG00626', 'Country Code');
			return false;
		}
		if (formObj.cust_cnt_cd.value.length != 2) {
			ComShowCodeMessage('BKG95018', 'Country Code', '2');
			return false;
		}
		if (ComIsNull(formObj.cust_seq) && ComIsNull(formObj.cust_nm)
				&& ComIsNull(formObj.cust_addr)) {
//			ComShowCodeMessage('BKG00404', 'Country SEQ or Name or Address');
			ComShowCodeMessage("BKG95046", "Customer Code No. or Name or Address");
			return false;
		}
		if(!ComIsNumber(document.form.cust_seq.value) && document.form.cust_seq.value.length != 0 ){
	 		ComShowCodeMessage("BKG00458"); // invalid customer code
	 		document.form.cust_seq.value='';
	 		
	 		return false;
	 	}
		
		  //space나 특수문자만 조회할 경우 막음
        if(!ComIsNull(formObj.cust_nm.value)){
          	if(ComTrimAll(formObj.cust_nm.value, "~","`","!","@","#","$","%","^","*","&","(",")","-","_","=","|","+","<",">", ",",".","'",":",";","?","/"," ").length <= 0 ||ComTrimAll(formObj.cust_nm.value).length <= 0){
          		ComShowCodeMessage("BKG43048");
          		 formObj.cust_nm.focus();
                 return false;
          	}
         }
        
		break;
		
	case IBSAVE:
		var oldFlg = formObj.indiv_pson_flg_origin.value;
		var newFlg = "N";
		if(formObj.indiv_pson_flg.checked == true){
			newFlg = "Y";
		}
		 if(form.indiv_dp_flg.value == "Y"){//CNEE일때만 체크해준다.
				if (oldFlg != newFlg ){
					ComShowCodeMessage('BKG08200');
					return false;
				}
			   }
		break;
	}
	return true;
}

/**
 * 화면 yyyyMMd 날짜 체크
 */
function dateCheck(dateobj) {
	if (dateobj.value == "")
		return true;//null이면 체크 안함
	return ComIsDate(dateobj.value);
}

function isNullEtcData(xmlStr) {
	var rtn = false;
	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	xmlDoc.loadXML(xmlStr);

	var xmlRoot = xmlDoc.documentElement;
	if (xmlRoot == null)
		return true;

	var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
	if (etcDataNode == null)
		return true;

	var etcNodes = etcDataNode.childNodes;
	if (etcNodes == null)
		return true;
	if (etcNodes.length == 0)
		rtn = true;

	return rtn;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {

	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 187;

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
			InitRowInfo(2, 1, 6, rowsPerPage);

			var HeadTitle1 = " Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|Customer Information in MDM|";
			var HeadTitle2 = " | | |Seq.|Status|I/B Office\nHistory|Code|Name|S.OFC|S.Rep|City|Location code|State|Customer Address|Zip Code|TEL|F/F FMC No.|";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			InitHeadMode(true, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, prefix + "cust_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, prefix + "cust_seq");
			InitDataProperty(0, cnt++, dtRadioCheck, 20, daCenter, false, prefix + "radio", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtSeq, 38, daCenter, false, prefix + "Seq");
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, prefix + "delt_flg", false, "", dfNone, 0, false, false);
			//InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "r_bklst", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, prefix + "history_yn", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix + "code", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 160, daLeft, false, prefix + "cust_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, false, prefix + "ofc_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 85, daCenter, false, prefix + "srep_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, prefix + "cty_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++ , dtData,150,daCenter,  false,    	prefix + 	"location_code",   			false,          "",       dfNone,   	0,     false,       true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix + "ste_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 250, daLeft, false, prefix + "cust_addr", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, false, prefix + "zip_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "phn_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 65, daCenter, false, prefix + "frt_fwrd_fmc_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 45, daLeft, false, prefix + "no_use_rsn", false, "", dfNone, 0, false, false);

			CountPosition = 0;//[1/3] 페이지 위치 
		}

		break;
	case "sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 242;

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
			InitRowInfo(2, 1, 6, 100);

			var HeadTitle1 = "||||Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template|Customer Information Template";
			var HeadTitle2 = "||||Sel.|Seq.|Name|Address|Tel. No.|Fax No.|PIC|City|Location code|State|Country|Zip Code|E-mail|Street/P.O.Box|EORI No|Remark";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
			InitHeadMode(true, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,    DATATYPE,	   WIDTH,  DATAALIGN,	COLMERGE,	  SAVENAME,		            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, prefix2 + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix2 + "cust_cnt_cd");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, prefix2 + "cust_seq");
			InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, prefix2 + "tmplt_seq");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, prefix2 + "del_chk");
			InitDataProperty(0, cnt++, dtSeq, 35, daCenter, false, prefix2 + "Seq");
			InitDataProperty(0, cnt++, dtData, 85, daLeft, false, prefix2 + "cust_nm", false, "", dfEngUpKey, 0, false, false, 100);
			InitDataProperty(0, cnt++, dtData, 110, daLeft, false, prefix2 + "cust_addr", false, "", dfEngUpKey, 0, false, false, 200);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, false, prefix2 + "cust_phn_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 75, daCenter, false, prefix2 + "cust_fax_no", false, "", dfNone, 0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, false, prefix2 + "pic", false, "", dfEngUpKey, 0, true, true, 50);
			InitDataProperty(0, cnt++, dtData, 55, daLeft, false, prefix2 + "cust_cty_nm", false, "", dfEngUpKey, 0, true, true, 300);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, false, prefix2 + "location_code", false, "", dfEngUpKey, 0, true, true, 300);
			InitDataProperty(0, cnt++, dtData, 40, daLeft, false, prefix2 + "cust_ste_cd", false, "", dfEngUpKey, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix2 + "cstms_decl_cnt_cd", false, "", dfEngUpKey, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 55, daLeft, false, prefix2 + "cust_zip_cd", false, "", dfNone, 0, true, true, 10);
			InitDataProperty(0, cnt++, dtData, 95, daLeft, false, prefix2 + "cust_eml", false, "", dfEngUpKey, 0, true, true, 150);
			InitDataProperty(0, cnt++, dtData, 95, daLeft, false, prefix2 + "eur_cstms_st_nm", false, "", dfEngUpKey, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtData, 95, daLeft, false, prefix2 + "eori_no", false, "", dfEngUpKey, 0, true, true, 100);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, false, prefix2 + "tmplt_rmk", false, "", dfEngUpKey, 0, true, true, 500);
			InitDataValid(0, prefix2 + "cust_nm", vtEngUpOther, "1234567890 ,.-()");
			InitDataValid(0, prefix2 + "cust_addr", vtEngUpOther, "1234567890 ,.-()");
			InitDataValid(0, prefix2 + "cstms_decl_cnt_cd", vtEngUpOnly);
			InitDataValid(0, prefix2 + "cust_phn_no", vtNumericOther, " ,-()");
			InitDataValid(0, prefix2 + "cust_fax_no", vtNumericOther, " ,-()");
			InitDataValid(0, prefix2 + "pic", vtEngUpOther, "1234567890 ,.-()");
			InitDataValid(0, prefix2 + "cust_cty_nm", vtEngUpOther, "1234567890 ,.-()");
			InitDataValid(0, prefix2 + "cust_ste_cd", vtEngUpOther, "1234567890");
			InitDataValid(0, prefix2 + "cust_eml", vtEngOther, "1234567890 -@.");

			CountPosition = 0;//[1/3] 페이지 위치 
		}

		break;

	}
}

function custPopupOK() {
	/* 
	 * Individual Person 이 Check 되어 있으면 Validation Check Skip
	 * 
	 * Booking Main Customer(ESM_BKG_0079_05) 화면에서 호출된 경우 Opener Name = t4frame
	 * e-Booking Customer   (ESM_BKG_0229_02) 화면에서 호출된 경우 Opener Name = t2frame
	 */
	
	if(form.indiv_dp_flg.value == "Y"){
		if(document.form.indiv_pson_flg.checked == true){
			
			// Check 된 CNEE CD 와 Individual Person 같이 존재 하는 경우, 둘 중 하나만 선택가능하도록 제어. 
			if (sheetObjects[0].FindCheckedRow(prefix + "radio").split("|")[0] != "") {
				ComShowCodeMessage("BKG08199");
				return;
			}
			
			if(ComShowCodeConfirm("BKG08196")){
				opener.document.form.indiv_pson_flg.value = "Y";
				opener.document.form.cn_cust_seq.value = "";
				opener.document.form.cn_cust_lgl_eng_nm.value = "";
				self.close();
			}
			return;
		}else{
			opener.document.form.indiv_pson_flg.value = "N";
		}
	}
	
	if (0==sheetObjects[1].CheckedRows(prefix2 + "del_chk")) {
		if (0==sheetObjects[0].CheckedRows(prefix + "radio")) {
			ComShowCodeMessage("COM12189");
			return;
		}
		if (!isUsable(sheetObjects[0])) {
			return;
		}
	}
	if (1<sheetObjects[1].CheckedRows(prefix2 + "del_chk")) {
		ComShowCodeMessage("BKG08040");  //Please select only one row.
		return;
	}
	var isModified = false;
	if (sheetObjects[1].IsDataModified) {
		var arrRow = sheetObjects[1].FindStatusRow("I|U|D").split(";");
		for (var i=0; i<arrRow.length-1; i++) {
			for (var j=0; j<sheetObjects[1].LastCol+1; j++) {
				if (j == sheetObjects[1].SaveNameCol(prefix2 + "ibflag") && "D"!=sheetObjects[1].CellValue(arrRow[i],prefix2 + "ibflag")) continue;
				if (j == sheetObjects[1].SaveNameCol(prefix2 + "del_chk")) continue;
				if (j == sheetObjects[1].SaveNameCol(prefix2 + "Seq")) continue;
				if (sheetObjects[1].CellValue(arrRow[i],j) != sheetObjects[1].CellSearchValue(arrRow[i],j)) {
					isModified = true;
					break;
				}
			}
		}
	}
	var retObj1 = getCustInfoRows(sheetObjects[0].FindCheckedRow(prefix + "radio").split("|")[0]);
	var retObj2 = getTemplateRows(prefix2 + "del_chk");
	if (isModified) {
		if (ComShowCodeConfirm("BKG00386")) {  //Data changed. Do you want to save?
			doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
		}
	}
	if (!isValidateFail) {
		if (callbackMethod) {
			callbackMethod(retObj1, retObj2);
			self.close();
		} else {
			self.close();
		}
	}
}

function getTemplateRows(colName) {
	if (0==sheetObjects[1].CheckedRows(colName)) return null;
	var chkRow = sheetObjects[1].FindCheckedRow(colName).split("|")[0];
	var cArray = new Array();  //열데이터를 담고 있는 배열
	for (var j=0; j < sheetObjects[1].LastCol+1; j++) {
		cArray[j] = sheetObjects[1].CellValue(chkRow, j);
	}
	return cArray;
}

function getCustInfoRows(idx) {
	if (0==sheetObjects[0].CheckedRows(prefix + "radio")) return null;
	var cArray = new Array(); //열데이터를 담고 있는 배열
	for (var j=0; j < sheetObjects[0].LastCol+1; j++) {
		if (j==sheetObjects[0].SaveNameCol(prefix + "radio")) {
			continue;
		}
		cArray[j] = sheetObjects[0].CellValue(idx, j);
	}
	return cArray;
}

/**
 * Individual Person 에 체크가 되면, Consignee Code, Consignee Sequence, Customer 정보를
 * 삭제한다. 
 */
function delCneeCd(){
	
	var formObj = document.form;
	if(formObj.indiv_pson_flg.checked == true){

		formObj.cust_seq.value = "";
		
		var noDataXml = "<SHEET><ETC-DATA><ETC KEY='Exception'><![CDATA[]]></ETC><ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC></ETC-DATA><DATA  TOTAL='0'></DATA></SHEET>";
		sheetObjects[0].LoadSearchXml(noDataXml, false);
		sheetObjects[1].LoadSearchXml(noDataXml, false);
		
	}
	
}
 
 /**
  * DEL 콤보 Change 이벤트 발생 처리<br>
  * DEL CD 를 DEL 선택한 코드값으로 변경한다.<br>
  * 
  * @return 없슴
  * @author 박미옥
  * @version 2009.07.09
  */
 function cust_cnt_cd_OnChange() {
 	var formObj = document.form;
 	if(formObj.cust_cnt_cd.value !="US"){
 		document.form.area_cd.className = "input2";
			document.form.area_cd.readOnly = true;
 	}else{
 		document.form.area_cd.className = "input";
			document.form.area_cd.readOnly = false;
 	}
 }

/* 개발자 작업  끝 */
