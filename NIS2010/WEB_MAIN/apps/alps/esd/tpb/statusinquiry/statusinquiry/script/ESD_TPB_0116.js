/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0116.js
*@FileTitle : Status By TPB
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-19
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-10-19 Sun, Choi 1.1 ALPS Migration
* -------------------------------------------------------
* History
* 2010.10.15 변종건 [CHM-201006480-01] [TPB] TPB 관련 보완 요청 (JO TPB Process Inquiry  &  Status by TPB)
* 2013.04.15 서미진 [선조치 CSR] Period 를 1년으로 제한
* 2016.02.12 Kim Hyun Hwa [CHM-201640040]Status by TPB 화면에서 S/Office 및 TPB type 칼럼 추가-BKG 관련항목추가 
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
     * @class ESD_TPB_0116 : ESD_TPB_0116 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0116() {
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
  		
  		initControl();
  		func_rhq_ctrl_ofc_list();
  		
  		document.form.s_n3pty_bil_tp_cd.onchange = s_n3pty_bil_tp_cd_OnChange;
  		//document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange_ToSearch; // for searching 
  		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
  		//document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur_ToSearch;
  		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;
  		document.form.s_ots_sts_cd.selectedIndex = 1;
  		//document.all.btns_calendar2.disabled = true;
  		if (document.form.s_state.value == "BKG"){
	  		var formObject = document.form;
	  		
	  		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);  // BKG 에서 호출
  		}
  	}
  	
  	function initControl() {		
		var formObj = document.form;
		
	    //Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm  ('blur', 			'obj_deactivate',  		formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리	
//		axon_event.addListenerFormat('focus', 			'obj_activate'  ,  		formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
//	    axon_event.addListenerFormat('keypress', 		'obj_keypress'  , 		formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리	    
//	    axon_event.addListenerFormat('keyup', 			'obj_keyup'     ,  		formObj);
	}
	
    function obj_deactivate() {
    	var formObj = document.form;
		var obj = event.srcElement;
    	
    	ComChkObjValid(obj);
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
  					style.height = 280;
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
  					InitColumnInfo(56, 3, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)
  		
//  					var HeadTitle = "STS||TPB No.|Seq.|Source|Invoice No.|Invoice Date|Source No.|BKG No.|B/L No.|VVD|EQ No|Type|3rd Party Code|3rd Party Name|TPB Status|Overdue|Currency|I/F AMT|Original|Invoice|Collect|Adjust|Balance|I/F User|I/F Office|Adjust Type|R.O.C From|R.O.C To|From TPB No.|Recovery Activity|EAC Type|CSR No.";
  					var HeadTitle = "STS||Seq.|TPB No.|OtsSeq|DpSeq.|Office|Source|Invoice No.|Invoice Date|Source No.|BKG No.|B/L No.|VVD|EQ No|Type|3rd Party\nType|3rd Party\nCode|3rd Party Name|Non TPB Reason|TPB Status|Overdue|Currency|Original|Administration|Deducted|VAT|Invoice|Collect|Adjust|Balance|I/F User|I/F User Name|I/F Office|I/F Date|Adjust Type|ROC From|ROC To|From TPB No.|Recovery Activity|EAC Type|CSR No.|Contract No|Contract Office|POR|POL|POD|DEL|R.Term|D.Term";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  		
  					//데이터속성	[ROW,	  COL, DATATYPE, 	  WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtHiddenStatus,   30,    daCenter,  true,    "");
      				InitDataProperty(0, cnt++, dtCheckBox,  	 30,    daCenter,  true,    "chk");
      				InitDataProperty(0, cnt++, dtSeq,            50,    daCenter,  true,    "seq");
      				InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    "n3pty_no",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,         70,    daCenter,  true,    "n3pty_no_dp_seq",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 70,    daCenter,  true,    "ots_dtl_seq",        	    false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 55,    daCenter,  true,    "ofc_cd",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 50,    daCenter,  true,    "n3pty_src_sub_sys_cd",     false,          "",       dfNone,    0,     false,       true);
      
      				InitDataProperty(0, cnt++, dtData,      	 95,    daCenter,  true,    "n3pty_inv_no",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 80,    daCenter,  true,    "inv_iss_dt",        		false,          "",       dfNone,    0,     false,       false);
      				InitDataProperty(0, cnt++, dtData,      	130,    daCenter,  true,    "n3pty_src_no",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 90,    daCenter,  true,    "bkg_no_all",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 85,    daCenter,  true,    "bl_no_all",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 70,    daCenter,  true,    "vvd",        				false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    "eq_no",        			false,          "",       dfNone,    0,     false,       false);
      				
      				InitDataProperty(0, cnt++, dtData,       	160,    daCenter,  true,    "n3pty_bil_tp_nm",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	70,     daCenter,  true,    "trd_party_type",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	70,     daCenter,  true,    "trd_party_code",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	150,    daLeft,    true,    "trd_party_name",        	false,          "",       dfNone,    0,     false,       true);
      				
      				InitDataProperty(0, cnt++, dtCombo,       	180,    daLeft,	   true,    "n3pty_non_cfm_rsn_cd",     false,          "",       dfNone,    0,     false,       true);
      				
      				InitDataProperty(0, cnt++, dtData,       	120,    daLeft ,   true,    "ots_sts_nm",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	 60,    daRight,   true,    "overdue",        			false,          "",		  dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	 60,    daCenter,  true,    "curr_cd",        			false,          "",		  dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight ,  true,    "ots_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				
      				InitDataProperty(0, cnt++, dtAutoSum,     	100,    daRight,   true,    "add_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight,   true,    "ddct_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight,   true,    "vat_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight ,  true,    "inv_amt",        			false,          "",      dfFloat,    2,     false,       true);
   
      				InitDataProperty(0, cnt++, dtHidden,     	100,    daRight,   true,    "clt_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight,   true,    "stl_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtAutoSum,       100,    daRight,   true,    "bal_amt",        			false,          "",      dfFloat,    2,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    "if_usr_id",        		false,          "",       dfNone,    0,     false,       true); // Added By Kim Jin-seung in 2007-04-26
      				InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    "if_usr_nm",        		false,          "",       dfNone,    0,     false,       true); // Added By Kim Jin-seung in 2007-04-26
      				InitDataProperty(0, cnt++, dtData,      	 70,    daCenter,  true,    "if_ofc_cd",        		false,          "",       dfNone,    0,     false,       true); // Added By Kim Jin-seung in 2007-04-26
      				InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    "if_dt",        			false,          "",       dfNone,    0,     false,       true);
      				
      				InitDataProperty(0, cnt++, dtData,      	150,    daCenter,  true,    "n3pty_stl_tp_cd",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	 70,    daCenter,  true,    "stl_rqst_ofc_cd",        	false,          "",       dfNone,    0,     false,       true);
      
      				InitDataProperty(0, cnt++, dtData,      	 70,    daCenter,  true,    "stl_to_clt_cng_ofc_cd",    false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    "fm_clt_cng_ofc_n3pty_no",	false,          "",       dfNone,    0,     false,       true); // Added By Kim Jin-seung in 2007-05-08
      				InitDataProperty(0, cnt++, dtImage,     	130,    daCenter,  true,    "clt_act_yn",        		false,          "",       dfNone,    0,     false,       false);
      				InitDataProperty(0, cnt++, dtData,      	 80,    daCenter,  true,    "edn_tp_nm",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,      	125,    daCenter,  true,    "csr_no",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	100,    daCenter,  true,    "contract_no",           	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	90,     daCenter,  true,    "contract_ofc",           	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	50,     daCenter,  true,    "por_cd",           	    false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	50,     daCenter,  true,    "pol_cd",           	    false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	50,     daCenter,  true,    "pod_cd",           	    false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	50,     daCenter,  true,    "del_cd",           	    false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	60,     daCenter,  true,    "rcv_term_cd",              false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtData,       	60,     daCenter,  true,    "de_term_cd",           	false,          "",       dfNone,    0,     false,       true);
      				
      				InitDataProperty(0, cnt++, dtHidden,    	 0,    daCenter,  true,    "ots_sts_cd",        		false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 0,    daCenter,  true,    "vndr_cust_div_cd",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 0,    daCenter,  true,    "curr_cd",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 0,    daCenter,  true,    "n3pty_bil_tp_cd",        	false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 0,    daCenter,  true,    "cfm_dt",        			false,          "",       dfNone,    0,     false,       true);
      				InitDataProperty(0, cnt++, dtHidden,    	 0,    daCenter,  true,    "so_if_seq",        		    false,          "",    dfInteger,    0,     false,       true);
      
      				ImageList(0) = "/hanjin/img/button/btng_collectionactivity.gif";
      				ImageList(1) = "/hanjin/img/button/btng_collectionactivity_yellow.gif";
      
      				InitDataCombo (0, "n3pty_non_cfm_rsn_cd", combo02Text, combo02Code);
      				
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
//  				case "btns_calendar1":
//  					 var cal = new calendarPopup();
//  					 cal.select(formObject.s_sdate, 's_sdate', 'yyyy-MM-dd');
//  					break;
//  				case "btns_calendar2":
//  					if(!document.all.btns_calendar2.disabled){
//  						var cal = new calendarPopupFromTo();
//  						cal.displayType = "date";
//  						cal.select(formObject.s_sdate, 's_sdate',formObject.s_edate, 's_edate', 'yyyy-MM-dd');
//  					}
//  					break;
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
  					formObject.s_edn_tp_cd.disabled = false;
  					ComClearCombo(formObject.s_n3pty_bil_tp_cd);
  					ComAddComboItem(formObject.s_n3pty_bil_tp_cd, "<<Select>>", "");
  					//document.all.period_class.className	= "nostar";
  		  			document.all.s_sdate.className	= "";
  		  			document.all.s_edate.className	= "";
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
  						//alert("수정필요 290");
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
  							//alert("수정필요 324");
  							return;
  							formObject.action = "ESD_TPB_0106.do";
  							formObject.submit();
  						}else{
  							formObject.s_dao_n3pty_no.value = tpb_getN3ptyArr(n3ptyArr, "NO", "");
  							formObject.s_cfm_dt_prev.value = tpb_getN3ptyArr(n3ptyArr, "DATE", "PREV");
  							formObject.s_cfm_dt_last.value = tpb_getN3ptyArr(n3ptyArr, "DATE", "LAST");
  							formObject.f_cmd.value = "";
  							//alert("수정필요 332");
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
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}

  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0116GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBSAVE:		//저장
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0116GS.do", tpbFrmQryStr(formObj));
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
  			
  			// 2013.04.15 서미진 [선조치 CSR] Period 중 한쪽만 넣었을때 validation
  			if(formObj.s_sdate.value != ""&&formObj.s_edate.value ==""){
  				ComShowCodeMessage("TPB90078","Period");
	   		    formObj.s_edate.focus();
	   		    return false;			
  			}
  			
  			if(formObj.s_sdate.value == ""&&formObj.s_edate.value !=""){
  				ComShowCodeMessage("TPB90078","Period");
	   		    formObj.s_sdate.focus();
	   		    return false;	
  			}

  		    // 2013.04.15 서미진 [선조치 CSR] Period 를 1년으로 제한
  			if(formObj.s_ots_sts_cd.value != 'T' || formObj.s_if_rhq_cd.value == 'ALL'){
	  			var check_date = ComGetDaysBetween(formObj.s_sdate.value,formObj.s_edate.value);
	  			if(check_date < 0){
		   	    	ComShowCodeMessage("TPB90109","Period From Date", "To Date");
		   		    formObj.s_sdate.focus();
		   		    return false;			
	  			}
	  			
		   	    if(check_date > 365){
		   	    	ComShowCodeMessage("TPB90108","365 days");
		   		    formObj.s_sdate.focus();
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

  		//Outstanding Amount 의 Auto Upate check
  		tpb_chgColor_ots_amt(sheetObj, 27, 12);
  		
		if( document.form.s_ots_sts_cd.value == "N" ){
			sheetObj.ColHidden("n3pty_no") = true;
			sheetObj.ColHidden("seq") = false;
			sheetObj.ColHidden("n3pty_inv_no") = true;
			sheetObj.ColHidden("inv_iss_dt") = true;
			sheetObj.ColHidden("overdue") = true;
			sheetObj.ColHidden("add_amt") = true;
			sheetObj.ColHidden("ddct_amt") = true;
			sheetObj.ColHidden("vat_amt") = true;
			sheetObj.ColHidden("inv_amt") = true; 
			sheetObj.ColHidden("stl_amt") = true;
			sheetObj.ColHidden("bal_amt") = true;
			sheetObj.ColHidden("n3pty_stl_tp_cd") = true;
			sheetObj.ColHidden("stl_rqst_ofc_cd") = true;
			sheetObj.ColHidden("stl_to_clt_cng_ofc_cd") = true;
			sheetObj.ColHidden("fm_clt_cng_ofc_n3pty_no") = true; 
			sheetObj.ColHidden("clt_act_yn") = true;
			sheetObj.ColHidden("n3pty_non_cfm_rsn_cd") = false;
		}else{
			sheetObj.ColHidden("n3pty_no") = false;
			sheetObj.ColHidden("n3pty_inv_no") = false;
			sheetObj.ColHidden("seq") = true;
			sheetObj.ColHidden("inv_iss_dt") = false;
			sheetObj.ColHidden("overdue") = false;
			sheetObj.ColHidden("inv_amt") = false;
			sheetObj.ColHidden("stl_amt") = false;
			sheetObj.ColHidden("bal_amt") = false;
			sheetObj.ColHidden("n3pty_stl_tp_cd") = false;
			sheetObj.ColHidden("stl_rqst_ofc_cd") = false;
			sheetObj.ColHidden("stl_to_clt_cng_ofc_cd") = false;
			sheetObj.ColHidden("fm_clt_cng_ofc_n3pty_no") = false;
			sheetObj.ColHidden("clt_act_yn") = false;
			sheetObj.ColHidden("n3pty_non_cfm_rsn_cd") = true;
			
			if( document.form.s_if_type[1].checked  ){
				 sheetObj.ColHidden("add_amt") = true;
				 sheetObj.ColHidden("ddct_amt") = true;
				 sheetObj.ColHidden("vat_amt") = true;
			} else {
				 sheetObj.ColHidden("add_amt") = false;
				 sheetObj.ColHidden("ddct_amt") = false;
				 sheetObj.ColHidden("vat_amt") = false;
			}
	
		}


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
              //location.href = "ESD_TPB_0115.do?pgmNo=ESD_TPB_0115&s_direct_tpb_no="+sheetObj.CellValue(Row, Col);
              
      		var theURL = "ESD_TPB_0115.do?s_direct_tpb_no="+sheetObj.CellValue(Row, Col)+"&popUpFlg="+"Y";
      		var winName = "ESD_TPB_0115";
      		var features = "scroll:no;status:no;help:no;dialogWidth:1015px;dialogHeight:630px";
      		ComOpenWindow(theURL,winName,features,true);
             
              
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
  			ComShowMessage(ComGetMsg('COM12176','','',''));
  		}
  		if(!otsCd){
  			ComShowMessage(ComGetMsg('TPB90003','','',''));
  			if(otsCdCnt == 0) str = '';
  		}

  		return str;
  	}

  	function s_n3pty_bil_tp_cd_OnChange(formObj){  
  		
  		var obj = document.form.s_n3pty_bil_tp_cd;
  		var str = obj.value;
  		if(str != '' || ComGetObjText(obj) == 'ALL'){
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
  		if(str != '' || ComGetObjText(obj) == 'ALL'){
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
  			ComShowMessage(ComGetMsg('COM12113','3rd Party No','',''));
  			rtn = false;
  		}

  		return rtn;
  	}

  	function checkPeriod(val){
  		if(val == "T"){ //TPB
  			//document.all.s_sdate.disabled = true;
  			//document.all.s_edate.disabled = true;
  			//document.all.btns_calendar2.disabled = true;
  			//document.all.period_class.className	= "nostar";
  			document.all.s_sdate.className	= "";
  			document.all.s_edate.className	= "";
  			
  			document.all.s_ots_sts_cd_detail_open.style.display = ''; /// Added By Kim Jin-seung In 2008-05-20
  			document.all.s_ots_sts_cd_detail_close.style.display = 'none'; /// Added By Kim Jin-seung In 2008-05-20
  			document.all.s_ots_sts_cd_detail_non.style.display = 'none'; 
  		}else if(val == "N"){
  			document.all.s_sdate.className	= "input1";
  			document.all.s_edate.className	= "input1";

  			document.all.s_ots_sts_cd_detail_open.style.display = 'none'; 
  			document.all.s_ots_sts_cd_detail_close.style.display = 'none'; 
  			document.all.s_ots_sts_cd_detail_non.style.display = ''; 
  		}else {
  			//document.all.s_sdate.disabled = false;
  			//document.all.s_edate.disabled = false;
  			//document.all.btns_calendar2.disabled = false;
  			//document.all.period_class.className	= "star";
  			document.all.s_sdate.className	= "input1";
  			document.all.s_edate.className	= "input1";

  			document.all.s_ots_sts_cd_detail_open.style.display = 'none'; /// Added By Kim Jin-seung In 2008-05-20
  			document.all.s_ots_sts_cd_detail_close.style.display = ''; /// Added By Kim Jin-seung In 2008-05-20
  			document.all.s_ots_sts_cd_detail_non.style.display = 'none'; 
  		}
  	}
	/* 개발자 작업  끝 */