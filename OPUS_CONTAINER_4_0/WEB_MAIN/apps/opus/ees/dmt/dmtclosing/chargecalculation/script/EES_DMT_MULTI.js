/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_DMT_MULTI.js
*@FileTitle  : Multi data select common
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/


   	/* 개발자 작업	*/    
	/* 공통전역변수 */
	//var calPop = new calendarPopupGrid();
	var curTab=1;
	var beforetab=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheet=null
	if(sheet == 2) {
		var sheetObj=sheetObjects[1];
	} else {
		var sheetObj=sheetObjects[0];
	}
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
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve": 
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;  
				case "btn_RowAdd":
	    			doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
				case "btn_Apply": 
					comPopupOK_1(sheetObject,formObject);
				break;
				case "btn_Close":  
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
		for(i=0;i<sheetObjects.length;i++) { 
			//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] ); 
            initSheet(sheetObjects[i],i + 1); 
        	//khlee-마지막 환경 설정 함수 추가 
            ComEndConfigSheet(sheetObjects[i]);
		}   
		for(i=0; i < 6; i++) {
			sheetObjects[0].DataInsert();
		}
		fn_OnLoad();
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

		        	var HeadTitle="Seq.|Chk| Data";

		        	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0, VScrollMode:1 } );

		        	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:0 };
		        	var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        	InitHeaders(headers, info);

		        	var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		        	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"multiplekey",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 } ];
		        	
		        	InitColumns(cols);
		        	SetEditable(1);
		        	SetSheetHeight(250);
		        	SetColProperty(0 ,"multiplekey" , {AcceptKeys:"E|N|[-]" , InputCaseSensitive:1});
				}
			    break;
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBINSERT:      // 입력
				var lvcnt=0;
				var lvrow=sheetObj.RowCount() + sheetObj.HeaderRows();
				if( !isNaN(formObj.row_count.value) ) {
					lvcnt = eval(formObj.row_count.value);
					if( !donumberheck(lvcnt) ) {
						for(i=lvrow; i < lvcnt+lvrow; i++){
							sheetObj.DataInsert(i);
						}
					} else {  
						sheetObj.DataInsert(-1);
						formObj.row_count.value="1";
					}
				} else { 
					formObj.row_count.value="1";
				}
			break;
			case IBCOPYROW:        //행 복사
				sheetObj.DataCopy();
			break;
			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			break;
			case IBLOADEXCEL:        //엑셀 업로드
				sheetObj.LoadExcel();
			break;
		}
	}
	/**
	 * Location 이나 Contry Code 입력시 이벤트처리 
	 *
	 */
	function sheet1_OnChange(sheetObj, row, col, value){
		var formObject=document.form;
		var colName=sheetObj.ColSaveName(col);
		var inputStr=delSpace(value);
		switch(colName){
			case 'multiplekey':
				for (var i=0; i < inputStr.length; i++) {
					var oneChar=inputStr.charAt(i);
					if (oneChar != "") {
						if ( hanCheck(oneChar) ) { 
							ComShowCodeMessage("COM12127", "Input data");
							sheetObj.SetCellValue(row,col,"");
							sheetObj.SelectCell(row, col);
							loopval="N";
							break;
						} else{
							continue;
						}
					} else {
						break;
					}
				} 
				var chkval=trim(sheetObj.GetCellValue(row, 'multiplekey'));
				if(chkval=="") { 
					sheetObj.SetCellValue(row,'check',"0");
					sheetObj.SetCellValue(row,col,"");
				} else {
					sheetObj.SetCellValue(row,'check',"1");
				}
			break;
		}
	}
	// 한글 여부 체크.
	// 입력 문자열이 한글이면 true, 한글이 아니면 false.
	function hanCheck(str) { 
		var str1=getByteLenval(str);
		if(str.length*2 == str1) // 한글이면
			return true;
		else    // 한글이 아니면
			return false;
	}
	// 입력받은 String의 Byte Size를 구한다.
	function getByteLenval(str) {
		var len=0;
		if( str == null ) return 0;
		for( var i=0 ; i < str.length ; i++ ) {
			var c=escape(str.charAt(i));
			if ( c.length == 1 ) len ++;
			else if( c.indexOf("%u") != -1 ) len += 2;
			else if( c.indexOf("%") != -1 ) len += c.length/3;
		}
		return len;
	} 
	// 문자열 사이의 공백을 제거
	function delSpace(str) {
		var trimstr=str;
		for (var i=0; i< str.length;i++) {
			trimstr=trimstr.replace(' ' ,'');
		}
		return trimstr;
	}
	
	function comPopupOK_1(sheetObj,formObject) {
		var formObject=document.form;
		var checkRows;
		var colsCnt=sheetObj.LastCol() + 1;
		var rows=sheetObj.LastRow();
		var rArray=null; //행데이터를 담고 있는 배열
		var cArray=null; //열데이터를 담고 있는 배열
		var return_val=formObject.returnval.value;
		checkRows=sheetObj.CheckedRows("check");
		if(checkRows == 0) {
			ComShowCodeMessage("DMT00009"); 
			return;
		} else {
			var idx=0;
			var chkval="";
			rArray=new Array(checkRows);
			for(var i=0; i <= rows; i++) {
				if(sheetObj.GetCellValue(i, "check") == 1) {
					cArray=new Array(colsCnt);
					for(var j=0; j<cArray.length; j++) {
						chkval=sheetObj.GetCellValue(i, 'multiplekey');
						if(chkval=="") {  
							ComShowCodeMessage("DMT05014", "data"); 
							sheetObj.SetCellEditable(i,'multiplekey',1);
							sheetObj.SelectCell(i, 'multiplekey');
							return;
						}
						cArray[j]=chkval;
					}
					chkval=sheetObj.GetCellValue(i, 'multiplekey');
					var a = idx;
					rArray[idx++]=chkval;
				}
				//sheetObj.SetRowBackColor(i,"#000000");
			}
		}
		var xxx=sheetObj.FindCheckedRow("check");
		var xxxRow=xxx.split("|");
		var errcnt=0;
		var dupcnt=0;
		for(var i=0; i < xxxRow.length-2; i++){
			for(var j=i+1; j < xxxRow.length-1; j++){
				if(sheetObj.GetCellValue(xxxRow[i],'multiplekey') == sheetObj.GetCellValue(xxxRow[j],'multiplekey')){
					sheetObj.SetRowBackColor(xxxRow[j],"#FFFF00");
					if(errcnt == 0){
						dupcnt=xxxRow[j];
					}
					errcnt++;
				}
			}
		}
		if(errcnt > 0){       
			ComShowCodeMessage("DMT00144", "Input data"); 
			sheetObj.SetCellEditable(dupcnt,'multiplekey',1);
			sheetObj.SelectCell(dupcnt, 'multiplekey');
		}else{
			
			var opener=window.dialogArguments;
			
			if (!opener) {
				opener=parent; 
			}
			
			// 일반 팝업인 경우
			opener.getDmt_Multi(rArray,return_val);  //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
			
			/*
			
			if(opener != null) {
				// 일반 팝업인 경우
				opener.getDmt_Multi(rArray,return_val);  //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
			} else {
				// Modal 팝업인 경우
				window.dialogArguments.getDmt_Multi(rArray,return_val);
			}*/
			ComClosePopup(); 
		}	
	}   
	function fn_OnLoad() {
		var formObject=document.form;   
		if(sheetObjects[0].RowCount()> 1)
			sheetObjects[0].SelectCell(1,2);
		//formObject.sheet1.ColHidden(1) = true;	// 마지막컬럼인인 특정셋팅 컬럼인지는 모르겠으나 히든설정이 안되는것도 있음(수정바람~~!)
	}   
	function sheet1_OnKeyDown(sheetObj, row, col, keycode, Shift) {
		var colName=sheetObj.ColSaveName(col);
		if( keycode == 9 || keycode == 13 ){
			sheetObj.SetCellEditable(row,'multiplekey',1);
		}
	}
	function sheet1_OnKeyUp(sheetObj, row, col, keycode, Shift) {
		var colName=sheetObj.ColSaveName(col);
		if( keycode == 9 || keycode == 13 ){
			sheetObj.SetCellEditable(row,'multiplekey',1);
			sheetObj.SelectCell(row, 'multiplekey');
		}  
	}
	/**  
	 *  trim  
	 */ 
    function trim(string)
    {
    	for(;string.indexOf(" ")!= -1;)
    	{
     		string=string.replace(" ","");
    	}
    	return string;
   }
	/**
	 * 숫자에 대한 유효성을 체크.
	 */
	function donumberheck(obj) {
		var lveng=/[0-9]/;
		if( lveng.test(obj) ) {
			return false;
		}
		return true;
	}      
	/* 개발자 작업  끝 */ 
