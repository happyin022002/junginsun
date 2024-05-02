/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0002.js
 *@FileTitle : Entry and Inquiry of Financial Affairs
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.04.28 박희동
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
 * @class fns_joo_0002 : fns_joo_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0002() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.initCombo = initCombo;
}

/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		if (srcName == null) {
			return;
		}

		//class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;

			case "btn_new":
				UF_reset("");
				break;

			case "btn_save":
				formObj.chg_ofc_gubun.value = "1";				
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
				
			case "btn_changeOfc":
				formObj.chg_ofc_gubun.value = "2";
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;				
				
			case "btn_downExcel":
				sheetObject1.SpeedDown2Excel();
				break;
				
			case "btn_delete1":
				JooRowHideDelete(sheetObject1, "sheet1_del_chk");
				break;

			case "btn_delete2":
				JooRowHideDelete(sheetObject2, "sheet2_del_chk");
				break;
				
			case "btn_create":
				doActionIBSheet(sheetObject1, formObj, IBCREATE);
				break;

			case "btn_pop_car":
				ComOpenPopup("/hanjin/COM_ENS_0N1.do", 450, 455, "popupCrrFinish", "1,0,1,1,1", true, false, 0, 0, 0, "popcrr");				
				break;

			case "btn_pop_customer":
				var param = '';
				ComOpenPopupWithTarget('/hanjin/COM_ENS_041.do', 780, 470, '3:cust_seq|4:cust_lgl_eng_nm', '1,0,0,1', true);
				break;

			case "btn_pop_vendor":
				var param = '';
				ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 780, 455, '2:vndr_seq|4:vndr_lgl_eng_nm', '1,0,1,1,1', true);
				break;
				
			case "delt_flg":
				var check = 0;
				if (formObj.delt_flg.checked){
					formObj.delt_flg.value = "Y";
					check = 1;
				}else{
					formObj.delt_flg.value = "N";
				}

				var arrPrefix = new Array("sheet1_", "sheet2_");
				
				for(var inx=0; inx < 2; inx++){
					for(var jnx=2; jnx <= sheetObjects[inx].LastRow; jnx++){
						sheetObjects[inx].CellValue(jnx, arrPrefix[inx]+"del_chk")=check;
					}
				}				
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
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
function loadPage(trdCombo, currCombo) {
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1, currCombo);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//최초에는 trade만 조회하고 trade변경시에 lane을 읽어온다.
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1, trdCombo);
    }
    
    initControl();
    
    ComBtnDisable("btn_changeOfc");
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
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj);
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj);
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);    
    
    axon_event.addListener  ('keypress', 'cust_seq_keypress' , 'cust_seq');		
    axon_event.addListener  ('keypress', 'vndr_seq_keypress' , 'vndr_seq');		
    axon_event.addListener  ('keypress', 'jo_crr_cd_keypress', 'jo_crr_cd');	
    axon_event.addListener  ('click'   , 'delt_flg_tmp_click', 'delt_flg_tmp');
    
    axon_event.addListener  ('blur'  , 'cust_seq_onblur' , 'cust_seq');
    axon_event.addListener  ('blur'  , 'vndr_seq_onblur' , 'vndr_seq');
    axon_event.addListener  ('blur'  , 'jo_crr_cd_onblur', 'jo_crr_cd');

    UF_reset("");
}

/**
 * Focus를 잃었을 때 -, 등을 추가한다.
 **/
function obj_blur(){
	ComChkObjValid(event.srcElement);
}

/**
 * Focus를 획득했을 때 -, 등을 제거한다.
 * @return
 */
function obj_focus(){
    ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "int":
	        //숫자 만입력하기
	        ComKeyOnlyNumber(event.srcElement);
			break;
		case "float":
	        //숫자+"."입력하기
	        ComKeyOnlyNumber(event.srcElement, ".");
			break;
	}	
}

/**
 * Form Keyup => Enter Key쳤을 때 next focus로 이동
 * @return
 */
function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}

/**
 * delt_flg_tmp click했을 경우
 * @return
 */
function delt_flg_tmp_click(){
	
	formObj = document.form;
	formObj.delt_flg.value = formObj.delt_flg_tmp.checked?"Y":"N";
	
	var delChk = formObj.delt_flg_tmp.checked?"1":"0";
	var bolHid = formObj.delt_flg_tmp.checked?true:false;
	
	var prefix = new Array("sheet1_","sheet2_");
	
	//Delete Mark를 Check했을 경우 Revenue, Expense의 Sheet들을 삭제한 것처럼 처리한다.
	//Uncheck한 경우는 원복처리함
	if (sheetObjects[0].RowCount > 0){
		for (var inx=sheetObjects[0].HeaderRows; inx<=sheetObjects[0].LastRow; inx++){
			sheetObjects[0].CellValue2(inx, prefix[0]+"del_chk") = delChk;
			sheetObjects[0].RowHidden(inx) = bolHid;
		}
	}
	
	if (sheetObjects[1].RowCount > 0){
		for (var inx=sheetObjects[1].HeaderRows; inx<=sheetObjects[1].LastRow; inx++){
			sheetObjects[1].CellValue2(inx, prefix[1]+"del_chk") = delChk;
			sheetObjects[1].RowHidden(inx) = bolHid;
		}
	}
}

