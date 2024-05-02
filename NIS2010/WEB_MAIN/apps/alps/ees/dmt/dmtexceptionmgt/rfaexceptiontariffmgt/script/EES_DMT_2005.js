/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2005.js
*@FileTitle : DEM/DET Adjustment Request - Before Booking Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.30 이성훈
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
     * @class DEM/DET Adjustment Request - Before Booking Approval 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_2005() {
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
	var IBSEARCH_VER 		= 101;
	var IBSEARCH_PROPNO 	= 102
	var IBSEARCH_RFANO_CUST = 103;
	var IBSEARCH_APRO 		= 106;
	var IBSEARCH_CUST 		= 107;
	var IBSEARCH_VER_APVLNO = 108;
	var IBSEARCH_APVLOFC 	= 109;
	var IBSEARCH_CHECK_ROLE = 110;
	var IBSEARCH_SUB		= 111;
	var IBSEARCH_APRO_NO	= 112;
	var IBSEARCH_VER_CHECK	= 113;
	var IBSAVE_DAR 			= 201;
	var IBSAVE_VERSTS 		= 202;
	var IBSAVE_CANCEL 		= 203;
	var IBSAVE_APPROVAL 	= 204;
	var IBSAVE_COUNTER 		= 205;
	var IBSAVE_REJECT 		= 206;
	var IBSEARCH_OFC        = 207;
	
	//DATA 구분자 정의
	var ROWMARK 			= "|";
	var FIELDMARK 			= "=";

	var TARIFF 				= "dmdt_trf_cd";
	var EFF_DT 				= "eff_dt";
	var EXP_DT 				= "exp_dt";
	var CNTRCGO 			= "dmdt_cntr_cgo_tp_txt";
	var CVRG_CTI 			= "cvrg_conti_cd";
	var CVRG_CNT 			= "cvrg_cnt_cd";
	var CVRG_RGN 			= "cvrg_rgn_cd";
	var CVRG_STE 			= "cvrg_ste_cd";
	var CVRG_LOC 			= "cvrg_loc_cd";
	var FT_FLG 				= "ft_use_flg";	
	var ADD_DYS 			= "add_dys";
	var TOT_DYS 			= "ttl_dys";
	var RT_FROM 			= "ft_ovr_dys";
	var RT_UPTO 			= "ft_und_dys";
	var RT_20FT 			= "cntr_20ft_rt_amt";
	var RT_40FT 			= "cntr_40ft_rt_amt";
	var RT_HC 				= "cntr_hc_rt_amt";
	var RT_45FT 			= "cntr_45ft_rt_amt";
	var RT_R9 		    	= "cntr_r9_rt_amt";
	var RT_SEQ 				= "rfa_expt_rt_seq";
	var RT_MANDATORY 		= "rt_chk_flg";		//RT 가 필수항목인지 여부를 나타냄.(Y: 필수, N: 옵션)
	var RT_CHECK 			= "rt_chk";			//RT 의 체크박스 선택값	
	var SAT_FLG 			= "xcld_sat_flg";
	var SUN_FLG 			= "xcld_sun_flg";
	var HOL_FLG 			= "xcld_hol_flg";
	var ORGDST_MULTI 		= "org_dest_multi";
	var ORGDST_CTI 			= "org_dest_conti_cd";
	var ORGDST_CNT 			= "org_dest_cnt_cd";
	var ORGDST_RGN 			= "org_dest_rgn_cd";
	var ORGDST_STE 			= "org_dest_ste_cd";
	var ORGDST_LOC 			= "org_dest_loc_cd";
	var BKGDEL_CTI 			= "fnl_dest_conti_cd";	
	var BKGDEL_CNT 			= "fnl_dest_cnt_cd";
	var BKGDEL_RGN 			= "fnl_dest_rgn_cd";
	var BKGDEL_STE 			= "fnl_dest_ste_cd";
	var BKGDEL_LOC 			= "fnl_dest_loc_cd";
	var REMARK 				= "expt_trf_rmk";
	var FULL_REMARK 		= "full_expt_trf_rmk";
	var DAR_NO 				= "rfa_expt_dar_no";
	var MAPG_SEQ 			= "rfa_expt_mapg_seq";
	var VER_SEQ 			= "rfa_expt_ver_seq";
	var DTL_SEQ 			= "rfa_rqst_dtl_seq";
	var CVRG_SEQ 			= "cvrg_cmb_seq";
	var CURR_CD 			= "curr_cd";
	var RQST_STS_CD 		= "dmdt_expt_rqst_sts_cd";
	var RQST_STS_DESC 		= "dmdt_expt_rqst_sts_desc";
	var PROG_DT	 			= "prog_dt";
	var PROG_OFC_CD 		= "prog_ofc_cd";
	var PROG_USR_NM 		= "prog_usr_nm";
	var PROG_RMK 			= "prog_rmk";
				
	//ROW 의 실제 삭제여부를 나타내는 변수
	//Request Detail 의 하위 항목은 hidden 상태로 조회되기 때문에 실제 삭제와 구분하기 위해서 사용됨
	var HID_STATUS 			= "hidden_status";

	//Actual Customer
	var CUST_CD 			= "cust_cd";
	var CUST_NM 			= "cust_nm";
	
	//조회시점에 Proposal No.가 변경된 경우 RFA No. Customer, Affiliate, Version 을 재조회하기 위해서 사용하는 변수 
	var prevPropNo 			= "";
	
	//조회시점에 DAR No.가 변경된 경우 Version 을 재조회하기 위해서 사용하는 변수
    var prevDarNo 			= "";
    
	//조회시점에 Approval No.가 변경된 경우 Version 을 재조회하기 위해서 사용하는 변수    
    var prevApvlNo 			= "";
    
    var prevActStatus 		= "";
    
  	//Sort 시 선택되어진 Row 의 선택상태를 계속 유지하기 위해서 사용되는 변수
	var currDtlSeq 			= "";
	
	//현재 버전 내용중에 이전버전에서 추가된 신규내용표시. 2011.12.19 KHH
	var NEW_FLG 	= "new_flg";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         var sheetObject5 = sheetObjects[4];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

	        	case "btn_Affiliate":
					if (ComIsBtnEnable("btn_Affiliate")) 
						doProcessPopup("Affiliate");
					break;
				
	        	case "btn_Retrieve":
					if (ComIsBtnEnable("btn_Retrieve"))
						doActionRetrieve();
					break;

				case "btn_New":
					if (ComIsBtnEnable("btn_New"))
						doActionNew();
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
		var sheetObj 	= sheetObjects[0];

	   	// 팝업으로 호출시에 타이틀 표시 처리
        if (isPopupWindow()) {
	        var spanObj = document.getElementById("title2");
	       	spanObj.innerText = " DEM/DET Adjustment Request - Before Booking Approval";
	       	
	       	if (ComGetObjValue(formObj.caller) == "3107") {
	       		btnCloseLayer.style.display  = "inline";
	       	}
	       	else {
	       		//팝업으로 호출시 팝업에 해당되는 메뉴 버튼들을 보여준다.
	       		btnPopUpLayer.style.display	 = "inline";
	       	}
	   	}
        else {
        	//메인으로 호출시 팝업에 해당되는 메뉴 버튼들을 보여준다.
        	btnMainLayer.style.display	 = "inline";
        }
        
        for (i = 0 ; i < sheetObjects.length ; i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
      		//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		//1.html컨트롤 이벤트초기화
		initControl();
		
		//2.화면 Load 시 비활성화될 컨트롤들을 초기화 시킨다.
		initDisableObjects();
		
     	// User 소속 Office 
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_OFC);

   		//3.로그인 User가 Security 상에서 EES_DMT_2005(DAR-Before BKG Approval)의 Access 권한이 있는지 조회한다.
   		doActionIBCommon(sheetObj,formObj,IBSEARCH_CHECK_ROLE,COMMAND12);

   		//4.메인화면인지 팝업화면인지에 따라서 초기작업이 달라진다.
   		if (isPopupWindow()) {
			//4-1.2006번 화면에서 조회된 결과를 더블클릭해서 팝업으로 현 화면을 띄울경우 넘겨받은 파라미터가 있을 경우 자동조회를 수행한다.
			doActionRetrieve();
		}
		else {
			//4-2.Main 화면으로 Load 될 때에는 버튼을 초기화 시켜준다.
			ComBtnEnable(	"btn_Retrieve"		);
			ComBtnEnable(	"btn_New"			);
			ComBtnDisable(	"btn_Approval"		);
			ComBtnDisable(	"btn_CounterOffer"	);
			ComBtnDisable(	"btn_Reject"		);
		}
    }

 	function initControl() {
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- 키보드 입력할때			
  		axon_event.addListener('keydown', 'ComKeyEnter', 'darNo');
  		axon_event.addListener('keydown', 'ComKeyEnter', 'approvalNo');
	}
 	
 	function initDisableObjects() {
		var formObj = document.form;
		
		with(formObj) {
			//팝업화면으로 Load 될 때에는 DAR No., APVL No. 를 비활성화 시켜준다.
			//팝업화면으로 Load 시 활성화색상에서 비활성화 색상으로 변경되는 부분을 해결하기 위해 기본으로 비활성화시켜서 처리해줘야 함.
			if (isPopupWindow()) {
				ComEnableManyObjects(false, darNo, approvalNo);
	        	darNo.className 		= "input2";
	        	approvalNo.className 	= "input2";
			}
			//메인화면으로 Load 될 때에는 DAR No., APVL No. 를 활성화 시켜준다.
			else {
				ComEnableManyObjects(true, darNo, approvalNo);
	        	darNo.className 		= "input";
	        	approvalNo.className 	= "input";
			}
			
        	ComEnableManyObjects(false, rFANo, proposalNo, custCd, custNm, approvalOfcCd, status, currency, chkMultiOrgDest, chkRateAdjustment);
        	rFANo.className 		= "input2";
        	proposalNo.className 	= "input2";
        	custCd.className 		= "input2";
        	custNm.className 		= "input2";
        	approvalOfcCd.className = "input2";
        	status.className 		= "input2";
        	currency.className 		= "input2";
        	chkMultiOrgDest.className 	= "trans";
        	chkRateAdjustment.className = "trans";
        	
			comment.readOnly 		= true;
			comment.className 		= "textarea2";
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
                    style.height = 185;
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
                    var headCount = ComCountHeadTitle(HeadTitle1) + 13;
                    formObj.sheet1_cnt.value = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, false, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	 	  30,    	daCenter,   	true,     		"ibflag");
                    InitDataProperty(0, cnt++ , dtSeq,    			  30,    	daCenter,   	true,     		"Seq");
					InitDataProperty(0, cnt++ , dtData,			 	  50,		daCenter,		true,			TARIFF,					false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   			  75,		daCenter,		true,			EFF_DT,					false,	"",		dfDateYmd,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   			  75,		daCenter,		true,			EXP_DT,					false,	"",		dfDateYmd,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,   			 120,		daLeft,			true,			CNTRCGO,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData, 		 	  40,		daCenter,		true,			CVRG_CNT,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData, 		 	  40,		daCenter,		true,			CVRG_RGN,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   			  50,		daCenter,		true,			CVRG_LOC,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,  		  20,		daCenter,		true,			FT_FLG,					false,	"",		dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,   			  50,		daCenter,		true,			ADD_DYS,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   			  50,		daCenter,		true,			TOT_DYS,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,		 	  30,		daCenter,		true,			SAT_FLG,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox,  	 	  30,		daCenter,		true,			SUN_FLG,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtCheckBox, 	 	  45,		daCenter,		true,			HOL_FLG,				false,	"",		dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtCombo,   			  40,		daCenter,		true,			ORGDST_MULTI,			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,  		 	  40,		daCenter,		true,			ORGDST_CTI,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,  		 	  40,		daCenter,		true,			ORGDST_CNT,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,  		 	  40,		daCenter,		true,			ORGDST_RGN,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   			  50,		daCenter,		true,			ORGDST_LOC,				false,	"",		dfEngUpKey,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,		 		  40,		daCenter,		true,			BKGDEL_CNT,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		 		  40,		daCenter,		true,			BKGDEL_RGN,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   			  50,		daCenter,		true,			BKGDEL_LOC,				false,	"",		dfEngUpKey,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   			  70,		daCenter,		true,			CUST_CD,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,   			 120,		daCenter,		true,			CUST_NM,				false,	"",		dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,   			 120,		daLeft,			true,			REMARK,					false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			DAR_NO,					false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			MAPG_SEQ,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			VER_SEQ,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			DTL_SEQ,				false,	"",		dfNone,			0,	false,	false);
					
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			CVRG_SEQ,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			CURR_CD,				false,	"",		dfNone,			0,	false,	false);					
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			FULL_REMARK,			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			CVRG_CTI,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			BKGDEL_CTI,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   		   0,		daCenter,		true,			RQST_STS_CD,			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   	   0,		daCenter,		true,			RT_MANDATORY,			false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,   	   	   0,		daCenter,		true,			RT_CHECK,				false,	"",		dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,  		       0,		daCenter,		true,			NEW_FLG,				false,	"",		dfNone,			0,	false,	false);	


					InitDataCombo(0, ORGDST_MULTI, "Single|Multi", "S|M");
					
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
                    InitHeadMode(true, true, false, false, false,false);
					
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	   30,    	daCenter,   	true,     	"ibflag");
                    InitDataProperty(0, cnt++ , dtData,    		   30,    	daCenter,   	true,     	"Seq",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,	   		   80,		daCenter,		false,		ORGDST_CTI,			false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,	   		   80,		daCenter,		false,		ORGDST_CNT,			false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	   	   80,		daCenter,		false,		ORGDST_RGN,			false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   		   80,		daCenter,		false,		ORGDST_LOC,			false,	"",		dfEngUpKey,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	   	   90,		daCenter,		false,		CVRG_CTI,			false,	"",		dfNone,			0,	false,		false);
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
                    var headCount = ComCountHeadTitle(HeadTitle1) + 7;
                    formObj.sheet3_cnt.value = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, false, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 	 30,    	daCenter,   	true,     	"ibflag");
					InitDataProperty(0, cnt++ , dtData,   			 75,		daCenter,		false,		RT_FROM,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   			 75,		daCenter,		false,		RT_UPTO,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   			 85,		daRight,		false,		RT_20FT,			false,	"",		dfNullFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   			 85,		daRight,		false,		RT_40FT,			false,	"",		dfNullFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   			 85,		daRight,		false,		RT_HC,				false,	"",		dfNullFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   			 85,		daRight,		false,		RT_45FT,			false,	"",		dfNullFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,   			 85,		daRight,		false,		RT_R9,				false,	"",		dfNullFloat,	2,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		DAR_NO,				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   		  0,		daCenter,		true,		MAPG_SEQ,			false,	"",		dfNone,			0,	false,		false);					
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		VER_SEQ,			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	  	  0,		dtHidden,		true,		DTL_SEQ,			false,	"",		dfNone,			0,	false,		false);
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
                    InitHeadMode(true, true, false, false, false, false);

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

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			//조회
			case IBSEARCH:
				if (sheetObj.id == "sheet1") {
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
					ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
					ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
					ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	"");
					ComSetObjValue(formObj.f_cmd, 				SEARCH);

					//2.조회조건으로 조회실행
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.WaitImageVisible 		  = false;
					sheetObjects[0].WaitImageVisible = false;
					sheetObjects[3].WaitImageVisible = false;
					//*********************************************************************************
					
					var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));

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
						formObj.comment.className 	= "textarea2";
						//++++++++++++++++++++++++++++++++++++++++++++++++
					}					
				}
				else if (sheetObj.id == "sheet3") {
					var sheetObj1 = sheetObjects[0];
					
					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					var customerCd = ComTrim(formObj.custCd.value);
					ComSetObjValue(formObj.cust_cnt_cd, customerCd.substring(0,2));
					ComSetObjValue(formObj.cust_seq, 	customerCd.substring(2));					
					ComSetObjValue(formObj.f_cmd, 		SEARCH01);
				
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
					var result = ComGetEtcData(sXml, "RATE");
					ComSetObjValue(formObj.result, result);					
				}
				break;
			
	        	
			//Before Booking Request 의 Detail Seq. 에 해당되는 하위 항목들을 조회합니다.	
	        case IBSEARCH_SUB:			
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 	sheetObj.CellValue(sheetObj.SelectRow, DAR_NO));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	sheetObj.CellValue(sheetObj.SelectRow, MAPG_SEQ));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	sheetObj.CellValue(sheetObj.SelectRow, VER_SEQ));
				ComSetObjValue(formObj.rfa_rqst_dtl_seq, 	sheetObj.CellValue(sheetObj.SelectRow, DTL_SEQ));
				ComSetObjValue(formObj.f_cmd, 				SEARCH17);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				sheetObjects[1].WaitImageVisible = false;
				sheetObjects[2].WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
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
					

			//1.DAR No. 나 APVL No. 로 Proposal No. 를 조회한다.
			case IBSEARCH_PROPNO:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 				SEARCH05);
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.rfa_expt_apro_no, 	ComTrim(ComGetObjValue(formObj.approvalNo)));
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
	            var propNo = ComTrim(ComGetEtcData(sXml, "PROP_NO"));
	            if (propNo != "") {
	            	ComSetObjValue(formObj.result, 		"Y");
	            	ComSetObjValue(formObj.proposalNo, 	propNo);
	            }
	            else {
	            	ComSetObjValue(formObj.result, 		"N");
	            }

	            if (ComTrim(ComGetObjValue(formObj.darNo)) == "")
	            	ComSetObjValue(formObj.darNo, 		ComGetEtcData(sXml, "DAR_NO"));
	            //2010-05-27
	            //if (ComTrim(ComGetObjValue(formObj.approvalNo)) == "")
	            //	ComSetObjValue(formObj.approvalNo, 	ComGetEtcData(sXml, "APRO_NO"));
				break;	
							
						
			//2.Proposal No. 로 RFA No. 와 Customer Cd 와 Customer Name 을 조회한다.
			case IBSEARCH_RFANO_CUST:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, 				SEARCH14);
				ComSetObjValue(formObj.prop_no, 			ComGetObjValue(formObj.proposalNo));
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
	            ComSetObjValue(formObj.custCd, ComGetEtcData(sXml, "CUST_CD"));
	            ComSetObjValue(formObj.custNm, ComGetEtcData(sXml, "CUST_NM"));
	            ComSetObjValue(formObj.rFANo, ComGetEtcData(sXml, "RFA_NO"));
				break;	
				
				
			//3.DAR No. 에 해당되는 VER No. 정보를 조회한다.			
			case IBSEARCH_VER:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH02);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//4.선택한 버전정보가 있으면 셋팅한다.
				var ver_value = ComGetObjValue(formObj.version);
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var comboDatas = ComGetEtcData(sXml, "VER");
				if (comboDatas != undefined) {
					addComboItem(formObj.version,comboDatas,false);
				}
				if(ver_value != "") {
					ComSetObjValue(formObj.version, ver_value);
				}
				break;
				
			//3.DAR No. 에 해당되는 현재(DB) VER No. 정보를 조회한다.			
			case IBSEARCH_VER_CHECK:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH02);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				//ComOpenWait(true);
				//sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				//ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				var verList = handleNullString(ComGetEtcData(sXml, "VER"));
				var val = getMaxVersion(verList);
				ComSetObjValue(formObj.max_ver, val);	//max_version 조회
				var val2 = getMaxVersionStatus(verList);
				ComSetObjValue(formObj.max_ver_status, val2);
				
				break;
				
			//4.DAR No. 에 해당되는 Approval Office Code 정보를 조회한다.			
			case IBSEARCH_APVLOFC:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH16);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var comboDatas = ComGetEtcData(sXml, "APVLOFC");
				ComSetObjValue(formObj.approvalOfcCd, comboDatas);
				break;
				
			//5.APVL No. 에 해당되는 VER No. 정보를 조회한다.
			case IBSEARCH_VER_APVLNO:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				//ComSetObjValue(formObj.rfa_expt_apro_no, 	ComGetObjText(formObj.rfa_expt_apro_no));
				ComSetObjValue(formObj.rfa_expt_apro_no, 	ComGetObjValue(formObj.approvalNo));
				ComSetObjValue(formObj.f_cmd, 				SEARCH15);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************	
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************

				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var comboDatas = ComGetEtcData(sXml, "VER");
	            setComboText(formObj.version,comboDatas);
				break;
				
				
			//Approval No. 정보를 조회한다.				
			case IBSEARCH_APRO:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 	"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH11);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var comboDatas = ComGetEtcData(sXml, "APRO");

				if (comboDatas != undefined) {
					var aproArr = comboDatas.split(FIELDMARK);
					ComSetObjValue(formObj.approvalNo, aproArr[0]);
				}
				else {
					ComSetObjValue(formObj.approvalNo, "");
				}
				break;							

			//Approval No. 정보를 조회한다.				
			case IBSEARCH_APRO_NO:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 	ComTrim(ComGetObjValue(formObj.darNo)));
				ComSetObjValue(formObj.rfa_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.prop_no,				ComTrim(ComGetObjValue(formObj.proposalNo)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH18);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
				ComSetObjValue(formObj.approvalNo, ComGetEtcData(sXml, "APVL_NO"));
				break;					
				
			//Proposal No. 에 해당되는 Customer 정보를 조회한다.				
			case IBSEARCH_CUST:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.f_cmd, 				SEARCH12);
			
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));

				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
	            var comboDatas = ComGetEtcData(sXml, "CUST_CD");
				if (comboDatas != undefined) {
					ComSetObjValue(formObj.custCd, comboDatas);
					comboDatas = ComGetEtcData(sXml, "CUST_NM");
					ComSetObjValue(formObj.custNm, comboDatas);
				}	            
				else {
					ComClearObject(formObj.custCd);
					ComClearObject(formObj.custNm);
				}
				break;				
				
				
			//Accept 버튼 클릭시 Version 의 상태정보를 변경하고, 로그테이블에 입력한다.
			case IBSAVE_VERSTS:
				//1.Version 상태정보 변경 요청 전, 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.prop_no, 			ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.sc_expt_ver_seq, 	ComParseInt(ComGetObjText(formObj.version)));
				ComSetObjValue(formObj.f_cmd, 				SEARCH10);
				
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
				
				
			case IBSAVE_APPROVAL:
				//1.삭제 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"A");
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Approved");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		ComGetObjValue(formObj.approvalNo));
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				ComSetObjValue(formObj.f_cmd, 					SEARCH08);					
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
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
				
				
			case IBSAVE_COUNTER:
				//1.삭제 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"O");	
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Counter Offered");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		"");
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));				
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment));
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				ComSetObjValue(formObj.f_cmd, 					SEARCH09);				
				
				//2.선택된 조건으로 삭제실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
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
				
				
			case IBSAVE_REJECT:
				//1.삭제 전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.rfa_expt_dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.rfa_expt_mapg_seq, 		"1");
				ComSetObjValue(formObj.rfa_expt_ver_seq, 		ComGetObjText(formObj.version));				
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_cd, 	"J");	
				ComSetObjValue(formObj.dmdt_expt_rqst_sts_desc, "Rejected");
				ComSetObjValue(formObj.rfa_expt_apro_no, 		"");
				ComSetObjValue(formObj.rfa_no, 					ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.cust_cd, 				ComGetObjValue(formObj.custCd));
				ComSetObjValue(formObj.cust_nm, 				ComGetObjValue(formObj.custNm));
				ComSetObjValue(formObj.prog_rmk, 				ComGetObjText(formObj.comment)); 
				ComSetObjValue(formObj.popup_flag, 				isPopupWindow() ? "Y" : "N");
				ComSetObjValue(formObj.f_cmd, 					SEARCH10);
				
				//2.선택된 조건으로 REJECT 실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("EES_DMT_2005GS.do", FormQueryString(formObj));
				
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
				
				ComSetObjValue(formObj.ofc_cd, usrid_ofc);
				break;	
													
		}
    }
	
	/**
	 * 공통모듈을 조회하기 위한 함수
	 */	
    function doActionIBCommon(sheetObj,formObj,sAction,sComboAction) {
	    sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
	    switch(sAction) {
	    
	    	//2005 화면에 대한 ROLE 이 있는지 조회한다.
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
				
				//3.조회후 결과처리
				ComSetObjValue(formObj.role_auth, 	handleNullString(ComGetEtcData(sXml, "ROLE_AUTH")));
				ComSetObjValue(formObj.role_permit, handleNullString(ComGetEtcData(sXml, "ROLE_PERMIT")));
				break;
	    }
		sheetObj.WaitImageVisible = true;
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
		
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		if (OldRow >= sheetObj.HeaderRows && OldRow != NewRow) {
			
			//-------------------------------------------
			currDtlSeq = sheetObj.CellValue(sheetObj.SelectRow, DTL_SEQ);
			//-------------------------------------------
			
			//선택한 Detail Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
			setSubBeforeException(true);
		}		
	}	 
	
	/**
	 * Sheet1 에 마우스를 오버할 경우 각 필드에 따라서 툴팁정보를 보여준다.
	 */	
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {

		with(sheetObj) {
			var colName = ColSaveName(MouseCol);
			
			if (MouseRow >= HeaderRows && MouseRow <= LastRow) {

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
	 * Row 가 선택될 때 해당 Comment 를 보여준다.
	 */	
	function sheet4_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
		var formObj = document.form;
		
		//선택한 Row 위치가 변경될 때마다 아래 로직을 수행한다.
		if (OldRow >= sheetObj.HeaderRows && OldRow != NewRow) {
			ComSetObjValue(formObj.comment, sheetObj.CellValue(NewRow, PROG_RMK));
		}		
	}
		
	/**
	 * Before Booking Request Detail 에 등록된  데이터 조회하는 동작을 정의하는 함수
	 */		
	function doActionRetrieve() {
		var formObj 		= document.form;
		var sheetRFAObj		= sheetObjects[0];
		var sheetCVRGObj	= sheetObjects[1];
		var sheetRTObj		= sheetObjects[2];
		var sheetHSTObj		= sheetObjects[3];
		
		//1.조회전 DAR No. 나 APVL No. 중 하나는 반드시 입력되어야 한다.
		var currDarNo 	= ComTrim(ComGetObjValue(formObj.darNo));
		var currApvlNo 	= ComTrim(ComGetObjValue(formObj.approvalNo));
		
		if (currDarNo == "" && currApvlNo == "") {
			ComShowCodeMessage("DMT02002", "DAR No. or APVL No.");
			ComSetFocus(formObj.darNo);
			return;
		}
		//2.DAR No. 나 APVL No. 로 ., Proposal No 정보를 조회한다.
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_PROPNO);
		
		//2010-05-27
		//currApvlNo = ComTrim(ComGetObjValue(formObj.approvalNo));
		
		if (ComGetObjValue(formObj.result) == "N") {
			ComShowCodeMessage("DMT06001");
			ComSetFocus(formObj.darNo);
			return;
		}
		var currPropNo = ComTrim(ComGetObjValue(formObj.proposalNo));
		
		//3.조회된 Proposal No 가 다를 경우에만 아래 내용을 수행한다.
		if (prevPropNo != currPropNo) {
			//3-1.Proposal No. 로 RFA No. 와 Customer 를 조회한다.
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_RFANO_CUST);
		}

		//4.Proposal No. 나 DAR No. 나 Approval No. 가 변경된 경우라면 Version 정보에 대해서 재설정해 준다.
		if (prevPropNo != currPropNo || prevDarNo != currDarNo || prevApvlNo != currApvlNo) {
			
			//4-1.DAR No. 에 대한 Approval Office 를 조회한다.
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APVLOFC);
			
			//4-2.DAR No. 에 포함된 VER 목록을 조회한다.
			doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER);
			
			//4-3.APVL No. 로 조회한 경우라면 APVL No. 버전을 조회해서 설정해준다.
			if (ComTrim(ComGetObjValue(formObj.approvalNo)) != "") {
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_VER_APVLNO);
			}

			//4-4.Status 정보를 Version 정보에서 찾아서 설정한다.
			ComSetObjValue(formObj.status, getVerStatus("Text"));
			
			//4-5.Status 가 Approved 일 경우 Approval No. 를 조회한다.
			if (getVerStatus("Code") == "A") {
				//doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO);
				doActionIBSheet(sheetRFAObj, formObj, IBSEARCH_APRO_NO);
			}
		}
		
		//조회조건 필드 정보에 대한 재조회인지를 구분하기 위해서 아래 변수값을 설정한다.
		prevPropNo 	= currPropNo;
		prevDarNo 	= currDarNo;
		prevApvlNo 	= currApvlNo;
		
		//4.DEM/DET Adjustment Request - Before Booking Request 정보와 Comment History 정보를 조회한다.
		doActionIBSheet(sheetRFAObj, formObj, IBSEARCH);
		//--------------------------------------------------------------------
		currDtlSeq = sheetRFAObj.CellValue(sheetRFAObj.SelectRow, DTL_SEQ);
		//--------------------------------------------------------------------
		
		//5.조회결과가 있을 경우
		if (sheetRFAObj.RowCount > 0) {

			//5-1.DAR No. 와 APVL No. 를 비활성화 시킨다.(Data 꼬임 방지) 장민지대리 요청사항
			with(formObj) {
				ComEnableManyObjects(false, darNo, approvalNo);
				darNo.className 		= "input2";
				approvalNo.className 	= "input2";
			}
			
			//선택한 Detail Seq. 에 맞도록 하위 정보들을 갱신한다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
			setSubBeforeException(true);
		}
		else {
			//하위 그리드를 초기화 시킨다.
			sheetCVRGObj.RemoveAll();
			sheetRTObj.RemoveAll();
			sheetHSTObj.RemoveAll();
			
			//하위 정보들을 초기화 시킨다.(매개변수는 하위항목을 조회할것인지를 나타낸다.) 
			setSubBeforeException(false);			
		}

