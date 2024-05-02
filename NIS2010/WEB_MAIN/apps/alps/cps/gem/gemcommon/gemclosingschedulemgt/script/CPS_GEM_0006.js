/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0006.js
 *@FileTitle : Closing Confirmation & Interface Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.17 최정미
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011-02-17 이준범 [CHM-201108627-01]
 * 제목: Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 보완: Request 권한 없는 Office 에 대한 화면 Block
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
 * @class Expense Code Inquiry : Expense Code Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0006(){
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.validateForm = validateForm;
	
	// add
	this.obj_keypress = obj_keypress;
	this.obj_deactivate = obj_deactivate;
	this.obj_activate = obj_activate;	
	
	this.initProperty = initProperty;
	this.initKeySetting = initKeySetting;
	this.setInSheetRowReset = setInSheetRowReset;
	this.setAtSheetRowReset = setAtSheetRowReset
	
	// sheet
	this.sheet1_OnChange = sheet1_OnChange;
	this.sheet1_OnPopupClick = sheet1_OnPopupClick;
	this.sheet2_OnChange = sheet2_OnChange;
	this.sheet2_OnPopupClick = sheet2_OnPopupClick;
		
}

//=============================================================
//#Form Command          #IBSheet Action                
//INIT        = 0;       IBSEARCH       = 0;  // 조회         
//ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
//SEARCH      = 2;       IBSAVE         = 2;  // 저장         
//SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
//MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
//REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
//REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
//MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
//PRINT       = 8;       IBDELETE       = 8;  // 삭제         
//REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                     IBROWSEARCH    = 10; // Row 조회     
//                     IBCREATE       = 11; // Create       
//                     IBRESET        = 12; // Reset        
//                     IBBATCH        = 13; // Batch        
//=============================================================

/* 개발자 작업 */

//===================================================================================
//공통전역변수
//===================================================================================
var sheetObjects = new Array();
var sheetCnt = 0;
var curYear = "";
var frm = null;
var sheet1 = null;
var sheet2 = null;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

//===================================================================================
//초기화 
//===================================================================================
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage(year) {
	frm = document.form;
	sheet1 = sheetObjects[0];
	sheet2 = sheetObjects[1];
	sheetCnt = sheetObjects.length ;
	
	for(i=0;i<sheetObjects.length;i++){		
		//khlee-시작 환경 설정 함수 이름 변경
        //alert("sheetObjects[i] : "+sheetObjects[i]);
		ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
	}
   
    // 현재년도 설정
    if (frm.clz_yrmon.value == "") {
    	frm.clz_yrmon.value = year;
    }  
    curYear = year;
    
    // html컨트롤 이벤트초기화
    initControl();

}

/**
* 화면 깜빡임 제거 하면서 로드시 초기Data조회
* @param sheetObj
* @return
*/
function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.WaitImageVisible = false;

	if ( doActionIBSheet(IBCLEAR) == false ) {
		return;
	}
   // 초기Data조회
	doActionIBSheet(IBSEARCH);

