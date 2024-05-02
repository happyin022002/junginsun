/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_CIM_0061.js
*@FileTitle : EQ Balance Report Inquiry
*Open Issues : 장비 과부족현황 Mailing (2014.03 ~ 2014.04)
*Change history :
*@LastModifyDate : 2014.04.03
*@LastModifier : Kim Chang Young
*@LastVersion : 1.0
* 2014.04.03 Kim Chang Young
* 1.0 Creation
=========================================================*/
	/**
	 * @extends 
	 * @class EES_CIM_0061 : EES_CIM_0061 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_CIM_0061() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject			= setSheetObject;
		this.setComboObject			= setComboObject;
		this.loadPage				= loadPage;
		this.initControl			= initControl;
		this.obj_activate			= obj_activate;
		this.obj_deactivate			= obj_deactivate;
		this.obj_keypress			= obj_keypress;
		this.initSheet				= initSheet;
		this.initCombo				= initCombo;
		this.doActionIBSheet		= doActionIBSheet;
		this.setTabObject			= setTabObject;
		this.validateForm			= validateForm;
		this.rhq_cd_OnChange		= rhq_cd_OnChange;
		this.sconti_cd_OnChange		= sconti_cd_OnChange;
		this.lcc_cd_OnChange		= lcc_cd_OnChange;
	}
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0 ;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var shtCnt = 0;
		var sheetObject1 = sheetObjects[shtCnt++];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
			
				case "btn_retrieve":
					
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					
					break;
					
				case "btn_new":
					formObject.reset();
					
					doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
						
					break;
					
				case "btn_downexcel":
					
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					
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
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param {IBMultiCombo} combo_obj IBMultiCombo Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		initControl();
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	}
	
	/**
	 * 초기 이벤트 등록 
	 */
	function initControl() {
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');							//엔터키 조회 이벤트처리
		axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);				//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);			//form OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerForm('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
