/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0107.js
*@FileTitle : TPB Group Remaking
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-04
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-09-04 Sun, CHOI 1.1 ALPS Migration
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
     * @class ESD_TPB_0107 : ESD_TPB_0107 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0107() {
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

  var n3pty_no_Array = new Array(); // it will be used on group change

  var n3pty_expn_tp_cd_Array = new Array(); // for group check condition 
  var trd_party_code_Array = new Array(); // for group check condition 
  var rev_vvd_Array = new Array(); // for group check condition 
  var cfm_curr_cd_Array = new Array(); // for group check condition 

  var act_vvd_Array = new Array(); // for group check condition // for JO
  var csr_no_Array = new Array(); // for group check condition // for JO
  var gl_month_Array = new Array(); // for group check condition // for JO


  var final_retrieve_querystrings = ""; /// 최종 retrieve 조건 query string 저장 

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBTab Object를 초기화 설정
  	 * 탭 ID는 tab1,tab2,...
  	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
  	 */
  	function InitTab() {
  		//alert("InitTab");
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

  		//document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange;
  		//document.form.s_n3pty_bil_tp_cd.onchange = s_n3pty_bil_tp_cd_OnChange;
  		//document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange_ToSearch; // for searching 
  		//document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
  		//document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur_ToSearch;
  		
  		document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange;
  		document.form.s_vndr_cust_div_cd.onchange = s_trd_party_val_OnFocus; // for searching 
  		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
  		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur_ToSearch;
  		
  		//document.all.btns_calendar2.disabled = true;
  		document.form.s_n3pty_src_sub_sys_cd.onchange = tpb_searchBillingCaseByExpenseType;
  		
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
 					style.height = 360;
 					//전체 너비 설정
 					SheetWidth = mainTable.clientWidth;
 		
 					//Host정보 설정[필수][HostIp, Port, PagePath]
 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 		
 					//전체Merge 종류 [선택, Default msNone]
 					MergeSheet = msHeaderOnly;
 		
 					//전체Edit 허용 여부 [선택, Default false]
 					Editable = true;
 		
 					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 					InitRowInfo( 2, 1, 9);
 		
 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 					InitColumnInfo(27, 9, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle1 = "STS||G/S Org|G/S|dtl_seq|AS-IS(Current)|AS-IS(Current)|TO-BE(To be Changed)|TO-BE(To be Changed)|Expense Type|Expense Type|Expense Type|S/P Invoice No.|BKG No.|B/L No.|Revenue VVD|Actual VVD|CSR No.|GL Month|EQ No.|3rd Party|3rd Party|TPB Status|Candidate YN|ROC Candidate YN|Confirm Currency|Confirmed Amount";
 					var HeadTitle2 = "STS||G/S Org|G/S|dtl_seq|TPB No.|Seq.|TPB No.|Seq.|Main|Sub Code|Sub|S/P Invoice No.|BKG No.|B/L No.|Revenue VVD|Actual VVD|CSR No.|GL Month|EQ No.|Code|Name|TPB Status|Candidate YN|ROC Candidate YN|Confirm Currency|Confirmed Amount";

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);
 		
 					//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++, dtStatus,     30,    daCenter,  true,    "ibflag",           false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "chk",              false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtHidden,       40,    daCenter,  true,    "grp_srt_no_org",   false,          "",    dfInteger,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,       40,    daCenter,  true,    "grp_srt_no",       false,          "",    dfInteger,    0,      true,       true);
     				InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  true,    "ots_dtl_seq",      false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "n3pty_no_org",     false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,       50,    daCenter,  true,    "n3pty_no_dp_seq_org",false,        "",       dfNone,    0,     false,       true);

     				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "n3pty_no",         false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,       50,    daCenter,  true,    "n3pty_no_dp_seq",  false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,       50,    daCenter,  true,    "n3pty_expn_tp_cd", false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtHidden,     50,    daCenter,  true,    "n3pty_bil_tp_cd",  false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,      120,    daLeft  ,  true,    "n3pty_bil_tp_nm",  false,          "",       dfNone,    0,     false,       true);
     
     				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "n3pty_src_no",     false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "bkg_no_all",       false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "bl_no_all",        false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "rev_vvd",          false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtHidden,      100,    daCenter,  true,    "act_vvd",          false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtHidden,      100,    daCenter,  true,    "csr_no",           false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtHidden,      100,    daCenter,  true,    "gl_month",         false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "eq_no",            false,          "",       dfNone,    0,     false,       false);
     				
     				InitDataProperty(0, cnt++, dtData,       100,    daCenter, true,    "trd_party_code",   false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,       150,    daLeft,   true,    "trd_party_name",   false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,       120,    daLeft ,  true,    "ots_sts_nm",       false,          "",       dfNone,    0,     false,       true);
    				InitDataProperty(0, cnt++, dtHidden,       120,    daCenter , true,    "candidate_yn",          false,          "",      dfNone,    0,     false,       true);
    				InitDataProperty(0, cnt++, dtHidden,       120,    daCenter , true,    "roc_candidate_yn",          false,          "",      dfNone,    0,     false,       true);
    				InitDataProperty(0, cnt++, dtData,       110,    daCenter, true,    "cfm_curr_cd",      false,          "",       dfNone,    0,     false,       true);
     				InitDataProperty(0, cnt++, dtData,       120,    daRight , true,    "cfm_amt",          false,          "",      dfFloat,    2,     false,       true);

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
  				case "btns_calendar1":
  					var cal = new ComCalendar();
  					cal.displayType = "date";
  					cal.select(formObject.s_sdate, 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					if (!document.all.btns_calendar2.disabled){
	  					var cal = new ComCalendarFromTo();
	  					cal.displayType = "date";
	  					cal.select(formObject.s_sdate, formObject.s_edate,'yyyy-MM-dd');
  					}
  					break;
  				case "btn_vvd":
  					var param = '?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  					ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					break;
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_3rdParty":
  					get3rdPartyToSearch( formObject.s_vndr_cust_div_cd.value );
  					break;
  				case "btn_settlement":
  					var str = getCheckN3ptyNo(formObject,sheetObject);
  					if(str != ''){
  						formObject.f_cmd.value = SEARCH;
  						formObject.method = "post";
  						formObject.action = "ESD_TPB_0015.do";
  						formObject.submit();
  					}
  					break;
  				case "btn_invoicecreation":
  					var vndr_cust_div_cd = "";
  				    var ots_sts_cd = "";
  					var n3ptyArr = new Array(); //선택한 n3pty No 배열

  					for(var i=1;i<=sheetObject.RowCount;i++){
  						if(sheetObject.CellValue(i,"chk") == '1'){
  							//Staff은 Invoice Creation 불가, Outstanding Initial 상태만 가능
  							if( sheetObject.CellValue(i,"vndr_cust_div_cd") == "S" ||
  								(sheetObject.CellValue(i,"ots_sts_cd") != "O" && sheetObject.CellValue(i,"ots_sts_cd") != "M") ){
  								ComShowMessage(ComGetMsg('TPB90011','','',''));
  								return;
  							}
  							n3ptyArr[n3ptyArr.length] = new Array(sheetObject.CellValue(i,"n3pty_no")
  																  ,sheetObject.CellValue(i,"cfm_dt"));

  						}
  					}

  					if(n3ptyArr.length == 0){
  						ComShowMessage(ComGetMsg('COM12176','','',''));
  						return;
  					} else if(n3ptyArr.length > 0){
  						// 서로 다른 n3pty_no 가 있는지 체크한다.
  						if( n3ptyArr.length == 1 ){
  						//if( tpb_equal_n3ptyNo(n3ptyArr, sheetObject) ){ //삭제됨 2007.02.27
  							formObject.s_n3pty_no.value = n3ptyArr[0][0];
  							formObject.s_cfm_dt.value = n3ptyArr[0][1];
  							formObject.f_cmd.value = "";
  							formObject.action = "ESD_TPB_0028.do";
  							formObject.submit();
  						}else{
  							formObject.s_dao_n3pty_no.value = tpb_getN3ptyArr(n3ptyArr, "NO", "");
  							formObject.s_cfm_dt_prev.value = tpb_getN3ptyArr(n3ptyArr, "DATE", "PREV");
  							formObject.s_cfm_dt_last.value = tpb_getN3ptyArr(n3ptyArr, "DATE", "LAST");
  							formObject.f_cmd.value = "";
  							formObject.action = "ESD_TPB_0028.do";
  							formObject.submit();
  						}

  					}

  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg('COM12111'));
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
  				sheetObj.DoSearch4Post("ESD_TPB_0107GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBSAVE:		//저장
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0107GS.do", tpbFrmQryStr(formObj));
  				//doActionIBSheet(sheetObj,formObj,IBSEARCH);
  				break;
  			case IBINSERT:	   //입력
  				var Row = sheetObj.DataInsert();
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

  			if(document.all.period_class.className == "star"){
  				if(s_sdate.value == ""){
  					ComShowCodeMessage("TPB90098",Msg_Required);
  					s_sdate.focus();
  					return false;
  				}
  				if(s_edate.value == ""){
  					ComShowCodeMessage("TPB90098",Msg_Required);
  					s_edate.focus();
  					return false;
  				}
  			}
  			
  			// if (trim(formObj.s_edn_tp_cd.value) == ''){ // Added By Kim Jin-seung in 2007-04-30
  			// 	ComShowMessage("'EAC Type' " + Msg_Required);
  			// 	formObj.s_edn_tp_cd.focus();
  			// 	return false;
  			// }

//  			if(formObj.s_ots_amt_from.value != ''){
//  				if(formObj.s_ots_amt_to.value == ''){
//  					ComShowMessage(getMsg('COM12130','Amount','number',''));
//  					formObj.s_ots_amt_to.focus();
//  					return false;
//  				}
//  			}
//  			if(formObj.s_ots_amt_to.value != ''){
//  				if(formObj.s_ots_amt_from.value == ''){
//  					ComShowMessage(getMsg('COM12130','Amount','number',''));
//  					formObj.s_ots_amt_from.focus();
//  					return false;
//  				}
//  			}
  		}
  		
  		return true;
  	}
  	
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	 
	function sheet1_OnSearchEnd(sheetObj,errMsg){
//  			for ( var i = 0; i <= sheetObj.RowCount; i++ ){
//  				sheetObj.CellFontUnderline(i+1, "n3pty_no") = true;
//  			}

		//Outstanding Amount 의 Auto Update check
//  			tpb_chgColor_ots_amt(sheetObj, 27, 12);

		//alert(sheetObj.CellValue(2,"grp_srt_no").toString());
		if(errMsg==null && erMsg == ''){
			ComShowMessage(errMsg);
		} else {
    		//var temp = "";
    		for(var i=2; i<sheetObj.RowCount+2; i++){ // 배열에 초기 정보 grp_srt_no, n3pty_no 추가 
    		    n3pty_no_Array      [sheetObj.CellValue(i,"grp_srt_no").toString()] = sheetObj.CellValue(i,"n3pty_no"); 
    		    n3pty_expn_tp_cd_Array[sheetObj.CellValue(i,"grp_srt_no").toString()] = sheetObj.CellValue(i,"n3pty_expn_tp_cd"); 
    		    trd_party_code_Array[sheetObj.CellValue(i,"grp_srt_no").toString()] = sheetObj.CellValue(i,"trd_party_code"); 
    		    rev_vvd_Array       [sheetObj.CellValue(i,"grp_srt_no").toString()] = sheetObj.CellValue(i,"rev_vvd"); 
    		    cfm_curr_cd_Array   [sheetObj.CellValue(i,"grp_srt_no").toString()] = sheetObj.CellValue(i,"cfm_curr_cd"); 
    		    //act_vvd_Array       [sheetObj.CellValue(i,"grp_srt_no").toString()] = sheetObj.CellValue(i,"act_vvd"); 
    		    //csr_no_Array        [sheetObj.CellValue(i,"grp_srt_no").toString()] = sheetObj.CellValue(i,"csr_no"); 
    		    //gl_month_Array      [sheetObj.CellValue(i,"grp_srt_no").toString()] = sheetObj.CellValue(i,"gl_month"); 
    		    //temp += "\n" + sheetObj.CellValue(i,"n3pty_no");
    		    //alert(sheetObj.CellValue(i,"grp_srt_no").toString()); 
    		}

//  	    		showErrMessage( temp ); 
//  	    		temp = ""; 
//  	    		for(var i=1; i<n3pty_no_Array.length; i++ ){
//  	    		    temp += "\n" + n3pty_no_Array[i.toString()]; 
//  	    		}
//  	    		showErrMessage( temp ); 
//=========================================================================================================================================================
//			var check_cnt = 1;
//			var grp_srt_no_org = "";
//			var grp_srt_no = "";
//			var before_tpb_no = "";
//			var now_tpb_no = "";
//			
//			for(var i = 1; i <= sheetObj.RowCount ; i++){
//				//grp_srt_no_org = sheetObj.CellValue(i+1,'grp_srt_no_org')
//				//grp_srt_no = sheetObj.CellValue(i+1,'grp_srt_no')
//				before_tpb_no = sheetObj.CellValue(i+1,'n3pty_no_org')
//				now_tpb_no = sheetObj.CellValue(i+1,'n3pty_no')
//				//alert(before_tpb_no);
//				//sheetObj.CellValue2(i+1,'grp_srt_no_org') = i;
//				//sheetObj.CellValue2(i+1,'grp_srt_no') = i;
//				//if(before_tpb_no == now_tpb_no){
//				//alert(now_tpb_no.length());
//				//if(now_tpb_no.length() > 0 && before_tpb_no != now_tpb_no){
//				//sheetObj.CellValue2(i+1,'grp_srt_no') = i;
//
//				if(before_tpb_no != now_tpb_no){
//					//sheetObj.RowStatus(Row) = "";
//					//sheetObj.CellValue(i+1,'n3pty_no_org') = sheetObj.CellValue(i+1,'n3pty_no');
//				} else {
//					//sheetObj.RowStatus(Row) = "";
//				}
//			}
//=========================================================================================================================================================
		}
	}
  					
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			//ComShowMessage(getMsg('COM12149','Data'));
  			ComShowMessage(ComGetMsg('COM12149','Data'));
  			sheetObj.DoSearch("ESD_TPB_0107GS.do", final_retrieve_querystrings ); /// sheet data reload
  		}
  	}
  	
  	function sheet1_OnChange(sheetObj,Row,Col,Value){
  	    // ComShowMessage( Row + " / " + Col + " / " + Value + " / " + sheetObj.CellValue(Row,"grp_srt_no") ); return;

  		/// Check change에 따른 이벤트 처리 
  		if ( sheetObj.ColSaveName(Col) == "grp_srt_no" ) { 
  		    
  		    var n3pty_no_ToBe           = n3pty_no_Array        [Value.toString()]; 
  		    
  		    var n3pty_expn_tp_cd_MustBe = n3pty_expn_tp_cd_Array[Value.toString()]; 
  		    var trd_party_code_MustBe   = trd_party_code_Array  [Value.toString()]; 
  		    var rev_vvd_MustBe          = rev_vvd_Array         [Value.toString()]; 
  		    var cfm_curr_cd_MustBe      = cfm_curr_cd_Array     [Value.toString()]; 
  		    
  		    //var act_vvd_MustBe  = act_vvd_Array [Value.toString()]; 
  		    //var csr_no_MustBe   = csr_no_Array  [Value.toString()]; 
  		    //var gl_month_MustBe = gl_month_Array[Value.toString()]; 
  		    
  		    if ( n3pty_no_ToBe != undefined && n3pty_no_ToBe !=null && n3pty_no_ToBe.length==14 ){

  		        /// group 필수 체크 - Expense Type Main
  		        if ( sheetObj.CellValue(Row,"n3pty_expn_tp_cd") != n3pty_expn_tp_cd_MustBe ) {
  		            ComShowMessage(ComGetMsg('TPB90065', 'Expense Type - Main'));
  		            sheetObj.CellValue2(Row,"grp_srt_no") = sheetObj.CellValue(Row,"grp_srt_no_org"); 
  		            return;
  		        }		        
  		        /// group 필수 체크 - 3rd Party Code
  		        if ( sheetObj.CellValue(Row,"trd_party_code") != trd_party_code_MustBe ) {
  		            ComShowMessage(ComGetMsg('TPB90065', '3rd Party'));
  		            sheetObj.CellValue2(Row,"grp_srt_no") = sheetObj.CellValue(Row,"grp_srt_no_org"); 
  		            return;
  		        }
  		        /// group 필수 체크 - Revenue VVD
  		        if ( sheetObj.CellValue(Row,"rev_vvd") != rev_vvd_MustBe ) {
  		            ComShowMessage(ComGetMsg('TPB90065', 'Revenue VVD'));
  		            sheetObj.CellValue2(Row,"grp_srt_no") = sheetObj.CellValue(Row,"grp_srt_no_org"); 
  		            return;
  		        }
  		        /// group 필수 체크 - Currency 
  		        if ( sheetObj.CellValue(Row,"cfm_curr_cd") != cfm_curr_cd_MustBe ) {
  		            ComShowMessage(ComGetMsg('TPB90065', 'Currency'));
  		            sheetObj.CellValue2(Row,"grp_srt_no") = sheetObj.CellValue(Row,"grp_srt_no_org");
  		            return;
  		        }
  		        /// group 필수 체크 - Acual VVD
  		        //if ( sheetObj.CellValue(Row,"act_vvd") != act_vvd_MustBe ) {
  		        //    ComShowMessage(getMsg('TPB90065','Acual VVD'));
  		        //    return;
  		        //}
  		        /// group 필수 체크 - CSR No.
  		        //if ( sheetObj.CellValue(Row,"csr_no") != csr_no_MustBe ) {
  		        //    ComShowMessage(getMsg('TPB90065','CSR No'));
  		        //    return;
  		        //}
  		        /// group 필수 체크 - Month of GL Date
  		        //if ( sheetObj.CellValue(Row,"gl_month") != gl_month_MustBe ) {
  		        //    ComShowMessage(getMsg('TPB90065','the Month of GL Date'));
  		        //    return;
  		        //}


  		        /// to-be tpb no 할당 
         		    sheetObj.CellValue2(Row,"n3pty_no") = n3pty_no_ToBe; 
//=========================================================================================================================================================
  		        	//if ( sheetObj.CellValue(Row,"grp_srt_no") == sheetObj.CellValue(Row,"grp_srt_no_org") ){ /// 복원일 경우 
         		   	//	sheetObj.CellValue2(Row,"n3pty_no") = sheetObj.CellValue(Row,"n3pty_no_org"); 
  		        	//} else { /// 다른 값일 경우 
        		    //	sheetObj.CellValue2(Row,"n3pty_no") = ""; 
  		        	//}
//=========================================================================================================================================================
         		    if ( sheetObj.CellValue(Row,"n3pty_no") == sheetObj.CellValue(Row,"n3pty_no_org") ){ /// 복원일 경우
         		    	sheetObj.CellValue2(Row,"n3pty_no_dp_seq") = sheetObj.CellValue(Row,"n3pty_no_dp_seq_org"); 
         		    } else { /// 다른 값일 경우 
         		    	sheetObj.CellValue2(Row,"n3pty_no_dp_seq") = ""; 
         		    }
         		    
              } else {
            	  	if (sheetObj.CellValue(Row,"candidate_yn") == "N" || sheetObj.CellValue(Row,"roc_candidate_yn") == "N") {
						ComShowMessage(ComGetMsg('TPB90068', 'ROC-in'));
						sheetObj.CellValue2(Row,"grp_srt_no") = sheetObj.CellValue(Row,"grp_srt_no_org"); 
					}else {
						sheetObj.CellValue2(Row,"n3pty_no") = ""; 
						sheetObj.CellValue2(Row,"n3pty_no_dp_seq") = ""; 
					}
              }
  		}
  	}

  	function sheet1_OnClick(sheetObj,Row,Col,Value){
//  		alert(sheetObj.CellValue(Row,23));
//  		if(sheetObj.ColSaveName(Col) == 'n3pty_no'){
//  			document.form.f_cmd.value = SEARCH;
//  			document.form.s_n3pty_no.value = sheetObj.CellValue(Row, Col);
//  			document.form.s_h_ots_sts_cd.value = sheetObj.CellValue(Row, "ots_sts_cd");
//  			document.form.s_trd_party_code.value = sheetObj.CellValue(Row, "trd_party_code");
//  			document.form.s_h_vndr_cust_div_cd.value = sheetObj.CellValue(Row, "vndr_cust_div_cd");
//  			document.form.s_h_n3pty_inv_no.value = sheetObj.CellValue(Row, "n3pty_inv_no");
//  			document.form.method = "post";
//  			document.form.action = "ESD_TPB_0006.do";
//  			document.form.submit();
//  		}else if(sheetObj.ColSaveName(Col) == 'clt_act_yn'){
//  			var clt_act_yn = sheetObj.CellValue(Row,Col)
//  			//if(clt_act_yn != '0' && clt_act_yn != ''){
//  				// openCollectionActPopup(sheetObj.CellValue(Row,"n3pty_no"), '');
//  				openCollectionActPopup(sheetObj.CellValue(Row,"n3pty_no"), '', sheetObj.CellValue(Row,"fm_clt_cng_ofc_n3pty_no")); // ROC From 포함시 
//  			//}
//  		}
  	}

  	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
  		/*
  		var mRow = sheetObj.MouseRow;
  		var mCol = sheetObj.MouseCol;
  		if(sheetObj.ColSaveName(mCol) == 'clt_act_yn'){
  			if(sheetObj.CellValue(mRow,mCol) == '0' || sheetObj.CellValue(mRow,mCol) == ''){
  				sheetObj.MousePointer = "Default";
  			}
  		}*/
  	}

  	function setSource(sObj){
  		var val = sObj.value;
  		if(sObj.type == 'radio'){
  			var obj = form.s_n3pty_src_sub_sys_cd;
  			for(i=0; i<obj.length; i++)	{
  				var compValue = obj[i].value;
  				  if(compValue == val)
  				   { 	
  						obj.selectedIndex = i 
  						break;
  				   }else{
  						obj.selectedIndex = 0;
  				   }
  			}
  		}else if(sObj.type == 'select-one'){
  			var obj = form.s_n3pty_src_sub_sys_cd_check;
  			if(val == ''){
  				for(i=0; i<obj.length; i++)	{
  					obj[i].checked = false;
  				}
  			}else{
  				for(i=0; i<obj.length; i++)	{
  					var compValue = obj[i].value;
  					if(compValue  == val){
  						//obj[i].disabled = false;
  						obj[i].checked = true
  					}else{
  						//obj[i].disabled = true
  					}
  				}
  			}
  		}
  	}


  	function if_rhq_cd_OnChange(){
  		var f = document.form;
  		if(f.s_office_level.value == "H" || f.s_office_level.value == "R"){ //Head Office, RHQ
  			getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','11', new Array("s_if_rhq_cd","s_office_level"));
  		}else if(f.s_office_level.value == "G" || f.s_office_level.value == "T" || f.s_office_level.value == "C" || f.s_office_level.value == ""){ //General Office
  			//clear_Combo(f.s_if_ofc_cd);
  			ComClearCombo(f.s_if_ofc_cd);
  			//add_Combo(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  			ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
  		}
  	    
  	}

  	function getCheckN3ptyNo(formObj, sheetObj){
  		var str = '';
  		var otsCd = true;
  		var otsCdCnt = 0;

  		if(sheetObj.RowCount > 0){
  			var o = document.createElement("<input type='hidden' name='n3pty_no'>");
  			document.form.appendChild(o);

  			for ( var i = 0; i <= sheetObj.RowCount; i++ ){
  				if(sheetObj.RowStatus(i) == 'U'){
  					str += sheetObj.CellValue(i,'n3pty_no')+"|";

  					//settlement로 넘기는 데이타의 ots_sts_cd 는 O,J,L,M 만 가능하다.
  					var ots = sheetObj.CellValue(i, "ots_sts_cd");
  					if(ots != 'O' && ots != 'J' && ots != 'L' && ots != 'M'){
  						otsCd = false;
  					}else{
  						otsCdCnt++;
  					}
  				}
  			}
  			document.form.n3pty_no.value = str;
  		}

  		if(str == ''){
  			ComShowMessage(getMsg('COM12176','','',''));
  		}
  		if(!otsCd){
  			ComShowMessage(getMsg('TPB90003','','',''));
  			if(otsCdCnt == 0) str = '';
  		}

  		return str;
  	}

  	function s_n3pty_bil_tp_cd_OnChange(formObj){
  		var obj = document.form.s_n3pty_bil_tp_cd;
  		var str = obj.value;
  		if(str != '' || get_Combo(obj) == 'ALL'){
  			document.form.s_edn_tp_cd.value = "";
  			document.form.s_edn_tp_cd.disabled = true;
  		}else{
  			document.form.s_edn_tp_cd.disabled = false;
  		}
  	}

  	function tpb_searchBillingCaseByExpenseType(){
  		getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseByExpenseType','F','','2',new Array("s_n3pty_src_sub_sys_cd"));
  		
  		var obj = document.form.s_n3pty_src_sub_sys_cd;
  		var str = obj.value;

  		if(str != '' || get_Combo(obj) == 'ALL'){
  			document.form.s_edn_tp_cd.disabled = false;
  		}else{
  			document.form.s_edn_tp_cd.disabled = true;
  		}
  	}

  	function tpb_getN3ptyArr(arr, gubun, type){
  		var str = "";
  		var dateArr = new Array();
  		var otsCdCnt = 0;

  		for ( var i = 0; i < arr.length; i++ ){
  			if(gubun.toUpperCase() == 'NO'){
  				str += arr[i][0]+",";
  			}else if(gubun.toUpperCase() == 'DATE'){
  				dateArr[dateArr.length]= arr[i][1];
  			}
  		}

  		if(gubun.toUpperCase() == "DATE"){
  			dateArr = dateArr.sort();
  			if(type.toUpperCase() == "PREV") str = dateArr[0];
  			else if (type.toUpperCase() == "LAST") str = dateArr[dateArr.length-1];
  		}
  		return str;
  	}

  	//동일한 N3PTY_NO 를 선택하였는지 체크한다.
  	// Deprecated 2007.02.27
  	function tpb_equal_n3ptyNo(n3ptyArr, sheetObj){
  		var rtn = true;

  		for(var i=0;i<n3ptyArr.length;i++){
  			var dbl = 0;
  			for(var j=0;j<n3ptyArr.length;j++){

  				if(n3ptyArr[i][0] != n3ptyArr[j][0]){
  					continue;
  				}else{
  					dbl++;
  					if(dbl>1){
  						n3ptyArr.splice(j,1);
  						j--;
  					}
  				}

  			}
  		}

  		if(n3ptyArr.length > 1){
  			ComShowMessage(getMsg('COM12113','3rd Party No','',''));
  			rtn = false;
  		}

  		return rtn;
  	}

  	function checkPeriod(val){
  		if(val == "T"){ //TPB
  			document.all.s_sdate.disabled = true;
  			document.all.s_edate.disabled = true;
  			document.all.btns_calendar2.disabled = true;
  			document.all.period_class.className	= "nostar";
  			
  			document.all.s_ots_sts_cd_detail_open.style.display = ''; /// Added By Kim Jin-seung In 2008-05-20
  			document.all.s_ots_sts_cd_detail_close.style.display = 'none'; /// Added By Kim Jin-seung In 2008-05-20
  		}else{
  			document.all.s_sdate.disabled = false;
  			document.all.s_edate.disabled = false;
  			document.all.btns_calendar2.disabled = false;
  			document.all.period_class.className	= "star";

  			document.all.s_ots_sts_cd_detail_open.style.display = 'none'; /// Added By Kim Jin-seung In 2008-05-20
  			document.all.s_ots_sts_cd_detail_close.style.display = ''; /// Added By Kim Jin-seung In 2008-05-20
  		}
  		
  	}

  	function tpb_searchBillingCaseByExpenseType(){
  		getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseByExpenseType','F','','2',new Array("s_n3pty_src_sub_sys_cd"));
  	}
	/* 개발자 작업  끝 */