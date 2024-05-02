/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1951.js
*@FileTitle : OP Inventory for Pseudo Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.01
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2013.07.01 이영두
* 1.0 Creation
=========================================================*/
    /**
     * @extends 
     * @class EES_CIM_1951 : EES_CIM_1951 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CIM_1951() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
    }
    
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
 
    var comboObjects = new Array();
    var comboCnt = 0 ;


 	var IBSEARCH01  = 29;
 	var IBSEARCH02  = 30;
 	var IBSEARCH03  = 31;
 	var IBSEARCH04  = 32;
 	var IBSEARCH05  = 33;
 	var IBSEARCH06  = 34;
 	var IBSEARCH07  = 35;
 
    var totHeadCount = 0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var shtCnt = 0;
        var sheetObject1 = sheetObjects[shtCnt++];
        var sheetObject2 = sheetObjects[shtCnt++];

        /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
        	var row;
        	var titleFlag = '';
        	var rsheetObjects;
        	if ( beforetab == 0 ) {	  //1번째 탭에서 조회
        		row = sheetObjects[0].RowCount;
        		rsheetObjects = sheetObjects[0];
        	} else if ( beforetab == 1 ) {	  //2번째 탭에서 조회
        		row = sheetObjects[1].RowCount;
        		rsheetObjects = sheetObjects[1];
        	}
			switch(srcName) {

				case "btn_Retrieve":
					if ( beforetab == 0 ) {	  //첫번째 탭에서 조회
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
						doActionIBSheet(sheetObjects[1],formObject,IBSEARCH02);
					}
					break;

				case "btn_new":
		        	formObject.reset();

					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
						
					break;

				case "btn_downexcel":
					doActionIBSheet(rsheetObjects,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_rhq_cd":	//RHQ 조회 팝업
					ComOpenPopup("COM_ENS_071.do", 1000, 470, "setRhqCd", "1,0,1,1,1", false, false, null, null, null, "COM_ENS_071");
						
					break;
		            
				case "btn_bkg_ofc_cd":	//Booking Office 조회 팝업
					ComOpenPopup("COM_ENS_071.do", 1000, 470, "setBkgOfcCd", "1,0,1,1,1", false, false, null, null, null, "COM_ENS_071");
     						
					break;
					
				case "btn_cust_cd":	//Customer Code 조회 팝업
					ComOpenPopup("COM_ENS_041.do", 1000, 430, "setCustCd", "1,0,1,1,1", false, false, null, null, null, "COM_ENS_041");

					break; 		
					
				case "btn_op_loc_cd":	//OP Location 조회 팝업
					ComOpenPopup("COM_ENS_051.do", 1000, 430, "setOpLocCd", "1,0,1,1,1", false, false, null, null, null, "COM_ENS_051");

					break;

			} // end switch
			

     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

    	for(i=0;i<sheetObjects.length;i++){
         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    	
    	for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        initControl();
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
    * 초기 이벤트 등록 
    */
    function initControl() {
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');							//엔터키 조회 이벤트처리
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			//form OnBeforeDeactivate이벤트에 코드 처리
    	axon_event.addListenerForm('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
    	axon_event.addListenerFormat('blur', 'obj_blur', form);
    }

    /**
     * beforeactivate 이벤트 처리
     * beforeactivate -없애기
     */    
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	/**
	 * beforedeactivate 이벤트 처리
	 * beforedeactivate YYYY-MM 포멧 처리
	 */	
	function obj_deactivate() {
		ComClearSeparator(event.srcElement);
	}



	/**
     * 키이벤트 등록
    */  
 	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "rhq_cd":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
				break;
			case "bkg_ofc_cd":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
				break;
			case "bkg_no":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "cust_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "cust_nm":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;				
			case "op_loc_cd":
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
				break;
			case "stay_days":
				ComKeyOnlyNumber(event.srcElement);// 숫자만 입력허용
				break;
		}
	} 
 	
 	
	/**
	 * OP Location  blur 이벤트 처리
	 * OP Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		switch (event.srcElement.name) {
			case "rhq_cd":
				if ( document.form.rhq_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH03);
				}
				break;
			case "op_loc_cd":
				if ( document.form.op_loc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH04);
				}
				break;
			case "bkg_ofc_cd":
				if ( document.form.bkg_ofc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH05);
				}
				break;
			case "bkg_no":
				if ( document.form.bkg_no.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH06);
				}
				break;
			case "cust_cd":
				if ( document.form.cust_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH07);
				}
				break;				
		}
	}
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	
    	var cnt = 0;
    	var shtID = sheetObj.id;

    	switch(shtID) {
    		case "sheet1":      //sheet1 init
    			with (sheetObj) {

    				// 높이 설정
    				style.height = 345;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
    				
    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				
    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msPrevColumnMerge + msHeaderOnly;
    				
                    //전체Edit 허용 여부 [선택, Default false]
    				Editable = false;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(2, 1, 20, 100);
    				
    				var HeadTitle1 = "RHQ|Booking\nOffice|Sales Rep.|Customer CD|Customer Name|TP/SZ|Total|Total|31 or Over|31 or Over|31 or Over|1~15|1~15|1~15|16~30|16~30|16~30|31~60|31~60|31~60|61~120|61~120|61~120|121~180|121~180|121~180|181~365|181~365|181~365|366 or Over|366 or Over|366 or Over|";
    				var HeadTitle2 = "RHQ|Booking\nOffice|Sales Rep.|Customer CD|Customer Name|TP/SZ|CNTR|AVG|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|";
    				
    				var headCount = ComCountHeadTitle(HeadTitle1);
    				totHeadCount = headCount;
    				
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(false, false, false, true, false,false);
    				
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
    				InitHeadRow(1, HeadTitle2, true);
    				
    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtAutoSum,	70,	  daCenterTop,	true,	"rhq_cd",			false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtAutoSum,	70,	  daCenterTop,	true,	"bkg_ofc_cd",		false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtAutoSum,	70,	  daCenter,		true,	"ob_srep_cd",		false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtAutoSum,	80,	  daCenter,		true,	"cust_cd",			false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtAutoSum,	200,  daLeftTop,	true,	"cust_nm",			false,	"",	dfNone);
    				
    				InitDataProperty(0, cnt++ , dtData,		60,   daCenter, 	true,	"cntr_tpsz_cd",   	false,	"",	dfNone);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"total_qty",    	false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"total_avg",     	false,	"",	dfNullInteger);
    				
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"over_qty",   		false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"over_avg",    		false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"over_rate",		false,	"",	dfNone,	1);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty1",   			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg1",    			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate1",			false,	"",	dfNone,	1);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty2",   			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg2",    			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate2",			false,	"",	dfNone,	1);

    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty3",   			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg3",    			false,	"",	dfNullInteger);
    				InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate3",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty4",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg4",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate4",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty5",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg5",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate5",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty6",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg6",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate6",			false,	"",	dfNone,	1);

                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"qty7",   			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"avg7",    			false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,		60,   daRight,  	true,	"rate7",			false,	"",	dfNone,	1);
                    InitDataProperty(0, cnt++ , dtHidden,	60,   daRight,  	true,	"lvl",				false,	"",	dfNone,	1);
                     
                    SetSortDialog(false);
                    CountPosition = 0;
                    SelectHighLight = false;
                    FrozenCols = 6;
                }
    	        break;

    		case "sheet2":      //sheet1 init
    			with (sheetObj) {

    				// 높이 설정
    				style.height = 345; 	
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
    				
    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				
    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msNone;
    				
                    //전체Edit 허용 여부 [선택, Default false]
    				Editable = false;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 10, 100);
    				
    				var HeadTitle = "RHQ\nOffice|Booking\nOffice|Sales Rep.|Customer CD|Customer Name|Booking\nNumber|Container No|TP/SZ|OP Location\nYard Code|OP Location\nYard Name|Staying\nDays";
    				
    				var headCount = ComCountHeadTitle(HeadTitle);
    				//totHeadCount = headCount;
    				
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
    				
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false,false)
    				
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				
    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtData,  	100,   daCenter,	true,	"rhq_cd",		false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		100,   daCenter,    true,	"bkg_ofc_cd",   false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		100,   daCenter, 	true,	"ob_srep_cd",   false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		100,   daCenter, 	true,	"cust_cd",   	false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		200,   daLeft, 		true,	"cust_nm",   	false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		100,   daCenter, 	true,	"bkg_no",   	false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		100,   daCenter, 	true,	"cntr_no",   	false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		100,   daCenter, 	true,	"cntr_tpsz_cd", false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		100,   daCenter, 	true,	"yd_cd",   		false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		300,   daLeft, 		true,	"yd_nm",   		false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,		60,    daRight, 	true,	"stay_days",   	false,	"",	dfNone);
    				                     
                    SetSortDialog(false);
                    CountPosition = 2;
                    SelectHighLight = false;
    			}
    	        break;
                 
         	}
    }

	/**
     * Sheet관련 프로세스 처리
    */  
    function doActionIBSheet(sheetObj,formObj,sAction) {
//    	 sheetObj.ShowDebugMsg = true;
         switch(sAction) {

         	case IBSEARCH:      //Summary
         		sheetObj.RemoveAll();
         		
         		if(!validateForm(sheetObj,formObj,sAction)) return;
         		
         		sheetObj.CellValue(0,8) = form.stay_days.value+" or Over";
         		sheetObj.CellValue(0,9) = form.stay_days.value+" or Over";
         		sheetObj.CellValue(0,10) = form.stay_days.value+" or Over";  
         			
	            formObj.f_cmd.value = SEARCH;
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true); 
	            //alert("test"+ FormQueryString(formObj));
	            sheetObj.DoSearch("EES_CIM_1951GS.do",FormQueryString(formObj));
	
	            ComOpenWait(false); 
         		break;

         	case IBSEARCH02:      //Detail
         		sheetObj.RemoveAll();
         		
         		if(!validateForm(sheetObj,formObj,sAction)) return;
        		
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true); 

	            formObj.f_cmd.value = SEARCH02;
		        sheetObj.DoSearch("EES_CIM_1951GS.do",FormQueryString(formObj));
		        ComOpenWait(false); 
         		break; 
         		
    		case IBSEARCH03: //RHQ  focusOut
    			formObj.inquiryLevel.value = "W";
    			formObj.location.value = formObj.rhq_cd.value;
    			
    			formObj.f_cmd.value = SEARCH04;
    			if (formObj.rhq_cd.value == "") {
    				return false;
    			}
    			
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.WaitImageVisible = false;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck = ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.rhq_cd.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.rhq_cd.value = "";
    					ComSetFocus(document.form.rhq_cd);
    					return false;
    				} else {
    					return true;
    				}
    			} else {
    				ComSetFocus(document.form.bkg_ofc_cd);
    			}
    	
    			break;
         		
    		case IBSEARCH04: //OP Location focusOut
    			formObj.inquiryLevel.value = "V";
    			formObj.location.value = formObj.op_loc_cd.value;
    			
    			formObj.f_cmd.value = SEARCH04;
    			if (formObj.op_loc_cd.value == "") {
    				return false;
    			}
    			
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.WaitImageVisible = false;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck = ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.op_loc_cd.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.op_loc_cd.value = "";
    					ComSetFocus(document.form.op_loc_cd);
    					return false;
    				} else {
    					return true;
    				}
    			} else {
    				ComSetFocus(document.form.cust_cd);
    			}
    	
    			break;
   		
    		case IBSEARCH05: //Booking Office  focusOut
    			formObj.inquiryLevel.value = "K";
    			formObj.location.value = formObj.bkg_ofc_cd.value;
    			
    			formObj.f_cmd.value = SEARCH04;
    			if (formObj.bkg_ofc_cd.value == "") {
    				return false;
    			}
    			
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.WaitImageVisible = false;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck = ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.bkg_ofc_cd.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.bkg_ofc_cd.value = "";
    					ComSetFocus(document.form.bkg_ofc_cd);
    					return false;
    				} else {
    					return true;
    				}
    			} else {
    				ComSetFocus(document.form.bkg_no);
    			}
    	
    			break;
    			
    		case IBSEARCH06: //Booking Number  focusOut
    			formObj.inquiryLevel.value = "B";
    			formObj.location.value = formObj.bkg_no.value;
    			
    			formObj.f_cmd.value = SEARCH04;
    			if (formObj.bkg_no.value == "") {
    				return false;
    			}
    			
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.WaitImageVisible = false;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck = ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.bkg_no.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.bkg_no.value = "";
    					ComSetFocus(document.form.bkg_no);
    					return false;
    				} else {
    					return true;
    				}
    			} else {
    				ComSetFocus(document.form.op_loc_cd);
    			}
    	
    			break;
    		
    		case IBSEARCH07: //Customer Code  focusOut
    			formObj.inquiryLevel.value = "U";
    			formObj.location.value = formObj.cust_cd.value;
    			
    			formObj.f_cmd.value = SEARCH04;
    			if (formObj.cust_cd.value == "") {
    				return false;
    			}
    			
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.WaitImageVisible = false;
    			var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck = ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.cust_cd.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.cust_cd.value = "";
    					ComSetFocus(document.form.cust_cd);
    					return false;
    				} else {
    					return true;
    				}
    			} else {
    				ComSetFocus(document.form.stay_days);
    			}
    	
    			break;
    			
            case IBDOWNEXCEL:      // 입력
            	if ( sheetObj.rowCount != 0 ) {
          	  		sheetObj.Down2Excel(-1, false, false, true);
            	} else {
            		ComShowMessage(msgs["CIM30008"]);	//No data found
            		return;
            	}
          	  	break;
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    	case 1:
    		with (tabObj) {
    			var cnt  = 0 ;
    			InsertTab( cnt++ , "Summary" , -1 );
    			InsertTab( cnt++ , "Detail" , -1 );
    		}
    		break;
    	 }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

     	objs[nItem].style.display = "Inline";
     	objs[beforetab].style.display = "none";

     	//--------------- 요기가 중요 --------------------------//
     	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab= nItem;
    }

     /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 data 조회한다.
     */
    function tab1_OnClick(tabObj , nItem)
    {
//    	if ( nItem == 0 ) {
// 		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//     	} else if ( nItem == 1 ) {
// 			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
//     	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj, formObj, sAction) {

		with (formObj) {

		}

		return true;
	}

    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet2_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }
    
    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	if ( sheetObj.rowCount != 0 ) {
    		with(sheetObj)
    		{
    			for(var i = 1; i <= LastRow; i ++)
    			{
    				var lvl = CellValue(i, "lvl");
    				if ( lvl == '000111' ) {
    					sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
    				}
    			}
    			for ( var j=0; j<totHeadCount; j++ ) {
    				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
    			}
    			sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
    			sheetObj.RowDelete(sheetObj.LastRow-1 , false);
    			
    			sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
    			sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 6);
    		}
    		sheetObj.SelectHighLight = false;
    	}
    	sheetObj.Redraw = true;
    }

    
	/**
	 * Location 팝업창에서 선택한 Location Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setOpLocCd(aryPopupData){
        form.op_loc_cd.value = aryPopupData[0][3];
        form.btn_op_loc_cd.checked = true;
	}
	
    
	/**
	 * Booking Office 팝업창에서 선택한 Booking Office Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setBkgOfcCd(aryPopupData){
        form.bkg_ofc_cd.value = aryPopupData[0][3];
        form.btn_bkg_ofc_cd.checked = true;
	}
    
	/**
	 * Booking Office 팝업창에서 선택한 Booking Office Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setRhqCd(aryPopupData){
        form.rhq_cd.value = aryPopupData[0][3];
        form.btn_rhq_cd.checked = true;
	}
	
	/**
	 * Customer  팝업창에서 선택한 Customer Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setCustCd(aryPopupData){
        form.cust_cd.value = aryPopupData[0][3];
        form.btn_cust_cd.checked = true;
	}