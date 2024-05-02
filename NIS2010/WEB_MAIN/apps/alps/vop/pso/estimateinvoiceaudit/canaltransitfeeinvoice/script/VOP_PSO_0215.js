/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0215.js
*@FileTitle : File Download
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.05 진마리아
* 1.0 Creation
* 
* History
* 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가
* 2016.03.14 CHM-201640418 승인 단계에서 파일 첨부 기능 추가
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
     * @class vop_pso_0215 : vop_pso_0215 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_pso_0215() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // ===================================================================================
 // 전역변수 추상함수
 // ===================================================================================
    
 // IBSheet 
 var sheetObjects = new Array();
 var sheetCnt = 0;

 var uploadObjects = new Array();
 var uploadCnt = 0;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 document.onclick = processButtonClick;

 /**
  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
  */
 function processButtonClick() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
 	var srcName = window.event.srcElement.getAttribute("name");
 	
	switch (srcName) {
		case "btn_upload":
//			openUpload("PSO");
			doActionIBSheet(sheetObj, formObj, IBINSERT);
			break;
			
		case "btn_delete":
			doActionIBSheet(sheetObj, formObj, IBDELETE);
			break;
			
		case "btn_save":
			// 변경된 파일정보가 존재하는지 체크한다.
			if (!fnExistsNoSaveAtchFilesBySheet(sheetObj)) {
				ComShowCodeMessage('PSO09014');
				return;
			}
		
			if (!ComShowCodeConfirm('PSO09015')) {
				return;
			}
			doActionIBSheet(sheetObj, formObj, IBSAVE);		
			break;
			
		case "btn_close":			
			// 첨부만 하고 저장하지 않은 파일이 존재하는지 체크한다.
			if (fnExistsNoSaveAtchFiles()) {
				// 저장하지 않은 파일이 존재하는데도, 팝업윈도우를 종료할지를 유저에게 확인후 처리한다.
				if (!ComShowCodeConfirm('PSO09016'))
					return;
			}
			var opener = window.dialogArguments;
			opener.setAtchFileNo(sheetObjects[0].RowCount("R"));
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
  * IBSheet Object를 배열로 등록
  * @param {ibsheet} sheetObj    IBSheet Object  
  **/
 function setSheetObject(sheet_obj){
     sheetObjects[sheetCnt++] = sheet_obj;
 }

 /**
  * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
  * @param {ibupload} uploadObj    IBUpload Object
  **/
 function setUploadObject(uploadObj) {
 	uploadObjects[uploadCnt++] = uploadObj;
 }

 /**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  **/
 function loadPage() {

     var formObj = document.form;
     sheetCnt = sheetObjects.length ;   
     
     //시트 초기화 
     for(var i=0 ; i < sheetCnt ; i++) {
         ComConfigSheet (sheetObjects[i]);
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);              
     }
     
	//UPLOAD 환경 설정
	for (var i = 0; i < uploadObjects.length; i++) {
		//1. 기본 환경 설정
		ComConfigUpload(uploadObjects[i], "/hanjin/VOP_PSO_0215GS.do");

		// 2. Upload 초기화
		// initUpload(uploadObjects[i],i+1);
	}
	uploadObjects[0].AutoConfirm = "UP_OVERWRITE_NO DOWN_OVERWRITE_NO DELETE_NO";
   	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 }

 /**
   * 시트 초기설정값, 헤더 정의
   * @param {ibsheet} sheetObj  sheet
   * @param {int} sheetNo 시트번호
   */
 function initSheet(sheetObj, sheetNo) {
 	var cnt = 0;	
 	with (sheetObj) {
 		switch (sheetObj.id) {
 		case "sheet1": 
             // 높이 설정
 			style.height = 240;
 								
 			//전체 너비 설정
 			SheetWidth = mainTable.clientWidth;

 			//Host정보 설정[필수][HostIp, Port, PagePath]
 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

 			//전체Merge 종류 [선택, Default msNone]
 			MergeSheet = msHeaderOnly;

 			//전체Edit 허용 여부 [선택, Default false]
 			Editable = true;

 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 			InitRowInfo(1, 1, 15, 100);

 			var HeadTitle1 = "|Sel.|File Name|ID|Date|Download|file_path|file_sav_id";
// 			var HeadTitle1 = "|Sel.|Seq.|File Name|ID|Date|Download|file_path|file_sav_id";
 			var headCount = ComCountHeadTitle(HeadTitle1);
 								
 			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 			InitColumnInfo(headCount, 0, 0, true);

 			// 해더에서 처리할 수 있는 각종 기능을 설정한다					
 			InitHeadMode(true, true, true, true, false,false);
 			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 			InitHeadRow(0, HeadTitle1, true);
            
             //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//            InitDataProperty(0, cnt++ , dtStatus,	0,		daCenter,	true,	"ibflag");         
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	"ibflag");         
    		InitDataProperty(0, cnt++ , dtCheckBox, 	40, 	daCenter, true, 	"del_chk", 	false, "", dfNone, 0, true, true);

//            InitDataProperty(0, cnt++ , dtDataSeq,	    40,		daCenter,	true,	"seq");			
 			InitDataProperty(0, cnt++ , dtData,      	320,    daLeft,     false,  "file_upld_nm",	true,		"",		dfNone,		0,	false,		false);
 			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	"upd_usr_id",	false,      "",		dfNone,		0,	false,		false);			
 			InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	"upd_dt",		false,      "",		dfNone,		0,	false,		false);
 			InitDataProperty(0, cnt++ , dtImage,		40,		daCenter,	true,	"file_download",false,      "",		dfNone,		0,	false,		false);
