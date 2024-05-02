/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cim_1061.js
 *@FileTitle : Location M/B by COA BKG
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.03.17
 *@LastModifier : 박명신
 *@LastVersion : 1.0	
 * 2011.03.17	
 * 1.0 Creation	
 * --------------------------------------------------------
 * History
 * 2012.07.06 신자영 [CHM-201218595-01] M/B 기능으로 Trend 검색 시, Type별 total 컬럼 추가
 * 2012.10.10 신자영 [CHM-201220642-01] Location M/B By COA BKG 보완
 * 2012.12.04 신자영 [CHM-201221786-01] TP/SZ 추가 요청
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
 * @class ees_cim_1061 : ees_cim_1061 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cim_1061() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업  */
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ; 
var beforetab = 1; 
var tabIndex = 0;
var beforetabForClick = 0;				 

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array(); 
var comboCnt = 0;	 	

//t1sheet1을 다이나믹하게 사용하기 위한
var t1sheet1Stats = true;	

var currT1sheet1trade = "";

var currT2sheet1trade = "";
var currT2sheet1Period = "";	
var currT2sheet1weekList = "";	

//이미지 경로
var imageUrl1 = "http://" + location.hostname + ":" + location.port;
imageUrl1 = imageUrl1 + "/hanjin/apps/alps/ees/cim/cntroperationperformancemgt/eqmatchbacknloadfactormgt/image/EES_CIM_1061_01.gif";
												
var imageUrl2 = "http://" + location.hostname + ":" + location.port;
imageUrl2 = imageUrl2 + "/hanjin/apps/alps/ees/cim/cntroperationperformancemgt/eqmatchbacknloadfactormgt/image/EES_CIM_1061_02.gif";
		
var tpszList = new Array (	
	// 2012.12.04 신자영 [CHM-201221786-01] TP/SZ 추가 요청 - C2, C4, R8 추가
 	new Array("D2","D4","D5","D7"),
 	new Array("O2","S2","C2","O4","S4","C4","O5"),
	new Array("F2","A2","F4","A4","F5"),	
	new Array("R2","R5","R8","R9")
)		
		
// XTC 날짜입력이벤트 컨트롤 	
var enterSwitch = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
	var shtCnt   = 0;
	var sheet1   = sheetObjects[shtCnt++];
	var t1sheet1 = sheetObjects[shtCnt++];
	var t2sheet1 = sheetObjects[shtCnt++];

	/*******************************************************/
	var formObject = document.form;
	
	try {		
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {	
		case "btn_Retrieve":
			if (tabIndex == 0) {	
				doActionIBSheet(t1sheet1, formObject, IBSEARCH);
			} else if (tabIndex == 1) { 				
				doActionIBSheet(t2sheet1, formObject, IBROWSEARCH);			
			}	
			break;
					
		case "btn_new":		
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
			break;			

		case "btn_loc_cd": //Location 조회 팝업																			
			strUrl = "EES_CIM_1062.do";																										
			ComOpenWindow(strUrl,'eesCim1062','width=400,height=400,menubar=0,status=0,scrollbars=0,resizable=0,top=200,left=400');
			break;								
					
		case "btn_downexcel":
			if (tabIndex == 0) {		
				t1sheet1.Down2Excel(-1, false, false, true);
			} else if (tabIndex == 1) {
				t2sheet1.Down2Excel(-1, false, false, true);				
			} 
			break;
			
		case "btn_SaveFormat":			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
			break;		
			
		case "btn_RecallFormat":				
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
			break;			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert("지금은 사용하실 수가 없습니다 ");
		} else {
			alert(e);
		} // end if
	} // end try
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;

}

/** 
 * IBCombo Object를 배열로 등록
 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */ 
function setComboObject(combo_obj){      
	comboObjects[comboCnt++] = combo_obj;  
} 	     
			  
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	initControl();   
	
		
   //형식적 initSheet
	initSheet(sheetObjects[0],"HIDDEN");	
								
	ComConfigSheet(sheetObjects[1]);	
	initSheet(sheetObjects[1],"HIDDEN");	
	ComEndConfigSheet(sheetObjects[1]);		 
		
	ComConfigSheet(sheetObjects[2]);		
	initSheet(sheetObjects[2],"MBT");				
	ComEndConfigSheet(sheetObjects[2]);		
			
	// IBMultiCombo초기화 
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k + 1); 
    }
			        
	for(var k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k + 1);
    }
		
	//초기화
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}

/**   
 * Combo 기본 설정    
 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */     
