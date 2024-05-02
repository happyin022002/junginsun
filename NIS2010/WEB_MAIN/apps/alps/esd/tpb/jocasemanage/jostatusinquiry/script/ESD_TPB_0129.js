/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0129.js
*@FileTitle : JO TPB Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-05
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.2
* --------------------------------------------------------
* History
* 2008-09-16 O Wan-Ki 			1.0	최초 생성
* 2009-03-09 O Wan-Ki 			1.1 sync to non-JO
* 2009-10-05 Jong-Geon Byeon	1.2 ALPS Migration
* 2013.05.08 Ja Young Shin [CHM-201324216] [TPB] SINWA TPB OFC 등록
* 2015.07.30 Kim Hyun Hwa[CHM-201537151]그룹사 표준 코드 시행 프로그램 수정(8/22적용)
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

  var rowForCorrection = 0;
  //var invNoForCorrection = 0;
  //var invRmdForCorrection = 0;
  //var invHisSeqForCorrection = 0;

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
  		document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange_ToSearch; // for searching 
  		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
  		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur_ToSearch;
  		document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange;		
  		document.form.s_if_ctrl_cd.onchange = if_ctrl_cd_OnChange;
  		tpb_3rdPartyStaffClear(document.form.s_vndr_cust_div_cd);
  		

  		document.form.s_ofc_cd_for_rhq.value = "SELCON";
  		document.form.s_office_level.value = "H";
  		getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2', new Array("s_ofc_cd_for_rhq","s_office_level"));

  		if(document.form.s_office_level.value == "H"){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2', new Array("s_ofc_cd_for_rhq","s_office_level"));
  		}else if(document.form.s_office_level.value == "R"){
  			ComClearCombo(document.form.s_if_rhq_cd);
  			ComAddComboItem(document.form.s_if_rhq_cd, document.form.s_rhq_cd_for_rhq.value, document.form.s_rhq_cd_for_rhq.value);
  			setTimeout("if_rhq_cd_OnChange();",300);
  		}else if(document.form.s_office_level.value == "G" ||  document.form.s_office_level.value == "T" ||  document.form.s_office_level.value == "C" || document.form.s_office_level.value == ""){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','5', new Array("s_ofc_cd_for_rhq","s_office_level"));
  			if_rhq_cd_OnChange();
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
  					// 높이 설정
  					style.height = 410;
  										
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;

  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  					//전체Merge 종류 [선택, Default msNone]
  					//MergeSheet = msHeaderOnly;
  					MergeSheet = msAll;

  				   //전체Edit 허용 여부 [선택, Default false]
  					Editable = true;

  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 9, 100);

  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(22, 5, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, false, true, false, false)

  					var HeadTitle = "|SEQ|Office|TPB No.|Invoice No.|Version|AR B/L No.|Expense type|Currency|Net Amount|VAT Amount|Invoice Amount|ERP I/F Amount|Issued Date|Issued By|C/L|3rd Party|ERP I/F Date|length_n3pty_bil_tp_cd|3rd Party Division Code|3rd Party Code|n3pty_inv_his_seq|length_n3pty_bil_tp_cd"; // Recovery Activity|

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					
  					//데이터속성      [ROW,   COL,       DATATYPE,    WIDTH, DATAALIGN,  COLMERGE, 	  SAVENAME,  		     KEYFIELD,  CALCULOGIC,   DATAFORMAT,POINTCOUNT,UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtHiddenStatus,		100,  daCenter,		false,    "sts",					false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtSeq,        		 30,  daCenter,  	false,    "seq");
  					InitDataProperty(0, cnt++, dtData,       		 80,  daCenter,  	false,    "ofc_cd",         		false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		110,  daCenter,   	true ,    "n3pty_no",           	false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		110,  daCenter,   	true ,    "n3pty_inv_no",       	false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		 50,  daCenter,  	false,    "n3pty_inv_rvis_cd",      	false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		100,  daCenter,  	true ,    "if_bl_no",           	false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		 85,  daCenter,  	false,    "n3pty_expn_tp_cd",   	false,          "",    	  dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		 60,  daCenter,  	false,    "curr_cd",            	false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		120,  daRight ,  	false,    "ots_amt",            	false,          "",      dfFloat,    2,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		120,  daRight ,  	false,    "vat_amt",            	false,          "",      dfFloat,    2,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		120,  daRight ,  	false,    "inv_amt",            	false,          "",      dfFloat,    2,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		120,  daRight ,  	false,    "clt_amt",            	false,          "",      dfFloat,    2,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		100,  daCenter,  	false,    "inv_iss_locl_dt",    	false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,       		80,   daCenter,  	false,    "upd_usr_id",         	false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		 30,  daCenter,  	false,    "clt_agn_flg",        	false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		200,  daLeft  ,    	false,    "trd_party_nm",       	false,          "",       dfNone,    0,     false,       false);
