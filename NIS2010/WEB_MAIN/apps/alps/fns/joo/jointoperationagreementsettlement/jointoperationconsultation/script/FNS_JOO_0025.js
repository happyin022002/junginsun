/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0025.js
 *@FileTitle : CSR Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.19
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.06.19 박희동
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
 * @class fns_joo_0025 : fns_joo_0025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0025() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix="sheet1_";

var aproFlg = "N";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj1 = sheetObjects[0];

	/*******************************************************/
	var form = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		if (srcName == null || srcName == "gubun") {
			return;
		}
		// class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {

		case "btnCalFr":
			var cal = new ComCalendar();
			cal.setEndFunction("calFr"); 			
			cal.select(form.fr_dt, 'yyyy-MM-dd');
			if(form.crr_cd.GetCount() != 0){
				form.crr_cd.RemoveAll();
			}
			break;

		case "btnCalTo":
			var cal = new ComCalendar();
			cal.setEndFunction("calTo"); 			
			cal.select(form.to_dt, 'yyyy-MM-dd');
			if(form.crr_cd.GetCount() != 0){
				form.crr_cd.RemoveAll();
			}
			break;
			
		case "btn_retrieve":
			doActionIBSheet(sheetObj1, form, IBSEARCH);
			break;

		case "btn_downexcel":
			sheetObj1.SpeedDown2Excel();
			break;

		case "btn_new":
			sheetObj1.RemoveAll();
			form.gubun[0].checked=true;
			form.fr_dt.value = gSysDate;
			form.to_dt.value = gSysDate;
			form.slp_ofc_cd.Index=0;
			form.csr_no.value="";
			
			break;

		case "btn_csr":
			if (sheetObj1.SelectRow == undefined || sheetObj1.SelectRow == null){
				ComShowCodeMessage("JOO00072");
				return;
			}
			if (sheetObj1.LastRow == 0){
				ComShowCodeMessage("JOO00073");
				return;
			}
			var row = sheetObj1.SelectRow;
			
			var csrNo = sheetObj1.CellValue(row, prefix+"csr_no");
			
			if (csrNo == ""){
				ComShowCodeMessage("JOO00074");
				return;
			}

			var param = '?csrNo='+csrNo;
			ComOpenPopup("/hanjin/FNS_JOO_0024.do"+param, 835, 450, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");
			break;
			
		case "btn_save":
			doActionIBSheet(sheetObj1,form,IBSAVE);
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
 * Calendar 선택 후 호출되는 function
 * @return
 */
function calFr(){
	var form = document.form;
	sheetObjects[0].RemoveAll();
	doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
}

/**
 * Calendar 선택 후 호출되는 function
 * @return
 */
function calTo(){
	var form = document.form;
	sheetObjects[0].RemoveAll();
	doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++] = combo_obj;  
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(ofcList) {

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	

	//최초에는 trade만 조회하고 trade변경시에 lane을 읽어온다.
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1, ofcList);
    }
    
    initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var form = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate',   'obj_focus', form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'    ,  form);    
    
    axon_event.addListener  ('keypress', 'csr_no_keypress' , 'csr_no');		
    axon_event.addListener  ('keypress', 'fr_dt_keypress' , 'fr_dt');		
    axon_event.addListener  ('keypress', 'to_dt_keypress' , 'to_dt');		
    axon_event.addListener  ('keyup', 'csr_no_keyup', 'csr_no');	
    axon_event.addListener  ('keyup', 'fr_dt_keyup', 'fr_dt');	
    axon_event.addListener  ('keyup', 'to_dt_keyup', 'to_dt');
//    axon_event.addListener  ('blur', 'fr_dt_blur', 'fr_dt');	
//    axon_event.addListener  ('blur', 'to_dt_blur', 'to_dt');
    axon_event.addListener  ('click', 'change_event_radio', 'gubun');    
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur(){
    ComChkObjValid(event.srcElement);
}

function obj_focus(){
    ComClearSeparator(event.srcElement);
}

function fr_dt_keypress(){
    ComKeyOnlyNumber(document.form.fr_dt);
}

function to_dt_keypress(){
    ComKeyOnlyNumber(document.form.to_dt);
}

