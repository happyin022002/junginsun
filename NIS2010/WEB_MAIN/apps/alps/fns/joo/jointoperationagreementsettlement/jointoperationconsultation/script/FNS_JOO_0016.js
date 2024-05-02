/*================================================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0016.js
 *@FileTitle : Combined Monthly Clearance Creation & Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.23
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.07.23 박희동
 * 1.0 Creation
 * -------------------------------------------------------------------------------
 * History
 * 2010.09.03 이준범 [CHM-201005738-01] Combined MCS creation 화면에 Print 버튼 추가 요청
 *            rdOpen(), setQueryStr() Function 추가
 * 2012.02.28 조병연 [CHM-20121640001][ALPS JOO] Account Month가 Closing된 후 Save 및 Delete 기능 비활성화 
 * - Account Month가 Closing된 이후에는 Data 생성 및 삭제 기능들이 비활성화되도록 Logic 추가
 * - 현재 AP Closing Time을 기준으로 하는것을 AR Closing Time으로 변경 (쿼리 변경)
 * - Save, Delete 버튼 비활성화
 *            
=================================================================================*/
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
 * @class FNS_JOO_0016 : FNS_JOO_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0016() {
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
//공통전역변수 
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

var aryPrefix = new Array("sheet1_","sheet2_");

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObj = document.form;
    var rdObject = rdObjects[0];
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		if (srcName == null || srcName == undefined) return;
		
		switch (srcName) {
			case "btns_back":
		    	sheetObjects[0].RemoveAll();
		    	sheetObjects[1].RemoveAll();
				if (formObj.acct_yrmon.value!=""){
					formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M",-1).substring(0,7);
				}
				
				UF_resetCondition();
				formObj.jo_crr_cd.focus();
				//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
				break;
	
			case "btns_next":
				sheetObjects[0].RemoveAll();
		    	sheetObjects[1].RemoveAll();
				if (formObj.acct_yrmon.value!=""){
					formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M", 1).substring(0,7);
				}
				UF_resetCondition();
				formObj.jo_crr_cd.focus();
				//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
				break;
	
			case "btn_del":
				doActionIBSheet(sheetObject1, formObj, IBDELETE);
				break;
				
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
	
			case "btn_new":
				UF_resetCondition();
				UF_resetSheets();
				formObj.acct_yrmon.focus();
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObject2, formObj, IBSAVE);
				break;
	
			case "btn_downexcel":
				sheetObject2.SpeedDown2Excel();
				break;
					
			case "btn_print":
				rdOpen(formObj);
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
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
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
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);    

    axon_event.addListener  ('keypress', 'acct_yrmon_keypress', 'acct_yrmon');	
    
    formObj.acct_yrmon.focus();
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur(){
	var formObj = document.form;
	ComChkObjValid(event.srcElement);
    
    if (event.srcElement.name == "acct_yrmon"){
    	sheetObjects[0].RemoveAll();
    	sheetObjects[1].RemoveAll();
    	
		//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC10);
		UF_resetCondition();
    	
    }
}

function obj_focus(){
    ComClearSeparator(event.srcElement);
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}

