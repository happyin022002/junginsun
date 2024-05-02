/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_pri_8101.js
 *@FileTitle : Import Restricted Commodities File Upload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.09.26
 *@LastModifier : 이인영
 *@LastVersion : 1.0
 * 2011.09.26 이인영
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
 * @class esm_pri_8101 : esm_pri_8101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_pri_8101() {
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
var uploadObjects = new Array();
var uploadCnt = 0;
var sheetCnt = 0;

var URL_ESM_PRI = 'ESM_PRI_8101GS.do';
var PRI_DIV_NAME = "_Pri_div1_";
var PRI_FRAME_NAME = "_Pri_iframe1_";
var checkBoxString = '';
var iframeW = 190;
var iframeH = 100;
var prefix = "sheet1_";

var _debug = false;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

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
			style.height = 302;
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

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
			//InitHeadMode(true, true, true, true, false,false)
			var HeadTitle = "|File Name|File Size|||||||";

			var headCount = ComCountHeadTitle(HeadTitle);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(7, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus,  0, daCenter,  true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtData,	370, daLeft, false, prefix + "org_file_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 	 60, daCenter, false, prefix + "file_size",   false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "scq_rqst_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "spcl_cgo_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "file_sav_id");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "file_path_rmk");
//			InitDataProperty(0, cnt++, dtData, 0, daCenter, true, prefix + "sav_file_nm");

			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			CountPosition = 0;
			FocusEditMode = 0;
		}
		break;
	}
}
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	/*******************************************************/
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
			//2.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
			if (!ComShowConfirm(ComGetMsg("PRI00001"))){
				return;
			}
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			window.close();
			break;
		case "btn_close":
			window.close();
			break;
		} // end switch
	} catch (ex) {
		if (ex == "[object Error]") {
			pri_error_alert('processButtonClick', ex);
			ComShowMessage(OBJECT_ERROR);
		} else {
			alert(ex);
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
	
	if(formObj.editable.value != "Y"){	
		ComBtnDisable("btn_upload");
		ComBtnDisable("btn_delete");
		ComBtnDisable("btn_save");
	}
	
	try {

		for (i = 0; i < sheetObjects.length; i++) {

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i], i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		//UPLOAD 환경 설정
		for ( var i = 0; i < uploadObjects.length; i++) {
			//1. 기본 환경 설정
			ComConfigUpload(uploadObjects[i], "/hanjin/" + URL_ESM_PRI);

			//2. Upload 초기화
			//initUpload(uploadObjects[i],i+1);
		}
		uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
		// DIV 초기화
		divLayer_Config();
		// 최초 조회시작 
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

	} catch (ex) {
		pri_error_alert('loadPage', ex);
		return false;
	}
}

/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColFontUnderline(prefix + "org_file_nm") = true;
		DataLinkMouse(prefix + "org_file_nm") = true;
	}
}

/**
 * Sheet 저장완료 후 이벤트 발생
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH); //파일링크를 위해 재조회
}
/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 * @param {String} 	Value     	파일명
 **/
