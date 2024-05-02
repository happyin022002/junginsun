/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EES_EQR_1030.js
 *@FileTitle : Empty Repo Guideline Email
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : YONGCHAN SHIN
 *@LastVersion : 1.0
 * 2013.01.06 YONGCHAN SHIN
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class EES_EQR_1030 : EES_EQR_1030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_EQR_1030() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initControl 		= initControl;
	this.doActionIBSheet	= doActionIBSheet;
	this.validateForm 		= validateForm;
	this.openPopup 			= openPopup;	
}


/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt     = 0;
var comboObjects = new Array();
var comboCnt 	 = 0 ;
var comObjects   = new Array();
var pri_combo_cd = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	var formObj = document.form;

    for(i=0;i<sheetObjects.length;i++){
    	//시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
		//마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObj,IBSEARCH);
			break;

			case "btn_save":
				doActionIBSheet(sheetObject, formObj, MULTI);
			break;

			case "btn_new":
				init_form();//화면 초기화.
			break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
			break;

			case "btns_open_ofc":		//Office Code
				openPopup();
			break;
			
			case "btn_row_add":		// row add
				sheetObject.DataInsert();
			break;	
									
			
				
		} // end switch
	} catch (e) { 
		if (e == "[object Error]") {
			ComShowCodeMessage("EQR01109");//The service is not available now
		} else {
			alert(e);
		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH:      //조회

			sheetObj.RemoveAll();
	       	formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("EES_EQR_1030GS.do", FormQueryString(formObj));

       break;

	   case MULTI:	// Save
		    formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("EES_EQR_1030GS.do",FormQueryString(formObj));
	   break;
	   
       case IBDOWNEXCEL:   //엑셀 다운로드
       		if(sheetObj.RowCount >0){
	       		sheetObj.Down2Excel(-1,false,false,true);
			}else{
				ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
			}
       break;
    }
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo){
	var cnt = 0;

	switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {

				// 높이 설정
				style.height = 410;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge + msHeaderOnly]
				//MergeSheet = msPrevColumnMerge + msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//EditableColorDiff = false;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "Del|Seq|User ID|User Name|RHQ|Office Code|e-Mail|";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				HeadTitleCnt = ComCountHeadTitle(HeadTitle);
				InitColumnInfo(HeadTitleCnt, 0, 0, true);
				
				//Row Height Fix
				//AutoRowHeight = false;  

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, true, false)
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				// 데이터속성 [   ROW, COL, DATATYPE,       WIDTH,DATAALIGN,	COLMERGE,  SAVENAME,	  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtDelCheck, 		60,	 daCenter,	 false,  "delchk", 			    false, 		"", 		dfNone, 		0,		true, 	true);
				InitDataProperty(0, cnt++, dtSeq, 			60,  daCenter,	 false,  "seq", 	    		false, 		"", 		dfNone, 		0,		false, 	false);
				InitDataProperty(0, cnt++, dtData, 			120, daCenter, 	 false,  "gline_rcpt_usr_id",	true, 		"", 		dfNone, 		0,		false, 	true,        20);
				InitDataProperty(0, cnt++, dtData, 			150, daCenter, 	 false,  "usr_nm", 				false, 		"", 		dfNone, 		0,		false, 	false);
				InitDataProperty(0, cnt++, dtData, 			100, daCenter, 	 false,  "ar_hd_qtr_ofc_cd", 	false, 		"", 		dfNone, 		0,		false, 	false);
				InitDataProperty(0, cnt++, dtData,			100, daCenter, 	 false,  "ofc_cd",				false, 		"", 		dfNone,  		0,		false,	false);
				InitDataProperty(0, cnt++, dtData, 		    180, daCenter, 	 false,  "gline_rcpt_eml",     	true, 		"", 		dfNone, 	    0,		true, 	true,        200);

				InitDataProperty(0, cnt++, dtHiddenStatus,	10,  daCenter, 	 false,  "ibflag",  			false, 		"", 		dfNone, 		0,		false, false);
				
			}

		break;
	}
}

