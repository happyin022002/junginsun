/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0097.js
*@FileTitle : Invoice Letter Wording Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.03 박정진
* 1.0 Creation
* -------------------------------------------------------- 
 * History
 * 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
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
     * @class fns_inv_0097 : fns_inv_0097 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function fns_inv_0097() {
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
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//RD
    var rdObjects = new Array();
	var rdCnt = 0;
	
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
	 * @version 2009.07.03
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var rdObject = rdObjects[0];
		/*******************************************************/
		
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btns_port": //port 조회버튼
					var loc_cd_val = formObject.port_cd.value;
					var sys_code = "ENIS";
	            
					var loc_port_ind_val = "1";
	            
					var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";
					var classId = "COM_ENS_051";
					var param = '?loc_cd='+loc_cd_val+'&sysCode='+sys_code+'&classId='+classId;
	 			  
					ComOpenPopup('/hanjin/COM_ENS_051.do' + param, 900, 450, 'getCOM_ENS_051_1', dispaly);
				break;
				
				case "btns_cust1": //CUST 조회버튼
					var v_cust_cnt_cd = formObject.cust_cnt_cd.value;
					var v_cust_seq = formObject.cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
			
				case "btns_cust2": //CUST 조회버튼
					var v_cust_cnt_cd = formObject.cust_cnt_cd.value;
					var v_cust_seq = formObject.cust_seq.value;
					var v_cust_nm = sheetObject1.UrlEncoding(formObject.cust_nm.value);
					
					var classId = "FNS_INV_0086";
					var param = '?cust_cnt_cd='+v_cust_cnt_cd+'&cust_seq='+v_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
				break;
			
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					//ComBtnEnable("btn_Print");
				break;
				
				case "btn_New":
					removeAll(formObject);
					changeSearchOption('V');
				break;
				
				case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
				
				case "btn_Delete":
					doActionIBSheet(sheetObject1,formObject,REMOVE);
				break;
				
				case "btn_Print":
					rdOpen(rdObjects[0], formObject);
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
	 * @version 2009.07.03
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
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
	 * @version 2009.07.03
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                  //나머지는 속성이나 함수는 필요하지 않으므로 모두 생략한다.
	                
	              //전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msNone;

	    			//전체Edit 허용 여부 [선택, Default false]
	    			Editable = true;
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(1, 1, 15, 100);
	    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			InitColumnInfo(2, 0, 0, true);

	    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			InitHeadMode(true, true, false, true, false, false)
	    			var HeadTitle1 = " |";

	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle1, true);

	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtHiddenStatus,30,    daCenter,  true,    "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,         40,    daCenter,  false,   "Seq");
				}
			break;
		}
	}
	
	/** 
	 * RD 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {RdObject} rdObject
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.03
	 */
	function initRdConfig(rdObject){
		var Rdviewer = rdObject;

		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0); 
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
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
	 * @version 2009.07.03
	 */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListenerForm ('keyup', 'obj_keyup', form);
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
	 * @version 2009.07.03
	 */
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;
			case "int":
				//숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "engup":
				switch(event.srcElement.name){
					case "vvd":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;

					case "port_cd":
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					
					case "cust_cnt_cd":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
					break;
				}
				break;
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
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
	 * @version 2009.07.03
	 */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
		event.srcElement.select();
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
	 * @version 2009.07.03
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		
		switch(event.srcElement.name){
			case "cust_seq":
				//Grid Charge 의 Cust Code 에 동일하게 넣어줌.
				if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value != '') {
					var valueCustSeq = formObj.cust_seq.value;
					formObj.cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC20);
	
					var custCd = "";
					if (formObj.cust_nm.value != '') {
						custCd = formObj.cust_cnt_cd.value+ComLpad(valueCustSeq,6,"0");
					}
					else {
						custCd = "";
						formObj.cust_seq.focus();
					}
				}
				else {
					formObj.cust_nm.value = '';
				}
			break;
		
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
        }
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
	 * @version 2009.04.27
	 */
	function obj_keyup() {
		var formObj = document.form;
		
		switch (event.srcElement.name) {
			case "cust_cnt_cd":
				var custCntCd = event.srcElement.value;
				
				if (custCntCd.length == 2) {
					formObj.cust_seq.focus();
				}
	 		break;
		}
	}

	function changeSearchOption(value) {
		var formObj = document.form;
		
		formObj.vvd.value = "";
		formObj.port_cd.value = "";
		formObj.cust_cnt_cd.value = "";
		formObj.cust_seq.value = "";
		formObj.cust_nm.value = "";
		formObj.subject.value = "";
		formObj.text1.value = "";
		formObj.high_light1.checked = false;
		formObj.text2.value = "";
		formObj.high_light2.checked = false;
		formObj.text3.value = "";
		formObj.high_light3.checked = false;
		formObj.text4.value = "";
		formObj.high_light4.checked = false;
		
		if(value == 'V') {
			ComEnableObject(formObj.vvd,true);
			ComEnableObject(formObj.port_cd,true);

			formObj.vvd.className = "input1";
			formObj.vvd.tabIndex = "";
			formObj.port_cd.className = "input1";
			formObj.port_cd.tabIndex = "";

			ComEnableObject(formObj.cust_cnt_cd,false);
			ComEnableObject(formObj.cust_seq,false);

			formObj.cust_cnt_cd.className = "input2";
			formObj.cust_cnt_cd.tabIndex = "-1";
			formObj.cust_seq.className = "input2";
			formObj.cust_seq.tabIndex = "-1";
			
			formObj.vvd.focus();
		}
		else {
			ComEnableObject(formObj.cust_cnt_cd,true);
			ComEnableObject(formObj.cust_seq,true);
			
			formObj.cust_cnt_cd.className = "input1";
			formObj.cust_cnt_cd.tabIndex = "";
			formObj.cust_seq.className = "input1";
			formObj.cust_seq.tabIndex = "";

			ComEnableObject(formObj.vvd,false);
			ComEnableObject(formObj.port_cd,false);
			
			formObj.vvd.className = "input2";
			formObj.vvd.tabIndex = "-1";
			formObj.port_cd.className = "input2";
			formObj.port_cd.tabIndex = "-1";
			
			formObj.cust_cnt_cd.focus();
		}
		
		formObj.ar_ofc_cd.Enable = true;
		
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Print");
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
	 * @version 2009.07.03
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;

					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.ofc_cd.value = arrStr2[1];
	     			
	     			ComOpenWait(true);  //대기이미지 표시
	     			
	     			var vvdStr = formObj.vvd.value;
	     			var portCdStr = formObj.port_cd.value;
	     			var custCntCdStr = formObj.cust_cnt_cd.value;
	     			var custSeqStr = formObj.cust_seq.value;
	     			
	     			var sXml = sheetObj.GetSaveXml("FNS_INV_0097GS.do", FormQueryString(formObj));
	     			sheetObj.LoadSearchXml(sXml);
	     			
	    		    ComOpenWait(false); //대기이미지 숨김
	     			
	    		    // 조회된 데이터가 있는 경우
	     			if(sXml.indexOf("TOTAL='0'") < 1){
	     				if (formObj.search_option[0].checked) {
		     				ComEnableObject(formObj.vvd,false);
		     				ComEnableObject(formObj.port_cd,false);
		     				formObj.vvd.className = "input2";
		     				formObj.vvd.tabIndex = "-1";
		     				formObj.port_cd.className = "input2";
		     				formObj.port_cd.tabIndex = "-1";
		     				
		     				formObj.ar_ofc_cd.Enable = false;
		     				
		     				ComBtnEnable("btn_Save");
			     			ComBtnEnable("btn_Delete");
			     			ComBtnEnable("btn_Print");
			     			
		    		    	formSettingVal(formObj,sXml);
	     				}
	     				else {
		     				ComEnableObject(formObj.cust_cnt_cd,false);
		     				ComEnableObject(formObj.cust_seq,false);
		     				formObj.cust_cnt_cd.className = "input2";
		     				formObj.cust_cnt_cd.tabIndex = "-1";
		     				formObj.cust_seq.className = "input2";
		     				formObj.cust_seq.tabIndex = "-1";
		     				
		     				formObj.ar_ofc_cd.Enable = false;
		     				
		     				ComBtnEnable("btn_Save");
			     			ComBtnEnable("btn_Delete");
			     			ComBtnEnable("btn_Print");
			     			
		    		    	formSettingVal(formObj,sXml);
	     				}
	    		    }
	     			// 조회된 데이터가 없는 경우
	    		    else {
	    		    	if (formObj.search_option[0].checked) {
		    		    	initFormSettingVal(formObj,sXml);
		    		    	
			     			formObj.vvd.value = vvdStr;
			     			formObj.port_cd.value = portCdStr;
			     			
		     				ComEnableObject(formObj.vvd,false);
		     				ComEnableObject(formObj.port_cd,false);
		     				formObj.vvd.className = "input2";
		     				formObj.vvd.tabIndex = "-1";
		     				formObj.port_cd.className = "input2";
		     				formObj.port_cd.tabIndex = "-1";
		     				
		     				formObj.ar_ofc_cd.Enable = false;
	
		     				ComBtnEnable("btn_Save");
	    		    	}
	    		    	else {
		    		    	initFormSettingVal(formObj,sXml);
		    		    	
			     			formObj.cust_cnt_cd.value = custCntCdStr;
			     			formObj.cust_seq.value = custSeqStr;
			     			
		     				ComEnableObject(formObj.cust_cnt_cd,false);
		     				ComEnableObject(formObj.cust_seq,false);
		     				formObj.cust_cnt_cd.className = "input2";
		     				formObj.cust_cnt_cd.tabIndex = "-1";
		     				formObj.cust_seq.className = "input2";
		     				formObj.cust_seq.tabIndex = "-1";
		     				
		     				formObj.ar_ofc_cd.Enable = false;
	
		     				ComBtnEnable("btn_Save");
	    		    	}
	    		    }
				}
			break;
			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ofc_cd.value = arrStr2[1];
				
				formObj.f_cmd.value = SEARCH03;
				
				var actCustCntCd = formObj.cust_cnt_cd.value;
				var actCustSeq = ComReplaceStr(formObj.cust_seq.value,",","");
				
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
	
				if(CoInvShowXmlMessage(sXml) != "") {
					formObj.cust_seq.value = "";
					formObj.cust_nm.value = "";
					
					ComAlertFocus(formObj.cust_cnt_cd, CoInvShowXmlMessage(sXml));
				} else {
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
					var delt_flg = ComGetEtcData(sXml,"delt_flg");
					
					if (cust_nm != undefined && delt_flg != undefined) {
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.seq_cust_seq.value = "";
						formObj.cust_nm.value = "";
					}
				}
			break;
			
			case IBSAVE:      // 입력
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
					
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.ofc_cd.value = arrStr2[1];
	     			
	 				var SaveXml = sheetObj.GetSaveXml("FNS_INV_0097GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSaveXml(SaveXml);
	 				ComBtnEnable("btn_Save");
	     			ComBtnEnable("btn_Delete");
	     			ComBtnEnable("btn_Print");
				}
			break;
			
			case REMOVE:      // 삭제
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = REMOVE;
					
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.ofc_cd.value = arrStr2[1];
	     			
	     			//alert(FormQueryString(formObj));
	     			
	 				var SaveXml = sheetObj.GetSaveXml("FNS_INV_0097GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSaveXml(SaveXml);
	 				
	 				removeAll(formObj);
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
		}
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
	 * @version 2009.07.03
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			initSheet(sheetObjects[i],i+1);
		}
     
		//RD
		initRdConfig(rdObjects[0]);
		 
		var formObj = document.form;
		 
		initControl();
		 
		removeAll(formObj);
				
		formObj.vvd.focus();
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
	 * @version 2009.07.03
	 */
    function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
		case IBSEARCH:      //조회
			with(formObj){
				if(ar_ofc_cd.text == "") {
					ComShowCodeMessage("INV00004");
					ar_ofc_cd.focus();
					return false;
				}
				
				// By VVD 선택시
				if (search_option[0].checked) {
					if(vvd.value == "") {
						ComShowCodeMessage("INV00004");
						vvd.focus();
						return false;
					}
					if(port_cd.value == "") {
						ComShowCodeMessage("INV00004");
						port_cd.focus();
						return false;
					}
				}
				else {
					if(cust_cnt_cd.value == "") {
						ComShowCodeMessage("INV00004");
						cust_cnt_cd.focus();
						return false;
					}
					if(cust_seq.value == "") {
						ComShowCodeMessage("INV00004");
						cust_seq.focus();
						return false;
					}
				}
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
	 * @version 2009.07.03
	 */
	function removeAll(formObj) {
		formObj.reset();
	 	
		sheetObjects[0].RemoveAll();
		
		formObj.vvd.value = "";
		formObj.port_cd.value = "";
		formObj.cust_cnt_cd.value = "";
		formObj.cust_seq.value = "";
		formObj.cust_nm.value = "";
		formObj.subject.value = "";
		formObj.text1.value = "";
		formObj.high_light1.checked = false;
		formObj.text2.value = "";
		formObj.high_light2.checked = false;
		formObj.text3.value = "";
		formObj.high_light3.checked = false;
		formObj.text4.value = "";
		formObj.high_light4.checked = false;
		
		ComEnableObject(formObj.vvd,true);
		ComEnableObject(formObj.port_cd,true);

		formObj.vvd.className = "input1";
		formObj.vvd.tabIndex = "";
		formObj.port_cd.className = "input1";
		formObj.port_cd.tabIndex = "";

		ComEnableObject(formObj.cust_cnt_cd,false);
		ComEnableObject(formObj.cust_seq,false);

		formObj.cust_cnt_cd.className = "input2";
		formObj.cust_cnt_cd.tabIndex = "-1";
		formObj.cust_seq.className = "input2";
		formObj.cust_seq.tabIndex = "-1";
		
		formObj.ar_ofc_cd.Enable = true;
		
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_Print");
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
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
	 * @version 2009.07.03
	 */
	function MakeComboObject(cmbObj, arrStr) {
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.BackColor = "#CCFFFD";
	}
	
	/** 
	 * 조회조건에 따른 입력항목 활성상태 세팅<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 입력[E]시와 조회[I]시에 따라 각 입력항목의 활성화 상태와 버튼의 표시여부를 세팅한다.
	 * </pre>
	 * @param  {object} formObj    
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.03
	 */
	function formSettingVal(formObj,sXml){
		if (formObj.search_option[0].checked) {
		 	formObj.vvd.value 		= ComGetEtcData(sXml,"vvd");
		 	formObj.port_cd.value 	= ComGetEtcData(sXml,"port_cd");
		}
		else {
		 	formObj.cust_cnt_cd.value = ComGetEtcData(sXml,"cust_cnt_cd");
		 	formObj.cust_seq.value 	  = ComGetEtcData(sXml,"cust_seq");
		}

	 	formObj.subject.value 	= ComGetEtcData(sXml,"subject");
	 	
	 	formObj.text1.value 	= ComGetEtcData(sXml,"text1"); 
	 	formObj.text2.value 	= ComGetEtcData(sXml,"text2"); 
	 	formObj.text3.value 	= ComGetEtcData(sXml,"text3"); 
	 	formObj.text4.value 	= ComGetEtcData(sXml,"text4"); 
	 	
	 	if (ComGetEtcData(sXml,"high_light1")=='Y') {
	 		formObj.high_light1.checked = true;
	 	} 
	 	else {
	 		formObj.high_light1.checked = false;
	 	}
	 	if (ComGetEtcData(sXml,"high_light2")=='Y') {
	 		formObj.high_light2.checked = true;
	 	} 
	 	else {
	 		formObj.high_light2.checked = false;
	 	}
	 	if (ComGetEtcData(sXml,"high_light3")=='Y') {
	 		formObj.high_light3.checked = true;
	 	} 
	 	else {
	 		formObj.high_light3.checked = false;
	 	}
	 	if (ComGetEtcData(sXml,"high_light4")=='Y') {
	 		formObj.high_light4.checked = true;
	 	} 
	 	else {
	 		formObj.high_light4.checked = false;
	 	}
	}
	
	function initFormSettingVal(formObj,sXml){
	 	formObj.subject.value 	= "";
	 	formObj.text1.value 	= ""; 
	 	formObj.text2.value 	= ""; 
	 	formObj.text3.value 	= ""; 
	 	formObj.text4.value 	= ""; 
	 	formObj.high_light1.checked = false;
	 	formObj.high_light2.checked = false;
	 	formObj.high_light3.checked = false;
	 	formObj.high_light4.checked = false;
	 	
	 	//ComBtnDisable("btn_Print");
	}
	
	/** 
	 * 팝업창(COM_ENS_051_1)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.03
	 */
	function getCOM_ENS_051_1(rowArray) {
		var colArray = rowArray[0];
		
		document.all.port_cd.value = colArray[3];
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
	 * @version 2009.04.27
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObj = document.form;
		
		formObj.cust_cnt_cd.value = colArray[8];
		formObj.cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObj.cust_nm.value = colArray[4];
	}
	 
	/** 
	 * Rd 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {RdObject} rdObject
	 * @param  {object} formObj    
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.07.03
	 */
	function rdOpen(rdObject, formObj){
		var Rdviewer = rdObject ;
		
		if(formObj.search_option[0].checked == true){
			var vslCd = formObj.vvd.value.substring(0,4);
			var skdVoyNo = formObj.vvd.value.substring(4,8);
			var skdDirCd = formObj.vvd.value.substring(8,9);
			var rdParam = "/rv "+"frm1_ar_ofc_cd["+formObj.ar_ofc_cd.text+"] frm1_vsl_cd["+vslCd+"] frm1_skd_voy_no["+skdVoyNo+"] frm1_skd_dir_cd["+skdDirCd+"] frm1_port_cd ["+formObj.port_cd.value+"]";		
			var rdFile = "FNS_INV_0524_vvd.mrd";
		}else{
			var rdParam = "/rv "+"frm1_ar_ofc_cd["+formObj.ar_ofc_cd.text+"]  frm1_cust_cnt_cd["+formObj.cust_cnt_cd.value+"] frm1_cust_seq["+formObj.cust_seq.value+"]";		
			var rdFile = "FNS_INV_0524_cust.mrd";
		}
		
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";
		
		Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam+ "/rpagenuminit [1] /riprnmargin /rwait");
		Rdviewer.CMPrint();
	}
	/* 개발자 작업  끝 */