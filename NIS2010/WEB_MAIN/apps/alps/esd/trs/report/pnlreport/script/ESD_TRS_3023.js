/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_TRS_3023.js
 *@FileTitle : Profit & Loss report for Europe Inland BIZ
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.03
 *@LastModifier : 
 *@LastVersion : 1.0
===============================================================================
 History
 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 생성
 2012.08.24 변종건 [CHM-201219884-01] TRS - P&L REPORT 기능 추가 보완
 2012.11.15 변종건 [CHM-201221435-01] Profit & Loss Report for Europe Inland BIZ 수정
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESD_TRS_3023 : ESD_TRS_3023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_3023() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수 */
//var calPop = new ComCalendarGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var comboObjects = new Array();
var comboCnt = 0 ;
var rdObjects = new Array();

var allClickFlg = false;
var request = null;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_new":
				initForm();
				chkOptTp("P");
				break;

			case "btn_downexcel":
				if( document.form.r_view[0].checked == true ){
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				} else if( document.form.r_view[1].checked == true ){
					doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
				}
				break;
				
			case "btn_ctrt_office1":
				if( formObject.r_prd_bkg_div[0].checked == true ){
					ComOpenPopup('/hanjin/COM_ENS_071.do', 700, 430, 'getCtrtOffice1', '1,0,1,1,1,1,1,1');
				}
				break;
				
			case "btn_wo_office1":
				if( formObject.r_prd_bkg_div[0].checked == true ){
					ComOpenPopup('/hanjin/COM_ENS_071.do', 700, 430, 'getWoOffice1', '1,0,1,1,1,1,1,1');
				}
				break;
				
			case "btn_wo_office2":
				if( formObject.r_prd_bkg_div[0].checked == true ){
					ComOpenPopup('/hanjin/COM_ENS_071.do', 700, 430, 'getWoOffice2', '1,0,1,1,1,1,1,1');
				}
				break;
				
			case "btn_ctrt_office2":
				if( formObject.r_prd_bkg_div[0].checked == true ){
					ComOpenPopup('/hanjin/COM_ENS_071.do', 700, 430, 'getCtrtOffice2', '1,0,1,1,1,1,1,1');
				}
				break;
				
			case "btn_customer":
				if( formObject.r_prd_bkg_div[0].checked == true ){
					ComOpenPopup('/hanjin/COM_ENS_041.do', 900, 410, 'getCustomer', '1,0,1,1,1,1,1,1');
				}
				break;
				
			case "btn_detail":
				//다 건의 팝업 처리
				popUpCall("ESD_TRS_3023_01", "M", 0);
				break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
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
function loadPage(){
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//MultiCombo초기화 
    for(var k=0;k<comboObjects.length;k++){
    	initCombo(comboObjects[k],comboObjects[k].id);
    }
	
	//Initializing
	doActionIBSheet(sheetObjects[2],document.form,SEARCH01);
	
	initControl();
	initForm();
	chkOptTp("P");
	
}

 
/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboId) {
	var formObject = document.form
	var idx = 0;
	if( comboId == "combo_rd_term" ){
		idx = 0;
    	comboObj.InsertItem(idx++, "All", "");
    	comboObj.InsertItem(idx++, "CY", "Y");
    	comboObj.InsertItem(idx++, "Door", "D");
		comboObj.Text = "ALL";
    } else{
    	comboObj.MultiSelect = false;
    	comboObj.UseEdit = true;
    }
}


/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 */
function initControl() {
//    axon_event.addListener('click', 'obj_click', 'manual');    		//Click
//    axon_event.addListener('keyup', 'obj_keyup', 'boo_bkg_no'); 		//Key Up
    axon_event.addListenerFormat('blur',    'obj_blur',     form);	//Blur
//    axon_event.addListenerFormat('focus',   'obj_focus',    form);	//Focus
    axon_event.addListenerFormat('keypress','obj_keypress', form);	//Key Press 
}


/**
 * HTML Control의 objClick이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_click() {
}


/**
 * HTML Control의 objKeyup이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keyup() {
}


/**
 * HTML Control의 onBlur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur(){
	var elementObj = event.srcElement;
	var formObj = document.form;

 	switch(elementObj.name){
 		case "s_cust_cd":
 			if(!isNull(elementObj.value)){
 				if( formObj.s_cust_cd.value != "" && formObj.s_cust_cd.value.length < 3 ){
 					ComShowCodeMessage("COM132201","Customer Code");
 					formObj.s_cust_cd.value = "";
 					return;
 				}
 				
 				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObjects[1].GetSearchXml("ESD_TRS_3023GS.do", FormQueryString(formObj));
				if( ComGetEtcData(sXml, "cust_cd") != undefined && ComGetEtcData(sXml, "cust_nm") != undefined ){
					formObj.s_cust_cd.value = ComGetEtcData(sXml, "cust_cd");
					formObj.s_cust_nm.value = ComGetEtcData(sXml, "cust_nm");
				} else{
					formObj.s_cust_nm.value = "";
				}
 			}
 			break;
 	}
}

/**
 * HTML Control의 onFocus이벤트에서 마스크 구분자를 제거한다. <br>
 */
