/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_PSO_0041.js
*@FileTitle : File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.02
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2014.07.02 
* 1.0 Creation
 *----------------------------------------------------------
 * History
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
 * @class VOP_PSO_0041 : VOP_PSO_0041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0041() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var uploadObjects = new Array();
var uploadCnt = 0;

var FILE_SELECT_CANCEL 	= "USER_CANCEL";
var FILE_NM 			= "file_nm";
var FILE_SIZE			= "file_size";
var FILE_PATH 			= "file_path";
var FILE_SAV_ID 		= "file_sav_id";
var UPD_DT              = "upd_dt";
var ATCH_FILE_DIV_CD	= "atch_file_div_cd";
var PREFIX 				= "sheet1_";
var URL_VOP_PSO 		= "VOP_PSO_0041GS.do";
var URL_FILE_DOWNLOAD 	= "/hanjin/FileDownload";


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
 * @param {ibupload} uploadObj    IBUpload Object
 **/
function setUploadObject(upload_obj) {
	uploadObjects[uploadCnt++] = upload_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	var formObj = document.form;
	
	if (!validateParam()) {
		window.close();
	}
	else {
		for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		//UPLOAD 환경 설정
		for (var i = 0; i < uploadObjects.length; i++) {
			//1. 기본 환경 설정
			ComConfigUpload(uploadObjects[i], "/hanjin/" + URL_VOP_PSO);
	
			// 2. Upload 초기화
			// initUpload(uploadObjects[i],i+1);
		}
		uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";

		var arrFileDivCd = new Array();
		arrFileDivCd[0] = "R";
		arrFileDivCd[1] = "C";
		// Regulation/Contract 첨부파일 조회
		for (var i=0; i<sheetObjects.length; i++) {
			//첨부파일구분코드설정
			ComSetObjValue(formObj.atch_file_div_cd, arrFileDivCd[i]);
			
			doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
		}

		if (sCaller == "0036") {	// Port Tariff Inquiry 화면에서 호출시
			ComBtnDisable("btn_upload");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_save");
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	with (sheetObj) {
		// 높이 설정
		style.height = 157;
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

		var HeadTitle = "|Sel.|File Name|File Size|Auth|Upload date";
		
		var headCount = ComCountHeadTitle(HeadTitle) + 3;
		
		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false, false)

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtHiddenStatus, 	  0, 	daCenter, true, 	PREFIX + "ibflag");
		InitDataProperty(0, cnt++, dtCheckBox, 		 40, 	daCenter, true, 	PREFIX + "del_chk", 	false, "", dfNone, 0, true, true);
		InitDataProperty(0, cnt++, dtPopup, 		165,   	  daLeft, false, 	PREFIX + FILE_NM, 		false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 			 50, 	daCenter, false, 	PREFIX + FILE_SIZE, 	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtCheckBox, 		 45, 	daCenter, true, 	PREFIX + "ctrt_scr_flg", 	false, "", dfNone, 0, true, true);
		InitDataProperty(0, cnt++, dtData, 	    	 40, 	daCenter, false, 	PREFIX + UPD_DT, 		false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	PREFIX + FILE_PATH);
		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	PREFIX + FILE_SAV_ID);
		InitDataProperty(0, cnt++, dtHidden, 		  0, 	daCenter, false, 	PREFIX + ATCH_FILE_DIV_CD);

		MultiSelection = false;
		SelectHighLight = true;
		SheetBackColor = RgbColor(248, 248, 248);
		SelectBackColor = RgbColor(236, 246, 247);
		CountPosition = 0;
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	
	var formObj = document.form;
	var crCd    = ComGetObjValue(formObj.cr_cd);
	
	/** 시트변수 설정 ****************************************/
	var sheetObj = crCd == "R" ? sheetObjects[0] : sheetObjects[1];
	var crNm	 = crCd == "R" ? "[Regulation]"  : "[Contract]";
	/*********************************************************/
	
	var srcName = window.event.srcElement.getAttribute("name");

	switch (srcName) {
	case "btn_upload":
		doActionIBSheet(sheetObj, formObj, IBINSERT);
		break;
		
	case "btn_delete":
		ComSetObjValue(formObj.atch_file_div_cd, ComGetObjValue(formObj.cr_cd));
		doActionIBSheet(sheetObj, formObj, IBDELETE);
		break;
		
	case "btn_save":
		// 변경된 파일정보가 존재하는지 체크한다.
		if (!fnExistsNoSaveAtchFilesBySheet(sheetObj)) {
			alert(crNm + " There is no data changed");
			return;
		}
	
		if (!confirm(crNm + " Data Changed. Do you want to save it ?")) {
			return;
		}
		
		ComSetObjValue(formObj.atch_file_div_cd, ComGetObjValue(formObj.cr_cd));		
		doActionIBSheet(sheetObj, formObj, IBSAVE);		
		break;
		
	case "btn_close":
		
		// 첨부만 하고 저장하지 않은 파일이 존재하는지 체크한다.
		if (fnExistsNoSaveAtchFiles()) {
			// 저장하지 않은 파일이 존재하는데도, 팝업윈도우를 종료할지를 유저에게 확인후 처리한다.
			if (!confirm("There is files that you don't save. Do you want to close popup?"))
				return;
		}
		
		var atchFileNames = fnAtchFileNames();
		eval("window.opener." + sFunc + "(atchFileNames)");
		window.close();
		break;
	}
}