function csr_no_keyup(){
	var val = event.srcElement.value;
	var bPop = false;
	if (val.length == 19){
		sheetObjects[0].RemoveAll();
		if (ComIsNumber(val.substring(8,9))){
			bPop = true;
		}
	}else if (val.length == 20){
		sheetObjects[0].RemoveAll();
		bPop = true;
	}
	
	if (bPop){
		var param = '?csrNo='+val;
		ComOpenPopup("/hanjin/FNS_JOO_0068.do"+param, 850, 500, "popupFinish1", "1,0,1,1,1,1,1,1", true);
	} 
}

function csr_no_keypress(){
    //영대문자 자동변환
    ComKeyOnlyAlphabet('uppernum');
    var form = document.form;
    if(form.crr_cd.GetCount() != 0){
    	form.crr_cd.RemoveAll();
	}
}

function change_event_radio(){
	//var src = window.event.srcElement.getAttribute("name")
	sheetObjects[0].RemoveAll();
	var form = document.form;
	doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
	
	if(form.crr_cd.GetCount() != 0){
		form.crr_cd.RemoveAll();
	}
}

function fr_dt_keyup(){
	var form = document.form;
	var frDt = ComReplaceStr(form.fr_dt.value,"-","");
	if (frDt.length == 8){
		sheetObjects[0].RemoveAll();
		doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
	}
	
	if(form.crr_cd.GetCount() != 0){
		form.crr_cd.RemoveAll();
	}
}

function to_dt_keyup(){
	var form = document.form;
	var toDt = ComReplaceStr(form.to_dt.value,"-",""); 
	if (toDt.length == 8){
		sheetObjects[0].RemoveAll();
		doActionIBSheet(sheetObjects[0], form, IBROWSEARCH);
	}
	
	if(form.crr_cd.GetCount() != 0){
		form.crr_cd.RemoveAll();
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "Approval|Register No.|Off-set No.|Issue Date|Effective Date|Cur.|Issue Amount|USD Amount|Issuer|Description|Payment Date";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix+"apro_flg"        , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData,140, daCenter, true, prefix+"csr_no"          , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix+"csr_offst_no"    , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix+"slp_iss_dt"      , false, "", dfDateYmd);
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, prefix+"eff_dt"          , false, "", dfDateYmd);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, prefix+"csr_locl_curr_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 95, daRight , true, prefix+"csr_locl_amt"    , false, "", dfNullFloat, 2);
			InitDataProperty(0, cnt++, dtData, 95, daRight , true, prefix+"usd_locl_amt"    , false, "", dfNullFloat, 2);
			InitDataProperty(0, cnt++, dtData,100, daCenter, true, prefix+"issuer"          , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData,100, daLeft  , true, prefix+"csr_desc"        , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix+"pay_dt"          , false, "", dfNone);
			
		}
		break;

	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo, ofcList) {
    var formObj = document.form
    
    switch(comboNo) {  
    	case 1: 
           with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = true;	
				SetColAlign("left");        
				SetColWidth("30");
 				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=6;
 		    }
            var comboItems = ofcList.split("|");
            
            addComboItem(comboObj, comboItems);

            comboObj.Index2 = 0;
            
            if (comboItems.length == 1){
            	comboObj.Enable = false;
            }else{
            	comboObj.Enable = true;
            }
 			break;
    	case 2: 
    		with (comboObj){
	    		MultiSelect = false;
				UseAutoComplete = true;
				SetColAlign("left");
				SetColWidth("60");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자+숫자만 입력가능
				MaxLength = 3;
    		}
    		break;
 	} 
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	if(!validateForm(sheetObj,formObj,sAction)){
		return false;
	}

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0025GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml);
			break;

		case IBROWSEARCH: //해당 조회조건에 맞는 OFFICE LIST combo로 setting
			comboObjects[0].RemoveAll();

			formObj.f_cmd.value = SEARCHLIST01;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0025GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			var ofcList = ComGetEtcData(sXml,"ofc_list");
			initCombo(comboObjects[0],1, ofcList);
			
