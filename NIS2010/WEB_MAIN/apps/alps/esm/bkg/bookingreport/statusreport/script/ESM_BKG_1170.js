/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1170.js
 *@FileTitle : booking report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.15
 *@LastModifier : 조원주
 *@LastVersion : 1.0
 * 2012.02.15 조원주
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
 * @class ESM_BKG_0111_01 : ESM_BKG_0111_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1170_01() {
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

var sheetObjects    = new Array();
var sheetObjectsMap = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

var tabItem = 0;

var loadPageCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
	sheetObjectsMap[sheet_obj.id] = sheet_obj;
}

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
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	doActionIBSheet(sheetObjects[1], document.form, COMMAND01);
	
	//setSheetVisble(0);

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	//MultiCombo초기화 
	for(var k=0;k<comboObjects.length;k++){
         initCombo(comboObjects[k],comboObjects[k].id);
     }
	
	ComSetObjValue(document.form.charge_cd,'1');
	document.form.charge_cd.focus();
	initControl();
	
	loadPageCnt = 1;

//	document.form.fr_dt.value ="2014-10-01";
//	document.form.to_dt.value ="2014-10-10";
}

/**
 * 콤보 초기설정값
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj, comboId) {
	var formObject = document.form
	
	if( comboId == "charge_cd" ){
	    comboObj.DropHeight = 200; 
	    initCombo_charge_cd();
	}
	
	if( comboId == "p_rhq_bkg_ofc_cd" ){
	    comboObj.DropHeight = 200; 
	    //initCombo_rhq_ofc_cd();
	}	
}

/**
 * Charge Code Setting
 */
function initCombo_charge_cd() {
	with (document.form.charge_cd) {
		MultiSelect = false; 
		MultiSeparator=",";
		//ColCnt = 2;
			var i=0; 
			InsertItem(i++, "BCC,MCF","1"); 
			InsertItem(i++, "OBS", "2"); 
			InsertItem(i++, "BLR", "3"); 
			InsertItem(i++, "LBP", "4"); 
			InsertItem(i++, "TPF", "5"); 
			InsertItem(i++, "CTC", "6"); 
			InsertItem(i++, "LSI", "7"); 
		} 
}

/**
 * Multi Combo Setting
 */