/**
 * Carrier Code Pop-up 띄운 후 data 받는 function
 * @param rowArray
 * @return
 */
function popupCrrFinish(rowArray){
	var formObj = document.form;
	var fstArray = rowArray[0];
	var joCrrCd  = fstArray[3];
	//Carrier Code가 3이 아닌 것이 있을 수 있다.
	if (joCrrCd.length != 3){
		ComShowCodeMessage('JOO00002'); //The length of Carrier code in Joint Operation is 3 characters only.
		formObj.jo_crr_cd.focus();
		return;
	}
	
	var oldJoCrrCd = formObj.jo_crr_cd_hid.value;

	//변경이 되었다면 reset
	if (joCrrCd != oldJoCrrCd){
		UF_reset(joCrrCd);		
	}
}

//jo_crr_cd에는 영문 대문자만 입력가능
function jo_crr_cd_keypress() {
    ComKeyOnlyAlphabet('upper');
}

//Carrier 변경시
function jo_crr_cd_onblur(){
    var formObj = document.form;
    var sheetObj = sheetObjects[2];
    
    //기존 Carrier Code와 다른 경우에만 UF_RESET하고 Validation Check를 한다.
    if (formObj.jo_crr_cd_hid.value != formObj.jo_crr_cd.value){    
    	UF_reset(formObj.jo_crr_cd.value);
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    }
}

//Customer 코드 입력시는 영대문자+숫자만 입력가능
function cust_seq_keypress(){
    ComKeyOnlyAlphabet('uppernum');
}

//Vendor 코드 입력시는 숫자만 입력가능
function vndr_seq_keypress(){
    ComKeyOnlyNumber(document.form.vndr_seq);
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo, trdCombo) {
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
 				MaxLength=3;
 		    }
            var comboItems = trdCombo.split("|");
            addComboItem(comboObj, comboItems);           	

 			break; 
 			
    	case 2: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left|left");        
 				SetColWidth("30|0"); //Rlane_cd, auth_cd
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
 				MaxLength=5;
  		    }
  			break; 

    	case 3: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left"); //name, code        
 				SetColWidth("50");
  				DropHeight = 160;
  				ValidChar(2,0);//영문대문자만 입력가능
  				MaxLength=5;
  		    }
			comboObj.RemoveAll();

			var codeItems = joStlOptCd.split("|");
			var nameItems = joStlOptNm.split("|");

			for (var i = 0 ; i < codeItems.length ; i++) {
				comboObj.InsertItem(i, nameItems[i], codeItems[i]);
			}   	
  			break; 
    } 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {

    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			if (sComboObj.id == "rlane_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCHLIST02;
				formObj.super_cd1.value = formObj.trd_cd.Code;
				formObj.code.value = "";
				formObj.super_cd2.value = formObj.jo_crr_cd.value;
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
	            ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code|auth_cd");
			}
														
	        break;
    }
}

//TRADE 변경시 하위 Combo, sheet reset
function trd_cd_OnChange(comboObj, idx_cd, text){
	var formObj = document.form;

	sheetObjects[0].RemoveAll();	
	sheetObjects[1].RemoveAll();
	
	comboObjects[1].Index2 = -1;
	comboObjects[1].RemoveAll();

	formObj.cust_seq.value = "";
	formObj.cust_lgl_eng_nm.value = "";
	formObj.vndr_seq.value = "";
	formObj.vndr_lgl_eng_nm.value = "";
	
	setChangeOfc();	//2014.12.15 민정호	
}

//rlane_cd에 focus가 오면 조건에 해당하는 rlane_cd list를 조회한다.
function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	if (comboObj.GetCount() == 0){
		comboObj.Enable =false;
		doActionIBCombo(sheetObjects[3], formObj ,IBSEARCH , comboObj, "rlane_cd");
		comboObj.Enable =true;
	}
}

//LANE 변경시 reset 
function rlane_cd_OnChange(comboObj, code, text){
	var formObj = document.form;
	

	sheetObjects[0].RemoveAll();	
	sheetObjects[1].RemoveAll();

	formObj.cust_seq.value = "";
	formObj.cust_lgl_eng_nm.value = "";
	formObj.vndr_seq.value = "";
	formObj.vndr_lgl_eng_nm.value = "";
	
	UF_setAuth(comboObj.GetText(code, 1));
}

//Lane의 focus out 시 조회한다.
function rlane_cd_OnBlur(comboObj){
	var formObj = document.form;

	if (comboObj.Code.length == 5)
		doActionIBSheet(sheetObjects[3], formObj, IBSEARCH);
}

