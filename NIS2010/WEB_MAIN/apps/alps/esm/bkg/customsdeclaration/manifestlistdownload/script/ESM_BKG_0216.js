/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0216.js
 *@FileTitle : China: Cross-Check & Download
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.23
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2009.08.25 이수빈
 * 1.0 Creation
 * 
 * 1.1 2011.05.23 민정호 [CHM-201110798]China 24hr Manifest 관련 Download 기능 추가
 * 1.2 2011.06.14 민정호 [CHM-201111493]China 24hr Manifest 로직 보완 (Seal)
 * 1.3 2011.07.22 박성진 [CHM-201112024]Split 01-China 24hr Manifest 관련 화면보완 및 추가
 * 1.4 2011.07.25 민정호 [CHM-201112024] Split 01-China 24hr Manifest 관련 화면보완 및 추가
 * 1.5 2011.08.05 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
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
 * @class China: Cross-Check & Download : China: Cross-Check & Download 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function esm_bkg_0216() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
    this.sheet1_OnClick = sheet1_OnClick;
    this.sheet1_OnDblClick = sheet1_OnDblClick;
}

/* 개발자 작업    */

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject1 = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
    /*******************************************************/
    var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_retrieve":
				formObject.check_data_download.value = "1";
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
			
			case "btn_new":
				doActionIBSheet(sheetObject1,formObject,IBRESET);							
			break;
			
			case "btn_save_as":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
			break;	
			
			case "btn_save_csv":
       	 		doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;
			
			case "btn_down":
				doActionIBSheet(sheetObject1,formObject,IBINSERT);
			break;	
			
			case "btn_bkg_main":
				doActionIBSheet(sheetObject1,formObject,IBROWSEARCH);
			break;																											
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
	//화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerForm("Click","obj_Click", document.form);
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	// 중국내 ID 일 경우만 버튼 활성화
	if(!saveCsvFlg){
		ComBtnDisable("btn_save_csv");
	}
	document.form.vvd.focus();
	
}

/**
 * 조회조건 입력할 때 MaxLength까지 입력하면 다음탭으로 이동
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	var srcName = window.event.srcElement.getAttribute("name");
	
	if ( (  srcName == "vvd" || srcName == "pol_cd" ) && ComChkLen(srcValue, srcMaxLength) == "2" ) {
		ComSetNextFocus();
	}
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
 

function obj_Click() {
	var formObject = document.form;
	var currType = formObject.curr_type.value;
	var srcValue = window.event.srcElement.getAttribute("value");
	var srcName = window.event.srcElement.getAttribute("name");
	var sheetObj = sheetObjects[0];
	
	if ( srcName == "trans_type" && currType != srcValue){
		sheetObj.RemoveAll();
		formObject.bl_cnt.value = 0;
		formObject.cntr_cnt.value = 0;
		formObject.curr_type.value = srcValue;
	}
}
/**
 * 조회조건 클릭할 때 값에 따라 데이터 필터링
 */
/*
var orgBlCnt;
var orgCntrCnt;
var currType = 'all';
function obj_Click() {
	
	var formObject = document.form;
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	var srcName = window.event.srcElement.getAttribute("name");
	
	var sheetObj = sheetObjects[0];
	var blCnt = orgBlCnt;
	var cntrCnt = orgCntrCnt;
	
	if ( srcValue == currType ) return false;
	if ( srcName == "trans_type" && sheetObj.TotalRows > 0) {
		//sheetObj.Redraw = false;
		for(var i=2; i<sheetObj.TotalRows+2; i++){
			if( srcValue == "local" ){ 		// LOCAL
				if(sheetObj.CellValue(i,"tr") == "E" || sheetObj.CellValue(i,"tr") == "I"){
					sheetObj.RowHidden(i) = false;
				}
				else{
					sheetObj.RowHidden(i) = true;
					blCnt = blCnt - 1;
					cntrCnt = cntrCnt - parseInt(sheetObj.CellValue(i,"cntr_cnt"));
				}
			}
			else if( srcValue == "ts" ){ 	// T/S
				if(sheetObj.CellValue(i,"tr") == "R" || sheetObj.CellValue(i,"tr") == "T"){
					sheetObj.RowHidden(i) = false;
				}
				else{
					sheetObj.RowHidden(i) = true;
					blCnt = blCnt - 1;
					cntrCnt = cntrCnt - parseInt(sheetObj.CellValue(i,"cntr_cnt"));
				}
			}
			else{ 	// ALL
				sheetObj.RowHidden(i) = false;
				blCnt = orgBlCnt;
				cntrCnt = orgCntrCnt;
			}
		}
		//sheetObj.Redraw = true;
		formObject.bl_cnt.value = ComAddComma(blCnt);
		formObject.cntr_cnt.value = ComAddComma(cntrCnt);
	}
	currType = srcValue;

}
*/