function initCombo_rhq_ofc_cd() {
	with (document.form.p_rhq_bkg_ofc_cd) {
		MultiSelect = true; 
		MultiSeparator=",";
		} 
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
     var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
     
     //alert("keyValue : " + keyValue);
	 
	 
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	if ( keyValue != 9 && keyValue !=16 && ComChkLen(srcValue, srcMaxLength) == "2" ) {
		ComSetNextFocus();
	}
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	
 	DATE_SEPARATOR = "-";
 	
 	var formObject = document.form;
 	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
 	axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
	axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
 	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
 	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 	
	ComSetObjValue(formObject.fr_dt,ComGetNowInfo());
	ComSetObjValue(formObject.to_dt,ComGetNowInfo());  
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "int":
		//숫자만입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		//숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	case "eng":
		//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		ComKeyOnlyAlphabet();
		break;
	case "engdn":
		//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		ComKeyOnlyAlphabet('lower');
		break;
	case "engup":
		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "engupnum":
		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	default:
		//숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(event.srcElement);
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
	case 1:
		with (sheetObj) {
			// 높이 설정
			style.height = 94;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
	
			var HeadTitle1 = " | |Scope";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");

			InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, "ibflag", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true,"slct_flg");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "m_svc_scp_cd", false, "", dfEngUpKey, 0, true, true);
			
			CountPosition = 0;

		}
		break;
	case 2:
		with (sheetObj) {
			// 높이 설정
			style.height = 94;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
	
			var HeadTitle1 = " | |Office";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");

			InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, "ibflag", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true,"slct_flg");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "m_gso_ofc_cd", false, "", dfEngUpKey, 0, true, true);
			
			CountPosition = 0;

		}
		break;
		
	case 3:
		with (sheetObj) {
			// 높이 설정
			style.height = 94;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
	
			var HeadTitle1 = " | |Office";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");

			InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, "ibflag", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true,"slct_flg");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "m_ctrt_ofc_cd", false, "", dfEngUpKey, 0, true, true);
			
			CountPosition = 0;

		}
		break;
		
	case 4:
		with (sheetObj) {
			// 높이 설정
			style.height = 94;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 100);
	
			var HeadTitle1 = " | |Office";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");

			InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, "ibflag", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true,"slct_flg");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "m_p_ofc_cd", false, "", dfEngUpKey, 0, true, true);
			
			CountPosition = 0;

		}
		break;		
		
	case 5: //t1sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 382;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge+msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);


			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Booking\n RHQ|Booking\n GSO OFC|Booking\n OFC|CA Office|BL Issue\n Office|Prepaid\n Office|Collect\n Office|No. of BL|No of BL\n Rating|Application\n Ratio|Cur.|Rating\n Total";
			
	        var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 3, 0, true);
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			//InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "rhq_bkg_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "gso_bkg_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "bkg_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "corr_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "obl_iss_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "ppd_rcv_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "clt_ofc_cd", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "bl_cnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "bl_rate_cnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "appl_ratio", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "curr_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daRight, true, "rating_ttl", false, "", dfNone, 0, false, true);

		    ShowSubSum("rhq_bkg_ofc_cd", "gso_bkg_ofc_cd", 0, false, false, SaveNameCol("rhq_bkg_ofc_cd"));
		      
			CountPosition = 0;
		}
		break;

	case 6: //t2sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 382;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(15, 4, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Scope|Booking\n R.OFC|BKG OFC|POR|POL|POD|DEL|Contract\n No.|Customer\n Code|Customer|No. of BL|No. of BL\n Rating|Application\n Ratio|Cur.|Rating\n Total";
			
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "svc_scp_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "rhq_bkg_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "bkg_ofc_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "por_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pol_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "pod_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "del_cd", false, "", dfNone, 0, false, true);
			
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "contract_no", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "customer_code", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daLeft, true, "customer_name", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "bl_cnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "bl_rate_cnt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, true, "appl_ratio", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "curr_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 110, daRight, true, "rating_ttl", false, "", dfNone, 0, false, true);
			
			CountPosition = 0;
		}
		break;
	case 7: //Collect Office 다중 선택
		with (sheetObj) {
		// 높이 설정
		style.height = 94;
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;

		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "")
			InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msHeaderOnly;

		// 전체Edit 허용 여부 [선택, Default false]
		Editable = true;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(1, 1, 2, 100);

		var HeadTitle1 = " | |Office";
		var headCount = ComCountHeadTitle(HeadTitle1);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false, false);

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
		// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		// InitDataProperty(0, cnt++ , dtHiddenStatus, 40, daCenter, true, "ibflag");

		InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, "ibflag", false, "", dfNone, 0, true, true);
		InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true,"slct_flg");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "m_p_ofc_cd", false, "", dfEngUpKey, 0, true, true);
		
		CountPosition = 0;

		}
		break;			

	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	var sheetObject5 = sheetObjects[4];
	var sheetObject6 = sheetObjects[5];
	/** **************************************************** */
	var formObject = document.form;

	//try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {

		case "btn_Retrieve":
			if (tabItem == 0) {
				ComSetObjValue(formObject.tab_cd, '1');
				doActionIBSheet(sheetObjects[4], document.form, IBSEARCH);
			} else {
				ComSetObjValue(formObject.tab_cd, '2');
				doActionIBSheet(sheetObjects[5], document.form, IBSEARCH);
			}
			break;
		
		case "btn_multi_scp":
			bkgScpListPopUp();
			break;
		case "btn_multi_ofc":
			bkgOfcListPopUp();
			break;	
		case "btn_multi_cofc":
			bkgCofcListPopUp();
			break;
		case "btn_multi_pofc":
			bkgPofcListPopUp();
			break;			
		case "btn_multi_pofc2":
			bkgPofcList2PopUp();
			break;			
		case "svc_scp_list_add":
			sheetObjects[0].DataInsert(-1);
			break;
		case "ofc_list_add":
			sheetObjects[1].DataInsert(-1);
			break;
		case "cofc_list_add":
			sheetObjects[2].DataInsert(-1);
			break;
		case "pofc_list_add":
			sheetObjects[3].DataInsert(-1);
			break;	
		case "pofc_list2_add":
			sheetObjectsMap["pOfcList2sheet"].DataInsert(-1);
			break;	
			
		case "svc_scp_list_del":
			if (sheetObjects[0].CheckedRows("slct_flg") != 0) {
				var checkList = sheetObjects[0].FindCheckedRow("slct_flg");
				var arrRow = checkList.split("|");
				for (idx=arrRow.length-2; idx>=0; idx--){ 	
					sheetObjects[0].RowDelete(arrRow[idx], false);
				}
			}
			break;
		case "ofc_list_del":
			if (sheetObjects[1].CheckedRows("slct_flg") != 0) {
				var checkList = sheetObjects[1].FindCheckedRow("slct_flg");
				var arrRow = checkList.split("|");
				for (idx=arrRow.length-2; idx>=0; idx--){ 	
					sheetObjects[1].RowDelete(arrRow[idx], false);
				}
			}
			break;
		case "cofc_list_del":
			if (sheetObjects[2].CheckedRows("slct_flg") != 0) {
				var checkList = sheetObjects[2].FindCheckedRow("slct_flg");
				var arrRow = checkList.split("|");
				for (idx=arrRow.length-2; idx>=0; idx--){ 	
					sheetObjects[2].RowDelete(arrRow[idx], false);
				}
			}
			break;
		case "pofc_list_del":
			if (sheetObjects[3].CheckedRows("slct_flg") != 0) {
				var checkList = sheetObjects[3].FindCheckedRow("slct_flg");
				var arrRow = checkList.split("|");
				for (idx=arrRow.length-2; idx>=0; idx--){ 	
					sheetObjects[3].RowDelete(arrRow[idx], false);
				}
			}
			break;
		case "pofc_list2_del":
			if (sheetObjectsMap["pOfcList2sheet"].CheckedRows("slct_flg") != 0) {
				var checkList = sheetObjectsMap["pOfcList2sheet"].FindCheckedRow("slct_flg");
				var arrRow = checkList.split("|");
				for (idx=arrRow.length-2; idx>=0; idx--){ 	
					sheetObjectsMap["pOfcList2sheet"].RowDelete(arrRow[idx], false);
				}
			}
			break;
			
		case "svc_scp_list_ok":
      	  	var svcScpList = "";
  			var sRow = sheetObjects[0].FindCheckedRow("slct_flg");	
  			var arrRow = sRow.split("|");	
  			for( var i = 0; i < arrRow.length-1; i++ ) {	
  				svcScpList = svcScpList + doSepRemove(sheetObjects[0].CellValue(arrRow[i], "m_svc_scp_cd"), " ")+",";
  			}
  			svcScpList = svcScpList.substring(0, svcScpList.length-1);
  			formObject.p_svc_scp_cd.value = svcScpList;
  			document.all.msvcScpCd.style.display = "none";
  			document.all.msvcScpCd.style.visibility = 'hidden';
			break;	
		case "ofc_list_ok":
      	  	var bkgOfcList = "";
  			var sRow = sheetObjects[1].FindCheckedRow("slct_flg");	
  			var arrRow = sRow.split("|");	
  			for( var i = 0; i < arrRow.length-1; i++ ) {	
  				bkgOfcList = bkgOfcList + ComReplaceStr(sheetObjects[1].CellValue(arrRow[i], "m_gso_ofc_cd"), " ","")+",";
  			}
  			bkgOfcList = bkgOfcList.substring(0, bkgOfcList.length-1);
  			formObject.p_gso_bkg_ofc_cd.value = bkgOfcList;

  			document.all.bkgOfcList.style.display = "none";
  			document.all.bkgOfcList.style.visibility = 'hidden';
			break;
		case "cofc_list_ok":
      	  	var ctrOfcList = "";
  			var sRow = sheetObjects[2].FindCheckedRow("slct_flg");	
  			var arrRow = sRow.split("|");	
  			for( var i = 0; i < arrRow.length-1; i++ ) {	
  				ctrOfcList = ctrOfcList + ComReplaceStr(sheetObjects[2].CellValue(arrRow[i], "m_ctrt_ofc_cd"), " ","")+",";
  			}
  			ctrOfcList = ctrOfcList.substring(0, ctrOfcList.length-1);
  			formObject.p_ctrt_ofc_cd.value = ctrOfcList;

  			document.all.ctrOfcList.style.display = "none";
  			document.all.ctrOfcList.style.visibility = 'hidden';
			break;
		case "pofc_list_ok":
      	  	var pOfcList = "";
  			var sRow = sheetObjects[3].FindCheckedRow("slct_flg");	
  			var arrRow = sRow.split("|");	
  			for( var i = 0; i < arrRow.length-1; i++ ) {	
  				pOfcList = pOfcList + ComReplaceStr(sheetObjects[3].CellValue(arrRow[i], "m_p_ofc_cd"), " ","")+",";
  			}
  			pOfcList = pOfcList.substring(0, pOfcList.length-1);
  			formObject.p_sel_ofc_cd.value = pOfcList;

  			document.all.pOfcList.style.display = "none";
  			document.all.pOfcList.style.visibility = 'hidden';
			break;			
		case "pofc_list2_ok":
			var pOfcList = "";
			var sRow = sheetObjectsMap["pOfcList2sheet"].FindCheckedRow("slct_flg");	
			var arrRow = sRow.split("|");	
			for( var i = 0; i < arrRow.length-1; i++ ) {	
				pOfcList = pOfcList + ComReplaceStr(sheetObjectsMap["pOfcList2sheet"].CellValue(arrRow[i], "m_p_ofc_cd"), " ","")+",";
			}
			pOfcList = pOfcList.substring(0, pOfcList.length-1);
			formObject.p_sel_ofc_cd2.value = pOfcList;
			
			document.all.pOfcList2.style.display = "none";
			document.all.pOfcList2.style.visibility = 'hidden';
			break;			

		case "btn_New":
			ComResetAll();
			break;

		case "btn_SaveExcel":
			if (tabItem == 0) {
				sheetObject5.SpeedDown2Excel(-1);
			} else {

				sheetObject6.SpeedDown2Excel(-1);
			}
			break;
			
		case "btn_BlInquiry":
			openDetail();
			break;
			
		case "charge_cd":
			alert("1");
			break

		} // end switch
