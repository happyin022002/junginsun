/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_SCE_0150.js
 *@FileTitle : Dwell/Delay Notification Sending Status
 *Open Issues :
 *@LastModifyDate : 2011.07.21
 *@LastModifier : 이수진
 *@LastVersion : 1.0
 * 2011.07.21 이수진
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
 * @class ESD_SCE_0150 : ESD_SCE_0150 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */


function ESD_SCE_0150() {
	this.processButtonClick = tprocessButtonClick;
	this.setComboObject = setComboObject;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject	= setTabObject;
	this.validateForm	= validateForm;
	this.obj_keypress   = obj_keypress;
}

/* 개발자 작업 */
//공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

//var isFirstOnLoad = "false";
//var isCopyAllRequested = false;
//var saveFail = false;
//var saveSuccess = true;


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

		case "btn_new":
			sheetObject.RemoveAll();
			initSheet(sheetObject,1);

			formObject.reset();
			break;
        
		case "btn_ctrt_cust":
        	openCustomerPop(false,'cust_cd');
        	break;
        	
		case "btn_excel":
			down_excel();
			break;

		case "btn_text":
			down_text();
			break;
			
		case "btn_print":
			down_print();
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

//키 입력 핸들러
function initControl() {
	 axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
     axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
     axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
     axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);        
     axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
     axon_event.addListenerForm	('focusin',			'form_focusin',			document.form); //- 클릭시
	 axon_event.addListener ('keydown', 'ComKeyEnter', 'form');	
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
	for(var k = 0; k < comboObjects.length; k++){	
        initCombo(comboObjects[k], k + 1);
    }
	initControl();	
	
}
 
/**
 * 콤보 초기설정값 정의 <br>
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
 */
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
    }
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
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 4, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(7, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "|SEQ|Customer Code|96hrs Terminal Dwell|48hrs Enroute Dwell|72hrs Destination Dwell|24hrs Vessel Delay";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]

			InitDataProperty(0, cnt++ , dtHiddenStatus,  0, 	daCenter,  	false,    "ibflag");
            InitDataProperty(0, cnt++ , dtDataSeq,	    50, 	daCenter,  	true,     "Seq");
            InitDataProperty(0, cnt++ , dtData, 		200,	daCenter,	true,     "cust_cd", 	    false,    "",  dfNone, 0,   false,	true);
            InitDataProperty(0, cnt++ , dtData, 		180,    daCenter,	true,     "t96_cnt",  	false,    "",  dfNone, 0,   false,	true);            
            InitDataProperty(0, cnt++ , dtData, 		180,	daCenter,	true,     "e48_cnt", 	false,    "",  dfNone, 0,   false,	true);
            InitDataProperty(0, cnt++ , dtData, 		180,    daCenter,	true,     "d72_cnt", 	false,    "",  dfNone, 0,   false,	true);
            InitDataProperty(0, cnt++ , dtData, 		180,	daCenter,	true,     "v24_cnt", 	false,    "",  dfNone, 0,   false,	true);
            
            DataLinkMouse('cust_cd') = true;
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


//Sheet관련 프로세스 처리

function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSEARCH:	
		
		if( formObj.start_dt.value == ""){
			ComShowCodeMessage("COM130201","Date");
			return;
		}
		
		if( formObj.end_dt.value == ""){
			ComShowCodeMessage("COM130201","Date");
			return;
		}
		
		if ( ComGetDaysBetween(formObj.start_dt.value, formObj.end_dt.value) > 31) {
			alert("The maximum period can't be over 31 days!")
			formObj.start_dt.focus();
			return false;
		}
		
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH ;
		sheetObj.DoSearch4Post("ESD_SCE_0150GS.do", SceFrmQryString(formObj));	
		
		break;

	}
}
    
/**
 * ETD,ETB 기간 선택 달력 띄우기
 */
