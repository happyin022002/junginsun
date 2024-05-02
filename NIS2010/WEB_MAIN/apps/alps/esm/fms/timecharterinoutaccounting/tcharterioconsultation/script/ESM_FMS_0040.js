/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0040.js
*@FileTitle : Manual Slip
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.08.17 최우석
* 1.0 Creation
* 2010.09.01 윤진영 [CHM-201005625] FMS Acct Payable-Manual Slip Validation 수정
* 2010.10.11 원종규 [CHM-201006342-01] Manual Slip Evidence Type & Currency Error 수정
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
     * @class esm_fms_0040 : esm_fms_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0040() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.setSlpIssDt			= setSlpIssDt;
    	this.initConfirm			= initConfirm;
    	this.initControl			= initControl;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_keypress			= obj_keypress;
    	this.eng_keypress			= eng_keypress;
    	this.obj_change				= obj_change;
    	this.setVndrSeq				= setVndrSeq;
    	this.setEffDt				= setEffDt;
    	this.obj_activate			= obj_activate;
    	this.setCsulSlp				= setCsulSlp;
    	this.setSheetInfo			= setSheetInfo;
    	this.sheet1_OnChange		= sheet1_OnChange;
    	this.setDrDiff				= setDrDiff;
    	this.sheet1_OnSaveEnd		= sheet1_OnSaveEnd;
    	this.inputReadOnly			= inputReadOnly;
    	this.initRdConfig			= initRdConfig;
    	this.rdOpen					= rdOpen;
    	this.setRqstDt				= setRqstDt;
    	this.checkKeyNumber			= checkKeyNumber;
    	this.checkVvdCd				= checkVvdCd;
    	this.checkSlpFuncCd			= checkSlpFuncCd;
    	this.checkAcctCdVvdLevelMdt	= checkAcctCdVvdLevelMdt;
    	this.checkAcctCdVvdLevel	= checkAcctCdVvdLevel;
    }

   	/* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var rdObjects = new Array();
    var rdCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];

        /*******************************************************/
        var formObject = document.form;

        try {
        	var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {
    			case "btn_Brokerage":
    				if(validateForm(sheetObject,formObject)) {
	    			  	for (var row=1; row<=sheetObject.LastRow; row++) {
	    					if(sheetObject.CellValue(row, "flet_ctrt_no") != "") {
	    						sheetObject.RowHidden(row)= true;
	    						sheetObject.RowStatus(row)= "D";
	    					}
	    				}
	    			  	
	    			  	curr_cd = form.csr_curr_cd.value;
    					ComOpenPopup("ESM_FMS_00401.do?curr_cd="+curr_cd, 900, 395, "setCsulSlp", "1,0,1,1,1", false, false, null, null, null, "esm_fms_00401");
    				}
					break;
						
    			case "btn_RowAdd":
    				if(validateForm(sheetObject,formObject)) {
						var row = sheetObject.DataInsert(-1);
						setSheetInfo(row);
						sheetObject.CellFont("FontName", row, "vvd_cd") = "Courier New";
						sheetObject.CellFont("FontName", row, "slp_loc_cd") = "Courier New";
					}
					break;

    			case "btn_RowDel":
    				ComRowHideDelete(sheetObject, "DelChk");
    				setDrDiff();
					break;

    			case "btn_New":
    				if(!initConfirm()) return;
        			ComResetAll();
        			setSlpIssDt();
        			inputReadOnly("0");
					break;

    			case "btn_Save":    				    				
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

    			case "btn_TaxEvidence":
    				if(validateForm(sheetObject,formObject,IBSEARCH) == false) return;
    				
	        		// TAX구분(TAX/CI일때만)
	        		var evid_tp_cd = form.evid_tp_cd.value;
	        		// Effective DT값
	        		var tax_inv_yrmon = formObject.eff_dt.value;
	        		var vndr_seq = formObject.vndr_seq.value;
	        		
	        		ComOpenPopup("ESM_FMS_0029.do?tax_inv_yrmon="+tax_inv_yrmon+"&evid_tp_cd="+evid_tp_cd+"&own_gubun=own"+"&vndr_seq="+vndr_seq, 917, 562,"setTaxEvidence", "1,0,1,1,1", false);
	        		break;

    			case "btn_SlipInquiry":
    				ComOpenWindowCenter("ESM_FMS_0041_1.do?popup=yes", "esm_fms_0041_1", 1024, 590, false);
    				//ComOpenWindowCenter("ESM_FMS_0041.do?popup=yes", "esm_fms_0041", 1024, 590, false);
					break;
				
				//2017.04.18 preview 기능 추가
	        	case "btn_preview":
	        		rdOpenPreview(rdObjects[0], document.form);
	        		break;
	        		
    			case "btn_Print":
    				rdOpen(rdObjects[0], document.form);
					break;
				
    			case "btn_vndrSeq":
    				ComOpenPopup("ESM_FMS_0070.do?condFlag=VP", 520, 430, "setVndrSeq", "1,0,1,1,1", false);
    				break;
    				
    			case "btn_effDt":
    				var cal = new ComCalendar();
    				cal.setDisplayType('date');
    				cal.setEndFunction('setEffDt');
					cal.select(form.eff_dt, 'yyyy-MM-dd');
    				break;
    			
    			case "btn_rqstDt":
    				var cal = new ComCalendar();
    				cal.setDisplayType('date');
    				cal.setEndFunction('setRqstDt');
					cal.select(form.rqst_dt, 'yyyy-MM-dd');
    				break;
    				
    			case "apro_step_btn" :
    				if(form.csr_no.value != "") return; 
    				var v_ofc_cd = formObject.slp_ofc_cd.value;
    	    	    
    	    	    
    	    	    var v_sub_sys_cd = "FMS";
    	            var param = "?mode=save&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&classId=COM_ENS_0T1"+"&target_obj_nm=apro_step";
    					ComOpenPopup('/hanjin/COM_ENS_0T1.do'+param, 835, 540, '', 'none', true);
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
	        //khlee-시작 환경 설정 함수 이름변경
	        ComConfigSheet (sheetObjects[i] );

	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
	        
	        sheetObjects[i].ExtendLastCol = false;
        }
        
        //RD
		initRdConfig(rdObjects[0]);

        initControl();
        
        setSlpIssDt();
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "slp_func_cd");
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "evid_tp_cd");
        
    	//Payments Slip TaxEvidence Button Disable 하기
    	ComBtnDisable("btn_taxEvidence");	
    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj, document.form, IBSEARCH, "slp_func_cd");
		doActionIBSheet(sheetObj, document.form, IBSEARCH, "evid_tp_cd");
		
		sheetObj.WaitImageVisible = true;   
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;

    	switch(sheetNo) {
    	 	case 1:
    	 		with (sheetObj) {

    	 			// 높이 설정
                    style.height = 260;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);
 
					var HeadTitle1 = "|Sel.|Seq.|Acct Code|Vendor Code|Center Code|City|Effective Date|Slip Amount|Description|VVD Code|Key Number|csr_no|flet_ctrt_no|flet_iss_tp_cd|inv_seq|inv_dtl_seq";
					var headCount = ComCountHeadTitle(HeadTitle1);
     
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,  	30,    	daCenter,  	true,  	"DelChk");
					InitDataProperty(0, cnt++, dtDataSeq,		40,    	daCenter,  	true,   "Seq");
					InitDataProperty(0, cnt++, dtData,      	80,		daCenter,	false,	"acct_cd",		 true,	"",	dfNone,			0,	true,	true, 	6);
					InitDataProperty(0, cnt++, dtData,      	90,		daCenter,	false,	"vndr_seq",		 true,	"",	dfNone,			0,	true,	true, 	6);
					InitDataProperty(0, cnt++, dtData,      	90,		daCenter,	false,	"ctr_cd",		 true,	"",	dfNone,			0,	true,	true, 	6);
					InitDataProperty(0, cnt++, dtData,      	60,		daCenter,	false,	"slp_loc_cd",	 true,	"",	dfNone,			0,	false,	false, 	5);
					InitDataProperty(0, cnt++, dtData,      	90,		daCenter,	false,	"eff_dt",		 false,	"",	dfDateYmd,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,   	   	90,		daRight,	false,	"csr_amt",		 false,	"",	dfFloat,	2,	true,	true, 	18);
					InitDataProperty(0, cnt++, dtData,      	214,	daLeft,		false,	"csr_desc",		 true,	"",	dfNone,			0,	true,	true, 	50);
					InitDataProperty(0, cnt++, dtData,      	80,		daCenter,	false,	"vvd_cd",		 false,	"",	dfNone,			0,	true,	true, 	10);
					InitDataProperty(0, cnt++, dtData,			100,	daCenter,	false,	"to_inv_no",	 false,	"",	dfNone,			0,	false,	false, 	12);

					// ---------------------------------------------------------------------------
					InitDataProperty(0, cnt++, dtHidden,      	30,		daCenter,	false,	"csr_no",		 false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,      	30,		daCenter,	false,	"flet_ctrt_no",	 false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,      	30,		daCenter,	false,	"flet_iss_tp_cd",false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,      	30,		daCenter,	false,	"inv_seq",		 false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++, dtHidden,      	30,		daCenter,	false,	"inv_dtl_seq",	 false,	"",	dfNone,			0,	false,	false);
					//InitDataProperty(0, cnt++, dtHidden,      	30,		daCenter,	false,	"apro_step",	 false,	"",	dfNone,			0,	false,	false);
					// ---------------------------------------------------------------------------

                    InitDataValid(0, "acct_cd", vtNumericOnly);
                    InitDataValid(0, "vndr_seq", vtNumericOnly);
                    InitDataValid(0, "ctr_cd", vtNumericOnly);
                    InitDataValid(0, "vvd_cd", vtEngUpOther, "0123456789");
    	 		}
    	 		break;
    	 		
    	 	case 2:      //sheet2
	            with (sheetObj) {
	            	var prefix = "tax_";
	                // 높이 설정
	                style.height = 120;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);	
	                
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false, false)
	
	                var HeadTitle = "|Seq|Sel|tax_inv_yrmon|ofc_cd|tax_iss_cd|tax_vat_tp_cd|tax_naid_flg|tax_div_cd|fa_flg|tax_pl_cd|tax_nsl_flg|spl_rgst_no|ownr_nm|co_nm|bzct_nm|bztp_nm|spl_addr|iss_dt|spl_amt|tax_amt|total_amt|SLP_TP_CD|SLP_FUNC_CD|SLP_OFC_CD|SLP_ISS_DT|SLP_SER_NO|CRE_USR_ID|UPD_USR_ID";
	                var headCount = ComCountHeadTitle(HeadTitle);

	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);       
	                	                										  //134
	                //데이터속성    	[ROW, COL,  DATATYPE,     WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  	   			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,    	prefix + "ibflag");
	                InitDataProperty(0, cnt++ , dtSeq,    		40,    	daCenter,  	true,    	prefix + "Seq");
					InitDataProperty(0, cnt++ , dtDummyCheck,   40,    	daCenter,  	false,		prefix + "DelChk");
	                InitDataProperty(0, cnt++ , dtData,      	180,   	daCenter,  	false,    	prefix + "tax_inv_yrmon",		false,          "",      	dfDateYm,   	0,     	true,       true);
	                InitDataProperty(0, cnt++ , dtData,      	180,   	daCenter,  	false,      prefix + "ofc_cd",				false,          "",      	dfNone,   		0,     	true,       true);
	                InitDataProperty(0, cnt++ , dtData,      	110,   	daCenter,  	false,    	prefix + "tax_iss_cd",			false,          "",      	dfNone,      	0,     	false,      false);
	                InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_vat_tp_cd",		false,          "",      	dfNone,      	0,     	false,      false);
					InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "tax_naid_flg",    	false,          "",      	dfNone,   		0,     	false,      true);
					InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "tax_div_cd",     		false,          "",      	dfNone,   		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "fa_flg",     			false,          "",      	dfNone,  		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	99,    	daRight,   	false,    	prefix + "tax_pl_cd",			false,          "",      	dfNone, 		2,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_nsl_flg",			false,          "",      	dfNone,      	0,     	true,       false);
					
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "spl_rgst_no",			false,          "",      	dfNone,      	0,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "ownr_nm",  			false,          "",      	dfNone,   		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	161,   	daCenter,  	false,    	prefix + "co_nm",  				false,          "",      	dfNone,   		0,     	true,       true);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "bzct_nm",				false,          "",      	dfNone,      	0,     	true,       false);
					
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "bztp_nm",				false,          "",      	dfNone,      	0,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "spl_addr",			false,          "",      	dfNone,      	0,     	true,       false);
					
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "iss_dt",				false,          "",      	dfDateYmd,      0,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "spl_amt",				false,          "",      	dfNullFloat,    2,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "tax_amt",				false,          "",      	dfNullFloat,    2,     	true,       false);
					InitDataProperty(0, cnt++ , dtData,      	134,   	daCenter,  	false,    	prefix + "total_amt",			false,          "",      	dfNullFloat,    2,     	true,       false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_tp_cd",			false,			"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_func_cd",			false,			"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_ofc_cd",	    	false,			"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      	65,		daCenter,	true,		prefix + "slp_iss_dt",			false,			"",			dfDateYmd,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      	60,		daLeft,		false,		prefix + "slp_ser_no",			false,			"",			dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "cre_usr_id",			false,			"",			dfNone,			0,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	110,	daRight,	true,		prefix + "upd_usr_id",			false,			"",			dfNone,			0,		false,		true);
	            }
    	 		break;
            
	        case 3:      //sheet3
	            with (sheetObj) {
	            	var prefix = "txd_";
	            	
	                // 높이 설정
	                style.height = 120;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					var HeadTitle1 = " |순번|Sel|품명|공급가액|세액|합계";
					var headCount = ComCountHeadTitle(HeadTitle1);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		80,		daCenter,	true,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,      	40,		daCenter,	false,		prefix + "tax_dtl_ser_no",	false,		"",		dfNone,				0,		false,		true);
					InitDataProperty(0, cnt++ , dtDummyCheck,   	40,    	daCenter,  	true,   	prefix + "DelChk");
					InitDataProperty(0, cnt++ , dtData,      	  	440,	daCenter,	true,		prefix + "itm_nm",			false,		"",		dfNone,				0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		prefix + "spl_amt",			false,		"",		dfNullFloat,		2,		true,		true);
					InitDataProperty(0, cnt++ , dtData,   	   		100,	daRight,	true,		prefix + "tax_amt",			false,		"",		dfNullFloat,		2,		false,		true);
					InitDataProperty(0, cnt++ , dtData,      	  	110,	daRight,	true,		prefix + "total_amt",		false,		"",		dfNullFloat,		2,		false,		true);
	            }
	            break;
    	}
    }

    /**
     * Sheet관련 프로세스를 처리한다.<br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction, objNm, row) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
	    		if(objNm == "csr_curr_cd") {
					form.f_cmd.value = SEARCH01;
					var param = "f_cmd=" +  form.f_cmd.value + "&curr_cd=" + form.csr_curr_cd.value;
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0076GS.do", param);
		   			var currNm = ComGetEtcData(sXml, "currCd");
	
		   			if(typeof currNm == "undefined" || currNm == "" ) {
		   				form.csr_curr_cd.value = "";
		   				ComAlertFocus(formObj.csr_curr_cd, ComGetMsg("FMS00006", "Currency"));
		   			} else {
		   				//Currency Validation 에 관계없이 증빙 유형 변경 가능하게 처리
		   				/** 
		   				    if(currNm == "KRW") {
		   					form.evid_tp_cd.value = "5";
		   					form.evid_tp_cd.disabled = true;
		   				} else {
		   					form.evid_tp_cd.disabled = false;
		   				} 
		   				
		   				*/ 
		   				if(currNm == "KRW"&&form.evid_tp_cd.value != "5") {
		   					ComBtnEnable("btn_TaxEvidence");
		   				}else{
		   					ComBtnDisable("btn_TaxEvidence");
		   				}
		   			}
	    		} else if(objNm == "slp_func_cd") {
    				CoFmsGetCombo("FORM", formObj, sheetObj, "CD02267", "slp_func_cd", "slp_func_cdText");
	    		} else if(objNm == "evid_tp_cd") {
    				CoFmsGetCombo("FORM", formObj, sheetObj, "CD01745", "evid_tp_cd", "evid_tp_cdText");
    				form.evid_tp_cd.value = "5";
    				ComBtnDisable("btn_TaxEvidence");
	    		} else if(objNm == "eff_dt") {
	    			formObj.f_cmd.value = SEARCH09;
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , ComReplaceStr(FormQueryString(form),"-",""));
		   			var effDt = ComGetEtcData(sXml, "effDt");
		   			if(typeof effDt == "undefined" || effDt == "" ) {
						formObj.eff_dt.value = "";
						ComAlertFocus(formObj.eff_dt, ComGetMsg("FMS01565"));
					} else {
						for(var i=1; i<=sheetObj.LastRow; i++) {
							sheetObj.CellValue2(i, "eff_dt") = formObj.eff_dt.value;
						}
					}
	    		} else if(objNm == "vndr_seq") {
	    			formObj.f_cmd.value = SEARCH01;
	    			var param = FormQueryString(formObj) + "&cond_flag=VM" + "&cd_cnt=&cd_seq=" + form.vndr_seq.value;
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0070GS.do", param);
					var cdName = ComGetEtcData(sXml, "cdName");
					if(typeof cdName == "undefined" || cdName == "" ) {
						form.vndr_seq.value = "";
						form.vndr_nm.value = "";
						form.vndr_seq.focus();
						ComShowCodeMessage('FMS01334');
			    	} else {
			    		form.vndr_nm.value = cdName;
			    	}
	    		}
    			break;
    			
    		case IBROWSEARCH:
	    		if (objNm == "ctr_cd") {
	   			 	formObj.f_cmd.value = SEARCH01;
	   			 	var acctCd = sheetObj.CellValue(row, "acct_cd");
	   			 	var ctrCd = sheetObj.CellValue(row, "ctr_cd");
	   			 	var sXml = sheetObj.GetSearchXml("ESM_FMS_0021GS.do", FormQueryString(formObj)+"&acct_cd="+acctCd+"&chk_ctr_cd="+ctrCd);
	   			 	var slpLocCd = ComGetEtcData(sXml, "slpLocCd");
	   			 	if(typeof slpLocCd == "undefined" || slpLocCd == "" ) {
	   			 		ComShowCodeMessage('FMS01441');
		   			 	sheetObj.CellValue2(row, "ctr_cd") = "";
	        			sheetObj.SelectCell(row, "ctr_cd");
	   			 	} else {
	   			 		sheetObj.CellValue2(row, "slp_loc_cd") = slpLocCd;
	   			 	}
	    		} else if (objNm == "acct_cd") {
	    			formObj.f_cmd.value = SEARCH01;
	    			var acctCd = sheetObj.CellValue(row, "acct_cd");
	    			var sXml = sheetObj.GetSearchXml("ESM_FMS_0069GS.do", FormQueryString(formObj)+"&acct_cd="+acctCd);
	    			var cdName = ComGetEtcData(sXml, "cdName");
	    			if(typeof cdName == "undefined" || cdName == "" ) {
	    				ComShowCodeMessage('FMS01336');
	    				sheetObj.CellValue2(row, "ctr_cd") = "";
	    				sheetObj.CellValue2(row, "slp_loc_cd") = "";
	    				sheetObj.CellValue2(row, "acct_cd") = "";
	        			sheetObj.SelectCell(row, "acct_cd");
	    			}
	    		} else if(objNm == "vndr_seq") {
	    			formObj.f_cmd.value = SEARCH01;
	    			var cd_seq = sheetObj.CellValue(row, "vndr_seq");
	    			var param = FormQueryString(formObj) + "&cond_flag=VM"+"&cd_cnt=&cd_seq="+cd_seq;
					var sXml = sheetObj.GetSearchXml("ESM_FMS_0070GS.do", param);
					var cdName = ComGetEtcData(sXml, "cdName");
					if(typeof cdName == "undefined" || cdName == "" ) {
						ComShowCodeMessage('FMS01334');
						sheetObj.CellValue2(row, "vndr_seq") = "";
	        			sheetObj.SelectCell(row, "vndr_seq");
			    	}
	    		} else if(objNm == "vvd_cd") {
	    			formObj.f_cmd.value = SEARCH06;
	    			var vvdCd = sheetObj.CellValue(row, "vvd_cd");
	    			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", FormQueryString(formObj)+"&vvd_cd="+vvdCd);
	    			if(CoFmsShowXmlMessage(sXml) != "") {
	    				ComAlertFocus(formObj.vvd_cd, CoFmsShowXmlMessage(sXml));
	    				sheetObj.CellValue2(row, "vvd_cd") = "";
	    				sheetObj.SelectCell(row, "vvd_cd");
					} 
	    		}
    			break;

    		case IBSAVE:        //저장
    			if(validateForm(sheetObj,formObj,sAction)) {    				
    				if(!saveConfirm()) return;
    				
    				formObj.f_cmd.value = MULTI;
    				if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") return;
    				if(form.evid_tp_cd.value != "5") {
	    				if(sheetObjects[2].RowCount == 0) {
							ComShowCodeMessage("FMS01458");
							return;
	    				}
    				}
    				//sheetObjects[0].CellValue2(row, "apro_step") = formObj.apro_step.value;
					
    				var param = FormQueryString(formObj) + "&" + 
								ComFmsSetPrifix(sheetObjects[0].GetSaveString(),"sheet1_") + "&" +
								sheetObjects[1].GetSaveString() + "&" +
								sheetObjects[2].GetSaveString();
					var sXml = sheetObj.GetSaveXml("ESM_FMS_0040GS.do", param);
					var csrNo = ComGetEtcData(sXml, "csrNo");
					if(csrNo == ""){
						alert(CoFmsShowXmlMessage(sXml));
					}else{
						sheetObj.LoadSaveXml(sXml);						
					}
    			}
    			break;

    		case IBINSERT:      // 입력
            	break;
    	}
	}

    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj, formObj, sAction) {
    	if (!ComFmsChkValid(formObj,"csr_desc")) {
      		return false;
       	}

     	if(sAction == IBSAVE) {
 	    	if(sheetObjects[0].RowCount == 0) {
 	  			ComShowCodeMessage("FMS00007");
 	  			return false;
 	  		}

 	    	if (!ComChkValid(formObj)) {
 	      		return false;
 	       	}

 	    	for(var i=1; i<=sheetObjects[0].LastRow; i++) {
 	    		var acctCd  = sheetObj.CellValue(i,  "acct_cd");
 	    		if(sheetObjects[0].CellValue(i, "csr_amt") == "0"&& acctCd !="111811") {
 	    			ComShowCodeMessage("FMS00020", "Slip Amount");
 	    			sheetObj.SelectCell(i, "csr_amt");
 	 	  			return false;
 	    		}

 	    		// --------------------------------------------------
				// Currency가 KRW와 JPY는 소수점을 입력못하게 체크한다.
				// --------------------------------------------------
				var currCd = form.csr_curr_cd.value;
				if(currCd == "KRW" || currCd == "JPY" || currCd == "PAB") {
					var carAmt = sheetObj.CellValue(i, "csr_amt").replace(/,/g,'');
					if(carAmt%parseInt(carAmt)) {
						ComShowCodeMessage("FMS01476");
						sheetObj.SelectCell(i, "csr_amt");
						return false;
					}
				}
				// --------------------------------------------------

	 	   		// VVD Code 체크
	 	   		if(checkVvdCd(sheetObjects[0], i)) {
	 	   			var vvdCd = sheetObjects[0].CellValue(i, "vvd_cd");
	 	   			if(vvdCd == "") {
						//2011-11-09추가
						//ACC# 421211 사용시 VVD 입력을 요구.
						var acctCdCol = sheetObj.SaveNameCol("acct_cd");
 						var acctCdValue = sheetObj.CellValue(i,acctCdCol);
						if (acctCdValue != "421211" && acctCdValue != "421221" ) {
		 	   				ComShowCodeMessage("FMS01155");
		 	   				sheetObjects[0].SelectCell(i, "vvd_cd");
		 	   				return false;
						}
	 	   			}
	 	   		}

	 	   		// Key Number 체크
	 			if(checkKeyNumber(sheetObjects[0], i)) {
	 				var toInvNo = sheetObjects[0].CellValue(i, "to_inv_no");
	 				if(toInvNo == "") {
	 					ComShowCodeMessage("FMS01456");
	 					sheetObjects[0].SelectCell(i, "to_inv_no");
	 					return false;
	 				}
	 			}
	 	   		
	 			var csrCurrCd = form.csr_curr_cd.value;
	 			var acctCd = sheetObj.CellValue(i, "acct_cd");
				if(csrCurrCd != "KRW" && acctCd == "111811") {
					ComShowCodeMessage('FMS01475');
					sheetObj.CellValue2(i, "acct_cd") = "";
        			sheetObj.SelectCell(i, "acct_cd");
        			return false;
				}
 	    	}
 	    	
 	    	var slpFuncCd = form.slp_func_cd.value;
 	    	var balance = form.balance.value.replace(/,/g,'');
 	    	if(slpFuncCd == "S") {
 	    		if(balance < 0) {
 	    			ComShowCodeMessage("FMS01466");
 	    			return false;
 	    		}
 	    	} else if(slpFuncCd == "P") {
 	    		if(balance < 0) {
 	    			ComShowCodeMessage("FMS01470");
 	    			return false;
 	    		}
 	    	} else if(slpFuncCd == "C") {
 	    		if(balance >= 0) {
 	    			ComShowCodeMessage("FMS01467");
 	    			return false;
 	    		}
 	    	}
     	}

      	return true;
    }
     
    /**
  	 * slp_iss_dt에 오늘 일자 세팅한다.<br>
  	 */
  	function setSlpIssDt() {
          var now=new Date();

          var y=now.getYear()+"";
          var M=now.getMonth()+1;
          if (M < 10) M = '0'+M;
          var d=now.getDate();
          if (d < 10) d = '0'+d;

          document.form.slp_iss_dt.value = ComGetMaskedValue(y+M+d, "ymd");
  	}
  	 
  	/**
     * 변경된 데이터가 있을 경우 다른 작업시 진행여부를 체크한다.<br>
     **/
    function initConfirm() {
    	var okYn = true;
      	if(sheetObjects[0].isDataModified) {
      		var okYn = ComShowCodeConfirm("FMS00002");
      	}
      	
      	return okYn;
    }
     
    /**
  	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
  		//Axon 이벤트 처리1. 이벤트catch
  		axon_event.addListenerForm  ('blur',      'obj_deactivate',  form); 		//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
  		axon_event.addListenerFormat('keypress'	, 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
  		axon_event.addListenerForm  ('keypress'	, 'eng_keypress', form); 			//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
  		axon_event.addListenerForm  ('change'	, 'obj_change', form); 				//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
  		axon_event.addListenerForm  ('beforeactivate', 'obj_activate', form); 		//- form 전체 컨트롤 모든 컨트롤의 OnFocus이벤트에 코드 처리
  	}

  	/**
     * HTML Control의 ondeactivate이벤트에서 Effective DT, Requset DT, Vendor Code의 Validation을 체크한다.<br>
     **/
    function obj_deactivate(){
    	if((event.srcElement.name == "eff_dt") ||
    	   (event.srcElement.name == "rqst_dt")) {
    		ComChkObjValid(event.srcElement);
    	} else if((event.srcElement.name == "vndr_seq")) {
    		ComChkObjValid(event.srcElement, true, false, false);
    	}
    }

	/**
	 * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다.<br>
	 **/
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
	 	}
	}

    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다.<br>
     **/
    function eng_keypress() {
    	if(event.srcElement.name == "csr_curr_cd") {
     		//영대문자 자동변환
     		ComKeyOnlyAlphabet('upper');
     	}
    }

    /**
     * HTML Control의 onchange이벤트에서 Effective DT, Currency, Vendor Code, Evidence Type, Requset DT의 Validation을 체크한다.<br>
     */
 	function obj_change() {
 		if((event.srcElement.name == "csr_curr_cd") && (form.csr_curr_cd.value.length == 3)) {
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH, "csr_curr_cd");
 		} else if((event.srcElement.name == "eff_dt")) {
			if (form.eff_dt.value != "" && ComIsDate(form.eff_dt.value)) {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
        	}
 		//} else if((event.srcElement.name == "vndr_seq") && (form.vndr_seq.value.length == 6)) {
 		} else if((event.srcElement.name == "vndr_seq")) {
 			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH, "vndr_seq");
 		} else if(event.srcElement.name == "evid_tp_cd") {
 			if((form.evid_tp_cd.value == "1" || form.evid_tp_cd.value == "4")&&form.csr_curr_cd.value=="KRW") {
 				ComBtnEnable("btn_TaxEvidence");
 			} else {
 				ComBtnDisable("btn_TaxEvidence");
 			}
 		} else if((event.srcElement.name == "vndr_seq") && (form.vndr_seq.value.length == 0)) {
 			form.vndr_nm.value = "";
 		} else if((event.srcElement.name == "rqst_dt")) {
 			setRqstDt();
 		} else if((event.srcElement.name == "slp_func_cd")) {
 			sheetObjects[0].RemoveAll();
 			sheetObjects[1].RemoveAll();
 			sheetObjects[2].RemoveAll();
 			form.dr.value = "0";
 			form.diff.value = "0";
 			form.balance.value = "0";
 			form.evid_tp_cd.disabled = false;
 		}
 	}

 	/**
 	 * Vendor/Customer Inquiry 팝업창에서 선택한 Vender Code와 name을 Form항목에 설정한다.<br>
 	 */
 	function setVndrSeq(aryPopupData) {
 		form.vndr_seq.value = aryPopupData[0][5];
 		form.vndr_nm.value = aryPopupData[0][3];
 	}

 	/**
	 * Eff Data의 Validation을 체크한다.<br>
	 */
	function setEffDt() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "eff_dt");
	}

	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
	 */
    function obj_activate() {
        if((event.srcElement.name == "eff_dt") ||
    	   (event.srcElement.name == "rqst_dt")) {
        	ComClearSeparator(event.srcElement);
        }
    }

    /**
  	 * Csul_Slp 정보를 설정한다.<br>
  	 */
  	function setCsulSlp(aryPopupData) {
  		var row = sheetObjects[0].DataInsert(-1);
  		sheetObjects[0].CellValue2(row, "acct_cd") = aryPopupData[0][7];
  		if(aryPopupData[0][15] == "40") {
  			sheetObjects[0].CellValue2(row, "csr_amt") = aryPopupData[0][9];
  		} else {
  			sheetObjects[0].CellValue2(row, "csr_amt") = -1*aryPopupData[0][9];
  		}
  		sheetObjects[0].CellValue2(row, "csr_desc") = aryPopupData[0][3];
  		sheetObjects[0].CellValue2(row, "vvd_cd") = aryPopupData[0][10];
  		sheetObjects[0].CellValue2(row, "flet_ctrt_no") = aryPopupData[0][11];
  		sheetObjects[0].CellValue2(row, "flet_iss_tp_cd") = aryPopupData[0][12];
  		sheetObjects[0].CellValue2(row, "inv_seq") = aryPopupData[0][13];
  		sheetObjects[0].CellValue2(row, "inv_dtl_seq") = aryPopupData[0][14];
  		setSheetInfo(row);

  		var acctCd = sheetObjects[0].CellValue(row, "acct_cd");
  		// Key Number Enable 여부체크
  		if(checkKeyNumber(sheetObjects[0], row)) {
  			sheetObjects[0].CellEditable(row, "to_inv_no") = true;
		} else {
			sheetObjects[0].CellEditable(row, "to_inv_no") = false;
		}

  		sheetObjects[0].CellEditable(row, "acct_cd") = false;
  		sheetObjects[0].CellEditable(row, "vndr_seq") = false;
  		sheetObjects[0].CellEditable(row, "csr_desc") = false;

  		inputReadOnly(2);
  		setDrDiff();
  		
  		sheetObjects[0].CellFont("FontName", row, "vvd_cd") = "Courier New";
  		sheetObjects[0].CellFont("FontName", row, "slp_loc_cd") = "Courier New";
  	}

  	/**
  	 * 입력받은 Effective DT, Request DT를 Sheet에 설정한다.<br>
  	 */
    function setSheetInfo(row) {
    	sheetObjects[0].CellValue2(row, "eff_dt") = form.eff_dt.value;
    	sheetObjects[0].CellValue2(row, "vndr_seq") = form.vndr_seq.value;
    }
    
    /**
     * sheet1의 OnChange이벤트 발생시 Acct Code, Vendor Code, Center Code, VVD Code의 Validation을 체크한다.<br>
     */
    function sheet1_OnChange(sheetObj, row, col, value) {
    	
		if(col == 3) {
			if(sheetObj.CellValue(row, "acct_cd").length > 0) {
				var acctCd = sheetObj.CellValue(row, "acct_cd");
				
				// 510991 : USE Only JOO Module.  FMS 510993
				if(acctCd == "510991") {
					ComShowConfirm("Account Code 510991 is not available");
		    		sheetObj.CellValue2(row,col) = "";
					sheetObj.SelectCell(row,col);
					return;
				}
				
//				if(acctCd == "951111") {
//					sheetObj.CellEditable(row, "vvd_cd") = false;
//				}
				// 계정 항차 레벨 검사(Account 별 VVD Level Check)
				// 해당 계정에 대한 항차 입력 여부 판단
				if(checkAcctCdVvdLevelMdt(sheetObj, row)) {
					sheetObj.CellEditable(row, "vvd_cd") = false;
					sheetObj.CellValue2(row, "vvd_cd") = "";
				} else {
					if(checkAcctCdVvdLevel(sheetObj, row)) {
						sheetObj.CellEditable(row, "vvd_cd") = true;
						sheetObj.CellValue2(row, "vvd_cd") = "";
					} else {
						sheetObj.CellEditable(row, "vvd_cd") = false;
						sheetObj.CellValue2(row, "vvd_cd") = "";
					}
				}

				// Key Number Enable 여부체크
				if(checkKeyNumber(sheetObj, row)) {
					sheetObj.CellEditable(row, "to_inv_no") = true;
				} else {
					sheetObj.CellEditable(row, "to_inv_no") = false;
				}
				
				var csrCurrCd = form.csr_curr_cd.value;
				if(csrCurrCd != "KRW" && acctCd == "111811") {
					ComShowCodeMessage('FMS01475');
					sheetObj.CellValue2(row, "acct_cd") = "";
        			sheetObj.SelectCell(row, "acct_cd");
        			return;
				}

				// Slip Type에 따라 Acct Code 체크
				if(checkSlpFuncCd(sheetObj, row)) {
					doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "acct_cd", row);
				} else {
					return;
				}
			}
		} else if(col == 4) {
			if(sheetObj.CellValue(row, "vndr_seq").length > 0) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "vndr_seq", row);
			}
		} else if(col == 5) {
			if(sheetObj.CellValue(row, "ctr_cd").length > 0) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ctr_cd", row);
			}
    	} else if(col == 10) {
			if(sheetObj.CellValue(row, "vvd_cd").length > 0) {
				doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "vvd_cd", row);
			}
    	} else if(col == 8) {
    		if(value != "") {
    			setDrDiff();
    		}                    
    	}
		
    }
    
    
    
    /**
     * IBSheet Object에서 입력값이 변경된 경우
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value){
    	//var currCd = comboObjects[0].Code;
    	var currCd = form.csr_curr_cd.value;
    	var colName = sheetObj.ColSaveName(Col);
    	
    	if(colName == "tax_total_amt"){								
    		if(currCd == "KRW"){			
    			if(sheetObj.CellValue(1, "tax_tax_pl_cd") == '1'){				// tax_tax_pl_cd 1:영세, 2:과세			
    				fnTax1();		// 영세, KRW
    			}else{	
    				fnTax3();		// 과세, KRW	
    				setDrDiff();
    			}			
    		}		
    	}	
    }

    /**
     * 영세, KRW
     */
    function fnTax1(){ 	
    	var sheetObj = sheetObjects[0];	
    	var lastRow = sheetObj.LastRow;
    	var hiddenRow = 0;		
    	
    	for ( var i = 1; i <= lastRow; i++) {		
    		if(sheetObj.CellValue(i,  "acct_cd") == "111811" ){
    			hiddenRow = i;			
    			sheetObj.CellValue2(i,  "ibflag") = "D";
    		}
    	}	
    	if(hiddenRow > 1){
    		sheetObj.RowHidden(hiddenRow) = true;
    	}		
    		
    	var row = sheetObj.DataInsert(-1);
    		
    	sheetObj.CellValue2(row,  "acct_cd") = "111811";
    	sheetObj.CellValue2(row,  "csr_amt") = 0;
    	sheetObj.CellValue2(row,  "csr_desc") = form.csr_desc.value+" 매입 0% 일반";
    	sheetObj.CellValue2(row,  "slp_seq_no") = "4000";	
    	sheetObj.CellValue2(row,  "vndr_seq") = sheetObj.CellValue(lastRow,  "vndr_seq");	
    	sheetObj.CellValue2(row,  "ctr_cd") = sheetObj.CellValue(lastRow,  "ctr_cd");			
    	sheetObj.CellValue2(row,  "slp_loc_cd") = sheetObj.CellValue(lastRow,  "slp_loc_cd");			
    	sheetObj.CellValue2(row,  "eff_dt") = sheetObj.CellValue(lastRow,  "eff_dt");			
    }

    /**
     * 과세, KRW
     */
    function fnTax3(){
    	var sheetObj = sheetObjects[0];	
    	var lastRow = sheetObj.LastRow;
    	var vndrSeq = sheetObj.CellValue(lastRow,  "vndr_seq");	
    	var hiddenRow = 0;		
    	
    	for ( var i = 1; i <= lastRow; i++) {		
    		if(sheetObj.CellValue(i,  "acct_cd") == "111811" ){
    			hiddenRow = i;
    			sheetObj.CellValue2(i,  "ibflag") = "D"; 
    		}
    	}	
    	if(hiddenRow > 1){
    		sheetObj.RowHidden(hiddenRow) = true;
    	}		
    		
    	var row = sheetObj.DataInsert(-1);		
    	var tempAmt = 0;
    	
    	for ( var i = 1; i <= lastRow; i++) {						
    		if(sheetObj.CellValue(i,  "acct_cd") != "111811" ){						
    			tempAmt = tempAmt + Number(sheetObj.CellValue(i,  "csr_amt"));
    		}
    	}			
    	sheetObj.CellValue2(row,  "acct_cd") = "111811";
    	sheetObj.CellValue2(row,  "csr_amt") = tempAmt*0.1;
    	sheetObj.CellValue2(row,  "csr_desc") = form.csr_desc.value+" 매입 10% 일반";		
    	sheetObj.CellValue2(row,  "slp_seq_no") = "4000";	
    	sheetObj.CellValue2(row,  "vndr_seq") = sheetObj.CellValue(lastRow,  "vndr_seq");	
    	sheetObj.CellValue2(row,  "ctr_cd") = sheetObj.CellValue(lastRow,  "ctr_cd");
    	sheetObj.CellValue2(row,  "slp_loc_cd") = sheetObj.CellValue(lastRow,  "slp_loc_cd");	
    	sheetObj.CellValue2(row,  "eff_dt") = sheetObj.CellValue(lastRow,  "eff_dt");
    }


    /**
     * 대변/차변 값을 설정한다.<br>
     * @param value
     * @return
     */
    function setDrDiff() {
    	var csrAmt = 0;
    	var dr = 0;
    	var diff = 0;
    	for(var i=1; i<=sheetObjects[0].LastRow; i++) {
    		csrAmt = sheetObjects[0].CellValue(i, "csr_amt");
			if(csrAmt > 0) {
				dr = dr*1 + csrAmt*1;
			} else {
				diff = diff*1 + csrAmt*1;
			}
    	}

    	balance = (dr*1 + diff*1).toFixed(2);
		form.dr.value = ComAddComma(dr.toFixed(2));
		form.diff.value = ComAddComma(diff.toFixed(2));
		form.balance.value = ComAddComma(balance);
		form.csr_amt.value = balance;
		form.rqst_amt.value = balance;
    }

    /**
     * 채권번호를 설정한다.<br>
     * @param ErrMsg
     * @return
     */
    function sheet1_OnSaveEnd(ErrMsg) {
    	var sheetObj = sheetObjects[0];
    	
    	if(sheetObj.RowCount > 0) {    		
	    		inputReadOnly("1");
	    		form.csr_no.value = sheetObj.CellValue(1, "csr_no");
	
	  	    	for(var i=1; i<=sheetObj.LastRow; i++) {
	  	    		sheetObj.CellEditable(i, "DelChk") = false;
	  	    		sheetObj.CellEditable(i, "acct_cd") = false;
	  	    		sheetObj.CellEditable(i, "vndr_seq") = false;
	  	    		sheetObj.CellEditable(i, "ctr_cd") = false;
	  	    		sheetObj.CellEditable(i, "slp_loc_cd") = false;
	  	    		sheetObj.CellEditable(i, "eff_dt") = false;
	  	    		sheetObj.CellEditable(i, "csr_amt") = false;
	  	    		sheetObj.CellEditable(i, "csr_desc") = false;
	  	    		sheetObj.CellEditable(i, "vvd_cd") = false;
	  	    		sheetObj.CellEditable(i, "to_inv_no") = false;
	  	    	}    			
  	    }
    }

    /**
     * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
     **/
    function inputReadOnly(flag) {
    	if(flag == "0") {
    		form.csr_desc.readOnly = false;
    		form.slp_func_cd.disabled = false;
    		form.evid_tp_cd.disabled = false;
    		form.rqst_dt.readOnly = false;
    		form.eff_dt.readOnly = false;
    		form.vndr_seq.readOnly = false;
    		form.csr_curr_cd.readOnly = false;
    		form.btn_rqstDt.style.cursor = "hand";
    		document.images["btn_rqstDt"].name = "btn_rqstDt";
    		form.btn_effDt.style.cursor = "hand";
    		document.images["btn_effDt"].name = "btn_effDt";
    		form.btn_vndrSeq.style.cursor = "hand";
    		document.images["btn_vndrSeq"].name = "btn_vndrSeq";
    		ComBtnEnable("btn_Brokerage");
    		ComBtnEnable("btn_RowAdd");
    		ComBtnEnable("btn_RowDel");
    		ComBtnEnable("btn_Save");
    		ComBtnEnable("btn_TaxEvidence");
    		form.evid_tp_cd.value = "5";
    		if(form.evid_tp_cd.value == "5") {
    			ComBtnDisable("btn_TaxEvidence");
    		}
    	} else if(flag == "1") {
    		form.csr_desc.readOnly = true;
    		form.slp_func_cd.disabled = true;
    		form.evid_tp_cd.disabled = true;
    		form.rqst_dt.readOnly = true;
    		form.eff_dt.readOnly = true;
    		form.vndr_seq.readOnly = true;
    		form.csr_curr_cd.readOnly = true;
    		form.btn_rqstDt.style.cursor = "default";
    		document.images["btn_rqstDt"].name = "no_btn_rqstDt";
    		form.btn_effDt.style.cursor = "default";
    		document.images["btn_effDt"].name = "no_btn_effDt";
    		form.btn_vndrSeq.style.cursor = "default";
    		document.images["btn_vndrSeq"].name = "no_btn_vndrSeq";
    		ComBtnDisable("btn_Brokerage");
    		ComBtnDisable("btn_RowAdd");
    		ComBtnDisable("btn_RowDel");
    		ComBtnDisable("btn_Save");
    		ComBtnDisable("btn_TaxEvidence");
    	} else if(flag == "2") {
    		form.csr_curr_cd.readOnly = true;
    		form.vndr_seq.readOnly = true;
    		form.btn_vndrSeq.style.cursor = "default";
    		document.images["btn_vndrSeq"].name = "no_btn_vndrSeq";
    	} else if(flag == "3") {
    		form.evid_tp_cd.disabled = true;
    	}
    }

    /**
   	 * 페이지에 있는 RD Object를 로드한다. <br>
   	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다.<br>
   	 * @param {rdObject} rdObject    RD Object
   	 **/
   	function initRdConfig(rdObject){
   	    var Rdviewer = rdObject ;
   	    Rdviewer.style.height = 0;
   	    Rdviewer.style.width = 0;
   	    
   	    Rdviewer.AutoAdjust = true;
   	    Rdviewer.ViewShowMode(0);

   		Rdviewer.setbackgroundcolor(128,128,128);
   		Rdviewer.SetPageLineColor(128,128,128);
   	}
   	 
   	/**
   	 * 전표를 출력한다.<br>
   	 */
   	function rdOpen(rdObject, formObject){
  		if(sheetObjects[0].RowCount == 0) {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}

  		if(form.csr_no.value == "") {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}

 		var Rdviewer = rdObject ;
 	
 		rdParam = RD_FormQueryString(formObject,1);
 		var rdParam = '/rv '+ rdParam;
 		var rdFile = 'ESM_FMS_031.mrd';

 		// 열고자 하는 RD 파일을 지정한다.
 	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/'+rdFile, RDServer+rdParam);
 		Rdviewer.CMPrint (); //인쇄 시작
 	}
   	
   	function rdOpenPreview(rdObject, formObject){
  		if(sheetObjects[0].RowCount == 0) {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}

  		if(form.csr_no.value == "") {
  			ComShowCodeMessage("FMS00015");
  			return;
  		}
 	
 		rdParam = RD_FormQueryString(formObject,1);
 		var rdParam = '/rv '+ rdParam;
 		var strPath = 'apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_031.mrd';
 		
 		formObject.com_mrdPath.value = strPath;
 		formObject.com_mrdArguments.value = rdParam;
        ComOpenRDPopupModal('resizable=yes;dialogWidth:750px;dialogHeight:690px');    
 	}
   	
   	/**
   	 * Requset DT가 CSR Data보다 작은지를 체크한다.<br>
   	 */
   	function setRqstDt() {
   		var csrDt = form.slp_iss_dt.value.replace(/-/g,'');
   		var rqstDt = form.rqst_dt.value.replace(/-/g,'');
   		
   		if(parseInt(csrDt) > parseInt(rqstDt)) {
   			form.rqst_dt.value = "";
   			ComAlertFocus(form.rqst_dt, ComGetMsg('FMS01438'));
   		}
   	}
   	
    /**
     * Account Code 에 따라 Key Number 를 입력해야하는지 판단여부를 체크한다.<br>
     **/
    function checkKeyNumber(sheetObj, row) {
    	var acctCd = sheetObj.CellValue(row, "acct_cd");
    	if(   acctCd == "167111"
    	   || acctCd == "16712"
    	   || acctCd == "167191"
    	   || (parseInt(acctCd) > 511300 && parseInt(acctCd) < 511499 && acctCd != "511351")
    	   || (parseInt(acctCd) > 133810 && parseInt(acctCd) < 133891)) {
    		return true;
    	}
    	
    	return false;
 	}

    /**
     * Account Code 에 따라 VVD_CD 를 입력해야하는지 판단여부를 체크한다.<br>
     **/
    function checkVvdCd(sheetObj, row) {
    	var acctCd = sheetObj.CellValue(row, "acct_cd");
    	
    	if(acctCd == "580111") {
    		sheetObj.CellValue2(row, "vvd_cd") = "";
    		return false;
    	} else if(acctCd.substring(0,1) == "4"
	   	   || acctCd.substring(0,1) == "6"
	   	   || acctCd.substring(0,1) == "7"
	   	   || acctCd.substring(0,2) == "51"
	   	   || acctCd == "956115"
	   	   || acctCd == "962111"
	   	   || acctCd == "111071") {
    		return true;
    	}

    	return false;
    }

    /**
     * Slip Type 에 따라 Acct Code를 체크한다.<br>
     **/
    function checkSlpFuncCd(sheetObj, row) {
    	var acctCd = sheetObj.CellValue(row, "acct_cd");
    	var slpFuncCd = form.slp_func_cd.value;
    	if(slpFuncCd == "S") {
    		if(acctCd.substring(0,6) == "111431") {
   				ComShowCodeMessage("FMS01464");
   				sheetObj.CellValue2(row, "acct_cd") = "";
   				sheetObj.SelectCell(row, "acct_cd");
   				return false;
    		}
    	} else if(slpFuncCd == "P") {
    		if(acctCd.substring(0,6) == "111431") {
    			var tmpCnt=0;
    			for(i=sheetObj.HeaderRows;i<sheetObj.RowCount;i++) {
    				if(sheetObj.CellValue(i,"acct_cd")=="111431") {
    					tmpCnt++;
    				}
    			}
    			if(tmpCnt > 0) {
    				ComShowCodeMessage("FMS01464");
    				sheetObj.CellValue2(row, "acct_cd") = "";
    				sheetObj.SelectCell(row, "acct_cd");
    				return false;
    			}
    		}	
    		if(acctCd == "111071") {
    			ComShowCodeMessage("FMS01462");
    			sheetObj.CellValue2(row, "acct_cd") = "";
    			sheetObj.SelectCell(row, "acct_cd");
    			return false;
    		}


    	} else if(slpFuncCd == "C") {
    		if(acctCd.substring(0,6) == "111431") {
   				ComShowCodeMessage("FMS01464");
   				sheetObj.CellValue2(row, "acct_cd") = "";
   				sheetObj.SelectCell(row, "acct_cd");
   				return false;
    		}
    	}
    	
    	return true;
    }

    /**
     * Save 여부 메세지를 보여준다.<br>
     **/
  	function saveConfirm() {
  		var okYn = ComShowConfirm(ComGetMsg("FMS00017"));
  		return okYn;
  	}

    /**
     * Account 별 VVD Level Check(해당 계정에 대한 항차 필수입력 여부 체크)
     * 계정 항차 레벨을 체크하여 해당 계정에 대해 항차를 입력해야하는지를 판단 <br>
     * @param {ibsheet}	 sheetObj    IBSheet Object
     * @param {ibsheet}  row     	 sheetObj의 선택된 Row
     * @return {boolean} true : 필수입력, false : pass
     **/
    function checkAcctCdVvdLevelMdt(sheetObj, row) {
     	//Account 별 VVD Level Check
     	var acctCdCol = sheetObj.SaveNameCol("acct_cd");
 		var acctCdValue = sheetObj.CellValue(row,acctCdCol);
 		
 		if(	  acctCdValue.substring(0,4) == "4212"
 		   || acctCdValue.substring(0,4) == "5801"
 		   || acctCdValue == "612900"
 	       || acctCdValue == "712900") {
 			
 			return true;
 		} else {
 			return false;
 		}
    }
     
    /**
     * Account 별 VVD Level Check
     * 계정 항차 레벨을 체크하여 해당 계정에 대해 항차를 입력해야하는지를 판단 <br>
     * @param {ibsheet}	 sheetObj    IBSheet Object
     * @param {ibsheet}  row     	 sheetObj의 선택된 Row
     * @return {boolean} true : 항차 레벨 검사, false : pass
     **/
    function checkAcctCdVvdLevel(sheetObj, row) {
    	//Account 별 VVD Level Check
     	var acctCdCol = sheetObj.SaveNameCol("acct_cd");
 		var acctCdValue = sheetObj.CellValue(row,acctCdCol);
 		
 		if((   acctCdValue.substring(0,1) == "4"
 		    || acctCdValue.substring(0,1) == "6"
 		    || acctCdValue.substring(0,1) == "7"
 		    || acctCdValue.substring(0,2) == "51"
 		    || acctCdValue == "956115"
 		    || acctCdValue == "962111"
 		    || acctCdValue == "111071") && !(   acctCdValue.substring(0,4) == "4212"
 				    						 || acctCdValue.substring(0,4) == "5801"
 				    						 || acctCdValue == "612900"
 				    					     || acctCdValue == "712900")) {
 			
 			return true;
 		} else {
 			return false;
 		}
    }
    

    
    function setMakeTaxEvidence(taxAmt) {
    }
    
    /**
     * Evidence Type 변경시 Tax Evidence버튼을 컨트롤한다 <br>
     **/
    function setButton(val) {
    /*	
    	100010	CD01745	1	TAX
    	100020	CD01745	4	CI
    	100030	CD01745	5	ETC
    */	  	
    	form.evid_tp_cd_val.value = val;
    	
    	if(val == 5) {
        	//Payments Slip TaxEvidence Button Disable 하기
    		ComBtnDisable("btn_taxEvidence");		
    	} else {	
    		//Payments Slip TaxEvidence Button Enable 하기
    		ComBtnEnable("btn_taxEvidence");
    	}
    }
    
    /* 개발자 작업  끝 */