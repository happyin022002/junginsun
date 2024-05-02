/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0045.js
 *@FileTitle : Adjustment Slot Hire
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.07.20 박희동
 * 1.0 Creation
 * -----------------------------------------------------------------------
 * History
 * 2010.10.21 이준범 [CHM-201006630-01] Unit Cost Basic Port 컬럼 삭제 
 *            기존 Hidden으로 설정 된 컬럼에 대하여 DownExcel 시 보이지 않도록 옵션 변경
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
 * @class FNS_JOO_0045 : FNS_JOO_0045 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0045() {
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

var gYmFr;
var gYmTo;

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
		if (srcName == null || srcName == "re_divr_cd" || srcName == "stl_adj_irr_flg") {
			return;
		}

		//class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {
			case "btn_left_fm":
		    	sheetObjects[0].RemoveAll();
				if (formObj.fm_acct_yrmon.value!=""){
					var fr = ComGetDateAdd(formObj.fm_acct_yrmon.value+"-01","M",-1).substring(0,7);
					var to = formObj.to_acct_yrmon.value;

					if (!UF_checkPeriod(fr, to)){
						formObj.fm_acct_yrmon.focus();
						return;
					}
					formObj.fm_acct_yrmon.value = fr;
					
					gYmFr = ComReplaceStr(fr,"-","");
				}
				break;

			case "btn_right_fm":
		    	sheetObjects[0].RemoveAll();
				if (formObj.fm_acct_yrmon.value!=""){
					var fr = ComGetDateAdd(formObj.fm_acct_yrmon.value+"-01","M", 1).substring(0,7);
					var to = formObj.to_acct_yrmon.value;
					if (!UF_checkPeriod(fr, to)){
						formObj.fm_acct_yrmon.focus();
						return;
					}
					formObj.fm_acct_yrmon.value = fr;
					
					gYmFr = ComReplaceStr(fr,"-","");
				}
				break;

			case "btn_left_to":
		    	sheetObjects[0].RemoveAll();
				if (formObj.to_acct_yrmon.value!=""){
					var fr = formObj.fm_acct_yrmon.value;
					var to = ComGetDateAdd(formObj.to_acct_yrmon.value+"-01","M",-1).substring(0,7);
					if (!UF_checkPeriod(fr, to)){
						formObj.to_acct_yrmon.focus();
						return;
					}
					formObj.to_acct_yrmon.value = to;
					
					gYmTo = ComReplaceStr(to,"-","");
				}
				break;

			case "btn_right_to":
		    	sheetObjects[0].RemoveAll();
				if (formObj.to_acct_yrmon.value!=""){
					var fr = formObj.fm_acct_yrmon.value;
					var to = ComGetDateAdd(formObj.to_acct_yrmon.value+"-01","M", 1).substring(0,7);
					if (!UF_checkPeriod(fr, to)){
						formObj.to_acct_yrmon.focus();
						return;
					}
					formObj.to_acct_yrmon.value = to;
					
					gYmTo = ComReplaceStr(to,"-","");
				}
				break;

			case "btns_back":
				formObj.jo_crr_cd.focus();
				sheetObjects[0].RemoveAll();
				if (formObj.acct_yrmon.value!=""){
					formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M",-1).substring(0,7);
					//UF_setAcctYrmon(formObj.acct_yrmon.value);					
				}
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
				break;				
				
			case "btns_next":
				formObj.jo_crr_cd.focus();
		    	sheetObjects[0].RemoveAll();
				if (formObj.acct_yrmon.value!=""){
					formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M", 1).substring(0,7);
					//UF_setAcctYrmon(formObj.acct_yrmon.value);					
				}
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
				break;
	
			case "btn_delete":
				JooRowHideDelete(sheetObject1, prefix+"del_chk");
				break;

			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
	
			case "btn_new":
				sheetObjects[0].RemoveAll();
				formObj.jo_crr_cd.Index2 = -1;
				formObj.trd_cd.Index2 = -1;
				formObj.rlane_cd.Index2 = -1;
				formObj.re_divr_cd[0].checked = true;
				formObj.fm_acct_yrmon.focus();
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
	
			case "btn_downexcel":
				sheetObject1.SpeedDown2Excel(0,false,false,"","",false,false,"", false, prefix+"del_chk"+"|"+prefix+"vsl_cd"+"|"+prefix+"skd_voy_no"+"|"+prefix+"skd_dir_cd"+"|"+prefix+"rev_dir_cd"+"|"+prefix+"stl_bzc_port_cd"+"|"+prefix+"eta_dt"+"|"+prefix+"rn"+"|"+prefix+"uc_bss_port_cd"+"|"+prefix+"stl_adj_irr_flg"+"|"+prefix+"acct_yrmon"+"|"+prefix+"stl_vvd_seq"+"|"+prefix+"stl_seq"+"|"+prefix+"jo_crr_cd"+"|"+prefix+"re_divr_cd"+"|"+prefix+"trd_cd"+"|"+prefix+"rlane_cd"+"|"+prefix+"jo_stl_itm_cd"+"|"+prefix+"stl_adj_flg"+"|"+prefix+"pre_acct_yrmon"+"|"+prefix+"pre_stl_vvd_seq"+"|"+prefix+"pre_stl_seq"+"|"+prefix+"stl_lst_flg"+"|"+prefix+"uc_bss_port_etd_dt"+"|"+prefix+"slip_no","",false,"",false);
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
    
    gYmFr = gYYYYMM;
    gYmTo = gYYYYMM;
    
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
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);    

    axon_event.addListener('blur' , 'fm_acct_yrmon_onblur', 'fm_acct_yrmon');
    axon_event.addListener('blur' , 'to_acct_yrmon_onblur', 'to_acct_yrmon');
    axon_event.addListener('click', 'change_event_radio', 're_divr_cd');
    axon_event.addListener('click', 'diff_only_yn_click', 'diff_only_yn');
    axon_event.addListener('keypress', 'acct_yrmon_keypress', 'acct_yrmon');	
    axon_event.addListener('keypress', 'fm_acct_yrmon_keypress', 'fm_acct_yrmon');	
    axon_event.addListener('keypress', 'to_acct_yrmon_keypress', 'to_acct_yrmon');	
    
    formObj.acct_yrmon.focus();
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur(){
    ComChkObjValid(event.srcElement);
    
	var src = window.event.srcElement.getAttribute("name")
    if (src == "acct_yrmon"){
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC10);
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

function obj_onclick(){
	var src = window.event.srcElement.getAttribute("name")
}

function fm_acct_yrmon_onblur(){
	var fm = ComReplaceStr(document.form.fm_acct_yrmon.value,"-","")+"01";	
	var to = ComReplaceStr(document.form.to_acct_yrmon.value,"-","")+"01";
	
	if (!UF_checkPeriod(fm,to)){
		document.form.fm_acct_yrmon.focus();
	}
	
	gYmFr = ComReplaceStr(document.form.fm_acct_yrmon.value,"-","");
}

function to_acct_yrmon_onblur(){
	var fm = ComReplaceStr(document.form.fm_acct_yrmon.value,"-","")+"01";	
	var to = ComReplaceStr(document.form.to_acct_yrmon.value,"-","")+"01";
	
	if (!UF_checkPeriod(fm,to)){
		document.form.to_acct_yrmon.focus();
	}
	
	gYmTo = ComReplaceStr(document.form.to_acct_yrmon.value,"-","");
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

function diff_only_yn_click(){
	var form = document.form;
	var sheetObj = sheetObjects[0];
	sheetObj.RemoveAll();
	
	var i = sheetObj.HeaderRows;
	var status = sheetObj.RowStatus(i);
	
	var calDiffTEUAmt = "|sheet1_bsa_slt_prc| * |sheet1_dtl_bsa_qty|";
	var calDiffPrcAmt = "|sheet1_bsa_qty1| * |sheet1_dtl_bsa_slt_prc|";
	var calTotAmt     = "|sheet1_adj_bsa_qty_locl_amt| + |sheet1_adj_bsa_slt_prc_locl_amt|";
	
	if (form.diff_only_yn.checked){
		form.fm_acct_yrmon.readOnly = false;
		form.to_acct_yrmon.readOnly = false;
		form.btn_left_fm.disabled  = false;
		form.btn_left_to.disabled  = false;
		form.btn_right_fm.disabled = false;
		form.btn_right_to.disabled = false;
		form.fm_acct_yrmon.value = gYmFr;//gYYYYMM;
		form.to_acct_yrmon.value = gYmTo;//gYYYYMM;
		form.diff_only_yn.value = "Y";
//		for (var inx=0; inx<form.stl_adj_irr_flg.length; inx++){
//			form.stl_adj_irr_flg[inx].disabled = false;
//		}
		form.fm_acct_yrmon.focus();
	}else{
		form.fm_acct_yrmon.value = "";
		form.to_acct_yrmon.value = "";
		form.fm_acct_yrmon.readOnly = true;
		form.to_acct_yrmon.readOnly = true;
		form.btn_left_fm.disabled  = true;
		form.btn_left_to.disabled  = true;
		form.btn_right_fm.disabled = true;
		form.btn_right_to.disabled = true;
		form.diff_only_yn.value = "N";		
//		form.stl_adj_irr_flg[0].checked =true;
//		for (var inx=0; inx<form.stl_adj_irr_flg.length; inx++){
//			form.stl_adj_irr_flg[inx].disabled = true;
//		}
		calDiffTEUAmt = "";
		calDiffPrcAmt = "";
		calTotAmt     = "";
		form.acct_yrmon.focus();
	}

	with (sheetObj){
		InitDataProperty(0, 17, dtData        ,  80, daRight ,false, prefix+"adj_bsa_qty_locl_amt"    , false, calDiffTEUAmt, dfNullFloat  ,2,false,false);//17
		InitDataProperty(0, 18, dtData        ,  80, daRight ,false, prefix+"adj_bsa_slt_prc_locl_amt", false, calDiffPrcAmt, dfNullFloat  ,2,false,false);//18
		InitDataProperty(0, 19, dtAutoSum     ,  80, daRight ,false, prefix+"stl_locl_amt"            , false, calTotAmt    , dfNullFloat  ,2,false,false);//19
	}
}

function acct_yrmon_keypress(){
	ComKeyOnlyNumber(this, '');
}

function fm_acct_yrmon_keypress(){
	ComKeyOnlyNumber(this, '');
}

function to_acct_yrmon_keypress(){
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
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 382;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle1 = "STS|VVD|VSL|VOY|Dir.|Fin.\nDir.|BSA Type.|COA BSA|COA BSA|Manual\nSettle|RN||JOO_BSA|JOO_BSA|Difference BSA|Difference BSA|Cur.|Adjustment Amount|Adjustment Amount|Adjustment Amount|Flg|Remark|Unit Cost\nBasic Port|Combined\nNo"
				           + "|acct_yrmon|stl_vvd_seq|stl_seq|jo_crr_cd|re_divr_cd|trd_cd|rlane_cd|jo_stl_itm_cd|stl_adj_flg|pre_acct_yrmon|pre_stl_vvd_seq|pre_stl_seq|stl_lst_flg|uc_bss_port_etd_dt|slip_no|Basic\nPort|Schedule";

			var HeadTitle2 = "STS|VVD|VSL|VOY|Dir.|Fin.\nDir.|BSA Type.|TEU|Price|Manual\nSettle|RN||TEU|Price|TEU|Price|Cur.|TEU DIFF|Price DIFF|Total|Flg|Remark|Unit Cost\nBasic Port|Combined\nNo"
		                   + "|acct_yrmon|stl_vvd_seq|stl_seq|jo_crr_cd|re_divr_cd|trd_cd|rlane_cd|jo_stl_itm_cd|stl_adj_flg|pre_acct_yrmon|pre_stl_vvd_seq|pre_stl_seq|stl_lst_flg|uc_bss_port_etd_dt|slip_no|Basic\nPort|Schedule";

			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount,11, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			var calDiffTEU = "|sheet1_bsa_qty| - |sheet1_bsa_qty1|";
			var calDiffPrc = "|sheet1_bsa_slt_prc| - |sheet1_bsa_slt_prc1|";
			var calDiffTEUAmt = "|sheet1_bsa_slt_prc| * |sheet1_dtl_bsa_qty|";
			var calDiffPrcAmt = "|sheet1_bsa_qty1| * |sheet1_dtl_bsa_slt_prc|";
			var calTotAmt     = "|sheet1_adj_bsa_qty_locl_amt| + |sheet1_adj_bsa_slt_prc_locl_amt|";

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus      ,  30, daCenter, true,	prefix+"ibflag" ); //0
			InitDataProperty(0, cnt++, dtData        ,  80, daCenter, true, prefix+"vvd"                     , false, ""           , dfNone       ,0,false,false,4);//3
			InitDataProperty(0, cnt++, dtHidden      ,  50, daCenter, true, prefix+"vsl_cd"                  , false, ""           , dfNone       ,0,false,false,4);//3
			InitDataProperty(0, cnt++, dtHidden      ,  50, daCenter, true, prefix+"skd_voy_no"              , false, ""           , dfNone       ,0,false,false,4);//4
			InitDataProperty(0, cnt++, dtHidden      ,  40, daCenter, true, prefix+"skd_dir_cd"              , false, ""           , dfNone       ,0,false,false,1);//5
			InitDataProperty(0, cnt++, dtHidden      ,  40, daCenter, true, prefix+"rev_dir_cd"              , false, ""           , dfNone       ,0,false,false,1);//6
			InitDataProperty(0, cnt++, dtCombo       , 100, daLeft  , true, prefix+"jo_stl_jb_cd"            , false, ""           , dfNone       ,0,false,false);//8
			InitDataProperty(0, cnt++, dtData        ,  50, daRight , true, prefix+"bsa_qty"                 , false, ""           , dfNullInteger,0,false,false);//10
			InitDataProperty(0, cnt++, dtData        ,  50, daRight , true, prefix+"bsa_slt_prc"             , false, ""           , dfNullFloat  ,2,false,false);//11
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, prefix+"jo_mnu_nm"               , false, ""           , dfNone       ,0,false,false);//9
			InitDataProperty(0, cnt++, dtHidden      ,  50, daCenter, true, prefix+"rn"                      , false, ""           , dfNone       ,0,false,false);//9
			InitDataProperty(0, cnt++, dtCheckBox    ,  30, daCenter, true, prefix+"del_chk"); //1
			InitDataProperty(0, cnt++, dtData        ,  50, daRight ,false, prefix+"bsa_qty1"                , false, ""           , dfNullInteger,0,false,false);//12
			InitDataProperty(0, cnt++, dtData        ,  50, daRight ,false, prefix+"bsa_slt_prc1"            , false, ""           , dfNullFloat  ,2,false,false);//13
			InitDataProperty(0, cnt++, dtData        ,  50, daRight ,false, prefix+"dtl_bsa_qty"             , false, ""/*calDiffTEU*/   , dfNullInteger,0,false,false);//14
			InitDataProperty(0, cnt++, dtData        ,  50, daRight ,false, prefix+"dtl_bsa_slt_prc"         , false, ""/*calDiffPrc*/   , dfNullFloat  ,2,false,false);//15
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, prefix+"locl_curr_cd"            , false, ""           , dfNone       ,0,false,false);//16
			InitDataProperty(0, cnt++, dtData        ,  80, daRight ,false, prefix+"adj_bsa_qty_locl_amt"    , false, calDiffTEUAmt, dfNullFloat  ,2,false,false);//17
			InitDataProperty(0, cnt++, dtData        ,  80, daRight ,false, prefix+"adj_bsa_slt_prc_locl_amt", false, calDiffPrcAmt, dfNullFloat  ,2,false,false);//18
			InitDataProperty(0, cnt++, dtAutoSum     ,  80, daRight ,false,	prefix+"stl_locl_amt"            , false, calTotAmt    , dfNullFloat  ,2,false,false);//19
			//2010.03.23 임시로 막음
			//InitDataProperty(0, cnt++, dtCheckBox    ,  60, daCenter, true, prefix+"stl_adj_irr_flg"         , false, ""           , dfNone       ,0,false,true );//21
			InitDataProperty(0, cnt++, dtHidden      ,  60, daCenter, true, prefix+"stl_adj_irr_flg"         , false, ""           , dfNone       ,0,false,true );//21
			InitDataProperty(0, cnt++, dtData        , 100, daCenter, true, prefix+"stl_adj_irr_rmk"         , false, ""           , dfNone       ,0,false,true ,100);//22
			InitDataProperty(0, cnt++, dtHidden      ,  70, daCenter, true, prefix+"uc_bss_port_cd"          , false, ""           , dfNone       ,0,false,false);//7
			InitDataProperty(0, cnt++, dtData        ,  65, daCenter, true, prefix+"stl_cmb_seq"             , false, ""           , dfNone       ,0,false,false);//20

			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"acct_yrmon"              , false, ""           , dfNone       ,0,false,false);//23
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"stl_vvd_seq"             , false, ""           , dfNone       ,0,false,false);//24
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"stl_seq"                 , false, ""           , dfNone       ,0,false,false);//25
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"jo_crr_cd"               , false, ""           , dfNone       ,0,false,false);//26
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"re_divr_cd"              , false, ""           , dfNone       ,0,false,false);//27
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"trd_cd"                  , false, ""           , dfNone       ,0,false,false);//28
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"rlane_cd"                , false, ""           , dfNone       ,0,false,false);//29
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"jo_stl_itm_cd"           , false, ""           , dfNone       ,0,false,false);//30
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"stl_adj_flg"             , false, ""           , dfNone       ,0,false,false);//32
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"pre_acct_yrmon"          , false, ""           , dfNone       ,0,false,false);//33
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"pre_stl_vvd_seq"         , false, ""           , dfNone       ,0,false,false);//34
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"pre_stl_seq"             , false, ""           , dfNone       ,0,false,false);//35
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"stl_lst_flg"             , false, ""           , dfNone       ,0,false,false);//36
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"uc_bss_port_etd_dt"      , false, ""           , dfNone       ,0,false,false);//38
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  ,false, prefix+"slip_no"                 , false, ""           , dfNone       ,0,false,false);//39
			InitDataProperty(0, cnt++, dtHidden      ,   0, daCenter,false, prefix+"stl_bzc_port_cd"         , false, ""           , dfNone       ,0,false,false);//7
			InitDataProperty(0, cnt++, dtHidden      ,   0, daCenter,false, prefix+"eta_dt"                  , false, ""           , dfNone       ,0,false,false);//8

			//TOTAL 글자가  첫번째 column에 와서 잘리는 것을 방지하기 위함 
			MessageText("Sum") = "";
			
