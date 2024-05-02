/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_EAS_0226.js
*@FileTitle : EAC File Attach
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-11
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 1.0 최초 생성
*
=========================================================*/

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * 구주 S/O
 */

function initSheet(sheetObj, sheetNo) {
  var sheetObj   = sheetObjects[0]; 
  var cnt = 0;
  switch(sheetNo) {
  	case 1: //sheet0 init 
	  with (sheetObj) {
		  // 높이 설정
		  style.height = GetSheetHeight(10);
		  //전체 너비 설정
		  SheetWidth = mainTable.clientWidth;
	
		  //Host정보 설정[필수][HostIp, Port, PagePath]
		  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
		  //전체Merge 종류 [선택, Default msNone]
		  MergeSheet = msHeaderOnly;
	
		  //전체Edit 허용 여부 [선택, Default false]
		  Editable = true;
	
		  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		  InitRowInfo( 1, 1, 9, 100);
	
		  // 해더에서 처리할 수 있는 각종 기능을 설정한다
		  InitHeadMode(true, true, true, true, false,false) ;
		  var HeadTitle = "|||File Name|File Size|Date(Local)|file_sav_id|file_path_desc|atch_file_lnk_seq" ;
		  var HeadCount = ComCountHeadTitle(HeadTitle);
		  
		  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		  InitColumnInfo(HeadCount, 0, 0, true);
		  
		  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		  InitHeadRow(0, HeadTitle, true);
		  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		  InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
		  InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daRight,   true,   "status",         		false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);		  
		  InitDataProperty(0, cnt++ , dtCheckBox,       25,  	daCenter,   true,   "del_chk",              	false,    "",      dfNone,          0,          true,        true,   0,  false, true,  "", false);
		  InitDataProperty(0, cnt++ , dtData,     200,  daLeft, true, "file_nm",      false,    "",  dfNone,     0,     false,  false,    9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     100,  daLeft, true, "file_size",      false,    "",  dfNone,     0,     false,  false,    9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,     90,  daCenter, true, "rgst_dt", false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtHidden,     0,  daLeft, true, "file_sav_id", false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtHidden,     0,  daLeft, true, "file_path_desc", false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtHidden,     0,  daLeft, true, "atch_file_lnk_seq", false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
	  }
  break;
  }
}

/**
* Sheet 기본 설정 및 초기화 
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); //khlee-시작 환경 설정 함수 이름 변경
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
	}
	var sheetObj = sheetObjects[0];
	
	//UPLOAD 환경 설정
	for ( var i = 0; i < uploadObjects.length; i++) {
		//1. 기본 환경 설정
		ComConfigUpload(uploadObjects[i], "/hanjin/" + "ESD_EAS_0226GS.do");
	}
	var formObj = document.form;
	
	//var attachFileReadOnly = formObj.attach_file_readonly.value;
//	if (attachFileReadOnly.substr(0,1) == "Y") {
//	    ComBtnDisable("btng_upload"); // upload버튼 비활성화
//    }
//	if (attachFileReadOnly.substr(1,1) == "Y") {
//		ComBtnDisable("btng_remove"); // delete버튼 비활성화
//	}
//	if (attachFileReadOnly == "Y") {
//		ComBtnDisable("btng_remove"); // delete버튼 비활성화
//	}
	doActionIBSheet(sheetObj,formObj,IBSEARCH);
}

//페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록
function setUploadObject(uploadObj){
   uploadObjects[uploadCnt++] = uploadObj;
}


/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
/* 공통전역변수 */
var sheetObjects     = new Array();
var sheetCnt         = 0;

var uploadObjects = new Array();
var uploadCnt = 0;

document.onclick = processButtonClick;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var sheetObj = sheetObjects[0];

    /*******************************************************/
    var formObj = document.form;

   try {
       var srcName = window.event.srcElement.getAttribute("name");
       switch(srcName) {
	       case "btng_upload":
	    	   sheet_FileUpload(sheetObj);
	    	   break;
	       case "btng_remove":
	    	   sheet_DataDelete(sheetObj);
	    	   break;
	       case "btng_close":
	    	   window.close();
	    	   break;
       } // end switch
   }catch(e) {
       if( e == "[object Error]") {
			ComShowCodeMessage('TRS90031');
       } else {
			ComShowMessage(e);
       }
   }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
	var formObj = document.form;

    switch(sAction) {
       case IBSEARCH:
	   	    formObj.f_cmd.value = SEARCH01;
	   	    sheetObj.DoSearch4Post("ESD_EAS_0226GS.do", FormQueryString(formObj));
			break;
       case IBSAVE:      // 저장
           formObj.f_cmd.value = MULTI;

           //1.IBUpload에 파일 추가하기
           var upObj = uploadObjects[0];
           upObj.Files=""; //-먼저기존파일을 모두 지운후 추가함
           setFileUpload(sheetObj);
           //2.IBSheet 데이터 QueryString으로 묶기
           var sParam = ComGetSaveString(sheetObj);
           if (sParam == "") return;
           //3.Form 데이터 QueryString으로 묶기
           sParam += "&" + FormQueryString(formObj);
           ComOpenWait(true);
           //4. 서버에 request전달하고, reponse 받기

           if (upObj.LocalFiles == "") {
               /*******파일이 없는 경우 IBSheet 이용하기********/
        	   var sXml = sheetObj.GetSaveXml("ESD_EAS_0226GS.do", sParam);           
           } else {
               /*******파일이 있는 경우 IBUpload 이용하기********/
               upObj.ExtendParam = sParam;
               upObj.ParamDecoding = true;
               var sXml = upObj.DoUpload(true);
           }
    	   var atch_file_lnk_id = ComGetEtcData(sXml,"atch_file_lnk_id");
                  
    	   if (atch_file_lnk_id != "undefined" && atch_file_lnk_id !=undefined ) {
    		   formObj.atch_file_lnk_id.value = atch_file_lnk_id;
    	   }

			//5.저장후 결과처리
			if (sXml.length > 0){
				var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
				if ( State == "S" ) {	
					ComShowMessage(ComGetMsg("BKG06071"));
					sheetObj.LoadSaveXml(sXml);
				}else{
					fnExceptionMessage(sXml);
				}
			}
           ComOpenWait(false);
           break;
    }
}

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * File Upload
 * @param {ibsheet} sheetObj    IBSheet Object
 * @return {없음}
 **/
