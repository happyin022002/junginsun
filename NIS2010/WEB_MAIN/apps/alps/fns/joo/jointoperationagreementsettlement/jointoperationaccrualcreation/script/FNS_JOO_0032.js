/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_joo_0032.js
*@FileTitle : Estimate Report - Account
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.08 함대성
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
     * @class fns_joo_0032 : fns_joo_0032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0032() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    //New button click시에 IBCombo들의 change이벤트를 타지 못하도록 하기 위함
    var gNew = false;
    var gCurRow = 0;
    var prefix = "sheet1_";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch (srcName) {
			case "btns_back":
		    	sheetObjects[0].RemoveAll();
				if (formObject.exe_yrmon.value!=""){
					formObject.exe_yrmon.value = ComGetDateAdd(formObject.exe_yrmon.value+"-01","M",-1).substring(0,7);
				}
				break;
	
			case "btns_next":
				sheetObjects[0].RemoveAll();
				if (formObject.exe_yrmon.value!=""){
					formObject.exe_yrmon.value = ComGetDateAdd(formObject.exe_yrmon.value+"-01","M", 1).substring(0,7);
				}
				break;
  
    		case "btn_retrieve":
    			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    			break;
    			
    		case "btn_new":
    			sheetObject1.RemoveAll();
    			formObject.exe_yrmon.value = formObject.dt.value;
    			break;

 

    		case "btn_downExcel":
    			sheetObject1.SpeedDown2Excel();
    			break;
    		} // end switch
    	} catch (e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('JOO00001');
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
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /** 
     * IBCombo Object를 배열로 등록
     * param : combo_obj ==> 콤보오브젝트
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */ 
    function setComboObject(combo_obj) {  
        comboObjects[comboCnt++] = combo_obj;  
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

    	for (i = 0; i < sheetObjects.length; i++) {
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects[i]);

    		initSheet(sheetObjects[i], i + 1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],k+1);
        }
        
        //Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 			 
    	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerFormat('keypress',         'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
    	axon_event.addListener('keypress', 'exe_yrmon_keypress', 'exe_yrmon');
        
        sheetObjects[0].FitColWidth("0|10|10|10|10|20|20|20"); 
    }

   //Axon 이벤트 처리2. 이벤트처리함수
     function obj_deactivate(){
         ComChkObjValid(event.srcElement);
     }
     
     function obj_activate(){
         ComClearSeparator(event.srcElement);
     }  
    	 
     function exe_yrmon_keypress(){
       	ComKeyOnlyNumber(this, '');
     }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

    	var cnt = 0;

    	switch (sheetNo) {
    	case 1: //t1sheet1 init
    		with (sheetObj) {  
    			ScrollBar = 2;
                // 높이 설정
                style.height = 420;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(8, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)

                var HeadTitle = "|Item|Revenue Month|Revenue Lane|Revenue VVD|Estimated Amount|Actual Amount|Accrual Amount";

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,0,    daCenter,  true,   prefix+"ibflag");
                InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"item",         false,          "",      dfNone ,    0,     false,          false, false     );
                InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"rev_yrmon",     false,          "",      dfDateYm ,    0,     false,          false, false     );
                InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"rlane_cd",     false,          "",      dfNone ,    0,     false,          false, false     );
                InitDataProperty(0, cnt++ , dtData,    0,    daCenter,  true,    prefix+"rvvd",     false,          "",      dfNone  ,    0,     false,          false, false     );

                InitDataProperty(0, cnt++ , dtAutoSum,    0,    daRight,  true,    prefix+"estm_amt",     false,          "",      dfNullFloat,      2 ,     false,          false, false     );
                InitDataProperty(0, cnt++ , dtAutoSum,    0,    daRight,  true,    prefix+"act_amt",     false,          "",       dfNullFloat,      2 ,     false,          false, false     );
                InitDataProperty(0, cnt++ , dtAutoSum,    0,    daRight,  true,    prefix+"accl_amt",     false,          "",       dfNullFloat,      2 ,     false,          false, false     );
                
                sheetObj.FitColWidth("0|10|10|10|10|20|20|20"); 
    		} 
    		break;

    	}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) { 
    	
    	case IBSEARCH: //조회
    		if (validateForm(sheetObj, formObj, sAction)){
    			
    			formObj.f_cmd.value = SEARCH;
    	        var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열
    			//formObj.exe_yrmon.value = ComReplaceStr(formObj.exe_yrmon,"-","");
    			var sXml = sheetObj.GetSearchXml("FNS_JOO_0032GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
    			
    			var arrXml = sXml.split("|$$|");
    			sheetObj.LoadSearchXml(arrXml[0]);
    		}
    		break; 
    		 		
    	}
    }

    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
        var formObject = document.form
        
        switch(comboNo) {  
        	case 1: 
               with (comboObj) { 
    				MultiSelect = false; 
    				UseAutoComplete = true;	
    				SetColAlign("left|left");        
    				SetColWidth("0|30");
     				DropHeight = 160;
     		    }
                var comboItems = gCrrCombo.split("|");
                addComboItem(comboObj, comboItems);           	
     			break; 
     			
        	case 2: 
                with (comboObj) { 
     				MultiSelect = false; 
     				UseAutoComplete = true;	
     				SetColAlign("left|left");        
     				SetColWidth("0|30");
      				DropHeight = 160;
      		    }
      			break;
      			
        	case 3: 
                with (comboObj) { 
     				MultiSelect = false; 
     				UseAutoComplete = true;	
     				SetColAlign("left|left");        
     				SetColWidth("0|30");
      				DropHeight = 160;
      		    }
      			break;
     	} 
    }

    // 조회조건필드인 Lane SVC Type 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH: //TRADE
 
    														
    	        break;
        }
    }

   
    //R/E변경시 
    function exe_yrmon_OnChange(idx_cd, text){
    	if (gNew) return;
    	sheetObjects[0].RemoveAll();
    }
       
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) {
    		case IBCREATE: //저장용 조회
    		case IBSEARCH: //조회
    			//if (formObj.exe_yrmon.text.length < 3){
    			//	ComShowMessage("Select a Carrier code...");
    			//	return false;
    			//} 
 
    			break;
    			
 
    	}
    	return true;
    }

    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    }

 	function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
 		doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    }    
    
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
    	var sName = sheetObj.ColSaveName(Col);

    	var Value = sheetObj.EditValue;
    	//4자리 치면 NEXT로 이동
    	if ((sName == (prefix+"vsl_cd")) && (Value.length == 4)){
    		sheetObj.SelectCell(Row, prefix+"skd_voy_no",true);
    	}

    	//4자리 치면 NEXT로 이동
    	if (sName == prefix+"skd_voy_no" && Value.length==4){
    		sheetObj.SelectCell(Row, prefix+"skd_dir_cd",true);
    	}
    }

    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var sName = sheetObj.ColSaveName(Col);
    	var formObj = document.form;
    	gCurRow = Row;

    	//alert(Row+"_----->" +sheetObj.cellValue(Row, prefix+"closing_chk"));
    	 
    	/*
    	if (sName == prefix+"vsl_cd" || sName==prefix+"skd_voy_no" || sName==prefix+"skd_dir_cd" || sName==prefix+"rev_dir_cd"){
    		var vvd  = sheetObj.CellValue(Row, prefix+"vsl_cd");
    		vvd += sheetObj.CellValue(Row, prefix+"skd_voy_no");
    		vvd += sheetObj.CellValue(Row, prefix+"skd_dir_cd");
    		vvd += sheetObj.CellValue(Row, prefix+"rev_dir_cd");
    		
    		if (vvd.length == 10){
    			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    		}
    	}*/
    }

	/* 개발자 작업  끝 */