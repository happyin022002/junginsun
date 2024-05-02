/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0103.js
*@FileTitle : dailyforecastmanage
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
* 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
* 2013.07.16 진마리아 MNLBA->MNLSC 하드코딩 변경
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
     * @class ESM_SPC_0103 : ESM_SPC_0103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0103() {
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

    var init_rgnOffice = '';
    var init_subOffice = '';
    var init_salesRep = '';
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	//try {
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
    					searchSalesRep = new Array();
    					document.getElementById("rgnOffice").Code2 = init_rgnOffice;
    					document.getElementById("subOffice").Code2 = init_subOffice;
    					document.getElementById("salesRep").Code2 = init_salesRep;
    					
						SpcSearchOptionTrade("trade",true,true);
						SpcSearchOptionSubTrade("subTrade", true, false);
						SpcSearchOptionLane("lane", true, true);// 0207 SHKIM  
    					break;
    					
            	    case "btn_save":
            	    	doActionIBSheet(sheetObject, formObject, IBSAVE);
            	        break;
            	    case "btn_rowadd":
    					doActionIBSheet(sheetObject,formObject,IBINSERT);
            	        break;
            	    case "btn_ok":
            	    	window.returnValue = "OK";
            	    	self.close();
            	        break;
            	    case "btn_close":
            	    	window.returnValue = "CLOSE";
            	    	self.close();
            	        break;
            	    case "btn_downexcel":
       	            	doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
            	        break;

    			} // end switch
        	//}catch(e) {
        	//	if( e == "[object Error]") {
        	//		ComShowCodeMessage("COM12111");
        	//	} else {
        	//		ComShowMessage(e);
        	//	}
        	//}
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
        	SpcSearchOptionTrade("trade",true,true);
        	SpcSearchOptionSubTrade("subTrade", true, false);
        	SpcSearchOptionLane("lane", true, true);
        	SpcSearchOptionBound("bound",false,true,false,false);
        	
            tab_retrives = new Array(sheetObjects.length);
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
    		
       		var imgObjs = document.getElementsByTagName("IMG");
    		var value = "";
    		var include = "";
    		if(ofc_cd == "SELCTY" || ofc_cd == "SELCDO" || ofc_cd == "SINRS"){
    			value = "SELHO";
    		} else if (ofc_cd == "SHARCS" || ofc_cd == "SHARCC" || ofc_cd == "SHARCO") {
    			value = "SHARC";
    		} else if (ofc_cd == "HAMRUS" || ofc_cd == "HAMRUC" || ofc_cd == "HAMRUO") {
    			value = "HAMRU";
    		} else if (ofc_cd == "NYCRAS" || ofc_cd == "NYCRAC" || ofc_cd == "NYCRAO") {
    			value = "NYCRA";
    		} else if (ofc_cd == "SINRSS" || ofc_cd == "SINRSO" || ofc_cd == "SINRSC") {
    		    value = "SHARC";
    		} else if(ofc_cd == "JKTSC" || ofc_cd == "JKTBA"){
    			value = "JKTBA";
    		} else if(ofc_cd == "MNLSC"|| ofc_cd == "MNLBA"){
    			value = "MNLSC";
    		} else if(ofc_cd == "PHXSA"|| ofc_cd == "LGBSC"){
    			value = "LGBSC";
    		} else if(ofc_cd == "PKGSA"|| ofc_cd == "PKGSC"){
    			value = "PKGSC";
    		} else if(ofc_cd == "SELSA"|| ofc_cd == "SELSC"){
    			value = "SELSC";
    		} else if(ofc_cd == "SLCSC"|| ofc_cd == "SEASC"){
    			value = "SEASC";
    		//} else if("HO|HQ|AQ|BB|BS|BA".indexOf(ofc_tp_cd) < 0){
    		} else if("HO|HQ|AQ|BB|BS|BA".lastIndexOf(ofc_tp_cd) > -1){
    			value = ofc_cd;
    		}
    		var rtn = getCodeList("ChildOffice", "ofc_cd="+value+"&level=4");
    		initData_rgnOffice(rtn[0].split("|"), rtn[1].split("|"));

    		var formObject = document.form;
        	var comObj = document.getElementById("rgnOffice");
    		var focusObj = comObj;
        	if(comObj.GetCount() <= 1){
    	    	comObj.Index = 0;
        		var comObj1 = document.getElementById("subOffice");
        		if(comObj.Code != comObj1.Code){
        			comObj1.Enable = false;
        		}
        	}
        	if((srep_id + rlane_cd + trd_cd + sub_trd_cd + bound + rgn_ofc_cd + sub_ofc_cd + ioc_cd) != ""){
//        		imgObjs[0].parentElement.parentElement.style.display = "none";
        	}
        	var setAllField = true;
        	var focusObj = null;
    		if(rgn_ofc_cd != ""){
    			comObjects[0].Code = rgn_ofc_cd;
    			comObjects[0].Enable = false;
    		}
    		else{
    			focusObj = focusObj==null?comObjects[0]:null;
    		}
    		if(sub_ofc_cd != ""){ 
    			comObjects[1].Code = sub_ofc_cd;
    			comObjects[1].Enable = false;
    		}
    		else{ 
    			focusObj = focusObj==null?comObjects[1]:null;
    		}
    		if(srep_id != ""){ 
    			comObjects[2].Code = srep_id;
    			comObjects[0].Enable = false;
    			comObjects[1].Enable = false;
    			comObjects[2].Enable = false;
    			search_srep_id.innerText = srep_id;
    		}
    		else{ 
    			focusObj = focusObj==null?comObjects[2]:null;
    			setAllField = setAllField && false;
    		}
    		if(srep_nm != ""){
    			search_srep_nm.innerText = srep_nm;
    		}
    		if(ioc_cd != ""){
    			formObject.ioc.value = ioc_cd;
    			formObject.ioc.disabled = true;
    			search_ioc_cd.innerText = ioc_cd=="O"?"OCN":ioc_cd=="I"?"IPC":ioc_cd=="T"?"TS":"";
    		}
    		else{
    			focusObj = focusObj==null?formObject.ioc:null;
    			setAllField = setAllField && false;
    		}
    		if(trd_cd != ""){
    			comObjects[3].Code = trd_cd;
    			comObjects[3].Enable = false;
    			search_trd_cd.innerText = trd_cd;
    		}
    		else{
    			focusObj = focusObj==null?comObjects[3]:null;
    			setAllField = setAllField && false;
    		}
    		if(sub_trd_cd != ""){
    			comObjects[4].Code = sub_trd_cd;
    			comObjects[4].Enable = false;
    			search_sub_trd_cd.innerText = sub_trd_cd;
    		}
    		else{
    			focusObj = focusObj==null?comObjects[4]:null;
    			setAllField = setAllField && false;
    		}
    		if(rlane_cd != ""){
    			comObjects[5].Code = rlane_cd;
    			comObjects[5].Enable = false;
    			search_rlane_cd.innerText = rlane_cd;
    		}
    		else{
    			focusObj = focusObj==null?comObjects[5]:null;
    			setAllField = setAllField && false;
    		}
    		if(bound != ""){
    			formObject.bound.value = bound;
    			formObject.bound.disabled = true;
    			search_bound.innerText = bound;
    		}
    		else{
    			focusObj = focusObj==null?formObject.bound:null;
    			setAllField = setAllField && false;
    		}
        	if(setAllField){
        		searchCondition.style.display = "none";
        		searchInformation.style.display = "inline";
//        		document.all.td_retrieve.style.display = "none";
//        		document.all.td_new.style.display = "none";
//        		document.all.td_line.style.display = "none";
       			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
        	}
        	else{
        		searchCondition.style.display = "inline";
        		searchInformation.style.display = "none";
        		if(focusObj != null){
        			focusObj.focus();
        		}
        		/* test using s
    	    	if(isDevMode){
    		    	document.getElementById("trade").Code = "TPS";
    		    	document.getElementById("subTrade").Code = "PS";
    		    	document.getElementById("lane").Code = "PSXTP";
    		    	//document.getElementById("subOffice").Code = "";
    		    	document.getElementById("salesRep").Code = "KR155";
    		    	formObject.ioc.value = "O";
    		    	formObject.bound.value = "E";
    	    	}
    	    	test using e */
        	}
        	
			
        	document_onresize();
        	init_rgnOffice = document.getElementById("rgnOffice").Code;
        	init_subOffice = document.getElementById("subOffice").Code;
        	init_salesRep = document.getElementById("salesRep").Code;
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
         * TabSheet1에서 조회후 타이틀 변경
         */
    	function initSheet1(sheetObj){
    	       with (sheetObj) {
    	            // 높이 설정
    	    	    //style.height = 100 ;
    	    	    if(is_child == "true") {
    	    	    	style.height = getSheetHeight(9) ;
    	    	    } else {
    	    	    	style.height = getSheetHeight(19) ;
    	    	    }
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
    	            InitColumnInfo(13, 0, 0, false);
    	
    	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	            InitHeadMode(false, true, true, true, false,false) ;
    	            
    	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    	            InitHeadRow(0, "Del|AccountCode|NAME", true);
    	            
    				var cnt = 0;
    	            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	            InitDataProperty(0, cnt++ , dtDelCheck ,    45,    daCenter,   true,    "del_flag",     false,          "",       dfNone,       0,     true,       true, -1, false, false, "", false);
    	            InitDataProperty(0, cnt++ , dtPopupEdit ,    100,    daCenter,   true,    "cust_cd",     true,          "",       dfNone,       0,     false,       true, 8);
    	            InitDataProperty(0, cnt++ , dtData ,    200,    daLeft,   true,    "cust_nm",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden ,    20,    daCenterTop,   true,    "srep_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden ,    40,    daCenterTop,   true,    "trd_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden ,    50,    daCenterTop,   true,    "sub_trd_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden ,    20,    daCenterTop,   true,    "rlane_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden ,    40,    daCenterTop,   true,    "dir_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden ,    50,    daCenterTop,   true,    "ioc_ts_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden ,    20,    daCenterTop,   true,    "cust_cnt_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden ,    40,    daCenterTop,   true,    "cust_seq",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden ,    40,    daCenterTop,   true,    "fcast_cust_tp_cd",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataProperty(0, cnt++ , isDevMode?dtStatus:dtHiddenStatus ,    50,    daCenterTop,   true,    "ibflag",     false,          "",       dfNone,       0,     false,       false);
    	            InitDataValid(0, 1, vtEngUpOther, "0123456789");
    	            //InitUserFormat(0, 1, "LL######", "");
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
    				
    				var param = "salesRep="      + comObjects[2].Code;
    				param = param + "&ioc="      + formObj.ioc.value;
    				param = param + "&trade="    + comObjects[3].Code;
    				param = param + "&subTrade=" + comObjects[4].Code;
    				param = param + "&lane="     + comObjects[5].Code;
    				param = param + "&bound="    + formObj.bound.value;
//    				var rtn = sheetObj.DoSearch4Post("ESM_SPC_0103GS.do", "f_cmd="+(SEARCHLIST)+"&"+FormQueryString(formObj));
    				var rtn = sheetObj.DoSearch4Post("ESM_SPC_0103GS.do", "f_cmd="+(SEARCHLIST)+"&"+param);
    				srep_id = comObjects[2].Code;
    				rlane_cd = comObjects[5].Code;
    				trd_cd = comObjects[3].Code;
    				sub_trd_cd = comObjects[4].Code;
    				bound = formObj.bound.value;
    				ioc_cd = formObj.ioc.value;
    				sub_ofc_cd = comObjects[1].Code;
    				if(sheetObj.RowCount > 0){
    					formObj.accountType.value = sheetObj.CellValue(1, "fcast_cust_tp_cd");
    				}
    				check_retrive = true;
    				break;

                case IBSAVE:        //저장
    				if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
    				
    				var param = "salesRep="         + comObjects[2].Code;
    				param = param + "&ioc="         + formObj.ioc.value;
    				param = param + "&trade="       + comObjects[3].Code;
    				param = param + "&subTrade="    + comObjects[4].Code;
    				param = param + "&lane="        + comObjects[5].Code;
    				param = param + "&bound="       + formObj.bound.value;
    				param = param + "&accountType=" + formObj.accountType.value;
    				
                    //var rtn = doSaveSheet(sheetObj, "ESM_SPC_0103GS.do", "f_cmd="+(MULTI)+"&"+FormQueryString(formObj), null);
                    //var rtn = doSaveSheet(sheetObj, "ESM_SPC_0100GS.do", "f_cmd="+(MULTI01 + beforetab)+"&"+FormQueryString(formObj));
                    //var rtn = doSaveSheet(sheetObj, "ESM_SPC_0103GS.do", "f_cmd="+(MULTI)+"&"+FormQueryString(formObj),null);
                    var rtn = doSaveSheet(sheetObj, "ESM_SPC_0103GS.do", "f_cmd="+(MULTI)+"&"+param,null);
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
        
        function changeAccountType(){
        	var obj = event.srcElement;
        	var acct_tp = obj.value;
        	var sheetObj = sheetObjects[0];
        	for(var i = 0 ; i < sheetObj.RowCount ; i++){
        		sheetObj.CellValue(i + 1, "fcast_cust_tp_cd") = acct_tp;
        	}
        }
    	/*sheet에 선택한 pol 팝업값 셋팅
    	 * 
    	 */
    	function setSheet1PopUpValue(rowArray, row, col) {    		
    		var sheetObj = sheetObjects[0];
    		var colArray = rowArray[0];
    		var orgCd = sheetObj.CellValue(row,"fcast_cust_tp_cd");
    		sheetObj.CellValue(row, col) = colArray[3];
    		sheetObj.CellValue(row, col + 1) = colArray[4];
    		sheetObj.CellValue(row, "cust_cnt_cd") = colArray[3].substring(0, 2);
    		sheetObj.CellValue(row, "cust_seq") = colArray[3].substring(2);
    		sheetObj.CellValue(row, "fcast_cust_tp_cd") = orgCd;//
    	}
        
    	/* pol 공통팝업 클릭시			
    	 * 
    	 */	
    	function sheet1_OnPopupClick(sheetObj, row, col)
    	{
    	    if(sheetObj.ColSaveName(col) == "cust_cd" ) {
    			var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
    			var cust_cd = sheetObj.CellValue(row, col);
    			spcPopup("Customer", "cust_cd="+cust_cd+"&ofc_cd="+sub_ofc_cd, 770, 470, 'setSheet1PopUpValue', dispaly, row, col);
    	    }
    	}
    	var selectedCell_OldValue = 0;
        function sheet1_OnSelectCell(sheetObj, orow, ocol, row, col){
        	selectedCell_OldValue = sheetObj.CellValue(row, col)*1;
        }
    	function sheet1_OnChange(sheetObj, row, col, value){
//    		CustAbbrNm
        	switch(sheetObj.ColSaveName(col)){
        	case "cust_cd":
        		if(ComTrim(value).length <= 0){
    				sheetObj.CellValue2(row, col + 1) = "";
    				break;
        		}
        		else if(ComTrim(value).length <= 2){
        			ComShowCodeMessage("COM12143", "Account Code", "2");
    				sheetObj.CellValue2(row, col) = "";
    				sheetObj.SelectCell(row, col);
    				break;
        		}
        		if(isNaN(value.substring(2))){
    				ComShowMessage("Invalid Format");
    				sheetObj.CellValue2(row, col) = "";
    				sheetObj.SelectCell(row, col);
    				break;
        		}
        		value = value.toUpperCase();
        		var rtn = "";
        		if(value == "XX999999"){
        			rtn = new Array("XX999999|", "OTHERS|");
        		}
        		else{
        			rtn = getCodeList("CustAbbrNm", "cust_cnt_cd="+value.substring(0, 2)+"&cust_seq="+value.substring(2));
        		}
        		if(rtn[0] == ""){
        			sheetObj.CellValue2(row, col) = "";
        			sheetObj.CellValue2(row, col + 1) = "";
    				break;
        		}
        		if(rtn[0].split("|").length > 2){
    				var cust_cd = value;
    				spcPopup("Customer", "cust_cd="+cust_cd+"&ofc_cd="+sub_ofc_cd, 770, 470, 'setSheet1PopUpValue', dispaly, row, col);
    				break;
        		}
        		sheetObj.CellValue2(row, col + 1) = rtn[1].split("|")[0];
    			sheetObj.CellValue(row, "cust_cnt_cd") = value.substring(0, 2);
    			sheetObj.CellValue(row, "cust_seq") = value.substring(2);
        		sheetObj.CellValue2(row, col) = value;
        		break;
    		}
    		selectedCell_OldValue = value;
    	}

    	function trade_OnChange(comObj, value, text ){
//    		if(text == '|ALL'){	optionAllReset("trade",value);   return;} // 0207 SHKIM
//    		if(value == "") return;
    		SpcSearchOptionSubTrade("subtrade",true,false,"","",value);			// 0207 SHKIM
    		SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
    	} 
    	
    	function rgnOffice_OnChange(comObj, value, text ){
    		if(value == "") return;
    		var rtn = getCodeList("ChildOffice", "ofc_cd="+value+"&level=5&include=1");
    		initData_subOffice(rtn[0].split("|"), rtn[1].split("|"));
    		if(document.getElementById("subOffice").Code == ""){
    			var rtn = getCodeList("SalesRep", "ofc_cd="+value+"&level=4");
    			initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
    		}
    		
    		// 2010.05.10 subOffice Index = 0 값을 늦게 가져와서 재호출
    		var subObj = document.getElementById("subOffice");
    		subOffice_OnChange(subObj, subObj.Code, subObj.Text);
    	} 
    	
    	function subOffice_OnChange(comObj, value, text ){
    		var rtn = "";
    		if(value == ""){
    			rtn = getCodeList("SalesRep", "ofc_cd="+document.getElementById("rgnOffice").Code+"&level=4");
    		}
    		else{
    			rtn = getCodeList("SalesRep", "ofc_cd="+value+"&level=5");
    		}
    		initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
    	} 
    	
    	function initDataValue_rgnOffice(){
    	    var sheetObj = document.getElementById("rgnOffice");
    	    with(sheetObj){
    	        Index2 = 0;
    	    }
    	}

    	function initData_rgnOffice(codes, names){
    	    var sheetObj = document.getElementById("rgnOffice");
    	    var cnt = 0;
    	    with(sheetObj){
    	        RemoveAll();
    	        SetTitle("Office|Name");
    	        SetColWidth("60|250");
    	        SetColAlign("left|left");
    	        ShowCol = 0;
    	        MultiSelect = false;
    	        MaxSelect = 1;
    	        DropHeight = 190;
    	        if(codes == undefined || codes == null){
    	        	return;
    	        }
    	        if(codes.length > 2){
    	    		InsertItem(-1, "|ALL", "");
    	        }
    	    	var selectCode = "";
    		    for(var i = 0 ; i < codes.length - 1 ; i++){
    		    	var txt = names[i].split("~");
    		    	if(txt[1] == "1"){
    		    		selectCode = codes[i];
    		    	}
    		    	InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
    		    }
    		    if(selectCode != ""){
    		    	Code = selectCode;
    		    }
    		    else{
    		    	Index = 0;
    		    }
    			Enable = (GetCount() > 1);
    	    }
    	}	
    	function initData_subOffice(codes, names){
    	    var sheetObj = document.getElementById("subOffice");
    	    var cnt = 0;
    	    with(sheetObj){
    	        RemoveAll();
    	        SetTitle("Office|Name");
    	        SetColWidth("60|250");
    	        SetColAlign("left|left");
    	        ShowCol = 0;
    	        MultiSelect = false;
    	        MaxSelect = 1;
    	        DropHeight = 190;
    	        if(codes == undefined || codes == null){
    	        	return;
    	        }
    	        if(codes.length > 2){
    	    		InsertItem(-1, "|ALL", "");
    	        }
    	    	var selectCode = "";
    		    for(var i = 0 ; i < codes.length - 1 ; i++){
    		    	var txt = names[i].split("~");
    		    	if(txt[1] == "1"){
    		    		selectCode = codes[i];
    		    	}
    		    	InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
    		    }
    		    if(selectCode != ""){
    		    	Code = selectCode;
    		    }
    		    else{
    		    	Index = 0;
    		    }
    			Enable = (GetCount() > 1);
    			Enable = !(Index > 1);
    	    }
    	}
        
    	function initDataValue_subOffice(){
    	    var sheetObj = document.getElementById("subOffice");
    	    with(sheetObj){
    	        Index2 = 0;
    	    }
    	}
    	
    	function initData_salesRep(codes, names){
    	    var sheetObj = document.getElementById("salesRep");
    	    var cnt = 0;
    	    with(sheetObj){
    	    	RemoveAll();
    	        SetTitle("Code|Name|OFC|OFC NM");
    	        SetColWidth("60|150|60|100");
    	        SetColAlign("left|left|left|left");
    	        ShowCol = 0;
    	        MultiSelect = false;
    	        MaxSelect = 1;
    	        DropHeight = 190;
    	        if(codes == undefined || codes == null){
    	        	return;
    	        }
    	        if(codes.length > 2){
    	    		InsertItem(-1, "|ALL", "");
    	        }
    	    	var selectCode = "";
    		    for(var i = 0 ; i < codes.length - 1 ; i++){
    		    	var txt = names[i].split("~");
    		    	if(txt[3] == "1"){
    		    		selectCode = codes[i];
    		    	}
    		    	InsertItem(-1, codes[i]+"|"+names[i].replace(/~/g, "|"), codes[i]);
    		    }
    		    if(selectCode != ""){
    		    	Code = selectCode;
    		    }
    		    else{
    		    	Index = 0;
    		    }
    	    }
    	}
        
    	function initDataValue_salesRep(){
    	    var sheetObj = document.getElementById("salesRep");
    	    with(sheetObj){
    	        Index2 = 0;
    	    }
    	}

        function subTrade_OnChange(comObj,value,text ){
//        	if(text == '||ALL'){   optionAllReset("subtrade",document.form.trade.Code); return; } // 0207 SHKIM
        	if ( is_child == 'false' ) {
        		SpcSearchOptionLane("lane",true,true,'',document.form.trade.Code,value,true);	// 0207 SHKIM
	        	if(value == "" ) return;
	        	
	        	var arrSubtrade = text.split("|");
	        	if(arrSubtrade.length > 1) {
	        		comObjects[3].Code2 = arrSubtrade[0];
	        		comObjects[5].Code2 = '';
	        	} else {
	        		comObjects[3].Code2 = comObj.GetText(value,0);  
	        		comObjects[5].Code2 = '';
	        	}        	
        	}
        }  
        function trade_OnChange(comObj,value,text ){
//        	if(text == '|ALL'){	optionAllReset("trade",value);   return;} // 0207 SHKIM
        	if ( is_child == 'false' ) {
	        	if(value == "" ) return;
	        	var repTrade = comObj.GetText(value,0);  
	        	comObjects[4].Code2 = ""; //sub trade
	        	comObjects[5].Code2 = ""; // lane
        	}
        	SpcSearchOptionSubTrade("subtrade",true,false,"","",value);			// 0207 SHKIM
    		SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
        } 
        
        function lane_OnChange(comObj,value,text ){
        	// 해당사항없음.if(text == '||ALL'){	optionAllReset("lane");  } // 0207 SHKIM
        	if ( is_child == 'false' ) {
	        	comObj.UseCode=true;
		    	if(value == "" ) return;
		    	var arrLane = text.split("|");
		    	if(arrLane.length > 1) {
		    		comObjects[3].Code2 = arrLane[0];
		    		comObjects[4].Code2 = arrLane[1];
		    	} else {
		    		comObjects[3].Code2 = comObj.GetText(value,0);  
		    		comObjects[4].Code2 = comObj.GetText(value,1);  
		    	}
        	}
        }   
        
       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){

            switch(sAction) {
    			
               case IBSEARCH:      //조회
    				if(comObjects[2].Code == ""){
    					//ComShowMessage(getMsg("COM12113", "Sales Rep"));
    					ComShowMessage(getMsg("SPC90114", "Sales Rep"));
    					comObjects[2].focus();
    					return false;
    				}
    				if(formObj.ioc.value == ""){
    					ComShowMessage(getMsg("SPC90114", "IOC"));
    					formObj.ioc.focus();
    					return false;
    				}
    				if(comObjects[3].Code == ""){
    					ComShowMessage(getMsg("SPC90114", "Trade"));
    					comObjects[3].focus();
    					return false;
    				}
    				if(comObjects[4].Code == ""){
    					ComShowMessage(getMsg("SPC90114", "Sub Trade"));
//    					comObjects[4].focus();
    					return false;
    				}
    				if(comObjects[5].Code == ""){
    					ComShowMessage(getMsg("SPC90114", "Lane"));
    					comObjects[5].focus();
    					return false;
    				}
    				if(formObj.bound.value == ""){
    					ComShowMessage(getMsg("SPC90114", "Bound"));
    					formObj.bound.focus();
    					return false;
    				}
    		        return true;
    		    case IBSAVE:
    	    		var frow = sheetObj.ColValueDup("cust_cd"); 
    	    		if(frow > 0){
    	    			ComShowMessage(getMsg("SPC90114", "Account Code"));
    	    			sheetObj.SelectCell(frow, "cust_cd");
    	    			return false;
    	    		}
    		    	return true;
    		}
    		return true;
        }
        
        function sheet1_OnSaveEnd(sheetObj, errMsg) {
        	if(sheetObj.EtcData("status") == "OK"){
        		ComShowMessage("saved successfully.");  
        	}else{
        		ComShowMessage(errMsg);
        	}
        }

    	function initDataValue_trade(){
    	    var sheetObj = document.getElementById("trade");
    	    with(sheetObj){
    	        Index2 = 0;
    	    }
    	}
    	
    	function initDataValue_subTrade(){
    	    var sheetObj = document.getElementById("subTrade");
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
    	
    	function initDataValue_rgnOffice(){
    	    var sheetObj = document.getElementById("rgnOffice");
    	    with(sheetObj){
    	        Index2 = 0;
    	    }
    	}        
	/* 개발자 작업  끝 */
