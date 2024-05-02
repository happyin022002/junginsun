/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0234.js
 *@FileTitle : ESM_BKG-0234
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 임재택
 *@LastVersion : 1.0
 * 2009.05.19 임재택
 * 1.0 Creation
 * 
 * 2011.08.05 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
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
 * @class ESM_BKG-0234 : ESM_BKG-0234 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0234() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var prefix1 = "t1sheet1_";
var prefix2 = "t2sheet1_";
var prefix3 = "t3sheet1_";

var intervalId = "";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];		   
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
			case "btn_retrieve":
				if ( beforetab == 0 ) {	  //첫번째탭에서 조회
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
				} else if ( beforetab == 2 ) {	//세번째 탭에서 조회.
					doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
				} else if ( beforetab == 3 ) {	//네번째 탭에서 조회.
					doActionIBSheet(sheetObjects[3],formObject,IBSEARCH);
				} else if ( beforetab == 4 ) {	//다섯번째 탭에서 조회.
					doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
				} else if ( beforetab == 5 ) {  //여섯번째 탭에서 조회.
					doActionIBSheet(sheetObjects[5],formObject,IBSEARCH);
				} else if ( beforetab == 6 ) {  //일곱번째 탭에서 조회
					doActionIBSheet(sheetObjects[6],formObject,IBSEARCH);
				} else if ( beforetab == 7 ) {  //여덟번째 탭에서 조회
					doActionIBSheet(sheetObjects[7],formObject,IBSEARCH);
				} 
				//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
			case "btn_new":
				doActionIBSheet(sheetObjects[0],formObject,IBRESET);							
			break;			
			case "btn_downexcel":
				if ( beforetab == 0 ) {	  //첫번째탭에서 조회
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
					doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 2 ) {	//세번째 탭에서 조회.
					doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 3 ) {	//네번째 탭에서 조회.
					doActionIBSheet(sheetObjects[3],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 4 ) {	//다섯번째 탭에서 조회.
					doActionIBSheet(sheetObjects[4],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 5 ) {	//여섯번째 탭에서 조회.
					doActionIBSheet(sheetObjects[5],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 6 ) {	//일곱번째 탭에서 조회.
					doActionIBSheet(sheetObjects[6],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 7 ) {	//여덟번째 탭에서 조회.
					doActionIBSheet(sheetObjects[7],formObject,IBDOWNEXCEL);
				}
			break;    
/*			case "btn_transmit":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;*/
							 
         } // end switch
	}catch(e) {
		if( e == "[object Error]") {
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
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
     //khlee-시작 환경 설정 함수 이름 변경
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
     //khlee-마지막 환경 설정 함수 추가
         ComEndConfigSheet(sheetObjects[i]);
     }

     for(k=0;k<tabObjects.length;k++){
         initTab(tabObjects[k],k+1);
     }
     //initControl();
	var formObj = document.form;
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp","obj_KeyUp", formObj);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", formObj);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	ComSetDisplay('btn_transmit', false);
}


/**
 * 조회조건 입력할 때 MaxLength까지 입력하면 다음탭으로 이동
 */
function obj_KeyUp() {
 	var formObject = document.form;
 	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
 	var srcValue = window.event.srcElement.getAttribute("value");
 	var srcName = window.event.srcElement.getAttribute("name");
 	
 	if ( (  srcName == "vvd_cd" || srcName == "pol_cd" || srcName == "pod_cd" ) && ComChkLen(srcValue, srcMaxLength) == "2" ) {
 		ComSetNextFocus();
 	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
    var sheetID = sheetObj.id;				
    switch(sheetID) {
    	case "t1sheet1":
    		with (sheetObj) {
		   	 	// 높이 설정
		   	 	style.height = 300;
		   	 	//전체 너비 설정
		   	 	SheetWidth = mainTable.clientWidth;
		   	 	//Host정보 설정[필수][HostIp, Port, PagePath]
		   	 	if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		   	 	//전체Merge 종류 [선택, msNone]
		   	 	MergeSheet = msNone;
		   	 	//전체Edit 허용 여부 [선택, Default false]
		   	 	Editable = true;
		   	 	//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		   	 	InitRowInfo(1, 1, 3, 100);
		   	 	var HeadTitle1 = "|Seq.|Custom Office Code|Registry\nNumber|Bill of Lading\nnumber|B/L Line\nnumber|B/L sub-line\nno.|B/L\nStatus|Previous\ndocument|B/L\ntype|B/L nature\ncode|Unique reference\nnumber|Exporter name|Exporter address 1|" +
		   	 			"Exporter address 2|Exporter address 3|Expoter address 4|Consignee\ncode|Consignee name|Consignee address 1|Consignee address 2|Consignee address 3|Consignee address 4|Notify\nCode|Notify Name|Notify address 1|Notify address 2|" +
		   	 			"Notify address 3|Notify address 4|Place of\nDeparture|Place of\ndestination|Number of\ncontainers|Packaging\ncode|Number of\npackages|Gross mass|Measurement|Shipping marks 1|Shipping marks 2|Shipping marks 3|Shipping marks 4|" +
		   	 			"Shipping marks 5|Shipping marks 6|Shipping marks 7|Shipping marks 8|Shipping marks 9|Shipping marks 10|Goods description 1|Goods description 2|Goods description 3|Goods description 4|Goods description 5|Freight\nIndicator|" +
		   	 			"Freight\nValue|Freight\nCurrency|Customs\nValue|Customs\nCurrency|Transport\nValue|Transport\nCurrency|Insurance\nvalue|Insurance\nCurrency|Total no.\nof sub-B/L|Number\nof seal|Delivery\nMode|Information 1|Information 2"
		   	 	var headCount = ComCountHeadTitle(HeadTitle1);
		   	 	//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOS=0,FROZENMOVE=false]
		   	 	InitColumnInfo(headCount, 0, 0, true);
		   	 	//해더에서 처리할 수 있는 각종 기능을 설정한다
		   	 	InitHeadMode(true, true, false, true, false, false);
		   	 	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
		   	 	InitHeadRow(0, HeadTitle1, true);
		   	 	//데이터속성 [ROW,   COL,    DATATYPE,     WIDTH, DATAALIGN, COLMERGE,          SAVENAME,       	   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		   	 	InitDataProperty(0, cnt++, dtHiddenStatus,   40,   daCenter,  false,    prefix1 + "ibflag"   		   , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtHidden,         30,   daCenter,  false,    prefix1 + "seq"     	       , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtCombo,         150,   daCenter,  false,    prefix1 + "ofc_cd"   	       , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "reg_no"	     	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           90,   daCenter,  false,    prefix1 + "bl_no"			   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           55,   daCenter,  false,    prefix1 + "bl_line_no"		   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           75,   daCenter,  false,    prefix1 + "bl_sub_line_no"	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           45,   daCenter,  false,    prefix1 + "bl_sts"			   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "pre_doc"		       , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           35,   daCenter,  false,    prefix1 + "bl_tp"			   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "bl_nt_cd"           , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          105,   daCenter,  false,    prefix1 + "uq_ref_no"		   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "shpr_nm"       	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "shpr_addr1"   	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "shpr_addr2"   	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "shpr_addr3"   	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "shpr_addr4"   	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "cnee_cd"    		   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "cnee_nm"    		   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "cnee_addr1" 		   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "cnee_addr2" 		   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "cnee_addr3" 		   , false,     "",         dfNone,      0,        false,     false);  
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "cnee_addr4" 		   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           80,   daCenter,  false,    prefix1 + "ntfy_cd"        	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "ntfy_nm"        	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "ntfy_addr1"    	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "ntfy_addr2"    	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "ntfy_addr3"    	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "ntfy_addr4"    	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "por_cd"             , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "del_cd"             , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           75,   daCenter,  false,    prefix1 + "tot_cntr"           , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           75,   daCenter,  false,    prefix1 + "pck_tp"       	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           75,   daCenter,  false,    prefix1 + "pck_qty"            , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           80,    daRight,  false,    prefix1 + "wgt"                , false,     "",         dfNullFloat, 3,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           90,    daRight,  false,    prefix1 + "vol"                , false,     "",         dfNullFloat, 5,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc1"           , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc2"           , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc3"           , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc4"           , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc5"           , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc6"           , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc7"           , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc8"           , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc9"           , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "mk_desc10"          , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          160,     daLeft,  false,    prefix1 + "gds_desc1"          , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "gds_desc2"          , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "gds_desc3"          , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "gds_desc4"          , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          220,     daLeft,  false,    prefix1 + "gds_desc5"          , false,     "",         dfNone,      0,        true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "fre_ind"            , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "fre_val"            , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "fre_cur"            , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "cstms_val"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "cstms_cur"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "trsp_val"           , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "trsp_cur"           , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "insur_val"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "insur_cur"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           70,   daCenter,  false,    prefix1 + "tot_sub_bl"         , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           60,   daCenter,  false,    prefix1 + "tot_seal"           , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           60,   daCenter,  false,    prefix1 + "del_mod"            , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           90,   daCenter,  false,    prefix1 + "info1"              , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,           90,   daCenter,  false,    prefix1 + "info2"              , false,     "",         dfNone,      0,        false,     false);
		    	
		   	 	InitDataCombo(0, prefix1 + "ofc_cd", "|Port of San Fernando|Port of Manila|Manila Int'l Container Port|Port of Batangas|Port of Cebu|Port of Cagayan de Oro|Port of Davao|Sub-port of Mariveles|ETC", "|P01|P02A|P02B|P04|P07|P10|P12|P16A|ETC");
    		}
   	 		break;
   	
   	
		case "t2sheet1":
		    with(sheetObj) {
		   	 	//높이설정
		   	 	style.height = 300;
		   	 	//전체 너비 설정
		   	 	SheetWidth = mainTable.clientWidth;
		   	 	//Host 정보 설정[필수][HostIp, Port, PagePath]
		   	 	if (location.hostname) InitHostInfo(location.hostname,  location.port, page_path);
		   	 	//전체 Merge 종류 [선택, msNone]
		   	 	MergeSheet = msNone;
		   	 	//전체 Edit 허용여부 [선택, Default false]
		   	 	Editable = true;
		   	 	//행 정보 설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		   	 	InitRowInfo(1, 1, 3, 100)
		   	 	var HeadTitle1 = "|Seq.|Custome Office Code|Registry\nNumber|Date of\narrival|Time of\narrival|Place of\ndeparture|Place of\ndestination|Carrier\nCode|Carrier Name|Carrier address 1|Carrier address 2|Carrier address 3|Carrier address 4|" +
		   	 			"Transportation\nmode|Transport\nIdentification|Transport\nNationality|Pleased of\nRegistration|Transport\nregistration number|Transport\nregistration date|Voyage\nnumber|Country of\nOrigin|Master\ninfo2|Net\ntonnage|Gross\ntonnage|" +
		   	 			"Number\nof B/L|Total number\nof containers"
		   	    var headCount = ComCountHeadTitle(HeadTitle1);
		   	 	//컬럼 정보 설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		   	 	InitColumnInfo(headCount, 0, 0, true);
		   	 	//해더에서 처리할 수 있는 각종 기능을 설정한다
		   	 	InitHeadMode(true, true, false, true, false, false);
		   	 	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
		   	 	InitHeadRow(0, HeadTitle1, true);
		   	 	//데이터속성 [ROW,   COL,    DATATYPE,     WIDTH, DATAALIGN, COLMERGE,   SAVENAME,       			   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		   	 	InitDataProperty(0, cnt++, dtHiddenStatus,  40,    daCenter,  false,    prefix2 + "ibflag"   		   , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtHidden,        30,    daCenter,  false,    prefix2 + "seq"     	       , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtCombo,         150,   daCenter,  false,    prefix2 + "ofc_cd"   	       , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          70,    daCenter,  false,    prefix2 + "reg_no"	     	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          60,    daCenter,  false,    prefix2 + "eta_dt"	    	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          60,    daCenter,  false,    prefix2 + "eta_tm"	    	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          70,    daCenter,  false,    prefix2 + "por_cd"             , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          70,    daCenter,  false,    prefix2 + "del_cd"             , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          50,    daCenter,  false,    prefix2 + "crr_cd"             , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          80,    daCenter,  false,    prefix2 + "crr_nm"             , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          110,   daCenter,  false,    prefix2 + "crr_addr1"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          110,   daCenter,  false,    prefix2 + "crr_addr2"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          110,   daCenter,  false,    prefix2 + "crr_addr3"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          110,   daCenter,  false,    prefix2 + "crr_addr4"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          95,    daCenter,  false,    prefix2 + "trsp_mod"           , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          90,    daCenter,  false,    prefix2 + "trsp_id"            , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          80,    daCenter,  false,    prefix2 + "trsp_ntlt"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          90,    daCenter,  false,    prefix2 + "plz_reg"            , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          120,   daCenter,  false,    prefix2 + "trsp_reg_no"        , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          110,   daCenter,  false,    prefix2 + "trsp_reg_dt"        , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          65,    daCenter,  false,    prefix2 + "vvd"            	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          70,    daCenter,  false,    prefix2 + "por"            	   , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          60,    daCenter,  false,    prefix2 + "mst_info2"          , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          60,    daCenter,  false,    prefix2 + "net_ton"            , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          60,    daCenter,  false,    prefix2 + "grs_ton"            , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          60,    daCenter,  false,    prefix2 + "tot_bl"             , false,     "",         dfNone,      0,        false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          90,    daCenter,  false,    prefix2 + "tot_cntr"           , false,     "",         dfNone,      0,        false,     false);
		    
		   	 	InitDataCombo(0, prefix2 + "ofc_cd", "|Port of San Fernando|Port of Manila|Manila Int'l Container Port|Port of Batangas|Port of Cebu|Port of Cagayan de Oro|Port of Davao|Sub-port of Mariveles|ETC", "|P01|P02A|P02B|P04|P07|P10|P12|P16A|ETC");
	    	}
	    	break;
    	
    
	    case "t3sheet1":
	    	with(sheetObj) {
	    	 	//높이설정
	    	 	style.height = 300;
	    	 	//전체 너비 설정
	    	 	SheetWidth = mainTable.clientWidth;
	    	 	//Host 정보 설정[필수][HostIp, Port, PagePath]
	    	 	if (location.hostname) InitHostInfo(location.hostname,  location.port, page_path);
	    	 	//전체 Merge 종류 [선택, msNone]
	    	 	MergeSheet = msNone;
	    	 	//전체 Edit 허용여부 [선택, Default false]
	    	 	Editable = true;
	    	 	//행 정보 설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    	 	InitRowInfo(1, 1, 3, 100)
	    	 	var HeadTitle1 = "|Seq.|Custom Office Code|Registry\nNumber|Bill of Lading\nnumber|Container\nIdentification|Type of\ncontainer|Empty/Full\nIndicator|Marks of\nseals # 1|Marks of\nseals # 2|Marks of\nseals # 3|Sealing\nParty Code"
		 		var headCount = ComCountHeadTitle(HeadTitle1);
		   	 	//컬럼 정보 설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		   	 	InitColumnInfo(headCount, 0, 0, true);
		   	 	//해더에서 처리할 수 있는 각종 기능을 설정한다
		   	 	InitHeadMode(true, true, false, true, false, false);
		   	 	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
		   	 	InitHeadRow(0, HeadTitle1, true);
		   	 	//데이터속성 [ROW,   COL,    DATATYPE,     WIDTH, DATAALIGN, COLMERGE,   SAVENAME,       			 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		   	 	InitDataProperty(0, cnt++, dtHiddenStatus,  40,    daCenter,  false,    prefix3 + "ibflag"   		 , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtHidden,        30,    daCenter,  false,    prefix3 + "seq"     	     , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtCombo,         150,   daCenter,  false,    prefix3 + "ofc_cd"   	     , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          80,   daCenter,  false,    prefix3 + "reg_no"	    	 , false,     "",         dfNone,      0,         false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          100,   daCenter,  false,    prefix3 + "bl_no"	     	 , false,     "",         dfNone,      0,         false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          100,   daCenter,  false,    prefix3 + "cntr_no"	     	 , false,     "",         dfNone,      0,         false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          90,   daCenter,  false,    prefix3 + "cntr_tpsz"	     , false,     "",         dfNone,      0,         false,     false);
		   	 	InitDataProperty(0, cnt++, dtCombo,         90,   daCenter,  false,    prefix3 + "cgo_tp"	     	 , false,     "",         dfNone,      0,         true,      true);
		   	 	InitDataProperty(0, cnt++, dtData,          90,   daCenter,  false,    prefix3 + "cntr_seal_no"	 , false,     "",         dfNone,      0,         false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          90,   daCenter,  false,    prefix3 + "cntr_seal_no2"	 , false,     "",         dfNone,      0,         false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          90,   daCenter,  false,    prefix3 + "cntr_seal_no3"	 , false,     "",         dfNone,      0,         false,     false);
		   	 	InitDataProperty(0, cnt++, dtData,          90,   daCenter,  false,    prefix3 + "seal_pty_cd"	     , false,     "",         dfNone,      0,         false,     false);
		
		   	 	InitDataCombo(0, prefix3 + "ofc_cd", "|Port of San Fernando|Port of Manila|Manila Int'l Container Port|Port of Batangas|Port of Cebu|Port of Cagayan de Oro|Port of Davao|Sub-port of Mariveles|ETC", "|P01|P02A|P02B|P04|P07|P10|P12|P16A|ETC");
		   	 	InitDataCombo(0, prefix3 + "cgo_tp", "  |FCL|LCL|Break Bulk", " |1|2|3")
    		}
    		break;

	    case "t4sheet1":      //t1sheet1 init
    		with (sheetObj) {
              	
				// 높이 설정
    			style.height = 320;
				//전체 너비 설정
    			SheetWidth = mainTable.clientWidth;
		
    			//Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
    			//전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msNone;
										
    			//전체Edit 허용 여부 [선택, Default false]
    			Editable = true;
		
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				var HeadTitle1 = "|Seq.|Registry Number|Date of Arrival|Vessel Name & Voyage Number|Last Port of Origin|Port of Discharge|Port of Discharge|Marker";
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, 
                //CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, 
                //SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,		"ibflag",		false,		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"seq",			false, 		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			170,	daCenter,	false,		"reg_number",	false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			165,	daCenter,	false,		"etadt",		false,		"",	dfDateYmd,	0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			215,	daCenter,	false,		"vname",		false,		"",	dfNone,		0,		false,		false,	30);
				InitDataProperty(0, cnt++ , dtData,			165,	daCenter,	false,		"polcd",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtCombo,		170,	daCenter,	false,		"discharge",	false,		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"etl_desc",		false, 		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"Marker",		false,		"0",dfNone,		0,		false,		false);
				
				InitDataCombo(0,    "discharge",    "|Manila South Harbor|Manila North Harbor|",    "|1|2",    "");
            }
            break;
              

         case "t5sheet1":      //t2sheet1 init
             with (sheetObj) {
              	
			    // 높이 설정
			    style.height = 320;
			    //전체 너비 설정
			    SheetWidth = mainTable.clientWidth;
			    //Host정보 설정[필수][HostIp, Port, PagePath]
			    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			    //전체Merge 종류 [선택, Default msNone]
			    MergeSheet = msNone;			
			    //전체Edit 허용 여부 [선택, Default false]
			    Editable = true;
			    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			    InitRowInfo(1, 1, 3, 100);
			    var HeadTitle1 = "|Seq.|Year|Registry No.|B/L Number|Cargo Type|Cargo Type|Shipper Name|Shipper Address 1|Shipper Address 2|Shipper Address 3|Shipper Address 4|";
			    HeadTitle1 +=	"Consignee Name|Consignee Address 1|Consignee Address 2|Consignee Address 3|Consignee Address 4|";
			    HeadTitle1 +=	"Notify Name|Notify Address 1|Notify Address 2|Notify Address 3|Notify Address 4|Total No. of CNTR|Weight|Volume|Country Origin|POD|Marker";

			    var headCount = ComCountHeadTitle(HeadTitle1);
			    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			    InitColumnInfo(headCount, 0, 0, true);
			    // 해더에서 처리할 수 있는 각종 기능을 설정한다
			    InitHeadMode(true, true, false, true, false,false);
			    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			    InitHeadRow(0, HeadTitle1, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, 
			    //CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, 
			    //SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,		"ibflag",				false,		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"seq",					false, 		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,		"year",      			false,		"",	dfNone,		0,		false,		false,	1);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"reg_number2",  		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			115,	daCenter,	false,		"bl_no",  				false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	false,		"cargo_type", 			false,		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"etl_cargo_type",		false, 		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"shipper_name",    		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"shipper_address1",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"shipper_address2",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"shipper_address3",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"shipper_address4",		false,		"",	dfNone,		0,		false,		false);                                                                    
				InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		false,		"consignee_name",    	false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		false,		"consignee_address1",	false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		false,		"consignee_address2",	false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		false,		"consignee_address3",	false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		false,		"consignee_address4",	false,		"",	dfNone,		0,		false,		false);                                                                                              
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"notify_name",    		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"notify_address1",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"notify_address2",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"notify_address3",		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		false,		"notify_address4",		false,		"",	dfNone,		0,		false,		false);                                                                                                 
				InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,		"total_cntr",     		false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,		"weight",    			false,		"",	dfNullFloat,2,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,		"volume",    			false,		"",	dfNullFloat,3,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		"country_origin",   	false,		"",	dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	false,		"pod",       			false,		"",	dfNone,		0,		true,		true);                                                                                                  
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,		"Marker2",    			false,		"0",dfNone,		0,		false,		false);
				
				InitDataCombo(0, "pod", "AEG|CEB|MLA", "AEG|CEB|MLA");
				InitDataCombo(0, "cargo_type", "  |FCL|LCL|Break Bulk", "O|1|2|3");
            }
             break;        
             
             
         case "t6sheet1":      //t3sheet1 init
             with (sheetObj) {
				// 높이 설정
				style.height = 300;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			    //전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
			    var HeadTitle1 = "|Seq.|Registry No.|B/L Number|Container Number|Type / Size|Container Seal Number|Delivery Type|Marker";
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,		"ibflag",			false,		"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"seq",				false, 		"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,		"reg_number3",		false,		"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	false,		"bl_no2",			false,		"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			165,	daCenter,	false,		"container_no",		false,		"",		dfNone,		0,		false,		false,	30);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,		"type_size",		false,		"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,			170,	daLeft,		false,		"cntr_real_no",		false,		"",		dfNone,		0,		false,		false); 
				InitDataProperty(0, cnt++ , dtData,			130,	daCenter,	false,		"delivery_type",	false,		"",		dfNone,		0,		false,		false);										
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"Marker",			false,		"0",	dfNone,		0,		false,		false);
            }
             break;      
             
             
         case "t7sheet1":      //t4sheet1 init
             with (sheetObj) {
				// 높이 설정
				style.height = 300;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
			    MergeSheet = msNone;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				var HeadTitle1 = "|Seq.|Seq.2|Registry No.|B/L Number|Package Type|No. of Package|Description & Goods|Marker";
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,		"ibflag",		false,		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"seq",			false, 		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"seq2",			false, 		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,		"reg_number4",	false,		"",	dfNone,		0,		false,		false,false,-1,false,false);
				InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	false,		"bl_no3",		false,		"",	dfNone,		0,		false,		false,false,-1,false,false);
				InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,		"package_type",	false,		"",	dfNone,		0,		false,		false,false,-1,false,false);
				InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	false,		"pck_qty",		false,		"",	dfNone,		0,		false,		false,false,-1,false,false);
				InitDataProperty(0, cnt++ , dtData,			250,	daLeft,		false,		"desc_good",	false,		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,		"mark",			false,		"",	dfNone,		0,		false,		false,false,-1,false,false);
             }
             break;     
             
             
         case "t8sheet1":      //t5sheet1 init
             with (sheetObj) {
				// 높이 설정
				style.height = 300;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;		
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);		
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				var HeadTitle1 = "|Seq.|Registry No.|B/L Number|Marks & Numbers|Marker";
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,		"ibflag",				false,		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"seq",					false, 		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			220,	daCenter,	false,		"reg_number5",			false,		"",	dfNone,		0,		false,		false,false,-1,false,false);
				InitDataProperty(0, cnt++ , dtData,			250,	daCenter,	false,		"bl_no4",			  	false,		"",	dfNone,		0,		false,		false,false,-1,false,false);
				InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		false,		"desc_good2",			false,		"",	dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			160,	daCenter,	false,		"mark2",				false,		"",	dfNone,		0,		false,		false,false,-1,false,false);
             }
             break; 
             
     	case "sheet1":
    		with (sheetObj) {
                // 높이 설정
                style.height = 0;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 2, 100);

                //var HeadTitle = "|vvd_cd|pol_cd|pod_cd|line_cd|flatFile";
                var HeadTitle = "flatFile";
    			var headCount = ComCountHeadTitle(HeadTitle);

    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtData,	100, daLeft, false,	"flat_file");
    		}
    		break;             
    }
}

