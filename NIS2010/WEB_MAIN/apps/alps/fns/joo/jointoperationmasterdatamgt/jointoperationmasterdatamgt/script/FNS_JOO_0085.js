/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : FNS_JOO_0085.js
 *@FileTitle : Basic Information for Loading Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.23
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2010.12.23 박희동
 * 1.0 Creation
* -------------------------------------------------------
* 2012.04.05 조병연[CHM-201217059-01]
* Title : [ALPS JOO] Estimate VVD Code Check - Current Estimate Cost 0 조회 기능 추가
* 내용 :
* 1. BSA adjustment 칼럼 추가  :
* 기존 통합선복사용실적조회 화면에 있던 BSA adjustment 기능을 Basic Info 화면으로 옮겨, 
* 해당 Lane, Carrier에 일괄적으로 적용 (TEU, WT 분리하여 적용)
* 2. Add Carriers 수정 : 
* Main에서 Lane, Rep. Carrier를 신규로 생성했을 때, Add Carriers로 자동으로 저장되도록 수정
* 3. Bay plan table에서 같은 포트가 2개 이상일 경우, 가장 늦은 ETD에 해당하는 plan의 data를 적용 수정 : 
* 테스트 서버 적용된 사항 미반영 상태. 
* 모든 레인에서 같은 포트가 두 개 이상이라면 마지막에 CALLING 한 포트를 기준으로 해야 함 
* (ALX, BRSSZ & ALW, MXZLO)
* EX. ALX/ HJAA0014E : ETD 2011-10-15 data (현재 ETD 2011-10-03 data 임)
* 4. RF sub alloc 수정 : 
* Basic Info에 입력된 RF sub alloc 을 반영하여, sub alloc 보다 loading 개수가 
* 적은 경우 “0”으로 표기되도록 쿼리 수정
* 
* 
Date : 2012.07.24.
Ticket ID : SRM-201227013
Title :[ALPS JOO] TDR Inquiry by VVD - Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가
개발자 : 전상화
Description
   1. Lane 조회 조건 수정 (PopUp -> Select Box)로 수정하면서 추가 사항(select Key 추가)을 반영


