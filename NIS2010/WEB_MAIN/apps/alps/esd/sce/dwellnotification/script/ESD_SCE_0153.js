/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_SCE_0153.js
 *@FileTitle : Dwell Reason Update by VVD
 *Open Issues :
 *@LastModifyDate : 2011.07.19
 *@LastModifier : 손은주
 *@LastVersion : 1.0
 * 2011.07.19 손은주
 * 1.0 Creation
 * --------------------------------------------------------
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
 * @author SM LINE
 */

/**
 * @extends
 * @class ESD_SCE_0153 : ESD_SCE_0153 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

function ESD_SCE_0140() {
	this.processButtonClick = tprocessButtonClick;
	this.setComboObject = setComboObject;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
//공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

var isFirstOnLoad = "false";
var isCopyAllRequested = false;
var saveFail = false;
var saveSuccess = true;



//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_save":

			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_new":

			sheetObject.RemoveAll();
			initSheet(sheetObject,1);
			formObject.reset();
			chk_schPart(formObject.sch_part[0]);

			break;
		case "btns_calendar": //달력버튼
            var cal = new ComCalendarFromTo();            
            cal.select(document.form.fr_eta_dt,document.form.to_eta_dt,'yyyy-MM-dd');

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

function initControl() {
	axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
    
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
 
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

 
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	
}
 


/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
 
function initSheet(sheetObj, sheetNo) {
	 

	var cnt = 0;

	switch (sheetNo) {
	case 1: 
		with (sheetObj) {
			// 높이 설정
			style.height = GetSheetHeight(20);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 10, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(16, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);

			var HeadTitle = "|Seq.|Lane|VVD|ETA|ETD|Dwell Reason at TMNL|Update|Update|Update|Update|";
			var HeadTitle1 = "|Seq.|Lane|VVD|ETA|ETD|Dwell Reason at TMNL|Date(EST)|User ID|User Name|Office|";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtDummyCheck,	  30,	daCenter,  true,	"ibcheck",			false,			"",		  dfNone,			0,	   true,	   false);
			InitDataProperty(0, cnt++ , dtDataSeq,       70,   daCenter,  true,    "seq",     false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,    "slan_cd",      false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,       100,  daCenter,  true,    "vvd",     			false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,       120,  daCenter,  true,    "eta_dt",     	false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,       120,  daCenter,  true,    "etd_dt",     	false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,       300,  daLeft,  true,    "dwll_rsn",     	false,          "",       dfNone,   		0,     true,      true, 2000, false);
			InitDataProperty(0, cnt++ , dtData,       120,  daCenter,  true,    "upd_dt",     		false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,       100,  daCenter,  true,    "upd_usr_id",     	false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,       120,  daCenter,  true,    "upd_usr_nm",     	false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtData,       100,  daCenter,  true,    "upd_ofc_cd",     	false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtStatus,      0,   daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "upd_usr_id1",     	false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "upd_usr_nm1",     	false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,  true,    "upd_ofc_cd1",     	false,          "",       dfNone,   		0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden,       70,   daCenter,  true,    "dwll_rsn_seq",     false,          "",       dfNone,   		0,     false,      false);
			
			ColHidden('ibflag')	= true;
			WaitImageVisible=false;
		}
		break;
	}
}


/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}
 
/**
 * IBCombo Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, tabTitle[0], -1);	
			InsertTab(cnt++, tabTitle[1], -1);	
			InsertTab(cnt++, tabTitle[2], -1);	
			InsertTab(cnt++, tabTitle[3], -1);	
		}
		break;
	}
	tabObj.TabMouseOverEffect = true;
}


//Sheet관련 프로세스 처리

function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSEARCH:	
		
		if( formObj.port_cd.value == ""){
			ComShowCodeMessage("COM130201","Port");
			return;
		}

		if( formObj.sch_part[0].checked == true && (formObj.fr_eta_dt.value=="" || formObj.to_eta_dt.value=="")){
			ComShowCodeMessage("COM130201","ETA");
			return;
		}
		
		if( formObj.sch_part[1].checked == true && formObj.vvd_cd.value==""){
			ComShowCodeMessage("COM130201","VVD Code");
			return;
		}
		
		if(!validateForm(sheetObj, formObj, sAction)) {return;}
		
		
		formObj.f_cmd.value = SEARCH02 ;
		ComOpenWait(true);
		sheetObj.DoSearch4Post("ESD_SCE_0153GS.do", SceFrmQryString(formObj));
		ComOpenWait(false);
				
		break;
		
	case IBSAVE:
		formObj.f_cmd.value = MULTI01 ;
		var checkList = sheetObj.FindCheckedRow('ibcheck');
		var checkArray = checkList.split('|');
		if(checkList == ''){
			ComShowCodeMessage('COM12176');
			return false;
		}
		for(var k=0; k<checkArray.length-1; k++)
		{
			sheetObj.CellValue2(checkArray[k], 'upd_usr_id1') = formObj.usr_id.value;
			sheetObj.CellValue2(checkArray[k], 'upd_usr_nm1') = formObj.usr_nm.value;
			sheetObj.CellValue2(checkArray[k], 'upd_ofc_cd1') = formObj.usr_ofc_cd.value;
		}
		ComOpenWait(true);
		sheetObj.DoSave("ESD_SCE_0153GS.do", SceFrmQryString(formObj), 'ibcheck',false);
		ComOpenWait(false);
	}
}

function chk_schPart(obj){
	var formObj = document.form;
	if( obj.value == 'eta'){
		formObj.fr_eta_dt.className = "input1";
		formObj.to_eta_dt.className = "input1";
		formObj.vvd_cd.className = "input2"
		formObj.fr_eta_dt.disabled = false;
		formObj.to_eta_dt.disabled = false;
		formObj.vvd_cd.value = "";
		formObj.vvd_cd.disabled = true;

	}else{
		formObj.fr_eta_dt.className = "input2";
		formObj.to_eta_dt.className = "input2";
		formObj.vvd_cd.className = "input1"
		formObj.fr_eta_dt.value = "";
		formObj.to_eta_dt.value = "";
		formObj.fr_eta_dt.disabled = true;
		formObj.to_eta_dt.disabled = true;
		formObj.vvd_cd.disabled = false;
	}

}

/**
* 저장결과가 오류가 발생했을 때 공통처리하는 함수
* IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
*/
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

