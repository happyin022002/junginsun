/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0124.js
*@FileTitle : JO TPB Handling
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 박성진
*@LastVersion : 1.4
* 2008-09-11 O Wan-Ki 1.0 최초 생성
* 2008-11-18 O Wan-Ki 1.1 타 페이지로부터 Link 받는 기능 추가
* 2009-01-20 O Wan-Ki 1.2 revise amount 데이터 포맷 변경, I/F Amount, I/F Currency, I/F USD Amount 칼럼 추가.
* 2009-01-29 O Wan-Ki 1.3 조회쿼리 보완에 따른 변경 (컬럼추가)
* 2009-11-16 Park Sung-Jin 1.4 ALPS Migration 작업
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
     * @class ESD_TPB_0124 : ESD_TPB_0124 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0124() {
    	this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.setTabObject           = setTabObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;        
        this.initControl            = initControl;
        this.initTab                = initTab;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    }
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;

  var isJORetrive = false; // Added By Kim Jin-seung In 2007-08-10
  var MaxDetailCount = 100; // Maximum Detatil Count .... Added By Kim Jin-seung In 2008-01-09

  var final_retrieve_querystrings = ""; /// 최종 retrieve 조건 query string 저장 

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
  		// tpb_3rdPartyStaffClear(document.form.s_vndr_cust_div_cd);

  		if(document.form.s_n3pty_no.value != "" || document.form.s_dao_n3pty_no.value != ""){
  			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		} else if ( document.form.s_n3pty_no_strs_link.value.length >= 14) {
  			//document.form.s_n3pty_no.value = document.form.s_n3pty_no_strs_link.value
  		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
  					style.height = 380;
  										
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;

  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;

  				   //전체Edit 허용 여부 [선택, Default false]
  					Editable = true;

  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 10, 10);

  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(34, 0, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)
  					
  					var HeadTitle1 = " | |TPB No.|Invoice No.|Invoice No.|Invoice No.|Exp. Type|Exp. Type|Exp. Type|S/P Inv. No.|EQ No.|3rd Party|3rd Party|3rd Party|Revenue VVD|I/F(TES/TRS/M&R)|I/F(TES/TRS/M&R)|I/F(TES/TRS/M&R)|Currency|Outstanding AMT|Revised AMT|Confirmation|Confirmation|Confirmation|Overdue|ERP I/F|ERP I/F|ERP I/F|Recovery Activity|invoice_able|revise_able|erpif_able|length_n3pty_bil_tp_cd|trd_party_code_o";
  					var HeadTitle2 = " | |TPB No.|Invoice No.|||Main|Sub code|Sub|S/P Inv. No.|EQ No.|Division|Code|Name|Revenue VVD|Cur.|Amount|USD|Currency|Outstanding AMT|Revised AMT|ID|Name|Date|Overdue|ID|Name|Date|Recovery Activity|invoice_able|revise_able|erpif_able|length_n3pty_bil_tp_cd|trd_party_code_o";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);
  					InitHeadRow(1, HeadTitle2, true);
  				   
  					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtHiddenStatus,100,  daCenter, false,    "sts",                 false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtRadioCheck, 30,    daCenter,  true,    "chk",                 false,          "",       dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "n3pty_no",            false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "n3pty_inv_no",        false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  true,    "n3pty_inv_rvis_seq",  false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  true,    "n3pty_inv_rvis_cd",   false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,       70,    daCenter, false,    "n3pty_src_sub_sys_cd",false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtHidden,     60,    daCenter, false,    "n3pty_bil_tp_cd",     false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      130,    daCenter, false,    "n3pty_bil_tp_nm",     false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      150,    daCenter,  true,    "n3pty_src_no",        false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "eq_no",               false,          "",       dfNone,    0,     false,       true); /// Added By Kim Jin-seung In 2007-08-07

  					InitDataProperty(0, cnt++, dtHidden,     50,    daCenter,  true,    "vndr_cust_div_cd",    false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "trd_party_code",      false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      150,    daLeft,    true,    "trd_party_name",      false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "revenue_vvd",         false,          "",       dfNone,    0,     false,       true);

  					// * 2009-01-20 O Wan-Ki 1.2 revise amount 데이터 포맷 변경, I/F Amount, I/F Currency, I/F USD Amount 칼럼 추가.
  					InitDataProperty(0, cnt++, dtData,       50,    daCenter,  true,    "if_curr_cd",          false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,       80,    daRight,   true,    "if_amt",              false,          "",       dfFloat,   2,     false,       true);
  					InitDataProperty(0, cnt++, dtData,       80,    daRight,   true,    "if_amt_usd",          false,          "",       dfFloat,   2,     false,       true);

  					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "curr_cd",             false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      110,    daRight,   true,    "ots_amt",             false,          "",       dfFloat,   2,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      110,    daRight,   true,    "rvs_amt",             false,          "",       dfFloat,   2,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "cfm_usr_id",          false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "cfm_usr_nm",          false,          "",       dfNone,    0,     false,       true); // added in 2008-11-25
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "cfm_dt",              false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "overdue",             false,          "",       dfNone,    0,     false,       true); // added in 2008-11-25
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "erpif_usr_id",        false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "erpif_usr_nm",        false,          "",       dfNone,    0,     false,       true);
  					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "erpif_dt",            false,          "",       dfNone,    0,     false,       true); // added in 2008-11-25
  					InitDataProperty(0, cnt++, dtImage,     120,    daCenter,  true,    "rcvr_act_yn",         false,          "",       dfNone,    0,     false,       false); // added in 2008-11-25

  					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "invoice_able",        false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "revise_able",         false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "erpif_able",          false,          "",       dfNone,    0,     false,       false);
  					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "length_n3pty_bil_tp_cd",          false,          "",       dfNone,    0,     false,       false); // added in 2008-11-27
  					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "trd_party_code_o",    false,          "",       dfNone,    0,     false,       false);

  					ImageList(0) = "/hanjin/img/button/btng_collectionactivity.gif";
  					ImageList(1) = "/hanjin/img/button/btng_collectionactivity_yellow.gif";

  					DataLinkMouse("rcvr_act_yn") = true;
          			
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
  				case "bttn_add":
  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "bttn_cancel":
  					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "bttn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "bttn_remove":
  					break;
  				case "bttn_preview":
  					sheetObject.ExcelPrint = "PreView";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  					sheetObject.ExcelPrint = "PrintOnly";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_vvd":
  					var param = '?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  					ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					document.all.btn_invoice_t.style.display = "none";
  					document.all.btn_revise_t.style.display = "none";
  					document.all.btn_erpif_t.style.display = "none";
  					document.all.btn_modification_t.style.display = "none";
  					break;
  				case "btn_3rdParty":
  					get3rdPartyToSearch( formObject.s_vndr_cust_div_cd.value );
  					break;
  				case "btns_calendar1":
  					var cal = new ComCalendar();
  					cal.displayType = "date";
  					cal.select(formObject.s_sdate, 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					var cal = new ComCalendarFromTo();
  					cal.displayType = "date";
  					cal.select(formObject.s_sdate, formObject.s_edate,'yyyy-MM-dd');
  					break;
  				case "btn_invoice":
  					//formObject.f_cmd.value = SEARCH01;
  					formObject.f_cmd.value = SEARCH;
  					var str = "";
  					for(var i=2;i<=sheetObject.RowCount+1;i++){
  						if(sheetObject.CellValue(i,"chk") == "1"){
  							str += sheetObject.CellValue(i,"n3pty_no")+"|";
  							formObject.s_trd_party_code.value = sheetObject.CellValue(i,"trd_party_code_o");
  						}
  			  		}
  					formObject.s_dao_n3pty_no.value = str;
  					formObject.method = "post";
  					formObject.action = "ESD_TPB_0126.do?pgmNo=ESD_TPB_0126";
  					formObject.submit();
  					break;
  				case "btn_revise":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_erpif":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				/*case "btn_roc":
  					var str = getCheckN3ptyNo(formObject,sheetObject); 
  					if(str != ''){
  						formObject.f_cmd.value = SEARCH;
  						formObject.method = "post";
  						formObject.action = "ESD_TPB_0113.do?sysCommUiTitle=TPB Response Office Change&sysCommUiNavigation=Service Delivery > 3rd Party Billing > TPB Process";
  						formObject.submit();
  					}
  					break;
  				case "btn_writeoff":
  					var str = getCheckN3ptyNo(formObject,sheetObject);
  					if(str != ''){
  						formObject.f_cmd.value = SEARCH;
  						formObject.method = "post";
  						formObject.action = "ESD_TPB_0114.do?sysCommUiTitle=TPB Write-Off&sysCommUiNavigation=Service Delivery > 3rd Party Billing > TPB Process";
  						formObject.submit();
  					}
  					break;*/
  				case "btn_modification":
  					var str = getCheckN3ptyNo(formObject,sheetObject); 
  					if(str != ''){
  						formObject.f_cmd.value = SEARCH;
  						formObject.method = "post";
  						formObject.action = "ESD_TPB_0125.do?pgmNo=ESD_TPB_0125";
  						formObject.submit();
  					}
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('COM12111');
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
  				final_retrieve_querystrings = tpbFrmQryStr(formObj); /// on save end
  				sheetObj.DoSearch4Post("ESD_TPB_0124GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBSAVE:		// Revise
  				//var sRow = sheetObj.FindStatusRow("U");
  				//sRow = ComClearSeparator(sRow, "", ";");
  				for(var i=2;i<=sheetObj.RowCount+1;i++){
						if(sheetObj.CellValue(i,"chk") == "1"){
							var sRow = i;
						}
  				}
  				if(sRow == ""){
  					ComShowCodeMessage('COM12113','Invoice No.','','');
  					return;
  				}else{
					document.form.s_n3pty_inv_no.value = sheetObj.CellValue(sRow, "n3pty_inv_no");
					document.form.s_n3pty_inv_his_seq.value = sheetObj.CellValue(sRow, "n3pty_inv_rvis_seq");
					document.form.s_n3pty_inv_rmd_cd.value = sheetObj.CellValue(sRow, "n3pty_inv_rvis_cd");
          			document.form.s_trd_party_code.value = sheetObj.CellValue(sRow, "trd_party_code");
          			document.form.s_h_vndr_cust_div_cd.value = sheetObj.CellValue(sRow, "vndr_cust_div_cd");
          			document.form.s_length_n3pty_bil_tp_cd.value = sheetObj.CellValue(sRow, "length_n3pty_bil_tp_cd");
      			    document.form.s_correction_yn.value = "Y"; 
      			    document.form.f_cmd.value = SEARCH01;
          			document.form.method = "post";
          			document.form.action = "ESD_TPB_0127.do?pgmNo=ESD_TPB_0127"; //?s_n3pty_inv_no="+document.form.s_n3pty_inv_no.value+"&s_n3pty_inv_rmd="+document.form.s_n3pty_inv_rmd_cd.value+"&s_n3pty_inv_his_seq="+document.form.s_n3pty_inv_his_seq.value;
          			document.form.submit();
  				}
  				break;	
  			case IBINSERT: //ERP I/F
  				//var sRow = sheetObj.FindStatusRow("U");
  				//sRow = ComClearSeparator(sRow, ";");
  				for(var i=2;i<=sheetObj.RowCount+1;i++){
					if(sheetObj.CellValue(i,"chk") == "1"){
						var sRow = i;
					}
				}
  				
  				if(sRow == ""){
  					ComShowCodeMessage('COM12113','Invoice No.','','');
  					return;
  				}else{
  					var s_n3pty_inv = sheetObj.CellValue(sRow,"n3pty_inv_no");
  					var s_n3pty_no = sheetObj.CellValue(sRow,"n3pty_no");
  					document.form.s_n3pty_inv_no.value = sheetObj.CellValue(sRow, "n3pty_inv_no");
					document.form.s_n3pty_inv_his_seq.value = sheetObj.CellValue(sRow, "n3pty_inv_rvis_seq");
					document.form.s_n3pty_inv_rmd_cd.value = sheetObj.CellValue(sRow, "n3pty_inv_rvis_cd");
					formObj.f_cmd.value = ADD;
					sheetObj.DoSave("ESD_TPB_0124GS.do", tpbFrmQryStr(formObj),-1,false);
					
					//ERP I/F 완료된 대상 Closed로 재조회
  					document.form.s_status.value="E";
  					document.form.s_n3pty_inv_no_search.value = s_n3pty_inv;
  					document.form.s_n3pty_no.value = s_n3pty_no;
  					formObj.f_cmd.value = SEARCH;
  					sheetObj.DoSearch4Post("ESD_TPB_0124GS.do", tpbFrmQryStr(formObj));
  				}
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
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  	    document.form.s_n3pty_no_strs_link.value = "";
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  		    document.all.btn_erpif_t.style.display = "none";
  		    ComShowCodeMessage('COM12149','Data');
  			sheetObj.DoSearch4Post("ESD_TPB_0124GS.do", final_retrieve_querystrings); /// sheet data reload
  		}
  	}
  	
  	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){
  	}

  	function tpb_checkInvoiceDetailCount(sheetObj){
  		var cnt = 0;
  		for(var i=1;i<=sheetObj.RowCount;i++){
  			cnt += sheetObj.CellValue(i,"chk_box");
  		}
  		if ( cnt > MaxDetailCount ){
  			ComShowCodeMessage('TPB90052', MaxDetailCount.toString());
  		    return false;
  		} else {
  		    return true;
  		}
  	}

  	function sheet1_OnClick(sheetObj, Row,Col,Value){

  		if ( sheetObj.ColSaveName(Col) == "rcvr_act_yn" ) { 
  			var r_n3pty_no = sheetObj.CellValue(Row, "n3pty_no");
  			var r_n3pty_inv_no = sheetObj.CellValue(Row, "n3pty_inv_no");
  			
  			openRecoveryActPopup(r_n3pty_no,r_n3pty_inv_no,'','N');
  		}
  	}

  	function sheet1_OnChange(sheetObj,Row,Col,Value){
  		if ( sheetObj.ColSaveName(Col) == "chk" ) { 
              var invoice_able = sheetObj.CellValue(Row, "invoice_able");
              /// invoice button 
              if ( invoice_able == 'Y' ) {
                  document.all.btn_invoice_t.style.display = "";
              } else {
                 document.all.btn_invoice_t.style.display = "none";
              }

              var revise_able = sheetObj.CellValue(Row, "revise_able");
              /// revise button 
              if ( revise_able == 'Y' ) {
                  document.all.btn_revise_t.style.display = "";
              } else {
            	  document.all.btn_revise_t.style.display = "none";
              }
              
              var erpif_able = sheetObj.CellValue(Row, "erpif_able");
              /// erpif button 
              if ( erpif_able == 'Y' ) {
                  document.all.btn_erpif_t.style.display = "";
              } else {
                 document.all.btn_erpif_t.style.display = "none";
              }
              
            	// roc, write-off button 
              if ( revise_able != 'Y' && erpif_able != 'Y' ){
                  document.all.btn_modification_t.style.display = "";
              } else {
                 document.all.btn_modification_t.style.display = "none";
              }
              
              // tpb no            
      		document.all.s_detail_n3pty_no.value = sheetObj.CellValue(Row,"n3pty_no");
      		//3rd Party code
      		document.all.s_trd_party_code.value = sheetObj.CellValue(Row,"trd_party_code");
      		//vndr_cust_div_cd
      		document.all.s_h_vndr_cust_div_cd.value = sheetObj.CellValue(Row,"vndr_cust_div_cd");
      		document.all.s_length_n3pty_bil_tp_cd.value = sheetObj.CellValue(Row,"length_n3pty_bil_tp_cd");
  		}
  	}
  	
  	//Invoice Detail로 넘길 데이터에 대한 유효성 체크
  	function tpb_checkInvoiceList(sheetObject, formObject){
  		var rtn = true;
  		var invArr = new Array(); //선택한 row 배열
  		var bilArr = new Array(); //선택한 Billing case 배열
  		var n3pty_src_sub_sys_cd = '';
  		var trd_party_code		 = '';
  		var revenue_vvd			 = '';
  		var actual_vvd           = ''; // Added By Kim Jin-seung In 2007-08-10
  		var curr_cd				 = '';
  		var vndr_cust_div_cd	 = '';
  		var csr_no               = ''; // Added By Kim Jin-seung In 2007-08-10
  		var gl_month             = ''; // Added By Kim Jin-seung In 2007-08-10

  		for(var i=1;i<=sheetObject.RowCount;i++){
  			if(sheetObject.CellValue(i,0) == '1'){
  				invArr[invArr.length] = new Array( sheetObject.CellValue(i,"n3pty_src_sub_sys_cd")
  												  ,sheetObject.CellValue(i,"trd_party_code")
  												  ,sheetObject.CellValue(i,"revenue_vvd")
  												  ,sheetObject.CellValue(i,"curr_cd")
  												  ,sheetObject.CellValue(i,"vvd_cd") // Added By Kim Jin-seung In 2007-08-10
  												  ,sheetObject.CellValue(i,"csr_no") // Added By Kim Jin-seung In 2007-08-10
  												  ,sheetObject.CellValue(i,"gl_month") // Added By Kim Jin-seung In 2007-08-10
  												  ,i);
  				bilArr[bilArr.length] = sheetObject.CellValue(i,"n3pty_bil_tp_cd");

  				if(n3pty_src_sub_sys_cd == ''){
  					n3pty_src_sub_sys_cd = sheetObject.CellValue(i,"n3pty_src_sub_sys_cd");
  				}
  				if(trd_party_code == ''){
  					trd_party_code = sheetObject.CellValue(i,"trd_party_code");
  				}
  				if(revenue_vvd == ''){
  					revenue_vvd = sheetObject.CellValue(i,"revenue_vvd");
  				}
  				if(curr_cd == ''){
  					curr_cd = sheetObject.CellValue(i,"curr_cd");
  				}
  				if(vndr_cust_div_cd == ''){
  					vndr_cust_div_cd = sheetObject.CellValue(i,"vndr_cust_div_cd");
  				}
  				
  				if(actual_vvd == ''){ // Added By Kim Jin-seung In 2007-08-10
  					actual_vvd = sheetObject.CellValue(i,"vvd_cd");
  				}
  				if(csr_no == ''){ // Added By Kim Jin-seung In 2007-08-10
  					csr_no = sheetObject.CellValue(i,"csr_no");
  				}
  				if(gl_month == ''){ // Added By Kim Jin-seung In 2007-08-10
  					gl_month = sheetObject.CellValue(i,"gl_month");
  				}
  				
  			}
  		}

  		var invArrLen = invArr.length;
  		var invArrStr = invArr.toString();

  		// outstanding grouping check 
  		if ( isJORetrive==false ){

         		// NON J/O  : Source, 3rd Party, Revenue VVD, Currency 다른 값이 있는지 체크
      		for(var i=0;i<invArr.length;i++){

      			if(invArr[i][0] != n3pty_src_sub_sys_cd){
      				ComShowCodeMessage('TPB90001',i+1,'Source','');
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][1] != trd_party_code){
      				ComShowCodeMessage('TPB90001',i+1,'3rd Party','');
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][2] != revenue_vvd){
      				ComShowCodeMessage('TPB90001',i+1,'Revenue VVD','');
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][3] != curr_cd){
      				ComShowCodeMessage('TPB90001',i+1,'Currency','');
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      		}

  		} else {

  		    // J/O Case - Source, 3rd Party, Actual VVD, Currency, Csr No., Month of GL Date 다른 값이 있는지 체크
      		for(var i=0;i<invArr.length;i++){
      			if(invArr[i][0] != n3pty_src_sub_sys_cd){
      				ComShowCodeMessage('TPB90001',i+1,'Source','');
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][1] != trd_party_code){
      				ComShowCodeMessage('TPB90001',i+1,'3rd Party','');
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][2] != revenue_vvd){
      				ComShowCodeMessage('TPB90001',i+1,'Revenue VVD','');
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][3] != curr_cd){
      				ComShowCodeMessage('TPB90001',i+1,'Currency','');
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}

      			if(invArr[i][4] != actual_vvd){
      				ComShowCodeMessage('TPB90001',i+1,'Actual VVD','');
//      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][5] != csr_no){
      				ComShowCodeMessage('TPB90001',i+1,'CSR No.','');
//      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][6] != gl_month){
      				ComShowCodeMessage('TPB90001',i+1,'Month of GL Date','');
//      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}

      		}
    		
  		}

  		if(invArr.length == 0){
  			ComShowCodeMessage('COM12176','','','');
  			return false;
  		}else if(!rtn){
  			return rtn;
  		}

  		//Billing Case Maximum 8개 인지 체크(중복제거 후)
  		for(var i=0;i<bilArr.length;i++){
  			var dbl = 0;
  			for(var j=0;j<bilArr.length;j++){

  				if(bilArr[i] != bilArr[j]){
  					continue;
  				}else{
  					dbl++;
  					if(dbl>1){
  						bilArr.splice(j,1);
  						j--;
  					}
  				}

  			}
  		}


  		if(bilArr.length > 8){
  			ComShowCodeMessage('TPB90002','8','','');
  			rtn = false;
  		}else{
  			//Billing case 코드 갯수
  			formObject.s_length_n3pty_bil_tp_cd.value = bilArr.length;
  		}
  		//3rd Party code
  		formObject.s_trd_party_code.value = trd_party_code;
  		//vndr_cust_div_cd
  		formObject.s_h_vndr_cust_div_cd.value = vndr_cust_div_cd;

  		return rtn;
  	}

  	function getCheckN3ptyNo(formObj, sheetObj){
  	    
        document.form.s_n3pty_no_strs_link.value = "";
          
  		var str = '';
  		var sRow = sheetObj.FindCheckedRow("chk");
  		sRow = sRow.split("|")[0];
  		if(sRow == ""){
  			ComShowCodeMessage('COM12113','TPB No.','','');
  			return;
  		} else {
  		    str = sheetObj.CellValue(sRow,'n3pty_no'); 
      		document.form.s_n3pty_no_strs_link.value = str;
  		}

  		if(str == ''){
  			ComShowCodeMessage('COM12176','','','');
  		}
  		
  		// showErrMessage(str);
  		return str;
  	}

	/* 개발자 작업  끝 */