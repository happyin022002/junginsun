/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0069.js
*@FileTitle : View All Rates
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.08.13 김대호
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview View All Rates 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Pri
 * @class ESM_PRI_0069:ESM_PRI_0069 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_0069() {
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
var gPageNo = 1;
//업무전역변수
var gCurrDate;
var svcScpCd;

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
* @version 2009.08.13
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
* @version 2009.08.13
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
    
    //doActionIBSheet(sheet1, form, IBSEARCH, "", "1"); 
    doActionIBSheet(sheet1, form, IBSEARCH_ASYNC01, "", "1"); 
    
    // 4만건 이상 테스트
    // SC NO : GLO90901
    // WHERE PROP_NO = 'PDX090072M'
    //	AND AMDT_SEQ = '13'
    //	AND SVC_SCP_CD = 'TPE'
    //	AND GEN_SPCL_RT_TP_CD = 'G'
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
* @version 2009.08.13
*/ 
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	var sheetID = sheetObj.id;
   
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
		            //높이 설정
		            style.height = 460;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		            
		            ScrollTrack = false;
		            MassOfSearch = 1;
		            //IsBufferedScroll = true
		            
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(2, 1, 3, 5000); // DB paging 시 jsp rowpage와   페이지와 같이 맞춰줘야함.
		            var HeadTitle1 = "|||Seq.|Commodity|Actual\nCustomer|Origin|Origin|Origin|Origin|Destination|Destination|Destination|Destination|PER|CGO\nType|CUR|Rate";
		            var HeadTitle2 = "|||Seq.|Commodity|Actual\nCustomer|Location|Country|State|Via |Via|Location|Country|State|PER|CGO\nType|CUR|Rate"
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            InitHeadRow(1, HeadTitle2, true);
                   
//데이터속성         ROW ,COL   ,DATATYPE     ,WIDTH  ,DATAALIGN   ,COLMERGE  ,SAVENAME                       ,KEYFIELD,CALCULOGIC,DATAFORMAT       ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtHidden     ,50     ,daLeft      ,true      ,"cmdt_hdr_seq" 		        ,false ,""          ,dfNone           ,0               ,false     ,false);
InitDataProperty(0 ,cnt++ ,dtHidden     ,50     ,daLeft      ,true      ,"rout_seq" 		            ,false ,""          ,dfNone           ,0               ,false     ,false);
InitDataProperty(0 ,cnt++ ,dtHidden     ,50     ,daLeft      ,true      ,"rt_seq"    		            ,false ,""          ,dfNone           ,0               ,false     ,false);
InitDataProperty(0 ,cnt++ ,dtSeq        ,40     ,daCenter    ,true      ,"seq"                          ,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,130    ,daLeft	     ,true      ,"prc_cmdt_def_nm"  	        ,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,130    ,daLeft      ,true      ,"cust_lgl_eng_nm" 	            ,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,90     ,daLeft      ,true      ,"org_rout_pnt_loc_def_cd"   	,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,55     ,daCenter    ,true      ,"org_rout_pnt_loc_cnt_cd"  	,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,40     ,daCenter    ,true      ,"org_rout_pnt_loc_ste_cd"  	,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,50     ,daLeft      ,true      ,"org_rout_via_port_def_cd"   	,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,50     ,daLeft      ,true      ,"dest_rout_via_port_def_cd"    ,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,90     ,daLeft      ,true      ,"dest_rout_pnt_loc_def_cd"     ,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,55     ,daCenter    ,true      ,"dest_rout_pnt_loc_cnt_cd"     ,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,40     ,daCenter    ,true      ,"dest_rout_pnt_loc_ste_cd"     ,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,30     ,daCenter    ,true      ,"rat_ut_cd"    		        ,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,35     ,daCenter    ,true      ,"prc_cgo_tp_cd" 			    ,false ,""          ,dfNone           ,0               ,false     ,false);                                                                                                        
InitDataProperty(0 ,cnt++ ,dtData       ,30     ,daCenter    ,true      ,"curr_cd"    		            ,false ,""          ,dfNone           ,0               ,false     ,false);
InitDataProperty(0 ,cnt++ ,dtData       ,75     ,daRight     ,true      ,"prop_frt_rt_amt" 		        ,false ,""          ,dfNullFloat      ,2               ,false     ,false);

					//AutoRowHeight = false;
					WordWrap = true;
					//Ellipsis = true;
					
		    		CountFormat = "[SELECTDATAROW / TOTALROWS]";

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
* @version 2009.08.13
*/ 
function processButtonClick(){
	var form = document.form;
    try {
	    var srcName = window.event.srcElement.getAttribute("name");
	    switch(srcName) {
	    	case "btn_retrieve":
	    		//doActionIBSheet(sheet1, form, IBSEARCH, "", "1");
	    		doActionIBSheet(sheet1, form, IBSEARCH_ASYNC01, "", "1");
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
* sheet1 데이터 조회후 발생하는 sheet1_OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2009.12.23
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var form = document.form;
    if (errMsg == "") {
    	if(form.f_cmd.value == SEARCH) {
        	var pageRows = parseInt(form.pagerows.value, 10);
        	var totalRows = parseInt(sheet1.TotalRows, 10);
        	var totalPage = totalRows / pageRows;
        	var bottoomRow = sheet1.LastRow - sheet1.HeaderRows + 1;
        	totalPage = parseInt(totalPage, 10);
        	var totalMod = totalRows % pageRows;
        	if(totalMod > 0) {
        		totalPage = totalPage + 1;
        	}
    		//sheet1.CountFormat = "[" + ComAddComma2(pageRows, "#,###") + " row : " + ComAddComma2(bottoomRow, "#,###") + " bottom]" + "        " + "[" + gPageNo + " page / " + totalPage + " page]" + "        " + "[SELECTDATAROW / TOTALROWS]";
        	//sheet1.CountFormat = "[" + ComAddComma2(bottoomRow, "#,###") + " bottom]" + "        " + "[" + gPageNo + " page / " + totalPage + " page]" + "        " + "[SELECTDATAROW / TOTALROWS]";
    		//sheet1.CountFormat = "[SELECTDATAROW / TOTALROWS]" + "[" + sheet1.TotalRows + "]";
    		//alert(sheet1.TotalRows);
    	}
    }

}   

/** 
* sheet1 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {String} Row       : 처음 조회 시 사용된 조회 조건
* @param  {Long} Col 		 : 다음 페이지 번호
* @param  {Long} Value 	     : 한페이지에 조회하는 행의 개수, InitRowInfo Method에서 설정
* @return 없음
* @see #
* @author 김대호
* @version 2009.12.23
*/ 
/*
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
   doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}
*/

/**
 * OnClick 이벤트 발생시 호출되는 function <br>
 * Sheet의 해당 Sel을 클릭 시 메모장을 화면에 표시한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
 * @return 없음
 * @author 김대호
 * @version 2010.01.12
 */  	           
 function sheet1_OnClick(sheetObj, Row, Col, Value) {
   //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
   var colname = sheetObj.ColSaveName(Col);  	 
 	switch(colname) {
 		case "prc_cmdt_def_nm":
 		case "cust_lgl_eng_nm": 	    		
   		ComShowMemoPad(sheetObj, Row, Col, true, 450, 80);
   		break;
 	}    	 

}

/** 
* sheet1 셀을 더블클릭했을시 발생하는 sheet1_OnDblClick 이벤트핸들러 <br>
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
* @version 2009.08.13
*/ 
function sheet1_OnDblClick(sheetObj, Row, Col, Value) {
	var cmdt_hdr_seq = sheet1.CellValue(Row, "cmdt_hdr_seq");
	var rout_seq = sheet1.CellValue(Row, "rout_seq");
	var rt_seq = sheet1.CellValue(Row, "rt_seq");
	opener.moveRowPosTo(cmdt_hdr_seq, rout_seq, rt_seq);
	window.close();	
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
* @version 2009.08.13
*/ 
function doActionIBSheet(sheetObj, formObj, sAction, condParam, PageNo) {
	   
	sheet1.ShowDebugMsg = false;
         
	switch(sAction) {
	
		case IBSEARCH_ASYNC01: //일반조회
		
			ComOpenWait(true);
			sheet1.WaitImageVisible = false;
		
			formObj.f_cmd.value = SEARCHLIST; // 일반조회
			
			// DoSearch 용, MassOfSearch 용
			sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT,NOMERGEROW,NOTRIM,NOTDTAG,NOCOMBO,NOFORMAT";
    		sheet1.DoSearch("ESM_PRI_0069GS.do", FormQueryString(formObj));
    		
    		// DoSearch4Fx 용
			//sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC";
			//sheet1.DoSearch4Fx("ESM_PRI_0069GS.do", FormQueryString(formObj));
		
			// MassOfSearch 용
			//sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT,NOMERGEROW,NOTRIM,NOTDTAG,NOCOMBO,NOFORMAT";
			//var sXml = sheet1.GetSearchXml("ESM_PRI_0069GS.do", FormQueryString(formObj));
			//sheet1.LoadSearchXml(sXml);

			ComOpenWait(false);
			
			break;
	
		case IBSEARCH: //조회: 현재사용안함
    		
			ComOpenWait(true);
			sheet1.WaitImageVisible = false;
		
			formObj.f_cmd.value = SEARCH; // paging
        	gPageNo = 1;
        	
            // DoSearch 용
			//sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT,NOMERGEROW,NOTRIM,NOTDTAG,NOCOMBO,NOFORMAT";
        	//sheet1.DoSearch("ESM_PRI_0069GS.do", FormQueryString(formObj), "page_no=" + PageNo);
        	
            // DoSearch4Fx 용
			sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC";
			sheet1.DoSearch4Fx("ESM_PRI_0069GS.do", FormQueryString(formObj), "page_no=" + PageNo);		
		
			ComOpenWait(false);
			
			break;
			
		case IBSEARCHAPPEND: // 현재사용안함
			
			ComOpenWait(true);
			sheet1.WaitImageVisible = false;
			
            formObj.f_cmd.value = SEARCH; // paging
            gPageNo = PageNo;
            
            // DoSearch 용
			//sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT,NOMERGEROW,NOTRIM,NOTDTAG,NOCOMBO,NOFORMAT";
            //sheet1.DoSearch("ESM_PRI_0069GS.do", FormQueryString(formObj), "page_no=" + PageNo, true);
            
            // DoSearch4Fx 용
			sheet1.SpeedOption="NOPROGRESSTICK,NOSTATUS,NOFIT,NOSUM,NOCALC";
            sheet1.DoSearch4Fx("ESM_PRI_0069GS.do", FormQueryString(formObj), "page_no=" + PageNo, true);
            
			ComOpenWait(false);
            
            break;
            
	}
}