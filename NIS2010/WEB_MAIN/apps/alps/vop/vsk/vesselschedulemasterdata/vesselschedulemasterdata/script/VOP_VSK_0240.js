/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0240.js
*@FileTitle : Service Provider Group Registration (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.08.24 서창열
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
     * @class VOP_VSK_0240 : VOP_VSK_0240 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0240() {
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

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;


	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
//		var sheetObject4 = sheetObjects[3];
  
		/*******************************************************/
		var formObject = document.form;

		try {
     		var srcName = window.event.srcElement.getAttribute("name");

     		switch(srcName) {

	     		case "btn_retrieve":
	     			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
	     			break;
	 					
	     		case "btn_add":
	     			appendSelectRowByVendor(sheetObject1);
	     			break;
	 					
				case "btn_del":
					removeSelectRowByVendor(sheetObject1);
					break;	
					
				case "btn_new":
					clearAllData(sheetObject3);
					break;		
					
				case "btn_save":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;																	
				
				case "btn_close":
					window.close();
					break;
				
				case "btn_rAdd":
					setAddLaneDir(sheetObject2, sheetObject2.SelectRow);
					break;
					
				case "btn_rDel":
					setDelLaneDir(sheetObject3, sheetObject3.SelectRow);
					break;
					
//				case "btn_test":
//					var testXml = ComMakeSearchXml(sheetObject3, true, "", "", false);
//					alert(testXml);
//					break;
 				

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj = document.form;
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
		var prefix = sheetID + "_";

		switch(sheetNo) {
			case 1:      // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 100;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//InitHeadMode(false, false, true, true, false,false);
					InitHeadMode(false, true, true, true, false,false);

					var HeadTitle1 = " |Sel.|Service Provider Code|Service Provider Name";


					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ ROW, COL,  	DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, CALCULOGIC, 	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter, 	false, 		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	false,		prefix+"sel",				false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	200,	daCenter,	true,		prefix+"vndr_seq",			false,		"",			dfNone,			0,			false,		true , 6);
					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,		prefix+"vndr_lgl_eng_nm",	false,		"",			dfNone,			0,			false,		false);

					InitDataValid(0, prefix+"vndr_seq", vtNumericOnly);

					ShowButtonImage = 1;  
					ShowMsgMode = false;
					WaitImageVisible = false;
				}
				break;

			case 2:      // sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 290;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(10, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false)

					var HeadTitle1 = "|Lane\nCode|Lane Name|||||||";


					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, 	COL,  	DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, 		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,  	daCenter, 		false, 		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix+"vsl_slan_cd",		false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		  	false,		prefix+"vsl_slan_nm",		false,		"",			dfNone,			0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	  	false,		prefix+"north_dir",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	  	false,		prefix+"south_dir",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		false,		prefix+"bound1",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		false,		prefix+"bound2",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	  	false,		prefix+"cnl_agn_vndr_seq",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	  	false,		prefix+"vndr_seq",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++,  dtCheckBox,     0,  	daCenter,  		false,   	"hiddencheck");

					ColHidden("hiddencheck") = true;
					
					WaitImageVisible = false;
				}
				break;     

			case 3:      // sheet3 init
				with (sheetObj) {
					// 높이 설정
					style.height = 290;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false);

					var HeadTitle1 = "|Lane\nCode|Lane Name|North\nBound|South\nBound|DIR_SEQ1|DIR_SEQ2||||||";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  					KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,  	daCenter, 	false, 		prefix+"ibflag");
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,		prefix+"vsl_slan_cd",		false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,			230,	daLeft,		false,		prefix+"vsl_slan_nm",		false,		"",			dfNone,			0,			false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,		prefix+"north_dir_cb",		false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,		prefix+"south_dir_cb",		false,		"",			dfNone,			0,			true,		true);
					
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		prefix+"north_dir",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		prefix+"south_dir",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		prefix+"bound1",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		prefix+"bound2",			false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	false,		prefix+"cnl_agn_vndr_seq",	false,		"",			dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			0,		daCenter,	  	false,		prefix+"vndr_seq",			false,		"",			dfNone,			0,			true,		true);

					InitDataProperty(0, cnt++,  dtCheckBox,     0,  	daCenter,  	false,   	"hiddencheck");

//					InitDataCombo(0, prefix+"bound_seq1", "W|E|N|S", "W|E|N|S");
//					InitDataCombo(0, prefix+"bound_seq2", "W|E|N|S", "W|E|N|S");

					ColHidden("hiddencheck") = true;

					InitComboNoMatchText(true);
					WaitImageVisible = false;
				}
				break;
	    }
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:		//조회
				formObj.f_cmd.value = SEARCH;
				
				var arrPrefix = new Array("sheet1_", "sheet2_", "sheet3_");
				var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix);

				for(var i=0; i<sheetObjects.length; i++){
					sheetObjects[i].WaitImageVisible = false;
				}
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("VOP_VSK_0240GS.do", sParam);
				ComOpenWait(false);
				
				showSheetData(sheetObj, formObj, sXml);
				break;

			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = MULTI;
					var arrPrefix = new Array("sheet1_", "sheet2_", "sheet3_");

//					var vndrSeq = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vndr_seq");
					var sParam = ComGetSaveString(sheetObjects);
					if (sParam == "") return;
					sParam = sParam + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix);
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("VOP_VSK_0240GS.do", sParam);
					ComOpenWait(false);
					
//					if(sXml.length>0) sheetObj.LoadSearchXml(sXml);
					
					sheetObj.LoadSaveXml(sXml);
					
					//SAVE OK 일 경우 저장된 내용 다시 조회.
					var nodeText = VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
					if(nodeText == "OK"){
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}

//					setSaveAfter(sheetObjects[2],formObj,vndrSeq);

					sheetObj.ShowButtonImage = 0;
				}
				/*
				else{
				setRevokHiddenGrid();
				}
				*/
				break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSAVE:
				
//				for(var i=1; i<= sheetObjects[3].RowCount; i++){
//					if(sheetObjects[3].CellValue(i,"sheet4_serviceFlg") == "I" || sheetObjects[3].CellValue(i,"sheet4_serviceFlg") == "U"){
//						if(sheetObjects[3].CellValue(i,"sheet4_laneFlg") == "I" || sheetObjects[3].CellValue(i,"sheet4_laneFlg") == "U"){
//
	//						if(ComIsNull(sheetObjects[3].CellValue(i,"sheet4_bound_seq1"))){
	//							ComShowCodeMessage('VSK00027');
	//							sheetObjects[2].SelectCell(i,"sheet3_bound_seq1",true);
	//							return false;
	//						}
//
	//						if(ComIsNull(sheetObjects[3].CellValue(i,"sheet4_bound_seq2"))){
	//							ComShowCodeMessage('VSK00027');
	//							sheetObjects[2].SelectCell(i,"sheet3_bound_seq2",true);
	//							return false;
	//						}
	//					}
	//				}
	//			}
		
			break;
		}
		return true;
	}
 
	/**
	 * 조회 후 처리로직.
	 * 
	 * @param sheetObj	sheetObjects[0]
	 * @param formObj
	 * @param sXml
	 * @return
	 */
	function showSheetData(sheetObj, formObj, sXmlArr){
		var arrXml = sXmlArr.split("|$$|");
		var vndrSeq = "";

		for(var i=0; i<arrXml.length; i++){
			var curSheetObj = sheetObjects[i];
			var sXml = arrXml[i];
			
			var prefix = curSheetObj.id + "_";
			
			curSheetObj.Redraw = false;
			curSheetObj.LoadSearchXml(sXml);
			curSheetObj.Redraw = true;
			
			if(prefix == "sheet1_"){
				vndrSeq = curSheetObj.CellValue(curSheetObj.HeaderRows, prefix+"vndr_seq");
			}else if(prefix == "sheet2_"){
				var curRow = sheetObj.SelectRow;
				if(VskIsNull(curRow)) curRow = sheetObj.HeaderRows;
				setLaneInfoByVendorSheet2(sheetObj, curRow);
				initIbFlag(curSheetObj);

//				curSheetObj.ColumnSort(prefix+"vsl_slan_cd", "ASC");
			}else if(prefix == "sheet3_"){
				var curRow = sheetObj.SelectRow;
				if(VskIsNull(curRow)) curRow = sheetObj.HeaderRows;
				setLaneInfoByVendor(sheetObj, curRow);
				setDirectionByVendor(curSheetObj, sXml);
				initIbFlag(curSheetObj);
			}
		}
		showCountFormat(sheetObjects[2], sheetObjects[2].SelectRow);
		showCountFormatSheet2(sheetObjects[1], sheetObjects[1].SelectRow);

		
		//All Check 초기화
		sheetObj.CheckAll(sheetObj.id+"_sel") = 0;
	} 
	
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var headCnt = sheetObj.HeaderRows;
		if(NewRow >= headCnt && NewCol > 0){
			setLaneInfoByVendor(sheetObj, NewRow);
			setLaneInfoByVendorSheet2(sheetObj, NewRow);
			showCountFormat(sheetObjects[2], sheetObjects[2].SelectRow);
			showCountFormatSheet2(sheetObjects[1], sheetObjects[1].SelectRow);
		}
	}