/**
* 시트 초기설정값, 헤더 정의
* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
*/
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch(sheetID) {
	
     	case "sheet1":      //sheet1 init
	        with (sheetObj) {
	            // 높이 설정
	            style.height = 362;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 2, 1, 3, 100);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, true, true, false,false)
	
	            var HeadTitle1 = "|Sel.|Seq.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|SHPR|SHPR|SHPR|SHPR|SHPR|SHPR|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|TP|TR|DG|RF|CNTR|Download\nStatus|Download\nStatus|Transmission Status|Transmission Status|| ";
	            var HeadTitle2 = "|Sel.|Seq.|B/L No.|BKG No.|POL|POD|DEL|Package|Package|Weight|Weight|Seal|Seal|Seal|Nm|Ad|Cnt|St/P|EC|Fax|Eml|Phn|Nm|Ad|Cnt|St/P|UO|Fax|Eml|Phn|Nm|Ad|Cnt|St/P|UO|Fax|Eml|Phn|TP|TR|DG|RF|CNTR|Download\nStatus|Download\nStatus|Transmission Status|Transmission Status|| ";
	            var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	             
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);
	                                 
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtHiddenStatus,	  0, 	daCenter,  	false,    "ibflag");
		        InitDataProperty(0, cnt++ , dtCheckBox,		40, 	daCenter,  	true,     "Chk");
	            InitDataProperty(0, cnt++ , dtDataSeq,	    30, 	daCenter,  	true,     "Seq");     
	            InitDataProperty(0, cnt++ , dtData, 		90,		daCenter,	true,     "bl_no",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		100,	daCenter,	true,     "bkg_no",  		false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,	true,     "pol_cd",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,	true,     "pod_cd",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		50,		daCenter,	true,     "del_cd",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "pck_qty",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "pck_tp_cd",  	false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "act_wgt",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "wgt_ut_cd",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "seal_no_flg",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "seal_knd_flg",	false,    "",  dfNone, 0,   true,	true);	// 추가(0519)
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "sealer_cd_flg",	false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "shpr_nm",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "shpr_addr",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "shpr_cnt",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "shpr_st_po",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "shpr_rgst_no",  	false,    "",  dfNone, 0,   true,	true);

	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "shpr_fax",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "shpr_eml",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "shpr_phn",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "cnee_nm",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "cnee_addr",  	false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "cnee_cnt",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "cnee_st_po",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "cnee_rgst_no",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "cnee_fax",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "cnee_eml",  		false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "cnee_phn",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "ntfy_nm",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "ntfy_addr",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "ntfy_cnt",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		30,		daCenter,	true,     "ntfy_st_po",  	false,    "",  dfNone, 0,   true,	true);

	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "ntfy_rgst_no",  	false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "ntfy_fax",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "ntfy_eml",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "ntfy_phn",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "bkg_cgo_tp_cd",  false,    "",  dfNone, 0,   true,	true);

	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "tr",  			false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "dcgo_flg",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "rc_flg",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		40,		daCenter,	true,     "cntr_cnt",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		25,		daCenter,	true,     "dl_flg",  		false,    "",  dfNone, 0,   true,	true);
	            
	            InitDataProperty(0, cnt++ , dtData, 		75,		daLeft,		true,     "mf_dl_dt", 		false,    "",  dfUserFormat2, 0,   true,	true,	-1,	false,	false);
	            InitDataProperty(0, cnt++ , dtData, 		70,		daCenter,	true,     "trsm_msg_tp_id", false,    "",  dfNone, 0,   true,	true,	-1,	false,	false);
	            InitDataProperty(0, cnt++ , dtData, 		100,	daLeft,		true,     "mf_snd_dt",  	false,    "",  dfUserFormat2, 0,   true,	true,	-1,	false,	false);
	            InitDataProperty(0, cnt++ , dtHidden, 		10,		daLeft,		true,     "dl_chk_flg",  	false);	            
				InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		false,	  "down_csv",		false,	  "",  dfNone,	0,		false,		false);
				
				
				InitUserFormat2(0, "mf_dl_dt", "####-##-## ##:##:##", "-|:" );	
				InitUserFormat2(0, "mf_snd_dt", "####-##-## ##:##:##", "-|:" );	
				
				CountPosition = 0;
				if(document.form.str_pgm_no.value != "ESM_BKG_0216-1") {
					sheetObj.ColHidden("shpr_cnt") = true;
					sheetObj.ColHidden("cnee_cnt") = true;
					sheetObj.ColHidden("ntfy_cnt") = true;
					sheetObj.ColHidden("shpr_st_po") = true;
					sheetObj.ColHidden("cnee_st_po") = true;
					sheetObj.ColHidden("ntfy_st_po") = true;
					sheetObj.ColHidden("shpr_rgst_no") = true;
					sheetObj.ColHidden("cnee_rgst_no") = true;
					sheetObj.ColHidden("ntfy_rgst_no") = true;
					sheetObj.ColHidden("shpr_fax") = true;
					sheetObj.ColHidden("cnee_fax") = true;
					sheetObj.ColHidden("ntfy_fax") = true;
					sheetObj.ColHidden("shpr_eml") = true;
					sheetObj.ColHidden("cnee_eml") = true;
					sheetObj.ColHidden("ntfy_eml") = true;
					sheetObj.ColHidden("shpr_phn") = true;
					sheetObj.ColHidden("cnee_phn") = true;
					sheetObj.ColHidden("ntfy_phn") = true;
				}
				
	        }
            sheetObj.SetMergeCell(0, 44, 2, 2); 
            sheetObj.SetMergeCell(0, 46, 2, 2); 

	        break;

     	case "sheet2":      //sheet1 init
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
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 3, 100);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, true, true, false,false);
	
	            var HeadTitle = "flag||Seq|B/L No.|BKG No.";
	            var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(headCount, 0, 0, true);
	             
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle, true);
	                                 
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	            InitDataProperty(0, cnt++ , dtStatus,	    50, 	daCenter,  	false,    "ibflag"); 
		        InitDataProperty(0, cnt++ , dtCheckBox,		30, 	daCenter,  	true,     "Chk");
	            InitDataProperty(0, cnt++ , dtSeq,	     	30, 	daCenter,  	true,     "Seq");    
	            InitDataProperty(0, cnt++ , dtData, 		90,		daCenter,	true,     "bl_no",  		false,    "",  dfNone, 0,   true,	true);
	            InitDataProperty(0, cnt++ , dtData, 		100,	daCenter,	true,     "bkg_no",  		false,    "",  dfNone, 0,   true,	true);
	        }
	        break;
	}
}

