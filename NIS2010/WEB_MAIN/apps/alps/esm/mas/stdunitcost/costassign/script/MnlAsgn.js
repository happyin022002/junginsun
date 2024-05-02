/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_9999.js
*@FileTitle : Batch Test Page
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영
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
     * @class Batch Test를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function MnlAsgn() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/**
 * Sheet 기본 설정 및 초기화
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}

/**
 * IBSheet Object를 배열로 등록
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;



// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
								
			//case "btn_close":
				//window.close();
			//break;
				
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
 * 시트 초기설정값, 헤더 정의
 */
function initSheet(sheetObj,sheetNo) {
	var formObj = document.form;

	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				SheetWidth = mainTable.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly; //msNone;
				Editable = true;
				InitRowInfo(1, 1, 10, 100);
				InitColumnInfo(3, 1, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "SEQ|MAS_BAT_CD|CNT|";
				InitHeadRow(0, HeadTitle, true);


				cnt = 0;
				
				InitDataProperty(0, cnt++, dtSeq,        50, daCenter,	 true, "");
				
				InitDataProperty(0, cnt++, dtData,       200, daCenter,   true, "mas_bat_cd",	false, "", dfNone, 0, false, false);	
				InitDataProperty(0, cnt++, dtData,   	 200, daRight,   true, "cnt",     		false, "", dfInteger, 0, false, false);
																
				//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
				

				HeadRowHeight = 10;
				CountPosition = 0;

				style.height = GetSheetHeight(20) ;

			}
			break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;


	switch(sAction) {
		case IBSEARCH:      //조회
			if (!validateCond(formObj)) {
				return false;
			}
			// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch4Post("MnlAsgnGS.do", masFormQueryString(formObj));
//			var xml = sheetObj.GetSearchXml("MnlAsgnGS.do", FormQueryString(formObj));
//			formObj.aa.value= xml;
			ComOpenWait(false);
			break;
			
		
		
	}
}

function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	with(sheetObj) {
	}
}

 
/**
 * 화면 조회값에 대한 유효성검증 프로세스 처리
 */
function validateCond(formObj) {
	with(formObj){
	}

	return true;
}

