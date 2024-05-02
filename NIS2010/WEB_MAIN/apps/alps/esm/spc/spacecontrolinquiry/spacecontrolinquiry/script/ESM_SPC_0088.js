/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_SPC_0088.js
 *@FileTitle : TS PLAN GUIDE Attachment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.03
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2016.04.03 이혜민
 * 1.0 Creation
 *----------------------------------------------------------
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
 * @class ESM_SPC_0088 : ESM_SPC_0088 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0088() {
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
var sheetObjects = new Array();
var sheetCnt = 0;
var uploadObjects = new Array();
var uploadCnt = 0;
var URL_ESM_SPC = 'ESM_SPC_0088GS.do';
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	try {
		for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		//UPLOAD 환경 설정
		for ( var i = 0; i < uploadObjects.length; i++) {
			//1. 기본 환경 설정
			ComConfigUpload(uploadObjects[i], "/hanjin/" + URL_ESM_SPC);

			// 2. Upload 초기화
			// initUpload(uploadObjects[i],i+1);
		}
		uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

	} catch (ex) {
		return false;
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
			style.height = 182;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(15, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "|Sel.|File Name|File Size";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,  "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, "del_chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopup, 175, daLeft, false, "file_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false,  "file_size", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "pln_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "rep_trd_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "rep_sub_trd_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "rlane_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "vvd_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "irr_port_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "irr_yd_cd");
			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "file_path");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "file_sav_id");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true,  "file_seq");

			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			CountPosition = 0;
		}
		break;
	}
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
		case "btn_upload":
			doActionIBSheet(sheetObject1, formObject, IBINSERT);
			break;
		case "btn_delete":
			doActionIBSheet(sheetObject1, formObject, IBDELETE);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
var item_cnt = 0; // 현재 sheet에 보이는 item의 갯수
function fn_filteredData(sheetObj, tmp_name, tmp_value) {
	item_cnt = 0;
	var cnt = sheetObj.LastRow;
	if (cnt == 0)
		return;
	for (ix = 1; ix <= cnt; ix++) {
		if (sheetObj.RowStatus(ix) == 'D') {
		} else if (sheetObj.CellValue(ix, tmp_name) == tmp_value) {
			sheetObj.RowHidden(ix) = false;
			item_cnt++;
		} else {
			sheetObj.RowHidden(ix) = true;
		}
	}
	return true;
}

/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColFontUnderline( "file_nm") = true;
		DataLinkMouse( "file_nm") = true;
	}
}
/**
 * Sheet 저장완료 후 이벤트 발생
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH); // 파일링크를 위해 재조회
	if(sheetObj.RowCount>0){
		opener.sheetObjects[1].CellValue(opener.sheetObjects[1].SelectRow ,"pln_atch") = "Y";
	}else{
		opener.sheetObjects[1].CellValue(opener.sheetObjects[1].SelectRow ,"pln_atch") = "N";
	}
	
}
/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 * @param {String} 	Value     	파일명
 **/
function sheet1_OnClick(sheetObj, Row, Col, Value) {

	 if (Col != 2) return;
	 
	// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
	if (sheetObj.CellText(Row,  "file_nm") == "" || sheetObj.RowStatus(Row) == "I") {
		selectFile(sheetObj, Row, Col);
		return;
	}
	
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row,  "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(getMsg("SPC90400"));
	}
	
}
 /**
 * 파일존재유무판단  
 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
 * param :file_id
 * return :boolean
 */
function fnSaveFileExist(file_id,sheetObj) {
	var formObj = document.form;
	var param = "&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	var output_text = ComGetEtcData(sXml, "output_text");
	return output_text;
}
/**
 * Sheet관련 프로세스 처리 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	formObj   
 * @param {String} 	sAction   
 * @return {없음}
 **/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		ComSetObjValue(formObj.f_cmd, SEARCH);
		// 2.조회조건으로 조회실행
		var sXml = sheetObj.GetSearchXml(URL_ESM_SPC, FormQueryString(formObj));
		// 3.조회후 결과처리
		sheetObj.LoadSearchXml(sXml);

		//size 변경하기 
		for ( var row = sheetObj.HeaderRows; row <= sheetObj.RowCount; row++) {
			var size = getSize(sheetObj.CellValue(row,  "file_size"));
			sheetObj.CellValue(row,  "file_size") = size;
			sheetObj.RowStatus(row) = 'R';
		}
		
		break;
	case IBSAVE: //저장

		if (!validateForm(sheetObj, formObj, sAction))
			return;

		// 0.IBUpload에 파일 추가하기
		var upObj = uploadObjects[0];
		upObj.Files = ""; // -먼저기존파일을 모두 지운후 추가함
		var paramFile1 = setFileUpload(sheetObj);
		ComSetObjValue(formObj.f_cmd, MULTI);

		// 2.IBSheet 데이터 QueryString으로 묶기
		var sParam = ComGetSaveString(sheetObj);
		if (sParam == "")
			return;

		// 1.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		
		ComOpenWait(true, true); // 키보드나 마우스를 대기상태 & 대기이미지

		if (upObj.LocalFiles == "") {
			//3.Form 데이터 QueryString으로 묶기
			sParam += "&" + FormQueryString(formObj);
			// 4. 서버에 request전달하고, reponse 받기
			var sXml = sheetObj.GetSaveXml(URL_ESM_SPC, sParam);
			if (sXml.length > 0)
				sheetObj.LoadSaveXml(sXml);
		} else {
			//3.Form 데이터 QueryString으로 묶기
			sParam += "&" + FormQueryString(formObj);
			// 3.저장조건으로 저장실행
			upObj.ExtendParam = sParam; // param값 추가
			upObj.ParamDecoding = true;
			var sXml = upObj.DoUpload(true);
			// 4.저장후 결과처리
			if (sXml.length > 0){
				var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if ( State == "S" ) {	
					sheetObj.LoadSaveXml(sXml);
				}else{
					fnExceptionMessage(sXml);
				}
			}
		}
		ComOpenWait(false);
		break;
		
	case IBINSERT: // 입력
		selectFile(sheetObj, sheetObj.RowCount, '', true);
		break;
		
	case IBDELETE: // 삭제
		if (sheetObj.FindCheckedRow( "del_chk") != "") {
			if (!ComShowConfirm(getMsg("SPC10535"))){ 
				return;
			}
			ComRowHideDelete(sheetObj,  "del_chk");
			doActionIBSheet(sheetObj, document.form, IBSAVE);
		} else {
			ComShowCodeMessage("SPC90401");// "No Selected Row";
		}
		break;
	}
}

