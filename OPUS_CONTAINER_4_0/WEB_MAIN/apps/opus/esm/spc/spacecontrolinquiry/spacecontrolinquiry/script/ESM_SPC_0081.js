

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* 개발자 작업	*/
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    var init_year='';
    var init_week='';
    var init_duration='';
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	// try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
        	    case "btn_retrieve":
   	            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            break;
				case "btn_new":
					if(checkModifiedSheet(sheetObject)) {
						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
							return;
						}
					}
	            	//공통함수사용: 화면을 초기화
//					resetAll();
					sheet1.RemoveAll();
       				formObject.year.value=init_year;
					formObject.week.value=init_week;  
					formObject.duration.value=init_duration; 
					SpcSearchOptionWeek("week",false,document.form.year.value);
					SpcSearchOptionTrade("trade");
					SpcSearchOptionSubTrade("subtrade", true, true);
					SpcSearchOptionLane("rlane_cd"); // 0207 SHKIM    		
					break;
        	    case "btn_downexcel":
   	            	doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
        	        break;
    			case "btn_bsa":
    				var sUrl="/hanjin/ESM_SPC_0084.do";
  		          ComOpenPopup(sUrl, 600, 400, "", "0,0", true, false, "", "", "","BSA INPUT"); 
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
     	SpcSearchOptionYear("year");
     	SpcSearchOptionWeek("week");
     	SpcSearchOptionDuration("duration", 15, 1);
     	SpcSearchOptionTrade("trade");
     	SpcSearchOptionSubTrade("subtrade", true, true);
     	SpcSearchOptionLane("rlane_cd");
     	SpcSearchOptionBound("bound",false,true,false,false);
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetResizeFull=true;
		document_onresize();
		// Operator Combo 초기화
    	var rtn=getCodeList("Operator", "");
    	initData_operator(rtn[0].split("|"), rtn[1].split("|"));
//    	document.form.year.focus();
    	init_year=document.form.year.value; // 년 초기화용
    	init_week=document.form.week.value; // 주차 초기화용
    	init_duration=document.form.duration.value; // 기간 초기화용
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
                with (sheetObj) {
	                var HeadTitle="Carrier|Week|Trade|Sub-Trade|Lane|VVD|Bound|BSA|F/M|20F|2H|40F|4H|45F|Full TEU|Full WGT|Mty TEU|Mty WGT|POL|POD";
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"OPR_CD",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"COST_WK",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"TRD_CD",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"SUB_TRD_CD",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"RLANE_CD",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"VVD",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"DIR_CD",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"BASIC_SLOT",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"CNTR_TYPE",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"CNTR_20",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"CNTR_20H",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"CNTR_40",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"CNTR_40H",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"CNTR_45",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"FULL_TEU",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"FULL_WGT",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"MTY_TEU",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"MTY_WGT",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POL",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                    {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"POD",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	                
	                SetFocusEditMode(default_edit_mode);
	                InitColumns(cols);
	                SetEditable(0);
	                SetSheetHeight(ComGetSheetHeight(sheetObj, 20));
               	}
                break;
        }
    }
    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, quite) {
    	if(quite == undefined) quite=false;
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
                sheetObj.ReDraw=false;
                formObj.f_cmd.value=SEARCHLIST;
                var param=SpcFormString(formObj,'f_cmd,year,week,duration,trade,subtrade,rlane_cd,rhq,bound,operator');
                sheetObj.DoSearch("ESM_SPC_0081GS.do", param);
                sheetObj.ReDraw=true;     
                break;
			case IBDOWNEXCEL:        //엑셀 다운로드        

				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
				}
              	break;
        }
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        var year=formObj.year.value;
        if(year == ""){
        	ComShowMessage(getMsg("SPC90114","Year")); 
//            formObj.year.focus();
            return false;
        }
        var week=formObj.week.value;
        if(week == ""){
        	ComShowMessage(getMsg("SPC90114","Week")); 
//            formObj.week.focus();
            return false;
        }
        var duration=formObj.duration.value;
        if(duration == ""){
        	ComShowMessage(getMsg("SPC90114","Duration")); 
//            formObj.duration.focus();
            return false;
        }
        var trade=formObj.trade.value;
        if(trade == "" || comObjects[0].GetSelectCode()== ""){
        	ComShowMessage(getMsg("SPC90114","Trade")); 
//            formObj.trade.focus();
            return false;
        }
        var rhq=formObj.rhq.value;
        if(rhq == ""){
        	ComShowMessage(getMsg("SPC90114","RHQ")); 
//            formObj.rhq.focus();
            return false;
        }
        return true;
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function initDataValue_operator(){
	    with(operator){
	        SetSelectIndex(0);
	    }
	}
    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initData_operator(codes, names){
//    	var sheetObj=document.getElementById("operator");
    	var cnt=0;
    	with(operator){
    		RemoveAll();
    		SetTitle("Carrier");
    		//SetColWidth("60|250");
    		SetColAlign(0, "left");
    		//ShowCol     = 0;
    		SetMultiSelect(0);
    		SetMaxSelect(1);
    		SetDropHeight(190);
    		if(codes == undefined || codes == null){
    			return;
    		}
    		if(codes.length > 2){
    			InsertItem(-1, "|ALL", "");
    		}
    		var selectCode="";
    		for(var i=0 ; i < codes.length - 1 ; i++){
    			var txt=names[i].split("~");
    			if(txt[1] == "1"){
    				selectCode=codes[i];
    			}
    			InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
    		}
    		if(selectCode != ""){
    			Code=selectCode;
    		} else {
    			GetSelectIndex(0);
    		}
    		SetEnable((GetItemCount() > 1));
    		SetEnable(!(GetSelectIndex() > 1));
    	}
    }
    /*
     * Trade OnChange시
     */  	 
    function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//    	if(text == '|ALL'){	optionAllReset2("trade",value,"true");   return;} // 0207 SHKIM