//	function sheet1_OnDblClick(sheetObj, Row, Col) {
////		var formObj = document.form;
//		var rowCnt = sheetObj.RowCount;
//		var prefix = sheetObj.id + "_";
//
//		if(rowCnt > 0){
//			if(Col >= 2){
////				var vndrSeq = sheetObj.CellValue(Row, prefix+"vndr_seq");
////				if(VskIsNotNull(vndrSeq)){
////					sheetObjects[2].RemoveAll();
////					getHiddenGrid(sheetObj,formObj,vndrSeq,Row);
//					setLaneInfoByVendor(sheetObj, Row);
////				}
//			}
//		}
//	}

	function sheet1_OnPopupClick(sheetObj, Row, Col){
		var rowCnt = sheetObj.RowCount;
		var formObj = document.form;
		
		if(rowCnt > 0){
			var url = "/hanjin/COM_ENS_0C1.do";
			var rtnFunName = "getLaneCdHelp";
			ComOpenPopup(url, 700, 480, rtnFunName, '0,0,1', false, false, Row, Col, 0);
		}
	}
	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		var sXml = null;
		
		if(Row >= headCnt && Col > 0){
			var colName = sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"vndr_seq"){
				var vndrSeq = ComLpad(sheetObj.CellValue(Row, Col), 6, "0");
				for(var i=headCnt; i<=totCnt; i++){
					if(vndrSeq == sheetObj.CellValue(i, prefix+"vndr_seq")){
						ComShowCodeMessage("VSK00002", vndrSeq);
						sheetObj.CellValue2(Row, Col) = "";
						sheetObj.SelectCell(Row, Col, true);
						return;
					}
				}
				
				if(vndrSeq == "000000"){
					sheetObj.CellValue2(Row, prefix+"vndr_seq") = "";
					sheetObj.CellValue2(Row, prefix+"vndr_lgl_eng_nm") = "";
				}else{
					formObj.f_cmd.value = SEARCH02;
					
					formObj.vndr_seq.value = vndrSeq;
					
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0240GS.do", FormQueryString(formObj));
					var etcVndrSeq = ComGetEtcData(sXml, "vndr_seq");
					var etcVndrNm = ComGetEtcData(sXml, "vndr_nm");
					
					if(VskIsNull(etcVndrSeq) || VskIsNull(etcVndrNm)){
						ComShowCodeMessage("VSK00065", vndrSeq);
						sheetObj.CellValue2(Row, Col) = "";
						sheetObj.SelectCell(Row, Col, true);
						return;
					}
					
					sheetObj.CellValue2(Row, prefix+"vndr_seq") = etcVndrSeq;
					sheetObj.CellValue2(Row, prefix+"vndr_lgl_eng_nm") = etcVndrNm;
				}
			}
		}
	}

	function sheet2_OnDblClick(sheetObj, Row, Col) {
		setAddLaneDir(sheetObj, Row);
	}
	
	function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var headCnt = sheetObj.HeaderRows;
		
		if(NewRow >= headCnt && NewCol > 0){
			showCountFormat(sheetObj, NewRow);
		}
	}

	function sheet3_OnDblClick(sheetObj, Row, Col) {
		if(sheetObj.RowCount > 0){
			if(Col <= 2){
				setDelLaneDir(sheetObj, Row);
			}
		}
	}
	
	function sheet3_OnComboChange(sheetObj, Row, Col, Code, Text) {
		if(Row >= sheetObj.HeaderRows){
			var prefix = sheetObj.id + "_";
			var sDirCd = sheetObj.CellValue(Row, prefix+"bound1") + "|" + sheetObj.CellValue(Row, prefix+"bound2");
			var arrDirCd = sDirCd.split("|");
			
			if(sheetObj.ColSaveName(Col) == prefix+"north_dir_cb"){
				sheetObj.CellValue2(Row, prefix+"north_dir") = Code;
				for(var i=0; i<arrDirCd.length; i++){
					if(Code != arrDirCd[i]){
						sheetObj.CellValue2(Row, prefix+"south_dir_cb") = arrDirCd[i];
						sheetObj.CellValue2(Row, prefix+"south_dir") = arrDirCd[i];
						break;
					}
				}
			}else if(sheetObj.ColSaveName(Col) == prefix+"south_dir_cb"){
				sheetObj.CellValue2(Row, prefix+"south_dir") = Code;
				for(var i=0; i<arrDirCd.length; i++){
					if(Text != arrDirCd[i]){
						sheetObj.CellValue2(Row, prefix+"north_dir_cb") = arrDirCd[i];
						sheetObj.CellValue2(Row, prefix+"north_dir") = arrDirCd[i];
						break;
					}
				}
			}
		}
	}
	
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
	
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerForm("focus", "obj_focus", formObj);
	}
     
	function obj_focus() {
		if(event.srcElement.options){
			event.srcElement.focus();
		}else{
			event.srcElement.select();
		}
	}

	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */

	
	/**
	 * sheet1 의 Popup close 후 실행.
	 * 
	 * @param rtnObjs
	 * @param Row
	 * @param Col
	 * @param sheetIdx
	 * @return
	 */
	function getLaneCdHelp(rtnObjs, Row, Col, sheetIdx){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var prefix = sheetObj.id + "_";
		
		if(rtnObjs){
			var rtnDatas = rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					sheetObj.CellValue2(Row, prefix+"vndr_seq") = rtnDatas[2];
					sheetObj.CellValue2(Row, prefix+"vndr_lgl_eng_nm") = rtnDatas[4];
				}
			}
		}