* =========================================================*/
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
 * @class FNS_JOO_0085 : FNS_JOO_0085 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0085() {
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

var prefix = "sheet1_";
var gRow = "";

var gTrdLaneCrrArr; //0 : Trade, 1 : Lane, 2 : Carrier

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
/* 2012.06.04 사용자 요청
		case "btns_carriers":
			//var param = '?csrNo=' + '111';
			ComOpenPopup("/hanjin/FNS_JOO_0086.do", 935, 540,
					"popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0,
					"pop1");
			break;
*/			
		case "btns_copy":
			UF_copyRow();
			break;

		case "btns_add":
			UF_addRow(-1);
			break;

		case "btns_insert":
			UF_addRow();
			break;
			
		case "btns_del":
			JooRowHideDelete(sheetObj, prefix+"del_chk");
			break;
			
		case "btn_retrieve":
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case "btn_new":
			UF_reset();
			break;

		case "btn_downexcel":
			var paramObj = new Object();
			var url = ComJooGetPgmTitle(sheetObj, paramObj);
			sheetObj.SpeedDown2Excel(-1, false, false, "", url);
			break;

		case "btn_save":
			doActionIBSheet(sheetObj, formObj, IBSAVE);
			break;
			
		case "btn_pop_ofc_cd":
			ComOpenPopup("/hanjin/COM_ENS_071.do", 750, 470, "ofc_cd_pop_event", "1,0,1", true);
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

	var arr1d = gTrdLaneCrr.split("|");
	gTrdLaneCrrArr = arr1d;
	for (var i=0; i< arr1d.length; i++){
		var arr2d = arr1d[i];
		gTrdLaneCrrArr[i] = arr2d.split(",");
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
	axon_event.addListenerFormat('beforedeactivate', 'obj_deactivate',  formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate'  , 'obj_activate'  ,  formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerFormat('keyup'           , 'obj_keyup'     ,  formObj);
    axon_event.addListenerFormat('click'           , 'obj_onclick'   , 	formObj);

    axon_event.addListener('beforedeactivate', 'ofc_cd_onblur'    , 'ofc_cd');
    axon_event.addListener('keypress', 'ofc_cd_keypress' , 'ofc_cd');
    axon_event.addListener('keyup'   , 'ofc_cd_keyup'    , 'ofc_cd');
}

//function obj_keypress() {
//	alert("zz");
//	var obj = event.srcElement;
//    switch(obj.name){
//	    case "ofc_cd":
//	    	alert("1");
//	        ComKeyOnlyAlphabet('upper');
//	    break;
//	}
//}

function obj_keyup() {
	ComKeyEnter('lengthnextfocus');
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {
	ComChkObjValid(event.srcElement);
}

function obj_activate() {
	ComClearSeparator(event.srcElement);
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
			style.height = 420;
			// 전체 너비 설정
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

			var HeadTitle  = "|Sel|Ref No|Office|Rev/Exp|Trade|Lane|Direction|Rep.\nCarrier|Sub\nCarriers|Source|BSA\nAdjustment|BSA\nAdjustment|Weight|Weight|20' HC|20' HC|20' HC|40' HC|40' HC|40' HC|45'|45'|45'|45'|RF|RF|BKG Data Inquiry|Eff. Date|Exp. Date|Creation Date|Update date|Update ID|Update Name|Del|Seq|Adjustment\nRemark|R";
			var HeadTitle2  = "||Ref No|Office|Rev/Exp|Trade|Lane|Direction|Rep.\nCarrier|Sub\nCarriers|Source|TEU|WT|Ton per TEU|Round Type|Sub Alloc|Over Ratio (TEU)|Round Type|Sub Alloc|Over Ratio (TEU)|Round Type|Sub Alloc|Under Ratio (TEU)|Over Ratio (TEU)|Round Type|Ocean Sub Alloc|Inter Sub Alloc|BKG Data Inquiry|Eff. Date|Exp. Date|Creation Date|Update date|Update ID|Update Name|Del|Seq|Adjustment\nRemark|R";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 10, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, false, true, false)
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, prefix + "ibflag" );
			InitDataProperty(0, cnt++, dtCheckBox    , 30, daCenter, true, prefix + "del_chk");
			InitDataProperty(0, cnt++, dtData        ,190, daLeft, true, prefix + "jo_ref_no"           		, false, "", dfNone        , 0, false, true );
			InitDataProperty(0, cnt++, dtCombo   	 , 70, daCenter, true, prefix + "ofc_cd"              		, false, "", dfNone        , 0, false, true ,6);
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true, prefix + "re_divr_cd"          		, false, "", dfNone        , 0, false, true );
			InitDataProperty(0, cnt++, dtCombo       , 50, daCenter, true, prefix + "trd_cd"              		, false, "", dfNone        , 0, false, true );
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true, prefix + "rlane_cd"            		, false, "", dfNone        , 0, false, true );
			
			// 2012.05.31 Modify and Add
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true, prefix + "skd_dir_cd"                , false, "", dfNone        , 0, false, true );
			InitDataProperty(0, cnt++, dtData        , 50, daCenter, true, prefix + "jo_crr_cd"           		, false, "", dfNone        , 0, false, true );
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true, prefix + "jo_crr_flag"            	, false, "", dfNone        , 0, false, false );

			InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true, prefix + "jo_src_cd"           		, false, "", dfNone        , 0, true , true );

			InitDataProperty(0, cnt++, dtData        , 80, daRight , false, prefix + "jo_aloc_adj_teu_qty"     	, false, "", dfNullFloat   , 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 80, daRight , false, prefix + "jo_aloc_adj_wgt"      	, false, "", dfNullFloat   , 2, true , true );
			
			InitDataProperty(0, cnt++, dtData        , 80, daRight , false, prefix + "jo_ton_teu_qty"      		, false, "", dfNullFloat   , 2, true , true );
			InitDataProperty(0, cnt++, dtCombo       , 80, daCenter , false, prefix + "jo_ton_wgt_rnd_rt"   	, false, "", dfNullFloat   , 2, true , true );
			InitDataProperty(0, cnt++, dtData        , 90, daRight , false, prefix + "jo_20ft_gnte_qty"    		, false, "", dfNullInteger , 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 100, daRight, false, prefix + "jo_20ft_teu_qty"     		, false, "", dfNullFloat   , 2, true , true );
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter , false, prefix + "jo_20ft_rnd_rt"      	, false, "", dfNullFloat   , 2, true , true );
			
			InitDataProperty(0, cnt++, dtData        , 90, daRight , false, prefix + "jo_40ft_gnte_qty"    		, false, "", dfNullInteger , 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 100, daRight, false, prefix + "jo_40ft_teu_qty"     		, false, "", dfNullFloat , 2, true , true );
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter , false, prefix + "jo_40ft_rnd_rt"      	, false, "", dfNullFloat   , 2, true , true );
			InitDataProperty(0, cnt++, dtData        , 100, daRight, false, prefix + "jo_45ft_gnte_qty"    		, false, "", dfNullFloat , 2, true , true );
			InitDataProperty(0, cnt++, dtData        , 110, daRight, false, prefix + "jo_45ft_und_teu_qty"      , false, "", dfNullFloat , 2, true , true );
			InitDataProperty(0, cnt++, dtData        , 100, daRight, false, prefix + "jo_45ft_ovr_teu_qty"      , false, "", dfNullFloat   , 2, true , true );
			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter , false, prefix + "jo_45ft_rnd_rt"      	, false, "", dfNullFloat   , 2, true , true );
			InitDataProperty(0, cnt++, dtData        , 100, daRight, false, prefix + "jo_rf_gnte_ocn_qty"  		, false, "", dfNullInteger , 0, true , true );
			InitDataProperty(0, cnt++, dtData        , 100, daRight, false, prefix + "jo_rf_gnte_inter_qty"		, false, "", dfNullInteger , 0, true , true );
			InitDataProperty(0, cnt++, dtCombo       , 110, daCenter, true, prefix + "jo_bkg_tp_cd"        		, false, "", dfNone        , 0, true, true);
			InitDataProperty(0, cnt++, dtPopupEdit   , 80, daCenter, true, prefix + "agmt_eff_dt"         		, false, "", dfDateYmd     , 0, true , true );
			
			InitDataProperty(0, cnt++, dtPopupEdit   , 80, daCenter, true, prefix + "agmt_exp_dt"         		, false, "", dfDateYmd     , 0, true , true );
			InitDataProperty(0, cnt++, dtData        ,120, daCenter, true, prefix + "cre_dt"              		, false, "", dfUserFormat2 , 0, false, false);
			InitDataProperty(0, cnt++, dtData        ,120, daCenter, true, prefix + "upd_dt"              		, false, "", dfUserFormat2 , 0, false, false);
			InitDataProperty(0, cnt++, dtData        , 80, daCenter, true, prefix + "cre_usr_id"          		, false, "", dfNone        , 0, false, false);
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true, prefix + "cre_usr_nm"          		, false, "", dfNone        , 0, false, false);
			
			InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true, prefix + "delt_flg"            		, false, "", dfNone        , 0, false, false);
			InitDataProperty(0, cnt++, dtHidden      , 80, daCenter, false, prefix + "jo_ref_seq"          		, false, "", dfNone        , 0, false, false);
			InitDataProperty(0, cnt++, dtData      , 80, daCenter, true, prefix + "jo_aloc_adj_rmk"          		, false, "", dfNone        , 0, true, true);
			InitDataProperty(0, cnt++, dtHidden    , 50, daCenter, true, prefix + "jo_ref_crr_cd"           		, false, "", dfNone        , 0, true , true );
			ImageList(0) = "/hanjin/img/button/btns_calendar.gif";

			InitDataCombo(0, prefix+"re_divr_cd" , "Rev|Exp", "R|E");
			InitDataCombo(0, prefix+"delt_flg"   , "Yes|No", "Y|N");
			InitDataCombo(0, prefix+"jo_src_cd"   , "ALL|RDR|TDR|BKG|RDR+BKG|TDR+BKG", "A|R|T|B|C|D");
			InitDataCombo(0, prefix+"jo_ton_wgt_rnd_rt"   , "Round|Round Up|Round Down", "1|2|3");
			InitDataCombo(0, prefix+"jo_20ft_rnd_rt"   , "Round|Round Up|Round Down", "1|2|3");
			InitDataCombo(0, prefix+"jo_40ft_rnd_rt"   , "Round|Round Up|Round Down", "1|2|3");
			InitDataCombo(0, prefix+"jo_45ft_rnd_rt"   , "Round|Round Up|Round Down", "1|2|3");
			InitDataCombo(0, prefix+"jo_bkg_tp_cd"   , "A|B", "A|B");
			// 2012.06.01 Add
			InitDataCombo(0, prefix+"skd_dir_cd"   , " |E|W|S|N", " |E|W|S|N");
			
			var trdList = gTrdCd.split("|");
			var trdSheet = "";
			var trdCodeName = "";
			for (var i=0; i<trdList.length; i++){
				trdCodeName = trdList[i].split(",");
				if (i == 0){
					trdSheet = trdCodeName[0];
				}else{
					trdSheet = trdSheet + "|" + trdCodeName[0];
				}
			}

			//OFC_CD
			var ofcCdList = gOfcCd.split("|");
			var ofcSheet = "";
			var ofcCodeName = "";
			for (var i=0; i<ofcCdList.length; i++){
				ofcCodeName = ofcCdList[i].split(",");
				if (i == 0){
					ofcSheet = ofcCodeName[0];
				}else{
					ofcSheet = ofcSheet + "|" + ofcCodeName[0];
				}
			}
			InitDataCombo(0, prefix+"ofc_cd"      , ofcSheet  , ofcSheet);
			InitDataCombo(0, prefix+"trd_cd"      , trdSheet  , trdSheet);
			//InitDataCombo(0, prefix+"jo_src_cd"   , gJoSrcNm  , gJoSrcCd);
			//InitDataCombo(0, prefix+"jo_bkg_tp_cd", gJoBkgTpNm, gJoBkgTpCd);
			//InitDataValid(0, prefix+"ofc_cd"   , vtEngUpOnly); //영문대문자
			InitUserFormat2(0, prefix+"cre_dt" , "####-##-## ##:##:##", "-|:");
			InitUserFormat2(0, prefix+"upd_dt" , "####-##-## ##:##:##", "-|:");

			InitComboNoMatchText(true);
			ComboOpenMode = true; //한번 클릭으로 펼쳐짐
		}
		break;

	}
}

