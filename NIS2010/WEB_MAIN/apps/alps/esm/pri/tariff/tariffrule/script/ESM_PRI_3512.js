/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3512.js
*@FileTitle : Tariff Rule Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.20
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.20 최성민
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
     * @class ESM_PRI_3512 : ESM_PRI_3512 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3512() {
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

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch (srcName) {
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCREATE);
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_openc":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC03);
					break;

				case "btn_history":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
					break;

				case "btn_print":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC02);
					break;

			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

  /**
	* IBSheet Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
   	* @author 최성민
   	* @version 2010.10.13
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
  /**
	* IBCombo Object를 배열로 등록 <br>
	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	* 배열은 소스 상단에 정의 <br>
	* <br><b>Example :</b>
	* <pre>
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj 필수 IBCombo Object
	* @return 없음
   	* @author 최성민
   	* @version 2010.10.13
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

   /**
    * Sheet 기본 설정 및 초기화 <br>
    * body 태그의 onLoad 이벤트핸들러 구현 <br>
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 최성민
    * @version 2010.10.13
    */
	function loadPage() {
		var formObj = document.form;
		
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
	    
	    //Axon 이벤트 초기화
	    initControl();
	    
	    //Tariff Code Combo 세팅
	    ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );	
	    //Status Code Combo 세팅
	    ComPriTextCode2ComboItem(trfRuleStsCdComboValue, trfRuleStsCdComboText, getComboObject(comboObjects, 'trf_rule_sts_cd'),"|","\t" );
	    //초기값
	    //comboObjects[1].Code2 = "F";
		
	    formObj.tariff_cd.focus();		
	}
	
    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */ 	    
     function initControl() {
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
        axon_event.addListenerForm('beforeactivate', 'obj_onActivate', document.form);
        //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_onKeypress', document.form);               
        //axon_event.addListener ('keyup', "ComKeyEnter('LengthNextFocus')", document.form);        
        //axon_event.addListener('change', 'rf_flg_OnChange', 'rf_flg');
        //axon_event.addListener('change', 'trf_rule_ctnt_onChange', 'trf_rule_ctnt');
        //axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);        
        axon_event.addListenerFormat ('keydown', 'obj_onKeydown', document.form);
        
     }
	
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
         	case "sheet1":
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 250;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle = "Flag|Seq.|Rule\nNo.|Rule Name|Charge\nCode|Amend\nType|Approval\nOffice|Creation\nDate|Effective\nDate|Expiration\nDate|Publish\nDate|Amend\nNo. " +
                     		"|Status|Request\nOffice|Creation\nStaff" +
                     		"|1|2|3|4|5|6";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, false);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,			40,   	daCenter,  	false,	"seq");
 					 InitDataProperty(0, cnt++ , dtData,	   		70,		daLeft,		false,	"trf_rule_no",			false,	"",	dfNone, 			0,     false,	false,	10);
                     InitDataProperty(0, cnt++ , dtData,			160,  	daLeft,		false,	"trf_rule_nm",  		false,	"",	dfNone,				0,     false,	false,	100);
                     InitDataProperty(0, cnt++ , dtCombo,			50,  	daCenter,	false,	"trf_rule_chg_cd",     	false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,			50,  	daCenter,	false,	"trf_rule_amdt_tp_cd",  false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtCombo,  	    	70,   	daCenter, 	false,	"apro_ofc_cd",      	false,	"",	dfNone, 			0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,			70,  	daCenter,	false,	"cre_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,			70,  	daCenter, 	false,	"eff_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,			70,  	daCenter, 	false,	"exp_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,			70,  	daCenter, 	false,	"pub_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,			50,  	daCenter, 	false,	"amdt_seq",     		false,	"",	dfNone, 		 	0,     false,	false);

                     InitDataProperty(0, cnt++ , dtCombo,			60,  	daCenter, 	false,	"trf_rule_sts_cd",     	false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,			60,  	daCenter, 	false,	"rqst_ofc_cd",     		false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,    		90,   	daCenter, 	false,	"cre_usr_id",     		false,	"",	dfNone, 			0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"trf_pfx_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"trf_no");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"trf_rule_ctnt");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"bef_trf_rule_ctnt");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"amdt_flg");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"upd_dt");
                     
                     InitDataCombo(0, "trf_rule_chg_cd", trfRuleChgCdComboText, trfRuleChgCdComboValue);
                     InitDataCombo(0, "trf_rule_amdt_tp_cd", trfRuleAmdtTpCdComboText, trfRuleAmdtTpCdComboValue);
                     InitDataCombo(0, "trf_rule_sts_cd", trfRuleStsCdComboText, trfRuleStsCdComboValue);
                     InitDataCombo(0, "apro_ofc_cd", aproOfcCdComboText, aproOfcCdComboValue);
                    
 					 //InitDataValid(0, "trf_rule_no", 				vtEngUpOther, "1234567890-");

			 		 //ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
			 		 //CountPosition = 0;		// Total 숨김
			 		 //ImageList(0) = "img/btns_calendar.gif";
			 		 //PopupButtonImage(0, "cre_dt") = 0;
			 		 //PopupButtonImage(0, "eff_dt") = 0;
			 		 //PopupButtonImage(0, "exp_dt") = 0;
	                 WaitImageVisible = false;
	                 
	                 //영역 다중 선택 가능 여부 설정하기
	                 MultiSelection = false;
	                 
	                 //MultiSelection=false 이면 1개의 행만 선택 가능 
	                 SelectionMode = smSelectionRow; //1
	                 
	                 //Row Height 가 늘어나는것을 방지
	                 AutoRowHeight = false;

         		}
              	break;
     	}
	}
	
   /**
    * IBCOMBO를 초기화하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} comboObj 필수 IBMultiCombo Object
    * @param {int} comboNo 필수 IBMultiCombo의 순번
    * @return 없음
    * @author 최성민
    * @version 2010.10.13
    */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "tariff_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 8;
	            	UseAutoComplete = true;
	            	
	            	ValidChar(2, 3);	//영어 대문자, 숫자+특수문자 포함
	            }
	            break;
	        case "trf_rule_sts_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	MaxLength = 10;
	            	UseAutoComplete = true;
	            	
	            	ValidChar(1, 0);	//영문만 입력
	            }
	            break;	
	    }
	}

  /**
   * Sheet관련 프로세스 처리 <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {form} formObj 필수 html form object
   * @param {int} sAction 필수 프로세스 플래그 상수
   * @return 없음
   * @author 최성민
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) { 				
	 			case IBSEARCH: // 조회
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	  				ComOpenWait(true);
	  				formObj.rule_ctnt.value = "";
		 			formObj.f_cmd.value = SEARCH01;
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3512GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
	 				break;

	 			case IBCREATE: // New
	 				comboObjects[0].Index = -1;
	 				comboObjects[1].Index = -1;
					formObj.trf_pfx_cd.value = "";
					formObj.trf_no.value = "";	
					formObj.trf_rule_no.value = "";
					formObj.rule_ctnt.value = "";
					formObj.trf_rule_ctnt.value = "";
					sheetObj.RemoveAll();
					formObj.tariff_cd.focus();
					break;
									
				case IBSEARCH_ASYNC01: // History
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}			
				
		 			var pgmNo = "ESM_PRI_3509";
		 			var pgmUrl = "/hanjin/ESM_PRI_3509.do"
		    		var params = "&trf_pfx_cd="+sheetObj.cellValue(sheetObj.selectRow, "trf_pfx_cd");
		 				params += "&trf_no="+sheetObj.cellValue(sheetObj.selectRow, "trf_no");
		 				params += "&trf_rule_no="+sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_no");
		 						 				
					var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		 			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
					var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
					var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);	            
					break;

				case IBSEARCH_ASYNC02: // Print
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}

					var sParam = "trf_pfx_cd=" + sheetObj.cellValue(sheetObj.selectRow, "trf_pfx_cd")
			    		+ "&trf_no="   + sheetObj.cellValue(sheetObj.selectRow, "trf_no")
			    		+ "&amdt_seq=" + sheetObj.cellValue(sheetObj.selectRow, "amdt_seq")
			    		+ "&trf_rule_no=" + sheetObj.cellValue(sheetObj.selectRow, "trf_rule_no");
					
					var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_3508.do?"+sParam, "", 1024, 700, true);
					break;
					
				case IBSEARCH_ASYNC03: // Open Creation
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}			
				
		 			var pgmNo = "ESM_PRI_3507";
		 			var pgmUrl = "/hanjin/ESM_PRI_3507.do";
		    		var params = "&trf_pfx_cd="+sheetObj.cellValue(sheetObj.selectRow, "trf_pfx_cd");
		 				params += "&trf_no="+sheetObj.cellValue(sheetObj.selectRow, "trf_no");
		 				params += "&trf_rule_no="+sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_no");
		 						 				
					var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		 			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
					var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
					var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);	            
					break;
	 		}
 		}catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e);
 			}
 		}finally {
 			 ComOpenWait(false);
 		}
 	}
 	
	
   /**
    * OnClick 이벤트 발생시 호출되는 function <br>
    * sheet의 Row를 선택하면 Contents 입출력, 버튼 컨트롤, 권한 컨트롤 등을 관리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
   	* @author 최성민
   	* @version 2010.10.13
    */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj = document.form;

		if (OldRow != NewRow) {
				//Contents 입출력관리
				setRuleContents(sheetObj, NewRow, NewCol);
				
		}
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
   	 * @version 2010.10.13
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;
 		
 		if(sheetObj.RowCount < 1) {
 			formObj.rule_ctnt.value = "";
 		}
 	}
 	
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Status 상황에 따라서 Rule Contents 의 입출력을 세팅한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 최성민
     * @version 2010.10.13
     */	
 	function setRuleContents(sheetObj, NewRow, NewCol)  { 		
 		var formObj = document.form; 		
 		var aCtnt = sheetObj.CellValue(NewRow, "trf_rule_ctnt");
 	
 		if(sheetObj.RowCount > 0) {
 			formObj.rule_ctnt.scrollTop = 0; 			
			formObj.rule_ctnt.value = aCtnt;
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
   	 * @version 2010.10.13
     */
	function validateForm(sheetObj, formObj, sAction) {

		switch (sAction) {
 		case IBSEARCH: // 조회
 			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			}
			break;

		case IBCREATE: // New
			break;

   		case IBSEARCH_ASYNC01:
   			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			}
   			
   			if (sheetObj.RowCount < 1) {
   				ComShowCodeMessage("PRI00337","Rule No.");
 				return false;
 			}
 			break;

   		case IBSEARCH_ASYNC02:
   			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			}
   			
   			if (sheetObj.RowCount < 1) {
   				ComShowCodeMessage("PRI00337","Rule No.");
 				return false;
 			}
 			break;

   		case IBSEARCH_ASYNC03:
   			if (comboObjects[0].Code == "") {
 				ComShowCodeMessage("PRI00308","select", "Tariff Code");
 				formObj.tariff_cd.focus();
				return false;
			}
   			
   			if (sheetObj.RowCount < 1) {
   				ComShowCodeMessage("PRI00337","Rule No.");
 				return false;
 			}
 			break;

 			
 		}

 		return true;
 	}
	
   	/**
   	 * OnChange 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function tariff_cd_OnChange(comboObj, code, text) {
   		var formObj = document.form;
   		
   		var arrText = text.split("|");
   		if (arrText != null && arrText.length > 1) {
			var arr = code.split("-");				
			formObj.trf_pfx_cd.value = arr[0];
			formObj.trf_no.value = arr[1];
		
 			//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
   		}
   	}

   	/**
   	 * OnClear 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function tariff_cd_OnClear(comboObj) {
   		var formObj = document.form;		
   		comboObj.Index = -1;
   	}
   	
	
   	/**
   	 * OnKeyDown 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function tariff_cd_OnKeyDown(comboObj, KeyCode) {
   		var formObj = document.form;
   		if (KeyCode == 13){   		
		 	if (comboObj.Index > -1){	
			   	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
   		}
   	}
   	
   	/**
   	 * OnKeyDown 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function trf_rule_sts_cd_OnKeyDown(comboObj, KeyCode) {
   		var formObj = document.form;
   		if (KeyCode == 13){   		
		   	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   		}
   	}

   	
   	/**
   	 * OnChange 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	/*
   	function trf_rule_sts_cd_OnChange(comboObj, code, text) {
   		var formObj = document.form;
   		
   		var arrText = text.split("|");
   		if (arrText != null && arrText.length > 1) {   			
 			//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
   		}
   	}
   	*/
   	     
     /**
      * OnKeyPress event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_onKeypress()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 최성민
      * @version 2010.10.13
      */ 
	function obj_onKeypress() {
        switch (event.srcElement.dataformat) {  
	        case "engup":
	            if (event.srcElement.name == "trf_rule_no") {
	                ComKeyOnlyAlphabet('uppernum',"45");
	            }    
	            break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            case "float":
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "ymd":
            	ComKeyOnlyNumber(event.srcElement, "-");
                break;
            default:
        }
    }    
	
   /**
    * OnBeforeActivate   event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_onActivate()
    * </pre>
    * @param 없음
    * @return 없음
      * @author 최성민
      * @version 2010.10.13
    */   
    function obj_onActivate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);
    }
    

   /**
    * OnKeyDown event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param 없음
    * @return 없음
   	* @author 최성민
   	* @version 2010.10.13
    */  
	function obj_onKeydown(){
		//Proposal No,S/C No. 에서 Enter key조회
	 	var eleName = event.srcElement.name;
	 	if (eleName == "trf_rule_no" || eleName == "trf_rule_ctnt"){
		 	var keyValue = null;
			if(event == undefined || event == null) {
		    	keyValue = 13;
			}else{
		    	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		  	}
		   	if (keyValue == 13){
		    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		  	}
		}
	}
	
   	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    tariff_cd_OnBlur(comboObj);
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */   	
   	function tariff_cd_OnBlur(comboObj) {
   		var formObj = document.form;
   		
   		var code = comboObj.FindIndex(comboObj.Code, 0);
   				
   		if (code != null && code != "") {
   	   		var arr = code.split("-");				
   			formObj.trf_pfx_cd.value = arr[0];
   			formObj.trf_no.value = arr[1];
   		}
   	}
   	
   	/**
   	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    trf_rule_sts_cd_OnBlur(comboObj);
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */   	
   	function trf_rule_sts_cd_OnBlur(comboObj) {
   		var formObj = document.form;
   		
   		var code = comboObj.FindIndex(comboObj.Code, 0);
   				
   		if (code != null && code != "") {
   			var text = comboObj.GetText(code, 1); 
   		}
   	}
 
	/* 개발자 작업  끝 */