/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0126.js
*@FileTitle : JO TPB Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010-03-17
*@LastModifier : Sun, CHOI
*@LastVersion : 1.3
* 2008-01-22 O Wan-Ki 1.0 최초 생성
* 2009-03-23 O Wan-Ki 1.1 N200903090210, rcv_due_dt 자동변경으로 처리(+30)
* 2009-11-16 Park Sung-Jin 1.2 ALPS Migration 작업
* 2010-03-17 Sun, CHOI 1.3 TPB Invoice Preview POPUP 으로 변경
* 2010-10-22 손은주 [CHM-201006504-01] [TPB] Currency Change Validation 보완
* 2015.07.30 Kim Hyun Hwa[CHM-201537151]그룹사 표준 코드 시행 프로그램 수정
* 2016.05.26 KIM HYUN HWA [CHM-201641663]Microsoft사 Load ID 추가 요청 
*            - JO는 해당 데이터 발생하지 않아 Sheet 만 수정한 상태임. 추후 필요시 Preview 호출시 s_snd_edi 추가가 필요함 
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
     * @class ESD_TPB_0126 : ESD_TPB_0126 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0126() {
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
    var tabObjects = new Array();
    var sheetCnt = 0;
    var tabCnt = 0;

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

  		//getTPBGenCombo('s_curr_cd','searchInvoiceCurrency','F','','2',new Array("s_ofc_cd", "s_rhq_cd", "s_cnt_cd"));
  		getCurrencyList();
  		ComBtnDisable("btn_preview");
		ComOpenWait(true);
  		//n3pty_no 에 해당하는 모든 billing case 정보를 hidden sheet로 조회한다.
  		//setTimeout("doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH);",2000);
  		doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBSEARCH);
  		ComOpenWait(false);
  	}

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 * item 추가시 sheetObj.CellValue 사용하는 부분 index 확인 필요함. (ex. sheetObjects[i].CellValue(j, 30))
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
  					InitColumnInfo(58, 0, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
				if(    document.form.s_ofc_cd.value == "ATLSC" //"ATLBB"
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
  						InitHeadMode(true, true, false, true, false, false)
  			  		}else {
  			  			InitHeadMode(true, true, true, true, false, false)
  			  		}

  					var HeadTitle = "Seq.|TPB No.|Billing Case|Billing Case Name|EQ Kind|EQ No.|TP/SZ|BKG No.|B/L No.|Load ID|VVD|VVD|MG Set No.|Location|Route|New EQ No.|New Seal No.|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|CSR No.|GL Date|Original AMT|for Invoice||||||||||||||||||||||||VAT|VAT AMT";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					sheetNo = "";
  					
  					//데이터속성    [ ROW, COL,   DATATYPE,      WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  						KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtData,      	 30,    daCenter,  true,    sheetNo+"seq", 					false,			"",		dfNone,			0,		false);
  					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"n3pty_no",        		false,          "",     dfNone,    		0,     	false,		false);
  					InitDataProperty(0, cnt++, dtHidden,     	 80,    daCenter,  true,    sheetNo+"n3pty_bil_tp_cd",      false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtHidden,      	120,    daCenter,  true,    sheetNo+"n3pty_bil_tp_nm",      false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     		 80,    daCenter,  true,    sheetNo+"eq_knd_nm",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"eq_no",        		false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     		 40,    daCenter,  true,    sheetNo+"eq_tpsz_cd",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"bkg_no_all",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"bl_no_all",        	false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"lod_id",           	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"vvd",        			false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"vvd_cd",        		false,          "",     dfNone,    		0,     	false,      false); // Added By O Wan-Ki In 2007-08-13

  					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"mgset_no",        		false,          "",     dfNone,    		0,     	true,       true);

  					InitDataProperty(0, cnt++, dtData,     		 70,    daCenter,  true,    sheetNo+"yd_cd",        		false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,      	230,    daCenter,  true,    sheetNo+"route",        		false,          "",     dfNone,    		0,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,      	110,    daCenter,  true,    sheetNo+"new_eq_no",        	false,          "",     dfNone,    		0,     	true,       true,		11);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"new_cntr_seal_no",     false,          "",     dfNone,    		0,     	true,       true, 		10);
  					
  					InitDataProperty(0, cnt++, dtData,      	130,    daCenter,  true,    sheetNo+"cita_no",        		false,          "",     dfNone,    		0,     	true,       true, 		20);
  					InitDataProperty(0, cnt++, dtData,     		 90,    daCenter,  true,    sheetNo+"cntr_wgt",        		false,          "",     dfFloat,    	2,     	true,       true, 		13);
  					InitDataProperty(0, cnt++, dtCombo,     	 60,    daCenter,  true,    sheetNo+"n3pty_cntr_wgt_ut_cd", false,          "",     dfNone,    		0,     	true,       true,		 3);
  					InitDataProperty(0, cnt++, dtData,      	100,    daRight ,  true,    sheetNo+"wt_hrs",        		false,          "",     dfFloat,    	2,     	true,       true,		 6);
  					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"occr_dt",        		false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"new_vsl_cd",        	false,          "",     dfNone,    		0,     	true,       true,		 4);
  					InitDataProperty(0, cnt++, dtData,      	100,    daCenter,  true,    sheetNo+"new_bkg_no",        	false,          "",     dfNone,    		0,     	true,       true, 		11);
  					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"damage_dt",        	false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"repair_location",      false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"lst_free_dt",        	false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtPopup,      	100,    daCenter,  true,    sheetNo+"pkup_dt",        		false,          "",     dfDateYmd,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtData,     		 60,    daCenter,  true,    sheetNo+"ft_ovr_dys",        	false,          "",     dfInteger,    	0,     	true,       true,		 3);			
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"csr_no",        		false,          "",     dfNone,    		0,     	false,      false); // Added By O Wan-Ki In 2007-08-13
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"gl_dt",        		false,          "",     dfNone,    		0,     	false,      false); // Added By O Wan-Ki In 2007-08-13

  					InitDataProperty(0, cnt++, dtData,      	130,    daRight ,  true,    sheetNo+"ots_amt",        		false,          "",     dfFloat,    	2,     	false,      false);
  					InitDataProperty(0, cnt++, dtData,      	130,    daRight ,  true,    sheetNo+"inv_dtl_amt",        	false,          "",     dfFloat,    	2,     	true,       true, 		17);

  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"eq_knd_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"fm_nod_cd",        	false,          "",     dfNone,    		0,     	true,       true);
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
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daRight ,  true,    sheetNo+"original_inv_dtl_amt", false,          "",     dfFloat,    	2,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"so_if_seq",        	false,          "",     dfInteger,    	0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"lgs_cost_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"acct_cd",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"so_no",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"finc_dir_cd",        	false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"rev_amt",        		false,          "",     dfNone,    		0,     	true,       true);
  					InitDataProperty(0, cnt++, dtHidden,      	100,    daCenter,  true,    sheetNo+"ots_dtl_seq",        	false,          "",     dfNone,    		0,     	true,       true);
  					
  					InitDataProperty(0, cnt++, dtHiddenStatus,   30,    daCenter,  true,    sheetNo+"ibflag");
  					InitDataProperty(0, cnt++, dtCheckBox,		 45,	daCenter,  true,	sheetNo+"vat_dtl_chk",			false,			"",		dfNone,			0,	    true ,		true,		 1,		false,		false,		"",		true);
					InitDataProperty(0, cnt++, dtData,			 80,	daRight ,  true,	sheetNo+"vat_dtl_amt",			false,			"",		dfFloat,		2,	    false,		false,		17);
  					
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
  					InitColumnInfo(58, 0, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)

  					var HeadTitle = "Seq.|3rd Party No|Billing Case|Billing Case Name|EQ Kind|EQ No.|TP/SZ|BKG No.|B/L No.|Load ID|MG Set No.|VVD|Location|Route|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|New EQ No.|New Seal No.|OTS AMT|for Invoice||||||||||||||||||||||||VAT|VAT AMT";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					
  					sheetNo="";

  					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtSeq,       30,    daCenter,  true,    sheetNo+"seq");
  					InitDataProperty(0, cnt++, dtData,      100,   daCenter,  true,    sheetNo+"n3pty_no",           false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,    sheetNo+"n3pty_bil_tp_cd",    false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      120,   daCenter,  true,    sheetNo+"n3pty_bil_tp_nm",    false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,    sheetNo+"eq_knd_nm",          false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      40,    daCenter,  true,    sheetNo+"eq_no",              false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,    sheetNo+"eq_tpsz_cd",         false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,    sheetNo+"bkg_no_all",         false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,    sheetNo+"bl_no_all",          false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,    sheetNo+"lod_id",             false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,    sheetNo+"vvd",                false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,   daCenter,  true,    sheetNo+"vvd_cd",             false,       "",      dfNone,    0,     false,       false); // Added By O Wan-Ki In 2007-08-13

  					InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,    sheetNo+"mgset_no",           false,       "",      dfNone,    0,     true,       true);

  					InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,    sheetNo+"yd_cd",              false,       "",      dfNone,    0,     true,       true);													
  					InitDataProperty(0, cnt++, dtData,      70,    daCenter,  true,    sheetNo+"route",              false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"new_eq_no",          false,       "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"new_cntr_seal_no",   false,       "",      dfNone,    0,     true,       true);

  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"cita_no",            false,       "",      dfDateYmd,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"cntr_wgt",           false,       "",      dfDateYmd,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"n3pty_cntr_wgt_ut_cd",  false,    "",      dfInteger,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"wt_hrs",          false,          "",      dfInteger,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"occr_dt",         false,          "",      dfDateYmd,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtPopup,     60,    daRight ,  true,    sheetNo+"new_vsl_cd",      false,          "",      dfDateYmd,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"new_bkg_no",      false,          "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"damage_dt",       false,          "",      dfDateYmd,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtPopup,     60,    daRight ,  true,    sheetNo+"repair_location", false,          "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"lst_free_dt",     false,          "",      dfDateYmd,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"pkup_dt",         false,          "",      dfDateYmd,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"ft_ovr_dys",      false,          "",      dfInteger,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,   daCenter ,  true,    sheetNo+"csr_no",         false,          "",      dfNone,    0,     false,       false); // Added By O Wan-Ki In 2007-08-13
  					InitDataProperty(0, cnt++, dtHidden,    100,   daCenter ,  true,    sheetNo+"gl_dt",          false,          "",      dfNone,    0,     false,       false); // Added By O Wan-Ki In 2007-08-13

  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"ots_amt",         false,          "",      dfFloat,    2,     true,       true);
  					InitDataProperty(0, cnt++, dtData,      60,    daRight ,  true,    sheetNo+"inv_dtl_amt",     false,          "",      dfFloat,    2,     true,       true);

  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"eq_knd_cd",        false,        "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"fm_nod_cd",        false,        "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"via_nod_cd",       false,        "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"to_nod_cd",        false,        "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"dor_nod_cd",       false,        "",      dfNone,    0,     true,       true);

  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"bkg_no",          false,         "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"bkg_no_split",    false,         "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"bl_no",           false,         "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"bl_no_tp",        false,         "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"bl_no_chk",       false,         "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"vsl_cd",          false,         "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"skd_voy_no",      false,         "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"skd_dir_cd",      false,         "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"estm_svr_id",     false,         "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daRight ,  true,    sheetNo+"original_inv_dtl_amt",  false,   "",      dfFloat,    2,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter ,  true,   sheetNo+"so_if_seq",      false,          "",      dfInteger,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter ,  true,   sheetNo+"lgs_cost_cd",    false,          "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter ,  true,   sheetNo+"acct_cd",        false,          "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter ,  true,   sheetNo+"so_no",          false,          "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter ,  true,   sheetNo+"finc_dir_cd",    false,          "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter ,  true,   sheetNo+"rev_amt",        false,          "",      dfNone,    0,     true,       true);
  					InitDataProperty(0, cnt++, dtHidden,    100,    daCenter ,  true,   sheetNo+"ots_dtl_seq",    false,          "",      dfNone,    0,     true,       true);

  					InitDataProperty(0, cnt++, dtStatus,    30,    daCenter,  true,    sheetNo+"ibflag");
  					InitDataProperty(0, cnt++, dtCheckBox,	45,	   daCenter,  true,	sheetNo+"vat_dtl_chk",		  false,		  "",		dfNone,			0,	    true ,		true,		 1,		false,		false,		"",		true);
					InitDataProperty(0, cnt++, dtData,		80,    daRight ,  true,	sheetNo+"vat_dtl_amt",		  false,		  "",		dfFloat,		2,	    false,		false,		17);
  					
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
//  				formObject.f_cmd.value = SEARCH;
//  				formObject.method = "post";
//  				formObject.action = "ESD_TPB_0112.do?pgmNo=ESD_TPB_0112";
//  				formObject.submit();
  					
					// 2010-03-17 Sun, CHOI 1.3 TPB Invoice Preview POPUP 으로 변경
					var s_dao_n3pty_bil_tp_cd = formObject.s_dao_n3pty_bil_tp_cd.value;
					var s_n3pty_inv_no = formObject.s_n3pty_inv_no.value;
					var s_n3pty_inv_his_seq = formObject.s_n3pty_inv_his_seq.value;
					var s_n3pty_inv_rmd_cd = formObject.s_n3pty_inv_rmd_cd.value;

					openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd);

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
  				//* 2009-03-23 O Wan-Ki 1.3 N200903090210, rcv_due_dt 자동변경으로 처리(+30)