/**
 * 첨부만하고 저장하지 않은 파일이 존재하는지 체크해주는 함수 <br>
 **/
function fnExistsNoSaveAtchFiles() {
	
	var isExists = false;
	
	for (var i=0; i< sheetObjects.length; i++) {
		if (fnExistsNoSaveAtchFilesBySheet(sheetObjects[i])) {
			isExists = true;
			break;
		}
	}	
	
	return isExists;
}

/**
 * 첨부만하고 저장하지 않은 파일이 존재하는지 체크해주는 함수 <br>
 **/
function fnExistsNoSaveAtchFilesBySheet(sheetObj) {
	
	var count = 0;	// 첨부만되고 저장하지 않은 파일 갯수
	
	if (sheetObj.RowCount > 0) {
		for (var i=1; i<=sheetObj.RowCount; i++) {
			// 저장완료된 파일만 첨부파일명에 추가한다.

			if (sheetObj.RowStatus(i) == "I" || sheetObj.RowStatus(i) == "U") {
				count++;
			}
		}
	}
	
	return count > 0;
}

/**
 * 부모창에 전달할 첨부된 파일명을 반환해주는 함수 <br>
 **/
function fnAtchFileNames() {
	
	var atchFileNames = "";	// 첨부및 저장이 완료된 파일명 리스트
	
	var arrAtchFileName  = new Array();
	var arrAtchFileDivCd = new Array();
	arrAtchFileName[0]   = "";
	arrAtchFileName[1]   = "";
	arrAtchFileDivCd[0]  = "R";
	arrAtchFileDivCd[1]  = "C";
	
	for (var i=0; i< arrAtchFileDivCd.length; i++) {
		if (sheetObjects[i].RowCount > 0) {
			for (var j=1; j<=sheetObjects[i].RowCount; j++) {
				// 저장완료된 파일만 첨부파일명에 추가한다.					
				if (sheetObjects[i].RowStatus(j) == "R") {
					if (arrAtchFileName[i].length > 0) {
						arrAtchFileName[i] += ",";
					}
					arrAtchFileName[i] += sheetObjects[i].CellValue(j, PREFIX + FILE_NM);
				}
			}
			// 파일구분별로 저장된 파일명이 존재하는 경우에만 Prefix 를 붙여준다.(Regulation : [R], Contract : [C])
			if (arrAtchFileName[i].length > 0)
				arrAtchFileName[i] = "[" + arrAtchFileDivCd[i] + "]" + arrAtchFileName[i];
		}
	}
	
	for (var i=0; i<arrAtchFileName.length; i++) {
		if (atchFileNames.length > 0)
			atchFileNames += " ";
		atchFileNames += arrAtchFileName[i];
	}
	
	return atchFileNames;
}

/**
 * Sheet관련 프로세스 처리 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	formObj   
 * @param {String} 	sAction   
 * @return {없음}
 **/
