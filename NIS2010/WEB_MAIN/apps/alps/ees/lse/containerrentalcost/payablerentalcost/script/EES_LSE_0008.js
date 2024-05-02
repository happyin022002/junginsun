/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0008.js
*@FileTitle : Invoice File Import
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.10 노정용
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
     * @class EES_LSE_0008 : EES_LSE_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0008() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

	/* 개발자 작업 */

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	//파일업로드를 사용하기 위한
	var uploadObjects = new Array();
	var uploadCnt = 0;

	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq  = "";
	var fileUploadFlag = false;

	var fileSaveFlag = false;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_New":
					ComResetAll();
					break;

				case "btn_Close":
					window.close();
					if ( fileSaveFlag ) {
						var opener = window.dialogArguments;
						var func   = "opener."+ComGetObjValue(formObj.func)+"();";
						eval(func);
					}
					break;

				case "btn_Save":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;

				case "btn_FileAdd":
					doActionIBSheet(sheetObject1, formObj, IBINSERT);
					break;

				case "btn_FileDel":
					doActionIBSheet(sheetObject1, formObj, IBDELETE);
					break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
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
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj){
		uploadObjects[uploadCnt++] = uploadObj;
	}

	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files = "";
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for ( var i = 0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		for (var ii=0; ii < 9 ; ii++){ 
			sheetObjects[0].DataInsert(-1);
		}
 		sheetObjects[0].SelectCell(1, 0);

		ComConfigUpload(uploadObjects[0], "/hanjin/LSE_INTGS.do");
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {

		var cnt = 0;

		switch(sheetObj.id) {
			//파일 업로드
		    case "sheet1" :
				with(sheetObj) {
					// 높이 설정
					style.height = 242;

					// 전체 너비 설정
					SheetWidth = mainTable3.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 13, 100);

					var HeadTitle1 = "|Sel.|Seq.|Lessor File Name|Local File Path|Upload File Name|AGMT NO.|AGMT NO.|Contract No.|Save Result";

					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	"chkbox");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	false,	"Seq");
					InitDataProperty(0, cnt++ , dtPopup,		150,	daLeft,		false,	"org_file_nm",		true,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		200,	daCenter,	false,	"org_file_path",	true,	"",	dfNone,	0,	false,	true);
					InitDataProperty(0, cnt++ , dtHidden,		150,	daCenter,	false,	"upload_file_nm",	true,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"agmt_cty_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"agmt_seq",			false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,	"lse_ctrt_no",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			500,	daLeft,		false,	"save_result",		false,	"",	dfNone,	0,	false,	false);

					CountPosition = 0;

					DataInsert();
				}

				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {

		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					var sRow = sheetObj.FindCheckedRow("chkbox");
					//if (sRow == "") {
					//	ComShowCodeMessage("COM12189");
					//	return 0;
					//}

					//가져온 행을 배열로 만들기
					var arrRow = sRow.split("|"); //결과 : "1|3|5|"

					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var vCoCostYrmon = ComGetObjValue(formObj.co_cost_yrmon);

					for ( var i = 0 ; i < arrRow.length-1 ; i++ ) {
						var sParam = "f_cmd="+COMMAND01;
						sParam = sParam + "&co_cost_yrmon=" + vCoCostYrmon;
						sParam = sParam + "&upload_file_nm=" + sheetObj.CellValue(arrRow[i], "upload_file_nm");

						var sXml = sheetObj.GetSaveXml("EES_LSE_0008GS.do" , sParam);

						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							sheetObj.CellValue2(arrRow[i], "save_result") = ComGetEtcData(sXml,"result");
							sheetObj.CellValue2(arrRow[i], "agmt_cty_cd") = ComGetEtcData(sXml,"agmt_no").substr(0, 3);
							sheetObj.CellValue2(arrRow[i], "agmt_seq")    = ComGetEtcData(sXml,"agmt_no").substr(3);
							sheetObj.CellValue2(arrRow[i], "lse_ctrt_no") = ComGetEtcData(sXml,"ctrt_no");
							sheetObj.CellValue2(arrRow[i], "chkbox")    = "N";
							fileSaveFlag = true;
						} else if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "F" ) {
							sheetObj.CellValue2(arrRow[i], "save_result") = "System not available. Plz, contact system manager.";
							sheetObj.CellValue2(arrRow[i], "chkbox")    = "N";
						}
					}
					ComOpenWait(false);
					sheetObj.WaitImageVisible = true;
				}

				break;

			case IBDELETE:
					var sRow = sheetObj.FindCheckedRow("chkbox");
					if (sRow == "") {
						ComShowCodeMessage("COM12189");
						return 0;
					}

					//가져온 행을 배열로 만들기
					var arrRow = sRow.split("|"); //결과 : "1|3|5|"
					for ( var i = arrRow.length-2 ; i >= 0 ; i-- ) {
						sheetObj.RowDelete(arrRow[i], false);
					}
				break;

			case IBINSERT:      // 입력
				//if ( sheetObj.RowCount < 10 ) {
					var row = sheetObj.DataInsert(-1);
				//} else {
				//	ComShowCodeMessage("LSE01103");
				//}
				break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSAVE:
				var sRow = sheetObj.FindCheckedRow("chkbox");
				//ComDebug(sRow);
				if (sRow == "") {
					ComShowCodeMessage("COM12189");
					return false;
				}

				//가져온 행을 배열로 만들기
				var arrRow = sRow.split("|"); //결과 : "1|3|5|"

				for ( var i = 0 ; i < arrRow.length-1 ; i++ ) {
					if ( sheetObj.CellValue(arrRow[i], "upload_file_nm") == "" ) {
						ComShowCodeMessage("LSE01133");
						sheetObj.SelectCell(arrRow[i], "upload_file_nm");
						return false;
					}
				}
				break;
		}

		return true;
	}


	/**
	 * 파일 선택하기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 **/
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;

		switch (colName) {
			case "org_file_nm":
				if ( fileUploadFlag ) {
		    		return;
		    	}

		    	var upObj = uploadObjects[0];
			    var fileName = sheetObj.OpenFileDialog("Payable Invoice File","","","Text|*.txt");
			 	//var fileName = sheetObj.OpenFileDialog("", "", "", "Excel|*.xls|Excel|*.XLS|Text|*.txt|Text|*.TXT");
			 	var relativePath = "";
			 	var fileType     = "";
				var badFile = false;

				if ( fileName.indexOf("\\") == -1 ) {
					badFile = true;
				} else {
					relativePath = fileName.substr(fileName.lastIndexOf("\\") + 1);         // File Name
					fileType     = relativePath.substr(relativePath.lastIndexOf(".") + 1);  // File Type

					//TXT, XLS
					if ( fileType.toUpperCase() != "TXT" && fileType.toUpperCase() != "CSV" ) {
						badFile = true;
					}
				}

			 	if ( !badFile ) {
			 		ComOpenWait(true);
			 		fileUploadFlag = true;

			 		sheetObj.CellValue2(Row, "org_file_nm")   = relativePath;
			 		sheetObj.CellValue2(Row, "org_file_path") = fileName;

			 		// 기존파일을 모두 지운후 추가함
			 		upObj.Files = "";
			 		var ret  = upObj.AddFile(fileName);
					var sXml1 = upObj.DoUpload(true);
					uploadFileName = ComGetEtcData(sXml1,"filename");
					sheetObj.CellValue2(Row, "upload_file_nm") = uploadFileName;

					fileUploadFlag = false;
					ComOpenWait(false);

				 	if ( sheetObj.CellValue(Row, "upload_file_nm") != "" ) {
				 		sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var vCoCostYrmon = ComGetObjValue(formObj.co_cost_yrmon);
						var sParam = "f_cmd="+COMMAND01;
						sParam = sParam + "&co_cost_yrmon=" + vCoCostYrmon;
						sParam = sParam + "&upload_file_nm=" + sheetObj.CellValue(Row, "upload_file_nm");
						var sXml = sheetObj.GetSaveXml("EES_LSE_0008GS.do" , sParam);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							sheetObj.CellValue2(Row, "save_result") = ComGetEtcData(sXml,"result");
							sheetObj.CellValue2(Row, "agmt_cty_cd") = ComGetEtcData(sXml,"agmt_no").substr(0, 3);
							sheetObj.CellValue2(Row, "agmt_seq")    = ComGetEtcData(sXml,"agmt_no").substr(3);
							sheetObj.CellValue2(Row, "lse_ctrt_no") = ComGetEtcData(sXml,"ctrt_no");
							sheetObj.CellValue2(Row, "chkbox")    = "N";
							fileSaveFlag = true;
						} else if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "F" ) {
							sheetObj.CellValue2(Row, "save_result") = "System not available. Plz, contact system manager.";
							sheetObj.CellValue2(Row, "chkbox")    = "N";
						}

						ComOpenWait(false);
						sheetObj.WaitImageVisible = true;
				 	} else {
				 		sheetObj.CellValue2(Row, "save_result") = "Fail to upload File.";
				 	}
			 	} else {
			 		if ( fileName != "<USER_CANCEL>" ) {
			 			ComShowCodeMessage("LSE01097");
			 		}
				}

			 	break;
		}
	}

	function sheet1_OnDblClick(sheetObj, Row, Col) {
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(Col);

		switch (colName) {
			case "agmt_cty_cd":
			case "agmt_seq":
			case "lse_ctrt_no":
				if ( sheetObj.CellValue(Row, "agmt_cty_cd") != ""
				  && sheetObj.CellValue(Row, "agmt_seq")    != ""
				  && sheetObj.CellValue(Row, "lse_ctrt_no") != "" ) {
					var url = "/hanjin/EES_LSE_0098.do";
					url = url + "?agmt_cty_cd="   + sheetObj.CellValue(Row, "agmt_cty_cd");
					url = url + "&agmt_seq="      + sheetObj.CellValue(Row, "agmt_seq");
					url = url + "&lse_ctrt_no="   + sheetObj.CellValue(Row, "lse_ctrt_no");
					url = url + "&co_cost_yrmon=" + ComGetObjValue(formObj.co_cost_yrmon);
					ComOpenPopup(url, 855, 450, '', '1,0', true);
				}

				break;
		}
	}

	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;
		//doActionIBSheet(sheetObj, formObj, IBINSERT);
	}
	/* 개발자 작업  끝 */