/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_JOO_0074.js
 *@FileTitle : Estimate Performance Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.16
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.09.16 박희동
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
 * @class FNS_JOO_0074 : FNS_JOO_0074 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0074() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix="sheet1_";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;

			case "btn_new":
				UF_reset();
				break;

			case "btn_downexcel":
				sheetObjects[0].SpeedDown2Excel(-1);
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
	for (var i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
	
	initControl();	
}

/**
 * Combo 기본 설정
 * Combo의 항목을 설정한다.
 * @param comboObj 
 * @param comboIndex Number
 */
function initCombo(comboObj, comboNo) {
	var formObject = document.form

	switch (comboNo) {
		case 1: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = false;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}
			if (ComTrim(gTrdCd) != ""){
				var comboItems = (" |"+gTrdCd).split("|");
				addComboItem(comboObj, comboItems);
			}
			break; 
			
		case 2: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = false;	
				SetColAlign("left");        
				SetColWidth("50");
				DropHeight = 160;
 				ValidChar(2,1);//영문대문자+숫자만 입력가능
				MaxLength=5;
			}
			if (ComTrim(gRlaneCd) != ""){
				var comboItems = (" |"+gRlaneCd).split("|");
				addComboItem(comboObj, comboItems);
			}
			break;
			
		case 3: 
			with (comboObj) { 
				MultiSelect = false; 
				UseAutoComplete = false;	
				SetColAlign("left");        
				SetColWidth("30");
				DropHeight = 160;
				ValidChar(2,0);//영문대문자만 입력가능
				MaxLength=3;
			}
			if (ComTrim(gJoCrrCd) != ""){
				var comboItems = (" |"+gJoCrrCd).split("|");
				addComboItem(comboObj, comboItems);
			}
			break;

		case 4: 
            with (comboObj) { 
 				MultiSelect = false; 
 				UseAutoComplete = false;	
 				SetColAlign("left|left");        
 				SetColWidth("50|0");
  				DropHeight = 160;
 				ValidChar(2,0);//영문대문자만 입력가능
  		    }
			comboObj.RemoveAll();

			var codeItems = (" |"+gBsaTpCd).split("|");
			var nameItems = (" |"+gBsaTpNm).split("|");

			for (var i = 0 ; i < codeItems.length ; i++) {
				comboObj.InsertItem(i, nameItems[i]+"|"+codeItems[i], codeItems[i]);
			}   	
			
			break;
	}
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {

	var formObject = document.form;

	axon_event.addListener('click', 'fnDocClick', "btn_exe_back");
	axon_event.addListener('click', 'fnDocClick', "btn_exe_next");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_from_back");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_from_next");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_to_back");
	axon_event.addListener('click', 'fnDocClick', "btn_vvd_to_next");
    axon_event.addListener('click', 're_divr_cd_click', 're_divr_cd');
    axon_event.addListener('click', 'diff_option_click', 'diff_option');

    axon_event.addListenerForm('keypress', 'fnObjKeyPress', formObject);

	axon_event.addListenerFormat('blur', 'fnDeactivate', formObject);
	axon_event.addListenerFormat('focus', 'fnActivate', formObject);
	
	//formObject.exe_yrmon.focus();
}

function re_divr_cd_click(){
	UF_setCond("1");
}

