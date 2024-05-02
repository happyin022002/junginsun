/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_1022.js
*@FileTitle : Dangerous CGO Application Details for Partner Lines
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.26 김현욱
* 1.0 Creation
* =========================================================
*History
* 2013.05.08 김현화 [CHM-201324585]DG Packing Instruction 기능 적용. 
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
     * @class vop_scg_1022 : vop_scg_1022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_1022() {
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

    
//------------------------------------------------------------------------------//
/* 공통 변수 */    
//------------------------------------------------------------------------------//
    
    // 공통전역변수
    var comboObjects  = new Array();
	var comboCnt      = 0;
	
    var sheetObjects  = new Array();
    var sheetCnt      = 0;
    
    var uploadObjects = new Array();
	var uploadCnt     = 0;
	
	var orgSheetObj   = null;
	var orgFormObj    = null;
	var closeYn       = false;
	var newYn         = false;
	var arrData		  = null;

//------------------------------------------------------------------------------//
/* 공통 변수 -- 초기화 프로세스 */    
//------------------------------------------------------------------------------//
    
    // 이벤트 Catch Listener
    function initControl() {
         // Axon 이벤트 처리1. 이벤트catch(개발자변경)
         axon_event.addListenerFormat ('keypress', 'obj_keypress',   form);
         axon_event.addListenerFormat ('focus',    'obj_focus',      form);
         axon_event.addListenerFormat ('blur',     'obj_focusout',   form);
         axon_event.addListenerForm   ('keyup',    'obj_keyup',      form);
         axon_event.addListenerForm   ('change',   'obj_change', 	 form);
         axon_event.addListener       ('keydown',  'obj_keydown',   'form');
    }
    
    // 팝업창 고정
//    window.onblur = function() {
//        self.focus();
//    }
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     */
    function setComboObject(combo_obj) {
         comboObjects[comboCnt++] = combo_obj;
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }
     
    /**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
 	function setUploadObject(uploadObj) {
 		uploadObjects[uploadCnt++] = uploadObj;
 	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }		
        
        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++) {
        	if(comboObjects[k].id != 'mrn_polut_flg' && comboObjects[k].id != 'imdg_lmt_qty_flg' && comboObjects[k].id != 'imdg_expt_qty_flg') {
       	 		initCombo(comboObjects[k], k + 1);
        	}
        }
        
        //Upload Sheet 기본 설정 및 초기화
    	initUpload();
        
        initControl();
        
        //조회성 기능을 구분
        if(preConds.pop_mode == 'view') {
        	btnEnabled("view", false);
        }
        
        initCombo(comboObjects[3], comboObjects[3].no);
		initCombo(comboObjects[5], comboObjects[5].no);
		initCombo(comboObjects[6], comboObjects[6].no);
        
        //Combo 초기화
	 	searchTPSZList(sheetObjects[0]);

		//초기셋팅
	 	setPreCondition(sheetObjects[1]);
	 	
	 	//조회
	 	if(preConds.spcl_cgo_rqst_seq != '') {
	 		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	 	} else {
	 		var openerXml = window.dialogArguments.getAppDetlObj();
	 		if(openerXml != null) {
		 		sheetObjects[1].LoadSearchXml(openerXml, true);
	 		} else {
	 			resetUI(sheetObjects[1], document.form, "init");
	 		}
	 	}
        
        window.name = "partnerDG";
    }
     
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
     	switch(comboObj.id) {
     		case "pol_cd":  
	  			with(comboObj) {
	  				Enable = true;
	  				MultiSelect = false;
	  				BackColor = "#CCFFFD";
	  				SetColWidth("83|19");
	  			}
	  			break;  
     		case "pod_cd":  
	  			with(comboObj) {
	  				Enable = true;
	  				MultiSelect = false;
	  				BackColor = "#CCFFFD";
	  				SetColWidth("83|19");
	  			}
	  			break;  
 	  		case "spcl_cgo_seq":  
 	  			with(comboObj) {
 	  				Enable = true;
 	  				MultiSelect = false;
 	  				BackColor = "#CCFFFD";
 	  				LineColor = "#FFFFFF"; 
 	  				SetColAlign("right|center|right");
	  				SetColWidth("50|20|");
 	  				ShowCol = 2;
 	  				Index = "";
 	  			}
 	  			break;  
 	  		case "imdg_lmt_qty_flg":  	  			
 	  			with(comboObj) {
 	  				InsertItem(0, "Y", "Y"); 
 	 	  			InsertItem(1, "N", "N"); 
 	 	  			
 	  				Enable = true;
 	  				MultiSelect = false;
 	  				BackColor = "#CCFFFD";
 	  				Code2 = "N";
 	  			} 	  			
 	  			break; 
 	  		case "imdg_expt_qty_flg":  	  			
 	  			with(comboObj) {
 	  				InsertItem(0, "Y", "Y"); 
 	 	  			InsertItem(1, "N", "N"); 
 	 	  			
 	  				Enable = true;
 	  				MultiSelect = false;
 	  				BackColor = "#CCFFFD";
 	  				Code2 = "N";
 	  			} 	  			
 	  			break; 
 	  		case "dcgo_sts_cd":   	  			 
 	  			with(comboObj) {
 	  				SetColWidth(62);
 	  				DropHeight = 19*6;
 	  				
 	  				InsertItem(0, "",       ""); 
 	 	  			InsertItem(1, "GAS", 	"G"); 
 	 	  			InsertItem(2, "PASTE",  "P"); 
 	 	  			InsertItem(3, "LIQUID", "L"); 
 	 	  			InsertItem(4, "SOLID",  "S");
 	 	  			
 	  				Enable = true;
 	  				MultiSelect = false; 	  				
 	  				Index = "";
 	  			} 	  			
 	  			break; 
 	  		case "mrn_polut_flg":   	  			
 	  			with(comboObj) {
 	  				InsertItem(0, "Y", "Y"); 
 	 	  			InsertItem(1, "N", "N"); 
 	 	  			
 	  				Enable = true;
 	  				MultiSelect = false;
 	  				Code2 = "N";
 	  			} 	  			
 	  			break;  	  		
 	  	}
    }
     
    /**
     * Upload Sheet 기본 설정 및 초기화
     */
    function initUpload() {          
         //UPLOAD 환경 설정
         for(var i=0;i<uploadObjects.length;i++){
 		    //1. 기본 환경 설정
 		    ComConfigUpload(uploadObjects[i], "/hanjin/VOP_SCG_1022GS.do");
 		}
    }

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            
			case "sheet1":      //sheet1 init
                with (sheetObj) {

                    //높이 설정
                    //style.height = 200;
                    //전체 너비 설정
                    //SheetWidth = mainTable.clientWidth;
                    SheetWidth = 190;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

					var HeadTitle1 = "|Seq.|Container No.|TP/SZ";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN,		COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus, 0,      daCenter,   false,   	"ibflag");  
                    InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,		"spcl_cntr_seq",		false,		"",				dfNone,		0,			false,		false, -1, false, false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cntr_ref_no",			false,      "",				dfNone,		0,			true,		true,  13, false, false);
					InitDataProperty(0, cnt++ , dtComboEdit,	40,		daCenter,	true,		"cntr_tpsz_cd",			true,       "",				dfNone,		0,			true,		true,  2);
					
					InitDataValid(0, "cntr_ref_no", vtEngUpOther, "1234567890-");
					
					MultiSelection = false;
					CountPosition  = 0;
                                                                                 
				}
                break;
			case "sheet2":      //sheet2 init
            	with (sheetObj) {

					//높이 설정
	                style.height = 0;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 4, 100);
	
	                //해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false)

	                var HeadTitle1 = "|CntrSeq|CgoSeq|Container No.|TPSZ" +
	                                 "|out_n1st_imdg_pck_qty|out_n1st_imdg_pck_cd|out_n1st_imdg_pck_desc|out_n2nd_imdg_pck_qty|out_n2nd_imdg_pck_cd|out_n2nd_imdg_pck_desc" +
	                                 "|in_n1st_imdg_pck_qty|in_n1st_imdg_pck_cd|in_n1st_imdg_pck_desc|in_n2nd_imdg_pck_qty|in_n2nd_imdg_pck_cd|in_n2nd_imdg_pck_desc" +
	                                 "|intmd_n1st_imdg_pck_qty|intmd_n1st_imdg_pck_cd|intmd_n1st_imdg_pck_desc|intmd_n2nd_imdg_pck_qty|intmd_n2nd_imdg_pck_cd|intmd_n2nd_imdg_pck_desc" +
	                                 "|max_in_pck_qty|max_in_pck_tp_cd|hcdg_pck_rstr_desc|hcdg_intmd_bc_rstr_desc|hcdg_tnk_rstr_desc|imdg_lmt_qty|imdg_lmt_qty_meas_ut_cd|imdg_expt_qty_cd|imdg_spcl_provi_no" +
	                                 "|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|grs_capa_qty" +
	                                 "|prp_shp_nm|hzd_desc|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|hcdg_flg|imdg_subs_rsk_lbl_rmk" +
			                		 "|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_expt_qty_flg" +
			                		 "|emer_cntc_phn_no|emer_cntc_pson_nm|imdg_segr_grp_no" +
			                		 "|ems_no|ctrl_temp_ctnt|emer_rspn_gid_no|emer_rspn_gid_chr_no|emer_temp_ctnt" +
			                		 "|diff_rmk|auth_dt|auth_sts_cd|org_auth_sts_cd|apro_ref_no|cgo_rqst_dt";

	                var headCount = ComCountHeadTitle(HeadTitle1);
	                
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);

	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++,  dtStatus,  				20,     daCenter,    	false,   	"ibflag");  
	                InitDataProperty(0, cnt++ , dtData,					30,		daCenter,		false,		"spcl_cntr_seq");
	                InitDataProperty(0, cnt++ , dtData,					30,		daCenter,		false,		"spcl_cgo_seq");
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,		"cntr_ref_no",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"cntr_tpsz_cd",				false,			"",      dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"out_n1st_imdg_pck_qty",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"out_n1st_imdg_pck_cd",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"out_n1st_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"out_n2nd_imdg_pck_qty",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"out_n2nd_imdg_pck_cd",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"out_n2nd_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"in_n1st_imdg_pck_qty",	    false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"in_n1st_imdg_pck_cd",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"in_n1st_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"in_n2nd_imdg_pck_qty",	    false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"in_n2nd_imdg_pck_cd",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"in_n2nd_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"intmd_n1st_imdg_pck_qty",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"intmd_n1st_imdg_pck_cd",   false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"intmd_n1st_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"intmd_n2nd_imdg_pck_qty",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"intmd_n2nd_imdg_pck_cd",   false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"intmd_n2nd_imdg_pck_desc",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"max_in_pck_qty",	        false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"max_in_pck_tp_cd",		    false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"hcdg_pck_rstr_desc",	    false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"hcdg_intmd_bc_rstr_desc",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"hcdg_tnk_rstr_desc",	    false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"imdg_lmt_qty",	            false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"imdg_lmt_qty_meas_ut_cd",	false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"imdg_expt_qty_cd",	        false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					20,		daCenter,		false,		"imdg_spcl_provi_no",	    false,			"",      dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"imdg_clss_cd",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"imdg_comp_grp_cd",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"imdg_un_no",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"imdg_un_no_seq",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,		"grs_wgt",					false,			"",      dfNullFloat,		3,		true,		true, 18);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"wgt_ut_cd",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,		"net_wgt",					false,			"",      dfNullFloat,		3,		true,		true, 18);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,		"grs_capa_qty",				false,			"",      dfNullFloat,		3,		true,		true, 18);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"prp_shp_nm",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"hzd_desc",					false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"flsh_pnt_cdo_temp",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"imdg_pck_grp_cd",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"psa_no",					false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"imdg_lmt_qty_flg",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"hcdg_flg",				    false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"imdg_subs_rsk_lbl_rmk",	false,			"",      dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"n1st_imdg_subs_rsk_lbl_cd",false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"n2nd_imdg_subs_rsk_lbl_cd",false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"n3rd_imdg_subs_rsk_lbl_cd",false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"n4th_imdg_subs_rsk_lbl_cd",false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"dcgo_sts_cd",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"mrn_polut_flg",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"imdg_expt_qty_flg",		false,			"",      dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"emer_cntc_phn_no",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"emer_cntc_pson_nm",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daLeft,		    true,		"imdg_segr_grp_no",			false,			"",      dfNone,			0,		true,		true, 100);  
					
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"ems_no",					false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"ctrl_temp_ctnt",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"emer_rspn_gid_no",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"emer_rspn_gid_chr_no",		false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"emer_temp_ctnt",			false,			"",      dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"diff_rmk",					false,			"",      dfNone,			0,		true,		true);
					
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"auth_dt",					false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"auth_sts_cd",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"org_auth_sts_cd",			false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"apro_ref_no",				false,			"",      dfNone,			0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		true,		"cgo_rqst_dt",				false,			"",      dfNone,			0,		true,		true);
				
					CountPosition = 0;					
					
            	}
            	break;
			case "sheet3":      // sheet3 init
	            with (sheetObj) {
	                //높이 설정
	                style.height = 0;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 6, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(12, 0, 0, true);
	
	                var HeadTitle = "|Seq.||File Name||ID|Date|||||";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,	        30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	false,	"No");
					InitDataProperty(0, cnt++ , dtHidden,       0,      daCenter,   false,  "file_set_yn",	false,  "",     dfNone,         0,     		true,    	true);
					InitDataProperty(0, cnt++ , dtData,			245,	daCenter,	false,	"file_nm",		false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtHidden,		0,	    daCenter,	false,	"file_sav_id",	false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"cre_usr_id",	false,	"",		dfNone,			0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"cre_dt",		false,	"",		dfDateYmd,		0,			true,		true);
	
					InitDataProperty(0, cnt++ , dtHidden,	    30,		daCenter,	false,	"spcl_cgo_irr_file_seq");	
					InitDataProperty(0, cnt++ , dtHidden,	    30,		daCenter,	false,	"crr_cd");
					InitDataProperty(0, cnt++ , dtHidden,	    30,		daCenter,	false,	"bkg_ref_no");
					InitDataProperty(0, cnt++ , dtHidden,	    30,		daCenter,	false,	"spcl_cgo_rqst_seq");
					InitDataProperty(0, cnt++ , dtHidden,	    30,		daCenter,	false,	"spcl_cgo_rqst_atch_file_seq");
			   }
			   break;
        }
    } 
     
    /**
     * 화면 초기화 - Cargo
     * param : startObj ==> 시작오브젝트, endObj ==> 종료오브젝트, type ==> 1(폼오브젝트만), 2(IB Combo 오브젝트만), 3(모두)
     */
    function clearObjAll(startObj, endObj, type) {

         try {
        	 var elems   = document.form.elements;
        	 var startYn = false;
        	 for(var i = 0; i < elems.length; i++) {
                 var elem = elems[i];
                 
                 if(startObj == null || startObj.name == elem.name) startYn = true;
                 
                 if(startYn) {
	                 if ((elem.tagName == 'INPUT' || elem.tagName == 'SELECT' || elem.tagName == 'TEXTAREA') && (type == 1 || type == 3)) {
	                	 if(elem.name != '') {
	                		 if(elem.tagName == 'SELECT') {
	                			 elem.selectedIndex = 0;
	                		 } else if(elem.tagName == 'TEXTAREA') {
	                			 elem.value = "";
	                		 } else {
	                			 ComClearObject(elem);
	                		 }
	                	 }
	                 } else if (elem.tagName == 'OBJECT' && (type == 2 || type == 3)) {
	                	 var sObjId = elem.classid;
	                	 switch(sObjId){
		                     case CLSID_IBMCOMBO: //IBMultiCombo 경우만
		                     	elem.Code2 = "-1";
		                        break;
		                 }
	                 }
                 }
                 
                 if(endObj != null && endObj.name == elem.name) break;
        	 }
         } catch(err) { ComFuncErrMsg(err.message); }
         
         return;
    }
     
    /**
     * 화면 초기화 - All
     * param : sheetObj ==> 시트오브젝트, formObj ==> 폼오브젝트, what ==> 무엇을
     */
    function resetUI(sheetObj, formObj, what) {
    	var rgn_shp_opr_cd = ComGetObjValue(formObj.rgn_shp_opr_cd);
		
    	sheetObj.LoadSearchXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");
    	
    	btnEnabled("init", false);
		
		if(what == 'new') {
	    	ComResetAll();
			comboObjects[0].RemoveAll();
			comboObjects[1].RemoveAll();
			comboObjects[2].RemoveAll();
			
			setEnableUI(document.form, document.form.cgo_opr_cd, document.form.pod_cd, 'enable');
    		document.getElementById("btn_Carrier").style.visibility = "";
    		document.getElementById("btn_VVDpop").style.visibility = "";
    		
    		//Attach File 버튼 색상변경
    		chgBtnAttachFile(0);
    		
    		resetForUnNo(formObj);
			
			ComSetObjValue(formObj.rgn_shp_opr_cd, rgn_shp_opr_cd);
			ComSetFocus(formObj.cgo_opr_cd);
		} else if(what == 'init') {
			sheetObjects[0].RemoveAll();
		}
		
		clearObjAll(document.form.spcl_cgo_seq, document.form.apro_ref_no, 3);
		
		setCgoSeq(sheetObjects[0], sheetObj);
		setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "disable");
    }
     
    /**
     * 화면 초기화 - Information of UN No.
     * param : formObj ==> 폼오브젝트
     */
    function resetForUnNo(formObj) {
    	ComSetObjValue(formObj.imdg_un_no_seq, 		    "");
    	ComSetObjValue(formObj.imdg_clss_cd, 		    "");
    	ComSetObjValue(formObj.imdg_comp_grp_cd, 	    "");
    	ComSetObjValue(formObj.prp_shp_nm, 			    "");
    	ComSetObjValue(formObj.hzd_desc, 			    "");
    	ComSetObjValue(formObj.imdg_pck_grp_cd, 	    "");
    	ComSetObjValue(formObj.psa_no, 				    "");
    	ComSetObjValue(formObj.hcdg_pck_rstr_desc, 		"");
    	ComSetObjValue(formObj.hcdg_intmd_bc_rstr_desc, "");
    	ComSetObjValue(formObj.hcdg_tnk_rstr_desc, 		"");
    	ComSetObjValue(formObj.imdg_lmt_qty, 		    "");
    	ComSetObjValue(formObj.imdg_expt_qty_cd, 		"");
    	ComSetObjValue(formObj.ems_no, 		            "");
    	ComSetObjValue(formObj.ctrl_temp_ctnt, 		    "");
    	ComSetObjValue(formObj.emer_rspn_gid_no, 		"");
    	ComSetObjValue(formObj.emer_rspn_gid_chr_no,    "");
    	ComSetObjValue(formObj.emer_temp_ctnt, 		    "");
    	ComSetObjValue(formObj.imdg_lmt_qty_meas_ut_cd, "");
    	ComSetObjValue(formObj.hcdg_flg,                "");
    	ComSetObjValue(formObj.imdg_subs_rsk_lbl_rmk,   "");
    	
    	var formItems = new Array();
		formItems[0] = "n1st";
		formItems[1] = "n2nd";
		formItems[2] = "n3rd";
		formItems[3] = "n4th";
    	for(var i=0; i<4; i++) {		
			ComSetObjValue(eval("document.form."+formItems[i]+"_imdg_subs_rsk_lbl_cd"), "");
		}
    	
    	//Cargo Status 값 초기화
    	document.all.dcgo_sts_cd.Code2 = "";
    	//Marin Pollutant 값 초기화
    	document.all.mrn_polut_flg.Code2 = "N";
    	//Limited Q'ty 값 초기화
    	document.all.imdg_lmt_qty_flg.Code2 = "N";
    	//Excepted Q'ty 값 초기화
    	document.all.imdg_expt_qty_flg.Code2 = "N";

    	//HCDG/Remark(s) Button 색상 초기화
    	chgBtnHcdgRemarks('', '');

    	//Technical Name 박스 초기화
    	var itemObj = document.getElementById("hzd_desc"); 	
    	chgTecNmBox('', itemObj);
    	ComSetObjValue(formObj.imdg_spcl_provi_no, "");

    	//Flash Point의 입력값 초기화
    	ComSetObjValue(formObj.flsh_pnt_cdo_temp, "");	
    	//Flash Point의 상태변경 결정
    	fixFlshPointForm(formObj); 

    	//Pre-Checking Report 결과 초기화
    	setPreChkRslt("N");
    }
     