//  				case "btns_calendar":
//					 var cal = new ComCalendar();
//					 cal.select(formObject.s_rcv_due_dt, 'yyyy-MM-dd');
//					break;
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
  				case "btns_calendar": 
  					var cal = new ComCalendar();
  					cal.select(formObject.s_rcv_due_dt, 'yyyy-MM-dd');
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
  				var x = sheetObj.GetSearchXml("ESD_TPB_0126GS.do", tpbFrmQryStr(formObj));
  				
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
  				if( (formObj.s_curr_cd.value == "KRW" || formObj.s_curr_cd.value == "JPY" || formObj.s_curr_cd.value == "VND") ){
  					var totAmt = ComGetUnMaskedValue(formObj.s_total_amt.value,"float");
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
  					var sum_inv_amt = 0;
  					for(var i=0;i<sheetObjects.length-1;i++){
  						for(var j=1;j<=sheetObjects[i].RowCount;j++){
//  						var tmp_ots_amt = parseFloat(sheetObjects[i].CellValue(j, 30)); //ots_amt // Changed From 27 To 30 By O Wan-Ki In 2007-08-14
//  						var tmp_inv_dtl_amt = parseFloat(sheetObjects[i].CellValue(j, 31)); //inv_dtl_amt // Changed From 28 To 31 By O Wan-Ki In 2007-08-14
  							var tmp_ots_amt = parseFloat(sheetObjects[i].CellValue(j, 31)); //ots_amt // Changed From 27 To 30 By O Wan-Ki In 2007-08-14
  							var tmp_inv_dtl_amt = parseFloat(sheetObjects[i].CellValue(j, 32)); //inv_dtl_amt // Changed From 28 To 31 By O Wan-Ki In 2007-08-14

  							  							// OTS_AMT > INV_AMT 인지 여부를 체크한다.
  							if( tmp_inv_dtl_amt > 0 ){
  								if(tmp_ots_amt < tmp_inv_dtl_amt){
  									ComShowCodeMessage("COM12133","Invoice Amout","OTS AMT","small value");
  									return false;
  								}
  							}

  							//ComShowMessage(sheetObjects[i].id+','+tmp_inv_dtl_amt+','+sheetObjects[i].CellValue(j, 31));// Changed From 28 To 31 By O Wan-Ki In 2007-08-14
  							sum_inv_amt += tmp_inv_dtl_amt;
  						}
  						sum_save_string += sheetObjects[i].GetSaveString();
  						sum_save_string += "&";
  					}
  					formObj.s_sum_inv_amt.value = ComGetUnMaskedValue(document.form.s_total_amt.value,"float");
  					// ComShowMessage('sum='+formObj.s_sum_inv_amt.value); //return;

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
  					// ComShowMessage( " final sum_inv_amt ; " + sum_inv_amt );  return;
  					// / TOTAL INVOICE AMOUNT CHECK -----  

  					formObj.f_cmd.value = MULTI;

  					var sXml = sheetObjects[sheetObjects.length-1].GetSaveXml("ESD_TPB_0126GS.do", sum_save_string + tpbFrmQryStr(formObj));

  					sheetObjects[sheetObjects.length-1].LoadSaveXml(sXml);

  				}
  				break;
  			case ADD: //ERP I/F
  				formObj.f_cmd.value = ADD;
  				div_processing_show(); // show processing image
  				
  				var sXml = sheetObjects[sheetObjects.length-1].GetSaveXml("ESD_TPB_0126GS.do", tpbFrmQryStr(formObj));

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
  	function sheet0_OnSearchEnd(sheetObj,errMsg){
  		var formObj = document.form;
  		//ComEtcDataToForm(document.form, sheetObj);
  		formObj.s_bil_loc.value = sheetObj.EtcData("s_bil_loc");
		formObj.s_phn_no.value = sheetObj.EtcData("s_phn_no");
		formObj.s_vndr_cnt_cd.value = sheetObj.EtcData("s_vndr_cnt_cd");
		//formObj.s_vndr_cust_addr2.value = sheetObj.EtcData("s_vndr_cust_addr2");
		formObj.s_cust_seq.value = sheetObj.EtcData("s_cust_seq");
		formObj.s_sheet_set_count.value = sheetObj.EtcData("s_sheet_set_count");
		formObj.s_trd_party_code_detail.value = sheetObj.EtcData("s_trd_party_code_detail");
		formObj.s_vat_xch_rt.value = sheetObj.EtcData("s_vat_xch_rt");
		//formObj.tax_rgst_no.value = sheetObj.EtcData("tax_rgst_no");
		//formObj.svc_cate_rmk.value = sheetObj.EtcData("svc_cate_rmk");
		//formObj.pmnt_acct_no.value = sheetObj.EtcData("pmnt_acct_no");
		formObj.s_vndr_cust_nm.value = sheetObj.EtcData("s_vndr_cust_nm");
		if(ComParseInt(sheetObj.EtcData("length_n3pty_bil_tp_cd"))>0){
			formObj.s_length_n3pty_bil_tp_cd.value = sheetObj.EtcData("length_n3pty_bil_tp_cd");
		}
		//formObj.high_edu_tax.value = sheetObj.EtcData("high_edu_tax");
		//formObj.edu_tax.value = sheetObj.EtcData("edu_tax");
		formObj.s_vndr_cust_addr.value = sheetObj.EtcData("s_vndr_cust_addr");
		formObj.s_curr_cd.value = sheetObj.EtcData("s_curr_cd");
		formObj.prcs_cnt.value = sheetObj.EtcData("s_prcs_cnt");
		formObj.s_fax_no.value = sheetObj.EtcData("s_fax_no");

		formObj.s_vndr_seq.value = sheetObj.EtcData("s_vndr_seq");
		formObj.s_cust_cnt_cd.value = sheetObj.EtcData("s_cust_cnt_cd");
		// s_ida_tax_seq  <==  ida_tax_seq
		//formObj.s_ida_tax_seq.value = sheetObj.EtcData("ida_tax_seq");
		formObj.s_ida_tax_seq.value = "0";
		//formObj.expn_tax.value = sheetObj.EtcData("expn_tax");
		formObj.s_vndr_cust_eml.value = sheetObj.EtcData("s_vndr_cust_eml");
		formObj.s_rgst_no.value = sheetObj.EtcData("s_rgst_no");
		
		/*
		if(formObj.indiaTaxForm.value == "Y"){
			document.getElementById('tax_rgst_no_text').innerText = sheetObj.EtcData("tax_rgst_no");
    		document.getElementById('svc_cate_rmk_text').innerText = sheetObj.EtcData("svc_cate_rmk");
    		document.getElementById('pmnt_acct_no_text').innerText = sheetObj.EtcData("pmnt_acct_no");
			document.getElementById('expn_tax_text').innerText = sheetObj.EtcData("expn_tax");
			document.getElementById('edu_tax_text').innerText = sheetObj.EtcData("edu_tax");
			document.getElementById('high_edu_tax_text').innerText = sheetObj.EtcData("high_edu_tax");
		}
		*/
  		var s_rhq_cd = sheetObj.EtcData("s_rhq_cd");

  		//구주지역만 VAT No.입력 가능
  		// ComShowMessage(s_rhq_cd);
  		if(s_rhq_cd == "HAMRU"){ // "HAMUR" // HAMHQ => HAMUR로 변경 by O Wan-Ki In 2007-05-21
  			document.form.s_rgst_no.readOnly = false;
  			document.form.s_rgst_no.className = "";
  		}else{
  			document.form.s_rgst_no.readOnly = true;
  			document.form.s_rgst_no.className = "noinput";
  		}



  		//VAT 적용된 금액 산출
  		var sumInvAmt = sheetObj.ComputeSum("|31|"); // Changed By O Wan-Ki In 2007-08-14
  		tpb_vatAmountReCalculate(sumInvAmt);

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

          		if ( tpb_no!=undefined && tpb_no.length==11 ){ // 정상적으로 처리되었을 경우 
              		//document.all.btn_confirm_t.disabled = true;
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
  	function tpb_makeTabLoad(formObj, sheetObjects, bilArr, x){
  		for(var i=0;i<sheetObjects.length-1;i++){
  			//TAB title 세팅
  			//document.getElementById("tab_title"+(i+1)).innerHTML = bilArr[i];
  			//Data load
  			var title = bilArr[i];
  			if(formObj.load_num.value == "0"){
				tabObjects[i].InsertTab(-1, title, true);
			}
  			sheetObjects[i].LoadSearchXml(x);
  			//TAB 별로 n3pty_bil_tp_cd 다른 것은 삭제
  			for(var j=1;j<=sheetObjects[i].RowCount;j++){
  				if(sheetObjects[i].CellValue(j, 3) != bilArr[i]){   //n3pty_bil_tp_nm
  					sheetObjects[i].RowDelete(j, false);
  					--j;
  				}
  				if(j != 0 ) sheetObjects[i].CellValue(j, 0) = j;   //seq
  				sheetObjects[i].TotalRows = j; //Row갯수를 다시 세팅한다.

  				//Outstanding Amount 의 Auto Upate check
  				tpb_chgColor_ots_amt(sheetObjects[i], 44, 27, j);

  				sheetObjects[i].Visible = true;

  			}
  			//Billing Case Code에 따라 다른 폼을 적용시킨다.
  			tpb_setSheetByBillingCase(sheetObjects[i], sheetObjects[i].CellValue(1, 2), i+1);  //n3pty_bil_tp_cd
  		}
  		formObj.load_num.value = "1";
  	}

  	//Billing case 중복 제거된 배열 구한다.
  	function tpb_getBillingCase(sheetObject){
  		var bilArrNm = new Array(); //Billing case Name 배열
  		var bilArrCd = new Array(); //Billing case CD 배열

  		for(var i=1;i<=sheetObject.RowCount;i++){
  			bilArrNm[bilArrNm.length] = sheetObject.CellValue(i, 3);  //n3pty_bil_tp_nm
  			bilArrCd[bilArrCd.length] = sheetObject.CellValue(i, 2);  //n3pty_bil_tp_cd
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
  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
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
//  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no  // Added By O Wan-Ki In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd") = true;			//gl_dt // Added By O Wan-Ki In 2007-08-13
  				sheetObj.ColHidden(idx+"vvd_cd") = false;			//vvd_cd (actual vvd) // Added By O Wan-Ki In 2007-08-13
  				for(var i=1;i<=sheetObj.RowCount; i++){ sheetObj.CellEditable(i, idx+"inv_dtl_amt") = false; }    // JO Case inv_dtl_amt Blocking ... Added By O Wan-Ki In 2007-10-29
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
  				break;
  		}
			
			if ( document.form.s_trd_party_code_detail.value != "US071995"  ){
				sheetObj.ColHidden(idx+"lod_id") = true;
		       }
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
	function openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd) {
		var theURL = "ESD_TPB_0112.do?pgmNo=ESD_TPB_0112&f_cmd="+SEARCH+"&s_dao_n3pty_bil_tp_cd="+s_dao_n3pty_bil_tp_cd+"&s_n3pty_inv_no="+s_n3pty_inv_no+"&s_n3pty_inv_his_seq="+s_n3pty_inv_his_seq+"&s_n3pty_inv_rmd_cd="+s_n3pty_inv_rmd_cd;
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
  	

	/* 개발자 작업  끝 */