//		var newVndrSeq = Number(sheetObj.CellValue(Row, prefix+"vndr_seq"));
//		var dupCnt = 0;
//		for(var i=1; i<=sheetObject.RowCount; i++){
//			if(newVndrSeq == Number(sheetObject.CellValue(i, prefix+"vndr_seq"))){
//				dupCnt++;
//			}
//		}
//
//		if(dupCnt > 1){
//			ComShowCodeMessage("VSK00002",newVndrSeq);
//			sheetObject.CellValue(row,col) = "";
//			sheetObject.CellValue(row,"sheet1_vndr_lgl_eng_nm") = "";
//			sheetObject.SelectCell(Row,Col, true);
//			return;
//		}
//
//		//COM_ENS_0C1 공통 ServiceProvider 팝업 오픈 후  
//		//ServiceProvider에 속하지 않은 공통 코드 그리만 sheet2만 조회한다
//		if(sheetObject.CellValue(row,"sheet1_ibflag") == "I"){
//			//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH,"B",newVndrSeq);
//			sheetObjects[2].RemoveAll();
//		}
	}
	
	/*
	 * =====================================================================
	 * Etc Function
	 * =====================================================================
	 */
	
	/**
	 * 선택한 Vendor 의 Lane 정보를 목록을 찾아서 보여 줍니다.
	 * 
	 * @param sheetObj sheetObjects[0]
	 * @param Row
	 * @return
	 */
	function setLaneInfoByVendor(sheetObj, Row){
		var vndrSeq = sheetObj.CellValue(Row, sheetObj.id+"_vndr_seq");
		if(VskIsNull(vndrSeq)) vndrSeq = "";
		
		var vndrSheetObj = sheetObjects[2];
		var prefix = vndrSheetObj.id + "_";
		var headCnt = vndrSheetObj.HeaderRows;
		var totCnt = vndrSheetObj.LastRow;
		
		vndrSheetObj.Redraw = false;
		for(var i=headCnt; i<=totCnt; i++){
			if(VskIsNotNull(vndrSeq) && vndrSheetObj.CellValue(i, prefix+"cnl_agn_vndr_seq") == vndrSeq){
				vndrSheetObj.RowHidden(i) = false;
			}else{
				vndrSheetObj.RowHidden(i) = true;
			}
		}
		vndrSheetObj.Redraw = true;
			
	}
	
	/**
	 * 선택한 Vendor 의 Lane 정보를 목록을 찾아서 보여 줍니다.
	 * 
	 * @param sheetObj sheetObjects[0]
	 * @param Row
	 * @return
	 */
	function setLaneInfoByVendorSheet2(sheetObj, Row){
		var vndrSeq = sheetObj.CellValue(Row, sheetObj.id+"_vndr_seq");
		if(VskIsNull(vndrSeq)) vndrSeq = "";
		
		var vndrSheetObj = sheetObjects[1];
		var prefix = vndrSheetObj.id + "_";
		var headCnt = vndrSheetObj.HeaderRows;
		var totCnt = vndrSheetObj.LastRow;
		
		vndrSheetObj.Redraw = false;
		for(var i=headCnt; i<=totCnt; i++){
			if(VskIsNotNull(vndrSeq) && vndrSheetObj.CellValue(i, prefix+"cnl_agn_vndr_seq") == "" && vndrSheetObj.CellValue(i, prefix+"vndr_seq") == vndrSeq){
				vndrSheetObj.RowHidden(i) = false;
			}else{
				vndrSheetObj.RowHidden(i) = true;
			}
		}
		vndrSheetObj.Redraw = true;
			
	}

	/**
	 * 하단 좌측의 Lane 목록에서 선택한 Lane 을 하단 우측의 Vandor Lane 목록에 추가한다.
	 * 
	 * @param sheetObj sheetObjects[1]
	 * @param Row
	 * @return
	 */
	function setAddLaneDir(sheetObj, Row){
		// Vendor Sheet
		var vndrSheetObj = sheetObjects[0];
		var vndrSeq = vndrSheetObj.CellValue(vndrSheetObj.SelectRow, vndrSheetObj.id+"_vndr_seq");
		
		if(VskIsNull(vndrSeq)){
			ComShowCodeMessage("VSK00106");
			return;
		}

		// Vendor 가 기 선택한 Lane 목록 Sheet
		var targetSheetObj = sheetObjects[2];
		var targetPrefix = targetSheetObj.id + "_";
		var targetHeadCnt = targetSheetObj.HeaderRows;
		var beforeRowPos = targetSheetObj.LastRow;

		// Vendor 가 미 선택한 Lane 목록 Sheet
		var prefix = sheetObj.id + "_";
		var selRowStr = sheetObj.GetSelectionRows("/");
		if(selRowStr === "0" || selRowStr === "") return;
		var selRowArr = selRowStr.split("/");
		
		var laneCdArr = new Array();
//		var ibFlagArr = new Array();
		
		for (var i=0; i<selRowArr.length; i++) {
//			var vRow = parseInt(selRowArr[i]);
			var laneCd = sheetObj.CellValue(selRowArr[i], prefix+"vsl_slan_cd");
			var cnlVndrSeq = sheetObj.CellValue(selRowArr[i], prefix+"cnl_agn_vndr_seq");
			
			if(targetSheetObj.RowCount > 0){
				for(var j=targetHeadCnt; j<=beforeRowPos; j++){
					// 기존에 추가되어 있는 Lane은 목록에서 삭제한다.
					if(targetSheetObj.CellValue(j, targetPrefix+"vsl_slan_cd") == laneCd){
						targetSheetObj.RowHidden(j) = false;
						appendComboItemBySheet(targetSheetObj, j);
						sheetObj.RowDelete(selRowArr[i], false);
//						targetSheetObj.RowDelete(j, false);
						break;
					}
					sheetObj.CellValue2(selRowArr[i], "hiddencheck") = "Y";
					laneCdArr[i] = laneCd;

				}
			}else{
				
				sheetObj.CellValue2(selRowArr[i], "hiddencheck") = "Y";
				laneCdArr[i] = laneCd;
			}
//			ibFlagArr[i] = sheetObj.CellValue(parseInt(selRowArr[i]), prefix+"ibflag");
		}

		//ComOpenWait(true);
		var saveColName = "sheet2_vsl_slan_cd|sheet2_vsl_slan_nm|sheet2_north_dir|sheet2_south_dir|sheet2_bound1|sheet2_bound2|sheet2_cnl_agn_vndr_seq";
		var sXml = ComMakeSearchXml(sheetObj, false, "hiddencheck", saveColName, true);
//		sheetObj.ColumnSort(prefix+"lane_cd", "ASC");
		targetSheetObj.LoadSearchXml(sXml.replace(/sheet2_/gi, targetPrefix), true);
		var targetTotCnt = targetSheetObj.LastRow;

		for(var i=0; i<laneCdArr.length; i++){
			for(var j=targetHeadCnt; j<=targetTotCnt; j++){
				if(laneCdArr[i] == targetSheetObj.CellValue(j, targetPrefix+"vsl_slan_cd")){
					targetSheetObj.CellValue2(j, targetPrefix+"cnl_agn_vndr_seq") = vndrSeq;
					
					appendComboItemBySheet(targetSheetObj, j);
					
					
//					var dirSeq1 = targetSheetObj.CellValue(j, targetPrefix+"dir_seq1");
//					var dirSeq2 = targetSheetObj.CellValue(j, targetPrefix+"dir_seq2");
//					var dirCds = dirSeq1 + "|" + dirSeq2;
//						 
//					targetSheetObj.CellComboItem(j, targetPrefix+"bound_seq1", dirCds, dirCds, 0);
//					targetSheetObj.CellComboItem(j, targetPrefix+"bound_seq2", dirCds, dirCds, 0);
//						
//					targetSheetObj.CellValue(j, targetPrefix+"bound_seq1") = dirSeq1;
//					targetSheetObj.CellValue(j, targetPrefix+"bound_seq2") = dirSeq2;
//
//					if(ibFlagArr[i] == "U"){
//						targetSheetObj.CellValue(j, targetPrefix+"ibflag") = "I";
//						targetSheetObj.CellValue(j, targetPrefix+"vndr_seq") = vndrSeq;
//					}else if(ibFlagArr[i] == "D"){
//						targetSheetObj.CellValue(j, targetPrefix+"ibflag") = "R";
//					}
////					targetSheetObj.CellEditable(j, targetPrefix+"lane_cd") = false;
////					targetSheetObj.CellEditable(j, targetPrefix+"lane_nm") = false;
//					
					break;
				}
			}
		}
		
		var newCurRow = 0;
//		var newCurRow = getNewCurRow(targetSheetObj);
		showCountFormat(targetSheetObj, newCurRow);

		// HiddenGrid에서 해당하는 Lane Cd를 선택한 Service Code로 셋팅한다
//		var hdnSheetObj = sheetObjects[3];
//		var hdnPrefix = hdnSheetObj.id + "_";
//		var headCnt = hdnSheetObj.HeaderRows;
//		var rowCnt =  hdnSheetObj.RowCount;
//		var totalCnt = hdnSheetObj.LastRow;
//
//		var vendorIbflag = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_ibflag");
//		var cnt = 0;
//
//		for(var i=0; i<laneCdArr.length; i++){
//			for(var j=headCnt; j<=totalCnt; j++){
//				if(vendorIbflag == "R"){
//					if(laneCdArr[i] == hdnSheetObj.CellValue(j, hdnPrefix+"lane_cd")){
//						if(ibFlagArr[i] == "U"){
//							hdnSheetObj.CellValue(j, hdnPrefix+"serviceFlg") = "U";
//							hdnSheetObj.CellValue(j, hdnPrefix+"laneFlg") = "I";
//							hdnSheetObj.CellValue(j, hdnPrefix+"vndr_seq") = vndrSeq;
//							hdnSheetObj.CellValue(j, hdnPrefix+"bound_seq1") = hdnSheetObj.CellValue(j, hdnPrefix+"dir_seq1");
//							hdnSheetObj.CellValue(j, hdnPrefix+"bound_seq2") = hdnSheetObj.CellValue(j, hdnPrefix+"dir_seq2");
//						}else if(ibFlagArr[i] == "D"){
//							hdnSheetObj.CellValue(j, hdnPrefix+"serviceFlg") = "R";
//							hdnSheetObj.CellValue(j, hdnPrefix+"laneFlg") = "R";
//							hdnSheetObj.CellValue(j, hdnPrefix+"vndr_seq") = vndrSeq;
//						}
//					}
//				}else if(vendorIbflag == "I"){
//					if(laneCdArr[i] == hdnSheetObj.CellValue(j, hdnPrefix+"lane_cd")){
//						if(ibFlagArr[i] == "U"){
//							hdnSheetObj.CellValue(j, hdnPrefix+"serviceFlg") = "I";
//							hdnSheetObj.CellValue(j, hdnPrefix+"laneFlg") = "I";
//							hdnSheetObj.CellValue(j, hdnPrefix+"vndr_seq") = vndrSeq;
//							hdnSheetObj.CellValue(j, hdnPrefix+"bound_seq1") = hdnSheetObj.CellValue(j, hdnPrefix+"dir_seq1");
//							hdnSheetObj.CellValue(j, hdnPrefix+"bound_seq2") = hdnSheetObj.CellValue(j, hdnPrefix+"dir_seq2");
//						}else if(ibFlagArr[i] == "D"){
//							hdnSheetObj.CellValue(j, hdnPrefix+"serviceFlg") = "I";
//							hdnSheetObj.CellValue(j, hdnPrefix+"laneFlg") = "I";
//							hdnSheetObj.CellValue(j, hdnPrefix+"vndr_seq") = vndrSeq;
//							hdnSheetObj.CellValue(j, hdnPrefix+"bound_seq1") = "";
//							hdnSheetObj.CellValue(j, hdnPrefix+"bound_seq2") = "";
//						}
//					}
//				}
//			}
//		}
	}

	/**
	 * 하단 우측의 Vandor Lane 목록에서 선택한 Lane 을 제거(Hidden)하고 하단 좌측의 Lane 목록에 추가한다.
	 * 
	 * @param sheetObj sheetObjects[2]
	 * @param Row
	 * @return
	 */
	function setDelLaneDir(sheetObj, Row){
		// Vendor Sheet
		var vndrSheetObj = sheetObjects[0];
		var vndrSeq = vndrSheetObj.CellValue(vndrSheetObj.SelectRow, vndrSheetObj.id+"_vndr_seq");
		//선텍된 Vendor 정보
		var cnlVndrSeq = sheetObj.CellValue(sheetObj.SelectRow, sheetObj.id+"_cnl_agn_vndr_seq"); 
		// Vendor 가 미 선택한 Lane 목록 Sheet
		var targetSheetObj = sheetObjects[1];
		var targetPrefix = targetSheetObj.id + "_";
		var targetHeadCnt = targetSheetObj.HeaderRows;
		var beforeRowPos = targetSheetObj.LastRow;

		// Vendor 가 기 선택한 Lane 목록 Sheet
		var prefix = sheetObj.id + "_";
		var selRowStr = sheetObj.GetSelectionRows("/");
		if(selRowStr === "0" || selRowStr === "") return;
		var selRowArr = selRowStr.split("/");
		
		var laneCdArr = new Array();
		var selLnae = sheetObj.CellValue(sheetObj.SelectRow, prefix+"vsl_slan_cd");
		
		for (var i=0; i<selRowArr.length; i++) {
			if(sheetObj.CellValue(selRowArr[i], prefix+"cnl_agn_vndr_seq") == vndrSeq && sheetObj.RowHidden(selRowArr[i]) == false){
				laneCdArr[i] = sheetObj.CellValue(selRowArr[i], prefix+"vsl_slan_cd");
				sheetObj.CellValue2(selRowArr[i], "hiddencheck") = "Y";
				
				//해당 Vendor가 다중 Lane 으로 등록되었는지 확인
				if(sheetObj.CellValue(selRowArr[i], prefix+"vsl_slan_cd") == selLnae && sheetObj.CellValue(selRowArr[i], prefix+"_cnl_agn_vndr_seq") == cnlVndrSeq){ 
					removeLaneInfoByVendor(sheetObj, selRowArr[i]);
				}else{
					sheetObj.CellValue2(Row, prefix+"cnl_agn_vndr_seq") = "";
					sheetObj.RowHidden(Row) = true;
				}
//				sheetObj.CellValue(selRowArr[i], prefix+"vndr_seq") = "";
//				sheetObj.CellValue(selRowArr[i], prefix+"vndr_flg") = "N";
//				sheetObj.CellValue(selRowArr[i], prefix+"bound_seq1") = "";
//				sheetObj.CellValue(selRowArr[i], prefix+"bound_seq2") = "";
////				sheetObj.CellComboItem(selRowArr[i], prefix+"bound_seq1", "", "", 0);
////				sheetObj.CellComboItem(selRowArr[i], prefix+"bound_seq2", "", "", 0);
//				sheetObj.RowHidden(selRowArr[i]) = true;
			}
		}
		
//		targetSheetObj.Redraw = false;
		var saveColName = "sheet3_vsl_slan_cd|sheet3_vsl_slan_nm|sheet3_north_dir|sheet3_south_dir|sheet3_bound1|sheet3_bound2|sheet3_cnl_agn_vndr_seq";
		var sXml = ComMakeSearchXml(sheetObj, false, "hiddencheck", saveColName, false);
		targetSheetObj.LoadSearchXml(sXml.replace(/sheet3_/gi, "sheet2_"), true);
		var targetTotCnt = targetSheetObj.LastRow;
		// 미 선택 목록에 추가한 Lane 정보 초기화.
		for(var j=beforeRowPos; j<=targetTotCnt; j++){
			if(targetSheetObj.CellValue(j, targetPrefix+"vndr_seq") == cnlVndrSeq){
				targetSheetObj.CellValue2(j, targetPrefix+"cnl_agn_vndr_seq") = "";
//				targetSheetObj.CellValue2(j, targetPrefix+"vndr_flg") = "N";
				targetSheetObj.CellValue2(j, targetPrefix+"north_dir") = "";
				targetSheetObj.CellValue2(j, targetPrefix+"south_dir") = "";
			}
		}
		targetSheetObj.ColumnSort(targetPrefix+"vsl_slan_cd", "ASC");
//		targetSheetObj.Redraw = true;
		
		//All Check 초기화
//		sheetObj.CheckAll2("hiddencheck") = 0;
			
		for (var i=0; i<selRowArr.length; i++) {
			sheetObj.CellValue2(selRowArr[i], "hiddencheck") = "N";
		}
		
		var newCurRow = 0;
//		var newCurRow = getNewCurRow(sheetObj);
		showCountFormat(sheetObj, newCurRow);
		
//		var sRowStr= "";
//		var sXml = "";
//		var keyVals = new Array();
//		var ibFlagVals = new Array();
////		if(sheetObjects[2].RowCount==0) return;
////		sRowStr= sheetObjects[2].GetSelectionRows("/");
//
//		//ComOpenWait(true);
//		//자바 스크립트 배열로 만들기
//		var arr = sRowStr.split("/");
//		for (i=0; i<arr.length; i++) {
//			sheetObjects[2].CellValue2(parseInt(arr[i]), "hiddencheck") = "Y";
//			keyVals[i] = sheetObjects[2].CellValue(parseInt(arr[i]), "sheet3_lane_cd");
//			ibFlagVals[i] = sheetObjects[2].CellValue(parseInt(arr[i]), "sheet3_ibflag");
//		}
//		  
//		sXml=ComMakeSearchXml(sheetObjects[2], false, "hiddencheck","sheet3_lane_cd|sheet3_lane_nm|sheet3_vndr_seq|sheet3_dir_seq1|sheet3_dir_seq2|sheet3_vndr_flg|sheet3_bound_seq1|sheet3_bound_seq2", true)
//		sheetObjects[2].ColumnSort("sheet3_lane_cd", "ASC");
//		sheetObjects[1].LoadSearchXml(sXml.replace(/sheet3_/gi,"sheet2_"), true);
//		sheetObjects[1].ColumnSort("sheet2_lane_cd", "ASC");
//		  
//		for(var k=0; k<keyVals.length; k++){
//			var tempVal = keyVals[k];
//			var flagVal = ibFlagVals[k];
//			for(var j=1;j<=sheetObjects[1].RowCount; j++){
//				if(tempVal == sheetObjects[1].CellValue(j,1)){
//					sheetObjects[1].CellValue(j,"sheet2_bound_seq1") = "";
//					sheetObjects[1].CellValue(j,"sheet2_bound_seq2") = "";
//					
//					if(flagVal == "I"){
//						sheetObjects[1].CellValue(j,"sheet2_ibflag") = "R";
//					}else if(flagVal == "R" || flagVal == ""){
//						sheetObjects[1].CellValue(j,"sheet2_ibflag") = "D";
//					}else if(flagVal == "U"){
//						sheetObjects[1].CellValue(j,"sheet2_ibflag") = "D";
//					}
//				}
//			}
//		}
//
//		//HiddenGrid에서 해당하는 Lane Cd를 를 선택한 Service Code로 셋팅한다
//		var prefix4 = "sheet4_";
//		var prefix3 = "sheet3_";
//		var headCnt = sheetObjects[3].HeaderRows;
//		var rowCnt =  sheetObjects[3].RowCount;
//		var totalCnt = headCnt+rowCnt;
//		var vndrSeq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"sheet1_vndr_seq");
//
//		var vendorIbflag = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"sheet1_ibflag");
//		var cnt = 0;
//
//		for(var k=0; k<keyVals.length; k++){
//			var tempLaneCd = keyVals[k];
//			var flagVal = ibFlagVals[k];
//		//alert("del : vendorIbflag : "+vendorIbflag);  	                	
//		//alert("del : flagVal : "+flagVal);
//			for(var i=headCnt; i<totalCnt; i++){
//				if(vendorIbflag == "R"){
//					if(tempLaneCd == sheetObjects[3].CellValue(i,prefix4+"lane_cd")){
//						if(flagVal == "I"){
//							sheetObjects[3].CellValue(i,prefix4+"serviceFlg") = "R";
//							sheetObjects[3].CellValue(i,prefix4+"laneFlg") = "R";
//							sheetObjects[3].CellValue(i,prefix4+"vndr_seq") = "";
//						}else{
//							sheetObjects[3].CellValue(i,prefix4+"serviceFlg") = "U";
//							sheetObjects[3].CellValue(i,prefix4+"laneFlg") = "D";
//							sheetObjects[3].CellValue(i,prefix4+"vndr_seq") = "";
//						}
//					}
//				}else if(vendorIbflag == "I"){
//					if(tempLaneCd == sheetObjects[3].CellValue(i,prefix4+"lane_cd")){
//						if(flagVal == "I"){
//							sheetObjects[3].CellValue(i,prefix4+"serviceFlg") = "R";
//							sheetObjects[3].CellValue(i,prefix4+"laneFlg") = "R";
//							sheetObjects[3].CellValue(i,prefix4+"vndr_seq") = "";
//						}else{
//							sheetObjects[3].CellValue(i,prefix4+"serviceFlg") = "U";
//							sheetObjects[3].CellValue(i,prefix4+"laneFlg") = "D";
//							sheetObjects[3].CellValue(i,prefix4+"vndr_seq") = "";
//						}
//					}
//
//				}
//			}
//		}
	}

	
	/**
	 * Vendor 가 선택한 Lane정보 Sheet의 Direction 목록을 정의
	 * 
	 * @param sheetObj sheetObjects[2]
	 * @param sXml
	 * @return
	 */
	function setDirectionByVendor(sheetObj, sXml){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		
		for(var i=headCnt; i<=totCnt; i++){
//			if(laneCdArr[i] == targetSheetObj.CellValue(j, targetPrefix+"lane_cd")){
			appendComboItemBySheet(sheetObj, i);

//				if(ibFlagArr[i] == "U"){
//					targetSheetObj.CellValue(j, targetPrefix+"ibflag") = "I";
//					targetSheetObj.CellValue(j, targetPrefix+"vndr_seq") = vndrSeq;
//				}else if(ibFlagArr[i] == "D"){
//					targetSheetObj.CellValue(j, targetPrefix+"ibflag") = "R";
//				}
//				targetSheetObj.CellEditable(j, targetPrefix+"lane_cd") = false;
//				targetSheetObj.CellEditable(j, targetPrefix+"lane_nm") = false;
				
//				break;
//			}
		}
	}

	/**
	 * Vendor 가 선택한 Lane정보 Sheet의 Direction 을 정의
	 * 
	 * @param sheetObj sheetObjects[2]
	 * @param Row
	 * @return
	 */
	function appendComboItemBySheet(sheetObj, Row){
		var prefix = sheetObj.id + "_";
		
		var bound1 = sheetObj.CellValue(Row, prefix+"bound1");
		var bound2 = sheetObj.CellValue(Row, prefix+"bound2");
		var dirCds = bound1 + "|" + bound2;
			 
		sheetObj.CellComboItem(Row, prefix+"north_dir_cb", dirCds, dirCds, 0);
		sheetObj.CellComboItem(Row, prefix+"south_dir_cb", dirCds, dirCds, 0);
		
		var northDir = bound1;
		var southDir = bound2;
		if(VskIsNotNull(sheetObj.CellValue(Row, prefix+"north_dir"))){
			northDir = sheetObj.CellValue(Row, prefix+"north_dir");
		}else{
			sheetObj.CellValue2(Row, prefix+"north_dir") = northDir;
		}
		if(VskIsNotNull(sheetObj.CellValue(Row, prefix+"south_dir"))){
			southDir = sheetObj.CellValue(Row, prefix+"south_dir");
		}else{
			sheetObj.CellValue2(Row, prefix+"south_dir") = southDir;
		}

		sheetObj.CellValue2(Row, prefix+"north_dir_cb") = northDir;
		sheetObj.CellValue2(Row, prefix+"south_dir_cb") = southDir;
	}
	
	/**
	 * Vendor 추가
	 * 
	 * @param sheetObj sheetObjects[0]
	 * @return
	 */
	function appendSelectRowByVendor(sheetObj){
		var prefix = sheetObj.id + "_";
		
		sheetObj.DataInsert(-1);
		sheetObj.SelectCell(sheetObj.LastRow, prefix+"vndr_seq");
		showCountFormat(sheetObjects[2]);
	}
	
	/**
	 * Vendor 목록에 선택한 Vendor 를 삭제.
	 * 
	 * @param sheetObj sheetObjects[0]
	 * @return
	 */
	function removeSelectRowByVendor(sheetObj){
		var prefix = sheetObj.id + "_";
//		var rowIdx = sheetObj.SelectRow + sheetObj.HeaderRows;
//		var vndrSeq = sheetObj.CellValue(sheetObj.SelectRow, prefix+"vndr_seq");
		var arrVndrSeq = new Array();
		var strSel = sheetObj.FindCheckedRow(prefix+"sel");		//삭제할 Vendor 가 여러건 일 수 있으므로 해당 Vendor를 모두 찾아온다.
		if(strSel == "") ComShowCodeMessage("COM12189");
		var arrSel = strSel.split("|"); //가져온 행을 배열로 만들기 ( 결과 : "1|3|5| )"
		if(arrSel != null && arrSel != undefined && arrSel.length > 0){
			for(var i=0; i<arrSel.length-1; i++){
				arrVndrSeq[i] = sheetObj.CellValue(arrSel[i], prefix+"vndr_seq");
			}
		}
		//선택된 Vendor 정보
		var selVndr = sheetObj.CellValue(sheetObj.SelectRow, prefix+"vndr_seq");
		
		if(arrVndrSeq != null && arrVndrSeq != undefined && arrVndrSeq.length > 0){
//			ComShowCodeMessage("VSK00005");
			
			if(ComRowHideDelete(sheetObj, prefix+"sel") > 0){
			
				var vndrSheetObj = sheetObjects[2];
				var vndrPrefix = vndrSheetObj.id + "_";
				var vndrHeadCnt = vndrSheetObj.HeaderRows;
				var vndrTotCnt = vndrSheetObj.LastRow;
				
				// Vendor 가 미 선택한 Lane 목록 Sheet
				var targetSheetObj = sheetObjects[1];
				var targetPrefix = targetSheetObj.id + "_";
				var targetHeadCnt = targetSheetObj.HeaderRows;
				var beforeRowPos = targetSheetObj.LastRow;
				
				//삭제되는 Lane 정보 저장
				var arrLane = new Array(); 
				for(var i=vndrHeadCnt; i<=vndrTotCnt; i++){
					if(vndrSheetObj.CellValue(i, vndrPrefix+"cnl_agn_vndr_seq") == selVndr){
						arrLane[i] = vndrSheetObj.CellValue(i, vndrPrefix+"vsl_slan_cd");
					}
				}
				
				//다중으로 등록된 Lane Count
				var multiCnt = 0; 
				for(var i=vndrHeadCnt; i<=vndrTotCnt; i++){
					for(var j=0; j<=arrLane.length; j++){
						if(vndrSheetObj.CellValue(i, vndrPrefix+"vsl_slan_cd") == arrLane[j] && vndrSheetObj.CellValue(i, vndrPrefix+"cnl_agn_vndr_seq") != selVndr){
								multiCnt++;
						}
					}
				}
				
				for(var i=vndrHeadCnt; i<=vndrTotCnt; i++){
					for(var j=arrVndrSeq.length-1; j>=0; j--){
						if(arrVndrSeq[j] == vndrSheetObj.CellValue(i, vndrPrefix+"cnl_agn_vndr_seq")){
							vndrSheetObj.CellValue2(i, "hiddencheck") = "Y";
							//Lane이 다중으로 등록되어있는지 확인
							if(multiCnt==0){
								removeLaneInfoByVendor(vndrSheetObj, i);
							}else{
								vndrSheetObj.CellValue2(i, vndrPrefix+"cnl_agn_vndr_seq") = "";
								vndrSheetObj.RowHidden(i) = true;
							}
		//					vndrSheetObj.CellValue(i, vndrPrefix+"vndr_seq") = "";
		//					vndrSheetObj.CellValue(i, vndrPrefix+"vndr_flg") = "N";
		//					vndrSheetObj.CellValue(i, vndrPrefix+"bound_seq1") = "";
		//					vndrSheetObj.CellValue(i, vndrPrefix+"bound_seq2") = "";
						}
					}
				}
				

				
				targetSheetObj.Redraw = false;
				var saveColName = "sheet3_vsl_slan_cd|sheet3_vsl_slan_nm|sheet3_north_dir|sheet3_south_dir|sheet3_bound1|sheet3_bound2|sheet3_cnl_agn_vndr_seq";
				var sXml = ComMakeSearchXml(vndrSheetObj, false, "hiddencheck", saveColName, false);
				targetSheetObj.LoadSearchXml(sXml.replace(/sheet3_/gi,"sheet2_"), true);
				var targetTotCnt = targetSheetObj.LastRow;
				
				// 미 선택 목록에 추가한 Lane 정보 초기화.
				for(var j=beforeRowPos; j<=targetTotCnt; j++){
					targetSheetObj.CellValue2(j, targetPrefix+"cnl_agn_vndr_seq") = "";
//					targetSheetObj.CellValue2(j, targetPrefix+"vndr_flg") = "N";
					targetSheetObj.CellValue2(j, targetPrefix+"north_dir") = "";
					targetSheetObj.CellValue2(j, targetPrefix+"south_dir") = "";
				}
				targetSheetObj.ColumnSort(targetPrefix+"vsl_slan_cd", "ASC");
				targetSheetObj.Redraw = true;
				
				sheetObj.SelectCell(sheetObj.LastRow, prefix+"vndr_seq");
				showCountFormat(sheetObjects[2]);
			}
		}
	}
	
	/**
	 * Vendor의 Lane 목록에서 해당 Row를 삭제(Hidden)하고 값을 초기화.
	 * 
	 * @param sheetObj
	 * @param Row
	 * @return
	 */
	function removeLaneInfoByVendor(sheetObj, Row){
		var prefix = sheetObj.id + "_";
		
		sheetObj.CellValue2(Row, prefix+"cnl_agn_vndr_seq") = "";
//		sheetObj.CellValue2(Row, prefix+"vndr_flg") = "N";
		sheetObj.CellValue2(Row, prefix+"north_dir") = "";
		sheetObj.CellValue2(Row, prefix+"south_dir") = "";
//		sheetObj.CellComboItem(selRowArr[i], prefix+"bound_seq1", "", "", 0);
//		sheetObj.CellComboItem(selRowArr[i], prefix+"bound_seq2", "", "", 0);
		
		sheetObj.RowHidden(Row) = true;
	}
	
	/**
	 * 조회된 Data 들의 ibflag 를 'R' 로 Setting.
	 * 
	 * @param sheetObj
	 * @return
	 */
	function initIbFlag(sheetObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		
		if(sheetObj.RowCount > headCnt){
			for(var i=headCnt; i<=totCnt; i++){
//				sheetObj.CellValue2(i, prefix+"ibflag") = "R";
				sheetObj.RowStatus(i) = "R";
			}
		}
	}
	
	/**
	 * 해당 Sheet 의 CountFormat 을 설정한다.
	 * Hidden 값 제외한 RowCount 를 계산.
	 * 
	 * @param sheetObj sheetObjects[2]
	 * @param Row
	 * @return
	 */
	function showCountFormat(sheetObj, Row){
		var vndrSheetObj = sheetObjects[0];
		var vndrSeq = vndrSheetObj.CellValue(vndrSheetObj.SelectRow, vndrSheetObj.id+"_vndr_seq");
		
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		var curTotCnt = 0;		// 선택한 Vendor 의 Lane 수(Hidden 값 제외)
		var curRowIdx = 0;		// 해당 Vendor 의 선택한 Lane 의 RowCount (화면상의 RowCount).
		var firstRow = 0;		// 해당 Vendor 의 첫번째 Lane 의 RowCount (실제 Sheet 의 RowCount).
		
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"cnl_agn_vndr_seq") == vndrSeq && sheetObj.RowHidden(i) == false){
				curTotCnt++;
				
				if(i == Row){
					curRowIdx = curTotCnt;
				}
				if(curTotCnt == 1){
					firstRow = i;
				}
			}
		}
		
		if(curRowIdx == 0 && firstRow > 0){
			curRowIdx = 1;
			sheetObj.SelectCell(firstRow, prefix+"vsl_slan_cd");
		}
		
		var sCountFormat = "["+curRowIdx+" / "+curTotCnt+"]";
		sheetObj.CountFormat = sCountFormat;
	}
	
	/**
	 * 해당 Sheet 의 CountFormat 을 설정한다.
	 * Hidden 값 제외한 RowCount 를 계산.
	 * 
	 * @param sheetObj sheetObjects[2]
	 * @param Row
	 * @return
	 */
	function showCountFormatSheet2(sheetObj, Row){
		var vndrSheetObj = sheetObjects[0];
		var vndrSeq = vndrSheetObj.CellValue(vndrSheetObj.SelectRow, vndrSheetObj.id+"_vndr_seq");
		
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		var curTotCnt = 0;		// 선택한 Vendor 의 Lane 수(Hidden 값 제외)
		var curRowIdx = 0;		// 해당 Vendor 의 선택한 Lane 의 RowCount (화면상의 RowCount).
		var firstRow = 0;		// 해당 Vendor 의 첫번째 Lane 의 RowCount (실제 Sheet 의 RowCount).
		
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObjects[1].CellValue(i, prefix+"vndr_seq") == vndrSeq && sheetObjects[1].RowHidden(i) == false){
				curTotCnt++;
				
				if(i == Row){
					curRowIdx = curTotCnt;
				}
				if(curTotCnt == 1){
					firstRow = i;
				}
			}
		}
		
		if(curRowIdx == 0 && firstRow > 0){
			curRowIdx = 1;
			sheetObjects[1].SelectCell(firstRow, prefix+"vsl_slan_cd");
		}
		
		var sCountFormat = "["+curRowIdx+" / "+curTotCnt+"]";
		sheetObjects[1].CountFormat = sCountFormat;
	}

	/**
	 * Direction 그리드를 초기화 한다.
	 * 
	 * @param sheetObj
	 * @return
	 */
	function clearAllData(sheetObj){
//		sheetObj.SelectRow(3);
//		var selRowStr = sheetObj.GetSelectionRows("/");
//		alert(selRowStr);
//		setDelLaneDir(sheetObj, sheetObj.SelectRow);
		
		var vndrSheetObj = sheetObjects[0];
		var vndrSeq = vndrSheetObj.CellValue(vndrSheetObj.SelectRow, vndrSheetObj.id+"_vndr_seq");
		
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var totCnt = sheetObj.LastRow;
		
		sheetObj.Redraw = false;
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.CellValue(i, prefix+"cnl_agn_vndr_seq") == vndrSeq && sheetObj.RowHidden(i) == false){
				setDelLaneDir(sheetObj, i);
			}
		}
		sheetObj.Redraw = true;
		
