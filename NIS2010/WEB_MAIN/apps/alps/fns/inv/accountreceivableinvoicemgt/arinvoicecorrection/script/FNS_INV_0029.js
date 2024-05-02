/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0029.js
*@FileTitle : Manual System Clear
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.04 박정진
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
     * @class fns_inv_0029 : fns_inv_0029 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function fns_inv_0029() {
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
	//공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	//IBMultiCombo
	var comboObjects = new Array();
	var comboCnt = 0;

	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
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
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_execute":
					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
				break;
				
				case "btn_new":
					formObject.ar_ofc_cd.RemoveAll();
					removeAll(document.form);					
				break;
					
				case "btns_cust1": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.cust_cnt_cd.value;
					var v_act_cust_seq = formObject.cust_seq.value;
					var classId = "FNS_INV_0013";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
			
					ComOpenWindow('/hanjin/FNS_INV_0013.do' + param, 'getFNS_INV_0013', 'width=900,height=650');
				break;
				
				case "btns_cust2": //CUST 조회버튼
					var v_act_cust_cnt_cd = formObject.cust_cnt_cd.value;
					var v_cust_nm = sheetObject1.UrlEncoding(formObject.cust_nm.value);
					
					var classId = "FNS_INV_0086";
					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_lgl_eng_nm='+v_cust_nm+'&pop_yn=Y&classId='+classId;
			
					ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086', '1,0,1,1,1', false, false);
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
		var formObj = document.form;
		
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
		
		initControl();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
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
	 * @version 2009.10.19
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
					//높이 설정
					style.height = 320;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					var HeadTitle = " |OFC|VVD|S/A Date|SAILING DATE|B/L No|I/F No|C/A NO|BKG NO|CUSTOMER|REV TYPE|REV SRC|BND|POL|POD|Ex. Rate|USD CHG TOT|LCL CHG TOT|LCL_TOT_AMT|I/F DT|";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					var prefix="sheet1_";

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		false,		prefix + "ibflag");
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "ar_ofc_cd",		false,		"",		dfNone,			0,		false,		false,		10);
					InitDataProperty(0, cnt++ , dtData,    	 	130,	daCenter,		false,		prefix + "vvd",				false,		"",		dfNone,			0,		false,		false,		11);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "sail_arr_dt",		false,		"",		dfDateYmd,		0,		false,		false,		12);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "sail_dt",			false,		"",		dfDateYmd,		0,		false,		false,		3);

					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bl_src_no",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "ar_if_no",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bkg_corr_no",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	120,	daCenter,		false,		prefix + "bkg_no",			false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "customer",		false,		"",		dfNone,			0,		false,		false,		11);
					
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "rev_tp_cd",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,  	   	80,		daCenter,		false,		prefix + "rev_src_cd",		false,		"",		dfDateYmd,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "io_bnd_cd",		false,		"",		dfNone,			0,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "pol_cd",			false,		"",		dfNone,			0,		false,		false,		20);
					InitDataProperty(0, cnt++ , dtData,    	 	80,		daCenter,		false,		prefix + "pod_cd",			false,		"",		dfNone,			0,		false,		false,		3);

					InitDataProperty(0, cnt++ , dtData,    	 	100,	daRight,		false,		prefix + "inv_xch_rt",		false,		"",		dfNullFloat,	6,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	130,	daRight,		false,		prefix + "usd_chg_tot",		false,		"",		dfNullFloat,	2,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,    	 	130,	daRight,		false,		prefix + "lcl_chg_tot",		false,		"",		dfNullFloat,	2,		false,		false,		3);
					InitDataProperty(0, cnt++ , dtData,  	   	130,	daCenter,		false,		prefix + "inv_ttl_locl_amt",false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,    	 	100,	daCenter,		false,		prefix + "bl_inv_if_dt",	false,		"",		dfDateYmd,		0,		false,		false);

					InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,		false,		prefix + "dp_prcs_knt",		false,		"",		dfNone,			0,		false,		false);

					CountPosition = 0;
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
		var formObj = document.form;
		
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerForm ('focus', 'obj_activate', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
		axon_event.addListenerForm ('blur', 'obj_deactivate', formObj);
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
		var formObj = document.form;
		
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
					case "bl_src_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
						break;
					
					case "ar_if_no":	
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum'); 
						break;

					case "cust_cnt_cd":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
						break;

					case "port":	
						//영문대문자만입력하기		    	        
						ComKeyOnlyAlphabet('upper'); 
						break;
				}
			break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
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
		var formObj = document.form;
		
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
	 * @version 2009.10.19
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
		var sheetObject = sheetObjects[0];
		var formObj = document.form;
		
		switch(event.srcElement.name){
			case "cust_seq":
				if (formObj.cust_cnt_cd.value != '' && formObj.cust_seq.value != '') {
					var valueCustSeq = formObj.cust_seq.value;
					formObj.cust_seq.value = ComLpad(valueCustSeq,6,"0");
					
					doActionIBSheet(sheetObject,formObj,IBSEARCH_ASYNC20);
					
					for(i=sheetObject.rowCount; i>0; i--){
						if (formObj.cust_nm.value != '') {
							sheetObject.CellValue2(i, "cust_code") = formObj.cust_cnt_cd.value+ComLpad(valueCustSeq,6,"0");
						}
					}
				}
				else {
					formObj.cust_cnt_cd.value = '';
					formObj.cust_seq.value = '';
					formObj.cust_nm.value = '';
					
					for(i=sheetObject.rowCount; i>0; i--){
						sheetObject.CellValue2(i, "cust_code") = "";
					}
				}
				break;
			default:
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
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
					formObj.ofc_cd.value = arrStr2[1];
					formObj.ots_smry_cd.value = arrStr2[13];
					
					formObj.f_cmd.value = MULTI;
					
					var sParam = FormQueryString(formObj);
					sParam = sParam + "&cust_cd="+ formObj.cust_cnt_cd.value + formObj.cust_seq.value; 
					
					ComOpenWait(true);  //대기이미지 표시
					
					var sXml = sheetObj.GetSaveXml("FNS_INV_0029GS.do", sParam );
					if (sXml.indexOf("ERROR") < 1){
						var resultCnt = ComGetEtcData(sXml,"result_cnt");
						
						sheetObj.LoadSaveXml(sXml);
						
						ComOpenWait(false); //대기이미지 숨김
						
						if (resultCnt != undefined) {
							if (resultCnt > 0) {
								formObj.total_count.value = resultCnt;
								ComShowCodeMessage("INV00093");
							}
							else {
								formObj.total_count.value = "0";
								ComShowCodeMessage("INV00092");
							}
						} else {
							formObj.total_count.value = "";
							ComShowCodeMessage("INV00053");
						}
					}
					else {
						ComOpenWait(false); //대기이미지 숨김	
						
						ComShowCodeMessage("INV00053");
					}
				}
			break;
			
			case IBSEARCH_ASYNC01:        //저장
			
			if(validateForm(sheetObj,formObj,sAction)) {
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ofc_cd.value = arrStr2[1];
				formObj.ots_smry_cd.value = arrStr2[13];
				
				formObj.f_cmd.value = MULTI01;
				
				var sParam = FormQueryString(formObj);
				
				ComOpenWait(true);  //대기이미지 표시
				
				var sXml = sheetObj.GetSaveXml("FNS_INV_0029GS.do", sParam );
				if (sXml.indexOf("ERROR") < 1){
					var resultCnt = ComGetEtcData(sXml,"result_cnt");
					
					sheetObj.LoadSaveXml(sXml);
					
					ComOpenWait(false); //대기이미지 숨김
					
					if (resultCnt != undefined) {
						if (resultCnt > 0) {
							formObj.total_count.value = resultCnt;
							ComShowCodeMessage("INV00093");
						}
						else {
							formObj.total_count.value = "0";
							ComShowCodeMessage("INV00092");
						}
					} else {
						formObj.total_count.value = "";
						ComShowCodeMessage("INV00053");
					}
				}
				else {
					ComOpenWait(false); //대기이미지 숨김	
					
					ComShowCodeMessage("INV00053");
				}
			}
			
			break;

			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
	 			formObj.f_cmd.value = SEARCH02;
	 			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			
	 			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
	 			var arrStr = sStr.split("|");
	 			//office
	 			MakeComboObject(formObj.ar_ofc_cd, arrStr);
	 			
	 			var arrStr2 = arrStr[1].split("^");
	 			var ar_ofc_cd = arrStr2[3];

	 			// 로그인한 사용자의  office 정보를 가져온다.
	 			var ofcStr;
	 			var ofcStr2;
	 			
	 			for (var i=0; i < arrStr.length; i++) {
	 				var sStr9 = arrStr[i].split("^");
	 				if (sStr9[1] == ar_ofc_cd) {
	 					ofcStr = arrStr[i]
	 				}
	 			}
	 			var ofcStr2 = ofcStr.split("^");
	 			
	 			formObj.ar_ofc_cd.text = ofcStr2[3];
			break;
			
			case IBSEARCH_ASYNC20: // customer name 조회
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ofc_cd.value = arrStr2[1];
				
				formObj.f_cmd.value = SEARCH03;
				
				var actCustCntCd = formObj.cust_cnt_cd.value;
				var actCustSeq = formObj.cust_seq.value;
				
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
	
				var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
				var delt_flg = ComGetEtcData(sXml,"delt_flg");
				
				if (cust_nm != undefined && delt_flg != undefined) {
					if (delt_flg == 'Y') {
						ComShowCodeMessage("INV00060");
						formObj.cust_cnt_cd.value = "";
						formObj.cust_seq.value = "";
						formObj.cust_nm.value = "";
						formObj.cust_cnt_cd.focus();
						return;
					}
					formObj.cust_nm.value = cust_nm;
				} else {
					formObj.cust_cnt_cd.value = "";
					formObj.cust_seq.value = "";
					formObj.cust_nm.value = "";
				}
			break;

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
    	switch(sAction) {
		case IBSAVE:      //Retrieve
			with(formObj){
				if(ar_ofc_cd.text == "") {
					ComShowCodeMessage("INV00004");
					ar_ofc_cd.focus();
					return false;
				}
				if(bl_src_no.value == "" && vvd_cd.value == "" && (cust_cnt_cd.value == "" && cust_seq.value == "") ) {
					ComShowCodeMessage("INV00004");
					bl_src_no.focus();
					return false;
				}
				
			}
		break;
		
		case IBSEARCH_ASYNC01: 
			with(formObj){
				if(if_no1.value == "" || if_no2.value == "") {
					ComShowCodeMessage("INV00004");
					if_no1.focus();
					return false;
				}				
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
		var idx = 0;
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			var ots_smry_cd = arrStr2[13];
			
			// ar_ofc_cd의 ots_smry_cd 가 'INV','CLR' 인 경우에만 콤보에 표시한다.
			if (ots_smry_cd == 'INV' || ots_smry_cd == 'CLR') {
				cmbObj.InsertItem(idx, ar_ofc_cd, arrStr[i]);
				idx++;
			}
		}
		cmbObj.BackColor = "#CCFFFD";
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
		
		formObj.bl_src_no.focus();
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
		var formObject = document.form;
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
	 * @version 2009.10.19
	 */
	function getFNS_INV_0086(rowArray) {
		var colArray = rowArray[0];
		
		var formObject = document.form;
		
		formObject.cust_cnt_cd.value = colArray[8];
		formObject.cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	}

	/* 개발자 작업  끝 */