//	doActionIBSheet(sheetObj, document.form, IBCLEAR);
	sheetObj.WaitImageVisible = true;
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo){
	var cnt = 0;
	switch (sheetObj.id) {
		
		case "sheet1":
			with (sheetObj){
				// 높이 설정
				style.height = 350;
				
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
								
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(3, 1, 15, 100);
				
				var HeadTitle1 = " |  |Planning & Performance|Planning & Performance|Planning & Performance|Planning & Performance|Planning & Performance|KEY1|KEY2|";
				var HeadTitle2 = " |  |Closing DT|Creator|Creation DT|CLS|CLS|KEY1|KEY2|";
				var HeadTitle3 = " |  |Closing DT|Creator|Creation DT|G/L I/F|MK|KEY1|KEY2|";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 2, false);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
				InitHeadMode(false, false, false, true, false, false)

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				InitHeadRow(2, HeadTitle3, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++, dtData, 		120, 	daCenter, 	true,	"col1",				false, "", dfNone);
				InitDataProperty(0, cnt++, dtData, 		60, 	daCenter, 	true,	"col2",				false, "", dfNone);
				
				//in
				InitDataProperty(0, cnt++, dtPopup, 	100, 	daCenter, 	true,	"in_clz_dt", 		false, "", dfDateYmd);
				InitDataProperty(0, cnt++, dtData, 		80, 	daCenter, 	true,	"in_cre_usr_id",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 		80, 	daCenter, 	true,	"in_cre_dt", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCheckBox, 	60, 	daCenter,	true,	"in_gl_if_flg",		false, "", dfNone);
				InitDataProperty(0, cnt++, dtCheckBox, 	0, 	daCenter,	false,	"in_clz_flg",		false, "", dfNone);
								
				// dtHidden
				// Left 헤더로 인해 dtHiddenStatus 밑에 추가
				InitDataProperty(0, cnt++, dtHidden, 	60, 	daCenter, 	true,	"in_clz_div_cd", 	false, "", dfNone);
				InitDataProperty(0, cnt++, dtHidden, 	60, 	daCenter, 	true,	"in_clz_yrmon", 	false, "", dfNone);
				
				InitDataProperty(0, cnt++, dtHiddenStatus, 60, daCenter, true,"ibflag");
				
				CountPosition = 0;
				
				// 해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
				InitHeadColumn(
						"col1",
						"Initial Plan|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|",
						daCenter);
				InitHeadColumn("col2", ""+curYear+"|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC",
						daCenter);
				
				PopupImage = "img/btns_calendar.gif";
			    
				ShowButtonImage = 2;
				sheet1.DataRowHeight = 22;
				
			}
			break;
		case "sheet2":
			with (sheetObj){
				// 높이 설정
				style.height = 350;

				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(3, 1, 15, 100);

				var HeadTitle1 = " |  |Performance (Subsidiary)|Performance (Subsidiary)|Performance (Subsidiary)|Performance (Subsidiary)|KEY1|KEY2|";
				var HeadTitle2 = " |  |Closing DT|Creator|Creation DT|CLS_MK|KEY1|KEY2|";
				var HeadTitle3 = " |  |Closing DT|Creator|Creation DT|CLS_MK|KEY1|KEY2|";
				
				var headCount = ComCountHeadTitle(HeadTitle1);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 2, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				InitHeadRow(2, HeadTitle3, true);

				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++, dtHidden, 	120, 	daCenter, 	true,	"col1",				false, "", dfNone);
				InitDataProperty(0, cnt++, dtHidden, 	60, 	daCenter, 	true,	"col2",				false, "", dfNone);
				
				//at
				InitDataProperty(0, cnt++, dtPopup, 	100, 	daCenter, 	true,	"at_clz_dt", 		false, "", dfDateYmd);
				InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, 	true,	"at_cre_usr_id",	false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 		100, 	daCenter, 	true,	"at_cre_dt", 		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCheckBox, 	0, 		daCenter, 	true,	"at_clz_flg",		false, "", dfNone);
				
				// dtHidden
				// Left 헤더로 인해 dtHiddenStatus 밑에 추가
				InitDataProperty(0, cnt++, dtHidden, 	60, 	daCenter, 	true,	"at_clz_div_cd", 	false, "", dfNone);				
				InitDataProperty(0, cnt++, dtHidden, 	60, 	daCenter, 	true,	"at_clz_yrmon", 	false, "", dfNone);				
				
				InitDataProperty(0, cnt++, dtHiddenStatus, 60, daCenter, true,"ibflag");
				
				CountPosition = 0;
				
				// 해더컬럼정보[선택][컬럼,표시글자,컬럼정렬]
				InitHeadColumn(
						"col1",
						"Initial Plan|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|Monthly Request\n(ADD / TRS)|",
						daCenter);
				InitHeadColumn("col2", ""+curYear+"|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC",
						daCenter);
				
				
				PopupImage = "img/btns_calendar.gif";
			    ShowButtonImage = 2;
				sheet2.DataRowHeight = 22;
			}
			break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction){
	//sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	
		case IBCLEAR:      //Open

			frm.f_cmd.value = SEARCH;
			var sXml = sheet1.GetSearchXml("CPS_GEM_0004GS.do", FormQueryString(frm));

			var arrXml = sXml.split("|$$|");
			var authFlg  = "";
			
			// 로그인 오피스 정보 
			if (arrXml.length > 0) {			
				var list = ComXml2ListMap(arrXml[0]);
				var officeLevelVo  = list[0];

				authFlg  = officeLevelVo["auth_flg"];	
			}
			// 권한 없는 Office 가 로그인 시 화면 닫음
			if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
				goNoAuthority();
				return false;
		    }
	 	   	break;
	
		case IBSEARCH: //조회
      		if(validateForm(sAction)) {
      			frm.f_cmd.value = SEARCH;
      			var sXml = sheet1.GetSearchXml("CPS_GEM_0006GS.do", FormQueryString(frm));
      			var arrXml = sXml.split("|$$|");
      			if (ComGetTotalRows(arrXml[0]) > 0) {
	  				sheet1.LoadSearchXml(arrXml[0]);
	  				sheet2.LoadSearchXml(arrXml[0]);
	  			}
	  			
	  			// 검색된 데이터의 값을 체크해서 ClosingDt를 Edittable시킴
      			initProperty(sAction);
     	   	}
     	   	break;
     	   	   	   	  	
		case IBSAVE: // 저장
			if(validateForm(sAction)) {
				// 저장하시겠습니까?
				if(!ComCodeMsgBySave()) return;
				
				frm.f_cmd.value = MULTI;
				//var sXml = sheet1.DoSave("CPS_GEM_0006GS.do", FormQueryString(frm),-1,false);
				//if(sXml) doActionIBSheet(IBSEARCH);
				
				var sParam = FormQueryString(frm);
				var sParam1 = sheet1.GetSaveString();
				var sParam2 = sheet2.GetSaveString();
				
				//alert(sheet1.IsDataModified +"==>"+sParam1+"<" +"\n"+ sheet2.IsDataModified +"==>"+sParam2+"<" +"\n");
				
				if (!sheet1.IsDataModified && !sheet2.IsDataModified) {				
					ComCodeMsgByNoContentsSave();
					return; 
				}
				
				if (sParam1 == "" && sParam2 == "") {				
					ComCodeMsgByNoContentsSave();
					return; 
				}
				
				if(sParam1 != "") sParam = sParam + "&" + sParam1;
				if(sParam2 != "") sParam = sParam + "&" + sParam2;
				
				//alert(sParam);
				//return;
				
    			var sXml = sheet1.GetSaveXml("CPS_GEM_0006GS.do", sParam);
    			//sheet1.LoadSearchXml(sXml);
    			if(sXml) doActionIBSheet(IBSEARCH);
    						
    		}
			break;
		
		case IBINSERT: // 입력
			break;
	}
}

