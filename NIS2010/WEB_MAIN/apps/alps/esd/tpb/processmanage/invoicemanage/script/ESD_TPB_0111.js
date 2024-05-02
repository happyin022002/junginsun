/*=========================================================
vbnzxcvbnm,./Zxc*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0111.js
*@FileTitle : Invoice Revise/Cancel
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-17
*@LastModifier : Sun, CHOI
*@LastVersion : 1.9
* 2008-09-12 O Wan-Ki 1.0 최초 생성
* 2008-12-19 O Wan-Ki 1.1 Recovery Activity 조회기능 보완.
* 2009-03-13 O Wan-Ki 1.2 N200903090210, Invoice Revision 가능여부 판단기능 구현.
* 2009-03-16 O Wan-Ki 1.3 KRW,JPY,VND 의 Amount 는 정수로 보완.
* 2009-04-27 O Wan-Ki 1.4 N200904160080, 주소영역 save 가능여부 판단기능 추가.
* 2009-06-09 O Wan-Ki 1.5 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
* 2009-06-29 O Wan-Ki 1.5 S1V-09P-001, tax 전송부분 보완 
* 2009-07-31 O Wan-Ki 1.6 N200907020250, 인도 동적인보이스 Revision 적용
* 2009-10-12 Park Sung-Jin 1.7 ALPS Migration 작업
* 2010-03-05 Sun, CHOI 1.8 TPB Invoice Inquiry -> TPB Invoice Revise/Cancel 호출하는 방법 보완
* 2010-03-17 Sun, CHOI 1.9 TPB Invoice Preview POPUP 으로 변경
* 2010-10-22 손은주 [CHM-201006504-01] [TPB] Currency Change Validation 보완
* 2015.08.22 KIM HYUN HWA [CHM-201537151]그룹사 표준 코드 시행 프로그램 수정- 조직코드 변경
* 2015.11.11 KIM HYUN HWA [CHM-201538870]TPB code 추가에 (Pier Pass-PI) 따른 TPB invoice preview 화면 수정 요청
* 2015.11.12 KIM HYUN HWA [CHM-201538882]인도지역 Swachh Bharat Cess(SBC) 신설 관련 TPB Invoice 수정
* 2016.04.12 KIM HYUN HWA [CHM-201641107]Logistics Rev  데이터 ROC, W/O 기능 제한
*                                       (N3PTY_TP_CD 가 'R' 인 경우 기능 사용할수 없이 조회만 되도록 함) 
* 2016.05.25 KIM HYUN HWA [CHM-201641620]인도 Tax 추가 요청(KKC 추가)-2016.06.01일부 적용 Tax
* 2016.05.26 KIM HYUN HWA [CHM-201641663]Microsoft사 Load ID 추가 요청                                     
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
     * @class ESD_TPB_0111 : ESD_TPB_0111 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0111() {
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
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;
  var readOnly = true;
  var tabObjects = new Array();
  var tabCnt = 0;
  
  // collection activity 전역 변수 
  var s_clt_agn_flg = ""; // now final status (in the db system)
  var isSaveEnd = true; 

  //Sheet Column 위치
  var colLoc = new Array();

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBTab Object를 초기화 설정
  	 * 탭 ID는 tab1,tab2,...
  	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
  	 */
	function InitTab(tab) {
		try{
			with(tab){
				InsertTab(0, "Tanker Index" , 23 );
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
  		 /*
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
  		*/
  		
  		var tabObj = document.all.tab1;
		var nItem = 0;
		tabObj.BackColor="#FFFFFF";
		tabObj.TabBackColor(nItem)="146,174,230";
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
 	function setTabObject(tab_obj){
 		tabObjects[tabCnt++] = tab_obj;	
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

 			sheetObjects[i].Visible = false;
 		}
  		
  		//getTPBGenCombo('s_curr_cd','searchInvoiceCurrency','F','','2',new Array("s_ofc_cd", "s_rhq_cd", "s_cnt_cd"));
  		getCurrencyList();
		ComOpenWait(true);
  		document.form.s_clt_agn_flg.onchage = s_clt_agn_flg_OnChange; // Added By Kim Jin-seung In 2007-10-18
  		
  		if ( document.form.pop_yn.value == "Y" ){
   		   document.all.btn_close_t.style.display = "";
 		}else{
 		   document.all.btn_close_t.style.display = "none";
 		}
  		
  	    var s_correction_yn = document.form.s_correction_yn.value; // Added In 2008-06-04
  	    if ( s_correction_yn=="Y" ){ // Added In 2008-06-04
      		document.form.s_vndr_cust_div_cd.value = document.form.s_h_vndr_cust_div_cd.value;
      		document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange;
      		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
      		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;
  	    }
  	 
  		if ( document.all.s_detail_n3pty_no.value != "" || document.all.s_n3pty_inv_no.value != "" ) {
  			
      		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH);
            editInit();
  		} else {
  		    document.all.btn_retrieve_t.style.display = "";
  		    document.all.s_n3pty_inv_no.readOnly = false;
  		}
  		
		if(document.form.s_n3pty_inv_no.value == ""){
			document.form.s_curr_cd.disabled = true;
		}
		
		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,SEARCH02);
		ComOpenWait(false);
  	}

  	function editInit(){
  	    document.all.btn_preview_t.style.display = "";
  		var s_same_version_yn = document.all.s_same_version_yn.value; 
  		var s_correction_yn = document.all.s_correction_yn.value; 
  		var s_inquiryOnly_yn = document.all.s_inquiryOnly_yn.value;

  		if ( s_inquiryOnly_yn == "Y" ){
              document.all.s_curr_cd.disabled = true;
              document.all.s_vat_xch_rt_chk.disabled = true;
              document.all.s_clt_agn_flg.disabled = true;

      		for(i=0;i<sheetObjects.length;i++){
      			sheetObjects[i].Editable = false;  
      		}
  		// } else if (s_same_version_yn=="Y" && s_correction_yn=="Y"){
  		} else if (s_correction_yn=="Y"){
  		    readOnly = false;
  		    // ComShowMessage("Y");
  		    document.all.btn_cancel_t.disabled = false;
  		    document.all.btn_cancel_t.style.display = "";
  		    document.all.btn_save_t.disabled = false;
  		    document.all.btn_save_t.style.display = "";
  		} else {
            document.all.s_curr_cd.disabled = true;
            document.all.s_vat_xch_rt_chk.disabled = true;
            document.all.s_clt_agn_flg.disabled = true;

      		for(i=0;i<sheetObjects.length;i++){
      			sheetObjects[i].Editable = false;  
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
  		//switch(sheetNo) {
  			//case 1:	  //IBSheet1 init
  			if(sheetNo != sheetObjects.length){ 
  				with (sheetObj) {
  					var cnt = 0;
  					// 높이 설정
  					style.height = 120;
  										
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;

  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;

  				   //전체Edit 허용 여부 [선택, Default false]
  					Editable = true;

  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 9, 100);

  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(65, 0, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					// 2015.08.22 조직변경 
 					if(document.form.s_ofc_cd.value     ==  "ATLSC" //"ATLBB"
  			  			|| document.form.s_ofc_cd.value ==  "ATLSA" //"ATLSC"
  			  			|| document.form.s_ofc_cd.value ==  "CHISC" //"CHIBB"
  			  			|| document.form.s_ofc_cd.value ==  "HOUSC" //"HOUBB"
  			  			|| document.form.s_ofc_cd.value ==  "ILMBS"          
  			  			|| document.form.s_ofc_cd.value ==  "LGBSC" //"LGBBB"
  			  			|| document.form.s_ofc_cd.value ==  "NYCSC" //"NYCBB"
  			  			|| document.form.s_ofc_cd.value ==  "ORFSO" //"ORFBS"
  			  			|| document.form.s_ofc_cd.value ==  "PDXSO" //"PDXBS"
  			  			|| document.form.s_ofc_cd.value ==  "PHXSA" //"PHXSC"
  			  			|| document.form.s_ofc_cd.value ==  "SAVSO" //"SAVBS"
  			  			|| document.form.s_ofc_cd.value ==  "SEASC" //"SEABB"
 					){	
  			  			InitHeadMode(true, false, false, true, false, false);
  			  		}else {
  			  			InitHeadMode(true, false, true, true, false, false);
  			  		}
  					 var HeadTitle = "Del.|STS|Seq.|SAC Code|SAC Description|Invoice No|TPB No.|Billing Case|Billing Case Name|EQ Kind|EQ No.|TP/SZ|BKG No.|B/L No.|Load ID|VVD|VVD|MG Set No.|Location|Terminal Name|ATD|Account Name|Account Code|Route|New EQ No.|New Seal No.|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|CSR No.|GL Date|Original AMT|Add AMT|for Invoice|||||||||||||||||||VAT|VAT AMT||R_type";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					sheetNo = "";
  					
  					//데이터속성    [ ROW, COL,   DATATYPE,   	  WIDTH, 	DATAALIGN, COLMERGE,SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtHidden,      	 30,    daCenter,  true,    sheetNo+"delChkBox", 			false,			"",		dfNone,			0,		true); // dtDelCheck
  					InitDataProperty(0, cnt++, dtStatus,      	 30,    daCenter,  true,    sheetNo+"ibflag");
  					InitDataProperty(0, cnt++, dtHidden,      	 30,    daCenter,  true,    sheetNo+"seq", 					false,			"",		dfNone,			0,		false);
  					InitDataProperty(0, cnt++, dtData,      	 65,    daCenter,  true,    sheetNo+"ida_sac_cd",        	false,          "",     dfNone,    		0,     	false,      false);
					InitDataProperty(0, cnt++, dtData,      	240,    daLeft,    true,    sheetNo+"ida_sac_nm",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtHidden,     	 80,    daCenter,  true,    sheetNo+"n3pty_inv_no",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"n3pty_no",        		false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtHidden,     	 80,    daCenter,  true,    sheetNo+"n3pty_bil_tp_cd",      false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtHidden,      	120,    daCenter,  true,    sheetNo+"n3pty_bil_tp_nm",      false,          "",     dfNone,    		0,     	false,      false);
  					
  					InitDataProperty(0, cnt++, dtData,     		 60,    daCenter,  true,    sheetNo+"eq_knd_nm",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,      	 80,    daCenter,  true,    sheetNo+"eq_no",        		false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     		 50,    daCenter,  true,    sheetNo+"eq_tpsz_cd",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"bkg_no_all",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtHidden,     	 90,    daCenter,  true,    sheetNo+"bl_no_all",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     	     90,    daCenter,  true,    sheetNo+"lod_id",           	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"vvd",        			false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtHidden,   		 70,    daCenter,  true,    sheetNo+"vvd_cd",     			false,          "",     dfNone,    		0,     	false,      false); // Added By Kim Jin-seung In 2007-08-13

  					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"mgset_no",        		false,          "",     dfNone,    		0,     	true,       true);

  					InitDataProperty(0, cnt++, dtData,     		 60,    daCenter,  true,    sheetNo+"yd_cd",        		false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     		170,    daLeft,    true,    sheetNo+"yd_nm",        		false,          "",     dfNone,    		0,     	false,      false);
					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"atd",        			false,          "",     dfTimeHms,    	0,     	false ,     false);
					InitDataProperty(0, cnt++, dtCombo,     	160,    daLeft,    true,    sheetNo+"acct_cd",        		false,          "",     dfNone,    		0,     	true,       true);
					InitDataProperty(0, cnt++, dtHidden,     	210,    daLeft,    true,    sheetNo+"acct_cd_org",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,      	230,    daCenter,  true,    sheetNo+"route",        		false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,      	110,    daCenter,  true,    sheetNo+"new_eq_no",        	false,          "",     dfNone,    		0,     	true,       true, 		11);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"new_cntr_seal_no",     false,          "",     dfNone,    		0,     	true,       true, 		10);
  					
  					InitDataProperty(0, cnt++, dtData,      	130,    daCenter,  true,    sheetNo+"cita_no",        		false,          "",     dfNone,    		0,     	true,       true, 		20);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"cntr_wgt",        		false,          "",     dfFloat,    	2,     	true,       true, 		13);
  					InitDataProperty(0, cnt++, dtCombo,     	 60,    daCenter,  true,    sheetNo+"n3pty_cntr_wgt_ut_cd", false,          "",     dfNone,    		0,     	true,       true,		 3);
  					InitDataProperty(0, cnt++, dtData,      	100,    daRight ,  true,    sheetNo+"wt_hrs",        		false,          "",     dfFloat,    	2,     	true,       true,		 6);
  					InitDataProperty(0, cnt++, dtPopup,      	 80,    daCenter,  true,    sheetNo+"occr_dt",        		false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"new_vsl_cd",        	false,          "",     dfNone,    		0,     	true,       true,		 4);
  					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"new_bkg_no",        	false,          "",     dfNone,    		0,     	true,       true, 		11);
  					InitDataProperty(0, cnt++, dtPopup,      	 80,    daCenter,  true,    sheetNo+"damage_dt",        	false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"repair_location",      false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,      	 80,    daCenter,  true,    sheetNo+"lst_free_dt",        	false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,      	 80,    daCenter,  true,    sheetNo+"pkup_dt",        		false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daCenter,  true,    sheetNo+"ft_ovr_dys",        	false,          "",     dfInteger,    	0,     	true,       true,		 3);			
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"csr_no",        		false,          "",     dfNone,    		0,     	false,      false); // Added By Kim Jin-seung In 2007-08-13
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"gl_dt",        		false,          "",     dfNone,    		0,     	false,      false); // Added By Kim Jin-seung In 2007-08-13

  					InitDataProperty(0, cnt++, dtData,      	 80,    daRight ,  true,    sheetNo+"ots_amt",        		false,          "",     dfFloat,    	2,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     		 80,    daRight ,  true,    sheetNo+"inv_dtl_add_amt", 		false,          "",     dfFloat,    	2,     	true,       true,    	17);
  					InitDataProperty(0, cnt++, dtData,      	 90,    daRight ,  true,    sheetNo+"inv_dtl_amt",        	false,          "",     dfFloat,    	2,     	true,       true, 		17);

  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"eq_knd_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"fm_nod_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"via_nod_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"to_nod_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"dor_nod_cd",        	false,          "",     dfNone,    		0,     	true,       true);

  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"bkg_no",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"bkg_no_split",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"bl_no",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"bl_no_tp",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"bl_no_chk",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"vsl_cd",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"skd_voy_no",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"skd_dir_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"estm_svr_id",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"n3pty_inv_dtl_seq",    false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"original_inv_dtl_amt", false,          "",     dfFloat,    	2,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"so_if_seq",        	false,          "",     dfInteger,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"ots_dtl_seq",        	false,          "",     dfNone,    		0,     	true,       true);
  			// 2015.08.22 조직변경 PKGBB -- > PKGSC
  		    if(document.form.s_ofc_cd.value == "PKGSC"){
  					InitDataProperty(0, cnt++, dtHidden,		 45,	daCenter,  true,	sheetNo+"vat_dtl_chk",			false,			"",		dfNone,			0,	    true ,		true,		 1,		false,		false,		"",		true);
					InitDataProperty(0, cnt++, dtHidden,		 80,	daRight ,  true,	sheetNo+"vat_dtl_amt",			false,			"",		dfFloat,		2,	    false,		false,		17);
  			}else{
  					InitDataProperty(0, cnt++, dtCheckBox,		 45,	daCenter,  true,	sheetNo+"vat_dtl_chk",			false,			"",		dfNone,			0,	    true ,		true,		 1,		false,		false,		"",		true);
					InitDataProperty(0, cnt++, dtData,			 80,	daRight ,  true,	sheetNo+"vat_dtl_amt",			false,			"",		dfFloat,		2,	    false,		false,		17);
  			}
  			        InitDataProperty(0, cnt++, dtHidden,      	 10,    daCenter,  true,    sheetNo+"inv_iss_ofc_cd",     	false,          "",     dfNone,    		0,     	true,       true);
  			        InitDataProperty(0, cnt++, dtHidden,      	 50,    daCenter,  true,    sheetNo+"n3pty_tp_cd",          false,          "",     dfNone,    		0,     	false,      false);
  					InitDataCombo (0, sheetNo+"n3pty_cntr_wgt_ut_cd", combo01Text, combo01Code); //uom

  					ImageList(0) = "/hanjin/img/alps/button/btns_calendar.gif";
  					PopupButtonImage(0, sheetNo+"lst_free_dt") = 0; //last_free_dt
  					PopupButtonImage(0, sheetNo+"pkup_dt") = 0; //pick_up_dt
  					PopupButtonImage(0, sheetNo+"occr_dt") = 0; //occur_dt
  					PopupButtonImage(0, sheetNo+"damage_dt") = 0; //damage_dt


  				}
  			}else{
  				//break;
  			//case 2:	  //IBSheet2 init

  				with (sheetObj) {
  					var cnt = 0;
  					//전체 너비 설정
  					style.height = 120;
  										
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;

  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;

  				   //전체Edit 허용 여부 [선택, Default false]
  					Editable = false;

  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 9, 100);

  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(63, 0, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, false, true, true, false, false)

  					var HeadTitle = "Del.|STS|Seq.|Invoice No|TPB No.|Billing Case|Billing Case Name|EQ Type|EQ No.|TP/SZ|BKG No.|B/L No.|Load ID|MG Set No.|VVD|Location|Terminal Name|ATD|Account Name|Account Code|Route|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|New EQ No.|New Seal No.|OTS AMT|for Invoice||||||||||||||||||||||VAT|VAT AMT||Rtype";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					sheetNo = "";

  					//데이터속성    [ ROW, COL,   DATATYPE,   	  WIDTH, 	DATAALIGN, COLMERGE,SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtCheckBox,       30,    daCenter,  true,    sheetNo+"delChkBox", 			false,			"",		dfNone,			0,		false);
  					InitDataProperty(0, cnt++, dtStatus,      	 30,    daCenter,  true,    sheetNo+"ibflag");
  					InitDataProperty(0, cnt++, dtSeq,      		 30,    daCenter,  true,    sheetNo+"seq");
  					InitDataProperty(0, cnt++, dtData,     		 80,    daCenter,  true,    sheetNo+"n3pty_inv_no",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"n3pty_no",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 80,    daCenter,  true,    sheetNo+"n3pty_bil_tp_cd",      false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,      	120,    daCenter,  true,    sheetNo+"n3pty_bil_tp_nm",      false,          "",     dfNone,    		0,     	true,       true);
  					
  					InitDataProperty(0, cnt++, dtData,     		 80,    daCenter,  true,    sheetNo+"eq_knd_nm",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 40,    daCenter,  true,    sheetNo+"eq_no",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 80,    daCenter,  true,    sheetNo+"eq_tpsz_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"bkg_no_all",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,     	 70,    daCenter,  true,    sheetNo+"bl_no_all",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     	     70,    daCenter,  true,    sheetNo+"lod_id",        	    false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"vvd",        			false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	 70,    daCenter,  true,    sheetNo+"vvd_cd",        		false,          "",     dfNone,    		0,     	false,       false); // Added By Kim Jin-seung In 2007-08-13

  					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"mgset_no",        		false,          "",     dfNone,    		0,     	true,       true);

  					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"yd_cd",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		210,    daLeft,    true,    sheetNo+"yd_nm",        		false,          "",     dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"atd",        			false,          "",     dfTimeHms,    	0,      true ,      true);
					InitDataProperty(0, cnt++, dtCombo,     	210,    daLeft,    true,    sheetNo+"acct_cd",        		false,          "",     dfNone,    		0,      true,       true);
					InitDataProperty(0, cnt++, dtHidden,     	210,    daLeft,    true,    sheetNo+"acct_cd_org",        	false,          "",     dfNone,    		0,      true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"route",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"new_eq_no",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"new_cntr_seal_no",     false,          "",     dfNone,    		0,     	true,       true);

  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"cita_no",        		false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"cntr_wgt",        		false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"n3pty_cntr_wgt_ut_cd", false,          "",     dfInteger,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"wt_hrs",        		false,          "",     dfInteger,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"occr_dt",        		false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,     	 60,    daRight ,  true,    sheetNo+"new_vsl_cd",        	false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"new_bkg_no",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"damage_dt",        	false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,     	 60,    daRight ,  true,    sheetNo+"repair_location",      false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"lst_free_dt",        	false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"pkup_dt",        		false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"ft_ovr_dys",        	false,          "",     dfInteger,   	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"csr_no",        		false,          "",     dfNone,    		0,     	false,       false); // Added By Kim Jin-seung In 2007-08-13
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"gl_dt",        		false,          "",     dfNone,    		0,     	false,       false); // Added By Kim Jin-seung In 2007-08-13

  					InitDataProperty(0, cnt++, dtData,     		 80,    daRight ,  true,    sheetNo+"ots_amt",        		false,          "",     dfFloat,    	2,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daRight ,  true,    sheetNo+"inv_dtl_add_amt",     	false,          "",     dfFloat,    	2,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daRight ,  true,    sheetNo+"inv_dtl_amt",        	false,          "",     dfFloat,    	2,     	true,       true);

  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"eq_knd_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"fm_nod_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"via_nod_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"to_nod_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"dor_nod_cd",        	false,          "",     dfNone,    		0,     	true,       true);

  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"bkg_no",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"bkg_no_split",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"bl_no",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"bl_no_tp",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"bl_no_chk",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"vsl_cd",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"skd_voy_no",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"skd_dir_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"estm_svr_id",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"n3pty_inv_dtl_seq",    false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"original_inv_dtl_amt", false,          "",     dfFloat,    	2,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"so_if_seq",        	false,          "",     dfInteger,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"ots_dtl_seq",        	false,          "",     dfNone,    		0,     	true,       true);
  				  // 2015.08.22 조직변경 PKGBB -- > PKGSC
  				  if(document.form.s_ofc_cd.value == "PKGSC"){	
  					InitDataProperty(0, cnt++, dtHidden,		 45,	daCenter,  true,	sheetNo+"vat_dtl_chk",			false,			"",		dfNone,			0,	    true ,		true,		 1,		false,		false,		"",		true);
					InitDataProperty(0, cnt++, dtHidden,		 80,	daRight ,  true,	sheetNo+"vat_dtl_amt",			false,			"",		dfFloat,		2,	    false,		false,		17);
  				  }else{
   					InitDataProperty(0, cnt++, dtCheckBox,		 45,	daCenter,  true,	sheetNo+"vat_dtl_chk",			false,			"",		dfNone,			0,	    true ,		true,		 1,		false,		false,		"",		true);
					InitDataProperty(0, cnt++, dtData,			 80,	daRight ,  true,	sheetNo+"vat_dtl_amt",			false,			"",		dfFloat,		2,	    false,		false,		17);
  				  }
  				    InitDataProperty(0, cnt++, dtHidden,      	 10,    daCenter,  true,    sheetNo+"inv_iss_ofc_cd",     	false,          "",     dfNone,    		0,     	true,       true);
  				    InitDataProperty(0, cnt++, dtHidden,      	 50,    daCenter,  true,    sheetNo+"n3pty_tp_cd",          false,          "",     dfNone,    		0,     	false,      false);
  				}
  				//break;
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
  			
