	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : EES_MNR_0112.js
	 *@FileTitle : Expense Plan Creation by HO
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.20
	 *@LastModifier : 정영훈
	 *@LastVersion : 1.0
	 * 2009.05.20 정영훈
	 * 1.0 Creation
	 * 2014-02-11 JongHee HAN SELCON 입력 Data 삭제 Bug 해결
	=========================================================*/
	/****************************************************************************************
	 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
	 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
	 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	/**
	 * @extends
	 * @class ui_mnr_0112 : ui_mnr_0112 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_MNR_0112() {
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
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	// 화면 로딩후 조회여부 체크
	var retrieveClick = 0;
	var operationOfcCode = "";
	var operationOfcDesc = "";
	
	var initInd = 'N';
	var mainMsg = 'M&R Expense Plan Creation';
	var subMsg = 'Agreement Number';
	
	var Saved = "";
	var Confirmed = "";	
	
	var nowLoad = 0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
			case "btn_Calendar": //calender button
				var cal = new ComCalendar();
				cal.setDisplayType('year');
				cal.select(formObject.mnr_pln_yr, 'yyyy');
				break;
				
			case "btn_PopUp": //office popup
				ComOpenPopup("EES_MNR_0212.do?po="
						+ ComGetObjValue(formObject.combo1), 515, 260, 'setParam',
						'0,0', true);
				break;
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject,  IBSEARCH);	
				break;
	
			case "btn_New":
				doNew(sheetObject1, formObject, IBCLEAR);
				doActionIBSheet(sheetObject1, formObject,  IBSEARCH);

				//ComEnableObject(formObject.mnr_pln_yr, true);
				formObject.mnr_pln_yr.className = "input1";

				break;
	
			case "btn_Save":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);	
				break;
	
			case "btn_Delete":
				if(ComShowCodeConfirm("MNR00026")){
					doSheetDelete();
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
					doNew(sheetObject1, formObject, IBCLEAR);
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
				}
				break;
	
			case "btn_Confirm":
				if(ComShowCodeConfirm("MNR00197", "MNR PLAN ")){
					doConfirm(sheetObject1, formObject);
				}
				break;

			case "btn_RowAdd":
				var row = sheetObject2.DataInsert(-1);
				
				//RowAdd시에 해당 Ofc를 보여주기위해 추가
				sheetObject2.CellValue(row, "sheet2_mnr_pln_yr") = formObject.mnr_pln_yr.value;
				sheetObject2.CellValue(row, "sheet2_mnr_pln_ofc_cd") = sheetObject2.CellValue(row, "sheet2_office");
				sheetObject2.CellValue(row, "sheet2_mnr_pln_ofc_hdr_cd") = formObject.combo1.Code;
				sheetObject2.CellValue(row, "sheet2_ofc_tp_hdr_cd") = sheetObject1.CellValue(2, "sheet1_ofc_tp_cd");
				sheetObject2.CellValue(row, "sheet2_mnr_pln_hdr_seq") = sheetObject1.CellValue(2, "sheet1_mnr_pln_seq");
				sheetObject2.CellValue(row, "sheet2_mnr_pln_grp_no") = sheetObject1.CellValue(2, "sheet1_mnr_pln_grp_no");
				
				//Sheet1의 ofc_tp_cd의 value에 따라 Sheet2의 ofc_tp_cd를 설정한다.
				if(sheetObject1.CellValue(2, "sheet1_ofc_tp_cd") == "HO"){
					sheetObject2.CellValue(row, "sheet2_ofc_tp_cd") = "HQ";
				} else {
					sheetObject2.CellValue(row, "sheet2_ofc_tp_cd") = "BB";
				}
				
				break;
	
			case "btn_Delete2":
				if(sheetObjects[1].FindCheckedRow("del_chk") == ""){ 
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;             	   
				}
				if(ComShowCodeConfirm("MNR00026")){
					ComRowHideDelete(sheetObjects[1], "del_chk");
				}	
				break;
	
			case "btn_DownExcel":
				doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
				break;
				
			case "btn_calendar1":        
                var cal = new ComCalendar();      
                cal.select(formObject.cre_dt, 'yyyy-MM-dd'); 
                break;		
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
			}
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
			SetTitle("Office Code|Office Name");
	
			SetColAlign("left|left");
			SetColWidth("90|180");
			DropHeight = 160;
		}
	
		with (formObject.combo2) {
			MultiSeparator = "|";
			SetTitle("Office Code | Office Name");
	
			SetColAlign("left|left");
			SetColWidth("90|180");
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
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		MnrWaitControl(true);
		initControl();
		
		for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		nowLoad=1;
		var formObj = document.form; 
	
		var sCondition = new Array (
			new Array("MnrGenCd","HOOFC", "COMMON") //HOOfc 초기화
			,new Array("MnrGenCd","CD00017", "COMMON") 
		);   
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
		
		for(var i=0; i<comboList.length; i++)
		{	
			if (comboList[i] != null) {
				var xmlVal = comboList[i][0].split("|");
				if(i==0)
				{
					HOOfc = xmlVal[0];
				}else if(i==1)
				{
					Saved = xmlVal[0];
					xmlVal= comboList[i][1].split("|");
					Confirmed = xmlVal[0];
				}
			} else {
				if(i==0)
				{
					HOOfc = "";
				}else if(i==1)
				{
					Saved = "N";
					Confirmed = "Y";
				}
			}
		}			
		
		initCombo();
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		MnrWaitControl(false);
		//alert("HOOfc : " + HOOfc + ", currOfcCd : " + currOfcCd+ ", rhqOfcCd : " +rhqOfcCd);
		
		// save, confirm 버튼 통재
		
		if(HOOfc  != currOfcCd){
			if(rhqOfcCd != currOfcCd){
				ComBtnDisable("btn_Delete");
			}
			
			sheetObjects[0].Enable = false;
			var itemindex = formObj.combo1.FindIndex(currOfcCd, 0);

			if(itemindex == -1){
				formObj.combo1.Code = MnrHqOfcByOfc(sheetObjects[0], currOfcCd);
				formObj.combo1.Enable = false;
				formObj.combo2.Code = formObj.combo2.FindIndex(currOfcCd, 0);
				formObj.combo2.Enable = false;
				//alert("-1 : " +formObj.combo2.Code);
			}						
			// currOfcCd is branch
			else {
				formObj.combo1.Code  = itemindex;
				formObj.combo1.Enable = false;
				
			}												
			
		} else{
			formObj.combo1.Code = HOOfc;
		}
		
		//시트1의 mnr_pln_yr을 저장하기위해 페이지 Open시에 해당 데이터를 설정한다. 
		sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_mnr_pln_yr") = formObj.mnr_pln_yr.value;
		sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_mnr_pln_ofc_cd") = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_office");

		//화면 open시 조건에 따라 해당 데이터를 설정한다.
		if(formObj.combo1.Code == "SELCON"){
			sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_ofc_tp_cd") = "HO";
		} else {
			sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_ofc_tp_cd") = "HQ";
		}
		
		//화면 open시 조회한다.
		doActionIBSheet(sheetObjects[0], document.form,  IBSEARCH);
		
	}

	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch 
		// - form 전체 컨트롤중 rdoCity를 제외한 모든 컨트롤의 
		// OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerForm('blur', 'obj_deactivate', form); 
		// - form 전체 컨트롤 중 dataformat 속성이 있는 모든
		// 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('focus', 'obj_activate', form);
		// - form 전체 컨트롤 중 dataformat속성이 있는 모든
		// 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', form); 
		// - form 전체 컨트롤 중 dataformat속성이 있는 모든
		// mnr_pln_yr 변경시 이벤트 처리
    	axon_event.addListener('change', 'mnr_pln_yr_onchange', 'mnr_pln_yr', '');		

	}
	
	//Axon 이벤트 처리2. 이벤트처리함수  
	function obj_deactivate() {
		//ComChkObjValid(event.srcElement);
	}
	
	function obj_activate() {
		//ComClearSeparator(event.srcElement);
	}
	
	function obj_keypress() {
		obj = event.srcElement;
		if (obj.dataformat == null)
			return;
		window.defaultStatus = obj.dataformat;
	
		switch (obj.dataformat) {
		case "YYMM":
			ComKeyOnlyNumber(obj);
			break;
		}
	}
	
	/**
     * mnr_pln_yr 변경시 이벤트 처리
	 * param :
	 * mnr_pln_yr 값 변경 시 데이터 값에 따라 화면을 재조회한다.
     */
    function mnr_pln_yr_onchange() {
    	var formObject = document.form;
    	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    }
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch (sheetObj.id) {
		case "sheet1": // sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 100;
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
			InitRowInfo(2, 1, 10, 100);
	
			var HeadTitle1 = "|Office|511511|511521|511531|511541|511551|511561|Total|||";
			var HeadTitle2 = "|Office|Re-use CNTR|Off-Hire CNTR|Re-use CHSS|Off-Hire CHSS|Reefer CNTR|CHSS Trip Permit|Total|||";
			//var HeadTitle3 = "|Office|Budget|Budget|Budget|Budget|Budget|Budget|Total";
			var headCount = ComCountHeadTitle(HeadTitle1) + 5;
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, false);
			InitHeadRow(1, HeadTitle2, false);
			//InitHeadRow(2, HeadTitle3, false);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, D ATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, prefix + "ibflag");
	
			InitDataProperty(0, cnt++, dtData, 120, daCenter, true, prefix+ "office", true, "", dfEngUpKey, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 120, daRight, false, prefix+ "p511511", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtData, 120, daRight, false, prefix+ "p511521", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtData, 120, daRight, false, prefix+ "p511531", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtData, 120, daRight, false, prefix+ "p511541", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtData, 120, daRight, false, prefix+ "p511551", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtData, 120, daRight, false, prefix+ "p511561", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtData,   0, daRight, true, "total",false, "|" + prefix + "p511511|+|" + prefix + "p511521|+|"+ prefix + "p511531|+|" + prefix + "p511541|+|"+ prefix + "p511551|+|" + prefix + "p511561|",dfFloat, 2, true, true);
	
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, prefix+ "cre_usr_id", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, prefix+ "cre_dt", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, prefix+ "mnr_pln_seq", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, prefix+ "mnr_pln_flg", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, prefix+ "mnr_pln_yr", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, prefix+ "mnr_pln_ofc_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, prefix+ "ofc_tp_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 50, daCenter, true, prefix+ "mnr_pln_grp_no", false, "", dfNone);
	
			CountPosition = 0;
	
		}
		break;
	
		case "sheet2": // sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 322;
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
			InitRowInfo(2, 1, 12, 100);
	
			var HeadTitle1 = "|Sel|Seq.|Office|511511|511521|511531|511541|511551|511561|Total|||||||";
			var HeadTitle2 = "|Sel|Seq.|Office|Re-use CNTR|Off-Hire CNTR|Re-use CHSS|Off-Hire CHSS|Reefer CNTR|CHSS Trip Permit|Total|||||||";
			var headCount = ComCountHeadTitle(HeadTitle1) + 2;
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, false);
			InitHeadRow(1, HeadTitle2, false);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet2_";
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,prefix + "ibflag");
	
			InitDataProperty(0, cnt++, dtCheckBox,     40, daCenter, true,         "del_chk", false,	"", dfNone,	0, true,  true);
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "Seq");
			InitDataProperty(0, cnt++, dtComboEdit, 90, daCenter, true, prefix+ "office", true, "", dfEngUpKey, 0, true, true, 6, false);
			InitDataProperty(0, cnt++, dtAutoSumEx, 120, daRight, false, prefix+ "p511511", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtAutoSumEx, 120, daRight, false, prefix+ "p511521", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtAutoSumEx, 120, daRight, false, prefix+ "p511531", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtAutoSumEx, 120, daRight, false, prefix+ "p511541", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtAutoSumEx, 120, daRight, false, prefix+ "p511551", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtAutoSumEx, 120, daRight, false, prefix+ "p511561", true, "", dfNullFloat, 2, true, true,13);
			InitDataProperty(0, cnt++, dtAutoSumEx, 100, daRight, true, "total",	false, "|" + prefix + "p511511|+|" + prefix + "p511521|+|"+ prefix + "p511531|+|" + prefix + "p511541|+|"+ prefix + "p511551|+|" + prefix + "p511561|",dfFloat, 2, true, true);
	
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix+ "mnr_pln_seq", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix+ "mnr_pln_dtl_seq", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix+ "mnr_pln_yr", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix+ "mnr_pln_ofc_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, prefix+ "ofc_tp_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, prefix+ "mnr_pln_ofc_hdr_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 30, daCenter, true, prefix+ "ofc_tp_hdr_cd", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix+ "mnr_pln_hdr_seq", false, "", dfNone);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix+ "mnr_pln_grp_no", false, "", dfNone);

			SelectionMode = smSelectionRow;    
			SelectHighLight = true;            
			SelectFontBold = false;          
			SelectBackColor = RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
	
			CountPosition = 0;
			//기본설정을 변경한다. 원래는 첫번째 col의 "TOTAL"이라고 찍히는 property
			messageText("Sum") = "";	
		}
		break;	
		}
	}	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {	
			case IBSEARCH: //조회
				doIBSEARCH(sheetObj, formObj, sAction);
				break;
		
			case IBSAVE: //저장
				doIBSAVE(sheetObj, formObj, sAction);
				break;
		
			case IBDELETE:
				doIBDELETESave(sheetObj, formObj, sAction);
				break;
		
			case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
				doIBCLEAR(sheetObj, formObj, sAction);
				break;
		
			case IBDOWNEXCEL:
				doIBExcel(sheetObj, formObj, sAction);
				break;	
		}
	}
	
	/**
	 * 폼을 초기화한다.
	 * @return
	 */
	function doAllClear() {
		var formObj = document.form;
	
		formObj.f_cmd.value = "";
		formObj.pagerows.value = "";
		//ComEnableObject(formObj.mnr_pln_yr, true);
		formObj.mnr_pln_yr.className = "input1";	
		formObj.ctrl_ofc_cd.value = "";	
	}	

	function doSheetDelete() {	
		for (i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
			sheetObjects[0].RowStatus(i) = "D";
		}
	
		for (i = sheetObjects[1].HeaderRows; i < sheetObjects[1].LastRow; i++) {
			sheetObjects[1].RowStatus(i) = "D";
		}
	}
	
	function doWriteOffice(formObj) {
		sheetObjects[0].CellValue2(sheetObjects[0].HeaderRows, "sheet1_office") = ComGetObjValue(formObj.combo1);
	}

	function doNew(sheetObject1, formObject, IBCLEAR) {
		if(HOOfc  == currOfcCd){
			doActionIBSheet(sheetObject1, formObject, IBCLEAR);
	
			sheetObject1.RemoveAll();
			sheetObject1.DataInsert(-1);
			doWriteOffice(formObject);
			formObject.cre_dt.value = ComGetNowInfo();
			formObject.cre_usr_id.value = self_usr_nm;
			doAllClear();
			sheetObjects[0].Enable = true;
			sheetObjects[1].Enable = true;
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Confirm");
		}else{
			sheetObjects[1].RemoveAll();
			comboOnChange(formObject.combo1, formObject.combo1.Code, formObject.combo1.Code);
			formObject.cre_dt.value = ComGetNowInfo();
			formObject.cre_usr_id.value = self_usr_nm;
			doAllClear();
			sheetObjects[1].Enable = true;
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Confirm");
		}	
		//시트1의 mnr_pln_yr을 저장하기위해 페이지 Open시에 해당 데이터를 설정한다. 
		sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_mnr_pln_yr") = formObject.mnr_pln_yr.value;
		sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_mnr_pln_ofc_cd") = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_office");

		//화면 open시 조건에 따라 해당 데이터를 설정한다.
		if(formObject.combo1.Code == "SELCON"){
			sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_ofc_tp_cd") = "HO";
		} else {
			sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_ofc_tp_cd") = "HQ";
		}	

	}	
	
	function doIBCLEAR(sheetObj, formObj, sAction) {
		nowLoad = 1;
		// 콤보데이타 초기화
		formObj.combo1.removeAll();
		formObj.mnr_pln_yr.value = ComGetNowInfo("yy").substr(2,2) + ComLpad(ComGetNowInfo("mm"),2,"0");
		//Combo 세팅 	
		var sCondition = new Array (
				new Array("MdmOrganization","RHQ","TRUESELHOFALSE")   //Regional HQ
		);   
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		
		for(var i=0; i<comboList.length; i++)
		{		
			if(comboList[i] != null)
			{
				for(var j = 0; j < comboList[i].length;j++)
				{   
					var xmlVal = comboList[i][j].split("|");  
					if(i==0){
						formObj.combo1.InsertItem(j, comboList[i][j] ,  xmlVal[0]);
					}
				}	
				
				if(i==0)
				{
//					alert("currOfcCd : " + currOfcCd + " / " + HOOfc +  " / " + rhqOfcCd);
/*					if (HOOfc != currOfcCd) {
						//alert("1 : ");
						var itemindex = formObj.combo1.FindIndex(currOfcCd, 0);
						//alert("2 : " + itemindex);
						if(itemindex == -1){
							
							formObj.combo1.Code = MnrHqOfcByOfc(sheetObjects[0], currOfcCd);											
							formObj.combo1.Enable = false;
							alert(formObj.combo2.FindIndex(currOfcCd, 0));
							formObj.combo2.Code = formObj.combo2.FindIndex(currOfcCd, 0);
							formObj.combo2.Enable = false;
						}						
						// currOfcCd is branch
						else {
							formObj.combo1.Code  = itemindex;
							formObj.combo1.Enable = false;
							
						}												
//						
					} else
						formObj.combo1.Code = HOOfc;
*/					
					
					//2014-02-10 JongHee HAN Plan Office를 currOfcCd.Account로 고정시킴 
					//Why ? 변경하면 MNR_PLN_DTL Data가 삭제되는 Bug 발생
					//formObj.combo1.Enable = false;
				}
			}
			else
			{
				if(i==0){
					ComShowCodeMessage("MNR00005", "Regional HQ Code  ");
				}
			}
		}				

		//쉬트 초기화
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[0].DataInsert(-1);
		nowLoad = 0;
		comboOnChange(formObj.combo1, formObj.combo1.Code, formObj.combo1.Code);
	
		formObj.cre_dt.value = ComGetNowInfo();
		formObj.cre_usr_id.value = self_usr_nm;
		formObj.status.value = "New";
		doWriteOffice(formObj);				
	}	

	function doIBDELETESave(sheetObj, formObj, sAction) { 
		formObj.f_cmd.value = MULTI;
		formObj.delall.value = "Y";
		var aryPrefix = new Array("sheet1_", "sheet2_");
		var sParam = ComGetSaveString(sheetObjects, true, true);
		
		if (sParam == "")
			return;
		sParam += "&" + FormQueryString(formObj) + "&"
		+ ComGetPrefixParam(aryPrefix);

		var sXml = sheetObj.GetSaveXml("EES_MNR_0112GS.do", sParam);
		sheetObjects[0].LoadSaveXml(sXml);
		sheetObjects[1].LoadSaveXml(sXml);
	}
	
	function doIBSAVE(sheetObj, formObj, sAction) { 	
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;

		}else{
			
			formObj.f_cmd.value = MULTI;
			//formObj.ctrl_ofc_cd.value = ComGetObjValue(formObj.combo1);
			
			var aryPrefix = new Array("sheet1_", "sheet2_");
			var sParam = ComGetSaveString(sheetObjects, true, true);
			
			if (sParam == "")
				return false;
			
			sParam += "&" + FormQueryString(formObj) + "&"
			+ ComGetPrefixParam(aryPrefix);		

			if(HOOfc  == currOfcCd){
				sParam += "&hoofc=true";	
			}else {
				sParam += "&hoofc=false";	
			}
			
			var tmpOfcCd       = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_office");
			var tmpMnrPlnOfcCd = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_mnr_pln_ofc_cd");			
			var sXml = sheetObj.GetSaveXml("EES_MNR_0112GS.do", sParam);
			sheetObjects[0].LoadSaveXml(sXml);

			doIBSEARCH(sheetObj, formObj, IBSEARCH);
		}	
		return true;
	}
	
	
	function doIBSEARCH(sheetObj, formObj, sAction) {
		if (!validateForm(sheetObj, formObj, sAction)) {
			return;
		}
		
		MnrWaitControl(true);
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();

		formObj.f_cmd.value = SEARCH;
		var aryPrefix = new Array("sheet1_", "sheet2_");

		var sParam = "";
		
		if(HOOfc  == currOfcCd){
			sParam += "hoofc=true"
		}else {
			sParam += "hoofc=false"
		}
	
		sParam += "&" + FormQueryString(formObj) + "&"
		+ ComGetPrefixParam(aryPrefix);

		var sXml = sheetObj.GetSearchXml("EES_MNR_0112GS.do", sParam);
		var arrXml = sXml.split("|$$|");
	
		for ( var i = 0; i < arrXml.length; i++) {
			sheetObjects[i].Redraw = false;
			if (i > 0) {
				sheetObjects[i].WaitImageVisible = false;
			}
			sheetObjects[i].LoadSearchXml(arrXml[i]);
			sheetObjects[i].Redraw = true;
		}
	
		//ComEnableObject(formObj.mnr_pln_yr, false);
	
		doWriteOffice(formObj);	
		sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_mnr_pln_ofc_cd") = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_office");

	}
	
	function doIBExcel(sheetObj, formObj, sAction) {
		sheetObjects[0].SpeedDown2Excel(-1);
		sheetObjects[1].SpeedDown2Excel(-1, true);
	}
	
	/**
	 * Confirm 버튼을 클릭할경우 처리작업
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function doConfirm(sheetObj, formObj) {
		if(doIBSAVE(sheetObj, formObj, IBSAVE)){
			formObj.f_cmd.value = MULTI;
			var sParam = ComGetSaveString(sheetObj, true, true);
			
			if (sParam == "")
				return;
			sParam += "&" + FormQueryString(formObj) + "&" + "mnr_pln_flg=Y";

			var sXml = sheetObj.GetSaveXml("EES_MNR_0112GS.do", sParam);
			doIBSEARCH(sheetObj, formObj, IBSEARCH);
		}
	}	

    /**
	 * combo1에서 OnChange가 발생하는 경우 이벤트처리
	 * @param indexCode
	 * @param Text
	 * @param row
	 * @return
	 */
	function combo1_OnChange(indexCode, Text, row){
		var formObj = document.form;
		var comboObj = formObj.combo1;
		comboOnChange(comboObj, formObj.combo1.Code, Text);

		if(HOOfc == currOfcCd){
			var tmp1 = formObj.combo1.Code;

			if(currOfcCd != tmp1){
				ComBtnDisable("btn_Delete");
				ComBtnDisable("btn_Save");
				ComBtnDisable("btn_Confirm");
	
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_Delete2");	
			}else{
				ComBtnEnable("btn_Delete");
				ComBtnEnable("btn_Save");
				ComBtnEnable("btn_Confirm");
	
				ComBtnEnable("btn_RowAdd");
				ComBtnEnable("btn_Delete2");	
			}
		}
		
		doActionIBSheet(sheetObjects[0], formObj,  IBSEARCH);
	}
	
	
	/**
	 * combo1에서 OnChange가 발생하는 경우 이벤트처리
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
	function comboOnChange(comboObj, Index_Code, Text) {
		// sheetObjects[0].WaitImageVisible = false;
		var formObj = document.form;
		formObj.combo2.removeAll();
	
		var f_query = '';
		var sXml = "";
		var sCondition=null;
	
		// 쿼리 스트링 조합시작	
		if(Index_Code == HOOfc){
			 sCondition = new Array (   
					 new Array("MdmOrganization","RHQ","TRUESELHOFALSE")
			 );				
	
		}else{
			 sCondition = new Array (      
					  new Array("MdmOrganization","SEARCH",Index_Code) 
			);  
		}
		
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
		operationOfcCode = "";
		operationOfcDesc = "";
		
		if (comboList[0] != null) {

			for ( var i = 0; i < comboList[0].length; i++) {
				var xmlVal = comboList[0][i].split('|');
				formObj.combo2.InsertItem(i, comboList[0][i], xmlVal[0]);
				operationOfcCode = operationOfcCode + xmlVal[0] + "|";
				operationOfcDesc = operationOfcDesc + xmlVal[0]+"\t"+xmlVal[1] + "|";
			}
	
			operationOfcCode = operationOfcCode.substring(0, operationOfcCode.length - 1);
			operationOfcDesc = operationOfcDesc.substring(0, operationOfcDesc.length - 1);
			sheetObjects[1].InitDataCombo(0, "sheet2_office", operationOfcDesc, operationOfcCode, operationOfcCode.substring(0,operationOfcCode.indexOf("|")) );
			if(formObj.combo1.FindIndex(currOfcCd, 0) != -1){
				formObj.combo2.InsertItem(0, "ALL", "ALL");
				formObj.combo2.Code = "ALL";
			}
		}
		//sheetObjects[0].WaitImageVisible = true;
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction, Row) {
		with (formObj) {
			if ((sAction == IBSEARCH) || (sAction == IBSAVE)) {
				if (!ComChkValid(formObj))
					return false;
			}	
	
			if(sAction==IBSAVE) {				
				if (!ComChkValid(formObj)) return false;
				//저장시  중복체크
				var Row = sheetObjects[1].ColValueDup( "sheet2_office");
				if(sheetObjects[1].IsDataModified){
					if(Row>0){
						ComShowCodeMessage("MNR00006", "2th sheet of " + Row + " row ");
						sheetObjects[1].SelectCell(Row, "sheet2_office");
						return false;
					}
				}
				
				var sht1_p511511 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511511");
				var sht1_p511521 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511521");
				var sht1_p511531 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511531");
				var sht1_p511541 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511541");
				var sht1_p511551 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511551");
				var sht1_p511561 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511561");
				
				var sht2_p511511 = sheetObjects[1].SumValue(0, "sheet2_p511511");
				var sht2_p511521 = sheetObjects[1].SumValue(0, "sheet2_p511521");
				var sht2_p511531 = sheetObjects[1].SumValue(0, "sheet2_p511531");
				var sht2_p511541 = sheetObjects[1].SumValue(0, "sheet2_p511541");
				var sht2_p511551 = sheetObjects[1].SumValue(0, "sheet2_p511551");
				var sht2_p511561 = sheetObjects[1].SumValue(0, "sheet2_p511561");

				
				if(parseFloat(sht1_p511511) != parseFloat(sht2_p511511)){
					ComShowCodeMessage("MNR00401", "Summary","Detail Data`s Total");
					sheetObjects[1].SelectCell(sheetObjects[1].lastRow - 1, "sheet2_p511511");
					return false;
				} 
				else if(parseFloat(sht1_p511521) != parseFloat(sht2_p511521)){
					ComShowCodeMessage("MNR00401", "Summary","Detail Data`s Total");
					sheetObjects[1].SelectCell(sheetObjects[1].lastRow - 1, "sheet2_p511521");
					return false;
				}
				else if(parseFloat(sht1_p511531) != parseFloat(sht2_p511531)){
					ComShowCodeMessage("MNR00401", "Summary","Detail Data`s Total");
					sheetObjects[1].SelectCell(sheetObjects[1].lastRow - 1, "sheet2_p511531");
					return false;
				}
				else if(parseFloat(sht1_p511541) != parseFloat(sht2_p511541)){
					ComShowCodeMessage("MNR00401", "Summary","Detail Data`s Total");
					sheetObjects[1].SelectCell(sheetObjects[1].lastRow - 1, "sheet2_p511541");
					return false;
				}
				else if(parseFloat(sht1_p511551) != parseFloat(sht2_p511551)){
					ComShowCodeMessage("MNR00401", "Summary","Detail Data`s Total");
					sheetObjects[1].SelectCell(sheetObjects[1].lastRow - 1, "sheet2_p511551");
					return false;
				}
				else if(parseFloat(sht1_p511561) != parseFloat(sht2_p511561)){
					ComShowCodeMessage("MNR00401", "Summary","Detail Data`s Total");
					sheetObjects[1].SelectCell(sheetObjects[1].lastRow - 1, "sheet2_p511561");
					return false;
				}
				
				
			}	
		} // with
	
		return true;
	}
	
	/**
	 * 저장후에 로딩메시지
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023");
		} else {
			//ComShowCodeMessage("MNR00008", ErrMsg);
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		MnrWaitControl(false);
		
		var formObj = document.form; 
		var tmp1 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_cre_dt");
		var tmp2 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_cre_usr_id");
		var tmp3 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_mnr_pln_flg");
		var tmp4 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_mnr_pln_ofc_cd");
		var tmp5 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_office");

		//시트1의 mnr_pln_yr을 저장하기위해 페이지 Sheet1에 해당 데이터를 설정한다. 
		sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_mnr_pln_yr") = formObj.mnr_pln_yr.value;
		
		//Plan Office의 value에 따라 ofc_tp_cd를 설정한다.		
		if(formObj.combo1.Code == "SELCON"){
			sheetObjects[0].CellValue(2, "sheet1_ofc_tp_cd") = "HO";
		} else {
			sheetObjects[0].CellValue(2, "sheet1_ofc_tp_cd") = "HQ";
		}
		
		//sheet1의 ofc_tp_cd가 HQ이면 sheet1은 Unable
		if(sheetObjects[0].CellValue(2, "sheet1_ofc_tp_cd") == "HQ"){
			sheetObjects[0].Editable = false;
		} else {
			sheetObjects[0].Editable = true;
		}
				
		//Plan Office가 SELCON가 아니면 Delete 버튼을 비활성화 한다.
		if(formObj.combo1.Code != "SELCON"){
			ComBtnDisable("btn_Delete");	
		} else {
			ComBtnEnable("btn_Delete");
		}
		
		
		if(tmp4 == tmp5){
			formObj.cre_dt.value     = tmp1;
			formObj.cre_usr_id.value = tmp2;
		}else{
			formObj.cre_dt.value = ComGetNowInfo();
			formObj.cre_usr_id.value = self_usr_nm;		 
		}

		if(tmp3 == null){
			//alert("tmp3 : " + tmp3);
			formObj.status.value = "New";
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_Save");	
			
		}else if(tmp3 == Confirmed){
			//alert("tmp3 : " + tmp3);
			formObj.status.value = "Confirmed";
			ComBtnDisable("btn_Delete");
			
		}else if(tmp3 == Saved){	
			
			formObj.status.value = "Saved";
			
		} else {
			
			formObj.status.value = "New";	
			formObj.cre_dt.value = ComGetNowInfo();
			formObj.cre_usr_id.value = self_usr_nm;		
		}
	
		if(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "total") == '0'){
			if (HOOfc != currOfcCd) {
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_Delete2");
			}
		}else{
			if(tmp3 != Confirmed){
				ComBtnEnable("btn_RowAdd")
				ComBtnEnable("btn_Delete2");					
			}
		}
		
		if(HOOfc  != currOfcCd){
			sheetObjects[0].Enable = false;
		}
		
		if(sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511511") == ""){
			sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_ibflag") = "I";
		}
		
		var itemindex = formObj.combo1.FindIndex(currOfcCd, 0);

		// Branch office 값이 있으면 itemindex가 -1 이다.
		if(itemindex == -1){
			ComBtnDisable("btn_New");
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Confirm");
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_Delete2");
		}						
		else {
			ComBtnEnable("btn_New");
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_Confirm");
			ComBtnEnable("btn_RowAdd");
			ComBtnEnable("btn_Delete2");
		}
		
	}


	function sheet2_OnSearchEnd(sheetObj, errMsg) {
		sheetObj.SumText(0, "sheet2_office") = "TOTAL";		
				
		for(var i = 1 ; i <= sheetObjects[1].RowCount + 1 ; i++){
			sheetObjects[1].CellEditable(i, "sheet2_office") = false;
		}
		
		document.form.mnr_pln_yr.className = "input1";
		
	}
	
	function sheet2_OnChangeSum(sheetObj, Row){
		with(sheetObj)
		{
			sheetObj.SumText(0, "sheet2_office") = "TOTAL";	
		}
	}
	
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(nowLoad == 0){
			
			if(sheetObj.ColSaveName(Col) == "sheet1_p511511"){
				var sht1_p511511 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511511");
				var sht2_p511511 = sheetObjects[1].SumValue(0, "sheet2_p511511");
				if(parseFloat(sht1_p511511) < parseFloat(sht2_p511511)){
					ComShowCodeMessage("MNR00400", "Summary data","Detail`s Summary");
					sheetObjects[0].CellValue2(Row,  "sheet1_p511511") = "";
					sheetObjects[0].SelectCell(Row,  "sheet1_p511511");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet1_p511521"){
				var sht1_p511521 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511521");
				var sht2_p511521 = sheetObjects[1].SumValue(0, "sheet2_p511521");
				if(parseFloat(sht1_p511521) < parseFloat(sht2_p511521)){
					ComShowCodeMessage("MNR00400", "Summary data","Detail`s Summary");
					sheetObjects[0].CellValue2(Row, "sheet1_p511521") = "";
					sheetObjects[0].SelectCell(Row, "sheet1_p511521");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet1_p511531"){
				var sht1_p511531 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511531");
				var sht2_p511531 = sheetObjects[1].SumValue(0, "sheet2_p511531");
				if(parseFloat(sht1_p511531) < parseFloat(sht2_p511531)){
					ComShowCodeMessage("MNR00400", "Summary data","Detail`s Summary");
					sheetObjects[0].CellValue2(Row, "sheet1_p511531") = "";
					sheetObjects[0].SelectCell(Row, "sheet1_p511531");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet1_p511541"){
				var sht1_p511541 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511541");
				var sht2_p511541 = sheetObjects[1].SumValue(0, "sheet2_p511541");
				if(parseFloat(sht1_p511541) < parseFloat(sht2_p511541)){
					ComShowCodeMessage("MNR00400", "Summary data","Detail`s Summary");
					sheetObjects[0].CellValue2(Row, "sheet1_p511541") = "";
					sheetObjects[0].SelectCell(Row, "sheet1_p511541");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet1_p511551"){
				var sht1_p511551 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511551");
				var sht2_p511551 = sheetObjects[1].SumValue(0, "sheet2_p511551");
				if(parseFloat(sht1_p511551) < parseFloat(sht2_p511551)){
					ComShowCodeMessage("MNR00400", "Summary data","Detail`s Summary");
					sheetObjects[0].CellValue2(Row, "sheet1_p511551") = "";
					sheetObjects[0].SelectCell(Row, "sheet1_p511551");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet1_p511561"){
				var sht1_p511561 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511561");
				var sht2_p511561 = sheetObjects[1].SumValue(0, "sheet2_p511561");
				if(parseFloat(sht1_p511561) < parseFloat(sht2_p511561)){
					ComShowCodeMessage("MNR00400", "Summary data","Detail`s Summary");
					sheetObjects[0].CellValue2(Row, "sheet1_p511561") = "";
					sheetObjects[0].SelectCell(Row, "sheet1_p511561");
				}
			}
		}
	
	} 
	
	function sheet2_OnChange(sheetObj,Row, Col, Value){
		if(nowLoad == 0){
			
			if(sheetObj.ColSaveName(Col) == "sheet2_office"){
				
				//Sheet2의 ofc값이 변경되면 변경된 값으로 mnr_pln_ofc_cd를 설정해준다.
				sheetObjects[1].CellValue(Row, "sheet2_mnr_pln_ofc_cd") = sheetObjects[1].CellValue(Row, "sheet2_office");
				
				//Sheet2의 Office가 SELCON이면 ofc_tp_cd를 HO로 설정한다.
				if(sheetObjects[0].CellValue(2, "sheet1_ofc_tp_cd") == "HO" && sheetObjects[1].CellValue(Row, "sheet2_office") == "SELCON"){
					sheetObjects[1].CellValue(Row, "sheet2_ofc_tp_cd") = "BB";
				} else if (sheetObjects[0].CellValue(2, "sheet1_ofc_tp_cd") == "HO" && sheetObjects[1].CellValue(Row, "sheet2_office") != "SELCON"){
					sheetObjects[1].CellValue(Row, "sheet2_ofc_tp_cd") = "HQ";
				}
							
			}else if(sheetObj.ColSaveName(Col) == "sheet2_p511511"){
				var sht1_p511511 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511511");
				var sht2_p511511 = sheetObjects[1].SumValue(0, "sheet2_p511511");
				if(parseFloat(sht1_p511511) < parseFloat(sht2_p511511)){
					ComShowCodeMessage("MNR00196", "Detail data","Summary");
					sheetObjects[1].CellValue2(Row,  "sheet2_p511511") = "";
					sheetObjects[1].SelectCell(Row,  "sheet2_p511511");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet2_p511521"){
				var sht1_p511521 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511521");
				var sht2_p511521 = sheetObjects[1].SumValue(0, "sheet2_p511521");
				if(parseFloat(sht1_p511521) < parseFloat(sht2_p511521)){
					ComShowCodeMessage("MNR00196", "Detail data","Summary");
					sheetObjects[1].CellValue2(Row, "sheet2_p511521") = "";
					sheetObjects[1].SelectCell(Row, "sheet2_p511521");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet2_p511531"){
				var sht1_p511531 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511531");
				var sht2_p511531 = sheetObjects[1].SumValue(0, "sheet2_p511531");
				if(parseFloat(sht1_p511531) < parseFloat(sht2_p511531)){
					ComShowCodeMessage("MNR00196", "Detail data","Summary");
					sheetObjects[1].CellValue2(Row, "sheet2_p511531") = "";
					sheetObjects[1].SelectCell(Row, "sheet2_p511531");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet2_p511541"){
				var sht1_p511541 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511541");
				var sht2_p511541 = sheetObjects[1].SumValue(0, "sheet2_p511541");
				if(parseFloat(sht1_p511541) < parseFloat(sht2_p511541)){
					ComShowCodeMessage("MNR00196", "Detail data","Summary");
					sheetObjects[1].CellValue2(Row, "sheet2_p511541") = "";
					sheetObjects[1].SelectCell(Row, "sheet2_p511541");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet2_p511551"){
				var sht1_p511551 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511551");
				var sht2_p511551 = sheetObjects[1].SumValue(0, "sheet2_p511551");
				if(parseFloat(sht1_p511551) < parseFloat(sht2_p511551)){
					ComShowCodeMessage("MNR00196", "Detail data","Summary");
					sheetObjects[1].CellValue2(Row, "sheet2_p511551") = "";
					sheetObjects[1].SelectCell(Row, "sheet2_p511551");
				}
				
			}else if(sheetObj.ColSaveName(Col) == "sheet2_p511561"){
				var sht1_p511561 = sheetObjects[0].CellValue(sheetObjects[0].HeaderRows, "sheet1_p511561");
				var sht2_p511561 = sheetObjects[1].SumValue(0, "sheet2_p511561");
				if(parseFloat(sht1_p511561) < parseFloat(sht2_p511561)){
					ComShowCodeMessage("MNR00196", "Detail data","Summary");
					sheetObjects[1].CellValue2(Row, "sheet2_p511561") = "";
					sheetObjects[1].SelectCell(Row, "sheet2_p511561");
				}
			}
		}
	
	}   	
	/**
	 * operation office의 validation을 검사한다.
	 * @param strhq
	 * @param strofc
	 * @param Row
	 * @param Col
	 * @return
	 */
	function  checkOperationOfc(strhq, strofc, Row, Col){
		var srchStr = strofc+","+strhq;
		var retArray = MnrGeneralCodeCheck(sheetObjects[1],"OFC",srchStr);
		
		if(retArray == null){
			ComShowCodeMessage("MNR00010", "Office");
			sheetObjects[1].CellValue2(Row, sheetObjects[1].SaveNameCol("sheet2_office")) = "";
			sheetObjects[1].SelectCell(Row, sheetObjects[1].SaveNameCol("sheet2_office"));
		}
	}	

	/* 개발자 작업  끝 */