/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EES_CGM_1155.js
*@FileTitle 	: Performance by Pool
*Open Issues 	:
*Change history :
*@LastModifyDate: 2014.02.11
*@LastModifier 	: 신용찬
*@LastVersion 	: 1.0
* 2014.02.11 신용찬
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_1155 : ees_cgm_1155 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1155() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
   
    var tot_cntr_tpsz_cd ="";
    var comboObjects = new Array();
    var comboCnt = 0 ;
    var HeadTitleCnt =0;
    var headCnt = 0;
   
    var IBSEARCH01  = 29;
    var IBSEARCH02  = 30;
    var IBSEARCH03  = 31;
    var IBSEARCH04  = 32;
    var IBSEARCH05  = 33;
    var IBSEARCH06  = 34;
   


   	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
   	document.onclick = processButtonClick;

   	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
   	function processButtonClick(){
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	        
	    var sheetObject1 = sheetObjects[0];	
	    
	    /*******************************************************/
	    var formObject = document.form;
	
		try {
	   		var srcName = window.event.srcElement.getAttribute("name");
	
            switch(srcName) {

			case "btn_new":		//조회조건 초기화
				sheetObjects[0].WaitImageVisible = false;
				sheetObjects[0].Redraw = false;
				sheetObjects[0].RemoveAll();
				sheetObjects[0].Redraw = true;

			    comboObjects[0].Code = "";       		// pool 초기화
			    document.form.search_vndr_seq.value = ""; 	// Lessor 초기화
			    document.form.search_yd_cd.value = ""; 		// Yard 초기화
			    document.form.scc_cd.value = ""; 		// scc 초기화
			    
			    searchDefaultMonth();            		// Period 초기화			    
			    
    			var HeadTitle = "Lessor|Lessor Name|Pool|SCC|Yard|Div|Total|YYYY-M1|YYYY-M2|YYYY-M3";

    			HeadTitleCnt = HeadTitle.split("|").length;
    			for ( var i=0; i<headCnt; i++ ) {
    				if ( HeadTitleCnt <= i ) {
    					sheetObjects[0].ColHidden(i) = true;
    				} else {
    					sheetObjects[0].ColHidden(i) = false;
    				}
    			}
    			
    			for ( var i=0; i<HeadTitleCnt; i++ ) {
    				sheetObjects[0].CellValue2(0,i) = HeadTitle.split("|")[i];	 
    			}
    			
    			sheetObjects[0].SheetWidth = 580;

				break;
				
            case "btns_crnt_scc_cd":	// Location Popup

            	ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 450,"scc_cd:scc_cd", "1,0,1,1,1,1,1", true);
	            break; 
	            
            case "btns_vndr":
            	ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackVendor", "0,1,1,1,1,1", true, false);
            	break;  
            	
            case "btns_crnt_yd_cd":		// Yard
            	ComOpenPopup('/hanjin/COM_ENS_061.do', 800, 475, "callBackYard", "0,1,1,1,1,1,1", true, false);
            	break;            	
	            
			case "btn_downexcel":	//DOWN EXCEL

				doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);

				break;
			case "btn_Retrieve":	//조회

				sheetObjects[0].RemoveAll();
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

				break;

			case "btns_Calendar1": // Period (From)
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.from_bse_dt, "yyyy-MM");

				break;
				
			case "btns_Calendar2": // Period (To)
				var cal = new ComCalendar();
				cal.setDisplayType('month');
				cal.select(formObject.to_bse_dt, "yyyy-MM");

				break;				
				
           } // end switch
   		} catch(e) {
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
     * IBCombo Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }    
    
    /**
    * 초기 이벤트 등록 
    */
    function initControl() {
 
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , document.form);						//알파벳 대문자,숫자만 입력허용
//    	axon_event.addListener('keyup', 'from_bse_dt_onkeyUp', 'from_bse_dt');							//from_bse_dt keyup 이벤트 처리
//    	axon_event.addListener('keyup', 'to_bse_dt_onkeyUp', 'to_bse_dt');								//to_bse_dt keyup 이벤트 처리
   	
    	//axon_event.addListenerFormat('keydown', 'ComKeyEnter', 'form');								//엔터키 조회 이벤트처리

    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', document.form); 					//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form, 'scc_cd'); 		//form OnBeforeDeactivate이벤트에 코드 처리, SCC 는 제외처리
       	axon_event.addListenerForm('change','obj_change',document.form);       							//- 변경될때.

    }

	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "scc_cd":				
				ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
				break;
			case "from_bse_dt":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "to_bse_dt":
				ComKeyOnlyNumber(event.srcElement);
				break;				
	
		}
	}

    /**
	 * Period FM  beforeactivate 이벤트 처리
	 * Period FM  beforeactivate -없애기
	 */    
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
		
	/**
	* Period to  beforedeactivate 이벤트 처리
	* Period to  beforedeactivate YYYY-MM 포멧 처리
	*/	
	function obj_deactivate() {
		ComAddSeparator(event.srcElement);
	}
		
    /**
	 * Period FM  keyup 이벤트 처리
	 * Period FM  keyup YYYY-MM 포멧 처리
	 */
