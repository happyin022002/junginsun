/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0130.js
*@FileTitle : JO TPB Process Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.3
* --------------------------------------------------------
* History
* 2008.08.27 O Wan-Ki 			1.0	최초 생성
* 2009.07.27 O Wan-Ki 			1.1	팝업버튼 활성화
* 2009.10.12 Jong-Geon Byeon	1.2 ALPS Migration
* 2010.08.09 Jong-Geon Byeon	1.3 CHM-201005106-01
* 2013.05.08 Ja Young Shin [CHM-201324216] [TPB] SINWA TPB OFC 등록
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
     * @class ESD_TPB_105 : ESD_TPB_105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_105() {
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
  //var calPop = new calendarPopupGrid();
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

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
  		// 1-1. jsp에서 선언된 sheet Object들을 배열화 한다.(sheet Object가 여러개일수 있으므로)
  	}
  	
  	function ComAddComboItem2(obj, pText, pValue) {  	  		
		if(obj != null )
		{ 
			var optionItem   = document.createElement("option");
			optionItem.text  = pText;
			optionItem.value = pValue;
			 
			obj.add(optionItem);
			return obj.length;
		}
		return 0;		
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
  		
  		if(document.form.s_office_level.value == "H"){
			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2', new Array("s_ofc_cd_for_rhq","s_office_level"));
		} else if(document.form.s_office_level.value == "R"){
			ComClearCombo(document.form.s_if_rhq_cd);
			if(ComAddComboItem2(document.form.s_if_rhq_cd, document.form.s_rhq_cd_for_rhq.value, document.form.s_rhq_cd_for_rhq.value) > 0){
				if_rhq_cd_OnChange2();
			}
			
		}else if(document.form.s_office_level.value == "G" ||  document.form.s_office_level.value == "T" ||  document.form.s_office_level.value == "C" || document.form.s_office_level.value == ""){			
			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','5', new Array("s_ofc_cd_for_rhq","s_office_level"));			
			if_rhq_cd_OnChange2();
		}
		document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange2;
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
  					//SheetWidth = 785;
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msAll;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 10);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(31, 0, 0, false);
  		
  					// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable, ColumnMove, AllCheckEnable, UserResize, RowMove, Head3D]
  					InitHeadMode(true, true, false, true, false, false)
 					
  					var HeadTitle1 = "TES Data|TES Data|TES Data|TES Data|TES Data|TES Data|TES Data|TES Data|TES Data|TES Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|TPB Data|AR Data|AR Data|AR Data|AR Data|AR Data|AR Data";
  					var HeadTitle2 = "|Inv. Office|CSR No.|Reject|S/P Invoice No.|Cost Code|Cur|Amount|Carrier|Remark|TPB Status|TPB No.|TPB Invoice No.|3rd Party Code|3rd Party Name|Cur|Interface Amount|Confirmed Amount|Invoice Amount|Revenue Amount|ERP I/F Date|I/F User|I/F Office|Recovery Activity|Cancel CSR No.|G/L Date|ERP I/F Sts.|Cur|Amount|CSR No.|Display Type";
  					
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);
  					InitHeadRow(1, HeadTitle2, true);
  		
  					//데이터속성	[   ROW,   COL,	DATATYPE, 	  WIDTH,	DATAALIGN,  COLMERGE,	SAVENAME,   	   KEYFIELD,	CALCULOGIC,   DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty( 0, cnt++,	dtHiddenStatus,	 40,	daCenter,	   false,	"ibflag");
  					InitDataProperty( 0, cnt++, dtData, 		 65, 	daCenter,	    true, 	"cost_ofc_cd"       , false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		120, 	daCenter,	    true, 	"csr_no"          	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 45, 	daCenter,	    true, 	"tml_inv_rjct_sts_cd", false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		120, 	daCenter,	    true, 	"inv_no"    		, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 65, 	daCenter,	    true, 	"lgs_cost_cd"      	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 40, 	daCenter,	   false, 	"curr_cd"      		, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		110, 	daRight ,	   false, 	"inv_amt"         	, false, 	"", 			dfFloat, 			2, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 50, 	daCenter,	   false, 	"tml_crr_cd"       	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 70, 	daCenter,	   false, 	"calc_rmk"       	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		130, 	daLeft  ,	   false, 	"ots_sts_nm"      	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		100, 	daCenter,	   false, 	"n3pty_no"        	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		100, 	daCenter,	   false, 	"n3pty_inv_no"    	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		100, 	daCenter,	   false, 	"trd_party_code"  	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		120, 	daLeft  ,	   false, 	"trd_party_name"  	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 50, 	daCenter,	   false, 	"if_curr_cd"      	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		110, 	daRight ,	   false, 	"if_amt"          	, false, 	"", 			dfFloat, 			2, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		110, 	daRight ,	   false, 	"cfm_amt"         	, false, 	"", 			dfFloat, 			2, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		110, 	daRight ,	   false, 	"inv_amt1"         	, false, 	"", 			dfFloat, 			2, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		110, 	daRight ,	   false, 	"rev_amt"         	, false, 	"", 			dfFloat, 			2, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		100, 	daCenter,	   false, 	"inv_if_dt"	       	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 70, 	daCenter,	   false, 	"cre_usr_id"       	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 65, 	daCenter,	   false, 	"inv_if_ofc_cd"    	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtImage, 		130, 	daCenter,	   false, 	"clt_act_yn"      	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		120, 	daCenter,	   false, 	"cxl_csr_no"   	  	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		100, 	daCenter,	   false, 	"gl_eff_dt"    	  	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		100, 	daCenter,	   false, 	"inv_erp_if_sts_cd"	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		 40, 	daCenter,	   false, 	"ar_curr_cd"     	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		110, 	daCenter,	   false, 	"chg_amt"     	  	, false, 	"", 			dfFloat, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtData, 		120, 	daCenter,	   false, 	"ap_ar_offst_no"  	, false, 	"", 			dfNone, 			0, 		false, 		false );
  					InitDataProperty( 0, cnt++, dtHidden, 		 30, 	daCenter,	   false, 	"display_type" 	  	, false, 	"", 			dfNone, 			0, 		false, 		false );

  					ImageList(0) = "/hanjin/img/button/btng_collectionactivity.gif";
  					ImageList(1) = "/hanjin/img/button/btng_collectionactivity_yellow.gif";

  					DataLinkMouse("clt_act_yn") = true;

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
//  				case "btn_add":
//  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
//  					break;
//  				case "btn_cancel":
//  					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
//  					break;
//  				case "btn_save":
//  					doActionIBSheet(sheetObject,formObject,IBSAVE);
//  					break;
//  				case "btn_remove":
//  					break;
  				case "btns_calendar2":
  					if (!document.all.btns_calendar2.disabled){
	  					var cal = new ComCalendarFromTo();
	  					cal.displayType = "date";
	  					cal.select(formObject.s_sdate, formObject.s_edate,'yyyy-MM-dd');
  					}
  					break;
  				case "btn_preview":
  					sheetObject.ExcelPrint = "PreView";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_print":
  					sheetObject.ExcelPrint = "PrintOnly";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					formObject.reset();
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
  				sheetObj.DoSearch4Post("ESD_TPB_0130GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBSAVE:		//저장
  				
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0130GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert(-1);
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
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
  	function sheet_OnSearchEnd(sheetObj,errMsg){
  		//if(errMsg!=null){
  		//	ComShowMessage(errMsg);
  		//}
  	}
  	
  	function sheet1_OnClick(sheetObj, Row,Col,Value){

  		/// Recovery Activity 버튼 클릭시 팝업
  		if ( sheetObj.ColSaveName(Col) == "clt_act_yn" ) { 
  			var r_n3pty_no = sheetObj.CellValue(Row, "n3pty_no");
  			var r_n3pty_inv_no = sheetObj.CellValue(Row, "n3pty_inv_no");
  			
  			openRecoveryActPopup(r_n3pty_no,r_n3pty_inv_no,'','N');
  		}
  	}
  	
  	function if_rhq_cd_OnChange2(){
  		var f = document.form;
  		if(f.s_office_level.value == "H" || f.s_office_level.value == "R"){ //Head Office, RHQ
  			getTPBGenCombo('s_if_ofc_cd','searchJoHandleOfficeList','F','','11', new Array("s_if_rhq_cd","s_office_level"));
  			//getTPBGenCombo('s_if_ofc_cd','searchJoHandleOfficeList','F','','11', new Array("s_if_rhq_cd","s_office_level"), '', "if_ctrl_cd_OnChange");
  		}else if(f.s_office_level.value == "G" || f.s_office_level.value == "T" || f.s_office_level.value == "C" || f.s_office_level.value == ""){ //General Office
  			ComClearCombo(f.s_if_ofc_cd);
  			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  		}
  	}	
	/* 개발자 작업  끝 */