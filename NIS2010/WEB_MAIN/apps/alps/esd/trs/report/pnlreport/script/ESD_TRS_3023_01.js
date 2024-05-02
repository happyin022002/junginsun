/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_TRS_3023_01.js
 *@FileTitle : Profit & Loss Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.03
 *@LastModifier : 
 *@LastVersion : 1.0
===============================================================================
 History
 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 생성
 2012.08.24 변종건 [CHM-201219884-01] TRS - P&L REPORT 기능 추가 보완
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
 * @class ESD_TRS_3023_01 : ESD_TRS_3023_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_3023_01() {
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

//var opener = window.dialogArguments;

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
			case "btn_detail":
				popUpCall("ESD_TRS_3023_02", "M", 0);
				break;
				
			case "btn_downexcel":
				if( formObject.s_view.value == "S" ){
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				} else{
					doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
				}
				break;
				
			case "btn_close":
				window.close();
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
		ComConfigSheetTrs(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	
	//Initializing
	initForm();
	
	initControl();
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
//    axon_event.addListenerFormat('blur',    'obj_blur',     form);	//Blur
//    axon_event.addListenerFormat('focus',   'obj_focus',    form);	//Focus
//    axon_event.addListenerFormat('keypress','obj_keypress', form);	//Key Press 
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
				style.height = GetSheetHeight(26);
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
				InitHeadMode(true, false, true, true, true, false) ;

				var HeadTitle1 = 				"Sts||SEQ|Year|Month|Week|BKG No|BKG\nSplit|BKG Rev\nMerged|Contract\nOffice|RHQ|Service\nScope|Bound|Bound";
					HeadTitle1 = HeadTitle1 + 	"|BKG Route|BKG Route|BKG Route|BKG Route|R/D\nTerm|RFA No|Application\nDate|Customer\nType|Customer\nType|Customer No|Customer\nName|Revenue\nType|Revenue\nType|W/O Office";
					HeadTitle1 = HeadTitle1 + 	"|TTL Cntr in BKG|TTL Cntr in BKG|TTL Cntr in BKG|TTL Box in W/O|TTL Box in W/O|TTL Box in W/O|TTL TEU\nin W/O";
					HeadTitle1 = HeadTitle1 + 	"|Total\nRev(USD)|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type";
					HeadTitle1 = HeadTitle1 + 	"|P&L(USD) by Cost Type|P&L(USD) by Cost Type|P&L(USD) by Cost Type|P&L(USD) by Cost Type";
					HeadTitle1 = HeadTitle1 + 	"|Commodity\nCode|Commodity\nName|P&L Result|P&L Result|P&L Result|P&L Result|P&L Result|P&L Result|P&L Result|P&L Result|TTL Count";
				
				var HeadTitle2 = 				"Sts||SEQ|Year|Month|Week|BKG No|BKG\nSplit|BKG Rev\nMerged|Contract\nOffice|RHQ|Service\nScope|Bound|Bound";
					HeadTitle2 = HeadTitle2 + 	"|POR|POL|POD|DEL|R/D\nTerm|RFA No|Application\nDate|Customer\nType|Customer\nType|Customer No|Customer\nName|Revenue\nType|Revenue\nType|W/O Office";
					HeadTitle2 = HeadTitle2 + 	"|TTL|20'|40'|TTL|20'|40'|TTL TEU\nin W/O";
					HeadTitle2 = HeadTitle2 + 	"|Total\nRev(USD)|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nFull Cost|W/O\nAmount";
					HeadTitle2 = HeadTitle2 + 	"|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nFull Cost|W/O\nAmount";
					HeadTitle2 = HeadTitle2 + 	"|Commodity\nCode|Commodity\nName|IHC Tariff|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nTTL Cost|Cost Table\nFull Cost|Cost Table\nFull Cost|W/O\nAmount|W/O\nAmount|TTL Count";

				var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 7, 0, true);
                
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);

				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,		20,	daCenter,	true,		"ibflag",   					false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtCheckBox,   		40,	daCenter, 	true,    	"chk",  						false, 		"", 		dfNone, 	0, 			true, 		true, 			30, 	false,	 	true, 		"", 		true );
				InitDataProperty(0, cnt++ , dtSeq,   			40, daCenter,  	true,    	"seq",							false,  	"",			dfNone,   	0, 			false,		false,		   100,		false,		true,	   	"",	  		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daCenter, 	true,    	"cost_year",  					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daCenter, 	true,    	"cost_month",   				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"cost_week",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		   100,	daCenter, 	true,    	"bkg_no",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"split_flg",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"bkg_mrg_flg",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"ctrt_ofc_cd",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"rhq_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"svc_scp_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    50,	daCenter, 	true,    	"io_bnd_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    50,	daCenter, 	true,    	"io_bnd_nm",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"por_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"pol_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"pod_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"del_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"rcv_de_term_cd",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    80,	daCenter, 	true,    	"rfa_no",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"rt_aply_dt",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    60,	daCenter, 	true,    	"prc_ctrt_cust_tp_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"prc_ctrt_cust_tp_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    80,	daCenter, 	true,    	"cust_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		   200,	daLeft, 	true,    	"cust_nm",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    60,	daCenter, 	true,    	"inlnd_rev_tp_cd",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"inlnd_rev_tp_nm",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"wo_ofc_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"bkg_cntr_qty",    				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"bkg_20ft_cntr_qty",   			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    50,	daRight, 	true,    	"bkg_40ft_cntr_qty",  			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   	    	50,	daRight, 	true,    	"wo_cntr_qty",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"wo_20ft_cntr_qty",       		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"wo_40ft_cntr_qty",				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"wo_teu_qty", 					false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"bkg_inlnd_chg_amt", 			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"gline_frt_rt_amt",       		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"inlnd_cost_usd_amt",  			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"inlnd_cost_trsp_usd_amt",   	false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"wo_usd_amt",   				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_gline_frt_rt_amt",       	false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_inlnd_cost_usd_amt",       	false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_inlnd_cost_trsp_usd_amt",   false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_wo_usd_amt",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"cmdt_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		   200,	daLeft, 	true,    	"cmdt_nm",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"ihc_pl_rslt_cd",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"ihc_pl_rslt_nm",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"cost_ttl_pl_rslt_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"cost_ttl_pl_rslt_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"cost_full_pl_rslt_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"cost_full_pl_rslt_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"wo_pl_rslt_cd",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"wo_pl_rslt_nm",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"tot_knt",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				
				CellFontColor(0, "pl_gline_frt_rt_amt")     	= RgbColor(255,0,0);
				CellFontColor(0, "pl_inlnd_cost_usd_amt")     	= RgbColor(255,0,0);
				CellFontColor(0, "pl_inlnd_cost_trsp_usd_amt")  = RgbColor(255,0,0);
				CellFontColor(0, "pl_wo_usd_amt")     			= RgbColor(255,0,0);
				CellFontColor(0, "ihc_pl_rslt_cd")     			= RgbColor(255,0,0);
				CellFontColor(0, "ihc_pl_rslt_nm")    			= RgbColor(255,0,0);
				CellFontColor(0, "cost_ttl_pl_rslt_cd")     	= RgbColor(255,0,0);
				CellFontColor(0, "cost_ttl_pl_rslt_nm")     	= RgbColor(255,0,0);
				CellFontColor(0, "cost_full_pl_rslt_cd")     	= RgbColor(255,0,0);
				CellFontColor(0, "cost_full_pl_rslt_nm")    	= RgbColor(255,0,0);
				CellFontColor(0, "wo_pl_rslt_cd")     			= RgbColor(255,0,0);
				CellFontColor(0, "wo_pl_rslt_nm")     			= RgbColor(255,0,0);
				
				CellFontColor(1, "pl_gline_frt_rt_amt")     	= RgbColor(255,0,0);
				CellFontColor(1, "pl_inlnd_cost_usd_amt")     	= RgbColor(255,0,0);
				CellFontColor(1, "pl_inlnd_cost_trsp_usd_amt")  = RgbColor(255,0,0);
				CellFontColor(1, "pl_wo_usd_amt")     			= RgbColor(255,0,0);
				CellFontColor(1, "ihc_pl_rslt_nm")     			= RgbColor(255,0,0);
				CellFontColor(1, "cost_ttl_pl_rslt_nm")     	= RgbColor(255,0,0);
				CellFontColor(1, "cost_full_pl_rslt_nm")     	= RgbColor(255,0,0);
				CellFontColor(1, "wo_pl_rslt_nm")     			= RgbColor(255,0,0);
				CellFontColor(1, "ihc_pl_rslt_cd")     			= RgbColor(255,0,0);
				CellFontColor(1, "ihc_pl_rslt_nm")    			= RgbColor(255,0,0);
				CellFontColor(1, "cost_ttl_pl_rslt_cd")     	= RgbColor(255,0,0);
				CellFontColor(1, "cost_ttl_pl_rslt_nm")     	= RgbColor(255,0,0);
				CellFontColor(1, "cost_full_pl_rslt_cd")     	= RgbColor(255,0,0);
				CellFontColor(1, "cost_full_pl_rslt_nm")    	= RgbColor(255,0,0);
				CellFontColor(1, "wo_pl_rslt_cd")     			= RgbColor(255,0,0);
				CellFontColor(1, "wo_pl_rslt_nm")     			= RgbColor(255,0,0);
			}
			break;
		
		case 2:      //sheet2 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(26);
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
				InitHeadMode(true, false, true, true, true, false) ;
	
				var HeadTitle1 = 				"Sts||SEQ|Year|Month|Week|BKG No|BKG\nSplit|BKG Rev\nMerged|Service\nScope|W/O Office|Bound|Bound";
					HeadTitle1 = HeadTitle1 + 	"|BKG Route|BKG Route|BKG Route|BKG Route|R/D\nTerm|Contract\nOffice|RHQ|RFA No|Application\nDate|Customer\nType|Customer\nType|Customer No|Customer\nName|Revenue\nType|Revenue\nType";
					HeadTitle1 = HeadTitle1 + 	"|TTL Cntr in BKG|TTL Cntr in BKG|TTL Cntr in BKG|TTL Box in W/O|TTL Box in W/O|TTL Box in W/O|TTL TEU\nin W/O";
					HeadTitle1 = HeadTitle1 + 	"|Total\nRev(USD)|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type|Total Cost(USD) by Cost Type";
					HeadTitle1 = HeadTitle1 + 	"|P&L(USD) by Cost Type|P&L(USD) by Cost Type|P&L(USD) by Cost Type|P&L(USD) by Cost Type";
					HeadTitle1 = HeadTitle1 + 	"|Commodity\nCode|Commodity\nName|P&L Result|P&L Result|P&L Result|P&L Result|P&L Result|P&L Result|P&L Result|P&L Result|TTL Count";
				
				var HeadTitle2 = 				"Sts||SEQ|Year|Month|Week|BKG No|BKG\nSplit|BKG Rev\nMerged|Service\nScope|W/O Office|Bound|Bound";
					HeadTitle2 = HeadTitle2 + 	"|POR|POL|POD|DEL|R/D\nTerm|Contract\nOffice|RHQ|RFA No|Application\nDate|Customer\nType|Customer\nType|Customer No|Customer\nName|Revenue\nType|Revenue\nType";
					HeadTitle2 = HeadTitle2 + 	"|TTL|20'|40'|TTL|20'|40'|TTL TEU\nin W/O";
					HeadTitle2 = HeadTitle2 + 	"|Total\nRev(USD)|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nFull Cost|W/O\nAmount";
					HeadTitle2 = HeadTitle2 + 	"|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nFull Cost|W/O\nAmount";
					HeadTitle2 = HeadTitle2 + 	"|Commodity\nCode|Commodity\nName|IHC Tariff|IHC Tariff|Cost Table\nTTL Cost|Cost Table\nTTL Cost|Cost Table\nFull Cost|Cost Table\nFull Cost|W/O\nAmount|W/O\nAmount|TTL Count";
	
				var headCount = ComCountHeadTitle(HeadTitle1);
	
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 7, 0, true);
	            
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
	
				//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, 	dtHiddenStatus,		20,	daCenter,	true,		"ibflag",   					false, 		"", 		dfNone, 	0, 			false, 		false,  		 0, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtCheckBox,   		40,	daCenter, 	true,    	"chk",  						false, 		"", 		dfNone, 	0, 			true, 		true, 			30, 	false,	 	true, 		"", 		true );
				InitDataProperty(0, cnt++ , dtSeq,   			40, daCenter,  	true,    	"seq",							false,  	"",			dfNone,   	0, 			false,		false,		   100,		false,		true,	   	"",	  		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daCenter, 	true,    	"cost_year",  					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daCenter, 	true,    	"cost_month",   				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"cost_week",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		   100,	daCenter, 	true,    	"bkg_no",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"split_flg",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"bkg_mrg_flg",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    60,	daCenter, 	true,    	"svc_scp_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"wo_ofc_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    50,	daCenter, 	true,    	"io_bnd_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"io_bnd_nm",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"por_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"pol_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"pod_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"del_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    50,	daCenter, 	true,    	"rcv_de_term_cd",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"ctrt_ofc_cd",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"rhq_cd",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    80,	daCenter, 	true,    	"rfa_no",      					false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"rt_aply_dt",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    60,	daCenter, 	true,    	"prc_ctrt_cust_tp_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"prc_ctrt_cust_tp_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    80,	daCenter, 	true,    	"cust_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		   200,	daLeft, 	true,    	"cust_nm",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    60,	daCenter, 	true,    	"inlnd_rev_tp_cd",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    60,	daCenter, 	true,    	"inlnd_rev_tp_nm",      		false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"bkg_cntr_qty",    				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"bkg_20ft_cntr_qty",   			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    50,	daRight, 	true,    	"bkg_40ft_cntr_qty",  			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   	    	50,	daRight, 	true,    	"wo_cntr_qty",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"wo_20ft_cntr_qty",       		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"wo_40ft_cntr_qty",				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			50,	daRight, 	true,    	"wo_teu_qty", 					false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   			80,	daRight, 	true,    	"bkg_inlnd_chg_amt", 			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"gline_frt_rt_amt",       		false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"inlnd_cost_usd_amt",  			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"inlnd_cost_trsp_usd_amt",   	false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"wo_usd_amt",   				false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_gline_frt_rt_amt",       	false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_inlnd_cost_usd_amt",       	false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_inlnd_cost_trsp_usd_amt",   false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,   		    80,	daRight, 	true,    	"pl_wo_usd_amt",       			false, 		"", 		dfFloat, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"cmdt_cd",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		   200,	daLeft, 	true,    	"cmdt_nm",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"ihc_pl_rslt_cd",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"ihc_pl_rslt_nm",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"cost_ttl_pl_rslt_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"cost_ttl_pl_rslt_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"cost_full_pl_rslt_cd",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"cost_full_pl_rslt_nm",      	false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"wo_pl_rslt_cd",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtData,  		    70,	daCenter, 	true,    	"wo_pl_rslt_nm",      			false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				InitDataProperty(0, cnt++, 	dtHidden,  		    70,	daCenter, 	true,    	"tot_knt",      				false, 		"", 		dfNone, 	0, 			false, 		false, 			30, 	false,	 	true, 		"", 		false);
				
				CellFontColor(0, "pl_gline_frt_rt_amt")     	= RgbColor(255,0,0);
				CellFontColor(0, "pl_inlnd_cost_usd_amt")     	= RgbColor(255,0,0);
				CellFontColor(0, "pl_inlnd_cost_trsp_usd_amt")  = RgbColor(255,0,0);
				CellFontColor(0, "pl_wo_usd_amt")     			= RgbColor(255,0,0);
				CellFontColor(0, "ihc_pl_rslt_cd")     			= RgbColor(255,0,0);
				CellFontColor(0, "ihc_pl_rslt_nm")    			= RgbColor(255,0,0);
				CellFontColor(0, "cost_ttl_pl_rslt_cd")     	= RgbColor(255,0,0);
				CellFontColor(0, "cost_ttl_pl_rslt_nm")     	= RgbColor(255,0,0);
				CellFontColor(0, "cost_full_pl_rslt_cd")     	= RgbColor(255,0,0);
				CellFontColor(0, "cost_full_pl_rslt_nm")    	= RgbColor(255,0,0);
				CellFontColor(0, "wo_pl_rslt_cd")     			= RgbColor(255,0,0);
				CellFontColor(0, "wo_pl_rslt_nm")     			= RgbColor(255,0,0);
				
				CellFontColor(1, "pl_gline_frt_rt_amt")     	= RgbColor(255,0,0);
				CellFontColor(1, "pl_inlnd_cost_usd_amt")     	= RgbColor(255,0,0);
				CellFontColor(1, "pl_inlnd_cost_trsp_usd_amt")  = RgbColor(255,0,0);
				CellFontColor(1, "pl_wo_usd_amt")     			= RgbColor(255,0,0);
				CellFontColor(1, "ihc_pl_rslt_nm")     			= RgbColor(255,0,0);
				CellFontColor(1, "cost_ttl_pl_rslt_nm")     	= RgbColor(255,0,0);
				CellFontColor(1, "cost_full_pl_rslt_nm")     	= RgbColor(255,0,0);
				CellFontColor(1, "wo_pl_rslt_nm")     			= RgbColor(255,0,0);
				CellFontColor(1, "ihc_pl_rslt_cd")     			= RgbColor(255,0,0);
				CellFontColor(1, "ihc_pl_rslt_nm")    			= RgbColor(255,0,0);
				CellFontColor(1, "cost_ttl_pl_rslt_cd")     	= RgbColor(255,0,0);
				CellFontColor(1, "cost_ttl_pl_rslt_nm")     	= RgbColor(255,0,0);
				CellFontColor(1, "cost_full_pl_rslt_cd")     	= RgbColor(255,0,0);
				CellFontColor(1, "cost_full_pl_rslt_nm")    	= RgbColor(255,0,0);
				CellFontColor(1, "wo_pl_rslt_cd")     			= RgbColor(255,0,0);
				CellFontColor(1, "wo_pl_rslt_nm")     			= RgbColor(255,0,0);
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
	   		formObj.f_cmd.value = SEARCH;
	   		var param = opener.form.s_param.value + "&s_view=" + formObj.s_view.value;
	   		var sXml = sheetObj.GetSearchXml("ESD_TRS_3023_01GS.do", param);
	   		sheetObj.LoadSearchXml(sXml);
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
		case IBDOWNEXCEL:
			//그리드 데이터 없을 경우
			if( sheetObj.RowCount <= 0 ){
				return false;
			}
			break;
	}
	
	return true;
}