function sheet1_OnClick(sheetObj, Row, Col, Value) {

	if (Col != 1) return;
	 
	if (sheetObj.ColSaveName(Col) == prefix + "org_file_nm") {
	
		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		if (sheetObj.CellText(Row, prefix + "org_file_nm") == "" || sheetObj.RowStatus(Row) == "I") {
			selectFile(sheetObj, Row, Col);
			return;
		}
		// 파일이 존재시 다운로드 받는다.
		var key_id = sheetObj.CellValue(Row, prefix + "file_sav_id");
		var exist = fnSaveFileExist(key_id , sheetObj);
		// 서버에 파일존재유무확인 
		if(eval(exist)){
			hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
		}else{
			ComShowMessage(ComGetMsg("PRI09001"));
			//Attached File is deleted due to storage server capacity
		}
		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	}
	
	var key_id = sheetObj.CellValue(Row, prefix + "file_sav_id");
	hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
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
 * 멀티 SELECT 이벤트 DIV Layer창 생성 
 * 
 */
function divLayer_Config() {

	var iframeHTML = 'apps/alps/esm/pri/specialcargoquotation/scqlist/jsp/ESM_PRI_8101.HTML';

	var _divWait = document.createElement("<div id='" + PRI_DIV_NAME + "'  name='div01'  style='position:absolute; cursor:wait; left:0px; top:0px; width:100%; height:100%; z-index:999; visibility:hidden;'/>");
	document.body.insertBefore(_divWait);

	var _frameWait = document.createElement("<IFRAME id='" + PRI_FRAME_NAME + "' name='iframe01' src='" + iframeHTML + "' frameborder=0 marginHeight=0 marginWidth=0 width=" + iframeW + " height=" + iframeH + " style='position:absolute;' />");
	_divWait.appendChild(_frameWait);

}

/**
 * getMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 체크한다. 
 */
function getMultiSelectCheck(_check) {

	try {
		var t_nm = iframe01.document.getElementsByName('t_check');
		var arrRow = _check.split(",");
		for (idx = 0; idx < arrRow.length; idx++) {
			for (i = 0; i < t_nm.length; i++) {
				if (arrRow[idx] == t_nm[i].value) {
					t_nm[i].checked = true;
				}
			}
		}
	} catch (ex) {
		pri_error_alert('getMultiSelectCheck', ex);
		return false;
	}
}

/**
 * 마우스 다운 이벤트
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
var current_Row = 0;
var current_Equal = false;

function sheet1_OnMouseDown(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var Pri_div = document.getElementById(PRI_DIV_NAME);
	var Pri_iframe = document.getElementById(PRI_FRAME_NAME);

	var m_row = sheetObj.MouseRow;
	var m_col = sheetObj.MouseCol;

	try {

		//4번째 컬럼에서만 팝업창 열림 
		if (m_row > 0 && m_col == 5) {

			if (Pri_div.style.visibility == "hidden") {
				//초기 마우스 클릭 ROW 위치 
				if (sheetObj.MouseRow == current_Row) {
					current_Equal = true;
				} else {
					current_Row = sheetObj.MouseRow;
				}
				//layer 왼쪽 좌표 
				var gleft = sheetObj.ColLeft(m_col) - 150;
				//layer 위쪽 좌표 
				var gtop = 110 + sheetObj.RowTop(m_row) + sheetObj.RowHeight(m_row);
				//select box 리스트 다시 렌더링 초기화 
				iframe01.document.getElementById('ContainerList').innerHTML = checkBoxString;
				//보여주기 
				showSelectForm(gtop, gleft);

			} else {
				//감추기 
				hiddenSelectForm();
			}

		} else if (m_row > 0 && m_col == 2) {
			// 파일 다운로드 처리 
		} else {
			//그 이외의 컬럼이 눌리면  팝업 닫기
			hiddenSelectForm();
		}

	} catch (ex) {
		pri_error_alert('sheet1_OnMouseDown', ex);
		return false;
	}
}
/**
 * 보이기 multiSelectFrame  이벤트 발생
 * @param topPos    상단 좌표 
 * @param leftPos    왼쪽 좌표 
 */
function showSelectForm(topPos, leftPos) {

	alert("showSelectForm");
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var Pri_div = document.getElementById(PRI_DIV_NAME);
	var Pri_iframe = document.getElementById(PRI_FRAME_NAME);

	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
		return;

	try {

		if (current_Equal) {
			//포커스 강제설정 
			sheetObj.SelectCell(current_Row, prefix + "cargo_contain", false);
			current_Equal = false;
		}

		Pri_iframe.style.left = leftPos;
		Pri_iframe.style.top = topPos;

		if (current_Row < 0)
			current_Row = 1;
		// 눌렀을 경우  check 여부 셋팅하기 
		var _check = sheetObj.CellText(current_Row, prefix + "dcgo_seq");
		if (typeof _check != null || typeof _check != "undefined" || _check != "") {
			getMultiSelectCheck(_check);
		}

		Pri_div.style.visibility = "visible";
		Pri_iframe.style.visibility = "visible";

		Pri_div.focus();
	} catch (ex) {
		pri_error_alert('showSelectForm', ex);
		return false;
	}
}
/**
 * 숨기기 multiSelectFrame   이벤트 발생
 * @param void
 */
function hiddenSelectForm() {

	var formObj = document.form;
	var Pri_div = document.getElementById(PRI_DIV_NAME);
	var Pri_iframe = document.getElementById(PRI_FRAME_NAME);
	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
		return;
	try {
		if (Pri_div.style.visibility == "visible") {

			Pri_iframe.style.visibility = "hidden";
			Pri_div.style.visibility = "hidden";

			// 값 셋팅하기 
			setMultiSelectCheck();

			if (count_checked > 1) {
				sheetObjects[0].CellImage(current_Row, prefix + "multiPopup") = 0;
			} else {
				sheetObjects[0].CellImage(current_Row, prefix + "multiPopup") = 1;
			}

		}
	} catch (ex) {
		pri_error_alert('hiddenSelectForm', ex);
		return false;
	}
}

/**
 * setMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 구한다. 
 */
var count_checked = 0;
function setMultiSelectCheck() {

	try {

		var t_ck = iframe01.document.getElementsByName('t_check');
		var t_nm = iframe01.document.getElementsByName('t_name');
		if (t_nm.length == 0)
			return;
		var r_value = '';
		var r_text = '';
		var _flag = false;
		count_checked = 0;// initial 
		for (i = 0; i < t_ck.length; i++) {
			if (t_ck[i].checked) {
				if (!_flag)
					r_text = t_nm[i].value;
				if (_flag)
					r_value += ',';
				r_value += t_ck[i].value;
				_flag = true;
				count_checked++;
			}
		}

	} catch (ex) {
		pri_error_alert('setMultiSelectCheck', ex);
		return false;
	}
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
	var aryPrefix = new Array("sheet1_");
	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		checkBoxString = ''; 
		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
		ComSetObjValue(formObj.f_cmd, SEARCH);
		//2.조회조건으로 조회실행
		var sXml = sheetObj.GetSearchXml(URL_ESM_PRI, FormQueryString(formObj) + "&" + ComGetPrefixParam('sheet1_'));
		//3.조회후 결과처리
		sheetObj.LoadSearchXml(sXml);
		var _val = ComGetObjValue(formObj.ridr_tp_cd);
		//4.값 존재시 처리 
		if (sheetObj.RowCount > 0) {

			for ( var row = 1; row <= sheetObj.LastRow; row++) {

				//size 변경하기 
				var size = getSize(sheetObj.CellValue(row, prefix + "file_size"));
				sheetObj.CellValue(row, prefix + "file_size") = size;
				sheetObj.RowStatus(row) = 'R';
			}
		}
		
		checkBoxString = ComGetEtcData(sXml, "checkBoxString");
		break;
		
	case IBSAVE: //저장
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		//1.IBSheet 데이터 QueryString으로 묶기
		var sParam = ComGetSaveString(sheetObj);
		if (sParam == "")
			return;

		//0.IBUpload에 파일 추가하기
		var upObj = uploadObjects[0];
		upObj.Files = ""; //-먼저기존파일을 모두 지운후 추가함
		
		// File 가 5MB 이상이면 메세지를 표시한다.
		var filePath = setFileUpload(sheetObj, prefix);
		if(upObj.GetFileSize(filePath) > 5*1024*1024){
			ComShowCodeMessage("PRI09002");//"File size can't not exceeds 5MB.";
			return;
		}
		
		ComSetObjValue(formObj.f_cmd, MULTI);
		if (upObj.LocalFiles == "") {
			/*******파일이 없는 경우 IBSheet 이용하기********/
			//3.Form 데이터 QueryString으로 묶기
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
			
			//4. 서버에 request전달하고, reponse 받기
			var sXml = sheetObj.GetSaveXml(URL_ESM_PRI, sParam);
			if (sXml.length > 0)
				sheetObj.LoadSaveXml(sXml);
		} else {
			/*******파일이 있는 경우 IBUpload 이용하기********/
			//3.Form 데이터 QueryString으로 묶기
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);

			//3.저장조건으로 저장실행
			upObj.ExtendParam = sParam; //param값 추가 
			upObj.ParamDecoding = true;

			var sXml = upObj.DoUpload(true);
			//4.저장후 결과처리
			if (sXml.length > 0){
				var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if ( State == "S" ) {	
					ComShowMessage(ComGetMsg("PRI00101"));//Data saved successfully.
					sheetObj.LoadSaveXml(sXml);
				}else{
					fnExceptionMessage(sXml);
				}
			}
		}
		break;
		
	case COMMAND01: // 입력
		var sParam = ComGetSaveString(sheetObj);
		//0.IBUpload에 파일 추가하기
		var upObj = uploadObjects[0];
		upObj.Files = ""; //-먼저기존파일을 모두 지운후 추가함
		var paramFile1 = setFileUpload(sheetObj, prefix);
		ComSetObjValue(formObj.f_cmd, MULTI);
		if (upObj.LocalFiles == "") {
			/*******파일이 없는 경우 IBSheet 이용하기********/
			//3.Form 데이터 QueryString으로 묶기
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
			//4. 서버에 request전달하고, reponse 받기
			var sXml = sheetObj.GetSaveXml(URL_ESM_PRI, sParam);
			if (sXml.length > 0)
				sheetObj.LoadSaveXml(sXml);
	
		} else {
			/*******파일이 있는 경우 IBUpload 이용하기********/
			//3.Form 데이터 QueryString으로 묶기
			sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
	
			//3.저장조건으로 저장실행
			upObj.ExtendParam = sParam; //param값 추가 
			upObj.ParamDecoding = true;
			
			var sXml = upObj.DoUpload(true);
	
			//4.저장후 결과처리
			if (sXml.length > 0){
				var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if ( State == "S" ) {	
					ComShowMessage(ComGetMsg("PRI00101"));//Data saved successfully.
					sheetObj.LoadSaveXml(sXml);
				}else{
					fnExceptionMessage(sXml);
				}
			}
		}
		break;
	
	case IBINSERT: // 입력
		hiddenSelectForm();
		selectFile(sheetObj, sheetObj.RowCount, '', true);
		break;
		
	case IBDELETE: // 삭제
		if(sheetObj.CellValue(sheetObj.SelectRow, prefix + "org_file_nm") != ""){
			if (!ComShowConfirm(ComGetMsg("PRI00002"))){//Do you want to delete?
				return;
			}
			sheetObj.RowHidden(sheetObj.SelectRow)= true;
			sheetObj.CellValue(sheetObj.SelectRow, prefix + "ibflag") = "D";
			doActionIBSheet(sheetObj, document.form, COMMAND01);
		}
		break;
	}
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
 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	prefix    	파일 경로
 **/