//		var sRowStr= "";
//		var sXml = "";
//		var keyVals = new Array();
//		var ibFlagVals = new Array();
//		
//		if(sheetObj3.RowCount == 0) return;
//
//		for(var i=1; i<=sheetObj3.RowCount; i++){
//			sRowStr = sRowStr+(i+"/");
//		}	
//		var arr = sRowStr.split("/");
//
//		for (i=0; i<arr.length -1; i++) {
//			sheetObj3.CellValue2(parseInt(arr[i]), "hiddencheck") = "Y";
//			keyVals[i] = sheetObj3.CellValue(parseInt(arr[i]), "sheet3_lane_cd");
//			ibFlagVals[i] = sheetObj3.CellValue(parseInt(arr[i]), "sheet3_ibflag");
//		}
//
//		sXml=ComMakeSearchXml(sheetObj3, false, "hiddencheck","sheet3_lane_cd|sheet3_lane_nm|sheet3_vndr_seq|sheet3_dir_seq1|sheet3_dir_seq2|sheet3_vndr_flg|sheet3_bound_seq1|sheet3_bound_seq2", true)
//		sheetObj3.ColumnSort("sheet3_lane_cd", "ASC");
//		sheetObj2.LoadSearchXml(sXml.replace(/sheet3_/gi,"sheet2_"), true);
//		sheetObj2.ColumnSort("sheet2_lane_cd", "ASC");
//
//		for(var k=0; k<keyVals.length; k++){
//			var tempVal = keyVals[k];
//			var flagVal = ibFlagVals[k];
//			for(var j=1;j<=sheetObj2.RowCount; j++){
//				if(tempVal == sheetObj2.CellValue(j,1)){
//					sheetObj2.CellValue(j,"sheet2_bound_seq1") = "";
//					sheetObj2.CellValue(j,"sheet2_bound_seq2") = "";
//
//					if(flagVal == "I"){
//						sheetObj2.CellValue(j,"sheet2_ibflag") = "R";
//					}else if(flagVal == "R" || flagVal == ""){
//						sheetObj2.CellValue(j,"sheet2_ibflag") = "D";
//					}else if(flagVal == "U"){
//						sheetObj2.CellValue(j,"sheet2_ibflag") = "D";
//					}
//				}
//			}
//		}
//
//		var prefix4 = "sheet4_";
//		var prefix3 = "sheet3_";
//		var headCnt = sheetObjects[3].HeaderRows;
//		var rowCnt =  sheetObjects[3].RowCount;
//		var totalCnt = headCnt+rowCnt;
//		var vendorIbflag = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"sheet1_ibflag");
//		var vndrSeq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"sheet1_vndr_seq");
//		var cnt = 0;
//
//		for(var k=0; k<keyVals.length; k++){
//			var tempVal = keyVals[k];
//
//			for(var i=headCnt; i<totalCnt; i++){
//				if(vendorIbflag == "R"){
//					if(tempVal == sheetObjects[3].CellValue(i,prefix4+"lane_cd")){
//						cnt++;
//						sheetObjects[3].CellValue(i,prefix4+"serviceFlg") = "U";
//						sheetObjects[3].CellValue(i,prefix4+"laneFlg") = "D";
//						sheetObjects[3].CellValue(i,prefix4+"vndr_seq") = "";
//					}
//				}else if(vendorIbflag == "I"){
//					if(tempVal == sheetObjects[3].CellValue(i,prefix4+"lane_cd")){
//						cnt++;
//						sheetObjects[3].CellValue(i,prefix4+"serviceFlg") = "R";
//						sheetObjects[3].CellValue(i,prefix4+"laneFlg") = "R";
//						sheetObjects[3].CellValue(i,prefix4+"vndr_seq") = "";
//					}
//				}
//			}
//		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
     