//------------------------------------------------------------------------------//
/* 초기화 프로세스 -- 폼 이벤트 액션 */    
//------------------------------------------------------------------------------//     

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
		
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		
		var comboObj1 = comboObjects[2];
		
		var formObj   = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				
				case "btn2_Add":	
					if(sheetObj1.RowCount == 0 || sheetObj1.SelectRow == -1 || validateForm(sheetObj1,formObj,sheetObj1.SelectRow,IBSEARCH_ASYNC03)) {	//Container정보 필수입력여부 체크
			    		if(sheetObj2.RowCount == 0 || sheetObj2.SelectRow == -1 || validateForm(sheetObj2,formObj,-1,IBSEARCH_ASYNC01)) {	//Cago정보 필수입력여부 체크   
							addCntrRow(sheetObj1);
							addCgoRow(sheetObj1, sheetObj2);
			    		}
					}
					break;		
				case "btn2_Delete":			
					delCntrRow(sheetObj1, sheetObj2);
					break;
				case "btn2_Copy":
					//onPopupClick(sheetObj1, formObj, srcName, "CopyCntr");
					copyCntr('1', 1, null);
					break;
	
				case "btn2_UN_Information":
					onPopupClick(sheetObj1, formObj, srcName, "UnInformation");
					break;				
				case "btn2_Restrictions":
					onPopupClick(sheetObj1, formObj, srcName, "Restrictions");
					break;
				case "btn2_Pre_Checking_Report":
					onPopupClick(sheetObj2, formObj, srcName, "PreChecking");
					break;
				
				case "btn_Un_No":	
					onPopupClick(sheetObj1, formObj, srcName, "UnNo");
					break;

				case "btn2_Package_Qty_Type":
					onPopupClick(sheetObj2, formObj, srcName, "DgPkgQtyType");
					break;
				case "btn2_HCDG":
					//alert(srcName);
					break;
				case "btn2_Remark(s)":
					//alert(srcName);
					break;
				case "btn2_Other_Emergency_Information":
					onPopupClick(sheetObj2, formObj, srcName, "OtherEmerInfo");
					break;

				case "btn3_Remark":					
					onPopupClick(sheetObj2, formObj, srcName, "Remark");
					break;
				case "btn3_Row_Add":					
		    		if(validateForm(sheetObj2,formObj,-1,IBSEARCH_ASYNC01)) {	//Cago정보 필수입력여부 체크    		
		    			addCgoRow(sheetObj1, sheetObj2);
		    		}
					break;
				case "btn3_Row_Copy":
					if(validateForm(sheetObj2,formObj,-1,IBSEARCH_ASYNC01)) {	//Cago정보 필수입력여부 체크 
						copyCargo(sheetObj1, sheetObj2, sheetObj2.SelectRow);
					}
					break;
				case "btn3_Row_Delete":
					delCgoRow(sheetObj2, sheetObj1.CellValue(sheetObj1.SelectRow, "spcl_cntr_seq"), comboObj1.Code);
					break;
				
				case "btn_calendar":
					var cal = new ComCalendar();
		            cal.select(formObj.auth_dt, "yyyy-MM-dd"); 
					break;

				case "btn1_Retrieve":
					doActionIBSheet(sheetObj2, formObj, IBSEARCH);
					break;
				case "btn1_New":
					resetUI(sheetObj1, formObj, "new");
					
					orgSheetObj = null;
					newYn       = true;
					break;
				case "btn1_Attach_File":
					//Supporting Documents or Pictures 팝업 열기
					formObj.f_cmd.value = "";
					ComOpenPopup('/hanjin/VOP_SCG_2013_01.do?file_pop_kind=approval&'+FormQueryString(formObj), 605, 290, "setFileUpload", 'none', true);	
					break;
				case "btn1_Save":
					doActionIBSheet(sheetObj2, formObj, IBSAVE);
					break;
				case "btn1_Mail":
					onPopupClick(sheetObj2, formObj, srcName, "Mail");
					break;
				case "btn1_Close":
					window.close();
					break;
				
				//Pop-Up
				case "btn_Carrier":
	 				onPopupClick(sheetObj1, formObj, srcName, "Carrier");
	 				break;
				case "btn_VVDpop":
	 				onPopupClick(sheetObj1, formObj, srcName, "VVD");
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
    
    // 업무 자바스크립트 OnFocus 이벤트 처리
    function obj_focus() {
    	switch(event.srcElement.name){ 
	    	case "auth_dt":
				ComClearSeparator (event.srcElement);
				ComSetFocus("auth_dt");
				break;
    	}
    }
    
    // 업무 자바스크립트 OnFocusOut 이벤트 처리
    function obj_focusout() {
    	var sheetObj = sheetObjects[1];
    	with(event.srcElement) {
	    	switch(name) { 
		    	case "cgo_opr_cd":	
		    		searchCarrierCheck(event.srcElement);	//Carrier Check
		        	break;
		    	case "skd_dir_cd":	
		    		searchVVDCheck();						//VVD Check
		        	break;	
		    	case "imdg_un_no":	
		    		searchUNNoCheck(event.srcElement);		//UN No. Check
		        	break;
		    	case "grs_wgt":	case "net_wgt":	
		    		ComSetObjValue(eval("document.form."+event.srcElement.name), sheetObj.CellText(sheetObj.SelectRow, event.srcElement.name));
		    		//상호 배제
		    		if(document.activeElement.id != 'grs_wgt' && document.activeElement.id != 'net_wgt') {
		    			chkGrossNetWeight(event.srcElement);
		    		}
		        	break;
		    	case "wgt_ut_cd":
		    		ComSetObjValue(document.form.wgt_ut_cd2, event.srcElement.value);
		        	break;
		    	case "wgt_ut_cd2":	
		    		ComSetObjValue(document.form.wgt_ut_cd, event.srcElement.value);
		        	break;
		    	case "auth_dt":
		    		ComAddSeparator(event.srcElement);
		    		break;
		    	case "flsh_pnt_cdo_temp":	 
		    		if(ComChkObjValid(event.srcElement)) {
		    			chkFlshPoint(event.srcElement);
		    		}
		    		break;
	    	}
    	}
    } 
    
    // 업무 자바스크립트 OnKeyPress 이벤트 처리
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	    	case "cgo_opr_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	    	case "bkg_no":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	    	case "vsl_cd":	
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "skd_voy_no":	
	        	    	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "skd_dir_cd":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;	   
	    	        case "imdg_un_no": 
	    	        	ComKeyOnlyNumber(event.srcElement);
	    	        	break;
	    	        case "wgt_ut_cd": case "wgt_ut_cd2":	
	    	        	ComKeyOnlyAlphabet('upper');
	    	        	break;
	    	        case "emer_cntc_phn_no": case "emer_cntc_pson_nm":	
	    	        	ComKeyOnlyAlphabet('num','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|58|59|60|61|62|63|64|91|92|93|94|95|96|123|124|125|126');
	    	        	break;
	    	        case "apro_ref_no":
	    	        	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
	    	        case "imdg_segr_grp_no":
	    	        	ComKeyOnlyAlphabet('num');
	    	        	break;	
    	    	}
    	    	break;
    	    case "float":
	            ComKeyOnlyNumber(event.srcElement, "-.");
	            break;
    	    case "int":
	            ComKeyOnlyNumber(event.srcElement, "-");
	            break;
    	    default:
    	    	ComKeyOnlyAlphabet("num");
    	    	break;     
    	}
    }  
    
    // 업무 자바스크립트 OnChange 이벤트 처리
    function obj_change() {
    	var sheetObj = sheetObjects[1];
    	with(event.srcElement) {
	    	switch(name){
		    	case "vsl_cd": case "skd_voy_no":	
		    		var vsl_cd     = ComGetObjValue(document.form.skd_voy_no);
		    		var skd_dir_cd = ComGetObjValue(document.form.skd_dir_cd);
	    			if(name == "vsl_cd") {
	    				ComSetObjValue(document.form.skd_voy_no, "");
		    			ComSetObjValue(document.form.skd_dir_cd, "");
	    			} else if(name == "skd_voy_no") {
	    				ComSetObjValue(document.form.skd_dir_cd, "");
	    			}
	    			
	    			comboObjects[0].RemoveAll();
	    			comboObjects[1].RemoveAll();
		        	break;	
		    	case "n1st_imdg_subs_rsk_lbl_cd": case "n2nd_imdg_subs_rsk_lbl_cd":	case "n3rd_imdg_subs_rsk_lbl_cd":	case "n4th_imdg_subs_rsk_lbl_cd":		
		    		if(ComChkObjValid(event.srcElement)) {	//Float, Int Check
		    			fixFlshPointForm(document.form);	//Flash Point의 상태변경 결정
		    		}
		        	break;
		    	case "bkg_ref_no": case "vsl_cd": case "skd_voy_no": case "skd_dir_cd":
		    		//Pre-Checking Report 결과 초기화
					setPreChkRslt("N");
		    		break;
		    	case "auth_sts_cd":
		    		if(value == 'Y') {
		    			var psn_no    = ComGetObjValue(document.form.psa_no);
		    			var flsh_temp = ComGetObjValue(document.form.flsh_pnt_cdo_temp);
		    			
		    			if(psn_no == '1' && flsh_temp != '' && parseInt(flsh_temp) < -25) {
		    				doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC02);
		    			}
		    		}
		    		break;
	    	}
    	}
    } 
    
    // 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keyup() {  
    	var sheetObj = sheetObjects[1];
    	with(event.srcElement) {
	    	switch(name) { 
	    		case "grs_wgt":	case "net_wgt":	
	    			var wgtVal  = ComGetObjValue(eval("document.form."+name));
	        		var wgtVals = wgtVal.split("."); 
	        		if(wgtVals.length > 1 && wgtVals[1].length > 3) {
	        			wgtVal = wgtVal.substring(0,wgtVal.length-1);
	        			ComSetObjValue(eval("document.form."+name), wgtVal);
	        		}
//        			if(wgtVals[0].length > 15) {
//        				wgtVal = wgtVals[0].substring(0,wgtVals[0].length-1);
//        				if(wgtVals.length > 1) wgtVal = wgtVal + "." + wgtVals[1];
//        				ComSetObjValue(eval("document.form."+name), wgtVal);
//        			}
//        			var objMaxLength = ComReplaceStr(wgtVal.replace('.',''),',','').length;
//        			if(objMaxLength == 18) {
//        				if(name == 'grs_wgt') ComSetNextFocus(document.form.net_wgt);
//        				else ComSetNextFocus(document.form.prp_shp_nm);
//        			}
	    			sheetObj.CellValue2(sheetObj.SelectRow, name) = ComGetObjValue(eval("document.form."+name));	    			

		        	break;
		        default:
		        	if(event.keyCode != 9) obj_nextfocus(event.srcElement);
		        
		        	break;
	    	}
    	}
    }
    
    // 인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
    function obj_nextfocus(obj) {
    	var objMaxLength = obj.getAttribute("maxlength");
    	var objValue 	 = obj.getAttribute("value");
    	
    	if (ComChkLen(objValue, objMaxLength) == 2) {    		
    		if(obj.name == 'vsl_cd') {
    			ComSetObjValue(document.form.skd_voy_no, "");
    			ComSetObjValue(document.form.skd_dir_cd, "");
			} else if(obj.name == 'skd_voy_no') {
				ComSetObjValue(document.form.skd_dir_cd, "");
			}
    		if(obj.name == 'skd_dir_cd' || obj.name == 'cgo_opr_cd') {
    			obj.blur();
    		} else {
    			ComSetNextFocus(obj);
    		}
    	}
    }
    
    // 업무 자바스크립트 OnKeyDown 이벤트 처리
    function obj_keydown() {
    	if(event.keyCode == 13) {
    		switch(event.srcElement.name) {
    	    	case "rgn_shp_opr_cd": case "cgo_opr_cd": case "bkg_ref_no": case "vsl_cd": case "skd_voy_no": case "skd_dir_cd": case "pol_cd": case "pod_cd":
    	    		var obj = document.getElementById("btn1_Retrieve");
    	    		obj.fireEvent("onclick");
    	    		break;
    		}
    	}
    } 
    
    // 닫기 이벤트에 대한 부모창 갱신
    function win_close() {
    	if(preConds.pop_mode != 'view') {
    		if(newYn) {
    			window.dialogArguments.searchList();
    		} else {
	    		closeYn = true;
	    		if(orgSheetObj != null) sheetObjects[1].LoadSearchXml(orgSheetObj);
    		}
    	}
    }
    
//------------------------------------------------------------------------------//
/* 폼 이벤트 액션 -- 시트 이벤트 액션*/    
//------------------------------------------------------------------------------//
    
	/**
     * Sheet1 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
	function sheet1_OnLoadFinish(sheetObj) {	
	 	//Combo 초기화
	 	//searchTPSZList(sheetObj);	//ComOpenWait 함수 충돌 이유로 LoadPage로 이동
	}

	/**
     * Sheet2 OnLoadFinish Event 처리
     * param : sheetObj ==> 시트오브젝트
     * 
     */
	function sheet2_OnLoadFinish(sheetObj) {//ComOpenWait 함수 충돌 이유로 LoadPage로 이동		 	
	 	//초기셋팅
	 	//setPreCondition(sheetObj);
	 	
	 	//조회
//	 	if(preConds.spcl_cgo_rqst_seq != '') {
//	 		doActionIBSheet(sheetObj, document.form, IBSEARCH);
//	 	} else {
//	 		var openerXml = window.dialogArguments.getAppDetlObj();
//	 		if(openerXml != null) {
//		 		sheetObj.LoadSearchXml(openerXml, true);
//	 		} else {
//	 			resetUI(sheetObj, document.form, "init");
//	 		}
//	 	}
	}
     
    /**
     * imdg_lmt_qty_flg MultiCombo OnLoadFinish Event 처리
     * param : comboObj ==> 콤보오브젝트
     * 
     */
 	function imdg_lmt_qty_flg_OnLoadFinish(comboObj) {	
    	 //initCombo(comboObj, comboObj.no);	//ComOpenWait 함수 충돌 이유로 LoadPage로 이동	
 	}
 	
 	/**
     * imdg_expt_qty_flg MultiCombo OnLoadFinish Event 처리
     * param : comboObj ==> 콤보오브젝트
     * 
     */
 	function imdg_expt_qty_flg_OnLoadFinish(comboObj) {	
    	 //initCombo(comboObj, comboObj.no);	//ComOpenWait 함수 충돌 이유로 LoadPage로 이동	
 	}
     
    /**
     * mrn_polut_flg MultiCombo OnLoadFinish Event 처리
     * param : comboObj ==> 콤보오브젝트
      * 
     */
  	function mrn_polut_flg_OnLoadFinish(comboObj) {
     	 //initCombo(comboObj, comboObj.no);	//ComOpenWait 함수 충돌 이유로 LoadPage로 이동	
  	}

	/**
     * Sheet2 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	 if(!closeYn) {
	    	 var sheetObj1 = sheetObjects[0];
	    	 sheetObj1.RemoveAll();
	    	 btnEnabled("init", true);
	    	 
	    	 with (sheetObj) {    		
	    		if(RowCount != 0) {
	    			var cntrSeq, nextCntrSeq, authStsCd;
	    			var yCt = 0, nCt = 0, rCt = 0;
	    			for ( var iRow = HeaderRows; iRow <= LastRow; iRow++) {
	    				cntrSeq   = CellValue(iRow, "spcl_cntr_seq");
	    				authStsCd = CellValue(iRow, "auth_sts_cd");
	    				if(cntrSeq != nextCntrSeq) {
	    					sheetObj1.DataInsert(-1,0);
	    					sheetObj1.CellValue2(sheetObj1.SelectRow, "spcl_cntr_seq") = cntrSeq;
	    					sheetObj1.CellValue2(sheetObj1.SelectRow, "cntr_ref_no")   = CellValue(iRow, "cntr_ref_no");
	    					sheetObj1.CellValue2(sheetObj1.SelectRow, "cntr_tpsz_cd")  = CellValue(iRow, "cntr_tpsz_cd");
	    					
	    					findFirstRowCgo(sheetObj1, sheetObj1.SelectRow, sheetObj);
	    				}
	    				nextCntrSeq = cntrSeq;
	    				
	    				if(authStsCd == 'Y') yCt++;
	    				else if(authStsCd == 'N') nCt++;
	    				else if(authStsCd == 'R') rCt++;
	    				
	    				sheetObj.CellValue2(iRow, "org_auth_sts_cd") = authStsCd;
	    			}
	    			
	    			sheetObj1.SelectCell(1, "cntr_ref_no");
	    			sheetObj.SelectCell(1, "cntr_ref_no");
	    			
	    			//승인진행상태에 따라서 입력항목 조절
	    			var noEditFlg = true;
					for ( var cRow = sheetObj1.HeaderRows; cRow <= sheetObj1.LastRow; cRow++) {
						var fstRow = sheetObj.FindText("spcl_cntr_seq", sheetObj1.CellValue(cRow, "spcl_cntr_seq"), 0, -1, true);
						noEditFlg = true;
						for(var cntrCt=fstRow; cntrCt<=sheetObj.LastRow; cntrCt++) {
							if(sheetObj.CellValue(cntrCt, "spcl_cntr_seq") != sheetObj1.CellValue(cRow, "spcl_cntr_seq")) break;
							if(sheetObj.CellValue(cntrCt, "org_auth_sts_cd") == 'R') noEditFlg = false;
						}
						if(noEditFlg) {
							sheetObj1.CellEditable(cRow, "cntr_ref_no") = false;
							sheetObj1.CellEditable(cRow, "cntr_tpsz_cd") = false;
						}
					}
	    			if(rCt == 0) {  
	    				
	    				btnEnabled("view", false);
	    				
	    				if(preConds.pop_mode != 'view') preConds.pop_mode = "noedit";
	    			} if((yCt+nCt) > 0) {
	    				setEnableUI(document.form, document.form.pol_cd, document.form.pod_cd, "disable");
	    			}
	    			
	    			//초기 로드 Cargo 선택
	    			if(preConds.spcl_cntr_seq != '') {
	    				sheetObj1.SelectCell(sheetObj1.FindText("spcl_cntr_seq",preConds.spcl_cntr_seq),"cntr_ref_no");
	    				document.all.spcl_cgo_seq.Code = preConds.spcl_cgo_seq;
	    				
	    				preConds.spcl_cntr_seq = '';
	    				preConds.spcl_cgo_seq  = '';
	    			}
	    		} else {
	    			sheetObj1.LoadSearchXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");
	    			
	    			clearObjAll(document.form.spcl_cgo_seq, document.form.apro_ref_no, 3);
	    			
	    			setCgoSeq(sheetObj1, sheetObj);
	    			setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "disable");
	    			
	    			btnEnabled("init", false);
	    		}
	    	 }
	    	 
	    	 //편집전 원본정보 유지
	    	 orgSheetObj = IBS_GetDataSearchXml(sheetObj);
	    	 setOrgFormInfo(document.form);
    	 } else {
    		 window.dialogArguments.setResultPop(orgFormObj, sheetObj);
    	 }
    }
     
    /**
     * Sheet3 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 에러메시지
     * 
     */
  	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {	
  	 	with(sheetObj) {
  	 		for(var rowIdx=HeaderRows; rowIdx<=LastRow; rowIdx++) {
  	 			CellValue2(rowIdx, "spcl_cgo_irr_file_seq") = CellValue(rowIdx, "spcl_cgo_rqst_atch_file_seq");
  	 		}
  	 		
  	 		//버튼 색상 변경
  	 		chgBtnAttachFile(RowCount);
  	 	}
  	}

	/**
     * Sheet1 Cell Select Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 Row ==> NewRow, 선택한 Col ==> NewCol
     * note  : validation으로 인한 이전상태로의 원복시에는 이벤트 발생을 제한한다. (see - callBack)
     */
    var callBack = true;	
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	if(callBack && NewRow != OldRow) {
    		//Container 정보 셋팅전의 경우 아래 기능 무의미
    		if(sheetObj.CellValue(NewRow, "spcl_cntr_seq") != '') {
	    		
	    		var requiredChk = false;
	    		//Container정보 필수입력여부 체크
	    		if(sheetObj.RowStatus(OldRow) != '' && OldRow != 0 && !validateForm(sheetObj,document.form,OldRow,IBSEARCH_ASYNC03)) {	
	    			requiredChk = true;	    			
	    		}
	    		//Cago정보 필수입력여부 체크   - 예외)화면 Reset일 경우 예외
	    		if(!requiredChk) {
	    			if(sheetObj.RowCount != 0 && !validateForm(sheetObj,document.form,-1,IBSEARCH_ASYNC01)) {
		    			requiredChk = true;
		    		}
	    		}
	    		
	    		if(requiredChk) {	    			
	    			callBack = false;
	    			sheetObj.SelectCell(OldRow, "spcl_cntr_seq");
	    			callBack = true;
	    			
	    			return;
	    		}
	    		
	    		//Delete, Copy 버튼 활성화
	    		btnEnabled('init', true);
	    		
	    		var sheetObj2 = sheetObjects[1];
	    		
	    		var isCgoSeq = findMaxCgoRow(sheetObj2, sheetObj.CellValue(NewRow, "spcl_cntr_seq"));
	    		
	    		if(isCgoSeq == 0) {
	    			clearObjAll(document.form.spcl_cgo_seq, document.form.apro_ref_no, 3);
	    			setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "disable");
	    			sheetObj2.SelectCell(0, "spcl_cgo_seq");
	    		} else {
	    			var isDisabled = document.form.cntr_cgo_seq_sum.disabled;
	    			
	    			if(isDisabled) {
	    				setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "enable");    			
	    			} else {
	    				setFormToSheetAll(sheetObj2, sheetObj2.SelectRow, document.form.imdg_clss_cd, document.form.apro_ref_no);
	    			}
	    			
	    			clearObjAll(document.form.spcl_cgo_seq, document.form.apro_ref_no, 3);
	    			findFirstRowCgo(sheetObj, NewRow, sheetObj2);
	    		}
    		}
    	}
	}
     
    /**
     * Sheet1 Cell OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> Row, 선택한 Col ==> Col
     * note  : validation으로 인한 이전상태로의 원복시에는 이벤트 발생을 제한한다. (see - callBack), 이전 선택 Row 값 저장 (see - beforeRow)
     * see   : OnSelect Event로 대체
     */