//	} catch (e) {
//		if (e == "[object Error]") {
//			ComShowMessage(OBJECT_ERROR);
//		} else {
//			ComShowMessage(e);
//		}
//	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;

		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);

		sheetObj.FocusAfterProcess = false;
		formObj.f_cmd.value = SEARCH;
		
		sheetObj.DoSearch("ESM_BKG_1170GS.do", FormQueryString(formObj));

		//searchEnd(sheetObj);
		
		sheetObj.SelectCell(0, 0, false);

		ComOpenWait(false);
		
//		if (tabItem == 0) {
//			td_info.innerHTML = "Bl cnt:"+ComAddComma(sheetObjectsMap["t1sheet1"].ComputeSum("bl_cnt")) + " Rate cnt:"+ComAddComma(sheetObjectsMap["t1sheet1"].ComputeSum("bl_rate_cnt"));
//		}
		
		break;

	case COMMAND01: //CODE 조회						
		formObj.f_cmd.value = SEARCH01;
		// sheetObj.DoSearch("ESM_BKG_0111GS.do",FormQueryString(formObj));
		var searchXml = sheetObj.GetSearchXml("ESM_BKG_1170GS.do", FormQueryString(formObj));

		var sXml = searchXml.split("|$$|");

		// US Filer
		ComBkgXml2ComboItem(sXml[0], formObj.p_rhq_bkg_ofc_cd, "val", "name");
		//ComBkgXml2ComboItem(sXml[1], formObj.p_rhq_bkg_ofc_cd, "val", "name");
		
