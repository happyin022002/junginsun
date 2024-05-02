/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1049.js
*@FileTitle : Unmatch Details
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.05 김대호
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview Unmatch Details 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESM_BKG_1049:ESM_BKG_1049 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1049() {
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.processButtonClick		= processButtonClick;
	this.doActionIBSheet 		= doActionIBSheet;
}
    
//===================================================================================
//전역변수
//===================================================================================
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1;
//업무전역변수
//===================================================================================
//페이지 초기화
//===================================================================================
/** 
* IBSheet Object를 sheetObjects 배열로 등록 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : IBSheet Object
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.05
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
* body 태그의 onLoad 이벤트핸들러 구현 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.05
*/ 
function loadPage() {
	
    //IBSheet 초기화
    sheet1 = sheetObjects[0];
    sheetCnt = sheetObjects.length;
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
    }
    
    sheet1.WaitImageVisible = false;
    
    doActionIBSheet(sheet1, form, IBSEARCH);
    
}

/** 
* sheet1_OnLoadFinish 이벤트핸들러 구현 <br>
* IBSheet를 초기화 한후에 선처리해야 하는 기능을 추가한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.12
*/
/*
function sheet1_OnLoadFinish(sheetObj) {
	var form = document.form;	

}
*/

/** 
* Sheet 기본 설정 및 초기화 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {sheetObj} sheetObj : 시트오브젝트
* @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.05
*/ 
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	var sheetID = sheetObj.id;
   
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
		            //높이 설정
		            style.height = 530;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 3, 100);
		            var HeadTitle1 = "Error\nKind|Description|Booking|Contract|mtch_umch_tp_cd|mtch_umch_tp_desc";
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
                   
//데이터속성         ROW ,COL   ,DATATYPE     ,WIDTH  ,DATAALIGN   ,COLMERGE  ,SAVENAME            ,KEYFIELD,CALCULOGIC,DATAFORMAT       ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtData       ,45     ,daCenter	 ,false     ,"umch_tp_cd"  	     ,false ,""          ,dfNone           ,0);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,130    ,daCenter    ,false     ,"umch_tp_nm" 	     ,false ,""          ,dfNone           ,0);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,385    ,daLeft      ,false     ,"bkg_itm_log"   	 ,false ,""          ,dfNone           ,0);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,385    ,daLeft      ,false     ,"ctrt_itm_log"  	 ,false ,""          ,dfNone           ,0);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtHidden     ,80     ,daCenter    ,false     ,"mtch_umch_tp_cd"   ,false ,""          ,dfNone           ,0);    
InitDataProperty(0 ,cnt++ ,dtHidden     ,80     ,daCenter    ,false     ,"mtch_umch_tp_desc" ,false ,""          ,dfNone           ,0);    

					//AutoRowHeight = false;
					//WordWrap = true;
					Ellipsis = true;
	        		ToolTipOption = "balloon:true;width:600;icon:0";					

	        }
	      	break;
	}
}

//===================================================================================
//버튼 이벤트 처리
//===================================================================================
document.onclick = processButtonClick;

/** 
* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.05
*/ 
function processButtonClick(){
	var form = document.form;
    try {
	    var srcName = window.event.srcElement.getAttribute("name");
	    switch(srcName) {
	    	case "btn_retrieve":
	    		doActionIBSheet(sheet1, form, IBSEARCH);
	    		break;
	    		
	    	case "btn_close":
	    		window.close();
	    		break;
	    		
	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
 		}
 	}
}

//===================================================================================
//Axson Event Handler
//===================================================================================

//===================================================================================
//UI Object Event Handler
//===================================================================================
/** 
* sheet1 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2009.11.27
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var form = document.form;
	//sheet1.FitSize(true, false);
	sheet1.SheetFontName = "Arial";
	sheet1.ColFontColor("bkg_itm_log") = sheet1.RgbColor(255, 0, 0);
	if (errMsg == "") {
    	if(sheet1.RowCount > 0) {
    		
    		var cellFont = "Courier New";
    		var cellFontSize = 8;
    	    var startRow = sheet1.HeaderRows;
    		var endRow = sheet1.HeaderRows + sheet1.RowCount;
    		var tmpStr = "";
    		
    		for(var i = startRow; i < endRow; i++) {
    			
    			sheet1.RowHeight(i) = 0;
    			
    			tmpStr = "";
    			tmpStr = sheet1.CellValue(i, "bkg_itm_log") + "\n";
    			sheet1.CellValue(i, "bkg_itm_log") = tmpStr;     			
    			
    			tmpStr = "";
    			tmpStr = sheet1.CellValue(i, "ctrt_itm_log") + "\n";
    			sheet1.CellValue(i, "ctrt_itm_log") = tmpStr;     			
    			
    			sheet1.CellFont("FontName", i, "bkg_itm_log") = cellFont;
    			sheet1.CellFont("FontName", i, "ctrt_itm_log" ) = cellFont;
    			sheet1.CellFont("FontSize", i, "bkg_itm_log") = cellFontSize;
    			sheet1.CellFont("FontSize", i, "ctrt_itm_log") = cellFontSize;
    			
    		}
    		
    	}

    }
}   

/** 
* sheet1 셀을 마우스 선택시 발생하는 sheet1_OnClick 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {IBSheet} Row : 변경된 행 정보
* @param  {IBSheet} Col : 변경된 컬럼정보
* @param  {IBSheet} Value : 변경된 값
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.12
*/ 
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	//desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	var colName = sheet1.ColSaveName(Col);
	switch (colName) {
	case "bkg_itm_log":
	case "ctrt_itm_log":
		//ComShowMemoPad(sheet1,null,null,null,200,180,500);
		break;
	}
}

/**
* desccription, Booking, Contract 을 풍선도움말로 보여주기 위해 도움말을 생성한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.14
*/
function setToolTip (sheetObj) {
	var startRow = sheet1.HeaderRows;
	var endRow = sheet1.HeaderRows + sheet1.RowCount;
	for (var i = startRow; i < endRow; i++) {
		sheet1.ToolTipText(i,"umch_tp_nm") = sheet1.CellValue(i,"umch_tp_nm");
		sheet1.ToolTipText(i,"bkg_itm_log") = sheet1.CellValue(i,"bkg_itm_log");
		sheet1.ToolTipText(i,"ctrt_itm_log") = sheet1.CellValue(i,"ctrt_itm_log");
	}
}

//===================================================================================
//서버 조회/저장
//===================================================================================
/** 
* 서버 조회 및 저장등의 기능을 호출하는 doActionIBSheet  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} comboObj : 콤보오브젝트
* @param  {form} formObj : HTML Form 컨트롤
* @param  {int} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.05
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	   
	sheet1.ShowDebugMsg = false;
         
	switch(sAction) {
		case IBSEARCH: //조회
		
			ComOpenWait(true);
			sheet1.WaitImageVisible = false;
		
    		formObj.f_cmd.value = SEARCH;
			var sXml = sheet1.GetSearchXml("ESM_BKG_1049GS.do", FormQueryString(formObj));
			if(ComGetEtcData(sXml, "auditResultNm") != undefined){
				formObj.audit_result.value = ComGetEtcData(sXml, "auditResultNm");
			}
			sheet1.LoadSearchXml(sXml);			
 			//setToolTip(sheetObj, formObj, sAction);
			
			ComOpenWait(false);
			
			break;
	}
}