//
//	//ServiceProvider 입력을 사용하자 KeyIn으로 입력 후
//	// 해당 Code에 대한 Name과 체크를 한다
//	//ServiceProvider에 속하지 않은 공통 코드 그리드 sheet2 재 조회한다
//	function sheet1_OnAfterEdit(sheetObj,Row,Col) {
//		var prefix = sheetObj.id + "_";
//		var cnt = sheetObj.RowCount + sheetObj.HeaderRows;
//		var formObj = document.form;
//		var vndrSeq = "";
//
//		if(Row > 0){
//			if(Col == 2){
//				var newVndrSeq = Number(sheetObj.EditValue);
//
//				var headRow = sheetObj.HeaderRows;
//				var rowCnt = sheetObj.RowCount;
//				var totCnt = headRow+rowCnt-1;
//
//				var dupCnt = 0;
//				for(var i=headRow; i<=totCnt; i++){
	//				if(newVndrSeq == Number(sheetObj.CellValue(i,"sheet1_vndr_seq"))){
	//					dupCnt++;
	//				}
	//			}
//
	//			if(dupCnt > 1){
	//				ComShowCodeMessage("VSK00002",newVndrSeq);
	//				sheetObj.CellValue(Row,Col) = "";
	//				sheetObj.CellValue(Row,"sheet1_vndr_lgl_eng_nm") = "";
	//				sheetObj.SelectCell(Row,Col, true);
	//				return;
	//			}
