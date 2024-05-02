/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0010.js
 *@FileTitle : Expense Code Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.30
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.30 최정미
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
 * @author CLT
 */

/**
 * @extends
 * @class Expense Code Inquiry : Expense Code Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0010(){
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.initControl = initControl;
	this.validateForm = validateForm;
	
	// add
	this.setComboObject = setComboObject;
	this.initCombo = initCombo;
	this.obj_keypress = obj_keypress;
	this.obj_deactivate = obj_deactivate;
	this.obj_activate = obj_activate;
	
	this.setExpnAcctSearch = setExpnAcctSearch;
	this.isLangCheck = isLangCheck;
	
	// sheet
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnPopupClick = sheet1_OnPopupClick;	
}

/* 개발자 작업 */

//===================================================================================
//공통전역변수
//===================================================================================
var sheetObjects = new Array();
var sheetCnt = 0;
var frm = null;
var sheet1 = null;

//IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var combo2 = null;
var combo3 = null;
var comboCnt = 0;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj){
  comboObjects[comboCnt++] = combo_obj;
}

//===================================================================================
//초기화 
//===================================================================================
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	frm = document.form;
	sheet1 = sheetObjects[0];
	sheetCnt = sheetObjects.length ;
	
	for(i=0;i<sheetCnt;i++){		
		//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
	}

	// combo
	combo1 = comboObjects[0];
	combo2 = comboObjects[1];
	combo3 = comboObjects[2];
	comboCnt = comboObjects.length;
	
    // IBMultiCombo초기화
	for(var k=0; k<comboObjects.length; k++){
        initCombo(comboObjects[k]);
    }
    
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
	
	// 초기Data조회
	doActionIBSheet(IBSEARCH);

	doActionIBSheet(sheetObj, document.form, IBCLEAR);
	sheetObj.WaitImageVisible = true;
}