/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg) {
	sheetObj.ColFontColor("pl_gline_frt_rt_amt")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("pl_inlnd_cost_usd_amt")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("pl_inlnd_cost_trsp_usd_amt")     = sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("pl_wo_usd_amt")     				= sheetObj.RgbColor(255,0,0);
	
	sheetObj.ColFontColor("ihc_pl_rslt_cd")     			= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("ihc_pl_rslt_nm")     			= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("cost_ttl_pl_rslt_cd")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("cost_ttl_pl_rslt_nm")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("cost_full_pl_rslt_cd")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("cost_full_pl_rslt_nm")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("wo_pl_rslt_cd")     				= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("wo_pl_rslt_nm")     				= sheetObj.RgbColor(255,0,0);
	
	if( document.all.sheetLayer[0].style.display == "inline" ){
//		if( parseInt(sheetObj.CellValue(sheetObj.LastRow, "tot_knt")) > 2000){
//			sheetObj.TotalRows = sheetObj.CellValue(sheetObj.LastRow, "tot_knt");
//			ComShowCodeMessage("TRS90446");
//		}
	}
}
 
function sheet2_OnSearchEnd(sheetObj,errMsg) {
	sheetObj.ColFontColor("pl_gline_frt_rt_amt")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("pl_inlnd_cost_usd_amt")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("pl_inlnd_cost_trsp_usd_amt")     = sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("pl_wo_usd_amt")     				= sheetObj.RgbColor(255,0,0);
	
	sheetObj.ColFontColor("ihc_pl_rslt_cd")     			= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("ihc_pl_rslt_nm")     			= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("cost_ttl_pl_rslt_cd")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("cost_ttl_pl_rslt_nm")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("cost_full_pl_rslt_cd")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("cost_full_pl_rslt_nm")     		= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("wo_pl_rslt_cd")     				= sheetObj.RgbColor(255,0,0);
	sheetObj.ColFontColor("wo_pl_rslt_nm")     				= sheetObj.RgbColor(255,0,0);
	
	if( document.all.sheetLayer[1].style.display == "inline" ){
//		if( parseInt(sheetObj.CellValue(sheetObj.LastRow, "tot_knt")) > 2000){
//			sheetObj.TotalRows = sheetObj.CellValue(sheetObj.LastRow, "tot_knt");
//			ComShowCodeMessage("TRS90446");
//		}
	}
}
 
