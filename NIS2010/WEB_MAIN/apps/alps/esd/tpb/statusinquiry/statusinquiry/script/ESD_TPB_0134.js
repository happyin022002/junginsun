/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0134.js
*@FileTitle : TPB Status by Booking(B/L)
*Open Issues :
*Change history :
*@LastModifyDate : 2010-01-19
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2010-01-19 Sun, Choi 1.0 최초 생성
* 2010-01-19 Sun, Choi 1.1 ALPS Migration
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
     * @class ESD_TPB_0134 : ESD_TPB_0134 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0134() {
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
  		
  		//document.all.btns_calendar2.disabled = true;
  		if (document.form.s_state.value == "BKG"){
	  		var formObject = document.form;
	  		
	  		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);  // BKG 에서 호출
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
  					style.height = 160;
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 9);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(38, 3, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)
  		
  					var HeadTitle = "STS||TPB No.|Seq.|Source|Invoice No.|Invoice Date|Source No.|BKG No.|B/L No.|VVD|EQ No|Type|3rd Party Code|3rd Party Name|TPB Status|Overdue|Currency|Original|Invoice|Collect|Adjust|Balance|I/F User|I/F Office|Adjust Type|R.O.C From|R.O.C To|From TPB No.|Recovery Activity|EAC Type|CSR No.";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  		
  					//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtHiddenStatus,     30,    daCenter,  true,    "");
      				InitDataProperty(0, cnt++, dtHidden,   30,    daCenter,  true,    "chk");
      				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "n3pty_no",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  true,    "n3pty_no_dp_seq",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       50,    daCenter,  true,    "n3pty_src_sub_sys_cd",        false,          "",       dfNone,    0,     false,       true);
      
      				InitDataProperty(0, cnt++, dtData,       95,    daCenter,  true,    "n3pty_inv_no",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "inv_iss_dt",        false,          "",       dfNone,    0,     false,       false);
      				InitDataProperty(0, cnt++, dtData,      130,    daCenter,  true,    "n3pty_src_no",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       90,    daCenter,  true,    "bkg_no_all",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       85,    daCenter,  true,    "bl_no_all",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       65,    daCenter,  true,    "vvd",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      120,    daCenter,  true,    "eq_no",        false,          "",       dfNone,    0,     false,       false);
      				
      				InitDataProperty(0, cnt++, dtData,       160,    daCenter, true,    "n3pty_bil_tp_nm",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       100,    daCenter, true,    "trd_party_code",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       150,    daLeft,   true,    "trd_party_name",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       120,    daLeft ,  true,    "ots_sts_nm",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,        70,    daRight,  true,    "overdue",        false,          "",      dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,        70,    daCenter, true,    "curr_cd",        false,          "",      dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       100,    daRight , true,    "ots_amt",        false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       100,    daRight , true,    "inv_amt",        false,          "",      dfFloat,    2,     false,       true);
      
      				InitDataProperty(0, cnt++, dtHidden,     100,    daRight,  true,    "clt_amt",        false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       100,    daRight,  true,    "stl_amt",        false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       100,    daRight,  true,    "bal_amt",        false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "if_usr_id",        false,          "",       dfNone,    0,     false,       true); // Added By Kim Jin-seung in 2007-04-26
      				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "if_ofc_cd",        false,          "",       dfNone,    0,     false,       true); // Added By Kim Jin-seung in 2007-04-26
      				InitDataProperty(0, cnt++, dtData,      150,    daCenter,  true,    "n3pty_stl_tp_cd",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       70,    daCenter,  true,    "stl_rqst_ofc_cd",        false,          "",       dfNone,    0,     false,       true);
      
      				InitDataProperty(0, cnt++, dtData,       60,    daCenter,  true,    "stl_to_clt_cng_ofc_cd",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "fm_clt_cng_ofc_n3pty_no",      false,          "",       dfNone,    0,     false,       true); // Added By Kim Jin-seung in 2007-05-08
      				InitDataProperty(0, cnt++, dtImage,     130,    daCenter,  true,    "clt_act_yn",        false,          "",       dfNone,    0,     false,       false);
      				InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "edn_tp_nm",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      125,    daCenter,  true,    "csr_no",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "ots_sts_cd",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "vndr_cust_div_cd",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "curr_cd",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "n3pty_bil_tp_cd",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "cfm_dt",        false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,     80,    daCenter,  true,    "so_if_seq",        false,          "",       dfInteger,    0,     false,       true);
      
      				ImageList(0) = "/hanjin/img/button/btng_collectionactivity.gif";
      				ImageList(1) = "/hanjin/img/button/btng_collectionactivity_yellow.gif";
      
      				//DataLinkMouse("n3pty_no") = true;
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
  					var cal = new ComCalendarFromTo();
  					cal.displayType = "date";
  					cal.select(formObject.s_sdate, formObject.s_edate,'yyyy-MM-dd');
  					break;
  				case "btn_vvd":
  					var param = '?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  					ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					//formObject.s_edn_tp_cd.disabled = false;
  					//ComClearCombo(formObject.s_n3pty_bil_tp_cd);
  					//ComAddComboItem(formObject.s_n3pty_bil_tp_cd, "<<Select>>", "");
  					//document.all.period_class.className	= "nostar";
  		  			//document.all.s_sdate.className	= "";
  		  			//document.all.s_edate.className	= "";
  					//document.all.s_sdate.disabled = true;
  					//document.all.s_edate.disabled = true;
  					//document.all.btns_calendar2.disabled = true;
  					break;
  				case "btn_3rdParty":
  					get3rdPartyToSearch( formObject.s_vndr_cust_div_cd.value );
  					break;
  				case "btn_settlement":
  					var str = getCheckN3ptyNo(formObject,sheetObject);
  					if(str != ''){
  						formObject.f_cmd.value = SEARCH;
  						formObject.method = "post";
  						return;
  						formObject.action = "ESD_TPB_0015.do?pgmNo=ESD_TPB_0015";
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
  							return;
  							formObject.action = "ESD_TPB_0106.do";
  							formObject.submit();
  						}else{
  							formObject.s_dao_n3pty_no.value = tpb_getN3ptyArr(n3ptyArr, "NO", "");
  							formObject.s_cfm_dt_prev.value = tpb_getN3ptyArr(n3ptyArr, "DATE", "PREV");
  							formObject.s_cfm_dt_last.value = tpb_getN3ptyArr(n3ptyArr, "DATE", "LAST");
  							formObject.f_cmd.value = "";
  							return;
  							formObject.action = "ESD_TPB_0106.do";
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
  				formObj.f_cmd.value = SEARCH;
  				if(formObj.s_bkg_no_all.value != "" || formObj.s_bl_no_all.value != "" ){
  					sheetObj.DoSearch4Post("ESD_TPB_0134GS.do", tpbFrmQryStr(formObj));
  				}
  				break;
  			case IBSAVE:		//저장
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0134GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBINSERT:	  //입력
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

  			if(!ComChkValid(formObj)) return false; // 다시 추가 예정

  			//if(document.all.period_class.className == "star"){
  			if(document.all.s_sdate.className == "input1" && document.all.s_edate.className == "input1"){
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
  			
  			// if (ComTrim(formObj.s_edn_tp_cd.value) == ''){ // Added By Kim Jin-seung in 2007-04-30
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
  		for ( var i = 0; i <= sheetObj.RowCount; i++ ){
  			sheetObj.CellFontUnderline(i+1, "n3pty_no") = true;
  		}

  		//Outstanding Amount 의 Auto Update check
  		tpb_chgColor_ots_amt(sheetObj, 27, 12);
  		
  	}
  					
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(ComGetMsg('COM12149','Data','',''));
  		}
  	}

  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  		if(sheetObj.ColSaveName(Col) == 'n3pty_no'){
//  			document.form.f_cmd.value = SEARCH;
//  			document.form.s_n3pty_no.value = sheetObj.CellValue(Row, Col);
//  			document.form.s_h_ots_sts_cd.value = sheetObj.CellValue(Row, "ots_sts_cd");
//  			document.form.s_trd_party_code.value = sheetObj.CellValue(Row, "trd_party_code");
//  			document.form.s_h_vndr_cust_div_cd.value = sheetObj.CellValue(Row, "vndr_cust_div_cd");
//  			document.form.s_h_n3pty_inv_no.value = sheetObj.CellValue(Row, "n3pty_inv_no");
//  			document.form.method = "post";
//  			document.form.action = "ESD_TPB_0115.do";
//  			document.form.submit();
//              location.href = "ESD_TPB_0115.do?pgmNo=ESD_TPB_0115&s_direct_tpb_no="+sheetObj.CellValue(Row, Col);
  		}else if(sheetObj.ColSaveName(Col) == 'clt_act_yn'){
  			var clt_act_yn = sheetObj.CellValue(Row,Col)
  			//if(clt_act_yn != '0' && clt_act_yn != ''){
  				// openCollectionActPopup(sheetObj.CellValue(Row,"n3pty_no"), '');
//  				openCollectionActPopup(sheetObj.CellValue(Row,"n3pty_no"), '', sheetObj.CellValue(Row,"fm_clt_cng_ofc_n3pty_no")); // ROC From 포함시 
  				openRecoveryActPopup(sheetObj.CellValue(Row,"n3pty_no"), '', sheetObj.CellValue(Row,"fm_clt_cng_ofc_n3pty_no"),'N'); // ROC From 포함시 
  			//}
  		}
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

	/* 개발자 작업  끝 */