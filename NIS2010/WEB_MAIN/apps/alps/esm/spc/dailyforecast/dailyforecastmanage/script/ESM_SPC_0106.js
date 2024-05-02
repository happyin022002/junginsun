/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0106.js
*@FileTitle : Account Registration 
*Open Issues :
*Change history :
*2008-03-04 김원섭
*   - Summarize 기능 개선
* 2008-09-10 임옥영 CSR:N200809090009
* 각 지역그룹팀에 대한 권한부여 
* 2008-10-10 임옥영 CSR:N200810070001
*   -SINRS에 SELCDO와 동일한 권한 부여
* 2009-03-27 최윤성 CSR:R200903190002
* - SPC_SREP_CUST_MAPG 테이블의 SREP_USR_ID -> SREP_CD 컬럼명 수정
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2012.11.22 최윤성 [CHM-201221575-01] [SPC] 한국지점 Forecast Input 화면 Header 부분 로직 보완 - alert 메시지 내용 수정
* 2013.01.02 최윤성 [CHM-201322312-01] FCST Input(SELSC) 2차 수정요청
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.07.01 진마리아 [선처리] alps error log 관련, customer seq 에 붙여넣기 기능을 통한 문자열이 들어가는 경우 방지
* 2015.11.19 이혜민 [CHM-201538569] FCST Input > Account Add/Del 사용시 Data 확인 및 팝업처리 요청
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
    function ESM_SPC_0106() {
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
        var sheetObject1 = sheetObjects[1];
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
    	    	doActionIBSheet(sheetObject1, formObject, IBSAVE);
    	        break;
    	        
    	    case "btn_downexcel": // 엑셀 다운로드
    	    	sheetObject1.Down2Excel(-1, false, false, true);
    			break;
    			
    	    case "btn_upload":
    	    	sheetObject1.RemoveAll();
    	    	
    	    	sheetObject1.ReDraw=false;
    	    	sheetObject1.LoadExcel(true, 1, "", 1, -1, "", false);
   				
   				validateUpload(sheetObject1, formObject);
   				sheetObject1.ReDraw=true;
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
        tab_retrives = new Array(sheetObjects.length);
        var tdisp = "block";
        
        for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
        }
        
        initSheetCombo_subtrade(sheetObjects[1]);
        
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
            case 2:      //sheet2 init
            	initSheet2(sheetObj);
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
	            SheetWidth = mainTable1.clientWidth;
				
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msNone;
	
	            Editable = true;
	
	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 1, 1, 9, 100);
	            
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(3, 0, 0, false);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(false, true, true, true, false,false) ;
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, "S.OFC|S.REP|S.REP Name", true);
	            
				var cnt = 0;
	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "sls_ofc_cd",  false,          "",       dfNone,       0,     false,       false);
	            InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "srep_cd",     false,          "",       dfNone,       0,     false,       false);
	            InitDataProperty(0, cnt++ , dtData ,    60,    daLeft,     true,    "srep_nm",     false,          "",       dfNone,       0,     false,       false);
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
			SheetWidth = mainTable2.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;
			
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 9, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(20, 0, 0, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false) ;
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, "Del||Individual|Status|Code|Name|Type|S.OFC|SUB TRD 1|SUB TRD 2|SUB TRD 3|SUB TRD 4|SUB TRD 5||", true);
			
			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtDelCheck 		,    25,    daCenter,   true,    "sel",     		false,          "",       dfNone,       0,     true,       true, -1, false, false, "", false);
			
			InitDataProperty(0, cnt++ , dtHiddenStatus	,    50,    daCenter,   true,    "ibflag",     		false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtCheckBox 		,    70,    daCenter,   true,    "indiv_cust_use_flg",  		false,          "",       dfNone,       0,     true,       true, -1, false, false, "", false);
			InitDataProperty(0, cnt++ , dtHidden		,    60,    daCenter,   true,    "cust_sts",    	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 			,    80,    daCenter,   true,    "cust_cd",     	false,         	"",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 			,    250,   daLeft,   	true,    "cust_nm",     	false,          "",       dfNone,       0,     false,      false);
			//InitDataProperty(0, cnt++ , dtData 			,    70,    daCenter,   true,    "cust_lvl",    	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtCombo			,    70,    daCenter,   true,    "rvis_cntr_cust_tp_cd",     	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 			,    60,    daCenter,   true,    "sls_ofc_cd",     	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_1",     	false,          "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_2",     	false,          "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_3",     	false,          "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_4",     	false,          "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtComboEdit		,    80,    daCenter,   true,    "sub_trd_5",     	false,          "",       dfNone,       0,     true,      true,		2);
			InitDataProperty(0, cnt++ , dtHidden		,    80,    daCenter,   true,    "sub_trd_cd",     	false,          "",       dfNone,       0,     true,      true);
			InitDataProperty(0, cnt++ , dtHidden		,    60,    daCenter,   true,    "sls_rep_ofc_team_cd",     	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 		,    20,    daCenter,   true,    "srep_cd",    		false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 		,    20,    daCenter,   true,    "cust_cnt_cd", 	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 		,    40,    daCenter,   true,    "cust_seq",   		false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 		,    40,    daCenter,   true,    "delt_flg",   		false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 		,    40,    daCenter,   true,    "exist_flg",   	false,          "",       dfNone,       0,     false,      false);

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
				sheetObjects[1].RemoveAll();
				
				var param = SpcFormString(formObj,"f_cmd,trade,sls_ofc_cd,srep_cd,srep_nm,cust_cnt_cd,cust_seq,cust_nm");
				var rtn = sheetObj.DoSearch4Post("ESM_SPC_0106GS.do", param);
				sheetObj.ReDraw=true;
				break;


            case IBSAVE:
            	//저장
				if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				}
				
				formObj.f_cmd.value = MULTI;
				
				var param = SpcFormString(formObj,"f_cmd,trade");		
                var rtn = doSaveSheet(sheetObj, "ESM_SPC_0106GS.do",param,null);
                break;
                
		   case IBINSERT:      // 입력
		   		if(!check_retrive){
					ComShowMessage(getMsg("SPC90124"));
					return;
		   		}
				var row = sheetObj.DataInsert();
				sheetObj.CellValue2(row, "srep_cd") = srep_id;
				sheetObj.CellValue2(row, "trd_cd") = trd_cd;
				sheetObj.CellValue2(row, "sub_trd_cd") = sub_trd_cd;
				sheetObj.CellValue2(row, "rlane_cd") = rlane_cd;
				sheetObj.CellValue2(row, "dir_cd") = bound;
				sheetObj.CellValue2(row, "ioc_ts_cd") = ioc_cd;
				sheetObj.CellValue2(row, "fcast_cust_tp_cd") = formObj.accountType.value;
				//행추가시 Month로 선택컬럼
				sheetObj.SelectCell(row, 1, true, ""); 
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
			
        	case IBSEARCH:
        		var custSeq = formObj.cust_seq.value;
        		if(custSeq!=""){
        			if(!ComIsNumber(custSeq)){
        				ComShowCodeMessage("COM12114", "Customer Code");
        				return false;
        			}
        		}
        	break;
        	
		    case IBSAVE:
	    		var dRow = sheetObj.ColValueDup("cust_cd"); 
	    		
	    		if(dRow > 0){
	    			ComShowMessage(getMsg("SPC90114", "Account Code"));
	    			sheetObj.SelectCell(dRow, "cust_cd");
	    			return false;
	    		}
	    		
	    		var sRow       = sheetObj.FindStatusRow("I|U");
	    		var sArr       = sRow.split(";");
	    		var indiv      = "";
	    		var sub_trd_cd = "";
	    		
	    		for(var i=0; i < sArr.length - 1; i++) {
	    			indiv      = sheetObj.CellValue(sArr[i], "indiv_cust_use_flg");
	    			sub_trd_cd = ComTrim(sheetObj.CellValue(sArr[i], "sub_trd_cd"));

	    			if(indiv == "1" && sub_trd_cd == "") {
	    				ComShowMessage(getMsg("SPC90114", "Sub Trade"));
	    				sheetObj.SelectCell(sArr[i], "sub_trd_1");
	    				return false;
	    			}
	    		}

	    		var indivCnt = sheetObj.CheckedRows("indiv_cust_use_flg");
	    		if(Number(indivCnt)>100){
	    			ComShowMessage("Can Not Save Individual Accounts more than 100");
	    			return false;
	    		}
	    		
		    	break;
		}
		return true;
    }
    
    function sheet2_OnSaveEnd(sheetObj, errMsg) {
    	if(sheetObj.EtcData("status") == "OK"){
    		ComShowMessage("saved successfully.");  
    		
    		window.returnValue = "OK";
    		self.close();
    	}else{
    		ComShowMessage(errMsg);
    	}
    }
    
    /**
     * S.Rep Double-Click시 해당 Sales Rep에 등록된 화주정보 조회
     * @param sheetObj
     * @param row
     * @param col
     */
    function sheet1_OnDblClick(sheetObj, row, col){
    	var formObj = document.form;
    	var srep_cd = sheetObj.CellValue(row, "srep_cd");
    	
    	formObj.f_cmd.value = SEARCHLIST02;
    	sheetObjects[1].ReDraw=false;
		check_retrive = true;

 	    var param = SpcFormString(formObj,"f_cmd,trade,cust_cnt_cd,cust_seq,cust_nm,cost_yrwk,sls_ofc_cd");
 	    param += "&srep_cd="+srep_cd;
 	   
 	    var rtn = sheetObjects[1].DoSearch4Post("ESM_SPC_0106GS1.do", param);
 	    sheetObjects[1].ReDraw=true;
    }
    
    /**
     * Individual Check 시 
     * @param sheetObj
     * @param row
     * @param col
     * @param value
     */
    function sheet2_OnChange(sheetObj, row, col, value){
    	var formObj = document.form;
    	var sName = sheetObj.ColSaveName(col);
    	
    	switch(sName){
    	case "indiv_cust_use_flg":
    		sheetObj.CellValue2(row, "indiv_cust_use_flg") = value=="1"?"Y":"N";
    		sheetObj.CellValue2(row, "delt_flg") = "N";
    		//indiv_cust_use_flg 가 uncheck되었을 경우 해당 S.Office, S.Rep, Account에게 오늘 이후 wk에 물량이 있는지 확인.
    		if( value == 0  && (sheetObj.CellValue(row, "cust_cd") != "XX999999") && (value != sheetObj.CellSearchValue(row, "indiv_cust_use_flg"))){
				formObj.f_cmd.value = SEARCHLIST03;
				
				var param = SpcFormString(formObj,"f_cmd,trade,srep_cd,sls_ofc_cd");
		 	    param += "&cust_cd="+sheetObj.CellValue(row, "cust_cd");
		  	   
				var arrXml = sheetObj.GetSearchXml("ESM_SPC_0106GS.do", param);
				var VolExistWk = ComGetEtcData(arrXml, "VolExistWk");
				if(VolExistWk != null && VolExistWk != ""){
    				ComShowMessage(getMsg("SPC90311", VolExistWk.substr(1)));
				}
    		}
    		break;
    	case "sel":
    		sheetObj.CellValue2(row, "indiv_cust_use_flg") = value=="1"?"N":"Y";
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
		if (sheetObj.RowCount==1){
			sheet1_OnDblClick(sheetObj, 1, 2);
		}		
		// chk_cust_cd 
//		chkCustCd(sheetObj);
	}
	
	 
	/**
	 * Sheet2의 조회 후
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){		
				
		// chk_cust_cd 
//		chkCustCd(sheetObj);
	}
	
	/**
	 * Check Cust 고객 점검
	 */
	function chkCustCd(sheetObj){
		
		var chkCustCd= document.form.chkCustCd.value; 
		var existFlg ="";
		
		for ( var i = 1 ; i < sheetObj.RowCount; i++) {
			
			custIndivFlg  = sheetObj.CellValue(i, "indiv_cust_use_flg");
			existFlg      = sheetObj.CellValue(i, "exist_flg");
			
			if( custIndivFlg =="1" && existFlg =="N")
				chkCustCd = sheetObj.CellValue(i, "cust_cd");
		}	
		
		if( chkCustCd !="" && chkCustCd.length > 0 ){
			
			var msg = "1. Update FCST for your newly added/deleted account.\n";
			msg += "2. After updating FCST, go to 'ACCT. ADD / DELETE' and 'save' to confirm newly added/deleted account.\n";

			alert(msg);			      
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
    	var indiv      = 0;
    	var sub_trd_cd = "";
    	
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    		sheetObj.CellValue2(i, "srep_cd")     = formObj.srep_cd.value;
			sheetObj.CellValue2(i, "cust_cnt_cd") = (sheetObj.CellValue(i, "cust_cd")).substr(0, 2);
    		sheetObj.CellValue2(i, "cust_seq")    = (sheetObj.CellValue(i, "cust_cd")).substr(2) * 1;
    		
    		col = sheetObj.SaveNameCol("sub_trd_5"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_5") = text;
    		sub_trd_cd = sub_trd_cd + text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_4"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_4") = text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_3"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_3") = text;
    		sub_trd_cd = sub_trd_cd + text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_2"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_2") = text;
    		sub_trd_cd = sub_trd_cd + text;
    		
    		col = sheetObj.SaveNameCol("sub_trd_1"); 
    		text = getSheetComboText(sheetObj, i, col, 1);
    		sheetObj.CellValue2(i, "sub_trd_1") = text;
    		sub_trd_cd = sub_trd_cd + text;
    		
    		sheet2_OnChange(sheetObj, i, col, text);
    		
    		indiv = sheetObj.CellValue(i, "indiv_cust_use_flg");
    		
			if(indiv != "1" && sub_trd_cd.replace(/\s/g, "") == "") {
				sheetObj.CellValue(i, "ibflag") = "R";
			}
    		
			indiv      = 0;
			sub_trd_cd = "";			
    	}
    }
	/* 개발자 작업  끝 */