function obj_focus(){
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function obj_keypress(){
	switch(event.srcElement.dataformat){
		case "engup":		//영문대문자
	 		ComKeyOnlyAlphabet('upper');
	 		break;
	 		
		case "engupnum":	//숫자+"영문대분자"입력하기
			ComKeyOnlyAlphabet('uppernum');
			break;

		case "num":			//숫자 입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		
		case "engnum":		//숫자+"영문대소"입력하기
			ComKeyOnlyAlphabet('num'); 
			break;
			
		case "engupcomma":	//영문대문자+Comma
			ComKeyOnlyAlphabet('upper', '44');
	        break;
		
		default:
	}
}
//Axon 이벤트 처리2. 이벤트처리함수 --- end

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(13);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 24);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, false, true, false, false);

				var HeadTitle1 = 				"Sts|ALL|SEQ|div|grp_no|Contract\nOffice|Service\nScope|Bound|Bound|W/O\nOffice|Customer\nType|Customer\nType|Revenue\nType|Revenue\nType";
					HeadTitle1 = HeadTitle1 + 	"|TTL No\nof BKG|TTL Cntr\nin BKG|TTL Box\nin W/O|TTL TEU\nin W/O|Total\nRev(USD)";
					HeadTitle1 = HeadTitle1 + 	"|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type";
					HeadTitle1 = HeadTitle1 + 	"|P&L(USD) by Cost Type|P&L(USD) by Cost Type|P&L(USD) by Cost Type|P&L(USD) by Cost Type";
				
				var HeadTitle2 = 				"Sts|ALL|SEQ|div|grp_no|Contract\nOffice|Service\nScope|Bound|Bound|W/O\nOffice|Customer\nType|Customer\nType|Revenue\nType|Revenue\nType";
					HeadTitle2 = HeadTitle2 + 	"|TTL No\nof BKG|TTL Cntr\nin BKG|TTL Box\nin W/O|TTL TEU\nin W/O|Total\nRev(USD)";
					HeadTitle2 = HeadTitle2 + 	"|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nFull Cost|W/O\nAmount";
					HeadTitle2 = HeadTitle2 + 	"|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nFull Cost|W/O\nAmount";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 13, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,		20,	daCenter,	true,		"ibflag",   					false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtCheckBox,   		40,	daCenter, 	true,    	"chk",  						false, 		"", 		dfNone, 	0, 			true, 		true, 			30, 	false,	 	true, 		"", 		true );
				InitDataProperty(0, cnt++, 	dtData,   			40,	daCenter, 	true,    	"seq", 							false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		40,	daCenter, 	true,    	"div", 							false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		40,	daCenter, 	true,    	"grp_no", 						false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			60,	daCenter, 	true,    	"ctrt_ofc_cd",  				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			60,	daCenter, 	true,    	"svc_scp_cd",   				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		50,	daCenter, 	true,    	"io_bnd_cd",   					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		50,	daCenter, 	true,    	"io_bnd_nm",   					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"wo_ofc_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"prc_ctrt_cust_tp_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"prc_ctrt_cust_tp_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"inlnd_rev_tp_cd",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"inlnd_rev_tp_nm",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"ttl_no_of_bkg",    			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"bkg_cntr_qty",    				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    50,	daRight, 	true,    	"wo_cntr_qty",  				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   	    	50,	daRight, 	true,    	"wo_teu_qty",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"bkg_inlnd_chg_amt",       		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"gline_frt_rt_amt", 			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"inlnd_cost_usd_amt", 			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"inlnd_cost_trsp_usd_amt", 		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"wo_usd_amt",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_gline_frt_rt_amt",  		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_inlnd_cost_usd_amt",   		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_inlnd_cost_trsp_usd_amt",   false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_wo_usd_amt",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
			}
			break;
		
		
		case 2:      //sheet2 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(13);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 24);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, false, true, false, false) ;
	
				var HeadTitle1 = 				"Sts|ALL|SEQ|div|grp_no|W/O\nOffice|Service\nScope|Bound|Bound|Contract\nOffice|Customer\nType|Customer\nType|Revenue\nType|Revenue\nType"
					HeadTitle1 = HeadTitle1 + 	"|TTL No\nof BKG|TTL Cntr\nin BKG|TTL Box\nin W/O|TTL TEU\nin W/O|Total\nRev(USD)"
					HeadTitle1 = HeadTitle1 + 	"|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type"
					HeadTitle1 = HeadTitle1 + 	"|P&L(USD) by Cost Type|P&L(USD) by Cost Type|P&L(USD) by Cost Type|P&L(USD) by Cost Type";
				
				var HeadTitle2 = 				"Sts|ALL|SEQ|div|grp_no|W/O\nOffice|Service\nScope|Bound|Bound|Contract\nOffice|Customer\nType|Customer\nType|Revenue\nType|Revenue\nType"
					HeadTitle2 = HeadTitle2 + 	"|TTL No\nof BKG|TTL Cntr\nin BKG|TTL Box\nin W/O|TTL TEU\nin W/O|Total\nRev(USD)"
					HeadTitle2 = HeadTitle2 + 	"|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nFull Cost|W/O\nAmount"
					HeadTitle2 = HeadTitle2 + 	"|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nFull Cost|W/O\nAmount"
	
				var headCount = ComCountHeadTitle(HeadTitle1);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 13, 0, true);
	            
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
	
				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,		20,	daCenter,	true,		"ibflag",   					false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtCheckBox,   		40,	daCenter, 	true,    	"chk",  						false, 		"", 		dfNone, 	0, 			true, 		true, 			30, 	false,	 	true, 		"", 		true );
				InitDataProperty(0, cnt++, 	dtData,   			40,	daCenter, 	true,    	"seq", 							false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		40,	daCenter, 	true,    	"div", 							false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		40,	daCenter, 	true,    	"grp_no", 						false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"wo_ofc_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		60,	daCenter, 	true,    	"svc_scp_cd",   				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,   		50,	daCenter, 	true,    	"io_bnd_cd",   					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daCenter, 	true,    	"io_bnd_nm",   					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			60,	daCenter, 	true,    	"ctrt_ofc_cd",  				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"prc_ctrt_cust_tp_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"prc_ctrt_cust_tp_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"inlnd_rev_tp_cd",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"inlnd_rev_tp_nm",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"ttl_no_of_bkg",    			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"bkg_cntr_qty",    				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    50,	daRight, 	true,    	"wo_cntr_qty",  				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   	    	50,	daRight, 	true,    	"wo_teu_qty",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"bkg_inlnd_chg_amt",       		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"gline_frt_rt_amt", 			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"inlnd_cost_usd_amt", 			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"inlnd_cost_trsp_usd_amt", 		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"wo_usd_amt",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_gline_frt_rt_amt",  		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_inlnd_cost_usd_amt",   		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_inlnd_cost_trsp_usd_amt",   false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_wo_usd_amt",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
			}
			break;
			
		case 3:      //sheet3 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(0);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;   //msAll / msPrevColumnMerge / msHeaderOnly
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 23);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, false, true, true, false) ;
	
				var HeadTitle =  "Sts";
	
				var headCount = ComCountHeadTitle(HeadTitle);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	            
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,		20,	daCenter,	true,		"ibflag",   	false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
			}
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, chkflg) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return;
	   		
	   		if( comboObjects[0].Text == "All" ){
	   			formObj.s_svc_scp.value = "";
	   		} else{
	   			formObj.s_svc_scp.value = comboObjects[0].Code;
	   		}
	   		
	   		if( comboObjects[1].Text == "All" ){
	   			formObj.s_cust_tp.value = "";
	   		} else{
	   			formObj.s_cust_tp.value = comboObjects[1].Code;
	   		}
	   		
	   		formObj.s_pnl_div.value = comboObjects[2].Code;
	   		
	   		if( comboObjects[3].Text == "Profit & Loss" ){
	   			formObj.s_pnl_tp.value = "";
	   		} else{
	   			formObj.s_pnl_tp.value = comboObjects[3].Code;
	   		}
	   		
	   		if( comboObjects[4].Text == "All" ){
	   			formObj.s_rev_tp.value = "";
	   		} else{
	   			formObj.s_rev_tp.value = comboObjects[4].Code;
	   		}
	   		
	   		if( comboObjects[5].Text == "All" ){
	   			formObj.s_rd_term.value = "";
	   		} else{
	   			formObj.s_rd_term.value = comboObjects[5].Code;
	   		}
	   		
	   		formObj.f_cmd.value = SEARCH;
	   		formObj.s_search.value = TrsFrmQryString(formObj); //s_search는 호출 된 팝업(ESD_TRS_3023_01)에서 사용할 조회 조건
	   		var sXml = sheetObj.GetSearchXml("ESD_TRS_3023GS.do", TrsFrmQryString(formObj));
	   		var arrXml = sXml.split("|$$|");
	   		sheetObjects[0].LoadSearchXml(arrXml[0]);
	   		sheetObjects[1].LoadSearchXml(arrXml[1]);
	   		break;
	   		
		case SEARCH01:		//Combo List
			if(!validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESD_TRS_3023GS.do", TrsFrmQryString(formObj));
			var arrXml = sXml.split("|$$|");
		  	ComXml2ComboItem(arrXml[0], formObj.combo_svc_scp, "val", "name");
		  	ComXml2ComboItem(arrXml[1], formObj.combo_cust_tp, "val", "name");
		  	ComXml2ComboItem(arrXml[2], formObj.combo_pnl_div, "val", "name");
		  	ComXml2ComboItem(arrXml[3], formObj.combo_pnl_tp, "val", "name");
		  	ComXml2ComboItem(arrXml[4], formObj.combo_rev_tp, "val", "name");
			break;

		case IBDOWNEXCEL:	//Down Excel
			if(!validateForm(sheetObj,formObj,sAction)) return;
			sheetObj.SpeedDown2Excel(-1, false, false);
			break;
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case IBSEARCH:
			if( formObj.r_prd_bkg_div[0].checked == true ){
				//Month 또는 Week의 입력 체크
				if( formObj.f_year.value == "" || formObj.i_fm_wm.value == "" || formObj.i_to_wm.value == "" ){
					if( formObj.f_chkprd[0].checked == true ){
						ComShowCodeMessage("COM130403","Week");
					} else{
						ComShowCodeMessage("COM130403","Month");
					}
					return false;
				}
				
				//Year의 입력 체크
				if( formObj.f_year.value.length != 4 ){
					ComShowCodeMessage("COM132201","Year");
					return false;
				}
				
				//Contract Office / W/O Office 입력 체크
				if( formObj.r_view[0].checked == true ){
					if( formObj.s_ctrt_ofc_cd1.value == "" ){
						ComShowCodeMessage("COM130403","Contract Office Code");
						return false;
					}
				} else{
					if( formObj.s_wo_ofc_cd2.value == "" ){
						ComShowCodeMessage("COM130403","W/O Office Code");
						return false;
					}
				}
				
				//최대 조회 기간 3개월 여부 체크
				var diffDate = ComGetDaysBetween(formObj.s_fm_date, formObj.s_to_date);
				if( diffDate > 91 ){
					ComShowCodeMessage("TRS90391","Three Months");
					return false;
				}
			} else{
				//BKG No 또는 RFA No 입력 여부 체크
				if( formObj.s_bkg_no.value == "" && formObj.s_rfa_no.value == "" ){
					ComShowCodeMessage("COM130403","BKG No");
					return false;
				}
			}
			
			
			break;
		case IBDOWNEXCEL:
			//그리드 데이터 없을 경우
			if( sheetObj.RowCount <= 0 ){
				return false;
			}
			break;
	}
	
	return true;
}