//Carrier-Lane별 권한에 따른 button control
function UF_setAuth(auth){
	if (auth == null || auth == undefined){
		auth = "R";
	}
	var editable = true;
	if (auth == "R"){
		editable = false;
	}
	JooSetBtnClass("C", editable);
	for (var i = 0; i < sheetObjects.length; i++) {
		sheetObjects[i].Editable = editable;
	}

	var formObj = document.form;
	formObj.jo_stl_opt_cd.Enable  =  editable;
	formObj.delt_flg_tmp.disabled = !editable;
	formObj.cust_seq.readOnly     = !editable;
	formObj.vndr_seq.readOnly     = !editable;
	
	setChangeOfc();	//2014.12.15 민정호	
}

/**
 * Customer Code OnBlur
 * @return
 */
function cust_seq_onblur(){
	var formObj = document.form;
	
	if (formObj.cust_seq.value.length < 3){
		formObj.cust_lgl_eng_nm.value = "";
	}else{
		//Customer Code는 CUST_CNT_CD||CUST_SEQ 이므로
		//XX99999 이다.
		if (ComIsNumber(formObj.cust_seq.value.substring(0,2))){
			ComShowCodeMessage('JOO00003');
			formObj.cust_seq.value="";
			formObj.cust_seq.focus();
			return;
		}
		if (!ComIsNumber(formObj.cust_seq.value.substring(2))){
			ComShowCodeMessage('JOO00003');
			formObj.cust_seq.value="";
			formObj.cust_seq.focus();
			return;
		}
		
		doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC01);
	}
}

/**
 * Vendor Code OnBlur
 * @return
 */
function vndr_seq_onblur(){
	var formObj = document.form; 
	var vndrSeq = formObj.vndr_seq.value;

	if (vndrSeq.length == 0){
		formObj.vndr_lgl_eng_nm.value = "";
	}else{
		doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_ASYNC02);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo, currCombo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 160;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			var HeadTitle  = "STS||Item|Customer|DR|DR|DR|CR|CR|CR|Full Name|Cur.|PIC|Carrier|Lane|RE|Trade|Office";
			var HeadTitle1 = "STS||Item|Customer|ACCT|Center|City|ACCT|Center|City|Full Name|Cur.|PIC|Carrier|Lane|RE|Trade|Office";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle1, true);

			var prefix = "sheet1_";
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus   ,  0, daCenter, true , prefix+"ibflag"   );
			InitDataProperty(0, cnt++, dtCheckBox ,  0, daCenter, true , prefix+"del_chk"  );
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, true , prefix+"jo_stl_itm_cd" , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, true , prefix+"cust_seq"      , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"dr_acct_cd"    , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"dr_ctr_cd"     , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"dr_loc_cd"     , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"cr_acct_cd"    , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"cr_ctr_cd"     , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"cr_loc_cd"     , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daLeft  , true , prefix+"jo_stl_itm_nm" , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo    ,  0, daCenter, true , prefix+"locl_curr_cd"  , true , "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtData   	 ,  0, daLeft  , true , prefix+"stl_pic_nm"    , false, "", dfNone, 0, false, false);			
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"jo_crr_cd"     , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"rlane_cd"      , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"re_divr_cd"    , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"trd_cd"    , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"ofc_cd"    , false, "", dfNone, 0, false, false);			

			FitColWidth("15|10|20|20|20|20|20|20|20|20|40|20|40|0|0|0|0|0|0");
			InitDataCombo(0, prefix+"locl_curr_cd", currCombo, currCombo);
		}
		break;

	case 2: //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 160;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			var HeadTitle  = "STS||Item|Service\nProvider|DR|DR|DR|CR|CR|CR|Full Name|Cur.|PIC|Carrier|Lane|RE|Trade|Office";
			var HeadTitle1 = "STS||Item|Service\nProvider|ACCT|Center|City|ACCT|Center|City|Full Name|Cur.|PIC|Carrier|Lane|RE|Trade|Office";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle1, true);

			var prefix = "sheet2_";
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus   ,  0, daCenter, true , prefix+"ibflag"   );
			InitDataProperty(0, cnt++, dtCheckBox ,  0, daCenter, true , prefix+"del_chk"  );
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, true , prefix+"jo_stl_itm_cd" , true , "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, true , prefix+"cust_seq"      , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"dr_acct_cd"    , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"dr_ctr_cd"     , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"dr_loc_cd"     , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"cr_acct_cd"    , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"cr_ctr_cd"     , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daCenter, false, prefix+"cr_loc_cd"     , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData     ,  0, daLeft  , true , prefix+"jo_stl_itm_nm" , true , "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo    ,  0, daCenter, true , prefix+"locl_curr_cd"  , true , "", dfNone, 0, true , true );
			InitDataProperty(0, cnt++, dtData   	 ,  0, daLeft  , true , prefix+"stl_pic_nm"    , false, "", dfNone, 0, false, false);			
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"jo_crr_cd"     , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"rlane_cd"      , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"re_divr_cd"    , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"trd_cd"    , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden   ,  0, daLeft  , true , prefix+"ofc_cd"    , false, "", dfNone, 0, false, false);					

			FitColWidth("15|10|20|20|20|20|20|20|20|20|40|20|40|0|0|0|0|0|0");
			InitDataCombo(0, prefix+"locl_curr_cd", currCombo, currCombo);
		}
		break;

	case 3: //sheet3 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
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

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			var HeadTitle = "STS|DEL_CHK|JO_CRR_CD|RLANE_CD|VNDR_SEQ|VNDR_LGL_ENG_NM|CUST_CNT_CD|CUST_SEQ|CUST_LGL_ENG_NM|TRD_CD|DELT_FLG|JO_STL_OPT_CD";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			var prefix = "sheet3_";
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus   , 30, daLeft, false, prefix+"ibflag"         );
			InitDataProperty(0, cnt++, dtCheckBox , 30, daLeft, false, prefix+"del_chk"        );
			InitDataProperty(0, cnt++, dtData     ,100, daLeft, false, prefix+"jo_crr_cd"      );
			InitDataProperty(0, cnt++, dtData     ,100, daLeft, false, prefix+"rlane_cd"       );
			InitDataProperty(0, cnt++, dtData     ,100, daLeft, false, prefix+"vndr_seq"       );
			InitDataProperty(0, cnt++, dtData     ,100, daLeft, false, prefix+"vndr_lgl_eng_nm");
			InitDataProperty(0, cnt++, dtData     ,100, daLeft, false, prefix+"cust_cnt_cd"    );
			InitDataProperty(0, cnt++, dtData     ,100, daLeft, false, prefix+"cust_seq"       );
			InitDataProperty(0, cnt++, dtData     ,100, daLeft, false, prefix+"cust_lgl_eng_nm");
			InitDataProperty(0, cnt++, dtData     ,100, daLeft, false, prefix+"trd_cd"         );
			InitDataProperty(0, cnt++, dtData     , 30, daLeft, false, prefix+"delt_flg"       );
			InitDataProperty(0, cnt++, dtData     , 30, daLeft, false, prefix+"jo_stl_opt_cd"  );
		}
		break;

	case 4: //sheet3 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
		}
		break;
		
	}
}

