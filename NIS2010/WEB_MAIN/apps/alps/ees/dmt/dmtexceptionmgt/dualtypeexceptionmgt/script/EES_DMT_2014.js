/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2014.js
*@FileTitle : Dual Type Exception Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.08.17 이성훈
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
* 2011.09.08 김현화 [CHM-201113290]CTIC 국가/Location에 대한 Dual Type Exception(DTE) 설정 금지 - checkDualCoverage 로직 보완.
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
    function EES_DMT_2014() {
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
	var sheetObjects 	= new Array();
	var sheetCnt 		= 0;

	var comboObjects 	= new Array();
	var comboCnt 		= 0;	
	
	//Action 정의
	var IBSEARCH_CUST 			= 101;
	var IBSEARCH_CVRG 			= 102;
	var IBSEARCH_DUAL_CUST 		= 103;
	var IBSEARCH_CNTRCGO 		= 104;
	var IBSEARCH_TYPE 			= 105;
	var IBSEARCH_DUAL_CVRG 		= 106;
	var IBSEARCH_DEL_CUST 		= 107;
	var IBSEARCH_CUSTNM 		= 108;
	var IBSEARCH_CHECK_EXPDT 	= 109;
	var IBSEARCH_CHECK_DUP 		= 110;
	
	//DATA 구분자 정의
	var ROWMARK 		= "|";
	var FIELDMARK 		= "=";
	
	//업무전역변수
	var COUNTRY 		= "CNT";
	var REGION 			= "RGN";
	var STATE 			= "STE";
	var LOCATION 		= "LOC";
	var CNTR_CARGE		= "CONTR_CGO";
	
	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation = true;
	
	var DEL_CHK 		= "del_chk";
	var STATUS 			= "dul_expt_delt_desc";
	var CUST_CD 		= "cust_cd";
	var CUST_NM 		= "cust_nm";
	var TYPE 			= "dmdt_ctrt_expt_tp_cd";
	var EFF_DT 			= "dul_expt_eff_dt";
	var EXP_DT 			= "dul_expt_exp_dt";
	var BOUND 			= "io_bnd_cd";
	var CVRG_CNT 		= "cvrg_cnt_cd";
	var CVRG_RGN 		= "cvrg_rgn_ste_cd";
	var CVRG_LOC 		= "cvrg_loc_cd";
	var CNTRCGO 		= "dmdt_cntr_cgo_tp_cd";
	var REMARK 			= "dul_expt_rmk";
	var UPD_OFC 		= "upd_ofc_cd";
	var UPD_USR_NM 		= "upd_usr_nm";
	var UPD_DT 			= "upd_dt";
	var DELT_FLG 		= "dul_expt_delt_flg";
	var CUST_CNT_CD 	= "cust_cnt_cd";
	var CUST_SEQ 		= "cust_seq";
	var CUST_EXPT_SEQ 	= "cust_expt_seq";
	var EXP_FLG 		= "exp_flg";

	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation = true;

	//발생된 OnChange 이벤트가 화면상에서 이루어진것이 아닐경우, 
	//즉 조회된 데이터로 각 콤보필드를 설정해줄때 발생된 것인지를 구분해주는 변수.(의도치 않은 행위를 막기 위해서 사용함)
	//이 변수의 설정은 Location 필드에서 한다.
	var isValueSettingEvent = false;
	
	//Type(SC, Before) 에 따라서 CNTR/Cargo Type 이 다르게 나타나야 한다.
	//페이지 로드시점에 Type 에 따른 CNTR/Cargo Type 을 조회해서 전역변수에 저장해 놓고, Type 변경시 해당 정보를 보여주도록 처리하기 위함 
	var sCCNTRCargoType 	= "";
	var rfaCNTRCargoType 	= "";
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
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
							
				case "btn_AddDualType":
					if (ComIsBtnEnable("btn_AddDualType")) 
						doActionAddDualType();
					break;
				
				case "btn_CopyDualType":
					if (ComIsBtnEnable("btn_CopyDualType")) 
						doActionCopyDualType();
					break;
				
				case "btn_DelDualType":
					if (ComIsBtnEnable("btn_DelDualType"))
						doActionDelDualType();
					break;
				
				case "btn_ExpireDualType":
					if (ComIsBtnEnable("btn_ExpireDualType"))
						doActionExpireDualType();
					break;
				
				case "btn_DownExcel":
					if (ComIsBtnEnable("btn_DownExcel"))
						doActionDownExcel();
					break;
				
				case "btn_Retrieve":
					if (ComIsBtnEnable("btn_Retrieve")) 
						doActionRetrieve();
					break;
				
				case "btn_New":
					if (ComIsBtnEnable("btn_New")) 
						doActionNew();
					break;
				
				case "btn_Save":
					if (ComIsBtnEnable("btn_Save"))
						doActionSave();
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
            ComConfigSheet (sheetObjects[i] );

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
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH02,CVRG_CNT,false);
		
		//Region 조회 후 콤보에 조회된 결과 설정
	 	//Coverage 의 Region 필드에 적용됨
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH01,CVRG_RGN,false);
		
   		//S/C CNTR/CGO 조회 후 전역변수에 저장
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CNTRCGO,SEARCH15,CNTRCGO);

   		//RFA(Before Booking Request) CNTR/CGO 조회 후 전역변수에 저장
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CNTRCGO,SEARCH11,CNTRCGO); 	
		
		//전체 Country 정보 조회 후 콤보에 설정
  		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
  		
  		//전체 Region 정보 조회 후 콤보에 설정
  		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
  		
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

        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 420;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 8, 100);

                    var HeadTitle1 = "||Seq.|Status|Customer|Customer|Type|PROP No|EFF DT|EXP DT|Bound|Coverage|Coverage|Coverage|CNTR/Cargo Type|Remark|Update|Update|Update";
                    var HeadTitle2 = "||Seq.|Status|Code|Name|Type|PROP No|EFF DT|EXP DT|Bound|CN|RGN|LOC|CNTR/Cargo Type|Remark|Office|Name|Date";
                    var headCount = ComCountHeadTitle(HeadTitle2) + 5;
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)     
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	 30,    	daCenter,   	true,   "ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,			 30,		daCenter,		true,	DEL_CHK,		false,	"",		dfNone,			0,	true,		true);					
                    InitDataProperty(0, cnt++ , dtSeq,    			 35,    	daCenter,   	true,   "Seq"); 
					InitDataProperty(0, cnt++ , dtData,   			 60,		daCenter,		true,	STATUS,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtPopupEdit, 		 80,		daCenter,		true,	CUST_CD,  		true,	"",		dfNone,		0,	false,		true,	8);
					InitDataProperty(0, cnt++ , dtData,   			 180,		daLeft,			true,	CUST_NM,  		true,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtCombo,   			 90,		daCenter,		true,	TYPE,  			true,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   			 90,		daCenter,		true,	"prop_no",  	true,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   			 80,		daCenter,		true,	EFF_DT,  		true,	"",		dfDateYmd,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   			 80,		daCenter,		true,	EXP_DT,  		false,	"",		dfDateYmd,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtCombo,   			 80,		daCenter,		true,	BOUND,  		true,	"",		dfNone,		0,	false,		true);
                                        		                                       
					InitDataProperty(0, cnt++ , dtComboEdit,   		 50,		daCenter,		true,	CVRG_CNT,  		true,	"",		dfEngUpKey,		0,	false,		true,	2);
					InitDataProperty(0, cnt++ , dtComboEdit,   		 50,		daCenter,		true,	CVRG_RGN,  		false,	"",		dfEngUpKey,		0,	false,		true,	3);
					InitDataProperty(0, cnt++ , dtData,   			 60,		daCenter,		true,	CVRG_LOC,  		false,	"",		dfEngUpKey,		0,	false,		true,	5);
					InitDataProperty(0, cnt++ , dtCombo,   			 110,		daLeft,			true,	CNTRCGO,  		false,	"",		dfNone,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   			 200,		daLeft,			true,	REMARK,  		false,	"",		dfNone,			0,	false,		true,	200);
                                                                                   
					InitDataProperty(0, cnt++ , dtData,   			 75,		daCenter,		true,	UPD_OFC,		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   			 120,		daLeft,			true,	UPD_USR_NM,  	false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   			 80,		daCenter,		true,	UPD_DT,  		false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,	CUST_EXPT_SEQ,  false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,	EXP_FLG,  		false,	"",		dfNone,			0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,	DELT_FLG,  		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,	CUST_CNT_CD,  	false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,	CUST_SEQ,  		false,	"",		dfNone,			0,	false,		false);
					
					
					InitDataCombo(0, TYPE, "", "");
					InitDataCombo(0, BOUND, " |Inbound|Outbound", " |I|O");
					InitDataCombo(0, CVRG_CNT, "", "");
					InitDataCombo(0, CVRG_RGN, "", "");
					InitDataCombo(0, CNTRCGO, "", "");
					
		            //영문 대문자만 입력되도록 설정=================================
		            InitDataValid(0, CVRG_LOC,  vtEngUpOther, "0123456789");
		            InitDataValid(0, CUST_CD,   vtEngUpOther, "0123456789");
		            InitDataValid(0, "prop_no",   vtEngUpOther, "0123456789");
		            //==========================================================
																																									
					ShowButtonImage = 2;	
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(TYPE);					
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
		ComBtnEnable("btn_AddDualType");		//Row Add 버튼
		ComBtnDisable("btn_CopyDualType");		//Row Copy 버튼
		ComBtnDisable("btn_DelDualType");		//Delete 버튼
		ComBtnDisable("btn_ExpireDualType");	//Expire 버튼
		
		ComBtnEnable("btn_Retrieve");			//Retrieve 버튼
		ComBtnEnable("btn_New");				//New 버튼
		ComBtnEnable("btn_Save");				//Save 버튼
		ComBtnDisable("btn_DownExcel");			//Down Excel 버튼
	}	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	//Dual Type Exception 조회
			case IBSEARCH:
				if (validateForm(sheetObj,formObj,sAction)) {
					
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					var cboCustomerObj = comboObjects[0];
					var custCd = ComTrim(cboCustomerObj.Text);
					if (custCd.length > 2) {
						ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0,2));
						ComSetObjValue(formObj.cust_seq, custCd.substring(2));

						cboCustomerObj.Text = fetchLeftPadding(custCd);
					} 
					else {
						ComSetObjValue(formObj.cust_cnt_cd, "");
						ComSetObjValue(formObj.cust_seq, "");		
					}
					ComSetObjValue(formObj.dul_expt_eff_dt, 	ComGetUnMaskedValue(ComGetObjValue(formObj.effFmDt), "ymd"));
					ComSetObjValue(formObj.dul_expt_exp_dt, 	ComGetUnMaskedValue(ComGetObjValue(formObj.effToDt), "ymd"));
					ComSetObjValue(formObj.dul_expt_delt_flg, 	ComGetObjValue(formObj.status));
					ComSetObjValue(formObj.f_cmd, SEARCH);
					ComSetObjValue(formObj.io_bnd_cd, ComGetObjValue(formObj.bound));
			    	ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, ComGetObjValue(formObj.type));
			    	ComSetObjValue(formObj.cvrg_cnt_cd, ComTrim(comboObjects[1].Text));
			    	ComSetObjValue(formObj.cvrg_rgn_ste_cd, ComTrim(comboObjects[2].Text));
			    	ComSetObjValue(formObj.cvrg_loc_cd, ComTrim(ComGetObjValue(formObj.cvrg_location)));
					
					//2.조회전 결과필드들을 Empty 시킨다.
					sheetObj.RemoveAll();
	
					//3.조회조건으로 조회실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
					
		            sheetObj.DoSearch("EES_DMT_2014GS.do", FormQueryString(formObj));
		            
		            //*********************************************************************************
		            ComOpenWait(false);
		            //*********************************************************************************
		            
		            //4.데이터가 존재할 경우 
		            if (sheetObj.RowCount > 0) {
		            	//4-1.버튼의 상태를 설정한다.
		        		ComBtnEnable("btn_CopyDualType");		//Row Copy 버튼
		        		ComBtnEnable("btn_DelDualType");		//Delete 버튼
		        		ComBtnEnable("btn_DownExcel");			//Down Excel 버튼		
		        		ComBtnEnable("btn_ExpireDualType");		//Expire 버튼
		            }
		            //5.데이터가 없을 경우
		            else {
		            	//5-1.버튼의 상태를 화면 로드되는 시점의 상태로 초기화 시킨다.
		            	initBtnControl();
		            }
				}
				break;
	
			
			//선택한 Customer 가 S/C, Before Booking Customer 인지 조회
			case IBSEARCH_DUAL_CUST:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				var custCd = sheetObjects[0].CellValue(sheetObj.SelectRow, CUST_CD);
				ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
				ComSetObjValue(formObj.cust_seq, custCd.substring(2));
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObjects[0].WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObjects[0].GetSearchXml("EES_DMT_2014GS.do", FormQueryString(formObj));
	            
	            //*********************************************************************************
	            ComOpenWait(false);
	            //*********************************************************************************
	            
				//3.조회후 결과처리
				var isSCCustomer = ComGetEtcData(sXml, "SC_CUST");
				var isBFCustomer = ComGetEtcData(sXml, "BF_CUST");
				
				if (isSCCustomer == "Y" && isBFCustomer == "Y") {
					sheetObj.CellValue(sheetObj.SelectRow, TYPE) = "";
					sheetObj.CellEditable(sheetObj.SelectRow, TYPE) = true;
				}
				if (isSCCustomer == "Y" && isBFCustomer == "N") {
					sheetObj.CellValue(sheetObj.SelectRow, TYPE) = "S";
					sheetObj.CellEditable(sheetObj.SelectRow, TYPE) = false;
				}
				if (isSCCustomer == "N" && isBFCustomer == "Y") {
					sheetObj.CellValue(sheetObj.SelectRow, TYPE) = "B";
					sheetObj.CellEditable(sheetObj.SelectRow, TYPE) = false;
				}				
				if (isSCCustomer == "N" && isBFCustomer == "N") {
					sheetObj.CellValue(sheetObj.SelectRow, TYPE) = "";
					sheetObj.CellEditable(sheetObj.SelectRow, TYPE) = false;
				}				
				break;
			
				
			//입력된 Coverage 가 Dual Coverage 인지를 체크한다.
			case IBSEARCH_DUAL_CVRG:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH03);
				
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
				var isDualCoverage = ComGetEtcData(sXml, "IS_DUALCVRG");
				ComSetObjValue(formObj.result, "");
				ComSetObjValue(formObj.result, isDualCoverage);
				break;
			
				
			//선택한 Dual Type Customer 정보가 삭제가능한지 체크한다.
			case IBSEARCH_DEL_CUST:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH04);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObjects[0].WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObjects[0].GetSearchXml("EES_DMT_2014GS.do", FormQueryString(formObj));
				
	            //*********************************************************************************
	            ComOpenWait(false);
	            //*********************************************************************************
	            
				//3.조회후 결과처리
				var result = ComGetEtcData(sXml, "DEL_CUST");
				ComSetObjValue(formObj.result, result);
				if (result != "Y") {
					ComSetObjValue(formObj.result_sc_no, ComGetEtcData(sXml, "SC_NO"));
					ComSetObjValue(formObj.result_dar_no, ComGetEtcData(sXml, "DAR_NO"));
				}
				else {
					ComSetObjValue(formObj.result_sc_no, "");
					ComSetObjValue(formObj.result_dar_no, "");
				}
				
				break;
				
			
			//EXP DT 의 유효성을 체크한다.(S/C, Before Booking 의  Expire Date 보다 작다면 에러)
			case IBSEARCH_CHECK_EXPDT:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH05);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObjects[0].WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObjects[0].GetSearchXml("EES_DMT_2014GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var result = ComGetEtcData(sXml, "RESULT");
				ComSetObjValue(formObj.result, result);
				if (result != "Y") {
					ComSetObjValue(formObj.result_sc_no, ComGetEtcData(sXml, "SC_NO"));
					ComSetObjValue(formObj.result_dar_no, ComGetEtcData(sXml, "DAR_NO"));
				}
				else {
					ComSetObjValue(formObj.result_sc_no, "");
					ComSetObjValue(formObj.result_dar_no, "");
				}				
				break;
				
			
			//입력된 DUAL TYPE EXCEPTION 의 DB 와의 중복여부를 체크한다.
			case IBSEARCH_CHECK_DUP:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH06);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObjects[0].WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObjects[0].GetSearchXml("EES_DMT_2014GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var result = ComGetEtcData(sXml, "RESULT");
				ComSetObjValue(formObj.result, result);
				if (result == "Y") {
					ComSetObjValue(formObj.result_dul_expt_eff_dt, ComGetEtcData(sXml, "DUL_EXPT_EFF_DT"));
					ComSetObjValue(formObj.result_dul_expt_exp_dt, ComGetEtcData(sXml, "DUL_EXPT_EXP_DT"));
				}
				else {
					ComSetObjValue(formObj.result_dul_expt_eff_dt, "");
					ComSetObjValue(formObj.result_dul_expt_exp_dt, "");					
				}
				break;
				
				
			case IBSAVE:
				//1.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, MULTI);
	
				var sParam = "";
				var sParam1 = sheetObjects[0].GetSaveString();
				if (sheetObj.IsDataModified == true) {
					sParam = sParam1 + "&";
				}
				sParam += "&" + FormQueryString(formObj);				
				
				//2.그리드를 통해서 입력받은 정보로 저장/수정/삭제 실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSaveXml("EES_DMT_2014GS.do", sParam);
					
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.저장 후 결과처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}

				break;
        }
    }
	
    /**
     * 조회를 위해서 필요한 매개변수를 설정해주는 함수
     */	
	function setCommonParameters(sheetObj,sComboAction) {
    	var formObj = document.form;
    	
    	//실행해야할 Action 을 정의하는 매개변수설정
		ComSetObjValue(formObj.f_cmd, sComboAction);
		
		switch(sComboAction) {
			//전체 Region 조회
			case SEARCH01 :
				break;
		
			//전체 Country 조회
			case SEARCH02 :
				break;
			
			//Country 에 포함된  Region 조회
			case SEARCH03:
				ComSetObjValue(formObj.cnt_cd, sheetObj.CellValue(sheetObj.SelectRow, CVRG_CNT));
				break;
				
			//Location 을 포함하는  상위 Country, Region 조회
			case SEARCH04:
				ComSetObjValue(formObj.loc_cd, sheetObj.CellValue(sheetObj.SelectRow, CVRG_LOC));
				break;

			//Region 을 포함하는 상위(Country) 정보를 조회한다.				
			case SEARCH13:
				//Region 을 포함하는  상위(Country) 정보를 조회한다.
				ComSetObjValue(formObj.rgn_cd, sheetObj.CellValue(sheetObj.SelectRow, CVRG_RGN));
				break;
				
			//State 을 포함하는 상위(Country) 정보를 조회한다.
			case SEARCH17:
				ComSetObjValue(formObj.ste_cd, sheetObj.CellValue(sheetObj.SelectRow, CVRG_RGN));
				break;
		}
	}
	
	// 조회조건필드인 Country, Region Combo 데이터 조회
    // 마지막 인자인 sInitCellCombo 는 화면 로드시 Coverage 정보를 설정할때 false 로 넣어주는 인자값, 없을 경우 기본값 true 로 설정
    function doActionIBCommon(sheetObj,formObj,sAction,sComboAction,sComboField,sInitCellCombo) {
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
				//3-1.조회된 결과를 콤보에 설정해주기 전에 기존 정보를 모두 삭제한다.
				comboObj.RemoveAll();
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
	    		
	    		
	    	case IBSEARCH_CUSTNM:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
	    		var custCd = sheetObj.CellValue(sheetObj.SelectRow, CUST_CD);
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
				ComSetObjValue(formObj.cust_seq, custCd.substring(2));
				
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
				var result = ComGetEtcData(sXml, "CUST_NM");
				if (result != undefined && result != "") {
					sheetObj.CellValue(sheetObj.SelectRow, sComboField) = result;
				}
				else {
					ComShowCodeMessage("DMT00165", "Customer Code");
					sheetObj.CellValue2(sheetObj.SelectRow, CUST_CD) = "";
					sheetObj.CellValue2(sheetObj.SelectRow, CUST_NM) = "";
				}
	    		break;

	    		
	    	case IBSEARCH_CVRG:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				setCommonParameters(sheetObj,sComboAction);
				
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

				//조회된 Coverage 정보를 loadPage 에서 호출할 경우와 그리드 내에서 선택으로 인해 호출할 경우 구분하기 위함.
				sInitCellCombo = sInitCellCombo == false ? false : true;
				
				switch(sComboAction) {
				
					//3-1.Region 조회(모든 Region 목록)
					case SEARCH01:
						comboDatas = ComGetEtcData(sXml, "RGN");
						addCellComboItem(sheetObj,comboDatas,sComboField,sInitCellCombo);
						break;
					
					//3-2.Country 조회(모든 Country 목록)
					case SEARCH02:
						comboDatas = ComGetEtcData(sXml, "CNT");
						addCellComboItem(sheetObj,comboDatas,sComboField,sInitCellCombo);
						break;
												
					//3-3.Country 항목 선택에 따른 해당 Region 조회
					case SEARCH03:
						sComboField = sComboField.split(ROWMARK);

						//응답 XML 에서 Region or State 정보를 추출해서 목록에 입력해준다.	
						var cntCd = sheetObj.CellValue(sheetObj.SelectRow, sComboField[0]);
						if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
							comboDatas = ComGetEtcData(sXml, "STE");
						} else {
							comboDatas = ComGetEtcData(sXml, "RGN");
						}
						
						//조회된 결과가 없을 경우 Error Message 를  보여주고 Empty 로 초기화시킨다.
						if (comboDatas == undefined || ComTrim(comboDatas) == "") {
							ComShowCodeMessage("DMT00110", "Country");
							sheetObj.CellValue(sheetObj.SelectRow, sComboField[0]) = "";
							return;
						} else {
							addCellComboItem(sheetObj,comboDatas,sComboField[1],true);
						}				
						break;						
												
					//3-4.Coverage LOC 상위 항목조회(입력한 LOC 에 해당되는 상위 CN, RGN 을 조회한다)
					case SEARCH04:
						sComboField = sComboField.split(ROWMARK);
						
						//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
						comboDatas = ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj,comboDatas,sComboField[0]);
							
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							var cntCd = ComTrim(sheetObj.CellValue(sheetObj.SelectRow, sComboField[0]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas = ComGetEtcData(sXml, "STE");
								} else {
									comboDatas = ComGetEtcData(sXml, "RGN");
								}
								setCellComboItem(sheetObj,comboDatas,sComboField[1]);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Location");
							sheetObj.CellValue2(sheetObj.SelectRow,sComboField[2]) = "";
						}
						break;
						
					//3-5.Region 항목코드로 상위(Country) 정보를 조회한다.
					case SEARCH13:	
						
					//3-6.State 항목코드로 상위(Country) 정보를 조회한다.
					case SEARCH17:
						sComboField = sComboField.split(ROWMARK);
						
						//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
						comboDatas = ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj,comboDatas,sComboField[1]);
							
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							var cntCd = ComTrim(sheetObj.CellValue(sheetObj.SelectRow, sComboField[1]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas = ComGetEtcData(sXml, "STE");
								} 
								else {
									comboDatas = ComGetEtcData(sXml, "RGN");
								}
								setCellComboItem(sheetObj,comboDatas,sComboField[2]);
							}
						
						}
						else {
							ComShowCodeMessage("DMT00110", "Region");
							sheetObj.CellValue2(sheetObj.SelectRow, sComboField[2]) = "";							
						}
						break;
				}	    	    
	    		break;               
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
      * 그리드내 콤보필드에 데이터를 선택해준다.
      */		
 	function setCellComboItem(sheetObj,comboDatas,sComboKey) {
 		var sRow = sheetObj.SelectRow;
 		var sVal = "";
 		if (comboDatas != undefined) {
 			var comboItem = comboDatas.split(FIELDMARK);
 			sVal = comboItem[0];
 		}
 		sheetObj.CellValue(sRow, sComboKey) = sVal;
 	}
 	
     /**
      * 그리드내 콤보필드에 데이터를 추가해준다.
      */		
 	function addCellComboItem(sheetObj,comboDatas,sComboKey,isCellCombo,isOnlyTextView) {
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
    	//저장할 경우 필수입력항목 체크
    	else if (sAction == IBSAVE) {
    		with(sheetObj) {
    			//저장할 데이터가 없을 경우
    			if (RowCount == 0) {
    				ComShowCodeMessage("DMT00128");
    				return false;
    			}
               
				//0.중복데이터 체크
				if (!dupValidate(sheetObj)) return false;

    			for (var row = HeaderRows ; row <= LastRow ; row++) {
    			
    				if (RowStatus(row) == "I" || RowStatus(row) == "U") {

    					//1.필수입력체크
	    				//1-1.Customer Code
	    				if (ComTrim(CellValue(row, CUST_CD)) == "") {
	    					ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "Customer Code");
	    					return false;
	    				}
	    			
	    				//1-2.Type
	    				if (ComTrim(CellValue(row, TYPE)) == "") {
	    					ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "Type");
	    					return false;
	    				}
	    				
	    				//1-3.EFF DT
	    				if (ComTrim(CellValue(row, EFF_DT)) == "") {
	    					ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "EFF DT");
	    					return false;
	    				}
	    				
	    				//1-4.EXP DT
	    				//Expire 버튼을 클릭한 ROW 라면 EXP DT 컬럼정보를 필수적으로 입력을 받는다.
	    				if (CellValue(row, EXP_FLG) == "Y" && ComTrim(CellValue(row, EXP_DT)) == "") {
	    					ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "EXP DT");
	    					return false;
	    				}
	    				
	    				//EXP DT 가 입력되었다면 EFF DT 이전 날짜인지 체크한다.
	    				if (ComTrim(CellValue(row, EXP_DT)) != "") {
	    					if (ComGetDaysBetween(ComTrim(CellValue(row, EXP_DT)), ComTrim(CellValue(row, EFF_DT))) > 0) {
	    		    			ComShowCodeMessage("COM12133", "'EFF DT'", "'EXP DT'", "earlier");
	    		    			return false;	    			
	    		    		}
	    					//신규 입력된 EXP DT 의 유효성을 체크한다.(S/C, Before Booking 에  EXP DT 를 초과하는 데이터가 있다면 'Error' 처리한다.)
	    					//2009-10-21(화) 
	    					else if (CellValue(row, STATUS) == "Live" && !checkExpireDate(row)) {
	    		    			return false;		    						
	    					}
	    				}
	    				
	    				//1-5.Bound(Type 이 Before 일 경우에만 필수입력) => S/C 에도 필수입력으로 변경(2009-10-27(화))
	    				if (ComTrim(CellValue(row, BOUND)) == "") {
	    					ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "Bound");
	    					return false;
	    				}
	    			
	    				//1-6.Coverage(Type 이 Before 일 경우에만 필수입력) => S/C 에도 필수입력으로 변경(2009-10-27(화))
	    				if (ComTrim(CellValue(row, CVRG_CNT)) == "") {
	    					ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "Coverage");
	    					return false;
	    				}
	    		
	    				//1-7.Coverage 가 Dual 인지 체크한다.
	    				//    2009-10-20(화) :: 신규입력건에 대해서만 Dual Type 을 Check 한다.
	
	    				if (RowStatus(row) == "I") {
	    					
		    				if (ComTrim(CellValue(row, CVRG_CNT)) != "") {
		    					if (!checkDualCoverage(row)) {
		    						return false;
		    					}
		    				}
	    				}
	    		
    				}
    			}
    		}
    	}
    	
		return true;
    }
	
   	/**
   	 * Dual Type Exception Inquiry 데이터 중복입력 체크
   	 */	      
   	 function dupValidate(sheetObj) {
         var formObj = document.form;
         
   		//중복체크로직
         var srcEffDt = "";
         var srcExpDt = "";
         var trgEffDt = "";
         var trgExpDt = "";

   		with(sheetObj) {
   			
   			//1.모든 신규  데이터에 대해서 DB 중복체크 여부를 확인한다.
   			for (var row = HeaderRows ; row <= LastRow ; row++) {
   				if (RowStatus(row) == "I") {
   					if (!dupValidateWithDB(row)) return false;
   				}
   			}
   			
   			//2.모든 신규 데이터에 대해서 화면 중복체크 여부를 확인한다.
 			for (var i = HeaderRows ; i <= LastRow - 1 ; i++) {
 				if (CellValue(i, STATUS) == "Deleted" || RowStatus(i) == "D") continue;
 				
 				srcEffDt = CellValue(i, EFF_DT) != "" ? CellValue(i, EFF_DT) : "99991231";
 				srcExpDt = CellValue(i, EXP_DT) != "" ? CellValue(i, EXP_DT) : "99991231";
 					
 				for (var j = i + 1 ; j <= LastRow ; j++) {
 					if (CellValue(j, STATUS) == "Deleted" || RowStatus(j) == "D") continue;
 					
 					trgEffDt = CellValue(j, EFF_DT) != "" ? CellValue(j, EFF_DT) : "99991231";
 					trgExpDt = CellValue(j, EXP_DT) != "" ? CellValue(j, EXP_DT) : "99991231";
 					
 					//중복체크 대상에 ORG/Dest., BKG POR/DEL, Actual Customer 항목추가함(장민지 대리요청으로 2009-08-16 일 추가함)						
 					if (	CellValue(i, CUST_CD) == CellValue(j, CUST_CD)
 						&& 	CellValue(i, TYPE) == CellValue(j, TYPE)
 						&& 	CellValue(i, BOUND) == CellValue(j, BOUND)
 						&& 	CellValue(i, CVRG_CNT) == CellValue(j, CVRG_CNT)
 						&& 	CellValue(i, CVRG_RGN) == CellValue(j, CVRG_RGN)
 						&& 	CellValue(i, CVRG_LOC) == CellValue(j, CVRG_LOC)
 						&& 	CellValue(i, CNTRCGO) == CellValue(j, CNTRCGO)
 						&& 	CellValue(i, "prop_no") == CellValue(j, "prop_no")		) {

 						//EFF DT, EXP DT 가 겹치는게 있는지 검사한다.(겹치면 중복 데이터)
 						if (	(	trgEffDt >= srcEffDt &&  trgEffDt <= srcExpDt	)
 							||	(	trgExpDt >= srcEffDt &&  trgExpDt <= srcExpDt	)
 							||	(	srcEffDt >= trgEffDt &&  srcEffDt <= trgExpDt	)									
 							||	(	srcExpDt >= trgEffDt &&  srcExpDt <= trgExpDt	)	) {

 							//==================================== 에러메시지 생성 ================================================================================
 							var dupAlertMsg = "\n\n";
 							dupAlertMsg += "Customer Code : [ " + CellValue(i, CUST_CD)+ " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "Type : [ " + CellText(i, TYPE) + " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "EFF DT : [ " + CellValue(i, EFF_DT) + " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "EXP DT : [ " + CellValue(i, EXP_DT) + " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "BOUND : [ " + CellText(i, BOUND) + " ]";
 							dupAlertMsg += "\n";				
 							dupAlertMsg += "Coverage : [ " + CellValue(i, CVRG_CNT) + " ][ " + CellValue(i, CVRG_RGN) + " ][ " + CellValue(i, CVRG_LOC) + " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "CNTR/Cargo Type : [ " + CellText(i, CNTRCGO) + " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "Prop No : [ " + CellText(i, "prop_no") + " ]";
 							//====================================================================================================================================
 							
 							ComShowCodeMessage("DMT00138", CellValue(j, "Seq"), dupAlertMsg);
 							return false;
 						}
 					}
 				}	//안쪽 for
 			} //바깥쪽 for
   		} //end with
  		return true;
   	 }
   	
   	/**
   	 * 입력된 ROW 와 DB 에 ROW 가 중복된 데이터인지 체크하는 함수 
   	 */
     function dupValidateWithDB(row) {
     	var formObj = document.form;
   		var sheetObj = sheetObjects[0];
   		
 		//DB 에 저장된 내용과의 중복체크를 수행한다.
 		//중복체크를 위한 필수입력매개변수 설정 
   		with(sheetObj) {
 			ComSetObjValue(formObj.cust_cd, CellValue(row, CUST_CD));
 			ComSetObjValue(formObj.dul_expt_eff_dt, CellValue(row, EFF_DT));
 			ComSetObjValue(formObj.dul_expt_exp_dt, CellValue(row, EXP_DT));
 			ComSetObjValue(formObj.io_bnd_cd, CellValue(row, BOUND));
 			ComSetObjValue(formObj.cvrg_cnt_cd, CellValue(row, CVRG_CNT));
 			ComSetObjValue(formObj.cvrg_rgn_ste_cd, CellValue(row, CVRG_RGN));
 			ComSetObjValue(formObj.cvrg_loc_cd, CellValue(row, CVRG_LOC));
 			ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, CellValue(row, TYPE));
 			ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, CellValue(row, CNTRCGO));
 			ComSetObjValue(formObj.prop_no, CellValue(row, "prop_no"));

 			//DB 중복체크 실행
 			doActionIBSheet(sheetObj,formObj,IBSEARCH_CHECK_DUP);
 		
 			//DB 중복체크 결과 중복되었다면
 			if (ComGetObjValue(formObj.result) == "Y") {
 				//==================================== 에러메시지 생성 ================================================================================
 				var dupAlertMsg = "\n\n";
 				dupAlertMsg += "Customer Code : [ " + CellValue(row, CUST_CD)+ " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "Type : [ " + CellText(row, TYPE) + " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "EFF DT : [ " + ComGetObjValue(formObj.result_dul_expt_eff_dt) + " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "EXP DT : [ " + ComGetObjValue(formObj.result_dul_expt_exp_dt) + " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "BOUND : [ " + CellText(row, BOUND) + " ]";
 				dupAlertMsg += "\n";				
 				dupAlertMsg += "Coverage : [ " + CellValue(row, CVRG_CNT) + " ][ " + CellValue(row, CVRG_RGN) + " ][ " + CellValue(row, CVRG_LOC) + " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "CNTR/Cargo Type : [ " + CellText(row, CNTRCGO) + " ]";
				dupAlertMsg += "\n";
				dupAlertMsg += "Prop No : [ " + CellText(row, "prop_no") + " ]";
 				
 				ComShowCodeMessage("DMT00138", CellValue(row, "Seq"), dupAlertMsg);
 				return false;
 				//====================================================================================================================================
 			}
 		} 
 		return true;
   	}
   	 
	/**
	 * 선택된 Row 에 입력된 Expire Date 가 유효한지 체크해주는 함수
	 * S/C, Before Booking 에 등록된 데이터의 Expire Date 가 여기에 입력된 Expire Date 보다 크다면 에러처리한다.
	 */	      
	 function checkExpireDate(row) {
		 var formObj = document.form;
		 var sheetObj = sheetObjects[0];

     	//2.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
		with(sheetObj) {
	     	var custCd = sheetObj.CellValue(row, CUST_CD);
	     	var typeCd = sheetObj.CellValue(row, TYPE);
	     	var cntCd = sheetObj.CellValue(row, CVRG_CNT);
	     	var rgnCd = "";
	     	var steCd = "";
	     	if (cntCd == "CA" || cntCd == "US") {
	     		steCd = sheetObj.CellValue(row, CVRG_RGN);
	     		rgnCd = "";
	     	}
	     	else {
	     		steCd = "";
	     		rgnCd = sheetObj.CellValue(row, CVRG_RGN);
	     	}
	     	var locCd = sheetObj.CellValue(row, CVRG_LOC);
		}
		
     	ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
     	ComSetObjValue(formObj.cust_seq, custCd.substring(2));
     	ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, typeCd);
     	ComSetObjValue(formObj.cvrg_cnt_cd, cntCd);
     	ComSetObjValue(formObj.cvrg_rgn_cd, rgnCd);
     	ComSetObjValue(formObj.cvrg_ste_cd, steCd);
     	ComSetObjValue(formObj.cvrg_loc_cd, locCd);
    	//EFF DT
    	ComSetObjValue(formObj.dul_expt_eff_dt, 	 sheetObj.CellValue(row, EFF_DT));
    	//EXP DT
    	ComSetObjValue(formObj.dul_expt_exp_dt, 	 sheetObj.CellValue(row, EXP_DT));     	
     	
		 //Expire Date 체크를 실행한다.
		 doActionIBSheet(sheetObj,formObj,IBSEARCH_CHECK_EXPDT);

     	//4.조회 후 결과처리를 한다.
     	//4-1.삭제불가한 사용자 일 경우
     	if (ComGetObjValue(formObj.result) != "Y") {
     		var scNo = ComGetObjValue(formObj.result_sc_no);
     		var darNo = ComGetObjValue(formObj.result_dar_no);
     		var custCd = sheetObj.CellValue(row, CUST_CD);

    		//S/C 일 경우
    		if (sheetObj.CellValue(row, TYPE) == "S") {
    			ComShowCodeMessage("DMT04011", custCd, scNo);
    		}
    		//Before Booking 일 경우
    		else if (sheetObj.CellValue(row, TYPE) == "B") {
    			ComShowCodeMessage("DMT04012", custCd, darNo);
    		}
     		return false;
     	}
     	return true;
	 }
    	 
   	/**
   	 * Dual Type Exception Inquiry 데이터 중복입력 체크
   	 */	      
   	 function checkDualCoverage(selectRow) {
      
   		 var formObj = document.form;
   		 var sheetObj = sheetObjects[0];
   		 var irow = selectRow;
   		 var cntCd="";
   		 var rgnCd="";
   		 var steCd="";
   		 var locCd="";
   		 var bnd ="";
   		 var effdt="";
   		 var expdt="";
   		
   			 cntCd = sheetObj.CellValue(irow, CVRG_CNT);
   			 if (cntCd == "CA" || cntCd == "US") {
   				 steCd = sheetObj.CellValue(irow, CVRG_RGN);
   				 rgnCd = "";
   			 }
   			 else {
   				 steCd = "";
   				 rgnCd = sheetObj.CellValue(irow, CVRG_RGN);
   			 }
   			 locCd = sheetObj.CellValue(irow, CVRG_LOC);
   			 bnd   = sheetObj.CellValue(irow, BOUND);
   	   		 effdt = sheetObj.CellValue(irow, EFF_DT);
   	   		 expdt = sheetObj.CellValue(irow, EXP_DT);
 
	  		 ComSetObjValue(formObj.cnt_cd, "");
	   		 ComSetObjValue(formObj.rgn_cd, "");
	   		 ComSetObjValue(formObj.ste_cd, "");
	   		 ComSetObjValue(formObj.loc_cd, "");
	   		 ComSetObjValue(formObj.io_bnd, "");
	   		 ComSetObjValue(formObj.eff_dt, "");
	   		 ComSetObjValue(formObj.exp_dt, "");
	   		 
	   		 ComSetObjValue(formObj.cnt_cd, cntCd);
	   		 ComSetObjValue(formObj.rgn_cd, rgnCd);
	   		 ComSetObjValue(formObj.ste_cd, steCd);
	   		 ComSetObjValue(formObj.loc_cd, locCd);
	   		 ComSetObjValue(formObj.io_bnd, bnd);
	   		 ComSetObjValue(formObj.eff_dt, effdt);
	   		 ComSetObjValue(formObj.exp_dt, expdt)
   		 

   		 //Dual Coverage 체크를 실행한다.
   		 ComSetObjValue(formObj.result, "");
   		 doActionIBSheet(sheetObj,formObj,IBSEARCH_DUAL_CVRG);

   		 if (ComGetObjValue(formObj.result) != "Y") {
   			var errAlertMsg = "";
 
	   			errAlertMsg += "[ " + sheetObj.CellValue(irow, CVRG_CNT) + " ]";
	   			errAlertMsg += "[ " + sheetObj.CellValue(irow, CVRG_RGN) + " ]";
	   			errAlertMsg += "[ " + sheetObj.CellValue(irow, CVRG_LOC) + " ]";
	   			
	   			ComShowCodeMessage("DMT00132", sheetObj.CellValue(irow, "Seq"), errAlertMsg);

   			sheetObj.CellValue2(irow, CVRG_CNT) = "";
   			sheetObj.CellValue2(irow, CVRG_RGN) = "";
   			sheetObj.CellValue2(irow, CVRG_LOC) = "";
			return false;
   		 }
   		 return true;
   	 }
  	 
 	/**
 	 * Sheet1 에 변경이 발생하였을 때 호출되는 함수
 	 */		 
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj = document.form;
		
		with(sheetObj) {
			switch(ColSaveName(Col)) {
			
				case CUST_CD:
					//Customer Code 가 입력되면 자동으로 Customer Name 을 조회해서 설정해준다.
					if (Value == "" || Value.length < 3) {
						ComShowCodeMessage("DMT00165", "Customer Code");
						CellValue2(Row, Col) = "";
						CellValue2(Row, CUST_NM) = "";
					}
					else {
						if (Value.length != 8) {
							CellValue2(Row, Col) = fetchLeftPadding(Value);
						}
						doActionIBCommon(sheetObj,formObj,IBSEARCH_CUSTNM,SEARCH19,CUST_NM);
					}
					break;
				
				case TYPE:
					//Before 일 경우
					if (CellValue(Row,TYPE) == "B") {
						CellValue(Row, CNTRCGO) = "";
						addCellComboItem(sheetObj, rfaCNTRCargoType, CNTRCGO, true, false);
					}
					//S/C 일 경우
					else if (CellValue(Row,TYPE) == "S") {
						CellValue(Row, CNTRCGO) = "";
						addCellComboItem(sheetObj, sCCNTRCargoType, CNTRCGO, true, true);
					}
					break;
					
				case CVRG_CNT:
					var cntCd = ComTrim(sheetObj.CellValue(Row,Col));
					//Country 가 Empty 라면 모든 Region 정보를 조회한다.
					if (cntCd.length == 0) {
						doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH01,CVRG_RGN);
						sheetObj.CellValue(Row, CVRG_RGN) = "";
					}
					//Country 에 소속된 하위 Regino or State 정보를 조회한다.	
					else if (cntCd.length == 2) {
						doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH03,CVRG_CNT + "|" + CVRG_RGN);
					}
					//Country 가 변경될 경우 Location 정보를 지운다.
					if (isClearLocation) {
						sheetObj.CellValue(Row,CVRG_LOC) = '';
//						clearLocation(sheetObj,CVRG_LOC);
					}
					break;				
	
				case CVRG_RGN:
					var rgnCd = ComTrim(sheetObj.CellValue(Row,Col));
					//Region 를 포함하는 상위  Country 정보를 조회한다.
					switch(rgnCd.length) {
						case 2: 
							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH17,"|" + CVRG_CNT + "|" + CVRG_RGN);
							break;
							
						case 3:
							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH13,"|" + CVRG_CNT + "|" + CVRG_RGN);
							break;
					}
					//Region 이 변경될 경우 Location 정보를 지운다.
					if (isClearLocation) {
						sheetObj.CellValue(Row,CVRG_LOC) = '';
					}					
