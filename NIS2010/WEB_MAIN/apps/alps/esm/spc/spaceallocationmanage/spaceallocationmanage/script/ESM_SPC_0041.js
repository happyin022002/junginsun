/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0041.js
*@FileTitle : Space-Reallocation Model Run 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2009.11.24 서관영
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
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
     * @class ESM_SPC_0041 : ESM_SPC_0041 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0041() {
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
//	sheetResizeFull = true;		
	sheetResizeCount = 2;
//	resizeTargetObject[0] = "engineLogDiv";
	var key = "";
	var intervalID = null;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    var init_year1 = ''; 
    var init_week1 = ''; 
    var init_year2 = ''; 
    var init_week2 = ''; 
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

//    	try {
    		var srcObj = window.event.srcElement;
    		if(srcObj.Enable != undefined && !srcObj.Enable) return;
    		var srcName = srcObj.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
//    	            btnImgEnable("btn_opretespace", true);
    	            ComBtnEnable("btn_opretespace");
        	        break;

        	    case "btn_new":
                    if(checkModifiedSheet(sheetObjects[1])){
                        if(ComShowConfirm (getMsg("SPC90001")) != 1){
                            return;
                        }
                    }  				
					doActionIBSheet(sheetObject,formObject,IBCLEAR);
//    	            btnImgEnable("btn_opretespace", false);
    	            
					formObject.year1.value = init_year1;
		    		formObject.week1.value = init_week1;
					formObject.year2.value = init_year2;
		    		formObject.week2.value = init_week2;  
		    		
					SpcSearchOptionTrade("trade", true, true);
					SpcSearchOptionSubTrade("subtrade", true, true);
					SpcSearchOptionLane("lane"); // 0207 SHKIM   
        	        break;

        	    case "btn_opretespace":
    	            //doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

            } // end switch
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowCodeMessage("COM12111");
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

       sheetObjects[sheetCnt++] = sheet_obj;


    }
    function setComboObject(combo_obj){

       comObjects[comboCnt++] = combo_obj;


    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	SpcSearchOptionYear("year1");
    	SpcSearchOptionWeek("week1");
    	SpcSearchOptionYear("year2");
    	SpcSearchOptionWeek("week2");
    	SpcSearchOptionTrade("trade", true, true);
    	SpcSearchOptionSubTrade("subtrade", true, true);
    	SpcSearchOptionLane("lane");
    	SpcSearchOptionBound("bound",false,true,false,true);
    	
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetResizeFull = true;
		document_onresize();
		
//        btnImgEnable(document.getElementsByName("btn_opretespace")[0], false);
        ComBtnDisable("btn_opretespace");

        document.form.year1.focus();
		//if(isDevMode){
		//	 var formObject = document.form;
		//	 formObject.year1.value = "2005";
		//	 formObject.year2.value = "2006";
		//	 formObject.week2.value = "12";
		//	 comObjects[0].Code = "TPS";
			 
		//}
		init_year1 = document.form.year1.value;	//년 초기화용
		init_week1 = document.form.week1.value;	//주차 초기화용
		init_year2 = document.form.year2.value;	//년 초기화용
		init_week2 = document.form.week2.value;	//주차 초기화용        
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
					style.height = GetSheetHeight(20) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;
                    FocusEditMode = default_edit_mode;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false) ;

					var HeadTitle0 = "Rep. Trade|Rep. Trade|Sub Trade|Sub Trade|Lane|Lane|Bound|Week|VVD|Model\nRun";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
//					DataAutoTrim = false;
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   true,     "trade",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtCheckBox,  20,    daCenter,   true,     "flag1",     false,          "",       dfNone,          0,    true,      false, 0, false, false, "", false);
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   true,     "subtrade",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtCheckBox,  20,    daCenter,   true,     "flag2",     false,          "",       dfNone,          0,    true,      false, 0, false, false, "", false);
					InitDataProperty(0, cnt++ , dtData,      100,   daCenter,   true,     "lane",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtCheckBox,  20,    daCenter,   true,     "flag3",     false,          "",       dfNone,          0,    true,      false, 0, false, false, "", false);
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   false,     "bound",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtData,      70,    daCenter,   false,     "week",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtData,      150,   daCenter,   false,     "vvd",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtCheckBox,  80,    daCenter,   false,     "flag4",     false,          "",       dfNone,          0,    true,      false);
					InitDataProperty(0, cnt++ , dtHidden,  20,    daCenter,   false,     "vsl_cd",     false,          "",       dfNone,          0,    true,      false );
					InitDataProperty(0, cnt++ , dtHidden,  20,    daCenter,   false,     "skd_voy_no",     false,          "",       dfNone,          0,    true,      false );
					InitDataProperty(0, cnt++ , dtHidden,  20,    daCenter,   false,     "skd_dir_cd",     false,          "",       dfNone,          0,    true,      false );
