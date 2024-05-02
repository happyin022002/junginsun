/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0567.js
*@FileTitle : CA Inquiry
*Open Issues : ESM_BKG_0567 화면
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.28 이남경
* 1.0 Creation 
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
     * @class ESM_BIS_0567 : ESM_BIS_0567 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BIS_0567() {
    	this.processButtonClick		 = tprocessButtonClick;
    	this.setTabObject            = setTabObject;
    	this.setSheetObject 		 = setSheetObject;
    	this.loadPage 				 = loadPage;
    	this.initTab 				 = initTab;
    	this.initSheet 				 = initSheet;
    	this.initRdConfig            = initRdConfig;
    	this.doActionIBSheet 		 = doActionIBSheet;
    	this.sheet1_OnSearchEnd      = sheet1_OnSearchEnd;
    	this.t2sheet1_OnSearchEnd    = t2sheet1_OnSearchEnd;
    	this.tab1_OnChange           = tab1_OnChange;
    	this.setEtcDataToForm_bkg    = setEtcDataToForm_bkg;
    	this.RdPrint                 = RdPrint;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;    
    
    var rdObjects = new Array();
    var rdCnt = 0;
        
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        sheetObject1 = sheetObjects[0];
        sheetObject2 = sheetObjects[1];
        sheetObject3 = sheetObjects[2];
        sheetObject4 = sheetObjects[3];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
			    	break;
			    case "btn_down_excel":
	      	    	//필수입력체크 
	      	    	//if(formObject.bkg_no.value.trim() == "") {
	      	    	if(formObject.oldBkgNo.value.trim() == "") {
	      	    		ComBkgNessMessage(formObject.bkg_no); 
	      	    		return false;
	      	    	}
			    	
			    	var sheetObj = null;
			    	if (tabObjects[0].selectedIndex == 2)  {
			    		sheetObj = sheetObjects[3];
			    	} else if (tabObjects[0].selectedIndex == 1)  {
			    		sheetObj = sheetObjects[2];
			    	} else {
			    		sheetObj = sheetObjects[1];
			    	}			    	
		        	if (sheetObj.RowCount == 0) {
		        		ComShowCodeMessage("BKG00109"); 
		        	    return;
		        	} else {
				   		sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
		        	}
			    	break;
			    	
			    case "btn_ca_kind_detail": 
			    	ComOpenPopup("ESM_BKG_0758.do?pgmNo=ESM_BKG_0758", 300, 410, "", '1,0,1,1,1', true);
			    	break;
			    	
				case "btn_print":
	      	    	//필수입력체크 
	      	    	//if(formObject.bkg_no.value.trim() == "") {
	      	    	if(formObject.oldBkgNo.value.trim() == "") {
	      	    		ComBkgNessMessage(formObject.bkg_no); 
	      	    		return false;
	      	    	}

					//if (RdPrint()) {
					//    rdObjects[0].CMPrint();
					//}
					RdPrint();

					break;

				case "btn_close":
					self.close();
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
    	}
    }

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt = 0 ;
                    InsertTab( cnt++, "General",              -1 );
                    InsertTab( cnt++, "Freight & Charge",     -1 );
                    InsertTab( cnt++, "Customer Information", -1 );
 				    BaseColor = "#F3F2F8";
                }
             break;
        }
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form; 
    	 
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        
        for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form);
        axon_event.addListenerForm  ('keyup',    'obj_keyup', form); 
        
        //RD 초기화
        initRdConfig(rdObjects[0]);   
        
        //initParam();  //form 객체에 한번만 
        
        if (formObj.bkg_no.value != "") {
	   		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	   	} 
        if (formObj.popFlg.value == "Y") {
        	ComEnableManyTd(true, "btn_close");
        } else {
        	ComEnableManyTd(false, "btn_close");
        }
    }
     
     
 	// 업무 자바스크립트 OnKeyPress 이벤트 처리
 	function obj_keypress_loc() {
 		switch(event.srcElement.dataformat){
 	       case "float":
 	           //숫자+"."입력하기
 	           ComKeyOnlyNumber(event.srcElement, ".");
 	           break;
 	       case "eng":
 	           //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
 	           ComKeyOnlyAlphabet();
 	           break;
 	       case "engdn":
 	           //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
 	           ComKeyOnlyAlphabet('lower');
 	           break;
 	       case "engup":
 	           //영문 대문자만 입력하기
 	           ComKeyOnlyAlphabet('upper');
 	           break;
 	       case "int":
 	           //숫자만입력하기(정수,날짜,시간)
 	           ComKeyOnlyNumber(event.srcElement);
 	           break;
 	       case "uppernum":
 	           //영문 대문자+숫자
 	           ComKeyOnlyAlphabet('uppernum'); 
 	           break;
 	       case "tel":
 		        // 숫자+"-"입력하기
 		        ComKeyOnlyNumber(event.srcElement, "-"); 
 		        break;
 	    }
 	}
    /**
     * KeyUp 처리 
     */   
 	function obj_keyup() {
 		var formObj = document.form;

 		with (formObj) {
 			if ( window.event.keyCode == 13 ) {
 				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 			}
 		}
 	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		switch(sheetObj.id) {
			case "sheet1":      //t4sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 130;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 5, 100);
		
		            var HeadTitle = "|C/A No.|C/A OFC.|Contract OFC.|C/A Date|Reason|Class|Class|Exempt"+
		                            "|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind|C/A Kind||";
		            var headCount = ComCountHeadTitle(HeadTitle);
		            		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            //dtRadioCheck
		            InitDataProperty(0,	cnt++,	dtRadioCheck,	21 ,  daCenter,	     false,	  "radio",                 false,    "",      dfNone,	      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	    80,  daLeft,  	     false,   "ca_no",                 false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,     	120,  daCenter,  	 false,   "corr_ofc_cd",   	       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    120,  daCenter,  	 false,   "ctrt_ofc_cd",   	       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    110,  daCenter,  	 false,   "corr_dt",               false,    "",      dfNone, 		  0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    50,   daCenter,  	 false,   "ca_rsn_cd",   	       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "rat_flg",   	           false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "expn_flg",   	       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    60,   daCenter,  	 false,   "doc_perf_expt_cd",      false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "rt_corr_flg",   	       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "chg_term_corr_flg",     false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "rcvde_term_corr_flg",   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "rout_corr_flg",   	   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "cust_corr_flg",   	   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "qty_corr_flg",   	   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "meas_qty_corr_flg",     false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "cmdt_corr_flg",   	   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "trnk_vsl_corr_flg",     false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "prpst_vsl_corr_flg",    false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    30,   daCenter,  	 false,   "ca_otr_rsn_corr_flg",   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,   	80,   daLeft,  	     false,   "bkg_no",                false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,   	30,   daCenter,  	 false,   "bkg_corr_rmk",          false,    "",      dfNone,         0,     false,      false);

					CountPosition = 0;
		        }
		        break; 
		
	        case "t1sheet1":      //t1sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 200;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = "Correction Items|Correction Items|Previous|Current";
		            var headCount = ComCountHeadTitle(HeadTitle);		            
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 2, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtData,   	 110,   daLeft,  	 true,    "item_hdr",        false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,  	 true,    "his_cate_nm",     false,   "",      dfNone, 		0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 350,   daLeft,      false,   "pre_ctnt",        false,   "",      dfNone, 		0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 350,   daLeft,  	 false,   "crnt_ctnt",       false,   "",      dfNone,         0,     true,       true);
		            
					CountPosition = 0;
		        }
		        break;
	
			case "t2sheet1":      //t2sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 200;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = "|FRT|P/T|Rated As|Curr.|Rate|Amount|Term|Prepaid|Collect|Third";
		            var headCount = ComCountHeadTitle(HeadTitle);	
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 1, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false); 
		            
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtData,   	 180,   daCenter,  	 true,    "corr_name",     	     false,          "",      dfNone,          0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daCenter,  	 false,   "chg_cd",              false,          "",      dfNone, 		   0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daCenter,  	 false,   "rat_ut_cd",           false,          "",      dfNone,          0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daRight,  	 false,   "rat_as_qty",   	     false,          "",      dfNone, 		   0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 50,   	daCenter, 	 false,   "curr_cd",   	         false,          "",      dfNone,          0,     true,       true);		
		            InitDataProperty(0, cnt++ , dtData,   	 70,    daRight,     false,   "chg_ut_amt",          false,          "",      dfNone, 		   0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 120,   daRight,     false,   "chg_amt",             false,          "",      dfNone,          0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 70,    daCenter,    false,   "frt_term_cd",         false,          "",      dfNone, 		   0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 70,    daRight,     false,   "prepaid",             false,          "",      dfNone, 		   0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 70,    daRight,     false,   "collect",             false,          "",      dfNone, 		   0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 70,    daRight,     false,   "third",               false,          "",      dfNone, 		   0,     true,       true);

					CountPosition = 0;		
		        }
		        break;
	
		    case "t3sheet1":      //t3sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 200;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = " | |Previous|Current";
		            var headCount = ComCountHeadTitle(HeadTitle);	
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 2, 0, true);		            
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		            
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            //InitDataProperty(0, cnt++ , dtData,   	 110,   daLeft,  	 true,    "type",   	  false,    "",      dfNone, 			0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 110,   daLeft,  	 true,    "item_hdr",     false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,  	 true,    "his_cate_nm",  false,   "",      dfNone, 		0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 350,   daLeft,      false,   "pre_ctnt",     false,   "",      dfNone, 		0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 350,   daLeft,  	 false,   "crnt_ctnt",    false,   "",      dfNone,         0,     true,       true);

					CountPosition = 0;
		        }
		        break;
		        
     		case "msgsheet1":      //msgsheet1 init : msg 전용 grid
				with (sheetObj) {
					// 높이 설정
					//style.height = 50;					
					//전체 너비 설정
					//SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
					InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,     true,   "ibflag");		
					
					WaitImageVisible = false; 
				}	
			    break;
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
      	    case IBSEARCH: 
      	    	//필수입력체크 
      	    	if(formObj.bkg_no.value.trim() == "" && 
      	    	   formObj.bl_no.value.trim()  == "" && 
      	    	   formObj.ca_no.value.trim()  == "") {
      	    		ComBkgNessMessage(formObj.bkg_no); 
      	    		return false;
      	    	}

      	    	if (sheetObj.id=="sheet1") {  
      	    		formObj.f_cmd.value = SEARCH; 
					var sXml = sheetObj.GetSearchXml("ESM_BIS_0567GS.do", FormQueryString(formObj)); 
					var arrXml = sXml.split("|$$|");
					
					if(ComGetEtcData(arrXml[0], "DataYn") == "N") {
						sheetObjects[4].LoadSearchXml(arrXml[0]); 
						
						//clear
				    	formObj.remark.value = "";
				    	sheetObjects[0].RemoveAll();
				    	sheetObjects[1].RemoveAll();
				    	sheetObjects[2].RemoveAll();
				    	sheetObjects[3].RemoveAll();
						
				    	setEtcDataToForm_clear();			    	
						return;
					} 
					
		            if (arrXml.length > 0) 
					{
		            	sheetObjects[0].RemoveAll();
		            	sheetObjects[0].LoadSearchXml(arrXml[0]); 
		            }
      	    	} else if (sheetObj.id=="t1sheet1") {
	      	    	formObj.f_cmd.value = SEARCH01; 
					var sXml = sheetObj.GetSearchXml("ESM_BIS_0567GS.do", FormQueryString(formObj)); 
					var arrXml = sXml.split("|$$|");  
					
			    	//clear
			    	formObj.remark.value = "";
			    	sheetObjects[1].RemoveAll();
			    	sheetObjects[2].RemoveAll();
			    	sheetObjects[3].RemoveAll();
			    	//load
					sheetObjects[1].LoadSearchXml(arrXml[0]);
					sheetObjects[2].LoadSearchXml(arrXml[1]);
					sheetObjects[3].LoadSearchXml(arrXml[2]);
      	    	} 
                break;
        }
    }

    
    //######################[1. Event]############################################################
    /**
     * sheet1 클릭시 처리 
     */    
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var formObj = document.form;
		var colId = sheetObj.ColSaveName(Col);
		if (colId == "radio") {
			formObj.bkg_no_mst.value = sheetObj.CellValue(Row, "bkg_no");
			formObj.ca_no_mst.value  = sheetObj.CellValue(Row, "ca_no"); 
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			
			formObj.remark.value = nullToBlank(sheetObj.CellValue(Row, "bkg_corr_rmk"));
		}        
	}    
    
    /**
    * sheet1 조회완료 후 처리 
    */    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj = document.form;
	   	
	   	if (ErrMsg.trim() != msgs['BKG00095'].trim()) 
	   	{
	   		setEtcDataToForm_bkg(formObj, sheetObjects[0]);  
	   	
		   	if (sheetObj.SearchRows > 0) {
		   		var nRow = 1; //sheetObj.RowCount; 
		   	    sheetObj.CellValue(nRow, "radio") = 1;
		   	    sheetObj.SelectCell(nRow, "radio");
		   	    sheet1_OnClick(sheetObj, nRow, sheetObj.SaveNameCol("radio"), 1); 	 
		   	} else {
		    	formObj.remark.value = "";
		    	sheetObjects[1].RemoveAll();
		    	sheetObjects[2].RemoveAll();
		    	sheetObjects[3].RemoveAll();
		   	}
	   	}	   	
    }
    
    /**
    * t2sheet1 조회완료 후 처리 
    */    
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj = document.form;
	   	
	   	if (sheetObj.SearchRows > 0) {
	   		sheetObj.Redraw = false;
	   		
	   		var strCorrNm = "";	   		
	   		var bRgbColor = false;
    		for (var i=1; i<=sheetObj.RowCount; i++) {
    			if (i==1) {
    				strCorrNm = sheetObj.CellValue(i, "corr_name");	
    			}
    			if (strCorrNm != sheetObj.CellValue(i, "corr_name")) {
	    		    strCorrNm = sheetObj.CellValue(i, "corr_name");
	    		    bRgbColor = !bRgbColor;
	    		}
/*    			
        		if (bRgbColor) {
	    			sheetObj.RangeBackColor(i, 0, i, 10) = sheetObj.RgbColor(255,255,0);   
	    		} else {
	    			sheetObj.RangeBackColor(i, 0, i, 10) = sheetObj.RgbColor(255,255,255); 
	    		}
*/
    			if (strCorrNm == "DIFFERENCE") {
    				sheetObj.RangeBackColor(i, 0, i, 10) = sheetObj.RgbColor(186, 235, 176);   //(210, 242, 206)  
    			} else if (strCorrNm == "PREVIOUS") {
    				sheetObj.RangeBackColor(i, 0, i, 10) = sheetObj.RgbColor(255, 255, 255); 
    			} else {
    				sheetObj.RangeBackColor(i, 0, i, 10) = sheetObj.RgbColor(254, 240, 251);   //(253, 227, 247);
    			}
    		}
	   		
	   		sheetObj.Redraw = true;
	   		tabObjects[0].tabEnable(1) = true;
	   	} else {
	   		tabObjects[0].tabEnable(1) = false;
	   	}
    }    
    
    /**
    * t2sheet1 조회완료 후 처리 
    */    
    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	if (sheetObj.SearchRows > 0) {
	   		tabObjects[0].tabEnable(2) = true;
	   	} else {
	   		tabObjects[0].tabEnable(2) = false;
	   	}
    }
    
   /**
	* Tab 클릭시 이벤트 관련
	* 선택한 탭의 요소가 활성화 된다.
	*/   
	function tab1_OnChange(tabObj, nItem)
	{
		var formObj = document.form;
	    var objs = document.all.item("tabLayer");
		objs[nItem].style.display     = "Inline";
		objs[beforetab].style.display = "none";
	
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		beforetab = nItem;
	} 
	
	
	//######################[2. Etc]##############################################################
    /**
    * Header 출력(Booking 정보) 
    * : ComEtcDataToForm()함수대신, EtcData를 화면에 View 
    */
    function setEtcDataToForm_bkg(formObj, sheetObj) {
        //------------------------------
        //sheetEtcData -> Form 
        with (formObj) 
        {	
        	oldBkgNo.value     = sheetObj.EtcData("bkg_no"); 
        	oldBlNo.value      = sheetObj.EtcData("bl_no"); 
        	oldCaNo.value      = sheetObj.EtcData("ca_no");        	
        	bkg_no.value       = sheetObj.EtcData("bkg_no"); 
        	bl_no.value        = sheetObj.EtcData("bl_no"); 
        	ca_no.value        = sheetObj.EtcData("ca_no"); 
        	cust_cnt_cd.value  = sheetObj.EtcData("cust_cnt_cd"); 
        	cust_nm.value      = sheetObj.EtcData("cust_nm"); 
        	cust_seq.value     = sheetObj.EtcData("cust_seq"); 
        	sailed_vvd.value   = sheetObj.EtcData("sailed_vvd"); 	        
        	t_vvd.value        = sheetObj.EtcData("t_vvd"); 
        	por_cd.value       = sheetObj.EtcData("por_cd");
        	pol_cd.value       = sheetObj.EtcData("pol_cd");
        	del_cd.value       = sheetObj.EtcData("del_cd");
        	pod_cd.value       = sheetObj.EtcData("pod_cd");
        	por_nod_cd.value   = sheetObj.EtcData("por_nod_cd");
        	pol_nod_cd.value   = sheetObj.EtcData("pol_nod_cd");
        	del_nod_cd.value   = sheetObj.EtcData("del_nod_cd");
        	pod_nod_cd.value   = sheetObj.EtcData("pod_nod_cd");        	
        } 
    }
	
    /**
    * Header 출력(Booking 정보) 
    * : ComEtcDataToForm()함수대신, EtcData를 화면에 clear
    */
    function setEtcDataToForm_clear() {
    	var formObj = document.form;
    	
        //------------------------------
        //sheetEtcData -> Form 
        with (formObj) 
        {	
        	oldBkgNo.value     = ""; 
        	oldBlNo.value      = ""; 
        	oldCaNo.value      = "";        	
        	//bkg_no.value       = sheetObj.EtcData("bkg_no"); 
        	//bl_no.value        = sheetObj.EtcData("bl_no"); 
        	//ca_no.value        = sheetObj.EtcData("ca_no"); 
        	cust_cnt_cd.value  = ""; 
        	cust_nm.value      = ""; 
        	cust_seq.value     = ""; 
        	sailed_vvd.value   = ""; 	        
        	t_vvd.value        = ""; 
        	por_cd.value       = "";
        	pol_cd.value       = "";
        	del_cd.value       = "";
        	pod_cd.value       = "";
        	por_nod_cd.value   = "";
        	pol_nod_cd.value   = "";
        	del_nod_cd.value   = "";
        	pod_nod_cd.value   = "";        	
        } 
    }

   
    //#############################(3. Util/Etc)##################################################
    /**
	 * Rd 설정
	 */
	function initRdConfig(rdObject){
		var RdViewer = rdObject;

		RdViewer.AutoAdjust = true;
		RdViewer.HideStatusbar();
		RdViewer.ViewShowMode(0); 
		RdViewer.setbackgroundcolor(128,128,128);
		RdViewer.SetPageLineColor  (128,128,128);
	}    

	/**
	 * 선택된 key값에 의해 기 생성된 RD(*.mrd)로 파라메터를 보내 처리
	 */
	function RdPrint() {
		var formObj = document.form;
		//var RdViewer = rdObjects[0];
		
		var rdUrl      = "apps/alps/esm/bkg/bookingcorrection/bdrcorrection/report/";
		//var rdOption   = " /riprnmargin";   //' /rwait'
		var rdFileName = "";
		var rdParam    = "";		
		var strTitle   = "CA Inquiry";

		var sRow = sheetObjects[0].FindCheckedRow("radio");
		var arrRow = sRow.split("|");
		
		rdFileName = "ESM_BKG_0182.mrd"; 
		rdParam    = "/rp ['"+sheetObjects[0].CellValue(arrRow[0], "bkg_no")+"'] ['"+sheetObjects[0].CellValue(arrRow[0], "ca_no")+"']";
		
		//RdViewer.FileOpen(RD_path + rdUrl + rdFileName, RDServer + rdParam + rdOption); 
		//공통팝업 사용시, 
		formObj.com_mrdPath.value      = rdUrl + rdFileName;
		formObj.com_mrdArguments.value = rdParam;
		formObj.com_mrdTitle.value     = strTitle;
  		formObj.com_mrdBodyTitle.value = "<span style='color:red'>"+strTitle+"</span>";
  		
  		//ComOpenRDPopup();  //modalless
  		//modalless : no_session
  		var goUrl = "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/jsp/rd.jsp";
  		ComPostOpenWindow(goUrl, "ESM_BIS_0567", "width=1200, height=800, resizable=yes");
  		
/* : modal 
  	    var goUrl = "COM_RD_COMMON_POPUP.do";
  		var param = "?com_mrdPath="     +formObj.com_mrdPath.value+
                    "&com_mrdArguments="+formObj.com_mrdArguments.value+
                    "&com_mrdTitle="    +formObj.com_mrdTitle.value+
                    "&com_mrdBodyTitle="+formObj.com_mrdBodyTitle.value+
                    "&com_zoomIn="      +7;
  		ComOpenWindowCenter(goUrl+param, "ESM_BIS_0567", 1200, 800, true);
*/ 

		return true;
	}
	 
 	/**
 	 * TD버튼 일괄 Enable/Disable 처리  
 	 */
    function ComEnableManyTd(bEnable, objs) {
 	    try {
 	        var args = arguments;
 	
 	        if (args.length < 2) return;
 	        for(var i=1; i<args.length; i++) {
 	 	    	if (bEnable == true) {
 		    		ComBtnEnable(args[i]);
 		    	} else {
 		    		ComBtnDisable(args[i]);
 		    	} 
 	        }
 	    } catch(err) { ComFuncErrMsg(err.message); }
    }	 
    
	/* 개발자 작업  끝 */