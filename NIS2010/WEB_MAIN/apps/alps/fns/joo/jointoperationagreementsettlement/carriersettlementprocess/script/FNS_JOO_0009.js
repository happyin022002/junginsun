/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0009.js
 *@FileTitle : Over Used Slot Hire for RDR
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.09
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.06.09 박희동
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.11.12 신자영 [CHM-201007065-01] JOO Unit Cost Basic Port컬럼 삭제 요청
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
 * @class fns_joo_0009 : fns_joo_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0009() {
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
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC10);
				break;
	
			case "btns_next":
				formObj.jo_crr_cd.focus();
				sheetObjects[0].RemoveAll();
				if (formObj.acct_yrmon.value!=""){
					formObj.acct_yrmon.value = ComGetDateAdd(formObj.acct_yrmon.value+"-01","M", 1).substring(0,7);
				}
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
				var rtu    = formObj.rlane_cd.GetText(idx_cd,1);
				
//				if (rtu.length != 1){
//					ComShowCodeMessage('JOO00083');
//					return;
//				}
				
				var loclCurrCd = formObj.rlane_cd.GetText(idx_cd,2);
				
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
				sheetObjects[0].CellValue2(row, prefix+"jo_stl_itm_cd") = formObj.jo_stl_itm_cd.value;
				sheetObjects[0].CellValue2(row, prefix+"jo_mnu_nm"    ) = formObj.jo_mnu_nm.value;
				sheetObjects[0].CellValue2(row, prefix+"skd_dir_cd"   ) = "";
				sheetObjects[0].CellValue2(row, prefix+"rev_dir_cd"   ) = "";
				sheetObjects[0].CellValue2(row, prefix+"ioc_cd"       ) = "";
				sheetObjects[0].CellValue2(row, prefix+"sconti_cd"    ) = "";
				sheetObjects[0].CellValue2(row, prefix+"locl_curr_cd" ) = loclCurrCd;
				sheetObjects[0].CellValue2(row, prefix+"stl_adj_flg"  ) = "N"; //보정여부 N
				sheetObjects[0].CellValue2(row, prefix+"stl_lst_flg"  ) = "Y"; //최종여부 Y
				
				sheetObjects[0].SelectCell(row, prefix+"vsl_cd", true);			
				break;
	
			case "btn_delete":
				JooRowHideDelete(sheetObject1, prefix+"del_chk");
				break;

			case "btn_delete_all":
				doActionIBSheet(sheetObject1, formObj, IBDELETE);
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
				formObj.re_divr_cd[0].checked = true;
				formObj.acct_yrmon.focus();
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
	
			case "btn_downexcel":
				sheetObject1.SpeedDown2Excel();
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
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);    

    axon_event.addListener('keypress', 'acct_yrmon_keypress', 'acct_yrmon');	
    axon_event.addListener('click', 'change_event_radio', 're_divr_cd');
    
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
			style.height = 394;
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
			//Unit Cost\nBasic Port| 제외함 (2010.11.15 신자영 [CHM-201007065-01] JOO Unit Cost Basic Port컬럼 삭제 요청)
			var HeadTitle  = "STS||VSL|VOY|Dir|Fin.\nDir|Inter/\nOcean|RGN|Dep.\nPort|1st BSA|1st BSA|Used Slot|Used Slot";
			HeadTitle += "|Over Used|Over Used|BSA\nWeight\nPer TEU|Confirm\nOver\nUsed|BSA Over\nUsed Slot\nPrice|Currency|Amount|Combined\nNo|RVS|Basic Port|Schedule|Unit Cost\nBasic Port|acct_yrmon|stl_vvd_seq|stl_seq|trd_cd|jo_crr_cd|rlane_cd|re_divr_cd|jo_stl_itm_cd|jo_mnu_nm|uc_bss_port_etd_dt|slip_no|stl_adj_flg|stl_lst_flg|Dup";

			var HeadTitle1 = "STS||VSL|VOY|Dir|Fin.\nDir|Inter/\nOcean|RGN|Dep.\nPort|TEU|WGT|TEU|WGT";
			HeadTitle1 += "|TEU|WGT|BSA\nWeight\nPer TEU|Confirm\nOver\nUsed|BSA Over\nUsed Slot\nPrice|Currency|Amount|Combined\nNo|RVS|Basic Port|Schedule|Unit Cost\nBasic Port|acct_yrmon|stl_vvd_seq|stl_seq|trd_cd|jo_crr_cd|rlane_cd|re_divr_cd|jo_stl_itm_cd|jo_mnu_nm|uc_bss_port_etd_dt|slip_no|stl_adj_flg|stl_lst_flg|Dup";

			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 8, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			InitHeadRow(1, HeadTitle1, true);
			
			//SetMergeCell(0,2,2,4);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus      ,  30, daCenter, true,	prefix+"ibflag" ); //0
			InitDataProperty(0, cnt++, dtCheckBox    ,  30, daCenter, true, prefix+"del_chk"); //1
			InitDataProperty(0, cnt++, dtData        ,  40, daCenter, true, prefix+"vsl_cd",         false, "", dfNone       ,0,false, true,  4);//2
			InitDataProperty(0, cnt++, dtData        ,  40, daCenter, true, prefix+"skd_voy_no",     false, "", dfNone       ,0,false, true,  4);//3
			InitDataProperty(0, cnt++, dtCombo       ,  30, daCenter, true, prefix+"skd_dir_cd",     false, "", dfNone       ,0,false, true,  1);//4
			InitDataProperty(0, cnt++, dtData        ,  30, daCenter, true, prefix+"rev_dir_cd",     false, "", dfNone       ,0,false,false,  1);//5
			InitDataProperty(0, cnt++, dtCombo       ,  70, daCenter, true, prefix+"ioc_cd",         false, "", dfNone       ,0,false, true);//9
			InitDataProperty(0, cnt++, dtCombo       ,  40, daCenter, true, prefix+"sconti_cd",      false, "", dfNone       ,0,false, true);//10
			InitDataProperty(0, cnt++, dtData        ,  50, daCenter, true, prefix+"fm_port_cd",     false, "", dfNone       ,0,false,false,  5);//11
			InitDataProperty(0, cnt++, dtData        ,  50, daRight , true, prefix+"fnl_hjs_bsa_qty",false, "", dfInteger    ,0,false,false);//12
			InitDataProperty(0, cnt++, dtData        ,  70, daRight , true, prefix+"fnl_bsa_wgt"    ,false, "", dfFloat      ,2,false,false);//13
			InitDataProperty(0, cnt++, dtData        ,  50, daRight , true, prefix+"usd_slt_bsa_qty",false, "", dfInteger    ,0,true ,true);//14
			InitDataProperty(0, cnt++, dtData        ,  70, daRight , true, prefix+"usd_slt_wgt"    ,false, "", dfFloat      ,2,true ,true);//15
			InitDataProperty(0, cnt++, dtData        ,  40, daRight , true, prefix+"over_usd_qty"   ,false, "|sheet1_usd_slt_bsa_qty|-|sheet1_fnl_hjs_bsa_qty|", dfInteger,0,false,false);//16
			InitDataProperty(0, cnt++, dtData        ,  80, daRight , true, prefix+"over_usd_wgt"   ,false, "|sheet1_usd_slt_wgt|-|sheet1_fnl_bsa_wgt|", dfFloat, 2,false,false);//17
			//2010.03.25 BSA Per Weight I/F후에도 수정가능하게 해달라 (박효숙 차장)
			//InitDataProperty(0, cnt++, dtData        ,  60, daRight , true, prefix+"bsa_per_wgt"    ,false, "", dfFloat      ,2,false,false);//18
			InitDataProperty(0, cnt++, dtData        ,  60, daRight , true, prefix+"bsa_per_wgt"    ,false, "", dfFloat      ,2,false, true);//18
			InitDataProperty(0, cnt++, dtData        ,  60, daRight , true, prefix+"bsa_qty"        ,false, "IF (IF(|sheet1_over_usd_qty| >= Round(|sheet1_over_usd_wgt|/|sheet1_bsa_per_wgt|,0), |sheet1_over_usd_qty|, Round(|sheet1_over_usd_wgt|/|sheet1_bsa_per_wgt|,0)) > 0 , IF(|sheet1_over_usd_qty| >= Round(IF(|sheet1_bsa_per_wgt|=0,0,|sheet1_over_usd_wgt|/|sheet1_bsa_per_wgt|),0), |sheet1_over_usd_qty|, Round(IF(|sheet1_bsa_per_wgt|=0,0,|sheet1_over_usd_wgt|/|sheet1_bsa_per_wgt|),0)),0)", dfInteger,0,false,false);//19
			InitDataProperty(0, cnt++, dtData        ,  60, daRight , true, prefix+"bsa_slt_prc"    ,false, "", dfFloat      ,2,true,true);//20
			InitDataProperty(0, cnt++, dtData        ,  80, daCenter, true, prefix+"locl_curr_cd"   ,false, "", dfNone       ,0,false,false);//21
			InitDataProperty(0, cnt++, dtAutoSum     ,  80, daRight , true, prefix+"stl_locl_amt"   ,false, "Round(|sheet1_bsa_qty|*|sheet1_bsa_slt_prc|,2)", dfFloat, 2,false,false);//22
			InitDataProperty(0, cnt++, dtData        ,  80, daCenter, true, prefix+"stl_cmb_seq"    ,false, "", dfNone       ,0,false,false);//23
			InitDataProperty(0, cnt++, dtData        ,  40, daCenter, true, prefix+"rvs_cmb_flg"    ,false, "", dfNone       ,0,false,false);//23
			InitDataProperty(0, cnt++, dtData        ,  70, daCenter, true, prefix+"stl_bzc_port_cd",false, "", dfNone       ,0,false,false);//6
			InitDataProperty(0, cnt++, dtData        , 110, daCenter, true, prefix+"eta_dt",         false, "", dfUserFormat2,0,false,false);//7
			//2010.11.15 신자영 [CHM-201007065-01] JOO Unit Cost Basic Port컬럼 삭제 요청 - dtHidden으로 변경
			InitDataProperty(0, cnt++, dtHidden      ,  70, daCenter, true, prefix+"uc_bss_port_cd", false, "", dfNone       ,0,false,false);//8

			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"acct_yrmon"        , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"stl_vvd_seq"       , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"stl_seq"           , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"trd_cd"            , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"jo_crr_cd"         , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"rlane_cd"          , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"re_divr_cd"        , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"jo_stl_itm_cd"     , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"jo_mnu_nm"         , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"uc_bss_port_etd_dt", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"slip_no"           , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"stl_adj_flg"       , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , false, prefix+"stl_lst_flg"       , false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      ,   0, daLeft  , true , prefix+"stl_dup_flg"       , false, "", dfNone, 0, false, false);

			MessageText("Sum") = ""; //summary row에 자동으로 생성되는 TOTAL이란 글자를 없앰
			
			InitDataValid(0, prefix+"vsl_cd"     , vtEngUpOther, "0123456789");//영문대문자+숫자
			InitDataValid(0, prefix+"skd_voy_no" , vtNumericOnly);//숫자만 올 수 있음
			InitDataValid(0, prefix+"fm_port_cd" , vtEngUpOnly  );//영문대문자
			
			InitDataCombo(0, prefix+"skd_dir_cd"  , "E|W|S|N", "E|W|S|N");
			InitDataCombo(0, prefix+"ioc_cd"      , gIoc         , gIoc);
			InitDataCombo(0, prefix+"sconti_cd"   , gRgnCombo    , gRgnCombo);

			InitUserFormat2(0, prefix+"eta_dt" , "####-##-## ##:##:##", "-|:");

			HeadRowHeight = 25;
		}
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
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml);
			break;

		//Create
		case IBCREATE:
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml);
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
				var addedCnt = 0;
				for(var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
					//첫번째 입력가능 필드에 focusing 
					if (sheetObj.RowStatus(inx) == "I"){
						sheetObj.SelectCell(inx,prefix+"jo_stl_jb_cd",true);
						addedCnt ++;
						break;
					}
				}
				
				if (addedCnt == 0){
					ComShowCodeMessage('JOO00054');
				}
			}
			break;
			
		//저장
		case IBSAVE:
			var SaveStr = ComGetSaveString(sheetObjects[0]);
			
			if (SaveStr == ""){
				ComShowCodeMessage("JOO00036");
				return false;
			}

			if (!ComShowCodeConfirm('JOO00046')){
				return false;
			}
			
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0009GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			sheetObj.LoadSearchXml(sXml);

			var RTNVAL = ComGetEtcData(sXml, "RTNVAL");
			if (RTNVAL == "E"){
				ComShowCodeMessage("JOO00161");
				return;
//				if (ComShowConfirm(ComGetEtcData(sXml,"MSG"))){
//					doActionIBSheet(sheetObj, document.form, IBINSERT);					
//				}
			}else{
				if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
					doActionIBSheet(sheetObj, document.form, IBSEARCH);
				}
			}
			
			break;

		case IBINSERT: //중복체크하지 않는 저장 ==> OUS RDR에서는 필요없다...==> 화면에서 중복체크 처리함
			var SaveStr = ComGetSaveString(sheetObjects[0]);
			
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			sheetObj.DoSave("FNS_JOO_0009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix), -1, false);
			ComOpenWait(false);
			break;
			
		case IBDELETE: //삭제
			if (!ComShowCodeConfirm('JOO00061')){
				return;
			}
			formObj.f_cmd.value = REMOVE01;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			sheetObj.DoSearch("FNS_JOO_0009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			ComOpenWait(false);
			break;

		//VVD 9자리 입력
		case IBROWSEARCH:
			formObj.f_cmd.value = SEARCHLIST;
			formObj.cur_row.value = (gCurRow - sheetObj.HeaderRows);
			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0009GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
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
		
		//VVD 10자리 입력
		case IBSEARCH_ASYNC01: // VVD 유효성 체크 및 basic port 를 가져온다.
			formObj.f_cmd.value = SEARCHLIST01;
			formObj.cur_row.value = gCurRow-sheetObj.HeaderRows;
			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0009GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			var CHECKVVD = ComGetEtcData(sXml,"CHECKVVD");
			
			if (CHECKVVD=="N"){
				sheetObj.CellValue2(gCurRow, prefix+"stl_vvd_seq"       ) = ComGetEtcData(sXml,"stl_vvd_seq");
				sheetObj.CellValue2(gCurRow, prefix+"stl_bzc_port_cd"   ) = ComGetEtcData(sXml,"stl_bzc_port_cd");
				sheetObj.CellValue2(gCurRow, prefix+"eta_dt"            ) = ComGetEtcData(sXml,"eta_dt");
				//sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_cd"    ) = ComGetEtcData(sXml,"uc_bss_port_cd");
				//sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_etd_dt") = ComGetEtcData(sXml,"uc_bss_port_etd_dt");
				//2010.03.25 query변경으로 1st BSA TEU, WGT는 RGN변경시 가져오는 것으로 수정됨
//				sheetObj.CellValue2(gCurRow, prefix+"fnl_hjs_bsa_qty"   ) = ComGetEtcData(sXml,"fnl_hjs_bsa_qty");
//				sheetObj.CellValue2(gCurRow, prefix+"fnl_bsa_wgt"       ) = ComGetEtcData(sXml,"fnl_bsa_wgt");
				sheetObj.CellValue2(gCurRow, prefix+"bsa_per_wgt"       ) = ComGetEtcData(sXml,"bsa_per_wgt");
				
				sheetObj.SelectCell(gCurRow, prefix+"ioc_cd", true);
			}else{
				if (CHECKVVD=="E"){
					ComShowCodeMessage("JOO00141");
				}else if (CHECKVVD=="T"){
					ComShowCodeMessage("JOO00142");
				}

				sheetObj.CellValue2(gCurRow, prefix+"stl_vvd_seq"    ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"stl_bzc_port_cd") = "";
				sheetObj.CellValue2(gCurRow, prefix+"eta_dt"         ) = "";
				//sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_cd"    ) = "";
				//sheetObj.CellValue2(gCurRow, prefix+"uc_bss_port_etd_dt") = "";
//				sheetObj.CellValue2(gCurRow, prefix+"fnl_hjs_bsa_qty"   ) = "";
//				sheetObj.CellValue2(gCurRow, prefix+"fnl_bsa_wgt"       ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"bsa_per_wgt"       ) = "";
				
				sheetObj.CellValue2(gCurRow, prefix+"vsl_cd"         ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"skd_voy_no"     ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"skd_dir_cd"     ) = "";
				sheetObj.CellValue2(gCurRow, prefix+"rev_dir_cd"     ) = "";
				sheetObj.SelectCell(gCurRow, prefix+"vsl_cd", true);
			}
			break;

		// I/O 변경시 단가
		case IBSEARCH_ASYNC02:
			formObj.f_cmd.value = SEARCHLIST02;
			formObj.cur_row.value = gCurRow-sheetObj.HeaderRows;
			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0009GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			var CHECKVVD = ComGetEtcData(sXml,"CHECKVVD");
			
			if (CHECKVVD=="N"){
				sheetObj.CellValue(gCurRow, prefix+"bsa_slt_prc") = ComGetEtcData(sXml,"bsa_slt_prc");
				sheetObj.CellEditable(gCurRow, prefix+"bsa_slt_prc") = true;
				sheetObj.SelectCell(gCurRow, prefix+"over_usd_qty", true);
			}else{
				if (CHECKVVD=="E"){
					ComShowCodeMessage("JOO00143");
				}else if (CHECKVVD=="T"){
					ComShowCodeMessage("JOO00144");
				}
				//2010.01.28 I/O변경했는데 data가 없더라도 그대로 둔다. => User Input 하겠다. 박효숙 차장 
				//sheetObj.CellValue2(gCurRow, prefix+"ioc_cd") = "";
				sheetObj.CellEditable(gCurRow, prefix+"bsa_slt_prc") = true;
				sheetObj.SelectCell(gCurRow, prefix+"ioc_cd", true);
			}
			
			break;
			
		//RGN 변경시 From Port, Used Slot정보 가져오기
		case IBSEARCH_ASYNC03: 
			formObj.f_cmd.value = SEARCHLIST03;
			formObj.cur_row.value = gCurRow-sheetObj.HeaderRows;
			var SaveStr = ComGetSaveString(sheetObj,true,true,-1);
			var sXml = sheetObj.GetSaveXml("FNS_JOO_0009GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			
			var CHECKVVD = ComGetEtcData(sXml,"CHECKVVD");
			
			if (CHECKVVD=="N"){
				sheetObj.CellValue(gCurRow, prefix+"fm_port_cd"     ) = ComGetEtcData(sXml,"fm_port_cd"     );
				sheetObj.CellValue(gCurRow, prefix+"usd_slt_bsa_qty") = ComGetEtcData(sXml,"usd_slt_bsa_qty");
				sheetObj.CellValue(gCurRow, prefix+"usd_slt_wgt"    ) = ComGetEtcData(sXml,"usd_slt_wgt"    );
				//2010.03.25 RGN변경시 1st BSA TEU, WGT를 가져오는 것으로 변경됨
				sheetObj.CellValue(gCurRow, prefix+"fnl_hjs_bsa_qty") = ComGetEtcData(sXml,"fnl_hjs_bsa_qty");
				sheetObj.CellValue(gCurRow, prefix+"fnl_bsa_wgt"    ) = ComGetEtcData(sXml,"fnl_bsa_wgt"    );
				sheetObj.CellEditable(gCurRow, prefix+"fm_port_cd"     ) = false;
				//sheetObj.CellEditable(gCurRow, prefix+"usd_slt_bsa_qty") = false;
				//sheetObj.CellEditable(gCurRow, prefix+"usd_slt_wgt"    ) = false;
				sheetObj.SelectCell(gCurRow, prefix+"over_usd_qty", true);
			}else{
				if (CHECKVVD=="E"){
					ComShowCodeMessage("JOO00143");
				}else if (CHECKVVD=="T"){
					ComShowCodeMessage("JOO00144");
				}
				//2010.01.28 RGN변경했는데 data가 없더라도 그대로 둔다. => User Input 하겠다. 박효숙 차장 
				//sheetObj.CellValue2(gCurRow, prefix+"sconti_cd") = "";
				sheetObj.CellEditable(gCurRow, prefix+"fm_port_cd"     ) = true;
				//sheetObj.CellEditable(gCurRow, prefix+"usd_slt_bsa_qty") = true;
				//sheetObj.CellEditable(gCurRow, prefix+"usd_slt_wgt"    ) = true;
				sheetObj.SelectCell(gCurRow, prefix+"fm_port_cd", true);
			}
			
			break;
			
		case IBSEARCH_ASYNC10: //마감여부 조회
			formObj.f_cmd.value = SEARCH10;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0009GS.do", FormQueryString(formObj));
			
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
						UF_setAuth(comboObjects[2].GetText(code, 3));
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
				SetColAlign("left|left|left|left");        
				SetColWidth("30|0|0|0"); //rlane_cd, RTU, currency, auth_cd
  				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
 				MaxLength=5;
  		    }
  			break;
 	} 
}