//===================================================================================
//Form 이벤트 처리
//===================================================================================
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
 	DATE_SEPARATOR = "/";
 	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',	form); //- 포커스 나갈때
	//axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
	axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
	//axon_event.addListenerForm('keyup',				'obj_keyup',		form); //- 키 올라올때
	//axon_event.addListener('change',   'obj_change',  'agmt_seq'); //- 변경될때.
}

/**
* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
**/
function obj_keypress(){
	switch (event.srcElement.name) {    
	    case "clz_yrmon":
	    	ComKeyOnlyNumber(event.srcElement);
	    	if(event.keyCode == 13) {doActionIBSheet(IBSEARCH);}
			break;
	}	
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 **/
function obj_deactivate(){
	var strClzYrmon = frm.clz_yrmon.value;
	switch(event.srcElement.name){
		case "clz_yrmon":
			if(strClzYrmon.length == 4) {
				// Key Setting(필수)
				//initKeySetting();
				
				//헤더시트값변경
				sheet1.CellValue2(3,1) = strClzYrmon;
				sheet2.CellValue2(3,1) = strClzYrmon;
			}
			break;
	}
}

/**
 * HTML Control Foucs in
 */
function obj_activate(){
   ComClearSeparator(event.srcElement);
}
 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	//var sheetObject = sheetObjects[0];
	
	/** **************************************************** */
	//var formObject = document.form;
	
	try	{
		var srcName = window.event.srcElement.getAttribute("name");
		//alert("srcName : "+srcName);
		switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(IBSEARCH);            	
                break;
			case "btn_New":
				// 초기화하시겠습니까?
				if(!ComCodeMsgByInitialize()) return;
				ComResetAll();
				frm.clz_yrmon.focus();
		 		initProperty(IBSEARCH);
		 		break;
			case "btn_Save":
				doActionIBSheet(IBSAVE);
				break;
			case "clz_yrmon_cal":
				var cal = new ComCalendar();
				cal.setDisplayType('year');
				cal.select(frm.clz_yrmon, 'yyyy');
                break;
		} // end switch
	}
	catch (e){
		if (e == "[object Error]"){
			// GEM01027	ENG	W	지금은 사용하실 수가 없습니다.
			ComCodeMsgByNoUsed();
		}else{
			ComShowMessage(e);
		}
	}
}

