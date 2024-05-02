/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1301.js
*@FileTitle  : DOT References
*@author     : CLT
*@version    : 1.0
*@since      : 2015/11/17
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		
			if(ComGetBtnDisable(srcName)){
				return false;
			}
     		
     		switch(srcName) {
     			case "btn_ok":
     				var opener = window.dialogArguments;
     				if (!opener) opener = parent;
					if (opener.getCOM_DOT_INFO_POPUP == undefined) {
						return ComShowMessage('Cannot find opener.getCOM_DOT_INFO_POPUP() or parent.getCOM_DOT_INFO_POPUP() js function');
					}
					setReturnData();
					opener.getCOM_DOT_INFO_POPUP(setReturnData());
					ComClosePopup();
 		    	  //comPopupOK();								
               break;
 		       case "btn_close":
 		    	   ComClosePopup(); 
               break;
     		} // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
	}
	function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
    	doActionIBSheet(sheetObjects[0],document.form,INIT);
    	if(document.form.pop_type.value=="R"){
    		ComBtnDisable("btn_ok");
    		sheetObjects[0].SetEditable(0);
    	}
	}
	
	 /**
	  * setting sheet initial values and header
	  * @param sheetObj
	  * @param sheetNo
	  * @return
	  */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
				with(sheetObj){		    
					var HeadTitle="|Reference Type|Reference";	
					SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );	
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);	
					var cols = [ {Type:"Status",   Hidden:1,  Width:30,    Align:"Center",ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Text",     Hidden:0,  Width:270,   Align:"Left",  ColMerge:0,   SaveName:"ref_type",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
								 {Type:"Text",     Hidden:0,  Width:270,   Align:"Left",  ColMerge:0,   SaveName:"ref_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
					             
					];
					
					InitColumns(cols);
					SetEditable(1);
					SetSheetHeight(150);
		        }
				break;
		}
	}	
	
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 * @param sheet_obj IBSheet Object
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	/**
	 * Sheet process handling
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
			case INIT: //Retrieve
				sheetObjects[0].SetWaitImageVisible(1);
				formObj.f_cmd.value=INIT;
		 		var sXml=sheetObj.GetSearchData("ESM_BKG_1301GS.do", FormQueryString(formObj));
				sheetObjects[0].LoadSearchData(sXml);
				sheetObjects[0].SetWaitImageVisible(0);
				break;
		}
	}
	
	function setReturnData(){
	  	var rArray =  new Array(1); //데이터를 담고 있는 배열
		var rowCnt = sheetObjects[0].RowCount();
		rArray[0] = new Array(rowCnt);
		var arrCnt = 0;
		for (var i=1; i < rowCnt+1; i++) {
			rArray[0][arrCnt] = sheetObjects[0].GetCellValue(i,"ref_name");
			arrCnt++;
		}
		return rArray;
	}
/* 개발자 작업  끝 */
