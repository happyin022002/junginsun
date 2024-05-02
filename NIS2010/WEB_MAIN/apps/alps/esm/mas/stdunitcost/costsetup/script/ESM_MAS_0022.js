/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_MAS_0022.js
*@FileTitle : MTY Reposition Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.07
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.12.07 송호진
* 1.0 Creation
=========================================================
* History
* 2012.12.13 송호진 [CHM-201221879] [MAS] Manual Cost Set up 화면 로직 수정 ( 파일 신규 생성 )
* 2013.02.19 서미진 [CHM-201323054] Creation Date 기준 MT Invoicing AMT 컬럼 추가
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
     * @class ESM_MAS_0022 : ESM_MAS_0022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0022() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
        this.doActionIBSheet2   = doActionIBSheet2   ;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;
    var beforetab2 = 1;
    
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

		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		
  		var obj = document.form.f_yearweek;
  		obj.value = document.form.f_cost_yrmon.value;
  		obj.value = ComGetMaskedValue(obj.value,"ym");
  		setPeriod(obj);
  		
  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		ComEtcDataToForm(document.form,sheetObjects[0]);
  		
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
  				if (tab_selno == 0) { //첫번째 탭이면
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  				} else { //아니면
  					doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
  				}
 				break;

  			case "btn_create":
				doActionIBSheet(sheetObject,formObject,IBCREATE);
  				break;
  				
  			case "btn_down_excel":
  				 if (tab_selno == 0) { //첫번째 탭이면
 					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
 				} else {
 					doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
 				}
  				break;      	
  				

  			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
  				break;
  				
  			case "btn_Close": 				
				window.opener.getRetrieve();
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
   	 * IBTab Object를 배열로 등록
   	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
   	 * 배열은 소스 상단에 정의
   	 */
   	function setTabObject(tab_obj) {
   		tabObjects[tabCnt++] = tab_obj;

   	}
	
	/**
   	 * Tab 기본 설정
   	 * 탭의 항목을 설정한다.
   	 */
   	function initTab(tabObj, tabNo) {
   		switch (tabNo) {
   		case 1:
   			with (tabObj) {
   	            var cnt  = 0 ;
   	            InsertTab( cnt++ , "Reposition Cost Detail" , -1 );
   	            InsertTab( cnt++ , "Interface Data" , -1 );
   			}
   			break;

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
	  				style.height = GetSheetHeight(18) ;
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
	  				InitRowInfo(2, 1, 1, 100);
	
					var HeadTitle1 = "|Sel|Apply to\nAdjusted P&L|cost_yrmon|WK|sls_fm_dt|MT Invoicing AMT (MAS)|MT Invoicing AMT (MAS)|MT Invoicing AMT (MAS)" +
							             "|MT Invoicing AMT (TES/TRS)\n(Approval Date)|MT Invoicing AMT (TES/TRS)\n(Approval Date)|MT Invoicing AMT (TES/TRS)\n(Approval Date)" +
					                     "|MT Invoicing AMT (TES/TRS)\n(Creation Date)|MT Invoicing AMT (TES/TRS)\n(Creation Date)|MT Invoicing AMT (TES/TRS)\n(Creation Date)" ;
					var HeadTitle2 = "|Sel|Apply to\nAdjusted P&L|cost_yrmon|WK|sls_fm_dt|TES|TRS|Total|TES|TRS|Total|TES|TRS|Total" ;
					
	  				var headCount = ComCountHeadTitle(HeadTitle1);
	
	  				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  				InitColumnInfo(headCount, 0, 0, true);
	
	  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, true, true, false, false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
	
	  				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  				InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,		50,		daCenter,	false,	"ibflag");
  					InitDataProperty(0, cnt++ , dtCheckBox,			40,		daCenter,	true,	"sel_flg",			false,	"",		dfNone,		0,	true,		true ); 
  					InitDataProperty(0, cnt++ , dtCheckBox,			100,	daCenter,	true,	"aply_adj_pl_flg",	false,	"",		dfNone,		0,	true,		true ); 
  					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	"cost_yrmon",		false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	true,	"cost_wk",			false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		true,	"sls_fm_dt",		false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtAutoSum,			80,		daRight,	false,	"mty_tml_mnl_amt",	false,	"",		dfInteger,	0,	true,		true, 9);
  					InitDataProperty(0, cnt++ , dtAutoSum,			80,		daRight,	false,	"mty_trsp_mnl_amt",	false,	"",		dfInteger,	0,	true,		true, 9);
  					InitDataProperty(0, cnt++ , dtAutoSum,			80,		daRight,	false,	"mty_ttl_mnl_amt",	false,	"|6|+|7|",		dfInteger,	0,	false,		false, 9);
  					InitDataProperty(0, cnt++ , dtAutoSum,			80,		daRight,	false,	"mty_tml_if_amt",	false,	"",		dfInteger,	0,	false,		false, 9);
  					InitDataProperty(0, cnt++ , dtAutoSum,			80,		daRight,	false,	"mty_trsp_if_amt",	false,	"",		dfInteger,	0,	false,		false, 9);
  					InitDataProperty(0, cnt++ , dtAutoSum,			80,		daRight,	false,	"mty_ttl_if_amt",	false,	"",		dfInteger,	0,	false,		false, 9);
  					InitDataProperty(0, cnt++ , dtAutoSum,			80,		daRight,	false,	"mty_tml_cre_bse_if_amt",	false,	"",		dfInteger,	0,	false,		false, 9);
  					InitDataProperty(0, cnt++ , dtAutoSum,			80,		daRight,	false,	"mty_trsp_cre_bse_if_amt",	false,	"",		dfInteger,	0,	false,		false, 9);
  					InitDataProperty(0, cnt++ , dtAutoSum,			80,		daRight,	false,	"mty_ttl_cre_if_amt",	false,	"",		dfInteger,	0,	false,		false, 9);

  					WaitImageVisible = false;  					
  				}
  				break;

  			case 2:		//sheet2 init
  				with (sheetObj) {

	  				// 높이 설정
	  				style.height = GetSheetHeight(18) ;
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
	
					var HeadTitle1 = "Year|R.Month|I/F Week|MT Steve|MT Trans|Total" ;
					
	  				var headCount = ComCountHeadTitle(HeadTitle1);
	
	  				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  				InitColumnInfo(headCount, 0, 0, true);
	
	  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, true, true, false, false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
	
	  				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  				InitHeadRow(0, HeadTitle1, true);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//  					InitDataProperty(0, cnt++ , dtHiddenStatus,		50,		daCenter,	false,	"ibflag");
  					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"cost_yr",			false,	"",		dfNone,		0,	true,		true ); 
  					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"rev_mon",	false,	"",		dfNone,		0,	true,		true ); 
  					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,	"cost_wk",		false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,			110,		daRight,	true,	"mt_steve",			false,	"",		dfInteger,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,			110,		daRight,		true,	"mt_trans",		false,	"",		dfInteger,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,			120,		daRight,	false,	"ttl_amt",	false,	"",		dfInteger,	2,	true,		true, 9);

  					WaitImageVisible = false;  					
  				}
  				break;
  		}
  	}
   
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
            
            case IBSEARCH:      //결과조회

                ComOpenWait(true);
                
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch("ESM_MAS_0022GS.do", masFormQueryString(formObj));
                
                //Deferred Expense를 위한 값 추출
                ComOpenWait(false);
                break;
            
            case IBCREATE:      //생성
            
                if (!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }

            	if (!ComShowCodeConfirm("MAS10020")) {
            		return false;
            	}

				ComOpenWait(true);				
				formObj.f_cmd.value = MULTI01;
				var sParam = masFormQueryString(formObj);
 				var sParamSheet = sheetObj.GetSaveString();
  				if (sParamSheet != "") {
  					sParam += "&" + sParamSheet;
  				}

				ComOpenWait(true);
 				var sXml = sheetObj.GetSaveXml("ESM_MAS_0022GS.do", sParam);
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				sheetObj.LoadSaveXml(sXml);				
				
				break;
              			
            case IBSAVE:	//저장
            	if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
            					
				
				if (!ComShowCodeConfirm("MAS00006")) {
					return false;
				}
								
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI02;
				sheetObj.DoSave("ESM_MAS_0022GS.do", masFormQueryString(formObj),-1,false);
				ComOpenWait(false);
				
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
  				
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
            
            case IBSEARCH:      //결과조회

                ComOpenWait(true);
                
                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoSearch("ESM_MAS_0022GS.do", masFormQueryString(formObj));
                
                //Deferred Expense를 위한 값 추출
                ComOpenWait(false);
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
  				
        }
    }

  	function setPeriod(obj){		
  	    ComMasSetPeriod2(obj);
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
    * @version 2012.12.13
    */
	function validateForm(sheetObj, formObj, sAction) {

		switch (sAction) {
		case IBSEARCH: // 조회
			break;

  		case IBCREATE:
   			if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
				return false;
			} 
   			
   			if (!sheetObj.IsDataModified) {
				ComShowCodeMessage("MAS00007");
				return false;
			}
   			
   			if(sheetObj.CheckedRows("sel_flg") < 1) {
				ComShowCodeMessage("MAS10015", "Sel");
   				return false;
   			}
			break; 	
			
  		case IBSAVE:
   			if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
				return false;
			} 
   			
   			if (!sheetObj.IsDataModified) {
				ComShowCodeMessage("MAS00007");
				return false;
			}
   			

			for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {				
				if(sheetObj.CellValue(i, "sel_flg") == "1" && sheetObj.CellValue(i, "mty_inv_amt") == 0) {
					ComShowCodeMessage("MAS10015", "MT Invoicing AMT(TES/TRS)");
	   				return false;
				} 
			}
			
			break; 			
			
		}

		return true;
	}
   

  /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   */
   function sheet1_OnSearchEnd(sheetObj, errMsg){
       sheetObj.SumText(0,"aply_adj_pl_flg") = "TOTAL";       
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
    * @version 2012.12.13
    */
//	function sheet1_OnChange(sheetObj, Row, Col, Value) {
//    	var colName = sheetObj.ColSaveName(Col);
//		var formObj = document.form;
//
//		switch(colName)
//    	{			
//    		case "sel_flg":
//				if(sheetObj.CellValue(Row, Col) == "1") {
//					sheetObj.CellEditable(Row,"aply_adj_pl_flg") = false;
//					sheetObj.CellEditable(Row,"otr_expn_amt") = false;
//				} else {
//					sheetObj.CellEditable(Row,"aply_adj_pl_flg") = true;
//					sheetObj.CellEditable(Row,"otr_expn_amt") = true;
//				}
//				
//				break;			
//    	}
//	}
//	
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 최성민
     * @version 2012.12.13
     */ 		
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
		var formObj = document.form;		
		//Sel에 Checked Data가 존재하면 재조회
		if(formObj.f_cmd.value == MULTI02 && sheetObj.CheckedRows("sel_flg") > 0) {
			doActionIBSheet(sheetObj,document.form,IBSEARCH);
		}
	}
	
	/**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj, nItem) {
    	var formObj = document.form;
      var objs = document.all.item("tabLayer");
      
      objs[nItem].style.display = "inline";
      objs[beforetab].style.display = "none";
      
      //--------------- 요기가 중요 --------------------------------//
      objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
      //----------------------------------------------------------//
      beforetab = nItem;
      
      tab_selno = nItem;

      if (tab_selno == 0) { 
    	  ComBtnEnable("btn_create");
    	  ComBtnEnable("btn_save");
      } else {
    	  ComBtnDisable("btn_create");
    	  ComBtnDisable("btn_save"); 
      }
      
    }
    
    /**
     * BackEndJob 실행결과조회<br>
     * 
     * @param sheetObj
     * @param sKey
     */
    function doActionValidationResult(sheetObj, sKey) {
    	var sXml = sheetObj.GetSearchXml("ESM_MAS_0022GS.do?f_cmd=" + COMMAND02 + "&key=" + sKey);
    	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

    	if (sJbStsFlg == "SUCCESS") {
    		// 성공메시지 보여주고
    		clearInterval(intervalId);    		
    		doActionIBSheet(sheetObj, document.form, IBSEARCH);
    		ComShowMessage(ComGetMsg("MAS00004","Data"));    		
    		ComOpenWait(false);
    	} else if (sJbStsFlg == "FAIL") {
    		//에러
    		ComOpenWait(false);
    		// 에러메시지 보여주고
    		ComShowMessage(ComGetMsg("MAS00001"));
    		clearInterval(intervalId);
    	}
    }

    
	
   
	/* 개발자 작업  끝 */