//===================================================================================
//Private function
//===================================================================================
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sAction){
	if (!ComChkValid(frm)) return false;
	
	var	inFromYm;
	var inToYm;
	var	atFromYm;
	var atToYm;
	
	with(frm){		
		if (sAction == IBSAVE) {
    		for(var row=5; row<=sheet1.LastRow; row++) {
    			inFromYm = sheet1.CellValue(row-1, "in_clz_dt");
    			inToYm = sheet1.CellValue(row, "in_clz_dt");
    			atFromYm = sheet2.CellValue(row-1, "at_clz_dt");
    			atToYm = sheet2.CellValue(row, "at_clz_dt");
    			//alert(inFromYm.replace(/-/g, '')+"=="+inToYm.replace(/-/g, ''));
    			// in
    			if(inToYm != ""){
	    			if(inFromYm=="" ||inFromYm==null){
	    				// GEM01030	ENG	W	날짜입력 오류! 전월 날짜를 입력 하십시요.
	    				ComShowCodeMessage("GEM01030");
	    				sheet1.SelectCell(row-1, "in_clz_dt");
	    				return false;
	    			}
    			}
    			if(parseInt(inToYm.replace(/-/g, '')) <= parseInt(inFromYm.replace(/-/g, ''))) {
    				// GEM01031	ENG	W	날짜입력 오류! 전월 날짜보다 커야 합니다.
    				ComShowCodeMessage("GEM01031");
    				sheet1.SelectCell(row, "in_clz_dt");
    				return false;
    			}
    			// at
    			if(atToYm != ""){
	    			if(atFromYm=="" ||atFromYm==null){
	    				// GEM01030	ENG	W	날짜입력 오류! 전월 날짜를 입력 하십시요.
	    				ComShowCodeMessage("GEM01030");
	    				sheet2.SelectCell(row-1, "at_clz_dt");
	    				return false;
	    			}
    			}
    			if(parseInt(atToYm.replace(/-/g, '')) <= parseInt(atFromYm.replace(/-/g, ''))) {
    				// GEM01031	ENG	W	날짜입력 오류! 전월 날짜보다 커야 합니다.
    				ComShowCodeMessage("GEM01031");
    				sheet2.SelectCell(row, "at_clz_dt");
    				return false;
    			}
    		}
		}
	}
	
	return true;
}

/**
 * 검색된 데이터의 값을 체크해서 ClosingDt를 Edittable시킴
 * @return
 */