/**
 * doActionIBSheet
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	if(!validateForm(sheetObj,formObj,sAction)){
		return false;
	}

	switch (sAction) {
		case IBSEARCH: //조회
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.f_cmd.value = SEARCH;
	        var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_");	//prefix 문자열 배열
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0002GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));

			var arrXml = sXml.split("|$$|");

			for(var inx=0; inx<arrXml.length; inx++){
				sheetObjects[inx].LoadSearchXml(arrXml[inx]);
			}
			break;

		case IBCREATE: //생성
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			var aryPrefix = new Array("sheet1_","sheet2_", "sheet3_");
			
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0002GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			
			var arrXml = sXml.split("|$$|");

			for(var inx=0; inx<arrXml.length; inx++){
				sheetObjects[inx].LoadSearchXml(arrXml[inx],false);
			}
			
			//Create했을 경우 첫번째  Currency와 동일하게
			var curr = "";
			for(var inx=sheetObjects[0].HeaderRows; inx<=sheetObjects[0].LastRow; inx++){
				if (curr == "" && sheetObjects[0].RowStatus(inx) =="R"){
					curr=sheetObjects[0].CellValue(inx,aryPrefix[0]+"locl_curr_cd");
					break;
				}
			}

			if (curr == ""){
				for(var inx=sheetObjects[1].HeaderRows; inx<=sheetObjects[1].LastRow; inx++){
					if (curr == "" && sheetObjects[1].RowStatus(inx) =="R"){
						curr=sheetObjects[1].CellValue(inx,aryPrefix[1]+"locl_curr_cd");
						break;
					}
				}
			}

			for(var inx=sheetObjects[0].HeaderRows; inx<=sheetObjects[0].LastRow; inx++){
				if (sheetObjects[0].RowStatus(inx) == "I"){
					sheetObjects[0].CellValue2(inx,aryPrefix[0]+"locl_curr_cd") = curr;
				}
			}
			
			for(var inx=sheetObjects[1].HeaderRows; inx<=sheetObjects[1].LastRow; inx++){
				if (sheetObjects[1].RowStatus(inx) == "I"){
					sheetObjects[1].CellValue2(inx,aryPrefix[1]+"locl_curr_cd") = curr;
				}
			}
			
			break;
						
		case IBSAVE:        //저장
			var chgOfcGubun = formObj.chg_ofc_gubun.value;		//2014.12.15 민정호			
			if(chgOfcGubun == '2'){								
				var prefix1="sheet1_";
				var prefix2="sheet2_";

				for (var inx=sheetObjects[0].HeaderRows; inx<=sheetObjects[0].LastRow; inx++){
					
					sheetObjects[0].RowHidden(inx) = false					
					sheetObjects[0].CellValue2(inx, prefix1+"ibflag") = "U";
				}

				for (var inx=sheetObjects[1].HeaderRows; inx<=sheetObjects[1].LastRow; inx++){
					sheetObjects[1].RowHidden(inx) = false					
					sheetObjects[1].CellValue2(inx, prefix2+"ibflag") = "U";
				}												
			}
			
			var SaveStr = ComGetSaveString(sheetObjects);			

			if (SaveStr == ""){
				ComShowCodeMessage('JOO00036'); //저장할 데이타가 없음
				return;
			}

			
			//저장할것인가?
			if (!ComShowCodeConfirm('JOO00046')){
				if(chgOfcGubun == '2'){		
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
				return;
			}

			var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_");	//prefix 문자열 배열

			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0002GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
					
			break;
	
		case IBSEARCH_ASYNC01: //Customer 명 읽어오기
			formObj.f_cmd.value = SEARCHLIST04;
			formObj.code.value = formObj.cust_seq.value;
			formObj.super_cd1.value = "";
			formObj.super_cd2.value = "";
			
	        var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
	        var custNm = ComGetEtcData(sXml,"cust_lgl_eng_nm");
	        if (custNm == undefined || custNm == null || ComTrim(custNm) == ''){
	        	ComShowCodeMessage("JOO00003");
				formObj.cust_lgl_eng_nm.value = ""; 
				formObj.cust_seq.value = ""; 
				formObj.cust_seq.focus();
	        }else{
				formObj.cust_seq.value = ComGetEtcData(sXml,"cust_seq"); 
				formObj.cust_lgl_eng_nm.value = custNm; 
				formObj.vndr_seq.focus();
	        }
	        break;

		case IBSEARCH_ASYNC02: //Vendor 명 읽어오기
			formObj.f_cmd.value = SEARCHLIST05;
			formObj.code.value = formObj.vndr_seq.value;
			formObj.super_cd1.value = "";
			formObj.super_cd2.value = "";
	        var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
	        var vndrNm = ComGetEtcData(sXml,"vndr_lgl_eng_nm");
	        if (vndrNm == undefined || vndrNm == null || ComTrim(vndrNm) == ''){
	        	ComShowCodeMessage("JOO00147");
				formObj.vndr_lgl_eng_nm.value = ""; 
				formObj.vndr_seq.value = ""; 
				formObj.vndr_seq.focus();
	        }else{
				formObj.vndr_seq.value = ComGetEtcData(sXml,"vndr_seq"); 
				formObj.vndr_lgl_eng_nm.value = vndrNm;
	        }
	        
	        break;

		case IBSEARCH_ASYNC03: //Carrier유효성 체크
			formObj.f_cmd.value = SEARCHLIST12;
			formObj.super_cd1.value = ""; 
			formObj.code.value = formObj.jo_crr_cd.value;
			formObj.super_cd2.value = "";
			
			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

			var check = ComGetEtcData(sXml, "CHECK");
			
			if (check == "E"){
				ComShowMessage(ComGetEtcData(sXml, "CHKMSG"));
				formObj.jo_crr_cd.value="";
				formObj.jo_crr_cd_hid.value = "";
				formObj.jo_crr_cd.focus();
			}else{
				formObj.jo_crr_cd_hid.value = formObj.jo_crr_cd.value; 
				formObj.trd_cd.focus();
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
		case IBCREATE: //저장용 조회
			if (formObj.jo_crr_cd.value.length < 3){
				ComShowCodeMessage('JOO00008'); //Select a Carrier code
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Index == -1){
				ComShowCodeMessage('JOO00009'); //Select a Trade code
				formObj.trd_cd.focus(); 
				return false;
			}

			if (formObj.rlane_cd.Index == -1){
				ComShowCodeMessage('JOO00010'); //Select a Revenue Lane code
				formObj.rlane_cd.focus();
				return false;
			}

			if (formObj.jo_stl_opt_cd.Index == -1){
				ComShowCodeMessage('JOO00133'); //Select a settlement option
				formObj.jo_stl_opt_cd.focus();
				return false;
			}
			
			if (formObj.delt_flg_tmp.checked){
				ComShowCodeMessage('JOO00004');//("If you want to create accounts, uncheck the delete mark...");
				formObj.delt_flg_tmp.focus();
				return false;
			}
			
			//Customer, Vendor 둘다 null 인 경우는 안됨
			if (formObj.cust_seq.value.length < 3 && formObj.vndr_seq.value.length < 1){
				ComShowCodeMessage('JOO00005');//("You should input one at least, either Customer or Vendor...");
				formObj.cust_seq.focus();
				return false;
			}
			break;
			
		case IBSAVE:   //저장
			if (formObj.jo_crr_cd.value.length < 3){
				ComShowCodeMessage('JOO00008'); //Select a Carrier code
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Index == -1){
				ComShowCodeMessage('JOO00009'); //Select a Trade code
				formObj.trd_cd.focus(); 
				return false;
			}

			if (formObj.rlane_cd.Index == -1){
				ComShowCodeMessage('JOO00010'); //Select a Revenue Lane code
				formObj.rlane_cd.focus();
				return false;
			}

			if (formObj.jo_stl_opt_cd.Index == -1){
				ComShowCodeMessage('JOO00133'); //Select a settlement option
				formObj.jo_stl_opt_cd.focus();
				return false;
			}
			
			//Customer, Vendor 둘다 null 인 경우는 안됨
			if (formObj.cust_seq.value.length < 3 && formObj.vndr_seq.value.length < 1){
				ComShowCodeMessage('JOO00005');//("You should input one at least, either Customer or Vendor...");
				formObj.cust_seq.focus();
				return false;
			}

			if ((formObj.cust_seq.value.length != 0) && (formObj.cust_lgl_eng_nm.value.length == 0)){
				ComShowCodeMessage('JOO00006');//("Check the Validation of Customer Code");
				formObj.cust_seq.focus();
				return false;
			}
			if ((formObj.vndr_seq.value.length != 0) && (formObj.vndr_lgl_eng_nm.value.length == 0)){
				ComShowCodeMessage('JOO00007');//("Check the Validation of Vendor Code");
				formObj.vndr_seq.focus();
				return false;
			}
			if (existsUnDelRows(sheetObjects[0], "sheet1_")){
				ComShowCodeMessage('JOO00079');
				return false;
			}
			if (existsUnDelRows(sheetObjects[1], "sheet2_")){
				ComShowCodeMessage('JOO00079');
				return false;
			}

			if (sheetObjects[0].RowCount > 0){
				for(var inx=sheetObjects[0].HeaderRows; inx<=sheetObjects[0].LastRow; inx++){
					var rowStatus = sheetObjects[0].RowStatus(inx); 
					if (rowStatus == "D" || rowStatus == "R")
						continue;
					
					var drCntr = sheetObjects[0].CellValue(inx, "sheet1_dr_ctr_cd");
					if (ComTrim(drCntr) == ""){
						ComShowCodeMessage("JOO00019", (inx-sheetObjects[0].HeaderRows+1) + "th DR Center Code");
						sheetObjects[0].SelectCell(inx, "sheet1_dr_ctr_cd", true);
						return false;
					}

					var drLoc = sheetObjects[0].CellValue(inx, "sheet1_dr_loc_cd");
					if (ComTrim(drLoc) == ""){
						ComShowCodeMessage("JOO00019", (inx-sheetObjects[0].HeaderRows+1) + "th DR Local Code");
						sheetObjects[0].SelectCell(inx, "sheet1_dr_loc_cd", true);
						return false;
					}

					var crCntr = sheetObjects[0].CellValue(inx, "sheet1_cr_ctr_cd");
					if (ComTrim(crCntr) == ""){
						ComShowCodeMessage("JOO00019", (inx-sheetObjects[0].HeaderRows+1) + "th CR Center Code");
						sheetObjects[0].SelectCell(inx, "sheet1_cr_ctr_cd", true);
						return false;
					}

					var crLoc = sheetObjects[0].CellValue(inx, "sheet1_cr_loc_cd");
					if (ComTrim(crLoc) == ""){
						ComShowCodeMessage("JOO00019", (inx-sheetObjects[0].HeaderRows+1) + "th CR Local Code");
						sheetObjects[0].SelectCell(inx, "sheet1_cr_loc_cd", true);
						return false;
					}
					
					var currency = sheetObjects[0].CellValue(inx, "sheet1_locl_curr_cd");
					if (currency == ""){
						ComShowCodeMessage('JOO00114',inx-sheetObjects[0].HeaderRows+1);
						sheetObjects[0].SelectCell(inx, "sheet1_locl_curr_cd", true);
						return false;
					}
				}
			}

			if (sheetObjects[1].RowCount > 0){
				for(var inx=sheetObjects[1].HeaderRows; inx<=sheetObjects[1].LastRow; inx++){
					var rowStatus = sheetObjects[1].RowStatus(inx); 
					if (rowStatus == "D" || rowStatus == "R")
						continue;

					var drCntr = sheetObjects[1].CellValue(inx, "sheet2_dr_ctr_cd");
					if (ComTrim(drCntr) == ""){
						ComShowCodeMessage("JOO00019", (inx-sheetObjects[1].HeaderRows+1) + "th DR Center Code");
						sheetObjects[1].SelectCell(inx, "sheet2_dr_ctr_cd", true);
						return false;
					}

					var drLoc = sheetObjects[1].CellValue(inx, "sheet2_dr_loc_cd");
					if (ComTrim(drLoc) == ""){
						ComShowCodeMessage("JOO00019", (inx-sheetObjects[1].HeaderRows+1) + "th DR Local Code");
						sheetObjects[0].SelectCell(inx, "sheet2_dr_loc_cd", true);
						return false;
					}

					var crCntr = sheetObjects[1].CellValue(inx, "sheet2_cr_ctr_cd");
					if (ComTrim(crCntr) == ""){
						ComShowCodeMessage("JOO00019", (inx-sheetObjects[1].HeaderRows+1) + "th CR Center Code");
						sheetObjects[1].SelectCell(inx, "sheet2_cr_ctr_cd", true);
						return false;
					}

					var crLoc = sheetObjects[1].CellValue(inx, "sheet2_cr_loc_cd");
					if (ComTrim(crLoc) == ""){
						ComShowCodeMessage("JOO00019", (inx-sheetObjects[1].HeaderRows+1) + "th CR Local Code");
						sheetObjects[0].SelectCell(inx, "sheet2_cr_loc_cd", true);
						return false;
					}
					
					var currency = sheetObjects[1].CellValue(inx, "sheet2_locl_curr_cd");
					if (currency == ""){
						ComShowCodeMessage('JOO00114',inx-sheetObjects[1].HeaderRows+1);
						sheetObjects[1].SelectCell(inx, "sheet2_locl_curr_cd", true);
						return false;
					}
				}
			}
			// Input 내용을 Sheet에 setting한다.
			UF_setInputToSheet();
			break;
			
			
		case IBSEARCH: //조회
			if (formObj.jo_crr_cd.value.length < 3){
				ComShowCodeMessage('JOO00008'); //Select a Carrier code
				formObj.jo_crr_cd.focus();
				return false;
			}

			if (formObj.trd_cd.Index == -1){
				ComShowCodeMessage('JOO00009'); //Select a Trade code
				formObj.trd_cd.focus(); 
				return false;
			}

			if (formObj.rlane_cd.Index == -1){
				ComShowCodeMessage('JOO00010'); //Select a Revenue Lane code
				formObj.rlane_cd.focus();
				return false;
			}
			break;
	}
	return true;
}

//sheet1_OnChange
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var prefix="sheet1_";
	//Currency Code가 변경되었을 경우 모든 sheet의 모든 data에 적용한다.
	if (sheetObj.ColSaveName(Col)== prefix+"locl_curr_cd"){
		setCurVal(Value);
	} 
}

//sheet2_OnChange
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var prefix="sheet2_";
	//Currency Code가 변경되었을 경우 모든 sheet의 모든 data에 적용한다.
	if (sheetObj.ColSaveName(Col)== prefix+"locl_curr_cd"){
		setCurVal(Value);
	}
}

/**
 * Currency setting
 * @param Value
 * @return
 */
