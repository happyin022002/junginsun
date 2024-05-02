/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SAM_0002.jsp
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.05.20 박찬민
* 1.0 Creation
=========================================================
* History
* 
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
function ESM_COA_0183() {
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
var tab_no = 0;
var tab_no2 = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

var tabItem = 0;
var seqSheet1 = 0;
var seqSheet2 = 0;

var loadPageCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
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

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	
	//MultiCombo초기화 
	for ( var k = 1; k < comboObjects.length - 1; k++) {
		initCombo(comboObjects[k]);
	}
	initControl();
	var formObj = document.form;
	doActionIBCombo(sheetObjects[0], formObj, SEARCH);
}

/**
 * 콤보 초기설정값
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.UseCode = true;
	// comboObj.LineColor = "#ffffff";
	// comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
	comboObj.DropHeight = 150;
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
     var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
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
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObject); // - 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject); // - 포커스 들어갈때
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - 키보드 입력할때
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObject);
	axon_event.addListenerForm('change', 'obj_change', formObject); // change
	axon_event.addListenerFormat ('keydown', 'obj_keydown', formObject);  // Enter key 처리
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
 * OnKeyDown event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param 없음
 * @return 없음
 * @author 서미진
 * @version 2010.11.03
 */
function obj_keydown(){
    //enter key조회
    var eleName = event.srcElement.name;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1:      //t5sheet1 init (Customer RPB)
        with (sheetObj) {

        	// 높이 설정
            style.height = 400;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msAll;//msPrevColumnMerge + msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            EditableColorDiff = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 2, 100);

            

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false);
            var HeadTitle1 = "|Month|Lane|IOC|POR|DEL|Typr/Size|Cust No.|Rev.|OFT|MISC|Security";
            var headCount = ComCountHeadTitle(HeadTitle1);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            	InitDataProperty(0, cnt++,  dtHiddenStatus, 30, 	daCenter,    false,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,	80,			daCenter,	false,		"rpb_yrmon",    false,	"",      dfNone,	0,		false,		false);     
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"rlane_cd",  	false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"ioc_cd",  	false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,			daCenter,	false,		"bkg_por_cd",     false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"bkg_del_cd",     false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"cntr_tpsz_cd",     false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"rpb_cust_no",     false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"bkg_avg_rpb_rev",     false,	"",       dfFloat,	2,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"bkg_oft_avg_rpb_rev",  	false,	"",       dfFloat,	2,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"bkg_misc_avg_rpb_rev",  	false,	"",       dfFloat,	2,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"scr_chg_avg_rpb_rev",  	false,	"",       dfFloat,	2,		false,		false);
			CountPosition = 2;
        }
        break;
	
	case 2: //t1sheet1 init (Rout RPB)
		with (sheetObj) {
            // 높이 설정
            style.height = 430;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msAll;//msPrevColumnMerge + msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            EditableColorDiff = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 2, 100);

            

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false);
            var HeadTitle1 = "|Month|Lane|IOC|POR|DEL|Typr/Size|Rev.|OFT|MISC|Security";
            var headCount = ComCountHeadTitle(HeadTitle1);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            	InitDataProperty(0, cnt++,  dtHiddenStatus, 30, 	daCenter,    false,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,	80,			daCenter,	false,		"rpb_yrmon",    false,	"",      dfNone,	0,		false,		false);     
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"rlane_cd",  	false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"ioc_cd",  	false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,			daCenter,	false,		"bkg_por_cd",     false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"bkg_del_cd",     false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"cntr_tpsz_cd",     false,	"",      dfNone,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"bkg_avg_rpb_rev",     false,	"",       dfFloat,	2,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"bkg_oft_avg_rpb_rev",  	false,	"",       dfFloat,	2,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"bkg_misc_avg_rpb_rev",  	false,	"",       dfFloat,	2,		false,		false);
				InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"scr_chg_avg_rpb_rev",  	false,	"",       dfFloat,	2,		false,		false);
			CountPosition = 2;
       }
        break;

	case 3: //t2sheet1 init (SCC RPB)
		with (sheetObj) {
            // 높이 설정
            style.height = 430;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msAll;//msPrevColumnMerge + msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            EditableColorDiff = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 10, 100);           

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false);
          
            var HeadTitle1 = "|Month|POR SCC|DEL SCC|Typr/Size|Rev.|OFT|MISC|Security";
			var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  	
            InitHeadRow(0, HeadTitle1, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++,  dtHiddenStatus, 30, 	daCenter,    false,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,	80,			daCenter,	false,		"rpb_yrmon",    false,	"",      dfNone,	0,		false,		false);     
			InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"bkg_por_scc_cd",  	false,	"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"bkg_del_scc_cd",  	false,	"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	false,		"cntr_tpsz_cd",     false,	"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"bkg_avg_rpb_rev",     false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"bkg_oft_avg_rpb_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"bkg_misc_avg_rpb_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"scr_chg_avg_rpb_rev",  	false,	"",       dfFloat,	2,		false,		false);
            
