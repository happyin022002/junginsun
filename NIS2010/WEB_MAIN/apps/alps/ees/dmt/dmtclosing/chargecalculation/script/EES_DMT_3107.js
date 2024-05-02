/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3107.js
*@FileTitle : Calculation Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.10 황효근
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
     * @class EES_DMT_3107 : EES_DMT_3107 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_3107() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0; 

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
					case "btn_Close":
						window.close();
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
	        ComConfigSheet (sheetObjects[i] );
	        initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	}
     
     
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
 	function sheet4_OnLoadFinish() {
 		//sheetObjects[0].WaitImageVisible = false;
 		var formObj = document.form;
   		var sheetObj = sheetObjects[0];
   		
	    doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
            case "sheet1":	// Basic Tariff
                with (sheetObj) {
                    // 높이 설정
                    style.height = 110;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msAll; //msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Basic Tariff|Basic Tariff|F/D|F/Time EXCL|F/Time EXCL|F/Time EXCL|Over|Rate per Day|Rate per Day|Rate per Day|Charge Calculation";
					var HeadTitle2 = "|Appl. Date|Coverage|F/D|SAT|SUN|H/day|Over|Cur.|Over Day|Rate|Charge Calculation";
					//var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,		true,	"ibflag");
                    InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenterTop,	true,	"bzc_trf_aply_dt",	false,	"",	dfDateYmd,		0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenterTop,	true,	"cvrg_cd",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenterTop,	true,	"ft_dys",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtCheckBox,		40,	daCenterTop,	true,	"xcld_sat_flg",		false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenterTop,	true,	"xcld_sun_flg",		false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		50,	daCenterTop,	true,	"xcld_hol_flg",		false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,			60, daCenterTop,	true,	"org_ft_ovr_dys",	false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,			50,	daCenterTop,	true,	"curr_cd",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,			100,daCenter,		true,	"ft_ovr_und_dys",	false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,			80,	daCenter,		true,	"cntr_ft_rt_amt",	false,	"",	dfNullFloat,	2,	false);
                    InitDataProperty(0, cnt++ , dtData,			80,	daRight,		true,	"bzc_chg_calc",		false,	"",	dfNullFloat,	2,	false);

 					CountPosition = 0;
				}
                break;

            case "sheet2":	// Commodity Exception Tariff
                with (sheetObj) {
                    // 높이 설정
                    style.height = 62;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|CMDT Exception Tariff|CMDT Exception Tariff|CMDT Exception Tariff|Add Day|Total Day|F/Time EXCL|F/Time EXCL|F/Time EXCL|Over|Cur.|Amount per CMDT Tariff";
					var HeadTitle2 = "|Appl. Date|CMDT|Rep.|Add Day|Total Day|SAT|SUN|H/day|Over|Cur.|Amount per CMDT Tariff";
					//var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
                    InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"cmdt_expt_aply_dt",	false,	"",	dfDateYmd,		0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"cmdt_cd",				false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"rep_cmdt_cd",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"add_dys",				false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"ttl_dys",				false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	"xcld_sat_flg",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	"xcld_sun_flg",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		50,	daCenter,	true,	"xcld_hol_flg",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			80,	daCenter,	true,	"cmdt_ovr_dys",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			50,	daCenter,	true,	"curr_cd",				false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			130,daRight,	true,	"cmdt_expt_amt",		false,	"",	dfNullFloat,	2,	false);

                    CountPosition = 0;
				}
                break;

            case "sheet3":	// S/C or RFA Exception
                with (sheetObj) {
                    // 높이 설정
                    style.height = 82;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|S/C or RFA Exception|S/C or RFA Exception|Request|APVL|Add|Total|F/Time EXCL|F/Time EXCL|F/Time EXCL|Over|Rate Adjustment|Rate Adjustment|Cur.|Amount per S/C or RFA";
					var HeadTitle2 = "|Appl. Date|S/C or APVL No.|Request|APVL|Add|Total|SAT|SUN|H/day|Over|Cur.|First Tier Rate|Cur.|Amount per S/C or RFA";
					//var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(19, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
                    InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"sc_rfa_expt_aply_dt",	false,	"",	dfDateYmd,		0,	false);
                    InitDataProperty(0,	cnt++ ,	dtPopup,		130,daCenter,	true,	"sc_apvl_no",			false,	"",	dfNone,			0,	true, true);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"rqst_ofc_cd",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			50,	daCenter,	true,	"apro_ofc_cd",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			40,	daCenter,	true,	"add_dys",				false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			40,	daCenter,	true,	"ttl_dys",				false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		35,	daCenter,	true,	"xcld_sat_flg",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		35,	daCenter,	true,	"xcld_sun_flg",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		45,	daCenter,	true,	"xcld_hol_flg",			false,	"",	dfNone,			0,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"sc_rfa_expt_ovr_dys",	false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	"curr_cd",				false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"cntr_ft_rt_amt",		false,	"",	dfNullFloat,	2,	false);
                    InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"bzc_trf_curr_cd",		false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,			110,daRight,	true,	"sc_rfa_expt_amt",		false,	"",	dfNullFloat,	2,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"rqst_usr_nm",			false,  "",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"apro_usr_nm",			false,  "",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"prop_no",				false,  "",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"rfa_expt_dar_no",		false,  "",	dfNone,			0,	false);

                    ImageList(0) = "img/btns_search.gif";
 					ShowButtonImage = 2;
                    
                    CountPosition	= 0;
 					ToolTipOption	= "balloon:true;width:50;";
				}
                break;

            case "sheet4":	// After Booking
                with (sheetObj) {
                    // 높이 설정
                    style.height = 62;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|After Booking|Request|APVL|Add Day|Total Day|F/Time EXCL|F/Time EXCL|F/Time EXCL|Over Day|D/C per Container|D/C per Container|D/C per Container";
					var HeadTitle2 = "|Approval No.|Request|APVL|Add Day|Total Day|SAT|SUN|H/day|Over Day|Cur.|Amount|Ratio(%)";
					//var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(15, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
                    InitDataProperty(0,	cnt++ ,	dtData,			130,daCenter,	true,	"aft_expt_apro_no",	false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"rqst_ofc_cd",		false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			60,	daCenter,	true,	"apro_ofc_cd",		false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"add_dys",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,			70,	daCenter,	true,	"ttl_dys",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	"xcld_sat_flg",		false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	"xcld_sun_flg",		false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		50,	daCenter,	true,	"xcld_hol_flg",		false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"aft_expt_ovr_dys",	false,	"",	dfNone,			0,	false);
                    
                    InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	"curr_cd",			false,	"",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtData,			140,daCenter,	true,	"dc_amt",			false,	"",	dfNullFloat,	2,	false);
                    InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"dc_rto",			false,	"",	dfNullFloat,	2,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"rqst_usr_nm",		false,  "",	dfNone,			0,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	"apro_usr_nm",		false,  "",	dfNone,			0,	false);

 					CountPosition = 0;
 					ToolTipOption="balloon:true;width:50;";
				}
                break;

            case "sheet5":	// Clock Stop
                with (sheetObj) {
                    // 높이 설정
                    style.height = 42;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    var HeadTitle1 = "|Clock Stop No.|From Date|To Date|Stop Day|Remark(s)";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
                    InitDataProperty(0,	cnt++ ,	dtData,		150,	daCenter,	true,	"clk_stop_no",		false,	"",	dfNone,		0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,	daCenter,	true,	"clk_stop_fm_dt",	false,	"",	dfDateYmd,	0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,		100,	daCenter,	true,	"clk_stop_to_dt",	false,	"",	dfDateYmd,	0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,		80,		daCenter,	true,	"stop_day",			false,	"",	dfNone,		0,	false);
                    InitDataProperty(0,	cnt++ ,	dtData,		200,	daLeft,		true,	"clk_stop_rmk",		false,	"",	dfNone,		0,	false);

                    CountPosition = 0;
				}
                break;
                
            case "sheet6":	  // Exception Cost 2012.10.05 추가
            with (sheetObj) {
                // 높이 설정
                style.height = 62;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(2, 1, 3, 100);

				var HeadTitle1 = "|Tariff F/T End DT|F/time End Date|To Movment Date|Exception Days|Rate|Rate|Rate|Cur.|Exception Cost";
				var HeadTitle2 = "|Tariff F/T End DT|F/time End Date|To Movment Date|Exception Days|Cur.|Rate.|Stock|Cur.|Exception Cost";
				//var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(10, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true, false);
                InitHeadRow(1, HeadTitle2, true, false);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,	 daCenter,	true,	"ibflag");
                InitDataProperty(0,	cnt++ ,	dtData,			110, daCenter,	true,	"dmdt_bzc_ft_end_dt",	false,	"",	dfDateYmd,	   0,	false);
                InitDataProperty(0,	cnt++ ,	dtData,			110, daCenter,	true,	"expt_ft_end_dt",		false,	"",	dfDateYmd,	   0,	false);
                InitDataProperty(0,	cnt++ ,	dtData,			110, daCenter,	true,	"to_mvmt_dt",		    false,	"",	dfDateYmd,		0,	false);
                InitDataProperty(0,	cnt++ ,	dtData,			100, daCenter,	true,	"expt_dys",		        false,	"",	dfNone,			0,	false);
                InitDataProperty(0,	cnt++ ,	dtHidden,			40,	 daCenter,	true,	"curr_cd",			    false,	"",	dfNone,			0,	false);
                InitDataProperty(0,	cnt++ ,	dtHidden,			110, daCenter,	true,	"exp_rt_amt",			false,	"",	dfNullFloat,	2,	false);
                InitDataProperty(0,	cnt++ ,	dtHidden,			110, daCenter,	true,	"cntr_cost_stk_amt",	false,	"",	dfNullFloat,	2,	false);
                InitDataProperty(0, cnt++ , dtHidden,	     	40,	 daCenter,	true,	"bzc_trf_curr_cd",		false,	"",	dfNone,			0,	false);
                InitDataProperty(0, cnt++ , dtHidden,		    110, daCenter,	true,	"expt_cost_amt",		false,	"",	dfNullFloat,	2,	false);

					CountPosition = 0;
					ToolTipOption="balloon:true;width:50;";
			}
            break;    

        }
    }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	
	       case IBSEARCH:      //조회
	       		//if(!validateForm(sheetObj,formObj,sAction)) return;
	       		
	       		sheetObj.WaitImageVisible=false;
	       		sheetObjects[0].WaitImageVisible=false;
	       		sheetObjects[1].WaitImageVisible=false;
	       		sheetObjects[2].WaitImageVisible=false;
	       		sheetObjects[3].WaitImageVisible=false;
	       		sheetObjects[4].WaitImageVisible=false;
	       		sheetObjects[5].WaitImageVisible=false;
	       		ComOpenWait(true);
	       
	       		formObj.f_cmd.value = SEARCH;
                sheetObj.DataAutoTrim = false;
                var sXml = sheetObj.GetSearchXml("EES_DMT_3107GS.do", FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                
                sheetObjects[0].LoadSearchXml(arrXml[0]);	// Clock Stop
                sheetObjects[1].LoadSearchXml(arrXml[1]);	// Basic Tariff
                sheetObjects[2].LoadSearchXml(arrXml[2]);	// Commodity Exception Tariff
                sheetObjects[3].LoadSearchXml(arrXml[3]);	// S/C or RFA Exception Tariff
                sheetObjects[4].LoadSearchXml(arrXml[4]);	// After Booking
                sheetObjects[5].LoadSearchXml(arrXml[5]);	// Exception Cost
                ComOpenWait(false);

                var bzcTrfCurrCd = ComGetEtcData(arrXml[0], "bzc_trf_curr_cd");
                
                if (bzcTrfCurrCd != undefined && bzcTrfCurrCd != '') {
	                var bzcTrfCurrCd	= ComGetEtcData(arrXml[0], "bzc_trf_curr_cd");
	                var orgChgAmt		= ComGetEtcData(arrXml[0], "org_chg_amt");
	                var cmdtExptAmt		= ComGetEtcData(arrXml[0], "cmdt_expt_amt");
	                var scRfaExptAmt	= ComGetEtcData(arrXml[0], "sc_rfa_expt_amt");
	                var aftExptDcAmt	= ComGetEtcData(arrXml[0], "aft_expt_dc_amt");
	                var bilAmt			= ComGetEtcData(arrXml[0], "bil_amt");
	                var exptCostAmt		= sheetObjects[5].ComputeSum("expt_cost_amt");

	                var arrObj = formObj.bzc_trf_curr_cd;
	                for(var i=0; i < arrObj.length; i++) {
	                	arrObj[i].value = bzcTrfCurrCd;
	                }
	                formObj.expt_curr_cd.value = "USD";

	                if(cmdtExptAmt == '') cmdtExptAmt = '0';
	                
	                ComSetObjValue(formObj.org_chg_amt, 	ComAddComma2(orgChgAmt+'', "#,###.00"));
	                ComSetObjValue(formObj.cmdt_expt_amt, 	ComAddComma2(cmdtExptAmt+'', "#,###.00"));
	                ComSetObjValue(formObj.sc_rfa_expt_amt, ComAddComma2(scRfaExptAmt+'', "#,###.00"));
	                ComSetObjValue(formObj.aft_expt_dc_amt, ComAddComma2(aftExptDcAmt+'', "#,###.00"));
	                ComSetObjValue(formObj.bil_amt,			ComAddComma2(bilAmt+'', "#,###.00"));
	                ComSetObjValue(formObj.expt_cost_amt,   ComAddComma2(exptCostAmt+'', "#,###.00"));
                }
                
	            break;
	    }
	}
	
	
	// Grid 특정 컬럼에 대해서 말풍선 기능 추가
	function sheet3_OnMouseMove(sheetObj, Button, Shift, X, Y){
		with(sheetObj){
  			Row = MouseRow;
  			Col = MouseCol;
  			if (Row > 0) {
  				var colSaveNm = ColSaveName(Col);
  				if(colSaveNm == 'rqst_ofc_cd')
  					MouseToolTipText = CellValue(Row, "rqst_usr_nm");
  				else if(colSaveNm == 'apro_ofc_cd')
  					MouseToolTipText = CellValue(Row, "apro_usr_nm");
  				else
  					MouseToolTipText = '';
  			}
  		}
  	}
	
	// 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event
	//function sheet3_OnClick(sheetObj, row, col, value, cellX, cellY, cellW, cellH) {
	// 데이터 셀의 팝업 버튼이 눌러졌을 때 발생하는 Event
	function sheet3_OnPopupClick(sheetObj, row, col) {
		with(sheetObj){
			// S/C or APVL No. 데이터셀 더블 클릭시
			if(ColSaveName(col) == 'sc_apvl_no') {
				var scApvlNo = CellValue(row, col);
				if(scApvlNo == '') return;
				
				if(scApvlNo.length <= 10) {
					// S/C Exception Entry 화면 호출
					var propNo = CellValue(row, "prop_no");
					ComOpenPopup('EES_DMT_2001.do?prop_no=' + propNo + '&caller=3107', 1020, 710, "findCustomer", "1,0,1,1,1,1,1", true);
				} else {
					//  Before Booking Approval 화면 호출
					var srcName = 'sheet3';
					var darNo = CellValue(row, "rfa_expt_dar_no");
					ComOpenPopup('EES_DMT_2005P.do?dar_no=' + darNo + '&caller=3107&sheetId=' + srcName, 1020, 645, "findCustomer", "1,0,1,1,1,1,1", true);
				}
			}
		} // with end
	}
	
	
	// Grid 특정 컬럼에 대해서 말풍선 기능 추가
	function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y){
  		with(sheetObj){
  			Row = MouseRow;
  			Col = MouseCol;
  			if (Row > 0) {
  				var colSaveNm = ColSaveName(Col);
  				if(colSaveNm == 'rqst_ofc_cd')
  					MouseToolTipText = CellValue(Row, "rqst_usr_nm");
  				else if(colSaveNm == 'apro_ofc_cd')
  					MouseToolTipText = CellValue(Row, "apro_usr_nm");
  				else
  					MouseToolTipText = '';
  			}
  		}
  	}


	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	    with(formObj){
	    	
	    }
	
	    return true;
	}
    

	/* 개발자 작업  끝 */