/** 
 * Sheet 관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
    switch(sAction) {

    	case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)) {	
					formObj.f_cmd.value = SEARCH;
					status = sheetObj.EtcData('status');
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.sheetgubun.value = sheetObj.id;
					formObj.vsl_cd.value = formObj.vvd_cd.value.substring(0,4);
					formObj.skd_voy_no.value = formObj.vvd_cd.value.substring(4,8);
					formObj.skd_dir_cd.value = formObj.vvd_cd.value.substring(8);			
					var prefix = "";
					if(sheetObj == sheetObjects[0]) {
						prefix = prefix1;
					} else if (sheetObj == sheetObjects[1]) {
						prefix = prefix2;
					} else if (sheetObj == sheetObjects[2]) {
						prefix = prefix3;
					}
					
					if(prefix != "") {
						var sXml = sheetObj.GetSearchXml("ESM_BKG_0234GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));						
					} else {
						var sXml = sheetObj.GetSearchXml("ESM_BKG_0234GS.do", FormQueryString(formObj));
					}
					
					sheetObj.LoadSearchXml(sXml);
			   	  	ComEtcDataToForm(formObj, sheetObj);
			   	  	sheetObj.EtcData("vvd") = formObj.vvd_cd.value;
			   	  	ComOpenWait(false);
			}
			break;
    	case IBRESET:
    	    formObj.reset();
    	    sheetObjects[0].RemoveAll();
    	    sheetObjects[1].RemoveAll();
    	    sheetObjects[2].RemoveAll();
    	    formObj.vvd_cd.focus();
    		break;
		case IBDOWNEXCEL:      // 엑셀다운로드

			var sHeetName = "";
		   
		   if(beforetab == 0) {
			   sHeetName = "sheet1_";
		   }
			   
		   if(beforetab == 1) {
			   sHeetName = "sheet2_";
		   }
			   
		   if(beforetab == 2) {
			   sHeetName = "sheet3_";
		   }
			   
		   if(beforetab == 3) {
			   sHeetName = "sheet4_";
		   }
		   
		   if(beforetab == 4) {
			   sHeetName = "sheet5_";
		   }
		   
		   if(beforetab == 5) {
			   sHeetName = "sheet6_";
		   }
			
		   if(beforetab == 6) {
			   sHeetName = "sheet7_";
		   }
		   
		   if(beforetab == 7) {
			   sHeetName = "sheet8_";
		   }
		   
		    formObj.sheetgubun.value = sHeetName;
			formObj.f_cmd.value = MULTI01;
			var savedFileName = "";
		    var sParam = "";
		    if(sHeetName == "sheet1_") {
	 			if(!validateForm(sheetObj,formObj,sAction)) {
		    		return false;
		    	}
		    	savedFileName = sheetObj.CellValue(1, prefix1 + "reg_no").substr(0, 7) + ".BOL.txt";
		    	sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(true, true, prefix1 + "ibflag");
		    	ComOpenWait(true);
				sheetObjects[8].DoSearch("ESM_BKG_0234GS.do", sParam);
				ComOpenWait(false);
				sheetObjects[8].Down2Text("", "", "", savedFileName, "c:\\flatFile\\", "", false, false, true);
		    } else if(sHeetName == "sheet2_") {
		    	if(!validateForm(sheetObj,formObj,sAction)) {
		    		return false;
		    	}
		    	savedFileName = sheetObj.CellValue(1, prefix2 + "reg_no").substr(0, 7) + ".GEN.txt";
		    	sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(true, true, prefix2 + "ibflag");
				ComOpenWait(true);
				sheetObjects[8].DoSearch("ESM_BKG_0234GS.do", sParam);
				ComOpenWait(false);
				sheetObjects[8].Down2Text("", "", "", savedFileName, "c:\\flatFile\\", "", false, false, true);
		    } else if(sHeetName == "sheet3_") {
		    	if(!validateForm(sheetObj,formObj,sAction)) {
		    		return false;
		    	}
		    	savedFileName = sheetObj.CellValue(1, prefix3 + "reg_no").substr(0, 7) + ".CTN.txt";
		    	for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
		    		if(sheetObj.CellValue(i, prefix3 + "cgo_tp") == "1") {
		    			sheetObj.CellValue(i, prefix3 + "cgo_tp") = "FCL" 
		    		} else if(sheetObj.CellValue(i, prefix3 + "cgo_tp") == "2") {
		    			sheetObj.CellValue(i, prefix3 + "cgo_tp") = "LCL"
		    		} else if(sheetObj.CellValue(i, prefix3 + "cgo_tp") == "3") {
		    			sheetObj.CellValue(i, prefix3 + "cgo_tp") = "Break Bulk"
		    		}
		    	}
		    	sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(true, true, prefix3 + "ibflag");
				ComOpenWait(true);
				sheetObjects[8].DoSearch("ESM_BKG_0234GS.do", sParam);
				ComOpenWait(false);
				sheetObjects[8].Down2Text("", "", "", savedFileName, "c:\\flatFile\\", "", false, false, true);
		    } else {
			// 기존 코드
			    for(var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ;i++){
			    	if(sheetObj.RowStatus(i) != "U") continue;
			    	if(sHeetName == "sheet4_"){
			    		sParam = sParam + "ibflag=" + sheetObj.CellValue(i,"ibflag");
			    		sParam = sParam + "&seq=" + sheetObj.CellValue(i,"seq");
			    		sParam = sParam + "&discharge=" + sheetObj.CellValue(i,"discharge");
			    	}
			    	else if(sHeetName == "sheet5_"){
			    		sParam = sParam + "ibflag=" + sheetObj.CellValue(i,"ibflag");
			    		sParam = sParam + "&seq=" + sheetObj.CellValue(i,"seq");
			    		sParam = sParam + "&pod=" + sheetObj.CellValue(i,"pod");
			    		sParam = sParam + "&cargo_type=" + sheetObj.CellValue(i,"cargo_type");
			    	}
			    	else if(sHeetName == "sheet7_"){
			    		sParam = sParam + "ibflag=" + sheetObj.CellValue(i,"ibflag");
			    		sParam = sParam + "&seq=" + sheetObj.CellValue(i,"seq");
			    		sParam = sParam + "&seq2=" + sheetObj.CellValue(i,"seq2");
			    		sParam = sParam + "&desc_good=" + sheetObj.CellValue(i,"desc_good");
			    	}
			    	else if(sHeetName == "sheet8_"){
			    		sParam = sParam + "ibflag=" + sheetObj.CellValue(i,"ibflag");
			    		sParam = sParam + "&seq=" + sheetObj.CellValue(i,"seq");
			    		sParam = sParam + "&desc_good2=" + sheetObj.CellValue(i,"desc_good2");
			    	}
			    	
					sParam = sParam + ";"
				}

				formObj.sheetdata.value = sParam;
			    formObj.target = "download";				 			 
			    formObj.action = "ESM_BKG_0234GS_1.do";		
			    formObj.submit();
			    
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;                    
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0234GS.do", FormQueryString(formObj));
				
				var filename = ComGetEtcData(sXml, "filename");
				if(filename == undefined || filename == null || filename == "") return;			
				ComOpenWait(false);				
				document.formFile.target = "download";
				document.formFile.downloadLocation.value = filename;
				var fileNm = filename.substr(5,filename.length);
				document.formFile.downloadFileName.value = fileNm;
				document.formFile.submit();		
		    }
			//ComOpenWait(false); 
		break;
         
/*		case IBSAVE:
			
			//if(!validateForm(sheetObj, formObj, sAction)) return false;
			
			formObj.f_cmd.value = MULTI;
			var sParam = FormQueryString(formObj);
			sParam += "&" + sheetObjects[0].GetSaveString(false, true, prefix1+"ibflag");
			sParam += "&" + sheetObjects[1].GetSaveString(false, true, prefix2+"ibflag");
			sParam += "&" + sheetObjects[2].GetSaveString(false, true, prefix3+"ibflag");
			alert(sheetObjects[0].GetSaveString(false, true, prefix1+"ibflag"));
			return;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true, true);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_0234GS.do", sParam);
			var key = ComGetEtcData(sXml, "KEY");
			intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
			
			break;*/
    }
}
 
