/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3503.js
*@FileTitle : Tariff Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.25
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.12 서미진
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
     * @class ESM_PRI_3503 : ESM_PRI_3503 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_3503() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 			= setSheetObject;
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.initControl            	= initControl;
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
     * @return 없음
     * @author 서미진
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
					
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, SEARCH01);
		 			form.tariff_cd.focus();
					break;
					
				case "btn_Down_Excel":
					sheetObject1.Down2Excel();
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
	* @param {ibsheet} sheet_obj 필수 IBSheet Object
	* @return 없음
    * @author 서미진
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
    * @author 서미진
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
    * <pre> formObj
    *     loadPage();
    * </pre>
    * @return 없음
    * @author 서미진
    * @version 2010.10.13
    */
	function loadPage() {  	
    	
		for (i = 0; i < sheetObjects.length; i++) {

			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);	
		}
		
	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		
	    //Tariff Code Combo 세팅
	    ComPriTextCode2ComboItem(tariffCdComboValue, tariffCdComboText, getComboObject(comboObjects, 'tariff_cd') ,"|","\t" );	    
        form.tariff_cd.focus();
	}

    /**
    * 사용하는 Event Listener 를 등록한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     initControl();
    * </pre>
    * @return 없음
    * @author 문동규
    * @version 2009.08.25
    */
   function initControl() {
       //Axon 이벤트 처리1. 이벤트catch(개발자변경)
//       axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
//       axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
//       axon_event.addListener('keyup', "ComKeyEnter('LengthNextFocus')", document.form);
       axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
       axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
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
     * @author 서미진
     * @version 2010.10.13
     */ 
 	function initCombo(comboObj, comboNo) {
    	 
 	    switch(comboObj.id) {
 	        case "tariff_cd":
 	            with(comboObj) {
 	            	DropHeight = 200;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	IMEMode = 0;
 	            	UseAutoComplete = true;
 	            	ValidChar(2, 3);	//영어 대문자, 숫자+특수문자 포함
 	            	MaxLength = 8;
 	            }
 	            break;	        
 	    }
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
     * @author 서미진
     * @version 2010.10.13
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
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
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 20, 100);

                 var HeadTitle = "Seq|Tariff Code|Tariff Name|Tariff Type";

                 var headCount = ComCountHeadTitle(HeadTitle);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(4, 4, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false,false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] /// 
                 InitHeadRow(0, HeadTitle, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, 	dtSeq,          		40,    	daCenter,  	false,       	"Seq");           
                 InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	false, 		"tariff_code",	 	 false,    "",    dfNone,   0 ,   false,  false);                              
                 InitDataProperty(0, cnt++ , 	dtData,				500,		daLeft,		false,			"trf_nm",	 		 false,    "",    dfNone,   0 ,   false,  false);
                 InitDataProperty(0, cnt++ , 	dtData,				10,		daCenter,	false,			"trf_bzc_tp_cd",	  false,   "",    dfNone,   0 ,   false,  false);
                 
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
   * @author 서미진
   * @version 2010.10.13
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
	   try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {	
	 		
		 		case SEARCH01: // 조회
	 			
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			ComOpenWait(true);	 			
		 			formObj.f_cmd.value = SEARCH01;
		 			
		 			if (ComIsEmpty(comboObjects[0].Text)){
    	   				formObj.trf_pfx_cd.value = "";
    	   				formObj.trf_no.value = "";
    	   				formObj.trf_nm.value = "";	  
		 			}
		 			
		 			var sXml = sheetObj.GetSearchXml("ESM_PRI_3503GS.do", FormQueryString(formObj));		 		
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
	 * @author 서미진
	 * @version 2010.11.01
	 */
	function tariff_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		var arrText = text.split("|");
		
		if (arrText != null && arrText.length > 1) {   			
			formObj.trf_nm.value = comboObj.GetText(code, 1);
	   			if (ComIsEmpty(comboObj.Text)) {
	   				formObj.trf_pfx_cd.value = "";
	   				formObj.trf_no.value = "";
	   				formObj.trf_nm.value = "";	    	   				
	   			}else{
					var arr = code.split("-");
					formObj.trf_pfx_cd.value = arr[0];
					formObj.trf_no.value = arr[1];
	   			} 
	   			doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
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
    	 * @author 서미진
    	 * @version 2010.11.01
	   	 */
	   	function tariff_cd_OnKeyDown(comboObj, KeyCode) {
	   		var formObj = document.form;
	   		if (KeyCode == 13){ 	   						
			 		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
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
	 * @author 서미진
	 * @version 2010.11.01
	 */   	
	function tariff_cd_OnBlur(comboObj) {
		var formObj = document.form;
		
		var code = comboObj.FindIndex(comboObj.Code, 0);
				
		if (code != null && code != "") {
	   		var arr = code.split("-");				
			formObj.trf_pfx_cd.value = arr[0];
			formObj.trf_no.value = arr[1];
			formObj.trf_nm.value = comboObj.GetText(code, 1);
		}
	}

    	    	 

	/* 개발자 작업  끝 */