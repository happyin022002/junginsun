/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0028.js
*@FileTitle : Invoice Data Manual Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.20 최도순
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
	 * @class FNS_INV_0028 : FNS_INV_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0028() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
		this.getBackEndJobStatus	= getBackEndJobStatus;
		this.getBackEndJobLoadFile	= getBackEndJobLoadFile;
	}
	
	/* 개발자 작업	*/	
	
	//공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
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
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	
			switch(srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
	
			case "btn_execute":
				formObject.man_div_ind.value = "I";
				if(sheetObject1.RowCount<1||sheetObject1.CheckedRows('chk')<1 ){
					ComShowCodeMessage("COM12189");
					return;
				}
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
	
			case "btn_ifbkg":
				
				if(sheetObject1.RowCount>0&&sheetObject1.CheckedRows('chk')>0 ){
					formObject.man_div_ind.value = "I";
					formObject.bkg_no.value = "";
					formObject.vvd.value = "";
					formObject.pol.value = "";
					formObject.pod.value = "";
				} else {
					formObject.man_div_ind.value = "M";
					if(formObject.bkg_no.value==""&&formObject.vvd.value==""){
						ComShowCodeMessage("INV00004");
						formObject.bkg_no.focus();
						return;
					}
					if(formObject.vvd.value!=""&&formObject.vvd.value.length!=9){
						ComShowCodeMessage("INV00004");
						formObject.vvd.focus();
						return;
					}
					if(formObject.vvd.value!=""){
						if(formObject.pol.value==""){
							ComShowCodeMessage("INV00004");
							formObject.pol.focus();
							return;
						}
						if(formObject.pod.value==""){
							ComShowCodeMessage("INV00004");
							formObject.pod.focus();
							return;
						}
					}
				}
				doActionIBSheet(sheetObject1,formObject,COMMAND01);
				break;
				
			case "btn_erp":
				formObject.man_div_ind.value = "T";
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
			case "btn_erpU":
				formObject.man_div_ind.value = "U";
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;  
			case "btn_cancel":
				formObject.man_div_ind.value = "C";
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
			case "btn_otherif":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC10);
			break;
				
			case "btn_new":
				formObject.fm_if_dt.value = "";
				formObject.to_if_dt.value = "";
				formObject.trnk_vvd.value = "";
				formObject.bl_src_no.value = "";
				formObject.pol_cd.value = "";
				formObject.pod_cd.value = "";
				formObject.bkg_no.value = "";
				formObject.vvd.value = "";
	
				if ( formObject.inv_adm.value =="INVADM" ){
					   formObject.no_text.value = "";
					   formObject.ar_if_no.value = "";
					   formObject.no_text2.value = "";
				}
			 
				sheetObjects[0].RemoveAll();
	
				formObject.fm_if_dt.focus();
				break;	
	
			case "btns_calendar1": //달력버튼
			var cal = new ComCalendar();
			cal.select(formObject.fm_if_dt, 'yyyy-MM-dd');
			break;
	
			case "btns_calendar2": //달력버튼
			var cal = new ComCalendar();
			cal.select(formObject.to_if_dt, 'yyyy-MM-dd');
			break;
			
			case "btn_multibkg":
				
				formObject.man_div_ind.value = "M";
					if(formObject.no_text2.value==""){
						ComShowCodeMessage("INV00004");
						formObject.no_text2.focus();
						return;
					}

				doActionIBSheet(sheetObject1,formObject,COMMAND02);
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
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	
	
	/** 
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
	
		for(i=0;i<sheetObjects.length;i++){
	
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}	
	
		initControl();
	
		document.form.fm_if_dt.focus();
	
	}
	
	/** 
	 * Sheet 기본 설정 및 초기화 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBSheet} sheetObj : 시트오브젝트
	 * @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 385;
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
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(13, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle = "|Sel.|PPD Office|CCT Office|Trunk VVD|B/L No|BKG No|I/F Date|POL|POD|Status|Err Rsn|bkg_no|bkg_seq";
	
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,		50,		daCenter,	true,	 "chk",			false,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,	     		 80,    daCenter,  true,    "ppd_ofc",		false,    "",      dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,	     		 80,    daCenter,  true,    "cct_ofc",		false,    "",      dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 80,    daCenter,  true,    "trnk_vvd",    false,    "",      dfNone,		0,	false,		false, 9,false);
				InitDataProperty(0, cnt++ , dtData,	     		 100,    daCenter,  true,    "bl_src_no",  	false, 	  "", 	   dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,	     		 100,    daCenter,  true,    "bkg_no",  	false, 	  "", 	   dfNone,		0,	false,		false, 0,false);
				InitDataProperty(0, cnt++ , dtData,     		 80,    daCenter,  true,    "src_if_dt",   false,    "",      dfDateYmd,		0,	false,		false, 9,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "pol_cd",      false,    "",      dfNone,		0,	false,		false, 9,false);
				InitDataProperty(0, cnt++ , dtData,     		 70,    daCenter,  true,    "pod_cd",      false,    "",      dfNone,		0,	false,		false, 9,false);
				InitDataProperty(0, cnt++ , dtData,     		 50,    daCenter,  true,    "inv_ar_if_cd",      false,    "",      dfNone,		0,	false,		false, 9,false);
				InitDataProperty(0, cnt++ , dtData,     		 100,    daLeft,  true,    "ar_if_err_rsn",      false,    "",      dfNone,		0,	false,		false, 9,false);
				//InitDataProperty(0, cnt++ , dtHidden,     		 0,      daCenter,  true,    "bkg_no",      false,    "",      dfNone,		0,	false,		false, 9,false);
				InitDataProperty(0, cnt++ , dtHidden,     		 0,      daCenter,  true,    "bkg_seq",      false,    "",     dfNone,		0,	false,		false, 9,false);
	
				RequestTimeOut = 1000; 
				EditableColorDiff = false;
				WaitImageVisible = false; 
			}
			break;		
	
		}
	}
	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
		case COMMAND01:
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				var sXml = sheetObj.GetSaveXml("FNS_INV_0028GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"chk"),"sheet1_"));
					sheetObj.LoadSaveXml(sXml);
					ComOpenWait(false);
			}
			break;
			
		case COMMAND02:
			// BKG NO 다건 처리
			var sStr = formObj.no_text2.value;
			var arrStr = sStr.split(",");
 
			ComOpenWait(true);
			formObj.bkg_no_cnt.value = arrStr.length ;
			for (var i = 0; i < arrStr.length;i++ ) {
				if( arrStr[i] !=""){
				formObj.bkg_no.value = arrStr[i].trim(); 
		
					if(validateForm(sheetObj,formObj,sAction)){
						
						formObj.f_cmd.value = MULTI;
						var sXml = sheetObj.GetSaveXml("FNS_INV_0028GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"chk"),"sheet1_"));
							
						if (sXml.indexOf("ERROR") < 1){
							formObj.bkg_no_cnt.value = formObj.bkg_no_cnt.value - 1 ;
						}
						else {
							formObj.bkg_no_cnt.value = formObj.bkg_no_cnt.value ;
						}
			
						if( i == arrStr.length -1) {
							sheetObj.LoadSaveXml(sXml);
						}
					  }
					}
				}
			  ComOpenWait(false);
	
			break;		
			
		case IBSAVE:        //저장			
			
		var arIfNo = "";
		arIfNo = formObj.ar_if_no.value;
		if(arIfNo !=""){

			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				var sXml = sheetObj.GetSaveXml("FNS_INV_0028GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"chk"),"sheet1_"));
					sheetObj.LoadSaveXml(sXml);
					ComOpenWait(false);
			}
		}else{
			//no_text (,로 연결하여 여러건 입력)
			var sStr = formObj.no_text.value;
			var arrStr = sStr.split(",");
 
			ComOpenWait(true);
			formObj.if_no_cnt.value = arrStr.length ;
			for (var i = 0; i < arrStr.length;i++ ) {
				if( arrStr[i] !=""){
				formObj.ar_if_no.value = arrStr[i].trim(); 

			if(validateForm(sheetObj,formObj,sAction)){
				//ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				var sXml = sheetObj.GetSaveXml("FNS_INV_0028GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(false,true,"chk"),"sheet1_"));
		
		
					if (sXml.indexOf("ERROR") < 1){
						formObj.if_no_cnt.value = formObj.if_no_cnt.value - 1 ;
					}
					else {
						formObj.if_no_cnt.value = formObj.if_no_cnt.value ;
					}
		
					if( i == arrStr.length -1) {
						sheetObj.LoadSaveXml(sXml);
					}
		          }
			
				}
				
			}
			ComOpenWait(false);
		}
		
		break;	
	
		case IBSEARCH:      //조회
	
		if(validateForm(sheetObj,formObj,sAction)){	
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
	
			sheetObj.DoSearch("FNS_INV_0028GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
	
		break;
		
		case IBSEARCH_ASYNC10:      //other i/f 관리	
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var sXml = sheetObj.GetSearchXml("FNS_INV_0083GS.do", FormQueryString(formObj)); 
			var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
			//alert(state);
			var arIfNo = ComGetEtcData(sXml,"ar_if_no");
			//formObj.ar_if_no.value = arIfNo;
			alert("AR_IF_NO : "+arIfNo);
			ComOpenWait(false);		
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
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:			
				if(formObj.fm_if_dt.value==""&&formObj.to_if_dt.value==""&&formObj.trnk_vvd.value==""&&formObj.bl_src_no.value==""){
					ComShowCodeMessage("INV00004");
					formObj.fm_if_dt.focus();
					return;
				}
	
				if(ComGetDaysBetween(formObj.fm_if_dt.value,formObj.to_if_dt.value)>30){
					ComShowCodeMessage("INV00043");
					formObj.to_if_dt.focus();
					return;
				}
	
				if(formObj.fm_if_dt.value>formObj.to_if_dt.value){
					ComShowCodeMessage("INV00024");
					formObj.to_if_dt.focus();
					return;
				}
				break;
			}
		}     
	
		return true;
	}
	
	
	
	/**
	 * fm_if_dt,to_if_dt 변경시 날짜 유형 체크 후 masked value 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_ComGetMaskedValue('fm_if_dt');
	 * </pre>
	 * @param String elNm
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_ComGetMaskedValue(elNm) {
	
		var formObj;
	
		if (elNm == "fm_if_dt") {
			formObj = form.fm_if_dt;
		} else {
			formObj = form.to_if_dt;
		}
		var value = formObj.value;
	
		if(value=="") return;
		value = ComReplaceStr(value,"-","");
		if (value.length < 8) {
			ComShowCodeMessage("INV00024");
			return;
		} 
	
		if (value.substring(4,6) > 12) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		if (value.substring(4,6) == 00) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		if (value.substring(6,8) > 31) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		if (value.substring(6,8) == 00) {
			ComShowCodeMessage("INV00024");
			return;
		} 
		var ret = ComGetMaskedValue(value, "ymd")  ; 
		formObj.value = ret;
		
		if(elNm == "fm_if_dt"){
			if(form.to_if_dt.value==""){
				form.to_if_dt.value = ret;
			}
			form.to_if_dt.select(); 
		}
	}
	
	/**
	 * 선택된 탭의 fm_dt 자릿수 체크하여  to_dt로 포커스 이동 시켜주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkCustLeng('20090901');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	function checkFmDtLeng(value){    	  
		if(ComTrimAll(value," ", "-", ":").length==8){
			if(form.to_if_dt.value==""){
				form.to_if_dt.value = ComTrimAll(value," ", "-", ":");
			}
			form.to_if_dt.select(); 
		}
	}
	
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
	 *
	 * @return 없음
	 * @see #doActionIBSheet
	 */
	function getBackEndJobStatus() {
		form.f_cmd.value = SEARCH02;
		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0028GS.do", FormQueryString(form));
		var arrXml = sXml.split("|$$|");
		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
		var jobMsg = ComGetEtcData(arrXml[0], "jb_msg")
		if(jobState == "3") {
			clearInterval(timer);
			//getBackEndJobLoadFile();
			ComShowCodeMessage("INV00051");
			ComOpenWait(false);
	
		} else if(jobState == "4") {
			clearInterval(timer);
			// BackEndJob을 실패 하였습니다.
			ComShowCodeMessage("INV00089");
			ComOpenWait(false);
	
		} else if(jobState == "5") {
			clearInterval(timer);
			// 이미 BackEndJob 결과 파일을 읽었습니다.
			ComShowCodeMessage("INV00090");
			ComOpenWait(false);   	    	
		}
	}
	
	/**
	 * BackEndJob의 결과가 완료되면 결과를 조회한다.<br>
	 * 
	 * @return 없음
	 * @see #getBackEndJobStatus
	 */
	function getBackEndJobLoadFile() {
		form.f_cmd.value = SEARCH03;
		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0028GS.do", FormQueryString(form));
		var arrXml = sXml.split("|$$|");
		if(arrXml.length > 0) {
	
			if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="S"){
				alert(ComGetEtcData(sXml,"RESULT"));
			}
	
			form.backendjob_key.value = "";
		}
	}
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
	function initControl() {
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat('keypress',       'obj_keypress',    form); //- 키보드 입력할때
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	
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
			ComKeyOnlyAlphabet('upper');
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

/* 개발자 작업  끝 */