function setCurVal(Value){
	var prefix1="sheet1_";
	var prefix2="sheet2_";

	for (var inx=sheetObjects[0].HeaderRows; inx<=sheetObjects[0].LastRow; inx++){
		if (sheetObjects[0].CellValue(inx, prefix1+"jo_stl_itm_cd") != "")
			if (sheetObjects[0].CellValue(inx, prefix1+"locl_curr_cd") != Value)
				sheetObjects[0].CellValue2(inx, prefix1+"locl_curr_cd") = Value;
	}

	for (var inx=sheetObjects[1].HeaderRows; inx<=sheetObjects[1].LastRow; inx++){
		if (sheetObjects[1].CellValue(inx, prefix2+"jo_stl_itm_cd") != "")
			if (sheetObjects[1].CellValue(inx, prefix2+"locl_curr_cd") != Value)
				sheetObjects[1].CellValue2(inx, prefix2+"locl_curr_cd") = Value;
	}
}

/**
 * Carrier정보의 Sheet내용을 input text에 display한다.
 * @return
 */
function UF_setSheetToInput(){
	var sheet = sheetObjects[2];
	var form  = document.form;
	var row   = sheet.RowCount;
	var prefix="sheet3_";

	if (row == 0) {
		form.jo_stl_opt_cd.Index   = -1;
		form.delt_flg.value        = "N";
		form.delt_flg_tmp.value    = "N";
		form.delt_flg_tmp.checked  = false;
		form.cust_seq.value        = "";
		form.cust_lgl_eng_nm.value = "";
		form.vndr_seq.value        = "";
		form.vndr_lgl_eng_nm.value = "";

		//입력될 수 있게 row add해둔다.
		sheet.DataInsert(-1);
	}else{
		form.jo_crr_cd_hid.value   = sheet.CellValue(row, prefix+"jo_crr_cd");
		form.jo_stl_opt_cd.Code    = sheet.CellValue(row, prefix+"jo_stl_opt_cd");
		form.delt_flg.value        = sheet.CellValue(row, prefix+"delt_flg");
		var custCntCd = sheet.CellValue(row, prefix+"cust_cnt_cd");
		var custSeq   = sheet.CellValue(row, prefix+"cust_seq");
		form.cust_seq.value = custCntCd + custSeq;
		form.cust_lgl_eng_nm.value = sheet.CellValue(row, prefix+"cust_lgl_eng_nm");
		form.vndr_seq.value        = sheet.CellValue(row, prefix+"vndr_seq");
		form.vndr_lgl_eng_nm.value = sheet.CellValue(row, prefix+"vndr_lgl_eng_nm");
		
		var deltFlg = sheet.CellValue(row, prefix+"delt_flg");
		form.delt_flg_tmp.value = deltFlg;
		if (deltFlg == "Y")
			form.delt_flg_tmp.checked = true;
		else
			form.delt_flg_tmp.checked = false;
	}

	setChangeOfc();	//2014.12.15 민정호	
}