/**
 * 조회 후 처리
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    //document.form.trans_type[0].checked = true;
    
	var tot_cntr = 0;
    var redColor = sheetObj.RgbColor(255, 0, 0);
	for (i=2; i<sheetObj.RowCount+2; i++){
	   	for(j=8; j<39; j++){
			if(sheetObj.CellValue(i, j) == 'N'){
				sheetObj.CellFont("FontColor", i, j) = redColor;
			}
	   	}
	   	tot_cntr = tot_cntr + parseInt(sheetObj.CellValue(i, "cntr_cnt"));
	}
    orgBlCnt = sheetObj.TotalRows;
    orgCntrCnt = tot_cntr;
    document.form.bl_cnt.value = ComAddComma(sheetObj.TotalRows);
    document.form.cntr_cnt.value = ComAddComma(tot_cntr);
}

/**
 * 시트 체크박스 선택 시 Hidden 시트의 같은 Row도 체크 설정
 * @param sheetObj
 * @param row
 * @param col
 * @param val
 * @return
 */
function sheet1_OnChange(sheetObj, row, col, val) {
	var sheetObj2 = sheetObjects[1];
	if(sheetObj.ColSaveName(col) == "Chk"){
		sheetObj2.CellValue2(row-1, "Chk") = sheetObj.CellValue(row, "Chk"); 
	}
}