//					InitDataProperty(0, cnt++ , dtHidden,  20,    daCenter,   false,     "raloc_ver_no",     false,          "",       dfNone,          0,    true,      false );
//					InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,   false,     "ibflag",     false,          "",       dfNone,          0,    true,      false );
//					InitDataProperty(0, cnt++ , dtHidden,  20,    daCenter,   false,     "key1",     false,          "",       dfNone,          0,    true,      false );
//					InitDataProperty(0, cnt++ , dtHidden,  20,    daCenter,   false,     "key2",     false,          "",       dfNone,          0,    true,      false );
//					InitDataProperty(0, cnt++ , dtHidden,  20,    daCenter,   false,     "key3",     false,          "",       dfNone,          0,    true,      false );
//					InitDataProperty2(0, 9, dtCheckBox, "all-check=true");

//					HeadRowHeight = 21;
			   }
				break;
			case 2:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(3) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;
                    FocusEditMode = default_edit_mode;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false) ;

					var HeadTitle0 = "";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					DataAutoTrim = false;
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,  100,    daLeft,   true,     "",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtData,  100,    daLeft,   true,     "",     false,          "",       dfNone,          0,    true,      false );
					InitDataProperty(0, cnt++ , dtData,  100,    daLeft,   true,     "",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtData,  100,    daLeft,   true,     "",     false,          "",       dfNone,          0,    true,      false );

			   }
				break;		
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
			
			var param = "f_cmd=" + formObj.f_cmd.value;
			param = param + "&year1="    + formObj.year1.value;
			param = param + "&week1="    + formObj.week1.value;
			param = param + "&year2="    + formObj.year2.value;
			param = param + "&week2="    + formObj.week2.value;
			param = param + "&trade="    + comObjects[0].Code;
			param = param + "&bound="    + formObj.bound.value;
			param = param + "&subtrade=" + comObjects[1].Code;
			param = param + "&lane="     + comObjects[2].Code;
			param = param + "&office="   + formObj.office.value;
			
			//sheetObj.DoSearch4Post("ESM_SPC_0041GS.do", FormQueryString(formObj));
			sheetObj.DoSearch4Post("ESM_SPC_0041GS.do", param);
			sheetObj.ReDraw=true;
			clearStatusInterval();
			break;
		case IBCLEAR:        //초기화
			resetAll();
			isSearchEnd = false;
			clearStatusInterval();
			break;
		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false);
			sheetObjects[1].Down2Excel(-1, true,true);
			break;
		case IBSAVE:      // 입력