function diff_option_click(){
	sheetObjects[0].RemoveAll();
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
				style.height = 360;
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
	
				var HeadTitle = "Seq.|Revenue\nMonth|Carrier\nCode|Service\nProvider/\nCustomer|Revenue\nVVD|Revenue\nLane|BSA\nType|BSA|Slot\nPrice"
					+"|Account\nCode|Estimated\nCost|Actual\nCost|Accrual\nCost|Diff.\nAmount|Type|IO\nFlag|STS\nMK"; //|Actual Month|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|REV_DIR_CD|||||";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false)
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtDataSeq      ,  30, daCenter, false, prefix+"seq"              , false, "", dfNone  , 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  60, daCenter, false, prefix+"rev_yrmon"        , false, "", dfDateYm, 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  50, daCenter, false, prefix+"jo_crr_cd"        , false, "", dfNone  , 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  110, daCenter, false, prefix+"vndr_cust_seq"    , false, "", dfNone  , 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  80, daLeft  , false, prefix+"vvd"              , false, "", dfNone  , 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  60, daCenter, false, prefix+"rlane_cd"         , false, "", dfNone  , 0, false, false);
				InitDataProperty(0, cnt++, dtCombo        , 130, daLeft  , false, prefix+"jo_stl_jb_cd"     , false, "", dfNone  , 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  50, daRight , false, prefix+"bsa_qty"          , false, "", dfNumber, 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  60, daRight , false, prefix+"bsa_slt_prc"      , false, "", dfFloat , 2, false, false);
				InitDataProperty(0, cnt++, dtData         ,  70, daCenter, false, prefix+"acct_cd"          , false, "", dfNone  , 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  80, daRight , false, prefix+"estm_amt"         , false, "", dfFloat , 2, false, false);
				InitDataProperty(0, cnt++, dtData         ,  80, daRight , false, prefix+"act_amt"          , false, "", dfFloat , 2, false, false);
				InitDataProperty(0, cnt++, dtData         ,  80, daRight , false, prefix+"accl_amt"         , false, "", dfFloat , 2, true , true );
				InitDataProperty(0, cnt++, dtData         ,  80, daRight , false, prefix+"diff_amt"         , false, "", dfFloat , 2, true , true );
				InitDataProperty(0, cnt++, dtData         ,  40, daCenter, false, prefix+"estm_vvd_tp_cd"   , false, "", dfNone  , 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  40, daCenter, false, prefix+"jo_ioc_div_cd"    , false, "", dfNone  , 0, false, false);
				InitDataProperty(0, cnt++, dtData         ,  40, daCenter, false, prefix+"accl_amt_corr_flg", false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"exe_yrmon"        , false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"vsl_cd"           , false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"skd_voy_no"       , false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"skd_dir_cd"       , false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"rev_dir_cd"       , false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"estm_vvd_hdr_id"  , false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"cntr_blk_div_cd"  , false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"sys_src_id"       , false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"jo_cntr_div_ctnt" , false, "", dfNone  , 0, false, false);
	//			InitDataProperty(0, cnt++, dtHidden       ,   0, daCenter, false, prefix+"loc_cd"           , false, "", dfNone  , 0, false, false);
	
				InitDataCombo (0, prefix+"jo_stl_jb_cd",gBsaTpNm , gBsaTpCd);
				
			}
			break;
	
		case 2: // 단지 Estiamted Period 변경시 마감여부를 check할 때 깜빡임을 방지하기 위한 sheet임
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
			}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	if (!validateForm(sheetObj, formObj, sAction)) {
		return;
	}

	switch (sAction) {

		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			var param = FormQueryString(formObj)+"&" + ComGetPrefixParam(prefix);
			sheetObj.DoSearch("FNS_JOO_0074GS.do", param);
			break;
			
		case IBROWSEARCH:
			formObj.f_cmd.value = SEARCHLIST01;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0074GS.do", FormQueryString(formObj));
			
			var conFlg = formObj.estm_cond_flg.value;
			switch(conFlg){
				//EXE_YRMON, RE_DIVR_Cd변경시 REV_YRMON_FR, REV_YRMON_TO, TRADE, LANE, CARRIER 조회한다.
				case "1":
					var revYrmonFr = ComGetEtcData(sXml, "REV_YRMON_FR");
					var revYrmonTo = ComGetEtcData(sXml, "REV_YRMON_TO");
					
					formObj.rev_yrmon_fr.value = revYrmonFr.substring(0,4)+"-"+revYrmonFr.substring(4);
					formObj.rev_yrmon_to.value = revYrmonTo.substring(0,4)+"-"+revYrmonTo.substring(4);

				//EXE_YRMON, RE_DIVR_Cd변경시 REV_YRMON_FR, REV_YRMON_TO, TRADE, LANE, CARRIER 조회한다.
				case "2":
					var trdCombo = ComGetEtcData(sXml, "TRD_CD");
					if (ComTrim(trdCombo) != ""){
						var comboItems = (" |"+trdCombo).split("|");
						addComboItem(comboObjects[0], comboItems);
					}
				
				case "3":
					var rlaneCombo = ComGetEtcData(sXml, "RLANE_CD");
					if (ComTrim(rlaneCombo) != ""){
						var comboItems = (" |"+rlaneCombo).split("|");
						addComboItem(comboObjects[1], comboItems);
					}
					
				case "4":
					var crrCombo = ComGetEtcData(sXml, "JO_CRR_CD");
					if (ComTrim(crrCombo) != ""){
						var comboItems = (" |"+crrCombo).split("|");
						addComboItem(comboObjects[2], comboItems);
					}
					break;
			}
			break;

		case IBRESET: //NEW 버튼  
			UF_reset();
			break;
	}	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
			case IBSEARCH:
				if (formObj.exe_yrmon.value.length == 0){
					ComShowCodeMessage('JOO00089');
					formObj.exe_yrmon.focus();
					return false;
				}
				break;
		}
	}
	return true;
}