/*		if (arrXml.length > 3)
			ComXml2ComboItem(arrXml[3], formObj.elements["slan_cd"], "vsl_slan_cd", "vsl_slan_cd|vsl_slan_nm");
			formObj.slan_cd.InsertItem(0,"All","All");
            formObj.slan_cd.Index =0 ;
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], formObj.bkg_rt_sts_cd, "val", "name");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], formObj.bkg_sts_cd, "val", "name");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.rhq_cd, "val", "desc");;*/

		
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	
	if(ComGetObjValue(formObj.charge_cd) == ""){
		ComShowCodeMessage("BKG00104","Charge");
		formObj.charge_cd.focus();
		return false;
	}

	if(ComGetObjValue(formObj.fr_dt) == ""){
		ComShowCodeMessage("BKG00499");
		formObj.fr_dt.focus();
		return false;
	}
	if(ComGetObjValue(formObj.to_dt) == ""){
		ComShowCodeMessage("BKG00499");
		formObj.to_dt.focus();
		return false;
	}
 	
	if (!ComIsNull(formObj.fr_dt) 
  			&& !ComIsNull(formObj.to_dt) 
  			&& ComGetDaysBetween(formObj.fr_dt.value, formObj.to_dt.value) > 31){
   		 
			ComShowCodeMessage("BKG50469");//Can't Input Date Over 31 days!
			formObj.fr_dt.focus();
			return false;
	}

	var v_charge_cd = ComGetObjValue(formObj.charge_cd);
	var p_rhq_bkg_ofc_cd = ComGetObjValue(formObj.p_rhq_bkg_ofc_cd);
	if(v_charge_cd == "4" || v_charge_cd == "5" || v_charge_cd == "6" || v_charge_cd == "7"){
		if (ComIsNull(p_rhq_bkg_ofc_cd)){
			ComShowCodeMessage("BKG00104","Booking RHQ");
			formObj.p_rhq_bkg_ofc_cd.focus();
			return false;
		}
	}
	   
	return true;
}