/**
 * 파일 생성 종료 후 호출
 */
function CloseWait(){
	ComOpenWait(false); 
}


/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++] = tab_obj;
}
 
/**
 * 시트에 있는 값을 가지고 form에 있는 hidden 에 넣는 작업을 한다.
 */
function setFormSheet7(sheetObj) {
	 var reg_number4 = "";
	 var bl_no3 = "";
	 var package_type = "";
	 var pck_qty = "";
	 var desc_good = "";
	 var mark = "";
	 for(var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ;i++){		
		    reg_number4 = reg_number4 + sheetObj.CellValue(i, "reg_number4") + "|";
		    bl_no3 = sheetObj.CellValue(i, "bl_no3") + "|";
		    package_type = sheetObj.CellValue(i, "package_type") + "|";
		    pck_qty = sheetObj.CellValue(i, "pck_qty") + "|";
		    desc_good = sheetObj.CellValue(i, "desc_good") + "|";
		    mark = sheetObj.CellValue(i, "mark") + "|";		    		
	 }
	 document.form.reg_number4.value = reg_number4;	
	 document.form.bl_no3.value = bl_no3;
	 document.form.package_type.value = package_type;
	 document.form.pck_qty.value = pck_qty;
	 document.form.desc_good.value = desc_good;
	 document.form.mark.value = mark;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
      switch(tabNo) {
          case 1:
             with (tabObj) {
                 var cnt  = 0 ;
                 InsertTab( cnt++ , "File 1-BOL" , -1 );
                 InsertTab( cnt++ , "File 2-GEN" , -1 );
                 InsertTab( cnt++ , "File 3-CTN" , -1 );
//                 InsertTab( cnt++ , "File 1" , -1 );
//                 InsertTab( cnt++ , "File 2" , -1 );
//                 InsertTab( cnt++ , "File 3" , -1 );
//                 InsertTab( cnt++ , "File 4" , -1 );
//                 InsertTab( cnt++ , "File 5" , -1 );
             }
          break;

      }
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem) {
     var objs = document.all.item("tabLayer");
	 objs[nItem].style.display = "Inline";
	 objs[beforetab].style.display = "none";
	 //--------------- 요기가 중요 --------------------------//
	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	 //------------------------------------------------------//
	 beforetab= nItem;
}