//  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
			  	case "btn_new":
		  		    location.href = "ESD_TPB_0111.do?pgmNo=ESD_TPB_0111";
  					break;
  				case "bttn_add":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_save":
  				    var tot_amt = ComGetUnMaskedValue(document.form.s_total_amt.value,"float");
  				     
  				    /* 2009-03-13 O Wan-Ki 저장할 수 있는 지(Due Date 나 금액의 변동이 있었는가) 확인 */
  				    if( !isSaveable() ){ 
  				    	ComShowCodeMessage("TPB90091");
  				    	return;
  				    } 
  				     
  				    if ( tot_amt < 0.00 ) {
                        ComShowCodeMessage('TPB90033','Total Amount','0.00');
  				    } else {
        				doActionIBSheet(sheetObject,formObject,IBSAVE);
  				    }
  					break;
  				case "bttn_remove":
  					break;
  				case "btn_preview":
                    if ( s_clt_agn_flg == "Y" ) {
                        document.all.btn_preview_t.disabled = true; 
                    } else {
                        document.all.btn_preview_t.disabled = false; 
                    }
                      
  					if(document.all.btn_preview_t.disabled){
  						ComShowCodeMessage("TPB90009","","","");
  						return;
  				    }
  					if(formObject.s_n3pty_inv_no.value == ''){
  						ComShowCodeMessage("COM12151","Invoice","","");
  						return;
  					}
  					
