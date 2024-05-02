/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_presetmulty.js
*@FileTitle : EQ Component 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 박명신 
*@LastVersion : 1.0 
* 2009.05.27 박명신 
* 1.0 Creation    
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
     * @extends Mnr   
     * @class ees_mnr_multy : ees_mnr_multy 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_multy() {    
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm; 
    }     
   	/* 개발자 작업	*/    
	  
	/* 공통전역변수 */
	//var calPop = new calendarPopupGrid();
	var curTab = 1;
	var beforetab = 0;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	 
	var sheet = null
	  
	if(sheet == 2) {
		var sheetObj = sheetObjects[1];
	} else {
		var sheetObj = sheetObjects[0];
	}
	
	/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var Mincount = 0;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve": 
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;  
				 
				case "btn_RowAdd": 
	    			doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
				
				case "btn_Apply":  
					comPopupOK(sheetObject,formObject);
				break;
				
				case "btn_Close":    
					window.close();
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
 
       sheetObjects[sheetCnt++] = sheet_obj;

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
		doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
	}
	 
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {	
		var cnt = 0;	
		switch(sheetNo) {	
			case 1:      //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 300; 
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
	
					//전체Edit 허용 여부 [선택, Default false] 
					Editable = true; 
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(3, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//InitHeadMode(true, false, false, false, false,false)
					InitHeadMode(true, true, true, true, false,false)
					 	
					var HeadTitle = "Sel|Seq| Data";
						  	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,        CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtCheckBox, 50,    daCenter,  false,    "check",		false,          "",       dfNone,        0,       true,       true);
					InitDataProperty(0, cnt++ , dtSeq,      30,    daCenter,  false,    "",				false,          "",       dfNone,        0,       false,      false);
					InitDataProperty(0, cnt++ , dtData,     100,   daCenter,  false,    "multiplekey",  false,			"",       dfNone,        0,       true,       true,	  20,	 true,	 true,	   "",	  false);
								
					//SELECT 로우 배경색	                  
					//SelectionMode MultiSelection=false이면 1개의 행만 선택 가능           
					EditableColorDiff = false;     
					MultiSelection = true;                                    
					SelectionMode = smSelectionRow;  
					//선택시 하이라이트사용하지 않음            
					SelectHighLight = false;             
					//선택시 볼드 사용하지 않음              
				}
			break;
		}	
	}
		
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBINSERT:      // 입력
				var presetData  = formObj.presetData.value;
				var datas = presetData.split("|"); 
					
				for ( var i = 0; i < datas.length; i++) {
					var Row = sheetObj.DataInsert(-1);     
					sheetObj.CellValue2(Row,"multiplekey") = datas[i].toUpperCase();	
					sheetObj.CellEditable(Row, "multiplekey") = false;      
				}	
				
				if(datas.length > 0){
					sheetObj.SelectCell(1, 0, false);
				}		
					
				var checkedList = formObj.checked.value;  
				var checks = checkedList.split("|");
				 	  	 	  
				for(var j = 0; j < checks.length; j++){     
					for ( var i = 1; i <= sheetObj.RowCount; i++) {  
						if(checks[j] == sheetObj.CellValue(i,"multiplekey")){
							sheetObj.RowDelete(i, false);  	 
						} 			 	    		
					}		         
				}  	  	 
			break;
			 
			case IBCOPYROW:        //행 복사
				sheetObj.DataCopy();
			break;
	
			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
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
			if(sheetObj.CellValue(row,col) == 1){                    
				sheetObj.RowBackColor(row) = sheetObj.RgbColor(SelectBackColorR,SelectBackColorG,SelectBackColorB);
			} else {                            
				sheetObj.RowBackColor(row) = sheetObj.RgbColor(SheetEditBackColorR,SheetEditBackColorG,SheetEditBackColorB);  
			} 
		}	  		
		
		var formObject = document.form;
		var colName = sheetObj.ColSaveName(col);
		var inputStr = delSpace(value);
		switch(colName){
			case 'multiplekey':
				for (var i = 0; i < inputStr.length; i++) {
					var oneChar = inputStr.charAt(i);
					if (oneChar != "") {
						if ( hanCheck(oneChar) ) { 
							ComShowCodeMessage("MNR00161", "Multiple Inquiry data!");
							sheetObj.CellValue(row,col)="";    
							sheetObj.SelectCell(row, col); 
							loopval ="N";
							break;
						} else {
							continue;
						}
					} else {
						break;
					}
				} 
				var chkval=trim(sheetObj.CellValue(row, 'multiplekey'));
				if(chkval=="") { 
					sheetObj.CellValue(row,'check')="0";
					sheetObj.CellValue(row,col)="";
				} else {
					sheetObj.CellValue(row,'check')="1"; 
				}
			break;
		}
	}
	
	// 한글 여부 체크.
	// 입력 문자열이 한글이면 true, 한글이 아니면 false.
	function hanCheck(str) { 
		var str1 = getByteLenval(str);
		if(str.length*2 == str1) // 한글이면
			return true;
		else    // 한글이 아니면
			return false;
	}
	
	// 입력받은 String의 Byte Size를 구한다.
	function getByteLenval(str) {
		var len = 0;
		if( str == null ) return 0;
		for( var i = 0 ; i < str.length ; i++ ) {
			var c = escape(str.charAt(i));
			if ( c.length == 1 ) len ++;
			else if( c.indexOf("%u") != -1 ) len += 2;
			else if( c.indexOf("%") != -1 ) len += c.length/3;
		}
		return len;
	} 
	
	// 문자열 사이의 공백을 제거
	function delSpace(str) {
		var trimstr = str;
		for (var i=0; i< str.length;i++) {
			trimstr = trimstr.replace(' ' ,'');
		}
		return trimstr;
	}
		
	/**
     * 추가로 넘겨야 될값이 많아서 따로 구현한다.
     */
	function comPopupOK(sheetObj,formObject) {
		var formObj = document.form;
		var rArray = new Array(); //행데이터를 담고 있는 배열
		                   
	    var sRow = sheetObj.FindCheckedRow("check");
	    //가져온 행을 배열로 반든다.	 	  	 	      
	    var arrRow = sRow.split("|"); 	   
		var cArray = new Array();  		  	   
	    for (idx = 0; idx < arrRow.length - 1; idx++){     
			 //열데이터를 담고 있는 배열  	 
			cArray[idx] = sheetObj.CellValue(arrRow[idx], "multiplekey");
		}     	
		var shidx = formObj.sheet_id.value;	
		var tmpval1 = formObj.prefix.value;       
		var tmpval2 = formObj.temp_value1.value;       
		opener.getMnr_psMulti(cArray,shidx,tmpval1 + "|" + tmpval2);    //호출하는 부모js에 getMnr_psMulti 붙여넣으면됩니다.
		window.close(); 	       		   	              	
	}   	  	
						 
	function sheet1_OnKeyDown(sheetObj, row, col, keycode, Shift) {
		var colName = sheetObj.ColSaveName(col);
		if( keycode == 9 || keycode == 13 ){
			sheetObj.CellEditable(row,'multiplekey') = true;
		} 	
	}
		
	function sheet1_OnKeyUp(sheetObj, row, col, keycode, Shift) {
		var colName = sheetObj.ColSaveName(col); 
		if( keycode == 9 || keycode == 13 ){
			sheetObj.CellEditable(row,'multiplekey') = true;
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
     		string = string.replace(" ","");
    	}
 
    	return string;
   }
	
	/**
	 * 숫자에 대한 유효성을 체크.
	 */
	function donumberheck(obj) {
		var lveng = /[0-9]/;
		if( lveng.test(obj) ) {
			return false;
		}
		return true;
	}      
	/* 개발자 작업  끝 */ 
