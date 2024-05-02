/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0135.js
*@FileTitle : Activity - TPB Confirmation
*Open Issues :
*Change history :
*@LastModifyDate : 2010-11-09
*@LastModifier : eunju, son
*@LastVersion : 1.1
* 2010-11-09 손은주  1.0 최초 생성
* 2010-11-18 손은주 [CHM-201006809-01][TPB] TPB Activity기간별 TPB 조회 기능 - office 관련 select box 수정
* 2010.11.19 손은주 [CHM-201006809-01] [TPB] TPB Activity기간별 TPB 조회 기능 - RHQ 필수 조건수정
* 2011-02-21 손은주 [CHM-201108686-01][TPB] 실적 조회 화면 보완 - Activity기간별 TPB 조회 기능 검색 조건 수정
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
     * @class ESD_TPB_0135 : ESD_TPB_0135 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0135() {
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
  		
  		var sheetObj = sheetObjects[0];
  		var formObj = document.form;
  		sheetObj.RemoveEtcData();
  		formObj.f_cmd.value = SEARCH01;
  		sheetObj.DoSearch4Post("ESD_TPB_0135GS.do", tpbFrmQryStr(formObj));
  		
		var user_ctrl_ofc_cd = sheetObj.EtcData('USER_CTRL_OFC_CD');	
		formObj.s_ctrl_ofc_cd.value =  user_ctrl_ofc_cd;
  		var real_office_level = formObj.s_office_level.value;
  		formObj.s_office_level.value='H';
  		
  		getRHQOfcList();
  		document.form.s_office_level.value = real_office_level;
  		setSelectBox(document.form.s_if_rhq_cd,document.form.s_rhq_cd_for_rhq.value);
  		if_rhq_cd_OnChange();
  		getCtrlOfcList();
  		if( real_office_level == 'C') setSelectBox(document.form.s_if_ctrl_cd,document.form.s_user_ofc_cd.value);
  		else setSelectBox(document.form.s_if_ctrl_cd,document.form.s_ctrl_ofc_cd.value);
  		if_ctrl_cd_OnChange();
  		setSelectBox(document.form.s_if_ofc_cd,document.form.s_user_ofc_cd.value);
  		  		
  		
  	 }
  	 
  
  	 
  	function setSelectBox(obj, value){
  		if(obj.length > 0){
  			for(var i = 0; i<obj.options.length; i++){
  				if(obj.options(i).value == value){
  					obj.options.selectedIndex = i;
  				}
  			}
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
  					InitRowInfo( 1, 1, 9);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(39, 3, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)
  		
//  					var HeadTitle = "STS||TPB No.|Seq.|Source|Invoice No.|Invoice Date|Source No.|BKG No.|B/L No.|VVD|EQ No|Type|3rd Party Code|3rd Party Name|TPB Status|Overdue|Currency|I/F AMT|Original|Invoice|Collect|Adjust|Balance|I/F User|I/F Office|Adjust Type|R.O.C From|R.O.C To|From TPB No.|Recovery Activity|EAC Type|CSR No.";
//  					var HeadTitle = "STS|S/N|TPB No.|RHQ|Con. Office|Con. Month|Source|Invoice No.|Invoice Date|Source No.|BKG No.|B/L No.|VVD|EQ No|Type|3rd Party Code|3rd Party Name|TPB Status|Overdue|Currency|Original|Invoice|Collect|Adjust|Balance|I/F User|I/F Office|Adjust Type|R.O.C From|R.O.C To|Recovery Activity|EAC Type|CSR No.";
  					var HeadTitle = "STS|S/N|TPB No.|RHQ|Confirming Office|Confirmed Month|Source|Invoice No.|Invoice Date|Source No.|BKG No.|B/L No.|VVD|EQ No|Type|3rd Party Code|3rd Party Name|TPB Status|Overdue|Currency|Original|Invoice|Collect|Adjust|Balance|I/F User|I/F Office|ROC or W/O|ROC From|ROC To|Recovery Activity|EAC Type|CSR No.";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  		
  					//데이터속성	[ROW,	  COL, DATATYPE, 	  WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtHiddenStatus,   30,    daCenter,  true,    "");
  					InitDataProperty(0, cnt++, dtData,    	 	 70,    daCenter,  true,    "n3pty_no_dp_seq",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 90,    daCenter,  true,    "n3pty_no",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 60,    daCenter,  true,    "rhq",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 90,    daCenter,  true,    "cfm_ofc_cd",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 90,    daCenter,  true,    "cfm_mon",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 50,    daCenter,  true,    "n3pty_src_sub_sys_cd",     false,          "",       dfNone,    0,     false,       true);
      
      				InitDataProperty(0, cnt++, dtData,      	 95,    daCenter,  true,    "n3pty_inv_no",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 80,    daCenter,  true,    "inv_iss_dt",        		false,          "",       dfNone,    0,     false,       false);
      				InitDataProperty(0, cnt++, dtData,      	130,    daCenter,  true,    "n3pty_src_no",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 90,    daCenter,  true,    "bkg_no_all",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 85,    daCenter,  true,    "bl_no_all",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 70,    daCenter,  true,    "vvd",        				false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    "eq_no",        			false,          "",       dfNone,    0,     false,       false);
      				
      				InitDataProperty(0, cnt++, dtData,       	160,    daCenter,  true,    "n3pty_bil_tp_nm",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	100,    daCenter,  true,    "trd_party_code",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	150,    daLeft,    true,    "trd_party_name",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	120,    daLeft ,   true,    "ots_sts_nm",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	 60,    daRight,   true,    "overdue",        			false,          "",		  dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	 60,    daCenter,  true,    "curr_cd",        			false,          "",		  dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight ,  true,    "ots_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight ,  true,    "inv_amt",        			false,          "",      dfFloat,    2,     false,       true);
      
      				InitDataProperty(0, cnt++, dtHidden,     	100,    daRight,   true,    "clt_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight,   true,    "stl_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight,   true,    "bal_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    "if_usr_id",        		false,          "",       dfNone,    0,     false,       true); // Added By Kim Jin-seung in 2007-04-26
      				InitDataProperty(0, cnt++, dtData,      	 70,    daCenter,  true,    "if_ofc_cd",        		false,          "",       dfNone,    0,     false,       true); // Added By Kim Jin-seung in 2007-04-26
      				InitDataProperty(0, cnt++, dtData,      	150,    daCenter,  true,    "n3pty_stl_tp_cd",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 70,    daCenter,  true,    "stl_rqst_ofc_cd",        	false,          "",       dfNone,    0,     false,       true);
      
      				InitDataProperty(0, cnt++, dtData,      	 70,    daCenter,  true,    "stl_to_clt_cng_ofc_cd",    false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtImage,     	130,    daCenter,  true,    "clt_act_yn",        		false,          "",       dfNone,    0,     false,       false);
      				InitDataProperty(0, cnt++, dtData,      	 80,    daCenter,  true,    "edn_tp_nm",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	125,    daCenter,  true,    "csr_no",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 80,    daCenter,  true,    "ots_sts_cd",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 80,    daCenter,  true,    "vndr_cust_div_cd",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 80,    daCenter,  true,    "curr_cd",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 80,    daCenter,  true,    "n3pty_bil_tp_cd",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 80,    daCenter,  true,    "cfm_dt",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 80,    daCenter,  true,    "so_if_seq",        		false,          "",    dfInteger,    0,     false,       true);
      
      				ImageList(0) = "/hanjin/img/button/btng_collectionactivity.gif";
      				ImageList(1) = "/hanjin/img/button/btng_collectionactivity_yellow.gif";
      
      				DataLinkMouse("n3pty_no") = true;
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
  				
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btns_calendar1":
  					var cal = new ComCalendar();
  					cal.setDisplayType('month');
  					cal.select(formObject.s_sdate, 'yyyy-MM');
  					break;
  				case "btns_calendar2":
  					var cal = new ComCalendar();
  					cal.setDisplayType('month');
  					cal.select(formObject.s_edate,'yyyy-MM');
  					break;
  				
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();  					
  		  			document.all.s_sdate.className	= "";
  		  			document.all.s_edate.className	= "";
  				
  				
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
  				sheetObj.DoSearch4Post("ESD_TPB_0135GS.do", tpbFrmQryStr(formObj));
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
			var days_between = ComGetDaysBetween(formObj.s_sdate , formObj.s_edate) ;  // 조회 기간
	   		
			if ( days_between > 365 ) {
				ComShowMessage(" Possible inquiry period is limited to 1 year.");
				return false;
			}
  			
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

  		//Outstanding Amount 의 Auto Upate check
  		tpb_chgColor_ots_amt(sheetObj, 27, 12);
  		
  	}
  					

  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  		if(sheetObj.ColSaveName(Col) == 'n3pty_no'){
              location.href = "ESD_TPB_0115.do?pgmNo=ESD_TPB_0115&s_direct_tpb_no="+sheetObj.CellValue(Row, Col);
  		}else if(sheetObj.ColSaveName(Col) == 'clt_act_yn'){
  			var clt_act_yn = sheetObj.CellValue(Row,Col)
  			openRecoveryActPopup(sheetObj.CellValue(Row,"n3pty_no"), '', sheetObj.CellValue(Row,"fm_clt_cng_ofc_n3pty_no"),'N'); // ROC From 포함시 
  		}
  	}


  	
  	function if_rhq_cd_OnChange(){
  		getCtrlOfcList();
  		getTpbOfcList();
	
  	}
  	
  	function if_ctrl_cd_OnChange(){
  		getTpbOfcList();
  		
  	}
  	
  	/**
	 * RHQ office를 combobox에 입력하는 함수 - 2010.11.17
	 */
	function getRHQOfcList() {
		
		var sheetObj = sheetObjects[0];
  		var formObj = document.form;
  		sheetObj.RemoveEtcData();
  		formObj.f_cmd.value = SEARCH02;
  		sheetObj.DoSearch4Post("ESD_TPB_0135GS.do", tpbFrmQryStr(formObj));
  		
		var rhq_ofc_cd = sheetObj.EtcData('RHQ_OFC_CD');	
		
		
		var rhqOfcCdArray = rhq_ofc_cd.split('|');

		var comboObj = eval("document.all.s_if_rhq_cd");
		
		if(comboObj != undefined) {
			ComClearCombo(comboObj);
		}
		ComAddComboItem(comboObj, "ALL", "" );
		
		var k = 0;
		while(k < rhqOfcCdArray.length-1 ){
			k++;
			ComAddComboItem(comboObj, rhqOfcCdArray[k], rhqOfcCdArray[k]);
		}
		
	}
	
	/**
	 * Control office를 combobox에 입력하는 함수 - 2010.11.17
	 */
	function getCtrlOfcList() {
		
		var sheetObj = sheetObjects[0];
  		var formObj = document.form;
  		sheetObj.RemoveEtcData();
  		formObj.f_cmd.value = SEARCH03;
  		sheetObj.DoSearch4Post("ESD_TPB_0135GS.do", tpbFrmQryStr(formObj));
  		
		var ctrl_ofc_cd = sheetObj.EtcData('CTRL_OFC_CD');	
		
		
		var ctrlOfcCdArray = ctrl_ofc_cd.split('|');

		var comboObj = eval("document.all.s_if_ctrl_cd");
		
		if(comboObj != undefined) {
			ComClearCombo(comboObj);
		}
//		ComAddComboItem(comboObj, "ALL", "" );
//alert("ctrlOfcCdArray.length:"+ctrlOfcCdArray.length+"ctrl_ofc_cd:"+ctrl_ofc_cd);		
		var k = 0;
		while(k < ctrlOfcCdArray.length-1 ){
			k++;
			if(k==1 && ctrlOfcCdArray.length>2){ComAddComboItem(comboObj, "ALL", "" );}
			ComAddComboItem(comboObj, ctrlOfcCdArray[k], ctrlOfcCdArray[k]);
		}
		
	}
	
	/**
	 * Tpb office를 combobox에 입력하는 함수 - 2010.11.17
	 */
	function getTpbOfcList() {
		
		var sheetObj = sheetObjects[0];
  		var formObj = document.form;
  		sheetObj.RemoveEtcData();
  		formObj.f_cmd.value = SEARCH04;
  		sheetObj.DoSearch4Post("ESD_TPB_0135GS.do", tpbFrmQryStr(formObj));
  		
		var tpb_ofc_cd = sheetObj.EtcData('TPB_OFC_CD');	
		
		
		var tpbOfcCdArray = tpb_ofc_cd.split('|');

		var comboObj = eval("document.all.s_if_ofc_cd");
		
		if(comboObj != undefined) {
			ComClearCombo(comboObj);
		}
//		ComAddComboItem(comboObj, "ALL", "" );
//alert("tpbOfcCdArray.length:"+tpbOfcCdArray.length+"tpb_ofc_cd:"+tpb_ofc_cd);		
		var k = 0;
		while(k < tpbOfcCdArray.length-1 ){
			k++;
			if(k==1 && tpbOfcCdArray.length>2){ComAddComboItem(comboObj, "ALL", "" );}
			ComAddComboItem(comboObj, tpbOfcCdArray[k], tpbOfcCdArray[k]);
		}
		
	}

	/* 개발자 작업  끝 */