function initForm(){
	comboObjects[0].Text = "All";
	comboObjects[1].Text = "All";
	comboObjects[2].Code = "I";
	comboObjects[3].Text = "Profit & Loss";
	comboObjects[4].Text = "All";
	document.form.reset();
	chkView("S");
	chkWM("M");
	document.getElementById("div_period").innerHTML = "";
}


/**
* 화면 폼입력값에 Null Check
*/
function isNull(itemValue){
   if(itemValue==null || itemValue=="" || itemValue=="undefined"){
   	return true;
   }
   else{
   	return false;
   }
}


/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
	for( var idx = parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
		if( sheetObj.CellValue(idx,"div") == "2" ){
			sheetObj.CellFont("FontBold", idx, "ibflag", idx, "pl_wo_usd_amt") = true;
			sheetObj.RowBackColor(idx) = sheetObj.RgbColor(211,216,250);
		} else if( sheetObj.CellValue(idx,"div") == "3" ){
			sheetObj.CellFont("FontBold", idx, "ibflag", idx, "pl_wo_usd_amt") = true;
			sheetObj.RowBackColor(idx) = sheetObj.RgbColor(166,163,240);
			sheetObj.CellEditable(idx, "chk") = false; 
		}
	}
	allClickFlg = false;
}

function sheet2_OnSearchEnd(sheetObj,errMsg) {
	for( var idx = parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++ ){
		if( sheetObj.CellValue(idx,"div") == "2" ){
			sheetObj.CellFont("FontBold", idx, "ibflag", idx, "pl_wo_usd_amt") = true;
			sheetObj.RowBackColor(idx) = sheetObj.RgbColor(211,216,250);
		} else if( sheetObj.CellValue(idx,"div") == "3" ){
			sheetObj.CellFont("FontBold", idx, "ibflag", idx, "pl_wo_usd_amt") = true;
			sheetObj.RowBackColor(idx) = sheetObj.RgbColor(166,163,240);
			sheetObj.CellEditable(idx, "chk") = false; 
		}
	}
	allClickFlg = false;
}