//Pop-up창에서 Close시 호출한다.
function parentSearch() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	if (!validateForm(sheetObj, formObj, sAction))
		return;

	switch (sAction) {

	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = false;
		sheetObj.DoSearch("FNS_JOO_0085GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		break;

	case IBSAVE: //저장
		formObj.f_cmd.value = MULTI;
		var SaveStr = ComGetSaveString(sheetObj); // 배열입니다.
		if (SaveStr == ""){
			ComShowCodeMessage("JOO00036");
			return false;			
		}
		
		if (!ComShowCodeConfirm("JOO00046")){
			return false;
		}
		
		for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++)
		{
			var joSrcCd =ComTrimAll(sheetObj.CellValue(i, prefix+"jo_src_cd")," ");
			if(joSrcCd == "R" || joSrcCd == "T")
			{
				//sheetObj.cellValue(Row,prefix+"jo_bkg_tp_cd") = "";
			}
		}
		
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSaveXml("FNS_JOO_0085GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

		if (ComGetEtcData(sXml,"RTNVAL") == "N"){
			sheetObj.LoadSaveXml(sXml);		
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}else{
			ComShowMessage(ComGetEtcData(sXml,"RTNVAL"));
		}
		break;
/* 2012.05.31 사용자 요청으로 삭제
	case IBROWSEARCH: //조회
		formObj.f_cmd.value = SEARCH01;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("FNS_JOO_0085GS.do", FormQueryString(formObj));
		var refNoList = ComGetEtcData(sXml,"REF_NO_COMBO");
		comboObjects[0].RemoveAll();		
		var comboItems = ("ALL, |"+refNoList).split("|");
		UF_addComboItem(comboObjects[0], comboItems);  		
		break;
*/		
	case IBSEARCH_ASYNC01: //OFFICE CODE Validation Check(For IBSheet Cell)
		formObj.f_cmd.value = SEARCH11;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code="+sheetObj.CellValue(gRow, prefix+"ofc_cd"));
		if (ComGetEtcData(sXml,"RESULT") == "E"){
			ComShowCodeMessage("JOO00136", "Office");
			sheetObj.CellValue2(gRow, prefix+"ofc_cd") = "";
			sheetObj.SelectCell(gRow, prefix+"ofc_cd");
		}
		break;

	case IBSEARCH_ASYNC02: //OFFICE CODE Validation Check(For Input Box)
		formObj.f_cmd.value = SEARCH11;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code="+formObj.ofc_cd.value);
		if (ComGetEtcData(sXml,"RESULT") == "E"){
			ComShowCodeMessage("JOO00136", "Office");
			formObj.ofc_cd.value = "";
			formObj.ofc_cd.focus();
		}
		break;

	case IBSEARCH_ASYNC03: //IBSheet상의 Trade Code변경시 Revenue Lane Setting
		formObj.f_cmd.value = SEARCH16;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1=&super_cd2="+sheetObj.CellValue(gRow, prefix+"trd_cd"));
		var rlaneCdList = ComGetEtcData(sXml,"rlane_combo_sheet");
		sheetObj.InitCellProperty(gRow, prefix+"rlane_cd", dtCombo);
        sheetObj.CellComboItem(gRow, prefix+"rlane_cd" , rlaneCdList, rlaneCdList);
		sheetObj.CellValue2(gRow, prefix+"rlane_cd") = "";
		sheetObj.CellValue2(gRow, prefix+"jo_crr_cd") = "";
		break;

	case IBSEARCH_ASYNC04: 
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("FNS_JOO_0085GS.do", "f_cmd=102"
				+"&ofc_cd="+sheetObj.CellValue(gRow, prefix+"ofc_cd")
				+"&re_divr_cd="+sheetObj.CellValue(gRow, prefix+"re_divr_cd")
				+"&trd_cd="+sheetObj.CellValue(gRow, prefix+"trd_cd")
				+"&rlane_cd="+sheetObj.CellValue(gRow, prefix+"rlane_cd"));

		var code = ComGetEtcData(sXml,"CODE");
		var text = ComGetEtcData(sXml,"TEXT");
		var comboList = text.split("|");

		if (sheetObj.RowStatus(gRow) == "I"){
			sheetObj.CellValue2(gRow, prefix+"jo_ref_no"  ) = "";
			sheetObj.CellValue2(gRow, prefix+"agmt_eff_dt") = "";
			sheetObj.CellValue2(gRow, prefix+"agmt_exp_dt") = "";
		}

		//기존 같은 Data가 없으면 수기 입력 가능
		if (code == "" || comboList.length == 0){
			sheetObj.InitCellProperty(gRow, prefix+"jo_ref_no", dtData);
			sheetObj.CellEditable(gRow, prefix+"jo_ref_no") = false;
		}else if (comboList.length >= 1){
			if (ComShowCodeConfirm("JOO00188",comboList.length)){
				sheetObj.InitCellProperty(gRow, prefix+"jo_ref_no", dtData);
				sheetObj.CellEditable (gRow, prefix+"jo_ref_no"  ) = false;
				sheetObj.CellEditable (gRow, prefix+"agmt_eff_dt") = true;
				sheetObj.CellEditable (gRow, prefix+"agmt_exp_dt") = true;
		        sheetObj.SelectCell(gRow, prefix+"rlane_cd");
			}else{
				sheetObj.InitCellProperty(gRow, prefix+"jo_ref_no", dtCombo);
				sheetObj.CellEditable (gRow, prefix+"jo_ref_no"  ) = true;
				sheetObj.CellEditable (gRow, prefix+"agmt_eff_dt") = false;
				sheetObj.CellEditable (gRow, prefix+"agmt_exp_dt") = false;
		        sheetObj.CellComboItem(gRow, prefix+"jo_ref_no" , text, code);
				sheetObj.CellValue2(gRow, prefix+"jo_ref_no"  ) = "";
				sheetObj.CellValue2(gRow, prefix+"agmt_eff_dt") = "";
				sheetObj.CellValue2(gRow, prefix+"agmt_exp_dt") = "";
		        sheetObj.SelectCell(gRow, prefix+"del_chk");
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
	var formObj = document.form;

	switch (comboObj.id) {
/* 2012.06.01
	case "jo_ref_no":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("120");
			DropHeight = 160;
			ValidChar(2, 1);//영문대문자 숫자만 입력가능
			MaxLength = 25;
		}
		comboObj.InsertItem(0, "ALL", " ");
		comboObj.Text2 = "ALL";
		break;
*/
	case "re_divr_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 7;
		}
		var comboItems = "ALL, |Revenue,R|Expense,E";
		UF_addComboItem(comboObj, comboItems.split("|"));
		comboObj.Text2 = "ALL";
		break;
		
	case "jo_crr_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = ("ALL, |"+gCrrCd).split("|");
		UF_addComboItem(comboObj, comboItems);
		comboObj.Text2 = "ALL";
		break;

	case "trd_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = ("ALL, |"+gTrdCd).split("|");
		UF_addComboItem(comboObj, comboItems);
//		comboObj.InsertItem(0, "ALL", " ");
		comboObj.Text2 = "ALL";
		
		break;

	case "rlane_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("50");
			DropHeight = 160;
			ValidChar(2, 1);//영문대문자+숫자만 입력가능
			MaxLength = 5;
		}
			
		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCH16;
		sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1="+formObj.jo_crr_cd.Code);
        ComXml2ComboItem(sXml, formObj.rlane_cd,"code","code");
        comboObj.InsertItem(0, "ALL", " ");
        comboObj.Index2 = 0;
		
		break;
		
	case "delt_flg":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 200;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 3;
		}
		var comboItems = "ALL, |Yes,Y|No,N";
		UF_addComboItem(comboObj, comboItems.split("|"));
		comboObj.Code2 = "N";
		
		break;
		
	case "ofc_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 200;
			ValidChar(2,2);//영문대문자만 입력가능
			MaxLength=3;
		}
		var comboItems = gOfcCd.split("|");
		addComboItem(comboObj, comboItems);
		comboObj.Index2 = 0;
        if (comboItems.length == 1){
        	comboObj.Enable = false;
        }else{
        	comboObj.Enable = true;
        }
		break;

	//2012.06.01 add
	case "skd_dir_cd":
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("60");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 1;
		}
		var comboItems = "ALL, |E,E|W,W|S,S|N,N";
		UF_addComboItem(comboObj, comboItems.split("|"));
		comboObj.Text2 = "ALL";
		break;

	}
}

