/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_INV_0138.js
 *@FileTitle : Invoice Detail Inquiry for AKLBA
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.15
 *@LastModifier : 김준호
 *@LastVersion : 1.0
 * 2009.09.07 최도순
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
	 * @class FNS_INV_0138 : FNS_INV_0138 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0138() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		    = setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl              = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	
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
	
			case "btn_new":
				sheetObject1.RemoveAll();
				formObject.fm_dt.value="";
				formObject.to_dt.value="";
				formObject.ar_ofc_cd.value="AKLBA";
				
//				formObject.vvd_cd.value="";
//				formObject.svc_scp_cd.value="";
//				formObject.io_bnd_cd.value="";
//				formObject.por_cd.value="";
//				formObject.pol_cd.value="";
//				formObject.pod_cd.value="";
//				formObject.del_cd.value="";
//				formObject.iss_opt.value="";
//				formObject.act_cust_cnt_cd.value="";
//				formObject.act_cust_seq.value="";
//				formObject.cust_lgl_eng_nm.value="";				
//				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
				break;
	
			case "btn_downexcel":
				sheetObjects[0].SpeedDown2Excel(-1,false,false,'','',false,false,'',false);
				break;
	
//			case "btn_actcust":
//				var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.act_cust_cnt_cd.value+'&cust_seq='+formObject.act_cust_seq.value+'&pop_yn=Y';
//				var Row = 1;
//				var Col = 1;
//				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
//				break; 
//			case "btn_custNm":
//				param = '?pgmNo=FNS_INV_0086&cust_seq='+formObject.act_cust_seq.value+'&cust_cnt_cd='+formObject.act_cust_cnt_cd.value;
//				ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
//				break;	
	
			case "btns_calendar1": //달력버튼
			var cal = new ComCalendar();
			cal.select(formObject.fm_dt, 'yyyy-MM-dd');
			break;
	
			case "btns_calendar2": //달력버튼
			var cal = new ComCalendar();
			cal.select(formObject.to_dt, 'yyyy-MM-dd');
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
			
//		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);	
//		document.form.iss_opt.value="";
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
				style.height = 350;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle1 = "|Seq.|IF Date|Good Date|BL No|AR IF No|VVD|SHPR|CNEE|Notify|POR|POL|POD|DEL|Charge|Charge Description|Currency|Unit Rate|Charge Amount|Ex.Rate|Total Amount|Container";
	
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,			00,		daCenter,		true,		"ibflag");
				InitDataProperty(rowCnt,	cnt++,	dtSeq,						40,		daCenter,		true,		"chg_seq");
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 		70,		daCenter,		true,		"bl_inv_if_dt",				false,		"",		dfDateYmd,		0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					70,		daCenter,		false,		"bl_inv_cfm_dt",			false,		"",		dfDateYmd,		0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					90	,	daCenter,		false,		"bl_src_no",				false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					80,		daCenter,		false,		"ar_if_no",				false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					80,		daCenter,		false,		"vvd",						false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					250,	daLeft,			false,		"shpr",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					250,	daLeft,			false,		"cnee",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					250,	daLeft,			false,		"notify",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,		"por_cd",					false,		"",		dfDateYmd,		0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,		"pol_cd",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,		"pod_cd",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,		"del_cd",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					50,		daCenter,		false,		"chg_cd",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					180,	daLeft,			false,		"chg_full_nm",			false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					70,		daCenter,		false,		"curr_cd",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					70,		daRight,		false,		"trf_rt_amt",				false,		"",		dfNullFloat,		3,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daRight,		false,		"chg_amt",				false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					75,		daRight,		false,		"inv_xch_rt",				false,		"",		dfNullFloat,		3,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daRight,		false,		"inv_ttl_locl_amt",		false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					300,	daLeft,			false,		"cntr_no",					false,		"",		dfNone,			0,		false);

				RequestTimeOut = 1000; 
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
	
//			case IBSEARCH_ASYNC01: // 화면 로딩시 AR_OFFICE_LIST 조회
//			ComOpenWait(true);
//			formObj.f_cmd.value = SEARCH02;
//			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
//			
//			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
//			var arrStr = sStr.split("|");
//		
//			MakeComboObject2(formObj.ar_ofc_cd, arrStr);
//		
//			var arrStr2 = "";
//			var ar_ofc_cd = "";
//			var arHdQtrOfcCd = "";
//			for(i=1;i<arrStr.length;i++){
//				arrStr2 = arrStr[i].split("^");
//				arHdQtrOfcCd = arrStr2[0]
//				                       if(arrStr2[1]==arrStr2[3]){
//				                    	   ar_ofc_cd = arrStr2[1];
//		
//				                    	   formObj.ar_ofc_cd.text = ar_ofc_cd;
//				                    	   formObj.ofc.value = ar_ofc_cd;
//				                    	   form.ofc_cd.value = form.ofc.value;	
//				                       }
//			}
//			formObj.ar_hd_qtr_ofc_cd.value=arHdQtrOfcCd;
		
//			formObj.f_cmd.value = SEARCH01;
//			sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
//			sStr = ComGetEtcData(sXml,"svc_scp_cd1");
//			arrStr = sStr.split("|");
//			MakeComboObject(formObj.svc_scp_cd, arrStr);
//			formObj.svc_scp_cd.text = "ALL";
		
