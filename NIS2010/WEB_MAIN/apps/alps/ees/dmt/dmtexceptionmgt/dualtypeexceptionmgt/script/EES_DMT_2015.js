/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EESs_DMT_2015.js
*@FileTitle : Dual Type Exception Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.08.24 이성훈
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
     * @class Dual Type Exception Creation : Dual Type Exception Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_2015() {
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
	
	var sheetObjects = new Array();
	var sheetCnt = 0; 

	var comboObjects = new Array();
	var comboCnt = 0;	
	
	//Action 정의
	var IBSEARCH_CUST 		= 101;
	var IBSEARCH_CVRG 		= 102;
	var IBSEARCH_DUAL_CUST 	= 103;
	var IBSEARCH_CNTRCGO 	= 104;
	var IBSEARCH_TYPE 		= 105;
	var IBSEARCH_DUAL_CVRG 	= 106;
	var IBSEARCH_DEL_CUST 	= 107;
	var IBSEARCH_APPLIED 	= 108;
	
	//DATA 구분자 정의
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	//업무전역변수
	var COUNTRY 		= "CNT";
	var REGION 			= "RGN";
	var STATE 			= "STE";
	var LOCATION 		= "LOC";
	var CNTR_CARGE		= "CONTR_CGO";
	
	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation = true;
	
	var DEL_CHK 	= "del_chk";	
	var STATUS 		= "dul_expt_delt_desc";
	var CUST_CD 	= "cust_cd";
	var CUST_NM 	= "cust_nm";
	var TYPE 		= "dmdt_ctrt_expt_tp_cd";
	var EFF_DT 		= "dul_expt_eff_dt";
	var EXP_DT 		= "dul_expt_exp_dt";
	var BOUND 		= "io_bnd_cd";
	var CVRG_CNT 	= "cvrg_cnt_cd";
	var CVRG_RGN 	= "cvrg_rgn_ste_cd";
	var CVRG_LOC 	= "cvrg_loc_cd";
	var CNTRCGO 	= "dmdt_cntr_cgo_tp_cd";
	var REMARK 		= "dul_expt_rmk";
	var UPD_OFC 	= "upd_ofc_cd";
	var UPD_USR_NM 	= "upd_usr_nm";
	var UPD_DT 		= "upd_dt";
	var EXP_DT 		= "exp_dt";
	var SC_NO 		= "sc_no";
	var RFA_NO 		= "rfa_no";
	var PROP_NO 	= "prop_no";
	var DAR_NO 		= "dar_no";
	var VER_NO 		= "ver";
	var VER_STATUS 	= "status";
	var APVL_NO 	= "apvl_no";
	var CNT_CD 		= "cnt_Cd";
	var RGN_CD 		= "rgn_Cd"
	var LOC_CD 		= "loc_cd";
	var LOC_TP 		= "loc_tp";
	var CUST_SEQ	= "cust_expt_seq";

	
	//Type(SC, Before) 에 따라서 CNTR/Cargo Type 이 다르게 나타나야 한다.
	//페이지 로드시점에 Type 에 따른 CNTR/Cargo Type 을 조회해서 전역변수에 저장해 놓고, Type 변경시 해당 정보를 보여주도록 처리하기 위함 
	var sCCNTRCargoType 	= "";
	var rfaCNTRCargoType 	= "";	
	
  	//Sort 시 선택되어진 Row 의 선택상태를 계속 유지하기 위해서 사용되는 변수
	var currCustCd			= "";
	var currCustSeq			= "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	     var sheetObject1 = sheetObjects[0];
  	     var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObj = document.form;

    	try {
     		var srcObj = window.event.srcElement;
     		var srcName = srcObj.getAttribute("name");;

            switch(srcName) {
	         	case "btns_calendar": //달력 버튼
	     			var cal = new ComCalendarFromTo();
	                cal.select(formObj.effFmDt, formObj.effToDt, 'yyyy-MM-dd');
					break;
					
				case "btn_DownExcel":
					if (ComIsBtnEnable("btn_DownExcel")) 
						doActionDownExcel(sheetObject1);
					break;
				
				case "btn_Retrieve":
					if (ComIsBtnEnable("btn_Retrieve")) 
						doActionRetrieve();
					break;
				
				case "btn_Detail":
					if (ComIsBtnEnable("btn_Retrieve")) 
						doActionDetail();
					break;
					
				case "btn_New":
					if (ComIsBtnEnable("btn_New")) 
						doActionNew();
					break;
				
				case "btn_MainDownExcel":
					if (ComIsBtnEnable("btn_MaindDownExcel"))
						doActionDownExcel(sheetObject2);
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
		var formObj = document.form;
		
        for (i = 0 ; i < sheetObjects.length ; i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
	 	//1.IBMultiCombo초기화 
	    for (var k = 0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k],k+1);
	    }

		//2.html컨트롤 이벤트초기화
		initControl();

		//3.화면 Load 시 비활성화될 컨트롤들을 초기화 시킨다.
		initDisableObjects();
		
		//4.버튼의 상태를 초기화 시킨다.
		initBtnControl();
    }

  	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
  	function sheet1_OnLoadFinish() {
  		var formObj = document.form
  		var sheetObj = sheetObjects[0];
     	
  		//Dual Type Exception 에 등록된 Customer 정보를 조회한다.
  		doActionIBCommon(sheetObj,formObj,IBSEARCH_CUST,SEARCH01);
  		
		//Type 조회 후 콤보에 조회된 결과 설정
		doActionIBCommon(sheetObj,formObj,IBSEARCH_TYPE,SEARCH15,TYPE);
		
		//Country 조회 후 콤보에 조회된 결과 설정
		//Coverage 의 CN 필드에 적용됨
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH02,CVRG_CNT);	
		
		// CNTR CGO Type 전역변수 설정
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CNTRCGO,SEARCH11);
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CNTRCGO,SEARCH15);
		
		//전체 Country 정보 조회 후 콤보에 설정
  		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
  		//전체 Region 정보 조회 후 콤보에 설정
  		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
  		
  		//전역 변수 CNTR_CGO_TP 데이터를 이용한 콤보 아이템 추가