//조회조건필드인 Lane SVC Type 데이터 조회
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH: //TRADE
			if (sComboObj.id == "trd_cd"){
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
				formObj.f_cmd.value = SEARCH15;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd1="+formObj.jo_crr_cd.Code+"&super_cd2=");
                ComXml2ComboItem(sXml, formObj.trd_cd,"code","code");
				sComboObj.InsertItem(0, "ALL", " ");
				sComboObj.Index2 = 0;
    	   }else if (sComboObj.id == "rlane_cd") {
				//콤보필드를 초기화시킨다.
				sComboObj.RemoveAll();
									
				formObj.f_cmd.value = SEARCH16;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj)+"&code=&super_cd2="+formObj.trd_cd.Code+"&super_cd1=");
				var comboItems = ("ALL, |"+ComGetEtcData(sXml, "rlane_cd")).split("|");
				addComboItem(comboObjects[5],comboItems);
				sComboObj.Index2 = 0;
			}
														
	        break;
    }
}

/* 2012.05.31 사용자 요청으로 삭제
function jo_ref_no_OnChange(comboObj, Code, Text) {
	sheetObjects[0].RemoveAll();
}

function jo_ref_no_OnFocus(comboObj) {
//	if (comboObj.GetCount() == 1){
		comboObj.Enable = false;
		doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH);
		comboObj.Enable = true;
//	}
}
*/