//		axon_event.addListenerFormat('blur', 'obj_blur', form);
		
		document.form.rhq_cd.Enable = false;
	}
	
	/**
	 * beforeactivate 이벤트 처리
	 * beforeactivate -없애기
	 * beforeactivate 포커스 주기
	 */
	function obj_activate() {
//		alert("obj_activate");
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
	}
	/**
	 * beforedeactivate 이벤트 처리
	 * beforedeactivate YYYY-WW 포멧 처리
	 */	
	function obj_deactivate() {
//		alert("obj_deactivate");
//		ComClearSeparator(event.srcElement);
		var fmWeekVal = document.getElementById("fm_week");
		var toWeekVal = document.getElementById("to_week");
		sFmVal = fmWeekVal.value.replace(/\/|\-|\./g, "");
		sToVal = toWeekVal.value.replace(/\/|\-|\./g, "");
		
		switch (event.srcElement.name) {
		
		case "fm_week":
			if (!ComChkObjValid(event.srcElement, false)) {
				
				if (fmWeekVal.getAttribute("dataformat") == "yw") { // 주별로 조회
					if ( (sFmVal.length == 6 && !ComIsWeek(sFmVal.substring(4, 6))) ||
							sFmVal.length < 6 ) {
						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYYWW"); // msgs['CIM21004'] = 'Date format is wrong.  Please enter a valid date format. [{?msg1}]';
						event.srcElement.focus();
						event.srcElement.select();
						
						return false;
					}
				}
			}
		break;
		
		case "to_week":
			if (!ComChkObjValid(event.srcElement, false)) {
				
				if (toWeekVal.getAttribute("dataformat") == "yw") { // 주별로 조회
					if ( (sToVal.length == 6 && !ComIsWeek(sToVal.substring(4, 6))) ||
							sToVal.length < 6 ) {
						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYYWW"); // msgs['CIM21004'] = 'Date format is wrong.  Please enter a valid date format. [{?msg1}]';
						event.srcElement.focus();
						event.srcElement.select();
						
						return false;
					}
				}
			}
		break;
		
		}
		return true;
	}
	
	/**
	 * 키이벤트 등록
	*/
	function obj_keypress() {
//		alert("obj_keypress");
		switch (event.srcElement.name) {
		
		case "fm_week":
			// 숫자만 + "-"만 입력허용
			ComKeyOnlyNumber(event.srcElement);
		break;
		
		case "to_week":
			// 숫자만 + "-"만 입력허용
			ComKeyOnlyNumber(event.srcElement);
		break;
		
		}
	} 
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		
		var cnt = 0;
		var shtID = sheetObj.id;

		switch(shtID) {
			case "sheet1":	//sheet1 init
				with (sheetObj) {
				
					// 높이 설정
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 20, 100);
					
					var HeadTitle1 = "RCC|SCONTI_CD|Sub-conti|LCC|ECC|YYYYWW|"
									+"Inventory Surplus/Deficit Status|Inventory Surplus/Deficit Status|Inventory Surplus/Deficit Status|Inventory Surplus/Deficit Status|Inventory Surplus/Deficit Status|"
									+"Inventory Surplus/Deficit Status|Inventory Surplus/Deficit Status|Inventory Surplus/Deficit Status|Inventory Surplus/Deficit Status|Inventory Surplus/Deficit Status|"
									+"Confirm|Remark";
									
					var HeadTitle2 = "RCC|SCONTI_CD|Sub-conti|LCC|ECC|YYYYWW|"
									+"D2|D4|D5|D7|R2|R5|O2|O4|F2|F4|"	// Inventory Surplus/Deficit Status
									+"Confirm|Remark";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					InitDataProperty(0, cnt++ , dtData,		60,   daCenter,	true,	"rcc_cd",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtHidden,	70,   daCenter,	true,	"sconti_cd",	false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		155,  daCenter,	true,	"sconti_nm",	false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		60,   daCenter,	true,	"lcc_cd",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		60,   daCenter,	true,	"ecc_cd",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		70,   daCenter,	true,	"tgt_yrwk",		false,	"",	dfDateYm, 0, false, false);
					/** Inventory Surplus/Deficit Status **/
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"d2_sts",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"d4_sts",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"d5_sts",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"d7_sts",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"r2_sts",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"r5_sts",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"o2_sts",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"o4_sts",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"f2_sts",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		40,   daCenter,	true,	"f4_sts",		false,	"",	dfNone, 0, false, false);
					
					InitDataProperty(0, cnt++ , dtData,		50,   daCenter,	true,	"cfm_flg",		false,	"",	dfNone, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,		300,  daLeft,	true,	"sts_rmk",		false,	"",	dfNone, 0, false, false);
					
					SetSortDialog(false);
					CountPosition = 0;
					SelectHighLight = false;
					FrozenCols = 6;
					
					CountPosition = 2;
				}
				break;
				
			}
	}
	
	/** 
	 * 콤보 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @param comboNo 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "rhq_cd":
				with (comboObj) {
					SetColAlign("left");
					SetColWidth("50");
					DropHeight = 200;
				}
			break;
			
			case "sconti_cd":
				with (comboObj) {
					SetTitle("Code|Description")
					SetColAlign("left|left");
					SetColWidth("50|200");
					ShowCol(1);
					DropHeight = 200;
				}
			break;
			
			case "lcc_cd":
				with (comboObj) {
					SetColAlign("left");
					SetColWidth("50");
					DropHeight = 200;
				}
			break;
			
			case "ecc_cd":
				with (comboObj) {
					SetColAlign("left");
					SetColWidth("50");
					DropHeight = 200;
				}
			break;
		}
	}
	
	/**
	 * Sheet관련 프로세스 처리
	*/
	function doActionIBSheet(sheetObj,formObj,sAction) {
//		sheetObj.ShowDebugMsg = true;
		switch(sAction) {

			case IBSEARCH:	//Retrieve
				
				for(var idx=0; idx < sheetObjects.length; idx++) {
					sheetObjects[idx].RemoveAll();
				}
				
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
					
				formObj.f_cmd.value = SEARCH;
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				
				sheetObj.DoSearch("EES_CIM_0061GS.do",FormQueryString(formObj));
				
				ComOpenWait(false);
				break;
				
			case IBSEARCH_ASYNC01:	//pre search
				
				for(var idx=0; idx < sheetObjects.length; idx++) {
					sheetObjects[idx].RemoveAll();
				}
				
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true); 
				
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0061GS.do", FormQueryString(formObj));
				
				ComOpenWait(false);
				
				var sLclHqOfcCd = ComGetEtcData(sXml, "lcl_hq_ofc_cd");
				var sGlblHqOfcCd = ComGetEtcData(sXml, "glbl_hq_ofc_cd");
				var sNowWeek = ComGetEtcData(sXml, "now_week");
				var sLastWeek = ComGetEtcData(sXml, "last_week");
				var sArHdQtrOfcCd = ComGetEtcData(sXml, "ar_hd_qtr_ofc_cd");
				var sSubContiCd		= ComGetEtcData(sXml, "sconti_cd");
				var sLccCd			= ComGetEtcData(sXml, "lcc_cd");
				var sEccCd			= ComGetEtcData(sXml, "ecc_cd");
				
				// RHQ Combo 세팅
				if(!ComIsEmpty(sLclHqOfcCd)) {
					MakeComboObject(formObj.rhq_cd, sLclHqOfcCd, "^", true, "codeOnly");
				}
				
				// Period 세팅
				if(!ComIsEmpty(sNowWeek) && !ComIsEmpty(sLastWeek)) {
					formObj.fm_week.value = sLastWeek.substring(0,4) + "-" + sLastWeek.substring(4,6);
					formObj.to_week.value = sNowWeek.substring(0,4) + "-" + sNowWeek.substring(4,6);
					formObj.fm_week.focus();
					formObj.fm_week.select();
				}
				
				// RHQ Combo 활성화, 비활성화
				var pos1 = sGlblHqOfcCd.indexOf(formObj.accnt_ofc_cd.value);
				var pos2 = sLclHqOfcCd.indexOf(sArHdQtrOfcCd);

				// 로긴한 office code가 glbl_hq_ofc_cd에 포함되어 있으면~
				if(pos1 > -1) {
					// RHQ => ALL
					formObj.rhq_cd.Index = 0;
					formObj.rhq_cd.Enable = true;
					ComBtnEnable("btn_retrieve");
					
					// RHQ 코드로(MDM_ORGANIZATION.AR_HD_QTR_OFC_CD) 본부 기준 조회하기 위한 flag value
					formObj.send_flag.value = "HQ";
				}
				// 로긴한 office code의 ar_hd_qtr_ofc_cd가 lcl_hq_ofc_cd에 포함되어 있고
				// RHQ combo가 비활성화 상태이면
				//else if(pos2 > -1 && !formObj.rhq_cd.Enable) {
				else if(pos2 > -1) {
					formObj.rhq_cd.Code2 = sArHdQtrOfcCd;
					//formObj.rhq_cd.Enable = false;
					formObj.rhq_cd.Enable = true;
					ComBtnEnable("btn_retrieve");
					
					// account.office_cd(MDM_ORGANIZATION.OFC_CD)로 사무소별 조회하기 위한 flag value
					formObj.send_flag.value = "BRNCH";
				}
				// 로긴한 office code가 본부(SELHO)도 아니고, lcl_hq_ofc_cd에도 포함되어 있지 않을 때~
				else {
					// RHQ의 선택이 없게~
					formObj.rhq_cd.Index2 = "-1";
					formObj.rhq_cd.Enable = true;
					//formObj.rhq_cd.Enable = false;
					//ComBtnDisable("btn_retrieve");
				}
				
				if(formObj.send_flag.value == "BRNCH") {
					
					rhq_cd_OnChange(comboObjects[0] , comboObjects[0].Code, comboObjects[0].Text);
				} else {
					
					// Sub-Conti Combo 세팅
					if(!ComIsEmpty(sSubContiCd)) {
						MakeComboObject(formObj.sconti_cd, sSubContiCd, "^", true, "codeText");
					}
					
					// LCC 세팅
					if(!ComIsEmpty(sLccCd)) {
						MakeComboObject(formObj.lcc_cd, sLccCd, "^", true, "codeOnly");
					}
					
					// ECC 세팅
					if(!ComIsEmpty(sEccCd)) {
						MakeComboObject(formObj.ecc_cd, sEccCd, "^", true, "codeOnly");
					}
				}
				
				// MAS에서 호출하는 부분과 관련하여 로직 추가(2016.04.22)
				// [CHM-201641102] [테마제안 캠페인]Pre CM/OP 화면에서 EQ Status 조회 컬럼 추가
				if(formObj.mas_rhq.value != "" && formObj.mas_rhq.value != "null" && formObj.mas_rhq.value != "NULL" ) {
					formObj.rhq_cd.text = formObj.mas_rhq.value;
					formObj.ecc_cd.text = formObj.mas_ecc.value;
					doActionIBSheet(sheetObj , formObj , IBSEARCH);
				}
				// MAS 작업 끝
				
				break; 
			
			case IBSEARCH_ASYNC02:	// RHQ OnChange -> Sub-Conti combo Setting
				
				formObj.sconti_cd.RemoveAll();

				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0060GS.do", FormQueryString(formObj));
				
				var sSubContiCd = ComGetEtcData(sXml, "sub_conti_cd");
				
				// Sub-Conti Combo 세팅
				if(!ComIsEmpty(sSubContiCd)) {
					MakeComboObject(formObj.sconti_cd, sSubContiCd, "^", true, "codeText");
				}
				
				break;	
				
			case IBSEARCH_ASYNC03:	// Sub-Conti OnChange -> LCC combo Setting
				
				formObj.lcc_cd.RemoveAll();
				
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0060GS.do", FormQueryString(formObj));
				
				var sLccCd = ComGetEtcData(sXml, "lcc_cd");
				
				// LCC 세팅
				if(!ComIsEmpty(sLccCd)) {
					MakeComboObject(formObj.lcc_cd, sLccCd, "^", true, "codeOnly");
				}
				
				break;
				
			case IBSEARCH_ASYNC04:	// LCC OnChange -> ECC combo Setting
				
				formObj.ecc_cd.RemoveAll();
				
				formObj.f_cmd.value = SEARCH04;
				var sXml = sheetObj.GetSearchXml("EES_CIM_0060GS.do", FormQueryString(formObj));
				
				var sEccCd = ComGetEtcData(sXml, "ecc_cd");
				
				// ECC 세팅
				if(!ComIsEmpty(sEccCd)) {
					MakeComboObject(formObj.ecc_cd, sEccCd, "^", true, "codeOnly");
				}
				
				break;
			
			case IBDOWNEXCEL:	// 입력
				if ( sheetObj.rowCount != 0 ) {
					sheetObj.Down2Excel(-1, false, false, true);
				} else {
					ComShowCodeMessage("COM132202", "Down Excel");	// msgs['COM132202'] = '{?msg1} is not available.';
					return;
				}
				break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSEARCH:	// Retrieve
				with (formObj) {
					
					if(ComIsEmpty(rhq_cd.Text)) {
						ComShowCodeMessage("CIM30022", "RHQ");	// msgs['CIM30022'] = 'Mandatory field is missing. Please input {?msg1}';
						return false;
					}
					
					if(ComIsEmpty(fm_week.value)) {
						ComShowCodeMessage("CIM30022", "Period(From)");	// msgs['CIM30022'] = 'Mandatory field is missing. Please input {?msg1}';
						return false;
					}
					
					if(ComIsEmpty(to_week.value)) {
						ComShowCodeMessage("CIM30022", "Period(To)");	// msgs['CIM30022'] = 'Mandatory field is missing. Please input {?msg1}';
						return false;
					}
				}
				
				break;
			
		}
		return true;
	}
	
	/**
	 * sheet1 조회종료
	 * sheet1 조회종료후 이벤트 호출
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		sheetObj.Redraw = false;
		if ( sheetObj.rowCount != 0 ) {
			with(sheetObj)
			{
				// Row Loop
				for(var i = 2; i <= LastRow; i++)
				{
					// Col Loop
					for(var j = 1; j <= LastCol; j++) {
						
						/** Inventory Surplus/Deficit Status **/
						if(ColSaveName(j).substring(2, 6) == "_sts") {
							
							CellFont("FontName", i, j) = "Courier New";		// Font
							
							if(CellValue(i, j).substring(0, 1) == "0") {
								CellValue2(i, j) = "";						// 0%, 0 ==> ""
							}
						}
					}
				}
			}
		}
		sheetObj.Redraw = true;
	}
	
	/** 
	 * RHQ OnChange action<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @param String Code
	 * @param String Text
	 * @return none
	 * @see #
	 * @author Kim Chang Young
	 * @version 2014.04.04
	 */
	function rhq_cd_OnChange(cmbObj , Code, Text) {
//		alert(Code + ", " + Text) ;
		var formObj = document.form;
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
		
		formObj.sconti_cd.focus();
	}
	
	/** 
	 * Sub-Conti OnChange action<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @param String Code
	 * @param String Text
	 * @return none
	 * @see #
	 * @author Kim Chang Young
	 * @version 2014.03.25
	 */
	function sconti_cd_OnChange(cmbObj , Code, Text) {
//		alert(Code + ", " + Text) ;
		var formObj = document.form;
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
		
		formObj.lcc_cd.focus();
	}
	
	/** 
	 * LCC OnChange action<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @param String Code
	 * @param String Text
	 * @return none
	 * @see #
	 * @author Kim Chang Young
	 * @version 2014.03.25
	 */
	function lcc_cd_OnChange(cmbObj , Code, Text) {
//		alert(Code + ", " + Text) ;
		var formObj = document.form;
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
		
		formObj.ecc_cd.focus();
	}