function initCombo (comboObj, comboNo) {   
    //var cnt  = 0 ;	 
    var formObject = document.form;        
      
    switch(comboNo) {    
          case 1:			 		
		   with (comboObj) {	 
				MultiSelect = true; 
				UseAutoComplete = true;	
				SetColAlign("left");
				SetColWidth("100");  
				DropHeight = 200;
				ValidChar(2,3);   
		   }			 
		   break;	    
    }       
}  
	
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {		
			var cnt = 0;
			InsertTab(cnt++, "M/B Detail", 0);						
			InsertTab(cnt++, "M/B Trend ", -1);					
							
			t1sheet1Stats = true;		
			ImageUrl(0)= imageUrl1; 																
		}
		break;

	}
}
	
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetType) {			
	var cnt = 0;	
	var sheetID = sheetObj.id;	
					
	switch (sheetType) {	
				
	case "HIDDEN": 	
	    with (sheetObj) {
	        //Host정보 설정[필수][HostIp, Port, PagePath]
	        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		} 	
		break;
		
	case "MBD1": //t1sheet1 init		
		with (sheetObj) {
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly + msPrevColumnMerge;	 			
								
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;			
				
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 2, 1, 20, 100);		
						
			var formObj = document.form;
			
			//트레이드 리스트를 가져온다. 									
			var currTrade = formObj.trade_cd.Code;	
			currT1sheet1trade = formObj.trade_cd.Code;
			var currTradeList = currTrade.split(",");		
			if(currTrade == ""){	
				currTradeList.length = 0;	
			}	
													
			var arrTpszList;	
			//타입사이즈 리스트를 가져온다. 
			if(formObj.tpsz[0].checked){
				arrTpszList = tpszList[0];
			} else if(formObj.tpsz[1].checked){
				arrTpszList = tpszList[1];
			} else if(formObj.tpsz[2].checked){
				arrTpszList = tpszList[2];
			} else {	
				arrTpszList = tpszList[3];	
			}												
																
			var HeadTitle1 = "|Location|Division|Total";
			
			for ( var i = 0; i < currTradeList.length; i++) {
				for ( var j = 0; j < arrTpszList.length; j++) {
					HeadTitle1 += "|" + currTradeList[i];					
				}		
			}			
															
			var HeadTitle2 = "|Location|Division|Total";
			
			for ( var i = 0; i < currTradeList.length; i++) {
				for ( var j = 0; j < arrTpszList.length; j++) {
					HeadTitle2 += "|" + arrTpszList[j];					
				}		
			}		
														
			var headCount = 4 +  parseInt(currTradeList.length) * parseInt(arrTpszList.length);
				
			//전체 너비 설정									 	 	
			var size =	120 + 20 + (parseInt(currTradeList.length) * parseInt(arrTpszList.length) * 60);  	
			if (size > 975) {											
				SheetWidth = 975;									
			} else {
				SheetWidth = size;
			}		
										
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]	
			InitColumnInfo(headCount, 4, 0, true);  			
						
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D] 		
			InitHeadMode(false, true, true, true, false,false);	
										
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]			
            InitHeadRow(0, HeadTitle1, true);									
            InitHeadRow(1, HeadTitle2, true);											
							
			// 데이터속성 [ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]										
			InitDataProperty(0, cnt++ , dtHiddenStatus,	 	50,    	daCenter,  	true,   "ibflag"); 		
			InitDataProperty(0, cnt++, dtData, 				60, 	daCenter, 	true, 	"loc_cd", false, "", dfNone);		
			InitDataProperty(0, cnt++, dtData, 				70, 	daLeft, 	true, 	"div", false, "", dfNone);	 	
			InitDataProperty(0, cnt++, dtAutoSum, 			60, 	daRight, 	true, 	"qty0", false, "", dfNone);	
																						
			for ( var i = 0; i < currTradeList.length; i++) {	
				for ( var j = 0; j < arrTpszList.length; j++) {			
					InitDataProperty(0, cnt++, dtAutoSum, 60, daRight, false, "qty" + (i + 1) + "_" + (j + 1) , false, "", dfNone);				
				}																		
			}													
														
			MultiSelection = false;     
			SelectionMode = smSelectionRow;    
			SelectHighLight = false;												
			CountPosition = 0;	
			ColHidden("div") = true;	
			
		} // end with
		break;

	case "MBD2": //t1sheet1 init		
		with (sheetObj) {	
			//style.height = 385;
						
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly + msPrevColumnMerge;	 			
						
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;		
					
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 2, 4, 20, 100);							
															
			var formObj = document.form;
			
			//트레이드 리스트를 가져온다. 									
			var currTrade = formObj.trade_cd.Code;	
			currT1sheet1trade = formObj.trade_cd.Code;					
			var currTradeList = currTrade.split(",");		
			if(currTrade == ""){	
				currTradeList.length = 0;
			}	
																				
			var arrTpszList;	
			//타입사이즈 리스트를 가져온다. 
			if(formObj.tpsz[0].checked){				
				arrTpszList = tpszList[0];	
			} else if(formObj.tpsz[1].checked){
				arrTpszList = tpszList[1];
			} else if(formObj.tpsz[2].checked){
				arrTpszList = tpszList[2];
			} else {	
				arrTpszList = tpszList[3];	
			}		
												
			var HeadTitle1 = "|Location|Division|Total";
			
			for ( var i = 0; i < currTradeList.length; i++) {
				for ( var j = 0; j < arrTpszList.length; j++) {
					HeadTitle1 += "|" + currTradeList[i];					
				}		
			}			
															
			var HeadTitle2 = "|Location|Division|Total";
			
			for ( var i = 0; i < currTradeList.length; i++) {
				for ( var j = 0; j < arrTpszList.length; j++) {
					HeadTitle2 += "|" + arrTpszList[j];					
				}		
			}		
														
			var headCount = 4 +  parseInt(currTradeList.length) * parseInt(arrTpszList.length);
				
			//전체 너비 설정							 	 	
			var size =	210 + 20 + (parseInt(currTradeList.length) * parseInt(arrTpszList.length) * 60);  	
			if (size > 975) {													
				SheetWidth = 975;									
			} else {	
				SheetWidth = size;
			}	
						
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]	
			InitColumnInfo(headCount, 4, 0, true);  			
						
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D] 		
			InitHeadMode(false, true, true, true, false,false);	
										
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]			
            InitHeadRow(0, HeadTitle1, true);									
            InitHeadRow(1, HeadTitle2, true);											
						
			var RowCnt = 0;	
								
			for ( var RowCnt = 0; RowCnt < 4; RowCnt++) {
				var cnt = 0;		
				// 데이터속성 [ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]										
				InitDataProperty(RowCnt, cnt++ , dtHiddenStatus,	 	50,    	daCenter,  	true,  "ibflag"); 		
				InitDataProperty(RowCnt, cnt++, dtData, 				80, 	daCenter, 	true, 	"loc_cd", false, "", dfNone);		
				InitDataProperty(RowCnt, cnt++, dtData, 				70, 	daLeft, 	true, 	"div", false, "", dfNone);	 	
				InitDataProperty(RowCnt, cnt++, dtAutoSum, 			60, 	daRight, 	true, 	"qty0", false, "", dfNone);	
				
				for ( var i = 0; i < currTradeList.length; i++) {			
					for ( var j = 0; j < arrTpszList.length; j++) {				
						InitDataProperty(RowCnt, cnt++, dtAutoSum, 60, daRight, false, "qty" + (i + 1) + "_" + (j + 1) , false, "", dfNone);				
					}																	
				}			
			}								
																						
			MultiSelection = false;     
			SelectionMode = smSelectionRow;    
			SelectHighLight = false;												
			CountPosition = 0;		
			ColHidden("div") = false;			
		} // end with
		break;	
					
	case "MBT": //t2sheet1 init	
		with (sheetObj) {					
			// 높이 설정	
			var formObj = document.form;
							
			var HeadTitle1 = "|Location|TP/SZ|Division|Total";	
			var HeadTitle2 = "|Location|TP/SZ|Division|Total";
			
			//초기화 하기위해 쉬트 세팅시 상태 저장
			currT2sheet1weekList = formObj.week_list.value;
			currT2sheet1Period = formObj.period.value;	
			 		
			var weekList = formObj.week_list.value;  
												
			var currWeekList = weekList.split(",");	
			if(weekList == ""){	
				currWeekList.length = 0;	
			}	
			//데이타 리셋여부를 위해 저장해놓음
			currT2sheet1trade = formObj.trade_cd.Code;	
													
			for ( var i = 0; i < currWeekList.length; i++) {
				HeadTitle1 += "|" + formObj.trade_cd.Code;
				HeadTitle2 += "|" + currWeekList[i];	
			}						
									
			//전체 너비 설정						 	 	
			var size =	250 + 20 + 20 + (parseInt(currWeekList.length) * 60);  	
			if (size > 975) {														
				SheetWidth = 975;											
			} else {
				SheetWidth = size;
			}																									 	 		
								  	 						
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;			 			
															
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;				
								
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 4, 20, 100);									
																		
			var headCount = 5 +  parseInt(currWeekList.length);
			//[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D] 		
			InitHeadMode(false, true, false, false, false,false);		
						 						 	 				
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]	
			InitColumnInfo(headCount, 4, 0, true); 		
									
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]			
            InitHeadRow(0, HeadTitle1, true);										
            InitHeadRow(1, HeadTitle2, true); 
																							
			for ( var RowCnt = 0; RowCnt < 4; RowCnt++) {						
				var cnt = 0;								
				// 데이터속성 [ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]										
				InitDataProperty(RowCnt, cnt++ , dtHiddenStatus,	 	50,    	daCenter,  	true,  "ibflag"); 		
				InitDataProperty(RowCnt, cnt++, dtData, 				80, 	daCenter, 	true, 	"loc_cd", false, "", dfNone);		
				InitDataProperty(RowCnt, cnt++, dtData, 				40, 	daCenter, 	true, 	"tpsz", false, "", dfNone);	 	
				InitDataProperty(RowCnt, cnt++, dtData, 				90, 	daLeft, 	true, 	"div", false, "", dfNone);	
				InitDataProperty(RowCnt, cnt++, dtAutoSum, 				60, 	daRight, 	true, 	"qty0", false, "", dfNone);	
																														
				for ( var i = 0; i < currWeekList.length; i++) {	
					InitDataProperty(RowCnt, cnt++, dtAutoSum, 60, daRight, false, "qty" + (i + 1), false, "", dfNone);				
				}															
			}																												
			MultiSelection = false;	     
			SelectionMode = smSelectionRow;  	  
			SelectHighLight = false;													
			CountPosition = 0;		
		} // end with
		break;	
	} // end switch
} // end function

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: //조회 MBD
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);		
			formObj.f_cmd.value = SEARCH;			
			var sXml = sheetObj.GetSearchXml("EES_CIM_1061GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);		
			ComOpenWait(false);					
			sheetObj.WaitImageVisible = true;						
		}				
		break;
		
	case IBROWSEARCH: //조회 MBT
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);				
			formObj.f_cmd.value = SEARCH01;					
			var sXml = sheetObj.GetSearchXml("EES_CIM_10612GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);						
			ComOpenWait(false);					
			sheetObj.WaitImageVisible = true;									
		}					
		break;	
			
	case IBSEARCH_ASYNC01: //기간 변화에 따른 시트 변형
			formObj.f_cmd.value = COMMAND01;											
			var sXml = sheetObj.GetSearchXml("EES_CIM_10611GS.do", FormQueryString(formObj));
			var weekStr = ComGetEtcData(sXml, "PERIOD_LIST");
			formObj.week_list.value = weekStr;													
		break;	
				
	case IBSEARCH_ASYNC02: //SAVE FORMAT
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;
			formObj.f_cmd.value = COMMAND04;	
			var sXml = sheetObj.GetSaveXml("EES_CIM_10611GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;	
			
			if(CimComGetErrMsg(sXml) == null){			
				ComShowCodeMessage("CIM30019");		
			}												
		}		 
		break;			
		
	case IBSEARCH_ASYNC03: //RECALL FORMAT	
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.WaitImageVisible = false;			
			formObj.f_cmd.value = COMMAND05;				
			var sXml = sheetObj.GetSearchXml("EES_CIM_10611GS.do", FormQueryString(formObj));
			sheetObj.WaitImageVisible = true;
			
			var cntrTpszLvl = ComGetEtcData(sXml, "CNTR_TPSZ_LVL");	
			var rfLvl 		= ComGetEtcData(sXml, "RF_LVL");	
			var trdNm 		= ComGetEtcData(sXml, "TRD_NM");	
			var socLvl 		= ComGetEtcData(sXml, "SOC_LVL");	
					
			//초기화 
			formObj.reset();		
			for(var i = 0; i < sheetObjects.length;i++){ 
				sheetObjects[i].Code = "-1";				 		
				sheetObjects[i].RemoveAll(); 		
			} 
							
			//조회 해온 포멧을 맞게 세팅한다.
			//rdtype 세팅	
			var optcnt = formObj.rdtype.options.length; 	
			for(var i = 0 ; i < optcnt; i++){			 	
				if(formObj.rdtype.options[i].value == rfLvl) { 
					formObj.rdtype.options[i].selected = true;	 	
					break;			 	
				}			
			}		
								
			//SOC 세팅			
			var optcnt = formObj.soc.options.length; 
			for(var i =0 ; i < optcnt; i++){	 	
				if(formObj.soc.options[i].value == socLvl) { 
					formObj.soc.options[i].selected = true;	 	
					break; 
				}		
			}	
			
			//TPSZ 세팅	
			var optcnt = formObj.tpsz.length; 
			for(var i =0 ; i < optcnt; i++){	 	
				if(formObj.tpsz[i].value == cntrTpszLvl) { 
					formObj.tpsz[i].checked = true;	 	
					break;	 
				}				
			}							
						
			//탭초기화
			tabObjects[0].SelectedIndex = 0;	
			tabObjects[0].ImageUrl(0)= imageUrl1;
			t1sheet1Stats = true;
			beforetabForClick = 0;		
						
			//Trade 세팅	
			formObj.trade_cd.MultiSelect = true;
			formObj.trade_cd.Code = trdNm;
			document.form.transmode.value = trdNm;   
												
			sheetObjects[1].Reset();			
			var sheetType = "MBD1";		
			initSheet(sheetObjects[1],sheetType);	
									
			//Tpsz 값 세팅	
			var arrTpszList;		
			//타입사이즈 리스트를 가져온다. 
			if(formObj.tpsz[0].checked){	
				arrTpszList = tpszList[0];
				formObj.rdtype.disabled = true;	
			} else if(formObj.tpsz[1].checked){
				arrTpszList = tpszList[1];
				formObj.rdtype.disabled = true;	
			} else if(formObj.tpsz[2].checked){
				arrTpszList = tpszList[2];
				formObj.rdtype.disabled = true;	
			} else {	
				arrTpszList = tpszList[3];	
				formObj.rdtype.disabled = false;
			}	
										
			var tpszListStr = "";
			for(var i = 0; i < arrTpszList.length;i++){ 
				tpszListStr += arrTpszList[i] + ",";		
			}	
			tpszListStr = CimDelLastDelim(tpszListStr);			
			formObj.tpsz_list.value = tpszListStr;	
		}		
		break;	
		
	case IBCLEAR: //초기화	
		var formObj = document.form;
						
		formObj.reset();	
		
		//탭초기화
		tabObjects[0].SelectedIndex = 0;	
		tabObjects[0].ImageUrl(0)= imageUrl1;
		t1sheet1Stats = true;
		beforetabForClick = 0;  
					
		for(var i = 0; i < sheetObjects.length;i++){ 
			sheetObjects[i].Code = "-1";				 		
			sheetObjects[i].RemoveAll(); 		
		} 
		
		for(var i = 0; i < comboObjects.length;i++){ 
			comboObjects[i].Code = "-1"; 
			comboObjects[i].RemoveAll(); 	
		} 	
								
		//코드화 하여 조회 하여야 하나 CIM 에 기반 사항이 없음
		var tradeCdList = new Array (
			 "TPS"	
			,"AES"
			,"TAS"
			,"IAS"
			,"EMS"
			,"IES"
			,"IMS"			
		);				
									
		//디폴트로 올삽입			  
		formObj.trade_cd.InsertItem(0,"ALL","ALL");  		
		for(var i = 1;i < (tradeCdList.length + 1);i++){	
			formObj.trade_cd.InsertItem(i,tradeCdList[i - 1], tradeCdList[i - 1]); 				
		}						
			
		document.form.transmode.value = "ALL";																										
		formObj.trade_cd.Code = "ALL";																		
		formObj.tpsz_list.value = "D2,D4,D5,D7";
		formObj.tpsz[0].checked = true;
		formObj.rdtype.disabled = true;	
		
		/**
		 * Location 초기화 퍼포먼스때문에 N처리함	 	
		 * 최신 Location이 지속적으로 반영되어야 한다면 쿼리를 DELETE로 변경
		 */			
		var formObj = document.form;
		sheetObj.WaitImageVisible = false;			
		formObj.f_cmd.value = COMMAND02;							
		var sXml = sheetObj.GetSearchXml("EES_CIM_10611GS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible = true;  
			
		ComSetFocus(formObj.froms);	
		break;				
	}			
}		