function sheet1_OnDblClick(sheetObj,Row,Col){
	popUpCall("ESD_TRS_3023_02", "S", Row);
}

function sheet2_OnDblClick(sheetObj,Row,Col){
	popUpCall("ESD_TRS_3023_02", "S", Row);
}

function initForm(){
	if( document.form.s_view.value == "S" ){
		document.all.sheetLayer[0].style.display = "inline";
		document.all.sheetLayer[1].style.display = "none";
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	} else{
		document.all.sheetLayer[0].style.display = "none";
		document.all.sheetLayer[1].style.display = "inline";
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
	}
}

function popUpCall(p_url, p_div, p_row){
	if( document.form.s_view.value == "S" ){
		var sheetObj = sheetObjects[0];
	} else if( document.form.s_view.value == "O" ){
		var sheetObj = sheetObjects[1];
	}
	
	if( sheetObj.RowCount <= 0 ){
		ComShowCodeMessage("COM130401");
		return;
	}
	
	var vStart = ",'";
	var vEnd = "'";
	var sUrl = "/hanjin/ESD_TRS_3023_02.do";
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
	if( arrRow.length - 1 > 200 ){
		ComShowCodeMessage("TRS90448");
		return;
	}
	
	for( var idx = 0; idx < arrRow.length - 1; idx++ ){
		vCond = vCond + vStart + sheetObj.CellValue(arrRow[idx], "bkg_no") + vEnd;
	}
	vCond = vCond.substr(1,vCond.length);
	
	document.form.s_bkg_arr.value = vCond
	var myOption = "width=1024,height=700,menubar=0,status=0,scrollbars=0,resizable=1";
	window.open(sUrl, p_url, myOption);
	
}
/* 개발자 작업  끝 */