//    var callBack = true;	
//    var beforeRow;
//    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
//    	if(callBack && Row != beforeRow) {
//			//Container 정보 셋팅전의 경우 아래 기능 무의미
//			if(sheetObj.CellValue(Row, "spcl_cntr_seq") != '') {
//				//Cago정보 필수입력여부 체크    		
//				if(!validateForm(sheetObj,document.form,-1,IBSEARCH_ASYNC01)) {
//					
//					callBack = false;
//					sheetObj.SelectCell(beforeRow, "spcl_cntr_seq");
//					callBack = true;
//					
//					return;
//				} else {
//					beforeRow = Row;
//				}
//				
//				var sheetObj2 = sheetObjects[1];
//				
//				var isCgoSeq = findMaxCgoRow(sheetObj2, sheetObj.CellValue(Row, "spcl_cntr_seq"));
//				
//				if(isCgoSeq == 0) {
//					clearObjAll(document.form.spcl_cgo_seq, document.form.apro_ref_no, 3);
//					setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "disable");
//					sheetObj2.SelectCell(0, "spcl_cgo_seq");
//				} else {
//					var isDisabled = document.form.cntr_cgo_seq_sum.disabled;
//					
//					if(isDisabled) {
//						setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "enable");    			
//					} else {
//						setFormToSheetAll(sheetObj2, sheetObj2.SelectRow, document.form.imdg_clss_cd, document.form.apro_ref_no);
//					}
//					
//					clearObjAll(document.form.spcl_cgo_seq, document.form.apro_ref_no, 3);
//					findFirstRowCgo(sheetObj, Row, sheetObj2);
//				}
//			}
//		}
//	}
    
    /**
     * Sheet2 Cell Select Event 처리
     * param : sheetObj ==> 시트오브젝트, OldRow ==> 선택전 Row, OldCol ==> 선택전 Col, 선택한 Row ==> NewRow, 선택한 Col ==> NewCol
     * 
     */
    var cgoSelBlk = false;
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	 if(!cgoSelBlk) {
	    	 with (sheetObj) {
	    		 var status = RowStatus(NewRow);
		    	 if(RowCount != 0 && status != 'D') {
			    	 setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "enable");
			    	 setCgoSeq(sheetObjects[0], sheetObj);
			    	 setSheetToFormAll(sheetObj, NewRow, document.form.spcl_cgo_seq, document.form.apro_ref_no);
		    	 }
	    	 }
    	 }
	}
     
    /**
     * Sheet1 OnKeyUp Event 처리
     * param : sheetObj ==> 시트오브젝트, 선택한 Row ==> Row, 선택한 Col ==> Col
     * 
     */
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
  		with(sheetObj) { 
  			if(ColSaveName(Col) == "cntr_ref_no") {
  				var sheetObj2 = sheetObjects[1];
  				var cntrSeq;
  				for(var i=sheetObj2.HeaderRows; i<=sheetObj2.LastRow; i++) {
  					cntrSeq = sheetObj2.CellValue(i, "spcl_cntr_seq");
  					if(cntrSeq == CellValue(Row, "spcl_cntr_seq")) sheetObj2.CellValue2(i, ColSaveName(Col)) = EditValue;
  				}
  	    	}
   		}
    } 
    
    /**
     * Sheet1 Combo Change Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col, Value ==> Grid Cell Value
     * 
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	 with(sheetObj) { 
    		var sheetObj2 = sheetObjects[1];
	    	if(ColSaveName(Col) == "cntr_tpsz_cd") {
  				var cntrSeq;
  				for(var i=sheetObj2.HeaderRows; i<=sheetObj2.LastRow; i++) {
  					cntrSeq = sheetObj2.CellValue(i, "spcl_cntr_seq");
  					if(cntrSeq == CellValue(Row, "spcl_cntr_seq")) sheetObj2.CellValue2(i, ColSaveName(Col)) = CellValue(Row, Col);
  				}
	    	} else if(ColSaveName(Col) == "diff_rmk") {
	    		ComSetObjValue(document.form.diff_rmk, sheetObj2.CellValue(Row, Col));
	    	}
    	 }
	}
     
    /**
     * Sheet2 Cell Change Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col, Value ==> Grid Cell Value
     * 
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
     	 with(sheetObj) { 
 	    	if(ColSaveName(Col) == "diff_rmk") {
 	    		ComSetObjValue(document.form.diff_rmk, sheetObjects[1].CellValue(Row, Col));
 	    	}
     	 }
 	}
     
    /**
     * POL Combo Change Event 처리
     * param : comboObj ==> 콤보오브젝트, 변경한 Code ==> Code, 변경한 Text ==> Text
     * 
     */
    function pol_cd_OnChange(comboObj, Code, Text) {
    	searchETADt(Code);	//ETA Dt 조회
    	
 		doActionIBCombo(sheetObjects[1], comboObjects[1], 2, Code);	//POD 조회
 		
 		//Pre-Checking Report 결과 초기화
		setPreChkRslt("N");
    }
     
    /**
     * POD Combo Change Event 처리
     * param : comboObj ==> 콤보오브젝트, 변경한 Code ==> Code, 변경한 Text ==> Text
     * 
     */
    function pod_cd_OnChange(comboObj, Code, Text) {
    	//Pre-Checking Report 결과 초기화
		setPreChkRslt("N");
    }
     
    /**
     * Cargo Seq. Combo OnChange Event 처리
     * param : comboObj ==> 콤보오브젝트, 변경한 Code ==> Code, 변경한 Text ==> Text
     * 
     */
    function spcl_cgo_seq_OnChange(comboObj, Code, Text) {  
    	if(Code != preCgoSeq) {
	    	if(validateForm(sheetObjects[1],document.form,-1,IBSEARCH_ASYNC01)) {	//Cago정보 필수입력여부 체크 
		    	var sheetObj1 = sheetObjects[0];
		    	var sheetObj2 = sheetObjects[1];
		    	
		    	setFormToSheetAll(sheetObj2, sheetObj2.SelectRow, document.form.imdg_clss_cd, document.form.apro_ref_no);
		    	
		    	var selCntrSeq = sheetObj1.CellValue(sheetObj1.SelectRow, "spcl_cntr_seq");
		    	var fstRow = sheetObj2.FindText("spcl_cntr_seq", selCntrSeq, 0, -1, true);
				
		    	var cntrSeq, cgoSeq;
				for(var startIdx=fstRow; startIdx<=sheetObj2.LastRow; startIdx++) {
					cntrSeq = sheetObj2.CellValue(startIdx, "spcl_cntr_seq");
					cgoSeq  = sheetObj2.CellValue(startIdx, "spcl_cgo_seq");
					if(selCntrSeq == cntrSeq && Code == cgoSeq) sheetObj2.SelectCell(startIdx, "spcl_cgo_seq");
				}
				preCgoSeq = Code;
	    	} else {
	    		comboObj.Code = preCgoSeq;
	    	}
    	}
    }
     
    /**
     * Cargo Seq. Combo OnFocus Event 처리
     * param : comboObj ==> 콤보오브젝트
     * 
     */
    var preCgoSeq;
    function spcl_cgo_seq_OnFocus(comboObj) {
    	preCgoSeq = comboObj.Code;
    }
    
    /**
     * Limited Q'ty Combo OnChange Event 처리
     * param : comboObj ==> 콤보오브젝트, 변경한 Code ==> Code, 변경한 Text ==> Text
     * 
     */
    function imdg_lmt_qty_flg_OnChange(comboObj, Code, Text) {  
    	var formObj = document.form;
    	var sheetObj = sheetObjects[1];
    	
    	var imdg_un_no     = ComGetObjValue(formObj.imdg_un_no);
    	var imdg_un_no_seq = ComGetObjValue(formObj.imdg_un_no_seq);
    	
    	if(imdg_un_no.length > 0 && Code == 'Y') {
    		var sXml = searchUnNoInfo(sheetObj, imdg_un_no, imdg_un_no_seq);
    		
    		var sArr1 = ComScgXml2Array(sXml, "imdg_lmt_qty");
    		var sArr2 = ComScgXml2Array(sXml, "imdg_lmt_qty_desc");
			if(sArr1 != null) {
				var imdg_lmt_qty      = sArr1[0];
				var imdg_lmt_qty_desc = sArr2[0];
				
				//if((imdg_lmt_qty == '0' || imdg_lmt_qty == '') && imdg_lmt_qty_desc != '') {	//LQ Remark 여부에 대한 조건 삭제, 2009.10.13
				//if(imdg_lmt_qty == '0' || imdg_lmt_qty == '') {
				if((imdg_lmt_qty == '0' || imdg_lmt_qty == '') && imdg_lmt_qty_desc == '') {	//LQ Remark 여부에 대한 조건 추가, 2010.05.18
					ComShowCodeMessage('SCG50016');	//'This UN No. is not permitted as Limited Quantity.'				
					document.all.imdg_lmt_qty_flg.Code2 = 'N';
					
					return;
				}
			}
			
//			var max_in_pck_qty = ComGetObjValue(formObj.max_in_pck_qty);
//			if(max_in_pck_qty == '' || max_in_pck_qty == '0') {
//				ComShowCodeMessage('SCG10072');	//'This UN No. is not permitted as Limited Quantity.'				
//				document.all.imdg_lmt_qty_flg.Code2 = 'N';
//				
//				return;
//			}
    	} else if(imdg_un_no.length == 0) {
    		ComShowCodeMessage('SCG50007', 'UN No.');	//'Please input {?msg1}.'
    		
    		ComSetFocus(formObj.imdg_un_no);
    		
    		var selCode = document.all.imdg_lmt_qty_flg.Code;
    		if(selCode == 'Y') document.all.imdg_lmt_qty_flg.Code2 = 'N';
    		else document.all.imdg_lmt_qty_flg.Code2 = 'Y';
    		
    		return;
    	}
    	
    	return;
    }
     
    /**
     * Excepted Q'ty Combo OnChange Event 처리
     * param : comboObj ==> 콤보오브젝트, 변경한 Code ==> Code, 변경한 Text ==> Text
     * 
     */
    function imdg_expt_qty_flg_OnChange(comboObj, Code, Text) {  
     	var formObj = document.form;
     	var sheetObj = sheetObjects[1];
     	
     	var imdg_un_no     = ComGetObjValue(formObj.imdg_un_no);
     	var imdg_un_no_seq = ComGetObjValue(formObj.imdg_un_no_seq);
     	
     	if(imdg_un_no.length > 0 && Code == 'Y') {
     		var sXml = searchUnNoInfo(sheetObj, imdg_un_no, imdg_un_no_seq);
     		
     		var sArr1 = ComScgXml2Array(sXml, "imdg_expt_qty_cd");
     		var sArr2 = ComScgXml2Array(sXml, "imdg_expt_qty_desc");
 			if(sArr1 != null) {
 				var imdg_expt_qty_cd   = sArr1[0];
 				var imdg_expt_qty_desc = sArr2[0];
 				
 				//if((imdg_expt_qty_cd == 'E0' || imdg_expt_qty_cd == '') && imdg_expt_qty_desc != '') {//EQ Remark 여부에 대한 조건 삭제, 2009.10.13
 				if(imdg_expt_qty_cd == 'E0' || imdg_expt_qty_cd == '') {
 					ComShowCodeMessage('SCG50019');	//'This UN No. is not permitted as Excepted Quantity.'
 					document.all.imdg_expt_qty_flg.Code2 = 'N';
 					
 					return;
 				}
 			}
// 			var max_in_pck_qty = ComGetObjValue(formObj.max_in_pck_qty);
//			if(max_in_pck_qty == '' || max_in_pck_qty == '0') {
//				ComShowCodeMessage('SCG50019');	//'This UN No. is not permitted as Excepted Quantity.'	
//				document.all.imdg_expt_qty_flg.Code2 = 'N';
//				
//				return;
//			}
     	} else if(imdg_un_no.length == 0) {
     		ComShowCodeMessage('SCG50007', 'UN No.');	//'Please input {?msg1}.'
     		
     		ComSetFocus(formObj.imdg_un_no);
     		
     		var selCode = document.all.imdg_expt_qty_flg.Code;
     		if(selCode == 'Y') document.all.imdg_expt_qty_flg.Code2 = 'N';
     		else document.all.imdg_expt_qty_flg.Code2 = 'Y';
     		
     		return;
     	}
     	
     	return;
    }
     
    /**
     * Marine Pollutant Combo OnChange Event 처리
     * param : comboObj ==> 콤보오브젝트, 변경한 Code ==> Code, 변경한 Text ==> Text
     * 
     */
    function mrn_polut_flg_OnChange(comboObj, Code, Text) {  
    	var formObj = document.form;
      	var sheetObj = sheetObjects[1];
      	
      	var imdg_un_no     = ComGetObjValue(formObj.imdg_un_no);
      	var imdg_un_no_seq = ComGetObjValue(formObj.imdg_un_no_seq);
      	
      	if(imdg_un_no.length > 0 && Code == 'N') {
      		var sXml = searchUnNoInfo(sheetObj, imdg_un_no, imdg_un_no_seq);
      		
      		var sArr = ComScgXml2Array(sXml, "imdg_mrn_polut_cd");
  			if(sArr != null) {
  				var imdg_mrn_polut_cd   = sArr[0];
  				
  				if(imdg_mrn_polut_cd == 'P') {
  					ComShowCodeMessage('SCG50026');	//'This UN No. is identified as marine pollutants.'
  					document.all.mrn_polut_flg.Code2 = 'Y';
  					
  					return;
  				}
  			}
      	} else if(imdg_un_no.length == 0) {
      		ComShowCodeMessage('SCG50007', 'UN No.');	//'Please input {?msg1}.'
      		
      		ComSetFocus(formObj.imdg_un_no);
      		
      		var selCode = document.all.mrn_polut_flg.Code;
      		if(selCode == 'Y') document.all.mrn_polut_flg.Code2 = 'N';
      		else document.all.mrn_polut_flg.Code2 = 'Y';
      		
      		return;
      	}
    }

