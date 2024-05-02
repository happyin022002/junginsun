/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0010.js
*@FileTitle : Cost Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.07.28 전재홍
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
     * @class ESD_LEA_0010 : ESD_LEA_0010 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0010() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject 		= setComboObject;    	
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
	var sheetObjects 	= new Array();
	var sheetCnt 		= 0;
	var comboObjects 	= new Array();
	var comboCnt 		= 0;

	/* IB MULTI COMBO (Main Cost Type Code) 화면최초로딩시 onChange Event 미처리를 위한 전역변수 */ 
	var comboOnChangeEvtEnableFlag	= 'N';
	
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		 var sheetObject  = sheetObjects[0];
    		 var sheetObject1 = sheetObjects[1];
    		 var sheetObject2 = sheetObjects[2];

    		 /*******************************************************/
    		 var formObject = document.form;

    		try {
    			var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {

    				case "btn_retrieve":
    				 	sheetObject.RemoveAll();
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btng_downexcel":
    					
    					if (sheetObject.RowCount == 0){	//LEA90008 : No data found
    						ComShowMessage(ComGetMsg("LEA90008"));
    						return;
    					}
    					
    					//lea_form2sheet(formObject, sheetObject2);
    					//sheetObject2.Down2Excel(-1	, false	,	false,	true,	"",	"",	false,	false, "",	true);
    					//sheetObject .Down2Excel(-1	, true	,	false,	true,	"",	"",	false,	false, "",	true);
    					//doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	    	sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
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
         * IBCombo Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의 
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
        }    	
    	
    	/**
    	 * Sheet 기본 설정 및 초기화
    	 * body 태그의 onLoad 이벤트핸들러 구현
    	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	 */
        
    	function loadPage(frmMnCostTypeCode, frmSubCostTypeCode) {

    		for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);

    			initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
    		//IBMultiCombo 초기화
    		initCombo_mn_cost_tp_cd		();
    		initCombo_sub_cost_tp_cd	();
    		initCombo_frm_accl_type_cd	();
    		
    		comboOnChangeEvtEnableFlag	= 'Y';
    		
//    		doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
//    		lea_initCombo(sheetObjects[1],document.form);
    		
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
         * IB MULTI COMBO 초기화
         */
        function initCombo_mn_cost_tp_cd(){
        	
    		var formObj = document.form;

    		formObj.f_cmd.value 	= SEARCH20	;		//IB MULTI COMBO.MAIN COST TYPE CODE 조회
    		formObj.cost_kind.value	= "COST_KIND_MAIN"; 
   		
			//var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
			
			var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
			
    		var comboList 	= new Array();
    		comboList		= LeaXml2ComboString(sXml, "code", "name");
    		
    		//IB MULTI COMBO Property 설정
    		formObj.mn_cost_tp_cd.SetTitle("Main Cost Type");
    		formObj.mn_cost_tp_cd.SetColAlign("left");
    		formObj.mn_cost_tp_cd.SetColWidth("120");
    		
    		if(comboList != null){
    			for(var i = 0; i < comboList.length;i++){ 
    				var code = comboList[i].substring(0, comboList[i].indexOf('|') );
    				formObj.mn_cost_tp_cd.InsertItem(i, comboList[i] , code);
    				formObj.mn_cost_tp_cd.Code = code;
    			}
    			formObj.mn_cost_tp_cd.InsertItem(0, "All" , "All");
    			formObj.mn_cost_tp_cd.Code2 = "All";
    		}        	
        }
        
        /**
         * IB MULTI COMBO 초기화
         */        
        function initCombo_sub_cost_tp_cd(){
        	
    		var formObj = document.form;

    		formObj.f_cmd.value 	= SEARCH20	;	//IB MULTI COMBO.SUB COST TYPE CODE 조회
    		formObj.cost_kind.value	= "COST_KIND_SUB"; 
   		
			//var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
			
			var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
			
    		var comboList 	= new Array();
    		comboList		= LeaXml2ComboString(sXml, "code", "name");
    		
    		//IB MULTI COMBO Property 설정
    		formObj.sub_cost_tp_cd.SetTitle("Sub Cost Type | Sub Cost Type Name");
    		formObj.sub_cost_tp_cd.SetColAlign("left|left");
    		formObj.sub_cost_tp_cd.SetColWidth("125|300");
    		formObj.sub_cost_tp_cd.DropHeight = 400;
    		
    		if(comboList != null){
    			for(var i = 0; i < comboList.length;i++){ 
    				var code = comboList[i].substring(0, comboList[i].indexOf('|') );
    				formObj.sub_cost_tp_cd.InsertItem(i, comboList[i] , code);
    				formObj.sub_cost_tp_cd.Code = code;
    			}
    			formObj.sub_cost_tp_cd.InsertItem(0, "All" , "All");
    			formObj.sub_cost_tp_cd.Code2 = "All";
    		}        	
        }        
        
        /**
         * IB MULTI COMBO 초기화
         */
        function initCombo_frm_accl_type_cd(){
        	
    		var formObj = document.form;

    		//IB MULTI COMBO Property 설정
    		formObj.frm_accl_type_cd.SetTitle("Accrual Type");
    		formObj.frm_accl_type_cd.SetColAlign("left");
    		formObj.frm_accl_type_cd.SetColWidth("120");
    		
   			formObj.frm_accl_type_cd.InsertItem(0, "All"		, "All"		);
   			formObj.frm_accl_type_cd.InsertItem(1, "Auto" 		, "Auto"	);
   			formObj.frm_accl_type_cd.InsertItem(2, "Manual" 	, "Manual"	);
   			formObj.frm_accl_type_cd.Code2 = "All";
        }
        
        
        
        /**
         * IB MULTI COMBO onChange Event 처리
         */  
        function mn_cost_tp_cd_OnChange(comboObj, Index_Code, Text){  	

        	//IB COMBO 화면로딩+초기화+OnChange Evt 발생시 Blocking처리, 화면로딩이후에만 OnChange Evt 작동되도록처리목적
        	if(comboOnChangeEvtEnableFlag != 'Y')	return;
        	
    		var formObj = document.form;
    		formObj.sub_cost_tp_cd.removeAll();
    	
    		formObj.f_cmd.value 			= SEARCH20	;	//IB MULTI COMBO 조회
    		formObj.cost_kind.value			= "COST_KIND_SUB"; 
    		formObj.sel_mn_cost_tp_cd.value = Index_Code;
    		
        	if(Index_Code == 'All')		formObj.sel_mn_cost_tp_cd.value = '';
   		
        	sheetObjects[0].WaitImageVisible = false;
			//var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
			
			var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
			
			
			sheetObjects[0].WaitImageVisible = true;
    		var comboList 	= new Array();
    		comboList		= LeaXml2ComboString(sXml, "code", "name");
    	
    		if(comboList != null){
    			for(var i = 0; i < comboList.length;i++){ 
    				var code = comboList[i].substring(0, comboList[i].indexOf('|') );
    				formObj.sub_cost_tp_cd.InsertItem(i, comboList[i] , code);
    				formObj.sub_cost_tp_cd.Code = code;
    			}
    			formObj.sub_cost_tp_cd.InsertItem(0, "All" , "All");
    			formObj.sub_cost_tp_cd.Code2 = "All";
    		}
        }         
        
       /**
    	 * 시트 초기설정값, 헤더 정의
    	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	 */
    	function initSheet(sheetObj,sheetNo) {

    		var cnt = 0;

    		switch(sheetNo) {
    			case 1:      //sheet1 init
    				with (sheetObj) {
    					// 높이 설정
    					style.height = 400;
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    				   //전체Edit 허용 여부 [선택, Default false]
    					Editable = true;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 2, 1, 9, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(14, 1 , 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false) ;

    					var HeadTitle = "Cost\nType Ⅰ|Cost Type Ⅱ|Cost Type Ⅱ|Cost Code|Cost Code|Account Code|Account Code|Account Code|Account Code|Accrual|Accrual|Accrual|Source|Source";
    					var HeadTitle1 = "Cost\nType Ⅰ|Code|Name|Code|Name|Code|Name|Rep.\nCode|Other Lines||Type|Case|Est.|Actual";

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, true);

    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData  ,       60,    daCenter,   true ,    "mn_cost_tp_cd"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "sub_cost_tp_cd"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,      200,    daCenter,   false,    "sub_cost_tp_nm"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       60,    daCenter,   false,    "lgs_cost_cd"			,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,      170,    daCenter,   false,    "lgs_cost_full_nm"	,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "acct_cd"					,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,      200,    daCenter,   false,    "acct_cd_nm"				,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "rep_acct_cd"			,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       80,    daCenter,   false,    "otr_crr_acct_cd"	,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true ,    "accl_auto_cd"			,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       60,    daCenter,   true ,    "accl_auto_nm"			,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "accl_lgc_tp_cd"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "estm_cost_flg"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "cost_src_sys_cd"	,     false,          "",       dfNone,          0,     false,       false);

    					RangeBackColor(1,1, 1,13) = RgbColor(222, 251, 248);   // ENIS
    					HeadRowHeight = 21 ;
    					HeadRowHeight = 20 ;

    				}
    				break;
    			case 2:      //sheet1 init
    				with (sheetObj) {
    					// 높이 설정
    					style.height = 280;
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
    					InitColumnInfo(1, 0 , 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false) ;

    					var HeadTitle = "";
    					
    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "",     false,          "",       dfNone,          0,     true,       true);


    				}
    				break;
    			case 3:      //sheet1 init
    				with (sheetObj) {
    					// 높이 설정
    					style.height = 280;
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
    					InitColumnInfo(5, 3 , 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false) ;

    					var HeadTitle = "Cost Code|Account Code|Cost Type I|Cost Type Ⅱ|Accrual Type";

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, true);

    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "lgs_cost_cd"			,     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "acct_cd"					,     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true ,    "mn_cost_tp_cd"		,     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "sub_cost_tp_cd"		,     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "accl_auto_cd"		,     false,          "",       dfNone,          0,     true,       true);

    					RangeBackColor(1,1, 1,13) = RgbColor(222, 251, 248);   // ENIS
    					HeadRowHeight = 21 ;
    					HeadRowHeight = 20 ;

    				}
    				break;
    		}
    	}

      // Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {

    		   case IBSEARCH:      //조회
    			  	formObj.f_cmd.value = SEARCH;
    			  	//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
    			  	
    			  	var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
    			  	
    			  	
    			    //showErrMessage(searchXml);
    			    if(searchXml != "") sheetObj.LoadSearchXml(searchXml, false);
                break;

    		   case IBDOWNEXCEL:        //엑셀 다운로드
    			 // sheetObj.Down2Excel(-1, false, false, true);
    			   sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "",true);

    		  break;

    		}
    	}


      // Sheet관련 프로세스 처리
    	function doActionIBSheet2(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBSEARCH_ASYNC01:      //조회
    				formObj.f_cmd.value = SEARCH01;
    				//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
    				
    				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
    				
    				
    			    //showErrMessage(searchXml);
    			    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);			    
    			    break;
    			case IBSEARCH_ASYNC02:      //조회
    			  	formObj.f_cmd.value = SEARCH02;
    				//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
    				
    				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
    				
    				
    			    //showErrMessage(searchXml);
    			    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
    			    break;
    		}
    	}


       /**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
//                if (!isNumber(iPage)) {
    //
//                    return false;
//                }
    		}

    		return true;
    	}

    	/**
    	 * 해당 Sheet change Event발생시 실행하는 함수.
    	 *
    	 */
    	function sheet1_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
    	{ 
          sText = sheetObj.CellText(sheetObj.MouseRow,sheetObj.MouseCol);
         
          //마우스 모양 설정하기
          if (sheetObj.MouseCol == 2 || sheetObj.MouseCol == 4 || sheetObj.MouseCol == 6){
               //풍선도움말 만들기
          		sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
          }

      }	
        
       /**
         * EnterKey Event 조회 프로세스 처리
         */
    		function lea_enterRetrieve(){
    			var sheetObject = sheetObjects[0];
    			var formObject = document.form;
     			sheetObject.RemoveAll();
     			doActionIBSheet(sheetObject,formObject,IBSEARCH);
    		}
     		
       /**
         * Form Data를Sheet로 Copy 프로세스 처리
         */
    		function lea_form2sheet(formObj, sheetObj){
    			sheetObj.RemoveAll();
    			var Row = sheetObj.DataInsert(-1);
    			sheetObj.CellValue(Row , "mn_cost_tp_cd"	) = formObj.mn_cost_tp_cd.Text		;
    			sheetObj.CellValue(Row , "sub_cost_tp_cd"	) = formObj.sub_cost_tp_cd.Text		;
    			sheetObj.CellValue(Row , "lgs_cost_cd"		) = formObj.frm_cost_cd.value		;
    			sheetObj.CellValue(Row , "acct_cd"			) = formObj.frm_acct_cd.value		;
    			sheetObj.CellValue(Row , "accl_auto_cd"	  	) = formObj.frm_accl_type_cd.Text	;
    		}

        		

	/* 개발자 작업  끝 */