//			if(intervalID != null){
//				if(ComShowConfirm (getMsg("SPC90122")) != 1){
//			         break;
//			    }
//			}
//			formObj.f_cmd.value = COMMAND01;
//			var rtn = doSaveSheet(sheetObj, "ESM_SPC_0041GS.do", FormQueryString(formObj), "flag4");
//			clearStatusInterval();
//			if(rtn == "OK"){
//				key = sheetObj.EtcData("key");
//				searchEngineStatus();
//				intervalID = setInterval("searchEngineStatus()", formObj.intervalTime.value*1000);
//			}
			break;
		}
	}
	function clearStatusInterval(){
		if(intervalID != null){
			var rtn = clearInterval(intervalID);
		}
		intervalID == null;
		lastSeq = "0";
		var len = engineLog.rows.length;
		for(var i = 0 ; i < len ; i++){
			engineLog.deleteRow();
		}
	}
	var lastSeq = " ";
	function searchEngineStatus(){
		var sheetObj = sheetObjects[1];
		var queryStr = "f_cmd="+SEARCHLIST02+"&stsCd="+lastSeq+"&verNo="+key;
		with(sheetObj){
			DoSearch4Post("ESM_SPC_0041GS.do", queryStr);
			if(RowCount > 0){
				var lrow = LastRow;
				var frow = HeaderRows;
				for(var i = frow ; i <= lrow ; i++){
					lastSeq = CellValue(i, 2);
    				if(lastSeq == "ZZZZZZ"){
    					if(intervalID != null){
                			clearInterval(intervalID);
                			intervalID = null;
                			lastSeq = "0";
                			ComShowCodeMessage("SPC90127", key, CellValue(i, 1));
                		}
               			return;
    				}
					appendEngineLog(new Array(CellValue(i, 0), CellValue(i, 1)));
				}
			}
		}
	}
	function appendEngineLog(log){
		var tr = engineLog.insertRow();
		var td1 = tr.insertCell();
		var td2 = tr.insertCell();
		td1.nowrap = true;
		td1.innerHTML = log[0];
		td2.innerHTML = log[1];
		var div = engineLog.parentElement;
		div.scrollTop = engineLog.offsetHeight - div.offsetHeight;
	}
 	function sheet1_OnClick(sheetObj, row, col){
 		with(sheetObj){
 			ReDraw = false;
	 		switch(sheetObj.ColSaveName(col)){
	 		case "flag1":
	 			var val = CellValue(row, "key1");
	 			var status = (CellValue(row, col)*1+1)%2;
	 			var frow = FindText("key1",val);
	 			while(frow >= 0){
	 				CellValue2(frow, "flag1") = status;
	 				CellValue2(frow, "flag2") = status;
	 				CellValue2(frow, "flag3") = status;
	 				CellValue2(frow, "flag4") = status;
	 				frow = FindText("key1", val, frow+1);
	 			}
	 			break;
	 		case "flag2":
	 			var val = CellValue(row, "key2");
	 			var status = (CellValue(row, col)*1+1)%2;
	 			var frow = FindText("key2",val);
	 			while(frow >= 0){
	 				CellValue2(frow, "flag2") = status;
	 				CellValue2(frow, "flag3") = status;
	 				CellValue2(frow, "flag4") = status;
	 				frow = FindText("key2", val, frow+1);
	 			}
	 			break;
	 		case "flag3":
	 			var val = CellValue(row, "key3");
	 			var status = (CellValue(row, col)*1+1)%2;
	 			var frow = FindText("key3",val);
	 			while(frow >= 0){
	 				CellValue2(frow, "flag3") = status;
	 				CellValue2(frow, "flag4") = status;
	 				frow = FindText("key3", val, frow+1);
	 			}
	 			break;
	 		case "flag4":
	 			var status = (CellValue(row, col)*1+1)%2;
 				CellValue2(row, "flag4") = status;
	 			break;
	 		}
 			ReDraw = true;
	 	}
 	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		return true;
	}
	
	   
	function trade_OnChange(comObj,value,text ){
		if(text == '|ALL'){	optionAllReset("trade",value,"true");   return;} // 0207 SHKIM
    	if(value == "") return;
		//sub_trade의 초기화
		comObjects[1].Index2 = 0;     
		//lane의 초기화
		comObjects[2].Index2 = 0;        
		SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		//SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
		SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
	}   
	
	function subtrade_OnChange(comObj,value,text ){
		if(text == '||ALL'){   
			//optionAllReset("subtrade",document.form.trade.Code,"true"); 
			SpcSearchOptionSubTrade("subtrade",true,true,"","",document.form.trade.Code);			// 0207 SHKIM   			
	    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,'',true);	// 0207 SHKIM   
			return; 
		} // 0207 SHKIM
    	if(value == "") return;
		comObjects[0].Code2 = comObj.GetText(value,0);  
		//lane의 초기화
		comObjects[2].Index2 = 0;  
		SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM
	} 
	
	function lane_OnChange(comObj,value,text ){
		if(value == "" ) return;
		var repTrade = comObj.GetText(value,0);  
		var subTrade = comObj.GetText(value,1);
		comObjects[0].Code2 = repTrade;
		comObjects[1].Code2 = subTrade;
	}
	function intervalTime_OnChange(){
		var obj = event.srcElement;
		if(intervalID != null){
			clearInterval(intervalID);
			try{
				if(obj.value*1 > 0){
					intervalID = setInterval("searchEngineStatus()", obj.value*1000);
				}
			}catch(e) {
			}
		}
		return false;
	}

    function initDataValue_trade(){
    	var sheetObj = document.getElementById("trade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_subtrade(){
    	var sheetObj = document.getElementById("subtrade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_lane(){
    	var sheetObj = document.getElementById("lane");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
	/* 개발자 작업  끝 */