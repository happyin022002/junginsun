/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0566.jsp
*@FileTitle : Booking History (B/L Data)
*Open Issues : ESM_BKG_0566 화면
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.04 이남경
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
     * @class esm_bkg_0566 : esm_bkg_0566 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0566() {
    	this.processButtonClick		 = tprocessButtonClick;
    	this.setTabObject            = setTabObject;
    	this.setSheetObject 		 = setSheetObject;
    	this.setComboObject          = setComboObject;
    	this.loadPage 				 = loadPage;
    	this.initTab 				 = initTab;
    	this.initControl             = initControl;
    	this.initSheet 				 = initSheet;
    	this.initRdConfig            = initRdConfig;
    	this.doActionIBSheet 		 = doActionIBSheet;
    	this.t1sheet1_OnSearchEnd    = t1sheet1_OnSearchEnd;
    	this.t2sheet1_OnSearchEnd    = t1sheet2_OnSearchEnd;
    	this.t3sheet1_OnSearchEnd    = t1sheet3_OnSearchEnd;
    	this.t4sheet1_OnSearchEnd    = t1sheet4_OnSearchEnd;
    	this.search_by_item_OnChange = search_by_item_OnChange;
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
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var rdObjects = new Array();
    var rdCnt = 0;
    //var queryStr = "";

    //tab별 조회완료 여부구분용
    var xSearchTab1 = false;
    var xSearchTab2 = false;
    var xSearchTab3 = false;
    var xSearchTab4 = false;
        
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
				case "btn_print":
					if (RdPrint()) {
					    rdObjects[0].CMPrint();
					}
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
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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
                    InsertTab( cnt++, "All",      -1 );
                    InsertTab( cnt++, "Fax/EDI",       -1 );
                    InsertTab( cnt++, "Customs",       -1 );
                   // InsertTab( cnt++, "Documentation", -1 );
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        
        initControl();
        
        //RD 초기화
        initRdConfig(rdObjects[0]);   
        
        for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        //---------------
        //IBMultiCombo 초기화
        for(var j=0;j<comboObjects.length;j++){
            initCombo(comboObjects[j],j+1);
        }
        
        //initParam();  //form 객체에 한번만
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
    }

    function initCombo(comboObj, comboNo) {
     	with (comboObj) {
     		MultiSeparator = "|";
         }
    }
    
    function initControl() {
    	var formObject = document.form;

//        axon_event.addListenerForm('beforedeactivate', 'bkg0566_deactivate',  formObject); //- 포커스 나갈때
//        axon_event.addListenerFormat('beforeactivate', 'bkg007901_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListenerForm('click', 'bkg0566_click',    formObject); //- 클릭시
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		switch(sheetObj.id) {
	        case "t1sheet1":      //t1sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 390;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly+ msPrevColumnMerge;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(13, 3, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false)

		            var HeadTitle = "|Item|Item|Now Read|Previous|User Name|Office|Date(Local)|Date(GMT)||||HIS_DTL_SEQ";
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHidden,    110,   daLeft,  	 true,    "his_seq",      false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 110,   daLeft,  	 true,    "item_hdr",     false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,  	 true,    "his_cate_nm",  false,   "",      dfNone, 		0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 210,   daLeft,  	 false,   "crnt_ctnt",    false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 180,   daLeft,      false,   "pre_ctnt",     false,   "",      dfNone, 		0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,    daCenter,    false,   "cre_usr_id",   false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 60,    daCenter,    false,   "office",       false,   "",      dfNone, 		0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,    daCenter,    false,   "cre_dt",       false,   "",      dfNone, 		0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,    daCenter,    false,   "gmt_dt",       false,   "",      dfNone, 		0,     true,       true);
		            
		            InitDataProperty(0, cnt++ , dtHidden,  	 0,   daLeft,  	 false,   "crnt_ctnt_org",   false,   "",      dfNone,      0,     false,       false);
		            InitDataProperty(0, cnt++ , dtHidden,  	 0,   daLeft,      false,   "pre_ctnt_org",    false,   "",      dfNone, 		0,     false,       false);
		            InitDataProperty(0, cnt++ , dtHidden,  	 0,   daLeft,      false,   "corr_no",   		 false,   "",      dfNone, 		0,     false,       false);		            
		            InitDataProperty(0, cnt++ , dtHidden,  	 0,   daLeft,      false,   "his_dtl_seq",   		 false,   "",      dfNone, 		0,     false,       false);

					//InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );
					CountPosition = 0;
		        }
		        break;
	
			case "t2sheet1":      //t2sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 390;
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
		
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(9, 1, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false)
		            
		            var HeadTitle = " |From|From|To|To|Via|Date|User|Office";
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtData,   	 210,   daLeft,  	 true,    "item",     	  false,          "",      dfNone,          0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daLeft,  	 false,   "frm_a",        false,          "",      dfNone, 			0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daLeft,  	 false,   "frm_b",        false,          "",      dfNone,          0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daLeft,  	 false,   "to_a",   	  false,          "",      dfNone, 			0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   	daLeft, 	 false,   "to_b",   	  false,          "",      dfNone,          0,     true,       true);		
		            InitDataProperty(0, cnt++ , dtData,   	 70,    daCenter,    false,   "via",          false,          "",      dfNone, 			0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daCenter,    false,   "cre_dt",       false,          "",      dfNone,          0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daLeft,      false,   "cre_usr_id",   false,          "",      dfNone, 			0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daLeft,      false,   "office",       false,          "",      dfNone, 			0,     true,       true);
		
		            //InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );
					CountPosition = 0;		
		        }
		        break;
	
		    case "t3sheet1":      //t3sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 390;
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
		
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(7, 2, 0, true);		            
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false)

		            var HeadTitle = "Port|Port|Customs Status|Date(Local)|Date(GMT)|User|Office";
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtData,   	 110,    daCenter, 	true,    "port",   	    	false,    "",      dfNone, 			0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 150,    daLeft,  	true,    "port_nm",         false,    "",      dfNone,          0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 250,    daLeft,	false,   "cust_status_nm",  false,    "",      dfNone, 			0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 120,    daCenter,  false,   "mf_snd_dt",       false,    "",      dfNone,          0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 120,    daCenter,  false,   "gmt_dt",       false,    "",      dfNone,          0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 110,    daCenter,  false,   "cre_usr_id",   	false,    "",      dfNone, 			0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 120,    daLeft,    false,   "ofc_nm", 	        false,    "",      dfNone, 			0,     true,       true);
		
					//InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );  //dfUserFormat2
					CountPosition = 0;
		        }
		        break;
		        
			case "t4sheet1":      //t4sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 390;
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
		
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(7, 1, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false)
			
		            var HeadTitle = "Documentation|Date(Local)|Date(GMT)|Office|User|Remark|Reason";
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtData,   	 255,   daLeft,  	 true,    "item",          false,    "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,  	 false,   "cre_dt",   	   false,    "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,  	 false,   "gmt_dt",   	   false,    "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 70,   	daCenter,  	 false,   "office",   	   false,    "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 110,   daLeft,  	 false,   "cre_usr_id",    false,    "",      dfNone, 		  0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 140,   daLeft,  	 false,   "remark",   	   false,    "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 110,   daLeft,  	 false,   "reason",   	   false,    "",      dfNone,         0,     true,       true);
		
					//InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );
					CountPosition = 0;
		        }
		        break; 
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
      	    case IBSEARCH: 
      	    	if (sheetObj.id=="t1sheet1") {
	      	    	formObj.f_cmd.value = SEARCH;
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0566GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
					//if(ComGetEtcData(arrXml[0], "DataYn") == "N") {
					//	ComShowCodeMessage("BKG00095");
					//}
					
		            if (arrXml.length > 0) 
					{
		                ComBkgXml2ComboItem(arrXml[1], formObj.search_by_item, "ud_nm", "ui_id");
		                formObj.search_by_item.Text = "All";
		              
		                arrXml[0] = "<?xml version='1.0' ?>" + arrXml[0];
		                sheetObjects[0].LoadSearchXml(arrXml[0]);  
		                setEtcDataToForm_bkg(formObj, sheetObjects[0]);  
		            }
      	    	} else if (sheetObj.id=="t2sheet1") {
      	    		formObj.f_cmd.value = SEARCH02;
 	          		sheetObj.DoSearch("ESM_BKG_0566GS.do", FormQueryString(formObj));
      	    	} else if (sheetObj.id=="t3sheet1") {
      	    		formObj.f_cmd.value = SEARCH03;
 	          		sheetObj.DoSearch("ESM_BKG_0566GS.do", FormQueryString(formObj));
      	    	} else if (sheetObj.id=="t4sheet1") {
      	    		formObj.f_cmd.value = SEARCH04;
 	          		sheetObj.DoSearch("ESM_BKG_0566GS.do", FormQueryString(formObj));
      	    	}
                break;
        }
    }

    
    //######################[1. Event]############################################################    
    /**
     * t1sheet1 조회완료 후 처리 
     */    
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;
    	if (sheetObj.SearchRows>0) {
    		sheetObj.Redraw = false;
    		sheetObj.ColBackColor("item_hdr")    = sheetObj.HeadBackColor;  
    		sheetObj.ColBackColor("his_cate_nm") = sheetObj.HeadBackColor;
    		
    		for (var i=1; i<=sheetObj.RowCount; i++) {
        		if (sheetObj.CellValue(i, "crnt_ctnt") == "View Detail") {
	    			sheetObj.CellFontUnderline(i, "crnt_ctnt") = true;	    			
	    		}
	    		if (sheetObj.CellValue(i, "pre_ctnt") == "View Detail") {
	    			sheetObj.CellFontUnderline(i, "pre_ctnt") = true;	 	    			
	    		}
	    		if (sheetObj.CellValue(i, "his_seq") == "999999") {
	    			sheetObj.CellBackColor(i,"item_hdr") = 	 sheetObj.RgbColor(246, 225, 236);
	    			sheetObj.CellBackColor(i,"his_cate_nm") = 	sheetObj.RgbColor(246, 225, 236);
	    		}
    		}
    		sheetObj.Redraw = true;
    	}	
    	xSearchTab1 = true;
    }    
    /**
    * t1sheet1 OnClick시 View Detail popup 처리  
    */
    function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
    	var formObj = document.form;
    	
    	var colId = sheetObj.ColSaveName(Col);
    	if (colId == "crnt_ctnt" || colId == "pre_ctnt") {
    		if (Value == "View Detail") {
    			var bkgNo     = formObj.bkg_no.value; 
	    		var blNo      = formObj.bl_no.value; 
	    		var hisCateNm = sheetObj.CellValue(Row, "his_cate_nm");
	    		var crntCtnt  = sheetObj.CellValue(Row, "crnt_ctnt_org"); 
	    		var preCtnt   = sheetObj.CellValue(Row, "pre_ctnt_org"); 
	    		var creUsrId  = sheetObj.CellValue(Row, "cre_usr_id"); 
	    		
	    		var office    = sheetObj.CellValue(Row, "office"); 
	    		var creDt     = sheetObj.CellValue(Row, "cre_dt"); 
	    		comBkgCallPop0955('setHistoryDtlViewCallBack', bkgNo, blNo, hisCateNm, crntCtnt, preCtnt, creUsrId, office, creDt);	
    		}
    	} 
    }
    
    /**
    * t2sheet1 조회완료 후 처리 
    */    
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj = document.form;
	   	if (sheetObj.SearchRows>0) {
	   		sheetObj.Redraw = false;
	   		sheetObj.ColBackColor("item") = sheetObj.HeadBackColor;  
	   		sheetObj.Redraw = true;
	   	}
	   	xSearchTab2 = true;
    }
    /**
    * t3sheet1 조회완료 후 처리 
    */    
    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj = document.form;
	   	if (sheetObj.SearchRows>0) {
	   		sheetObj.Redraw = false;
	   		sheetObj.ColBackColor("port_a") = sheetObj.HeadBackColor;  
	   		sheetObj.ColBackColor("port_b") = sheetObj.HeadBackColor;
	   		sheetObj.Redraw = true;
	   	}	
	   	xSearchTab3 = true;
    }
    /**
    * t4sheet1 조회완료 후 처리 
    */    
    function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj = document.form;
	   	if (sheetObj.SearchRows>0) {
	   		sheetObj.Redraw = false;
	   		sheetObj.ColBackColor("item") = sheetObj.HeadBackColor;
	   		sheetObj.Redraw = true;
	   	}	
	   	xSearchTab4 = true;
    } 
    
    /**
    * Tro master : search_by_item 콤보 선택변경시, 이벤트처리
    */
    function search_by_item_OnChange(comboObj, idx_cd, text) {    	
    	var formObj  = document.form; 
    	var sheetObj = sheetObjects[0]; 

    	with(sheetObj) {
    		Redraw = false;
	    	for (var i=1; i<=RowCount; i++) {
	    		if ("All" == text) {
	    			RowHidden(i) = false;
	    		} else if (CellValue(i, "item_hdr") == text) {
	    		    RowHidden(i) = false;
	    		} else {
	    			RowHidden(i) = true;
	    		}
	    	}
	    	Redraw = true;
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
	
		//--------------- 요기가 중요 ----------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab = nItem;

		if (tabObjects[0].selectedIndex == 1) {
            if (!xSearchTab2) {
            	doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);  
            }
            formObj.search_by_item.Enable = false;
		} else if (tabObjects[0].selectedIndex == 2) {
            if (!xSearchTab3) {
            	doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);  
            }
            formObj.search_by_item.Enable = false;
		} else if (tabObjects[0].selectedIndex == 3) {
            if (!xSearchTab4) {
            	doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);  
            }
            formObj.search_by_item.Enable = false;