/**
 * Booking Creation 화면 이동
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col){
//	if (Col <= 0) return;
//	var sParam = "&bl_no="+sheetObj.CellValue(Row,"bl_no")+"&bkg_no="+sheetObj.CellValue(Row,"bkg_no");
//	ComOpenWindowCenter("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079"+sParam, "ESM_BKG_0079", 1024, 660);

	var bkgNo= sheetObj.CellValue(Row,"bkg_no");
	comBkgCallPopBkgDetail(bkgNo);
}

function sheet1_OnMouseMove(Button, Shift, X, Y) {
    if(sheetObjects[0].MouseRow == 1 && sheetObjects[0].MouseCol == 17 ||sheetObjects[0].MouseRow == 1 && sheetObjects[0].MouseCol == 25 ||sheetObjects[0].MouseRow == 1 && sheetObjects[0].MouseCol == 33) {
    	sheetObjects[0].MouseToolTipText = "Country";
    } else if(sheetObjects[0].MouseRow == 1 && sheetObjects[0].MouseCol == 18 || sheetObjects[0].MouseRow == 1 && sheetObjects[0].MouseCol == 26 || sheetObjects[0].MouseRow == 1 && sheetObjects[0].MouseCol == 34) {
    	sheetObjects[0].MouseToolTipText = "Street/P.O.Box";
	} else if(sheetObjects[0].MouseRow == 1 && sheetObjects[0].MouseCol == 19) {
    	sheetObjects[0].MouseToolTipText = "Enterprise Code";
	} else if(sheetObjects[0].MouseRow == 1 && sheetObjects[0].MouseCol == 27 || sheetObjects[0].MouseRow == 1 && sheetObjects[0].MouseCol == 35) {
		sheetObjects[0].MouseToolTipText = "USCI, ORG, Business License No.";
	} else {
		sheetObjects[0].MouseToolTipText = "";
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch(sAction) {

		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = SEARCH;
			formObj.gubun.value = "";
			if(formObj.loc_nm.value == "POL"){
				formObj.loc_cd.value = formObj.pol_cd.value;
			}
			else if(formObj.loc_nm.value == "POD"){
				formObj.loc_cd.value = formObj.pod_cd.value;
			}
			
    		ComOpenWait(true, true);
            sheetObj.Redraw = false;         
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0216GS.do", FormQueryString(formObj));
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	        if(State == "S"){
	        	 var sheetObj2 = sheetObjects[1];  
                 sheetObj.LoadSearchXml(sXml);       
                 sheetObj2.LoadSearchXml(sXml);  
     			 if(sheetObj.TotalRows > 0){ 
     				 if(formObj.check_data_download.value == '1'){
		                 sheetObj.CheckAll2("Chk") = 1;   
		                 sheetObj2.CheckAll2("Chk") = 1;
     				 }
     			 }
                 sheetObj.Redraw = true;
                 document.form.call_sgn_no.value = ComGetEtcData(sXml,"call_sgn_no") == "null" ? "" : ComGetEtcData(sXml,"call_sgn_no"); 
                 document.form.pre_port.value 	 = ComGetEtcData(sXml,"pre_port") 	 == "null" ? "" : ComGetEtcData(sXml,"pre_port"); 
                 document.form.nxt_port.value 	 = ComGetEtcData(sXml,"nxt_port") 	 == "null" ? "" : ComGetEtcData(sXml,"nxt_port"); 
                 document.form.vps_eta_dt.value  = ComGetEtcData(sXml,"vps_eta_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_eta_dt"); 
                 document.form.vps_etd_dt.value  = ComGetEtcData(sXml,"vps_etd_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_etd_dt");
                 document.form.vps_etb_dt.value  = ComGetEtcData(sXml,"vps_etb_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_etb_dt"); 
                 document.form.vsl_eng_nm.value  = ComGetEtcData(sXml,"vsl_eng_nm")  == "null" ? "" : ComGetEtcData(sXml,"vsl_eng_nm");
                 
                 if(formObj.check_data_download.value == '2'){
         			 chkDataDownload(sheetObj, formObj,'2'); 
                 }                 
	        }else{
	        	// 에러메세지 출력
	    		ComShowMessage(ComResultMessage(sXml));
	        }
			 ComOpenWait(false);
		break;

        case IBRESET:        //New
    	    formObj.reset();
    	    sheetObjects[0].RemoveAll();
    	    sheetObjects[1].RemoveAll();
    	    sheetObjects[0].CheckAll2("Chk") = 0;
    	    sheetObjects[1].CheckAll2("Chk") = 0;
    	    formObj.vvd.focus();
    	break;
		
		case IBDOWNEXCEL:        //Save As
		   	if (sheetObj.RowCount == 0 ) {
		   		ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
		   	    return;
		   	} else {
		   	    sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
		   	}
		break;

		case IBSAVE:      //Save CSV
			if(!validateForm(sheetObj,formObj,IBSEARCH)) return false; 
			formObj.f_cmd.value = SEARCH01;
			formObj.gubun.value = "csv";
			
			ComOpenWait(true,true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0216GS.do", FormQueryString(formObj));
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	        if(State == "S"){
			   	if ( ComGetEtcData(sXml,"total") == "0" ) {
		 			//ComOpenWait(false);
			   		ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
			   		ComOpenWait(false);
			   	    return;
			   	} else {
//					formObj.f_cmd.value = COMMAND01;
//					formObj.target = "download";
//					formObj.action = "ESM_BKG_0216_1GS.do?bkg_cgo_tp_cd="+formObj.bkg_cgo_tp_cd.value;
//					formObj.submit();

					ComOpenWait(true);
					formObj.f_cmd.value = COMMAND01;                    
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0216GS.do", FormQueryString(formObj));   					
					var down_csv = ComGetEtcData(sXml, "down_csv");  
					sheetObj.CellText(2, "down_csv") = down_csv;     
					
					var sDate = formObj.date.value;
					var sFileName = "China Cross Check and Download_" + getCurrentTime() + ".csv"
					ComOpenWait(false);
					sheetObj.Down2Text("", "", "34", sFileName, "", "", false, false, true);	
			   	}
	        }
	        else{
                sheetObj.Redraw = false;           
                sheetObj.LoadSearchXml(sXml);   
                sheetObj.Redraw = true;
	        }
	        //ComOpenWait(false); // 종료는 onreadystatechange 이벤트 발생시 처리
		break;
		
		case IBINSERT:      //Download
			//if(!validateForm(sheetObj,formObj,sAction)) return false;		
			var chkNm = Number(sheetObj.CheckedRows(1));
			
			chkDataDownload(sheetObj, formObj,'1');
			
			var reChkNm = Number(sheetObj.CheckedRows(1));
			var gapChkNm = Number(chkNm)-Number(reChkNm);
			
			var unChk = Number(sheetObj.RowCount)-Number(sheetObj.CheckedRows(1)); //unchecked count
			
			if (sheetObj.CheckedRows(1) == 0) {
				//선택된 내역이 없을경우
				ComShowCodeMessage('BKG08192'); // "Seal Information is mandatory. \nPlease insert seal number / kind / code."
	         	return;
			}
														
			if(sheetObj.CheckedRows(1) > 0){
				ComOpenWait(true,true);
				formObj.f_cmd.value = MULTI;

				var sParam = FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString(false);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0216GS.do", sParam);				
				if(ComBkgErrMessage(sheetObjects[0], sXml)) {
					//다운로드 시 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림  3초마다
					var key = ComGetEtcData(sXml, "KEY");					
					intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "','" + unChk + "','" + gapChkNm + "','" + chkNm + "');", 6000);
				}
			}
		break;
		
		case IBROWSEARCH:
			if(sheetObj.TotalRows == 0){
				//선택된 내역이 없을경우
				ComShowCodeMessage('BKG00249'); // No Selected Row
			}else{
				var sParam = "&bl_no="+sheetObj.CellValue(sheetObj.SelectRow,"bl_no")+"&bkg_no="+sheetObj.CellValue(sheetObj.SelectRow,"bkg_no");
				ComOpenWindowCenter("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079"+sParam, "ESM_BKG_0079", 1024, 660);
			}
		break;
	}
}


/**
 * BackEndJob 상태 코드를 3초마다 읽어와서 성공,실패에 따라 처리 
 * @param sheetObj
 * @param sKey
 * @return
 */
