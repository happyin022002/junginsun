	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_mnr_0211.js 
	 *@FileTitle : Tire Purchase W/O Inquiry - Popup
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
	function ees_mnr_0194() {
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
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		if(window.dialogArguments != undefined)
		{
			var formObject=document.form;
			if(window.dialogArguments.document.form.vsl_cd2!=undefined)
			{
				formObject.vsl_cd.value=window.dialogArguments.document.form.vsl_cd2.value;
				if(formObject.vsl_cd.value.length > 0)
				setVesselInfo(sheetObjects[0],1,formObject.vsl_cd.value);
				formObject.vsl_cd.Enable=false;
			}
			
			if(window.dialogArguments.document.form.cost_ofc_cd!=undefined)
			{
				formObject.cost_ofc_cd.value=window.dialogArguments.document.form.cost_ofc_cd.value;
			}
			
			if(formObject.vsl_cd.value.length > 0)
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
	
		switch(sheetNo) {
		case 1:      // sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 230;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);
	
			var HeadTitle1 = "|Seq.|W/O No.|VVD CD|Office|Yard|Curr.|W/O Issue\nDate|Unit Type|Part No.|Part Name|Q'ty|Unit Cost|Amount";
	
	
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,		true,	"Status");
			InitDataProperty(0,	cnt++,	dtSeq,					30,		daCenter,		true,	"Seq");
			InitDataProperty(0,	cnt++,	dtData,		0,		daCenter,		true,	prefix+"mnr_ord_seq",			false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,		true,	prefix+"vsl_vvd",				false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		55,		daCenter,		true,	prefix+"ord_iss_ofc_cd",		false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,		true,	prefix+"spr_prt_spl_yd_cd",		false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		40,		daCenter,		true,	prefix+"curr_cd",				false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		70,		daCenter,		true,	prefix+"cre_dt",				false,	"",	dfDateYmd,0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,		true,	prefix+"spr_ut_tp_nm",			false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		120,	daCenter,		true,	prefix+"spr_prt_no",			false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		120,	daCenter,		true,	prefix+"spr_prt_nm",			false,	"",	dfNone,		0,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		30,		daCenter,		true,	prefix+"rpr_qty",				false,	"",	dfNone,		0,	true,	true);											
			InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,		true,	prefix+"spr_prt_uc_amt",		false,	"",	dfNullFloat,2,	true,	true);
			InitDataProperty(0,	cnt++,	dtData,		60,		daCenter,		true,	prefix+"total_amt",				false,	"",	dfNullFloat,2,	true,	true);
	
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
	* IBSheet Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
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
  	
  	function obj_change(){	     
  		var obj      = event.srcElement; 
  		var formObj  = document.form; 
  		var sheetObj = sheetObjects[0]; 
  	
  		if ( ComTrim(obj.value) != "" ) {
  			switch(obj.name) {      
  			case "vsl_cd":
  				setVesselInfo(sheetObj,1,formObj.vsl_cd.value);
  				break;   
  			}       
  		} 
  	}    
  	
  	function obj_keypress(){   
  		obj = event.srcElement;    
  		keys = event.keyCode;
  		var sheetObj = sheetObjects[0]; 
  		if(obj.dataformat == null) return; 
  		window.defaultStatus = obj.dataformat;
  		var formObj  = document.form; 
  		if ( ComTrim(obj.value) != "" ) {
  			switch(obj.name) {      
  			case "vsl_cd":   
  				MnrWaitControl(true);
  				var strVslCdAll=formObj.vsl_cd.value;

  				if(strVslCdAll.length > 3)
  				{ 
  					if(keys==13)
  					{
  						setVesselInfo(sheetObj,1,strVslCdAll);
  						ComSetFocus(formObj.fromcal);
  					}
  				}
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
  		}         
  	}     

	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		MnrWaitControl(false);
		nowLoad = 0;
	}
	
	// Sheet관련 프로세스 처리 
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) 
		{    
		case IBSEARCH:      //조회 
		if(!validateForm(sheetObj,formObj,sAction))return;
	
		MnrWaitControl(true);
		nowLoad = 1;
		sheetObjects[0].RemoveAll();
	
		formObj.f_cmd.value = SEARCH; 
	
		var sParam = "";
		var aryPrefix = new Array("sheet1_");
	
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
	
		var sXml   = sheetObj.GetSearchXml("EES_MNR_0194GS.do", sParam);
		arrDataSearchDbXml = sXml.split("|$$|");
	
		for ( var i = 0; i < arrDataSearchDbXml.length; i++) {
			sheetObjects[i].Redraw = false;
			sheetObjects[i].WaitImageVisible = false;
			sheetObjects[i].LoadSearchXml(arrDataSearchDbXml[i]);
			sheetObjects[i].Redraw = true;
		}   
		MnrWaitControl(false);                
		break;          
	
		case IBCLEAR:      //초기화  
		MnrWaitControl(true);
		formObj.cost_ofc_cd.value = currOfcCd;
		formObj.tocal.value  = ComGetNowInfo();
		formObj.fromcal.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -90);
		formObj.vsl_cd.value="";
		formObj.vsl_eng_nm.value="";
		sheetObjects[0].RemoveAll();
		MnrWaitControl(false);     
		break;           
		}  
	}   
	
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj, formObj, sAction) {
		with(formObj){
			//조회시
			if(sAction==IBSEARCH)
			{
				if(formObj.vsl_cd.value == ""){
					ComShowCodeMessage("MNR00172","Vessel");  
					ComSetFocus(formObj.vsl_cd);     
					return false;
				}

				if(formObj.fromcal.value.length <8){
					ComShowCodeMessage("MNR00036","W/O Issue Date");    
					ComSetFocus(formObj.fromcal);     
					return false;
				}
	
				if(formObj.tocal.value.length <8){
					ComShowCodeMessage("MNR00036","W/O Issue Date");    
					ComSetFocus(formObj.tocal);     
					return false;
				}
			}
			return true;
		}
	}
	
	function setVesselInfo(sheetObj,Row,vsl_cd){
		MnrWaitControl(true);
		var formObj = document.form;
		var sXml = MnrComVesselInfoSearch(sheetObj,vsl_cd);
		var retArr =  MnrXmlToArray(sXml); 
		//0vsl_eng_nm|1 ibflag|2 skd_dir_cd| 3 skd_voy_no|4 pagerows|5 vsl_slan_cd|6 vsl_cd|
		if(retArr != null){  
			//TpSz	
			formObj.vsl_eng_nm.value=retArr[0][0];
			ComSetFocus(formObj.fromcal);	
	
		} else {	  
			formObj.vsl_eng_nm.value="";
			ComSetFocus(formObj.vsl_cd);	
		}	
		MnrWaitControl(false);
		calReq=0;
	}	
	
	/* 개발자 작업  끝 */