//					if (isClearLocation) clearLocation(sheetObj,CVRG_LOC);
					break;					
					
				case CVRG_LOC:
					var locCd = ComTrim(sheetObj.CellValue(Row,Col));
		    		if (locCd.length == 5) {
						isClearLocation = false;
						isValueSettingEvent = true;
						//Location 상위(Country, Region or State) 정보를 조회한다.
						doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH04,CVRG_CNT + "|" + CVRG_RGN + "|" + CVRG_LOC);
						isValueSettingEvent = false;
						isClearLocation = true;
					}
					else if (locCd.length > 0) {
						ComShowCodeMessage("DMT00110", "Location");
						sheetObj.CellValue2(Row, Col) = "";
					}
					break;				
			}
		}
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
  	 * Customer 조회를 위해서 조회용 팝업창을 띄우는 함수 
  	 */	 
	function sheet1_OnPopupClick(sheetObj,Row,Col) {
		ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
	}
	
	/**
  	 * Customer 공통팝업에서 선택한 Customer 정보를 해당 필드에 설정하는 함수 
  	 */
    function getCustCd(aryPopupData) {
  		var formObj = document.form;
  		var sheetObj = sheetObjects[0];
  		
  		with(sheetObj) {
  			CellValue(SelectRow, CUST_CD) = aryPopupData[0][3];
  			CellValue(SelectRow, CUST_NM) = aryPopupData[0][4];
  		}
  		
  		//Customer Code 를 가지고 S/C 와 Before Booking 에 해당하는 Customer 인지를 조회한다.
  		doActionIBSheet(sheetObj,formObj,IBSEARCH_DUAL_CUST);
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
	* Row Add 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	*/	 
    function doActionAddDualType() {
    	var sheetObj = sheetObjects[0];
    	
		with(sheetObj) {
			DataInsert(-1);
			//ROW 추가시 TYPE 은 Empty 이어야 한다. 
			CellValue(LastRow, TYPE) 	= "";
			//ROW 추가시 CNTR/Cargo Type 은 Empty 이어야 한다.
			CellValue(LastRow, CNTRCGO) = "";
			addCellComboItem(sheetObj,"",CNTRCGO,false,false);
		}
		
		//Row 가 추가되면 자동으로 Row Copy 와 Row Delete 버튼은 활성화된다.
		if (!ComIsBtnEnable("btn_CopyDualType")) 	ComBtnEnable("btn_CopyDualType");
		if (!ComIsBtnEnable("btn_DelDualType")) 	ComBtnEnable("btn_DelDualType");
    }
	
   /**
	* Row Copy 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	*/	 
    function doActionCopyDualType() {
		var sheetObj = sheetObjects[0];
		
		with(sheetObj) {
			var row = DataCopy();
			RowStatus(row) = "I";
			
			//Row Copy/Delete은 Sel. 선택 필요 및 선택된 것만 조치
			//[8/26] Row Copy시 Status 와 Update Date/User 정보는 제외하고 Copy 필요 
			//[8/26] Row Copy시 비활성화된 것 copy해도 새로 copy된 줄은 활성화 상태 유지 필요 (현재 비활성화된 상태가 copy됨)
			CellValue2(row, STATUS) 	= "";
			CellValue2(row, UPD_OFC) 	= "";
			CellValue2(row, UPD_USR_NM) = "";
			CellValue2(row, UPD_DT) 	= "";
		}
    }
    
   /**
	* Delete 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	*/	 
    function doActionDelDualType() {
    	var formObj 	= document.form;
    	var sheetObj 	= sheetObjects[0];
        var delRows 	= sheetObj.FindCheckedRow("del_chk");
        
        if (delRows == "") {
        	ComShowCodeMessage("DMT00154", "delete");
        	return;
        }
        var delRowArr = delRows.split(ROWMARK);
        
        //Row Delete시 "Do you want to delete [Value]?" Alert창을 띄우고 Yes시 조치
        var msg = "delete " + fetchAllCustomerCodeSelected();
        if (!ComShowCodeConfirm("DMT00135", msg)) return;
        
        //각 ROW 별로 삭제가능한 정보인지 validate 한다.
        for (var i = 0 ; i < delRowArr.length - 1 ; i++) {
        	
        	//1.Status 가 Deleted 인 것을 선택시 Alert 창을 띄우며 막음.
        	if (sheetObj.CellValue(delRowArr[i], STATUS) == "Deleted") {
        		ComShowCodeMessage("DMT00176", sheetObj.CellValue(delRowArr[i], CUST_CD));
        		return;
        	}
        	
        	//2.삭제가능 여부의 대한 체크는 Live 인 경우에만 해당된다.
        	if (sheetObj.CellValue(delRowArr[i], STATUS) == "Live") {
        	
	        	//2-1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
	        	var custCd 	= sheetObj.CellValue(delRowArr[i], CUST_CD);
	        	var typeCd 	= sheetObj.CellValue(delRowArr[i], TYPE);
	        	var cntCd 	= sheetObj.CellValue(delRowArr[i], CVRG_CNT);
	        	var rgnCd 	= "";
	        	var steCd 	= "";
	        	if (cntCd == "CA" || cntCd == "US") {
	        		steCd 	= sheetObj.CellValue(delRowArr[i], CVRG_RGN);
	        		rgnCd 	= "";
	        	}
	        	else {
	        		steCd 	= "";
	        		rgnCd 	= sheetObj.CellValue(delRowArr[i], CVRG_RGN);
	        	}
	        	var locCd 	= sheetObj.CellValue(delRowArr[i], CVRG_LOC);
	        	var ioBndCd = sheetObj.CellValue(delRowArr[i], BOUND);
	        	var cntrCgo = sheetObj.CellValue(delRowArr[i], CNTRCGO);
	        	
	        	ComSetObjValue(formObj.cust_cnt_cd, 		 custCd.substring(0, 2));
	        	ComSetObjValue(formObj.cust_seq, 			 custCd.substring(2));
	        	ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, typeCd);
	        	ComSetObjValue(formObj.cvrg_cnt_cd, 		 cntCd);
	        	ComSetObjValue(formObj.cvrg_rgn_cd, 		 rgnCd);
	        	ComSetObjValue(formObj.cvrg_ste_cd, 		 steCd);
	        	ComSetObjValue(formObj.cvrg_loc_cd, 		 locCd);
	        	//EFF DT
	        	ComSetObjValue(formObj.dul_expt_eff_dt, 	 sheetObj.CellValue(delRowArr[i], EFF_DT));
	        	//EXP DT
	        	ComSetObjValue(formObj.dul_expt_exp_dt, 	 sheetObj.CellValue(delRowArr[i], EXP_DT));
	        	

	        	ComSetObjValue(formObj.io_bnd_cd, 		 	  ioBndCd);
	        	ComSetObjValue(formObj.prop_no, 		 	  sheetObj.CellValue(delRowArr[i], "prop_no"));

	        	ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, 		 cntrCgo);
	        	
	        	//2-2.조회모듈을 호출한다.
	        	doActionIBSheet(sheetObj,formObj,IBSEARCH_DEL_CUST);
	        	
	        	//2-3.조회 후 결과처리를 한다.
	        	//2-4.삭제불가한 사용자 일 경우
	        	if (ComGetObjValue(formObj.result) != "Y") {
	        		var scNo = ComGetObjValue(formObj.result_sc_no);
	        		var darNo = ComGetObjValue(formObj.result_dar_no);
	        		var custCd = sheetObj.CellValue(delRowArr[i], CUST_CD);
	        		
	        		//S/C 일 경우
	        		if (sheetObj.CellValue(delRowArr[i], TYPE) == "S") {
	        			ComShowCodeMessage("DMT02031", custCd, scNo);
	        		}
	        		//Before Booking 일 경우
	        		else if (sheetObj.CellValue(delRowArr[i], TYPE) == "B") {
	        			ComShowCodeMessage("DMT02032", custCd, darNo);
	        		}
	        		return;
	        	}
        	}
        }
        
        //선택한 모든 ROW 를 삭제처리한다.
        for (var i = 0 ; i < delRowArr.length - 1 ; i++) {
        
			if (sheetObj.RowStatus(delRowArr[i]) == "I") {
				sheetObj.RowDelete(delRowArr[i], false);
			}
			else {
				sheetObj.RowStatus(delRowArr[i]) = "D";
				sheetObj.RowHidden(delRowArr[i]) = true;
			}
        }
        
		//Row 가 모두 삭제되었다면 자동으로 Row Copy 와 Row Delete 버튼은 비활성화된다.
        if (fetchRowCount() == 0) {
        	if (ComIsBtnEnable("btn_CopyDualType")) ComBtnDisable("btn_CopyDualType");
        	if (ComIsBtnEnable("btn_DelDualType")) ComBtnDisable("btn_DelDualType");
        }
    }
    
   /**
	* Expire 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	*/	 
    function doActionExpireDualType() {
		var sheetObj = sheetObjects[0];
		
		//선택된 항목이 없을 경우 Alert 창을 띄우며 막음.
        var delRows = sheetObj.FindCheckedRow("del_chk");
        if (delRows == "") {
        	ComShowCodeMessage("DMT00154", "expire");
        	return;
        }		
		
		//Status가 Deleted인 것을 선택시 “[Value] was already deleted” Alert창을 띄우며 막음
		if (isExpireDualType()) {
			remarkCheckExpireDualType();
		}
    }
	
   /**
	* 선택한 모든 항목들이 Expire 처리 가능한지를 체크해주는 함수
	*/		
	function isExpireDualType() {
		var sheetObj = sheetObjects[0];
		
        //각 ROW 별로 Expire 가능한 정보인지 validate 한다.
        with(sheetObj) {
            var expRows = FindCheckedRow("del_chk");
            var expRowArr = expRows.split(ROWMARK);
            
	        for (var i = 0 ; i < expRowArr.length - 1 ; i++) {
	        	if (	RowStatus(expRowArr[i]) != "D"
	        		&&	CellValue(expRowArr[i], STATUS) == "Deleted"	) {
					ComShowCodeMessage("DMT00176", CellValue(expRowArr[i], CUST_CD));
					return false;	        		
	        	}
	        }
        }
		return true;
	}

   /**
	* 선택한 모든 항목들의 EXP DT 컬럼을 필수항목으로 표시해주고, 입력가능하도록 활성화시켜주는 함수
	*/	
	function remarkCheckExpireDualType() {
		var sheetObj = sheetObjects[0];
		
        with(sheetObj) {
            var expRows = FindCheckedRow("del_chk");
            var expRowArr = expRows.split(ROWMARK);
            
	        for (var i = 0 ; i < expRowArr.length - 1 ; i++) {
	        	if (RowStatus(expRowArr[i]) != "D") {
					CellValue(expRowArr[i], EXP_FLG) = "Y";
					CellEditable(expRowArr[i], EXP_DT) = true;	        		
	        	}
	        }
        }
	}
	
   /**
	* Down Excel 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	*/	 
    function doActionDownExcel() {
		var sheetObj = sheetObjects[0];

		sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, DEL_CHK);
    }
    
   /**
	* Retrieve 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	*/	 
    function doActionRetrieve() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	var cboCustomerObj = comboObjects[0];
    	
    	if(comboObjects[3].Code.indexOf('All') == -1) {
    		ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, comboObjects[3].Code);
    	}else{
    		ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, '');
    	}
    	    	
		if (validateForm(sheetObj,formObj,IBSEARCH)) {
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
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
			ComSetObjValue(status, "");
			ComSetObjValue(prop_no, "");
			ComSetObjValue(type, "");
			ComSetObjValue(bound, "");			
		}	    	
		cboCustomerObj.Enable = true;
		cboCustomerObj.Text = "";
		
		for(var i in comboObjects) {
			comboObjects[i].Enable = true;
			comboObjects[i].Text = "";
			if(i==3) {
				makeCntrCgoCombo(comboObjects[i], 'All');	
			}
		}
		
		//조회된 결과를 삭제해준다.
		sheetObj.RemoveAll();
		
		//버튼을 초기화  시켜준다.
		initBtnControl();
    }

   /**
	* Save 버튼 클릭시 실행되어야 할 동작을 정의하는 함수
	*/	 
    function doActionSave() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	var cboCustomerObj = comboObjects[0];
    	
		if (validateForm(sheetObj,formObj,IBSAVE)) {
			//저장 Action 을 수행한다.	
			doActionIBSheet(sheetObj,formObj,IBSAVE);
			
			//저장 Action 이 정상실행시 조회를 실행한다.
			if (ComGetObjValue(formObj.result) == "Y") {

				//Customer 정보를 재조회하고 난 후, 이전 상태값을 유지하기 위해서 현재 선택된  값을 백업한다.
				var custCd = cboCustomerObj.Text;
				//Customer 정보가 추가되었기 때문에, Customer 정보를 재조회한다.
				doActionIBCommon(sheetObj,formObj,IBSEARCH_CUST,SEARCH01);
				//새로 조회된 Customer 목록에서 이전에 선택된 정보로 선택해준다.
				cboCustomerObj.Text = custCd;
				
				//저장을 했기 때문에, 새로 조회를 한다.
				doActionRetrieve();
			}			
		}    	
    }
    
	/**
	 * Customer Code 를 변경하면 해당 Customer Name 을 자동으로 입력해준다.
	 */	
