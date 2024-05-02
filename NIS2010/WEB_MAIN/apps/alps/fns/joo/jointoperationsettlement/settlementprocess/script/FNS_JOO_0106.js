/*================================================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0106.js
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.08.03
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2015.08.03 민정호
 * 1.0 Creation
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
 * @class fns_joo_0106 : fns_joo_0106 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0106() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var gCurRow = 0;
var prefix = "sheet1_";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName == null || srcName == "re_divr_cd") {
			return;
		}

		//class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {
		case "btns_back":
			formObj.jo_crr_cd.focus();
	    	sheetObjects[0].RemoveAll();
			if (formObj.acct_yrmon.value!=""){
				formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M",-1).substring(0,7);
			}
			//2011-10-10 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거
			//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
			break;

		case "btns_next":
			formObj.jo_crr_cd.focus();
			sheetObjects[0].RemoveAll();
			if (formObj.acct_yrmon.value!=""){
				formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M", 1).substring(0,7);
			}
			//2011-10-10 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거
			//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10); 
			break;

		case "btn_add":
			if (formObj.jo_crr_cd.index == -1){ 
				ComShowCodeMessage('JOO00008');
				return;
			}
			
			if (formObj.trd_cd.index    == -1){
				ComShowCodeMessage('JOO00009');
				return;
			}
			
			if (formObj.rlane_cd.index  == -1){
				ComShowCodeMessage('JOO00010');
				return;
			}

			var idx_cd = formObj.rlane_cd.Code;
			var loclCurrCd = formObj.rlane_cd.GetText(idx_cd,1);
			
			if (loclCurrCd.length!=3){
				ComShowCodeMessage('JOO00082');
				return;
			}
			
			var row = sheetObject1.DataInsert(-1);
			var reDivrCd = JooGetRadioValue(formObj.re_divr_cd);
			
			sheetObjects[0].CellValue2(row, prefix+"acct_yrmon"   ) = ComReplaceStr(formObj.acct_yrmon.value,"-","");
			sheetObjects[0].CellValue2(row, prefix+"trd_cd"       ) = formObj.trd_cd.Code;
			sheetObjects[0].CellValue2(row, prefix+"jo_crr_cd"    ) = formObj.jo_crr_cd.Code;
			sheetObjects[0].CellValue2(row, prefix+"rlane_cd"     ) = formObj.rlane_cd.Code;
			sheetObjects[0].CellValue2(row, prefix+"re_divr_cd"   ) = reDivrCd;
			sheetObjects[0].CellValue2(row, prefix+"jo_stl_itm_cd") = formObj.jo_stl_itm_cd.Code;
			sheetObjects[0].CellValue2(row, prefix+"jo_mnu_nm"    ) = formObj.jo_mnu_nm.value;
			sheetObjects[0].CellValue2(row, prefix+"skd_dir_cd"   ) = "";
			sheetObjects[0].CellValue2(row, prefix+"rev_dir_cd"   ) = "";
			sheetObjects[0].CellValue2(row, prefix+"locl_curr_cd" ) = loclCurrCd;
			sheetObjects[0].CellValue2(row, prefix+"jo_stl_jb_cd" ) = "";
			sheetObjects[0].CellValue2(row, prefix+"stl_adj_flg"  ) = "N"; //보정여부 N
			sheetObjects[0].CellValue2(row, prefix+"stl_lst_flg"  ) = "Y"; //최종여부 Y
			
			sheetObjects[0].SelectCell(row, prefix+"jo_stl_itm_cd", true);			
			
			//추가(10/12)
			sheetObjects[0].CellValue2(row, prefix+"stl_vvd_seq"  ) = "0";			
			break;

		case "btn_delete":
			JooRowHideDelete(sheetObject1, prefix+"del_chk");
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObj, IBSEARCH);
			break;
			
		case "btn_create":
			doActionIBSheet(sheetObject1, formObj, IBCREATE);
			break;
						
		case "btn_new":
			sheetObjects[0].RemoveAll();
			formObj.jo_crr_cd.Index2 = -1;
			formObj.trd_cd.Index2 = -1;
			formObj.rlane_cd.Index2 = -1;
			formObj.jo_stl_itm_cd.Index2 = -1;
			formObj.re_divr_cd[0].checked = true;
			formObj.acct_yrmon.focus();
			break;

		case "btn_save":
			doActionIBSheet(sheetObject1, formObj, IBSAVE);
			break;

		case "btn_downexcel":
			sheetObject1.SpeedDown2Excel();
			break;
			
		//2010.09.06 정윤태 [CHM-201005739-01] Other Settlement Creation시 Row Copy기능 추가	
		case "btn_copy":
			
			var row = sheetObject1.DataInsert();
			var reDivrCd = JooGetRadioValue(formObj.re_divr_cd);
			var idx_cd = formObj.rlane_cd.Code;
			var loclCurrCd = formObj.rlane_cd.GetText(idx_cd,1);
			
			//데이타 조회 후 데이타가 한건 이상 존재한 경우
			if(sheetObject1.RowCount > 1) {
				sheetObjects[0].CellValue2(row, prefix+"jo_stl_itm_cd") = sheetObjects[0].CellValue(row-1, prefix+"jo_stl_itm_cd");
				sheetObjects[0].CellValue2(row, prefix+"vsl_cd"      )  = sheetObjects[0].CellValue(row-1, prefix+"vsl_cd"       );
				sheetObjects[0].CellValue2(row, prefix+"skd_voy_no"  )  = sheetObjects[0].CellValue(row-1, prefix+"skd_voy_no"   );
				sheetObjects[0].CellValue2(row, prefix+"skd_dir_cd"  )  = sheetObjects[0].CellValue(row-1, prefix+"skd_dir_cd"   );
				sheetObjects[0].CellValue2(row, prefix+"rev_dir_cd"  )  = sheetObjects[0].CellValue(row-1, prefix+"rev_dir_cd"   );
				sheetObjects[0].CellValue2(row, prefix+"locl_curr_cd")  = sheetObjects[0].CellValue(row-1, prefix+"locl_curr_cd" );
				sheetObjects[0].CellValue2(row, prefix+"stl_vvd_seq")   = sheetObjects[0].CellValue(row-1, prefix+"stl_vvd_seq"  );
				
				sheetObjects[0].CellValue2(row, prefix+"acct_yrmon"   ) = ComReplaceStr(formObj.acct_yrmon.value,"-","");
				sheetObjects[0].CellValue2(row, prefix+"trd_cd"       ) = formObj.trd_cd.Code;
				sheetObjects[0].CellValue2(row, prefix+"jo_crr_cd"    ) = formObj.jo_crr_cd.Code;
				sheetObjects[0].CellValue2(row, prefix+"rlane_cd"     ) = formObj.rlane_cd.Code;
				sheetObjects[0].CellValue2(row, prefix+"re_divr_cd"   ) = reDivrCd;
				
				sheetObjects[0].CellValue2(row, prefix+"jo_mnu_nm"    ) = formObj.jo_mnu_nm.value;
				sheetObjects[0].CellValue2(row, prefix+"locl_curr_cd" ) = loclCurrCd;
				sheetObjects[0].CellValue2(row, prefix+"jo_stl_jb_cd" ) = "";
				sheetObjects[0].CellValue2(row, prefix+"stl_adj_flg"  ) = "N"; //보정여부 N
				sheetObjects[0].CellValue2(row, prefix+"stl_lst_flg"  ) = "Y"; //최종여부 Y

				//추가(10/12)
				sheetObjects[0].CellValue2(row, prefix+"stl_vvd_seq"  ) = "0";										
			//데이타 조회 후 데이타가 존재하지 않은 경우
			} else {
				sheetObjects[0].CellValue2(row, prefix+"skd_dir_cd"  ) = "";
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
    
//    JooSetBtnClass("C2", false);
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
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);    

    axon_event.addListener('keypress', 'acct_yrmon_keypress', 'acct_yrmon');	
    axon_event.addListener('click', 'change_event_radio', 're_divr_cd');
    
    formObj.acct_yrmon.focus();
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur(){
	var formObj = document.form;	
    ComChkObjValid(event.srcElement);
    
	var src = window.event.srcElement.getAttribute("name")
    if (src == "acct_yrmon"){
		//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
    	doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
    }
}

function obj_focus(){
    ComClearSeparator(event.srcElement);
}

function obj_keypress(){
	var src = window.event.srcElement.getAttribute("name")
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');
}

function acct_yrmon_keypress(){
	ComKeyOnlyNumber(this, '');
}

function obj_onclick(){
	var src = window.event.srcElement.getAttribute("name")
}

function change_event_radio(){
	var src = window.event.srcElement.getAttribute("name")
	sheetObjects[0].RemoveAll();

	//re_divr_cd 가 변경될때에도 rlane을 읽어온다.
	if (document.form.trd_cd.Code.length == 3){
		doActionIBCombo(sheetObjects[0] , document.form ,IBSEARCH , comboObjects[2] ,"rlane_cd");
	}
	
	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC10);
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
			style.height = 388;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "STS||ITEM|VSL|VOY|Dir.|Fin.\nDir.|Cur.|TEU|Slot Price|Amount|BSA Type|Remarks|Combined\nNo|RVS|" +
								   "acct_yrmon|stl_vvd_seq|stl_seq|trd_cd|jo_crr_cd|rlane_cd|re_divr_cd|jo_mnu_nm|stl_bzc_port_cd|eta_dt|slip_no|stl_adj_flg|" +
								   "stl_lst_flg|uc_bss_port_cd|uc_bss_port_etd_dt|Dup.|Canceled\nVVD|ACCT_YRMON2|rev_yrmon|rev_yrmon_seq|rev_seq";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus      ,  30, daCenter, true , prefix+"ibflag" );
			InitDataProperty(0, cnt++, dtCheckBox    ,  30, daCenter, true , prefix+"del_chk");
			InitDataProperty(0, cnt++, dtCombo       ,  50, daCenter, true , prefix+"jo_stl_itm_cd", false, "", dfNone     , 0, false, true );
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true , prefix+"vsl_cd"       , false, "", dfNone     , 0, false, true ,4);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true , prefix+"skd_voy_no"   , false, "", dfNone     , 0, false, true ,4);
			InitDataProperty(0, cnt++, dtCombo       ,  40, daCenter, true , prefix+"skd_dir_cd"   , false, "", dfNone     , 0, false, true );
			InitDataProperty(0, cnt++, dtData        ,  40, daCenter, true , prefix+"rev_dir_cd"   , false, "", dfNone     , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true , prefix+"locl_curr_cd" , false, "", dfNone     , 0, false, false);
			//2010.04.14 TEU 소수점 3자리로 수정해달라고 요청함(박효숙 차장...근거 : mail)
			InitDataProperty(0, cnt++, dtAutoSum     ,  50, daRight , true , prefix+"bsa_qty"      , false, "", dfFloat    , 3, true , true );
			InitDataProperty(0, cnt++, dtData        ,  80, daRight , true , prefix+"bsa_slt_prc"  , false, "", dfFloat    , 2, true , true );
			//수식은 editable하지 않음
			//InitDataProperty(0, cnt++, dtAutoSum     , 110, daRight , true , prefix+"stl_locl_amt" , false, "|8|*|9|", dfNullFloat, 2, false, true);
			InitDataProperty(0, cnt++, dtAutoSum     , 100, daRight , true , prefix+"stl_locl_amt" , false, "", dfNullFloat, 2, false, true);
			InitDataProperty(0, cnt++, dtCombo       , 110, daLeft  , true , prefix+"jo_stl_jb_cd" , false, "", dfNone     , 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 140, daLeft  , true , prefix+"stl_rmk"      , false, "", dfNone     , 0, true , true , 50);
			InitDataProperty(0, cnt++, dtData        ,  70, daCenter, true , prefix+"stl_cmb_seq"  , false, "", dfNone     , 0, false, false,  3);
			InitDataProperty(0, cnt++, dtData        ,  40, daCenter, true , prefix+"rvs_cmb_flg"  , false, "", dfNone     , 0, false, false,  3);
//임시
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"acct_yrmon"              , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"stl_vvd_seq"             , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"stl_seq"                 , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"trd_cd"                  , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"jo_crr_cd"               , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"rlane_cd"                , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"re_divr_cd"              , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"jo_mnu_nm"               , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"stl_bzc_port_cd"         , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"eta_dt"                  , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"slip_no"                 , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"stl_adj_flg"             , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"stl_lst_flg"             , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"uc_bss_port_cd"          , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"uc_bss_port_etd_dt"      , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft,   false, prefix+"stl_dup_flg"      , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft,   false, prefix+"cxl_vvd_flg"      , false, "", dfNone, 0, false, false);			
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft,   false, prefix+"acct_yrmon2"      , false, "", dfNone, 0, false, false);			
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft,   false, prefix+"rev_yrmon"      , 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft,   false, prefix+"rev_yrmon_seq", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft,   false, prefix+"rev_seq"      , 			false, "", dfNone, 0, false, false);			

			MessageText("Sum") = ""; //summary row에 자동으로 생성되는 TOTAL이란 글자를 없앰

			InitDataValid(0, prefix+"vsl_cd"     , vtEngUpOther, "0123456789");//영문대문자+숫자
			InitDataValid(0, prefix+"skd_voy_no" , vtNumericOnly);//숫자만 올 수 있음
			InitDataValid(0, prefix+"stl_rmk"    , vtEngOther, gVtOther); //영문
			
			InitDataCombo(0, prefix+"skd_dir_cd"   , "E|W|S|N", "E|W|S|N");
			InitDataCombo(0, prefix+"jo_stl_itm_cd", gAbbrSheet   , gAbbrSheet);
			InitDataCombo(0, prefix+"jo_stl_jb_cd" , gStlComnm    , gStlCombo);

		}
		break;
		
	case 2: //t1sheet1 init
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
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_JOO_0106GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;

		case IBSAVE: //중복체크하는 저장
			var SaveStr = ComGetSaveString(sheetObjects[0], true, true);
			
			if (SaveStr == ""){
				ComShowCodeMessage("JOO00036");
				return false;
			}

			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}

			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;

			var sXml = sheetObj.GetSaveXml("FNS_JOO_0106GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			
			sheetObj.LoadSearchXml(sXml);
			
			var dupRows = "";
			for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow; i++){
				if (sheetObj.RowStatus(i) == "R" || sheetObj.RowStatus(i) == "D")
					continue;
				
				if (sheetObj.CellValue(i,prefix+"stl_dup_flg") == "Y"){
					dupRows = dupRows + i +"|";
				}
			}
			
			if (dupRows.length > 0)
				dupRows = dupRows.substring(0, dupRows.length-1);

			var RTNVAL = ComGetEtcData(sXml, "RTNVAL");
			if (RTNVAL == "E"){
				if (ComShowCodeConfirm('JOO00132', dupRows)){
					doActionIBSheet(sheetObj, document.form, IBINSERT);					
				}
			}else{
				if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				}
			}
			
			break;

		//SAVE => Do you want to save the changes? 물음 없이...저장 
		case IBINSERT:
			var SaveStr = ComGetSaveString(sheetObjects[0], true, true);
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0106GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			
			sheetObj.LoadSearchXml(sXml);
			
			var dupRows = "";
			for(var i=sheetObj.HeaderRows; i<sheetObj.LastRow; i++){
				if (sheetObj.RowStatus(i) == "R" || sheetObj.RowStatus(i) == "D")
					continue;
				
				if (sheetObj.CellValue(i,prefix+"stl_dup_flg") == "Y"){
					dupRows = dupRows + i +"|";
				}
			}
			
			if (dupRows.length > 0)
				dupRows = dupRows.substring(0, dupRows.length-1);

			var RTNVAL = ComGetEtcData(sXml, "RTNVAL");
			if (RTNVAL == "E"){
				if (ComShowCodeConfirm('JOO00132', dupRows)){
					doActionIBSheet(sheetObj, document.form, IBINSERT);					
				}
			}else{
				doActionIBSheet(sheetObj, document.form, IBSEARCH);					
			}
			
			break;

		//VVD 9자리 입력시 REV_DIR_CD를 조회해온다.	
		case IBROWSEARCH:
			formObj.f_cmd.value = SEARCHLIST;
			formObj.cur_row.value = (gCurRow - sheetObj.HeaderRows);
			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0106GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			var revDirList = ComGetEtcData(sXml,"REV_DIR_LIST");
			var errCd      = ComGetEtcData(sXml,"ERR_CD");
			if (errCd == "N"){
				if ((revDirList.split("|")).length > 1){
			        sheetObj.InitCellProperty(gCurRow, 5, dtCombo, daCenter, prefix+"rev_dir_cd", "", dfNone);
					sheetObj.CellComboItem(gCurRow, prefix+"rev_dir_cd"  , revDirList , revDirList, 0);
				}else{
					sheetObj.CellValue(gCurRow, prefix+"rev_dir_cd")=revDirList;
				}
			}else{
				ComShowCodeMessage("JOO00031");
				sheetObj.CellValue2(gCurRow, prefix+"skd_dir_cd") ="";
			}
			break;

		//VVD Validation Check
		case IBSEARCH_ASYNC01:
//			formObj.f_cmd.value = SEARCHLIST01;
//			formObj.cur_row.value = gCurRow-1;
//			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
//			var sXml = sheetObj.GetSaveXml("FNS_JOO_0106GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//			
//			var CHECKVVD = ComGetEtcData(sXml,"CHECKVVD");
//			
//			if (CHECKVVD=="N"){
//				sheetObj.CellValue2(gCurRow, prefix+"stl_vvd_seq"       ) = ComGetEtcData(sXml,"stl_vvd_seq");
//				sheetObj.CellValue2(gCurRow, prefix+"stl_bzc_port_cd"   ) = ComGetEtcData(sXml,"stl_bzc_port_cd");
//				sheetObj.CellValue2(gCurRow, prefix+"eta_dt"            ) = ComGetEtcData(sXml,"eta_dt");
//				sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_cd"    ) = ComGetEtcData(sXml,"uc_bss_port_cd");
//				sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_etd_dt") = ComGetEtcData(sXml,"uc_bss_port_etd_dt");
//				sheetObj.CellValue2(gCurRow, prefix+"cxl_vvd_flg"       ) = "N";
//				sheetObj.SelectCell(gCurRow, prefix+"bsa_qty", true);
//			//Cancel된 VVD면 0053 POP-UP
//			}else if (CHECKVVD=="P"){
//				sheetObj.CellValue2(gCurRow, prefix+"cxl_vvd_flg"       ) = "Y";
//				var vslCd    = sheetObj.CellValue(gCurRow, prefix+"vsl_cd");
//				var skdVoyNo = sheetObj.CellValue(gCurRow, prefix+"skd_voy_no");
//				var skdDirCd = sheetObj.CellValue(gCurRow, prefix+"skd_dir_cd");
//				var revDirCd = sheetObj.CellValue(gCurRow, prefix+"rev_dir_cd");
//				var reDivrCd = sheetObj.CellValue(gCurRow, prefix+"re_divr_cd");
//				var joCrrCd  = sheetObj.CellValue(gCurRow, prefix+"jo_crr_cd");
//				var rlaneCd  = sheetObj.CellValue(gCurRow, prefix+"rlane_cd");
//				var param = '?vslCd='+vslCd+'&skdVoyNo='+skdVoyNo+'&skdDirCd='+skdDirCd+'&revDirCd='+revDirCd+'&reDivrCd='+reDivrCd+'&joCrrCd='+joCrrCd+'&rlaneCd='+rlaneCd;
//				ComOpenPopup('/hanjin/FNS_JOO_0053.do'+param, 600, 440, 'popupFinish', '1,0,1,1,1,1,1,1', true);
//			}else{
//				if (CHECKVVD=="E"){
//					ComShowCodeMessage("JOO00141");
//				}else if (CHECKVVD=="T"){
//					ComShowCodeMessage("JOO00142");
//				}
//				sheetObj.CellValue2(gCurRow, prefix+"stl_vvd_seq"       ) = "";
//				sheetObj.CellValue2(gCurRow, prefix+"stl_bzc_port_cd"   ) = "";
//				sheetObj.CellValue2(gCurRow, prefix+"eta_dt"            ) = "";
//				sheetObj.CellValue2(gCurRow, prefix+"vsl_cd"            ) = "";
//				sheetObj.CellValue2(gCurRow, prefix+"skd_voy_no"        ) = "";
//				sheetObj.CellValue2(gCurRow, prefix+"skd_dir_cd"        ) = "";
//				sheetObj.CellValue2(gCurRow, prefix+"rev_dir_cd"        ) = "";
//				sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_cd"    ) = "";
//				sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_etd_dt") = "";
//
//				sheetObj.SelectCell(gCurRow, prefix+"vsl_cd", true);
//			}
			break;
			
			//Create
		case IBCREATE:
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0106GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml,false);

			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				var addedCnt = sheetObj.RowCount("I");
				if (addedCnt == 0){
					ComShowCodeMessage('JOO00054');
				}
			}
			break;			
							
		case IBSEARCH_ASYNC10: //마감여부 조회
			formObj.f_cmd.value = SEARCH10;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0012GS.do", FormQueryString(formObj));
			
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				gClzYn = ComGetEtcData(sXml,"clz_yn"); 
				if (gClzYn == "C"){
					//2012-02-28 이미 마감된 Account Month 지정 시 팝업되는 메시지 창(It was closed) 제거는 그대로 두고 날짜 변경시에 우선적으로 체크하도록 수정
					ComShowCodeMessage("JOO00177");
// 임시					
					JooSetBtnClass("C", false);
// 임시					
					sheetObjects[0].Editable = false;
				//Open상태면 Authority에 따라 Button을 활성화, 비활성화 한다.
				}else{
// 임시					
					JooSetBtnClass("C", true);
					sheetObjects[0].Editable = true;
					if (comboObjects[2].index != -1){
						var code = comboObjects[2].Code;
						UF_setAuth(comboObjects[2].GetText(code, 2));
					}
				}
			}
			
			break;

		case IBSEARCH_ASYNC02:
			formObj.f_cmd.value = SEARCHLIST02;
			formObj.cur_row.value = gCurRow-1;
			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0106GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			var CHECKVVD = ComGetEtcData(sXml,"CHECK_BSA_TYPE");
			
			if (CHECKVVD=="E"){
				ComShowCodeMessage("JOO00180");
				sheetObj.CellValue2(gCurRow, prefix+"jo_stl_jb_cd") = "";

				sheetObj.SelectCell(gCurRow, prefix+"jo_stl_jb_cd", true);
			}
			break;
		
	}
}

function popupFinish(){
	
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
 				SetColAlign("left|left|left");        
 				SetColWidth("30|0|0"); //rlane_cd, currency, auth_cd
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
 				MaxLength=5;
  		    }
  			break;

    	case 4: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = true;	
 				SetColAlign("left");        
 				SetColWidth("30");
  				DropHeight = 160;
 				ValidChar(2,2);//영문대문자만 입력가능
 				MaxLength=3;
  		    }
            gAbbrCombo = ",|"+gAbbrCombo;
            var comboItems = gAbbrCombo.split("|");
            addComboItem(comboObj, comboItems);           	
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
									
				formObj.f_cmd.value = SEARCHLIST06;
				formObj.code.value = "";
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = "";
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
                ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
			}else if (sComboObj.id == "rlane_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCHLIST16;
				formObj.code.value = "OTH"; //Item
				formObj.name.value = JooGetRadioValue(formObj.re_divr_cd); //re_divr_cd
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = formObj.trd_cd.Code;
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
                ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code|name|auth_cd");
			}
														
	        break;
    }
}

//TRADE 변경시 LANE 변경
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();	
	comboObjects[1].Index2 = -1;
	comboObjects[2].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
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
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj ,"trd_cd");
		comboObj.Enable = true;	
	}	
}

//TRADE 변경시 LANE 변경
function trd_cd_OnChange(comboObj, idx_cd, text){
	sheetObjects[0].RemoveAll();
	comboObjects[2].Index2 = -1;
	comboObjects[2].RemoveAll();
}

function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	
	if (comboObjects[1].Code.length < 3){
		ComShowCodeMessage("JOO00009");
		formObj.trd_cd.focus();
		return;
	}
	
	if (comboObj.GetCount() == 0){
		comboObj.Enable = false;	
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj ,"rlane_cd");
		comboObj.Enable = true;	
	}	
}

//RLANE 변경시 clear
function rlane_cd_OnChange(comboObj, code, text){
	sheetObjects[0].RemoveAll();
	UF_setAuth(comboObj.GetText(code, 2));
}

function UF_setAuth(auth){
	//마감되었다면 이미 버튼제어가 된 상태고 권한에 상관없이 disable
// 임시	
	if (gClzYn == "C") return;
	
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
}

//JO_STL_ITM_CD change
function jo_stl_itm_cd_OnBlur(comboObj){
	sheetObjects[0].RemoveAll();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBCREATE: //저장용 조회
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

		if (formObj.trd_cd.Index == -1){
			ComShowCodeMessage('JOO00009');
			formObj.trd_cd.focus();
			return false;
		}

		if (formObj.rlane_cd.Index == -1){
			ComShowCodeMessage('JOO00010');
			formObj.rlane_cd.focus();
			return false;
		}

		var idx_cd = formObj.rlane_cd.Code;
		var loclCurrCd = formObj.rlane_cd.GetText(idx_cd,1);
		
		if (loclCurrCd.length!=3){
			ComShowCodeMessage('JOO00082');
			return;
		}
		break;
				
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

			if (formObj.trd_cd.Index == -1){
				ComShowCodeMessage('JOO00009');
				formObj.trd_cd.focus();
				return false;
			}

			if (formObj.rlane_cd.Index == -1){
				ComShowCodeMessage('JOO00010');
				formObj.rlane_cd.focus();
				return false;
			}
			break;
			
		case IBSAVE:   //저장		
// 임시			
			for (var idx=sheetObj.LastRow-1; idx>=0; idx--){
				if(sheetObj.CellValue(idx, prefix+"ibflag") == 'U' || sheetObj.CellValue(idx, prefix+"ibflag") == 'R'){
					if(sheetObj.CellValue(idx, prefix+"del_chk") == '1'){
						sheetObj.CellValue(idx, prefix+"ibflag") = 'I'
					}					
				}
			}
			
			//TEU 와  SLOT PRICE 에 값이 없으면  삭제 처리하기(중간에 입력상태의 행이 있을수도 있으므로  역순으로 처리한다.)
			var cnt_novalue = 0;
			for (var idx=sheetObj.LastRow-1; idx>=0; idx--){
				var bsa = sheetObj.CellValue(idx, prefix+"bsa_qty");
				var sltPrc = sheetObj.CellValue(idx, prefix+"bsa_slt_prc");
				
				if ((bsa == "0" || bsa == "") && (sltPrc == "0" || sltPrc == "")){					
					if (cnt_novalue != 1 && !ComShowCodeConfirm("JOO00181")){
						return false;
					}else{cnt_novalue = 1}
					
					//Insert인 경우 삭제하면 아예 삭제
					if (sheetObj.RowStatus(idx) == "I"){
						sheetObj.RowDelete(idx, false);	//1.삭제
					}else{
						sheetObj.CellValue2(idx, prefix+"del_chk")= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
						sheetObj.RowHidden(idx)= true;		//2.행 숨기기
						sheetObj.RowStatus(idx)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
					}
				}
			}
		
			var cnt = 0;
			for (var inx=sheetObj.HeaderRows; inx <= sheetObj.LastRow; inx++){
				var status = sheetObj.RowStatus(inx); 
				if (status =="R")
					continue;
				cnt++;

				if (status == "D"){ 
					var slip = sheetObj.CellValue(inx, prefix+"stl_cmb_seq"); 
					if (slip != ""){
						ComShowCodeMessage('JOO00057',inx ,slip);
						sheetObj.SelectCell(inx, prefix+"del_chk", true);
						return false;
					}
				}else{
// 임시					
//					if ((status == "I" || status == "U") && sheetObj.CellValue(inx, prefix+"del_chk") == "1"){
//						ComShowCodeMessage("JOO00079");
//						sheetObj.SelectCell(inx,prefix+"del_chk",true);
//						return false;
//					}
//
//					if (sheetObj.CellValue(inx, prefix+"vsl_cd").length < 4){
//						ComShowCodeMessage('JOO00040',inx);
//						sheetObj.SelectCell(inx, prefix+"vsl_cd", true);
//						return false;
//					}
//					if (sheetObj.CellValue(inx, prefix+"skd_voy_no").length < 4){
//						ComShowCodeMessage('JOO00041',inx);
//						sheetObj.SelectCell(inx, prefix+"skd_voy_no", true);
//						return false;
//					}
//					if (sheetObj.CellValue(inx, prefix+"skd_dir_cd").length < 1){
//						ComShowCodeMessage('JOO00042',inx);
//						sheetObj.SelectCell(inx, prefix+"skd_dir_cd", true);
//						return false;
//					}
//					if (sheetObj.CellValue(inx, prefix+"rev_dir_cd").length < 1){
//						ComShowCodeMessage('JOO00055',inx);
//						sheetObj.SelectCell(inx, prefix+"rev_dir_cd", true);
//						return false;
//					}

					var itm = sheetObj.CellValue(inx, prefix+"jo_stl_itm_cd");
					
					if (itm == "S/H" || itm == "OUS"){
						var bsa = sheetObj.CellValue(inx, prefix+"bsa_qty");
						if (bsa == "0" || bsa == ""){
							ComShowCodeMessage('JOO00058',inx, "BSA TEU");
							sheetObj.SelectCell(inx, prefix+"bsa_qty", true);
							return false;
						}
						
						var sltPrc = sheetObj.CellValue(inx, prefix+"bsa_slt_prc");
						if (sltPrc == "0" || sltPrc == ""){
							ComShowCodeMessage('JOO00058',inx, "Slot Price");
							sheetObj.SelectCell(inx, prefix+"bsa_slt_prc", true);
							return false;
						} 
					}
					
					if (itm == "S/H"){
						var joStlJbCd = sheetObj.CellValue(inx, prefix+"jo_stl_jb_cd");
						
						if (joStlJbCd == ""){
							ComShowCodeMessage('JOO00058',inx, "BSA Type");
							sheetObj.SelectCell(inx, prefix+"jo_stl_jb_cd", true);
							return false;
						}
					}

					//2010.01.05 AMOUNT가 0이면 저장못하도록 수정
					//Adjustment의 0값을 Combined시키기 위함
					if (sheetObj.CellValue(inx, prefix+"stl_locl_amt").length == 0
					||  sheetObj.CellValue(inx, prefix+"stl_locl_amt") == "0"){
						ComShowCodeMessage('JOO00056',inx);
						sheetObj.SelectCell(inx, prefix+"stl_locl_amt", true);
						return false;
					}
				}
			}
			
			if (cnt==0){
				ComShowCodeMessage('JOO00036');
				return false;
			}
			break;
			
			
		case IBDELETE: //전체삭제
			var isCombined = false;
			var stlCmbSeq = "";
			//전체 Data삭제시 하나라도 Combined된 data가 있으면 삭제불가
			for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
				stlCmbSeq = sheetObj.CellValue(i, prefix+"stl_cmb_seq");
				if (ComTrim(stlCmbSeq) != ""){
					isCombined = true;
					break;
				}
			}
			if (isCombined){
				ComShowCodeMessage('JOO00057',i, stlCmbSeq);
				return false;
			}
			break;
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SumText(0,prefix+"jo_stl_itm_cd") = "TOTAL"; //TOTAL이라는 글자가 잘리지 않게 넓은데로 옮김

	//combined data는 삭제 checkbox를 막는다.
	for (var i=sheetObj.HeaderRows; i<= sheetObj.LastRow; i++){
		var ibflag    = sheetObj.RowStatus(i);
		var stlCmbSeq = sheetObj.CellValue(i, prefix+"stl_cmb_seq");

		if (ComTrim(stlCmbSeq) == ""){
			sheetObj.CellEditable(i, prefix+"del_chk"    ) = true;
			sheetObj.CellEditable(i, prefix+"bsa_qty"    ) = true;
			sheetObj.CellEditable(i, prefix+"bsa_slt_prc") = true;
			sheetObj.CellEditable(i, prefix+"stl_rmk"    ) = true;

			var itm = sheetObj.CellValue(i,prefix+"jo_stl_itm_cd");
			if (itm == "S/H"){
				sheetObj.CellEditable(i, prefix+"jo_stl_jb_cd") = true;
				sheetObj.CellEditable(i, prefix+"stl_locl_amt") = false;
			}else if (itm == "OTH"){
				sheetObj.CellEditable(i, prefix+"jo_stl_jb_cd") = false;
				sheetObj.CellEditable(i, prefix+"stl_locl_amt") = true;
			}else{
				sheetObj.CellValue2(i, prefix+"jo_stl_jb_cd") = "";
				sheetObj.CellEditable(i, prefix+"jo_stl_jb_cd") = false;
				sheetObj.CellEditable(i, prefix+"stl_locl_amt") = false;
			}
		}else{
			sheetObj.CellEditable(i, prefix+"del_chk"     ) = false;
			sheetObj.CellEditable(i, prefix+"bsa_qty"     ) = false;
			sheetObj.CellEditable(i, prefix+"bsa_slt_prc" ) = false;
			sheetObj.CellEditable(i, prefix+"stl_rmk"     ) = false;
			sheetObj.CellEditable(i, prefix+"jo_stl_jb_cd") = false;
			sheetObj.CellEditable(i, prefix+"stl_locl_amt") = false;
		}

		if (sheetObj.CellValue(i,prefix+"cxl_vvd_flg") == "Y"){			
			sheetObj.CellBackColor(i,prefix+"cxl_vvd_flg") = sheetObj.RgbColor(255, 0, 0);			
		}
	}	
}

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
	var sName = sheetObj.ColSaveName(Col);

	var Value = sheetObj.EditValue;
	//4자리 치면 NEXT로 이동
	if ((sName == (prefix+"vsl_cd")) && (Value.length == 4)){
		sheetObj.SelectCell(Row, prefix+"skd_voy_no",true);
	}

	//4자리 치면 NEXT로 이동
	if (sName == prefix+"skd_voy_no" && Value.length==4){
		sheetObj.SelectCell(Row, prefix+"skd_dir_cd",true);
	}
	//1자리 치면 NEXT로 이동
	if (sName == (prefix+"skd_dir_cd")){
		sheetObj.SelectCell(Row, prefix+"rev_dir_cd",true);
	}
	//1자리 치면 NEXT로 이동
	if (sName == (prefix+"rev_dir_cd")){
		sheetObj.SelectCell(Row, prefix+"bsa_qty",true);
	}
}

/**
 * sheet1_OnChange
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	gCurRow = Row;

	if (sName == prefix+"jo_stl_itm_cd"){
		sheetObj.CellValue2(Row, prefix+"vsl_cd")     = "";
		sheetObj.CellValue2(Row, prefix+"skd_voy_no") = "";
		sheetObj.CellValue2(Row, prefix+"skd_dir_cd") = "";
		sheetObj.CellValue2(Row, prefix+"rev_dir_cd") = "";
		
		if (Value == "S/H"){
			sheetObj.CellEditable(Row, prefix+"jo_stl_jb_cd") = true;
			sheetObj.CellValue2(Row, prefix+"stl_locl_amt") = "";
			sheetObj.CellEditable(Row, prefix+"stl_locl_amt") = false;
		}else if (Value == "OTH"){
			sheetObj.CellValue2(Row, prefix+"jo_stl_jb_cd") = "";
			sheetObj.CellEditable(Row, prefix+"jo_stl_jb_cd") = false;
			sheetObj.CellEditable(Row, prefix+"stl_locl_amt") = true;
		}else{
			sheetObj.CellValue2(Row, prefix+"jo_stl_jb_cd") = "";
			sheetObj.CellValue2(Row, prefix+"stl_locl_amt") = "";
			sheetObj.CellEditable(Row, prefix+"stl_locl_amt") = false;
			sheetObj.CellEditable(Row, prefix+"jo_stl_jb_cd") = false;
		}
	}
	//수식이 아니므로 변경할때마다 계산해준다.
	if (sName == prefix+"bsa_qty" || sName == prefix+"bsa_slt_prc"){
		var bsaQty    = sheetObj.CellValue(Row, prefix+"bsa_qty");
		var bsaSltPrc = sheetObj.CellValue(Row, prefix+"bsa_slt_prc");
		
		var stlLoclAmt = Number(bsaQty) * Number(bsaSltPrc);
		sheetObj.CellValue(Row, prefix+"stl_locl_amt") = stlLoclAmt;
	}

	var vvd  = sheetObj.CellValue(Row, prefix+"vsl_cd");
	vvd += sheetObj.CellValue(Row, prefix+"skd_voy_no");
	vvd += sheetObj.CellValue(Row, prefix+"skd_dir_cd");
	vvd += sheetObj.CellValue(Row, prefix+"rev_dir_cd");
	
	if (sName == prefix+"vsl_cd" || sName==prefix+"skd_voy_no" || sName==prefix+"skd_dir_cd" || sName==prefix+"rev_dir_cd"){
		if (sheetObj.CellValue(Row, prefix+"jo_stl_itm_cd").length != 3){
			ComShowCodeMessage("JOO00043", Row - sheetObj.HeaderRows + 1);
			sheetObj.SelectCell(Row, prefix+"jo_stl_itm_cd", true);
		}
		
		var tmp = sheetObj.GetComboInfo(Row, prefix+"rev_dir_cd", "Code").split("|");
		if ( sName!=prefix+"rev_dir_cd" || tmp.length <= 1 && Value == "" && sheetObj.RowStatus(Row) == "I"){
			var vvd1  = sheetObj.CellValue(Row, prefix+"vsl_cd");
			vvd1 += sheetObj.CellValue(Row, prefix+"skd_voy_no");
			vvd1 += sheetObj.CellValue(Row, prefix+"skd_dir_cd");
			
			//VVD를 역으로 입력하므로 check할 필요없음 revenue dir. list 조회
			if (vvd1.length == 9){
				doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
			}
		}

		if (vvd.length == 10){
//			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}
	
	if (sName == prefix+"jo_stl_jb_cd"){
		var joStlItmCd = sheetObj.CellValue(Row, prefix+"jo_stl_itm_cd");
		if (joStlItmCd.length == 0){
			ComShowCodeMessage("JOO00043", Row - sheetObj.HeaderRows + 1);
			sheetObj.CellValue2(Row, prefix+"jo_stl_jb_cd") = "";
			sheetObj.SelectCell(Row, prefix+"jo_stl_itm_cd", true);
			return;
		}
		
		if (joStlItmCd == "S/H"){
			if (vvd.length < 10){
				ComShowCodeMessage("JOO00039");
				sheetObj.CellValue2(Row, prefix+"jo_stl_jb_cd") = "";
				sheetObj.SelectCell(Row, prefix+"vsl_cd", true);
				return;
			}
			//BSA Type Validation Check
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	var sName = sheetObj.ColSaveName(Col);
	var Val   = sheetObj.CellValue(Row, Col);
	//취소된 VVD는 이력을 보여준다.
	if (sName == prefix+"cxl_vvd_flg" && Val == "Y"){
		var vslCd    = sheetObj.CellValue(Row, prefix+"vsl_cd");
		var skdVoyNo = sheetObj.CellValue(Row, prefix+"skd_voy_no");
		var skdDirCd = sheetObj.CellValue(Row, prefix+"skd_dir_cd");
		var revDirCd = sheetObj.CellValue(Row, prefix+"rev_dir_cd");
		var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
		var joCrrCd  = sheetObj.CellValue(Row, prefix+"jo_crr_cd");
		var rlaneCd  = sheetObj.CellValue(Row, prefix+"rlane_cd");
		var param = "?vslCd="+vslCd+"&skdVoyNo="+skdVoyNo+"&skdDirCd="+skdDirCd+"&revDirCd="+revDirCd+"&reDivrCd="+reDivrCd+"&joCrrCd="+joCrrCd+"&rlaneCd="+rlaneCd;
		ComOpenPopup("/hanjin/FNS_JOO_0053.do"+param, 600, 440, "popupFinish", "1,0,1,1,1,1,1,1", true);
	}
}
/* 개발자 작업  끝 */