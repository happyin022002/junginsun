/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1004.js
*@FileTitle : Basic Tariff Detail(s) Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.26 김태균
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
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
     * @class EES_DMT_1004 : EES_DMT_1004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_1004() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

	
	//  업무전역변수
	var CONTINENT 	= "CONTI";
	var COUNTRY 	= "CNT";
	var REGION 		= "RGN";
	var STATE 		= "STE";
	var LOCATION 	= "LOC";
	var YARD		= "YD";
	
    var ALL_TARIFF_CD 	= "all_tariff_cd"; 
    var CNTR_CARGE		= "CONTR_CGO";
    
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	var Mincount = 0 ;
	
	
	/*
	 * 콤보에 선택된 항목을 변경할 경우 OnChange 이벤트 발생으로 조회된 결과를 
	 * 상위나 하위 콤보박스에  넣어줄 때 의도적이지 않게 재차발생되어지는 OnChange 이벤트를 막기 위한 변수
	 */
	var isNoChangeActive = false;
	
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
			 	 
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_new":
					initControl();
					break;

 				case "btn_minimize":
                    Mincount = (Mincount+1)%2 ;
                    Minimize(Mincount);
                    break;
					
				case "btn_downexcel":
				    t1901SpeedDownExcel();
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
     // IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
		
        //Axon 이벤트 처리
        initAxonControl();
    }
    
    // 화면 깜빡임때문에 sheet1_OnLoadFinish 이벤트 적용
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj = document.form;
    	
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST08,"","");
    	
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[0]);		//1
//
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[1]);		//2
//
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[2]);			//3
//
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[4]);		//5
//
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[5]);		//6
//
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[6]);			//7
//
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObjects[7]);	//8
//
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH11,CNTR_CARGE,comboObjects[8]);		//9
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

            case "sheet1":      // sheet4 init
                with (sheetObj) {
					// 높이 설정
                	//style.height = 295;
                	style.height = 330;
					SheetWidth = mainTable.clientWidth;

				 	// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					//MergeSheet = msPrevColumnMerge;
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
					

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Tariff\nType|Coverage|ORG/\nDest.|dmdt_de_term_cd|BKG\nTerm|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T EXCL|F/T EXCL|F/T EXCL|Free Time|Free Time|Charge|Charge|Charge|Charge|Charge|Charge|Charge|expire_chk|wknd1|wknd2";
					var HeadTitle2 = "|Tariff\nType|Coverage|ORG/\nDest.|dmdt_de_term_cd|BKG\nTerm|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|Sat|Sun|HOLI|No.of\nCNTR|Free Day|CUR|Over Day|20FT|40FT|H/C|45FT|R9|expire_chk|wknd1|wknd2";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenterTop,	true,		"hdnStatus");
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daCenterTop,	true,		"dmdt_trf_cd",			false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0,	cnt++ ,	dtData,			65,		daCenterTop,	true,		"covrg",				false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0,	cnt++ ,	dtData,			50,		daCenterTop,	true,		"org_dest",				false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtHidden,		50,		daCenterTop,	true,		"dmdt_de_term_cd",		false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenterTop,	true,		"dmdt_de_term_nm",		false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtHidden,       50,     daCenterTop,    true,       "trf_grp_seq");                    
                    InitDataProperty(0, cnt++ , dtData,			200,	daCenterTop,	true,		"dmdt_bzc_trf_grp_nm",	false,		"",		dfNone,	0,	false, false, -1, false, false);

                    InitDataProperty(0, cnt++ , dtData,			100,	daCenterTop,	true,		"eff_dt",				false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,         110,    daCenterTop,    true,       "exp_dt",               false,      "",     dfNone, 0,  false, false, -1, false, false);

                    InitDataProperty(0, cnt++ , dtData,			100,	daCenterTop,	false,		"dmdt_cntr_tp_cd",		false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			120,	daCenterTop,	true,		"dmdt_cgo_tp_cd",		false,		"",		dfNone,	0,	false, false, -1, false, false);
                    
                    InitDataProperty(0, cnt++ , dtData,			130,	daCenterTop,	true,		"dmdt_chg_cmnc_tp_cd",	false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			35,		daCenterTop,	true,		"xcld_sat_flg",			false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			35,		daCenterTop,	true,		"xcld_sun_flg",			false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			35,		daCenterTop,	true,		"xcld_hol_flg",			false,		"",		dfNone,	0,	false, false, -1, false, false);

                    InitDataProperty(0, cnt++ , dtData,			45,		daCenterTop,	true,		"free_time",			false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			65,		daCenterTop,	true,		"ft_dys",				false,		"",		dfNullInteger,		0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			40,		daCenterTop,	true,		"curr_cd",				false,		"",		dfNone,	0,	false, false, -1, false, false);

                    InitDataProperty(0, cnt++ , dtData,			65,		daCenterTop,	true,		"over_day",				false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		true,		"cntr_20ft_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		true,		"cntr_40ft_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		true,		"cntr_hc_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		true,		"cntr_45ft_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		true,		"cntr_r9_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenterTop,	false,		"expire_chk",			false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenterTop,	false,		"wknd1",				false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenterTop,	false,		"wknd2",				false,		"",		dfNone,	0,	false, false, -1, false, false);
                  
                    CountPosition = 0;		// 건수 정보를 표시하지 않음.
                    FrozenCols = SaveNameCol("eff_dt");
                    
			  	}
				break;
				
				
            case "sheet2":      // sheet4 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 302;
                    SheetWidth = mainTable2.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msPrevColumnMerge;
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;
                    

                    // 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "|Tariff\nType|Coverage|ORG/\nDest.|dmdt_de_term_cd|BKG\nTerm|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T Exclusion|F/T Exclusion|F/T Exclusion|Free Time|Free Time|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|expire_chk|wknd1|wknd2";
                    var HeadTitle2 = "|Tariff\nType|Coverage|ORG/\nDest.|dmdt_de_term_cd|BKG\nTerm|trf_grp_seq|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|Sat|Sun|H/day|CNTR\nQ'ty|Free Day|Cur.|Over Day|20FT|40FT|H/C|45FT|R9|expire_chk|wknd1|wknd2";

                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenterTop,       true,       "hdnStatus");
                    InitDataProperty(0, cnt++ , dtData,         60,     daCenterTop,       true,       "dmdt_trf_cd",          false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         65,     daCenterTop,       true,       "covrg",                false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         50,     daCenterTop,       true,       "org_dest",             false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtHidden,		50,		daCenterTop,	   true,	   "dmdt_de_term_cd",		false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenterTop,	   true,	   "dmdt_de_term_nm",		false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtHidden,       50,     daCenterTop,       true,       "trf_grp_seq");
                    InitDataProperty(0, cnt++ , dtData,         200,    daCenterTop,       true,       "dmdt_bzc_trf_grp_nm",  false,      "",     dfNone,     0,  false);

                    InitDataProperty(0, cnt++ , dtData,         100,    daCenterTop,       true,       "eff_dt",               false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         110,    daCenterTop,       true,       "exp_dt",               false,      "",     dfNone,  0,  false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenterTop,       false,       "dmdt_cntr_tp_cd",      false,      "",     dfNone,  0,  false);
                    InitDataProperty(0, cnt++ , dtData,         120,    daCenterTop,       true,       "dmdt_cgo_tp_cd",       false,      "",     dfNone,     0,  false);
                    
                    InitDataProperty(0, cnt++ , dtData,         130,    daCenterTop,       true,       "dmdt_chg_cmnc_tp_cd",  false,      "",     dfNone,  0,  false);
                    InitDataProperty(0, cnt++ , dtData,         35,     daCenterTop,       true,       "xcld_sat_flg",         false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         35,     daCenterTop,       true,       "xcld_sun_flg",         false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         35,     daCenterTop,       true,       "xcld_hol_flg",         false,      "",     dfNone,     0,  false);

                    InitDataProperty(0, cnt++ , dtData,         45,     daCenterTop,       true,       "free_time",            false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         65,     daCenterTop,       true,       "ft_dys",               false,      "",     dfNullInteger,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         40,     daCenterTop,       false,      "curr_cd",              false,      "",     dfNone,     0,  false);

                    InitDataProperty(0, cnt++ , dtData,         65,     daCenterTop,       false,      "over_day",             false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daRightTop,       false,      "cntr_20ft_rt_amt",     false,      "",     dfNullFloat,    2,  false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daRightTop,       false,      "cntr_40ft_rt_amt",     false,      "",     dfNullFloat,    2,  false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daRightTop,       false,      "cntr_hc_rt_amt",       false,      "",     dfNullFloat,    2,  false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daRightTop,       false,      "cntr_45ft_rt_amt",     false,      "",     dfNullFloat,    2,  false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daRightTop,       false,      "cntr_r9_rt_amt",       false,      "",     dfNullFloat,    2,  false);
                    InitDataProperty(0, cnt++ , dtHidden,       100,    daCenterTop,       false,      "expire_chk",           false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtHidden,       100,    daCenterTop,       false,      "wknd1",                false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtHidden,       100,    daCenterTop,       false,      "wknd2",                false,      "",     dfNone,     0,  false);
                    
                    CountPosition = 0;      // 건수 정보를 표시하지 않음.
                    FrozenCols = SaveNameCol("eff_dt");
                    
                }
                break;
        }
    }    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				setParameters(SEARCH);

				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {

						//2.조회전 결과필드들을 Empty 시킨다.
						initResultControls();
						ComSetObjValue(formObj.f_cmd, SEARCH02 ); 

	                    //ComOpenWait Start
	                    sheetObj.WaitImageVisible=false;
	                    ComOpenWait(true);
						
						//2.조회조건으로 조회실행
						sheetObj.DoSearch("EES_DMT_1004GS.do", FormQueryString(formObj));
						
	                    //ComOpenWait End
	                    ComOpenWait(false);

						//3.Expired Validity
						for(var i=0; i<= sheetObj.RowCount+1; i++) {
							
							if(sheetObj.CellValue(i, "expire_chk") == "Y") {
								sheetObj.CellFontColor(i, 5) = sheetObj.RgbColor(255,0,0); 
								sheetObj.CellFontColor(i, 6) = sheetObj.RgbColor(255,0,0); 
								sheetObj.CellFontColor(i, 7) = sheetObj.RgbColor(255,0,0); 
							}
						}
						
						sheetObj.CellValue(1,"xcld_sat_flg") = sheetObj.CellValue(2,"wknd1");
						sheetObj.CellValue(1,"xcld_sun_flg") = sheetObj.CellValue(2,"wknd2");
					}
                    if (sheetObj.id == "sheet2") {
                        
                        ComSetObjValue(formObj.f_cmd, SEARCH02 ); 

	                    //ComOpenWait Start
	                    sheetObj.WaitImageVisible=false;
	                    ComOpenWait(true);

                        //2.조회조건으로 조회실행
                        sheetObj.DoSearch("EES_DMT_1004GS.do", FormQueryString(formObj));
                        
	                    //ComOpenWait End
	                    ComOpenWait(false);

                        //3.Expired Validity
                        for(var i=0; i<= sheetObj.RowCount+1; i++) {
                            
                            if(sheetObj.CellValue(i, "expire_chk") == "Y") {
                                sheetObj.CellFontColor(i, 5) = sheetObj.RgbColor(255,0,0); 
                                sheetObj.CellFontColor(i, 6) = sheetObj.RgbColor(255,0,0); 
                                sheetObj.CellFontColor(i, 7) = sheetObj.RgbColor(255,0,0); 
                            }
                        }
                        
                        sheetObj.CellValue(1,"xcld_sat_flg") = sheetObj.CellValue(2,"wknd1");
                        sheetObj.CellValue(1,"xcld_sun_flg") = sheetObj.CellValue(2,"wknd2");
                    }
				}
				break;	

		case IBDOWNEXCEL:	// EXCEL DOWNLOAD
			if (sheetObj.id == "sheet1") {
				sheetObj.SpeedDown2Excel(-1);
			}; 
			break;
		}			
    }    
    
	function initAxonControl() {  
	    //Axon 이벤트 처리1. 이벤트catch 
		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('blur',	'obj_blur',		form); //- 포커스 나갈때
		axon_event.addListenerFormat('keypress',		'obj_keypress',    form); //- 키보드 입력할때
		axon_event.addListener('keydown', 'obj_keydown',  'cvrg_location', 'yd_cd1', 'org_dest_location');	//Enter시 자동Retrieve

	}
		   
	//Axon 이벤트 처리2. 이벤트처리함수  
	/*
	 * Location 필드 입력문자 대문자로 변환 
	 */		
	function obj_keypress(){ 
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	         
	    switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
	            break;   
	    }   
	}
	
	/*
	 * Location FocusOut시 입력값 자리수에 대한 Validation Check
	 */
	function obj_blur() {
		obj = event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage('DMT00110');
			ComClearObject(obj);
			ComSetFocus(obj);
		}
	}
	
	function obj_keydown() {
		if(event.keyCode == 13) {
			//obj = event.srcElement;
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 /*
    	//Coverage Continent Valid check
    	if(ComTrim(ComGetObjValue(formObj.cvrg_conti_cd)) == "") {
    		ComAlertFocus(formObj.combo1, ComGetMsg('COM12113', "Coverage Continent"));
    		return false;
    	}
    	
    	//Coverage Country Valid check
    	if(ComTrim(ComGetObjValue(formObj.cvrg_cnt_cd)) == "") {
    		ComAlertFocus(formObj.combo2, ComGetMsg('COM12113', "Coverage Country"));
    		return false;
    	}
    	*/
    	//Validity check
    	if(!formObj.validity1.checked && !formObj.validity2.checked && !formObj.validity3.checked) {
    		ComShowCodeMessage('COM12114', "Validity");
    		return false;
    	}
    	
		//필수항목에 데이터가 입력되었는지 확인한다.
        return true;
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
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObj = document.form
		var	i = 0;
	    
	    switch(comboNo) {  
	    	//Continent
	    	case 1: 
	    	case 6:
	    		with (comboObj) { 
	    			MultiSelect = false; 
					UseAutoComplete = false;	
	    			SetColAlign("left|left");
	    			SetColWidth("30|100");
					DropHeight = 160;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 1;
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObj);
				break;

			//Country
	    	case 2:
	    	case 7:
	    		with (comboObj) {
	    			MultiSelect = false;
	    			UseAutoComplet = false;
					SetColAlign("left|left");        
					SetColWidth("30|200");
	    			DropHeight = 160;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 2;
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObj);
	    		break;
	    		
	    	//Region
	    	case 3:
	    	case 8:
	    		with (comboObj) {
  					MultiSelect = false; 
  					UseAutoComplete = false;	
	    			SetColAlign("left|left");
	    			SetColWidth("40|200");
  					DropHeight = 160;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 3;
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
	    		break;
		    //Coverage Yard
	    	case 4:
	    		with (comboObj) {
  					MultiSelect = false; 
  					UseAutoComplete = false;	
	    			SetColAlign("left");
	    			SetColWidth("50");
  					DropHeight = 160;
					ValidChar(2,1);		//영문 대문자,숫자
					MaxLength = 2;
	    		}
	    		comboObj.InsertItem(0, "", "");
	    		break;
	    		
	    	//Dem/Det Delivery Term Code
	    	case 5:
	            	var arrDmdtDeTermCdCode = f_dmdt_de_term_cdCode.split("|");
	            	var arrDmdtDeTermCdText = f_dmdt_de_term_cdText.split("|");
	            	
	            	with (comboObj) {
		                MultiSelect = false; 
		                UseAutoComplete = false;    
		                SetColAlign("left");
		                SetColWidth("50");
		                DropHeight = 80;
		                ValidChar(2,1);     //영문 대문자, 숫자
		                MaxLength = 2;

		                InsertItem(0,  "All",  "A");
		                i++;
		                
		                for (var j=0; j<arrDmdtDeTermCdText.length; j++){
							InsertItem(i++,  arrDmdtDeTermCdText[j],  arrDmdtDeTermCdCode[j]);
						}
		                
		                comboObjects[4].Code = "A";	// Default로 초기화.
	            	}
	            	
	            	break;
	    	//Tariff Type
	    	case 9:
	    		with (comboObj) {
  					MultiSelect = true; 
  					UseAutoComplete = true;	
  					SetColAlign("left|left");        
  					SetColWidth("55|330");
  					DropHeight = 160;
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObj);
	    		break;
		    //CNTR & Cargo Type
	    	case 10:
	    		with (comboObj) {
  					MultiSelect = true; 
  					UseAutoComplete = true;	
  					SetColAlign("left");
  					SetColWidth("300");
  					
  					DropHeight = 200;
	    		}
	    		//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH11,CNTR_CARGE,comboObj);
	    		break;
	     } 
	} 	
	
	/*
	 * Continent 조회필드가 변경될 경우 그 소속의 Country, Region or State 정보를 조회해주는 함수
	 */		
	function combo1_OnChange(comboObj, Index_Code, Text) {
		search_combo1(comboObj, Index_Code, Text);
	}
	
	function search_combo1(comboObj, searchIndex, searchText) {
		//1. Continent 가 Empty 라면 하위필드조회는 하지 않는다.
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		var formObj = document.form;
		
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		//Region 초기화
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location 초기화
		clearLocation1();
		//Yard 초기화																																																																																																																																																																																																																																																		
		clearYard();
	}	
	
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo1(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}

	/*
	 * Country 조회필드가 변경될 경우 그 소속의 Region or State 정보를 조회해주는 함수
	 */		
	function combo2_OnChange(comboObj, Index_Code, Text) {
		search_combo2(comboObj, Index_Code, Text);
	}
	
	function search_combo2(comboObj, searchIndex, searchText) {
		//1. Continent 가 Empty 라면 하위필드조회는 하지 않는다.
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		if (comboObj.Text == "CA" || comboObj.Text == 'US') {
			Region.innerHTML = "State";
		} else {
			Region.innerHTML = "Region";
		}
		
		var formObj = document.form;
		
		isNoChangeActive = true;
		//Continent 조회- 셋팅
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		//Region 조회
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive = false;
	
		//Location 초기화
		clearLocation1();
		//Yard 초기화
		clearYard();
	}	
	
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo2(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	/*
	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function combo3_OnChange(comboObj, Index_Code, Text) {
		search_combo3(comboObj, Index_Code, Text);
	}
	function search_combo3(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) return;

		if (comboObj.Text.length == 0) return;
		
		var formObj = document.form;

		isNoChangeActive = true;
		
		//US, CA인 STATE 코드 자리수가 2인 경우
		if(comboObj.Text.length == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		isNoChangeActive = false;	
		
		//Location 초기화
		clearLocation1();
		//Yard 초기화
		clearYard();
		
	}
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo3(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}		
	
	/*
	 * Location 조회필드에서 Enter Key 가 입력될 경우 Location 을 포함하는 Continent, Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation1(obj) {
		if(isAlphaNum()) {
			if (isNoChangeActive) return;

			var formObj = document.form;
			var locCd = ComTrim(ComGetObjValue(obj));
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
    				Region.innerHTML = "State";
    			}else{
    				Region.innerHTML = "Region";
    			}
    			
    			isNoChangeActive = true;
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
    			isNoChangeActive = false;
	    	}		
		}
	}

	/*
	 * yd_cd1 조회필드에서 LOCATION에 해당하는 YARD 정보를 조회하는 함수
	 */		
	function checkYard1(obj) {
		if(isAlphaNum()) {
			checkYard1_sub1(obj);
			checkYard1_sub2(obj);
		}
	}
	
	/*
	 * yd_cd1 입력시 location을 조회한다.
	 */
	function checkYard1_sub1(obj) {
		if (isNoChangeActive) return;
		
		var formObj = document.form;
		var yardCd1 = ComTrim(ComGetObjValue(obj));
		
    	if (yardCd1.length == 5) {
			
			if(yardCd1.substring(0,2) == "CA" || yardCd1.substring(0,2) == "US") {
				Region.innerHTML = "State";
			}else{
				Region.innerHTML = "Region";
			}
			isNoChangeActive = true;
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
			isNoChangeActive = false;
    	}
	}
	/*
	 * yd_cd1 입력시 yd_cd list를 조회한다.
	 */
	function checkYard1_sub2(obj) {
		if (isNoChangeActive) return;
		
		var formObj = document.form;
		var yardCd1 = ComTrim(ComGetObjValue(obj));
		
    	if (yardCd1.length == 5) {
    		if (yardCd1.length > 0) {
				isNoChangeActive = true;
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH14,YARD,obj);
				isNoChangeActive = false;
			}
    	}
	}	
	/*
	 * YARD 조회필드가 입력될 경우 Location 을 포함하는 Continent, Country 와 Region or State 정보를 조회하는 함수
	 */	
	function combo4_OnChange(comboObj, Index_Code, Text) {
		search_combo4(comboObj, Index_Code, Text);
	}
	function search_combo4(comboObj, searchIndex, searchText) {
		if(comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		if(searchIndex == undefined || searchIndex == ""){//2009.10.14 yard code값이 존재하지 않으면 강제로 입력 값을 지운다.
			comboObj.Text = "";	
			return;
		}
		var formObj = document.form;
		
		//Region or State 에 해당되는 Country 정보를 선택해주고
		//Region or State 는 선택된 항목으로만 채워져 있어야 하다.(나머지 항목은 삭제)
		isNoChangeActive = true;
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,COMMAND03,YARD,comboObj);
		isNoChangeActive = false;
	}
	function combo4_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo4(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	
	/*
	 * Continent 조회필드가 변경될 경우 그 소속의 Country, Region or State 정보를 조회해주는 함수
	 */		
	function combo6_OnChange(comboObj, Index_Code, Text) {
		search_combo6(comboObj, Index_Code, Text);
	}
	function search_combo6(comboObj, searchIndex, searchText) {
		//1. Continent 가 Empty 라면 하위필드조회는 하지 않는다.
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		var formObj = document.form;
		
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);
		
		//Region 초기화
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);
		//Location 초기화
		clearLocation2();
	}
	
	function combo6_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo6(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	
	/*
	 * Country 조회필드가 변경될 경우 그 소속의 Region or State 정보를 조회해주는 함수
	 */		
	function combo7_OnChange(comboObj, Index_Code, Text) {
		search_combo7(comboObj, Index_Code, Text);
	}
	function search_combo7(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) return;
		
		//Continent 가 Empty 라면 하위필드조회는 하지 않는다.
		if (comboObj.Text.length == 0 ) return;
	
		if (comboObj.Text == "CA" || comboObj.Text == 'US') {
			Region2.innerHTML = "State";
		} else {
			Region2.innerHTML = "Region";
		}
		
		var formObj = document.form;
		
		isNoChangeActive = true;
		//Continent 조회- 셋팅
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);
		//Region 조회
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);
		isNoChangeActive = false;
	}
	
	function combo7_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo7(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/*
	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function combo8_OnChange(comboObj, Index_Code, Text) {
		search_combo8(comboObj, Index_Code, Text);
	}
	function search_combo8(comboObj, searchIndex, searchText) {
		if (isNoChangeActive) return;
		
		if (comboObj.Text.length == 0) return;

		var formObj = document.form;
		
		isNoChangeActive = true;
		//US, CA인 STATE 코드 자리수가 2인 경우
		if(comboObj.Text.length == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		isNoChangeActive = false;
	}
	function combo8_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo8(comboObj, sIndexCode, sText);
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}	
	
	/*
	 * Location 조회필드에서 Enter Key 가 입력될 경우 Location 을 포함하는 Continent, Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation2(obj) {
		
		if(isAlphaNum()) {
			if (isNoChangeActive) return;

			var formObj = document.form;
			var locCd = ComTrim(ComGetObjValue(obj));
	    	if (locCd.length == 5) {
	    		
    			if(locCd.substring(0,2) == "CA" || locCd.substring(0,2) == "US") {
    				Region2.innerHTML = "State";
    			}else{
    				Region2.innerHTML = "Region";
    			}
    			isNoChangeActive = true;
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);
    			isNoChangeActive = false;
	    	}		
		}
	}
	
	// 조회조건필드인 Combo 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		var index_1 = 0;
		var index_2 = 0;
		var index_3 = 0;
		
		switch(sAction) {
           case IBSEARCH:      // 조회
				if (sheetObj.id == "sheet1") {
					//3.조회후 결과처리
					var comboDatas;
					var comboItems;
					
					switch(sComboAction) {
						case SEARCHLIST08:
					        //1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST08); 
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        //ALL_TARIFF_TYPE
					        comboItems = ComGetEtcData(sXml, ALL_TARIFF_CD).split(ROWMARK);
							addComboItem(comboObjects[8],comboItems);						
	
							for (var i = 0 ; i < comboItems.length ; i++) {
					    		var comboItem = comboItems[i].split(FIELDMARK);
					    		comboObjects[8].CheckIndex(i) = true; 
					    	}  	
							
							//Cntr & Cargo
							comboItems = ComGetEtcData(sXml, CNTR_CARGE).split(ROWMARK);
							addComboItem2(comboObjects[9],comboItems);
							
							for (var i = 0 ; i < comboItems.length ; i++) {
					    		var comboItem = comboItems[i].split(FIELDMARK);
					    		comboObjects[9].CheckIndex(i) = true; 
					    	}
					        
							//Coverage Continent
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
					            comboItems = comboDatas.split(ROWMARK);
					            //선태가능한 상태로 변경
					            comboObjects[0].Code="-1";
					            comboObjects[0].RemoveAll();
					            addComboItem(comboObjects[0],comboItems); // Continent
					        }
							
							//Coverage Country 
							comboDatas = ComGetEtcData(sXml, COUNTRY);
					        if (comboDatas != undefined) {
					            comboItems = comboDatas.split(ROWMARK);
					            comboObjects[1].Code = "-1";
					            comboObjects[1].RemoveAll();
					            addComboItem(comboObjects[1],comboItems); //COUNTRY
					        }
					        
					        //Coverage Region
					        comboDatas = ComGetEtcData(sXml, REGION);
					        if (comboDatas != undefined) {
					            comboItems = comboDatas.split(ROWMARK);
					            comboObjects[2].Code = "-1";
					            comboObjects[2].RemoveAll();
					            addComboItem(comboObjects[2],comboItems); //REGION
					        }
					        
					        //Coverage Continent
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
					            comboItems = comboDatas.split(ROWMARK);
					            //선태가능한 상태로 변경
					            comboObjects[5].Code="-1";
					            comboObjects[5].RemoveAll();
					            addComboItem(comboObjects[5],comboItems);	// Continent
					        }
							
							//Coverage Country 
							comboDatas = ComGetEtcData(sXml, COUNTRY);
					        if (comboDatas != undefined) {
					            comboItems = comboDatas.split(ROWMARK);
					            comboObjects[6].Code = "-1";
					            comboObjects[6].RemoveAll();
					            addComboItem(comboObjects[6],comboItems); //COUNTRY
					        }
					        
					        //Coverage Region
					        comboDatas = ComGetEtcData(sXml, REGION);
					        if (comboDatas != undefined) {
					            comboItems = comboDatas.split(ROWMARK);
					            comboObjects[7].Code = "-1";
					            comboObjects[7].RemoveAll();
					            addComboItem(comboObjects[7],comboItems); //REGION
					        }
							
							break;
					
						//1. CONTINENT LIST
						case SEARCH08:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
							
							
							if(sObj.name == "combo1") {
								index_1 = 0;
							} else {
								index_1 = 5;
							}
							
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_1].Code="-1";
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//CONTINENT
							}else{
								ComShowCodeMessage("DMT06001");
							}
	
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							if(sObj.name == "combo2") {
								index_1 = 1;
							} else {
								index_1 = 6;
							}
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_1].Code="-1";
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//COUNTRY
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
						//3. REGION LIST
						case SEARCH01:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
							
							if(sObj.name == "combo3" || sObj.name == "combo1") {
								index_1 = 2;
							} else {
								index_1 = 7;
							} 
							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_1].Code="-1";
								comboObjects[index_1].RemoveAll();
								addComboItem(comboObjects[index_1],comboItems);	//REGION
								
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
							
						//4. Continent에 해당되는 CONTRY 정보 조회
						case SEARCH06:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        if(sObj.name == "combo1" || sObj.name == "combo3" || sObj.name == "cvrg_location"
								|| sObj.name == "combo4" || sObj.name == "yd_cd1") {
								index_1 = 1;
							}else{
								index_1 = 6;
							}
							comboDatas = ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								if(comboDatas != "") {
									comboItems = comboDatas.split(ROWMARK);
									comboObjects[index_1].Code = "-1";
									comboObjects[index_1].RemoveAll();
									addComboItem(comboObjects[index_1],comboItems);	//Country
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
								
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
	
						//5. Country에 해당 하는 CONTINENT 정보 조회
						case SEARCH12:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        if(sObj.name == "combo2") {
								index_1 = 0;
							} else {
								index_1 = 5;
							}
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							if( comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);	//Continent
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
								
						//5. Country가 변경시에 해당 하는 Region 정보 조회
						case SEARCH03:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        if(sObj.name == "combo2" || sObj.name == "combo3" || sObj.name == "combo4" 
								|| sObj.name == "cvrg_location" || sObj.name == "yd_cd1") {
								index_1 = 1;
								index_2 = 2;
								clearLocation1();
							} else {
								index_1 = 6;
								index_2 = 7;
								clearLocation2();
							}
							
							if(comboObjects[index_1].Text == "CA" || comboObjects[index_1].Text == "US" ) {
								//State
								comboDatas = ComGetEtcData(sXml, STATE);
							}else{
	                                                                                                                                                                                        									//Region
								comboDatas = ComGetEtcData(sXml, REGION);
							}
							
							if(comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[index_2].Code="-1";
								comboObjects[index_2].RemoveAll();				//Region						
								addComboItem(comboObjects[index_2],comboItems);
							}else {
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
							
						//6. State,Region를 변경시에 해당 하는 Continet, Country, State 정보 조회
						case SEARCH17:
						case SEARCH13:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        if(sObj.name == "combo3") {
								index_1 = 0;
								index_2 = 1;	//Location 초기화
								index_3 = 2;
								clearLocation1();
							} else {
								index_1 = 5;
								index_2 = 6;
								index_3 = 7;
								clearLocation2();
							}
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							
							if (comboDatas != undefined) {
								//Continent Setting
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								
								//Country List 조회
								comboObjects[index_2].Code="-1";
								comboObjects[index_2].RemoveAll();		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
	
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);	//Country
									
									//Region/State List 조회
									comboObjects[index_3].Code="-1";
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
	
									comboDatas = ComGetEtcData(sXml, sComboKey);
									
									if (comboDatas != undefined) {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
									
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}							
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							
							break;
	
						//4. Location을 입력시 조회
						case SEARCH10:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        var location = ComGetObjValue(sObj);

							if(sObj.name == "cvrg_location" || sObj.name == "yd_cd1") {
								index_1 = 0;
								index_2 = 1;	//Location 초기화
								index_3 = 2;
								clearLocation1();
							} else {
								index_1 = 5;
								index_2 = 6;
								index_3 = 7;
								clearLocation2();
							}
							//Continent 조회
							comboDatas = ComGetEtcData(sXml, CONTINENT);
	
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								//Continent Setting
								setComboItem(comboObjects[index_1],comboItems);		//Continent
								
								//Country List 조회
								comboObjects[index_2].Code="-1";
								comboObjects[index_2].RemoveAll();					//Country		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);
									
									//Region/State List 조회
									comboObjects[index_3].Code="-1";
									comboObjects[index_3].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
	
									if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
										comboDatas = ComGetEtcData(sXml, STATE);
					    			}else{
										comboDatas = ComGetEtcData(sXml, REGION);
					    			}
	
									if (comboDatas != undefined) {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);	//Region
										
										//location setting
										ComSetObjValue(sObj, location);
										
										if(sObj.name == "cvrg_location") {
											//yd_cd1 Setting
											ComSetObjValue(formObj.yd_cd1, ComGetObjValue(formObj.cvrg_location));
											isNoChangeActive = false;
											checkYard1_sub2(formObj.yd_cd1);
											ComSetFocus(formObj.yd_cd1);
											
										}
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
								ComShowCodeMessage('DMT00110','Location');
								ComClearObject(obj);
								ComSetFocus(obj);
							}
							
							break;
						//ALL_TARIFF_TYPE
						case SEARCH09:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							addComboItem(sObj,comboItems);						
	
							for (var i = 0 ; i < comboItems.length ; i++) {
					    		var comboItem = comboItems[i].split(FIELDMARK);
					    		sObj.CheckIndex(i) = true; 
					    	}  		
							break;
						//Cntr & Cargo
						case SEARCH11:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							
							addComboItem2(sObj,comboItems);
	
							for (var i = 0 ; i < comboItems.length ; i++) {
					    		var comboItem = comboItems[i].split(FIELDMARK);
					    		sObj.CheckIndex(i) = true; 
					    	}  		
							break;
						//Yard 입력완료시 Yard List 조회
						case SEARCH14:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        var yd_cd1 = ComGetObjValue(sObj);
							ComSetObjValue(formObj.cvrg_location, yd_cd1);
							index_1 = 3;
							
							//Continent 콤보 Empty 상태로 초기화
							comboObjects[3].Code="-1";
							comboObjects[3].RemoveAll();						
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, YARD);

							if (comboDatas == undefined ||comboDatas == "") {
//								ComShowCodeMessage("DMT06001");
//								ComSetObjValue(formObj.cvrg_location, "");
//								ComSetObjValue(formObj.yd_cd1, "");
								
							}else{
								
								comboItems = comboDatas.split(ROWMARK);
								addComboItem1(comboObjects[index_1],comboItems);	
								setComboItem(comboObjects[index_1],comboItems);
								
							}
							break;
						//Yard 선택시 Continent, Country, Location를 조회
						case COMMAND03:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);	
					        //2.조회조건으로 조회실행                 
					        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

					        index_1 = 0;
							index_2 = 1;
							index_3 = 2;
							
							
							//Continent 조회
							comboDatas = ComGetEtcData(sXml, CONTINENT);

							if (comboDatas != undefined) {
								//Continent Setting
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[index_1],comboItems);
								//Country List 조회
								comboObjects[index_2].Code="-1";
								comboObjects[index_2].RemoveAll();		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
								
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);

								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[index_2],comboItems);
									
									//Region/State List 조회
									comboObjects[index_3].Code="-1";
									comboObjects[index_3].RemoveAll();
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry

									//Region/State Setting
									if(comboObjects[index_2].Text == "CA" || comboObjects[index_2].Text == "US" ) {
										comboDatas = ComGetEtcData(sXml, STATE);
									}else{
										comboDatas = ComGetEtcData(sXml, REGION);
									}
									
									if (comboDatas != undefined) {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[index_3],comboItems);
										
										//location setting
										ComSetObjValue(formObj.cvrg_location, ComGetObjValue(formObj.yd_cd1));
									}else{
										ComShowCodeMessage("DMT06001");
										clearObjectValue(sObj);
									}
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
								
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}

							break;								
					}
	
				};
                break;
        }
		sheetObj.WaitImageVisible = true;
    }
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem2(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
    		comboObj.InsertItem(i, ComReplaceStr(comboItem[1],"^"," - ") , comboItem[0]);
    	}   		
	}
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem1(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
    	}   		
	}
	
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function Minimize(nItem)
    {

        var objs = document.all.item("showMin");

        if ( nItem == "1" )
        {
    	    objs.style.display = "none";
    	    sheetObjects[0].style.height = 470;
    	}
    	else
    	{
    	    objs.style.display = "inline";
    	    //sheetObjects[0].style.height = 295;
    	    sheetObjects[0].style.height = 330;
    	}
    }
	
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;

		//Coverage ComboSetting
		ComSetObjValue(formObj.cvrg_conti_cd, comboObjects[0].Text);
		ComSetObjValue(formObj.cvrg_cnt_cd, comboObjects[1].Text);
		ComSetObjValue(formObj.cvrg_rgn_cd, comboObjects[2].Text);
		ComSetObjValue(formObj.cvrg_loc_cd, ComGetObjValue(formObj.cvrg_location));
		ComSetObjValue(formObj.cvrg_yd_cd, comboObjects[3].Code);
		
		//Dem/Det Delivery Term Code Setting
		ComSetObjValue(formObj.dmdt_de_term_cd, comboObjects[4].Code);
		ComSetObjValue(formObj.dmdt_de_term_nm, comboObjects[4].Text);
		
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.org_dest_conti_cd, comboObjects[5].Text);
		ComSetObjValue(formObj.org_dest_cnt_cd, comboObjects[6].Text);
		ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[7].Text);
		ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
		
		//others
		ComSetObjValue(formObj.dmdt_trf_cd_list, comboObjects[8].Text);
		ComSetObjValue(formObj.dmdt_cntr_cgo_list, comboObjects[9].Code);

		//Retrieve Setting
		//ComSetObjValue(formObj.f_cmd, sAction);							//Command
	}
	/*
	 * Combo 공통 코드를 조회한다.
	 */
	function setComboParameters(sComboAction, sObj) {
		var formObj = document.form;

		switch(sObj.name) {
			case "combo1":
			case "combo2":
			case "combo3":
			case "combo4":
			case "cvrg_location":
			case "yd_cd1":
				//Coverage ComboSetting
				ComSetObjValue(formObj.conti_cd, comboObjects[0].Text);
				ComSetObjValue(formObj.cnt_cd, comboObjects[1].Text);
				ComSetObjValue(formObj.rgn_cd, comboObjects[2].Text);
				ComSetObjValue(formObj.ste_cd, comboObjects[2].Text);
				if(sObj.name == "cvrg_location") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
				} else if(sObj.name == "yd_cd1") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.yd_cd1));
				}
				
				ComSetObjValue(formObj.yd_cd, comboObjects[3].Code);
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command

			case "combo5":
		        ComSetObjValue(formObj.dmdt_de_term_cd,  comboObjects[4].Code);		//Dem/det Delivery Term Code
		        ComSetObjValue(formObj.dmdt_de_term_nm,  comboObjects[4].Text);		//Dem/det Delivery Term Name
		        break;
		        
			case "combo6":
			case "combo7":
			case "combo8":
			case "org_dest_location":
				//Origin/Dest ComboSettion
				ComSetObjValue(formObj.conti_cd, comboObjects[5].Text);
				ComSetObjValue(formObj.cnt_cd, comboObjects[6].Text);
				ComSetObjValue(formObj.rgn_cd, comboObjects[7].Text);
				ComSetObjValue(formObj.ste_cd, comboObjects[7].Text);
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_loction));

				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;	
			case "combo9":
			case "combo10":
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;
				
		}
	}

	//멀티콤보 클릭 이벤트
	function combo9_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}
	
	//멀티콤보 클릭 이벤트
	function combo10_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}
	
    /**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem = comboItems[0].split(FIELDMARK);
		comboObj.Text = checkedItem[0];
	}	
	
	/*
	 * 조회결과 정보 초기화
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}
	/*
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation1() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
	}

	/*
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation2() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.org_dest_location, "");
	}
	
	function clearObjectValue(obj) {
		switch(obj.name) {
			case "cvrg_location":
			case "yd_cd1":
			case "org_dest_location":
				obj.value = "";
				break;
			default:
				obj.Text = "";
				break;
		}
	}
		
	/**
	 * Yard 조회필드정보 초기화
	 * @return
	 */
	function clearYard() {
		var formObj = document.form;
		comboObjects[3].Code="-1";
		comboObjects[3].RemoveAll();
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		ComSetObjValue(formObj.yd_cd, "");
	}
	/*
	 *  초기화 
	 */		
	function initSearchControls() {
		var formObj = document.form;
		
		comboObjects[0].Code="-1";
		comboObjects[0].RemoveAll();
		comboObjects[1].Code="-1";
		comboObjects[1].RemoveAll();
		comboObjects[2].Code="-1";
		comboObjects[2].RemoveAll();
		comboObjects[3].Code="-1";
		comboObjects[3].RemoveAll();
		
		comboObjects[5].Code="-1";
		comboObjects[5].RemoveAll();
		comboObjects[6].Code="-1";
		comboObjects[6].RemoveAll();
		comboObjects[7].Code="-1";
		comboObjects[7].RemoveAll();
		comboObjects[8].Code="-1";
		comboObjects[8].RemoveAll();
		comboObjects[9].Code="-1";
		comboObjects[9].RemoveAll();
		
		ComSetObjValue(formObj.conti_cd, "");	
		ComSetObjValue(formObj.cnt_cd, "");		
		ComSetObjValue(formObj.rgn_cd, "");		
		ComSetObjValue(formObj.ste_cd, "");		
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.yd_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
		ComSetObjValue(formObj.org_dest_location, "");

		ComSetObjValue(formObj.cvrg_conti_cd, "");
		ComSetObjValue(formObj.cvrg_cnt_cd, "");
		ComSetObjValue(formObj.cvrg_rgn_cd, "");
		ComSetObjValue(formObj.cvrg_loc_cd, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		
		ComSetObjValue(formObj.org_dest_conti_cd, "");
		ComSetObjValue(formObj.org_dest_cnt_cd, "");
		ComSetObjValue(formObj.org_dest_rgn_cd, "");
		ComSetObjValue(formObj.org_dest_loc_cd, "");
		
		ComSetObjValue(formObj.dmdt_trf_cd_list, "");
		ComSetObjValue(formObj.dmdt_cntr_cgo_list, "");

		ComSetObjValue(formObj.validity1, "Y");		//Validity
		ComSetObjValue(formObj.validity2, "Y");		//Validity
		ComSetObjValue(formObj.validity3, "");		//Validity
		
		Region.innerHTML = "Region";
		Region2.innerHTML = "Region";
	}		
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initControl() {
		//조회필드 초기화
		initSearchControls();
		//조회결과 정보 초기화
		//initResultControls();
	 	// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    //데이터 초기화
	    var formObj = document.form;
	    
	    doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST08,"","");
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[0]);		//1
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[1]);		//2
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[2]);			//3
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[4]);		//5
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[5]);		//6
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[6]);			//7
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObjects[7]);	//8
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH11,CNTR_CARGE,comboObjects[8]);		//9
 
	}
	 
function t1901SpeedDownExcel () {
    sheetObjects[1].RemoveAll();
    doActionIBSheet( sheetObjects[1] , document.form , IBSEARCH );
//    sheetObjects[1].CellValue(1,"xcld_sat_flg") = sheetObjects[1].CellValue(2,"wknd1");
//    sheetObjects[1].CellValue(1,"xcld_sun_flg") = sheetObjects[1].CellValue(2,"wknd2");    
//    sheetObjects[1].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'','',false,'',true);
    sheetObjects[1].Down2Excel(-1);
}
	
	/* 개발자 작업  끝 */