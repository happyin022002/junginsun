/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2009.js
*@FileTitle : DEM/DET Adjustment Request - After Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.097.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.21 이성훈
* 1.0 Creation 
* 2010.09.16 김태균 [] [EES-DMT] AFTER BOOKING BACKENDJOB 메시지 수정
* 2011.03.04 김태균 [CHM-201109182-01] [DMT] After-bkg-DAR column name 변경 등 보완
* 2011.12.08 김현화 [CHM-201114630-01] [DMT] After-BKG-DAR Request 화면/기능 보완 - DR & Balance 관련-PreCalc기능 막음
* 2012.01.13 김현화 [CHM-201215480][DMT] After-bkg-DAR Request 화면 및 Approval 화면 보완. 
*            D/C Amount or Ratio가 없는 경우  Billable AMT after D/C를 Blank 처리  및 Final Billable AMT 표시 안함.
* 2012.05.10 김현화 [CHM-201217570-01]After-BKG-DAR 신청 사유 선택 기능 추가 (DMDT_EXPT_RQST_RSN_CD) 
* 2012.09.04 김현화 [CHM-201219794-01]apro_ofc_cd, usr_ofc_cd를 로그인 office에서 User id 소속 Office로 변경함.          
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
     * @class DEM/DET Adjustment Request - After Booking Request 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_2009() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject 		= setComboObject;
    }
    
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;


	// Action 정의
	var IBSEARCH_CHECK_CALC   	= 101;
	var IBSEARCH_CHECK_DUP 	  	= 102;
	var IBSEARCH_CHECK_BALCHG 	= 103;
	var IBSEARCH_BKG 		  	= 104;
	var IBSEARCH_CNTRCHG_BKG  	= 105;
	var IBSEARCH_COMM 		  	= 106;
	var IBSEARCH_DAR 		  	= 107;
	var IBSEARCH_CURR 		  	= 108;
	var IBSEARCH_CHECK_BKGNO  	= 109;
	var IBSEARCH_CHECK_ROLE		= 110;
	var IBSAVE_CANCEL 		  	= 201;
	var IBSAVE_APPROVAL 	  	= 202;
	var IBSAVE_COUNTEROFFER   	= 203;
	var IBSAVE_REJECT 		  	= 204;
	var IBSEARCH_OFC	        = 205;
   	var IBSEARCH_USER_OFC_LVL	= 206;

	
	// DATA 구분자 정의
	var ROWMARK 				= "|";
	var FIELDMARK 				= "=";

	var TARIFF 					= "dmdt_trf_cd";
	var BKG_NO 					= "bkg_no";
	var BL_NO 					= "bl_no";
	var FT_FLG 					= "ft_adj_flg";
	var ADD_DYS 				= "ft_add_dys";
	var TTL_DYS 				= "ft_ttl_dys";
	var SAT_FLG 				= "xcld_sat_flg";
	var SUN_FLG 				= "xcld_sun_flg";
	var HOL_FLG 				= "xcld_hol_flg";
	var DCAR_CURR 				= "curr_cd";	
	var DCAR_FLG 				= "dc_flg";
	var DCAR_AMT 				= "dc_amt";
	var DCAR_RTO 				= "dc_rto";
	var DCAR_RTO2 				= "dc_rto2";
	var TVVD 					= "tvvd";
	var POR 					= "por_cd";
	var POL 					= "pol_cd";
	var POD 					= "pod_cd";
	var DEL 					= "del_cd";
	var RD 						= "rd";
	var DG_FLG 					= "dcgo_flg";
	var RF_FLG 					= "rc_flg";
	var AK_FLG 					= "awk_cgo_flg";
	var BB_FLG 					= "bb_cgo_flg";
	var RD_FLG 					= "rd_cgo_flg";
	var SOC_FLG 				= "soc_flg";
	var CMDT_CD 				= "cmdt_cd";
	var CMDT_NM 				= "cmdt_nm";
	var CNTR_FLG 				= "each_cntr_flg";
	var STS 					= "dmdt_chg_sts_cd";
	var CNTR_NO 				= "cntr_no";
	var CNTR_TS 				= "cntr_tpsz_cd";
	var OFC 					= "ofc_cd";
	var FM_YD 					= "fm_mvmt_yd_cd";
	var FT_DYS 					= "ft_dys";
	var FT_OVR_DYS 				= "fx_ft_ovr_dys";
	var CURR 					= "bzc_trf_curr_cd";
	var DC_AMT 					= "aft_expt_dc_amt";
	var BIL_AMT 				= "bil_amt";
	var ORG_BIL_AMT 			= "org_bil_amt";
	var AR 						= "dmdt_ar_if_cd";
	var AR_FLG 					= "cntr_chg_dc_flg";
	var AR_AMT 					= "cntr_chg_dc_amt";
	var AR_RTO 					= "cntr_chg_dc_rto";
	var AR_RTO2 				= "cntr_chg_dc_rto2";
	var CNTR_TP 				= "cntr_tp";
	var STS_DESC 				= "sts_desc";
	var PROG_DT	 				= "prog_dt";
	var PROG_OFC_CD 			= "prog_ofc_cd";
	var PROG_USR_NM 			= "prog_usr_nm";
	var PROG_RMK 				= "prog_rmk";
	var SRCH_FLG 				= "child_search";	//BKG 에 Billable Amount per CNTR 정보를 조회했는지 상태값을 갖는 컬럼
	var DAR_NO 					= "aft_expt_dar_no";
	var ADJ_SEQ 				= "aft_expt_adj_seq";
	var CNTR_SEQ 				= "aft_expt_cntr_seq";
	var CHG_SEQ 				= "chg_seq";
	var GB 						= "chg_seq_desc";
	var SYS_ID 					= "sys_area_grp_id";
	var CNTR_NO 				= "cntr_no";
	var CNTR_CYC_NO 			= "cntr_cyc_no";
	var LOC_DIV_CD 				= "dmdt_chg_loc_div_cd";
	var RQST_OFC_CD 			= "rqst_ofc_cd";
	var PRNT_OFC 				= "prnt_ofc_cd"; // 2010-06-08 추가
	var AFT_DC_AMT 			    = "bil_aft_dc_amt";
	var DMDT_EXPT_RQST_RSN_CD   = "dmdt_expt_rqst_rsn_cd"
	
	//Container 하위 항목은 hidden 상태로 조회되기 때문에 실제 삭제와 구분하기 위해서 사용됨
	var HIDDEN 					= "hidden";
	
	//ROW COPY 를 통해서 sheet1_OnSelect 함수가 호출될  경우 그 로직을 수행하지 않기 위한 구분변수
	var isDataCopy 				= false;
	
	var timer;
	
    var prevActStatus 			= "";
    
  	//Sort 시 선택되어진 Row 의 선택상태를 계속 유지하기 위해서 사용되는 변수
	var currAdjSeq				= "";    
    
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
	
					case "btn_AddBkgReq":
						if (ComIsBtnEnable("btn_AddBkgReq")) 
							doActionAddADJAfterBKG();
						break;
						
					case "btn_DelBkgReq":
						if (ComIsBtnEnable("btn_DelBkgReq")) 
							doActionDelADJAfterBKG();
						break;
	
					case "btn_PreCalc":
						if (ComIsBtnEnable("btn_PreCalc")) 
							doActionPreCalc();
						break;
	
					case "btn_Reset":
						if (ComIsBtnEnable("btn_Reset")) 
							doActionReset();
						break;
						
					case "btn_Retrieve":
						if (ComIsBtnEnable("btn_Retrieve")) 
							doActionRetrieve();
						break;
	
					case "btn_New":
						if (ComIsBtnEnable("btn_New")) 
							doActionNew();
						break; 
						
					case "btn_Request":
						if (ComIsBtnEnable("btn_Request")) 
							doActionRequest();
						break;
						
					case "btn_Cancel":
						if (ComIsBtnEnable("btn_Cancel"))
							doActionCancel();
						break;
						
					case "btn_Approval":
						if (ComIsBtnEnable("btn_Approval"))
							doActionApproval();
						break;
						
					case "btn_CounterOffer":
						if (ComIsBtnEnable("btn_CounterOffer"))
							doActionCounterOffer();
						break;
						
					case "btn_Reject":
						if (ComIsBtnEnable("btn_Reject"))
							doActionReject();
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
     
  	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj 	= document.form;
    	var sheetObj 	= sheetObjects[0];
    
    	
	   	// 팝업으로 호출시에 타이틀 표시 처리
        if (isPopupWindow()) {
	        var spanObj = document.getElementById("title2");
	       	spanObj.innerText = " DEM/DET Adjustment Request - After Booking Approval";
	       	
	       	//팝업으로 호출시 팝업에 해당되는 메뉴 버튼들을 보여준다.
	       	btnPopUpLayer.style.display	 = "inline";	       	
	   	}
        else {
        	//메인으로 호출시 팝업에 해당되는 메뉴 버튼들을 보여준다.
        	btnMainLayer.style.display	 = "inline";
        }        
    	
        for (i = 0 ; i < sheetObjects.length ; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // IBMultiCombo초기화 
        for(var k=0;k<comboObjects.length;k++){
       	 initCombo(comboObjects[k],k+1);
        }
        
		//html컨트롤 이벤트초기화
		initControl();        
        
		//화면 Load 시 특정필드들을 비활성화 시킨다.
		initDisableControls();
		
     	// User 소속 Office 
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_OFC);
		
		// User 소속 Office Level  [CHM-201433113] APVL OFC : SELHO인 경우 로그인 OFC의 OFC LEVEL '1'이 아닌경우 제한  2014.12.09
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_USER_OFC_LVL);	
		
		doActionIBCommon(sheetObjects[0],formObj,SEARCH15, DMDT_EXPT_RQST_RSN_CD);
		
		//Billable Amount per CNTR 의 Free Time, F/T Exclusion, Amount or Ratio 컬럼을 감춘다.
		hideContainerColumn(true);
  		
  		//1.권한을 확인한다.
   		doActionIBCommon(sheetObj,formObj,IBSEARCH_CHECK_ROLE,COMMAND12);  		
   		
   		//2.Tariff Type 조회 후 콤보에 조회된 결과 설정
   		doActionIBCommon(sheetObj,formObj,IBSEARCH,SEARCHLIST,TARIFF);
   		
		//3.2006번 화면에서 조회된 결과를 더블클릭해서 팝업으로 현 화면을 띄울경우 넘겨받은 파라미터
		//  가 있을 경우 자동조회를 수행한다.
		if (ComTrim(ComGetObjValue(formObj.darNo)) != "") {
			doActionRetrieve();
		}
		else {   		
			//2.전체 버튼의 상태를 초기화 시킨다.
			initBtnControl();
		}
          //btn_PreCalc 기능 막음 .2011.12.09		
			ComBtnDisable("btn_PreCalc");
			ComBtnDisable("btn_Reset");
    }
  	
  	function initControl() {
		axon_event.addListenerForm('beforedeactivate','obj_deactivate',  document.form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때		
		axon_event.addListener('click', 'condType_click', 'cond_type');
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListener('blur', 'obj_blur', 'custCd');
	}
  	
	/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboNo) {
 	    var formObj = document.form;
 	    switch(comboObj.id) {  
 				
 	    	case "dmdt_expt_rqst_rsn_cd":
 	    		with (comboObj) { 
 					SetColAlign("left|left");        
					SetColWidth("45|310");
					DropHeight = 160;
					ColBackColor(0) = "#EEEEEE";
					ColBackColor(1) = "#EEEEEE";
 		    	}
 				break; 

 	     }
 	}
    
  	function initDisableControls() {
		 var formObj = document.form;
		 
		 with(formObj) {
			 ComEnableManyObjects(false, status, scNo, rfaNo, custCd, custNm, cntrQty, curr, totalBillAmt);
			 status.className 		= "input2";
			 scNo.className 		= "input2";
			 rfaNo.className 		= "input2";
			 custCd.className 		= "input2";
			 custNm.className 		= "input2";
			 cntrQty.className 		= "input2";
			 curr.className 		= "input2";
			 totalBillAmt.className = "input2";

			//Comment 초기화 +++++++++++++++++++++++++++++++++++
			chkComment.checked 		= false;
			
			comment.readOnly 		= true;
			comment.className 		= "textarea2";
			ComSetObjValue(comment, "");
			//+++++++++++++++++++++++++++++++++++++++++++++++++		
			
			dmdt_expt_rqst_rsn_cd.Enable  = false;
		 }
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
        	
            case "sheet1":
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

                    //2011.03.02. COLUMN NAME 변경
					var HeadTitle1 = "|Seq.|BKG No.|B/L No.|Tariff|by Cntr|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|D/C Amount or Ratio(by Cntr)|D/C Amount or Ratio(by Cntr)|D/C Amount or Ratio(by Cntr)|D/C Amount or Ratio(by Cntr)|D/C Amount or Ratio(by Cntr)|T/VVD|POR|POL|POD|DEL|RCV/DEL|Special|Special|Special|Special|Special|Special|Commodity|Commodity";
					var HeadTitle2 = "|Seq.|BKG No.|B/L No.|Tariff|by Cntr|Y|Add|Total|SAT|SUN|H/day|Y|CUR|AMT|Ratio|Ratio|T/VVD|POR|POL|POD|DEL|RCV/DEL|DG|RF|AK|BB|RD|S.O.C|Code|Name";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 5;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
                    InitDataProperty(0, cnt++ ,	dtSeq,			30,		daCenter,		true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		BKG_NO,			true,		"",		dfEngUpKey,		0,	true,	true,	13);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		BL_NO,			true,		"",		dfEngUpKey,		0,	true,	true,	12);
					InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,		true,		TARIFF,			true,		"",		dfEngUpKey,		0);
					
					InitDataProperty(0, cnt++ , dtCombo,		50,		daLeft,			true,		CNTR_TP,		false,		"",		dfEngUpKey,		0);		//2011.03.02. COLUMN NAME 변경
					InitDataProperty(0, cnt++ , dtCheckBox,  	20,		daCenter,		true,		FT_FLG,			false,		"",		dfNone,			0,	true,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		ADD_DYS,		false,		"",		dfNullInteger,	0,	false,	false,	2);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		TTL_DYS,		false,		"",		dfNullInteger,	0,	false,	false,	2);
					InitDataProperty(0, cnt++ , dtCheckBox,		35,		daCenter,		true,		SAT_FLG,		false,		"",		dfNone,			0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtCheckBox,		35,		daCenter,		true,		SUN_FLG,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,		45,		daCenter,		true,		HOL_FLG,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,  	20,		daCenter,		true,		DCAR_FLG,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,		true,		DCAR_CURR,		false,		"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		   130,		daRight,		true,		DCAR_AMT,		false,		"",		dfNullFloat,	2,	false,	false,	17);

					InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		DCAR_RTO,		false,		"",		dfNullFloat,	2,	false,	false,	5);
					InitDataProperty(0, cnt++ , dtData,			20,		daCenter,		true,		DCAR_RTO2,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		TVVD,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		POR,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		POL,			false,		"",		dfNone,			0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		POD,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		DEL,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		RD,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		DG_FLG,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		RF_FLG,			false,		"",		dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		AK_FLG,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		BB_FLG,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		RD_FLG,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		SOC_FLG,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		CMDT_CD,		false,		"",		dfNone,			0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,			170,	daLeft,			true,		CMDT_NM,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daLeft,			true,		CNTR_FLG,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daLeft,			true,		DAR_NO,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daLeft,			true,		ADJ_SEQ,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daLeft,			true,		RQST_OFC_CD,	false,		"",		dfNone,			0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daLeft,			true,		SRCH_FLG,		false,		"",		dfNone,			0,	false,	false);
					
					InitDataCombo(0, TARIFF, "", "");
					InitDataCombo(0, CNTR_TP, "Same|Different ", "S|D");	//2011.03.02. COLUMN NAME 변경
					InitDataCombo(0, DCAR_CURR, "", "");

					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(TVVD);

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

					var HeadTitle1 = "|Seq.|STS|A/R|CNTR No.|T/S|Office|From YD|G/B|F/T|Over|Cur.|Billable AMT|D/C AMT|Billable AMT after D/C|Free Time|Free Time|Free Time|F/Time EXCL|F/Time EXCL|F/Time EXCL|D/C Amount or Ratio|D/C Amount or Ratio|D/C Amount or Ratio|D/C Amount or Ratio|D/C Amount or Ratio";
					var HeadTitle2 = "|Seq.|STS|A/R|CNTR No.|T/S|Office|From YD|G/B|F/T|Over|Cur.|Billable AMT|D/C AMT|Billable AMT after D/C|Y|Add|Total|SAT|SUN|H/day|Y|CUR|AMT|Ratio|Ratio";
                    var headCount = ComCountHeadTitle(HeadTitle1) + 13;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ ,	dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
	                InitDataProperty(0, cnt++ ,	dtData,			30,		daCenter,		true,		"Seq",			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		STS,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		AR,				false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		CNTR_NO,		false,		"",		dfNone,			0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		CNTR_TS,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		OFC,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			55,		daCenter,		true,		FM_YD,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		GB,				false,		"",		dfNone,			1,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		FT_DYS,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		FT_OVR_DYS,		false,		"",		dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		CURR,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		BIL_AMT,		false,		"",		dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,		true,		DC_AMT,		    false,		"",		dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,		true,		AFT_DC_AMT,     false,	    "",		dfNullFloat,	2,	false,	false);
					
					InitDataProperty(0, cnt++ , dtCheckBox,  	20,		daCenter,		true,		FT_FLG,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		ADD_DYS,		false,		"",		dfNullInteger,	0,	false,	false,	2);
					
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		TTL_DYS,		false,		"",		dfNullInteger,	0,	false,	false,	2);
					InitDataProperty(0, cnt++ , dtCheckBox,		35,		daCenter,		true,		SAT_FLG,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,		35,		daCenter,		true,		SUN_FLG,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,		45,		daCenter,		true,		HOL_FLG,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,  	20,		daCenter,		true,		AR_FLG,			false,		"",		dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,		true,		DCAR_CURR,		false,		"",		dfEngUpKey,		0);
					InitDataProperty(0, cnt++ , dtData,		   130,		daRight,		true,		AR_AMT,			false,		"",		dfNullFloat,	2,	false,	false,	17);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		AR_RTO,			false,		"",		dfNullFloat,	2,	false,	false,	5);
					InitDataProperty(0, cnt++ , dtData,			20,		daCenter,		true,		AR_RTO2,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,		true,		BKG_NO,			false,		"",		dfNone,			0);
					
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,		true,		BL_NO,			false,		"",		dfNone,			0);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daLeft,			true,		DAR_NO,			false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daLeft,			true,		ADJ_SEQ,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daLeft,			true,		CNTR_SEQ,		false,		"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  	     0,		daCenter,		true,		SYS_ID,			false,		"",		dfNone,			0);

					InitDataProperty(0, cnt++ , dtHidden,  	     0,		daCenter,		true,		CNTR_CYC_NO,	false,		"",		dfNone,			0);
					InitDataProperty(0, cnt++ , dtHidden,  	     0,		daCenter,		true,		TARIFF,			false,		"",		dfNone,			0);
					InitDataProperty(0, cnt++ , dtHidden,  	     0,		daCenter,		true,		LOC_DIV_CD,		false,		"",		dfNone,			0);
					InitDataProperty(0, cnt++ , dtHidden,  	     0,		daCenter,		true,		CHG_SEQ,		false,		"",		dfNone,			0);
					InitDataProperty(0, cnt++ , dtHidden,  	     0,		daCenter,		true,		ORG_BIL_AMT,	false,		"",		dfNone,			0);

					InitDataProperty(0, cnt++ , dtHidden,  	     0,		daLeft,			true,		PRNT_OFC,		false,		"",		dfNone,			0);
					InitDataProperty(0, cnt++ , dtHidden,  	     0,		daCenter,		true,		HIDDEN,			false,		"",		dfNone,			0);
					
					InitDataCombo(0, DCAR_CURR, "", "");
					
					// 좌측 틀고정 컬럼 설정
					FrozenCols = SaveNameCol(GB);
					
					CountPosition = 0;
					
				}
				break;

            case "sheet3":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 100;
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
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		false,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq, 	  		30,		daCenter,		false,		"Seq");
					InitDataProperty(0, cnt++ , dtData,   		100,	daCenter,		false,		STS_DESC,			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   		80,		daCenter,		false,		PROG_DT,			false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   		70,		daCenter,		false,		PROG_OFC_CD,		false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   		100,	daLeft,			false,		PROG_USR_NM,		false,	"",		dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		0,		daLeft,			false,		PROG_RMK,			false,	"",		dfNone,		0,	false,	false);
					
					CountPosition = 0;
			}
			break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:      //조회
        		var sheetBKGObj 	= sheetObjects[0];
        		var sheetCNTRObj 	= sheetObjects[1];
        	
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    			ComSetObjValue(formObj.f_cmd, 		SEARCH);
        		ComSetObjValue(formObj.apvl_ofc_cd, ComGetObjValue(formObj.approvalOfcCd));
        		ComSetObjValue(formObj.dar_no, 		ComGetObjValue(formObj.darNo));
        		ComSetObjValue(formObj.apvl_no, 	ComGetObjValue(formObj.apvlNo));
        		
				//2.조회조건으로 조회실행
        		//*********************************************************************************
        		ComOpenWait(true);
        		sheetObj.WaitImageVisible = false;
        		//*********************************************************************************
        		
				var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));
				
				//3.조회 결과를 각 Sheet 에 매핑하기전 각 Sheet 를 Clear 한다.
        		sheetBKGObj.RemoveAll();
        		sheetCNTRObj.RemoveAll();
        		
				//4.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) {
					
					//조회조건필드에 조회된 값으로 설정해준다.
					ComSetObjValue(formObj.approvalOfcCd, 	ComGetEtcData(sXml, "APVL_OFC_CD"));
					ComSetObjValue(formObj.darNo, 			ComGetEtcData(sXml, "DAR_NO"));
					ComSetObjValue(formObj.apvlNo, 			ComGetEtcData(sXml, "APVL_NO"));
					ComSetObjValue(formObj.status, 			ComGetEtcData(sXml, "STS_DESC"));
					ComSetObjValue(formObj.scNo, 			ComGetEtcData(sXml, "SC_NO"));
					ComSetObjValue(formObj.rfaNo, 			ComGetEtcData(sXml, "RFA_NO"));
					ComSetObjValue(formObj.custCd, 			ComGetEtcData(sXml, "CUST_CD"));
					ComSetObjValue(formObj.custNm, 			ComGetEtcData(sXml, "CUST_NM"));
					ComSetObjValue(formObj.dmdt_expt_rqst_rsn_cd, ComGetEtcData(sXml, "DMDT_EXPT_RQST_RSN_CD"));
					//조회결과를 그리드에 매핑시킨다.
					sheetObj.LoadSearchXml(sXml);
					
					if (sheetObj.RowCount > 0) {
						//조회된 After Booking DAR 의 상태가 Counter Offered 일 경우에는 조회필드는 비활성화
						//2009-09-28(월) 변경사항 : 현재 Counter Offered일 경우에만 조회시 비활성화되는데, 조회되면 무조건 비활성화로 변경해도 무방
						 with(formObj) {
							 ComEnableManyObjects(false, darNo, apvlNo);
							 darNo.className 	= "input2";
							 apvlNo.className 	= "input2";
							 dmdt_expt_rqst_rsn_cd.Enable  = false;

						 }						
					}
					
					//조회후 BKG No., B/LL No., Tariff 를 수정하지 못하도록 변경한다.
					with(sheetObj) {
						for (var row = HeaderRows ; row <= LastRow ; row++) {
							disableKeyColumn(row);
						}
					}
				}
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				break;

				
		    //Calculation Type Check
        	case IBSEARCH_CHECK_CALC:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    			ComSetObjValue(formObj.f_cmd, SEARCH04);
			
				//2.조회조건으로 조회실행
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.WaitImageVisible = false;
    			//*********************************************************************************
    			
				var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				ComSetObjValue(formObj.result, ComGetEtcData(sXml, "CHECK_CALC"));
				ComSetObjValue(formObj.result2, ComGetEtcData(sXml, "LOC"));
				ComSetObjValue(formObj.result3, ComGetEtcData(sXml, "CALC_TYPE"));
        		break;
        		

        	//Tariff Type 과 BKG. B/L NO. 중복 Check	
        	case IBSEARCH_CHECK_DUP:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    			ComSetObjValue(formObj.f_cmd, SEARCH05);
			
				//2.조회조건으로 조회실행
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.WaitImageVisible = false;
    			//*********************************************************************************
    			
				var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				var darNo = ComGetEtcData(sXml, "DAR_NO");
				if (darNo != "")
					ComSetObjValue(formObj.result, "Y");	
				else
					ComSetObjValue(formObj.result, "N");
				ComSetObjValue(formObj.result2, darNo);
        		break;
        		
        	
        	//Balance Charge Check
        	case IBSEARCH_CHECK_BALCHG:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    			ComSetObjValue(formObj.f_cmd, SEARCH06);
			
				//2.조회조건으로 조회실행
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.WaitImageVisible = false;
    			//*********************************************************************************
    			
				var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				var result = ComGetEtcData(sXml, "CHECK_BALCHG");
				ComSetObjValue(formObj.result, result);
        		break;
			
        	
        	//BKG No. 또는 B/L No. 입력시 Charge 정보 불러오기 전에 맞는 BKG, B/L No. 인지 확인(2009-09-30(수))
        	//2009-10-13(화) 아래 모듈에서 S/C No., RFA No. 도 조회해서 상단의 값과 비교하는 로직 추가함.
         	case IBSEARCH_CHECK_BKGNO:
         		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
         		ComSetObjValue(formObj.f_cmd, COMMAND02);
         		with(sheetObj) {
         			ComSetObjValue(formObj.bl_no, CellValue(SelectRow, BL_NO));
         			ComSetObjValue(formObj.bkg_no, CellValue(SelectRow, BKG_NO));
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
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				var bkgNo = ComGetEtcData(sXml, "BKG_NO");
				var blNo = ComGetEtcData(sXml, "BL_NO");
				var scNo = ComGetEtcData(sXml, "SC_NO");
				var rfaNo = ComGetEtcData(sXml, "RFA_NO");				
				
				if (bkgNo != "") {

					//3-1.BKG No. 나 B/L No. 로 조회된 S/C No. 나 RFA No. 가 조회컬럼에 있는 값과  다른지 체크를 한다.============		
					if (ComGetObjValue(formObj.scNo) != "" && scNo != ComGetObjValue(formObj.scNo)) {
						ComSetObjValue(formObj.result, "N");
						//어느 조건 체크에서 에러가 발생되었는지를 알려주기 위함.(SC 는SC No. 가 조회컬럼과 맞지 않을때 설정)
						ComSetObjValue(formObj.result2, "SC");
						return;
					}
					else if (ComGetObjValue(formObj.rfaNo) != "" && rfaNo != ComGetObjValue(formObj.rfaNo)) {
						ComSetObjValue(formObj.result, "N");
						//어느 조건 체크에서 에러가 발생되었는지를 알려주기 위함.(RFA 는 RFA No. 가 조회컬럼과 맞지 않을때 설정)
						ComSetObjValue(formObj.result2, "RFA");
						return;
					}
					else if (ComGetObjValue(formObj.scNo) != "" && ComGetObjValue(formObj.rfaNo) != "") {
						ComSetObjValue(formObj.scNo) = scNo;
						ComSetObjValue(formObj.rfaNo) = rfaNo;
					}
					//==================================================================================================

					ComSetObjValue(formObj.result, "Y");
					ComSetObjValue(formObj.result2, "");
					
					//3-2.조회된 값으로 재설정 해준다.
					with(sheetObj) {
						CellValue2(SelectRow, BKG_NO) = bkgNo;
						CellValue2(SelectRow, BL_NO) = blNo;
					}
				}
				else {
					ComSetObjValue(formObj.result, "N");
					//어느 조건 체크에서 에러가 발생되었는지를 알려주기 위함.(빈공백은 BKG No., B/L No. 에 맞는게 없을 때 설정)
					ComSetObjValue(formObj.result2, "");	
				}
				break;
				
				
       		//BKG No./ B/L No. 의 Booking Data 를 조회한다.
        	case IBSEARCH_BKG:
        		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
    			ComSetObjValue(formObj.f_cmd, SEARCH02);

				//2.조회조건으로 조회실행
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.WaitImageVisible = false;
    			//*********************************************************************************
    			
				var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				var frmSCNo 	= ComTrim(ComGetObjValue(formObj.scNo));
				var frmRFANo 	= ComTrim(ComGetObjValue(formObj.rfaNo));
				var srvSCNo 	= handleNullString(ComGetEtcData(sXml, "SC_NO"));
				var srvRFANo 	= handleNullString(ComGetEtcData(sXml, "RFA_NO"));		
				
				with(sheetObj) {
					if ((frmSCNo != "" && frmSCNo != srvSCNo) || (frmRFANo != "" && frmRFANo != srvRFANo)) {
						
						//3-1.입력한 BKG No. 의 S/C 또는 RFA No. 가 상단의 S/C 또는 RFA No. 와 불일치시 에러메시지를 띄워주며 막음.
						ComShowCodeMessage("DMT00159", CellValue(SelectRow, "Seq"));
						CellValue2(SelectRow, BKG_NO) 	= "";
						CellValue2(SelectRow, BL_NO) 	= "";
						ComSetObjValue(formObj.result, 	"N");
						
						return;
					}
					else {

						//조회된 결과값으로 Billable Amount per CNTR 설정
						if (frmSCNo == "" && frmRFANo == "") {
							ComSetObjValue(formObj.scNo, 	svrSCNo);
							ComSetObjValue(formObj.rfaNo, 	srvRFANo);
							ComSetObjValue(formObj.custCd, 	handleNullString(ComGetEtcData(sXml, "CUST_CD")));
							ComSetObjValue(formObj.custNm, 	handleNullString(ComGetEtcData(sXml, "CUST_NM")));
						}

						CellValue2(SelectRow, BKG_NO) 	= handleNullString(ComGetEtcData(sXml, "BKG_NO"));
						CellValue2(SelectRow, BL_NO) 	= handleNullString(ComGetEtcData(sXml, "BL_NO"));
						CellValue2(SelectRow, TVVD) 	= handleNullString(ComGetEtcData(sXml, "TVVD"));
						CellValue2(SelectRow, POR) 		= handleNullString(ComGetEtcData(sXml, "POR"));
						CellValue2(SelectRow, POL) 		= handleNullString(ComGetEtcData(sXml, "POL"));
						CellValue2(SelectRow, POD) 		= handleNullString(ComGetEtcData(sXml, "POD"));
						CellValue2(SelectRow, DEL) 		= handleNullString(ComGetEtcData(sXml, "DEL"));
						CellValue2(SelectRow, RD) 		= handleNullString(ComGetEtcData(sXml, "RD"));
						CellValue2(SelectRow, DG_FLG) 	= handleNullString(ComGetEtcData(sXml, "DG_FLG"));
						CellValue2(SelectRow, RF_FLG) 	= handleNullString(ComGetEtcData(sXml, "RF_FLG"));
						CellValue2(SelectRow, AK_FLG) 	= handleNullString(ComGetEtcData(sXml, "AK_FLG"));
						CellValue2(SelectRow, BB_FLG) 	= handleNullString(ComGetEtcData(sXml, "BB_FLG"));
						CellValue2(SelectRow, RD_FLG) 	= handleNullString(ComGetEtcData(sXml, "RD_FLG"));
						CellValue2(SelectRow, SOC_FLG) 	= handleNullString(ComGetEtcData(sXml, "SOC_FLG"));
						CellValue2(SelectRow, CMDT_CD) 	= handleNullString(ComGetEtcData(sXml, "CMDT_CD"));
						CellValue2(SelectRow, CMDT_NM) 	= handleNullString(ComGetEtcData(sXml, "CMDT_NM"));
						
						ComSetObjValue(formObj.result, "Y");
					}
				}
        		break;
        	

        	//Billable Amount per CNTR 정보를 조회한다.
        	case IBSEARCH_CNTRCHG_BKG:
        		var sheetBKGObj = sheetObjects[0];

        		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
        		with(sheetBKGObj) {
	    			ComSetObjValue(formObj.f_cmd, 			 SEARCH01);
	    			ComSetObjValue(formObj.pod, 			 CellValue(SelectRow, POD));
	    			ComSetObjValue(formObj.pol, 			 CellValue(SelectRow, POL));
	    			ComSetObjValue(formObj.del, 			 CellValue(SelectRow, DEL));
	    			ComSetObjValue(formObj.por, 			 CellValue(SelectRow, POR));
	    			ComSetObjValue(formObj.tariff, 			 CellValue(SelectRow, TARIFF));
	    			ComSetObjValue(formObj.bkg_no, 			 CellValue(SelectRow, BKG_NO));
	    			ComSetObjValue(formObj.is_cntr, 		 CellValue(SelectRow, CNTR_FLG));
	    			ComSetObjValue(formObj.aft_expt_dar_no,	 CellValue(SelectRow, DAR_NO));
	    			ComSetObjValue(formObj.aft_expt_adj_seq, CellValue(SelectRow, ADJ_SEQ));	    			
        		}
        		
				//2.조회조건으로 조회실행
    			//*********************************************************************************
    			ComOpenWait(true);
    			sheetObj.WaitImageVisible = false;
    			//*********************************************************************************
    			
    			var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));

    			//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchXml(sXml, true);
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************				
				
				//3-1.조회된 Container 목록정보가 After Booking 에 등록되지 않은 정보일 경우 기본 KEY 값을 설정해준다.(AS-IS 데이터 일 경우)
				setSequenceBKGContainer();
				
				//3-2.Charge Container 가 있는지 체크해서 그 플래그값을 설정해준다.
				if (fetchChargeRowCount() > 0) {
					//Seq No. 를 순차적으로 붙여준다.
					setCNTRSeq();  
					
					//After Exception Container Seq. 를 순차적으로 붙여준다.(After Booking 등록 후에 생성된 Charge 정보가 까지 조회되기 때문에)
					setAfterBookingCNTRSeq();
					
					//Container 항목이 존재하지 않는다면 EACH_CNTR_FLG 를 'N' 로 설정한다.
					sheetBKGObj.CellValue(sheetBKGObj.SelectRow, CNTR_FLG) 	 	= "Y";
					
					//Container 항목이 존재하지 않을 경우에는 CNTR 은 활성화된다.(2009-11-05(목))===============================
					sheetBKGObj.CellEditable(sheetBKGObj.SelectRow, CNTR_TP) = isEnableGrid();
					//====================================================================================================
					
					//D/C AMT or Ratio Pre Cal., Reset 버튼 활성화 (2009-11-06(금)) ========================================
					//PreCalc 기능 막음.2011.12.09 
					//ComBtnEnable("btn_PreCalc");
					//ComBtnEnable("btn_Reset");
					//====================================================================================================					
				}
				else {
					//Container 항목이 존재하지 않는다면 EACH_CNTR_FLG 를 'N' 로 설정한다.
					sheetBKGObj.CellValue(sheetBKGObj.SelectRow, CNTR_FLG)		= "N";
					
					//Container 항목이 존재하지 않을 경우에는 CNTR 은 'All' 자동설정되며 비활성화된다.(2009-11-05(목))===========
					sheetBKGObj.CellValue2(sheetBKGObj.SelectRow, 	CNTR_TP) 	= "S";
					sheetBKGObj.CellEditable(sheetBKGObj.SelectRow, CNTR_TP) 	= false;
					//====================================================================================================
					
					//D/C AMT or Ratio Pre Cal., Reset 버튼 비활성화 (2009-11-06(금)) ======================================
					ComBtnDisable("btn_PreCalc");
					ComBtnDisable("btn_Reset");
					//====================================================================================================					
				}

				//3-3.Quantity 설정
				ComSetObjValue(formObj.cntrQty, getChargeQuantity());
    			
				//3-4.Cur. 설정(강환수석님 요청으로 Currency 는 조회된 Billable Amount per CNTR 의 첫번째 항목을 보여주도록 변경)
				//         1 개의 Booking 에 여러개의 Container 가 존재하더라도 그 Currency 는 모두 동일하다.
				ComSetObjValue(formObj.curr, getCurrency());
				
				//3-5.Container Billable Amount 의 Total 정보를 구한다.
				sumBillableAmount();
				
				//3-6.BKG 의 Container 목록을 조회해서 그 결과값을 Charge Detail per BKG GRID 에 가지고 있음을 설정한다.
				//	     그래야, 재조회를 통한 중복된  데이터가 GRID 에 나타남을 방지할 수 있다.
				sheetBKGObj.CellValue(sheetBKGObj.SelectRow, SRCH_FLG) = "Y";
        		break
        		
        	
        	//Comment History 정보를 조회한다.
        	case IBSEARCH_COMM:
        		var sheetBKGObj = sheetObjects[0];
        		var sheetHSTObj = sheetObjects[2];
        		
        		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
        		//  BKG 데이터 조회시 사용한 매개변수를 그대로 사용하기 때문에 추가적으로 설정할 필요는 없음
        		ComSetObjValue(formObj.f_cmd, SEARCH03);
        		
        		//2.조회결과를 매핑하기 전 관련 컨트롤들을 Clear 시킨다.
        		sheetHSTObj.RemoveAll();
        		with(formObj) {
        			ComSetObjValue(formObj.comment, "");
        			chkComment.checked = false;
        		}
        		
				//3.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
    			var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));
    			
				//4.조회된 결과를 그리드에 매핑시킨다.
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchXml(sXml);    			
    			
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//5.Comment History 에 대한 설정
				formObj.chkComment.checked = false;
				
				with(sheetHSTObj) {
					if (RowCount > 0) {
						ComSetObjValue(formObj.comment, CellValue(HeaderRows, PROG_RMK));
					}
					else {
						ComSetObjValue(formObj.comment, "");
					}
					//Comment 비활성화+++++++++++++++++++++++++++++++++
					//ComEnableObject(formObj.comment, false);
					formObj.comment.readOnly 	= true;
					formObj.comment.className 	= "textarea2";
					//++++++++++++++++++++++++++++++++++++++++++++++++
				}
				break;

				
			//새로운 DAR 정보를 생성한다.
        	case IBSEARCH_DAR:
				//1.DAR No. 요청 전, 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, SEARCH07);
				
				//2.입력조건으로 수정실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));
									
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var result = ComGetEtcData(sXml, "DAR");
				ComSetObjValue(formObj.result, result);        		
        		break;
        		

        	case IBSAVE:        //저장
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, MULTI);
			
				var sParam = "";
				var sParam1 = sheetObjects[0].GetSaveString();
				var sParam2 = sheetObjects[1].GetSaveString();
				if (sheetObjects[0].IsDataModified == true) {
					sParam1 = ComSetPrifix(sParam1, "subBKG");
					sParam = sParam1 + "&";
				}
				if (sheetObjects[1].IsDataModified == true) {
					sParam2 = ComSetPrifix(sParam2, "subBKGCNTR");
					sParam = sParam + sParam2 + "&";
				}
				ComSetObjValue(formObj.aft_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd,	"R");
				ComSetObjValue(formObj.apro_ofc_cd, 			ComGetObjValue(formObj.approvalOfcCd));
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment));				
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				
				sParam += "&" + FormQueryString(formObj);
			
				//2.저장실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSaveXml("EES_DMT_2009GS.do", sParam);

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
				
				if (isPopupWindow()) {
					ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
				}
				
				break;
				
			
			case IBSAVE_CANCEL:
				//1.삭제 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 					SEARCH08);
				ComSetObjValue(formObj.aft_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"C");
				if (!formObj.chkComment.checked) {
					ComSetObjValue(formObj.prog_rmk, 			"");
				}
				else {
					ComSetObjValue(formObj.prog_rmk, 			ComGetObjText(formObj.comment));
				}
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));
										
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
				
				if (isPopupWindow()) {
					ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
				}
				
				break;
				
				
			case IBSAVE_APPROVAL:
				//1.Approval 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 						COMMAND01);
				ComSetObjValue(formObj.aft_expt_dar_no, 			ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 		"A");
				ComSetObjValue(formObj.prog_rmk, 					ComGetObjText(formObj.comment));
				ComSetObjValue(formObj.popup_flag, 					isPopupWindow() ? "Y" : "N");
				
				//승인처리 후 메일을 전송하기 위해서 필요한 파라미터
				ComSetObjValue(formObj.sc_no, 						ComGetObjValue(formObj.scNo));
				ComSetObjValue(formObj.rfa_no, 						ComGetObjValue(formObj.rfaNo));
				ComSetObjValue(formObj.bl_no, 						fetchAllBLNo());
				ComSetObjValue(formObj.cust_cd, 					ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 					ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, 	"Approved");
				
				var sParam = "";
				var sParam1 = sheetObjects[0].GetSaveString();
				var sParam2 = sheetObjects[1].GetSaveString();
				if (sheetObjects[0].IsDataModified == true) {
					sParam1 = ComSetPrifix(sParam1, "subBKG");
					sParam = sParam1 + "&";
				}
				if (sheetObjects[1].IsDataModified == true) {
					sParam2 = ComSetPrifix(sParam2, "subBKGCNTR");
					sParam = sParam + sParam2 + "&";
				}
				sParam += "&" + FormQueryString(formObj);
				
				//2.선택된 조건으로 승인처리실행(Back End Job으로 처리)
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSaveXml("EES_DMT_2009GS.do", sParam);
				
				var jobKey = ComGetEtcData(sXml, "BackEndJobKey");
				if (jobKey.length > 0) {
					ComSetObjValue(formObj.job_key, jobKey);
					
					sheetObj.WaitImageVisible = false;
					sheetObj.RequestTimeOut = 10000;
					
					//3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
					timer = setInterval(getBackEndJobStatus, 3000); 
				}				
				break;	
				
				
			case IBSAVE_COUNTEROFFER:
				//1.CounterOffer 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				//ComSetObjValue(formObj.f_cmd, 					COMMAND01); //SEARCH10
				ComSetObjValue(formObj.aft_expt_dar_no, 			ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 		"O");
				ComSetObjValue(formObj.prog_rmk, 					ComGetObjText(formObj.comment));
				ComSetObjValue(formObj.popup_flag, 					isPopupWindow() ? "Y" : "N");
				
				//Counter Offer 처리 후 메일을 전송하기 위해서 필요한 파라미터
				ComSetObjValue(formObj.sc_no, 						ComGetObjValue(formObj.scNo));
				ComSetObjValue(formObj.rfa_no, 						ComGetObjValue(formObj.rfaNo));
				ComSetObjValue(formObj.bl_no, 						fetchAllBLNo());
				ComSetObjValue(formObj.cust_cd, 					ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 					ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, 	"Counter Offered");
				
				if(ComGetObjValue(formObj.apvlNo) == '') {
					ComSetObjValue(formObj.f_cmd,	SEARCH10);
					
					//2.선택된 조건으로 COUNTER OFFER 실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
					
					var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));
	
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
					
					if (isPopupWindow()) {
						ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
					}
					
				} else {
					ComSetObjValue(formObj.f_cmd,	COMMAND01);
					
					var sParam = "";
					var sParam1 = sheetObjects[0].GetSaveString();
					var sParam2 = sheetObjects[1].GetSaveString();
					if (sheetObjects[0].IsDataModified == true) {
						sParam1 = ComSetPrifix(sParam1, "subBKG");
						sParam = sParam1 + "&";
					}
					if (sheetObjects[1].IsDataModified == true) {
						sParam2 = ComSetPrifix(sParam2, "subBKGCNTR");
						sParam = sParam + sParam2 + "&";
					}
					sParam += "&" + FormQueryString(formObj);
					
					//2.선택된 조건으로 승인처리실행(Back End Job으로 처리)
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
	
					var sXml = sheetObj.GetSaveXml("EES_DMT_2009GS.do", sParam);
					
					var jobKey = ComGetEtcData(sXml, "BackEndJobKey");
					if (jobKey.length > 0) {
						ComSetObjValue(formObj.job_key, jobKey);
						
						sheetObj.WaitImageVisible = false;
						sheetObj.RequestTimeOut = 10000;
						
						//3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
						timer = setInterval(getBackEndJobStatus, 3000); 
					}
				}
				
				break;

			case IBSAVE_REJECT:
				//1.Reject 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				//ComSetObjValue(formObj.f_cmd, 					COMMAND01); //SEARCH11
				ComSetObjValue(formObj.aft_expt_dar_no, 			ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 		"J");
				ComSetObjValue(formObj.prog_rmk, 					ComGetObjText(formObj.comment));
				ComSetObjValue(formObj.popup_flag, 					isPopupWindow() ? "Y" : "N");
				
				//Reject 처리 후 메일을 전송하기 위해서 필요한 파라미터
				ComSetObjValue(formObj.sc_no, 						ComGetObjValue(formObj.scNo));
				ComSetObjValue(formObj.rfa_no, 						ComGetObjValue(formObj.rfaNo));
				ComSetObjValue(formObj.bl_no, 						fetchAllBLNo());
				ComSetObjValue(formObj.cust_cd, 					ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 					ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, 	"Rejected");
				
				if(ComGetObjValue(formObj.apvlNo) == '') {
					ComSetObjValue(formObj.f_cmd,	SEARCH11);
				
					//2.선택된 조건으로 REJECT 실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
					
					var sXml = sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));
											
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
					
					if (isPopupWindow()) {
						ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
					}
					
				} else {
					ComSetObjValue(formObj.f_cmd,	COMMAND01);
					
					var sParam = "";
					var sParam1 = sheetObjects[0].GetSaveString();
					var sParam2 = sheetObjects[1].GetSaveString();
					if (sheetObjects[0].IsDataModified == true) {
						sParam1 = ComSetPrifix(sParam1, "subBKG");
						sParam = sParam1 + "&";
					}
					if (sheetObjects[1].IsDataModified == true) {
						sParam2 = ComSetPrifix(sParam2, "subBKGCNTR");
						sParam = sParam + sParam2 + "&";
					}
					sParam += "&" + FormQueryString(formObj);
					
					//2.선택된 조건으로 승인처리실행(Back End Job으로 처리)
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible = false;
					//*********************************************************************************
	
					var sXml = sheetObj.GetSaveXml("EES_DMT_2009GS.do", sParam);
					
					var jobKey = ComGetEtcData(sXml, "BackEndJobKey");
					if (jobKey.length > 0) {
						ComSetObjValue(formObj.job_key, jobKey);
						
						sheetObj.WaitImageVisible = false;
						sheetObj.RequestTimeOut = 10000;
						
						//3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
						timer = setInterval(getBackEndJobStatus, 3000); 
					}
				}
				
				break;
				
			case IBSEARCH_OFC:      //user ofc 조회	
	            formObj.f_cmd.value = SEARCH22;
		          
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			     
		 	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		 	    
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//조회후 결과처리
				var usrid_ofc = ComGetEtcData(sXml, "OFC_CD");
				
	//			ComSetObjValue(formObj.apro_ofc_cd, usrid_ofc);
				ComSetObjValue(formObj.usr_ofc_cd, usrid_ofc);
				break;	
				
			case IBSEARCH_USER_OFC_LVL:      // [CHM-201433113] APVL OFC : SELHO인 경우 로그인 OFC의 OFC LEVEL '1'이 아닌경우 제한  2014.12.09
	            formObj.f_cmd.value = SEARCH25;
	            
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			     
		 	    var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
		 	    
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//조회후 결과처리
				ComSetObjValue(formObj.user_ofc_lvl, ComGetEtcData(sXml, "USER_OFC_LVL"));
			break;
				
        }
    }

	//콤보관련 데이터를 조회하는 함수
	function doActionIBCommon(sheetObj,formObj,sAction,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {
			//Tariff Type 불러오기
			case IBSEARCH:
				
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				setCommonParameters(sheetObj,sComboAction,sComboKey);

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
						addCellComboItem(sheetObj,comboDatas,sComboKey,false,"");
						break;
						
					//3-2.선택한 Tariff 와 BKG No. 나 BL No. 에 해당되는 Local Currency 정보를 조회한다.
					case COMMAND05:
						comboDatas = ComGetEtcData(sXml, "CURRENCY");
						//After Booking DAR 데이터의 Currency 를 설정해준다.
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
						//Charge Detail per BKG 데이터의 Currency 를 설정해준다.
						addCellComboItem(sheetObj,comboDatas,sComboKey,false);
						break;						
				};
				break;
				
				//3-3.로그인 User가 Security 상에서 EES_DMT_2009(DAR-After BKG Approval)의 Access 권한이 있는지 조회한다.
			case IBSEARCH_CHECK_ROLE:
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
				
				//3.조회결과 처리
				ComSetObjValue(formObj.role_auth, 	handleNullString(ComGetEtcData(sXml, "ROLE_AUTH")));
				ComSetObjValue(formObj.role_permit, handleNullString(ComGetEtcData(sXml, "ROLE_PERMIT")));
				break;
				
			 case SEARCH15:
				    ComSetObjValue(formObj.f_cmd, SEARCH15); 
				    ComSetObjValue(formObj.intg_cd_id, "CD03043");
				   
					var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));   
					var comboDatas = ComGetEtcData(sXml, "COMMON_CD");
					
					
					if (comboDatas != undefined && comboDatas != '') {
						var comboItems = comboDatas.split(ROWMARK);
						for (var i = 0 ; i < comboItems.length ; i++) {
							var comboItem = comboItems[i].split(FIELDMARK);
							comboObjects[0].InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);		
			         	}
					}
				   
			  break;	
        }
		sheetObj.WaitImageVisible = true;
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
		//조회옵션으로 DAR 항목을 선택한 후 특정 필드에 데이터를 입력하면, 기타 다른 필드들에 입력된 값은 Clear 시킨다. 
		clearNoSelectConditionFields();
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
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
		var comboInitTxt = "";
		var comboInitVal = "";
		var sRow = sheetObj.SelectRow;
		
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
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	 
 		with (sheetObj) {
	 		for (var row = HeaderRows ; row <= LastRow ; row++) {
	 			
	 			//입력 혹은 수정한 데이터에 대해서만 유효성 검증을 한다.
	 			if (RowStatus(row) == "I" || RowStatus(row) == "U") {

	 				//1.필수입력항목이 없을 경우.
			    	if (ComTrim(form.approvalOfcCd) == "") {
			    	    ComShowCodeMessage("DMT03028", "APVL Office"); 
			    	    return false;
			    	}
			    	else if (CellValue(row, BKG_NO) == "") {
			    		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "BKG No.");
			    		return false;
			    	}
			    	else if (CellValue(row, BL_NO) == "") {
			    		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "B/L No.");
			    		return false;
			    	}
			    	else if (CellValue(row, TARIFF) == "") {
			    		ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "Tariff");
			    		return false;
			    	}
	 				
			    	//BKG 데이터에 대한 유효성을 체크한다.
			    	if (CellValue(row, CNTR_TP) == "S") {

				    	//2.Free Time 또는 D/C Amount, D/C Ratio 중 하나도 입력이 되지 않은 경우 "Free Time or D/C Amount/Ratio is mandatory!" Alert 창을 띄우며 막음
				    	//2-1.2009-10-07 변경사항 : Free Time 의 Y 컬럼과 D/C Amount/Ratio 의 Y 컬럼이 둘다 체크되지 않았을 경우 에러 메시지로 mandatory 를 보여주고
			    		//                        값이 입력되지 않았을 경우에는 missing 으로 나타나도록 변경함
			    		if (CellValue(row, FT_FLG) == 0 && CellValue(row, DCAR_FLG) == 0) {
				    		ComShowCodeMessage("DMT02011", CellValue(row, "Seq"));
				    		return false;			    			
			    		}
			    		else if (CellValue(row, FT_FLG) == 1 && CellValue(row, ADD_DYS) == "" && CellValue(row, TTL_DYS) == "") {
			    			ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "Free Time");
			    			return false;
			    		}
			    		else if (CellValue(row, DCAR_FLG) == 1 && CellValue(row, DCAR_AMT) == "" && CellValue(row, DCAR_RTO) == "") {
			    			ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "D/C Amount or Ratio");
			    			return false;
			    		}
	
			    		//2-2.D/C Amount or Ratio 입력시 Cur. 필수선택(AMT 입력시 Cur. 필수입력 조건, Ratio에는 Cur. 불필요)
			    		if (CellValue(row, DCAR_FLG) == 1 && CellValue(row, DCAR_CURR) == "" && CellValue(row, DCAR_AMT) != "") {
			    			ComShowCodeMessage("DMT00108", CellValue(row, "Seq"), "CUR");
			    			return false;			    			
			    		}
			    		
				    	//3.Free Time 내에 Add Day 와 Total 가 둘 다 있을 경우 "Only one of Add day or Total day can be input" Alert 창 띄우며 막음
				    	if (CellValue(row, ADD_DYS) != "" && CellValue(row, TTL_DYS) != "") {
				    		ComShowCodeMessage("DMT02004", CellValue(row, "Seq"));
				    		return false;
				    	}

				    	//4.D/C Amount or Ratio에 둘 다 입력되어 있을 경우 "Only one of D/C Amount or Ratio can be input" Alert 창 띄우며 막음
				    	if (CellValue(row, DCAR_AMT) != "" && CellValue(row, DCAR_RTO) != "") {
				    		ComShowCodeMessage("DMT02012", CellValue(row, "Seq"));
				    		return false;
				    	}
			    	}
			    	//Billable Amount per CNTR 의 모든 데이터에 대한 유효성을 체크한다.
			    	else {
			    		if (!validateChargeContainer(row, sAction)) {
			    			return false;
			    		}
			    	}
			    	
			    	//5.해당 BKG/B/L No. 의 Tariff Type 의 Calculation Type 이 맞지 않을 경우 "Calculation Type discrepancy![Location Code] - [Dual]" Alert 창 띄우며 막음
			    	//  ([Location Code] 에는 DMIF, DMOF 의 경우에는 From yard, DTIC/CTIC 의 경우에는 BKG DEL, DTOC/CTOC 의 경우에는 BKG POR 의 Location 이 나옴.
			    	//  [Dual] 또는 [Combined] 인지 표기)
			    	if (!checkCalcuationType(sheetObj,formObj)) {
			    		if (ComGetObjValue(formObj.result3) == "C") {
			    			ComShowCodeMessage("DMT00132", CellValue(row, "Seq"), ComGetObjValue(formObj.result2));
			    		}
			    		else if (ComGetObjValue(formObj.result3) == "D") {
			    			ComShowCodeMessage("DMT02003", CellValue(row, "Seq"), ComGetObjValue(formObj.result2));
			    		}
			    		return false;
			    	}

			    	//6.Tariff Type 과 BKG 또는 B/L No. 가 중복되면 중복 Alert 창 띄워주며 막음
			    	//  중복체크는조회컬럼에 DAR No. 가 없을 경우(즉, 신규입력일 경우)에만 체크함.
			    	//  중복체크를 위해 필요한 매개변수를 설정해 준다.
			    	ComSetObjValue(formObj.bkg_no, CellValue(row, BKG_NO));
			    	ComSetObjValue(formObj.bl_no, CellValue(row, BL_NO));
			    	ComSetObjValue(formObj.tariff, CellValue(row, TARIFF));
			    	if (ComTrim(ComGetObjValue(formObj.darNo)) == "") {
				    	if (checkDupTariffBKGBLNo(sheetObj,formObj)) {
				    		ComShowCodeMessage("DMT00155", CellValue(row, "Seq"), ComGetObjValue(formObj.result2));
				    		return false;
				    	}
			    	}
			    	
			    	//7.Balance Charge 가 있는 CNTR 가 있는 경우 Alert 창 보여줌
			    	//  CNTR[XXXX] with Balance Charge cannot be applied of this DAR! Pls contact DEM/DET Office [XXXX]" (Balance Charge 가 있는 CNTR# 와
			    	//  DEM/DET Office 를 보여줌)
			    	//  장민지대리 요청으로 주석처리함.(2009-09-21일 ) 
			    	//if (checkBalanceCharge(sheetObj,formObj)) {
			    	//	ComShowCodeMessage("DMT02015", CellValue(row, "Seq"), "cntr no", "office no");
			    	//	return false;
			    	//}
			    	
	 			} else { // RowStatus(row) == "R"
	 				if (CellValue(row, CNTR_TP) != "S") {
	 					if (!validateChargeContainer(row, sAction)) {
			    			return false;
			    		}
	 				}
	 			}
	 			
	 		} // for - end
 		} // with - end
 		
		//6.중복데이터 체크 로직 추가(2009-07-28)
		if (!dupValidate(sheetObj)) return false;
		
		//8.Comment 입력문자 길이 Check(2009-09-16)
		//  Request 일 경우 Comment 는 필수입력!!
		if (!validateComment()) return false;
		
 		return true;
    }

  	/**
  	 * 해당 BKG/B/L No. 의 Container 정보중 Free Time 과 D/C Amount or Ratio 의 필수입력체크를 수행하는 함수
  	 */	    
    function validateChargeContainer(selectedRow, sAction) {
    	var sheetBKGObj = sheetObjects[0];
    	var sheetCNTRObj = sheetObjects[1];
    	
     	with(sheetBKGObj) {
     		var adjSeq = CellValue(selectedRow, ADJ_SEQ);
     		var seqNo = CellValue(selectedRow, "Seq");		// 상단 BKG Grid Seq
     		
     		//Charge 정보를 화면으로 불러오지 않았다면, 즉, Charge 정보가 변경되지 않았다면 Validation 을 하지 않는다.
     		if (CellValue(selectedRow, SRCH_FLG) != "Y") return true;
     	}
     	
     	var formObj = document.form;
     	var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
    	var isCheckCnt = 0;

    	//Charge 는 최소 1개 이상만 입력되면 유효성 통과
    	with(sheetCNTRObj) {
     		for (var row = HeaderRows ; row <= LastRow ; row++) {
     			
     			if (RowStatus(row) != "D" && adjSeq == CellValue(row, ADJ_SEQ)) {
     				var bkgCntrSeqNo = seqNo + '-' + CellValue(row, "Seq");
     				// 2010-07-02 추가
					var roleAuth = ComGetObjValue(formObj.role_auth);
     				
     				if (CellValue(row, FT_FLG) == "1") {
     					// 2010-06-09 추가
     					if(sAction == IBSAVE_APPROVAL) {
     						// 2010-07-02 수정
     						if(roleAuth == "DMT03" && (usrOfcCd == CellValue(row, OFC) || usrOfcCd == CellValue(row, PRNT_OFC)) ) {
    	     					// pass
    	     				} else if( roleAuth == "DMT01" || roleAuth == "DMT02" ) {
    	     					// pass
     						} else {
    	     					ComShowCodeMessage("DMT03071", bkgCntrSeqNo);
    					    	return false;
    	     				}
         				}
     					
     					if (CellValue(row, ADD_DYS) == "" && CellValue(row, TTL_DYS) == "") {
     						ComShowCodeMessage("DMT00108", bkgCntrSeqNo, "Free Time");
     						return false;    
     					}
     					else if (CellValue(row, ADD_DYS) != "" && CellValue(row, TTL_DYS) != "") {
 				    		ComShowCodeMessage("DMT02004", bkgCntrSeqNo);
 				    		return false;    						
     					}
   						isCheckCnt++;
     				}
     				
     				if (CellValue(row, AR_FLG) == "1") {
     					// 2010-06-09 추가
     					if(sAction == IBSAVE_APPROVAL) {
     						// 2010-07-02 수정
     						if(roleAuth == "DMT03" && (usrOfcCd == CellValue(row, OFC) || usrOfcCd == CellValue(row, PRNT_OFC)) ) {
    	     					// pass
    	     				} else if( roleAuth == "DMT01" || roleAuth == "DMT02" ) {
    	     					// pass
     						} else {
    	     					ComShowCodeMessage("DMT03071", bkgCntrSeqNo);
    					    	return false;
    	     				}
         				}
     					
     					if (CellValue(row, DCAR_CURR) == "" && CellValue(row, AR_AMT) != "") {
     						ComShowCodeMessage("DMT00108", bkgCntrSeqNo, "CUR");
     						return false;     						
     					}     					
     					else if (CellValue(row, AR_AMT) == "" && CellValue(row, AR_RTO) == "") {
     						ComShowCodeMessage("DMT00108", bkgCntrSeqNo, "D/C Amount or Ratio");
     						return false;
     					}
     					else if (CellValue(row, AR_AMT) != "" && CellValue(row, AR_RTO) != "") {
     			    		ComShowCodeMessage("DMT02012", bkgCntrSeqNo);
 				    		return false;    						
     					}
   						isCheckCnt++;
     				}
     			}
     		}
     		
    		if (isCheckCnt == 0) {
	    		ComShowCodeMessage("DMT02011", seqNo);
    			return false;
    		}
    	}

    	return true;
    }
    
  	/**
  	 * 중복된 Tariff, BKG No., B/L No. 를 가지는 데이터가 있는지 체크하는 함수
  	 */	  	 
  	function dupValidate(sheetObj) {
  		
  		with(sheetObj) {
	  		var dupRows = ColValueDupRows(TARIFF + "|" + BKG_NO + "|" + BL_NO);
	  		if (dupRows != "") {
	    		var dupArrRow = dupRows.split(",");
	        	ComShowCodeMessage('DMT00161', CellValue(dupArrRow[0], "Seq"));
				SelectRow = dupArrRow[0];
	        	return false;
			}
  		}
  		
  		return true;
  	}
  	 
 	/**
 	 * 해당 BKG No. 또는 B/L No. 의 Tariff Type 의 Calculation Type 이 맞는지 체크하는 함수
 	 */	
    function checkCalcuationType(sheetObj, formObj) {
    	
    	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_CALC);
    	
    	return ComGetObjValue(formObj.result) == "Y" ? true : false; 
    }
 
   	/**
  	 * BKG No. 또는 B/L No. 입력시 Charge 정보 불러오기 전에 맞는 BKG, B/L No. 인지 체크하는 함수
  	 */	
     function checkTariffBKGBLNo(sheetObj, formObj) {
      
      	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_BKGNO);

      	return ComGetObjValue(formObj.result) == "Y" ? true : false;
     }
     
 	/**
	 * Tariff Type 과 BKG 또는 B/L No. 가 중복되는지 체크하는 함수
	 */	
    function checkDupTariffBKGBLNo(sheetObj, formObj) {

    	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_DUP);

    	return ComGetObjValue(formObj.result) == "Y" ? true : false;
    }
    
 	/**
	 * Balance Charge 가 있는 CNTR 가 있는지 체크하는 함수
	 */	
    function checkBalanceCharge(sheetObj, formObj) {

    	doActionIBSheet(sheetObj, formObj, IBSEARCH_CHECK_BALCHG);
    	
    	return ComGetObjValue(formObj.result) == "Y" ? true : false;
    }
    
 	/**
	 * Sheet1 에 변경이 발생하였을 때 호출되는 함수
	 */	    
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj = document.form;
		
		with(sheetObj) {
			switch(ColSaveName(Col)) {

				//1.BKG No. 가 변경되었을 경우 해당 BKG 정보를 조회한다.
				case BKG_NO:
					//1-1.BKG_NO 가 입력되었다면 B/L No. 를 조회한다.
					if (ComTrim(CellValue(SelectRow, BKG_NO)) == "") return;
					if (!checkBKGBLNo(BKG_NO)) return;
					
					//1-2.Tariff 가 입력되지 않았다면 조회를 수행하지 않는다.
					if (ComTrim(CellValue(SelectRow, TARIFF)) == "") return;
					
					//1-3.Tariff 와 BKG No. 에 해당하는 Charge Detail 정보 조회를 수행한다.
					searchContainerByTariffBKGNo();					
					break;
					

				//2.BKG No. 가 변경되었을 경우 해당 BKG 정보를 조회한다.
				case BL_NO:
					//2-1.B/L No. 가 입력되었다면 BKG No. 를 조회한다.
					if (ComTrim(CellValue(SelectRow, BL_NO)) == "") return;
					if (!checkBKGBLNo(BL_NO)) return;
					
					//2-2.Tariff 가 입력되지 않았다면 조회를 수행하지 않는다.
					if (ComTrim(CellValue(SelectRow, TARIFF)) == "") return;
					
					//2-3.Tariff 와 BKG No. 에 해당하는 Charge Detail 정보 조회를 수행한다.
					searchContainerByTariffBKGNo();
					break;
					
					
				//3.Tariff 가 변경되었을 경우 해당 BKG 정보를 조회한다.
				case TARIFF:
					//3-1.선택한 Tariff 가 Blank 이면 조회를 수행하지 않는다.
					if (ComTrim(CellValue(SelectRow, TARIFF)) == "") return;
					
					//3-2.BKG No, B/L No. 가 입력되지 않았다면 조회를 수행하지 않는다.
					if (ComTrim(CellValue(SelectRow, BKG_NO)) == "" && ComTrim(CellValue(SelectRow, BL_NO)) == "") return;
					
					//3-3.Tariff 와 BKG No. 에 해당하는 Charge Detail 정보 조회를 수행한다.
					searchContainerByTariffBKGNo();
					break;
						
					
				//CNTR 에 따라서 Free Time, F/Time EXCL, D/C Amount or Ratio 활성화 혹은 비활성화 처리한다.
				//인자는 비활성화시 존재하는 값을 삭제할지를 나타낸다.
				case CNTR_TP:
					modifyModeFreeTimeAmountorRatio(true);
					break;


				//Free Time Y 를 체크하거나 체크해제할 경우
				case FT_FLG:
					if (Value == 1) {
						editableFreeTime(Row, true);
					}
					else {
						editableFreeTime(Row, false);
					}
					break;

					
				//D/C Amount or Ratio Y 를 체크하거나 체크해제할 경우
				case DCAR_FLG:
					if (Value == 1) {
						editableDCAmountRatio(Row, true);
					}
					else {
						editableDCAmountRatio(Row, false);
					}
					break;
			}
		}
	
	}
	
   /**
	* 정렬시 현재 선택되어진 ROW 의 선택상태를 계속 유지하도록 처리해주는 함수
	*/	
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (currAdjSeq == CellValue(row, ADJ_SEQ)) {
					SelectRow = row;
					break;
				}
			}
		}
	}
		
	/**
	 * BKG Row 가 선택될 때 조건별 Row 상태를 변경한다.
	 */	
	function sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj = document.form;
		var sheetCNTRObj = sheetObjects[1];
		
		//이 함수가 ROW COPY 를 통해서 호출될  경우 아래 로직을 수행하지 않는다.
		if (isDataCopy) return;
		
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		with(sheetObj) {
			if (OldRow >= HeaderRows && OldRow != NewRow) {
				
				//-------------------------------------------
				currAdjSeq = CellValue(SelectRow, ADJ_SEQ);
				//-------------------------------------------
				
				if (RowStatus(NewRow) != "D") {
					displayChargeDetailperBKG(NewRow)
				}
			}
		}
	}

 	/**
	 * Sheet2 에 변경이 발생하였을 때 호출되는 함수
	 */	    
    function sheet2_OnChange(sheetObj,Row,Col,Value) {
		var formObj = document.form;
		
		with(sheetObj) {
			switch(ColSaveName(Col)) {
	
				//Free Time Y 를 체크하거나 체크해제할 경우
				case FT_FLG:
					if (Value == 1) {
						editableCNTRFreeTime(Row, true);
					}
					else {
						editableCNTRFreeTime(Row, false);
					}
					break;

					
				//D/C Amount or Ratio Y 를 체크하거나 체크해제할 경우
				case AR_FLG:
					if (Value == 1) {
						editableCNTRDCAmountRatio(Row, true);
					}
					else {
						editableCNTRDCAmountRatio(Row, false);
					}
					break;
					
					
				case DCAR_CURR:
					changeCurrencyAltogther(Row);					
					break;
			}
		}
	}	 

	/**
	 * Comment History 의 Row 가 선택될 때 해당 Comment 를 보여준다.
	 */	
	function sheet3_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj = document.form;
		
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		if (OldRow >= sheetObj.HeaderRows && OldRow != NewRow) {
			if (!formObj.chkComment.checked) {
				ComSetObjValue(formObj.comment, sheetObj.CellValue(NewRow, PROG_RMK));
			}
		}		
	}
	 
   /**
	* Tariff 나 BKG No. 가 변경되었을 경우 After Booking DAR 에 해당되는 Charge Detail 정보를 조회하는 함수
	*/	 	
	function searchContainerByTariffBKGNo() {
		var formObj 		= document.form;
		var sheetBKGObj 	= sheetObjects[0];
		var sheetCNTRObj 	= sheetObjects[1];
		
		var tariff 	= "";
		var cntCd 	= "";
		
		with(sheetBKGObj) {
			tariff = CellValue(SelectRow, TARIFF);
			
			//1-1.Calculation Type Check 하기 위한 매개변수를 설정한다.
			ComSetObjValue(formObj.bkg_no, CellValue(SelectRow, BKG_NO));
			ComSetObjValue(formObj.bl_no, CellValue(SelectRow, BL_NO));
			ComSetObjValue(formObj.tariff, CellValue(SelectRow, TARIFF));
		
			//1-2.해당 BKG No. 의 Tariff Type 의 Calculation Type 이 맞는지 체크를 수행한다.
	    	if (!checkCalcuationType(sheetBKGObj,formObj)) {
	    		if (ComGetObjValue(formObj.result3) == "C") {
	    			ComShowCodeMessage("DMT00132", CellValue(SelectRow, "Seq"), ComGetObjValue(formObj.result2));
	    		}
	    		else if (ComGetObjValue(formObj.result3) == "D") {
	    			ComShowCodeMessage("DMT02003", CellValue(SelectRow, "Seq"), ComGetObjValue(formObj.result2));
	    		}
	    		CellValue2(SelectRow, TARIFF) = "";
	    		return false;
	    	}
			
			//1-3.Tariff Type 과 BKG 가 중복되었는지 체크한다.
	    	if (checkDupTariffBKGBLNo(sheetBKGObj,formObj)) {
	    		ComShowCodeMessage("DMT00155", CellValue(SelectRow, "Seq"), ComGetObjValue(formObj.result2));
	    		CellValue2(SelectRow, TARIFF) = "";
	    		return false;
	    	}
		}

    	//1-4.입력한 BKG No. 의 Booking Data 를 조회한다.
		doActionIBSheet(sheetBKGObj,formObj,IBSEARCH_BKG);
    	
    	//BKG No., B/L No. 에 해당되는 데이터가 없다면 종료
    	if (ComGetObjValue(formObj.result) == "N") return;
    	
    	//1-5.입력한 BKG No. 의 Charge Detail per BKG 정보를 조회한다.
    	//    조회하기전 Charge Detail per BKG 를 After Booking 에서 읽어올 것인지 Charge Calculation 에서 
    	//    읽어올 것인지 설정해준다.(이 경우에는 Charge Calculation 에서 읽어온다. 2009-11-02)
    	ComSetObjValue(formObj.is_aft_bkg_cntr, "N");
		doActionIBSheet(sheetCNTRObj,formObj,IBSEARCH_CNTRCHG_BKG);
		
		//1-6.전체 CNTR가 A/R I/F 되어 있으면 Alert창 띄워주면 확인 요청.
		if (checkARIFAllContainer()) {
			if (!ComShowCodeConfirm("DMT00167")) {
				//조회된 Booking 정보와 Charge 정보를 모두 삭제한다.
				removeBookingChargeData();
				return;
			}
		}
		
    	//1-7.조회후 BKG No., B/LL No., Tariff 를 수정하지 못하도록 변경한다.
		disableKeyColumn(sheetBKGObj.SelectRow);
		
    	//1-8.Currency 를 조회한다.
    	with(sheetBKGObj) {
			switch(tariff) {
				case "DMIF": 
					cntCd = CellValue(SelectRow, POD).substring(0, 2);
					break;
				case "DMOF": 
					cntCd = CellValue(SelectRow, POL).substring(0, 2);
					break;
				case "DTIC":
				case "CTIC":
					cntCd = CellValue(SelectRow, DEL).substring(0, 2);
					break;
				case "DTOC":
				case "CTOC":
					cntCd = CellValue(SelectRow, POR).substring(0, 2);
					break;
			}
    	}
    	ComSetObjValue(formObj.cnt_cd, cntCd);
   		doActionIBCommon(sheetBKGObj,formObj,IBSEARCH,COMMAND05,DCAR_CURR);
   		
		//1-9.CNTR 에 따라서 Free Time, F/Time EXCL, D/C Amount or Ratio 활성화 혹은 비활성화 처리한다.
   		//    (인자는 비활성화시 존재하는 값을 삭제할지를 나타낸다)
		modifyModeFreeTimeAmountorRatio(false);  		
	}

	/**
	 * Free Time Y 컬럼을 체크하거나 체크해제시 관련된 모든 컬럼의 활성화를 지정해주는 함수
	 */
	function editableFreeTime(row, flg) {
		var sheetBKGObj = sheetObjects[0];
		
		with(sheetBKGObj) {
			if (!flg) {
				CellValue(row, ADD_DYS) = "";
				CellValue(row, TTL_DYS) = "";
				CellValue(row, SAT_FLG) = 0;
				CellValue(row, SUN_FLG) = 0;
				CellValue(row, HOL_FLG) = 0;				
			}
			
			//Grid 가 활성화 상태일 경우에만 각 필드의 입력가능여부를 선택할 수 있다.
			if (isEnableGrid()) {
				CellEditable(row, ADD_DYS) = flg;
				CellEditable(row, TTL_DYS) = flg;
				CellEditable(row, SAT_FLG) = flg;
				CellEditable(row, SUN_FLG) = flg;
				CellEditable(row, HOL_FLG) = flg;
			}
		}
	}
	 
	/**
	 * Billable Amount per CNTR 의 Free Time Y 컬럼을 체크하거나 체크해제시 관련된 모든 컬럼의 활성화를 지정해주는 함수
	 */
	function editableCNTRFreeTime(row, flg) {
		var sheetCNTRObj = sheetObjects[1];
		
		with(sheetCNTRObj) {
			if (!flg) {
				CellValue(row, ADD_DYS) = "";
				CellValue(row, TTL_DYS) = "";
				CellValue(row, SAT_FLG) = 0;
				CellValue(row, SUN_FLG) = 0;
				CellValue(row, HOL_FLG) = 0;				
			}
			
			//Grid 가 활성화 상태일 경우에만 각 필드의 입력가능여부를 선택할 수 있다.
			if (isEnableGrid()) {			
				CellEditable(row, ADD_DYS) = flg;
				CellEditable(row, TTL_DYS) = flg;
				CellEditable(row, SAT_FLG) = flg;
				CellEditable(row, SUN_FLG) = flg;
				CellEditable(row, HOL_FLG) = flg;
			}
		}
	}
		
	/**
	 * D/C Amount or Ratio Y 컬럼을 체크하거나 체크해제시 관련된 모든 컬럼의 활성화를 지정해주는 함수
	 */
	function editableDCAmountRatio(row, flg) {
		var sheetBKGObj = sheetObjects[0];
		
		with(sheetBKGObj) {	
			if (!flg) {
				CellValue2(row, DCAR_CURR) = "";
				CellValue2(row, DCAR_AMT) = "";
				CellValue2(row, DCAR_RTO) = "";
			}
			
			//Grid 가 활성화 상태일 경우에만 각 필드의 입력가능여부를 선택할 수 있다.
			if (isEnableGrid()) {				
				CellEditable(row, DCAR_CURR) = flg;
				CellEditable(row, DCAR_AMT) = flg;
				CellEditable(row, DCAR_RTO) = flg;
			}
		}			
	}

	/**
	 * D/C Amount or Ratio Y 컬럼을 체크하거나 체크해제시 관련된 모든 컬럼의 활성화를 지정해주는 함수
	 */
	function editableCNTRDCAmountRatio(row, flg) {
		var sheetCNTRObj = sheetObjects[1];
		
		with(sheetCNTRObj) {	
			if (!flg) {
				CellValue2(row, DCAR_CURR) = "";
				CellValue2(row, AR_AMT) = "";
				CellValue2(row, AR_RTO) = "";
			}
			
			//Grid 가 활성화 상태일 경우에만 각 필드의 입력가능여부를 선택할 수 있다.
			if (isEnableGrid()) {
				CellEditable(row, DCAR_CURR) = flg;
				CellEditable(row, AR_AMT) = flg;
				CellEditable(row, AR_RTO) = flg;
			}
			
			//Y에 체크될 경우 CUR 에 값이 하나라도 있으면 그 값으로 현재 체크된 항목의 CUR 을 채워준다.
			if (flg) {
				for (var row = HeaderRows ; row <= LastRow ; row++) {
					if (row != SelectRow && RowStatus(row) != "D" && CellValue(row, DCAR_CURR) != "") {
						CellValue2(SelectRow, DCAR_CURR) = CellValue(row, DCAR_CURR);
						break;
					}
				}
			}			
		}			
	}
		
	/**
	 * BKG 데이터의 CNTR 선택값에 따라서 CNTR 데이터의 일부 컬럼을 보여주거나 감추도록 동작하는 함수
	 */	
	function hideContainerColumn(flg) {
		var sheetCNTRObj = sheetObjects[1];
		
		with(sheetCNTRObj) {
			ColHidden(FT_FLG) = flg;
			ColHidden(ADD_DYS) = flg;
			ColHidden(TTL_DYS) = flg;
			ColHidden(SAT_FLG) = flg;
			ColHidden(SUN_FLG) = flg;
			ColHidden(HOL_FLG) = flg;
			ColHidden(AR_FLG) = flg;
			ColHidden(DCAR_CURR) = flg;
			ColHidden(AR_AMT) = flg;
			ColHidden(AR_RTO) = flg;
			ColHidden(AR_RTO2) = flg;
		}
	}

	/**
	 * BKG 데이터의 CNTR 선택값에 따라서 CNTR 데이터의 일부 컬럼데이터를 지워지는 동작하는 함수
	 */		 
	function clearContainerColumn(row) {
		var sheetBKGObj = sheetObjects[0];		
		var sheetCNTRObj = sheetObjects[1];

		var adjSeq = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, ADJ_SEQ);
		
		with(sheetCNTRObj) {		
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (adjSeq == CellValue(row, ADJ_SEQ)) {
					CellValue(row, FT_FLG) = 0;
					CellValue(row, ADD_DYS) = "";
					CellValue(row, TTL_DYS) = "";
					CellValue(row, SAT_FLG) = 0;
					CellValue(row, SUN_FLG) = 0;
					CellValue(row, HOL_FLG) = 0;
					CellValue(row, AR_FLG) = 0;
					CellValue(row, AR_AMT) = "";
					CellValue(row, AR_RTO) = "";
				}
			}
		}
	}
	 
	/**
	 * BKG 데이터의 CNTR 선택값에 따라서 CNTR 모든 데이터에 대해서  
	 * Free Time 의 Y 컬럼과 Amount or Ratio 의 Y 컬럼을 체크하도록 동작하는 함수
	 */		 
	function checkContainerColumn(selectRow) {
		var sheetBKGObj = sheetObjects[0];		
		var sheetCNTRObj = sheetObjects[1];
		
		var adjSeq = sheetBKGObj.CellValue(selectRow, ADJ_SEQ);
		
		with(sheetCNTRObj) {		
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (adjSeq == CellValue(row, ADJ_SEQ)) {
					//G/B 가 Balance 일 경우에는 Free Time, F/Time EXCL, D/C Amount or Ratio 입력불가
					if (CellValue(row, GB) == "B") {
						//컬럼의 값을 비체크 상태로 초기화 시킨다.						
						CellValue(row, FT_FLG) = 0;
						CellValue(row, AR_FLG) = 0;
						
						//컬럼의 상태를 비활성화 시킨다.
						CellEditable(row, FT_FLG) = false;
						CellEditable(row, AR_FLG) = false;
						
						editableCNTRFreeTime(row, false);
						editableCNTRDCAmountRatio(row, false);						
					}
				}
			}
		}
	}
		
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		for (var i = 2; i <= LastRow; i ++) {
				CellValue2(i, DCAR_RTO2) = "%";
			}
		}
    	//Edit 기능 제한 2011.12.09
    	sheetObj.Editable = false;
	}

	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			 var finalAmtcnt = 0 ;
			for (var i = 2; i <= LastRow; i ++) {
				CellValue2(i, AR_RTO2) = "%";
				
				  if (CellValue(i, AR_FLG)== 1){
					   finalAmtcnt = 1 ;
//					  if(CellValue(i, BIL_AMT) == 0){	 
//						 CellValue2(i, DC_AMT) ="";
//						 CellValue2(i, AFT_DC_AMT) ="";	
//						}
				  }else{
					  if(CellValue(i, DC_AMT) == 0 ){	
						 CellValue2(i, DC_AMT) ="";
						 CellValue2(i, AFT_DC_AMT) ="";
					  }else{
						 finalAmtcnt = finalAmtcnt + 1 ;
					  }
				  }
				
				
			}
			if (finalAmtcnt == 0){
			    ComSetObjValue(document.form.totalBillAmt,"");
			}
		}
		//Edit 기능 제한 2011.12.09
		sheetObj.Editable = false;
	}

	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow == (HeaderRows - 1)) {
				switch(colName) {
					case ADD_DYS: MouseToolTipText = "Additional Day"; break;
					case TTL_DYS: MouseToolTipText = "Total Day"; break;					
					default: MouseToolTipText = "";
				}
			}
			else {
				MouseToolTipText = "";
			}			
		}	
	}
	
	function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow == (HeaderRows - 1)) {
				switch(colName) {
					case ADD_DYS: MouseToolTipText = "Additional Day"; break;
					case TTL_DYS: MouseToolTipText = "Total Day"; break;					
					default: MouseToolTipText = "";
				}
			}
			else {
				MouseToolTipText = "";
			}			
		}
	}
		
    /**
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setCommonParameters(sheetObj,sAction,sComboKey) {
		var formObj = document.form;

		ComSetObjValue(formObj.f_cmd, sAction);			//Command
	}
		
   /**
    * Row Add 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */		
    function doActionAddADJAfterBKG() {
    	var formObj = document.form;
    	var sheetBKGObj = sheetObjects[0];

    	//데이터를 추가할 때, sheet1_OnSelect 함수가 자동으로 호출되는데, 이 경우 BKG DAR 에 대한 CNTR 정보를재조회해서
    	//CNTR GRID 에 추가하는 문제가 발생되는데, 이를 해결하기 위해서 아래 변수를 TRUE 로 설정한다.
    	isDataCopy = true;    	
    	with(sheetBKGObj) {
    		DataInsert(-1);
    		//조회된 상태에서 ROW 를 추가하는 것이라면 DAR No. 를 추가해준다.
    		if (LastRow > HeaderRows && CellValue(HeaderRows, DAR_NO) != "") {
    			CellValue(LastRow, DAR_NO) = CellValue(HeaderRows, DAR_NO);
    		}    		
    		//Tariff 컬럼을 기본값으로 Empty 시켜준다.
    		//빈 공란을 추가한다.(Default를 공란으로 하여, User 선택 유) 2009-09-30(수) 추가함.
    		CellValue(LastRow, TARIFF) = "";
    		//CUR 을 공란으로 설정한다.
    		CellValue(LastRow, DCAR_CURR) = "";    		
    		//Ratio 의 '%' 기호를 추가한다.
    		CellValue(LastRow, DCAR_RTO2) = "%";
    		//Billable Amount per CNTR 조회를 했는지 상태값을 저장하는 조회플래그
    		CellValue(LastRow, SRCH_FLG) = "N";
    		//ADJ_SEQ 값을 추가한다.
    		CellValue(LastRow, ADJ_SEQ) = fetchNextADJSeq();
    	}
    	isDataCopy = false;
    	
    	//복사된 행의 Charge Detail per BKG 데이터가 없으므로 아무 데이터도 보여주지 않도록 처리한다.
    	showBillableAmountPerCNTR(); 
    	
    	//BKG 의 선택행 변경으로 인해 Charge Detail per BKG 의 CNTR Q'ty, Cur., Total Billable AMT 데이터를 지워준다.
    	clearChargeDetailTopInfo();
    	
     	//계산된 컬럼의 색상을 원복시킨다.
     	changeCalcColumn(false);
     	
     	//Row 추가시 Charge Detail per BKG 데이터가 없기 때문에 D/C AMT or Ratio Pre Cal., Reset 버튼 비활성화
     	//D/C AMT or Ratio Pre Cal., Reset 버튼 활성화 (2009-11-06(금)) ========================================
     	ComBtnDisable("btn_PreCalc");
     	ComBtnDisable("btn_Reset");
     	//====================================================================================================     	
    }
    
   /**
    * Delete 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */		
    function doActionDelADJAfterBKG() {
    	var formObj = document.form;    	
    	var sheetBKGObj = sheetObjects[0];

    	with(sheetBKGObj) {
	    	if (SelectRow >= HeaderRows) {
				//Billable Amount per CNTR 정보도 삭제해준다.
				doActionDelADJAfterBKGContainer(SelectRow);
				
				if (RowStatus(SelectRow) == 'I') {
					RowDelete(SelectRow, false);
				}
				else {
					RowStatus(SelectRow) = 'D';
					RowHidden(SelectRow) = true;
				}

				//1.행이 삭제된 후 자동으로 선택되어질 다음 행을 찾는다.
				var row = fetchSelectedNextRow(SelectRow);
				//1-1.보여줄 행이 있다면
				if (row != -1) {
					SelectRow = row;
					displayChargeDetailperBKG(row);
				}				
				
		     	//계산된 컬럼의 색상을 원복시킨다.
		     	changeCalcColumn(false);
		    	
		 		//After Booking 정보가 모두 삭제된 경우 S/C No., RFA No., Customer 정보를 삭제해 준다.
		 		if (getAfterBKGCount() < 1) {
		 			ComClearObject(formObj.scNo);
		 			ComClearObject(formObj.rfaNo);
		 			ComClearObject(formObj.custCd);
		 			ComClearObject(formObj.custNm);
		 		}				
			}
    	}
    }
    
   /**
    * BKG 데이터가 삭제될 경우 그 하위 Container 정보도 삭제처리해 주는 함수
    */	    
    function doActionDelADJAfterBKGContainer(selectRow) {
    	var formObj = document.form;
    	var sheetBKGObj = sheetObjects[0];
    	var sheetCNTRObj = sheetObjects[1];
    	
    	var adjSeq = sheetBKGObj.CellValue(selectRow, ADJ_SEQ);
    	var status = sheetBKGObj.RowStatus(selectRow);
    	
 		//Charge Header 정보 삭제
 		ComClearObject(formObj.cntrQty);
 		ComClearObject(formObj.curr);
 		ComClearObject(formObj.totalBillAmt);
 		
    	with(sheetCNTRObj) {
    		for (var row = LastRow ; row >= HeaderRows ; row--) {
    			if (RowStatus(row) != "D" && adjSeq == CellValue(row, ADJ_SEQ)) {
    				
    				if (RowStatus(row) == "I" || status == "I") {
    					RowDelete(row, false);
    				}
    				else {
    					RowStatus(row) = 'D';
    					RowHidden(row) = true;
    				}
    			}
    		}
    	}
    }
    
    /**
     * D/C AMT or Ratio Per Cal. 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */
     // 2011.12.08 부터 사용하지 않음 이후 재 사용시 내부 로직 수정 필요함. EES_DMT_2008.js 참고 
     function doActionPreCalc() {
     	var formObj = document.form;
     	var sheetBKGObj = sheetObjects[0];
     	var sheetCNTRObj = sheetObjects[1];

     	//이미 클릭된 상태라면 클릭되지 않도록 처리한다.
     	if (isCalculated()) return;
     	
     	with(sheetBKGObj) {
     		var adjSeq = CellValue(SelectRow, ADJ_SEQ);
     		var cntrTp = CellValue(SelectRow, CNTR_TP);
     		var dcArFlg = CellValue(SelectRow, DCAR_FLG);
     	}
     	
     	var total = 0;
     	var bilAmt = "";
     	var disAmt = "";
     	var disRto = "";
     	
     	//CNTR 이 'All' 로 선택되어 있다면, BKG 에 입력된 D/C Amount or Ratio 의 AMT 나 Ratio 를 Charge Container 로 복사한다.
     	if (cntrTp == "S") {
     		copyDCAmountOrRatioToChargeContainer();
     	}
     	
     	with(sheetCNTRObj) {
     		for (var row = HeaderRows ; row <= LastRow ; row++) {
     			if (RowStatus(row) != "D" && RowHidden(row) == false && adjSeq == CellValue(row, ADJ_SEQ)) {

     				//D/C AMT or Ratio Pre Cal.에 체크된 항목에 대해서만 아래 로직을 수행합니다.(2009-11-05 목)
     				if (dcArFlg == 1 || CellValue(row, AR_FLG) == 1) {
 	    				if (CellValue(row, GB) == "G") {
 	    					if (CellValue(row, AR_AMT) == "" && CellValue(row, AR_RTO) == "") {
 	    	     				//D/C AMT, Ratio 에 입력된 값이 없을 경우 "Pls input D/C Amount or Ratio" Alert창 띄우며 막음(2009-10-07(수))
	    	     				if (cntrTp == "S") {
	    	     					ComShowCodeMessage("DMT00168", sheetBKGObj.CellValue(sheetBKGObj.SelectRow, "Seq"));
	    	     					removeDCAmountOrRatioToChargeContainer();
	    	     				}
	    	     				else {
	    	     					ComShowCodeMessage("DMT00168", CellValue(row, "Seq"));	
	    	     				} 	    	     				
 	  	     					return;     						
 	    					}
 	    					else if (CellValue(row, AR_AMT) != "" && CellValue(row, AR_RTO) != "") {
 	    	     				//D/C AMT, Ratio 에 둘다 입력되어있을 경우  Alert창 띄우며 막음(2009-11-04(수))
	    	     				if (cntrTp == "S") {
	    	     					ComShowCodeMessage("DMT02012", sheetBKGObj.CellValue(sheetBKGObj.SelectRow, "Seq"));
	    	     					removeDCAmountOrRatioToChargeContainer();
	    	     				}
	    	     				else {
	    	     					ComShowCodeMessage("DMT02012", CellValue(row, "Seq"));	
	    	     				} 	    	     				
 	  	     					return;     						
 	    					}
 	    					else if (CellValue(row, AR_AMT) != "") {
 	    						disAmt = CellValue(row, AR_AMT);
 	    						disRto = "";
 	    					}
 	    					else if (CellValue(row, AR_RTO) != "") {
 	    						disAmt = "";
 	    						disRto = CellValue(row, AR_RTO);
 	    					}
 	    				}
 	    				
 	    				if (disAmt != "") {
 	    					bilAmt = CellValue(row, BIL_AMT) - disAmt;
 	    				}
 	    				else if (disRto != "") {
 	    					// 2010-05-31 수정
	    					bilAmt = CellValue(row, BIL_AMT) - CellValue(row, BIL_AMT) * disRto / 100;
	    					bilAmt = ComRound(bilAmt, 2);
 	    				}
 	    				else {
 	    					bilAmt = CellValue(row, BIL_AMT);
 	    				}
 	    				
 	    				//Billable AMT는 항상 0.00 이상이어야함. 즉, 마이너스 금액이 나오면 안됨(2009-11-04(수))
 	    				bilAmt = bilAmt >= 0 ? bilAmt : 0;
 	    				CellValue(row, BIL_AMT) = bilAmt;
     				}
     				
     				// 2010-05-25 수정
    				total = total + parseFloat(CellValue(row, BIL_AMT));
    				
     			}
     		} // for - end
     	} // with - end
     	
     	// 2010-05-25 추가
    	total = ComRound(total, 2);
     	
     	ComSetObjValue(formObj.totalBillAmt, ComAddComma2(total + "", "#,###.00"));
     	
     	//Calculation 을 완료하면 버튼과 계산컬럼의 색상을 빨간색으로 변경한다.
     	changeCalcColumn(true);
    	
     	//CNTR 이 'All' 로 선택되어 있다면, BKG 에 입력된 D/C Amount or Ratio 의 AMT 나 Ratio 를 Charge Container 로 복사한 정보를 삭제한다.
     	if (cntrTp == "S") {
     		removeDCAmountOrRatioToChargeContainer();
     	}      	
     }
     
    /**
     * Reset 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */
  // 2011.12.08 부터 사용하지 않음 이후 재 사용시 내부 로직 수정 필요함. EES_DMT_2008.js 참고 
     function doActionReset() {
     	var formObj = document.form;
     	var sheetBKGObj = sheetObjects[0];
     	var sheetCNTRObj = sheetObjects[1]
     	                                
     	var bkgNo = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, BKG_NO);
     	var tariff = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, TARIFF);
     	
     	var total = 0;
     	
     	with(sheetCNTRObj) {
     		for (var row = HeaderRows ; row <= LastRow ; row++) {
     			if (	RowStatus(row) != "D" 
     				&&	RowHidden(row) == false
     				&& 	bkgNo == CellValue(row, BKG_NO)
     				&& 	tariff == CellValue(row, TARIFF)	) {
     				CellValue(row, BIL_AMT) = CellValue(row, ORG_BIL_AMT);
     				
     				// 2010-05-25 수정
     				total = total + parseFloat(CellValue(row, BIL_AMT));
     			}
     		}
     	}
     	//구한 합을 Total Billable Amount 에 설정해준다.
     	ComSetObjValue(formObj.totalBillAmt, ComAddComma2(total + "", "#,###.00"));
     	
     	//계산된 컬럼의 색상을 원복시킨다.
     	changeCalcColumn(false);     	
     }      
    
    /**
     * Retrieve 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */		
    function doActionRetrieve() {
     	var formObj 		= document.form;    	 
    	var sheetBKGObj 	= sheetObjects[0];
    	var sheetCNTRObj 	= sheetObjects[1];
    	var sheetHSTObj 	= sheetObjects[2];
    	
     	//조회전 계산된 컬럼의 색상을 원복시킨다.
     	changeCalcColumn(false);
     	
    	//조회 전 필수 입력값을 체크한다.(DAR No. 또는 APVL No. 없으면 "Please enter DAR No. or APVL No." Alert창 띄움)
    	with(formObj) {
    		if (ComTrim(ComGetObjValue(darNo)) == "" && ComTrim(ComGetObjValue(apvlNo)) == "") {
    			ComShowCodeMessage("DMT00166");
    			ComSetFocus(darNo);
    			return;
    		}
    	}
    	
    	//등록된 After Booking DAR 정보를 조회한다. 
    	doActionIBSheet(sheetBKGObj,formObj,IBSEARCH);
    	
		//--------------------------------------------------------------------
		currAdjSeq = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, ADJ_SEQ);
		//--------------------------------------------------------------------
		
    	with(sheetBKGObj) {
			//3.조회된 After Booking Adjustment Request 이 존재한다면 Container 와 Comment History 목록을 조회한다.
			if (RowCount > 0) {
				//3-1.Container 목록을 조회한다.
		    	//    조회하기전 Charge Detail per BKG 를 After Booking 에서 읽어올 것인지 Charge Calculation 에서 
		    	//    읽어올 것인지 설정해준다.(이 경우에는 After Booking 에서 읽어온다. 2009-11-02)
		    	ComSetObjValue(formObj.is_aft_bkg_cntr, "Y");
				doActionIBSheet(sheetCNTRObj,formObj,IBSEARCH_CNTRCHG_BKG);
				
				//3-2.DMT03 권한을 가진 사용자일 경우 Approval, Counter Offer, Reject 권한이 있는지 조회한다.
				if (ComGetObjValue(formObj.role_auth) == "DMT03")
					check03RoleAuth();
				
				//3-3.Status 가 공란이거나, Counter Offered 상태일 때에만 Grid 활성화
				enableGrid(isEnableGrid());
				
				//3-4.CNTR 에 따라서 Free Time, F/Time EXCL, D/C Amount or Ratio 활성화 혹은 비활성화 처리한다.
				//    (인자는 비활성화시 존재하는 값을 삭제할지를 나타낸다)
				modifyModeFreeTimeAmountorRatio(false);
				
				//3-5.Comment History 목록을 조회한다.
				doActionIBSheet(sheetHSTObj,formObj,IBSEARCH_COMM);				
			}
			else {
				ComShowCodeMessage("DMT06001");
				if (ComTrim(ComGetObjValue(formObj.darNo)) != "") {
					ComSetFocus(formObj.darNo);	
				}
				else {
					ComSetFocus(formObj.apvlNo);
				}
			}
    	}
   		
    	//4.조회된 모든 Row 의 상태를 읽기 상태로 변경해준다.
    	for (var sheetNo = 0 ; sheetNo < 2 ; sheetNo++) {
    		with(sheetObjects[sheetNo]) {
    			for (var row = HeaderRows ; row <= LastRow ; row++) {
    				RowStatus(row) = "R";
    			}
    		}
    	}
    	
    	//5.버튼의 상태를 변경해준다.
    	initBtnControl();
    }
   
    /**
     * Retrieve 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */		
    function doActionNew() {
        var formObj = document.form;
        var sheetBKGObj = sheetObjects[0];
        var sheetCNTRObj = sheetObjects[1];
        var sheetHSTObj = sheetObjects[2];
        
        //조회된 결과 그리드를 지워준다.
        sheetBKGObj.RemoveAll();
        sheetCNTRObj.RemoveAll();
        sheetHSTObj.RemoveAll();
        
        //조회필드를 지워준다.
        with(formObj) {
	        ComSetObjValue(approvalOfcCd, "");
	        ComClearObject(darNo);
	        ComClearObject(apvlNo);
	        ComClearObject(status);;
	        ComClearObject(scNo);
	        ComClearObject(rfaNo);
	        ComClearObject(custCd);
	        ComClearObject(custNm);
	        ComClearObject(cntrQty);
	        ComClearObject(curr);
	        ComClearObject(totalBillAmt);
	        
	        //비활성화 상태의 조회필드들을 활성화  시킨다.
   	 		ComEnableManyObjects(true, darNo, apvlNo);
   	 		darNo.className 	= "input";
   	 		apvlNo.className 	= "input";
   	 		
			//Comment 초기화 +++++++++++++++++++++++++++++++++++
			chkComment.checked 		= false;
			
			comment.readOnly 		= true;
			comment.className 		= "textarea2";
			ComSetObjValue(comment, "");
			//+++++++++++++++++++++++++++++++++++++++++++++++++	 		
        }
        //계산된 컬럼의 색상을 원복시킨다.
     	changeCalcColumn(false);
     	
		//버튼 초기화
		initBtnControl();
		
		//Charge Detail for BKG 의 Free Time, F/Time EXCL, D/C Amount or Ratio 컬럼들을 감춘다.
		hideContainerColumn(true);
		
		//DAR No.에 포커스를 준다.
		ComSetFocus(formObj.darNo);		
    }
    
    /**
     * Request 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */		
    function doActionRequest() {
      	var formObj 	= document.form;
     	var sheetBKGObj = sheetObjects[0];

     	if (sheetBKGObj.RowCount < 1) {
     		ComShowCodeMessage("DMT00128");
     		return;
     	}

     	//Request 하기 전에 입력값에 대한 Validation Check 를 수행한다.
		if (validateForm(sheetBKGObj,formObj,IBSAVE)) {

			//DAR No. 가 없을 경우 DAR No. 를 자동생성
			if (sheetBKGObj.CellValue(sheetBKGObj.HeaderRows, DAR_NO) == "") {
				//새로운 생성된 DAR No. 를 조회한다.
				doActionIBSheet(sheetBKGObj,formObj,IBSEARCH_DAR);
				//조회된 DAR No. 를 조회컬럼에 설정해준다.
				ComSetObjValue(formObj.darNo, ComGetObjValue(formObj.result));
				//조회된 DAR No. 를 BKG, CNTR 의 모든 데이터에 설정해준다.
				setNewDARNo(ComGetObjValue(formObj.darNo));
			}
			
			//Request 를 수행하기 전에 CNTR TYPE 이 Different 일 경우에는 Charge Detail per BKG 의 
			//Cur. 컬럼에 설정된  값을 BKG 의 Cur. 에 설정해준다.
			setCurrencyBKGContainer();

			//Request 를 수행하기 전에 Charge 가 존재할 경우 Container Flag 를 'Y' 로 설정해준다.
			setFlagBKGContainer();
			
			//Request 를 수행한다.
			doActionIBSheet(sheetBKGObj,formObj,IBSAVE);
			
			//Request Action 이 정상실행시 조회를 실행한다.
			if (ComTrim(ComGetObjValue(formObj.result)) == "Y") {
				//2006 번 화면에서 팝업으로 띄운경우 현재 화면에서 실행된 Action 에 따라서 2006 번 화면에 조회된 결과에 반영하기 위해서 사용함.
				prevActStatus = ComGetObjValue(formObj.status);
				
				doActionRetrieve();
				
			   	//2006번(DEM/DET Adjustment Request & Approval Status) 화면에서 호출될 경우
				//Request 내역을 Main 화면에 반영시켜준다.
		        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
		        	commitMainScreen("Requested");
		        } 					
			}			
		}
    }
    
    /**
     * Cancel 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */		
    function doActionCancel() {
    	var sheetBKGObj = sheetObjects[0];
    	var formObj = document.form;

		if (!ComShowCodeConfirm("DMT00135", "cancel this request")) { return; }
		

		
		//Cancel Action 을 수행한다.			
		doActionIBSheet(sheetBKGObj,formObj,IBSAVE_CANCEL);
		
		//저장 Action 이 정상실행시 조회를 실행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			//2006 번 화면에서 팝업으로 띄운경우 현재 화면에서 실행된 Action 에 따라서 2006 번 화면에 조회된 결과에 반영하기 위해서 사용함.
			prevActStatus = ComGetObjValue(formObj.status);
			
			doActionRetrieve();
			
		   	//2006번(DEM/DET Adjustment Request & Approval Status) 화면에서 호출될 경우
			//Cancel 내역을 Main 화면에 반영시켜준다.
	        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen("Cancel");
	        } 			
		}   	
    }    
    
     /**
      * Approval 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
      */		
     function doActionApproval() {
    	var formObj 	= document.form;
     	var sheetBKGObj = sheetObjects[0];

     	//===================================================================================
		// Data 변경 후 Approval 버튼 누르면  일반적인 "Do you want to approve?" 문구 대신에
	    // "Data was changed. Do you want to approve with changed data?" 문구 띄우고
	    // Yes 선택시 data 입력 내용 validation 하고 바로 변경된 내용으로 DAR 적용 부탁드립니다.
     	//===================================================================================
		isChangedData = false;
		for (var sheetNo = 0 ; sheetNo < 2 ; sheetNo++) {
			with(sheetObjects[sheetNo]) {
				for (var row = HeaderRows ; row <= LastRow ; row++) {
					if (RowStatus(row) == "U") {
						isChangedData = true;
						break;
					}
				}
			}
			if (isChangedData) break;
		}
		
		if (isChangedData) {
			if (!ComShowCodeConfirm("DMT01136")) { return; }
		}
		else {
			if (!ComShowCodeConfirm("DMT00135", "approve")) { return; }
		}

     	// [CHM-201433113] APVL OFC : SELHO인 경우 로그인 OFC의 OFC LEVEL '1'이 아닌경우 제한  2014.12.09
     	if (!checkOfcLvlByAplvOfc()) { return; }	
     	
		//입력된 값에 대한 유효성을 체크한다.
		if (validateForm(sheetBKGObj, formObj, IBSAVE_APPROVAL)) {
			//Request 를 수행하기 전에 CNTR TYPE 이 Different 일 경우에는 Charge Detail per BKG 의 
			//Cur. 컬럼에 설정된  값을 BKG 의 Cur. 에 설정해준다.
			setCurrencyBKGContainer();

			//Request 를 수행하기 전에 Charge 가 존재할 경우 Container Flag 를 'Y' 로 설정해준다.
			setFlagBKGContainer();

			//Approval Action 을 수행한다.			
			doActionIBSheet(sheetBKGObj, formObj, IBSAVE_APPROVAL);
		}
     } 
     
     /**
      * CounterOffer 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
      */		
     function doActionCounterOffer() {
     	var sheetBKGObj = sheetObjects[0];
     	var formObj = document.form;

 		if (!ComShowCodeConfirm("DMT00135", "counter offer")) { return; }

     	// [CHM-201433113] APVL OFC : SELHO인 경우 로그인 OFC의 OFC LEVEL '1'이 아닌경우 제한  2014.12.09
     	if (!checkOfcLvlByAplvOfc()) { return; }	
     	
		//COUNTER OFFER 실행시 Comment 는 필수입력사항이다.				
		if (!validateComment()) return;
		
 		//Cancel Action 을 수행한다.			
 		doActionIBSheet(sheetBKGObj,formObj,IBSAVE_COUNTEROFFER);
 		
 		if(ComGetObjValue(formObj.apvlNo) == '') {
	 		//CounterOffer Action 이 정상실행시 조회를 실행한다.
	 		if (ComGetObjValue(formObj.result) == "Y") {
	 			ComShowCodeMessage("DMT00160", "counter offered");
	 			
				//2006 번 화면에서 팝업으로 띄운경우 현재 화면에서 실행된 Action 에 따라서 2006 번 화면에 조회된 결과에 반영하기 위해서 사용함.
				prevActStatus = ComGetObjValue(formObj.status);
			
	 			doActionRetrieve();
	 			
			   	//2006번(DEM/DET Adjustment Request & Approval Status) 화면에서 호출될 경우
				//승인한 내역을 Main 화면에 반영시켜준다.
		        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
		        	commitMainScreen("CounterOffer");
		        } 			
	 		}
 		}
     } 
     
    /**
     * Reject 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
     */		
    function doActionReject() {
     	var sheetBKGObj = sheetObjects[0];
     	var formObj = document.form;

 		if (!ComShowCodeConfirm("DMT00135", "reject")) { return; }

     	// [CHM-201433113] APVL OFC : SELHO인 경우 로그인 OFC의 OFC LEVEL '1'이 아닌경우 제한  2014.12.09
     	if (!checkOfcLvlByAplvOfc()) { return; }	

		//REJECT 실행시 Comment 는 필수입력사항이다.				
		if (!validateComment()) return;
		
 		//Cancel Action 을 수행한다.			
 		doActionIBSheet(sheetBKGObj,formObj,IBSAVE_REJECT);
 		
 		if(ComGetObjValue(formObj.apvlNo) == '') {
	 		//Reject Action 이 정상실행시 조회를 실행한다.
	 		if (ComGetObjValue(formObj.result) == "Y") {
	 			ComShowCodeMessage("DMT00160", "rejected");
	 			
				//2006 번 화면에서 팝업으로 띄운경우 현재 화면에서 실행된 Action 에 따라서 2006 번 화면에 조회된 결과에 반영하기 위해서 사용함.
				prevActStatus = ComGetObjValue(formObj.status);
				
	 			doActionRetrieve();
	 			
			   	//2006번(DEM/DET Adjustment Request & Approval Status) 화면에서 호출될 경우
				//승인한 내역을 Main 화면에 반영시켜준다.
		        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
		        	commitMainScreen("Reject");
		        }
	 		}    
 		}
    } 
     
   /**
    * Close 버튼이 클릭되었을 경우 실행해야할 동작을 정의하는 함수
    */
    function doActionClose() {
     	
		window.close();
    }
     
    /**
	 * 조회된 결과에 따른 버튼의 상태를 일괄적으로 변경해주는 함수
	 */	    
    function initBtnControl() {
		var formObj = document.form;
		var sheetBKGObj = sheetObjects[0];
		
		
        //2006번 화면에서 팝업으로 띄우는 After Booking 화면은 Retrieve와 New는 비활성화하는 것이 나을듯(2009-11-12(목))
        if (ComGetObjValue(formObj.caller) == "2006") {
        	ComBtnDisable("btn_Retrieve");
        	ComBtnDisable("btn_New");
        }
        else {
        	ComBtnEnable("btn_Retrieve");
        	ComBtnEnable("btn_New");
        }		
		
		//1.화면 버튼의 상태를 설정한다.######################
    	//Request 버튼의 상태를 초기화 시킨다.
    	initBtnRequest();
    	//Cancel 버튼의 상태를 초기화 시킨다.
    	initBtnCancel();
    	//Approval 버튼의 상태를 초기화 시킨다.
    	initBtnApproval();
    	//Counter Offer 버튼의 상태를 초기화 시킨다.
    	initBtnCounterOffer();
    	//Reject 버튼의 상태를 초기화 시킨다.
    	initBtnReject();
    	
    	//2.D/C AMT or Ratio Pre Cal., Reset 버튼의 상태를 설정한다.(2009-11-06(금)) ================================================
//  2011.12.09 기능 막음.
//    	if (sheetBKGObj.RowCount > 0 && fetchChargeRowCount() > 0) {
//    		ComBtnEnable("btn_PreCalc");
//    		ComBtnEnable("btn_Reset");
//    	}
//    	else {
//    		ComBtnDisable("btn_PreCalc");
//    		ComBtnDisable("btn_Reset");    		
//    	}
    	//========================================================================================================================    	
    }
    
    /**
	 * 조회된 결과에 따른 Request 버튼의 상태를 변경해주는 함수
	 */	     
    function initBtnRequest() {
    	var formObj = document.form;
    	var sheetBKGObj = sheetObjects[0];
    	
    	var rqstOfcCd = "";
    	with(sheetBKGObj) {
    		if (RowCount > 0) rqstOfcCd = CellValue(HeaderRows, RQST_OFC_CD);
    	}
    	
    	var status = ComTrim(ComGetObjValue(formObj.status));
    	//1.Status 가 없으면 활성화
    	//[9/25] 2009화면상에서는 조회되는 DAR에 대해서만 Request (수정)만 가능하므로, STS가 공란일 경우에는 Request 버튼 비활성화(2009-11-02일 수정)
    	if (status == "") {
    		ComBtnDisable("btn_AddBkgReq");
			ComBtnDisable("btn_DelBkgReq");

    		ComBtnDisable("btn_Request");
    	}
    	//2.Status 가 Counter Offered 이면서 로그인 점소가 Request 점소와 동일할 경우 활성화 
    	//2012.09.04 User id 소속 Office로 변경함. 
    	else if (status == "Counter Offered" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) {
    		ComBtnEnable("btn_AddBkgReq");
    		ComBtnEnable("btn_DelBkgReq");

    		ComBtnEnable("btn_Request");
    	}
    	//3.Status 가 Request 일 경우, 로그인 점소가 Request 점소와 동일할 경우 활성화
    	//2012.09.04 User id 소속 Office로 변경함. 
    	else if (status == "Requested" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) {
    		ComBtnEnable("btn_AddBkgReq");
    		ComBtnEnable("btn_DelBkgReq");
    		
    		ComBtnEnable("btn_Request");
    	}
    	else {
    		ComBtnDisable("btn_AddBkgReq");
			ComBtnDisable("btn_DelBkgReq");
			
    		ComBtnDisable("btn_Request");
    	}
    }
    
    /**
	 * 조회된 결과에 따른 Cancel 버튼의 상태를 변경해주는 함수
	 */	     
    function initBtnCancel() {
    	var formObj 	= document.form;
    	var sheetBKGObj = sheetObjects[0];
    	
    	var rqstOfcCd = "";
    	with(sheetBKGObj) {
    		if (RowCount > 0) rqstOfcCd = CellValue(HeaderRows, RQST_OFC_CD);
    	}
    	
    	//1.Status 가 Requested 인 경우 로그인 점소와  Request 점소가 동일할 경우 활성화
    	var status = ComTrim(ComGetObjValue(formObj.status));
    	if ((status == "Requested" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd) ) || 
    			(status == "Counter Offered" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd)) )
    		ComBtnEnable("btn_Cancel");
    	else
    		ComBtnDisable("btn_Cancel");
   }
	 
    /**
	 * 조회된 결과에 따른 Approval 버튼의 상태를 변경해주는 함수
	 */	     
    function initBtnApproval() {
    	//1.아래 모든 조건이 PASS 되어야만 활성화가 된다.
    	//1-1.로그인 User 가 Security 상에서 UI_DMT_2009(DAR-After BKG Approval) 의 Access 권한이 있을 경우 활성화
    	var isPass1 = isPermitRole();
    	    	
    	//1-2.Approval Office 와 로그인 점소의 소속 지역본부/본수(NYCRA, HAMRU, SHARC, SINRS, SELHO) 가 동일할 경우에만 활성화
    	var isPass2 = isMatchOffice();
    	    	
    	//1-3.Status 가 "Requested", "Counter Offered", "Rejected" 상태에서는 활성화 및 Status 가 공란, "Cancelled", "Approved" 상태에서는 비활성화
    	var isPass3 = isPermitStatus("Approval");
    	    	
    	if (isPass1 && isPass2 && isPass3) {
    		ComBtnEnable("btn_Approval");
    	}
    	else {
    		ComBtnDisable("btn_Approval");
    	}
	 }
	 
    /**
	 * 조회된 결과에 따른 Counter Offer 버튼의 상태를 변경해주는 함수
	 */	     
    function initBtnCounterOffer() {
    	//1.아래 모든 조건이 PASS 되어야만 활성화가 된다.
    	//1-1.로그인 User 가 Security 상에서 UI_DMT_2009(DAR-After BKG Approval) 의 Access 권한이 있을 경우 활성화
    	var isPass1 = isPermitRole();

    	//1-2.Approval Office 와 로그인 점소의 소속 지역본부/본수(NYCRA, HAMRU, SHARC, SINRS, SELHO) 가 동일할 경우에만 활성화
    	var isPass2 = isMatchOffice();
    	
    	//1-3.Status 가 "Requested", "Counter Offered", "Rejected" 상태에서는 활성화 및 Status 가 공란, "Cancelled", "Approved" 상태에서는 비활성화
    	var isPass3 = isPermitStatus("CounterOffer");
    	
    	if (isPass1 && isPass2 && isPass3) {
    		ComBtnEnable("btn_CounterOffer");
    	}
    	else {
    		ComBtnDisable("btn_CounterOffer");
    	}
	}
	 
    /**
	 * 조회된 결과에 따른 Counter Offer 버튼의 상태를 변경해주는 함수
	 */	     
    function initBtnReject() {
    	//1.아래 모든 조건이 PASS 되어야만 활성화가 된다.
    	//1-1.로그인 User 가 Security 상에서 UI_DMT_2009(DAR-After BKG Approval) 의 Access 권한이 있을 경우 활성화
    	var isPass1 = isPermitRole();

    	//1-2.Approval Office 와 로그인 점소의 소속 지역본부/본수(NYCRA, HAMRU, SHARC, SINRS, SELHO) 가 동일할 경우에만 활성화
    	var isPass2 = isMatchOffice();
    	
    	//1-3.Status 가 "Requested", "Counter Offered", "Rejected" 상태에서는 활성화 및 Status 가 공란, "Cancelled", "Approved" 상태에서는 비활성화
    	var isPass3 = isPermitStatus("Reject");
    	
    	if (isPass1 && isPass2 && isPass3) {
    		ComBtnEnable("btn_Reject");
    	}
    	else {
    		ComBtnDisable("btn_Reject");
    	}
   }

    /**
	 * 로그인 User 가 Security 상에서 EES_DMT_2009(DAR-After BKG Approval)의 Access 권한이 있는지 결과를 반환하는 함수
	 */	 
    function isPermitRole() {
        var formObj 	= document.form;
        var isPermit 	= false;

        var roleAuth	= ComGetObjValue(formObj.role_auth);
        var rolePermit	= ComGetObjValue(formObj.role_permit);
        
    	if (roleAuth == "DMT01" || roleAuth == "DMT02" || roleAuth == "DMT03") {
    		if (rolePermit == "Y")
    			isPermit = true;
    	}
		return isPermit
	}
	 
    /**
	 * Approval Office 와 로그인 점소의 소속 지역본부/본수(NYCRA, HAMRU, SHARC, SINRS, SELHO) 가 동일한지 결과를 반환하는 함수
	 */	 
	function isMatchOffice() {
	    var formObj = document.form;
	    	
		 
		with(formObj) {
			var avalOfcCd = ComGetObjValue(formObj.approvalOfcCd);
			var usrRhqCd = ComGetObjValue(formObj.usr_rhq_cd);
			
			// 1. APVL Office == 사용자 Office의 AR Head Querter Office
			// 2. APVL Office (SELIB/TYOIB) 일 경우 SELHO 도 승인 가능. (VVOIA 추가)
		    if (( avalOfcCd == usrRhqCd) ||
		    	((avalOfcCd == "SELIB" || avalOfcCd == "TYOIB" || avalOfcCd == "VVOIA")
		    	&& (usrRhqCd == "SELHO"))) {
		    	return true;
		    }
		}
		
		return false;
	}

    /**
	 * Status 값에 따라 버튼의 활성화 여부를 반환해주는 함수
	 */	     
	function isPermitStatus(sts) {
	    var formObj = document.form;
	 
	    var status = ComTrim(ComGetObjValue(formObj.status));
		if (sts == "Approval") {
			if (status == "Requested" || status == "Counter Offered" || status == "Rejected")
			    return true;
		}
	    else if (sts == "CounterOffer") {
			if (status == "Requested" || status == "Approved" || status == "Rejected")
			    return true;
	    }
	    else if (sts == "Reject") {
			if (status == "Requested" || status == "Counter Offered" || status == "Approved")
			    return true;
	    }
	    
		return false;
	}
		 
 	/**
 	 * ROW Add or Copy 시 다음 BKG Sequence 를 구하는 함수
 	 */		
 	function fetchNextADJSeq() {
 		var formObj = document.form;
 		var sheetBKGObj = sheetObjects[0];
 		
 		var prevSeq = 0;
 		var currSeq = 0;
 		with(sheetBKGObj) {
 			for (var row = HeaderRows ; row <= LastRow ; row++) {
 				currSeq = ComParseInt(CellValue(row, ADJ_SEQ));
 				prevSeq = currSeq > prevSeq ? currSeq : prevSeq;
			}
 		}

 		return prevSeq + 1;
 	} 
	
	/**
	 * 선택한 BKG 데이터에 해당되는 Billable Amount per CNTR 정보를 보여준다.
	 */		
	function showBillableAmountPerCNTR() {
		var sheetBKGObj = sheetObjects[0];
		var sheetCNTRObj = sheetObjects[1];
		
		with(sheetBKGObj) {
			var bkgNo = CellValue(SelectRow, BKG_NO);
			var tariff = CellValue(SelectRow, TARIFF);
			var adjSeq = CellValue(SelectRow, ADJ_SEQ);
		}
		
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				
				if (	RowStatus(row) != "D"
					&& 	bkgNo == CellValue(row, BKG_NO) 
					&&	tariff == CellValue(row, TARIFF)
					&&	adjSeq == CellValue(row, ADJ_SEQ)	) {
				
					//ROW 를 보여준다.
					RowHidden(row) = false;
				}
				else {
					//ROW 를 숨긴다.
					RowHidden(row) = true;
				}
			}
		}
	}

	/**
	 * 선택한 BKG 데이터에 해당되는 Billable Amount per CNTR 정보의 Total 을 구한다.
	 */	    
    function sumBillableAmount() {
    	var formObj = document.form;
		var sheetBKGObj = sheetObjects[0];
		var sheetCNTRObj = sheetObjects[1];
		var isSumed = false;
		var total = 0;
		var dc_amt = 0;
		var bil_amt = 0;
		var finalAmtcnt = 0 ;
		
		with(sheetBKGObj) {
			var bkgNo = CellValue(SelectRow, BKG_NO);
			var tariff = CellValue(SelectRow, TARIFF);
			var adjSeq = CellValue(SelectRow, ADJ_SEQ);
		}
		
		with(sheetCNTRObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (	RowStatus(row) != "D"
					&&	RowHidden(row) == false
					&& 	bkgNo == CellValue(row, BKG_NO) 
					&&	tariff == CellValue(row, TARIFF) 
					&&	adjSeq == CellValue(row, ADJ_SEQ)	) {
					
					if (!isSumed) isSumed = true;
					CellValue2(row, BIL_AMT) = CellValue(row, ORG_BIL_AMT);
					
					if (CellValue(row, DC_AMT) == "") {
					    dc_amt = 0;
					}
					else {
					    dc_amt = parseFloat(CellValue(row, DC_AMT));
					}
					bil_amt = parseFloat(CellValue(row, BIL_AMT));
					
//					// 2010-05-25 수정
//					total = total + parseFloat(CellValue(row, BIL_AMT));
					
					if (bil_amt < dc_amt) {
						total = total;
					}
					else {
					     total = ComRound((total + bil_amt - dc_amt), 2);
					}
					if (CellValue(row, DC_AMT) != "" ) {
						finalAmtcnt = finalAmtcnt+1;
					}
				}
			}
		}
		
		if (!isSumed) total = "";
		//구한 합을 Total Billable Amount 에 설정해준다.
		if (finalAmtcnt == 0){
			ComSetObjValue(formObj.totalBillAmt, "");
		}else{
		    ComSetObjValue(formObj.totalBillAmt, ComAddComma2(total + "", "#,###.00"));
		}
    }
    
    /**
     * Charge Container 의 Currency 를 Booking 의 Currency 로 설정해주는 함수
     * Currency 정보를 저장하기 위해서는 BKG 그리드에 저장을 해야하기 때문이다.
     */	 
     function setCurrencyBKGContainer() {
       	var sheetBKGObj 	= sheetObjects[0];
       	var sheetCNTRObj 	= sheetObjects[1];

       	with(sheetBKGObj) {
 	      	for (var row = HeaderRows ; row <= LastRow ; row++) {
 	      		var cntrTp = CellValue(row, CNTR_TP);
 	      		var adjSeq = CellValue(row, ADJ_SEQ);
 	      		
 	      		if (cntrTp == "D") {
	 	      		for (var subRow = sheetCNTRObj.HeaderRows ; subRow <= sheetCNTRObj.LastRow ; subRow++) {
	 	      			if (sheetCNTRObj.RowStatus(subRow) != "D" && adjSeq == sheetCNTRObj.CellValue(subRow, ADJ_SEQ)) {
	 	      				var currCd = ComTrim(sheetCNTRObj.CellValue(subRow, DCAR_CURR));
	 	      				if (currCd != "") {
	 	      					CellValue2(row, DCAR_CURR) = currCd;
	 	      					break;
	 	      				}
	 	      			}
	 	      		}
 	      		}
 	      	}
       	}
    }
     
   /**
 	* BOOKING에 해당하는 Container들에 Discount금액이나 Ratio를 각 Container별로 입력가능한지를 나타내주는 함수
 	*/	 
 	function setFlagBKGContainer() {
     	var sheetBKGObj = sheetObjects[0];

     	with(sheetBKGObj) {
 	      	for (var row = HeaderRows ; row <= LastRow ; row++) {
 	      		var cntrTp = CellValue(row, CNTR_TP);
 	      		var adjSeq = CellValue(row, ADJ_SEQ);
 	      		
 	      		//삭제되지 않은 항목에 대해서만 처리해준다.
 	      		if (RowStatus(row) != "D") {
 		      		//CNTR 을 'All' 선택시
 		      		if (cntrTp == "S") {
 		      			CellValue2(row, CNTR_FLG) = "N";
 		      		}
 		      		//CNTR 을 'Different' 선택시
 		      		else if (cntrTp == "D") {
 		      			CellValue2(row, CNTR_FLG) = "Y";
 		      		}
 	      		}
 	      	}
     	}
    }
 	
   /**
    * 신규조회된 DAR No. 를 BKG, Container 에 설정해준다.
    */	     
	function setNewDARNo(darNo) {
      	var sheetBKGObj = sheetObjects[0];
      	var sheetCNTRObj = sheetObjects[1];

      	with(sheetBKGObj) {
      		for (var row = HeaderRows ; row <= LastRow ; row++) {
      			CellValue(row, DAR_NO) = darNo;
      		}
      	}

      	with(sheetCNTRObj) {
  			for (var row = HeaderRows ; row <= LastRow ; row++) {
      			CellValue(row, DAR_NO) = darNo;
      		}
      	}
	}
      
   /**
    * Booking Container 가 신규일 경우 Seqeunce 값을 설정해주는 함수
    */    
    function setSequenceBKGContainer() {
		var sheetBKGObj 	= sheetObjects[0];
		var sheetCNTRObj 	= sheetObjects[1];
		
		with(sheetBKGObj) {
			var darNo 	= CellValue(SelectRow, DAR_NO);
			var bkgNo 	= CellValue(SelectRow, BKG_NO);
			var tariff 	= CellValue(SelectRow, TARIFF);
			var adjSeq 	= CellValue(SelectRow, ADJ_SEQ);
		}
		var cntrSeq = 1;
		
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				//Tariff 나 BKG No., B/L No. 가 변경되어 Charge Detail per BKG 정보를 조회한 경우
				//After Booking DAR 에 등록되지 않은 조회된 데이터일 때에는
				//DAR No., Adjustment Seq., Container Seq. 가 존재하지 않을 수 있으며, 그 경우에는
				//BKG 데이터로부터 값을 구해서  설정해줘야 한다.
				if (	RowStatus(row) != "D" 
					&& 	RowHidden(row) == false 
					&& 	bkgNo == CellValue(row, BKG_NO) 
					&&	tariff == CellValue(row, TARIFF) 
					&&	CellValue(row, ADJ_SEQ) == ""	) {
					
					if (darNo != "") CellValue2(row, DAR_NO) = darNo;
					CellValue2(row, ADJ_SEQ) = adjSeq;
					CellValue2(row, CNTR_SEQ) = cntrSeq++;
				}
			}
		}
    }
    
  	/**
	 * 2009 화면이 팝업으로 띄워졌는지를 알려주는 함수
	 */
	function isPopupWindow() {
	    var formObj = document.form;

		if (ComGetObjValue(formObj.caller) != "" && ComGetObjValue(formObj.darNo) != "") {
			return true;
		}
		return false;  		
    } 
	
  	/**
	 * 2006 번 메인화면에 Approval, Counter Offer, Reject 한 결과를 반영해주는 함수
	 */
	function commitMainScreen(sAction) {
		var formObj				= document.form;
        var receivedSheetObj 	= window.dialogArguments.sheetObjects[2];
        var sentSheetObj 		= window.dialogArguments.sheetObjects[5];
        
        //조회조건으로 DATE 선택시에만 하기 로직을 수행한다.(승인처리시에는 Received Tab 에 데이터를 삭제하고 Send Tab 으로 이동)
        if (!window.dialogArguments.document.form.cond_type[0].checked) return;
        
        //DAR No., Ver No. 가 동일한 Received Tab 에 데이터를 삭제하고 Send Tab 에 추가해준다.
        var sheetId		= ComGetObjValue(formObj.sheetId);
        var reqOfc		= (sheetId == "t1sheet3") 	? receivedSheetObj.CellValue(	receivedSheetObj.SelectRow, "req_ofc_cd"	) 
        											: sentSheetObj.CellValue(		sentSheetObj.SelectRow, 	"req_ofc_cd"	);
        var apvlOfc		= (sAction != "Requested")  ? ComGetObjValue(formObj.usr_ofc_cd) : "";
        var isSameOfc	= window.dialogArguments.isSameOffice(reqOfc, apvlOfc);

        //1. Request 와 Approval Office 가 동일할 경우에는 조회시 Received Tab 과 Sent Tab 에 모두 나타남.
        //   위와 같은 경우에는 어느 Tab 에서든 호출되었을 경우 두 곳 모두 데이터를 Update 쳐준다.
        if (isSameOfc) {
        	updateRow(receivedSheetObj, sAction);
			updateRow(sentSheetObj, 	sAction);			
        }
        //2. Request 와 Approval Office 가 상이한 경우에는 Received Tab 에서 호출할 경우 Sent Tab 으로 데이터를 이동시키면 됨
        else {
        	
        	if (prevActStatus == "Requested") {
        		//Received Tab => Received Tab(update)
        		if (sAction == "Requested" || sAction == "Cancel") {
        			updateRow(receivedSheetObj, sAction);
        		}
        		//Received Tab => Sent Tab(delete data from received tab and insert data into sent tab)
        		else {
        			moveRowSheetToSheet(receivedSheetObj, sentSheetObj, sAction);	
        		}
        	}
        	else {
        		//Received Tab => Sent Tab(delete data from received tab and insert data into sent tab)
        		if (sAction == "Requested") {
        			moveRowSheetToSheet(receivedSheetObj, sentSheetObj, sAction);		
        		}
        		//Sent Tab => Sent Tab(update)
        		else {
        			updateRow(sentSheetObj, sAction);
        		}
        	}
        }
	}
	
 	/**
	 * 선택된 Row 의 상태를 갱신(변경된 정보로) 해주는 함수
	 */		 
	function updateRow(sheetObj, sAction) {
		var formObj 	= document.form;
		var darNo		= ComGetObjValue(formObj.darNo);
		
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (darNo == CellValue(row, "dar_no")) {
					CellValue(row, "apvl_no") 		= sAction == "Approval" ? ComGetObjValue(formObj.apvlNo) : "";
					CellValue(row, "status") 		= ComGetObjValue(formObj.status);
					CellValue(row, "apro_ofc_cd") 	= ComGetObjValue(formObj.usr_ofc_cd);
					CellValue(row, "upd_dt") 		= ComGetObjValue(formObj.popup_upd_dt);
				}
			}
		}		
	}
	
 	/**
	 * 선택된 Row 를 현재 Sheet 에서 다른 Sheet 로 이동시키는 함수
	 */		
    function moveRowSheetToSheet(fromSheetObj, toSheetObj, sAction) {
        var formObj		= document.form;
        
		//Received Tab 에는 동일한 DAR No. 가 'TO','CC' 로 나타날 수 있기 때문에
		//이 경우에는 삭제는 2 건을 하되 Sent Tab 에는 한 건만 추가되어 나타나도록 구분해주기 위해 사용하는 변수
		var isAppliedRow 	= false;
		var darNo			= ComGetObjValue(formObj.darNo);
		
		with(fromSheetObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				if (darNo == CellValue(row, "dar_no")) {
					if (!isAppliedRow) {
						
						//데이터 행 추가
		                var addedRow = toSheetObj.DataInsert(toSheetObj.RowCount);
		                
		                //데이터 옮기기
		                var fieldValue = "";
		                for (ic = 0 ; ic <= LastCol ; ic++) {

		                	switch(ColSaveName(ic)) {
			                	case "apvl_no":
			                		fieldValue = sAction == "Approval" ? ComGetObjValue(formObj.apvlNo) : "";
			                		break;
			                		
			                	case "status":
			                		fieldValue = ComGetObjValue(formObj.status);
			                		break;
			                		
			                	case "apro_ofc_cd":
			                		fieldValue = sAction != "Requested" ? ComGetObjValue(formObj.usr_ofc_cd) : "";
			                		break;
			                		
			                	case "upd_dt":
			                		fieldValue = ComGetObjValue(formObj.popup_upd_dt);
			                		break;
			                			
			                	default:
			                		fieldValue = CellValue(row, ic);
		                	}
		                	toSheetObj.CellValue(addedRow, ic) = fieldValue;
		                }
		                isAppliedRow = true;
					}

	                //원본에서 지움
	                RowDelete(row, false);
				}
			}
		}    	
    }
		
 	/**
	 * D/C AMT or Ratio Pre Cal. 컬럼의 계산버튼 클릭시 관련 컬럼들의 상태를 변경하거나, 선택된 행의 변경으로 인해 초기화 시켜주는 함수
	 */	 
	function changeCalcColumn(flg) {

		if (flg) {
	     	//빨간색으로 변경된 버튼과 계산컬럼을 선택된 행의 변경으로 인해 초기화 시켜준다.
	     	document.getElementById("btn_PreCalc").style.color = "red";
	     	document.getElementById("totalBillAmt").style.color = "red";				
		}
		else {
	     	//빨간색으로 변경된 버튼과 계산컬럼을 선택된 행의 변경으로 인해 초기화 시켜준다.
	     	document.getElementById("btn_PreCalc").style.color = "";
	     	document.getElementById("totalBillAmt").style.color = "";				
		}
		
		changeCalcBillableAMT(flg);		
	}
	
 	/**
	 * D/C AMT or Ratio Pre Cal. 컬럼의 계산버튼 클릭시 관련 컬럼들의 상태를 변경하거나, 선택된 행의 변경으로 인해 초기화 시켜주는 함수
	 */		 
	function changeCalcBillableAMT(flg) {
		var sheetBKGObj = sheetObjects[0];
		var sheetCNTRObj = sheetObjects[1];
		
   	    var adjSeq = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, ADJ_SEQ);
		
     	with(sheetCNTRObj) {
     		for (var row = HeaderRows ; row <= LastRow ; row++) {
     			if (RowStatus(row) != "D" && adjSeq == CellValue(row, ADJ_SEQ)) {
     				if (flg) {
     					CellFont("FontColor",row,BIL_AMT) = RgbColor(255,0,0);
     				}
     				else {
     					CellFont("FontColor",row,BIL_AMT) = RgbColor(0,0,0);
     				}
   				}
     		}
		}
	}
	 
 	/**
	 * D/C AMT or Ratio Pre Cal. 컬럼의 계산이 처리되었는지를 확인해주는 함수
	 */	 
	function isCalculated() {

	    if (document.getElementById("btn_PreCalc").style.color == "red") {
	    	return true;
	    }
    	return false;
	}
		
    /**
 	 * Status 상태에 따라서 BKG 그리드를 활성화 시키거나 비활성화 시킨다.
 	 */
    function enableGrid(flg) {
    	var sheetBKGObj = sheetObjects[0];

    	with(sheetBKGObj) {
    		for (var row = HeaderRows ; row <= LastRow ; row++) {
    			if (RowStatus(row) != "D") {

    				//Charge 정보가 없을 경우에는 CNTR_TP 는 비활성화다.(2009-11-05(목))
    				if (CellValue(row, CNTR_FLG) != "N") {
    					CellEditable(row, CNTR_TP) = flg;
    				}
    				else {
    					CellEditable(row, CNTR_TP) = false;
    				}    				
	    			CellEditable(row, FT_FLG) 		= flg;
	    			CellEditable(row, ADD_DYS) 		= flg;
	    			CellEditable(row, TTL_DYS) 		= flg;
	    			CellEditable(row, SAT_FLG) 		= flg;
	    			CellEditable(row, SUN_FLG) 		= flg;
	    			CellEditable(row, HOL_FLG) 		= flg;
	    			CellEditable(row, DCAR_FLG) 	= flg;
	    			CellEditable(row, DCAR_CURR) 	= flg;
	    			CellEditable(row, DCAR_AMT) 	= flg;
	    			CellEditable(row, DCAR_RTO) 	= flg;
    			}
    		}
    	}
    	
    	enableContainerGrid(flg);
    }
	    
    /**
  	 * Status 상태에 따라서 Container per BKG 그리드를 활성화 시키거나 비활성화 시킨다.
  	 */
     function enableContainerGrid(flg) {
     	var sheetBKGObj 	= sheetObjects[0];
     	var sheetCNTRObj 	= sheetObjects[1]; 

     	with(sheetBKGObj) {
     		var bkgNo 	= CellValue(SelectRow, BKG_NO);
     		var tariff 	= CellValue(SelectRow, TARIFF);
     	}
     	
     	with(sheetCNTRObj) {
     		for (var row = LastRow ; row >= HeaderRows ; row--) {
     			if (	RowStatus(row) != "D" 
     				&& bkgNo 	== CellValue(row, BKG_NO)
     				&& tariff 	== CellValue(row, TARIFF)	) {
	     			CellEditable(row, FT_FLG) 	= flg;
	     			CellEditable(row, ADD_DYS) 	= flg;
	     			CellEditable(row, TTL_DYS) 	= flg;
	     			CellEditable(row, SAT_FLG) 	= flg;
	     			CellEditable(row, SUN_FLG) 	= flg;
	     			CellEditable(row, HOL_FLG) 	= flg;
	     			CellEditable(row, AR_FLG) 	= flg;
	     			CellEditable(row, AR_AMT) 	= flg;
	     			CellEditable(row, AR_RTO) 	= flg;
     			}
     		}
     	}
     }
     
    /**
	 * 조회된 After Booking DAR 의 상태값에 따라서 그리드의 상태를 활성화 시킬것인지 비활성화 시킬것인지를 판단하는 함수
	 */    
    function isEnableGrid() {
    	var formObj 	= document.form;
    	var sheetBKGObj = sheetObjects[0];
    	
    	var rqstOfcCd = "";
    	with(sheetBKGObj) {
    		if (RowCount > 0) rqstOfcCd = CellValue(HeaderRows, RQST_OFC_CD);
    	}
    	
    	//GRID 활성화는 1)Status 가 공란이거나, 2)Counter Offered 일 경우 로그인 점소가 Request 점소와 동일할 경우
    	//             3)Requested 일 경우 로그인 점소가 Request 점소와 동일할 경우 이다.
    	//			   4)Approval 권한을 가진 사용자일 경우
		var status = ComTrim(ComGetObjValue(formObj.status));
		if (status == "")
			return true;	
		else if (status == "Counter Offered" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd))
			return true;
    	else if (status == "Requested" && rqstOfcCd == ComTrim(formObj.usr_ofc_cd))
    		return true;
    	else if (isPermitRole() &&  isMatchOffice() && isPermitStatus("Approval"))
    		return true;
		return false;
    }
    
  	/**
  	 * DAR 조회필드항목중 특정필드에 값이 입력되면 다른 필드들은 모두 Clear 시킨다.
  	 */
  	function clearNoSelectConditionFields() {	 
  	    var formObj = document.form;
  	    
  		with(formObj) {
  			switch(event.srcElement.name) {
  				case "darNo":
  					if (ComTrim(ComGetObjValue(apvlNo)) != "") ComClearObject(apvlNo);
  					break;
  					
  				case "apvlNo":
  					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
  					break;  					
  			}
  		}
  	}
   	
 	/**
 	 * Change Detail per BKG 의 D/C Amount or Ratio 의 Currency 가 변경되면 동일한 모든 데이터도 동일하게 변경시켜준다.
 	 */		 
 	function changeCurrencyAltogther(selectRow) {
 		var sheetCNTRObj = sheetObjects[1];
 		
 		with(sheetCNTRObj) {
 			var adjSeq = CellValue(selectRow, ADJ_SEQ);
 			var currCd = CellValue(selectRow, DCAR_CURR);
 			
 			for (var row = HeaderRows ; row <= LastRow ; row++) {
 				
 				if (adjSeq == CellValue(row, ADJ_SEQ) && row != selectRow) {
 					
 					if (CellValue(row, AR_FLG) == 1) {
 						CellValue2(row, DCAR_CURR) = currCd;
 					}
 					else {
 						CellValue2(row, DCAR_CURR) = "";
 					}
 				}
 			}
 		}
 	}

   /**
    * Tariff 와 BKG No. 가 동일한 Charge Detail per BKG 의 총 갯수를 구해서 반환하는 함수
    */
    function getChargeQuantity() {
		var sheetBKGObj = sheetObjects[0];
		var sheetCNTRObj = sheetObjects[1];
		
		var quantity = 0;
		with(sheetBKGObj) {
			var bkgNo = CellValue(SelectRow, BKG_NO);
			var tariff = CellValue(SelectRow, TARIFF);
			var adjSeq = CellValue(SelectRow, ADJ_SEQ);
		}
		
		var seq = 1;
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	RowStatus(row) != "D"
					&&  RowHidden(row) == false
					&& 	bkgNo == CellValue(row, BKG_NO) 
					&&	tariff == CellValue(row, TARIFF) 
					&&	adjSeq == CellValue(row, ADJ_SEQ)	) {

					quantity++;
				}
			}
		}    	
		quantity = quantity > 0 ? quantity : "";
		
    	return quantity
    }
 	    
   /**
    * Tariff 와 BKG No. 가 동일한 Charge Detail per BKG 의 첫번째 Currency 를 찾아서 반환하는 함수
    */
    function getCurrency() {
		var sheetBKGObj = sheetObjects[0];
		var sheetCNTRObj = sheetObjects[1];
		
		var quantity = 0;
		with(sheetBKGObj) {
			var bkgNo = CellValue(SelectRow, BKG_NO);
			var tariff = CellValue(SelectRow, TARIFF);
			var adjSeq = CellValue(SelectRow, ADJ_SEQ);
		}
		
		var seq = 1;
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	RowStatus(row) != "D"
					&&  RowHidden(row) == false
					&& 	bkgNo == CellValue(row, BKG_NO) 
					&&	tariff == CellValue(row, TARIFF) 
					&&	adjSeq == CellValue(row, ADJ_SEQ)	) {

					return CellValue(row, CURR);
				}
			}
		} 
    	return "";
    }

   /**
    * Charge Detail per BKG 의 CNTR Q'ty, Cur, Total Billable AMT 정보를 Clear 해주는 함수
    */    
	function clearChargeDetailTopInfo() {
		var formObj = document.form;
   	
		with(formObj) {
			ComClearObject(cntrQty);
			ComClearObject(curr);
			ComClearObject(totalBillAmt);
		}
	}
   
   	/**
   	 * Rate Adjustment 항목을 선택하거나 선택해제시 수행해야할 동작을 정의하는 함수
   	 */	
  	 function checkComment() {
   		var formObj 	= document.form;
 		var sheetHSTObj	= sheetObjects[2];
 		
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
			if (chkComment.checked) {
				comment.className = "textarea1";
			}
			else {
				comment.className = "textarea2";
			}
			//++++++++++++++++++++++++++++++++++++++++++++++++
 	 	} 
  	}
   	 
 	/**
 	 * Comment 에 대한 필수입력 체크를 수행하는 함수
 	 */	   	 
     function validateComment() {
     	var formObj = document.form;
     	
     	with(formObj) {
	 		if (!chkComment.checked) {
	 			ComShowCodeMessage("DMT00151");
	 			ComSetFocus(chkComment);
	 			return false;				
	 		}
	 		else if (ComTrim(ComGetObjValue(comment)) == "") {
	 			ComShowCodeMessage("DMT02002", "Comment");
	 			ComSetFocus(comment);
	 			return false;				
	 		}
	 		else if (ComChkLenByByte(ComGetObjValue(comment), 500) == 0) {
	 			ComShowCodeMessage("DMT00104", "Comment", "500");
	 			ComSetFocus(comment);
	 			return false;				
	 		}
     	}
        return true;	
     }   	
 	 
  	/**
  	 * BKG No.나 B/L No. 로 Charge 조회 후에는 키 컬럼을 수정하지 못하도록 변경한다.
  	 */		
  	function disableKeyColumn(selectedRow) {
  		var sheetBKGObj = sheetObjects[0];
  		
  		with(sheetBKGObj) {
  			CellEditable(selectedRow, BKG_NO)	= false;
  			CellEditable(selectedRow, BL_NO) 	= false;
  			CellEditable(selectedRow, TARIFF) 	= false;
  		}
  	}
  	 
   	/**
   	 * BKG No. 나 B/L No. 입력시 B/L No. 나 BKG No., S/C No., RFA No. 를 조회하 함수
   	 */	 	
  	function checkBKGBLNo(COL) {
  		var formObj = document.form;
  		var sheetBKGObj = sheetObjects[0];

  		//1-1.BKG No. 또는 B/L No. 입력시 B/L No. 나 BKG No. 를 조회하고 맞지 않을 경우 에러메시지를 보여준다.
   		with(sheetBKGObj) {
  	 		if (!checkTariffBKGBLNo(sheetBKGObj,formObj)) {
  	 			
  	 			if (ComGetObjValue(formObj.result2) == "") {
 	 	 			ComShowCodeMessage("DMT00165", COL == BKG_NO ? "BKG No." : "B/L No.");
 	 	     		CellValue2(SelectRow, BKG_NO) = "";
 	 	     		CellValue2(SelectRow, BL_NO) = "";
 	 	     		return false;
  	 			}
  	 			else {
 					//3-1.입력한 BKG No. 의 S/C 또는 RFA No. 가 상단의 S/C 또는 RFA No. 와 불일치시 에러메시지를 띄워주며 막음.
 					ComShowCodeMessage("DMT00159", CellValue(SelectRow, "Seq"));
 					CellValue2(SelectRow, BKG_NO) = "";
 					CellValue2(SelectRow, BL_NO) = "";
 					return false;
  	 			}
  	 		} 
   		}
   		return true;
  	}
   	 
  	/**
  	 * 전체 CNTR가 A/R I/F 되어 있는지 체크해주는 함수
  	 * (1 개 만이라도 A/R I/F 되어 있을 경우 체크해주도록 변경)
  	 */	
  	function checkARIFAllContainer() {
  		var sheetBKGObj = sheetObjects[0];
  		var sheetCNTRObj = sheetObjects[1];

  		var adjSeq = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, ADJ_SEQ);

  		with(sheetCNTRObj) {
  			for (var row = HeaderRows ; row <= LastRow ; row++) {
  				if (RowStatus(row) != "D" && adjSeq == CellValue(row, ADJ_SEQ)) {
  					if (CellValue(row, AR) == "Y") {
  						return true;
  					}
  				}
  			}
  		}
  		return false;
  	}
  	
 	/**
	 * 전체 CNTR가 A/R I/F 되어 있을 경우 사용자가 취소시 조회된 정보를 모두 삭제해 주는 함수.
	 */	 	
	function removeBookingChargeData() {
		var formObj = document.form;
		var sheetBKGObj = sheetObjects[0];
		var sheetCNTRObj = sheetObjects[1];
		
		with(sheetBKGObj) { 		
			var adjSeq = CellValue(SelectRow, ADJ_SEQ); 
		}
		
 		//Charge Header 정보 삭제
 		ComClearObject(formObj.cntrQty);
 		ComClearObject(formObj.curr);
 		ComClearObject(formObj.totalBillAmt);
 		
 		//Charge 정보 삭제
 		with(sheetCNTRObj) {
 			for (var row = LastRow ; row >= HeaderRows ; row--) {
 				if (RowStatus(row) != "D" && RowHidden(row) == false && adjSeq == CellValue(row, ADJ_SEQ)) {
 					if (RowStatus(row) == "I") {
 						RowDelete(row, false);
 					}
 					else {
 						RowStatus(row) = "D";
 						RowHidden(row) = true; 						
 					}
 				}
 			}
 		}
		
		//Booking 정보 삭제
		with(sheetBKGObj) {
			CellValue2(SelectRow, BKG_NO) = "";
			CellValue2(SelectRow, BL_NO) = "";
			CellValue2(SelectRow, TVVD) = "";
			CellValue2(SelectRow, POR) = "";
			CellValue2(SelectRow, POL) = "";
			CellValue2(SelectRow, POD) = "";
			CellValue2(SelectRow, DEL) = "";
			CellValue2(SelectRow, RD) = "";
			CellValue2(SelectRow, DG_FLG) = "";
			CellValue2(SelectRow, RF_FLG) = "";
			CellValue2(SelectRow, AK_FLG) = "";
			CellValue2(SelectRow, BB_FLG) = "";
			CellValue2(SelectRow, RD_FLG) = "";
			CellValue2(SelectRow, SOC_FLG) = "";
			CellValue2(SelectRow, CMDT_CD) = "";
			CellValue2(SelectRow, CMDT_NM) = "";
		}
		
 		//오직 하나 뿐인 Booking 정보일 경우 S/C No., RFA No., Customer 정보를 삭제해 준다.
 		if (getAfterBKGCount() <= 1) {
 			ComClearObject(formObj.scNo);
 			ComClearObject(formObj.rfaNo);
 			ComClearObject(formObj.custCd);
 			ComClearObject(formObj.custNm);
 		}		
	}

 	/**
	 * 존재하는 Booking 의 ROW 수를 구하는 함수
	 */	 	 
	function getAfterBKGCount() {
		var sheetBKGObj = sheetObjects[0];
		var count = 0;
		
		with(sheetBKGObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (RowStatus(row) != "D") {
					count++;
				}
			}
		}
		return count;
	}
	 
   /**
     * Pre Calc 버튼을 클릭시 CNTR 이 'All' 로 지정되었때, 계산을 위해서 BKG 의
     * D/C Amount or Ratio 의 데이터를 Container Charge 로 복사해주는 함수
     */	
    function copyDCAmountOrRatioToChargeContainer() {
    	var sheetBKGObj = sheetObjects[0];
    	var sheetCNTRObj = sheetObjects[1]
    	                                
   	    var adjSeq = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, ADJ_SEQ);
    	var amt = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, DCAR_AMT);
    	var ratio = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, DCAR_RTO);
    	
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (RowStatus(row) != "D" && adjSeq == CellValue(row, ADJ_SEQ)) {
					if (CellValue(row, GB) == "G") {
						CellValue2(row, AR_AMT) = amt;
						CellValue2(row, AR_RTO) = ratio;
					}
				}
			}
		}
    }
    
  /**
    * Pre Calc 버튼을 클릭시 CNTR 이 'All' 로 지정되었때, 계산을 위해서 BKG 의
    * D/C Amount or Ratio 의 데이터를 Container Charge 로 복사해준 정보를 삭제해 주는 함수
    */	
    function removeDCAmountOrRatioToChargeContainer() {
    	var sheetBKGObj = sheetObjects[0];
    	var sheetCNTRObj = sheetObjects[1]
   	                                
    	var adjSeq = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, ADJ_SEQ);
    	var amt = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, DCAR_AMT);
    	var ratio = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, DCAR_RTO);
   	
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (RowStatus(row) != "D" && adjSeq == CellValue(row, ADJ_SEQ)) {
					if (CellValue(row, GB) == "G") {
						CellValue2(row, AR_AMT) = "";
						CellValue2(row, AR_RTO) = "";
					}
				}
			}
		}
   }

    /**
     * CNTR 의 선택된 값에 따라서 BKG, CNTR 의 Free Time, Amount or Ratio 컬럼의 활성화 여부를 처리해주는 함수
     */    
    function modifyModeFreeTimeAmountorRatio(isValueClear) {
    	var sheetBKGObj = sheetObjects[0];
     	var sheetCNTRObj = sheetObjects[1]; 

     	var isActive = isEnableGrid();
     	
     	with(sheetBKGObj) {
     		var cntrType = CellValue(SelectRow, CNTR_TP);
     		var bkgNo = CellValue(SelectRow, BKG_NO);
     		var tariff = CellValue(SelectRow, TARIFF);
     	}
    	
    	//모두 동일할 경우
    	if (cntrType == "S") {
    		with(sheetBKGObj) {
    			var row = SelectRow;

    			//[ BKG ] Free Time Y 컬럼, D/C Amount or Ratio Y 컬럼의 활성화, 비활성화 상태로 변경한다.
    			CellEditable(row, FT_FLG) = isActive;
    			CellEditable(row, DCAR_FLG) = isActive;
    			
				//Free Time Y 컬럼이 체크되었다면 Free Time(Add, Total), F/Time EXCL(SAT, SUN, H/day) 을 활성화 시킨다.
				if (CellValue(row, FT_FLG) == 1) {
					CellEditable(row, ADD_DYS) = isActive;
					CellEditable(row, TTL_DYS) = isActive;
					CellEditable(row, SAT_FLG) = isActive;
					CellEditable(row, SUN_FLG) = isActive;
					CellEditable(row, HOL_FLG) = isActive;
				}
				else {
					CellEditable(row, ADD_DYS) = false;
					CellEditable(row, TTL_DYS) = false;
					CellEditable(row, SAT_FLG) = false;
					CellEditable(row, SUN_FLG) = false;
					CellEditable(row, HOL_FLG) = false; 
				}
				
				//D/C Amount or Ratio Y 컬럼이 체크되었다면 D/C Amount or Ratio(CUR, AMT, Ratio) 을 활성화 시킨다.
				if (CellValue(row, DCAR_FLG) == 1) {
					CellEditable(row, DCAR_CURR) = isActive;
					CellEditable(row, DCAR_AMT) = isActive;
					CellEditable(row, DCAR_RTO) = isActive;
				}
				else {
					CellEditable(row, DCAR_CURR) = false;
					CellEditable(row, DCAR_AMT) = false;
					CellEditable(row, DCAR_RTO) = false;
				}
				
				//Charge Detail per BKG 에서 지정된 컬럼을 감춘다.
				hideContainerColumn(true);
				
				//Charge Detail per BKG 에 컬럼데이터를 지운다.
				if (isValueClear) {
					clearCNTRFreeTimeAmountorRatio();
				}
				
				//Charge Detail per BKG 에 컬럼을 비활성화 시킨다.
				modifyCNTRModeFreeTimeAmountorRatio(row, false);
    		}
    	}
    	//모두 다를 경우
    	else if (cntrType == "D") {
			//[ BKG ] Free Time Y 컬럼, D/C Amount or Ratio Y 컬럼의 활성화, 비활성화 상태로 변경한다.
    		with(sheetBKGObj) {
    			CellEditable(SelectRow, FT_FLG) = false;
    			CellEditable(SelectRow, DCAR_FLG) = false;
    		}
    		
    		with(sheetCNTRObj) {
    			for (var row = HeaderRows ; row <= LastRow ; row++) {
         			if (RowStatus(row) != "D" && bkgNo == CellValue(row, BKG_NO) && tariff == CellValue(row, TARIFF)) {

        				isActive = isEnableGrid();
         				
         				//G/B 컬럼의 데이터가 'B' 일 경우에는 'Y' 체크박스 비활성화
         				if (CellValue(row, GB) == "B") isActive = false;
         				
         				CellEditable(row, FT_FLG) = isActive;
	    				//Free Time Y 컬럼이 체크되었다면 Free Time(Add, Total), F/Time EXCL(SAT, SUN, H/day) 을 활성화 시킨다.
	    				if (CellValue(row, FT_FLG) == 1) {
	    					CellEditable(row, ADD_DYS) = isActive;
	    					CellEditable(row, TTL_DYS) = isActive;
	    					CellEditable(row, SAT_FLG) = isActive;
	    					CellEditable(row, SUN_FLG) = isActive;
	    					CellEditable(row, HOL_FLG) = isActive;
	    				}
	    				else {
	    					CellEditable(row, ADD_DYS) = false;
	    					CellEditable(row, TTL_DYS) = false;
	    					CellEditable(row, SAT_FLG) = false;
	    					CellEditable(row, SUN_FLG) = false;
	    					CellEditable(row, HOL_FLG) = false;
	    				}
	    				
	    				CellEditable(row, AR_FLG) = isActive;
	    				//D/C Amount or Ratio Y 컬럼이 체크되었다면 D/C Amount or Ratio(CUR, AMT, Ratio) 을 활성화 시킨다.
	    				if (CellValue(row, AR_FLG) == 1) {
	    					CellEditable(row, DCAR_CURR) = isActive;
							CellEditable(row, AR_AMT) = isActive;
							CellEditable(row, AR_RTO) = isActive;
	    				}
	    				else {
	    					CellEditable(row, DCAR_CURR) = false;
							CellEditable(row, AR_AMT) = false;
							CellEditable(row, AR_RTO) = false;	
	    				}
         			}
    			}
    			
				//Charge Detail per BKG 에서 지정된 컬럼을 보여준다.
				hideContainerColumn(false);
				
				//[ BKG ] 에 컬럼데이터를 지운다.
				if (isValueClear) {
					clearBKGFreeTimeAmountorRatio();
				}
				
				//[ BKG ] 에 컬럼을 비활성화 시킨다.
				modifyBKGModeFreeTimeAmountorRatio(SelectRow, false);				
    		}
    	}
    }
    
   /**
    * BKG Grid 의 Free Time, Amount or Ratio 컬럼의 활성화 여부를 처리해주는 함수
    */ 
    function modifyBKGModeFreeTimeAmountorRatio(row, isActive) {
    	var sheetBKGObj = sheetObjects[0];

    	if (!isEnableGrid()) isActive = false;
    	
    	with(sheetBKGObj) {
			CellEditable(row, ADD_DYS) = isActive;
			CellEditable(row, TTL_DYS) = isActive;
			CellEditable(row, SAT_FLG) = isActive;
			CellEditable(row, SUN_FLG) = isActive;
			CellEditable(row, HOL_FLG) = isActive; 
			CellEditable(row, DCAR_CURR) = isActive;
			CellEditable(row, DCAR_AMT) = isActive;
			CellEditable(row, DCAR_RTO) = isActive;
    	}
    }
    
    /**
     * CNTR Grid 의 Free Time, Amount or Ratio 컬럼의 활성화 여부를 처리해주는 함수
     */ 
    function modifyCNTRModeFreeTimeAmountorRatio(bkgrow, isActive) {
     	var sheetBKGObj = sheetObjects[0];
     	var sheetCNTRObj = sheetObjects[1]; 
    	
     	if (!isEnableGrid()) isActive = false;
     	
		with(sheetBKGObj) {
			var bkgNo = CellValue(bkgrow, BKG_NO);
			var tariff = CellValue(bkgrow, TARIFF);
			var adjSeq = CellValue(bkgrow, ADJ_SEQ);
		}
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
     			if (	RowStatus(row) != "D"
     				&&	RowHidden(row) == false
     				&& 	bkgNo == CellValue(row, BKG_NO) 
     				&&	tariff == CellValue(row, TARIFF)
     				&&	adjSeq == CellValue(row, ADJ_SEQ)	) {
     				
     				CellEditable(row, ADD_DYS) = isActive;
     				CellEditable(row, TTL_DYS) = isActive;
					CellEditable(row, SAT_FLG) = isActive;
					CellEditable(row, SUN_FLG) = isActive;
					CellEditable(row, HOL_FLG) = isActive;
					CellEditable(row, DCAR_CURR) = isActive;
					CellEditable(row, AR_AMT) = isActive;
					CellEditable(row, AR_RTO) = isActive;			
     			}
			}
		}
    }

   /**
    * BKG Grid 의 Free Time, Amount or Ratio 컬럼의 데이터를 삭제해주는 함수
    */   
    function clearBKGFreeTimeAmountorRatio() {
    	var sheetBKGObj = sheetObjects[0];
    	
    	with(sheetBKGObj) {
    		CellValue2(SelectRow, FT_FLG) = 0;
    		CellValue2(SelectRow, ADD_DYS) = "";
    		CellValue2(SelectRow, TTL_DYS) = "";
    		CellValue2(SelectRow, SAT_FLG) = 0;
    		CellValue2(SelectRow, SUN_FLG) = 0;
    		CellValue2(SelectRow, HOL_FLG) = 0;
    		CellValue2(SelectRow, DCAR_FLG) = 0;
    		CellValue2(SelectRow, DCAR_CURR) = "";
    		CellValue2(SelectRow, DCAR_AMT) = "";
    		CellValue2(SelectRow, DCAR_RTO) = "";    		
    	}
    }
    
    /**
     * Charge Detail per BKG Grid 의 Free Time, Amount or Ratio 컬럼의 데이터를 삭제해주는 함수
     */ 
    function clearCNTRFreeTimeAmountorRatio() {
    	var sheetBKGObj = sheetObjects[0];
     	var sheetCNTRObj = sheetObjects[1]; 
    	
     	with(sheetBKGObj) {
     		var bkgNo = CellValue(SelectRow, BKG_NO);
     		var tariff = CellValue(SelectRow, TARIFF);
     	}
     	
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
     			if (RowStatus(row) != "D" && bkgNo == CellValue(row, BKG_NO) && tariff == CellValue(row, TARIFF)) {
     				CellValue2(row, FT_FLG) = 0;
					CellValue2(row, ADD_DYS) = "";
					CellValue2(row, TTL_DYS) = "";
					CellValue2(row, SAT_FLG) = 0;
					CellValue2(row, SUN_FLG) = 0;
					CellValue2(row, HOL_FLG) = 0;
					CellValue2(row, AR_FLG) = 0;
					CellValue2(row, DCAR_CURR) = "";
					CellValue2(row, AR_AMT) = "";
					CellValue2(row, AR_RTO) = "";					
     			}
			}
		}
    }

   /**
    * Charge Detail per BKG Grid. 의 Seq. 값을 순차적으로 재설정해준다.
    */
   function setCNTRSeq() {
		var sheetBKGObj = sheetObjects[0];
		var sheetCNTRObj = sheetObjects[1];
		
		with(sheetBKGObj) {
			var bkgNo = CellValue(SelectRow, BKG_NO);
			var tariff = CellValue(SelectRow, TARIFF);
			var adjSeq = CellValue(SelectRow, ADJ_SEQ);
		}
		
		var seq = 1;
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	RowStatus(row) != "D"
					&&  RowHidden(row) == false
					&& 	bkgNo == CellValue(row, BKG_NO) 
					&&	tariff == CellValue(row, TARIFF) 
					&&	adjSeq == CellValue(row, ADJ_SEQ)	) {

					CellValue2(row, "Seq") = seq++;
				}
			}
		}
   }
     
    /**
    * 삭제된 행 이후에 자동으로 선택되어질 행을 찾아주는 함수
    */
   function fetchSelectedNextRow(delRow) {
		var sheetBKGObj = sheetObjects[0];
		var nextRow = -1;
		
		with(sheetBKGObj) {
			//삭제된 현재 행보다 큰 행을 찾는다.
			for (var row = delRow ; row <= LastRow ; row++) {
				if (RowStatus(row) != "D") {
					nextRow = row;
					break;
				}
			}

			//큰 행에서 찾지 못했다면 
			if (nextRow == -1) {
				//현재 행보다 작은 행을 찾는다.
				for (var row = delRow ; row >= HeaderRows ; row--) {
					if (RowStatus(row) != "D") {
						nextRow = row;
						break;
					}
				}
			}
		}
		return nextRow;
   }
    
	/**
	 * BKG 다른 행이 선택될 경우 Charge Detail per BKG 에 보여줄 항목들도 변경해줘야 한다.
	 */
    function displayChargeDetailperBKG(newRow) {
		var formObj = document.form;
		var sheetBKGObj = sheetObjects[0];
		var sheetCNTRObj = sheetObjects[1];
			
		//BKG 의 선택행 변경으로 인해 Charge Detail per BKG 의 CNTR Q'ty, Cur., Total Billable AMT 데이터를 지워준다.
		clearChargeDetailTopInfo();  
   	
   		//선택한 행 변경시 Calculation 버튼 클릭후 빨간색으로 변경된 관련 컬럼들의 색상을 이전색으로 원복시킨다.
   		changeCalcColumn(false);
   	
		//조회된  데이터가 아니라면 찾아서 보여준다.
		if (sheetBKGObj.CellValue(newRow, SRCH_FLG) != "Y") {
			with(sheetBKGObj) {
				//Charge Detail per BKG 정보를 조회하기 위해서는 선택한 ROW 의 Tariff 와 BKG No. 나 B/L No. 가 반드시 존재해야만 한다.
				if (CellValue(newRow, TARIFF) != "" && (CellValue(newRow, BKG_NO) != "" || CellValue(newRow, BL_NO) != "")) {
					
			    	//조회하기전 Charge Detail per BKG 를 After Booking 에서 읽어올 것인지 Charge Calculation 에서 
			    	//읽어올 것인지 설정해준다.(이 경우에는 DAR_NO 가 있을 경우 After Booking 에서 읽어오고, 
					//                        없을 경우에는 Charge Calculation 에서 읽어온다. 2009-11-02)					
					if (CellValue(newRow, DAR_NO) != "") {
						ComSetObjValue(formObj.is_aft_bkg_cntr, "Y");
					}
					else {
						ComSetObjValue(formObj.is_aft_bkg_cntr, "N");
					}
					//Billable Amount per CNTR 정보를 조회한다.
					doActionIBSheet(sheetCNTRObj,formObj,IBSEARCH_CNTRCHG_BKG);		
				}
			}
		}
		else {
			//Container Quantity 정보를 그리드내 조회된 결과에서 그 합을 세어서 보여준다.
			ComSetObjValue(formObj.cntrQty, getChargeQuantity());
			//Currency 정보를 선택한 BKG 정보에 맞도록 변경해준다.
			ComSetObjValue(formObj.curr, getCurrency());
			//Container Billable Amount 의 Total 정보를 구한다.
			sumBillableAmount();						
		}
		
		//CNTR 에 따라서 Free Time, F/Time EXCL, D/C Amount or Ratio 활성화 혹은 비활성화 처리한다.
  		//(인자는 비활성화시 존재하는 값을 삭제할지를 나타낸다)    	
		modifyModeFreeTimeAmountorRatio(true);
		
		//BKG 에 해당되는 Billable Amount per CNTR 정보를 보여준다.
		showBillableAmountPerCNTR();
		
 		//Charge Detail per BKG 데이터가 존재하면 D/C AMT or Ratio Pre Cal., Reset 버튼을 활성화 시키고, 없으면 비활성화 시킨다.(2009-11-06(금))
// 2011.12.09 PreCalc 기능 막음.
//		if (fetchChargeRowCount() > 0) {
// 			ComBtnEnable("btn_PreCalc");
// 			ComBtnEnable("btn_Reset");
// 		}
// 		else {
// 			ComBtnDisable("btn_PreCalc");
// 			ComBtnDisable("btn_Reset");
// 		}		
    }
	 
   /**
    * Tariff 와 BKG No. 가 동일한 Charge Detail per BKG 의 총 갯수를 구해서 반환하는 함수
    */
    function fetchChargeRowCount() {
     	var sheetBKGObj = sheetObjects[0];
     	var sheetCNTRObj = sheetObjects[1];

     	var adjSeq = sheetBKGObj.CellValue(sheetBKGObj.SelectRow, ADJ_SEQ); 
     	var count = 0;

     	with(sheetCNTRObj) {
     		for (var row = HeaderRows ; row <= LastRow ; row++) {
     			if (RowStatus(row) != "D" && RowHidden(row) == false && adjSeq == CellValue(row, ADJ_SEQ)) {
     				count++;
     			}
     		}
     	}
     	return count;
    }
   
    /**
     * 로그인 사용자가 DMT03 권한을 가질경우에 대한 유효한 권한인지에 대해서 체크해주는 함수
     */
    function check03RoleAuth() {
    	var formObj		= document.form;
    	var sheetBKGObj = sheetObjects[0];
    	var sheetCNTRObj = sheetObjects[1];
    	var isPermit	= false;

    	with(sheetBKGObj) {
    		//조건 비교를 위한 매개변수 설정
    		//APVL Office
    		ComSetObjValue(formObj.etc2, ComGetObjValue(formObj.approvalOfcCd));
    		//AFT_EXPT_DAR_NO
    		ComSetObjValue(formObj.etc4, ComGetObjValue(formObj.darNo));
    		
    		for (var row = HeaderRows ; row <= LastRow ; row++) {
    			
    			if (RowStatus(row) != "D") {
		    		//BKG_NO
		    		ComSetObjValue(formObj.etc5, CellValue(row, BKG_NO));
		    		//DMDT_TRF_CD
		    		ComSetObjValue(formObj.etc6, CellValue(row, TARIFF));
		    		
                    //적용대상 Row에 대해서만  check 하도록 수정함.		    		
					 var cntrTp = sheetBKGObj.CellValue(row, CNTR_TP);
		             var adjSeq = sheetBKGObj.CellValue(row, ADJ_SEQ);

			     	for (var i = sheetCNTRObj.HeaderRows ; i <= sheetCNTRObj.LastRow ; i++) {
			     		if((adjSeq == sheetCNTRObj.CellValue(i, ADJ_SEQ))
			     		    && (cntrTp == "S" || sheetCNTRObj.CellValue(i, FT_FLG) == "1"|| sheetCNTRObj.CellValue(i, AR_FLG) == "1")){
				    		
				    		//조회 실행
				    		doActionIBCommon(sheetBKGObj,formObj,IBSEARCH_CHECK_ROLE,COMMAND12);
				    		if (ComGetObjValue(formObj.role_permit) == "Y") {
				    			isPermit = true;
				    		}else{
				    			isPermit = false;
				    			break;
				    		}
			 		    }
			     		
			     	}	    		

    			}
    		}
    	}

    	ComSetObjValue(formObj.role_permit, isPermit ? "Y" : "N");
    }
    
    /**
     * 조회된 모든 B/L No.를 일련의 스트링으로 변환하여 반환해주는 함수
     */
    function fetchAllBLNo() {
    	var sheetBKGObj = sheetObjects[0];
    	var allBlNo		= "";
    	
    	with(sheetBKGObj) {
	    	for (var row = HeaderRows ; row <= LastRow ; row++) {
	    		if (RowStatus(row) != "D") {
	    			allBlNo += CellValue(row, BL_NO);
	    			if (row < LastRow) allBlNo += ",";
	    		}
	    	}
    	}
    	return allBlNo;
    }
     
     
     /// BACK END JOB Create Start ////////////////////////////////////////////
     /**
     * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
     */
    function getBackEndJobStatus() {
        var formObj 	= document.form;
    	var sheetObj 	= sheetObjects[0];
    	
    	//It gets a status of backendjob. 2
       	ComSetObjValue(formObj.f_cmd, COMMAND02);
       	
      	var sXml 		= sheetObj.GetSearchXml("EES_DMT_2009GS.do", FormQueryString(formObj));
       	var jobState 	= ComGetEtcData(sXml, "jb_sts_flg");

       	if (jobState == "3") {
       		clearInterval(timer);
       		
       		// BackEndJob이 성공 하였습니다.
       		getBackEndJobLoadFile();
       	} 
       	else if (jobState == "4") {
       		clearInterval(timer);
       		
       		// BackEndJob을 실패 하였습니다.
	 		var jbUsrErrMsg	= ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DMT01125");
			ComOpenWait(false);
       	} 
       	else if (jobState == "5") {
       		clearInterval(timer);
       		
       		// 이미 BackEndJob 결과 파일을 읽었습니다.
       		ComShowCodeMessage("DMT01125");

			ComOpenWait(false);
       	}
    }

    function getBackEndJobLoadFile() {
        var formObj 	= document.form;
    	var sheetObj 	= sheetObjects[0];
    	 
     	//It returns a result. 3 
        ComSetObjValue(formObj.f_cmd, 			COMMAND03);
		ComSetObjValue(formObj.aft_expt_dar_no, ComGetObjValue(formObj.darNo));
		ComSetObjValue(formObj.popup_flag, 		isPopupWindow() ? "Y" : "N");
		
    	sheetObj.ShowDebugMsg 		= false;
    	sheetObj.WaitImageVisible 	= false;
    	
    	var sXml = sheetObj.GetSearchXml ("EES_DMT_2009GS.do", FormQueryString(formObj));
    	
    	ComOpenWait(false);
    	
 		//Approval Action 이 정상실행시 조회를 실행한다.
    	if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
    		var exptRqstStsCd = ComGetObjValue(formObj.dmdt_expt_rqst_sts_cd);
    		var msg;
    		var action;
    		
    		if(exptRqstStsCd == 'A') {
    			msg = 'approved';
    			action = 'Approval';
    		} else if(exptRqstStsCd == 'O') {
    			msg = 'counter offered';
    			action = 'CounterOffer';
    		} else if(exptRqstStsCd == 'J') {
    			msg = 'rejected';
    			action = 'Reject';
    		}
    		
    		ComShowCodeMessage("DMT00160", msg);

			if (isPopupWindow()) {
				ComSetObjValue(formObj.popup_upd_dt, handleNullString(ComGetEtcData(sXml, "upd_dt")));
				
				//2006 번 화면에서 팝업으로 띄운경우 현재 화면에서 실행된 Action 에 따라서 2006 번 화면에 조회된 결과에 반영하기 위해서 사용함.
				prevActStatus = ComGetObjValue(formObj.status);
			}
			
 			doActionRetrieve();
 			
		   	//2006번(DEM/DET Adjustment Request & Approval Status) 화면에서 호출될 경우
			//승인한 내역을 Main 화면에 반영시켜준다.
	        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen(action);
	        }
 		}   	
    } 
      
    /// BACK END JOB Create End ////////////////////////////////////////////
    
    /**
     * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
     */
    function handleNullString(sVal) {
   	
        if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";

        return ComTrim(sVal);
    }
    
    /**
	 * After Exception Container Seq. 를 순차적으로 붙여주는 함수.
	 * After Booking 등록 후에 생성된 Charge 정보가 까지 조회되기 때문에
	 */
	function setAfterBookingCNTRSeq() {
		var sheetBKGObj 	= sheetObjects[0];
		var sheetCNTRObj 	= sheetObjects[1];
		
		with(sheetBKGObj) {
			var bkgNo 	= CellValue(SelectRow, BKG_NO);
			var tariff 	= CellValue(SelectRow, TARIFF);
			var adjSeq 	= CellValue(SelectRow, ADJ_SEQ);
		}
		
		var maxCNTRSeq = 0;
		with(sheetCNTRObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	RowStatus(row) != "D"
					&&	RowStatus(row) != "I"
					&&  RowHidden(row) == false
					&&	""		!= CellValue(row, CNTR_SEQ)
					&& 	bkgNo 	== CellValue(row, BKG_NO) 
					&&	tariff 	== CellValue(row, TARIFF) 
					&&	adjSeq 	== CellValue(row, ADJ_SEQ)	) {

					if (ComParseInt(CellValue(row, CNTR_SEQ)) > maxCNTRSeq) maxCNTRSeq = ComParseInt(CellValue(row, CNTR_SEQ));
				}
			}

			maxCNTRSeq++;
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	RowStatus(row) == "I"
					&&  RowHidden(row) == false
					&&  ""		== CellValue(row, CNTR_SEQ)
					&& 	bkgNo 	== CellValue(row, BKG_NO) 
					&&	tariff 	== CellValue(row, TARIFF) 
					&&	adjSeq 	== CellValue(row, ADJ_SEQ)	) {

					CellValue(row, CNTR_SEQ) = maxCNTRSeq++;
				}
			} 			
		}
	}    
	
	/**
     *  [CHM-201433113] APVL OFC : SELHO인 경우 로그인 OFC의 OFC LEVEL '1'이 아닌경우 제한  2014.12.09
     */	
	function checkOfcLvlByAplvOfc() {
		var isChecked = true;
		var formObj = document.form;
		
		if (ComGetObjValue(formObj.approvalOfcCd) == "SELHO") {
			if (ComGetObjValue(formObj.user_ofc_lvl) != "1") {
				ComShowCodeMessage("DMT01170");
				isChecked = false;
			}
		}
		
		return isChecked;
	}	