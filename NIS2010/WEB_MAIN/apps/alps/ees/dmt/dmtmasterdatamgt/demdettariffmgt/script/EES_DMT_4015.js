/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_4015.js
*@FileTitle : SZPSC DEM Tariff Inquiry
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
     * @class ees_dmt_4015 : ees_dmt_4015 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_dmt_4015() {
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
    	///alert("processButtonClick");
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
//					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
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
    	
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[1]);		//1
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[2]);			//2
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[3]);			//3
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObjects[4]);	//4
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH11,CNTR_CARGE,comboObjects[5]);		//5	 	
    	doEnableBkgTerm();
    }
   
    // BKG Term 사용 여부를 첵크한다.
    function doEnableBkgTerm() {
    	var formObj = document.form;
//    	
//    	if (
//    		(ComGetObjValue(formObj.combo6) == "DTOC" || ComGetObjValue(formObj.combo6) == "DTIC") &&
//    		(ComGetObjValue(formObj.cvrg_country) == "US"   || ComGetObjValue(formObj.cvrg_country) == "CA"  )
//    		){
//    		comboObjects[1].Enable = true;
//    	} else {
    		comboObjects[1].Enable = false;
    		ComSetObjValue(formObj.combo2, "N")
//    	}
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
                	style.height = 332;
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

					var HeadTitle1 = "|Tariff\nType|Coverage|ORG/\nDest.|dmdt_de_term_cd|BKG\nTerm|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T EXCL|F/T EXCL|F/T EXCL|Free Time|Free Time|Charge|Charge|Charge|Charge|Charge|Charge|Charge|expire_chk|wknd1|wknd2";
					var HeadTitle2 = "|Tariff\nType|Coverage|ORG/\nDest.|dmdt_de_term_cd|BKG\nTerm|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|SAT|SUN|HOLI|No.of\nCNTR|Free Day|CUR|Over Day|20FT|40FT|H/C|45FT|R9|expire_chk|wknd1|wknd2";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenterTop,		true,		"hdnStatus");
                    InitDataProperty(0,	cnt++ ,	dtData,			60,		daCenterTop,		true,		"dmdt_trf_cd",			false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0,	cnt++ ,	dtData,			65,		daCenterTop,		true,		"covrg",				false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0,	cnt++ ,	dtData,			50,		daCenterTop,		true,		"org_dest",				false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0,	cnt++ ,	dtHidden,		50,		daCenterTop,		true,		"dmdt_de_term_cd",				false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0,	cnt++ ,	dtData,			50,		daCenterTop,		true,		"dmdt_de_term_nm",				false,		"",		dfNone,		0,	false, false, -1, false, false);
                    
                    InitDataProperty(0, cnt++ , dtData,			200,	daCenterTop,		true,		"dmdt_bzc_trf_grp_nm",	false,		"",		dfNone,		0,	false, false, -1, false, false);

                    InitDataProperty(0, cnt++ , dtData,			100,	daCenterTop,		true,		"eff_dt",				false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			110,	daCenterTop,		true,		"exp_dt",				false,		"",		dfDateYmd,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daCenterTop,		false,		"dmdt_cntr_tp_cd",		false,		"",		dfDateYmd,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			120,	daCenterTop,		false,		"dmdt_cgo_tp_cd",		false,		"",		dfNone,		0,	false, false, -1, false, false);
                    
                    InitDataProperty(0, cnt++ , dtData,			130,	daCenterTop,		true,		"dmdt_chg_cmnc_tp_cd",	false,		"",		dfNone,	0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			35,		daCenterTop,		false,		"xcld_sat_flg",			false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			35,		daCenterTop,		false,		"xcld_sun_flg",			false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			35,		daCenterTop,		false,		"xcld_hol_flg",			false,		"",		dfNone,		0,	false, false, -1, false, false);

                    InitDataProperty(0, cnt++ , dtData,			45,		daCenterTop,		false,		"free_time",			false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			65,		daCenterTop,		false,		"ft_dys",				false,		"",		dfNullInteger,		0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			40,		daCenterTop,		false,		"curr_cd",				false,		"",		dfNone,		0,	false, false, -1, false, false);

                    InitDataProperty(0, cnt++ , dtData,			65,		daCenterTop,		false,		"over_day",				false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		false,		"cntr_20ft_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		false,		"cntr_40ft_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		false,		"cntr_hc_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		false,		"cntr_45ft_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtData,			100,	daRightTop,		false,		"cntr_r9_rt_amt",		false,		"",		dfNullFloat,	2,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenterTop,		false,		"expire_chk",			false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenterTop,		false,		"wknd1",				false,		"",		dfNone,		0,	false, false, -1, false, false);
                    InitDataProperty(0, cnt++ , dtHidden,		100,	daCenterTop,		false,		"wknd2",				false,		"",		dfNone,		0,	false, false, -1, false, false);                    
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

                    var HeadTitle1 = "|Tariff\nType|Coverage|ORG/\nDest.|BKG\nTerm|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T Exclusion|F/T Exclusion|F/T Exclusion|Free Time|Free Time|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|expire_chk|wknd1|wknd2";
                    var HeadTitle2 = "|Tariff\nType|Coverage|ORG/\nDest.|BKG\nTerm|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|Sat|Sun|H/day|CNTR\nQ'ty|Free Day|Cur.|Over Day|20FT|40FT|H/C|45FT|R9|expire_chk|wknd1|wknd2";

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
//                    InitDataProperty(0, cnt++ , dtHidden,       200,    daCenterTop,       true,       "dmdt_de_term_cd",  false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         200,    daCenterTop,       true,       "dmdt_de_term_nm",  false,      "",     dfNone,     0,  false);