function doActionValidationResult(sheetObj, sKey, unChk, gapChkNm, chkNm) {
	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0216GS.do?f_cmd="+MULTI01+"&key="+sKey);	 
    var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

    //에러가 발생했을 경우 대기사항을 종료한다.
    if(!ComBkgErrMessage(sheetObjects[0], sXml)) {
    	clearInterval(intervalId);
        ComOpenWait(false);
        return;        
    }
    
    if (sJbStsFlg == "SUCCESS") {
    	clearInterval(intervalId);
    	ComOpenWait(false);
		//성공메시지 보여주고
		//ComShowMessage(ComResultMessage(sXml));

    	if(gapChkNm<1){
    		ComShowCodeMessage("BKG08194");// Customs Data Created
    	}else{
    		ComShowCodeMessage("BKG00261",gapChkNm);
    	}

   		var aryDl = new Array(sheetObjects[0].RowCount);   		
   		for(var i=2; i < sheetObjects[0].RowCount+2; i++){
   			if(sheetObjects[0].CellValue(i,"Chk") == 1){
   				aryDl[i-2] = 'd';
   			}else{
   				aryDl[i-2] = '';
   			}
   		}    	
    	
		sheetObjects[0].CheckAll("Chk") = 0;
		//sheet1 다시 조회
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		for(var i=0; i < aryDl.length; i++){
			if(aryDl[i] == 'd'){
				sheetObjects[0].CellValue(i+2,'Chk') = '1';
				sheetObjects[1].CellValue(i+1,'Chk') = '1';				
			}else{
				sheetObjects[0].CellValue(i+2,'Chk') = '0';
				sheetObjects[1].CellValue(i+1,'Chk') = '0';				
			}
		}			
		
		return;
    } else if (sJbStsFlg == "FAIL") {
    	//에러
    	clearInterval(intervalId);
    	ComOpenWait(false);
		//에러메시지 보여주고
    	ComShowCodeMessage("BKG08195",chkNm);
		ComShowMessage(ComResultMessage(sXml));
    }
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
    switch (sAction) {
	    case IBSEARCH: // 조회
			if(!ComChkRequired(formObj)) return false;
			if(formObj.trans_mode.value != "D") return true;
			if(formObj.pod_cd.value.substring(0,2) == "CN"){
				if(formObj.pod_cd.value == "CNHKG"){
					ComShowCodeMessage('BKG06036');   // Invalid POD. China port only.
					return false;
				}
			}else{
				ComShowCodeMessage('BKG06036');   // Invalid POD. China port only.
				return false;
			}
	        return true;
	        break;
    }
}