/**
* sheet cell value 변경시 발생하는 이벤트
**/
function sheet1_OnChange(sheetObj, row, col, value){
	
	var colName = sheetObj.ColSaveName(col);
	if( colName == 'dwll_rsn'){
		sheetObj.cellValue2(row, "ibcheck") = 1;
	}

}

//  ===================================================================================
//  Axson Event Handler
//  ===================================================================================
/** 
 * Object 의 Keypress 이벤트핸들러 <br>
 * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 */ 
function obj_keypress(){
    var obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;
    switch(obj.dataformat){
        case "ymd": //날짜 입력하기
            ComKeyOnlyNumber(obj,"-"); 
            break;
        case "int": //숫자만 입력
        case "number": //숫자만 입력
            ComKeyOnlyNumber(obj);
            break;
        case "engup":
            ComKeyOnlyAlphabet('upper');
            break;
        case "uppernum":
            ComKeyOnlyAlphabet('uppernum');
            break;
        default:
            //ComKeyOnlyNumber(obj);
            break;
    }
}


/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	  	case IBSEARCH:
	  		if (formObj.sch_part[0].checked) {
	  			var frDt = formObj.fr_eta_dt.value.replace(/-/g,"");
	  			var toDt = formObj.to_eta_dt.value.replace(/-/g,"");  
	  			if(parseInt(frDt) > (parseInt(toDt))){
		    		//ComShowMessage("From 은  To 날짜보다 이후 일수는 없습니다.");
		    		ComShowCodeMessage("SCE90050","ETA To Date","ETA From Date");
		    		formObj.to_eta_dt.focus();
		    		formObj.to_eta_dt.value ="";
		    		return false;
		    	}
	  		}
        break;
	} 
	
	return true;
}