function getCurrSelectedLOC (){	
	formObj = document.form;	
	formObj.f_cmd.value = COMMAND03;		
	var sXml = sheetObjects[0].GetSearchXml("EES_CIM_10611GS.do", FormQueryString(formObj));
							
	return ComGetEtcData(sXml, "LOCATION_CNT");	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH || sAction == IBROWSEARCH) {
			if(sAction == IBSEARCH){
				if(trade_cd.Code == ""){
					ComShowCodeMessage("CIM21001", "Trade ");
					ComSetFocus(trade_cd);							
					return false;						
				}			
			}			
			
			if(sAction == IBROWSEARCH){	
				if(week_list.value == "" && froms.value != ""){
					ComShowCodeMessage("CIM30023");			
					ComSetObjValue(froms,"");					
					ComSetObjValue(tos,"");							
					ComSetFocus(froms);													
					return false;						
				}			
			}			
					
			if (period.value == "M") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(tos);
					return false;
				}
			} else if (period.value == "W") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);	
					return false;	
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(tos);	
					return false;
				}
			}
			
			if (froms.value.length < 6) {
				return false;
			} else if (tos.value.length < 6) {
				return false;
			}
				
			if (!enterSwitch) {
				return false;
			}
				
			//로케이션 선택여부 
			var currSelectedLOC = getCurrSelectedLOC();
			if(currSelectedLOC == "0"){	
				ComShowCodeMessage("CIM21001", "Location ");
							
				strUrl = "EES_CIM_1062.do";																													
				ComOpenWindow(strUrl,'eesCim1062','width=400,height=400,menubar=0,status=0,scrollbars=0,resizable=0,top=200,left=400');		
				return false;			
			}	
		}			
	}
	return true;
}