function callDatePop(val){
	var cal = new ComCalendarFromTo();
	if (val == 'EFF Date'){
		cal.select(form.start_dt,  form.end_dt,  'yyyy-MM-dd');
	}
}   
 
// excel 다운
function down_excel(){
	var sheetObj = sheetObjects[0];
	ComOpenWait(true);
	sheetObj.Down2Excel(-1, false, false, true);
	ComOpenWait(false);

}

// text 문서 다운
function down_text(){
	var sheetObj = sheetObjects[0];	
	ComOpenWait(true);
	sheetObj.Down2Text("", "\t", "", "AllData.txt", "c:\\down\\", "");
	ComOpenWait(false);
}

// Print
function down_print(){
	var sheetObj = sheetObjects[0];
	sheetObj.ExtendLastCol = false;
	sheetObj.Down2Print(true, 2, "Dwell/Delay Notification Sending Status", 1,1);
	sheetObj.ExtendLastCol = true;
}


// 시트 컬럼 더블 클릭 이벤트 핸들
function sheet1_OnDblClick(sheetObj ,Row, Col){
	
	 var formObject = document.form;
     var colName = sheetObj.ColSaveName(Col);
     var dtValue = sheetObj.CellValue(Row,Col);
     switch(colName) {
      
     case "cust_cd":
 		
		 var paramUrl = "cust_cd="+sheetObj.CellValue(Row,'cust_cd')+"&sc_no="+sheetObj.CellValue(Row,'sc_no')+"&start_dt=" + formObject.start_dt.value + "&end_dt=" + formObject.end_dt.value;
		
	     if(Col == 2 && sheetObj.CellValue(Row,"cust_cd") !== "" ){
	       window.showModalDialog("ESD_SCE_0152.do?"+paramUrl, self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:900px;dialogHeight:600px");
	//       window.showModalDialog("ESD_SCE_0152.do?"+paramUrl, self, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:325px");
	      }
	      break;
     }
}

// 조회 후 로직 처리
function sheet1_OnSearchEnd(sheetObj)
{    	
	
	var idx = coSceSaveNameCol(sheetObj, 'cust_cd');
	var rowcount = sheetObj.RowCount;	
	sheetObj.ColFontUnderline('cust_cd') = true;
	sheetObj.ColFontColor('cust_cd')= sheetObj.RgbColor(0, 0, 255);
	sheetObj.RangeFontBold(1,idx,rowcount,idx)=true;
	ComOpenWait(false);

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
    
    // Customer Code 조회 팝업 오픈
	function openCustomerPop(multi, custCd, custNm, ofcCd, custSgmt){
		var formObj = document.form ;
		var param   = "" ;
		var display = getCommPopDisplay(multi) ;

		param  = "?classId=" + getCommPopClassId() ;
		param += getURLParam(multi, "cust_cd", custCd) ;
		param += getURLParam(multi, "cust_nm", custNm) ;
		param += getURLParam(multi, "ofc_cd",  ofcCd) ;

		custCdFld   = custCd ;
		custNmFld   = custNm ;
		ofcCdFld    = ofcCd ;
		custSgmtFld = custSgmt ;
		multiChkYN  = multi ;
		ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 770, 450, 'setValFromCustomerPop', display, true) ;
	}
	
	//PopUp 화면에서 선택한 Code Setting
	 function setValFromCustomerPop(rowArray){
		var colArray = null ;
		var formObj = document.form;
		
		colArray = rowArray[0] ;
		formObj.cust_cnt_cd.value = colArray[3].substring(0,2);
		formObj.cust_seq.value = colArray[3].substring(2);
	}

	 // Customer Code 입력시 Cust_Cnt_Cd 입력후 Cust_Seq Input Box로 Focus
	 function focusCustSeq(){
	  	formObj = document.form;
	   	if(formObj.cust_cnt_cd.value.length == 2){
	   	formObj.cust_seq.focus();
	   	}
     }