// 조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj, sComboKey) {
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
									
				formObj.f_cmd.value = SEARCHLIST15;
				formObj.code.value = formObj.jo_stl_itm_cd.value; //Item
				formObj.name.value = JooGetRadioValue(formObj.re_divr_cd); //re_divr_cd
				formObj.super_cd1.value = formObj.jo_crr_cd.Code;
				formObj.super_cd2.value = formObj.trd_cd.Code;
				
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
                ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code|name|super_cd1|auth_cd");
			}
														
	        break;
    }
}

//TRADE 변경시 LANE 변경
function jo_crr_cd_OnChange(comboObj, idx_cd, text){
	comboObjects[1].Index2 = -1;
	comboObjects[2].Index2 = -1;
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	sheetObjects[0].RemoveAll();
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
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj, "trd_cd");
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
		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj,"rlane_cd");
		comboObj.Enable = true;
	}
}

//RLANE 변경시 clear
function rlane_cd_OnChange(comboObj, code, text){
	sheetObjects[0].RemoveAll();
	UF_setAuth(comboObj.GetText(code, 3));
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
			var rtu    = formObj.rlane_cd.GetText(idx_cd,1);
			
//			if (rtu.length != 1){
//				ComShowCodeMessage('JOO00083');
//				return false;
//			}
			
			var loclCurrCd = formObj.rlane_cd.GetText(idx_cd,2);
			
			if (loclCurrCd.length!=3){
				ComShowCodeMessage('JOO00082');
				return false;
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
			var cnt = 0;
			for (var inx=sheetObj.HeaderRows; inx <= sheetObj.LastRow; inx++){
				var status = sheetObj.RowStatus(inx); 
				if (status == "R")
					continue;
				
				cnt++;

				var slip = sheetObj.CellValue(inx, prefix+"stl_cmb_seq");

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

				if (status == "D") 
					continue;
				
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
				
				if (sheetObj.CellValue(inx, prefix+"ioc_cd").length < 1){
					ComShowCodeMessage('JOO00085',inx);
					sheetObj.SelectCell(inx, prefix+"ioc_cd", true);
					return false;
				}

				if (sheetObj.CellValue(inx, prefix+"sconti_cd").length < 1){
					ComShowCodeMessage('JOO00086',inx);
					sheetObj.SelectCell(inx, prefix+"sconti_cd", true);
					return false;
				}
				//2010.01.05 AMOUNT가 0이면 저장못하도록 수정
				//Adjustment의 0값을 Combined시키기 위함
				if (sheetObj.CellValue(inx, prefix+"stl_locl_amt").length == 0
				||  sheetObj.CellValue(inx, prefix+"stl_locl_amt") == "0"){
					ComShowCodeMessage('JOO00056',inx);
					sheetObj.SelectCell(inx, prefix+"stl_locl_amt", true);
					return false;
				}

				var fstBsaQty = sheetObj.CellValue(inx, prefix+"fnl_hjs_bsa_qty");
				
				if (fstBsaQty == "" || Number(fstBsaQty) == 0){
					ComShowCodeMessage('JOO00058',inx, "1st BSA + Swap TEU");
					sheetObj.SelectCell(inx, prefix+"fnl_hjs_bsa_qty", false);
					return false;
				}
				
				var fstBsaWgt = sheetObj.CellValue(inx, prefix+"fnl_bsa_wgt");
				if (fstBsaWgt == "" || Number(fstBsaWgt)==0){
					ComShowCodeMessage('JOO00058',inx, "1st BSA + Swap WGT");
					sheetObj.SelectCell(inx, prefix+"fnl_bsa_wgt", false);
					return false;
				}
				
				var bsaPerWgt = sheetObj.CellValue(inx, prefix+"bsa_per_wgt");

				if (bsaPerWgt == "" || Number(bsaPerWgt)==0){
					ComShowCodeMessage('JOO00058',inx, "1st BSA Weight Per TEU");
					sheetObj.SelectCell(inx, prefix+"bsa_per_wgt", false);
					return false;
				}
				
				var bsaSltPrc =sheetObj.CellValue(inx, prefix+"bsa_slt_prc");

				if (bsaSltPrc == "" || Number(bsaSltPrc)==0){
					ComShowCodeMessage('JOO00058',inx, "1st BSA Over Used Slot Price");
					sheetObj.SelectCell(inx, prefix+"bsa_slt_prc", true);
					return false;
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
	sheetObj.SumText(0,prefix+"vsl_cd") = "TOTAL"; //TOTAL이라는 글자가 잘리지 않게 넓은데로 옮김
	
	//combined data는 삭제 checkbox를 막는다.
	for (var i=sheetObj.HeaderRows; i<= sheetObj.LastRow; i++){
		var ibflag    = sheetObj.RowStatus(i);
		var stlCmbSeq = sheetObj.CellValue(i, prefix+"stl_cmb_seq");
		if (ibflag == "R"){
			if (ComTrim(stlCmbSeq) == ""){
				sheetObj.CellEditable(i, prefix+"del_chk"        ) = true;
				sheetObj.CellEditable(i, prefix+"usd_slt_bsa_qty") = true;
				sheetObj.CellEditable(i, prefix+"usd_slt_wgt"    ) = true;
			}else{
				sheetObj.CellEditable(i, prefix+"del_chk"        ) = false;
				sheetObj.CellEditable(i, prefix+"usd_slt_bsa_qty") = false;
				sheetObj.CellEditable(i, prefix+"usd_slt_wgt"    ) = false;
			}
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
	if ((sName == (prefix+"skd_voy_no")) && (Value.length == 4)){
		sheetObj.SelectCell(Row, prefix+"skd_dir_cd",true);
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	gCurRow = Row;

	
	var vsl = sheetObj.CellValue(Row, prefix+"vsl_cd");
	var voy = sheetObj.CellValue(Row, prefix+"skd_voy_no");
	var dir = sheetObj.CellValue(Row, prefix+"skd_dir_cd");
	var rev = sheetObj.CellValue(Row, prefix+"rev_dir_cd");
	
	var vvd = vsl + voy + dir + rev;

	if (sName == prefix+"vsl_cd" || sName==prefix+"skd_voy_no" || sName==prefix+"skd_dir_cd" || sName==prefix+"rev_dir_cd"){
		var tmp = sheetObj.GetComboInfo(Row, prefix+"rev_dir_cd", "Code").split("|");
		if ( sName!=prefix+"rev_dir_cd" || tmp.length <= 1 && Value == "" && sheetObj.RowStatus(Row) == "I"){
			
			if ((vsl+voy+dir).length == 9){
				doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
			}
		}

		if (vvd.length == 10){
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}else if (sName == prefix+"ioc_cd"){
		if (vvd.length != 10){
			ComShowCodeMessage("JOO00039");//먼저 VVD 입력하라
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}
		//2010.11.17 신자영  uc_bss_port_etd_dt 관련 로직 막음
		//var ucBssPortEdtDt = sheetObj.CellValue(Row, prefix+"uc_bss_port_etd_dt");
		//if (ucBssPortEdtDt.length < 8){
		//	ComShowCodeMessage("JOO00154");//먼저 Unit Cost Basic Port Etd Dt를 입력하라
		//	sheetObj.CellValue2(Row, Col) = "";
		//	return;
		//}
		
		if (ComTrim(Value) != ""){
			//2010.01.28 I/O 변경시에는 sconti_cd clear시킴
			sheetObj.CellValue2(Row, prefix+"sconti_cd") = "";
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
		}
	}else if (sName == prefix+"sconti_cd"){
		if (vvd.length != 10){
			ComShowCodeMessage("JOO00039");//먼저 VVD 입력하라
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}

		var iocCd = sheetObj.CellValue(Row, prefix+"ioc_cd");
		if (iocCd.length < 1){
			ComShowCodeMessage("JOO00155");//먼저 Unit Cost Basic Port Etd Dt를 입력하라
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}

		if (ComTrim(Value) != ""){
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
		}
	}else if (sName == prefix+"usd_slt_bsa_qty" || sName == prefix+"usd_slt_wgt"){
		if (vvd.length != 10){
			ComShowCodeMessage("JOO00039");//먼저 VVD 입력하라
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}		
		var iocCd = sheetObj.CellValue(Row, prefix+"ioc_cd");
		if (iocCd.length < 1){
			ComShowCodeMessage("JOO00155");
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}
		var rgn = sheetObj.CellValue(Row, prefix+"sconti_cd");
		if (rgn.length < 1){
			ComShowCodeMessage("JOO00156");
			sheetObj.CellValue2(Row, Col) = "";
			return;
		}
		
		var usdQty = sheetObj.CellValue(Row, prefix+"usd_slt_bsa_qty");
		var usdWgt = sheetObj.CellValue(Row, prefix+"usd_slt_wgt");
		if (sName == prefix+"usd_slt_bsa_qty"){
			usdQty = Value;
		}else if (sName == prefix+"usd_slt_wgt"){
			usdWgt = Value;
		}
		
		var amt = sheetObj.CellValue(Row,prefix+"stl_locl_amt");
		
		if (existsSamePair(sheetObj, Row, vsl, voy, dir, rev, iocCd, rgn, usdQty, usdWgt, amt)){
			//계속하겠냐? 했을 때 아니면 삭제?
			if (!ComShowCodeConfirm("JOO00157")){
				sheetObj.CellValue2(Row, prefix+"usd_slt_bsa_qty") = "";
				sheetObj.CellValue2(Row, prefix+"usd_slt_wgt" ) = "";
				sheetObj.CellValue2(Row, prefix+"stl_locl_amt") = "";
			}else{
				sheetObj.CellValue2(Row, prefix+"stl_dup_flg" ) = "Y";
			}
		}
	}
}

/**
 * Dup Check
 * @param sheetObj
 * @param Row
 * @param vsl
 * @param voy
 * @param dir
 * @param fin
 * @param ioc
 * @param rgn
 * @param usdQty
 * @param usdWgt
 * @param amt
 * @return
 */
function existsSamePair(sheetObj, Row, vsl, voy, dir, fin, ioc, rgn, usdQty, usdWgt, amt){
	var rtnVal = false;
	for(var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
		if (inx==Row) continue;
		
		var lvsl    = sheetObj.CellValue(inx, prefix+"vsl_cd");
		var lvoy    = sheetObj.CellValue(inx, prefix+"skd_voy_no");
		var ldir    = sheetObj.CellValue(inx, prefix+"skd_dir_cd");
		var lfin    = sheetObj.CellValue(inx, prefix+"rev_dir_cd");
		var lioc    = sheetObj.CellValue(inx, prefix+"ioc_cd");
		var lrgn    = sheetObj.CellValue(inx, prefix+"sconti_cd");
		var lusdQty = sheetObj.CellValue(inx, prefix+"usd_slt_bsa_qty");
		var lusdWgt = sheetObj.CellValue(inx, prefix+"usd_slt_wgt");
		var lamt    = sheetObj.CellValue(inx, prefix+"stl_locl_amt");

		if (lvsl    == vsl 
		&&  lvoy    == voy  
		&&  ldir    == dir    
		&&  lfin    == fin    
		&&  lioc    == ioc    
		&&  lrgn    == rgn    
		&&  lusdQty == usdQty    
		&&  lusdWgt == usdWgt    
		&&  lamt    == amt){
			rtnVal = true;
			break;
		}
	}
	return rtnVal;
}
/* 개발자 작업  끝 */