//  					formObject.target = "_self";
//  					formObject.method = "post";
//  					formObject.f_cmd.value = SEARCH;
//  					formObject.action = "ESD_TPB_0112.do?pgmNo=ESD_TPB_0112";
//  					formObject.submit();

  					//sheetObject.ExcelPrint = "PreView";
  					//doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					var edi_snd_flg ="Y";
  				     // MS Load ID
  					for(var i=0;i<sheetObjects.length-1;i++){
					if ( formObject.s_trd_party_val.value == "US071995"  ){
					     for(var j=1;j<=sheetObjects[i].RowCount;j++){
					    	if( sheetObjects[i].CellValue(j, "lod_id") == "" ){
						   	    	edi_snd_flg ="N";
						   	   }
					         }
					      }
				      }
  					if (edi_snd_flg =="N"){
  						if(!ComShowCodeConfirm('TPB90115')){
  							ComShowCodeMessage("TPB90116", "BKG Container P/O & Other No :Load ID");
  							return;
  						}
  					}

					// 2010-03-17 Sun, CHOI 1.9 TPB Invoice Preview POPUP 으로 변경
					var s_dao_n3pty_bil_tp_cd = formObject.s_dao_n3pty_bil_tp_cd.value;
					var s_n3pty_inv_no = formObject.s_n3pty_inv_no.value;
					var s_n3pty_inv_his_seq = formObject.s_n3pty_inv_his_seq.value;
					var s_n3pty_inv_rmd_cd = formObject.s_n3pty_inv_rmd_cd.value;
//					var s_lnk_n3pty_inv_no = formObject.s_lnk_n3pty_inv_no.value;
					var s_final_flg = formObject.s_final_flg.value;
					var s_trd_party_val = formObject.s_trd_party_val.value;
					if (edi_snd_flg == "N"){
						s_trd_party_val = "";
					}
					openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd, s_final_flg, s_trd_party_val );

  					break;
  				case "bttn_excel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  					sheetObject.ExcelPrint = "PrintOnly";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_search":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btns_calendar":
  					var cal = new ComCalendar();
  					 cal.select(formObject.s_rcv_due_dt, 'yyyy-MM-dd');
  					break;
  				case "btn_alertConfirm":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_collectionactivity":
  					if( formObject.s_n3pty_no.value.length == 14 ){
  						openRecoveryActPopup(formObject.s_n3pty_no.value,formObject.s_n3pty_inv_no.value,'','N');
  					}else{
  						ComShowMessage('Input valid TPB No.');
  					}
  					break;
  				case "btn_settlement":
  					var ots = formObject.s_detail_ots_sts_cd.value;
  					var otsArr = ots.split("|");
  					for(var i=0;i<otsArr.length;i++){
  						if(otsArr[i] != 'O' && otsArr[i] != 'J' && otsArr[i] != 'L' && otsArr[i] != 'M'){
  							ComShowCodeMessage('TPB90056','','','');
  							return;
  						}
  					}
  					
  					location.href = "ESD_TPB_0015.do?n3pty_no="+formObject.s_detail_n3pty_no.value+"&f_cmd="+SEARCH;
  					break;
  				case "btn_caremarks":
  					if(document.all.btn_caremarks_t.disabled) return;

  					var s_clt_agn_rmk = document.all.s_clt_agn_rmk.value;
  					var theURL = "ESD_TPB_0803.do?s_clt_agn_rmk="+s_clt_agn_rmk;
  					var winName = "ESD_TPB_0803";
  					var features = "scroll:no;status:no;help:no;dialogWidth:405px;dialogHeight:330px";
  					var rtnValue = window.showModalDialog(theURL, window, features);
  		  		    
  	  		    	if(rtnValue != undefined && rtnValue != null ){
  	  		    		document.all.s_clt_agn_rmk.value = rtnValue;
  	  		    	}
  	  		    	
  					break;
  				case "btn_cancel":
  					if( !document.all.btn_cancel_t.disabled ){
                        var reasonCheckResult = openInvoiceCancelRemarkPopup();
          				if ( reasonCheckResult) {
  							formObject.f_cmd.value = REMOVE;
  							sheetObjects[sheetObjects.length-1].DoSave("ESD_TPB_0111GS.do", tpbFrmQryStr(formObject), 3, false);
          				}

  					}else{
  						ComShowCodeMessage('TPB90021','','','');
  						return;
  					}
  					
  					break;
  				case "btn_erpInterface":
  					if( ComShowConfirm(ComGetMsg("TPB90008","","","")) ){	
  						doActionIBSheet(sheetObject,formObject,ADD);
  					}
  					break;
  				case "btn_3rdParty": /// In 2008-06-04
  					get3rdParty( document.all.s_vndr_cust_div_cd.value );
  					break;
  				case "btn_retrieve": 
  				    doActionIBSheet(sheetObject,formObject,COMMAND01);
  				    break;
  				case "btn_close":
					 window.returnValue = "Y";
					 window.close();
				    break;    

  			} // end switch
