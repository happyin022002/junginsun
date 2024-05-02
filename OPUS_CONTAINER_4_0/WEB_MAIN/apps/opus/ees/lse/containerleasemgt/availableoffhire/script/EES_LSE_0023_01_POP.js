/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_0023_POP.js
*@FileTitle  : EQ Component
*@author     : CLT
*@version    : 1.0
*@since      : 2015/03/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* 공통전역변수 */
	//var calPop = new calendarPopupGrid();
	var curTab=1;
	var beforetab=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheet=null
	var sheetObj=sheetObjects[0];
	/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
	// 공통전역변수
	var sheetObjects=new Array();
	var sheetCnt=0;
	var Mincount=0;
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		/*******************************************************/
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve": 
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;  	
				case "btn_select": 
					var Row=sheetObject.RowCount();
					comPopSelect(sheetObject,formObject); 
				break;
				case "btn_close":
					ComClosePopup(); 
				break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e); 
			} else {
				ComFuncErrMsg(e); 
			}	
		}
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
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		ComOpenWait(true);
		for(i=0;i<sheetObjects.length;i++) { 
            ComConfigSheet (sheetObjects[i] ); 
            initSheet(sheetObjects[i],i + 1); 
            ComEndConfigSheet(sheetObjects[i]);
		}   
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> sheetObject, sheetNo ==> sheetObject tag serial number
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 initializing sheet모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {	
		var cnt=0;	
		switch(sheetNo) {	
			case 1:      //sheet1 init
			    with(sheetObj){
					var HeadTitle="Sel|Seq|Place|Name";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Radio",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"check",   KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Seq",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq_num", KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",   Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",  KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1,  EditLen:20 },
					             {Type:"Text",   Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_nm",  KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:1,   InsertEdit:1,  EditLen:20 } ];
					InitColumns(cols);
					SetSheetHeight(300);
					SetEditable(1);
					SetEditableColorDiff(0);
		            SetSelectionMode(smSelectionRow);
		      }
			break;
		}	
	}
	// handling sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH: 
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
	         	sheetObj.SetWaitImageVisible(1);
				sheetObj.DoSearch("EES_LSE_0023GS.do", FormQueryString(formObj));
		        sheetObj.SetWaitImageVisible(0);
		        ComOpenWait(false);
			break;
		}
	}
	
	function comPopSelect(sheetObj,formObject) {
		var formObj = document.form;
		var checkRows;
		var colsCnt = sheetObj.LastCol()+ 1;
 		var rows = sheetObj.RowCount();
		var rArray = null; //list containing row data
		var cArray = null; // list containing col data
		var return_val = formObj.returnval.value;
		var return_row = formObj.returnrow.value;
		checkRows = sheetObj.CheckedRows("check");
		if(checkRows == 0) {
			ComShowCodeMessage("LSE01076", ""); 
			return;
		} else {
			var idx = 0;
			var chkval = "";
			rArray = new Array(checkRows);
			for(var i = 1; i < rows+1; i++) {
				if(sheetObj.GetCellValue(i, "check") == 1) {
					cArray = new Array(colsCnt);
					for(var j = 0; j < cArray.length; j++) {
						chkval = sheetObj.GetCellValue(i, "loc_cd");
						if(chkval == "") {  
							ComShowCodeMessage("LSE01076", "Multiple Inquiry data!"); 
							sheetObj.SetCellEditable(i,"loc_cd",1);
							sheetObj.SelectCell(i, "loc_cd");
							return;
						}
						cArray[j]=chkval;
					}
					chkval=sheetObj.GetCellValue(i, "loc_cd");
					// 체크된 cell을 rArray에 넣어준다.
					rArray[idx++]=chkval;
				}
				sheetObj.SetRowBackColor(i,"#FFFFFF");
			}
		}
		var xxx=sheetObj.FindCheckedRow("check");
		var xxxRow=xxx.split("|");
		var errcnt=0;
		var dupcnt=0;
		
		for(var i = 0; i < xxxRow.length; i++){
			for(var j = i+1; j < xxxRow.length; j++){
				//sheetObj.SetRowBackColor(j+1,"#FFFFFF");
				if(sheetObj.GetCellValue(xxxRow[i],"loc_cd") == sheetObj.GetCellValue(xxxRow[j],'loc_cd')){
					sheetObj.SetRowBackColor(j+1,"#FFFF00");
					sheetObj.SetRowBackColor(i+1,"#FFFF00");
					if(errcnt == 0){
						dupcnt=xxxRow[j];
					}
					errcnt++;
				}
			}
		}
		if(errcnt > 0){       
			ComShowCodeMessage("LSE01005", ""); 
			//sheetObj.CellValue(xxx,'multiplekey')=""; 
			sheetObj.SetCellEditable(dupcnt,"loc_cd",1);
			sheetObj.SelectCell(dupcnt, "loc_cd");
		}else{ 
			opener.getLse_Multi(rArray,return_row); //호출하는 부모js에 getLse_Multi 붙여넣으면 됩니다.
			
			ComClosePopup(); 
		}	
	}  
	
	/* 개발자 작업  끝 */ 
