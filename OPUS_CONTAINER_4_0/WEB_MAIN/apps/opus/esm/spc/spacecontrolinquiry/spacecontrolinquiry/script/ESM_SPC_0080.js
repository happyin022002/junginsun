/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_SPC_0080.js
 *@FileTitle : Weekly L/F by Carrier
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
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
     * @class ESM_SPC_0080 : ESM_SPC_0080 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
   
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
    var init_duration='';
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	/*******************************************************/
    	var sheetObject=sheet1;
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
       				resetAll();
       				formObject.year.value=init_year;
					formObject.week.value=init_week;  
					formObject.duration.value=init_duration;  
					SpcSearchOptionWeek("week",false,document.form.year.value);
					SpcSearchOptionTrade("trade");
					SpcSearchOptionSubTrade("subtrade", true, true);
					SpcSearchOptionLane("rlane_cd"); // 0207 SHKIM    
    				break;
    			case "btn_downexcel":
    				if(sheetObject.RowCount() < 1){//no data
    					ComShowCodeMessage("COM132501");
    				}else{
    					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
    				}
    				break;
    			case "btn_downexcel_data":
    				if(sheetObject.RowCount() < 1){//no data
    					ComShowCodeMessage("COM132501");
    				}else{
    					doActionIBSheet(sheetObject1, formObject, "IBDOWNEXCELDATA");
    				}
    				break;
    			case "btn_bsa":
    				var sUrl="/hanjin/ESM_SPC_0084.do";
    		          ComOpenPopup(sUrl, 600, 400, "", "0,0", true, false, "", "", "","BSA INPUT"); 
    				break;    	    				
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
     	SpcSearchOptionDuration("duration", 15, 1);
     	SpcSearchOptionTrade("trade");
     	SpcSearchOptionSubTrade("subtrade", true, true);
     	SpcSearchOptionLane("rlane_cd");
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
    	// Operator Combo 초기화
    	var rtn=getCodeList("Operator", "");
    	//initData_operator(rtn[0].split("|"), rtn[1].split("|"));
    //	document.form.year.focus();
    	// TEST 용
    	//document.getElementById("year").value = "2009";
    	//document.getElementById("week").value = "35";
    	//comObjects[0].Text = "AES";
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
    	switch(sheetNo) {
    		case 1:      //sheet1 init
//    			sheetObj.SetSheetHeight(sheetObj.getSheetHeight(17) );
    			initSheet1(sheet1, "200701|200702|200703", "20070101~20070106|20070107~20070113|20070114~20070120");
    			break;
    		case 2:      //sheet2 init
//    			sheetObj.SetSheetHeight(sheetObj.getSheetHeight(17) );
    			initSheet2(sheet2);
    			break;
    	}
    }
    /**
     * Sheet1에서 조회후 타이틀 변경
     */
    function initSheet1(sheetObj, strWeeks, strFdTds) {
        with(sheetObj){
            //no support[check again]CLT 		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
          SetFocusEditMode(default_edit_mode);
          var weekArr=strWeeks.split("|");
          var fdtdArr=strFdTds.split("|");
          var columnCount=3 + (weekArr.length) * 7;
          var HeadTitle0="Sub Trade\n/Lane|Carrier|";
          var HeadTitle1="Sub Trade\n/Lane|Carrier|";
          var WeekTitle="";
          var FdTdTitle="";
          var Title3="";
          for(var i=0 ; i < weekArr.length ; i++) {
          for(var h=0 ; h < 7 ; h++) {
          WeekTitle=WeekTitle + "|" + weekArr[i];
          FdTdTitle=FdTdTitle + "|" + fdtdArr[i];
          }
          }
          HeadTitle0=HeadTitle0 + WeekTitle;
          HeadTitle1=HeadTitle1 + FdTdTitle;
          var cnt=0;

          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"area",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"opr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	        for(var j = 1 ; j < weekArr.length+1 ; j++){
	          cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bsa"+j,      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	          cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"full"+j,     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	          cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"empty"+j,    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	          cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_load"+j, KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	          cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_wgt"+j,  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	          cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"full_lf"+j,  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
	          cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_lf"+j,   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 });
	        }
          /*for(var m = 0 ; m <columnCount ; m ++) {
	          GetCellBackColor(1,m) = "#555555";
	          GetCellBackColor(2,m) = "#555555";
          }*/
          SetCellBackColor(1,0,"#555555");
          InitColumns(cols);
          SetSheetHeight(200);
          SetEditable(0);
          /*SetCellBackColor(1,0,"#555555");
          SetCellBackColor(1,m,"#555555");
          SetCellBackColor(2,m,"#555555");*/
//                SetHeaderRowHeight(20);
//          SetHeaderRowHeight(21);
          }


    }
    /**
     * Sheet1에서 조회후 타이틀 변경
     */
    function initSheet2(sheetObj) {
        with(sheetObj){
            //no support[check again]CLT 		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		          SetFocusEditMode(default_edit_mode);
		          var HeadTitle="Carrier|Week|Trade|Sub-Trade|Lane|VVD|Bound|BSA|FULL|MTY|TTL LOAD|TTL WGT|FULL L/F|TTL L/F";
		          var cnt=0;
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"opr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"week",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lane",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bound",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bsa",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"full",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"empty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_load",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_wgt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"full_lf",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_lf",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 } ];
		           
		          InitColumns(cols);
		
		          SetEditable(0);
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
//    			sheet1.RemoveAll();
//    			sheetObj.RenderSheet(0);
    			param=SpcFormString(formObj, 'year,week,duration,trade,subtrade,rlane_cd,bound,rhq,area,operator');//2010.09.16 이윤정 [CHM-201005916-01] 검색 조건 중 subtrade 추가 
     			rtn=sheetObj.GetSearchData("ESM_SPC_0080GS.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    			week=getEtcDataFromXml(rtn, "week");
            	fdtd=getEtcDataFromXml(rtn, "fdtd");
//            	sheetObj.Reset();
//            	sheetObj.RemoveAll();
            	sheetObj.RenderSheet(0);
            	initSheet1(sheetObj, week, fdtd);
//            	sheetObj.LoadSearchData(rtn,{Sync:1} );
            	sheetObj.RenderSheet(1);
            	sheetObj.RemoveAll();
            	sheetObj.LoadSearchData(rtn,{Sync:1} );
    			break;
    		case IBDOWNEXCEL:        //엑셀 다운로드
     			sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
    			break;
    			
    		case "IBDOWNEXCELDATA":        //엑셀 다운로드
    			if(param != "") {
    				formObj.f_cmd.value=SEARCHLIST02;
     				rtn=sheetObjects[1].GetSearchData("ESM_SPC_0080GS2.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
    				initSheet2(sheetObj);
    				sheetObj.LoadSearchData(rtn,{Sync:1} );
    			}
     			sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1, ExcelFontSize:9});
    			break;
    	}
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction) {
    	var mTrade=comObjects[0].GetSelectCode();
    	var rhq=formObj.rhq.value;
    	if(mTrade == "") {
    		ComShowMessage(getMsg("SPC90114", "Trade"));
    		ComSetFocus(document.getElementById(comObjects[0].options.id + "_text"));
    		return false;
    	}
    	if(rhq == "") {
    		ComShowMessage(getMsg("SPC90114", "RHQ"));
    		formObj.rhq.focus();
    		return false;
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
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initData_operator(codes, names){
    	var sheetObj=document.getElementById("operator");
    	var cnt=0;
    	with(sheetObj){
    		sheetObj.RemoveAll();
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
    			SetSelectIndex(0);
    		}
	//    		SetEnable((GetItemCount() > 1));
	//    		SetEnable(!(Index > 1));
    	}
    }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
  	 function initDataValue_operator(){
 	    var sheetObj=document.getElementById("operator");
 	    with(sheetObj){
 	        SetSelectIndex(0);
 	    }
 	 } 
     /*
      * Trade OnChange시
      */  	 
     function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
//    	if(text == '|ALL'){	optionAllReset2("trade",value,"true");   return;} // 0207 SHKIM
//      	if(value == "" ) return;
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
    	SpcSearchOptionLane("rlane_cd",true,false,'',trade.GetSelectCode(),newCode,true);	// 0207 SHKIM
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
     function rlane_cd_OnChange(comObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
    	var arrLane=newText.split("|");
    	if(arrLane.length > 1) {
    		comObjects[0].SetSelectCode(arrLane[0],false);
    		comObjects[1].SetSelectCode(arrLane[1],false);
    	} else {
    		comObjects[0].SetSelectCode(comObj.GetText(newCode,0),false);
    		comObjects[1].SetSelectCode(comObj.GetText(newCode,1),false);
    	}	
     }      
     function initDataValue_trade(){
      	var sheetObj=document.getElementById("trade");
      	with(sheetObj){
      		SetSelectIndex(0);
      	}
      }
      function initDataValue_subtrade(){
      	var sheetObj=document.getElementById("subtrade");
      	with(sheetObj){
      		SetSelectIndex(0);
      	}
      }
      function initDataValue_rlane_cd(){
      	var sheetObj=document.getElementById("rlane_cd");
      	with(sheetObj){
      		SetSelectIndex(0);
      	}
      }  
      /**
       * Start Week 의 year 변경시
       * Start Week 의 year 변경시 주차 변경
       */
      function checkWeek(){
      	SpcSearchOptionWeek("week",false,document.form.year.value);
      }  
	/** 개발자 작업  끝 */
