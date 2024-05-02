/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : FNS_INV_0134.js
*@FileTitle :  Surcharge Description on Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.14
*@LastModifier : 김준호
*@LastVersion : 1.0
* 2011.01.19 김준호
* 1.0 Creation
* --------------------------------------------------------
* History
* 2013.05.14 김준호 [CHM-201324641] Surcharge 통합에 의한 INV상 Description 변경
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
	 * fns_inv_0134 : fns_inv_0134 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0134()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @version 2013.05.14
	 */

	function fns_inv_0134() {
//		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
	/* 개발자 작업	*/
	
	// 공통전역변수
//	var chg_ind = true;
//	var code_ind = false;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var ROWMARK = "|";
	var FIELDMARK = "^";
	
	// IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 김준호
	 * @version 2013.05.14
	 */
	function processButtonClick(){
		// Selection sheet.
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {

				case "btn_add":			        	
					doActionIBSheet(sheetObj,formObj,IBINSERT);							 				
					break;							
		
				case "btn_delete":
	           	 	if(!validateForm(sheetObj,formObj,IBDELETE)) {
	           	 		return false;
	           	 	}
					ComRowHideDelete(sheetObj, "DelChk");
					break;	
					
				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
		
				case "btn_new":
					
					initNewControl();
					
					formObj.ar_hd_qtr_ofc_cd.focus();
					
					break;
		
				case "btn_save":	

					doActionIBSheet(sheetObj,formObj,IBSAVE);
					break; 
					
				case "btn_DownExcel":
					sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "|ibflag|DelChk|upd_usr_id|upd_dt|chg_seq");	
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
	 *     setSheetObject(sheetObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 김준호
	 * @version 2013.05.14
	 */
	function setSheetObject(sheetObj){
	
		sheetObjects[sheetCnt++] = sheetObj;
	
	}
	
	
	/** 
	 * 콤보 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
  	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "ar_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
//	                SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
				break;
		}
  	}
	
	/**
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objKeypress()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 김준호
	 * @version 2013.05.14
	 */
	function objKeypress() {
		switch(event.srcElement.dataformat){
		case "engup":
	
			switch(event.srcElement.name){
			case "ar_ofc_cd":
				//영문대문자만입력하기
				ComKeyOnlyAlphabet('upper'); 
			}
			break;              
	
		default:
			// 숫자만입력하기
			ComKeyOnlyNumber(event.srcElement);
		}
	}
	
	/**
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objDeactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 김준호
	 * @version 2013.05.14
	 */
	function objActivate() {
		ComClearSeparator (event.srcElement);
	}
	
	/**
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objDeactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 김준호
	 * @version 2013.05.14
	 */
	function objDeactivate(){
	
		switch(event.srcElement.name){
	
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			ComChkObjValid(event.srcElement);
		}
	
	}
	
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 김준호
	 * @version 2013.05.14
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
					
		doActionCombo();
		
		formObj.ar_hd_qtr_ofc_cd.focus();
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br> 
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj, 0)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호 
	 * @return 없음 
	 * @author 김준호
	 * @version 2013.05.14
	 */  
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
	
		switch(sheetID) {
			case "sheet1" : 
				with (sheetObj) {
			
					// 높이 설정
					style.height = 400;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
			
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
			
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
			
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					var HeadTitle = "|Seq|Sel.|RHQ|Office|Charge Code|Charge Name|Charge Description on Invoice";
					var headCount = ComCountHeadTitle(HeadTitle);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(9, 0, 0, true);
			
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, true, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
//					var rowCnt = 0;
			
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	
					InitDataProperty(0, cnt++ , dtHiddenStatus,   30,    daCenter,  false,    "ibflag");
			        InitDataProperty(0, cnt++ , dtSeq,            30,    daCenter,  false,    "seq",                false,   "",      dfNone);			
					InitDataProperty(0, cnt++,  dtDummyCheck,     40,    daCenter,  false,    "DelChk");
					InitDataProperty(0, cnt++ , dtComboEdit,      100,   daCenter,  false,    "ar_hd_qtr_ofc_cd",   false,    "",     dfNone,		0,	false,		true,	6);
					InitDataProperty(0, cnt++ , dtComboEdit,   	  100,   daCenter,  false,    "ar_ofc_cd",     	    true,    "",      dfNone,		0,	false,		true,	6);		           
					InitDataProperty(0, cnt++ , dtComboEdit,   	  100,   daCenter,  false,    "chg_cd",             true,    "",      dfNone,		0,	false,		true,	3);
					InitDataProperty(0, cnt++ , dtData,     	  300,   daLeft,    false,    "chg_nm",             false,   "",      dfNone,		0,	false,		false,	100);
					InitDataProperty(0, cnt++ , dtData,     	  300,   daLeft,	false,    "chg_desc_conv_ctnt", true,    "",      dfNone,		0,	true,		true,	100);
					InitDataProperty(0, cnt++ , dtHidden,     	  100,   daCenter,  false,    "chg_seq",     	    false,   "",      dfNone,		0,	false,		false,	3);
					
					InitDataValid(0,    "chg_desc_conv_ctnt",   vtEngUpOther, " ,0,1,2,3,4,5,6,7,8,9,.,-,(,)");
					
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
	 * @author 김준호
	 * @version 2013.05.14
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH:  //조회
	
			if (validateForm(sheetObj,formObj,sAction)) {

 				formObj.f_cmd.value = SEARCH;
					
 			    var arrStr1 = formObj.ar_hd_qtr_ofc_cd.Code.split("^");
				formObj.ar_hd_qtr_ofc_cd.value = arrStr1[1];
									   
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ar_ofc_cd.value = arrStr2[1];
					   
				var arrStr3 = formObj.ar_ofc_cd.Code.split("^");
				formObj.chg_cd.value = arrStr3[1];
					
				var sXml = sheetObj.DoSearch("FNS_INV_0134GS.do", FormQueryString(formObj));
				ComOpenWait(false);
			}
							
			break;
	
		case IBSAVE:        //저장
	
			if(validateForm(sheetObj,formObj,sAction)){

				formObj.f_cmd.value = MULTI;				
				var sParam = FormQueryString(formObj);
				var sParam1 = sheetObj.GetSaveString(true); 				  


				if (sParam1 == "") {
					return; 
				} else {
					sParam1 = ComSetPrifix(sParam1, "sheet1_");
					sParam = sParam + "&" + sParam1;
				}
				
				result = sheetObj.DoSave("FNS_INV_0134GS.do", sParam); 	
 
 				if(result) {
 					doActionIBSheet(sheetObj, formObj, IBSEARCH);
 				}
				
			}
			break;
		
		case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
			
			formObj.f_cmd.value = SEARCH19;
			
			var rhq = formObj.rhq.value;
			if(rhq == "SELHO"){	
				formObj.ofc_cd.value = "";
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
				var sStr = "|ALL"+ComGetEtcData(sXml,"ar_ofc_cd");
		    } else {
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
		    	var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
		    }
			var arrStr = sStr.split("|");
			MakeComboObject(formObj.ar_ofc_cd, arrStr);
			
			if(rhq == "SELHO"){	
			   formObj.ar_ofc_cd.text = arrStr[1];
		    } else {   
			   formObj.ar_ofc_cd.text = formObj.login_ofc_cd.value;
		    }
			
			break;
			
		case IBSEARCH_ASYNC11:  
			//화면 로딩시 RHQ Office 조회
			formObj.f_cmd.value = SEARCH21;
			
			var rhq = formObj.rhq.value;
			if(rhq == "SELHO"){
				formObj.ofc_cd.value = "";
	 	        var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));       
	 		    var sStr = "|ALL"+ComGetEtcData(sXml,"ar_hd_qtr_ofc_cd");	
			} else {
	 	        var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));       
	 		    var sStr = ComGetEtcData(sXml,"ar_hd_qtr_ofc_cd");	
			}

			var arrStr = sStr.split("|"); 			
			
			MakeComboObject(formObj.ar_hd_qtr_ofc_cd, arrStr); 
			formObj.ar_hd_qtr_ofc_cd.text = arrStr[1];
			
			break;
		
		case IBSEARCH_ASYNC13:  
			
			//Sheet내 combo RHQ Office 조회
			formObj.f_cmd.value = SEARCH21;
			var sXml1 = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			var sStr1 = ComGetEtcData(sXml1,"ar_hd_qtr_ofc_cd");
			addCellComboItem(sheetObj,sStr1,"ar_hd_qtr_ofc_cd",true);
			
			//Sheet내 combo AR Office 조회
			formObj.f_cmd.value = SEARCH19;
			var sXml2 = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			var sStr2 = ComGetEtcData(sXml2,"ar_ofc_cd");

			addCellComboItem(sheetObj,sStr2,"ar_ofc_cd",true);
						
			//Sheet내 combo Charge Code 조회
			formObj.f_cmd.value = SEARCH13;
			var sXml3 = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			var sStr3 = ComGetEtcData(sXml3,"chg_cd");
			addCellComboItem(sheetObj,sStr3,"chg_cd",true);
			
			break;
			
		
		case IBSEARCH_ASYNC12:  
			//화면 로딩시 Charge Code 조회
			formObj.f_cmd.value = SEARCH13;
			
		        var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
				var sStr = "|ALL"+ComGetEtcData(sXml,"chg_cd");
				var arrStr = sStr.split("|"); 			
				
				MakeComboObject(formObj.chg_cd, arrStr); 


			break;
	    
		case IBSEARCH_ASYNC14:  
			//화면 로딩시 RHQ Office 조회하여 ofc_cd setting.
			formObj.f_cmd.value = SEARCH21;
							
		    var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
		    var sStr = ComGetEtcData(sXml,"ar_hd_qtr_ofc_cd");
			var arrStr = sStr.split("|"); 
					
			formObj.rhq.value = arrStr[1];
			
			break;
			

		case IBINSERT:      // 입력
		