function sheet_FileUpload(sheetObj) {
	var formObj = document.form;
	if (selectFile(sheetObj, sheetObj.RowCount, '', true)) {
		doActionIBSheet(sheetObj, formObj, IBSAVE);
	}
}

/**
 * Row Delete
 * @param {ibsheet} sheetObj    IBSheet Object
 * @return {없음}
 **/
function sheet_DataDelete(sheetObj) {
	var formObj = document.form;

	if(sheetObj.FindCheckedRow("del_chk") == ""){   
		ComShowCodeMessage("EAS90051");
		return false;
	}

	if(confirm(ComGetMsg('COM12165', ''))) {
		ComRowHideDelete(sheetObj, "del_chk");
		doActionIBSheet(sheetObj, formObj, IBSAVE);
	}
}

/**
 * 파일 선택하기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
 **/
function selectFile(sheetObj, Row, Col, _insert) {
	var formObj = document.form;
	if (Col == '' || sheetObj.ColSaveName(Col) == 'file_nm') {
		//파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
		var file_nm = sheetObj.CellText(Row, "file_nm");

		if (typeof file_nm == "undefined" || file_nm == "File Name" || (file_nm != "" && _insert)) {
			Row = sheetObj.DataInsert(-1, 0);//File Add인 경우 New Row 생성
		}

		var fileName = sheetObj.OpenFileDialog('');
		if (fileName == "<USER_CANCEL>") {
			sheetObj.RowDelete(Row, false);
			return false;
		}

		//USER_CANCEL
		if (fileName.indexOf("\\") != -1) {
			sheetObj.CellValue2(Row, "file_path_desc") = fileName;
			sheetObj.CellValue2(Row, "eac_no") = formObj.eac_no.value;
			//sheetObj.CellValue2(Row, "eac_cmpl_cd") = formObj.eac_cmpl_cd.value;
			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
			sheetObj.CellValue2(Row, "file_nm") = fileName;
			
//			// 파일명이 20자 이상이면, 경고창을 띄운다.
//			if(fileName.substr(0,fileName.indexOf(".")).length >= 50){
//				alert("Warning! Please Input filename within 20 characters.");
//				sheetObj.CellValue2(sheetObj.SelectRow, "ibflag") = "D";
//			} else {
//				sheetObj.CellValue2(Row, "file_nm") = fileName;
//			}
		}
	}
	return true;
}

/**
 * 첨부파일을 저장한다.<br>
 * @param {ibsheet} sheetObj    IBSheet Object
 **/
function doUpload(sheetObj) {

}


/**
 * IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 **/
function setFileUpload(sheetObj) {
	//트랜잭션 상태가 "입력"인 행을 찾아 온다.
	var sRow = sheetObj.FindStatusRow("I");
	var upObj = uploadObjects[0];
	var arrRow = sRow.split(";");
	
	for (idx=0; idx<arrRow.length-1; idx++){ 
		var row = arrRow[idx];

		//IBSheet에서 파일 경로 가져오기
		var sFile = sheetObj.CellValue(row, "file_path_desc");
		if (sFile == "") ComShowCodeMessage("EAS90050");
		
		//IBUpload에 파일 추가하기
		upObj.AddFile(sFile);
	}
}

/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		ColFontUnderline("file_nm") = true;
		DataLinkMouse("file_nm") = true;
	}
}

/**
 * Sheet 저장완료 후 이벤트 발생
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	//if (ErrMsg.length > 30) return;
	doActionIBSheet(sheetObj, document.form, IBSEARCH); // 파일링크를 위해 재조회
}

/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 * @param {String} 	Value     	파일명
 **/
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	if (sheetObj.ColSaveName(Col) != 'file_nm') return;
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row, "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(ComGetMsg("EAS90052"));
	}
}

/**
 * 파일 첨부여부 리턴
 */
function fnRtnFileY() {
	var parentObj = window.dialogArguments.document.form;
	var sheetObj   = sheetObjects[0];
	var formObj = document.form;
	var atch_file_lnk_id = formObj.atch_file_lnk_id.value;    
	if (sheetObj.RowCount > 0) {	
		ComSetObjValue(parentObj.atch_file_lnk_flg,"Y");
		ComSetObjValue(parentObj.atch_file_lnk_id, atch_file_lnk_id);
	}else{
		ComSetObjValue(parentObj.atch_file_lnk_flg,"");
		ComSetObjValue(parentObj.atch_file_lnk_id, "");
	}
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