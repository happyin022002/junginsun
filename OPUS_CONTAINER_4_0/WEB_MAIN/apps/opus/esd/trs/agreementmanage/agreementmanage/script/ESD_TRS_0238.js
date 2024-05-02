/*
=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0238.js
*@FileTitle  : Agreement Attach File Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2015/09/24
=========================================================
*/
// 공통전역변수
var sheetObjects=new Array();
var uploadObjects=new Array();
var uploadCnt=0;
var sheetCnt=0;
var checkBoxString='';
var iframeW=190;
var iframeH=100;
var _debug=false;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: //sheet1 init
	    with(sheetObj){
			var HeadTitle="|Sel.|File Name|File Size||||";
			var headCount=ComCountHeadTitle(HeadTitle);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [
			    {Type:"Status",    Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		        {Type:"CheckBox",  Hidden:0, 	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",       KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		        {Type:"PopupEdit", Hidden:0,  	Width:350,  Align:"Left",    ColMerge:1,   SaveName:"file_nm",       KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        {Type:"Text",      Hidden:0,  	Width:80,   Align:"Right",   ColMerge:1,   SaveName:"file_size",     KeyField:0,   CalcLogic:"",   Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"file_path_rmk" },
		        {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"file_sav_id" },
		        {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"img_seq" }
		        ];
			InitColumns(cols);
			SetEditable(1);
			SetShowButtonImage(2);
			SetFocusEditMode(0);
			resizeSheet();
		}
		break;
	}
}
	