//trade_cd 멀티콤보 클릭 이벤트
function trade_cd_OnCheckClick(comboObj, index, Index_Code) {
	
	var preSelectMode = document.form.transmode.value;	
	//alert(preSelectMode);						         
	//alert(index);						
																		
	if (preSelectMode.indexOf("ALL") == -1 && index == 0) {														
		comboObj.Code = "ALL";
	} else if(preSelectMode == "ALL" && index == 0) {							
		comboObj.Code = "";				
	} else if((preSelectMode == "ALL" || preSelectMode == "") && index != 0) {				
		comboObj.Code = Index_Code;												 		
	}						
}	
		
/**  
 * trade_cd Change 이벤트      
 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
 * @param  {String}    Index_Code   Index 나 코드
 * @param  {String}    Text   텍스트
 */  
function trade_cd_OnChange(comboObj,Index_Code, Text){	
	document.form.transmode.value = comboObj.Code;		
		
	if (tabIndex == 0) {
		sheetObjects[1].Reset();	
												
		var sheetType = "";			
		if(t1sheet1Stats){	
			sheetType = "MBD1";
		} else {	
			sheetType = "MBD2";	
		}			
		initSheet(sheetObjects[1],sheetType);	
	} else if (tabIndex == 1) {		
		if(document.form.froms.value != "" && document.form.tos.value != ""){			
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
			sheetObjects[2].Reset();										
			initSheet(sheetObjects[2],"MBT");									
		}															
	}	
}
	
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	//------------------------------------------------------//
	beforetab = nItem;	
	tabIndex = nItem;	
}	
	
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnClick(tabObj, nItem) {
	formObj = document.form;
	var priCode = formObj.trade_cd.Code;
	if (nItem == 0) {			
		//콤보의 세팅 바꿈
		formObj.trade_cd.MultiSelect = true;		
																					
		if(beforetabForClick == nItem){	
			if(t1sheet1Stats){	
				t1sheet1Stats = false;	
				formObj.work_type.value = "MBD2";
				sheetObjects[1].Reset();			
				initSheet(sheetObjects[1],formObj.work_type.value);		
				tabObj.ImageUrl(0)= imageUrl2;		
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
			} else {	 		
				t1sheet1Stats = true; 	
				formObj.work_type.value = "MBD1"; 		  
				sheetObjects[1].Reset();										
				initSheet(sheetObjects[1],formObj.work_type.value);		
				tabObj.ImageUrl(0)= imageUrl1;				
				doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);								 		
			}					 			
		} else {
			formObj.trade_cd.Code2 = priCode;			
			document.form.transmode.value = priCode;	
					
			var sheetType = "";	
			if(t1sheet1Stats){			
				sheetType = "MBD1";	
				formObj.work_type.value = "MBD1";	
			} else {
				sheetType = "MBD2";	
				formObj.work_type.value = "MBD2";	
			}	
											
			if(currT1sheet1trade != formObj.trade_cd.Code){
				sheetObjects[1].Reset();								
				initSheet(sheetObjects[1],sheetType);							
			}	
		}			
	} else if (nItem == 1) {
		formObj.work_type.value = "MBT";		
		//콤보의 세팅 바꿈
		formObj.trade_cd.MultiSelect = false;	
									
		if(priCode == "ALL" || priCode == ""){									
			formObj.trade_cd.Code2 = "ALL";		
			document.form.transmode.value = "ALL";			
		} else {								
			if(priCode.length == 3){		
				formObj.trade_cd.Code2 = priCode;	
				document.form.transmode.value = priCode;			
			} else {		
				formObj.trade_cd.Code = "ALL";				
				document.form.transmode.value = "ALL";	
			}							
		}				
																												
		if((currT2sheet1trade != formObj.trade_cd.Code) || (currT2sheet1weekList != formObj.week_list.value) || (currT2sheet1Period != formObj.period.value)){	
			if(chkToDateWeekBlurFORTAB()){	
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
				sheetObjects[2].Reset();		
				initSheet(sheetObjects[2],"MBT");					
				if(sheetObjects[2].RowCount == 0){	
					doActionIBSheet(sheetObjects[2], formObj, IBROWSEARCH);	
				}							
			}			
		} else {	
			chkToDateWeekBlurFORTAB();		
		}											
	}							
	beforetabForClick = nItem;	
}
			
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		//MBD1	
		if(formObj.work_type.value == "MBD1"){	
			if(RowCount > 0){		
				var totalRow = LastRow - 1;
										
				if(RowHidden(totalRow) == true){
					for(j = 0;j <= LastCol; j++) {																
						SumText(0,j) = CellValue(totalRow,j);	
						CellFontColor(LastRow,j) = CellFontColor(totalRow,j);
					}												
				}			
			}			 	
		//MBD2					
		} else {	
			var sumRow = 0;	
			if(RowCount > 0){							
				for(i = (LastRow - 7) ;i <= (LastRow - 4); i++) {				
					if(RowHidden(i) == true){		
						for(j = 0;j <= LastCol; j++) {																	
							SumText(sumRow,j) = CellValue(i,j);						
							CellFontColor(LastRow - 3 + sumRow,j) = CellFontColor(i,j);		
						}															
						sumRow++;						
					}				
				}	
				SetMergeCell((LastRow - 3), 1, 4, 1);							
			}						
		}			
	}
}	