//		} else {
//            if (!xSearchTab1&&loadPage) {
//            	alert("tabOnchange");
//            	doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);  
//            }
//            formObj.search_by_item.Enable = true;
		} else{
			formObj.search_by_item.Enable = true;
		}
	} 
	
	
	//######################[2. Etc]##############################################################
    /**
    * Header 출력(Booking 정보) 
    * : ComEtcDataToForm()함수대신, EtcData를 화면에 View 
    */
    function setEtcDataToForm_bkg(formObj, sheetObj) {
        //------------------------------
        //sheetEtcData -> Form 
        //IBS_EtcDataToForm(formObj, sheetObj);
        with (formObj) 
        {
        	bkg_no.value       = sheetObj.EtcData("bkg_no"); 	        
        	n1st_vvd.value     = sheetObj.EtcData("n1st_vvd"); 
        	trnk_vvd.value     = sheetObj.EtcData("trnk_vvd"); 
        	bl_no.value        = sheetObj.EtcData("bl_no"); 
        	n1st_pol.value     = sheetObj.EtcData("n1st_pol"); 
        	trnk_pol.value     = sheetObj.EtcData("trnk_pol"); 
        	port_closing.value = sheetObj.EtcData("port_closing"); 
        	n1st_etb.value     = sheetObj.EtcData("n1st_etb"); 
        	trnk_etb.value     = sheetObj.EtcData("trnk_etb"); 	        
        	bdr_dt.value       = sheetObj.EtcData("bdr_dt"); 
        	n1st_etd.value     = sheetObj.EtcData("n1st_etd");
        	trnk_etd.value     = sheetObj.EtcData("trnk_etd");
        }        
    }
	
	/**
	 * Booking History : Detail View 팝업 호출. <br>
	 */
	function comBkgCallPop0955(callback_func, bkgNo, blNo, hisCateNm, crntCtnt, preCtnt, creUsrId, office, creDt) {
		
		var param = "?bkg_no="+bkgNo
		          + "&bl_no="+blNo
		          + "&his_cate_nm="+hisCateNm
		          + "&crnt_ctnt="+crntCtnt
		          + "&pre_ctnt="+preCtnt
		          + "&cre_usr_id="+creUsrId
		          + "&office="+office
		          + "&cre_dt="+creDt;		
		var sUrl  = "ESM_BKG_0955.do"+param;
       
        ComOpenWindowCenter(sUrl, "ESM_BKG_0955", 740, 410, true); 
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
		var RdViewer = rdObjects[0];
		
		var rdUrl      = "apps/alps/esm/bkg/bookingconduct/generalbookingconduct/generalbookingsearch/report/";
		var rdOption   = " /riprnmargin";   //' /rwait'
		var rdFileName = "";
		var rdParam    = "";		

		if (tabObjects[0].selectedIndex == 1) {
			rdFileName = "ESM_BKG_0800.mrd";
			rdParam    = "/rv BKG_NO['"+formObj.bkg_no.value+"']";
		} else if (tabObjects[0].selectedIndex == 2) {
			rdFileName = "ESM_BKG_0801.mrd";
			rdParam    = "/rv BKG_NO['"+formObj.bkg_no.value+"']";
		} else if (tabObjects[0].selectedIndex == 3) {
			rdFileName = "ESM_BKG_0802.mrd";
			/*formObj.com_mrdPath.value      = rdUrl + rdFileName;
			formObj.com_mrdArguments.value = "/rp ['"+formObj.bkg_no.value+"']";
			ComOpenRDPopup();
			return true;*/
			
			rdParam    = "/rp ['"+formObj.bkg_no.value+"']";
		} else {
			rdFileName = "ESM_BKG_0799.mrd";
			rdParam    = "/rv BKG_NO['"+formObj.bkg_no.value+"'] ATTR_CTNT_2['"+formObj.search_by_item.Text+"']";
			/*
			formObj.com_mrdPath.value      = rdUrl + rdFileName;
			formObj.com_mrdArguments.value = "/rp ['"+formObj.bkg_no.value+"'] ['"+formObj.search_by_item.Text+"']";
			ComOpenRDPopup();
			return true;*/
			
		}
		RdViewer.FileOpen(RD_path + rdUrl + rdFileName, RDServer + rdParam + rdOption); 
		
		return true;
	}	
	 
	 function bkg0566_click(){
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0]; 
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	
    	if(srcName == "ca_only"){
        	with(sheetObj) {
        		Redraw = false;
    	    	for (var i=1; i<=RowCount; i++) {
    	    		if (CellValue(i, "corr_no").length == 0) {
        	    		if(ComGetObjValue(formObj.ca_only) == "Y"){
	    	    		    RowHidden(i) = true;
	    	    		} else {
	    	    			RowHidden(i) = false;
	    	    		}
    	    		} else {
        	    		if(ComGetObjValue(formObj.ca_only) == "Y"){
	    	    		    RowHidden(i) = false;
	    	    		} else {
	    	    			RowHidden(i) = true;
	    	    		}
    	    			
    	    		}
    	    	}
    	    	Redraw = true;
        	}    		
    	}
	 }
	 
	 function getViewDetail(obj){
		 var sheetObj = sheetObjects[0]; 
		 var iRow = sheetObj.SelectRow;
 		 var crntCtnt  = sheetObj.CellValue(iRow, obj); 
		 return crntCtnt;
	 }
	 
	/* 개발자 작업  끝 */