//			InitDataValid(0, prefix+"vsl_cd"     , vtEngUpOnly  );//영문대문자
//			InitDataValid(0, prefix+"skd_voy_no" , vtNumericOnly);//숫자만 올 수 있음
//			InitDataValid(0, prefix+"stl_cmb_seq", vtNumericOnly);//숫자만 올 수 있음
			InitDataCombo(0, prefix+"jo_stl_jb_cd", gStlComnm    , gStlCombo);
			
//			InitUserFormat2(0, prefix+"eta_dt" , "####-##-## ##:##:##", "-|:");
		}
		break;
		
	case 2: // sheet1 init
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
			sheetObj.DoSearch("FNS_JOO_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;

		case IBSAVE: //저장
			if (!ComShowCodeConfirm("JOO00046")){
				return false;
			}
			
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("FNS_JOO_0045GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix), -1, false);
			break;

		case IBSEARCH_ASYNC10: //마감여부 조회
			formObj.f_cmd.value = SEARCH10;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0045GS.do", FormQueryString(formObj));
			
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				gClzYn = ComGetEtcData(sXml,"clz_yn"); 
				if (gClzYn == "C"){
					ComShowCodeMessage("JOO00177");
					JooSetBtnClass("C", false);
					sheetObjects[0].Editable = false;
				//Open상태면 Authority에 따라 Button을 활성화, 비활성화 한다.
				}else{
					if (comboObjects[2].index != -1){
						var code = comboObjects[2].Code;
						UF_setAuth(comboObjects[2].GetText(code, 2));
					}
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
 				SetColAlign("left|left|left");        
 				SetColWidth("30|0|0"); //rlane_cd, , auth_cd
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
 				MaxLength=5;
  		    }
  			break;
 	} 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
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
				formObj.code.value = formObj.jo_stl_itm_cd.value; //Item
				formObj.name.value = JooGetRadioValue(formObj.re_divr_cd); //re_divr_cd
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = formObj.trd_cd.Code;
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
                ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code|name|auth_cd");
//
//				var nameList = ComGetEtcData(sXml, "nameList").split("|");
//				var codeList = ComGetEtcData(sXml, "codeList").split("|");
//
//				for(var i=0; i < nameList.length; i++){
//					sComboObj.InsertItem(i, codeList[i] + "|" + nameList[i], codeList[i]);
//				}
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
	comboObjects[2].Index2 = -1;
	comboObjects[2].RemoveAll();
	sheetObjects[0].RemoveAll();
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
	var formObj = document.form;
	
	sheetObjects[0].RemoveAll();
	formObj.locl_curr_cd.value = comboObj.GetText(code,1);
	UF_setAuth(comboObj.GetText(code,2));
	
	if (comboObj.GetText(code,2) == "R"){
		formObj.diff_only_yn.checked = false;
		formObj.diff_only_yn.value = "N";
		formObj.diff_only_yn.disabled = true;
	}else{
		formObj.diff_only_yn.disabled = false;
	}
	diff_only_yn_click();	
}

