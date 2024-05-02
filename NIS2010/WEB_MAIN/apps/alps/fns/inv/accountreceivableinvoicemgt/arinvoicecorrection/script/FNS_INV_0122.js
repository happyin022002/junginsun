/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0122.js
*@FileTitle :  Marking "Reverse Charge" by I/F No 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.05.27
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
	 * @class FNS_INV_0122 : FNS_INV_0122 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0122() {
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
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObj = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
		
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			
				case "btn_New":
					removeAll(formObj);
				break;
			
				case "btn_Save":
					doActionIBSheet(sheetObj,formObj,IBSAVE);
				break;
				
				
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

	/** 
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/** 
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * <br><b>Example :</b>
	 * <pre>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
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
		
		
		initControl();
		
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01); 	
		
		//버튼 초기화
		ComBtnDisable("btn_Save");
		
		formObj.bl_src_no.focus();
	}

	/** 
	 * 시트 초기설정값, 헤더 정의<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * </pre>
	 * @param sheetObj 시트오브젝트
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
		
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 350;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
				
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;//msPrevColumnMerge + msHeaderOnly; //msHeaderOnly;
				
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
				
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
				
					var HeadTitle = "||Reverse \n Charge|I/F No.|Act Cust.|Type|I/F Date|Good Date|Invoice No.|Cur|Amount|Ex.Rate|Local Amount|";
					var headCount = ComCountHeadTitle(HeadTitle);
				
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
				
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, true, true, false, false);
				
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				
					var rowCnt = 0;
					
					//데이터속성              [ROW,      COL,    DATATYPE,       WIDTH,  DATAALIGN,      COLMERGE,   SAVENAME,               KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		0,		daCenter,		true,		 "merge_chk",			false,			"",		dfNone,    		0,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	30,		daCenter,		true,		 "ibflag");
					InitDataProperty(rowCnt,	cnt++,	dtCheckBox,		80,		daCenter,		true,		 "DelChk");
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		true,		 "ar_if_no",			false,			"",		dfNone,      	0,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtData,			80,		daCenter,		true,		 "act_cust_cd",			false,			"",		dfNone,      	0,		false,		false);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daCenter,		true,		 "rev_tp_src",			false,			"",		dfNone,			0,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daCenter,		true,		 "bl_inv_if_dt",		false,			"",		dfDateYmd,    	0,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daCenter,		true,		 "bl_inv_cfm_dt",		false,			"",		dfDateYmd,		0,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daCenter,		true,		 "inv_no",				false,			"",		dfNone,			0,		false,		false);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			40,		daCenter,		true,		 "curr_cd",				false,			"",		dfNone,     	0,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		false,		 "chg_amt",				false,			"",		dfFloat,		2,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		false,		 "inv_xch_rt",			false,			"",		dfFloat,		6,		false,		false);
					
					InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		false,		 "locl_amt",			false,			"",		dfFloat,    	2,		false,		false);
					InitDataProperty(rowCnt,	cnt++,	dtHidden,		60,		daCenter,		false,		 "rvs_chg_flg",			false,			"",		dfNone,    		0,		false,		false);
										
					
					CountPosition = 2;
					SelectHighLight = false;

				}
			break;			
		}
	}
	
	
	/** 
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function initControl() {
		var formObj = document.form;
		
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('focus', 'obj_activate', formObj);
	}
	
	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function obj_keypress() {
		var formObj = document.form;
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, ".-"); 
			break;
			case "int":
				//숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement,"-"); 
			break;
			case "engup":
				switch(event.srcElement.name){
					case "bl_src_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
				}
				break;
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}

	/** 
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 (포커스가 들어갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function obj_activate() {
		var formObj = document.form;
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
		event.srcElement.select();
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
	 * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
	 * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH_ASYNC01: // 화면 로딩시 AR_OFFICE_LIST 조회
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			
			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
			var arrStr = sStr.split("|");
			
			MakeComboObject2(formObj.ar_ofc_cd, arrStr);
		
			var arrStr2 = "";
			var ar_ofc_cd = "";
		
			for(i=1;i<arrStr.length;i++){
				arrStr2 = arrStr[i].split("^");
				if(arrStr2[1]==arrStr2[3]){
					ar_ofc_cd = arrStr2[1];
		
					formObj.ofc.value = ar_ofc_cd;
					formObj.ofc_cd.value = formObj.ofc.value;	
				}
			}
			formObj.ar_ofc_cd.text = ar_ofc_cd;	
			
			ComOpenWait(false);
			
			break;
			
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					
					var sXml = sheetObj.GetSearchXml("FNS_INV_0122GS.do", FormQueryString(formObj));
					
					var arrXml = sXml.split("|$$|");
					
					if (sXml.indexOf("ERROR") < 1){
						if ( arrXml[0] != null){
							sheetObj.LoadSearchXml(arrXml[0]);
							if(sheetObjects[0].RowCount==0){
								ComShowCodeMessage("COM130401");
								formObj.bl_src_no.select();
							}
						}
					}
						     		
				}
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					
					var rowCnt = sheetObj.RowCount;  
					for(i=1; i<=rowCnt; i++) {
					    			
			    		if(sheetObj.CellValue(i, "DelChk")==1) {
			    			sheetObj.CellValue2(i, "rvs_chg_flg") = "Y";
			    		} else {
			    			sheetObj.CellValue2(i, "rvs_chg_flg") = "N";
			    		}
					}
			        
									
					var sXml = sheetObj.GetSaveXml("FNS_INV_0122GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(true,true),"sheet1_") );
					
					
					if (sXml.indexOf("ERROR") < 1){
						ComShowCodeMessage("INV00051");
					}
					else {
						ComShowCodeMessage("INV00053");
					}
					ComBtnDisable("btn_Save");
				}
			break;
		}
	}
	
	
	/** 
     * sheet상에서 데이타를 받아 sheet의 콤보박스에 세팅. <br>
     * curr_cd : currency code 세팅
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj : 시트오브젝트  
     * @param  {String} comboValues : 세팅할 값
     * @param  {String} colName : sheet에서 세팅할 컬럼
     * @return (boolean) isCellCombo : CellComboItem, InitDataCombo
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */		
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo, sRow) {
		//var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
		var ROWMARK = "|";
		var FIELDMARK = "=";

		comboValues = "|"+" "+comboValues;		
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 1 ; i < comboItems.length ; i++) {				
				comboItem = comboItems[i].split(FIELDMARK);
				if (comboItem[0] != "") {
					comboTxt += comboItem[0];
					comboVal += comboItem[0];
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}
			}
		}
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal);
		}
	}
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:      //조회
				with(formObj){
					if(bl_src_no.value == "") {
						ComShowCodeMessage("INV00004");
						bl_src_no.focus();
						return false;
					}
				}
			break;
			
					
			case IBSAVE:      //저장
				with(formObj){
				}
			break;
			
		}
		return true;
	}
	
	/** 
	 * 화면 초기화<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.05
	 */
	function removeAll(formObj) {
		
		//B/L & Charge 그리드 초기화
		sheetObjects[0].RemoveAll();
		//버튼 초기화
		ComBtnDisable("btn_Save");
		
		formObj.bl_src_no.value="";
	}
	
	
    /** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.10.05
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		
		var rowCnt = sheetObj.RowCount;  
		for(i=1; i<=rowCnt; i++) {
		    			
    		if(sheetObj.CellValue(i, "rvs_chg_flg")=="Y") {
    			sheetObj.CellValue2(i, "DelChk") = 1;
    		} else {
    			sheetObj.CellValue2(i, "DelChk") = 0;
    		}
		}
        
    	ComBtnEnable("btn_Save");	
	}
	
    /** 
     * OnChange 이벤트 발생시[CR 그리드 입력항목 변경] 호출되는 함수 <br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {IBSheet} sheetObj        
     * @param  {rownum} Row        
     * @param  {colnum} Col        
     * @param  {object} Value        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.10.05
     */
	function sheet1_OnChange(sheetObj,Row,Col,Value){
		var formObj = document.form;
		
	}
    
     function sheet1_OnClick(sheetObj, row, col ,value) {
      	
     	 var rowCnt = sheetObj.RowCount;
         var arIfNo = sheetObj.CellValue(row,"ar_if_no");
         var delChk = sheetObj.CellValue(row,"DelChk");         
         var colSaveName = sheetObj.ColSaveName(col);
          
         switch(colSaveName) {
 	       	case "DelChk" :
 	
 	    		for(i=1; i<=rowCnt; i++) {
  	    		    			
 		    		if(delChk == 1) {
 		    			if(i == row) continue;
 		    			if(arIfNo == sheetObj.CellValue(i, "ar_if_no")) {
 		    				sheetObj.CellValue2(i, "DelChk") = 0;
 		    				//sheetObj.CellValue2(i, "rvs_chg_flg") = "N";
 		    			}
 		    		} else if(delChk == 0) {
 		    			if(i == row) continue;
 		    			if(arIfNo == sheetObj.CellValue(i, "ar_if_no")) {
 		    				sheetObj.CellValue2(i, "DelChk") = 1;
 		    				//sheetObj.CellValue2(i, "rvs_chg_flg") = "Y";
 		    			}
 		    		}
 	    		}
 	    		break;
 	    	
         } // end switch
         
     }
	
	 
	
	 
	/**
	 * 콤보 생성<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    MakeComboObject2(formObj.ar_ofc_cd, arrStr);
	 * </pre>
	 * @param object cmbObj
	 * @param String arrStr
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function MakeComboObject2(cmbObj, arrStr) {
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
		}
	
		cmbObj.DropHeight = 190;
	}       

	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office값 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd_OnChange(document.form,'HAMBB','HAMBB');
	 * </pre>
	 * @param object comboObj
	 * @param string value
	 * @param string text
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function ar_ofc_cd_OnChange(comboObj,value,text){ 
		sheetObjects[0].RemoveAll();
	
		arrStr = value.split("^");
		document.form.ofc.value = arrStr[1];
		document.form.ofc_cd.value = arrStr[1];
	}
	/* 개발자 작업  끝 */