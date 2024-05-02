/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3507.js
*@FileTitle : Tariff Rule Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.06 최성민
* 1.0 Creation
=========================================================
* History
* 2011.04.19 이행지 [CHM-201110201-01] Tariff Rule 관련 Status 변경 관리자 기능 추가 요청
*                                  - SuperUser일 경우 Publish Cacel권한 부여
* 2011.05.06 이행지 [선처리] Amend Rule Contents - SuperUser 조건 AND -> OR 로 수정
* 2011.05.16 이행지 [CHM-201110773-01] [PRI] Tariff Rule - Publish Cancel 기능 보완
*                                    Publish Cancel 버튼 추가
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
     * @class ESM_PRI_3507 : ESM_PRI_3507 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3507() {
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
	
	/*
	 * 2011.04.19 이행지 [CHM-201110201-01]
	 * 숨겨진 기능인 super user 권한을 가졌는지 여부를 체크하기 위한 변수 추가
	 */
	var IS_SUPER_USER = false;
	var superUserRoute = "";
	var STANDARD_SUPER_USER_ROUTE = "btn_new|no_btn_amendcompare|no_btn_cancel|no_btn_publish|no_btn_approve|no_btn_request|no_btn_rowdelete|no_btn_rowadd|no_btn_amendcancel|no_btn_amend|no_btn_amendcompare|no_btn_cancel|no_btn_publish";
   

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
			
			/*
	 		 * 2011.04.19 이행지 [CHM-201110201-01]
        	 * 숨겨진 기능인 super user 검증하기 위한 로직
        	 */
        	verifySuperUser(srcName);

			switch (srcName) {
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCREATE);
					break;

				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;

				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;

				case "btn_amend":
					doActionIBSheet(sheetObject1,formObject,MODIFY01);
					break;

				case "btn_amendcancel":
					doActionIBSheet(sheetObject1,formObject,MODIFY02);
					break;

				case "btn_rowadd":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;

				case "btn_rowdelete":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
					break;

				case "btn_request":
					doActionIBSheet(sheetObject1,formObject,MODIFY03);
					break;

				case "btn_approve":
					doActionIBSheet(sheetObject1,formObject,MODIFY04);
					break;

				case "btn_publish":
					doActionIBSheet(sheetObject1,formObject,MODIFY05);					
					break;

				case "btn_cancel":
					doActionIBSheet(sheetObject1,formObject,MODIFY06);
					break;
				case "btn_amendcompare":
					doActionIBSheet(sheetObject1,formObject,MODIFY07);
					break;
					
				case "btn_superuser_cancel": //2011.04.19 이행지 [CHM-201110201-01] Superuser만 사용가능한 Cancel Publish
	                doActionIBSheet(sheetObject1,document.form,MULTI02);                
	                break;
				case "btn_publish_cancel": //2011.05.03 이행지 [] Tariff Rule - Publish Cancel 기능 보완
					doActionIBSheet(sheetObject1,document.form,MULTI03);
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
	    
	    //버튼 초기화
	    toggleButtons("INIT");

	    //Tariff Code Combo 세팅
	    ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );	 
	    	    
	    // Inquiry 화면에서 이동시 호출됨
	    if(formObj.trf_no.value != "") {
	    	var trfPfxCd 	= formObj.trf_pfx_cd.value;
	    	var trfNo 		= formObj.trf_no.value;
	    	var trfRuleNo 	= formObj.temp_rule_no.value;
	    	var trfCd 		= trfPfxCd + "-" + trfNo;	    	
	    	comboObjects[0].Code = trfCd;
	    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);	    	
	    	var Row = sheetObjects[0].FindText("trf_rule_no", trfRuleNo);	    	
	    	sheetObjects[0].SelectCell(Row, "trf_rule_no");
	    }
	    
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
        //axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        //axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
        //axon_event.addListener ('keyup', "ComKeyEnter('LengthNextFocus')", document.form);        
        //axon_event.addListener('change', 'rf_flg_OnChange', 'rf_flg');
        axon_event.addListener('change', 'trf_rule_ctnt_onChange', 'trf_rule_ctnt');
        //axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);        
        //axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
        
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
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 6, 100);

                     var HeadTitle = "Flag|Seq.|Rule\nNo.|Rule Name|Charge\nCode|Amend\nType|Approval\nOffice|Creation\nDate|Effective\nDate|Expiration\nDate|Publish\nDate|Amend\nNo. " +
                     		"|Status|Request\nOffice|Creation\nStaff" +
                     		"|1|2|3|4|5|6|7|8";

                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 3, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, false);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                     InitDataProperty(0, cnt++ , dtDataSeq,			40,   	daCenter,  	false,	"seq");
 					 InitDataProperty(0, cnt++ , dtData,	   		70,		daLeft,		false,	"trf_rule_no",			true,	"",	dfNone, 			0,     false,	false,	10);
                     InitDataProperty(0, cnt++ , dtData,			160,  	daLeft,		false,	"trf_rule_nm",  		true,	"",	dfNone,				0,     true,	true,	100);
                     InitDataProperty(0, cnt++ , dtCombo,			50,  	daCenter,	false,	"trf_rule_chg_cd",     	false,	"",	dfNone, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtCombo,			50,  	daCenter,	false,	"trf_rule_amdt_tp_cd",  false,	"",	dfNone, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtCombo,  	    	70,   	daCenter, 	false,	"apro_ofc_cd",      	true,	"",	dfNone, 			0,     true,	true);
                     InitDataProperty(0, cnt++ , dtData,			80,  	daCenter,	false,	"cre_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtPopupEditFormat,	100,  	daCenter, 	false,	"eff_dt",     			true,	"",	dfDateYmd, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtPopupEditFormat,	100,  	daCenter, 	false,	"exp_dt",     			false,	"",	dfDateYmd, 		 	0,     true,	true);
                     InitDataProperty(0, cnt++ , dtData,			80,  	daCenter, 	false,	"pub_dt",     			false,	"",	dfDateYmd, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,			50,  	daCenter, 	false,	"amdt_seq",     		false,	"",	dfNone, 		 	0,     false,	false);

                     InitDataProperty(0, cnt++ , dtCombo,			60,  	daCenter, 	false,	"trf_rule_sts_cd",     	false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,			70,  	daCenter, 	false,	"rqst_ofc_cd",     		false,	"",	dfNone, 		 	0,     false,	false);
                     InitDataProperty(0, cnt++ , dtData,    		90,   	daCenter, 	false,	"cre_usr_id",     		false,	"",	dfNone, 			0,     false,	false);
                     
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"trf_pfx_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"trf_no");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"trf_rule_ctnt");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"bef_trf_rule_ctnt");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"amdt_flg");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"upd_dt");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"bef_pub_dt");
                     InitDataProperty(0, cnt++ , dtHidden,			40,		daLeft,		false,	"apro_flg");
                     
                     InitDataCombo(0, "trf_rule_chg_cd", trfRuleChgCdComboText, trfRuleChgCdComboValue);
                     InitDataCombo(0, "trf_rule_amdt_tp_cd", trfRuleAmdtTpCdComboText, trfRuleAmdtTpCdComboValue);
                     InitDataCombo(0, "trf_rule_sts_cd", trfRuleStsCdComboText, trfRuleStsCdComboValue);
                     InitDataCombo(0, "apro_ofc_cd", aproOfcCdComboText, aproOfcCdComboValue);
                    
 					 InitDataValid(0, "trf_rule_no",	vtEngUpOther, "1234567890-");
 					 InitDataValid(0, "trf_rule_nm", 	vtEngOther, PRI_VALID_CHAR);  // 한글제외

			 		 ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
			 		 //CountPosition = 0;		// Total 숨김
			 		 ImageList(0) = "img/btns_calendar.gif";
			 		 ImageList(1) = "img/btns_calendar_off.gif";

			 		 PopupButtonImage(0, "cre_dt") = 0;
			 		 PopupButtonImage(0, "eff_dt") = 0;
			 		 PopupButtonImage(0, "exp_dt") = 0;
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
		 			formObj.f_cmd.value = SEARCH01;
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3507GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchXml(sXml);
	 				break;
	 				
	 			case IBSEARCH_ASYNC01: // 중복체크	 				
		 			formObj.f_cmd.value = SEARCH02;
		 			
		 			var sParam = FormQueryString(formObj);	 				
	  				sParam += "&trf_rule_no=" + sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_no");
	  				sParam += "&amdt_seq=" + sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq");	  					  				
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3507GS.do", sParam);
	  				var dupLen = ComGetEtcData(sXml,"DUP_LEN");
	  				
	  				if(dupLen > 0) {
	  					return false;
	  				} else {
	  					return true;
	  				}
					
	 				break;

	 			case IBCREATE: // New
	 				comboObjects[0].Index = -1;
					formObj.trf_pfx_cd.value = "";
					formObj.trf_no.value = "";
					formObj.trf_nm.value = "";	
					formObj.trf_rule_ctnt.value = "";
					formObj.bef_trf_rule_ctnt.value = "";
					sheetObj.RemoveAll();
					formObj.tariff_cd.focus();
					toggleButtons("INIT");
					break;
					  
	 			case IBINSERT: // Row Add
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 					
					var idx = doRowChange(sheetObj, -2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, true);					
					if (idx < 0) {
						return false;
					}

					formObj.trf_rule_ctnt.value = "";
					formObj.bef_trf_rule_ctnt.value = "";

		  			//sheetObj.CellValue2(idx, "cre_dt") = ComGetNowInfo();
		  			sheetObj.CellValue2(idx, "trf_pfx_cd") = formObj.trf_pfx_cd.value;
		  			sheetObj.CellValue2(idx, "trf_no") = formObj.trf_no.value;
		  			
					sheetObj.CellValue2(idx, "amdt_seq") = 0;
					sheetObj.CellValue2(idx, "trf_rule_sts_cd") = "I";
					sheetObj.CellValue2(idx, "cre_usr_id") = formObj.strusr_id.value;
					sheetObj.CellValue2(idx, "rqst_ofc_cd") = formObj.strofc_cd.value;

					sheetObj.CellEditable(idx, "trf_rule_no") = true;
					sheetObj.CellEditable(idx, "trf_rule_nm") = true;
					sheetObj.SelectCell(idx, "trf_rule_no", true);	
					toggleButtons("INSERT");
	 				break;

	 			case IBSAVE: // Save
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				
	 				if (!supressConfirm && !ComPriConfirmSave()) {
	  					return false;
	  				}
	 					 				
	 				//Content 가 변경됬을 경우 sheet에 업데이트 한다.
	 				//Content 수정후 바로 save버튼 클릭했을 때 호출됨.
	 				if (formObj.trf_rule_ctnt.value != sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_ctnt")) {
	 					sheetObj.CellValue2(sheetObj.SelectRow, "trf_rule_ctnt") = formObj.trf_rule_ctnt.value;
	 				}
	 				
	  				ComOpenWait(true);
	 				formObj.f_cmd.value = MULTI01;
	 				var sParam = FormQueryString(formObj);
	 				var sParamSheet = sheetObj.GetSaveString();
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}
	  				
	 				var sXml = sheetObj.GetSaveXml("ESM_PRI_3507GS.do", sParam);
	 				
	 				//재조회 전의 Row 를 찾아가자.
					var selectRow = sheetObj.SelectRow;
					var selectCol = sheetObj.SelectCol										
					var sValue = sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_no");
					var sStatus = sheetObj.RowStatus(sheetObj.SelectRow);
				
					doActionIBSheet(sheetObj,document.form,IBSEARCH);	
					
					//Add Row 일경우에 해당됨.
					if(sStatus == "I") {
						selectRow = sheetObj.FindText("trf_rule_no", sValue, 0, -1, true);
					}
					
					sheetObj.SelectCell(selectRow, selectCol, false);					
	 				sheetObj.LoadSaveXml(sXml);	 
	  				return true;
	  				
	 				break;
	 			
				case IBDELETE: // Delete
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					var amdtSeq = sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq");
					if(amdtSeq == 0) {	
						if(sheetObj.RowStatus(sheetObj.SelectRow) == "I"){
							sheetObj.RowDelete(sheetObj.SelectRow, false);
						} else {
							sheetObj.RowHidden(sheetObj.SelectRow)= true;
							sheetObj.RowStatus(sheetObj.SelectRow)= "D";
						}
					}
										
					//Contents 입출력관리
					setRuleContents(sheetObj, sheetObj.SelectRow, 1);
					
					//버튼 컨트롤
					setButtonControl(sheetObj, sheetObj.SelectRow, 1);
					
					//권한관리 컨트롤
					setAuthButtonControl(sheetObj, sheetObj.SelectRow, 1);
					
					break;
									
				case MODIFY01: // Amend
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
			            
					var sUrl = "/hanjin/ESM_PRI_3519.do";
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3519", 450, 220, true);

					//ComDebug(rtnVal);
					
		            if (rtnVal) {
						var selectRow = sheetObj.SelectRow + 1;
						var selectCol = sheetObj.SelectCol;
						doActionIBSheet(sheetObj,document.form,IBSEARCH);					
						sheetObj.SelectCell(selectRow, selectCol, false);
		            }				
					break;

				case MODIFY02: // Amend Cancel
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (!ComShowCodeConfirm("PRI00015")) {
						return false;
					}
					
	  				ComOpenWait(true);
	  				
	  				//트랜젝션으로 처리하기 위함
	  				sheetObj.RowStatus(sheetObj.SelectRow)= "D";
	  				
					formObj.f_cmd.value = MODIFY02;
					var sParam = FormQueryString(formObj);
	 				var sParamSheet = sheetObj.GetSaveString();
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}
	  					  				
					var sXml = sheetObj.GetSaveXml("ESM_PRI_3507GS.do", sParam);
					var selectRow = sheetObj.SelectRow;
					var selectCol = sheetObj.SelectCol
					doActionIBSheet(sheetObj,document.form,IBSEARCH);					
					sheetObj.SelectCell(selectRow, selectCol, false);
					sheetObj.LoadSaveXml(sXml);					
					break;

					
				case MODIFY03: // Request
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					//수정사항이 존재할경우 저장후 REQUEST 처리한다.
		   			if (sheetObj.IsDataModified) {
		   				if (ComShowCodeConfirm("PRI00006")) {
							supressConfirm = true;
							var rslt = doActionIBSheet(sheetObj,document.form,IBSAVE);
							supressConfirm = false;
						}
		   				
		   				if (!rslt) {
		   					return false;
		   				}
					}
		 			
					
					if (!ComShowCodeConfirm("PRI06001")) {
						return false;
					}
					
	  				ComOpenWait(true);
					formObj.f_cmd.value = MODIFY03;
					sheetObj.CellValue2(sheetObj.SelectRow, "trf_rule_sts_cd") = "Q";
										
					var sParam = FormQueryString(formObj);
	 				var sParamSheet = sheetObj.GetSaveString();
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}

					var sXml = sheetObj.GetSaveXml("ESM_PRI_3507GS.do", sParam);
					var selectRow = sheetObj.SelectRow;
					var selectCol = sheetObj.SelectCol
					doActionIBSheet(sheetObj,document.form,IBSEARCH);					
					sheetObj.SelectCell(selectRow, selectCol, false);
					sheetObj.LoadSaveXml(sXml);
					break;

				case MODIFY04: // Approval
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (!ComShowCodeConfirm("PRI06002")) {
						return false;
					}
					
	  				ComOpenWait(true);
					formObj.f_cmd.value = MODIFY04;
					sheetObj.CellValue2(sheetObj.SelectRow, "trf_rule_sts_cd") = "A";
					
					var sParam = FormQueryString(formObj);
	 				var sParamSheet = sheetObj.GetSaveString();
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}

					var sXml = sheetObj.GetSaveXml("ESM_PRI_3507GS.do", sParam);
					var selectRow = sheetObj.SelectRow;
					var selectCol = sheetObj.SelectCol
					doActionIBSheet(sheetObj,document.form,IBSEARCH);					
					sheetObj.SelectCell(selectRow, selectCol, false);
					sheetObj.LoadSaveXml(sXml);
					break;
					
				case MODIFY05: // Publish
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
			            
					var sUrl = "/hanjin/ESM_PRI_3510.do";
					var param = "?isSuperUser="+IS_SUPER_USER;
					var rtnVal = ComPriOpenWindowCenter(sUrl+param, "ESM_PRI_3510", 500, 220, true);

		            if (rtnVal) {
						var selectRow = sheetObj.SelectRow;
						var selectCol = sheetObj.SelectCol;
						
						if(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") > 0) {
							selectRow = selectRow - 1;
						}						
						
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
						sheetObj.SelectCell(selectRow, selectCol, false);
		            }	
		            
					break;

				case MODIFY06: // Cancel
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					if (!ComShowCodeConfirm("PRI00015")) {
						return false;
					}

	  				ComOpenWait(true);
					formObj.f_cmd.value = MODIFY06;
					
					if(sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_sts_cd") == "Q") {
						sheetObj.CellValue2(sheetObj.SelectRow, "trf_rule_sts_cd") = "I";
					} else if(sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_sts_cd") == "A") {
						sheetObj.CellValue2(sheetObj.SelectRow, "trf_rule_sts_cd") = "Q";
					}

					var sParam = FormQueryString(formObj);
	 				var sParamSheet = sheetObj.GetSaveString();
	  				if (sParamSheet != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet, "");
	  				}

					var sXml = sheetObj.GetSaveXml("ESM_PRI_3507GS.do", sParam);					
					var selectRow = sheetObj.SelectRow;
					var selectCol = sheetObj.SelectCol
					doActionIBSheet(sheetObj,document.form,IBSEARCH);					
					sheetObj.SelectCell(selectRow, selectCol, false);										
					sheetObj.LoadSaveXml(sXml);
					
					break;
					
				case MODIFY07: // amendcompare
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					//수정사항이 존재할경우 저장후 처리한다.
		   			if (sheetObj.IsDataModified) {
		   				if (ComShowCodeConfirm("PRI00006")) {
							supressConfirm = true;
							var rslt = doActionIBSheet(sheetObj,document.form,IBSAVE);
							supressConfirm = false;
						}
		   				
		   				if (!rslt) {
		   					return false;
		   				}
					}
		 			
			            
					var sUrl = "/hanjin/ESM_PRI_3599.do";
					var selectRow = sheetObj.SelectRow;
					var selectCol = sheetObj.SelectCol;
					var trf_rule_no = sheetObj.CellValue(selectRow,"trf_rule_no");
					var trf_pfx_cd = sheetObj.CellValue(selectRow,"trf_pfx_cd");
					var trf_no = sheetObj.CellValue(selectRow,"trf_no");
					var amdt_seq2 = sheetObj.CellValue(selectRow,"amdt_seq");
					var amdt_seq1 = amdt_seq2 -1;
					var param = "?trf_rule_no="+trf_rule_no+"&trf_pfx_cd="+trf_pfx_cd+"&trf_no="+trf_no+"&amdt_seq1="+amdt_seq1+"&amdt_seq2="+amdt_seq2
					var sFeatures = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=yes,alwaysRaised,dependent,titlebar=no,width=1024,height=700";
					ComOpenWindow(sUrl+param, "ESM_PRI_3599", sFeatures, false); 
	 
					break;

		 		case MULTI02: // btn_superuser_cancel
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 		
		 			var trf_rule_sts_cd = sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_sts_cd");
		 			if(trf_rule_sts_cd != 'F')
		 				return false;
			        if (!ComShowCodeConfirm("PRI01046")) {
			            return false;
			        }   
			    	ComOpenWait(true); //->waiting->start

		 			var selectRow = sheetObj.SelectRow;
		 			var selectCol = sheetObj.SelectCol;
		 			var selectAmdtSeq = sheetObj.CellValue(selectRow,"amdt_seq");
		 			
			    	formObj.f_cmd.value = MULTI02;
			        sheetObj.CellValue2(sheetObj.SelectRow,"trf_rule_sts_cd") = "A";
			        
			        var sParam = "";           
			        var sParamSheet1 = sheetObj.GetSaveString(false);
			        if (sParamSheet1 != "") {
			            sParam +=  ComPriSetPrifix(sParamSheet1, "");
			        }                        
			        sParam += "&" + FormQueryString(formObj);
			        var sXml = sheetObj.GetSaveXml("ESM_PRI_3507GS.do", sParam);                    
			        sheetObj.LoadSaveXml(sXml);
			        doActionIBSheet(sheetObj,document.form,IBSEARCH);
			        ComOpenWait(false); //->waiting->End
			        
			        if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" ){
		 				if(selectAmdtSeq == "0")
		 					sheetObj.SelectCell(selectRow, selectCol, false);
		 				else
		 					sheetObj.SelectCell(selectRow+1, selectCol+1, false);		 					
		 			}
			        break;
			        
		 		case MULTI03: // btn_publish_cancel
		 			if (!validateForm(sheetObj,document.form,sAction)) {
		 				return false;
		 			}
		 			ComOpenWait(true); //->waiting->start
		 			var selectRow = sheetObj.SelectRow;
		 			var selectCol = sheetObj.SelectCol;
		 			var selectAmdtSeq = sheetObj.CellValue(selectRow,"amdt_seq");
		 			var sUrl = "/hanjin/ESM_PRI_3523.do";
		 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_3523", 400, 250, true);
		 			if(rtnVal == true){
		 				doActionIBSheet(sheetObj,document.form,IBSEARCH);
		 				if(selectAmdtSeq == "0")
		 					sheetObj.SelectCell(selectRow, selectCol, false);
		 				else
		 					sheetObj.SelectCell(selectRow+1, selectCol+1, false);		 					
		 			}
		 			ComOpenWait(false); //->waiting->End
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
 	
 	
	//이벤트 컨트롤을 위해 사용됨 - 이벤트 발생전에 Validation 체크
	var isFiredNested = false;
	//저장 메세지를 구분하기 위해 사용됨.
	var supressConfirm = false;
   /**
    * SHEET의 ROW을 클릭할때 호출되는 function <br>
    * sheet의 Row를 선택할때 이전 Row에서 데이터 변경이 존재할 경우에 저장처리한다.  <br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetObj, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} appendRow 필수 SHEET Row 추가 유무
    * @return 없음
    * @author 최성민
    * @version 2010.10.13
    */
	function doRowChange(sheetObj, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetObj.IsDataModified) {				
				isFiredNested = true;
				sheetObj.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				var rslt = false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm = true;
					adjNewRow = Math.max(NewRow - sheetObj.RowCount("D"), sheetObj.HeaderRows);
					var rslt = doActionIBSheet(sheetObj,document.form,IBSAVE);
					supressConfirm = false;
				}
				if (rslt) {
					isFiredNested = true;
					sheetObj.SelectCell(adjNewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetObj.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (appendRow) {
				isFiredNested = true;
				var idx = sheetObj.DataInsert();
				isFiredNested = false;
				return idx;
			}
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
			var idx = doRowChange(sheetObj, OldRow, NewRow, OldCol, NewCol, false);
		
			if(idx != -1) {
				//Contents 입출력관리
				setRuleContents(sheetObj, NewRow, NewCol);
				
				//버튼 컨트롤
				setButtonControl(sheetObj, NewRow, NewCol);
				
				//권한관리 컨트롤
				setAuthButtonControl(sheetObj, NewRow, NewCol);
			}
			
			changeSelectBackColor4Rule(sheetObj, formObj);
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
   	 * @version 2010.10.13
     */
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;

 		switch(colName)
     	{
 			
     		case "eff_dt":
 				if(sheetObj.CellValue(Row, "exp_dt") != "") {
 					if(sheetObj.CellValue(Row, "eff_dt") >= sheetObj.CellValue(Row, "exp_dt")) {
 						ComShowCodeMessage("PRI00346");
 						sheetObj.CellValue2(Row, "eff_dt") = "";
 	 					sheetObj.SelectCell(Row,"eff_dt");
 					}
 				}
 				break;
 			
 			case "exp_dt":
 				if(sheetObj.CellValue(Row, "exp_dt") != "") {
 					if(sheetObj.CellValue(Row, "eff_dt") >= sheetObj.CellValue(Row, "exp_dt")) {
 						ComShowCodeMessage("PRI00345");
 						sheetObj.CellValue2(Row, "exp_dt") = "";
 	 					sheetObj.SelectCell(Row,"exp_dt");
 					}
 				}
 				break;
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
 		var ofcCd = formObj.strofc_cd.value;
 		
 		var	bCtnt = sheetObj.CellValue(NewRow, "bef_trf_rule_ctnt");
 		var aCtnt = sheetObj.CellValue(NewRow, "trf_rule_ctnt");
 	
 		//if(sheetObj.RowCount > 0) {
		formObj.trf_rule_ctnt.value = aCtnt;
		formObj.bef_trf_rule_ctnt.value = bCtnt;
 		//}
 		
		//초기 세팅
		var actnt = document.getElementById("trf_rule_ctnt");		
		if(sheetObj.RowStatus(NewRow) != "I" 
			&& (sheetObj.CellValue(NewRow, "amdt_flg") == "N" || sheetObj.CellValue(NewRow, "trf_rule_sts_cd") != "I")) {
			actnt.setAttribute("readOnly", true);	
			actnt.className = "input2";
		} else {
			if ((sheetObj.RowStatus(NewRow) == "I" || ofcCd == sheetObj.CellValue(NewRow, "rqst_ofc_cd")) || IS_SUPER_USER == true) {
				actnt.setAttribute("readOnly", false);				
			} else {
				actnt.setAttribute("readOnly", true);	
			}
			actnt.className = "";
		}
 		
 	}
 	
    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Row를 선택할때마다 Status에 따라서 버튼을 컨트롤한다.<br>
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
 	function setButtonControl(sheetObj, NewRow, NewCol)  {
		//초기세팅
		toggleButtons("INIT");
		
		if(sheetObj.CellValue(NewRow, "amdt_flg") == "N") {
			toggleButtons("NOTAMEND");
		} else {
			if(sheetObj.CellValue(NewRow, "trf_rule_sts_cd") == "Q") {
				toggleButtons("REQUESTED");				
			} else if(sheetObj.CellValue(NewRow, "trf_rule_sts_cd") == "A") {
				toggleButtons("APPROVED");
			} else if(sheetObj.CellValue(NewRow, "trf_rule_sts_cd") == "F") {
				toggleButtons("PUBLISH");
			} else {
				if(sheetObj.CellValue(NewRow, "amdt_seq") > 0) {
					toggleButtons("AMEND");
				} else {
					if(sheetObj.CellValue(sheetObj.SelectRow, "ibflag") == "I"){
						toggleButtons("INSERT");
					} else {
						toggleButtons("NEW");
					}
				}
			}
		}
 	}
 	
    /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Row를 선택할때마다 권한별 버튼을 컨트롤한다. <br>
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
 	function setAuthButtonControl(sheetObj, NewRow, NewCol)  {
 		var formObj = document.form;
		var ofcCd = formObj.strofc_cd.value;
		
		//Amend Cancel
		if(ofcCd != sheetObj.CellValue(NewRow, "rqst_ofc_cd")) {
			ComBtnDisable("btn_amendcancel");
		}
		
		//Request 
		if(ofcCd != sheetObj.CellValue(NewRow, "rqst_ofc_cd")) {
			ComBtnDisable("btn_request");
		}
		
		//Approve
		/*
		if(ofcCd != sheetObj.CellValue(NewRow, "apro_ofc_cd")) {
			ComBtnDisable("btn_approve");
		}
		*/
		if(sheetObj.CellValue(sheetObj.SelectRow, "apro_flg") != "Y") {
			ComBtnDisable("btn_approve");
		}
		
		//Cancel(REQUESTED)      
		if(sheetObj.CellValue(NewRow, "trf_rule_sts_cd") == "Q") {
			if(ofcCd == sheetObj.CellValue(NewRow, "rqst_ofc_cd")  || sheetObj.CellValue(sheetObj.SelectRow, "apro_flg") == "Y") {		
				ComBtnEnable("btn_cancel");
			}
		//Cancel(APPROVED)  	
		}else if(sheetObj.CellValue(NewRow, "trf_rule_sts_cd") == "A") {			
			if(sheetObj.CellValue(sheetObj.SelectRow, "apro_flg") == "Y") {
				ComBtnEnable("btn_cancel");
			}
			/*
			if(ofcCd == sheetObj.CellValue(NewRow, "apro_ofc_cd")) {					
				ComBtnEnable("btn_cancel");
			}	
			*/
		}
		
		//Row Delete
		if(ofcCd != sheetObj.CellValue(NewRow, "rqst_ofc_cd")) {		
			ComBtnDisable("btn_rowdelete");
		}
		
		//Save
		if(ofcCd != sheetObj.CellValue(NewRow, "rqst_ofc_cd")) {		
			ComBtnDisable("btn_save");
		}

		//Publish
		if(sheetObj.CellValue(sheetObj.SelectRow, "apro_flg") != "Y" && IS_SUPER_USER == false ) {
			ComBtnDisable("btn_publish");
		}
		//SupperUser 일 경우의 버튼 Control
		if(IS_SUPER_USER == true){
			if( sheetObj.CellValue(sheetObj.SelectRow,"trf_rule_sts_cd") == "F"
				&& sheetObj.CellValue(sheetObj.SelectRow,"amdt_flg") == "Y" ){
				ComBtnEnable("btn_superuser_cancel");
			}
			if( sheetObj.CellValue(sheetObj.SelectRow,"trf_rule_sts_cd") == "A"){
				ComBtnEnable("btn_publish");
				ComBtnEnable("btn_cancel");
			}
			if( sheetObj.CellValue(sheetObj.SelectRow,"trf_rule_sts_cd") == "Q"){
				ComBtnEnable("btn_approve");
				ComBtnEnable("btn_cancel");
			}
			if( sheetObj.CellValue(sheetObj.SelectRow,"trf_rule_sts_cd") == "I"){
				ComBtnEnable("btn_amendcancel");
				ComBtnEnable("btn_request");
				ComBtnEnable("btn_save");
			}
		}
		// Publish Cacel
		if( sheetObj.CellValue(sheetObj.SelectRow,"trf_rule_sts_cd") == "F"
			&& sheetObj.CellValue(sheetObj.SelectRow,"amdt_flg") == "Y" 
			&& sheetObj.CellValue(sheetObj.SelectRow, "apro_flg") == "Y" ) {
			ComBtnEnable("btn_publish_cancel");
		}
		
 	}
 	
    /**
     * Amend Row의 Highlight 색상을 다르게 표시한다.<br>
     * 선택된 Row의 RowFontColor나 CellFontColor Property를 읽어 색상을 변경합니다.<br>
     * <b>Example :</b>
     * <pre>
     *     changeSelectBackColor4Rule(sheetObj, formObj);
     * </pre>
     *
     * @param {sheet} sheetObj 필수, SheetObject
     * @param {form}  formobj   필수,html의 Form 오브젝트 Name
     * @return 없음
     * @author 최성민
     * @version 2009.12.31
     */
    function changeSelectBackColor4Rule(sheetObj, formObj) {
        var amdtSeq = sheetObj.Cellvalue(sheetObj.SelectRow, "amdt_seq");

        if (baseSelectBackColor == null) {
            baseSelectBackColor = getPriHighlightColor(sheetObj, "basic");
        }
        if (newSelectBackColor == null) {
            newSelectBackColor = getPriHighlightColor(sheetObj, "new");
        }
        
        if (sheetObj.RowFontColor(sheetObj.SelectRow) != 0 || sheetObj.CellFontColor(sheetObj.SelectRow, 1) != 0
            || (sheetObj.RowStatus(sheetObj.SelectRow) == "I")){
            sheetObj.SelectBackColor = newSelectBackColor;
        } else {
            sheetObj.SelectBackColor = baseSelectBackColor;
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
 			/*
 			if(!ComChkRequired(document.form)){
 				return false;
 			}
 			
 			if(formObj.trf_no.value.length != 3) {
 				ComShowCodeMessage('PRI00308');
 				return false;
 			} 
 			*/
			break;

		case IBCREATE: // New
			break;

   		case IBSAVE:
   			if (!sheetObj.IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
			
   			if (comboObjects[0].Code == "") {
				return false;
			}
   			
   			if (sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_no") == "") {
   				ComShowCodeMessage("PRI00316", "Rule No");
   				sheetObj.SelectCell(sheetObj.SelectRow, "trf_rule_no");
				return false;
			}
   			
   			if (sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_nm") == "") {
   				ComShowCodeMessage("PRI00316", "Rule Name");
   				sheetObj.SelectCell(sheetObj.SelectRow, "trf_rule_nm");
				return false;
			}

   			if (sheetObj.CellValue(sheetObj.SelectRow, "apro_ofc_cd") == "") {
   				ComShowCodeMessage("PRI00316", "Approval Office");
   				sheetObj.SelectCell(sheetObj.SelectRow, "apro_ofc_cd");
				return false;
			}

   			if (sheetObj.CellValue(sheetObj.SelectRow, "eff_dt") == "") {
   				ComShowCodeMessage("PRI00316", "Effective Date");
   				sheetObj.SelectCell(sheetObj.SelectRow, "eff_dt");
				return false;
			}

   			if (ComTrim(sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_ctnt")) == "") {
   				ComShowCodeMessage("PRI01042", "Rule Detail");
   				formObj.trf_rule_ctnt.focus();
				return false;
			}
   			
   			
   			/*
   			if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
				return false;
			}
   			 */  					   			
   			//중복체크 -서버체크해야함
   			/*
   			var dupRow = sheetObj.ColValueDup("trf_pfx_cd|trf_no|trf_rule_no|amdt_seq", false);
            if (dupRow >= 0) {
            	sheetObj.SelectRow = dupRow;
              	ComShowCodeMessage("PRI00342", "Rule No.");
             	return false;
            }
            */
   			
   			if (sheetObj.RowStatus(sheetObj.SelectRow) == "I") {
	   			if(!doActionIBSheet(sheetObj,formObj, IBSEARCH_ASYNC01)) {
	   				sheetObj.SelectCell(sheetObj.SelectRow,"trf_rule_no");
	   				ComShowCodeMessage("PRI00342", "Rule No.");
	   				return false;
	   			} 
   			}
   			
   			//날짜 체크 -onchange시에 체크   			
            if(sheetObj.CellValue(sheetObj.SelectRow, "exp_dt") != "") {
            	if(sheetObj.CellValue(sheetObj.SelectRow, "eff_dt") >= sheetObj.CellValue(sheetObj.SelectRow, "exp_dt")) {
            		ComShowCodeMessage("PRI00345");
					sheetObj.CellValue2(sheetObj.SelectRow, "exp_dt") = "";
 					sheetObj.SelectCell(sheetObj.SelectRow,"exp_dt");
 					return false;
            	}
            }
            
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
 			break;


   		case IBINSERT:
 			if (comboObjects[0].Code == "") {
 				return false;
 			}
 			break;

 		case MODIFY01: // Amend
 			if (comboObjects[0].Code == "") {
 				return false;
 			}
 			break;

 		case MODIFY02: // Amend Cancel
 			if (comboObjects[0].Code == "") {
 				return false;
 			}
 			
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////            
 			break;

 		case MODIFY03: // Request
 			if (comboObjects[0].Code == "") {
 				return false;
 			}
 			
 			if(ComIsEmpty(formObj.trf_rule_ctnt)) {
 				ComShowCodeMessage("PRI00308","input", "Rule Detail");
 				formObj.trf_rule_ctnt.focus();
				return false;
 			}
 			
            if(sheetObj.CellValue(sheetObj.SelectRow, "exp_dt") != "") {
            	if(sheetObj.CellValue(sheetObj.SelectRow, "eff_dt") > sheetObj.CellValue(sheetObj.SelectRow, "exp_dt")) {
            		ComShowCodeMessage("PRI00346");
 					return false;
            	}
            }
             			
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
			break;

 		case IBDELETE: // Row Delete
 			if (comboObjects[0].Code == "") {
 				return false;
 			}
 			
 			if(sheetObj.RowCount < 1) {
 				return false;
 			}
 			break;

 		case MODIFY04: // Approve
 			if (comboObjects[0].Code == "") {
 				return false;
 			}

			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
 			break;

 		case MODIFY06: // Cancel
 			if (comboObjects[0].Code == "") {
 				return false;
 			}
 			
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
 			break;

 		case MULTI03: // btn_publish_cancel 			
			/////////////////////////////////////////////////////////////////////
	        // update date 검사
	        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
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
   	 * @version 2010.10.13
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj = document.form;
 		var ofcCd = formObj.strofc_cd.value;
 		
 		sheetObj.Redraw = false;
 		for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
 			
 			if(sheetObj.CellValue(i, "amdt_seq") > 0) {
 				sheetObj.CellEditable(i,"eff_dt") = false;
 				sheetObj.PopupButtonImage(i, "eff_dt") = 1;
 			}

 			if(sheetObj.CellValue(i, "trf_rule_sts_cd") != "I") {
 				sheetObj.RowEditable(i) = false;
 				sheetObj.PopupButtonImage(i, "eff_dt") = 1;
 				sheetObj.PopupButtonImage(i, "exp_dt") = 1;
 			}
 			
 			if(sheetObj.CellValue(i, "amdt_flg") == "N") {
 				sheetObj.RowEditable(i) = false;
 				sheetObj.PopupButtonImage(i, "eff_dt") = 1;
 				sheetObj.PopupButtonImage(i, "exp_dt") = 1;
 				sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol)=true;
 			} else if (sheetObj.CellValue(i, "amdt_flg") == "Y" && sheetObj.CellValue(i, "trf_rule_sts_cd") != "F") {
 				sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
 			}
 			
 			if (ofcCd != sheetObj.CellValue(i, "rqst_ofc_cd") && IS_SUPER_USER != true) {
 				sheetObj.RowEditable(i) = false;
 				sheetObj.PopupButtonImage(i, "eff_dt") = 1;
 				sheetObj.PopupButtonImage(i, "exp_dt") = 1;
 			}
 		}
 		sheetObj.Redraw = true;
 		
 		changeSelectBackColor4Rule(sheetObj, formObj); 		
 	}

 	 /**
      * OnClick 이벤트 발생시 호출되는 function <br>
      * 달력 DIV를 호출한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
      * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
      * @return 없음
   	  * @author 최성민
   	  * @version 2010.10.13
      */
      function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
  	    var colname = sheetObj.ColSaveName(Col);
  	    var formObj = document.form;
  	    var pinkColor = sheetObj.RgbColor(255,192,203);

       	switch(colname)
       	{
   	    	case "eff_dt":
   	    		cal = new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
   	    		break;
   	    	case "exp_dt":
   	    		cal = new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
   	    		break;
       	}

      }


	/**
	 * Sheet Data를 XML형태로 넘겨받는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetObj sheetObject
   	 * @author 최성민
   	 * @version 2010.10.13
	 */
    function getSheetXml() { 
    	var sheetObj = sheetObjects[0];
        var formObj = document.form;
        var sXml = "";
        var sCol = "";
        var sValue = "";
        
        sCol = "trf_pfx_cd|trf_no|trf_rule_no|amdt_seq";
        sValue = sheetObj.CellValue(sheetObj.SelectRow, "trf_pfx_cd")
        	+ "|" + sheetObj.CellValue(sheetObj.SelectRow, "trf_no")
        	+ "|" + sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_no")
        	+ "|" + sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq");
        
        sXml = ComPriSheet2Xml(sheetObj, null, sCol, sValue);
        
        return sXml;
    }

 	/**
 	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * </pre>
 	 * @param {string} mode 필수 사용자 권한이나 모드
   	 * @author 최성민
   	 * @version 2010.10.13
 	 */
 	function toggleButtons(mode) {
 		var sheetObj = sheetObjects[0];
 		switch (mode) {
 		case "INIT":
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_save");
			
 			ComBtnDisable("btn_amend");
 			ComBtnDisable("btn_amendcancel");
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowdelete");
 			ComBtnDisable("btn_request");
 			ComBtnDisable("btn_approve");
 			ComBtnDisable("btn_publish");
 			ComBtnDisable("btn_cancel");
 			ComBtnDisable("btn_superuser_cancel");
 			ComBtnDisable("btn_publish_cancel");
 			//init은 항상 1번 호출 되기 때문에 이곳에서 처리함
 			ComBtnDisable("btn_amendcompare");
 			if(sheetObjects[0].SelectRow > 0   ){
 				if( sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "amdt_seq") > 0){
 					ComBtnEnable("btn_amendcompare");
 				}
 			}
 			break;
		case "INSERT":		
 			ComBtnEnable("btn_rowadd");
 			ComBtnEnable("btn_rowdelete");
 			
 			ComBtnEnable("btn_save");
 			break;
 		case "NEW":		
 			ComBtnEnable("btn_rowadd");
 			ComBtnEnable("btn_rowdelete");
 			ComBtnEnable("btn_request");
 			break;
 		case "NOTAMEND":
 			ComBtnDisable("btn_save");
 			break;
 		case "AMEND":			
 			ComBtnEnable("btn_amendcancel");
 			ComBtnEnable("btn_rowadd");
 			ComBtnEnable("btn_request");
 			break;
 		case "REQUESTED":
 			ComBtnEnable("btn_rowadd");
 			ComBtnEnable("btn_approve");
 			break;
 		case "APPROVED":		
 			ComBtnEnable("btn_rowadd");
 			ComBtnEnable("btn_publish");
 			break;
 		case "PUBLISH": 			
 			ComBtnEnable("btn_amend");
 			ComBtnEnable("btn_rowadd");
 			break;
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
   	function tariff_cd_OnChange(comboObj, code, text) {
   		var formObj = document.form;
   		
   		var arrText = text.split("|");
   		if (arrText != null && arrText.length > 1) {   			
   			
   			formObj.trf_nm.value = comboObj.GetText(code, 1);
   			
			var arr = code.split("-");				
			formObj.trf_pfx_cd.value = arr[0];
			formObj.trf_no.value = arr[1];
		
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
   		formObj.trf_nm.value = "";   		
   		comboObj.Index = -1;
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

   			var text = comboObj.GetText(code, 1);
   			if (text != null && text != "" && text != formObj.trf_nm.value) {
   				formObj.trf_nm.value = comboObj.GetText(code, 1);
   				
   	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);   	 			
   			}
   		}
   	}
   	
   	   
    /**
    * 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 <BR>
    * 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확은을 한다.<BR>
    * <br><b>Example :</b>
    * <pre>
    *     (sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} sheetObj update date와 key를 가진 sheet object
    * @param {String} checkTpCd update date를 check해야 하는 table이 다를 수 있다 이를 구분하는 code
    *  
    * @return boolean , true : 변경된 데이터 있음, false: 변경된 데이터 없음.
    * @author 송민석
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(sheetObj, checkTpCd ){
    	var returnValue = false;
        /////////////////////////////////////////////////////////////////////
    	
        // update date 검사
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_RULE&page_name=Tariff Rule"
	        + "&key1="+sheetObj.CellValue(sheetObj.SelectRow, "trf_pfx_cd") 
	        + "&key2="+sheetObj.CellValue(sheetObj.SelectRow, "trf_no") 
	        + "&key3="+sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") 
	        + "&key4="+sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_no")
	        + "&upd_dt="+sheetObj.CellValue(sheetObj.SelectRow, "upd_dt");
	        var cXml = sheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   case "CHECK2" : //amend
	   	    var amdt_seq = parseInt(sheetObj.CellValue(1, "amdt_seq"));
	   		//다음 seq가 이미 생성되었는지 확인한다.
	   		amdt_seq++;
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_RULE&page_name=Tariff Rule"
	        + "&key1="+sheetObj.CellValue(sheetObj.HeaderRows, "trf_pfx_cd") 
	        + "&key2="+sheetObj.CellValue(sheetObj.HeaderRows, "trf_no") 
	        + "&key3="+amdt_seq
	        + "&key4="+sheetObj.CellValue(sheetObj.HeaderRows, "trf_rule_no")
	        + "&upd_dt="+sheetObj.CellValue(sheetObj.HeaderRows, "upd_dt");
	        var cXml = sheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
   
   /**
    * onChange   event를 처리한다. <br>
    * TextArea 에 값이 변경됬을 경우 sheet 의 row 이동시 저장메시지를 호출한다.
    * <br><b>Example :</b>
    * <pre>
    *     trf_rule_ctnt_onChange()
    * </pre>
    * @param 없음
    * @return 없음
   	* @author 최성민
   	* @version 2010.10.13
    */    
	function trf_rule_ctnt_onChange() {
		var sheetObj = sheetObjects[0];
		var formObj = document.form;       
   		var ruleCtnt = formObj.trf_rule_ctnt.value;

   		if(ruleCtnt != sheetObj.CellValue(sheetObj.SelectRow, "trf_rule_ctnt")) {
   			sheetObj.CellValue2(sheetObj.SelectRow, "trf_rule_ctnt") = ruleCtnt;
   		}
	}
    
    /**
     * 운영서버 테스트시 CLT에 제공되는 account는 제한되어 있는데 <BR>
     * SC 화면의 office별 권한 체크로 인해 원할한 테스트가 불가능 하다.<BR>
     * 이른 회피하기 위해 정해진 경로대로 화면 조작을 할 경우 현재 로긴된 사용자가<BR>
     * 작성권, 승인권, 대표승인권을 갖도록 해주는 함수 이다. <BR>
     * <br><b>Example :</b>
     * <pre>
     *     verifySuperUser(srcName);
     * </pre>
     * @param {String} srcName 화면에서 click한 object의 이름. 
     * @return 없음
     * @author 송민석
     * @version 2010.06.29
     */
    function verifySuperUser(srcName){
 	   	//이미 권한을 획득했다면 더이상 권한 검증을 하지 않는다.
 	   	if( IS_SUPER_USER ){
 	   		return ;
 	   	}
 	   	if (srcName != null && srcName != "" ){
 	    	if( srcName == "btn_new"){
 	        	superUserRoute = srcName;
 	    	}else{
 	        	superUserRoute += "|" + srcName;
 	        	if( STANDARD_SUPER_USER_ROUTE.indexOf(superUserRoute) == 0 ){
 	        		if( STANDARD_SUPER_USER_ROUTE == superUserRoute ){
 	        			//권한 획득
 	        			ComShowMessage("You are a superuser from now on.\nPlease, operate carefully.")
 	        			IS_SUPER_USER = true;
 	        			//Superuser만 사용 할수 있는 button을 보여준다.
 	        			showButtonsForSuperUser();
 	        		}
 	        	}else{ // 경로가 틀렸으므로 btn_new 버튼부터 다시 시작 해야만
 	        			// super user의 권한 획득 가능
 	        		superUserRoute = "";
 	        	}
 	    	}
 	   	}
    }
    
    /**
     * 운영서버 테스트시 CLT에 제공되는 account는 제한되어 있는데 <BR>
     * SC 화면의 office별 권한 체크로 인해 원할한 테스트가 불가능 하다.<BR>
     * 이른 회피하기 위해 정해진 경로대로 화면 조작을 할 경우 현재 로긴된 사용자가<BR>
     * 작성권, 승인권, 대표승인권을 갖도록 하는 숨은 로직이 있는데 <BR>
     * 이때 Superuser만이 사용 할수 있는 숨은 button을 보여준다.
     * <br><b>Example :</b>
     * <pre>
     *     showButtonsForSuperUser();
     * </pre>
     * @return 없음
     * @author 송민석
     * @version 2010.06.29
     */
    function showButtonsForSuperUser(){
 		// filed 상태를 이전 상태로 되돌릴수 있는 버튼을 보여준다.
 		var file_btn_obj = document.getElementById("span_cancel_publish");
 		file_btn_obj.style.display = "inline";
    }
     	 
    
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
/*    
   function obj_keypress() {
       switch (event.srcElement.dataformat) {          
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
   */
   /**
    * OnBeforeActivate   event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_activate()
    * </pre>
    * @param 없음
    * @return 없음
   	* @author 최성민
   	* @version 2010.10.13
    */ 
   /*
    function obj_activate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);
    }
    */

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
/*    
  function obj_keydown(){
      //Proposal No,S/C No. 에서 Enter key조회
      var eleName = event.srcElement.name;
      if (eleName == "trf_no"){
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
*/
	/* 개발자 작업  끝 */