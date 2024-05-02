/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0123.jsp
*@FileTitle :  SVAT Reg. NO for CMBBB
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 권 민
*@LastVersion : 1.0
* 2011.10.11 권 민
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
	 * fns_inv_0123 : fns_inv_0123 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0123()
	 * </pre>
	 * @param	없음
	 * @return	없음
	 * @author	권 민
	 * @version 2011.10.11
	 */
	function fns_inv_0123() {
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
	 * @author 권 민
	 * @version 2011.10.11
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
	
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
		
				case "btn_new":
	                ComResetAll();
	              //버튼 초기화
	    			ComBtnDisable("btn_save");
					break;
		
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					
					doActionIBSheet(sheetObject,formObject,IBSEARCH);	  
					break; 
					
				case "btn_downExcel":
					sheetObject.SpeedDown2Excel(-1);
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
	 * @author 권 민
	 * @version 2011.10.11
	 */
	function setSheetObject(sheetObj){
		sheetObjects[sheetCnt++] = sheetObj;
	}
	
	/**
	 * 업무 자바스크립트 OnKeyPress 이벤트 Catch <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    initControl()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 권 민
	 * @version 2011.10.11
	 */
	function initControl() {
		var form = document.form;
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerForm ('keypress', 'objKeypress', form);
		axon_event.addListener ('click', 'obj_click', 'gubun');
	}
	
	/**
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objKeypress()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 권 민
	 * @version 2011.10.11
	 */
	function objKeypress() {
		switch(event.srcElement.dataformat){
		case "engup":
	
			switch(event.srcElement.name){
				case "cust_cnt_cd":	
					//영문대문자만입력하기		    	        
					ComKeyOnlyAlphabet('upper'); 
				break;
				
				case "svat_rgs_no":	
					//영문대문자+숫자입력하기+space
					ComKeyOnlyAlphabet('uppernum',"32|64"); 
				break;
			}
		break;
	
		default:
			// 숫자만입력하기
			ComKeyOnlyNumber(event.srcElement);
		}
	}
	
	/**
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objDeactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 권 민
	 * @version 2011.10.11
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
	 * @author 권 민
	 * @version 2011.10.11
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
	
		}
		initControl();
		
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
		//버튼 초기화
		ComBtnDisable("btn_save");
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
	 * @author 권 민
	 * @version 2011.10.11
	 */  
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      //t1sheet1 init
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
			
			var HeadTitle = "Customer Code|Customer Name|SVAT Reg. No.|Tax payer ID|Update Date|User ID||";
			var headCount = ComCountHeadTitle(HeadTitle);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);
	
			//UseUTF8 = true;
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						
			InitDataProperty(0,	cnt++,	dtData,		130,	daCenter,	true,	"cust_cd",			false,	"",	dfNone,		0,	false,	false,	0);
			InitDataProperty(0,	cnt++,	dtData,		300,	daCenter,	true,	"cust_lgl_eng_nm",	false,	"",	dfNone,		0,	false,	false,	0);
			InitDataProperty(0,	cnt++,	dtData,		160,	daCenter,	true,	"spnd_vat_rgst_no",	false,	"",	dfEngUpKey,	0,	true,	true,	15);
			InitDataProperty(0,	cnt++,	dtData,		180,	daCenter,	true,	"cust_rgst_no",		false,	"",	dfNone,		0,	false,	false,	0);
			
			InitDataProperty(0,	cnt++,	dtData,		110,	daCenter,	true,	"upd_dt",		false,	"",	dfNone,		0,	false,	false,	0);
			InitDataProperty(0,	cnt++,	dtData,		 80,	daCenter,	true,	"upd_usr_id",		false,	"",	dfNone,		0,	false,	false,	0);
			InitDataProperty(0, cnt++ , dtHidden,	80,    	daCenter, 	false,	"cust_cnt_cd",		false,	"",	dfNone,		0,	false,	true);
            InitDataProperty(0, cnt++ , dtHidden,	80,    	daCenter, 	false,	"cust_seq",			false,	"",	dfNone,		0,	false,	true);
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
	 * @author 권 민
	 * @version 2011.10.11
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
	
			case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)) {
				if(sheetObj.id == "sheet1") {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("FNS_INV_0123GS.do", FormQueryString(formObj));
				}
			}			
			
			// Add. 2016.06.22
			if(formObj.gubun[2].checked || formObj.chkGubun.value =="2"){
				ComBtnDisable("btn_save");
			}
			break;
		
			case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)){
				formObj.f_cmd.value = MULTI;

				var sXml = sheetObj.GetSaveXml("FNS_INV_0123GS.do", FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(true,true),"sheet1_") );
				
				if (sXml.indexOf("ERROR") < 1){
					ComShowCodeMessage("INV00051");
				}
				else {
					ComShowCodeMessage("INV00053");
				}
				ComBtnDisable("btn_save");
					
			} else {
				return;
			}
		    
			break;
		}
	}
	 
	 /** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object        
     * @return 없음
	 * @author 권 민
	 * @version 2011.10.11
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		
		var rowCnt = sheetObj.RowCount;  
		
		// 조회온 데이터가 있을 때 저장버튼 활성화
		if(rowCnt > 0){
			ComBtnEnable("btn_save");
		}else{
			//버튼 초기화
			ComBtnDisable("btn_save");
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
	 * @author 권 민
	 * @version 2011.10.11
	 */
	function validateForm(sheetObj,formObj,sAction){
		 switch(sAction) {
			case IBSEARCH:      //조회
				with(formObj){
					if(formObj.gubun[0].checked) {
						if(formObj.cust_cnt_cd.value == "" || formObj.cust_seq.value == ""){
							ComShowCodeMessage("INV00144");
							return false;
						}
						formObj.chkGubun.value	= formObj.gubun[0].value;
					}else if(formObj.gubun[1].checked) {
						if(formObj.svat_rgs_no.value == ""){
							ComShowCodeMessage("INV00145");
							return false;
						}
						formObj.chkGubun.value	= formObj.gubun[1].value;
					}else if(formObj.gubun[2].checked) { // add. 2016.06.22
						formObj.chkGubun.value	= formObj.gubun[2].value;
					}
				}
			break;
					
			case IBSAVE:      //저장
				with(sheetObj){
					var svat_rgs_no		= sheetObj.CellValue(1, 2);
					var tax_payer_id	= sheetObj.CellValue(1, 3);
	
					if (tax_payer_id == "") {
						ComShowCodeMessage("INV00146");
						return false;
					}
					
					//[2013.01.18][CHM-201322544] svat_reg_no 삭제 기능허용. 
					// svat_reg_no 삭제를 허용하기 위해 null값 입력 가능하도록 주석처리함. svat_reg_no null값 입력은 삭제를 의미함.  
//					if(svat_rgs_no == ""){
//						ComShowCodeMessage("INV00147");
//						return false;
//					}
				}
			break;
			
		}
		return true;
	}
	 
	 /** 
	 * Radio 변경<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author	권 민
	 * @version 2011.10.12
	 */
	function obj_click() {
		var formObj     = document.form;	
		
		if (formObj.gubun[0].checked) {
			formObj.svat_rgs_no.value = "";
			ComBtnDisable("btn_save");
		} else if(formObj.gubun[1].checked){
			formObj.cust_cnt_cd.value	= "";
			formObj.cust_seq.value		= "";
			ComBtnDisable("btn_save");
		} else if(formObj.gubun[2].checked){
			formObj.cust_cnt_cd.value	= "";
			formObj.cust_seq.value		= "";
			formObj.svat_rgs_no.value = "";
			ComBtnDisable("btn_save");
		}
   }
		
	/* 개발자 작업  끝 */