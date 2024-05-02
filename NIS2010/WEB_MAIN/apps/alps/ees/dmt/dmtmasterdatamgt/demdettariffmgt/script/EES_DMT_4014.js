/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_dmt_4014.jsp
*@FileTitle : SZPSC DEM Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.04 김태균
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
     * @class EES_DMT_4014 : EES_DMT_4014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function EES_DMT_4014() {
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
	
    var COMMON_TARIFF_CD 	= "common_tariff_cd"; 
    
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	var ORIGIN = "Origin";
	var DESTINATION = "Destination";
	
	var IBSAVE2     = 51;	//사용자

	
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
    	var sheetObject3 = sheetObjects[2];
    	var sheetObject4 = sheetObjects[3];
			 	 
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcObj = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_New":
					initControl();
					EnableControls();
					break;
					
				case "btn_Create":
					if(ComIsBtnEnable(srcName)) {
						openPopup(sheetObject1, formObject, srcName);
					}
					break;
					
 				case "btn_Update":
					if(ComIsBtnEnable(srcName)) {
						openPopup(sheetObject1, formObject, srcName);
					}
 					break;

 				case "btn_Confirm":
 					if(ComIsBtnEnable(srcName)) {
						//Confirm 실행
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
 					}
					break;
					
 				case "btn_Expire":
 					if(ComIsBtnEnable(srcName)) {
						openPopup(sheetObject1, formObject, srcName);
 					}
					break;

 				case "btn_ConfirmCancel":
 					if(ComIsBtnEnable(srcName)) {
 						//ConfirmCancel
 						doActionIBSheet(sheetObject1,formObject,IBSAVE2);
 					}
					break;

 				case "btn_Delete":
 					if(ComIsBtnEnable(srcName)) {
 						doActionIBSheet(sheetObject1,formObject,IBDELETE);
 					}
					break;

 				case "btn_Copy":
 					if(ComIsBtnEnable(srcName)) {
						openPopup(sheetObject1, formObject, srcName);
 					}
					break;

 				case "btn_Downexcel":
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
	    //Button 초기화
	    initButton();
    	
        for(i=0;i<sheetObjects.length;i++){
            //시작 환경 설정 함수 이름 변경
        	ComConfigSheet (sheetObjects[i] );
        	initSheet(sheetObjects[i],i+1);
            //마지막 환경 설정 함수 추가
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
    	
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");

//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST,COMMON_TARIFF_CD,comboObjects[0]);	//Tariff Type
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[2]);			//Orgin Continent
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[3]);				//Orgin Country
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[4]);				//Orgin Region
    	doEnableBkgTerm();
    }
    
    // BKG Term 사용 여부를 첵크한다.
    function doEnableBkgTerm() {
    	var formObj = document.form;
    	
    	if (
    		(ComGetObjValue(formObj.combo1) == "DTOC" || ComGetObjValue(formObj.combo1) == "DTIC") &&
    		(ComGetObjValue(formObj.cvrg_country) == "US"   || ComGetObjValue(formObj.cvrg_country) == "CA"  )
    		){
    		comboObjects[2].Enable = true;
    	} else {
    		comboObjects[2].Enable = false;
    		ComSetObjValue(formObj.combo3, "N")
    	}
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
					// 높이 설정
					style.height = 222;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);
	
					var HeadTitle = "|dmdt_de_term_cd|BKG Term|Group Name|trf_grp_seq|Effective Date|Expiration Date|User Office|CNTR Type|Cargo Type|rgn_cfm_flg|grp_cfm_flg|trf_seq|svr_id|xcld_sat_flg|xcld_sun_flg|xcld_hol_flg|dmdt_chg_cmnc_tp_nm|cmnc_hr|curr_cd|eff_day|dmdt_trf_cd";
					
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
	
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//
					DataAutoTrim = false;
	
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtHidden,      	70,		daCenter,	true,	"dmdt_de_term_cd",		false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,      	70,		daCenter,	true,	"dmdt_de_term_nm",		false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,      	300,	daCenter,	true,	"dmdt_bzc_trf_grp_nm",	false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	true,	"trf_grp_seq",			false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,      	150,	daCenter,	true,	"eff_dt",				false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	150,	daCenter,	true,	"exp_dt",				false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,      	150,	daCenter,	true,	"user_office",			false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,      	150,	daCenter,	false,	"dmdt_cntr_tp_nm",		false,	"",		dfNone,		0,	false,		true,	10);
					InitDataProperty(0, cnt++ , dtData,      	200,	daCenter,	false,	"dmdt_cgo_tp_nm",		false,	"",		dfNone,		0,	false,		true,	20);

					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"rgn_cfm_flg",			false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"grp_cfm_flg",			false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"trf_seq",				false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"svr_id",				false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"xcld_sat_flg",			false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"xcld_sun_flg",			false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"xcld_hol_flg",			false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"dmdt_chg_cmnc_tp_nm",	false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"cmnc_hr",				false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"curr_cd",				false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"eff_day",				false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      	30,		daCenter,	false,	"dmdt_trf_cd",			false,	"",		dfNone,		0,	false,		true);
					

					CountPosition = 0;		// 건수 정보를 표시하지 않음.

               }
                break;


            case 2:      // sheet3 init
                with (sheetObj) {
					// 높이 설정
					style.height = 150;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 2, 100);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "|CNTR Q'ty|CNTR Q'ty|Free Day";
					var HeadTitle2 = "|From|Up To|Free Day";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					InitHeadRow(1, HeadTitle2, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"hdnStatus");
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,	"ft_fm_qty",	false,		"",		dfNone,		0,			false,		true,	3);
					InitDataProperty(0, cnt++ , dtData,    		90,		daCenter,	false,	"ft_to_qty",	false,		"",		dfNone,		0,			false,		true,	3);
					InitDataProperty(0, cnt++ , dtData,      	70,		daCenter,	true,	"ft_dys",		false,		"",		dfNone,		0,			false,		true,	3);

					CountPosition = 0;		// 건수 정보를 표시하지 않음.
					SelectHighLight = false;

				}
                break;
                
            case 3:      // sheet4 init
                with (sheetObj) {
						// 높이 설정
						style.height = 150;
						// 전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						// Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						// 전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;

						// 전체Edit 허용 여부 [선택, Default false]
						Editable = true;

						// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo( 2, 1, 2, 100);

						// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(8, 0, 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);

						var HeadTitle = "|Over Day|Over Day|Rate Per Day|Rate Per Day|Rate Per Day|Rate Per Day|Rate Per Day";
						var HeadTitle2 = "|From|Up To|20 FT|40 FT|H/C|45 FT|R9";

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);
						InitHeadRow(1, HeadTitle2, true);

						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"hdnStatus");
						InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	false,	"ft_ovr_dys",		false,		"",		dfNone,		0,			false,		true,	3);
						InitDataProperty(0, cnt++ , dtData,    		75,		daCenter,	false,	"ft_und_dys",		false,		"",		dfNone,		0,			false,		true,	3);
						InitDataProperty(0, cnt++ , dtData,      	100,	daRight,	true,	"cntr_20ft_rt_amt",	false,		"",		dfFloat,	2,			false,		true,	22);
						InitDataProperty(0, cnt++ , dtData,      	100,	daRight,	true,	"cntr_40ft_rt_amt",	false,		"",		dfFloat,	2,			false,		true,	22);
						InitDataProperty(0, cnt++ , dtData,      	100,	daRight,	true,	"cntr_hc_rt_amt",	false,		"",		dfFloat,	2,			false,		true,	22);
						InitDataProperty(0, cnt++ , dtData,      	100,	daRight,	true,	"cntr_45ft_rt_amt",	false,		"",		dfFloat,	2,			false,		true,	22);
						InitDataProperty(0, cnt++ , dtData,      	100,	daRight,	true,	"cntr_r9_rt_amt",	false,		"",		dfFloat,	2,			false,		true,	22);

						CountPosition = 0;		// 건수 정보를 표시하지 않음.
						SelectHighLight = false;

	  				}
                break;

            case 4:      // sheet4 init
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

                    var HeadTitle1 = "|Tariff\nType|Coverage|ORG/\nDest.|BKG Term|Group Name|Effective Date|Expiration Date|CNTR & Cargo Type|CNTR & Cargo Type|F/T Commence|F/T Exclusion|F/T Exclusion|F/T Exclusion|Free Time|Free Time|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|expire_chk|wknd1|wknd2";
                    var HeadTitle2 = "|Tariff\nType|Coverage|ORG/\nDest.|BKG Term|Group Name|Effective Date|Expiration Date|CNTR|Cargo|F/T Commence|Sat|Sun|H/day|CNTR\nQ'ty|Free Day|Cur.|Over Day|20FT|40FT|H/C|45FT|R9|expire_chk|wknd1|wknd2";

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
//                    InitDataProperty(0, cnt++ , dtHidden,       70,     daCenterTop,       true,       "dmdt_de_term_cd",      false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         70,     daCenterTop,       true,       "dmdt_de_term_nm",      false,      "",     dfNone,     0,  false);
                    
                    InitDataProperty(0, cnt++ , dtData,         200,    daCenterTop,       true,       "dmdt_bzc_trf_grp_nm",  false,      "",     dfNone,     0,  false);