function resizeSheet(){
	ComResizeSheet(sheetObjects[0],65);
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
			case "btn_delete":
				doActionIBSheet(sheetObj, formObj, IBDELETE);
				break;
			case "btn_save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
		} // end switch
	} catch (e) {
	}
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj=document.form;
	if (formObj.agmt_no.value == '') {
		ComShowCodeMessage("TRS90464");	// 조회를 위한 Agreement No가 없습니다.
	}
	
	for (var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initUpload();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

function initUpload(){
	upload1.Initialize({
		SaveUrl:"/opuscntr/ESD_TRS_0238GS.do",
		ShowButtonArea: true,
		ShowInfoArea: false,
		ExtraForm:'upLoadForm',
		
		AfterSaveStatus : function(result) { // 상태 저장 후 실행
			// 에러코드
			var code = result.code;
			
			if(document.upLoadForm){ // upLoadForm이 있을 경우 제거(중복 방지)
				document.body.removeChild(document.upLoadForm);
			}
			
      		if( code == 0) { // 에러가 없을 경우 sheet1에 데이터 로드
      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
      			sXml = convert2ibsheet7(sXml);
      			if (sXml.length > 0){
      				ComShowMessage(ComGetMsg("TRS90405"));
      				sheet1.LoadSaveData(sXml);
      			}
 				var files = result.files;
                for( var i = 0; i < files.length; i++) {
                	ComUploadRemoveFile(upload1, "", true);
                }
      		}else {
				ComShowMessage(result.msg);
			}
		},			
		
		AfterAddFile : function(result) { // 파일 추가 이벤트 발생하고 파일 선택이 이루어진 후 실행
			doActionIBSheet(sheetObjects[0], document.form, IBINSERT);  
			
            var files = result.files; // 업로드 대상 파일 목록
            var fileName=files[files.length-1].GetFileName();
            var row = sheet1.GetSelectRow();
            var formObj = document.form;
			
            for( var i = 0; i < files.length; i++) {
            	if(sheet1.GetCellValue(sheet1.GetSelectRow(), "file_nm") == files[i].GetFileName()){
            		files[i].DeleteFromList();
            	}
            }
            var files = upload1.GetList();
            var fileName=files[files.length-1].GetFileName(); // FILE_NM 저장
            var serialNo = files[files.length-1].GetSerialNo(); // FILE_SAV_ID 저장
            var row = sheet1.GetSelectRow();
			
            for( var i = 0; i < files.length; i++) {
            	console.log(sheet1.GetCellValue(sheet1.GetSelectRow(), "file_sav_id") + ">>" + files[i].GetSerialNo());
            	if(sheet1.GetCellValue(sheet1.GetSelectRow(), "file_sav_id") == files[i].GetSerialNo()) {
            		upload1.RemoveOneFile(files[i].GetSerialNo()); // 중복 파일 삭제
            	}
            }
            
            sheet1.SetCellValue(row, "file_path",fileName, 0);
			sheet1.SetCellValue(row, "file_nm",fileName, 0);
			sheet1.SetCellFontUnderline(row, "file_nm", 1);
		},
		
		AfterOnload : function() { // 업로더 초기화 된 후 실행
	        upload1.SetCustomAddButtonAsID('btn_upload');
		}
	});
}

function sheet1_OnMouseMove(){
	var row     = sheet1.MouseRow(),
    col     = sheet1.MouseCol(),
    info    = null;
         
    if (row > 0 &&col == 2) {
    	prow = row;
    	info = sheet1.GetCellElement(row, col, 1);
    	upload1.SetFileUploadElement(info);
    } 
}

/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SetColFontUnderline("file_nm", 1);
		SetDataLinkMouse("file_nm", 1);
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
	
	if (Col != 2) return;
	if (sheetObj.ColSaveName(Col) == "file_nm") {
		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		if (sheetObj.GetCellText(Row, "file_nm") == "" || sheetObj.GetRowStatus(Row) == "I") {
			selectFile(sheetObj, Row, Col, false);
			return;
		}
		// 파일이 존재시 다운로드 받는다.
		var key_id=sheetObj.GetCellValue(Row, "file_sav_id");
		var exist=fnSaveFileExist(key_id , sheetObj);
		// 서버에 파일존재유무확인 
		if(eval(exist)){
			hiddenFrame.location.href="/opuscntr/FileDownload?key=" + key_id;
		}else{
			ComShowMessage(ComGetMsg("TRS90465"));
		}
	}
}
 /**
  * 파일존재유무판단  
  * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
  * param :file_id
  * return :boolean
  */
 function fnSaveFileExist(file_id,sheetObj) {
 	var formObj=document.form;
 	var param="&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
  	var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
 	var output_text=ComGetEtcData(sXml, "output_text");
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
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		checkBoxString=''; 
		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
		formObj.f_cmd.value = SEARCH;
		//2.조회조건으로 조회실행
		var sXml=sheetObj.GetSearchData("ESD_TRS_0238GS.do", FormQueryString(formObj));
		//3.조회후 결과처리
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		//4.값 존재시 처리 
		if (sheetObj.RowCount()> 0) {
			for ( var row=1; row <= sheetObj.LastRow(); row++) {
				//size 변경하기 
				var size = getSize(sheetObj.GetCellValue(row, "file_size"));
				sheetObj.SetCellValue(row, "file_size", size);
				sheetObj.SetRowStatus(row,'R');
			}
		}
		checkBoxString=ComGetEtcData(sXml, "checkBoxString");
		break;
	case IBSAVE: //저장
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		
		if (!ComShowConfirm(ComGetMsg("TRS90463"))){ // 삭제 확인 팝업메시지
			return;
		}
		
		//1.IBSheet 데이터 QueryString으로 묶기
		var sParam=ComGetSaveString(sheetObj);
		if (sParam == "")
			return;
		//0.IBUpload에 파일 추가하기
		formObj.f_cmd.value = MULTI;
		if (upload1.GetList().length == 0) {
			/*******파일이 없는 경우 IBSheet 이용하기********/
			//3.Form 데이터 QueryString으로 묶기
			sParam += "&" + FormQueryString(formObj);
			//4. 서버에 request전달하고, reponse 받기
			var sXml=sheetObj.GetSaveData("ESD_TRS_0238GS.do", sParam);
			if (sXml.length > 0)
				sheetObj.LoadSaveData(sXml);
			
		} else {
			/*******파일이 있는 경우 IBUpload 이용하기********/
	        sParam += "&" + FormQueryString(formObj);
	        paramToForm(sParam);
	        upload1.SaveStatus();
		}
		break;
	case IBINSERT: // 입력
		selectFile(sheetObj, sheetObj.RowCount(), '', true);
		break;
	case IBDELETE: // 삭제
		if (sheetObj.FindCheckedRow("del_chk") != "") {
			if (!ComShowConfirm(ComGetMsg("TRS90467"))){
				return;
			}
			ComRowHideDelete(sheetObj, "del_chk");
			
			var sParam=ComGetSaveString(sheetObj);
			//0.IBUpload에 파일 추가하기
			var upObj=uploadObjects[0];
			formObj.f_cmd.value = MULTI;
			if (upload1.GetList().length == 0) {
				/*******파일이 없는 경우 IBSheet 이용하기********/
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj);
				//4. 서버에 request전달하고, reponse 받기
				var sXml=sheetObj.GetSaveData("ESD_TRS_0238GS.do", sParam);
				if (sXml.length > 0)
					sheetObj.LoadSaveData(sXml);
			} else {
				/*******파일이 있는 경우 IBUpload 이용하기********/
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj);
				paramToForm(sParam);
				upload1.SaveStatus();
			}
		} else {
			ComShowCodeMessage("TRS90382");//"No Selected Row";
		}
		break;
	}
}
/**
 * 용량계산하기  <br>
 * @param {String} 	val 		파일용량
 * @param {String} 	r_value    	MB/KB계산 
 **/