function acct_yrmon_keypress(){
	ComKeyOnlyNumber(this, '');
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
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	
	           //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 3, 100);
	
				var HeadTitle  = "Lane|CFM|AUTH";
	            var headCount = ComCountHeadTitle(HeadTitle);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false);
	
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle, true);
	
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtData    , 55, daCenter,  true, aryPrefix[0]+"rlane_cd"    ,false,"",dfNone, 0, false, false);
	            InitDataProperty(0, cnt++ , dtCheckBox, 30, daCenter,  true, aryPrefix[0]+"cmb_cfm_flg" ,false,"",dfNone, 0,  true, true );
	            InitDataProperty(0, cnt++ , dtHidden  , 30, daCenter,  true, aryPrefix[0]+"stl_dup_flg" ,false,"",dfNone, 0,  true, true );
			}
			break;
		
		case 2: //t1sheet1 init
			with (sheetObj) {
	            // 높이 설정
	            style.height = 400;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	
	           //전체Edit 허용 여부 [선택, Default false]
	            Editable = false;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 2, 1, 3, 100);
	
				var HeadTitle  = "STS|Lane|Item|BSA Type|Cur.|SML|SML|SML|SML|Partner|Partner|Partner|Partner|Remark|ACCT_YRMON|JO_CRR_CD|RE_DIVR_CD|STL_VVD_SEQ|STL_SEQ";
	            var HeadTitle1 = "STS|Lane|Item|BSA Type|Cur.|VVD|BSA|Price|Amount|VVD|BSA|Price|Amount|Remark|ACCT_YRMON|JO_CRR_CD|RE_DIVR_CD|STL_VVD_SEQ|STL_SEQ";
	            var headCount = ComCountHeadTitle(HeadTitle);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false);
	
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle , true);
	            InitHeadRow(1, HeadTitle1, true);

	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtHiddenStatus ,  0, daCenter,  true, aryPrefix[1]+"ibflag"); //
	            InitDataProperty(0, cnt++ , dtData         , 70, daCenter,  true, aryPrefix[1]+"rlane_cd"      ,false,"",dfNone);
	            InitDataProperty(0, cnt++ , dtData         , 40, daCenter,  true, aryPrefix[1]+"jo_stl_itm_cd" ,false,"",dfNone);
	            InitDataProperty(0, cnt++ , dtCombo        , 90, daLeft  ,  true, aryPrefix[1]+"jo_stl_jb_cd"  ,false,"",dfNone);
	            InitDataProperty(0, cnt++ , dtData         , 35, daCenter,  true, aryPrefix[1]+"locl_curr_cd"  ,false,"",dfNone);
	            InitDataProperty(0, cnt++ , dtData         , 80, daCenter, false, aryPrefix[1]+"r_vvd"         ,false,"",dfNone);
	            InitDataProperty(0, cnt++ , dtData         , 50, daRight , false, aryPrefix[1]+"r_bsa_qty"     ,false,"",dfNullInteger);
	            InitDataProperty(0, cnt++ , dtData         , 70, daRight , false, aryPrefix[1]+"r_bsa_slt_prc" ,false,"",dfNullFloat  ,2);
	            InitDataProperty(0, cnt++ , dtAutoSum      ,100, daRight , false, aryPrefix[1]+"r_stl_locl_amt",false,"",dfNullFloat  ,2);
	            InitDataProperty(0, cnt++ , dtData         , 80, daCenter, false, aryPrefix[1]+"e_vvd"         ,false,"",dfNone);
	            InitDataProperty(0, cnt++ , dtData         , 50, daRight , false, aryPrefix[1]+"e_bsa_qty"     ,false,"",dfNullInteger);
	            InitDataProperty(0, cnt++ , dtData         , 70, daRight , false, aryPrefix[1]+"e_bsa_slt_prc" ,false,"",dfNullFloat  ,2);
	            InitDataProperty(0, cnt++ , dtAutoSum      , 90, daRight , false, aryPrefix[1]+"e_stl_locl_amt",false,"",dfNullFloat  ,2);
	            InitDataProperty(0, cnt++ , dtData         ,100, daCenter, true, aryPrefix[1]+"remark"        ,false,"",dfNone);

	            InitDataProperty(0, cnt++ , dtHidden       ,  0, daLeft  , false, aryPrefix[1]+"acct_yrmon");
	            InitDataProperty(0, cnt++ , dtHidden       ,  0, daLeft  , false, aryPrefix[1]+"jo_crr_cd");
	            InitDataProperty(0, cnt++ , dtHidden       ,  0, daLeft  , false, aryPrefix[1]+"re_divr_cd");
	            InitDataProperty(0, cnt++ , dtHidden       ,  0, daLeft  , false, aryPrefix[1]+"stl_vvd_seq");
	            InitDataProperty(0, cnt++ , dtHidden       ,  0, daLeft  , false, aryPrefix[1]+"stl_seq");

	            InitDataCombo(0, aryPrefix[1]+"jo_stl_jb_cd", gStlComnm    , gStlCombo);
			}
			break;

		case 3: //t1sheet1 init
			sheetObj.style.height = 0;
			break;
		}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {

	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {
		case IBSEARCH: //조회
			UF_resetSheets();
			formObj.rlane_cd.value = UF_getSeletedRlane();
			
			//Combined No를 선택하지 않으면 RLANE List만 조회
			if (formObj.stl_cmb_seq.Code == ""){
				formObj.f_cmd.value = SEARCHLIST01;
				var sXml = sheetObjects[0].GetSearchXml("FNS_JOO_0016GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix[0]));
				sheetObjects[0].LoadSearchXml(sXml);
			//Combined No를 선택하면 RLANE List 와 Settlement를 동시에 조회
			}else{
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObjects[0].GetSearchXml("FNS_JOO_0016GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml = sXml.split("|$$|");
				for(var inx=0; inx<arrXml.length; inx++){
					sheetObjects[inx].LoadSearchXml(arrXml[inx]);
				}
			}

			break;

			//RLANE 선택시 COMBINED정보 조회
		case IBSEARCH_ASYNC01:
			formObj.f_cmd.value = SEARCHLIST02;
			var sXml = sheetObjects[1].GetSearchXml("FNS_JOO_0016GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix[1]));
			sheetObjects[1].LoadSearchXml(sXml);
			break;
			
		case IBSAVE: //저장
			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}
			formObj.rlane_cd.value = UF_getSeletedRlane();
			formObj.f_cmd.value = MULTI;
			var SaveStr = ComGetSaveString(sheetObjects[1]);

			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);			
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0016GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix[1]));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
			
			//STL_CMB_SEQ를 다시 조회해서 마지막 index를 선택해서 조회한다.
			doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[3] ,"stl_cmb_seq1");			
			break;

		case IBDELETE: // Combined된 자료중에 아직 Slip을 끊지 않은 것을 combined해제한다.
			if (!ComShowCodeConfirm("JOO00061")){
				return;
			}
			
			formObj.f_cmd.value = REMOVE;
			var SaveStr = ComGetSaveString(sheetObjects[1], true, true);
			
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0016GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix[1]));			
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);

			//STL_CMB_SEQ를 다시 조회해서 마지막 index를 선택해서 조회한다.
			doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[3] ,"stl_cmb_seq2");			
			break;
			
		case IBSEARCH_ASYNC10: //마감여부 조회
			formObj.f_cmd.value = SEARCH10;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0016GS.do", FormQueryString(formObj));
			
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				gClzYn = ComGetEtcData(sXml,"clz_yn"); 
				if (gClzYn == "C"){
					//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
					//ComShowCodeMessage("JOO00177");
					JooSetBtnClass("D", false);		// Delete
					JooSetBtnClass("S", false);		// Save
					sheetObjects[0].Editable = false;
					
				//Open상태면 Authority에 따라 Button을 활성화, 비활성화 한다.
				}else{
					JooSetBtnClass("D", true);		// Delete
					JooSetBtnClass("S", true);		// Save
					sheetObjects[0].Editable = true;
				}
			}
			
			break;
			
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
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
            var comboItems = gCrrCombo.split("|");
            addComboItem(comboObj, comboItems);           	
 			break; 
 			
    	case 2: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=3;
  		    }
  			break;
  			
    	case 3: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("50");
  				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
 				MaxLength=7;
  		    }
			comboObj.RemoveAll();
			comboObj.InsertItem(0, "","");
			comboObj.InsertItem(1, "EXPENSE","E");
			comboObj.InsertItem(2, "REVENUE","R");
  			break;

    	case 4: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left|left");        
 				SetColWidth("30|0");
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
  		    }
  			break;
 	} 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			//if(validateForm(sheetObj,formObj,sAction))
			if (sComboObj.id == "trd_cd") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
				comboObjects[3].RemoveAll();
									
				formObj.f_cmd.value = SEARCHLIST17;
				formObj.code.value = "";
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = formObj.acct_yrmon.value; //Item
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

				//Trade setting
				var comboItems = (",|"+ComGetEtcData(sXml, sComboKey)).split("|"); 
				addComboItem(sComboObj,comboItems);

				//Combined No.
				var codeList = ComGetEtcData(sXml, "combined_no").split("|");
				var nameList = ComGetEtcData(sXml, "slip_no").split("|");
				if (codeList.length == 1 && codeList[0] == ""){
					comboObjects[3].InsertItem(0, " | ", " ");
				}else{
					comboObjects[3].InsertItem(0, " | ", " ");
					for(var i=1; i <=codeList.length; i++){
						comboObjects[3].InsertItem(i, codeList[i-1]+"|"+nameList[i-1], codeList[i-1]);
					}
				}
				
				//formObj.trd_cd.focus();
			}
			else if (sComboObj.id == "stl_cmb_seq") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCHLIST18;
				formObj.code.value = "";
				formObj.name.value = formObj.trd_cd.Code;
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = formObj.acct_yrmon.value; //Item
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

				//Combined No.
				var codeList = ComGetEtcData(sXml, "combined_no").split("|");
				var nameList = ComGetEtcData(sXml, "slip_no").split("|");
				if (codeList.length == 1 && codeList[0] == ""){
					comboObjects[3].InsertItem(0, " | ", " ");
				}else{
					comboObjects[3].InsertItem(0, " | ", " ");
					for(var i=1; i <=codeList.length; i++){
						comboObjects[3].InsertItem(i, codeList[i-1]+"|"+nameList[i-1], codeList[i-1]);
					}
				}
				//formObj.stl_cmb_seq.focus();
				
				//save후 stl_cmb_seq를 refresh하고 마지막 stl_cmb_seq를 조회조건으로 조회한다.
				if (sComboKey=="stl_cmb_seq1"){
					sComboObj.Index2 = sComboObj.GetCount()-1;
					comboObjects[1].Index2 = -1;
					comboObjects[2].Index2 = -1;
					comboObjects[1].Enable = false;
					comboObjects[2].Enable = false;
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				//delete후 stl_cmb_seq를 refresh하고 stl_cmb_seq를 선택하지 않고  조회한다.
				}else if (sComboKey=="stl_cmb_seq2"){
					sComboObj.Index2 = -1;
					comboObjects[1].Enable = true;
					comboObjects[2].Enable = true;
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
			}

	        break;
    }
}

