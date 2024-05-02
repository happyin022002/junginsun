/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_lse_1003.js
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
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve": 
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;  
				case "btn_Apply":  
					comPopupOK_Preset(sheetObject,formObject);
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
		ComOpenWait(true);
		for(i=0;i<sheetObjects.length;i++) { 
			//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] ); 
            initSheet(sheetObjects[i],i + 1); 
        	//khlee-마지막 환경 설정 함수 추가 
            ComEndConfigSheet(sheetObjects[i]);
		}   
		doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
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
					var HeadTitle="Sel|Seq| Data";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"multiplekey",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 } ];
		       
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
			case IBINSERT:      // saving
				var presetData=formObj.org_cntr_tpsz_cd.value;
				var datas=presetData.split("|"); 
				sheetObj.RenderSheet(0);
				for ( var i=0; i < datas.length; i++) {
					var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row,"multiplekey",datas[i].toUpperCase(),0);
					sheetObj.SetCellEditable(Row, "multiplekey",0);
				}	
				sheetObj.RenderSheet(1);
				if(datas.length > 0){
					sheetObj.SelectCell(1, 0, false);
				}		
				var checkedList=formObj.checked.value;  
				var checks=checkedList.split("|");
				for(var j=0; j < checks.length; j++){     
					for ( var i=1; i <= sheetObj.RowCount(); i++) {
						if(checks[j] == sheetObj.GetCellValue(i,"multiplekey")){
							sheetObj.RowDelete(i, false);
						} 			 	    		
					}		         
				}  	  	 
				
				ComOpenWait(false);
			break;
			case IBCOPYROW:        //행 복사
				sheetObj.DataCopy();
			break;
			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
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
		if(sheetObj.ColSaveName(col) == 'check')
		{	
			if(sheetObj.GetCellValue(row,col) == 1){
				sheetObj.SetRowBackColor(row,"#FFFFFF");
			} else {                            
				sheetObj.SetRowBackColor(row,"#FFFFFF");
			} 
		}	  		
		var formObject=document.form;
		var colName=sheetObj.ColSaveName(col);
		var inputStr=delSpace(value);
		switch(colName){
			case 'multiplekey':
				for (var i=0; i < inputStr.length; i++) {
					var oneChar=inputStr.charAt(i);
					if (oneChar != "") {
						if ( hanCheck(oneChar) ) { 
							ComShowCodeMessage("MNR00161", "Multiple Inquiry data!");
							sheetObj.SetCellValue(row,col,"");
							sheetObj.SelectCell(row, col);
							loopval="N";
							break;
						} else {
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
	// saving 문자열이 한글이면 true, 한글이 아니면 false.
	function hanCheck(str) { 
		var str1=getByteLenval(str);
		if(str.length*2 == str1) // 한글이면
			return true;
		else    // 한글이 아니면
			return false;
	}
	// saving받은 String의 Byte Size를 구한다.
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
	/**
     * setting return value to parent form.
     */
	function comPopupOK_Preset(sheetObj,formObject) {
		var formObj=document.form;
		var rArray=new Array(); //list containing row data
	    var sRow=sheetObj.FindCheckedRow("check");
	    //setting row as list.	 
	    if(sRow != "") {
		    var arrRow=sRow.split("|"); 	   
			var cArray=new Array();  		  	   
		    for (idx=0; idx < arrRow.length ; idx++){     
				 // list containing col data  	 
		    	cArray[idx]=sheetObj.GetCellValue(arrRow[idx], "multiplekey");
			}     	
		    
		    var shidx="0";	
		    if(formObj.sheet_id.value != "6") {
		    	shidx="0";	
		    }else{
		    	shidx = formObj.sheet_id.value;
		    }
		    
			var tmpval1="";       
			var tmpval2=formObj.temp_value1.value;
			var opener = window.dialogArguments;
			if (!opener) opener = parent;
			if(shidx == "0") {
				opener.getLse_psMulti(cArray,shidx,tmpval1 + "|" + tmpval2);    //호출하는 부모js에 getMnr_psMulti 붙여넣으면됩니다.
			}else{
				opener.getLse_psMulti01(cArray,shidx,tmpval1 + "|" + tmpval2, formObj.sheet_row.value);    //호출하는 부모js에 getMnr_psMulti 붙여넣으면됩니다.
			}
			ComClosePopup(); 
	    }else{
	    	ComShowCodeMessage("LSE01045");
			return false;
	    }
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