/**
 * Popup Data Validation Check. <br>
 **/
function ofc_cd_pop_event(aryPopupData) {
	document.form.ofc_cd.value = aryPopupData[0][3];
	sheetObjects[0].RemoveAll();
}

function re_divr_cd_OnChange(comboObj, Code, Text) {
	sheetObjects[0].RemoveAll();
}

function jo_crr_cd_OnChange(comboObj, code, text){
	sheetObjects[0].RemoveAll();

	//comboObjects[3].RemoveAll();
	//comboObjects[3].InsertItem(0, "ALL", " ");
	//comboObjects[3].Text2 = "ALL";

	//comboObjects[4].RemoveAll();
	//comboObjects[4].InsertItem(0, "ALL", " ");
	//comboObjects[4].Text2 = "ALL";
}

//TRADE 변경시 LANE 변경
function trd_cd_OnChange(comboObj, Code, Text){
	var formObj = document.form;

	formObj.rlane_cd.Index2 = -1;
	formObj.rlane_cd.RemoveAll();
	sheetObjects[0].RemoveAll();

	doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObjects[5] ,"rlane_cd");
	formObj.trd_cd.focus();
//	formObject.rlane_cd.InsertItem(0, "ALL", " ");
//	formObject.rlane_cd.Text2 = "ALL";
}
/*
function rlane_cd_OnFocus(comboObj){
	var formObj = document.form;
	if (comboObj.GetCount() == 0) {
		comboObj.Enable = false;
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, comboObj ,"rlane_cd");
		comboObj.Enable = true;
	}
}
*/
function rlane_cd_OnChange(comboObj, code, text){
	sheetObjects[0].RemoveAll();
}

function delt_flg_OnChange(comboObj, Code, Text) {
	sheetObjects[0].RemoveAll();
}