//            var comboItems = ofcList.split("|");
//            
//            addComboItem(comboObjects[0], comboItems);
//            comboObjects[0].Index2 = 0;
//            
//            if (comboItems.length == 1){
//            	comboObj.Enable = false;
//            }else{
//            	comboObj.Enable = true;
//            }
			break;

		case IBDOWNEXCEL: // 엑셀내려받기
			sheetObj.SpeedDown2Excel(1);
			break;
		case IBSEARCH_ASYNC02:
			formObj.f_cmd.value = SEARCH30;
			var param = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", param);
			ComXml2ComboItem(sXml, formObj.crr_cd, "code", "name");
			
			formObj.crr_cd.InsertItem(0, "All", " ");
			break;
			
		case IBSAVE:        //저장
		 	if(sheetObj.RowCount == 0) return;
		 	if(aproFlg == "Y") return;
		 	if(!saveConfirm()) return;
 			
		 	formObj.f_cmd.value = MULTI;
		 			 	
	    	var sParam = FormQueryString(formObj);
	    	var sXml = sheetObj.GetSaveXml("FNS_JOO_0025GS.do", sParam);
	    	sheetObj.LoadSearchXml(sXml);
	    	
	        var saveFlag = ComJooGetTrAllValue(sXml);
			
			if (saveFlag == "OK") {
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}	
			
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBROWSEARCH:
			//SELADG 가 아니면 자기 것만 보면 되므로 office list를 가져올 필요 없다.
//			if (gOfcCd != "SELADG"){ 
//				return false;
//			}
			
			var frDt = ComReplaceStr(formObj.fr_dt,"-","");

			if (!ComIsDate(frDt,"ymd")){
				return false;
			}

			var toDt = ComReplaceStr(formObj.to_dt,"-","");

			if (!ComIsDate(toDt,"ymd")){
				return false;
			}
			
			if (ComGetDaysBetween(frDt, toDt) < 0){
				return false;
			}					
			break;
			
		case IBSEARCH: //조회
			var frDt = ComReplaceStr(formObj.fr_dt,"-","");

			var toDt = ComReplaceStr(formObj.to_dt,"-","");

			if (ComGetDaysBetween(frDt, toDt) < 0){
				ComShowCodeMessage("JOO00078");
				formObj.to_dt.focus();
				return false;
			}
			break;
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, errMsg){
	if (sheetObj.RowCount > 0) {
		JooSetBtnClass("P", true); // data가 있으면 CSR Detail과 Print버튼 활성화
		
		form.save_csr_no.value = sheetObj.CellValue(1, prefix+"csr_no");
		 
		if(sheetObj.CellValue(1, prefix+"apro_flg") == "N") aproFlg = "N";
		else aproFlg = "Y";
		
	} else {
		JooSetBtnClass("P", false);// data가 있으면 CSR Detail과 Print버튼 비활성화
	}
}

function sheet1_OnClick(sheetObj, row, col, cellX, cellY, cellW, cellH) {
	 
	 form.save_csr_no.value = sheetObj.CellValue(row, prefix+"csr_no");
	 
	 if(sheetObj.CellValue(row, prefix+"apro_flg") == "N") aproFlg = "N";
	 else aproFlg = "Y";
}

/**
 * double Click 시
 * @param sheetObj
 * @param Row
 * @param Col
 * @param CellX
 * @param CellY
 * @param CellW
 * @param CellH
 * @return
 */
//function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
function sheet1_OnDblClick(sheetObj, Row, Col) {
	var param = '?csrNo='+sheetObj.CellValue(Row, prefix+"csr_no");
	ComOpenPopup("/hanjin/FNS_JOO_0068.do"+param, 850, 500, "popupFinish1", "1,0,1,1,1,1,1,1", true);
}

/**
 * pop up창이 닫혔을때
 * @param arry
 * @return
 */
function popupFinish1(arry){
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

function slp_ofc_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
	var form = document.form;
	if(form.crr_cd.GetCount() != 0){
		form.crr_cd.RemoveAll();
	}
}
function crr_cd_OnFocus(comboObj) {
	var formObj = document.form;
	if (comboObj.GetCount() == 0) {
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[sheetObjects.length - 1], formObj,
				IBSEARCH_ASYNC02);
		comboObj.Enable = true;
	}
}

function saveConfirm() {
	//setTotalAmount('S');
	
	var okYn = ComShowConfirm(ComGetMsg("JOO00217"));
	
	return okYn;
}
/* 개발자 작업  끝 */