//------------------------------------------------------------------------------//
/* 시트 이벤트 액션 - 일반 함수 */    
//------------------------------------------------------------------------------//
	
	/**
     * Add Container
     */   
	function addCntrRow(sheetObj) {		
		with(sheetObj) {			
			var maxSeq = 0;
			
			if(RowCount > 0) {
				var cntrSeq;
				for(var idx=HeaderRows; idx<=LastRow; idx++) {
					cntrSeq = CellValue(idx, "spcl_cntr_seq");
					if(parseInt(cntrSeq) > maxSeq) maxSeq = parseInt(cntrSeq);
				}
			}
			
			DataInsert(-1,0);
			CellValue2(SelectRow, "spcl_cntr_seq") = maxSeq + 1;
		}
		
		btnEnabled("init", true);
	}

	/**
     * Add Cargo
     */   
	function addCgoRow(sheetObj1, sheetObj2) {	
		if(sheetObj1.SelectRow > 0) {
			if(sheetObj2.RowCount > 0) {
				setFormToSheetAll(sheetObj2, sheetObj2.SelectRow, document.form.imdg_clss_cd, document.form.apro_ref_no);
			} else {
				sheetObj2.RemoveAll();
			}
			
			sheetObj2.DataInsert(-1,0);	
			sheetObj2.SelectCell(sheetObj2.SelectRow, "spcl_cntr_seq");
			
			var cntrSeq    = sheetObj1.CellValue(sheetObj1.SelectRow, "spcl_cntr_seq");
			var cntrRefNo  = sheetObj1.CellValue(sheetObj1.SelectRow, "cntr_ref_no");
			var cntrTpszCd = sheetObj1.CellValue(sheetObj1.SelectRow, "cntr_tpsz_cd");
			var cgoSeq  = findMaxCgoRow(sheetObj2, cntrSeq) + 1;
			
			sheetObj2.CellValue2(sheetObj2.SelectRow, "spcl_cntr_seq") = cntrSeq;
			sheetObj2.CellValue2(sheetObj2.SelectRow, "spcl_cgo_seq")  = cgoSeq;
			sheetObj2.CellValue2(sheetObj2.SelectRow, "cntr_ref_no")   = cntrRefNo;
			sheetObj2.CellValue2(sheetObj2.SelectRow, "cntr_tpsz_cd")  = cntrTpszCd;
			
			//기본값
			sheetObj2.CellValue2(sheetObj2.SelectRow, "imdg_lmt_qty_flg")  = "N";
			sheetObj2.CellValue2(sheetObj2.SelectRow, "mrn_polut_flg")     = "N";
			sheetObj2.CellValue2(sheetObj2.SelectRow, "imdg_expt_qty_flg") = "N";
			sheetObj2.CellValue2(sheetObj2.SelectRow, "auth_dt")           = ComGetNowInfo("ymd", "-");
			sheetObj2.CellValue2(sheetObj2.SelectRow, "auth_sts_cd")       = "R";
			sheetObj2.CellValue2(sheetObj2.SelectRow, "cgo_rqst_dt")       = ComGetNowInfo("ymd", "-");
			sheetObj2.CellValue2(sheetObj2.SelectRow, "wgt_ut_cd")         = "KGS";
			
			sheetObj2.SelectCell(sheetObj2.SelectRow, "spcl_cgo_seq");
			
			var isCgoSeq = findMaxCgoRow(sheetObj2, cntrSeq);
			if(isCgoSeq == 1) setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "enable");
			
			btnEnabled("init", true);
			
			//Pre-Checking Report 결과 초기화
			setPreChkRslt("N");
		} else {
			ComShowCodeMessage('SCG50007','CNTR Seq.');	//'Please input {?msg1}.'
		}
		
		return;
	}
	
	/**
     * Find Cargo Sequence
     */
	function findMaxCgoRow(sheetObj, searchVal) {
		var fstRow = sheetObj.FindText("spcl_cntr_seq", searchVal, 0, -1, true);
		
		if(fstRow == -1) {
			return 0;
		} else {
			var maxSeq = 0, cgoSeq = 0;
			var cntrSeq;
			for(var startIdx=fstRow; startIdx<=sheetObj.LastRow; startIdx++) {
				cntrSeq = sheetObj.CellValue(startIdx, "spcl_cntr_seq");
				cgoSeq  = parseInt(sheetObj.CellValue(startIdx, "spcl_cgo_seq"));
				if(sheetObj.RowStatus(startIdx) != 'D' && searchVal == cntrSeq && cgoSeq > maxSeq) maxSeq = cgoSeq;
			}
			return maxSeq;
		}
	}
     
    /**
     * Delete Container
     */
 	function delCntrRow(sheetObj1, sheetObj2) {	
 		delCgoRow(sheetObj2, sheetObj1.CellValue(sheetObj1.SelectRow, "spcl_cntr_seq"), -1);
		sheetObj1.RowDelete(sheetObj1.SelectRow, false);
		sheetObj1.SelectCell(0, "spcl_cntr_seq");
		sheetObj2.SelectCell(0, "spcl_cgo_seq");
		
		clearObjAll(document.form.spcl_cgo_seq, document.form.apro_ref_no, 3);
		
		setCgoSeq(sheetObj1, sheetObj2);
		setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "disable");
		
		btnEnabled("init", false);
 	}
	
	/**
     * Delete Cargo
     */
	function delCgoRow(sheetObj, delCntrSeq, delCgoSeq) {	
		var fstRow = sheetObj.FindText("spcl_cntr_seq", delCntrSeq, 0, -1, true);
		
		if(fstRow != -1) {
			var cntrSeq, cgoSeq;
			var matchSeqs = "";
			for(var searchIdx=fstRow; searchIdx<=sheetObj.LastRow; searchIdx++) {
				cntrSeq = sheetObj.CellValue(searchIdx, "spcl_cntr_seq");
				cgoSeq  = sheetObj.CellValue(searchIdx, "spcl_cgo_seq");
				if(delCntrSeq == cntrSeq && (delCgoSeq == -1 || delCgoSeq == cgoSeq)) matchSeqs += searchIdx+"|";
			}
			var matchSeq = matchSeqs.split("|");
			for (var delIdx=matchSeq.length-2; delIdx>=0; delIdx--){
				sheetObj.RowStatus(matchSeq[delIdx])= "D";
			}
			
			//Pre-Checking Report 결과 초기화
			setPreChkRslt("N");
			
			sheetObj.SelectCell(0, "spcl_cgo_seq");
			
			var isCgoSeq = findMaxCgoRow(sheetObj, delCntrSeq);
			if(isCgoSeq == 0) {	
				clearObjAll(document.form.spcl_cgo_seq, document.form.apro_ref_no, 3);
				setEnableUI(document.form, document.form.spcl_cgo_seq, document.form.apro_ref_no, "disable");
				
				if(delCgoSeq != -1) {
					//if(ComShowCodeConfirm('SCG50002', 'data')) {	//'Do you want to delete {?msg1}?'
						delCntrRow(sheetObjects[0], sheetObj);
					//}
				}
			} else {
				sheetObj.SelectCell(nextCgoRow(sheetObj, delCntrSeq, delCgoSeq), "spcl_cgo_seq");
			}
		}
	}
     
    /**
     * Find next moving cago sequence
     */
 	function nextCgoRow(sheetObj, delCntrSeq, delCgoSeq) {	 		
 		var cntrSeq, cgoSeq, rowStatus;
 		var nextRow = 0;
 		for(var nextIdx=sheetObj.HeaderRows; nextIdx<=sheetObj.LastRow; nextIdx++) {
 			cntrSeq = sheetObj.CellValue(nextIdx, "spcl_cntr_seq");
			cgoSeq  = sheetObj.CellValue(nextIdx, "spcl_cgo_seq");
			rowStatus = sheetObj.RowStatus(nextIdx);
 			if(rowStatus != 'D' && delCntrSeq == cntrSeq) {
 				nextRow = nextIdx;
 			}
 		}
 		
 		return nextRow;
 	}
     
    /**
     * Sheet Cago --> Form Cago
     * param : startObj ==> 시작오브젝트, endObj ==> 종료오브젝트
     */
    function setSheetToFormAll(sheetObj, row, startObj, endObj) {    	 
         try {
         	 var elems   = document.form.elements;
         	 var startYn = false;
         	 var authStsCd = sheetObj.CellValue(row, "org_auth_sts_cd");
         	 for(var i = 0; i < elems.length; i++) {
         		 var elem  = elems[i];
         		 var objNm = elem.name;
                  
                 if(startObj == null || startObj.name == objNm) startYn = true;
                 
                 if(startYn) {                	 
	                 if ((elem.tagName == 'INPUT' || elem.tagName == 'SELECT' || elem.tagName == 'TEXTAREA') && objNm != null && objNm != '') {	                	 
	                	 if(elem.name == 'wgt_ut_cd2') objNm = "wgt_ut_cd";
	                	 var sheetVal = sheetObj.CellText(row, objNm);
	                	 if(sheetVal != null) {
	                		 if(elem.tagName == 'SELECT') {
	                			 for (var idx = 0; idx < elem.length; idx++) {
	                                 if (elem[idx].value == sheetVal) {
	                                	 elem[idx].selected = true;
	                                     break;
	                                 }
	                             }
	                		 } else {
	                			 elem.value = sheetVal;
	                			 
	                			 //SP274 가 적용되는 UN No. 의 경우 Technical Name을 필수항목으로 설정한다.
	                			 if(objNm == 'hzd_desc') {
	                				 var imdgSpclProviNo = sheetObj.CellValue(row, "imdg_spcl_provi_no");
	                				 chgTecNmBox(imdgSpclProviNo, elem);
	                			 }
	                			 if(objNm == 'n4th_imdg_subs_rsk_lbl_cd') {
	                				 fixFlshPointForm(document.form); //Flash Point의 상태변경 결정
	                			 }
	                			 
	                			 if(endObj.name == objNm) {
	                				 var hcdg_flg              = sheetObj.CellText(row, "hcdg_flg");
	                				 var imdg_subs_rsk_lbl_rmk = sheetObj.CellText(row, "imdg_subs_rsk_lbl_rmk");
	                				 //HCDG,Remark(s) Button 색상변경
	                				 chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk);
	                			 }
	                		 }
	                	 }
	                	 if(elem.name == 'grs_wgt' || elem.name == 'net_wgt') ComAddSeparator(elem);
	                 } else if (elem.tagName == 'OBJECT') {
	                	 var sObjId = elem.classid;
	                 	 switch(sObjId){
	 	                 	case CLSID_IBMCOMBO: //IBMultiCombo 경우만
	 	                 		elem.Code2 = sheetObj.CellValue(row, objNm);
	 	                        break;
	 	                 }
	                  }
                 }
                 if(endObj != null && endObj.name == objNm) break;
         	 }
         	 
         	 if(authStsCd == 'Y' || authStsCd == 'N') setEnableUI(document.form, document.form.imdg_clss_cd, document.form.apro_ref_no, "readonly");
         	 
         } catch(err) { ComFuncErrMsg(err.message); }
    }
     
    /**
     * Form Cago --> Sheet Cago
     * param : sheetObj ==> 시트오브젝트, row ==> 선택한 Row, startObj ==> 시작오브젝트, endObj ==> 종료오브젝트
     * see : 1. Cargo Seq. Combo 변경시 , CNTR Seq. Row 변경시 , Cargo Row Add시 , 
     */
    function setFormToSheetAll(sheetObj, row, startObj, endObj) {    	 
    	try {
    		var elems   = document.form.elements;
          	var startYn = false;
          	for(var i = 0; i < elems.length; i++) {
          		var elem = elems[i];
                   
                if(startObj == null || startObj.name == elem.name) startYn = true;
                
                if(startYn && row > 0) {
	                if (elem.tagName == 'INPUT' || elem.tagName == 'SELECT' || elem.tagName == 'TEXTAREA') {
	                	if(elem.tagName == 'SELECT') {
	                		sheetObj.CellValue2(row, elem.name) = elem[elem.selectedIndex].value;
	                	} else {
	                		sheetObj.CellValue2(row, elem.name) = elem.value;
	                	}
	                } else if (elem.tagName == 'OBJECT') {
	                 	var sObjId = elem.classid;
	                  	switch(sObjId){
	  	                	case CLSID_IBMCOMBO: //IBMultiCombo 경우만
	  	                 		sheetObj.CellValue2(row, elem.name) = elem.Code;
	  	                        break;
	  	                }
	                 }
                }
                   
                if(endObj != null && endObj.name == elem.name) break;
          	}
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * Cago Sequence 구성
     * param : sheetObj1 ==> 시트오브젝트, sheetObj2 ==> 시트오브젝트
     */
    function setCgoSeq(sheetObj1, sheetObj2) {    
    	var cgoCombo  = comboObjects[2];
    	var itemCdIdx = 0;
    	var itemNmIdx = 0;
    	var aproCt    = 0;
    	var totalCt   = 0;
    	
    	cgoCombo.RemoveAll();
    	
    	var comboItemsCd = new Array();
    	var comboItemsNm = new Array();
    	if(sheetObj1.SelectRow != 0) {
	    	var selCntrSeq = sheetObj1.CellValue(sheetObj1.SelectRow, "spcl_cntr_seq");
	    	var fstRow = sheetObj2.FindText("spcl_cntr_seq", selCntrSeq, 0, -1, true);
			
			if(fstRow != -1) {
				var cntrSeq, cgoSeq, authStsCd, rowStatus;
				for(var startIdx=fstRow, i=0; startIdx<=sheetObj2.LastRow; startIdx++) {
					cntrSeq   = sheetObj2.CellValue(startIdx, "spcl_cntr_seq");
					cgoSeq    = sheetObj2.CellValue(startIdx, "spcl_cgo_seq");
					authStsCd = sheetObj2.CellValue(startIdx, "auth_sts_cd");
					rowStatus = sheetObj2.RowStatus(startIdx);
					if(rowStatus != 'D' && selCntrSeq == cntrSeq) {
						comboItemsCd[itemCdIdx++] = cgoSeq;
						comboItemsNm[itemNmIdx++] = cgoSeq + " - " + authStsCd;
						totalCt++;
						if(authStsCd == 'Y' || authStsCd == 'N') aproCt++;
					}
				}
			}
    	}
    	
    	setComboProperty(cgoCombo, comboItemsCd.length+1, "50|20|");
    	
    	for(itemCdIdx=0; itemCdIdx<comboItemsCd.length; itemCdIdx++) {
    		cgoCombo.InsertItem(itemCdIdx, comboItemsNm[itemCdIdx]+"| |"+comboItemsCd[itemCdIdx], comboItemsCd[itemCdIdx]);
    	}
    	
    	ComSetObjValue(document.form.cntr_cgo_seq_sum, totalCt);

		return i;
    }
    
    /**
     * Disable/Enable Cago UI
     * param : formObj ==> 폼오브젝트, startObj ==> 시작오브젝트, endObj ==> 종료오브젝트, type ==> 유형
     */
    function setEnableUI(formObj, startObj, endObj, type) {    	 
          try {
          	 var elems   = document.form.elements;
          	 var startYn = false;
          	 for(var i = 0; i < elems.length; i++) {
          		 var elem = elems[i];
                   
                  if(startObj == null || startObj.name == elem.name) startYn = true;
                  
                  if(startYn) {
 	                 if (elem.tagName == 'INPUT' || elem.tagName == 'SELECT' || elem.tagName == 'TEXTAREA') {
 	                	 if(type == 'disable' || type == 'readonly') {
 	                		 if(elem.tagName == 'TEXTAREA') {
 	                			 elem.setAttribute("readOnly", "true");
 	                		 } else {
 	                			elem.setAttribute("disabled", "true");
 	                		 }
 	                	 } else if(type == 'enable') {
 	                		 if(elem.tagName == 'TEXTAREA') {
 	                			 elem.removeAttribute("readOnly");
	                		 } else {
	                			 elem.removeAttribute("disabled");
	                		 }
 	                	 }
 	                 } else if (elem.tagName == 'OBJECT') {
 	                	 var sObjId = elem.classid;
 	                 	 switch(sObjId){
 	 	                 	case CLSID_IBMCOMBO: //IBMultiCombo 경우만
 	 	                 		if(type == 'disable' || type == 'readonly') elem.Enable = false;
 	 	                 		else if(type == 'enable') elem.Enable = true; 
 	 	                        break;
 	 	                 }
 	                  }
                  }
                  if(endObj != null && endObj.name == elem.name) break;
          	 }
          	 
          	 if(type == 'disable' || type == 'readonly') {
          		document.getElementById("btn_calendar").style.visibility = "hidden";
          		document.getElementById("btn_Un_No").style.visibility = "hidden";
          	 } else if(type == 'enable') {
          		document.getElementById("btn_calendar").style.visibility = "";
          		document.getElementById("btn_Un_No").style.visibility = "";
          	 }
          	 
          	 if(endObj.name == 'apro_ref_no') {
	          	 var btnObjs = document.getElementsByTagName("td");
	          	 var btnName;
	          	 startYn = false;
	          	 for(var i = 0; i < btnObjs.length; i++) {
	         		 var btnObj = btnObjs[i];
	         		 btnName = btnObj.name;
	         		 if (btnObj.className == 'btn2' || btnObj.className == 'btn2_1') {
	         			 if(btnName == 'btn2_UN_Information' || btnName == 'no_btn2_UN_Information') startYn = true;
	         			 
	         			 if(startYn) {
	         				 if(btnName != 'btn3_Row_Add' && btnName != 'no_btn3_Row_Add') {
	         					 
	         					 if(btnName.indexOf("no_") != -1) {
	         						btnName = ComTrimAll(btnName, "no_");
	         					 }
	         					 
			         			 if(type == 'disable') {
			         				 ComBtnDisable(btnName);
			         				 
			         				 if(btnName == 'btn2_Pre_Checking_Report' || btnName == 'no_btn2_Pre_Checking_Report') btnObj.style.color = '#c0c0c0';
			         			 } else if(type == 'enable') {
			                		 if(preConds.pop_mode == 'view' || preConds.pop_mode == 'noedit') {
			                			 if(btnName != 'btn3_Row_Copy' && btnName != 'no_btn3_Row_Copy' && btnName != 'btn3_Row_Delete' && btnName != 'no_btn3_Row_Delete') {
			                				 ComBtnEnable(btnName);
			                			 }
			                		 } else {
			                			 ComBtnEnable(btnName);
			                		 }
			                		 if(btnName == 'btn2_Pre_Checking_Report' || btnName == 'no_btn2_Pre_Checking_Report') btnObj.style.color = '#737373';
			                	 }
	         				 }
	         			 }
	         		 }
	         		 
	         		 if(btnName == 'btn3_Row_Delete' || btnName == 'no_btn3_Row_Delete') break;
	          	 }
          	 }          	
          } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * Set Precondition
     * param : sheetObj ==> 시트오브젝트
     */
    function setPreCondition(sheetObj) {
    	var elems   = document.form.elements;
    	var preCondEle;
    	for(var i = 0; i < elems.length; i++) {
      		var elem = elems[i];
            
      		preCondEle = eval("preConds."+elem.name);
      		if (elem.tagName == 'INPUT') {      			
            	if(preCondEle != null) elem.value = preCondEle;
            } else if (elem.tagName == 'OBJECT') {
             	var sObjId = elem.classid;
              	switch(sObjId){
                	case CLSID_IBMCOMBO: 
                		if(preCondEle != null) elem.Code2 = preCondEle;
                        break;
	            }
            }
      		if(elem.name == 'skd_dir_cd') {
      			if(elem.value != '') doActionIBCombo(sheetObj, comboObjects[0], 1, '');	//POL 조회
      		} else if(elem.name == 'pol_cd') {
      			if(preCondEle != '') doActionIBCombo(sheetObj, comboObjects[1], 2, elem.Code);	//POD 조회
      		} else if(elem.name == 'pod_cd') break;
      	}
    	
    	if(preConds.spcl_cgo_rqst_seq != '') {
    		ComSetObjValue(document.form.ibflag, "U");
    		
    		setEnableUI(document.form, document.form.cgo_opr_cd, document.form.skd_dir_cd, 'readonly');
    		document.getElementById("btn_Carrier").style.visibility = "hidden";
    		document.getElementById("btn_VVDpop").style.visibility = "hidden";
    	}
    	
    	return true;
    }
     
    /**
     * Find first row of cago related with container
     * param : sheetObj1 ==> 시트오브젝트, sheet1Row ==> 선택한 Row, sheetObj2 ==> 시트오브젝트
     */
    function findFirstRowCgo(sheetObj1, sheet1Row, sheetObj2) {
    	var cntrSeq = sheetObj1.CellValue(sheet1Row, "spcl_cntr_seq");
    	var fstRow  = sheetObj2.FindText("spcl_cntr_seq", cntrSeq, 0, -1, false);
    	
    	for(var findIdx=fstRow; findIdx<=sheetObj2.LastRow; findIdx++) {
    		if(sheetObj2.RowStatus(findIdx) != 'D') {
    			fstRow = findIdx;
    			break;
    		}
    	}
    	
		if(fstRow != -1) sheetObj2.SelectCell(fstRow, "spcl_cgo_seq");
    }
     
    /**
     * 버튼 비/활성
     * param : what ==> 활성/비활성여부
     */
    function btnEnabled(what, how) {
    	 
    	if(how) {
    		if(preConds.pop_mode != 'view' || preConds.pop_mode == 'noedit') {
	    		ComBtnEnable("btn1_Save");
	    		ComBtnEnable("btn2_Add");
	    		ComBtnEnable("btn2_Delete");
	    		ComBtnEnable("btn2_Copy");
	    		ComBtnEnable("btn3_Row_Add");
	    		ComBtnEnable("btn3_Row_Copy");
	    		ComBtnEnable("btn3_Row_Delete");   
    		}		
    	} else {
    		if(what == 'view' || preConds.pop_mode == 'noedit') {
    			ComBtnDisable("btn1_New");
    			ComBtnDisable("btn1_Save");
    			ComBtnDisable("btn2_Add");
    		}
	    	ComBtnDisable("btn2_Delete");
	    	ComBtnDisable("btn2_Copy");
	    	ComBtnDisable("btn3_Row_Add");
	    	ComBtnDisable("btn3_Row_Copy");
	    	ComBtnDisable("btn3_Row_Delete");	    	
    	}
    }
     
    /**
     * Fix the drop-height of combo 
     */
    function setComboProperty(obj, rlstCt, width) {
    	if(rlstCt <= 10) {
    		obj.DropHeight = 19*rlstCt;
    		obj.SetColWidth(width);
   		} else {
   			obj.DropHeight = 19*10;
   		}
    }
     
    /**
 	 * Copy Cargo
 	 */
 	function copyCargo(sheetObj1, sheetObj2, row) {
 		addCgoRow(sheetObj1, sheetObj2);
 		for(var cgoIdx=sheetObj2.SaveNameCol("cntr_tpsz_cd")+1; cgoIdx<=sheetObj2.SaveNameCol("diff_rmk"); cgoIdx++) {
 			sheetObj2.CellValue2(sheetObj2.SelectRow, cgoIdx) = sheetObj2.CellValue(row, cgoIdx);
 		}
 		sheetObj2.SelectCell(sheetObj2.SelectRow, "spcl_cntr_seq");
 	}
 	 
 	/**
  	 * Copy Form's information for Booking
  	 */
  	function setOrgFormInfo(formObj) {
  		orgFormObj = new Array();
  		
  		orgFormObj[0]  = ComGetObjValue(formObj.ibflag);
  		orgFormObj[1] = ComGetObjValue(formObj.spcl_cgo_rqst_seq);
	   	orgFormObj[2]  = ComGetObjValue(formObj.vsl_cd);
	   	orgFormObj[3]  = ComGetObjValue(formObj.skd_voy_no);
	   	orgFormObj[4]  = ComGetObjValue(formObj.skd_dir_cd);
	   	orgFormObj[5]  = ComGetObjValue(formObj.slan_cd);
	   	orgFormObj[6]  = ComGetObjValue(formObj.bkg_ref_no);
	   	orgFormObj[7]  = ComGetObjValue(formObj.cgo_opr_cd);
	   	orgFormObj[8]  = ComGetObjValue(formObj.pol_cd);
	   	orgFormObj[9]  = ComGetObjValue(formObj.eta_dt);
	   	orgFormObj[10]  = ComGetObjValue(formObj.pod_cd);
	   	orgFormObj[11] = ComGetObjValue(formObj.crr_cd); 
  	}
    
//------------------------------------------------------------------------------//
/* 일반 함수 -- 팝업 액션 과 리턴함수 */    
//------------------------------------------------------------------------------//    
    
    /**
     * 팝업 Action
     */
    function onPopupClick(sheetObj, formObj, srcName, srcType){
    	var imdg_un_no = ComGetObjValue(formObj.imdg_un_no);
    	
    	if (srcType == "Carrier") {
    		ComOpenPopup('/hanjin/COM_ENS_0N1.do?crr_cd='+ComGetObjValue(document.form.cgo_opr_cd), 423, 460, "setCallBackCarrier", "0,0,1,1,1", true);
   	 	} else if (srcType == "VVD") {		
			var vsl_cd = ComGetObjValue(document.form.vsl_cd);
        	var sUrl = "";
        	
        	if(vsl_cd == ""){
        		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
        		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
        	}else{
        		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
        		ComOpenPopup(sUrl, 305, 420, "setCallBackVVD", "0,0", true);
        	}
   	 	} else if(srcType == "UnNo") {
   	 		//Reset items related to Un No.
   	 		resetForUnNo(formObj);
   	 		
			//var paramStr = "";
			//if(imdg_un_no.length == 4 && !isNaN(imdg_un_no)) {
			//	paramStr = "&imdg_un_no="+imdg_un_no;
			//}
	    	//var sUrl = "/hanjin/VOP_SCG_0002Pop.do?pop_yn=Y"+paramStr;
			//ComOpenPopup(sUrl, 1000, 648, "setCallBackUnNo", "0,0,1,1,1,1,1,1,1,1", true);
			ComOpenPopup("ESM_BKG_0204.do?f_cmd=&"+FormQueryString(formObj), 913, 440, "setCallBackUnNo2", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
   	 	} else if(srcType == "Restrictions") {
   	 		if(imdg_un_no == '') ComAlertFocus(formObj.imdg_un_no, "'" + formObj.imdg_un_no.getAttribute("caption") + "' " + Msg_Required);
   	 		else {
   	 			var sParam = Array();
   	 			sParam[0]  = "imdg_un_no="     + ComGetObjValue(formObj.imdg_un_no);
   	 			sParam[1]  = "imdg_un_no_seq=" + ComGetObjValue(formObj.imdg_un_no_seq);
   	 			sParam[2]  = "imdg_clss_cd="   + ComGetObjValue(formObj.imdg_clss_cd);
   	 			sParam[3]  = "pol_cd="         + ComGetObjValue(formObj.pol_cd);
   	 			sParam[4]  = "pod_cd="         + ComGetObjValue(formObj.pod_cd);
   	 			sParam[5]  = "slan_cd="        + ComGetObjValue(formObj.slan_cd);
   	 			sParam[6]  = "bkg_no=";
   	 			sParam[7]  = "bkg_ref_no="     + ComGetObjValue(formObj.bkg_ref_no);
   	 			sParam[8]  = "vsl_cd="         + ComGetObjValue(formObj.vsl_cd);
   	 			sParam[9]  = "skd_voy_no="     + ComGetObjValue(formObj.skd_voy_no);   
   	 			sParam[10] = "skd_dir_cd="     + ComGetObjValue(formObj.skd_dir_cd); 
   	 			
   	 			ComOpenWindowCenter("VOP_SCG_0021.do?"+sParam.join("&"), "winRestrictions", "1023", "663", true);
   	 		}
   	 	} else if(srcType == "PreChecking") {
   	 		onPreChkPopup(sheetObj, formObj, "R",  "940", "965");
   	 	} else if(srcType == "UnInformation") {
   	 		if(imdg_un_no == '') ComAlertFocus(formObj.imdg_un_no, "'" + formObj.imdg_un_no.getAttribute("caption") + "' " + Msg_Required);
	 		else ComOpenWindowCenter("VOP_SCG_0001Pop.do?pgmNo=VOP_SCG_0001&pop_mode=Y&"+FormQueryString(formObj), "winUnInformation", "1025", "630", true);
	 	} else if(srcType == "Mail") {
	 		if(ComGetObjValue(formObj.ibflag) == 'I') {
	  			//ComShowCodeMessage("SCG50018");	//'Please use after Retrieve.'
	  			return;
	  		} else {  		  	
			  	var crr_cd                 = ComGetObjValue(formObj.crr_cd);
			  	var bkg_ref_no             = ComGetObjValue(formObj.bkg_ref_no);
			  	var spcl_cgo_rqst_seq      = ComGetObjValue(formObj.spcl_cgo_rqst_seq);
			  	var rgn_shp_opr_cd         = ComGetObjValue(formObj.rgn_shp_opr_cd);
			  	var scg_flg                = "DG";
			  	var send_type              = "P0";
			  	
			  	mailObj.crr_cd            = crr_cd;
			  	mailObj.bkg_ref_no        = bkg_ref_no;
			  	mailObj.spcl_cgo_rqst_seq = spcl_cgo_rqst_seq;
			  	mailObj.rgn_shp_opr_cd    = rgn_shp_opr_cd;
			  	mailObj.scg_flg           = scg_flg;
			  	mailObj.send_type         = send_type;
			  	mailObj.user_id           = user_id;
			  	
			  	ComScgSendMail(sheetObj, formObj, mailObj);
	  		}
	 	} else if(srcType == "Remark") {
	 		ComOpenWindowCenter("VOP_SCG_0757.do", "remark", "500", "320", true);
	 	} else if(srcType == "OtherEmerInfo") {
	 		//ComOpenWindowCenter("VOP_SCG_0770.do", "otherEmerInfo", "505", "195", true);
	 		
	 		var sParam = "";
	 		sParam += "imdg_emer_no="+ComGetObjValue(formObj.ems_no);
			sParam += "&emer_rspn_gid_no="+ComGetObjValue(formObj.emer_rspn_gid_no);
			sParam += "&emer_rspn_gid_chr_no="+ComGetObjValue(formObj.emer_rspn_gid_chr_no);
			sParam += "&ctrl_temp_ctnt="+ComGetObjValue(formObj.ctrl_temp_ctnt);
			sParam += "&emer_temp_ctnt="+ComGetObjValue(formObj.emer_temp_ctnt);
	 		ComOpenPopup("ESM_BKG_0770.do?"+sParam, 505, 215, "setOtherEmergencyInformation2", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0770");
	 	} else if(srcType == "DgPkgQtyType") {
	 		//ComOpenWindowCenter("VOP_SCG_0206.do", "dgPkgQtyType", "710", "520", true);
	 		
	 		var sParam = "";
	 		sParam += "in_imdg_pck_cd1="+ComGetObjValue(formObj.in_n1st_imdg_pck_cd);
			sParam += "&in_imdg_pck_cd2="+ComGetObjValue(formObj.in_n2nd_imdg_pck_cd);
			
			sParam += "&intmd_imdg_pck_cd1="+ComGetObjValue(formObj.intmd_n1st_imdg_pck_cd);
			sParam += "&intmd_imdg_pck_cd2="+ComGetObjValue(formObj.intmd_n2nd_imdg_pck_cd);
			
			sParam += "&out_imdg_pck_cd1="+ComGetObjValue(formObj.out_n1st_imdg_pck_cd);
			sParam += "&out_imdg_pck_cd2="+ComGetObjValue(formObj.out_n2nd_imdg_pck_cd);
			
			sParam += "&in_imdg_pck_desc1="+ComGetObjValue(formObj.in_n1st_imdg_pck_desc);
			sParam += "&in_imdg_pck_desc2="+ComGetObjValue(formObj.in_n2nd_imdg_pck_desc);
			
			sParam += "&intmd_imdg_pck_desc1="+ComGetObjValue(formObj.intmd_n1st_imdg_pck_desc);
			sParam += "&intmd_imdg_pck_desc2="+ComGetObjValue(formObj.intmd_n2nd_imdg_pck_desc);
			
			sParam += "&out_imdg_pck_desc1="+ComGetObjValue(formObj.out_n1st_imdg_pck_desc);
			sParam += "&out_imdg_pck_desc2="+ComGetObjValue(formObj.out_n2nd_imdg_pck_desc);
			
			sParam += "&in_imdg_pck_qty1="+ComGetObjValue(formObj.in_n1st_imdg_pck_qty);
			sParam += "&in_imdg_pck_qty2="+ComGetObjValue(formObj.in_n2nd_imdg_pck_qty);
			
			sParam += "&intmd_imdg_pck_qty1="+ComGetObjValue(formObj.intmd_n1st_imdg_pck_qty);
			sParam += "&intmd_imdg_pck_qty2="+ComGetObjValue(formObj.intmd_n2nd_imdg_pck_qty);
			
			sParam += "&out_imdg_pck_qty1="+ComGetObjValue(formObj.out_n1st_imdg_pck_qty);
			sParam += "&out_imdg_pck_qty2="+ComGetObjValue(formObj.out_n2nd_imdg_pck_qty);
			
			sParam += "&hcdg_intmd_bc_rstr_desc="+ComGetObjValue(formObj.hcdg_intmd_bc_rstr_desc);
			sParam += "&hcdg_pck_rstr_desc="+ComGetObjValue(formObj.hcdg_pck_rstr_desc);
			sParam += "&hcdg_tnk_rstr_desc="+ComGetObjValue(formObj.hcdg_tnk_rstr_desc);
			
			var imdg_lmt_qty_meas_ut_cd = ComGetObjValue(formObj.imdg_lmt_qty_meas_ut_cd);
	   		if(imdg_lmt_qty_meas_ut_cd == 'mlg') imdg_lmt_qty_meas_ut_cd = "ml or g";
	   		else if(imdg_lmt_qty_meas_ut_cd == 'lkg') imdg_lmt_qty_meas_ut_cd = "l or kg";
			sParam += "&ltd_qty="+ComGetObjValue(formObj.imdg_lmt_qty)+" "+imdg_lmt_qty_meas_ut_cd;
			
			sParam += "&imdg_expt_qty_cd="+ComGetObjValue(formObj.imdg_expt_qty_cd);
			
			sParam += "&grs_wgt="+ComGetObjValue(formObj.grs_wgt);
			sParam += "&net_wgt="+ComGetObjValue(formObj.net_wgt);
			sParam += "&grs_capa_qty="+ComGetObjValue(formObj.grs_capa_qty);
		
			
			ComOpenPopup("ESM_BKG_0206.do?"+sParam, 710, 545, "setDgPkgQtyType2", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0206");
	 	} else if(srcType == "CopyCntr") {
	 		ComOpenWindowCenter("VOP_SCG_0735.do", "copyCntr", "422", "522", true);
	 	}
    }

    /**
     * Pre-Checking Pop-Up
     */
    function onPreChkPopup(sheetObj, formObj, popType,  width, height) {
    	//Form values --> Sheet
		setFormToSheetAll(sheetObj, sheetObj.SelectRow, formObj.imdg_clss_cd, formObj.apro_ref_no);
		
    	formObj.f_cmd.value = SEARCH;
    	var returnVal = ComOpenWindowCenter("VOP_SCG_0069.do?pop_type="+popType+"&"+FormQueryString(formObj), "winPreChecking", 940, 910, true);
    	
    	return returnVal;
    }

    /**
     * Making parameter of Pre-Checking
     */
    function makePreChkParam() {
    	var sheetObj2 = sheetObjects[1];		
		var formObj   = document.form;
		
		var sParam = "";
		for(var i=sheetObj2.HeaderRows; i<=sheetObj2.LastRow; i++) {
			if(sheetObj2.RowStatus(i) != 'D') {
				for(var j=0; j<=sheetObj2.LastCol; j++) {
					sParam += sheetObj2.ColSaveName(j)+"="+sheetObj2.CellValue(i, j)+"&";
				}
			}
		}
		
		sParam += "rgn_shp_opr_cd="+ComGetObjValue(formObj.rgn_shp_opr_cd);
		sParam += "&cgo_opr_cd="+ComGetObjValue(formObj.cgo_opr_cd);
		sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_ref_no);
		sParam += "&vsl_cd="+ComGetObjValue(formObj.vsl_cd);
		sParam += "&skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
		sParam += "&skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
		sParam += "&crr_cd="+ComGetObjValue(formObj.crr_cd);
		sParam += "&slan_cd="+ComGetObjValue(formObj.slan_cd);
		sParam += "&pol_cd="+ComGetObjValue(formObj.pol_cd);
		sParam += "&pod_cd="+ComGetObjValue(formObj.pod_cd);
		
		return sParam;
    }

    /**
   	 * BKG Company Help (Pop-Up)에서 받은 데이타 세팅.<br>
   	 * @param {arry} rtnObjs
   	 */
   	function setCallBackCarrier(rtnObjs) {
   		if(rtnObjs){
 			var rtnDatas = rtnObjs[0];
 			if(rtnDatas){
 				if(rtnDatas.length > 0){
 					ComSetObjValue(document.form.cgo_opr_cd, rtnDatas[3]);
 					ComSetFocus(document.form.bkg_no);
 				}
 			}
     	}
   	} 
     
    /**
   	 * VSL/VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
   	 * @param {arry} rtnObjs
   	 */
   	function setCallBackVSL(rtnObjs) {
   		if(rtnObjs){
 			var rtnDatas = rtnObjs[0];
 			if(rtnDatas){
 				if(rtnDatas.length > 0){
 					ComSetObjValue(document.form.vsl_cd, rtnDatas[1]);
 					ComSetObjValue(document.form.crr_cd, rtnDatas[3]);
 					ComSetFocus(document.form.skd_voy_no);
 				}
 			}
     	}
   	} 
   	
    /**
   	 * (Sheet용)VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
   	 * @param {arry} obj
   	 */
   	function setCallBackVVD(obj) {
   		if(obj){
 			var rtnDatas = obj[0];
 			if(rtnDatas){
 				if(rtnDatas.length > 0){
 					ComSetObjValue(document.form.skd_voy_no, rtnDatas[2]);
 					ComSetObjValue(document.form.skd_dir_cd, rtnDatas[3]);
 					
 					searchVVDCheck();	//Lane 조회
 					
 					doActionIBCombo(sheetObjects[1], comboObjects[0], 1, '');	//POL 조회
 				}
 			}
     	}
   	}
   	 
   	/**
 	 * UN Number 팝업의 선택항목 내리기 - SCG용
 	 */
 	function setCallBackUnNo(aryPopupData) {
 		var formObj = document.form;
 		
 		ComSetObjValue(formObj.imdg_un_no, 			aryPopupData[0][2]);
 		ComSetObjValue(formObj.imdg_un_no_seq, 		aryPopupData[0][3]);
 		ComSetObjValue(formObj.imdg_clss_cd, 		aryPopupData[0][4]);
 		ComSetObjValue(formObj.imdg_comp_grp_cd, 	aryPopupData[0][5]);
 		ComSetObjValue(formObj.prp_shp_nm, 			aryPopupData[0][6]);
 		ComSetObjValue(formObj.hzd_desc, 			aryPopupData[0][7]);
 		ComSetObjValue(formObj.imdg_pck_grp_cd, 	aryPopupData[0][9]);
 		ComSetObjValue(formObj.psa_no, 				aryPopupData[0][14]);
 		
 		ComSetObjValue(formObj.hcdg_pck_rstr_desc, 		aryPopupData[0][17]);
 		ComSetObjValue(formObj.hcdg_intmd_bc_rstr_desc, aryPopupData[0][18]);
 		ComSetObjValue(formObj.hcdg_tnk_rstr_desc, 		aryPopupData[0][19]);
 		ComSetObjValue(formObj.imdg_lmt_qty, 		    aryPopupData[0][11]);
 		ComSetObjValue(formObj.imdg_expt_qty_cd, 		aryPopupData[0][12]);
 		
 		ComSetObjValue(formObj.ems_no, 		            aryPopupData[0][20]);
 		ComSetObjValue(formObj.ctrl_temp_ctnt, 		    aryPopupData[0][21]);
 		ComSetObjValue(formObj.emer_rspn_gid_no, 		aryPopupData[0][22]);
 		ComSetObjValue(formObj.emer_rspn_gid_chr_no,    aryPopupData[0][23]);
 		ComSetObjValue(formObj.emer_temp_ctnt, 		    aryPopupData[0][24]);
 		ComSetObjValue(formObj.imdg_lmt_qty_meas_ut_cd, aryPopupData[0][25]);
 		
 		ComSetObjValue(formObj.hcdg_flg,                aryPopupData[0][14]);
 		ComSetObjValue(formObj.imdg_subs_rsk_lbl_rmk,   aryPopupData[0][13]);
 		
 		var imdg_subs_rsk_lbl_cd = aryPopupData[0][8];
 		if(imdg_subs_rsk_lbl_cd != null) {
 			imdg_subs_rsk_lbl_cd = imdg_subs_rsk_lbl_cd.split("|");
 			
 			var formItems = new Array();
 			formItems[0] = "n1st";
 			formItems[1] = "n2nd";
 			formItems[2] = "n3rd";
 			formItems[3] = "n4th";
 			var subsRsk  = "";
	 		for(var i=0; i<4; i++) {
	 			if(i < imdg_subs_rsk_lbl_cd.length) subsRsk = imdg_subs_rsk_lbl_cd[i];
	 			else subsRsk = "";
	 			
	 			ComSetObjValue(eval("document.form."+formItems[i]+"_imdg_subs_rsk_lbl_cd"), subsRsk);
	 		}
 		}
 		
 		//Marin Pollutant 값 셋팅
 		var imdg_mrn_polut_cd   = aryPopupData[0][26]=='P'?'Y':'N';
 		document.all.mrn_polut_flg.Code2 = imdg_mrn_polut_cd;
 		
 		var hcdg_flg              = ComGetObjValue(formObj.hcdg_flg);
 		var imdg_subs_rsk_lbl_rmk = ComGetObjValue(formObj.imdg_subs_rsk_lbl_rmk);
 		
 		//HCDG/Remark(s) Button 색상변경
 		chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk);
 		
 		//SP274 가 적용되는 UN No. 의 경우 Technical Name을 필수항목으로 설정한다.
 		var imdg_spcl_provi_no = aryPopupData[0][16]; 		
 		var proviNos; 		
 		var itemObj = document.getElementById("hzd_desc"); 		
 		var imdgSpclProviNo = ""; 	
 		if(imdg_spcl_provi_no.length > 0) {
 			proviNos = imdg_spcl_provi_no.split("|");
 			if(proviNos.length > 0) {
		 		for(var pIdx=0; pIdx<proviNos.length; pIdx++) {
		 			if(proviNos[pIdx] == '274') imdgSpclProviNo = proviNos[pIdx];
		 		}
 			}
 		}  		
 		chgTecNmBox(imdgSpclProviNo, itemObj);
 		ComSetObjValue(formObj.imdg_spcl_provi_no, imdgSpclProviNo);
 		
 		//Flash Point의 입력값 초기화
 		ComSetObjValue(formObj.flsh_pnt_cdo_temp, "");	
 		//Flash Point의 상태변경 결정
 		fixFlshPointForm(formObj); 
 		
 		//Pre-Checking Report 결과 초기화
		setPreChkRslt("N");
 	}
 	 
 	/**
  	 * UN Number 팝업의 선택항목 내리기 - BKG용
  	 */
  	function setCallBackUnNo2(aryPopupData) {
  		var formObj = document.form;
  		
  		ComSetObjValue(formObj.imdg_un_no, 			aryPopupData[0][2]);
  		ComSetObjValue(formObj.imdg_un_no_seq, 		aryPopupData[0][3]);
  		ComSetObjValue(formObj.imdg_clss_cd, 		aryPopupData[0][4]);
  		ComSetObjValue(formObj.imdg_comp_grp_cd, 	aryPopupData[0][5]);
  		ComSetObjValue(formObj.prp_shp_nm, 			aryPopupData[0][7]);
  		ComSetObjValue(formObj.hzd_desc, 			aryPopupData[0][8]);
  		var imdg_pck_grp_cd = aryPopupData[0][6];
  		if(imdg_pck_grp_cd == '1') imdg_pck_grp_cd = "I";
  		else if(imdg_pck_grp_cd == '2') imdg_pck_grp_cd = "II";
  		else if(imdg_pck_grp_cd == '3') imdg_pck_grp_cd = "III";
  		ComSetObjValue(formObj.imdg_pck_grp_cd, 	imdg_pck_grp_cd);
  		ComSetObjValue(formObj.psa_no, 				aryPopupData[0][14]);
  		
  		ComSetObjValue(formObj.hcdg_pck_rstr_desc, 		aryPopupData[0][26]);
  		ComSetObjValue(formObj.hcdg_intmd_bc_rstr_desc, aryPopupData[0][27]);
  		ComSetObjValue(formObj.hcdg_tnk_rstr_desc, 		aryPopupData[0][28]);
  		ComSetObjValue(formObj.imdg_lmt_qty, 		    aryPopupData[0][19]);
  		ComSetObjValue(formObj.imdg_expt_qty_cd, 		aryPopupData[0][20]);
  		
  		ComSetObjValue(formObj.ems_no, 		            aryPopupData[0][16]);
  		ComSetObjValue(formObj.ctrl_temp_ctnt, 		    aryPopupData[0][29]);
  		ComSetObjValue(formObj.emer_rspn_gid_no, 		aryPopupData[0][17]);
  		ComSetObjValue(formObj.emer_rspn_gid_chr_no,    aryPopupData[0][18]);
  		ComSetObjValue(formObj.emer_temp_ctnt, 		    aryPopupData[0][30]);
  		ComSetObjValue(formObj.imdg_lmt_qty_meas_ut_cd, aryPopupData[0][31]);
  		
  		ComSetObjValue(formObj.hcdg_flg,                aryPopupData[0][21]);
 		//ComSetObjValue(formObj.imdg_subs_rsk_lbl_rmk,   aryPopupData[0][8]);
  		
  		var imdg_subs_rsk_lbl_cd = aryPopupData[0][9]+"|"+aryPopupData[0][10]+"|"+aryPopupData[0][11]+"|"+aryPopupData[0][12];
  		if(imdg_subs_rsk_lbl_cd != null) {
  			imdg_subs_rsk_lbl_cd = imdg_subs_rsk_lbl_cd.split("|");
  			
  			var formItems = new Array();
  			formItems[0] = "n1st";
  			formItems[1] = "n2nd";
  			formItems[2] = "n3rd";
  			formItems[3] = "n4th";
  			var subsRsk  = "";
 	 		for(var i=0; i<4; i++) {
 	 			if(i < imdg_subs_rsk_lbl_cd.length) subsRsk = imdg_subs_rsk_lbl_cd[i];
 	 			else subsRsk = "";
 	 			
 	 			ComSetObjValue(eval("document.form."+formItems[i]+"_imdg_subs_rsk_lbl_cd"), subsRsk);
 	 		}
  		}
  		
  		//Marin Pollutant 값 셋팅
 		var imdg_mrn_polut_cd   = aryPopupData[0][15]=='P'?'Y':'N';
 		document.all.mrn_polut_flg.Code2 = imdg_mrn_polut_cd;
  		
 		var hcdg_flg              = ComGetObjValue(formObj.hcdg_flg);
 		var imdg_subs_rsk_lbl_rmk = ComGetObjValue(formObj.imdg_subs_rsk_lbl_rmk);
 		
 		//HCDG/Remark(s) Button 색상변경
 		chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk);
  		
  		//SP274 가 적용되는 UN No. 의 경우 Technical Name을 필수항목으로 설정한다.
  		var imdg_spcl_provi_no = aryPopupData[0][23]; 		
  		var proviNos; 		
  		var itemObj = document.getElementById("hzd_desc"); 		
  		var imdgSpclProviNo = ""; 	
  		if(imdg_spcl_provi_no.length > 0) {
  			proviNos = imdg_spcl_provi_no.split("|");
  			if(proviNos.length > 0) {
 		 		for(var pIdx=0; pIdx<proviNos.length; pIdx++) {
 		 			if(proviNos[pIdx] == '274') imdgSpclProviNo = proviNos[pIdx];
 		 		}
  			}
  		}
  		chgTecNmBox(imdgSpclProviNo, itemObj);
  		ComSetObjValue(formObj.imdg_spcl_provi_no, imdgSpclProviNo);
  		
  		//Flash Point의 입력값 초기화
 		ComSetObjValue(formObj.flsh_pnt_cdo_temp, "");	
  		//Flash Point의 상태변경 결정
  		fixFlshPointForm(formObj); 
  		
  		//Pre-Checking Report 결과 초기화
 		setPreChkRslt("N");
  	}
 	 
 	/**
 	 * 팝업 IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다.
 	 **/
 	function setFileUpload(aryPopupData) {
 		var sheetObj  = sheetObjects[2];
 		var uploadObj = uploadObjects[0];
 		
 		uploadObj.Files = "";					//먼저기존파일을 모두 지운후 추가함
 		sheetObj.removeAll();
 		
 		var file_cnt = 0;
 		for (var rowIdx=0; rowIdx<aryPopupData.length; rowIdx++){ 
 			var fileSetYn = aryPopupData[rowIdx][2];	//신규추가 파일여부 확인
 			var ibFlag    = aryPopupData[rowIdx][0];	//Row 상태
 			
 			//파일 경로 가져오기
 			if(fileSetYn == 'Y') {
 				var sFile = aryPopupData[rowIdx][3];
 				if (sFile=="") ComShowCodeMessage('SCG50004', 'Data');	//'{?msg1} is not available.'
 				
 				//IBUpload에 파일 추가하기
 				var ret = uploadObj.AddFile(sFile);
 			}
 			
 			//파일 갯수 가져오기
 			if(ibFlag != 'D') file_cnt++;
 			
 			//Sheet 정보 가져오기			
 			sheetObj.DataInsert(-1,0);	//신규행 생성
 			for (var colIdx=0; colIdx<=aryPopupData[0].length; colIdx++){ 
 				sheetObj.CellValue2(rowIdx+1, colIdx) = aryPopupData[rowIdx][colIdx];
 			}
 			sheetObj.CellValue2(rowIdx+1, "crr_cd")                      = ComGetObjValue(document.form.crr_cd);
 			sheetObj.CellValue2(rowIdx+1, "bkg_ref_no")                  = ComGetObjValue(document.form.bkg_ref_no);
 			sheetObj.CellValue2(rowIdx+1, "spcl_cgo_rqst_seq")           = ComGetObjValue(document.form.spcl_cgo_rqst_seq);
 			sheetObj.CellValue2(rowIdx+1, "spcl_cgo_rqst_atch_file_seq") = sheetObj.CellValue(rowIdx+1, "spcl_cgo_irr_file_seq");
 		}
 		
 		//Attach File 버튼 색상변경
 		chgBtnAttachFile(file_cnt);
 	
 		return; 
 	}
 	
 	/**
 	 * 업로드용 Hidden IBSheet의 정보를 가져온다.
 	 */
 	function getFileUpload() {
 		var sheetObj  = sheetObjects[2];
 		if(sheetObj.RowCount == 0) return null; 
 		return sheetObj; 
 	}
 	 
 	/**
  	 * Remark Setter
  	 */
  	function setRemark(value) {
  		ComSetObjValue(document.form.diff_rmk, value);
  	}
  	 
  	/**
   	 * Remark Getter
   	 */
   	function getRemark() {
   		return ComGetObjValue(document.form.diff_rmk);
   	}
   	
   	/**
  	 * Other_Emergency_Information Setter
  	 */
  	function setOtherEmergencyInformation(formObj) {
  		ComSetObjValue(document.form.ems_no,               ComGetObjValue(formObj.ems_no));
  		ComSetObjValue(document.form.ctrl_temp_ctnt,       ComGetObjValue(formObj.ctrl_temp_ctnt));
  		ComSetObjValue(document.form.emer_rspn_gid_no,     ComGetObjValue(formObj.emer_rspn_gid_no));
  		ComSetObjValue(document.form.emer_rspn_gid_chr_no, ComGetObjValue(formObj.emer_rspn_gid_chr_no));
  		ComSetObjValue(document.form.emer_temp_ctnt,       ComGetObjValue(formObj.emer_temp_ctnt));
  	}
  	 
  	/**
   	 * Other_Emergency_Information Setter
   	 */
   	function setOtherEmergencyInformation2(aryPopupData) {
   		ComSetObjValue(document.form.ems_no,               aryPopupData[0][4]);
   		ComSetObjValue(document.form.ctrl_temp_ctnt,       aryPopupData[0][5]);
   		ComSetObjValue(document.form.emer_rspn_gid_no,     aryPopupData[0][6]);
   		ComSetObjValue(document.form.emer_rspn_gid_chr_no, aryPopupData[0][7]);
   		ComSetObjValue(document.form.emer_temp_ctnt,       aryPopupData[0][8]);
   	}
  	
  	/**
   	 * Other_Emergency_Information Getter
   	 */
   	function getOtherEmergencyInformation() {
   		return document.form;
   	}
   	 
   	/**
   	 * DG Package Q'ty & Type Setter
   	 */
   	function setDgPkgQtyType(formObj) {
   		ComSetObjValue(document.form.out_n1st_imdg_pck_qty,      ComGetObjValue(formObj.out_imdg_pck_qty1));
   		ComSetObjValue(document.form.out_n1st_imdg_pck_cd,       ComGetObjValue(formObj.out_imdg_pck_cd1));
   		ComSetObjValue(document.form.out_n1st_imdg_pck_desc,     ComGetObjValue(formObj.out_imdg_pck_desc1));
   		ComSetObjValue(document.form.out_n2nd_imdg_pck_qty,      ComGetObjValue(formObj.out_imdg_pck_qty2));
   		ComSetObjValue(document.form.out_n2nd_imdg_pck_cd,       ComGetObjValue(formObj.out_imdg_pck_cd2));
   		ComSetObjValue(document.form.out_n2nd_imdg_pck_desc,     ComGetObjValue(formObj.out_imdg_pck_desc2));
   		
   		ComSetObjValue(document.form.in_n1st_imdg_pck_qty,       ComGetObjValue(formObj.in_imdg_pck_qty1));
   		ComSetObjValue(document.form.in_n1st_imdg_pck_cd,        ComGetObjValue(formObj.in_imdg_pck_cd1));
   		ComSetObjValue(document.form.in_n1st_imdg_pck_desc,      ComGetObjValue(formObj.in_imdg_pck_desc1));
   		ComSetObjValue(document.form.in_n2nd_imdg_pck_qty,       ComGetObjValue(formObj.in_imdg_pck_qty2));
   		ComSetObjValue(document.form.in_n2nd_imdg_pck_cd,        ComGetObjValue(formObj.in_imdg_pck_cd2));
   		ComSetObjValue(document.form.in_n2nd_imdg_pck_desc,      ComGetObjValue(formObj.in_imdg_pck_desc2));
   		
   		ComSetObjValue(document.form.max_in_pck_qty,             ComGetObjValue(formObj.max_in_pck_qty));
   		ComSetObjValue(document.form.max_in_pck_tp_cd,           ComGetObjValue(formObj.max_in_pck_tp_cd));
   		
   		var max_in_pck_qty = ComGetObjValue(formObj.max_in_pck_qty);
		if(max_in_pck_qty == '' || max_in_pck_qty == '0') {		
			document.all.imdg_lmt_qty_flg.Code2 = 'N';
			document.all.imdg_expt_qty_flg.Code2 = 'N';
		}
   	}
   	 
   	/**
	 * DG Package Q'ty & Type Setter
	 */
	function setDgPkgQtyType2(aryPopupData) {
		var formObj = document.form;
		ComSetObjValue(formObj.out_n1st_imdg_pck_qty,      aryPopupData[0][7]);
		ComSetObjValue(formObj.out_n1st_imdg_pck_cd,       aryPopupData[0][8]);
		ComSetObjValue(formObj.out_n1st_imdg_pck_desc,     aryPopupData[0][9]);
		ComSetObjValue(formObj.out_n2nd_imdg_pck_qty,      aryPopupData[0][10]);
		ComSetObjValue(formObj.out_n2nd_imdg_pck_cd,       aryPopupData[0][11]);
		ComSetObjValue(formObj.out_n2nd_imdg_pck_desc,     aryPopupData[0][12]);
		
		ComSetObjValue(formObj.intmd_n1st_imdg_pck_qty,    aryPopupData[0][13]);
		ComSetObjValue(formObj.intmd_n1st_imdg_pck_cd,     aryPopupData[0][14]);
		ComSetObjValue(formObj.intmd_n1st_imdg_pck_desc,   aryPopupData[0][15]);
		ComSetObjValue(formObj.intmd_n2nd_imdg_pck_qty,    aryPopupData[0][16]);
		ComSetObjValue(formObj.intmd_n2nd_imdg_pck_cd,     aryPopupData[0][17]);
		ComSetObjValue(formObj.intmd_n2nd_imdg_pck_desc,   aryPopupData[0][18]);
		
		ComSetObjValue(formObj.in_n1st_imdg_pck_qty,       aryPopupData[0][19]);
		ComSetObjValue(formObj.in_n1st_imdg_pck_cd,        aryPopupData[0][20]);
		ComSetObjValue(formObj.in_n1st_imdg_pck_desc,      aryPopupData[0][21]);
		ComSetObjValue(formObj.in_n2nd_imdg_pck_qty,       aryPopupData[0][22]);
		ComSetObjValue(formObj.in_n2nd_imdg_pck_cd,        aryPopupData[0][23]);
		ComSetObjValue(formObj.in_n2nd_imdg_pck_desc,      aryPopupData[0][24]);
		
  		ComSetObjValue(formObj.grs_capa_qty,              aryPopupData[0][29]);
	}
   	
   	/**
   	 * DG Package Q'ty & Type Getter
   	 */
   	function getDgPkgQtyType() {
   		return document.form;
   	}
   	 
   	/**
	 * DG application copy's Container Getter
	 */
	function getCntrList() {
		return sheetObjects[0];
	}
	 
	/**
	 * Copy Container
	 */
	function copyCntr(option, ct, sheetObj) {
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		
		var selCntrSeq = sheetObj1.CellValue(sheetObj1.SelectRow, "spcl_cntr_seq");
		var selCntrRow = sheetObj1.SelectRow;
		var selCgoRow  = sheetObj2.SelectRow;
		
		if(validateForm(sheetObj2,document.form,-1,IBSEARCH_ASYNC01)) {	//Cago정보 필수입력여부 체크 		
			if(option == '1' || option == '2') {
				for(var copyCt=0; copyCt<ct; copyCt++) {
					with(sheetObj1) {
						var selRow = FindText("spcl_cntr_seq", selCntrSeq, 0, -1, true);				
						if(selRow != -1) {
							addCntrRow(sheetObj1);
							for(var cntrIdx=SaveNameCol("cntr_tpsz_cd"); cntrIdx<=SaveNameCol("cntr_tpsz_cd"); cntrIdx++) {
								CellValue2(SelectRow, cntrIdx) = CellValue(selRow, cntrIdx);
							}
						}
					}
					
					with(sheetObj2) {
						if(option == '1') {
							var fstRow = FindText("spcl_cntr_seq", selCntrSeq, 0, -1, true);
							if(fstRow != -1) {
								var cgoCntrSeq;
								for(var cgoRowIdx=fstRow; cgoRowIdx<=LastRow; cgoRowIdx++) {				
									cgoCntrSeq = CellValue(cgoRowIdx, "spcl_cntr_seq");
									if(cgoCntrSeq == selCntrSeq && RowStatus(cgoRowIdx) != 'D') {	
										addCgoRow(sheetObj1, sheetObj2);
										for(var cgoIdx=SaveNameCol("cntr_tpsz_cd"); cgoIdx<=SaveNameCol("diff_rmk"); cgoIdx++) {
											CellValue2(SelectRow, cgoIdx) = CellValue(cgoRowIdx, cgoIdx);
										}
										SelectCell(SelectRow, "spcl_cntr_seq");
									}
								}
							}
						} else if(option == '2') {
							if(selCgoRow >= HeaderRows) {
								addCgoRow(sheetObj1, sheetObj2);
								for(var cgoIdx=SaveNameCol("cntr_tpsz_cd"); cgoIdx<=SaveNameCol("diff_rmk"); cgoIdx++) {
									CellValue2(SelectRow, cgoIdx) = CellValue(selCgoRow, cgoIdx);
								}
								SelectCell(SelectRow, "spcl_cntr_seq");
							}
						}
					}
				}
			} else if(option == '3') {
				with(sheetObj) {
					for(var rowIdx=HeaderRows; rowIdx<=LastRow; rowIdx++) {
		    			if(CellValue(rowIdx, "copyChk") == "1") {
		    				var chkRow = sheetObj1.FindText("spcl_cntr_seq", CellValue(rowIdx, "seq"), 0, -1, true);
		    				sheetObj1.SelectCell(chkRow, "spcl_cntr_seq");
		    				for (var copyIdx=0; copyIdx<CellValue(rowIdx,"copyCnt"); copyIdx++) {	    					
		    					copyCargo(sheetObj1, sheetObj2, selCgoRow);
		    				}
		    			}
					}
				}
			}
		}
	}
	 
	/**
	 * Pre-Checking result Setter - Y:체크후 통과 , N:체크전 , P:체크후 금지
	 */
	function setPreChkRslt(rslt) {
		ComSetObjValue(document.form.pre_chk_flg, rslt);
		
		var btnObj = document.getElementById('btn2_Pre_Checking_Report');
		if(rslt == 'P') {
			btnObj.style.color = "red";
 		} else if(rslt == 'Y') {
 			btnObj.style.color = "blue";
 		} else {
 			btnObj.style.color = "#737373";
 		}
	}
	
	//Control progress of Pre-Checking pop-up
	isIE  = document.all;
	isNN  = !document.all && document.getElementById;
	isN4  = document.layers;
	isHot = false;

	function nextPosInit(e){
		topDog = isIE ? "BODY" : "HTML";
		whichDog = isIE ? document.all.popWindow : document.getElementById("popWindow");
		hotDog = isIE ? event.srcElement : e.target;
		
		while(hotDog.id != null && hotDog.id != "popWindow" && hotDog.tagName != topDog) {
			hotDog=isIE ? hotDog.parentElement : hotDog.parentNode;
		}
		if (hotDog.id == "popWindow") {
			offsetx   = isIE ? event.clientX : e.clientX;
			offsety   = isIE ? event.clientY : e.clientY;
			nowX      = parseInt(whichDog.style.left);
			nowY      = parseInt(whichDog.style.top);
			nextPosEnabled = true;
			document.onmousemove = nextPos;
		}
	}

	function nextPos(e) {
		if (!nextPosEnabled) return;
		whichDog.style.left = isIE ? nowX + event.clientX - offsetx : nowX + e.clientX - offsetx;
		whichDog.style.top = isIE ? nowY + event.clientY - offsety : nowY + e.clientY - offsety;
		return false;
	}

	document.onmousedown = nextPosInit;
	document.onmouseup   = Function("nextPosEnabled=false");
	
	/**
	 * Progress Pop-Up of Pre-checking
	 */
	function showProgressPop(sheetObj, formObj) {
		var layerWidth  = 249;
		var layerHeight = 76 + 15;
		var pX = (document.body.clientWidth  - layerWidth )/2 + document.body.scrollLeft;
		var pY = (document.body.clientHeight - layerHeight )/2 + document.body.scrollTop + 100;
		
		//Form values --> Sheet
		setFormToSheetAll(sheetObj, sheetObj.SelectRow, formObj.imdg_clss_cd, formObj.apro_ref_no);
		
		ComBtnsEnable(false);
		
		formObj.f_cmd.value = SEARCH;
		var layerUrl = "VOP_SCG_0069.do?pop_type=B2&"+FormQueryString(formObj);
		
		var contents = "";
		contents = contents + "<div id=\"popWindow\" style=\"left:"+pX+"px; top:"+pY+"px; width:"+layerWidth+"px;height:"+layerHeight+"px;position:absolute;cursor:move ; border:0px solid #9999c1; z-index:1;overflow: no; visibility:visible\">";
		contents = contents + "<table class=\"popup\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
		contents = contents + "	<tr>";
		contents = contents + "		<td height=\"15\">";
		contents = contents + "			<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">";
		contents = contents + "				<tr>";
		contents = contents + "					<td class=\"title\" align=\"absmiddle\" valign=\"bottom\">Under Pre-Checking ...</td>";
		contents = contents + "				</tr>";
		contents = contents + "			</table>";
		contents = contents + "		</td>";
		contents = contents + "	</tr>";
		contents = contents + "	<tr>";
		contents = contents + "		<td>";
		contents = contents + "			<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">";
		contents = contents + "				<tr>";
		contents = contents + "					<td><img name=\"progressBar\" src=\"/hanjin/img/waiting.gif\" width=\"249\" height=\"76\" border=\"0\" align=\"absmiddle\"></td>";
		contents = contents + "				</tr>";
		contents = contents + "			</table>";
		contents = contents + "		</td>";
		contents = contents + "	</tr>";
		contents = contents + "	<tr>";
		contents = contents + "		<td>";
		contents = contents + "			<iframe id=\"preCheckFrm\" src=\""+layerUrl+"\" frameborder=\"0\" framespacing=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\" scrolling=\"no\" topmargin=\"0\" width=\"1\" height=\"1\"></iframe>";
		contents = contents + "		</td>";
		contents = contents + "	</tr>";
		contents = contents + "</table>";
		contents = contents + "</div>";
		
		progressPop.innerHTML = contents;
		
		window.document.body.style.cursor = "wait";
	}
	
	/**
	 * Close Pop-Up of Pre-checking
	 */
	function closeProgressPop() {
		document.all('popWindow').style.visibility = 'hidden';
		window.document.body.style.cursor = "default";
		
		ComBtnsEnable(true);
		
		doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
	}

//------------------------------------------------------------------------------//
/* 팝업 액션 과 리턴함수 -- 일반 조회 */    
//------------------------------------------------------------------------------//   	 
   	 
    /**
     * Carrier Validation
     */
    function searchCarrierCheck(obj) {
      	var formObj  = document.form;
      	var sheetObj = sheetObjects[0];
      	
      	var sParam = Array();
  	  	sParam[0] = "crr_cd="+obj.value;
  	  	sParam[1] = "f_cmd="+SEARCH01;
  	  	
  	  	if(sParam.join("").length > 16) {
  	    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
  	
  	    	var crrData = ComScgXml2Array(sXml, "crr_cd");
  	      	
  		   	if(crrData == null) {
  			    ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
  			    
  			    ComSetObjValue(obj, ""); 	 		    
 	 		    ComSetFocus(obj);
  		   	} else {
  	  	  		ComSetFocus(formObj.bkg_ref_no);
  	  	  	} 
  	  	}
    }
    
    /**
     * VVD Validation
     */
    function searchVVDCheck() {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[0];
    	
    	var sParam = Array();
	  	sParam[0] = "vsl_cd="+ComGetObjValue(formObj.vsl_cd);
	  	sParam[1] = "skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
	  	sParam[2] = "skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
	  	sParam[3] = "f_cmd="+SEARCH05;
	  	
	  	if(sParam.join("").length > 38) {
	    	var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
	
	    	var crr_cd      = ComScgXml2Array(sXml, "vsl_opr_tp_cd");
	    	var vsl_slan_cd = ComScgXml2Array(sXml, "vsl_slan_cd");
	    	
	 	   	if(crr_cd == null) {
	 	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
	 		    
	 		    ComSetObjValue(formObj.skd_dir_cd, "");
	 		    ComSetObjValue(formObj.skd_voy_no, "");
	 		    ComSetObjValue(formObj.vsl_cd, "");
	 		    ComSetObjValue(formObj.crr_cd, "");
	 		    ComSetObjValue(formObj.slan_cd, "");
	 		    
	 		    ComSetFocus(formObj.vsl_cd);
	 	   	} else {
	 	   		ComSetObjValue(formObj.crr_cd, crr_cd);
	 	   		ComSetObjValue(formObj.slan_cd, vsl_slan_cd);
	 	   		doActionIBCombo(sheetObjects[1], comboObjects[0], 1, '');	//POL 조회
	 	   		
	 	   		comboObjects[1].RemoveAll();	//POD 초기화
	 	   	}
	  	}
    }
     
    /**
     * TP/SZ Combo 목록 조회
     */
    function searchTPSZList(sheetObj) {       	
 		var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", "f_cmd="+SEARCH06);
 		
 		var arrCombo = ComXml2ComboString(sXml, "cntr_tpsz_cd", "cntr_tpsz_cd");
		if(arrCombo != null && arrCombo.length > 0) 
			sheetObj.InitDataCombo(0, "cntr_tpsz_cd", "| |"+arrCombo[0], "| |"+arrCombo[1], " ", " ");
    }
     
    /**
     * UN No. Validation
     */
    function searchUNNoCheck(obj) {
     	if(obj.value == '') return;
     	 
      	var formObj  = document.form;
      	var sheetObj = sheetObjects[0];
      	
      	formObj.f_cmd.value = SEARCH01;
      	
      	var param =  FormQueryString(formObj) ;
        var sXml  =  sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", param);
     	var sTotal = ComScgGetTotalValue(sXml);
     	
     	if( sTotal == "0"){
     		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
     		
     		ComSetObjValue(obj, ""); 
     		ComSetObjValue(document.form.imdg_un_no_seq, "");
     		ComSetObjValue(document.form.imdg_clss_cd, "");
     		ComSetObjValue(document.form.imdg_comp_grp_cd, "");
     		
 		    ComSetFocus(obj);
        } else {
        	onPopupClick(sheetObj, formObj, "UnNo", "UnNo");
 	   	}
    }
     
    /**
     * UN No. Information 조회
     */
    function searchUnNoInfo(sheetObj, imdg_un_no, imdg_un_no_seq) {
    	sheetObj.WaitImageVisible = false;
		var sXml = sheetObj.GetSearchXml("SCG_COM_INTERNALGS.do", "f_cmd="+SEARCH05+"&imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq);
		sheetObj.WaitImageVisible = true;
		
		return sXml;
    }
     
    /**
     * ETA 조회
     */
    function searchETADt(pol_cd) {       	
     	var sParam = Array();
     	sParam[0] = "vsl_cd="+ComGetObjValue(document.form.vsl_cd);
 	  	sParam[1] = "skd_voy_no="+ComGetObjValue(document.form.skd_voy_no);
 	  	sParam[2] = "skd_dir_cd="+ComGetObjValue(document.form.skd_dir_cd);
 	  	sParam[3] = "loc_cd="+pol_cd.substring(0,5);
 	  	sParam[4] = "f_cmd="+SEARCH10;
     	
 		var sXml = sheetObjects[1].GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
 		var etaDt = ComScgXml2Array(sXml, "vps_eta_dt");
 		
 		ComSetObjValue(document.form.eta_dt, etaDt);
    }
 
//------------------------------------------------------------------------------//
/* 일반 조회 -- IB 조회 */    
//------------------------------------------------------------------------------//    
    
    // Combo관련 프로세스 처리
    function doActionIBCombo(sheetObj, comboObj, comboNo, polCd) {
    	var formObj  = document.form;
     	
     	sheetObj.ShowDebugMsg = false;
         
        switch(comboNo) {
 	  		case 1:
 	  			
 	  			var sParam = Array();
 	  		  	sParam[0] = "vsl_cd="+ComGetObjValue(document.form.vsl_cd);
 	  		  	sParam[1] = "skd_voy_no="+ComGetObjValue(document.form.skd_voy_no);
 	  		  	sParam[2] = "skd_dir_cd="+ComGetObjValue(document.form.skd_dir_cd);
 	  		  	sParam[3] = "f_cmd="+SEARCH10;
 	  	    	
 	  			var sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
 	  			
 	  			comboObj.RemoveAll();
 	  			
 	  			var arrCombo = ComXml2ComboString(sXml, "loc_cd", "loc_nm");
 	  	    	
 	  	    	if(arrCombo != null && arrCombo.length > 0) {
 	  	    		var loc_cds        = ComScgXml2Array(sXml, "loc_cd");
 	  	    		var clptIndSeqs    = ComScgXml2Array(sXml, "clpt_ind_seq");
 	  	    		var turnPortIndCds = ComScgXml2Array(sXml, "turn_port_ind_cd");
 	  	    		var skdCngStsCd    = ComScgXml2Array(sXml, "skd_cng_sts_cd"); 	  	    		
 	  	    		
 	  	    		//Set Combo Drop Size
 	  	    		setComboProperty(document.all.pol_cd, loc_cds.length, "102");
 	  	    		
 	  	    		var newPolIdx = 0;
 	  	    		for(var arrIdx=0; arrIdx<loc_cds.length; arrIdx++) {
 	  	    			if(loc_cds[arrIdx] != null && loc_cds[arrIdx] != '') {
 	  		    			if(turnPortIndCds[arrIdx] != 'D' && turnPortIndCds[arrIdx] != 'V' && turnPortIndCds[arrIdx] != 'F') { 	  		    				
 	  		    				if(skdCngStsCd[arrIdx] != 'S') {
 	  		    					comboObj.InsertItem(newPolIdx++, loc_cds[arrIdx]+"|"+clptIndSeqs[arrIdx], loc_cds[arrIdx]+""+clptIndSeqs[arrIdx]);
 	  		    				} else {
 	  		    					comboObj.InsertItem(newPolIdx++, "", "");
 	  		    				}
 	  		    			}
 	  	    			}
 	  	    		}
 	  	    		
 	  	    		ComSetFocus(document.all.pol_cd);
 	  	    	} else {
 	  	    		comboObjects[1].RemoveAll();
 	  	    	}
         		
 	  			break; 
 	  		case 2:  
 	  			
 	  			var sParam = Array();
 	  		  	sParam[0] = "vsl_cd="+ComGetObjValue(document.form.vsl_cd);
 	  		  	sParam[1] = "skd_voy_no="+ComGetObjValue(document.form.skd_voy_no);
 	  		  	sParam[2] = "skd_dir_cd="+ComGetObjValue(document.form.skd_dir_cd);
 	  		  	sParam[3] = "f_cmd="+SEARCH10;
 	  	    	
 	  			var sXml = "";
 	  			
 	  			if(polCd != '') {
 	  				sXml = sheetObj.GetSearchXml("SCG_COM_EXTERNALGS.do", sParam.join("&")); 
 	  			}
 	  			
 	  			comboObj.RemoveAll();
 	  			
 	  			var arrCombo = ComXml2ComboString(sXml, "loc_cd", "loc_nm");
 	  	    	
 	  	    	if(arrCombo != null && arrCombo.length > 0 && polCd != '') {
 	  	    		var loc_cds        = ComScgXml2Array(sXml, "loc_cd");
 	  	    		var clptIndSeqs    = ComScgXml2Array(sXml, "clpt_ind_seq");
 	  	    		var clptSeqs       = ComScgXml2Array(sXml, "clpt_seq");
 	  	    		var skdCngStsCd    = ComScgXml2Array(sXml, "skd_cng_sts_cd");
 	  	    		
 	  	    		//Set Combo Drop Size
 	  	    		setComboProperty(document.all.pod_cd, loc_cds.length, "102");
 	  	    		
 	  	    		var polClptSeq = "0";
 	  	     		var newPodIdx  = 0;
 	  	     		
 	  	     		for(var arrIdx1=0; arrIdx1<loc_cds.length; arrIdx1++) {
 	  	     			if(loc_cds[arrIdx1]+""+clptIndSeqs[arrIdx1] == polCd) polClptSeq = clptSeqs[arrIdx1];
 	  	     		}
 	  	    		
 	  	    		var newPodIdx = 0;
 	  	    		for(var arrIdx2=0; arrIdx2<loc_cds.length; arrIdx2++) {
 	  	    			if(loc_cds[arrIdx2] != null && loc_cds[arrIdx2] != '') {
 	  	    				if(parseInt(clptSeqs[arrIdx2]) > parseInt(polClptSeq)) {
 	  	    					if(skdCngStsCd[arrIdx2] != 'S') {
 	  	    						comboObj.InsertItem(newPodIdx++, loc_cds[arrIdx2]+"|"+clptIndSeqs[arrIdx2], loc_cds[arrIdx2]+""+clptIndSeqs[arrIdx2]);
 	  	    					} else {
 	  		    					comboObj.InsertItem(newPodIdx++, "", "");
 	  		    				}
 	  		    			}
 	  	    			}
 	  	    		}
 	  	    		
 	  	    		ComSetFocus(document.all.pod_cd);
 	  	    	}
         		
 	  			break; 
        }
        
        return true;
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH: case SEARCH01:      //조회
				if(!validateForm(sheetObj,formObj,-1,IBSEARCH)) {
					return;
				} else {
					//기존 등록된 BKG에 대한 수정외에는 등록 Sequence를 초기화 한다.
					if(sAction == IBSEARCH && ComGetObjValue(formObj.ibflag) == 'I') {
						ComSetObjValue(formObj.spcl_cgo_rqst_seq, "");
					}
					//Pre-Checking Report 의 결과를 초기화 한다.
					setPreChkRslt("N");
				}
				
				formObj.f_cmd.value = SEARCH;
	 			var sXml = sheetObj.GetSearchXml("VOP_SCG_1022GS.do", FormQueryString(formObj));	 
	 			
	 			var arrXml = sXml.split("|$$|");

	 			ComOpenWait(false, true);	//Button의 충돌로 인하여 사용치 못함.
	 			
	 			var spcl_cgo_rqst_seq = ComGetEtcData(arrXml[0],"spcl_cgo_rqst_seq");
	 			
	 			if(spcl_cgo_rqst_seq != '' && spcl_cgo_rqst_seq != 'null') {
	 				ComSetObjValue(formObj.spcl_cgo_rqst_seq, spcl_cgo_rqst_seq);
	 				ComSetObjValue(formObj.ibflag, "U");
	 				
	 				ComSetObjValue(formObj.org_cgo_opr_cd, ComGetObjValue(formObj.cgo_opr_cd));
	 				ComSetObjValue(formObj.org_bkg_ref_no, ComGetObjValue(formObj.bkg_ref_no));
	 				ComSetObjValue(formObj.org_vsl_cd,     ComGetObjValue(formObj.vsl_cd));
	 				ComSetObjValue(formObj.org_skd_voy_no, ComGetObjValue(formObj.skd_voy_no));
	 				ComSetObjValue(formObj.org_skd_dir_cd, ComGetObjValue(formObj.skd_dir_cd));
	 				ComSetObjValue(formObj.org_crr_cd,     ComGetObjValue(formObj.crr_cd));
	 				ComSetObjValue(formObj.org_slan_cd,    ComGetObjValue(formObj.slan_cd));
	 				
	 				setEnableUI(document.form, document.form.cgo_opr_cd, document.form.skd_dir_cd, 'readonly');
	 				document.getElementById("btn_Carrier").style.visibility = "hidden";
	 				document.getElementById("btn_VVDpop").style.visibility = "hidden";
	 			} else {
	 				ComSetObjValue(formObj.spcl_cgo_rqst_seq, "");
	 				ComSetObjValue(formObj.ibflag, "I");
	 			} 	
	 			
	 			//Pre-Checking 결과
	 			ComSetObjValue(formObj.pre_chk_flg, "N");
	 			
	 			for(var i = 1; i < arrXml.length+1; i++){ 
	 				sheetObjects[i].WaitImageVisible = false;	
					sheetObjects[i].LoadSearchXml(arrXml[i-1]); 
					sheetObjects[i].WaitImageVisible = true; 
				}
	 			
	 			if(arrXml.length < 2) {
	 				uploadObj.Files = "";					
	 				sheetObjects[2].removeAll();
	 			}

	 			// pre-checking summary 조회 2013.06.03
			 	var sParam = makePreChkParam();
				
				formObj.f_cmd.value = SEARCH04;
				var sXml = sheetObj.GetSearchXml("VOP_SCG_0069GS.do?f_cmd="+formObj.f_cmd.value, sParam);
				var arrXml = sXml.split("|$$|");
		        arrData = ComScgXml2Array(arrXml[0], "crr_flg|port_flg|seg_flg|expt_qty_flg|ltd_qty_flg|pi_flg");
		        
		        if(arrData[sheetObjects[1].SelectRow-1][0] == "X"){
		        	ComSetObjValue(formObj.pre_crr, "X");
		        }else{
		        	ComSetObjValue(formObj.pre_crr, "O");
		        }
		        if(arrData[sheetObjects[1].SelectRow-1][1] == "X"){
		        	ComSetObjValue(formObj.pre_opr, "X");
		        }else{
		        	ComSetObjValue(formObj.pre_opr, "O");
		        }
		        if(arrData[sheetObjects[1].SelectRow-1][2] == "X"){
		        	ComSetObjValue(formObj.pre_sgr, "X");
		        }else{
		        	ComSetObjValue(formObj.pre_sgr, "O");
		        }
		        if(arrData[sheetObjects[1].SelectRow-1][3] == "X" || arrData[sheetObjects[1].SelectRow-1][4] == "X" || arrData[sheetObjects[1].SelectRow-1][5] == "X"){
		        	ComSetObjValue(formObj.pre_pck, "X");
		        }else if ( arrData[sheetObjects[1].SelectRow-1][3] == "M" || arrData[sheetObjects[1].SelectRow-1][4] == "M" || arrData[sheetObjects[1].SelectRow-1][5] == "M" ){
		        	ComSetObjValue(formObj.pre_pck, "M");
		        }else{
		        	ComSetObjValue(formObj.pre_pck, "O");
		        }
	 			
	 			
	 			//see [sheet2_OnSearchEnd]
	 			
	 			ComOpenWait(false);
	 			
	 			//Waitting 이미지로 인한 창 스크롤 생성 방지용
	 			document.body.scroll = "no";

            	break;
            	
			case IBBATCH:	//Pre-Checking
				if(!validateForm(sheetObj,formObj,-1,IBSEARCH)) return;											//Booking 정보 체크
				if(!validateForm(sheetObj,formObj,-1,IBSEARCH_ASYNC02)) return;									//Container,Cargo 유무체크
			    if(!validateForm(sheetObjects[0],formObj,sheetObjects[0].SelectRow,IBSEARCH_ASYNC03)) return;	//Container 정보 체크
				if(!validateForm(sheetObj,formObj,-1,IBSEARCH_ASYNC01)) return;									//Cargo 정보 체크				
				else {
					formObj.f_cmd.value = SEARCH;
					var returnVal = ComGetObjValue(document.form.pre_chk_flg);
					if(returnVal == 'N') {
						//returnVal = onPreChkPopup(sheetObj, formObj, "B", "255", "105");
						showProgressPop(sheetObj, formObj);
					} else {
						doActionIBSheet(sheetObj, formObj, IBSAVE);
					}
				}
				
				break;

			case IBSAVE:        //저장
			
				var preChkConfirmYn = true;
				
				var returnVal = ComGetObjValue(document.form.pre_chk_flg);
				if(returnVal != 'Y') {
					if(!ComShowCodeConfirm('SCG50029')) {	//'This booking doesn\'t comply with HJS policy according to Pre Checking Report.\nDo you want to proceed approval?'
						//onPreChkPopup(sheetObj, formObj, "S", "940", "965");
						return false;	
					} else {
						preChkConfirmYn = false;
					}
				}
				
				var rowPosition = sheetObj.SelectRow;			
				formObj.f_cmd.value = MULTI;
				
				//Form values --> Sheet
				setFormToSheetAll(sheetObj, sheetObj.SelectRow, formObj.imdg_clss_cd, formObj.apro_ref_no);
				
				if(ComGetObjValue(formObj.ibflag) == 'U') {
					//BKG Info의 변경불가 항목들을 원복한다.
					ComSetObjValue(formObj.bkg_ref_no, ComGetObjValue(formObj.org_bkg_ref_no));
	 				ComSetObjValue(formObj.vsl_cd,     ComGetObjValue(formObj.org_vsl_cd));
	 				ComSetObjValue(formObj.skd_voy_no, ComGetObjValue(formObj.org_skd_voy_no));
	 				ComSetObjValue(formObj.skd_dir_cd, ComGetObjValue(formObj.org_skd_dir_cd));
	 				ComSetObjValue(formObj.crr_cd,     ComGetObjValue(formObj.org_crr_cd));
	 				ComSetObjValue(formObj.slan_cd,    ComGetObjValue(formObj.org_slan_cd));
				}
				
				//Cago 정보 저장 쿼리 생성시 포커스 자동 이동으로 인하여 기존 포커스 유지를 위하여 조건식 추가
				if(rowPosition == -1) cgoSelBlk = true;
				
				//BKG Company 변경시 모든 Cargo의 정보를 변경하도록 강제한다.
				var org_cgo_opr_cd = ComGetObjValue(formObj.org_cgo_opr_cd);
				var cgo_opr_cd     = ComGetObjValue(formObj.cgo_opr_cd);
				if(org_cgo_opr_cd != '' && org_cgo_opr_cd != cgo_opr_cd) {
					for(var upIdx=sheetObj.HeaderRows; upIdx<=sheetObj.LastRow; upIdx++) {
						sheetObj.RowStatus(upIdx) = "U";
					}
				}					
				
				var sParam = ComGetSaveString(sheetObj, false, false, -1);				
				if(cgoSelBlk) {
					sheetObj.SelectCell(0, "spcl_cgo_seq");
					cgoSelBlk = false;
				}
     		   	
     		   	//파일 팝업화면을 공통으로 사용하기 위하여 변환작업 추가
     		    var fileParam = ComGetSaveString(sheetObjects[2], true, false, -1);
     		    
     		   	//'저장하시겠습니까?'
        		if(preChkConfirmYn && !ComShowCodeConfirm('SCG50001', 'data')) return false;	//'Do you want to save {?msg1}?'
     		   	
     		   	//Booking Key 를 Cago 정보에 연결
     		   	var bkgKeyParam = "&crr_cd="+ComGetObjValue(formObj.crr_cd);
     		   	bkgKeyParam += "&bkg_ref_no="+ComGetObjValue(formObj.bkg_ref_no);
     		   	bkgKeyParam += "&spcl_cgo_rqst_seq="+ComGetObjValue(formObj.spcl_cgo_rqst_seq);
     		    bkgKeyParam += "&cgo_opr_cd="+ComGetObjValue(formObj.cgo_opr_cd);
     		    bkgKeyParam += "&vsl_cd="+ComGetObjValue(formObj.vsl_cd);
     		    bkgKeyParam += "&skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
     		    bkgKeyParam += "&skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
     		    bkgKeyParam += "&slan_cd=";
     		    bkgKeyParam += "&pol_cd="+ComGetObjValue(formObj.pol_cd);
     		    bkgKeyParam += "&pod_cd="+ComGetObjValue(formObj.pod_cd);
     		   	
     		    sParam = ComReplaceStr(sParam, "&spcl_cntr_seq", bkgKeyParam+"&spcl_cntr_seq");
     		    
     		    var formParam = FormQueryString(formObj);
     		   	
     		    sParam = ComScgSetPrifix(sParam, "cago_");  
     		    sParam += "&"+ComScgSetPrifix(fileParam, "file_");  
     		   	
     		   	var paramPrefix = new Array("", "cago_", "file_");
     		   	sParam += "&" + formParam + "&" + ComGetPrefixParam(paramPrefix);;
     		   	
     		   	ComOpenWait(true, true);
     		   	
     		   	//1.IBUpload 가져오기
         	    var uploadObj = uploadObjects[0];	
         	    
         	    if (uploadObj.LocalFiles == "") {      		   	
         	    	sXml = sheetObj.GetSaveXml("VOP_SCG_1022GS.do", sParam);         	    	
         	    } else {
         	    	uploadObj.ExtendParam = sParam; 				
         	    	uploadObj.ParamDecoding = true;

         	    	sXml = uploadObj.DoUpload(true);
         	    }
     		   	
     		    var rslt = ComGetEtcData(sXml, "rslt");
     		   	
     		    if(rslt == '0') {
     		    	ComShowMessage(ComScgGetMessageFromXml(sXml));
     		    } else {     		    	
     		    	if (sXml.length > 0) sheetObj.LoadSaveXml(sXml);
     		    	doActionIBSheet(sheetObjects[1], formObj, SEARCH01);
     		    }
     		   	
     		   	ComOpenWait(false);
     		   	
     		   	//Waitting 이미지를 인한 창 스크롤 생성 방지용
	 			document.body.scroll = "no";
				
				break;

			case IBSEARCH_ASYNC02:      // MPA1 Validation
				var sParam = Array();
		     	sParam[0] = "vsl_cd="+ComGetObjValue(formObj.vsl_cd);
		 	  	sParam[1] = "skd_voy_no="+ComGetObjValue(formObj.skd_voy_no);
		 	  	sParam[2] = "skd_dir_cd="+ComGetObjValue(formObj.skd_dir_cd);
		 	  	sParam[3] = "pod_cd="+ComGetObjValue(document.all.pod_cd);
		 	  	sParam[4] = "f_cmd="+SEARCH01;
		     	
		 		var sXml = sheetObj.GetSearchXml("VOP_SCG_1022GS.do", sParam.join("&")); 
		 		
		 		//MAP1 Validation
		 		chkMpa1(sheetObj, formObj, sXml);

				break;
        }
    }

//------------------------------------------------------------------------------//
/* IB 조회 - 검증 프로세스 */    
//------------------------------------------------------------------------------// 	
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, row, sAction) {
        with(formObj){
        	switch(sAction) {	
        		case IBSEARCH:	// Booking 필수항목 확인
        			if(!ComChkObjValid(formObj.cgo_opr_cd)) return false;
        			if(!ComChkObjValid(formObj.bkg_ref_no)) return false;
        			if(!ComChkObjValid(formObj.vsl_cd)) 	return false;
            		if(!ComChkObjValid(formObj.skd_voy_no)) return false;
            		if(!ComChkObjValid(formObj.skd_dir_cd)) return false;
            		
            		//Check requirement of POL
    		    	if(ComGetObjValue(document.all.pol_cd) == '') {
    		    		ComAlertFocus(document.all.pol_cd, "'POL' " +Msg_Required);    		    		
    		    		return;
    		    	}
    		    	//Check requirement of POD
    		    	if(ComGetObjValue(document.all.pod_cd) == '') {
    		    		ComAlertFocus(document.all.pod_cd, "'POD' " +Msg_Required);    		    		
    		    		return;
    		    	}
        			
        			break;
        		case IBSEARCH_ASYNC01:	//Cargo 필수항목 확인
        			try {
        	         	 var elems = document.form.elements;
        	         	 var startYn = false;
        	         	 for(var i = 0; i < elems.length; i++) {
        	         		 var elem  = elems[i];
        	         		 var objNm = elem.name;
        	                  
        	                 if('spcl_cgo_seq' == objNm) {
        	                	 if(elem.Index == -1) return true;
        	                	 startYn = true;        	                 
        	                 }
        	                 if(startYn) {                	 
        		                 if (elem.tagName == 'INPUT' && objNm != null && objNm != '') {	                	 
        		                	 if(elem.getAttribute("required") != null) {
        		                		 if (ComTrim(ComGetObjValue(elem)) == "") {
        		                			 if(objNm == 'hzd_desc') {
        		                				 ComShowCodeMessage('SCG50012');	//'For the purpose of documentation and package marking the Proper Shipping Name shall be supplemented with the technical name for this UN No.'
        		                			 } else {
        		                				 ComShowMessage("'" + elem.getAttribute("caption") + "' " + Msg_Required);
        		                			 }
        		                			 
        		                			 if(objNm == 'out_n1st_imdg_pck_qty') {
        		                				 document.all.btn2_Package_Qty_Type.fireEvent('onclick');
        		                			 } else if(objNm == 'imdg_un_no_seq') {
    		                					 document.all.btn_Un_No.fireEvent('onclick');
        		                			 } else {
        		                				 elem.focus();
        		                			 }
        		                			 
        		                			 return false;
        		                		 }
        		                		 if(objNm == 'prp_shp_nm') {
        		                			 var orAndPos = ComGetObjValue(elem).toUpperCase().indexOf(" OR ");
        		                			 if(orAndPos == -1) orAndPos = ComGetObjValue(elem).toUpperCase().indexOf(" AND ");
        		                			 if(orAndPos != -1) {
        		                				 var nextStr = ComGetObjValue(elem).substring(orAndPos,ComGetObjValue(elem).length);
        		                				 var nextStrs = nextStr.split(" ");
        		                				 
    		                					 nextStr = "";
    		                					 for(var chkIdx=2; chkIdx<nextStrs.length; chkIdx++) {
    		                						 if(ComTrim(nextStrs[chkIdx]) != '') {
    		                							 nextStr = nextStrs[chkIdx];
    		                							 break;
    		                						 }
    		                					 }
        		                				 
        		                				 if(nextStr != '' && nextStr == nextStr.toUpperCase()) {
	        		                				 ComShowCodeMessage('SCG50020');	//'When conjunction such as "and" or "or" are in the Proper Shipping Name or when segments of the name are punctuated by commas, you have to select the most appropriate one.'
	        		                				 elem.focus();
	        		                				 
	        		                				 return false;
        		                				 }
        		                			 }
        		                		 }
        		                		 if(objNm == 'grs_wgt' || objNm == 'net_wgt') {
        		                			 if(!chkGrossNetWeight(elem)) return false;
        		                		 }
        		                	 }
        		                 } else if (elem.tagName == 'OBJECT') {
        		                	 var sObjId = elem.classid;
        		                 	 switch(sObjId){
        		 	                 	case CLSID_IBMCOMBO: //IBMultiCombo 경우만
        		 	                 		if(elem.className == 'mult_combo1') {
        		 	                 			if (elem.Code == "") {
        		 	                 				ComShowMessage(elem.id + Msg_Required);
        		 	                 				elem.focus();
               		                			 
        		 	                 				return false;
        		 	                 			}
        		 	                 		}
        		 	                 		break;
        		 	                 }
        		                  }
        	                 }
        	                 if('apro_ref_no' == objNm) break;
        	         	 }
        	         } catch(err) { ComFuncErrMsg(err.message); }
        			
        			break;
        		case IBSEARCH_ASYNC02:	//Container,Cargo 등록여부 확인        			
    				var cntrCt = sheetObjects[0].RowCount;
    				var cgoCt  = sheetObj.RowCount("R") + sheetObj.RowCount("I") + sheetObj.RowCount("U");
    				if(cntrCt > 0) {
    					if(cgoCt > 0) {
    						return true;
    					} else {
    						ComShowCodeMessage('SCG50007','Cargo Seq');	//'Please input {?msg1}.'
    						return false;
    					}
    				} else {
    					ComShowCodeMessage('SCG50007','CNTR Seq');	//'Please input {?msg1}'
    					return false;
    				}
    				
        			break;
        		case IBSEARCH_ASYNC03:	//Container 필수항목 확인        			
					var cntr_tpsz_cd = sheetObj.CellText(row, "cntr_tpsz_cd");
					if(ComTrim(cntr_tpsz_cd) == '') {
						ComShowMessage("'TP/SZ' " + Msg_Required);
						//sheetObj.SelectCell(row, "cntr_tpsz_cd");
						
						return false;
					}
					
	    			break;
	    			
        		case IBSEARCH_ASYNC04:	// PKG QTY/TYPE 항목 확인
        		if(ComGetObjValue(formObj.out_n1st_imdg_pck_qty) != null && ComGetObjValue(formObj.out_n1st_imdg_pck_qty) != '' && ComGetObjValue(formObj.in_n1st_imdg_pck_qty) != null && ComGetObjValue(formObj.in_n1st_imdg_pck_qty) != ''){
        			var chkGrs = parseFloat(formObj.grs_wgt.value.replace(/,/g, "")) / parseFloat(formObj.out_n1st_imdg_pck_qty.value);
        			var chkNet = parseFloat(formObj.net_wgt.value.replace(/,/g, "")) / parseFloat(formObj.in_n1st_imdg_pck_qty.value);
        			var lmtQty = formObj.imdg_lmt_qty.value;
        			var lmtQtyUt = formObj.imdg_lmt_qty_meas_ut_cd.value;
        			if(lmtQtyUt == "mlg" || lmtQtyUt == "MLG"){
        				lmtQtyUt = "ml or g";
        			}else if(lmtQtyUt == "LKG"){
        				lmtQtyUt = "L or KG";
        			}
        			
        			if(formObj.imdg_lmt_qty_meas_ut_cd.value != "L" && formObj.imdg_lmt_qty_meas_ut_cd.value != "KG" && formObj.imdg_lmt_qty_meas_ut_cd.value != "LKG"){
        				chkNet = parseFloat(chkNet)*1000;
        			}
        			if(chkGrs > 30 || chkNet > lmtQty){
        				var netRound = (Math.round(chkNet * 1000))/1000
        				ComShowCodeMessage('SCG50038', formObj.imdg_un_no.value, netRound, lmtQty, lmtQtyUt);	//'This UN NO-[{?msg1}] limited quantity of [{?msg2} KG] per package is greater than [{?msg3} KG] in IMDG regulation. \nPls re-check again.'
    					return false;	
        			}
        		}else{
        			ComShowCodeMessage('SCG50039');
        			onPopupClick(sheetObjects[1], formObj, "btn2_Package_Qty_Type", "DgPkgQtyType");
        			return false;
        		}
        		break;	
	    			
	    			
        	}
        }
		return true;
	}

    /**
     * Gross/Net Weight의 입력값 체크
     */
    function chkGrossNetWeight(obj) {
    	var sheetObj = sheetObjects[1];
    	if(parseFloat(sheetObj.CellValue(sheetObj.SelectRow, "grs_wgt")) < parseFloat(sheetObj.CellValue(sheetObj.SelectRow, "net_wgt"))) {
			ComAlertFocus(obj, "Net weight should be less than gross weight.");
			obj.select();
			
			return false;
		}
    	
    	return true;
    }
	
    /**
     * Flash Point의 입력값 체크
     */
    function chkFlshPoint(obj) {
    	var formObj = document.form;
    	with(obj) {
    		if(value != '') {
    			if(ComGetObjValue(formObj.imdg_un_no) == '') {
    				ComShowCodeMessage('SCG50007', 'UN No.');	//'Please input {?msg1}.'
    				ComSetObjValue(obj, "");
    				ComSetFocus(formObj.imdg_un_no);
    			} else {
    				//오직 주위험성이 Class 3일 경우에만 해당 메시지 보이기
    				if(ComGetObjValue(formObj.imdg_clss_cd) == '3' && ComGetObjValue(formObj.n1st_imdg_subs_rsk_lbl_cd) == '' && ComGetObjValue(formObj.n2nd_imdg_subs_rsk_lbl_cd) == '' && ComGetObjValue(formObj.n3rd_imdg_subs_rsk_lbl_cd) == '' && ComGetObjValue(formObj.n4th_imdg_subs_rsk_lbl_cd) == '') {
	    				if(ComGetObjValue(formObj.imdg_pck_grp_cd) == 'III') {
	    					if(parseInt(ComGetObjValue(obj)) < 23 || parseInt(ComGetObjValue(obj)) > 60) {
	    						ComShowCodeMessage('SCG50023');	//'Flashpoint is expected to be in the range of 23°C (include 23°C) to 60°c(include 60°C) for packing group III.'
	    					}
	    				}else if(ComGetObjValue(formObj.imdg_pck_grp_cd) == 'I' || ComGetObjValue(formObj.imdg_pck_grp_cd) == 'II') {
	    					if(parseInt(ComGetObjValue(obj)) >= 23) {
	    						ComShowCodeMessage('SCG50024');	//'Flashpoint is expected to be below 23°C for packing group I or II.'
	    					}
	    				}
    				}
    			}    				
    		}
    	}
    }
     
    /**
     * Flash Point의 상태변경 결정(주위험성이 Class 3(인화성 액체)이거나 또는 부위험성(Subsidiary risk)이 Class 3(인화성 액체)인 경우 Flashpoint 입력란을 필수입력 항목으로 함 .)
     */
    function fixFlshPointForm(formObj) {
    	var rslt = false;
    	var flshpointObj = document.getElementById("flsh_pnt_cdo_temp"); 	
 		if(ComGetObjValue(formObj.imdg_clss_cd) == '3' || ComGetObjValue(formObj.n1st_imdg_subs_rsk_lbl_cd) == '3' || ComGetObjValue(formObj.n2nd_imdg_subs_rsk_lbl_cd) == '3' || ComGetObjValue(formObj.n3rd_imdg_subs_rsk_lbl_cd) == '3' || ComGetObjValue(formObj.n4th_imdg_subs_rsk_lbl_cd) == '3') {
 			flshpointObj.removeAttribute("disabled");
 			flshpointObj.setAttribute("required", "true");
 			flshpointObj.className = "input1";
 		} else if(ComGetObjValue(formObj.imdg_clss_cd) != '' && ComGetObjValue(formObj.imdg_clss_cd) != '3') {
 			ComSetObjValue(flshpointObj, "");
 			flshpointObj.removeAttribute("required");
 			flshpointObj.setAttribute("disabled", "true");
 			flshpointObj.className = "input2";
 		} else {
 			flshpointObj.removeAttribute("required");
 			flshpointObj.removeAttribute("disabled");
 			flshpointObj.className = "input";
 			
 			rslt = true;
 		}
 		
 		return rslt;
    }
     
    /**
     * SP274 가 적용되는 UN No. 의 경우 Technical Name을 필수항목으로 설정한다.
     */
    function chgTecNmBox(imdgSpclProviNo, obj) {
    	if(imdgSpclProviNo == '274') {
    		obj.setAttribute("required", "true");
    		obj.className = "input1";
		} else {
			obj.removeAttribute("required");
			obj.className = "input";
		}
    }
     
    /**
     * HCDG/Remark(s) Button 색상변경
     */
    function chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk) {
    	//HCDG Button 색상변경
		if(hcdg_flg == 'Y')
			document.getElementById('btn2_HCDG').style.color="red";
		else document.getElementById("btn2_HCDG").style.color = "#737373";
		 
		//Remark(s) Button 색상변경
		if(hcdg_flg != null && ComTrim(imdg_subs_rsk_lbl_rmk) != '') {
 			//document.getElementById('btn2_Sub_Remark').style.color = "red";
 		} else {
 			//document.getElementById("btn2_Sub_Remark").style.color = "#737373";
 		}
    }
     
    /**
     * Attach File Button 색상변경
     */
    function chgBtnAttachFile(val) {
    	if(val != 0) {
 			document.getElementById('btn1_Attach_File').style.color = "red";
 		} else {
 			document.getElementById("btn1_Attach_File").style.color = "black";
 		}
    }
     
    /**
     * MPA1 체크
     */
    function chkMpa1(sheetObj, formObj, sXml) {
    	var rslt = ComGetEtcData(sXml, "rslt");
 		
 		//MAP1 Validation
 		if(rslt != '-1') {
 			//'This DG Cargo is listed in First Schedule of Singapore. You need to check the total approved cargo net weight on the class for the max quantity of First Schedule DG which may remain on board at a Singapore berth.\nSo far, total {?msg1}kg have been approved on the Class {?msg2}. You are going to approve net weight {?msg3}kg additionally. Do you confirm?'
 			if (ComShowCodeConfirm('SCG50022', 
				 "BKG:"+ComGetObjValue(formObj.bkg_ref_no)+
				 ", VVD:"+ComGetObjValue(formObj.vsl_cd)+ComGetObjValue(formObj.skd_voy_no)+ComGetObjValue(formObj.skd_dir_cd)+
				 ", Class:"+ComGetObjValue(formObj.imdg_clss_cd),   
				 rslt)) {
 			}else{
 				document.all.auth_sts_cd.value = sheetObj.CellValue(sheetObj.SelectRow, "auth_sts_cd");
 			}
 		}
    }     

	/* 개발자 작업  끝 */