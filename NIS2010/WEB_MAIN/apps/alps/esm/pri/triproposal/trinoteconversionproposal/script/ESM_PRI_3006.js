/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3006.js
*@FileTitle : Tariff Fomula Rule Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.17 최성민
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
     * @class ESM_PRI_3006 : ESM_PRI_3006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3006() {
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

	var selectedGlineSeq = null;
	
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
     * @version 2009.10.28
     */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
				
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
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
	* @version 2009.10.28
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
	* @version 2009.10.28
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
    * @version 2009.05.17
    */
	function loadPage() {

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
	    

		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);

	    ComPriTextCode2ComboItem(srchTrfCdComboValue, srchTrfCdComboText, getComboObject(comboObjects, 'srch_trf_cd') ,"|","\t" );
	   
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
     * @version 2009.05.22
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
                     InitRowInfo( 1, 1, 6, 100);
                     
                     var HeadTitle = "|Sel.|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
                     		"|Pay Term|Commodity|US SVC Mode|POR|POL|POD|DEL" +
                     		"|Receiving\nTerm|Delivery\nTerm" +
                     		"|Type|Per\n(in Tariff)|Cargo Type\n(in Tariff)" +
                     		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19";
                     
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 6, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter,  true,	"ibflag");
                     InitDataProperty(0, cnt++ , dtHidden,     		40,   daCenter,  true,	"chk");
                     InitDataProperty(0, cnt++ , dtData,	   		50,   daCenter,  true,	"chg_rule_def_cd",			false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,			100,  daCenter,  true,	"eff_dt",  					false,	"",	dfDateYmd,			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,			100,  daCenter,  true,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     false,       false);
                     InitDataProperty(0, cnt++ , dtCombo,    		90,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,  	    	45,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,        	40,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,         	80,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,      	3,     false,       false,	10);
                     InitDataProperty(0, cnt++ , dtData,   			40,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     false,       false);
                     
                     InitDataProperty(0, cnt++ , dtData,  			50,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,   	    	50,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     false,      	false, 	3);
                     InitDataProperty(0, cnt++ , dtCombo,      		80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,    		80,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     false,       false,	6);
                     InitDataProperty(0, cnt++ , dtCombo,      		90,   daCenter,  true,	"bkg_usa_svc_mod_cd",  		false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,    		75,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtData,    		75,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     false,       false,	5);                     
                     InitDataProperty(0, cnt++ , dtData,    		75,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtData,    		75,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                     InitDataProperty(0, cnt++ , dtCombo,        	70,   daCenter,  true,	"bkg_rcv_term_cd", 			false,	"",	dfNone, 			0,     false,       false);
                     
                     InitDataProperty(0, cnt++ , dtCombo,        	70,   daCenter,  true,	"bkg_de_term_cd",			false,	"",	dfNone,				0,     false,       false);
                     InitDataProperty(0, cnt++ , dtCombo,        	75,   daCenter,  true,	"rule_appl_chg_tp_cd", 		false,	"",	dfNone, 			0,     false,       false);                     
                     InitDataProperty(0, cnt++ , dtData,   	 		60,   daCenter,  true,	"conv_rat_ut_cd",   		false,	"",	dfNone, 			0,     false,       false);
                     InitDataProperty(0, cnt++ , dtData,  			70,   daCenter,  true,	"conv_prc_cgo_tp_cd",		false,	"",	dfNone, 			0,     false,       false);
                                          
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"note_conv_mapg_id");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"note_conv_seq");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"trf_pfx_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"amdt_seq");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"tri_prop_no");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"trf_no");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"chg_rule_tp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"note_conv_chg_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"note_conv_rule_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"note_conv_tp_cd");    
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"bkg_cmdt_tp_cd");
                                          
                     
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"bkg_por_tp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"bkg_pol_tp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"bkg_pod_tp_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"bkg_del_tp_cd");
                     
                     /////////////////////////////////////////////////////////////////////////////////////////
                     //STATE코드는 CNT_CD+STE_CD로 저장되어야 하기때문에 아래와 같이 컬럼을 추가함
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"bkg_por_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"bkg_pol_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"bkg_pod_cnt_cd");
                     InitDataProperty(0, cnt++ , dtHidden,			10,	daLeft,		false,	"bkg_del_cnt_cd");
                     
                     InitDataCombo(0, "rule_appl_chg_tp_cd", ruleApplChgTpCdComboText, ruleApplChgTpCdComboValue);
                     InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);      
                     InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);            
                     InitDataCombo(0, "bkg_usa_svc_mod_cd", bkgUsaSvcModCdComboText, bkgUsaSvcModCdComboValue);                     
                     InitDataCombo(0, "bkg_rcv_term_cd", bkgRcvTermCdComboText, bkgRcvTermCdComboValue);
                     InitDataCombo(0, "bkg_de_term_cd", bkgDeTermCdComboText, bkgDeTermCdComboValue);
                                       
			 		 ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
			 		 CountPosition = 0;		// Total 숨김
			 		 ImageList(0) = "img/btns_calendar.gif";
			 		 PopupButtonImage(0, "eff_dt") = 0;
			 		 PopupButtonImage(0, "exp_dt") = 0;
	                 WaitImageVisible = false;

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
    * @version 2009.07.15
    */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "srch_trf_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;
	        
	        case "note_seq":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = false;
	            	
	            	SetColWidth("80|100|0");
	            	
	            	IMEMode = 0;
	            	ValidChar(2, 1);
	            }
	            break
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
       * @version 2009.05.22
       */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
 			sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {
				case IBSEARCH_ASYNC01: // Service Scope 선택시, Duration조회
					formObj.f_cmd.value = SEARCH02;
					var sXml = sheetObj.GetSearchXml("ESM_PRI_3006GS.do", FormQueryString(formObj));
					comboObjects[1].RemoveAll();
					sheetObj.RemoveAll();				
	
					ComPriXml2ComboItem(sXml, formObj.note_seq, "note_seq", "eff_dt|exp_dt|eff_dt", false);					
					break;
					
				case IBSEARCH_ASYNC02: // Duration선택후 INFO 정보 세팅
	  				ComOpenWait(true);
					formObj.f_cmd.value = SEARCH02;
					var sXml = sheetObj.GetSearchXml("ESM_PRI_3006GS.do", FormQueryString(formObj));
					var arrData = ComPriXml2Array(sXml, "note_conv_mapg_id|cfm_flg");
					formObj.note_conv_mapg_id.value = arrData[0][0];
		 			formObj.cfm_flg.value = arrData[0][1];	 			
		 			getConfirmName(arrData[0][1]);	
		 			
		 	 		doActionIBSheet(sheetObj, document.form, IBSEARCH);
					break;
														
	 			case IBSEARCH: // 조회
	  				ComOpenWait(true);
		 			// NOTE CONVERSION RULE
					var sCd = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm = sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			
		 			formObj.f_cmd.value = SEARCH01;
	  				var sXml = sheetObj.GetSearchXml("ESM_PRI_3006GS.do", FormQueryString(formObj));  				
					sheetObj.LoadSearchXml(sXml);
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
     * @version 2009.04.17
     */
 	function validateForm(sheetObj, formObj, sAction) {
 		
 		switch (sAction) {
 		case IBSEARCH: // 조회
			if (comboObjects[0].Code == "" || comboObjects[1].Code == "") {
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
	 * @version 2009.05.20
	 */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj = document.form;
	 		
 		for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
 			var prevStatus = sheetObj.RowStatus(i);
 			if(sheetObj.CellValue(i,"exp_dt") == "99991231") {
 				sheetObj.CellValue2(i,"exp_dt") = "";
 			}
			sheetObj.RowStatus(i) = prevStatus; 
			

	 		//Route 에서 State 코드일 경우 색상처리
	 		setStateColor(sheetObj, i);
			
	 		//Rule Code 일 경우에는 색상을 지정
	 		//setChargeRuleColor(sheetObj, i);
 		}
	}

  	/**
  	 * Route 에 State 코드일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setStateColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 IBSheet Object 의 Row Index
  	 * @return 없음
  	 * @author 최성민
  	 * @version 2009.07.09
  	 */ 
 	function setStateColor(sheetObj, Row) {
 		// State 색 구분
 		var pinkColor = sheetObj.RgbColor(255,192,203);
 		
		if(sheetObj.CellValue(Row, "bkg_por_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_por_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_pol_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_pol_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_pod_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_pod_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "bkg_del_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"bkg_del_def_cd") = pinkColor;
 		}
		
		if(sheetObj.CellValue(Row, "conv_org_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_org_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_org_via_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_dest_via_loc_def_cd") = pinkColor;
 		}
		if(sheetObj.CellValue(Row, "conv_dest_loc_tp_cd") == "T") {
 			sheetObj.CellBackColor(Row,"conv_dest_loc_def_cd") = pinkColor;
 		} 		
 	
 	}
 	
  	/**
  	 * Code 가 Rule Code 일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setChargeRuleColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 IBSheet Object 의 Row Index
  	 * @return 없음
  	 * @author 최성민
  	 * @version 2009.07.09
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// Rule & Charge Code 색 구분
 		var sCodeColor = sheetObj.RgbColor(255,200,200);
 		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
	 		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "RAC" ) {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = 0;
 		} else {
 			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = sCodeColor;
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
   	 * @author 박성수
   	 * @version 2009.05.01
   	 */
	function srch_trf_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		var arrText = text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.srch_trf_nm.value = comboObj.GetText(code, 1);

			var srchTrfCd = formObj.srch_trf_cd.value;
			var arr = code.split("-");				
			formObj.trf_pfx_cd.value = arr[0];
			formObj.trf_no.value = arr[1];
		
			selectedGlineSeq = null;			
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		}
	}


   	function srch_trf_cd_OnClear(comboObj) {
   		var formObject = document.form;
   		formObject.srch_trf_nm.value = "";
   		
   		comboObj.Index = -1;
   	}
   	
   	/**
  	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *    ssrch_trf_cd_OnBlur(comboObj);
  	 * </pre>
  	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
  	 * @return 없음
  	 * @author 박성수
  	 * @version 2009.05.01
  	 */
  	function srch_trf_cd_OnBlur(comboObj) {
  		var formObj = document.form;
  		
  		var code = comboObj.FindIndex(comboObj.Code, 0);
  				
  		if (code != null && code != "") {
  	   		var arr = code.split("-");				
  			formObj.trf_pfx_cd.value = arr[0];
  			formObj.trf_no.value = arr[1];

  			var text = comboObj.GetText(code, 1);
  			if (text != null && text != "" && text != formObj.srch_trf_nm.value) {
  				formObj.srch_trf_nm.value = comboObj.GetText(code, 1);
  	 			selectedGlineSeq = null;
  	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
  			}
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
 	 * @author 박성수
 	 * @version 2009.05.01
 	 */
 	function note_seq_OnChange(comboObj, code, text) {
 		var formObj = document.form;
 		
 		selectedGlineSeq = code;
 		
 		if (code == "" || text == "") {
 			return;
 		}
 		
 		var effText = comboObj.GetText(code, 0);
 		var expText = comboObj.GetText(code, 1);
 		
 		formObj.eff_dt.value = effText;
 		formObj.exp_dt.value = expText;
 		
 		if (code == null || code == "" || code == "X") {
 			return true;
 		}
 		
 		// INFO 정보 조회후 FORM세팅
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
 	}
 

 	/**
 	 * OnClear 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 	 * @return 없음
 	 * @author 박성수
 	 * @version 2009.05.01
 	 */
 	function note_seq_OnClear(comboObj) {
 		var formObj = document.form;
 		
 		comboObj.Code = "X";
 		formObj.eff_dt.value = "";
 		formObj.exp_dt.value = "";
 		formObj.cfm_flg.value = "";
 		formObj.cfm_flg_nm.value = "";
 	}
 	
	
 	/**
 	 * OnKeyUp 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 	 * @param {Integer} KeyCode 필수 키보드의 아스키 값
 	 * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 	 * @return 없음
 	 * @author 박성수
 	 * @version 2009.05.01
 	 */
 	function note_seq_OnKeyUp(comboObj, KeyCode, Shift) {
 		var selEffDt = comboObj.Text;
 		
 		if (selEffDt.search(/[^0-9]/gi) >= 0) {
 			selEffDt = selEffDt.replace(/[^0-9]/gi, "");
 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
 		}
 		
 		if (selEffDt.length == 8) {
 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
 			document.form.exp_dt.focus();
 		}
 	}
 	

 	/**
 	 * OnFocus 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 	 * @return 없음
 	 * @author 박성수
 	 * @version 2009.05.01
 	 */
 	function note_seq_OnFocus(comboObj) {
 		var selEffDt = comboObj.Text;
 		
 		if (selEffDt != null && selEffDt != "") {
 			selEffDt = selEffDt.replace(/-/gi, "");
 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
 		}
 	}
 	
 	/**
 	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *    ssvc_scp_cd_OnBlur(comboObj);
 	 * </pre>
 	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
 	 * @return 없음
 	 * @author 박성수
 	 * @version 2009.05.01
 	 */
 	function note_seq_OnBlur(comboObj) {
 		var selEffDt = comboObj.Text;
 		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
 			return false;
 		} 		
 		
 		if (ComIsDate(selEffDt)) {
 			selEffDt = selEffDt.replace(/-/gi, "");
 			selEffDt = selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
 			
 			document.form.eff_dt.value = selEffDt;
 			
 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
 		} else {
 			ComShowCodeMessage("COM12134", "Effective Date");
 			document.form.note_seq.focus();
 			return false;
 		}
 	}
 	 
 	 
 	 	    
 	   /**
  	    * Confirmation Flag 값을 Flag 명으로 변경한다. <br>
  	    * <br><b>Example :</b>
  	    * <pre>
  	    * getConfirmName(flg);
  	    * </pre>
  	    * @param {string} flg Confirmation Flag 값
  	    * @return 없음
  	    * @author 최성민
  	    * @version 2009.08.13
  	    */  	    
 	    function getConfirmName(flg) {
 	    	var formObj = document.form;
 	    	
 			if(flg == "Y"){
 				formObj.cfm_flg_nm.value = "Yes";
 				formObj.cfm_flg.value = "Y";
 			} else if(flg == "N"){
 				formObj.cfm_flg_nm.value = "No";
 				formObj.cfm_flg.value = "N";
 			} else {
 				formObj.cfm_flg_nm.value = "";
 				formObj.cfm_flg.value = "";
 			}
 	    }
 	    
	/* 개발자 작업  끝 */