function initProperty(sAction) {
	switch (sAction) {
		case IBSEARCH: //조회
			// 1.[Planning & Performance] Initial Plan( Grid 의 첫줄) 일 경우 G/L I/F 없으므로, G/L I/F 체크박스 선택(“√”) 해제 상태로 비활성화 
			// 2.[Performance(Subsidiary)]  Initial Plan( Grid 의 첫줄) 은 모두 비활성화
			// 3.그외

			for(var row=3; row<=sheet1.LastRow; row++) {
				if(row == 3) {
					// 1.Planning & Performance
					sheet1.CellValue2(row,"in_gl_if_flg") = 0;
					sheet1.CellEditable(row, "in_gl_if_flg") = false;					
				}
				// 3. 그외
				if(sheet1.CellValue(row,"in_clz_flg") == 1){
					sheet1.CellEditable(row, "in_clz_dt") = false;
				}
			}
			for(var row=3; row<=sheet2.LastRow; row++) {
				if(row == 3) {
					// 2.Performance(Subsidiary)
					sheet2.CellValue2(row,"at_clz_flg") = 0;
					sheet2.CellEditable(row, "at_clz_flg") = false;
					sheet2.CellEditable(row, "at_clz_dt") = false;
					
				}
				// 3. 그외
				//alert("sheet2 ("+row+") :"+sheet2.CellValue(row,"at_clz_flg"));
				if(sheet2.CellValue(row,"at_clz_flg") == 1){
					sheet2.CellEditable(row, "at_clz_dt") = false;
				}
			}
			break;		
	}
}

/**
 * 데이터 조회후 KeySetting
 */
function initKeySetting() {
	var k = 0;
	var strKey = "";
	curYear = frm.clz_yrmon.value;
	for(var row=3; row<=sheet1.RowCount+2; row++) {
		
		if(row == 3) strKey = "00";
		else strKey = "0"+k; 
		
		sheet1.CellValue2(row,"in_clz_div_cd") = "IN";
		sheet1.CellValue2(row,"in_clz_yrmon") = curYear + strKey;
		sheet2.CellValue2(row,"at_clz_div_cd") = "AT";
		sheet2.CellValue2(row,"at_clz_yrmon") = curYear + strKey;
		
		k++;
	}
}
  
/**
 * Planning & Performance 의 CLS_MK를 체크해제시 초기화
 * @param sheetObj
 * @param row
 * @return
 */
function setInSheetRowReset(sheetObj, row, val) {
	 if(!val) sheetObj.CellValue(row,"in_clz_dt") = "";
	sheetObj.CellValue(row,"in_gl_if_flg") = 0;
	sheetObj.CellEditable(row, "in_clz_dt") = true;	
}

/**
 * Performance(Subsidiary) 의 CLS_MK를 체크해제시 초기화
 * @param sheetObj
 * @param row
 * @return
 */
function setAtSheetRowReset(sheetObj, row, val) {
	if(!val) sheetObj.CellValue(row,"at_clz_dt") = "";
	sheetObj.CellEditable(row, "at_clz_dt") = true;	
}

//===================================================================================
//Sheet 이벤트 처리
//===================================================================================
/**
 * 셀의 값이 바뀌었을 때 발생하는 Event
 * @param sheetObj
 * @param row
 * @param col
 * @return
 */
