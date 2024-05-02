/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2001.jsp
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.20 이성훈
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109290-01] Split 12-ALPS의 Location 조회불가건 수정 보완 요청.
* 2011.12.14 김현화 [CHM-201114827-01] SC와 RFA의 DEMDET Exception Version-up 화면/기능 보완
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
    function EES_DMT_2001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
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
		
	//Action 정의
	var IBSEARCH_INIT			= 100;
	var IBSEARCH_VER 			= 101;
	var IBSEARCH_CUST 			= 102;
	var IBSEARCH_CALC 			= 103;
	var IBSEARCH_DUAL 			= 104;
	var IBSEARCH_CHKCONTI 		= 105;
	var IBSEARCH_FILED 			= 106;
	var IBSEARCH_SCNO_CUST 		= 107;
	var IBSEARCH_SUB			= 108;
	var IBSEARCH_SCTARIFF		= 109;
	var IBSEARCH_CHECK_DUP		= 110;
	var IBSEARCH_VER_CHECK		= 111;
	var IBSAVE_VERSTS 			= 201;
	var IBSAVE_SCTARIFF			= 202;
	var IBSAVE_SCTARIFF_UPDATE	= 203;
	var IBSAVE_SCTARIFF_HISTORY	= 204;
	var	IBDELETE_SCTARIFF		= 301;
			
	//DATA 구분자 정의
	var ROWMARK 		= "|";
	var FIELDMARK 		= "=";
	
	var TARIFF 			= "dmdt_trf_cd";
	var EFF_DT 			= "eff_dt";
	var EXP_DT 			= "exp_dt";	
	var CNTRCGO 		= "dmdt_cntr_cgo_tp_cd";
	var CVRG_SEQ 		= "cvrg_seq";
	var CVRG_MULTI 		= "cvrg_multi";
	var CURR_CVRG_MULTI = "curr_cvrg_multi";
	var CVRG_CNT 		= "cnt_cd";
	var CVRG_RGN 		= "rgn_cd";
	var CVRG_STE 		= "ste_cd";
	var CVRG_LOC 		= "loc_cd";
	var FT_SEQ 			= "ft_seq";
	var FT_FLG 			= "ft_flg";
	var PREV_FT_FLG 	= "prev_ft_flg";
	var	FT_TIR 			= "ft_tir";
	var ADD_DYS 		= "ft_add_dys";
	var TOT_DYS 		= "ft_tot_dys";
	var FT_FROM 		= "cntr_fm_qty";
	var FT_UPTO 		= "cntr_to_qty";
	var FT_DAYS 		= "ft_dys";
	var RT_FROM 		= "ft_fm_dys";
	var RT_UPTO 		= "ft_to_dys";
	var RT_20FT 		= "cntr_20ft_rt_amt";
	var RT_40FT 		= "cntr_40ft_rt_amt";
	var RT_HC 			= "cntr_hc_rt_amt";
	var RT_45FT 		= "cntr_45ft_rt_amt";
	var RT_R9 		    = "cntr_r9_rt_amt";
	var RT_SEQ 			= "rt_seq";
	var RT_MANDATORY 	= "rt_chk_flg";	//RT 가 필수항목인지 여부를 나타냄.(Y: 필수, N: 옵션)
	var RT_CHECK 		= "rt_chk";		//RT 의 체크박스 선택값	
	var SAT_FLG 		= "xcld_sat_flg";
	var SUN_FLG 		= "xcld_sun_flg";
	var HOL_FLG 		= "xcld_hol_flg";
	var ORGDST_CTI 		= "sc_expt_fm_conti_cd";
	var ORGDST_CNT 		= "sc_expt_fm_cnt_cd";
	var ORGDST_RGN 		= "sc_expt_fm_rgn_cd";
	var ORGDST_STE 		= "sc_expt_fm_ste_cd";
	var ORGDST_LOC 		= "sc_expt_fm_loc_cd";
	var BKGDEL_CNT 		= "fnl_dest_cnt_cd";
	var BKGDEL_RGN 		= "fnl_dest_rgn_cd";
	var BKGDEL_STE 		= "fnl_dest_ste_cd";
	var BKGDEL_LOC 		= "fnl_dest_loc_cd";
	var CYDOOR 			= "rcv_de_term_cd";
	var REMARK 			= "expt_trf_rmk";
	var FULL_REMARK 	= "full_expt_trf_rmk";
	var PROP_NO 		= "prop_no";
	var VER_SEQ 		= "sc_expt_ver_seq";
	var GRP_SEQ 		= "sc_expt_grp_seq";
	var CURR_CD 		= "curr_cd";
	
	//Flag 변수(화면 입력데이터에 따라서 그 내용이 달리 설정됨)
	var CMDT_FLG 		= "cmdt_flg";
	var ACT_CUST_FLG 	= "act_cust_flg";
	var FM_TO_PAIR_FLG 	= "fm_to_pair_flg";
	var FT_ADD_FLG 		= "ft_add_flg";
	var FT_ADJ_FLG 		= "ft_adj_flg";
	var RT_ADJ_FLG 		= "rt_adj_flg";
	var DMDT_FT_ADJ_TP_CD = "dmdt_ft_adj_tp_cd";
	
	//ROW 의 실제 삭제여부를 나타내는 변수
	//GROUP 의 하위 항목은 hidden 상태로 조회되기 때문에 실제 삭제와 구분하기 위해서 사용됨
	var HID_STATUS 		= "hidden_status";
	
	//Actual Customer Sheet 의  Column 명
	var CUST_CD			= "cust_cd";
	var CUST_NM 		= "cust_nm";
	
	//Commodity Sheet 의  Column 명
	var CMDT_CD 		= "cmdt_cd";
	var CMDT_NM 		= "cmdt_nm";
	
	//현재 ROW 가 수정가능한 상태인지를 나타내주는 컬럼(조회된 데이터는 초기에 Editable 불가하다.)
	var ROW_EDIT_STS 	= "row_edit_status";
	
	//현재 버전 내용중에 이전버전에서 추가된 신규내용표시. 2011.12.16 KHH
	var NEW_FLG 	= "new_flg";

	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation = true;

	//발생된 OnChange 이벤트가 화면상에서 이루어진것이 아닐경우, 
	//즉 조회된 데이터로 각 콤보필드를 설정해줄때 발생된 것인지를 구분해주는 변수.(의도치 않은 행위를 막기 위해서 사용함)
	//이 변수의 설정은 Location 필드에서 한다.
	//2009.06.21 추가사항 .Continent 에 잘못된 값이 들어와서 하위 Country 를 초기화 시킬때, 
	//상위 Continent 필드의 초기화를 막아주기 위해서도 사용됨.
	var isValueSettingEvent 	= false;
	
	//Row Copy 버튼 클릭시 자동으로 Row 가 생성되면서 선택위치가 변경된다.
	//선택위치 변경시 수정,입력,삭제된 S/C Exception Tariff 가 있는지 검사하는 함수를 호출하게 되는데, 여기에서 정상처리로 만들기 위해서 사용하는 변수
	var isCopySCExceptionTariff = false;
	
	//Rate Adjustment 필수항목여부를 체크할 때 Coverage 에 값 입력시 중복 호출되는 것을 막기 위함.
	var isRateCheckingCVRG 		= "";	

	//중복체크 에러메시지
   	var dupAlertMsg 			= "";	 
  	var dupAlertSubMsg 			= "";
	
  	//Sort 시 선택되어진 Row 의 선택상태를 계속 유지하기 위해서 사용되는 변수
	var currGrpSeq 				= "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetSCObj 	= sheetObjects[0];
         var sheetCVRGObj 	= sheetObjects[1];
         var sheetFTObj 	= sheetObjects[2];
         var sheetRTObj 	= sheetObjects[3];
         var sheetCUSTObj 	= sheetObjects[4];
         var sheetCMDTObj 	= sheetObjects[5];

         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_AddGroup":
					if (ComIsBtnEnable(srcName))
						addGroup();
					break;

				case "btn_CopyGroup":
					if (ComIsBtnEnable(srcName)) 
						copyGroup();
					break;

				case "btn_DelGroup":
					if (ComIsBtnEnable(srcName)) 
						delGroup();
					break;
					
				case "btn_SaveGroup":
					if (ComIsBtnEnable(srcName)) 
						saveGroup(false, false);//(변경된 정보가 있는지 검사하지 않았음을 나타낸다, 그리드 입력가능/입력불가능 상태처리까지 진행함)
					break;
				case "btn_DownExcel":
					if (ComIsBtnEnable(srcName))
						 if (sheetSCObj.RowCount < 1) {
							 ComShowCodeMessage("DMT06001");
							 return;
						 }
					    sheetSCObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false);
					break;
					
				case "btn_AddMultiCoverage":
					if (ComIsBtnEnable(srcName)) 
						addMultiCoverage();
					break;

				case "btn_DelMultiCoverage":
					if (ComIsBtnEnable(srcName)) 
						delSubSCException(sheetCVRGObj);
					break;

				case "btn_AddFreeTime":
					if (ComIsBtnEnable(srcName)) 
						addFreeTime();
					break;

				case "btn_DelFreeTime":
					if (ComIsBtnEnable(srcName)) 
						delSubSCException(sheetFTObj);
					break;

				case "btn_AddRateAdjustment":
					if (ComIsBtnEnable(srcName)) 
						addRateAdjustment();
					break;

				case "btn_DelRateAdjustment":
					if (ComIsBtnEnable(srcName)) 
						delSubSCException(sheetRTObj);
					break;
				
				case "btn_AddCustomer":
					if (ComIsBtnEnable(srcName)) 
						addCustomer();
					break;

				case "btn_DelCustomer":
					if (ComIsBtnEnable(srcName)) 
						delSubSCException(sheetCUSTObj);
					break;
					
				case "btn_AddCommodity":
					if (ComIsBtnEnable(srcName)) 
						addCommodity();
					break;

				case "btn_DelCommodity":
					if (ComIsBtnEnable(srcName)) 
						delSubSCException(sheetCMDTObj);
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
				
				case "btn_Delete":
					if (ComIsBtnEnable(srcName)) 
						doActionDelete();
					break;
						
				case "btn_Accept":
					if (ComIsBtnEnable(srcName)) 
						doActionAccept();
					break;
						
				case "btn_AcceptCancel":
					if (ComIsBtnEnable(srcName)) 
						doActionAcceptCancel();						
					break;	
					
				case "btn_Close":
					if (ComIsBtnEnable(srcName)) 
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		var formObj 		= document.form;
  		var sheetSCObj 		= sheetObjects[0];
  		var sheetCMDTObj	= sheetObjects[5];
		
        for (i = 0 ; i < sheetObjects.length ; i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
  		
		//1.화면 Load 시 비활성화될 컨트롤들을 초기화 시킨다.
		initDisableObjects();        

		//2.호출자에 따라서 보여줄 버튼을 정한다.
		displayBtnByCaller();
		
  		//3.페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_INIT);
		
		//4.Proposal No 가 있을 경우에만 아래 내용을 조회한다.
		if (ComTrim(ComGetObjValue(formObj.proposalNo)) != "") {
			
			//4-1.S/C Exception 에 등록된 데이터를 조회한다.
			doActionRetrieve(IBSEARCH);
			
		}
		else {
			//4-2.Version 를 초기값으로 설정해준다.
			addComboItem(formObj.version,"001=",true);
			
			//4-3.메인 버튼의 상태를 주어진 조건에 따라서 활성화 or 비활성화 시킨다.
			initBtnControl();
		}
		searchCustomerByTypeChange();
		
		
	}
  	
 	function initDisableObjects() {
		var formObj = document.form;
		
		with(formObj) {
			ComEnableManyObjects(false, sCNo, proposalNo, status, custCd, custNm);
			sCNo.className 			= "input2";
			proposalNo.className 	= "input2";
			status.className 		= "input2";
			custCd.className 		= "input2";
			custNm.className 		= "input2";
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
		var formObj = document.form;
        switch(sheetid) {
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

					var HeadTitle1 = "|Seq.|Tariff|EFF DT|EXP DT|CNTR/CGO|Coverage|Coverage|Coverage|Coverage|Free Time|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|Origin(I) or Dest(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|BKG DEL(I) or POR(O)|CY/Door|Remark";
                    var HeadTitle2 = "|Seq.|Tariff|EFF DT|EXP DT|CNTR/CGO|Multi|CN|RGN|LOC|Y|Tier|Add|Total|SAT|SUN|H/day|CT|CN|RGN|LOC|CN|State|LOC|CY/Door|Remark";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 20;
                    formObj.sheet1_cnt.value = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
					
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, false, false, false);

                    //단일 행만 선택하도록 설정
                    MultiSelection = false;
                    SelectionMode = smSelectionRow;
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	30,    	daCenter,   	true,     		"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,    			30,    	daCenter,   	true,     		"Seq");
					InitDataProperty(0, cnt++ , dtCombo,			60,		daCenter,		true,			TARIFF,					true,		"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,   			75,		daCenter,		true,			EFF_DT,					true,		"",		dfDateYmd,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,   			75,		daCenter,		true,			EXP_DT,					true,		"",		dfDateYmd,		0,	true,	true);
					
					InitDataProperty(0, cnt++ , dtCombo,   			90,		daLeft,			true,			CNTRCGO,				true,		"",		dfEngUpKey,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,   			50,		daCenter,		true,			CVRG_MULTI,				false,		"",		dfEngUpKey,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtComboEdit,  		40,		daCenter,		true,			CVRG_CNT,				false,		"",		dfNone,			0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtComboEdit,		40,		daCenter,		true,			CVRG_RGN,				false,		"",		dfNone,			0,	true,	true,	3);
					InitDataProperty(0, cnt++ , dtData,   			50,		daCenter,		true,			CVRG_LOC,				false,		"",		dfNone,			0,	true,	true,	5);
					
					InitDataProperty(0, cnt++ , dtCheckBox,  		20,		daCenter,		true,			FT_FLG,					false,		"",		dfEngUpKey,		0,	true,	true);
					InitDataProperty(0, cnt++ , dtCombo,   			50,		daCenter,		true,			FT_TIR,					false,		"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,   			50,		daCenter,		true,			ADD_DYS,				false,		"",		dfNullInteger,	0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtData,   			50,		daCenter,		true,			TOT_DYS,				false,		"",		dfNullInteger,	0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtCheckBox,			30,		daCenter,		true,			SAT_FLG,				false,		"",		dfNone,			0,	true,	true);

					InitDataProperty(0, cnt++ , dtCheckBox,   	 	30,		daCenter,		true,			SUN_FLG,				false,		"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtCheckBox,   	 	45,		daCenter,		true,			HOL_FLG,				false,		"",		dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtComboEdit,  		40,		daCenter,		true,			ORGDST_CTI,				false,		"",		dfNone,			0,	true,	true,	1);
					InitDataProperty(0, cnt++ , dtComboEdit,   		40,		daCenter,		true,			ORGDST_CNT,				false,		"",		dfNone,			0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtComboEdit,   		40,		daCenter,		true,			ORGDST_RGN,				false,		"",		dfNone,			0,	true,	true,	3);
					
					InitDataProperty(0, cnt++ , dtData,   			50,		daCenter,		true,			ORGDST_LOC,				false,		"",		dfNone,			0,	true,	true,	5);
					InitDataProperty(0, cnt++ , dtComboEdit, 		40,		daCenter,		true,			BKGDEL_CNT,				false,		"",		dfNone,			0,	true,	true,	2);
					InitDataProperty(0, cnt++ , dtComboEdit,		40,		daCenter,		true,			BKGDEL_RGN,				false,		"",		dfNone,			0,	true,	true,	3);
					InitDataProperty(0, cnt++ , dtData,   			50,		daCenter,		true,			BKGDEL_LOC,				false,		"",		dfNone,			0,	true,	true,	5);
					InitDataProperty(0, cnt++ , dtCombo,   			60,		daCenter,		true,			CYDOOR,					false,		"",		dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,   			120,	daLeft,			true,			REMARK,					false,		"",		dfNone,			0,	true,	true,	500);
					
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			PROP_NO,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			VER_SEQ,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			GRP_SEQ,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			CVRG_SEQ,				false,		"",		dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			CURR_CVRG_MULTI,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			CURR_CD,				false,		"",		dfNone,			0,	false,	false);					
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			FULL_REMARK,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			RT_MANDATORY,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			RT_CHECK,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		    0,		daCenter,		true,			NEW_FLG,				false,		"",		dfNone,			0,	false,	false);	
					
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			ROW_EDIT_STS,			false,		"",		dfNone,			0,	false,	false);					
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			CMDT_FLG,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			ACT_CUST_FLG,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			FM_TO_PAIR_FLG,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			FT_ADD_FLG,				false,		"",		dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			FT_ADJ_FLG,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			RT_ADJ_FLG,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,			DMDT_FT_ADJ_TP_CD,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		    0,		daCenter,		true,			PREV_FT_FLG,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		    0,		daCenter,		true,			HID_STATUS,				false,		"",		dfNone,			0,	false,	false);
					

					
					
					//콤보 설정
					InitDataCombo(0, TARIFF, "", "");
					InitDataCombo(0, CVRG_MULTI, "Single|Multi", "S|M");
					InitDataCombo(0, CVRG_CNT, "", "");
					InitDataCombo(0, CVRG_RGN, "", "");
					InitDataCombo(0, CNTRCGO, "", "");
					InitDataCombo(0, FT_TIR, "Single|Multi", "S|M");
					InitDataCombo(0, ORGDST_CTI, "", "");
					InitDataCombo(0, ORGDST_CNT, "", "");
					InitDataCombo(0, ORGDST_RGN, "", "");
					InitDataCombo(0, BKGDEL_CNT, "", "");
					InitDataCombo(0, BKGDEL_RGN, "", "");
					InitDataCombo(0, CYDOOR, " |CY|Door", " |Y|D");

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
                    InitRowInfo(2, 1, 7, 100);

                    var HeadTitle1 = "|Seq.|BKG POD / CY|BKG POD / CY|BKG POD / CY";
                    var HeadTitle2 = "|Seq.|Country|Region|Location";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 7;
                    formObj.sheet2_cnt.value = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, false, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	30,    	daCenter,   	true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,    			40,    	daCenter,   	true,		"Seq",				false,		"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtComboEdit,		65,		daCenter,		true,		CVRG_CNT,			true,		"",		dfNone,			0,	false,		true,	2);
					InitDataProperty(0, cnt++ , dtComboEdit, 		55,		daCenter,		false,		CVRG_RGN,			false,		"",		dfNone,			0,	false,		true,	3);
					InitDataProperty(0, cnt++ , dtData,   			65,		daCenter,		false,		CVRG_LOC,			false,		"",		dfNone,			0,	false,		true,	5);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		PROP_NO,			false,		"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		VER_SEQ,			false,		"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		GRP_SEQ,			false,		"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		CVRG_SEQ,			false,		"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		    0,		daCenter,		true,		NEW_FLG,			false,		"",		dfNone,			0,	false,	false);	

					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		HID_STATUS,			false,		"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,		RT_MANDATORY,		false,		"",		dfNone,			0,	false,		false);
					InitDataCombo(0, CVRG_CNT, "", "");
					InitDataCombo(0, CVRG_RGN, "", "");	


					//영문 대문자만 입력되도록 설정=================================
					InitDataValid(0, CVRG_CNT,  vtEngUpOnly);
					InitDataValid(0, CVRG_RGN,  vtEngUpOnly);
		            InitDataValid(0, CVRG_LOC,  vtEngUpOther, "0123456789");
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
                    InitRowInfo(2, 1, 7, 100);

                    var HeadTitle1 = "|CNTR Q'ty|CNTR Q'ty|Total";
                    var HeadTitle2 = "|From|Up to|Total";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 6;
                    formObj.sheet3_cnt.value = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
					
                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	30,    	daCenter,   	true,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,   		 	60,		daCenter,		false,	FT_FROM,			true,	"",		dfNullInteger,	0,	false,		true,	2);
					InitDataProperty(0, cnt++ , dtData, 		 	50,		daCenter,		true,	FT_UPTO,			false,	"",		dfNullInteger,	0,	false,		true,	2);
					InitDataProperty(0, cnt++ , dtData, 		 	40,		daCenter,		true,	FT_DAYS,			true,	"",		dfNullInteger,	0,	false,		true,	2);
					InitDataProperty(0, cnt++ , dtHidden,   	  	0,		daCenter,		true,	PROP_NO,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	0,		daCenter,		true,	VER_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	0,		daCenter,		true,	GRP_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	0,		daCenter,		true,	FT_SEQ,				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		    0,		daCenter,		true,	NEW_FLG,			false,	"",		dfNone,			0,	false,	    false);	

					InitDataProperty(0, cnt++ , dtHidden,   		0,		daCenter,		true,	HID_STATUS,			false,	"",		dfNone,			0,	false,		false);
					
					CountPosition = 0;
               }
                break;

            case "sheet4":
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
                    var headCount = ComCountHeadTitle(HeadTitle1) + 6;
                    formObj.sheet4_cnt.value = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	 30,    	daCenter,   	true,     		"ibflag");
					InitDataProperty(0, cnt++ , dtData,   			 75,		daCenter,		false,			RT_FROM,			true,	"",		dfNullInteger,	0,	false,		true,	2);
					InitDataProperty(0, cnt++ , dtData,   			 75,		daCenter,		false,			RT_UPTO,			false,	"",		dfNullInteger,	0,	false,		true,	2);

					InitDataProperty(0, cnt++ , dtData,   			 80,		daRight,		false,			RT_20FT,			true,	"",		dfNullFloat,	2,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   			 80,		daRight,		false,			RT_40FT,			true,	"",		dfNullFloat,	2,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   			 80,		daRight,		false,			RT_HC,				true,	"",		dfNullFloat,	2,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   			 70,		daRight,		false,			RT_45FT,			true,	"",		dfNullFloat,	2,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   			 70,		daRight,		false,			RT_R9,			   true,	"",		dfNullFloat,	2,	false,		true);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,			PROP_NO,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,			VER_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,			GRP_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,			RT_SEQ,				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		      0,		daCenter,		true,		    NEW_FLG,			false,	"",		dfNone,			0,	false,	    false);	

					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,			HID_STATUS,			false,	"",		dfNone,			0,	false,		false);
						
					CountPosition = 0;
				}
                break;

            case "sheet5":
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

                    var HeadTitle1 = "|Code|Name"
                    var headCount = ComCountHeadTitle(HeadTitle1) + 6;
                    formObj.sheet5_cnt.value = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	 30,    	daCenter,   	true,     	"ibflag");
					InitDataProperty(0, cnt++ , dtCombo,	 		100,		daCenter,		false,		CUST_CD,			false,	"",		dfEngUpKey,		0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   		 	100,		daLeft,			false,		CUST_NM,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		false,		PROP_NO,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		false,		VER_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		false,		GRP_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		false,		ACT_CUST_FLG,		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		      0,		daCenter,		true,		NEW_FLG,			false,	"",		dfNone,			0,	false,	    false);	

					InitDataProperty(0, cnt++ , dtHidden,   		  0,		dtHidden,		false,		HID_STATUS,			false,	"",		dfNone,			0,	false,		false);
					
					InitDataCombo(0, CUST_CD, "", "");
					CountPosition = 0;
				}
                 break;


            case "sheet6":
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
                    var headCount = ComCountHeadTitle(HeadTitle1) + 5;
                    formObj.sheet6_cnt.value = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, false, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 	 30,    	daCenter,   	true,     	"ibflag");
					InitDataProperty(0, cnt++ , dtComboEdit,	 	100,		daCenter,		false,		CMDT_CD,			false,	"",		dfNone,			0,	false,		true);
					InitDataProperty(0, cnt++ , dtData,   		 	100,		daLeft,			false,		CMDT_NM,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		PROP_NO,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		VER_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		GRP_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,  		      0,		daCenter,		true,		NEW_FLG,			false,	"",		dfNone,			0,	false,	    false);	
					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,		HID_STATUS,			false,	"",		dfNone,			0,	false,		false);
					
					InitDataCombo(0, CMDT_CD, "", "");
					CountPosition = 0;
				}
                break;


        }
    }

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg 	= false;
	
		var sheetSCObj			= sheetObjects[0];
		var sheetCVRGObj		= sheetObjects[1];
		var sheetCUSTObj 		= sheetObjects[4];
		var sheetCMDTObj		= sheetObjects[5];
		
		switch(sAction) {
			
	        //페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
	        //1.Tariff Type, 2.CNTR/CGO Type, 3.Continent, 4.Country, 5.Region
	        case IBSEARCH_INIT:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no,		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 		COMMAND01);
	
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리 =========================================================================
				//3-1.Tariff Type
				tariffList 		= ComGetEtcData(sXml, "TARIFF");
				addCellComboItem(sheetObj, tariffList, "dmdt_trf_cd", false);
				
				//3-2.CNTR/CGO Type
				cntrCgoList		= ComGetEtcData(sXml, "CNTRCGO");
				addCellComboItem(sheetObj, cntrCgoList, "dmdt_cntr_cgo_tp_cd", false, true);
				
				//3-3.Origin or Dest. Continent
				continentList 	= ComGetEtcData(sXml, "CONTINENT");
				addCellComboItem(sheetObj, continentList, "sc_expt_fm_conti_cd", false);
				
				//3-4.Country
				countryList 	= ComGetEtcData(sXml, "COUNTRY");
				//3-4-1.Group Sheet 의 Coverage CN 을 설정한다.						
				addCellComboItem(sheetObj, 		countryList, 	"cnt_cd", 				false);
				//3-4-2.Group Sheet 의 Origin(I) or Dest.(D) 의 CN 을 설정한다.
				addCellComboItem(sheetObj, 		countryList, 	"sc_expt_fm_cnt_cd",	false);
				//3-4-3.Group Sheet 의 BKG DEL(I) or POR(O) 의 CN 을 설정한다.
				addCellComboItem(sheetObj, 		countryList, 	"fnl_dest_cnt_cd", 		false);
				//3-4-4.Multi Coverage Sheet 의 Country 를 설정한다.
				addCellComboItem(sheetCVRGObj, 	countryList, 	"cnt_cd", 				false);
				
				//3-5.Region
				regionList 		= ComGetEtcData(sXml, "REGION");
				//3-5-1.Group Sheet 의 Coverage State 을 설정한다.						
				addCellComboItem(sheetObj, 		regionList, 	"rgn_cd", 				false);
				//3-5-2.Group Sheet 의 Origin(I) or Dest.(D) 의 RGN 을 설정한다.
				addCellComboItem(sheetObj, 		regionList, 	"sc_expt_fm_rgn_cd", 	false);
				//3-5-3.Group Sheet 의 BKG DEL(I) or POR(O) 의 State 을 설정한다.
				addCellComboItem(sheetObj, 		regionList, 	"fnl_dest_rgn_cd", 		false);
				//3-5-4.Multi Coverage Sheet 의 Region 를 설정한다.
				addCellComboItem(sheetCVRGObj, 	regionList, 	"rgn_cd", 				false);
				
				//3-6.S/C Duration
				ComSetObjValue(formObj.sc_eff_dt, 		handleNullString(ComGetEtcData(sXml, "EFF_DT")));
				ComSetObjValue(formObj.sc_exp_dt, 		handleNullString(ComGetEtcData(sXml, "EXP_DT")));
				 
				//3-7.Accept, Accept Cancel 버튼 권한 조회
				ComSetObjValue(formObj.isAcceptAuth,	handleNullString(ComGetEtcData(sXml, "HAS_AUTH")));
				
				//3-8.Proposal No. 로 SC No. 와 Customer Cd 와 Customer Name 을 조회한다.
	            ComSetObjValue(formObj.custCd, 			handleNullString(ComGetEtcData(sXml, "CUST_CD"))); //CUST_CNT_CD + CUST_SEQ(6자리)
	            ComSetObjValue(formObj.custNm, 			handleNullString(ComGetEtcData(sXml, "CUST_NM")));
	            ComSetObjValue(formObj.custSeq, 		handleNullString(ComGetEtcData(sXml, "CUST_SEQ"))); //CUST_SEQ(입력된 실제값)
	            ComSetObjValue(formObj.sCNo, 			handleNullString(ComGetEtcData(sXml, "SC_NO")));

	            ComSetObjValue(formObj.custTpCd, 		handleNullString(ComGetEtcData(sXml, "PRC_CTRT_CUST_TP_CD")));
	            
	            //3-9.Acutual Customer 조회
	            actCustList 	= handleNullString(ComGetEtcData(sXml, "CUST"));
	            addCellComboItem(sheetCUSTObj, 	actCustList, 	CUST_CD, 				false);
	            
	            //3-10.Commodity 조회
	            cmdtList		= handleNullString(ComGetEtcData(sXml, "CMDT"));
	            addCellComboItem(sheetCMDTObj, 	cmdtList, 		CMDT_CD, 				false);
				//========================================================================================
	        
	        	break;
        	

	        case IBSEARCH:
	        	  
				//S/C Exception Tariff 를 조회합니다.
				if (sheetObj.id == "sheet1") {
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
					ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
					ComSetObjValue(formObj.sc_expt_grp_seq, "");
					ComSetObjValue(formObj.f_cmd, 			SEARCH);
					
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
					//3-1.그리드를 초기화 시킨다.
					sheetObj.RemoveAll();
					
					//3-2.그리드에 조회된 결과를 Load 시켜준다.
					if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) {
						sheetObj.LoadSearchXml(sXml);
					}
				}
				else if (sheetObj.id == "sheet2") {
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
					ComSetObjValue(formObj.f_cmd, 		SEARCH);
				
					//2.조회조건으로 조회실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
					
					var sXml = sheetObj.DoSearch("EES_DMT_2001GS.do", FormQueryString(formObj));
					
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************					
				}
				else if (sheetObj.id == "sheet3") {
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
					ComSetObjValue(formObj.f_cmd, 		SEARCH);
				
					//2.조회조건으로 조회실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
					
					var sXml = sheetObj.DoSearch("EES_DMT_2001GS.do", FormQueryString(formObj));
					
					//*********************************************************************************
					ComOpenWait(false);
					//*********************************************************************************						
				}
				else if (sheetObj.id == "sheet4") {
					
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					with(sheetSCObj) {
	  	  				ComSetObjValue(formObj.cust_cnt_cd, 		ComTrim(ComGetObjValue(formObj.custCd)).substring(0,2));
	  	  				ComSetObjValue(formObj.cust_seq, 			ComTrim(ComGetObjValue(formObj.custCd)).substring(2));
	  					ComSetObjValue(formObj.dmdt_trf_cd, 		ComTrim(CellValue(SelectRow, TARIFF)));
	  					ComSetObjValue(formObj.eff_dt, 				ComTrim(CellValue(SelectRow, EFF_DT)));
	  					ComSetObjValue(formObj.exp_dt, 				ComTrim(CellValue(SelectRow, EXP_DT)));
	  					ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, ComTrim(CellValue(SelectRow, CNTRCGO)));
	  					ComSetObjValue(formObj.f_cmd, 				SEARCH01);
	  					ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
  	  				}
				
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
			
				
			//S/C Exception Tariff 의 현재 선택되어진 Group Seq. 정보만 조회합니다.	
	        case IBSEARCH_SCTARIFF:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 		sheetObj.CellValue(sheetObj.SelectRow, PROP_NO));
				ComSetObjValue(formObj.sc_expt_ver_seq, sheetObj.CellValue(sheetObj.SelectRow, VER_SEQ));
				ComSetObjValue(formObj.sc_expt_grp_seq, sheetObj.CellValue(sheetObj.SelectRow, GRP_SEQ));
				ComSetObjValue(formObj.f_cmd, 			SEARCH17);
				
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
				with(sheetObj) {
					CellValue2(SelectRow, TARIFF) 			= handleNullString(ComGetEtcData(sXml, "TARIFF"));
					CellValue2(SelectRow, EFF_DT) 			= handleNullString(ComGetEtcData(sXml, "EFF_DT"));
					CellValue2(SelectRow, EXP_DT) 			= handleNullString(ComGetEtcData(sXml, "EXP_DT"));
					CellValue2(SelectRow, CNTRCGO) 			= handleNullString(ComGetEtcData(sXml, "CNTRCGO"));
					CellValue2(SelectRow, CVRG_MULTI) 		= handleNullString(ComGetEtcData(sXml, "CVRG_MULTI"));
					CellValue2(SelectRow, CVRG_CNT) 		= handleNullString(ComGetEtcData(sXml, "CVRG_CNT"));
					CellValue2(SelectRow, CVRG_RGN) 		= handleNullString(ComGetEtcData(sXml, "CVRG_RGN"));
					CellValue2(SelectRow, CVRG_LOC) 		= handleNullString(ComGetEtcData(sXml, "CVRG_LOC"));
					CellValue2(SelectRow, FT_FLG) 			= handleNullString(ComGetEtcData(sXml, "FT_FLG"));
					CellValue2(SelectRow, FT_TIR) 			= handleNullString(ComGetEtcData(sXml, "FT_TIR"));
					CellValue2(SelectRow, ADD_DYS) 			= handleNullString(ComGetEtcData(sXml, "ADD_DYS"));
					CellValue2(SelectRow, TOT_DYS) 			= handleNullString(ComGetEtcData(sXml, "TOT_DYS"));
					CellValue2(SelectRow, SAT_FLG) 			= handleNullString(ComGetEtcData(sXml, "SAT_FLG"));
					CellValue2(SelectRow, SUN_FLG) 			= handleNullString(ComGetEtcData(sXml, "SUN_FLG"));
					CellValue2(SelectRow, HOL_FLG) 			= handleNullString(ComGetEtcData(sXml, "HOL_FLG"));
					CellValue2(SelectRow, ORGDST_CTI) 		= handleNullString(ComGetEtcData(sXml, "ORGDST_CTI"));
					CellValue2(SelectRow, ORGDST_CNT) 		= handleNullString(ComGetEtcData(sXml, "ORGDST_CNT"));
					CellValue2(SelectRow, ORGDST_RGN) 		= handleNullString(ComGetEtcData(sXml, "ORGDST_RGN"));
					CellValue2(SelectRow, ORGDST_LOC) 		= handleNullString(ComGetEtcData(sXml, "ORGDST_LOC"));
					CellValue2(SelectRow, BKGDEL_CNT)		= handleNullString(ComGetEtcData(sXml, "BKGDEL_CNT"));
					CellValue2(SelectRow, BKGDEL_RGN) 		= handleNullString(ComGetEtcData(sXml, "BKGDEL_RGN"));
					CellValue2(SelectRow, BKGDEL_LOC) 		= handleNullString(ComGetEtcData(sXml, "BKGDEL_LOC"));
					CellValue2(SelectRow, CYDOOR) 			= handleNullString(ComGetEtcData(sXml, "CYDOOR"));
					CellValue2(SelectRow, REMARK) 			= handleNullString(ComGetEtcData(sXml, "REMARK"));
					CellValue2(SelectRow, PROP_NO) 			= handleNullString(ComGetEtcData(sXml, "PROP_NO"));
					CellValue2(SelectRow, VER_SEQ) 			= handleNullString(ComGetEtcData(sXml, "VER_SEQ"));
					CellValue2(SelectRow, GRP_SEQ) 			= handleNullString(ComGetEtcData(sXml, "GRP_SEQ"));
					CellValue2(SelectRow, CURR_CVRG_MULTI) 	= handleNullString(ComGetEtcData(sXml, "CURR_CVRG_MULTI"));
					CellValue2(SelectRow, CURR_CD) 			= handleNullString(ComGetEtcData(sXml, "CURR_CD"));
					CellValue2(SelectRow, FULL_REMARK) 		= handleNullString(ComGetEtcData(sXml, "FULL_REMARK"));
					CellValue2(SelectRow, RT_MANDATORY) 	= handleNullString(ComGetEtcData(sXml, "RT_MANDATORY"));
					CellValue2(SelectRow, RT_CHECK) 		= handleNullString(ComGetEtcData(sXml, "RT_CHECK"));
					
					//조회를 하였으니 현재 상태를 'R' 로 변경한다.
					RowStatus(SelectRow) = "R";
				}
	        	break;
	        	
				
			//화면에서 입력한 S/C 정보와 기등록된 S/C 정보중 중복된 데이터가 있는지 조회 합니다.	
	        case IBSEARCH_CHECK_DUP:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				with(sheetObj) {
					ComSetObjValue(formObj.prop_no, 			CellValue(SelectRow, PROP_NO));
					ComSetObjValue(formObj.sc_expt_ver_seq, 	CellValue(SelectRow, VER_SEQ));
					ComSetObjValue(formObj.sc_expt_grp_seq, 	CellValue(SelectRow, GRP_SEQ));
					ComSetObjValue(formObj.dmdt_trf_cd,			CellValue(SelectRow, TARIFF));
					ComSetObjValue(formObj.eff_dt,				CellValue(SelectRow, EFF_DT));
					ComSetObjValue(formObj.exp_dt,				CellValue(SelectRow, EXP_DT));
					ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd,	CellValue(SelectRow, CNTRCGO));
					ComSetObjValue(formObj.sc_expt_fm_conti_cd,	CellValue(SelectRow, ORGDST_CTI));
					ComSetObjValue(formObj.sc_expt_fm_cnt_cd,	CellValue(SelectRow, ORGDST_CNT));
					
					if (CellValue(SelectRow, ORGDST_CNT) == "CA" || CellValue(SelectRow, ORGDST_CNT) == "US") {
						ComSetObjValue(formObj.sc_expt_fm_rgn_cd,	"");
						ComSetObjValue(formObj.sc_expt_fm_ste_cd,	CellValue(SelectRow, ORGDST_RGN));
					}
					else {
						ComSetObjValue(formObj.sc_expt_fm_rgn_cd,	CellValue(SelectRow, ORGDST_RGN));
						ComSetObjValue(formObj.sc_expt_fm_ste_cd,	"");
					}

					ComSetObjValue(formObj.sc_expt_fm_loc_cd,	CellValue(SelectRow, ORGDST_LOC));
					
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
					ComSetObjValue(formObj.rcv_de_term_cd,		CellValue(SelectRow, CYDOOR));
				}
				
				ComSetObjValue(formObj.f_cmd, 			SEARCH18);
				
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
				ComSetObjValue(formObj.result, handleNullString(ComGetEtcData(sXml, "RESULT")));
				
	        	break;
	        	
	        	
			//S/C Exception Tariff 의 Group Seq. 에 해당되는 하위 항목들을 조회합니다.	
	        case IBSEARCH_SUB:			
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			SEARCH16);
				ComSetObjValue(formObj.prop_no, 		sheetObj.CellValue(sheetObj.SelectRow, PROP_NO));
				ComSetObjValue(formObj.sc_expt_ver_seq, sheetObj.CellValue(sheetObj.SelectRow, VER_SEQ));
				ComSetObjValue(formObj.sc_expt_grp_seq, sheetObj.CellValue(sheetObj.SelectRow, GRP_SEQ));
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				sheetObjects[1].WaitImageVisible = false;
				sheetObjects[2].WaitImageVisible = false;
				sheetObjects[3].WaitImageVisible = false;
				sheetObjects[4].WaitImageVisible = false;
				sheetObjects[5].WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var arrXml = sXml.split("|$$|");
	            
				//3-1.그리드를 초기화 시킨다.
	            sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				sheetObjects[5].RemoveAll();
				
				//3-2.그리드에 조회된 결과를 Load 시켜준다.
            	if (arrXml.length > 0 && ComGetTotalRows(arrXml[0]) > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);//Multi Coverage
				if (arrXml.length > 1 && ComGetTotalRows(arrXml[1]) > 0) sheetObjects[2].LoadSearchXml(arrXml[1]);//Tiered Free Time
				if (arrXml.length > 2 && ComGetTotalRows(arrXml[2]) > 0) sheetObjects[3].LoadSearchXml(arrXml[2]);//Rate Adjustment
				if (arrXml.length > 3 && ComGetTotalRows(arrXml[3]) > 0) sheetObjects[4].LoadSearchXml(arrXml[3]);//Actual Customer
				if (arrXml.length > 4 && ComGetTotalRows(arrXml[4]) > 0) sheetObjects[5].LoadSearchXml(arrXml[4]);//Commodity

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//Actual Customer 에 데이터가 있을 경우 Customer Type 을 설정해준다.
//				if (sheetObjects[4].RowCount > 0) {
//					ComSetObjValue(formObj.customerType, sheetObjects[4].CellValue(sheetObjects[4].HeaderRows, ACT_CUST_FLG));
//				}
//				else {
//					//기본값으로 설정한다.(Actual Customer)
//					ComSetObjValue(formObj.customerType, "Y");
//				}
				if ( formObj.custTpCd.value == "NVO" ){
					ComSetObjValue(formObj.customerType, "Y");
				} else {
					ComSetObjValue(formObj.customerType, "N");
				}
				
	        	break;
	        	
	        	
			//화면 Load 시 Version 정보를 조회한다.				
			case IBSEARCH_VER:	
			
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 			SEARCH02);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var verList = handleNullString(ComGetEtcData(sXml, "VER"));
	            
				ComClearCombo(formObj.version);
				
				if (verList != "")
					addComboItem(formObj.version, verList, 	false);
				else
					addComboItem(formObj.version, "001=",	true);
				break;
				
			//Action이 발생하기 직전 현재상태의 Version 정보를 조회한다.				
			case IBSEARCH_VER_CHECK:	
			
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 			SEARCH02);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				//ComOpenWait(true);
				//sheetObj.WaitImageVisible = false;
				//********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				//ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(MAX VERSION, MAX VERSION STATUS)
	            var verList = handleNullString(ComGetEtcData(sXml, "VER"));
				var val = getMaxVersion(verList);
				ComSetObjValue(formObj.max_ver, val);	//max_version 조회
				var val2 = getMaxVersionStatus(verList);
				ComSetObjValue(formObj.max_ver_status, val2);
				
				break;
			
				
			//화면 Load 시, Actual Customer Type 변경시 Actual Customer 정보를 조회한다.				
			case IBSEARCH_CUST:	
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 			SEARCH03);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var comboDatas = ComGetEtcData(sXml, "CUST");
               
				//3-1.조회된 결과를 그리드내에 해당 셀 콤보에 매핑시켜준다.
				addCellComboItem(sheetObj, comboDatas, CUST_CD, false);
				
				break;
				
				
			//Tariff Type 이 'DMIF, DMOF' 일 경우 Calc Type 을  체크한다.
			case IBSEARCH_CALC:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			SEARCH06);
							
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
				ComSetObjValue(formObj.f_cmd, 			SEARCH07);
							
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
				ComSetObjValue(formObj.f_cmd, 			SEARCH08);
							
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
				
				
			//Accept 버튼 클릭시 해당 S/C 가 Filed STS 인지 체크한다.
			case IBSEARCH_FILED:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			SEARCH09);
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
							
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
	            var comboDatas = ComGetEtcData(sXml, "FILED");
				ComSetObjValue(formObj.result, comboDatas);					
				break;
					
			
			//Save 버튼 클릭시 생성, 수정된 S/C Exception Tariff 를 DB 에 반영합니다.(한 건 단위로 실행된다)
			case IBSAVE_SCTARIFF:        
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			MULTI);
				
				var sParam = "";
				var sParam1 = sheetObjects[0].GetSaveString();
				var sParam2 = sheetObjects[1].GetSaveString();
				var sParam3 = sheetObjects[2].GetSaveString();
				var sParam4 = sheetObjects[3].GetSaveString();
				var sParam5 = sheetObjects[4].GetSaveString(true);	//all delete -> insert
				var sParam6 = sheetObjects[5].GetSaveString(true);	//all delete -> insert

				if (sheetObjects[0].IsDataModified == true) {
					sParam1 = ComSetPrifix(sParam1, "subGRP");
					sParam = sParam1 + "&";
				}
				if (sheetObjects[1].IsDataModified == true) {
					sParam2 = ComSetPrifix(sParam2, "subCVRG");
					sParam = sParam + sParam2 + "&";
				}
				if (sheetObjects[2].IsDataModified == true) {
					sParam3 = ComSetPrifix(sParam3, "subFT");
					sParam = sParam + sParam3 + "&";
				}
				if (sheetObjects[3].IsDataModified == true) {
					sParam4 = ComSetPrifix(sParam4, "subRT");
					sParam = sParam + sParam4 + "&";
				}
				if (sheetObjects[4].IsDataModified == true) {
					sParam5 = ComSetPrifix(sParam5, "subCT");
					sParam = sParam + sParam5 + "&";
				}
				if (sheetObjects[5].IsDataModified == true) {
					sParam6 = ComSetPrifix(sParam6, "subCM");
					sParam = sParam + sParam6 + "&";
				}					

				sParam += "&" + FormQueryString(formObj);

				//2.저장실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSaveXml("EES_DMT_2001GS.do", sParam);
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************				

				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
					
					//신규 S/C Exception Tariff 입력시 Group Seq 를 반환받아서 설정해준다. ======================
					var grpSeq 	= handleNullString(ComGetEtcData(sXml, "GRP_SEQ"));
					if (sheetObj.RowStatus(sheetObj.SelectRow) == "I") {
						sheetObj.CellValue2(sheetObj.SelectRow, GRP_SEQ) = grpSeq;
					}
					//======================================================================================					
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
                break;

                
   			//Update 버튼 클릭시 'Live'상태의 S/C Exception Tariff 정보를 새로운 버전으로 생성 합니다.
			case IBSAVE_SCTARIFF_UPDATE:
				//1.생성 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 					MULTI02);
				ComSetObjValue(formObj.prop_no, 				sheetObj.CellValue(sheetObj.HeaderRows, PROP_NO));
				ComSetObjValue(formObj.sc_expt_prev_ver_seq, 	sheetObj.CellValue(sheetObj.HeaderRows, VER_SEQ));
				ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"T");
				
				//2.위의 조건으로 S/C Exception Tariff 정보를 생성하도록 서버로직을 호출 합니다.
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
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
				
                
   			//S/C Exception Tariff History 팝업에서 선택한 버전의 S/C Exception Tariff 를 현재 버전에 생성 합니다.
            //만일, 현재 버전에 S/C Exception Tariff 가 존재한다면 모두 삭제한다.
			case IBSAVE_SCTARIFF_HISTORY:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 					MULTI03);
				ComSetObjValue(formObj.prop_no, 				ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, 		ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"T");
				
				//2.위의 조건으로 S/C Exception Tariff 정보를 생성하도록 서버로직을 호출 합니다.
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
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
				ComSetObjValue(formObj.f_cmd, 			SEARCH10);
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
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
				
				//3.결과 처리
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
				break;	
				
				
			case IBDELETE:
				//1.삭제 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			SEARCH05);	
				ComSetObjValue(formObj.prop_no, 		ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, ComParseInt(ComGetObjText(formObj.version)));
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
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
				
			
			//Row Delete 버튼을 클릭할 경우 해당 S/C Exception Tariff 를 삭제해 준다.
			case IBDELETE_SCTARIFF:
				//1.삭제 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 			MULTI01);	
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2001GS.do", FormQueryString(formObj));
				
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

	   		case IBSEARCH_ASYNC01:         // 조회
	   			formObj.f_cmd.value = COMMAND15;
	   			var selRow = sheetObj.SelectRow;
	   			
	   			var param = "f_cmd=" + COMMAND15
	   					  + "&cmdt_cd=" + sheetObj.CellText(sheetObj.SelectRow, "cmdt_cd")
	   					  ;
	   		
	       		//ComOpenWait Start
	   			sheetObj.WaitImageVisible=false;
	   			ComOpenWait(true);
	
	   			var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do",param);
	            
	            //ComOpenWait End
	            ComOpenWait(false);
            
	            var rtnName = ComGetEtcData(sXml, "rtnName");

	            if ( rtnName != undefined && rtnName != '') {
	                var rtnNameArr = rtnName.split("|");
	                sheetObj.CellValue2( selRow , 2 ) = rtnNameArr[1];
	            } else {
	                ComShowCodeMessage( "DMT00165" , "Commodity code" );
	                sheetObj.CellValue2( selRow , 1 ) = "";
	                sheetObj.CellValue2( selRow , 2 ) = "";
	            }
	            break;
	   		case IBSEARCH_ASYNC02:         // 조회
	   			formObj.f_cmd.value = SEARCH19;
	   			var selRow = sheetObj.SelectRow;
	   			var param = "f_cmd=" + SEARCH19
	   			          + "&cust_cnt_cd=" + sheetObj.CellText(sheetObj.SelectRow, "cust_cd").substring(0,2)
	   			          + "&cust_seq=" + ComLpad((sheetObj.CellText(sheetObj.SelectRow, "cust_cd").substring(2)),6,"0");
	   			          ;
	   			//MDM_CUSTOMER 존재 여부 확인
	   			var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do",param);
	   			
	   			var rtnName = ComGetEtcData(sXml, "CUST_NM");
	   			
	   			if ( rtnName != undefined && rtnName != '') {
	   				param = "f_cmd=" + SEARCH19
		          	  	  + "&prop_no=" + ComGetObjValue(formObj.prop_no)
 			          	  + "&cust_cnt_cd=" + sheetObj.CellText(sheetObj.SelectRow, "cust_cd").substring(0,2)
 			          	  + "&cust_seq=" + ComLpad((sheetObj.CellText(sheetObj.SelectRow, "cust_cd").substring(2)),6,"0")
 			          	  ;

	   				
		       		//ComOpenWait Start
		   			sheetObj.WaitImageVisible=false;
		   			ComOpenWait(true);
	   				
		   			var sXml2 = sheetObj.GetSearchXml("EES_DMT_2001GS.do" , param);
	   				
		            //ComOpenWait End
		            ComOpenWait(false);
	   				
	   				var rtnFlag = ComGetEtcData(sXml2, "rtnValue");
	   				if(rtnFlag == "Y"){
		   				ComShowCodeMessage( "DMT01151" );
		   				sheetObj.CellValue2( selRow , 1 ) = "";
		   				sheetObj.CellValue2( selRow , 2 ) = "";
	   				}else{
	   					sheetObj.CellValue2( selRow , 1 ) = sheetObj.CellText(sheetObj.SelectRow, "cust_cd").substring(0,2)
	   														+ ComLpad((sheetObj.CellText(sheetObj.SelectRow, "cust_cd").substring(2)),6,"0");
		                sheetObj.CellValue2( selRow , 2 ) = rtnName;
	   				}
	   			}else{
	   				ComShowCodeMessage( "DMT00165" , "Customer code" );
	   				sheetObj.CellValue2( selRow , 1 ) = "";
	   				sheetObj.CellValue2( selRow , 2 ) = "";
	   			}
	   			
            break;
				
        }
    }
	
	// 콤보관련 데이터를 조회하는 함수
	function doActionIBCombo(sheetObj, formObj, sAction, sComboAction, sComboKey, sSetParameter) {
        sheetObj.ShowDebugMsg 		= false;
		sheetObj.WaitImageVisible 	= false;
		
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
						comboDatas = ComGetEtcData(sXml, "common_tariff_cd");
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
						break;
						
					//3-2.CNTR/Cargo Type 조회(모든 CNTR/Cargo 목록)
					case SEARCH15:											
						comboDatas = ComGetEtcData(sXml, "COMMON_CD");
						addCellComboItem(sheetObj,comboDatas,sComboKey,false,true);
						break;

					//3-3.Origin or Dest. CT 조회(모든 Continent 목록)	
					case SEARCH08:
						comboDatas = ComGetEtcData(sXml, "CONTI");
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
						break;
						
					//3-4.Country 조회(모든 Country 목록)				
					case SEARCH02:
						comboDatas = ComGetEtcData(sXml, "CNT");
						if (sComboKey == "ALL") {
							//1.Group Sheet 의 Coverage CN 을 설정한다.						
							addCellComboItem(sheetObjects[0],comboDatas,"cnt_cd",false);
							//2.Group Sheet 의 Origin(I) or Dest.(D) 의 CN 을 설정한다.
							addCellComboItem(sheetObjects[0],comboDatas,"sc_expt_fm_cnt_cd",false);
							//3.Group Sheet 의 BKG DEL(I) or POR(O) 의 CN 을 설정한다.
							addCellComboItem(sheetObjects[0],comboDatas,"fnl_dest_cnt_cd",false);
							//4.Multi Coverage Sheet 의 Country 를 설정한다.
							addCellComboItem(sheetObjects[1],comboDatas,"cnt_cd",false);
						}
						else {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						}
						break;
						
					//3-5.Region 조회(모든 Region 목록)					
					case SEARCH01:
						comboDatas = ComGetEtcData(sXml, "RGN");
						if (sComboKey == "ALL") {
							//1.Group Sheet 의 Coverage State 을 설정한다.						
							addCellComboItem(sheetObjects[0],comboDatas,"rgn_cd",false);
							//2.Group Sheet 의 Origin(I) or Dest.(D) 의 RGN 을 설정한다.
							addCellComboItem(sheetObjects[0],comboDatas,"sc_expt_fm_rgn_cd",false);
							//3.Group Sheet 의 BKG DEL(I) or POR(O) 의 State 을 설정한다.
							addCellComboItem(sheetObjects[0],comboDatas,"fnl_dest_rgn_cd",false);
							//4.Multi Coverage Sheet 의 Region 를 설정한다.
							addCellComboItem(sheetObjects[1],comboDatas,"rgn_cd",false);
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
							comboDatas = ComGetEtcData(sXml, "STE");
						} else {
							comboDatas = ComGetEtcData(sXml, "RGN");
						}

						//조회된 결과가 없을 경우 Error Message 를  보여주고 Empty 로 초기화시킨다.
						if (comboDatas == undefined || ComTrim(comboDatas) == "") {
							ComShowCodeMessage("DMT00110", "Country");
							sheetObj.CellValue(selectedRow, sComboKey[0]) = "";
							return;
						} else {
							addCellComboItem(sheetObj,comboDatas,sComboKey[1],true);
						}					
						break;
						
					//3-7.Coverage LOC 상위 항목조회(입력한 LOC 에 해당되는 상위 CN, RGN 을 조회한다)
					case SEARCH04:
						sComboKey = sComboKey.split(ROWMARK);
						
						//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
						comboDatas = ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							
							if (sheetObj.id == "sheet1") selectedRow = sheetObj.SelectRow;
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							var cntCd = ComTrim(sheetObj.CellValue(selectedRow, sComboKey[0]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas = ComGetEtcData(sXml, "STE");
								} 
								else {
									comboDatas = ComGetEtcData(sXml, "RGN");
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
						comboDatas = ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined && ComTrim(comboDatas) != "") {
							addCellComboItem(sheetObj,comboDatas,sComboKey,true);
						} else {
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
						comboDatas = ComGetEtcData(sXml, "CONTI");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							comboDatas = ComGetEtcData(sXml, "CNT");
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							var cntCd = sheetObj.CellValue(selectedRow, sComboKey[1]);
							if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
								comboDatas = ComGetEtcData(sXml, "STE");
							} else {
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
						comboDatas = ComGetEtcData(sXml, "CONTI");
						if (comboDatas != undefined && ComTrim(comboDatas) != "") {
							setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							comboDatas = ComGetEtcData(sXml, "CNT");
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
						}
						break;
												
					//3-11.Origin or Dest. Region 상위 항목조회(선택한 Region 에 해당되는 상위 CT, CN 을 조회한다)
					case SEARCH13:

					//3-12.Origin or Dest. Region 상위 항목조회(선택한 Region 에 해당되는 상위 CT, CN 을 조회한다)
					case SEARCH17:
						sComboKey = sComboKey.split(ROWMARK);

						//응답 XML 에서 Continent 정보를 추출해서 목록에서 선택해준다.
						comboDatas = ComGetEtcData(sXml, "CONTI");
						if (comboDatas != undefined) {						
							if (ComTrim(sComboKey[0]) != "") {
								//응답 XML 에서 Continent 정보를 추출해서 목록에서 선택해준다.
								setCellComboItem(sheetObj, comboDatas, sComboKey[0], selectedRow);
							}
							
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							comboDatas = ComGetEtcData(sXml, "CNT");
							setCellComboItem(sheetObj, comboDatas, sComboKey[1], selectedRow);
							
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							var cntCd = ComTrim(sheetObj.CellValue(selectedRow, sComboKey[1]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas = ComGetEtcData(sXml, "STE");
								} 
								else {
									comboDatas = ComGetEtcData(sXml, "RGN");
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
						ComClearCombo(formObj.currency);
						comboDatas = ComGetEtcData(sXml, sComboKey);
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
	function addCellComboItem(sheetObj, comboDatas, sComboKey, isCellCombo, isOnlyTextView) {
    	var formObj			= document.form;
		var comboItem;
		var comboItems;
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
					if (isOnlyTextView) {
						comboTxt += comboItem[1];
					} else {
						//ACTUAL CUSTOMER 콤보설정일때
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
			comboItems = comboDatas.split(ROWMARK);	
	    	for (var i = 0 ; i < comboItems.length ; i++) {
    			comboItem = comboItems[i].split(FIELDMARK);
				val = comboItem[0];
				txt = isOnlyCode ? comboItem[0] : comboItem[1];
				ComAddComboItem(comboObj,val,txt);
    		}
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
				val = ver_item[0];
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
				val = ver_item[1];
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
 	 * Multi Origin or Destination 각 Row 별로 Rate Adjustment 필수여부를 
 	 * 조회해서 그 결과를 반환한다.
 	 */
 	function getRTMandatory() {
 		var sheetObj1 = sheetObjects[0];
 		var sheetObj2 = sheetObjects[1];
 		
 		with(sheetObj1) {
 			var propNo = CellValue(SelectRow, PROP_NO);
 			var verSeq = CellValue(SelectRow, VER_SEQ);
 			var grpSeq = CellValue(SelectRow, GRP_SEQ);
 		}
 		
 		var mark = "N";
 		with(sheetObj2) {
	 		for (var row = HeaderRows ; row <= LastRow ; row++) {
	 			//삭제된 데이터에 대해서는 처리하지 않는다.		
	 			if (CellValue(row, HID_STATUS) != "Y") {				
	 				if (	propNo == CellValue(row, PROP_NO)
	 					 && verSeq == CellValue(row, VER_SEQ)
	 					 && grpSeq == CellValue(row, GRP_SEQ)	) {
	 					if (CellValue(row, RT_MANDATORY) == "Y") {
	 						mark = "Y";
	 					}
	 				}
	 			}
	 		}
 		}
 		return mark;
 	}     
		
    /**
     * Rate Adjustment 가 선택되었는지를 체크하는 함수.
     */	
	function setCheckMarkRTAdjust(selectedRow) {
    	 var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		var sheetRTObj 	= sheetObjects[3];
		
		//1.Rate Adjustment 에 등록된 데이터가 있다면 선택표시를 해준다.
		//  Currency 가 등록된 데이터가 있다면 선택표시를 해준다.	
		//  Mandatory 항목으로 지정되어 있다면 선택표시를 해준다.
		var rowCount 	= fetchRowCount(sheetRTObj);
		var currCd 		= sheetSCObj.CellValue(selectedRow, CURR_CD);
		var isMandatory = sheetSCObj.CellValue(selectedRow, RT_MANDATORY);
		
		if (rowCount > 0 || currCd != "" || isMandatory == "Y") {
			sheetSCObj.CellValue(selectedRow, RT_CHECK) = "Y";
		} else {
			sheetSCObj.CellValue(selectedRow, RT_CHECK) = "N";
		}
	}
		
    /**
     * Rate Adjustment Sheet 의 Currency 를 조회하는 함수
     */	
	function searchCurrencyList(selectedRow) {
    	var formObj 	= document.form;
		var sheetRTObj 	= sheetObjects[3];
	
		if (getSCExceptionCountry(selectedRow) != "") {
			doActionIBCombo(sheetRTObj, formObj, IBSEARCH, COMMAND05, "CURRENCY");
		}
	}

    /**
     * 선택된 GROUP ROW 에 해당되는 Coverage Country 를 조회하는 함수
     */	
	function getSCExceptionCountry(selectedRow) {
		var sheetSCObj 		= sheetObjects[0];
		var sheetCVRGObj 	= sheetObjects[1];
		var cntCd 			= "";
				
		if (sheetSCObj.CellValue(selectedRow, CVRG_MULTI) == "S") {
			cntCd = ComTrim(sheetSCObj.CellValue(selectedRow, CVRG_CNT));
		}
		else if (fetchRowCount(sheetCVRGObj) > 0) {
			cntCd = fetchColumnValueOfLastRow(sheetCVRGObj, CVRG_CNT);
		}
		return cntCd;	
	}

    /**
     * 선택된 Currency 값을 Group Sheet 의 선택된 Row 의 Currency 필드에 설정해준다.
     */
	function setCurrencyVal() {
    	var formObj 	= document.form;
		var sheetObj 	= sheetObjects[0];
		
		sheetObj.CellValue(sheetObj.SelectRow, CURR_CD) = ComTrim(ComGetObjValue(formObj.currency));
	}
	
	/**
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setComboParameters(sheetObj, sAction, sComboKey) {
		var formObj 		= document.form;
		var sheetSCObj	 	= sheetObjects[0];
		var sheetCVRGObj 	= sheetObjects[1];

		ComSetObjValue(formObj.f_cmd, sAction);			//Command
		
		var rgnCd = "";
		if (sComboKey.indexOf("fnl") != -1 && sheetObj.SelectRow >= sheetObj.HeaderRows) {
			ComSetObjValue(formObj.conti_cd, 	"");
			ComSetObjValue(formObj.cnt_cd, 		sheetObj.CellValue(sheetObj.SelectRow, BKGDEL_CNT));		//BKG DEL(I) or POR(O) CN
			
			rgnCd = ComTrim(sheetObj.CellValue(sheetObj.SelectRow, BKGDEL_RGN));
			if (rgnCd.length == 2) 
				ComSetObjValue(formObj.ste_cd, rgnCd);	//Coverage STE
			else 
				ComSetObjValue(formObj.rgn_cd, rgnCd);						//Coverage RGN
			
			ComSetObjValue(formObj.rgn_cd, 		sheetObj.CellValue(sheetObj.SelectRow, BKGDEL_RGN));		//BKG DEL(I) or POR(O) State
			ComSetObjValue(formObj.loc_cd, 		sheetObj.CellValue(sheetObj.SelectRow, BKGDEL_LOC));		//BKG DEL(I) or POR(O) LOC				
		}
		else if (sComboKey.indexOf("sc") != -1 && sheetObj.SelectRow >= sheetObj.HeaderRows) {
			ComSetObjValue(formObj.conti_cd, 	sheetObj.CellValue(sheetObj.SelectRow, ORGDST_CTI));		//Origin(I) or Dest.(O) CT
			ComSetObjValue(formObj.cnt_cd, 		sheetObj.CellValue(sheetObj.SelectRow, ORGDST_CNT));		//Origin(I) or Dest.(O) CN
			
			rgnCd = ComTrim(sheetObj.CellValue(sheetObj.SelectRow, ORGDST_RGN));
			if (rgnCd.length == 2) 
				ComSetObjValue(formObj.ste_cd, rgnCd);	//Origin(I) or Dest.(O) STE
			else 
				ComSetObjValue(formObj.rgn_cd, rgnCd);						//Origin(I) or Dest.(O) RGN
			
			ComSetObjValue(formObj.loc_cd, 		sheetObj.CellValue(sheetObj.SelectRow, ORGDST_LOC));		//Origin(I) or Dest.(O) LOC				
		}
		//Rate Adjustment 의 Currency 콤보의 조회조건을 채워준다.
		else if (sComboKey == "CURRENCY") {
			if (sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_MULTI) == "S") {
				ComSetObjValue(formObj.cnt_cd, 	sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_CNT));
			}
			else if (fetchRowCount(sheetCVRGObj) > 0) {
				ComSetObjValue(formObj.cnt_cd, 	sheetCVRGObj.CellValue(sheetCVRGObj.HeaderRows, CVRG_CNT));
			}
		}
		else if (sheetObj.SelectRow >= sheetObj.HeaderRows) {
			ComSetObjValue(formObj.conti_cd, 	"");
			ComSetObjValue(formObj.cnt_cd, 		sheetObj.CellValue(sheetObj.SelectRow, CVRG_CNT));			//Coverage CN
			
			rgnCd = ComTrim(sheetObj.CellValue(sheetObj.SelectRow, CVRG_RGN));
			if (rgnCd.length == 2) 
				ComSetObjValue(formObj.ste_cd, rgnCd);	//Coverage STE
			else 
				ComSetObjValue(formObj.rgn_cd, rgnCd);						//Coverage RGN				
			
			ComSetObjValue(formObj.loc_cd, 		sheetObj.CellValue(sheetObj.SelectRow, CVRG_LOC));			//Coverage LOC
		}
	}
	
	/**
	 * Sheet1 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
	    var formObj 		= document.form;
		var sheetCVRGObj	= sheetObjects[1];
		var sheetFTObj		= sheetObjects[2];

		//Coverage 컬럼에서 Rate Adjustment 필수여부를 체크하다가 없을 경우 Coverage 모든 컬럼을 Clear 하기 위해서 사용하는 변수
		var isCoverageError = false; 
		
		switch(sheetObj.ColSaveName(Col)) {
			
			case TARIFF:
				changeCYDoor(sheetObj, Row);
				changeBKGDELorPOR(sheetObj, Row);
				//선택된 Tariff 타입에 따라서 Multi Coverage 의 제목이 변경된다.(2009-07-28)
				setMultiCoverageTitle();
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
				
			//Coverage Multi 항목에서 'Single' or 'Multi' 선택시 =======================================================================
			case CVRG_MULTI:
				//1.변경에 따라서 무조건 Country 정보는 초기화 되기 때문에 Currency 정보를 초기화 해준다.
				ComClearCombo(formObj.currency);
				
				//2.Coverage Type 이 변경될 때마다 Rate Adjustment 필수여부를 기본값 'N' 으로 초기화 시킨다.(2009-07-31)
				sheetObj.CellValue(Row, RT_MANDATORY) = "N";
				
				//3.선택한 Multi Type 에 맞게 Coverage 입력상태를 변경해준다.(체크박스, 버튼포함)
				setMultiCoverageGrid();
				
				//4-1.Multi Coverage 를 선택할 경우 자동으로 Row 를 추가해준다.(2009-07-28)
				if (Value == "M") {
					with(sheetObj) {
						CellValue2(Row, 	CVRG_CNT) 	= "";
						CellValue2(Row, 	CVRG_RGN) 	= "";
						CellValue2(Row, 	CVRG_LOC) 	= "";
					}
					
					addMultiCoverage();
				}
				//4-2.Single 로 선택할 경우 Multi Coverage 에 있는 모든 데이터를 삭제한다.
				else {
					delSubSCException(sheetCVRGObj, "All");
				}
				break;
			//======================================================================================================================
			
				
			case CVRG_CNT:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG = CVRG_CNT;
				
				var cntCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Country 가 Empty 라면 모든 Region 정보를 조회한다.
				if (cntCd.length == 0) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH01,"rgn_cd");
					sheetObj.CellValue(Row,"rgn_cd") = "";
					
					//Country 가 Empty 될 경우 Currency 정보를 지운다.
					ComClearCombo(formObj.currency); 
				}
				//Country 에 소속된 하위 Regino or State 정보를 조회한다.	
				else if (cntCd.length == 2) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH03,"cnt_cd|rgn_cd");
					//Country 가 변경될 경우 그에 해당되는 Currency 정보를 조회한다.
					searchCurrencyList(Row);
					//조회된 Currency 정보에서 첫번째 항목을 기본값으로 설정한다.
					sheetObj.CellValue(Row, CURR_CD) = ComTrim(ComGetObjValue(formObj.currency));
				}
				//Country 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"loc_cd");
				
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

				var rgnCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Region 를 포함하는 상위  Country 정보를 조회한다.
				switch(rgnCd.length) {
					case 2: 
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17,"|cnt_cd|rgn_cd");
						break;
						
					case 3:
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13,"|cnt_cd|rgn_cd");
						break;
				}
				//Region 이 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"loc_cd");
				
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
	    			doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH04,"cnt_cd|rgn_cd|loc_cd");
					isValueSettingEvent = false;
					isClearLocation = true;
				}
				else if (locCd.length > 0){
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

				
			//Free Time Y 항목에서 체크박스 선택하거나 선택해제시=======================================================================	==
			case FT_FLG:
				with(sheetObj) {
					if (Value == "1") {
						CellValue(Row, 		FT_TIR) 	= "S";
					}
					else {
						CellValue(Row, 		FT_TIR) 	= "";
						CellValue(Row, 		ADD_DYS) 	= "";
						CellValue(Row, 		TOT_DYS) 	= "";
					}
				}
				break;			
			//======================================================================================================================
				
				
			//Free Time Tier 항목에서 'Single' or 'Multi' 선택시 =======================================================================			
			case FT_TIR:
				//1.선택한 Free Time Tier 에 맞게 Coverage 입력상태를 변경해준다.(체크박스, 버튼포함)
				setTieredFreeTimeGrid();

				//2-1.Tiered Free Time 를 선택할 경우 자동으로 Row 를 추가해준다.(2009-07-28)
				if (Value == "M") {
					with(sheetObj) {
						CellValue(Row, 		ADD_DYS) 	= "";
						CellValue(Row, 		TOT_DYS) 	= "";
					}
					
					addFreeTime();
				}
				//2-2.Single 로 선택할 경우 Multi Coverage 에 있는 모든 데이터를 삭제한다.
				else {
					delSubSCException(sheetFTObj, "All");
				}

				break;
			//======================================================================================================================
				
				
			case ORGDST_CTI:
				var ctCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Continent 가 Empty 라면 모든 Country 와 모든 Region 정보를 조회한다.
				if (ctCd.length == 0) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH02,"sc_expt_fm_cnt_cd");
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH01,"sc_expt_fm_rgn_cd");
				}
				//Continent 에 소속된 하위 Country 정보를 조회한다.
				else if (ctCd.length == 1) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH06,"sc_expt_fm_cnt_cd");
				}
				//Continent 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"sc_expt_fm_loc_cd");				
				break;
			
				
			case ORGDST_CNT:
				var cntCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Country 가 Empty 라면 모든 Region 정보를 조회한다.
				if (cntCd.length == 0) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH01,"sc_expt_fm_rgn_cd");
					sheetObj.CellValue(Row,"sc_expt_fm_rgn_cd") = "";
				}
				//Country 를 포함하는 상위 Continent 와 Country 에 소속된 하위 Region 정보를 조회한다.
				else if (cntCd.length == 2) {
					if (!isValueSettingEvent) {
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH12,"sc_expt_fm_conti_cd|sc_expt_fm_cnt_cd");
					}
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH03,"sc_expt_fm_cnt_cd|sc_expt_fm_rgn_cd");
				}
				//Country 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"sc_expt_fm_loc_cd");				
				break;
				
				
			case ORGDST_RGN:
				if (isValueSettingEvent) return;	//화면에서 발생된 이벤트가 아닐경우에는 무시한다.
				
				var rgnCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Region 를 포함하는 상위 Continent, Country 정보를 조회한다.
				switch(rgnCd.length) {
					case 2: 
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17,"sc_expt_fm_conti_cd|sc_expt_fm_cnt_cd|sc_expt_fm_rgn_cd");
						break;
						
					case 3:
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13,"sc_expt_fm_conti_cd|sc_expt_fm_cnt_cd|sc_expt_fm_rgn_cd");
						break;
				}
				//Region 이 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"sc_expt_fm_loc_cd");				
				break;
					
				
			case ORGDST_LOC:
				var locCd = ComTrim(sheetObj.CellValue(Row,Col));
				if (locCd.length == 5) {
					isClearLocation = false;
					isValueSettingEvent = true;
					//Location 상위(Continent, Country, Region or State) 정보를 조회한다.
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH10,"sc_expt_fm_conti_cd|sc_expt_fm_cnt_cd|sc_expt_fm_rgn_cd|sc_expt_fm_loc_cd");
					isValueSettingEvent = false;
					isClearLocation = true;
				}
				else if (locCd.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.CellValue2(Row, Col) = "";
				}							
				break;
				
				
			case BKGDEL_CNT:
				if (getCoverageCNData(Row) == "") {
					sheetObj.CellValue2(Row, BKGDEL_CNT) = "";
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				
				var cntCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Country 가 Empty 라면 모든 Region 정보를 조회한다.
				if (cntCd.length == 0) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH01,"fnl_dest_rgn_cd");
					sheetObj.CellValue(Row,"fnl_dest_rgn_cd") = "";
				}
				//Country 에 소속된 하위 Region 정보를 조회한다.
				else if (cntCd.length == 2) {
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH03,"fnl_dest_cnt_cd|fnl_dest_rgn_cd");
				}
				//Country 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"fnl_dest_loc_cd");
				
				//BKG POR(O) or DEL(I) 입력된 CN의 Continent가 12번 Coverage의 Continent와 다를 경우 
				//“Discrepancy with Coverage continent!” Alert창 띄우며 막음 (2009-07-28)
				if (!equalContinentByCN(Row)) {
					ComShowCodeMessage("DMT02008");
					sheetObj.CellValue(Row, BKGDEL_CNT) = "";
					sheetObj.CellValue2(Row, BKGDEL_LOC) = "";
					return;
				}
				break;
				
				
			case BKGDEL_RGN:
				if (getCoverageCNData(Row) == "") {
					sheetObj.CellValue2(Row, BKGDEL_RGN) = "";
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				
				if (isValueSettingEvent) return;	//화면에서 발생된 이벤트가 아닐경우에는 무시한다.
				
				var rgnCd = ComTrim(sheetObj.CellValue(Row,Col));
				//Region 를 포함하는 상위  Country 정보를 조회한다.
				switch(rgnCd.length) {
					case 2: 
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17,"|fnl_dest_cnt_cd|fnl_dest_rgn_cd");
						break;
						
					case 3:
						doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13,"|fnl_dest_cnt_cd|fnl_dest_rgn_cd");
						break;
				}
				//Region 이 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) clearLocation(sheetObj,"fnl_dest_loc_cd");						
				break;
					
				
			case BKGDEL_LOC:
				if (getCoverageCNData(Row) == "") {
					sheetObj.CellValue2(Row, BKGDEL_LOC) = "";
					ComShowCodeMessage("DMT00148", "Coverage");
					return;
				}
				
				var locCd = ComTrim(sheetObj.CellValue(Row,Col));
				if (locCd.length == 5) {
					isClearLocation 	= false;
					isValueSettingEvent = true;
					
					//Location 상위(Country, Region or State) 정보를 조회한다.
					doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH04,"fnl_dest_cnt_cd|fnl_dest_rgn_cd|fnl_dest_loc_cd");
					
					isValueSettingEvent = false;
					isClearLocation 	= true;
				}	
				else if (locCd.length > 0) {
					ComShowCodeMessage("DMT00110", "Location");
					sheetObj.CellValue2(Row, Col) = "";
				}							
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
				if (currGrpSeq == CellValue(row, GRP_SEQ)) {
					SelectRow = row;
					break;
				}
			}
		}
	}

	/**
	 * S/C Exception Tariff 의 Group Seq. 의 선택이 변경될 경우 해당 하위 항목들을 조회한다.
	 */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var formObj	= document.form;
		
		//========================================================================================
    	//Row Add, Row Copy 버튼이 클릭될 경우 자동으로 Row 선택이 변경되면서 이 함수를 호출합니다.
    	//이 경우는 예상치 않은 함수호출이기 때문에 아래 로직을 수행하지 않습니다.
    	if (isCopySCExceptionTariff) return;
    	//========================================================================================
    	
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		with(sheetObj) {
			if (OldRow >= HeaderRows && OldRow != NewRow) {
				
				//chkResult => 0: 결과, 1: 발생된 Row, 2:입력,수정,삭제 구분, 3:에러메시지
				var chkResult = isChangedSCExceptionTariff();
				if (chkResult[0]) {
					if (!ComShowCodeConfirm("DMT01112", "save")) {
						SelectRow = OldRow;
						
						//-------------------------------------------
						currGrpSeq = CellValue(SelectRow, GRP_SEQ);
						//-------------------------------------------
						
						return;
					}
					
					//추가, 수정, 삭제된 Row 정보를 DB 에 반영한다. ########################
					SelectRow = OldRow;
					
					//-------------------------------------------
					currGrpSeq = CellValue(SelectRow, GRP_SEQ);
					//-------------------------------------------
					
					//매개변수는 변경된 정보가 있음을 나타낸다.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
					if (!saveGroup(chkResult[0], true)) return;	
					//##################################################################
				}
				else {
					//-------------------------------------------
					currGrpSeq = CellValue(SelectRow, GRP_SEQ);
					//-------------------------------------------
					
					//선택한 Group Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
					setSubSCException(true);
				}
			}
		}
	}
	
	/*
	 * Sheet1 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {

		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow == (HeaderRows - 1)) {
				switch(colName) {
					case ADD_DYS: MouseToolTipText = "Additional Day"; break;
					case TOT_DYS: MouseToolTipText = "Total Day"; break;
					default: MouseToolTipText = "";
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
		
	/*
	 * Sheet2(Multi Coverage) 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];

		//Coverage 컬럼에서 Rate Adjustment 필수여부를 체크하다가 없을 경우 Coverage 모든 컬럼을 Clear 하기 위해서 사용하는 변수
		var isCoverageError = false; 
		
		switch(sheetObj.ColSaveName(Col)) {
			
			//[Country] 변경시 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			case CVRG_CNT:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG = CVRG_CNT;

				//타 메소드 호출시 현재 Row 정보를 전달하기 위해서 아래 변수에 그 값을 설정해 준다.===========================================================
				var isDeleteRowValue = false;
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue = true;
				}
				//================================================================================================================================

				if (Value.length == 0) {
					
					//Country 에 해당되는 Region or Status 정보를 조회한다. ========================================================================
					doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01, "rgn_cd"); 
	
					//조회 완료 후에는 아래 매개변수를 지워줘야 한다.
					if (isDeleteRowValue) {
						ComSetObjValue(formObj.select_row, 	"");
					}
					//==========================================================================================================================

					//Country 정보가 공백이므로 Region 정보도 공백으로 초기화 시킨다.
					sheetObj.CellValue(Row, "rgn_cd") = "";
					
					//Country 가 Empty 될 경우 Currency 정보를 지운다.
					ComClearCombo(formObj.currency); 	
				}
				//Country 에 소속된 하위 Region 정보를 조회한다.
				else if (Value.length == 2) {

					//Country 에 해당되는 Region or Status 정보를 조회한다. ========================================================================
					ComSetObjValue(formObj.cnt_cd,		Value);	
					ComSetObjValue(formObj.f_cmd,		SEARCH03);

					doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH03, "cnt_cd|rgn_cd", false);

					//조회 완료 후에는 아래 매개변수를 지워줘야 한다.
					if (isDeleteRowValue) {
						ComSetObjValue(formObj.select_row, 	"");
					}
					//==========================================================================================================================

					//Multi Coverage 에서는 첫번째 항목에 대해서만 Currency 조회를 실행한다.
					var rowCount = fetchRowCount(sheetObj);
					if (rowCount < 2) {
						//Country 가 변경될 경우 그에 해당되는 Currency 정보를 조회한다.
						searchCurrencyList(sheetSCObj.SelectRow);
						//조회된 Currency 정보에서 첫번째 항목을 기본값으로 설정한다.
						sheetSCObj.CellValue(sheetSCObj.SelectRow, CURR_CD) = ComTrim(ComGetObjValue(formObj.currency));
					}
				}

				//Country 가 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) sheetObj.CellValue2(Row, CVRG_LOC) = "";
				
				//Rate Adjustment 항목의 필수,선택여부를 체크한다.(2009-07-31)
				if (isRateCheckingCVRG == CVRG_CNT) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError = true;
					}
				}
				
				if (isRateCheckingCVRG == CVRG_CNT) isRateCheckingCVRG = "";
				break;
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				
				
			//[Region] 변경시 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			case CVRG_RGN:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG = CVRG_RGN;
				
				if (isValueSettingEvent) return;	//화면에서 발생된 이벤트가 아닐경우에는 무시한다.
				
				var isDeleteRowValue = false;
				//Region or State 의 Continent, Country, Region 정보를 조회한다. ===================================================================
				if (ComGetObjValue(formObj.select_row) == "") {
					ComSetObjValue(formObj.select_row, 	Row);
					isDeleteRowValue = false;
				}
				
				if (Value.length == 2) {
					ComSetObjValue(formObj.rgn_cd,		"");	
					ComSetObjValue(formObj.ste_cd,		Value);
				}
				else {
					ComSetObjValue(formObj.rgn_cd,		Value);	
					ComSetObjValue(formObj.ste_cd,		"");
				}
				
				switch(Value.length) {
					case 2:
						ComSetObjValue(formObj.f_cmd,		SEARCH17);

						//마지막 매개변수는 doActionIBCombo 에서 조회를 위한 매개변수를 설정할지 여부를 알려준다.
						doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH17, "|cnt_cd|rgn_cd", false);
						break;
						
					case 3:
						ComSetObjValue(formObj.f_cmd,		SEARCH13);

						//마지막 매개변수는 doActionIBCombo 에서 조회를 위한 매개변수를 설정할지 여부를 알려준다.
						doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH13, "|cnt_cd|rgn_cd", false);
						break;
				}

				//조회 완료 후에는 아래 매개변수를 지워줘야 한다.
				if (isDeleteRowValue) {
					ComSetObjValue(formObj.select_row, 	"");
				}
				//================================================================================================================================
				
				//Region 이 변경될 경우 Location 정보를 지운다.
				if (isClearLocation) sheetObj.CellValue2(Row, CVRG_LOC) = "";
				
				//Rate Adjustment 항목의 필수,선택여부를 체크한다.(2009-07-30)
				if (isRateCheckingCVRG == CVRG_RGN) {
					if (checkMandatoryRateAdjustment() == "E") {
						isCoverageError = true;
					}
				}

				if (isRateCheckingCVRG == CVRG_RGN) isRateCheckingCVRG = "";					
				break;	
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				
			
			//[Location] 변경시 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			case CVRG_LOC:
				if (isRateCheckingCVRG == "") isRateCheckingCVRG = CVRG_LOC;
				
				if (Value.length == 5) {
					isClearLocation 	= false;
					isValueSettingEvent = true;
					
					//Location 상위(Country, Region or State) 정보를 조회한다. ===================================================================
					//조회를 위한 매개변수를 설정한다.(loc_cd 만 사용하기 때문에 이 필드만 설정해주면 된다.)
					ComSetObjValue(formObj.loc_cd,		Value);	
					ComSetObjValue(formObj.select_row, 	Row);
					ComSetObjValue(formObj.f_cmd,		SEARCH04);
					
					//마지막 매개변수는 doActionIBCombo 에서 조회를 위한 매개변수를 설정할지 여부를 알려준다.
					doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH04, "cnt_cd|rgn_cd|loc_cd", false); 
					
					//조회 완료 후에는 아래 매개변수를 지워줘야 한다.
					ComSetObjValue(formObj.select_row, 	"");
					//==========================================================================================================================
					
					isValueSettingEvent = false;
					isClearLocation 	= true;
				}		
				else if (Value.length > 0) {
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
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				
		}

		//Rate Adjustment Mandatory 체크시 Coverage 컬럼에서 에러 발생시 Coverage 컬럼을 모두 Clear 해준다.
		if (isCoverageError) sheetObj.CellValue(Row, CVRG_CNT) = "";
	}
	
	/*
	 * Sheet2 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function sheet2_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		var sheetSCObj = sheetObjects[0];
		
		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow >= HeaderRows && MouseRow <= LastRow) {

				if (colName == CVRG_CNT || colName == CVRG_RGN || colName == CVRG_LOC) {
					var trfCd = sheetSCObj.CellValue(sheetSCObj.SelectRow, TARIFF);
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
		
	/*
	 * Sheet3(Tiered Free Time) 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		var formObj 	= document.form;
		var sheetObj 	= sheetObjects[2];

		with(sheetObj) {
			switch(ColSaveName(Col)) {
			case FT_UPTO:

				if (	ComTrim(CellValue(Row, FT_FROM)) != "" 
					&& 	ComTrim(CellValue(Row, FT_UPTO)) != "" 
					&& 	ComParseInt(CellValue(Row, FT_FROM)) > ComParseInt(CellValue(Row, FT_UPTO))) {
					ComShowCodeMessage("DMT01032", "[Tiered Free Time]");
					CellValue2(Row, FT_UPTO) = "";
					return;
				}
				
				var ftUpTo = ComTrim(CellValue(Row,Col));
				var ftFmTo = ComParseInt(ftUpTo) + 1;
				
				//다음 Row 가 없을 경우 -1 을 반환하고, 있을 경우 Row 값을 반환한다.
				var nextRow = getNextRow(Row, sheetObj);
				if (nextRow > 0) {
					CellValue2(nextRow, FT_FROM) = ftFmTo;						
				}
				break;
			}
		}
	 }
		
	/*
	 * Sheet4(Rate Adjustment) 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet4_OnChange(sheetObj, Row, Col, Value) {
		var formObj 	= document.form;
		var sheetObj 	= sheetObjects[3];

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
								
	/*
	 * Sheet5(Actual Customer) 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet5_OnChange(sheetObj,Row,Col,Value) {
		switch(sheetObj.ColSaveName(Col)) {
			case CUST_CD:
				var row_value = sheetObj.CellText(Row, Col);
				if(row_value.length < 3) {
					ComShowCodeMessage( "DMT00165" , "Customer code" );
					sheetObj.CellValue2(Row, CUST_CD) = "";
					sheetObj.CellValue2(Row, CUST_NM) = "";
				} else {
		    		var cust_cnt_cd = row_value.substring(0,2);
		    		var cust_seq	= row_value.substring(2);
		    		if(isNaN(cust_seq)){
		    			ComShowCodeMessage( "DMT00165" , "Customer code" );
		    			sheetObj.CellValue2(Row, CUST_CD) = "";
						sheetObj.CellValue2(Row, CUST_NM) = "";
		    		}else{
		    			if (ComLpad(cust_seq,6,"0")!="000000"){
		    				sheetObj.CellValue2(Row, CMDT_CD) = cust_cnt_cd+ComLpad(cust_seq,6,"0");
		    			}
		    			doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC02); 	//입력 코드 validation 체크
		    		}
				}
				break;
		}		
	}
	 
	/*
	 * Sheet6(Commodity) 에 변경이 발생하였을 때 호출되는 함수
	 */		 
	function sheet6_OnChange(sheetObj,Row,Col,Value) {
		switch(sheetObj.ColSaveName(Col)) {
			case CMDT_CD:
				var row_value = sheetObj.CellText(Row, Col);
				if (row_value == "") {
					sheetObj.CellValue2(Row, CMDT_CD) = "";
					sheetObj.CellValue2(Row, CMDT_NM) = "";
				} else {
					doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01); 	//입력 코드 validation 체크
				}

				break;
		}		
	}	
	

	
	/**
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation(sheetObj, sComboKey) {
		 
		//현재 ROW 를 결정한다.(Multi Coverage 에서는 여러줄에 복사를 할 경우 발생되는 문제점을 처리하기 위함) +++++++++++++++++++++++++++++++++
		selectedRow = sheetObj.SelectRow;
		if (sheetObj.id == "sheet2" && ComGetObjValue(formObj.select_row) != "") {
			selectedRow = ComGetObjValue(formObj.select_row);
		}
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
		sheetObj.CellValue2(selectedRow, sComboKey) = "";
	}
	
	/**
	 * Coverage 필드를 Empty 로 초기화한다.
	 */	
	function clearCoverage() {
		var sheetObj = sheetObjects[0];
				
		sheetObj.CellText(sheetObj.SelectRow,CVRG_CNT) = "";
		sheetObj.CellText(sheetObj.SelectRow,CVRG_RGN) = "";
		
		//불필요한 Rate Adjustment 의 필수여부체크를 막기 위해서 아래 전역변수를 임의 값으로 설정함.
		isRateCheckingCVRG = "No Checking";
		sheetObj.CellComboItem(sheetObj.SelectRow,CVRG_RGN,"","");
		isRateCheckingCVRG = "";
		
		sheetObj.CellValue2(sheetObj.SelectRow, CVRG_LOC) = "";
	}
	
	/**
	 * CY/Door 필드의 상태변경 : Tariff 가 DTIC/DTOC/CTIC/CTOC 일 때만 입력 활성화
	 */		
	function changeCYDoor(sheetObj,Row) {
		var trfCd = ComTrim(sheetObj.CellValue(Row,TARIFF));
		
		if (trfCd == "DTIC" || trfCd == "DTOC" || trfCd == "CTIC" || trfCd == "CTOC") {
			sheetObj.CellEditable(Row,CYDOOR) = true;
		}
		else {
			sheetObj.CellValue(Row,CYDOOR) = "";
			sheetObj.CellEditable(Row,CYDOOR) = false;
		}		
	}
	
	/**
	 * BKG DEL(I) or PRO(O) 필드의 상태변경 : Tariff 가 DMIF/DMOF 일 때만 입력 활성화
	 */		
	function changeBKGDELorPOR(sheetObj,Row) {
		var trfCd = ComTrim(sheetObj.CellValue(Row,TARIFF));
		
		if (trfCd == "DMIF" || trfCd == "DMOF") {
			sheetObj.CellEditable(Row,BKGDEL_CNT) = true;
			sheetObj.CellEditable(Row,BKGDEL_RGN) = true;
			sheetObj.CellEditable(Row,BKGDEL_LOC) = true;
		}
		else {
			sheetObj.CellValue2(Row,BKGDEL_CNT) = "";
			sheetObj.CellValue2(Row,BKGDEL_RGN) = "";
			sheetObj.CellValue2(Row,BKGDEL_LOC) = "";
			sheetObj.CellEditable(Row,BKGDEL_CNT) = false;
			sheetObj.CellEditable(Row,BKGDEL_RGN) = false;
			sheetObj.CellEditable(Row,BKGDEL_LOC) = false;
		}
	}	
		
	/*
	 * Group 정보를 추가한다.
	 */		
	function addGroup() {
		var formObj 		= document.form;
		var sheetSCObj 		= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		var sheetFTObj		= sheetObjects[2];
		var sheetRTObj		= sheetObjects[3];
		var sheetCUSTObj	= sheetObjects[4];
		var sheetCMDTObj	= sheetObjects[5];		

		//1.Row Add 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구 ==========================
		var chkResult = isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				//변경된 내용만 조회해서 그리드에 설정.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
				if (!saveGroup(chkResult[0], true)) return;	
			}
			else {
				//ComShowCodeMessage("DMT01115");
				return;
			}
		}
		//==========================================================================================================================
		
		with(sheetSCObj) {
			if (fetchRowCount(sheetSCObj) > 0) {
				propNo = CellValue(LastRow, PROP_NO);
				verSeq = CellValue(LastRow, VER_SEQ);
			} else {
				propNo = ComGetObjValue(formObj.proposalNo);
				verSeq = ComParseInt(ComGetObjText(formObj.version));
			}
		
			//===============================================================================================================
			//Row 를 생성하면 자동으로 포커스가 이동한다.
			//포커스가 이동되면서 sheet1_OnSelect 함수를 호출하게 되고, 거기에서 변경된 내용이 있는지 조회하는 모듈을 태운다.
			//바로, 위 프로세스를 막기 위해서 아래와 같이 전역변수에 플래그값을 변경한다.
			isCopySCExceptionTariff = true;
			var irow = DataInsert(-1);
			isCopySCExceptionTariff = false;
			
			// new row 글자색 지정 2011.12.14  김현화
			sheetSCObj.RowFontColor(irow) = RgbColor(0,0,255); 
			//===============================================================================================================
			
			CellValue2(LastRow, PROP_NO) = propNo;
			CellValue2(LastRow, VER_SEQ) = verSeq;
			CellValue2(LastRow, GRP_SEQ) = "";
			//EFF DT, EXP DT 는 S/C Duration 을 default 로 설정한다.(2009-11-29)
			//CellValue2(LastRow, EFF_DT) = ComGetObjValue(formObj.sc_eff_dt);
			//CellValue2(LastRow, EXP_DT) = ComGetObjValue(formObj.sc_exp_dt);
			
			// Effective Date를 Current Date으로 Setting 2011.12.14  김현화
			CellValue2(LastRow, EFF_DT) = getTodate();
			CellValue2(LastRow, EXP_DT) = ComGetObjValue(formObj.sc_exp_dt);

			
			//Default 는 Y 컬럼 체크(2009-07-27)
			CellValue2(LastRow, FT_FLG) 		= "1";
			CellValue2(LastRow, PREV_FT_FLG) 	= "1";
			CellValue2(LastRow, ROW_EDIT_STS) 	= "Y";
			CellValue2(LastRow, CURR_CD)		= "";
			CellValue2(LastRow, RT_MANDATORY) 	= "N";
		}
		
		//Multi Coverage 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setMultiCoverageGrid();
		sheetCVRGObj.RemoveAll();
		
		//Tiered Free Time 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setTieredFreeTimeGrid();
		sheetFTObj.RemoveAll();
		
		//Rate Adjustment 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setRateAdjustmentGrid();
		sheetRTObj.RemoveAll();
		
		//Custmoer 그리드를 Clear 시킨다.
		setCustomerGrid();
		sheetCUSTObj.RemoveAll();

		//Commodity 그리드를 Clear 시킨다.
		setCommodityGrid();
		sheetCMDTObj.RemoveAll();
	}
			
	/*
	 * Multi Coverage 정보를 추가한다.
	 */		
	function addMultiCoverage() {
	    var formObj 		= document.form;
	    var sheetSCObj		= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		var cvrgSeq			= "";
		
		if (formObj.chkMultiCoverage.checked) {
			cvrgSeq = fetchColumnValueOfLastRow(sheetCVRGObj, CVRG_SEQ);
			cvrgSeq	= cvrgSeq  == "" ? 1 : ComParseInt(cvrgSeq)  + 1;
			
			//Multi Coverage 그리드에 Row 를 생성한다.
			with(sheetCVRGObj) {
				DataInsert(-1);
				
				CellValue2(LastRow, PROP_NO) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, PROP_NO);
				CellValue2(LastRow, VER_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, VER_SEQ);
				CellValue2(LastRow, GRP_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);
				CellValue2(LastRow, CVRG_SEQ)	= cvrgSeq;
			}
		}
	}
	
	/*
	 * Tiered Free Time 정보를 추가한다.
	 */		
	function addFreeTime() {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];
		var sheetFTObj 	= sheetObjects[2];
		var ftSeq		= "";
		var ftUpTo		= "";
		var ftFrom		= "";
		
		if (fetchRowCount(sheetFTObj) > 0) {
			if (fetchColumnValueOfLastRow(sheetFTObj, FT_UPTO) == "") {
				ComShowCodeMessage("DMT02002", "Up to");
				return;					
			} 
			else if (fetchColumnValueOfLastRow(sheetFTObj, FT_DAYS) == "") {
				ComShowCodeMessage("DMT02002", "Total");
				return;					
			}
		}

		if (formObj.chkFreeTime.checked) {
			ftSeq	= fetchColumnValueOfLastRow(sheetFTObj, FT_SEQ);
			ftUpTo	= fetchColumnValueOfLastRow(sheetFTObj, FT_UPTO);
			
			ftSeq	= ftSeq  == "" ? 1 : ComParseInt(ftSeq)  + 1;
			ftFrom	= ftUpTo == "" ? 1 : ComParseInt(ftUpTo) + 1;
			
			//Tiered Free Time 그리드에 Row 를 생성한다.
			with(sheetFTObj) {
				DataInsert(-1);
				
				CellValue2(LastRow, 	PROP_NO) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, PROP_NO);
				CellValue2(LastRow, 	VER_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, VER_SEQ);
				CellValue2(LastRow, 	GRP_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);				
				CellValue2(LastRow, 	FT_SEQ) 	= ftSeq;
				CellValue2(LastRow, 	FT_FROM) 	= ftFrom;
				CellEditable(LastRow, 	FT_FROM) 	= false;
			}
		}
	}
	
	/*
	 * Rate Adjustment 정보를 추가한다.
	 */		
	function addRateAdjustment() {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];
		var sheetRTObj	= sheetObjects[3];
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
			} // 2011.06.27 타입 추가
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
				
				CellValue2(LastRow, 	PROP_NO) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, PROP_NO);
				CellValue2(LastRow, 	VER_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, VER_SEQ);
				CellValue2(LastRow, 	GRP_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);					
				CellValue2(LastRow, 	RT_SEQ) 	= rtSeq;
				CellValue2(LastRow, 	RT_FROM) 	= rtFrom;
				CellEditable(LastRow, 	RT_FROM) 	= false;
			}
		}
	}
	
	/*
	 * Actual Customer 정보를 추가한다.
	 */		
	function addCustomer() {
		var sheetSCObj		= sheetObjects[0];
		var sheetCUSTObj	= sheetObjects[4];
				
		if (fetchRowCount(sheetCUSTObj) > 0 && fetchColumnValueOfLastRow(sheetCUSTObj, CUST_CD) == "") {
			ComShowCodeMessage("DMT02002", "Code");
			return;					
		}
		
		with(sheetCUSTObj) {
			DataInsert(-1);
			
			CellValue2(LastRow, 	PROP_NO) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, PROP_NO);
			CellValue2(LastRow, 	VER_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, VER_SEQ);
			CellValue2(LastRow, 	GRP_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);
		}
	}
	
	/*
	 * Commodity 정보를 추가한다.
	 */		
	function addCommodity() {
		var sheetSCObj		= sheetObjects[0];		 
		var sheetCMDTObj 	= sheetObjects[5];
		
		if (fetchRowCount(sheetCMDTObj) > 0 && fetchColumnValueOfLastRow(sheetCMDTObj, CMDT_CD) == "") {
			ComShowCodeMessage("DMT02002", "Code");
			return;					
		}
		
		with(sheetCMDTObj) {
			DataInsert(-1);
			
			CellValue2(LastRow, 	PROP_NO) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, PROP_NO);
			CellValue2(LastRow, 	VER_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, VER_SEQ);
			CellValue2(LastRow, 	GRP_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);
		}
	}		
	
    /**
	 * S/C Exception Tariff 의 하위 그리드내에 삭제되지 않은 마지막 Row 데이터의 지정된 Column 값을 반환하는 함수
	 */
	function fetchColumnValueOfLastRow(sheetObj, COL) {
		var lastColumnValue = "";
		
		with(sheetObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (RowStatus(row) != "D") {

					lastColumnValue = ComTrim(CellValue(row, COL));
					
					//Multi Coverage 에서 Rate Adjustment 가 필수항목일 경우 Country 값은 반드시 존재해야한다. 이때, 이 함수에서 Country 값을 읽어올때,
					//맨 마지막 행에 값이 없으면 그 상위 행에 값을 읽어오도록 처리함.(Multi Coverage 에서는 Row Add 시 빈 공란상태로 계속 추가가능하도록 구현되어 있기 때문에)
					if (COL != CVRG_CNT || lastColumnValue != "") break;
				}
			}
		}
		return lastColumnValue;
	}
	 
	/**
	 * Group 정보를 Copy 한다.
	 */		
	function copyGroup() {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];

 		//Copy 버튼 클릭시 데이터가 있는지 검사한다. ====================================================================================
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("DMT01117", "copy");
			return;
		}
		//==========================================================================================================================
			
		//1.Row Add 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구 ==========================
		var chkResult = isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				//변경된 내용만 조회해서 그리드에 설정.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
				if (!saveGroup(chkResult[0], true)) return;
			}
			else {
				//ComShowCodeMessage("DMT01115");
				return;
			}
		}
		//==========================================================================================================================
			
		with(sheetSCObj) {
			//===============================================================================================================
			//Row 를 복사하면 자동으로 복사된 행이 생성되고 포커스가 이동한다.
			//포커스가 이동되면서 sheet1_OnSelect 함수를 호출하게 되고, 거기에서 변경된 내용이 있는지 조회하는 모듈을 태운다.
			//바로, 위 프로세스를 막기 위해서 아래와 같이 전역변수에 플래그값을 변경한다.
			isCopySCExceptionTariff = true;
			var row = DataCopy();
			isCopySCExceptionTariff = false;
			//===============================================================================================================
			
			//복사한 Row 를 시스템에 반영하기 위해서 상태를 '입력' 으로 설정해준다.
			RowStatus(row) = "I";
			
			//저장시점에 Multi 구분이 'Single' 인 Coverage 데이터를 Multi Coverage Grid 로
			//이동시킬때 정상처리를 위해서 Previous Coverage Multi 를 Clear 한다.
			CellValue(row, CURR_CVRG_MULTI) = "";
			
			//Group Sequence 는 저장할 때 시스템쪽에서 자동으로 생성해서 입력해준다.
			CellValue(row, GRP_SEQ) = "";
		}

		//S/C Exception Tariff 의 해당 Group 의 하위항목들을 모두 복사해준다.
		for (var sheetNo = 1 ; sheetNo < sheetObjects.length ; sheetNo++) {
			with(sheetObjects[sheetNo]) {
				for (var row = HeaderRows ; row <= LastRow ; row++) {
					RowStatus(row) 			= "I";
					CellValue(row, GRP_SEQ) = "";
				}
			}
		}
	}
		
	/**
	 * Delete 버튼 클릭시 선택되어진 Group 정보를 삭제한다.
	 * 그룹정보 삭제시 그 하위의 모든 정보들도 함께 삭제된다.
	 */		
	function delGroup() {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}				
		//==========================================================================================================================
		
		with(sheetSCObj) {
			if (fetchRowCount(sheetSCObj) > 0) {

				//삭제될 정보의 Key 값을 임의 저장한다. 
				if (RowStatus(SelectRow) != 'I') {
					
					//S/C Exception Tariff Group 정보를 삭제할 것인지 확인한다.
					if (fetchRowCount(sheetSCObj) == 1) {
						if (!ComShowCodeConfirm("DMT01119")) return;
					}
					else if (fetchRowCount(sheetSCObj) > 1) {
						if (!ComShowCodeConfirm("DMT00135", "delete")) return;
					}
					
					ComSetObjValue(formObj.prop_no, 		CellValue(SelectRow, PROP_NO));
					ComSetObjValue(formObj.sc_expt_ver_seq, CellValue(SelectRow, VER_SEQ));
					ComSetObjValue(formObj.sc_expt_grp_seq, CellValue(SelectRow, GRP_SEQ));

					//삭제된 Row 를 DB에 반영시키는 Action 을 수행한다. ===============================================================
					doActionIBSheet(sheetSCObj, formObj, IBDELETE_SCTARIFF);
					//=============================================================================================================
					
					if (ComGetObjValue(formObj.result) != "Y") {
						ComShowCodeMessage("DMT00008", "save");
						return;
					}
				}
				
				//S/C Exception Tariff Group 정보를 삭제한다. ======================================================================
				//하위 항목들을 모두 삭제해 주고, 기본값으로 초기화 시킨다.
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				sheetObjects[5].RemoveAll();
				
				RowDelete(SelectRow, false);
				//=================================================================================================================
				
				if (fetchRowCount(sheetSCObj) > 0) {
					//자동 선택된 Group Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.)  
					setSubSCException(true);
				}
				else {
					//재조회를 수행한다.
					doActionRetrieve(IBSEARCH);
				}
			}
		}
	}

	/**
	 * SAVE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수(매개변수는 변경된 정보가 있는지 없는지 나타낸다.)
	 */				
	function saveGroup(isChangedSCTariff, isOnlyRetrieve) {
		var sheetSCObj	= sheetObjects[0];
		var formObj		= document.form;
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//==========================================================================================================================

 		//Save 버튼 클릭시 데이터가 있는지 검사한다. ====================================================================================
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("DMT01117", "save");
			return;
		}
		//==========================================================================================================================
		
		//S/C Tariff Exception 의 변경여부를 체크하지 않았다면 체크해준다. ==============================================================
		if (!isChangedSCTariff) {
			//chkResult => 0: 결과, 1: 발생된 Row, 2:입력,수정,삭제 구분, 3:에러메시지
			var chkResult = isChangedSCExceptionTariff();
			if (!chkResult[0]) {
				ComShowCodeMessage("DMT01113");
				return false;
			}
		}
		//===========================================================================================================================
		
		//입력하거나 수정하거나 삭제된 내용을 반영한다.
		if (validateForm()) {
			
			//S/C Exception Tariff 의 Coverage 가 Single 일 경우, 그 정보를 저장하기 위해서 Multi Coverage Grid 에 데이터를 복사한다. =======
			copyGroupCoverageforSave();
			//======================================================================================================================

			//Flag 정보를 세팅해준다. ================================================================================================
			setFlagValues();
			//======================================================================================================================

			//선택한 Customer Type 을 Customer Grid 에 매핑해준다. ====================================================================
			setCustomerType();
			//======================================================================================================================
			
			//Save 버튼 클릭시에는 무조건 'Temp.Save' 로 설정한다. =====================================================================
			ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, "T");
			//======================================================================================================================
			
			//추가, 수정, 삭제된 S/C Exception Tariff 를 DB 에 반영한다. ==============================================================
			doActionIBSheet(sheetSCObj, formObj, IBSAVE_SCTARIFF);
			//======================================================================================================================
			
			//저장을 위해서 Multi Coverage Grid 에 복사한 데이터를 삭제한다. ============================================================
			releaseGroupCoverageforSave();
			//======================================================================================================================
			
			//저장 Action 이 정상실행시 Alert 창을 띄워주고, 조회를 실행한다. ============================================================
			if (ComGetObjValue(formObj.result) == "Y") {
				ComShowCodeMessage("DMT00001");
				
				doActionRetrieve(IBSEARCH_SCTARIFF);
			}
			//======================================================================================================================
		}
		else {
			
			return false;
		}

		return true;
	}
		
    /**
     * S/C Exception Tariff 의 하위항목들에 대한 삭제를 수행하는 함수(전체, 선택항목 삭제)
     */	
	function delSubSCException(sheetObj, part) {
		
		with(sheetObj) {
			//S/C Exception Tariff 의 하위 항목의 그리드내에 있는 모든 데이터를 삭제한다.
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
			//S/C Exception Tariff 의 하위 항목의 그리드내에 있는 선택한 항목만을 삭제한다.
			else {
				// 선택된 행이 없을 경우 실행하지 않는다.
				if (SelectRow == -1) return;
				
				// Tiered Free Time 과 RateAdjustment 는 마지막행부터 삭제해야 합니다.
				if (id == "sheet3" || id == "sheet4") {
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
	 * S/C Exception Group 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableGroup(flag) {
		var sheetSCObj 	= sheetObjects[0];
		var tmpStatus	= "";
		
		with(sheetSCObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				//================================================================
				//아래 로직을 수행하는 동안 Row 의 상태가 자동으로 변경되는걸  
				//방지하기 위해서 그 이전 상태값을 임시저장했다가 설정 후 원복해준다.
				tmpStatus = sheetSCObj.RowStatus(row);
				//================================================================
				
				CellEditable(row, TARIFF) 		= flag;
				CellEditable(row, EFF_DT) 		= flag;
				CellEditable(row, EXP_DT) 		= flag;
				CellEditable(row, CNTRCGO) 		= flag;
				CellEditable(row, CVRG_MULTI) 	= flag;

				if (flag && CellValue(row, CVRG_MULTI) == "M") {
					CellEditable(row, CVRG_CNT) = false;
					CellEditable(row, CVRG_RGN) = false;
					CellEditable(row, CVRG_LOC) = false;
				} 
				else {
					CellEditable(row, CVRG_CNT) = flag;
					CellEditable(row, CVRG_RGN) = flag;
					CellEditable(row, CVRG_LOC) = flag;
				}

				CellEditable(row, FT_FLG) 		= flag;
				CellEditable(row, FT_TIR) 		= flag;

				if (flag && "M" == CellValue(row, FT_TIR)) {
					CellEditable(row, ADD_DYS) 	= false;
					CellEditable(row, TOT_DYS) 	= false;				
				}
				else {
					CellEditable(row, ADD_DYS) 	= flag;
					CellEditable(row, TOT_DYS) 	= flag;				
				}			

				CellEditable(row, SAT_FLG) 		= flag;
				CellEditable(row, SUN_FLG) 		= flag;
				CellEditable(row, HOL_FLG) 		= flag;
				CellEditable(row, ORGDST_CTI) 	= flag;
				CellEditable(row, ORGDST_CNT) 	= flag;
				CellEditable(row, ORGDST_RGN) 	= flag;
				CellEditable(row, ORGDST_LOC) 	= flag;

				//BKG DEL(I) or POR(O) 필드의 활성화 여부는 Tariff 필드의 입력값에 따라서 달라진다.
				if (flag) { 
					changeBKGDELorPOR(sheetSCObj, row); 
				}
				else { 
					CellEditable(row, BKGDEL_CNT) = false; 
					CellEditable(row, BKGDEL_RGN) = false;
					CellEditable(row, BKGDEL_LOC) = false;
				}
	
				//CY/Door 필드의 활성화 여부는 Tariff 필드의 입력값에 따라서 달라진다.
				if (flag) { 
					changeCYDoor(sheetSCObj, row); 
				}
				else { 
					CellEditable(row, CYDOOR) 	= false; 
				}
				CellEditable(row, REMARK) 		= flag;
				
				//각 ROW 의 Editable 한 상태값을 기억하기 위해서 저장함.
				sheetSCObj.CellValue(row, ROW_EDIT_STS)	= flag ? "Y" : "N";
				
				//한 Row 에 대한 설정이 완료된 후 Row 의 상태를 원복시킨다. =============
				sheetSCObj.RowStatus(row) = tmpStatus;
				//================================================================
			}
		}
		
		//Group 버튼을 주어진 플래그에 맞게 활성화 / 비활성화 시킨다.
	
		if (flag) {
			ComBtnEnable("btn_AddGroup");
			ComBtnEnable("btn_CopyGroup");
			ComBtnEnable("btn_DelGroup");
			ComBtnEnable("btn_SaveGroup");
			ComBtnEnable("btn_DownExcel");
			
		}
		else {
			ComBtnDisable("btn_AddGroup");
			ComBtnDisable("btn_CopyGroup");
			ComBtnDisable("btn_DelGroup");
			ComBtnDisable("btn_SaveGroup");
			ComBtnEnable("btn_DownExcel");
		}
	}

	/**
	 * S/C Exception MultiCoverage 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableMultiCoverage(flag) {
		var sheetCVRGObj = sheetObjects[1];
		
		with(sheetCVRGObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				CellEditable(row, CVRG_CNT) = flag;
				CellEditable(row, CVRG_RGN) = flag;
				CellEditable(row, CVRG_LOC) = flag;
			}
		}

		//Multi Coverage 버튼을 주어진 플래그에 맞게 활성화 / 비활성화 시킨다.
		if (flag) {
			ComBtnEnable("btn_AddMultiCoverage");
			ComBtnEnable("btn_DelMultiCoverage");
		}
		else {
			ComBtnDisable("btn_AddMultiCoverage");
			ComBtnDisable("btn_DelMultiCoverage");
		}
	}
	
	/**
	 * S/C Exception Tiered Free Time 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableTieredFreeTime(flag) {
		var sheetFTObj = sheetObjects[2];

		with(sheetFTObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				CellEditable(row, FT_FROM) = false;
				CellEditable(row, FT_UPTO) = flag;
				CellEditable(row, FT_DAYS) = flag;
			}
		}

		//Tiered Free Time 버튼을 주어진 플래그에 맞게 활성화 / 비활성화 시킨다.
		if (flag) {
			ComBtnEnable("btn_AddFreeTime");
			ComBtnEnable("btn_DelFreeTime");
		}
		else {
			ComBtnDisable("btn_AddFreeTime");
			ComBtnDisable("btn_DelFreeTime");
		}
	}
		
	/**
	 * S/C Exception Rate Adjustment 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableRateAdjustment(flag, isClicked) {
		var formObj		= document.form;
		var sheetRTObj 	= sheetObjects[3];

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
	 * S/C Exception Actual Customer 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableActualCustomer(flag) {
		var formObj			= document.form;
		var sheetCUSTObj 	= sheetObjects[4];
		
		//Customer Type 콤보박스 활성화 / 비활성화
		with(formObj) {
//			ComEnableManyObjects(flag, customerType);
			ComEnableManyObjects(false, customerType);

//			if (flag)
//				customerType.className	= "input";
//			else
				customerType.className	= "input2";
		}
		
		with(sheetCUSTObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				CellEditable(row, CUST_CD)	= flag;
			}
		}
		
		//Customer 버튼을 주어진 플래그에 맞게 활성화 / 비활성화 시킨다.
		if (flag) {
			ComBtnEnable("btn_AddCustomer");
			ComBtnEnable("btn_DelCustomer");
		}
		else {
			ComBtnDisable("btn_AddCustomer");
			ComBtnDisable("btn_DelCustomer");
		}		
	}
						
	/**
	 * S/C Exception Commodity 의 모든 정보를 주어진 플래그 상태로 설정해준다.
	 */		
	function editableCommodity(flag) {
		var sheetCMDTObj 	= sheetObjects[5];
		
		with(sheetCMDTObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				CellEditable(row, CMDT_CD) = flag;
			}
		}
		
		//Commodity 버튼을 주어진 플래그에 맞게 활성화 / 비활성화 시킨다.
		if (flag) {
			ComBtnEnable("btn_AddCommodity");
			ComBtnEnable("btn_DelCommodity");
		}
		else {
			ComBtnDisable("btn_AddCommodity");
			ComBtnDisable("btn_DelCommodity");
		}		
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
		//New Button
		initBtnNew();		
		//Update Button
		initBtnUpdate();
		//Request Button
		initBtnRequest();
		//Delete Button
		initBtnDelete();
		//Accept Button
		initBtnAccept();
		//Accept Cancel Button
		initBtnAcceptCancel();
	}

	/**
	 * 조건에 따라서 UPDATE 버튼의 상태가 변경된다.
	 */		
	function initBtnNew() {
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			ComBtnEnable("btn_New");
		} else {
			ComBtnDisable("btn_New");
		}		
	}
	
	/**
	 * 조건에 따라서 UPDATE 버튼의 상태가 변경된다.
	 */		
	function initBtnUpdate() {
		var formObj = document.form;
				
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var curver = ComTrim(ComGetObjText(formObj.version));
			var maxver = ComTrim(formObj.version.options[0].text);
			var status = getVerStatus("Code");
			
			//Version 이 최종 Version 이면서 Status 가 Requested 또는 Live 일 때만 활성화
			if (curver == maxver && (status == "R" || status == "L" || status == "D")) {
				ComBtnEnable("btn_Update");		
			} else {
				ComBtnDisable("btn_Update");
			}
		} else {
			//Status 가 공란 또는 Accepted 이거나, 상위 Version 이 생긴 경우 비활성화
			ComBtnDisable("btn_Update");
		}
	}
	
	/**
	 * 조건에 따라서 REQUEST 버튼의 상태가 변경된다.
	 */		
	function initBtnRequest() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var status = getVerStatus("Code");
			
			//S/C Proposal Creation 화면에서 열릴 때에 Status가 공란 또는 Temp. Saved이면 활성화
			if (status == "" || status == "T")
				ComBtnEnable("btn_Request");
			else
				ComBtnDisable("btn_Request");
				
		} else {		
			ComBtnDisable("btn_Request");
		}
	}	
	
	/**
	 * 조건에 따라서 DELETE 버튼의 상태가 변경된다.
	 */		
	function initBtnDelete() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var status = getVerStatus("Code");
			
			//Status 가  Requested
			if (status == "R" || status == "T")
				ComBtnEnable("btn_Delete");
			else
				ComBtnDisable("btn_Delete");
				
		} else {		
			//Status 가 공란 또는 Accepted 이거나, 상위 Version 이 생긴 경우 비활성화
			ComBtnDisable("btn_Delete");
		}
	}

	/**
	 * 조건에 따라서 ACCEPT 버튼의 상태가 변경된다.
	 * 이 함수는 페이지가 Load 될 때 와 조회 후 호출된다.
	 */		
	function initBtnAccept() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var status = getVerStatus("Code");
			
			//Status 가 Requested 일 때에 활성화
			if (status == "R") {
				//[11/13] 로직 추가 (로그인 점소가 Main과 Scope의 Approval Office인 User)(2009-11-30(월))
				if (ComGetObjValue(formObj.isAcceptAuth) == "Y") {
					ComBtnEnable("btn_Accept");
				}
				else {
					ComBtnDisable("btn_Accept");
				}
			}
			else {
				ComBtnDisable("btn_Accept");
			}
				
		} else {		
			//Status 가 공란 또는 Accepted 이거나, 상위 Version 이 생긴 경우 비활성화
			ComBtnDisable("btn_Accept");
		}
	}

	/**
	 * 조건에 따라서 ACCEPT CANCEL 버튼의 상태가 변경된다.
	 */		
	function initBtnAcceptCancel() {
		var formObj = document.form;
		
		//S/C No., Proposal No, Contract Party 가 존재하면 S/C Proposal Creation 화면에서 호출된 것으로써 조건에 따라 활성화.
		if (isProposalCreationScreen()) {
			var status = getVerStatus("Code");
			
			//해당 버튼 / 권한은 Pricing 담당자에게만 있음(SAOSC외 지역본부 이상)
			//버튼 권한은 S/C 시스템 승인권자와 동일
			//위 로직은 권한문제로 인해서 추후 구현해야 함.(2009-06-01)
			
			//Status 가 Accepted 일 때에 활성화
			if (status == "A") {
				//[11/13] 로직 추가 (로그인 점소가 Main과 Scope의 Approval Office인 User)(2009-11-30(월))
				if (ComGetObjValue(formObj.isAcceptAuth) == "Y") {
					ComBtnEnable("btn_AcceptCancel");
				}
				else {
					ComBtnDisable("btn_AcceptCancel");
				}
			}
			else {
				ComBtnDisable("btn_AcceptCancel");
			}
				
		} else {		
			//Status 가 공란 또는 Accepted 이거나, 상위 Version 이 생긴 경우 비활성화
			ComBtnDisable("btn_AcceptCancel");
		}
	}
	
	/**
	 * S/C EXCEPTION 에 등록된  데이터 조회하는 동작을 정의하는 함수
	 */		
	function doActionRetrieve(sAction) {
		var formObj 		= document.form;
		var sheetSCObj		= sheetObjects[0];

		//1.Proposal No. 에 대한 최상위 Version 정보를 조회한다.
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER);
		
		//2.최상위 Version 정보로 S/C Exception 정보를 조회한다.
		doActionRetrieveByVer(sAction);
		
	}
	 
	/**
	 * Version 정보가 변경될 경우 실행될 동작을 정의하는 함수
	 */		
	function doActionRetrieveByVer(sAction) {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];

		//1.조회전에 Status 필드를 초기화한다.
		ComSetObjValue(formObj.status, getVerStatus("Text"));
		
		//2.S/C별 DEM/DET 등록된 특별 계약 내용을 조회한다.
		doActionIBSheet(sheetSCObj, formObj, sAction);
		
		//--------------------------------------------------------------------
		currGrpSeq = sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);
		//--------------------------------------------------------------------
			
		//3.S/C Exception Tariff 의 조회결과가 있다면 현재 선택된 Group Seq. 의 하위항목을 조회한다.
		if (sheetSCObj.RowCount > 0) {
			
			if (getVerStatus("Code") == "T" && ComGetObjValue(formObj.isEditable) == "Y")
				//임시 저장 상태이고, 수정권한이 있을 경우 입력가능모드로 변경한다.(버튼 포함)
				editableGroup(true);
			
			else
				editableGroup(false);
			
			
			//선택한 Group Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
			setSubSCException(true);
			
		}
		else {
			if (ComGetObjValue(formObj.isEditable) == "Y")
				//조회된 결과가 없고 Version 이 1 이며, 수정권한이 있을 경우 입력가능모드로 변경한다.(버튼 포함)
				editableGroup(true);
			else
				editableGroup(false);
			
			//하위 그리드를 초기화 시킨다.
            sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			sheetObjects[5].RemoveAll();
			
			//하위 정보들을 초기화 시킨다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
			setSubSCException(false);
		}
		
		//4.메인 버튼의 상태를 주어진 조건에 따라서 활성화 or 비활성화 시킨다.
		initBtnControl();
		
		//5.쉬트 정렬의 활성화/비활성화 시킨다.
		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
			sheetSCObj.InitHeadMode(false, false, false, false, false, false);
		}
		else {
			sheetSCObj.InitHeadMode(true, false, false, false, false, false);	
		}
		
	 }

   /**
	* S/C Exception Tariff 목록중 선택한 Group Seq. 변경되었을 경우 하위 항목의 상태를 변경한다.
	*/	
    function setSubSCException(isRetrieve) {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		//Group Seq. 의 하위 항목을 조회한다.
		if (isRetrieve) {
			doActionIBSheet(sheetSCObj, formObj, IBSEARCH_SUB);
		}
		
		//1.선택된 Tariff 타입에 따라서 Multi Coverage 의 제목이 변경된다.(2009-07-28)
		setMultiCoverageTitle();

		//2.Multi Coverage 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setMultiCoverageGrid();
		
		//3.Tiered Free Time 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setTieredFreeTimeGrid();
		
		//4.Rate Adjustment 의 체크박스와 입력상태를 변경해준다.(버튼 포함)
		setRateAdjustmentGrid();
		
		//5.Customer 의   입력상태를 변경해준다.(버튼 포함)
		setCustomerGrid();
		
		//6.Commodity 의   입력상태를 변경해준다.(버튼 포함)
		setCommodityGrid();
    }

   /**
	* S/C Exception Tariff 의 Coverage 상태를 변경해주는 함수
	*/
	function setMultiCoverageGrid() {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		with(sheetSCObj) {
			//=================================================================================================================================
			//Coverage 의 Multi 타입이 Multi 일 경우에는 Multi Coverage 체크박스를 체크해준다.
			//=================================================================================================================================
			if (CellValue(SelectRow, CVRG_MULTI) == "M") {
				formObj.chkMultiCoverage.checked = true;
				
				//Group 그리드의 Coverage 컬럼을 모두 비활성화 시킨다.
				CellEditable(SelectRow, CVRG_CNT) 	= false;
				CellEditable(SelectRow, CVRG_RGN) 	= false;
				CellEditable(SelectRow, CVRG_LOC) 	= false;
				
				//Multi Coverage 그리드의 모든 컬럼을 수정가능한 상태일 경우 모두 활성화 시키고, 그렇지 않을 경우 모두 비활성화 시킨다.
				if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
					editableMultiCoverage(true);
				}
				else {
					editableMultiCoverage(false);
				}
			}
			else {
				formObj.chkMultiCoverage.checked = false;
	
				//Group 그리드의 Coverage 컬럼을 수정가능한 상태일 경우 모두 활성화 시키고, 그렇지 않을 경우 모두 비활성화 시킨다.
				if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
					CellEditable(SelectRow, CVRG_CNT) 	= true;
					CellEditable(SelectRow, CVRG_RGN) 	= true;
					CellEditable(SelectRow, CVRG_LOC) 	= true;
				}
				else {
					CellEditable(SelectRow, CVRG_CNT) 	= false;
					CellEditable(SelectRow, CVRG_RGN) 	= false;
					CellEditable(SelectRow, CVRG_LOC) 	= false;
				}
				
				//Multi Coverage 그리드의 모든 컬럼을 비활성화 시킨다.
				editableMultiCoverage(false);	
			}
		}
	}
	
   /**
	* S/C Exception Tariff 의 Free Time 상태를 변경해주는 함수
	*/
	function setTieredFreeTimeGrid() {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		with(sheetSCObj) {
			//=================================================================================================================================
			//Free Time 의 Tier 타입이 Multi 일 경우에는 Tiered Free Time 체크박스를 체크해준다.
			//=================================================================================================================================
			if (CellValue(SelectRow, FT_TIR) == "M") {
				formObj.chkFreeTime.checked = true;

				//Group 그리드의 Free Time 컬럼의 일부를 비활성화 시킨다.
				CellEditable(SelectRow, ADD_DYS) 	= false;
				CellEditable(SelectRow, TOT_DYS) 	= false;
				
				//Tiered Free Time 그리드의 모든 컬럼을 수정가능한 상태일 경우 모두 활성화 시키고, 그렇지 않을 경우 모두 비활성화 시킨다.
				if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
					CellEditable(SelectRow, FT_FLG) 	= true;
					CellEditable(SelectRow, FT_TIR) 	= true;
					
					editableTieredFreeTime(true);
				}
				else {
					CellEditable(SelectRow, FT_FLG) 	= false;
					CellEditable(SelectRow, FT_TIR) 	= false;
					
					editableTieredFreeTime(false);
				}				
			}
			else if (CellValue(SelectRow, FT_TIR) == "S") {
				formObj.chkFreeTime.checked = false;
				
				//Group 그리드의 Free Time 컬럼을 수정가능한 상태일 경우 모두 활성화 시키고, 그렇지 않을 경우 모두 비활성화 시킨다.
				if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
					CellEditable(SelectRow, FT_FLG) 	= true;
					CellEditable(SelectRow, FT_TIR) 	= true;
					CellEditable(SelectRow, ADD_DYS) 	= true;
					CellEditable(SelectRow, TOT_DYS) 	= true;
				}
				else {
					CellEditable(SelectRow, FT_FLG) 	= false;
					CellEditable(SelectRow, FT_TIR) 	= false;
					CellEditable(SelectRow, ADD_DYS) 	= false;
					CellEditable(SelectRow, TOT_DYS) 	= false;
				}
				
				//Tiered Free Time 그리드의 모든 컬럼을 비활성화 시킨다.
				editableTieredFreeTime(false);				
			}
			//Free Time 의 Y 컬럼 체크해제할 경우 호출됨
			else if (CellValue(SelectRow, FT_TIR) == "") {
				formObj.chkFreeTime.checked = false;
				
				if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
					CellEditable(SelectRow, FT_FLG) 	= true;
				}
				else {
					CellEditable(SelectRow, FT_FLG) 	= false;
				}
				CellEditable(SelectRow, FT_TIR) 	= false;
				CellEditable(SelectRow, ADD_DYS) 	= false;
				CellEditable(SelectRow, TOT_DYS) 	= false;
				
				//Tiered Free Time 그리드의 모든 컬럼을 비활성화 시킨다.
				editableTieredFreeTime(false);	
			}
		}
	}
	
   /**
	* S/C Exception Tariff 의 Rate Adjustment 상태를 변경해주는 함수
	*/
	function setRateAdjustmentGrid() {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		with(sheetSCObj) {		
			//=================================================================================================================================
			//4.Rate Adjustment 의 체크박스를 체크해준다.
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

			//S/C Exception Tariff 에 등록된 Currency 가 있을 경우에는 조회한 Currency 목록에서 선택해준다.
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
	* S/C Exception Tariff 의 Customer 상태를 변경해주는 함수
	*/
	function setCustomerGrid() {
		var sheetSCObj 	= sheetObjects[0];
		
		with(sheetSCObj) {
			if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
				editableActualCustomer(true);
			}
			else {
				editableActualCustomer(false);
			}
		}
	}
	
   /**
	* S/C Exception Tariff 의 Commodity 상태를 변경해주는 함수
	*/
	function setCommodityGrid() {
		var sheetSCObj 	= sheetObjects[0];
		
		with(sheetSCObj) {
			if (CellValue(SelectRow, ROW_EDIT_STS) == "Y") {
				editableCommodity(true);
			}
			else {
				editableCommodity(false);
			}
		}
	}	
	
	/**
	 * NEW 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionNew() {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
				
		//Version 비활성화시 활성화시켜준다.(2009-11-13(금))
		with(formObj) {
			ComEnableManyObjects(true, version);
			version.className = "input";
		}
	
		//New 버튼 클릭시 화면 Load 시와 동일하게 동작한다.
		doActionRetrieve(IBSEARCH);
	}

	/**
	 * UPDATE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionUpdate() {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}
		//==========================================================================================================================
		if (getVerStatus("Code") == "R") {
			if (!ComShowCodeConfirm("DMT00133")) { return; }
			
			//STS 컬럼을 공란으로 변경한다.
			ComClearObject(formObj.status);	
			
			//메인 메뉴버튼의 상태를 활성화 / 비활성화 시킨다.
			ComBtnDisable(	"btn_Update"		);
			ComBtnEnable(	"btn_Request"		);
			ComBtnDisable(	"btn_Delete"		);
			ComBtnDisable(	"btn_Accept"		);
			ComBtnDisable(	"btn_AcceptCancel"	);				
		}
		else if (getVerStatus("Code") == "L" || getVerStatus("Code") == "D") {
			
			if (!ComShowCodeConfirm("DMT01114", ComGetObjText(formObj.version))) { return; }
			
			//현재 버전의  S/C Exception Tariff 정보를 신규 버전에 저장을 한다.
			doActionIBSheet(sheetSCObj, formObj, IBSAVE_SCTARIFF_UPDATE);
			
			if (ComGetObjValue(formObj.result) == "Y") {
				//신규 버전의  S/C Exception Tariff 를 조회한다.
				doActionRetrieve(IBSEARCH);
			}
			else {
				ComShowCodeMessage("DMT00008", "update");
				return;
			}
		}
		
		//Update버튼 클릭시 Version 을 변경하지 못하도록 비활성화(2009-11-13(금))
		with(formObj) {
			ComEnableManyObjects(false, version);
			version.className = "input2";
		}

		//S/C Exception Tariff 의 모든 컬럼들을 입력가능하도록 활성화 시킨다.
		editableGroup(true);
		
		//선택한 Group Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
		setSubSCException(false);
		
		//쉬트 정렬의 활성화/비활성화 시킨다.
		if (ComGetObjValue(formObj.status) == "" || ComGetObjValue(formObj.status) == "Temp. Saved") {
			sheetSCObj.InitHeadMode(false, false, false, false, false, false);
		}
		else {
			sheetSCObj.InitHeadMode(true, false, false, false, false, false);	
		}		
	}			

	/**
	 * REQUEST 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionRequest() {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}				
		//==========================================================================================================================

		//1.Request 버튼 클릭시 데이터가 있는지 검사한다.
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("DMT01117", "request");
			return;
		}
		
		//2.Request 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구
		var chkResult = isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT01112", "save")) {
				//변경된 내용에 대한 SAVE 수행 후 변경된 내용만 조회해서 그리드에 설정.(그리드 입력가능/입력불가능 상태처리는 하지 않음)
				if (!saveGroup(chkResult[0], true)) return;	
			}
		}
		
		//3.Request 상태로 변경하기 위해 매개변수를 알맞게 설정해준다.
		ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"R");
		
		//4.Version 상태를 갱신하고 그 이력정보를 남긴다.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		
		//5.Request 가 정상적으로 완료되었으면 조회를 수행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			
			doActionRetrieve(IBSEARCH);
			
			//하단 Request, Delete하고 난 다음에는 최종 Version이 조회되는데, 이때 Version 컬럼을 활성화해주세요.
			with(formObj) {
				ComEnableObject(version, true);
				version.className 		= "input";
			}	
		}
	}
		
	/**
	 * DELETE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionDelete() {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}				
		
		if (ComShowCodeConfirm("DMT02007")) {
			
			doActionIBSheet(sheetSCObj, formObj, IBDELETE);
			
			//저장 Action 이 정상실행시 조회를 실행한다.
			if (ComGetObjValue(formObj.result) == "Y") {
				
				ComShowCodeMessage("DMT01116", "deleted");

				doActionRetrieve(IBSEARCH);
				
				//하단 Request, Delete하고 난 다음에는 최종 Version이 조회되는데, 이때 Version 컬럼을 활성화해주세요.
				with(formObj) {
					ComEnableObject(version, true);
					version.className 		= "input";
				}				
			}

		}
	}	

	/**
	 * ACCEPT 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionAccept() {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","New");//Version status has changed. Pls click New button
			return;
		}				
		//==========================================================================================================================
		
		//Accept 하기 전에 확인하고 처리하도록 변경(2009-08-03)
		if (!ComShowCodeConfirm("DMT00135", "Accept")) { return; }
		
		//S/C 가 Filed STS 인지를 조회한다.
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_FILED);
		//결과를 받는다.
		var result = ComGetObjValue(formObj.result);

		//1.Accept 버튼 클릭시 해당 S/C 가 Filed STS 가 아닐 경우 Status 를 Accepted 로 변경
		if (result == "N") {
			ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"A");
		}
		//2.Accept 버튼 클릭시 해당 S/C 가 Filed STS 일 경우 Status 를 Live 로 변경
		else {
			ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"L");
		}

		//3.Version 상태를 갱신하고 그 이력정보를 남긴다.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		
		//4.Accept 가 정상적으로 완료되었으면 조회를 수행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			doActionRetrieve(IBSEARCH);
		}
	}
	
	/**
	 * ACCEPT CANCEL 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionAcceptCancel() {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.=================================================================
		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_VER_CHECK);
		
		var dis_status = getVerStatus("Code");
		var max_status= ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);
		
		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148");//Version status has changed. Pls click New button
			return;
		}				
		//==========================================================================================================================
		
		//Accept 하기 전에 확인하고 처리하도록 변경(2009-08-03)
		if (!ComShowCodeConfirm("DMT00135", "cancel acceptance")) { return; }
		
		//1.Accept Cancel 버튼 클릭시 Status 를 "Requested" 로 변경한다.
		ComSetObjValue(formObj.dmdt_expt_ver_sts_cd, 	"R");
		
		//2.Version 의 상태를 갱신하고 그 이력정보를 남긴다.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_VERSTS);
		
		//3.Accept Cancel 이 정상적으로 완료되었으면 조회를 수행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			doActionRetrieve(IBSEARCH);
		}
	}
	
	/**
	 * CLOSE 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionClose() {
		var formObj = document.form;
		
		//1.Close 버튼 클릭시 Save가 되지 않은 줄이 있으면 “Data was changed. Do you want to save?” Alert 문구
		var chkResult = isChangedSCExceptionTariff();
		if (chkResult[0]) {
			if (ComShowCodeConfirm("DMT00147")) {
				self.close();
			}
			return;
		}
		
		self.close();
	}	
	
	 /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */	 
	function validateForm() {
    	var formObj 		= document.form;
		var sheetSCObj 		= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		var sheetFTObj		= sheetObjects[2];
		var sheetRTObj		= sheetObjects[3];
		
		//저장할 데이터가 없을 경우
		if (fetchRowCount(sheetSCObj) == 0) {
			ComShowCodeMessage("DMT00128");
			return false;
		}
		
		//건 단위로 추가, 수정이 발생하기 때문에 건 단위 처리만 하면 됨.
		with(sheetSCObj) {
			
			//생성,수정,삭제된 정보가 있는지 검색한다.
			var chkResult = isChangedSCExceptionTariff(1); //파라미터로 전달되는 1은 Sheet Index No. 이다.
	
			if (RowStatus(SelectRow) == "I" || RowStatus(SelectRow) == "U" || chkResult[0]) {

				//==================================================================================================
				//1-1.EFF DT Check
				//==================================================================================================
				if (CellValue(SelectRow, EFF_DT) == "") {
					ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "EFF DT");
					return false;
				}

				//==================================================================================================
				//1-2.EXP DT Check
				//==================================================================================================
				if (CellValue(SelectRow, EXP_DT) == "") {
					ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "EXP DT");
					return false;
				}

				//==================================================================================================
				//2.EXP DT 는 EFF DT 와 같거나 큰 날짜가 들어가도록 함
				//==================================================================================================
				if (ComGetDaysBetween(CellValue(SelectRow, EXP_DT), CellValue(SelectRow, EFF_DT)) > 0) {
	    			ComShowCodeMessage("COM12133", "'EFF DT'", "'EXP DT'", "earlier");
	    			return false;	    			
	    		}
				
				//==================================================================================================
				//3.Coverage Check
				//==================================================================================================
				//3-1.Single Coverage 에서 CN 는 필수항목이다.
				if (CellValue(SelectRow, CVRG_MULTI) == "S") {
					if (ComTrim(CellValue(SelectRow, CVRG_CNT)) == "") {
						ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "Coverage CN");
						return false;						
					}
					
					//Coverage 와 Origin(I) or Dest(O) 의 CN 이 같을 경우 에러처리..(2010-03-31)
					if (CellValue(SelectRow, CVRG_CNT) == CellValue(SelectRow, ORGDST_CNT)) {
						ComShowCodeMessage("DMT01144", CellValue(SelectRow, TARIFF).substring(2, 3) == "I" ? "Origin" : "Destination");
						return false;
					}
				}
				//3-2.Multi Coverage Data Count Check(최소 2개 이상이어야 함)
				else if (CellValue(SelectRow, CVRG_MULTI) == "M") {
					for (var row = sheetCVRGObj.HeaderRows ; row <= sheetCVRGObj.LastRow ; row++) {
						if (sheetCVRGObj.CellValue(row, CVRG_CNT) == "") {
							ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "Country");
							return false;
						}
						
						//Coverage 와 Origin(I) or Dest(O) 의 CN 이 같을 경우 에러처리..(2010-03-31)
						if (sheetCVRGObj.CellValue(row, CVRG_CNT) == CellValue(SelectRow, ORGDST_CNT)) {
							ComShowCodeMessage("DMT01144", CellValue(SelectRow, TARIFF).substring(2, 3) == "I" ? "Origin" : "Destination");
							return false;
						}						
					}
					
					if (fetchRowCount(sheetCVRGObj) < 2) {
						ComShowCodeMessage("DMT00115", CellValue(SelectRow, "Seq"), "Multi Coverage");
						return false;
					}
				} 

				//==================================================================================================
				//4.Free Time Validation Check
				//  (Y 컬럼 체크시 Tier, Add, Total, F/Time EXCL 컬럼 활성화)
				//==================================================================================================
				if (CellValue(SelectRow, FT_FLG) == 1) {
					//4-1.Free Time 이 'Single' 일 경우 Free Time 내에 Add Day 와 Total 이 둘다 있을 경우 에러처리
					if (CellValue(SelectRow, FT_TIR) == "S") {
						if (CellValue(SelectRow, ADD_DYS) != "" && CellValue(SelectRow, TOT_DYS) != "") {
							ComShowCodeMessage("DMT02004", CellValue(SelectRow, "Seq"));
							return false;
						} 
						else if (CellValue(SelectRow, ADD_DYS) == "" && CellValue(SelectRow, TOT_DYS) == "") {
							ComShowCodeMessage("DMT00108", CellValue(SelectRow, "Seq"), "Free Time");
							return false;						
						}
					}
					//4-2.Free Time 이  'Multi' 일 경우Tiered Free Time 에서 마지막 Row 의  Up to 컬럼은 공란이어야 하며, 공란이 아닐경우 에러처리
					else if (CellValue(SelectRow, FT_TIR) == "M") {
						if (!validateTieredFreeTime(SelectRow)) {
							return false; 
						}
						else if (fetchRowCount(sheetFTObj) < 2) {
							ComShowCodeMessage("DMT00115", CellValue(SelectRow, "Seq"), "Tiered Free Time");
							return false;
						} 
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
				//5.Dual Type 일 경우에는 Free Time 의 Total 컬럼값은 필수이다. 
				//  Free Time 이 Multi 일 경우에는 위 Free Time Validation Check 에서 모두 걸러주기 때문에
				//  아래는 Single or 미선택시 Total 값 입력여부에 대한 체크만 하면 된다.
				//==================================================================================================
				if (CellValue(SelectRow, RT_MANDATORY) == "Y" && CellValue(SelectRow, FT_TIR) != "M") {
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
				//6.Rate Adjustment Validation Check(마지막 Row 의 Up to 컬럼은 공란이어야 하며, 아닐경우 에러처리)
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
				//7.Calculation Type Check
				//==================================================================================================
				if (!validateCalculationType(SelectRow))
					return false;

				if (!validateCalculationTypeInDM(SelectRow))
					return false;

				//==================================================================================================
				//8.Actual Customer 데이터 중복체크
				//==================================================================================================
				if (!validateActualCustomer(SelectRow)) 
					return false;

				//==================================================================================================
				//9. Commodity 데이터 중복체크
				//==================================================================================================
				if (!validateCommodity(SelectRow))
					return false;
			}
		}

		if (dupValidate()) return false;	//중복데이터 체크 로직 추가(2009-07-28)
		
		return true;
	}
     
  	/**
  	 * S/C Exception Tariff 의 화면입력에 대한 기등록된 데이터에서 중복여부를 체크하는 함수
  	 */	     
     function dupValidate() {
  		var formObj			= document.form;
  		var sheetSCObj		= sheetObjects[0];
  		var sheetCVRGObj 	= sheetObjects[1];
  		var sheetCUSTObj	= sheetObjects[4];
  		var sheetCMDTObj	= sheetObjects[5];
    	
  		//중복여부 조회를 위해서 필요한 매개변수를 설정해준다.
  		
  		var coverageList = "";
  		if (sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_MULTI) == "S") {
  			with(sheetSCObj) {
  				
  				coverageList	+= convertEmptyToSpace(CellValue(SelectRow, CVRG_CNT));
	  			coverageList  	+= ", ";
	  			
	  			if (CellValue(SelectRow, CVRG_CNT) == "CA" || CellValue(SelectRow, CVRG_CNT) == "US") {
	  				coverageList  	+= "' '";
		  			coverageList  	+= ", ";
	  				coverageList  	+= convertEmptyToSpace(CellValue(SelectRow, CVRG_RGN));
	  			}
	  			else {
	  				coverageList  	+= convertEmptyToSpace(CellValue(SelectRow, CVRG_RGN));
		  			coverageList  	+= ", ";
	  				coverageList  	+= "' '";
	  			}
	  			
  		  		coverageList	+= ", ";	  			
	  			coverageList  	+= convertEmptyToSpace(CellValue(SelectRow, CVRG_LOC));
  			}
  		}
  		else {
  			with(sheetCVRGObj) {
  				for (var row = HeaderRows ; row <= LastRow ; row++) {
  					if (RowStatus(row) == "D") continue;
  					
  		  			coverageList 	+= convertEmptyToSpace(CellValue(row, CVRG_CNT));
  		  			coverageList	+= ", ";
  		  			
	  		  		if (CellValue(row, CVRG_CNT) == "CA" || CellValue(row, CVRG_CNT) == "US") {
		  				coverageList  	+= "' '";
			  			coverageList  	+= ", ";
		  				coverageList  	+= convertEmptyToSpace(CellValue(row, CVRG_RGN));
	  		  		}
	  		  		else {
		  				coverageList  	+= convertEmptyToSpace(CellValue(row, CVRG_RGN));
			  			coverageList  	+= ", ";
		  				coverageList  	+= "' '";
	  		  		}

  		  			coverageList	+= ", ";  		  			
  		  			coverageList	+= convertEmptyToSpace(CellValue(row, CVRG_LOC));
  		  			
  		  			if (row < LastRow) coverageList	+= "|";
  				}
  			}
  		}
  		
  		var actCustList = "";
  		with(sheetCUSTObj) {
  			for (var row = HeaderRows ; row <= LastRow ; row++) {
  				if (RowStatus(row) == "D") continue;
  				
  				actCustList		+= "'" + CellValue(row, CUST_CD).substring(0, 2) + "'";
  				actCustList		+= ", ";
  				actCustList		+= "'" + CellValue(row, CUST_CD).substring(2) + "'";
  				
  				if (row < LastRow) actCustList	+= "|";
  			}
  		}
  		
  		var cmdtList	= "";
  		with(sheetCMDTObj) {
  			for (var row = HeaderRows ; row <= LastRow ; row++) {
  				if (RowStatus(row) == "D") continue;
  				
  				cmdtList		+= CellValue(row, CMDT_CD);
  				
  				if (row < LastRow) cmdtList	+= "|";
  			}
  		}
  		
  		ComSetObjValue(formObj.coverage_list, 	coverageList);
  		ComSetObjValue(formObj.act_cust_list, 	actCustList);
  		ComSetObjValue(formObj.cmdt_list, 		cmdtList);
  		
    	//중복여부를 체크한다.
    	doActionIBSheet(sheetSCObj, formObj, IBSEARCH_CHECK_DUP);
    	
    	if (ComGetObjValue(formObj.result) == "Y") {
    		ComShowCodeMessage("DMT00138", sheetSCObj.CellValue(sheetSCObj.SelectRow, "Seq"));
    		return true;
    	}
    	
      	return false;
	}


 	/**
	 * Calculation Type 확인(모든 Tariff 와 Coverage 에 대해서 수행) 
	 */		
	function validateCalculationType(selectedRow) {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];
		var sheetRTObj	= sheetObjects[3];
		
		var custCd 		= ComTrim(ComGetObjValue(formObj.custCd));
		var tariff 		= sheetSCObj.CellValue(selectedRow, TARIFF);
		var params 		= "";
		if (sheetSCObj.CellValue(selectedRow, CVRG_MULTI) == "S") {
			params = 				changeNullToSpace(sheetSCObj.CellValue(selectedRow, CVRG_CNT));
			params = params + "=" + changeNullToSpace(sheetSCObj.CellValue(selectedRow, CVRG_RGN));
			params = params + "=" + changeNullToSpace(sheetSCObj.CellValue(selectedRow, CVRG_LOC));
		}
		else {
			params = getMultiCoverageData();
		}
		params += "|";
		params += tariff;
		params += "|";
		params += sheetSCObj.CellValue(selectedRow, EFF_DT);
		params += "|";
		params += sheetSCObj.CellValue(selectedRow, EXP_DT);
		params += "|";
		params += sheetSCObj.CellValue(selectedRow, CNTRCGO);
		params += "|";

		if (custCd.length > 2) {
			params += custCd.substring(0,2);
			params += ComTrim(ComGetObjValue(formObj.custSeq));
		}
		
		//1.Calculation Type Check 실행을 위한 파라미터 설정
		ComSetObjValue(formObj.chk_calc_tp_in, params);
		
		//2.Calculation Type Check 실행
		if (tariff.indexOf("CT") != -1) {
			doActionIBSheet(sheetSCObj, formObj, IBSEARCH_DUAL);
		}
		else {
			//2-1.DMIF, DMOF 의 경우 BKG DEL(I) or POR(O) 입력시 해당지역의 Calculation Type이
			//    Combined 일 경우에 대한 로직을 안 태우기 위해서 설정해줘야 함.			
			ComSetObjValue(formObj.chk_calc_tp_combined, "N");
			doActionIBSheet(sheetSCObj, formObj, IBSEARCH_CALC);
		}

		//3.실행결과 추출
		var result = ComGetObjValue(formObj.result);
		//result(E: Error, M: Mandatory, O:Option)

		//3-1.결과가 Y 일 경우 (입력된 Coverage 의 Tariff Type 의 Calculation Type 이 맞을 경우)
		if (result == "M") {
			if (tariff.indexOf("CT") != -1) {
				//Free Time 은 Total Day 만 입력 가능함.
				if (ComTrim(sheetSCObj.CellValue(selectedRow, ADD_DYS)).length > 0) {
					ComShowCodeMessage("DMT00113", sheetSCObj.CellValue(selectedRow, "Seq"));
					return false; 					
				}
				//Rate Adjustment 는 필수 입력임.
				if (fetchRowCount(sheetRTObj) < 1) {
					ComShowCodeMessage("DMT00114", sheetSCObj.CellValue(selectedRow, "Seq"));
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
			ComShowCodeMessage(errMsgId, sheetSCObj.CellValue(selectedRow, "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + locCd + " ]");				
			return false;					
		}

		return true;
	}
	
	/*
	 * Calculation Type 확인(DMIF, DMOF 의 경우 BKG DEL(I) or POR(O)이 입력되었을 경우 실행) 
	 */		
	function validateCalculationTypeInDM(selectedRow) {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		var custCd 		= ComTrim(ComGetObjValue(formObj.custCd));
		var tariff 		= sheetSCObj.CellValue(selectedRow, TARIFF);
		var params 		= "";
		
		if (tariff.indexOf("DM") != -1) {
			if (ComTrim(sheetSCObj.CellValue(selectedRow, BKGDEL_CNT)) != "") {
				params = 				changeNullToSpace(sheetSCObj.CellValue(selectedRow, BKGDEL_CNT));
				params = params + "=" + changeNullToSpace(sheetSCObj.CellValue(selectedRow, BKGDEL_RGN));
				params = params + "=" + changeNullToSpace(sheetSCObj.CellValue(selectedRow, BKGDEL_LOC));
				params += "|";
				params += tariff;
				params += "|";
				params += sheetSCObj.CellValue(selectedRow, EFF_DT);
				params += "|";
				params += sheetSCObj.CellValue(selectedRow, EXP_DT);
				params += "|";
				params += sheetSCObj.CellValue(selectedRow, CNTRCGO);
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
				doActionIBSheet(sheetSCObj, formObj, IBSEARCH_CALC);
				
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
								
					ComShowCodeMessage("DMT00132", sheetSCObj.CellValue(selectedRow, "Seq"), "[ " + cntCd + " ][ " + rgnCd + " ][ " + locCd + " ]");				
					return false;				
				}			
			}
		}
		return true;		
	}
	
	/**
	 * Tiered Free Time Sheet 에 있는 항목에 대해서 Validation 을 체크한다.
	 */			
	function validateTieredFreeTime(selectedRow) {
		var sheetSCObj	= sheetObjects[0];
		var sheetFTObj	= sheetObjects[2];
		
		//마지막 Row 일 경우 CNTR QTY 의 From, Total 은 필수 입력, Up to 은 Empty 이어야 함.
		if (isEmptyColumnOfLastRow(sheetFTObj, FT_FROM)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "From");
			return false;
		}
		else if (!isEmptyColumnOfLastRow(sheetFTObj, FT_UPTO)) {
			ComShowCodeMessage("DMT02005", sheetSCObj.CellValue(selectedRow, "Seq"));
			return false;
		}
		else if (isEmptyColumnOfLastRow(sheetFTObj, FT_DAYS)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "Total");
			return false;
		}
		
		//Up to 는 From와 같거나 큰 숫자가 들어가도록 함
		with(sheetFTObj) {
			for (var row = HeaderRows ; row < LastRow ; row++) {
				if (RowStatus(row) != "D") {
					if (ComParseInt(CellValue(row, FT_FROM)) > ComParseInt(CellValue(row, FT_UPTO))) {
						ComShowCodeMessage("DMT01032", "[Tiered Free Time]");
						CellValue2(row, FT_UPTO) = "";
						return false;
					}
				}
			}
		}

		return true;		
	}
	
	/**
	 * Rate Adjustment Sheet 에 있는 항목에 대해서 Validation 을 체크한다.
	 */			
	function validateRateAdjustment(selectedRow) {
		var sheetSCObj	= sheetObjects[0];
		var sheetRTObj	= sheetObjects[3];
		
		//마지막 Row 일 경우 Over Day 의 From 은 필수입력 Up to 은 Empty 이어야 함.
		//또한, Pate per Day 의 20FT, 40FT, H/C, 45FT 는 필수입력
		if (isEmptyColumnOfLastRow(sheetRTObj, RT_FROM)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "From");
			return false;
		}
		else if (!isEmptyColumnOfLastRow(sheetRTObj, RT_UPTO)) {
			ComShowCodeMessage("DMT02006", sheetSCObj.CellValue(selectedRow, "Seq"));
			return false;
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_20FT)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "20FT");
			return false;
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_40FT)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "40FT");
			return false;			
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_HC)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "H/C");
			return false;			
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_45FT)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "45FT");
			return false;			
		}
		else if (isEmptyColumnOfLastRow(sheetRTObj, RT_R9)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "R9");
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
	 * Actual Customer 에는 중복된 코드값이 있어서는 안된다.
	 */			
	function validateActualCustomer(selectedRow) {
		var sheetSCObj		= sheetObjects[0];
		var sheetCUSTObj	= sheetObjects[4];
		
		//필수입력 체크
		if (isEmptyColumnOfLastRow(sheetCUSTObj, CUST_CD)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "Customer Code");
			return false;			
		}
				
		//중복체크
		var dupRows = sheetCUSTObj.ColValueDupRows(GRP_SEQ + "|" + CUST_CD, false, true);
		if (dupRows != "") {
			ComShowCodeMessage("DMT00138", sheetSCObj.CellValue(selectedRow, "Seq"), "Actual Customer");
			return false;
		}
		return true;
	}	
	
	/**
	 * Commodity 에는 중복된 코드값이 있어서는 안된다.
	 */
	function validateCommodity(selectedRow) {
        var sheetSCObj 		= sheetObjects[0];
		var sheetCMDTObj 	= sheetObjects[5];
		
		//필수입력 체크
		if (isEmptyColumnOfLastRow(sheetCMDTObj, CMDT_CD)) {
			ComShowCodeMessage("DMT00108", sheetSCObj.CellValue(selectedRow, "Seq"), "Commodity Code");
			return false;			
		}	

		//중복체크			
		var dupRows = sheetCMDTObj.ColValueDupRows(GRP_SEQ + "|" + CMDT_CD, false, true);
		if (dupRows != "") {
			ComShowCodeMessage("DMT00138", sheetSCObj.CellValue(selectedRow, "Seq"), "Commodity");
			return false;
		}
		return true;
	}
		
	/**
	 * Group Sheet 에 선택된 Row 에 해당되는 Multi Coverage Code 값을 일련의 스트링으로 반환한다.
	 */
	function getMultiCoverageData() {
		var sheetSCObj 		= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		var cvrgData 		= "";

		with(sheetCVRGObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				//삭제된 데이터에 대해서는 처리하지 않는다.		
				if (RowStatus(row) != "D") {
					cvrgData = cvrgData 		+ changeNullToSpace(CellValue(row, CVRG_CNT));
					cvrgData = cvrgData + "=" 	+ changeNullToSpace(CellValue(row, CVRG_RGN));
					cvrgData = cvrgData + "=" 	+ changeNullToSpace(CellValue(row, CVRG_LOC));
					if (row < LastRow) { cvrgData += "^"; }
				}
			}
		}
		return cvrgData;
	}
			
	/**
	 * Coverage CN 정보를 찾아서 반환한다.
	 */	 
	 function getCoverageCNData(selectRow) {
		var sheetObj = sheetObjects[0];
		 
		if (ComTrim(sheetObj.CellValue(selectRow, CVRG_MULTI)) == "M") {
			return getMultiCoverageFirstCNData();
		}
		else {
			return ComTrim(sheetObj.CellValue(selectRow, CVRG_CNT));
		}		 
	 }
	 
	/**
	 * Group Sheet 에 선택된 Row 에 해당되는 Multi Coverage 의 첫번째 Country 값을  반환한다.
	 */
	function getMultiCoverageFirstCNData() {
		var sheetCVRGObj = sheetObjects[1];

		with(sheetCVRGObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				//삭제된 데이터에 대해서는 처리하지 않는다.		
				if (RowStatus(row) != "D") {
					return CellValue(row, CVRG_CNT);
				}
			}
		}
		return "";
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
					if(COL == CMDT_CD) {
						if (ComTrim(CellText(row, COL)) == "")
							isEmptyColumn = true;
					}else{
						if (ComTrim(CellValue(row, COL)) == "") 
							isEmptyColumn = true;
					}
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
	
	/**
	 * 주어진 Sheet 내 주어진 row 다음 row 의 인덱스를 반환하는 함수
	 */	
	function getNextRow(currRow, sheetObj) {
		var sheetObj1 = sheetObjects[0];
		
		var propNo = sheetObj1.CellValue(sheetObj1.SelectRow, PROP_NO);
		var verSeq = sheetObj1.CellValue(sheetObj1.SelectRow, VER_SEQ);
		var grpSeq = sheetObj1.CellValue(sheetObj1.SelectRow, GRP_SEQ);
		
		var nextRow = -1;
		for (var row = sheetObj.HeaderRows ; row <= sheetObj.LastRow ; row++) {
			//삭제된 데이터에 대해서는 처리하지 않는다.		
			if (sheetObj.CellValue(row, HID_STATUS) != "Y") {				
				if (	propNo == sheetObj.CellValue(row, PROP_NO)
					 && verSeq == sheetObj.CellValue(row, VER_SEQ)
					 && grpSeq == sheetObj.CellValue(row, GRP_SEQ)	) {
						
					if (row > currRow) {
						nextRow = row;
						break;
					}
				}
			}
		}				
		return nextRow;			
	}
		
	/**
	 * BKG POR(O) or DEL(I) 입력된 CN 의 Continent 와 Coverage 의 Continent
	 * 가 동일한지 비교를 한다. 
	 */		
	function equalContinentByCN(selectedRow) {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		var orgCN = ComTrim(sheetSCObj.CellValue(selectedRow, BKGDEL_CNT));
		
		//옵션항목이므로 입력되지 않았을 경우 PASS
		if (orgCN.length == 0) return true;
		
		if (ComTrim(sheetSCObj.CellValue(selectedRow, CVRG_MULTI)) == "M") {
			trgCN = getMultiCoverageFirstCNData();
		} else {
			trgCN = ComTrim(sheetSCObj.CellValue(selectedRow, CVRG_CNT));
		}
		
		ComSetObjValue(formObj.fnl_dest_cnt_cd, orgCN);
		ComSetObjValue(formObj.cnt_cd, 			trgCN);

		doActionIBSheet(sheetSCObj, formObj, IBSEARCH_CHKCONTI);
		chkOutData = ComGetObjValue(formObj.result);
		
		if (chkOutData == "Y") { return true; }
		else { return false; }
	}
	
	/**
	 * 주어진 값이 '' 일 경우 ' ' 로 변경해주는 함수
	 */	
	function changeNullToSpace(str) {
		return ComTrim(str).length == 0 ? " " : ComTrim(str);
	}	
	
	/**
	 * Rate Adjustment 체크박스를 클릭할 경우 실행될 동작을 정의하는 함수
	 */	
	function checkRateAdjustment() {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];
		
		with(sheetSCObj) {
			//1.필수항목인 상태에서 UnCheck 할 경우 막아야 함.
			if (CellValue(SelectRow, RT_MANDATORY) == "Y" && !formObj.chkRateAdjustment.checked) {
				ComShowCodeMessage("DMT00129", CellValue(SelectRow, "Seq"));
				formObj.chkRateAdjustment.checked = true;
				return;
			}
		
			//2.Country 가 선택되지 않은 상태에서 Check 할 경우 막아야 함.
			if (getSCExceptionCountry(SelectRow) == "" && formObj.chkRateAdjustment.checked) {
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
		 var sheetSCObj	= sheetObjects[0];
		 var sheetRTObj	= sheetObjects[3];

		//1.Currency 를 조회한다.
		searchCurrencyList(sheetSCObj.SelectRow);
		//2.입력모드로 변경
		editableRateAdjustment(true);
		//3.체크상태 변경
		sheetSCObj.CellValue(sheetSCObj.SelectRow, RT_CHECK) = "Y";
		
		//4.Multi Coverage 에 첫번째 Row 입력시 Rate Adjustment 가 필수항목일 경우 자동으로 Rate Row 를 추가시킨다.
		//                   두번째 Row 입력시 Rate Adjustment 가 필수항목일 경우 자동으로 Rate Row 를 추가시키지 않도록 변경함.
		if (fetchRowCount(sheetRTObj) == 0) {
			//자동으로 Row 를 추가해준다.(2009-07-28)
			addRateAdjustment();
		}
	}
	
	/**
	 * Rate Adjustment 를 Check 해제할 경우 동작을 정의하는 함수
	 */		 
	function doActionUnCheckOnRateAdjustment() {
		var formObj 	= document.form;
		var sheetSCObj	= sheetObjects[0];
		var sheetRTObj	= sheetObjects[3];
		
		//1.RateAdjustment 항목을 모두 지워준다.
		delSubSCException(sheetRTObj, "All");
		//2.Currency 항목을 모두 지워준다.
		ComClearCombo(formObj.currency);
		//3.Currency 변수값을 Empty 로 설정한다.
		sheetSCObj.CellValue(sheetSCObj.SelectRow, CURR_CD) = "";
		//4.비입력모드로 변경
		//  두번째 인자는 Rate Adjustment 체크박스를 클릭해서 발생된 이벤트인지 구분하기 위함이다. 
		//  그럴경우에는 Rate Adjustment, Currency 컬럼은 제외된다.
		editableRateAdjustment(false, true);
		//5.체크상태 변경
		sheetSCObj.CellValue(sheetSCObj.SelectRow, RT_CHECK) = "N";			
	}
		
	/**
	 * 화면에 입력된 필드값에 따라서 Flag 필드값을 설정해준다.
	 */			
	function setFlagValues() {
		var sheetSCObj 		= sheetObjects[0];
		var sheetRTObj		= sheetObjects[3]
		var sheetCUSTObj	= sheetObjects[4];
		var sheetCMDTObj	= sheetObjects[5];
		
		with(sheetSCObj) {

			//1.CMDT_FLG : 21번 항목 Commodity가 등록되었을 때 Y, Default N
			if (fetchRowCount(sheetCMDTObj) > 0) {
				CellValue(SelectRow, CMDT_FLG) = "Y";
			} 
			else {
				CellValue(SelectRow, CMDT_FLG) = "N";
			}

			//2.ACT_CUST_FLG : 20번 항목이 등록되었을 때 Y, Default N
			if (fetchRowCount(sheetCUSTObj) > 0) {
				CellValue(SelectRow, ACT_CUST_FLG) = "Y";
			} 
			else {
				CellValue(SelectRow, ACT_CUST_FLG) = "N";
			}
			
			//3.FM_TO_PAIR_FLG : 15번 항목이 등록되었을 때 Y, Default N
			if (CellValue(SelectRow, ORGDST_CTI) != "") {
				CellValue(SelectRow, FM_TO_PAIR_FLG) = "Y";
			} 
			else {
				CellValue(SelectRow, FM_TO_PAIR_FLG) = "N";
			}
			
			//4.FT_FLG : 13번 또는 18번 항목이 입력되었을때 Y, Default N(필수항목이므로 무조건 "Y")
			//4-1.Free Time 에 Y 필드 추가로 인해서 아래 값은 Y 필드값으로 설정함.(2009-07-27 화면변경요청에 따라 주석처리함)
			//sheetObj.CellValue(row, FT_FLG) = "Y";
				
			//4.FT_ADD_FLG : 13번 항목 입력시 Y, Default N
			//  Total 에 값이 입력되면 FT_ADD_FLG = 'N', Add 에 값이 입력되면 FT_ADD_FLG = 'Y' 로 설정(2009-11-25(수))
			if (CellValue(SelectRow, FT_TIR) == "S") {
				if (CellValue(SelectRow, ADD_DYS) != "")
					CellValue(SelectRow, FT_ADD_FLG) = "Y";
				else if (CellValue(SelectRow, TOT_DYS) != "")
					CellValue(SelectRow, FT_ADD_FLG) = "N";
			}
			else {
				CellValue(SelectRow, FT_ADD_FLG) = "N";
			}
			
			//5.FT_ADJ_FLG : 18번 항목 입력시 Y, Default N
			if (CellValue(SelectRow, FT_TIR) == "M") {
				CellValue(SelectRow, FT_ADJ_FLG) = "Y";
			} 
			else {
				CellValue(SelectRow, FT_ADJ_FLG) = "N";
			}
			
			//6.RT_ADJ_FLG : 19번 항목 입력시  Y, Default N
			if (fetchRowCount(sheetRTObj) > 0) {
				CellValue(SelectRow, RT_ADJ_FLG) = "Y";
			} 
			else {
				CellValue(SelectRow, RT_ADJ_FLG) = "N";
			}
			
			//7.DMDT_FT_ADJ_TP_CD : 13번 Free Time이 Add인 경우 'A', 멀티로 18번 항목이 입력 되었거나 Total인 경우 'T'
			if (CellValue(SelectRow, ADD_DYS) != "") {
				CellValue(SelectRow, DMDT_FT_ADJ_TP_CD) = "A";
			} 
			else if (CellValue(SelectRow, TOT_DYS) != "") {
				CellValue(SelectRow, DMDT_FT_ADJ_TP_CD) = "T";
			} 
			else {
				CellValue(SelectRow, DMDT_FT_ADJ_TP_CD) = "";
			}						
		}
	}		
	 
	/**
	 * 현재 버전의 Status Code 나 Text 를 반환한다.
	 */		
	function getVerStatus(type) {
		var formObj = document.form;
		var status = ComTrim(ComGetObjValue(formObj.version));		//화면 데이터
		if (status.indexOf(":") != -1) {
			var stsArr = status.split(":");
			if (type == "Code") { 
				return stsArr[0]; 
			}
			else { 
				return stsArr[1]; 
			}
		}

		return "";
	}
	
	/**
	 * 선택한 Group 데이터의 Tariff 에 따라서 Multi Coverage 의 제목을 변경한다.
	 */	 
	function setMultiCoverageTitle() {
		var sheetObj1 = sheetObjects[0];
		var sheetObj = sheetObjects[1];
		 
		var trfCd = sheetObj1.CellValue(sheetObj1.SelectRow, TARIFF);

		var HeadTitle1 = "";
        var HeadTitle2 = "|Seq.|Country|Region|Location";
		switch(trfCd) {
			case "DMOF": 
				HeadTitle1 = "|Seq.|BKG POL / CY|BKG POL / CY|BKG POL / CY";
				break;
				
			case "DMIF": 
				HeadTitle1 = "|Seq.|BKG POD / CY|BKG POD / CY|BKG POD / CY";
				break;
				
			case "DTOC":
			case "CTOC":
				HeadTitle1 = "|Seq.|BKG POR|BKG POR|BKG POR";
				break;
				
			case "DTIC": 
			case "CTIC":
				HeadTitle1 = "|Seq.|BKG DEL|BKG DEL|BKG DEL";
				break;
		}
		
        sheetObj.InitHeadRow(0, HeadTitle1, true);
        sheetObj.InitHeadRow(1, HeadTitle2, true);
	}
	
   	/**
   	 * Rate Adjustment 항목의 필수, 선택여부를 체크하는 함수
   	 */	  	 
  	function checkMandatoryRateAdjustment() {
  		var formObj 		= document.form;
  		var sheetSCObj 		= sheetObjects[0];
  		var sheetCVRGObj 	= sheetObjects[1];
  		var sheetRTObj		= sheetObjects[3];

  		with(sheetSCObj) {
  			
			//Rate Adjustment 의 필수항목여부 체크를 위해서는 아래 조건에 해당되는 값들을 모두 입력받아야 한다.
  			if (	ComTrim(CellValue(SelectRow, TARIFF)) 	!= "" 
  				&& 	ComTrim(CellValue(SelectRow, EFF_DT)) 	!= "" 
  				&&	ComTrim(CellValue(SelectRow, EXP_DT)) 	!= "" 
  				&& 	ComTrim(CellValue(SelectRow, CNTRCGO)) 	!= ""	) {
  				
  				//< Coverage 가 Single 인 경우 >+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	  			if (CellValue(SelectRow, CVRG_MULTI) == "S") {
	  				
	  				//Country 가 입력되지 않았다면 Rate Adjustment 필수여부를 체크하지 않는다.
	  				if (CellValue(SelectRow, CVRG_CNT) == "") return;
	  				
	  				//Coverage 매개변수 설정
	  				ComSetObjValue(formObj.cnt_cd,	CellValue(SelectRow, CVRG_CNT));
	  				ComSetObjValue(formObj.loc_cd,	CellValue(SelectRow, CVRG_LOC));
	  				
	  				if (CellValue(SelectRow, CVRG_CNT) == "CA" || CellValue(SelectRow, CVRG_CNT) == "US") {
	  					ComSetObjValue(formObj.rgn_cd, "");
	  					ComSetObjValue(formObj.ste_cd, CellValue(SelectRow, CVRG_RGN));
	  				}
	  				else {
	  					ComSetObjValue(formObj.rgn_cd, CellValue(SelectRow, CVRG_RGN));
	  					ComSetObjValue(formObj.ste_cd, "");
	  				}
	  	  			
					//1.필수항목인지 조회한다.
					doActionIBSheet(sheetRTObj, formObj, IBSEARCH);
					
					//결과값은 (M : Mandatory, O : Option, E: Error)
					var result = ComTrim(ComGetObjValue(formObj.result));

					//2.필수항목 체크결과 처리
					//2-1.에러일 경우(Error)
					if (result == "E") {
						CellValue(SelectRow, RT_MANDATORY) 	= "N";
						CellValue(SelectRow, RT_CHECK)		= "N";

						//에러메시지를 보여주고 'E' 를 리턴한다.
						if (CellValue(SelectRow, TARIFF).indexOf("CT") != -1)	
							errMsgId = "DMT02003";
						else
							errMsgId = "DMT00132";

						errMsg = "[ " + CellValue(SelectRow, CVRG_CNT) + " ][ " + CellValue(SelectRow, CVRG_RGN) + " ][ " + CellValue(SelectRow, CVRG_LOC) + " ]";
						ComShowCodeMessage(errMsgId, CellValue(SelectRow, "Seq"), errMsg);

						return "E";
					}
					//2-2.필수항목일 경우(Mandatory)
					else if (result == "M") {
						CellValue(SelectRow, RT_MANDATORY) 	= "Y";
						CellValue(SelectRow, RT_CHECK)		= "Y";
						
						//필수항목일 경우 Rate Adjustment 를 자동으로 선택해주고 입력가능한 상태로 만들어준다.==================
						formObj.chkRateAdjustment.checked = true;
						checkRateAdjustment();
						//==============================================================================================
					}
					//2-3.옵션항목일 경우
					else {
						CellValue(SelectRow, RT_MANDATORY) = "N";
						
						if (fetchRowCount(sheetRTObj) > 0)
							CellValue(SelectRow, RT_CHECK)		= "Y";
						else
							CellValue(SelectRow, RT_CHECK)		= "N";
					}
	  			}
	  			//< Coverage 가 Multi 인 경우  >+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	  			else {
	  				for (var row = sheetCVRGObj.HeaderRows ; row <= sheetCVRGObj.LastRow ; row++) {
	  					if (sheetCVRGObj.RowStatus(row) != "D") {
  							
	  		  				//Country 가 입력되지 않았다면 Rate Adjustment 필수여부를 체크하지 않는다.
	  		  				if (sheetCVRGObj.CellValue(row, CVRG_CNT) == "") continue;
	  		  				
  			  				//Coverage 매개변수 설정
  			  				ComSetObjValue(formObj.cnt_cd,	sheetCVRGObj.CellValue(row, CVRG_CNT));
  			  				ComSetObjValue(formObj.loc_cd,	sheetCVRGObj.CellValue(row, CVRG_LOC));
  			  				
  			  				if (sheetCVRGObj.CellValue(row, CVRG_CNT) == "CA" || sheetCVRGObj.CellValue(row, CVRG_CNT) == "US") {
  			  					ComSetObjValue(formObj.rgn_cd, "");
  			  					ComSetObjValue(formObj.ste_cd, sheetCVRGObj.CellValue(row, CVRG_RGN));
  			  				}
  			  				else {
  			  					ComSetObjValue(formObj.rgn_cd, sheetCVRGObj.CellValue(row, CVRG_RGN));
  			  					ComSetObjValue(formObj.ste_cd, "");
  			  				}  							

  							//1.필수항목인지 조회한다.
  							doActionIBSheet(sheetRTObj, formObj, IBSEARCH);
  								
  							//결과값은 (M : Mandatory, O : Option, E: Error)
  							var result = ComTrim(ComGetObjValue(formObj.result));
  							
  							//2.필수항목 체크결과 처리
  							//2-1.에러일 경우(Error)
  							if (result == "E") {
  								CellValue(SelectRow, RT_MANDATORY) 	= "N";
  								CellValue(SelectRow, RT_CHECK)		= "N";
  								
  								//에러메시지를 보여주고 'E' 를 리턴한다.
  								if (CellValue(SelectRow, TARIFF).indexOf("CT") != -1)	
  									errMsgId = "DMT02003";
  								else
  									errMsgId = "DMT00132";
  								
  								errMsg = "[ " + sheetCVRGObj.CellValue(row, CVRG_CNT) + " ][ " + sheetCVRGObj.CellValue(row, CVRG_RGN) + " ][ " + sheetCVRGObj.CellValue(row, CVRG_LOC) + " ]";
  								ComShowCodeMessage(errMsgId, CellValue(SelectRow, "Seq"), errMsg);

  								return "E";
  							}
  							//2-2.필수항목일 경우(Mandatory)
  							else if (result == "M") {
  								CellValue(SelectRow, RT_MANDATORY) 	= "Y";
  								CellValue(SelectRow, RT_CHECK)		= "Y";
  									
  								//필수항목일 경우 Rate Adjustment 를 자동으로 선택해주고 입력가능한 상태로 만들어준다.==================
  								formObj.chkRateAdjustment.checked = true;
  								checkRateAdjustment();
  								//==============================================================================================
  							}
  							//2-3.옵션항목일 경우
  							else {
  								CellValue(SelectRow, RT_MANDATORY) = "N";
  								
  								if (fetchRowCount(sheetRTObj) > 0)
  									CellValue(SelectRow, RT_CHECK)		= "Y";
  								else
  									CellValue(SelectRow, RT_CHECK)		= "N";
  							}
	  					}
	  				}	
	  			} //Coverage Multi 구분 end if
  			} //Rate Adjustment 필수항목인지 체크하기 위한 필수입력값들에 대한 체크 end if
  		}
  		return result;
  	}
	 
	/**
	 * Free Time 의 Y 컬럼 선택시 자동으로 Tier 가 'Single' 선택되도록 변경하는 로직으로 인해서
	 * 다른 ROW 선택시 무조건 Tier 가 'Multi' 였음에도 'Single' 로 변경되는 문제를 해결하기 위해서 
	 * Y 컬럼에 대한 이전상태 필드를 만들고, 그 상태필드를 초기화 해주는 함수.
	 */	    	 
   	function setPreviousFTFlag(sheetObj) {
   		with(sheetObj) {
	   		for (var row = HeaderRows ; row < LastRow ; row++) {
	   			CellValue(row, PREV_FT_FLG) = CellValue(row, FT_FLG);
	   		}
   		}
   	}
	
	 
	/**
	 * S/C Group Grid 내의 Coverage 정보를 
	 * Multi Coverage Grid 내의 데이터로 옮겨 놓는다.
	 */		
	function copyGroupCoverageforSave() {
		var sheetSCObj		= sheetObjects[0];
		var sheetCVRGObj 	= sheetObjects[1];

		with(sheetSCObj) {
			var prevCVRGMulti 	= ComTrim(CellValue(SelectRow, CURR_CVRG_MULTI));
			var currCVRGMulti	= ComTrim(CellValue(SelectRow, CVRG_MULTI));
		}
											
		/**
		 * Multi 구분이 
		 * 1. Single 에서 Single 일 경우 플래그 상태를 	'U' 로 변경하고 수정 처리한다.
		 * 2. Single 에서 Multi 	 일 경우 플래그 상태를 	'D' 로 변경해서 삭제 처리한다.
		 * 3. Multi 에서 Single 	 일 경우 플래그 상태를 	'I' 로 변경하고 입력 처리한다.
		 * 4. Multi 에서 Multi  	 일 경우 플래그 상태를 	'U' 로 변경하고 수정 처리한다.
		 */
		with(sheetCVRGObj) {
			//1. Single 에서 Single 일 경우 플래그 상태를 'U' 로 변경하고 수정 처리한다.									
			if (prevCVRGMulti == "S" && currCVRGMulti == "S") {
				DataInsert(-1);
				RowHidden(LastRow) = true;
				
				CellValue2(LastRow, PROP_NO) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, PROP_NO);
				CellValue2(LastRow, VER_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, VER_SEQ);
				CellValue2(LastRow, GRP_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);
				CellValue2(LastRow, CVRG_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_SEQ);
				CellValue2(LastRow, CVRG_CNT) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_CNT);
				CellValue2(LastRow, CVRG_RGN) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_RGN);
				CellValue2(LastRow, CVRG_LOC) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_LOC);
				
				//Row 의 상태설정이 제대로 반영되기 위해서는  값 설정해주고 난 후 에 지정해줘야 한다.
				RowStatus(LastRow) = "U";
			}
			//2. Single 에서 Multi 일 경우 플래그 상태를 'D' 로 변경해서 삭제 처리한다.
			else if (prevCVRGMulti == "S" && currCVRGMulti == "M") {
				//삭제된 Origin(I) or Dest(O) 를 실제로 서버에서 처리하기 위해서 삭제될 정보를 임의추가된 ROW 에
				//설정해서 날려준다.
				DataInsert(-1);
				//상태값을 'U' 로 설정하지 않고 곧바로 'D' 로 설정하면  ROW 가 삭제되어 서버에 아래 내용이 전달되지 않음
				RowStatus(LastRow) = "U";
				RowHidden(LastRow) = true;
				
				//기본키 값 설정
				CellValue2(LastRow, PROP_NO) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, PROP_NO);
				CellValue2(LastRow, VER_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, VER_SEQ);
				CellValue2(LastRow, GRP_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);
				CellValue2(LastRow, CVRG_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_SEQ);
				
				//Row 의 상태설정이 제대로 반영되기 위해서는  값 설정해주고 난 후 에 지정해줘야 한다.
				RowStatus(LastRow) = "D";
			}
			//3. Multi 에서 Single 일 경우 플래그 상태를 'I' 로 변경하고 입력 처리한다.
			else if ((prevCVRGMulti == "M" || prevCVRGMulti == "") && currCVRGMulti == "S") {
				DataInsert(-1);
				RowHidden(LastRow) = true;
				
				//기본키 값 설정
				CellValue2(LastRow, PROP_NO) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, PROP_NO);
				CellValue2(LastRow, VER_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, VER_SEQ);
				CellValue2(LastRow, GRP_SEQ) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, GRP_SEQ);
				CellValue2(LastRow, CVRG_SEQ) 	= "1";
				CellValue2(LastRow, CVRG_CNT) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_CNT);
				CellValue2(LastRow, CVRG_RGN) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_RGN);
				CellValue2(LastRow, CVRG_LOC) 	= sheetSCObj.CellValue(sheetSCObj.SelectRow, CVRG_LOC);
				
				//Row 의 상태설정이 제대로 반영되기 위해서는  값 설정해주고 난 후 에 지정해줘야 한다.
				RowStatus(LastRow) = "I";					
			}
		}			
	}
	
	/**
	 * S/C Group Grid 내의 Coverage 정보를 저장을 위해서 Multi Coverage Grid 내의 데이터로 옮겨 놓은 데이터를 삭제한다.
	 */		
	function releaseGroupCoverageforSave() {
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
	 * S/C Exception Tariff History 조회를 위한 팝업을 띄우는 함수.
	 */
	function openWinSearchTariffHistory() {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		var sCNo 		= ComTrim(ComGetObjValue(formObj.sCNo));
		var custCd 		= ComTrim(ComGetObjValue(formObj.custCd));
		var custNm 		= ComTrim(ComGetObjValue(formObj.custNm));
		var status 		= ComTrim(ComGetObjValue(formObj.status));
		var propNo 		= ComTrim(ComGetObjValue(formObj.proposalNo));
		var verSeq		= ComTrim(ComGetObjText(formObj.version));
		var count 		= fetchRowCount(sheetSCObj);
		var caller		= ComTrim(ComGetObjValue(formObj.caller));
		
		if (caller == "2006" || caller == "2007" || caller == "3107") {
			isActBtnCopy = "N";
		}
		else if (status == "" || status == "Temp. Saved") {
			isActBtnCopy = "Y";
		}
		else {
			isActBtnCopy = "N";
		}
		
		var params = "sc_no=" + sCNo;
		params += "&prop_no=" + propNo;
		params += "&ver_seq=" + verSeq;
		params += "&cust_cd=" + custCd;
		params += "&cust_nm=" + custNm;
		params += "&status=" + status;
		params += "&rowcount=" + count + "";
		params += "&is_copy=" + isActBtnCopy;
		
		ComOpenPopup("EES_DMT_2103.do?" + params, 920, 455, "copyTariffHistory", "1,0,1,1,1,1,1", true);
	}
	
	/**
	 * S/C Exception Tariff History 에서 선택한 버전의 S/C Exception Tariff 를 현재 버전에 생성해주는 함수
	 */	
	function copyTariffHistory(aryPopupData) {
		var formObj 	= document.form;
		var sheetSCObj 	= sheetObjects[0];
		
		//S/C Exception Tariff History 팝업화면에서 선택한 버전
		ComSetObjValue(formObj.hist_prop_no, 			aryPopupData[0]);
		ComSetObjValue(formObj.sc_expt_hist_ver_seq,	aryPopupData[1]);
		
		//현재 버전의 S/C Exception Tariff 정보가 있으면 모두 삭제하고, 
		//현재 버전에 S/C Exception Tariff History 팝업화면에서 선택한 버전의 S/C Exception Tariff 정보로 생성한다.
		doActionIBSheet(sheetSCObj, formObj, IBSAVE_SCTARIFF_HISTORY);
		
		if (ComGetObjValue(formObj.result) == "Y") {

			//신규 버전의  S/C Exception Tariff 를 조회한다.
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
		
    	switch(ComGetObjValue(formObj.caller)) {
	    	case "2006":
	    	case "2007":
	    	case "3107":
				btnNewLayer.style.display  				= 'none';
				btnUpdateLayer.style.display  			= 'none';
				btnSaveLayer.style.display  			= 'none';
				btnDeleteLayer.style.display  			= 'none';
				btnAcceptLayer.style.display  			= 'none';
				btnAcceptCancelLayer.style.display  	= 'none';
				
				//S/C Group
				btnAddSCLayer.style.display  			= 'none';
				btnCopySCLayer.style.display  			= 'none';
				btnSaveSCLayer.style.display 		 	= 'none';
				btnDelSCLayer.style.display  			= 'none';
				btnDownSCLayer.style.display  			= 'inline';
				
				//Multi Coverage
				btnAddMultiCoverageLayer.style.display  = 'none';
				btnDelMultiCoverageLayer.style.display  = 'none';
				
				//Tiered Free Time
				btnAddFreeTimeLayer.style.display  		= 'none';
				btnDelFreeTimeLayer.style.display  		= 'none';
				
				//Rate Adjustment
				btnAddRateAdjustmentLayer.style.display  = 'none';
				btnDelRateAdjustmentLayer.style.display  = 'none';
				
				//Customer
				btnAddCustomerLayer.style.display  		= 'none';
				btnDelCustomerLayer.style.display  		= 'none';
				
				//Commodity
				btnAddCommodityLayer.style.display  	= 'none';
				btnDelCommodityLayer.style.display  	= 'none';
				
				btnLineLayer.style.display				= 'none';
				btnCloseLayer.style.display  			= 'inline';
				break;
				
			default:
				btnNewLayer.style.display  				= 'inline';
				btnUpdateLayer.style.display  			= 'inline';
				btnSaveLayer.style.display  			= 'inline';
				btnDeleteLayer.style.display  			= 'inline';
				btnAcceptLayer.style.display  			= 'inline';
				btnAcceptCancelLayer.style.display  	= 'inline';
				
				//S/C Group
				btnAddSCLayer.style.display  			= 'inline';
				btnCopySCLayer.style.display  			= 'inline';
				btnSaveSCLayer.style.display 		 	= 'inline';
				btnDelSCLayer.style.display  			= 'inline';
				btnDownSCLayer.style.display  			= 'inline';
				
				//Multi Coverage
				btnAddMultiCoverageLayer.style.display  = 'inline';
				btnDelMultiCoverageLayer.style.display  = 'inline';
				
				//Tiered Free Time
				btnAddFreeTimeLayer.style.display  		= 'inline';
				btnDelFreeTimeLayer.style.display  		= 'inline';
				
				//Rate Adjustment
				btnAddRateAdjustmentLayer.style.display  = 'inline';
				btnDelRateAdjustmentLayer.style.display  = 'inline';
				
				//Customer
				btnAddCustomerLayer.style.display  		= 'inline';
				btnDelCustomerLayer.style.display  		= 'inline';
				
				//Commodity
				btnAddCommodityLayer.style.display  	= 'inline';
				btnDelCommodityLayer.style.display  	= 'inline';
				
				btnLineLayer.style.display				= 'inline';
				btnCloseLayer.style.display  			= 'inline';   
    	}
    }
	
    /**
     * Customer Type 이 변경될 경우 해당 Customer 정보를 조회해서 콤보에 채워주는 함수
     */
    function searchCustomerByTypeChange() {
        var formObj 	 = document.form;
        var sheetCUSTObj = sheetObjects[4];
        
       
        //조회된 데이터나 신규 입력된 데이터가 있으면 모두 삭제해준다.
        //delSubSCException(sheetCUSTObj, "All"); //2012.01.02 제외시킴

        //조회 하기 전 매개변수를 설정해 준다.
        ComSetObjValue(formObj.cust_type, ComGetObjValue(formObj.customerType));
        
        //조회 후 결과를 설정해준다.
     
       	doActionIBSheet(sheetCUSTObj, formObj, IBSEARCH_CUST);
       
    }

    /**
     * Save 시 선택한 Actual Customer 의 Type 을 저장하기 위해서 그리드에 매핑해주는 함수
     */
    function setCustomerType() {
    	var formObj 	 = document.form;
    	var sheetCustObj = sheetObjects[4];
    	var custType 	 = ComGetObjValue(formObj.customerType);
    	
    	with(sheetCustObj) {
    		for (var row = HeaderRows ; row <= LastRow ; row++) {
    			CellValue2(row, ACT_CUST_FLG) = custType;
    		}
    	}
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
    function isChangedSCExceptionTariff(initSheetNo) {
    	var result = new Array(); 
    	
    	//초기값 설정
    	result[0] = false;
    	
    	//검색을 실행할 쉬트번호가 매개변수로 넘어오지 않을경우에는 Group 쉬트부터 검색을 실행한다.
    	if (initSheetNo == undefined) initSheetNo = 0;
    	
        for (var sheetNo = initSheetNo ; sheetNo < sheetObjects.length ; sheetNo++) {
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
    function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
    
    	with(sheetObj) {
    		for (var i = 1; i <= LastRow; i ++) {
    			var celcnt = document.form.sheet4_cnt.value ;
				if(CellValue(i, NEW_FLG) == "Y") {
					sheetObj.RowFontColor(i) = RgbColor(0,0,255); 
					for (var j = 1; j <= celcnt; j ++) {
					    sheetObj.CellFont("FontBold", i, j) = true;
					}
				}
			}
		}
    	
	}
    function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
    	
    	with(sheetObj) {
    		for (var i = 1; i <= LastRow; i ++) {
    			var celcnt = document.form.sheet5_cnt.value ;
				if(CellValue(i, NEW_FLG) == "Y") {
					sheetObj.RowFontColor(i) = RgbColor(0,0,255); 
					for (var j = 1; j <= celcnt; j ++) {
					    sheetObj.CellFont("FontBold", i, j) = true;
					}
				}
			}
		}
    	
	}
    function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		for (var i = 1; i <= LastRow; i ++) {
    			var celcnt = document.form.sheet6_cnt.value ;
				if(CellValue(i, NEW_FLG) == "Y") {
					sheetObj.RowFontColor(i) = RgbColor(0,0,255); 
					for (var j = 1; j <= celcnt; j ++) {
					    sheetObj.CellFont("FontBold", i, j) = true;
					}
				}
			}
		}
	}
    
	/* 개발자 작업  끝 */