function skd_dir_cd_OnChange(comboObj, Code, Text) {
	sheetObjects[0].RemoveAll();
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH:
			break;
			
		case IBSAVE:
			for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
				var rowStatus = sheetObj.RowStatus(i);
				
				if (rowStatus == "R" || rowStatus == "D")
					continue;
				
				if (sheetObj.CellValue(i, prefix+"ofc_cd").length < 5){
					ComShowCodeMessage("JOO00112");
					sheetObj.SelectCell(i, prefix+"ofc_cd");
					return false;
				}

				if (sheetObj.CellValue(i, prefix+"re_divr_cd").length < 1){
					ComShowCodeMessage("JOO00184");
					sheetObj.SelectCell(i, prefix+"re_divr_cd");
					return false;
				}

				if (sheetObj.CellValue(i, prefix+"trd_cd").length < 3){
					ComShowCodeMessage("JOO00009");
					sheetObj.SelectCell(i, prefix+"trd_cd");
					return false;
				}

				if (sheetObj.CellValue(i, prefix+"rlane_cd").length < 5){
					ComShowCodeMessage("JOO00010");
					sheetObj.SelectCell(i, prefix+"rlane_cd");
					return false;
				}
				
				//2012.06.01
				if (sheetObj.CellValue(i, prefix+"skd_dir_cd").length < 1) {
					ComShowCodeMessage("JOO00190");
					sheetObj.SelectCell(i, prefix+"skd_dir_cd");
					return false;					
				}

				if (sheetObj.CellValue(i, prefix+"jo_crr_cd").length < 3){
					ComShowCodeMessage("JOO00008");
					sheetObj.SelectCell(i, prefix+"jo_crr_cd");
					return false;
				}

				if (sheetObj.CellValue(i, prefix+"jo_src_cd").length < 1){
					ComShowCodeMessage("JOO00185");
					sheetObj.SelectCell(i, prefix+"jo_src_cd");
					return false;
				}

				if (sheetObj.CellValue(i, prefix+"jo_src_cd") == "B"){
					if (sheetObj.CellValue(i, prefix+"jo_bkg_tp_cd").length < 1){
						ComShowCodeMessage("JOO00186");
						sheetObj.SelectCell(i, prefix+"jo_bkg_tp_cd");
						return false;
					}
				}
				if (sheetObj.CellValue(i, prefix+"agmt_eff_dt").length < 8){
					ComShowCodeMessage("JOO00187", "Fm Date");
					sheetObj.SelectCell(i, prefix+"agmt_eff_dt");
					return false;
				}
				if (sheetObj.CellValue(i, prefix+"agmt_exp_dt").length < 8){
					ComShowCodeMessage("JOO00187", "To Date");
					sheetObj.SelectCell(i, prefix+"agmt_exp_dt");
					return false;
				}
				if (Number(sheetObj.CellValue(i, prefix+"agmt_eff_dt").replace(/-/g,"")) > Number(sheetObj.CellValue(i, prefix+"agmt_exp_dt").replace(/-/g,""))){
					ComShowCodeMessage("JOO00078");
					sheetObj.SelectCell(i, prefix+"agmt_exp_dt");
					return false;
				}
			}
			break;
		}
	}

	return true;
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
		if (sheetObj.CellValue(i, prefix+"jo_ref_no") == "") break;
		var joCrrCd = sheetObj.CellValue(i, prefix+"jo_crr_cd");
		var deltFlg = sheetObj.CellValue(i, prefix+"delt_flg");
		if (deltFlg == "Y"){
			sheetObj.RowEditable(i) = false;
			//sheetObj.CellEditable(i, prefix+"del_chk") = false;
		}else{
			sheetObj.RowEditable(i) = true;
			//sheetObj.CellEditable(i, prefix+"del_chk") = true;
		}
		
		var trd   = sheetObj.CellValue(i, prefix+"trd_cd");
		var rlane = sheetObj.CellValue(i, prefix+"rlane_cd");
		
		var crrList = "";
		for(var k=0; k<gTrdLaneCrrArr.length; k++){
			if (trd == gTrdLaneCrrArr[k][0] && rlane == gTrdLaneCrrArr[k][1]){
				if (k==0){
					crrList = gTrdLaneCrrArr[k][2];
				}else{
					crrList = crrList+"|"+gTrdLaneCrrArr[k][2];
				}
			}
		}
		sheetObj.InitCellProperty(i, prefix+"jo_crr_cd", dtCombo);
        sheetObj.CellComboItem(i, prefix+"jo_crr_cd" , crrList, crrList);
        sheetObj.CellValue2(i, prefix+"jo_crr_cd") = joCrrCd;
        
        var reDivrCd = sheetObj.CellValue(i, prefix+"re_divr_cd");
        var joSrcCd  = sheetObj.CellValue(i, prefix+"jo_src_cd");
        
        var cdList = "";
        var nmList = "";
        for (var j=0; j<gJoSrcCd.length; j++){
        	if (reDivrCd == "E"){
        		if (gJoSrcCd[j] == "B"){
	        		if (j==0){
	        			cdList = gJoSrcCd[j];
	        			nmList = gJoSrcNm[j];
	        		}else{
	        			cdList = cdList+"|"+gJoSrcCd[j];
	        			nmList = nmList+"|"+gJoSrcNm[j];
	        		}
        		}
        	}else if (reDivrCd == "R"){
        		if (gJoSrcCd[j] != "B"){
	        		if (j==0){
	        			cdList = gJoSrcCd[j];
	        			nmList = gJoSrcNm[j];
	        		}else{
	        			cdList = cdList+"|"+gJoSrcCd[j];
	        			nmList = nmList+"|"+gJoSrcNm[j];
	        		}
        		}
        	}
        }
		//sheetObj.InitCellProperty(i, prefix+"jo_src_cd", dtCombo);
        //sheetObj.CellComboItem(i, prefix+"jo_src_cd" , nmList, cdList);
        //sheetObj.CellValue2(i, prefix+"jo_src_cd") = joSrcCd;

        cdList = "";
        nmList = "";
        var joBkgTpCd = sheetObj.CellValue(i, prefix+"jo_bkg_tp_cd"); 
        if (joSrcCd == "B"){
        	for (var j=0; j<gJoBkgTpCd.length; j++){
        		if (j==0){
        			cdList = gJoBkgTpCd[j];
        			nmList = gJoBkgTpNm[j];
        		}else{
        			cdList = cdList+"|"+gJoBkgTpCd[j];
        			nmList = nmList+"|"+gJoBkgTpNm[j];
        		}
        	}
			sheetObj.InitCellProperty(i, prefix+"jo_bkg_tp_cd", dtCombo);
            sheetObj.CellComboItem(i, prefix+"jo_bkg_tp_cd" , nmList, cdList);
            sheetObj.CellEditable(i, prefix+"jo_bkg_tp_cd") = true;
            sheetObj.CellValue2(i, prefix+"jo_bkg_tp_cd") = joBkgTpCd;
        }else{
			sheetObj.InitCellProperty(i, prefix+"jo_bkg_tp_cd", dtData);
            sheetObj.CellEditable(i, prefix+"jo_bkg_tp_cd") = false;
        }
	}
}

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
	var sName = sheetObj.ColSaveName(Col);

	var Value = sheetObj.EditValue;
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	gRow = Row;
	var formObj = document.form;
    switch (sheetObj.ColSaveName(Col)) {
		case prefix+"ofc_cd":
			doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01);
			break;
	
		case prefix+"trd_cd":
			if (sheetObj.RowStatus(Row) == "I" || sheetObj.RowStatus(Row) == "U"){
				if (Value == ""){
					ComShowCodeMessage("JOO00009");
					sheetObj.SelectCell(Row, Col);
					return;
				}
				var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
				if (reDivrCd == "E") {				
					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03)
					sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "SML";
					sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
				} else {
					sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "";
					sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03)
				}
			}
			break;
		case prefix+"re_divr_cd":
			var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
			if (reDivrCd == "E") {
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "SML";
				sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = false;
			} else {
				sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "";
				sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
			}
			
			break;
		case prefix+"rlane_cd":
			if (sheetObj.RowStatus(Row) == "I" || sheetObj.RowStatus(Row) == "U"){
				if (sheetObj.CellValue(Row, prefix+"trd_cd") == ""){
					ComShowCodeMessage("JOO00009");
					sheetObj.SelectCell(Row, prefix+"trd_cd");
					return;
				}
				if (Value == ""){
					ComShowCodeMessage("JOO00010");
					sheetObj.SelectCell(Row, Col);
					return;
				}
				
				var trd   = sheetObj.CellValue(Row, prefix+"trd_cd");
				var rlane = sheetObj.CellValue(Row, prefix+"rlane_cd");
				var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
				
				var crrList = "";
				
				if (reDivrCd == "R") {
					
				for(var k=0; k<gTrdLaneCrrArr.length; k++){
					if (trd == gTrdLaneCrrArr[k][0] && rlane == gTrdLaneCrrArr[k][1]){
						if (k==0){
							crrList = gTrdLaneCrrArr[k][2];
						}else{
							crrList = crrList+"|"+gTrdLaneCrrArr[k][2];
						}
					}
				}
				
					sheetObj.InitCellProperty(Row, prefix+"jo_crr_cd", dtCombo);
			        sheetObj.CellComboItem(Row, prefix+"jo_crr_cd" , crrList, crrList);
			        sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "";
					sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = true;
				} else {
					sheetObj.CellValue2(Row, prefix+"jo_crr_cd") = "SML";
					sheetObj.CellEditable(Row, prefix+"jo_crr_cd") = false;
				}
				
				
		        
//		        var findSameRefNo = false;
//		        for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++){
//		        	if (i == Row || sheetObj.CellValue(i, prefix+"delt_flg") == "Y" || sheetObj.RowStatus(i) == "D") continue;
//		        	//같으면 날짜도 같고 수정 불가
//		        	if (sheetObj.CellValue(i, prefix+"ofc_cd"    ) == sheetObj.CellValue(Row, prefix+"ofc_cd"    )
//		        	&&  sheetObj.CellValue(i, prefix+"re_divr_cd") == sheetObj.CellValue(Row, prefix+"re_divr_cd")
//		        	&&  sheetObj.CellValue(i, prefix+"trd_cd"    ) == sheetObj.CellValue(Row, prefix+"trd_cd"    )
//		        	&&  sheetObj.CellValue(i, prefix+"rlane_cd"  ) == sheetObj.CellValue(Row, prefix+"rlane_cd"  )){
//		        		
//		        		sheetObj.CellValue2(Row, prefix+"agmt_eff_dt") = sheetObj.CellValue(i, prefix+"agmt_eff_dt"); 
//		        		sheetObj.CellValue2(Row, prefix+"agmt_exp_dt") = sheetObj.CellValue(i, prefix+"agmt_exp_dt");
//		        		sheetObj.CellEditable(Row, prefix+"agmt_eff_dt") = false;
//		        		sheetObj.CellEditable(Row, prefix+"agmt_exp_dt") = false;
//		        		findSameRefNo = true;
//		        		break;
//		        	}
//		        }
		        
		        	doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
			}
			break;
			
		case prefix+"jo_ref_no":
			var arrText = (sheetObj.GetComboInfo(Row, Col, "Text")).split("|");
			var idx     = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");

			if (arrText.length > 0 ){
				//var arrTextArr = (arrText[idx]).split("\t");
				//sheetObj.CellValue2(Row, prefix+"agmt_eff_dt") = arrTextArr[1];
				//sheetObj.CellValue2(Row, prefix+"agmt_exp_dt") = arrTextArr[2];
			}
			break;
			
		case prefix+"agmt_eff_dt":
			var arrText = (sheetObj.GetComboInfo(Row, Col, "Text")).split("|");
			//var arrCode = sheetObj.GetComboInfo(Row, Col, "Code").split("|");
			var idx     = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			//alert(idx);
			if (arrText.length > 0 ){
				var arrTextArr = (arrText[idx]).split("\t");
				sheetObj.CellValue2(Row, prefix+"agmt_exp_dt") = arrTextArr[1];
				sheetObj.CellValue2(Row, prefix+"jo_ref_no"  ) = arrTextArr[2];
			}
			break;
			
		case prefix+"re_divr_cd":
	        var reDivrCd = sheetObj.CellValue(Row, prefix+"re_divr_cd");
	        
	        var cdList = "";
	        var nmList = "";
	        
	        for (var j=0; j<gJoSrcCd.length; j++){
	        	if (reDivrCd == "E"){
	        		if (gJoSrcCd[j] == "B"){
		        		if (j==0){
		        			cdList = gJoSrcCd[j];
		        			nmList = gJoSrcNm[j];
		        		}else{
		        			cdList = cdList+"|"+gJoSrcCd[j];
		        			nmList = nmList+"|"+gJoSrcNm[j];
		        		}
	        		}
	        	}else if (reDivrCd == "R"){
	        		if (gJoSrcCd[j] != "B"){
		        		if (j==0){
		        			cdList = gJoSrcCd[j];
		        			nmList = gJoSrcNm[j];
		        		}else{
		        			cdList = cdList+"|"+gJoSrcCd[j];
		        			nmList = nmList+"|"+gJoSrcNm[j];
		        		}
	        		}
	        	}
	        }
			//sheetObj.InitCellProperty(Row, prefix+"jo_src_cd", dtCombo);
	        //sheetObj.CellComboItem(Row, prefix+"jo_src_cd" , nmList, cdList);
			
			break;
			
		case prefix+"jo_src_cd":
	        /*
			var cdList = "";
	        var nmList = "";

	        if (Value == "B"){
	        	for (var j=0; j<gJoBkgTpCd.length; j++){
	        		if (j==0){
	        			cdList = gJoBkgTpCd[j];
	        			nmList = gJoBkgTpNm[j];
	        		}else{
	        			cdList = cdList+"|"+gJoBkgTpCd[j];
	        			nmList = nmList+"|"+gJoBkgTpNm[j];
	        		}
	        	}
				sheetObj.InitCellProperty(Row, prefix+"jo_bkg_tp_cd", dtCombo);
	            sheetObj.CellComboItem(Row, prefix+"jo_bkg_tp_cd" , nmList, cdList);
				sheetObj.CellEditable(Row, prefix+"jo_bkg_tp_cd") = true;
	        }else{
				sheetObj.InitCellProperty(Row, prefix+"jo_bkg_tp_cd", dtData);
				sheetObj.CellEditable(Row, prefix+"jo_bkg_tp_cd") = false;
	        }
			*/
			var cdList = "";
	        var nmList = "";

	        if (Value == "T" || Value == "R"){
				for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++){
					sheetObj.cellValue(Row,prefix+"jo_bkg_tp_cd") = "";
				}
				sheetObj.CellEditable(Row, prefix+"jo_bkg_tp_cd") = false;
	        }else{for (var j=0; j<gJoBkgTpCd.length; j++){
	        		if (j==0){
	        			cdList = gJoBkgTpCd[j];
	        			nmList = gJoBkgTpNm[j];
	        		}else{
	        			cdList = cdList+"|"+gJoBkgTpCd[j];
	        			nmList = nmList+"|"+gJoBkgTpNm[j];
	        		}
	        	}
				sheetObj.InitCellProperty(Row, prefix+"jo_bkg_tp_cd", dtCombo);
	            sheetObj.CellComboItem(Row, prefix+"jo_bkg_tp_cd" , nmList, cdList);
				sheetObj.CellEditable(Row, prefix+"jo_bkg_tp_cd") = true;
	        }			
			break;
    }
}