/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
	comboObj.DropHeight = 190;
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo){
	var cnt = 0;
	switch(sheetObj.id) {

	    case "sheet1":
	        with (sheetObj) {

	            // 높이 설정
	            style.height = 420;
	            
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;

	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;

	           //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;

	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(2, 1, 18, 100);

				var HeadTitle1 = "|1st Group (Item DIV)|1st Group (Item DIV)|2nd Group (Planning)|2nd Group (Planning)|3rd Group (Accounting)|3rd Group (Accounting)|Final Group(Expense Code)|Final Group(Expense Code)|Final Group(Expense Code)|Account Code|Account Code|Account Code|Salary|Sales DIV";
				var HeadTitle2 = "|Code|Name|Code|Name|Code|Name|Code|Name|TIC|Code|Name|Description|Salary|Sales DIV";
		
	            var headCount = ComCountHeadTitle(HeadTitle1);

	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 3, 0, true);

	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false,false)

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

	            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,		DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,		0,		daCenter,	true,		"ibflag");
				
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"lvl1_code",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				120,	daLeft,		true,		"lvl1_name",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"lvl2_code",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				120,	daLeft,		true,		"lvl2_name",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"lvl3_code",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				120,	daLeft,		true,		"lvl3_name",		false,		"",			dfNone);

				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"lvl4_code",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				120,	daLeft,		true,		"lvl4_name",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"lvl4_tic", 		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"acct_code",		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				120,	daLeft,		true,		"acct_name", 		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtPopup,			300,	daLeft,		true,		"acct_desc",		false,		"",			dfNone,		0);
				InitDataProperty(0, cnt++ , dtData,				60,		daCenter,	true,		"saly_flg", 		false,		"",			dfNone);
				InitDataProperty(0, cnt++ , dtData,				0,		daCenter,	true,		"sls_div",			false,		"",			dfNone);

				PopupImage  =  "img/btns_inquiry.gif";
				ShowButtonImage = 2;
			}
			break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sAction){
	//sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		
		case IBSEARCH: // OPEN	  		
  			frm.f_cmd.value = SEARCH;
  			var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));
  			var arrXml = sXml.split("|$$|");
  			
  			var langDiv = getColNameValue("sch_lang");
  			// ---------------------------------
  			// Tic List
  			// ---------------------------------
  			var comboTicData = ComGetEtcData(arrXml[0], "ticList").split("|");
	   		if(typeof comboTicData != "undefined" && comboTicData != "") {	
				var ticCd = frm.sch_tic_cd;
				ticCd.length = 0;
				ComAddComboItem(ticCd,"","");
				
				for(var i=0 ; i < comboTicData.length ; i++ ) {
					ComAddComboItem(ticCd,comboTicData[i],comboTicData[i]);
				}
	   		}
	   		
  			// ---------------------------------
  			// Expense Form ~ To 
  			// ---------------------------------
  			var arrTempData = ComXml2ListMap(arrXml[0]);
  			combo1.InsertItem(0, "|", "");
  			combo2.InsertItem(0, "|", "");
			var k1 = 1;
			var k2 = 1;
  			for(var i=0 ; i < arrTempData.length ; i++ ) {
  				var tempData = arrTempData[i];
  				
  				if(langDiv == "K") {
					combo1.InsertItem(k1++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
					combo2.InsertItem(k2++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if(langDiv == "E") {
					combo1.InsertItem(k1++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
					combo2.InsertItem(k2++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
  			}
  			combo1.Code = "";
  			combo2.Code = "";
  			
  			// ---------------------------------
  			// Group Expense 
  			// ---------------------------------
  			var arrTempData = ComXml2ListMap(arrXml[1]);
  			combo3.InsertItem(0, "|", "");
			var k = 1;
  			for(var i=0 ; i < arrTempData.length ; i++ ) {
  				var tempData = arrTempData[i];
  				
  				if(langDiv == "K") {
					combo3.InsertItem(k++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if(langDiv == "E") {
					combo3.InsertItem(k++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
  			}
  			combo3.Code = "";
	   		
  			break;
		case SEARCHLIST: // 조회
			if(validateForm(sAction))
      		{
				frm.f_cmd.value = SEARCHLIST;
      			frm.sch_expense_from.value = combo1.Code;
      			frm.sch_expense_to.value = combo2.Code;
      			frm.sch_expense_group.value = combo3.Code;
      			
      			var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));
	  			var arrXml = sXml.split("|$$|");
	  			if (arrXml.length > 0) {
	  				sheet1.LoadSearchXml(arrXml[0]);
	  			}
     	   	}
     	   	break;     	
		case SEARCHLIST01: // Expense조회
			frm.f_cmd.value = SEARCHLIST01;
			frm.sch_expense_from.value = combo1.Code;
			frm.sch_expense_to.value = combo2.Code;
			
  			var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));
  			
  			var langDiv = getColNameValue("sch_lang");
  			var preCombo1 = combo1.Code;
  			var preCombo2 = combo2.Code;  			
  			// ---------------------------------
  			// Expense Form ~ To 
  			// ---------------------------------
  			combo1.RemoveAll(); 
  			combo2.RemoveAll();
  			var arrTempData = ComXml2ListMap(sXml);	
  			combo1.InsertItem(0, "|", "");
  			combo2.InsertItem(0, "|", "");
			var k1 = 1;
			var k2 = 1;
  			for(var i=0 ; i < arrTempData.length ; i++ ) {
  				var tempData = arrTempData[i];
  				  				
  				if(langDiv == "K") {
					combo1.InsertItem(k1++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
					combo2.InsertItem(k2++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if(langDiv == "E") {
					combo1.InsertItem(k1++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
					combo2.InsertItem(k2++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
  			}
  			combo1.Code = preCombo1;
  			combo2.Code = preCombo2;
  			
			break;
		case SEARCHLIST02: // Account조회
			frm.f_cmd.value = SEARCHLIST02;
			frm.sch_expense_from.value = combo1.Code;
			frm.sch_expense_to.value = combo2.Code;
			
  			var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));
  			
  			var langDiv = getColNameValue("sch_lang");
  			var preCombo1 = combo1.Code;
  			var preCombo2 = combo2.Code;
  			// ---------------------------------
  			// Account Form ~ To 
  			// ---------------------------------
  			combo1.RemoveAll(); 
  			combo2.RemoveAll();
  			var arrTempData = ComXml2ListMap(sXml);	
  			combo1.InsertItem(0, "|", "");
  			combo2.InsertItem(0, "|", "");
			var k1 = 1;
			var k2 = 1;
  			for(var i=0 ; i < arrTempData.length ; i++ ) {
  				var tempData = arrTempData[i];
  				
  				if(langDiv == "K") {
					combo1.InsertItem(k1++, tempData["acct_cd"]+"|"+tempData["krn_nm"], tempData["acct_cd"]);
					combo2.InsertItem(k2++, tempData["acct_cd"]+"|"+tempData["krn_nm"], tempData["acct_cd"]);
				} else if(langDiv == "E") {
					combo1.InsertItem(k1++, tempData["acct_cd"]+"|"+tempData["eng_nm"], tempData["acct_cd"]);
					combo2.InsertItem(k2++, tempData["acct_cd"]+"|"+tempData["eng_nm"], tempData["acct_cd"]);
				}
  			}
  			combo1.Code = preCombo1;
  			combo2.Code = preCombo2;
  			
			break;
		case SEARCHLIST03: // Group Expense조회
			frm.f_cmd.value = SEARCHLIST03;
			frm.sch_expense_group.value = combo3.Code;
			
			var sXml = sheet1.GetSearchXml("CPS_GEM_0010GS.do", FormQueryString(frm));
			
			var langDiv = getColNameValue("sch_lang");
			var preCombo3 = combo3.Code;
			
			combo3.RemoveAll();
			
			// ---------------------------------
			// Group Expense 
			// --------------------------------- 
  			var arrTempData = ComXml2ListMap(sXml);
			combo3.InsertItem(0, "|", "");
			var k = 1;
			for(var i=0 ; i < arrTempData.length ; i++ ) {
				var tempData = arrTempData[i];
				
				if(langDiv == "K") {
					combo3.InsertItem(k++, tempData["gen_expn_cd"]+"|"+tempData["krn_abbr_nm"], tempData["gen_expn_cd"]);
				} else if(langDiv == "E") {
					combo3.InsertItem(k++, tempData["gen_expn_cd"]+"|"+tempData["eng_abbr_nm"], tempData["gen_expn_cd"]);
				}
			}
			combo3.Code = preCombo3;			
			break;
		
		case IBSAVE: // 저장
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
	axon_event.addListenerForm('beforeactivate',	'obj_activate',		form); //- 포커스 들어갈때
	axon_event.addListenerForm('keypress',			'obj_keypress',		form); //- 키 눌렸을때
	//axon_event.addListenerForm('keyup',				'obj_keyup',		form); //- 키 올라올때
	//axon_event.addListener('change',   'obj_change',  'agmt_seq'); //- 변경될때.
}

/**
 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
	switch (event.srcElement.name) {    
	    case "":
	    	break;
	}	
}

/**
 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
 **/
function obj_deactivate(){
	switch(event.srcElement.name){
		case "":
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
				doActionIBSheet(SEARCHLIST);            	
                break;
			case "btn_New":
				// Do you want to initialize?
				if(!ComCodeMsgByInitialize()) return;
				ComResetAll();
				combo1.RemoveAll();
				combo2.RemoveAll();
				combo3.RemoveAll();
				
				doActionIBSheet(IBSEARCH);
				frm.sch_expense_gbn[0].focus();
				break;
				
			case "btn_DownExcel":
				if (sheet1.RowCount <= 0 ) {
					// There is no related data!
					ComCodeMsgByNoRelatedData();
					return;
				} else {
					//sheet1.Down2Excel(1,false,false,true,"","",false,false," Expense Code Inquiry");
					sheet1.SpeedDown2Excel(1,false,false,"","",false,false," Expense Code Inquiry");
				}
				break;
			case "btn_Close":		
				self.close();	
				break;
			
		} // end switch
	}
	catch (e){
		if (e == "[object Error]"){
			// 지금은 사용하실 수가 없습니다.
			ComCodeMsgByNoUsed();
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
	
	if(sAction == SEARCHLIST) {		
		var fromCd = combo1.Code;
		var toCd = combo2.Code;		
		if(parseInt(toCd.replace(/-/g, '')) < parseInt(fromCd.replace(/-/g, ''))) {
			// GEM01038	ENG	W	검색값의 범위입력 오류!
			ComShowCodeMessage("GEM01037");
			combo1.focus();
			return false;
		}
	}
	return true;
}

/**
* Expense or Account 관련 Event처리시 선택되는 값에 따라 화면정보가 변경된다.
**/
function setExpnAcctSearch(val) {
	if(val.value=="Y") {
		//expense
		doActionIBSheet(SEARCHLIST01);
	} else {
		// account
		doActionIBSheet(SEARCHLIST02);
	}
}

/**
* 검색 언어 선택시 Expense, Accout, Group Expense의 값을 변경
*/
function isLangCheck(val) {
	if(getColNameValue("sch_expense_gbn") == "Y") {
		// expense
		doActionIBSheet(SEARCHLIST01);
	} else {
		// account
		doActionIBSheet(SEARCHLIST02);
	}
	// group expense
	doActionIBSheet(SEARCHLIST03);
}

//===================================================================================
//Sheet 이벤트 처리
//===================================================================================
/**
 * 셀을 클릭했을때 발생하는 이벤트 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} row     	sheetObj의 선택된 Row
 * @param {ibsheet} col     	sheetObj의 선택된 Col
 **/
function sheet1_OnClick(sheetObj, row, col, value) {
	//alert(sheetObj+"=="+row+"=="+col+"=="+value);
	//desc 셀을 클릭했을때 MemoPad를 표시한다.
	if(sheet1.ColSaveName(col)=="acct_desc") {
		//sheetObj.CellEditable(row, col) = false; 
		//alert(col);
		ComShowMemoPad(sheetObj, row, col, true, 300, 300);
		//sheetObj.CellEditable(row, col) = true;
	}
}

/**
 * 셀을 클릭했을때 MemoPad를 표시한다.
 * @param sheetObj
 * @param row
 * @param col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, row, col){
	//desc 셀을 클릭했을때 MemoPad를 표시한다.
	if(sheet1.ColSaveName(col)=="acct_desc") {
		sheetObj.CellEditable(row, col) = false; 
		//alert(col);
		ComShowMemoPad(sheetObj, row, col, true, 300, 300);
		sheetObj.CellEditable(row, col) = true;

	}
}

/**
 * 선택된 Item이 변경되었을 때 이벤트가 발생한다.
 * @param comboObj
 * @param index_cd
 * @param text
 * @return
 */
function combo1_OnChange(comboObj, index_cd, text) {
	// 다음 포커스로 이동
	combo2.focus();
}

/**
* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
* @param comboObj
* @param index_cd
* @param text
* @return
*/
function combo2_OnChange(comboObj, index_cd, text) {
	// 다음 포커스로 이동
	comFocusChange('document.form.sch_expense_div[0]');
}

/**
* 선택된 Item이 변경되었을 때 이벤트가 발생한다.
* @param comboObj
* @param index_cd
* @param text
* @return
*/
function combo3_OnChange(comboObj, index_cd, text) {
	// 다음 포커스로 이동
	comFocusChange('document.form.sch_tic_cd');
}

function combo1_OnFocus(comboObj, KeyCode, Shift) {
	// 숫6자리만 입력
	if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
		frm.sch_expense_from.value = "";
		comboObj.Text = "";
	}
}

function combo2_OnFocus(comboObj, KeyCode, Shift) {
	// 숫6자리만 입력
	if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
		frm.sch_expense_to.value = "";
		comboObj.Text = "";
	}
}

function combo1_OnKeyUp(comboObj, KeyCode, Shift) {
	// 숫6자리만 입력
	//if(comboObj.Text.length >= 6) return;
	if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
		var sText = comboObj.Text;
		if (comboObj.Text.length == 6) {
			//frm.sch_expense_from.value = sText;
			comboObj.Text = sText.substring(1, sText.length);
			combo2.focus();
		}
	} else { 
		comboObj.Text = ""; 
	}
}


function combo2_OnKeyUp(comboObj, KeyCode, Shift) {
	var sText = comboObj.Text;
	// 숫6자리만 입력
	if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
		if (sText.length == 6) {
			frm.sch_expense_to.value = sText;
			frm.sch_expense_div[0].focus();
		}
	} else {
		comboObj.Text = ""; 
	}
}

function combo3_OnKeyUp(comboObj, KeyCode, Shift) {
	var sText = comboObj.Text;
	// 숫6자리만 입력
	if ((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105) ) {
		if (sText.length == 6) {
			frm.sch_expense_group.value = sText;
			frm.sch_tic_cd.focus();
		}
	} else { 
		comboObj.Text = ""; 
	}
}

/* 개발자 작업 끝 */