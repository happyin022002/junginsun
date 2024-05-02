/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0466.js
*@FileTitle : Multiple Input Popup VL/VD
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : Kim Jong Ock
*@LastVersion : 1.0 
* 2014.01.03 Kim Jong Ock 
* 1.0 Creation   
**********************************************************
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
     * @extends CTM   
     * @class ees_ctm_0466 : ees_ctm_0466 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0466() {    
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
			
				case "btn_RowAdd":
	    			doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
				
				case "btn_Apply": 
					comPopupOK(sheetObject,formObject);
				break;
				
				case "btn_New":
					sheetObjects[0].CheckAll("check") = 0;
			  		ComResetAll();
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
		
		   var arr = document.form.orgval.value.split(","); //원래 입력되어 있던 데이터
		   
		
		   if (arr.length > 0 &&  document.form.orgval.value !="" ){
			  
			   for(i=0; i < arr.length; i++) {
					var insrow = sheetObjects[0].DataInsert(i);
					sheetObjects[0].CellValue2(insrow, 'multiplekey') = arr[i].substr(0,11);
					sheetObjects[0].CellValue2(insrow, 'digit') = arr[i].substr(10,11);
					sheetObjects[0].CellValue2(insrow, 'cntr_no') =  arr[i];
					sheetObjects[0].CellValue2(insrow,'check')="1"; 
				}
		   }else{   
	        	for(i=0; i < 6; i++) {
			      sheetObjects[0].DataInsert(i);
	     	    }
		   }
		//onload();
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
					style.height = 180;
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
					InitColumnInfo(6, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, false, false,false)
	
					var HeadTitle = "Seq.|Chk|CNTR NO|Digit|Event Date|cntr";
					  
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD,        CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtSeq,      30,    daCenter,  false,    "",				false,      "",       dfNone,        0,       false,      false);
					InitDataProperty(0, cnt++ , dtCheckBox, 30,    daCenter,  false,    "check",		false,      "",       dfNone,        0,       true,       true);
					InitDataProperty(0, cnt++ , dtData,     140,   daCenter,  false,    "multiplekey",  false,		"",       dfNone,        0,       true,       true,	  11,	 true,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtData,     40,    daCenter,  false,    "digit",        false,		"",       dfNone,        0,       false,      false,  1,	 true,	 true,	   "",	  false);
					InitDataProperty(0, cnt++ , dtData,     120,   daCenter,  false,    "event_dt",     false,		"",       dfUserFormat2, 0,       true,       true);
					InitDataProperty(0, cnt++ , dtHidden,    0,   daCenter,   false,    "cntr_no",      false,		"",       dfNone,        0,       false,      false,  11,	 true,	 true,	   "",	  false);

					InitDataValid(0,  "multiplekey", vtEngUpOther,"0123456789-"); 
                    InitUserFormat2(0, "event_dt", "####-##-## ##:##", "-|:" );
				}
			break;
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBINSERT:      // 입력
				var lvcnt = 0;
				var lvrow = sheetObj.RowCount;
				if( !isNaN(formObj.row_count.value) ) {
					lvcnt = eval(formObj.row_count.value);
					if( !donumberheck(lvcnt) ) {
						for(i=lvrow; i < lvcnt+lvrow; i++){
							if(sheetObj.RowCount < 300){
								sheetObj.DataInsert(i);
							}else{
								ComShowCodeMessage("CTM30015"); //"Inquiry data exceeds maximum 300 containers."
								formObj.row_count.value = "0";
								break;
							}	
						}
					} else {  
						if(sheetObj.RowCount < 300){
							sheetObj.DataInsert(-1);
							formObj.row_count.value = "1";
						}else{
							ComShowCodeMessage("CTM30015"); //"Inquiry data exceeds maximum 300 containers."
							formObj.row_count.value = "0";
						}
					}
				} else { 
					if(sheetObj.RowCount < 300){
						formObj.row_count.value = "1";
					}else{
						formObj.row_count.value = "0";
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
	
	function sheet1_OnChange(sheetObj, row, col, value){
		var formObject = document.form;
		var colName = sheetObj.ColSaveName(col);
		var inputStr = delSpace(value);
		switch(colName){
			case 'multiplekey':
				for (var i = 0; i < inputStr.length; i++) {
					var oneChar = inputStr.charAt(i);
					if (oneChar != "") {
						if ( hanCheck(oneChar) ) { 
							ComShowCodeMessage("COM12127", "Input data");
							sheetObj.CellValue(row,col)="";    
							sheetObj.SelectCell(row, col); 
							loopval ="N";
							break;
						} else{
							continue;
						}
					} else {
						break;
					}
				}
				
				var cntr_no = trim(sheetObj.CellValue(row, 'multiplekey'));
				
				var	 xml = sheetObj.GetSearchXml ("CTMCommonGS.do", "f_cmd=" + SEARCH10 + "&p_cntrno=" + cntr_no);
				var	 rtnValue = ComGetEtcData(xml, "rtnValue");

				 if (rtnValue == null) {
					   	sheetObj.CellValue2(row, 'digit') = "";
				    	sheetObj.CellValue2(row, 'cntr_no') =  "";
				 }else {
				    var CtnrVal = rtnValue.split("|");
				    if (CtnrVal.length >= 3) {
				     	sheetObj.CellValue2(row, 'digit') = CtnrVal[0].substring(10,11);
				    	sheetObj.CellValue2(row, 'cntr_no') =  CtnrVal[0];
				   }
				} 
				
				var chkval=trim(sheetObj.CellValue(row, 'cntr_no'));
				if(chkval=="") { 
					sheetObj.CellValue(row,'check')="0";
				} else {
					sheetObj.CellValue(row,'check')="1"; 
				}
				
 
			break;
			case 'check':	
				if ( value == "1") {
				   var chkval=trim(sheetObj.CellValue(row, 'cntr_no'));
				   if(chkval=="") { 
					  ComShowCodeMessage("CTM20111");
			     	}
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
		
	function comPopupOK(sheetObj,formObject) {
		var formObject = document.form;
		var checkRows;
		var colsCnt = sheetObj.LastCol + 1;
		var rows = sheetObj.Rows;
	
		var rArray = null; //행데이터를 담고 있는 배열
		var cArray = null; //열데이터를 담고 있는 배열
	
		var rDateArray = null; //행데이터를 담고 있는 배열
		
		var return_val = formObject.returnval.value;
	  
		checkRows = sheetObj.CheckedRows("check");
		if(checkRows == 0 && sheetObj.RowCount > 0 ) {
			ComShowCodeMessage("CTM30001"); 
			return;
		} else {
			var idx = 0;
			var chkval = "";
			var chkvalDate = "";
			
			rArray = new Array(checkRows);
			rDateArray = new Array(checkRows);
			
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
					cArray = new Array(colsCnt);
					for(var j=0; j<cArray.length; j++) {
						chkval=sheetObj.CellValue(i, 'cntr_no');
						var multiplekey =  sheetObj.CellValue(i, 'multiplekey');
						var digit  =  sheetObj.CellValue(i, 'digit');
						if(multiplekey =="") {  
							ComShowCodeMessage("CTM00002", "data"); 
							sheetObj.CellEditable(i,'multiplekey') = true;
							sheetObj.SelectCell(i, 'multiplekey'); 
							return;
						}
						if(digit =="") {  
							ComShowCodeMessage("CTM20111"); 
							sheetObj.CellEditable(i,'multiplekey') = true;
							sheetObj.SelectCell(i, 'multiplekey'); 
							return;
						}
						cArray[j] = chkval;
					}
					chkval=sheetObj.CellValue(i, 'cntr_no');
					rArray[idx] = chkval;
					
					chkvalDate=sheetObj.CellValue(i, 'event_dt');
					rDateArray[idx++] = chkvalDate;
				}
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(0,0,0);
			}
		}
		var xxx = sheetObj.FindCheckedRow("check"); 
		var xxxRow = xxx.split("|");
		var errcnt = 0;
		var dupcnt = 0;
		for(var i = 0; i < xxxRow.length-2; i++){
			for(var j = i+1; j < xxxRow.length-1; j++){
				if(sheetObj.CellValue(xxxRow[i],'multiplekey') == sheetObj.CellValue(xxxRow[j],'multiplekey')){				
					sheetObj.RowBackColor(xxxRow[j]) = sheetObj.RgbColor(255,255,0);
					if(errcnt == 0){
						dupcnt = xxxRow[j];
					}
					errcnt++;
				}
			}
		}
		if(errcnt > 0){       
			ComShowCodeMessage("COM131302", "Input data"); 
			sheetObj.CellEditable(dupcnt,'multiplekey') = true;
			sheetObj.SelectCell(dupcnt, 'multiplekey');  
		}else{
			if(opener != null) {
				// 일반 팝업인 경우
				opener.getCntr_Multi(rArray,rDateArray,return_val);  //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
			} else {
				// Modal 팝업인 경우
				window.dialogArguments.getCntr_Multi(rArray,rDateArray,return_val);
			}
			
			window.close();             
		}	
	}   
	
	function onload() {
		var formObject = document.form;   
		if(sheetObjects[0].RowCount > 1)    
			sheetObjects[0].SelectCell(1,2); 

		
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