function sheet1_OnPopupClick(sheetObj, Row, Col) {
    switch (sheetObj.ColSaveName(Col)) {
		case prefix+"agmt_eff_dt":
			var cal = new ComCalendarGrid();
			cal.select(sheetObj, Row, Col, "yyyy-MM-dd");
			break;
		case prefix+"agmt_exp_dt":
			var cal = new ComCalendarGrid();
			cal.select(sheetObj, Row, Col, "yyyy-MM-dd");
			break;
		case prefix+"ofc_cd":
			ComOpenPopup("/hanjin/COM_ENS_071.do", 750, 470, "ofc_cd_sheet_pop_event", "1,0,1", true, false, Row, Col, 0);
			break;

	}
}

// 2012.06.04 사용자 요청
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	gRow = Row;
	var formObj = document.form;
    switch (sheetObj.ColSaveName(Col)) {
		case prefix+"jo_crr_flag":
			var joRefNo = sheetObj.CellValue(Row, prefix+"jo_ref_no");
			if( joRefNo == '' ) {
				ComShowCodeMessage("JOO00192");
			} else {
			//var param = '?csrNo=' + '111';
				var paramUrl = "pgmNo=FNS_JOO_0086&jo_ref_no="+joRefNo;
			//	var newWin = window.showModalDialog("ESD_SCE_0915.do?"+paramUrl, "bkg_info_win", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:810px;dialogHeight:415px");

			ComOpenPopup("/hanjin/FNS_JOO_0086.do?"+paramUrl, 935, 240,
					"popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0,
					"pop1");
			}
			break;

	}
}