//		formObj.approvalNo.value = currApvlNo;
		//6.메인 버튼의 상태를 주어진 조건에 따라서 활성화 or 비활성화 시킨다.
		initBtnControl();
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

		//2.Multi Coverage 의 체크박스와 입력상태를 변경해준다.
		setMultiOrgDestGrid();

		//3.Rate Adjustment 의 체크박스와 입력상태를 변경해준다.
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
			}
			else {
				formObj.chkMultiOrgDest.checked = false;
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

			//Currency 를 설정해 준다.
			ComSetObjValue(formObj.currency, CellValue(SelectRow, CURR_CD));
		}
	}
		
   /**
    * Version 이 변경될 경우 해당 데이터를 조회한다.
    */		 
    function checkRFAByVersion() {
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	
    	var version = ComTrim(ComGetObjValue(formObj.version));
    	if (version != "") {

			//1.2번째 조회필드 항목을 Clear 시킨다.
			ComClearObject(formObj.approvalNo);	//APVL No.
			ComClearObject(formObj.status);		//Status
		
			//2.모든 결과 필드들을 Clear 시킨다.
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			formObj.comment.value = "";		

			//3.선택한 Version 이 승인일 경우 APVL No.를 조회한다.
			if (getVerStatus("Code") == "A") {
				//doActionIBSheet(sheetObj, formObj, IBSEARCH_APRO);
				doActionIBSheet(sheetObj, formObj, IBSEARCH_APRO_NO);
			} 			
    		
			//4.Status 값을 설정해 준다.
			ComSetObjValue(formObj.status, getVerStatus("Text"));
			//5.조회 모듈을 태운다.
			doActionRetrieve(); 			
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
	function addMultiComboItem(comboObj,comboItems) {
   	  
    	for (var i = 0 ; i < comboItems.length ; i++) {
			if (ComTrim(comboItems[i]) != "") {
    			var comboItem = comboItems[i].split(FIELDMARK);
				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
			}
    	}
	}
	
    /**
     * 주어진 값과 동일한 콤보필드에 있는 항목의 Text 를 찾아서 선택해준다. 
     */	
 	function setComboText(comboObj,comboItem) {
    	  
     	for (var i = 0 ; i < comboObj.length ; i++) {
     		if (comboObj[i].text == comboItem) {
     			comboObj[i].selected = true;
     			break;
     		}
     	}
 	}
 	
	/**
	 * NEW 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */		
	function doActionNew() {
		var formObj = document.form;
		
		//1.조회필드들을 Empty 시킨다.
		ComClearObject(formObj.rFANo);	
		ComClearObject(formObj.proposalNo);
		ComClearObject(formObj.custCd);
		ComClearObject(formObj.custNm);
		ComClearObject(formObj.approvalOfcCd);
		ComClearObject(formObj.darNo);
		ComClearCombo(formObj.version);
		ComClearObject(formObj.approvalNo);
		ComClearObject(formObj.status);
		
		//1-1.조회필드 활성화
		enableConditionObjects(true);		
		
		//2.조회결과의 모든 Grid 들을 Empty 시킨다.
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[3].RemoveAll();
		
		//3.Multi Origin or Dest. 와 Rate Adjustment 와 Comment 컨트롤의 상태를 Disable 로 초기화 시킨다.
		with(formObj) {
			chkMultiOrgDest.checked = false;
			chkRateAdjustment.checked = false;
			ComSetObjValue(currency, "");
			
			//Comment 초기화 +++++++++++++++++++++++++++++++++++
			chkComment.checked 		= false;
			
			comment.readOnly 		= true;
			comment.className 		= "textarea2";
			ComSetObjValue(comment, "");
			//+++++++++++++++++++++++++++++++++++++++++++++++++
		}		
		
		//4.버튼 상태를 초기화 시킨다.
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnDisable("btn_Approval");
		ComBtnDisable("btn_CounterOffer");
		ComBtnDisable("btn_Reject");
		
		//5.New 클릭후 재조회를 위해서는 아래 변수를 Empty 로 초기화 시켜야 한다.
		prevPropNo 	= "";
		prevDarNo 	= "";
		prevApvlNo 	= "";
	}
	 
	/**
	 * 조회필드들의 상태를 변경해주는 함수
	 */				
	function enableConditionObjects(flag) {
		var formObj = document.form;
		
		with(formObj) {
			ComEnableManyObjects(flag, darNo, version, approvalNo);
			darNo.className 		= "input";
			version.className 		= "input2";
			approvalNo.className 	= "input";
		}		
	}
	
	/**
	 * APPROVAL 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionApproval() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","Retrieve");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================			

		if (!ComShowCodeConfirm("DMT00135", "approve")) { return; }
		
		//APPROVAL 실행시 Comment 는 필수입력사항이다.				
		if (!validateComment()) return;	
		
		//2.Approval Action 을 수행한다.
		doActionIBSheet(sheetObj,formObj,IBSAVE_APPROVAL);
		
		//3.저장 Action 이 정상실행시 조회를 실행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			
			//2006 번 화면에서 팝업으로 띄운경우 현재 화면에서 실행된 Action 에 따라서 2006 번 화면에 조회된 결과에 반영하기 위해서 사용함.
			prevActStatus = ComGetObjValue(formObj.status);
			
			//조회를 수행하기 위해서 아래 전역변수 값들을 지워준다.
			prevPropNo 	= "";
			prevDarNo 	= "";
			prevApvlNo 	= "";
			
			doActionRetrieve();
			
		   	//2006번(DEM/DET Adjustment Request & Approval Status) 화면에서 호출될 경우
			//승인한 내역을 Main 화면에 반영시켜준다.
	        if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen("Approval");
	        }
		}
	}
	
	/**
	 * COUNTER OFFER 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionCounterOffer() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","Retrieve");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================	
			
		if (!ComShowCodeConfirm("DMT00135", "counter offer")) { return; }

		//COUNTER OFFER 실행시 Comment 는 필수입력사항이다.				
		if (!validateComment()) return;			
		
		//2.Counter Offer Action 을 수행한다.			
		doActionIBSheet(sheetObj,formObj,IBSAVE_COUNTER);

		//3.저장 Action 이 정상실행시 조회를 실행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			
			//2006 번 화면에서 팝업으로 띄운경우 현재 화면에서 실행된 Action 에 따라서 2006 번 화면에 조회된 결과에 반영하기 위해서 사용함.
			prevActStatus = ComGetObjValue(formObj.status);
			
			//조회를 수행하기 위해서 아래 변수 값들을 지워준다.
			prevPropNo 	= "";
			prevDarNo 	= "";
			prevApvlNo 	= "";
			
			doActionRetrieve();
			
		   	//2006번(DEM/DET Adjustment Request & Approval Status) 화면에서 호출될 경우
			//Counter Offer 한 내역을 Main 화면에 반영시켜준다.
			if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen("CounterOffer");
	        }			
		}		
	}
	
	/**
	 * REJECT 버튼을 클릭할 경우 실행될 동작을 정의하는 함수
	 */				
	function doActionReject() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		
		//현재 DB상의 VERSION정보를 조회하여 화면상의  VERSION정보와 체크 한다.============================================
		doActionIBSheet(sheetObj, formObj, IBSEARCH_VER_CHECK);

		var dis_status = getVerStatus("Code");
		var max_status = ComGetObjValue(formObj.max_ver_status);
		var curver     = ComTrim(ComGetObjText(formObj.version));
		var maxver	   = ComGetObjValue(formObj.max_ver);

		if(curver != maxver || dis_status != max_status) { 
			ComShowCodeMessage("DMT01148","Retrieve");//Version status has changed. Pls click New button
			return;
		}
		//=====================================================================================================	
			
		if (!ComShowCodeConfirm("DMT00135", "reject")) { return; }
						
		//REJECT 실행시 Comment 는 필수입력사항이다.				
		if (!validateComment()) return;		
						
		//2.Reject Action 을 수행한다.			
		doActionIBSheet(sheetObj,formObj,IBSAVE_REJECT);

		//3.저장 Action 이 정상실행시 조회를 실행한다.
		if (ComGetObjValue(formObj.result) == "Y") {
			
			//2006 번 화면에서 팝업으로 띄운경우 현재 화면에서 실행된 Action 에 따라서 2006 번 화면에 조회된 결과에 반영하기 위해서 사용함.
			prevActStatus = ComGetObjValue(formObj.status);
			
			//조회를 수행하기 위해서 아래 변수 값들을 지워준다.
			prevPropNo 	= "";
			prevDarNo 	= "";
			prevApvlNo 	= "";
			
			doActionRetrieve();
			
		   	//2006번(DEM/DET Adjustment Request & Approval Status) 화면에서 호출될 경우
			//Reject 한 내역을 Main 화면에 반영시켜준다.
			if (isPopupWindow() && ComGetObjValue(formObj.caller) == "2006") {
	        	commitMainScreen("Reject");
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
	 * 메인 버튼에 대해서 주어진 조건에 따라 상태를 변경하는 함수 
	 */					
	function initBtnControl() {
		//Retrieve Button
		initBtnRetrieve();
		//New Button
		initBtnNew();
		//Approval Button
		initBtnApproval();
		//Counter Offer Button
		initBtnCounterOffer();
		//Reject Button
		initBtnReject();
	}
				
	/**
	 * 조건에 따라서 Retrieve 버튼의 상태가 변경된다.
	 */		
	function initBtnRetrieve() {
        var formObj = document.form;
		 
        //2006번 화면에서 팝업으로 띄우는 Before 화면은 Retrieve와 New는 비활성화하는 것이 나을듯(2009-11-10(화))
        if (isPopupWindow()) {
        	ComBtnDisable("btn_Retrieve");
        }
        else {
        	ComBtnEnable("btn_Retrieve");
        }
	}
	
	/**
	 * 조건에 따라서 New 버튼의 상태가 변경된다.
	 */		
	function initBtnNew() {
	    var formObj = document.form;
		
        //2006번 화면에서 팝업으로 띄우는 Before 화면은 Retrieve와 New는 비활성화하는 것이 나을듯(2009-11-10(화))
	    if (isPopupWindow()) {
        	ComBtnDisable("btn_New");
        }
        else {
        	ComBtnEnable("btn_New");
        }		
	}

	/**
	 * 조건에 따라서 Approval 버튼의 상태가 변경된다.
	 */		
	function initBtnApproval() {
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
			
	/**
	 * 조건에 따라서 Reject 버튼의 상태가 변경된다.
	 */		
	function initBtnReject() {
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
	}
			
	/**
	 * 조건에 따라서 Counter Offer 버튼의 상태가 변경된다.
	 */		
	function initBtnCounterOffer() {
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
 		var sheetObj1 = sheetObjects[0];
 		var sheetObj2 = sheetObjects[1];
 		 
 		var trfCd = sheetObj1.CellValue(sheetObj1.SelectRow, TARIFF);

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
 		
 		sheetObj2.InitHeadRow(0, HeadTitle1, true);
 		sheetObj2.InitHeadRow(1, HeadTitle2, true);  		
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
 		var formObj = document.form;
 		
 		var rFANo 	= ComTrim(ComGetObjValue(formObj.rFANo));
 		var propNo 	= ComTrim(ComGetObjValue(formObj.proposalNo));		
 		var custCd 	= ComTrim(ComGetObjValue(formObj.custCd));
 		var custNm 	= ComTrim(ComGetObjValue(formObj.custNm));
 		var status 	= ComTrim(ComGetObjValue(formObj.status));
 		var caller	= ComTrim(ComGetObjValue(formObj.caller));
 		
		if (caller == "3107") {
			isActBtnCopy = "N";
		}
		else if (status == "" || status == "Temp. Saved") {
			isActBtnCopy = "Y";
		}
		else {
			isActBtnCopy = "N";
		}
		
 		var params = "rfa_no=" + rFANo;
 		params += "&prop_no=" + propNo;		
 		params += "&cust_cd=" + custCd;
 		params += "&cust_nm=" + custNm;
 		params += "&status=" + status;
 		params += "&is_copy=" + isActBtnCopy;
 		
 		ComOpenPopup("EES_DMT_2105.do?" + params, 920, 480, "copyDARHistory", "1,0,1,1,1,1,1", true);		
 	}
 	
  	/**
	 * 2005 화면이 팝업으로 띄워졌는지를 알려주는 함수
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
        var receivedSheetObj 	= window.dialogArguments.sheetObjects[1];
        var sentSheetObj 		= window.dialogArguments.sheetObjects[4];
        
        //조회조건으로 DATE 선택시에만 하기 로직을 수행한다.(승인처리시에는 Received Tab 에 데이터를 삭제하고 Send Tab 으로 이동)
        if (!window.dialogArguments.document.form.cond_type[0].checked) return;
        
        //DAR No., Ver No. 가 동일한 Received Tab 에 데이터를 삭제하고 Send Tab 에 추가해준다.
        var sheetId		= ComGetObjValue(formObj.sheetId);
        var reqOfc		= (sheetId == "t1sheet2") 	? receivedSheetObj.CellValue(	receivedSheetObj.SelectRow, 	"req_ofc_cd"		) 
													: sentSheetObj.CellValue(		sentSheetObj.SelectRow, 		"req_ofc_cd"		);
        var apvlOfc		= (sAction != "Requested")  ? ComGetObjValue(formObj.ofc_cd) : "";
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
        		if (sAction == "Requested") {
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
		var verNo		= ComGetObjText(formObj.version);
		
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (darNo == CellValue(row, "dar_no") && verNo == CellValue(row, "ver_no")) {
					CellValue(row, "apvl_no") 		= sAction == "Approval" ? ComGetObjValue(formObj.approvalNo) : "";
					CellValue(row, "status") 		= ComGetObjValue(formObj.status);
					CellValue(row, "apro_ofc_cd") 	= ComGetObjValue(formObj.ofc_cd);
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
		var verNo			= ComGetObjText(formObj.version);
		
		with(fromSheetObj) {
			for (var row = LastRow ; row >= HeaderRows ; row--) {
				
				if (darNo == CellValue(row, "dar_no") && verNo == CellValue(row, "ver_no")) {
					if (!isAppliedRow) {
						
						//데이터 행 추가
		                var addedRow = toSheetObj.DataInsert(toSheetObj.RowCount);
		                
		                //데이터 옮기기
		                var fieldValue = "";
		                for (ic = 0 ; ic <= LastCol ; ic++) {

		                	switch(ColSaveName(ic)) {
			                	case "apvl_no":
			                		fieldValue = sAction == "Approval" ? ComGetObjValue(formObj.approvalNo) : "";
			                		break;
			                		
			                	case "status":
			                		fieldValue = ComGetObjValue(formObj.status);
			                		break;
			                		
			                	case "apro_ofc_cd":
			                		fieldValue = sAction != "Requested" ? ComGetObjValue(formObj.ofc_cd) : "";
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
	function isPermitStatus(sts) {
	    var formObj = document.form;
	 
	    var status = ComTrim(ComGetObjValue(formObj.status));
		if (sts == "Approval") {
			if (status == "Requested")
			    return true;
		}
	    else if (sts == "CounterOffer") {
			if (status == "Requested")
			    return true;
	    }
	    else if (sts == "Reject") {
			if (status == "Requested")
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
     