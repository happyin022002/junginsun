/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0105.js
*@FileTitle : TPB Candidate Confirmation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : Park Sung-Jin
*@LastVersion : 2.0
* 2008-09-01 O Wan-Ki 1.0 최초 생성
* 2008-09-08 O Wan-Ki 1.1 테이블 변경에 따른 보완
* 2009-01-16 O Wan-Ki 1.2 오피스의  계단식 구조 활성화
* 2009-01-22 O Wan-Ki 1.3 confirm가능대상 변경(if_ofc_cd->ofc_cd)
* 2009-01-28 O Wan-Ki 1.4 Interfaced by Name 칼럼추가.
* 2009-02-16 O Wan-Ki 1.5 I/G/N 전체선택 기능추가.
* 2009-08-31 Park Sung-Jin 2.0 ALPS Migration
* 2011.03.31 변종건 [CHM-201109756-01] [TPB] Billing Type 특정case 조회 이상 현상 수정
* 2016.01.21 Kim Hyun Hwa [CHM-201639839] TPB Candidate confirmation에서 control office에 ALL 추가 요청
*                                         지역본부 및 본사 로그인 시 적용
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
     * @class ESD_TPB_0105 : ESD_TPB_0105 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0105() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업 */
    /* 공통전역변수 */
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
  	 * comSheetObject(id)에서 호출한다
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
  	var var_ofc_cd_timer; 
  	var interval = 2000; // initial condition
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}

  		if( document.form.s_office_level.value != "C" ){
  			if( document.form.s_office_level.value == "H" || document.form.s_office_level.value == "R"){
  				func_rhq_ctrl_ofc_list(null, '1');
  			}else{
  				func_rhq_ctrl_ofc_list(null, '2');

  			}

  		} else {
  			ComClearCombo(document.form.s_if_ofc_cd);
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','',1, new Array("s_if_ctrl_cd","s_office_level"));
  			//var_ofc_cd_timer = setInterval(callback_populate_ofc_cd, 2500);
  			var_ofc_cd_timer = setInterval(run_ofc_cd_timer , interval);
  			document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange;
			document.form.s_if_ctrl_cd.onchange = if_ctrl_cd_OnChange;
 		}
  		
  		//func_rhq_ctrl_ofc_list(null, '2');
  		document.form.s_n3pty_src_sub_sys_cd.onchange = tpb_searchBillingCaseByExpenseType;

  	}
  	
    function run_ofc_cd_timer() {
        clearInterval(var_ofc_cd_timer);
        if(interval > 15000 ){        
        	clearInterval(var_ofc_cd_timer);
        	alert("Fail to load Office List");
        	return false;
        }
        if(callback_populate_ofc_cd()){
        	clearInterval(var_ofc_cd_timer);
        	return false;
        }

        interval = interval * 1.5;
        var_ofc_cd_timer = setInterval(run_ofc_cd_timer, interval);

    }
  	function callback_populate_ofc_cd(){  		
  		if(document.form.s_if_ofc_cd.length > 0){
  			if(document.form.s_if_ofc_cd.length == 1){
  				//console.log("txt length : " + document.form.s_if_ofc_cd.options[0].text.length);
  				if(document.form.s_if_ofc_cd.options[0].text.indexOf("Select") == -1 &&
  						document.form.s_if_ofc_cd.options[0].text.indexOf("ALL") == -1){
  					return true;
  				} else {
  					getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','',2, new Array("s_if_ctrl_cd","s_office_level"));
  				}
  			} else {
  				return true;
  			}
  		} else {
  			getTPBGenCombo('s_if_ofc_cd','searchTPBOfficeList','F','',2, new Array("s_if_ctrl_cd","s_office_level"));
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
  					InitColumnInfo(55, 10, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)
  					
  					//var HeadTitle1 = "Del.|STS|SEQ|Confirm|Confirm|Confirm|Confirm|Confirm|ots_dtl_seq|TPB No.|Exp. Type|Exp. Type|S/P Inv No.|3rd Party|3rd Party|EQ Type|EQ No|TP/SZ|BKG No.|B/L No.|VVD|Interfaced Amount|Interfaced Amount|Interfaced Amount|Interfaced\nRemark|Confirmed\nAmount|I/F Date|Interfaced by|Interfaced by|Interfaced by|Description|Reviewed by|Reviewed by|Reason for Non-TPB|CSR No.|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|ofc_cd";
  					//var HeadTitle2 = "Del.|STS|SEQ|I|G|N|R|D|ots_dtl_seq|TPB No.|Main|Sub|S/P Inv No.|Type|Code|EQ Type|EQ No|TP/SZ|BKG No.|B/L No.|VVD|LCL Cur|LCL Amt|USD(Equiv.)|Interfaced\nRemark|Confirmed\nAmount|I/F Date|Office|ID|Name|Description|Office|ID|Reason for Non-TPB|CSR No.|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|ofc_cd";
  					var HeadTitle1 = "Del.|STS|SEQ|Confirm|Confirm|Confirm|Confirm|Confirm|ots_dtl_seq|TPB No.|Exp. Type|Exp. Type|n3pty_bil_tp_cd|S/P Inv No.|3rd Party|3rd Party|EQ Kind|EQ No|TP/SZ|BKG No.|B/L No.|VVD|Interfaced Amount|Interfaced Amount|Interfaced Amount|Interfaced\nRemark|Confirmed\nAmount|I/F Date|Interfaced by|Interfaced by|Interfaced by|Description|Reviewed by|Reviewed by|Non-TPB Reason|Non-TPB Request|CSR No.|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|ofc_cd|EQ Type|SAC Code";
  					var HeadTitle2 = "Del.|STS|SEQ|I|G|N|R|D|ots_dtl_seq|TPB No.|Main|Sub|n3pty_bil_tp_cd|S/P Inv No.|Type|Code|EQ Kind|EQ No|TP/SZ|BKG No.|B/L No.|VVD|LCL Cur|LCL Amt|USD(Equiv.)|Interfaced\nRemark|Confirmed\nAmount|I/F Date|Office|ID|Name|Description|Office|ID|Non-TPB Reason|Non-TPB Request|CSR No.|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|ofc_cd|EQ Type|SAC Code";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);
  					InitHeadRow(1, HeadTitle2, true);

//                [ROW ,COL	  ,DATATYPE     ,WIDTH ,DATAALIGN ,COLMERGE ,SAVENAME                 ,KEYFIELD ,CALCULOGIC ,DATAFORMAT ,POINTCOUNT ,UPDATEEDIT ,INSERTEDIT ,EDITLEN ,FULLINPUT ,SORTENABLE ,TOOLTIP ,ALLCHECK ,SAVESTATUS ,FORMATFIX]
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,30    ,daLeft    ,true     ,""                       ,false    ,""         ,dfNone     ,0          ,true       ,true       ,1       ,false     ,false      ,""      ,false );
				  InitDataProperty(0   ,cnt++   ,dtStatus     ,30    ,daCenter  ,true     ,"ibflag" );
				  InitDataProperty(0   ,cnt++   ,dtSeq        ,30    ,daCenter  ,true     ,"seq" );
				
				  InitDataProperty(0   ,cnt++   ,dtCheckBox   ,30    ,daCenter  ,true     ,"cfm_i"                  ,false    ,""         ,dfNone     ,0          ,true       ,true       ,false   ,false     ,false      ,false   ,true  );
				  InitDataProperty(0   ,cnt++   ,dtCheckBox   ,30    ,daCenter  ,true     ,"cfm_g"                  ,false    ,""         ,dfNone     ,0          ,true       ,true       ,false   ,false     ,false      ,false   ,true  );
				  InitDataProperty(0   ,cnt++   ,dtCheckBox   ,30    ,daCenter  ,true     ,"cfm_n"                  ,false    ,""         ,dfNone     ,0          ,true       ,true       ,false   ,false     ,false      ,false   ,true  );
				  InitDataProperty(0   ,cnt++   ,dtCheckBox   ,30    ,daCenter  ,true     ,"cfm_r"                  ,false    ,""         ,dfNone     ,0          ,true       ,true       ,false   ,false     ,false      ,false   ,false );
				  InitDataProperty(0   ,cnt++   ,dtCheckBox   ,30    ,daCenter  ,true     ,"cfm_d"                  ,false    ,""         ,dfNone     ,0          ,true       ,true       ,false   ,false     ,false      ,false   ,false );
				
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,30    ,daCenter  ,true     ,"ots_dtl_seq"            ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,100   ,daCenter  ,true     ,"n3pty_no"               ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,40    ,daCenter  ,true     ,"n3pty_src_sub_sys_cd"   ,false    ,""         ,dfNone     ,0          ,false      ,true       );		// Exp.Type - Main
				  InitDataProperty(0   ,cnt++   ,dtData       ,120   ,daCenter  ,true     ,"n3pty_bil_tp_nm"        ,false    ,""         ,dfNone     ,0          ,false      ,true       );		// Exp.Type - Sub
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,30    ,daCenter  ,true     ,"n3pty_bil_tp_cd"        ,false    ,""         ,dfNone     ,0          ,false      ,true       );		// Exp.Type - Sub : n3pty_bil_tp_cd				  
				  InitDataProperty(0   ,cnt++   ,dtData       ,110   ,daCenter  ,true     ,"n3pty_src_no"           ,false    ,""         ,dfNone     ,0          ,false      ,true       );		// S/P Inv No.(칼럼명:n3pty_src_no)

				
				  InitDataProperty(0   ,cnt++   ,dtCombo      ,60    ,daCenter  ,true     ,"vndr_cust_div_cd"       ,false    ,""         ,dfNone     ,0          ,true       ,false      );		// 3rd Party - Type
				  InitDataProperty(0   ,cnt++   ,dtPopupEdit  ,100   ,daCenter  ,true     ,"trd_party_val"          ,false    ,""         ,dfNone     ,0          ,true       ,false      ,8 );	// 3rd Party - Code
				
				  InitDataProperty(0   ,cnt++   ,dtData       ,60    ,daCenter  ,true     ,"eq_knd_nm"              ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,90    ,daCenter  ,true     ,"eq_no"                  ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,40    ,daCenter  ,true     ,"eq_tpsz_cd"             ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,90    ,daCenter  ,true     ,"g_bkg_no_all"           ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,90    ,daCenter  ,true     ,"g_bl_no_all"            ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,80    ,daCenter  ,true     ,"g_vvd"                  ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,60    ,daCenter  ,true     ,"if_curr_cd"             ,false    ,""         ,dfNone     ,0          ,false      ,true       ); // Interfaced Amount - LCL Cur
				  InitDataProperty(0   ,cnt++   ,dtData       ,80    ,daRight   ,true     ,"if_amt"                 ,false    ,""         ,dfFloat    ,2          ,false      ,true       ); // Interfaced Amount - LCL Amt
				  InitDataProperty(0   ,cnt++   ,dtData       ,80    ,daRight   ,true     ,"if_amt_usd"             ,false    ,""         ,dfFloat    ,2          ,false      ,true       ); // Interfaced Amount - USD(Equiv.)
				  InitDataProperty(0   ,cnt++   ,dtData       ,200    ,daCenter  ,true     ,"if_rmk"            	,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,80    ,daRight   ,true     ,"cfm_amt"                ,false    ,""         ,dfFloat    ,2          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,70    ,daCenter  ,true     ,"if_dt"                  ,false    ,""         ,dfDateYmd  ,0          ,false      ,true       ); 
				  InitDataProperty(0   ,cnt++   ,dtData       ,50    ,daCenter  ,true     ,"if_ofc_cd"              ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,70    ,daCenter  ,true     ,"if_usr_id"              ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,90    ,daCenter  ,true     ,"if_usr_nm"              ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,100   ,daCenter  ,true     ,"cfm_rmk"                ,false    ,""         ,dfNone     ,0          ,true       ,true       ); // Description
				  InitDataProperty(0   ,cnt++   ,dtData       ,50    ,daCenter  ,true     ,"rvw_ofc_cd"             ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtData       ,70    ,daCenter  ,true     ,"rvw_usr_id"             ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtCombo      ,150   ,daLeft  	,true     ,"n3pty_non_cfm_rsn_cd"   ,false    ,""         ,dfNone     ,0          ,false      ,true       ); // Reason for Non-TPB
				  InitDataProperty(0   ,cnt++   ,dtPopup      ,120   ,daCenter  ,true     ,"non_cfm_rsn_flg"   		,false    ,""         ,dfNone     ,0          ,true       ,true      ); // Non-TPB Remark
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,80    ,daCenter  ,true     ,"csr_no"                 ,false    ,""         ,dfNone     ,0          ,false      ,true       );
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"vndr_cnt_cd"            ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"vndr_seq"               ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"cust_cnt_cd"            ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"cust_seq"               ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"n3pty_ofc_cd"           ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"n3pty_if_tp_cd"         ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"src_vndr_seq"           ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"tes_gubun"              ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"trs_gubun"              ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"estm_seq_no"            ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"estm_rvis_no"           ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"estm_dtl_seq_no"        ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"estm_svr_id"            ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"cost_expt_flg"          ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"check_finc_dir_cd"      ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"ofc_cd"                 ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"eq_knd_cd"              ,false    ,""         ,dfNone);
				  InitDataProperty(0   ,cnt++   ,dtHidden     ,65    ,daCenter  ,true     ,"ida_sac_cd"             ,false    ,""         ,dfNone);
  									

  					RowHeight (0) = RowHeight(1) = 0;

  					DataLinkMouse("n3pty_src_no") = true;
  					
  					InitDataCombo (0, "vndr_cust_div_cd", " |"+combo01Text, " |"+combo01Code);
  					InitDataCombo (0, "n3pty_non_cfm_rsn_cd", combo02Text, combo02Code);

  					ColHidden("ibflag") = true;
  					ColHidden("cfm_i") = true;
  					ColHidden("cfm_g") = true;
  					ColHidden("cfm_n") = true;
  					ColHidden("cfm_r") = true;
  					ColHidden("cfm_d") = true;
  					
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
  				case "btn_save":
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
  					// init bind value due to "G" validatin check
  					grp_n3pty_src_sub_sys_cd = "_NULL";
  					grp_g_vvd = "_NULL";
  					grp_trd_party_val = "_NULL";
  					grp_g_bilTpCd = "_NULL";
  					grp_cnt = 0;
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_vvd":
  					var param = '?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  					ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 420, 'getVVD', '1,0,1,1,1,1,1,1');
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					break;
  				case "btns_calendar1":
  					 var cal = new calendarPopup();
  					 cal.select(formObject.s_sdate, 's_sdate', 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					var cal = new ComCalendarFromTo();
  					cal.select(formObject.s_sdate, formObject.s_edate, 'yyyy-MM-dd');
  					break;
  				case "btn_inv":
  					var str = getCheckN3ptyNo(formObject,sheetObject);
  					if(str != ''){
  						formObject.f_cmd.value = SEARCH;
  						formObject.method = "post";
  						formObject.action = "ESD_TPB_0106.do?pgmNo=ESD_TPB_0106";
  						formObject.submit();
  					}
  					break;
  				case "btn_roc":
  					var str = getCheckN3ptyNo(formObject,sheetObject);
  					if(str != ''){
  						formObject.f_cmd.value = SEARCH;
  						formObject.method = "post";
  						formObject.action = "ESD_TPB_0113.do?pgmNo=ESD_TPB_0113";
  						formObject.submit();
  					}
  					break;
  				case "btn_wo":
  					var str = getCheckN3ptyNo(formObject,sheetObject);
  					if(str != ''){
  						formObject.f_cmd.value = SEARCH;
  						formObject.method = "post";
  						formObject.action = "ESD_TPB_0114.do?pgmNo=ESD_TPB_0114";
  						formObject.submit();
  					}
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('TPB90014');
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

//  		    CHM-201325799 [TPB] Candidate Confirmation 화면 Control OFC 칼럼에 All 항목 추가

  			if(formObj.s_office_level.value != 'H' && formObj.s_office_level.value != "R" && formObj.s_office_level.value != "C"){
  		   		if(formObj.s_if_ctrl_cd.value != 'ALL' && formObj.s_if_ofc_cd.value == ''){
  		   			formObj.s_if_ofc_cd.required = true;
  		   		}
  			}	

  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  
  				//입력값 길이 체크
  				var lenArr = new Array();
  				lenArr[0] = new Array(formObj.s_bkg_no_all,'BKG No',formObj.s_bkg_no_all.getAttribute("maxlength"),11);
  				lenArr[1] = new Array(formObj.s_bl_no_all,'B/L No',formObj.s_bl_no_all.getAttribute("maxlength"));
  				lenArr[2] = new Array(formObj.s_vvd,'VVD',formObj.s_vvd.getAttribute("maxlength"));
  				
  				if(!checkFormLength(lenArr)){
  					return false;
  				}

  				//if(formObj.s_eq_tp_cd.value != '' || formObj.s_eq_no.value != ''){
  				if(formObj.s_eq_knd_cd.value != '' || formObj.s_eq_no.value != ''){
  					if(formObj.s_eq_no.value == ''){
  						ComShowCodeMessage('COM12130','Equipment','EQ No.','');
  						formObj.s_eq_no.focus();
  						return false;
  					}
  					//if(formObj.s_eq_tp_cd.value == ''){
  					if(formObj.s_eq_knd_cd.value == ''){
  						ComShowCodeMessage('COM12130','Equipment','EQ Kind Code','');
  						formObj.s_eq_knd_cd.focus();
  						return false;
  					}
  				}

  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0105GS.do", tpbFrmQryStr(formObj));
  				break;
  				
  			case IBSAVE:		//저장
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				var grpCnt = 0;
  				
  				//Confirmed가 체크안되 있거나, Review에 체크안되 있을 경우 save 불가, check상태 아닌 UPD제거
  				var check_cnt = 0;

  				//Confirmed 가 'N' 이거나 Review 에 체크하였을 경우 remark 입력 필수.
  				for(var i = 2; i <= sheetObj.RowCount+1 ; i++){
  				
  					// 그룹 체크박스 선택개수 체크 
  					if( sheetObj.CellValue(i, 'cfm_g') == '1' ){
  						grpCnt++;
  					}
  					
  					if( sheetObj.RowStatus(i) != 'R' 
  						&& sheetObj.CellValue(i, 'recm_flg') == '1' ){

  						if(sheetObj.CellValue(i, 'cfm_rmk') == ''){
  							ComShowCodeMessage('COM12130',(i-1)+' Row','Remarks','');
  							return false;
  						}
  					}

  					//Confirmed 가 'N' 일을 경우 Reason 입력 필수.
  					if( sheetObj.RowStatus(i) == 'U' 
  						&& sheetObj.CellValue(i, 'cfm_n') == '1' ){

  						if(sheetObj.CellValue(i, 'n3pty_non_cfm_rsn_cd') == '' || sheetObj.CellValue(i, 'non_cfm_rsn_flg')!= 'Y'){
//  							ComShowCodeMessage('COM12130',(i-1)+' Row','Reason and Note','');
  							ComShowCodeMessage('TPB90078','Non-TPB Reason and make a request(s) on ' + (i-1)+ ' row(s)');
  							return false;
  						}
  					}

  					if(sheetObj.RowStatus(i) != 'R'){
  						if(sheetObj.CellValue(i, 'n3pty_bil_tp_cd') == ''){
  							ComShowCodeMessage('COM12130',(i-1)+' Row','Billing Case','');
  							return false;
  						}
  						// JO Case, CSR No., GL Date, Actual VVD 
  						if(sheetObj.CellValue(i, 'n3pty_bil_tp_cd') == 'JO'){
  						    if(sheetObj.CellValue(i, 'csr_no').length == 0){
  						    	ComShowCodeMessage('TPB90038',(i-1)+' Row','CSR No.','');
      							return false;
  						    }
  						    if(sheetObj.CellValue(i, 'gl_dt').length != 8){
  						    	ComShowCodeMessage('TPB90038',(i-1)+' Row','GL Date','');
      							return false;
  						    }
  						    if(sheetObj.CellValue(i, 'vvd_cd').length == 0){
  						    	ComShowCodeMessage('TPB90038',(i-1)+' Row','Actual VVD','');
      							return false;
  						    }
  						}
  					}

  					//cfm_flg 세팅
  					if(sheetObj.RowStatus(i) != 'R'){
      					if(sheetObj.CellValue(i, 'cfm_i') == '1' || sheetObj.CellValue(i, 'cfm_g') == '1'){
      						sheetObj.CellValue(i, 'n3pty_cfm_cd') = 'Y';
      					}else if(sheetObj.CellValue(i, 'cfm_n') == '1'){
      						sheetObj.CellValue(i, 'n3pty_cfm_cd') = 'N';
      					}
  					}
  					
  					// RowStatus의 상태변화가 있을 때 check_cnt를 증가하여 Save가능하게 한다.
  					if(sheetObj.RowStatus(i) != "" && 
  					   sheetObj.CellValue(i,'cfm_i')=='1' || 
  					   sheetObj.CellValue(i,'cfm_g')=='1' || 
  					   sheetObj.CellValue(i,'cfm_n')=='1' ||
  					   sheetObj.CellValue(i,'cfm_r')=='1' ||
  					   sheetObj.CellValue(i,'cfm_d')=='1'
  					){
  						check_cnt += 1;
  					}else if(sheetObj.RowStatus(i) != "" && 
  					   sheetObj.CellValue(i,'cfm_i')!='1' ||
  					   sheetObj.CellValue(i,'cfm_g')!='1' ||
  					   sheetObj.CellValue(i,'cfm_n')!='1' ||
  					   sheetObj.CellValue(i,'cfm_r')!='1' ||
  					   sheetObj.CellValue(i,'cfm_d')!='1' 
  					){
  						//sheetObj.CellValue(i,'ibflag') = "";
  						sheetObj.RowStatus(i) = "";
  					}
  					
  				}// end - for(var i = 2; i <= sheetObj.RowCount+1 ; i++){

  				// 그룹 체크박스 선택개수 확인 - 2이상 50이하의 그룹선택을 할 수 있다.
  				// [CSR #2261] 그룹 체크박스 선택개수 확인 - 2이상 300이하의 그룹선택을 할 수 있다. (2017.10.18)
  				if( grpCnt != 0 && grpCnt < 2 || grpCnt > 300 ){
  					ComShowCodeMessage('TPB90079');
  					return;
  				}
  				// 선택된 checkBox가 없으면 Save할 수 없다.
  				if(check_cnt < 1){
  					//ComShowMessage(sheetObj.MessageText("UserMsg13"));
  					ComShowCodeMessage('TPB90080');
  					return;
  				}

  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0105GS.do", tpbFrmQryStr(formObj));
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
  			
  			/**
  			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
  			 */
  			if(s_if_ctrl_cd.value != "ALL" && !ComChkValid(formObj)) return false;
  			
  		}
  		
  		return true;
  	}
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){

  		//진입권한에 따라 체크박스의 종류를 다르게 보여준다.
  		if( document.form.s_office_level.value == "T"
  			|| document.form.s_office_level.value == "C" ){
  			sheetObj.ColHidden("cfm_i")=false;
  			sheetObj.ColHidden("cfm_g")=false;
  			sheetObj.ColHidden("cfm_n")=false;
  		}else if( document.form.s_office_level.value == "R"){
  			sheetObj.ColHidden("cfm_r")=false;
  			sheetObj.ColHidden("cfm_d")=false;
  		}else{
  			sheetObj.ColHidden("cfm_i")=true;
  			sheetObj.ColHidden("cfm_g")=true;
  			sheetObj.ColHidden("cfm_n")=true;
  			sheetObj.ColHidden("cfm_r")=true;
  			sheetObj.ColHidden("cfm_d")=true;
  		}//진입권한에 따라 체크박스의 종류를 다르게 보여준다.
  			
  		for ( var i = 2; i <= sheetObj.RowCount+1; i++ ){
  		
  			if(sheetObj.CellValue(i, "n3pty_src_no") != ""){ 
  				sheetObj.CellFontUnderline(i, "n3pty_src_no") = true;
  			}

  			//MNR 중 Manual로 등록되어 있으면 팝업링크 금지
  			if(sheetObj.CellValue(i,"n3pty_src_sub_sys_cd") == "MNR" && sheetObj.CellValue(i, "n3pty_if_tp_cd") == "M"){
  				sheetObj.CellFontUnderline(i, "n3pty_src_no") = false;
  			}
  			
  			//Billing Case가 JO 이면 금액 수정 가능
  			if(sheetObj.CellValue(i,"n3pty_bil_tp_cd") == "JO"){
  				sheetObj.CellEditable(i, "cfm_amt") = true;
  				// sheetObj.CellEditable(i, "cfm_flg_n") = false; // JO Case Blocking ... Added By Kim Jin-seung In 2007-10-29 // Changed In 2007-12-24
  			}
  			//cfm_amt 는 if_amt와 동일하게 설정
  			sheetObj.CellValue2(i, "cfm_amt") = sheetObj.CellValue(i, "if_amt");
  			
  			//자신의 점소로 I/F된 건만이 Confirm가능.
  			if( document.form.s_ofc_cd_for_rhq.value != sheetObj.CellValue(i, "ofc_cd") 
  				&& document.form.s_office_level.value != "R"){// * 2009-01-22 O Wan-Ki 1.3 confirm가능대상 변경(if_ofc_cd->ofc_cd)
  				sheetObj.RowEditable(i) = false;
  			}
  		}
  		var lvl = document.form.s_office_level.value;

  		for(var i = 2; i < sheetObj.Rows ; i++){

  			//Currency 없으면 confirm 불가능
  			if(sheetObj.CellValue(i, "if_curr_cd") != ""){
  				sheetObj.CellEditable(i, "if_curr_cd") = false;
  			}else{
  				sheetObj.CellEditable(i, "cfm_i") = false;
  				sheetObj.CellEditable(i, "cfm_g") = false;
  			}
  			//cfm_amt 없으면 confirm 불가능
  			if(sheetObj.CellValue(i, "cfm_amt") == "0"){
  				sheetObj.CellEditable(i, "cfm_i") = false;
  				sheetObj.CellEditable(i, "cfm_g") = false;	
  			}
  			//confirm flag가 N일때만 Reason edit 가능
  			if(sheetObj.CellValue(i, "cfm_n") == "0"){
  				sheetObj.CellEditable(i, "n3pty_non_cfm_rsn_cd") = false;
  			}
  			//RHQ Login 시 confirm 비활성, review만 활성
  			if(lvl == "R"){
  				sheetObj.CellEditable(i, "cfm_i") = false;
  				sheetObj.CellEditable(i, "cfm_g") = false;
  				sheetObj.CellEditable(i, "cfm_n") = false;
  			}
  			
  			if( document.form.s_nr.value == "N" ){
  				if( document.form.s_office_level.value == "T"
  		  			|| document.form.s_office_level.value == "C" ){
	  				sheetObj.CellEditable(i, "cfm_i") = false;
	  				sheetObj.CellEditable(i, "cfm_g") = false;
	  				sheetObj.CellEditable(i, "cfm_n") = false;
  				}
  			}
  			if( document.form.s_nr.value == "N" ){
  				sheetObj.CellEditable(i,"cfm_r") = true;
  				sheetObj.CellEditable(i,"cfm_d") = true;
  			}else{
  				sheetObj.CellEditable(i,"cfm_r") = false;
  				sheetObj.CellEditable(i,"cfm_d") = false;
  				sheetObj.ColHidden("cfm_r")=true;
  				sheetObj.ColHidden("cfm_d")=true;
  			}
  			
  		}
  		//Outstanding Amount 의 Auto Update check
  		tpb_chgColor_ots_amt(sheetObj, 59, 17, null, 2);
  		
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	 
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		
  		if(errMsg==null || errMsg == ''){
  			ComShowCodeMessage('COM12149','Data','','');
  		}

  		var lvl = document.form.s_office_level.value;
  		
  		

  		for(var i = 2; i < sheetObj.Rows ; i++){
  			
  			if(sheetObj.CellValue(i, "n3pty_src_no") != ""){ 
  				sheetObj.CellFontUnderline(i, "n3pty_src_no") = true;
  			}

  			//MNR 중 Manual로 등록되어 있으면 팝업링크 금지
  			if(sheetObj.CellValue(i,"n3pty_src_sub_sys_cd") == "MNR" && sheetObj.CellValue(i, "n3pty_if_tp_cd") == "M"){
  				sheetObj.CellFontUnderline(i, "n3pty_src_no") = false;
  			}
  			
  			
  			//save후 checkBox 조작 불가능
  			sheetObj.CellEditable(i, "cfm_i") = false;
  			sheetObj.CellEditable(i, "cfm_g") = false;
  			sheetObj.CellEditable(i, "cfm_n") = false;
  			sheetObj.CellEditable(i, "cfm_r") = false;
  			sheetObj.CellEditable(i, "cfm_d") = false;
  			sheetObj.CellEditable(i, "vndr_cust_div_cd") = false;
  			sheetObj.CellEditable(i, "trd_party_val") = false;
  			sheetObj.CellEditable(i, "cfm_rmk") = false;
  			sheetObj.CellEditable(i, "n3pty_non_cfm_rsn_cd") = false;
  			
  			//Vendor 없으면 confirm 불가능
  			if(sheetObj.CellValue(i, "vndr_cust_div_cd") == "" || sheetObj.CellValue(i, "trd_party_val") == ""){
  				sheetObj.CellEditable(i, "cfm_i") = false;
  				sheetObj.CellEditable(i, "cfm_g") = false;
  			}
  			//Currency 없으면 confirm 불가능
  			if(sheetObj.CellValue(i, "if_curr_cd") != ""){
  				sheetObj.CellEditable(i, "if_curr_cd") = false;
  			}else{
  				sheetObj.CellEditable(i, "cfm_i") = false;
  				sheetObj.CellEditable(i, "cfm_g") = false;
  			}
  			//cfm_amt 없으면 confirm 불가능
  			if(sheetObj.CellValue(i, "cfm_amt") == "0"){
  				sheetObj.CellEditable(i, "cfm_i") = false;
  				sheetObj.CellEditable(i, "cfm_g") = false;
  			}
  			//confirm flag가 N일때만 Reason edit 가능
  			if(sheetObj.CellValue(i, "cfm_n") == "0"){
  				sheetObj.CellEditable(i, "n3pty_non_cfm_rsn_cd") = false;
  			}

  			//RHQ Login 시 confirm 비활성, review만 활성
  			if(lvl == "R"){
  				sheetObj.CellEditable(i, "cfm_i") = false;
  				sheetObj.CellEditable(i, "cfm_g") = false;
  			}

  			//Finc_dir_cd 체크
  			//if(sheetObj.CellValue(i, "check_finc_dir_cd") != "Y"){
  			//	sheetObj.RowEditable(i) = false;
  			//}
  		}

  		//Outstanding Amount 의 Auto Upate check
  		tpb_chgColor_ots_amt(sheetObj, 59, 17, null, 2);
  	}

      // Added By Kim Jin-seung In 2007-05-08
  	function sheet1_OnPopupClick(sheetObj,Row,Col){
  		var colname = sheetObj.ColSaveName(Col);
  		switch(colname)
  		{
  		case "trd_party_val":
  		//get3rdParty_sheet( sheetObj.CellValue(Row,"vndr_cust_div_cd"), Row,Col,sheetObj ); // 3rd party open popup // Added 'sheetObj' parameter ... By Kim Jin-seung In 2008-05-19
  		get3rdPartyTarget_sheet( sheetObj.CellValue(Row,"vndr_cust_div_cd"), Row,Col,sheetObj );
  		break;
  		
  		case "non_cfm_rsn_flg":		// [CHM-201114303] [TPB] Non-TPB Candidate Remark 란 추가 요청 - Note On Non-TPB 팝업 호출
  		     var dispaly = "0,1,1,1,1,1,1,1,1,1";
     	     var classId = "ESD_TPB_0814";
		     var nowRow = sheetObjects[0].SelectRow;
		     if((sheetObjects[0].Cellvalue(nowRow,"cfm_n") == true && sheetObjects[0].Cellvalue(nowRow,"n3pty_non_cfm_rsn_cd") != '')||(sheetObjects[0].Cellvalue(nowRow,"non_cfm_rsn_flg")=='Y')){
		    	 
		     
		     var pOts_dtl_seq = sheetObjects[0].CellValue(nowRow, "ots_dtl_seq");
		     var pN3pty_non_cfm_rsn_cd = sheetObjects[0].CellValue(nowRow, "n3pty_non_cfm_rsn_cd");
		     var param = '?classId='+classId + "&ots_dtl_seq=" + pOts_dtl_seq + "&n3pty_non_cfm_rsn_cd=" + pN3pty_non_cfm_rsn_cd;
		     ComOpenPopup('ESD_TPB_0814.do' + param, 750, 330, 'getN3ptyNonCfmRsn', dispaly, true, false, Row, Col, sheetObj);
		     }
  			
  		break;
  		}
    }

      // Added By Kim Jin-seung In 2007-05-08
  	function sheet1_OnKeyDown(sheetObj,Row, Col, KeyCode, Shift){
  	    // sheetObj.CellValue2(Row,"trd_party_val") = sheetObj.CellValue(Row,"trd_party_val"); // Removed By Kim Jin-seung In 2007-06-21
  		return;
  	}

  	function sheet1_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift){
  	    // sheetObj.CellValue2(Row,"trd_party_val") = sheetObj.CellValue(Row,"trd_party_val"); // Removed By Kim Jin-seung In 2007-06-21
  		return;
  	}
  	
  	function sheet1_OnClick(sheetObj,Row,Col,Value){
  		var colNm = sheetObj.ColSaveName(Col);
  		var lvl = document.form.s_office_level.value;
  		
  		if( (colNm == 'cfm_i' || colNm == 'cfm_g' || colNm == 'cfm_n') && sheetObj.CellEditable(Row, colNm) == true ){
  			
  			if( Value == '1' ){
  				if( colNm == 'cfm_n' ){
  					sheetObj.CellValue(Row, 'n3pty_cfm_cd') = 'N';
  					sheetObj.CellValue(Row, 'n3pty_non_cfm_rsn_cd') = "";
  					sheetObj.CellEditable(Row, "n3pty_non_cfm_rsn_cd") = false;
  				}else if( colNm == 'cfm_i' ){
  					sheetObj.CellValue(Row, 'n3pty_cfm_cd') = '';
  				}else if( colNm == 'cfm_g' ){
  					sheetObj.CellValue(Row, 'n3pty_cfm_cd') = '';
  				}
  				return;
  			} else{
  				
  				if( colNm == 'cfm_flg_y' && sheetObj.CellEditable(Row, Col) ){
  					sheetObj.CellValue(Row, 'cfm_flg_n') = '0';
  					sheetObj.CellValue(Row, 'recm_flg') = '0';
  					sheetObj.CellValue(Row, 'n3pty_cfm_cd') = 'Y';
  				}else if( colNm == 'cfm_flg_n' ){
  					sheetObj.CellValue(Row, 'cfm_flg_y') = '0';
  					sheetObj.CellValue(Row, 'recm_flg') = '0';
  					sheetObj.CellValue(Row, 'n3pty_cfm_cd') = 'N';
  					sheetObj.CellEditable(Row, "n3pty_non_cfm_rsn_cd") = true;
  				}else if( colNm == 'recm_flg' ){
  					sheetObj.CellValue(Row, 'cfm_flg_y') = '0';
  					sheetObj.CellValue(Row, 'cfm_flg_n') = '0';	
  					sheetObj.CellValue(Row, 'n3pty_cfm_cd') = 'R';
  				}
  			}
  		}

  		//RHQ Login 시 confirm 비활성
  		if(lvl == "R"){
  			sheetObj.CellEditable(Row, "cfm_flg_y") = false;
  		}
	
  		//타모듈 팝업 호출
  		if(colNm == 'n3pty_src_no' && sheetObj.CellFontUnderline(Row, colNm)){
  			var src_cd = sheetObj.CellValue(Row, "n3pty_src_sub_sys_cd");
  			var param;
  			var theURL;
  			var winName;
  			var features;
  			if(src_cd == 'TRS'){
  				var trs_gubun = sheetObj.CellValue(Row, "trs_gubun");
  				if(trs_gubun > 0){
  					param = "?pgmNo=ESD_TRS_0038&inv_no="+sheetObj.CellValue(Row,"n3pty_src_no")+"&inv_vndr_seq="+sheetObj.CellValue(Row,"src_vndr_seq")+"&editflg=N";
  					theURL = "ESD_TRS_0038.do"+param;
  					winName = "ESD_TRS_0038";
  					//features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=700";
  					features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
  				}else{
  					param = "?pgmNo=ESD_TRS_0033&inv_no="+sheetObj.CellValue(Row,"n3pty_src_no")+"&inv_vndr_seq="+sheetObj.CellValue(Row,"src_vndr_seq")+"&mode=search";
  					theURL = "ESD_TRS_0033.do"+param;
  					winName = "ESD_TRS_0033";
  					//features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=630";
  					features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
  				}
  				ComOpenWindow(theURL,winName,features,true);
  			}else if(src_cd == 'TES'){
  				var tes_gubun = sheetObj.CellValue(Row, "tes_gubun");
  				if(tes_gubun != ""){
  					if(tes_gubun == "TM"){
  						param = "?pgmNo=ESD_TES_0017&inv_no="+sheetObj.CellValue(Row,"n3pty_src_no")+"&vndr_seq="+sheetObj.CellValue(Row,"src_vndr_seq");
  						theURL = "ESD_TES_0017.do"+param;
  						winName = "ESD_TES_0017";
  						//features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=570";
  						features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
  					}else if(tes_gubun == "ON"){
  						param = "?pgmNo=ESD_TES_0068&inv_no="+sheetObj.CellValue(Row,"n3pty_src_no")+"&vndr_seq="+sheetObj.CellValue(Row,"src_vndr_seq");
  						theURL = "ESD_TES_0068.do"+param;
  						winName = "ESD_TES_0068";
  						//features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=570";
  						features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
  					}else if(tes_gubun == "OF"){
  						param = "?pgmNo=ESD_TES_0018&inv_no="+sheetObj.CellValue(Row,"n3pty_src_no")+"&vndr_seq="+sheetObj.CellValue(Row,"src_vndr_seq");
  						theURL = "ESD_TES_0018.do"+param;
  						winName = "ESD_TES_0018";
  						//features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=620";
  						features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
  					}else if(tes_gubun == "ST"){
  						param = "?pgmNo=ESD_TES_0019&inv_no="+sheetObj.CellValue(Row,"n3pty_src_no")+"&vndr_seq="+sheetObj.CellValue(Row,"src_vndr_seq");
  						theURL = "ESD_TES_0019.do"+param;
  						winName = "ESD_TES_0019";
  						//features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=620";
  						features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
  					}
  					ComOpenWindow(theURL,winName,features,true);
  				}
  			}else if(src_cd == 'MNR'){
				var param;
				var winName = "EES_MNR_0192";
				var eqNo = sheetObj.CellValue(Row, "eq_no");
				var estmSeqNo = sheetObj.CellValue(Row, "estm_seq_no"); 
				var estmRvisNo = sheetObj.CellValue(Row, "estm_rvis_no");
				var eqKndCd = sheetObj.CellValue(Row, "eq_knd_cd")

				param = "?pgmNo=EES_MNR_0192&rqst_eq_no="+eqNo+"&rpr_rqst_seq="+estmSeqNo+"&rpr_rqst_ver_no="+estmRvisNo+"&eq_knd_cd="+eqKndCd;
				var features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:730px";
				ComOpenWindow('/hanjin/EES_MNR_0192.do'+param, winName, features, true);
  			}
  			
  			
  		}

  		//Outstanding Amount 의 Auto Update check
  		tpb_chgColor_ots_amt(sheetObj, 59, 17, null, 2);
  	}


      function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
  		
          // ComShowMessage( sheetObj.ColSaveName(NewCol) );
          if ( sheetObj.ColSaveName(NewCol)=="trd_party_val"){
          	var divCd = ComTrim(sheetObj.CellValue(NewRow, 'vndr_cust_div_cd'));
          	if( divCd!='C' && divCd!="V" && divCd!="S") {
          	    // ComShowCodeMessage('TPB90015'); 
          	    try { sheetObj.SelectCell(NewRow,"vndr_cust_div_cd"); } catch(e){  } /// set focus
          	}
          }
        
  		// invoice, ROC, W/O 버튼 display 조정
  		if(sheetObj.SelectRow > 1){
  			if(sheetObj.CellValue(NewRow, "n3pty_no") == ""){
  				document.getElementById('btn_inv_t').style.display = 'none';
  		  		document.getElementById('btn_roc_t').style.display = 'none';
  		  		document.getElementById('btn_wo_t').style.display = 'none';
  			}else{
  				document.getElementById('btn_inv_t').style.display = '';
  		  		document.getElementById('btn_roc_t').style.display = '';
  		  		document.getElementById('btn_wo_t').style.display = '';
  			}
  		}
      }
      
    // 자동 Grouping시 개별, Validation Alert를 무효/유효화하는 indicator 
  	var _alertSwitch = true;
  	var grp_n3pty_src_sub_sys_cd = "_NULL";
  	var grp_g_vvd = "_NULL";
  	var grp_trd_party_val = "_NULL";
  	var grp_g_bilTpCd = "_NULL";
  	var grp_g_sac_cd = "_NULL";
  	var grp_cnt = 0;

  	/** 
  	 * 2009-02-16 O Wan-Ki 1.5 I/G/N 전체선택 기능추가.
  	 * checkBox, 전체선택 시 header event를 잡기위한 OnMouseDown Event
  	 *
  	 **/ 
  	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y){
  		// ComShowMessage("MouseRow : " + sheetObj.MouseRow + " / MouseCol : " + sheetObj.MouseCol);
  		
  		var colNm = sheetObj.ColSaveName(sheetObj.MouseCol);
  		
  		if( sheetObj.MouseRow == 1 ){
  			if( colNm == "cfm_i" ){
  				sheetObj.CheckAll2("cfm_g") = 0;
  				// cfm_g 가 전체해제되면, _alertSwitch 기능을 초기화 해두어야한다.
  				_alertSwitch = true;
  				sheetObj.CheckAll2("cfm_n") = 0;
  			}else if( colNm == "cfm_g" ){
  				
  				sheetObj.CheckAll2("cfm_i") = 0;
  				sheetObj.CheckAll2("cfm_n") = 0;
  				
  			}else if( colNm == "cfm_n" ){
  				sheetObj.CheckAll2("cfm_i") = 0;
  				sheetObj.CheckAll2("cfm_g") = 0;
  				// cfm_g 가 전체해제되면, _alertSwitch 기능을 초기화 해두어야한다.
  				_alertSwitch = true;
  			}
  		}
  		
  		// _alertSwitch 작동여부 판별 start
  		if( sheetObj.MouseRow == 1 ){
  			if( colNm == "cfm_i" || colNm == "cfm_n" ){
  				_alertSwitch = true;
  				grp_n3pty_src_sub_sys_cd = "_NULL";
  				grp_g_vvd = "_NULL";
  				grp_trd_party_val = "_NULL";
  				grp_g_bilTpCd = "_NULL";
  				grp_g_sac_cd = "_NULL";
  			}else if( colNm == "cfm_g" ){
  				var k=0;
  				for(var i = 2; i <= sheetObj.RowCount+1 ; i++){
  					if(sheetObj.CellValue(i,"cfm_g") == 1){
  						k++;
  					}
  				}
  				if( k==0 ){
  					grp_n3pty_src_sub_sys_cd = "_NULL";
  					grp_g_vvd = "_NULL";
  					grp_trd_party_val = "_NULL";
  					grp_g_bilTpCd = "_NULL";
  					grp_g_sac_cd = "_NULL";
  				}
  				_alertSwitch = false;
  			}
  		}else if( sheetObj.MouseRow > 1 ){
  			var k=0;
  			for(var i = 2; i <= sheetObj.RowCount+1 ; i++){
  				if(sheetObj.CellValue(i,"cfm_g") == 1){
  					k++;
  				}
  			}
  			if( k==0 ){
  				grp_n3pty_src_sub_sys_cd = "_NULL";
  				grp_g_vvd = "_NULL";
  				grp_trd_party_val = "_NULL";
  				grp_g_bilTpCd = "_NULL";
  				grp_g_sac_cd = "_NULL";
  			}
  			_alertSwitch = true;
  		}
  		// _alertSwitch 작동여부 판별 end
  		
  		// sheet1의 'vndr_cust_div_cd'의 변화를 감지하기 위해 저장
  		if(colNm == "vndr_cust_div_cd"){
  			document.form.s_vndr_cust_div_cd.value = sheetObj.CellValue(Row, "vndr_cust_div_cd");
  		}
  		
  	}
  	
  	function sheet1_OnChange(sheetObj,Row,Col,Value){

  		var colNm = sheetObj.ColSaveName(Col);
  		//*2008-11-14 3rd party 지정없이 선택불가.
  		if(colNm == 'cfm_i' || colNm == 'cfm_g'){
  			if(sheetObj.CellValue(Row, 'vndr_cust_div_cd')==''||sheetObj.CellValue(Row, 'trd_party_val')==''){
  				sheetObj.CellValue2(Row, 'cfm_i') = 0;
  				sheetObj.CellValue2(Row, 'cfm_g') = 0;
  				ComShowCodeMessage('TPB90081');				
  				return;
  			}
  		}
  		
  		// Grouping Validation Check
        switch( Col ) {
	  		case 3 : // I
	  			if( sheetObj.cellValue(Row,'cfm_g') == 1 ){ grp_cnt --; }
	  			sheetObj.cellValue2(Row,'cfm_g') = 0;
	  			sheetObj.cellValue2(Row,'cfm_n') = 0;
	  			sheetObj.CellEditable(Row,"n3pty_non_cfm_rsn_cd")=false;
	  			break;
	  		case 4 : // G
	  			if( sheetObj.cellValue(Row,'cfm_g') == 1 ){ grp_cnt ++; }else{ grp_cnt --; }
	  			sheetObj.cellValue2(Row,'cfm_i') = 0;
	  			sheetObj.cellValue2(Row,'cfm_n') = 0;
	  			sheetObj.CellEditable(Row,"n3pty_non_cfm_rsn_cd")=false;
	  			break;
	  		case 5 : // N
	  			if( sheetObj.cellValue(Row,'cfm_g') == 1 ){ grp_cnt --; }
	  			sheetObj.cellValue2(Row,'cfm_i') = 0;
	  			sheetObj.cellValue2(Row,'cfm_g') = 0;
	  			break;
	  		case 6 :
	  			sheetObj.cellValue2(Row,'cfm_d') = 0;
	  			break;
	  		case 7 :
	  			sheetObj.cellValue2(Row,'cfm_r') = 0;
	  			break;
  		}

  		// validation check for "G" selection
  		if( sheetObj.CellValue(Row, 'cfm_g') == 1 ){ // when "G" checked
  			
  			var errCheck = 0; // total error count
  			var errMsg = "Invalidate Data"; // error alarm message

 			// VGM Billing Type Code끼리만  Group 가능함
  			if( grp_g_bilTpCd == "_NULL" ){
  				grp_g_bilTpCd = sheetObj.CellValue(Row, 'n3pty_bil_tp_cd');
  			}else{
  				if( sheetObj.CellValue(Row, 'n3pty_bil_tp_cd') != grp_g_bilTpCd ) {
  					var chkBilTpCds = "V1_V2_V3_V4";
  					if( (chkBilTpCds.indexOf(grp_g_bilTpCd) == -1 && chkBilTpCds.indexOf(sheetObj.CellValue(Row, 'n3pty_bil_tp_cd')) != -1 )
  							|| ( chkBilTpCds.indexOf(grp_g_bilTpCd) != -1 &&  chkBilTpCds.indexOf(sheetObj.CellValue(Row, 'n3pty_bil_tp_cd')) == -1)){
	  					sheetObj.cellValue2(Row,'cfm_g') = 0;
	  					errCheck ++;
	  					errMsg += "\n" + errCheck + ". Must be the VGM type grouped together";
  					}
  				}
  			}
  			
  			if( grp_trd_party_val == "_NULL" ){
  				grp_trd_party_val = sheetObj.CellValue(Row, 'trd_party_val');
  			}else{
  				if( sheetObj.CellValue(Row, 'trd_party_val')!= grp_trd_party_val ){
  					sheetObj.cellValue2(Row,'cfm_g') = 0; // cancel to "G" checking
  					errCheck ++;
  					errMsg += "\n" + errCheck + ". 3rd Party Code";
  				}
  			}
  			
  			if( grp_n3pty_src_sub_sys_cd == "_NULL" ){
  				grp_n3pty_src_sub_sys_cd = sheetObj.CellValue(Row, 'n3pty_src_sub_sys_cd');
  			}else{
  				if( sheetObj.CellValue(Row, 'n3pty_src_sub_sys_cd')!= grp_n3pty_src_sub_sys_cd ){
  					sheetObj.cellValue2(Row,'cfm_g') = 0;
  					errCheck ++;
  					errMsg += "\n" + errCheck + ". Exp.Type";
  				}
  			}
  			
  			if( grp_g_vvd == "_NULL" ){
  				grp_g_vvd = sheetObj.CellValue(Row, 'g_vvd');
  			}else{
  				if( sheetObj.CellValue(Row, 'g_vvd')!= grp_g_vvd ){
  					sheetObj.cellValue2(Row,'cfm_g') = 0;
  					errCheck ++;
  					errMsg += "\n" + errCheck + ". VVD";
  				}
  			}
  			
  			if( grp_g_sac_cd == "_NULL" ){
  				grp_g_sac_cd = sheetObj.CellValue(Row, 'ida_sac_cd');
  			}else{
  				if( sheetObj.CellValue(Row, 'ida_sac_cd')!= grp_g_sac_cd && document.form.s_cnt_cd.value == "IN" ){
  					sheetObj.cellValue2(Row,'cfm_g') = 0;
  					errCheck ++;
  					errMsg += "\n" + errCheck + ". SAC Code";
  				}
  			}

  			if( errCheck > 0 ){ 
  				grp_cnt --;
  				// 2009-02-16 O Wan-Ki 1.5 I/G/N 전체선택 기능추가. - 전체선택시에는 개별 error message를 제거한다.
  				if(_alertSwitch == true ){
  					ComShowMessage(errMsg);
  				}
  			}
  		}// validation check for "G" selection
  		
  		if( grp_cnt == 0 ){ 
  			grp_n3pty_src_sub_sys_cd = "_NULL";
  			grp_g_vvd = "_NULL";
  			grp_trd_party_val = "_NULL";
  			grp_g_bilTpCd = "_NULL";
  			grp_g_sac_cd = "_NULL";
  		}
  		
  		_sheet_onchange( sheetObj,Row,Col,Value );
  		var colNm = sheetObj.ColSaveName(Col);
  		var lvl = document.form.s_office_level.value;

  		
//  		//Cost Exception 건은 confirm 불가함
//  		if(colNm == "cfm_i" || colNm == "cfm_g"){
//  			if(sheetObj.CellValue(Row, 'cost_expt_flg') == "Y"){
//  				ComShowCodeMessage('TPB90026','','','');
//  				sheetObj.CellEditable(Row, "cfm_i") = false;
//  				sheetObj.CellEditable(Row, "cfm_g") = false;
//  				sheetObj.CellValue2(Row, "cfm_i") = "0";
//  				sheetObj.CellValue2(Row, "cfm_g") = "0";
//  				sheetObj.RowStatus(Row) = "";
//  				
//  				//group check 초기화.
//  				sheetObj.CheckAll2("cfm_i") = 0;
//  				sheetObj.CheckAll2("cfm_g") = 0;
//  				sheetObj.CheckAll2("cfm_n") = 0;
//  				grp_cnt = 0;
//  				grp_n3pty_src_sub_sys_cd = "_NULL";
//  				grp_g_vvd = "_NULL";
//  				grp_trd_party_val = "_NULL";
//  				grp_g_bilTpCd = "_NULL";
//  				
//  				return;
//  			}
//  		}

  		//FINC_DIR_CD 유효하지 않은 건은 confirm 불가함
  		if(colNm == "cfm_i" || colNm == "cfm_g"){
  			if(sheetObj.CellValue(Row, 'check_finc_dir_cd') != "Y"){
  			
  				ComShowCodeMessage('TPB90082');
  				
  				sheetObj.CellEditable(Row, "cfm_i") = false;
  				sheetObj.CellEditable(Row, "cfm_g") = false;
  				sheetObj.CellValue2(Row, "cfm_i") = "0";
  				sheetObj.CellValue2(Row, "cfm_g") = "0";
  				sheetObj.RowStatus(Row) = "";
  				
  				//group check 초기화.
  				sheetObj.CheckAll2("cfm_i") = 0;
  				sheetObj.CheckAll2("cfm_g") = 0;
  				sheetObj.CheckAll2("cfm_n") = 0;
  				grp_cnt = 0;
  				grp_n3pty_src_sub_sys_cd = "_NULL";
  				grp_g_vvd = "_NULL";
  				grp_trd_party_val = "_NULL";
  				grp_g_bilTpCd = "_NULL";
  				
  				return;
  			}
  		}

  		if(colNm == 'vndr_cust_div_cd' || colNm == 'trd_party_val'){

  			var vndr_cust_div_cd = sheetObj.CellValue(Row, "vndr_cust_div_cd");
  			var trd_party_val = sheetObj.CellValue(Row, "trd_party_val");
  			trd_party_val = ComTrim(trd_party_val).toUpperCase(); // ComTrim & UPPER CASE 
  			sheetObj.CellValue2(Row, "trd_party_val") = trd_party_val;

  			if( ComTrim( sheetObj.CellValue(Row, 'trd_party_val') ) != ''){
  			    
  				if( ComTrim(sheetObj.CellValue(Row, 'vndr_cust_div_cd') ) != ""){
  					sheetObj.CellEditable(Row, "cfm_i") = true;
  					sheetObj.CellEditable(Row, "cfm_g") = true;

  				}

  				if(sheetObj.CellValue(Row, 'if_curr_cd') == "" ||
  					parseFloat(sheetObj.CellValue(Row, 'cfm_amt')) == 0){
  					sheetObj.CellEditable(Row, "cfm_flg_y") = false;
  					sheetObj.CellValue2(Row, "cfm_flg_y") = "0";
  				}
  				
  			}else{
  				sheetObj.CellEditable(Row, "cfm_flg_y") = false;
  				sheetObj.CellValue2(Row, "cfm_flg_y") = "0";
  				sheetObj.CellValue2(Row, "trd_party_val") = "";
  			}

  		
  			if(colNm == "vndr_cust_div_cd" && vndr_cust_div_cd == ""){
  				sheetObj.CellValue2(Row, "trd_party_val") = "";
  				sheetObj.CellValue2(Row, "vndr_cnt_cd") = "";
  				sheetObj.CellValue2(Row, "vndr_seq") = "";
  				sheetObj.CellValue2(Row, "cust_cnt_cd") = "";
  				sheetObj.CellValue2(Row, "cust_seq") = "";
  				sheetObj.CellValue2(Row, "n3pty_ofc_cd") = "";
  			}

              // 3rd Party Input directly ... 
              if ( trd_party_val.length == 0 ){ // 3rd party value가 없으면 
              
  				sheetObj.CellValue2(Row, "trd_party_val") = "";
  				sheetObj.CellValue2(Row, "vndr_cnt_cd") = "";
  				sheetObj.CellValue2(Row, "vndr_seq") = "";
  				sheetObj.CellValue2(Row, "cust_cnt_cd") = "";
  				sheetObj.CellValue2(Row, "cust_seq") = "";
  				sheetObj.CellValue2(Row, "n3pty_ofc_cd") = "";
  				
              } else { // 있을 경우 유효성 체크
                  if ( colNm == 'trd_party_val' && ( vndr_cust_div_cd=="V" || vndr_cust_div_cd=="C" || vndr_cust_div_cd=="S" ) ){ // Add colNm condition By Kim Jin-seung In 2008-05-21
                      
                        // server side로부터 가져와서 getTPBGenCombo 함수이하에서 직접 처리함 
                        document.all.s_vndr_cust_div_cd.value = vndr_cust_div_cd; // input type hidden 이용 
                        document.all.s_trd_party_val.value = trd_party_val; // input type hidden 이용 
                        getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd"), Row); 

                  }
              }
  		}
  		
  		/* 3rd party없이 confirm허용
  		if( colNm == 'vndr_cust_div_cd' ) {
  			sheetObj.CellValue2(Row, "trd_party_val") = ""; 
//  			sheetObj.CellEditable(Row, "cfm_flg_y") = false;
  			sheetObj.CellEditable(Row, "cfm_i") = false;
  			sheetObj.CellEditable(Row, "cfm_g") = false;
//  			sheetObj.CellValue2(Row, "cfm_flg_y") = "0";			
  			sheetObj.CellValue2(Row, "cfm_i") = "0";			
  			sheetObj.CellValue2(Row, "cfm_g") = "0";									
  	    }
  		*/

  		if(colNm == 'if_curr_cd'){
  			if(sheetObj.CellValue(Row, 'if_curr_cd') != "" &&
  				ComTrim(sheetObj.CellValue(Row, 'vndr_cust_div_cd')) != '' &&
  				sheetObj.CellValue(Row, 'trd_party_val') != '' &&
  				parseFloat(sheetObj.CellValue(Row, 'cfm_amt')) > 0){
  				sheetObj.CellEditable(Row, "cfm_i") = true;
  				sheetObj.CellEditable(Row, "cfm_g") = true;								
  			}else{
  				sheetObj.CellEditable(Row, "cfm_i") = false;
  				sheetObj.CellEditable(Row, "cfm_g") = false;
  				sheetObj.CellValue2(Row, "cfm_i") = "0";			
  				sheetObj.CellValue2(Row, "cfm_g") = "0";									
  			}
  		}

  		if(colNm == 'cfm_amt'){
  			if(parseFloat(sheetObj.CellValue(Row, 'cfm_amt')) > 0 &&
  				sheetObj.CellValue(Row, 'if_curr_cd') != "" &&
  				ComTrim(sheetObj.CellValue(Row, 'vndr_cust_div_cd')) != '' &&
  				sheetObj.CellValue(Row, 'trd_party_val') != ''){
  				sheetObj.CellEditable(Row, "cfm_i") = true;
  				sheetObj.CellEditable(Row, "cfm_g") = true;
  			}else{
  				sheetObj.CellEditable(Row, "cfm_i") = false;
  				sheetObj.CellEditable(Row, "cfm_g") = false;				
  				sheetObj.CellValue2(Row, "cfm_i") = "0";
  				sheetObj.CellValue2(Row, "cfm_g") = "0";
  			}

  			if(sheetObj.CellValue(Row,"n3pty_bil_tp_cd") == "JO"){
  				// if(parseFloat(sheetObj.CellValue(Row,"if_amt")) > parseFloat(sheetObj.CellValue(Row,"cfm_amt"))){ // Removed By Kim Jin-seung In 2007-07-06
  				if( parseFloat(sheetObj.CellValue(Row,"cfm_amt")) <= 0  ){ // Changed By Kim Jin-seung In 2007-07-06
  					ComShowCodeMessage('TPB90035','Confirmed Amount','0.00'); // Changed By Kim Jin-seung In 2007-07-06
  					sheetObj.CellValue2(Row,"cfm_amt") = sheetObj.CellValue(Row,"if_amt");
  					sheetObj.CellEditable(Row, "cfm_flg_y") = true;
  					sheetObj.CellEditable(Row, "cfm_flg_n") = true; // Added In 2007-12-24
  				}
  			}
  		}


//  		if(colNm == "cfm_flg_n"){
  		if(colNm == "cfm_n"){		
  			if(Value == "0"){
  				sheetObj.CellValue2(Row, 'n3pty_non_cfm_rsn_cd') = "";
  				sheetObj.CellEditable(Row, "n3pty_non_cfm_rsn_cd") = false;
  			}else if(Value == "1"){
  				sheetObj.CellEditable(Row, "n3pty_non_cfm_rsn_cd") = true;
//  				sheetObj.CellValue2(Row, 'cfm_flg_y') = '0';
//  				sheetObj.CellValue2(Row, 'recm_flg') = '0';
  				sheetObj.CellValue2(Row, 'cfm_i') = '0';
  				sheetObj.CellValue2(Row, 'cfm_g') = '0';				
  				sheetObj.CellValue2(Row, 'n3pty_cfm_cd') = 'N';

  			}
  		}

  		if(colNm == 'n3pty_non_cfm_rsn_cd'){
  			if(Value == "CN"){
  				ComOpenPopup('/hanjin/COM_ENS_092.do', 850, 550, 'getStaff_sheet_formail', 'none', Row, 22);
  			}
  		}

  		//RHQ Login 시 confirm 비활성
  		if(lvl == "R"){
//  		sheetObj.CellEditable(Row, "cfm_flg_y") = false;
  			sheetObj.CellEditable(Row, "cfm_i") = false;
  			sheetObj.CellEditable(Row, "cfm_g") = false;
  		}

  		//Outstanding Amount 의 Auto Upate check
  		tpb_chgColor_ots_amt(sheetObj, 59, 17, null, 2);
  		
  		//STS > UDP 상태표시 조작
  		if(sheetObj.CellValue(Row, "cfm_i") == "0" &&
  	       sheetObj.CellValue(Row, "cfm_g") == "0" &&
  	       sheetObj.CellValue(Row, "cfm_n") == "0" &&
  	       sheetObj.CellValue(Row, "cfm_r") == "0" &&
  	       sheetObj.CellValue(Row, "cfm_d") == "0"){
  				sheetObj.RowStatus(Row) = "";
  		}
  		
  		// sheet1의 'vndr_cust_div_cd'의 변화를 감지하여 'trd_party_val'을 초기화한다.
  		if(colNm == "vndr_cust_div_cd"){
  			var sVndrCustDivCd = document.form.s_vndr_cust_div_cd.value;
  			var vndrCustDivCd = sheetObj.CellValue(Row, "vndr_cust_div_cd");
  			if(sVndrCustDivCd != vndrCustDivCd){
  				sheetObj.CellValue2(Row, "trd_party_val") = "";
  			}
  		}
  		
  		// Non-Confirm 의 경우를 제외하고 Reason for Non-TPB 초기화 되어야 함
  		if( sheetObj.CellValue(Row, 'cfm_g') == 1 ){
  			sheetObj.CellValue2(Row, "n3pty_non_cfm_rsn_cd") = "";
  		}
  		
  	}
  	/////////onChange/////////////////////////////////////////

  	function getStaff_sheet_formail(rowArray, row, col){
  		var gubun = ':';
  		var user_id = '';
  		var user_email = '';

  		for(var i=0; i<rowArray.length; i++){
  			if(i == rowArray.length-1) gubun = '';

  			colArray = rowArray[i];
  			
  			user_id += colArray[0] + gubun;
  			user_email += colArray[1] + gubun;
  		}

  		var sheetObj = sheetObjects[0];

  		sheetObj.CellValue(row, 'toEmail') = user_email+";"+user_id;

  	}

