/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0110.js
*@FileTitle : Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-17
*@LastModifier : Sun, CHOI
*@LastVersion : 1.7
* 2008-01-22 O Wan-Ki 1.0 최초 생성
* 2009-03-16 O Wan-Ki 1.1 KRW,JPY,VND 의 Amount 는 정수로 보완.
* 2009-04-21 O Wan-Ki 1.2 N200904160080, Invoice Creation 폼 변경 (주소선택기능추가)
* 2009-06-09 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
* 2009-06-29 O Wan-Ki 1.3 S1V-09P-001, tax 전송부분 보완
* 2009-07-09 O Wan-Ki 1.4 N200907020250, 인도세금포맷 동적변경기능 추가
* 2009-08-12 O Wan-Ki 1.5 ALPS 최초 생성
* 2009-09-14 Park Sung-Jin 1.6 ALPS Migration 작업
* 2010-03-17 Sun, CHOI 1.7 TPB Invoice Preview POPUP 으로 변경
* 2010-10-22 손은주 [CHM-201006504-01] [TPB] Currency Change Validation 보완
* 2015-03-30 KIM HYUN HWA [CHM-201534974]TPB invoice format변경 요청-말레이지아 지역(PKGBB) 의 세법 신규 적용 사유)
* 2015.08.22 KIM HYUN HWA [CHM-201537151]그룹사 표준 코드 시행 프로그램 수정- 조직코드 변경
* 2015.11.11 KIM HYUN HWA [CHM-201538870]TPB code 추가에 (Pier Pass-PI) 따른 TPB invoice preview 화면 수정 요청
* 2015.11.12 KIM HYUN HWA [CHM-201538882]인도지역 Swachh Bharat Cess(SBC) 신설 관련 TPB Invoice 수정
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
     * @class ESD_TPB_0110 : ESD_TPB_0110 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0110() {
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
    var tabObjects = new Array();
    var sheetCnt = 0;
    var tabCnt = 0;
    

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
    		var tabObj = document.all.tab1;
    		var nItem = 0;
    		tabObj.BackColor="#FFFFFF";
    		tabObj.TabBackColor(nItem)="146,174,230";
    	
    		//var objs = document.all.item("tabLayer");
    		
    		//objs[beforetab].style.display = "none";
    		
    		//objs[nItem].style.display = "Inline";
    	
    		//--------------- 요기가 중요 --------------------------//
    		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
    		//objs[beforetab].style.zIndex = 0;
    		//objs[nItem].style.zIndex = 9;
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

      		if ( document.form.pop_yn.value == "Y" ){
      		   document.all.btn_close_t.style.display = "";
    		}else{
    		   document.all.btn_close_t.style.display = "none";
    		}
      		ComBtnDisable("btn_preview");
    		
    		getCurrencyList();
    		ComOpenWait(true);
    
    		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH);
    		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,SEARCH02);
    	
    		ComOpenWait(false);
    		//getTPBGenCombo('s_curr_cd','searchInvoiceCurrency','F','','2',new Array("s_ofc_cd", "s_rhq_cd", "s_cnt_cd"));

    		//setTimeout("doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH);",3000);
    		//n3pty_no 에 해당하는 모든 billing case 정보를 hidden sheet로 조회한다.
    		
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
    					if(document.form.s_ofc_cd.value     == "ATLSC" //"ATLBB"
      			  			|| document.form.s_ofc_cd.value == "ATLSA" //"ATLSC"
      			  			|| document.form.s_ofc_cd.value == "CHISC" //"CHIBB"
      			  			|| document.form.s_ofc_cd.value == "HOUSC" //"HOUBB"
      			  			|| document.form.s_ofc_cd.value == "ILMBS"          
      			  			|| document.form.s_ofc_cd.value == "LGBSC" //"LGBBB"
      			  			|| document.form.s_ofc_cd.value == "NYCSC" //"NYCBB"
      			  			|| document.form.s_ofc_cd.value == "ORFSO" //"ORFBS"
      			  			|| document.form.s_ofc_cd.value == "PDXSO" //"PDXBS"
      			  			|| document.form.s_ofc_cd.value == "PHXSA" //"PHXSC"
      			  			|| document.form.s_ofc_cd.value == "SAVSO" //"SAVBS"
      			  			|| document.form.s_ofc_cd.value == "SEASC" //"SEABB" 
      			  		 ){
      						InitHeadMode(true, true, false, true, false, false);
      			  		 }else {
      			  			InitHeadMode(true, true, true, true, false, false);
      			  		 }

    					    var HeadTitle = "Seq.|SAC Code|SAC Description|TPB No.|Billing Case|Billing Case Name|EQ Kind|EQ No.|TP/SZ|BKG No.|B/L No.|Load ID|VVD|VVD|MG Set No.|Location|Terminal Name|ATD|Account Name|Account Code|Route|New EQ No.|New Seal No.|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|CSR No.|GL Date|Original AMT|Add AMT|for Invoice|||||||||||||||||||||||||VAT|VAT AMT";

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					sheetNo = "";
    					
    					//데이터속성    [ ROW, COL,   DATATYPE,      WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++, dtData,      	 30,    daCenter,  true,    sheetNo+"seq", 					false,			"",		dfNone,			0,		false);
    					InitDataProperty(0, cnt++, dtData,      	 65,    daCenter,  true,    sheetNo+"ida_sac_cd",        	false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtData,      	240,    daLeft,    true,    sheetNo+"ida_sac_nm",        	false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"n3pty_no",        		false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtHidden,     	 80,    daCenter,  true,    sheetNo+"n3pty_bil_tp_cd",      false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtHidden,      	120,    daCenter,  true,    sheetNo+"n3pty_bil_tp_nm",      false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"eq_knd_nm",        	false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtData,      	 80,    daCenter,  true,    sheetNo+"eq_no",        		false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtData,     		 50,    daCenter,  true,    sheetNo+"eq_tpsz_cd",        	false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"bkg_no_all",        	false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtHidden,     	 90,    daCenter,  true,    sheetNo+"bl_no_all",        	false,          "",     dfNone,    		0,     	false,       false);
        				InitDataProperty(0, cnt++, dtData,   	     70,    daCenter,  true,    sheetNo+"lod_id",        	    false,          "",     dfNone,    		0,     	true,        true);
    					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"vvd",        			false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtHidden,      	 70,    daCenter,  true,    sheetNo+"vvd_cd",        		false,          "",     dfNone,    		0,     	false,       false); // Added By O Wan-Ki In 2007-08-13
    					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"mgset_no",        		false,          "",     dfNone,    		0,     	true ,       true );
    					InitDataProperty(0, cnt++, dtData,     		 80,    daCenter,  true,    sheetNo+"yd_cd",        		false,          "",     dfNone,    		0,     	false,       false,		7);
    					InitDataProperty(0, cnt++, dtData,     		170,    daLeft,    true,    sheetNo+"yd_nm",        		false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"atd",        			false,          "",     dfTimeHms,    	0,     	false ,      false);
    					InitDataProperty(0, cnt++, dtCombo,     	160,    daLeft,    true,    sheetNo+"acct_cd",        		false,          "",     dfNone,    		0,     	true,        true);
    					InitDataProperty(0, cnt++, dtHidden,     	210,    daLeft,    true,    sheetNo+"acct_cd_org",        	false,          "",     dfNone,    		0,     	true,        true);
    					InitDataProperty(0, cnt++, dtData,      	230,    daCenter,  true,    sheetNo+"route",        		false,          "",     dfNone,    		0,     	false,       false);
    					InitDataProperty(0, cnt++, dtData,      	110,    daCenter,  true,    sheetNo+"new_eq_no",        	false,          "",     dfNone,    		0,     	true ,       true, 		11);
    					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"new_cntr_seal_no",     false,          "",     dfNone,    		0,     	true ,       true, 		10);
    					InitDataProperty(0, cnt++, dtData,      	130,    daCenter,  true,    sheetNo+"cita_no",        		false,          "",     dfNone,    		0,     	true ,       true, 		20);
    					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"cntr_wgt",        		false,          "",     dfFloat,    	2,     	true ,       true, 		13);
    					InitDataProperty(0, cnt++, dtCombo,     	 60,    daCenter,  true,    sheetNo+"n3pty_cntr_wgt_ut_cd", false,          "",     dfNone,    		0,     	true ,       true,		 3);
    					InitDataProperty(0, cnt++, dtData,      	100,    daRight ,  true,    sheetNo+"wt_hrs",        		false,          "",     dfFloat,    	2,     	true ,       true,		 6);
    					InitDataProperty(0, cnt++, dtPopup,      	 80,    daCenter,  true,    sheetNo+"occr_dt",        		false,          "",     dfDateYmd,    	0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"new_vsl_cd",        	false,          "",     dfNone,    		0,     	true ,       true,		 4);
    					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"new_bkg_no",        	false,          "",     dfNone,    		0,     	true ,       true, 		11);
    					InitDataProperty(0, cnt++, dtPopup,      	 80,    daCenter,  true,    sheetNo+"damage_dt",        	false,          "",     dfDateYmd,    	0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"repair_location",      false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtPopup,      	 80,    daCenter,  true,    sheetNo+"lst_free_dt",        	false,          "",     dfDateYmd,    	0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtPopup,      	 80,    daCenter,  true,    sheetNo+"pkup_dt",        		false,          "",     dfDateYmd,    	0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daCenter,  true,    sheetNo+"ft_ovr_dys",        	false,          "",     dfInteger,    	0,     	true ,       true,		 3);			
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"csr_no",        		false,          "",     dfNone,    		0,     	false,       false); // Added By O Wan-Ki In 2007-08-13
    					InitDataProperty(0, cnt++, dtHidden,      	 80,    daCenter,  true,    sheetNo+"gl_dt",        		false,          "",     dfNone,    		0,     	false,       false); // Added By O Wan-Ki In 2007-08-13
    					InitDataProperty(0, cnt++, dtData,      	 90,    daRight ,  true,    sheetNo+"ots_amt",        		false,          "",     dfFloat,    	2,     	false,       false);
    					InitDataProperty(0, cnt++, dtData,      	 90,    daRight ,  true,    sheetNo+"inv_dtl_add_amt",     	false,          "",     dfFloat,    	2,     	true ,       true, 		17);
    					InitDataProperty(0, cnt++, dtData,      	 90,    daRight ,  true,    sheetNo+"inv_dtl_amt",        	false,          "",     dfFloat,    	2,     	true ,       true, 		17);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"eq_knd_cd",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"fm_nod_cd",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"via_nod_cd",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"to_nod_cd",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"dor_nod_cd",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"bkg_no",        		false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"bl_no",        		false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"vsl_cd",        		false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"skd_voy_no",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"skd_dir_cd",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"estm_svr_id",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"original_inv_dtl_amt", false,          "",     dfFloat,    	2,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"so_if_seq",        	false,          "",     dfInteger,    	0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"lgs_cost_cd",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"so_no",        		false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"finc_dir_cd",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"rev_amt",        		false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"ots_dtl_seq",        	false,          "",     dfNone,    		0,     	true ,       true);
    					
    					InitDataProperty(0, cnt++, dtHiddenStatus,	 30,    daCenter,  true,    sheetNo+"ibflag");
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"n3pty_expn_tp_cd",     false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"n3pty_if_tp_cd",       false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"estm_seq_no",        	false,          "",     dfNone,    		0,     	true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"estm_rvis_no",        	false,          "",     dfNone,    		0,     	true ,       true);
    					
    				if(document.form.s_ofc_cd.value == "PKGBB"){
    					InitDataProperty(0, cnt++, dtHidden,		 45,	daCenter,  true,	sheetNo+"vat_dtl_chk",			false,			"",		dfNone,			0,	    true ,		 true,		 1,		false,		false,		"",		true);
    					InitDataProperty(0, cnt++, dtHidden,		 80,	daRight ,  true,	sheetNo+"vat_dtl_amt",			false,			"",		dfFloat,		2,	    false,		 false,		17);
    				}else{	
    					InitDataProperty(0, cnt++, dtCheckBox,		 45,	daCenter,  true,	sheetNo+"vat_dtl_chk",			false,			"",		dfNone,			0,	    true ,		 true,		 1,		false,		false,		"",		true);
    					InitDataProperty(0, cnt++, dtData,			 80,	daRight ,  true,	sheetNo+"vat_dtl_amt",			false,			"",		dfFloat,		2,	    false,		 false,		17);
    				}
    					
    					InitDataCombo (0, sheetNo+"n3pty_cntr_wgt_ut_cd", combo01Text, combo01Code); 
    					
    					DataLinkMouse("eq_no") = true;

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
    					InitHeadMode(true, true, true, true, false, false)

    					var HeadTitle = "Seq.|3rd Party No|Billing Case|Billing Case Name|EQ Type|EQ No.|TP/SZ|BKG No.|B/L No.|L|MG Set No.|VVD|Location|Terminal Name|ATD|Account Name|Account Code|Route|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|New EQ No.|New Seal No.|OTS AMT|Add AMT|for Invoice||||||||||||||||||||||||||VAT|VAT AMT";

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					
    					sheetNo="";

    					//데이터속성    [ ROW, COL,   DATATYPE,   	  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++, dtSeq,      		 30,    daCenter,  true,    sheetNo+"seq");
    					InitDataProperty(0, cnt++, dtData,      	 90,    daCenter,  true,    sheetNo+"n3pty_no",        		false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 80,    daCenter,  true,    sheetNo+"n3pty_bil_tp_cd",      false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,      	120,    daCenter,  true,    sheetNo+"n3pty_bil_tp_nm",      false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daCenter,  true,    sheetNo+"eq_knd_nm",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"eq_no",        		false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 40,    daCenter,  true,    sheetNo+"eq_tpsz_cd",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"bkg_no_all",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,     	 70,    daCenter,  true,    sheetNo+"bl_no_all",        	false,          "",     dfNone,    		0,     true ,       true);
        				InitDataProperty(0, cnt++, dtData,   	     70,    daCenter,  true,    sheetNo+"lod_id",        	    false,          "",     dfNone,    		0,     true,        true);

    					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"vvd",        			false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	 70,    daCenter,  true,    sheetNo+"vvd_cd",        		false,          "",     dfNone,    		0,     false,       false); // Added By O Wan-Ki In 2007-08-13

    					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"mgset_no",        		false,          "",     dfNone,    		0,     true ,       true);

    					InitDataProperty(0, cnt++, dtData,     		 60,    daCenter,  true,    sheetNo+"yd_cd",        		false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		210,    daLeft,    true,    sheetNo+"yd_nm",        		false,          "",     dfNone,    		0,     true,        true);
    					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"atd",        			false,          "",     dfTimeHms,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtCombo,     	210,    daLeft,    true,    sheetNo+"acct_cd",        		false,          "",     dfNone,    		0,     true,        true);
    					InitDataProperty(0, cnt++, dtHidden,     	210,    daLeft,    true,    sheetNo+"acct_cd_org",        	false,          "",     dfNone,    		0,     true,        true);
    					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"route",        		false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"new_eq_no",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"new_cntr_seal_no",     false,          "",     dfNone,    		0,     true ,       true);

    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"cita_no",        		false,          "",     dfDateYmd,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"cntr_wgt",        		false,          "",     dfDateYmd,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"n3pty_cntr_wgt_ut_cd", false,          "",     dfInteger,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"wt_hrs",        		false,          "",     dfInteger,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"occr_dt",        		false,          "",     dfDateYmd,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtPopup,     	 60,    daRight ,  true,    sheetNo+"new_vsl_cd",        	false,          "",     dfDateYmd,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"new_bkg_no",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"damage_dt",        	false,          "",     dfDateYmd,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtPopup,     	 60,    daRight ,  true,    sheetNo+"repair_location",      false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"lst_free_dt",        	false,          "",     dfDateYmd,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"pkup_dt",        		false,          "",     dfDateYmd,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		 60,    daRight ,  true,    sheetNo+"ft_ovr_dys",        	false,          "",     dfInteger,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"csr_no",        		false,          "",     dfNone,    		0,     false,       false); // Added By O Wan-Ki In 2007-08-13
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"gl_dt",        		false,          "",     dfNone,    		0,     false,       false); // Added By O Wan-Ki In 2007-08-13

    					InitDataProperty(0, cnt++, dtData,     		100,    daRight ,  true,    sheetNo+"ots_amt",        		false,          "",     dfFloat,    	2,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		100,    daRight ,  true,    sheetNo+"inv_dtl_add_amt",     	false,          "",     dfFloat,    	2,     true ,       true);
    					InitDataProperty(0, cnt++, dtData,     		100,    daRight ,  true,    sheetNo+"inv_dtl_amt",        	false,          "",     dfFloat,    	2,     true ,       true);

    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"eq_knd_cd",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"fm_nod_cd",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"via_nod_cd",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"to_nod_cd",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"dor_nod_cd",        	false,          "",     dfNone,    		0,     true ,       true);

    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"bkg_no",        		false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"bl_no",        		false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"vsl_cd",        		false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"skd_voy_no",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"skd_dir_cd",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"estm_svr_id",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"original_inv_dtl_amt",	false,          "",     dfFloat,    	2,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"so_if_seq",        	false,          "",     dfInteger,    	0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"lgs_cost_cd",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"so_no",        		false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"finc_dir_cd",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"rev_amt",        		false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"ots_dtl_seq",        	false,          "",     dfNone,    		0,     true ,       true);
    					
    					InitDataProperty(0, cnt++, dtStatus,      	 30,    daCenter,  true,    sheetNo+"ibflag");
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"n3pty_expn_tp_cd",     false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"n3pty_if_tp_cd",       false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"estm_seq_no",        	false,          "",     dfNone,    		0,     true ,       true);
    					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"estm_rvis_no",        	false,          "",     dfNone,    		0,     true ,       true);
        			if(document.form.s_ofc_cd.value == "PKGBB"){	
    					InitDataProperty(0, cnt++, dtHidden,		 40,	daCenter,  true,	sheetNo+"vat_dtl_chk",			false,			"",		dfNone,			0,	   true ,		true,		 1,		false,		false,		"",		true);
    					InitDataProperty(0, cnt++, dtHidden,		100,	daRight ,  true,	sheetNo+"vat_dtl_amt",			false,			"",		dfFloat,		2,	   false,		false,		17);
        			}else{
    					InitDataProperty(0, cnt++, dtCheckBox,		 40,	daCenter,  true,	sheetNo+"vat_dtl_chk",			false,			"",		dfNone,			0,	   true ,		true,		 1,		false,		false,		"",		true);
    					InitDataProperty(0, cnt++, dtData,			100,	daRight ,  true,	sheetNo+"vat_dtl_amt",			false,			"",		dfFloat,		2,	   false,		false,		17);
        			}	
    					DataLinkMouse("eq_no") = true;
    					
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
    				case "btn_preview":
    					if(formObject.s_n3pty_inv_no.value == ''){
    						ComShowCodeMessage("COM12150","Invoice","","");
    						return;
    					}