/** 
 * sheet2 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
 */ 
 function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 	with(sheetObj) {
 		//ShowSubSum("sub_str", "", -1, false, false, 0);
 		ShowSubSum("rhq_bkg_ofc_cd", "", 0, false, false, 0);
 	}
 }
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	
	}

	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
	
				var cnt = 0;
				InsertTab(cnt++, "Summary View", -1);
				InsertTab(cnt++, "Detail View", -1);
	
			}
			break;
	
		}
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {
	
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		tabItem = nItem;
		
		// --------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab = nItem;
		
		
	    if(loadPageCnt == 0) return;
	    
	    //document.getElementById("btn_Retrieve").fireEvent("onclick");
	    
	
	}

	/**
	* Service Scope Multi Popup
	*/
	function bkgScpListPopUp() {
		var formObj = document.form;
		
  	  	if (document.all.msvcScpCd.style.display == "none") {
  			document.all.msvcScpCd.style.display = "block";
  			document.all.msvcScpCd.style.visibility = 'visible';
  			
  			document.all.bkgOfcList.style.display = "none";
  			document.all.bkgOfcList.style.visibility = 'hidden';
  			document.all.ctrOfcList.style.display = "none";
  			document.all.ctrOfcList.style.visibility = 'hidden';
  			document.all.pOfcList.style.display = "none";
  			document.all.pOfcList.style.visibility = 'hidden';
  			document.all.pOfcList2.style.display = "none";
  			document.all.pOfcList2.style.visibility = 'hidden';
  			if ( sheetObjects[0].RowCount < 1 ) {
  				sheetObjects[0].DataInsert(-1);
      			//sheetObjects[0].CellValue2(1, "p_rhq_bkg_ofc_cd") = formObj.p_rhq_bkg_ofc_cd.value;
  			}
  	  	} else {
  			document.all.msvcScpCd.style.display = "none";
  			document.all.msvcScpCd.style.visibility = 'hidden';
  	  	}
  	}
	
	/**
	* BKG OFC Multi Popup
	*/	
	function bkgOfcListPopUp() {
		var formObj = document.form;
		
  	  	if (document.all.bkgOfcList.style.display == "none") {
  			document.all.bkgOfcList.style.display = "block";
  			document.all.bkgOfcList.style.visibility = 'visible';
  			
  			document.all.msvcScpCd.style.display = "none";
  			document.all.msvcScpCd.style.visibility = 'hidden';
  			document.all.ctrOfcList.style.display = "none";
  			document.all.ctrOfcList.style.visibility = 'hidden';
  			document.all.pOfcList.style.display = "none";
  			document.all.pOfcList.style.visibility = 'hidden';
  			document.all.pOfcList2.style.display = "none";
  			document.all.pOfcList2.style.visibility = 'hidden';  			
  			if ( sheetObjects[1].RowCount < 1 ) {
  				sheetObjects[1].DataInsert(-1);
      			//sheetObjects[0].CellValue2(1, "p_rhq_bkg_ofc_cd") = formObj.p_rhq_bkg_ofc_cd.value;
  			}
  	  	} else {
  			document.all.bkgOfcList.style.display = "none";
  			document.all.bkgOfcList.style.visibility = 'hidden';
  	  	}
  	}	
	
	/**
	* Contract OFC Multi Popup
	*/	
	function bkgCofcListPopUp() {
		var formObj = document.form;
		
  	  	if (document.all.ctrOfcList.style.display == "none") {
  			document.all.ctrOfcList.style.display = "block";
  			document.all.ctrOfcList.style.visibility = 'visible';
  			
  			document.all.msvcScpCd.style.display = "none";
  			document.all.msvcScpCd.style.visibility = 'hidden';
  			document.all.bkgOfcList.style.display = "none";
  			document.all.bkgOfcList.style.visibility = 'hidden';
  			document.all.pOfcList.style.display = "none";
  			document.all.pOfcList.style.visibility = 'hidden';
  			document.all.pOfcList2.style.display = "none";
  			document.all.pOfcList2.style.visibility = 'hidden';
  			if ( sheetObjects[2].RowCount < 1 ) {
  				sheetObjects[2].DataInsert(-1);
      			//sheetObjects[0].CellValue2(1, "p_rhq_bkg_ofc_cd") = formObj.p_rhq_bkg_ofc_cd.value;
  			}
  	  	} else {
  			document.all.ctrOfcList.style.display = "none";
  			document.all.ctrOfcList.style.visibility = 'hidden';
  	  	}
  	}		

	/**
	* Correction OFC Multi Popup
	*/
	function bkgPofcListPopUp() {
		var formObj = document.form;
		
  	  	if (document.all.pOfcList.style.display == "none") {
  			document.all.pOfcList.style.display = "block";
  			document.all.pOfcList.style.visibility = 'visible';
  			
  			document.all.msvcScpCd.style.display = "none";
  			document.all.msvcScpCd.style.visibility = 'hidden';
  			document.all.bkgOfcList.style.display = "none";
  			document.all.bkgOfcList.style.visibility = 'hidden';
  			document.all.ctrOfcList.style.display = "none";
  			document.all.ctrOfcList.style.visibility = 'hidden';
  			document.all.pOfcList2.style.display = "none";
  			document.all.pOfcList2.style.visibility = 'hidden';  			
  			if ( sheetObjects[3].RowCount < 1 ) {
  				sheetObjects[3].DataInsert(-1);
      			//sheetObjects[0].CellValue2(1, "p_rhq_bkg_ofc_cd") = formObj.p_rhq_bkg_ofc_cd.value;
  			}
  	  	} else {
  			document.all.pOfcList.style.display = "none";
  			document.all.pOfcList.style.visibility = 'hidden';
  	  	}
  	}		
	/**
	 * Correction OFC Multi Popup
	 */
	function bkgPofcList2PopUp() {
		var formObj = document.form;
		
		if (document.all.pOfcList2.style.display == "none") {
			document.all.pOfcList2.style.display = "block";
			document.all.pOfcList2.style.visibility = 'visible';
			
			document.all.msvcScpCd.style.display = "none";
			document.all.msvcScpCd.style.visibility = 'hidden';
			document.all.bkgOfcList.style.display = "none";
			document.all.bkgOfcList.style.visibility = 'hidden';
			document.all.ctrOfcList.style.display = "none";
			document.all.ctrOfcList.style.visibility = 'hidden';
			document.all.pOfcList.style.display = "none";
			document.all.pOfcList.style.visibility = 'hidden';
			if ( sheetObjects[3].RowCount < 1 ) {
				sheetObjectsMap["pOfcList2sheet"].DataInsert(-1);
				//sheetObjects[0].CellValue2(1, "p_rhq_bkg_ofc_cd") = formObj.p_rhq_bkg_ofc_cd.value;
			}
		} else {
			document.all.pOfcList2.style.display = "none";
			document.all.pOfcList2.style.visibility = 'hidden';
		}
	}		


	/**
	* from,to 기간 선택 달력 띄우기
	*/
	function callDatePop(val){
		var cal = new ComCalendarFromTo();
		if (val == 'BKG_DATE'){
		cal.select(form.fr_dt,  form.to_dt,  'yyyy-MM-dd');
		}
		
	}

  	/**
  	 * Charge Code 변경에 따른 스크립트
  	 */
	function charge_cd_OnChange(comboObj,value,text){
 		var formObj = document.form;
 		if(value =='1')
 		{
 			lbDate.innerHTML="Correction Date";
 			lbOfc.innerHTML="Correction Office";
 			document.getElementById("id_lb_ofc").style.display ="inline";
 			document.getElementById("id_lb_ofc2").style.display ="none";
 			sheetObjects[4].ColHidden("bl_cnt")        = false;
 			sheetObjects[4].ColHidden("appl_ratio")     = false;
 			sheetObjects[4].ColHidden("corr_ofc_cd")    = false;
 			sheetObjects[4].ColHidden("obl_iss_ofc_cd") = true;
 			sheetObjects[4].ColHidden("clt_ofc_cd") 	= true;
 			sheetObjects[4].ColHidden("ppd_rcv_ofc_cd") = true;
 			
 		}
 		else if(value =='2')
 		{
 			lbDate.innerHTML="Surrender Date";
 			lbOfc.innerHTML="Surrender Office";
 			document.getElementById("id_lb_ofc").style.display ="inline";
 			document.getElementById("id_lb_ofc2").style.display ="none";
 			sheetObjects[4].ColHidden("bl_cnt")         = false;
 			sheetObjects[4].ColHidden("appl_ratio")     = false;
 			sheetObjects[4].ColHidden("corr_ofc_cd")    = true;
 			sheetObjects[4].ColHidden("obl_iss_ofc_cd") = true;
 			sheetObjects[4].ColHidden("clt_ofc_cd") 	= true;
 			sheetObjects[4].ColHidden("ppd_rcv_ofc_cd") = true;
 			
 		}else if(value =='3'){
 			lbDate.innerHTML="Re-Issue Date";
 			lbOfc.innerHTML="Re-Issue Office";
 			document.getElementById("id_lb_ofc").style.display ="inline";
 			document.getElementById("id_lb_ofc2").style.display ="none";
 			sheetObjects[4].ColHidden("bl_cnt")         = false;
 			sheetObjects[4].ColHidden("appl_ratio")     = false;
 			sheetObjects[4].ColHidden("corr_ofc_cd")    = true;
 			sheetObjects[4].ColHidden("obl_iss_ofc_cd") = true;
 			sheetObjects[4].ColHidden("clt_ofc_cd") 	= true;
 			sheetObjects[4].ColHidden("ppd_rcv_ofc_cd") = true;
 			
 		// 2015.02.27 	charge_cd: 4 LBP, 5 TPF, 6 CTC, 7 LSI 추가 Detail 사용안함.
 		}else if(value =='4'){ //LBP
 			SelectdIndex = 0;
 			
 			lbDate.innerHTML="BL Issue Date";
 			lbOfc.innerHTML="BL Issue Office";
 			document.getElementById("id_lb_ofc").style.display ="inline";
 			document.getElementById("id_lb_ofc2").style.display ="none";
 			sheetObjects[4].ColHidden("bl_cnt")         = true;
 			sheetObjects[4].ColHidden("appl_ratio")     = true;
 			sheetObjects[4].ColHidden("corr_ofc_cd")    = true;
 			sheetObjects[4].ColHidden("obl_iss_ofc_cd") = false;
 			sheetObjects[4].ColHidden("clt_ofc_cd") 	= true;
 			sheetObjects[4].ColHidden("ppd_rcv_ofc_cd") = true;
 		}else if(value =='5'){ //TPF
 			lbDate.innerHTML="On-board Date";
 			document.getElementById("id_lb_ofc").style.display ="inline";
 			document.getElementById("id_lb_ofc2").style.display ="inline";
 			sheetObjects[4].ColHidden("bl_cnt")         = false;
 			sheetObjects[4].ColHidden("appl_ratio")     = false;
 			sheetObjects[4].ColHidden("corr_ofc_cd")    = true;
 			sheetObjects[4].ColHidden("obl_iss_ofc_cd") = true;
 			setUiForTPF(ComGetObjValue(formObj.p_rhq_bkg_ofc_cd));
 		}else if(value =='6'){ //CTC
 			lbDate.innerHTML="On-board Date";
 			document.getElementById("id_lb_ofc").style.display ="none";
 			document.getElementById("id_lb_ofc2").style.display ="none";
 			sheetObjects[4].ColHidden("bl_cnt")         = true;
 			sheetObjects[4].ColHidden("appl_ratio")     = true;
 			sheetObjects[4].ColHidden("corr_ofc_cd")    = true;
 			sheetObjects[4].ColHidden("obl_iss_ofc_cd") = true;
 			sheetObjects[4].ColHidden("clt_ofc_cd") 	= true;
 			sheetObjects[4].ColHidden("ppd_rcv_ofc_cd") = true;
 		}else if(value =='7'){ //LSI
 			lbDate.innerHTML="On-board Date";
 			document.getElementById("id_lb_ofc").style.display ="none";
 			document.getElementById("id_lb_ofc2").style.display ="none";
 			sheetObjects[4].ColHidden("bl_cnt")         = true;
 			sheetObjects[4].ColHidden("appl_ratio")     = true;
 			sheetObjects[4].ColHidden("corr_ofc_cd")    = true;
 			sheetObjects[4].ColHidden("obl_iss_ofc_cd") = true;
 			sheetObjects[4].ColHidden("clt_ofc_cd") 	= true;
 			sheetObjects[4].ColHidden("ppd_rcv_ofc_cd") = true;
 		}
 		changeCommonEventForChageCd(value);
 	}

   function setUiForTPF(p_rhq_bkg_ofc_cd){	   
	   
		if(p_rhq_bkg_ofc_cd =="SHARC"){
			lbOfc.innerHTML="Prepaid Office";
			selOfc2.innerHTML="PPD-3rd Party Office";
			sheetObjects[4].ColHidden("clt_ofc_cd") 	= true;
			sheetObjects[4].ColHidden("ppd_rcv_ofc_cd") = false;			
		}else{
			lbOfc.innerHTML="Collect Office";
			selOfc2.innerHTML="CCT-3rd party Office";
			sheetObjects[4].ColHidden("clt_ofc_cd") 	= false;
			sheetObjects[4].ColHidden("ppd_rcv_ofc_cd") = true;			
		}
   }
	
   function changeCommonEventForChageCd(chargeCd){
	   if(chargeCd =="4" || chargeCd =="5" || chargeCd =="6" || chargeCd =="7"){
		   tabObjects[0].SelectedIndex = 0;
		   if(tabObjects[0].GetCount() == 2){
			   tabObjects[0].DeleteTab(1);
		   }
	   }else{
		   if(tabObjects[0].GetCount() == 1){
			   tabObjects[0].InsertTab(1, "Detail View", -1);
		   }
	   }
  	 
	   sheetObjectsMap["t1sheet1"].RemoveAll();
	   sheetObjectsMap["t2sheet1"].RemoveAll();
   }
   
   function p_rhq_bkg_ofc_cd_OnChange(comboObj,value,text){
	   var formObj = document.form;
		if(ComGetObjValue(formObj.charge_cd) !="5"){// 5 TPF
			return;
		}
		setUiForTPF(value);
   }
	
    // 공통으로 사용할 스크립트 소스
  	/**
  	 * sep에 해당하는 char를 제거하는 스크립트
  	 */
  	function doSepRemove(obj, sep) {
  		var ch = "";
  		var lvobj = "";
  		for(var i=0; i<obj.length; i++) {
  			if(obj.charAt(i) == sep) {
  				ch = "";
  			} else {
  				ch = obj.charAt(i);
  			}
  			lvobj = lvobj + ch;
  		}
  		return lvobj;
  	}	
  	
    /**
     * open B/L Detail
     */    
    function openDetail(){
 	   var formObj  = document.form;
 	   var sheetObj = sheetObjects[0];
 	   var chk = false;
 	  if (!validateForm(sheetObj, document.form, IBSEARCH))
			return;
 	   /*var sel_slan_cd,sel_vvd,sel_pol_cd,sel_etd_dt,sel_cost_wk,sel_ob_srep_cd,sel_cust_cd;
 	   for (var i = 1 ; i < sheetObj.LastRow ; i++){
 	   		if (sheetObj.CellValue(i,'sel') == '1'){
 	   			sel_slan_cd = sheetObj.CellValue(i,'slan_cd');
 	   			sel_vvd = sheetObj.CellValue(i,'vvd');
 	   			sel_pol_cd = sheetObj.CellValue(i,'pol_cd');
 	   			sel_etd_dt = sheetObj.CellValue(i,'etd_dt');
 	   			sel_cost_wk = sheetObj.CellValue(i,'cost_wk');
 	   			sel_ob_srep_cd = sheetObj.CellValue(i,'ob_srep_cd');
 	   			sel_cust_cd = sheetObj.CellValue(i,'cust_cd');
 	   			chk = true;
 	   			break;
 	   		}
 	   }
 	   
 	   if (!chk){
 	   		ComShowCodeMessage("BKG00249");//No Selected Row
 			return;
 	   }*/
 	   formObj.f_cmd.value = INIT;
   	   formObj.tab_cd.value = 1;
 	  
 	   var param = "";
 	   /*param += "&sel_slan_cd="+sel_slan_cd;
 	   param += "&sel_vvd="+sel_vvd;
 	   param += "&sel_pol_cd="+sel_pol_cd;
 	   param += "&sel_etd_dt="+sel_etd_dt;
 	   param += "&sel_cost_wk="+sel_cost_wk;
 	   param += "&sel_ob_srep_cd="+sel_ob_srep_cd;
 	   param += "&sel_cust_cd="+sel_cust_cd;*/
 	   param += "&"+FormQueryString(formObj);
 	   //alert("/hanjin/ESM_BKG_1083.do?f_cmd=SEARCH&"+FormQueryString(formObj));
 	   ComOpenWindowCenter("/hanjin/ESM_BKG_1175.do?"+param, "ESM_BKG_1175", 1000, 570, false);
  	   //var pWin = ComOpenWindow("/hanjin/ESM_BKG_1083.do" + param,"open1083", "statebar=no,width=1000,height=570,left=200,top=0");

    }  	
/*
// grid click Event 처리
function t1sheet1_OnClick(sheetObj,Row, Col, Value)
{
	sheetObj.CountFormat = "[ " + sheetObj.CellValue(Row, 0) + " / " + seqSheet1 + " ]";
}

// grid click Event 처리
function t2sheet1_OnClick(sheetObj,Row, Col, Value)
{
	sheetObj.CountFormat = "[ " + sheetObj.CellValue(Row, 0) + " / " + seqSheet2 + " ]";
}
 */
/* 개발자 작업 끝 */