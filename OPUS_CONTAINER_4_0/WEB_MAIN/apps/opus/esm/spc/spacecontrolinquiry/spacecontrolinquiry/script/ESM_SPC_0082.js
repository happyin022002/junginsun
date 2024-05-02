/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0082.js
*@FileTitle  : L/F Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */
    /**
     * @extends 
     * @class ESM_SPC_0082 : ESM_SPC_0082 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
//    function ESM_SPC_0082() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
   	/** 개발자 작업	*/
    // 공통전역변수
    var sheetObjects=new Array();
    var comObjects=new Array();
    var sheetCnt=0;
    var comboCnt=0;
    var param="";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    var init_year='';
    var init_week='';
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	/*******************************************************/
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    			case "btn_new":
    				sheetObject.RemoveAll();
    				formObject.reset();
    				ComResetAll();
    				formObject.year.value=init_year;
					formObject.week.value=init_week;
					SpcSearchOptionWeek("week",false,document.form.year.value);         
					SpcSearchOptionTrade("trade", true, true);
	     			SpcSearchOptionSubTrade("subtrade");
    				break;
    			case "btn_downexcel":		
           			doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
    				break;
    			case "btn_downexcel_data":
    				doActionIBSheet(sheetObject1, formObject, "IBDOWNEXCELDATA");
    				break;
//    			case "maxi":
//    					toggleSheetSize();
//    				break;
    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj) {
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
    	SpcSearchOptionTrade("trade", true, true);
    	SpcSearchOptionSubTrade("subtrade", true, true);
    	SpcSearchOptionBound("bound",false,true,false,false);
    	for(i=0;i<sheetObjects.length;i++) {
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	var sheetResizeFull=true;
    	document_onresize();
    	document.form.year.focus();
    	// TEST 용
    	//document.getElementById("year").value = "2009";
    	//document.getElementById("week").value = "35";
    	//comObjects[0].Text = "AES";
    	init_year=document.form.year.value; // 년 초기화용
    	init_week=document.form.week.value; // 주차 초기화용
    }
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	switch(sheetNo) {
    		case 1:      //sheet1 init
//    			sheetObj.SetSheetHeight(sheetObj.getSheetHeight(17));
    			
    			initSheet1(sheetObj, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120");
    			break;
    		case 2:      //sheet2 init
//    			sheetObj.SetSheetHeight(sheetObj.getSheetHeight(17) );
    			initSheet2(sheetObj);
    			break;
    	}
    }
    /**
     * Sheet1에서 조회후 타이틀 변경
     */
    function initSheet1(sheetObj, strWeeks, strFdTds) {
    	with (sheetObj) {
    		 SetFocusEditMode(default_edit_mode);
            var weekArr=strWeeks.split("|");
            var fdtdArr=strFdTds.split("|");
            var columnCount=2 + (weekArr.length) * 6 + 6;
//            (columnCount + 1, 2 , 0, true);
            var HeadTitle0="Sub Trade\n/Lane|";
            var HeadTitle1="Sub Trade\n/Lane|";
            var HeadTitle2="BSA|FULL|EMPTY|TTL LOAD|FULL L/F|TTL L/F";
            var WeekTitle="";
            var FdTdTitle="";
            var Title3="";
            for(var i=0 ; i < weekArr.length ; i++) {
	            for(var h=0 ; h < 6 ; h++) {
		            WeekTitle=WeekTitle + "|" + weekArr[i];
		            FdTdTitle=FdTdTitle + "|" + fdtdArr[i];
	            }
	            Title3=Title3 + "|" + HeadTitle2;
            }
            for(var h=0 ; h < 6 ; h++) {
	            WeekTitle=WeekTitle + "|G.TTL";
	            FdTdTitle=FdTdTitle + "|G.TTL";
            }
            Title3=Title3 + "|" + HeadTitle2;
            HeadTitle0=HeadTitle0 + WeekTitle;
            HeadTitle1=HeadTitle1 + FdTdTitle;
            HeadTitle2="Sub Trade\n/Lane| " + Title3;
            var cnt=0;

            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

            var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle0, Align:"Center"},
                        { Text:HeadTitle1, Align:"Center"},
                        { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"area",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                  for(var j=1 ; j < weekArr.length+1 ; j++){
		            cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bsa"+j,       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"full"+j,      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"empty"+j,     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_load"+j,  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"full_lf"+j,   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_lf"+j,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
		            }
		            cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"t_bsa",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"t_full",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"t_empty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"t_ttl_load",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"t_full_lf",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
		            cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"t_ttl_lf",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
		       
            InitColumns(cols);
            SetEditable(0);
            SetSheetHeight(ComGetSheetHeight(sheetObj, 17));
            SetRowHeight(20);
            SetRowHeight(21);
           
    	}
    }
    /**
     * Sheet1에서 조회후 타이틀 변경
     */
    function initSheet2(sheetObj) {
    	with (sheetObj) {
    		SetFocusEditMode(default_edit_mode);
//            (12, 0, 0, true);
            var HeadTitle="Week|Trade|Sub-Trade|Lane|Bound|VVD|BSA|FULL|MTY|TTL LOAD|FULL L/F|TTL L/F";
            var cnt=0;

            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

            var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"week",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lane",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bsa",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"full",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"empty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_load",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"full_lf",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_lf",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 } ];
             
            InitColumns(cols);
            SetEditable(0);
            SetSheetHeight(ComGetSheetHeight(sheetObj, 17));
            
            
    	}
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    }
    // Sheet1관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if(!validateForm(sheetObj,formObj,sAction)) {
    				return false;
    			}
    			formObj.f_cmd.value=SEARCHLIST01;