//                    InitDataProperty(0, cnt++ , dtHidden,       50,     daCenterTop,       true,       "trf_grp_seq");
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
						if(ComGetObjValue(formObj.combo4) == "") {
							ComSetObjValue(formObj.yd_cd1, "");
						}

						//2.조회전 결과필드들을 Empty 시킨다.
						initResultControls();
						ComSetObjValue(formObj.f_cmd, SEARCH02 ); 
						
	                    //ComOpenWait Start
	                    sheetObj.WaitImageVisible=false;
	                    ComOpenWait(true);
						
						//2.조회조건으로 조회실행
						sheetObj.DoSearch("EES_DMT_4015GS.do", FormQueryString(formObj));
						
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
                        sheetObj.DoSearch("EES_DMT_4015GS.do", FormQueryString(formObj));

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

   		case IBCLEAR:       //초기화 
			initSearchControls();
			//buttonMode("IBCLEAR");
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
			ComShowCodeMessage('DMT00110','Location');
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
	    var formObj = document.form;
	    var	i=0;
	    
	    switch(comboNo) {
	    	//Coverage Yard
	    	case 1:
	    		with (comboObj) {
					MultiSelect = false; 
					//UseAutoComplete = false;	
					SetColAlign("left");
					SetColWidth("50");
					DropHeight = 160;
					ValidChar(2,1);		//영문 대문자,숫자
					MaxLength = 2;
	    		}
	    		comboObj.InsertItem(0, "", "");
	    		break;
	    		
	    	//Dem/Det Delivery Term Code
	    	case 2:
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
		                
		                comboObjects[1].Code = "A";	// Default로 초기화.
	            	}
	            	
	            	break;
	            	
	    	//Continent
	    	case 3:
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
	    		break;
	    	//Country
	    	case 4:
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
	    		break;
	    		
	    	//Region
	    	case 5:
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
	    		break;
	    	//Tariff Type
	    	case 6:
//	    		with (comboObj) {
//	    			MultiSelect = true; 
//					UseAutoComplete = true;	
//					SetColAlign("left|left");        
//					SetColWidth("55|330");
//					DropHeight = 160;
//	    		}
				with (comboObj) {
                    MultiSelect = false; 
                    UseAutoComplete = true; 
                    SetColAlign("left|left");        
                    SetColWidth("55|330");
                    DropHeight = 160;
                    ValidChar(2,0);     //영문 대문자
                    IMEMode = 0;
                    MaxLength = 4;
				}
	    		break;
	    	//CNTR & Cargo Type
	    	case 7:
	    		with (comboObj) {
	    			MultiSelect = true; 
					UseAutoComplete = true;	
					SetColAlign("left");
					SetColWidth("300");
					
					DropHeight = 200;
	    		}
	    		break;
	    }

	} 	
	
	/*
	 * Location 조회필드에서 Enter Key 가 입력될 경우 
	 * Location 을 포함하는 Continent, Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation1(obj) {
		
		if(isAlphaNum()) {
			if (isNoChangeActive) return;

			var formObj = document.form;
			var locCd = ComTrim(ComGetObjValue(obj));
	    	if (locCd.length == 5) {
	    		
    			isNoChangeActive = true;
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);	//ContinentHierarchyByLocation(conti,cnt,rgn,ste,loc)
    			isNoChangeActive = false;
	    	}		
		}
	}	
	
	/*
	 * yd_cd1 조회필드에서 Enter Key가 입력될 경우
	 * LOCATION에 해당하는 YARD 정보를 조회하는 함수
	 */		
	function checkYard1(obj) {
		if(isAlphaNum()){
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
			isNoChangeActive = true;
   			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH10,LOCATION,obj);	//ContinentHierarchyByLocation(conti,cnt,rgn,ste,loc)
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
			isNoChangeActive = true;
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH14,YARD,obj);		//yard_code list
			isNoChangeActive = false;
		}
	}		
	/*
	 * Continent Combo 이벤트
	 * 그 소속의 Country정보를 조회해주는 함수
	 */		
	function combo3_OnChange(comboObj, Index_Code, Text) {
		search_combo3(comboObj, Index_Code, Text);
	}
	function search_combo3(comboObj, searchIndex, searchText) {
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		var formObj = document.form;
		
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);	//CountryListByContinent
		//Region 초기화
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);		//SearchRegionList
		//Location 초기화
		clearLocation2();
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
	 * Country Combo 이벤트
	 * 그 소속의 Continent, Region or State 정보를 조회해주는 함수
	 */		
	function combo4_OnChange(comboObj, Index_Code, Text) {
		search_combo4(comboObj, Index_Code, Text);
	}
	function search_combo4(comboObj, searchIndex, searchText) {
		//Continent 가 Empty 라면 하위필드조회는 하지 않는다.
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive)	return;

		if (comboObj.Text == "CA" || comboObj.Text == 'US') {
			Region2.innerHTML = "State";
		} else {
			Region2.innerHTML = "Region";
		}
		
		var formObj = document.form;
		
		isNoChangeActive = true;
		//Continent 조회
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH12,CONTINENT,comboObj);		//SearchContinetListByCountry
		//Region 조회
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,REGION,comboObj);			//SearchRegionListByCountry, searchStateListByCountry
		isNoChangeActive = false;

		//Location 초기화
		clearLocation2();
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
	 * Region or State Combo 이벤트
	 * 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function combo5_OnChange(comboObj, Index_Code, Text) {
		search_combo5(comboObj, Index_Code, Text);
	}
	function search_combo5(comboObj, searchIndex, searchText) {
		var region_len = comboObj.Text.length ;
		
		if (region_len == 0)	return;
		
		if (isNoChangeActive)	return;
		
		var formObj = document.form;

		isNoChangeActive = true;
		
		//US, CA인 STATE 코드 자리수가 2인 경우
		if(region_len == 2) {
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH17,STATE,comboObj);	//searchHierarchyByState
		}else{
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH13,REGION,comboObj);	//searchHierarchyByRegion
		}
		
		isNoChangeActive = false;
	}
	function combo5_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			search_combo5(comboObj, sIndexCode, sText);
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
	    	if (ComTrim(ComGetObjValue(obj)).length == 5) {
	    		
				var locCd = ComTrim(ComGetObjValue(obj));
	    		if (locCd.length > 0) {
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
	}
	
	// 조회조건필드인 Combo 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction,sComboKey,sObj) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
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
	
					        //Origin/Dest. Continent
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
					            comboItems = comboDatas.split(ROWMARK);
					            //선태가능한 상태로 변경
					            comboObjects[2].Code="-1";
					            comboObjects[2].RemoveAll();
					            addComboItem(comboObjects[2],comboItems);
					        }
							
							//Coverage Country 
							comboDatas = ComGetEtcData(sXml, COUNTRY);
					        if (comboDatas != undefined) {
					            comboItems = comboDatas.split(ROWMARK);
					            comboObjects[3].Code = "-1";
					            comboObjects[3].RemoveAll();
					            addComboItem(comboObjects[3],comboItems); //COUNTRY
					        }
					        
					        //Coverage Region
					        comboDatas = ComGetEtcData(sXml, REGION);
					        if (comboDatas != undefined) {
					            comboItems = comboDatas.split(ROWMARK);
					            comboObjects[4].Code = "-1";
					            comboObjects[4].RemoveAll();
					            addComboItem(comboObjects[4],comboItems); //COUNTRY
					        }
					        
					        //ALL_TARIFF_TYPE
					        comboItems = ComGetEtcData(sXml, ALL_TARIFF_CD).split(ROWMARK);
					        var comboItemsTariff = new Array();
							for (var i = 0 ; i < comboItems.length ; i++) {
								var comboItem = comboItems[i].split(FIELDMARK);
								if(comboItem[0] == "All") {
									comboItemsTariff[0] = comboItems[i];
								}else if(comboItem[0] == "DMIF") {
									comboItemsTariff[1] = comboItems[i];
								}else if(comboItem[0] == "DMOF") {
									comboItemsTariff[2] = comboItems[i];
								}
							}
							
							addComboItem(comboObjects[5],comboItemsTariff);	
							comboObjects[5].Index = 0; 
	
							for (var i = 0 ; i < comboItemsTariff.length ; i++) {
					    		var comboItem = comboItemsTariff[i].split(FIELDMARK);
					    		comboObjects[5].CheckIndex(i) = true; 
					    	}   	
							
							//Cntr & Cargo
							comboItems = ComGetEtcData(sXml, CNTR_CARGE).split(ROWMARK);
							addComboItem2(comboObjects[6],comboItems);
							
							for (var i = 0 ; i < comboItems.length ; i++) {
					    		var comboItem = comboItems[i].split(FIELDMARK);
					    		comboObjects[6].CheckIndex(i) = true; 
					    	}
					        
							
							break;					
					
					
					
						//1. CONTINENT LIST
						case SEARCH08:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[2].Code = "-1";				//CONTINENT
								comboObjects[2].RemoveAll();
								addComboItem(comboObjects[2],comboItems);
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[3].Code = "-1";				//COUNTRY
								comboObjects[3].RemoveAll();
								addComboItem(comboObjects[3],comboItems);	
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

							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[4].Code = "-1";				//REGION
								comboObjects[4].RemoveAll();
								addComboItem(comboObjects[4],comboItems);	
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
						//4. ALL_TARIFF_TYPE
						case SEARCH09:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);
							
							var comboItemsTariff = new Array();
							for (var i = 0 ; i < comboItems.length ; i++) {
								var comboItem = comboItems[i].split(FIELDMARK);
								if(comboItem[0] == "All") {
									comboItemsTariff[0] = comboItems[i];
								}else if(comboItem[0] == "DMIF") {
									comboItemsTariff[1] = comboItems[i];
								}else if(comboItem[0] == "DMOF") {
									comboItemsTariff[2] = comboItems[i];
								}
							}
							
							addComboItem(sObj,comboItemsTariff);						
	
							for (var i = 0 ; i < comboItemsTariff.length ; i++) {
					    		var comboItem = comboItemsTariff[i].split(FIELDMARK);
					    		sObj.CheckIndex(i) = true; 
					    	}  		
							break;
						//5. Cntr & Cargo
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
						//6. Location을 입력시 조회-- (loc_cd,rgn_cd,ste_cd,cnt_cd,conti_cd)
						case SEARCH10:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "cvrg_location"  || sObj.name == "yd_cd1") {		//Coverage Location
								var location = ComGetObjValue(sObj);
								var regionData = "";
								var regionCode = "";
								//RGN 체크
								regionData = ComGetEtcData(sXml, REGION);
								
								if(regionData != undefined && regionData != "") {
									regionCode = regionData.split(FIELDMARK);
									
									if(regionCode != undefined && regionCode != "") {
										if(regionCode[0] == "CNS") {
											//yd_cd1 Setting
											ComSetObjValue(formObj.yd_cd1, location);		//loc_cd -> yd_cd1 에 셋팅
											isNoChangeActive = false;
											checkYard1_sub2(formObj.yd_cd1);				//yard code list 조회
											ComSetFocus(formObj.yd_cd1);
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
								
							}else{
								var location = ComGetObjValue(sObj);
	
								clearLocation2();
								//Continent 조회
								comboDatas = ComGetEtcData(sXml, CONTINENT);
		
								if (comboDatas != undefined && comboDatas != "") {
									comboItems = comboDatas.split(ROWMARK);
									//Continent Setting
									setComboItem(comboObjects[2],comboItems);		//Continent
									
									//Country List 조회
									comboObjects[3].Code = "-1";
									comboObjects[3].RemoveAll();					//Country		
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
									
									//Country Setting
									comboDatas = ComGetEtcData(sXml, COUNTRY);
		
									if (comboDatas != undefined && comboDatas != "") {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[3],comboItems);
										
										//Region/State List 조회
										comboObjects[4].Code = "-1";
										comboObjects[4].RemoveAll();				//Region
										doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
		
										if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
											comboDatas = ComGetEtcData(sXml, STATE);
						    			}else{
											comboDatas = ComGetEtcData(sXml, REGION);
						    			}
		
										if (comboDatas != undefined && comboDatas != "") {
											comboItems = comboDatas.split(ROWMARK);
											setComboItem(comboObjects[4],comboItems);	//Region
											
											//location setting
											ComSetObjValue(sObj, location);
											
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
							}
							break;
						//7. Yard 입력완료시 Yard List 조회
						case SEARCH14:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							var yd_cd1 = ComGetObjValue(sObj);
							ComSetObjValue(formObj.cvrg_location, yd_cd1);
							
							//Continent 콤보 Empty 상태로 초기화
							comboObjects[0].Code = "-1";
							comboObjects[0].RemoveAll();						
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, YARD);

							if (comboDatas == undefined ||comboDatas == "") {
								//ComShowCodeMessage("DMT06001");
								//ComSetObjValue(formObj.cvrg_location, "");
								//ComSetObjValue(formObj.yd_cd1, "");
								
							}else{
								
								comboItems = comboDatas.split(ROWMARK);
								addComboItem1(comboObjects[0],comboItems);	
								setComboItem(comboObjects[0],comboItems);
								
							}
							break;	
						
						//8. Continent에 해당되는 CONTRY 정보 조회
						case SEARCH06:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								if(comboDatas != "") {
									comboItems = comboDatas.split(ROWMARK);
									comboObjects[3].Code = "-1";
									comboObjects[3].RemoveAll();
									addComboItem(comboObjects[3],comboItems);	//Country
								}else{
									ComShowCodeMessage("DMT06001");
									clearObjectValue(sObj);
								}
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
							
						//9. Country에 해당 하는 CONTINENT 정보 조회
						case SEARCH12:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[2],comboItems);	//Continent
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;		
							
						//10. Country가 변경시에 해당 하는 Region 정보 조회
						case SEARCH03:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							clearLocation2();
							
							if(comboObjects[3].Text == "CA" || comboObjects[3].Text == "US" ) {
								//State
								comboDatas = ComGetEtcData(sXml, STATE);
							}else{
	                                                                                                                                                                                        									//Region
								comboDatas = ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[4].Code = "-1";
								comboObjects[4].RemoveAll();				//Region						
								addComboItem(comboObjects[4],comboItems);
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

							clearLocation2();
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							
							if (comboDatas != undefined && comboDatas != "") {
								//Continent Setting
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[2],comboItems);		//Continent
								
								//Country List 조회
								comboObjects[3].Code = "-1";
								comboObjects[3].RemoveAll();		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
	
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined && comboDatas != "") {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[3],comboItems);	//Country
									
									//Region/State List 조회
									comboObjects[4].Code = "-1";
									comboObjects[4].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
	
									comboDatas = ComGetEtcData(sXml, sComboKey);
									
									if (comboDatas != undefined && comboDatas != "") {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[4],comboItems);	//Region
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
    	    sheetObjects[0].style.height = 474;
    	}
    	else
    	{
    	    objs.style.display = "inline";
    	    sheetObjects[0].style.height = 330;
    	}
    }
	
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;

		//Coverage ComboSetting
		ComSetObjValue(formObj.cvrg_conti_cd, ComGetObjValue(formObj.cvrg_continent));
		ComSetObjValue(formObj.cvrg_cnt_cd, ComGetObjValue(formObj.cvrg_country));
		ComSetObjValue(formObj.cvrg_rgn_cd, ComGetObjValue(formObj.cvrg_region));
		ComSetObjValue(formObj.cvrg_loc_cd, ComGetObjValue(formObj.cvrg_location));
		ComSetObjValue(formObj.cvrg_yd_cd, comboObjects[0].Code);
		
		//Dem/Det Delivery Term Code Setting
		ComSetObjValue(formObj.dmdt_de_term_cd, comboObjects[1].Code);
		ComSetObjValue(formObj.dmdt_de_term_nm, comboObjects[1].Text);
		
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.org_dest_conti_cd, comboObjects[2].Text);
		ComSetObjValue(formObj.org_dest_cnt_cd, comboObjects[3].Text);
		ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[4].Code);
		ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
		
		//others
		ComSetObjValue(formObj.dmdt_trf_cd_list, comboObjects[5].Text);
		ComSetObjValue(formObj.dmdt_cntr_cgo_list, comboObjects[6].Code);

		//Retrieve Setting
		//ComSetObjValue(formObj.f_cmd, sAction);							//Command
	}
	/*
	 * Combo 공통 코드를 조회한다.
	 */
	function setComboParameters(sComboAction, sObj) {
		var formObj = document.form;

		switch(sObj.name) {
			case "combo1":		//coverage yd_cd2
			case "cvrg_location":
			case "yd_cd1":
				//Coverage ComboSetting
				if(sObj.name == "cvrg_location") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
				} else if(sObj.name == "yd_cd1") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.yd_cd1));
				}
				
				ComSetObjValue(formObj.yd_cd, comboObjects[0].Code);
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;

			case "combo3":	//orgin/dest continent
			case "combo4":	//orgin/dest country
			case "combo5":	//orgin/dest region/state
			case "org_dest_location":
				//Origin/Dest ComboSettion
				ComSetObjValue(formObj.conti_cd, comboObjects[2].Text);
				ComSetObjValue(formObj.cnt_cd, comboObjects[3].Text);
				ComSetObjValue(formObj.rgn_cd, comboObjects[4].Text);
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_loction));

				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;	
			case "combo6":	//Tariff Type
			case "combo7":	//CNTR & Cargo Type
				//Retrieve Setting
				ComSetObjValue(formObj.f_cmd, sComboAction);							//Command
				break;
				
		}
	}

	//멀티콤보 클릭 이벤트
	function combo6_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}
	
	//멀티콤보 클릭 이벤트
	function combo7_OnCheckClick(comboObj, index, code) {
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
		comboObjects[0].Code = "-1";
		comboObjects[0].RemoveAll();
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		ComSetObjValue(formObj.yd_cd, "");
	}
	/*
	 *  초기화 
	 */		
	function initSearchControls() {
		var formObj = document.form;
		
		comboObjects[0].RemoveAll();
		comboObjects[2].RemoveAll();
		comboObjects[3].RemoveAll();
		comboObjects[4].RemoveAll();
		comboObjects[5].RemoveAll();
		comboObjects[6].RemoveAll();

		
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
	    //DATA 초기화
    	var formObj = document.form;

    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST08,"","");    	
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[0]);		//5
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[1]);			//6
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[2]);			//7
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH09,ALL_TARIFF_CD,comboObjects[4]);	//8
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH11,CNTR_CARGE,comboObjects[5]);		//9
	    
    	doEnableBkgTerm();
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