function sheet1_OnClick(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	
	if( colName == "chk" ){
		if( sheetObj.CellValue(Row,"div") == "1" ){
			var findRow = sheetObj.FindText("grp_no", sheetObj.CellValue(Row, "grp_no"), sheetObj.HeaderRows);
			if( findRow >= sheetObj.HeaderRows ){
				for( var idx = findRow; idx <= sheetObj.LastRow; idx++ ){
					if( sheetObj.CellValue(Row, "grp_no") == sheetObj.CellValue(idx, "grp_no") && sheetObj.CellValue(idx,"div") == "2" ){
						sheetObj.CellValue(idx,"chk") = 0;
						break;
					}
				}
			}
		} else if( sheetObj.CellValue(Row, "div") == "2" ){
			if( sheetObj.CellValue(Row, "chk") == 0 ){
				var findRow = sheetObj.FindText("grp_no", sheetObj.CellValue(Row, "grp_no"), sheetObj.HeaderRows);
				if( findRow >= sheetObj.HeaderRows ){
					for( var idx = findRow; idx <= sheetObj.LastRow; idx++ ){
						if( sheetObj.CellValue(Row, "grp_no") == sheetObj.CellValue(idx, "grp_no") && sheetObj.CellValue(idx, "div") == "1" ){
							sheetObj.CellValue(idx, "chk") = 0;
						}
						if( sheetObj.CellValue(Row, "grp_no") == sheetObj.CellValue(idx, "grp_no") && sheetObj.CellValue(idx, "div") == "2" ){
							break;
						}
					}
				}
			}
		}
	}
}

