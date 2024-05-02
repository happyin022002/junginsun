/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1951.js
*@FileTitle  : OP Inventory for Pseudo Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
    /**
     * @extends 
     * @class EES_CIM_1951 : EES_CIM_1951 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CIM_1951() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    	this.sheet1_OnSearchEnd=sheet1_OnSearchEnd;
    }
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0 ;
 	var IBSEARCH01=29;
 	var IBSEARCH02=30;
 	var IBSEARCH03=31;
 	var IBSEARCH04=32;
 	var IBSEARCH05=33;
 	var IBSEARCH06=34;
 	var IBSEARCH07=35;
    var totHeadCount=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var shtCnt=0;
        var sheetObject1=sheetObjects[shtCnt++];
        var sheetObject2=sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
        	var row;
        	var titleFlag='';
        	var rsheetObjects;
        	if ( beforetab == 0 ) {	  //1번째 탭에서 조회
        		row=sheetObjects[0].RowCount();
        		rsheetObjects=sheetObjects[0];
        	} else if ( beforetab == 1 ) {	  //2번째 탭에서 조회
        		row=sheetObjects[1].RowCount();
        		rsheetObjects=sheetObjects[1];
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
					
					tabObjects[0].SetSelectedIndex(0);
					break;
				case "btn_downexcel":
					doActionIBSheet(rsheetObjects,formObject,IBDOWNEXCEL);
					break;
				case "btn_rhq_cd":	//RHQ 조회 팝업
					ComOpenPopup("COM_ENS_071.do", 1000, 520, "setRhqCd", "1,0,1,1,1", true, false, null, null, null, "COM_ENS_071");
					break;
				case "btn_bkg_ofc_cd":	//Booking Office 조회 팝업
					ComOpenPopup("COM_ENS_071.do", 1000, 520, "setBkgOfcCd", "1,0,1,1,1", true, false, null, null, null, "COM_ENS_071");
					break;
				case "btn_cust_cd":	//Customer Code 조회 팝업
					ComOpenPopup("COM_ENS_041.do", 1000, 490, "setCustCd", "1,0,1,1,1", true, false, null, null, null, "COM_ENS_041");
					break; 		
				case "btn_op_loc_cd":	//OP Location 조회 팝업
					ComOpenPopup("COM_ENS_051.do", 1000, 460, "setOpLocCd", "1,0,1,1,1", true, false, null, null, null, "COM_ENS_051");
					break;
			} // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
    	resizeSheet();
    	for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
        initControl();
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
    */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
    * 초기 이벤트 등록 
    */
    function initControl() {
        //axon_event.addListener('keydown', 'ComKeyEnter', 'form');							//엔터키 조회 이벤트처리
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			//form OnBeforeDeactivate이벤트에 코드 처리
    	//axon_event.addListenerForm('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
    	axon_event.addListenerFormat('blur', 'obj_blur', form);
    }
    /**
     * beforeactivate 이벤트 처리
     * beforeactivate -없애기
     */    
	function obj_activate() {
		ComClearSeparator(ComGetEvent());
	}
	/**
	 * beforedeactivate 이벤트 처리
	 * beforedeactivate YYYY-MM 포멧 처리
	 */	
	function obj_deactivate() {
		ComClearSeparator(ComGetEvent());
	}
	/**
     * 키이벤트 등록
    */  
