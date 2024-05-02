/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3003.js
*@FileTitle : TRI Creation &amp; Amendment - Note Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.30 최성민
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
     * @class ESM_PRI_3003 : ESM_PRI_3003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3003() {
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

    // 콤보에서의 VISIALE 항목 리스트
    var sChgCdVisiable = "";

    // Note Conversion type Code
    var NOTE_CONV_TP_CD = "R";	//TRI RATE NOTE

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * processButtonClick();
     * </pre>
     * 
     * @return 없음
     * @author 최성민
     * @version 2009.10.28
     */
    function processButtonClick() {
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    	var sheetObject1 = sheetObjects[0];

    	/** **************************************************** */
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch (srcName) {
    		case "btn_retrieve":
    			if (validateForm(sheetObject1, formObject, IBSEARCH)) {
    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    			}
    			break;
    			
    		case "btn_close":	
    			window.close();    				
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
    function setSheetObject(sheet_obj) {
    	sheetObjects[sheetCnt++] = sheet_obj;
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

    	for (i = 0; i < sheetObjects.length; i++) {

    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects[i]);

    		initSheet(sheetObjects[i], i + 1);
    		// khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
    function initSheet(sheetObj, sheetNo) {

    	var cnt = 0;
    	var sheetID = sheetObj.id;
    	switch (sheetID) {
    	case "sheet1":
    		with (sheetObj) {
                // 높이 설정
                style.height = 220;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 7, 100);

                var HeadTitle = "|Sel.|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
                		"|Pay Term|Weight\n(Ton < = )|Weight\n( > Ton)|SOC|T/S\nPort|Direct\nCall|Bar Type" +
                		"|1|2|3|4|5|6|7|8|9|10|11|12";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 6, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,		30,   daCenter,  true,	"ibflag");
                InitDataProperty(0, cnt++ , dtHidden,     		40,   daCenter,  true,	"chk");
                InitDataProperty(0, cnt++ , dtData,	   			50,   daCenter,  true,	"chg_rule_def_cd",			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,				100,  daCenter,  true,	"eff_dt",  					false,	"",	dfDateYmd,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,				100,  daCenter,  true,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     false,       false);
                InitDataProperty(0, cnt++ , dtCombo,    		90,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtCombo,  	    	45,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtCombo,        	40,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         	80,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,   		3,     false,       false,	10);
                InitDataProperty(0, cnt++ , dtCombo,   			40,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtCombo,  			50,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,   	    	50,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     false,      	false, 	3);
                InitDataProperty(0, cnt++ , dtCombo,      		80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     false,       false,	4);
                InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     false,       false,	4);
                InitDataProperty(0, cnt++ , dtCombo,			40,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,				70,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtCombo,			50,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtCombo,   	 		65,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_mapg_id");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"trf_pfx_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"amdt_seq");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"tri_prop_no");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"trf_no");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"chg_rule_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_chg_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_rule_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_hdr_seq");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_tp_cd");
                InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_ts_port_tp_cd");
                
                InitDataCombo(0, "bkg_soc_flg", 		" |Yes|No", " |Y|N");
                InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
                InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);            
                InitDataCombo(0, "bkg_prc_cgo_tp_cd", bkgPrcCgoTpCdComboText, bkgPrcCgoTpCdComboValue);
                InitDataCombo(0, "rt_op_cd", rtOpCdComboText, rtOpCdComboValue);
                InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);            
                InitDataCombo(0, "bkg_hngr_bar_tp_cd", bkgHngrBarTpCdComboText, bkgHngrBarTpCdComboValue);            
                InitDataCombo(0, "bkg_rat_ut_cd", bkgRatUtCdComboText, bkgRatUtCdComboValue);
                InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);            
                //InitDataCombo(0, "chg_rule_def_cd", chargeRuleCdComboText,chargeRuleCdComboValue);
                
                //sChgCdVisiable = chargeRuleCdComboText;	//초기로딩값 세팅
                
                                            
                InitDataValid(0, "chg_rule_def_cd", 			vtEngUpOnly);
                InitDataValid(0, "bkg_imdg_clss_cd", 			vtNumericOther, ".");			 
    			 
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
		    	case IBSEARCH: // 조회
	  				ComOpenWait(true);
		    		// NOTE CONVERSION RULE
		    		var sCd = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
		    		var sNm = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
		
		    		// //////////////////////////////////////////////////////////////////////////////
		    		formObj.f_cmd.value = SEARCH01;
		    		var sXml = sheetObj.GetSearchXml("ESM_PRI_3002GS.do", FormQueryString(formObj));
		    		var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd");
		
		    		if (arrData != null && arrData.length > 0) {
		    			for ( var i = 0; i < arrData.length; i++) {
		    				if (sCd.indexOf(arrData[i][0]) < 0) {
		    					sCd += "|" + arrData[i][0];
		    					sNm += "|" + arrData[i][0];
		    				}
		    			}
		    			sheetObj.InitDataCombo(0, 2, sNm, sCd, "", "", 0, "", "", sChgCdVisiable);
		    		}
		
		    		sheetObj.LoadSearchXml(sXml);
					ComOpenWait(false);
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
    	case IBSEARCH:
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
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
    	for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
     		//Rule Code 일 경우에는 색상을 지정
     		//setChargeRuleColor(sheetObj, i);
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

	/* 개발자 작업  끝 */