function doActionIBSheet(sheetObj, formObj, sAction) {

	switch (sAction) {

		case IBSEARCH: //조회
			if (!validateForm(sheetObj, formObj, sAction))
				return;

			// 1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
			ComSetObjValue(formObj.f_cmd, SEARCH);
			// 2.조회조건으로 조회실행
			var sXml = sheetObj.GetSearchXml(URL_VOP_PSO, FormQueryString(formObj) + "&" + ComGetPrefixParam('sheet1_'));
			// 3.조회결과 바인딩
			sheetObj.LoadSearchXml(sXml);
			// 4.값 존재시 처리
			if (sheetObj.RowCount > 0) {
				//size 변경하기 
				for (var row = 1; row <= sheetObj.LastRow; row++) {
					var size = getSize(sheetObj.CellValue(row, PREFIX + FILE_SIZE));
					sheetObj.CellValue(row, PREFIX + FILE_SIZE) = size;
					sheetObj.RowStatus(row) = 'R';
				}
			}	
		
			break;
	
		case IBSAVE: //저장
			if (!validateForm(sheetObj, formObj, sAction))
				return;

			// 0.IBUpload에 파일 추가하기
			var upObj = uploadObjects[0];
			
			uploadFileToGrid(sheetObj, formObj);	// UPLOAD 할 파일을 선택해서 그리드에 매핑해준다.
			ComSetObjValue(formObj.f_cmd, MULTI);

			// 2.IBSheet 데이터 QueryString으로 묶기
			var sParam = ComGetSaveString(sheetObj);
			if (sParam == "")
				return;

			// 1.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.
			ComOpenWait(true, true); // 키보드나 마우스를 대기상태 & 대기이미지

			if (upObj.LocalFiles == "") {
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(PREFIX);
				// 4. 서버에 request전달하고, reponse 받기
				var sXml = sheetObj.GetSaveXml(URL_VOP_PSO, sParam);
				if (sXml.length > 0)
					sheetObj.LoadSaveXml(sXml);
			} 
			else {
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(PREFIX);
				// 3.저장조건으로 저장실행
				upObj.ExtendParam = sParam; // param값 추가
				upObj.ParamDecoding = true;
				var sXml = upObj.DoUpload(true);
				
				// 4.저장후 결과처리
				if (sXml.length > 0) {
					var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if (State == "S") {	
						sheetObj.LoadSaveXml(sXml);
					}
				}
			}
			ComOpenWait(false);			
			break;
			
		case IBINSERT: // 입력
			selectFile(sheetObj, sheetObj.RowCount, "", true);
			break;
			
		case IBDELETE: // 삭제
			var crNm = ComGetObjValue(formObj.cr_cd) == "R" ? "[Regulation]" : "[Contract]";
			if (sheetObj.FindCheckedRow(PREFIX + "del_chk") != "") {
				if (!confirm(crNm + " Are you sure to delete?")){ 
					return;
				}
				ComRowHideDelete(sheetObj, PREFIX + "del_chk");
				doActionIBSheet(sheetObj, document.form, IBSAVE);
			} else {
				alert(crNm + " No Selected Row");
				//ComShowCodeMessage("BKG00249");// "No Selected Row";
			}
			break;
	}
}


/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	fnFormatFileName(sheetObj);
	var temp = sheetObj.cellValue(2,PREFIX+"CTRT_SCR_FLG");

}

/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	fnFormatFileName(sheetObj);
}

/**
 * 파일 링크설정 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 */
function fnFormatFileName(sheetObj) {
	with (sheetObj) {
		ColFontUnderline(PREFIX + FILE_NM) = true;
		DataLinkMouse(PREFIX + FILE_NM) = true;
	}	
}

/**
 * Sheet 저장완료 후 이벤트 발생
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	
	fnSearchAfterSave(sheetObj);
}

/**
 * Sheet 저장완료 후 이벤트 발생
 */
function sheet2_OnSaveEnd(sheetObj, ErrMsg) {

	fnSearchAfterSave(sheetObj);
}

/**
 * Regulation, Contract 파일 저장후 재조회
 */
