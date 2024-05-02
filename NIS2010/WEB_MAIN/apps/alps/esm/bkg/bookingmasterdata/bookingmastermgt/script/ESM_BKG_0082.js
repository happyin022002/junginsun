/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0082.js
 *@FileTitle : Booking Creation 1_MT P/UP CY inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김기종
 *@LastVersion : 1.0
 * 2009.05.04 김기종
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
	 * @class esm_bkg_0082 : esm_bkg_0082 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function esm_bkg_0082() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
		this.sheet1_OnClick =sheet1_OnClick;
		this.callPopupOK = callPopupOK;
		this.getLocalCheckedRows =getLocalCheckedRows;
		this.setMakeChildSheetVal=setMakeChildSheetVal;
		this.isSheetCheckVal = isSheetCheckVal;
		
	}
	
	/* 개발자 작업 */
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
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
			// ComDebug(srcName);
			switch (srcName) {
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
	
			case "btn_confirm":
				callPopupOK(sheetObject);
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
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	}
	function sheet1_OnLoadFinish(sheetObj) {
		initControl();
	}
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {int} sheetNo sheetObjects 배열에서 순번
	 */
	function initControl() {
		var formObject = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',  'obj_KeyPress',    formObject); // 키보드 입력할때
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
		// axon_event.addListener('change', 'yd_cd_change', 'yd_cd'); //- Yd
		// Code 입력 후 Name 정보 가져오기
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	
	
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
	
		switch (sheetNo) {
		case 1: 
			with (sheetObj) {
	
				// 높이 설정
				style.height = 337;
				// 전체 너비 설정
				SheetWidth = leftTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(6, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				// InitHeadMode(true, true, false, true, false, false)
				InitHeadMode(true, true, false, true, false,false)
				
				var HeadTitle1 = " ||Yard|YD_NM|PHN_NO|YD_PIC_NM";
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				// 데이터속성 [	ROW, COL, 	DATATYPE, WIDTH, DATAALIGN, COLMERGE,SAVENAME,KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,ALLCHECK,SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHidden, 	30, daCenter, false, 	"radio",		false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtRadioCheck,30, daCenter, false,	"check", 		false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 		48, daCenter, true, 	"yd_cd",		false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 	48, daCenter, false, 	"yd_nm",		false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 	48, daCenter, false, 	"phn_no",		false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtHidden, 	48, daCenter, false,	"yd_pic_nm", 	false, "", dfNone, 0, false, true);
			}
			break;
		case 2: // t1sheet1 init
			with (sheetObj) {
				// 높이 설정(150)
				style.height = 250;
				// 전체 너비 설정
				SheetWidth = rightTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
				
				var tempTilte = "Available EQ Status per Day(estimated)";
				var HeadTitle = "Booking|Booking|Available EQ Status per Day(estimated)";
				
				for (var i = 1; i < 15; i++) {
					HeadTitle = HeadTitle + "|" + tempTilte;
				}
				var HeadTitle2 = "TP/SZ|QTY|Today|D+1|D+2|D+3|D+4|D+5|D+6|D+7|D+8|D+9|D+10|D+11|D+12|D+13";
				
				
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle2), 0, 0, false);
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle2, false);
				
				// 데이터속성 [	ROW, COL, 	DATATYPE, WIDTH, DATAALIGN, COLMERGE,SAVENAME,KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,ALLCHECK,SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true,	"cntr_tpsz_cd", false, "", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true,	"op_cntr_qty", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, true,	"fcast_qty", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true,	"fcast_qty1", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true,	"fcast_qty2", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true,	"fcast_qty3", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true,	"fcast_qty4", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true,	"fcast_qty5", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true,	"fcast_qty6", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true,	"fcast_qty7", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true,	"fcast_qty8", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 30, daCenter, true,	"fcast_qty9", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 35, daCenter, true,	"fcast_qty10", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 35, daCenter, true,	"fcast_qty11", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 35, daCenter, true,	"fcast_qty12", 	false, "", dfInteger, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 35, daCenter, true,	"fcast_qty13", 	false, "", dfInteger, 0, false, true);
				Visible = true;
			}
			break;
		}
	}
	/**
	 * 조회 종료 후 이벤트 처리. <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {col} ErrMsg DB조회 후 남기 메시지
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObjects[1].RemoveAll();
		sheet1_OnClick(sheetObjects[0], 1, 1, '');
	}
	
	/**
	 * Sheet Click 후 이벤트 처리. <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {col} ErrMsg DB조회 후 남기 메시지
	 */
	
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var formObj = document.form;
		// var sheetObject = sheetObjects[1];
		
		ComSetObjValue(formObj.yd_nm, sheetObj.CellValue(Row, "yd_nm"));
		ComSetObjValue(formObj.phn_no, sheetObj.CellValue(Row, "phn_no"));
		ComSetObjValue(formObj.yd_pic_nm, sheetObj.CellValue(Row, "yd_pic_nm"));
		formObj.selectSheetYdCd.value =sheetObj.CellValue(Row, "yd_cd");
		if (sheetObj.CellValue(Row, "yd_nm") != ''){
			doActionIBSheet(sheetObjects[1], formObj, IBROWSEARCH);
		}
	}
	/**
	 * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
	 * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서<br>
	 * IBSheet의 기능을 호추할 때 사용한다. <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {form} formObj Form Object
	 * @param {int} sAction 처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		// sheetObj.ShowDebugMsg = false;
	
		switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_BKG_0082GS.do", FormQueryString(formObj)
						+ "&" + ComGetPrefixParam(""));
				
				
			}
			break;
		case IBROWSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH01;
	
	   			var sXml = sheetObj.GetSearchXml("ESM_BKG_0082GS.do" , FormQueryString(formObj));
	   			var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);
				// 부모창 값 세팅
				setMakeChildSheetVal(formObj);
			}
			break;
		}
	}
	/**
	 * 부모창에서 받아온 값들을 팝업에서 display. <br>
	 * 
	 * @param {form} formObj 화면 form Object
	 */
	function setMakeChildSheetVal(formObj){
		var  parentRefSheet ;
		if (formObj.callSheetIdx.value !=""){
			parentRefSheet = eval(opener.sheetObjects[formObj.callSheetIdx.value]);
		}else{
			parentRefSheet =opener.sheetObjects[0];
		}
		
		var  mySheet =sheetObjects[1];
		for (i = 2; i<= mySheet.LastRow; i++) {
			for (j = 1; j<= parentRefSheet.LastRow; j++) {
				if (mySheet.CellText(i, "cntr_tpsz_cd") == parentRefSheet.CellText(j, "cntr_tpsz_cd")){
					mySheet.CellValue(i, "op_cntr_qty") = ComAddComma(parentRefSheet.CellValue(j, "op_cntr_qty"));
				}
			}
		}
		for (k = 1; k<= parentRefSheet.LastRow; k++) {
			if (isSheetCheckVal(mySheet,"cntr_tpsz_cd",parentRefSheet.CellText(k, "cntr_tpsz_cd")) == false){
				mySheet.DataInsert(-1);
				
				mySheet.CellText(mySheet.LastRow,"cntr_tpsz_cd") = parentRefSheet.CellText(k, "cntr_tpsz_cd");
				mySheet.CellText(mySheet.LastRow,"op_cntr_qty") = ComAddComma(parentRefSheet.CellText(k, "op_cntr_qty"));
				sheetCnt++
			}
		}
	}
	/**
	 * 팝업에서 check 선택시 부모창으로 값을 전달. <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {col} formObj 화면 중 좌선택 값
	 * @param {val) check 비교 값
	 * @return {boolean} 정상 여부
	 */
	function isSheetCheckVal(sheetObj,col,checkVal){
		for (i = 1; i<= sheetObj.LastRow; i++) {
			if (sheetObj.CellText(i, col) == checkVal){
				return true;
			}
		}
		return false;
	}
	/**
	 * 팝업에서 check 선택시 부모창으로 값을 전달. <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {String} value sheetObj의 입력값
	 */
	function callPopupOK(sheetObj) {
		var formObj = document.form;
		var calllFunc;
		var rArray = null; // 행데이터를 담고 있는 배열
		// 단일선택(Radio) 또는 다중선택(CheckBox) 일 때..
		rArray = getLocalCheckedRows(sheetObj);
		
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		calllFunc = formObj.calllFunc.value;
		opener.eval(calllFunc)(rArray);
		window.close();
	}
	
	/**
	 * 시트에서 선택된. row의 값들을 배렬로 리턴 <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {String} column name
	 */
	
	function getLocalCheckedRows(sheetObj,colName) {
		var checkRows;
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
		
		var rArray = null; // 행데이터를 담고 있는 배열
		var cArray = null; // 열데이터를 담고 있는 배열
		
		checkRows = sheetObj.CheckedRows('check');
		
		if(checkRows == 0) {  			
				return null;
			}
			else {
				var idx = 0;
	  		rArray = new Array(checkRows);
	  		
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {					
		  			cArray = null;
		  			
		  			// 특정 컬럼명이 지정된 경우
		  			if(colName != null && colName != "") {
		  				cArray = sheetObj.CellValue(i, colName);
		  			} else {
		  				cArray = new Array(colsCnt);
		  				
			  			for(var j=0; j<cArray.length; j++) {
	                    	cArray[j] = sheetObj.CellValue(i, j);
	                    }
	                }
	                rArray[idx++] = cArray;
	     		}
	  		}
	  	}
	  	return rArray;
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
	 * 
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {form} formObj 화면 form Object
	 * @param {ibsheet} sAction IBSheet Object
	 * @param {String} value sheetObj의 입력값
	 * @return {boolean} 정상 여부
	 * @see #ComChkValid
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
		}
		return true;
	}
	
	/* 개발자 작업 끝 */