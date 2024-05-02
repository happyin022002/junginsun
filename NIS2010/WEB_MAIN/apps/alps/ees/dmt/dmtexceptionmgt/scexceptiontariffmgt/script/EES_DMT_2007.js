/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2007.js
*@FileTitle : S/C & RFA Exception Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.03 이성훈
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
     * @class S/C & RFA Exception Inquiry 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1; 
	
	var comboObjects = new Array();
	var comboCnt = 0;	

	//Action 정의
	var IBSEARCH_TARIFF 	= 100;
	var IBSEARCH_SC_STAT 	= 101;
	var IBSEARCH_RFA_STAT 	= 102;
	var IBSEARCH_REF_OFC 	= 103;
	var IBSEARCH_CVRG 		= 104;
	var IBSEARCH_CUST_NM 	= 105;
	
	//업무전역변수
	var CONTINENT 			= "CONTI";
	var COUNTRY 			= "CNT";
	var REGION 				= "RGN";
	var STATE 				= "STE";
	var LOCATION 			= "LOC";
	var YARD				= "YD";
	
	var ROWMARK 			= "|";
	var FIELDMARK 			= "=";
	
	//S/C GRID 필드명 변수
    var SC_NO 				= "sc_no";
    var RFA_NO 				= "rfa_no";
    var STATUS 				= "status";
    var TARIFF 				= "tariff";
    var EFF_DT 				= "eff_dt";
    var EXP_DT 				= "exp_dt";
    var CNTRCGO 			= "cntrcgo";
    var CNT_CD 				= "cnt_cd";
    var RGN_CD 				= "rgn_cd";
    var LOC_CD 				= "loc_cd";
    var FT_TIR 				= "ft_tir";
    var FT_ADD_DYS 			= "ft_add_dys";
    var FT_TOT_DYS 			= "ft_tot_dys";
    var SAT_FLG 			= "xcld_sat_flg";
    var SUN_FLG 			= "xcld_sun_flg";
    var HOL_FLG 			= "xcld_hol_flg";
    var CURR_CD				= "curr_cd";
    var ORGDST_MULTI 		= "org_dest_multi";
	var ORGDST_CTI 			= "org_dest_conti_cd";
	var ORGDST_CNT 			= "org_dest_cnt_cd";
	var ORGDST_RGN 			= "org_dest_rgn_cd";
	var ORGDST_LOC 			= "org_dest_loc_cd";;
    var BKGDEL_CNT 			= "fnl_dest_cnt_cd";
    var BKGDEL_RGN 			= "fnl_dest_rgn_cd";
    var BKGDEL_LOC 			= "fnl_dest_loc_cd";
    var CYDOOR 				= "rcv_de_term_cd";
    var RATE_FLG 			= "rt_flg";
    var CMDT_FLG 			= "rep_cmdt_flg";
    var ACUST_FLG 			= "act_cust_flg";
    var AMDT_SEQ 			= "amdt_seq";
    var PROP_NO 			= "prop_no";
    var CUST_CD 			= "cust_cd";
    var CUST_NM 			= "cust_nm";
    var VER 				= "ver_seq";
    var GRP_SEQ 			= "grp_seq";
    var DAR_NO 				= "dar_no";
    var APRO_NO 			= "apvl_no";
    var RQST_SEQ 			= "rqst_seq";
    var ACT_CUST_CD 		= "act_cust_cd";
    var ACT_CUST_NM 		= "act_cust_nm";
    var CVRG_SEQ			= "cvrg_seq";
    
	//S/C - Tiered Free Time GRID 필드명 변수
    var CNTR_FM_QTY 		= "cntr_fm_qty";
    var CNTR_TO_QTY 		= "cntr_to_qty";
    var FT_DYS 				= "ft_dys";
    
	//S/C - Rate Adjustment GRID 필드명 변수    
	var RT_FROM 			= "ft_fm_dys";
	var RT_UPTO 			= "ft_to_dys";
	//RFA - Rate Adjustment GRID 필드명 변수
	var RT_OVER 			= "ft_ovr_dys";
	var RT_UNDR 			= "ft_und_dys";
	//S/C, RFA 공통 필드명 변수
	var RT_20FT 			= "cntr_20ft_rt_amt";
	var RT_40FT 			= "cntr_40ft_rt_amt";
	var RT_HC 				= "cntr_hc_rt_amt";
	var RT_45FT 			= "cntr_45ft_rt_amt";
	var RT_R9 		        = "cntr_r9_rt_amt";
	
	//S/C - Actual Customer Grid 필드명 변수   
	var CUST_CD 			= "cust_cd";
	var CUST_NM 			= "cust_nm";
	var CUST_TP				= "cust_tp";
	
	//S/C - Commodity Grid 필드명 변수   
	var CMDT_CD 			= "cmdt_cd";
	var CMDT_NM 			= "cmdt_nm";
	
	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation 	= true;
	
	//Tab 변수
	var SC_TAB 				= 0;
	var RFA_TAB 			= 1;
	
  	//Sort 시 선택되어진 Row 의 선택상태를 계속 유지하기 위해서 사용되는 변수
	var currPropNo			= "";
	var currVerSeq			= "";
	var currGrpSeq			= "";
	var currCvrgSeq			= "";

	var currDarNo			= "";
	var currDarVerSeq		= "";
	var currRqstSeq			= "";
	var currCvrgCmbSeq		= "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetSCObj 	= sheetObjects[0];
         var sheetRFAObj	= sheetObjects[5]
         /*******************************************************/
         var formObj = document.form;

    	try {
     		var srcObj = window.event.srcElement;
     		var srcName = srcObj.getAttribute("name");
     		
            switch(srcName) {

	        	case "btn_Affiliate":
					if (ComIsBtnEnable("btn_Affiliate")) 
						doProcessPopup(sheetRFAObj, "Affiliate");
					break;
				
				case "btns_ofcCalendar": //달력 버튼
	 				var cal = new ComCalendarFromTo();
	            	cal.select(formObj.ofcEffDtFm, formObj.ofcEffDtTo, 'yyyy-MM-dd');
					break;
	     
				case "btns_cvrgCalendar": //달력 버튼
 					var cal = new ComCalendarFromTo();
            		cal.select(formObj.cvrgEffDtFm, formObj.cvrgEffDtTo, 'yyyy-MM-dd');
            		break;

				case "btn_Retrieve":
					if (ComIsBtnEnable("btn_Retrieve"))
						doActionRetrieve();
					break;
		
				case "btn_New":
					if (ComIsBtnEnable("btn_New"))
						doActionNew();
					break;
					
				case "btn_Minimize":
					if (ComIsBtnEnable("btn_Minimize"))
						doActionMinimize();
					break;
					
				case "btn_Detail":
					if (ComIsBtnEnable("btn_Detail"))
						doActionDetail();
					break;
		
				case "btn_DownExcel":
					if (ComIsBtnEnable("btn_DownExcel"))
						doActionDownExcel();
					break;

				case "btn_Close":
					doActionClose();
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){

    	 tabObjects[tabCnt++] = tab_obj;
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

 	   	// 팝업으로 호출시에 타이틀 표시 처리
        if(isPopupWindow()) {
	        var spanObj = document.getElementById("title2");
 	       	spanObj.innerText = " S/C & RFA Exception Inquiry";
 	       	
	       	//팝업으로 호출시에 Close 버튼을 보여준다.
	       	btnCloseLayer.style.display  = "inline"; 	       	
 	   	}
         
        for (i = 0 ; i < sheetObjects.length ; i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);        	
        }

		for (var k = 0 ; k < tabObjects.length ; k++){
            initTab(tabObjects[k],k+1);
        }
		
	 	//IBMultiCombo초기화 
	    for (var k = 0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k],k+1);
	    }
	    
		//html컨트롤 이벤트초기화
		initControl();
    }

 	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
 	function t1sheet1_OnLoadFinish() {
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
 		
 		//S/C 의 상태정보를 조회해서 S/C 콤보에 설정해 준다.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_SC_STAT,SEARCH15);
 		//Before 의 상태정보를 조회해서 RFA 콤보에 설정해 준다.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_RFA_STAT,SEARCH15);
 		//Tariff Type 정보를 조회해서 Tariff 콤보에 설정해 준다.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_TARIFF,SEARCH09);
 		//Ref. Office 정보를 조회해서 Ref. Office 콤보에 설정해 준다.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_REF_OFC,SEARCHLIST01);
 		//Country정보를 조회해서 그리드 Coverage 의 CN 콤보에 설정해 준다.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH02);
 		//Region정보를 조회해서 그리드 Coverage 의 RGN 콤보에 설정해 준다.
 		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH01);
 		
		//화면 Load 시 특정필드들을 비활성화 시킨다.
		initDisableControls();

 		//화면 Load 시 조회필드들을 초기화한다.(항상, 조회후 멀티콤보에 데이터를 채운 후에 실행해야 정상적으로 동작한다.)
		initOfficeControls();
		
 		//팝업화면으로 Load 될 경우 파라미터로 전달받은 S/C No. 나 RFA No. 로 조회를 수행한다.
 		if (isPopupWindow()) {
 			doActionRetrieve();
 		}
 	}
 	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

  		sheetObj.ToolTipOption="balloon:true;width:50;";
  		
        var cnt = 0;
		var sheetid = sheetObj.id;
        switch(sheetid) {
            case "t1sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 162;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);

					var HeadTitle1 = "|Seq.|S/C No.|Ver.|Status|Tariff|EFF DT|EXP DT|CNTR/Cargo|Coverage|Coverage|Coverage|Free Time|Free Time|Free Time|F/T Exclusion|F/T Exclusion|F/T Exclusion|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|CY/Door|Rate|CMDT|Cust.|Proposal No.|Customer|Customer";
                    var HeadTitle2 = "|Seq.|S/C No.|Ver.|Status|Tariff|EFF DT|EXP DT|CNTR/Cargo|CN|RGN|LOC|Tier|Add|Total|SAT|SUN|H/day|CT|CN|RGN|LOC|CN|State|LOC|CY/Door|Rate|CMDT|Cust.|Proposal No.|Code|Name";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 4;

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		SC_NO,			false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		VER,			false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		STATUS,			false,	"",	dfNone,		0,	false);

					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		TARIFF,	   		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		EFF_DT,	    	false,	"",	dfDateYmd,	0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		EXP_DT,      	false,	"",	dfDateYmd,	0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		CNTRCGO,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		CNT_CD,			false,	"",	dfNone,		0,	false);
					
					InitDataProperty(0, cnt++ , dtData,			35, 	daCenter,		true,		RGN_CD,			false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			45, 	daCenter,		true,		LOC_CD,			false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		FT_TIR,			false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,	  		30,		daCenter,		true,		FT_ADD_DYS,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		FT_TOT_DYS,		false,	"",	dfNone,		0,	false);

					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		SAT_FLG,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		SUN_FLG,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		true,		HOL_FLG,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		ORGDST_CTI,	   	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		ORGDST_CNT,	 	false,	"",	dfNone,		0,	false);

					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		ORGDST_RGN,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		true,		ORGDST_LOC,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		BKGDEL_CNT,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		BKGDEL_RGN,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		true,		BKGDEL_LOC,     false,	"",	dfNone,		0,	false);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		CYDOOR,			false,	"",	dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		RATE_FLG,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		CMDT_FLG,		false,	"",	dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		ACUST_FLG,	  	false,	"",	dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		PROP_NO,		false,	"",	dfNone,		0,	false);

                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		CUST_CD,      	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			160,	daLeft,			true,		CUST_NM,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		GRP_SEQ,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		AMDT_SEQ,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		CURR_CD,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		CVRG_SEQ,	    false,	"",	dfNone,		0,	false);

					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(FT_TIR);
					
					CountPosition = 0;
				}
				break;

            case "t1sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);

					var HeadTitle1 = "|CNTR Q'TY|CNTR Q'TY|Total";
					var HeadTitle2 = "|From|Up to|Total";
                    var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   	InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		CNTR_FM_QTY,	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		CNTR_TO_QTY,	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		FT_DYS,			false,	"",	dfNone,		0,	false);

					CountPosition = 0;
				}
				break;

             case "t1sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);

					var HeadTitle1 = "|Over Day|Over Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day";
					var HeadTitle2 = "|From|Up to|20 FT|40 FT|H/C|45 FT|R9";
                    var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   	InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                   	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		RT_FROM,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		RT_UPTO,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daRight,		true,		RT_20FT,		false,	"",	dfFloat,	2,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daRight,		true,		RT_40FT,		false,	"",	dfFloat,	2,	false);

					InitDataProperty(0, cnt++ , dtData,			120,	daRight,		true,		RT_HC,			false,	"",	dfFloat,	2,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,		true,		RT_45FT,		false,	"",	dfFloat,	2,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,		true,		RT_R9,		    false,	"",	dfFloat,	2,	false);

					CountPosition = 0;
                }
                break;
                
		  case "t1sheet4":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 62;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 7, 100);

                    var HeadTitle1 = "|Code|Name";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 1;
                      
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   	InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		CUST_CD,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		CUST_NM,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		  0,	daCenter,		true,		CUST_TP,		false,	"",	dfNone,		0,	false);

					CountPosition = 0;
				}
				break;

             case "t1sheet5":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 62;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 7, 100);

                    var HeadTitle1 = "|Code|Name";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                      
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   	InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		CMDT_CD,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		CMDT_NM,		false,	"",	dfNone,		0,	false);

					CountPosition = 0;
				}
				break;
				
		 case "t2sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 162;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);

					var HeadTitle1 = "|Seq.|RFA No.|Status|Tariff|EFF DT|EXP DT|CNTR/Cargo|Coverage|Coverage|Coverage|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|Origin(I) or Dest.(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|Actual Customer|Actual Customer|Rate|DAR No.|Ver.|Approval No.|Proposal No.|Customer|Customer";
                    var HeadTitle2 = "|Seq.|RFA No.|Status|Tariff|EFF DT|EXP DT|CNTR/Cargo|CN|RGN|LOC|Add|Total|SAT|SUN|H/day|Multi|CT|CN|RGN|LOC|CN|State|LOC|Code|Name|Rate|DAR No.|Ver.|Approval No.|Proposal No.|Code|Name";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 4;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		RFA_NO,		  	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		STATUS,			false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		TARIFF,	   		false,	"",	dfNone,		0,	false);

					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		EFF_DT,	    	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		EXP_DT,      	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		CNTRCGO,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,	  	daCenter,		true,		CNT_CD,			false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			35, 	daCenter,		true,		RGN_CD,			false,	"",	dfNone,		0,	false);

					InitDataProperty(0, cnt++ , dtData,			45, 	daCenter,		true,		LOC_CD,			false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		FT_ADD_DYS,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,	  		35,		daCenter,		true,		FT_TOT_DYS,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		SAT_FLG,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		SUN_FLG,		false,	"",	dfNone,		0,	false);
					
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		true,		HOL_FLG,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		ORGDST_MULTI,	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		ORGDST_CTI,	   	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		ORGDST_CNT,	 	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		ORGDST_RGN,	   	false,	"",	dfNone,		0,	false);
					
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		true,		ORGDST_LOC,	 	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		BKGDEL_CNT,	 	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		BKGDEL_RGN,	   	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			45,		daCenter,		true,		BKGDEL_LOC,	 	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		ACT_CUST_CD,	false,	"",	dfNone,		0,	false);

					InitDataProperty(0, cnt++ , dtData,			160,	daLeft,			true,		ACT_CUST_NM,	false,	"",	dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		RATE_FLG,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		DAR_NO,      	false,	"",	dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		VER,		    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,		true,		APRO_NO,		false,	"",	dfNone,		0,	false);

					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		PROP_NO,	  	false,	"",	dfNone,		0,	false);
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		CUST_CD,	  	false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			160,	daLeft,			true,		CUST_NM,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		RQST_SEQ,		false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		AMDT_SEQ,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		CURR_CD,	    false,	"",	dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,		true,		CVRG_SEQ,	    false,	"",	dfNone,		0,	false);
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(FT_ADD_DYS);
					
					CountPosition = 0;
				}
				break;

            case "t2sheet2":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);

                    var HeadTitle1 = "|Seq.|BKG POR|BKG POR|BKG POR|BKG POR";
                    var HeadTitle2 = "|Seq.|Continent|Country|Region|Location";
                    var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   	InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"hdnStatus");
                    InitDataProperty(0, cnt++ , dtSeq,    		80,    	daCenter,   	true,     	"Seq",				false,	"",		dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,	   		70,		daCenter,		false,		ORGDST_CTI,			false,	"",		dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,	  		65,		daCenter,		false,		ORGDST_CNT,			false,	"",		dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,   	   	60,		daCenter,		false,		ORGDST_RGN,			false,	"",		dfNone,		0,	false);
					InitDataProperty(0, cnt++ , dtData,   		65,		daCenter,		false,		ORGDST_LOC,			false,	"",		dfNone,		0,	false);

					CountPosition = 0;
				}
				break;

             case "t2sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 122;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);

					var HeadTitle1 = "|Over Day|Over Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day";
					var HeadTitle2 = "|From|Up to|20 FT|40 FT|H/C|45 FT|R9";
                    var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                   	InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflg");
					InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,		false,		RT_OVER,			false,	"",		dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,   		60,		daCenter,		false,		RT_UNDR,			false,	"",		dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,   		80,		daRight,		false,		RT_20FT,			false,	"",		dfNullFloat,	2,	false);
					InitDataProperty(0, cnt++ , dtData,   		80,		daRight,		false,		RT_40FT,			false,	"",		dfNullFloat,	2,	false);
					InitDataProperty(0, cnt++ , dtData,   		80,		daRight,		false,		RT_HC,				false,	"",		dfNullFloat,	2,	false);
					InitDataProperty(0, cnt++ , dtData,   		70,		daRight,		false,		RT_45FT,			false,	"",		dfNullFloat,	2,	false);
					InitDataProperty(0, cnt++ , dtData,   		70,		daRight,		false,		RT_R9,			    false,	"",		dfNullFloat,	2,	false);
					
					CountPosition = 0;
				}
			break;

        }
    }

 	/**
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
  	 */ 
  	function initCombo(comboObj, comboNo) {
  	    var formObj = document.form

  	    switch(comboNo) {

  	    	//S/C
  	    	case 1:
  	    		with(comboObj) {
  					MultiSelect = true; 
  					UseAutoComplete = true;	
  					SetColWidth("110");
  					DropHeight = 160;
  	    		}
  	    		break;

  	    	//Before
  	    	case 2:
  	    		with(comboObj) {
  					MultiSelect = true; 
  					UseAutoComplete = true;	
  					SetColWidth("120");
  					DropHeight = 160;
  	    		}
  	    		break;
  	    		
  	    	//Tariff Type
  	    	case 3:
  	    		with(comboObj) {
  					MultiSelect = true; 
  					UseAutoComplete = true;	
  					SetColAlign("left|left");        
  					SetColWidth("55|330");
  					DropHeight = 160;
  	    		}
  	    		break;
  	    		
  		   	//Ref. Office
  	    	case 4:
  	        	with(comboObj) { 
  					MultiSelect = true;
  					UseAutoComplete = true;	
  					ColBackColor(0) = "#CCFFFD";
   					ColBackColor(1) = "#CCFFFD";
  					DropHeight = 160;
  					BackColor = "#CCFFFD";
  					FontColor = "#606060";
  					
  					ValidChar(2, 2);	// 영어대문자 사용
  	    	    }
  	            break; 
  	            
  			//Country
  			case 5:
  				with(comboObj) { 
  					MultiSelect = false; 
  					SetColAlign("left|left");        
  					SetColWidth("50|190");
  					DropHeight = 160;
  					
   					ValidChar(2);	// 영어대문자
					MaxLength = 2;     					
  		    	}
  				break;
  			
  			//Region
  			case 6: 
  				with(comboObj) { 		
  					MultiSelect = false; 
  					SetColAlign("left|left");        
  					SetColWidth("50|190");
  					DropHeight = 160;
  					
   					ValidChar(2);	// 영어대문자
					MaxLength = 3;      					
  				}
  				break;			
  	     } 
  	} 
  	
 	function initControl() {
		axon_event.addListenerForm('beforedeactivate','obj_deactivate', 	document.form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('keypress',	'obj_keypress', 		document.form); //- 키보드 입력할때
		axon_event.addListenerFormat('focus',		'obj_focus',			document.form); //- 포커스 들어갈때
		axon_event.addListener('click', 			'condType_click', 		'cond_type');
		axon_event.addListener('blur', 				'obj_blur', 			'custCd');
		axon_event.addListener('keydown', 			'ComKeyEnter', 			'form');
	}
 	
    /**
    * HTML Control Foucs in
    */
	function obj_focus(){
		var obj = event.srcElement;
		ComClearSeparator(obj);
       
		//글자가 있는 경우 블럭으로 선택할수 있도록 한다.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
	}

    //포커스가 나갈 때
 	function obj_deactivate(){
 		//입력Validation 확인하기 + 마스크구분자 넣기
 		var obj = event.srcElement;
 		if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
    		 
 		} else if(obj.name == 'yd_cd' || obj.name == 'tmnl_cd') {
 			if(obj.value.length > 0 && obj.value.length < 5) {
 	 			ComShowCodeMessage('DMT00110', 'Location');
 	 			ComClearObject(obj);
    		 	}
 		} else {
 			ComChkObjValid(obj);
 		}
	}
 	
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		var formObj = document.form;
		
		switch(event.srcElement.dataformat){
			case "engup":
				// 영문대+숫자 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
          	case "engup2":
 		    	// 영문대+숫자+예외문자
          		DmtComKeyOnlyAlphabet('uppernum', ',');
 		        break;
          	case "int":
     	        //숫자 만입력하기
     	        ComKeyOnlyNumber(event.srcElement);
     	        break;
          	default:
 	         	// 숫자만입력하기(정수,날짜,시간)
 	            ComKeyOnlyNumber(event.srcElement);
		}
		//조회옵션으로 DAR 항목을 선택한 후 특정 필드에 데이터를 입력하면, 기타 다른 필드들에 입력된 값은 Clear 시킨다. 
		clearNoSelectDARFields();
	} 
	
	//업무 자바스크립트 OnBlur 이벤트 처리
	function obj_blur() {
		switch(event.srcElement.name){
			case "custCd":
				searchCustomerName();
				break;
		}
	}
	
    // Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
        	case IBSEARCH:
        		//1.S/C 조회
        		if (sheetObj.id == "t1sheet1") {
    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    				ComSetObjValue(formObj.f_cmd, SEARCH);
    				ComSetObjValue(formObj.type, "SC");
        	  		
    				//2.조회조건으로 조회실행
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
    				//*********************************************************************************
    				
    				sheetObj.DoSearch("EES_DMT_2007GS.do", FormQueryString(formObj));
    				
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
    				
    				//3.S/C 항목만 조회를 할 경우라면 자동으로 S/C Tab 이 선택되도록 변경해준다.
    				if (formObj.chkSC.checked) {
    					tabObjects[0].SelectedIndex = 0;
    				}    				
        		}
        		//2.S/C - Tiered Free Time 조회
        		else if (sheetObj.id == "t1sheet2") {
    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    				ComSetObjValue(formObj.f_cmd, SEARCH01);
    				
    				//2.조회조건으로 조회실행
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
    				//*********************************************************************************
    				
    				var sXml = sheetObj.GetSearchXml("EES_DMT_2007GS.do", FormQueryString(formObj));
    				
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchXml(sXml);
    				
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//3.S/C - Rate Adjustment 조회
        		else if (sheetObj.id == "t1sheet3") {
    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    				ComSetObjValue(formObj.f_cmd, SEARCH02);
    				
    				//2.조회조건으로 조회실행
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
    				//*********************************************************************************
    				
    				var sXml = sheetObj.GetSearchXml("EES_DMT_2007GS.do", FormQueryString(formObj));
    				
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchXml(sXml);
    				
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//4.S/C - Actual Customer 조회
        		else if (sheetObj.id == "t1sheet4") {
    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    				ComSetObjValue(formObj.f_cmd, SEARCH03);
    				
    				//2.조회조건으로 조회실행
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
    				//*********************************************************************************
    				
    				var sXml = sheetObj.GetSearchXml("EES_DMT_2007GS.do", FormQueryString(formObj));
    				
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) {
    					sheetObj.LoadSearchXml(sXml);
    					//선택된 Customer 의 Type 을 설정해준다.
    					ComSetObjValue(formObj.scCustType, sheetObj.CellValue(sheetObj.SelectRow, CUST_TP));
    				}
    				
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//5.S/C - Commodity 조회
        		else if (sheetObj.id == "t1sheet5") {
    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    				ComSetObjValue(formObj.f_cmd, SEARCH04);
    				
    				//2.조회조건으로 조회실행
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
    				//*********************************************************************************
    				
    				var sXml = sheetObj.GetSearchXml("EES_DMT_2007GS.do", FormQueryString(formObj));
    				
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchXml(sXml);
    				
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//6.RFA 조회
        		else if (sheetObj.id == "t2sheet1") {
    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    				ComSetObjValue(formObj.f_cmd, SEARCH);
    				ComSetObjValue(formObj.type, "BB");
    				
    				//2.조회조건으로 조회실행
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
    				//*********************************************************************************
    				
    				sheetObj.DoSearch("EES_DMT_2007GS.do", FormQueryString(formObj));
    				
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
    				
    				//3.RFA 항목만 조회를 할 경우라면 자동으로 RFA Tab 이 선택되도록 변경해준다.
    				if (!formObj.chkSC.checked && formObj.chkRFA.checked) {
    					tabObjects[0].SelectedIndex = 1;
    				}
    				
    				//4.선택한 Before Booking 의 Tariff 에 따라서 Multi Origin or Destination 의 제목줄을 변경해준다.
					setMultiOriginOrDestTitle();
        		}
        		//7.RFA - Multi Origin or Destination 조회
        		else if (sheetObj.id == "t2sheet2") {
    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    				ComSetObjValue(formObj.f_cmd, SEARCH05);
    				
    				//2.조회조건으로 조회실행
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
    				//*********************************************************************************
    				
    				var sXml = sheetObj.GetSearchXml("EES_DMT_2007GS.do", FormQueryString(formObj));
    				
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchXml(sXml);
    				
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}
        		//8.RFA - Rate Adjustment 조회
        		else if (sheetObj.id == "t2sheet3") {
    				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    				ComSetObjValue(formObj.f_cmd, SEARCH06);
    				
    				//2.조회조건으로 조회실행
    				//*********************************************************************************
    				ComOpenWait(true);
    				sheetObj.WaitImageVisible = false;
    				//*********************************************************************************
    				
    				var sXml = sheetObj.GetSearchXml("EES_DMT_2007GS.do", FormQueryString(formObj));
    				
    				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchXml(sXml);
    				
    				//*********************************************************************************
    				ComOpenWait(false);
    				//*********************************************************************************
        		}        		
				break;
        }
    }

	/**
	 * 콤보필드를 초기화 시키기 위해서 해당 데이터를 조회후 조회된 데이터로 채운다.
	 */	
	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction) {
	    sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
	    switch(sAction) {
	    
	    	//S/C 상태값을 조회한다.
	    	case IBSEARCH_SC_STAT:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.intg_cd_id, "CD01972");
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var comboObj = comboObjects[0];
				var comboDatas = ComGetEtcData(sXml, "COMMON_CD");
				
				//2009-09-28(월) S/C Status All, Requested, Accepted, Live, Deleted 순서로 나타나도록 변경#################
				var sCStatusArray = comboDatas.split(ROWMARK);
				
				var sCStatusSortArray = new Array();
				sCStatusSortArray[0] = "R" + FIELDMARK;
				sCStatusSortArray[1] = "A" + FIELDMARK;
				sCStatusSortArray[2] = "L" + FIELDMARK;
				sCStatusSortArray[3] = "D" + FIELDMARK;
				
				var sCStatusDatas = "" + FIELDMARK + "All";
				for (var sortI = 0 ; sortI < sCStatusSortArray.length ; sortI++) {
					for (var arrayI = 0 ; arrayI < sCStatusArray.length ; arrayI++) {
						if (sCStatusArray[arrayI].indexOf(sCStatusSortArray[sortI]) != -1) {
							sCStatusDatas += ROWMARK + sCStatusArray[arrayI];
							break;
						}
					}
				}
				//######################################################################################################
				var comboItems = sCStatusDatas.split(ROWMARK);
				addComboItem(comboObj,comboItems,"ONE-SELECT");
				comboObj.Code = "L";
				break;

		    //BEFORE 상태값을 조회한다.
	    	case IBSEARCH_RFA_STAT:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.intg_cd_id, "CD02069");
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var comboObj = comboObjects[1];
				var comboDatas = ComGetEtcData(sXml, "COMMON_CD");
				
				//2009-09-28(월) RFA Status	All, Requested, Cancelled, Approved, Counter Offered, Rejected 순서로 나타나도록 변경#################
				var rFAStatusArray = comboDatas.split(ROWMARK);
				
				var rFAStatusSortArray = new Array();
				rFAStatusSortArray[0] = "R" + FIELDMARK;
				rFAStatusSortArray[1] = "C" + FIELDMARK;
				rFAStatusSortArray[2] = "A" + FIELDMARK;
				rFAStatusSortArray[3] = "O" + FIELDMARK;
				rFAStatusSortArray[4] = "J" + FIELDMARK;
				
				var rFAStatusDatas = "" + FIELDMARK + "All";
				for (var sortI = 0 ; sortI < rFAStatusSortArray.length ; sortI++) {
					for (var arrayI = 0 ; arrayI < rFAStatusArray.length ; arrayI++) {
						if (rFAStatusArray[arrayI].indexOf(rFAStatusSortArray[sortI]) != -1) {
							rFAStatusDatas += ROWMARK + rFAStatusArray[arrayI];
							break;
						}
					}
				}				
				//##############################################################################################################################
				var comboItems = rFAStatusDatas.split(ROWMARK);
				addComboItem(comboObj,comboItems,"ONE-SELECT");
				comboObj.Code = "A";
				break;
			
	    	//Tariff Type 을 조회한다.
	    	case IBSEARCH_TARIFF:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var comboObj = comboObjects[2];
				var comboItems = ComGetEtcData(sXml, "all_tariff_cd").split(ROWMARK);
				addComboItem(comboObj,comboItems);
				
				//팝업화면으로 Load 될 때에는 전달받은 Tariff 로 설정해준다.
				if (isPopupWindow()) {
					comboObj.Text = ComGetObjValue(formObj.opener_tariff);
				}
				//메인화면으로 Load 될 때에는 전부 선택받은것으로 설정해준다.
				else {
					for (var i = 0 ; i < comboItems.length ; i++) {
						comboObj.CheckIndex(i) = true; 
					}
				}
				break;
				
			//Ref. Office 을 조회한다.				
	    	case IBSEARCH_REF_OFC:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
	    	    
   	 			//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
	    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
	    	    
	    	    //*********************************************************************************
	    	    ComOpenWait(false);
	    	    //*********************************************************************************
	    	    
	    	    //3.조회후 결과처리
	    	    var comboObj = comboObjects[3];
	    	    var ofc_cds = handleNullString(ComGetEtcData(sXml, "OFC_CD"));
	    	    var ofc_nms = handleNullString(ComGetEtcData(sXml, "OFC_NM"));
	    	   
	    	    if (sComboAction == SEARCHLIST01) { // Search Office
	    	    	
	    	    	if (ofc_cds != "") {
	    	    		
						var usrOfcCd = ComGetObjValue(formObj.login_ofc_cd);
	 					var idx = 0;
	 					
	 					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
	 					if (ofc_cds.indexOf(usrOfcCd) == -1) {
	 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
	 						idx = 1;
	 					}
	 					
			    	    var comboCodeArr = ofc_cds.split("|");
			    	    var comboTextArr = ofc_nms.split("|");
			    	    
			    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(idx + i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
			         	}
			    	    
			    	    //로그인 Office가 Default로 나오도록 함.
			    	    setDefaultRefOffice();
	    	    	}
	    	    } 
	    	    else { // incl. Sub Office
	    	    	if (ofc_cds != "")  {
	    	    		var usrOfcCd = ComGetObjValue(formObj.login_ofc_cd);
	    	    		
	    	    		if (comboObj.Code.indexOf(usrOfcCd) != -1 && ofc_cds.indexOf(usrOfcCd) == -1)
	    	    			ofc_cds = usrOfcCd + "," + ofc_cds;
	    	    		
	    	    		comboObj.Code = ofc_cds;
	    	    	}
	    	    }
	    	    break;
	    	    
			//Customer 프레임에 CUSTOMER ID 를 입력시 CUSTOMER NAME 을 조회한다.
        	case IBSEARCH_CUST_NM:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
	    	    //*********************************************************************************
	    	    ComOpenWait(false);
	    	    //*********************************************************************************
	    	    
				//3.조회후 결과처리
				var custNm = ComTrim(ComGetEtcData(sXml, "CUST_NM"));
				if (custNm == "") {
					ComShowCodeMessage("DMT06001");
					ComClearObject(formObj.custCd);
					ComClearObject(formObj.custNm);
					ComSetFocus(formObj.custCd);
					return;
				} else {
					ComSetObjValue(formObj.custNm, custNm);
				}
        		break;	    	    
	    	    
	    	case IBSEARCH_CVRG:
	    		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
	    		ComSetObjValue(formObj.f_cmd, sComboAction);
	    	    
   	 			//2.조회조건으로 조회실행
	    		//*********************************************************************************
	    		ComOpenWait(true);
	    		sheetObj.WaitImageVisible = false;
	    		//*********************************************************************************
	    		
	    	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
   	 		
	    	    //*********************************************************************************
	    	    ComOpenWait(false);
	    	    //*********************************************************************************
	    	    
				//3.조회후 결과처리
				var comboDatas;
				var comboItems;
				var comboItem;
				switch(sComboAction) {
					
					//3-1.Region 조회(모든 Region 목록)
					case SEARCH01:
						comboItems = ComGetEtcData(sXml, REGION).split(ROWMARK);
						comboObjects[5].RemoveAll();
						addComboItem(comboObjects[5],comboItems);						
						break;
					
					//3-2.Country 조회(모든 Country 목록)
					case SEARCH02:
						comboItems = ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
						comboObjects[4].RemoveAll();
						addComboItem(comboObjects[4],comboItems);						
						break;
												
					//3-3.Country 항목 선택에 따른 해당 Region 조회
					case SEARCH03:
						//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
						if (comboObjects[4].Text == "CA" || comboObjects[4].Text == "US") {
							comboDatas = ComGetEtcData(sXml, STATE);
						} else {
							comboDatas = ComGetEtcData(sXml, REGION);
						}
						//조회된 결과가 없을 경우 Error Message 를  보여주고 Empty 로 초기화시킨다.
						if (comboDatas == undefined || ComTrim(comboDatas) == "") {
							ComShowCodeMessage("DMT00110", "Country");
							return;
						} else {
							//Region 콤보 Empty 상태로 초기화
							comboObjects[5].RemoveAll();									
							comboItems = comboDatas.split(ROWMARK);
							addComboItem(comboObjects[5],comboItems);
						}					
						break;						
												
					//3-4.Location 항목 입력에 따른 상위 Country, Region 조회
					case SEARCH04:
						//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
						comboDatas = ComGetEtcData(sXml, COUNTRY);
						if (comboDatas != undefined) {
							comboItems = comboDatas.split(ROWMARK);
							setComboItem(comboObjects[4],comboItems);
						}
						//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
						var locCd = ComTrim(ComGetObjValue(formObj.location)).substring(0, 2);
						if (locCd == "CA" || locCd == "US") {
							comboDatas = ComGetEtcData(sXml, STATE);
						} else {
							comboDatas = ComGetEtcData(sXml, REGION);
						}
						if (comboDatas != undefined) {
							comboItems = comboDatas.split(ROWMARK);
							setComboItem(comboObjects[5],comboItems);
						} else {
							ComShowCodeMessage("DMT00110", "Location");
							ComClearObject(formObj.location);
							ComSetFocus(formObj.location);
						}
						break;
						
					//3-5.Region 항목코드로 상위(Country) 정보를 조회한다.
					case SEARCH13:						
					//3-6.State 항목코드로 상위(Country) 정보를 조회한다.
					case SEARCH17:
						//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
						comboDatas = ComGetEtcData(sXml, COUNTRY);
						if (comboDatas != undefined) {
							comboItems = comboDatas.split(ROWMARK);
							setComboItem(comboObjects[4],comboItems);

							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							if (comboObjects[4].Text == "US" || comboObjects[4].Text == "CA") {
								comboDatas = ComGetEtcData(sXml, STATE);
							}
							else {
								comboDatas = ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[5],comboItems);
							}							
						}
						else {
							ComShowCodeMessage("DMT00110", "Region");
							comboObjects[5].Text = "";
						}
						break;
				}	    	    
	    		break;

	    }
		sheetObj.WaitImageVisible = true;
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 var formObj = document.form;
    	 
    	 //1.Type 은 S/C or Before 둘 중 하나는 반드시 선택
    	 if (!formObj.chkSC.checked && !formObj.chkRFA.checked) {
    		 ComShowCodeMessage("DMT00102", "S/C or Before");
    		 return false;
    	 }
    	 //2.Tariff Type 은 필수선택
   		 if (ComTrim(comboObjects[2].Text) == "") {
    		 ComShowCodeMessage("DMT00102", "Tariff Type");
    		 return false;    			 
		 }    	 
    	 
    	 //3-1.Office 선택시(Ref.Office 와 Effective 는 필수입력항목이다.)
    	 if (formObj.cond_type[0].checked) {
    		 
  			var startDt	= ComTrim(ComGetObjValue(formObj.ofcEffDtFm));
 			var endDt	= ComTrim(ComGetObjValue(formObj.ofcEffDtTo));
    		 
    		 if (ComTrim(comboObjects[3].Text) == "") {
        		 ComShowCodeMessage("DMT00102", "Ref. Office");
        		 return false;    			 
    		 }
    		 else if (startDt == "") {
        		 ComShowCodeMessage("DMT00102", "Effective");
        		 ComSetFocus(formObj.ofcEffDtFm);
        		 return false;    			 
    		 }
    		 else if (endDt == "") {
        		 ComShowCodeMessage("DMT00102", "Effective");
        		 ComSetFocus(formObj.ofcEffDtTo);
        		 return false;    			 
    		 }
 			
			startDt = ComGetUnMaskedValue(startDt, 	'ymd');
     		endDt 	= ComGetUnMaskedValue(endDt, 	'ymd');
            limitDt = ComGetDateAdd(startDt, "Y", 1);
            if (ComChkPeriod(endDt, limitDt) == 0) {
            	ComShowCodeMessage("DMT00162", "1 year");
            	return false;
            }
    	 }
    	//3-2.Coverage 선택시(Country 와 Effective 는 필수입력항목이다.)
    	 else if (formObj.cond_type[1].checked) {
    		 
   			var startDt	= ComTrim(ComGetObjValue(formObj.cvrgEffDtFm));
 			var endDt	= ComTrim(ComGetObjValue(formObj.cvrgEffDtTo));
 			
    		 if (ComTrim(comboObjects[4].Text) == "") {
        		 ComShowCodeMessage("DMT00102", "Country");
        		 return false;       			 
    		 }
    		 //Effective 와 Ref.Office 는 필수입력항목이다.
    		 else if (startDt == "") {
        		 ComShowCodeMessage("DMT00102", "Effective");
        		 ComSetFocus(formObj.cvrgEffDtFm);
        		 return false;    			 
    		 }
    		 else if (endDt == "") {
        		 ComShowCodeMessage("DMT00102", "Effective");
        		 ComSetFocus(formObj.cvrgEffDtTo);
        		 return false;    			 
    		 }
    		 
 			startDt = ComGetUnMaskedValue(startDt, 	'ymd');
     		endDt 	= ComGetUnMaskedValue(endDt, 	'ymd');
            limitDt = ComGetDateAdd(startDt, "Y", 1);
            if (ComChkPeriod(endDt, limitDt) == 0) {
            	ComShowCodeMessage("DMT00162", "1 year");
            	return false;
            }
    	 }
    	 //3-3.DAR 선택시
    	 else {
    		 var sCNo = ComTrim(ComGetObjValue(formObj.sCNo));
    		 var rFANo = ComTrim(ComGetObjValue(formObj.rFANo));
    		 var propNo = ComTrim(ComGetObjValue(formObj.proposalNo));
    		 var darNo = ComTrim(ComGetObjValue(formObj.darNo));
    		 var aprvNo = ComTrim(ComGetObjValue(formObj.approvalNo));
    		 
    		 //1.S/C No., RFA No., Proposal No., DAR No., APVL No. 중 반드시 1 개의 항목만 입력되어야 한다.
    		 var inputFieldCount = 0;
    		 if (propNo != "") inputFieldCount++;
    		 if (sCNo != "") inputFieldCount++;
    		 if (rFANo != "") inputFieldCount++;
    		 if (darNo != "") inputFieldCount++;
    		 if (aprvNo != "") inputFieldCount++;

    		 if (inputFieldCount == 0 || inputFieldCount > 1) {
    			 ComShowCodeMessage("DMT00180");
    			 ComSetFocus(formObj.sCNo);
    			 return false;    			 
    		 }
    	 }
        return true;
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
                    InsertTab( cnt++ , "S/C" , -1 );
                    InsertTab( cnt++ , "RFA" , -1 );
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
  	* 정렬시 현재 선택되어진 ROW 의 선택상태를 계속 유지하도록 처리해주는 함수
  	*/	
  	function t1sheet1_OnSort(sheetObj, Col, SortArrow) {
  		
  		with(sheetObj) {
  			for (var row = HeaderRows ; row <= LastRow ; row++) {
  				if (	currPropNo 	== CellValue(row, PROP_NO) 
  					&& 	currVerSeq 	== CellValue(row, VER)
  					&& 	currGrpSeq 	== CellValue(row, GRP_SEQ)
  					&& 	currCvrgSeq == CellValue(row, CVRG_SEQ)) {
  					SelectRow = row;
  					break;
  				}
  			}
  		}
  	} 
  	
	/**
	 * 조회된 S/C 리스트 데이터에서 각 Row 를 선택할 때마다 그 하위 정보들을 조회한다.
	 */	
	function t1sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		
		//선택한 Row 위치가 변경될 때마다 자식 데이터 조회를 수행한다.
		if (OldRow >= sheetObj.HeaderRows && OldRow != NewRow) {
			
			//------------------------------------------------------------------
			currPropNo  = sheetObj.CellValue(sheetObj.SelectRow, PROP_NO);
			currVerSeq 	= sheetObj.CellValue(sheetObj.SelectRow, VER);
			currGrpSeq	= sheetObj.CellValue(sheetObj.SelectRow, GRP_SEQ);
			currCvrgSeq = sheetObj.CellValue(sheetObj.SelectRow, CVRG_SEQ);
			//------------------------------------------------------------------
			
			doActionSCChildRetrieve();
		}
	}
		
	/**
	 * Row 를 더블클릭시 관련 팝업화면을 띄운다.
	 */	
	function t1sheet1_OnDblClick(sheetObj,Row,Col) {
		
		 doActionDetail();
	}
		
	/**
	 * T1Sheet1 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function t1sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		 
		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow >= HeaderRows && MouseRow <= LastRow) {

				if (colName == CNT_CD || colName == RGN_CD || colName == LOC_CD) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DMOF 일 경우 말풍선 "BKG POL/CY"
					//         DMIF 일 경우 말풍선 "BKG POD/CY"
					//         DTOC, CTOC 일 경우 말풍선 "BKG POR"
					//         DTIC, CTIC 일 경우 말풍선 "BKG DEL"				
					switch(trfCd) {
						case "DMOF": MouseToolTipText = "BKG POL/CY"; break;
						case "DMIF": MouseToolTipText = "BKG POD/CY"; break;
						case "DTOC":
						case "CTOC": MouseToolTipText = "BKG POR"; break;
						case "DTIC":
						case "CTIC": MouseToolTipText = "BKG DEL"; break;
						default: MouseToolTipText = "";
					}
				}
				else if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DMOF, DTOC, CTOC 일 경우 말풍선 "BKG DEL"
					//         DMIF, DTIC, CTIC 일 경우 말풍선 "BKG POR" 		
					switch(trfCd) {
						case "DMOF":
						case "DTOC":
						case "CTOC": MouseToolTipText = "BKG DEL"; break;
						case "DMIF": 
						case "DTIC":
						case "CTIC": MouseToolTipText = "BKG POR"; break;
						default: MouseToolTipText = "";
					}
				}
				else if (colName == BKGDEL_CNT || colName == BKGDEL_RGN || colName == BKGDEL_LOC) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DMIF 일 경우 말풍선 "BKG DEL for Demurrage Only"
					//         DMOF 일 경우 말풍선 "BKG POR for Demurrage Only" 		
					switch(trfCd) {
						case "DMIF": MouseToolTipText = "BKG DEL for Demurrage Only"; break;
						case "DMOF": MouseToolTipText = "BKG POR for Demurrage Only"; break;
						default: MouseToolTipText = "";
					}
				}				
				else if (colName == CYDOOR) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DTIC, CTIC 일 경우 말풍선 "BKG DEL Term for Detention Only"
					//         DTOC, CTOC 일 경우 말풍선 "BKG RCV Term for Detention Only" 		
					switch(trfCd) {
						case "DTIC":
						case "CTIC": MouseToolTipText = "BKG DEL Term for Detention Only"; break;
						case "DTOC": 
						case "CTOC": MouseToolTipText = "BKG RCV Term for Detention Only"; break;
						default: MouseToolTipText = "";
					}					
				}
				else {
					MouseToolTipText = "";
				}
			}
			else {
				MouseToolTipText = "";
			}			
		}	
	}
	 
	 
   /**
  	* 정렬시 현재 선택되어진 ROW 의 선택상태를 계속 유지하도록 처리해주는 함수
  	*/	
  	function t2sheet1_OnSort(sheetObj, Col, SortArrow) {
  		
  		with(sheetObj) {
  			for (var row = HeaderRows ; row <= LastRow ; row++) {
  				if (	currDarNo 		== CellValue(row, DAR_NO) 
  					&& 	currDarVerSeq 	== CellValue(row, VER)
  					&& 	currRqstSeq 	== CellValue(row, RQST_SEQ)
  					&& 	currCvrgCmbSeq 	== CellValue(row, CVRG_SEQ)) {
  					SelectRow = row;
  					break;
  				}
  			}
  		}
  	}  
	  	
	/**
	 * 조회된 RFA(Before Adjustment Request) 리스트 데이터에서 각 Row 를 선택할 때마다 그 하위 정보들을 조회한다.
	 */	
	function t2sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		
		//선택한 Row 위치가 변경될 때마다 자식 데이터 조회를 수행한다.
		if (OldRow >= sheetObj.HeaderRows && OldRow != NewRow) {
			
			//------------------------------------------------------------------
			currDarNo  		= sheetObj.CellValue(sheetObj.SelectRow, DAR_NO);
			currDarVerSeq 	= sheetObj.CellValue(sheetObj.SelectRow, VER);
			currRqstSeq		= sheetObj.CellValue(sheetObj.SelectRow, RQST_SEQ);
			currCvrgCmbSeq 	= sheetObj.CellValue(sheetObj.SelectRow, CVRG_SEQ);
			//------------------------------------------------------------------
			
			setMultiOriginOrDestTitle();
			doActionRFAChildRetrieve();
		}
	}

	/**
	 * Row 를 더블클릭시 관련 팝업화면을 띄운다.
	 */	
	function t2sheet1_OnDblClick(sheetObj,Row,Col) {
		
		 doActionDetail();
	}
		
	/**
	 * T2Sheet1 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function t2sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {

		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow >= HeaderRows && MouseRow <= LastRow) {

				if (colName == CNT_CD || colName == RGN_CD || colName == LOC_CD) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DMOF 일 경우 말풍선 "BKG POL/CY"
					//         DMIF 일 경우 말풍선 "BKG POD/CY"
					//         DTOC, CTOC 일 경우 말풍선 "BKG POR"
					//         DTIC, CTIC 일 경우 말풍선 "BKG DEL"				
					switch(trfCd) {
						case "DMOF": MouseToolTipText = "BKG POL/CY"; break;
						case "DMIF": MouseToolTipText = "BKG POD/CY"; break;
						case "DTOC":
						case "CTOC": MouseToolTipText = "BKG POR"; break;
						case "DTIC":
						case "CTIC": MouseToolTipText = "BKG DEL"; break;
						default: MouseToolTipText = "";
					}
				}
				else if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DMOF, DTOC, CTOC 일 경우 말풍선 "BKG DEL"
					//         DMIF, DTIC, CTIC 일 경우 말풍선 "BKG POR" 		
					switch(trfCd) {
						case "DMOF":
						case "DTOC":
						case "CTOC": MouseToolTipText = "BKG DEL"; break;
						case "DMIF": 
						case "DTIC":
						case "CTIC": MouseToolTipText = "BKG POR"; break;
						default: MouseToolTipText = "";
					}
				}
				else if (colName == BKGDEL_CNT || colName == BKGDEL_RGN || colName == BKGDEL_LOC) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DMIF 일 경우 말풍선 "BKG DEL for Demurrage Only"
					//         DMOF 일 경우 말풍선 "BKG POR for Demurrage Only" 		
					switch(trfCd) {
						case "DMIF": MouseToolTipText = "BKG DEL for Demurrage Only"; break;
						case "DMOF": MouseToolTipText = "BKG POR for Demurrage Only"; break;
						default: MouseToolTipText = "";
					}
				}				
				else {
					MouseToolTipText = "";
				}
			}
			else {
				MouseToolTipText = "";
			}			
		}		
	}	 
	
	/**
	 * T2Sheet1 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function t2sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {

		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			var tariff = CellValue(MouseRow, TARIFF);
			
			if (MouseRow >= HeaderRows && MouseRow <= LastRow) {
				if (colName == CNT_CD || colName == RGN_CD || colName == LOC_CD) {
					//Tariff 가 DMOF 일 경우 말풍선 "BKG POL/CY"
					//         DMIF 일 경우 말풍선 "BKG POD/CY"
					//         DTOC, CTOC 일 경우 말풍선 "BKG POR"
					//         DTIC, CTIC 일 경우 말풍선 "BKG DEL"				
					switch(tariff) {
						case "DMOF": MouseToolTipText = "BKG POL/CY"; break;
						case "DMIF": MouseToolTipText = "BKG POD/CY"; break;
						case "DTOC":
						case "CTOC": MouseToolTipText = "BKG POR"; break;
						case "DTIC":
						case "CTIC": MouseToolTipText = "BKG DEL"; break;
						default: MouseToolTipText = "";
					}
				}
				else if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					//Tariff 가 DMOF, DTOC, CTOC 일 경우 말풍선 "BKG DEL"
					//         DMIF, DTIC, CTIC 일 경우 말풍선 "BKG POR" 		
					switch(tariff) {
						case "DMOF":
						case "DTOC":
						case "CTOC": MouseToolTipText = "BKG DEL"; break;
						case "DMIF": 
						case "DTIC":
						case "CTIC": MouseToolTipText = "BKG POR"; break;
						default: MouseToolTipText = "";
					}
				}
				else if (colName == BKGDEL_CNT || colName == BKGDEL_RGN || colName == BKGDEL_LOC) {
					//Tariff 가 DMIF 일 경우 말풍선 "BKG DEL for Demurrage Only"
					//         DMOF 일 경우 말풍선 "BKG POR for Demurrage Only" 		
					switch(tariff) {
						case "DMIF": MouseToolTipText = "BKG DEL for Demurrage Only"; break;
						case "DMOF": MouseToolTipText = "BKG POR for Demurrage Only"; break;
						default: MouseToolTipText = "";
					}
				}				
				else {
					MouseToolTipText = "";
				}
			}
			else {
				MouseToolTipText = "";
			}			
		}		
	}	
	
	/**
	 * T2Sheet2 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function t2sheet2_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		var sheetRFAObj = sheetObjects[5];
		
		var tariff = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, TARIFF);
		
		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow >= HeaderRows && MouseRow <= LastRow) {
				if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					//Tariff 가 DMOF 일 경우 말풍선 "BKG POL/CY"
					//         DMIF 일 경우 말풍선 "BKG POD/CY"
					//         DTOC, CTOC 일 경우 말풍선 "BKG POR"
					//         DTIC, CTIC 일 경우 말풍선 "BKG DEL"				
					switch(tariff) {
						case "DMOF": MouseToolTipText = "BKG POL/CY"; break;
						case "DMIF": MouseToolTipText = "BKG POD/CY"; break;
						case "DTOC":
						case "CTOC": MouseToolTipText = "BKG POR"; break;
						case "DTIC":
						case "CTIC": MouseToolTipText = "BKG DEL"; break;
						default: MouseToolTipText = "";
					}
				}			
				else {
					MouseToolTipText = "";
				}
			}
			else {
				MouseToolTipText = "";
			}			
		}		
	}	
		
 	/**
 	 * 선택한 Before Booking Request 데이터의 Tariff 에 따라서 Multi Origin or Destination 의 제목을 변경한다.
 	 */	  	 
  	function setMultiOriginOrDestTitle() {
		var sheetRFAObj = sheetObjects[5];
		var sheetMultiOrgDestObj = sheetObjects[6];
		 
		var tariff = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, TARIFF);

		var HeadTitle1 = "";
		var HeadTitle2 = "|Seq.|Continent|Country|Region|Location";	
		switch(tariff) {
			case "DMOF":
			case "DTOC":
			case "CTOC":
				HeadTitle1 = "|Seq.|BKG DEL|BKG DEL|BKG DEL|BKG DEL";
				break;
				
			case "DMIF":
			case "DTIC": 
			case "CTIC":				
				HeadTitle1 = "|Seq.|BKG POR|BKG POR|BKG POR|BKG POR";
				break;
		}
		
		sheetMultiOrgDestObj.InitHeadRow(0, HeadTitle1, true);
		sheetMultiOrgDestObj.InitHeadRow(1, HeadTitle2, true);  		
  	}	 
	 
  	/*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function doProcessPopup(sheetObj, srcName) {
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		var propNo = sheetObj.CellValue(sheetObj.SelectRow, PROP_NO);
  		
  		with(sheetObj) {
  	  		switch(srcName) {
 	  			case "Affiliate":	// Affiliate Inquiry Popup
  	  				var paramVal 	= "?cond_prop_no=" + propNo;
	  				var rtnVal 		= ComOpenWindowCenter("ESM_PRI_2019_06.do" + paramVal, "", 1020, 335, true); 	  			
 					break;
  	  		
  	  			case "cust_cd":		// Customer Inquiry Popup
  	  				ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true); 	  			
  					break;
  					
  	  			case SC_TAB:
  	  				ComOpenPopup('EES_DMT_2001.do?prop_no=' + propNo + '&caller=2007', 1020, 710, 'findCustomer', '1,0,1,1,1,1,1', true);
  	  				break;
  	  				
  	  			case RFA_TAB:
  	  				ComOpenPopup('EES_DMT_2003.do?prop_no=' + propNo + '&caller=2007', 1020, 690, 'findCustomer', '1,0,1,1,1,1,1', true);
  	  				break;
  					
  	  		} // switch-end
  		} // with-end
  	}
  	
 	function openWinSearchCustomer(srcName) {
		var sheetObj = sheetObjects[0];
		
		doProcessPopup(sheetObj, srcName);
	}
 	
	/**
   	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
   	 */
     function getCustCd(aryPopupData) {
   		var formObj = document.form;
   		document.form.custCd.value = aryPopupData[0][3];
   		document.form.custNm.value = aryPopupData[0][4];
     }
 	   
 	/**
	 * Customer ID 입력 후 포커스 아웃시 Customer Name 을 조회한다.
	 */
	function searchCustomerName() {
		var formObj = document.form;
		 
		var custCd = ComTrim(ComGetObjValue(formObj.custCd));
		if (custCd.length > 2) {
			ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
			ComSetObjValue(formObj.cust_seq, custCd.substring(2));		 
			 
			doActionIBCommon(sheetObjects[0], formObj, IBSEARCH_CUST_NM, SEARCH19);
		}
		else {
			ComClearObject(formObj.custCd);
			ComClearObject(formObj.custNm);
		}
	}

	/**
	 * 화면 Load 시 비활성화시킬 컨트롤들을 정의해서 설정해주는 함수
	 */	 
	function initDisableControls() {
		 var formObj = document.form;
		 
		 with(formObj) {
			 ComEnableManyObjects(false, custNm);
			 custNm.className = "input2";
		 }
	}
	
	/**
 	 * 조회 Date 필드 초기화
 	 */
 	function initOfficeControls() {
 		var formObj = document.form;
 		
 		//조회조건 부분적으로 활성화/비활성화  처리
 		formObj.cond_type[0].checked = true;
 		
 		//Incl.Sub Office 초기화
 		formObj.chkSubOfc.checked = false;
 		
 		//팝업화면으로 Load 될 경우 DAR 항목을 선택하고 파라미터로 전달받은 S/C No. 나 RFA No. 로 조회를 수행한다.
 		if (isPopupWindow()) {
 			//Default 선택이 Office 이기 때문에 DAR 선택으로 변경해준다.
 			formObj.cond_type[2].checked = true;
 			doEnableCondObj("dar");
 		}
 		//메인화면으로  Load 될 경우 OFFICE 항목을 선택한다.
 		else {
 			//Default 선택이 Office 이기 때문에, 초기화 시킬경우 자동선택해 준다.
 			formObj.cond_type[0].checked = true; 			
 			doEnableCondObj("office");
 		}
 	}
 	
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj, comboItems, comboType) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
    		
    		//멀티콤보에서 전형적인 SELECT 처럼 TEXT 와 CODE 값만을 가지도록 설정함.
    		if (comboType == "ONE-SELECT") {
    			comboObj.InsertItem(i, comboItem[1], comboItem[0]);
    		}
    		else {
    			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
    		}
    	}   		
	}
	     
    /**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */	
 	function setComboItem(comboObj,comboItems) {
 		var checkedItem = comboItems[0].split(FIELDMARK);
 		comboObj.Text = checkedItem[0];
 	}
 	
  	//S/C 멀티콤보 클릭 이벤트
  	function combo1_OnCheckClick(comboObj, index, code) {
  		setMultiCombo(comboObj, index, code) ;
  	}
  	
 	//RFA(Before BKG DAR) 멀티콤보 클릭 이벤트
 	function combo2_OnCheckClick(comboObj, index, code) {
 		setMultiCombo(comboObj, index, code) ;
 	}
 	
 	//Tariff Type 멀티콤보 클릭 이벤트
 	function combo3_OnCheckClick(comboObj, index, code) {
 		setMultiCombo(comboObj, index, code) ;
 	}
 	
	//멀티콤보 Click Event Catch
 	function combo4_OnCheckClick(comboObj, index, code) {
 		var formObj = document.form;
 		
 		if (formObj.chkSubOfc.checked) {
 			comboObj.checkIndex(index) = !comboObj.checkIndex(index);
 			ComShowCodeMessage('DMT00107');
 		}
 	}
	
	//멀티콤보 Click Event Catch
 	function combo4_OnKeyDown(comboObj, keycode, shift) { 
 		var formObj = document.form;
 		
 		if (formObj.chkSubOfc.checked) {
 			ComShowCodeMessage('DMT00107');
 		}
 	}	
	
	//DEM/DET Office 를 Login Office 로 초기화 해주는 함수
   	function setDefaultRefOffice() {
		var formObj 	 = document.form;
		var cboRefOffice = comboObjects[3];

		var itemindex = cboRefOffice.FindIndex(ComGetObjValue(formObj.login_ofc_cd), 0); 
		if (itemindex == -1) {
			cboRefOffice.Code = -1;
		}
		else {
			cboRefOffice.Code = ComGetObjValue(formObj.login_ofc_cd);
		}
   	}
	
    function condType_click() {
    	
    	doEnableCondObj(event.srcElement.value);
    }
	    
	function doEnableCondObj(condType) {
		var sheetObj 	= sheetObjects[0];
		var formObj 	= document.form;
		
		if (condType == "office" || condType == "coverage") {
			ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
		}
		
		//콤보객체 정의
		var cboOFCObj = comboObjects[3];
		var cboCNTObj = comboObjects[4];
		var cboRGNObj = comboObjects[5];
		
		
		with (formObj) {
			switch(condType){
				case "office":
					//Office 조회조건 필드들 활성화
					cboOFCObj.Enable = true;
					cboOFCObj.Index = 0;
					ComEnableManyObjects(true, ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					ofcEffDtFm.className = "input1";
					ofcEffDtTo.className = "input1";
					chkSubOfc.className = "trans";
					
					ComSetObjValue(ofcEffDtFm, ComGetDateAdd(ofcCurrDate, "D", -30));
					ComSetObjValue(ofcEffDtTo, ofcCurrDate);
					
					//Ref. Office 를 Login Office 로 설정해준다.
					setDefaultRefOffice();
					
					//Coverage 조회조건 필드들 비활성화
					cboCNTObj.Text = "";
					cboRGNObj.Text = "";
					cboCNTObj.Enable = false;
					cboRGNObj.Enable = false;
					ComEnableManyObjects(false, location, cvrgEffDtFm, cvrgEffDtTo);
					ComClearManyObjects(location, cvrgEffDtFm, cvrgEffDtTo);
					
					//DAR 조회조건 필드 비활성화
					ComEnableManyObjects(false, sCNo, rFANo, proposalNo, darNo, approvalNo);
					ComClearManyObjects(sCNo, rFANo, proposalNo, darNo, approvalNo);

					ComSetFocus(formObj.sCNo);
					break;
				
				case "coverage":
					//Office 조회조건 필드들 비활성화
					cboOFCObj.Text = "";
					cboOFCObj.Enable = false;
					ComEnableManyObjects(false, ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					ComClearManyObjects(ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					
					//Coverage 조회조건 필드들 활성화
					cboCNTObj.Enable = true;
					cboRGNObj.Enable = true;
					ComEnableManyObjects(true, location, cvrgEffDtFm, cvrgEffDtTo);
					location.className = "input";
					cvrgEffDtFm.className = "input1";
					cvrgEffDtTo.className = "input1";

					ComSetObjValue(cvrgEffDtFm, ComGetDateAdd(ofcCurrDate, "D", -30));
					ComSetObjValue(cvrgEffDtTo, ofcCurrDate);
					
					//DAR 조회조건 필드 비활성화
					ComEnableManyObjects(false, sCNo, rFANo, proposalNo, darNo, approvalNo);
					ComClearManyObjects(sCNo, rFANo, proposalNo, darNo, approvalNo);
					break;
					
				case "dar":
					//Office 조회조건 필드들 비활성화
					//cboOFCObj.Text = "";
					cboOFCObj.Code2 = -1;
					cboOFCObj.Enable = false;
					
					ComEnableManyObjects(false, ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					ComClearManyObjects(ofcEffDtFm, ofcEffDtTo, chkSubOfc);
					
					//Coverage 조회조건 필드들 비활성화
					cboCNTObj.Text = "";
					cboRGNObj.Text = "";					
					cboCNTObj.Enable = false;
					cboRGNObj.Enable = false;
					ComEnableManyObjects(false, location, cvrgEffDtFm, cvrgEffDtTo);
					ComClearManyObjects(location, cvrgEffDtFm, cvrgEffDtTo);
					
					//DAR 조회조건 필드들 활성화
					ComEnableManyObjects(true, sCNo, rFANo, proposalNo, darNo, approvalNo);
					sCNo.className = "input";
					rFANo.className = "input";
					proposalNo.className = "input";
					darNo.className = "input";
					approvalNo.className = "input"
						
					//선택한 조회조건의 첫번째 컨트롤에 포커스를 준다.
					ComSetFocus(sCNo);
					break;
			}
		}
	}
	
   /**
    * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
    */
	function doInclSubOfc() {
		var formObj 	= document.form;
		var cboOFCObj 	= comboObjects[3];
		
		if(formObj.chkSubOfc.checked) {	// Sub Office 포함
			if (ComIsEmpty(cboOFCObj.Code)) {
				ComShowCodeMessage('COM12113', "DEM/DET Office");
				formObj.chkSubOfc.checked = false;
				return;
			}
			formObj.ofc_cd.value 		= ComGetObjValue(cboOFCObj);
			formObj.tmp_ofc_cd.value 	= ComGetObjValue(cboOFCObj);
			
			doActionIBCommon(sheetObjects[0],formObj,IBSEARCH_REF_OFC,COMMAND01);
		} 
		else {
			ComSetObjValue(cboOFCObj, ComGetObjValue(formObj.tmp_ofc_cd));
		}
	}
    
	/**
	 * Country 조회필드가 변경될 경우 해당 Region or State 정보를 조회해주는 함수
	 */		
	function cboCountry_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		var cntCd = comboObj.Text;
		
		//Country 이 변경될 경우 Location 정보를 지운다.
		if (isClearLocation) clearLocation();
		
		//Region Caption 을 Country Code 에 따라서 변경해 준다.
		switch(cntCd) {
			case "CA":
			case "US":
				Region.innerHTML = "State";
				break;
				
			default:
				Region.innerHTML = "Region";
		}
		
		//Country 가 Empty 라면 모든 Region 정보를 조회한다.
		if (cntCd.length == 0) {
			doActionIBCommon(sheetObjects[0],formObj,IBSEARCH_CVRG,SEARCH01);
			return;	
		}
		
		//Country 에 소속된 하위 Region or State 정보를 조회한다.
	    ComSetObjValue(formObj.cnt_cd, cntCd);
		doActionIBCommon(sheetObjects[0],formObj,IBSEARCH_CVRG,SEARCH03);
	}
	
 	/**
 	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
 	 */	
	function cboRegion_OnChange(comboObj, Index_Code, Text) {
 		var sheetObj = sheetObjects[0];
 		var formObj = document.form;
 		var rgnCd = comboObj.Text;

		switch(rgnCd.length) {
			case 2: //State Code 로 상위 코드를 찾는다.
				ComSetObjValue(formObj.ste_cd, rgnCd);
				doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH17);
				break;
				
			case 3:	//Region Code 로 상위 코드를 찾는다.
				ComSetObjValue(formObj.rgn_cd, rgnCd);
				doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH13);
				break;
		}
 		
		//Region 이 변경될 경우 Location 정보를 지운다.
		if (isClearLocation) clearLocation();
 	}
	
	/**
	 * Location 조회필드에서 Enter Key 가 입력될 경우 Location 을 포함하는 Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation() {
		var formObj = document.form;
		var locCd = ComTrim(ComGetObjValue(formObj.location));
		if (locCd.length == 5) {
			isClearLocation = false;
			//Location 상위(Country, Region or State) 정보를 조회한다.
			ComSetObjValue(formObj.loc_cd, locCd);
			doActionIBCommon(sheetObjects[0],formObj,IBSEARCH_CVRG,SEARCH04);
			isClearLocation = true;
		}
	}
	 
	/**
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
	}
	 
 	/**
 	 * S/C & RFA Exception Inqury 조회조건에 맞는 데이터 조회하는 동작을 정의하는 함수
 	 */ 	 
	function doActionRetrieve() {
 		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		var sheetRFAObj = sheetObjects[5];
		
		var sCNo 	= ComTrim(ComGetObjValue(formObj.sCNo));
		var rFANo 	= ComTrim(ComGetObjValue(formObj.rFANo));
		var propNo 	= ComTrim(ComGetObjValue(formObj.proposalNo));
		var darNo 	= ComTrim(ComGetObjValue(formObj.darNo));
		var apvlNo 	= ComTrim(ComGetObjValue(formObj.approvalNo));
		
		//1.조회전 Validation Check 를 수행한다.
		if (!validateForm(sheetSCObj,formObj,IBSEARCH)) return; 

		//2.조회전 기존 조회결과를 삭제해 준다.
		for (var sheetNo = 0 ; sheetNo < sheetObjects.length ; sheetNo++) {
			sheetObjects[sheetNo].RemoveAll();
		}

		//3.조회전 화면에서 입력받은 파라미터를 설정한다.(한 번 호출시 S/C, RFA 의 조회조건을 모두 만족하도록 설정한다.),
		setCommonParameters();

		//4.조회 TYPE 이 S/C 인지 체크해서 조회를 실행한다.
		if (formObj.chkSC.checked) {
			
			//4-1.DAR 항목 선택시 S/C No. 나 Proposal No. 가 입력되었을 경우에만 조회를 수행한다.	
		    if (	formObj.cond_type[0].checked 
		    	|| 	formObj.cond_type[1].checked 
		    	|| (formObj.cond_type[2].checked && (sCNo != '' || propNo != ''))	) {
			
				//4-2.S/C 조회
				doActionIBSheet(sheetSCObj,formObj,IBSEARCH);
				
				//------------------------------------------------------------------
				currPropNo  = sheetSCObj.CellValue(sheetSCObj.SelectRow, PROP_NO);
				currVerSeq 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, VER);
				currGrpSeq	= sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);
				currCvrgSeq = sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_SEQ);
				//------------------------------------------------------------------				
		
				//4-3.조회된 S/C 가 있다면 해당 자식 정보들을 조회한다.
				if (sheetSCObj.RowCount > 0) {
					doActionSCChildRetrieve();
				}
		    }
		}

		//5.조회 TYPE 이 RFA(Before Booking) 인지 체크해서 조회를 실행한다.		
		if (formObj.chkRFA.checked) {
			
			//5-1.DAR 항목 선택시 RFA No., Proposal No., DAR No., APVL No. 가 입력되었을 경우에는 조회를 수행한다.
		    if (	formObj.cond_type[0].checked 
			    || 	formObj.cond_type[1].checked 
			    || (formObj.cond_type[2].checked && (rFANo != '' || propNo != '' || darNo != '' || apvlNo != ''))	) {			

			    //5-2.RFA 조회
				doActionIBSheet(sheetRFAObj,formObj,IBSEARCH);
				
				//-------------------------------------------------------------------------
				currDarNo  		= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DAR_NO);
				currDarVerSeq 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, VER);
				currRqstSeq		= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, RQST_SEQ);
				currCvrgCmbSeq 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_SEQ);
				//-------------------------------------------------------------------------
				
				//5-3.조회된 RFA 가 있다면 해당 자식 정보들을 조회한다.
				if (sheetRFAObj.RowCount > 0) {
					doActionRFAChildRetrieve();
				}
		    }
		}
	 }
 	 
  	/**
  	 * New 버튼 클릭시 동작을 정의하는 함수
  	 */ 	 
 	function doActionNew() {
 		var formObj = document.form;
 		
  		//1.Type 을 화면 Load 시점의 상태로 되돌린다.
  		formObj.chkSC.checked = true
  		checkType(formObj.chkSC);
  		 
  		//2.RFA(Before BKG DAR) 을 화면 Load 시점의 상태로 되돌린다.
  		formObj.chkRFA.checked = true;
  		checkType(formObj.chkRFA);
  		
  		//3.Tariff Type 을 화면 Load 시점의 상태로 되돌린다.
  		for (var i = 0 ; i < comboObjects[2].GetCount ; i++) {
  			comboObjects[2].CheckIndex(i) = true;
  		}
  		
  		//4.조회 조건선택을 화면 Load 시점의 상태로 되돌린다.
  		initOfficeControls();
  		
  		//5.Customer 를 화면 Load 시점의 상태로 되돌린다.
  		ComClearObject(formObj.custCd);
  		ComClearObject(formObj.custNm);
  		
  		//6.S/C, RFA 의 조회된 모든 결과를 지워준다.
  		for (var sheetNo = 0 ; sheetNo < sheetObjects.length ; sheetNo++) {
  			sheetObjects[sheetNo].RemoveAll();
  		}
  		
  		//7.S/C, RFA 의 Currency 와 Customer Type 을 지워준다.
  		ComClearObject(formObj.scCurrency);
  		ComClearObject(formObj.rfaCurrency);
  		formObj.custTp.selectedIndex = 0;
 	}
 	
 	/**
	 * Minimize 버튼 클릭시 동작을 정의하는 함수
	 */ 	 
	function doActionMinimize() {
		 var sheetSCObj = sheetObjects[0];
		 var sheetRFAObj = sheetObjects[5];
		 
		if (conditionLayer.style.display == 'inline') {
			conditionLayer.style.display = 'none';
			sheetSCObj.style.height = 162 + 82;
			sheetRFAObj.style.height = 162 + 82;
		}
		else {
			conditionLayer.style.display = 'inline';
			sheetSCObj.style.height = 162;
			sheetRFAObj.style.height = 162;;
		}
	}
	
 	/**
	 * Detail 버튼 클릭시 동작을 정의하는 함수
	 */ 	 
	function doActionDetail() {
		var sheetObj;
		
		//선택한 항목이 있는지 체크한다.
		switch (beforetab) {
			case SC_TAB:
				 sheetObj = sheetObjects[0];
				 if (sheetObj.RowCount < 1) {
					 ComShowCodeMessage("DMT06001");
					 return;
				 }
				 else if (sheetObj.SelectRow == -1) {
					 ComShowCodeMessage("DMT00140", "S/C");
					 return;
				 }
				 break;
				 
			case RFA_TAB:
				 sheetObj = sheetObjects[5];
				 if (sheetObjects[5].RowCount < 1) {
					 ComShowCodeMessage("DMT06001");
					 return;
				 }
				 else if (sheetObjects[5].SelectRow == -1) {
					 ComShowCodeMessage("DMT00140", "RFA");
					 return;
				 }
				 break;
		}
		doProcessPopup(sheetObj, beforetab);
	}
		
 	/**
	 * Down Excel 버튼 클릭시 동작을 정의하는 함수
	 */ 	 
	function doActionDownExcel() {
		
		 //선택한 항목이 있는지 체크한다.
		 switch (beforetab) {
			 case SC_TAB:
				 if (sheetObjects[0].RowCount < 1) {
					 ComShowCodeMessage("DMT06001");
					 return;
				 }
				 sheetObjects[0].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
				 break;
				 
			 case RFA_TAB:
				 if (sheetObjects[5].RowCount < 1) {
					 ComShowCodeMessage("DMT06001");
					 return;
				 }
				 sheetObjects[5].SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
				 break;
		 }
	}
		
    /**
     * Close 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */
    function doActionClose() {
    	
		window.close();
    }
	 
  	/**
  	 * S/C & RFA Exception Inqury 조회결과 선택한 S/C 의 자식데이터 조회하는 동작을 정의하는 함수
  	 */ 	 
 	function doActionSCChildRetrieve() {
 		var formObj 		= document.form;
 		var sheetSCObj 		= sheetObjects[0];
 		var sheetTFObj 		= sheetObjects[1];	//Tiered Free Time
 		var sheetRTObj 		= sheetObjects[2];	//Rate Adjustment
 		var sheetACUSTObj 	= sheetObjects[3];	//Actual Customer
 		var sheetCMDTObj 	= sheetObjects[4];	//Commodity

 		//S/C 자식 정보들을 조회하기 위한 키값
 		with(sheetSCObj) {
 			ComSetObjValue(formObj.prop_no, 		CellValue(SelectRow, PROP_NO));
 			ComSetObjValue(formObj.sc_expt_ver_seq, CellValue(SelectRow, VER));
 			ComSetObjValue(formObj.sc_expt_grp_seq, CellValue(SelectRow, GRP_SEQ));
 			
 	 		//Rate Adjustment Currency 설정
 	 		ComSetObjValue(formObj.scCurrency, 		CellValue(SelectRow, CURR_CD));
 		}
 		
 		//조회전 해당 그리드를 Clear 시킨다.
 		sheetTFObj.RemoveAll();
 		sheetRTObj.RemoveAll();
 		sheetACUSTObj.RemoveAll();
 		sheetCMDTObj.RemoveAll();
 		
 		//Tiered Free Time
 		doActionIBSheet(sheetTFObj, formObj, IBSEARCH);
 		//Rate Adjustment
 		doActionIBSheet(sheetRTObj, formObj, IBSEARCH);
 		//Actual Customer
 		doActionIBSheet(sheetACUSTObj, formObj, IBSEARCH);
 		//Commodity
 		doActionIBSheet(sheetCMDTObj, formObj, IBSEARCH);
 	}
 	
   	/**
   	 * S/C & RFA Exception Inqury 조회결과 선택한 RFA(Before Adjustment Request) 의 
   	 * 자식데이터 조회하는 동작을 정의하는 함수
   	 */ 	 
  	function doActionRFAChildRetrieve() {
  		var formObj 		= document.form;
 		var sheetORGDSTObj 	= sheetObjects[6];	//Multi Origin or Destination
 		var sheetRTObj 		= sheetObjects[7];	//Rate Adjustment
 		
  		//S/C 자식 정보들을 조회하기 위한 키값
  		with(sheetObjects[5]) {
  			ComSetObjValue(formObj.rfa_expt_dar_no, 	CellValue(SelectRow, DAR_NO));
  			ComSetObjValue(formObj.rfa_expt_ver_seq, 	CellValue(SelectRow, VER));
  			ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	CellValue(SelectRow, RQST_SEQ));
  			
 	 		//Rate Adjustment Currency 설정
 	 		ComSetObjValue(formObj.rfaCurrency, 		CellValue(SelectRow, CURR_CD));
  		}
  		
 		//조회전 해당 그리드를 Clear 시킨다.
 		sheetORGDSTObj.RemoveAll();
 		sheetRTObj.RemoveAll();
 		
		//Multi Origin or Destination
		doActionIBSheet(sheetORGDSTObj, formObj, IBSEARCH);
		//Rate Adjustment
		doActionIBSheet(sheetRTObj, formObj, IBSEARCH);		
  	}
  	
   	/**
  	 * 화면단에서 입력된 조회조건데이터를 조회용 매개변수에 설정하는 함수
  	 */ 	    
     function setCommonParameters() {
  		var formObj 		= document.form;
  		var cboSCObj 		= comboObjects[0];
  		var cboRFAObj 		= comboObjects[1];
  		var cboTariffObj 	= comboObjects[2];
  		var cboOFCObj 		= comboObjects[3];
  		var cboCNTObj 		= comboObjects[4];
  		var cboRGNObj 		= comboObjects[5];
  		
  		with(formObj) {
	  		//1.Set S/C Type
			ComSetObjValue(ver_sts_cd, cboSCObj.Code);

	 		//2.Set RFA Type
			ComSetObjValue(rqst_sts_cd, cboRFAObj.Code);

	 		//3.Set Tariff
	  		var trfCd = ComTrim(cboTariffObj.Text);
	  		if (trfCd.indexOf("All") != -1) {
	  			trfCd = trfCd.replace("All,", "");
	  		}
	  		ComSetObjValue(formObj.tariff, trfCd);

	  		//4-1.조회구분을 Office 선택시 
	  		if (cond_type[0].checked) {
	  			ComSetObjValue(ofc_cd, 		ComTrim(cboOFCObj.Text));
	  			ComSetObjValue(fm_dt, 		ComTrim(ComGetObjValue(ofcEffDtFm)));
	  			ComSetObjValue(to_dt, 		ComTrim(ComGetObjValue(ofcEffDtTo)));
	  			ComSetObjValue(cond_tp, 	"OFC");
	  		}
	  		//4-2.조회구분을 Coverage 선택시 
	  		else if (cond_type[1].checked) {
	  	  		var cntCd = ComTrim(cboCNTObj.Text);
	  	  		ComSetObjValue(cnt_cd, cntCd);
	  	  		if (cntCd == "US" || cntCd == "CA") {
	  	  			ComSetObjValue(ste_cd, 	ComTrim(cboRGNObj.Text));
	  	  			ComSetObjValue(rgn_cd, 	"");
	  	  		}
	  	  		else {
	  	  			ComSetObjValue(rgn_cd, 	ComTrim(cboRGNObj.Text));
	  	  			ComSetObjValue(ste_cd, 	"");
	  	  		}
	  	  		ComSetObjValue(loc_cd, 		ComTrim(ComGetObjValue(location)));
	  			ComSetObjValue(fm_dt, 		ComTrim(ComGetObjValue(cvrgEffDtFm)));
	  			ComSetObjValue(to_dt, 		ComTrim(ComGetObjValue(cvrgEffDtTo))); 
	  			ComSetObjValue(cond_tp, 	"CVRG");
	  		}
	  		//4-3.조회구분을 DAR 선택시
	  		else if (cond_type[2].checked) {
	  			ComSetObjValue(sc_no, 		ComTrim(ComGetObjValue(sCNo)));
	  			ComSetObjValue(rfa_no, 		ComTrim(ComGetObjValue(rFANo)));
	  			ComSetObjValue(prop_no, 	ComTrim(ComGetObjValue(proposalNo)));
	  			ComSetObjValue(dar_no, 		ComTrim(ComGetObjValue(darNo)));
	  			ComSetObjValue(apvl_no, 	ComTrim(ComGetObjValue(approvalNo)));
	  			ComSetObjValue(cond_tp, 	"DAR");
	  		}

	  		//5.Set Customer
			var custCode = ComTrim(ComGetObjValue(custCd));
			var custType = ComTrim(ComGetObjValue(custTp));
			if (custCode != "") {
				switch (custType) {
					case "":
						ComSetObjValue(cust_cd, 	custCode);
						ComSetObjValue(act_cust_cd, custCode);
						break;
						
					case "CUST":
						ComSetObjValue(cust_cd, 	custCode);
						ComSetObjValue(act_cust_cd, "");
						break;
						
					case "A/CUST":
						ComSetObjValue(cust_cd, 	"");
						ComSetObjValue(act_cust_cd, custCode);	    						
						break;
				}
			}
			else {
				ComSetObjValue(cust_cd, 	"");
				ComSetObjValue(act_cust_cd, "");
			}
  		}
     }
      	 
 	/**
   	 * Type 체크박스를 선택하거나 선택해지했을 경우 처리하는 함수
   	 */  	 
  	 function checkType(chkObj) {
  		 var cboTypeObj;
  		 var cboCode;
  		 
  		 switch(chkObj.name) {
	  		 case "chkSC":
	  			 cboTypeObj = comboObjects[0];
	  			 cboCode = "L";
	  			 break;
	  			 
	  		 case "chkRFA":
	  			 cboTypeObj = comboObjects[1];
	  			 cboCode = "A";
	  			 break;
  		 }
  		 
      	if (!chkObj.checked) {
 	    	for (var i = 0 ; i < cboTypeObj.GetCount ; i++) {
 	    		cboTypeObj.CheckIndex(i) = false;
 	    	}
 	    	cboTypeObj.Enable = false;
     	}
     	else {
     		cboTypeObj.Enable = true;
     		cboTypeObj.Code = cboCode;
     	}  		 
  	 }
  	 
  	/**
  	 * DAR 조회필드항목중 특정필드에 값이 입력되면 다른 필드들은 모두 Clear 시킨다.
  	 */
  	function clearNoSelectDARFields() {
  	    var formObj = document.form;
  	    
  		with(formObj) {
  			switch(event.srcElement.name) {
  				case "sCNo":
  					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
  					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
  					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
  					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
  					break;
  					
  				case "rFANo":
  					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
  					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
  					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
  					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
  					break;
  		
  				case "proposalNo":
  					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
  					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
  					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
  					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
  					break;
  					
  				case "darNo":
  					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
  					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
  					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
  					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
  					break;
  					
  				case "approvalNo":
  					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
  					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
  					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
  					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
  					break;
  			}
  		}		
  	}
  	 
   	/**
  	 * 2007 화면이 팝업으로 띄워졌는지를 알려주는 함수
  	 */
    function isPopupWindow() {
  	    var formObj = document.form;

  		if (ComGetObjValue(formObj.caller) != "" && (ComGetObjValue(formObj.sCNo) != "" || ComGetObjValue(formObj.rFANo) != "")) {
  			return true;
  		}
  		return false;  		
    } 

	/**
	 * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
	 */
	function handleNullString(sVal) {
	 	
	    if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
	
	    return ComTrim(sVal);
	}  	