function getSize(val) {
	var r_value = val;
	var value = Math.round(val / 1024);
	if (value > 0) {
		r_value = value;
		value = Math.round(value / 1024);
		if (value > 0) {
			value = value + " MB"
		} else {
			value = r_value + " KB"
		}
	} else {
		value = r_value + " Bytes"
	}
	return value;
}
/**
 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {String} 	prefix    	변수 구분값
 **/
function setFileUpload(sheetObj, prefix) {
	var sRow = sheetObj.FindStatusRow("I");
	var upObj = uploadObjects[0];
	var arrRow = sRow.split(";");
	for (idx = 0; idx < arrRow.length - 1; idx++) {
		var row = arrRow[idx];
		//파일 경로 가져오기
		var sFile = sheetObj.GetCellValue(row, "file_path");
		if (sFile == "") { // 업로드 실패 시
			ComShowCodeMessage("TRS90466");
		}
		//IBUpload에 파일 추가하기
		var ret = upObj.AddFile(sFile);
	}
	var param = "file_cnt=" + (arrRow.length - 1);
	return param;
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * B인경우 검사하지 않는다. 
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// 저장시 유효성검사 
		if (sAction == IBSAVE) {
			var c_row = sheetObj.LastRow();
			if (c_row == 0) { // 선택된 row가 없을 경우
				ComShowCodeMessage("TRS90215");
				return;
			}
			for ( var row = 1; row <= c_row; row++) {
				var v_file_nm = sheetObj.GetCellValue(row, "file_nm");
				if (v_file_nm == '') {
					ComShowMessage(row + "행의 [File Name]은 필수값입니다. ");
					selectFile(sheetObj, sheetObj.RowCount(), '', false);
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
function selectFile(sheetObj, Row, Col, insert) {
	var formObj = document.form;
	if (Col == '' || Col == '2') {
		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		var file_nm = sheetObj.GetCellText(sheetObj.GetSelectRow(), "file_nm");
		
		if(insert){
			Row = sheetObj.DataInsert(-1, 0);//File Add인 경우 New Row 생성
		}else{
			var filePath = sheetObj.OpenFileDialog('Please choose target file to upload.');
			if(filePath.indexOf("\\") != -1) {
				with(sheetObj) {
					SetCellValue(GetSelectRow(), "file_path", fileName, 0);
					fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
					SetCellValue(GetSelectRow(), "file_nm", fileName, 0);
				}
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
