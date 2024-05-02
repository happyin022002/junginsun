/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0053.js
*@FileTitle : Invoice Issue Inquiry by Invoice No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.27 박정진
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
	 * @class fns_inv_0053 : fns_inv_0053 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function fns_inv_0053() {
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
	
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;

	/**
	 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
	 **/
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
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		//var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;

				case "btn_new":
					// INV split_chk 버튼을 활성화한다.
					ComBtnDisable("btn_split_chk");
					removeAll(formObject);
				break;
				
				case "btn_split_chk":
					
					var bl_no = sheetObjects[0].CellValue(1, "bl_src_no")
					var ofcCd = formObject.ar_ofc_cd.text;
					
					var param = "?ofc="+ofcCd+"&bl_no="+bl_no+"&classId=FNS_INV_0131";
					ComOpenPopup('/hanjin/FNS_INV_0131.do' + param, 920, 520, '', '1,0,1,1,1', false);
					break;
				
				case "btns_cust": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
					var v_act_cust_seq = formObject.act_cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenPopup('/hanjin/FNS_INV_0013.do' + param, 920, 650, 'getFNS_INV_0013', '1,0,1,1,1', false);
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
	 * @version 2009.10.19
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
	 * @version 2009.10.19
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
	 * @version 2009.10.19
	 */
	function loadPage() {
		
		// INV split_chk 버튼을 숨긴다.
		document.getElementById('tbl_split_check').style.display = 'none';
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
		
		// INV split_chk 버튼을 비활성 화 한다
		ComBtnDisable("btn_split_chk");
		
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
	 * @version 2009.10.19
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObject = document.form;
		
		var cnt = 0;
		
		var dpPrcsKntLocal = formObject.dp_prcs_knt_local.value;
		var dpPrcsKnt = formObject.dp_prcs_knt.value;
		
		var setDpPrcsKnt = "";
		if (Number(dpPrcsKntLocal) > Number(dpPrcsKnt)) {
			setDpPrcsKnt = dpPrcsKntLocal;
		}
		else {
			setDpPrcsKnt = dpPrcsKnt;
		}
		
		switch(sheetNo) {
			case 1:      //sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = 322;
					//전체 너비 설정
					SheetWidth = mainTable1.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
	
					if(formObject.ar_ofc_cd.text == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
						var HeadTitle = "|B/L No.|POL|POD|CHG|Rated As|Rate|Per|Curr|Amount|Ex. Rate|Local Total|Grid Total|CGST|SGST|UGST|IGST";
					} else {
						var HeadTitle = "|B/L No.|POL|POD|CHG|Rated As|Rate|Per|Curr|Amount|Ex. Rate|Local Total|Grid Total";
					}
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 5, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, false);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,     daCenter,  false,   "ibflag");
					InitDataProperty(0, cnt++ , dtData,    		180,   	daCenter,  true,   "bl_src_no",		false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		55,    	daCenter,  false,   "pol_cd",			false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		55,    	daCenter,  false,   "pod_cd",			false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		55,    	daCenter,  false,   "chg_cd",			false,    "",    dfNone, 		0,     true,       true);

					InitDataProperty(0, cnt++ , dtData,    		80,     daRight,   false,   "rat_as_cntr_qty",	false,    "",    dfNullFloat, 	3);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtData,    	110,    daRight,   false,   "trf_rt_amt",   	false,    "",    dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtData,    	110,    daRight,   false,   "trf_rt_amt",   	false,    "",    dfInteger);
					}
					InitDataProperty(0, cnt++ , dtData,    		55,     daCenter,  false,   "per_tp_cd",	  	false,    "",    dfNone, 		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,    		60,     daCenter,  false,   "curr_cd",   		false,    "",    dfNone, 		0,     true,       true);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtData,    	110,    daRight,   false,   "chg_amt",	  		false,    "",    dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtData,    	110,    daRight,   false,   "chg_amt",	  		false,    "",    dfInteger);
					}
					
					InitDataProperty(0, cnt++ , dtData,    		80,     daRight,   false,   "inv_xch_rt",		false,    "",    dfNullFloat, 	6);
					if (setDpPrcsKnt > 0) {
						InitDataProperty(0, cnt++ , dtAutoSum, 	110,    daRight,   false,   "local_total",	  	false,    "",    dfNullFloat, 	setDpPrcsKnt);
						InitDataProperty(0, cnt++ , dtHidden, 	110,    daRight,   false,   "grid_total",	  	false,    "",    dfNullFloat, 	setDpPrcsKnt);
					}
					else {
						InitDataProperty(0, cnt++ , dtAutoSum, 	110,    daRight,   false,   "local_total",	  	false,    "",    dfInteger);
						InitDataProperty(0, cnt++ , dtHidden, 	110,    daRight,   false,   "grid_total",	  	false,    "",    dfInteger);
					}
					
					if(formObject.ar_ofc_cd.text == "BOMSC"){		//2017.08.01 인도 GST 세법 변경 관련 보완
						InitDataProperty(0, cnt++ , dtData,    	80,    daRight,   false,   "ida_cgst_amt",	  		false,    "",    dfNullFloat, 	2);
						InitDataProperty(0, cnt++ , dtData,    	80,    daRight,   false,   "ida_sgst_amt",	  		false,    "",    dfNullFloat, 	2);
						InitDataProperty(0, cnt++ , dtData,    	80,    daRight,   false,   "ida_ugst_amt",	  		false,    "",    dfNullFloat, 	2);
						InitDataProperty(0, cnt++ , dtData,    	80,    daRight,   false,   "ida_igst_amt",	  		false,    "",    dfNullFloat, 	2);
					}
					
					WaitImageVisible=false;
				}
			break;
		}
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
	                //SetTitle("Office Code");
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
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', form);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
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
	 * @version 2009.10.19
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
					case "inv_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "ar_ofc_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "bl_src_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "bl_src_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "bkg_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
					break;
					case "act_cust_cnt_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "inv_cust_cnt_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "cr_curr_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "cr_clt_ofc_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper'); 
					break;
					case "vvd":
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
	 * @version 2009.10.19
	 */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
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
	 * @version 2009.10.19
	 */
	function obj_deactivate(){
		switch(event.srcElement.name){
			case "date_value":
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
			case "port":
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
        }
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
	 * @version 2009.10.19
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					
					ComBtnDisable("btn_split_chk");
					
					formObj.f_cmd.value = SEARCH;

					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
	     			formObj.ofc.value = arrStr2[1];
	     			
                    sheetObjects[0].Reset();
                    
                    ComOpenWait(true);
				
	     			var sXml = sheetObj.GetSearchXml("FNS_INV_0053GS.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					
	     			if(CoInvShowXmlMessage(arrXml[0]) != "") {
	     				var invNo = formObj.inv_no.value;
	     				var arOfcCd = formObj.ar_ofc_cd.text;
	     				
	     				removeAll(formObj);
	     				
	     				formObj.inv_no.value = invNo;
	     				formObj.ar_ofc_cd.text = arOfcCd; 
	     				
	     				ComAlertFocus(formObj.inv_no, CoInvShowXmlMessage(arrXml[0]));
					} else {
						formObj.reset();
						
	     				// 소수점 자리수 설정
			 			formObj.dp_prcs_knt_local.value = ComGetEtcData(arrXml[0],"dp_prcs_knt_local");
			 			formObj.dp_prcs_knt.value = ComGetEtcData(arrXml[0],"dp_prcs_knt");
			 			
						if (arrXml.length > 0) {
							var list = ComXml2ListMap(arrXml[0]);
	
							if (list.length > 0) {
								var expensInfo  = list[0];
								ComMapToForm(formObj,expensInfo);
								
								var inv_tp_cd = formObj.inv_tp_cd.value;
			     				if (inv_tp_cd == "S") {
			    					// INV split_chk 버튼을 활성화한다.
			     					ComBtnEnable("btn_split_chk");
			     				} else {
			    					// INV split_chk 버튼을 비활성화한다.
			    					ComBtnDisable("btn_split_chk");
			     				}
								
							}
							else {
								var inv_no = formObj.inv_no.value;
								var ar_ofc_cd = formObj.ar_ofc_cd.text;
								
								ComShowCodeMessage("INV00095");
								
								ComResetAll();
								
								formObj.inv_no.value = inv_no;
								formObj.ar_ofc_cd.text = ar_ofc_cd;
							}
						}
						
			 			initSheet(sheetObjects[0],1);
						
						if (arrXml.length > 1) {
							sheetObjects[0].LoadSearchXml(arrXml[1]);
						}
					}
	     			
	     			ComOpenWait(false);
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
				
				// OFC_CD 가 BOMSC//SAOSC 이면 버튼을 보이게한다.
				if (formObj.ar_ofc_cd.text == "BOMSC" || formObj.ar_ofc_cd.text == "SAOSC") {
					document.getElementById('tbl_split_check').style.display = 'inline';
				} else {
					document.getElementById('tbl_split_check').style.display = 'none';
				}
				
			break;
         }
     }
	
	function ar_ofc_cd_OnChange(comboObj,value,text){ 
		
		// OFC_CD 가 BOMSC//SAOSC 이면 버튼을 보이게한다.
		if (text == "BOMSC" || text == "SAOSC") {
			document.getElementById('tbl_split_check').style.display = 'inline';
		} else {
			document.getElementById('tbl_split_check').style.display = 'none';			
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
	 * @version 2009.10.19
	 */
     function validateForm(sheetObj,formObj,sAction){
		 with(formObj){
			 if(inv_no.value == "") {          		 
				 ComShowCodeMessage("COM12114", "Invoice No");
				 inv_no.focus();
				 return false;
			 }
			 if(ar_ofc_cd.value == "") {
				 ComShowCodeMessage("COM12114", "Office");
				 ar_ofc_cd.focus();
				 return false;
			 }
		 }
		 return true;
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
 	 * @version 2009.10.19
 	 */
 	function sheet1_OnLoadFinish(sheetObj){
 		var formObj = document.form;
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		initControl();
		
		formObj.inv_no.focus();
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
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.BackColor = "#CCFFFD";
	}

	/** 
	 * 팝업창(COM_ENS_051)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function getCOM_ENS_051_1(rowArray) {
		var colArray = rowArray[0];
		
		document.all.port.value = colArray[3];
	}

	/** 
	 * VoList를 array[array[name]]형태로 변환<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {xml} xmlStr 조회 결과 setRsVoList , setRsVo
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function ComXml2ListMap(xmlStr) {
		
		var rtnArr = new Array();

		if (xmlStr == null || xmlStr == "") {
			return rtnArr;
		}

		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);

			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return rtnArr;
			}

			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return rtnArr;
			}

			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");

			var dataChileNodes = dataNode.childNodes;
			if (dataChileNodes == null) {
				return rtnArr;
			}

			for ( var i = 0; i < dataChileNodes.length; i++) {
				if (dataChileNodes[i].nodeType != 1) {
					continue;
				}
				
				var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

				var subDataArr = new Array();
				
				for ( var j = 0; j < arrData.length; j++) {
					subDataArr[colArr[j]] = arrData[j];
				}
				
				rtnArr[i] = (subDataArr);
			}

		} catch (err) {
			ComFuncErrMsg(err.message);
		}

		return rtnArr;
	}

	/** 
	 * Array의 name 과 HTML form의 이름이 동일할경우 form의 객체에 Value설정<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {form} form html 폼 
	 * @param {map} Array[name] 의 값 
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function ComMapToForm(form, map) {		
			//사용가능한 컨트롤을 배열로 생성한다.
			var len = form.elements.length;
			for (var i = 0; i < len; i++) {
				if (form.elements[i].classid == undefined) {
					var xvalue = map[form.elements[i].name];
					if (xvalue == undefined)
						continue;
					switch (form.elements[i].type) {
					case "button":
					case "reset":
					case "submit":
						break;
					case "radio":
						var eRadio = document.all[form.elements[i].name];
						var idx = 0;
						for ( var k = 0; k < eRadio.length; k++) {
							if (eRadio[k].value == xvalue) {
								idx = k;
								break;
							}
						}
						eRadio[idx].checked = true;
						break;
					case "checkbox":
						form.elements[i].checked = xvalue;
						break;
					case "select-one":
						var eOpt = form.elements[i].options;
						var idx = 0;
						if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
							var opt_len = eOpt.length;
							for ( var k = 0; k < opt_len; k++) {
								if (eOpt[k].value == xvalue) {
									idx = k;
									break;
								}
							}
						}
						form.elements[i].selectedIndex = idx;
						break;
					case "select-multiple": //선택될 값이 '|' 를 구분자로 입력되어있다고 가정한다.
						var eOpt = form.elements[i].options;
						var idx = 0;
						if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
							var opt_len = eOpt.length;
							var tvalue = xvalue.split("|");
							var tval_len = tvalue.length;
							for ( var k = 0; k < opt_len; k++) {
								for ( var m = 0; m < tval_len; m++) {
									if (eOpt[k].value == tvalue[m])
										eOpt[k].selected = true;
								}
							}
						}
						break;
					default:
						switch (form.elements[i].name) {
							case "cr_amt":
								form.elements[i].value = ComAddCommaRun(xvalue);
							break;
							case "cust_rgst_no":
								form.elements[i].value = ComGetMaskedValue(xvalue, "saupja");
							break;
							case "iss_dt":
								form.elements[i].value = ComGetMaskedValue(xvalue, "ymd");
							break;
							case "sail_arr_dt":
								form.elements[i].value = ComGetMaskedValue(xvalue, "ymd");
							break;
							case "due_dt":
								form.elements[i].value = ComGetMaskedValue(xvalue, "ymd");
							break;
							default:
								form.elements[i].value = xvalue;
							break;
						}
						
					}
				}
			}      	

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
	 * @version 2009.10.19
	 */
	function removeAll(formObj) {
		formObj.reset();
		
		sheetObjects[0].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		formObj.inv_no.focus();
	}

	/** 
	 * 팝업창(FNS_INV_0013)에서 선택 이벤트 처리시 부모창으로 call하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {array} rowArray : 팝업창에서 부모창으로 보내는 값  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function getFNS_INV_0013() {
		var colArray = rowArray[0];
		
		var formObject = document.form;
	}

	/** 
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * - curr_cd별 amount 합계를 계산하기 위한 함수
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.05.04
	 */ 	  	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObject = document.form;

		var curs = "";
		var sums = 0;
	
		if(sheetObj.RowCount > 0) {
			for(i = 1 ; i < sheetObj.Rows; i++){
				if (curs.indexOf(sheetObj.CellValue(i, "curr_cd")) == -1) {
					curs = curs + sheetObj.CellValue(i, "curr_cd") +"|";
					sums = Number(sums) + Number(sheetObj.CellValue(i, "grid_total"));
				}
			}
		}
		
		sheetObj.SumValue(0,"local_total") = sums;
	} 
	/* 개발자 작업  끝 */