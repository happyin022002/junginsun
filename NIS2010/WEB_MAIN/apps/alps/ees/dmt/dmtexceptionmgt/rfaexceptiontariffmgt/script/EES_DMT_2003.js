﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2003.jsp
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.12 이성훈
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
* 2012.09.04 김현화 [CHM-201219794-01] ofc_cd를 로그인 office에서 User id 소속 Office로 변경함.
* 2012.10.31 김현화 [CHM-201220988-01] CHM-201219794-01 이전 버전으로 원복함. (1.145)
* 2017.06.05 이성훈 Master RFA에 DEM-DET기능 추가에 따른 검토 요청. 
*                   - 기존 RFA 로직은 Master RFA 와 동일
*                   - Basic RFA 로직은 Master RFA 정보를 기반으로만 생성됨(Copy to RFA 실행시 적용됨)
*                   - Basic RFA 버전 UP 은 Master RFA 정보를 따라감. (동일한 버전일 경우, Auto Update 불가, Master 가 상위버전이고 승인된 경우에만 Auto Update 실행됨) 
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
    function EES_DMT_2003() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
	
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	//Action 정의
	var IBSEARCH_INIT				= 100;
	var IBSEARCH_DAR 				= 101;
	var IBSEARCH_VER 				= 102;
	var IBSEARCH_ACTCUST 			= 103;
	var IBSEARCH_CALC 				= 104;
	var IBSEARCH_DUAL 				= 105;
	var IBSEARCH_CHKCONTI 			= 106;
	var IBSEARCH_AFFL 				= 107;
	var IBSEARCH_COMM 				= 108;
	var IBSEARCH_APRO 				= 109;
	var IBSEARCH_RFANO_CUST 		= 110;
	var IBSEARCH_CHECK_DUP			= 111;
	var IBSEARCH_RFATARIFF			= 113;
	var IBSEARCH_SUB				= 114;
	var IBSEARCH_RFATARIFF_APVLNO	= 115;
	var IBSEARCH_VER_CHECK			= 116;
	var IBSEARCH_DAR_CHECK			= 117;
	var IBSAVE_DAR 					= 201;
	var IBSAVE_VERSTS 				= 202;
	var IBSAVE_REQUEST				= 203
	var IBSAVE_CANCEL 				= 204;
	var IBSAVE_APPROVAL 			= 205;
	var IBSAVE_COUNTER 				= 206;
	var IBSAVE_REJECT 				= 207;
	var IBSAVE_RFATARIFF			= 208;
	var IBSAVE_RFATARIFF_UPDATE		= 209;
	var	IBSAVE_RFATARIFF_HISTORY	= 210;
	var	IBDELETE_RFATARIFF			= 301;
	var IBSAVE_AUTO_UPDATE			= 211;
	
	//DATA 구분자 정의
	var ROWMARK 				= "|";
	var FIELDMARK 				= "=";

	var TARIFF 					= "dmdt_trf_cd";
	var EFF_DT 					= "eff_dt";
	var EXP_DT 					= "exp_dt";
	var CNTRCGO 				= "dmdt_cntr_cgo_tp_cd";
	var CVRG_CTI 				= "cvrg_conti_cd";
	var CVRG_CNT 				= "cvrg_cnt_cd";
	var CVRG_RGN 				= "cvrg_rgn_cd";
	var CVRG_STE 				= "cvrg_ste_cd";
	var CVRG_LOC 				= "cvrg_loc_cd";
	var FT_FLG 					= "ft_use_flg";
	var ADD_DYS 				= "add_dys";
	var TOT_DYS 				= "ttl_dys";
	var RT_FROM 				= "ft_ovr_dys";
	var RT_UPTO 				= "ft_und_dys";
	var RT_20FT 				= "cntr_20ft_rt_amt";
	var RT_40FT 				= "cntr_40ft_rt_amt";
	var RT_HC 					= "cntr_hc_rt_amt";
	var RT_45FT 				= "cntr_45ft_rt_amt";
	var RT_R9 		    		= "cntr_r9_rt_amt";	
	var RT_SEQ 					= "rfa_expt_rt_seq";	
	var RT_MANDATORY 			= "rt_chk_flg";		//RT 가 필수항목인지 여부를 나타냄.(Y: 필수, N: 옵션)
	var RT_CHECK 				= "rt_chk";			//RT 의 체크박스 선택값	
	var SAT_FLG 				= "xcld_sat_flg";
	var SUN_FLG 				= "xcld_sun_flg";
	var HOL_FLG 				= "xcld_hol_flg";
	var ORGDST_MULTI 			= "org_dest_multi";
	var CURR_ORGDST_MULTI 		= "curr_org_dest_multi";
	var ORGDST_CTI 				= "org_dest_conti_cd";
	var ORGDST_CNT 				= "org_dest_cnt_cd";
	var ORGDST_RGN 				= "org_dest_rgn_cd";
	var ORGDST_STE 				= "org_dest_ste_cd";
	var ORGDST_LOC 				= "org_dest_loc_cd";
	var BKGDEL_CTI 				= "fnl_dest_conti_cd";	
	var BKGDEL_CNT 				= "fnl_dest_cnt_cd";
	var BKGDEL_RGN 				= "fnl_dest_rgn_cd";
	var BKGDEL_STE 				= "fnl_dest_ste_cd";
	var BKGDEL_LOC 				= "fnl_dest_loc_cd";
	var REMARK 					= "expt_trf_rmk";
	var FULL_REMARK 			= "full_expt_trf_rmk";
	var DAR_NO 					= "rfa_expt_dar_no";
	var MAPG_SEQ 				= "rfa_expt_mapg_seq";
	var VER_SEQ 				= "rfa_expt_ver_seq";
	var DTL_SEQ 				= "rfa_rqst_dtl_seq";
	var CVRG_SEQ 				= "cvrg_cmb_seq";
	var VIEW_CVRG_SEQ 			= "view_cvrg_cmb_seq";
	var CURR_CD 				= "curr_cd";
	var RQST_STS_CD 			= "dmdt_expt_rqst_sts_cd";
	var RQST_STS_DESC 			= "dmdt_expt_rqst_sts_desc";
	var RQST_OFC_CD 			= "rqst_ofc_cd";
	var PROG_DT	 				= "prog_dt";
	var PROG_OFC_CD 			= "prog_ofc_cd";
	var PROG_USR_NM 			= "prog_usr_nm";
	var PROG_RMK 				= "prog_rmk";
			
	//Flag 변수(화면 입력데이터에 따라서 그 내용이 달리 설정됨)
	var RT_USE_FLG 				= "rt_use_flg";
	var FNL_DEST_FLG 			= "fnl_dest_flg";
				
	//ROW 의 실제 삭제여부를 나타내는 변수
	//Request Detail 의 하위 항목은 hidden 상태로 조회되기 때문에 실제 삭제와 구분하기 위해서 사용됨
	var HID_STATUS 				= "hidden_status";

	//Actual Customer
	var CUST_CD 				= "cust_cd";
	var CUST_NM 				= "cust_nm";
				
	//현재 ROW 가 수정가능한 상태인지를 나타내주는 컬럼(조회된 데이터는 초기에 Editable 불가하다.)
	var ROW_EDIT_STS 			= "row_edit_status";

	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation 		= true;

	//발생된 OnChange 이벤트가 화면상에서 이루어진것이 아닐경우, 
	//즉 조회된 데이터로 각 콤보필드를 설정해줄때 발생된 것인지를 구분해주는 변수.(의도치 않은 행위를 막기 위해서 사용함)
	//이 변수의 설정은 Location 필드에서 한다.
	var isValueSettingEvent 	= false;

	//Rate Adjustment 필수항목여부를 체크할 때 Coverage 에 값 입력시 중복 호출되는 것을 막기 위함.
	var isRateCheckingCVRG 		= "";
	
	//조회시점에 Proposal No.가 변경된 경우 DAR No. Version 을 재조회하기 위해서 사용하는 변수 
	var prevPropNo 				= "";
	//조회시점에 DAR No.가 변경된 경우 Version 을 재조회하기 위해서 사용하는 변수
    var prevDarNo 				= "";
    
    //APVL OFC 를 Empty 선택시 DAR 항목이 Empty 선택되도록 하기 위한 변수
    var isDAREmpty 				= false;
    
    //조회된 결과를 Multi Combo 에 추가한 후 특정 Item 을 선택하게 되면 combo1_onChange 이벤트가 발생되어
    //예기치 않은 Action 이 수행되는데 그걸 방지하기 위해서 사용하는 변수
    var isSettingValue 			= false;
    
	//Row Copy 버튼 클릭시 자동으로 Row 가 생성되면서 선택위치가 변경된다.
	//선택위치 변경시 수정,입력,삭제된 RFA Exception Tariff 가 있는지 검사하는 함수를 호출하게 되는데, 여기에서 정상처리로 만들기 위해서 사용하는 변수
	var isCopyRFAExceptionTariff = false;
	
  	//Sort 시 선택되어진 Row 의 선택상태를 계속 유지하기 위해서 사용되는 변수
	var currDtlSeq 				= "";
	
	//현재 버전 내용중에 이전버전에서 추가된 신규내용표시. 2011.12.19 KHH
	var NEW_FLG 	= "new_flg";
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetRFAObj 	= sheetObjects[0];
         var sheetCVRGObj 	= sheetObjects[1];
         var sheetRTObj 	= sheetObjects[2];
         var sheetHSTObj 	= sheetObjects[3];

         /*******************************************************/
         var formObject = document.form;

    	//try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            	case "btn_Affiliate":
					if (ComIsBtnEnable(srcName))
						doProcessPopup("Affiliate");
					break;
            
				case "btn_AddBKGReqDetail":
					if (ComIsBtnEnable(srcName)) 
						addBKGReqDetail();
					break;

				case "btn_CopyBKGReqDetail":
					if (ComIsBtnEnable(srcName)) 
						copyBKGReqDetail();
					break;

				case "btn_SaveBKGReqDetail":
					if (ComIsBtnEnable(srcName)) 
						saveBKGReqDetail();
					break;
					
				case "btn_DelBKGReqDetail":
					if (ComIsBtnEnable(srcName)) 
						delBKGReqDetail();
					break;

				case "btn_AddMultiOrgDest":
					if (ComIsBtnEnable(srcName)) 
						addMultiOrgDest();
					break;

				case "btn_DelMultiOrgDest":
					if (ComIsBtnEnable(srcName)) 
						delSubBeforeException(sheetCVRGObj);
					break;
					
				case "btn_AddRateAdjustment":
					if (ComIsBtnEnable(srcName)) 
						addRateAdjustment();
					break;

				case "btn_DelRateAdjustment":
					if (ComIsBtnEnable(srcName)) 
						delSubBeforeException(sheetRTObj);
					break;					

				case "btn_New":
					if (ComIsBtnEnable(srcName)) 
						doActionNew();
					break;

				case "btn_Update":
					if (ComIsBtnEnable(srcName)) 
						doActionUpdate();
					break;

				case "btn_Request":
					if (ComIsBtnEnable(srcName)) 
						doActionRequest();
					break;
				
				case "btn_Cancel":
					if (ComIsBtnEnable(srcName)) 
						doActionCancel();
					break;
							
				case "btn_Approval":
					if (ComIsBtnEnable(srcName)) 
						doActionApproval();
					break;
					
				case "btn_CounterOffer":
					if (ComIsBtnEnable(srcName)) 
						doActionCounterOffer();
					break;
					
				case "btn_Reject":
					if (ComIsBtnEnable(srcName)) 
						doActionReject();
					break;

				case "btn_Close":
					doActionClose();
					break;

            } // end switch
    	//}catch(e) {
    	//	if( e == "[object Error]") {
    	//		ComShowMessage(OBJECT_ERROR);
    	//	} else {
    	//		ComShowMessage(e);
    	//	}
    	//}
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
		var formObj 	= document.form;
  		var sheetRFAObj	= sheetObjects[0];
  		
        for (i = 0 ; i < sheetObjects.length ; i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
       		 //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
	 	//IBMultiCombo초기화 
	    for (var k = 0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k],k+1);
	    }
	 	
		//1.html컨트롤 이벤트초기화
		initControl();
		
		//2.화면 Load 시 비활성화될 컨트롤들을 초기화 시킨다.
		initDisableObjects();
		
		//3.호출자에 따라서 보여줄 버튼을 정한다.
		displayBtnByCaller();		
		
  		//4.페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_INIT);
		
		//5.Proposal No. 에 BBE( Before Booking Exception ) 이 등록된 경우에만 조회합니다.
		if (ComGetObjValue(formObj.exist_rfa_yn) == "Y") {
			
			//5-1.DEM/DET Adjustment Request Exception 에 등록된 데이터를 조회한다.
			doActionRetrieve(IBSEARCH);
		}
		else {
			//5-2.Version 를 초기값으로 설정해준다.
			addComboItem(formObj.version, "001=", true);
			
			//5-3.메인 버튼의 상태를 주어진 조건에 따라서 활성화 or 비활성화 시킨다.
			initBtnControl();
		}	 	
    }
  	
	function initControl() {
		axon_event.addListenerFormat('keypress',	'obj_keypress', 	document.form); 	//- 키보드 입력할때			
  		axon_event.addListener('keydown', 			'ComKeyEnter', 		'form');
	}
	
	function initDisableObjects() {
		var formObj = document.form;
		
		with(formObj) {
			ComEnableManyObjects(false, rFANo, proposalNo, custCd, custNm, status);
			rFANo.className 		= "input2";
			proposalNo.className 	= "input2";
			custCd.className 		= "input2";
			custNm.className 		= "input2";
			status.className 		= "input2";
			
			//Comment 초기화 +++++++++++++++++++++++++++++++++++
			chkComment.checked 		= false;
			
			comment.readOnly 		= true;
			comment.className 		= "textarea2";
			ComSetObjValue(comment, "");
			//+++++++++++++++++++++++++++++++++++++++++++++++++
		}		
	}
    
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "engup":
				// 영문대+숫자 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
          	case "engup2":
 		    	// 영문대+숫자+예외문자
          		DmtComKeyOnlyAlphabet('uppernum', ',. ');
 		        break;
          	case "engup3":
          		//영문입력시에는 대문자로 변환
          		DmtComKeyOnlyAlphabet('upperall')
          		break;
          	case "int":
     	        //숫자 만입력하기
     	        ComKeyOnlyNumber(event.srcElement);
     	        break;
          	default:
 	         	// 숫자만입력하기(정수,날짜,시간)
 	            ComKeyOnlyNumber(event.srcElement);
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
		var sheetID = sheetObj.id;
		var formObj = document.form;
        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 182;
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

					var HeadTitle1 = "|Seq.|Tariff|EFF DT|EXP DT|CNTR/Cargo Type|Coverage|Coverage|Coverage|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|Actual Customer|Actual Customer|Remark";
                    var HeadTitle2 = "|Seq.|Tariff|EFF DT|EXP DT|CNTR/Cargo Type|CN|RGN|LOC|Y|Add|Total|SAT|SUN|H/day|Multi|CT|CN|RGN|LOC|CN|RGN|LOC|Code|Name|Remark";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 20;
                    formObj.sheet1_cnt.value = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false, false);
                    
                    //단일 행만 선택하도록 설정
                    MultiSelection = false;
                    SelectionMode = smSelectionRow;
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    	daCenter,   	true,     		"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,    		 30,    	daCenter,   	true,     		"Seq");
					InitDataProperty(0, cnt++ , dtCombo,		 50,		daCenter,		true,			TARIFF,					true,	"",		dfEngUpKey,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,   		 75,		daCenter,		true,			EFF_DT,					true,	"",		dfDateYmd,		0,	true,	true);

					InitDataProperty(0, cnt++ , dtData,   		 75,		daCenter,		true,			EXP_DT,					true,	"",		dfDateYmd,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,   		140,		daLeft,			true,			CNTRCGO,				true,	"",		dfEngUpKey,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtComboEdit, 	 40,		daCenter,		true,			CVRG_CNT,				true,	"",		dfEngUpKey,		0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtComboEdit, 	 40,		daCenter,		true,			CVRG_RGN,				false,	"",		dfEngUpKey,		0,	true,	true,	3);
					InitDataProperty(0, cnt++ , dtData,   		 50,		daCenter,		true,			CVRG_LOC,				false,	"",		dfEngUpKey,		0,	true,	true,	5);

					InitDataProperty(0, cnt++ , dtCheckBox,  	 20,		daCenter,		true,			FT_FLG,					false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,   		 50,		daCenter,		true,			ADD_DYS,				false,	"",		dfNullInteger,	0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtData,   		 50,		daCenter,		true,			TOT_DYS,				false,	"",		dfNullInteger,	0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtCheckBox,		 30,		daCenter,		true,			SAT_FLG,				false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtCheckBox,   	 30,		daCenter,		true,			SUN_FLG,				false,	"",		dfNone,			0,	true,	true);
					
					InitDataProperty(0, cnt++ , dtCheckBox,   	 45,		daCenter,		true,			HOL_FLG,				false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,   		 40,		daCenter,		true,			ORGDST_MULTI,			false,	"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtComboEdit,  	 40,		daCenter,		true,			ORGDST_CTI,				false,	"",		dfEngUpKey,		0,	true,	true,	1);
					InitDataProperty(0, cnt++ , dtComboEdit,  	 40,		daCenter,		true,			ORGDST_CNT,				false,	"",		dfEngUpKey,		0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtComboEdit,  	 40,		daCenter,		true,			ORGDST_RGN,				false,	"",		dfEngUpKey,		0,	true,	true,	3);

					InitDataProperty(0, cnt++ , dtData,   		 50,		daCenter,		true,			ORGDST_LOC,				false,	"",		dfEngUpKey,		0,	true,	true,	5);
					InitDataProperty(0, cnt++ , dtComboEdit,	 40,		daCenter,		true,			BKGDEL_CNT,				false,	"",		dfEngUpKey,		0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtComboEdit,	 40,		daCenter,		true,			BKGDEL_RGN,				false,	"",		dfEngUpKey,		0,	true,	true,	3);
					InitDataProperty(0, cnt++ , dtData,   		 50,		daCenter,		true,			BKGDEL_LOC,				false,	"",		dfEngUpKey,		0,	true,	true,	5);
					InitDataProperty(0, cnt++ , dtCombo,   		 80,		daCenter,		true,			CUST_CD,				false,	"",		dfNone,			0,	true,	true);

					InitDataProperty(0, cnt++ , dtData,   		 180,		daLeft,			true,			CUST_NM,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   		 120,		daLeft,			true,			REMARK,					false,	"",		dfNone,			0,	true,	true,	500);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			DAR_NO,					false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			MAPG_SEQ,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			VER_SEQ,				false,	"",		dfNone,			0,	false,	false);                    					

					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			DTL_SEQ,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			CVRG_SEQ,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			VIEW_CVRG_SEQ,			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			CURR_ORGDST_MULTI,		false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			CURR_CD,				false,	"",		dfNone,			0,	false,	false);					

					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			FULL_REMARK,			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			CVRG_CTI,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			BKGDEL_CTI,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			RQST_STS_CD,			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			RQST_OFC_CD,			false,	"",		dfNone,			0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			RT_MANDATORY,			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			RT_CHECK,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		    0,		daCenter,		true,			NEW_FLG,				false,	"",		dfNone,			0,	false,	false);	

					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			RT_USE_FLG,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			FNL_DEST_FLG,			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   0,		daCenter,		true,			ROW_EDIT_STS,			false,	"",		dfNone,			0,	false,	false);					
					InitDataProperty(0, cnt++ , dtHidden,  	       0,		daCenter,		true,			HID_STATUS,				false,	"",		dfNone,			0,	false,	false);
					
					
					InitDataCombo(0, TARIFF, "", "", "", "");
					InitDataCombo(0, CNTRCGO, "", "");
					InitDataCombo(0, CVRG_CNT, "", "");
					InitDataCombo(0, CVRG_RGN, "", "");
					InitDataCombo(0, ORGDST_MULTI, "Single|Multi", "S|M");
					InitDataCombo(0, ORGDST_CTI, "", "");
					InitDataCombo(0, ORGDST_CNT, "", "");
					InitDataCombo(0, ORGDST_RGN, "", "");
					InitDataCombo(0, BKGDEL_CNT, "", "");
					InitDataCombo(0, BKGDEL_RGN, "", "");
					InitDataCombo(0, CUST_CD, "", "");

		            //영문 대문자만 입력되도록 설정=================================
					InitDataValid(0, CVRG_CNT,  vtEngUpOnly);
					InitDataValid(0, CVRG_RGN,  vtEngUpOnly);
		            InitDataValid(0, CVRG_LOC,  vtEngUpOther, "0123456789");
					
		            InitDataValid(0, ORGDST_CTI,  vtEngUpOnly);
		            InitDataValid(0, ORGDST_CNT,  vtEngUpOnly);
					InitDataValid(0, ORGDST_RGN,  vtEngUpOnly);
		            InitDataValid(0, ORGDST_LOC,  vtEngUpOther, "0123456789");
					
		            InitDataValid(0, BKGDEL_CNT,  vtEngUpOnly);
					InitDataValid(0, BKGDEL_RGN,  vtEngUpOnly);
		            InitDataValid(0, BKGDEL_LOC,  vtEngUpOther, "0123456789");
		            //==========================================================
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(FT_FLG);
					
					PopupImage = "img/btns_multisearch.gif"
					ShowButtonImage = 2;
					CountPosition = 0;
               }
                break;


            case "sheet2":
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
                    InitRowInfo( 2, 1, 7, 100);

                    var HeadTitle1 = "|Seq.|BKG POR|BKG POR|BKG POR|BKG POR";
                    var HeadTitle2 = "|Seq.|Continent|Country|Region|Location";
 					var headCount = ComCountHeadTitle(HeadTitle1) + 11;
                    formObj.sheet2_cnt.value = ComCountHeadTitle(HeadTitle1);
					
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false);
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	   30,    	daCenter,   	true,     	"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,    		   40,    	daCenter,   	true,     	"Seq",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtComboEdit,	   80,		daCenter,		false,		ORGDST_CTI,			true,	"",		dfEngUpKey,		0,	true,		true,	1);
					InitDataProperty(0, cnt++ , dtComboEdit,	   65,		daCenter,		false,		ORGDST_CNT,			false,	"",		dfEngUpKey,		0,	true,		true,	2);
					InitDataProperty(0, cnt++ , dtComboEdit,   	   60,		daCenter,		false,		ORGDST_RGN,			false,	"",		dfEngUpKey,		0,	true,		true,	3);
					InitDataProperty(0, cnt++ , dtData,   		   65,		daCenter,		false,		ORGDST_LOC,			false,	"",		dfEngUpKey,		0,	true,		true,	5);
					InitDataProperty(0, cnt++ , dtHidden,	   	   90,		daCenter,		false,		CVRG_CTI,			true,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	  	   90,		daCenter,		false,		CVRG_CNT,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	   90,		daCenter,		false,		CVRG_RGN,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	   80,		daCenter,		false,		CVRG_LOC,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		DAR_NO,				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		MAPG_SEQ,			false,	"",		dfNone,			0,	false,		false);					
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		VER_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		DTL_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		CVRG_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		    0,		daCenter,		true,		NEW_FLG,			false,	"",		dfNone,			0,	false,	    false);	

					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		HID_STATUS,			false,	"",		dfNone,			0,	false,		false);

					InitDataCombo(0, ORGDST_CTI, "", "", "", "");
					InitDataCombo(0, ORGDST_CNT, "", "", "", "");
					InitDataCombo(0, ORGDST_RGN, "", "", "", "");

		            //영문 대문자만 입력되도록 설정=================================
		            InitDataValid(0, ORGDST_CTI,  vtEngUpOnly);
		            InitDataValid(0, ORGDST_CNT,  vtEngUpOnly);
					InitDataValid(0, ORGDST_RGN,  vtEngUpOnly);
		            InitDataValid(0, ORGDST_LOC,  vtEngUpOther, "0123456789");
		            //==========================================================
					
					CountPosition = 0;
               }
                break;

            case "sheet3":
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
                    InitRowInfo( 2, 1, 7, 100);

					var HeadTitle1 = "|Over Day|Over Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day|Rate per Day";
                    var HeadTitle2 = "|From|Up To|20 FT|40 FT|H/C|45 FT|R9";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 8;
                    formObj.sheet3_cnt.value = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false ,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 	 30,    	daCenter,   	true,     	"ibflag");
					InitDataProperty(0, cnt++ , dtData,   			 60,		daCenter,		false,		RT_FROM,			true,	"",		dfNullInteger,	0,	true,		true,	2);
					InitDataProperty(0, cnt++ , dtData,   			 60,		daCenter,		false,		RT_UPTO,			false,	"",		dfNullInteger,	0,	true,		true,	2);
					InitDataProperty(0, cnt++ , dtData,   			 115,		daRight,		false,		RT_20FT,			true,	"",		dfNullFloat,	2,	true,		true);
					InitDataProperty(0, cnt++ , dtData,   			 115,		daRight,		false,		RT_40FT,			true,	"",		dfNullFloat,	2,	true,		true);
					InitDataProperty(0, cnt++ , dtData,   			 115,		daRight,		false,		RT_HC,				true,	"",		dfNullFloat,	2,	true,		true);
					InitDataProperty(0, cnt++ , dtData,   			 115,		daRight,		false,		RT_45FT,			true,	"",		dfNullFloat,	2,	true,		true);
					InitDataProperty(0, cnt++ , dtData,   			 115,		daRight,		false,		RT_R9,				true,	"",		dfNullFloat,	2,	true,		true);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		DAR_NO,				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,		MAPG_SEQ,			false,	"",		dfNone,			0,	false,		false);					
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		VER_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		DTL_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		CVRG_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		RT_SEQ,				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		      0,		daCenter,		true,		NEW_FLG,			false,	"",		dfNone,			0,	false,	    false);						
					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,		HID_STATUS,			false,	"",		dfNone,			0,	false,		false);
					
					CountPosition = 0;
               }
                break;

            case "sheet4":
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

					var HeadTitle1 = "|Seq.|Status|Date|Office|Name";
					var headCount = ComCountHeadTitle(HeadTitle1) + 1;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, false, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		50,		daCenter,		false,			"ibflag");
					InitDataProperty(0, cnt++ , dtSeq, 	  			30,		daCenter,		false,			"Seq");
					InitDataProperty(0, cnt++ , dtData,   			100,	daCenter,		false,			RQST_STS_DESC,		false,	"",		dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,   			80,		daCenter,		false,			PROG_DT,			false,	"",		dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,   			70,		daCenter,		false,			PROG_OFC_CD,		false,	"",		dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,   			70,		daLeft,			false,			PROG_USR_NM,		false,	"",		dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtHidden,  			70,		daLeft,			false,			PROG_RMK,			false,	"",		dfNone,			0,	false);
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

   	    	//DAR Combo
   	    	case 1:
   	    		with(comboObj) {
   					MultiSelect = false; 
   					UseAutoComplete = true;	
   					SetColAlign("left");        
   					SetColWidth("140");
   					DropHeight = 160;
   	    		}
   	    		break;
   	    		
   	   	   	//APVL NO Combo
   	    	case 2:
   	    		with(comboObj) {
   					MultiSelect = false; 
   					UseAutoComplete = true;	
   					SetColAlign("left");        
   					SetColWidth("135");
   					DropHeight = 160;
   	    		}
   	    		break;   	    		
   	     } 
   	}      
     
	//Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		var cboDARObj 		= comboObjects[0];
		var cboAPVLObj 		= comboObjects[1];
		var sheetCVRGObj	= sheetObjects[1]; 
		
		switch(sAction) {
			
	        //페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
	        //1.권한, 2.Tariff Type, 3.CNTR/CGO Type, 4.Continent, 5.Country, 6.Region, 7.RFA, Customer 조회
	        case IBSEARCH_INIT:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no,			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.apro_ofc_cd, 	"init");
				ComSetObjValue(formObj.f_cmd, 			COMMAND01);
	
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
	
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리 ===============================================================================================================
				//3-1.로그인 User가 Security 상에서 EES_DMT_2005(DAR-Before BKG Approval)의 Access 권한이 있는지 조회한다.
				ComSetObjValue(formObj.role_auth, 	handleNullString(ComGetEtcData(sXml, "ROLE_AUTH")));
				ComSetObjValue(formObj.role_permit, handleNullString(ComGetEtcData(sXml, "ROLE_PERMIT")));				
				
				//3-2.Tariff Type
				tariffList 		= handleNullString(ComGetEtcData(sXml, "TARIFF"));
				addCellComboItem(sheetObj, tariffList, "dmdt_trf_cd", false);
				
				//3-3.CNTR/CGO Type
				cntrCgoList		= handleNullString(ComGetEtcData(sXml, "CNTRCGO"));
				addCellComboItem(sheetObj, cntrCgoList, "dmdt_cntr_cgo_tp_cd", false, false);
				
				//3-4.Origin or Dest. Continent
				continentList 	= handleNullString(ComGetEtcData(sXml, "CONTINENT"));
				//3-4-1.Before Booking Tariff Sheet 의 Origin or Dest. Continent 를 설정한다.
				addCellComboItem(sheetObj, 		continentList, "org_dest_conti_cd", false);
				//3-4-2.Multi Origin or Destination Sheet 의 Continent 를 설정한다.
				addCellComboItem(sheetCVRGObj, 	continentList, "org_dest_conti_cd", false);
				
				//3-5.Country
				countryList 	= handleNullString(ComGetEtcData(sXml, "COUNTRY"));
				//3-5-1.Before Booking Tariff Sheet 의 Coverage CN 을 설정한다.						
				addCellComboItem(sheetObj, 		countryList, 	"cvrg_cnt_cd", 			false);
				//3-5-2.Before Booking Tariff Sheet 의 Origin(I) or Dest.(D) 의 CN 을 설정한다.
				addCellComboItem(sheetObj, 		countryList, 	"org_dest_cnt_cd",		false);
				//3-5-3.Before Booking Tariff Sheet 의 BKG DEL(I) or POR(O) 의 CN 을 설정한다.
				addCellComboItem(sheetObj, 		countryList, 	"fnl_dest_cnt_cd", 		false);
				//3-5-4.Multi Origin or Destination Sheet 의 Country 를 설정한다.
				addCellComboItem(sheetCVRGObj, 	countryList, 	"org_dest_cnt_cd", 		false);
				
				//3-6.Region
				regionList 		= handleNullString(ComGetEtcData(sXml, "REGION"));
				//3-6-1.Before Booking Tariff Sheet 의 Coverage State 을 설정한다.						
				addCellComboItem(sheetObj, 		regionList, 	"cvrg_rgn_cd", 			false);
				//3-6-2.Before Booking Tariff Sheet 의 Origin(I) or Dest.(D) 의 RGN 을 설정한다.
				addCellComboItem(sheetObj, 		regionList, 	"org_dest_rgn_cd", 		false);
				//3-6-3.Before Booking Tariff Sheet 의 BKG DEL(I) or POR(O) 의 State 을 설정한다.
				addCellComboItem(sheetObj, 		regionList, 	"fnl_dest_rgn_cd", 		false);
				//3-6-4.Multi Origin or Destination Sheet 의 Region 를 설정한다.
				addCellComboItem(sheetCVRGObj, 	regionList, 	"org_dest_rgn_cd", 		false);
				
				//3-7.Proposal No. 로 RFA No. 와 Customer Cd 와 Customer Name 을 조회한다.
	            ComSetObjValue(formObj.custCd, 			handleNullString(ComGetEtcData(sXml, "CUST_CD"))); //CUST_CNT_CD + CUST_SEQ(6자리)
	            ComSetObjValue(formObj.custNm, 			handleNullString(ComGetEtcData(sXml, "CUST_NM")));
	            ComSetObjValue(formObj.custSeq, 		handleNullString(ComGetEtcData(sXml, "CUST_SEQ"))); //CUST_SEQ(입력된 실제값)
	            ComSetObjValue(formObj.rFANo, 			handleNullString(ComGetEtcData(sXml, "RFA_NO")));
	            
	            //3-8.Actual Customer 를 조회한다.
	            actCustList 	= handleNullString(ComGetEtcData(sXml, "CUST"));
	            addCellComboItem(sheetObj, 		actCustList, 	CUST_CD, 				false);
	            
	            //3-9.Proposal No. 에 대한 DAR 를 조회한다.
	            darList 		= handleNullString(ComGetEtcData(sXml, "DAR"));
	            
	            cboDARObj.RemoveAll();
	            if (darList != "")
	            	addMultiComboItem(cboDARObj, darList.split(ROWMARK));

            	//DAR 항목 선택시 자동으로 발생되는 이벤트를 태우지 않도록 처리하기 위해서 isSettingValue 전역변수를 사용하였음.
            	if (cboDARObj.GetCount() > 0) {
	            	isSettingValue = true;
	            	cboDARObj.Index = 0;
	            	isSettingValue = false;
	            	
	            	//APVL OFC 를 설정해준다.
	            	ComSetObjValue(formObj.approvalOfcCd,  cboDARObj.Code);
            	}
				//==========================================================================================================================
            	
            	//3-10. Basic RFA 인지 여부를 보여줍니다.
            	//      Basic RFA 인 경우에는 Request 만 가능하며, Approval 상태인 경우에는 Master RFA 가 존재하고 상위버전이 존재할 경우 Auto Update 만 가능함.
            	ComSetObjValue(formObj.bzc_rfa_yn, 			handleNullString(ComGetEtcData(sXml, "BZC_RFA_YN")));
            	ComSetObjValue(formObj.mst_rfa_ver_uppr_yn, handleNullString(ComGetEtcData(sXml, "MST_RFA_VER_UPPR_YN")));

            	//3-11. Proposal No. 에 대한 BBE( Before Booking Exception ) 가 존재하는지 여부
            	ComSetObjValue(formObj.exist_rfa_yn, 		handleNullString(ComGetEtcData(sXml, "EXIST_RFA_YN")));
            	
            	//3-12. Basic RFA 인 경우, 승인 OFC 는 비활성화
            	if (ComGetObjValue(formObj.bzc_rfa_yn) == "Y") {
            		ComEnableObject(formObj.approvalOfcCd, false);
            	}
	        	break;
        	
		
			case IBSEARCH:      //조회
				if (sheetObj.id == "sheet1") {
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(cboDARObj.Text));
					ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
					ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
					ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	"");
					ComSetObjValue(formObj.f_cmd, 				SEARCH);
				
					//2.조회조건으로 조회실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible 		 = false;
					sheetObjects[0].WaitImageVisible = false;
					sheetObjects[3].WaitImageVisible = false;
					//*********************************************************************************
					
					var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));

					
					//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
		            var arrXml = sXml.split("|$$|");
		            
					//3-1.그리드를 초기화 시킨다.
		            sheetObjects[0].RemoveAll();	//Before Booking Request Detail
					sheetObjects[3].RemoveAll();	//Comment History
					
					//3-2.그리드에 조회된 결과를 Load 시켜준다.
	            	if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);//Before Booking Request Detail
					if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) sheetObjects[3].LoadSearchXml(arrXml[1]);//Comment History
					
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************
					
					//3-3.Comment History 에 대한 설정
					formObj.chkComment.checked = false;
					
					with(sheetObjects[3]) {
						if (RowCount > 0) {
							ComSetObjValue(formObj.comment, CellValue(HeaderRows, PROG_RMK));
						}
						else {
							ComSetObjValue(formObj.comment, "");
						}
						//Comment 비활성화+++++++++++++++++++++++++++++++++
						//ComEnableObject(formObj.comment, false);
						formObj.comment.readOnly 	= true;
						formObj.comment.style.backgroundColor = "#E8E7EC";	//textarea2
						//++++++++++++++++++++++++++++++++++++++++++++++++
					}
				}
				else if (sheetObj.id == "sheet3") {
					var sheetObj1 = sheetObjects[0];
					
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					var custCd = ComTrim(formObj.custCd.value);
					ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0,2));
					ComSetObjValue(formObj.cust_seq, ComTrim(ComGetObjValue(formObj.custSeq)));
					with(sheetObj1) {
						ComSetObjValue(formObj.dmdt_trf_cd, 		CellValue(SelectRow, TARIFF));
						ComSetObjValue(formObj.eff_dt, 				CellValue(SelectRow, EFF_DT));
						ComSetObjValue(formObj.exp_dt, 				CellValue(SelectRow, EXP_DT));
						ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, CellValue(SelectRow, CNTRCGO));
						ComSetObjValue(formObj.cnt_cd, 				CellValue(SelectRow, CVRG_CNT));
						if (CellValue(SelectRow, CVRG_CNT) == "CA" || CellValue(SelectRow, CVRG_CNT) == "US") {
							ComSetObjValue(formObj.rgn_cd, 			"");
							ComSetObjValue(formObj.ste_cd, 			CellValue(SelectRow, CVRG_RGN));
						}
						else {
							ComSetObjValue(formObj.rgn_cd, 			CellValue(SelectRow, CVRG_RGN));
							ComSetObjValue(formObj.ste_cd, 			"");							
						}
						ComSetObjValue(formObj.loc_cd, 				CellValue(SelectRow, CVRG_LOC));
						ComSetObjValue(formObj.ft_use_flg, 			CellValue(SelectRow, FT_FLG));
						
					}
					ComSetObjValue(formObj.f_cmd, SEARCH01);
				
					//2.조회조건으로 조회실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
					
					var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
									
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************
					
					//3.조회후 결과처리
					var result = ComGetEtcData(sXml, "RT_MANDATORY");
					ComSetObjValue(formObj.result, result);					
				}
				break;
				

			//Before Booking Request 의 현재 선택되어진 Detail Seq. 정보만 조회합니다.	
	        case IBSEARCH_RFATARIFF:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 	sheetObj.CellValue(sheetObj.SelectRow, DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	sheetObj.CellValue(sheetObj.SelectRow, MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	sheetObj.CellValue(sheetObj.SelectRow, VER_SEQ));
				ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	sheetObj.CellValue(sheetObj.SelectRow, DTL_SEQ));
				ComSetObjValue(formObj.f_cmd, 				SEARCH16);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				with(sheetObj) {
					CellValue2(SelectRow, TARIFF) 			= handleNullString(ComGetEtcData(sXml, "TARIFF"));
					CellValue2(SelectRow, EFF_DT) 			= handleNullString(ComGetEtcData(sXml, "EFF_DT"));
					CellValue2(SelectRow, EXP_DT) 			= handleNullString(ComGetEtcData(sXml, "EXP_DT"));
					CellValue2(SelectRow, CNTRCGO) 			= handleNullString(ComGetEtcData(sXml, "CNTRCGO"));
					CellValue2(SelectRow, CVRG_CNT) 		= handleNullString(ComGetEtcData(sXml, "CVRG_CNT"));
					CellValue2(SelectRow, CVRG_RGN) 		= handleNullString(ComGetEtcData(sXml, "CVRG_RGN"));
					CellValue2(SelectRow, CVRG_LOC) 		= handleNullString(ComGetEtcData(sXml, "CVRG_LOC"));
					CellValue2(SelectRow, FT_FLG) 			= handleNullString(ComGetEtcData(sXml, "FT_FLG"));
					CellValue2(SelectRow, ADD_DYS) 			= handleNullString(ComGetEtcData(sXml, "ADD_DYS"));
					CellValue2(SelectRow, TOT_DYS) 			= handleNullString(ComGetEtcData(sXml, "TOT_DYS"));
					CellValue2(SelectRow, SAT_FLG) 			= handleNullString(ComGetEtcData(sXml, "SAT_FLG"));
					CellValue2(SelectRow, SUN_FLG) 			= handleNullString(ComGetEtcData(sXml, "SUN_FLG"));
					CellValue2(SelectRow, HOL_FLG) 			= handleNullString(ComGetEtcData(sXml, "HOL_FLG"));
					CellValue2(SelectRow, ORGDST_MULTI) 	= handleNullString(ComGetEtcData(sXml, "ORGDST_MULTI"));
					CellValue2(SelectRow, ORGDST_CTI) 		= handleNullString(ComGetEtcData(sXml, "ORGDST_CTI"));
					CellValue2(SelectRow, ORGDST_CNT) 		= handleNullString(ComGetEtcData(sXml, "ORGDST_CNT"));
					CellValue2(SelectRow, ORGDST_RGN) 		= handleNullString(ComGetEtcData(sXml, "ORGDST_RGN"));
					CellValue2(SelectRow, ORGDST_LOC) 		= handleNullString(ComGetEtcData(sXml, "ORGDST_LOC"));
					CellValue2(SelectRow, BKGDEL_CNT)		= handleNullString(ComGetEtcData(sXml, "BKGDEL_CNT"));
					CellValue2(SelectRow, BKGDEL_RGN) 		= handleNullString(ComGetEtcData(sXml, "BKGDEL_RGN"));
					CellValue2(SelectRow, BKGDEL_LOC) 		= handleNullString(ComGetEtcData(sXml, "BKGDEL_LOC"));
					CellValue2(SelectRow, CUST_CD) 			= handleNullString(ComGetEtcData(sXml, "CUST_CD"));
					CellValue2(SelectRow, CUST_NM) 			= handleNullString(ComGetEtcData(sXml, "CUST_NM"));
					CellValue2(SelectRow, REMARK) 			= handleNullString(ComGetEtcData(sXml, "REMARK"));
					CellValue2(SelectRow, DAR_NO) 			= handleNullString(ComGetEtcData(sXml, "DAR_NO"));
					CellValue2(SelectRow, MAPG_SEQ)			= handleNullString(ComGetEtcData(sXml, "MAPG_SEQ"));
					CellValue2(SelectRow, VER_SEQ) 			= handleNullString(ComGetEtcData(sXml, "VER_SEQ"));
					CellValue2(SelectRow, DTL_SEQ) 			= handleNullString(ComGetEtcData(sXml, "DTL_SEQ"));
					CellValue2(SelectRow, CVRG_SEQ) 		= handleNullString(ComGetEtcData(sXml, "CVRG_SEQ"));
					CellValue2(SelectRow, VIEW_CVRG_SEQ) 	= handleNullString(ComGetEtcData(sXml, "VIEW_CVRG_SEQ"));
					CellValue2(SelectRow, CURR_ORGDST_MULTI)= handleNullString(ComGetEtcData(sXml, "CURR_ORGDST_MULTI"));
					CellValue2(SelectRow, CURR_CD) 			= handleNullString(ComGetEtcData(sXml, "CURR_CD"));
					CellValue2(SelectRow, FULL_REMARK) 		= handleNullString(ComGetEtcData(sXml, "FULL_REMARK"));
					CellValue2(SelectRow, CVRG_CTI) 		= handleNullString(ComGetEtcData(sXml, "CVRG_CTI"));
					CellValue2(SelectRow, BKGDEL_CTI) 		= handleNullString(ComGetEtcData(sXml, "BKGDEL_CTI"));
					CellValue2(SelectRow, RQST_STS_CD) 		= handleNullString(ComGetEtcData(sXml, "RQST_STS_CD"));
					CellValue2(SelectRow, RQST_OFC_CD) 		= handleNullString(ComGetEtcData(sXml, "RQST_OFC_CD"));
					
					//조회를 하였으니 현재 상태를 'R' 로 변경한다.
					RowStatus(SelectRow) = "R";
				}
	        	break;
	        	
	        	
			//Before Booking Request 의 Detail Seq. 에 해당되는 하위 항목들을 조회합니다.	
	        case IBSEARCH_SUB:			
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 	sheetObj.CellValue(sheetObj.SelectRow, DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	sheetObj.CellValue(sheetObj.SelectRow, MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	sheetObj.CellValue(sheetObj.SelectRow, VER_SEQ));
				ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	sheetObj.CellValue(sheetObj.SelectRow, DTL_SEQ));
				ComSetObjValue(formObj.f_cmd, 				SEARCH15);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible 		 = false;
				sheetObjects[1].WaitImageVisible = false;
				sheetObjects[2].WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var arrXml = sXml.split("|$$|");
	            
				//3-1.그리드를 초기화 시킨다.
	            sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				
				//3-2.그리드에 조회된 결과를 Load 시켜준다.
            	if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);//Multi Origin or Dest.
				if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) sheetObjects[2].LoadSearchXml(arrXml[1]);//Rate Adjustment

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				break;	        	
	        	
				
			//DAR No.목록 조회(Proposal No., Version Seq 에 해당되는)				
			case IBSEARCH_DAR:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 		SEARCH01);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            darList 		= handleNullString(ComGetEtcData(sXml, "DAR"));
	            
	            cboDARObj.RemoveAll();
	            if (darList != "")
	            	addMultiComboItem(cboDARObj, darList.split(ROWMARK));

            	//DAR 항목 선택시 자동으로 발생되는 이벤트를 태우지 않도록 처리하기 위해서 isSettingValue 전역변수를 사용하였음.
            	if (cboDARObj.GetCount() > 0) {
	            	isSettingValue = true;
	            	
	            	if (ComGetObjValue(formObj.apvlno_dar) != "") {
	            		matchIndex = -1;
	            		for (var i = 0 ; i < cboDARObj.GetCount() ; i++) {
	            			cboDARObj.Index = i;
	            			if (cboDARObj.Text == ComGetObjValue(formObj.apvlno_dar)) {
	            				matchIndex = i;
	            				break;
	            			}
	            		}
	            		cboDARObj.Index = matchIndex;
	            	}
	            	else {
	            		cboDARObj.Index = 0;
	            	}
	            	
	            	isSettingValue = false;
            	}
				break;
				
				//DAR No.목록 조회(Proposal No., Version Seq 에 해당되는)				
			case IBSEARCH_DAR_CHECK:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 		SEARCH01);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            darList 		= handleNullString(ComGetEtcData(sXml, "DAR"));
	            
	            if (darList != ""){
	            	ComSetObjValue(formObj.dar_no_check, "Y");
	            }else{
	            	ComSetObjValue(formObj.dar_no_check, "N");
	            }

				break;				
			//VER No.목록 조회(DAR No. 에 해당되는)				
			case IBSEARCH_VER:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, ComTrim(cboDARObj.Text));
				ComSetObjValue(formObj.prop_no,         ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 			SEARCH02);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				ComClearCombo(formObj.version);
				
	            verList 		= handleNullString(ComGetEtcData(sXml, "VER"));
				if (verList != "") {
					addComboItem(formObj.version, 	verList, 	false);
					
					if (ComGetObjValue(formObj.apvlno_ver) != "") {
						matchIndex = -1;
						for (var i = 0 ; i < formObj.version.length ; i++) {
							if (formObj.version.options[i].text == ComGetObjValue(formObj.apvlno_ver)) { 
								matchIndex = i;
								break;
							}
						}
						formObj.version.selectedIndex = matchIndex;
					}
				}
				else {
					addComboItem(formObj.version, 	"001=", 	true);
				}
				
				// [ Basic RFA ] Auto Update 를 통해서 버전이 갱신된 경우, Master RFA 의 상위버전 여부를 조회해야 한다.
				ComSetObjValue(formObj.mst_rfa_ver_uppr_yn, handleNullString(ComGetEtcData(sXml, "MST_RFA_VER_UPPR_YN")));
				break;
				

			//Action이 발생하기 직전 현재상태의 Version 정보를 조회한다.				
			case IBSEARCH_VER_CHECK:	
			
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, ComTrim(cboDARObj.Text));
				ComSetObjValue(formObj.f_cmd, 			SEARCH02);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				//ComOpenWait(true);
				//sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				//*********************************************************************************
				//ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            verList 		= handleNullString(ComGetEtcData(sXml, "VER"));
				var val = getMaxVersion(verList);
				if(val == undefined) {
					ComSetObjValue(formObj.max_ver, "001");	//max_version 조회
				}else{
					ComSetObjValue(formObj.max_ver, val);	//max_version 조회
				}
				var val2 = getMaxVersionStatus(verList);
				ComSetObjValue(formObj.max_ver_status, val2);
				break;				
			//화면 Load 시 Actual Customer 정보를 조회한다.				
			case IBSEARCH_ACTCUST:	
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 		SEARCH03);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var comboDatas = ComGetEtcData(sXml, "CUST");
				
				//3-1.Actual Customer Sheet 에서 사용하기 위한 변수 설정
				if (ComTrim(comboDatas).length > 0)  {
					isActualCustomer = true;
				} else {
					isActualCustomer = false;
				}
				//3-2.조회된 결과를 그리드내에 해당 셀 콤보에 매핑시켜준다.
				addCellComboItem(sheetObj,comboDatas,CUST_CD,false);
				break;


			//화면 Load 시 Comment History 정보를 조회한다.				
			case IBSEARCH_COMM:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 				SEARCH06);
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(cboDARObj.Text));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//3.조회 결과를 각 Sheet 에 매핑하기전 각 Sheet 를 Clear 한다. 
				sheetObj.RemoveAll();
				
				//4.조회된 결과를 그리드에 매핑시킨다.
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchXml(sXml);
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//5.Comment History 중 첫번째 항목에 대한 Comment 를 보여준다.
				ComSetObjValue(formObj.comment, sheetObj.CellValue(sheetObj.HeaderRows, PROG_RMK));
				break;			
						
				
			//화면 Load 시 Approval No. 정보를 조회한다.				
			case IBSEARCH_APRO:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 				SEARCH11);

				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				apvlList 		= handleNullString(ComGetEtcData(sXml, "APRO"));
			
				cboAPVLObj.RemoveAll();
				if (apvlList != "") {
					addMultiComboItem(cboAPVLObj, apvlList.split(ROWMARK));

					if (cboAPVLObj.GetCount() > 0) {
						isSettingValue = true;
						cboAPVLObj.Index = 0;
						isSettingValue = false;
					}
				}				
				break;							
							

			//화면 Load 시 Proposal No. 로 RFA No. 와 Customer Cd 와 Customer Name 을 조회한다.
			case IBSEARCH_RFANO_CUST:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 	SEARCH14);
				ComSetObjValue(formObj.prop_no, ComGetObjValue(formObj.proposalNo));
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				ComSetObjValue(formObj.custCd,		ComGetEtcData(sXml, "CUST_CD")); 	//CUST_CNT_CD + CUST_SEQ(6자리)
	            ComSetObjValue(formObj.custNm, 		ComGetEtcData(sXml, "CUST_NM"));
	            ComSetObjValue(formObj.custSeq, 	ComGetEtcData(sXml, "CUST_SEQ")); 	//CUST_SEQ(입력된 실제값)
	            ComSetObjValue(formObj.rFANo, 		ComGetEtcData(sXml, "RFA_NO"));
				break;	
				
				
			//화면에서 입력한 RFA 정보와 기등록된 RFA 정보중 중복된 데이터가 있는지 조회 합니다.	
	        case IBSEARCH_CHECK_DUP:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				with(sheetObj) {
					ComSetObjValue(formObj.rfa_expt_dar_no, 	CellValue(SelectRow, DAR_NO));
					ComSetObjValue(formObj.rfa_expt_mapg_seq, 	CellValue(SelectRow, MAPG_SEQ));
					ComSetObjValue(formObj.rfa_expt_ver_seq, 	CellValue(SelectRow, VER_SEQ));
					ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	CellValue(SelectRow, DTL_SEQ));
					ComSetObjValue(formObj.dmdt_trf_cd,			CellValue(SelectRow, TARIFF));
					ComSetObjValue(formObj.eff_dt,				CellValue(SelectRow, EFF_DT));
					ComSetObjValue(formObj.exp_dt,				CellValue(SelectRow, EXP_DT));
					
					var cntrCgoArr = CellValue(SelectRow, CNTRCGO).split(":");
					ComSetObjValue(formObj.dmdt_cntr_tp_cd,		cntrCgoArr[0]);
					ComSetObjValue(formObj.dmdt_cgo_tp_cd,		cntrCgoArr[1]);
					
					ComSetObjValue(formObj.cvrg_cnt_cd,			CellValue(SelectRow, CVRG_CNT));
					
					if (CellValue(SelectRow, CVRG_CNT) == "CA" || CellValue(SelectRow, CVRG_CNT) == "US") {
						ComSetObjValue(formObj.cvrg_rgn_cd,		"");
						ComSetObjValue(formObj.cvrg_ste_cd,		CellValue(SelectRow, CVRG_RGN));
					}
					else {
						ComSetObjValue(formObj.cvrg_rgn_cd,		CellValue(SelectRow, CVRG_RGN));
						ComSetObjValue(formObj.cvrg_ste_cd,		"");
					}

					ComSetObjValue(formObj.cvrg_loc_cd,			CellValue(SelectRow, CVRG_LOC));
					
					ComSetObjValue(formObj.ft_use_flg,			CellValue(SelectRow, FT_FLG));
					
					ComSetObjValue(formObj.fnl_dest_cnt_cd,		CellValue(SelectRow, BKGDEL_CNT));
					
					if (CellValue(SelectRow, BKGDEL_CNT) == "CA" || CellValue(SelectRow, BKGDEL_CNT) == "US") {
						ComSetObjValue(formObj.fnl_dest_rgn_cd,	"");
						ComSetObjValue(formObj.fnl_dest_ste_cd,	CellValue(SelectRow, BKGDEL_RGN));
					}
					else {
						ComSetObjValue(formObj.fnl_dest_rgn_cd,	CellValue(SelectRow, BKGDEL_RGN));
						ComSetObjValue(formObj.fnl_dest_ste_cd,	"");
					}

					ComSetObjValue(formObj.fnl_dest_loc_cd,		CellValue(SelectRow, BKGDEL_LOC));
					ComSetObjValue(formObj.act_cust_cnt_cd,		CellValue(SelectRow, CUST_CD).substring(0, 2));
					ComSetObjValue(formObj.act_cust_seq,		CellValue(SelectRow, CUST_CD).substring(2));
				}
				
				ComSetObjValue(formObj.f_cmd, 			SEARCH17);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				ComSetObjValue(formObj.result, handleNullString(ComGetEtcData(sXml, "RESULT")));
	        	break;
				
			//Tariff Type 이 'DMIF, DMOF' 일 경우 Calc Type 을  체크한다.
			case IBSEARCH_CALC:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH06);
							
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));										
						
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
	            var comboDatas = ComGetEtcData(sXml, "CALC");
				ComSetObjValue(formObj.result, comboDatas);
				if (comboDatas == "E") {
					var cntCd = ComGetEtcData(sXml, "CNT");
					ComSetObjValue(formObj.result_cnt, cntCd);
					var steCd = ComGetEtcData(sXml, "STE");
					ComSetObjValue(formObj.result_ste, steCd);
					var rgnCd = ComGetEtcData(sXml, "RGN");
					ComSetObjValue(formObj.result_rgn, rgnCd);
					var locCd = ComGetEtcData(sXml, "LOC");
					ComSetObjValue(formObj.result_loc, locCd);
				}				
				break;
				
				
			//Tariff Type 이 'CTIC, CTOC' 일 경우 Calc Type 와 Dual Type 을 모두 체크한다.				
			case IBSEARCH_DUAL:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH07);
							
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));										
						
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
	            var comboDatas = ComGetEtcData(sXml, "CALC");
				ComSetObjValue(formObj.result, comboDatas);
				if (comboDatas == "E") {
					var cntCd = ComGetEtcData(sXml, "CNT");
					ComSetObjValue(formObj.result_cnt, cntCd);
					var steCd = ComGetEtcData(sXml, "STE");
					ComSetObjValue(formObj.result_ste, steCd);
					var rgnCd = ComGetEtcData(sXml, "RGN");
					ComSetObjValue(formObj.result_rgn, rgnCd);
					var locCd = ComGetEtcData(sXml, "LOC");
					ComSetObjValue(formObj.result_loc, locCd);
				}
				break;
				
					
			//BKG POR(O) or DEL(I) 의 입력된 CN 의 Continent 와 Coverage 의 Continent 가 동일한지 비교한다.
			case IBSEARCH_CHKCONTI:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH08);
							
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
	            var comboDatas = ComGetEtcData(sXml, "EQUAL");
				ComSetObjValue(formObj.result, comboDatas);					
				break;
				

			//Before Booking의 APVL No. 에 해당되는 APVL OFC, DAR No., Version, Status 를 조회한다.
			case IBSEARCH_RFATARIFF_APVLNO:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.rfa_expt_apro_no, 	ComTrim(cboAPVLObj.Text));
				ComSetObjValue(formObj.f_cmd, 				SEARCH18);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************

				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            ComSetObjValue(formObj.apvlno_ofc, handleNullString(ComGetEtcData(sXml, "APVL_OFC")));
	            ComSetObjValue(formObj.apvlno_dar, handleNullString(ComGetEtcData(sXml, "DAR")));
	            ComSetObjValue(formObj.apvlno_ver, handleNullString(ComGetEtcData(sXml, "VER")));
	            
				break;
				
				
			case IBSAVE_RFATARIFF:        //저장
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 				MULTI);
				ComSetObjValue(formObj.cust_cnt_cd,			ComGetObjValue(formObj.custCd).substring(0, 2));
				ComSetObjValue(formObj.cust_seq,			ComGetObjValue(formObj.custCd).substring(2));
				ComSetObjValue(formObj.prog_rmk,			ComGetObjValue(formObj.comment));
				
				var sParam = "";
				var sParam1 = sheetObjects[0].GetSaveString();
				var sParam2 = sheetObjects[1].GetSaveString();
				var sParam3 = sheetObjects[2].GetSaveString();
				
				if (sheetObjects[0].IsDataModified == true) {
					sParam1 = ComSetPrifix(sParam1, "subBKGREQDTL");
					sParam = sParam1 + "&";
				}
				if (sheetObjects[1].IsDataModified == true) {
					sParam2 = ComSetPrifix(sParam2, "subORGDEST");
					sParam = sParam + sParam2 + "&";
				}
				if (sheetObjects[2].IsDataModified == true) {
					sParam3 = ComSetPrifix(sParam3, "subRT");
					sParam = sParam + sParam3 + "&";
				}
				sParam += "&" + FormQueryString(formObj);
				
				//2.저장실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSaveXml("EES_DMT_2003GS.do", sParam);

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
					
					//신규 Before Booking Request 입력시 Detail Seq 를 반환받아서 설정해준다. ======================
					var darList		=	handleNullString(ComGetEtcData(sXml, "DAR"));
		            if (darList != "") {
		            	addMultiComboItem(cboDARObj, darList.split(ROWMARK));
		            	
		            	//DAR 항목 선택시 자동으로 발생되는 이벤트를 태우지 않도록 처리하기 위해서 isSettingValue 전역변수를 사용하였음.
		            	if (cboDARObj.GetCount() > 0) {
			            	isSettingValue = true;
			            	cboDARObj.Index = 0;
			            	isSettingValue = false;
			            	
			            	sheetObj.CellValue2(sheetObj.SelectRow, DAR_NO) = cboDARObj.Text;
		            	}
		            }
					
					var dtlSeq 		= handleNullString(ComGetEtcData(sXml, "DTL_SEQ"));
					if (sheetObj.RowStatus(sheetObj.SelectRow) == "I") {
						sheetObj.CellValue2(sheetObj.SelectRow, DTL_SEQ) = dtlSeq;
					}
					//======================================================================================					
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}				
                break;
				

       		//Update 버튼 클릭시 'Approved', 'Rejected' 상태의 Before Booking Request 정보를 새로운 버전으로 생성 합니다.
			case IBSAVE_RFATARIFF_UPDATE:
				//1.생성 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 					MULTI02);
				ComSetObjValue(formObj.rfa_expt_dar_no,			sheetObj.CellValue(sheetObj.HeaderRows, DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq,		sheetObj.CellValue(sheetObj.HeaderRows, MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_prev_ver_seq, 	sheetObj.CellValue(sheetObj.HeaderRows, VER_SEQ));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"T");
				ComSetObjValue(formObj.prop_no,					ComGetObjValue(formObj.proposalNo));
				
				var apprOfcCd = handleNullString( ComGetObjValue(formObj.approvalOfcCd) );
				if (apprOfcCd == "") {
					// Invalid {Approval Office} Code
					// 2013.10.23 임창빈 통합 로그 에러 처리 작업.
					ComShowCodeMessage("DMT00110", "Approval Office");
					return;
				}
				
				ComSetObjValue(formObj.apro_ofc_cd, 			apprOfcCd );
				ComSetObjValue(formObj.cust_cnt_cd,				ComGetObjValue(formObj.custCd).substring(0, 2));
				ComSetObjValue(formObj.cust_seq,				ComGetObjValue(formObj.custCd).substring(2));

				//2.위의 조건으로 S/C Exception Tariff 정보를 생성하도록 서버로직을 호출 합니다.
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
                break;
                
                
       		//DAR History 팝업에서 선택한 버전의 Before Exception Request 를 현재 버전에 생성 합니다.
            //만일, 현재 버전에 Before Exception Request 가 존재한다면 모두 삭제한다.
			case IBSAVE_RFATARIFF_HISTORY:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 					MULTI03);
				ComSetObjValue(formObj.rfa_expt_dar_no, 		cboDARObj.Text);
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"T");
				ComSetObjValue(formObj.prop_no,					ComGetObjValue(formObj.proposalNo));
				
				var apprOfcCd = handleNullString( ComGetObjValue(formObj.approvalOfcCd) );
				if (apprOfcCd == "") {
					// Invalid {Approval Office} Code
					// 2013.10.23 임창빈 통합 로그 에러 처리 작업.
					ComShowCodeMessage("DMT00110", "Approval Office");
					return;
				}
				
				ComSetObjValue(formObj.apro_ofc_cd, 			apprOfcCd );				
				ComSetObjValue(formObj.cust_cnt_cd,				ComGetObjValue(formObj.custCd).substring(0, 2));
				ComSetObjValue(formObj.cust_seq,				ComGetObjValue(formObj.custCd).substring(2));				
				
				//2.위의 조건으로 S/C Exception Tariff 정보를 생성하도록 서버로직을 호출 합니다.
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}				
				break;
                
                
			//Accept 버튼 클릭시 Version 의 상태정보를 변경하고, 로그테이블에 입력한다.
			case IBSAVE_VERSTS:
				//1.Version 상태정보 변경 요청 전, 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH10);
				ComSetObjValue(formObj.prop_no, ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
					
				//2.입력조건으로 수정실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				break;
					
			
			//DAR No.가 없을 경우 새로운 DAR No. 를 생성한다.				
			case IBSAVE_DAR:
				//1.DAR No. 요청 전, 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH05);
				
				//2.입력조건으로 수정실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var result = ComGetEtcData(sXml, "DAR");
				ComSetObjValue(formObj.result, result);
				break;
				

			case IBSAVE_REQUEST:
				//1.REQUEST 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComTrim(cboDARObj.Text));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"R");				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 				
				ComSetObjValue(formObj.f_cmd, 					SEARCH06);
				ComSetObjValue(formObj.prop_no, 				ComGetObjValue(formObj.proposalNo));
				
				//2.선택된 조건으로 REQUEST 실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
											
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.REQUEST 후 결과처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
				break;				
				
				
			case IBSAVE_CANCEL:
				//1.CANCEL 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		cboDARObj.Text);
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"C");				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 				
				ComSetObjValue(formObj.f_cmd, 					SEARCH07);
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
													
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.CANCEL 후 결과처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
				break;
				
				
			case IBSAVE_APPROVAL:
				//1.삭제 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComTrim(cboDARObj.Text));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"A");
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Approved");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		ComTrim(cboAPVLObj.Text));
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.prop_no, 				ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.f_cmd, 					SEARCH08);
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.삭제 후 결과처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}							
				break;
				
				
			case IBSAVE_COUNTER:
				//1.COUNTER OFFER 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComTrim(cboDARObj.Text));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"O");	
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Counter Offered");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		"");
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.prop_no, 				ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.f_cmd, 					SEARCH09);
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.COUNTER OFFER 후 결과처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
				break;
				
				
			case IBSAVE_REJECT:
				//1.REJECT 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComTrim(cboDARObj.Text));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"J");	
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Rejected");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		"");
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.prop_no, 				ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.f_cmd, 					SEARCH10);
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.REJECT 후 결과처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}							
				break;
				
				
			//Row Delete 버튼을 클릭할 경우 해당 Before Exception Request 를 삭제해 준다.
			case IBDELETE_RFATARIFF:
				//1.삭제 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		sheetObj.CellValue(sheetObj.SelectRow, DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		sheetObj.CellValue(sheetObj.SelectRow, MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		sheetObj.CellValue(sheetObj.SelectRow, VER_SEQ));
				ComSetObjValue(formObj.rfa_rqst_dtl_seq, 		sheetObj.CellValue(sheetObj.SelectRow, DTL_SEQ));
				ComSetObjValue(formObj.f_cmd, 					MULTI01);	
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}				
				break;
			
			// Basic RFA 인 경우, Master RFA 에 승인된 상위버전이 존재하는 경우 - Auto Update 실행
			case IBSAVE_AUTO_UPDATE:
				// 1. 필요정보 설정
				ComSetObjValue(formObj.f_cmd, 			MULTI04);
				ComSetObjValue(formObj.cpy_tp_cd, 		"U");		// U : Auto Update ( Only DMT 모듈에서만 사용 ), C : copy to RFA ( Only PRI 모듈에서만 사용)
				ComSetObjValue(formObj.bzc_prop_no, 	ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.rfa_expt_dar_no, sheetObj.CellValue(sheetObj.SelectRow, DAR_NO));

				// 2. Auto Update 실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2003GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}				
				break;
		}
    }

	//콤보관련 데이터를 조회하는 함수
	function doActionIBCommon(sheetObj, formObj, sAction, sComboAction, sComboKey, sSetParameter) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
		//현재 ROW 를 결정한다.(Multi Coverage 에서는 여러줄에 복사를 할 경우 발생되는 문제점을 처리하기 위함) +++++++++++++++++++++++++++++++++
		selectedRow = sheetObj.SelectRow;
		if (sheetObj.id == "sheet2" && ComGetObjValue(formObj.select_row) != "") {
			selectedRow = ComGetObjValue(formObj.select_row);
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
        switch(sAction) {
			//Tariff Type 불러오기
			case IBSEARCH:
				
				if (sSetParameter == undefined) sSetParameter = true;
				
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				if (sSetParameter) {
					setComboParameters(sheetObj, sComboAction, sComboKey);
				}

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
				switch(sComboAction) {
						
					//3-1.Tariff 조회(모든 Tariff 목록)
					case SEARCHLIST:
						comboDatas = handleNullString(ComGetEtcData(sXml, "common_tariff_cd"));
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
						break;
						
					//3-2.CNTR/Cargo Type 조회(모든 CNTR/Cargo 목록)
					case SEARCH11:											
						comboDatas = handleNullString(ComGetEtcData(sXml, "CONTR_CGO"));
						comboDatas = comboDatas.replace("All=All^All|", "");
						addCellComboItem(sheetObj,comboDatas,sComboKey,false,false);
						break;

					//3-3.Origin or Dest. CT 조회(모든 Continent 목록)	
					case SEARCH08:
						comboDatas = handleNullString(ComGetEtcData(sXml, "CONTI"));
						//1.Before Booking Request Detail 의 Origin(I) or Dest.(D) 의 CT 를 설정한다.
						addCellComboItem(sheetObjects[0],comboDatas,sComboKey,false);
						
						//2.Multi Origin or Destination 의 CT 를 설정한다.
						addCellComboItem(sheetObjects[1],comboDatas,sComboKey,false);
						break;
						
					//3-4.Country 조회(모든 Country 목록)				
					case SEARCH02:
						comboDatas = handleNullString(ComGetEtcData(sXml, "CNT"));
						if (sComboKey == "ALL") {
							//1.Before Booking Request Detail 의 Coverage CN 을 설정한다.						
							addCellComboItem(sheetObjects[0],comboDatas,"cvrg_cnt_cd",false);
							
							//2.Before Booking Request Detail 의 Origin(I) or Dest.(D) 의 CN 을 설정한다.
							addCellComboItem(sheetObjects[0],comboDatas,"org_dest_cnt_cd",false);
							
							//3.Before Booking Request Detail 의 BKG DEL(I) or POR(O) 의 CN 을 설정한다.
							addCellComboItem(sheetObjects[0],comboDatas,"fnl_dest_cnt_cd",false);
							
							//4.Multi Origin or Destination BKG POR 의 Country 를 설정한다.
							addCellComboItem(sheetObjects[1],comboDatas,"org_dest_cnt_cd",false);
						}
						else {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						}
						break;
						
					//3-5.Region 조회(모든 Region 목록)					
					case SEARCH01:
						comboDatas = handleNullString(ComGetEtcData(sXml, "RGN"));
						if (sComboKey == "ALL") {
							//1.Before Booking Request Detail 의 Coverage State 을 설정한다.						
							addCellComboItem(sheetObjects[0],comboDatas,"cvrg_rgn_cd",false);
							
							//2.Before Booking Request Detail 의 Origin(I) or Dest.(D) 의 RGN 을 설정한다.
							addCellComboItem(sheetObjects[0],comboDatas,"org_dest_rgn_cd",false);
							
							//3.Before Booking Request Detail 의 BKG DEL(I) or POR(O) 의 State 을 설정한다.
							addCellComboItem(sheetObjects[0],comboDatas,"fnl_dest_rgn_cd",false);
							
							//4.Multi Origin or Destination BKG POR 의 Region 를 설정한다.
							addCellComboItem(sheetObjects[1],comboDatas,"org_dest_rgn_cd",false);
						}
						else {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						}
						break;
						
					//3-6.Coverage RGN 조회(선택한 CN 에 해당되는 RGN 을 모두 조회한다)
					case SEARCH03:
						sComboKey = sComboKey.split(ROWMARK);
						
						//응답 XML 에서 Region or State 정보를 추출해서 목록에 입력해준다.	
						var cntCd = sheetObj.CellValue(selectedRow, sComboKey[0]);
						if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
							comboDatas = handleNullString(ComGetEtcData(sXml, "STE"));
						} 
						else {
							comboDatas = handleNullString(ComGetEtcData(sXml, "RGN"));
						}

						//조회된 결과가 없을 경우 Error Message 를  보여주고 Empty 로 초기화시킨다.
						if (comboDatas == "") {
							ComShowCodeMessage("DMT00110", "Country");
							sheetObj.CellValue(selectedRow, sComboKey[0]) = "";
							return;
						} 
						else {
							addCellComboItem(sheetObj,comboDatas,sComboKey[1],true);
						}	
						break;
						
					//3-7.Coverage LOC 상위 항목조회(입력한 LOC 에 해당되는 상위 CN, RGN 을 조회한다)
					case SEARCH04:
						sComboKey = sComboKey.split(ROWMARK);
						
						//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
						comboDatas = handleNullString(ComGetEtcData(sXml, "CNT"));
						if (comboDatas != "") {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							
							if (sheetObj.id == "sheet1") selectedRow = sheetObj.SelectRow;
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							var cntCd = ComTrim(sheetObj.CellValue(selectedRow, sComboKey[0]));

							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas = handleNullString(ComGetEtcData(sXml, "STE"));
								} else {
									comboDatas = handleNullString(ComGetEtcData(sXml, "RGN"));
								}
								setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Location");
							sheetObj.CellValue2(selectedRow, sComboKey[2]) = "";
						}
						break;
											
					//3-8.Origin or Dest. CN 조회(선택한 Continent 에 해당되는 Country 정보를 조회한다)
					case SEARCH06:
						comboDatas = handleNullString(ComGetEtcData(sXml, "CNT"));
						if (comboDatas != "") {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						} 
						else {
							ComShowCodeMessage("DMT00110", "Continent");
							sheetObj.CellValue(selectedRow, ORGDST_CTI) = "";
							
							//Country 를 Empty 로 초기화 시킬때, 상위 Continent 필드까지 초기화되는 것을
							// 막기 위해서 변수를 false 로 설정함.(2009.06.21)
							isValueSettingEvent = true;
							sheetObj.CellValue(selectedRow, ORGDST_CNT) = "";
							isValueSettingEvent = false;
						}
						break;
						
					//3-9.Origin or Dest. LOC 상위 항목조회(입력한 LOC 에 해당되는 상위 CT, CN, RGN 을 조회한다)
					case SEARCH10:
						sComboKey = sComboKey.split(ROWMARK);
						
						//응답 XML 에서 Continent 정보를 추출해서 목록에서 선택해준다.
						comboDatas = handleNullString(ComGetEtcData(sXml, "CONTI"));
						if (comboDatas != "") {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							comboDatas = handleNullString(ComGetEtcData(sXml, "CNT"));
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							var cntCd = sheetObj.CellValue(selectedRow, sComboKey[1]);
							if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
								comboDatas = ComGetEtcData(sXml, "STE");
							} 
							else {
								comboDatas = ComGetEtcData(sXml, "RGN");
							}
							setCellComboItem(sheetObj, comboDatas, sComboKey[2], selectedRow);
						}
						else {
							ComShowCodeMessage("DMT00110", "Location");
							sheetObj.CellValue2(selectedRow, sComboKey[3]) = "";							
						}
						break;

					//3-10.Origin or Dest. Country 상위 항목조회(선택한 Country 에 해당되는 상위 CT 를 조회한다)
					case SEARCH12:
						sComboKey = sComboKey.split(ROWMARK);
						
						//응답 XML 에서 Continent 정보를 추출해서 목록에서 선택해준다.
						comboDatas = handleNullString(ComGetEtcData(sXml, "CONTI"));
						if (comboDatas != "") {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							if (sComboKey[0] == "org_dest_conti_cd") {
								//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
								comboDatas = ComGetEtcData(sXml, "CNT");
								setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							}
						}
						break;
												
					//3-11.Origin or Dest. Region 상위 항목조회(선택한 Region 에 해당되는 상위 CT, CN 을 조회한다)
					case SEARCH13:

					//3-12.Origin or Dest. Region 상위 항목조회(선택한 Region 에 해당되는 상위 CT, CN 을 조회한다)
					case SEARCH17:
						sComboKey = sComboKey.split(ROWMARK);

						//응답 XML 에서 Continent 정보를 추출해서 목록에서 선택해준다.
						comboDatas = handleNullString(ComGetEtcData(sXml, "CONTI"));
						if (comboDatas != "") {						
							if (ComTrim(sComboKey[0]) != "") {
								//응답 XML 에서 Continent 정보를 추출해서 목록에서 선택해준다.
								setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							}
							
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							comboDatas = handleNullString(ComGetEtcData(sXml, "CNT"));
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							var cntCd = ComTrim(sheetObj.CellValue(selectedRow, sComboKey[1]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas = handleNullString(ComGetEtcData(sXml, "STE"));
								} 
								else {
									comboDatas = handleNullString(ComGetEtcData(sXml, "RGN"));
								}
								setCellComboItem(sheetObj, comboDatas, sComboKey[2], selectedRow);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Region");
							sheetObj.CellValue2(selectedRow, sComboKey[2]) = "";							
						}
						
						break;
																								
					//3-13.Rate Adjustment 의 Currency 항목 조회
					case COMMAND05:
						comboDatas = handleNullString(ComGetEtcData(sXml, sComboKey));
						comboDatas = " = |" + comboDatas;
						addComboItem(formObj.currency,comboDatas,true);
						break;	
				};
				break;
        }
		sheetObj.WaitImageVisible = true;
    }	

    /**	
     * 그리드내 콤보필드에 데이터를 선택해준다.
     */		
	function setCellComboItem(sheetObj, comboDatas, sComboKey, sComboRow) {
    	var formObj 	= document.form;
		
		if (comboDatas != undefined) {
			comboItem 	= comboDatas.split(FIELDMARK);
			sVal 		= comboItem[0];
		}
		else {
			sVal		= "";
		}
		
		sheetObj.CellValue(sComboRow, sComboKey) = sVal;
	}
	
    /**
     * 그리드내 콤보필드에 데이터를 추가해준다.
     */		
	function addCellComboItem(sheetObj,comboDatas,sComboKey,isCellCombo,isOnlyTextView) {
     	var formObj			= document.form;
		var comboItems;
		var comboItem;
		var comboTxt 		= "";
		var comboVal 		= "";		
		var comboInitTxt 	= "";
		var comboInitVal 	= "";
		
		//현재 ROW 를 결정한다.(Multi Coverage 에서는 여러줄에 복사를 할 경우 발생되는 문제점을 처리하기 위함) +++++++++++++++++++++++++++++++++
		sRow = sheetObj.SelectRow;
		if (sheetObj.id == "sheet2" && ComGetObjValue(formObj.select_row) != "") {
			sRow = ComGetObjValue(formObj.select_row);
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
		
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
	function addComboItem(comboObj,comboDatas,isOnlyCode) {
		var comboItem;
		var comboItems;
		var val;
		var txt;
		if (comboDatas != undefined) {
			ComClearCombo(comboObj);
			comboItems = comboDatas.split(ROWMARK);
	    	for (var i = 0 ; i < comboItems.length ; i++) {
    			comboItem = comboItems[i].split(FIELDMARK);
				val = comboItem[0];
				txt = isOnlyCode ? comboItem[0] : comboItem[1];
				ComAddComboItem(comboObj,txt,val);
    		}
		}   		
	}
     
 	/**
      * 멀티콤보필드에 데이터를 추가해준다.
      */	
 	function addMultiComboItem(comboObj, comboItems) {
     	for (var i = 0 ; i < comboItems.length ; i++) {
     		var comboItem = comboItems[i].split(FIELDMARK);
 			comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
     	}
 	}     
	
	/**
 	 * Max Version 
 	 * 조회해서 그 결과를 반환한다.
 	 */
	function getMaxVersion(versions) {
		var ver_item;
		var ver_items;
		var val;
		if (versions != undefined) {
			ver_items = versions.split(ROWMARK);
	    	for (var i = 0 ; i < ver_items.length ; i++) {
    			ver_item = ver_items[i].split(FIELDMARK);
    			val = ver_item[1];
    			break;
    		}
		}
		return val; 
	}
	/**
 	 * Max Version Status 
 	 * 조회해서 그 결과를 반환한다.
 	 */
	function getMaxVersionStatus(versions) {
		var ver_item;
		var ver_items;
		var val;
		if (versions != undefined) {
			ver_items = versions.split(ROWMARK);	
	    	for (var i = 0 ; i < ver_items.length ; i++) {
	    		ver_item = ver_items[i].split(FIELDMARK);
				val = ver_item[0];
				break;
    		}
		}
		
		if (val.indexOf(":") != -1) {
			var stsArr = val.split(":");
			val = stsArr[0]; 
		}
		return val;
	}
	 	
    /**
     * Rate Adjustment 가 필수항목인지 조회해서 Validation Check 및 컨트롤들 상태변경시에 사용됨.
     */	
	function setMandatoryRTAdjust(selectedRow) {
    	var formObj 	= document.form;
		var sheetRFAObj = sheetObjects[0];
		var sheetRTObj 	= sheetObjects[2];


		/* Tariff Type 이 CTIC, CTOC 일 경우에 DMT_CALC_TP 테이블에 Coverage 정보에 해당되는 
		 * 데이터가 있을 경우 Rate Adjustment 는 선택항목이 된다.
		 * 항목이 없을 경우 DMT_DUL_TP_EXPT 테이블에 Bound, EFF/EXP DT, Coverage, CNTR/Cargo Type
		 * Customer 에 해당되는 데이터가 있을 경우 필수항목이 된다.
		 * 그렇지 않으면 선택항목이 된다.
		*/
		var tariff = sheetRFAObj.CellValue(selectedRow, TARIFF);
		if (tariff == "CTIC" || tariff == "CTOC") {
			//필수항목여부
			var isMandatory = "N";
			
			//필수항목인지 조회한다.
			doActionIBSheet(sheetRTObj, formObj, IBSEARCH);
			
			if (ComTrim(ComGetObjValue(formObj.result)) == "M") {
				isMandatory = "Y";
			}
			//조회한 결과를 필드에 저장한다.
			sheetRFAObj.CellValue(selectedRow, RT_MANDATORY) = isMandatory;
		} 
		else {
			sheetRFAObj.CellValue(selectedRow, RT_MANDATORY) = "N";
		}
	}
		
    /**
     * Rate Adjustment Sheet 의 Currency 를 조회하는 함수
     */	
	function searchCurrencyList(selectedRow) {
    	var formObj 	= document.form;
    	var sheetRFAObj	= sheetObjects[0];
		var sheetRTObj 	= sheetObjects[2];
	
		if (ComTrim(sheetRFAObj.CellValue(selectedRow, CVRG_CNT)) != "") {
			doActionIBCommon(sheetRTObj, formObj, IBSEARCH, COMMAND05, "CURRENCY");
		}
	}

    /**
     * 선택된 DTL ROW 에 해당되는 Origin(I) or Dest.(O) Country 를 조회하는 함수
     */	
	function getOriginOrDestinationCNT(selectRow) {
		var sheetObj = sheetObjects[0];
		var sheetObj1 = sheetObjects[1];
		var cntCd = "";
				
		if (sheetObj.CellValue(selectRow, ORGDST_MULTI) == "S") {
			cntCd = ComTrim(sheetObj.CellValue(selectRow, ORGDST_CNT));
		}
		else if (fetchRowCount(selectRow, sheetObj1) > 0) {
			cntCd = ComTrim(sheetObj1.CellValue(sheetObj1.HeaderRows, ORGDST_CNT))				
		}
		return cntCd;	
	}

    /**
     * 선택된 Currency 값을 Group Sheet 의 선택된 Row 의 Currency 필드에 설정해준다.
     */
	function setCurrencyVal() {
    	 var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];
		
		with(sheetRFAObj) {
			CellValue(SelectRow, CURR_CD) = ComTrim(ComGetObjValue(formObj.currency));
		}
	}
	
	/**
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setComboParameters(sheetObj, sAction, sComboKey) {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];

		ComSetObjValue(formObj.f_cmd, sAction);			//Command
		
		with(sheetObj) {
			if (sComboKey.indexOf("fnl") != -1 && SelectRow >= HeaderRows) {
				ComSetObjValue(formObj.conti_cd, 	"");
				ComSetObjValue(formObj.cnt_cd, 		CellValue(SelectRow, BKGDEL_CNT));		//BKG DEL(I) or POR(O) CN
	
				rgnCd = ComTrim(CellValue(SelectRow, BKGDEL_RGN));
				if (rgnCd.length == 2) 
					ComSetObjValue(formObj.ste_cd, rgnCd);		//BKG DEL(I) or POR(O) STE
				else 
					ComSetObjValue(formObj.rgn_cd, rgnCd);		//BKG DEL(I) or POR(O) RGN				
				
				ComSetObjValue(formObj.loc_cd, 		CellValue(SelectRow, BKGDEL_LOC));		//BKG DEL(I) or POR(O) LOC				
			}
			else if (sComboKey.indexOf("org") != -1 && SelectRow >= HeaderRows) {
				ComSetObjValue(formObj.conti_cd, 	CellValue(SelectRow, ORGDST_CTI));		//Origin(I) or Dest.(O) CT
				ComSetObjValue(formObj.cnt_cd, 		CellValue(SelectRow, ORGDST_CNT));		//Origin(I) or Dest.(O) CN
				
				rgnCd = ComTrim(CellValue(SelectRow, ORGDST_RGN));
				if (rgnCd.length == 2) 
					ComSetObjValue(formObj.ste_cd, rgnCd);		//Origin(I) or Dest.(O) STE
				else 
					ComSetObjValue(formObj.rgn_cd, rgnCd);		//Origin(I) or Dest.(O) RGN				
				
				ComSetObjValue(formObj.loc_cd, 		CellValue(SelectRow, ORGDST_LOC));		//Origin(I) or Dest.(O) LOC				
			}
			//Rate Adjustment 의 Currency 콤보의 조회조건을 채워준다.
			else if (sComboKey == "CURRENCY" && sheetRFAObj.SelectRow >= sheetRFAObj.HeaderRows) {
				ComSetObjValue(formObj.cnt_cd, 		sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_CNT));
			}
			else if (SelectRow >= HeaderRows) {
				ComSetObjValue(formObj.conti_cd, 	"");
				ComSetObjValue(formObj.cnt_cd, 		CellValue(SelectRow, CVRG_CNT));		//Coverage CN
				
				rgnCd = ComTrim(CellValue(SelectRow, CVRG_RGN));
				if (rgnCd.length == 2) 
					ComSetObjValue(formObj.ste_cd, rgnCd);		//Coverage STE
				else 
					ComSetObjValue(formObj.rgn_cd, rgnCd);		//Coverage RGN		
				
				ComSetObjValue(formObj.loc_cd, 		CellValue(SelectRow, CVRG_LOC));		//Coverage LOC
			}
		}
	}

	/**
	 * Before Booking Request Detail 에 등록된  데이터 조회하는 동작을 정의하는 함수
	 */		
	function doActionRetrieve(sAction) {
		var formObj 	= document.form;
		var cboDARObj 	= comboObjects[0];
		var cboAPVLObj	= comboObjects[1];
		var sheetRFAObj = sheetObjects[0];

		//1.Proposal No. 에 대한 최상위 Version 정보를 조회한다.
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER);
		
		//2.조회된 Ver No. 목록중 최상위 Ver No. 가 승인일 경우 APVL No.를 조회한다.
		if (getVerStatus("Code") == "A") {
			
			//조회조건을 설정한다.
			ComSetObjValue(formObj.prop_no, 			"");
			ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(cboDARObj.Text));
			ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
			ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
			
			//조회를 실행한다.
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO);
		}
		//2-1.승인된 버전이 아닐경우에는 APVL No. 를 Clear 해준다.
		else {
			cboAPVLObj.RemoveAll();
		}
		
		//3.최상위 Version 정보로 Before Exception Request 정보를 조회한다.
		doActionRetrieveByVer(sAction);
	}
	 
	/**
	 * 조회조건으로 Before Booking Request 조회를 실행하고 추가적인 동작을 정의하는 함수
	 */		 
	function doActionRetrieveByVer(sAction) {
		var formObj 		= document.form;
		var cboDARObj 		= comboObjects[0];
		var sheetRFAObj		= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		var sheetRTObj		= sheetObjects[2];
		var sheetHSTObj		= sheetObjects[3];
		
		//1.조회전에 Status 필드를 초기화한다.
		ComSetObjValue(formObj.status, getVerStatus("Text"));
		
		//2.DEM/DET Adjustment Request - Before Booking Request 정보와 Comment History 정보를 조회한다.
		doActionIBSheet(sheetRFAObj, formObj, sAction);

		//--------------------------------------------------------------------
		currDtlSeq = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DTL_SEQ);
		//--------------------------------------------------------------------
		
		//3.Before Booking Request Detail 의 조회결과가 있다면 현재 선택된 Detail Seq. 의 하위항목을 조회한다.
		if (sheetRFAObj.RowCount > 0) {

			if ((getVerStatus("Code") == "T" || getVerStatus("Code") == "O") && ComGetObjValue(formObj.isEditable) == "Y")
				//임시 저장 상태이고, 수정권한이 있을 경우 입력가능모드로 변경한다.(버튼 포함)
				editableDetail(true);
			else
				editableDetail(false);
			
			//선택한 Detail Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
			setSubBeforeException(true);
		}
		else {
			if (ComGetObjValue(formObj.isEditable) == "Y")
				//조회된 결과가 없고 Version 이 1 이며, 수정권한이 있을 경우 입력가능모드로 변경한다.(버튼 포함)
				editableDetail(true);
			else
				editableDetail(false);

			//하위 그리드를 초기화 시킨다.
			sheetCVRGObj.RemoveAll();
			sheetRTObj.RemoveAll();
			sheetHSTObj.RemoveAll();
			
			//하위 정보들을 초기화 시킨다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
			setSubBeforeException(false);
		}
		
		//4.메인 버튼의 상태를 주어진 조건에 따라서 활성화 or 비활성화 시킨다.
		initBtnControl();
		
		//5.쉬트 정렬의 활성화/비활성화 시킨다.
		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
			sheetRFAObj.InitHeadMode(false, false, false, false, false, false);
		}
		else {
			sheetRFAObj.InitHeadMode(true, false, false, false, false, false);
		}
	}
	
   /**
	* Before Exception Request 의 Detail 목록중 선택한 Detail Seq. 변경되었을 경우 하위 항목의 상태를 변경한다.
	*/	
    function setSubBeforeException(isRetrieve) {
		var formObj 	= document.form;
		var sheetRFAObj = sheetObjects[0];
		
		//Detail Seq. 의 하위 항목을 조회한다.
		if (isRetrieve) {
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_SUB);
		}
		
		//1.선택된 Tariff 타입에 따라서 Multi Coverage 의 제목이 변경된다.(2009-07-28)
		setMultiOrgDestTitle();

		//2.Multi Coverage 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setMultiOrgDestGrid();
		
		//3.Rate Adjustment 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setRateAdjustmentGrid();
	}

   /**
	* Before Booking Request 의 Multi Origin or Dest. 상태를 변경해주는 함수
	*/
	function setMultiOrgDestGrid() {
		var formObj 	= document.form;
		var sheetRFAObj = sheetObjects[0];
		
		with(sheetRFAObj) {
			//=================================================================================================================================
			// Origin or Dest. 의 Multi 타입이 Multi 일 경우에는 Multi Origin or Dest. 체크박스를 체크해준다.
			//=================================================================================================================================
			if (CellValue(SelectRow, ORGDST_MULTI) == "M") {
				formObj.chkMultiOrgDest.checked 	= true;
				
				//Detail 그리드의 Origin or Dest. 컬럼을 모두 비활성화 시킨다.
				CellEditable(SelectRow, ORGDST_CTI) = false;
				CellEditable(SelectRow, ORGDST_CNT) = false;
				CellEditable(SelectRow, ORGDST_RGN) = false;
				CellEditable(SelectRow, ORGDST_LOC) = false;
				
				//Multi Origin or Dest. 그리드의 모든 컬럼을 수정가능한 상태일 경우 모두 활성화 시키고, 그렇지 않을 경우 모두 비활성화 시킨다.
				if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
					editableMultiOrgDest(true);
				}
				else {
					editableMultiOrgDest(false);
				}
			}
			else {
				formObj.chkMultiOrgDest.checked = false;
	
				//Group 그리드의 Coverage 컬럼을 수정가능한 상태일 경우 모두 활성화 시키고, 그렇지 않을 경우 모두 비활성화 시킨다.
				if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
					CellEditable(SelectRow, ORGDST_CTI) = true;
					CellEditable(SelectRow, ORGDST_CNT) = true;
					CellEditable(SelectRow, ORGDST_RGN) = true;
					CellEditable(SelectRow, ORGDST_LOC) = true;
				}
				else {
					CellEditable(SelectRow, ORGDST_CTI) = false;
					CellEditable(SelectRow, ORGDST_CNT) = false;
					CellEditable(SelectRow, ORGDST_RGN) = false;
					CellEditable(SelectRow, ORGDST_LOC) = false;
				}
				
				//Multi Origin or Dest. 그리드의 모든 컬럼을 비활성화 시킨다.
				editableMultiOrgDest(false);	
			}
		}
	}
	
   /**
	* Before Booking Request 의 Rate Adjustment 상태를 변경해주는 함수
	*/
	function setRateAdjustmentGrid() {
		var formObj 	= document.form;
		var sheetRFAObj = sheetObjects[0];
		
		with(sheetRFAObj) {
			//=================================================================================================================================
			// Rate Adjustment 의 체크박스를 체크해준다.
			//=================================================================================================================================
			if (CellValue(SelectRow, RT_CHECK) == "Y") {
				formObj.chkRateAdjustment.checked = true;
			}
			else {
				formObj.chkRateAdjustment.checked = false;
			}

			//Currency 항목을 모두 지워준다.
			ComClearCombo(formObj.currency);

			//Coverage Country 에 해당하는 Currency 정보를 조회한다.
			searchCurrencyList(SelectRow);

			//Before Exception Request 에 등록된 Currency 가 있을 경우에는 조회한 Currency 목록에서 선택해준다.
			var currCd = CellValue(SelectRow, CURR_CD);
			if (currCd != "" && formObj.currency.length > 0) {
				ComSetObjValue(formObj.currency, currCd);
			}

			//Rate Adjustment 그리드의 모든 컬럼을 수정가능한 상태일 경우 모두 활성화 시키고, 그렇지 않을 경우 모두 비활성화 시킨다.
			if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
				editableRateAdjustment(true);
			}
			else {
				editableRateAdjustment(false);
			}
		}
	}
		
    /**
	 * Before Booking Request 의 Free Time 의 Y 컬럼 체크여부에 따라서 연관된 필드들의 상태와 값을 변경한다. 
	 */		
	function setFreeTimeByMandatory(sheetObj, Row, Col) {
	 
		with(sheetObj) {
			//체크박스 선택시
			if (CellValue(Row, Col) == "1") {
				CellEditable(Row, ADD_DYS) = true;
				CellEditable(Row, TOT_DYS) = true;
				CellEditable(Row, SAT_FLG) = true;
				CellEditable(Row, SUN_FLG) = true;
				CellEditable(Row, HOL_FLG) = true;
			}
			//체크박스 선택 해제시
			else {
				CellValue(Row, ADD_DYS) = "";
				CellValue(Row, TOT_DYS) = "";
				CellValue(Row, SAT_FLG) = "";
				CellValue(Row, SUN_FLG) = "";
				CellValue(Row, HOL_FLG) = "";
				
				CellEditable(Row, ADD_DYS) = false;
				CellEditable(Row, TOT_DYS) = false;
				CellEditable(Row, SAT_FLG) = false;
				CellEditable(Row, SUN_FLG) = false;
				CellEditable(Row, HOL_FLG) = false;			
			}
		}
	}
	
	/**
	 * NEW 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */		
	function doActionNew() {
		var formObj 	= document.form;
		var cboDARObj	= comboObjects[0];
		var cboAPVLObj	= comboObjects[1];
		var sheetRFAObj	= sheetObjects[0];
		
		//New 버튼 클릭시 APVL OFC, DAR No., Version, APVL No. 을 변경할 수 있도록 활성화(2009-11-13(금))=============================
		enableSearchFields(true);
		//============================================================================================================================
		
		//1.화면 Load 시 비활성화될 컨트롤들을 초기화 시킨다.
		initDisableObjects();
		
		//2.Approval Office 에 해당되는 DAR 목록 조회를 수행한다.
		ComSetObjValue(formObj.apro_ofc_cd, ComGetObjValue(formObj.approvalOfcCd));		
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR);
		
		//2.Proposal No 가 있을 경우에만 아래 내용을 조회한다.
		if (ComTrim(ComGetObjValue(formObj.proposalNo)) != "") {
			
			//2-1.DEM/DET Adjustment Request Exception 에 등록된 데이터를 조회한다.
			doActionRetrieve(IBSEARCH);
		}
		else {
			//2-2.Version 를 초기값으로 설정해준다.
			addComboItem(formObj.version, "001=", true);
			
			//2-3.메인 버튼의 상태를 주어진 조건에 따라서 활성화 or 비활성화 시킨다.
			initBtnControl();
		}	
	}
			
	/**
	 * UPDATE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionUpdate() {
		var formObj 	= document.form;
		var cboDARObj	= comboObjects[0];
		var cboAPVLObj 	= comboObjects[1];
		var sheetRFAObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================
		
		//result[0] : 검사결과, result[1] : 해당 Version 정보 +++++++++++++++++++++++++++++++++++++++++++++++++++++
		var result = isApprovedInPrevVersion();

		if (result[0]) {
			//Update 버튼 클릭시 동일 DAR의 기존 Version의 Status가 Approved인 건이 있으면 
			//When the new version is approved, Approved version [] will be cancelled. 
			//'Do you want to update to the new version?' Alert창 띄우며 Yes 선택시 조치 
			if (!ComShowCodeConfirm("DMT01122", result[1])) { return; }	
		}
		else {
			//Update 버튼 클릭시 동일 DAR의 기존 Version의 Status가 Approved인 건이 없으면 
			//'Do you want to update to a new version?' Alert창 띄우며 Yes 선택시 조치
			if (!ComShowCodeConfirm("DMT00135", "update the version")) { return; }	
		}
		
		var rfaVerSts = getVerStatus("Code"); 
		if (rfaVerSts == "A" || rfaVerSts == "J") {

			var bzcRfaYn = ComGetObjValue(formObj.bzc_rfa_yn);
			
			if (bzcRfaYn == "Y")
				// Master RFA 의 승인된 상위버전을 Copy 해서 신규 버전에 저장을 한다.
				doActionIBSheet(sheetRFAObj, formObj, IBSAVE_AUTO_UPDATE);
			else
				// 현재 버전의 Before Booking Request 정보를 신규 버전에 저장을 한다.
				doActionIBSheet(sheetRFAObj, formObj, IBSAVE_RFATARIFF_UPDATE);
			
			if (ComGetObjValue(formObj.result) == "Y") {

				//버전이 증가되었기 때문에 버전 정보를 새로 조회해서 Version 컬럼에 설정해준다.
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER);
				
				//Status 값을 설정해 준다.
				ComSetObjValue(formObj.status, getVerStatus("Text"));
				
				//Status 는 Temp. Saved 이기 때문에 APVL No. 를 Clear 시켜준다.
				cboAPVLObj.RemoveAll();
				
				//Before Booking Request 조회를 실행하고 그 결과에 따라 추가적인 동작을 실행한다.
				doActionRetrieve(IBSEARCH);
			}
			else {
				ComShowCodeMessage("DMT00008", "update");
				return;
			}
		}
		else {
			//Update버튼 클릭시 APVL OFC, DAR No., Version, APVL No. 을 변경하지 못하도록 비활성화(2009-11-13(금))=============================
			enableSearchFields(false);
			//============================================================================================================================
			
			//STS 컬럼을 공란으로 변경한다.
			ComClearObject(formObj.status);	
			
			//Before Booking Request 의  Detail Grid 의 모든 컬럼들을 입력가능하도록 활성화 시킨다.
			editableDetail(true);
			
			//선택한 Detail Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
			setSubBeforeException(false);
			
			//Update 버튼이 클릭된 경우 오직 Request 만 가능하다.
			//물론, New, Close 버튼은 언제나 활성화다
			ComBtnEnable(	"btn_New"			);
			ComBtnDisable(	"btn_Update"		);
			ComBtnEnable(	"btn_Request"		);
			ComBtnDisable(	"btn_Cancel"		);
			ComBtnDisable(	"btn_Approval"		);
			ComBtnDisable(	"btn_CounterOffer"	);
			ComBtnDisable(	"btn_Reject"		);
			ComBtnEnable(	"btn_Close"			);		
		}

		//쉬트 정렬의 활성화/비활성화 시킨다.
		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
			sheetRFAObj.InitHeadMode(false, false, false, false, false, false);
		}
		else {
			sheetRFAObj.InitHeadMode(true, false, false, false, false, false);
		}
	}				
		
	/**
	 * REQUEST 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionRequest() {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];
		var cboDARObj 	= comboObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================

		//=====================================================================================================
		//DAR NO가 없을때 Approval Office 에 대한 모든 DAR 정보를 조회하여 존재여부를 체크 한다.
		if (ComTrim(cboDARObj.Text) == "") {
			if(!doActionCheckByApprovalOfc()) {
				return;
			}
		}
		//=====================================================================================================
		
		//1.Request 버튼 클릭시 데이터가 있는지 검사한다.
		if (fetchRowCount(sheetRFAObj) == 0) {
			ComShowCodeMessage("DMT01117", "request");
			return;
		}

		//2.Request 실행시 Comment 는 필수입력사항이다.	
		if (!validateComment()) return;

		//3.Request 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구
		var chkResult = isChangedBeforeException();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				//변경된 내용에 대한 SAVE 수행 후 변경된 내용만 조회해서 그리드에 설정.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
				if (!saveBKGReqDetail(chkResult[0])) return;
				
			}
			else {
				//Save 되지 않은 줄이 있다면 Request 작업을 중지한다.
				return;
			}
		}
		
		//Request Action 을 수행한다.			
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_REQUEST);
		
		//저장 Action 이 정상실행시 조회를 실행한다.
		if (ComGetObjValue(formObj.result) == "Y") {

			//Request, Cancel, Approval, Counter Offer, Reject 버튼 클릭 이후에는 APVL OFC, DAR No, Version, APVL No. 모두 활성화 상태로 재조회
			enableSearchFields(true);
			
			doActionRetrieve(IBSEARCH);
		}	
	}

	/**
	 * CANCEL 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionCancel() {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================
		
		if (!ComShowCodeConfirm("DMT00135", "cancel this version")) { return; }
		
		//Cancel Action 을 수행한다.			
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_CANCEL);
		
		//저장 Action 이 정상실행시 조회를 실행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			
			//Request, Cancel, Approval, Counter Offer, Reject 버튼 클릭 이후에는 APVL OFC, DAR No, Version, APVL No. 모두 활성화 상태로 재조회
			enableSearchFields(true);
			
			doActionRetrieve(IBSEARCH);
		}		
	}
	
	/**
	 * APPROVAL 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionApproval() {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================

		if (!ComShowCodeConfirm("DMT00135", "approve")) { return; }
		
		//APPROVAL 실행시 Comment 는 필수입력사항이다.				
		if (!validateComment()) return;
		
		//Approval Action 을 수행한다.			
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_APPROVAL);
		
		//저장 Action 이 정상실행시 조회를 실행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			
			//Request, Cancel, Approval, Counter Offer, Reject 버튼 클릭 이후에는 APVL OFC, DAR No, Version, APVL No. 모두 활성화 상태로 재조회
			enableSearchFields(true);
			
			doActionRetrieve(IBSEARCH);		
		}		
	}
	
	/**
	 * COUNTER OFFER 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionCounterOffer() {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================	
			
		if (!ComShowCodeConfirm("DMT00135", "counter offer")) { return; }
					
		//COUNTER OFFER 실행시 Comment 는 필수입력사항이다.				
		if (!validateComment()) return;
		
		//Counter Offer Action 을 수행한다.			
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_COUNTER);

		//저장 Action 이 정상실행시 조회를 실행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			
			//Request, Cancel, Approval, Counter Offer, Reject 버튼 클릭 이후에는 APVL OFC, DAR No, Version, APVL No. 모두 활성화 상태로 재조회
			enableSearchFields(true);

			doActionRetrieve(IBSEARCH);	
		}		
	}
	
	/**
	 * REJECT 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionReject() {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================	
			
		if (!ComShowCodeConfirm("DMT00135", "reject")) { return; }
						
		//REJECT 실행시 Comment 는 필수입력사항이다.				
		if (!validateComment()) return;
						
		//Reject Action 을 수행한다.			
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_REJECT);
		
		//저장 Action 이 정상실행시 조회를 실행한다.
		if (ComGetObjValue(formObj.result) == "Y") {

			//Request, Cancel, Approval, Counter Offer, Reject 버튼 클릭 이후에는 APVL OFC, DAR No, Version, APVL No. 모두 활성화 상태로 재조회
			enableSearchFields(true);
			
			doActionRetrieve(IBSEARCH);	
		}		
	}				
	
	/**
	 * CLOSE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionClose() {

		//1.Close 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구
		var chkResult = isChangedBeforeException();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT00147")) {
				self.close();
			}
			return;
		}
				
		self.close();		
	}
		
	/**
	 * 새로 채번된 DAR No. 를 Before Booking Request Detail Grid 내의 모든 데이터에 갱신해준다. 
	 */			
	function setDarNoBKGReqDetail(darNo) {
		sheetObj = sheetObjects[0];
		setDarNoGridItem(darNo, sheetObj);
	}
	
	/**
	 * 새로 채번된 DAR No. 를 Multi Origin or Destination Grid 내의 모든 데이터에 갱신해준다. 
	 */			
	function setDarNoMultiOriginOrDestination(darNo) {
		sheetObj = sheetObjects[1];
		setDarNoGridItem(darNo, sheetObj);
	}
	
	/**
	 * 새로 채번된 DAR No. 를 Rate Adjustment Grid 내의 모든 데이터에 갱신해준다. 
	 */			
	function setDarNoRateAdjustment(darNo) {
		sheetObj = sheetObjects[2];
		setDarNoGridItem(darNo, sheetObj);
	}
		
	/**
	 * 새로 채번된 DAR No. 를 주어진  Grid 내의 모든 데이터에 갱신해준다. 
	 */				
	function setDarNoGridItem(darNo, sheetObj) {
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				CellValue(row, DAR_NO) = darNo;			
			}
		}
	}
	
	/**
	 * Before Booking Request Detail Grid 내의 Coverage 와 Origin or Dest. 정보를 
	 * Multi Origin or Destination Grid 내의 데이터로 옮겨 놓는다.
	 */		
	function copyBKGDetailReqCoverageforSave() {
		var sheetRFAObj		= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		
		with(sheetRFAObj) {
			var prevOrgDestMulti 	= ComTrim(CellValue(SelectRow, CURR_ORGDST_MULTI));
			var currOrgDestMulti	= ComTrim(CellValue(SelectRow, ORGDST_MULTI));
		}		

		/**
		 * Multi 구분이 
		 * 1. Single 에서 Single 일 경우 플래그 상태를 	'U' 로 변경하고 수정 처리한다.
		 * 2. Single 에서 Multi 	 일 경우 플래그 상태를 	'D' 로 변경해서 삭제 처리한다.
		 * 3. Multi 에서 Single 	 일 경우 플래그 상태를 	'I' 로 변경하고 입력 처리한다.
		 * 4. Multi 에서 Multi  	 일 경우 플래그 상태를 	'U' 로 변경하고 수정 처리한다.
		 */
		with(sheetCVRGObj) {
			//=================================================================================================
			//1. Single 에서 Single 일 경우 플래그 상태를 'U' 로 변경하고 수정 처리한다.								
			//=================================================================================================
			if (prevOrgDestMulti == "S" && currOrgDestMulti == "S") {
				DataInsert(-1);
				RowHidden(LastRow) = true;
				
				//기본키 값 설정
				CellValue2(LastRow, DAR_NO) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DAR_NO);
				CellValue2(LastRow, MAPG_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, MAPG_SEQ);
				CellValue2(LastRow, VER_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, VER_SEQ);
				CellValue2(LastRow, DTL_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DTL_SEQ);
				CellValue2(LastRow, CVRG_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_SEQ);
				CellValue2(LastRow, CVRG_CTI) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_CTI);
				CellValue2(LastRow, CVRG_CNT) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_CNT);
				CellValue2(LastRow, CVRG_RGN) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_RGN);
				CellValue2(LastRow, CVRG_LOC) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_LOC);
				CellValue2(LastRow, ORGDST_CTI) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, ORGDST_CTI);
				CellValue2(LastRow, ORGDST_CNT) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, ORGDST_CNT);
				CellValue2(LastRow, ORGDST_RGN) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, ORGDST_RGN);
				CellValue2(LastRow, ORGDST_LOC) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, ORGDST_LOC);
				
				//Row 의 상태설정이 제대로 반영되기 위해서는  값 설정해주고 난 후 에 지정해줘야 한다.
				RowStatus(LastRow) = "U";
			}
			//=================================================================================================
			//2. Single 에서 Multi 일 경우 플래그 상태를 'D' 로 변경해서 삭제 처리하고, 
		 	//   Multi Origin or Dest. 에 Coverage 정보를 추가한다.
		 	//=================================================================================================
			else if (prevOrgDestMulti == "S" && currOrgDestMulti == "M") {
				//삭제된 Origin(I) or Dest(O) 를 실제로 서버에서 처리하기 위해서 삭제될 정보를 임의추가된 ROW 에
				//설정해서 날려준다.
				DataInsert(-1);
				//상태값을 'U' 로 설정하지 않고 곧바로 'D' 로 설정하면  ROW 가 삭제되어 서버에 아래 내용이 전달되지 않음
				RowStatus(LastRow) = "U";
				RowHidden(LastRow) = true;
				
				//기본키 값 설정
				CellValue2(LastRow, DAR_NO) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DAR_NO);
				CellValue2(LastRow, MAPG_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, MAPG_SEQ);
				CellValue2(LastRow, VER_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, VER_SEQ);
				CellValue2(LastRow, DTL_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DTL_SEQ);
				CellValue2(LastRow, CVRG_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_SEQ);			
				
				//Row 의 상태설정이 제대로 반영되기 위해서는  값 설정해주고 난 후 에 지정해줘야 한다.
				RowStatus(LastRow) = "D";
				
				//2010-03-21일 신규 추가된 Multi Origin or Destination 에 Coverage 정보를 설정해 준다.
				for (var row = HeaderRows ; row <= LastRow ; row++) {
					CellValue2(row, CVRG_CTI) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_CTI);
					CellValue2(row, CVRG_CNT) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_CNT);
					CellValue2(row, CVRG_RGN) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_RGN);
					CellValue2(row, CVRG_LOC) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_LOC);
				}
				
			}
			//=================================================================================================
			//3. Multi 에서 Single 일 경우 플래그 상태를 'I' 로 변경하고 입력 처리한다.
			//=================================================================================================
			else if ((prevOrgDestMulti == "M" || prevOrgDestMulti == "") && currOrgDestMulti == "S") {
				DataInsert(-1);
				RowHidden(LastRow) = true;
				
				//기본키 값 설정
				CellValue2(LastRow, DAR_NO) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DAR_NO);
				CellValue2(LastRow, MAPG_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, MAPG_SEQ);
				CellValue2(LastRow, VER_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, VER_SEQ);
				CellValue2(LastRow, DTL_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DTL_SEQ);
				CellValue2(LastRow, CVRG_SEQ) 	= "1";	
				CellValue2(LastRow, CVRG_CTI) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_CTI);
				CellValue2(LastRow, CVRG_CNT) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_CNT);
				CellValue2(LastRow, CVRG_RGN) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_RGN);
				CellValue2(LastRow, CVRG_LOC) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_LOC);
				CellValue2(LastRow, ORGDST_CTI) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, ORGDST_CTI);
				CellValue2(LastRow, ORGDST_CNT) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, ORGDST_CNT);
				CellValue2(LastRow, ORGDST_RGN) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, ORGDST_RGN);
				CellValue2(LastRow, ORGDST_LOC) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, ORGDST_LOC);
				
				//Row 의 상태설정이 제대로 반영되기 위해서는  값 설정해주고 난 후 에 지정해줘야 한다.
				RowStatus(LastRow) = "I";					
			}
			//=================================================================================================
			//4. Multi 에서 Multi 일 경우 플래그 상태를 기존 상태로 그대로 유지해준다.
			//=================================================================================================
			else if ((prevOrgDestMulti == "M" || prevOrgDestMulti == "") && currOrgDestMulti == "M") {
				
				for (var subRow = HeaderRows ; subRow <= LastRow ; subRow++) {
					
					CellValue2(subRow, CVRG_CTI) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_CTI);
					CellValue2(subRow, CVRG_CNT) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_CNT);
					CellValue2(subRow, CVRG_RGN) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_RGN);
					CellValue2(subRow, CVRG_LOC) = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_LOC);
				}
			}			
		}
	}

	/**
	 * Before Booking Request Grid 내의 Origin or Dest. 정보를 저장을 위해서 Multi Origin or Dest Grid 내의 데이터로 옮겨 놓은 데이터를 삭제한다.
	 */		
	function releaseBKGDetailReqCoverageforSave() {
		var sheetCVRGObj 	= sheetObjects[1];
		
		with(sheetCVRGObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (RowHidden(row)) {
					RowDelete(row, false);
				}
			}
		}
	}
		
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */	 
	function validateForm(reqType) {
    	var formObj 		= document.form;
		var sheetRFAObj 	= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		var sheetRTObj		= sheetObjects[2];
		 
		//저장할 데이터가 없을 경우
		if (fetchRowCount(sheetRFAObj) == 0) {
			ComShowCodeMessage("DMT00128");
			return false;
		}		
		
		//건 단위로 추가, 수정이 발생하기 때문에 건 단위 처리만 하면 됨.
		with(sheetRFAObj) {
	
			//생성,수정,삭제된 정보가 있는지 검색한다.
			var chkResult = isChangedBeforeException(1); //파라미터로 전달되는 1은 Sheet Index No. 이다.
	
			if (RowStatus(SelectRow) == "I" || RowStatus(SelectRow) == "U" || chkResult[0]) {
				
				//==================================================================================================
				//1.APVL OFC Check
				//==================================================================================================
				if (ComTrim(ComGetObjValue(formObj.approvalOfcCd)) == "") {
					ComShowCodeMessage("DMT02002", "APVL OFC");
					ComSetFocus(formObj.approvalOfcCd);
					return false;			
				}
				
				//==================================================================================================
				//2-1.EFF DT Check
				//==================================================================================================		
				if (CellValue(SelectRow, EFF_DT) == "") {					
					ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "EFF DT");
					return false;
				}
				
				//==================================================================================================
				//2-2.EXP DT Check
				//==================================================================================================
				if (CellValue(SelectRow, EXP_DT) == "") {
					ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "EXP DT");
					return false;
				}
				
				//==================================================================================================
				//2-3.EXP DT 는 EFF DT 와 같거나 큰 날짜가 들어가도록 함
				//==================================================================================================
				if (ComGetDaysBetween(CellValue(SelectRow, EXP_DT), CellValue(SelectRow, EFF_DT)) > 0) {
	    			ComShowCodeMessage("COM12133", "'EFF DT'", "'EXP DT'", "earlier");
	    			return false;	    			
	    		}				
				
				//==================================================================================================
				//3.CNTR/Cargo Type Check
				//==================================================================================================				
				if (CellValue(SelectRow, CNTRCGO) == "") {
					ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "CNTR/Cargo Type");
					return false;
				}
				
				//==================================================================================================
				//4.Coverage Check
				//==================================================================================================
				if (CellValue(SelectRow, CVRG_CNT) == "") {
					ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "Coverage CN");
					return false;
				}
				
				//==================================================================================================
				//5.Free Time Check
				//==================================================================================================
				if (CellValue(SelectRow, FT_FLG) == 1) {
					if (CellValue(SelectRow, ADD_DYS) != "" && CellValue(SelectRow, TOT_DYS) != "") {
						ComShowCodeMessage("DMT02004", CellValue(SelectRow, "Seq"));
						return false;
					} 
					else if (CellValue(SelectRow, ADD_DYS) == "" && CellValue(SelectRow, TOT_DYS) == "") {
						ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "Free Time");
						return false;						
					}
				}
				else {
					//변경관리 추가사항으로 F/Time 또는 Rate 필수입력
					if (CellValue(SelectRow, RT_CHECK) == "N") {
						ComShowCodeMessage("DMT02028", CellValue(SelectRow, "Seq"));
						return false;
					}
				}
				
				//==================================================================================================
				//6.Origin(I) or Dest.(O) Validate Check
				//==================================================================================================				
				//6-1.Single Origin(I) or Dest.(O) 에서 CT 는 필수항목이다.
				if (CellValue(SelectRow, ORGDST_MULTI) == "S") {
					if (ComTrim(CellValue(SelectRow, ORGDST_CTI)) == "") {
						ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "Origin(I) or Dest.(O)");
						return false;						
					}
					
					//Coverage 와 Origin(I) or Dest(O) 의 CN 이 같을 경우 에러처리..(2010-03-31)
					if (CellValue(SelectRow, CVRG_CNT) == CellValue(SelectRow, ORGDST_CNT)) {
						ComShowCodeMessage("DMT01144", CellValue(SelectRow, TARIFF).substring(2, 3) == "I" ? "Origin" : "Destination");
						return false;
					}
					
				}
				//6-2.Multi Origin(I) or Dest.(O) Data Count Check(최소 2개 이상이어야 함)
				else if (CellValue(SelectRow, ORGDST_MULTI) == "M") {
					for (var row = sheetCVRGObj.HeaderRows ; row <= sheetCVRGObj.LastRow ; row++) {
						if (sheetCVRGObj.CellValue(row, ORGDST_CTI) == "") {
							ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "Continent");
							return false;
						}
						
						//Coverage 와 Origin(I) or Dest(O) 의 CN 이 같을 경우 에러처리..(2010-03-31)
						if (CellValue(SelectRow, CVRG_CNT) == sheetCVRGObj.CellValue(row, ORGDST_CNT)) {
							ComShowCodeMessage("DMT01144", CellValue(SelectRow, TARIFF).substring(2, 3) == "I" ? "Origin" : "Destination");
							return false;
						}							
					}
					
					if (fetchRowCount(sheetCVRGObj) < 2) {
						ComShowCodeMessage("DMT00115", CellValue(SelectRow, "Seq"), "Multi Origin or Destination");
						return false;
					}
				}
				
				//==================================================================================================
				//7.Dual Type 일 경우에는 Free Time 의 Total 컬럼값은 필수이다. 
				//  Free Time 이 Multi 일 경우에는 위 Free Time Validation Check 에서 모두 걸러주기 때문에
				//  아래는 Single or 미선택시 Total 값 입력여부에 대한 체크만 하면 된다.
				//==================================================================================================
				if (CellValue(SelectRow, RT_MANDATORY) == "Y") {
					if (CellValue(SelectRow, ADD_DYS) != "" && CellValue(SelectRow, TOT_DYS) == "") {
						ComShowCodeMessage("DMT00113", CellValue(SelectRow, "Seq"));	
						return false;
					}
					else if (CellValue(SelectRow, TOT_DYS) == "") {
						ComShowCodeMessage("DMT00152", CellValue(SelectRow, "Seq"));	
						return false;
					}
				}

				//==================================================================================================
				//8.Rate Adjustment Validation Check(마지막 Row 의 Up to 컬럼은 공란이어야 하며, 아닐경우 에러처리)
				//  필수항목일 경우에는 반드시 데이터가 있어야 한다.
				//  필수항목이 아닐 경우에는 데이터가 있을 경우 그 입력값에 대해서 Validation Check 를 해야한다.
				//==================================================================================================
				var rtRowCounts = fetchRowCount(sheetRTObj);
				if (CellValue(SelectRow, RT_CHECK) == "Y") {
					if (rtRowCounts < 1) {
						ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "Rate Adjustment");
						return false;
					} 
					if (CellValue(SelectRow, CURR_CD) == "") {
						ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "Currency");
						return false;
					}
				}
				if (rtRowCounts > 0 && !validateRateAdjustment(SelectRow))
					return false;
				
				//==================================================================================================
				//9.Calculation Type Check
				//==================================================================================================
				if (!validateCalculationType(SelectRow)) 
					return false;
				
				if (!validateCalculationTypeInDM(SelectRow))
					return false;
			}
		}
		//==================================================================================================
		//10.중복데이터 체크 로직 추가(2009-07-28)
		//==================================================================================================
		if (dupValidate()) return false;	//중복데이터 체크 로직 추가(2009-07-28)
		
		return true;
	}
     
   	/**
   	 * Before Booking Request 의 화면입력에 대한 기등록된 데이터에서 중복여부를 체크하는 함수
   	 */	     
    function dupValidate() {
   		var formObj			= document.form;
   		var sheetRFAObj		= sheetObjects[0];
   		var sheetCVRGObj 	= sheetObjects[1];

   		//중복여부 조회를 위해서 필요한 매개변수를 설정해준다.
   		
   		var coverageList = "";
   		if (sheetRFAObj.CellValue(sheetRFAObj.SelectRow, ORGDST_MULTI) == "S") {
   			with(sheetRFAObj) {
 	  			coverageList 	+= convertEmptyToSpace(CellValue(SelectRow, ORGDST_CTI));
 	  			coverageList  	+= ", ";   				
 	  			coverageList 	+= convertEmptyToSpace(CellValue(SelectRow, ORGDST_CNT));
 	  			coverageList  	+= ", ";
 	  			
 	  			if (CellValue(SelectRow, ORGDST_CNT) == "CA" || CellValue(SelectRow, ORGDST_CNT) == "US") {
 	  				coverageList  	+= "' '";
 		  			coverageList  	+= ", ";
 	  				coverageList  	+= convertEmptyToSpace(CellValue(SelectRow, ORGDST_RGN));
 	  			}
 	  			else {
 	  				coverageList  	+= convertEmptyToSpace(CellValue(SelectRow, ORGDST_RGN));
 		  			coverageList  	+= ", ";
 	  				coverageList  	+= "' '";
 	  			}
 	  			
   		  		coverageList	+= ", ";	 			
 	  			coverageList  	+= convertEmptyToSpace(CellValue(SelectRow, ORGDST_LOC));
   			}
   		}
   		else {
   			with(sheetCVRGObj) {
   				for (var row = HeaderRows ; row <= LastRow ; row++) {
   					if (RowStatus(row) == "D") continue;
   					
   	 	  			coverageList 	+= convertEmptyToSpace(CellValue(SelectRow, ORGDST_CTI));
   	 	  			coverageList  	+= ", ";     					
   		  			coverageList 	+= convertEmptyToSpace(CellValue(row, ORGDST_CNT));
   		  			coverageList	+= ", ";
   		  			
 	  		  		if (CellValue(row, ORGDST_CNT) == "CA" || CellValue(row, ORGDST_CNT) == "US") {
 		  				coverageList  	+= "' '";
 			  			coverageList  	+= ", ";
 		  				coverageList  	+= convertEmptyToSpace(CellValue(row, ORGDST_RGN));
 	  		  		}
 	  		  		else {
 		  				coverageList  	+= convertEmptyToSpace(CellValue(row, ORGDST_RGN));
 			  			coverageList  	+= ", ";
 		  				coverageList  	+= "' '";
 	  		  		}

   		  			coverageList	+= ", ";  		  			
   		  			coverageList	+= convertEmptyToSpace(CellValue(row, ORGDST_LOC));
   		  			
   		  			if (row < LastRow) coverageList	+= "|";
   				}
   			}
   		}
   		
   		ComSetObjValue(formObj.coverage_list, 	coverageList);
   		
     	//중복여부를 체크한다.
     	doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_CHECK_DUP);
     	