/**
 * Carrier정보 Input내용을 Sheet에 setting한다.
 * @return
 */
function UF_setInputToSheet(){
	var sheet = sheetObjects[2];

	var form  = document.form;
	var row   = sheet.LastRow;
	var prefix="sheet3_";
	
	sheet.CellValue(row, prefix+"jo_crr_cd"      ) = form.jo_crr_cd.value      ;
	sheet.CellValue(row, prefix+"trd_cd"         ) = form.trd_cd.Code          ;
	sheet.CellValue(row, prefix+"rlane_cd"       ) = form.rlane_cd.Code        ;
	sheet.CellValue(row, prefix+"jo_stl_opt_cd"  ) = form.jo_stl_opt_cd.Code   ;
	sheet.CellValue(row, prefix+"delt_flg"       ) = form.delt_flg_tmp.checked?"Y":"N";
	if (form.cust_seq.value.length > 2){
		sheet.CellValue(row, prefix+"cust_cnt_cd") = form.cust_seq.value.substring(0,2);
		sheet.CellValue(row, prefix+"cust_seq"   ) = form.cust_seq.value.substring(2);
	}else{
		sheet.CellValue(row, prefix+"cust_cnt_cd") = form.cust_seq.value;
		sheet.CellValue(row, prefix+"cust_seq"   ) = form.cust_seq.value;
	}
	sheet.CellValue(row, prefix+"cust_lgl_eng_nm") = form.cust_lgl_eng_nm.value;
	sheet.CellValue(row, prefix+"vndr_seq"       ) = form.vndr_seq.value       ;
	sheet.CellValue(row, prefix+"vndr_lgl_eng_nm") = form.vndr_lgl_eng_nm.value;
	
	setChangeOfc();	//2014.12.15 민정호	
}
/**
 * Sheet3 조회완료 후
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
	UF_setSheetToInput();
}

/**
 * Reset 
 * @param joCrrCd
 * @return
 */