//    					formObject.f_cmd.value = SEARCH;
//						formObject.method = "post";
//						formObject.action = "ESD_TPB_0112.do?pgmNo=ESD_TPB_0112";
//						formObject.submit();
    					
    					// 2010-03-17 Sun, CHOI 1.7 TPB Invoice Preview POPUP 으로 변경
    					var s_dao_n3pty_bil_tp_cd = formObject.s_dao_n3pty_bil_tp_cd.value;
    					var s_n3pty_inv_no = formObject.s_n3pty_inv_no.value;
    					var s_n3pty_inv_his_seq = formObject.s_n3pty_inv_his_seq.value;
    					var s_n3pty_inv_rmd_cd = formObject.s_n3pty_inv_rmd_cd.value;
    					var s_trd_party_code = formObject.s_trd_party_code.value;
    					openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd, s_trd_party_code);

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
    				case "btn_confirm":
    					if(document.all.btn_confirm_t.disabled){
    						ComShowCodeMessage('TPB90010','Confirm ','','');
    					}else{
        				    var tot_amt = ComGetUnMaskedValue(document.form.s_total_amt.value,"float");
        				    if ( tot_amt < 0.00 ) {
        				    	ComShowCodeMessage('TPB90033','Total Amount','0.00');
        				    } else {
        				    	doActionIBSheet(sheetObject,formObject,IBSAVE);
        				    }
    					}
    					
    					break;
    				case "btn_erpInterface":
    					if( ComShowConfirm(ComGetMsg("TPB90008","","","")) ){	
    						doActionIBSheet(sheetObject,formObject,ADD);
    					}					
    					break;
  					case "btn_close":
					     window.returnValue = "Y";
					     window.close();
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

    				//hidden sheet로 조회
    				formObj.f_cmd.value = SEARCH;
    				var x = sheetObj.GetSearchXml("ESD_TPB_0110GS.do", tpbFrmQryStr(formObj));
    
    				// 조회된 데이터 전체(DATA, ETC-DATA)를 IBSHEET에 셋팅
    				sheetObj.LoadSearchXml(x);
    				
    				//hidden sheet에 load된 데이터를 billing case 종류별로 분리해서 sheet를 display한다.
    				var bilArr = tpb_getBillingCase(document.all.sheet0);	//Billing case 배열	
    				
    				tpb_makeTabLoad(formObj, sheetObjects, bilArr[0], x);
    				
    				//n3pty_bil_tp_cd 를 ',' 로 구분하여 문자열로 저장한다.
    				formObj.s_dao_n3pty_bil_tp_cd.value = bilArr[1].join("','");

    				//초기 화면 로딩시 currency 값
    				if(document.form.s_from_curr_cd.value == ""){
    					document.form.s_from_curr_cd.value = document.form.s_curr_cd.value;
    				}else{
    					//currency 변경했을 경우
    					if(document.form.s_from_curr_cd.value != ""){
    						for(var i=0;i<sheetObjects.length-1;i++){
    							for(var j=1;j<=sheetObjects[i].RowCount;j++){
    								sheetObjects[i].RowStatus(j) = "U";
    							}
    						}

    						//VAT 적용된 금액 재산출
    						var sumInvAmt = sheetObj.ComputeSum("|31|"); // Changed By O Wan-Ki In 2007-08-14
    						//tpb_vatAmountReCalculate(sumInvAmt);
    						amtReCalculate();
    					}
    				}
    				if(document.form.s_ofc_cd.value == "PKGBB"){
		    			calculateGst() 
		    		}
    				
    				// only Administration Charge 
    				tmpBilTpCds =formObj.s_dao_n3pty_bil_tp_cd.value;
    				var tmpBilTpCdsArray = tmpBilTpCds.split("','");
    				for(k=0;k < tmpBilTpCdsArray.length;k++ ){
    					if(tmpBilTpCdsArray[k] == "V1" || tmpBilTpCdsArray[k] == "V2" || tmpBilTpCdsArray[k] == "V3" || tmpBilTpCdsArray[k] == "V4" ){
    						//document.form.s_add_amt.readonly = true;
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
					var sXml = sheetObj.GetSearchXml("ESD_TPB_0110GS.do", tpbFrmQryStr(formObj));
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
    				//* 2009-03-16 O Wan-Ki 1.1 KRW,JPY,VND 의 Amount 는 정수로 보완.
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
    				
    				//Invoice Sheet Set 존재 여부 체크
    				if(document.form.s_sheet_set_count.value < 1){
    					ComShowCodeMessage("COM12150","Invoice Sheet Set","","");
    					return;
    				}
    		
    				if( ComShowConfirm(ComGetMsg("TPB90055")) ){
    					
    					var s_h_vndr_cust_div_cd = formObj.s_h_vndr_cust_div_cd.value;
    					var s_trd_party_code = formObj.s_trd_party_code.value;
    					
    					
    					//모든 Sheet의 SaveString과 Invoice Amount 총합 구하기
    					var sum_save_string = "";
    					for(var i=0;i<sheetObjects.length-1;i++){
    						sum_save_string += sheetObjects[i].GetSaveString();
    						sum_save_string += "&";
  
     						// MS Load ID
    						if ( formObj.s_trd_party_code_detail.value == "US071995"  ){
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
    					

    					// * 2009-06-09 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발] - 인도 tax 추가.
    					if( document.form.cnt_cd.value == "IN" && document.form.indiaTaxForm.value == "Y" ){
    						formObj.s_sum_inv_amt.value = ComGetUnMaskedValue(document.form.lst_invoice_total.value,"float");
    					}else{
    						formObj.s_sum_inv_amt.value = ComGetUnMaskedValue(document.form.s_total_amt.value,"float");
    					}

    					
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
  
    					// / TOTAL INVOICE AMOUNT CHECK -----  
    					
    					//* 2009-06-29 O Wan-Ki 1.3 S1V-09P-001, tax 전송부분 보완
    					if( document.form.cnt_cd.value == 'IN' && document.form.indiaTaxForm.value == "Y" ){
    						if (document.form.lst_tax.value.length != 0 ){
    							document.form.s_vat_amt.value = ComGetUnMaskedValue(document.form.lst_tax.value,"float") ;
    						}
    					}else{//* 2009-07-09 O Wan-Ki 1.4 N200907020250, 인도세금포맷 동적변경기능 추가
    						document.form.s_ida_tax_seq.value = "0";
    					}
    					
    					formObj.f_cmd.value = MULTI;
    					var sXml = sheetObjects[sheetObjects.length-1].GetSaveXml("ESD_TPB_0110GS.do", sum_save_string + tpbFrmQryStr(formObj));
    					
    					sheetObjects[sheetObjects.length-1].LoadSaveXml(sXml);

    				}
    				break;
    			case ADD: //ERP I/F    				
    				formObj.f_cmd.value = ADD;
    				div_processing_show(); // show processing image
    				var sXml = sheetObjects[sheetObjects.length-1].GetSaveXml("ESD_TPB_0110GS.do", tpbFrmQryStr(formObj));
    				sheetObjects[sheetObjects.length-1].LoadSaveXml(sXml);
    				div_processing_hide(); // hide processing image
    				
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
    			if(!ComChkValid(formObj)) return false;
    		}
    		
    		return true;
    	}
        
    	/**
    	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
    	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
    	 */
    	 //sheet0_OnSearchEnd
    	function sheet0_OnSearchEnd(sheetObj,errMsg){
    		var formObj = document.form;
    		//ComEtcDataToForm(formObj, sheetObj);
    		
    		formObj.s_bil_loc.value = sheetObj.EtcData("s_bil_loc");
    		formObj.s_phn_no.value = sheetObj.EtcData("s_phn_no");
    		formObj.s_vndr_cnt_cd.value = sheetObj.EtcData("s_vndr_cnt_cd");
    		formObj.s_vndr_cust_addr2.value = sheetObj.EtcData("s_vndr_cust_addr2");
    		formObj.s_cust_seq.value = sheetObj.EtcData("s_cust_seq");
    		formObj.s_sheet_set_count.value = sheetObj.EtcData("s_sheet_set_count");
    		formObj.s_trd_party_code_detail.value = sheetObj.EtcData("s_trd_party_code_detail");
    		formObj.s_vat_xch_rt.value = sheetObj.EtcData("s_vat_xch_rt");
    		formObj.tax_rgst_no.value = sheetObj.EtcData("tax_rgst_no");
    		formObj.svc_cate_rmk.value = sheetObj.EtcData("svc_cate_rmk");
    		formObj.pmnt_acct_no.value = sheetObj.EtcData("pmnt_acct_no");
    		formObj.s_vndr_cust_nm.value = sheetObj.EtcData("s_vndr_cust_nm");
    		if(ComParseInt(sheetObj.EtcData("length_n3pty_bil_tp_cd"))>0){
    			formObj.s_length_n3pty_bil_tp_cd.value = sheetObj.EtcData("length_n3pty_bil_tp_cd");
    		}
    		formObj.high_edu_tax.value = sheetObj.EtcData("high_edu_tax");
    		formObj.edu_tax.value = sheetObj.EtcData("edu_tax");
    		formObj.s_vndr_cust_addr.value = sheetObj.EtcData("s_vndr_cust_addr");
    		formObj.s_curr_cd.value = sheetObj.EtcData("s_curr_cd");
    		formObj.prcs_cnt.value = sheetObj.EtcData("s_prcs_cnt");
    		formObj.s_fax_no.value = sheetObj.EtcData("s_fax_no");
    		//formObj.TRANS_RESULT_KEY.value = sheetObj.EtcData("TRANS_RESULT_KEY");
    		formObj.s_vndr_seq.value = sheetObj.EtcData("s_vndr_seq");
    		//formObj.s_addr.value = sheetObj.EtcData("s_addr");
    		formObj.s_cust_cnt_cd.value = sheetObj.EtcData("s_cust_cnt_cd");
    		// s_ida_tax_seq  <==  ida_tax_seq
    		formObj.s_ida_tax_seq.value = sheetObj.EtcData("ida_tax_seq");
    		formObj.expn_tax.value = sheetObj.EtcData("expn_tax");
    		formObj.s_vndr_cust_eml.value = sheetObj.EtcData("s_vndr_cust_eml");
    		formObj.s_rgst_no.value = sheetObj.EtcData("s_rgst_no");
    		formObj.locl_tax_rt.value = sheetObj.EtcData("locl_tax_rt");// 2015-11-12 추가

    		if(formObj.indiaTaxForm.value == "Y"){
    			document.all.tr_ida_form.style.display = "inline";
    			formObj.ida_cgst_rto.value = sheetObj.EtcData("ida_cgst_rto");
    			formObj.ida_sgst_rto.value = sheetObj.EtcData("ida_sgst_rto");
    			formObj.ida_igst_rto.value = sheetObj.EtcData("ida_igst_rto");
    			formObj.ida_ugst_rto.value = sheetObj.EtcData("ida_ugst_rto");
    			formObj.ida_tot_gst_rto.value = sheetObj.EtcData("ida_tot_gst_rto");
    		}

    		var s_rhq_cd = sheetObj.EtcData("s_rhq_cd");

    		//구주지역만 VAT No.입력 가능
    		// ComShowMessage(s_rhq_cd);
    		if(s_rhq_cd == "HAMRU"){ // HAMHQ => HAMUR로 변경 by O Wan-Ki In 2007-05-21 // HAMRU 로 변경 2015-08-22
    			document.form.s_rgst_no.readOnly = false;
    			document.form.s_rgst_no.className = "";
    		}else{
    			document.form.s_rgst_no.readOnly = true;
    			document.form.s_rgst_no.className = "noinput";
    		}
    		
    		//VAT 적용된 금액 산출
    		var sumInvAmt = sheetObj.ComputeSum("|31|");
    		var sumInvAmt = sheetObj.ComputeSum("ots_amt");

    		tpb_vatAmountReCalculate(sumInvAmt);
    		
    		
    		/* 2009-06-09 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
    		*/
    		//if( document.all.cnt_cd.value == "IN" ){
    		if( document.all.cnt_cd.value == "IN" && document.all.indiaTaxForm.value == "Y"){//* 2009-07-09 O Wan-Ki 1.4 N200907020250, 인도세금포맷 동적변경기능 추가
    			calculateForIndiaInvoice();
    		}
    		
    		if(document.form.s_ofc_cd.value == "PKGSC"){ // 2015.08.22 PKGBB 조직변경 
    			calculateGst();
    		}
    		
    	}

    	/**
    	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
    	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
    	 */
    	function sheet0_OnSaveEnd(sheetObj,errMsg){

    		if(errMsg==null || errMsg == ''){

                if(document.form.f_cmd.value == MULTI){
        			//초기 currency 변수 초기화
        			document.form.s_from_curr_cd.value = "";

                    // 처리 후 입력 폼에 할당
               		ComEtcDataToForm(document.form, sheetObj);
               		
            		// 이후 처리 
            		var tpb_no = document.all.s_n3pty_inv_no.value;
            	    // ComShowMessage("tpb_no"+tpb_no);

            		if ( tpb_no!=undefined && tpb_no.length==11 ){ // 정상적으로 처리되었을 경우 
                		document.all.btn_confirm_t.style.display = "none";
                        document.all.btn_erpInterface_t.style.display = "none";
                        ComBtnEnable("btn_preview");
            		}
        			ComShowCodeMessage('COM12149','Invoice','','');
        			

    			} else if(document.form.f_cmd.value == ADD){
                    document.all.btn_erpInterface_t.style.display = "none";
    				ComShowCodeMessage('COM12149','ERP Interface','','');
    			}


    		} else {
    		    
    		    ComShowMessage(errMsg);
    		    
    		}
    	}

    	//Tab 데이터를 load 한다.
    	function tpb_makeTabLoad(formObj,sheetObjects, bilArr, x){

    		for(var i=0;i<sheetObjects.length-1;i++){
    			//TAB title 세팅
    			//document.getElementById("tab_title"+(i+1)).innerHTML = bilArr[i];
    			var title = bilArr[i];
    			
   
    			if(formObj.load_num.value == "0"){
    				tabObjects[i].InsertTab(-1, title, true);
    			}

    			//Data load
    			sheetObjects[i].LoadSearchXml(x);
    			
    			ComEtcDataToForm(formObj, sheetObjects[i]);
    			
    			//TAB 별로 n3pty_bil_tp_cd 다른 것은 삭제
    			for(var j=1;j<=sheetObjects[i].RowCount;j++){
    				if(sheetObjects[i].CellValue(j, "n3pty_bil_tp_nm") != bilArr[i]){   //n3pty_bil_tp_nm
    					sheetObjects[i].RowDelete(j, false);
    					--j;
    				}
    				if(j != 0 ) sheetObjects[i].CellValue(j, "seq") = j;   //seq
    				sheetObjects[i].TotalRows = j; //Row갯수를 다시 세팅한다.

    				//Outstanding Amount 의 Auto Upate check  
    				//tpb_chgColor_ots_amt(sheetObjects[i], 44, 27, j);
    				//sheetObjects[i].CellBackColor(j, 31) = sheetObjects[i].RgbColor(255,255,255);

    				sheetObjects[i].Visible = true;

    			}
    			//Billing Case Code에 따라 다른 폼을 적용시킨다.
    			tpb_setSheetByBillingCase(sheetObjects[i], sheetObjects[i].CellValue(1, "n3pty_bil_tp_cd"), i+1);  //n3pty_bil_tp_cd
    			
        		
    		}
    		formObj.load_num.value = "1";
    	}


    	//Billing case 중복 제거된 배열 구한다.
    	function tpb_getBillingCase(sheetObject){
    		var bilArrNm = new Array(); //Billing case Name 배열
    		var bilArrCd = new Array(); //Billing case CD 배열

    		for(var i=1;i<=sheetObject.RowCount;i++){
    			bilArrNm[bilArrNm.length] = sheetObject.CellValue(i, "n3pty_bil_tp_nm");  //n3pty_bil_tp_nm
    			bilArrCd[bilArrCd.length] = sheetObject.CellValue(i, "n3pty_bil_tp_cd");  //n3pty_bil_tp_cd
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


    	function changeCurrency(val){
    		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH)
    	}
    	
    	function clickSearch(){
    		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH)
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"yd_nm") = true;
    				sheetObj.ColHidden(idx+"atd") = true;
    				sheetObj.ColHidden(idx+"acct_cd") = true;
    				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
    				sheetObj.ColHidden(idx+"ida_sac_cd") = true;
    				sheetObj.ColHidden(idx+"ida_sac_nm") = true;
    				break;
    			case "VD":
    				sheetObj.ColHidden(idx+"eq_knd_nm") = true;  //eq_knd_cd
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
//    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = false;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
    				for(var i=1;i<=sheetObj.RowCount; i++){ sheetObj.CellEditable(i, idx+"inv_dtl_amt") = false; }    // JO Case inv_dtl_amt Blocking ... Added By O Wan-Ki In 2007-10-29
    				sheetObj.ColHidden(idx+"yd_nm") = true;
    				sheetObj.ColHidden(idx+"atd") = true;
    				sheetObj.ColHidden(idx+"acct_cd") = true;
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
    				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
    				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
//    				sheetObj.ColHidden(idx+"eq_no") = true;
    				sheetObj.ColHidden(idx+"eq_tpsz_cd") = true;
//    				sheetObj.ColHidden(idx+"bkg_no_all") = true;
    				sheetObj.ColHidden(idx+"bl_no_all") = true;
    				sheetObj.ColHidden(idx+"lod_id") = true;
//    				sheetObj.ColHidden(idx+"vvd") = true;
    				sheetObj.ColHidden(idx+"vvd_cd") = true;
    				sheetObj.ColHidden(idx+"mgset_no") = true;
//    				sheetObj.ColHidden(idx+"yd_cd") = true;
//    				sheetObj.ColHidden(idx+"yd_nm") = true;
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
//    				sheetObj.ColHidden(idx+"gl_dt") = true;
//    				sheetObj.ColHidden(idx+"ots_amt") = true;
    				sheetObj.ColHidden(idx+"inv_dtl_add_amt") = true;
//    				sheetObj.ColHidden(idx+"inv_dtl_amt") = true;
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
	   		if ( document.form.s_trd_party_code_detail.value != "US071995"  ){
	   			sheetObj.ColHidden(idx+"lod_id") = true;
			}
	   		if( document.form.s_cnt_cd.value == "IN" ){
	   			sheetObj.ColHidden(idx+"ida_sac_cd") = false;
				sheetObj.ColHidden(idx+"ida_sac_nm") = false;
	   		}
    	}
    	
    	/**
    	 *  인도점소 전용 세금계산을 위한 함수.
    	 *  2009-06-09 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
    	 **/
    	function calculateForIndiaInvoice(){

    		var s_ddct_amt =  v("s_ddct_amt");
    		var s_net_amt = v("s_net_amt");
    		var s_add_amt =  v("s_add_amt");
    		var s_ddct_amt_f = ComGetUnMaskedValue(ComTrim(s_ddct_amt),"float");
    		var s_amt = addFloat(s_net_amt, s_add_amt);
    		var s_amt_f = ComGetUnMaskedValue(ComTrim(s_amt),"float");
    		var indiaTaxForm = document.form.indiaTaxForm.value;
    		
    		
    		if(s_ddct_amt_f - s_amt_f > 0){
    			ComShowCodeMessage('TPB90032', 'Deducted Amount', '(Net Amount + Administration Charge)');
    		}
    		if (indiaTaxForm == "Y") {
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
    		
    	    }else{
	      		// Expense
	      		document.form.lst_expense.value = v("s_total_amt");
	      		
	      		// Tax
	      		document.form.lst_tax.value = 0;  
	      		document.form.tot_tax.value = 0;
	      		
	      		// Invoice Total
	      		document.form.lst_invoice_total.value = document.form.lst_expense.value; 
	    	}
    		
    	}	
    	
    	
    	/* 
    	*  DOM 내 객체를 쉽게 쓰기위한 보조함수 - 금액전용
    	*  2009-06-09 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
    	*/
    	function v(arg){
    		return eval("document.form."+arg+".value");
    	}
    	
    	/*
    	*  실수의 합.
    	*  소수점 3자리까지만 계산하여 반올림 -> 소수점 2자리로 변경.
    	*  2009-06-09 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
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
    	*  실수의 곱.
    	*  소수점 3자리까지만 계산하여 반올림 -> 소수점 2자리로 변경.
    	*  2009-06-09 O Wan-Ki 1.3 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
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
    	
    	//* 2009-07-09 O Wan-Ki 1.4 N200907020250, 인도세금포맷 동적변경기능 추가
    	function onclick_indiaTaxForm_checkbox(){
    		
    		var idaFormYN = "";

    		if( document.form.indiaTaxForm.value == "Y" ){
    			idaFormYN = "N";
    			document.form.indiaTaxForm.value = "N";
    		}else{
    			idaFormYN = "Y";
    			document.form.indiaTaxForm.value = "Y";
    		}

//    		 var formObject = document.form ;
//			document.form.method = "post";
//			document.form.action = "ESD_TPB_0110.do?pgmNo=ESD_TPB_0110&indiaTaxForm=" + idaFormYN;
//			document.form.submit();

    		calculateForIndiaInvoice();

    	}
    	
    	/**
    	 * Invoice Preview 팝업을 띄우는 함수 - 2010.03
    	 *
    	 * @param : formObject - formObject
    	 * @param : s_dao_n3pty_bil_tp_cd - s_dao_n3pty_bil_tp_cd
    	 * @param : s_n3pty_inv_no - s_n3pty_inv_no
    	 * @param : s_n3pty_inv_his_seq - s_n3pty_inv_his_seq
    	 * @param : s_n3pty_inv_rmd_cd - s_n3pty_inv_rmd_cd
    	 */
    	function openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd, s_trd_party_code) {
    		var theURL = "ESD_TPB_0112.do?pgmNo=ESD_TPB_0112&f_cmd="+SEARCH+"&s_dao_n3pty_bil_tp_cd="+s_dao_n3pty_bil_tp_cd+"&s_n3pty_inv_no="+s_n3pty_inv_no+"&s_n3pty_inv_his_seq="+s_n3pty_inv_his_seq+"&s_n3pty_inv_rmd_cd="+s_n3pty_inv_rmd_cd+"&snd_edi_cd="+s_trd_party_code;
    	    //ComShowMessage( theURL );
    		var features = "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:768px";

    		var rtnValue = window.showModalDialog(theURL, window, features);
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
    	 *   PKGSC(PKGBB) GST계산
    	 **/
    	function calculateGst(){
    		
	 		var s_net_amt = ComGetUnMaskedValue(ComTrim(document.form.s_net_amt.value),"float");
			var s_add_amt = ComGetUnMaskedValue(ComTrim(document.form.s_add_amt.value),"float");
			var s_dsc_amt = ComGetUnMaskedValue(ComTrim(document.form.s_ddct_amt.value),"float");
			var tax_rt = document.form.s_vat_xch_rt.value;
            
    		var s_amt = ( parseFloat(s_net_amt) + parseFloat(s_add_amt) - parseFloat(s_dsc_amt)) ;
    		
    		var s_gst_amt = ComRound( parseFloat(s_amt)*parseFloat(tax_rt)/100 , 2);  //s_vat_amt   s_total_amt
	
			document.form.s_vat_amt.value = s_gst_amt;
			tpb_otherAmountReCalculate(document.form.s_vat_amt);

    	}
    	
      	function initDisableControls() {
      		var formObj = document.form;

      		formObj.s_trd_party_code_detail.disabled = true;
      		formObj.s_vndr_cust_addr.disabled = true;
      		formObj.s_cty_nm.disabled = true;
      		formObj.s_ste_cd.disabled = true;
      		formObj.s_zip_cd.disabled = true;
      		formObj.s_usr_inp_ctnt2.disabled = true;
    	}
    	

	/* 개발자 작업  끝 */