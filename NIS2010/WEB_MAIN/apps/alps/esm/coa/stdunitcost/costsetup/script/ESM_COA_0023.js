/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_COA_0023.js
*@FileTitle : General Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.09.26 최성민
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
     * @extends 
     * @class ESM_COA_0023 : ESM_COA_0023 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0023() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

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
  		for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		var obj = document.form.f_yearmonth;
  		obj.value = document.form.f_cost_yrmon.value;
  		obj.value = ComGetMaskedValue(obj.value,"ym");
  		setPeriod(obj);
  		
  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		
  	}

  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
  	function processButtonClick(){
  		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  		var sheetObject = sheetObjects[0];
  		var sheetObject2 = sheetObjects[1];

  		var formObject = document.form;

  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  			switch(srcName) {

  			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
 				break;

  			case "btn_down_excel":
  				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  				break;      	
  				
  			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
  				break;
  				
  			case "btn_Close": 	

	   			if ((sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) && ComShowCodeConfirm("COM130504")) {
	   				//validation check
	   				if(!doActionIBSheet(sheetObjects[0],formObject,IBSAVE, IBSEARCH)) { 
	   					return false;
	   				}
				}
            	
  				window.close(); 
  				break;

		} // end switch
  		} catch(e) {
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg(OBJECT_ERROR));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}

  	/**
  	* 시트 초기설정값, 헤더 정의
  	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	*/
  	function initSheet(sheetObj,sheetNo) {
  		var cnt = 0;
  		var sheetid = sheetObj.id;

  		switch(sheetNo) {
  			case 1:		//sheet1 init
  				with (sheetObj) {

	  				// 높이 설정
	  				style.height = GetSheetHeight(6) ;
	  				// 전체 너비 설정
	  				SheetWidth = mainTable.clientWidth;
	
	  				// Host정보 설정[필수][HostIp, Port, PagePath]
	  				if (location.hostname != "")
	  					InitHostInfo(location.hostname, location.port, page_path);
	
	  				// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
	  				// 전체Edit 허용 여부 [선택, Default false]
	  				Editable = true;
	
	  				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  				InitRowInfo(1, 1, 1, 100);
	
					var HeadTitle = "Sts|Cost Yrmon|Office View|Rhq|Ratio (%)|General Expense|otr_expn_amt" ;
					
	  				var headCount = ComCountHeadTitle(HeadTitle);
	
	  				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  				InitColumnInfo(headCount, 0, 0, true);
	
	  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, true, true, false, false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
	
	  				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  				InitHeadRow(0, HeadTitle, true);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
  					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"cost_yrmon",	false,	"",		dfNone,		0,	false,	false ); 
  					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"ofc_vw_cd",	false,	"",		dfNone,		0,	false,	false ); 
  					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"rhq_cd",		false,	"",		dfNone,		0,	false,	false ); 
  					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daCenter,	true,	"gen_expn_rto",	false,	"",		dfInteger,	0,	true,	true, 2);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	true,	"gen_expn_amt",	false,	"|otr_expn_amt| * |gen_expn_rto| / 100",		dfInteger,	0,	false,	false);
  					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,	true,	"otr_expn_amt",	false,	"",		dfInteger,	0,	false,	false);
  					
  					CountPosition = 0;
  					WaitImageVisible = false;  					
  				}
  				break;
  				
  			case 2:		//sheet2 init
  				with (sheetObj) {

	  				// 높이 설정
	  				style.height = GetSheetHeight(6) ;
	  				// 전체 너비 설정
	  				SheetWidth = mainTable.clientWidth;
	
	  				// Host정보 설정[필수][HostIp, Port, PagePath]
	  				if (location.hostname != "")
	  					InitHostInfo(location.hostname, location.port, page_path);
	
	  				// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
	  				// 전체Edit 허용 여부 [선택, Default false]
	  				Editable = true;
	
	  				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  				InitRowInfo(1, 1, 1, 100);
	
					var HeadTitle = "Sts|Cost Yrmon|Office View|Rhq|Ratio (%)|General Expense|otr_expn_amt" ;
					
	  				var headCount = ComCountHeadTitle(HeadTitle);
	
	  				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  				InitColumnInfo(headCount, 0, 0, true);
	
	  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, true, true, false, false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
	
	  				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  				InitHeadRow(0, HeadTitle, true);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
  					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"cost_yrmon",	false,	"",		dfNone,		0,	false,	false ); 
  					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"ofc_vw_cd",	false,	"",		dfNone,		0,	false,	false ); 
  					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"rhq_cd",		false,	"",		dfNone,		0,	false,	false ); 
  					InitDataProperty(0, cnt++ , dtAutoSum,		70,		daCenter,	true,	"gen_expn_rto",	false,	"",		dfInteger,	0,	true,	true, 2);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	true,	"gen_expn_amt",	false,	"|otr_expn_amt| * |gen_expn_rto| / 100",		dfInteger,	0,	false,	false);
  					InitDataProperty(0, cnt++ , dtHidden,		80,		daRight,	true,	"otr_expn_amt",	false,	"",		dfInteger,	0,	false,	false);
  					
  					CountPosition = 0;
  					WaitImageVisible = false;  					
  				}
  				break;
  		}
  	}
   
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, tAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
            
            case IBSEARCH:      //결과조회
				
	   			if ((sheetObj.IsDataModified || sheetObjects[1].IsDataModified) && ComShowCodeConfirm("COM130504")) {
	   				//validation check
	   				if(!doActionIBSheet(sheetObj,formObj,IBSAVE, IBSEARCH)) { 
	   					return false;
	   				}
				}
            	
                ComOpenWait(true);                
                formObj.f_cmd.value = SEARCH;
                var sXml = sheetObj.GetSearchXml("ESM_COA_0023GS.do" , FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);
                if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]); 
                ComOpenWait(false);                
                break;
            
        	case IBSAVE: // 저장
        		if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
            	
        		if (tAction == IBSEARCH) {
        			if (!ComShowCodeConfirm("COM130504")) {
    					return false;
    				}
        		} else {
    				if (!ComShowCodeConfirm("COA00006")) {
    					return false;
    				}
        		}
        		
				
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				var sParam = FormQueryString(formObj);

				var sParamSheet1 = sheetObjects[0].GetSaveString();
				if (sParamSheet1 != "") {
					sParam = sParam + "&" + sParamSheet1;
				}
				var sParamSheet2 = sheetObjects[1].GetSaveString();
				if (sParamSheet2 != "") {
					sParam = sParam + "&" + sParamSheet2;
				}
				
				var sXml = sheetObj.GetSaveXml("ESM_COA_0023GS.do", sParam);
								
				sheetObjects[1].LoadSaveXml(sXml);
				sXml = ComDeleteMsg(sXml);
				sheetObjects[0].LoadSaveXml(sXml);
				ComOpenWait(false);
				break;
  				
            case IBDOWNEXCEL:	//엑셀 다운로드
  				var excelType = selectDownExcelMethod(sheetObj);
  				switch (excelType) {
  					case "AY":
  						sheetObj.Down2Excel(0, false, false, true);
  						sheetObjects[1].Down2Excel(0, false, false, true);
  						break;
  					case "DY":
  						sheetObj.Down2Excel(-1, false, false, true);
  						sheetObjects[1].Down2Excel(-1, false, false, true);
  						break;
  					case "AN":
  						sheetObj.SpeedDown2Excel(0, false, false);
  						sheetObjects[1].SpeedDown2Excel(0, false, false);
  						break;
  					case "DN":
  						sheetObj.SpeedDown2Excel(-1, false, false);
  						sheetObjects[1].SpeedDown2Excel(-1, false, false);
  						break;
  				}
  				
        }
    }

  	function setPeriod(obj){		
  	    ComCoaSetPeriod3(obj);
  	}  


   /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
    * <br><b>Example :</b>
    * <pre>
    *     if (validateForm(sheetObj,document.form,IBSAVE)) {
    *         로직처리;
    *     }
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {form} formObj 필수 html form object
    * @param {int} sAction 필수 프로세스 플래그 상수
    * @returns bool <br>
    *          true  : 폼입력값이 유효할 경우<br>
    *          false : 폼입력값이 유효하지 않을 경우
    * @author 최성민
    * @version 2013.10.01
    */
	function validateForm(sheetObj, formObj, sAction) {

		switch (sAction) {
			case IBSEARCH: // 조회
				break;
	
	  		case IBSAVE:
	   			if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "" 
	   				&& sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
					return false;
				}
	   			
	   			if(sheetObj.SumText(0,"gen_expn_rto") != 100 || sheetObjects[1].SumText(0,"gen_expn_rto") != 100) {
					ComShowCodeMessage("COM12114","Ratio(%)");
	   				return false;
	   			}
	   			
	   			if (!sheetObj.IsDataModified && !sheetObjects[1].IsDataModified ) {
					ComShowCodeMessage("COA00007");
					return false;
				}
				break;
		}
		return true;
	}
   
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
  	 * @author 최성민
  	 * @version 2013.10.01
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		sheetObj.SumText(0,0) = "";
	    sheetObj.SumText(0,"rhq_cd") = "   TOTAL";
	} 	

	/**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
   	 * @author 최성민
   	 * @version 2013.10.02
     */
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;

 		switch(colName)
     	{ 			
     		case "gen_expn_rto":
     			sheetObj.CellValue2(Row, "gen_expn_amt") = sheetObj.CellValue(Row, "otr_expn_amt") * sheetObj.CellValue(Row, "gen_expn_rto") / 100; 				
 				break; 			
     	}
 	}

	/**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
   	 * @author 최성민
   	 * @version 2013.10.02
     */
 	function sheet2_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;

 		switch(colName)
     	{ 			
     		case "gen_expn_rto":
     			sheetObj.CellValue2(Row, "gen_expn_amt") = sheetObj.CellValue(Row, "otr_expn_amt") * sheetObj.CellValue(Row, "gen_expn_rto") / 100; 				
 				break; 			
     	}
 	}
	
   
	/* 개발자 작업  끝 */