// 			if(!validateForm(sheetObj,formObj,sAction)) return;
			
 			var newRow = sheetObj.DataInsert(-1); 
 			doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC13);
 		    			
 			sheetObj.CellValue2(newRow,'ar_hd_qtr_ofc_cd') = formObj.rhq.value;
 			sheetObj.CellValue2(newRow,'ar_ofc_cd') = formObj.login_ofc_cd.value;
 			
 			sheetObj.CellValue2(newRow,'chg_cd') = "";
 			sheetObj.CellValue2(newRow,'chg_nm') = "";
 			
 			if (formObj.login_ofc_cd.value != formObj.rhq.value) { //RHQ가 아니면 수정불가
 				if(formObj.rhq.value != 'SELHO'){
 					sheetObj.CellEditable(newRow, 'ar_ofc_cd') = false;
 					sheetObj.CellEditable(newRow, 'ar_hd_qtr_ofc_cd') = false;
 				}
 			} 
 				
			break;
			
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     validateForm(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return boolean
	 * @author 김준호
	 * @version 2013.05.14
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
		
			case IBSAVE : // C,U,D.
				with (formObj) {
						
					//1. Data의 변화가 있는지 체크한다.
					var chkCnt = 0;
					var idx = sheetObj.RowCount;
					var isChanged = false;
	
					if (!(idx > 0)) {
						ComShowCodeMessage("INV00091");  //'There is no data to save.'
						return false;
					}
						
					for (var i=1; i<idx+1; i++) {
						if (sheetObj.CellValue(i,"ibflag") =='I' || sheetObj.CellValue(i,"ibflag") == 'U' || sheetObj.CellValue(i,"ibflag") == 'D') {
							isChanged= true;
						}
					}
					
					if (!isChanged) {
						ComShowCodeMessage("INV00091");
						return false;
					}
					
					for (var i=1; i<idx+1; i++) {
												
						// 1. Charge description 이 null인지 체크한다.
						if (sheetObj.CellValue(i,"chg_desc_conv_ctnt").trim() =='') {
							ComShowCodeMessage("INV00167");
							sheetObj.SelectCell(i, 'chg_desc_conv_ctnt');
							return false;
						}
						
						// 2. AR Office Code가 null인지 체크한다.
						if (sheetObj.CellValue(i,"ar_ofc_cd").trim() =='') {
							ComShowCodeMessage("INV00168");
							sheetObj.SelectCell(i, 'ar_ofc_cd');
							return false;
						}
	
						// 3. Charge Code가 null 인지 체크한다
						if (sheetObj.CellValue(i,"chg_cd").trim() =='') {
							ComShowCodeMessage("INV00169");
							sheetObj.SelectCell(i, 'chg_cd');
							return false;
						}
						
						// 4. Charge Name가 null 인지 체크한다
						if (sheetObj.CellValue(i,"chg_nm").trim() =='') {
							ComShowCodeMessage("INV00170");
							sheetObj.SelectCell(i, 'chg_nm');
							return false;
						}
					}
				}
				break;
	
			
			case IBSEARCH :

				if(formObj.ar_ofc_cd.value == "") {
					 ComShowCodeMessage("COM12114", "Office");
					 ar_ofc_cd.focus();
					 return false;
				 }
				 break;
				 
				
			case IBDELETE:

				if (sheetObj.CheckedRows("DelChk") == 0) {
					ComShowMessage(msgs["INV00025"]);   //'Nothing was selected.'
					return false;
				} else if (sheetObj.CheckedRows("DelChk") > 0) {
					if(!ComShowCodeConfirm("INV00028")) return;  //'Do you really want to delete?'
				}
				
				break;
			}	
		return true;
	}
	
	/** 
	 * office code select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function MakeComboObject(cmbObj, arrStr) {
		
		cmbObj.RemoveAll();
		
//		for (var i = 1; i < arrStr.length;i++ ) {
//			var ar_hd_qtr_ofc_cd = '';
//			if (arrStr[i] != '') {
//				ar_hd_qtr_ofc_cd = arrStr[i];
//			}
//			cmbObj.InsertItem(i-1, ar_hd_qtr_ofc_cd, ar_hd_qtr_ofc_cd);
//		}
//		
		cmbObj.Code = arrStr[1];
////		cmbObj.BackColor = "#CCFFFD";
		
  		for (var i = 1; i < arrStr.length;i++ ) {
  			var arrStr2 = arrStr[i].split("|");
  			if(arrStr2 != ""){
  				cmbObj.InsertItem(i-1, arrStr2, arrStr2);
  			}
  			//var ar_ofc_cd = arrStr2[1];
  			//cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);
  		}
  		cmbObj.text = arrStr[1];
		
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
	 * Initialize object's event.
	 */
	function initControl() {
			
		var formObj = document.form;
		// Catching event.
		axon_event.addListenerFormat("keypress", "obj_keypress", formObj);
//		axon_event.addListenerFormat("focus", "obj_activate", formObj);
//		axon_event.addListenerForm("keyup", "obj_keyup", formObj);
//		axon_event.addListenerForm("blur", "obj_deactivate", formObj);
		axon_event.addListenerForm("change", "obj_onchange", formObj);
			
	}
	
	/** 
	 * Initialize object's event.
	 */
	function initNewControl() {
			
		var formObj = document.form;
				
		if(formObj.rhq.value == "SELHO"){
			formObj.ar_hd_qtr_ofc_cd.text = "ALL";
			formObj.ar_ofc_cd.text = "ALL";
			formObj.chg_cd.text = "ALL";
		} else {
			formObj.ar_ofc_cd.text = formObj.ofc_cd.value ;	
			formObj.chg_cd.text = "ALL";
		}
		
		sheetObjects[0].RemoveAll();
		
	}
	
	/**
	 * 그리드내 콤보필드에 데이터를 추가해준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     addCellComboItem(sheetObj,comboValues,colName,isCellCombo);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} comboValues combo 로 생성할 values
	 * @param {String} colName combo 가 위치할 GRID 내 column 명
	 * @param {String} isCellCombo  일반 combo 와 cell combo 구분 flag 
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
		
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
					
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
					
				if (comboItem[0] != "") {
					comboTxt += comboItem[0];
					//comboVal += comboItem[0];
					if (comboItem[1] != undefined) {
						comboVal += comboItem[0] +"^"+ comboItem[1];
					} else {
						comboVal += comboItem[0];
					}
	
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
	 * On change in grid.
	 * 
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @param value
	 */
	function sheet1_OnChange(sheetObj, row, col, value) {
		var formObj = document.form;
		var colSaveName = sheetObj.ColSaveName(col);

		switch (colSaveName) {

		case "chg_cd":
			
			if (sheetObj.cellValue(row,'chg_cd') != "") {
				if(!fn_chg_nm_sheet(sheetObj, row, col)){
					sheetObj.SelectCell(row, 'chg_cd');
				}
			}	
			
			break;
			
		case "ar_ofc_cd":
//
			break;
			
			
		default :
			break;
		}
	
	}
	
	 /**
	  * Retrieve charge name.
	  */
	 function fn_chg_nm_sheet(sheetObj,row,col) {

		 document.form.f_cmd.value = SEARCH20;
		 var chg_cd = sheetObj.CellValue(row,'chg_cd');
		 
		 var chg_nm= "";
		 
		 if (chg_cd.trim()!="") {
		
			 sheetObj.CellValue2(row,'chg_Cd') = chg_cd;
			 
			// 중복 체크를한다.
			 var idx = sheetObj.RowCount;
			 
			 for (var i =1;i<idx+1;i++) {
				var arOfcCdTmp = sheetObj.CellValue(i,'ar_ofc_cd');
				var chgCdTmp = sheetObj.CellValue(i,'chg_cd');
				var ar_ofc_cd = sheetObj.CellValue(row,'ar_ofc_cd');
				var chg_cd = sheetObj.CellValue(row,'chg_cd');

				if ( i != row && ar_ofc_cd == arOfcCdTmp && chg_cd == chgCdTmp) {
					sheetObj.CellValue2(row,'chg_nm') = "";
					sheetObj.CellValue2(row,'chg_desc_conv_ctnt') = "";
					ComShowCodeMessage("INV00052");  //Data is duplicated.
				 	return false;
			 	}
			}
			 		 
			 var queryParam = 	"f_cmd=120&chg_cd="+chg_cd;
			 var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", queryParam);
			 
			 chg_nm = ComGetEtcData(sXml,"chg_nm");
			 
			 if (chg_nm == undefined) {
				 sheetObj.CellValue2(row,'chg_nm') = "";
				 ComShowCodeMessage("INV00169");
				 return false;
			 } else {
				 sheetObj.CellValue2(row,'chg_nm') = chg_nm;
				 return true;
			 }
		 }
	 }
	 
	 /**
	  * On blur in grid.
	  * 
	  * @param sheetObj
	  * @param row
	  * @param col
	  * @param value
	  */
	 function sheet1_OnBlur(sheetObj, row, col, value) {
		 var formObj = document.form;
		 var colSaveName = sheetObj.ColSaveName(col);
		 
		 switch (colSaveName) {
		 
		 case "chg_desc_conv_ctnt":
			 
			 sheetObj.cellValue2(row,'chg_desc_conv_ctnt') = value.toUpperCase();
			 break;
		 default :
			 break;
		 }
	 }
	 
	 /**
	  * On blur in grid.
	  * 
	  * @param sheetObj
	  * @param row
	  * @param col
	  * @param value
	  */
	 function doActionCombo() {
			var formObj = document.form;
			
			//RHQ
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC14);
			
			//RHQ
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC11);
			
			//AR_OFC_CD
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
			
			//CHG_CD
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC12);
	 }
	 

	 
	/* 개발자 작업  끝 */