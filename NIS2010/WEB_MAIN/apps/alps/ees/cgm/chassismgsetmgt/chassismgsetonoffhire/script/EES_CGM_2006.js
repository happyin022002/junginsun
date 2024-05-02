/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_2006.js
 *@FileTitle : M.G.Set Master Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.09.28
 *@LastModifier : 조경완
 *@LastVersion : 1.0
 * 2009.06.09 박의수
 * 1.0 Creation
 * 2012.09.28 [CHM-201220361-01] 2011514 조경완 M.G.Set Master Inquiry 시, TAB 자동 이동 기능 
 * 2012.09.28 [CHM-201220357-01] 2011514 조경완 Disposal Indicator 추가
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
 * @class ees_cgm_2006 : ees_cgm_2006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_2006() {
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

// 공통전역변수
var tabObjects = new Array();
var tabCnt     = 0;
var beforetab  = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	/** **************************************************** */
	var formObj = document.form;

	try {
	var srcName = window.event.srcElement.getAttribute("name");

	switch (srcName) {

	case "btn_retrieve":
		if(formObj.eq_no.value == "" || formObj.eq_no.value == null){
			ComShowCodeMessage("CGM20023", "M.G.Set No");
			formObj.eq_no.focus();
			return;
		}
		doActionIBSheet(sheetObj2, formObj, IBSEARCH);
		break;

	case "btn_new":
		// 초기화 함수 호출
		objectClear();
		break;

	case "btn_save":
		// M.G.SET NO 알림 메세지  함수 호출
		noneMgsetCall();
		doActionIBSheet(sheetObj2, formObj, IBSAVE);
		break;

	case "btn_chssmvmt":
		var param = "";
	  	if(formObj.eq_no.value != '')
	  	{
		   	formObj.f_cmd.value = SEARCH01;
		   	var sXml = sheetObj2.GetSearchXml("EES_CGM_2006GS.do", FormQueryString(formObj));
		   	var chssNo = ComGetEtcData(sXml,"CHSS_NO");
		   	if(chssNo != null && chssNo != '')
		   	{
		  		var pgmNo = 'EES_CGM_1105';
		  		var pgmUrl = '/hanjin/EES_CGM_1105.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+chssNo ;

		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    	return;
		   	}
	    }
    	//eq_no 없어도 띄워준다.
  		var pgmNo = 'EES_CGM_1105';
  		var pgmUrl = '/hanjin/EES_CGM_1105.do';
  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';
    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;

    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);

    	break;

	case "btn_status":
		var param = "";
	  	if(formObj.eq_no.value != '')
	  	{
	  		var pgmNo = 'EES_CGM_2018';
	  		var pgmUrl = '/hanjin/EES_CGM_2018.do';
	  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';
	    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value;

	    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
	    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
	    }else
	    {
	    	//eq_no 없어도 띄워준다.
	  		var pgmNo = 'EES_CGM_2018';
	  		var pgmUrl = '/hanjin/EES_CGM_2018.do';
	  		var parentPgmNo = pgmNo.substring(0, 8)+'M019';
	    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;

	    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
	    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
	    }
		break;

	case "btn_mnr":
		var param = "";
	  	if(formObj.eq_no.value != '')
	  	{
	  		var pgmNo = 'EES_MNR_0028';
	  		var pgmUrl = '/hanjin/EES_MNR_0028.do';
	  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';
	    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&from_sys=CGM&eq_type=G&eq_no="+formObj.eq_no.value ;

	    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
	    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
	    }else
	    {
		    //eq_no 없어도 띄워준다.
		  	var pgmNo = 'EES_MNR_0028';
		  	var pgmUrl = '/hanjin/EES_MNR_0028.do';
		  	var parentPgmNo = pgmNo.substring(0, 8)+'M001';
		    var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&from_sys=CGM&eq_type=G";

		    var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
		    var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
	    }
	    break;

	case "btn_Calendar_a" :
		var cal = new ComCalendar();
		cal.select(formObj.mft_dt, "yyyy-MM-dd");
		break;

	case "btn_Calendar_b" :
		var cal = new ComCalendar();
		cal.select(formObj.mgst_warr_end_dt, "yyyy-MM-dd");
		break;

	case "btn_delgrid":
		for(var i = sheetObj1.rowCount; i>=1; i--)
		{
			if(sheetObj1.RowStatus(i) == "D") {
				//alert("이미 삭제됨"+sheetObj1.cellValue(i,"cntr_chss" ));
				continue;
			}else
			{
				//alert("삭제대상"+sheetObj1.cellValue(i,"cntr_chss" ));
				sheetObj1.RowStatus(i) = "D";
				sheetObj1.RowHidden(i)= true;		//2.행 숨기기
				break;
			}
		}
		//삭제후 마지막 데이터는 편집가능하게 해줌.
		AtDtUpdateMode();
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
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
    for(i=sheetObjects.length-1; i>=0; i--){
        // 시작 환경 설정 함수 이름 변경
    	ComConfigSheet (sheetObjects[i] );

    	initSheet(sheetObjects[i],i+1);
        // 마지막 환경 설정 함수 추가
    	ComEndConfigSheet(sheetObjects[i]);
    }
}

 /**
  * Sheet2 로딩 후 기본 설정 및 초기화 <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.08.05
  */
 function sheet1_OnLoadFinish(sheetObj) {
	var formObj = document.form;
    sheetObj.WaitImageVisible = false;

    // axon event 등록
	//axon_event.addListener ("click",	"obj_onClick",	"n2nd_chss_als_no_chk");
    axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	formObj);
    axon_event.addListenerFormat("keypress",			"obj_keypress",		form);
    axon_event.addListenerFormat("keyup",               "obj_keyup",        form);
	axon_event.addListenerFormat("beforeactivate",		"obj_activate",		form);
	axon_event.addListener      ("blur",				"obj_blur",			"eq_no", "mft_dt", "mgst_mchn_ser_no", "chss_tare_wgt_kgs", "chss_tare_wgt", "mgst_run_hrs", "mgst_warr_end_dt");
	axon_event.addListener('focusout', 'obj_focusout' , 'eq_no'  ); 
    axon_event.addListener('click', 'pop_atch_cntr', 'atch_cntr');			// atch_cntr popup
    axon_event.addListener('click', 'pop_atch_chs', 'atch_chs');			// atch_chs popup

 	initControl();
	//검색시작
	if(formObj.eq_no.value != "")
	{
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	}

    doActionIBSheet(sheetObj,document.form,IBCLEAR);
    sheetObj.WaitImageVisible = true;
 }