/**
 * Tab 클릭시 해당 탭 시트 데이터 조회
 */
function tab1_OnClick(tabObj) {
	var formObject = document.form;
	if(formObject.vvd_cd.value == "" || formObject.reg_no.value == "" || formObject.pod_cd.value == "") return;
	
	if ( beforetab == 0 ) {	  //첫번째탭에서 조회
		if(sheetObjects[0].EtcData("vvd") != formObject.vvd_cd.value || sheetObjects[0].RowCount == 0)
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
	} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
		if(sheetObjects[1].EtcData("vvd") != formObject.vvd_cd.value || sheetObjects[1].RowCount == 0)
			doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
	} else if ( beforetab == 2 ) {	//세번째 탭에서 조회.
		if(sheetObjects[2].EtcData("vvd") != formObject.vvd_cd.value || sheetObjects[2].RowCount == 0)
			doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
	} else if ( beforetab == 3 ) {	//네번째 탭에서 조회.
		if(sheetObjects[3].EtcData("vvd") != formObject.vvd_cd.value || sheetObjects[3].RowCount == 0)
			doActionIBSheet(sheetObjects[3],formObject,IBSEARCH);
	} else if ( beforetab == 4 ) {	//다섯번째 탭에서 조회.
		if(sheetObjects[4].EtcData("vvd") != formObject.vvd_cd.value || sheetObjects[4].RowCount == 0)
			doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
	} else if ( beforetab == 5 ) {  //여섯번째 탭에서 조회.
		if(sheetObjects[5].EtcData("vvd") != formObject.vvd_cd.value || sheetObjects[5].RowCount == 0)
			doActionIBSheet(sheetObjects[5],formObject,IBSEARCH);
	} else if ( beforetab == 6 ) {  //일곱번째 탭에서 조회.
		if(sheetObjects[6].EtcData("vvd") != formObject.vvd_cd.value || sheetObjects[6].RowCount == 0)
			doActionIBSheet(sheetObjects[6],formObject,IBSEARCH);
	} else if ( beforetab == 7 ) {  //여덟번째 탭에서 조회.
		if(sheetObjects[7].EtcData("vvd") != formObject.vvd_cd.value || sheetObjects[7].RowCount == 0)
			doActionIBSheet(sheetObjects[7],formObject,IBSEARCH);
	}		
}

