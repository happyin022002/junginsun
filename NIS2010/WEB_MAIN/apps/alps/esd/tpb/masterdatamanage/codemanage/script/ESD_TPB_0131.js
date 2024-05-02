/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0131.js
*@FileTitle : TPB Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.0
* 2009.07.03 Jong-Geon Byeon	1.0 ALPS Migration
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
	var curTab = 1;
    var beforetab = 0;
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    /**
     * @extends 
     * @class ESD_TPB_0131 : ESD_TPB_0131 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0131() {
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
    /**
	 * IBTab Object를 초기화 설정
	 * 탭 ID는 tab1,tab2,...
	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
	 */
	function InitTab() {
		try{
			with(document.all.tab1){
				InsertTab(0, "Dry Index" , 23 );
				InsertTab(1, "Tanker Index" , 23); 
				InsertTab(2, "Time Charter" , 23 );
				InsertTab(3, "Bunker Price" , 23 );
				InsertTab(4, "Ship Price" , 23); 
				InsertTab(5, "FFA Index" , 23 );
				TabBackColor(0)="146,174,230";
			}
		}catch(e){
			ComShowMessage(e);
		}
	}
	
	/**
	 * tab1의 onChange이벤트핸들러
	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	
	/**
	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
	 */
	function ChangeTab(tabObj,nItem){
		tabObj.BackColor="#FFFFFF";
		tabObj.TabBackColor(nItem)="146,174,230";
	
		var objs = document.all.item("tabLayer");
		objs[beforetab].style.display = "none";
		objs[nItem].style.display = "Inline";
	
		//--------------- 요기가 중요 --------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
		objs[beforetab].style.zIndex = 0;
		objs[nItem].style.zIndex = 9;
		//------------------------------------------------------//
		beforetab= nItem;
	}

	/**
	 * IBSheet Object를 배열로 등록
	 * ComSheetObject(id)에서 호출한다
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
		   //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			
			//getTPBGenCombo("s_if_type","searchIfType",'F', '', '1');
			getTPBGenCombo('s_billing_case_cd','searchBillingCaseCode','F','','1');
			getTPBGenCombo('s_expense_type','searchExpenseType','F', '', '1');
		}
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with (sheetObj) {
					var cnt = 0;
					style.height = 460;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 3, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
		
					var HeadTitle = "Del.|STS|I/F Type|Expense Type|Code|Name|Description|SCEM Exception Case|Interfaced To|Active\nFlag|Acct|Charge|SAC Code";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성	[ROW,	  COL,   DATATYPE,WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   		KEYFIELD,  CALCULOGIC,   DATAFORMAT, POINTCOUNT,   UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDelCheck,   30,    daCenter,  	true,    "");
					InitDataProperty(0, cnt++, dtStatus,     30,    daCenter,  	true,    "ibflag");
					InitDataProperty(0, cnt++, dtCombo,     120,    daLeft,  	true,    "n3pty_if_tp_cd",      true,          "",       dfNone,    	0,     		false,       false, 1);
					InitDataProperty(0, cnt++, dtCombo,     130,    daCenter,  	true,    "n3pty_expn_tp_cd",    true,          "",       dfNone,    	0,     		false,       false, 3);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter,  	true,    "n3pty_bil_tp_cd",     true,          "",       dfNone,    	0,     	    false,       false, 2);
					InitDataProperty(0, cnt++, dtData,      160,    daCenter,  	true,    "n3pty_bil_tp_nm",     true,          "",       dfNone,    	0,     		false,       false, 50);
					InitDataProperty(0, cnt++, dtData,      300,    daLeft,  	true,    "n3pty_bil_tp_desc",   true,          "",       dfNone,    	0,     		false,       false, 500);
					InitDataProperty(0, cnt++, dtHidden,    200,    daCenter,  	true,    "expt_cs_cd",       	false,         "",       dfNone,    	0,     		false,       false, 3);
					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  	true,    "cml_sys_if_cd",       true,          "",       dfNone,    	0,     		false,       false, 1); // originally dtCombo
					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  	true,    "act_flg",        		true,          "",       dfNone,    	0,     		false,       false, 1);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter,  	true,    "rev_acct_cd",         false,         "",       dfNone,    	0,     		false,       false, 6);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter,  	true,    "chg_cd",              false,         "",       dfNone,    	0,     		false,       false, 3);
					InitDataProperty(0, cnt++, dtData,       50,    daCenter,  	true,    "ida_sac_cd",          false,         "",       dfNone,    	0,     		true,        true,  6);


					InitDataCombo (0, "n3pty_expn_tp_cd", combo01Text, combo01Code);
					InitDataCombo (0, "cml_sys_if_cd", combo02Text, combo02Code);
					InitDataCombo (0, "act_flg", "Y|N", "Y|N","Y");
					InitDataCombo (0, "n3pty_if_tp_cd",  "Logistics Revenue|"+combo03Text,  "R|"+combo03Code);


					ColHidden(0) = true;
					ColHidden(1) = true;

				}
				break;
		}
	}

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
		 var sheetObject = sheetObjects[curTab-1];
		 /******************************************************/
		 var formObject = document.form;
		 if(curTab == 2)
			formObject = document.form2;
			
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_downexcel":
					sheetObject.ExcelPrint = "";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_retrieve":

					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
			} // end switch
		}catch(e) {			
			if( e == "[object Error]") {
				ComShowMessage(getMsg('COM12111'));
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
				
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TPB_0131GS.do", tpbFrmQryStr(formObj));
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		   if(!ComChkValid(formObj)) return false;
		}
		
		return true;
	}
	
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
		//if(errMsg!=null){
			//ComShowMessage(errMsg);
		//}
	}

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		if(errMsg==null || errMsg == ''){
			ComShowMessage(getMsg('COM12149','Data','',''));
		}
		IBS_EtcDataToForm2(document.form, sheetObj);

		getTPBGenCombo('s_billing_case_cd','searchBillingCaseCode');
		//getTPBGenCombo('s_if_type','searchIfType');
		getTPBGenCombo('s_expense_type','searchExpenseType','F', '', '1');

	}

	function sheet1_OnChange(sheetObj,Row,Col,Value){
		_sheet_onchange( sheetObj,Row,Col,Value );
		var selectValue = "";
		if(sheetObj.CellValue(Row,'ibflag') == 'I' 
			&& sheetObj.CellValue(Row,'n3pty_bil_tp_cd') != ""
			&& (sheetObj.ColSaveName(Col) == "n3pty_bil_tp_cd"
		                                               || sheetObj.ColSaveName(Col) == "n3pty_expn_tp_cd") ){
			var selectValue = sheetObj.CellValue(Row,'n3pty_bil_tp_cd');
			var s_codeAll = document.form.s_codeAll.value;
			var s_y = selectValue + "|Y";
			var s_n = selectValue + "|N";

			if(s_codeAll.indexOf(s_y) != -1){
				ComShowMessage(getMsg('TPB90016','','',''));
				sheetObj.CellValue2(Row,'n3pty_bil_tp_cd') = "";
			}else if(s_codeAll.indexOf(s_n) != -1){
				ComShowMessage(getMsg('TPB90017','','',''));
			}
		}
	}

	/**
	 * 코드 중복여부 체크하는 함수
	 */
	function checkTPBCode(sheetObj){
		var insertRow = new Array();
		for ( var i = 0; i <= sheetObj.RowCount; i++ ){
			if(sheetObj.CellValue(i,'ibflag') == 'I'){
				insertRow[insertRow.length] = sheetObj.CellValue(i,'n3pty_bil_tp_cd');
			}
		}
		
		if(insertRow.length > 0){
			for ( var i = 0; i <= sheetObj.RowCount; i++ ){
				for(var j = 0 ; j<insertRow.length;j++){
					if(insertRow[j] != '' && 
						sheetObj.CellValue(i,'ibflag') != 'I' && 
						sheetObj.CellValue(i,'n3pty_bil_tp_cd') == insertRow[j]){
						return false;
					}
				}
			}
		}
		return true;
	}
	/* 개발자 작업  끝 */