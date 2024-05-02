/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0054.js
*@FileTitle  : Portion Adjustment by RHQ_Figure Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/05
=========================================================*/	
	/****************************************************************************************
	  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
	                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
	                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/* 개발자 작업   */
	//공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	/**
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
	 */
	document.onclick=processButtonClick;
	function processButtonClick(){
	    var sheetObject=sheetObjects[0];
	    var formObj=document.form;
	    try {
	        var srcName=ComGetEvent("name");
	        switch(srcName) {
	        case "btn_DownExcel":
	        	if(sheetObj.RowCount() < 1) {
					 ComShowCodeMessage("COM132501");
				} else{
					doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
				}
	            break;
	        case "btn_close":
	        	ComClosePopup(); 
	            break;
	        }
	    } catch(e) {
	        if( e == "[object Error]") {
	            ComShowMessage(ComGetMsg("COM12111", "", ""));
	        } else {
	            ComShowMessage(e.message);
	        }
	    }
	}
	/**
	 * IBSheet Object 를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * IBSheet Object 를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
	    comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 *  Load 시
	 */
	function loadPage(){
	    var formObj=document.form;
	    loadingMode=true;
	    for(i=0;i<sheetObjects.length;i++){
	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
	    }
	        
	    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    loadingMode=false;
	    resizeSheet();
	}
	/**
	 *  Sheet 설정
	 */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
	    switch(sheetNo) {
	        case 1:     //sheet1 init
	            with(sheetObj){
	            var HeadTitle1="SEQ|Year|Quarter|N.OB/\nOB|Office\nView|Trade|Sub\nTrade|R.Lane|Lane\nBound|Trade\nBound|Week|VVD|RHQ|Office|Load(TEU)\nPortion|Load(TEU)|G.REV\nPortion|G.REV|";
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	            var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            InitHeaders(headers, info);
	            var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ob_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_wk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"lod_potn_rto",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"lod_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"rev_potn_rto",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"grs_rev",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"csq_cng_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            InitColumns(cols);
	            SetEditable(1);
	            SetSheetHeight(350);
                }
            break;
	    }
	}
	/**
	 * Sheet 관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	        case IBSEARCH:          //조회
	            formObj.f_cmd.value=SEARCH;
	            var sParam=FormQueryString(formObj);
	            var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0054GS.do",sParam);
	    		sheetObj.LoadSearchData(rtnXml,{Sync:1} );
	            sheetObj.SetSumText(0, "seq","");
	            sheetObj.SetSumText(0, "bse_yr","TOTAL");
	            break;
	        case IBDOWNEXCEL:       // 엑셀 다운로드
	        	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	            break;
	    }
	}
	
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
	/* 개발자 작업  끝 */