function trd_cd_OnChange(comboObj, Value, Text) {
	UF_setCond("3");
}

function rlane_cd_OnChange(comboObj, Value, Text) {
	UF_setCond("4");
}

function jo_crr_cd_OnChange(comboObj, Value, Text) {
	sheetObjects[0].RemoveAll();
}

function jo_stl_jb_cd_OnChange(comboObj, Value, Text) {
	sheetObjects[0].RemoveAll();
}

/**************************************USER FUNCTION *****************************************************/

/**
 * NEW 버튼 처리 
 * @param    void
 * @return   void
 */
function UF_reset() {
	var formObj = document.form;
	
	sheetObjects[0].RemoveAll();

	comboObjects[0].RemoveAll();
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	comboObjects[3].Index2 = -1;
	
	
	var comboItems;
	
	if (ComTrim(gTrdCd) != ""){
		comboItems = (" |"+gTrdCd).split("|");
		addComboItem(comboObjects[0], comboItems);           	
	}

	//Rlane Combo setting
	if (ComTrim(gRlaneCd) != ""){
		comboItems = (" |"+gRlaneCd).split("|");
		addComboItem(comboObjects[1], comboItems);
	}
	
	//Carrier Combo setting
	if (ComTrim(gJoCrrCd) != ""){
		comboItems = (" |"+gJoCrrCd).split("|");
		addComboItem(comboObjects[2], comboItems);           	
	}

	formObj.exe_yrmon.value    = gExeYrmon.substring(0,4)+"-"+gExeYrmon.substring(4);
	formObj.rev_yrmon_fr.value = gRevYrmonFr.substring(0,4)+"-"+gRevYrmonFr.substring(4);
	formObj.rev_yrmon_to.value = gRevYrmonTo.substring(0,4)+"-"+gRevYrmonTo.substring(4);

	formObj.re_divr_cd[0].checked = true;
	formObj.diff_option[0].checked = true;
	formObj.vvd.value = "";
}

/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 잃었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnDeactivate() {
	switch (event.srcElement.name) {
		case 'exe_yrmon':
			ComAddSeparator(event.srcElement);
			UF_setCond("1");
			break;
		case 'rev_yrmon_fr':
			ComChkObjValid(event.srcElement); // 포커스 나갈때 기간체크도 실시함..                  
			UF_setCond("2");
			break;
		case 'rev_yrmon_to':
			ComChkObjValid(event.srcElement); // 포커스 나갈때 기간체크도 실시함..                        
			UF_setCond("2");
			break;
	}
}
/**
 * <pre>
 *     form element의 dataformat을 이용한 입력 Validate 처리,
 *     focus 얻었을때발생.
 * </pre>
 * 
 * @return void
 */
