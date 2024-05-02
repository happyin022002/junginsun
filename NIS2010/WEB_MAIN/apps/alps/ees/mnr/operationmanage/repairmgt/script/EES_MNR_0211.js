	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_mnr_0211.js 
	 *@FileTitle : W/O Inquiry - Popup
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.26
	 *@LastModifier : 정영훈
	 *@LastVersion : 1.0
	 * 2009.06.06 정영훈
	 * 1.0 Creation
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
	 * @class ees_mnr_0211 : ees_mnr_0211 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_mnr_0211() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업	*/
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var initInd = 'N'
	var mainMsg = 'W/O Inquiry Popup'
	var subMsg = 'XXX'
	
	var eqcode = "";
	var eqdesc = "";
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
	
			case "btn1_Retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
	
			case "btn1_New":
				doActionIBSheet(sheetObject,formObject,IBCLEAR);
				break;
	
			case "btn1_OK":
				doActionIBSheet(sheetObject,formObject,COMMAND01);
				break;
	
			case "btn1_Close":
				window.close();
				break;
	
			case "btn_calendar":
				var cal = new ComCalendarFromTo();
				cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
				break;
	
			} // end switch
		} catch (e) {
			if( e == "[object Error]") {     
				ComFuncErrMsg(e);          
			} else {      
				ComFuncErrMsg(e);    
			}   
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
		
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();
	
		//콤보조회
		var sheetObj=sheetObjects[0];
		var formObj = document.form;
		var sCondition = new Array (
				new Array("MnrGenCd","CD00020", "COMMON") //Buyer Type _MNR_PRNR_KND_CD and Buyer Type Infomation 부문 _MNR_PRNR_KND_CD2			
				,new Array("MnrGenCd","SELHO","CUSTOM9")  //Buyer Detail Type _mnr_prnr_knd_dtl_cd
		);
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 설정
		var sheetComboText = "";
		var sheetComboCode = "";
		var sheetComboCodeText = "";
		var sheetComboDefault = "";
		for(var i = 0; i < comboList.length;i++){
			//쉬트콤보별 초기화
			sheetComboText = "";
			sheetComboCode = "";
			sheetComboCodeText = "";
			sheetComboDefault = ""; 
			if(comboList[i] != null){
				for(var j = 0; j < comboList[i].length;j++){ 
					var tempText = comboList[i][j].split("|");   
					sheetComboText +=  tempText[1] + "|";
					sheetComboCode +=  tempText[0] + "|";
					sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
					if(j ==0){	
						sheetComboDefault = tempText[0];      	
					}
					if(i==0) {
						formObj.combo1.InsertItem(j, tempText[0]+"|"+tempText[1]  ,tempText[0]);
					}else if (i==1) {
						formObj.combo2.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				if(i==0){
					formObj.combo1.InsertItem(0, "ALL" , "ALL");
					formObj.combo1.Code = "ALL";
				}else if(i==1){
					formObj.combo2.InsertItem(0, "ALL" , "ALL");
					formObj.combo2.Code = "ALL";
				}
			}
		}
	
		formObj.tocal.value  = ComGetNowInfo();
		formObj.fromcal.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -15); //이전 15일
		
		if(window.dialogArguments != undefined)
		{
			var formObject=document.form;
			if(window.dialogArguments.document.form.mnr_wo_tp_cd!=undefined)
			{
				formObject.combo1.Code2=window.dialogArguments.document.form.mnr_wo_tp_cd.value;
				formObject.combo1.Enable=false;
			}
			if(window.dialogArguments.document.form.cost_ofc_cd!=undefined)
			{
				formObject.cost_ofc_cd.value=window.dialogArguments.document.form.cost_ofc_cd.value;
			}
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		}
		MnrWaitControl(false);
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetId = sheetObj.id;
	
		switch (sheetId) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 200;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle1 = "|Sel|Seq|W/O Type|W/O No.|S/P Code|Service Provider Name|W/O Send Type|W/O Send Date|Agreement No|W/O Date|W/O Amount";
				var headCount = ComCountHeadTitle(HeadTitle1) + 1;
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				InitDataProperty(0, cnt++, dtHiddenStatus, 0);
				if(window.dialogArguments != undefined)
				{
					if(typeof(window.dialogArguments.document.form.sel_type)!="undefined")
					{
						if(window.dialogArguments.document.form.sel_type.value=="M")
							InitDataProperty(0, cnt++, dtCheckBox,        30,  daCenter,   true, "selchk");
						else if(window.dialogArguments.document.form.sel_type.value=="S")
							InitDataProperty(0, cnt++, dtRadioCheck,        30,  daCenter,   true, "selchk"); 			
					}else{
						InitDataProperty(0, cnt++, dtRadioCheck,        30,  daCenter,   true, "selchk");
					}
				}else{
					InitDataProperty(0, cnt++, dtRadioCheck,        30,  daCenter,   true, "selchk");
				}
	
				InitDataProperty(0, cnt++, dtSeq, 				30,  daCenter,   true, "Seq");
				InitDataProperty(0, cnt++, dtData, 				65,  daCenter,   true, "mnr_grp_tp_cd", 	false,"", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 				90,  daCenter,   true, "wono", 				false,"", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 				60, daRight,     true, "vndr_seq", 			false,"", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 				140, daLeft,   	 true, "vndr_lgl_eng_nm", 	false,"", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 				95,  daLeft,   	 true, "trsm_mod_nm", 		false,"", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 				95,  daLeft,     true, "senddt", 			false,"", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 				90,  daCenter,   true, "agmt_seq", 			false,"", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 		    	90,  daLeft,     true, "cre_dt", 			false,"", dfNone, 0, false, true);
				InitDataProperty(0, cnt++, dtData, 				90,  daRight,    true, "mnr_wrk_amt", 		false,"", dfFloat, 2, false, true);
				InitDataProperty(0, cnt++, dtHidden,    		90,  daCenter,   true, "eq_knd_cd", 		false,"", dfNone, 0, false, true);
				//SELECT 로우 배경색       
				SelectionMode = smSelectionRow;    
				SelectHighLight = true;            
				SelectFontBold = false;          
				SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);  
	
				CountPosition = 2;
			}
			break;
		}
	}
	
	/**
	 * 멀티 콤보 초기화 
	 * @return
	 */
	function initCombo() {
	
		var formObject = document.form
		with (formObject.combo1) {
			MultiSeparator = "|";
			SetColAlign("left|left");        
			SetColWidth("100|150");    
			DropHeight = 160;
	
		} 
		with (formObject.combo2) { 
			MultiSeparator = "|";
			SetColAlign("left|left");        
			SetColWidth("100|0");    
			DropHeight = 160; 
		} 
	}

	/**
	* IBSheet Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
		
	function sheet1_OnSearchEnd(sheetObj, errMsg)
	{
		nowLoad=0; 
		MnrWaitControl(false); 
	}
	function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH){
		document.form.retfld.value=sheetObj.CellValue(Row,"wono");
		comPopupOK(); 
	} 

	// Sheet관련 프로세스 처리 
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) 
		{    
		case IBSEARCH:      //조회 
		if(!validateForm(sheetObj,formObj,sAction))return;
		sheetObj.Redraw = true;    
		sheetObj.WaitImageVisible = true;	
		formObj.f_cmd.value = SEARCH;
		var sParam = FormQueryString(formObj);
		sParam += "&currOfcCd="+ currOfcCd; 
		var sXml = sheetObj.GetSearchXml("EES_MNR_0211GS.do",  sParam);
		sheetObj.LoadSearchXml(sXml); 
	
		//sheetObj.WaitImageVisible = false;
		//sheetObj.Redraw = false; 
		MnrWaitControl(false);                
		break;   	       
			
		case IBCLEAR:      //초기화  
		sheetObj.RemoveAll();         
		break;           
	
		case COMMAND01:      //ok 			
		if(sheetObj.RowCount < 1)
		{
			window.close();
			return false;
		}
		var selCheck=sheetObj.FindCheckedRow("selchk");
		if(sheetObj.FindCheckedRow("selchk") == ""){ 
			ComShowCodeMessage("MNR00038","Select ");
			return false;             	   
		}
		if(window.dialogArguments != undefined)
		{
			if(typeof(window.dialogArguments.document.form.wo_no) != "undefined")
			{
				var splCheck=selCheck.split("|");
				var strWoNO="";
				for(var i=0;i<splCheck.length;i++)
				{
					if(i==0)strWoNO+=sheetObj.CellValue(splCheck[i],"wono");
					else 
					{
						if(splCheck[i]!="")
							strWoNO+=","+sheetObj.CellValue(splCheck[i],"wono");
					}
				}
	
				window.dialogArguments.document.form.wo_no.value=strWoNO;
				window.close();
				return false;     
	
			}else{
				comPopupOK(); 
				return false;  
			}
		}else{
	
	
			comPopupOK(); 
			return false;     
		}
		break;  
		}  
	}      
		
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj)
		{
        	switch(sAction) 
        	{  	
			case IBSEARCH: 
				if (!ComChkObjValid(formObj)) {return false;}
				if(ComGetDaysBetween(formObj.fromcal.value, formObj.tocal.value) > 90)
				{
					ComShowCodeMessage("MNR00325","W/O Date","3Months");
					return false;
				}
			 	break;	
        	}
		}
			return true;
	}
	
	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject = document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	}             
			   	
	//Axon 이벤트 처리2. 이벤트처리함수   
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	} 
		
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        
				        
	function obj_keypress(){   
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
					 			              
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
	    }         
	}	

/* 개발자 작업  끝 */