function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var sumRow = 0;	
		for ( var x = 0; x < LastRow; x++) {
			if (CellValue(x, 1) == "ZZZZZ") {
				CellValue(x, 1) = "BY" + "\nCNTR TP/SZ";
				RowBackColor(x) = RgbColor(153, 204, 255);
				if(CellValue(x, 2) == "Total") {
					RowHidden(x) = true;
				}
			}
		}
		
		if(RowCount > 0){								
			for(i = (LastRow - 7) ;i <= (LastRow - 4); i++) {				
				if(RowHidden(i) == true){		
					for(j = 0;j <= LastCol; j++) {																	
						SumText(sumRow,j) = CellValue(i,j);						
						CellFontColor(LastRow - 3 + sumRow,j) = CellFontColor(i,j);		
					}																	
					sumRow++;							
				}					
			}	
			SetMergeCell((LastRow - 3), 1, 4, 1);								
		}								
	}
}
	
function lastDay(y, m) {
	var d, d2, s = "";
	d = new Date();
	d2 = new Date(y, m, "");
	s = d2.getDate();
	return (s);
}

function chkToDateWeekBlur() {
	var period = document.form.period.value;
	var toDate = document.form.tos.value;
	var frDate = document.form.froms.value;

	var toYearDate = toDate.substring(0, 4);
	var frYearDate = frDate.substring(0, 4);
	var toMonthDate = toDate.substring(5, 7);
	var frMonthDate = frDate.substring(5, 7);
	var frDayDate = "";
	var toDayDate = "";
			
	if (frDate.length > 7) {	
		frDayDate = frDate.substring(8, 10);
		toDayDate = toDate.substring(8, 10);
	} else {		
		frDayDate = "01";
		toDayDate = lastDay(toYearDate, toMonthDate);
	}
	
	var frDateFull = new Date(frYearDate, frMonthDate - 1, frDayDate);
	var toDateFull = new Date(toYearDate, toMonthDate - 1, toDayDate);
	var getDiffTime = toDateFull.getTime() - frDateFull.getTime();
	var retDate = Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
	var retMonth = ((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
	var retWeek = Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
	var week = "";
	var fromTo = 52;
	
	
	var checkWeek = 0;
	var weekErrMsg = "";
	if(tabObjects[0].SelectedIndex == 0){
		checkWeek = 52;	
		weekErrMsg = "CIM21032";					
	} else {
		checkWeek = 26;	
		weekErrMsg = "CIM21031";			
	}
		
					
	if (period == "M") {	
		if (retMonth >= 12) {
			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week = eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {
			betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { //1년 차이일때
				week = betwMonth;
			} else {
				week = (eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}
		
		if (week > checkWeek) {		
			if (event.srcElement.name == "tos") {			
				ComShowCodeMessage(weekErrMsg);	
				ComSetFocus(document.getElementById("tos"));		
			}
			return false;
		}	
	}
}

function chkToDateWeekBlurFORTAB() {	
	var period = document.form.period.value;
	var toDate = document.form.tos.value;
	var frDate = document.form.froms.value;

	var toYearDate = toDate.substring(0, 4);
	var frYearDate = frDate.substring(0, 4);
	var toMonthDate = toDate.substring(5, 7);
	var frMonthDate = frDate.substring(5, 7);
	var frDayDate = "";
	var toDayDate = "";
			
	if (frDate.length > 7) {	
		frDayDate = frDate.substring(8, 10);
		toDayDate = toDate.substring(8, 10);
	} else {		
		frDayDate = "01";
		toDayDate = lastDay(toYearDate, toMonthDate);
	}
		
	var frDateFull = new Date(frYearDate, frMonthDate - 1, frDayDate);
	var toDateFull = new Date(toYearDate, toMonthDate - 1, toDayDate);
	var getDiffTime = toDateFull.getTime() - frDateFull.getTime();
	var retDate = Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
	var retMonth = ((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
	var retWeek = Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
	var week = "";
	var fromTo = 52;
				
	var checkWeek = 0;	
	var weekErrMsg = "";
	if(tabObjects[0].SelectedIndex == 0){
		checkWeek = 52;	
		weekErrMsg = "CIM21032";					
	} else {
		checkWeek = 26;	
		weekErrMsg = "CIM21031";			
	}
						
	if (period == "M") {	
		if (retMonth >= 12) {
			if (event.srcElement.name == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}	
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week = eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {	
			betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { //1년 차이일때
				week = betwMonth;
			} else {			
				week = (eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}						
		}					
																	
		if (week > checkWeek) {			
			if(document.form.froms.value != "" && document.form.tos.value != ""){			
				ComShowCodeMessage(weekErrMsg);	
				ComSetObjValue(document.getElementById("tos"),"");		       			
				ComSetFocus(document.getElementById("tos"));					
			}				
			return false;
		}		
	}
	return true;
}

function initControl() {  
    //Axon 이벤트 처리1. 이벤트catch  
    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	axon_event.addListenerForm(	 'click', 'obj_click', form);
	axon_event.addListenerForm(	 'change', 'obj_change', form);
	axon_event.addListenerFormat('keyup', 'obj_keyup', form);			
	axon_event.addListener('keydown', 'ComKeyEnter2', form);	
}		 	             
			   
//Axon 이벤트 처리2. 이벤트처리함수
function obj_deactivate() {	
	
}
	
function obj_activate(){ 	  
    ComClearSeparator(event.srcElement);
}       
	    	
function obj_click() {
	formObj = document.form;
			
	obj = event.srcElement;
	if (obj.name == "tpsz") { // TP/SZ 종류에 따라
		if (obj.value != "R") {
			formObj.rdtype.disabled = true;
		} else {	
			document.form.rdtype.value = "I";	
			formObj.rdtype.disabled = false;
		}			
							
		sheetObjects[1].Reset();
								
		var sheetType = "";			
		if(t1sheet1Stats){	
			sheetType = "MBD1";
		} else {
			sheetType = "MBD2";	
		}		
																										
		initSheet(sheetObjects[1],sheetType);	
		sheetObjects[1].Redraw = true;     				
		//Tpsz 값 세팅
		var arrTpszList;	
		//타입사이즈 리스트를 가져온다. 
		if(formObj.tpsz[0].checked){	
			arrTpszList = tpszList[0];
		} else if(formObj.tpsz[1].checked){
			arrTpszList = tpszList[1];
		} else if(formObj.tpsz[2].checked){
			arrTpszList = tpszList[2];
		} else {	
			arrTpszList = tpszList[3];	
		}		
									
		var tpszListStr = "";
		for(var i = 0; i < arrTpszList.length;i++){ 
			tpszListStr += arrTpszList[i] + ",";		
		}	
		tpszListStr = CimDelLastDelim(tpszListStr);			
		formObj.tpsz_list.value = tpszListStr;	
	}	
}	
		
function obj_keypress(){   	
   switch (event.srcElement.name) {
	case "location":
		ComKeyOnlyAlphabet('upper');// 알파벳 대문자만 입력허용
		break;
	case "froms":	
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "tos":
		// 숫자만 + "-"만 입력허용
		ComKeyOnlyNumber(event.srcElement);
		break;		
	}		 
}	

function obj_keyup() {	
	var obj = event.srcElement;
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {	
		ComKeyEnter2('lengthnextfocus');
	} else {	
		obj_deactivate();	
	}
}

function obj_change() {			
	obj = event.srcElement;
	if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
			document.form.froms.value = "";
			document.form.tos.value = "";
			document.form.from_dt.value = "";
			document.form.to_dt.value = "";
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.form.froms.value = "";	
			document.form.tos.value = "";
			document.form.from_dt.value = "";
			document.form.to_dt.value = "";
		}	
		document.getElementById("froms").focus();
	}
	
	var f = document.getElementById("froms");
	var t = document.getElementById("tos");
	sVal1 = f.value.replace(/\/|\-|\./g, "");
	sVal2 = t.value.replace(/\/|\-|\./g, "");

	switch (event.srcElement.name) {
	case "froms":
		if (ComChkObjValid(event.srcElement, false)) {

			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1 != "" && sVal2 != "") {
					var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						//ComShowCodeMessage("CIM29004");
						enterSwitch = false;
						t.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from_dt").value = sVal1 + "01";
					document.getElementById("to_dt").value = sVal2 + day;
				}	

			} else { // 주별로 조회
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch = false;
						t.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from_dt").value = sVal1;
					document.getElementById("to_dt").value = sVal2;
				}
			}

		} else {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {

					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch = false;
					event.srcElement.focus();
					event.srcElement.select();
					return false;
				}
			} else { // 주별로 조회

				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					event.srcElement.focus();
					event.srcElement.select();
					enterSwitch = false;

					return false;
				}
			}
		}

		break;
	case "tos":
		if (ComChkObjValid(event.srcElement, false)) {

			if (t.getAttribute("dataformat") == "ym") {

				var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));

				if (sVal1 != "" && sVal2 != "") {
					var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29004");
						}
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
				}

				document.getElementById("from_dt").value = sVal1 + "01";
				document.getElementById("to_dt").value = sVal2 + day;
			} else { // 주별로 조회
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						if (event.srcElement.name == "tos") {
							ComShowCodeMessage("CIM29003");
						}
						enterSwitch = false;
						event.srcElement.value = "";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("from_dt").value = sVal1;
				document.getElementById("to_dt").value = sVal2;
			}	
			enterSwitch = true;
		} else {	
			if (t.getAttribute("dataformat") == "ym") {
				if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					t.focus();
					t.select();
					return false;
				}
			} else { // 주별로 조회
				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch = false;
					event.srcElement.value = "";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					t.focus();
					t.select();
					return false;
				}
			}
		}

		break;
	}
		
	//주차 변환	
	if(event.srcElement.name == "froms" || event.srcElement.name == "tos"){
		if(document.form.froms.value != "" && document.form.tos.value != ""){										
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);	
			if(tabIndex == 1){
				sheetObjects[2].Reset();		
				initSheet(sheetObjects[2],"MBT");	
			}													
		}								 														
	}			
	return true;	 
}