//			InitDataCombo(0, 'prmry_chk_flg', "N|Y|", "N|Y|");

			CountPosition = 2;
       }
        break;
		
    case 4:      //t4sheet1 init (Lane RPB)
        with (sheetObj) {

        	// 높이 설정
            style.height = 430;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;//msPrevColumnMerge + msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            EditableColorDiff = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 10, 100);           

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false);
          
            var HeadTitle1 = "|Month|Lane|IOC|Dir|20'|20'|20'|20'|40'|40'|40'|40'";
            var HeadTitle2 = "|Month|Lane|IOC|Dir|Net Rev.|OFT|MISC|Security|Net Rev.|OFT|MISC|Security";
			var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  	
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++,  dtHiddenStatus, 30, 	daCenter,    false,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,	80,			daCenter,	true,		"rpb_yrmon",    false,	"",      dfNone,	0,		false,		false);     
			InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,		"rlane_cd",  	false,	"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,		"ioc_cd",  	false,	"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,		"dir_cd",  	false,	"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"net_20ft_avg_rev",     false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"oft_20ft_avg_rev",     false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"misc_20ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"scr_20ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"net_40ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"oft_40ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"misc_40ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"scr_40ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);

			CountPosition = 2;
         }
        break;
        

    case 5:      //t3sheet1 init (Trade RPB)
        with (sheetObj) {

        	// 높이 설정
            style.height = 430;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;//msPrevColumnMerge + msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            EditableColorDiff = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 10, 100);           

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false);
          
            var HeadTitle1 = "|Month|Dir|Trade|20'|20'|20'|20'|40'|40'|40'|40'";
            var HeadTitle2 = "|Month|Dir|Trade|Net Rev.|OFT|MISC|Security|Net Rev.|OFT|MISC|Security";
			var headCount = ComCountHeadTitle(HeadTitle1);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  	
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++,  dtHiddenStatus, 30, 	daCenter,    false,    "ibflag");
			InitDataProperty(0, cnt++ , dtData,	80,			daCenter,	true,		"rpb_yrmon",    false,	"",      dfNone,	0,		false,		false);     
			InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,		"dir_cd",  	false,	"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daCenter,	true,		"trd_cd",  	false,	"",      dfNone,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"net_20ft_avg_rev",     false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"oft_20ft_avg_rev",     false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"misc_20ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"scr_20ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"net_40ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"oft_40ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"misc_40ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);
			InitDataProperty(0, cnt++ , dtData,	80,		daRight,	false,		"scr_40ft_avg_rev",  	false,	"",       dfFloat,	2,		false,		false);

			CountPosition = 2;
         }
            break;
	}
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve": // Basic Info 조회 KeyMan Tab 선택되어 있을때는 KeyMan Info 도 같이 조회	
			if (tabItem == 0) {
				doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
			} else if (tabItem == 1){
				doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
			}else if (tabItem == 2){
				doActionIBSheet(sheetObjects[2], document.form, SEARCH02);
			}else if (tabItem == 4){
				doActionIBSheet(sheetObjects[4], document.form, SEARCH03);
			}else if (tabItem == 3){
				doActionIBSheet(sheetObjects[3], document.form, SEARCH04);
			}
			break;

		case "btn_Creation":  // Basic Info SAVE
			var strUrl = "ESM_COA_0184.do" + "?f_rpb_yrmon="+formObject.f_rpb_yrmon.value;
			ComOpenWindow(strUrl,'temp','width=300,height=210,menubar=0,status=0,scrollbars=0,resizable=0,top=200,left=400');
			break;
			
		case "btn_DownExcel":  // Main New
			if (tabItem == 0) {
				doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			} else if (tabItem == 1){
				doActionIBSheet(sheetObjects[1], document.form, IBDOWNEXCEL);
			}else if (tabItem == 2){
				doActionIBSheet(sheetObjects[2], document.form, IBDOWNEXCEL);
			}else if (tabItem == 3){
				doActionIBSheet(sheetObjects[3], document.form, IBDOWNEXCEL);
			}else if (tabItem == 4){
				doActionIBSheet(sheetObjects[4], document.form, IBDOWNEXCEL);
			}
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

 
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = true;
	switch (sAction) {

    case MULTI02:    // Address Info Save
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		formObj.f_cmd.value = MULTI02;
	 	sheetObj.RemoveEtcData();
	    sheetObj.DoSave("ESM_SAM_0002GS.do", FormQueryString(formObj));
	    doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
		break;
    
	case SEARCH01: // Address Info Retrieve
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0183GS.do", coaFormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);	
		ComOpenWait(false);
		break;
		
	case SEARCH02: // Address Info Retrieve
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0183GS.do", coaFormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);	
		ComOpenWait(false);
		break;
		
	case SEARCH03: // Address Info Retrieve
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH03;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0183GS.do", coaFormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);	
		ComOpenWait(false);
		break;
		
	case SEARCH04: // Address Info Retrieve
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH04;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0183GS.do", coaFormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);	
		ComOpenWait(false);
		break;
		
	case SEARCH05: // Address Info Retrieve
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH05;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0183GS.do", coaFormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);	
		ComOpenWait(false);
		break;
		
	case IBDOWNEXCEL:        //엑셀 다운로드
        var excelType = selectDownExcelMethod(sheetObj);
		switch (excelType) {
			case "AY":
                sheetObj.Down2Excel(0, false, false, true);
                break;
			case "DY":
                sheetObj.Down2Excel(-1, false, false, true);
                break;
			case "AN":
                sheetObj.SpeedDown2Excel(0, false, false);
                break;
			case "DN":
                sheetObj.SpeedDown2Excel(-1, false, false);
                break;
        }
		
        break;
		
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	if(formObj.f_rpb_yrmon.value==""){
		ComShowCodeMessage('COA10009','Date','YYYY-MM');
		return false;
	}
	switch (sAction) {
	
	
		 case SEARCH01: // Address Info Save
			 
	         if (formObj.f_rlane_cd.Text == "" || formObj.f_rlane_cd.Text == "All") {
	        	 ComShowCodeMessage('COA10026','Lane');
	        	 return false;
	         }
			 break;
			 
		 case SEARCH05: // Address Info Save
			 
	         if (formObj.f_rlane_cd.Text == "" || formObj.f_rlane_cd.Text == "All") {
	        	 ComShowCodeMessage('COA10026','Lane');
	        	 return false;
	         }
			 break;
	}
		return true;
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

            var cnt  = 0 ;
            InsertTab( cnt++ , "Customer RPB" , -1 );
            InsertTab( cnt++ , "Route RPB" , -1 );
            InsertTab( cnt++ , "SCC RPB" , -1 );
            InsertTab( cnt++ , "Lane RPB" , -1 );
            InsertTab( cnt++ , "Trade RPB" , -1 ); 
		}
		
			 f_trd_cd.style.display ="none";
			 f_rlane_cd.style.display ="";
			 f_ioc_cd.style.display ="";
			 f_bkg_por_cd.style.display ="";
			 f_bkg_del_cd.style.display ="";
			 f_bkg_por_scc_cd.style.display ="none";
			 f_bkg_del_scc_cd.style.display ="none";
			 f_dir_cd.style.display ="none";
		break;

	}
}

