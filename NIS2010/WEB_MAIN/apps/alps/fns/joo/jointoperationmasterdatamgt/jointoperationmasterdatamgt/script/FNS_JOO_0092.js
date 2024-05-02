/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FNS_JOO_0092.jsp
*@FileTitle : BSA Information Entry History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.30
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.12.30 김영오
* 1.0 Creation
* 2013.06.14 이수진 [CHM-201325358]BSA Information Entry 기능 추가
*            - Remark RDR, Remark J/O 항목 추가
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
 * @class FNS_JOO_0092 : FNS_JOO_0092 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0092() {
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
		case "btn_downexcel":
			sheetObj.SpeedDown2Excel(1);
			break;

		case "btn_close":
			self.close();
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
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
			style.height = 410;
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

			var HeadTitle  = "|YYYY-WW|Office|Rev/Exp|Trade|Lane|Vessel|Voyage|Direction|Port|Port Seq.|Carrier|BSA|Add BSA|Add\nBSA Carrier|OUS\nBSA|Ton/TEU|OUS\nWeight"
				+"|20' HC|20' HC|40' HC|40' HC|45'|45'|45'|Round\nKind|Round\nType|RF Alloc|RF Alloc|IPC\nOUS|RDR Port|Revenue Port ETD|RDR Finish|BSA\nPrice|OUS Price|OUS Price|OUS Price|OUS Price|OUS Price"
				+"|R/F Price|R/F Price|Price\nFinish|VVD+Port+Seq+Crr|Remark RDR|Remark FAR J/O|Update\nDate|Update ID|Update Name|Delete\nMark";
			var HeadTitle2 = "|YYYY-WW|Office|Rev/Exp|Trade|Lane|Vessel|Voyage|Direction|Port|Port Seq.|Carrier|BSA|Add BSA|Add\nBSA Carrier|OUS\nBSA|Ton/TEU|OUS\nWeight"
				+"|Sub Alloc|Over Ratio (F)|Sub Alloc|Over Ratio (F)|Sub Alloc|Under Ratio (F)|Over Ratio (F)|Round\nKind|Round\nType|Ocean|Inter|IPC\nOUS|RDR Port|Revenue Port ETD|RDR Finish|BSA\nPrice"
				+"|Ocean|Inter|MT(Ocean)|MT(Inter)|Sector Price|Ocean|Inter|Price\nFinish|VVD+Port+Seq+Crr|Remark RDR|Remark FAR J/O|Update\nDate|Update ID|Update Name|Delete\nMark";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 12, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다.
			InitHeadMode(true, true, true, false, true, false)
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT,	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus      , 30, daCenter, true, prefix + "ibflag" );
//			InitDataProperty(0, cnt++, dtCheckBox    , 30, daCenter, true,  prefix + "del_chk"); //dtCheckBox
			
			InitDataProperty(0, cnt++, dtData   	 , 70, daCenter, true,  prefix + "yrwk"              		, false, "", dfDateYm      	, 0, false, false);      // YYYY-MM
			InitDataProperty(0, cnt++, dtCombo   	 , 70, daCenter, true,  prefix + "ofc_cd"              		, false, "", dfNone        	, 0, false, true ,6);      // Office
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true,  prefix + "re_divr_cd"          		, false, "", dfNone        	, 0, false, true );        // Rev/Exp
			InitDataProperty(0, cnt++, dtCombo       , 50, daCenter, true,  prefix + "trd_cd"              		, false, "", dfNone        	, 0, false, true );        // Trade
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix + "rlane_cd"            		, false, "", dfNone        	, 0, false, true );        // Lane
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix + "vsl_cd"            		, false, "", dfNone        	, 0, false, true ,4 );     // Vessel
			InitDataProperty(0, cnt++, dtData        , 60, daCenter, true,  prefix + "skd_voy_no"          		, false, "", dfNone        	, 0, false, true ,4 );     // Vessel
			InitDataProperty(0, cnt++, dtCombo       , 60, daCenter, true,  prefix + "skd_dir_cd"               , false, "", dfNone        	, 0, false, true );        // Direction
			InitDataProperty(0, cnt++, dtData   	 , 60, daCenter, true,  prefix + "port_cd"            		, false, "", dfNone        	, 0, false, true ,5 );     // Port
			InitDataProperty(0, cnt++, dtData        , 70, daCenter, true,  prefix + "port_seq"           		, false, "", dfNone        	, 0, false, true, 3 );     // Port Seq.
			
			InitDataProperty(0, cnt++, dtData        , 80, daCenter, true,  prefix + "jo_crr_cd"           		, false, "", dfNone        	, 0, false, true ,3);      // Carrier
			InitDataProperty(0, cnt++, dtData        , 80, daRight , true,  prefix + "jo_bsa_teu_qty"      		, false, "", dfInteger     	, 2, true , true );        // BSA			
			InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix + "jo_bsa_add_teu_qty"      	, false, "", dfInteger   	, 0, false, true );        // Add BSA 
			InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true,  prefix + "jo_add_bsa_crr_flg"      	, false, "", dfNone   	   	, 0, true , true );        // Add BSA Carrier 
			InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix + "jo_ovr_bsa_teu_qty"       , false, "", dfInteger   	, 2, false, true );        // OUS BSA
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  true,  prefix + "jo_ton_teu_qty"     		, false, "", dfFloat   		, 2, true , true );        // Ton/TEU
			InitDataProperty(0, cnt++, dtData        , 90, daRight , true,  prefix + "jo_ovr_ton_wgt"    		, false, "", dfFloat 		, 2, true , true );        // OUS Weight 
			InitDataProperty(0, cnt++, dtData        , 90, daRight , false, prefix + "jo_20ft_sub_teu_qty"    	, false, "", dfInteger 		, 0, true , true );        // 20'HC Sub Alloc 
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_20ft_ovr_rto"     		, false, "", dfFloat 		, 3, true , true );        // 20' Over Ratio
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_40ft_sub_teu_qty"    	, false, "", dfInteger 		, 0, true , true );        // 40'HC Sub Alloc
			
			InitDataProperty(0, cnt++, dtData        ,110, daRight,  false, prefix + "jo_40ft_ovr_rto"      	, false, "", dfFloat 		, 3, true , true );        // 40' Over Ratio
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_45ft_sub_teu_qty"      , false, "", dfInteger   	, 0, true , true );        // 45' Sub Alloc
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_45ft_und_rto"  		, false, "", dfFloat 		, 3, true , true );        // 45' Under Ratio
			InitDataProperty(0, cnt++, dtData        ,100, daRight,  false, prefix + "jo_45ft_ovr_rto"			, false, "", dfFloat 		, 3, true , true );        // 45' Over Ratio			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_rnd_knd_flg"          	, false, "", dfNone        	, 0, true , true);         // Round Kind
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_rnd_rule_lvl"          , false, "", dfNone        	, 0, true , true);         // Round Type			
			InitDataProperty(0, cnt++, dtData        ,110, daRight,  true,  prefix + "jo_rf_ocn_teu_qty"       	, false, "", dfInteger      , 0, true , true);         // RF Alloc Ocean
			InitDataProperty(0, cnt++, dtData   	 , 80, daRight,  true,  prefix + "jo_rf_inter_teu_qty"      , false, "", dfInteger     	, 0, true , true );        // RF Alloc Inter			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_inter_ovr_flg"         , false, "", dfNone        	, 0, true , true);         // IPC OUS			
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix + "jo_rdr_port_cd"          	, false, "", dfNone        	, 0, true , true,5);       // RDR Port
			InitDataProperty(0, cnt++, dtData        ,120, daCenter, true,  prefix + "rev_port_etd_dt"        	, false, "", dfDateYmd    	, 0, false, false);			// Revenue Port ETD
			
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_fsh_flg"          		, false, "", dfNone        	, 0, true , true);         // RDR Finish			
			InitDataProperty(0, cnt++, dtData  		 , 80, daRight,  true,  prefix + "jo_bsa_prc"         		, false, "", dfFloat     	, 2, true , true );        // BSA Price
			InitDataProperty(0, cnt++, dtData        ,120, daRight,  true,  prefix + "jo_ovr_ocn_prc"           , false, "", dfFloat 		, 2, true , true);         // OUS Price Ocean			
			InitDataProperty(0, cnt++, dtData        ,120, daRight,  true,  prefix + "jo_ovr_inter_prc"         , false, "", dfFloat 		, 2, true , true);         // OUS Price Inter
			InitDataProperty(0, cnt++, dtData        , 80, daRight,  true,  prefix + "jo_ovr_mt_ocn_prc"        , false, "", dfFloat        , 2, true , true);         // OUS Price MT(Ocean)
			InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix + "jo_ovr_mt_inter_prc"      , false, "", dfFloat        , 2, true , true);         // OUS Price MT(Inter)
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_sctr_prc_flg"          , false, "", dfNone        	, 0, true , true);         // OUS Price Sector Price
			InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix + "jo_rf_ocn_prc"          	, false, "", dfFloat        , 2, true , true);         // R/F Price Ocean			
			InitDataProperty(0, cnt++, dtData        , 90, daRight,  true,  prefix + "jo_rf_inter_prc"          , false, "", dfFloat        , 2, true , true);         // R/F Price Inter						
			InitDataProperty(0, cnt++, dtCombo       , 90, daCenter, true,  prefix + "jo_prc_fsh_flg"      		, false, "", dfNone        	, 0, true , true);         // Price Finish
			
			InitDataProperty(0, cnt++, dtData        ,140, daCenter, true,  prefix + "vvd_port"            		, false, "", dfNone        	, 0, false, true ,17 );    // Vessel			
			InitDataProperty(0, cnt++, dtData        ,300, daCenter, true,  prefix + "jo_bsa_entr_rdr_rmk"      , false, "", dfNone        	, 0, true , true,500);     // Remark RDR
			InitDataProperty(0, cnt++, dtData        ,300, daCenter, true,  prefix + "jo_bsa_entr_rmk"        	, false, "", dfNone        	, 0, true , true,500);     // Remark FAR J/O
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix + "upd_dt"          			, false, "", dfDateYmd      , 0, false, true);
			InitDataProperty(0, cnt++, dtData        , 90, daCenter, true,  prefix + "upd_usr_id"          		, false, "", dfNone        	, 0, false, true);
			InitDataProperty(0, cnt++, dtData        ,120, daCenter, true,  prefix + "usr_nm"          			, false, "", dfNone        	, 0, false, true);
			InitDataProperty(0, cnt++, dtCombo       , 80, daCenter, true,  prefix + "delt_flg"            		, false, "", dfNone        	, 0, false, true);
			
			ImageList(0) = "/hanjin/img/button/btns_calendar.gif";



			InitDataValid(0, prefix+"port_seq", vtNumericOnly);    			// 숫자만