/**
 * t4sheet1 시트 데이터 변경 시 처리
 */
function t4sheet1_OnChange(sheetObj, Row, Col, Value) {
  	var formObject = document.form;
  	if (sheetObj.ColSaveName(Col) == "Discharge"){  		 
  		sheetObj.CellValue2(Row, Col+1) = Value;  		 
  	}
}

/**
 * t5sheet1 시트 데이터 변경 시 처리
 */
function t5sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObject = document.form;
	if (sheetObj.ColSaveName(Col) == "cargo_type") {  		 
	  	sheetObj.CellValue2(Row, Col+1) = Value;  		 
  	}
}
  
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00161');
				ComSetFocus(formObj.vvd_cd);
				return false;
			}
			if (formObj.reg_no.value.length != 7) {
				ComShowCodeMessage('BKG00162');
				ComSetFocus(formObj.reg_no);
				return false;
			}
			if (formObj.pol_cd.value.length < 5) {			 
				formObj.pol_cd.value = "";		 
			}
			if (formObj.pod_cd.value.length < 5) {
				ComShowCodeMessage('BKG00210');
				ComSetFocus(formObj.pod_cd);
				return false;
			}
			return true;
		break;
		
		case IBDOWNEXCEL:
			if (sheetObj == sheetObjects[0]) {
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
					if(sheetObj.CellValue(i, prefix1 + "ofc_cd") == "") {
						ComShowCodeMessage('COM12200', 'Customs Office Code');
						sheetObj.SelectCell(i, prefix1 + "ofc_cd", true);
						return false;
					} else if(sheetObj.CellValue(i, prefix1 + "mk_desc1") == "") {
						ComShowCodeMessage('COM12200', 'Shpping marks1')
						sheetObj.SelectCell(i, prefix1 + "mk_desc1", true);
						return false;
					} else if(sheetObj.CellValue(i, prefix1 + "gds_desc1") == "") {
						ComShowCodeMessage('COM12200', 'Goods description1')
						sheetObj.SelectCell(i, prefix1 + "gds_desc1", true);
						return false;
					}
				}
			} else if (sheetObj == sheetObjects[1]) {
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
					if(sheetObj.CellValue(i, prefix2 + "ofc_cd") == "") {
						ComShowCodeMessage('COM12200', 'Customs Office Code');
						sheetObj.SelectCell(i, prefix2 + "ofc_cd", true);
						return false;
					}
				}
			} else if (sheetObj == sheetObjects[2]) {
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
					if(sheetObj.CellValue(i, prefix3 + "ofc_cd") == "") {
						ComShowCodeMessage('COM12200', 'Customs Office Code');
						sheetObj.SelectCell(i, prefix3 + "ofc_cd", true);
						return false;
					}
				}
			}	
			return true;
		break;	
	}
}
 
/*function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.getSearchXml("ESM_BKG_0234GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	
	if(!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if(sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowCodeMessage('BKG00101');
		return;
	} else if (sJbStsFlg == "FAIL") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowMessage(ComResultMessage(sXml));
	}
}*/

/* 개발자 작업 끝 */