//  	var mover_pos="";
//  	function sheet1_OnMouseMove(sheetObj,Button, Shift, X, Y){
//  	    
//  	    try {
//      		//마우스 위치를 행과 컬럼과 값 가져오기
//      		Row = sheetObj.MouseRow;
//      		Col = sheetObj.MouseCol;
//      
//      		//데이터 행이 아니거나 7컬럼이 아닌 경우 그냥 벗어남
//      		if(Row <= 0 || sheetObj.ColSaveName(Col) != 'if_rmk') {
//      			ShowTip.style.visibility = 'hidden';
//      			return;
//      		}
//      
//      		//전역 변수를 통해 현재 풍선도움말이 표시되는 셀의 위치를 기억함
//      		if 	(mover_pos == Row + "/" + Col) return;
//      		mover_pos = Row + "/" + Col;
//      
//      		sText = sheetObj.CellText(Row, "if_rmk");
//      
//      		//아무런 글자가 없는 경우 풍선도움말을 지운다.
//      		if(sText == "")
//      		{
//      			ShowTip.style.visibility = 'hidden';
//      			return;
//      		}
//      			
//      		//풍선도움말 만들기
//      		popFrame2.sheetPopToolTip(sheetObj, X+2, Y-2, ShowTip, sText);
//  	    } catch(e) {
//  	    	alert(e);
//  	    }
//  	}

  	function getVVD(rArray){
  		var cArray = rArray[0];
  		document.all.s_vvd.value = cArray[7];
  	}

  	function valueSplit(formObj){
  		//입력값 쪼개기  
  		formObj.s_bkg_no.value       = formObj.s_bkg_no_all;
  		formObj.s_bl_no.value		 = formObj.s_bl_no_all;
  		formObj.s_vsl_cd.value	     = formObj.s_vvd.value.substring(0,4);
  		formObj.s_skd_voy_no.value   = formObj.s_vvd.value.substring(4,8);
  		formObj.s_skd_dir_cd.value   = formObj.s_vvd.value.substring(8,9);
  	}
  	
  	function tpb_searchBillingCaseByExpenseType(){
  		if(document.all.s_n3pty_src_sub_sys_cd.value != ""){
  			getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseByExpenseType','F','','2',new Array("s_n3pty_src_sub_sys_cd"));
  		}else{
  			ComClearCombo(document.all.s_n3pty_bil_tp_cd);
  			ComAddComboItem(document.all.s_n3pty_bil_tp_cd, "<<Select>>", "");	
  		}
  	}
  	
  	function getCheckN3ptyNo(formObj, sheetObj){
  		var str = '';
  		var temp = '';
  		if(sheetObj.RowCount > 0){
      		for ( var i=2; i < sheetObj.RowCount+2; i++ ){
      			//if(sheetObj.RowStatus(i) == 'U'){
      			temp = sheetObj.CellValue(i,'n3pty_no'); 
      			if ( temp.length==14 ){
      				str += temp+"|";
       			    temp = '';
      			}
      			//}
      		}
      		document.form.s_n3pty_no_strs_link.value = str;
  		} else {
  		    str = '';
  		}

  		if(str == ''){
  			ComShowCodeMessage('COM12176','','','');
  		}
  		
  		return str;
  	}
  	
	/* 개발자 작업  끝 */