//                    InitDataProperty(0, cnt++ , dtHidden,       50,     daCenterTop,       true,       "trf_grp_seq");

                    InitDataProperty(0, cnt++ , dtData,         100,    daCenterTop,       true,       "eff_dt",               false,      "",     dfNone,     0,  false);
                    InitDataProperty(0, cnt++ , dtData,         110,    daCenterTop,       true,       "exp_dt",               false,      "",     dfNone,  0,  false);
                    InitDataProperty(0, cnt++ , dtData,         100,    daCenterTop,       false,      "dmdt_cntr_tp_cd",      false,      "",     dfNone,  0,  false);
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
                    InitDataProperty(0, cnt++ , dtData,         100,    daRightTop,       false,      "cntr_r9_rt_amt",     false,      "",     dfNullFloat,    2,  false);
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
			//조회
			case IBSEARCH:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.

				if (sheetObj.id == "sheet1") {
					if(ComGetObjValue(formObj.combo6) == "") {
						ComSetObjValue(formObj.yd_cd1, "");
					}
					ComSetObjValue(formObj.f_cmd, SEARCH);
					setParameters(SEARCH);
					//ComSetObjValue(formObj.cnt_cd, comboObjects[2].Text);

					if (validateForm(sheetObj,formObj,sAction)) {
						initResultControls();
						initResultText();						
						
                        //ComOpenWait Start
                        sheetObj.WaitImageVisible=false;
                        ComOpenWait(true);
                        
						var sXml = sheetObj.GetSearchXml("EES_DMT_4014GS.do", FormQueryString(formObj));
						sheetObj.LoadSearchXml(sXml);

                        //ComOpenWait End
                        ComOpenWait(false);
                        
						wknd1.innerHTML = ComGetEtcData(sXml, "WKND1");
						wknd2.innerHTML = ComGetEtcData(sXml, "WKND2");
						ComSetObjValue(formObj.wknd1, ComGetEtcData(sXml, "WKND1"));
						ComSetObjValue(formObj.wknd2, ComGetEtcData(sXml, "WKND2"));

						//sheet2, sheet3 자동 조회
						sheetObj.SelectCell(1,1);
						sheet1_OnClick(sheetObj, 1, 1, "");
						
                        //조회 옵션 사용불가
                        DisableControls();

					}
				}else if(sheetObj.id == "sheet2") {
					ComSetObjValue(formObj.f_cmd, SEARCH01);
					setParameters(SEARCH01);

                    //ComOpenWait Start
                    sheetObj.WaitImageVisible=false;
                    ComOpenWait(true);
                    
					sheetObj.DoSearch("EES_DMT_4014GS.do", FormQueryString(formObj));
					
                    //ComOpenWait End
                    ComOpenWait(false);
                    
					sheetObj.CellValue(sheetObj.LastRow, "ft_to_qty") = "";
				} else if(sheetObj.id == "sheet3") {
					ComSetObjValue(formObj.f_cmd, SEARCH02);
					setParameters(SEARCH02);
                    
					//ComOpenWait Start
                    sheetObj.WaitImageVisible=false;
                    ComOpenWait(true);

                    sheetObj.DoSearch("EES_DMT_4014GS.do", FormQueryString(formObj));

                    //ComOpenWait End
                    ComOpenWait(false);

					sheetObj.CellValue(sheetObj.LastRow, "ft_und_dys") = "";
                } else if (sheetObj.id == "sheet4") {
                    ComSetObjValue(formObj.f_cmd, SEARCH04 ); 

					//ComOpenWait Start
                    sheetObj.WaitImageVisible=false;
                    ComOpenWait(true);

                    //2.조회조건으로 조회실행
                    sheetObj.DoSearch("EES_DMT_4014GS.do", FormQueryString(formObj));
                        
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
				break;

			//Confirm
			case IBSAVE:
				ComSetObjValue(formObj.f_cmd, MODIFY );
				setParameters(MODIFY);
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				if(ComShowCodeConfirm('DMT00122')) {
 	 				//초기화
 	 				for(var i=1; i< sheetObj.TotalRows+1; i++) {
 						sheetObj.RowStatus(i) = "R";
 					}

 	 				for(var i=1; i< sheetObj.TotalRows+1; i++) {
 						sheetObj.RowStatus(i) = "U";
 					}
 					
					//ComOpenWait Start
                    sheetObj.WaitImageVisible=false;
                    ComOpenWait(true);

 					//Confirm 실행
 					sheetObj.DoSave("EES_DMT_4014GS.do", FormQueryString(formObj), -1, false);
 					
                    //ComOpenWait End
                    ComOpenWait(false);
 					
 	 				doActionIBSheet(sheetObj,formObj,IBSEARCH);

 				}
 				
 				
 				
				break;

			//Confirm Cancel
			case IBSAVE2:
				ComSetObjValue(formObj.f_cmd, MODIFY01 );
				setParameters(MODIFY01);
 				if(!validateForm(sheetObj,formObj,sAction)) return;

 				if(ComShowCodeConfirm('DMT01137')) {
	 				//초기화
	 				for(var i=1; i< sheetObj.TotalRows+1; i++) {
						sheetObj.RowStatus(i) = "R";
					}
	
	 				for(var i=1; i< sheetObj.TotalRows+1; i++) {
						sheetObj.RowStatus(i) = "U";
					}
	
					//Confirm Cancel실행
					sheetObj.DoSave("EES_DMT_4014GS.do", FormQueryString(formObj), -1, false);
					
	 				doActionIBSheet(sheetObj,formObj,IBSEARCH);
 				}

				break;
			
			//Delete
			case IBDELETE:
				ComSetObjValue(formObj.f_cmd, REMOVE );
				setParameters(REMOVE);
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				if(ComShowCodeConfirm('DMT01147')) {
 	 				//초기화
 	 				for(var i=1; i< sheetObj.TotalRows+1; i++) {
 						sheetObj.RowStatus(i) = "R";
 					}

 					var trf_seq = sheetObj.CellValue(sheetObj.SelectRow, "trf_seq");
 					var grp_seq = sheetObj.CellValue(sheetObj.SelectRow, "trf_grp_seq");
 					
                    //선택한 행만 삭제함
                    sheetObj.RowStatus(sheetObj.SelectRow) = "D";
//                    for(var i=1; i< sheetObj.TotalRows+1; i++) {
//                        sheetObj.RowStatus(i) = "D";
//                    }
 					
 					//Confirm 실행
 					sheetObj.DoSave("EES_DMT_4014GS.do", FormQueryString(formObj), -1, false);
 					
 	 				doActionIBSheet(sheetObj,formObj,IBSEARCH);

 				}

				break;
				

			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet1") {
					sheetObj.SpeedDown2Excel(-1);
				}; 
				break;
        }
    }
    /**
     * EES_DMT_1002, EES_DMT_1102 팝업 호출
     * @param url
     * @param sheetObj
     * @param formObject
     * @param srcName	버튼명(btn_Create, btn_Update, btn_Expire, btn_Copy)
     * @return
     */
    function openPopup(sheetObj, formObj, srcName) {
    	if(srcName == "btn_Create") {
//    		var exp_dt = sheetObj.CellValue(sheetObj.SelectRow, "exp_dt");
//    		var iCnt = 0;
//			//10개 CNTR/Cargo TYPE이 모두 생성된 이후에는 Expiration Date가 없는 Tariff Group 선택시
//    		if(sheetObj.TotalRows == 10) {
//    			if(exp_dt == "") {
//    				ComShowCodeMessage('DMT00116');//Pls expire the previous tariff first!
//    				return;
//    			}
//			}
//    		//exp_dt dup check
//    		for(var i=1; i< sheetObj.TotalRows+1 ; i++) {
//    			if(exp_dt != sheetObj.CellValue(i, "exp_dt")) {
//    				iCnt++;
//    			}
//    		}
//    		if(iCnt > 0) {
//    			ComShowCodeMessage('DMT00117');//Expiration Date different! Pls create tariff group separately!
//    			return;
//    		}
    		
			//parameter
			var cvrg_rgn_cd = "";
			var cvrg_ste_cd = "";
			var org_dest_rgn_cd = "";
			var org_dest_ste_cd = "";
			
			if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
				cvrg_rgn_cd	= "";
				cvrg_ste_cd = ComGetObjValue(formObj.cvrg_rgn_cd);
			}else {
				cvrg_rgn_cd	= ComGetObjValue(formObj.cvrg_rgn_cd);
				cvrg_ste_cd = "";
			}
			
//			if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
//				org_dest_rgn_cd	= "";
//				org_dest_ste_cd = ComGetObjValue(formObj.org_dest_rgn_cd);
//			}else {
//				org_dest_rgn_cd	= ComGetObjValue(formObj.org_dest_rgn_cd);
//				org_dest_ste_cd = "";
//			}
			
			
			var url = "EES_DMT_1002.do"
						+"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
						+"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
						+"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
						+"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
						+"&cvrg_rgn_cd="+cvrg_rgn_cd
						+"&cvrg_ste_cd="+cvrg_ste_cd
						+"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
						+"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
						+"&dmdt_de_term_cd="+ComGetObjValue(formObj.dmdt_de_term_cd)
                        +"&dmdt_de_term_nm="+ComGetObjValue(formObj.dmdt_de_term_nm)
						+"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
						+"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
						+"&org_dest_rgn_cd="+ComGetObjValue(formObj.org_dest_rgn_cd)
						+"&org_dest_ste_cd="+ComGetObjValue(formObj.org_dest_ste_cd)
						+"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
						+"&button_mode=C"
						+"&dmdt_bzc_trf_grp_nm="+sheetObj.CellValue(sheetObj.SelectRow, "dmdt_bzc_trf_grp_nm")
						+"&exp_dt="+ComTrim(sheetObj.CellValue(sheetObj.SelectRow, "exp_dt"))
						+"&wknd1="+ComGetObjValue(formObj.wknd1)
						+"&wknd2="+ComGetObjValue(formObj.wknd2)
						+"&svr_id="+ComGetObjValue(formObj.svr_id)
						+"&trf_seq="+ComGetObjValue(formObj.trf_seq)
						+"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
						+"&ui_code=4014"
                        +"&confirm_yn="+ComGetObjValue(formObj.confirm_yn)						
						;

			var returnValue = ComOpenWindowCenter(url, "EES_DMT_1002", "926","740", true);

			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
    		
    	}else if(srcName == "btn_Update") {
    		
			var rowIndex = sheetObj.SelectRow;
			
//			if(ComTrim(sheetObj.CellValue(rowIndex, "grp_cfm_flg")) == "Y") {
//				ComShowCodeMessage('DMT00118');//Already confirmed!'
//				return;
//			}    		
    		
//			//exp_dt 조회
//			var exp_dt = "";
//			var exp_dt_check = false;
//			var isFirst = false;
//			
//			for(var i=1; i< sheetObj.TotalRows+1 ; i++) {
//				
//				if(ComTrim(sheetObj.CellValue(i, "exp_dt")) == "") {
//					continue;
//				}
//				
//				if(!isFirst) {
//					isFirst = true;
//					exp_dt = ComTrim(sheetObj.CellValue(i, "exp_dt"));
//					continue;
//				}
//				
//				//exp_dt가 동일한지 체크
//				if(ComTrim(sheetObj.CellValue(i, "exp_dt")) != exp_dt) {
//					exp_dt_check = true;
//					break;
//				}
//				exp_dt = ComTrim(sheetObj.CellValue(i, "exp_dt"));
//			}
//			
//			if(exp_dt_check) {
//				ComShowCodeMessage('DMT00127');//Expiration Date different! Pls create tariff group separately!
//				return;
//			}


			//parameter
			var cvrg_rgn_cd = "";
			var cvrg_ste_cd = "";
			var org_dest_rgn_cd = "";
			var org_dest_ste_cd = "";
			
			if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
				cvrg_rgn_cd	= "";
				cvrg_ste_cd = ComGetObjValue(formObj.cvrg_rgn_cd);
			}else {
				cvrg_rgn_cd	= ComGetObjValue(formObj.cvrg_rgn_cd);
				cvrg_ste_cd = "";
			}
			
			if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
				org_dest_rgn_cd	= "";
				org_dest_ste_cd = ComGetObjValue(formObj.org_dest_rgn_cd);
			}else {
				org_dest_rgn_cd	= ComGetObjValue(formObj.org_dest_rgn_cd);
				org_dest_ste_cd = "";
			}
			
			var url = "EES_DMT_1002.do"
				+"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
				+"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
				+"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
				+"&cvrg_rgn_cd="+cvrg_rgn_cd
				+"&cvrg_ste_cd="+cvrg_ste_cd
				+"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
				+"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
				+"&dmdt_de_term_cd="+ComGetObjValue(formObj.dmdt_de_term_cd)
                +"&dmdt_de_term_nm="+ComGetObjValue(formObj.dmdt_de_term_nm)
				+"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
				+"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
				+"&org_dest_rgn_cd="+org_dest_rgn_cd
				+"&org_dest_ste_cd="+org_dest_ste_cd
				+"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
				+"&button_mode=U"
				+"&exp_dt="+ComTrim(sheetObj.CellValue(sheetObj.SelectRow, "exp_dt"))
				+"&wknd1="+ComGetObjValue(formObj.wknd1)
				+"&wknd2="+ComGetObjValue(formObj.wknd2)
				+"&svr_id="+ComGetObjValue(formObj.svr_id)
				+"&trf_seq="+ComGetObjValue(formObj.trf_seq)
				+"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
				+"&ui_code=4014"
				;

			var returnValue = ComOpenWindowCenter(url, "EES_DMT_1002", "926","740", true);

			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
			
    					
    	}else if(srcName == "btn_Expire") {
    		var rowIndex = sheetObj.SelectRow;
//    		if(ComTrim(sheetObj.CellValue(rowIndex, "exp_dt")) != "") {
//				//ComShowCodeMessage('DMT00118');//Already confirmed!'
//    			alert("Expire Completed!");
//				return;
//			}
			//parameter
			var cvrg_rgn_cd = "";
			var cvrg_ste_cd = "";
			var org_dest_rgn_cd = "";
			var org_dest_ste_cd = "";
			
			if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
				cvrg_rgn_cd	= "";
				cvrg_ste_cd = ComGetObjValue(formObj.cvrg_rgn_cd);
			}else {
				cvrg_rgn_cd	= ComGetObjValue(formObj.cvrg_rgn_cd);
				cvrg_ste_cd = "";
			}
			
			if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
				org_dest_rgn_cd	= "";
				org_dest_ste_cd = ComGetObjValue(formObj.org_dest_rgn_cd);
			}else {
				org_dest_rgn_cd	= ComGetObjValue(formObj.org_dest_rgn_cd);
				org_dest_ste_cd = "";
			}
			
			var url = "EES_DMT_1002.do"
				+"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
				+"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
				+"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
				+"&cvrg_rgn_cd="+cvrg_rgn_cd
				+"&cvrg_ste_cd="+cvrg_ste_cd
				+"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
				+"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
				+"&dmdt_de_term_cd="+ComGetObjValue(formObj.dmdt_de_term_cd)
                +"&dmdt_de_term_nm="+ComGetObjValue(formObj.dmdt_de_term_nm)
				+"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
				+"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
				+"&org_dest_rgn_cd="+org_dest_rgn_cd
				+"&org_dest_ste_cd="+org_dest_ste_cd
				+"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
				+"&button_mode=E"
				+"&exp_dt="+ComTrim(sheetObj.CellValue(sheetObj.SelectRow, "exp_dt"))
				+"&wknd1="+ComGetObjValue(formObj.wknd1)
				+"&wknd2="+ComGetObjValue(formObj.wknd2)
				+"&svr_id="+ComGetObjValue(formObj.svr_id)
				+"&trf_seq="+ComGetObjValue(formObj.trf_seq)
				+"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
				+"&ui_code=4014"
				;

			var returnValue = ComOpenWindowCenter(url, "EES_DMT_1002", "926","740", true);

			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}

    		
    	}else if(srcName == "btn_Copy") {
    		//parameter
			var cvrg_rgn_cd = "";
			var cvrg_ste_cd = "";
			var org_dest_rgn_cd = "";
			var org_dest_ste_cd = "";
			
			if(ComGetObjValue(formObj.cvrg_cnt_cd) == "US" || ComGetObjValue(formObj.cvrg_cnt_cd) == "CA") {
				cvrg_rgn_cd	= "";
				cvrg_ste_cd = ComGetObjValue(formObj.cvrg_rgn_cd);
			}else {
				cvrg_rgn_cd	= ComGetObjValue(formObj.cvrg_rgn_cd);
				cvrg_ste_cd = "";
			}
			
			if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
				org_dest_rgn_cd	= "";
				org_dest_ste_cd = ComGetObjValue(formObj.org_dest_rgn_cd);
			}else {
				org_dest_rgn_cd	= ComGetObjValue(formObj.org_dest_rgn_cd);
				org_dest_ste_cd = "";
			}
			
			var url = "EES_DMT_1101.do"
				+"?dmdt_trf_cd="+ComGetObjValue(formObj.dmdt_trf_cd)
				+"&dmdt_trf_nm="+ComGetObjValue(formObj.dmdt_trf_nm)
				+"&cvrg_conti_cd="+ComGetObjValue(formObj.cvrg_conti_cd)
				+"&cvrg_cnt_cd="+ComGetObjValue(formObj.cvrg_cnt_cd)
				+"&cvrg_rgn_cd="+cvrg_rgn_cd
				+"&cvrg_ste_cd="+cvrg_ste_cd
				+"&cvrg_loc_cd="+ComGetObjValue(formObj.cvrg_loc_cd)
				+"&cvrg_yd_cd="+ComGetObjValue(formObj.cvrg_yd_cd)
				+"&dmdt_de_term_cd="+ComGetObjValue(formObj.dmdt_de_term_cd)
                +"&dmdt_de_term_nm="+ComGetObjValue(formObj.dmdt_de_term_nm)
				+"&org_dest_conti_cd="+ComGetObjValue(formObj.org_dest_conti_cd)
				+"&org_dest_cnt_cd="+ComGetObjValue(formObj.org_dest_cnt_cd)
				+"&org_dest_rgn_cd="+org_dest_rgn_cd
				+"&org_dest_ste_cd="+org_dest_ste_cd
				+"&org_dest_loc_cd="+ComGetObjValue(formObj.org_dest_loc_cd)
				+"&svr_id="+ComGetObjValue(formObj.svr_id)
				+"&trf_seq="+ComGetObjValue(formObj.trf_seq)
				+"&trf_grp_seq="+ComGetObjValue(formObj.trf_grp_seq)
				+"&ui_code=4014"
				;
			
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_1101", "921","355", true);

			if(returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
    		
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
    	var msg ="";
    	
    	with(formObj) {
    		
    		switch(sAction) {
    			case IBSEARCH:      //조회
    		
		        	//Coverage Continent Valid check
		        	if(ComTrim(ComGetObjValue(formObj.dmdt_trf_cd)) == "") {
		        		ComAlertFocus(formObj.combo1, ComGetMsg('COM12113', "Tariff Type"));
		        		return false;
		        	}
		        	//Coverage Continent Valid check
		        	if(ComTrim(ComGetObjValue(formObj.cvrg_conti_cd)) == "") {
		        		ComAlertFocus(formObj.combo2, ComGetMsg('COM12113', "Coverage Continent"));
		        		return false;
		        	}
		        	
		        	//Coverage Country Valid check
		        	if(ComTrim(ComGetObjValue(formObj.cvrg_cnt_cd)) == "") {
		        		ComAlertFocus(formObj.combo4, ComGetMsg('COM12113', "Coverage Country"));
		        		return false;
		        	}
//		        	if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMOF" || ComGetObjValue(formObj.dmdt_trf_cd) == "DTOC" || 
//		        		ComGetObjValue(formObj.dmdt_trf_cd) == "CTOC") {
		        	if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMOF"){
		        		msg = DESTINATION;
//		        	} else if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMIF" ||	ComGetObjValue(formObj.dmdt_trf_cd) == "DTIC" || 
//		        		ComGetObjValue(formObj.dmdt_trf_cd) == "CTIC") {
		        	} else if(ComGetObjValue(formObj.dmdt_trf_cd) == "DMIF") {
		        		msg = ORIGIN;
		        	}
		        	
		        	//Orgin/Dest Continent Valid check
		        	if(ComTrim(ComGetObjValue(formObj.org_dest_conti_cd)) == "") {
		        		ComAlertFocus(formObj.combo6, ComGetMsg('COM12113', msg+" Continent"));
		        		return false;
		        	}
		        	break;
    			case IBSAVE:	//Confirm
    				var rowIndex = sheetObj.SelectRow;
    				
    				//Confirm 상태일 경우
//    				if(ComTrim(sheetObj.CellValue(rowIndex, "grp_cfm_flg")) == "Y") {
//    					ComShowCodeMessage('DMT00118');
//    					return false;
//    				}
    				//10개 
    				if(sheetObj.TotalRows != 10) {
    					ComShowCodeMessage("DMT00121");
    					return false;
    				}
    				
    				
//    				var exp_dt_cnt = 0;
//    				 				
//    				
//    				for(var i=1; i< sheetObj.TotalRows+1 ; i++) {
//    					//exp_dt가 존재하는지 
//    					if(ComTrim(sheetObj.CellValue(i, "exp_dt")) != "") {
//    						exp_dt_cnt++;
//    					}
//    				}
//    				//Expiration Date가 있는 경우
//    				if(exp_dt_cnt > 0) {
//    					ComShowCodeMessage('DMT00121');
//    					return false;
//    				}
    				
    				
    				break;    				

    			case IBSAVE2:	//Confirm Cancel
    				
    				var rowIndex = sheetObj.SelectRow;
    				
    				if(ComTrim(sheetObj.CellValue(rowIndex, "grp_cfm_flg")) == "N") {
    					ComShowCodeMessage('DMT00123');//Not in confirmed staus!
    					return false;
    				}
                    //eff_day가 미래시점인지 체크
                    for(var i = 1 ; i < sheetObj.TotalRows+1 ; i++ ) {
                    	if(ComTrim(sheetObj.CellValue(i, "eff_day")) < 0) {
                          ComShowCodeMessage('DMT00124');//Only for future tariff!
                          return false;
                      }
                    }

    				
    				break;
    			
    			case IBDELETE:	//Delete
    				
    				var rowIndex = sheetObj.SelectRow;
    				if(ComTrim(sheetObj.CellValue(rowIndex, "grp_cfm_flg")) == "Y") {
    					ComShowCodeMessage('DMT00118');//Already confirmed!
    					return false;
    				}
    				
    				break;
	        
    		}

    	}
    	
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
		var i = 0;
	    
	    switch(comboNo) { 
	    	//Tariff Type
	    	case 1:
	    		with (comboObj) {
					MultiSelect = false; 
					UseAutoComplete = true;	
					SetColAlign("left|left");        
					SetColWidth("55|330");
					DropHeight = 160;
					ValidChar(2,0);		//영문 대문자
					IMEMode = 0;
					MaxLength = 4;
	    		}
	    		break;
	    	
		    //Coverage Yard
	    	case 2:
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
            case 3:
            	var arrDmdtDeTermCdCode = f_dmdt_de_term_cdCode.split("|");
            	var arrDmdtDeTermCdText = f_dmdt_de_term_cdText.split("|");
            	
            	with (comboObj) {
	                MultiSelect = false; 
	                UseAutoComplete = false;    
	                SetColAlign("left");
	                SetColWidth("50");
	                DropHeight = 60;
	                ValidChar(2,1);     //영문 대문자, 숫자
	                MaxLength = 2;

	                for (var j=0; j<arrDmdtDeTermCdText.length; j++){
						InsertItem(i++,  arrDmdtDeTermCdText[j],  arrDmdtDeTermCdCode[j]);
					}
	                
	                comboObjects[2].Code = "N";	// Default로 초기화.
            	}
            	
            	break;
            	
	    	//Continent
	    	case 4: 
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
	    	case 5:
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
	    	case 6:
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
	    	
	     } 		
	} 	
	
	/*
	 * 버튼 초기화
	 */
	function initButton() {
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnDisable("btn_Create");
		ComBtnDisable("btn_Update");
		ComBtnDisable("btn_Confirm");
		ComBtnDisable("btn_Expire");
		ComBtnDisable("btn_ConfirmCancel");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Copy");
		ComBtnEnable("btn_DownExcel");
		
	}
	
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;

		//Triff Type ComboSettion
		ComSetObjValue(formObj.dmdt_trf_cd, comboObjects[0].Text);

		//Coverage ComboSetting
		ComSetObjValue(formObj.cvrg_conti_cd, ComGetObjValue(formObj.cvrg_continent));
		ComSetObjValue(formObj.cvrg_cnt_cd, ComGetObjValue(formObj.cvrg_country));
		ComSetObjValue(formObj.cvrg_rgn_cd, ComGetObjValue(formObj.cvrg_region));
		ComSetObjValue(formObj.cvrg_loc_cd, ComGetObjValue(formObj.cvrg_location));
		ComSetObjValue(formObj.cvrg_yd_cd, comboObjects[1].Code);
		
		ComSetObjValue(formObj.dmdt_de_term_cd,  comboObjects[2].Code);		//Dem/det Delivery Term Code
        ComSetObjValue(formObj.dmdt_de_term_nm,  comboObjects[2].Text);		//Dem/det Delivery Term Name
        
		//Origin/Dest ComboSettion
		ComSetObjValue(formObj.org_dest_conti_cd, comboObjects[3].Text);
		ComSetObjValue(formObj.org_dest_cnt_cd, comboObjects[4].Text);
		if(ComGetObjValue(formObj.org_dest_cnt_cd) == "US" || ComGetObjValue(formObj.org_dest_cnt_cd) == "CA") {
			ComSetObjValue(formObj.org_dest_rgn_cd, "");
			ComSetObjValue(formObj.org_dest_ste_cd, comboObjects[5].Text);
		}else{
			ComSetObjValue(formObj.org_dest_rgn_cd, comboObjects[5].Text);
			ComSetObjValue(formObj.org_dest_ste_cd, "");
		}
		ComSetObjValue(formObj.org_dest_loc_cd, ComGetObjValue(formObj.org_dest_location));
		
		ComSetObjValue(formObj.trf_seq, sheetObjects[0].CellValue(sheetObjects[0].SelectRow , "trf_seq"));
		ComSetObjValue(formObj.trf_grp_seq, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "trf_grp_seq"));
		ComSetObjValue(formObj.svr_id, sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "svr_id"));
		
	}	
	
	//Tariff Type 선택 이벤트
	function combo1_OnChange(comboObj, Index_Code, Text) {
		if(comboObj.Text.length < 4) {
			comboObj.Text = "";
			ComSetFocus(comboObj);
			return;
		}
		
		search_combo1(comboObj, Index_Code, Text);
	}
	function search_combo1(comboObj, searchIndex, searchText) {
		
		var formObj = document.form;
		
		if (comboObj.Text.length == 0 ){
			ComSetObjValue(formObj.dmdt_trf_nm, "");
			comboObj.Text = "";
			ComSetFocus(comboObj);
			return;
		}
		ComSetObjValue(formObj.dmdt_trf_nm, comboObj.GetText(searchIndex,1));	//텍스트 컬럼 보여주기
		var tariffType = ComTrim(comboObj.GetText(searchIndex, 0));
		
		if (tariffType == "DMOF" ) {
			OriginDest.innerHTML = DESTINATION;
		}
		else if (tariffType == "DMIF" || tariffType == ""){
			OriginDest.innerHTML = ORIGIN;
		}
	}
	function combo1_OnBlur(comboObj) {
		var formObj = document.form;
		var sIndexCode 	= comboObj.Index;
		var sText 		= comboObj.Text;
		
		if(sIndexCode == -1) {
			comboObj.Text = "";
			ComSetObjValue(formObj.dmdt_trf_nm, "");
		}
	}
	
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		if(KeyCode == 13) {
			var sIndexCode 	= comboObj.Index;
			var sText 		= comboObj.Text;
			
			//이벤트 처리
			//combo1_OnChange(comboObj, sIndexCode, sText);
			search_combo1(comboObj, sText, sText)
			
			//자동조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
			isNoChangeActive = true;
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH14,YARD,obj);
			isNoChangeActive = false;
    	}
	}

	/*
	 * Yard Combo 이벤트
	 * Location 을 포함하는 Continent, Country 와 Region or State 정보를 조회하는 함수
	 */		
	function combo2_OnChange(comboObj, Index_Code, Text) {
		search_combo2(comboObj, Index_Code, Text);
	}

	function search_combo2(comboObj, searchIndex, searchText) {
		if(comboObj.Text.length == 0 ) return;
		
		if(isNoChangeActive) return;
		
		if(searchIndex == undefined || searchIndex == ""){//2009.10.14 yard code값이 존재하지 않으면 강제로 입력 값을 지운다.
			comboObj.Text = "";	
			return;
		}
	}
	
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
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
	 * Continent Combo 이벤트
	 * 그 소속의 Country정보를 조회해주는 함수
	 */		
	function combo4_OnChange(comboObj, Index_Code, Text) {
		search_combo4(comboObj, Index_Code, Text);
	}
	function search_combo4(comboObj, searchIndex, searchText) {
		if (comboObj.Text.length == 0 ) return;
		
		if (isNoChangeActive) return;

		var formObj = document.form;
		
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,comboObj);	//CountryListByContinent
		//Region 초기화
		doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObj);		//SearchRegionList
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
	 * Country Combo 이벤트
	 * 그 소속의 Continent, Region or State 정보를 조회해주는 함수
	 */		
	function combo5_OnChange(comboObj, Index_Code, Text) {
		search_combo5(comboObj, Index_Code, Text);
	}
	function search_combo5(comboObj, searchIndex, searchText) {
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
	 * Region or State Combo 이벤트
	 * 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function combo6_OnChange(comboObj, Index_Code, Text) {
		search_combo6(comboObj, Index_Code, Text);
	}
	function search_combo6(comboObj, searchIndex, searchText) {
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
	
	//Sheet1 체크 이벤트
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		//if(sheetObj.SelectCol == 1) {
		
			var formObj = document.form;
			
			var sat_check = false;
			var sun_check = false;
			var hol_check = false;
			if(ComTrim(sheetObj.CellValue(Row, "xcld_sat_flg")) == "Y") {
				sat_check = true;
			}
			if(ComTrim(sheetObj.CellValue(Row, "xcld_sun_flg")) == "Y") {
				sun_check = true;
			}
			if(ComTrim(sheetObj.CellValue(Row, "xcld_hol_flg")) == "Y") {
				hol_check = true;
			}
			
			//F/Time Exclusion 조회이벤트
			doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);		

			ComSetObjValue(formObj.xcld_sat_flg, sat_check);
			ComSetObjValue(formObj.xcld_sun_flg, sun_check);
			ComSetObjValue(formObj.xcld_hol_flg, hol_check);
			
			ComSetObjValue(formObj.dmdt_chg_cmnc_tp_nm, ComTrim(sheetObj.CellValue(Row, "dmdt_chg_cmnc_tp_nm")));
			ComSetObjValue(formObj.cmnc_hr, ComTrim(sheetObj.CellValue(Row, "cmnc_hr")));
			ComSetObjValue(formObj.curr_cd, ComTrim(sheetObj.CellValue(Row, "curr_cd")));
	
			//F/Time Commence 조회이벤트
			doActionIBSheet(sheetObjects[2],formObj,IBSEARCH);
		//}
    }
	/**
	 * sheet1 조회 후 버튼 셋팅
	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		
		
		var formObj = document.form;
		//전체조회 일 경우는 Confirmed input box Setting
		ComSetObjValue(formObj.confirm_yn, ComTrim(sheetObj.CellValue(1, "rgn_cfm_flg")));	//region confirm
		
		//버튼 셋팅
		var temp_cnt = 0;
		var temp_cnt2 = 0;
		
		//Confirm status
		var confirm_st = ComGetObjValue(formObj.confirm_yn);
		//Tariff Group Status Y check
		var cnt_grp_confirm = 0;
		
		
		for(var i = 1; i < sheetObj.TotalRows+1; i++) {
			//exp_dt의 값이 존재하지 않는 경우
			if(ComTrim(sheetObj.CellValue(i, "exp_dt")) == "") {
				temp_cnt++;
			}
			
			//eff_dt의 값이 미래의 값인지 체크
			if(ComTrim(sheetObj.CellValue(i, "eff_day")) > 0) {
				temp_cnt2++;
			}
			
			//Tariff group confirm status
			if(ComTrim(sheetObj.CellValue(i, "grp_cfm_flg")) == "Y") {
				cnt_grp_confirm++;
			}
			
		}				
		
		//1.Create(disable : 10개 이면서 exp_dt 가 모두 ""인 경우)
		//if(sheetObj.TotalRows == 10 && temp_cnt == 10 ) {
		if(sheetObj.TotalRows == 10) {
			ComBtnDisable("btn_Create");
		} else {
			ComBtnEnable("btn_Create");
		}
		//2.Update
		if(confirm_st == "Y") {
			ComBtnDisable("btn_Update");
		}else if(confirm_st == "N"){
			ComBtnEnable("btn_Update");
		}else {
			ComBtnDisable("btn_Update");
		}
		//3.Confirm
		if(confirm_st == "Y") {
			ComBtnDisable("btn_Confirm");
		//}else if(confirm_st == "N" && sheetObj.TotalRows == 10){
		//	ComBtnEnable("btn_Confirm");
		}else if(confirm_st == "N") {
			ComBtnEnable("btn_Confirm");
		}else {
			ComBtnDisable("btn_Confirm");
		}

		//4.Expire -- logic 점검 필요
		//if(confirm_st == "Y" && temp_cnt == 10) {
//		if(cnt_grp_confirm == 10) {
//			if(temp_cnt == 0) {
//				ComBtnDisable("btn_Expire");
//			}else{
//				ComBtnEnable("btn_Expire");
//			}
//		}else{
//			ComBtnDisable("btn_Expire");
//		}
		if(cnt_grp_confirm > 0) {
			ComBtnEnable("btn_Expire");
		}else {
			ComBtnDisable("btn_Expire");
		}
		
		
		
		//5.Confirm Cancel
		if(confirm_st == "N") {
			ComBtnDisable("btn_ConfirmCancel");
		}else if(confirm_st == "Y"  && sheetObj.TotalRows == 10){
			ComBtnEnable("btn_ConfirmCancel");
		}else {
			ComBtnDisable("btn_ConfirmCancel");
		}
		
		//6.Delete
        if(confirm_st == "Y") {
            ComBtnDisable("btn_Delete");
        }else if(confirm_st == "N") {
        	ComBtnEnable("btn_Delete");
//if(cnt_grp_confirm > 0 ) {
//                ComBtnDisable("btn_Delete");
//            }else if(sheetObj.TotalRows > 0){
//                ComBtnEnable("btn_Delete");
//            }
        }else {
            ComBtnDisable("btn_Delete");
        }
		//7.Copy
		if(sheetObj.TotalRows == 10 && temp_cnt == 10) {
			ComBtnEnable("btn_Copy");
		}else{
			ComBtnDisable("btn_Copy");
		}
		
	}

	/**
	 * 저장 후 메시지를 띄워준다.- MESSAGE가 두번 발생하여 삭제함
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
//	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
//		if(ErrMsg != "") {
//			alert(ErrMsg);	
//		}
//		var formObject = document.form;
//		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);		
//	}
	
	/**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem = comboItems[0].split(FIELDMARK);
		comboObj.Text = checkedItem[0];
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
						//0. 화면로딩시 전체 조회(Tariff, Continent, Country, Region)
                		case SEARCHLIST07:
	                        //1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
	                		ComSetObjValue(formObj.f_cmd, SEARCHLIST07); 
	                        //2.조회조건으로 조회실행                 
	                        var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	
	                		//TARIFF LIST
	                		comboItems = ComGetEtcData(sXml, COMMON_TARIFF_CD).split(ROWMARK);	
	                		var comboItemsTariff = new Array();
							for (var i = 0 ; i < comboItems.length ; i++) {
								var comboItem = comboItems[i].split(FIELDMARK);
								
								if(comboItem[0] == "DMIF") {
									comboItemsTariff[0] = comboItems[i];
								}else if(comboItem[0] == "DMOF") {
									comboItemsTariff[1] = comboItems[i];
								}
							}
							
							addComboItem(comboObjects[0],comboItemsTariff);

							//Coverage Continent
	                		comboDatas = ComGetEtcData(sXml, CONTINENT);
	                		if (comboDatas != undefined) {
	                            comboItems = comboDatas.split(ROWMARK);
	                            //선태가능한 상태로 변경
	                            comboObjects[3].Code="-1";
	                            comboObjects[3].RemoveAll();
	                            addComboItem(comboObjects[3],comboItems);
	                        }
	                		
	                		//Coverage Country 
	                		comboDatas = ComGetEtcData(sXml, COUNTRY);
	                        if (comboDatas != undefined) {
	                            comboItems = comboDatas.split(ROWMARK);
	                            comboObjects[4].Code = "-1";
	                            comboObjects[4].RemoveAll();
	                            addComboItem(comboObjects[4],comboItems); //COUNTRY
	                        }
	                        
	                        //Coverage Region
	                        comboDatas = ComGetEtcData(sXml, REGION);
	                        if (comboDatas != undefined) {
	                            comboItems = comboDatas.split(ROWMARK);
	                            comboObjects[5].Code = "-1";
	                            comboObjects[5].RemoveAll();
	                            addComboItem(comboObjects[5],comboItems); //Region
	                        }
	                	
	                		break;					
						//1. TARIFF LIST
						case SEARCHLIST:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCHLIST); 
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboItems = ComGetEtcData(sXml, sComboKey).split(ROWMARK);

							var comboItemsTariff = new Array();
							for (var i = 0 ; i < comboItems.length ; i++) {
								var comboItem = comboItems[i].split(FIELDMARK);
								
								if(comboItem[0] == "DMIF") {
									comboItemsTariff[0] = comboItems[i];
								}else if(comboItem[0] == "DMOF") {
									comboItemsTariff[1] = comboItems[i];
								}
							}
							
							addComboItem(sObj,comboItemsTariff);						
							break;							
							
					
						//2. CONTINENT LIST
						case SEARCH08:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH08);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems = comboDatas.split(ROWMARK);
								//선태가능한 상태로 변경
								comboObjects[3].Code="-1";
								comboObjects[3].RemoveAll();
								addComboItem(comboObjects[3],comboItems);	//CONTINENT
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
								
							}
	
							break;
						//2. COUNTRY LIST
						case SEARCH02:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH02);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems = comboDatas.split(ROWMARK);
								//선태가능한 상태로 변경
								comboObjects[4].Code="-1";
								comboObjects[4].RemoveAll();
								addComboItem(comboObjects[4],comboItems);	//COUNTRY
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
						//3. REGION LIST
						case SEARCH01:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH01);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, sComboKey);
							if (comboDatas != undefined && comboDatas != "") {
								comboItems = comboDatas.split(ROWMARK);
								//선태가능한 상태로 변경
								comboObjects[5].Code="-1";
								comboObjects[5].RemoveAll();
								addComboItem(comboObjects[5],comboItems);	//REGION
								
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
	
							break;
							
						//4. Location을 입력시 조회-- (loc_cd,rgn_cd,ste_cd,cnt_cd,conti_cd)
						case SEARCH10:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH10);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							if(sObj.name == "cvrg_location" || sObj.name == "yd_cd1") {
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
											ComSetObjValue(formObj.yd_cd1, location);
											isNoChangeActive = false;
											checkYard1_sub2(formObj.yd_cd1);
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
									setComboItem(comboObjects[3],comboItems);		//Continent
									
									//Country List 조회
									comboObjects[4].Code = "-1";
									comboObjects[4].RemoveAll();					//Country		
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
									
									//Country Setting
									comboDatas = ComGetEtcData(sXml, COUNTRY);
		
									if (comboDatas != undefined && comboDatas != "") {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[4],comboItems);
										
										//Region/State List 조회
										comboObjects[5].Code = "-1";
										comboObjects[5].RemoveAll();				//Region
										doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
		
										if(location.substring(0,2) == "CA" || location.substring(0,2) == "US") {
											comboDatas = ComGetEtcData(sXml, STATE);
						    			}else{
											comboDatas = ComGetEtcData(sXml, REGION);
						    			}
		
										if (comboDatas != undefined && comboDatas != "") {
											comboItems = comboDatas.split(ROWMARK);
											setComboItem(comboObjects[5],comboItems);	//Region
											
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
						//4. Continent에 해당되는 CONTRY 정보 조회
						case SEARCH06:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH06);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								if(comboDatas != "") {
									comboItems = comboDatas.split(ROWMARK);
									comboObjects[4].Code = "-1";
									comboObjects[4].RemoveAll();
									addComboItem(comboObjects[4],comboItems);	//Country
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
							ComSetObjValue(formObj.f_cmd, SEARCH12);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							comboDatas = ComGetEtcData(sXml, CONTINENT);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[3],comboItems);	//Continent
							}else{
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
								
						//5. Country가 변경시에 해당 하는 Region 정보 조회
						case SEARCH03:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH03);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							clearLocation2();
							
							if(comboObjects[4].Text == "CA" || comboObjects[4].Text == "US" ) {
								//State
								comboDatas = ComGetEtcData(sXml, STATE);
							}else{
								comboDatas = ComGetEtcData(sXml, REGION);
							}
							
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								comboObjects[5].Code = "-1";
								comboObjects[5].RemoveAll();				//Region						
								addComboItem(comboObjects[5],comboItems);
							}else {
								ComShowCodeMessage("DMT06001");
								clearObjectValue(sObj);
							}
							break;
							
						//6. State,Region를 변경시에 해당 하는 Continet, Country, State 정보 조회
						case SEARCH17:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH17);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							clearLocation2();
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							
							if (comboDatas != undefined && comboDatas != "") {
								//Continent Setting
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[3],comboItems);		//Continent
								
								//Country List 조회
								comboObjects[4].Code = "-1";
								comboObjects[4].RemoveAll();		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
	
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined && comboDatas != "") {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[4],comboItems);	//Country
									
									//Region/State List 조회
									comboObjects[5].Code = "-1";
									comboObjects[5].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
	
									comboDatas = ComGetEtcData(sXml, sComboKey);
									
									if (comboDatas != undefined && comboDatas != "") {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[5],comboItems);	//Region
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
						case SEARCH13:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH13);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							clearLocation2();
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, CONTINENT);
							
							if (comboDatas != undefined && comboDatas != "") {
								//Continent Setting
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[3],comboItems);		//Continent
								
								//Country List 조회
								comboObjects[4].Code = "-1";
								comboObjects[4].RemoveAll();		
								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
	
								//Country Setting
								comboDatas = ComGetEtcData(sXml, COUNTRY);
	
								if (comboDatas != undefined && comboDatas != "") {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[4],comboItems);	//Country
									
									//Region/State List 조회
									comboObjects[5].Code = "-1";
									comboObjects[5].RemoveAll();				//Region
									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
	
									comboDatas = ComGetEtcData(sXml, sComboKey);
									
									if (comboDatas != undefined && comboDatas != "") {
										comboItems = comboDatas.split(ROWMARK);
										setComboItem(comboObjects[5],comboItems);	//Region
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
	
						
						//Yard 입력완료시 Yard List 조회
						case SEARCH14:
							//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
							ComSetObjValue(formObj.f_cmd, SEARCH14);
							setComboParameters(sComboAction, sObj);
							
							//2.조회조건으로 조회실행					
							var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));

							var yd_cd1 = ComGetObjValue(sObj);
							ComSetObjValue(formObj.cvrg_location, yd_cd1);
							
							//Continent 콤보 Empty 상태로 초기화
							comboObjects[1].Code = "-1";
							comboObjects[1].RemoveAll();						
							//Country 콤보 조회된 데이터로 선택
							comboDatas = ComGetEtcData(sXml, YARD);

							if (comboDatas == undefined ||comboDatas == "") {
								//ComShowCodeMessage("DMT06001");
								//ComSetObjValue(formObj.cvrg_location, "");
								//ComSetObjValue(formObj.yd_cd1, "");
								
							}else{
								
								comboItems = comboDatas.split(ROWMARK);
								addComboItem1(comboObjects[1],comboItems);	
								setComboItem(comboObjects[1],comboItems);
								
							}
							break;
						//Yard 선택시 Continent, Country, Location를 조회
//						case COMMAND03:
//							index_1 = 1;
//							index_2 = 2;
//							index_3 = 3;
//							
//							
//							//Continent 조회
//							comboDatas = ComGetEtcData(sXml, CONTINENT);
//
//							if (comboDatas != undefined && comboDatas != "") {
//								//Continent Setting
//								comboItems = comboDatas.split(ROWMARK);
//								setComboItem(comboObjects[index_1],comboItems);
//								//Country List 조회
//								comboObjects[index_2].Code = "-1";
//								comboObjects[index_2].RemoveAll();		
//								doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH06,COUNTRY,sObj);//searchCountryListByContinent
//								
//								//Country Setting
//								comboDatas = ComGetEtcData(sXml, COUNTRY);
//
//								if (comboDatas != undefined && comboDatas != "") {
//									comboItems = comboDatas.split(ROWMARK);
//									setComboItem(comboObjects[index_2],comboItems);
//									
//									//Region/State List 조회
//									comboObjects[index_3].Code = "-1";
//									comboObjects[index_3].RemoveAll();
//									doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH03,COUNTRY,sObj);//searchRegionListByCountry
//
//									//Region/State Setting
//									if(comboObjects[index_2].Text == "CA" || comboObjects[index_2].Text == "US" ) {
//										comboDatas = ComGetEtcData(sXml, STATE);
//									}else{
//										comboDatas = ComGetEtcData(sXml, REGION);
//									}
//									
//									if (comboDatas != undefined && comboDatas != "") {
//										comboItems = comboDatas.split(ROWMARK);
//										setComboItem(comboObjects[index_3],comboItems);
//										
//										//location setting
//										ComSetObjValue(formObj.cvrg_location, ComGetObjValue(formObj.yd_cd1));
//									}else{
//										ComShowCodeMessage("DMT06001");
//										clearObjectValue(sObj);
//									}
//								}else{
//									ComShowCodeMessage("DMT06001");
//									clearObjectValue(sObj);
//								}
//								
//							}else{
//								ComShowCodeMessage("DMT06001");
//								clearObjectValue(sObj);
//							}
//
//							break;								
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
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);		
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
	 * Yard 조회필드정보 초기화
	 * @return
	 */
	function clearYard() {
		var formObj = document.form;
		comboObjects[1].Code = "-1";
		comboObjects[1].RemoveAll();
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		ComSetObjValue(formObj.yd_cd, "");
	}
	
	/*
	 * Combo 공통 코드를 조회한다.
	 */
	function setComboParameters(sComboAction, sObj) {
		var formObj = document.form;
		
		switch(sObj.name) {
			case "combo2":
			case "cvrg_location":
			case "yd_cd1":
				//Coverage ComboSetting
				if(sObj.name == "cvrg_location") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));
				} else if(sObj.name == "yd_cd1") {
					ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.yd_cd1));
				}
				ComSetObjValue(formObj.yd_cd, comboObjects[1].Code);
				break;						

			case "combo4":
			case "combo5":
			case "combo6":
			case "org_dest_location":
				//Origin/Dest ComboSettion
				ComSetObjValue(formObj.conti_cd, comboObjects[3].Text);
				ComSetObjValue(formObj.cnt_cd, comboObjects[4].Text);
				ComSetObjValue(formObj.rgn_cd, comboObjects[5].Text);
                ComSetObjValue(formObj.ste_cd, comboObjects[5].Text);
				ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.org_dest_location));

				break;	
				
		}
	}
	/*
	 * 조회 옵션 사용가능
	 */
	function EnableControls() {
		var formObj = document.form;
		ComEnableObject(formObj.yd_cd1, true);
		ComEnableObject(formObj.cvrg_location, true);
		ComEnableObject(formObj.org_dest_location, true);
		
		formObj.yd_cd1.className 			= "input";
		formObj.cvrg_location.className 	= "input";
		formObj.org_dest_location.className = "input";

		for(var i = 0 ; i < comboObjects.length ; i++) {
			comboObjects[i].Enable = true;
		}
		
		doEnableBkgTerm();
	}
	
	/*
	 * 조회 옵션 사용불가
	 */
	function DisableControls() {
		var formObj = document.form;
		ComEnableObject(formObj.yd_cd1, false);
		ComEnableObject(formObj.cvrg_location, false);
		ComEnableObject(formObj.org_dest_location, false);

		formObj.yd_cd1.className 			= "input2";
		formObj.cvrg_location.className 	= "input2";
		formObj.org_dest_location.className = "input2";
		
		for(var i = 0 ; i < comboObjects.length ; i++) {
			comboObjects[i].Enable = false;
		}
	}
	
	/*
	 *  초기화 
	 */		
	function initSearchControls() {
		var formObj = document.form;
		
		comboObjects[0].Code = "-1";
		comboObjects[0].RemoveAll();
		comboObjects[1].Code = "-1";
		comboObjects[1].RemoveAll();
		comboObjects[3].Code = "-1";
		comboObjects[3].RemoveAll();
		comboObjects[4].Code = "-1";
		comboObjects[4].RemoveAll();
		comboObjects[5].Code = "-1";
		comboObjects[5].RemoveAll();
		
		ComSetObjValue(formObj.conti_cd, "");	
		ComSetObjValue(formObj.cnt_cd, "");		
		ComSetObjValue(formObj.rgn_cd, "");		
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.ste_cd, "");
		ComSetObjValue(formObj.yd_cd1, "");
		ComSetObjValue(formObj.yd_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
		ComSetObjValue(formObj.org_dest_location, "");

		ComSetObjValue(formObj.cvrg_conti_cd, "");
		ComSetObjValue(formObj.cvrg_cnt_cd, "");
		ComSetObjValue(formObj.cvrg_rgn_cd, "");
		ComSetObjValue(formObj.cvrg_ste_cd, "");
		ComSetObjValue(formObj.cvrg_loc_cd, "");
		ComSetObjValue(formObj.cvrg_yd_cd, "");
		
		ComSetObjValue(formObj.org_dest_conti_cd, "");
		ComSetObjValue(formObj.org_dest_cnt_cd, "");
		ComSetObjValue(formObj.org_dest_rgn_cd, "");
		ComSetObjValue(formObj.org_dest_ste_cd, "");
		ComSetObjValue(formObj.org_dest_loc_cd, "");
		
		ComSetObjValue(formObj.dmdt_trf_cd, "");
		ComSetObjValue(formObj.trf_seq, "");
		ComSetObjValue(formObj.trf_grp_seq, "");
		ComSetObjValue(formObj.dmdt_trf_nm, "");
		ComSetObjValue(formObj.confirm_yn, "");
		ComSetObjValue(formObj.wknd1, "SAT");
		ComSetObjValue(formObj.wknd2, "SUN");
		
		Region2.innerHTML = "Region";
		OriginDest.innerHTML = "Origin";
		OriginDest.innerHTML = "Origin";
		OriginDest.innerHTML = "Origin";
		wknd1.innerHTML = "SAT";
		wknd2.innerHTML = "SUN";
		
		initResultText();
	}	
	
	
	function initResultText() {
		var formObj = document.form;
		ComSetObjValue(formObj.xcld_sat_flg, "");
		ComSetObjValue(formObj.xcld_sun_flg, "");
		ComSetObjValue(formObj.xcld_hol_flg, "");

		ComSetObjValue(formObj.cmnc_hr, "");
		ComSetObjValue(formObj.dmdt_chg_cmnc_tp_nm, "");
		ComSetObjValue(formObj.curr_cd, "");
	}
	
	/*
	 * 조회결과 정보 초기화
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
	}
	
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initControl() {
		//조회필드 초기화
		initSearchControls();
		//조회결과 정보 초기화
		initResultControls();
		//Sheet2, Sheet3 결과값 초기화
		//initResultText();
		//ComResetAll();
	 	// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    //DATA 초기화
    	var formObj = document.form;
    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST07,"","");
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCHLIST,COMMON_TARIFF_CD,comboObjects[0]);	//tariff type
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH08,CONTINENT,comboObjects[2]);			//orgin/dest continent
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH02,COUNTRY,comboObjects[3]);				//orgin/dest country
//    	doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH01,REGION,comboObjects[4]);				//orgin/dest region
	    
	    
	    //Button 초기화
	    initButton();
		
	}	
    
function t1901SpeedDownExcel () {
//    sheetObjects[3].RemoveAll();
//    doActionIBSheet( sheetObjects[3] , document.form , IBSEARCH );
//    sheetObjects[1].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false,'','',false,'',true);
    sheetObjects[3].Down2Excel(-1);
}