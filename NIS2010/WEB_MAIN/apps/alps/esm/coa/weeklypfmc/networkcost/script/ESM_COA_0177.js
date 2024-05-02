/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0177.js
*@FileTitle : Lane Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.02.11 이행지
* 1.0 Creation
* =========================================================
* History
* 2010.02.11 이행지 Ticket ID:CHM-201002397 Vessel Pool 및 OP4 logic 보완 요청
* 2010.04.15 이행지 FormQueryString => coaFormQueryString 변경
* 2010.12.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                    - showErrMessage -> ComShowMessage로 수정
* 2014.06.17 임옥영 Ticket ID:CHM-201430756 AVG U/C의 Lane Detail R.Lane 알파벳 순 정렬
*                          del chk시 오류수정
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
     * @class ESM_COA_0177 : ESM_COA_0177 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0177() {
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
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var sRow = 0;


	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;

	  			case "btn_down_excel":
	  				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
	  				break;      	

	  			case "btn_month_copy":
	  		        var display = "0,1";
        	        ComOpenPopup("ESM_COA_0173.do?classId=ESM_COA_0177", 250, 200, "LaneTableCopy", display, true, false);
	  				break;      	
	  				
				case "btn_close":
					window.close();
					break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComComShowMessage(OBJECT_ERROR);
			} else {
				ComComShowMessage(e);
			}
		}
	}

	/**
	* IBSheet Object를 배열로 등록
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	* 배열은 소스 상단에 정의
	*/
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
	  				style.height = GetSheetHeight(21) ;
	  				// 전체 너비 설정
	  				SheetWidth = mainTable.clientWidth;
	
	  				// Host정보 설정[필수][HostIp, Port, PagePath]
	  				if (location.hostname != "")
	  					InitHostInfo(location.hostname, location.port, page_path);
	
	  				// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;  //msHeaderOnly;
	
	  				// 전체Edit 허용 여부 [선택, Default false]
	  				Editable = true;
	
	  				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  				InitRowInfo(1, 1, 1, 100);
	
					var HeadTitle = "|Del|Trade|Scope|R.Lane|Vessel Type|Number of Vessels|YYYYMM|Sts" ;
					
	  				var headCount = ComCountHeadTitle(HeadTitle);
	
	  				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  				InitColumnInfo(headCount, 0, 0, true);
	
	  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, true, false, false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
	
	  				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  				InitHeadRow(0, HeadTitle, true);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,	"merge_cd",		true,	"",		dfNone,		0,	false,	true ); 
  					
					InitDataProperty(0, cnt++ , dtDelCheck,		40,		daCenter,	true,	"del_chk",		false,	"",		dfNone,		0,	true,	true ); 
  					InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	"trd_cd",		true,	"",		dfNone,		0,	false,	true ); 
  					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"sub_trd_cd",	true,	"",		dfNone,		0,	false,	true ); 
  					InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,	"rlane_cd",		true,	"",		dfNone,		0,	false,	true ); 
  					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"vsl_oshp_cd",	true,	"",		dfNone,		0,	false,	false);
  					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"freq_no",		false,	"",		dfInteger,	0,	true,	true, 2);
  					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	false,	"cost_yrmon",	true,	"",		dfNone,		0,	false,	false);
  					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
  					
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

			case IBCLEAR:          //조회
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0177GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "trd_cd", true, 0);
				if (arrXml.length > 1)
					ComCoaSetIBCombo(sheetObj, arrXml[1], "rlane_cd", true, 0);	
				if (arrXml.length > 2)
					ComCoaSetIBCombo(sheetObj, arrXml[2], "sub_trd_cd", true, 0);	
				ComOpenWait(false);
				break;
		

            case IBSEARCH:      //조회			
   				if(!validateForm(sheetObj,formObj,sAction)) { 
   					return false;
   				}
				
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST;               
                sheetObj.DoSearch("ESM_COA_0177GS.do", FormQueryString(formObj));
                ComOpenWait(false);
                break;
                                            	
			case IBINSERT: 
				var costYrmon = ComGetUnMaskedValue(formObj.f_cost_yrmon, "ym");
				var rowCount = sheetObj.SelectRow;
				sheetObj.Redraw = false;
				sheetObj.DataInsert(-1);
				sheetObj.CellValue2(sheetObj.SelectRow, "vsl_oshp_cd") = "OWN";
				sheetObj.CellValue2(sheetObj.SelectRow, "merge_cd") = rowCount;
				sheetObj.CellValue2(sheetObj.SelectRow, "cost_yrmon") = costYrmon;
				sheetObj.DataInsert(-1);
				sheetObj.CellValue2(sheetObj.SelectRow, "vsl_oshp_cd") = "CHT";
				sheetObj.CellValue2(sheetObj.SelectRow, "merge_cd") = rowCount;
				sheetObj.CellValue2(sheetObj.SelectRow, "cost_yrmon") = costYrmon;
				sheetObj.DataInsert(-1);
				sheetObj.CellValue2(sheetObj.SelectRow, "vsl_oshp_cd") = "OTH";
				sheetObj.CellValue2(sheetObj.SelectRow, "merge_cd") = rowCount;
				sheetObj.CellValue2(sheetObj.SelectRow, "cost_yrmon") = costYrmon;	
				
				//Row Add 후 소계보여주기위함.
				sheetObj.MessageText("SubSum") = "TTL";
				sheetObj.ShowSubSum("rlane_cd", "6", -1, false, false, 5);
				sheetObj.Redraw = true;
				break;	
            
        	case IBSAVE: // 저장
        		if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
            	        		
				if (!ComShowCodeConfirm("COA00006")) {
					return false;
				}
        				
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;				
				sheetObj.DoSave("ESM_COA_0177GS.do", FormQueryString(formObj), -1, false);
				doActionIBSheet(sheetObj, formObj, IBSEARCH); //
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
				if(formObj.f_cost_yrmon.value == "") {
					ComShowCodeMessage("COA10015","YYYY-MM"); 
				}
				break;
	
	  		case IBSAVE:
	   			if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
					return false;
				}
	   			
	   			// 중복체크
	   			var Row = sheetObj.ColValueDup("trd_cd|rlane_cd|vsl_oshp_cd");
	   			if(Row != -1) {
	   				ComShowCodeMessage("COM12115", sheetObj.CellValue(Row, "rlane_cd")); 	 
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
		  //소계표현하기
		sheetObj.MessageText("SubSum") = "TTL";
		sheetObj.ShowSubSum("rlane_cd", "6", -1, false, false, 5);
	} 	
	
	
	/**
	 * OnSort 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {sheetObj} sheetObj 필수 IBSheet Object
	 * @param {Col} sort col
	 * @param {SortArrow} sorting ASC, DESC
	 * @return 없음
  	 * @author 임옥영
  	 * @version 2014.06.17
	 */
	 function sheet1_OnSort(sheetObj, Col, SortArrow) {		  
	  var formObj = document.form;
	  if(Col == 4) { 
		  formObj.f_sort.value = SortArrow;
		  doActionIBSheet(sheetObj,formObj,IBSEARCH);
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
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;

 		switch(colName)
     	{ 			
     		case "del_chk":
     			//merge 상태라서 해당 Row 는 삭제처리
//     			if(sheetObj.CellValue(Row, Col) == 1) {
//	     			sheetObj.CellValue2(Row-1, Col) = 1;
//	     			sheetObj.CellValue2(Row+1, Col) = 1;
//     			} else {
//     				sheetObj.CellValue2(Row-1, Col) = 0;
//	     			sheetObj.CellValue2(Row+1, Col) = 0;
//     			}
     			//첫번째 컬럼 선택시 header 변경 등의 오류 수정
     			var cur_merge_cd = sheetObj.CellValue(Row, "merge_cd");
     			var rcnt = sheetObj.RowCount + sheetObj.HeaderRows;
     			if(sheetObj.CellValue(Row, Col) == 1) {
     				if(Row-2 > 0 && (sheetObj.CellValue(Row-2, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row-2, Col) = 1;
     				if(Row-1 > 0 && (sheetObj.CellValue(Row-1, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row-1, Col) = 1;
     				if(Row+1 < rcnt && (sheetObj.CellValue(Row+1, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row+1, Col) = 1;
     				if(Row+2 < rcnt && (sheetObj.CellValue(Row+2, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row+2, Col) = 1;
     			} else {
     				if(Row-2 > 0 && (sheetObj.CellValue(Row-2, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row-2, Col) = 0;
     				if(Row-1 > 0 && (sheetObj.CellValue(Row-1, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row-1, Col) = 0;
     				if(Row+1 < rcnt && (sheetObj.CellValue(Row+1, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row+1, Col) = 0;
     				if(Row+2 < rcnt && (sheetObj.CellValue(Row+2, "merge_cd") == cur_merge_cd)) sheetObj.CellValue2(Row+2, Col) = 0;
     			}
                	
     			
     			
 				break; 	
 				
 				// Row Add 일때만 해당
     		case "trd_cd":
     			sheetObj.CellValue2(Row+1, Col) = Value;
     			sheetObj.CellValue2(Row+2, Col) = Value;     
     			

     			var param = "f_cmd="+SEARCHLIST11;
 				param = param + "&trd_cd="+sheetObj.CellValue(Row, Col);

 				var sXml = sheetObj.GetSearchXml("ESM_COA_0177GS.do", param);

 				var arrXml = sXml.split("|$$|");
 				if (arrXml.length > 0) {
 					ComCoaSetIBCombo(sheetObj, arrXml[0], "sub_trd_cd", true, 0, Row);
 				}
 				if (arrXml.length > 1) {
 					ComCoaSetIBCombo(sheetObj, arrXml[1], "rlane_cd", true, 0, Row);
 				}
 				break; 	

 	 			// Row Add 일때만 해당
     		case "sub_trd_cd":
     			sheetObj.CellValue2(Row+1, Col) = Value;
     			sheetObj.CellValue2(Row+2, Col) = Value; 
 				break; 	

 	 			// Row Add 일때만 해당
     		case "rlane_cd":
     			sheetObj.CellValue2(Row+1, Col) = Value;
     			sheetObj.CellValue2(Row+2, Col) = Value;  
     			sheetObj.CellValue2(Row, "merge_cd") = Value; 
     			sheetObj.CellValue2(Row+1, "merge_cd") = Value; 
     			sheetObj.CellValue2(Row+2, "merge_cd") = Value;     			
 				break; 	
 				
     		case "freq_no":
     			sheetObj.ShowSubSum("rlane_cd", "6", -1, false, false, 5);     			
 				break; 	
 				
 				
     	}
 	}

   
	/* 개발자 작업  끝 */
 