function sheet2_OnClick(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	
	if( colName == "chk" ){
		if( sheetObj.CellValue(Row,"div") == "1" ){
			var findRow = sheetObj.FindText("grp_no", sheetObj.CellValue(Row, "grp_no"), sheetObj.HeaderRows);
			if( findRow >= sheetObj.HeaderRows ){
				for( var idx = findRow; idx <= sheetObj.LastRow; idx++ ){
					if( sheetObj.CellValue(Row, "grp_no") == sheetObj.CellValue(idx, "grp_no") && sheetObj.CellValue(idx,"div") == "2" ){
						sheetObj.CellValue(idx,"chk") = 0;
						break;
					}
				}
			}
		} else if( sheetObj.CellValue(Row, "div") == "2" ){
			if( sheetObj.CellValue(Row, "chk") == 0 ){
				var findRow = sheetObj.FindText("grp_no", sheetObj.CellValue(Row, "grp_no"), sheetObj.HeaderRows);
				if( findRow >= sheetObj.HeaderRows ){
					for( var idx = findRow; idx <= sheetObj.LastRow; idx++ ){
						if( sheetObj.CellValue(Row, "grp_no") == sheetObj.CellValue(idx, "grp_no") && sheetObj.CellValue(idx, "div") == "1" ){
							sheetObj.CellValue(idx, "chk") = 0;
						}
						if( sheetObj.CellValue(Row, "grp_no") == sheetObj.CellValue(idx, "grp_no") && sheetObj.CellValue(idx, "div") == "2" ){
							break;
						}
					}
				}
			}
		}
	}
}

function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	var row = sheetObj.MouseRow;
	var col = sheetObj.MouseCol;

	//Header의 All Click 여부
	if( (row == 0 || row == 1) && col == 1 ){
		if( allClickFlg == false ){
			allClickFlg = true;
		} else{
			allClickFlg = false;
		}

		if (allClickFlg == true) {
			for( var idx = sheetObj.HeaderRows; idx <= sheetObj.LastRow; idx++ ){
				if( sheetObj.CellValue(idx, "div") == "2" ){
					sheetObj.CellValue2(idx, "chk") = 1;
				} else {
					sheetObj.CellValue2(idx, "chk") = 0;
				}
			}
		} else {
			for( var idx = sheetObj.HeaderRows; idx <= sheetObj.LastRow; idx++ ){
				sheetObj.CellValue2(idx, "chk") = 0;
			}
		}
	}
}

function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	var row = sheetObj.MouseRow;
	var col = sheetObj.MouseCol;

	//Header의 All Click 여부
	if( (row == 0 || row == 1) && col == 1 ){
		if( allClickFlg == false ){
			allClickFlg = true;
		} else{
			allClickFlg = false;
		}

		if (allClickFlg == true) {
			for( var idx = sheetObj.HeaderRows; idx <= sheetObj.LastRow; idx++ ){
				if( sheetObj.CellValue(idx, "div") == "2" ){
					sheetObj.CellValue2(idx, "chk") = 1;
				} else {
					sheetObj.CellValue2(idx, "chk") = 0;
				}
			}
		} else {
			for( var idx = sheetObj.HeaderRows; idx <= sheetObj.LastRow; idx++ ){
				sheetObj.CellValue2(idx, "chk") = 0;
			}
		}
	}
}

function sheet1_OnDblClick(sheetObj, Row, Col, Value){
	//한 건의 팝업 처리
	popUpCall("ESD_TRS_3023_01", "S", Row);
}

function sheet2_OnDblClick(sheetObj, Row, Col, Value){
	//한 건의 팝업 처리
	popUpCall("ESD_TRS_3023_01", "S", Row);
}