//			ComOpenWait(false);
//			break;
		
			case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;			
				var sXml = sheetObj.GetSearchXml("FNS_INV_0138GS.do" , FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
		
				if ( arrXml[0] != null)	{
					sheetObjects[0].LoadSearchXml(arrXml[0]); 	
				}
				ComOpenWait(false);
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
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
			case IBSEARCH:        //조회				
		
			if( formObj.fm_dt.value.trim() == "" || formObj.to_dt.value.trim() == "" ) {
				ComShowCodeMessage("INV00004");
				formObj.fm_dt.focus();
				return;
			}
			
			if(formObj.fm_dt.value.trim() != "" && formObj.to_dt.value.trim() != ""){
				var diff_day = ComGetDaysBetween(replaceAll(formObj.fm_dt.value.trim(),"-",""),replaceAll(formObj.to_dt.value.trim(),"-",""));
			
				if(diff_day > 90) {
					ComShowCodeMessage("COM132001","I/F Date","90 Days" );
					return false;
				}
			}
	
			break;				
			}
		}     
	
		return true;
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
//	function MakeComboObject2(cmbObj, arrStr) {
//		for (var i = 1; i < arrStr.length;i++ ) {
//			var arrStr2 = arrStr[i].split("^");
//			var ar_ofc_cd = arrStr2[1];
//			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
//		}
//		cmbObj.InsertItem(0, "ALL", "ALL^ALL");
//		cmbObj.DropHeight = 190;
//	}
	
	/**
	 * 팝업 (FNS_INV_0086) UI 처리 후 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    getFNS_INV_0086_1(rowArray, 1, 1);
	 * </pre>
	 * @param String rowArray
	 * @param number row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
//	function getFNS_INV_0086_1(rowArray, row, col) {    	 
//		var colArray = rowArray[0];	
//		document.form.act_cust_cnt_cd.value = colArray[8];
//		document.form.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
//		fn_act_cust_chg();
//	}
	
	/**
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_act_cust_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
//	function fn_act_cust_chg(){
//		fn_dueDate_chg();
//		fn_cust_nm(); 
//	}
	
	/**
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * fn_act_cust_chg() 에서 호출
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
//	function fn_cust_nm(){
//		//입력Validation 확인하기 + 마스크구분자 넣기
//		document.form.f_cmd.value = SEARCH03;
//		var cust_nm = "";
//		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "")&&(form.cust_seq.value.trim() != "000000")){
//			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
//			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
//			if (cust_nm == undefined) {
//				form.cust_lgl_eng_nm.value="";
//				form.act_cust_seq.value="";
//				ComShowCodeMessage("INV00008");
//				form.act_cust_cnt_cd.focus();
//				return;   	    		  
//			}else{	  	    		    	  
//				form.cust_lgl_eng_nm.value=cust_nm;    
//			}
//		}
//	}    
	
	/**
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * fn_act_cust_chg() 에서 호출
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
//	function fn_dueDate_chg(){
//		if(form.act_cust_seq.value!=''){
//			form.act_cust_seq.value = ComLpad(form.act_cust_seq.value.trim(), 6, "0"); 			  
//		} 	
//	
//		form.cust_cnt_cd.value = form.act_cust_cnt_cd.value;
//		form.cust_seq.value = form.act_cust_seq.value;
//	}
	
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office act_cust_cnt_cd,act_cust_seq 세팅<br>
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
//	function ar_ofc_cd_OnChange(comboObj,value,text){ 
//		sheetObjects[0].RemoveAll();
//	
//		arrStr = value.split("^");
//		document.form.ofc.value = arrStr[1];
//		document.form.ofc_cd.value = arrStr[1];
//	}
	
	/**
	 * fm_dt,to_dt 변경시 날짜 유형 체크 후 masked value 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   fn_ComGetMaskedValue('fm_dt');
	 * </pre>
	 * @param String value
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_ComGetMaskedValue(elNm) {
		var formObj;
		if (elNm == "fm_dt") {
			formObj = form.fm_dt;
		} else {
			formObj = form.to_dt;
		}
		var value = formObj.value;
		if (value=="") return;
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
		if(elNm == "fm_dt"){
			if(form.to_dt.value==""){
				form.to_dt.value = ret;
			}
			form.to_dt.select(); 
		}
	}
	
	/**
	 * 날짜유형변경시 issue option 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   chgDtType('I');
	 * </pre>
	 * @param String dtType
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	/**
	function chgDtType(dtType){
		if(dtType=="I"){
			document.form.iss_opt.value="I"
				document.form.iss_opt.disabled = true;
		}else{
			document.form.iss_opt.disabled = false;
		}
	}
		 */
	
	/**
	 * 선택된 탭의 cust_cnt_cd 자릿수 체크하여  cust_seq로 포커스 이동 시켜주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkCustLeng('DE');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
//	function checkCustLeng(value){    	  
//		if(value.length==2){
//			form.act_cust_seq.focus(); 
//		}
//	}
	
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
			if(form.to_dt.value==""){
				form.to_dt.value = ComTrimAll(value," ", "-", ":");
			}
			form.to_dt.select(); 
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
	
//	function MakeComboObject(cmbObj, arrStr) {
//		//IBMultiCombo초기화
//	
//	   //cmbObj.ShowCol = 10;
//		for (var i = 0; i < arrStr.length;i++ ) {
//			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
//		}
//		cmbObj.DropHeight = 190;
//	
//	}
	
    /** 
     * 문자에 대해 특정 문자열을 다른 문자열로 치환<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {String} strTemp : 치환 대상 문자
     * @param  {String} strValue1 : 대상문자에서 치환할 문자
     * @param  {String} strValue2 : 다른 문자열로 치환할 문자
     * @return {String} 중국어 금액
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function replaceAll(strTemp, strValue1, strValue2){
  	  while(1){
  	    if( strTemp.indexOf(strValue1) != -1 ){
  	       strTemp = strTemp.replace(strValue1, strValue2);
  	    }else{
  	       break;
  	    }   
  	  }
  	   return strTemp;   	 
  	}
    
/* 개발자 작업  끝 */