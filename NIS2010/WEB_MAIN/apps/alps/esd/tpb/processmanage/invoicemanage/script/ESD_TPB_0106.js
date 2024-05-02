/*=========================================================
*Copyright(c) Since 2009 CyberLogitec
*@FileName : ESD_TPB_0106.js
*@FileTitle : TPB Handling
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-16
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초 생성
* 2009-09-16 Sun, Choi 1.1 ALPS Migration
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
     * @class ESD_TPB_0106 : ESD_TPB_0106 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0106() {    
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
   			ComEndConfigSheet(sheetObjects[i]);
   		}
  		document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange;
  		//document.form.s_vndr_cust_div_cd.onchange = s_trd_party_val_OnFocus;
  		//document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
  		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;

  		document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange_ToSearch; // for searching
  		//document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
  		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;
  		//tpb_3rdPartyStaffClear(document.form.s_vndr_cust_div_cd);
  		
		if(document.form.s_n3pty_no.value != "" || document.form.s_dao_n3pty_no.value != ""){
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} else if ( document.form.s_n3pty_no_strs_link.value.length >= 14) {
		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		
		if(document.form.s_user_id.value =="TPBADM"){
		  document.all.btn_allif_left.style.display = "";
    	  document.all.btn_allif.style.display = "";
    	  document.all.btn_allif_right.style.display = "";
		}else{
		  document.all.btn_allif_left.style.display = "none";
    	  document.all.btn_allif.style.display = "none";
    	  document.all.btn_allif_right.style.display = "none";	
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
 					//2009-07-31 O Wan-Ki
 					InitColumnInfo(37, 0, 0, true);

 					// 해더에서 처리할 수 있는 각종 기능을 설정한다
 					InitHeadMode(true, true, true, true, false, false)
 					
 					var HeadTitle1 = " | |TPB No.|Invoice No.|Invoice No.|Invoice No.|Exp. Type|Exp. Type|Exp. Type|S/P Inv. No.|EQ No.|3rd Party|3rd Party|3rd Party|Revenue VVD|I/F(TES/TRS/M&R)|I/F(TES/TRS/M&R)|I/F(TES/TRS/M&R)|Currency|Outstanding AMT|Revised AMT|Confirm / ROC-Accept|Confirm / ROC-Accept|Confirm / ROC-Accept|Overdue|ERP I/F|ERP I/F|ERP I/F|Recovery Activity|invoice_able|revise_able|erpif_able|length_n3pty_bil_tp_cd|ida_tax_seq|n3pty_cd_o|rocrollback_able|tp";
 					var HeadTitle2 = " | |TPB No.|Invoice No.|||Main|Sub code|Sub|S/P Inv. No.|EQ No.|Division|Code|Name|Revenue VVD|Cur.|Amount|USD|Currency|Outstanding AMT|Revised AMT|ID|Name|Date|Overdue|ID|Name|Date|Recovery Activity|invoice_able|revise_able|erpif_able|length_n3pty_bil_tp_cd|ida_tax_seq|n3pty_cd_o|rocrollback_able|tp";

 					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 					InitHeadRow(0, HeadTitle1, true);
 					InitHeadRow(1, HeadTitle2, true);
 				   
 					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 					InitDataProperty(0, cnt++, dtHiddenStatus,100,  daCenter, false,    "sts",                 		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtRadioCheck, 30,    daCenter,  true,    "chk",                 		false,          "",       dfNone,    0,     true,       true);
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "n3pty_no",            		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "n3pty_inv_no",        		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  true,    "lst_n3pty_inv_rvis_seq",  	false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  true,    "n3pty_inv_rvis_cd",   		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,       70,    daCenter, false,    "n3pty_expn_tp_cd",			false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,     60,    daCenter, false,    "n3pty_bil_tp_cd",     		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      130,    daCenter, false,    "n3pty_bil_tp_nm",     		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      150,    daCenter,  true,    "n3pty_src_no",        		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "eq_no",               		false,          "",       dfNone,    0,     false,       true); /// Added By Kim Jin-seung In 2007-08-07
 					InitDataProperty(0, cnt++, dtHidden,     50,    daCenter,  true,    "vndr_cust_div_cd",    		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "n3pty_cd",      			false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      150,    daLeft,    true,    "n3pty_nm",      			false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,       90,    daCenter,  true,    "rev_vvd",        			false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,     50,    daCenter,  true,    "if_curr_cd",          		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,     80,    daRight,   true,    "if_amt",              		false,          "",       dfFloat,   2,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,     80,    daRight,   true,    "if_amt_usd",          		false,          "",       dfFloat,   2,     false,       true);					
 					InitDataProperty(0, cnt++, dtData,       80,    daCenter,  true,    "curr_cd",             		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      110,    daRight,   true,    "ots_amt",             		false,          "",       dfFloat,   2,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      110,    daRight,   true,    "rvs_amt",             		false,          "",       dfFloat,   2,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "cfm_usr_id",          		false,          "",       dfNone,    0,     false,       true); 
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "cfm_usr_nm",          		false,          "",       dfNone,    0,     false,       true); // added in 2008-11-25
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "cfm_dt",              		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "overdue",             		false,          "",       dfNone,    0,     false,       true); // added in 2008-11-25
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "erpif_usr_id",        		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "erpif_usr_nm",        		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtData,      100,    daCenter,  true,    "erpif_dt",            		false,          "",       dfNone,    0,     false,       true); // added in 2008-11-25
 					InitDataProperty(0, cnt++, dtImage,     120,    daCenter,  true,    "rcvr_act_yn",         		false,          "",       dfNone,    0,     false,       false); // added in 2008-11-25
 					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "invoice_able",        		false,          "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "revise_able",         		false,          "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "erpif_able",          		false,          "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "length_n3pty_bil_tp_cd",   false,          "",       dfNone,    0,     false,       false); // added in 2008-11-27
 					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "ida_tax_seq",          	false,          "",       dfNone,    0,     false,       false);
 					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter,  true,    "n3pty_cd_o",      	    	false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "rocrollback_able",   		false,          "",       dfNone,    0,     false,       true);
 					InitDataProperty(0, cnt++, dtHidden,     30,    daCenter,  true,    "n3pty_if_tp_cd",   		false,          "",       dfNone,    0,     false,       true);
 					
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
  			// form 이름에 주의하시기 바랍니다. 
  				with(document.form) {
	  			switch(srcName) {
	  				case "btn_add":
	  					doActionIBSheet(sheetObject,formObject,IBINSERT);
	  					break;
	  				case "btn_cancel":
	  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
	  					break;
	  				case "btn_save":
	  					doActionIBSheet(sheetObject,formObject,IBSAVE);

	  					break;
	  				case "btn_remove":
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
	  					setButtonHidden();
	  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
	  					break;
	  				case "btn_vvd":
	  					var param = '?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
	  					ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
	  					break;
	  				case "btn_new":
	  					sheetObject.RemoveAll();
	  					formObject.reset();
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
	  				case "btn_revise":
	  					doActionIBSheet(sheetObject,formObject,IBSAVE);
	  					break;
	  				case "btn_erpif":
	  					doActionIBSheet(sheetObject,formObject,IBINSERT);
	  					break;
	  				case "btn_allif":
	  					for(var i=2;i<=sheetObject.RowCount+1;i++){
                            var erp_yn =  sheetObject.CellValue(i, "erpif_able");
                        
	  						if (erp_yn == "Y"){
	  							sheetObject.CellValue(i,"chk") = "1";

		  					document.form.s_n3pty_inv_no.value = sheetObject.CellValue(i, "n3pty_inv_no");
		  					document.form.s_n3pty_inv_his_seq.value = sheetObject.CellValue(i, "lst_n3pty_inv_rvis_seq");
		  					document.form.s_n3pty_inv_rmd_cd.value = sheetObject.CellValue(i, "n3pty_inv_rvis_cd");
		  					formObject.f_cmd.value = ADD;
		  					var queryStr = sheetObject.GetSaveString(false, false, "sts");
		  					var searchXml = sheetObject.GetSaveXml("ESD_TPB_0106GS.do", queryStr+'&'+ tpbFrmQryStr(formObject));

	  						}
	  					}
	  					
	  					break;	
	  				case "btn_invoice":
	  					formObject.f_cmd.value = SEARCH01;
	  					var str = "";
	  					for(var i=2;i<=sheetObject.RowCount+1;i++){
	  						if(sheetObject.CellValue(i,"chk") == "1"){
	  							str += sheetObject.CellValue(i,"n3pty_no")+"|";
	  							formObject.s_trd_party_code.value = sheetObject.CellValue(i,"n3pty_cd_o");
	  						}
	  			  		}
	  					formObject.s_dao_n3pty_no.value = str;
	  					
//	  					formObject.method = "post";
//	  					formObject.action = "ESD_TPB_0110.do?pgmNo=ESD_TPB_0110";
//	  					formObject.submit();
	  					
	  				   // 2015.07.29  화면 메뉴이동에서 pop up으로 변경함.	  						
	  					var url = "ESD_TPB_0110.do"+"?s_dao_n3pty_no="+str
	  					+"&s_length_n3pty_bil_tp_cd="+formObject.s_length_n3pty_bil_tp_cd.value
	  					+"&s_h_vndr_cust_div_cd="+formObject.s_h_vndr_cust_div_cd.value
	  					+"&s_trd_party_code="+formObject.s_trd_party_code.value
    					+"&pop_yn=Y";
  					
					     var returnValue = ComOpenWindowCenter(url, "ESD_TPB_0110", "1050","750", true, "yes");
					     sheetObject.RemoveAll();
	  				     setButtonHidden();
						 doActionIBSheet(sheetObject,formObject,IBSEARCH);
 					
	  					break;
	  				case "btn_modification":
	  					var str = getCheckN3ptyNo(formObject,sheetObject); 
	  					if(str != ''){
//	  						formObject.f_cmd.value = SEARCH;
//	  						formObject.method = "post";
//	  						formObject.action = "ESD_TPB_0108.do?pgmNo=ESD_TPB_0108";
//	  						formObject.submit();
                            // 2015.07.29  화면 메뉴이동에서 pop up으로 변경함.	  						
		  					var url = "ESD_TPB_0108.do"+"?s_n3pty_no_strs_link="+str
        					+"&pop_yn=Y";
	  					
	  					var returnValue = ComOpenWindowCenter(url, "ESD_TPB_0108", "1050","625", true, "no");
	  					  // if(returnValue == "Y"){
	  						    formObject.s_n3pty_no_strs_link.value = "";
	  		  					sheetObject.RemoveAll();
	  		  				    setButtonHidden();
	  						    doActionIBSheet(sheetObject,formObject,IBSEARCH);
	  					 //   }
	  					}
	  					
	  					break;
	  				case "btn_roc":
	  					var str = getCheckN3ptyNo(formObject,sheetObject); 
	  					if(str != ''){
//	  						formObject.f_cmd.value = SEARCH;
//	  						formObject.method = "post";
//	  						formObject.action = "ESD_TPB_0113.do?pgmNo=ESD_TPB_0113";
//	  						formObject.submit();
	  					// 2015.07.29  화면 메뉴이동에서 pop up으로 변경함.	  	  						
		  					var url = "ESD_TPB_0113.do"+"?s_n3pty_no_strs_link="+str
		  					+"&n3pty_no="+str
        					+"&pop_yn=Y";
	  					
	  					   var returnValue = ComOpenWindowCenter(url, "ESD_TPB_0113", "1050","625", true, "no");
	  	 					   formObject.s_n3pty_no_strs_link.value = "";
	  	 					   sheetObject.RemoveAll();
	  	 					   setButtonHidden();
	  						   doActionIBSheet(sheetObject,formObject,IBSEARCH);
	  					}
	  					break;
	  				case "btn_writeoff":
	  					var str = getCheckN3ptyNo(formObject,sheetObject);
	  					if(str != ''){
//	  						formObject.f_cmd.value = SEARCH;
//	  						formObject.method = "post";
//	  						formObject.action = "ESD_TPB_0114.do?pgmNo=ESD_TPB_0114";
//	  						formObject.submit();
	  				    	// 2015.07.29  화면 메뉴이동에서 pop up으로 변경함.		
		  					var url = "ESD_TPB_0114.do"+"?s_n3pty_no_strs_link="+str
		  					+"&n3pty_no="+str
        					+"&pop_yn=Y";
	  					
	  					   var returnValue = ComOpenWindowCenter(url, "ESD_TPB_0114", "1050","625", true, "no");
	  	 					   formObject.s_n3pty_no_strs_link.value = "";
	  	 					   sheetObject.RemoveAll();
	  	 					   setButtonHidden();
	  						   doActionIBSheet(sheetObject,formObject,IBSEARCH);
	  					}
	  					break;
	  				case "btn_rollback":
	  					doActionIBSheet(sheetObject,formObject,IBBATCH);
	  					break;
	  				break;
				} // end switch
  			}// end with
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg('TPB90014'));
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
  				sheetObj.DoSearch4Post("ESD_TPB_0106GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBSAVE:		// Revise

  				for(var i=2;i<=sheetObj.RowCount+1;i++){
						if(sheetObj.CellValue(i,"chk") == "1"){
							var sRow = i;
						}
  				}

  				if(sRow == ""){
  					ComShowMessage(ComGetMsg('TPB90077', 'Invoice No.'));
  					return;
  				}else{
  					document.form.s_correction_yn.value = "Y"; 
  			
  					 // 2015.07.29  화면 메뉴이동에서 pop up으로 변경함.		
              			var url = "ESD_TPB_0111.do"
        					+"?s_n3pty_inv_no="+sheetObj.CellValue(sRow, "n3pty_inv_no")
        					+"&s_detail_n3pty_no="+sheetObj.CellValue(sRow, "n3pty_no")
        		    	    +"&s_n3pty_inv_his_seq="+sheetObj.CellValue(sRow, "lst_n3pty_inv_rvis_seq")
        					+"&s_n3pty_inv_rmd_cd="+sheetObj.CellValue(sRow, "n3pty_inv_rvis_cd")
        					+"&s_trd_party_code="+sheetObj.CellValue(sRow, "trd_party_code")
        					+"&s_h_vndr_cust_div_cd="+sheetObj.CellValue(sRow, "vndr_cust_div_cd")
        					+"&s_length_n3pty_bil_tp_cd="+sheetObj.CellValue(sRow, "length_n3pty_bil_tp_cd")
        					+"&s_correction_yn=Y"+"&pop_yn=Y"
        					;

              			var returnValue = ComOpenWindowCenter(url, "ESD_TPB_0111",  "1050","750", true,"yes");
              			setRevisionPopClose();
  				}
  				break;	
  			case IBINSERT: //ERP I/F

  				for(var i=2;i<=sheetObj.RowCount+1;i++){
						if(sheetObj.CellValue(i,"chk") == "1"){
							var sRow = i;
						}
  				}
  				if(sRow == ""){
  					ComShowMessage(ComGetMsg('TPB90077', 'Invoice No.'));
  					return;
  				}else{
  					var s_n3pty_inv = sheetObj.CellValue(sRow,"n3pty_inv_no");
  					var s_n3pty_no = sheetObj.CellValue(sRow,"n3pty_no");
  					document.form.s_n3pty_inv_no.value = sheetObj.CellValue(sRow, "n3pty_inv_no");
  					document.form.s_n3pty_inv_his_seq.value = sheetObj.CellValue(sRow, "lst_n3pty_inv_rvis_seq");
  					document.form.s_n3pty_inv_rmd_cd.value = sheetObj.CellValue(sRow, "n3pty_inv_rvis_cd");
  					formObj.f_cmd.value = ADD;
  					sheetObj.DoSave("ESD_TPB_0106GS.do", tpbFrmQryStr(formObj),-1,false);

  					//ERP I/F 완료된 대상 Closed로 재조회
  					document.form.s_status.value="E";
  					document.form.s_n3pty_inv_no_search.value = s_n3pty_inv;
  					document.form.s_n3pty_no.value = s_n3pty_no;
  					formObj.f_cmd.value = SEARCH;
  					sheetObj.DoSearch4Post("ESD_TPB_0106GS.do", tpbFrmQryStr(formObj));
  				}
  				break;
  			case IBBATCH: 	//RocRollback
  				var sRow = -1;
 				for(var i=2;i<=sheetObj.RowCount+1;i++){
					if(sheetObj.CellValue(i,"chk") == "1"){
						var sRow = i;
					}
				}
 				
				if(sRow == -1){
					ComShowMessage(ComGetMsg('TPB90077', 'ROC TPB NO'));
					return;
				}else{
					
					var sParam = "ofc_cd=" + document.form.s_user_ofc_cd.value;
					sParam += "&user_id=" + document.form.s_user_id.value;
					sParam += "&n3pty_no=" + sheetObj.CellValue(sRow, "n3pty_no");
					sParam += "&f_cmd=" + COMMAND01;
					
					var sXml = sheetObj.GetSearchXml("ESD_TPB_0106GS.do" , sParam);
					var result = ComGetEtcData(sXml,"result");
					
					if (result == "SUCCESS") {
						ComShowMessage("Successful RollbackROC");
		  				formObj.f_cmd.value = SEARCH;
		  				sheetObj.DoSearch4Post("ESD_TPB_0106GS.do", tpbFrmQryStr(formObj));
					} else {
						ComShowMessage("Failed RollbackROC");
					}
						
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
			/**
			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
			 */
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
  			document.all.btn_erpif_left.style.display = "none";
  		    document.all.btn_erpif.style.display = "none";
  		    document.all.btn_erpif_right.style.display = "none";
  			ComShowMessage(ComGetMsg('TPB90075', 'Data'));

  			sheetObj.DoSearch4Post("ESD_TPB_0106GS.do", final_retrieve_querystrings); /// sheet data reload
  		}
  	}
  	
  	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){
  		// ComShowMessage("MouseRow : " + sheetObj.MouseRow + " / MouseCol : " + sheetObj.MouseCol);
  	}

  	function tpb_checkInvoiceDetailCount(sheetObj){
  		var cnt = 0;
  		for(var i=1;i<=sheetObj.RowCount;i++){
  			cnt += sheetObj.CellValue(i,"chk_box");
  		}
  		// ComShowMessage("Check Count : " + cnt); 
  		if ( cnt > MaxDetailCount ){
  		    ComShowMessage(ComGetMsg('TPB90052', MaxDetailCount.toString()));
  		    return false;
  		} else {
  		    return true;
  		}
  	}

  	function sheet1_OnClick(sheetObj, Row, Col, Value){
  		/// Collection Activity 버튼 클릭시 팝업

  		if ( sheetObj.ColSaveName(Col) == "rcvr_act_yn" ) {

  			var r_n3pty_no = sheetObj.CellValue(Row, "n3pty_no");
  			var r_n3pty_inv_no = sheetObj.CellValue(Row, "n3pty_inv_no");
  			
  			openRecoveryActPopup(r_n3pty_no,r_n3pty_inv_no,'','N');
  		}
  	}

  	function sheet1_OnChange(sheetObj,Row,Col,Value){
  		/// Check change에 따른 이벤트 처리 
  		//if ( sheetObj.ColSaveName(Col) == "chk" && s_office_level=="G" ) { 
  		if ( sheetObj.ColSaveName(Col) == "chk" ) { 
  		      
              var invoice_able = sheetObj.CellValue(Row, "invoice_able");
              var logi_cd = sheetObj.CellValue(Row, "n3pty_if_tp_cd");
              /// invoice button 

              if ( invoice_able == 'Y' ) {
                  document.all.btn_invoice_left.style.display = "";
                  document.all.btn_invoice.style.display = "";
            	  document.all.btn_invoice_right.style.display = "";
              } else {
            	  document.all.btn_invoice_left.style.display = "none";
            	  document.all.btn_invoice.style.display = "none";
            	  document.all.btn_invoice_right.style.display = "none";
              }

              var revise_able = sheetObj.CellValue(Row, "revise_able");
              /// revise button 
              if ( revise_able == 'Y' ) {
            	  document.all.btn_revise_left.style.display = "";
            	  document.all.btn_revise.style.display = "";
            	  document.all.btn_revise_right.style.display = "";
              } else {
            	  document.all.btn_revise_left.style.display = "none";
            	  document.all.btn_revise.style.display = "none";
            	  document.all.btn_revise_right.style.display = "none";
              }

              var erpif_able = sheetObj.CellValue(Row, "erpif_able");
              /// erpif button 
              if ( erpif_able == 'Y' ) {
            	  document.all.btn_erpif_left.style.display = "";
            	  document.all.btn_erpif.style.display = "";
            	  document.all.btn_erpif_right.style.display = "";
              } else {
            	  document.all.btn_erpif_left.style.display = "none";
            	  document.all.btn_erpif.style.display = "none";
            	  document.all.btn_erpif_right.style.display = "none";
              }
              
              // roc, write-off button 
              if ( revise_able != 'Y' && erpif_able != 'Y' ){
				document.all.btn_roc_left.style.display = "";
				document.all.btn_roc.style.display = "";
				document.all.btn_roc_right.style.display = "";
				document.all.btn_writeoff_left.style.display = "";
				document.all.btn_writeoff.style.display = "";
				document.all.btn_writeoff_right.style.display = "";
				document.all.btn_modification_left.style.display = "";
				document.all.btn_modification.style.display = "";
				document.all.btn_modification_right.style.display = "";
              } else {
				document.all.btn_roc_left.style.display = "none";
				document.all.btn_roc.style.display = "none";
				document.all.btn_roc_right.style.display = "none";
				document.all.btn_writeoff_left.style.display = "none";
				document.all.btn_writeoff.style.display = "none";
				document.all.btn_writeoff_right.style.display = "none";
				document.all.btn_modification_left.style.display = "none";
				document.all.btn_modification.style.display = "none";
				document.all.btn_modification_right.style.display = "none";
              }
              
              var rocrollback_able = sheetObj.CellValue(Row, "rocrollback_able");
              // 담당자 변경시 수정 필요함.
              if ( rocrollback_able == 'Y' && (document.form.s_user_id.value == '0660011' || document.form.s_user_id.value == 'TPBADM') && logi_cd != 'R') {
            	  document.all.btn_rollback_left.style.display = "";
            	  document.all.btn_rollback.style.display = "";
            	  document.all.btn_rollback_right.style.display = "";
              } else {
            	  document.all.btn_rollback_left.style.display = "none";
            	  document.all.btn_rollback.style.display = "none";
            	  document.all.btn_rollback_right.style.display = "none";
              }
            
            // tpb no            
      		document.form.s_detail_n3pty_no.value = sheetObj.CellValue(Row,"n3pty_no");
      		//3rd Party code

      		document.form.s_trd_party_code.value = sheetObj.CellValue(Row,"trd_party_code");
      		//vndr_cust_div_cd
      		document.form.s_h_vndr_cust_div_cd.value = sheetObj.CellValue(Row,"vndr_cust_div_cd");
      		document.form.s_length_n3pty_bil_tp_cd.value = sheetObj.CellValue(Row,"length_n3pty_bil_tp_cd");

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
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Source',''));
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][1] != trd_party_code){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'3rd Party',''));
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][2] != revenue_vvd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Revenue VVD',''));
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][3] != curr_cd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Currency',''));
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      		}

  		} else {

  		    // J/O Case - Source, 3rd Party, Actual VVD, Currency, Csr No., Month of GL Date 다른 값이 있는지 체크
      		for(var i=0;i<invArr.length;i++){
      			if(invArr[i][0] != n3pty_src_sub_sys_cd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Source',''));
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][1] != trd_party_code){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'3rd Party',''));
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][2] != revenue_vvd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Revenue VVD',''));
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][3] != curr_cd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Currency',''));
      				sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}

      			if(invArr[i][4] != actual_vvd){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Actual VVD',''));
      				//sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][5] != csr_no){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'CSR No.',''));
      				//sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}
      			if(invArr[i][6] != gl_month){
      				ComShowMessage(ComGetMsg('TPB90001',i+1,'Month of GL Date',''));
      				//sheetObject.RowBackColor(invArr[i][7]) = sheetObject.RgbColor(192,192,192);
      				rtn =false;
      				break;
      			}

      		}
    		
  		}

  		if(invArr.length == 0){
  			ComShowMessage(ComGetMsg('TPB90076', ''));
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
  			ComShowMessage(ComGetMsg('TPB90002', '8'));
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
          
  		var str = "";
  		var sRow = sheetObj.FindCheckedRow("chk");
  		sRow = sRow.split("|")[0];
  		if(sRow == ""){
  			ComShowMessage(ComGetMsg('TPB90077', 'TPB No.'));
  			 str = "";
  			return;
  		} else {
  		    str = sheetObj.CellValue(sRow,'n3pty_no'); 
      		document.form.s_n3pty_no_strs_link.value = str;
  		}

  		if(str == ''){
  			ComShowMessage(ComGetMsg('TPB90076', ''));
  		}

  		//ComShowMessage(str);
  		return str; 
  	}
  	
  	function getPopUpClose() {    	 
		alert("OK");
	}
  	
  	function setButtonHidden() {    	 
  		document.all.btn_invoice_left.style.display = "none";
  		document.all.btn_invoice.style.display = "none";
  		document.all.btn_invoice_right.style.display = "none";

  		document.all.btn_revise_left.style.display = "none";
  		document.all.btn_revise.style.display = "none";
  		document.all.btn_revise_right.style.display = "none";

  		document.all.btn_erpif_left.style.display = "none";
  		document.all.btn_erpif.style.display = "none";
  		document.all.btn_erpif_right.style.display = "none";

  		document.all.btn_roc_left.style.display = "none";
  		document.all.btn_roc.style.display = "none";
  		document.all.btn_roc_right.style.display = "none";
  		document.all.btn_writeoff_left.style.display = "none";
  		document.all.btn_writeoff.style.display = "none";
  		document.all.btn_writeoff_right.style.display = "none";
  		document.all.btn_modification_left.style.display = "none";
  		document.all.btn_modification.style.display = "none";
  		document.all.btn_modification_right.style.display = "none";
  	    document.all.btn_rollback_left.style.display = "none";
	    document.all.btn_rollback.style.display = "none";
	    document.all.btn_rollback_right.style.display = "none";
	}
  	
  	function setRevisionPopClose(){  
  		 var sheetObject = sheetObjects[curTab-1];
 		 var formObject = document.form;
         setButtonHidden();
         doActionIBSheet(sheetObject,formObject,IBSEARCH);
  	}
	/* 개발자 작업  끝 */