//
	//			if(sheetObj.CellValue(Row,"sheet1_ibflag") == "I"){
	//				if(sheetObj.CellValue(Row,Col) != ""){
	//					formObj.f_cmd.value = SEARCH02;
	//					formObj.vndr_seq.value = sheetObj.CellValue(Row,Col); 
	//					formObj.eventNav.value = "";
	//					var sXml = sheetObj.GetSearchXml("VOP_VSK_0240GS.do", FormQueryString(formObj));
	//					var vndr_seq = ComGetEtcData(sXml, "vndr_seq");
	//					var vndr_nm = ComGetEtcData(sXml, "vndr_nm");
	//
	//					if( vndr_nm == "" || vndr_nm == undefined ){
	//						ComShowCodeMessage('VSK00065',formObj.vndr_seq.value);
	//						sheetObj.CellValue(Row,Col) = "";
	//						sheetObj.CellValue(Row,Col+1) = "";
	//						sheetObj.SelectCell( Row , Col-1 , true);
	//						return;
	//					}
	//					sheetObj.CellValue(Row,Col) = vndr_seq;
	//					sheetObj.CellValue(Row,Col+1) = vndr_nm;
	//					sheetObjects[2].RemoveAll(); 
	//					//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH,"B",vndr_seq);
//					}
//				}
//			}
//		}
//	}
//
// 
//
//	function doSaveAfter(sheetObj,formObj,vendSeq){
//		var headCnt = sheetObj.HeaderRows;
//		var rowCnt = sheetObj.RowCount;
//		var totCnt = headCnt+rowCnt-1;
//		
//		for(var i=headCnt; i<=totCnt; i++){
//			if(Number(sheetObj.CellValue(i,sheetObj.id+"_vend_seq")) == Number(vendSeq)){
//				sheetObj.SelectCell(i,sheetObj.id+"_vend_seq",true);
//			}
//		}
//	}
//
//	function getHiddenGrid(sheetObj,formObj,vndrSeq,Row){
//		var prefix4 = "sheet4_";
//		var prefix3 = "sheet3_";
//		var headCnt = sheetObjects[3].HeaderRows;
//		var rowCnt =  sheetObjects[3].RowCount;
//		var totalCnt = headCnt+rowCnt;
//		var vendorIbflag = sheetObjects[0].CellValue(Row,"sheet1_ibflag");
//		
//		var cnt = 0;
//		for(var i=headCnt; i<totalCnt; i++){
//			if(Number(vndrSeq) == Number(sheetObjects[3].CellValue(i,prefix4+"vndr_seq"))){
//				if(sheetObjects[3].CellValue(i,prefix4+"laneFlg") != "D"){
//					sheetObjects[2].DataInsert(-1);
//					cnt ++;
//					sheetObjects[2].CellValue(cnt,prefix3+"vndr_seq") = sheetObjects[3].CellValue(i,prefix4+"vndr_seq");
//					sheetObjects[2].CellValue(cnt,prefix3+"lane_cd") = sheetObjects[3].CellValue(i,prefix4+"lane_cd");
//					sheetObjects[2].CellValue(cnt,prefix3+"lane_nm") = sheetObjects[3].CellValue(i,prefix4+"lane_nm");
//					sheetObjects[2].CellValue(cnt,prefix3+"dir_seq1") = sheetObjects[3].CellValue(i,prefix4+"dir_seq1");
//					sheetObjects[2].CellValue(cnt,prefix3+"dir_seq2") = sheetObjects[3].CellValue(i,prefix4+"dir_seq2");
//					
//					var dirSeq1 = sheetObjects[3].CellValue(i,prefix4+"dir_seq1");
//					var dirSeq2 = sheetObjects[3].CellValue(i,prefix4+"dir_seq2");
//					var dirCds = dirSeq1+'|'+dirSeq2;
//					
//					var boundSeq1 = sheetObjects[3].CellValue(i,prefix4+"bound_seq1");
//					var boundSeq2 = sheetObjects[3].CellValue(i,prefix4+"bound_seq2");
//					
//					sheetObjects[2].CellComboItem(cnt, prefix3+"bound_seq1", dirCds,dirCds,0);
//					sheetObjects[2].CellComboItem(cnt, prefix3+"bound_seq2", dirCds,dirCds,0);
//					
//					sheetObjects[2].CellValue(cnt,"sheet3_bound_seq1") = boundSeq1;
//					sheetObjects[2].CellValue(cnt,"sheet3_bound_seq2") = boundSeq2;
//					
//					sheetObjects[2].CellEditable(cnt, "sheet3_lane_cd") = false;
//					sheetObjects[2].CellEditable(cnt, "sheet3_lane_nm") = false;
//					
//					sheetObjects[2].CellValue(cnt,prefix3+"ibflag") = sheetObjects[3].CellValue(i,prefix4+"laneFlg");
//				}
//			}
//		}
//		
//		sheetObjects[3].ColumnSort("sheet4_lane_cd", "ASC");
//	}
//
//	function setRevokHiddenGrid(){
//		sheetObjects[2].RemoveAll();
//		var vndrPos = 0;
//
//		for(var i=1; i<= sheetObjects[3].RowCount; i++){
//			if(sheetObjects[3].CellValue(i,"sheet4_serviceFlg") != "R" && sheetObjects[3].CellValue(i,"sheet4_laneFlg") != "R"){
//				if(ComIsNull(sheetObjects[3].CellValue(i,"sheet4_bound_seq1")) || ComIsNull(sheetObjects[3].CellValue(i,"sheet4_bound_seq2"))){
//					vndrPos = i;
//				}
//			}
//		}
//
//		var prefix4 = "sheet4_";
//		var prefix3 = "sheet3_";
//		var vndrSeq = sheetObjects[3].CellValue(vndrPos,"sheet4_vndr_seq");
//		var cnt = 0;
//		for(var i=1; i<= sheetObjects[3].RowCount; i++){
//			if(vndrSeq == sheetObjects[3].CellValue(i,"sheet4_vndr_seq")){
//				sheetObjects[2].DataInsert(-1);
//				cnt ++;
//				sheetObjects[2].CellValue(cnt,prefix3+"vndr_seq") = sheetObjects[3].CellValue(i,prefix4+"vndr_seq");
//				sheetObjects[2].CellValue(cnt,prefix3+"lane_cd") = sheetObjects[3].CellValue(i,prefix4+"lane_cd");
//				sheetObjects[2].CellValue(cnt,prefix3+"lane_nm") = sheetObjects[3].CellValue(i,prefix4+"lane_nm");
//				sheetObjects[2].CellValue(cnt,prefix3+"dir_seq1") = sheetObjects[3].CellValue(i,prefix4+"dir_seq1");
//				sheetObjects[2].CellValue(cnt,prefix3+"dir_seq2") = sheetObjects[3].CellValue(i,prefix4+"dir_seq2");
//
//				var dirSeq1 = sheetObjects[3].CellValue(i,prefix4+"dir_seq1");
//				var dirSeq2 = sheetObjects[3].CellValue(i,prefix4+"dir_seq2");
//				var dirCds = dirSeq1+'|'+dirSeq2;
//
//				var boundSeq1 = sheetObjects[3].CellValue(i,prefix4+"bound_seq1");
//				var boundSeq2 = sheetObjects[3].CellValue(i,prefix4+"bound_seq2");
//
//				sheetObjects[2].CellComboItem(cnt, prefix3+"bound_seq1", dirCds,dirCds,0);
//				sheetObjects[2].CellComboItem(cnt, prefix3+"bound_seq2", dirCds,dirCds,0);
//
//				sheetObjects[2].CellValue(cnt,"sheet3_bound_seq1") = boundSeq1;
//				sheetObjects[2].CellValue(cnt,"sheet3_bound_seq2") = boundSeq2;
//
//				sheetObjects[2].CellEditable(cnt, "sheet3_lane_cd") = false;
//				sheetObjects[2].CellEditable(cnt, "sheet3_lane_nm") = false;
//
//				sheetObjects[2].CellValue(cnt,prefix3+"ibflag") = sheetObjects[3].CellValue(i,prefix4+"laneFlg");
//			}
//		}
//		sheetObjects[2].SelectRow = vndrPos;
//
//		for(var k=1; k<sheetObjects[3].RowCount; k++){
//			if(Number(vndrSeq) == Number(sheetObjects[0].CellValue(k,"sheet1_vndr_seq"))){
//				sheetObjects[0].SelectRow = k;
//			}
//		}
//	}
//	/**
//	 * 선택한 Vendor 의 Lane 목록을 Setting.(저장 후 호출)
//	 * 
//	 * @param sheetObj
//	 * @param formObj
//	 * @param vndrSeq
//	 * @return
//	 */
//	function setSaveAfter(sheetObj, formObj, vndrSeq){
//		var targetSheetObj = sheetObjects[2];
//		
//		var prefix = sheetObj.id+"_";
//		var targetPrefix = targetSheetObj.id+"_";
//		
//		var headCnt = sheetObj.HeaderRows;
//		var rowCnt =  sheetObj.RowCount;
//		var totCnt = sheetObj.LastRow;
//		
//		targetSheetObj.Redraw = false;
//		targetSheetObj.RemoveAll();
//		var cnt = 0;
//		for(var i=headCnt; i<=totCnt; i++){
//			if(vndrSeq == sheetObj.CellValue(i,prefix+"vndr_seq")){
//				targetSheetObj.DataInsert(-1);
//				cnt ++;
//				
//				targetSheetObj.CellValue(cnt, targetPrefix+"vndr_seq") = sheetObj.CellValue(i, prefix+"vndr_seq");
//				targetSheetObj.CellValue(cnt, targetPrefix+"lane_cd") = sheetObj.CellValue(i, prefix+"lane_cd");
//				targetSheetObj.CellValue(cnt, targetPrefix+"lane_nm") = sheetObj.CellValue(i, prefix+"lane_nm");
//				targetSheetObj.CellValue(cnt, targetPrefix+"dir_seq1") = sheetObj.CellValue(i, prefix+"dir_seq1");
//				targetSheetObj.CellValue(cnt, targetPrefix+"dir_seq2") = sheetObj.CellValue(i, prefix+"dir_seq2");
//				
//				var dirCds = sheetObj.CellValue(i, prefix+"dir_seq1") + "|" + sheetObj.CellValue(i, prefix+"dir_seq2");
//				
//				targetSheetObj.CellComboItem(cnt, targetPrefix+"bound_seq1", dirCds, dirCds, 0);
//				targetSheetObj.CellComboItem(cnt, targetPrefix+"bound_seq2", dirCds, dirCds, 0);
//				
//				targetSheetObj.CellValue(cnt, targetPrefix+"bound_seq1") = sheetObj.CellValue(i, prefix+"bound_seq1");
//				targetSheetObj.CellValue(cnt, targetPrefix+"bound_seq2") = sheetObj.CellValue(i, prefix+"bound_seq2");
//				
////				targetSheetObj.CellEditable(cnt, targetPrefix+"lane_cd") = false;
////				targetSheetObj.CellEditable(cnt, targetPrefix+"lane_nm") = false;
//				
//				targetSheetObj.CellValue(cnt, targetPrefix+"ibflag") = "R";
//			}
//			
//			sheetObj.CellValue(i, prefix+"serviceFlg") = "";
//			sheetObj.CellValue(i, prefix+"laneFlg") = "";
//			sheetObj.CellValue(i, prefix+"ibflag") = "";
//		}
//		targetSheetObj.Redraw = true;
//		
//		sheetObj.ColumnSort(prefix+"lane_cd", "ASC");
//	}
	/* 개발자 작업  끝 */