/**
 * 화면 콤보 초기화
 */
function initControl(sheetObj){
	objectClear();

	//그리드 초기화함수 호출
	ibsheetReset();
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
		case "sheet1": // AT/DT
		    with (sheetObj) {

		        // 높이 설정
		        style.height = 182;
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

				var HeadTitle = "|||Seq.|CNTR/CHSS|Attach Date|Attach Date|Attach Yard|Detach Date|Detach Date|Detach Yard";
				var headCount = ComCountHeadTitle(HeadTitle);

		        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		        InitColumnInfo(headCount, 0, 0, true);

		        // 해더에서 처리할 수 있는 각종 기능을 설정한다
		        InitHeadMode(true, true, true, true, false,false)

		        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		        InitHeadRow(0, HeadTitle, true);

		        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		        InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
		        InitDataProperty(0, cnt++ , dtHiddenStatus, 0,		daCenter,	true,	"Sta");
		        InitDataProperty(0,	cnt++,	dtHiddenStatus,	80,		daCenter,	false,	"del_chk");
		        InitDataProperty(0, cnt++ , dtSeq,      	50,		daCenter,	true,	"Seq",     		false,	"",	dfNone);
		        InitDataProperty(0, cnt++ , dtData,			130,    daCenter,	true,	"cntr_chss",    false,	"",	dfNone,0,false,	false);

		        //InitDataProperty(0, cnt++ , dtData,     	180,    daCenter,	true,	"atch_dt",		false,	"",	dfUserFormat2,0,true,	false);
		        InitDataProperty(0, cnt++ , dtData,   	    100, 	daCenter,   true,   "atch_dt_day",  false,	"", dfDateYmd,	0, false,  false);
             	InitDataProperty(0, cnt++ , dtData,   	    70, 	daCenter,   true,   "atch_dt_hd",   false,	"", dfTimeHm, 	0, false,  false);
             	InitDataProperty(0, cnt++ , dtPopupEdit,   	180,    daCenter,	true,	"atch_yd_cd",	false,	"",	dfNone,		0, true,   false);

             	//InitDataProperty(0, cnt++ , dtData,     	180,    daCenter,	true,	"dtch_dt",		false,	"",	dfUserFormat2,0,true,	false);
		        InitDataProperty(0, cnt++ , dtData,   	    100, 	daCenter,   true,   "dtch_dt_day",  false,	"", dfDateYmd,	0, false,  false);
             	InitDataProperty(0, cnt++ , dtData,   	    80, 	daCenter,   true,   "dtch_dt_hd",   false,	"", dfTimeHm, 	0, false,  false);
		        InitDataProperty(0, cnt++ , dtPopupEdit,   	170,    daCenter,	true,	"dtch_yd_cd",	false,	"",	dfNone,		0, true,   false);

		        //InitUserFormat2(0, "atch_dt", "####-##-## ##:##", "-|:" );
		        //InitUserFormat2(0, "dtch_dt", "####-##-## ##:##", "-|:" );

				InitDataValid(0, "atch_yd_cd", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
				InitDataValid(0, "dtch_yd_cd", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
				CountPosition = 0;
		   }
		   break;
    	case "sheet2":
            with (sheetObj) {

	            // 높이 설정
	            style.height = 160;

	            //전체 너비 설정
	            SheetWidth = 200;

	            //Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msNone;

	           //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;

	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 3, 100);

	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, true, true, false,false)

	            var HeadTitle = "|M.G.Set No.|Status|Type|Term|Yard|Manufactured Date|Model No.|Machine Serial No.|Tare Weight(KG)|Tare Weight(lbs)|Voltage|Fuel Capacity|Current Hours| Last Updated Date|Warranty Date|On-Hire Office|On-Hire Date|Agreement No.|Lessor|Reference No.|Created Date|Created By|Updated Date|Updated By|eq_knd_cd|vndr_seq|cntr_chk|chs_chk|bare_chk|damage_chk|atch_cntr|atch_chs|disposal_chk";
                var headCount = ComCountHeadTitle(HeadTitle);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle, true);

	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

	            InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag");
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_no",				false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"aciac_div_cd",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_tpsz_cd",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"agmt_lstm_cd",			false,	"",	dfNone,	0,	false,	false);

	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"crnt_yd_cd",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			150,	daCenter,	true,	"mft_dt",				false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_spec_no",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			150,	daCenter,	true,	"mgst_mchn_ser_no",		false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			150,	daCenter,	true,	"chss_tare_wgt_kgs",	false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			150,	daCenter,	true,	"chss_tare_wgt",		false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"mgst_vltg_capa",		false,	"",	dfNone,	0,	false,	false);

	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"mgst_fuel_capa",		false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"mgst_run_hrs",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"mgst_run_hrs_upd_dt",	false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"mgst_warr_end_dt",		false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"onh_ofc_cd",			false,	"",	dfNone,	0,	false,	false);

	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"onh_dt",				false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"agreement_no",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"vndr_lgl_eng_nm",		false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"agmt_ref_no",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"cre_dt",				false,	"",	dfNone,	0,	false,	false);

	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"cre_usr_id",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"upd_dt",				false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"upd_usr_id",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_knd_cd",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"vndr_seq",				false,	"",	dfNone,	0,	false,	false);

	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"cntr_chk",				false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chs_chk",				false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"bare_chk",				false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"damage_chk",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"atch_cntr",			false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"atch_chs",				false,	"",	dfNone,	0,	false,	false);
	            InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"disposal_chk",			false,	"",	dfNone,	0,	false,	false);

            }
	        break;
    }
}