//  					InitDataProperty(0, cnt++, dtImage,     		120,  daCenter,   	true,     "clt_act_yn",             false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtData,      		 95,  daCenter,  	false,    "ar_if_dt",           	false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtHidden,    		 30,  daCenter,  	false,    "length_n3pty_bil_tp_cd", false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtHidden,    		 30,  daCenter,  	false,    "vndr_cust_div_cd",       false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtHidden,    		 30,  daCenter,  	false,    "trd_party_code",         false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtHidden,    		 30,  daCenter,  	false,    "n3pty_inv_his_seq",      false,          "",       dfNone,    0,     false,       false);
  					// InitDataProperty(0, cnt++, dtHidden,    		 30,    daCenter,  false,    "erpif_ynm",              false,          "",       dfNone,    0,     false,       false);

  					DataLinkMouse("n3pty_no") = true;
  					// DataLinkMouse("n3pty_inv_no") = true;
  					DataLinkMouse("n3pty_inv_rvis_cd") = true;
  					// DataLinkMouse("clt_act_yn") = true;
  					
  					ColHidden("if_bl_no") = true; //2009-03-09 
  					
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
//  				case "bttn_add":
//  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
//  					break;
//  				case "bttn_cancel":
//  					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
//  					break;
//  				case "bttn_save":
//  					doActionIBSheet(sheetObject,formObject,IBSAVE);
//  					break;
//  				case "bttn_remove":
//  					break;
//  				case "bttn_preview":
//  					sheetObject.ExcelPrint = "PreView";
//  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//  					break;
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
//  				case "bttn_print":
//  					sheetObject.ExcelPrint = "PrintOnly";
//  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_3rdParty":
  					if(!window.event.srcElement.disabled){
  						get3rdPartyToSearch( formObject.s_vndr_cust_div_cd.value );
  					}
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					break;
  				case "btns_calendar1":
  					 if(!window.event.srcElement.disabled){
  						 var cal = new calendarPopup();
  						 cal.select(formObject.s_sdate, 's_sdate', 'yyyy-MM-dd');
  					 }
  					break;
  				case "btns_calendar2":
  					if (!document.all.btns_calendar2.disabled){
	  					var cal = new ComCalendarFromTo();
	  					cal.displayType = "date";
	  					cal.select(formObject.s_sdate, formObject.s_edate,'yyyy-MM-dd');
  					}
  					break;
//  				case "btn_cancellationinv":
//  					doActionIBSheet(sheetObject,formObject,REMOVE);
//  					break;
//  				case "btn_correctioninv":
//  					doActionIBSheet(sheetObject,formObject,MODIFY);
//  					break;
//  				case "btn_erpInterface":
//  					doActionIBSheet(sheetObject,formObject,ADD);
//  					break;			
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
  				if( document.form.s_cond[0].checked ){ 
  					if(!validateForm(sheetObj,formObj,sAction)) {
  						return false;
  					}
  				}
  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0129GS.do", tpbFrmQryStr(formObj));
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
  		    
  			if(s_cond[0].checked){
  				if(s_sdate.value == "" || s_edate.value == ""){
  					ComShowMessage(getMsg("COM12179","","",""));
  					return false;
  				}
  			}else if(s_cond[1].checked){
  				if(trim(s_n3pty_inv_no_for_search.value) == ""){
  					ComShowMessage(getMsg("COM12114","Invoice No.","",""));
  					s_n3pty_inv_no_for_search.focus();
  					s_n3pty_inv_no_for_search.select();
  					return false;
  				}
  			}else if(s_cond[2].checked){
  				if(trim(s_eq_no.value) == ""){
  					ComShowMessage(getMsg("COM12114","EQ No.","",""));
  					s_eq_no.focus();
  					s_eq_no.select();
  					return false;
  				}
  			}
  		    
  			if(!ComChkValid(formObj)) return false;
  		}
  		
  		return true;
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		for ( var i = 0; i <= sheetObj.RowCount; i++ ){
  			sheetObj.CellFontUnderline(i+1, "n3pty_no") = true;
  			sheetObj.CellFontUnderline(i+1, "n3pty_inv_rvis_cd") = true;
  		}

