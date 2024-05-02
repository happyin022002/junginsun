/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0118.js
*@FileTitle : Terminal Internal Pricing (PA/RA) 
*Open Issues :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.09.28 박수훈
* 1.0 Creation
*Change history :
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.08.25 이윤정 [CHM-201005513] 현재 입력건의 경우 ESM_MAS_0118 화면상 "Curr."를 Local AMT가 아닌 Unit Cost에 대한 Curr.로 사용 변경
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.07.20 최성민 [CHM-201112295-01] [MAS] 내부거래단가 조건추가 : Actual Lane 정보
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
     * @class ESM_MAS_0118 : ESM_MAS_0118 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0118() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }


 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	var sheetObject = sheetObjects[0];
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {

    			case "btn_Retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

      			case "btn_rowadd":
	      				doActionIBSheet(sheetObject,formObject,IBINSERT);
	      			    break;

      			case "btn_rowdelete":
	      				doActionIBSheet(sheetObject,formObject,IBDELETE);
	      			    break;

    			case "btng_Save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;

    			case "btn_DownExcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    		} // end switch
    	} catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	} finally {
    		ComOpenWait(false);
    	}
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
    	
    	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    	
		ComSetFocus(document.form.f_cost_yrmon);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    	function initSheet(sheetObj,sheetNo) {
    		var cnt = 0;
    		switch(sheetNo) {
    			case 1:			//sheet1 init
    				with (sheetObj) {
    					style.height = GetSheetHeight(14) ;
    					SheetWidth = mainTable.clientWidth;//전체 너비 설정
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    					MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
    					Editable = true;//전체Edit 허용 여부 [선택, Default false]
    					InitRowInfo(2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitColumnInfo(15, 1, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitHeadMode(true, false, false, true, false, false);// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]

    					var HeadTitle0 = "|Sel.|YYYYMM|Terminal|S.Lane|TML Expense Account|TML Expense Account|Tariff Item|Tariff Item|Tariff Detail|Tariff Detail"
   						 + "|UOM\nSrc Code|TP/SZ|Curr.|Unit\nCost";
       					var HeadTitle1 = "|Sel.|YYYYMM|Terminal|S.Lane|Code|Desc.|Code|Desc.|Code|Desc."
   						 + "|UOM\nSrc Code|TP/SZ|Curr.|Unit\nCost";

       					
    					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle0, true);
    					InitHeadRow(1, HeadTitle1, true);

    					//데이터속성	DataRow, Col, [DataType], [Width], [DataAlign],
    					//					[ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
    					//					[PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
    					//					[ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
    					InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
    					InitDataProperty(0, cnt++, dtCheckBox,	   	40,	daCenter,	true,	"sel");
    					InitDataProperty(0, cnt++, dtData,	      	70,	daCenter,	true,	"cost_yrmon",			true,	"",	dfNone,			0,	false,	true,	6);
    					InitDataProperty(0, cnt++, dtCombo,	      	70,	daCenter,	true,	"tml_cd",				true,	"",	dfNone,			0,	false,	true,	7);
    					InitDataProperty(0, cnt++, dtCombo,	      	65,	daCenter,	true,	"uc_slan_cd",			true,	"",	dfNone,			0,	false,	true);
    					InitDataProperty(0, cnt++, dtCombo,	      	65,	daCenter,	true,	"mas_cost_src_cd",		true,	"",	dfNone,			0,	false,	true);
    					InitDataProperty(0, cnt++, dtData,	      	200,daLeft,		true,	"mas_cost_src_cd_nm",	false,	"",	dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++, dtCombo,	      	50,	daCenter,	true,	"tml_trf_itm_cd",		true,	"",	dfNone,			0,	false,	true);
    					InitDataProperty(0, cnt++, dtData,	      	140,daLeft,		true,	"tml_trf_itm_desc",		false,	"",	dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++, dtCombo,	      	50,	daCenter,	true,	"tml_trf_dtl_cd",		true,	"",	dfNone,			0,	false,	true);
    					InitDataProperty(0, cnt++, dtData,	      	140,daLeft,		true,	"tml_trf_dtl_desc",		false,	"",	dfNone,			0,	false,	false);
    					InitDataProperty(0, cnt++, dtHidden,      	70,	daCenter,	true,	"tml_ut_cd");
                                                                  
    					InitDataProperty(0, cnt++, dtCombo,	      	55,	daCenter,	true,	"cntr_tpsz_cd",			true,	"",	dfNone,			0,	false,	true);
    					InitDataProperty(0, cnt++, dtCombo,	      	50,	daCenter,	true,	"locl_curr_cd",			false,	"",	dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++, dtData,			80,	daRight,	true,	"tml_uc_amt",			false, 	"", dfNullFloatOrg,	2,	true,	true);
    					
    					RangeBackColor(1, 2, 1, 9) = RgbColor(222, 251, 248);  // ENIS

    					HeadRowHeight = 10;
    					CountPosition	= 0 ;
    					
    					InitDataValid(0, "cost_yrmon", 		vtNumericOnly);
    					//InitDataValid(0, "tml_cd", vtEngUpOther, "0123456789");
    					//InitDataValid(0, "tml_trf_itm_cd", vtEngUpOther, "0123456789");
    					//InitDataValid(0, "tml_trf_dtl_cd", vtEngUpOther, "0123456789");
    					WaitImageVisible = false;
    				}
    				break;
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
     * Sheet 관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {
	    	case IBCLEAR:    	
				ComOpenWait(true);
				var sXml = document.form.sXml.value; 				
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 0) {
					ComMasSetIBCombo(sheetObj, arrXml[0], "tml_cd", true, 0);
				}
				if (arrXml.length > 1) {
					ComMasSetIBCombo(sheetObj, arrXml[1], "cntr_tpsz_cd", true, 0);
				}
				if (arrXml.length > 2) {
					ComMasSetIBCombo(sheetObj, arrXml[2], "mas_cost_src_cd", true, 0, 0,"","", true);
				}
				if (arrXml.length > 3) {
					ComMasSetIBCombo(sheetObj, arrXml[3], "locl_curr_cd", true, 0);
				}
				if (arrXml.length > 4) {
					ComMasSetIBCombo(sheetObj, arrXml[4], "tml_trf_itm_cd", true, 0, 0,"","", true);
				}
				if (arrXml.length > 5) {
					ComMasSetIBCombo(sheetObj, arrXml[5], "tml_trf_dtl_cd", true, 0, 0,"","", true);
				}
				if (arrXml.length > 6) {
					ComMasSetIBCombo(sheetObj, arrXml[6], "uc_slan_cd", true, 0);
				}
				formObj.sXml.value="";
				ComOpenWait(false);
				break;
				
	    	case IBSEARCH:			//조회
  				if(!validateForm(sheetObj,formObj,sAction)){
  					return false;
  				}
  				
				// 업무처리중 버튼사용 금지 처리
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_MAS_0118GS.do", masFormQueryString(formObj));				
    			break;

    		case IBSAVE:			//저장				
  				if(!validateForm(sheetObj,formObj,sAction)){
  					return false;
  				}
  				
  				ComOpenWait(true);
  								
				//tml_ut_cd 데이터 세팅
				var tmlUtCd = "";
				for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
					if(sheetObj.RowStatus(i) == "I") {    						
						tmlUtCd =   sheetObj.CellValue(i, "tml_cd") + 
									sheetObj.CellValue(i, "mas_cost_src_cd") + 
									ComRpad(sheetObj.CellValue(i, "tml_trf_itm_cd"),4,"#") +
									ComRpad(sheetObj.CellValue(i, "tml_trf_dtl_cd"),4,"#");
						
						sheetObj.CellValue2(i, "tml_ut_cd") = tmlUtCd;
					}
				}
				
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESM_MAS_0118GS.do", masFormQueryString(formObj));		
    			break;

  			case IBINSERT:	//행 추가
  				var fCostYrmon = formObj.f_cost_yrmon.value;
  				var row = sheetObj.DataInsert(-1);
  				
  				if(fCostYrmon != "") {
  					sheetObj.CellValue2(row, "cost_yrmon") = fCostYrmon.replace("-","");
  				}
  				
  				sheetObj.SelectCell(row, "tml_cd");
  				break;
  				  				
			case IBDELETE: // Delete
				var iCheckRow = sheetObj.FindCheckedRow("sel");
				if(iCheckRow == ""){
					sheetObj.CellValue2(sheetObj.SelectRow,"sel")= "1";
				}
				iCheckRow = sheetObj.FindCheckedRow("sel");	
				
				if(iCheckRow != "") {
					ComRowHideDelete(sheetObj, "sel");
				}				
				break;
				
    		case IBDOWNEXCEL:	//엑셀 다운로드
    			var excelType = selectDownExcelMethod(sheetObj);
    			switch (excelType) {
    				case "AY":
    					sheetObj.Down2Excel(0, false, false, true);
    					break;
    				case "DY":
    					sheetObj.Down2Excel(-1, false, false, true);
    					break;
    				case "AN":
    					sheetObj.SpeedDown2Excel(0, false, false);
    					break;
    				case "DN":
    					sheetObj.SpeedDown2Excel(-1, false, false);
    					break;
    			}
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
     * @version 2011.07.15
     */  
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		
 		switch(colName)
     	{
 			case "mas_cost_src_cd":
 	    		if (Value != ""){
 	    			// DESC 세팅
 	    			var sText 	= sheetObj.GetComboInfo(Row, Col, "Text");
 	    			var arrText = sText.split("|"); 	    			
 	    			var sIdx 	= sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
 	    			var sDesc 	= arrText[sIdx].split("\t");
 	    			sheetObj.CellValue2(Row, "mas_cost_src_cd_nm") = sDesc[1];
 	    			 	
 	    			//Tariff Item 세팅
 	    			var sParam = "f_cmd=" + SEARCHLIST10;
 	    			sParam = sParam + "&tml_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "tml_cd");
 	    			sParam = sParam + "&mas_cost_src_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "mas_cost_src_cd");
 	    			var sXml = sheetObj.GetSearchXml("ESM_MAS_0118GS.do", sParam);
 	    			var arrXml = sXml.split("|$$|");
 	    			if (ComGetTotalRows(arrXml[0]) > 0) {
 	    				ComMasSetIBCombo(sheetObj, arrXml[0], "tml_trf_itm_cd", true, 0, Row,"","", true);
 	    			} else {
 	    				sheetObj.CellComboItem(Row,"tml_trf_itm_cd", " ", " ");
 	    			} 	    			
 	    		} else {
 	    			sheetObj.CellValue2(Row, "mas_cost_src_cd_nm") = "";
 	    		}
 	    		
 	    		//리프 트리까지 콤보 초기화
 	    		sheetObj.CellValue2(Row, "tml_trf_itm_cd") = "";
 	    		sheetObj.CellValue2(Row, "tml_trf_itm_desc") = "";
 	    		sheetObj.CellValue2(Row, "tml_trf_dtl_cd") = "";
 	    		sheetObj.CellValue2(Row, "tml_trf_dtl_desc") = "";
 	    		
 	    		break;
 	    		
    		case "tml_trf_itm_cd":
 	    		if (Value != ""){
 	    			// DESC 세팅
 	    			var sText 	= sheetObj.GetComboInfo(Row, Col, "Text");
 	    			var arrText = sText.split("|"); 	    			
 	    			var sIdx 	= sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
 	    			var sDesc 	= arrText[sIdx].split("\t");
 	    			sheetObj.CellValue2(Row, "tml_trf_itm_desc") = sDesc[1];
 	    			 	
 	    			//Tariff Detail 설정
 	    			var sParam = "f_cmd=" + SEARCHLIST11;
 	    			sParam = sParam + "&tml_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "tml_cd");
 	    			sParam = sParam + "&mas_cost_src_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "mas_cost_src_cd");
 	    			sParam = sParam + "&tml_trf_itm_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "tml_trf_itm_cd");
 	    			var sXml = sheetObj.GetSearchXml("ESM_MAS_0118GS.do", sParam);
 	    			var arrXml = sXml.split("|$$|");
 	    			
 	    			if (ComGetTotalRows(arrXml[0]) > 0) {
 	    				ComMasSetIBCombo(sheetObj, arrXml[0], "tml_trf_dtl_cd", true, 0, Row,"","", true);
 	    			} else {
 	    				sheetObj.CellComboItem(Row,"tml_trf_dtl_cd", " ", " ");
 	    			}
 	    		} else {
 	    			sheetObj.CellValue2(Row, "tml_trf_itm_desc") = "";
 	    		}
 	    		
 	    		//리프 트리까지 콤보 초기화
 	    		sheetObj.CellValue2(Row, "tml_trf_dtl_cd") = "";
 	    		sheetObj.CellValue2(Row, "tml_trf_dtl_desc") = "";
 	    		break;

    		case "tml_trf_dtl_cd":
 	    		if (Value != ""){
 	    			// DESC 세팅
 	    			var sText 	= sheetObj.GetComboInfo(Row, Col, "Text");
 	    			var arrText = sText.split("|"); 	    			
 	    			var sIdx 	= sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
 	    			var sDesc 	= arrText[sIdx].split("\t");
 	    			sheetObj.CellValue2(Row, "tml_trf_dtl_desc") = sDesc[1]; 	    			 
 	    		} else {
 	    			sheetObj.CellValue2(Row, "tml_trf_dtl_desc") = "";
 	    		}
 	    		break;
 	    		
    		case "tml_cd":
 	    		if (Value != "" && sheetObj.CellValue(Row, "mas_cost_src_cd") != ""){
 	    			// TML Expense Account 선택후 Terminal 를 수정할 수도 있으므로 ...
 	    			//Tariff Item 세팅
 	    			var sParam = "f_cmd=" + SEARCHLIST10;
 	    			sParam = sParam + "&tml_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "tml_cd");
 	    			sParam = sParam + "&mas_cost_src_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "mas_cost_src_cd");
 	    			var sXml = sheetObj.GetSearchXml("ESM_MAS_0118GS.do", sParam);
 	    			var arrXml = sXml.split("|$$|");
 	    			if (arrXml.length > 0) {
 	    				ComMasSetIBCombo(sheetObj, arrXml[0], "tml_trf_itm_cd", true, 0, Row,"","", true);
 	    			} else {
 	    				sheetObj.CellComboItem(Row,"tml_trf_dtl_cd", "", "");
 	    				sheetObj.CellComboItem(Row,"tml_trf_itm_cd", "", "");
 	    			}
 	    		}
 	    		
 	    		break;
 	    		
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
   	 * @version 2011.07.15
     */
 	function validateForm(sheetObj, formObj, sAction) {

 		switch (sAction) {
 			case IBSEARCH: // 조회
 				if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
 					ComShowCodeMessage('COM12180');
 					ComSetFocus(formObj.f_cost_yrmon);
 					return false;
 	    		}		
 				break;
 				
 	  		case IBSAVE: 	
 	  			if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
 					ComShowCodeMessage('COM12180');
 					ComSetFocus(formObj.f_cost_yrmon);
 					return false;
 	    		} 	  			
 				break;
 		}
 		return true;
 	}