/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var formObj = document.form;
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];

	switch (sAction) {

		// Search
		case IBSEARCH:
			sheetObj1.WaitImageVisible=false;
			sheetObj2.WaitImageVisible=false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			/* 기존
			sheetObj2.DoSearch("EES_CGM_2006GS.do",FormQueryString(formObj));
			*/
			var sXml = sheetObj.GetSearchXml("EES_CGM_2006GS.do" , FormQueryString(formObj));

			var arrXml = sXml.split("|$$|");
			if(arrXml.length>0)sheetObj2.LoadSearchXml(arrXml[0]); 	// 메인데이터
			if(arrXml.length>1)sheetObj1.LoadSearchXml(arrXml[1]);	// AT/DT


			// 조회 데이타가 없을때 메세지 출력
			if(sheetObj2.rowCount == 0){
				ComShowCodeMessage("CGM20023", formObj.eq_no.value); // chungpa 20090803 MGset not found err msg fix.
				initControl();
				ComOpenWait(false);
				return;
			}

			//chungpa 20100422 AT/DT 수정모드 start
			AtDtUpdateMode();
			//chungpa 20100422 AT/DT 수정모드 end



			// 조회된 그리드 값을 해당 텍스트 필드에 셋팅
			//Basic Info Start
			formObj.eq_no.value               = sheetObj2.CellValue(1, "eq_no");
			formObj.eq_tpsz_cd.value          = sheetObj2.CellValue(1, "eq_tpsz_cd");
			formObj.mft_dt.value              = sheetObj2.CellValue(1, "mft_dt");
			formObj.mgst_warr_end_dt.value    = sheetObj2.CellValue(1, "mgst_warr_end_dt");
			formObj.eq_spec_no.value          = sheetObj2.CellValue(1, "eq_spec_no");
			formObj.mgst_vltg_capa.value      = sheetObj2.CellValue(1, "mgst_vltg_capa");
			formObj.mgst_fuel_capa.value      = sheetObj2.CellValue(1, "mgst_fuel_capa");
			formObj.mgst_mchn_ser_no.value    = sheetObj2.CellValue(1, "mgst_mchn_ser_no");
			if(sheetObj2.CellValue(1, "chss_tare_wgt") == ""){
				formObj.chss_tare_wgt_kgs.value    = ComAddComma(sheetObj2.CellValue(1, "chss_tare_wgt_kgs")); // Weight를 세자리수까지 보여줍니다.
				formObj.chss_tare_wgt.value    = ComAddComma((sheetObj2.CellValue(1, "chss_tare_wgt_kgs").replaceStr(",")*2.2046).toFixed(0)); // KG->lbs 변환 후 Weight를 세자리수까지 보여줍니다.	
			} else {
				formObj.chss_tare_wgt.value    = ComAddComma(sheetObj2.CellValue(1, "chss_tare_wgt")); // Weight를 세자리수까지 보여줍니다.
				formObj.chss_tare_wgt_kgs.value    = ComAddComma((sheetObj2.CellValue(1, "chss_tare_wgt").replaceStr(",")/2.2046).toFixed(0)); // lbs->KG 변환 후 Weight를 세자리수까지 보여줍니다.
			}
			
			formObj.mgst_run_hrs.value        = ComAddComma(sheetObj2.CellValue(1, "mgst_run_hrs"));
			formObj.mgst_run_hrs_upd_dt.value = sheetObj2.CellValue(1, "mgst_run_hrs_upd_dt");
			//Basic Info End

			//On-Hire Status Start
			formObj.aciac_div_cd.value        = sheetObj2.CellValue(1, "aciac_div_cd");
			formObj.crnt_yd_cd.value          = sheetObj2.CellValue(1, "crnt_yd_cd");
			formObj.onh_dt.value              = sheetObj2.CellValue(1, "onh_dt");
			formObj.onh_ofc_cd.value          = sheetObj2.CellValue(1, "onh_ofc_cd");
			formObj.agreement_no.value        = sheetObj2.CellValue(1, "agreement_no");
			formObj.agmt_lstm_cd.value        = sheetObj2.CellValue(1, "agmt_lstm_cd");
			formObj.vndr_lgl_eng_nm.value     = sheetObj2.CellValue(1, "vndr_lgl_eng_nm");
			formObj.agmt_ref_no.value         = sheetObj2.CellValue(1, "agmt_ref_no");
			if(sheetObj.CellValue(1, "cntr_chk") == "Y"){ 			// CNTR 체크박스
				formObj.cntr_chk.checked = true;
			} else {
				formObj.cntr_chk.checked = false;
			}

			if(sheetObj.CellValue(1, "chs_chk") == "Y"){			// CHS 체크박스
				formObj.chs_chk.checked = true;
			} else {
				formObj.chs_chk.checked = false;
			}
			if(sheetObj.CellValue(1, "bare_chk") == "Y"){			// BARE 체크박스
				formObj.bare_chk.checked = true;
			} else {
				formObj.bare_chk.checked = false;
			}

			if(sheetObj.CellValue(1, "damage_chk") == "Y"){			// DAMAGE 체크박스
				formObj.damage_chk.checked = true;
			} else {
				formObj.damage_chk.checked = false;
			}
			//2012.09.28 Disposal 추가
			if(sheetObj.CellValue(1, "disposal_chk") == "Y"){			// DISPOSAL 체크박스
				formObj.disposal_chk.checked = true;
			} else {
				formObj.disposal_chk.checked = false;
			}

			//On-Hire Status End

			//chungpa 20091203 2006 MASTER 추가 항목 start
			formObj.atch_cntr.value 		= sheetObj2.CellValue(1, "atch_cntr");
			formObj.atch_chs.value 			= sheetObj2.CellValue(1, "atch_chs");
			//chungpa 20091203 2006 MASTER 추가 항목 end

			//Basic Info2 Start
			formObj.cre_dt.value              = sheetObj2.CellValue(1, "cre_dt");
			formObj.cre_usr_id.value          = sheetObj2.CellValue(1, "cre_usr_id");
			formObj.upd_dt.value              = sheetObj2.CellValue(1, "upd_dt");
			formObj.upd_usr_id.value          = sheetObj2.CellValue(1, "upd_usr_id");
			//Basic Info2 End


			//체크박스 DISABLE
			formObj.cntr_chk.disabled   = true;
			formObj.chs_chk.disabled  = true;
			formObj.bare_chk.disabled   = true;
			formObj.damage_chk.disabled = true;
			formObj.disposal_chk.disabled = true;

			ComBtnEnable("btn_save");

			ComOpenWait(false);
			break;

		case IBSAVE:
			var sParam = "";
			var sParam1 = "";
			var sParam2 = "";
			sheetObj1.WaitImageVisible=false;
			sheetObj2.WaitImageVisible=false;
			ComOpenWait(true);

			formObj.f_cmd.value = MULTI;
			sParam1 = sheetObjects[0].GetSaveString(false); // true 전체 데이터. false 현재 필요한것은 트랜재션 데이터 "U", "D"만 전달되면 좋겠슴.
			sParam1 = ComSetPrifix(sParam1, "ATDT_");


			sParam2 = sheetObjects[1].GetSaveString(false); // true 전체 데이터. false 현재 필요한것은 트랜재션 데이터 "U", "D"만 전달되면 좋겠슴.
			sParam2 = ComSetPrifix(sParam2, "MASTER_");

			/* chungpa 20100423 main sheet와 at_dt sheet 두개가 있서서 insert/updaet갯수 ask창이 상황에 맞지 않는다.
			if(sheetObj2.DoSave("EES_CGM_2006GS.do",FormQueryString(formObj) ))
 			{
 				ComShowCodeMessage("CGM00003");
 			}else
 			{

 			}*/

			// 메인페이지에 변경된 데이터가 없다.(데이터가 변경되면 'U").
			// 기존에는 변경된 데이터를 체크하기 위해 IBSHEET의 DoSave함수를 사용해서 insert:0,update:0,delete:0 를 자동체크했었슴.
			// 현재는 AT/DT sheet의 변경된 데이터도 같이 처리해야 하기 때문에 DoSave함수를 사용하면 sheet간 충돌이 나는 까닭에
			// GetSaveXml로 쿼리스트링을 묶어서 전달.
			// 이경우 GetSaveXml을 사용하기 때문에 DoSave의 자동 flag함수를 이용할 수 없다.
			// 따라서 ibflag의 값이 'R'(변경없슴)인지 선 체크해야함.

			if(sParam1 == '' && sParam2 == '')
			{
				//sParam1 == ''이면  AT/DT sheet에도 변경된 데이터가 없슴.
				//자동 메시지 처리용. 실제로 TRANSACTION이 발생하는 것은 아니지만,
				//IBSHEET의 NO SAVE데이터 메시지박스 활용.
				if(sheetObj2.DoSave("EES_CGM_2006GS.do",sParam ))
		 		{
		 			ComShowCodeMessage("CGM00003");
		 		}else
		 		{

		 		}
			}else // 메인 sheet 혹은 at/dt sheet 둘중 하나 혹은 전부 데이터 변경사항이 있다.
				  // 결국 체크 로직은 서버단에서 처리해야 한다.
			{
				if( sParam1 == '' ) // AT/DT변경사항없슴.
				{
					formObj.master_save_flag.value = 'MASTERONLY';
					sParam = sParam2+'&'+FormQueryString(formObj);
				}else if( sParam2 == '' ) // M.G.Set Master 변경사항 없슴.
				{

					formObj.master_save_flag.value = 'ATDTONLY';
					sParam = sParam1 + "&" + sParam2+'&'+FormQueryString(formObj);
				}else // M.G.Set Master 와 AT/DT sheet 모두 변경사항있슴.
				{

					formObj.master_save_flag.value = 'ALL';
					sParam = sParam1 + "&" + sParam2+'&'+FormQueryString(formObj);
				}

				// AT/DT수정시 제약사항적용
				// 빈칸이 있으면 안된다.

				if(	formObj.master_save_flag.value == 'ATDTONLY'
				||	formObj.master_save_flag.value == 'ALL' )
				{
					if(checkAtDtValid(sheetObj1,formObj,IBSEARCH)==false)
					{
						ComOpenWait(false);
						return;
					}
				}

				var sXml = sheetObj2.GetSaveXml("EES_CGM_2006GS.do", sParam);
				sheetObj.LoadSaveXml(sXml);

            	var sCheckResult = ComGetEtcData(sXml,"checkResult");

            	if(sCheckResult == COM_VALIDATION_FALSE){

            	} else if(sCheckResult == COM_VALIDATION_TRUE){
            		ComShowCodeMessage("CGM00003"); // SAVE성공
            		AtDtUpdateMode(); 				// 다시 update초기화 org_atch_dt도 갱신할겸.
            	}
			}

			ComOpenWait(false);
			break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}