//	 function from_bse_dt_onchage() {
//
//	    var formObject = document.form;
//	    var from_bse_dt = formObject.from_bse_dt.value.replace(/\/|\-|\./g, "");
//	    //if ( event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {	    	
//			   if ( from_bse_dt.length == 6 ) {
//				   ComAddSeparator(event.srcElement);
//				   if ( !chkPeriod('from') ) {  
//					   return;
//				   } else {
//			    	   formObject.to_bse_dt.focus();
//			    	   return;
//				   }
//			   }
//	    //}
//	 }  
	 
	 /**
	 * Period TO  keyup 이벤트 처리
	 * Period TO  keyup YYYY-MM 포멧 처리
	 */
//	 function to_bse_dt_onchage() {
//	 	var formObject = document.form;
//	 	var to_bse_dt = formObject.to_bse_dt.value.replace(/\/|\-|\./g, "");
//	 	if ( event.keyCode != 35 && event.keyCode != 36 && event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
//		    	if ( to_bse_dt.length == 6 ) {
//		    		ComAddSeparator(event.srcElement);
//		    		if ( !chkPeriod('to') ) {
//		    			return;
//		    		} 
//		    	}
//	     }
//	 }     
	    
    /**
     * Period TO  keyup 이벤트 처리
     * Period TO  keyup 날짜 체크 처리
     */
    function chkPeriod(fromToFlag) {
    	var formObj = document.form;
    	var chkFlag = true;
    	if ( fromToFlag == 'from') {
		  	if ( !ComIsDate(formObj.from_bse_dt.value, "ym") ) {
		  		formObj.from_bse_dt.value = "";
		  		formObj.from_bse_dt.focus();
		  		chkFlag = false;
		  	}
    	} else {
    	  	if ( !ComIsDate(formObj.to_bse_dt.value, "ym") ) {
    	  		formObj.to_bse_dt.value = "";
    	  		formObj.to_bse_dt.focus();
    	  		chkFlag = false;
    	  	}

    	}    	
   	
	  	if(formObj.from_bse_dt.value != "" && formObj.to_bse_dt.value != "") {
	  		if(formObj.from_bse_dt.value.trimAll("-") > formObj.to_bse_dt.value.trimAll("-")) {
	  			ComShowMessage(ComGetMsg("CGM20079", "To", "FM")); //'{?msg1} should be same or later than {?msg2}.';
	  			formObj.to_bse_dt.value = "";
	  			formObj.to_bse_dt.focus();
	  			chkFlag = false;
	  		}
	  		
	  		var input1=ComReplaceStr(formObj.from_bse_dt.value,"-","");
	  		var input2=ComReplaceStr(formObj.to_bse_dt.value,"-","");

	  		var date1 = new Date(input1.substr(0,4),input1.substr(4,2)-1);
	  		var date2 = new Date(input2.substr(0,4),input2.substr(4,2)-1);
	  		var interval = date2 - date1;
	  		var day = 1000*60*60*24;	  		
	  		var month = day*30;

	  		month = parseInt(interval/month)+1;
	  		if ( month > 12 ) {
	  			ComShowMessage(msgs["CGM20078"]);  //Maximum Period is 12 Months
	  			formObj.to_bse_dt.value = "";
	  			formObj.to_bse_dt.focus();
		  		chkFlag = false;
	  		}
	  	}
	  	return chkFlag;
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
    	
	    comboObjects[comboCnt++] = document.combo_pool;
	    
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k]);
	    }
	    	  	
	    searchDefaultMonth(); // Period 시작/종료 월 검색
	    initControl();	    
		sheetObjects[0].ExtendLastCol = false;  // GRID 마지막 컬럼 길이 확장 금지
	    
    }

	/** 
	 * MultiCombo 의 초기화  <br>
	 * @param  없음
	 * @return 없음
	 * @author 김창식
	 * @version 2009.09.17
	 */ 
	 function initCombo(comboObj) {
	    switch(comboObj.id) {
		     case "combo_pool":
		         with(comboObj) {
		        	 Code = "";
		             Text = "";
		             DropHeight = 100;
		             MultiSelect = false;
		             MaxSelect = 1;
		             UseCode = true;
	 	  	         comboObj.UseAutoComplete = true;
	 	  	         
	 	  		    var sXml2 = document.form.sXml.value;    
	 	  	 		var arrXml = sXml2.split("|$$|");	
	 	  	 		
	 	  		    if ( arrXml[0] == null ) {return;}
	 	  	 		var vArrayListData = ComCgmXml2ListMap(arrXml[0]);
	 	  	 	    var arrStr1 = new Array();
	 	  	 	    var arrStr2 = new Array();
	 	  	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 	  	 		    vListData = vArrayListData[i];
	 	  	 		    arrStr1[i] = vListData["code1"];
	 	  	 		    arrStr2[i] = vListData["code1"];
	 	  	 		}
	 	  	 		
	 	  	 		comboObj.RemoveAll();
	 	  	 		comboObj.InsertItem(0,"","");
	 				for (var i=0; i < arrStr1.length; i++ ) {
	 					var arrCode = arrStr1[i].split("|");
	 					comboObj.InsertItem(i+1, arrStr1[i], arrStr2[i]);
	 				}
	 				comboObj.Index2 = "" ;	 	  	 		
	 	  	 		
		         }
		         break;
		    }
	 }
	 
	 function MakeComboObject4(cmbObj, arrStr, arrStr2) {
	 	
		cmbObj.RemoveAll();
		cmbObj.InsertItem(0,"","");
		for (var i=0; i < arrStr.length; i++ ) {
			var arrCode = arrStr[i].split("|");
			cmbObj.InsertItem(i+1, arrStr[i], arrStr2[i]);
		}
		cmbObj.Index2 = "" ;
	}
	 
	/**
	 * Period 입력란에는 조회일자가 속한 달의 이전 달부터 3개월의 기간을 Default로 보여줌. (예. 2009-03-02에 조회시, FM: 2008-12  TO: 2009-02)
	 */
	function searchDefaultMonth() {
	
	   form.f_cmd.value = SEARCH03;
	   sheetObjects[0].WaitImageVisible = false;
	   var sXml = sheetObjects[0].GetSearchXml("EES_CGM_1155GS.do" , FormQueryString(form)); 	       
	    
	   //콤보코드와 콤보텍스트 가져오기
	   var fm_prd = ComGetEtcData(sXml,"fm_prd");
	   var to_prd = ComGetEtcData(sXml,"to_prd");
	       
	   form.from_bse_dt.value = fm_prd.substr(0,4)+"-"+fm_prd.substr(4,6);
	   form.to_bse_dt.value   = to_prd.substr(0,4)+"-"+to_prd.substr(4,6);
	       
	}	 
	 

    function initSheet(sheetObj,sheetNo,headTitle) {
        var cnt = 0;
      
	    switch (sheetNo) {
	        case 1:      //t1sheet1 init
	   			with (sheetObj) {
	                   //Host정보 설정[필수][HostIp, Port, PagePath]
	                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	   					// 높이 설정
	   				   style.height = 450;	   				   
	   				
	                   //전체Merge 종류 [선택, Default msNone]
	                   MergeSheet = msPrevColumnMerge;
	    
	                   //전체Edit 허용 여부 [선택, Default false]
	                   Editable = false;
	    
	                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                   InitRowInfo( 1, 6, 20, 100);  // 5줄을 패키지로 사용
	                   
	                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                   InitHeadMode(false, true, true, true, false,false)
//	                   InitHeadMode(true, true, true, true, true,false)
	                   CountPosition = 0;	//페이지카운트 없애기 
	
	                   if (headTitle==null || headTitle =="") {
	                	   headTitle = "Lessor|Lessor Name|Pool|SCC|Yard|Div|Total|YYYY-M1|YYYY-M2|YYYY-M3|YYYY-M4|YYYY-M5|YYYY-M6|YYYY-M7|YYYY-M8|YYYY-M9|YYYY-M10|YYYY-M11|YYYY-M12"; 
	                       InitColumnInfo(10, 0, 0, true);
	                   }
	                   headCnt  = headTitle.split("|").length;

	                   SheetWidth = mainTable.clientWidth;
	                   
//	                   SheetWidth = headCnt*80;
//	                   
//	                   if ( SheetWidth>975 ) {
//	                	   SheetWidth = 975;
//	                   }
	                   
	                   InitColumnInfo(headCnt, 0, 0, true);
	                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                   InitHeadRow(0, headTitle, true);
	                   sheetObj.FrozenCols = 7;
	    
	                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			   InitDataProperty(0, cnt++ , dtAutoSum,   50,    daCenterTop,	true,		"vndr_seq",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtAutoSum,   90,    daCenterTop,	true,		"vndr_nm",	        false,           "",      dfNone,			0,     true,       true);
	                   InitDataProperty(0, cnt++ , dtData,      50,    daCenterTop,	true,		"pool_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,      50,    daCenterTop,	true,		"scc",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,      60,    daCenterTop,	true,		"yd_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,      60,    daCenter,	true,		"div",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,   	80,    daRight,		true,		"ttl",				false,           "",      dfFloat,	2,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 7 ; i++){
	    				   InitDataProperty(0, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfFloat,	2,     true,       true);
	    			   }
	    				
	    			   cnt = 0;
	    			   InitDataProperty(1, cnt++ , dtAutoSum,   50,    daCenterTop,	true,		"vndr_seq",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(1, cnt++ , dtAutoSum,   90,    daCenterTop,	true,		"vndr_nm",	        false,           "",      dfNone,			0,     true,       true);	    			   
	    			   InitDataProperty(1, cnt++ , dtData,      50,    daCenterTop,	true,		"pool_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(1, cnt++ , dtData,      50,    daCenterTop,	true,		"scc",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(0, cnt++ , dtData,      60,    daCenterTop,	true,		"yd_cd",			false,           "",      dfNone,			0,     true,       true);	    			  
	    			   InitDataProperty(1, cnt++ , dtData,      60,    daCenter,	true,		"div",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(1, cnt++ , dtData,   	80,    daRight,		true,		"ttl",				false,           "",      dfFloat,	2,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 7 ; i++){
	    				   InitDataProperty(1, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfFloat,	2,     true,       true);
	    			   }
	    			    
	    			   cnt = 0;
	    			   InitDataProperty(2, cnt++ , dtAutoSum,   50,    daCenterTop,	true,		"vndr_seq",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtAutoSum,   90,    daCenterTop,	true,		"vndr_nm",	        false,           "",      dfNone,			0,     true,       true);	    			   
	    			   InitDataProperty(2, cnt++ , dtData,      50,    daCenterTop,	true,		"pool_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtData,      50,    daCenterTop,	true,		"scc",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtData,      60,    daCenterTop,	true,		"yd_cd",			false,           "",      dfNone,			0,     true,       true);

	    			   InitDataProperty(2, cnt++ , dtData,      60,    daCenter,	true,		"div",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(2, cnt++ , dtData,   	80,    daRight,		true,		"ttl",				false,           "",      dfFloat,			2,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 7 ; i++){
	    				   InitDataProperty(2, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfFloat,			2,     true,       true);
	    			   }
	    			   
	    			   cnt = 0;
	    			   InitDataProperty(3, cnt++ , dtAutoSum,   50,    daCenterTop,	true,		"vndr_seq",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(3, cnt++ , dtAutoSum,   90,    daCenterTop,	true,		"vndr_nm",	        false,           "",      dfNone,			0,     true,       true);	    			   
	    			   InitDataProperty(3, cnt++ , dtData,      50,    daCenterTop,	true,		"pool_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(3, cnt++ , dtData,      50,    daCenterTop,	true,		"scc",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(3, cnt++ , dtData,      60,    daCenterTop,	true,		"yd_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(3, cnt++ , dtData,      60,    daCenter,	true,		"div",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(3, cnt++ , dtData,   	80,    daRight,		true,		"ttl",				false,           "",      dfFloat,			2,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 7 ; i++){
	    				   InitDataProperty(3, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfFloat,			2,     true,       true);
	    			   }	   
	    			   
	    			   cnt = 0;
	    			   InitDataProperty(4, cnt++ , dtAutoSum,   50,    daCenterTop,	true,		"vndr_seq",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(4, cnt++ , dtAutoSum,   90,    daCenterTop,	true,		"vndr_nm",	        false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(4, cnt++ , dtData,      50,    daCenterTop,	true,		"pool_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(4, cnt++ , dtData,      50,    daCenterTop,	true,		"scc",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(4, cnt++ , dtData,      60,    daCenterTop,	true,		"yd_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(4, cnt++ , dtData,      60,    daCenter,	true,		"div",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(4, cnt++ , dtData,   	80,    daRight,		true,		"ttl",				false,           "",      dfFloat,			2,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 7 ; i++){
	    				   InitDataProperty(4, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfFloat,			2,     true,       true);
	    			   }		    			   

	    			   cnt = 0;
	    			   InitDataProperty(5, cnt++ , dtAutoSum,   50,    daCenterTop,	true,		"vndr_seq",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(5, cnt++ , dtAutoSum,   90,    daCenterTop,	true,		"vndr_nm",	        false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(5, cnt++ , dtData,      50,    daCenterTop,	true,		"pool_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(5, cnt++ , dtData,      50,    daCenterTop,	true,		"scc",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(5, cnt++ , dtData,      60,    daCenterTop,	true,		"yd_cd",			false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(5, cnt++ , dtData,      60,    daCenter,	true,		"div",				false,           "",      dfNone,			0,     true,       true);
	    			   InitDataProperty(5, cnt++ , dtData,   	80,    daRight,		true,		"ttl",				false,           "",      dfFloat,			2,     true,       true);
	    			   for(var i=1 ; i <= headCnt - 7 ; i++){
	    				   InitDataProperty(5, cnt++ , dtData,  80,    daRight,		true,		"year"+(i),			false,           "",      dfFloat,			2,     true,       true);
	    			   }		    			   

	    			   // 검색월에 따라 컬럼 감추기(7는 필수컬럼)
	    			   for ( var i=7; i<headCnt; i++ ) {
	    				   if ( headCnt < i+10 ) {
	    					   sheetObjects[0].ColHidden(i) = true;
	
	    				   } else {
	    					   sheetObjects[0].ColHidden(i) = false;

	    				   }
	    			   }
	    			   //SheetWidth = 7*80;
	    			   
	            }	   
	            break;
        }
    } 

    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    	
    		case IBSEARCH:      //조회
    			if(!validateForm(sheetObj,formObj,sAction)) return;  // VALIDATION
    			
    			sheetObj.Redraw = false;
    			sheetObj.WaitImageVisible = false;
    			ComOpenWait(true); 
    			
    			doActionIBSheet(sheetObj,document.form,IBSEARCH04);  // MONTH TITLE 조회 
    			
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch("EES_CGM_1155GS.do",FormQueryString(formObj));
    			ComOpenWait(false); 
    			
             break;
             
    		case IBSEARCH04:      //HEAD MONTH TITLE 조회
    			
    			form.f_cmd.value = SEARCH04;
    			var sXml = sheetObjects[0].GetSearchXml("EES_CGM_1155GS.do" , FormQueryString(form)); 
    			
    			//헤더 데이터를 설정한다.
    			var bse_dt = ComGetEtcData(sXml,"bse_dt");

    			var HeadTitle = "Lessor|Lessor Name|Pool|SCC|Yard|Div|Total|"+bse_dt;  // 타이틀 조립
    			HeadTitleCnt = HeadTitle.split("|").length;
    			for ( var i=0; i<headCnt; i++ ) {
    				if ( HeadTitleCnt <= i ) {
    					sheetObj.ColHidden(i) = true;
    				} else {
    					sheetObj.ColHidden(i) = false;
    				}
    			}
    			
    			for ( var i=0; i<HeadTitleCnt; i++ ) {
    				sheetObj.CellValue2(0,i) = HeadTitle.split("|")[i];	 
    			}
//    			sheetObj.SheetWidth = HeadTitleCnt*80;
//    			if ( sheetObj.SheetWidth>975 ) {
//    				sheetObj.SheetWidth = 975;
//    			}
//    			break;          
    			
    		case IBSEARCH_ASYNC05:	// SCC CODE 정합성 조회
    			formObj.f_cmd.value = SEARCH17;
    			
    			if(formObj.scc_cd.value != "" && formObj.scc_cd.value != null) {
        			formObj.eq_orz_cht_chktype.value = "SCC";    				
    				formObj.eq_orz_cht_scc_cd.value = formObj.scc_cd.value;

    				var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj));
    				// 데이터 건수
    		    	var dataCount = ComGetTotalRows(sXml);
    		    	if(dataCount==0){
    		    		ComShowCodeMessage('CGM10009','SCC Code');
    		    		formObj.scc_cd.value = "";
    		    	}
    		    
    		    	formObj.scc_cd.focus(); //validation후 focus는 scc로 가게 만든다. 
    			}
    		    break;	    		    		
             
    		case IBDOWNEXCEL:      // 엑섹다운로드
    			if(formObj.data_merge.checked){  // data merge 체크 
    				sheetObj.Down2Excel(-1, false, false, true); // merge 된 excel
    			}else {
    				sheetObj.Down2Excel(-1, false, false, false); // merge 안된 excel
    			}
    			break;
    	}
    }
    
    /**
    * GRID 조회종료후 이벤트 호출 (맨 마지막 TOTAL 라인을 생성-고정)
    */
    function t1sheet1_OnSearchEnd(sheetObj, msg){
    	/*
    	for(var i=1; i<=sheetObj.LastRow; i++){
    		if(sheetObj.CellValue(i,1).toUpperCase() == 'TOTAL'){
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(229,234,255);
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(229,234,255);
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
    		}
    	}
    	if ( sheetObj.rowCount != 0 ) {
	    	for ( var i=sheetObj.LastRow-5; i<sheetObj.LastRow-2; i++) {
	    		for ( var j=1; j<HeadTitleCnt; j++ ) {
	    			sheetObj.CellValue2(i+3,j) =  sheetObj.CellValue(i, j);
	    	    	sheetObj.CellAlign(i+3,"div") = daCenter;
	    		}
	    	}

	    	sheetObj.RowDelete(sheetObj.LastRow-5, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-4, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-3, false);
	    	sheetObj.SetMergeCell (sheetObj.LastRow-2, 0, 3, 2);
    	}
    	sheetObj.SelectHighLight = false;
    	sheetObj.Redraw = true;
    	*/

    	for(var i=1; i<=sheetObj.LastRow; i++){
    		if(sheetObj.CellValue(i,1).toUpperCase() == 'TOTAL'){
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(229,234,255);
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(229,234,255);
    			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
    		}
    	}
    	if ( sheetObj.rowCount != 0 ) {
	    	for ( var i=sheetObj.LastRow-11; i<sheetObj.LastRow-5; i++) {
	    		for ( var j=1; j<HeadTitleCnt; j++ ) {
	    			sheetObj.CellValue2(i+6,j) =  sheetObj.CellValue(i, j);
	    	    	sheetObj.CellAlign(i+6,"div") = daCenter;
	    		}
	    	}

	    	sheetObj.RowDelete(sheetObj.LastRow-11, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-10, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-9, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-8, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-7, false);
	    	sheetObj.RowDelete(sheetObj.LastRow-6, false);
	    	
	    	sheetObj.SetMergeCell (sheetObj.LastRow-5, 0, 6, 2);
    	}
    	sheetObj.SelectHighLight = false;
    	sheetObj.Redraw = true;  
    }
    
    
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch (sAction) {
    		case IBSEARCH:    		
	    	
    			// 날짜 공백 체크
    			if (document.form.from_bse_dt.value == '') {
    				ComShowCodeMessage('CGM10004', 'Period ');
    				document.form.from_bse_dt.focus();
    				return false;
    			}
    			if (document.form.to_bse_dt.value == '') {
    				ComShowCodeMessage('CGM10004', 'Period ');
    				document.form.to_bse_dt.focus();
    				return false;
    			}
			
				if ( document.form.from_bse_dt.value != '' ) {
				    ComAddSeparator(event.srcElement);
				    if ( !chkPeriod('from') ) {  
				    	return false;
					} else {
						formObj.to_bse_dt.focus();
				    	   //return;
					}
				} 

			    if ( document.form.to_bse_dt.value != '' ) {
			    	ComAddSeparator(event.srcElement);
			    	if ( !chkPeriod('to') ) {
			    		return false;
			    	} 
			    }

    	
    		}   	
    	}
    	return true;
    }
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function t1sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }
    
    /**
    * HTML Control의 Value가 변경되었을 경우 처리한다.
    */
    function obj_change(){
  	
    	var obj      = event.srcElement;
    	var formObj  = document.form;
    	//if ( ComTrim(ComGetObjValue(obj)) != "" ) {
    	switch(obj.name) {

    		case "scc_cd":		//Location Code
    			if ( ComTrim(obj.value) != "" && ComTrim(obj.value) != null ) {
    				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
    			}
    			break;

    	}

    }    
    
    /**
     * 콜백 함수. <br>
     * 공통팝업 ServiceProvider에서 선택한 Lessor Seq를 Form Object 인 vndr_seq에 설정한다.
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */   
    function callBackVendor(aryPopupData, row, col, sheetIdx){
        	 
       	var formObj = document.form;
        var vndrSeq = "";
        var i = 0;
        	 
        for(i = 0; i < aryPopupData.length; i++){
        	vndrSeq = vndrSeq + aryPopupData[i][2];
        		
        	if(i < aryPopupData.length - 1){
        		vndrSeq = vndrSeq + ",";
        	}
        }
        	 
        formObj.search_vndr_seq.value = vndrSeq;
        	 
    }    
    
    /**
     * 콜백 함수. <br>
     * @param  {Array} aryPopupData	필수	 Array Object
     * @param  {Int} row				필수 선택한 Row
     * @param  {Int} col				필수 선택한 Column
     * @param  {Int} sheetIdx			필수 Sheet Index
     * @return 없음
     * @author 김창식
     * @version 2009.07.16
     */   
    function callBackYard(aryPopupData, row, col, sheetIdx){         	 
        var formObj = document.form;
        var crntYdCd = "";
        var i = 0;
        
        for(i = 0; i < aryPopupData.length; i++){        	
        	crntYdCd = crntYdCd + aryPopupData[i][3];        	
        	if(i < aryPopupData.length - 1){
        		crntYdCd = crntYdCd + ",";
         	}
        }
         	 
        formObj.search_yd_cd.value = crntYdCd;

    }    

	/* 개발자 작업  끝 */