function sheet1_OnChange(sheetObj, row, col) {
	//헤더시트값변경
	sheetObj.CellValue2(3,1) = frm.clz_yrmon.value;
	
	switch (sheetObj.ColSaveName(col)) {
		case "in_gl_if_flg" :
			if(row > 3) {
				//alert("Change in_gl_if_flg : "+sheetObj.cellvalue(row,"in_gl_if_flg"));
				if(sheetObj.cellvalue(row,"in_gl_if_flg") == 0) {
					//alert("unCheck할경우 : "+sheetObj.CellValue(row,"in_clz_dt"));
					if(sheetObj.CellValue(row,"in_clz_flg") == 1){
						// GEM01033	ENG	W	CLS MK 체크를 먼저 풀어야 합니다.
						ComShowCodeMessage("GEM01033");
						
						sheetObj.CellValue2(row,"in_gl_if_flg") = 1;
						sheetObj.SelectCell(row,"in_clz_flg");
						
						return;
					}
				}
				if(sheetObj.cellvalue(row,"in_gl_if_flg") == 1) {
					//alert("Check할경우 : "+sheetObj.CellValue(row,"in_clz_flg"));
					if (sheetObj.CellValue(row,"in_clz_dt") == "") {
						// GEM01032	ENG	W	Closing DT를 입력하십시요.
						ComShowCodeMessage("GEM01032");
						
						sheetObj.CellValue2(row,"in_gl_if_flg") = 0;
						sheetObj.SelectCell(row,"in_clz_dt");
						
						return;
					}
					
					// G/L I/F 인터페이스 결과를 체크하려면..
					if(sheetObj.CellValue(row,"in_clz_dt") != "") {
						//alert(sheetObj.CellValue(row,"in_gl_if_flg"));
						frm.glif_clz_yrmon.value = sheetObj.CellValue(row,"in_clz_yrmon");
						frm.f_cmd.value = SEARCHLIST;
						var sXml = sheetObj.GetSearchXml("CPS_GEM_0006GS.do", FormQueryString(frm),-1,false);
						var arrXml = sXml.split("|$$|");
						
						var returnStr = ComGetEtcData(arrXml[0], "code");
						if(returnStr == "1") {
							//alert("G/L I/F 작업을 성공하였습니다.");
							ComShowCodeMessage('GEM01061',"성공");
							sheetObj.CellValue2(row,"in_gl_if_flg") = 1;
							sheetObj.SelectCell(row,"in_clz_flg");
						} else if(returnStr == "2"){
							//alert("G/L I/F 작업한 내용이 없습니다.");
							ComShowCodeMessage('GEM01062');
							sheetObj.CellValue2(row,"in_gl_if_flg") = 1;
							sheetObj.SelectCell(row,"in_gl_if_flg");
						} else if(returnStr == "0"){
							//alert("G/L I/F 작업을 실패하였습니다.");
							ComShowCodeMessage('GEM01061',"실패");
							sheetObj.CellValue2(row,"in_gl_if_flg") = 0;
							sheetObj.SelectCell(row,"in_gl_if_flg");				
						}
					}
				}
			}
			break;
		case "in_clz_flg" :
			if (sheetObj.CellValue(row,"in_clz_dt") == "") {
				// GEM01032	ENG	W	Closing DT를 입력하십시요.
				ComShowCodeMessage("GEM01032");
				
				sheetObj.CellValue2(row,"in_clz_flg") = 0;
				sheetObj.SelectCell(row,"in_clz_dt");
				
				return;
			}
			
			if(row > 3) {
				if (sheetObj.CellValue(row,"in_gl_if_flg") == 0) {
					// GEM01034	ENG	W	G/L I/F를 먼저 체크해야 합니다.
					ComShowCodeMessage("GEM01034");
					
					sheetObj.CellValue2(row,"in_clz_flg") = 0;
					sheetObj.SelectCell(row,"in_gl_if_flg");
					
					return;
				}
			}
			
			if(sheetObj.CellValue(row,"in_clz_flg") == 0) {
				//alert("unCheck할경우 : "+sheetObj.CellValue(row,"in_clz_dt"));
				if(row==4){
					//alert("a1 : "+row);
					if(sheetObj.CellValue(row+1,"in_clz_dt")!="" && sheetObj.CellValue(row+1,"in_clz_flg")==0){
 						setAtSheetRowReset(sheetObj, row, true);
 						return false;
 					}
					if(sheetObj.CellValue(row+1,"in_clz_flg")==1){
						// GEM01035	ENG	W	CLS MK 체크오류!
						ComShowCodeMessage("GEM01035");
						
						sheetObj.CellValue2(row,"in_clz_flg") = 1;
						sheetObj.SelectCell(row,"in_clz_flg");
						
						return;
					}
					setInSheetRowReset(sheetObj, row);					
				} else {
					//alert("a2 : "+row);
					if(sheetObj.CellValue(row+1,"in_clz_dt")!="" && sheetObj.CellValue(row+1,"in_clz_flg")==0){
 						setAtSheetRowReset(sheetObj, row, true);
 						return false;
 					}
					if(sheetObj.CellValue(row-1,"in_clz_flg")==1 && sheetObj.CellValue(row+1,"in_clz_flg")==1){
						// GEM01035	ENG	W	CLS MK 체크오류!
						ComShowCodeMessage("GEM01035");
						
						sheetObj.CellValue2(row,"in_clz_flg") = 1;
						sheetObj.SelectCell(row,"in_clz_flg");
						
						return;
					}
					setInSheetRowReset(sheetObj, row);
				}
			}
			
			if(sheetObj.CellValue(row,"in_clz_flg") == 1){
				//alert("Check할경우 : "+sheetObj.CellValue(row,"in_clz_flg"));
				
				// Performance(Subsidiary)에 CLS_MK를 먼저 체크해야함.
				if(row > 3) {
					//alert("change at_clz_flg : "+sheet2.CellValue(row,"at_clz_flg"));
					if(sheet2.CellValue(row,"at_clz_flg") == 0){
						// Performance(Subsidiary)에 CLS_MK를 먼저 체크해야 합니다.
						ComShowCodeMessage("GEM01063");
						
						sheetObj.CellValue2(row,"in_clz_flg") = 0;
						sheetObj.SelectCell(row,"in_clz_flg");
						
						return;
					}
				}
				
				if(row==4){
					//alert("b1 : "+row);
					if(sheetObj.CellValue(row+1,"in_clz_flg")==1){
						// GEM01035	ENG	W	CLS MK 체크오류!
						ComShowCodeMessage("GEM01035");
						
						sheetObj.CellValue2(row,"in_clz_flg") = 0;
						sheetObj.SelectCell(row,"in_clz_flg");
						
						return;
					}
					sheetObj.CellEditable(row, "in_clz_dt") = false;
					
				} else if(row==sheetObj.LastRow){
					//alert("b2 : "+row);
					if(sheetObj.CellValue(row-1,"in_clz_flg")==0){
						// GEM01035	ENG	W	CLS MK 체크오류!
						ComShowCodeMessage("GEM01035");
						
						sheetObj.CellValue2(row,"in_clz_flg") = 0;
						sheetObj.SelectCell(row,"in_clz_flg");
						
						setInSheetRowReset(sheetObj, row);
						
						return;
					}
					sheetObj.CellEditable(row, "in_clz_dt") = false;
				} else{	
					//alert("b3 : "+row);
					if(sheetObj.CellValue(row-1,"in_clz_flg")==0 && sheetObj.CellValue(row+1,"in_clz_flg")==0){
						// GEM01035	ENG	W	CLS MK 체크오류!
						ComShowCodeMessage("GEM01035");
						
						sheetObj.CellValue2(row,"in_clz_flg") = 0;
						sheetObj.SelectCell(row,"in_clz_flg");
						
						setInSheetRowReset(sheetObj, row);
						
						return;
					}				
					sheetObj.CellEditable(row,"in_clz_dt") = false;			
				}
			}
			break;
	}
}
 