/**
 * 기본 오브젝트 초기화
 */
function objectClear(){
	var formObj = document.form;
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	// IBSHEET 초기화
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();

	// FORM OBJECT 초기화
	formObj.reset();
	ComBtnDisable("btn_save");
}

/**
 * MGSET NO 항목에서만 Enter 시 Retrieve 실행
 * @author chungpa 20090805
 */
function obj_keyup(){
	obj = event.srcElement;
 	switch(obj.name){
 		case "eq_no":
 		{
 	    	var keyValue = null;
 	        if(event == undefined || event == null) {
 	        	keyValue = 13;
 	        } else {
 	        	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	        }

 	        if(keyValue == 13 || document.form.eq_no.value.length == 10)
 	        {
// 	        	ComKeyEnter('search');
				ComSetNextFocus(obj);
 	        }
  	    	break;
 		}
  	}
}

/**
 * 키 입력 제한(JSP 파일  해당 텍스트 필드에 DATAFORMAT에 셋팅해줌.)
 */
function obj_keypress(){
	 obj = event.srcElement;
	 if(obj.dataformat == null){
		 return;
	 }
	 window.defaultStatus = obj.dataformat;

	 switch(obj.dataformat) {
  	    case "engup":
	        if(obj.name == "eq_no"){
	        	ComKeyOnlyAlphabet("uppernum");
	        }
	        break;
	    case "isnum":
	    	ComKeyOnlyNumber(obj);
	    	break;
	    case "int":
 	    	ComKeyOnlyNumber(obj);
 	        break;
  	 	case "ymd":
  	 		ComKeyOnlyNumber(obj);
  	        break;
	 }
 }