function ofc_cd_sheet_pop_event(aryPopupData, row, col, sheetIdx){
	sheetObjects[sheetIdx].CellValue(row, col) = aryPopupData[0][3];
}


function ofc_cd_OnChange(comObj, Value, Text) {
	sheetObjects[0].RemoveAll();
}

function UF_copyRow(){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	
	var arrs = sheetObj.GetSelectionRows(",");
	var rows = arrs.split(",");
	for (var i = rows.length-1; i >= 0; i--){
		sheetObj.SelectCell(rows[i], 7);		
		var row = sheetObj.DataCopy();
		sheetObj.CellValue2(row, prefix+"ibflag"    ) = "I";
		sheetObj.CellValue2(row, prefix+"jo_ref_no" ) = "";
		sheetObj.CellValue2(row, prefix+"jo_ref_seq") = "";
		sheetObj.CellValue2(row, prefix+"delt_flg"  ) = "N";
		sheetObj.CellValue2(row, prefix+"cre_dt"    ) = "";
		sheetObj.CellValue2(row, prefix+"upd_dt"    ) = "";
		sheetObj.CellValue2(row, prefix+"cre_usr_id") = gUsrId;
		sheetObj.CellValue2(row, prefix+"cre_usr_nm") = gUsrNm;
		
		var sCode = sheetObj.GetComboInfo(row, prefix+"rlane_cd", "Code");
		var arrCode = sCode.split("|");
		
		//Copy한 Lane이 Combo가 아니라면 Combo로 만들어 준다.
		if (arrCode.length <= 1){
			var trd = sheetObj.CellValue(row, prefix+"trd_cd");
			
			var laneList = "";
			var lane = "";
			var cnt = 0;
			for(var k=0; k<gTrdLaneCrrArr.length; k++){
				if (trd == gTrdLaneCrrArr[k][0]){
					//TRADE_-LANE-CARRIER를 열거한 거라 lane이 같은게 있을 수 있으므로 중복을 제거한다.
					if (lane != gTrdLaneCrrArr[k][1]){
						lane = gTrdLaneCrrArr[k][1];
						
						if (cnt==0){
							laneList = gTrdLaneCrrArr[k][1];
						}else{
							laneList = laneList+"|"+gTrdLaneCrrArr[k][1];
						}
						cnt++;
					}
				}
			}
			sheetObj.InitCellProperty(row, prefix+"rlane_cd", dtCombo);
	        sheetObj.CellComboItem(row, prefix+"rlane_cd" , laneList, laneList);
		}
		
		if (i==0){
			sheetObj.SelectCell(row, prefix+"ofc_cd");
		}			
	}
}

function UF_addRow(i){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	var row;
	if (i == undefined || i == null || i == ""){
		row = sheetObj.DataInsert();
	}else{
		row = sheetObj.DataInsert(-1);		
	}

	sheetObj.CellValue2(row, prefix+"re_divr_cd")   = "";
	sheetObj.CellValue2(row, prefix+"trd_cd"   )    = "";
	sheetObj.CellValue2(row, prefix+"jo_crr_flag")  = "N"; //2012.06.01 Add
	sheetObj.CellValue2(row, prefix+"jo_src_cd")    = "";
	//sheetObj.CellValue2(row, prefix+"jo_bkg_tp_cd") = "";
	sheetObj.CellValue2(row, prefix+"delt_flg")     = "N";
	sheetObj.CellValue2(row, prefix+"cre_usr_id")   = gUsrId;
	sheetObj.CellValue2(row, prefix+"cre_usr_nm")   = gUsrNm;
	sheetObj.SelectCell(row, prefix+"ofc_cd");
	sheetObj.CellValue2(row, prefix+"jo_ton_wgt_rnd_rt")   = "1";
	sheetObj.CellValue2(row, prefix+"jo_20ft_rnd_rt")   = "1";
	sheetObj.CellValue2(row, prefix+"jo_40ft_rnd_rt")   = "1";
	sheetObj.CellValue2(row, prefix+"jo_45ft_rnd_rt")   = "1";
	
	return row;
}

function UF_reset(){
	for(var i=0; i<comboObjects.length; i++){
		if (i == 5){
			comboObjects[i].Index2 = 2;
		}else{
			comboObjects[i].Index2 = (comboObjects[i].GetCount() == 0? -1 : 0);
		}
	}
	document.form.ofc_cd.value = "";
	sheetObjects[0].RemoveAll();

	comboObjects[2].Text2 = "No";
	comboObjects[5].RemoveAll();
	doActionIBCombo(sheetObjects[0], document.form, IBSEARCH, comboObjects[5] ,"rlane_cd");
//	comboObjects[5].InsertItem(0, "ALL", " ");
//	comboObjects[5].Text2 = "ALL";
//	comboObjects[6].RemoveAll();
//	comboObjects[6].InsertItem(0, "All", " ");
//	comboObjects[6].InsertItem(1, "Yes", "Y");
//	comboObjects[6].InsertItem(2, "No", "N");
//	comboObjects[6].Text2 = "ALL";
}
/* 개발자 작업  끝 */