//            InitDataValid(0, prefix+"jo_end_vsl_cd", vtEngUpOnly);    		// 영대문자만
//            InitDataValid(0, prefix+"jo_end_skd_dir_cd", vtEngUpOnly);    	// 영대문자만
			InitDataCombo(0, prefix+"re_divr_cd" , "Rev|Exp", "R|E");
			InitDataCombo(0, prefix+"delt_flg"   , "Yes|No", "Y|N");
			InitDataCombo(0, prefix+"skd_dir_cd"   , " |E|W|S|N", " |E|W|S|N");
			InitDataCombo(0, prefix+"jo_add_bsa_crr_flg"   , " |Y|N", " |Y|N");
			InitDataCombo(0, prefix+"jo_sctr_prc_flg"   , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_inter_ovr_flg"  , "Y|N", "Y|N");
			InitDataCombo(0, prefix+"jo_rnd_knd_flg"   , "S|G", "S|G");
			InitDataCombo(0, prefix+"jo_rnd_rule_lvl"   , "No|Round|Up|Down", "N|R|U|D");			
			InitDataCombo(0, prefix+"jo_fsh_flg"  , "Y|N", "Y|N");
			
			
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

			InitComboNoMatchText(true);
			ComboOpenMode = true; //한번 클릭으로 펼쳐짐
		}
		break;

	}
}

//Pop-up창에서 Close시 호출한다.
function parentSearch() {
	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
//	2013.09.11 LSJ
//	if (!validateForm(sheetObj, formObj, sAction))
//		return;

	switch (sAction) {

	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.WaitImageVisible = true;
		sheetObj.DoSearch("FNS_JOO_0092GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		sheetObj.WaitImageVisible = false;
		break;
	}
}


/* 개발자 작업  끝 */