/**
 * AXON 이벤트 처리
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
    //ComIsNumber(event.srcElement, ",");
}


/**
 * OBJECT DEACTIVATE 이벤트에 대한 처리  <br>
 */
function obj_deactivate(){
	var formObj = document.form;
	obj = event.srcElement;

	if(obj.name == "mgst_warr_end_dt"){
		with(formObj){
			var creDtFr = ComReplaceStr(mgst_warr_end_dt.value, "-", "");
			//alert("creDtFr : " + creDtFr);
		}
        ComChkObjValid(event.srcElement);
	} else if(obj.name == "mft_dt"){
		with(formObj){
			var creDtFr = ComReplaceStr(mft_dt.value, "-", "");
			//alert("creDtFr : " + creDtFr);
		}
        ComChkObjValid(event.srcElement);
	}
}

/**
 * Object 의 change 이벤트에 대한 처리 
 */
function obj_focusout() { //2012.09.28 CHM-201220361-01 2011514 조경완 focus out 이벤트 추가 
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	obj = event.srcElement;
	
	switch (obj.name) {
		case "eq_no":
			if(formObj.pop_yn.value == 'N') { // 팝업이 아니면
				if (formObj.eq_no.value != '') {
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
					break;
				}
			}
			
			formObj.pop_yn.value = 'N' // 팝업시 최초 1회만 작동하도록
	}
}