function fnActivate() {
	switch (event.srcElement.name) {
		case 'exe_yrmon':
			ComClearSeparator(event.srcElement);
			break;
		case 'rev_yrmon_fr':
			ComClearSeparator(event.srcElement);
	
			break;
		case 'rev_yrmon_to':
			ComClearSeparator(event.srcElement);
			break;
	}
	event.srcElement.select();
}
/**
 * 년월 NAVI 처리 이벤트 
 * @param void
 * @return void
 */
function fnDocClick() {
	var obj = event.srcElement;
	var formObj = document.form;

	switch (obj.name) {
		case "btn_exe_back":
			UF_addMonth(formObj.exe_yrmon, -1);
			UF_setCond("1");
			break;

		case "btn_exe_next":
			UF_addMonth(formObj.exe_yrmon, +1);
			UF_setCond("1");
			break;

		case "btn_vvd_from_back":
			UF_addMonth(formObj.rev_yrmon_fr, -1);
			UF_setCond("2");
			break;

		case "btn_vvd_from_next":
			if (!UF_checkPeriod()){
				ComShowCodeMessage("JOO00078");
				return;
			}
			UF_addMonth(formObj.rev_yrmon_fr, +1);
			UF_setCond("2");
			break;

		case "btn_vvd_to_back":
			if (!UF_checkPeriod()){
				ComShowCodeMessage("JOO00078");
				return;
			}
			UF_addMonth(formObj.rev_yrmon_to, -1);
			UF_setCond("2");
			break;

		case "btn_vvd_to_next":
			UF_addMonth(formObj.rev_yrmon_to, 1);
			UF_setCond("2");
			break;
	}
}
/**
 * <pre>
 *    form Element의 KeyPress Event 발생시 처리.
 *    
 * </pre>
 * @return
 */
function fnObjKeyPress() {
	var obj = event.srcElement;
	var formObj = document.form;
	switch (obj.name) {
		case 'exe_yrmon':
			ComKeyOnlyNumber(obj);
			break;
	
		case 'rev_yrmon_fr':
			ComKeyOnlyNumber(obj);
			break;
	
		case 'rev_yrmon_to':
			ComKeyOnlyNumber(obj);
			break;

		case 'vvd':
		    ComKeyOnlyAlphabet('uppernum');
			break;
			
	}
}

function UF_setCond(flg){
	var formObj = document.form;
	
	formObj.estm_cond_flg.value = flg;
	
	switch (flg){
	//exe month, re_divr_cd 변경시
	case "1":
		formObj.rev_yrmon_fr.value = "";
		formObj.rev_yrmon_to.value = "";
	//rev year month변경시
	case "2":
		formObj.trd_cd.Index2 = -1;
		formObj.trd_cd.RemoveAll();
	//Trade변경시
	case "3":
		formObj.rlane_cd.Index2 = -1;
		formObj.rlane_cd.RemoveAll();
	//Lane변경시
	case "4":
		formObj.jo_crr_cd.Index2 = -1;
		formObj.jo_crr_cd.RemoveAll();
		break;
	}
	sheetObjects[0].RemoveAll();
	doActionIBSheet(sheetObjects[1], formObj, IBROWSEARCH);		
}

function UF_checkPeriod(){
	var formObj = document.form;
	var frDt = formObj.rev_yrmon_fr.value.replaceStr("-","")+"01";
	var toDt = formObj.rev_yrmon_to.value.replaceStr("-","")+"01";

	if (ComGetDaysBetween(frDt, toDt) <= 0){
		return false;
	}	
	
	return true;
}

function trd_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 9 || KeyCode == 13)
		setTimeout("document.getElementById(\"" + comboObjects[1].id  + "\").focus()", 0.1);
}

function rlane_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 9 || KeyCode == 13)
		setTimeout("document.getElementById(\"" + comboObjects[2].id  + "\").focus()", 0.1);
}

function jo_crr_cd_OnKeyDown(comboObj, KeyCode, Shift) {
	if (KeyCode == 9 || KeyCode == 13)
		setTimeout("document.getElementById(\"" + comboObjects[3].id  + "\").focus()", 0.1);
}
/* 개발자 작업  끝 */