function popUpCall(p_url, p_div, p_row){
	if( document.form.r_view[0].checked == true ){
		var view_div = "S";
		var sheetObj = sheetObjects[0];
	} else if( document.form.r_view[1].checked == true ){
		var view_div = "O";
		var sheetObj = sheetObjects[1];
	}
	
	if( sheetObj.RowCount <= 0 ){
		ComShowCodeMessage("COM130401");
		return;
	}
	
	var vStart = ",('";
	var vEnd = "')";
	var vSeparator = "','";
	var sUrl = "/hanjin/ESD_TRS_3023_01.do";
	var param = "?s_view=" + view_div;
	var vCond = "";
	
	if( p_div == "S" ){
		var vCheckRow = p_row+"|";
	} else{
		var vCheckRow = sheetObj.FindCheckedRow("chk");
	}
	var arrRow = vCheckRow.split("|");
	
	if( arrRow.length - 1 <= 0){
		ComShowCodeMessage("COM12177");
		return;
	}
	
	for( var idx = 0; idx < arrRow.length - 1; idx++ ){
		if( sheetObj.CellValue(arrRow[idx], "div") == "1" ){
			//Detail 대상 처리
			vCond = vCond + vStart;
			vCond = vCond + sheetObj.CellValue(arrRow[idx], "ctrt_ofc_cd") + vSeparator;
			vCond = vCond + sheetObj.CellValue(arrRow[idx], "wo_ofc_cd") + vSeparator;
			vCond = vCond + sheetObj.CellValue(arrRow[idx], "prc_ctrt_cust_tp_cd") + vSeparator;
			vCond = vCond + sheetObj.CellValue(arrRow[idx], "inlnd_rev_tp_cd") + vSeparator;
			if( view_div == "S" ){
				vCond = vCond + sheetObj.CellValue(arrRow[idx], "svc_scp_cd") + vEnd;
			} else{
				vCond = vCond + sheetObj.CellValue(arrRow[idx], "io_bnd_cd") + vEnd;
			}
		} else if( sheetObj.CellValue(arrRow[idx], "div") == "2" ){
			//소계 대상 처리
			var findRow = sheetObj.FindText("grp_no", sheetObj.CellValue(arrRow[idx], "grp_no"), sheetObj.HeaderRows);
			for( var jdx = findRow; jdx <= sheetObj.LastRow; jdx++ ){
				if( sheetObj.CellValue(arrRow[idx], "grp_no") == sheetObj.CellValue(jdx, "grp_no") && sheetObj.CellValue(jdx, "div") == "2" ){
					break;
				}
				vCond = vCond + vStart;
				vCond = vCond + sheetObj.CellValue(jdx, "ctrt_ofc_cd") + vSeparator;
				vCond = vCond + sheetObj.CellValue(jdx, "wo_ofc_cd") + vSeparator;
				vCond = vCond + sheetObj.CellValue(jdx, "prc_ctrt_cust_tp_cd") + vSeparator;
				vCond = vCond + sheetObj.CellValue(jdx, "inlnd_rev_tp_cd") + vSeparator;
				if( view_div == "S" ){
					vCond = vCond + sheetObj.CellValue(jdx, "svc_scp_cd") + vEnd;
				} else{
					vCond = vCond + sheetObj.CellValue(jdx, "io_bnd_cd") + vEnd;
				}
			}
		} else if( sheetObj.CellValue(arrRow[idx], "div") == "3" ){
			//Service Scope / Bound 별 총계 대상 처리 
			for( var jdx = sheetObj.HeaderRows; jdx <= sheetObj.LastRow; jdx++ ){
				if( view_div == "S" ){
					var findRow = sheetObj.FindText("svc_scp_cd", sheetObj.CellValue(arrRow[idx], "grp_no"), jdx);
				} else{
					var findRow = sheetObj.FindText("io_bnd_cd", sheetObj.CellValue(arrRow[idx], "grp_no"), jdx);
				}
				
				if( findRow >= sheetObj.HeaderRows ){
					vCond = vCond + vStart;
					vCond = vCond + sheetObj.CellValue(findRow, "ctrt_ofc_cd") + vSeparator;
					vCond = vCond + sheetObj.CellValue(findRow, "wo_ofc_cd") + vSeparator;
					vCond = vCond + sheetObj.CellValue(findRow, "prc_ctrt_cust_tp_cd") + vSeparator;
					vCond = vCond + sheetObj.CellValue(findRow, "inlnd_rev_tp_cd") + vSeparator;
					if( view_div == "S" ){
						vCond = vCond + sheetObj.CellValue(findRow, "svc_scp_cd") + vEnd;
					} else{
						vCond = vCond + sheetObj.CellValue(findRow, "io_bnd_cd") + vEnd;
					}
				}
			}
		}
	}
	
	vCond = vCond.substr(1,vCond.length);
	//s_param 은 팝업 창에서 조회 조건으로 사용(ESD_TRS_3023_01)
	document.form.s_param.value = document.form.s_search.value + "&s_cond=" + vCond;
	var myOption = "width=1024,height=700,menubar=0,status=0,scrollbars=0,resizable=1";
	window.open(sUrl + param, p_url, myOption);
	
}

function getCtrtOffice1(rowArray){
	var colArray = rowArray[0];
	document.form.s_ctrt_ofc_cd1.value = colArray[3];
	document.form.s_ctrt_ofc_cd1.focus();
}

function getWoOffice1(rowArray){
	var colArray = rowArray[0];
	document.form.s_wo_ofc_cd1.value = colArray[3];
	document.form.s_wo_ofc_cd1.focus();
}

function getWoOffice2(rowArray){
	var colArray = rowArray[0];
	document.form.s_wo_ofc_cd2.value = colArray[3];
	document.form.s_wo_ofc_cd2.focus();
}

function getCtrtOffice2(rowArray){
	var colArray = rowArray[0];
	document.form.s_ctrt_ofc_cd2.value = colArray[3];
	document.form.s_ctrt_ofc_cd2.focus();
}

function getCustomer(rowArray){
	var colArray = rowArray[0];
	document.form.s_cust_cd.value = colArray[3];
	document.form.s_cust_nm.value = colArray[4];
	document.form.s_cust_cd.focus();
}