//            InitDataProperty(0, cnt++ , dtData,	    100,		daCenter,	true,	"file_path"	);
//            InitDataProperty(0, cnt++ , dtData,	    100,		daCenter,	true,	"file_sav_id",	false,      "",		dfNone,		0,	false,		false);
            InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,	"file_path"	);
            InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	true,	"file_sav_id",	false,      "",		dfNone,		0,	false,		false);
            
            ImageList(0) = "img/ico_attach.gif";
//            MultiSelection = false;//
            ShowButtonImage = 2;
            break;		
 		}
 	}
 }

 /**
  * 파일 선택하기 <br>
  * @param {ibsheet} sheet    IBSheet Object
  * @param {ibsheet} row     	sheet 선택된 row
  * @param {ibsheet} col     	sheet 선택된 col
  **/
 function sheet1_OnPopupClick(sheet,row,col){

    var fileName = sheet.OpenFileDialog(ComGetMsg("PSO00022","file."));
 	if(fileName.indexOf("\\") !=-1) {
 		sheet.CellValue2(row, "file_path") = fileName;
 		fileName = fileName.substr(fileName.lastIndexOf("\\")+1);
 		sheet.CellValue2(row, "file_upld_nm")= fileName;
 	}
 }

 /**
  * 파일 업로드하기 <br>
  * @param {ibsheet} sheet    IBSheet Object
  * @param {ibsheet} row     	sheet 선택된 row
  * @param {ibsheet} col     	sheet 선택된 col
  * @param {String} 	value     	파일명
  **/
 function sheet1_OnClick(sheet,row,col,value){

	 sheet1_OnDblClick(sheet, row, col);
 }
  
 /**
  * 파일 다운받기 
  * sheet1 doubleClick후 이벤트 
  * @param {ibsheet} sheet 해당 시트   
  * @param {long} row 해당 셀의 Row Index
  * @param {long} col 해당 셀의 Column Index
  */
 function sheet1_OnDblClick(sheet, row, col) {

  	if (sheet.ColSaveName(col) != "file_download" || sheet.RowStatus(row)=="I" || sheet.CellText(row, "file_sav_id") == "") return;
	// 파일이 존재시 다운로드 받는다.
	var file_key = sheet.CellValue(row, "file_sav_id");
	var exist    = fnSaveFileExist(file_key , sheet);
	// 서버에 파일존재유무확인
	if (eval(exist)) {

//		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + file_key;
//		alert("/hanjin/FileDownload?key=" + file_key);
		location.href = "/hanjin/FileDownload?key=" + file_key;
	} else {
		ComShowCodeMessage('PSO09019');		
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
 
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	 for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		 sheetObj.CellValue2(i, "file_download") = "0"; //image 보이기 위해
	 }
 }
 
 /**
  * 마우스 포인터 이동시 발생하는 이벤트 <br>
  * @param {ibsheet} sheet    IBSheet Object
  * @param {ibsheet} Button     	sheet 선택된 Button
  * @param {ibsheet} Shift     	sheet 선택된 Shift
  * @param {int} 	X     		X좌표값
  * @param {int} 	Y     		Y좌표값
  **/
 function sheet1_OnMouseMove(sheet, Button, Shift, X, Y){
 	var row = sheet.MouseRow;
 	var col = sheet.MouseCol;
 	if (row < sheet.HeaderRows || col < 0) {
 		return;
 	}
 	
 	var saveName=sheet.ColSaveName(col);
 	
 	
 	if (saveName!= "file_upld_nm" && saveName!="file_download") {
 		return;
 	}
 	
 	var status = sheet.RowStatus(row);
 		
 	if (saveName=="file_upld_nm") {
 		sheet.MousePointer = (status=="I")?"Hand":"Default";
 	} else if (saveName=="file_download") {
 		sheet.MousePointer = (status=="I")?"Default":"Hand";
 	}

 }

  // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj, formObj, sAction) {
	 sheetObj.ShowDebugMsg = false;
	 sheetObj.WaitImageVisible=false;
     switch(sAction) {

	     case IBSEARCH:      //조회
		     formObj.f_cmd.value = SEARCH;
		     var sXml = sheetObj.GetSearchXml("VOP_PSO_0215GS.do", FormQueryString(formObj));
		     sheetObj.LoadSearchXml(sXml);
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
				sParam += "&" + FormQueryString(formObj);
				// 4. 서버에 request전달하고, reponse 받기
				var sXml = sheetObj.GetSaveXml("VOP_PSO_0215GS.do", sParam);
				if (sXml.length > 0)
					sheetObj.LoadSaveXml(sXml);
			} 
			else {
				//3.Form 데이터 QueryString으로 묶기
				sParam += "&" + FormQueryString(formObj);
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
			
		    formObj.f_cmd.value = SEARCH;
		    var sXml = sheetObj.GetSearchXml("VOP_PSO_0215GS.do", FormQueryString(formObj));
		    sheetObj.LoadSearchXml(sXml);

			ComOpenWait(false);			
			break;
			
		case IBINSERT: // 입력
			selectFile(sheetObj, sheetObj.RowCount, "", true);
			break;
			
		case IBDELETE: // 삭제
			if (sheetObj.FindCheckedRow("del_chk") != "") {
				if (!ComShowCodeConfirm('PSO00020')){  //PSO00020
					return;
				}
				ComRowHideDelete(sheetObj, "del_chk");
				doActionIBSheet(sheetObj, document.form, IBSAVE);
			    formObj.f_cmd.value = SEARCH;
			    var sXml = sheetObj.GetSearchXml("VOP_PSO_0215GS.do", FormQueryString(formObj));
			    sheetObj.LoadSearchXml(sXml);
			    
			} else {
				ComShowCodeMessage('PSO09018');
			}
			break;
     } 
 }

 
 /**
  * 파일 선택하기 <br>
  * @param {ibsheet} sheetObj    IBSheet Object
  * @param {ibsheet} addRowFlag  sheetObj에 Row추가 여부
  **/

 function selectFile(sheetObj, Row, Col, _insert) {
 	
 	var formObj = document.form;
 	
 	if (Col == "" || sheetObj.ColSaveName(Col) == 'file_upld_nm') {
 		
 		var fileName = sheetObj.OpenFileDialog("");
 		
 		// 파일대화상자에서 선택한 파일이 없을 경우 종료
 		if (fileName.indexOf("USER_CANCEL") != -1) {
 			return;
 		}

 		// 행이 없는 경우..
 		if ((sheetObj.HeaderRows - Row) == 0 || _insert) {
 			Row = sheetObj.DataInsert(-1, 0);// File Add인 경우 New Row 생성
 		}		

 		if (fileName.indexOf("\\") != -1) {
 			sheetObj.CellValue2(Row, "file_path") = fileName;
 			fileName = fileName.substr(fileName.lastIndexOf("\\") + 1);
 			sheetObj.CellValue2(Row, "file_upld_nm") = fileName;
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
 		uploadObjects[0].AddFile(sheetObj.CellValue(arrRow[idx], "file_path"));
 	}
 }

// /**
//  * 용량계산하기  <br>
//  * @param {String} 	_val 		파일용량
//  * @param {String} 	r_value    	MB/KB계산 
//  **/
// function getSize(_val) {
//
// 	var r_value = _val;
// 	var _value = Math.round(_val / 1024);
//
// 	if (_value > 0) {
// 		r_value = _value;
// 		_value = Math.round(_value / 1024);
// 		if (_value > 0) {
// 			_value = _value + " MB"
// 		} else {
// 			_value = r_value + " KB"
// 		}
// 	} else {
// 		_value = r_value + " Bytes"
// 	}
// 	return _value;
// }
 
 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj, formObj, sAction) { 
 	// 저장시 유효성검사 
 	if (sAction == IBSAVE) {
 		if (sheetObj.LastRow == 0) {
 			ComShowCodeMessage('PSO09017');
 			return false;
 		}
 	}
 	return true;
 }
	/* 개발자 작업  끝 */