function fnSearchAfterSave(sheetObj) {
	
	var formObj       = document.form;
	var atchFileDivCd = sheetObj.id == "sheet1" ? "R" : "C";
	ComSetObjValue(formObj.atch_file_div_cd, atchFileDivCd);
	
	doActionIBSheet(sheetObj, document.form, IBSEARCH); // 파일링크를 위해 재조회
}

/**
 * Regulation File Sheet 클릭 이벤트 발생
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {

	fnDownloadAtchFile(sheetObj, Row, Col);
}

/**
 * Contract File Sheet 클릭 이벤트 발생
 */
function sheet2_OnClick(sheetObj, Row, Col, Value) {

	fnDownloadAtchFile(sheetObj, Row, Col);
}

/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 **/
function fnDownloadAtchFile(sheetObj, Row, Col) {
	
	if (Col != 2) return;
	 
	// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
	if (sheetObj.CellText(Row, PREFIX + FILE_NM) == "" || sheetObj.RowStatus(Row) == "I") {
		return;
	}
	
	// 파일이 존재시 다운로드 받는다.
	var file_key = sheetObj.CellValue(Row, PREFIX + FILE_SAV_ID);
	var exist    = fnSaveFileExist(file_key , sheetObj);
	
	// 서버에 파일존재유무확인
	if (eval(exist)) {
		var param = "key=" + file_key;
		hiddenFrame.location.href = URL_FILE_DOWNLOAD + "?" + param;
	}
	else {
		alert("Attached File is deleted due to storage server capacity");
	}	
}

/**
 * 파일존재유무판단  
 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
 * param :file_id
 * return :boolean
 */
function fnSaveFileExist(file_key, sheetObj) {
	var formObj = document.form;
	var param = "&f_cmd=" + SEARCH02 + "&file_key=" + file_key;
	var sXml = sheetObj.GetSearchXml("PSO_COMGS.do", param);
	var exist = ComGetEtcData(sXml, "is_exists");
	return exist;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	// 저장시 유효성검사 
	if (sAction == IBSAVE) {
		var c_row = sheetObj.LastRow;
		if (c_row == 0) {
			var crNm = ComGetObjValue(formObj.cr_cd) == "R" ? "[Regulation]" : "[Contract]";
			alert(crNm + " Please select data to save.");
			return false;
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
	
	if (Col == "" || Col == "2") {
		
		var fileName = sheetObj.OpenFileDialog("");
		
		// 파일대화상자에서 선택한 파일이 없을 경우 종료
		if (fileName.indexOf(FILE_SELECT_CANCEL) != -1) {
			return;
		}

		// 행이 없는 경우..
		if ((sheetObj.HeaderRows - Row) == 0 || _insert) {
			Row = sheetObj.DataInsert(-1, 0);// File Add인 경우 New Row 생성
		}		

		if (fileName.indexOf("\\") != -1) {
			sheetObj.CellValue2(Row, PREFIX + FILE_PATH) = fileName;
			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
			sheetObj.CellValue2(Row, PREFIX + FILE_NM) = fileName;
			sheetObj.CellValue2(Row, PREFIX + ATCH_FILE_DIV_CD) = ComGetObjValue(formObj.cr_cd);
		}
	}
}

/**
 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	prefix    	변수 구분값
 **/
function uploadFileToGrid(sheetObj, formObj) {
	
	uploadObjects[0].Files = ""; // -먼저기존파일을 모두 지운후 추가함

	var arrRow   = sheetObj.FindStatusRow("I").split(";");
	
	for (idx=0; idx<arrRow.length-1; idx++) {
		// IBUpload에 파일 추가하기
		uploadObjects[0].AddFile(sheetObj.CellValue(arrRow[idx], PREFIX + FILE_PATH));
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
 * 전달매개변수 존재여부 체크  <br>
 **/
function validateParam() {
	
	var formObj = document.form;
	
	if (ComGetObjValue(formObj.yd_chg_no) == "") {
		alert("There is no charge no.");
		return false;
	} 
	else if (ComGetObjValue(formObj.yd_chg_ver_seq) == "") {
		alert("There is no charge ver.");
		return false;
	}
	return true;
}

/* 개발자 작업  끝 */