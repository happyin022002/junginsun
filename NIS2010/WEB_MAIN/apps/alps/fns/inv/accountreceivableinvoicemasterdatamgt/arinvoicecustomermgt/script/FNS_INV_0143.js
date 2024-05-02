/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0143.js
*@FileTitle : Auto Invoice Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
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
	 * @class fns_inv_0014 : fns_inv_0014 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0143() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		    = setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl              = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
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
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];	
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
				case "btn_retrive":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
		
				case "btn_new":
					sheetObject.RemoveAll();
					doActionIBSheet(sheetObjects[0],formObject,IBRESET);
					break;
		
				case "btn_downExcel":
					sheetObject.SpeedDown2Excel(-1);
					break;	
				case "btns_cust1": //CUST 조회버튼
					var v_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_cust_seq = formObject.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				
				case "btns_cust2": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_cust_nm = sheetObject.UrlEncoding(formObject.cust_nm.value);
					
					var classId = "FNS_INV_0086";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_lgl_eng_nm='+v_cust_nm+'&pop_yn=Y&classId='+classId;
			
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
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
	 * @version 2009.05.04
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		
		// combo
		combo1 = comboObjects[1];
		comboCnt = comboObjects.length;
		
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );	
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);	
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
	
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		document.form.ar_ofc_cd.focus();
		initControl();
	
	}
	
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
//		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
	}
	
	
	function obj_keypress(){
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "ymd":
				//숫자+"-"입력하기
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "eng":
				//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
				ComKeyOnlyAlphabet();
				break;
			case "engdn":
				//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
				ComKeyOnlyAlphabet('lower');
				break;
			case "engup":
				//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
				switch(event.srcElement.name){
				case "act_cust_cnt_cd":	
					//영문대문자만입력하기		    	        
					ComKeyOnlyAlphabet('upper'); 
				break;
				case "cust_nm":	    	        	
					//영문대문자+숫자 입력하기
					if(event.keyCode >= 97 && event.keyCode <= 122)
					{
						event.keyCode = event.keyCode - 32;
					}else if(event.keyCode == 32){
						event.keyCode = event.keyCode;
					}
					break;
				default:
					//영문대문자만입력하기		    	        
					ComKeyOnlyAlphabet('upper'); break;
				}
				break;
			case "num":
				//숫자만입력하기(정수,날짜,시간)
				ComKeyOnlyNumber('num');
				break;
			case "uppernum":
				//영문대+숫자 
				ComKeyOnlyAlphabet('uppernum');
				break;
			default:
				//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
				ComKeyOnlyAlphabet('upper');
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
	 * @version 2009.07.23
	 */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
	}
	
	/** 
	 * HTML Control KeyUp 이벤트 호출<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.23
	 */
	function obj_keyup() {
		var formObject = document.form;
		
		switch (event.srcElement.name) {
			case "act_cust_cnt_cd":
				var custCntCd = event.srcElement.value;
				
				if (custCntCd.length == 2) {
					formObject.act_cust_seq.focus();
				}
	 		break;
		}
	}
	
	/** 
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.23
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		switch(event.srcElement.name){
			case "act_cust_seq":
				if (formObject.act_cust_cnt_cd.value != '' && formObject.act_cust_seq.value != '') {
					var valueCustSeq = formObject.act_cust_seq.value;
					formObject.act_cust_seq.value = ComLpad(valueCustSeq,6,"0");
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
				}
			break;
			
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
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
	
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 380;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			//MergeSheet = msAll;
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			//InitRowInfo( 2, 2, 10, 100);
			InitRowInfo( 1, 1, 3, 100);                     
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			//InitHeadMode(false, true, true, true, false,false)
			InitHeadMode(true, true, true, true, false,false)
	
			var HeadTitle       = "|Office|Bound|Cust. Code|Customer Name|Invoice Sender|SML Ref|Customer Ref No Check|Local Charge Check|E-mail Address|Update date|Updated by";
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]FNS_INV_0034_02
			InitHeadRow(0, HeadTitle, true);
	
			var rowCnt = 0;
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(rowCnt, cnt++, dtHiddenStatus,	0,    daCenter,  	true,	"ibflag");
			
			InitDataProperty(rowCnt, cnt++ , dtData,     60,    	daCenter,  	false,    "ofc_cd",     						false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     50,    	daCenter,  	false,    "io_bnd_cd",     					false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     90, 		daCenter,  	false,    "cust",    							false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     200,    	daLeft,  		false,    "cust_nm",     						false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     100,    	daCenter,  	false,    "hjs_cust_svc_pic_tp_cd",	     	false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     100,    	daCenter,  	false,    "auto_inv_hjs_ref_no",	     	false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     150,    	daCenter,  	false,    "auto_inv_cust_ref_no_flg",	    false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     150,    	daCenter,  	false,    "auto_inv_locl_chg_flg",	    	false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     200,    	daLeft,  		false,    "auto_inv_eml",	     			false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     120,    	daCenter,  	false,    "upd_dt",     						false,          "",      dfNone );
			InitDataProperty(rowCnt, cnt++ , dtData,     120, 		daCenter,  	false,    "upd_usr_id",     					false,          "",      dfNone );           
			
//			FrozenCols = 3;
			
			WaitImageVisible = false; 
			
		}
		break;
	
	
	
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction,CondParam, PageNo) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {	
	
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;	
				if(validateForm(sheetObj,formObj,sAction)) { 
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.office.value = arrStr2[1];
	     			if(formObj.ar_ofc_cd.text == "All"){
	     				formObj.office.value = "ALL";
	     			}
					ComOpenWait(true);
					sheetObj.DoSearch("FNS_INV_0143GS.do",FormQueryString(formObj));
					ComOpenWait(false);
				} else {
					break;
				}
				break;
			
			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
				MakeComboObject(formObj.ar_ofc_cd, arrStr);
			
				var arrStr2 = arrStr[1].split("^");
				var ar_ofc_cd = arrStr2[3];
				formObj.ar_ofc_cd.text = ar_ofc_cd;
			
				break;
		
			case IBSEARCH_ASYNC20: // customer name 조회
//				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
//				alert("arrStr2=="+arrStr2);
//				formObj.ofc_cd.value = arrStr2[1];
				formObj.f_cmd.value = SEARCH03;

				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = formObj.act_cust_seq.value;
	
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
				
				if(CoInvShowXmlMessage(sXml) != "") {
					formObj.act_cust_seq.value = "";
					formObj.cust_nm.value = "";
					
					ComAlertFocus(formObj.act_cust_seq, CoInvShowXmlMessage(sXml));
				} else {
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
					var delt_flg = ComGetEtcData(sXml,"delt_flg");
					
					if (cust_nm != undefined && delt_flg != undefined) {
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.act_cust_seq.value = "";
						formObj.cust_nm.value = "";
					}
				}
			break;	
			case IBRESET: // New
				formObj.io_bnd_cd.Code = "A";
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
				break;
		}
	}
		
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (formObj.ar_ofc_cd.text == ""){
				ComShowCodeMessage("INV00004");
				formObj.ar_ofc_cd.focus();
				return;
			}
		}
	
		return true;
	}
	
	/**
	 * Office Combo 초기화 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     MakeComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param {ibCombo} cmbObj 필수 IBCombo Object
	 * @param {String} 콤보 리스트 스트링
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll();
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.InsertItem(0, "All", "ALL^");
		cmbObj.BackColor = "#CCFFFD";
		cmbObj.DropHeight = 190;
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
	 * @version 2009.05.04
	 */
  	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "ar_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
			break;

			case "io_bnd_cd":
				with (comboObj) {
					InsertItem(0, "All",    "A");
		            InsertItem(1, "O/B",    "O");
		            InsertItem(2, "I/B",    "I");
		            
		            Code = "A";
		            
		    		MultiSelect = false;
		    		UseCode = true;
		    		//LineColor = "#ffffff";
		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
				}
			break;		
		}
  	}
	
	/** 
	 * 팝업창(FNS_INV_0086)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.23
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObject = document.form;
		
		formObject.act_cust_cnt_cd.value = colArray[8];
		formObject.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	}
	/* 개발자 작업  끝 */