function UF_reset(joCrrCd){
	
	if (joCrrCd == undefined || joCrrCd == null){
		joCrrCd = "";
	}
	var formObj = document.form;
	
	sheetObjects[0].RemoveAll();	
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[2].DataInsert(-1);

	comboObjects[0].Index2=-1;
	comboObjects[1].Index2=-1;
	comboObjects[1].RemoveAll();
	comboObjects[2].Index2=-1;

	UF_setSheetToInput();
	formObj.jo_crr_cd.value = joCrrCd;
	
	if (joCrrCd == ""){
	    formObj.jo_crr_cd.focus();
	}else{
		formObj.trd_cd.focus();
	}
	
	setChangeOfc();	//2014.12.15 민정호	
}

/**
 * setChangeOfc 
 * @param 
 * @return
 */
function setChangeOfc(){
		
	var formObj = document.form;
	
	var ofc_cd = formObj.ofc_cd.value;
	var jo_crr_cd = formObj.jo_crr_cd.value;
	var trd_cd = comboObjects[0].Text;
	var rlane_cd = 	comboObjects[1].Text;
	
	/*
	alert("ofc_cd = "+ofc_cd+"\n"+
			"jo_crr_cd = "+jo_crr_cd+"\n"+
			"trd_cd = "+trd_cd+"\n"+
			"rlane_cd = "+rlane_cd+"\n"
			);
	*/	
	
	/*
SINWA	SINRS	서남아 Sub지역그룹
SINWSG	SINRSS	영업팀 
	 */
	if(ofc_cd == "SINRS" || ofc_cd == "SINRSS" || ofc_cd == "SELADG" ){
		if(jo_crr_cd == "XPR" && trd_cd == "IAS" && rlane_cd == "LCFIA"){
			ComBtnEnable("btn_changeOfc");			
		}else{
			ComBtnDisable("btn_changeOfc");			
		}
	}else{
		ComBtnDisable("btn_changeOfc");		
	}

}
/* 개발자 작업  끝 */