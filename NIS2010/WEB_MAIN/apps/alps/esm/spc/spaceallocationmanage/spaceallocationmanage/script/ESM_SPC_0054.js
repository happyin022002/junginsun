/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0054.js
*@FileTitle : Space Allocation Model Execute Log
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2009.11.18 서관영
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
     * @class ESM_SPC_0054 : ESM_SPC_0054 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0054() {
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
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcObj = window.event.srcElement;
    		if(srcObj.Enable != undefined && !srcObj.Enable) return;
    		var srcName = srcObj.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_new":
					doActionIBSheet(sheetObject,formObject,IBCLEAR);
        	        break;
        	    case "btn_popup_user":
					var user = formObject.user.value;
					spcPopup("UserID", "user_cd="+user, 770, 470, "getUser", "1,0,1,1,1,1,1,1");
        	        break;
        	    case "btns_calendar1":
        	        // 달력 팝업
        	        var cal = new ComCalendar();
        	        cal.select(formObject.sDate,  'yyyy-MM-dd');
        	        break;
        	    case "btns_calendar2":
        	        // 달력 팝업
        	        var cal = new ComCalendar();
           		    cal.select(formObject.eDate, 'yyyy-MM-dd');
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
	function getUser(){
        var colArray = rowArray[0];	
    	document.all.user.value = colArray[3];
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

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetResizeFull = true;
		document_onresize();
		
        setInitCondDate();
        document.form.sDate.focus();
    }
	function setInitCondDate(){
        var d = new Date();
        var year = d.getYear();
        var month = ComLpad((d.getMonth()+1)+"", 2, '0');
        var date = ComLpad(d.getDate()+"", 2, '0');
        var eDateStr = year + "-" + month + "-" + date;
        d = d - (1000*60*60*24*5);
        d = new Date(d);
        year = d.getYear();
        month = ComLpad((d.getMonth()+1)+"", 2, '0');
        date = ComLpad(d.getDate()+"", 2, '0');
        var sDateStr = year + "-" + month + "-" + date;
        document.form.sDate.value = sDateStr;
        document.form.eDate.value = eDateStr;
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
					style.height = GetSheetHeight(21) ;
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
					InitColumnInfo(8, 0 , 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false) ;

					var HeadTitle0 = "SEQ|Execute Date/Time|Start Date/Time|End Date/Time|User|Version No.|Status|Status Code";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					DataAutoTrim = false;
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDataSeq,   50,    daCenter,   false,  "",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtData,      150,    daCenter,   false,  "",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtData,      150,    daCenter,   false,  "",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtData,      150,   daCenter,   false,  "edt",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   false,  "",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , dtData,    100,    daCenter,   false,  "verNo",     false,          "",       dfNone,          0,    true,      false );
					InitDataProperty(0, cnt++ , dtData,      50,    daCenter,   false,  "statusNm",     false,          "",       dfNone,          0,    false,      false );
					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,    20,    daCenter,   false,  "status",     false,          "",       dfNone,          0,    true,      false );

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
			
			var param = SpcFormString(formObj,"f_cmd,sDate,eDate");
			
			//sheetObj.DoSearch4Post("ESM_SPC_0054GS.do", FormQueryString(formObj));
			sheetObj.DoSearch4Post("ESM_SPC_0054GS.do", param);
			sheetObj.ReDraw=true;
			clearStatusInterval();
			break;
		case IBCLEAR:        //초기화
			resetAll();
			isSearchEnd = false;
			clearStatusInterval();
			setInitCondDate();
			break;
		}
	}
	function clearStatusInterval(){
		if(intervalID != null){
			clearInterval(intervalID);
			intervalID == null;
		}
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
			RemoveAll();
			DoSearch4Post("ESM_SPC_0054GS.do", queryStr);
			if(RowCount > 0){
				var lrow = LastRow;
				var frow = HeaderRows;
				for(var i = frow ; i <= lrow ; i++){
					lastSeq = CellValue(i, 2);
    				if(lastSeq == "ZZZZZZ"){
    					if(intervalID != null){
                			clearInterval(intervalID);
               				setStatus(CellValue(i, 1), CellValue(i, 0));
                		}
               			return;
    				}
					appendEngineLog(new Array(CellValue(i, 0), CellValue(i, 1)));
				}
			}
		}
	}
	function setStatus(cd, dt){
		var sheetObj = sheetObjects[0];
		var row = sheetObj.FindText("verNo", key);
		if(row >= 0){
			sheetObj.CellValue(row, "status") = cd;
			sheetObj.CellValue(row, "statusNm") = cd;
			sheetObj.CellValue(row, "edt") = dt;
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
//	function sheet1_OnDblClick(sheetObj, row, col){
//        key = sheetObj.CellValue(row, "verNo");
//        var status = sheetObj.CellValue(row, "status");
//        lastSeq = "";
//        clearStatusInterval();
//        searchEngineStatus();
//        if(status == "P" || status == "I"){
//        	intervalID = setInterval("searchEngineStatus()", document.form.intervalTime.value*1000);
//        }
// 	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
    		switch(sAction) {
    			case IBSEARCH:      //조회
			        if(sDate.value > eDate.value){
			            ComShowMessage(getMsg("SPC90123", "Period"));
			            sDate.focus();
			            return false;
			        }
    				break;
    			case IBSAVE:        //저장
    				break;
    			case IBINSERT:      // 입력
    				break;
    			case IBCOPYROW:        //행 복사
    				break;
    			case IBDOWNEXCEL:        //엑셀 다운로드
    				break;
    			case IBLOADEXCEL:        //엑셀 업로드
    				break;
    		}
		}
		return true;
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


	/* 개발자 작업  끝 */