// 	function obj_keypress() {
//		var formObject=document.form;
//		switch (ComGetEvent().name) {
//			case "rhq_cd":
//				ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
//				break;
//			case "bkg_ofc_cd":
//				ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
//				break;
//			case "bkg_no":
//				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
//				break;
//			case "cust_cd":
//				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
//				break;
//			case "cust_nm":
//				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
//				break;				
//			case "op_loc_cd":
//				ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
//				break;
//			case "stay_days":
//				ComKeyOnlyNumber(ComGetEvent());// 숫자만 입력허용
//				break;
//		}
//	} 
	/**
	 * OP Location  blur 이벤트 처리
	 * OP Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		switch (ComGetEvent("name")) {
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
    	var cnt=0;
    	var shtID=sheetObj.id;
    	switch(shtID) {
    		case "sheet1":      //sheet1 init
    		    with(sheetObj){
    	       
    	      var HeadTitle1="RHQ|Booking\nOffice|Sales Rep.|Customer CD|Customer Name|TP/SZ||Total|Total|31 or Over|31 or Over|31 or Over|1~15|1~15|1~15|16~30|16~30|16~30|31~60|31~60|31~60|61~120|61~120|61~120|121~180|121~180|121~180|181~365|181~365|181~365|366 or Over|366 or Over|366 or Over|";
    	      var HeadTitle2="RHQ|Booking\nOffice|Sales Rep.|Customer CD|Customer Name|TP/SZ||CNTR|AVG|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|CNTR|AVG|%|";
    	      var headCount=ComCountHeadTitle(HeadTitle1);
    	      totHeadCount=headCount;
    	      (headCount, 0, 0, true);

    	      SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:7, Page:20, DataRowMerge:0 , PrevColumnMergeMode:0} );

    	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	      
    	      var headers = [ { Text:HeadTitle1, Align:"Center"},
    	                  { Text:HeadTitle2, Align:"Center"} ];
    	      InitHeaders(headers, info);

    	      var cols = [ {Type:"Text",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",   Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ob_srep_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",   Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",       KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"AutoSum",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"lvl1",           KeyField:0,   CalcLogic:"",   Format:""} ,
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"total_avg",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"over_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"over_avg",      KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"over_rate",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty1",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg1",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg2",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty3",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg3",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg4",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg5",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate5",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty6",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg6",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate6",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"avg7",          KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rate7",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
    	             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"lvl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 } ];
    	       
    	      InitColumns(cols);
    	      //SetSheetHeight(345);
    	      ComResizeSheet(sheetObj);
    	      SetEditable(0);
    	      //FrozenCols=6;
    	      SetMergeCell(0, 0, 2, 1);
    	      SetMergeCell(0, 1, 2, 1);
    	      SetMergeCell(0, 2, 2, 1);
    	      SetMergeCell(0, 3, 2, 1);
    	      SetMergeCell(0, 4, 2, 1);
    	      SetMergeCell(0, 5, 2, 1);
    	      }


    	        break;
    		case "sheet2":      //sheet1 init
    		    with(sheetObj){
    	       
    	      var HeadTitle="RHQ\nOffice|Booking\nOffice|Sales Rep.|Customer CD|Customer Name|Booking\nNumber|Container No|TP/SZ|OP Location\nYard Code|OP Location\nYard Name|Staying\nDays";
    	      var headCount=ComCountHeadTitle(HeadTitle);
    	      (headCount, 0, 0, true);

    	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

    	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
    	      InitHeaders(headers, info);

    	      var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ob_srep_cd",    KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",       KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"yd_nm",         KeyField:0,   CalcLogic:"",   Format:"" },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"stay_days",     KeyField:0,   CalcLogic:"",   Format:"" } ];
    	       
    	      InitColumns(cols);
    	      SetSheetHeight(365);
    	      //resizeSheet();
    	      SetEditable(0);
    	            }


    	        break;
         	}
    }
    // Sheet의 높이 자동으로 변경
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }
	/**
     * Sheet관련 프로세스 처리
    */  
    function doActionIBSheet(sheetObj,formObj,sAction) {
//    	 sheetObj.ShowDebugMsg = true;
         switch(sAction) {
         	case IBSEARCH:      //Summary
         		//sheetObj.RemoveAll();
         		if(!validateForm(sheetObj,formObj,sAction)) return;
         		sheetObj.SetCellValue(0,9,form.stay_days.value+" or Over");
         		sheetObj.SetCellValue(0,10,form.stay_days.value+" or Over");
         		sheetObj.SetCellValue(0,11,form.stay_days.value+" or Over");
	            formObj.f_cmd.value=SEARCH;
	            sheetObj.SetWaitImageVisible(0);
	            ComOpenWait(true); 
	            //alert("test"+ FormQueryString(formObj));
	            sheetObj.DoSearch("EES_CIM_1951GS.do",FormQueryString(formObj) );
         		break;
         	case IBSEARCH02:      //Detail
         		sheetObj.RemoveAll();
         		if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.SetWaitImageVisible(0);
	            ComOpenWait(true); 
	            formObj.f_cmd.value=SEARCH02;
	            sheetObj.DoSearch("EES_CIM_1951GS.do",FormQueryString(formObj) );
		        ComOpenWait(false); 
         		break; 
    		case IBSEARCH03: //RHQ  focusOut
    			formObj.inquiryLevel.value="W";
    			formObj.location.value=formObj.rhq_cd.value;
    			formObj.f_cmd.value=SEARCH04;
    			if (formObj.rhq_cd.value == "") {
    				return false;
    			}
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.SetWaitImageVisible(0);
    			var sXml=sheetObj.GetSearchData("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck=ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.rhq_cd.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.rhq_cd.value="";
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
    			formObj.inquiryLevel.value="V";
    			formObj.location.value=formObj.op_loc_cd.value;
    			formObj.f_cmd.value=SEARCH04;
    			if (formObj.op_loc_cd.value == "") {
    				return false;
    			}
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.SetWaitImageVisible(0);
    			var sXml=sheetObj.GetSearchData("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck=ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.op_loc_cd.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.op_loc_cd.value="";
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
    			formObj.inquiryLevel.value="K";
    			formObj.location.value=formObj.bkg_ofc_cd.value;
    			formObj.f_cmd.value=SEARCH04;
    			if (formObj.bkg_ofc_cd.value == "") {
    				return false;
    			}
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.SetWaitImageVisible(0);
    			var sXml=sheetObj.GetSearchData("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck=ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.bkg_ofc_cd.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.bkg_ofc_cd.value="";
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
    			formObj.inquiryLevel.value="B";
    			formObj.location.value=formObj.bkg_no.value;
    			formObj.f_cmd.value=SEARCH04;
    			if (formObj.bkg_no.value == "") {
    				return false;
    			}
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.SetWaitImageVisible(0);
    			var sXml=sheetObj.GetSearchData("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck=ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.bkg_no.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.bkg_no.value="";
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
    			formObj.inquiryLevel.value="U";
    			formObj.location.value=formObj.cust_cd.value;
    			formObj.f_cmd.value=SEARCH04;
    			if (formObj.cust_cd.value == "") {
    				return false;
    			}
    			//alert("test"+ FormQueryString(formObj));
    			sheetObj.SetWaitImageVisible(0);
    			var sXml=sheetObj.GetSearchData("EES_CIM_0008GS.do",FormQueryString(formObj));
    			var sCheck=ComGetEtcData(sXml, "check");
    			if (sCheck != "OK") {
    				if (document.form.cust_cd.value != "") {
    					ComShowCodeMessage("CIM29013");
    					document.form.cust_cd.value="";
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
            	if ( sheetObj.RowCount()!= 0 ) {
            		sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
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
    	tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    	case 1:
    		with (tabObj) {
    			var cnt=0 ;
    			InsertItem( "Summary" , "");
    			InsertItem( "Detail" , "");
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
        var objs=document.all.item("tabLayer");
     	objs[nItem].style.display="Inline";
     	objs[beforetab].style.display="none";
     	//--------------- 요기가 중요 --------------------------//
     	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab=nItem;
     	resizeSheet();
     	
     	
    }
     /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 data 조회한다.
     */
    function tab1_OnClick(tabObj , nItem)
    {
    	if ( nItem == 0 ) {
 		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	} else if ( nItem == 1 ) {
 			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
     	}
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
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function sheet2_OnClick(sheetObj, row, col, value) {
     //no support[implemented common]CLT 	sheetObj.SelectHighLight=true;
    }
    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
    	ComOpenWait(false); 
    	if ( sheetObj.RowCount()!= 0 ) {
    		with(sheetObj)
    		{
    			for(var i=1; i <= LastRow(); i ++)
    			{
    				var lvl=GetCellValue(i, "lvl");
    				if ( lvl == '000111' ) {
    					sheetObj.SetRowBackColor(i,"#C9D5EB");
    				}
    			}
    			for ( var j=0; j<totHeadCount; j++ ) {
    				sheetObj.SetCellValue(sheetObj.LastRow(),j,sheetObj.GetCellValue(sheetObj.LastRow()-1, j),0);
    			}
    			sheetObj.SetMergeCell(sheetObj.LastRow(), 0, 1, 6);
    			sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
    			sheetObj.RowDelete(sheetObj.LastRow()-1 , false);
    			sheetObj.SetCellValue(sheetObj.LastRow(),0,'G.Total');
    			
    		}
    //no support[implemented common]CLT 		sheetObj.SelectHighLight=false;
    	}
    	sheetObj.RenderSheet(1);
    	
    }
	/**
	 * Location 팝업창에서 선택한 Location Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setOpLocCd(aryPopupData){
        form.op_loc_cd.value=aryPopupData[0][3];
        form.btn_op_loc_cd.checked=true;
	}
	/**
	 * Booking Office 팝업창에서 선택한 Booking Office Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setBkgOfcCd(aryPopupData){
        form.bkg_ofc_cd.value=aryPopupData[0][3];
        form.btn_bkg_ofc_cd.checked=true;
	}
	/**
	 * Booking Office 팝업창에서 선택한 Booking Office Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setRhqCd(aryPopupData){
        form.rhq_cd.value=aryPopupData[0][3];
        form.btn_rhq_cd.checked=true;
	}
	/**
	 * Customer  팝업창에서 선택한 Customer Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setCustCd(aryPopupData){
        form.cust_cd.value=aryPopupData[0][3];
        form.btn_cust_cd.checked=true;
	}