//     	if (ComGetObjValue(formObj.result) == "Y") {
//     		ComShowCodeMessage("DMT00138", sheetRFAObj.CellValue(sheetRFAObj.SelectRow, "Seq"));
//     		return true;
//     	}
     	// 중복된 데이터정보를 보여줌.(동일 DAR NO내에 중복있을경우 우선을고 보여줌) -2012.01.06 김현화
     	if (ComGetObjValue(formObj.result) != "") {
     		ComShowCodeMessage("DMT00138", sheetRFAObj.CellValue(sheetRFAObj.SelectRow, "Seq"), ComGetObjValue(formObj.result));
     		return true;
     	}
     	
       	return false;
 	}     
     
	/**
	 * Calculation Type 확인(모든 Tariff 와 Coverage 에 대해서 수행) 
	 */		
	function validateCalculationType(selectedRow) {
		var formObj 		= document.form;
		var sheetRFAObj		= sheetObjects[0];
		var sheetRTObj 		= sheetObjects[2];
		
		var custCd = ComTrim(ComGetObjValue(formObj.custCd));
		var tariff = sheetRFAObj.CellValue(selectedRow, TARIFF);
		var params = "";
		params = changeNullToSpace(sheetRFAObj.CellValue(selectedRow, CVRG_CNT));
		params = params + "=" + changeNullToSpace(sheetRFAObj.CellValue(selectedRow, CVRG_RGN));
		params = params + "=" + changeNullToSpace(sheetRFAObj.CellValue(selectedRow, CVRG_LOC));
		params += "|";
		params += tariff;
		params += "|";
		params += sheetRFAObj.CellValue(selectedRow, EFF_DT);
		params += "|";
		params += sheetRFAObj.CellValue(selectedRow, EXP_DT);
		params += "|";
		params += sheetRFAObj.CellValue(selectedRow, CNTRCGO);
		params += "|";
		
		if (custCd.length > 2) {
			params += custCd.substring(0,2);
			params += ComTrim(ComGetObjValue(formObj.custSeq));
		}	
		
		//1.Calculation Type Check 실행을 위한 파라미터 설정
		ComSetObjValue(formObj.chk_calc_tp_in, params);
		
		//2.Calculation Type Check 실행
		if (tariff.indexOf("CT") != -1) {
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DUAL);	
		}
		else {
			//2-1.DMIF, DMOF 의 경우 BKG DEL(I) or POR(O) 입력시 해당지역의 Calculation Type이
			//    Combined 일 경우에 대한 로직을 안 태우기 위해서 설정해줘야 함.			
			ComSetObjValue(formObj.chk_calc_tp_combined, "N");
			
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_CALC);
		}
		
		//3.실행결과 추출
		var result = ComGetObjValue(formObj.result);
		//result(E: Error, M: Mandatory, O:Option)
		
		//3-1.결과가 Y 일 경우 (입력된 Coverage 의 Tariff Type 의 Calculation Type 이 맞을 경우)
		if (result == "M") {
			if (tariff.indexOf("CT") != -1) {
				//Free Time 은 Total Day 만 입력 가능함.
				if (ComTrim(sheetRFAObj.CellValue(selectedRow, ADD_DYS)).length > 0) {
					ComShowCodeMessage("DMT00113", sheetRFAObj.CellValue(selectedRow, "Seq"));
					return false; 					
				}
				//Rate Adjustment 는 필수 입력임.
				if (fetchRowCount(sheetRTObj) < 1) {
					ComShowCodeMessage("DMT00114", sheetRFAObj.CellValue(selectedRow, "Seq"));
					return false;
				}						
			}
		} 
		//3-2.결과가 N 일 경우(입력된 Coverage 의 Tariff Type 의 Calculation Type 이 맞지 않을 경우)
		else if (result == "E") {
			var cntCd = ComGetObjValue(formObj.result_cnt);
			var steCd = ComGetObjValue(formObj.result_ste);
			var rgnCd = ComGetObjValue(formObj.result_rgn);
			var locCd = ComGetObjValue(formObj.result_loc);
							
			if (cntCd.indexOf("US") != -1 || cntCd.indexOf("CA") != -1) {
				rgnCd = steCd;
			}

			var errMsgId = "";
			if (tariff.indexOf("CT") != -1) {
				errMsgId = "DMT02003";
			}
			else {
				errMsgId = "DMT00132";
			}	
			ComShowCodeMessage(errMsgId, sheetRFAObj.CellValue(selectedRow, "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + locCd + " ]");
			return false;					
		}

		return true;
	}
	
	/**
	 * Calculation Type 확인(DMIF, DMOF 의 경우 BKG DEL(I) or POR(O)이 입력되었을 경우 실행) 
	 */		
	function validateCalculationTypeInDM(selectedRow) {
		var formObj 		= document.form;
		var sheetRFAObj 	= sheetObjects[0];
		
		
		var custCd = ComTrim(ComGetObjValue(formObj.custCd));
		var tariff = sheetRFAObj.CellValue(selectedRow, TARIFF);
		var params = "";
		if (tariff.indexOf("DM") != -1) {
			if (ComTrim(sheetRFAObj.CellValue(selectedRow, BKGDEL_CNT)) != "") {
				params = changeNullToSpace(sheetRFAObj.CellValue(selectedRow, BKGDEL_CNT));
				params = params + "=" + changeNullToSpace(sheetRFAObj.CellValue(selectedRow, BKGDEL_RGN));
				params = params + "=" + changeNullToSpace(sheetRFAObj.CellValue(selectedRow, BKGDEL_LOC));
				params += "|";
				params += tariff;
				params += "|";
				params += sheetRFAObj.CellValue(selectedRow, EFF_DT);
				params += "|";
				params += sheetRFAObj.CellValue(selectedRow, EXP_DT);
				params += "|";
				params += sheetRFAObj.CellValue(selectedRow, CNTRCGO);
				params += "|";
				
				if (custCd.length > 2) {
					params += custCd.substring(0,2);
					params += ComTrim(ComGetObjValue(formObj.custSeq));
				}				
				
				//1.Calculation Type Check 실행을 위한 파라미터 설정
				ComSetObjValue(formObj.chk_calc_tp_in, params);
				//1-1.DMIF, DMOF 의 경우 BKG DEL(I) or POR(O) 입력시 해당지역의 Calculation Type이
				//    Combined 일 경우에 대한 로직을 태우기 위해서 설정해줘야 함.
				ComSetObjValue(formObj.chk_calc_tp_combined, "Y");
						
				//2.Calculation Type Check 실행
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_CALC);
				
				//3.실행결과 추출
				var result = ComGetObjValue(formObj.result);
				//result(E: Error, O:Option)
				
				//3-1.결과가 N 일 경우(해당지역의 Calculation Type 이 Combined 일 경우)
				if (result == "E") {
					var cntCd = ComGetObjValue(formObj.result_cnt);
					var steCd = ComGetObjValue(formObj.result_ste);
					var rgnCd = ComGetObjValue(formObj.result_rgn);
					var locCd = ComGetObjValue(formObj.result_loc);
									
					if (cntCd.indexOf("US") != -1 || cntCd.indexOf("CA") != -1) {
						rgnCd = steCd;
					}
								
					ComShowCodeMessage("DMT00132", sheetRFAObj.CellValue(selectedRow, "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + rgnCd + " ]");			
					return false;				
				}			
			}
		}
		return true;		
	}
	
	/**
	 * Rate Adjustment Sheet 에 있는 항목에 대해서 Validation 을 체크한다.
	 */			
	function validateRateAdjustment(selectedRow) {
        var sheetRFAObj = sheetObjects[0];
		var sheetRTObj	= sheetObjects[2];
		
		//마지막 Row 일 경우 Over Day 의 From 은 필수입력 Up to 은 Empty 이어야 함.
		//또한, Pate per Day 의 20FT, 40FT, H/C, 45FT 는 필수입력
		if (isEmptyColumnOfLastRow(sheetRTObj, RT_FROM)) {
			ComShowCodeMessage("DMT00108", sheetRFAObj.CellValue(selectedRow, "Seq"), "From");
			return false;
		}
		else if (!isEmptyColumnOfLastRow(sheetRTObj, RT_UPTO)) {
			ComShowCodeMessage("DMT02006", sheetRFAObj.CellValue(selectedRow, "Seq"));
			return false;
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_20FT)) {
			ComShowCodeMessage("DMT00108", sheetRFAObj.CellValue(selectedRow, "Seq"), "20FT");
			return false;
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_40FT)) {
			ComShowCodeMessage("DMT00108", sheetRFAObj.CellValue(selectedRow, "Seq"), "40FT");
			return false;			
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_HC)) {
			ComShowCodeMessage("DMT00108", sheetRFAObj.CellValue(selectedRow, "Seq"), "H/C");
			return false;			
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_45FT)) {
			ComShowCodeMessage("DMT00108", sheetRFAObj.CellValue(selectedRow, "Seq"), "45FT");
			return false;			
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_R9)) {
			ComShowCodeMessage("DMT00108", sheetRFAObj.CellValue(selectedRow, "Seq"), "R9");
			return false;			
		}
		//Up to 는 From와 같거나 큰 숫자가 들어가도록 함
		with(sheetRTObj) {
			for (var row = HeaderRows ; row < LastRow ; row++) {
				if (RowStatus(row) != "D") {
					if (ComParseInt(CellValue(row, RT_FROM)) > ComParseInt(CellValue(row, RT_UPTO))) {
						ComShowCodeMessage("DMT01032", "[Rate Adjustment]");
						CellValue2(row, RT_UPTO) = "";
						return false;
					}
					if ( ComTrim(CellValue(row,RT_20FT)) < 1 ){
						ComShowCodeMessage("DMT01168", "20FT"); 
						SelectCell(Row, RT_20FT);
						return false;
					}
					if ( ComTrim(CellValue(row,RT_40FT)) < 1 ){
						ComShowCodeMessage("DMT01168", "40FT"); 
						SelectCell(Row, RT_20FT);
						return false;
					}
					if ( ComTrim(CellValue(row,RT_HC)) < 1 ){
						ComShowCodeMessage("DMT01168", "HC"); 
						SelectCell(Row, RT_20FT);
						return false;
					}
					if ( ComTrim(CellValue(row,RT_45FT)) < 1 ){
						ComShowCodeMessage("DMT01168", "45FT"); 
						SelectCell(Row, RT_20FT);
						return false;
					}
					if ( ComTrim(CellValue(row,RT_R9)) < 1 ){
						ComShowCodeMessage("DMT01168", "R9"); 
						SelectCell(Row, RT_20FT);
						return false;
					}
				}
			}
		}		
		return true;				
	}
	
	/**
	 * Sheet1 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj 		= document.form;
		var sheetCVRGObj	= sheetObjects[1];
		
		//Coverage 컬럼에서 Rate Adjustment 필수여부를 체크하다가 없을 경우 Coverage 모든 컬럼을 Clear 하기 위해서 사용하는 변수
		var isCoverageError = false; 
		
		switch(sheetObj.ColSaveName(Col)) {
			
			case TARIFF:
				changeBKGDELorPOR(sheetObj, Row);
				//선택된 Tariff 타입에 따라서 Multi Origin or Destination 의 제목이 변경된다.(2009-07-29)
				setMultiOrgDestTitle();				
				//Rate Adjustment 항목의 필수,선택여부를 체크한다.(2009-07-30)
				if (checkMandatoryRateAdjustment() == "E") {
					sheetObj.CellValue2(Row, TARIFF) = "";				
				}				
				break;
			
			case EFF_DT:
				//Rate Adjustment 항목의 필수,선택여부를 체크한다.(2009-07-30)
				if (checkMandatoryRateAdjustment() == "E") {
					sheetObj.CellValue2(Row, EFF_DT) = "";				
				}
				break;

			case EXP_DT:
				//Rate Adjustment 항목의 필수,선택여부를 체크한다.(2009-07-30)
				if (checkMandatoryRateAdjustment() == "E") {
					sheetObj.CellValue2(Row, EXP_DT) = "";				
				}
				break;
				
			case CNTRCGO:
				//Rate Adjustment 항목의 필수,선택여부를 체크한다.(2009-07-30)
				if (checkMandatoryRateAdjustment() == "E") {
					sheetObj.CellValue2(Row, CNTRCGO) = "";				
				}
				break;
				
			case CVRG_CNT:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG = CVRG_CNT;
				
				var cntCd = ComTrim(sheetObj.CellValue(Row, Col));

				//Country 가 Empty 라면 모든 Region 정보를 조회한다.
				if (cntCd.length == 0) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH01,"cvrg_rgn_cd");
					sheetObj.CellValue(Row, "cvrg_rgn_cd") = "";
					
					//Country 가 Empty 될 경우 Currency 정보를 지운다.
					ComClearCombo(formObj.currency); 
				}
				//Country 에 소속된 하위 Regino or State 정보를 조회한다.	
				else if (cntCd.length == 2) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH12,"cvrg_conti_cd");
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH03,"cvrg_cnt_cd|cvrg_rgn_cd");
					
					//Country 가 변경될 경우 그에 해당되는 Currency 정보를 조회한다.
					searchCurrencyList(Row);
					//조회된 Currency 정보에서 첫번째 항목을 기본값으로 설정한다.
					sheetObj.CellValue(Row, CURR_CD) = ComTrim(ComGetObjValue(formObj.currency));
				}
				//Country 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"cvrg_loc_cd");	
				
				//Rate Adjustment 항목의 필수,선택여부를 체크한다.(2009-07-30)
				if (isRateCheckingCVRG == CVRG_CNT) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError = true;
					}
				}				
				if (isRateCheckingCVRG == CVRG_CNT) isRateCheckingCVRG = "";
				break;
				
			case CVRG_RGN:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG = CVRG_RGN;
				
				if (isValueSettingEvent) return;	//화면에서 발생된 이벤트가 아닐경우에는 무시한다.
				
				var rgnCd = ComTrim(sheetObj.CellValue(Row, Col));

				//Region 를 포함하는 상위  Country 정보를 조회한다.
				switch(rgnCd.length) {
					case 2:
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH17,"|cvrg_cnt_cd|cvrg_rgn_cd");
						break;
						
					case 3:
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH13,"|cvrg_cnt_cd|cvrg_rgn_cd");
						break;
				}
				//Region 이 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"cvrg_loc_cd");
				
				//Rate Adjustment 항목의 필수,선택여부를 체크한다.(2009-07-30)
				if (isRateCheckingCVRG == CVRG_RGN) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError = true;
					}
				}				
				if (isRateCheckingCVRG == CVRG_RGN) isRateCheckingCVRG = "";
				break;					
				
			case CVRG_LOC:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG = CVRG_LOC;
				
				var locCd = ComTrim(sheetObj.CellValue(Row,Col));
	    		if (locCd.length == 5) {
					isClearLocation = false;
					isValueSettingEvent = true;
					//Location 상위(Country, Region or State) 정보를 조회한다.
	    			doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH04,"cvrg_cnt_cd|cvrg_rgn_cd|cvrg_loc_cd");
					isValueSettingEvent = false;
					isClearLocation = true;
				}
				else if (locCd.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.CellValue2(Row, Col) = "";
				}
				//Rate Adjustment 항목의 필수,선택여부를 체크한다.(2009-07-30)
				if (isRateCheckingCVRG == CVRG_LOC) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError = true;
					}
				}				
				if (isRateCheckingCVRG == CVRG_LOC) isRateCheckingCVRG = "";
				break;
				
			//Free Time Y 컬럼에 체크선택이나 체크선택해제시 수행해야할 동작을 정의함.
			case FT_FLG:
				setFreeTimeByMandatory(sheetObj, sheetObj.SelectRow, FT_FLG);
				break;
				
			//Origin(I) or Dest.(O) 항목에서 'Single' or 'Multi' 선택시				
			case ORGDST_MULTI:
				//1.선택한 Multi Type 에 맞게 Multi Origin or Dest. 입력상태를 변경해준다.(체크박스, 버튼포함)
				setMultiOrgDestGrid();
				
				//2.Multi Origin or Dest. 를 선택할 경우 자동으로 Row 를 추가해준다.(2009-07-28)
				if (Value == "M") {
					with(sheetObj) {
						CellValue2(Row, 	ORGDST_CTI) 	= "";
						CellValue2(Row, 	ORGDST_CNT) 	= "";
						CellValue2(Row, 	ORGDST_RGN) 	= "";
						CellValue2(Row, 	ORGDST_LOC) 	= "";
					}
					
					addMultiOrgDest();
				}
				//3.Single 로 선택할 경우 Multi Origin or Dest. 에 있는 모든 데이터를 삭제한다.
				else {
					delSubBeforeException(sheetCVRGObj, "All");
				}
				break;
								
			case ORGDST_CTI:
				var ctCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Continent 가 Empty 라면 모든 Country 와 모든 Region 정보를 조회한다.
				if (ctCd.length == 0) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH02,"org_dest_cnt_cd");
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH01,"org_dest_rgn_cd");
				}
				//Continent 에 소속된 하위 Country 정보를 조회한다.
				else if (ctCd.length == 1) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH06,"org_dest_cnt_cd");
				}
				//Continent 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"org_dest_loc_cd");				
				break;
			
			case ORGDST_CNT:
				var cntCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Country 가 Empty 라면 모든 Region 정보를 조회한다.
				if (cntCd.length == 0) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH01,"org_dest_rgn_cd");
					sheetObj.CellValue(Row,"org_dest_rgn_cd") = "";
				}
				//Country 를 포함하는 상위 Continent 와 Country 에 소속된 하위 Region 정보를 조회한다.
				else if (cntCd.length == 2) {
					if (!isValueSettingEvent) {
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH12,"org_dest_conti_cd|org_dest_cnt_cd");
					}
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH03,"org_dest_cnt_cd|org_dest_rgn_cd");
				}
				//Country 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"org_dest_loc_cd");				
				break;
				
			case ORGDST_RGN:
				if (isValueSettingEvent) return;	//화면에서 발생된 이벤트가 아닐경우에는 무시한다.
				
				var rgnCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Region 를 포함하는 상위 Continent, Country 정보를 조회한다.
				switch(rgnCd.length) {
					case 2: 
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH17,"org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd");
						break;
						
					case 3:
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH13,"org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd");
						break;
				}
				//Region 이 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"org_dest_loc_cd");
				break;
								
			case ORGDST_LOC:
				var locCd = ComTrim(sheetObj.CellValue(Row,Col));
				if (locCd.length == 5) {
					isClearLocation = false;
					isValueSettingEvent = true;
					//Location 상위(Continent, Country, Region or State) 정보를 조회한다.
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH10,"org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd|org_dest_loc_cd");
					isValueSettingEvent = false;
					isClearLocation = true;
				}
				else if (locCd.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.CellValue2(Row, Col) = "";
				}								
				break;				
				
			case BKGDEL_CNT:
				if (ComTrim(sheetObj.CellValue(Row, CVRG_CNT)) == "") {
					sheetObj.CellValue2(Row, BKGDEL_CNT) = "";
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				
				var cntCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Country 가 Empty 라면 모든 Region 정보를 조회한다.
				if (cntCd.length == 0) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH01,"fnl_dest_rgn_cd");
					sheetObj.CellValue(Row,"fnl_dest_rgn_cd") = "";
				}
				//Country 에 소속된 하위 Region 정보를 조회한다.
				else if (cntCd.length == 2) {
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH12,"fnl_dest_conti_cd");
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH03,"fnl_dest_cnt_cd|fnl_dest_rgn_cd");
				}
				//Country 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"fnl_dest_loc_cd");
				
				//BKG POR(O) or DEL(I) 입력된 CN의 Continent가 12번 Coverage의 Continent와 다를 경우 
				//“Discrepancy with Coverage continent!” Alert창 띄우며 막음 (2009-07-28)
				if (!equalContinentByCN(Row)) {
					ComShowCodeMessage("DMT02008");
					sheetObj.CellValue(Row, BKGDEL_CNT) = "";
					sheetObj.CellValue2(Row, BKGDEL_RGN) = "";
					sheetObj.CellValue2(Row, BKGDEL_LOC) = "";
					return;
				}				
				break;
				
			case BKGDEL_RGN:
				if (ComTrim(sheetObj.CellValue(Row, CVRG_CNT)) == "") {
					sheetObj.CellValue2(Row, BKGDEL_RGN) = "";
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				
				if (isValueSettingEvent) return;	//화면에서 발생된 이벤트가 아닐경우에는 무시한다.
				
				var rgnCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Region 를 포함하는 상위  Country 정보를 조회한다.
				switch(rgnCd.length) {
					case 2: 
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH17,"|fnl_dest_cnt_cd|fnl_dest_rgn_cd");
						break;
						
					case 3:
						doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH13,"|fnl_dest_cnt_cd|fnl_dest_rgn_cd");
						break;
				}
				//Region 이 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"fnl_dest_loc_cd");							
				break;
								
			case BKGDEL_LOC:
				if (ComTrim(sheetObj.CellValue(Row, CVRG_CNT)) == "") {
					sheetObj.CellValue2(Row, BKGDEL_LOC) = "";
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				
				var locCd = ComTrim(sheetObj.CellValue(Row,Col));
				if (locCd.length == 5) {
					isClearLocation = false;
					isValueSettingEvent = true;
					//Location 상위(Country, Region or State) 정보를 조회한다.
					doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCH04,"fnl_dest_cnt_cd|fnl_dest_rgn_cd|fnl_dest_loc_cd");
					isValueSettingEvent = false;
					isClearLocation = true;
				}	
				else if (locCd.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.CellValue2(Row, Col) = "";
				}								
				break;
				
			case CUST_CD:
				sheetObj.CellValue2(Row, CUST_NM) = ComGetComboText(sheetObj, Row, Col, 1);
				break;
				
			case REMARK:
				sheetObj.CellValue(Row, FULL_REMARK) = sheetObj.CellValue(Row, REMARK);
				break;
		}
		
		//Rate Adjustment Mandatory 체크시 Coverage 컬럼에서 에러 발생시 Coverage 컬럼을 모두 Clear 해준다.
		if (isCoverageError) sheetObj.CellValue(Row, CVRG_CNT) = "";		
	}

   /**
	* 정렬시 현재 선택되어진 ROW 의 선택상태를 계속 유지하도록 처리해주는 함수
	*/	
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (currDtlSeq == CellValue(row, DTL_SEQ)) {
					SelectRow = row;
					break;
				}
			}
		}
	}
		
	/**
	 * Row 가 선택될 때 조건별 Row 상태를 변경한다.
	 */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var formObj 	= document.form;
		
		//========================================================================================
    	//Row Add, Row Copy 버튼이 클릭될 경우 자동으로 Row 선택이 변경되면서 이 함수를 호출합니다.
    	//이 경우는 예상치 않은 함수호출이기 때문에 아래 로직을 수행하지 않습니다.
    	if (isCopyRFAExceptionTariff) return;
    	//========================================================================================
    	
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		with(sheetObj) {
			if (OldRow >= HeaderRows && OldRow != NewRow) {

				//chkResult => 0: 결과, 1: 발생된 Row, 2:입력,수정,삭제 구분, 3:에러메시지
				var chkResult = isChangedBeforeException();
				if (chkResult[0]) {
					if (!ComShowCodeConfirm("DMT01112", "save")) {
						SelectRow = OldRow;
						
						//-------------------------------------------
						currDtlSeq = CellValue(SelectRow, DTL_SEQ);
						//-------------------------------------------
						
						return;
					}
					
					//추가, 수정, 삭제된 Row 정보를 DB 에 반영한다. ########################
					SelectRow = OldRow;
					
					//-------------------------------------------
					currDtlSeq = CellValue(SelectRow, DTL_SEQ);
					//-------------------------------------------
					
					//매개변수는 변경된 정보가 있음을 나타낸다.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
					if (!saveBKGReqDetail(chkResult[0])) return;	
					//##################################################################
				}
				else {
					//-------------------------------------------
					currDtlSeq = CellValue(SelectRow, DTL_SEQ);
					//-------------------------------------------
					
					//선택한 Detail Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
					setSubBeforeException(true);
				}
			}
		}
	}
		
	/**
	 * Sheet1 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {

		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow == (HeaderRows - 1)) {
				switch(colName) {
					case ADD_DYS: 	MouseToolTipText = "Additional Day"; 	break;
					case TOT_DYS: 	MouseToolTipText = "Total Day"; 		break;					
					default: 		MouseToolTipText = "";
				}
			}
			else if (MouseRow >= HeaderRows && MouseRow <= LastRow) {

				if (colName == CVRG_CNT || colName == CVRG_RGN || colName == CVRG_LOC) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DMOF 일 경우 말풍선 "BKG POL/CY"
					//         DMIF 일 경우 말풍선 "BKG POD/CY"
					//         DTOC, CTOC 일 경우 말풍선 "BKG POR"
					//         DTIC, CTIC 일 경우 말풍선 "BKG DEL"				
					switch(trfCd) {
						case "DMOF": 	MouseToolTipText = "BKG POL/CY"; 	break;
						case "DMIF": 	MouseToolTipText = "BKG POD/CY"; 	break;
						case "DTOC":
						case "CTOC": 	MouseToolTipText = "BKG POR"; 		break;
						case "DTIC":
						case "CTIC": 	MouseToolTipText = "BKG DEL"; 		break;
						default: MouseToolTipText = "";
					}
				}
				else if (colName == ADD_DYS) {
					MouseToolTipText = "Additional Day";
				}
				else if (colName == TOT_DYS) {
					MouseToolTipText = "Total Day";
				}
				else if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DMOF, DTOC, CTOC 일 경우 말풍선 "BKG DEL"
					//         DMIF, DTIC, CTIC 일 경우 말풍선 "BKG POR" 		
					switch(trfCd) {
						case "DMOF":
						case "DTOC":
						case "CTOC": 	MouseToolTipText = "BKG DEL"; 		break;
						case "DMIF": 
						case "DTIC":
						case "CTIC": 	MouseToolTipText = "BKG POR"; 		break;
						default: 		MouseToolTipText = "";
					}
				}
				else if (colName == BKGDEL_CNT || colName == BKGDEL_RGN || colName == BKGDEL_LOC) {
					var trfCd = CellValue(MouseRow, TARIFF);
					//Tariff 가 DMIF 일 경우 말풍선 "BKG DEL for Demurrage Only"
					//         DMOF 일 경우 말풍선 "BKG POR for Demurrage Only" 		
					switch(trfCd) {
						case "DMIF": 	MouseToolTipText = "BKG DEL for Demurrage Only"; break;
						case "DMOF": 	MouseToolTipText = "BKG POR for Demurrage Only"; break;
						default: 		MouseToolTipText = "";
					}
				}				
				else if (colName == REMARK)	{
					MouseToolTipText = CellValue(MouseRow, FULL_REMARK);
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
	 * Sheet2(Multi Coverage) 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj 	= document.form;

		switch(sheetObj.ColSaveName(Col)) {
		
			//[Continent] 변경시 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			case ORGDST_CTI:
				
				//타 메소드 호출시 현재 Row 정보를 전달하기 위해서 아래 변수에 그 값을 설정해 준다.===========================================================
				var isDeleteRowValue = false;
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue = true;
				}
				//================================================================================================================================				
				
				//Continent 가 Empty 라면 모든 Country 와 모든 Region 정보를 조회한다.
				if (Value.length == 0) {
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH02, "org_dest_cnt_cd");
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH01, "org_dest_rgn_cd");
				}
				//Continent 에 소속된 하위 Country 정보를 조회한다.
				else if (Value.length == 1) {
					ComSetObjValue(formObj.conti_cd,	Value);	
					ComSetObjValue(formObj.f_cmd,		SEARCH06);
					
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH06, "org_dest_cnt_cd", false);
				}
				
				//조회 완료 후에는 아래 매개변수를 지워줘야 한다. ======================================================================================
				if (isDeleteRowValue) {
					ComSetObjValue(formObj.select_row, 	"");
				}
				//================================================================================================================================
				
				//Continent 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) sheetObj.CellValue2(Row, ORGDST_LOC) = "";
				
				break;
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				
			
			//[Country] 변경시 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			case ORGDST_CNT:
				//타 메소드 호출시 현재 Row 정보를 전달하기 위해서 아래 변수에 그 값을 설정해 준다.===========================================================
				var isDeleteRowValue = false;
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue = true;
				}
				//================================================================================================================================				

				//Country 가 Empty 라면 모든 Region 정보를 조회한다.
				if (Value.length == 0) {
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH01, "org_dest_rgn_cd");
					sheetObj.CellValue(Row, "org_dest_rgn_cd") = "";
				}
				//Country 를 포함하는 상위 Continent 와 Country 에 소속된 하위 Region 정보를 조회한다.
				else if (Value.length == 2) {
					if (!isValueSettingEvent) {
						//조회조건 설정
						ComSetObjValue(formObj.cnt_cd,		Value);	
						ComSetObjValue(formObj.f_cmd,		SEARCH12);

						doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH12, "org_dest_conti_cd|org_dest_cnt_cd", false);
					}
					//조회조건 설정
					ComSetObjValue(formObj.cnt_cd,		Value);	
					ComSetObjValue(formObj.f_cmd,		SEARCH03);

					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH03, "org_dest_cnt_cd|org_dest_rgn_cd", false);
				}
				
				//조회 완료 후에는 아래 매개변수를 지워줘야 한다. ======================================================================================
				if (isDeleteRowValue) {
					ComSetObjValue(formObj.select_row, 	"");
				}
				//================================================================================================================================

				//Country 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) sheetObj.CellValue2(Row, ORGDST_LOC) = "";			
				break;
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
				
			//[Region] 변경시 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			case ORGDST_RGN:
				if (isValueSettingEvent) return;	//화면에서 발생된 이벤트가 아닐경우에는 무시한다.
				
				//타 메소드 호출시 현재 Row 정보를 전달하기 위해서 아래 변수에 그 값을 설정해 준다.===========================================================
				var isDeleteRowValue = false;
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue = true;
				}
				//================================================================================================================================				

				//Region 를 포함하는 상위 Continent, Country 정보를 조회한다.
				switch(Value.length) {
					case 2: 
						//조회조건 설정
						ComSetObjValue(formObj.f_cmd,		SEARCH17);
						ComSetObjValue(formObj.ste_cd,		Value);

						doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH17, "org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd", false);
						break;
						
					case 3:
						//조회조건 설정
						ComSetObjValue(formObj.f_cmd,		SEARCH13);
						ComSetObjValue(formObj.rgn_cd,		Value);

						doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH13, "org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd", false);
						break;
				}

				//조회 완료 후에는 아래 매개변수를 지워줘야 한다. ======================================================================================
				if (isDeleteRowValue) {
					ComSetObjValue(formObj.select_row, 	"");
				}
				//================================================================================================================================
						
				//Region 이 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) sheetObj.CellValue2(Row, ORGDST_LOC) = "";			
				break;
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				
			
			//[Location] 변경시 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			case ORGDST_LOC:
				if (Value.length == 5) {
					isClearLocation = false;
					isValueSettingEvent = true;
					
					//Location 상위(Continent, Country, Region or State) 정보를 조회한다. ===================================================================
					//조회를 위한 매개변수를 설정한다.(loc_cd 만 사용하기 때문에 이 필드만 설정해주면 된다.)
					ComSetObjValue(formObj.loc_cd,		Value);	
					ComSetObjValue(formObj.select_row, 	Row);
					ComSetObjValue(formObj.f_cmd,		SEARCH10);
					
					//Location 상위(Continent, Country, Region or State) 정보를 조회한다.
					doActionIBCommon(sheetObj, formObj, IBSEARCH, SEARCH10, "org_dest_conti_cd|org_dest_cnt_cd|org_dest_rgn_cd|org_dest_loc_cd", false);
					
					//조회 완료 후에는 아래 매개변수를 지워줘야 한다.
					ComSetObjValue(formObj.select_row, 	"");
					//======================================================================================================================================
					
					isValueSettingEvent = false;
					isClearLocation = true;
				}
				else if (Value.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.CellValue2(Row, Col) = "";
				}								
				break;	
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		}
	}
	
	/**
	 * Sheet2 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function sheet2_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		var sheetObj1 = sheetObjects[0];
		
		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow >= HeaderRows && MouseRow <= LastRow) {

				if (colName == ORGDST_CTI || colName == ORGDST_CNT || colName == ORGDST_RGN || colName == ORGDST_LOC) {
					var trfCd = sheetObj1.CellValue(sheetObj1.SelectRow, TARIFF);
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
	 * Sheet4(Rate Adjustment) 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		var formObj 	= document.form;
		var sheetObj 	= sheetObjects[2];

		with(sheetObj) {
			switch(ColSaveName(Col)) {
			case RT_UPTO:
				
				if (	ComTrim(CellValue(Row, RT_FROM)) != "" 
					&& 	ComTrim(CellValue(Row, RT_UPTO)) != "" 
					&& 	ComParseInt(CellValue(Row, RT_FROM)) > ComParseInt(CellValue(Row, RT_UPTO))) {
					ComShowCodeMessage("DMT01032", "[Rate Adjustment]");
					CellValue2(Row, RT_UPTO) = "";
					return;
				}
				
				var rtUpTo = ComTrim(sheetObj.CellValue(Row,Col));
				if (rtUpTo == "") { return; }
				if (!ComIsNumber(rtUpTo)) {
					ComShowCodeMessage("DMT00134");
					CellValue2(Row, Col) = "";
					SelectCell(Row, Col, false);
					return;					
				}               
				var rtFmTo = ComParseInt(rtUpTo) + 1;

				//다음 Row 가 없을 경우 -1 을 반환하고, 있을 경우 Row 값을 반환한다.
				var nextRow = getNextRow(Row, sheetObj);
				if (nextRow > 0) {
					CellValue2(nextRow, RT_FROM) = rtFmTo + "";						
				}
				break;
				
			case RT_20FT:
				if ( ComTrim(sheetObj.CellValue(Row,RT_20FT)) < 1 ){
					ComShowCodeMessage("DMT01168", "20FT"); 
					CellValue2(Row,RT_20FT) = "";
					SelectCell(Row, RT_20FT);
					return false;
				}
				break;

			case RT_40FT:
				if ( ComTrim(sheetObj.CellValue(Row,RT_40FT)) < 1 ){
					ComShowCodeMessage("DMT01168", "40FT");
					CellValue2(Row,RT_40FT) = "";
					SelectCell(Row, RT_40FT);
					return false;
				}
				break;

				case RT_HC:
				if ( ComTrim(sheetObj.CellValue(Row,RT_HC)) < 1 ){
					ComShowCodeMessage("DMT01168", "H/C");
					CellValue2(Row,RT_HC) = "";
					SelectCell(Row, RT_HC);
					return false;
				}
					break;

				case RT_45FT:
				if ( ComTrim(sheetObj.CellValue(Row,RT_45FT))< 1 ){
					ComShowCodeMessage("DMT01168", "45FT");
					CellValue2(Row,RT_45FT) = "";
					SelectCell(Row, RT_45FT);
					return false;
				}
					break;

				case RT_R9:
				if ( ComTrim(sheetObj.CellValue(Row,RT_R9))< 1 ){
					ComShowCodeMessage("DMT01168", "R9");
					CellValue2(Row,RT_R9) = "";
					SelectCell(Row, RT_R9);
					return false;
				}
				break;
			
			}
		}
	}
		
	/**
	 * Row 가 선택될 때 해당 Comment 를 보여준다.
	 */	
	function sheet4_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj = document.form;
		
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		if (OldRow >= sheetObj.HeaderRows && OldRow != NewRow) {
			if (!formObj.chkComment.checked) {
				ComSetObjValue(formObj.comment, sheetObj.CellValue(NewRow, PROG_RMK));
			}
		}		
	}
			
	/**
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation(sheetObj,sComboKey) {
		sheetObj.CellValue2(sheetObj.SelectRow, sComboKey) = "";
	}	
	
	/**
	 * Adjustment Request 정보를 추가한다.
	 */		
	function addBKGReqDetail() {
		var formObj 		= document.form;
		var cboDARObj 		= comboObjects[0];
		var sheetRFAObj 	= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		var sheetRTObj		= sheetObjects[2];

		//Row 를 추가하기 전에 Approval Office 가 선택되었는지를 체크한다.
		if (ComTrim(ComGetObjValue(formObj.approvalOfcCd)) == "") {
			ComShowCodeMessage("DMT00140", "APVL OFC");
			ComSetFocus(formObj.approvalOfcCd);
			return;
		}
		
		//1.Row Add 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구 ==========================
		var chkResult = isChangedBeforeException();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				//변경된 내용만 조회해서 그리드에 설정.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
				if (!saveBKGReqDetail(chkResult[0])) return;	
			}
			else {
				//ComShowCodeMessage("DMT01115");
				return;
			}
		}
		//==========================================================================================================================		
		
		with(sheetRFAObj) {
			if (fetchRowCount(sheetRFAObj) > 0) {
				darNo 	= CellValue(LastRow, 	DAR_NO);
				verSeq 	= CellValue(LastRow, 	VER_SEQ);
			} else {
				darNo	= ComTrim(cboDARObj.Text);
				verSeq	= ComTrim(ComGetObjText(formObj.version));
			}

			//===============================================================================================================
			//Row 를 생성하면 자동으로 포커스가 이동한다.
			//포커스가 이동되면서 sheet1_OnSelect 함수를 호출하게 되고, 거기에서 변경된 내용이 있는지 조회하는 모듈을 태운다.
			//바로, 위 프로세스를 막기 위해서 아래와 같이 전역변수에 플래그값을 변경한다.
			isCopyRFAExceptionTariff = true;
			var irow = DataInsert(-1);
			isCopyRFAExceptionTariff = false;
			//===============================================================================================================
			
			// new row 글자색 지정 2011.12.14  김현화
			sheetRFAObj.RowFontColor(irow) = RgbColor(0,0,255); 
			
			CellValue(LastRow, DAR_NO) 		= darNo;
			CellValue(LastRow, MAPG_SEQ) 	= "1";
			CellValue(LastRow, VER_SEQ) 	= verSeq;
			CellValue(LastRow, DTL_SEQ) 	= "";
			
			//Default 는 Y 컬럼 체크(2009-07-27)
			CellValue(LastRow, FT_FLG) 			= "1";
			CellValue(LastRow, CVRG_SEQ) 		= "1";
			CellValue(LastRow, ROW_EDIT_STS) 	= "Y";
			CellValue(LastRow, CURR_CD)			= "";
			CellValue(LastRow, RT_MANDATORY) 	= "N";
			
			CellValue(LastRow, EFF_DT) = getTodate();
			CellValue(LastRow, EXP_DT) = getTodate();
		}

		//Multi Origin or Destination 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setMultiOrgDestGrid();
		sheetCVRGObj.RemoveAll();
		
		//Rate Adjustment 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setRateAdjustmentGrid();
		sheetRTObj.RemoveAll();
	}
	
	/**
	 * Multi Origin Or Destination Grid 에 Row 를 추가한다.
	 */		
	function addMultiOrgDest() {
	    var formObj 		= document.form;
	    var sheetRFAObj		= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		var cvrgSeq			= "";
		
		if (formObj.chkMultiOrgDest.checked) {
			cvrgSeq = fetchColumnValueOfLastRow(sheetCVRGObj, CVRG_SEQ);
			cvrgSeq	= cvrgSeq  == "" ? 1 : ComParseInt(cvrgSeq)  + 1;
			
			//Multi Origin or Dest. 그리드에 Row 를 생성한다.
			with(sheetCVRGObj) {
				var irow = DataInsert(-1);
				
				CellValue(LastRow, DAR_NO) 		= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DAR_NO);
				CellValue(LastRow, MAPG_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, MAPG_SEQ);
				CellValue(LastRow, VER_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, VER_SEQ);
				CellValue(LastRow, DTL_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DTL_SEQ);
				CellValue(LastRow, CVRG_SEQ)	= cvrgSeq;
	
				// new row 글자색 지정 2011.12.14  김현화
				sheetCVRGObj.RowFontColor(irow) = RgbColor(0,0,255); 			
			
			}
		}		
	}
		
	/**
	 * Rate Adjustment Grid 에 Row 를 추가한다.
	 */		
	function addRateAdjustment() {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];
		var sheetRTObj	= sheetObjects[2];
		var rtSeq		= "";
		var rtUpTo		= "";
		var rtFrom		= "";
		
		if (fetchRowCount(sheetRTObj) > 0) {
			if (fetchColumnValueOfLastRow(sheetRTObj, RT_UPTO) == "") {
				ComShowCodeMessage("DMT02002", "Up to");
				return;					
			} 
			else if (fetchColumnValueOfLastRow(sheetRTObj, RT_20FT) == "") {
				ComShowCodeMessage("DMT02002", "20FT");
				return;					
			} 
			else if (fetchColumnValueOfLastRow(sheetRTObj, RT_40FT) == "") {
				ComShowCodeMessage("DMT02002", "40FT");
				return;					
			} 
			else if (fetchColumnValueOfLastRow(sheetRTObj, RT_HC) == "") {
				ComShowCodeMessage("DMT02002", "H/C");
				return;					
			} 
			else if (fetchColumnValueOfLastRow(sheetRTObj, RT_45FT) == "") {
				ComShowCodeMessage("DMT02002", "45FT");
				return;					
			} 
			else if (fetchColumnValueOfLastRow(sheetRTObj, RT_R9) == "") {
				ComShowCodeMessage("DMT02002", "R9");
				return;					
			}
		}
						
		if (formObj.chkRateAdjustment.checked) {
			rtSeq	= fetchColumnValueOfLastRow(sheetRTObj, RT_SEQ);
			rtUpTo	= fetchColumnValueOfLastRow(sheetRTObj, RT_UPTO);
			
			rtSeq	= rtSeq  == "" ? 1 : ComParseInt(rtSeq)  + 1;
			rtFrom	= rtUpTo == "" ? 1 : ComParseInt(rtUpTo) + 1;
			
			//Rate Adjustment 그리드에 Row 를 생성한다.
			with(sheetRTObj) {
				DataInsert(-1);
				
				CellValue(LastRow, 		DAR_NO) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DAR_NO);
				CellValue(LastRow, 		MAPG_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, MAPG_SEQ);
				CellValue(LastRow, 		VER_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, VER_SEQ);
				CellValue(LastRow, 		DTL_SEQ) 	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DTL_SEQ);
				CellValue(LastRow, 		CVRG_SEQ)	= sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CVRG_SEQ);
				CellValue(LastRow, 		RT_SEQ) 	= rtSeq;
				CellValue(LastRow, 		RT_FROM) 	= rtFrom;
				CellEditable(LastRow, 	RT_FROM) 	= false;
			}
		}
	}

	/**
	 * Adjustment Request 정보를 복사한다.
	 */		
	function copyBKGReqDetail() {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];

 		//Copy 버튼 클릭시 데이터가 있는지 검사한다. ====================================================================================
		if (fetchRowCount(sheetRFAObj) == 0) {
			ComShowCodeMessage("DMT01117", "copy");
			return;
		}
		//==========================================================================================================================
			
		//1.Row Add 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구 ==========================
		var chkResult = isChangedBeforeException();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				//변경된 내용만 조회해서 그리드에 설정.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
				if (!saveBKGReqDetail(chkResult[0])) return;
			}
			else {
				//ComShowCodeMessage("DMT01115");
				return;
			}
		}
		//==========================================================================================================================
		
		with(sheetRFAObj) {
			//===============================================================================================================
			//Row 를 복사하면 자동으로 복사된 행이 생성되고 포커스가 이동한다.
			//포커스가 이동되면서 sheet1_OnSelect 함수를 호출하게 되고, 거기에서 변경된 내용이 있는지 조회하는 모듈을 태운다.
			//바로, 위 프로세스를 막기 위해서 아래와 같이 전역변수에 플래그값을 변경한다.
			isCopyRFAExceptionTariff = true;
			var row = DataCopy();
			isCopyRFAExceptionTariff = false;
			//===============================================================================================================
			
			//복사한 Row 를 시스템에 반영하기 위해서 상태를 '입력' 으로 설정해준다.
			RowStatus(row) = "I";
		
			//저장시점에 Multi 구분이 'Single' 인 Coverage 데이터를 Multi Origin or Dest. Grid 로
			//이동시킬때 정상처리를 위해서 Previous Origin or Dest. Multi 를 Clear 한다.
			CellValue(row, CURR_ORGDST_MULTI) = "";
		
			//Detail Sequence 는 저장할 때 시스템쪽에서 자동으로 생성해서 입력해준다.
			CellValue(row, DTL_SEQ) = "";
		}
		
		//Before Booking Request 의 해당 Detail 의 하위항목들을 모두 복사해준다.
		for (var sheetNo = 1 ; sheetNo < sheetObjects.length ; sheetNo++) {
			with(sheetObjects[sheetNo]) {
				for (var row = HeaderRows ; row <= LastRow ; row++) {
					RowStatus(row) 			= "I";
					CellValue(row, DTL_SEQ) = "";
				}
			}
		}		
	}
		
	/**
	 * SAVE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수(매개변수는 변경된 정보가 있는지 없는지 나타낸다.)
	 */				
	function saveBKGReqDetail(isChangedRFATariff) {
		var formObj			= document.form;
		var cboDARObj		= comboObjects[0];
		var sheetRFAObj		= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================
		//DAR NO가 없을때 Approval Office 에 대한 모든 DAR 정보를 조회하여 존재여부를 체크 한다.
		if (ComTrim(cboDARObj.Text) == "") {
			if(!doActionCheckByApprovalOfc()) {
				return;
			}
		}
		//=====================================================================================================
		
 		//Save 버튼 클릭시 데이터가 있는지 검사한다. ====================================================================================
		if (fetchRowCount(sheetRFAObj) == 0) {
			ComShowCodeMessage("DMT01117", "save");
			return;
		}
		//==========================================================================================================================
		
		//RFA Tariff Exception 의 변경여부를 체크하지 않았다면 체크해준다. ==============================================================
		if (!isChangedRFATariff) {
			//chkResult => 0: 결과, 1: 발생된 Row, 2:입력,수정,삭제 구분, 3:에러메시지
			var chkResult = isChangedBeforeException();
			if (!chkResult[0]) {
				ComShowCodeMessage("DMT01113");
				return false;
			}
		}
		//===========================================================================================================================
		
		//입력하거나 수정하거나 삭제된 내용을 반영한다.
		if (validateForm()) {
	
			//Before Booking Request 의 Origin or Dest. 가 Single 일 경우, 그 정보를 저장하기 위해서 Multi Origin or Dest. Grid 에 데이터를 복사한다.=======
			copyBKGDetailReqCoverageforSave();
			//======================================================================================================================================

			//Flag 정보를 세팅해준다. ================================================================================================================
			setFlagValues();
			//======================================================================================================================================

			//Save 버튼 클릭시에는 무조건 'Temp.Save' 로 설정한다. =====================================================================================
			ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, "T");
			//=====================================================================================================================================

			//추가, 수정, 삭제된 RFA Exception Tariff 를 DB 에 반영한다. =============================================================================
			doActionIBSheet(sheetRFAObj, formObj, IBSAVE_RFATARIFF);
			//=====================================================================================================================================

			//저장을 위해서 Multi Origin or Dest. Grid 에 복사한 데이터를 삭제한다. ====================================================================
			releaseBKGDetailReqCoverageforSave();
			//=====================================================================================================================================

			//저장 Action 이 정상실행시 Alert 창을 띄워주고, 조회를 실행한다. ===========================================================================
			if (ComGetObjValue(formObj.result) == "Y") {
				ComShowCodeMessage("DMT00001");

				doActionRetrieve(IBSEARCH_RFATARIFF);
			}
			//=====================================================================================================================================

		}
		else {
			return false;
		}

		return true;
	}	 
	
    /**
     * Before Exception Request 의 하위항목들에 대한 삭제를 수행하는 함수(전체, 선택항목 삭제)
     */	
	function delSubBeforeException(sheetObj, part) {
		
		with(sheetObj) {
			//Before Exception Request 의 하위 항목의 그리드내에 있는 모든 데이터를 삭제한다.
			if (part == "All") {
				for (var row = LastRow ; row >= HeaderRows ; row--) {
					if (RowStatus(row) == "I") {
						RowDelete(row, false);
					}
					else {
						RowStatus(row) = "D";
						RowHidden(row) = true;
					}
				}
			}
			//Before Exception Request 의 하위 항목의 그리드내에 있는 선택한 항목만을 삭제한다.
			else {
				// 선택된 행이 없을 경우 실행하지 않는다.
				if (SelectRow == -1) return;
				
				// RateAdjustment 는 마지막행부터 삭제해야 합니다.
				if (id == "sheet3") {
					if (SelectRow == LastRow) {
						if (RowStatus(SelectRow) == "I") {
							RowDelete(SelectRow, false);
						}
						else {
							RowStatus(SelectRow) = "D";
							RowHidden(SelectRow) = true;
						}
					}
					else {
						ComShowCodeMessage("DMT01181");	//You must delete from last row
					}
				}
				else {
					if (RowStatus(SelectRow) == "I") {
						RowDelete(SelectRow, false);
					}
					else {
						RowStatus(SelectRow) = "D";
						RowHidden(SelectRow) = true;
					}
				}
			}
		}
	}
	 
	/*
	 * Before Exception Request 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableDetail(flag) {
		var sheetRFAObj = sheetObjects[0];
		var tmpStatus	= "";
		
		with(sheetRFAObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				//================================================================
				//아래 로직을 수행하는 동안 Row 의 상태가 자동으로 변경되는걸  
				//방지하기 위해서 그 이전 상태값을 임시저장했다가 설정 후 원복해준다.
				tmpStatus = RowStatus(row);
				//================================================================
				
				CellEditable(row, TARIFF) 		= flag;
				CellEditable(row, EFF_DT) 		= flag;
				CellEditable(row, EXP_DT) 		= flag;
				CellEditable(row, CNTRCGO) 		= flag;
				CellEditable(row, CVRG_CNT) 	= flag;
				CellEditable(row, CVRG_RGN) 	= flag;
				CellEditable(row, CVRG_LOC) 	= flag;
				CellEditable(row, FT_FLG) 		= flag;
				
				if (flag && CellValue(row, FT_FLG) == 1) {
					CellEditable(row, ADD_DYS) = true;
					CellEditable(row, TOT_DYS) = true;	
					CellEditable(row, SAT_FLG) = true;
					CellEditable(row, SUN_FLG) = true;
					CellEditable(row, HOL_FLG) = true;				
				}
				else {
					CellEditable(row, ADD_DYS) = false;
					CellEditable(row, TOT_DYS) = false;	
					CellEditable(row, SAT_FLG) = false;
					CellEditable(row, SUN_FLG) = false;
					CellEditable(row, HOL_FLG) = false;
				}				

				CellEditable(row, ORGDST_MULTI) = flag;

				if (flag && CellValue(row, ORGDST_MULTI) == "M") {
					CellEditable(row, ORGDST_CTI) = false;
					CellEditable(row, ORGDST_CNT) = false;
					CellEditable(row, ORGDST_RGN) = false;
					CellEditable(row, ORGDST_LOC) = false;
				} 
				else {
					CellEditable(row, ORGDST_CTI) = flag;
					CellEditable(row, ORGDST_CNT) = flag;
					CellEditable(row, ORGDST_RGN) = flag;
					CellEditable(row, ORGDST_LOC) = flag;
				}


				//BKG DEL(I) or POR(O) 필드의 활성화 여부는 Tariff 필드의 입력값에 따라서 달라진다.
				if (flag) { 
					changeBKGDELorPOR(sheetRFAObj, row); 
				}
				else { 
					CellEditable(row, BKGDEL_CNT) = false; 
					CellEditable(row, BKGDEL_RGN) = false;
					CellEditable(row, BKGDEL_LOC) = false;
				}
	
				CellEditable(row, CUST_CD) 		= flag;				
				CellEditable(row, REMARK) 		= flag;
				
				//각 ROW 의 Editable 한 상태값을 기억하기 위해서 저장함.
				CellValue(row, ROW_EDIT_STS)	= flag ? "Y" : "N";
				
				//한 Row 에 대한 설정이 완료된 후 Row 의 상태를 원복시킨다. =============
				RowStatus(row) = tmpStatus;
				//================================================================
			}
		}
		
		//Detail 버튼을 주어진 플래그에 맞게 활성화 / 비활성화 시킨다.
		if (flag) {
			ComBtnEnable("btn_AddBKGReqDetail");
			ComBtnEnable("btn_CopyBKGReqDetail");
			ComBtnEnable("btn_SaveBKGReqDetail");
			ComBtnEnable("btn_DelBKGReqDetail");
		}
		else {
			ComBtnDisable("btn_AddBKGReqDetail");
			ComBtnDisable("btn_CopyBKGReqDetail");
			ComBtnDisable("btn_SaveBKGReqDetail");
			ComBtnDisable("btn_DelBKGReqDetail");
		}
	}

	/**
	 * Before Booking Request 의 Multi Origin or Dest. 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableMultiOrgDest(flag) {
		var sheetCVRGObj = sheetObjects[1];
		
		with(sheetCVRGObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				CellEditable(row, ORGDST_CTI) = flag;
				CellEditable(row, ORGDST_CNT) = flag;
				CellEditable(row, ORGDST_RGN) = flag;
				CellEditable(row, ORGDST_LOC) = flag;
			}
		}

		//Multi Origin or Dest. 버튼을 주어진 플래그에 맞게 활성화 / 비활성화 시킨다.
		if (flag) {
			ComBtnEnable("btn_AddMultiOrgDest");
			ComBtnEnable("btn_DelMultiOrgDest");
		}
		else {
			ComBtnDisable("btn_AddMultiOrgDest");
			ComBtnDisable("btn_DelMultiOrgDest");
		}
	}
	
	/**
	 * S/C Exception Rate Adjustment 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableRateAdjustment(flag, isClicked) {
		var formObj		= document.form;
		var sheetRTObj 	= sheetObjects[2];

		isClicked = (isClicked == undefined) ? false : isClicked;
		
		//체크박스와 Currency 콤보박스 활성화 / 비활성화
		if (!isClicked) {
			with(formObj) {
				ComEnableManyObjects(flag, chkRateAdjustment, currency);
	
				if (flag)
					currency.className	= "input";
				else
					currency.className	= "input2";
			}
		}

		with(sheetRTObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				CellEditable(row, RT_FROM) 	= false;
				CellEditable(row, RT_UPTO) 	= flag;
				CellEditable(row, RT_20FT) 	= flag;
				CellEditable(row, RT_40FT) 	= flag;
				CellEditable(row, RT_HC) 	= flag;
				CellEditable(row, RT_45FT) 	= flag;
				CellEditable(row, RT_R9) 	= flag;
			}			
		}

		//Rate Adjustment 버튼을 주어진 플래그에 맞게 활성화 / 비활성화 시킨다.
		if (flag && formObj.chkRateAdjustment.checked) {
			ComBtnEnable("btn_AddRateAdjustment");
			ComBtnEnable("btn_DelRateAdjustment");
		}
		else {
			ComBtnDisable("btn_AddRateAdjustment");
			ComBtnDisable("btn_DelRateAdjustment");
		}
	}
	
	/**
	 * Before Booking Adjustment Request 정보를 삭제한다.
	 */		
	function delBKGReqDetail() {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================
		
		with(sheetRFAObj) {
			if (fetchRowCount(sheetRFAObj) > 0) {

				//삭제될 정보의 Key 값을 임의 저장한다. 
				if (RowStatus(SelectRow) != 'I') {
					
					//Before Booking Request 의 Detail 정보를 삭제할 것인지 확인한다.
					if (fetchRowCount(sheetRFAObj) == 1) {
						ComShowCodeMessage("DMT01123");
						return;
					}
					else if (fetchRowCount(sheetRFAObj) > 1) {
						if (!ComShowCodeConfirm("DMT00135", "delete")) return;
					}

					//삭제된 Row 를 DB에 반영시키는 Action 을 수행한다. ===============================================================
					doActionIBSheet(sheetRFAObj, formObj, IBDELETE_RFATARIFF);
					//=============================================================================================================
					
					if (ComGetObjValue(formObj.result) != "Y") {
						ComShowCodeMessage("DMT00008", "save");
						return;
					}
				}
				
				//Before Booking Request 의 Detail 정보를 삭제한다. =================================================================
				//하위 항목들을 모두 삭제해 주고, 기본값으로 초기화 시킨다.
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				
				RowDelete(SelectRow, false);
				//=================================================================================================================
				
				if (fetchRowCount(sheetRFAObj) > 0) {
					//자동 선택된 Detail Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.)  
					setSubBeforeException(true);
				}
				else {
					//재조회를 수행한다.
					doActionRetrieveBBR(IBSEARCH);
				}
			}
		}
	}
	
	/**
	 * BKG DEL(I) or PRO(O) 필드의 상태변경 : Tariff 가 DMIF/DMOF 일 때만 입력 활성화
	 */		
	function changeBKGDELorPOR(sheetObj, selectedRow) {
		var trfCd = ComTrim(sheetObj.CellValue(selectedRow, TARIFF));
		
		if (trfCd == "DMIF" || trfCd == "DMOF") {
			sheetObj.CellEditable(selectedRow,	BKGDEL_CNT) 	= true;
			sheetObj.CellEditable(selectedRow,	BKGDEL_RGN) 	= true;
			sheetObj.CellEditable(selectedRow,	BKGDEL_LOC) 	= true;
		}
		else {
			sheetObj.CellValue(selectedRow,	BKGDEL_CNT) 		= "";
			sheetObj.CellValue(selectedRow,	BKGDEL_RGN) 		= "";
			sheetObj.CellValue(selectedRow,	BKGDEL_LOC) 		= "";
			
			sheetObj.CellEditable(selectedRow,	BKGDEL_CNT) 	= false;
			sheetObj.CellEditable(selectedRow,	BKGDEL_RGN) 	= false;
			sheetObj.CellEditable(selectedRow,	BKGDEL_LOC) 	= false;
		}		
	}
		
	/**
	 * 주어진 Sheet 내에서 마지막  Row 의 지정한 컬럼의 정보를 읽어오는 함수
	 */	
	function fetchColumnValueOfLastRow(sheetObj, COL) {
		var lastColumnValue = "";
		
		with(sheetObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (RowStatus(row) != "D") {
					lastColumnValue = CellValue(row, COL);
					break;
				}
			}
		}
		return lastColumnValue;		
	}	

	/**
	 * 선택한 Version 의 Status Code, Text, Request Office Code 를 반환해주는 함수
	 */		
	function getVerStatus(type) {
		var formObj 	= document.form;
		var verInfo 	= ComTrim(ComGetObjValue(formObj.version));
		
		if (verInfo.indexOf(":") != -1) {
			var stsArr = verInfo.split(":");
			if (type == "Code") { 
				return stsArr[0]; 
			}
			else if (type == "Text") { 
				return stsArr[1]; 
			}
			else if (type == "ReqOfc") {
				return stsArr[2];
			}
		}
		return "";
	}
	 
	/**
	 * S/C Proposal Creation 화면에서 호출되었는지를 구분해주는 함수
	 */		
	function isProposalCreationScreen() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (ComTrim(ComGetObjValue(formObj.isEditable)) == "Y") {
			return true;	
		} else {
			return false;
		}		
	}
	
	/**
	 * 메인 버튼에 대해서 주어진 조건에 따라 상태를 변경하는 함수 
	 */					
	function initBtnControl() {
		var formObj  = document.form;
		
    	// Baisc RFA 인지 여부
		var bzcRfaYn = ComGetObjValue(formObj.bzc_rfa_yn);
		// Prop No. 에 해당되는 BBE( Before Booking Exception ) 등록 여부
		var existRfaYn = ComGetObjValue(formObj.exist_rfa_yn);
		// Basic RFA 생성시 copy 된 Master RFA 의 버전보다 상위 버전이 존재하는지 여부 
		var mstRfaVerUpprYn = ComGetObjValue(formObj.mst_rfa_ver_uppr_yn);   
		// 버전 상태
		var rfaVerSts = getVerStatus("Code");
		
    	// Basic RFA 인 경우
    	if (bzcRfaYn == "Y") {
    		// Update 버튼명 변경
    		no_btn_Update.innerText = "Auto Update";
    		
			// Disable Btn
    		ComBtnDisable("btn_New");
    		ComBtnDisable("btn_Update");
			ComBtnDisable("btn_Request");    		
			ComBtnDisable("btn_Cancel");
			ComBtnDisable("btn_Approval");
			ComBtnDisable("btn_Reject");
			ComBtnDisable("btn_CounterOffer");
			
    		if (existRfaYn == "Y" && isProposalCreationScreen()) {

    			// 'Temp' 상태인 경우, Request 버튼만 활성화 한다.
    			if (rfaVerSts == "T") {
    				ComBtnEnable("btn_Request");
    			}
    			
    			// '승인' 상태일 경우, Master RFA 의 버전을 비교해서 상위버전이 존재할 경우, Auto Update 버튼만 활성화 한다.
    			if (rfaVerSts == "A" && mstRfaVerUpprYn == "Y") {
    				ComBtnEnable("btn_Update");
    			}
    		}
    	}
    	else {
    		// Update 버튼명 변경
    		no_btn_Update.innerText = "Update";
    		
			//New Button
			initBtnNew();	
			//Update Button
			initBtnUpdate();
			//Request Button
			initBtnRequest();
			//Cancel Button
			initBtnCancel();
			//Approval Button
			initBtnApproval();
			//Counter Offer Button
			initBtnCounterOffer();
			//Reject Button
			initBtnReject();
    	}
	}
				
	/**
	 * 조건에 따라서 New 버튼의 상태가 변경된다.
	 */		
	function initBtnNew() {
		//RFA Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			ComBtnEnable("btn_New");
		} else {
			ComBtnDisable("btn_New");
		}		
	}

	/**
	 * 조건에 따라서 Update 버튼의 상태가 변경된다.
	 */		
	function initBtnUpdate() {
		var formObj = document.form;
				
		//RFA Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {

	    	//1.아래 모든 조건이 PASS 되어야만 활성화가 된다.
			//1-1.로그인 Office 와 Requested의 Office가 동일한 경우에만 활성화
			var isPass1 = ComGetObjValue(formObj.ofc_cd) == getVerStatus("ReqOfc");
	    	//
	    	//1-2.현재버전이 최종버전일 경우에만 활성화
	    	var isPass2 = isMatchVersion();
	    	
	    	//1-3.Status 가 Requested 인 경우 활성화
	    	var isPass3 = isPermitStatus("Update");
	    	
	    	if (isPass1 && isPass2 && isPass3)
	    		ComBtnEnable("btn_Update");
	    	else
	    		ComBtnDisable("btn_Update");
	    	
		} else {
			ComBtnDisable("btn_Update");
		}		
	}
	
	/**
	 * 조건에 따라서 Request 버튼의 상태가 변경된다.
	 */		
	function initBtnRequest() {
				
		//RFA Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			
			//1.아래 모든 조건이 PASS 되어야만 활성화가 된다.
	    	//1-1.Status 가 Requested 인 경우 활성화
	    	var isPass1 = isPermitStatus("Request");
			
	    	if (isPass1)
	    		ComBtnEnable("btn_Request");
	    	else
	    		ComBtnDisable("btn_Request");
		} else {
			ComBtnDisable("btn_Request");
		}
	}
	
	/**
	 * 조건에 따라서 Cancel 버튼의 상태가 변경된다.
	 */		
	function initBtnCancel() {
		var formObj = document.form;
		var sheetObj1 = sheetObjects[0];
				
		//RFA Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var statusCd = getVerStatus("Code");
			
			var rqstOfcCd = "";
			if (sheetObj1.RowCount > 0) rqstOfcCd = sheetObj1.CellValue(sheetObj1.HeaderRows, RQST_OFC_CD);
			var logOfcCd = ComGetObjValue(formObj.ofc_cd);
						 		
			//1.Status 가 Requested, Temp.Saved 일 때에만 활성화
			//2.Request 점소가 로그인한 경우에만 활성화(위 두 조건을 모두 만족해야 활성화 됨)
			if (rqstOfcCd == logOfcCd && (statusCd == "R" || statusCd == "T" || statusCd == "O")) {
				ComBtnEnable("btn_Cancel");
			} else {
				ComBtnDisable("btn_Cancel");
			}
		} else {
			ComBtnDisable("btn_Cancel");
		}		
	}
	
	/**
	 * 조건에 따라서 Approval 버튼의 상태가 변경된다.
	 */		
	function initBtnApproval() {
		var formObj = document.form;
				
		//RFA Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {

	    	//1.아래 모든 조건이 PASS 되어야만 활성화가 된다.
	    	//1-1.로그인 User 가 Security 상에서 UI_DMT_2005(DAR-Before BKG Approval)의 Access 권한이 있을 경우 활성화
	    	var isPass1 = isPermitRole();
	    	
	    	//1-2.Approval Office 와 로그인 점소의 소속 지역본부/본수(NYCRA, HAMRU, SHARC, SINRS, SELHO) 가 동일할 경우에만 활성화
	    	var isPass2 = isMatchOffice();
	    	
	    	//1-3.현재버전이 최종버전일 경우에만 활성화
	    	var isPass3 = isMatchVersion();
	    	
	    	//1-4.Status 가 Requested 인 경우 활성화
	    	var isPass4 = isPermitStatus("Approval");
	    	
	    	if (isPass1 && isPass2 && isPass3 && isPass4)
	    		ComBtnEnable("btn_Approval");
	    	else
	    		ComBtnDisable("btn_Approval");			
			
		} 
		else {
			ComBtnDisable("btn_Approval");
		}		
	}	
		
	/**
	 * 조건에 따라서 Reject 버튼의 상태가 변경된다.
	 */		
	function initBtnReject() {
		var formObj = document.form;
				
		//RFA Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {

	    	//1.아래 모든 조건이 PASS 되어야만 활성화가 된다.
	    	//1-1.로그인 User 가 Security 상에서 UI_DMT_2005(DAR-Before BKG Approval)의 Access 권한이 있을 경우 활성화
	    	var isPass1 = isPermitRole();

	    	//1-2.Approval Office 와 로그인 점소의 소속 지역본부/본수(NYCRA, HAMRU, SHARC, SINRS, SELHO) 가 동일할 경우에만 활성화
	    	var isPass2 = isMatchOffice();

	    	//1-3.현재버전이 최종버전일 경우에만 활성화
	    	var isPass3 = isMatchVersion();
	    	
	    	//1-4.Status 가 Requested 인 경우 활성화
	    	var isPass4 = isPermitStatus("Reject");
	    	
	    	if (isPass1 && isPass2 && isPass3 && isPass4)
	    		ComBtnEnable("btn_Reject");
	    	else
	    		ComBtnDisable("btn_Reject");				
			
		} else {
			ComBtnDisable("btn_Reject");
		}		
	}
		
	/**
	 * 조건에 따라서 Counter Offer 버튼의 상태가 변경된다.
	 */		
	function initBtnCounterOffer() {
		var formObj = document.form;
		
		//RFA Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			
	    	//1.아래 모든 조건이 PASS 되어야만 활성화가 된다.
	    	//1-1.로그인 User 가 Security 상에서 UI_DMT_2005(DAR-Before BKG Approval)의 Access 권한이 있을 경우 활성화
	    	var isPass1 = isPermitRole();

	    	//1-2.Approval Office 와 로그인 점소의 소속 지역본부/본수(NYCRA, HAMRU, SHARC, SINRS, SELHO) 가 동일할 경우에만 활성화
	    	var isPass2 = isMatchOffice();
	    	
	    	//1-3.현재버전이 최종버전일 경우에만 활성화
	    	var isPass3 = isMatchVersion();
	    	
	    	//1-4.Status 가 Requested 인 경우 활성화
	    	var isPass4 = isPermitStatus("CounterOffer");
	    	
	    	if (isPass1 && isPass2 && isPass3 && isPass4)
	    		ComBtnEnable("btn_CounterOffer");
	    	else
	    		ComBtnDisable("btn_CounterOffer");
			
		} else {
			ComBtnDisable("btn_CounterOffer");
		}		
	}
		
	/**
	 * 주어진 Sheet 내 마지막 Row 데이터 중 주어진 컬럼이 Empty 인지를 체크하는 함수
	 * 선택항목이고, 입력된 데이터가 없을 경우에는 false 를 반환한다.
	 */			
	function isEmptyColumnOfLastRow(sheetObj, COL) {
		var isEmptyColumn = false;
		
		with(sheetObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (RowStatus(row) != "D") {
					if (ComTrim(CellValue(row, COL)) == "") 
						isEmptyColumn = true;
					break;
				}
			}
		}

		return isEmptyColumn;		
	}
		
	/**
	 * 주어진 Sheet 내 데이터가 존재하는지를 체크하는 함수 
	 */
	function fetchRowCount(sheetObj) {
		var totCount = 0;
		
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (RowStatus(row) != "D") {
					totCount++
				}
			}
		}
		return totCount;	
	}
		
	/*
	 * 주어진 Sheet 내 주어진 row 다음 row 의 인덱스를 반환하는 함수
	 */	
	function getNextRow(currRow, sheetObj) {
		var sheetObj1 = sheetObjects[0];
		
		var darNo = sheetObj1.CellValue(sheetObj1.SelectRow, DAR_NO);
		var mapgSeq = sheetObj1.CellValue(sheetObj1.SelectRow, MAPG_SEQ);
		var verSeq = sheetObj1.CellValue(sheetObj1.SelectRow, VER_SEQ);
		var dtlSeq = sheetObj1.CellValue(sheetObj1.SelectRow, DTL_SEQ);
		
		var nextRow = -1;
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				//삭제된 데이터에 대해서는 처리하지 않는다.		
				if (CellValue(row, HID_STATUS) != "Y") {				
					if (darNo == CellValue(row, DAR_NO) &&
						mapgSeq == CellValue(row, MAPG_SEQ) &&
						verSeq == CellValue(row, VER_SEQ) &&
						dtlSeq == CellValue(row, DTL_SEQ)) {
							
						if (row > currRow) {
							nextRow = row;
							break;
						}
					}
				}
			}
		}				
		return nextRow;			
	}
			
	/*
	 * BKG POR(O) or DEL(I) 입력된 CN 의 Continent 와 Coverage 의 Continent
	 * 가 동일한지 비교를 한다. 
	 */		
	function equalContinentByCN(selectRow) {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		var orgCN = ComTrim(sheetObj.CellValue(selectRow, BKGDEL_CNT));
		
		//옵션항목이므로 입력되지 않았을 경우 PASS
		if (orgCN.length == 0) return true;
		
		var trgCN = ComTrim(sheetObj.CellValue(selectRow, CVRG_CNT));
		
		ComSetObjValue(formObj.fnl_dest_cnt_cd, orgCN);
		ComSetObjValue(formObj.cnt_cd, trgCN);

		doActionIBSheet(sheetObj,formObj,IBSEARCH_CHKCONTI);
		chkOutData = ComGetObjValue(formObj.result);
		
		if (chkOutData == "Y") { return true; }
		else { return false; }
	}
	
	/*
	 * 주어진 값이 "" 일 경우 " " 로 변경해주는 함수
	 */	
	function changeNullToSpace(str) {
		return ComTrim(str).length == 0 ? " " : ComTrim(str);
	}	
	
	/*
	 * Rate Adjustment 체크박스를 클릭할 경우 실행될 동작을 정의하는 함수
	 */	
	function checkRateAdjustment() {
		var formObj 	= document.form;
		var sheetRFAObj = sheetObjects[0];
		
		with(sheetRFAObj) {
			//1.필수항목인 상태에서 UnCheck 할 경우 막아야 함.
			if (CellValue(SelectRow, RT_MANDATORY) == "Y" && !formObj.chkRateAdjustment.checked) {
				ComShowCodeMessage("DMT00129", CellValue(SelectRow, "Seq"));
				formObj.chkRateAdjustment.checked = true;
				return;
			}
			
			//2.Country 가 선택되지 않은 상태에서 Check 할 경우 막아야 함.
			if (CellValue(SelectRow, CVRG_CNT) == "" && formObj.chkRateAdjustment.checked) {
				ComShowCodeMessage("DMT00130");
				formObj.chkRateAdjustment.checked = false;
				return;
			}			
		}
		
		//3.Rate Adjustment 항목을 선택했다면
		if (formObj.chkRateAdjustment.checked) {
			doActionCheckOnRateAdjustment();				
		} 
		//4.선택 해제하였다면 등록된 항목들을 모두 삭제하고 비활성화시킨다.
		else {
			doActionUnCheckOnRateAdjustment();
		}
	}
	
	/**
	 * Rate Adjustment 를 Check 할 경우 동작을 정의하는 함수
	 */		 
	function doActionCheckOnRateAdjustment() {
		var sheetRFAObj = sheetObjects[0];

		//1.Currency 를 조회한다.
		searchCurrencyList(sheetRFAObj.SelectRow);
		//2.입력모드로 변경
		editableRateAdjustment(true);
		//3.체크상태 변경
		sheetRFAObj.CellValue(sheetRFAObj.SelectRow, RT_CHECK) = "Y";
		//4.자동으로 Row 를 추가해준다.(2009-07-28)
		addRateAdjustment();
	}
	
	/**
	 * Rate Adjustment 를 Check 해제할 경우 동작을 정의하는 함수
	 */		 
	function doActionUnCheckOnRateAdjustment() {
		var formObj 	= document.form;
		var sheetRFAObj = sheetObjects[0];
		var sheetRTObj 	= sheetObjects[2];
		
		//1.RateAdjustment 항목을 모두 지워준다.
		delSubBeforeException(sheetRTObj, "All");
		//2.Currency 항목을 모두 지워준다.
		ComClearCombo(formObj.currency);
		//3.Currency 변수값을 Empty 로 설정한다.
		sheetRFAObj.CellValue(sheetRFAObj.SelectRow, CURR_CD) = "";
		//4.비입력모드로 변경
		//  두번째 인자는 Rate Adjustment 체크박스를 클릭해서 발생된 이벤트인지 구분하기 위함이다. 
		//  그럴경우에는 Rate Adjustment, Currency 컬럼은 제외된다.
		editableRateAdjustment(false, true);
		//5.체크상태 변경
		sheetRFAObj.CellValue(sheetRFAObj.SelectRow, RT_CHECK) = "N";		
	}
		 
	/*
	 * 화면에 입력된 필드값에 따라서 Flag 필드값을 설정해준다.
	 */			
	function setFlagValues() {
		var sheetRFAObj	= sheetObjects[0];
		var sheetRTObj	= sheetObjects[2];
		
		with(sheetRFAObj) {
			//1.RT_USE_FLG 은 Rate Adjustment 가 입력되면 Y
			if (fetchRowCount(sheetRTObj) > 0) {
				CellValue(SelectRow, RT_USE_FLG) = "Y";
			} else {
				CellValue(SelectRow, RT_USE_FLG) = "N";
			}
			
			//2.FNL_DEST_FLG 은 BKG DEL(I) or POR(O) 선택항목에 입력되면 Y
			if (ComTrim(CellValue(SelectRow, BKGDEL_CNT)) != "") {
				CellValue(SelectRow, FNL_DEST_FLG) = "Y";
			} else {
				CellValue(SelectRow, FNL_DEST_FLG) = "N";
			}
		}
	}	
    
   /**
    * Approval Office 가 변경될 경우 해당 데이터가 존재하는지 확인한다.
    */		 
    function doActionRetrieveByApprovalOfc() {
    	var formObj 		= document.form;
    	var cboDARObj 		= comboObjects[0];
    	var cboAPVLObj 		= comboObjects[1];
    	var sheetRFAObj		= sheetObjects[0];
    	var sheetCVRGObj	= sheetObjects[1];
    	var sheetRTObj		= sheetObjects[2];
    	var sheetHSTObj		= sheetObjects[3];
    	
		//1.Approval Office 에 해당되는 DAR 목록 조회를 위한 매개변수를 설정한다.
		ComSetObjValue(formObj.apro_ofc_cd, ComGetObjValue(formObj.approvalOfcCd));
		
		//2.Approval Office 에 해당되는 DAR 목록 조회를 수행한다.(Approval Office 가 '' 일 경우 Version 에 해당되는 모든 DAR 를 조회한다.)
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR);

		//3-1.APVL No. 목록 조회를 실행한다.
		if (ComGetObjValue(formObj.approvalOfcCd) == "")
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO);

		//4.Approval Office 에 해당되는 DAR 목록이 있다면
		if (cboDARObj.GetCount() > 0 && ComGetObjValue(formObj.approvalOfcCd) != "") {

			doActionRetrieve(IBSEARCH);
		}
		//5.Approval Office 에 해당되는 DAR 목록이 없다면
		else {
			//5-1.DAR No.목록을 Empty 로 보여준다.
			cboDARObj.Index = -1;
			
			//5-2.VER 목록을 001 로 초기화 시킨다.
			addComboItem(formObj.version, "001=", true);

			//5-3.Status 를 Clear 시킨다.
			ComClearObject(formObj.status);
			
			//5-4.APVL No.목록을 Empty 로 보여준다.
			if (ComGetObjValue(formObj.approvalOfcCd) != "")
				cboAPVLObj.RemoveAll();
			else
				cboAPVLObj.Index = -1;
			
			//5-5.모든 그리드를 Clear 시켜준다.
			sheetRFAObj.RemoveAll();
			sheetCVRGObj.RemoveAll();
			sheetRTObj.RemoveAll();
			sheetHSTObj.RemoveAll();
			
			//5-6.Comment 를 Clear 시킨다.
			ComSetObjValue(formObj.comment, "");
			
			//5-7.Before Exception Request Detail 활성화
			if (ComGetObjValue(formObj.isEditable) == "Y")
				editableDetail(true);
			else
				editableDetail(false);
			
			//5-8.하위 정보들을 초기화 시킨다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
			setSubBeforeException(false);
			
			//5-9.메인 버튼의 상태를 주어진 조건에 따라서 활성화 or 비활성화 시킨다.
			initBtnControl();  
		}
    }
    
    /**
     * Approval Office 에 대한 모든 DAR 정보를 조회하여 존재여부를 체크 한다.
     */		 
    function doActionCheckByApprovalOfc() {
    	var formObj 		= document.form;
    	var cboDARObj 		= comboObjects[0];
    	var sheetRFAObj		= sheetObjects[0];
    	
		//1.Approval Office 에 해당되는 DAR 목록 조회를 위한 매개변수를 설정한다.
		ComSetObjValue(formObj.apro_ofc_cd, ComGetObjValue(formObj.approvalOfcCd));
		
		//2.Approval Office 에 해당되는 DAR 목록 조회를 수행한다.(Approval Office 가 '' 일 경우 Version 에 해당되는 모든 DAR 를 조회한다.)
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR_CHECK);
		
		if(formObj.dar_no_check.value == "Y"){
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return false;	
		}
		return true;
    }
    
    /**
     * DAR No. 가 변경될 경우 해당 데이터를 조회한다.
     */	    
 	function combo1_OnChange(comboObj, Index_Code, Text) {
    	 
    	//조회된 결과를 Combo 에 추가한 후 특정 Item 을 선택할 경우 발생되는 예기치 않은 Action 을
    	//막기 위해서 아래 조건을 추가하였음.
    	if (!isSettingValue) 
    		doActionRetrieveByDARChange();
    }
     
    /**
     * APVL No. 가 변경될 경우 해당 데이터를 조회한다.
     */	    
  	function combo2_OnChange(comboObj, Index_Code, Text) {

    	//조회된 결과를 Combo 에 추가한 후 특정 Item 을 선택할 경우 발생되는 예기치 않은 Action 을
    	//막기 위해서 아래 조건을 추가하였음.
  		if (!isSettingValue)
  			doActionRetrieveByAPVLNoChange();
     }     
    
   /**
    * DAR No. 가 변경될 경우 해당 데이터를 조회한다.
    */		 
    function doActionRetrieveByDARChange() {
    	var formObj 	= document.form;
    	var cboDARObj 	= comboObjects[0];
    	var sheetRFAObj	= sheetObjects[0];

    	if (ComTrim(cboDARObj.Code) != "") {
    		
        	//1.APVL OFC 를 설정해준다.
        	ComSetObjValue(formObj.approvalOfcCd,  cboDARObj.Code);
    		
    		//2.DAR 에 해당하는 Version 정보와 Before Booking Request 조회를 수행한다.
    		doActionRetrieve(IBSEARCH);
    	}
    }
    
    /**
     * APVL No. 가 변경될 경우 해당 데이터를 조회한다.
     */	    
    function doActionRetrieveByAPVLNoChange() {
    	var formObj 	= document.form;
    	var cboDARObj 	= comboObjects[0];
    	var cboAPVLObj 	= comboObjects[1];
    	var sheetRFAObj	= sheetObjects[0];

    	if (ComTrim(cboAPVLObj.Code) != "") {

        	//1.APVL No. 에 해당되는 APVL OFC, DAR No., Version, APVL No. 를 조회한다.
        	doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_RFATARIFF_APVLNO);

        	//2.APVL OFC 를 설정해준다.
        	ComSetObjValue(formObj.approvalOfcCd, ComGetObjValue(formObj.apvlno_ofc));
        	ComSetObjValue(formObj.apro_ofc_cd,	  ComGetObjValue(formObj.apvlno_ofc));
        	
        	//3.APVL OFC 에 해당되는 DAR 정보를 조회한다.
        	doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR);
        	
    		//4.APVL OFC, DAR No., Version 에 해당되는 정보를 조회한다.(두번째 옵션은 Version 정보를 조회할지를 나타냄)
        	doActionRetrieve(IBSEARCH);
        	
        	//5.1번에서 조회된 결과값을 임의저장하는 변수를 초기화한다.
        	ComSetObjValue(formObj.apvlno_ofc, "");
        	ComSetObjValue(formObj.apvlno_dar, "");
        	ComSetObjValue(formObj.apvlno_ver, "");
    	}
    }
    
    /**
     * Version 이 변경될 경우 해당 데이터를 조회한다.
     */		 
     function doActionRetrieveByVerChange() {
    	var formObj 	= document.form;
    	var cboDARObj	= comboObjects[0];
    	var cboAPVLObj	= comboObjects[1];
     	var sheetRFAObj	= sheetObjects[0];
     	
     	if (ComGetObjText(formObj.version) != "") {

     		//1.선택한 Version 이 승인일 경우 APVL No.를 조회한다.
			if (getVerStatus("Code") == "A") {
				//조회조건을 설정한다.
				ComSetObjValue(formObj.prop_no, 			"");
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(cboDARObj.Text));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
				
				//조회를 실행한다.
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO);
			}
			//1-1.승인된 버전이 아닐경우에는 APVL No. 를 Clear 해준다.
			else {
				cboAPVLObj.RemoveAll();
			}
 			
			//2.Before Booking Request 조회를 수행한다.
			doActionRetrieveByVer(IBSEARCH);			
        }
    }
     
  	/**
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function doProcessPopup(srcName) {
  		var sheetObj 	= sheetObjects[0];
  		var formObj		= document.form;
  		
  		with(sheetObj) {
  	  		switch(srcName) {
  	  			case "Affiliate":		// Affiliate Inquiry Popup
		  	  		var paramVal 	= "?cond_prop_no=" + ComGetObjValue(formObj.proposalNo);
  	  				var rtnVal 		= ComOpenWindowCenter("ESM_PRI_2019_06.do" + paramVal, "", 1020, 335, true);
  	  				
  					break;

  	  		} // switch-end
  		} // with-end
  	} 
  	 
 	/**
 	 * 선택한 Before Booking Request 데이터의 Tariff 에 따라서 Multi Origin or Destination 의 제목을 변경한다.
 	 */	  	 
  	function setMultiOrgDestTitle() {
		var sheetRFAObj		= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		 
		var trfCd = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, TARIFF);

		var HeadTitle1 = "";
		var HeadTitle2 = "|Seq.|Continent|Country|Region|Location";	
		switch(trfCd) {
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
		
		sheetCVRGObj.InitHeadRow(0, HeadTitle1, true);
		sheetCVRGObj.InitHeadRow(1, HeadTitle2, true);  		
  	}
 	 
  	/**
  	 * Rate Adjustment 항목을 선택하거나 선택해제시 수행해야할 동작을 정의하는 함수
  	 */	
 	 function checkComment() {
  		var formObj 	= document.form;
 		var sheetHSTObj	= sheetObjects[3];
 		
 		with(formObj) {
 			if (chkComment.checked) {
 				ComSetObjValue(comment, "");
 			}
 			else {
 				ComSetObjValue(comment, sheetHSTObj.CellValue(sheetHSTObj.SelectRow, PROG_RMK));
 			}
 			
			//Comment 활성화 / 비활성화+++++++++++++++++++++++++
			//ComEnableObject(formObj.comment, false);
			comment.readOnly 	= !chkComment.checked;
			//팝업창에서 글자짤림 현상 수정
			if (chkComment.checked) {
				comment.style.backgroundColor = "#CCFFFD";	//textarea1
			}
			else {
				comment.style.backgroundColor = "#E8E7EC";	//textarea2
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++
 	 	}
 	}
  	 
   	/**
   	 * Rate Adjustment 항목의 필수, 선택여부를 체크하는 함수
   	 */	  	 
  	function checkMandatoryRateAdjustment() {
  		var formObj 	= document.form;
  		var sheetRFAObj	= sheetObjects[0];
  		var sheetRTObj	= sheetObjects[2];

  		with(sheetRFAObj) {
	  		var tariff 	= ComTrim(CellValue(SelectRow, TARIFF));
	  		var effDt 	= ComTrim(CellValue(SelectRow, EFF_DT));
	  		var expDt 	= ComTrim(CellValue(SelectRow, EXP_DT));
	  		var cntrCgo = ComTrim(CellValue(SelectRow, CNTRCGO));
	
	  		//Coverage 설정
	  		var cntCd 	= ComTrim(CellValue(SelectRow, CVRG_CNT));
	  		var rgnCd 	= ComTrim(CellValue(SelectRow, CVRG_RGN));
	  		var locCd 	= ComTrim(CellValue(SelectRow, CVRG_LOC));
  		}
  		
  		//필수항목인지 체크를 위해서 필요한 값들이 입력되었을 경우에 실행한다.
  		if (tariff != "" && effDt != "" && expDt != "" && cntrCgo != ""	&& cntCd != "") {
  			
			//1.Rate Adjustment 가 필수항목인지 체크한다. 체크하기 전에 이전 결과값을 Clear 시킨다.
  			ComSetObjValue(formObj.result, 		"");
			setMandatoryRTAdjust(sheetRFAObj.SelectRow);

			var result = ComTrim(ComGetObjValue(formObj.result));

			//2.필수항목 체크결과 처리
			//2-1.에러일 경우(Error)
			if (result == "E") {
				var errMsgId = "";
				if (tariff.indexOf("CT") != -1) {
					errMsgId = "DMT02003";
				}
				else {
					errMsgId = "DMT00132";
				}				
				ComShowCodeMessage(errMsgId, sheetRFAObj.CellValue(sheetRFAObj.SelectRow, "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + locCd + " ]");
				return result;
			}
			//2-2.필수항목일 경우(Mandatory)
			else if (result == "M") {
				//Rate Adjustment 가 필수항목이므로 RT_CHECK 를 'Y' 로 설정해준다.(그래야, 아래 함수에서 체크박스에 선택표시를 해준다.)
				sheetRFAObj.CellValue(sheetRFAObj.SelectRow, RT_CHECK)		= "Y";

				//Rate Adjustment Grid 의 상태를 활성화 / 비활성화 시킨다.
				setRateAdjustmentGrid();

				//자동으로 Row 를 추가해준다.(2009-07-29)
				if (fetchRowCount(sheetRTObj) == 0) 
					addRateAdjustment();				
			}
			//2-3.옵션항목일 경우
			else {
				if (fetchRowCount(sheetRTObj) > 0)
					sheetRFAObj.CellValue(sheetRFAObj.SelectRow, RT_CHECK)		= "Y";
				else
					sheetRFAObj.CellValue(sheetRFAObj.SelectRow, RT_CHECK)		= "N";
			}
			
			return result;
  		}
  		return "N";	//필수입력값이 없어서 실행하지 못하였을 경우
  	}
   	 
	/**
	 * Comment 에 대한 필수입력 체크를 수행하는 함수
	 */	   	 
    function validateComment() {
    	var formObj = document.form;
    	
		if (!formObj.chkComment.checked) {
			ComShowCodeMessage("DMT00151");
			ComSetFocus(formObj.chkComment);
			return false;				
		}
		else if (ComTrim(ComGetObjValue(formObj.comment)) == "") {
			ComShowCodeMessage("DMT02002", "Comment");
			ComSetFocus(formObj.comment);
			return false;				
		}
		else if (ComChkLenByByte(ComGetObjValue(formObj.comment), 500) == 0) {
			ComShowCodeMessage("DMT00104", "Comment", "500");
			ComSetFocus(formObj.comment);
			return false;				
		}
        return true;	
    }
	
   /**
	* RFA 조회를 위한 팝업을 띄우는 함수.
	*/	 
	function openWinSearchRFA() {
		var formObj 	= document.form;
		
		//var rfaNo		= ComTrim(ComGetObjValue(formObj.rFANo));
		var propNo		= ComTrim(ComGetObjValue(formObj.proposalNo));
		var pgmNo 		= "ESM_PRI_2019";
	    var pgmUrl 		= "/hanjin/ESM_PRI_2019.do";
	    //var params 		= "&s_rfa_no=" + rfaNo;
	    var params 		= "&s_prop_no=" + propNo;
	    var parentPgmNo = pgmNo.substring(0, 8) + 'M001';   
        var src 		= "&pgmUrl=" + ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
	    var sFeatures 	= "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";
	      
	    var winObj 		= window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures); 
	}
		
   /**
	* DAR History 조회를 위한 팝업을 띄우는 함수.
	*/	 
	function openWinSearchDARHistory() {
		var formObj 	= document.form;
		var cboDARObj	= comboObjects[0];
		var sheetRFAObj	= sheetObjects[0];
		
		var rFANo 		= ComTrim(ComGetObjValue(formObj.rFANo));
		var propNo 		= ComTrim(ComGetObjValue(formObj.proposalNo));
		var darNo 		= cboDARObj.Text;
		var verSeq 		= ComTrim(ComGetObjText(formObj.version));
		var custCd 		= ComTrim(ComGetObjValue(formObj.custCd));
		var custNm 		= ComTrim(ComGetObjValue(formObj.custNm));
		var status 		= ComTrim(ComGetObjValue(formObj.status));
		var count 		= fetchRowCount(sheetRFAObj);
		var caller		= ComTrim(ComGetObjValue(formObj.caller));
		
		if (caller == "2007") {
			isActBtnCopy = "N";
		}
		else if (status == "" || status == "Temp. Saved" || status == "Counter Offered") {
			isActBtnCopy = "Y";
		}
		else {
			isActBtnCopy = "N";
		}
		
		var params = "rfa_no=" 	+ rFANo;
		params += "&prop_no=" 	+ propNo;
		params += "&dar_no=" 	+ darNo;
		params += "&ver_seq=" 	+ verSeq;	
		params += "&cust_cd=" 	+ custCd;
		params += "&cust_nm=" 	+ custNm;
		params += "&status=" 	+ status;
		params += "&rowcount=" 	+ count + ""
		params += "&is_copy=" + isActBtnCopy;
		
		ComOpenPopup("EES_DMT_2105.do?" + params, 920, 480, "copyDARHistory", "1,0,1,1,1,1,1", true);		
	}
	
	/**
	 * DAR History 에서 선택한 항목을 복사해주는 함수
	 */	
	function copyDARHistory(aryPopupData) {
		var formObj 	= document.form;
		var sheetRFAObj	= sheetObjects[0];
		var cboDARObj	= comboObjects[0];
		
		//DAR History 팝업화면에서 선택한 버전
		ComSetObjValue(formObj.rfa_expt_hist_dar_no,	aryPopupData[0]);
		ComSetObjValue(formObj.rfa_expt_hist_mapg_seq,	aryPopupData[1]);
		ComSetObjValue(formObj.rfa_expt_hist_ver_seq,	aryPopupData[2]);
		
		//현재 버전의 Before Booking Request 정보가 있으면 모두 삭제하고, 
		//현재 버전에 DAR History 팝업화면에서 선택한 버전의 Before Booking Request 정보로 생성한다.
		doActionIBSheet(sheetRFAObj, formObj, IBSAVE_RFATARIFF_HISTORY);
		
		if (ComGetObjValue(formObj.result) == "Y") {

			if (cboDARObj.Text == "") {
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_DAR);
			}
			
			//DAR History 에서 복사된 Before Booking Request 를 조회한다.
			doActionRetrieve(IBSEARCH);
		}
		else {
			ComShowCodeMessage("DMT00008", "copy");
			return;
		}
	}
	 
	/**
	 * 화면이 팝업으로 나타날때, 호출자에 따라서 display 할 버튼이 달라지도록 처리하는 함수
	 */	
    function displayBtnByCaller() {
    	var formObj = document.form;
		 
    	if (ComGetObjValue(formObj.caller) == "2007") {
    		
    		//Group Buttons
    		btnAddRFALayer.style.display  			= 'none';
    		btnCopyRFALayer.style.display  			= 'none';
    		btnSaveRFALayer.style.display  			= 'none';
    		btnDelRFALayer.style.display  			= 'none';
    		
    		//Multi Origin or Dest. Buttons
    		btnAddMultiOrgDestLayer.style.display  	= 'none';
    		btnDelMultiOrgDestLayer.style.display  	= 'none';
    		
    		//RateAdjustment Buttons
    		btnAddAdjustmentLayer.style.display  	= 'none';
    		btnDelAdjustmentLayer.style.display  	= 'none';
    		
    		//Main Buttons
        	btnNewLayer.style.display  				= 'none';
        	btnUpdateLayer.style.display  			= 'none';
        	btnRequestLayer.style.display  			= 'none';
        	btnCancelLayer.style.display  			= 'none';
        	btnApprovalLayer.style.display  		= 'none';
        	btnCounterOfferLayer.style.display  	= 'none';
        	btnRejectLayer.style.display  			= 'none';
			btnLineLayer.style.display				= 'none';
        	btnCloseLayer.style.display  			= 'inline';
    	}
    	else {
    		//Group Buttons
    		btnAddRFALayer.style.display  			= 'inline';
    		btnCopyRFALayer.style.display  			= 'inline';
    		btnSaveRFALayer.style.display  			= 'inline';
    		btnDelRFALayer.style.display  			= 'inline';
    		
    		//Multi Origin or Dest. Buttons
    		btnAddMultiOrgDestLayer.style.display  	= 'inline';
    		btnDelMultiOrgDestLayer.style.display  	= 'inline';
    		
    		//RateAdjustment Buttons
    		btnAddAdjustmentLayer.style.display  	= 'inline';
    		btnDelAdjustmentLayer.style.display  	= 'inline';
    		
    		//Main Buttons
        	btnNewLayer.style.display  				= 'inline';
        	btnUpdateLayer.style.display  			= 'inline';
        	btnRequestLayer.style.display  			= 'inline';
        	btnCancelLayer.style.display  			= 'inline';
        	btnApprovalLayer.style.display  		= 'inline';
        	btnCounterOfferLayer.style.display  	= 'inline';
        	btnRejectLayer.style.display  			= 'inline';
			btnLineLayer.style.display				= 'inline';
        	btnCloseLayer.style.display  			= 'inline';   		
    	}
    }
	 
    /**
	 * 로그인 User 가 Security 상에서 EES_DMT_2005(DAR-Before BKG Approval)의 Access 권한이 있는지 결과를 반환하는 함수
	 */	 
    function isPermitRole() {
        var formObj = document.form;
        
		if (ComGetObjValue(formObj.role_permit) == "Y") return true;
		
		return false;
	}
	 
    /**
	 * Approval Office 와 로그인 점소의 소속 지역본부/본수(NYCRA, HAMRU, SHARC, SINRS, SELHO) 가 동일한지 결과를 반환하는 함수
	 */	 
	function isMatchOffice() {
	    var formObj = document.form;
		 
		with(formObj) {
		    if (ComGetObjValue(approvalOfcCd) == ComGetObjValue(rhq_ofc_cd))
			    return true;
		}
		return false;
	}

    /**
	 *  현재 버전이 최종버전과 동일한지 결과를 반환하는 함수
	 */	 
	function isMatchVersion() {
	    var formObj = document.form;
		 
		with(formObj) {
		    if (ComTrim(ComGetObjText(formObj.version)) == ComTrim(formObj.version.options[0].text))
			    return true;
		}
		return false;
	}

   /**
	 * Status 값에 따라 버튼의 활성화 여부를 반환해주는 함수
	 */	     
	function isPermitStatus(caller) {
	    var formObj = document.form;
	    var stsCd 	= getVerStatus("Code");
	    
		if (caller == "Approval") {
			if (stsCd == "R")
			    return true;
		}
	    else if (caller == "CounterOffer") {
			if (stsCd == "R")
			    return true;
	    }
	    else if (caller == "Reject") {
			if (stsCd == "R")
			    return true;
	    }
	    else if (caller == "Update") {
			if (stsCd == "R" || stsCd == "C" || stsCd == "A" || stsCd == "J")
			    return true;
	    }
	    else if (caller == "Request") {
			if (stsCd == "" || stsCd == "O" || stsCd == "T")
			    return true;
	    }
	    else if (caller == "TempSave") {
			if (stsCd == "" || stsCd == "O" || stsCd == "T")
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
     
    /**
     * 추가, 수정, 삭제된 항목이 있는지 검색하는 함수
     */
    function isChangedBeforeException(initSheetNo) {
    	var result = new Array(); 
   	
    	//초기값 설정
    	result[0] = false;
   	
	   	//검색을 실행할 쉬트번호가 매개변수로 넘어오지 않을경우에는 Group 쉬트부터 검색을 실행한다.
	   	if (initSheetNo == undefined) initSheetNo = 0;
	   	
	    for (var sheetNo = initSheetNo ; sheetNo < sheetObjects.length - 1 ; sheetNo++) {
	       	with(sheetObjects[sheetNo]) {
	            for (var row = HeaderRows ; row <= LastRow ; row++) {
	            	switch(RowStatus(row)) {
		            	case "I":
		            		result[0] = true;
		            		result[1] = row;
		            		result[2] = "추가";
		            		result[3] = "sheetObjects[" + sheetNo + "] 의 " + CellValue(row, "Seq") + " 가  추가 되었습니다. 확인하세요";
		            		return result;
		            		break;
		            		
		            	case "U":
		            		result[0] = true;
		            		result[1] = row;
		            		result[2] = "수정";
		            		result[3] = "sheetObjects[" + sheetNo + "] 의 " + CellValue(row, "Seq") + " 가  수정 되었습니다. 확인하세요";
		            		return result;
		            		break;
		            		
		            	case "D":
		            		result[0] = true;
		            		result[1] = row;
		            		result[2] = "삭제";		            		
		            		result[3] = "sheetObjects[" + sheetNo + "] 의 " + CellValue(row, "Seq") + " 가  삭제 되었습니다. 확인하세요";
		            		return result;
		            		break;
	            	}
	            }
	       	}
        }

     	return result;
   }

   /**
    * 현재버전부터 그 이하버전에 Approved 상태가 있는지를 검사하는 함수
    */
    function isApprovedInPrevVersion() {
        var formObj 	= document.form;
		var result		= new Array();
		
		result[0] 		= false;
		for (var idx = 0 ; idx < formObj.version.length ; idx++) {
			
			arrVersion = ComTrim(ComGetObjValue(formObj.version[idx])).split(":");
			
			if (arrVersion[0] == "A") {
				result[0]	= true;
				result[1]	= formObj.version[idx].text;
				break;
			}
		}
		
		return result;
    }
    
    /**
     * 조회 필드를 활성화 / 비활성화 시켜주는 함수
     */
    function enableSearchFields(flag) {
        var formObj		= document.form;
        var cboDARObj	= comboObjects[0];
        var cboAPVLObj	= comboObjects[1];
        
		with(formObj) {
			ComEnableManyObjects(flag, approvalOfcCd, version);

			if (flag) {
				version.className 			= "input";
				approvalOfcCd.className 	= "input1";
			}
			else {
				version.className 			= "input2";
				approvalOfcCd.className 	= "input2";
			}
		}
		
		cboDARObj.Enable 	= flag;
		cboAPVLObj.Enable	= flag;
    }
     
   /*
    * Coverage 값이 Empty 일 경우에는 Space 1칸으로 변환하여 반환하는 함수
    */
   function convertEmptyToSpace(sVal) {
   	
   	if (sVal == "")
   		return "' '";
   	else
   		return "'" + sVal + "'";
   }
    /* current date */  
  	function getTodate() {
		var today = new Date();
		var year = today.getYear();
		var month = today.getMonth() + 1;
		var day = today.getDate();
		if (month < 10) {
			month = "0" + month;
		}
		if (day < 10) {
			day = "0" + day;
		}
		var currDate = year +""+ month +""+  day;// 현재 날짜 생성
		return currDate;
	}
  	
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		for (var i = 1; i <= LastRow; i ++) {
    			var celcnt = document.form.sheet1_cnt.value ;
				if(CellValue(i, NEW_FLG) == "Y") {
					sheetObj.RowFontColor(i) = RgbColor(0,0,255); 
					for (var j = 1; j <= celcnt; j ++) {
					    sheetObj.CellFont("FontBold", i, j) = true;
					}
				}
			}
		}
	}
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		for (var i = 1; i <= LastRow; i ++) {
    			var celcnt = document.form.sheet2_cnt.value ;
				if(CellValue(i, NEW_FLG) == "Y") {
					sheetObj.RowFontColor(i) = RgbColor(0,0,255); 
					for (var j = 1; j <= celcnt; j ++) {
					    sheetObj.CellFont("FontBold", i, j) = true;
					}
				}
			}
		}
	}
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		for (var i = 1; i <= LastRow; i ++) {
    			var celcnt = document.form.sheet3_cnt.value ;
				if(CellValue(i, NEW_FLG) == "Y") {
					sheetObj.RowFontColor(i) = RgbColor(0,0,255); 
					for (var j = 1; j <= celcnt; j ++) {
					    sheetObj.CellFont("FontBold", i, j) = true;
					}
				}
			}
		}
	}   