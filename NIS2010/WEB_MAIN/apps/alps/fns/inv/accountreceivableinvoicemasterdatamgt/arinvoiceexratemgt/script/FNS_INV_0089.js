/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0089.js
*@FileTitle : Ex Rate Entry by Cusomtomer - Multi Cust
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.27 김세일
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
	 * @class fns_inv_0089 : fns_inv_0089 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0089() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
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
		var sheetObject2 = sheetObjects[1];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	
			switch(srcName) {
	
				case "btn_add":
					var indexKey = sheetObject1.DataInsert(-1);
					sheetObject1.CellEditable(indexKey,6) = false;
		
					break;  
		
				case "btn_del":
					ComRowHideDelete(sheetObject1, "DelChk");
					break;                                         
		
				case "btn_new":
					sheetObject1.RemoveAll();
					break; 
		
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;        
		
				case "btn_close":
					window.close();
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
	
		sheetObjects[1].Visible = false;
		openerCopy();	
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
	
		switch(sheetNo) {
			case 1:      //sheet1 init
			with (sheetObj) {
		
				// 높이 설정
				style.height = 240;
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
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
		
				var HeadTitle = "||Sel.|Seq.|Affiliate Cust.|Affiliate Cust.|Customer Name";
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
		
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,   "Status");
				InitDataProperty(0, cnt++ , dtCheckBox,      40,    daCenter,  false,   "DelChk");                    
				InitDataProperty(0, cnt++ , dtSeq,    			 40,    daCenter,  false,   "Seq");
				InitDataProperty(0, cnt++ , dtData,    			 70,    daCenter,  false,   "cust_cnt_cd",   	false,    "",    dfEngKey, 		0,     true,       true,	2);                      
				InitDataProperty(0, cnt++ , dtData, 			   80,    daCenter,  false,   "cust_seq",   	false,    "",    dfNone, 		0,     true,       true,	6);
		
				InitDataProperty(0, cnt++ , dtData,  				 50,    daCenter,  false,   "cust_nm",    			false,    "",    dfNone, 		0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,  				 50,    daCenter,  false,   "confirm_flag",    			false,    "",    dfNone, 		0,     true,       true);
				
				InitDataValid(0,    "cust_cnt_cd",   vtEngUpOnly);
		
		
			}
			break;
		
		
			case 2:      //sheet2 init
			with (sheetObj) {
		
				// 높이 설정
				style.height = 0;
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
				InitColumnInfo(17, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
		
				var HeadTitle = "|||From Date|To Date|Currency|Bound|Ex. Rate|Check Digit|Updated By|Updated Date";
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
		
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 40,daCenter, false, "DelChk");  
				InitDataProperty(0, cnt++ , dtSeq,    		 55,   daCenter,  false,     "Seq");
				InitDataProperty(0, cnt++ , dtPopupEdit, 	120,  daCenter,  false,     "fm_dt",   		false,          "",      dfDateYmd,    	0,     false,       true);
				InitDataProperty(0, cnt++ , dtPopupEdit,  	 120,  daCenter,   false,     "to_dt",    		false,          "",      dfDateYmd,    	0,     false,       true);
		
				InitDataProperty(0, cnt++ , dtData,    	100,   daCenter,  false,     "chg_curr_cd",    	false,          "",      dfNone,     		0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,    	100,   daCenter,  false,     "io_bnd_cd",   			false,          "",      dfNone,      	0,     false,       true);
				InitDataProperty(0, cnt++ , dtData,  		110,   daRight,	   false,     "inv_xch_rt",    		false,          "",      dfNullFloat,   6,     true,       true);
				InitDataProperty(0, cnt++ , dtData,  	    100,   daCenter,   false,     "check_digit",    false,          "",      dfNone,      	0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,    		110,   daCenter,  false,     "upd_usr_id",   	false,          "",      dfNone,      	0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,    		110,   daCenter,  false,     "upd_dt",   false,          "",      dfDateYmd,     0,     false,       false);                      
				InitDataProperty(0, cnt++ , dtHidden, 	   	0,   daCenter,  false,     "xch_rt_rvs_flg",   		false,          "",      dfNone,     		0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,  		0,   daRight,   false,     "ivs_xch_rt",   false,          "",      dfNullFloat,   6,     false,       true);
		
				InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "xch_rt_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "locl_curr_cd");
				InitDataProperty(0, cnt++ , dtHidden,  0,    daCenter,  true,    "ar_ofc_cd");
		
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
	
			case IBSEARCH:      //조회
			break;
		
			case IBSAVE:        //저장
			if(validateForm(sheetObjects[0],formObj,sAction)) return;
		
			var iCheckRow = sheetObjects[0].FindCheckedRow("DelChk"); 
			var iCheckRow2 = sheetObjects[1].FindCheckedRow("DelChk"); 
			if (iCheckRow== "") {
				ComShowCodeMessage("INV00025");
				return false;
			}
		
			if (iCheckRow2== "") {
				ComShowCodeMessage("INV00025");
				return false;
			}
		
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("FNS_INV_0089GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false,true,"DelChk"),"sheet1_") + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(false,true,"DelChk"),"sheet2_"));
		
			break;
		
			case IBINSERT:      // 입력		
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
				case IBSAVE:        //저장
					if (sheetObj.RowCount < 0) {
					ComShowCodeMessage("INV00001");
					return true;
				} else {
					for (var i=1; i<=sheetObj.RowCount; i++) {
						if (sheetObj.CellText(i,"cust_nm").trim() == ""){
							ComShowCodeMessage("INV00042",i+" Line");
							return true;
						}
					}
				}	
				break;
			}
		}     
		return;    
	}
	
	/**
	 * Customer Code 입력시 Customer Name을 가져온다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_cust_nm(1);
	 * </pre>
	 * @param number Row
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */	      
	function fn_cust_nm(Row){
		//입력Validation 확인하기 + 마스크구분자 넣기
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
		sheetObjects[0].CellValue2(Row,"cust_seq") = ComLpad(sheetObjects[0].CellValue(Row,"cust_seq"), 6, "0");
		document.form.cust_cnt_cd.value = sheetObjects[0].CellValue(Row,"cust_cnt_cd");
		document.form.cust_seq.value = sheetObjects[0].CellValue(Row,"cust_seq");
		if ((form.v_cust_cnt_cd.value.trim() != "" )&&(form.v_cust_seq.value.trim() != "" )){
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");   	    	  
			if (cust_nm == undefined) {   	    		
				form.cust_nm.value="";
				sheetObjects[0].CellValue2(Row,"cust_nm")="";
				ComShowCodeMessage("INV00054");
				sheetObjects[0].SelectCell(Row,"cust_seq");	  
				return;    	    		  
			} 
			sheetObjects[0].CellValue2(Row,"cust_nm") = cust_nm;	  
		}
	
	}
	
	/**
	 * Customer Code 입력시 중복 Customer 를 가져온다.<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_cust_nm(1);
	 * </pre>
	 * @param number Row
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */	
	function fn_cust_nm_dupli_chk(Row){
		//입력Validation 확인하기 + 마스크구분자 넣기
		document.form.f_cmd.value = SEARCH;
		var cnt = 0;
		document.form.cust_cnt_cd.value = sheetObjects[0].CellValue(Row,"cust_cnt_cd");
		document.form.cust_seq.value = sheetObjects[0].CellValue(Row,"cust_seq");
		if ((form.v_cust_cnt_cd.value.trim() != "" )&&(form.v_cust_seq.value.trim() != "" )){
			var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0089GS.do", FormQueryString(document.form));
			cnt = ComGetEtcData(sXml,"cnt");
			if (cnt > 0) {
				// 중복된 데이타가 있는데 저장할꺼니? 
				var result = ComShowCodeConfirm("INV00047");
				if (result) {
					sheetObjects[0].CellValue2(Row,"confirm_flag") = "U";
				} else {
					sheetObjects[0].CellValue2(Row,"DelChk") = true;
					ComRowHideDelete(sheetObjects[0], "DelChk");
				}
			} else {
				sheetObjects[0].CellValue2(Row,"confirm_flag") = "I";
			} 
	
		}
	
	}
	
	
	/**
	 * 그리드 변경시 실행 Customer Validation<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    sheet1_OnPopupClick(SheetObjects[0], 1,1,'20090901');
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number Col
	 * @param string Value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */  
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
	
		if (sheetObjects[0].ColSaveName(Col) == "cust_seq"){
			fn_cust_nm(Row);
			if(sheetObjects[0].CellValue(Row,"cust_nm")!=''){
				fn_cust_nm_dupli_chk(Row);
			}
		}
		return;
	}
	
	function sheet1_OnKeyUp(sheetObj,Row,Col,KeyCode,Shift){
		if(Col == 4&& sheetObj.EditText.length ==2){
			sheetObj.SelectCell(Row,5);
		}
	}
	
	/**
	 * 화면 로드시 부모창의 값들을 팝업에 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   openerCopy();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */  
	function openerCopy() {
	
		var sheetObj = opener.sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
	
		for (var i=1; i<=sheetObj.RowCount; i++) {
			sheetObj2.DataInsert(-1);
	
			//sheetObj2.CellValue(i,"ibflag") = "I";
			sheetObj2.RowStatus(i)  = "I";
			sheetObj2.CellValue(i,"DelChk") = sheetObj.CellText(i,"DelChk");
			sheetObj2.CellValue(i,"Seq") = sheetObj.CellText(i,"Seq");
			sheetObj2.CellValue(i,"fm_dt") = sheetObj.CellText(i,"fm_dt");
			sheetObj2.CellValue(i,"to_dt") = sheetObj.CellText(i,"to_dt");
			sheetObj2.CellValue(i,"chg_curr_cd") = sheetObj.CellText(i,"chg_curr_cd");
			sheetObj2.CellValue(i,"io_bnd_cd") = sheetObj.CellValue(i,"io_bnd_cd");
			sheetObj2.CellValue(i,"inv_xch_rt") = sheetObj.CellText(i,"inv_xch_rt");
			sheetObj2.CellValue(i,"check_digit") = sheetObj.CellText(i,"check_digit");
			sheetObj2.CellValue(i,"upd_usr_id") = sheetObj.CellText(i,"upd_usr_id");
			sheetObj2.CellValue(i,"upd_dt") = sheetObj.CellText(i,"upd_dt");
			sheetObj2.CellValue(i,"xch_rt_rvs_flg") = sheetObj.CellText(i,"xch_rt_rvs_flg");
			sheetObj2.CellValue(i,"ivs_xch_rt") = sheetObj.CellText(i,"ivs_xch_rt");
			sheetObj2.CellValue(i,"xch_rt_tp_cd") = sheetObj.CellText(i,"xch_rt_tp_cd");
			sheetObj2.CellValue(i,"locl_curr_cd") = sheetObj.CellText(i,"locl_curr_cd");
			sheetObj2.CellValue(i,"ar_ofc_cd") = sheetObj.CellText(i,"ar_ofc_cd");
		}
	
	}
   
/* 개발자 작업  끝 */