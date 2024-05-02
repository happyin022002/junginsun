	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0227.js 
	 *@FileTitle : M&R Extra W/O Inquiry Pop Up
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.10.15
	 *@LastModifier : 권영법
	 *@LastVersion : 1.0
	 * 2009.10.15 권영법
	 * 1.0 Creation 
			=========================================================*/
	/****************************************************************************************
			  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
								[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
								기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	/**
	 * @extends 
	 * @class ees_mnr_0227 : ees_mnr_0227 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0227() {
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
	
	var costDtlCode = "";
	var costDtlDesc = "";
	var OrgCostType = "";
	
	
	var mnrHngrBarTpCode = "";
	var mnrHngrBarTpDesc = "";
	var nowLoad = 0;
	
	//파일업로드를 사용하기 위한 
	var uploadObjects = new Array();
	var uploadCnt = 0;
	var arrDataSearchDbXml;
	
	var frontMnrOrdSeq="";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[2], formObject, IBSEARCH);
				break;
	
			case "btn_close":    
				self.close();  
				break;   
			} // end switch
		}catch(e) {
			if (e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
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
	
	function setParam(array) {
		if(array == null)return;
		var formObj = document.form;
		var str = array + "";
		var arr = str.split(',');
	
		formObj.mnr_ord_seq.value = arr[4];
	
		if(formObj.mnr_ord_seq.value.length > 3){
			doIBSEARCH(sheetObjects[2], formObj, IBSEARCH);
		}
	} 
	
	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj){
	
		uploadObjects[uploadCnt++] = uploadObj;
	}	
	
	function initControl() {       
		//Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	formObject); //- 변경될때.
	}             
	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
		ComChkObjValid(event.srcElement); 
	} 
	
	function obj_activate(){   
		ComClearSeparator(event.srcElement);
	}        
	
	function obj_change()
	{	     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" )
		{
	
			switch(obj.name)
			{      
			case "none":   
	
				break;  
	
			}       		
		}
	}    
	
	function obj_keypress(){   
		obj = event.srcElement;    
		keys = event.keyCode;
	
		if(obj.dataformat == null )
		{
			if(obj.name!="ord_hdr_rmk")
			{
				return; 
			}
		}
	
		window.defaultStatus = obj.dataformat;
		var formObj  = document.form; 
	
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
			case "none":   
				break;  
			}       
		}				 			              
		switch(obj.dataformat) {   
		case "ymd":   
		case "int":       
			ComKeyOnlyNumber(obj); 
			break;     
		case "float":    
			ComKeyOnlyNumber(obj, "-.");
			break; 
		case "eng":   
			ComKeyOnlyAlphabet();
			break;   
		case "engup":  
			ComKeyOnlyAlphabet('uppernum');           
			break; 
		case "engnum":  
			ComKeyOnlyAlphabet("num","32|64");           
			break; 
		}         
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		MnrWaitControl(true);
		initControl();  
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			if(sheetObjects[i].id.substring(0,2) == "sheet2" ){       
				DLCSheets[DLCSheetCnt++] = sheetObjects[i];  	
			} 	
		}
		initCombo();
		ComConfigUpload(uploadObjects[0], "/hanjin/MNR_INTGS.do"); 
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		MnrWaitControl(false);
	}	
	
	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files = "";
	}
	
	/**
	 * 멀티 콤보 초기화 
	 * @return
	 */
	function initCombo() {
	
		var formObject = document.form
		with (formObject.combo_vndr_seq) {
			MultiSeparator = "|";
			SetTitle("S/P Name|S/P Code|AGMT No|EQ TYPE|Effective Date|Reference No|Tariff No|Currency^AgmtVerNo^EQ code"); 
			SetColAlign("left|left|center|left|center|left|left|left");   
			SetColWidth("180|80|90|80|170|180|180|0");                        
			DropHeight = 160;        
		}  	 
	
	
		with (formObject.combo_cost_cd) {
			MultiSeparator = "|";

			SetColAlign("left");
			SetColWidth("180");
			DropHeight = 160;
		}
	
		with (formObject.combo_eq_knd_cd) {
			MultiSeparator = "|";
			SetTitle("Code|Name");
	
			SetColAlign("left|left");
			SetColWidth("90|180");
			DropHeight = 160;
	
			Enable = false;
		}
	
		combo_eq_knd_cd_Initialize();
	
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
			style.height = 140;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
	
			var HeadTitle1 = "|Sel|Seq|Extra Expense Type|EQ No.|Description |Hanger Bar Type|Unit Price| Q'ty|Amount|Remark(s)";
			var headCount = ComCountHeadTitle(HeadTitle1) + 5;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//	InitHeadMode(true, true, true, true, false,false) 
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]dtSeq
			InitHeadRow(0, HeadTitle1, true);
	
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,	prefix+	"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,    	40,     daCenter,   true,           "del_chk",              false,	"",		dfNone,		0, 	true,	true);
			InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,		    "Seq");
			InitDataProperty(0, cnt++ , dtCombo,		120,	daLeft,		true,	prefix+	"cost_dtl_cd",	        false,	"",		dfNone,		0,  true,	true);
			InitDataValid(   0,	cnt,  	vtEngUpOther, 	"0123456789");  
			InitDataProperty(0, cnt++ , dtData,	   		100,    daLeft,		true,	prefix+	"eq_no",				false,	"",		dfEngUpKey,	0,	true,	true,11);
			InitDataValid(   0,	cnt,  	vtEngUpOther, 	"0123456789");  
			InitDataProperty(0, cnt++ , dtData,	    	120,    daLeft,		true,	prefix+	"mnr_expn_dtl_nm",		false,	"",		dfNone,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,	prefix+	"mnr_hngr_bar_tp_cd",	false,	"",		dfNone,		0,  true,	true);
			InitDataProperty(0, cnt++ , dtData,			90,	    daRight,	true,	prefix+	"spr_prt_uc_amt",		false,	"",		dfFloat,	2,	true,	true);
			InitDataProperty(0, cnt++ , dtData,			60,	    daCenter,	true,	prefix+	"rpr_qty",			    false,	"",		dfNone,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtAutoSumEx,	90,		daRight,	true,	prefix+	"cost_amt",				false,	"",		dfFloat,	2,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			195,	daLeft,		true,	prefix+	"ord_dtl_rmk",	        false,	"",		dfNone,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"bzc_amt",	            false,	"",		dfFloat,	2,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"file_seq",	            false,	"",		dfFloat,	0,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"cost_cd",	            false,	"",		dfNone,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"mnr_rt_tp_cd",	        false,	"",		dfNone,		0,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,		120,	daRight,	true,	prefix+	"eq_no_check_yn",		false,	"",		dfNone,		0,	true,	true);
	
			SelectionMode   = smSelectionRow;    
			SelectHighLight = true;            
			SelectFontBold  = false;          
			SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
	
			CountPosition = 0;
	
		}
		break;
	
		case 2:      // sheet2 init
		with(sheetObj) {
			// 높이 설정
			var prefix = "";   
	
			style.height = 120; 
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;	
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 10, 100);
	
			var HeadTitle1 = "|Evidence Attached|Evidence Attached|Evidence Attached";
			var HeadTitle2 = "|Seq|File|Download";
	
			var headCount = ComCountHeadTitle(HeadTitle1);									
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(8, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true); 
			InitHeadRow(1, HeadTitle2, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	50,		daCenter,	true,	 prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtDummyCheck,	30,		daCenter,	false,	 prefix + "del_chk")
			InitDataProperty(0, cnt++ , dtPopup,      	180,    daCenter,  	false,   prefix + "org_file_nm",	true,	"",      dfNone,	0,     false,	true,	50);
			InitDataProperty(0, cnt++ , dtImage,      	40,   	daCenter,  	false,   prefix + "file_dw",   		false,	"",      dfNone,	0,     false,	true);
			InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,   prefix + "file_path_nm",	false,	"",      dfNone,	0,     true,	true);
			InitDataProperty(0, cnt++ , dtHidden,     	80,     daCenter,  	false,   prefix + "file_path",   	false,	"",      dfNone,	0,     true,	true);
			InitDataProperty(0, cnt++ , dtHidden,     	80,    	daCenter,  	false,   prefix + "file_seq",		false,	"",      dfNone,	0,     true,	true);										
			InitDataProperty(0, cnt++ , dtHidden,	 	80,		daLeft,		true,	 prefix + "file_dtl_seq",	false,	"",		 dfNone,	0,	   false,	false);
	
			CountPosition = 0;
	
			ImageList(0)= "/hanjin/img/ico_attach.gif";
			ShowButtonImage = 1;    
		} 		  
	
		break;
	
		case 3:      // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
	
			var HeadTitle1 = "MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|EQ_KND_CD|MNR_GRP_TP_CD|MNR_WO_TP_CD|COST_CD|TRSM_MOD_CD|AGMT_OFC_CTY_CD|AGMT_SEQ"                                                                                                                                                                                                 
				+ "|AGMT_VER_NO|CURR_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|ORD_ISS_OFC_CD|MNR_ORD_SND_DT|COST_OFC_CD|VNDR_SEQ"                                                                                                                                                                                                 
				+ "|SPR_PRT_SPL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|SPR_PRT_BRTH_DT|SPR_PRT_SPL_YD_CD|SPR_PRT_SPL_DT|ORD_HDR_RMK"                                                                                                                                                                                              
				+ "|FILE_SEQ|MNR_INP_DT|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT" ;
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 10, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false)
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet3_";
	
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_ord_ofc_cty_cd",	false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                   
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_ord_seq",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"eq_knd_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                            
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_grp_tp_cd",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                        
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_wo_tp_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                         
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cost_cd",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                              
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"trsm_mod_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"agmt_ofc_cty_cd",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                      
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"agmt_seq",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                             
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"agmt_ver_no",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"curr_cd",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                              
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_agmt_amt",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                         
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_wrk_amt",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"inv_amt",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                              
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"ord_iss_ofc_cd",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                       
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_ord_snd_dt",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                       
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cost_ofc_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"vndr_seq",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                             
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_spl_tp_cd",	false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                    
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"vsl_cd",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                               
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"skd_voy_no",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"skd_dir_cd",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_brth_dt",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                      
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_spl_yd_cd",	false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                    
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"spr_prt_spl_dt",		false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                       
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"ord_hdr_rmk",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"file_seq",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                          
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"mnr_inp_dt",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cre_usr_id",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"cre_dt",				false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                               
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"upd_usr_id",			false,	"",		dfNone,		0,	true,true);                                                                                                                                                                                                                                           
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	prefix+	"upd_dt",				false,	"",		dfNone,		0,	true,true);   
	
			SelectionMode   = smSelectionRow;    
			SelectHighLight = true;            
			SelectFontBold  = false;          
			SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
	
			CountPosition = 0;
	
		}
		break;
	
		}
	}

	function checkSheetStatus(sheetObj){
	
		var flag=true;
		var sRow = sheetObj.FindStatusRow("I|U|D");  // sheet 에 수정된 내용이 있는지 확인
		if(sRow != "") // sheet 수정내용 있음
		{                               	
			flag=false;
		}
	
		return flag
	}
	
	function checkWorkOrderNo(sheetObj, formObj, sAction){
	
		var flag=true;
	
		if( formObj.mnr_ord_seq.value =="" || formObj.mnr_ord_seq.value==null)
		{
			ComShowCodeMessage("MNR00172",'W/O No');   
			ComSetFocus(formObj.mnr_ord_seq);
	
			flag=false;
		}
		return flag
	}
	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCLEAR:
				doIBCLEAR(sheetObj, formObj, sAction);
				break;
			case IBSEARCH:      //조회
				if(checkSheetStatus(sheetObj))
				{
					if(checkWorkOrderNo(sheetObj, formObj, sAction))
					{
						doIBSEARCH(sheetObj, formObj, sAction); 
					}
				}
				else
				{
					if(ComShowCodeConfirm("MNR00007"))
					{
						if(checkWorkOrderNo(sheetObj, formObj, sAction))
						{
							doIBSEARCH(sheetObj, formObj, sAction);
						}
					}
				}
				break;
			case IBDOWNEXCEL:
				sheetObj.SpeedDown2Excel(-1);
				break;
		}
	}
	
	function doIBSEARCH(sheetObj, formObj, sAction){
		nowLoad = 1;
		formObj.f_gubuns.value = "popup";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(strMnrOrdSeq.length > 3)
		{
			strMnrOrdSeq=strMnrOrdSeq.substring(3);
			if(!ComIsNumber(strMnrOrdSeq))
			{
	
				ComShowCodeMessage("MNR00003");
				ComSetObjValue(formObj.mnr_ord_seq, "");  
				ComSetFocus(formObj.mnr_ord_seq);  
				return false;
			}
		}else{
	
			ComShowCodeMessage("MNR00003");
			ComSetObjValue(formObj.mnr_ord_seq, "");  
			ComSetFocus(formObj.mnr_ord_seq);  
			return false;
		}		
		MnrWaitControl(true);
		formObj.f_cmd.value = SEARCH; 
		var sParam = "";
		var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_");
	
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
	
		var sXml   = sheetObj.GetSearchXml("EES_MNR_0227GS.do", sParam);
		arrDataSearchDbXml = sXml.split("|$$|");
	
		for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
			if(i==0)continue;
			sheetObjects[i].Redraw = false;
			if (i > 0) {
				sheetObjects[i].WaitImageVisible = false;
			}
			sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
			sheetObjects[i].Redraw = true;
		}   
	
	
	}
	
	function doIBCLEAR(sheetObj, formObj, sAction){
		MnrWaitControl(true);
		formObj.f_gubuns.value = "popup";
		formObj.showDate.value = ComGetNowInfo();
	
		formObj.pic_eng_nm.value="";
		formObj.eff_dt.value = "";
		formObj.exp_dt.value = "";
	
		formObj.curr_cd.value = "";
		formObj.cost_cd.value = "";
		formObj.combo_vndr_seq.Code="-1";
		formObj.combo_vndr_seq.RemoveAll();
		formObj.combo_vndr_seq.Code="-1";
		formObj.combo_cost_cd.RemoveAll();
		formObj.ord_hdr_rmk.value="";
		combo_eq_knd_cd_Initialize();
		combo_vndr_seq_Initialize();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		MnrWaitControl(false);
	}
	
	/**
	 * 콤보 값조회(Agreement No) 초기화
	 * @return
	 */
	function combo_vndr_seq_Initialize(){
		var formObj = document.form;
		var sXml = MnrAGMTHdrCombo(sheetObjects[0],formObj.cost_ofc_cd.value);
		var arrResult = MnrXmlToArray(sXml);	
	
		if(arrResult != null){	 	     
			for(var i = 0; i < arrResult.length;i ++){
				var tempComboText = arrResult[i][8]       //8 vndr_nm|
				                 + "|" + arrResult[i][1]  //1 vndr_seq|
				                 + "|" + arrResult[i][9]  //9 agmt_no|
				                 + "|" + arrResult[i][30]  //29 agmt_ofc_cd|
				                 + "|" + arrResult[i][3]   //3eq_type_name|
				                 + "|" + arrResult[i][13] +"~" + arrResult[i][15]  //  13 eff_dt - 15 exp_dt|
				                 + "|" + arrResult[i][2] //2 agmt_ref_no| 
				                 + "|" + arrResult[i][25]   //25 trf_no|
				                 + "|" + arrResult[i][14] //14 curr_cd|
				                 + "^" + arrResult[i][12]   //12 agmt_ver_no|
				                 + "^" + arrResult[i][28]   //28eq_knd_cd|
				                 ;			

				formObj.combo_vndr_seq.InsertItem(i, tempComboText ,arrResult[i][1]); 
			}	
	
		} else {		
			ComShowCodeMessage("MNR00056");         
		} 	  
		formObj.combo_vndr_seq.Code="";
	}
	
	
	function combo_cost_cd_Initialize(eqtype){
		var formObj = document.form;
		formObj.combo_cost_cd.Code2="-1";
		formObj.combo_cost_cd.RemoveAll();
	
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd",eqtype, "CUSTOM6") //Cost Type
		);
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{ 
					var tempText = comboList[i][j].split("|");   

					if(i==0) 
					{
						if(tempText[0]!="MRRUSP"){  //MRRUSP일때 안보여지게
							formObj.combo_cost_cd.InsertItem(j, tempText[1] ,tempText[0]);
						}						
					}
				}
			}
		}
		
		formObj.combo_cost_cd.Code = OrgCostType;
	}
	
	function combo_eq_knd_cd_Initialize(){
		var formObj = document.form;
		formObj.combo_eq_knd_cd.Code2="-1";
		formObj.combo_eq_knd_cd.RemoveAll();
	
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd","CD00002", "COMMON") //EQ Type	
		);
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{ 
					var tempText = comboList[i][j].split("|");   

					if(i==0) 
					{
						formObj.combo_eq_knd_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
					}
				}
				if(i ==0)
				{	
					formObj.combo_eq_knd_cd.Code = "";     	
				}
			}
		}
	}
	
	function combo_eq_knd_cd_OnChange(indexCode, Text){
		if(Text == null) return;
		combo_cost_cd_Initialize(Text);
	}
	
	/**
	 * COMBO 변경 이벤트
	 * Cost Type 변경시 Sheet 의 컬럼 Display 설정
	 * @param indexCode
	 * @param Text
	 * @return
	 */
	function combo_cost_cd_OnChange(indexCode, Text){
		setSheetColumnDisplay(Text);  //Cost Type 콤보값에 따라 Sheet 의 컬럼 Display 설정
		
		var formObj = document.form;
		if((sheetObjects[0].RowCount) > 0  && nowLoad == 0){
			for(var i = 0; i < sheetObjects[0].DataRows; i ++ ){
				var tmpEx = sheetObjects[0].CellValue(i, "cost_dtl_cd");
				if(tmpEx != Text){
					if(ComShowCodeConfirm("MNR00080")){ 
						sheet1_cost_dtl_cd_Initialize(Text);
						sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
						sheetObjects[1].RemoveAll();
						sheetObjects[2].RemoveAll();
					}else{
						formObj.combo_cost_cd.Code2 = OrgCostType;
						setSheetColumnDisplay(OrgCostType);  //Cost Type 콤보값에 따라 Sheet 의 컬럼 Display 설정 원복
						break;
					}
				}
			}
		
		}else{   
			sheet1_cost_dtl_cd_Initialize(Text);
			sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
		}
	
		OrgCostType = formObj.combo_cost_cd.Code;
	}
	function combo_vndr_seq_OnChange(indexCode, Text){
		var formObj = document.form;
		var strEtc =formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index,  8 );
		var spltEtc =strEtc.split("^");
		formObj.pic_eng_nm.value = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index, 0 );
		formObj.curr_cd.value =  spltEtc[0];
	
		var strAgmtNo =formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index,  2 ); 
		if(strAgmtNo.length > 3)
		{
			formObj.agmt_ofc_cty_cd.value=strAgmtNo.substring(0,3); 
			formObj.agmt_seq.value=strAgmtNo.substring(3); 
		}
	
		var strAgmtVerNo=spltEtc[1];
		if ( ComIsNumber(strAgmtVerNo))
		{
			formObj.agmt_ver_no.value= strAgmtVerNo;
		}
		var arr = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index,  5 ).split("~");
		var tmpEffFrom = "";
		var tmpEffTo   = "";
			
		if(arr==""){
			tmpEffFrom = "";
			tmpEffTo   = "";
		}else{
			tmpEffFrom = arr[0];
			tmpEffTo   = arr[1];
		}	
		
		formObj.eff_dt.value = tmpEffFrom.trim();
		formObj.exp_dt.value = tmpEffTo.trim();
	
		formObj.combo_eq_knd_cd.Code2 =  spltEtc[2];
		combo_cost_cd_Initialize(formObj.combo_eq_knd_cd.Code);
		if((sheetObjects[0].RowCount) > 0  && nowLoad == 0){
			if(ComShowCodeConfirm("MNR00080")){ 
				sheet1_cost_dtl_cd_Initialize(Text);
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			}else{
				formObj.combo_cost_cd.Code2 = OrgCostType;
			}
		}
	}
	
	//Extra Expense Type Sheet Combo 
	function sheet1_cost_dtl_cd_Initialize(costtype){
		if(nowLoad==0)sheetObjects[0].RemoveAll();
	
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd",costtype, "COMMON") //Service Sub Type
		);
		costDtlCode = "";
		costDtlDesc = "";
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{ 
					var tempText = comboList[i][j].split("|");   

					if(i==0) 
					{
						costDtlCode = costDtlCode + tempText[0] + "|";
						costDtlDesc = costDtlDesc + tempText[1] + "|";
					}
				}
				if(i==0)
				{
					costDtlCode = costDtlCode.substring(0, costDtlCode.length - 1);
					costDtlDesc = costDtlDesc.substring(0, costDtlDesc.length - 1);
					sheetObjects[0].InitDataCombo(0, "sheet1_cost_dtl_cd", costDtlDesc, costDtlCode, costDtlCode.substring(0,costDtlCode.indexOf("|")) );
				}
			}
		}
	}
	
	//MNR_HNGR_BAR_TP_CD Sheet Combo 
	function sheet1_mnr_hngr_bar_tp_cd_Initialize(costtype){
	
		if(nowLoad==0)sheetObjects[0].RemoveAll();
	
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var sCondition = new Array (
				new Array("MnrGenCd",costtype, "COMMON") //Service Sub Type
		);
		mnrHngrBarTpCode = "";
		mnrHngrBarTpDesc = "";
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		for(var i = 0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{ 
					var tempText = comboList[i][j].split("|");   

					if(i==0) 
					{
						mnrHngrBarTpCode = mnrHngrBarTpCode + tempText[0] + "|";
						mnrHngrBarTpDesc = mnrHngrBarTpDesc + tempText[1] + "|";
					}
				}
				if(i==0)
				{
					mnrHngrBarTpCode = mnrHngrBarTpCode.substring(0, mnrHngrBarTpCode.length - 1);
					mnrHngrBarTpDesc = mnrHngrBarTpDesc.substring(0, mnrHngrBarTpDesc.length - 1);
					sheetObjects[0].InitDataCombo(0, "sheet1_mnr_hngr_bar_tp_cd", mnrHngrBarTpDesc, mnrHngrBarTpCode, mnrHngrBarTpCode.substring(0,mnrHngrBarTpCode.indexOf("|")) );
				}
			}
		}
	}
	

	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") { 
				if(strMnrOrdSeq=="" || strMnrOrdSeq=="NEW" )
				{
					ComShowCodeMessage("MNR00073");
	
				}else{
					ComShowCodeMessage("MNR00222");
				}
			} else { 
				ComShowCodeMessage("MNR00074",ErrMsg);
			}
		}else if(formObj.f_cmd.value == REMOVE)
		{
			if (errMsg == "") { 
				ComShowCodeMessage("MNR00082",ErrMsg);
			} else { 
				ComShowCodeMessage("MNR00027",ErrMsg);
			}
		}
		nowLoad = 0;
		MnrWaitControl(false);
	}
	
	
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		var formObj = document.form;
		if(formObj.combo_cost_cd.Code != "MRDRHG")
		{ 
			if(sheetObj.ColSaveName(NewCol) == "sheet1_eq_no")
			{
				sheetObj.SelectCell(NewRow, "sheet1_mnr_expn_dtl_nm",true);
			}
			if(sheetObj.ColSaveName(NewCol) == "sheet1_mnr_hngr_bar_tp_cd")
			{
				sheetObj.SelectCell(NewRow, "sheet1_spr_prt_uc_amt",true);
			}
			if(sheetObj.ColSaveName(NewCol) == "sheet1_cost_amt")
			{
				sheetObj.CellEditable(NewRow, NewCol) =false;
			}
	
		}else{
			if(sheetObj.ColSaveName(NewCol) == "sheet1_cost_amt")
			{
				sheetObj.CellEditable(NewRow, NewCol) =true;
			}
		}
	
		if(sheetObj.ColSaveName(OldCol) == "sheet1_eq_no" && formObj.combo_cost_cd.Code == "MRDRHG"){
			sheet1_eq_no_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol);
			return false;
		}
	
	
		if(OldRow !=NewRow)
		{
			if (nowLoad != 0) return;
	
			if(formObj.combo_cost_cd.Code == "MRDRHG"){ 
	
				sheetObj.CellBackColor(NewRow,"sheet1_eq_no") = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
				sheetObj.CellEditable(NewRow,"sheet1_eq_no") = true;
				sheetObj.CellBackColor(NewRow,"sheet1_mnr_hngr_bar_tp_cd") = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);
				sheetObj.CellEditable(NewRow,"sheet1_mnr_hngr_bar_tp_cd") = true;
	
			}else
			{
				sheetObj.CellBackColor(NewRow,"sheet1_eq_no") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);	
				sheetObj.CellEditable(NewRow,"sheet1_eq_no") = false;
				sheetObj.CellBackColor(NewRow,"sheet1_mnr_hngr_bar_tp_cd") = sheetObj.RgbColor(SheetNoEditBackColorR,SheetNoEditBackColorG,SheetNoEditBackColorB);	
				sheetObj.CellEditable(NewRow,"sheet1_mnr_hngr_bar_tp_cd") = false;
	
			}
			return;
		}
	}	 
	
	
	/**
	 * 파일 다운받기 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	sheetObj의 선택된 Row
	 * @param {ibsheet} Col     	sheetObj의 선택된 Col
	 * @param {String} 	Value     	파일명
	 **/  
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix = "";  
	
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.RowStatus(Row)=="I")return;
	
		if(sheetObj.CellText(Row, prefix+"file_path_nm") == "") return;
	
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_path_nm");
		return;
	}  
	
	function sheet3_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
		var prefix = "sheet3_";
		if(sheetObj.RowCount <=0)
		{
			nowLoad = 0;
			doIBCLEAR(sheetObjects[0], formObj, IBCLEAR);
			ComSetObjValue(formObj.mnr_ord_seq, "");  
			ComShowCodeMessage("MNR00005", "W/O No.");  
	
			ComSetFocus(formObj.mnr_ord_seq); 
			MnrWaitControl(false);
			return false;
		}
		
		formObj.combo_vndr_seq.UseCode = false;
		var agree_no = sheetObjects[2].CellValue(1, prefix+ "agmt_ofc_cty_cd")
		               + ComLpad(sheetObjects[2].CellValue(1, prefix+ "agmt_seq"),6,"0");
		formObj.combo_vndr_seq.Index = formObj.combo_vndr_seq.FindIndex(agree_no,2);
		formObj.combo_vndr_seq.UseCode = true;
		
		formObj.pic_eng_nm.value = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index, 0 );
		formObj.vndr_seq.value = formObj.combo_vndr_seq.GetIndexText(formObj.combo_vndr_seq.Index, 2 ) ;
		formObj.combo_eq_knd_cd.Code2 = sheetObjects[2].CellValue(1, prefix+ "eq_knd_cd");
		formObj.eq_knd_cd.value=formObj.combo_eq_knd_cd.Text;
		formObj.curr_cd.value   = sheetObjects[2].CellValue(1, prefix+ "curr_cd");
		formObj.agmt_ofc_cty_cd.value=sheetObjects[2].CellValue(1, prefix+ "agmt_ofc_cty_cd");
		formObj.agmt_seq.value=sheetObjects[2].CellValue(1, prefix+ "agmt_seq");
		formObj.agmt_ver_no.value=sheetObjects[2].CellValue(1, prefix+ "agmt_ver_no");
		formObj.file_seq.value=sheetObjects[2].CellValue(1, prefix+ "file_seq");
		formObj.showDate.value=sheetObjects[2].CellValue(1, prefix+ "cre_dt");
	
		var costcd = sheetObjects[2].CellValue(1, prefix+ "cost_cd"); 
	
		combo_cost_cd_Initialize(formObj.combo_eq_knd_cd.Code);
		formObj.combo_cost_cd.Code = costcd;
		formObj.cost_cd.value=formObj.combo_cost_cd.Text;
		formObj.ord_hdr_rmk.value=sheetObjects[2].CellValue(1, prefix+ "ord_hdr_rmk");
	
		for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
			if(i>0)break;
			sheetObjects[i].Redraw = false;
			if (i > 0) {
				sheetObjects[i].WaitImageVisible = false;
			}
			sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
			sheetObjects[i].Redraw = true;
		}   
		var prefix = "sheet1_";
		var ArrCostDtlDesc=costDtlDesc.split("|");
		var ArrMnrHngrBarTpCdDesc=mnrHngrBarTpDesc.split("|");
		for(var i=1;i<=sheetObjects[0].RowCount;i++)
		{
			var idx   = sheetObjects[0].GetComboInfo(i, prefix+ "cost_dtl_cd", "SelectedIndex");
			var idx2   = sheetObjects[0].GetComboInfo(i, prefix+ "mnr_hngr_bar_tp_cd", "SelectedIndex");
			sheetObjects[0].CellText(i, prefix+ "cost_dtl_cd")=ArrCostDtlDesc[idx];
			sheetObjects[0].CellText(i, prefix+ "mnr_hngr_bar_tp_cd")=ArrMnrHngrBarTpCdDesc[idx2];
		}
		var fileSeq=	formObj.file_seq.value;
		if(fileSeq != "" || fileSeq != undefined){ 
			var fileXml = SearchFileUpload(sheetObjects[1],fileSeq);
			sheetObjects[1].LoadSearchXml(fileXml);   				
		}	
	
	
		nowLoad = 0;
		MnrWaitControl(false);
	}
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with (formObj) {
	
			if (!ComChkObjValid(formObj))
				return false;
	
		}
		return true;
	}
	
	/**
	 * IBSheet의 각 탭에 대한 Row를 추가한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {없음}
	 **/
	function file_Insert(sheetObj){ 
		MnrWaitControl(true);
	
		uploadFileSeq = sheetObj.CellValue(2,"file_seq");
	
		if(uploadFileSeq == undefined){ 	 
			uploadFileSeq = "";	
		}
	
		var row =sheetObj.DataInsert(-1); 
		sheet2_OnPopupClick(sheetObj,row,2);
	}  
	
	function file_Remove(sheetObj) { 		  
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			if(sheetObj.RowCount ==1 )
			{
				document.form.file_seq.value="0";
				MnrWaitControl(false);
			}
			RemoveFileUpload(sheetObj);	         	 		
		} else {			      
			ComShowCodeMessage("MNR00150");   	   
		}	 
	}       
	
	/**
	 * Cost Type 콤보값에 따라 Sheet 의 컬럼 Display 설정
	 * @param costType
	 * @return
	 */
	function setSheetColumnDisplay(costType) {
		//Container - Hanger
		if (costType=="MRDRHA" || costType=="MRDRHD") {
			sheetObjects[0].ColHidden("sheet1_eq_no")=false;				//EQ No
			sheetObjects[0].ColHidden("sheet1_mnr_hngr_bar_tp_cd")=false;	//Hanger Bar Type
			sheetObjects[0].ColHidden("sheet1_rpr_qty")=false;				//Hanger Bar Qty
			sheetObjects[0].ColHidden("sheet1_mnr_expn_dtl_nm")= true;		//Description
			sheetObjects[0].ColHidden("sheet1_spr_prt_uc_amt")=true;		//Unit Price
			sheetObjects[0].ColHidden("sheet1_bar_if_chk")=false;		//bar_if_chk


			sheetObjects[0].CellValue(0,"sheet1_rpr_qty")="Hanger Bar QTY";	
			sheetObjects[0].ColWidth("sheet1_rpr_qty")= 100;
		} else { 	 
			//Chassis - Pre-Maintenance
			if(costType=="MRZSPR") {
				sheetObjects[0].ColHidden("sheet1_eq_no")=false;	//EQ No
			} else {
				sheetObjects[0].ColHidden("sheet1_eq_no")=true;		//EQ No
			}
			if(costType=="MRDROT" || costType=="MRZSOT" || costType=="MRGSOT" || costType=="MRZSTP" || costType=="MRZSTR") { //other일때 와 Tire Purchase, Tire Replace일때  qty 보여줌 0331
				sheetObjects[0].ColHidden("sheet1_rpr_qty")=false;
			}else{
				sheetObjects[0].ColHidden("sheet1_rpr_qty")=true;
			}	

			sheetObjects[0].ColHidden("sheet1_bar_if_chk")=true;		//bar_if_chk
			sheetObjects[0].ColHidden("sheet1_mnr_hngr_bar_tp_cd")=true;	//Hanger Bar Type
			
			sheetObjects[0].ColHidden("sheet1_mnr_expn_dtl_nm")= false;		//Description
			sheetObjects[0].ColHidden("sheet1_spr_prt_uc_amt")=false;		//Unit Price
			
			sheetObjects[0].CellValue(0,"sheet1_rpr_qty")="Q'ty";
			sheetObjects[0].ColWidth("sheet1_rpr_qty")= 60;
		}

		//Chassis - The Pachase
		if(costType=="MRZSTP"){
			sheetObjects[0].CellValue(0,"sheet1_mnr_expn_dtl_nm")="Brand";
		}else{
			sheetObjects[0].CellValue(0,"sheet1_mnr_expn_dtl_nm")="Description";
		}
	}
	/* 개발자 작업  끝 */
	