/**
 * Tab 변경시 이벤트 관련
 * 선택한 탭의 정보를 조회.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	tabItem = nItem;

	document.form.tab_item.value = tabItem;
	
	var formObject = document.form;

		if(tabItem == 1){
			 f_trd_cd.style.display ="none";
			 f_rlane_cd.style.display ="";
			 f_ioc_cd.style.display ="";
			 f_bkg_por_cd.style.display ="";
			 f_bkg_del_cd.style.display ="";
			 f_bkg_por_scc_cd.style.display ="none";
			 f_bkg_del_scc_cd.style.display ="none";
			 f_dir_cd.style.display ="none";
			 f_cntr_tpsz_cd.style.display ="";
			 document.form.f_rlane_cd.SetText('All',0,'') ;
			 document.form.f_rlane_cd.BackColor="#CCFFFD";
			 
		}else if(tabItem == 2){
			 f_trd_cd.style.display ="none";
			 f_rlane_cd.style.display ="none";
			 f_ioc_cd.style.display ="none";
			 f_bkg_por_cd.style.display ="none";
			 f_bkg_del_cd.style.display ="none";
			 f_bkg_por_scc_cd.style.display ="";
			 f_bkg_del_scc_cd.style.display ="";
			 f_dir_cd.style.display ="none";
			 f_cntr_tpsz_cd.style.display ="";
		}else if(tabItem == 4){
			 f_trd_cd.style.display ="";
			 f_rlane_cd.style.display ="none";
			 f_ioc_cd.style.display ="none";
			 f_bkg_por_cd.style.display ="none";
			 f_bkg_del_cd.style.display ="none";
			 f_bkg_por_scc_cd.style.display ="none";
			 f_bkg_del_scc_cd.style.display ="none";
			 f_dir_cd.style.display ="";
			 f_cntr_tpsz_cd.style.display ="none";
		}else if(tabItem == 3){
			 f_trd_cd.style.display ="none";
			 f_rlane_cd.style.display ="";
			 f_ioc_cd.style.display ="";
			 f_bkg_por_cd.style.display ="none";
			 f_bkg_del_cd.style.display ="none";
			 f_bkg_por_scc_cd.style.display ="none";
			 f_bkg_del_scc_cd.style.display ="none";
			 f_dir_cd.style.display ="";
			 f_cntr_tpsz_cd.style.display ="none";
			 document.form.f_rlane_cd.SetText('All',0,'All') ;
			 document.form.f_rlane_cd.BackColor="white";
		}else if(tabItem == 0){
			 f_trd_cd.style.display ="none";
			 f_rlane_cd.style.display ="";
			 f_ioc_cd.style.display ="";
			 f_bkg_por_cd.style.display ="";
			 f_bkg_del_cd.style.display ="";
			 f_bkg_por_scc_cd.style.display ="none";
			 f_bkg_del_scc_cd.style.display ="none";
			 f_dir_cd.style.display ="none";
			 f_cntr_tpsz_cd.style.display ="";
			 document.form.f_rlane_cd.BackColor="#CCFFFD";
			 document.form.f_rlane_cd.SetText('All',0,'') ;
		}

		

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	
	
    if(loadPageCnt == 0) return;
    
    //document.getElementById("btn_Retrieve").fireEvent("onclick");
}


  /**
   * 모든 콤보 박스 조회
   * 공통 부분 완성되면 추가 작업 요
   */
 	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
    
 		switch (sAction) {
 		 
 			case SEARCH: // load page 시
 				formObj.f_cmd.value = COMMAND01;
 				var sXml = sheetObj.GetSearchXml("ESM_COA_0183GS.do", coaFormQueryString(formObj));
 				var rtnValue = sXml.split("|$$|");
 	     		
 	     		for(var i=0; i<rtnValue.length; i++){
 					if(i == 0){
 						ComXml2ComboItem(rtnValue[i], formObj.f_trd_cd, "code", "name");
 						formObj.f_trd_cd.index2=0;
 					}else if(i == 1){
 						ComXml2ComboItem(rtnValue[i], formObj.f_rlane_cd, "code", "name");
 						document.form.f_rlane_cd.SetText('All',0,'') ;
 						formObj.f_rlane_cd.index2=0;
 					}else if(i == 2){
 						ComXml2ComboItem(rtnValue[i], formObj.f_ioc_cd, "code", "name");
 						formObj.f_ioc_cd.index2=0;
 					}else if(i == 3){
 						ComXml2ComboItem(rtnValue[i], formObj.f_dir_cd, "code", "name");
 						formObj.f_dir_cd.index2=0;
 					}else if(i == 4){
 						ComXml2ComboItem(rtnValue[i], formObj.f_cntr_tpsz_cd, "code", "name");
 						formObj.f_cntr_tpsz_cd.index2=0;
 					}
 	     		}
			   break;
 		}
 	}
   
   
   function setPeriod(obj){
 		
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];

 		if(obj == null){
           return;
       }
 		
 		if(obj.value == ""){
           if(obj.name == "f_rpb_yrmon" ){
               formObj.f_rpb_yrmon.value = "";
           } 
           document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
           return false;
       } else {
           if(!ComIsDate(formObj.f_rpb_yrmon , "ym")){
           	document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
           	return false;	
           }
       }
 		
 		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("ESM_COA_0183GS.do", coaFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");

		if (0<arrXml.length) {
			document.getElementById("div_period").innerHTML = "( "+ComGetEtcData(arrXml[0], "period") +" )";
		}
		
		if (ComGetEtcData(arrXml[0], "period") == ""){
			document.getElementById("div_period").innerHTML = "( YYYY-WK ~ YYYY-WK )";
		}
	}

   
/* 개발자 작업 끝 */