/**
 * 셀의 값이 바뀌었을 때 발생하는 Event
 * @param sheetObj
 * @param row
 * @param col
 * @return
 */
function sheet2_OnChange(sheetObj, row, col) {
	// Key Setting(필수)
	//initKeySetting();
 	
	//헤더시트값변경
	sheetObj.CellValue2(3,1) = frm.clz_yrmon.value;
	
	 switch (sheetObj.ColSaveName(col)) {
		case "at_clz_flg" :
 			if(row > 3) {
 				if (sheetObj.CellValue(row,"at_clz_dt") == "") {
 					// GEM01032	ENG	W	Closing DT를 입력하십시요.
 					ComShowCodeMessage("GEM01032");
 					
 					sheetObj.CellValue2(row,"at_clz_flg") = 0;
 					sheetObj.SelectCell(row,"at_clz_dt");
 					
 					return;
 				}
 			}
 			
			// UnChecked
 			if(sheetObj.CellValue(row,"at_clz_flg") == 0) {
 				if(row==4){
 					//alert("a1 : "+row);
 					if(sheetObj.CellValue(row+1,"at_clz_dt")!="" && sheetObj.CellValue(row+1,"at_clz_flg")==0){
 						setAtSheetRowReset(sheetObj, row, true);
 						return false;
 					}
 					if(sheetObj.CellValue(row+1,"at_clz_flg")==1){
 						// GEM01035	ENG	W	CLS MK 체크오류!
 						ComShowCodeMessage("GEM01035");
 						
 						sheetObj.CellValue2(row,"at_clz_flg") = 1;
 						sheetObj.SelectCell(row,"at_clz_flg");
 						
 						return;
 					}
 					setAtSheetRowReset(sheetObj, row);
 					
 				} else {
 					//alert("a2 : "+row);
 					if(sheetObj.CellValue(row+1,"at_clz_dt")!="" && sheetObj.CellValue(row+1,"at_clz_flg")==0){
 						setAtSheetRowReset(sheetObj, row, true);
 						return false;
 					}
 					if(sheetObj.CellValue(row-1,"at_clz_flg")==1 && sheetObj.CellValue(row+1,"at_clz_flg")==1){
 						// GEM01035	ENG	W	CLS MK 체크오류!
 						ComShowCodeMessage("GEM01035");
 						
 						sheetObj.CellValue2(row,"at_clz_flg") = 1;
 						sheetObj.SelectCell(row,"at_clz_flg");
 						
 						return;
 					}
 					setAtSheetRowReset(sheetObj, row);
 				}
 			}
 			
 			// Cheked
 			if(sheetObj.CellValue(row,"at_clz_flg") == 1){
 				if(row==4){
 					//alert("b1 : "+row);
 					if(sheetObj.CellValue(row+1,"at_clz_flg")==1){
 						// GEM01035	ENG	W	CLS MK 체크오류!
 						ComShowCodeMessage("GEM01035");
 						
 						sheetObj.CellValue2(row,"at_clz_flg") = 0;
 						sheetObj.SelectCell(row,"at_clz_flg");
 						
 						return;
 					}
 					sheetObj.CellEditable(row, "at_clz_dt") = false;
 					
 				} else if(row==sheetObj.LastRow){
 					//alert("b2 : "+row);
 					if(sheetObj.CellValue(row-1,"at_clz_flg")==0){
 						// GEM01035	ENG	W	CLS MK 체크오류!
 						ComShowCodeMessage("GEM01035");
 						
 						sheetObj.CellValue2(row,"at_clz_flg") = 0;
 						sheetObj.SelectCell(row,"at_clz_flg");
 						
 						setAtSheetRowReset(sheetObj, row);
 						return;
 					}
 					sheetObj.CellEditable(row, "at_clz_dt") = false;
 					
 				} else{	
 					//alert("b3 : "+row);
 					if(sheetObj.CellValue(row-1,"at_clz_flg")==0 && sheetObj.CellValue(row+1,"at_clz_flg")==0){
 						// GEM01035	ENG	W	CLS MK 체크오류!
 						ComShowCodeMessage("GEM01035");
 						
 						sheetObj.CellValue2(row,"at_clz_flg") = 0;
 						sheetObj.SelectCell(row,"at_clz_flg");
 						
 						setAtSheetRowReset(sheetObj, row);
 						return;
 					}				
 					sheetObj.CellEditable(row,"at_clz_dt") = false;			
 				}
			}
			break;
	}
}

/** 
* 달력 띄우는 샘플(IBSheet로 리턴하는 경우 예제)
*/
function sheet1_OnPopupClick(sheetObj, row, col){
	switch (sheetObj.ColSaveName(col)) {
       	case "in_clz_dt" :
		    if (sheetObj.ColSaveName(col) != "in_clz_dt") return;
		    var cal = new ComCalendarGrid("myCal");
		    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
		    break;
		    
	}
}

/** 
* 달력 띄우는 샘플(IBSheet로 리턴하는 경우 예제)
*/
function sheet2_OnPopupClick(sheetObj, row, col){
	switch (sheetObj.ColSaveName(col)) {
       	case "at_clz_dt" :
		    if (sheetObj.ColSaveName(col) != "at_clz_dt") return;
		    var cal = new ComCalendarGrid("myCal");
		    cal.select(sheetObj, row, col, 'yyyy-MM-dd');		    
		    break;
		    
	}
}

/* 개발자 작업 끝 */