//  	    document.all.btn_cancellationinv.style.display = "none";
//  	    document.all.btn_correctioninv.style.display = "none";
//  	    document.all.btn_erpInterface.style.display = "none";
  	}
  	
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  	    // ComShowMessage( Row + " / " + Col + " / " + Value); return;
  		// if(Col=='n3pty_inv_no' || sheetObj.ColSaveName(Col) == 'n3pty_inv_no' || sheetObj.ColSaveName(Col) == 'n3pty_inv_rmd'){

  		/// Collection Activity 버튼 클릭시 팝업
  		if ( sheetObj.ColSaveName(Col) == "n3pty_no" ) {
  			var tpb_no = sheetObj.CellValue(Row, "n3pty_no");
  			if ( tpb_no != null && tpb_no != undefined && tpb_no != "" ) {
    			var r_n3pty_no = sheetObj.CellValue(Row, "n3pty_no");
      			var r_n3pty_inv_no = sheetObj.CellValue(Row, "n3pty_inv_no");
      			
      			openRecoveryActPopup(r_n3pty_no,r_n3pty_inv_no,'','Y');
  			}
  			
  		/// to Detail 
  		} else if(sheetObj.ColSaveName(Col) == 'n3pty_inv_rvis_cd'){
//  			document.form.f_cmd.value = SEARCH01;
//  			document.form.s_n3pty_inv_no_for_search.value = sheetObj.CellValue(Row, Col);
//  			document.form.s_length_n3pty_bil_tp_cd.value = sheetObj.CellValue(Row, "length_n3pty_bil_tp_cd");
//  			document.form.s_trd_party_code.value = sheetObj.CellValue(Row, "trd_party_code");
//  			document.form.s_h_vndr_cust_div_cd.value = sheetObj.CellValue(Row, "vndr_cust_div_cd");
//  			document.form.s_inquiryOnly_yn.value = "Y";
//  			document.form.method = "post";
//  			document.form.action = "ESD_TPB_127.do?s_n3pty_inv_no="+sheetObj.CellValue(Row, 'n3pty_inv_no')+"&s_n3pty_inv_rmd="+sheetObj.CellValue(Row, 'n3pty_inv_rmd')+"&s_n3pty_inv_his_seq="+sheetObj.CellValue(Row, 'n3pty_inv_his_seq');
//  			document.form.submit();
  			
  			document.form.s_detail_n3pty_no.value = sheetObj.CellValue(Row, "n3pty_no");
  			document.form.s_n3pty_inv_no.value = sheetObj.CellValue(Row, "n3pty_inv_no");
  			document.form.s_n3pty_inv_his_seq.value = sheetObj.CellValue(Row, "n3pty_inv_his_seq");
  			document.form.s_n3pty_inv_rmd_cd.value = sheetObj.CellValue(Row, "n3pty_inv_rvis_cd");
  			document.form.s_trd_party_code.value = sheetObj.CellValue(Row, "trd_party_code");
  			document.form.s_h_vndr_cust_div_cd.value = sheetObj.CellValue(Row, "vndr_cust_div_cd");
  		    document.form.s_correction_yn.value = "N"; 
  			document.form.f_cmd.value = SEARCH01;
  			document.form.method = "post";
  			document.form.action = "ESD_TPB_0127.do?pgmNo=ESD_TPB_0127"; 
  			document.form.submit();
  		}
  		
  	}
  	
//  	function sheet1_OnChange(sheetObj,Row,Col,Value){
//  	    // ComShowMessage( Row + " / " + Col + " / " + Value); return;
  //
//  		/// Check change에 따른 이벤트 처리 
//  		if ( sheetObj.ColSaveName(Col) == "chk" ) { 
//  		    
//              // ComShowMessage( Row + " / " + Col + " / " + Value);
  //
//              var erpif_ynm = sheetObj.CellValue(Row, "erpif_ynm");
  //
//              /// erp i/f 버튼  
//              if ( erpif_ynm=="Y" || erpif_ynm=="M" ) {
//  		        document.all.btn_erpInterface.style.display = "";
//              } else {
//  		        document.all.btn_erpInterface.style.display = "none";
//              }
  //
//              /// cancellation, correction 버튼 
//              if ( erpif_ynm=="M" ) {
//      		    document.all.btn_cancellationinv.style.display = "none";
//      		    document.all.btn_correctioninv.style.display = "none";
//      		} else {
//      		    document.all.btn_cancellationinv.style.display = "";
//      		    document.all.btn_correctioninv.style.display = "";
//      		}
  //
//  		}
//  		
//  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  	    
  		if(errMsg==null || errMsg == ''){
  		    
  			if(document.form.f_cmd.value == REMOVE){
  			    
  				ComShowMessage(getMsg('TPB90059'));
            		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            		
  			} else if(document.form.f_cmd.value == MODIFY){
  			    
  			    document.form.s_correction_yn.value = "Y"; 
                  // sheet1_OnClick(sheetObj,rowForCorrection,'n3pty_inv_no','');
                  
      			document.form.f_cmd.value = SEARCH01;
      			document.form.method = "post";
      			document.form.action = "ESD_TPB_127.do?pgmNo=ESD_TPB_0127&s_n3pty_inv_no="+document.form.s_n3pty_inv_no.value+"&s_n3pty_inv_rmd="+document.form.s_n3pty_inv_rmd_cd.value+"&s_n3pty_inv_his_seq="+document.form.s_n3pty_inv_his_seq.value;
      			document.form.submit();

  			} else if(document.form.f_cmd.value == ADD){

  				ComShowMessage(getMsg('COM12149','ERP Interface','',''));
      			document.all.btn_erpInterface.style.display = 'none'; 
                  
  			} else {
  			    // ComShowMessage('sss');
  			}
  			
  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  			
  		} else {
  		    
  		    ComShowMessage(errMsg);
  		    
  		}
  	}
  	