function setFileUpload(sheetObj, prefix) {
	var sRow = sheetObj.FindStatusRow("I");
	var upObj = uploadObjects[0];
	var arrRow = sRow.split(";");

	for (idx = 0; idx < arrRow.length - 1; idx++) {
		var row = arrRow[idx];

		//파일 경로 가져오기
		var sFile = sheetObj.CellValue(row, prefix + "file_path_rmk");
		if (sFile == "")ComShowCodeMessage("PRI09003");
		
		//IBUpload에 파일 추가하기
		var ret = upObj.AddFile(sFile);

		// 파라미터 추가하기
		//sheetObj.CellValue2(row, prefix + "rgn_ofc_cd") = document.form.rgn_ofc_cd.value;
		//sheetObj.CellValue2(row, prefix + "loc_cd") 	= document.form.loc_cd.value;
		//sheetObj.CellValue2(row, prefix + "dp_seq") 	= document.form.dp_seq.value;
		
	}

	return sFile;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * B인경우 검사하지 않는다. 
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// 저장시 유효성검사 
		if (sAction == IBSAVE) {
			var c_row = sheetObj.LastRow;
			if (c_row == 0) {
				ComShowCodeMessage("PRI09004");//Please select data to save.
				return;
			} else if (c_row > 1) {
//				ComShowCodeMessage("BKG08209");//You should upload only one file.
//				ComRowHideDelete(sheetObj, prefix + "org_file_nm");
//				return;
			}
			var _val = ComGetObjValue(formObj.ridr_tp_cd);

			for ( var row = 1; row <= c_row; row++) {
				var v_file_nm = sheetObj.CellValue(row, prefix + "org_file_nm");
				if (v_file_nm == '') {
					ComShowMessage(row + " row [File Name] is mandatory. ");
					selectFile(sheetObj, sheetObj.RowCount, '', true);
					return false;
				}
			}
			// 검색시 유효성검사
		} else if (sAction == IBSEARCH) {

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
		var file_nm = sheetObj.CellText(Row, prefix + "org_file_nm");

		if (typeof file_nm == "undefined" || file_nm == "File Name" || (file_nm != "" && _insert)) {
			Row = sheetObj.DataInsert(-1, 0);//File Add인 경우 New Row 생성
		}

		var fileName = sheetObj.OpenFileDialog('');

		if (fileName.indexOf("\\") != -1) {
			sheetObj.CellValue2(Row, prefix + "file_path_rmk") = fileName;
			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
			
			// 파일명이 20자 이상이면, 경고창을 띄운다.
			if(fileName.substr(0,fileName.indexOf(".")).length >= 60){
				alert("Warning! Please Input filename within 60 characters.");
				sheetObj.CellValue2(sheetObj.SelectRow, prefix + "ibflag") = "D";
			} else {
				//sheetObj.CellValue2(Row, prefix + "file_nm") = fileName;
				sheetObj.CellValue2(Row, prefix + "org_file_nm") = fileName;
				//sheetObj.CellValue2(Row, prefix + "sav_file_nm") = fileName;
				sheetObj.CellValue2(Row, prefix + "scq_rqst_no") = formObj.scq_rqst_no.value;
				sheetObj.CellValue2(Row, prefix + "spcl_cgo_tp_cd") = formObj.spcl_cgo_tp_cd.value;
			}
		}
	}
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
 * Debug alert 
 */
function pri_error_alert(msg, ex) {
	alert('[ ' + msg + ' ] = [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
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