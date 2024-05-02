/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0085.js
*@FileTitle : Quota Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.19 KSJ
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
     * @class ESM_SPC_0106 : ESM_SPC_0103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0085() {
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
    var sheetObjects = new Array();
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var searchParams = "";
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        /*******************************************************/
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");
		
        switch(srcName) {

    	    case "btn_retrieve":
    	    	
	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;
	            
			case "btn_new":
				if(checkModifiedSheet(sheetObjects)) {
					if(ComShowConfirm (getMsg("SPC90001")) != 1) {
						return;
					}
				}
            	//공통함수사용: 화면을 초기화
				resetAll();
				ComBtnDisable("btn_rowadd");

		    	SpcSearchOptionTrade("trade", true, true, '', false, true);
		    	SpcSearchOptionSubTrade("subtrade", true, true, true, '', '', true);
		    	SpcSearchOptionLane("lane", true, false, '', '', '', '', true);
		    	initSheetCombo();
				break;
				
    	    case "btn_save":
    	    	if(beforetab == 0){
    	    		doActionIBSheet(sheetObject, formObject, IBSAVE);
    	    	}else{
    	    		doActionIBSheet(sheetObject1, formObject, IBSAVE);
    	    	}
    	        break;
    	        
    	    case "btn_rowadd":
    	    	
    	    	if(beforetab == 0){
    	    		sheetObject.DataInsert();
    	    	}else{
    	    		sheetObject1.DataInsert();
    	    	}
    	    	break;
    	    	
    	    case "btn_close":
    	    	window.returnValue = "CLOSE";
    	    	self.close();
    	        break;

		} // end switch
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	SpcSearchOptionTrade("trade", true, true, '', false, true);
    	SpcSearchOptionSubTrade("subtrade", true, true, true, '', '', true);
    	SpcSearchOptionLane("lane", true, false, '', '', '', '', true);
    	
        var tdisp = "block";
        
        for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
        }
   
        var sheetResizeFull = true;
		document_onresize();
		
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		
		// Sheet ComboBox 초기화
		initSheetCombo();
		
		// Row Add 버튼 비활성화 - 조회 후 활성화
		ComBtnDisable("btn_rowadd");
		
		//Axon 이벤트 처리1. 이벤트catch
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);  
	    
	    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
    	var formObj  = document.form;
    	 switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "by Quarter" , -1 );
                    InsertTab( cnt++ , "by VVD" , -1 );
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

        switch(sheetNo) {

            case 1:      //sheet1 init - by Quarter
				initSheet1(sheetObj);
                break;
            case 2:      //sheet2 init - by VVD
            	initSheet2(sheetObj);
            	break;
            case 3:      //sheet3 init
            	initSheet3(sheetObj);
            	break;
        }
    }
    
	/**
     * TabSheet1에서 조회후 타이틀 변경
     */
	function initSheet1(sheetObj){
	       with (sheetObj) {
	            // 높이 설정
	    	    //style.height = 100 ;
	    	    style.height = getSheetHeight(19) ;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
				
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	
	            Editable = true;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 2, 1, 9, 100);
	            
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(13, 0, 0, false);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(false, true, true, true, false,false) ;
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, "DEL|STS|Trade|Sub\nTrade|Lane|Year|Quarter|QTA|QTA|QTA|QTA|QTA|QTA", true);
	            InitHeadRow(1, "DEL|STS|Trade|Sub\nTrade|Lane|Year|Quarter|SELBR/E/R|SELBK|SELBS|Total|PUSBS|SELSC", true);
	            
				var cnt = 0;
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,      40,    daCenter,   true,    "del",     	false,          "",       dfNone,       0,     true,        true, -1, false, false, "", false);
				InitDataProperty(0, cnt++ , dtHiddenStatus,  50,    daCenter,   true,    "ibflag",  	false,          "",       dfNone,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtComboEdit ,    50,    daCenter,   true,    "trd_cd",  	true ,          "",       dfNone,       0,     false,       true );
				InitDataProperty(0, cnt++ , dtComboEdit ,    50,    daCenter,   true,    "sub_trd_cd",  true ,          "",       dfNone,       0,     false,       true );
	            InitDataProperty(0, cnt++ , dtComboEdit ,    70,    daCenter,   true,    "rlane_cd",    true ,          "",       dfNone,       0,     false,       true );
	            InitDataProperty(0, cnt++ , dtComboEdit ,    50,    daCenter,   true,    "bse_yr",      true ,          "",       dfNone,       0,     false,       true );
	            InitDataProperty(0, cnt++ , dtComboEdit ,    70,    daCenter,   true,    "bse_qtr_cd",  true ,          "",       dfNone,       0,     false,       true );
	            InitDataProperty(0, cnt++ , dtData      ,    80,    daRight,    true,    "qta_ratio1",  false,          "",       dfInteger,    0,     true,        true );
	            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_ratio2",  false,          "",       dfInteger,    0,     true,        true );
	            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_ratio3",  false,          "",       dfInteger,    0,     true,        true );
	            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_sub",     false,          "",       dfInteger,    0,     false,       false);
	            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_ratio4",  false,          "",       dfInteger,    0,     true,        true );
	            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_ttl",     false,          "",       dfInteger,    0,     false,       false);
	            
	            InitDataCombo(0, "bse_qtr_cd", " |1Q|2Q|3Q|4Q", " |1Q|2Q|3Q|4Q");

                HeadRowHeight  = 10;
	       }
	}
	
	/**
	 * TabSheet2에서 조회후 타이틀 변경
	 */
	function initSheet2(sheetObj){
		with (sheetObj) {
			// 높이 설정
			//style.height = 100 ;
			style.height = getSheetHeight(19) ;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 2, 1, 9, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, "DEL|STS|Trade|Sub\nTrade|Lane|VVD|QTA|QTA|QTA|QTA|QTA|QTA", true);
            InitHeadRow(1, "DEL|STS|Trade|Sub\nTrade|Lane|VVD|SELBR/E/R|SELBK|SELBS|Total|PUSBS|SELSC", true);
			
			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtDelCheck,      40,    daCenter,   true,    "del",     	false,          "",       dfNone,       0,     true,        true, -1, false, false, "", false);
			InitDataProperty(0, cnt++ , dtHiddenStatus,  50,    daCenter,   true,    "ibflag",  	false,          "",       dfNone,       0,     true,        true);
			InitDataProperty(0, cnt++ , dtComboEdit ,    50,    daCenter,   true,    "trd_cd",  	true ,          "",       dfNone,       0,     false,       true );
			InitDataProperty(0, cnt++ , dtComboEdit ,    70,    daCenter,   true,    "sub_trd_cd",  true ,          "",       dfNone,       0,     false,       true );
            InitDataProperty(0, cnt++ , dtComboEdit ,    50,    daCenter,   true,    "rlane_cd",    true ,          "",       dfNone,       0,     false,       true );
            InitDataProperty(0, cnt++ , dtData      ,    120,   daCenter,   true,    "vvd",         true ,          "",       dfNone,       0,     false,       true );
            InitDataProperty(0, cnt++ , dtData      ,    80,    daRight,    true,    "qta_ratio1",  false,          "",       dfInteger,    0,     true,        true );
            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_ratio2",  false,          "",       dfInteger,    0,     true,        true );
            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_ratio3",  false,          "",       dfInteger,    0,     true,        true );
            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_sub",     false,          "",       dfInteger,    0,     false,       false);
            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_ratio4",  false,          "",       dfInteger,    0,     true,        true );
            InitDataProperty(0, cnt++ , dtData      ,    60,    daRight,    true,    "qta_ttl",     false,          "",       dfInteger,    0,     false,       false);

            HeadRowHeight  = 10;
		}
	}
	
	/**
	 * TabSheet2에서 조회후 타이틀 변경
	 */
	function initSheet3(sheetObj){
		with (sheetObj) {
			// 높이 설정
			//style.height = 100 ;
			style.height = getSheetHeight(19) ;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 9, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(13, 0, 0, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, "DEL|STS|Trade|Sub\nTrade|Lane|BSE_YR|BSE_QTA|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|TEAM_CD|RATIO|APLY_CD", true);
			
			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCheckBox,    40,    daCenter,   true,    "del",     	false,          "",       dfNone,       0,     true,        true, -1, false, false, "", false);
			InitDataProperty(0, cnt++ , dtStatus  ,    50,    daCenter,   true,    "ibflag",  	false,          "",       dfNone,       0,     true,        true);
			InitDataProperty(0, cnt++ , dtData    ,    50,    daCenter,   true,    "trd_cd",  	false ,          "",       dfNone,       0,     true,       true );
			InitDataProperty(0, cnt++ , dtData    ,    70,    daCenter,   true,    "sub_trd_cd",  false ,          "",       dfNone,       0,     true,       true );
			InitDataProperty(0, cnt++ , dtData    ,    50,    daCenter,   true,    "rlane_cd",    false ,          "",       dfNone,       0,     true,       true );
			InitDataProperty(0, cnt++ , dtData    ,    50,    daCenter,   true,    "bse_yr",      false ,          "",       dfNone,       0,     true,       true );
			InitDataProperty(0, cnt++ , dtData    ,    50,    daCenter,   true,    "bse_qtr_cd",  false ,          "",       dfNone,       0,     true,       true );
			InitDataProperty(0, cnt++ , dtData    ,    120,   daCenter,   true,    "vsl_cd",      false ,          "",       dfNone,       0,     true,       true );
			InitDataProperty(0, cnt++ , dtData    ,    120,   daCenter,   true,    "skd_voy_no",  false ,          "",       dfNone,       0,     true,       true );
			InitDataProperty(0, cnt++ , dtData    ,    120,   daCenter,   true,    "skd_dir_cd",  false ,          "",       dfNone,       0,     true,       true );
			InitDataProperty(0, cnt++ , dtData    ,    120,   daCenter,   true,    "sls_rep_ofc_team_cd",     false ,          "",       dfNone,       0,     true,       true );
			InitDataProperty(0, cnt++ , dtData    ,    80,    daRight,    true,    "team_qta_rto",  false,          "",       dfNone,    0,     true,        true );
			InitDataProperty(0, cnt++ , dtData    ,    80,    daRight,    true,    "qta_aply_cd",  false,          "",       dfNone,    0,     true,        true );
			
			HeadRowHeight  = 10;
		}
	}
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;		
		
        switch(sAction) {
			
           case IBSEARCH:      //조회
        	   
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
				
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.ReDraw=false;
				sheetObj.RemoveAll();
				sheetObjects[1].RemoveAll();
				
				var param = SpcFormString(formObj,"f_cmd,trade,subtrade,lane");
				param += "&type=Q";
				rtn = sheetObjects[0].GetSearchXml("ESM_SPC_0085GS.do", param);
				sheetObj.LoadSearchXml(rtn); 
				sheetObj.ReDraw=true;
				

				sheetObjects[1].ReDraw=false;
				formObj.f_cmd.value = SEARCHLIST02;
				var param1 = SpcFormString(formObj,"f_cmd,trade,subtrade,lane");
				param1 += "&type=V";
				rtn1 = sheetObjects[1].GetSearchXml("ESM_SPC_0085GS1.do", param1);
				sheetObjects[1].LoadSearchXml(rtn1); 
				sheetObjects[1].ReDraw=true;
    			
				ComBtnEnable("btn_rowadd");
				break;

            case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				}
				
	    		copyToSheet3(sheetObj);
				
				formObj.f_cmd.value = MULTI;
				
				var param = SpcFormString(formObj,"f_cmd");				
                var rtn = doSaveSheet(sheetObjects[2], "ESM_SPC_0085GS.do",param,null);
                break;
                
           case IBDOWNEXCEL:        //엑셀 다운로드              
              sheetObj.Down2Excel(-1, false, false, true);
              break;
        }
    }
    
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        switch(sAction) {
			
		    case IBSAVE:
	    		for(i=2; i<sheetObj.RowCount+2; i++){
	    			if(sheetObj.CellValue(i, "qta_ttl") != 100){
	    				ComShowMessage(getMsg("SPC90134"));
	    				sheetObj.SelectCell(i, "qta_ttl");
	    				
	    				return false;
	    			}
	    		}
		    	return true;
		}
		return true;
    }
    
    /**
     * Save 후 메시지 처리
     * @param sheetObj
     * @param errMsg
     */
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	if(sheetObj.EtcData("status") == "OK"){
    		ComShowMessage("saved successfully.");  
    	}else{
    		ComShowMessage(errMsg);
    	}
    }
    
    /**
     * Save 후 메시지 처리
     * @param sheetObj
     * @param errMsg
     */
    function sheet2_OnSaveEnd(sheetObj, errMsg) {
    	if(sheetObj.EtcData("status") == "OK"){
    		ComShowMessage("saved successfully.");  
    		
    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	}else{
    		ComShowMessage(errMsg);
    	}
    }
    
    /**
     * Save 후 메시지 처리
     * @param sheetObj
     * @param errMsg
     */
    function sheet3_OnSaveEnd(sheetObj, errMsg) {
    	var formObj = document.form;
    	
    	if(beforetab == 0){
    		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    	}else{
    		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
    	}
    }
    
    /**
     * Sheet1 Onchange Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var sName = sheetObj.ColSaveName(Col);
    	var qta_sub = 0;
    	var qta_ttl = 0;

    	switch(sName){
    		// QTA 입력시 Total / SELSC 항목 값 구하기
	    	case "qta_ratio1":
	    	case "qta_ratio2":
	    	case "qta_ratio3":
	    	case "qta_ratio4":
	    		qta_sub = parseInt(sheetObj.CellValue(Row, "qta_ratio1")) + parseInt(sheetObj.CellValue(Row, "qta_ratio2")) + parseInt(sheetObj.CellValue(Row, "qta_ratio3"));
	    		qta_ttl = qta_sub + parseInt(sheetObj.CellValue(Row, "qta_ratio4"));
	    		
	    		sheetObj.CellValue2(Row, "qta_sub") = qta_sub;
	    		sheetObj.CellValue2(Row, "qta_ttl") = qta_ttl;
	    		
	    		if(sheetObj.CellValue(Row, "qta_ttl") > 100){
    				ComShowMessage(getMsg("SPC90134"));
    				sheetObj.SelectCell(Row, Col);
    			}
	    		
	    		break;
	    		
	    	// 노선 변경시 해당하는 Trade / Sub Trade Code 셋팅
	    	case "rlane_cd":
	    		var text = getSheetComboText(sheetObj, Row, Col, 0, "rlane_cd", Value);
	    		sheetObj.CellValue2(Row, "trd_cd") = text;
               
                text = getSheetComboText(sheetObj, Row, Col, 1, "rlane_cd", Value);
                sheetObj.CellValue2(Row, "sub_trd_cd") = text; 
	    		break;
	    	
	    	// Sub Trade 변경시 해당하는 Trade 셋팅 및 노선 초기화
	    	case "sub_trd_cd":
	    		var text = getSheetComboText(sheetObj, Row, Col, 0, "sub_trd_cd", Value);
	    		sheetObj.CellValue2(Row, "trd_cd") = text;
	    		initDataValue_lane();
                break;
                
            // Trade 변경시 Sub Trade / 노선 초기화
	    	case "trd_cd":
	    		initDataValue_subtrade();
	    		initDataValue_lane();
                break;
    	}
    }
    
    /**
     * Sheet2 Onchange Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @param Value
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value){
    	var sName = sheetObj.ColSaveName(Col);
    	var vvd_sub = 0;
    	var vvd_ttl = 0;

    	switch(sName){
    		// QTA 변경시 Total / SELSC 항목 반영
	    	case "qta_ratio1":
	    	case "qta_ratio2":
	    	case "qta_ratio3":
	    	case "qta_ratio4":
	    		qta_sub = parseInt(sheetObj.CellValue(Row, "qta_ratio1")) + parseInt(sheetObj.CellValue(Row, "qta_ratio2")) + parseInt(sheetObj.CellValue(Row, "qta_ratio3"));
	    		qta_ttl = qta_sub + parseInt(sheetObj.CellValue(Row, "qta_ratio4"));
	    		
	    		sheetObj.CellValue2(Row, "qta_sub") = qta_sub;
	    		sheetObj.CellValue2(Row, "qta_ttl") = qta_ttl;
	    		
	    		if(sheetObj.CellValue(Row, "qta_ttl") > 100){
    				ComShowMessage(getMsg("SPC90134"));
    				sheetObj.SelectCell(Row, Col);
    			}
	    		break;
	    		
	    	// 노선 변경시 해당하는 Trade / Sub Trade Code 셋팅
	    	case "rlane_cd":
	    		var text = getSheetComboText(sheetObj, Row, Col, 0, "rlane_cd", Value);
	    		sheetObj.CellValue2(Row, "trd_cd") = text;
	           
	            text = getSheetComboText(sheetObj, Row, Col, 1, "rlane_cd", Value);
	            sheetObj.CellValue2(Row, "sub_trd_cd") = text; 
	    		break;

		   	// Sub Trade 변경시 해당하는 Trade 셋팅 및 노선 초기화	
	    	case "sub_trd_cd":
	    		var text = getSheetComboText(sheetObj, Row, Col, 0, "sub_trd_cd", Value);
	    		sheetObj.CellValue2(Row, "trd_cd") = text;
	    		initDataValue_lane();
	            break;

	        // Trade 변경시 Sub Trade / 노선 초기화
	    	case "trd_cd":
	    		initDataValue_subtrade();
	    		initDataValue_lane();
                break;
    	}
    }
    

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
    	      	
        var formObj = document.form;
        var objs = document.all.item("tabLayer");
    	    	
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    		
    	beforetab = nItem;
    }
    
    /**
     * 조회조건의 Trade Code 변경 시 
     *  - Sub Trade 및 노선을 해당 Trade 에 속하는 값으로 셋팅
     */
    function trade_OnChange(comObj,value,text ){
    	comObjects[1].index2 = 0; 
  	  
    	//lane의 초기화
    	comObjects[2].Index2 = 0;  
    	SpcSearchOptionSubTrade("subtrade", true, true, true, '', value, true);
    	SpcSearchOptionLane("lane", true, false, '', value, '', true, true);
    }
    
    /**
     * 조회조건의 Sub Trade 변경 시 
     *  - 선택된 Sub Trade에 해당하는 Trade 및 노선 셋팅
     * @param comObj
     * @param value
     * @param text
     */
    function subtrade_OnChange(comObj,value,text ){
    	SpcSearchOptionLane("lane", true, false, '', document.form.trade.Code, value, true, true);
    	
		if(value == "") return;
	
		var arrTrade = text.split("|");
		if(arrTrade.length > 1) {
			comObjects[0].Code2 = arrTrade[0];
			comObjects[2].Code2 = '';
		} else {
			comObjects[0].Code2 = comObj.GetText(value,0);  
			comObjects[2].Code2 = '';
		}  
	} 
    
    /**
     * 조회조건의 노선 변경시
     *  - 선택된 노선에 해당하는 Trade / Sub Trade 로 셋팅 
     * @param comObj
     * @param value
     * @param text
     */
	function lane_OnChange(comObj,value,text ){
		if(value == "" ) return;
	
		var arrLane = text.split("|");
		if(arrLane.length > 1) {
			comObjects[0].Code2 = arrLane[0];
			comObjects[1].Code2 = arrLane[1];
		} else {
			comObjects[0].Code2 = comObj.GetText(value,0);  
			comObjects[1].Code2 = comObj.GetText(value,1);  
		}	
	}
	
	/**
	 * Combo 초기화
	 */
	function initSheetCombo() {
		initSheetCombo_trade();
		initSheetCombo_subtrade();
		initSheetCombo_lane();
		initSheetCombo_year();
	}
	
	/**
	 * Trade Combo 셋팅
	 */
	function initSheetCombo_trade() {
		var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        
        var rtn = getCodeXmlList("TradeCombo", "isRepTrade=true&del=&isPus=true");
        
        var arrData = ComXml2ComboString(rtn, "trd_cd", "trd_nm");
        
        if (arrData != null){
            var arrCode = arrData[0].split("|");
            var arrName = arrData[1].split("|");
            var conData = "";
            for(i=0; i < arrName.length;i++){
                if(i==0){
                    arrName[i] = arrCode[i]+"\t"+arrName[i];
                }else{
                    arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
                }
                conData = conData.concat(arrName[i]);
            }
            arrData[1] = conData;
        }
        arrData[0] = " |" + arrData[0];
        arrData[1] = " |" + arrData[1];
        
        sheetObject.InitDataCombo(0, "trd_cd", arrData[1], arrData[0]);
        sheetObject1.InitDataCombo(0, "trd_cd", arrData[1], arrData[0]);
	}
	
	/**
	 * Sub Trade Combo 셋팅
	 */
	function initSheetCombo_subtrade() {
		var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var rtn ; 
        
        rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=true&del=&isAll=true&isPus=true");
        
        
        var arrData = SpcXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
        
        arrData[0] = " |" + arrData[0];
        arrData[1] = "\t\t|" + arrData[1];
        
        sheetObject.InitDataCombo(0, "sub_trd_cd", arrData[1], arrData[0], "", "", 1);
        sheetObject1.InitDataCombo(0, "sub_trd_cd", arrData[1], arrData[0], "", "", 1);
	}
	
	/**
	 * Lane Combo 셋팅
	 */
	function initSheetCombo_lane() {
		var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var rtn;
        
       	rtn = getCodeXmlList("RLaneCombo", "del=&ipc=&isPus=true");
        var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
        
        arrData[0] = " |" + arrData[0];
        arrData[1] = "\t\t\t|" + arrData[1];
        
       	sheetObject.InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
       	sheetObject1.InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
	}
	
	/**
	 * 년도 Combo 셋팅
	 */
	function initSheetCombo_year() {
		var sheetObject  = sheetObjects[0];
        
		var today = new	Date();
		var year  = today.getFullYear();
		
		var pre  = 2;
		var post = 1;
		
		var code = " ";
		
		for (var i = year + pre; i > year - pre - post; i--) {
			code = code + "|" + i;
		}
        
        sheetObject.InitDataCombo(0, "bse_yr", code, code);
	}

	/**
	 * Trade 초기값 셋팅
	 */
    function initDataValue_trade(){
     	var sheetObj = document.getElementById("trade");
     	with(sheetObj){
     		Index2 = 0;
     	}
     }
     
    /**
     * Sub Trade 초기값 셋팅
     */
     function initDataValue_subtrade(){
     	var sheetObj = document.getElementById("subtrade");
     	with(sheetObj){
     		Index2 = 0;
     	}
     }
     
     /**
      * Lane 초기값 셋팅
      */
     function initDataValue_lane(){
     	var sheetObj = document.getElementById("lane");
     	with(sheetObj){
     		Index2 = 0;
     	}
     } 
     
     function copyToSheet3(sheetObj){
    	 sheetObj3 = sheetObjects[2];
    	 var team_cd = new Array("OTHER", "SELBK", "SELBS", "PUSBS");
    	 var qta_aply_cd = (beforetab==0?"Q":"V");
    	 
    	 sheetObj3.RemoveAll();
    	 
    	 for(i=2; i<sheetObj.RowCount + 2; i++){
    		 if(sheetObj.CellValue(i, "ibflag") != "R" ){
	    		 for(j=0; j<4; j++){
	    			 row = sheetObj3.DataInsert(0);
	    			 
	    			 sheetObj3.CellValue2(row, "del")                 = sheetObj.CellValue(i, "del");
	    			 sheetObj3.CellValue2(row, "ibflag")              = (sheetObj.CellValue(i, "ibflag")=="D"?"U":sheetObj.CellValue(i, "ibflag"));
	    			 sheetObj3.CellValue2(row, "trd_cd")              = sheetObj.CellValue(i, "trd_cd");
	    			 sheetObj3.CellValue2(row, "sub_trd_cd")          = sheetObj.CellValue(i, "sub_trd_cd");
	    			 sheetObj3.CellValue2(row, "rlane_cd")            = sheetObj.CellValue(i, "rlane_cd");
	    			 
	    			 if(beforetab == 0){
		    			 sheetObj3.CellValue2(row, "bse_yr")          = sheetObj.CellValue(i, "bse_yr");
		    			 sheetObj3.CellValue2(row, "bse_qtr_cd")      = sheetObj.CellValue(i, "bse_qtr_cd");
	    			 }else{
		    			 sheetObj3.CellValue2(row, "vsl_cd")          = sheetObj.CellValue(i, "vvd").substring(0, 4);
		    			 sheetObj3.CellValue2(row, "skd_voy_no")      = sheetObj.CellValue(i, "vvd").substring(4, 8);
		    			 sheetObj3.CellValue2(row, "skd_dir_cd")      = sheetObj.CellValue(i, "vvd").substring(8);
	    			 }
	    			 sheetObj3.CellValue2(row, "sls_rep_ofc_team_cd") = team_cd[j];
	    			 sheetObj3.CellValue2(row, "team_qta_rto")        = sheetObj.CellValue(i, "qta_ratio"+(j+1));
	    			 sheetObj3.CellValue2(row, "qta_aply_cd")         = qta_aply_cd;
	    		 }
    		 }
    	 }
     }
	/* 개발자 작업  끝 */
