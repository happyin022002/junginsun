/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0056.js
*@FileTitle  : spacecontrolinquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    //sheetResizeFull = true;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject=sheetObjects[0];
             var sheetObject1=sheetObjects[1];
             /*******************************************************/
             var formObject=document.form;
//        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
            	    case "btn_retrieve":
        	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
            	        break;
            	    case "btn_downexcel":
            	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	        break;
    				case "btn_popup_port": 
    					var port=formObject.port.value;
            	        spcPopup("Port", "port="+port, 770, 470, "callbackPopupPortCd", "1,0,1,1,1,1,1,1");
    					break;
                    case "btn_new":
                        doActionIBSheet(sheetObject,formObject,IBCLEAR);
						SpcSearchOptionTrade("trade", true, true, '', true);
						SpcSearchOptionSubTrade("subtrade", true, true);
						SpcSearchOptionLane("lane"); // 0207 SHKIM    
                        break;					      	        
            	    case "btns_calendar1":
            	        // 달력 팝업
            	        var cal=new ComCalendar();
               		    //cal.select(formObject.sDate, 'sDate', 'yyyy-MM-dd');
            	        cal.select(formObject.sDate, 'yyyy-MM-dd');
            	        break;
            	    case "btns_calendar2":
            	        // 달력 팝업
            	        var cal=new ComCalendar();
               		    //cal.select(formObject.eDate, 'eDate', 'yyyy-MM-dd');
            	        cal.select(formObject.eDate, 'yyyy-MM-dd');
            	        break;
                } // end switch