function chkOptTp(param){
	if( param == "P" ){
		for( var idx = 0; idx < document.form.f_chkprd.length; idx++ ){
			document.form.f_chkprd[idx].disabled  = false;
		}
		comboObjects[0].enable = true;
		comboObjects[1].enable = true;
		comboObjects[2].enable = true;
		comboObjects[3].enable = true;
		comboObjects[4].enable = true;
		
		document.form.f_year.className = "input1";
		document.form.i_fm_wm.className = "input1";
		document.form.i_to_wm.className = "input1";
		document.form.s_ctrt_ofc_cd1.className = "input1";
		document.form.c_ctrt_sub_ofc1.disabled = false;
		document.form.s_wo_ofc_cd1.className = "input";
		document.form.s_wo_ofc_cd2.className = "input1";
		document.form.s_io_bnd_cd.disabled = false;
		document.form.s_ctrt_ofc_cd2.className = "input";
		document.form.c_wo_sub_ofc1.disabled = false;
		document.form.s_cust_cd.className = "input";
		
		document.form.s_bkg_no.className = "input2";
		document.form.s_rfa_no.className = "input2";
		
		document.form.f_year.readOnly = false;
		document.form.i_fm_wm.readOnly = false;
		document.form.i_to_wm.readOnly = false;
		document.form.s_ctrt_ofc_cd1.readOnly = false;
		document.form.s_wo_ofc_cd1.readOnly = false;
		document.form.s_wo_ofc_cd2.readOnly = false;
		document.form.s_ctrt_ofc_cd2.readOnly = false;
		document.form.s_cust_cd.readOnly = false;
		document.form.s_bkg_no.readOnly = true;
		document.form.s_rfa_no.readOnly = true;
	} else{
		for( var idx = 0; idx < document.form.f_chkprd.length; idx++ ){
			document.form.f_chkprd[idx].disabled  = true;
		}
		comboObjects[0].enable = false;
		comboObjects[1].enable = false;
		comboObjects[2].enable = false;
		comboObjects[3].enable = false;
		comboObjects[4].enable = false;
		
		document.form.f_year.className = "input2";
		document.form.i_fm_wm.className = "input2";
		document.form.i_to_wm.className = "input2";
		document.form.s_ctrt_ofc_cd1.className = "input2";
		document.form.c_ctrt_sub_ofc1.disabled = true;
		document.form.s_wo_ofc_cd1.className = "input2";
		document.form.s_wo_ofc_cd2.className = "input2";
		document.form.s_io_bnd_cd.disabled = true;
		document.form.s_ctrt_ofc_cd2.className = "input2";
		document.form.c_wo_sub_ofc1.disabled = true;
		document.form.s_cust_cd.className = "input2";
	    
	    document.form.s_bkg_no.className = "input";
	    document.form.s_rfa_no.className = "input";
	    
	    document.form.f_year.readOnly = true;
		document.form.i_fm_wm.readOnly = true;
		document.form.i_to_wm.readOnly = true;
		document.form.s_ctrt_ofc_cd1.readOnly = true;
		document.form.s_wo_ofc_cd1.readOnly = true;
		document.form.s_wo_ofc_cd2.readOnly = true;
		document.form.s_ctrt_ofc_cd2.readOnly = true;
		document.form.s_cust_cd.readOnly = true;
		document.form.s_bkg_no.readOnly = false;
		document.form.s_rfa_no.readOnly = false;
	}
	
	document.form.i_fm_wm.value = "";
	document.form.i_to_wm.value = "";
}

function chkView(param){
	if( param == "S" ){
		document.all.div_sales_view.style.display = "inline";
		document.all.div_operation_view.style.display = "none";
		document.all.sheetLayer[0].style.display = "inline";
		document.all.sheetLayer[1].style.display = "none";
	} else{
		document.all.div_sales_view.style.display = "none";
		document.all.div_operation_view.style.display = "inline";
		document.all.sheetLayer[0].style.display = "none";
		document.all.sheetLayer[1].style.display = "inline";
	}
}
	
function chkWM(param){
	if( param == "W" ){ 		
	    document.getElementById("div_wm").innerHTML = "Week";
	} else{
		document.getElementById("div_wm").innerHTML = "Month";
	}
	
	document.form.i_fm_wm.value = "";
	document.form.i_to_wm.value = "";
}

function setPeriod(obj){
	var formObj = document.form;
	if( obj == null ){
		return;
	}
	
	if( chkValidPeriod() ){
		var sheetObj = sheetObjects[2];
		sheetObj.RemoveEtcData();
		formObj.s_fm_date.value = "";
		formObj.s_to_date.value = "";
		document.getElementById("div_period").innerHTML = ".....";
		formObj.f_cmd.value = SEARCH08;
		sheetObj.DoSearch4Post("ESD_TRS_0999GS.do", TrsFrmQryString(formObj));
		
		var fm_date = sheetObj.EtcData("FM_DATE");
		var to_date = sheetObj.EtcData("TO_DATE");
		
		if( fm_date != null && to_date != null ){
			formObj.s_fm_date.value = doSepRemove(doSepRemove(fm_date, " "), "-");
			formObj.s_to_date.value = doSepRemove(doSepRemove(to_date, " "), "-");
			document.getElementById("div_period").innerHTML = "( " + fm_date + " ~ " + to_date + " )";
//			ComBtnEnable("btn_retrieve");
		}
	}
}

function chkValidPeriod(){
	var formObj = document.form;

	with(formObj){
		if( i_fm_wm.value.length == 1 ){
			i_fm_wm.value = "0" + i_fm_wm.value;
		}
		if( i_to_wm.value.length == 1 ){
			i_to_wm.value = "0" + i_to_wm.value;
		}
		if( f_year.value.length == "" || i_fm_wm.value == "" || i_to_wm.value == "" ){
			return false;
		}
		if( f_year.value.length != 4 ){
			return false;
		}
		if( f_chkprd[1].checked && i_fm_wm.value > i_to_wm.value ){
			ComShowMessage(ComGetMsg("TRS90386","Month of From should be equal to or less than To."));
			i_to_wm.focus();
			return false;
		}	
		if( f_chkprd[0].checked && i_fm_wm.value > i_to_wm.value ){
			ComShowMessage(ComGetMsg("TRS90386","Week of From should be equal to or less than To."));
			i_to_wm.focus();
			return false;
		}
		if( f_chkprd[1].checked ){
			if( ComParseInt(f_year.value) <= 1900
			|| ComParseInt(i_fm_wm.value) <= 0 || ComParseInt(i_fm_wm.value) > 12
			|| ComParseInt(i_to_wm.value) <= 0 || ComParseInt(i_to_wm.value) > 12 ){
				return false;
			}
		}
		if(f_chkprd[0].checked){
			if( ComParseInt(f_year.value) <= 1900
			|| ComParseInt(i_fm_wm.value) <= 0 || ComParseInt(i_fm_wm.value) >= 54
			|| ComParseInt(i_to_wm.value) <= 0 || ComParseInt(i_to_wm.value) >= 54 ){
				return false;
			}
		}
	}
	return true;
}

