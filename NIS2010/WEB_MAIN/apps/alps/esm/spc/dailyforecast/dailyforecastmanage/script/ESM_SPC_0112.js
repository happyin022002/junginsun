/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0112.js
*@FileTitle : Account Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
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
     * @class ESM_SPC_0112 : ESM_SPC_0103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0112() {
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
				break;
				
    	    case "btn_save":
    	    	doActionIBSheet(sheetObject, formObject, IBSAVE);
    	        break;
    	        
    	    case "btn_close":
    	    	window.returnValue = "CLOSE";
    	    	self.close();
    	        break;
    	        
    	    case "btng_rowadd":
    	    	var row = sheetObjects[0].DataCopy(false);
    	    	
    	    	var rtn = getCodeXmlList("TeamSalesRep", "ofc_cd=" + formObject.ofc_cd.value + "&level=4");
    	    	var arrData = SpcXml2ComboItem(rtn, "code", "text");
    	    	
    	    	ShowCol = 0;
    			MultiSelect = false;
    			var codes = arrData[0].split("|");
    			var names = arrData[1].split("|");
    			var arrName = "";
    			
    			var selectCode = "";
    			for ( var i = 0; i < codes.length - 1; i++) {
    				var txt = names[i].split("~");
    				arrName += "|" + txt[0];
    			}
                
                arrData[0] = "|" + arrData[0];
                sheetObject.CellComboItem(row, "srep_cd", arrName, arrData[0])
    	    	break;
                
    	    case "btn_downexcel": // 엑셀 다운로드
    	    	sheetObject.Down2Excel(-1, false, false, true);
    			break;
    			
    	    case "btn_upload":
    	    	sheetObject.RemoveAll();
    	    	
   				sheetObject.LoadExcel(true, 1, "", 1, -1, "", false);
   				
   				validateUpload(sheetObject, formObject);       					
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
        tab_retrives = new Array(sheetObjects.length);
        var tdisp = "block";
        
        for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
        }
        
        initSheetCombo_subtrade(sheetObjects[0]);
        
        var sheetResizeFull = true;
		document_onresize();
		
		//Axon 이벤트 처리1. 이벤트catch
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);  
	    

		//  화면 로드시 자동조회하되록함.
		//-----------------------------------------------------
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		//-----------------------------------------------------
	    
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
				initSheet1(sheetObj);
                break;
        }
    }
    
	/**
	 * TabSheet2에서 조회후 타이틀 변경
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
			MergeSheet = msNone;
			
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 9, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(19, 0, 0, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, "Del||Code|Name|Level|Type|S.REP||SUB TRD 1|SUB TRD 2|SUB TRD 3|SUB TRD 4|SUB TRD 5|", true);
			
			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtDelCheck 		,    25,    daCenter,   true,    "sel",     		false,          "",       dfNone,       0,     true,       true, -1, false, false, "", false);
			
			InitDataProperty(0, cnt++ , dtHiddenStatus	,    50,    daCenter,   true,    "ibflag",     		false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 			,    80,    daCenter,   true,    "cust_cd",     	false,         	"",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 			,    250,   daLeft,   	true,    "cust_nm",     	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 			,    50,    daCenter,   true,    "cust_lvl",    	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtCombo			,    50,    daCenter,   true,    "rvis_cntr_cust_tp_cd",     	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtCombo			,    90,    daCenter,   true,    "srep_cd",     	true,           "",       dfNone,       0,     true,      true);
			InitDataProperty(0, cnt++ , dtHidden 		,    70,    daCenter,   true,    "srep_usr_id",    	false,          "",       dfNone,       0,     false,     false);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_1",     	true,           "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_2",     	false,          "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_3",     	false,          "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_4",     	false,          "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_5",     	false,          "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtHidden		,    80,    daCenter,   true,    "sub_trd_cd",     	false,          "",       dfNone,       0,     true,      true);
			InitDataProperty(0, cnt++ , dtHidden 		,    70,    daCenter,   true,    "srep_nm",    		false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 		,    70,    daCenter,   true,    "indiv_cust", 		false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 		,    20,    daCenter,   true,    "cust_cnt_cd", 	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 		,    40,    daCenter,   true,    "cust_seq",   		false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 		,    40,    daCenter,   true,    "delt_flg",   		false,          "",       dfNone,       0,     false,      false);

			HeadRowHeight  = 10;
			
			InitDataCombo (0, "rvis_cntr_cust_tp_cd", "BCO|NVO", "B|N");
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
				sheetObjects[0].RemoveAll();
				
				var param = SpcFormString(formObj,"f_cmd,ofc_cd,trade,cost_yrwk");
				var rtn = sheetObj.DoSearch4Post("ESM_SPC_0112GS.do", param);
				sheetObj.ReDraw=true;
				break;


            case IBSAVE:  
            	//저장
				if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				}
				
				formObj.f_cmd.value = MULTI;
				
				var param = SpcFormString(formObj,"f_cmd,trade,ofc_cd");
                var rtn = sheetObj.DoAllSave("ESM_SPC_0112GS.do",param);
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
        		
        		// 중복 Data 체크
        		// cust_cd | cust_nm| cust_lvl | rvis_cntr_cust_tp_cd | srep_cd
				var dup = sheetObj.ColValueDup("2|3|4|5|6");
        		
				if(dup != -1) {
					ComShowMessage(getMsg("SPC90135"));
					sheetObj.SelectCell(dup, 6);		// 중복된 행의 S.Rep 에 Focus
					return false;
				}
				
        		break;
		}
		return true;
    }
    
    function sheet1_OnSaveEnd(sheetObj, errMsg) {
    	if(sheetObj.EtcData("status") == "OK"){
    		ComShowMessage("saved successfully.");  
    		
    		window.returnValue = "OK";
    		self.close();
    	}else{
    		ComShowMessage(errMsg);
    	}
    }
    
    /**
     * Individual Check 시 
     * @param sheetObj
     * @param row
     * @param col
     * @param value
     */
    function sheet1_OnChange(sheetObj, row, col, value){
    	var formObj = document.form;
    	var sName = sheetObj.ColSaveName(col);
    	
    	switch(sName){
    	case "cust_indiv_flg":
    		sheetObj.CellValue2(row, "delt_flg") = value=="1"?"N":"Y";
    		break;
    	case "sel":
			sheetObj.CellValue2(row, "delt_flg") = value=="1"?"Y":"N";
			break;
    	case "sub_trd_1":
    	case "sub_trd_2":
    	case "sub_trd_3":
    	case "sub_trd_4":
    	case "sub_trd_5":
    		var text = getSheetComboText(sheetObj, row, col, 1);
    		sheetObj.CellValue2(row, col) = text;
    		
    		if(text == "ALL") {
    			var sCode   = sheetObj.GetComboInfo(row, col, "Code");
    			var arrCode = sCode.split("|");
    			
    			// Sub Trade 1 ~ 5 까지
    			for(var i=1; i < 6; i++) {
    				// arrCode 에서 최초의 NULL 제외 : - 1
    				if(i < arrCode.length - 1) {
    					// arrCode 에서 ALL 때문에 : + 1
    					sheetObj.CellValue2(row, "sub_trd_" + i) = arrCode[i+1];
    				} else {
    					sheetObj.CellText(row, "sub_trd_" + i) = " ";
    				}
    			}
    		}
    		
    		// Sub Trade 중복 제거 로직
			var chk  = "true";
	    	var arr1 = new Array();
	    	var arr2 = new Array();
	    	arr1[0] = ComTrim(sheetObj.CellValue(row, "sub_trd_1"));
	    	arr1[1] = ComTrim(sheetObj.CellValue(row, "sub_trd_2"));
	    	arr1[2] = ComTrim(sheetObj.CellValue(row, "sub_trd_3"));
	    	arr1[3] = ComTrim(sheetObj.CellValue(row, "sub_trd_4"));
	    	arr1[4] = ComTrim(sheetObj.CellValue(row, "sub_trd_5"));
	    	
	    	for(var i=0; i < arr1.length; i++) {
	    		for(var j=0; j < arr2.length; j++) {
	    			if(arr1[i] == arr2[j]) chk = "false";
	    		}
	    		        		
	    		if(arr1[i] != "" && chk == "true") arr2[arr2.length] = arr1[i];
	    		
	    		chk = "true";
	    	}
	    	
	    	sheetObj.CellValue2(row, "sub_trd_cd") = arr2;
    		break;
    	}
    }
    
    function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "engup":
	            if(obj.name=="srep_cd") ComKeyOnlyAlphabet('uppernum')
	            else ComKeyOnlyAlphabet('upper');
	            break;
	    }
	}
	 
	/**
	 * Sheet1의 조회 후
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){		
		var srep_cd = "";
    	var srep_nm = "";
    	var indiv_cust = "";
    	var sub_trd_cd = "";
    	
    	if(sheetObj.SearchRows == 0){
    		ComBtnDisable("btng_rowadd");
    	}else{
    		ComBtnEnable("btng_rowadd");
    	}
    	for(i = sheetObj.HeaderRows; i < sheetObj.RowCount + sheetObj.HeaderRows; i++){
    		srep_cd    = sheetObj.CellValue(i, "srep_usr_id");
    		srep_nm    = sheetObj.CellValue(i, "srep_nm");
    		indiv_cust = sheetObj.CellValue(i, "indiv_cust");
    		
    		sheetObj.CellComboItem(i, "srep_cd", srep_nm, srep_cd);
    		sheetObj.CellValue2(i, "srep_cd") = indiv_cust;
    		
    		sheetObj.CellValue2(i, "cust_cnt_cd") = (sheetObj.CellValue(i, "cust_cd")).substr(0, 2);
    		sheetObj.CellValue2(i, "cust_seq")    = (sheetObj.CellValue(i, "cust_cd")).substr(2);
    		
    		sheetObj.CellValue(i, "ibflag") = "R";
    	}
	}
   /**
     *  OTHERS 선택시 처리 
     */
    function sheet1_OnClick(sheetObj, row, col){    	
    	
    	switch(sheetObj.ColSaveName(col)){
    	case "srep_cd":
    		var mark = sheetObj.CellValue(row, col);
    		
    		if(mark == ""){
    			var rtn = getCodeXmlList("TeamSalesRep", "ofc_cd=" + document.form.ofc_cd.value + "&level=4");
    			var arrData = SpcXml2ComboItem(rtn, "code", "text");
	    	
    			ShowCol = 0;
    			MultiSelect = false;
    			var codes = arrData[0].split("|");
    			var names = arrData[1].split("|");
    			var arrName = "";
			
    			var selectCode = "";
    			for ( var i = 0; i < codes.length - 1; i++) {
    				var txt = names[i].split("~");
    				arrName += "|" + txt[0];
    			}
            
    			arrData[0] = "|" + arrData[0];
    			sheetObj.CellComboItem(row, "srep_cd", arrName, arrData[0])
    		}
 
    	}
    	
    }
	
	/**
	 * 화면 loading 시 Sheet 의 Combo 세팅
	 */
	function initSheetCombo_subtrade(sheetObj, ErrMsg){
		var formObject  = document.form;
		
		var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true&trdCd=" + formObject.trade.value);
        
        var arrData = SpcXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
        
        arrData[0] = " |ALL|" + arrData[0];
        arrData[1] = "\t \t|\tALL\t|" + arrData[1];
        
        sheetObj.InitDataCombo(0, "sub_trd_1", arrData[1], arrData[0], "", "", 1);
        sheetObj.InitDataCombo(0, "sub_trd_2", arrData[1], arrData[0], "", "", 1);
        sheetObj.InitDataCombo(0, "sub_trd_3", arrData[1], arrData[0], "", "", 1);
        sheetObj.InitDataCombo(0, "sub_trd_4", arrData[1], arrData[0], "", "", 1);
        sheetObj.InitDataCombo(0, "sub_trd_5", arrData[1], arrData[0], "", "", 1);
	}
	
	/**
     * Up Load 값의 유효성 체크
     */
    function validateUpload(sheetObj,formObj) {
    	var txet;
    	var col;
    	
    	var rtn = getCodeXmlList("TeamSalesRep", "ofc_cd=" + formObj.ofc_cd.value + "&level=4");
    	var arrData = SpcXml2ComboItem(rtn, "code", "text");
    	
    	ShowCol = 0;
		MultiSelect = false;
		var codes = arrData[0].split("|");
		var names = arrData[1].split("|");
		var arrName = "";
		
		var selectCode = "";
		for ( var i = 0; i < codes.length - 1; i++) {
			var txt = names[i].split("~");
			arrName += "|" + txt[0];
		}
        
        arrData[0] = "|" + arrData[0];
        sheetObj.InitDataCombo(0, "srep_cd", arrName, arrData[0]);
        
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			sheetObj.CellValue2(i, "cust_cnt_cd") = (sheetObj.CellValue(i, "cust_cd")).substr(0, 2);
    		sheetObj.CellValue2(i, "cust_seq")    = (sheetObj.CellValue(i, "cust_cd")).substr(2);
    		
    		col = sheetObj.SaveNameCol("srep_cd"); 
    		text = sheetObj.CellText(i, col);
    		sheetObj.CellText(i, "srep_cd") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_5"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_5") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_4"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_4") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_3"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_3") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_2"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_2") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_1"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_1") = text;
    		
    		sheet1_OnChange(sheetObj, i, col, text);
    	}
    }
	/* 개발자 작업  끝 */