//     	if(value == "" ) return;
    	var repTrade=comboObj.GetText(newCode,0);  
    	comObjects[1].SetSelectCode("",false);//sub trade
    	comObjects[2].SetSelectCode("",false);// lane
    	SpcSearchOptionSubTrade("subtrade",true,true,"","",newCode);			// 0207 SHKIM
		SpcSearchOptionLane("rlane_cd",true,false,'',newCode,'',true);	// 0207 SHKIM
    }
    /*
     * Sub Trade OnChange시
     */
    function subtrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){  
//    	if(text == '||ALL'){   optionAllReset2("subtrade",document.form.trade.Code,"true"); return; } // 0207 SHKIM
    	SpcSearchOptionLane("rlane_cd",true,false,'', trade.GetSelectCode(),newCode,true);	// 0207 SHKIM
   	 	if(newCode == "") return;
     	var arrTrade=newText.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].SetSelectCode(arrTrade[0],false);
    		comObjects[2].SetSelectCode('',false);
    	} else {
    		comObjects[0].SetSelectCode(comboObj.GetText(newCode,0),false);
    		comObjects[2].SetSelectCode('',false);
    	}
    }
    /*
     * lane OnChange시
     */     
    function rlane_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	if(newCode == "" ) return;
    	var arrLane = newText.split("|");
    	if(arrLane.length > 1) {
    		comObjects[0].SetSelectCode(arrLane[0],false);
    		comObjects[1].SetSelectCode(arrLane[1],false);
    	} else {
    		comObjects[0].SetSelectCode(comboObj.GetText(newCode,0),false);
    		comObjects[1].SetSelectCode(comboObj.GetText(newCode,1),false);
    	}
    }
      /**
       * Start Week 의 year 변경시
       * Start Week 의 year 변경시 주차 변경
       */
      function checkWeek(){
      	SpcSearchOptionWeek("week",false,document.form.year.value);
      }         
	/* 개발자 작업  끝 */