function createHttpRequest() {
	try{
		request = new XMLHttpRequest();
	} catch(trymicrosoft) {
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(othermicosoft) {
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(failed) {
				request = null;
			}
		}
	}
	if( request == null ) {
		ComShowMessage("Error Request XMLHttp");
	}
}

function chkSubOfc(obj) {
	var ofcCd = "";
	var objOfc;
	if( obj.checked == true ){
		if( obj.name == "c_ctrt_sub_ofc1" ){
			if( document.form.s_ctrt_ofc_cd1.value == "" ){
				obj.checked = false;
				ComShowCodeMessage("COM130201", "Contract Office Code");
				return false;
			}
			ofcCd = document.form.s_ctrt_ofc_cd1.value
			
		} else if( obj.name == "c_wo_sub_ofc1" ){
			if( document.form.s_wo_ofc_cd1.value == "" ){
				obj.checked = false;
				ComShowCodeMessage("COM130201", "W/O Office Code");
				return false;
			}
			ofcCd = document.form.s_wo_ofc_cd1.value
			
		} else if( obj.name == "c_wo_sub_ofc2" ){
			if( document.form.s_wo_ofc_cd2.value == "" ){
				obj.checked = false;
				ComShowCodeMessage("COM130201", "W/O Office Code");
				return false;
			}
			ofcCd = document.form.s_wo_ofc_cd2.value
			
		} else if( obj.name == "c_ctrt_sub_ofc2" ){
			if( document.form.s_ctrt_ofc_cd2.value == "" ){
				obj.checked = false;
				ComShowCodeMessage("COM130201", "Contract Office Code");
				return false;
			}
			ofcCd = document.form.s_ctrt_ofc_cd2.value
		}
		
		var url = "ESD_TRS_0002GS.do?f_cmd="+SEARCH11+"&ctrl_so_office="+ofcCd;
		createHttpRequest();
		request.open("GET", url, false);
		if( obj.name == "c_ctrt_sub_ofc1" ){
			request.onreadystatechange = subCtrtCntrOfc1;
		} else if( obj.name == "c_wo_sub_ofc1" ){
			request.onreadystatechange = subWOCntrOfc1;
		} else if( obj.name == "c_wo_sub_ofc2" ){
			request.onreadystatechange = subWOCntrOfc2;
		} else if( obj.name == "c_ctrt_sub_ofc2" ){
			request.onreadystatechange = subCtrtCntrOfc2;
		}
		request.send(null);	
	} else{
		if( obj.name == "c_ctrt_sub_ofc1" ){
			objOfc = document.form.s_ctrt_ofc_cd1
		} else if( obj.name == "c_wo_sub_ofc1" ){
			objOfc = document.form.s_wo_ofc_cd1
		} else if( obj.name == "c_wo_sub_ofc2" ){
			objOfc = document.form.s_wo_ofc_cd2
		} else if( obj.name == "c_ctrt_sub_ofc2" ){
			objOfc = document.form.s_ctrt_ofc_cd2
		}
		
		if( objOfc.value.length >= 5 ){
			objOfc.value = objOfc.value.substr(0,objOfc.value.indexOf(","))
		}
	}
}

function subCtrtCntrOfc1() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				document.form.c_ctrt_sub_ofc1.checked = false;
				ComShowMessage("No Data!");
			}
			document.form.s_ctrt_ofc_cd1.value = text_ofc.substring(0, text_ofc.length - 1);
		}
	}
}

function subCtrtCntrOfc2() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				document.form.c_ctrt_sub_ofc2.checked = false;
				ComShowMessage("No Data!");
			}
			document.form.s_ctrt_ofc_cd2.value = text_ofc.substring(0, text_ofc.length - 1);
		}
	}
}

function subWOCntrOfc1() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				document.form.c_wo_sub_ofc1.checked = false;
				ComShowMessage("No Data!");
			}
			document.form.s_wo_ofc_cd1.value = text_ofc.substring(0, text_ofc.length - 1);
		}
	}
}

function subWOCntrOfc2() {
	if( request.readyState == 4 ) {
		if( request.status == 200 ) {
			var docXml = request.responseXML;
			var rowXml = docXml.getElementsByTagName("row-count")[0];
			var subXml = null;
			var text_ofc = "";
			for( var n = 0; n < rowXml.firstChild.nodeValue; n++ ) {
				subXml = docXml.getElementsByTagName("sub-office")[n];
				text_ofc = text_ofc+subXml.firstChild.nodeValue+",";
			}
			if( text_ofc.length < 1 ) {
				document.form.c_wo_sub_ofc2.checked = false;
				ComShowMessage("No Data!");
			}
			document.form.s_wo_ofc_cd2.value = text_ofc.substring(0, text_ofc.length - 1);
		}
	}
}
/* 개발자 작업  끝 */