//    			sheetObjects[0].RemoveAll();
            	sheetObjects[0].RenderSheet(0);
    			param=SpcFormString(formObj, 'year,week,duration,trade,subtrade,bound,rhq'); 
     			rtn=sheetObjects[0].GetSearchData("ESM_SPC_0082GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    			week=getEtcDataFromXml(rtn, "week");
            	fdtd=getEtcDataFromXml(rtn, "fdtd");
//            	sheetObj.Reset();
            	initSheet1(sheetObj, week, fdtd);
            	sheetObj.LoadSearchData(rtn,{Sync:0} );
            	sheetObjects[0].RenderSheet(1);
    			break;
    		case IBDOWNEXCEL: 
    			if(sheetObj.RowCount() < 1){//no data
              		 ComShowCodeMessage("COM132501");
      	       		}else{//엑셀 다운로드
      	       			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, ExcelFontSize:9});
      	       		}
    			break;
    		case "IBDOWNEXCELDATA":        //엑셀 다운로드
    			if(param != "") {
    				formObj.f_cmd.value=SEARCHLIST02;
     				rtn=sheetObjects[1].GetSearchData("ESM_SPC_0082GS2.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    				initSheet2(sheetObj);
    				sheetObj.LoadSearchData(rtn,{Sync:0} );
    			}
    			if(sheetObj.RowCount() < 1){//no data
           		 	ComShowCodeMessage("COM132501");
   	       		} else {
   	       			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
   	       		}
    			break;
    	}
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
    	var dur=formObj.duration.value;
    	var trade=comObjects[0].GetSelectCode();
    	var rhq=formObj.rhq.value;
    	if(trade == "") {
    		ComShowMessage(getMsg("SPC90114", "Trade"));
//    		comObjects[0].focus();
    		return false;
    	}
    	if(rhq == "") {
    		ComShowMessage(getMsg("SPC90114", "RHQ"));
//    		formObj.rhq.focus();
    		return false;
    	}
    	if(trade == "IAS" && dur > 6) {
    		formObj.duration.value=5;
    	}
    	return true;
    }
    function getEtcDataFromXml(xml, str){
    	var pos=xml.indexOf("ETC KEY=\""+str+"\"");
    	if(pos < 0) return "";
		pos=xml.indexOf(">", pos + 1);
		if(pos < 0) return "";
		var epos=xml.indexOf("</ETC>", pos + 1);
		var rtn="";
		if(epos < 0){
			rtn=xml.substring(pos + 1);
		}
		else{
			rtn=xml.substring(pos + 1, epos);
		}
		return rtn;
	}
    /**
     * Start Week 의 year 변경시
     * Start Week 의 year 변경시 주차 변경
     */
    function checkWeek(){
    	SpcSearchOptionWeek("week",false,document.form.year.value);
    }   
    function trade_OnChange(comObj,value,text ){
//    	if(value == "" ) return;
    	var repTrade=comObj.GetText(value,0);  
    	comObjects[1].SetSelectCode("",false);//sub trade
    	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
    } 
    function subtrade_OnChange(comObj,value,text ){
    	if(value == "" ) return;
    	var arrTrade=text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].SetSelectCode(arrTrade[0],false);
    	} else {
    		comObjects[0].SetSelectCode(comObj.GetText(value,0),false);
    	}  
    }  
	/** 개발자 작업  끝 */