function rlane_cd_OnBlur(comboObj){
	if (comboObj.Code.length == 5){
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}

function UF_setAuth(auth){
	//마감되었다면 이미 버튼제어가 된 상태고 권한에 상관없이 disable
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

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
			if (formObj.diff_only_yn.checked){
				if (formObj.fm_acct_yrmon.value.length == 0){
					ComShowCodeMessage('JOO00089');
					formObj.fm_acct_yrmon.focus();
					return false;
				}
				if (formObj.to_acct_yrmon.value.length == 0){
					ComShowCodeMessage('JOO00089');
					formObj.to_acct_yrmon.focus();
					return false;
				}
				
				var fmDate = ComReplaceStr(formObj.fm_acct_yrmon.value,"-","")+"01";
				var toDate = ComReplaceStr(formObj.to_acct_yrmon.value,"-","")+"01";
				
				var fmDateAdd6m = ComGetDateAdd(fmDate,"M",6);
				//6개월 이상 차이나면 error message
				if (ComGetDaysBetween(fmDateAdd6m, toDate) > 0){
					ComShowCodeMessage("JOO00090");
					formObj.fm_acct_yrmon.focus();
					return false;
				}
				
				var yrmon = ComReplaceStr(formObj.acct_yrmon.value,"-","")+"01";

				//to_acct_yrmon이 acct_yrmon보다 이후이면 안된다.
				if (ComGetDaysBetween(toDate, yrmon) < 0){
					ComShowCodeMessage("JOO00091");
					formObj.to_acct_yrmon.focus();
					return false;
				}
			}
			
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
			var cnt = 0;
			for (var inx=sheetObj.HeaderRows; inx <= sheetObj.LastRow; inx++){
				var status = sheetObj.RowStatus(inx); 
				if (status =="R")
					continue;
				cnt++;

				var slip = sheetObj.CellValue(inx, prefix+"slip_no");

				if (status == "D" &&  slip != ""){
					ComShowCodeMessage('JOO00057',inx, slip);
					sheetObj.SelectCell(inx, prefix+"del_chk", true);
					return false;
				}
				
				if ((status == "I" || status == "U") && sheetObj.CellValue(inx, prefix+"del_chk") == "1"){
					ComShowCodeMessage("JOO00079");
					sheetObj.SelectCell(inx,prefix+"del_chk",true);
					return false;
				}

				if (sheetObj.CellValue(inx, prefix+"vsl_cd").length < 4){
					ComShowCodeMessage('JOO00040',inx);
					sheetObj.SelectCell(inx, prefix+"vsl_cd", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"skd_voy_no").length < 4){
					ComShowCodeMessage('JOO00041',inx);
					sheetObj.SelectCell(inx, prefix+"skd_voy_no", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"skd_dir_cd").length < 1){
					ComShowCodeMessage('JOO00042',inx);
					sheetObj.SelectCell(inx, prefix+"skd_dir_cd", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"rev_dir_cd").length < 1){
					ComShowCodeMessage('JOO00055',inx);
					sheetObj.SelectCell(inx, prefix+"rev_dir_cd", true);
					return false;
				}
				if (sheetObj.CellValue(inx, prefix+"stl_locl_amt").length == 0){
					ComShowCodeMessage('JOO00056',inx);
					sheetObj.SelectCell(inx, prefix+"stl_locl_amt", true);
					return false;
				}
			}
			
			if (cnt==0){
				ComShowCodeMessage('JOO00036');
				return false;
			}
			break;
	}
	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SumText(0,prefix+"vsl_cd") = "TOTAL"; //TOTAL이라는 글자가 잘리지 않게 넓은데로 옮김

	//Combined No가 있는 자료는 삭제 불가
	for (var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
		var rowStatus = sheetObj.RowStatus(inx);
		var stlCmbSeq = sheetObj.CellValue(inx, prefix+"stl_cmb_seq");
		if (rowStatus == "R" && ComTrim(stlCmbSeq) != ""){
			sheetObj.CellEditable(inx, prefix+"del_chk") = false;
		}else{
			sheetObj.CellEditable(inx, prefix+"del_chk") = true;
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
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	gCurRow = Row;
}

/**
 * acct_yrmon이 변경되었을 경우 sheet내의 Insert mode인 row의 acct_yrmon을 변경한다.
 * @param acctYrmon
 * @return
 */
function UF_setAcctYrmon(acctYrmon){
	var sheetObj = sheetObjects[0];
	for (var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
		if (sheetObj.RowStatus(inx) != "I") continue;
		sheetObj.CellValue2(inx, prefix+"acct_yrmon") = acctYrmon;
	}
}

function UF_checkPeriod(fr, to){
	var fmDate = ComReplaceStr(fr)+"01";  
	var toDate = ComReplaceStr(to)+"01";  

	if (ComGetDaysBetween(fmDate, toDate) < 0){
		ComShowCodeMessage("JOO00078");
		return false;
	}
	
//	var fmDateAdd6m = ComGetDateAdd(fmDate,"M",6);
//	
//	if (ComGetDaysBetween(fmDateAdd6m, toDate) > 0){
//		ComShowCodeMessage("JOO00090");
//		return false;
//	}
	
	return true;
}
/* 개발자 작업  끝 */