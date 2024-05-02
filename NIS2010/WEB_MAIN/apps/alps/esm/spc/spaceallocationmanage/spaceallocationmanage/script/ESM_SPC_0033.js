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
	sheet2.style.display ="none";
	SpcSearchOptionTrade("f_trade", true,true);
	SpcSearchOptionSubTrade("f_sub_trade", true, true);
	SpcSearchOptionLane("f_lane", true, false);
	SpcSearchOptionBound("f_bound",false,true,false,true);
	initSheetCombo();
//	doActionIBCombo(sheetObjects[0], formObj, SEARCH);
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
            MergeSheet = msHeaderOnly;//msPrevColumnMerge + msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;
            EditableColorDiff = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(2, 1, 9, 100);

            

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false);
            var HeadTitle1 = "STS|Del|Rep.Trade|Sub Trade|Lane|Bound|Effect Date|Effect Date|BSA|HC|HC|HC|HC|45FT|45FT|45FT|45FT";
			var HeadTitle2 = "STS|Del|Rep.Trade|Sub Trade|Lane|Bound|From|To|BSA|Calculation\n(TEU)|Sub-alloc\n(box)|Apply Sub-alloc|Calculation2\n(Over Sub-alloc/TEU)|Calculation\n(TEU)|Sub-alloc\n(box)|Apply Sub-alloc|Calculation2\n(Over Sub-alloc/TEU)";
            var headCount = ComCountHeadTitle(HeadTitle1);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++,  dtStatus,   	30,    daCenter,   true,    "ibflag",     	 	false,      "",       dfNone,   	   0,       true,       true);
            InitDataProperty(0, cnt++,  dtDelCheck,   	30,    daCenter,   true,    "",     	 	false,      "",       dfNone,   	   0,       true,       true);
            InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "rep_trd_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "sub_trd_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "rlane_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  70,   daCenter,  true ,     "dir_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "eff_fm_dt"           ,     true,         "",    dfDateYmd   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "eff_to_dt"           ,     true,         "",    dfDateYmd   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daRight,  true ,     "bsa_capa"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_hc_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_hc_bzc_bx_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtCombo  ,  100,   daCenter,  true ,     "aloc_hc_aply_flg"           ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  140,   daRight,  true ,     "aloc_hc_ovr_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_45ft_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_45ft_bzc_bx_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtCombo  ,  100,   daCenter,  true ,     "aloc_45ft_aply_flg"           ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  140,   daRight,  true ,     "aloc_45ft_ovr_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			CountPosition = 2;
			ImageList(0) = "img/btns_calendar.gif";
			PopupButtonImage(0, "eff_fm_dt") = 0;
			PopupButtonImage(0, "eff_to_dt") = 0;
			InitDataCombo(0, "aloc_hc_aply_flg", "N|Y", "N|Y");
			InitDataCombo(0, "aloc_45ft_aply_flg", "N|Y", "N|Y");
			InitDataValid(0, 2, vtEngUpOther,"0123456789");
			InitDataValid(0, 3, vtEngUpOther,"0123456789");
			InitDataValid(0, 4, vtEngUpOther,"0123456789");
			InitDataValid(0, 5, vtEngUpOther);
        }
        break;
	
	case 2: //t1sheet1 init (Rout RPB)
		with (sheetObj) {
			// 높이 설정
            style.height = 400;
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
            InitRowInfo(2, 1, 9, 100);

            

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false);
            var HeadTitle1 = "STS|Del|Rep.Trade|Sub Trade|Lane|Bound|Effect Date|Effect Date|Port|BSA|HC|HC|HC|HC|45FT|45FT|45FT|45FT";
			var HeadTitle2 = "STS|Del|Rep.Trade|Sub Trade|Lane|Bound|From|To|Port|BSA|Calculation\n(TEU)|Sub-alloc\n(box)|Apply Sub-alloc|Calculation2\n(Over Sub-alloc/TEU)|Calculation\n(TEU)|Sub-alloc\n(box)|Apply Sub-alloc|Calculation2\n(Over Sub-alloc/TEU)";
            var headCount = ComCountHeadTitle(HeadTitle1);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtStatus,   	30,    daCenter,   true,    "ibflag",     	 	false,      "",       dfNone,   	   0,       true,       true);
            InitDataProperty(0, cnt++,  dtDelCheck,   	30,    daCenter,   true,    "",     	 	false,      "",       dfNone,   	   0,       true,       true);
            InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "rep_trd_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "sub_trd_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "rlane_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  70,   daCenter,  true ,     "dir_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "eff_fm_dt"           ,     true,         "",    dfDateYmd   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "eff_to_dt"           ,     true,         "",    dfDateYmd   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "pol_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daRight,  true ,     "bsa_capa"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_hc_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_hc_bzc_bx_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtCombo  ,  100,   daCenter,  true ,     "aloc_hc_aply_flg"           ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  140,   daRight,  true ,     "aloc_hc_ovr_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_45ft_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_45ft_bzc_bx_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtCombo  ,  100,   daCenter,  true ,     "aloc_45ft_aply_flg"           ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  140,   daRight,  true ,     "aloc_45ft_ovr_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			CountPosition = 2;
			ImageList(0) = "img/btns_calendar.gif";
			PopupButtonImage(0, "eff_fm_dt") = 0;
			PopupButtonImage(0, "eff_to_dt") = 0;
			InitDataCombo(0, "aloc_hc_aply_flg", "N|Y", "N|Y");
			InitDataCombo(0, "aloc_45ft_aply_flg", "N|Y", "N|Y");
			InitDataValid(0, 2, vtEngUpOther,"0123456789");
			InitDataValid(0, 3, vtEngUpOther,"0123456789");
			InitDataValid(0, 4, vtEngUpOther,"0123456789");
			InitDataValid(0, 5, vtEngUpOther);
			InitDataValid(0, 8, vtEngUpOther,"0123456789");
       }
        break;

	case 3: //t2sheet1 init (SCC RPB)
		with (sheetObj) {
			// 높이 설정
            style.height = 400;
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
            InitRowInfo(2, 1, 9, 100);

            

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false);
            var HeadTitle1 = "STS|Del|Rep.Trade|Sub Trade|Lane|VVD|Bound|Effect Date|Effect Date|BSA|HC|HC|HC|HC|45FT|45FT|45FT|45FT";
			var HeadTitle2 = "STS|Del|Rep.Trade|Sub Trade|Lane|VVD|Bound|From|To|BSA|Calculation\n(TEU)|Sub-alloc\n(box)|Apply Sub-alloc|Calculation2\n(Over Sub-alloc/TEU)|Calculation\n(TEU)|Sub-alloc\n(box)|Apply Sub-alloc|Calculation2\n(Over Sub-alloc/TEU)";
            var headCount = ComCountHeadTitle(HeadTitle1);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtStatus,   	30,    daCenter,   true,    "ibflag",     	 	false,      "",       dfNone,   	   0,       true,       true);
            InitDataProperty(0, cnt++,  dtDelCheck,   	30,    daCenter,   true,    "",     	 	false,      "",       dfNone,   	   0,       true,       true);
            InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "rep_trd_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "sub_trd_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "rlane_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  80,   daCenter,  true ,     "vvd"           ,     true,         "",   dfNone   ,      0,     false,       true,          9, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  70,   daCenter,  true ,     "dir_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "eff_fm_dt"           ,     true,         "",    dfDateYmd   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "eff_to_dt"           ,     true,         "",    dfDateYmd   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daRight,  true ,     "bsa_capa"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_hc_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_hc_bzc_bx_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtCombo  ,  100,   daCenter,  true ,     "aloc_hc_aply_flg"           ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  140,   daRight,  true ,     "aloc_hc_ovr_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_45ft_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_45ft_bzc_bx_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtCombo  ,  100,   daCenter,  true ,     "aloc_45ft_aply_flg"           ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  140,   daRight,  true ,     "aloc_45ft_ovr_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			CountPosition = 2;
			ImageList(0) = "img/btns_calendar.gif";
			PopupButtonImage(0, "eff_fm_dt") = 0;
			PopupButtonImage(0, "eff_to_dt") = 0;
			InitDataCombo(0, "aloc_hc_aply_flg", "N|Y", "N|Y");
			InitDataCombo(0, "aloc_45ft_aply_flg", "N|Y", "N|Y");
			InitDataValid(0, 2, vtEngUpOther,"0123456789");
			InitDataValid(0, 3, vtEngUpOther,"0123456789");
			InitDataValid(0, 4, vtEngUpOther,"0123456789");
			InitDataValid(0, 5, vtEngUpOther,"0123456789");
			InitDataValid(0, 6, vtEngUpOther);
       }
        break;
		
    case 4:      //t4sheet1 init (Lane RPB)
        with (sheetObj) {

        	// 높이 설정
            style.height = 400;
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
            InitRowInfo(2, 1, 9, 100);

            

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, false, true, false,false);
            var HeadTitle1 = "STS|Del|Rep.Trade|Sub Trade|Lane|VVD|Bound|Effect Date|Effect Date|Port|BSA|HC|HC|HC|HC|45FT|45FT|45FT|45FT";
			var HeadTitle2 = "STS|Del|Rep.Trade|Sub Trade|Lane|VVD|Bound|From|To|Port|BSA|Calculation\n(TEU)|Sub-alloc\n(box)|Apply Sub-alloc|Calculation2\n(Over Sub-alloc/TEU)|Calculation\n(TEU)|Sub-alloc\n(box)|Apply Sub-alloc|Calculation2\n(Over Sub-alloc/TEU)";
            var headCount = ComCountHeadTitle(HeadTitle1);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 0, 0, true);
            
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle1, true);
            InitHeadRow(1, HeadTitle2, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtStatus,   	30,    daCenter,   true,    "ibflag",     	 	false,      "",       dfNone,   	   0,       true,       true);
            InitDataProperty(0, cnt++,  dtDelCheck,   	30,    daCenter,   true,    "",     	 	false,      "",       dfNone,   	   0,       true,       true);
            InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "rep_trd_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "sub_trd_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daCenter,  true ,     "rlane_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  80,   daCenter,  true ,     "vvd"           ,     true,         "",   dfNone   ,      0,     false,       true,          9, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  70,   daCenter,  true ,     "dir_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "eff_fm_dt"           ,     true,         "",    dfDateYmd   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "eff_to_dt"           ,     true,         "",    dfDateYmd   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtPopupEdit  ,  80,   daCenter,  true ,     "pol_cd"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtComboEdit  ,  80,   daRight,  true ,     "bsa_capa"           ,     true,         "",   dfNone   ,      0,     false,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_hc_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_hc_bzc_bx_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtCombo  ,  100,   daCenter,  true ,     "aloc_hc_aply_flg"           ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  140,   daRight,  true ,     "aloc_hc_ovr_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_45ft_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  100,   daRight,  true ,     "aloc_45ft_bzc_bx_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtCombo  ,  100,   daCenter,  true ,     "aloc_45ft_aply_flg"           ,     false,         "",   dfNone   ,      0,     true,       true,          30, 	false, 		false);
			InitDataProperty(0, cnt++ , dtData  ,  140,   daRight,  true ,     "aloc_45ft_ovr_calc_qty"           ,     false,         "",    dfFloat   ,      2,     true,       true,          30, 	false, 		false);
			CountPosition = 2;
			ImageList(0) = "img/btns_calendar.gif";
			PopupButtonImage(0, "eff_fm_dt") = 0;
			PopupButtonImage(0, "eff_to_dt") = 0;
			InitDataCombo(0, "aloc_hc_aply_flg", "N|Y", "N|Y");
			InitDataCombo(0, "aloc_45ft_aply_flg", "N|Y", "N|Y");
			InitDataValid(0, 2, vtEngUpOther,"0123456789");
			InitDataValid(0, 3, vtEngUpOther,"0123456789");
			InitDataValid(0, 4, vtEngUpOther,"0123456789");
			InitDataValid(0, 5, vtEngUpOther,"0123456789");
			InitDataValid(0, 6, vtEngUpOther);
			InitDataValid(0, 9, vtEngUpOther,"0123456789");
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
		
		case "btn_RowAdd":
			
			if(tabItem=="0" && document.form.f_pendulum.checked==false){
				var insertRow = sheetObjects[0].DataInsert();
				sheetObjects[0].InitCellProperty(insertRow, "bsa_capa", dtCombo);
	 		}else if(tabItem=="0" && document.form.f_pendulum.checked==true){
	 			var insertRow = sheetObjects[1].DataInsert();
				sheetObjects[1].InitCellProperty(insertRow, "bsa_capa", dtCombo);
	 		}else if(tabItem=="1" && document.form.f_pendulum.checked==false){
	 			var insertRow = sheetObjects[2].DataInsert();
				sheetObjects[2].InitCellProperty(insertRow, "bsa_capa", dtCombo);
	 		}else if(tabItem=="1" && document.form.f_pendulum.checked==true){
	 			var insertRow = sheetObjects[3].DataInsert();
				sheetObjects[3].InitCellProperty(insertRow, "bsa_capa", dtCombo);
	 		}

		break;
		
		case "btn_Retrieve": // Basic Info 조회 KeyMan Tab 선택되어 있을때는 KeyMan Info 도 같이 조회	
			if (tabItem == 0 && document.form.f_pendulum.checked==false) {
				doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			}else if(tabItem=="0" && document.form.f_pendulum.checked==true){
				doActionIBSheet(sheetObjects[1], document.form, SEARCH02);
	 		}else if(tabItem=="1" && document.form.f_pendulum.checked==false){
	 			doActionIBSheet(sheetObjects[2], document.form, SEARCH03);
	 		}else if(tabItem=="1" && document.form.f_pendulum.checked==true){
	 			doActionIBSheet(sheetObjects[3], document.form, SEARCH04);
	 		}
			break;
			
		case "btn_Save": // Basic Info 조회 KeyMan Tab 선택되어 있을때는 KeyMan Info 도 같이 조회	
			if (tabItem == 0 && document.form.f_pendulum.checked==false) {
				doActionIBSheet(sheetObjects[0], document.form, MULTI01);
			}else if(tabItem=="0" && document.form.f_pendulum.checked==true){
				doActionIBSheet(sheetObjects[1], document.form, MULTI02);
	 		}else if(tabItem=="1" && document.form.f_pendulum.checked==false){
	 			doActionIBSheet(sheetObjects[2], document.form, MULTI03);
	 		}else if(tabItem=="1" && document.form.f_pendulum.checked==true){
	 			doActionIBSheet(sheetObjects[3], document.form, MULTI04);
	 		}
			break;

		case "btn_DownExcel":  // Main New
			if (tabItem == 0 && document.form.f_pendulum.checked==false) {
				doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
			}else if(tabItem=="0" && document.form.f_pendulum.checked==true){
				doActionIBSheet(sheetObjects[1], document.form, IBDOWNEXCEL);
	 		}else if(tabItem=="1" && document.form.f_pendulum.checked==false){
	 			doActionIBSheet(sheetObjects[2], document.form, IBDOWNEXCEL);
	 		}else if(tabItem=="1" && document.form.f_pendulum.checked==true){
	 			doActionIBSheet(sheetObjects[3], document.form, IBDOWNEXCEL);
	 		}
			break;
			
		case "btn_New": // Basic Info 조회 KeyMan Tab 선택되어 있을때는 KeyMan Info 도 같이 조회	
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
	 			sheetObjects[2].RemoveAll();
	 			sheetObjects[3].RemoveAll();
	 			SpcSearchOptionTrade("f_trade", true,true);
	 			SpcSearchOptionSubTrade("f_sub_trade", true, true);
	 			SpcSearchOptionLane("f_lane", true, false);
	 			document.form.f_bound.selectedIndex = 0;
	 			document.form.f_pendulum.checked = false;
	 			tabObjects[0].SelectedIndex = 0;
	 			sheet1.style.display ="";
	 			sheet2.style.display ="none";
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

	case SEARCH01: // Address Info Retrieve
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0033GS.do", FormQueryString(formObj));
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
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0033GS.do", FormQueryString(formObj));
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
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0033GS.do", FormQueryString(formObj));
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
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0033GS.do", FormQueryString(formObj));
		sheetObj.LoadSearchXml(sXml);	
		ComOpenWait(false);
		break;
		
	case MULTI01:    // Address Info Save
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		formObj.f_cmd.value = MULTI01;
	 	sheetObj.RemoveEtcData();
	    sheetObj.DoSave("ESM_SPC_0033GS.do", FormQueryString(formObj));
	    doActionIBSheet(sheetObj, formObj, SEARCH01);
		break;
		
	case MULTI02:    // Address Info Save
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		formObj.f_cmd.value = MULTI02;
	 	sheetObj.RemoveEtcData();
	    sheetObj.DoSave("ESM_SPC_0033GS.do", FormQueryString(formObj));
	    doActionIBSheet(sheetObj, formObj, SEARCH02);
		break;
		
	case MULTI03:    // Address Info Save
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		formObj.f_cmd.value = MULTI03;
	 	sheetObj.RemoveEtcData();
	    sheetObj.DoSave("ESM_SPC_0033GS.do", FormQueryString(formObj));
	    doActionIBSheet(sheetObj, formObj, SEARCH03);
		break;
		
	case MULTI04:    // Address Info Save
		if (!validateForm(sheetObj,document.form,sAction)) {
			return false;
		}
		formObj.f_cmd.value = MULTI04;
	 	sheetObj.RemoveEtcData();
	    sheetObj.DoSave("ESM_SPC_0033GS.do", FormQueryString(formObj));
	    doActionIBSheet(sheetObj, formObj, SEARCH04);
		break;
		
	case IBDOWNEXCEL:        //엑셀 다운로드
		sheetObj.Down2Excel(-1, false, false, true);
		
        break;
		
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
//	if(formObj.f_rpb_yrmon.value==""){
//		ComShowCodeMessage('COA10009','Date','YYYY-MM');
//		return false;
//	}
	switch (sAction) {
	
	
		 case SEARCH01: // Address Info Save
			 
//	         if (formObj.f_rlane_cd.Text == "" || formObj.f_rlane_cd.Text == "All") {
//	        	 ComShowCodeMessage('COA10026','Lane');
//	        	 return false;
//	         }
			 break;
			 
		 case SEARCH05: // Address Info Save
			 
//	         if (formObj.f_rlane_cd.Text == "" || formObj.f_rlane_cd.Text == "All") {
//	        	 ComShowCodeMessage('COA10026','Lane');
//	        	 return false;
//	         }
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
            InsertTab( cnt++ , "By Lane" , -1 );
            InsertTab( cnt++ , "By VVD" , -1 );
		}
		
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
	sheetControl();
		if(tabItem == 1){
			 
		}else if(tabItem == 2){
			
		}else if(tabItem == 4){
			
		}else if(tabItem == 3){
			
		}else if(tabItem == 0){
			
		}

		

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
	
	
    if(loadPageCnt == 0) return;
    
    //document.getElementById("btn_Retrieve").fireEvent("onclick");
}

 	function sheetControl(){
 		if(document.form.tab_item.value=="0" && document.form.f_pendulum.checked==false){
 			sheet1.style.display ="";
 			sheet2.style.display ="none";
 		}else if(document.form.tab_item.value=="0" && document.form.f_pendulum.checked==true){
 			sheet1.style.display ="none";
 			sheet2.style.display ="";
 		}else if(document.form.tab_item.value=="1" && document.form.f_pendulum.checked==false){
 			sheet3.style.display ="";
 			sheet4.style.display ="none";
 		}else if(document.form.tab_item.value=="1" && document.form.f_pendulum.checked==true){
 			sheet3.style.display ="none";
 			sheet4.style.display ="";
 		}
 	}
   
 	/*
	 *  trade변경시
	 */
    function f_trade_OnChange(comObj,value,text ){
    	//sub_trade의 초기화
    	document.form.f_sub_trade.index2 = 0; 
    	//lane의 초기화
    	document.form.f_lane.index2 = 0;   
    	SpcSearchOptionSubTrade("f_sub_trade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("f_lane",true,false,'',value,'',true);			// 0207 SHKIM
    }
    
    function f_sub_trade_OnChange(comObj,value,text ){
    	SpcSearchOptionLane("f_lane",true,false,'',document.form.f_trade.Code,value,true);	// 0207 SHKIM    	
    	if(value == "") return;

    	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		document.form.f_trade.Code2 = arrTrade[0];
    		document.form.f_lane.Code2 = '';
    	} else {
    		document.form.f_trade.Code2 = comObj.GetText(value,0);  
    		document.form.f_lane.Code2 = '';
    	}  
    }
    
    function initSheetCombo() {
    	initSheetCombo_trade();
    	initSheetCombo_subtrade();
    	initSheetCombo_lane();
    	initSheetCombo_bound();
    }
    
    function initSheetCombo_trade() {
        
        var rtn = getCodeXmlList("TradeCombo", "isRepTrade=false&del=");
        
        var arrData = ComXml2ComboString(rtn, "trd_cd", "trd_nm");
        
        if (arrData != null){
            var arrCode = arrData[0].split("|");
            var arrName = arrData[1].split("|");
            var conData = "";
            for(i=0; i < arrName.length;i++){
                if(i==0){
                    arrName[i] = arrCode[i]+"\t"+arrName[i];
                }else{
                    arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
                }
                conData = conData.concat(arrName[i]);
            }
            arrData[1] = conData;
        }
        arrData[0] = " |" + arrData[0];
        arrData[1] = " |" + arrData[1];
        
        sheetObjects[0].InitDataCombo(0, "rep_trd_cd", arrData[1], arrData[0]);
        sheetObjects[1].InitDataCombo(0, "rep_trd_cd", arrData[1], arrData[0]);
        sheetObjects[2].InitDataCombo(0, "rep_trd_cd", arrData[1], arrData[0]);
        sheetObjects[3].InitDataCombo(0, "rep_trd_cd", arrData[1], arrData[0]);
	}
    	
	function initSheetCombo_subtrade() {
        
        var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true");
        
        var arrData = SpcXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
        
        arrData[0] = " |" + arrData[0];
        arrData[1] = "\t\t|" + arrData[1];
        
        sheetObjects[0].InitDataCombo(0, "sub_trd_cd", arrData[1], arrData[0], "", "", 1);
        sheetObjects[1].InitDataCombo(0, "sub_trd_cd", arrData[1], arrData[0], "", "", 1);
        sheetObjects[2].InitDataCombo(0, "sub_trd_cd", arrData[1], arrData[0], "", "", 1);
        sheetObjects[3].InitDataCombo(0, "sub_trd_cd", arrData[1], arrData[0], "", "", 1);
	}
    	
	function initSheetCombo_lane() {
        
        var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=");
        
        var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
        
        arrData[0] = " |" + arrData[0];
        arrData[1] = "\t\t\t|" + arrData[1];
        
        sheetObjects[0].InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
        sheetObjects[1].InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
        sheetObjects[2].InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
        sheetObjects[3].InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
	}
    	
	function initSheetCombo_bound() {
        
        var bound = " |E|W|S|N";
        
        sheetObjects[0].InitDataCombo(0, "dir_cd", bound, bound);
        sheetObjects[1].InitDataCombo(0, "dir_cd", bound, bound);
        sheetObjects[2].InitDataCombo(0, "dir_cd", bound, bound);
        sheetObjects[3].InitDataCombo(0, "dir_cd", bound, bound);
	}
	
	function t1sheet1_OnPopupClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "eff_fm_dt" :
			    var cal = new ComCalendarGrid();
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
			    
	       	case "eff_to_dt" :
			    var cal = new ComCalendarGrid();
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
		}
	}
   
	function t1sheet2_OnPopupClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "eff_fm_dt" :
			    var cal = new ComCalendarGrid();
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
			    
	       	case "eff_to_dt" :
			    var cal = new ComCalendarGrid();
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
			    
	    	case "pol_cd" :
	       		var pol_cd = sheetObj.CellValue(row, col);
	       		spcPopup("POL", "tt_pol_cd="+pol_cd+"", 770, 470, "setSheet1PopUpValue", "1,0,1,1,1,1,1,1", row, col);
	       		break;
		}
	}
	
	function t2sheet1_OnPopupClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "eff_fm_dt" :
			    var cal = new ComCalendarGrid();
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
			    
	       	case "eff_to_dt" :
			    var cal = new ComCalendarGrid();
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
		}
	}
	
	function t2sheet2_OnPopupClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "eff_fm_dt" :
			    var cal = new ComCalendarGrid();
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
			    
	       	case "eff_to_dt" :
			    var cal = new ComCalendarGrid();
			    cal.select(sheetObj, row, col, 'yyyy-MM-dd');
			    break;
			    
	    	case "pol_cd" :
	       		var pol_cd = sheetObj.CellValue(row, col);
	       		spcPopup("POL", "tt_pol_cd="+pol_cd+"", 770, 470, "setSheet3PopUpValue", "1,0,1,1,1,1,1,1", row, col);
	       		break;
		}
	}
	
	function t1sheet1_OnClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "bsa_capa" :
	       		if(sheetObj.CellValue(row,"ibflag")=="I"){
	       			if(sheetObj.CellValue(row,"rep_trd_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"sub_trd_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"rlane_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"dir_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"eff_fm_dt")!="" &&
	     	       	   sheetObj.CellValue(row,"eff_to_dt")!=""){
	       				document.form.f_cmd.value = COMMAND01;
	     	 			var sParam = "f_cmd="    +document.form.f_cmd.value
	     					            + "&rep_trd_cd=" + sheetObj.CellValue(row,"rep_trd_cd")
	     					            + "&sub_trd_cd=" + sheetObj.CellValue(row,"sub_trd_cd")
	     					            + "&rlane_cd=" + sheetObj.CellValue(row,"rlane_cd")
	     					            + "&dir_cd=" + sheetObj.CellValue(row,"dir_cd")
	     					            + "&eff_fm_dt=" + sheetObj.CellValue(row,"eff_fm_dt")
	     					            + "&eff_to_dt=" + sheetObj.CellValue(row,"eff_to_dt")
	     					            ;
	     	 			sheetObjects[0].CellComboItem(row, "bsa_capa", " |" + "", " |" + "");
	     	 			
	     	 			var sXml = sheetObjects[0].GetSearchXml("ESM_SPC_0033GS.do", sParam);
	     	 			var rtnValue = sXml.split("|$$|");
	     	 			
	     	 			var rtnArr = ComXml2ComboString(rtnValue,"code","name");
	     	 			if(rtnArr != undefined){
	     	 				sheetObjects[0].CellComboItem(row, "bsa_capa", " |" + rtnArr[0], " |" + rtnArr[0]);
	     	 			}else{
	     	 				ComShowMessage(ComGetMsg('COM130401')+'(BSA Capa)');
	     	 			}
	       			}else{
	       				ComShowMessage(ComGetMsg('COM130403','Rep.Trade, Sub Trade, Lane, Bound, Effect Date'));	
	       			}
	       		}
	       					    break;
		}
	}
	

	function t1sheet2_OnClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "bsa_capa" :
	       		if(sheetObj.CellValue(row,"ibflag")=="I"){
	       			if(sheetObj.CellValue(row,"rep_trd_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"sub_trd_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"rlane_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"dir_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"eff_fm_dt")!="" &&
	     	       	   sheetObj.CellValue(row,"eff_to_dt")!="" &&
	     	       	   sheetObj.CellValue(row,"pol_cd")!=""){
	       				document.form.f_cmd.value = COMMAND02;
	     	 			var sParam = "f_cmd="    +document.form.f_cmd.value
	     					            + "&rep_trd_cd=" + sheetObj.CellValue(row,"rep_trd_cd")
	     					            + "&sub_trd_cd=" + sheetObj.CellValue(row,"sub_trd_cd")
	     					            + "&rlane_cd=" + sheetObj.CellValue(row,"rlane_cd")
	     					            + "&dir_cd=" + sheetObj.CellValue(row,"dir_cd")
	     					            + "&eff_fm_dt=" + sheetObj.CellValue(row,"eff_fm_dt")
	     					            + "&eff_to_dt=" + sheetObj.CellValue(row,"eff_to_dt")
	     					            + "&pol_cd=" + sheetObj.CellValue(row,"pol_cd")
	     					            ;
	     	 			sheetObj.CellComboItem(row, "bsa_capa", " |" + "", " |" + "");
	     	 			
	     	 			var sXml = sheetObj.GetSearchXml("ESM_SPC_0033GS.do", sParam);
	     	 			var rtnValue = sXml.split("|$$|");
	     	 			
	     	 			var rtnArr = ComXml2ComboString(rtnValue,"code","name");
	     	 			if(rtnArr != undefined){
	     	 				sheetObj.CellComboItem(row, "bsa_capa", " |" + rtnArr[0], " |" + rtnArr[0]);
	     	 			}else{
	     	 				ComShowMessage(ComGetMsg('COM130401')+'(BSA Capa)');
	     	 			}
	       			}else{
	       				ComShowMessage(ComGetMsg('COM130403','Rep.Trade, Sub Trade, Lane, Bound, Effect Date, Port'));	
	       			}
	       		}
	       					    break;
		}
	}
	
	function t2sheet1_OnClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "bsa_capa" :
	       		if(sheetObj.CellValue(row,"ibflag")=="I"){
	       			if(sheetObj.CellValue(row,"rep_trd_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"sub_trd_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"rlane_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"dir_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"eff_fm_dt")!="" &&
	     	       	   sheetObj.CellValue(row,"eff_to_dt")!="" &&
	     	       	   sheetObj.CellValue(row,"vvd")!=""){
	       				document.form.f_cmd.value = COMMAND01;
	     	 			var sParam = "f_cmd="    +document.form.f_cmd.value
	     					            + "&rep_trd_cd=" + sheetObj.CellValue(row,"rep_trd_cd")
	     					            + "&sub_trd_cd=" + sheetObj.CellValue(row,"sub_trd_cd")
	     					            + "&rlane_cd=" + sheetObj.CellValue(row,"rlane_cd")
	     					            + "&dir_cd=" + sheetObj.CellValue(row,"dir_cd")
	     					            + "&eff_fm_dt=" + sheetObj.CellValue(row,"eff_fm_dt")
	     					            + "&eff_to_dt=" + sheetObj.CellValue(row,"eff_to_dt")
	     					            + "&vvd=" + sheetObj.CellValue(row,"vvd")
	     					            ;
	     	 			sheetObj.CellComboItem(row, "bsa_capa", " |" + "", " |" + "");
	     	 			
	     	 			var sXml = sheetObj.GetSearchXml("ESM_SPC_0033GS.do", sParam);
	     	 			var rtnValue = sXml.split("|$$|");
	     	 			
	     	 			var rtnArr = ComXml2ComboString(rtnValue,"code","name");
	     	 			if(rtnArr != undefined){
	     	 				sheetObj.CellComboItem(row, "bsa_capa", " |" + rtnArr[0], " |" + rtnArr[0]);
	     	 			}else{
	     	 				ComShowMessage(ComGetMsg('COM130401')+'(BSA Capa)');
	     	 			}
	       			}else{
	       				ComShowMessage(ComGetMsg('COM130403','Rep.Trade, Sub Trade, Lane, VVD, Bound, Effect Date'));	
	       			}
	       		}
	       					    break;
		}
	}

	function t2sheet2_OnClick(sheetObj, row, col){
		switch (sheetObj.ColSaveName(col)) {
	       	case "bsa_capa" :
	       		if(sheetObj.CellValue(row,"ibflag")=="I"){
	       			if(sheetObj.CellValue(row,"rep_trd_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"sub_trd_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"rlane_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"dir_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"eff_fm_dt")!="" &&
	     	       	   sheetObj.CellValue(row,"eff_to_dt")!="" &&
	     	       	   sheetObj.CellValue(row,"pol_cd")!="" &&
	     	       	   sheetObj.CellValue(row,"vvd")!=""){
	       				document.form.f_cmd.value = COMMAND02;
	     	 			var sParam = "f_cmd="    +document.form.f_cmd.value
	     					            + "&rep_trd_cd=" + sheetObj.CellValue(row,"rep_trd_cd")
	     					            + "&sub_trd_cd=" + sheetObj.CellValue(row,"sub_trd_cd")
	     					            + "&rlane_cd=" + sheetObj.CellValue(row,"rlane_cd")
	     					            + "&dir_cd=" + sheetObj.CellValue(row,"dir_cd")
	     					            + "&eff_fm_dt=" + sheetObj.CellValue(row,"eff_fm_dt")
	     					            + "&eff_to_dt=" + sheetObj.CellValue(row,"eff_to_dt")
	     					            + "&pol_cd=" + sheetObj.CellValue(row,"pol_cd")
	     					            + "&vvd=" + sheetObj.CellValue(row,"vvd")
	     					            ;
	     	 			sheetObj.CellComboItem(row, "bsa_capa", " |" + "", " |" + "");
	     	 			
	     	 			var sXml = sheetObj.GetSearchXml("ESM_SPC_0033GS.do", sParam);
	     	 			var rtnValue = sXml.split("|$$|");
	     	 			
	     	 			var rtnArr = ComXml2ComboString(rtnValue,"code","name");
	     	 			if(rtnArr != undefined){
	     	 				sheetObj.CellComboItem(row, "bsa_capa", " |" + rtnArr[0], " |" + rtnArr[0]);
	     	 			}else{
	     	 				ComShowMessage(ComGetMsg('COM130401')+'(BSA Capa)');
	     	 			}
	       			}else{
	       				ComShowMessage(ComGetMsg('COM130403','Rep.Trade, Sub Trade, Lane, VVD, Bound, Effect Date, Port'));	
	       			}
	       		}
	       					    break;
		}
	}
	

	
	 function setSheet1PopUpValue(rowArray, row, col) {
			var sheetObj = sheetObjects[1];
			var colArray = rowArray[0];
		
			sheetObj.CellValue(row, col) = colArray[3];
		}
		
	function setSheet3PopUpValue(rowArray, row, col) {
		var sheetObj = sheetObjects[3];
		var colArray = rowArray[0];
		
		sheetObj.CellValue(row, col) = colArray[3];
	}
		
	function t1sheet1_OnChange(sheetObj,row, col, value) {
        with(sheetObj){
        	switch(ColSaveName(col)){
        		case "rlane_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "lane", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "lane", value);
                    CellValue2(row, "sub_trd_cd") = text; 
                    text = getSheetComboText(sheetObj, row, col, 2, "lane", value);
                    CellValue2(row, "rlane_cd") = text; 
                    break;
                    
                case "sub_trd_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "subtrade", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "subtrade", value);
                    CellValue2(row, "sub_trd_cd") = text; 
                    CellValue2(row, "rlane_cd") = "";
                    break;  
                  
                case "rep_trd_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "trade", value);
                    CellValue2(row, "rep_trd_cd") = text; 
            		CellValue2(row, "sub_trd_cd") = "";
            		CellValue2(row, "rlane_cd") = "";
            		break;   
                  
                case "dir_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "bound", value);
                	CellValue2(row, "dir_cd") = text; 
                	break;
               	 
            }
        }
  	}
	
	function t1sheet2_OnChange(sheetObj,row, col, value) {
        with(sheetObj){
        	switch(ColSaveName(col)){
        		case "rlane_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "lane", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "lane", value);
                    CellValue2(row, "sub_trd_cd") = text; 
                    text = getSheetComboText(sheetObj, row, col, 2, "lane", value);
                    CellValue2(row, "rlane_cd") = text; 
                    break;
                    
                case "sub_trd_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "subtrade", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "subtrade", value);
                    CellValue2(row, "sub_trd_cd") = text; 
                    CellValue2(row, "rlane_cd") = "";
                    break;  
                  
                case "rep_trd_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "trade", value);
                    CellValue2(row, "rep_trd_cd") = text; 
            		CellValue2(row, "sub_trd_cd") = "";
            		CellValue2(row, "rlane_cd") = "";
            		break;   
                  
                case "dir_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "bound", value);
                	CellValue2(row, "dir_cd") = text; 
                	break;
               	 
            }
        }
  	}
	
	function t2sheet1_OnChange(sheetObj,row, col, value) {
        with(sheetObj){
        	switch(ColSaveName(col)){
        		case "rlane_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "lane", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "lane", value);
                    CellValue2(row, "sub_trd_cd") = text; 
                    text = getSheetComboText(sheetObj, row, col, 2, "lane", value);
                    CellValue2(row, "rlane_cd") = text; 
                    break;
                    
                case "sub_trd_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "subtrade", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "subtrade", value);
                    CellValue2(row, "sub_trd_cd") = text; 
                    CellValue2(row, "rlane_cd") = "";
                    break;  
                  
                case "rep_trd_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "trade", value);
                    CellValue2(row, "rep_trd_cd") = text; 
            		CellValue2(row, "sub_trd_cd") = "";
            		CellValue2(row, "rlane_cd") = "";
            		break;   
                  
                case "dir_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "bound", value);
                	CellValue2(row, "dir_cd") = text; 
                	break;
               	 
            }
        }
  	}
	
	function t2sheet2_OnChange(sheetObj,row, col, value) {
        with(sheetObj){
        	switch(ColSaveName(col)){
        		case "rlane_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "lane", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "lane", value);
                    CellValue2(row, "sub_trd_cd") = text; 
                    text = getSheetComboText(sheetObj, row, col, 2, "lane", value);
                    CellValue2(row, "rlane_cd") = text; 
                    break;
                    
                case "sub_trd_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "subtrade", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "subtrade", value);
                    CellValue2(row, "sub_trd_cd") = text; 
                    CellValue2(row, "rlane_cd") = "";
                    break;  
                  
                case "rep_trd_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "trade", value);
                    CellValue2(row, "rep_trd_cd") = text; 
            		CellValue2(row, "sub_trd_cd") = "";
            		CellValue2(row, "rlane_cd") = "";
            		break;   
                  
                case "dir_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "bound", value);
                	CellValue2(row, "dir_cd") = text; 
                	break;
               	 
            }
        }
  	}
		
   
/* 개발자 작업 끝 */