/**
 * 포커스 하이픈 제거(DATAFORMAT "YMD")
 */
function domFunFocusDel(a){
	var formObj = document.form;
	obj = event.srcElement;
	if(obj.name == "mgst_warr_end_dt"  ){
		document.form.mgst_warr_end_dt.value = ComReplaceStr(document.form.mgst_warr_end_dt.value, "-", "");
	} else if(obj.name == "mft_dt"  ){
		document.form.mft_dt.value           = ComReplaceStr(document.form.mft_dt.value, "-", "");
	}
}


/**
 * M.G.SET NO 비어있을 경우 알림 메세지
 */
function noneMgsetCall(){
	var formObj = document.form;
	if(formObj.eq_no.value == "" || formObj.eq_no.value == null){
		ComShowCodeMessage("CGM20023", "M.G.Set No");
		formObj.eq_no.focus();
		return;
	}
}


/**
 * IBSHEET 초기화
 */
function ibsheetReset(){
	var sheetObj = sheetObjects[1];
	sheetObj.RemoveAll();

	var row = sheetObj.DataInsert(0);
	sheetObj.CellValue(1, "eq_knd_cd") = "G";
	sheetObj.RowStatus(1)="R";
}


/**
 * IBSHEET GRID로 값 셋팅
 */
function obj_blur(comboObj, Index_Code, Text){

	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var formObj  = document.form;

	sheetObj2.CellValue(1, "eq_no")            = formObj.eq_no.value;
	sheetObj2.CellValue(1, "mft_dt")           = formObj.mft_dt.value;
	sheetObj2.CellValue(1, "mgst_mchn_ser_no") = formObj.mgst_mchn_ser_no.value;
	sheetObj2.CellValue(1, "chss_tare_wgt") = formObj.chss_tare_wgt.value;
	sheetObj2.CellValue(1, "mgst_run_hrs")     = formObj.mgst_run_hrs.value.replaceStr(",");
	sheetObj2.CellValue(1, "mgst_warr_end_dt") = formObj.mgst_warr_end_dt.value.replaceStr(",");
}


 /**
  * pop_atch_cntr 의 popup 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.12.08
  */
  function pop_atch_cntr(){
	  var formObj = document.form;
	  if(formObj.atch_cntr.value != "")
	  {
		  var formObj = document.form;
		  if(formObj.atch_cntr.value != "")
		  {
				var param = "?pgmNo=EES_CGM_1109";
	   		   	param = param + "&f_cmd=" + SEARCH;
	   			param = param + "&p_cntrno=" + formObj.atch_cntr.value;
	   		    ComOpenPopup('/hanjin/EES_CGM_1109.do' + param, 1080, 600, "", "1,0", true, false);
		  }
	  }
  }

 /**
  * pop_atch_chs 의 popup 이벤트에 대한 처리  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2009.12.08
  */
  function pop_atch_chs(){
 	  var formObj = document.form;
 	  if(formObj.atch_chs.value != "")
 	  {
 			var param = "?pgmNo=EES_CGM_1003";
    		   	param = param + "&f_cmd=" + SEARCH;
    			param = param + "&eq_no=" + formObj.atch_chs.value;
    		    ComOpenPopup('/hanjin/EES_CGM_1003.do' + param, 1080, 600, "", "1,0", true, false);
 	  }
  }