function ComKeyEnter2(sFlag) {
	try {
		var keyValue = null;
		if (event == undefined || event == null) {
			keyValue = 13;
		} else
			keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (sFlag == undefined || sFlag == null || sFlag.constructor != String || sFlag.trim() == "")
			sFlag = "search";

		switch (sFlag.toLowerCase()) {
		case "search":
			//Enter키를 누르면 조회버튼을 눌린것 처럼 처리
			if (keyValue != 13)
				return;
			var obj = document.getElementById("btn_Retrieve");
			if (obj == null)
				obj = document.getElementById("btn_retrieve");
			if (obj)
				obj.fireEvent("onclick");
			break;

		case "nextfocus":
			//Enter키를 누르면 Tab키를 누른것 처럼 처리
			if (keyValue == 13)
				event.keyCode = 9;
			break;

		case "lengthnextfocus":
			//입력필드는 maxlength만큼 모두 입력하면 Enter키를 누르지 않아도 자동이동하고,
			//그외의 경우 Enter키를 누르면 Tab키를 누른것 처럼 처리
			var iMaxLen = event.srcElement.getAttribute("maxLength");
			var sValue = event.srcElement.getAttribute("value");
			var bFocusProcess = false;

			//Enter키를 눌렀을 때
			if (keyValue == 13) {
				//Enter키를 누른것이 IBSheet가 아닌 경우만 처리한다.
				if (event.srcElement.classid != CLSID_IBSHEET) {
					bFocusProcess = true;
				}
				//iMaxLen 속성이 없거나 Value 속성이 없는것들은 처리하지 않는다.
			} else if (iMaxLen != null && sValue != null) {
				//ComDebug(iMaxLen+"=="+sValue.lengthByte());

				if (iMaxLen == sValue.lengthByte()) {
					//if(!((keyValue==37)||(keyValue==39)||(keyValue==46)||(keyValue==8)||(keyValue==9))){
					//참고:http://cdmanii.tistory.com/153
					if (!((keyValue >= 8 && keyValue <= 40) || //BackSpace~아래방향키키
							(keyValue >= 45 && keyValue <= 46) || //Insert,Delete키
							(keyValue >= 91 && keyValue <= 93) || //기능키
							(keyValue >= 112 && keyValue <= 123) || //F1~F12키
					(keyValue >= 144 && keyValue <= 145))) {//NumLock,ScrollLock

						bFocusProcess = true;
					}
				}
			}

			//포커스를 다음 컨트롤로 옮기는 처리를 해야 하는 경우
			if (bFocusProcess)
				ComSetNextFocus();

		default:
			//Enter키를 누르면 sFlag 명의 자바스크립트 함수를 호출 한다.
			if (keyValue == 13 && ComFuncCheck(sFlag))
				ComFunc();

		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}