// 	function combo1_OnChange(comboObj, Index_Code, Text) {
//	 	var formObj = document.form;
//
//	 	if (Text == "") {
//	 		ComClearObject(formObj.custNm);
//	 	}
//	 	else if (Text.length != 8) {
//	 		comboObj.Text = fetchLeftPadding(Text);
//	 	}
//	 	ComSetObjValue(formObj.custNm, comboObj.Code);
// 	}
 	
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
 	
	function setCustomerFromPopup(arvPopupData,Row,Col,sheetIdx) {
		//sheetObjects[sheetIdx].CellValue2(row,col) = arvPopupData[0][2];
	} 	
 	
	/**
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation(sheetObj,sComboKey) {
		sheetObj.CellValue2(sheetObj.SelectRow, sComboKey) = "";
	}
	 
    /**
     * 그리드내 콤보필드에 데이터를 추가해준다.
     */		
	function addCellComboItem(sheetObj, comboDatas, sComboKey, isCellCombo, isOnlyTextView) {
		var sRow 			= sheetObj.SelectRow;

		var comboItem;
		var comboItems;

		var comboTxt 		= "";
		var comboVal 		= "";
		var comboInitTxt 	= "";
		var comboInitVal 	= "";
		
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
 	* 선택한 모든 데이터의 Customer Code 를 반환하는 함수 
 	*/	
 	function fetchAllCustomerCodeSelected() {
 		var sheetObj = sheetObjects[0];
 		var codes = "";
 		
         with(sheetObj) {
             var expRows = FindCheckedRow("del_chk");
             var expRowArr = expRows.split(ROWMARK);
             
 	        for (var i = 0 ; i < expRowArr.length - 1 ; i++) {
 	        	if (RowStatus(expRowArr[i]) != "D") {
 	        		if (codes.indexOf(CellValue(expRowArr[i], CUST_CD)) == -1)
 	        			codes += CellValue(expRowArr[i], CUST_CD) + " "; 
 	        	}
 	        }
         }
         return codes;
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
 	
   /**
 	* 삭제되지 않은 전체 Row Count 를 구하는 함수 
 	*/ 	
 	function fetchRowCount() {
 		var sheetObj = sheetObjects[0];
 		var count = 0;
 		
 		with(sheetObj) {
 			for (var row = HeaderRows ; row <= LastRow ; row++) {
 				if (RowStatus(row) != "D") count++;
 			}
 		}
 		return count;
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