function UF_resetSheets(){
	var formObj = document.form;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	formObj.bal_jo_crr_cd.value="";
	formObj.balance.value="";
}

//Carrier변경시
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	comboObjects[1].Index2 = -1;
	comboObjects[3].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObjects[3].RemoveAll();
	UF_resetSheets();
}

function trd_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[0].Code.length < 3){
		ComShowCodeMessage("JOO00008");
		formObj.jo_crr_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;	
		doActionIBCombo(sheetObjects[2], formObj, IBSEARCH, comboObj ,"trd_cd");
		comboObj.Enable = true;	
	}	
}

//TRADE 변경시
function trd_cd_OnChange(comboObj, idx_cd, text){	
	UF_resetSheets();
}

function re_divr_cd_OnChange(comboObj, idx_cd, text){
	UF_resetSheets();
}

function stl_cmb_seq_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[0].Code.length < 3){
		ComShowCodeMessage("JOO00008");
		formObj.jo_crr_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;	
		doActionIBCombo(sheetObjects[2], formObj, IBSEARCH, comboObj, "trd_cd");
		comboObj.Enable = true;	
	}	
}

function stl_cmb_seq_OnChange(comboObj, idx_cd, text){
	var form  = document.form;
	//Combined. No가 있을 경우에는 R/E를 disabled 시킴
	if (ComTrim(idx_cd) == ""){
		form.trd_cd.Enable = true;
		form.re_divr_cd.Enable = true;
	}else{
		form.trd_cd.Index2 = -1;
		form.re_divr_cd.Index2 = -1;
		form.trd_cd.Enable = false;
		form.re_divr_cd.Enable = false;
	}
	UF_resetSheets();
	
	//조회
	if (idx_cd != "" && form.acct_yrmon.value != "" && form.jo_crr_cd.Code != ""){
		doActionIBSheet(sheetObjects[0], form, IBSEARCH);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
			if (formObj.acct_yrmon.value.length == 0){
				ComShowCodeMessage('JOO00033');
				formObj.acct_yrmon.focus();
				return false;
			}
			if (formObj.jo_crr_cd.index == -1){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

//			if (formObj.trd_cd.Index == -1){
//				ComShowCodeMessage('JOO00009');
//				formObj.trd_cd.focus();
//				return false;
//			}
			break;
			
		case IBSAVE:   //저장
			if (formObj.acct_yrmon.value.length == 0){
				ComShowCodeMessage('JOO00033');
				formObj.acct_yrmon.focus();
				return false;
			}
			if (formObj.jo_crr_cd.index == -1){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

//			if (formObj.trd_cd.Index == -1){
//				ComShowCodeMessage('JOO00009');
//				formObj.trd_cd.focus();
//				return false;
//			}

			//if (formObj.stl_cmb_seq.Index != -1){
			if (ComTrim(formObj.stl_cmb_seq.Code) != ""){
				ComShowCodeMessage('JOO00094');
				formObj.stl_cmb_seq.focus();
				return false;
			}
			if (sheetObjects[1].HeaderRows >= sheetObjects[1].LastRow){
				ComShowCodeMessage('JOO00036');
				return false;
			}
			
			break;

		case IBDELETE:   //삭제
			if (formObj.acct_yrmon.value.length == 0){
				ComShowCodeMessage('JOO00033');
				formObj.acct_yrmon.focus();
				return false;
			}
			if (formObj.jo_crr_cd.index == -1){
				ComShowCodeMessage('JOO00008');
				formObj.jo_crr_cd.focus();
				return false;
			}

//			if (formObj.trd_cd.Index == -1){
//				ComShowCodeMessage('JOO00009');
//				formObj.trd_cd.focus();
//				return false;
//			}

			if (formObj.stl_cmb_seq.Index == -1){
				ComShowCodeMessage('JOO00092');
				formObj.stl_cmb_seq.focus();
				return false;
			}
			var idx_cd = comboObjects[3].Code;
			if (comboObjects[3].GetText(idx_cd,1) != ""){
				ComShowCodeMessage('JOO00095');
				formObj.stl_cmb_seq.focus();
				return false;
			}
			
			if (sheetObjects[1].RowCount == 0){
				ComShowCodeMessage('JOO00093');
				return false;
			}
			break;
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;

	var aBoolean = false;

	//Combined No가 없으면 Check할 수 있다.
	if (ComTrim(comboObjects[3].Code) == ""){
		aBoolean = true;
	}

	for (var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
		//Combined No가 없더라도 해당 rlane에 권한이 없으면 선택 못한다.
		if (sheetObj.CellValue(inx, aryPrefix[0]+"stl_dup_flg") == "R"){
			sheetObj.CellEditable(inx, aryPrefix[0]+"cmb_cfm_flg") = false;
		}else{
			sheetObj.CellEditable(inx, aryPrefix[0]+"cmb_cfm_flg") = aBoolean;
		}
	}

	//Delete를 위함
	formObj.rlane_cd.value = UF_getSeletedRlane();
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	
	sheetObj.SumText(0,aryPrefix[1]+"rlane_cd") = "TOTAL"; //TOTAL이라는 글자가 잘리지 않게 넓은데로 옮김
    sheetObj.ShowSubSum(aryPrefix[1]+"rlane_cd","8|12", true, true);
    
    var hjs = sheetObj.SumValue(0,aryPrefix[1]+"r_stl_locl_amt");
    var crr = sheetObj.SumValue(0,aryPrefix[1]+"e_stl_locl_amt");

    var nHjs = (new Number(hjs)).toFixed(2);
    var nCrr = (new Number(crr)).toFixed(2);
    
    var balAmt = new Number(Math.abs(nHjs - nCrr)).toFixed(2);
    
    var balCarrier = formObj.jo_crr_cd.Code;
    
    if (hjs >= crr){
    	balCarrier = "SML";
    }

    formObj.balance.value = balAmt;
    formObj.bal_jo_crr_cd.value = balCarrier;
    ComAddSeparator(formObj.balance,"float");
}

/**
 * 셀을 마우스 더블클릭했을때 발생하는 이벤트 <br>
 */

function sheet2_OnDblClick(sheetObj, Row, Col ){
	
	var formObj = document.form;
    var value  = sheetObj.CellValue(Row,Col);
    	
    if(value == ""){return;}
    
    if( sheetObj.ColSaveName(Col) == aryPrefix[1]+"remark"){
    	
    	var acct_yrmon    = formObj.acct_yrmon.value;
    	var jo_crr_cd     = formObj.jo_crr_cd.Code;
    	var r_vvd         = sheetObj.CellValue(Row, aryPrefix[1]+"r_vvd");
    	var e_vvd         = sheetObj.CellValue(Row, aryPrefix[1]+"e_vvd");
    	var rlane_cd      = sheetObj.CellValue(Row, aryPrefix[1]+"rlane_cd")
    	var jo_stl_itm_cd = sheetObj.CellValue(Row, aryPrefix[1]+"jo_stl_itm_cd")
    	
    	var paramUrl = "pgmNo=FNS_JOO_0102&acct_yrmon="+acct_yrmon+"&jo_crr_cd="+jo_crr_cd+"&r_vvd="+r_vvd+"&e_vvd="+e_vvd+"&rlane_cd="+rlane_cd+"&jo_stl_itm_cd="+jo_stl_itm_cd;
    			
    	ComOpenPopup("/hanjin/FNS_JOO_0102.do?"+paramUrl, 400, 360,"", "1,0,1,1,1,1,1,1", true);
    }
}


function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	if (sName == aryPrefix[0]+"cmb_cfm_flg"){
		var rlane = UF_getSeletedRlane();

		formObj.rlane_cd.value = rlane;
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	}
}

function rdOpen( formObj){
    var formObj = document.form;
 
    queryStr="";
    if( !setQueryStr() ){
        return;
    } 
    var rdParam   =  '/rp '+queryStr;
    var strPath   =  "apps/alps/fns/joo/jointoperationagreementsettlement/jointoperationletter/report/FNS_JOO_0071.mrd"; 
    formObj.com_mrdPath.value      = strPath;
    formObj.com_mrdArguments.value = rdParam;
    ComOpenRDPopup();

}

function setQueryStr(){

    var formObj = document.form;         
    queryStr += " ["+formObj.acct_yrmon.value+"]";
    queryStr += " ["+formObj.jo_crr_cd.Code  +"]";
    if( formObj.stl_cmb_seq.Code == ""){
        ComShowCodeMessage("JOO00092");
        return false;         
    }else{
        queryStr += " ["+formObj.stl_cmb_seq.Code+"]";//5  COMB
    }
    var bal_jo_crr_cd = formObj.bal_jo_crr_cd.value;
    queryStr += " ["+bal_jo_crr_cd+"]";           

    return true;
}

/**
 * 선택된 rlane 코드를 AEXAE','FEXAE 형태로 만들어준다.
 * @return
 */
function UF_getSeletedRlane(){
	var rlane = "";
	for (var inx=sheetObjects[0].HeaderRows; inx<=sheetObjects[0].LastRow; inx++){
		if (sheetObjects[0].CellValue(inx, aryPrefix[0]+"cmb_cfm_flg") != "1") continue;
		//rlane += "'"+sheetObjects[0].CellValue(inx, aryPrefix[0]+"rlane_cd")+"',"; 
		rlane += sheetObjects[0].CellValue(inx, aryPrefix[0]+"rlane_cd")+",";
	}
	if (rlane.length != 0){
		//rlane = rlane.substring(1);
		//rlane = rlane.substring(0,rlane.length-2);
		rlane = rlane.substring(0,rlane.length-1);
		// rlane은 AEXAE',...,'FEXAE 형태로 넘어가야 한다.
	}
	
	return rlane;
}

function UF_resetCondition(){
	var formObj = document.form;
	formObj.stl_cmb_seq.RemoveAll();
	formObj.re_divr_cd.Index2=-1;
	formObj.re_divr_cd.Enable = true;
	formObj.trd_cd.RemoveAll();	
	formObj.trd_cd.Enable=true;	
	formObj.jo_crr_cd.Index2=-1;
}
/* 개발자 작업  끝 */