//  		comboDatas = ComGetEtcData(sXml, CNTR_CARGE);
//		if (comboDatas != undefined) {
//			comboItems = comboDatas.split(ROWMARK);
//			addComboItem2(comboObjects[3],comboItems);
//			
//			for (var i = 0 ; i < comboItems.length ; i++) {
//	    		var comboItem = comboItems[i].split(FIELDMARK);
//	    		comboObjects[3].CheckIndex(i) = true; 
//	    	}
//		}
  		makeCntrCgoCombo(comboObjects[3], 'A');
  	}
  	
  	// Type 콤보값이 변하면 그에 따른 CNTR_CGO 타입 목록을 갱신한다.
  	function refreshTypeCombo(val) {
  		makeCntrCgoCombo(comboObjects[3], val);
  	}
  	
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

    	sheetObj.ToolTipOption="balloon:true;width:50;";
        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;
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

                    var HeadTitle1 = "|Seq.||Status|Customer|Customer|Type|PROP No|EFF DT|EXP DT|Bound|Coverage|Coverage|Coverage|CNTR/Cargo Type|Remark|Update|Update|Update";
                    var HeadTitle2 = "|Seq.||Status|Code|Name|Type|PROP No|EFF DT|EXP DT|Bound|CN|RGN|LOC|CNTR/Cargo Type|Remark|Office|Name|Date";
                    var headCount = ComCountHeadTitle(HeadTitle2) + 1;
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)                    
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    	daCenter,   	true,   "ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,    		 35,    	daCenter,   	true,   "Seq"); 
                    InitDataProperty(0, cnt++ , dtHidden,		 30,		daCenter,		true,	DEL_CHK,		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 60,		daCenter,		true,	STATUS,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 80,		daCenter,		true,	CUST_CD,  		false,	"",		dfNone,			0,	false,		false);
                                        		                                       
					InitDataProperty(0, cnt++ , dtData,   		 180,		daLeft,			true,	CUST_NM,		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtCombo,   		 90,		daCenter,		true,	TYPE,			false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 90,		daCenter,		true,	"prop_no",		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 80,		daCenter,		true,	EFF_DT,			false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 80,		daCenter,		true,	EXP_DT,  		false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtCombo,   		 80,		daCenter,		true,	BOUND,  		false,	"",		dfNone,			0,	false,		false);
                                        		                                       
					InitDataProperty(0, cnt++ , dtCombo,   	 	 50,		daCenter,		true,	CVRG_CNT,  		false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtCombo,   	 	 50,		daCenter,		true,	CVRG_RGN, 		false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 60,		daCenter,		true,	CVRG_LOC, 		false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtCombo,   		 110,		daLeft,			true,	CNTRCGO, 		false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 200,		daLeft,			true,	REMARK, 		false,	"",		dfNone,			0,	false,		false);
                                                                                   
					InitDataProperty(0, cnt++ , dtData,   		 75,		daCenter,		true,	UPD_OFC,		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 120,		daLeft,			true,	UPD_USR_NM,  	false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 80,		daCenter,		true,	UPD_DT,  		false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	 80,		daCenter,		true,	CUST_SEQ,  		false,	"",		dfNone,			0,	false,		false);
					
					InitDataCombo(0, TYPE, "", "");
					InitDataCombo(0, BOUND, " |Inbound|Outbound", " |I|O");
					InitDataCombo(0, CVRG_CNT, "", "");
					InitDataCombo(0, CVRG_RGN, "", "");					
					InitDataCombo(0, CNTRCGO, "", "");	

		            //영문 대문자만 입력되도록 설정=================================
		            InitDataValid(0, CVRG_LOC,  vtEngUpOther, "0123456789");
		            //==========================================================
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(TYPE);					
               }
                break;

            case 2:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 160;
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

                    var HeadTitle1 = "Seq.|S/C No.|RFA No.|Prop No.|DAR No.|Ver.|Approval No|Status|EFF DT|EXP DT|Bound|Coverage|Coverage|Coverage|CNTR/Cargo Type|Local Type";
                    var HeadTitle2 = "Seq.|S/C No.|RFA No.|Prop No.|DAR No.|Ver.|Approval No|Status|EFF DT|EXP DT|Bound|CN|RGN|LOC|CNTR/Cargo Type|Local Type";
                    var headCount = ComCountHeadTitle(HeadTitle2);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)                    
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,    		 30,    	daCenter,   	true,  	"Seq"); 
					InitDataProperty(0, cnt++ , dtData,			 80,		daCenter,		true,	SC_NO,		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 80,		daCenter,		true,	RFA_NO,		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 80,		daCenter,		true,	PROP_NO,	false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		110,		daCenter,		true,	DAR_NO,		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 40,		daCenter,		true,	VER_NO,		false,	"",		dfNone,			0,	false,		false);
                                        		                                                                                  
					InitDataProperty(0, cnt++ , dtData,   		110,		daCenter,		true,	APVL_NO,	false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 90,		daCenter,		true,	VER_STATUS,	false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 80,		daCenter,		true,	EFF_DT,		false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 80,		daCenter,		true,	EXP_DT,		false,	"",		dfDateYmd,		0,	false,		false);
                                                                                                                              
					InitDataProperty(0, cnt++ , dtCombo,   		 80,		daCenter,		true,	BOUND,  	false,	"",		dfNone,			0,	false,		false);					
					InitDataProperty(0, cnt++ , dtData,   		 50,		daCenter,		true,	CNT_CD,		false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 50,		daCenter,		true,	RGN_CD,		false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 60,		daCenter,		true,	LOC_CD,		false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtCombo,   		110,		daLeft,			true,	CNTRCGO,	false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		 65,		daCenter,		true,	LOC_TP,		false,	"",		dfNone,			0,	false,		false);
					
					InitDataCombo(0, BOUND, " |Inbound|Outbound", " |I|O");
					InitDataCombo(0, CNTRCGO, "", "");					
					
		            //영문 대문자만 입력되도록 설정=================================
		            InitDataValid(0, LOC_CD,  vtEngUpOther, "0123456789");
		            //==========================================================
					
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
	    var sheetObj = sheetObjects[0];

	    switch(comboNo) {

	    	//화면에 등록된 Customer 조회
	    	case 1:
	    		with(comboObj) {
					MultiSelect = false;
					UseAutoComplete = true;
					SetColAlign("left|left");
					SetColWidth("90|300");
					DropHeight = 160;
					
					ValidChar(2, 1);	// 영어대문자, 숫자 사용
					MaxLength = 8;					
	    		}
	    		break;
	    	//Country 콤보  초기화
			case 2:
				with (comboObj) { 
					MultiSelect = false; 
					SetColAlign("left|left");
					SetColWidth("30|200");
					FontName 	= "Tahoma";					
					DropHeight 	= 160;
					
					ValidChar(2, 2);	// 영어대문자 사용
		    	}
				break;
			
			//Region 콤보 초기화
			case 3: 
				with (comboObj) { 		
					MultiSelect = false; 
					SetColAlign("left|left");        
					SetColWidth("50|190");
					FontName 	= "Tahoma";
					DropHeight 	= 160;
					
					ValidChar(2, 2);	// 영어대문자 사용
				}
				break;
			//CNTR/Cargo 콤보 초기화
			case 4: 
				with (comboObj) { 		
					MultiSelect = true; 
					UseAutoComplete = true;	
					SetColAlign("left");
					SetColWidth("300");
					
					DropHeight = 300;
				}
				break;
	     } 
	}
	   	
  	function initControl() {
		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- 포커스 나갈때  		
		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- 포커스 들어갈때  	
		axon_event.addListener('keydown', 		'ComKeyEnter', 	'form');
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
     function obj_blur(){
         //입력Validation 확인하기 + 마스크구분자 넣기
    	 var obj = event.srcElement;
    	 if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
    		 
    	 } else if(obj.name == 'yd_cd' || obj.name == 'tmnl_cd') {
    		 if(obj.value.length > 0 && obj.value.length < 5) {
    			var cdDiv = (obj.name == 'yd_cd') ? 'Yard' : 'Location';
	 			ComShowCodeMessage('DMT00110', cdDiv);
	 		 }
    	 } else {
    		 ComChkObjValid(obj);
    	 }
     }
     
	function initDisableObjects() {
		var formObj = document.form;
		
		with(formObj) {
			ComEnableManyObjects(false, custNm);
			custNm.className = "input2";
		}		
	}	 

	/**
	 * 화면이 로드되는 시점에 버튼의 상태를 초기화 시킨다.
	 */
    function initBtnControl() {
		
		//Dual Type Exception Button
		ComBtnDisable("btn_Detail");			//Detail 버튼
        ComBtnDisable("btn_DownExcel");			//Down Excel 버튼
		
        //Dual Type Exception Applied Data's Button
	    ComBtnEnable("btn_Retrieve");			//Retrieve 버튼
		ComBtnEnable("btn_New");				//New 버튼
		ComBtnDisable("btn_MainDownExcel");		//Down Excel 버튼
	}
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	//Dual Type Exception 조회
			case IBSEARCH:
				if (validateForm(sheetObj,formObj,sAction)) {
					
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					var cboCustomerObj 	= comboObjects[0];
					var custCd 			= ComTrim(cboCustomerObj.Text);
					if (custCd.length > 2) {
						var custCnt = custCd.substring(0,2);
						var custSeq = custCd.substring(2);
						
						ComSetObjValue(formObj.cust_cnt_cd, custCnt);
						ComSetObjValue(formObj.cust_seq, 	custSeq);

						switch(custSeq.length) {
							case 1: custSeq = "00000" 	+ custSeq;
								break;
							case 2: custSeq = "0000" 	+ custSeq;
								break;
							case 3: custSeq = "000" 	+ custSeq;
								break;
							case 4: custSeq = "00" 		+ custSeq;
								break;
							case 5: custSeq = "0" 		+ custSeq;
								break;
						}

						custCd = custCnt + custSeq;
						cboCustomerObj.Text = custCd;						
					} 
					else {
						ComSetObjValue(formObj.cust_cnt_cd, "");
						ComSetObjValue(formObj.cust_seq, 	"");		
					}
					ComSetObjValue(formObj.dul_expt_eff_dt, 	ComGetUnMaskedValue(ComGetObjValue(formObj.effFmDt), "ymd"));
					ComSetObjValue(formObj.dul_expt_exp_dt, 	ComGetUnMaskedValue(ComGetObjValue(formObj.effToDt), "ymd"));
					ComSetObjValue(formObj.dul_expt_delt_flg, 	ComGetObjValue(formObj.status));
					ComSetObjValue(formObj.intg_cd_id, 			"CD01969");
					ComSetObjValue(formObj.f_cmd, 				SEARCH);
					ComSetObjValue(formObj.io_bnd_cd, ComGetObjValue(formObj.bound));
			    	ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, ComGetObjValue(formObj.type));
			    	ComSetObjValue(formObj.cvrg_cnt_cd, ComTrim(comboObjects[1].Text));
			    	ComSetObjValue(formObj.cvrg_rgn_ste_cd, ComTrim(comboObjects[2].Text));
			    	ComSetObjValue(formObj.cvrg_loc_cd, ComTrim(ComGetObjValue(formObj.cvrg_location)));
					
					//2.조회전 결과필드들을 Empty 시킨다.
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
	
					//3.조회조건으로 조회실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
					
		            sheetObj.DoSearch("EES_DMT_2015GS.do", FormQueryString(formObj));
		            
		            //*********************************************************************************
		            ComOpenWait(false);
		            //*********************************************************************************
		            
		            //4.데이터가 존재할 경우 
		            if (sheetObj.RowCount > 0) {
		            	//4-1.버튼의 상태를 활성화시킨다.
		            	ComBtnEnable("btn_Detail");		//Detail 버튼
		        		ComBtnEnable("btn_DownExcel");	//Down Excel 버튼
		            }
		            //5.데이터가 없을 경우
		            else {
		            	//5-1.버튼의 상태를 비활성화시킨다.
		            	ComBtnDisable("btn_Detail");			//Detail 버튼
		            	ComBtnDisable("btn_DownExcel");			//Down Excel 버튼
		            	ComBtnDisable("btn_MainDownExcel");		//Down Excel 버튼
		            }
				}
				break;
				
        	//Dual Type Exception Applied 조회
			case IBSEARCH_APPLIED:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				var sheetObj1 = sheetObjects[0];

				with(sheetObj1) {
					ComSetObjValue(formObj.intg_cd_id, 				"CD01969");
					ComSetObjValue(formObj.cust_cd, 				CellValue(SelectRow, CUST_CD));
					ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, 	CellValue(SelectRow, TYPE));
					ComSetObjValue(formObj.eff_dt, 					CellValue(SelectRow, EFF_DT));
					ComSetObjValue(formObj.exp_dt, 					CellValue(SelectRow, EXP_DT));
					ComSetObjValue(formObj.io_bnd_cd, 				CellValue(SelectRow, BOUND));
					ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, 	CellValue(SelectRow, CNTRCGO));
					ComSetObjValue(formObj.prop_no, 				CellValue(SelectRow, PROP_NO));
				
					//SET COVERAGE
					var cntCd = ComTrim(CellValue(SelectRow, CVRG_CNT));
					ComSetObjValue(formObj.cnt_cd, cntCd);
					
					if (cntCd == "CA" || cntCd == "US") {
						ComSetObjValue(formObj.ste_cd, ComTrim(CellValue(SelectRow, CVRG_RGN)));
						ComSetObjValue(formObj.rgn_cd, ""); 
					}
					else {
						ComSetObjValue(formObj.rgn_cd, ComTrim(CellValue(SelectRow, CVRG_RGN)));
						ComSetObjValue(formObj.ste_cd, "");
					}
					ComSetObjValue(formObj.loc_cd, ComTrim(CellValue(SelectRow, CVRG_LOC)));
					//END
				}
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				
				//2.조회전 결과필드들을 Empty 시킨다.
				sheetObj.RemoveAll();

				//3.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2015GS.do", FormQueryString(formObj));
				
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchXml(sXml);
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************				
				
	            //4.데이터가 존재할 경우 
	            if (sheetObj.RowCount > 0) {
	            	//4-1.버튼의 상태를 활성화시킨다.
	            	ComBtnEnable("btn_MainDownExcel");		//Main Down Excel 버튼
	            }
	            //5.데이터가 없을 경우
	            else {
	            	//5-1.버튼의 상태를 비활성화시킨다.
	            	ComBtnDisable("btn_MainDownExcel");		//Main Down Excel 버튼
	            }				
				break;
        }
    }

	// 조회조건필드인 Country, Region Combo 데이터 조회
    function doActionIBCommon(sheetObj,formObj,sAction,sComboAction,sComboField) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
	    switch(sAction) {

	       //Dual Type Exception 에 등록된 Customer 조회
	    	case IBSEARCH_CUST:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2014GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var comboObj = comboObjects[0];
				var comboItems = ComGetEtcData(sXml, "CUSTCODE").split(ROWMARK);
				addComboItem(comboObj,comboItems);
                break;
                
            //S/C, RFA CNTR/Cargo Type 을 조회한다.
	    	case IBSEARCH_CNTRCGO:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.intg_cd_id, "CD01969");
				
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
	    	    if (sComboAction == SEARCH11) {
	    	    	rfaCNTRCargoType = ComGetEtcData(sXml, "CONTR_CGO");
	    	    	rfaCNTRCargoType = rfaCNTRCargoType.replace("All=All^All|", "");
	    	    }
	    	    else if (sComboAction == SEARCH15) {
	    	    	sCCNTRCargoType = ComGetEtcData(sXml, "COMMON_CD");
	    	    } 
	    		break;
	    		
    	    //Type(S/C, Before) 를 조회한다.
	    	case IBSEARCH_TYPE:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.intg_cd_id, "CD01970");
				
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
				var comboDatas = ComGetEtcData(sXml, "COMMON_CD");
				if (comboDatas != undefined) {
					addCellComboItem(sheetObj,comboDatas,sComboField,false,true);
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
						comboDatas = ComGetEtcData(sXml, "RGN");
						addCellComboItem(sheetObj,comboDatas,sComboField,false);
						break;
					
					//3-2.Country 조회(모든 Country 목록)
					case SEARCH02:
						comboDatas = ComGetEtcData(sXml, "CNT");
						addCellComboItem(sheetObj,comboDatas,sComboField,false);
						break;
				}
		}	    	    
	    sheetObj.WaitImageVisible = true;
    }		
    
	// 조회조건필드인 Country, Region Combo 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {
			case IBSEARCH:      // 조회

				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				setParameters(sComboAction);
				
				//2.조회조건으로 조회실행
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//3.조회후 결과처리
				var comboDatas;
				var comboItems;
				var comboItem;
				switch(sComboAction) {
					
					//3-1.Region 조회(모든 Region 목록)
					case SEARCH01:
						comboItems = ComGetEtcData(sXml, REGION).split(ROWMARK);
						comboObjects[2].RemoveAll();
						addComboItem(comboObjects[2],comboItems);						
						break;
					
					//3-2.Country 조회(모든 Country 목록)
					case SEARCH02:
						comboItems = ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
						comboObjects[1].RemoveAll();
						addComboItem(comboObjects[1],comboItems);						
						break;
												
					//3-3.Country 항목 선택에 따른 해당 Region 조회
					case SEARCH03:
						//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
						if (comboObjects[1].Text == "CA" || comboObjects[1].Text == "US") {
							comboDatas = ComGetEtcData(sXml, STATE);
						} else {
							comboDatas = ComGetEtcData(sXml, REGION);
						}
						if (comboDatas != undefined) {
							//Region 콤보 Empty 상태로 초기화
							comboObjects[2].RemoveAll();									
							comboItems = comboDatas.split(ROWMARK);
							addComboItem(comboObjects[2],comboItems);	
						}			
						break;
												
					//3-4.Location 항목 입력에 따른 상위 Country, Region 조회
					case SEARCH04:
						//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
						comboDatas = ComGetEtcData(sXml, COUNTRY);
						if (comboDatas != undefined) {
							comboItems = comboDatas.split(ROWMARK);
							setComboItem(comboObjects[1],comboItems);
						}
						//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
						var locCd = ComTrim(ComGetObjValue(formObj.cvrg_location)).substring(0, 2);
						if (locCd == "CA" || locCd == "US") {
							comboDatas = ComGetEtcData(sXml, STATE);
						} else {
							comboDatas = ComGetEtcData(sXml, REGION);
						}
						if (comboDatas != undefined) {
							comboItems = comboDatas.split(ROWMARK);
							setComboItem(comboObjects[2],comboItems);
						} else {
							ComShowCodeMessage("DMT00110", "Location");
							ComClearObject(formObj.cvrg_location);
							ComSetFocus(formObj.cvrg_location);
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
							setComboItem(comboObjects[1],comboItems);
							
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							if (comboObjects[1].Text == "US" || comboObjects[1].Text == "CA") {
								comboDatas = ComGetEtcData(sXml, STATE);
							}
							else {
								comboDatas = ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[2],comboItems);
							}							
						}
						else {
							ComShowCodeMessage("DMT00110", "Region");
							comboObjects[2].Text = "";
						}
						break;					
				}			
                break;
        }
		sheetObj.WaitImageVisible = true;
    }
    
    /*
	 * Country 조회필드가 변경될 경우 그 소속의 Region or State 정보를 조회해주는 함수
	 */		
	function cboCountry_OnChange(comboObj, Index_Code, Text) {
		var formObj 	= document.form;
		var sheetObj	= sheetObjects[0];			
		var cntCd 		= comboObj.Text;
		
		//Country 이 변경될 경우 Location 정보를 지운다.
		if (isClearLocation) clearLocation();

		//Country 가 Empty 라면 모든 Region 정보를 조회한다.
		if (cntCd.length == 0) {
			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
			return;	
		}	
		
		//Region Caption 을 Country Code 에 따라서 변경해 준다.
		switch(cntCd) {
			case "CA":
			case "US":
				Region.innerHTML = "State";
				break;
				
			default:
				Region.innerHTML = "Region";
		}
		
		//Country 에 소속된 하위 Regino or State 정보를 조회한다.
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH03);
		
	}

	/*
	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function cboRegion_OnChange(comboObj, Index_Code, Text) {
		var formObj 	= document.form;
		var sheetObj 	= sheetObjects[0];
		var rgnCd 		= comboObj.Text;
		
		switch(rgnCd.length) {
			case 2: //State Code 로 상위 코드를 찾는다.
				ComSetObjValue(formObj.ste_cd, rgnCd);
				ComSetObjValue(formObj.rgn_cd, rgnCd);
				doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17);
				break;
				
			case 3:	//Region Code 로 상위 코드를 찾는다.
				ComSetObjValue(formObj.rgn_cd, rgnCd);
				doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13);
				break;
		}
		
		//Region 이 변경될 경우 Location 정보를 지운다.
		if (isClearLocation) clearLocation();
	}
	
	//멀티콤보 클릭 이벤트
	function cboCNTRCGO_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	}
	
	/*
	 * Location 조회필드에서 Enter Key 가 입력될 경우 Location 을 포함하는 Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation() {
		var formObj = document.form;
    	if (ComTrim(ComGetObjValue(formObj.cvrg_location)).length == 5) {
			var locCd = ComTrim(ComGetObjValue(formObj.cvrg_location));
    		if (locCd.length == 5) {
				isClearLocation = false;
				//Location 상위(Country, Region or State) 정보를 조회한다.
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH04);
				isClearLocation = true;
			}
    	}		
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
    * 그리드내 콤보필드에 데이터를 추가해준다.
    */		
	function addCellComboItem(sheetObj, comboDatas, sComboKey, isCellCombo, isOnlyTextView) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
		var comboInitTxt = "";
		var comboInitVal = "";
		
		if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
			comboItems = comboDatas.split(ROWMARK);
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
				
				//InitDataCombo 메소드를 태울 경우 선택값을 주지 않을 경우
				//Code, Value 가 콤보에 나타나 글자가 밀리는 현상을 방지하기 위함.
				if (!isCellCombo && i == 0) {
					comboInitTxt = comboItem[0];
					comboInitVal = comboItem[0];
				}
				
				if (ComTrim(comboItem[0]) != "") {
					//Text 만 보여줘야 할 때
					if (isOnlyTextView) {
						comboTxt += comboItem[1];
					}
					//Text 가 '^' 을 구분자로 해서 내려올 때
					else if (comboItem[1].indexOf("\^") != -1) {
						comboTxt += comboItem[1].replace("^", " - ");
					}
					//Text 와 Code 를 둘 다 보여줘야 할 때
					else {
						comboTxt += comboItem[0] + "\t" + comboItem[1];
					}
					comboVal += comboItem[0];
				}
				else {
					comboTxt += " \t ";
					comboVal += " ";
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
		else {
			comboTxt += " \t ";
			comboVal += " ";			
		}
		
		var colName = sComboKey;
		
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
			sheetObj.CellValue2(sRow,colName) = "";
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal,comboInitTxt,comboInitVal);
		}
    }
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	 
     	//조회할 경우 필수입력항목 체크
     	if (sAction == IBSEARCH) {
     		var effFmDt = ComTrim(ComGetObjValue(formObj.effFmDt));
     		var effToDt = ComTrim(ComGetObjValue(formObj.effToDt));

     		if (effFmDt == "" && effToDt != "") {
     			ComShowCodeMessage("DMT03028", "Effective Date");
     			ComSetFocus(formObj.effFmDt);
     			return false;
     		}
     		else if (effFmDt != "" && effToDt == "") {
     			ComShowCodeMessage("DMT03028", "Effective Date");
     			ComSetFocus(formObj.effToDt);	
     			return false;
     		}
     		else if (effFmDt != "" && effToDt != "" && ComGetDaysBetween(effToDt, effFmDt) > 0) {
    			ComShowCodeMessage("COM12133", "'Effective To Date'", "'Effective From Date'", "earlier");
    			ComSetFocus(formObj.effFmDt);
    			return false;	    			
    		}     		
     	}
     	return true;
    }

   /**
 	* 정렬시 현재 선택되어진 ROW 의 선택상태를 계속 유지하도록 처리해주는 함수
 	*/	
 	function sheet1_OnSort(sheetObj, Col, SortArrow) {
 		
 		with(sheetObj) {
 			for (var row = HeaderRows ; row <= LastRow ; row++) {
 				if (currCustCd == CellValue(row, CUST_CD) && currCustSeq == CellValue(row, CUST_SEQ)) {
 					SelectRow = row;
 					break;
 				}
 			}
 		}
 	}     
     
     
    /**
 	 * Row 가 선택될 때 조건별 Row 상태를 변경한다.
 	 */	
 	function sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
 		var formObj = document.form;
 		var sheetObj2 = sheetObjects[1];
 		
 		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
 		if (OldRow >= sheetObj.HeaderRows && OldRow != NewRow) {
 			sheetObj2.RemoveAll();
 			
			//--------------------------------------------------------------
			currCustCd  = sheetObj.CellValue(sheetObj.SelectRow, CUST_CD);
			currCustSeq = sheetObj.CellValue(sheetObj.SelectRow, CUST_SEQ);
			//--------------------------------------------------------------
 		}
    }
       
   /**
    * Row 선택이 더블클릭될 경우 해당 Dual Type Exception Applied 를 조회한다.
    */	
    function sheet1_OnDblClick(sheetObj,Row,Col) {
    	
    	doActionDetail();
    }
 	 
 	/**
 	 * BOUND 필드에 선택되어진 값에 따라서 Coverage CN 필드에 MouseOver 할 경우 툴팁을 보여준다.
 	 */	
 	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
 		with(sheetObj) {
 			if (MouseRow >= HeaderRows && MouseRow <= LastRow) {
 				var colName = ColSaveName(MouseCol);
 				if (colName == CVRG_CNT || colName == CVRG_RGN || colName == CVRG_LOC) {
 					//Bound 가 'O' 일 경우 말풍선 'BKG POR', 'I' 일 경우 말풍선 'BKG DEL'

 					switch(CellValue(MouseRow, BOUND)) {
 						case "O": MouseToolTipText = "BKG POR"; break;
 						case "I": MouseToolTipText = "BKG DEL"; break;
 						default: MouseToolTipText = "";
 					}
 				}
 				else if (colName == REMARK) {
 					MouseToolTipText = CellValue(MouseRow, REMARK);
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
 	 * Effective From Date 가 변경될 경우 To Date 는 자동으로 +1년으로 설정된다.
 	 */	
 	function setEffectiveToDate() {
  		var formObj = document.form;
  		var effFmDt = ComTrim(ComGetObjValue(formObj.effFmDt));
  		var effToDt = "";
  		
  		if (ComIsDate(effFmDt)) {
  			effToDt = ComGetDateAdd(effFmDt, "Y", 1);
  			effToDt = ComGetDateAdd(effToDt, "D", -1);
  			ComSetObjValue(formObj.effToDt, effToDt);
  		}
 	}
		
	/**
	 * Customer Code 를 변경하면 해당 Customer Name 을 자동으로 입력해준다.
	 */	
//	function combo1_OnChange(comboObj, Index_Code, Text) {
//	 	var formObj = document.form;
//
//	 	if (Text == "") {
//	 		ComClearObject(formObj.custNm);
//	 	}
//	 	else if (Text.length != 8) {
//	 		comboObj.Text = fetchLeftPadding(Text);
//	 	}
//	 	ComSetObjValue(formObj.custNm, comboObj.Code);
//	}
	
	function combo1_OnBlur() {
		var formObj = document.form;
		var cboCustomerObj 	= comboObjects[0];
		var txt = cboCustomerObj.Code;
		if (txt == "") {
	 		ComClearObject(formObj.custNm);
	 	} else {
	 		cboCustomerObj.Text = fetchLeftPadding(txt); 
	 	}
		ComSetObjValue(formObj.custNm, cboCustomerObj.Code);
	}
	 
   /**
	* Retrieve 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	* Dual Type Exception 정보를 조회하는 Action
	*/	 
    function doActionRetrieve() {
    	var formObj 		= document.form;
    	var sheetObj 		= sheetObjects[0];
    	var cboCustomerObj 	= comboObjects[0];
    	
    	if(comboObjects[3].Code.indexOf('All') == -1) {
    		ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, comboObjects[3].Code);
    	}else{
    		ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, '');
    	}
    	
		if (validateForm(sheetObj, formObj, IBSEARCH)) {
			
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			
			//--------------------------------------------------------------
			currCustCd  = sheetObj.CellValue(sheetObj.SelectRow, CUST_CD);
			currCustSeq = sheetObj.CellValue(sheetObj.SelectRow, CUST_SEQ);
			//--------------------------------------------------------------
		}
    }
    
   /**
	* Detail 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	* Dual Type Exception Applied 정보를 조회하는 Action
	*/	 
    function doActionDetail() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	with(sheetObj) {
	    	if (CellValue(SelectRow, STATUS) == "Deleted") {
	    		ComShowCodeMessage("DMT00179");
	    		return
	    	}
	    	
	    	//조회 수행 시 S/C, RFA 에 따라서 보여주거나 감춰야 할 필드에 대한 처리를 수행한다.
	    	showColumnsByType(CellValue(SelectRow, TYPE));
    	}
    	
		//Dual Type Exception Applied 조회를 수행한다.
    	doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_APPLIED);
    }
    
   /**
	* New 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	*/	 
    function doActionNew() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	var cboCustomerObj = comboObjects[0];
    	
		with(formObj) {
			ComEnableManyObjects(true, effFmDt, effToDt, status);
			effFmDt.className = "input";
			effToDt.className = "input";
			status.className = "input";
			
			ComClearObject(effFmDt);
			ComClearObject(effToDt);
			ComClearObject(custNm);
			ComSetObjValue(prop_no, "");
			ComSetObjValue(status, "");
			ComSetObjValue(type, "");
			ComSetObjValue(bound, "");
		}	    	
		
		for(var i in comboObjects) {
			comboObjects[i].Enable = true;
			comboObjects[i].Text = "";
			if(i==3) {
				makeCntrCgoCombo(comboObjects[i], 'All');
				
				
//				var comboItems = [];
//				comboItems.push('All=All');
//				addComboItem2(comboObjects[3],comboItems);
//				var items = sCCNTRCargoType.split(ROWMARK);
//				for(var i in items) {
//					comboItems.push(items[i]);
//				}
//				addComboItem2(comboObjects[3],comboItems,'[S/C]');
//				
//				items = rfaCNTRCargoType.split(ROWMARK);
//				for(var i in items) {
//					comboItems.push(items[i]);
//				}
//				addComboItem2(comboObjects[3],comboItems,'[RFA]');
//				
//				for (var i = 0 ; i < comboItems.length ; i++) {
//		    		var comboItem = comboItems[i].split(FIELDMARK);
//		    		comboObjects[3].CheckIndex(i) = true; 
//		    	}
			}
		}
    }	 
	
   /**
	* Down Excel 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	*/	 
    function doActionDownExcel(sheetObj) {

		sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, DEL_CHK);
    }
    
   /**
	* 조회시 S/C, RFA 에 따라서 보여주는 컬럼이 달라지도록 처리해주는 함수
	*/	
	function showColumnsByType(searchType) {
		var sheetObj2 = sheetObjects[1];
		
		with(sheetObj2) {
			//1.S/C 조회시
			if (searchType == "S") {
				ColHidden(SC_NO) = false;
				ColHidden(RFA_NO) = true;
				ColHidden(DAR_NO) = true;
				ColHidden(APVL_NO) = true;
			}
			//2.Before Booking 조회시
			else if (searchType == "B") {
				ColHidden(SC_NO) = true;
				ColHidden(RFA_NO) = false;
				ColHidden(DAR_NO) = false;
				ColHidden(APVL_NO) = false;				
			}
		}
	}
	
	   /**
 	* Customer Code 를 8 자리에 맞춰서 반환시켜주는 함수 
 	*/	
    function fetchLeftPadding(custCd) {
    	var result = custCd;
    	
    	if (custCd != "" && custCd.length > 2) {
			var custCnt = custCd.substring(0,2);
			var custSeq = custCd.substring(2);
	
			switch(custSeq.length) {
				case 1: custSeq = "00000" + custSeq;
					break;
				case 2: custSeq = "0000" + custSeq;
					break;
				case 3: custSeq = "000" + custSeq;
					break;
				case 4: custSeq = "00" + custSeq;
					break;
				case 5: custSeq = "0" + custSeq;
					break;
			}
			result = custCnt + custSeq;
    	}
    	return result;
    }
    
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		
		ComSetObjValue(formObj.cnt_cd, comboObjects[1].Text);				//Country
		ComSetObjValue(formObj.rgn_cd, comboObjects[2].Text);
		ComSetObjValue(formObj.ste_cd, comboObjects[2].Text);
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.cvrg_location));	//Location	
		
		ComSetObjValue(formObj.f_cmd, sAction);								//Command
	}
	
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
	function clearLocation() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.cvrg_location, "");
	}
	
	/**
	 * CNTR, Cargo Type 콤보 박스 - 콤보 아이템을 Exception Type에 맞게 리스트를 생성
	 * @param comboObj 콤보객체
	 * @param type ('S':SC, 'B':Before(RFA), 그외:All)
	 */
	function makeCntrCgoCombo(comboObj, type) {
		
		comboObj.removeAll();
		
		var comboIdx = 0;
		// 첫번째 All 등록
		var data = 'All=All';				
		// SC
		if(type == 'S') {	
			var scArr = sCCNTRCargoType.split(ROWMARK);
			for(var i in scArr) {
				data += (ROWMARK + ComReplaceStr(scArr[i],"^"," - "));
			}
		// Before
		}else if(type == 'B') {
			var rfaArr = rfaCNTRCargoType.split(ROWMARK);
			for(var i in rfaArr) {
				data += (ROWMARK + ComReplaceStr(rfaArr[i],"^"," - "));
			}
		// All
		} else {
			var scArr = sCCNTRCargoType.split(ROWMARK);
			for(var i in scArr) {
				var comboItem = scArr[i].split(FIELDMARK);
				data += (ROWMARK + comboItem[0] + FIELDMARK + '[S/C] ' + ComReplaceStr(comboItem[1],"^"," - "));
			}
			var rfaArr = rfaCNTRCargoType.split(ROWMARK);
			for(var i in rfaArr) {
				var comboItem = rfaArr[i].split(FIELDMARK);
				data += (ROWMARK  + comboItem[0] + FIELDMARK + '[RFA] ' + ComReplaceStr(comboItem[1],"^"," - "));
			}		
		}
		var dataArr = data.split(ROWMARK);
		
		for(var i in dataArr) {
			var comboItem = dataArr[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[1] , comboItem[0]);
			comboObj.CheckIndex(i) = true;
		}
	}
    
    
	/* 개발자 작업  끝 */	