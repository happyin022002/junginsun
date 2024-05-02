/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EES_CGM_1156.js
*@FileTitle 	: Performance by Pool
*Open Issues 	:
*Change history :
*@LastModifyDate: 2014.03.03
*@LastModifier 	: 신용찬
*@LastVersion 	: 1.0
* 2014.03.03 신용찬
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_1156 : ees_cgm_1156 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CGM_1156() {
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

			    document.form.search_sc_no.value = ""; // sc no 최기화
			    document.form.search_yd_cd.value = ""; // yd cd 초기화
			    searchDefaultMonth();            // Period 초기와			    			    

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
				
	        case "sc_no_multi":           
	        	 rep_Multiful_inquiry("search_sc_no");	    	        
                
                break;
				
            case "btns_crnt_yd_cd":		// Yard
            	//ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 1000, 450, "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
            	ComOpenPopup('/hanjin/COM_ENS_061.do', 800, 475, "callBackYard", "0,1,1,1,1,1,1", true, false);
            	
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
 
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , document.form);				//
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', document.form); 			//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form); 		//form OnBeforeDeactivate이벤트에 코드 처리, sc no 는 제외처리    	

    }

	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "sc_no_multi":	

				ComKeyOnlyAlphabet('uppernum', "44");// 알파벳 대문자,숫자, ',' (keycode=44)만 입력허용
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
	    	  	
	    searchDefaultMonth(); // Period 시작/종료 월 검색
	    initControl();	    
		//sheetObjects[0].ExtendLastCol = false;  // GRID 마지막 컬럼 길이 확장 금지
	    
    }

	 
	/**
	 * Period 입력란에는 조회일자가 속한 달의 이전 달부터 3개월의 기간을 Default로 보여줌. (예. 2009-03-02에 조회시, FM: 2008-12  TO: 2009-02)
	 */
	function searchDefaultMonth() {
	
	   form.f_cmd.value = SEARCH03;
	   sheetObjects[0].WaitImageVisible = false;
	   var sXml = sheetObjects[0].GetSearchXml("EES_CGM_1156GS.do" , FormQueryString(form)); 	       
	    
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
	   				   style.height = 440;	   				   
	   				
	                   //전체Merge 종류 [선택, Default msNone]
	                   MergeSheet = msPrevColumnMerge;
	    
	                   //전체Edit 허용 여부 [선택, Default false]
	                   Editable = false;
	    
	                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                   InitRowInfo( 1, 1, 1, 100);  // 1줄을 패키지로 사용
	                   
	                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                   InitHeadMode(false, true, true, true, false,false)
	                   CountPosition = 0;	//페이지카운트 없애기 
	
	                   if (headTitle==null || headTitle =="") {
//	                	   headTitle = "S/C No|Customer \nCode|Customer \nName|Kind of \nCustomer|Actual \nCustomer Code|Actual \nCustomer Name|YYYYMM|SCC|Yard Code|Bound|B/L Term|Exempt|Bill Day|Bill Day(Avg)|Rental \nAMT|Box|Average"; 
//	                	   headTitle = "S/C No|Customer \nCode|Customer \nName|Kind of \nCustomer|Actual \nCustomer Code|Actual \nCustomer Name|YYYYMM|SCC|Bound|B/L \nTerm|Exempt|Bill Day|Bill Day\n(Avg)|Rental \nAMT|Box|Average"; 
	                	   headTitle = "S/C No|Customer \nCode|Customer \nName|Kind of \nCustomer|Actual \nCustomer \nCode|Actual \nCustomer Name|YYYYMM|SCC|Yard|Bound|B/L \nTerm|Exempt|Rental \nAMT|Box|Average"; 
	                       InitColumnInfo(5, 0, 0, true);
	                   }
	                   headCnt  = headTitle.split("|").length;

	                   SheetWidth = mainTable.clientWidth;

	                   InitColumnInfo(headCnt, 0, 0, true);
	                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                   InitHeadRow(0, headTitle, true);
	                   sheetObj.FrozenCols = 3;
	    
	                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE,   SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			   InitDataProperty(0, cnt++ , dtData,      75,    daCenter,	true,	"sc_no",		false,    "",      dfNone,			0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,      65,    daCenter,	true,	"cust_cd",		false,    "",      dfNone,			0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,     120,    daCenter,	true,	"cust_nm",		false,    "",      dfNone,			0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,   	65,    daCenter,	true,	"cust_kind",	false,    "",      dfNone,	        0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,      65,    daCenter,	true,	"cust_act_cd",	false,    "",      dfNone,	        0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,     120,    daCenter,	true,	"cust_act_nm",	false,    "",      dfNone,	        0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,   	60,    daCenter,	true,	"yearmonth",	false,    "",      dfUserFormat,	0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,   	50,    daCenter,	true,	"scc_cd",		false,    "",      dfNone,	        0,     false,       false);

	    			   InitDataProperty(0, cnt++ , dtData,   	60,    daCenter,	true,	"yd_cd",		false,    "",      dfNone,	        0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,   	45,    daCenter,	true,	"bound_cd",		false,    "",      dfNone,	        0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,   	45,    daCenter,	true,	"bl_term",		false,    "",      dfNone,	        0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,   	50,    daCenter,	true,	"exempt",		false,    "",      dfNone,	        0,     false,       false);
//	    			   InitDataProperty(0, cnt++ , dtData,   	50,    daCenter,	true,	"bill_day",		false,    "",      dfNone,	        0,     false,       false);
//	    			   InitDataProperty(0, cnt++ , dtData,   	50,    daCenter,	true,	"bill_day_avg",	false,    "",      dfNone,	        0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,   	60,    daRight,	    true,	"amt_rent",		false,    "",      dfFloat,	        2,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,   	45,    daRight,	    true,	"amt_box",		false,    "",      dfInteger,       0,     false,       false);
	    			   InitDataProperty(0, cnt++ , dtData,   	55,    daRight,	    true,	"amt_avg",		false,    "",      dfFloat,	        2,     false,       false);		    			      			   	    			   
	    			   
	    			   sheetObj.InitUserFormat(0, "yearmonth", "####-##", "-" ); // yyyymm setting
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
    			
    			sheetObj.WaitImageVisible = true;
    			
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch("EES_CGM_1156GS.do",FormQueryString(formObj));
             	sheetObj.Visible = true;
    			
             break;
                     
    			
    		case IBSEARCH_ASYNC05:	// SCC CODE 정합성 조회
    			formObj.f_cmd.value = SEARCH17;
    			
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
    			
    		    break;	    		    		
             
    		case IBDOWNEXCEL:      // 엑섹다운로드
    			if(formObj.data_merge.checked){  // data merge 체크 
    				sheetObj.Down2Excel(-1, false, false, true); // merge 된 excel
    			}else {
    				sheetObj.Down2Excel(-1, false, false, false); // merge 안된 excel
    			}
    			break;
    			
    			
//    		case IBSEARCH_ASYNC02:	// Yard 에 대한 Validation 체크 
//			   	formObj.f_cmd.value = COMMAND01;
//			   	formObj.yd_cd.value = formObj.search_yd_cd.value;
//			   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
//			   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
//			   	
//			   	if(sCheckResult == COM_VALIDATION_FALSE){
//			   		ComShowCodeMessage('CGM10009','Yard');
//			   		formObj.search_yd_cd.value = "";
//			   		formObj.search_yd_cd.focus();
//			   	}
//			   	
//			   	break;
    	}
    }
    
    /**
    * GRID 조회종료후 이벤트 호출 (맨 마지막 TOTAL 라인을 생성-고정)
    */
    function t1sheet1_OnSearchEnd(sheetObj, msg){
   	
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
    			if ( ComTrim(obj.value) != "" ) {
    				doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
    			}
    			break;

    	}

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
        
        //chungpa 20091015 check yard
        //checkGroup2Yard();
    }
    
    /**
	 * rep_Multiful_inquiry 사용시 받는부분  
	 * 소스에 붙여서 사용하세요          
	 * Location : 팝업에서 단일 선택을 한경우..     
	 */      
	function getCgm_Multi(rowArray,ret_val) {
		var formObj = document.form;  
		var tempText = ""; 
		//초기화	   
//		formObj.loc_list.value = ''; 	
		for(var i=0; i<rowArray.length; i++) {   
			var colArray = rowArray[i];     
			tempText +=  rowArray[i] + ','; 	  
		}      
		//마지막에 ,를 없애기 위함     
		tempText = CgmDelLastDelim(tempText);	 
		tempText = tempText.toUpperCase(); 	    
						        
		eval("document.form." + ret_val + ".value = '" + tempText + "';"); 
	}     

	/* 개발자 작업  끝 */