/**
* Data Download 처리 조건
* Seal 항목이 Y,Y,Y 인 경우
*/
function chkDataDownload(sheetObj,formObj, sw){
	formObj.check_data_download.value = "2";
	var chkData = "";
	var iChkCount = 0;
		for(var i=2; i < sheetObj.RowCount+2; i++){
			if(sw == '1'){			
				if(sheetObj.cellvalue(i,'Chk') == '1'){
					if(sheetObj.cellvalue(i,'bkg_cgo_tp_cd') == 'P'){
						iChkCount++;
						sheetObj.cellvalue(i,'Chk') = '1';
					}else{
						if(sheetObj.cellvalue(i,'dl_chk_flg') == 'Y'){
							iChkCount++;
							sheetObj.cellvalue(i,'Chk') = '1';							
						}else{
							chkData = sheetObj.cellvalue(i,'bkg_cgo_tp_cd');
							if(formObj.trans_mode.value == 'P' && (chkData == 'T' || chkData == 'F' || chkData == 'A' )){
//							chkData = formObj.trans_mode.value + sheetObj.cellvalue(i,'pck_qty') 
//							+ sheetObj.cellvalue(i,'pck_tp_cd') + sheetObj.cellvalue(i,'act_wgt') + sheetObj.cellvalue(i,'wgt_ut_cd');
//							if(chkData == 'PYYYY'){
								iChkCount++;
								sheetObj.cellvalue(i,'Chk') = '1';		
							}else{
								sheetObj.cellvalue(i,'Chk') = '0';
							}
						}
					}
				}
			}else{
				if(sheetObj.cellvalue(i,'bkg_cgo_tp_cd') == 'P'){
					iChkCount++;
					sheetObj.cellvalue(i,'Chk') = '1';
				}else{				
					if(sheetObj.cellvalue(i,'dl_chk_flg') == 'Y'){
						iChkCount++;
						sheetObj.cellvalue(i,'Chk') = '1';							
					}else{					
						sheetObj.cellvalue(i,'Chk') = '0';
					}
				}
			}
		}
	if(iChkCount == 0){
		sheetObj.CheckAll2("Chk") = 0; 
	}
}

/**
 * 현재날짜 구한다.
 * @return
 */
function getCurrentTime(){	 
	 var now=new Date(); 
	 var y=now.getFullYear(); // 년도.
	 var mon=now.getMonth()+1; // 월 (월은 0부터 시작므로 +1을 해야 합니다.)
	 var td =now.getDate(); // 일 (일은 1부터 시작하므로 +1을 하면 안 됩니다.)
	 var h =now.getHours(); // 시
	 var min =now.getMinutes(); // 분
	 var s =now.getSeconds(); // 초
	 var ms=now.getMilliseconds(); //밀리세컨드 (1/1000초)
	 
	 if(String(mon).length == 1) mon = '0'+mon;
	 if(String(td).length == 1) td = '0'+td;
	 if(String(h).length == 1) h = '0'+h;
	 if(String(min).length == 1) min = '0'+min;
	 if(String(s).length == 1) s = '0'+s;
	 
	 return y+mon+td+h+min+s;
} 
		
/* 개발자 작업  끝 */