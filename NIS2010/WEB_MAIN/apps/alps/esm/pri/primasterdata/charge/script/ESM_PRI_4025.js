/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4025.js
*@FileTitle : Charge Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.25 김재연
* 1.0 Creation
========================================================= 
* History                                                                                                                                                                                                                                                                                             
* 2012.07.18 원종규 [CHM-201219118] Charge code inquiry 의 Excel 출력 기능 추가 
* 2015.05.26 전지예 [CHM-201536019] Code Charge Inquiry의 Use 칼럼 변경요청
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
     * @class ESM_PRI_4025 : ESM_PRI_4025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4025() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업 */
    // 공통전역변수
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
     * @author 김재연
     * @version 2009.08.25
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject0 = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        
        /*******************************************************/
        var formObject = document.form;

        try {
        	var srcName = window.event.srcElement.getAttribute("name");

        	switch(srcName) {

        		case "btn_Retrieve":
        			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
        		case "btn_downexcel":
        			doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;		
					
        	} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
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
     * @author 김재연
     * @version 2009.08.25
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * IBMultiCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj 필수 IBMultiCombo Object
     * @return 없음
     * @author 김재연
     * @version 2009.08.25
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
     * @author 김재연
     * @version 2009.08.25
     */
    function loadPage() {
    	for (i = 0; i < sheetObjects.length; i++) {
 			// khlee-시작 환경 설정 함수 이름 변경
 			ComConfigSheet(sheetObjects[i]);
 	
 			initSheet(sheetObjects[i], i + 1);
 			// khlee-마지막 환경 설정 함수 추가
 			ComEndConfigSheet(sheetObjects[i]);
 		}
    	
    	// IBMultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
    	
    	pageOnLoadFinish();
    }
     
 	/**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.08.25
     */ 
    function pageOnLoadFinish() {
    	initControl();
    	initIBComboItem();
 		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
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
     * @author 김재연
     * @version 2009.08.25
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetId = sheetObj.id;

        switch(sheetId) {
        	
        	case "sheet0":
        		
        		with (sheetObj) {
	               	// Host정보 설정[필수][HostIp, Port, PagePath]
	       			if (location.hostname != "")
	       				InitHostInfo(location.hostname, location.port, page_path);
       									
                }
        		break;
        		
            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 440;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "Seq.|Code|Description|Rep.Charge|Freight/Charge Type|Revenue Class|Charge Character|SML Acct|Auto";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(10, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtSeq,	50,	 daCenter,	true,	"seq",				false);
					InitDataProperty(0, cnt++, dtData,	40,	 daCenter,	true,	"chg_cd",			false);
					InitDataProperty(0, cnt++, dtData,	370, daLeft,	true,	"chg_nm",			false);
					InitDataProperty(0, cnt++, dtData,	80,	 daCenter,	true,	"rep_chg_cd",		false);
					InitDataProperty(0, cnt++, dtData,	130, daCenter,	true,	"frt_chg_tp_cd",	false);
					InitDataProperty(0, cnt++, dtData,	90,	 daCenter,	true,	"chg_rev_tp_cd",	false);
					InitDataProperty(0, cnt++, dtData,	90,	 daCenter,	true,	"chg_aply_tp_cd",	false);
					InitDataProperty(0, cnt++, dtData,	60,	 daCenter,	true,	"hjs_chg_acct_cd",	false);
					InitDataProperty(0, cnt++, dtData,	40,	 daCenter,	true,	"auto_rat_flg",		false);
					
					InitDataCombo(0, "rep_chg_cd", 		repChgCdText, 		repChgCdValue);
					InitDataCombo(0, "frt_chg_tp_cd", 	frtChgTpCdText, 	frtChgTpCdValue);
					InitDataCombo(0, "chg_rev_tp_cd", 	chgRevTpCdText, 	chgRevTpCdValue);
					InitDataCombo(0, "chg_aply_tp_cd", 	chgAplyTpCdText, 	chgAplyTpCdValue);
					
					CountPosition = 0;
					AutoRowHeight = false;
					WaitImageVisible = false;
			}
			break;
        }
    }

    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.08.25
	 **/
 	function initControl() {
 		//** Date 구분자 **/
 		DATE_SEPARATOR = "/";

 		axon_event.addListenerForm('keypress', 'obj_keypress', form);
 		axon_event.addListener('keydown', 'ComKeyEnter', 'form'	);
 	}
 	
	/**
     * Open 시에 조회한 Combo Item 을 IBMultiCombo 에 셋팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.08.12
     */
    function initIBComboItem() {
        ComPriTextCode2ComboItem(repChgComboValue, repChgComboText, getComboObject(comboObjects, 'rep_chg_cd'),"|","\t");
        ComPriTextCode2ComboItem(frtChgTpComboValue, frtChgTpComboText, getComboObject(comboObjects, 'frt_chg_tp_cd'),"|","\t");
        ComPriTextCode2ComboItem(chgRevTpComboValue, chgRevTpComboText, getComboObject(comboObjects, 'chg_rev_tp_cd'),"|","\t");
        ComPriTextCode2ComboItem(chgAplyTpComboValue, chgAplyTpComboText, getComboObject(comboObjects, 'chg_aply_tp_cd'),"|","\t");
    }
	    
 	/**
     * OnKeyPress시 호출되는 function <br>
     * HTML Control의 onkeypress 이벤트에서 해당 key만 입력되게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.08.25
     */
 	function obj_keypress() {
 		 switch (event.srcElement.name) {
 		 
 			case "chg_cd":
 				ComKeyOnlyAlphabet('upper');
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
     * @author 김재연
     * @version 2009.08.25
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
     	sheetObj.ShowDebugMsg = false;
     	
     	switch(sAction) {
     		
     		case IBSEARCH:
     			ComOpenWait(true);
     			if (!validateForm(sheetObj, formObj, sAction)) {
     				ComOpenWait(false);
     				return false;
 	      		}
 	    		
 				formObj.f_cmd.value = SEARCH;
 				sheetObj.DoSearch("ESM_PRI_4025GS.do", FormQueryString(formObj));
 				ComOpenWait(false);
 				break;
 				
     		case IBDOWNEXCEL: //download excel  
     			ComOpenWait(true);
     			sheetObj.Down2Excel(-1);
     			ComOpenWait(false);
			break;
     	}
    }
 	
    /**
     * 콤보 초기설정값, 헤더 정의 <br>
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.08.25
     */
    function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "rep_chg_cd":
				var i = 0;
				with (comboObj) {
					BackColor = "white";
					DropHeight = 200;
					MultiSelect = false;
					MaxSelect = 1;
					//Enable = true;
					UseAutoComplete = true;
				}
				break;
		
			case "frt_chg_tp_cd":
				var i = 0;
				with (comboObj) {
					BackColor = "white";
					DropHeight = 200;
					MultiSelect = false;
					MaxSelect = 1;
					Enable = true;
					UseAutoComplete = true;
				}
				break;
		
			case "chg_rev_tp_cd":
				var i = 0;
				with (comboObj) {
					BackColor = "white";
					DropHeight = 200;
					MultiSelect = false;
					MaxSelect = 1;
					Enable = true;
					UseAutoComplete = true;
				}
				break;
		
			case "chg_aply_tp_cd":
				var i = 0;
				with (comboObj) {
					BackColor = "white";
					DropHeight = 200;
					MultiSelect = false;
					MaxSelect = 1;
					Enable = true;
					UseAutoComplete = true;
				}
				break;
		}
	}
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김재연
     * @version 2009.08.25
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
     	
  	 		case IBSEARCH:
  	 			if(!ComIsNull(formObj.chg_cd.value) && formObj.chg_cd.value.length < 2) {
  	 				ComShowCodeMessage('PRI04004', 'Code', '2', '3');
  	 				formObj.chg_cd.focus();
  	 				return false;
  	 			}
  	 			return true;
  	 			break;
     	}
     	return true;
     }

	/* 개발자 작업  끝 */