//        	}catch(e) {
//        		if( e == "[object Error]") {
//        			ComShowCodeMessage("COM12111");
//        		} else {
//        			ComShowMessage(e);
//        		}
//        	}
        }
        function getOffice(rowArray){
            var colArray=rowArray[0];	
        	document.all.office.value=colArray[3];
        }
        function getPOL(rowArray){
            var colArray=rowArray[0];	
        	document.all.pol.value=colArray[3];
        }
        /**
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
           comObjects[comboCnt++]=combo_obj;
        }
        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	SpcSearchOptionTrade("trade", true, true, '', true);
        	SpcSearchOptionSubTrade("subtrade", true, true);
        	SpcSearchOptionLane("lane");
        	SpcSearchOptionBound("bound",false,true,false,true);
        	SpcSearchOptionOcnipc("ioc",true);
            document.body.style.visibility="hidden";
            //document.getElementById("mainTable2").style.display= "inline";
            for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            var sheetResizeFull=true;
    		document_onresize();
            //document.getElementById("mainTable2").style.display= "none";
            document.body.style.visibility="visible";
    		var formObject=document.form;
    		setInitDate();
    		/* test using s
    		if(isDevMode)
    		{
    			 formObject.org.value="";
    			 formObject.sDate.value="20070527";
    			 formObject.eDate.value="20070610";
    			 formObject.port.value="CNHKG";
    			 comObjects[0].SetSelectCode("TPS");
    		}
    		test using e */		
        }
        function setInitDate() {
    		var formObject=document.form;
    		var cDate=new Date();
    		formObject.sDate.value=(cDate.getYear()+1900)+"-"+((cDate.getMonth()+1)<10?"0":"")+(cDate.getMonth()+1)+"-"+((cDate.getDate())<10?"0":"")+cDate.getDate();
    		cDate=new Date(cDate.getYear(), cDate.getMonth(), cDate.getDate() + 13);
    		formObject.eDate.value=(cDate.getYear()+1900+1900)+"-"+((cDate.getMonth()+1)<10?"0":"")+(cDate.getMonth()+1)+"-"+((cDate.getDate())<10?"0":"")+cDate.getDate();
    		formObject.sDate.focus();
        }
       /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with(sheetObj){
	                 SetFocusEditMode(default_edit_mode);
	                 var HeadTitle1="ETB|Rep.\nTrade|Rep.\nSubTrd|Trade|Sub\nTrade|Lane|Week|VVD|OCN\nIPC|RHQ|Area|Office|SUB\nOffice| |Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Forecast|Allocation|Allocation|Allocation|Allocation|Allocation|Allocation|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Alloc DIFF (with bkg)|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|By Discharging Vessel|By Discharging Vessel|By Discharging Vessel|By Discharging Vessel|By Discharging Vessel|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking";
	                 var HeadTitle2="ETB|Rep.\nTrade|Rep.\nSubTrd|Trade|Sub\nTrade|Lane|Week|VVD|OCN\nIPC|RHQ|Area|Office|SUB\nOffice| |POD|TEU|HC|45|53'|RF|WT|TEU|HC|45|53'|RF|WT|TEU|HC|45|53'|RF|WT|Total|Total|Total|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|Rep.|Sub|Lane|VVD|ETB|Total|Total|Total|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz|By Tp/Sz";
	                 var HeadTitle3="ETB|Rep.\nTrade|Rep.\nSubTrd|Trade|Sub\nTrade|Lane|Week|VVD|OCN\nIPC|RHQ|Area|Office|SUB\nOffice| |POD|TEU|HC|45|53'|RF|WT|TEU|HC|45|53'|RF|WT|TEU|HC|45|53'|RF|WT|Total TEU|20|40|20|40|HC|45|53'|RF20|RF40|WT|Trade| Trade ||||Total TEU|20|40|20|40|HC|45|53'|RF20|RF40|WT";
	
	                 SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
	                 var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	                 var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"}, { Text:HeadTitle3, Align:"Center"} ];
	                 InitHeaders(headers, info);
	                 var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"etb_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"rep_trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rep_sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"lane",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"week",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ioc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rhq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"aq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ofc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_teu",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_hc",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_45",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_53",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"fcast_rf",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"fcast_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"aloc_teu",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"aloc_hc",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"aloc_45",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"aloc_53",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"aloc_rf",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"aloc_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"diff_teu",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"diff_hc",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"diff_45",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"diff_53",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"diff_rf",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"diff_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"bkg_teu",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bkg_t20",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bkg_t40",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bkg_20",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bkg_40",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bkg_hc",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bkg_45",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bkg_53",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bkg_r20",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"bkg_r40",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bkg_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dis_trd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"dis_sub_trd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"dis_lane",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dis_vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dis_etb_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"dis_teu",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dis_t20",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dis_t40",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dis_20",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dis_40",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dis_hc",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dis_45",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dis_53",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dis_r20",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:"dis_r40",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"dis_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
	                  
	                 InitColumns(cols);
	                 SetEditable(0);
	                 SetSheetHeight(ComGetSheetHeight(sheetObj,19) );
	                 SetHeaderRowHeight(10);
	                 var backColor="#555555";
	                 SetRangeBackColor(1, 13, 2, 49,backColor);
	                 backColor="#555555";
	                 SetRangeBackColor(2, 13, 2, 49,backColor);
                 }
                    break;
                case 2:      //sheet2 init
                    break;
            }
        }
    function viewByTpSz(){
    	var obj=event.srcElement;
    	var status=!obj.checked;
    	var sheetObj=sheetObjects[0];
    	sheetObj.SetColHidden("fcast_hc"  ,status);
    	sheetObj.SetColHidden("fcast_45"  ,status);
    	sheetObj.SetColHidden("fcast_53"  ,status);
    	sheetObj.SetColHidden("fcast_rf"  ,status);
    	sheetObj.SetColHidden("fcast_wgt" ,status);
    	sheetObj.SetColHidden("aloc_hc"  ,status);
    	sheetObj.SetColHidden("aloc_45"  ,status);
    	sheetObj.SetColHidden("aloc_53"  ,status);
    	sheetObj.SetColHidden("aloc_rf"  ,status);
    	sheetObj.SetColHidden("aloc_wgt" ,status);
    	sheetObj.SetColHidden("diff_hc"  ,status);
    	sheetObj.SetColHidden("diff_45"  ,status);
    	sheetObj.SetColHidden("diff_53"  ,status);
    	sheetObj.SetColHidden("diff_rf"  ,status);
    	sheetObj.SetColHidden("diff_wgt" ,status);
    	sheetObj.SetColHidden("bkg_t20"  ,status);
    	sheetObj.SetColHidden("bkg_t40"  ,status);
    	sheetObj.SetColHidden("bkg_20"   ,status);
    	sheetObj.SetColHidden("bkg_40"   ,status);
    	sheetObj.SetColHidden("bkg_hc"   ,status);
    	sheetObj.SetColHidden("bkg_45"   ,status);
    	sheetObj.SetColHidden("bkg_53"   ,status);
    	sheetObj.SetColHidden("bkg_r20"  ,status);
    	sheetObj.SetColHidden("bkg_r40"  ,status);
    	sheetObj.SetColHidden("bkg_wgt"  ,status);
    	sheetObj.SetColHidden("dis_t20"  ,status);
    	sheetObj.SetColHidden("dis_t40"  ,status);
    	sheetObj.SetColHidden("dis_20"   ,status);
    	sheetObj.SetColHidden("dis_40"   ,status);
    	sheetObj.SetColHidden("dis_hc"   ,status);
    	sheetObj.SetColHidden("dis_45"   ,status);
    	sheetObj.SetColHidden("dis_53"   ,status);
    	sheetObj.SetColHidden("dis_r20"  ,status);
    	sheetObj.SetColHidden("dis_r40"  ,status);
    	sheetObj.SetColHidden("dis_wgt"  ,status);
    	if(status){
            sheetObj.SetColWidth("fcast_teu",60);
    		sheetObj.SetColWidth("aloc_teu",60);
    		sheetObj.SetColWidth("diff_teu",120);
    		sheetObj.SetColWidth("bkg_teu",60);
    		sheetObj.SetColWidth("dis_teu",60);
    	}
    	else{
             sheetObj.SetColWidth("fcast_teu",40);
    		sheetObj.SetColWidth("aloc_teu",40);
    		sheetObj.SetColWidth("diff_teu",40);
    		sheetObj.SetColWidth("bkg_teu",40);
    		sheetObj.SetColWidth("dis_teu",40);
    	}
    }
        function sheet1_OnSaveEnd(sheetObj, ErrMsg){
            log("sheet1_OnSaveEnd " + ErrMsg);
            if (ErrMsg == ""){
            }
            else{
            }
        }
        function sheet1_OnChange(sheetObj, row, col, val){
            cellChange(sheetObj, row, col, val, 7);
        }
        function sheet1_OnClick(sheetObj, row, col){
        	switch(sheetObj.ColSaveName(col)){
        	case "RHQCD":
        	case "OFFICECD":
        		if(sheetObj.GetCellValue(row, col) == "+"){
        			sheetObj.SetRowExpanded(row,!sheetObj.GetRowExpanded(row));
        		}
        		break;
        	}
        }    
        function cellChange(sheetObj, row, col, val, tcol){
        	var flg=(val==sheetObj.GetCellValue(row, col+12))?"R":"U";
            var flg_col=col+24;
            var pstat=sheetObj.GetCellValue(row, flg_col);
            sheetObj.SetCellValue(row, flg_col,flg,0);
        }
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
            sheetObj.RenderSheet(0);
            switch(sAction) {
               case IBSEARCH:      //조회
    				if(!validateForm(sheetObj,formObj,sAction)){
            			sheetObj.RenderSheet(1);
    					return false;
    				}
//                	formObj.f_cmd.value = SEARCHLIST;
                	var  param="sDate=" + formObj.sDate.value;
                	param=param + "&eDate=" + formObj.eDate.value;
                	param=param + "&port=" + formObj.port.value;
                	param=param + "&vvd=" + formObj.vvd.value;
                	param=param + "&org=" + formObj.org.value;
                	param=param + "&trade=" + comObjects[0].GetSelectCode();
                	param=param + "&subtrade=" + comObjects[1].GetSelectCode();
                	param=param + "&lane=" + comObjects[2].GetSelectCode();
                	param=param + "&bound=" + formObj.bound.value;
                	param=param + "&ioc=" + formObj.ioc.value;
                	param=param + "&chktyp=" + formObj.chkTYP.value;
//                           	
//              	var rtn =  sheetObj.DoSearch4Post("ESM_SPC_0056GS.do", FormQueryString(formObj));
                 	var rtn =  sheetObj.DoSearch("ESM_SPC_0056GS.do","f_cmd=" + (SEARCHLIST)+"&"+param );
                    break;
               case IBDOWNEXCEL:        //엑셀 다운로드
            	   
            	   if(sheetObj.RowCount() < 1){//no data
            			ComShowCodeMessage("COM132501");
            		}else{
            			sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, ExcelFontSize:9});            		
            		}
                  	
                  	break;             
              case IBCLEAR:        //초기화 
            	  	formObj.reset();
    				setInitDate();
    				//sheetObj.RemoveAll();
                  	break;               
            }
            sheetObj.RenderSheet(1);
        }
    /* 조회된 데이터의 수정 가능여부 체크 */
        function setEditable(sheetObj){
            var rows=sheetObj.RowCount();
            var scol=6;
            if(sheetObj.id == "sheet2"){
                scol=scol + 2;
            }
            var val="";
            for(var i=0 ; i < rows ; i++){
                for(var m=0 ; m < 12 ; m++){
                	val=sheetObj.GetCellValue(i+2, m + scol + 12);
                    if(val==""){
                        sheetObj.SetCellEditable(i+2, m + scol,0);
                    }
                    else{
                        sheetObj.SetCellEditable(i+2, m + scol,1);
                    }
                }
            }
        }
       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
        		switch(sAction) {
        			case IBSEARCH:      //조회
    			        if(formObj.port.value == ""){
    			            ComShowMessage(getMsg("SPC90114", "Port"));
    			            formObj.port.focus();
    			            return false;
    			        }
    			        if(formObj.port.value.length < 5){
    			        	ComShowCodeMessage("COM12174", "Port", 5);
    			            formObj.port.focus();
    			            return false;
    			        }
    			        if( formObj.vvd.value == "" ){    			
        			        if(formObj.sDate.value == ""){
        			            ComShowMessage(getMsg("SPC90114", "Start Date"));
        			            formObj.sDate.focus();
        			            return false;
        			        }
        			        if(formObj.eDate.value == ""){
        			            ComShowMessage(getMsg("SPC90114", "End Date"));
        			            formObj.eDate.focus();
        			            return false;
        			        }
        			        if(comObjects[0].GetSelectCode()== ""){
        			            ComShowMessage(getMsg("SPC90114", "Trade"));
        			            return false;
        			        }
    			        }else if (formObj.vvd.value.length < 9){
    			        	ComShowCodeMessage("COM12174", "VVD", "9");
    			            formObj.vvd.focus();
    			            return false;
    			        }
        				break;
        			case IBDOWNEXCEL:        //엑셀 다운로드
        				break;
        		}
    		}
    		return true;
        }
        function callbackPopupPortCd(rowArray){
            var colArray=rowArray[0];	
            var val=colArray[3];
        	document.all.port.value=val;
        }     
    function trade_OnChange(comObj,value,text ){
//    	if(text == '|ALL'){	optionAllReset("trade",value,"true");   return;} // 0207 SHKIM
//    	if(value == "") return;
    	//sub_trade의 초기화
    	comObjects[1].SetSelectIndex(0,false);
    	//lane의 초기화
    	comObjects[2].SetSelectIndex(0,false);
    	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
    }   
    function subtrade_OnChange(comObj,value,text ){
//    	if(text == '||ALL'){   
//    		// 사용안함. 직접 optionAllReset("subtrade",document.form.trade.Code,"true"); 
//    		SpcSearchOptionSubTrade("subtrade",true,true,"","",document.form.trade.Code);			// 0207 SHKIM   			
//	    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,'',true);	// 0207 SHKIM   
//    		return; 
//    	} // 0207 SHKIM    	
    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.GetSelectCode(),value,true);	// 0207 SHKIM
    	if(value == "") return;
     	var arrTrade=text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].SetSelectCode(arrTrade[0],false);
    	} else {
    		comObjects[0].SetSelectCode(comObj.GetText(value,0),false);
    	}     	    
	    //lane value change
	    comObjects[2].SetSelectIndex(0,false);
    } 
    function lane_OnChange(comObj,value,text ){
    	if(value == "" ) return;
    	var repTrade=comObj.GetText(value,0);  
    	var subTrade=comObj.GetText(value,1);
    	comObjects[0].SetSelectCode(repTrade,false);
    	comObjects[1].SetSelectCode(subTrade,false);
    }
    function initDataValue_trade(){
     	var sheetObj=document.getElementById("trade");
     	with(sheetObj){
     		Index2=0;
     	}
     }
     function initDataValue_subtrade(){
     	var sheetObj=document.getElementById("subtrade");
     	with(sheetObj){
     		Index2=0;
     	}
     }
     function initDataValue_lane(){
     	var sheetObj=document.getElementById("lane");
     	with(sheetObj){
     		Index2=0;
     	}
     }
	/* 개발자 작업  끝 */
