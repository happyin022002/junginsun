/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MST_0033.js
 *@FileTitle : EQ Procurement Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.20
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.07.20 민정호
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
 * @class EES_MST_0033 : EES_MST_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_MST_0033() {
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
var vOrcCntrTpszCd = "";

var sheetObjects = new Array();
var sheetCnt = 0;

// Combo Object Array
var comboObjects = new Array();
var comboCnt = 0;

var head_cntr_tpsz_cd = "";
var tot_cntr_tpsz_cd = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {
		var formObj = document.form;
		for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		// Form 이벤트 등록		  
		initControl();
		addCombo(); // 콤보박스 아이템 추가
		setBackColor();
	}

	/**
	 * Form 이벤트 등록
	 */
	function initControl() {
		var formObj = document.form;
	
		axon_event.addListenerFormat('blur', 'obj_deactivate', form);
		axon_event.addListenerFormat('focus', 'obj_activate', form); 
		axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
		axon_event.addListener('change', 'input_pln_yr_change', 'input_pln_yr', '');	
	}
 
	//input_pln_yr 변경시
	 function input_pln_yr_change() {
		var formObject = document.form;	 
	 	var selYr = ComGetObjValue(form.input_pln_yr);
	 	
	 	if(selYr != ''){
	 		formObject.bse_dt1.value = '';
	 	}
	 } 

	// 콤보박스 아이템 추가
	function addCombo() {
		var plnYr = "2006|"
		var today = new Date();
		var lastYr = today.getYear() + 1;
		for ( var k = 2007; k <= lastYr; k++) {
			if (k == lastYr) {
				plnYr = plnYr + k;
			} else {
				plnYr = plnYr + k + "|";
			}
		}
		var arrPlnYr = plnYr.split("|");
	
		with (form.input_pln_yr) {
			DropHeight = 270;
			for ( var i = 0; i < plnYr.split("|").length; i++) {
				InsertItem(i, arrPlnYr[i], arrPlnYr[i]);
			}
		} 
	}

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {	 	
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/** **************************************************** */
		var formObject = document.form;
		var input_pln_yr = ComGetObjValue(formObject.input_pln_yr);
		var invt_yr = ComGetObjValue(formObject.bse_dt1).substring(0,4);
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
			case "btn_downexcel":
				sheetObject1.Down2Excel(-1);
				break;
	
			case "btn_retrieve":			
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
	
			case "btn_new":
				comboObjects[0].Code = "";						
				formObject.input_pln_yr.value = "";
				formObject.bse_dt1.value = "";
	
				sheetObject1.RemoveAll();
				sheetObject1.RowEditable(1) = false;
				sheetObject1.RowEditable(7) = false;
				sheetObject1.RowEditable(9) = false;		
				sheetObject1.RowEditable(16) = false;
				sheetObject1.CellEditable(1,"g_total") = false;
				
				setBackColor();
				
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var formObj = document.form;
		
		var thetime=new Date(); 
		var now_year=thetime.getYear();//년
		
		var input_pln_yr = thetime.getYear();
		var invt_yr = input_pln_yr-1;
		var cnt = 0;
	
		switch (sheetNo) {
		case 1: //sheet1 init
			with (sheetObj) {
	        // 높이 설정
	        //style.height = 440;
	        //전체 너비 설정
	        //SheetWidth = mainTable.clientWidth;
	        SheetWidth = 989;
	
	        //Host정보 설정[필수][HostIp, Port, PagePath]
	        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	        //전체Merge 종류 [선택, Default msNone]
	        MergeSheet = msPrevColumnMerge + msHeaderOnly;       
	
	       //전체Edit 허용 여부 [선택, Default false]
	        Editable = false;
	
	        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	        InitRowInfo( 1, 1, 20, 100);
	
	        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	        InitColumnInfo(15, 0, 2, true);
	
	        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	        InitHeadMode(false, false, false, true, false,false);
	        Rows = 20;
	        var HeadTitle = "Item|TP/SZ|D2|D4|D5|D7|R2|R5|O2|O4|F2|F4|G.Total||";                     
	        
	        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			 InitHeadRow(0, HeadTitle, true);                     
	
	        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData, 200,  daCenter,  true, "item",			false,      "",      dfNone, 		0,     false,       false);
			InitDataProperty(0, cnt++ , dtData, 100,  daCenter,  true, "tp_sz",			false,      "",      dfNone, 		0,     false,       false);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "d2_qty",		false,      "",      dfNumber, 		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "d4_qty",		false,      "",      dfNumber, 		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "d5_qty",		false,      "",      dfNumber,		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "d7_qty",		false,      "",      dfNumber, 		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "r2_qty",		false,      "",      dfNumber,		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "r5_qty",		false,      "",      dfNumber, 		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "o2_qty",		false,      "",      dfNumber,		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "o4_qty",		false,      "",      dfNumber,		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "f2_qty",		false,      "",      dfNumber,		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "f4_qty",		false,      "",      dfNumber, 		0,     true,       true);
			InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "g_total",		false,      "",      dfNone, 		0,     true,       true);
			//InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "g_total",		false,      "|d2_qty|+|d4_qty|+|d5_qty|+|d7_qty|+|r2_qty|+|r5_qty|+|o2_qty|+|o4_qty|+|f2_qty|+|f4_qty|",      dfNumber,		0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden,  		0,    daCenter,  false,   "bse_yrmon");
			InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    daCenter,  false,   "ibflag");
			InitHeadColumn(0, "Inventory in Current Year|Inventory in Current Year|Inventory in Current Year|Inventory in Current Year|" +
							  "Plan Year|Plan Year|Plan Year|" +
							  "Shortage or Surplus VS Plan Year|" +
							  "Reduction Plan|Reduction Plan|Reduction Plan|Reduction Plan|Reduction Plan|Reduction Plan|" +
							  "EQ Shortage Qty in Plan Year|"+
							  "EQ Procurement Qty in Plan Year|EQ Procurement Qty in Plan Year|EQ Procurement Qty in Plan Year|EQ Procurement Qty in Plan Year");
			InitHeadColumn(1, "Total|OW|LT|ST|" +
					          "Supply Plan|Sales Plan|Utilization|" +
							  "Shortage or Surplus VS Plan Year|" +		          
					          "Total|EQ Disposal(-)|LT Off Hire(-)|ST Off Hire(-)|OW Delivery(+)|LT Delivery(+)|" +
							  "EQ Shortage Qty in Plan Year|" +
							  "Total|OW|LT|ST");
	
			CountPosition = 0;
	
			
			RowMerge(8) = true;
			RowMerge(15) = true;
			}
			break;
		}
	}
 
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: //조회
				if (validateForm(sheetObj, formObj, sAction)) {
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);					
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("EES_MST_0033GS.do", FormQueryString(formObj));
					ComOpenWait(false);					
				}
				break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			switch (sAction) {
			case IBSEARCH://조회
				if (ComGetObjValue(formObj.input_pln_yr) == "") {
					ComShowCodeMessage("MST00001", "Plan Year");
					ComSetFocus(formObj.input_pln_yr);
					return false;
				}
				break;
			}
		}
		return true;
	}

	/**
	 * Key-Press Event 처리
	 */
	function obj_keypress() {
		var obj = event.srcElement;
	
		switch (obj.dataformat) {
		case "ymd":
		case "ym":
		case "hms":
		case "hm":
		case "jumin":
		case "saupja":
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
			ComKeyOnlyAlphabet('upper');
			break;
		case "engdn":
			ComKeyOnlyAlphabet('lower');
			break;
		default:
			ComKeyOnlyNumber(obj);
			break;
		}
	}
 
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_deactivate() {
	
		var obj = event.srcElement;
		switch (obj.name) {
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			ComChkObjValid(obj);
			break;
		}
	}

	function obj_activate() {
		obj = event.srcElement;
	}

	// 조회 후 설정
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObject = document.form;
		
		sheetObj.RowMerge(8) = true;
		sheetObj.RowMerge(15) = true;
		
		var bse_yrmon = sheetObj.CellValue(1,"bse_yrmon");
		
		if(bse_yrmon != ''){
			formObject.bse_dt1.value = bse_yrmon.substring(0,4) + "-" + bse_yrmon.substring(4,6);		
		}	
		setBackColor();
	}

	// BackColor 표시
	function setBackColor(){
		sheetObjects[0].RowBackColor(1) = sheetObjects[0].SubSumBackColor;
		sheetObjects[0].RowBackColor(7) = sheetObjects[0].SubSumBackColor;
		sheetObjects[0].RowBackColor(9) = sheetObjects[0].SubSumBackColor;	
		sheetObjects[0].RowBackColor(16) = sheetObjects[0].SubSumBackColor;		
	}
/* 개발자 작업  끝 */