///////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * ATDT 조회후(혹은 삭제후) 가장 마지막 row를 편집가능하게.
 * @param 없음
 * @author 조재성
 * @version 2010.04.23
 */
 function AtDtUpdateMode(){
	 var formObj = document.form;
	 var sheetObj1 = sheetObjects[0];
	 var sheetObj2 = sheetObjects[1];
	 var lastData = 0;

	 //가장 최후의 데이터는 편집가능
	 for(var i = sheetObj1.rowCount; i>=1; i--)
	 {
		 if(sheetObj1.RowStatus(i) == "D") {
			 //alert("이미 삭제됨"+sheetObj1.cellValue(i,"cntr_chss" ));
			 continue;
		 }else
		 {
			 //alert("편집대상"+sheetObj1.cellValue(i,"cntr_chss" ));
			 if(sheetObj1.CellValue(i, "atch_dt_day")=="" || sheetObj1.CellValue(i,"atch_dt_hd")=="")
			 {
				 sheetObj1.RowEditable(i) = false; //atch_dt는 수정시 key값이 되므로 없으면 row자체를 수정불가로 한다.
			 }else
			 {
				 formObj.org_atch_dt.value				= sheetObj1.CellValue(i, "atch_dt_day") + sheetObj1.CellValue(i,"atch_dt_hd");
				 formObj.org_atch_yd_cd.value			= sheetObj1.CellValue(i, "atch_yd_cd");
				 formObj.org_dtch_dt.value				= sheetObj1.CellValue(i, "dtch_dt_day") + sheetObj1.CellValue(i,"dtch_dt_hd");
				 formObj.org_dtch_yd_cd.value			= sheetObj1.CellValue(i, "dtch_yd_cd");

				 //alert( formObj.org_atch_dt.value + " "+ formObj.org_atch_yd_cd.value + " " + formObj.org_dtch_dt.value+ " "+ formObj.org_dtch_yd_cd.value);

				 sheetObj1.RowEditable(i)					= true;
				 sheetObj1.CellEditable(i,"atch_dt_day")	= true;
				 sheetObj1.CellEditable(i,"atch_dt_hd")		= true;

				 if(sheetObj1.CellValue(i, "atch_yd_cd")=="")
					 sheetObj1.CellEditable(i,"atch_yd_cd") = false;
				 else
					 sheetObj1.CellEditable(i,"atch_yd_cd") = true;

				 if(sheetObj1.CellValue(i, "dtch_dt_day")=="" || sheetObj1.CellValue(i, "dtch_dt_hd")=="")
				 {
					 sheetObj1.CellEditable(i,"dtch_dt_day")	= false;
					 sheetObj1.CellEditable(i,"dtch_dt_hd")		= false;
				 }
				 else
				 {
					 sheetObj1.CellEditable(i,"dtch_dt_day")	= true;
					 sheetObj1.CellEditable(i,"dtch_dt_hd")		= true;
				 }

				 if(sheetObj1.CellValue(i, "dtch_yd_cd")=="")
					 sheetObj1.CellEditable(i,"dtch_yd_cd") = false;
				 else
					 sheetObj1.CellEditable(i,"dtch_yd_cd") = true;
			 }

			 sheetObj1.RowStatus(i) = "R";
			 lastData = i;
			 break;
		 }
	 }

	 //나머지는 편집불가
	 for(var j=1; j<=lastData-1; j++)
	 {
		 sheetObj1.RowEditable(j) = false;
	 }
 }

 /**
  * 시트네 팝업 클릭
  * @param sheetObj
  * @param row
  * @param col
  * @author 조재성
  * @version 2010.04.23
  */
 function sheet1_OnPopupClick(sheetObj, row, col){
	switch (sheetObj.ColSaveName(col)) {
       	case "atch_yd_cd" :
       		ComOpenPopup('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
       	    break;
 	    case "dtch_yd_cd" :
 	    	ComOpenPopup('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061&mode=yard' , 800, 475, 'setPrntUsrRoleCd','1,0,1,1,1', true, false, row, col, 0);
 	        break;
	}
}

 /**
  * 시트네 팝업 값 넣기
  * @param aryPopupData
  * @param row
  * @param col
  * @author 조재성
  * @version 2010.04.23
  */
function setPrntUsrRoleCd(aryPopupData, row, col, sheetIdx){
	var sheetObj1 = sheetObjects[0];
	sheetObj1.CellValue2(row, col) = aryPopupData[0][3];
}

/**
 * 선택된 셀이 바뀌었을때 발생하는 Event 처리
 * Agreement No 과 Referece No 의 유효성을 체크한다.
 * @author 조재성
 * @version 2010.04.23
 */
function sheet1_OnChange(sheetObj, Row, Col){
	var formObj = document.form;
	var chk      = true;
	switch (sheetObj.ColSaveName(Col)) {
		case "atch_yd_cd" :
  			formObj.f_cmd.value = COMMAND01;
		   	formObj.yd_cd.value =sheetObj.CellValue(Row, "atch_yd_cd");
		   	if(formObj.yd_cd.value!="")
		   	{
		   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		sheetObj.CellValue(Row, "atch_yd_cd") = "";
			   		sheetObj.SelectCell(Row, Col, true);
			   	} else {

			   	}
		   	}
	 	    break;
	    case "dtch_yd_cd" :
			formObj.f_cmd.value = COMMAND01;
		   	formObj.yd_cd.value =sheetObj.CellValue(Row, "dtch_yd_cd");
		   	if(formObj.yd_cd.value!="")
		   	{
		   		var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");
			   	if(sCheckResult == COM_VALIDATION_FALSE){
			   		ComShowCodeMessage('CGM10009','Yard');
			   		sheetObj.CellValue(Row, "dtch_yd_cd") = "";
			   		sheetObj.SelectCell(Row, Col, true);

			   	} else {

			   	}
		   	}
	 	    break;
	}
}

 /**
  * AT/DT 유효성검증 프로세스 처리 <br>
  * @author 조재성
  * @version 2010.04.23
  */
 function checkAtDtValid(sheetObj1,formObj,sAction){
 	with(formObj){
		switch(sAction){
			case IBSEARCH:
				 //가장 최후의 데이터는 편집가능
				 for(var i = sheetObj1.rowCount; i>=1; i--)
				 {
					 if(sheetObj1.RowStatus(i) == "D") {
						 //alert("이미 삭제됨"+sheetObj1.cellValue(i,"cntr_chss" ));
						 continue;
					 }else
					 {
						 //alert("편집대상"+sheetObj1.cellValue(i,"cntr_chss" ));

						 if( (sheetObj1.cellValue(i,"atch_dt_day") == "" || sheetObj1.cellValue(i,"atch_dt_hd") == "" )
						    && formObj.org_atch_dt.value != ""
						 )
						 {
							 ComShowCodeMessage("CGM10004", "Attach Date");
							 return false;
						 }
						 if(sheetObj1.cellValue(i,"atch_yd_cd") == ""
							 && formObj.org_atch_yd_cd.value != ""
						 )
						 {
							 ComShowCodeMessage("CGM10004", "Attach Yard");
							 return false;
						 }

						 if( (sheetObj1.cellValue(i,"dtch_dt_day") == "" ||sheetObj1.cellValue(i,"dtch_dt_hd") == ""  )
							 && formObj.org_dtch_dt.value != ""
						 )
						 {
							 ComShowCodeMessage("CGM10004", "Detach Date");
							 return false;
						 }
						 if(sheetObj1.cellValue(i,"dtch_yd_cd") == ""
							 && formObj.org_dtch_yd_cd.value != ""
						 )
						 {
							 ComShowCodeMessage("CGM10004", "Detach Yard");
							 return false;
						 }

						 //Row의 Attach date <  바로 이전 Row의 Detach Date  일 경우,
			             if(i>1)
						 {
			            	 if((sheetObj1.cellValue(i,"atch_dt_day") != "") && (sheetObj1.cellValue(i,"atch_dt_hd") != ""))
			            	 {
								 if((sheetObj1.cellValue(i,"atch_dt_day")+sheetObj1.cellValue(i,"atch_dt_hd"))
										 <
								     (sheetObj1.cellValue(i-1,"dtch_dt_day")+sheetObj1.cellValue(i-1,"dtch_dt_hd"))
								 )
								 {
									 ComShowCodeMessage("CGM10084");
									 return false;
								 }
			            	 }
						 }

						 //Row의 Attach date >= Row의 Detach Date 일 경우,
		            	 if((sheetObj1.cellValue(i,"dtch_dt_day") != "") && (sheetObj1.cellValue(i,"dtch_dt_hd") != ""))
		            	 {
							 if((sheetObj1.cellValue(i,"atch_dt_day")+sheetObj1.cellValue(i,"atch_dt_hd"))
									 >
							     (sheetObj1.cellValue(i,"dtch_dt_day")+sheetObj1.cellValue(i,"dtch_dt_hd"))
							 )
							 {
								 ComShowCodeMessage("CGM10084");
								 return false;
							 }
		            	 }

						 break; // for
					 }
				 }
		 	break; // switch
		}
 	}
	return true;
 }


/* 개발자 작업 끝 */
