/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0101.js
*@FileTitle : TPB Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-08-29 O Wan-Ki			1.0  최초 생성
* 2009-07-02 Jong-Geon Byeon	1.1 ALPS Migration
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
     * @class ESD_TPB_0101 : ESD_TPB_0101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0101() {
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
    /* 공통전역변수 */
    var curTab = 1;
    var beforetab = 0;
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
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
					style.height = 440;
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
		
					var HeadTitle = "Del.|STS|I/F Type|Expense Type|Code|Name|Description|SCEM Exception Case|Interfaced To|Active\nFlag|Charge|Account|SAC Code";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성		[ROW,COL	,DATATYPE	,WIDTH	,DATAALIGN	,COLMERGE	,SAVENAME			,KEYFIELD	,CALCULOGIC	,DATAFORMAT	,POINTCOUNT	,UPDATEEDIT	,INSERTEDIT	,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtDelCheck,    30,   daCenter,    true,    "");
					InitDataProperty(0, cnt++, dtStatus,      30,   daCenter,    true,    "ibflag");
					InitDataProperty(0, cnt++, dtCombo,      100,   daLeft,      true,    "n3pty_if_tp_cd",      true,          "",       dfNone,       0,      true,         true,     1);
					InitDataProperty(0, cnt++, dtCombo,      100,   daCenter,    true,    "n3pty_expn_tp_cd",    true,          "",       dfNone,       0,      true,         true,     3);
					InitDataProperty(0, cnt++, dtData,        50,   daCenter,    true,    "n3pty_bil_tp_cd",     true,          "",       dfNone,       0,      false,        true,     2);
					InitDataProperty(0, cnt++, dtData,       160,   daCenter,    true,    "n3pty_bil_tp_nm",     true,          "",       dfNone,       0,      true,         true,     50);
					InitDataProperty(0, cnt++, dtData,       300,   daLeft,      true,    "n3pty_bil_tp_desc",   true,          "",       dfNone,       0,      true,         true,     500);
					InitDataProperty(0, cnt++, dtHidden,     200,   daCenter,    true,    "expt_cs_cd",          false,         "",       dfNone,       0,      true,         true,     3);
					InitDataProperty(0, cnt++, dtHidden,     100,   daCenter,    true,    "cml_sys_if_cd",       true,          "",       dfNone,       0,      true,         true,     1); // originally dtCombo
					InitDataProperty(0, cnt++, dtHidden,      30,   daCenter,    true,    "act_flg",             true,          "",       dfNone,       0,      true,         true,     1);
					InitDataProperty(0, cnt++, dtData,        50,   daCenter,    true,    "chg_cd",              false,         "",       dfNone,    	0,     	true,         true,     3);
					InitDataProperty(0, cnt++, dtData,        60,   daCenter,  	 true,    "rev_acct_cd",         false,         "",       dfNone,    	0,     	true,         true,     6);
					InitDataProperty(0, cnt++, dtData,        50,   daCenter,  	 true,    "ida_sac_cd",          false,         "",       dfNone,    	0,     	true,         true,     6);



					InitDataCombo (0, "n3pty_expn_tp_cd", combo01Text, combo01Code);
					InitDataCombo (0, "cml_sys_if_cd", combo02Text, combo02Code);
					InitDataCombo (0, "act_flg", "Y|N", "Y|N","Y");
			      //InitDataCombo (0, "n3pty_if_tp_cd", combo03Text, combo03Code);
					InitDataCombo (0, "n3pty_if_tp_cd",  "Logistics Revenue|"+combo03Text,  "R|"+combo03Code);
					getTPBGenCombo('s_billing_case_cd','searchBillingCaseCode','F','','1');
					
					InitDataValid (0, "n3pty_bil_tp_cd", vtEngUpOther, "1234567890");  
					InitDataValid (0, "chg_cd", vtEngUpOther, "1234567890"); 

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
		
		 var sheetObject = sheetObjects[0];
	     var formObject = document.form;
	     
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_add":
					   doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_downexcel":
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
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TPB_0101GS.do", tpbFrmQryStr(formObj));
				break;
			case IBSAVE:		//저장
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESD_TPB_0101GS.do", tpbFrmQryStr(formObj));
				
				break;
			case IBINSERT:	  //입력
				var Row = sheetObj.DataInsert(-1);
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	
	/**
  	 * IBSheet 내 셀 값이 변경되었을 때 처리되는 함수.
  	 * 
  	 */	
  	function sheet1_OnChange(sheetObj, Row, Col, Value){

  		var colNm = sheetObj.ColSaveName(Col);
  		var temp;
  		var cnt = 0;
  		var chgCd = sheetObj.CellValue(Row,"chg_cd");
  		var ifType = sheetObj.CellValue(Row,"n3pty_if_tp_cd");

  		// n3pty_bil_tp_cd Duplication Check
  		if( colNm == "n3pty_bil_tp_cd" && Value != "" ){
  			for(i=1;i<=sheetObj.RowCount;i++)
  			{
  				temp = sheetObj.CellValue(i,"n3pty_bil_tp_cd");
  				if( Value == temp ) cnt = cnt + 1;
  			}
  			
  			if( cnt > 1 )	// 화면상 중복 체크
  			{
  				ComShowCodeMessage('TPB90069');
  				sheetObj.CellValue2(Row,'n3pty_bil_tp_cd') = '';
  			} else	// DB 중복 체크
  			{
  				document.form.s_n3pty_bil_tp_cd.value = Value;
  	  			getTPBGenCombo('CheckTPBCode','checkBillingCaseCode','V','','',new Array('s_n3pty_bil_tp_cd'),Value);
  			}
  		}
  		
  		if( colNm == "n3pty_bil_tp_cd" ||colNm == "chg_cd" ||colNm == "n3pty_if_tp_cd" ){
 				if(ifType != "R" ){
				   temp = "3"+sheetObj.CellValue(Row,"n3pty_bil_tp_cd");
				   if( chgCd != temp  ){
					 sheetObj.CellValue2(Row,"chg_cd") = temp ;
				   }
				}
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
	

    /* 개발자 작업  끝 */