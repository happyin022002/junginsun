	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0266.js 
	 *@FileTitle : Spare Part VSL Inventory Code
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2014.12.02
	 *@LastModifier : 차상영
	 *@LastVersion : 1.0
	 * 2014.12.02 차상영
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
	 * @class ees_mnr_0266 : ees_mnr_0266 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0266() {
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
	
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var comboListVndr;
	var comboListMdlNm;
	var comboListTpCd;
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
	
			case "btn_new":
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
			case "btn_save":			
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);				
				break; 
			case "btn_del" :
				if(ComShowCodeConfirm("MNR00026")){
					doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
				}				
						
				break;
			case "btn_add":
				doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
				break;
				
			case "btn_row_del":
				var selChk = sheetObjects[0].FindCheckedRow("sel_chk");
				if(selChk == ""){ 
					ComShowCodeMessage("MNR00038", "");
					return false;             	   
				}
				
				ComRowHideDelete(sheetObjects[0], "sel_chk");				
								
				break;
			
			case "btn_upload" :
				doActionIBSheet(sheetObjects[1], formObject, IBLOADEXCEL);
				break;
			case "btn_format_down" :
				var cnt=sheetObjects[0].RowCount;
				if(cnt<=0) {
					var Row = sheetObjects[0].DataInsert(-1); 
				}
				sheetObjects[0].SpeedDown2Excel(-1, false,false,"", "",false,false,"",false,"sel_chk|spr_prt_lst_amt|spr_prt_ver_seq|cre_dt"); 	
				
				break;
			case "btn_downexcel":
				sheetObjects[0].SpeedDown2Excel();
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
					style.height = 422;
		
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
			
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
			
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
			
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
					
					var HeadTitle1 = "|SEL.|PRT Seq|Seq|Maker|Model|Type|The Last Price|Current Price|Remarks|Ver.|Create Date";
					var headCount = ComCountHeadTitle(HeadTitle1);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
			
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
			
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
		            
		            //데이터속성    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++,		dtHiddenStatus,			20,			daCenter,		true,     "ibflag");
		            InitDataProperty(0, cnt++,		dtCheckBox,				30,			daCenter,		true,     "sel_chk");                        
		            InitDataProperty(0, cnt++,		dtHidden,				0,			daCenter,		true,     "spr_prt_seq",		false,		"",         dfNone,     	0,          false,      false);             
		            InitDataProperty(0, cnt++,		dtData,					40,			daCenter,		true,     "spr_prt_dp_seq",		false,		"",         dfNone,     	0,          true,       true);
		            InitDataProperty(0, cnt++,		dtCombo,				370,		daLeft,			true,     "spr_prt_vndr_seq",	false,		"",      	dfNone,			0,			false,		true);
		            InitDataProperty(0, cnt++,		dtCombo,				150,		daLeft,			true,     "spr_ut_mdl_nm",		false,		"",         dfNone,     	0,          false,      true);
		            InitDataProperty(0, cnt++,		dtCombo,				50,			daCenter,		true,     "spr_prt_tp_cd",		false,		"",         dfNone,     	0,          false,      true);
		            InitDataProperty(0, cnt++,		dtData,					100,		daRight,		true,     "spr_prt_lst_amt",	false,		"",         dfNumber,     	0,          false,      false);
		            InitDataProperty(0, cnt++,		dtData,					100,		daRight,		true,     "spr_prt_crnt_amt",	false,		"",         dfNumber,     	0,          true,      	true);           
		            InitDataProperty(0, cnt++,		dtData,					150,		daCenter,		true,     "spr_prt_rmk",		false,		"",         dfNone,     	0,          true,      	true);
		            InitDataProperty(0, cnt++,		dtHidden,				40,			daCenter,		true,     "spr_prt_ver_seq",	false,		"",         dfNone,     	0,          false,      false);		            
		            InitDataProperty(0, cnt++,		dtHidden,				40,			daCenter,		true,     "cre_dt",				false,		"",         dfNone,     	0,          false,      false);
		            
					InitDataCombo (0, "spr_prt_tp_cd", " |A|B", "N|A|B");
					
					InitDataValid(0, "spr_prt_dp_seq", vtNumericOnly);
					
				}// end of with
				
				break;
	
			case 2:      // sheet2 init 엑셀 업로드용 숨김 그리드
				with (sheetObj) {
					// 높이 설정
					style.height = 422;
		
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
			
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
			
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
			
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, 100);
					
					var HeadTitle1 = "|Seq|Maker|Model|Type|Current Price|Remarks";
					var headCount = ComCountHeadTitle(HeadTitle1);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
			
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
			
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
		            
		            //데이터속성    [ROW, COL, DATATYPE,        WIDTH, DATAALIGN, COLMERGE,  SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++,		dtHiddenStatus,			20,			daCenter,		true,     "ibflag");		                                 		                        
		            InitDataProperty(0, cnt++,		dtData,					40,			daCenter,		true,     "spr_prt_dp_seq",		false,		"",         dfNone,     	0,          true,       true);
		            InitDataProperty(0, cnt++,		dtData,					370,		daLeft,			true,     "spr_prt_vndr_seq",	false,		"",      	dfNone,			0,			false,		true);
		            InitDataProperty(0, cnt++,		dtData,					150,		daLeft,			true,     "spr_ut_mdl_nm",		false,		"",         dfNone,     	0,          false,      true);
		            InitDataProperty(0, cnt++,		dtData,					50,			daCenter,		true,     "spr_prt_tp_cd",		false,		"",         dfNone,     	0,          false,      true);		           
		            InitDataProperty(0, cnt++,		dtData,					100,		daRight,		true,     "spr_prt_crnt_amt",	false,		"",         dfNumber,     	0,          true,       true);           
		            InitDataProperty(0, cnt++,		dtData,					150,		daCenter,		true,     "spr_prt_rmk",		false,		"",         dfNone,     	0,          true,       true);		            			
					
				}// end of with
				
				break;			
			
		}// end of switch
	}
	
	
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObject = document.form;
		
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}		
		
		/** 2014.12.03 조회 콤보 숨김		
		//콤보 초기화 
		for(var i = 0; i < comboObjects.length;i++){ 
			comboObjects[i].RemoveAll();       
		}  			
		
		//콤보 초기화 
		for(var k=0;k<comboObjects.length;k++){ 
			initCombo(comboObjects[k], k+1);  
		}
		**/
		
		//조회 콤보 및 sheet 콤보 데이터 설정
		doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObjects[0]); //Maker
		doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC02,comboObjects[1]); //Model
				
		//로딩시 그리드 데이터 조회
		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		
	}
	
	
	/**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {        
	    var formObject = document.form;
	    
	    switch(comboNo) {     
		  case 1: 
			   with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;				  
					SetColAlign("center|left");        
					SetColWidth("70|370");         
					DropHeight = 160;                         
			   }			   
			   
			   break;   
		  case 2: 
			   with (comboObj) { 
					MultiSelect = false; 
					UseAutoComplete = true;				  
					SetColAlign("center");        
					SetColWidth("30|100");         
					DropHeight = 180; 
			   }			   
			   
			   break; 
		  
		 } 
	}
	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {			
			case IBCLEAR :
				
				formObj.new_yn.value = "Y"; //new 버튼 클릭 flag
				ComBtnDisable("btn_new");
				
				for(var i=sheetObj.HeaderRows; i<sheetObj.Rows; i++) {	
					sheetObj.CellValue2(i, "spr_prt_lst_amt") = sheetObj.CellValue(i, "spr_prt_crnt_amt");
					sheetObj.CellValue2(i, "spr_prt_crnt_amt") = "";
				}
				
				break;	
		
			case IBSEARCH:      //조회
				sheetObj.RemoveAll();
			
				formObj.f_cmd.value = SEARCH; 
				
				var sXml   = sheetObj.GetSearchXml("EES_MNR_0266GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml);
							
				formObj.new_yn.value = ""; //new 버튼 클릭 flag
				ComBtnEnable("btn_new");
				
				break;		
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				formObj.f_cmd.value = MULTI;
	
				//New 버튼 클릭시 그리드의 모든 행을 업데이트 플래그로 바꿔줌(변동되지 않는 행은 서버단에 넘어가지 않기 때문에)
				if(formObj.new_yn.value == "Y") {					
					for(var i=sheetObj.HeaderRows; i<sheetObj.Rows; i++) {	
						sheetObj.CellValue2(i, "ibflag") = "U";
					}					
				}
				
				var sParam = ComGetSaveString(sheetObj, false);
			    sParam += "&" + FormQueryString(formObj);
	      	
	        	var sXml = sheetObj.GetSaveXml("EES_MNR_0266GS.do", sParam);	
	        	var svcResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				sheetObj.LoadSaveXml(sXml);
				
				if (svcResult == "S") {	
					doActionIBSheet(sheetObj,document.form,IBSEARCH);			
				}
				
				break;
			case IBINSERT:      // 입력
				
				var row = sheetObj.DataInsert(-1);					
				sheetObj.CellValue2(row, "spr_prt_lst_amt") = "0";
				sheetObj.CellValue2(row, "spr_tp_cd") = "";
				
	            break;
			case IBDELETE:
				
				for(var i=sheetObj.HeaderRows; i<sheetObj.Rows; i++) {	
					sheetObj.CellValue2(i, "ibflag") = "D";
				}
				
				formObj.f_cmd.value = MULTI;
				
				var sParam = ComGetSaveString(sheetObj, false);
			    sParam += "&" + FormQueryString(formObj);
						    
				var sXml = sheetObj.GetSaveXml("EES_MNR_0266GS.do", sParam);
				var svcResult = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				sheetObj.LoadSaveXml(sXml);
				
				if (svcResult == "S") {				
					doActionIBSheet(sheetObj,document.form,IBSEARCH);
				}
				
	            break;
			case IBLOADEXCEL :
				sheetObjects[1].LoadExcel(-1,1,"","-1","-1","",false,false,""); 				
				
				//maker, model 엑셀 데이터 유효성 검사 및  코드값만 그리드에 남김
				var spr_prt_vndr_seq;
				var spr_ut_mdl_nm;
				var spr_prt_tp_cd;
				for(var i=sheetObjects[1].HeaderRows; i<sheetObjects[1].Rows; i++) {
					spr_prt_dp_seq = sheetObjects[1].CellValue(i, "spr_prt_dp_seq");
					spr_prt_vndr_seq = sheetObjects[1].CellValue(i, "spr_prt_vndr_seq");
					spr_ut_mdl_nm = sheetObjects[1].CellValue(i, "spr_ut_mdl_nm");
					spr_prt_tp_cd = sheetObjects[1].CellValue(i, "spr_prt_tp_cd");
					
					if(spr_prt_dp_seq=="") {
						ComShowCodeMessage("MNR00010","Upload Data(Seq)"); //{?msg1} is invalid.
						return;
					}			
					if(!ComIsNumber(spr_prt_dp_seq)) {
						ComShowCodeMessage("MNR00010","Upload Data(Seq)"); //{?msg1} is invalid.
						return;						
					}
					
					
					if(spr_prt_vndr_seq=="" || spr_prt_vndr_seq.length < 6) {
						ComShowCodeMessage("MNR00010","Upload Data(Maker)"); //{?msg1} is invalid.
						return;
					}
					if(spr_ut_mdl_nm=="" || spr_ut_mdl_nm.length < 2) {
						ComShowCodeMessage("MNR00010","Upload Data(Model)"); //{?msg1} is invalid.
						return;
					}					
					if(spr_prt_tp_cd=="" || spr_prt_tp_cd==" ") {
						spr_prt_tp_cd = "N";
					}
						
					sheetObjects[1].CellValue2(i, "spr_prt_vndr_seq") = spr_prt_vndr_seq.substr(0,6);
					sheetObjects[1].CellValue2(i, "spr_ut_mdl_nm") = spr_ut_mdl_nm.substr(0,2);	
					sheetObjects[1].CellValue2(i, "spr_prt_tp_cd") = spr_prt_tp_cd;
				}
				
				//기존 중복 데이터 덮어쓰기
				//for(var i=sheetObjects[1].HeaderRows; i<sheetObjects[1].Rows; i++) {		
				for(var i = sheetObjects[1].Rows; sheetObjects[1].HeaderRows<=i; i--) {
					for(var j=sheetObjects[0].HeaderRows; j<sheetObjects[0].Rows; j++) {						
						
						if(sheetObjects[1].CellValue(i, "spr_prt_vndr_seq")==sheetObjects[0].CellValue(j, "spr_prt_vndr_seq") &&
							sheetObjects[1].CellValue(i, "spr_ut_mdl_nm")==sheetObjects[0].CellValue(j, "spr_ut_mdl_nm") &&	
							sheetObjects[1].CellValue(i, "spr_prt_tp_cd")==sheetObjects[0].CellValue(j, "spr_prt_tp_cd")) {	

							sheetObjects[0].CellValue2(j, "spr_prt_dp_seq") = sheetObjects[1].CellValue(i, "spr_prt_dp_seq");
							sheetObjects[0].CellValue2(j, "spr_prt_crnt_amt") = sheetObjects[1].CellValue(i, "spr_prt_crnt_amt");
							sheetObjects[0].CellValue2(j, "spr_prt_rmk") 		= sheetObjects[1].CellValue(i, "spr_prt_rmk");	
							
							sheetObjects[1].RowDelete(i, false);
						}												
					}
				}				
				//신규 데이터 그리드에 추가
				for(var i=sheetObjects[1].HeaderRows; i<sheetObjects[1].Rows; i++) {	
					var row = sheetObjects[0].DataInsert(-1);	
					sheetObjects[0].CellValue2(row, "spr_prt_dp_seq")   = sheetObjects[1].CellValue(i, "spr_prt_dp_seq");
					sheetObjects[0].CellValue2(row, "spr_prt_vndr_seq") = sheetObjects[1].CellValue(i, "spr_prt_vndr_seq");
					sheetObjects[0].CellValue2(row, "spr_ut_mdl_nm") 	= sheetObjects[1].CellValue(i, "spr_ut_mdl_nm");
					sheetObjects[0].CellValue2(row, "spr_prt_tp_cd") 	= sheetObjects[1].CellValue(i, "spr_prt_tp_cd");
					sheetObjects[0].CellValue2(row, "spr_prt_crnt_amt") = sheetObjects[1].CellValue(i, "spr_prt_crnt_amt");
					sheetObjects[0].CellValue2(row, "spr_prt_rmk") 		= sheetObjects[1].CellValue(i, "spr_prt_rmk");
					sheetObjects[0].CellValue2(row, "spr_prt_lst_amt") 	= "0";											
				}
				
				sheetObjects[1].RemoveAll();
								
				break;
		}
		
	}
	
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {		
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {            					
	        case IBSEARCH_ASYNC01 :
	        	comboListVndr = "";
		 		formObj.f_cmd.value = SEARCH01;
		 		var xmlStr = sheetObj.GetSearchXml("EES_MST_COMGS.do", FormQueryString(formObj));
			    var chk = xmlStr.indexOf("ERROR");
				if (xmlStr.indexOf("ERROR") != -1 || xmlStr.indexOf("Error") != -1){
				   sheetObj.LoadSearchXml(xmlStr);
				   return;
			    }  		
				var sStr = ComGetEtcData(xmlStr, "comboList");
				comboListVndr = sStr.split("@");
				//MakeComboObject(formObj.spr_prt_vndr_seq, comboListVndr, 1, 0); //조회 조건 maker 콤보
				
				setGridCombo(sheetObj, comboListVndr, "spr_prt_vndr_seq"); //그리드  maker 콤보
				
				
				break;
	        case IBSEARCH_ASYNC02 :
	        	comboListMdlNm = "";
	        	//공통콤보 정보를 가져온다.    
				var sCondition = new Array ( 
					new Array("MnrGenCd","CD00096", "COMMON")
				)

				comboListMdlNm = MnrComSearchCombo(sheetObjects[0],sCondition);
				//MakeComboObject(formObj.spr_ut_mdl_nm, comboListMdlNm[0], 1, 0); //조회 조건 model 콤보
				
				setGridCombo(sheetObj, comboListMdlNm[0], "spr_ut_mdl_nm"); //그리드  model 콤보
    		
	        	break;
        }
		
        sheetObj.WaitImageVisible = true;
     }
	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction) {
		var generalCnt = 0;
		
		if (sAction == IBSAVE) {
			if(sheetObj.IsDataModified == false) {
				ComShowCodeMessage('COM130503'); // 'There is no updated data to save.'
				return false;
			}
			
			for(var i=sheetObj.HeaderRows; i<sheetObj.Rows; i++) {	
				if(sheetObj.CellValue(i, "ibflag") != "D") {
					if(sheetObj.CellValue(i, "spr_prt_dp_seq") == "") {
						ComShowCodeMessage("MNR00003","Seq");
						return false;
					}
					if(sheetObj.CellValue(i, "spr_prt_vndr_seq") == "") {
						ComShowCodeMessage("MNR00003","Maker");
						return false;
					}				
					if(sheetObj.CellValue(i, "spr_ut_mdl_nm") == "") {
						ComShowCodeMessage("MNR00003","Model");
						return false;
					}			
					if(sheetObj.CellValue(i, "spr_prt_crnt_amt") == "") {
						ComShowCodeMessage("MNR00003","Current Price");
						return false;
					}
					
					//General(999999) 입력 갯수 카운트
					if(sheetObj.CellValue(i, "spr_prt_vndr_seq") == "999999") {
						if(sheetObj.CellValue(i, "spr_prt_dp_seq") != "99") {						
							ComShowCodeMessage("COM12114","that Seq which is General for Maker must be 99."); //Please check {?msg1}
							return false;
						}
						if(sheetObj.CellValue(i, "spr_ut_mdl_nm") != "GE") {												
							ComShowCodeMessage("COM12114","that Model which is General for Maker must be General(GE)."); //Please check {?msg1}
							return false;
						}
						
						generalCnt = generalCnt + 1;
					}
				}	
			}
						
			if(generalCnt < 1) {
				ComShowCodeMessage("COM12114","that General for Maker must exist at least one."); //Please check {?msg1}
				return false;
			}
			
			//maker, model, type 중복 데이터 체크
			if(sheetObj.ColValueDup("spr_prt_vndr_seq|spr_ut_mdl_nm|spr_prt_tp_cd", false) > -1) {
				ComShowCodeMessage("MNR00006","Inserted Data");
				return false;
			}
			
		}
		
		return true;
	}
	   	
	
	/**
     * 콤보 오브젝트 생성(Spec No * Type/Size)
     */
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
    	 cmbObj.RemoveAll();
		 cmbObj.InsertItem(0, "", "");
		
		 for (var i=0; i<arrStr.length; i++) {
		    var arrCode = arrStr[i].split("|");

			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
		 }
		 cmbObj.Index2 = "" ;
    }

	/**
	 * 그리드내 Combo 생성
	 */
    function setGridCombo(sheetObj, comboList, targetColumnNm){
    	
		var sheetComboCode = " |"; 
		var sheetComboText = " |"; 
		var sheetComboDefault = " |";   
		
		if(comboList != null) { 	   
			for(var j = 0; j < comboList.length;j++){ 
				var tempText = comboList[j].split("|");
								
				sheetComboCode +=  tempText[0] + "|";    
				//sheetComboText +=  tempText[0] + "\t" + tempText[1] + "|"; 
				sheetComboText +=  tempText[0] + " - " + tempText[1] + "|"; 				
			}	
			
			//Maker 콤보시 General(999999) 항목 추가 설정
			if(targetColumnNm == "spr_prt_vndr_seq") {
				sheetComboCode += "999999";
				sheetComboText += "999999 - General";
			}
			
			sheetObj.InitDataCombo(0, targetColumnNm, sheetComboText, sheetComboCode, sheetComboDefault, sheetComboDefault); 				    
		}
	}

    /**
     * sheet1 OnSearchEnd 이벤트 처리  
     * @param sheetObj
     * @param ErrMsg
     * @return
     */ 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {    	
    	var formObject = document.form;
    	
    	// 현재 버전 번호 및 최근 생성 일자 추출
    	var prevDt;
    	var nextDt;
    	var maxDt = "";
    	var verSeq = "";
    	if((sheetObjects[0].Rows - sheetObjects[0].HeaderRows) > 0) {
	    	for(var i=sheetObjects[0].HeaderRows; i<sheetObjects[0].Rows; i++) {	
	    		for(var j=i+1; j<sheetObjects[0].Rows; j++) {
	    			prevDt = parseInt(ComReplaceStr(sheetObjects[0].CellValue(i,"cre_dt"),"-",""),10);
	    			nextDt = parseInt(ComReplaceStr(sheetObjects[0].CellValue(j,"cre_dt"),"-",""),10);
	    			
	    			if(prevDt <=  nextDt) {
	    				maxDt = nextDt;
	    				verSeq = sheetObjects[0].CellValue(j,"spr_prt_ver_seq");
	    			}
	    		}
	    	}
	    	
	    	if(maxDt != "") { //조홰된 데이터가 있을 때
		    	maxDt = maxDt.toString();
		    	
		    	formObject.txt_ver.value = verSeq;
		    	formObject.txt_cre_dt.value = maxDt.substr(0,4) + "-" + maxDt.substr(4,2) + "-" + maxDt.substr(6,2);
	    	}
    	}
    	

    }	

	/**
	 * Sheet 값이 변경되었을 때
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @param value
	 */    
    function sheet1_OnChange(sheetObj, row, col, value) {
		var formObject = document.form;
		var colName = sheetObj.ColSaveName(col);
		
		switch(colName) {
			case "spr_prt_vndr_seq" : 
				if(sheetObj.CellValue(row,colName) == "999999") { //벤더를 General(999999) 선택시, 모델과 Seq를 GE, 99 로 설정
					sheetObj.CellValue2(row, "spr_ut_mdl_nm") = "GE";
					sheetObj.CellValue2(row, "spr_prt_dp_seq") = "99";
				}	
				else {
					sheetObj.CellValue2(row, "spr_ut_mdl_nm") = "";
					sheetObj.CellValue2(row, "spr_prt_dp_seq") = "";					
				}
				
				break;
		}
    }