/**
 * 조회 완료 이벤트 후 로직 <br>
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

}

 /**
 * 셀을 마우스 클릭했을때 발생하는 이벤트 <br>
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	var formObj = document.form;

}

/*
 * Grid sheet 에서 onchange event 발생시 처리
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(Col);
	
	if( colName == "gline_rcpt_usr_id" ) {	// User ID 
		var usr_id = sheetObj.CellValue(Row, colName);	// usr id 입력값	
		
		// GRID 에 동일한 ID 가 존재하는지 검사
		for( i=1; i < sheetObj.RowCount+1; i++) {

			var row_value = sheetObj.CellValue(i, "gline_rcpt_usr_id");
			
		    if(i != Row && usr_id == row_value) {  // 동일 row 존재(입력row 는 비교대상 제외)   
		    	// 중복 USR ID 존재
	 			ComShowCodeMessage("EQR01140");	// There is duplicate user id
	 			sheetObj.CellValue2(Row, "gline_rcpt_usr_id") = "";
				return false;		    	
		    }
		}
		
 		
		formObj.f_cmd.value = SEARCH01; 
 		var sXml = sheetObj.GetSearchXml("EES_EQR_1030GS.do?usr_id="+usr_id, FormQueryString(formObj));   			 		
  		
 		var usr_id = ComGetEtcData(sXml,"gline_rcpt_usr_id")
 		
 		//USR_ID_VAL -- T:중복없음(사용가능), F:중복존재 입력불가
 		var dup_chk = ComGetEtcData(sXml,"usr_id_val")
 		
 		if(dup_chk=="F") { // 중복 데이터 존재
 			ComShowCodeMessage("EQR01140");	// There is duplicate user id
 			sheetObj.CellValue2(Row, "gline_rcpt_usr_id") = "";
			return false;
			
 		}else {  // 중복 아님

 			if(usr_id!=null && usr_id !="") {  // 존재하는 USER ID
 				sheetObj.CellValue2(Row, "gline_rcpt_usr_id") 	= ComGetEtcData(sXml,"gline_rcpt_usr_id");
 	 			sheetObj.CellValue2(Row, "usr_nm") 				= ComGetEtcData(sXml,"usr_nm");
 	 			sheetObj.CellValue2(Row, "ar_hd_qtr_ofc_cd") 	= ComGetEtcData(sXml,"ar_hd_qtr_ofc_cd");
 	 			sheetObj.CellValue2(Row, "ofc_cd") 				= ComGetEtcData(sXml,"ofc_cd");	
 	 			sheetObj.CellValue2(Row, "gline_rcpt_eml") 		= ComGetEtcData(sXml,"gline_rcpt_eml");	
 			}else {  // 존재하지 않는 USER ID
 				ComShowCodeMessage("EQR01141"); // This user id isn\'t available.
 				sheetObj.CellValue2(Row, "gline_rcpt_usr_id") = "";
 				return false;
 			}
 		

 		} 		
 		

	}else if( colName == "gline_rcpt_eml" ) { // EMAIL
	    //메일 주소 유효성 검증
		if(ComIsEmailAddr(sheetObj.CellValue(Row, colName))==false){
			ComShowCodeMessage("EQR01142");
			return false;				
		}
 			
	} 		
}

// 저장후 메세지 표현
function sheet1_OnSaveEnd(sheetObj, errMsg){
	var formObj = document.form;
	
	if (errMsg == "") {
		ComShowCodeMessage("EQR01001");		
	}
}

/**
 * New 버튼 클릭시 화면 초기화.
 */
function init_form() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	formObj.f_rhqcd.value = ""; // rhq office 기본값
	formObj.f_ofccd.value = ""; // office code 지우기
	
	sheetObj.RemoveAll(); // GRID 제거

}

/**
 * Office Pop-up Open 부분<br>
 */
function openPopup() {

	ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 755, 635, "ofc_cd:f_ofccd", "1,0,1,1,1,1,1,1", true);

	return;
}