/**
 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 **/
function setFileUpload(sheetObj) {
	var sRow = sheetObj.FindStatusRow("I");
	var upObj = uploadObjects[0];
	var arrRow = sRow.split(";");

	for (idx = 0; idx < arrRow.length - 1; idx++) {
		var row = arrRow[idx];

		// 파일 경로 가져오기
		var sFile = sheetObj.CellValue(row,  "file_path");
		
		// IBUpload에 파일 추가하기
		var ret = upObj.AddFile(sFile);
	}

	var param =  "file_cnt=" + (arrRow.length - 1);

	return param;
}

/**
 * 용량계산하기  <br>
 * @param {String} 	_val 		파일용량
 * @param {String} 	r_value    	MB/KB계산 
 **/
function getSize(_val) {

	var r_value = _val;
	var _value = Math.round(_val / 1024);

	if (_value > 0) {
		r_value = _value;
		_value = Math.round(_value / 1024);
		if (_value > 0) {
			_value = _value + " MB"
		} else {
			_value = r_value + " KB"
		}
	} else {
		_value = r_value + " Bytes"
	}
	return _value;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// 저장시 유효성검사 
		if (sAction == IBSAVE) {
			var c_row = sheetObj.LastRow;
			if (c_row == 0) {
				ComShowCodeMessage("SPC90402");// Please select data to save.
				return;
			}
			for ( var row = 1; row <= c_row; row++) {
				var v_file_nm = sheetObj.CellValue(row,  "file_nm");
				if (v_file_nm == '') {
					ComShowMessage(row + "행의 [File Name]은 필수값입니다. ");
					selectFile(sheetObj, sheetObj.RowCount, '', true);
					return false;
				}
			}
		} 
	}
	return true;
}

/**
 * 파일 선택하기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
 **/

function selectFile(sheetObj, Row, Col, _insert) {
	var formObj = document.form;

	if (Col == '' || Col == '2') {

		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		var file_nm = sheetObj.CellValue(Row,  "file_nm");

		if (typeof file_nm == "undefined" || file_nm == "File Name" || (file_nm != "" && _insert)) {
			Row = sheetObj.DataInsert(-1, 0);// File Add인 경우 New Row 생성
			sheetObj.CellValue2(Row,  "rep_trd_cd") 	= formObj.rep_trd_cd.value;
			sheetObj.CellValue2(Row,  "rep_sub_trd_cd") = formObj.rep_sub_trd_cd.value;
			sheetObj.CellValue2(Row,  "rlane_cd") 		= formObj.rlane_cd.value;
			sheetObj.CellValue2(Row,  "vvd_cd") 		= formObj.vvd_cd.value;
			sheetObj.CellValue2(Row,  "irr_port_cd") 	= formObj.irr_port_cd.value;
			sheetObj.CellValue2(Row,  "irr_yd_cd") 		= formObj.irr_yd_cd.value;
			sheetObj.CellValue2(Row,  "pln_seq") 		= formObj.pln_seq.value;

			
		}

		var fileName = sheetObj.OpenFileDialog('');

		if (fileName.indexOf("\\") != -1) {
			sheetObj.CellValue2(Row,  "file_path") = fileName;
			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
			sheetObj.CellValue2(Row,  "file_nm") = fileName;
		}
	}
}
/**
 * IBSheet의 대한 Row를 추가한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	flag    Row Add/Row Ins의 구분값
 * @return {없음}
 **/
function sheet1_DataInsert(sheetObj, flag) {
	var row = sheetObj.SelectRow;
	var col = sheetObj.SelectCol;

	var file_nm = sheetObj.CellValue(row,  "file_nm");
	// 1. upload 파일 존재유무
	if (sheetObj.RowCount == 0 || (typeof file_nm != "undefined" && file_nm != "")) {
		row = sheetObj.DataInsert(-1);
	}
	//2. 파일선택 팝업창
	sheetObj.SelectCell(row, "file_nm");
}

/**
 * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
 * @param {ibupload} uploadObj    IBUpload Object
 **/
function setUploadObject(uploadObj) {
	uploadObjects[uploadCnt++] = uploadObj;
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
 * fnExceptionMessage 
 */
 function fnExceptionMessage(rXml){
 	var rMsg = ComGetEtcData(rXml,"Exception")
 	var rmsg = rMsg.split("<||>");
 	if(rmsg[3] != undefined && rmsg[3].length > 0) {
 		ComShowMessage(rmsg[3]);
 	}else{
 		sheetObjects[0].LoadSaveXml(rXml);
 	}
 }
/* 개발자 작업  끝 */