//  		}catch(e) {			
//  			if( e == "[object Error]") {
//  				ComShowMessage(getMsg('COM12111'));
//  			} else {
//  				ComShowMessage(e);
//  			}
//  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  		   case IBSEARCH:	  //조회
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				//hidden sheet로 조회
  				formObj.f_cmd.value = SEARCH;
  				var x = sheetObj.GetSearchXml("ESD_TPB_0111GS.do", tpbFrmQryStr(formObj));

  				sheetObj.LoadSearchXml(x);
  				

  				//hidden sheet에 load된 데이터를 billing case 종류별로 분리해서 sheet를 display한다.
  				var bilArr = tpb_getBillingCase(document.all.sheet0);	//Billing case 배열
  				
  				tpb_makeTabLoad(formObj, sheetObjects, bilArr[0], x);
  				
  				//n3pty_bil_tp_cd 를 ',' 로 구분하여 문자열로 저장한다.
  				formObj.s_dao_n3pty_bil_tp_cd.value = bilArr[1].join("','");
  				//lert("formObj.s_dao_n3pty_bil_tp_cd.value:::"+formObj.s_dao_n3pty_bil_tp_cd.value);
  				//초기 화면 로딩시 currency 값
  				if(document.form.s_from_curr_cd.value == ""){
  					document.form.s_from_curr_cd.value = document.form.s_curr_cd.value;
  					lastSelectedCurrency = document.form.s_curr_cd.value; // select currency <select>, save last value // Added By Kim Jin-seung in 2007-05-14
  				}else{
  					//currency 변경했을 경우
  					if(document.form.s_from_curr_cd.value != ""){
  						for(var i=0;i<sheetObjects.length-1;i++){
  							for(var j=1;j<=sheetObjects[i].RowCount;j++){
  								sheetObjects[i].RowStatus(j) = "U";
  							}
  						}
  					}
  				}
  				var iss_ofc = sheetObj.CellValue(1, "inv_iss_ofc_cd");
  				document.form.inv_iss_ofc_cd.value = iss_ofc;

  				document.form.gst_amt.value = document.form.s_vat_amt.value ;
  				amtReCalculate();
  				if( document.form.cnt_cd.value == "IN" ){	
  	    			calculateForIndiaInvoice();
  	    		}

  				// 2015.08.22 조직변경 PKGBB--> PKGSC
  				if (iss_ofc == "PKGSC"){ 
  				   calculateGst() ;
  				}
  				//	only Administration Charge 
				tmpBilTpCds =formObj.s_dao_n3pty_bil_tp_cd.value;
				var tmpBilTpCdsArray = tmpBilTpCds.split("','");
				for(k=0;k < tmpBilTpCdsArray.length;k++ ){
					if(tmpBilTpCdsArray[k] == "V1" || tmpBilTpCdsArray[k] == "V2" || tmpBilTpCdsArray[k] == "V3" || tmpBilTpCdsArray[k] == "V4" ){
						document.form.s_add_amt.disabled = true;
						document.form.s_ddct_amt.disabled = true;
						invDtlAddamtReCalculate();
		    			tpb_otherAmountReCalculate(this);
		    			if( document.form.cnt_cd.value == "IN" ){	
		  	    			calculateForIndiaInvoice();
		  	    		}
						break;
					}
				}
  				break;
  				
	  		 case SEARCH02:	  //Account Code, Name Combo
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("ESD_TPB_0111GS.do", tpbFrmQryStr(formObj));
				var arrCombo = ComXml2ComboString(sXml, "name", "val") ;
				
				//Sheet의 Account 항목 Combo 생성 및 Combo 생성 버그 해결을 위한 편법
				for( var idx = 0; idx < sheetObjects.length-1; idx++ ){
					sheetObjects[idx].InitDataCombo(0, "acct_cd", arrCombo[1], arrCombo[0]);
					
					for( var jdx = sheetObjects[idx].HeaderRows; jdx <= sheetObjects[idx].LastRow; jdx++ ){
						sheetObjects[idx].CellValue2(jdx, "acct_cd") = sheetObjects[idx].CellValue(jdx, "acct_cd_org");
					}
				}
				break;
				
  			case IBSAVE:		//저장
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}

  				if(formObj.s_curr_cd.value == ""){
  					ComShowCodeMessage("COM12113","Currency","","");
  					return false;
  				}

  				//KRW,JPY,VND 의 Total Amt는 정수이어야 함.
  				//* 2009-03-16 O Wan-Ki 1.3 KRW,JPY,VND 의 Amount 는 정수로 보완.
  				if( (formObj.s_curr_cd.value == "KRW" || formObj.s_curr_cd.value == "JPY" || formObj.s_curr_cd.value == "VND") ){
  					var totAmt = ComGetUnMaskedValue(formObj.s_total_amt.value,"float");
					var addAmt = ComGetUnMaskedValue(formObj.s_add_amt.value,"float");
					var ddctAmt = ComGetUnMaskedValue(formObj.s_ddct_amt.value,"float");
  					if(parseFloat(addAmt) - parseInt(addAmt) > 0){
  						ComShowCodeMessage("TPB90093");
  						return false;
  					}
  					if(parseFloat(ddctAmt) - parseInt(ddctAmt) > 0){
  						ComShowCodeMessage("TPB90094");
  						return false;
  					}
  					if(parseFloat(totAmt) - parseInt(totAmt) > 0){
  						ComShowCodeMessage("TPB90024","","","");
  						return false;
  					}
  				}
                  var msg = ComGetMsg("TPB90054"); 
                  if ( formObj.s_n3pty_inv_sts_cd.value=="A"){
                      msg += "\n\n" + ComGetMsg("TPB90057"); 
                  }

  				if( ComShowConfirm(ComGetMsg("TPB90054"))){	
  					var s_h_vndr_cust_div_cd = formObj.s_h_vndr_cust_div_cd.value;
  					var s_trd_party_code = formObj.s_trd_party_code.value;

                      /// on save... add
  					for(var i=0;i<sheetObjects.length-1;i++){
  						for(var j=1;j<=sheetObjects[i].RowCount;j++){
  							sheetObjects[i].RowStatus(j) = "U";
  						}
  					}

  					//모든 Sheet의 SaveString과 Invoice Amount 총합 구하기
  					var sum_save_string = "";
//  					var sum_inv_amt = 0;
  					for(var i=0;i<sheetObjects.length-1;i++){
//  						for(var j=1;j<=sheetObjects[i].RowCount;j++){
//  							var tmp_ots_amt = parseFloat(sheetObjects[i].CellValue(j, "ots_amt")); //ots_amt // be careful 
//  							var tmp_inv_dtl_amt = parseFloat(sheetObjects[i].CellValue(j, "inv_dtl_amt")); //inv_dtl_amt // be careful 
//  							sum_inv_amt += tmp_inv_dtl_amt;
//  						}
  						sum_save_string += sheetObjects[i].GetSaveString();
  						sum_save_string += "&";
  						
 						// MS Load ID
						if ( formObj.s_trd_party_val.value == "US071995"  ){
						     for(var j=1;j<=sheetObjects[i].RowCount;j++){
						    	if( sheetObjects[i].CellValue(j, "lod_id") == "" ){
						    		var bkg_no  = sheetObjects[i].CellValue(j, "bkg_no_all");
						    		var cntr_no  = sheetObjects[i].CellValue(j, "eq_no");
						    		ComShowCodeMessage("COM130404", "Load ID" , "Load ID \n or register it at BKG Container P/O & Other No Pop up first.\n( BKG No : "+bkg_no+",  EQ No : "+cntr_no+" )");
						    		return;
						         }
						      }
					      }
  					}

  					//* 2009-06-09 O Wan-Ki 1.5 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
  					if( document.form.cnt_cd.value == "IN" ){
	  					formObj.s_sum_inv_amt.value = ComGetUnMaskedValue(document.form.lst_invoice_total.value,"float");
					}else{
						formObj.s_sum_inv_amt.value = ComGetUnMaskedValue(document.form.s_total_amt.value,"float");
					}

                      // TOTAL INVOICE AMOUNT CHECK -----  
  					var sum_inv_amt = formObj.s_sum_inv_amt.value;
  					try {
  					    sum_inv_amt = sum_inv_amt - 0.00;
  					} catch (e){
  					    ComShowCodeMessage('COM12111');
  					    return;
  					}
  					
  					if ( sum_inv_amt <= 0.0 ){
  					    ComShowCodeMessage('TPB90035', 'Total Amount ', '0.00 ');
  					    return;
  					}

  					//* 2009-06-29 O Wan-Ki 1.5 S1V-09P-001, tax 전송부분 보완
  					if( document.form.cnt_cd.value == 'IN'){
  						if (document.form.lst_tax.value.length != 0 ){
  							document.form.s_vat_amt.value = ComGetUnMaskedValue(document.form.lst_tax.value,"float") ;
  						}
  						if (document.form.tot_locl_tax.value.length != 0 ){
							document.form.s_locl_tax_amt.value = ComGetUnMaskedValue(document.form.tot_locl_tax.value,"float") ;
						}
  						if (document.form.n2nd_locl_tax.value.length != 0 ){
							document.form.s_n2nd_locl_tax_amt.value = ComGetUnMaskedValue(document.form.n2nd_locl_tax.value,"float") ;
						}
  					}
  					
  					document.form.s_net_amt.value = ComGetUnMaskedValue(document.form.s_net_amt.value,"float") ;
  					
  					formObj.f_cmd.value = MULTI;

  					var sXml = sheetObjects[sheetObjects.length-1].GetSaveXml("ESD_TPB_0111GS.do", sum_save_string + tpbFrmQryStr(formObj));
  					//ComShowMessage(sXml);
  					sheetObjects[sheetObjects.length-1].LoadSaveXml(sXml);
  				}
  				break;
  				
  			case ADD: //ERP I/F
  				formObj.f_cmd.value = ADD;
  				div_processing_show(); // show processing image
  				var sXml = sheetObjects[sheetObjects.length-1].GetSaveXml("ESD_TPB_0111GS.do", tpbFrmQryStr(formObj));
  				//ComShowMessage(sXml);
  				sheetObjects[sheetObjects.length-1].LoadSaveXml(sXml);
  				div_processing_hide(); // hide processing image

  				var s_cnt_cd = document.form.s_cnt_cd.value;
  				
  		  		if (s_cnt_cd == 'IN') {
	  				var ttl_amt = minusFloat(addFloat(v("s_net_amt"),v("s_add_amt")),v("s_ddct_amt"));
	  				formObj.s_total_amt.value = ComAddComma2(ttl_amt+"","#,###.00",",","");
  		  		} else {
  		  			formObj.s_vat_amt.value = ComAddComma2(sheetObj.EtcData("s_vat_amt")+"","#,###.00");
  		  			formObj.s_total_amt.value = ComAddComma2(sheetObj.EtcData("s_total_amt")+"","#,###.00");
  		  		}
  				
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
  		   case COMMAND01:	  //조회
                var tpb_no = document.all.s_n3pty_no.value;
                var tpb_inv_no = document.all.s_n3pty_inv_no.value;
                  
                if ( tpb_no.length == 0 && tpb_inv_no.length == 0 ){
                    ComShowCodeMessage("TPB90064");
                    document.all.s_n3pty_no.focus();
                    return; 
                }

  				//hidden sheet로 조회
  				formObj.f_cmd.value = SEARCHLIST;
  				var sXml = sheetObjects[sheetObjects.length-1].GetSaveXml("ESD_TPB_0111GS.do", tpbFrmQryStr(formObj));
  				//ComShowMessage(sXml);
  				sheetObjects[sheetObjects.length-1].LoadSearchXml(sXml);
  				
          		//IBS_EtcDataToForm2(formObj, sheetObj);
  		
                var n3pty_no = sheetObj.EtcData("s_detail_n3pty_no");
                var tmp_n3pty_no = sheetObj.EtcData("s_n3pty_no");
	            var tmp_n3pty_inv_no = sheetObj.EtcData("s_n3pty_inv_no");
	            var tmp_n3pty_inv_rmd_cd = sheetObj.EtcData("s_n3pty_inv_rmd_cd");
	            var tmp_n3pty_inv_his_seq = sheetObj.EtcData("s_n3pty_inv_his_seq");
	            var tmp_h_vndr_cust_div_cd = sheetObj.EtcData("s_h_vndr_cust_div_cd");
	            var tmp_trd_party_code = sheetObj.EtcData("s_trd_party_code");
	            var tmp_revise_able = sheetObj.EtcData("s_revise_able");
	            var tmp_ida_tax_seq = sheetObj.EtcData("s_ida_tax_seq");//2009-06-09 O Wan-Ki 1.5
	            var tmp_clt_agm_rmk = sheetObj.EtcData("s_clt_agn_rmk");

	            if ( tmp_n3pty_inv_rmd_cd==undefined || tmp_n3pty_inv_rmd_cd==null ) { 
	                ComShowCodeMessage("TPB90095");
	                return;
	            }
	            if ( n3pty_no==undefined || n3pty_no==null ) { n3pty_no = ""; }
	            if ( tmp_n3pty_no==undefined || tmp_n3pty_no==null ) { tmp_n3pty_no = ""; }
	            if ( tmp_n3pty_inv_no==undefined || tmp_n3pty_inv_no==null ) { tmp_n3pty_inv_no = ""; }
	            if ( tmp_n3pty_inv_rmd_cd==undefined || tmp_n3pty_inv_rmd_cd==null ) { tmp_n3pty_inv_rmd_cd = ""; }
	            if ( tmp_n3pty_inv_his_seq==undefined || tmp_n3pty_inv_his_seq==null ) { tmp_n3pty_inv_his_seq = ""; }
	            if ( tmp_h_vndr_cust_div_cd==undefined || tmp_h_vndr_cust_div_cd==null ) { tmp_h_vndr_cust_div_cd = ""; }
	            if ( tmp_trd_party_code==undefined || tmp_trd_party_code==null ) { tmp_trd_party_code = ""; }
	            if ( tmp_revise_able==undefined || tmp_revise_able==null ) { tmp_revise_able = ""; }
	            if ( tmp_ida_tax_seq==undefined || tmp_ida_tax_seq==null ) { tmp_ida_tax_seq = ""; }//2009-06-09 O Wan-Ki 1.5
	            if ( tmp_clt_agm_rmk==undefined || tmp_clt_agm_rmk==null ) { tmp_clt_agm_rmk = ""; }
	
	            formObj.s_detail_n3pty_no.value = n3pty_no;
	            formObj.s_n3pty_no.value = tmp_n3pty_no;
	            formObj.s_n3pty_inv_no.value = tmp_n3pty_inv_no;
	            formObj.s_n3pty_inv_rmd_cd.value = tmp_n3pty_inv_rmd_cd;
	            formObj.s_n3pty_inv_his_seq.value = tmp_n3pty_inv_his_seq;
	            formObj.s_h_vndr_cust_div_cd.value = tmp_h_vndr_cust_div_cd;
	            formObj.s_trd_party_code.value = tmp_trd_party_code;
	            formObj.s_correction_yn.value = tmp_revise_able;
	            formObj.s_inquiryOnly_yn.value = tmp_revise_able=="Y"?"N":"Y";
	            formObj.s_ida_tax_seq.value = tmp_ida_tax_seq;//2009-06-09 O Wan-Ki 1.5
	            formObj.s_clt_agn_rmk.value = tmp_clt_agm_rmk;

      			document.form.f_cmd.value = IBSEARCH;
      			document.form.method = "post";
      			document.form.action = "ESD_TPB_0111.do?pgmNo=ESD_TPB_0111";
      			document.form.submit();
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
  			//if (!isNumber(formObj.iPage)) {
  			//	return false;
  		   // }
  		}
  		
  		return true;
  	}
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet0_OnSearchEnd(sheetObj,errMsg){
  		
  		ComEtcDataToForm(document.form, sheetObj);
  		
  		s_clt_agn_flg = sheetObj.EtcData("s_clt_agn_flg");
  		var s_n3pty_inv_sts_cd = sheetObj.EtcData("s_n3pty_inv_sts_cd");
  		var s_n3pty_inv_rmd_yn = sheetObj.EtcData("s_n3pty_inv_rmd_yn");
  		var s_final_flg = sheetObj.EtcData("s_final_flg");
  		var s_lnk_n3pty_inv_no = sheetObj.EtcData("s_lnk_n3pty_inv_no");
  		var erpif_yn = sheetObj.EtcData("erpif_yn");
  		document.all.prcs_cnt.value = sheetObj.EtcData("s_prcs_cnt");
  		var tp_cd =  sheetObj.CellValue(1, "n3pty_tp_cd");
  		var usr_id = document.all.usr_id.value;
  		if ( usr_id == "21702010" || usr_id == "21702004" || usr_id == "0660011" ){
			 document.all.s_inquiryOnly_yn.value="N" ; 
		}

  		//Collection Agency cd
  		if(s_clt_agn_flg != undefined){
  			if(s_clt_agn_flg == "Y"){
  				document.form.s_clt_agn_flg.checked = true;
                  document.all.btn_preview_t.disabled = true;
  			} else {
  				document.form.s_clt_agn_flg.checked = false;
  			}
  		}
  		//A/R interface
  		if(s_n3pty_inv_sts_cd != undefined && s_n3pty_inv_sts_cd != "N"){
   			document.all.btn_save_t.disabled = false;
  			document.all.btn_cancel_t.disabled = false;
  		}
  		// ERP I/F BTN
  		var s_inquiryOnly_yn = document.all.s_inquiryOnly_yn.value; 

  		if ( s_inquiryOnly_yn == "Y" ){
  		    document.all.btn_erpInterface_t.disabled = true;
  			document.all.btn_erpInterface_t.style.display = 'none';
  		} else if ( erpif_yn != undefined && erpif_yn == "Y"){
  		    document.all.btn_erpInterface_t.disabled = false;
  			document.all.btn_erpInterface_t.style.display = '';
  		} else {
  		    document.all.btn_erpInterface_t.disabled = true;
  			document.all.btn_erpInterface_t.style.display = 'none';
  		}
  		
  		var s_vat_amt = document.form.s_vat_amt.value;
  		if(s_vat_amt != "" && parseFloat(s_vat_amt) > 0){
  			document.form.s_vat_xch_rt_chk.checked = true;
  			document.form.s_vat_xch_rt.value = sheetObj.EtcData("s_vat_xch_rt_original");
  		}else{
  			document.form.s_vat_xch_rt_chk.checked = false;
  			document.form.s_vat_xch_rt.value = sheetObj.EtcData("s_vat_xch_rt_original");
  		}
  		
  		//VAT 금액 format
  		document.form.s_net_amt.value = ComAddComma2(document.form.s_net_amt.value,"#,###.00");
  		document.form.s_add_amt.value = ComAddComma2(document.form.s_add_amt.value,"#,###.00");
  		document.form.s_ddct_amt.value = ComAddComma2(document.form.s_ddct_amt.value,"#,###.00");
  		document.form.s_vat_amt.value = ComAddComma2(s_vat_amt,"#,###.00");
  		document.form.s_total_amt.value = addFloat(document.form.s_total_amt.value,0);
  		document.form.org_clt_agn_flg.value = document.form.s_clt_agn_flg.checked;
  		
  		var s_cnt_cd = document.form.s_cnt_cd.value;
  		var s_ida_tax_seq = document.form.s_ida_tax_seq.value;

  		if( s_cnt_cd == 'IN' ){
  			calculateForIndiaInvoice();
//  			//2015-11-12 India SBC Tax 추가
//  			//document.form.tot_tax.value = addFloat(v("tot_svc_tax"),v("tot_locl_tax"));
//  			document.form.tot_tax.value = addFloat(addFloat(v("tot_svc_tax"),v("tot_locl_tax")),v("n2nd_locl_tax")) ;
//  			//document.form.lst_invoice_total.value = addFloat(v("s_total_amt"),v("tot_svc_tax"));
//  			document.form.lst_invoice_total.value = addFloat(v("s_total_amt"),v("tot_tax"));
 		}

  	}
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet0_OnSaveEnd(sheetObj,errMsg){

  		if(errMsg==null || errMsg == ''){
  		    
  			if(document.form.f_cmd.value == REMOVE){
  				ComShowCodeMessage('TPB90059');
//  				document.form.method = "post";
//  				document.form.f_cmd.value = "";
//  				document.form.action = "ESD_TPB_0106.do?pgmNo=ESD_TPB_0106";
//  				document.form.submit();
				// window.returnValue = "Y";
				// window.close();
  				return;
  				
  			} else if(document.form.f_cmd.value == MULTI){

  				ComShowCodeMessage('COM12149','Invoice','','');
      			document.all.btn_save_t.style.display = 'none'; 
      			document.all.btn_cancel_t.style.display = 'none'; 
      
      			//Detail이 모두 delete 되면 Header 테이블도 delete 된다.
      			var hdr_del_result = sheetObj.EtcData("hdr_del_result");
      			// ComShowMessage(hdr_del_result);
      
      			if( hdr_del_result == "HDR_DELETE"){
      				//document.form.action = "ESD_TPB_0106.do?sysCommUiTitle=Invoice Revision - Main&sysCommUiNavigation=Service Delivery > 3rd Party Billing > Invoice Management";
//      				document.form.action = "ESD_TPB_0106.do?pgmNo=ESD_TPB_0106";
//      				document.form.submit();
        			document.all.btn_save_t.style.display = 'none'; 
          			document.all.btn_cancel_t.style.display = 'none';
      				
      				return;
      			} else if( hdr_del_result.substring(0,1) == "R"){ // Rxx
      			    document.form.s_n3pty_inv_rmd_cd.value = hdr_del_result;
      			    document.form.s_n3pty_inv_his_seq.value = (parseInt(document.form.s_n3pty_inv_his_seq.value) + 2).toString();
      			    document.form.s_his_seq.value = document.form.s_n3pty_inv_his_seq.value;
      			}
      			
                  isSaveEnd = true;

      			//초기 currency 변수 초기화
      			document.form.s_from_curr_cd.value = "";
      			document.all.btn_save_t.style.display = 'none'; 
      			document.all.btn_cancel_t.style.display = 'none'; 
      			
  			} else if(document.form.f_cmd.value == ADD){
  			    
  				ComShowCodeMessage('COM12149','ERP Interface','','');
      			document.all.btn_erpInterface_t.style.display = 'none';
      			
  			}
  			
  		} else {
  		    ComShowMessage(errMsg);
  		}
  		
  		document.form.s_h_vndr_cust_div_cd.value = document.form.s_vndr_cust_div_cd.value; /// Added By Kim Jin-seung In 2008-06-04
  		
  		if(document.form.f_cmd.value != ADD){
	  		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH);
  		}
  	}

  	//Tab 데이터를 load 한다.
  	function tpb_makeTabLoad(formObj, sheetObjects, bilArr, x){
  		for(var i=0;i<sheetObjects.length-1;i++){
  			//TAB title 세팅
  			if( bilArr[i] == undefined ){
  			//	document.getElementById("tabSheet"+(i+1)).style.display = "none";
  			//	continue;
  			}
  			//document.getElementById("tab_title"+(i+1)).innerHTML = bilArr[i];
  			var title = bilArr[i];
  			if(formObj.load_num.value == "0"){
				tabObjects[i].InsertTab(-1, title, true);
			}
  			//Data load/
  			sheetObjects[i].LoadSearchXml(x);
  			//TAB 별로 n3pty_bil_tp_cd 다른 것은 삭제
  			for(var j=1;j<=sheetObjects[i].RowCount;j++){
  				if(sheetObjects[i].CellValue(j, "n3pty_bil_tp_nm") != bilArr[i]){   //n3pty_bil_tp_nm // be careful 
  					sheetObjects[i].RowDelete(j, false);
  					--j;
  				}
  				if(j != 0 ) {
  					sheetObjects[i].CellValue(j, "seq") = j;   //seq // be careful 
  					sheetObjects[i].RowStatus(j) = "R";
  				}
  				sheetObjects[i].TotalRows = j; //Row갯수를 다시 세팅한다.

  				//Outstanding Amount 의 Auto Upate check
  				tpb_chgColor_ots_amt(sheetObjects[i], 49, 30, j); // be careful 

  				sheetObjects[i].Visible = true;
  			}
  			//Billing Case Code에 따라 다른 폼을 적용시킨다.
  			tpb_setSheetByBillingCase(sheetObjects[i], sheetObjects[i].CellValue(1, "n3pty_bil_tp_cd"), i+1);  //n3pty_bil_tp_cd // be careful
  		}
  		formObj.load_num.value = "1";
  		
  	}

  	//Billing case 중복 제거된 배열 구한다.
  	function tpb_getBillingCase(sheetObject){
  		var bilArrNm = new Array(); //Billing case Name 배열
  		var bilArrCd = new Array(); //Billing case CD 배열
  		
  		for(var i=1;i<=sheetObject.RowCount;i++){
  			bilArrNm[bilArrNm.length] = sheetObject.CellValue(i, "n3pty_bil_tp_nm");  //n3pty_bil_tp_nm // be careful 
  			bilArrCd[bilArrCd.length] = sheetObject.CellValue(i, "n3pty_bil_tp_cd");  //n3pty_bil_tp_cd // be careful 
  		}

  		for(var i=0;i<bilArrNm.length;i++){
  			var dbl = 0;
  			for(var j=0;j<bilArrNm.length;j++){

  				if(bilArrNm[i] != bilArrNm[j]){
  					continue;
  				}else{
  					dbl++;
  					if(dbl>1){
  						bilArrNm.splice(j,1);
  						bilArrCd.splice(j,1);
  						j--;
  					}
  				}

  			}
  		}
  		return new Array(bilArrNm,bilArrCd);
  	}

  	function  tpb_chkLenByByte(obj, len, name){
  		if(!chkLenByByte(obj, len)){
  			ComShowCodeMessage("COM12142",name,len,"");
  		}
  	}

    var lastSelectedCurrency = ""; // select currency <select>, save last value // Added By Kim Jin-seung in 2007-05-14
  	function changeCurrency(val){
  		if(document.form.s_n3pty_inv_rmd_cd.value != null && document.form.s_n3pty_inv_rmd_cd.value != ""){
	  		if ( val==null || val=="" ){ // select currency <select>, save last value // Added By Kim Jin-seung in 2007-05-14
	  		    document.form.s_curr_cd.value = lastSelectedCurrency;
	  			return;
	  		}
  			doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH);
  			lastSelectedCurrency = document.form.s_curr_cd.value; // select currency <select>, save last value // Added By Kim Jin-seung in 2007-05-14
  			calculateForIndiaInvoice();
  		}
  	}
  	
  	function s_clt_agn_flg_OnChange(){ // Added By Kim Jin-seung In 2007-10-18
  	   isSaveEnd = false;
  	}

  	// show processing image 
  	function div_processing_show(){
  		document.all.div_processing.style.display = ''; 
  		// setTimeout("div_processing_hide();", 1000);
  	}
  	
  	// hide processing image 
  	function div_processing_hide(){
  		document.all.div_processing.style.display = 'none'; 
  	}	

  	//Billing Case Code에 따라 폼을 다르게 적용시킨다.
  	function tpb_setSheetByBillingCase(sheetObj, cd, idx){
  		idx = "";
  		//cd = prompt('TL/ST/DR/OW/FU/CI/RO/RH/CP/BB/FL/AW \nVD/GD/TR/CY/JO/RF/DG/SL/CC/WT/CD/ZD/CH/EE');
  		switch(cd){
  			case "TL":
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no			
  				sheetObj.ColHidden(idx+"yd_cd") = true;				//yd_cd				
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no		
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight			
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom				
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm		
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt			
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd			
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all		
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt			
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location	
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt		
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt		
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day			
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "ST":
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no			 
  				sheetObj.ColHidden(idx+"new_eq_no") = true;			//new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;		//new_cntr_seal_no
  				sheetObj.ColHidden(idx+"route") = true;				//route
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "DR":
  				sheetObj.ColHidden(idx+"yd_cd") = true;				//yd_cd
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;			//new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;		//new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "OW":
  				sheetObj.ColHidden(idx+"yd_cd") = true;				//yd_cd
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;			//new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;		//new_seal_no
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "FU":
  				sheetObj.ColHidden(idx+"route") = true;				//route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;			//new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;		//new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "CI":
  				sheetObj.ColHidden(idx+"route") = true;				//route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "RO":
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "RH":
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "CP":
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "BB":
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "FL":
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "AW":
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "VD":
  				sheetObj.ColHidden(idx+"eq_knd_nm") = true;  //eq_knd_nm
  				sheetObj.ColHidden(idx+"eq_no") = true;  //eq_no
  				sheetObj.ColHidden(idx+"eq_tpsz_cd") = true;  //eq_tpsz_cd
  				sheetObj.ColHidden(idx+"bkg_no_all") = true;  //bkg_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "GD":
  				sheetObj.ColHidden(idx+"bkg_no_all") = true;  //bkg_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"vvd") = true;  //vvd
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;  //new_vvd
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "TR":
  				sheetObj.ColHidden(idx+"yd_cd") = true;				//yd_cd
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "CY":
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "JO":
  				sheetObj.ColHidden(idx+"bkg_no_all") = true;  //bkg_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
//  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
//  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
//  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = false;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				for(var i=1;i<=sheetObj.RowCount; i++){ sheetObj.CellEditable(i, idx+"inv_dtl_amt") = false; }    // JO Case inv_dtl_amt Blocking ... Added By Kim Jin-seung In 2007-10-29
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "RF":
  				sheetObj.ColHidden(idx+"bkg_no_all") = true;  //bkg_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "DG":
  				sheetObj.ColHidden(idx+"bkg_no_all") = true;  //bkg_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "SL":
  				sheetObj.ColHidden(idx+"bkg_no_all") = true;  //bkg_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "CC":
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "WT":
  				sheetObj.ColHidden(idx+"yd_cd") = true;				//yd_cd
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "CD":
  				sheetObj.ColHidden(idx+"bkg_no_all") = true;  //bkg_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"vvd") = true;  //vvd
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;  //new_vvd
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "ZD":
  				sheetObj.ColHidden(idx+"bkg_no_all") = true;  //bkg_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;  //vvd
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "CH":
  				sheetObj.ColHidden(idx+"yd_cd") = true;				//yd_cd
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "CU":
  				sheetObj.ColHidden(idx+"yd_cd") = true;				//yd_cd
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "EE":
  				sheetObj.ColHidden(idx+"bkg_no_all") = true;  //bkg_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"bl_no_all") = true;  //bl_no_all
  				sheetObj.ColHidden(idx+"vvd") = true;  //vvd
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;  //new_vvd
  				sheetObj.ColHidden(idx+"route") = true;  //route
  				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
  				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
  				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
  				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
  				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
  				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
  				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
  				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
  				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
  				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
  				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
  				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
  				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
  				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
  				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By Kim Jin-seung In 2007-08-13
  				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
  				break;
  			case "TS":
				sheetObj.ColHidden(idx+"eq_knd_nm") = true;
				sheetObj.ColHidden(idx+"eq_no") = true;
				sheetObj.ColHidden(idx+"eq_tpsz_cd") = true;
				sheetObj.ColHidden(idx+"bkg_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"route") = true;
				sheetObj.ColHidden(idx+"mgset_no") = true;
				sheetObj.ColHidden(idx+"new_eq_no") = true;
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;
				sheetObj.ColHidden(idx+"cita_no") = true;
				sheetObj.ColHidden(idx+"cntr_wgt") = true;
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;
				sheetObj.ColHidden(idx+"wt_hrs") = true;
				sheetObj.ColHidden(idx+"occr_dt") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"new_bkg_no") = true;
				sheetObj.ColHidden(idx+"damage_dt") = true;
				sheetObj.ColHidden(idx+"repair_location") = true;
				sheetObj.ColHidden(idx+"lst_free_dt") = true;
				sheetObj.ColHidden(idx+"pkup_dt") = true;
				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;
				sheetObj.ColHidden(idx+"csr_no") = true;
				sheetObj.ColHidden(idx+"gl_dt") = true;
				sheetObj.ColHidden(idx+"vvd") = true;
				sheetObj.ColHidden(idx+"vvd_cd") = false;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				for( var jdx = sheetObj.HeaderRows; jdx <= sheetObj.LastRow; jdx++ ){
					sheetObj.CellEditable(jdx, "yd_cd") = true;
				}
				sheetObj.CellValue2(0, idx+"yd_cd") = "Terminal";
				break;
			case "TD":
				sheetObj.ColHidden(idx+"eq_knd_nm") = true;
				sheetObj.ColHidden(idx+"eq_no") = true;
				sheetObj.ColHidden(idx+"eq_tpsz_cd") = true;
				sheetObj.ColHidden(idx+"bkg_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"route") = true;
				sheetObj.ColHidden(idx+"mgset_no") = true;
				sheetObj.ColHidden(idx+"new_eq_no") = true;
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;
				sheetObj.ColHidden(idx+"cita_no") = true;
				sheetObj.ColHidden(idx+"cntr_wgt") = true;
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;
				sheetObj.ColHidden(idx+"wt_hrs") = true;
				sheetObj.ColHidden(idx+"occr_dt") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"new_bkg_no") = true;
				sheetObj.ColHidden(idx+"damage_dt") = true;
				sheetObj.ColHidden(idx+"repair_location") = true;
				sheetObj.ColHidden(idx+"lst_free_dt") = true;
				sheetObj.ColHidden(idx+"pkup_dt") = true;
				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;
				sheetObj.ColHidden(idx+"csr_no") = true;
				sheetObj.ColHidden(idx+"gl_dt") = true;
				sheetObj.ColHidden(idx+"vvd") = true;
				sheetObj.ColHidden(idx+"vvd_cd") = false;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				for( var jdx = sheetObj.HeaderRows; jdx <= sheetObj.LastRow; jdx++ ){
					sheetObj.CellEditable(jdx, "yd_cd") = true;
				}
				sheetObj.CellValue2(0, idx+"yd_cd") = "Terminal";
				break;
			case "SD":
				sheetObj.ColHidden(idx+"eq_knd_nm") = true;
				sheetObj.ColHidden(idx+"eq_no") = true;
				sheetObj.ColHidden(idx+"eq_tpsz_cd") = true;
				sheetObj.ColHidden(idx+"bkg_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"route") = true;
				sheetObj.ColHidden(idx+"mgset_no") = true;
				sheetObj.ColHidden(idx+"new_eq_no") = true;
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;
				sheetObj.ColHidden(idx+"cita_no") = true;
				sheetObj.ColHidden(idx+"cntr_wgt") = true;
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;
				sheetObj.ColHidden(idx+"wt_hrs") = true;
				sheetObj.ColHidden(idx+"occr_dt") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"new_bkg_no") = true;
				sheetObj.ColHidden(idx+"damage_dt") = true;
				sheetObj.ColHidden(idx+"repair_location") = true;
				sheetObj.ColHidden(idx+"lst_free_dt") = true;
				sheetObj.ColHidden(idx+"pkup_dt") = true;
				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;
				sheetObj.ColHidden(idx+"csr_no") = true;
				sheetObj.ColHidden(idx+"gl_dt") = true;
				sheetObj.ColHidden(idx+"vvd") = true;
				sheetObj.ColHidden(idx+"vvd_cd") = false;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				for( var jdx = sheetObj.HeaderRows; jdx <= sheetObj.LastRow; jdx++ ){
					sheetObj.CellEditable(jdx, "yd_cd") = true;
				}
				sheetObj.CellValue2(0, idx+"yd_cd") = "Terminal";
				break;
			case "SA":
				sheetObj.ColHidden(idx+"eq_knd_nm") = true;
				sheetObj.ColHidden(idx+"eq_no") = true;
				sheetObj.ColHidden(idx+"eq_tpsz_cd") = true;
				sheetObj.ColHidden(idx+"bkg_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"route") = true;
				sheetObj.ColHidden(idx+"mgset_no") = true;
				sheetObj.ColHidden(idx+"new_eq_no") = true;
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;
				sheetObj.ColHidden(idx+"cita_no") = true;
				sheetObj.ColHidden(idx+"cntr_wgt") = true;
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;
				sheetObj.ColHidden(idx+"wt_hrs") = true;
				sheetObj.ColHidden(idx+"occr_dt") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"new_bkg_no") = true;
				sheetObj.ColHidden(idx+"damage_dt") = true;
				sheetObj.ColHidden(idx+"repair_location") = true;
				sheetObj.ColHidden(idx+"lst_free_dt") = true;
				sheetObj.ColHidden(idx+"pkup_dt") = true;
				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;
				sheetObj.ColHidden(idx+"csr_no") = true;
				sheetObj.ColHidden(idx+"gl_dt") = true;
				sheetObj.ColHidden(idx+"vvd") = true;
				sheetObj.ColHidden(idx+"vvd_cd") = false;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				for( var jdx = sheetObj.HeaderRows; jdx <= sheetObj.LastRow; jdx++ ){
					sheetObj.CellEditable(jdx, "yd_cd") = true;
				}
				sheetObj.CellValue2(0, idx+"yd_cd") = "Terminal";
				break;
			case "DD":
				sheetObj.ColHidden(idx+"eq_knd_nm") = true;
				sheetObj.ColHidden(idx+"eq_no") = true;
				sheetObj.ColHidden(idx+"eq_tpsz_cd") = true;
				sheetObj.ColHidden(idx+"bkg_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"route") = true;
				sheetObj.ColHidden(idx+"mgset_no") = true;
				sheetObj.ColHidden(idx+"new_eq_no") = true;
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;
				sheetObj.ColHidden(idx+"cita_no") = true;
				sheetObj.ColHidden(idx+"cntr_wgt") = true;
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;
				sheetObj.ColHidden(idx+"wt_hrs") = true;
				sheetObj.ColHidden(idx+"occr_dt") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"new_bkg_no") = true;
				sheetObj.ColHidden(idx+"damage_dt") = true;
				sheetObj.ColHidden(idx+"repair_location") = true;
				sheetObj.ColHidden(idx+"lst_free_dt") = true;
				sheetObj.ColHidden(idx+"pkup_dt") = true;
				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;
				sheetObj.ColHidden(idx+"csr_no") = true;
				sheetObj.ColHidden(idx+"gl_dt") = true;
				sheetObj.ColHidden(idx+"vvd") = true;
				sheetObj.ColHidden(idx+"vvd_cd") = false;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				for( var jdx = sheetObj.HeaderRows; jdx <= sheetObj.LastRow; jdx++ ){
					sheetObj.CellEditable(jdx, "yd_cd") = true;
				}
				sheetObj.CellValue2(0, idx+"yd_cd") = "Terminal";
				break;
			case "OT":
				sheetObj.ColHidden(idx+"eq_knd_nm") = true;
				sheetObj.ColHidden(idx+"eq_no") = true;
				sheetObj.ColHidden(idx+"eq_tpsz_cd") = true;
				sheetObj.ColHidden(idx+"bkg_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"route") = true;
				sheetObj.ColHidden(idx+"mgset_no") = true;
				sheetObj.ColHidden(idx+"new_eq_no") = true;
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;
				sheetObj.ColHidden(idx+"cita_no") = true;
				sheetObj.ColHidden(idx+"cntr_wgt") = true;
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;
				sheetObj.ColHidden(idx+"wt_hrs") = true;
				sheetObj.ColHidden(idx+"occr_dt") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"new_bkg_no") = true;
				sheetObj.ColHidden(idx+"damage_dt") = true;
				sheetObj.ColHidden(idx+"repair_location") = true;
				sheetObj.ColHidden(idx+"lst_free_dt") = true;
				sheetObj.ColHidden(idx+"pkup_dt") = true;
				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;
				sheetObj.ColHidden(idx+"csr_no") = true;
				sheetObj.ColHidden(idx+"gl_dt") = true;
				sheetObj.ColHidden(idx+"vvd") = true;
				sheetObj.ColHidden(idx+"vvd_cd") = false;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				for( var jdx = sheetObj.HeaderRows; jdx <= sheetObj.LastRow; jdx++ ){
					sheetObj.CellEditable(jdx, "yd_cd") = true;
				}
				sheetObj.CellValue2(0, idx+"yd_cd") = "Terminal";
				break;
			case "V1":
			case "V2":
			case "V3":
			case "V4":
				sheetObj.ColHidden(idx+"route") = true;				//route
				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
				sheetObj.ColHidden(idx+"new_eq_no") = true;   //new_eq_no
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
				sheetObj.ColHidden(idx+"cita_no") = true;		//citation_no
				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
				sheetObj.ColHidden(idx+"wt_hrs") = true;		//waiting_tm
				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;			//new_vvd
				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
				sheetObj.ColHidden(idx+"pkup_dt") = true;		//pick_up_dt
				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;			//over_day
				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				for( var jdx = sheetObj.HeaderRows; jdx <= sheetObj.LastRow; jdx++ ){
					sheetObj.CellEditable(jdx, "inv_dtl_amt") = false;
				}
				break;
			case "1M":
			case "2M":
			case "3M":
			case "1R":
			case "2R":
			case "3R":
			case "4R":
			case "5R":
			case "6R":
			case "7R":
			case "8R":
			case "9R":
			case "M1":
			case "M2":
			case "M3":
			case "M4":
			case "M5":
			case "M6":
			case "M7":
			case "M8":
			case "M9":
			case "Q1":
			case "Q2":
			case "Q3":
			case "Q4":
			case "Q5":
			case "Q6":
			case "R1":
			case "R2":
			case "R3":
			case "R4":
			case "R5":
			case "R6":
			case "R7":
			case "R8":
			case "R9":
				sheetObj.ColHidden(idx+"seq") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				sheetObj.ColHidden(idx+"n3pty_no") = true;
				sheetObj.ColHidden(idx+"n3pty_bil_tp_cd") = true;
				sheetObj.ColHidden(idx+"n3pty_bil_tp_nm") = true;
				sheetObj.ColHidden(idx+"eq_knd_nm") = true;
//				sheetObj.ColHidden(idx+"eq_no") = true;
				sheetObj.ColHidden(idx+"eq_tpsz_cd") = true;
//				sheetObj.ColHidden(idx+"bkg_no_all") = true;
				sheetObj.ColHidden(idx+"bl_no_all") = true;
				sheetObj.ColHidden(idx+"lod_id") = true;
//				sheetObj.ColHidden(idx+"vvd") = true;
				sheetObj.ColHidden(idx+"vvd_cd") = true;
				sheetObj.ColHidden(idx+"mgset_no") = true;
//				sheetObj.ColHidden(idx+"yd_cd") = true;
//				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"acct_cd_org") = true;
				sheetObj.ColHidden(idx+"route") = true;
				sheetObj.ColHidden(idx+"new_eq_no") = true;
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;
				sheetObj.ColHidden(idx+"cita_no") = true;
				sheetObj.ColHidden(idx+"cntr_wgt") = true;
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;
				sheetObj.ColHidden(idx+"wt_hrs") = true;
				sheetObj.ColHidden(idx+"occr_dt") = true;
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;
				sheetObj.ColHidden(idx+"new_bkg_no") = true;
				sheetObj.ColHidden(idx+"damage_dt") = true;
				sheetObj.ColHidden(idx+"repair_location") = true;
				sheetObj.ColHidden(idx+"lst_free_dt") = true;
				sheetObj.ColHidden(idx+"pkup_dt") = true;
				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;
				sheetObj.ColHidden(idx+"csr_no") = true;
//				sheetObj.ColHidden(idx+"gl_dt") = true;
//				sheetObj.ColHidden(idx+"ots_amt") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
//				sheetObj.ColHidden(idx+"inv_dtl_amt") = true;
				sheetObj.ColHidden(idx+"eq_knd_cd") = true;
				sheetObj.ColHidden(idx+"fm_nod_cd") = true;
				sheetObj.ColHidden(idx+"via_nod_cd") = true;
				sheetObj.ColHidden(idx+"to_nod_cd") = true;
				sheetObj.ColHidden(idx+"dor_nod_cd") = true;
				sheetObj.ColHidden(idx+"bkg_no") = true;
				sheetObj.ColHidden(idx+"bl_no") = true;
				sheetObj.ColHidden(idx+"vsl_cd") = true;
				sheetObj.ColHidden(idx+"skd_voy_no") = true;
				sheetObj.ColHidden(idx+"skd_dir_cd") = true;
				sheetObj.ColHidden(idx+"estm_svr_id") = true;
				sheetObj.ColHidden(idx+"original_inv_dtl_amt") = true;
				sheetObj.ColHidden(idx+"so_if_seq") = true;
				sheetObj.ColHidden(idx+"lgs_cost_cd") = true;
				sheetObj.ColHidden(idx+"so_no") = true;
				sheetObj.ColHidden(idx+"finc_dir_cd") = true;
				sheetObj.ColHidden(idx+"rev_amt") = true;
				sheetObj.ColHidden(idx+"ots_dtl_seq") = true;
				sheetObj.ColHidden(idx+"n3pty_expn_tp_cd") = true;
				sheetObj.ColHidden(idx+"n3pty_if_tp_cd") = true;
				sheetObj.ColHidden(idx+"estm_seq_no") = true;
				sheetObj.ColHidden(idx+"estm_rvis_no") = true;
				break;
			case "HD":
			case "PP":
			case "TA":
			case "TT":
			case "PI":
				sheetObj.ColHidden(idx+"yd_cd") = true;				//yd_cd
				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
				sheetObj.ColHidden(idx+"new_eq_no") = true;         //new_eq_no
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
				sheetObj.ColHidden(idx+"cita_no") = true;		    //citation_no
				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
				sheetObj.ColHidden(idx+"wt_hrs") = true;		    //waiting_tm
				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;		//new_vvd
				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
				sheetObj.ColHidden(idx+"lst_free_dt") = true;		//last_free_dt
				sheetObj.ColHidden(idx+"pkup_dt") = true;		    //pick_up_dt
				sheetObj.ColHidden(idx+"ft_ovr_dys") = true;		//over_day
				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
				sheetObj.ColHidden(idx+"gl_dt") = true;			    //gl_dt // Added By O Wan-Ki In 2007-08-13
				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				break;
			case "RS":
				sheetObj.ColHidden(idx+"yd_cd") = true;				//yd_cd
				sheetObj.ColHidden(idx+"mgset_no") = true;			//mgset_no
				sheetObj.ColHidden(idx+"new_eq_no") = true;         //new_eq_no
				sheetObj.ColHidden(idx+"new_cntr_seal_no") = true;  //new_seal_no
				sheetObj.ColHidden(idx+"cita_no") = true;		    //citation_no
				sheetObj.ColHidden(idx+"cntr_wgt") = true;			//weight
				sheetObj.ColHidden(idx+"n3pty_cntr_wgt_ut_cd") = true;				//uom
				sheetObj.ColHidden(idx+"wt_hrs") = true;		    //waiting_tm
				sheetObj.ColHidden(idx+"occr_dt") = true;			//occur_dt
				sheetObj.ColHidden(idx+"new_vsl_cd") = true;		//new_vvd
				sheetObj.ColHidden(idx+"new_bkg_no") = true;		//new_bkg_all
				sheetObj.ColHidden(idx+"damage_dt") = true;			//damage_dt
				sheetObj.ColHidden(idx+"repair_location") = true;	//repair_location
				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
				sheetObj.ColHidden(idx+"gl_dt") = true;			    //gl_dt // Added By O Wan-Ki In 2007-08-13
				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
				sheetObj.ColHidden(idx+"yd_nm") = true;
				sheetObj.ColHidden(idx+"atd") = true;
				sheetObj.ColHidden(idx+"acct_cd") = true;
				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
				break;
  		}
  		if ( document.form.s_trd_party_val.value != "US071995"  ){
  			sheetObj.ColHidden(idx+"lod_id") = true;
		}
  		if( document.form.s_cnt_cd.value == "IN" && document.form.s_ida_tax_seq.value == "999" ){
   			sheetObj.ColHidden(idx+"ida_sac_cd") = false;
			sheetObj.ColHidden(idx+"ida_sac_nm") = false;
   		}
 		
  	}
  	
      function openInvoiceCancelRemarkPopup(){
      	var theURL = "ESD_TPB_0810.do";
          // ComShowMessage( theURL );
      	var features = "scroll:no;status:no;help:no;dialogWidth:470px;dialogHeight:280px";
      	var rtnValue = window.showModalDialog(theURL, window, features);

      	if(rtnValue != undefined && rtnValue != null ){
      	    
      		document.form.s_invoice_cancel_remark.value = rtnValue[0];

      		if ( rtnValue[0].length == 0 ){ 
      		    ComShowCodeMessage("TPB90060");
                  return false;
      		}

      		return true;
      		
      	} else {
      	    return false;
      	}
  	}
  	
  	/* 
  	** 2009-03-13 O Wan-Ki
  	** Revision을 발행을 허가할 것인지 확인 
  	*/
  	function isSaveable(){

  		/* 1. 폼 상의 변경이 있었는지 확인. */
  		// 1-1. Save Original Value
  		var org_due_date = document.form.org_due_date.value;
  		var org_adm_chrg = ComGetUnMaskedValue(document.form.org_adm_chrg.value,"float");
  		var org_ddct_amt = ComGetUnMaskedValue(document.form.org_ddct_amt.value,"float");
  		var org_tot_amt  = ComGetUnMaskedValue(document.form.org_tot_amt.value,"float");
  		var org_inv_desc  = document.form.org_inv_desc.value;
  		//* 2009-04-27 O Wan-Ki 1.4 N200904160080, 주소영역 save 가능여부 판단기능 추가.
  		var org_usr_inp_ctnt1     = document.form.org_usr_inp_ctnt1.value    ;
  		var org_vndr_cust_addr    = document.form.org_vndr_cust_addr.value   ;
  		var org_cty_nm            = document.form.org_cty_nm.value           ;
  		var org_ste_cd            = document.form.org_ste_cd.value           ;
  		var org_zip_cd            = document.form.org_zip_cd.value           ;
  		var org_usr_inp_ctnt2     = document.form.org_usr_inp_ctnt2.value    ;
  		var org_vndr_cust_ref_rmk = document.form.org_vndr_cust_ref_rmk.value;
  		
  				
  		// 1-2. Save Current Value
  		var cur_due_date = document.form.s_rcv_due_dt.value;
  		var cur_adm_chrg = ComGetUnMaskedValue(document.form.s_add_amt.value,"float");
  		var cur_ddct_amt = ComGetUnMaskedValue(document.form.s_ddct_amt.value,"float");
  		
  		//* 2009-06-09 O Wan-Ki 1.5 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
  		//var cur_tot_amt  = parseFloat(delete_Char(document.form.s_total_amt.value,","));
  		if( document.form.cnt_cd.value == "IN" ){
  			var cur_tot_amt  = ComGetUnMaskedValue(document.form.lst_invoice_total.value,"float");
  		}else{
  			var cur_tot_amt  = ComGetUnMaskedValue(document.form.s_total_amt.value,"float");
  		}
  		
  		var cur_inv_desc  = document.form.s_inv_desc.value;
  		//* 2009-04-27 O Wan-Ki 1.4 N200904160080, 주소영역 save 가능여부 판단기능 추가.
  		var cur_usr_inp_ctnt1     = document.form.s_usr_inp_ctnt1.value    ;
  		var cur_vndr_cust_addr    = document.form.s_vndr_cust_addr.value   ;
  		var cur_cty_nm            = document.form.s_cty_nm.value           ;
  		var cur_ste_cd            = document.form.s_ste_cd.value           ;
  		var cur_zip_cd            = document.form.s_zip_cd.value           ;
  		var cur_usr_inp_ctnt2     = document.form.s_usr_inp_ctnt2.value    ;
  		var cur_vndr_cust_ref_rmk = document.form.s_vndr_cust_ref_rmk.value;
  		
  		if(	org_due_date == cur_due_date 
  			&& org_adm_chrg == cur_adm_chrg 
  			&& org_ddct_amt == cur_ddct_amt 
  			&& org_tot_amt  == cur_tot_amt 
  			&& org_inv_desc == cur_inv_desc 
  			&& document.form.s_clt_agn_flg.checked.toString() == document.form.org_clt_agn_flg.value
  			&& org_usr_inp_ctnt1     == cur_usr_inp_ctnt1    
  			&& org_vndr_cust_addr    == cur_vndr_cust_addr   
  			&& org_cty_nm            == cur_cty_nm           
  			&& org_ste_cd            == cur_ste_cd           
  			&& org_zip_cd            == cur_zip_cd           
  			&& org_usr_inp_ctnt2     == cur_usr_inp_ctnt2    
  			&& org_vndr_cust_ref_rmk == cur_vndr_cust_ref_rmk
  			){
  			
  			return false;
  		}
  		
  						
          /* 2. IBSheet 상의 변경이 있었는지 확인. - inv_amt 수정여부. */
          // 1-1. Invoice Amount Check
          if( document.form.inv_amt_sts.value != 'U' ){
          	return false;
          }
                  				
  		return true;
  		
  	}
  	
  	
  	/**
  	 *  인도점소 전용 세금계산을 위한 함수.
  	 *  2009-06-09 O Wan-Ki 1.5 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
  	 **/
  	function calculateForIndiaInvoice(){

  		var s_ddct_amt =  v("s_ddct_amt");
		var s_net_amt = v("s_net_amt");
		var s_add_amt =  v("s_add_amt");
		var s_ddct_amt_f = ComGetUnMaskedValue(ComTrim(s_ddct_amt),"float");
		var s_amt = addFloat(s_net_amt, s_add_amt);
		var s_amt_f = ComGetUnMaskedValue(ComTrim(s_amt),"float");
		var s_cnt_cd = document.form.s_cnt_cd.value;
		var s_ida_tax_seq = document.form.s_ida_tax_seq.value;

		if(s_ddct_amt_f - s_amt_f > 0){
			ComShowCodeMessage('TPB90032', 'Deducted Amount', '(Net Amount + Administration Charge)');
		}
  		// Service Tax
  		if( s_cnt_cd == 'IN' && s_ida_tax_seq != '999' ){
  			document.all.div_ida_svc_tax.style.display = "inline";
  			document.all.div_ida_gst_tax.style.display = "none";
  			document.all.div_ida_gst_bil_to.style.display = "none";
  			
  			
	  		document.form.tot_expn_tax.value = multiplyFloat( v("s_total_amt"), v("expn_tax") );
	  		
	  		// Education Cess
	  		document.form.tot_edu_tax.value = multiplyFloat( v("tot_expn_tax"), v("edu_tax") );
	  		
	  		// Higher Edu Cess
	  		document.form.tot_high_edu_tax.value = multiplyFloat( v("tot_expn_tax"), v("high_edu_tax") );
	  		
	  		// local Tax (SBC)
	  		document.form.tot_locl_tax.value = multiplyFloat( v("s_total_amt"), v("locl_tax_rt") );
	  		
   		    document.form.n2nd_locl_tax.value = multiplyFloat( v("s_total_amt"), v("n2nd_locl_tax_rt") );

	  		// Total Service Tax
	  		document.form.tot_svc_tax.value = addFloat( addFloat(v("tot_expn_tax"),v("tot_edu_tax")), v("tot_high_edu_tax") );
	  		document.form.tot_svc_tax2.value = addFloat(addFloat(v("tot_svc_tax"),v("tot_locl_tax")), v("n2nd_locl_tax"));
	  		
	  		// Expense
	  		document.form.lst_expense.value = v("s_total_amt");
	  		
	  		
	  		// Tax
	  		document.form.lst_tax.value = v("tot_svc_tax");
	  		document.form.tot_tax.value = addFloat(addFloat(v("tot_svc_tax"),v("tot_locl_tax")), v("n2nd_locl_tax"));
	  		
	  		// Invoice Total
	  		//document.form.lst_invoice_total.value = ComAddComma2(addFloat( v("lst_expense"), v("lst_tax") ),"#,###.00");;
	  		//document.form.lst_invoice_total.value = addFloat(v("s_total_amt"),v("tot_svc_tax"));
	  		document.form.lst_invoice_total.value = addFloat(v("s_total_amt"),v("tot_tax"));

  		} else{
  			document.all.div_ida_svc_tax.style.display = "none";
  			document.all.div_ida_gst_tax.style.display = "inline";
  			document.all.div_ida_gst_bil_to.style.display = "inline";
  			
  			initDisableControls();
  			
	  		// CGST Tax
	  		document.form.ida_cgst_amt.value = multiplyFloat( v("s_total_amt"), v("ida_cgst_rto") );
   		
	  		// SGST Tax
	  		document.form.ida_sgst_amt.value = multiplyFloat( v("s_total_amt"), v("ida_sgst_rto") );
 
	  		// IGST Tax
	  		document.form.ida_igst_amt.value = multiplyFloat( v("s_total_amt"), v("ida_igst_rto") );
 
	  		// UGST Tax
	  		document.form.ida_ugst_amt.value = multiplyFloat( v("s_total_amt"), v("ida_ugst_rto") );

	  		// Total Service Tax
	  		document.form.ida_tot_gst_rto.value = addFloat( addFloat( addFloat( v("ida_cgst_rto"), v("ida_sgst_rto") ), v("ida_igst_rto") ), v("ida_ugst_rto"));
	  		document.form.ida_tot_gst_amt.value = addFloat( addFloat( addFloat( v("ida_cgst_amt"), v("ida_sgst_amt") ), v("ida_igst_amt") ), v("ida_ugst_amt"));

	  		// Expense
	  		document.form.lst_expense.value = v("s_total_amt");

	  		// Tax
	  		document.form.lst_tax.value = v("ida_tot_gst_amt");
	  		document.form.tot_tax.value = v("ida_tot_gst_amt");

	  		// Invoice Total
	  		document.form.lst_invoice_total.value = addFloat( v("lst_expense"), v("tot_tax") ); 
  		}

  	}
  	
  	
  	function initDisableControls() {
		var formObj = document.form;
		 
//		with(formObj) {
//			ComEnableManyObjects(false, s_usr_inp_ctnt1, s_vndr_cust_addr, s_cty_nm, s_ste_cd, s_zip_cd, s_usr_inp_ctnt2);
//			s_usr_inp_ctnt1.className 		= "input2";
//			s_vndr_cust_addr.className 	= "input2";
//			s_cty_nm.className 			= "input2";
//			s_ste_cd.className 			= "input2";
//			s_zip_cd.className 			= "input2";
//			s_usr_inp_ctnt2.className 		= "input2";
//		}
//		 
   		formObj.s_vndr_cust_nm.disabled = true;
//  		formObj.s_vndr_cust_addr.disabled = true;
  		formObj.s_cty_nm.disabled = true;
  		formObj.s_ste_cd.disabled = true;
  		formObj.s_zip_cd.disabled = true;
//  		formObj.s_usr_inp_ctnt2.disabled = true;
 	}
  	
  	
  	/* 
  	*  DOM 내 객체를 쉽게 쓰기위한 보조함수 - 금액전용
  	*  2009-06-09 O Wan-Ki 1.5 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
  	*/
  	function v(arg){
		return eval("document.form."+arg+".value");
	}
  	
  	/*
  	*  실수의 합.
  	*  소수점 3자리까지만 계산하여 반올림 -> 소수점 2자리로 변경.
  	*  2009-06-09 O Wan-Ki 1.5 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
  	*/
  	function addFloat( f1, f2 ){
		
		f1 = ComGetUnMaskedValue(ComTrim(f1),"float");
		f2 = ComGetUnMaskedValue(ComTrim(f2),"float");

		var result = ( Math.floor(f1*1000) + Math.floor(f2*1000) ) / 10 ;
		if( result - Math.floor(result) >= 0.5 ){
			result = (Math.floor(result)+1)/100;
		}else{
			result = (Math.floor(result))/100;
		}
		
		result = ComAddComma2(result+"","#,###.00");
		if( ((result.split("."))[1]).length < 2 ){
			result = result + "0";
		}
				
		return result;
	}
  	
  	
  	/*
  	*  실수의 차.
  	*  소수점 3자리까지만 계산하여 반올림 -> 소수점 2자리로 변경.
  	*  [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
  	*/
  	function minusFloat( f1, f2 ){
		
		f1 = ComGetUnMaskedValue(ComTrim(f1),"float");
		f2 = ComGetUnMaskedValue(ComTrim(f2),"float");

		var result = ( Math.floor(f1*1000) - Math.floor(f2*1000) ) / 10 ;
		if( result - Math.floor(result) >= 0.5 ){
			result = (Math.floor(result)+1)/100;
		}else{
			result = (Math.floor(result))/100;
		}
		
		result = ComAddComma2(result+"","#,###.00");
		if( ((result.split("."))[1]).length < 2 ){
			result = result + "0";
		}
				
		return result;
	}
  	
  	
  	/*
  	*  실수의 곱.
  	*  소수점 3자리까지만 계산하여 반올림 -> 소수점 2자리로 변경.
  	*  2009-06-09 O Wan-Ki 1.5 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
  	*/
  	function multiplyFloat( f1, f2 ){

		f1 = ComGetUnMaskedValue(ComTrim(f1),"float");
		f2 = ComGetUnMaskedValue(ComTrim(f2),"float");
		var result = ( Math.floor(f1*1000) * Math.floor(f2*1000) ) / 1000000 ;

		if( result - Math.floor(result) >= 0.5 ){
			result = (Math.floor(result)+1)/100;
		}else{
			result = (Math.floor(result))/100;
		}
		
		result = ComAddComma2(result+"","#,###.00");
		if( ((result.split("."))[1]).length < 2 ){
			result = result + "0";
		}
				
		return result;
	}
  	
	/**
	 * Invoice Preview 팝업을 띄우는 함수 - 2010.03
	 *
	 * @param : formObject - formObject
	 * @param : s_dao_n3pty_bil_tp_cd - s_dao_n3pty_bil_tp_cd
	 * @param : s_n3pty_inv_no - s_n3pty_inv_no
	 * @param : s_n3pty_inv_his_seq - s_n3pty_inv_his_seq
	 * @param : s_n3pty_inv_rmd_cd - s_n3pty_inv_rmd_cd
	 * @param : s_final_flg - s_final_flg
	 */
	 function openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd, s_final_flg, s_trd_party_val ) {
		var theURL = "ESD_TPB_0112.do?pgmNo=ESD_TPB_0112&f_cmd="+SEARCH+"&s_dao_n3pty_bil_tp_cd="+s_dao_n3pty_bil_tp_cd+"&s_n3pty_inv_no="+s_n3pty_inv_no+"&s_n3pty_inv_his_seq="+s_n3pty_inv_his_seq+"&s_n3pty_inv_rmd_cd="+s_n3pty_inv_rmd_cd+"&s_final_flg="+s_final_flg+"&snd_edi_cd="+s_trd_party_val;
	    //ComShowMessage( theURL );
		var features = "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:768px";

		var rtnValue = window.showModalDialog(theURL, window, features);
	}
	 
	 
	 /**
	  * input 값의 길이를 체크하고 메시지 보여주는 함수
	  */	
	 function checkLength(obj, len, name){
	 	if(!ComChkLenByByte(obj, len)){
	 		ComShowCodeMessage("COM12142",name,len,"");
	 		obj.focus();
	 	}
	 }
	  
  	/**
  	 * 사용자 오피스에서 사용가능한 currency 를 combobox에 입력하는 함수 - 2010.10.22
  	 */
  	function getCurrencyList() {
  		var sheetObj = sheetObjects[0];
  		var formObj = document.form;
  		formObj.f_cmd.value = SEARCH01;
  		var query = tpbFrmQryStr(formObj);
  		var otherObjs = new Array("s_ofc_cd", "s_rhq_cd", "s_cnt_cd");
  		query = query+"&id=s_curr_cd&method=searchInvoiceCurrency&mode=F&obj=&all=2";
  		sheetObj.RemoveEtcData();
  		sheetObj.DoSearch4Post("TPBCommonCodeGS.do", query);
  		var bil_curr_cd = sheetObj.EtcData('BIL_CURR_CD');
  		var bilCurrCdArray = bil_curr_cd.split('|');

  		var comboObj = eval("document.all.s_curr_cd");
  		
  		if(comboObj != undefined) {
  			ComClearCombo(comboObj);
  		}
  		ComAddComboItem(comboObj, "<<Select>>", "" );
  		
			var k = 0;
  		while(k < bilCurrCdArray.length-1 ){
  			k++;
  			ComAddComboItem(comboObj, bilCurrCdArray[k], bilCurrCdArray[k]);
  		}
  		
  	}
  	
	 /**
	 *  PKGSC(PKGBB) GST계산
	 **/
	function calculateGst(){
		
  		var s_net_amt = ComGetUnMaskedValue(ComTrim(document.form.s_net_amt.value),"float");
		var s_add_amt = ComGetUnMaskedValue(ComTrim(document.form.s_add_amt.value),"float");
		var s_dsc_amt = ComGetUnMaskedValue(ComTrim(document.form.s_ddct_amt.value),"float");
		var tax_rt = document.form.s_vat_xch_rt.value;
		var org_gst = document.form.gst_amt.value;
		var s_gst_amt = 0 ;
		var s_amt = ( parseFloat(s_net_amt) + parseFloat(s_add_amt) - parseFloat(s_dsc_amt)) ;
		
		
		if(parseFloat(s_net_amt) != 0 && parseFloat(org_gst)== 0){
			s_gst_amt = 0 ;
		}else{
			s_gst_amt = ComRound((parseFloat(s_amt)*parseFloat(tax_rt)/100) , 2);  //s_vat_amt   s_total_amt
		}
		
		document.form.s_vat_amt.value = s_gst_amt;
		tpb_otherAmountReCalculate(document.form.s_vat_amt);

	}	
	  
	
	/* 개발자 작업  끝 */