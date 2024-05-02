/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FNS_INV_0094_01.js
 *@FileTitle : Invoice Customer Change(Single)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.20
 *@LastModifier : 최도순
 *@LastVersion : 1.0
 * 2009.08.20 최도순
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2012.03.12 권   민 [CHM-201216480] SAOSC의 인보이스 이슈 기능 개발 요청
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
	 * @class FNS_INV_0094_01 : FNS_INV_0094_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0094_01() {
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
		var sheetObject2 = sheetObjects[1];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
	
			switch(srcName) {
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
	
			case "btn_New":
				formObject.ar_ofc_cd.RemoveAll(); 
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				ComResetAll();
	
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
	
				ComBtnDisable("btn_GotoSend");
				ComBtnDisable("btn_PaperIssue");
				ComBtnEnable("btn_Retrieve");
				ComBtnEnable("btn_Save");
	
				formObject.inv_no.readOnly=false;
				formObject.act_cust_cnt_cd.readOnly=false;
				formObject.act_cust_seq.readOnly=false;				
				formObject.inv_cust_cnt_cd.readOnly=false;
				formObject.inv_cust_seq.readOnly=false;
	
				formObject.inv_no.className = "input1";
				formObject.act_cust_cnt_cd.className = "input1";
				formObject.act_cust_seq.className = "input1";
				formObject.inv_cust_cnt_cd.className = "input1";
				formObject.inv_cust_seq.className = "input1";
				
				formObject.inv_no.focus();
				break;
	
			case "btn_Save":
				doActionIBSheet(sheetObject2,formObject,IBSAVE);
				break;
	
			case "btn_actcust":
				var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.act_cust_cnt_cd.value+'&cust_seq='+formObject.act_cust_seq.value+'&pop_yn=Y';
				var Row = 1;
				var Col = 1;
				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
				break; 
			case "btn_custNm":
				param = '?pgmNo=FNS_INV_0086&cust_seq='+formObject.act_cust_seq.value+'&cust_cnt_cd='+formObject.act_cust_cnt_cd.value;
				ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_1', '1,0', false, false, Row, Col, 0);
				break;
			
			case "btn_invcust":
				var param = '?pgmNo=FNS_INV_0013&cust_cnt_cd='+formObject.inv_cust_cnt_cd.value+'&cust_seq='+formObject.inv_cust_seq.value+'&pop_yn=Y';
				var Row = 1;
				var Col = 1;
				ComOpenPopup('/hanjin/FNS_INV_0013.do'+param, 920, 650, '', '0,0', false, false, "", "", 0);
				break; 
			case "btn_invCustNm":
				param = '?pgmNo=FNS_INV_0086&cust_seq='+formObject.inv_cust_seq.value+'&cust_cnt_cd='+formObject.inv_cust_cnt_cd.value;
				ComOpenPopup('/hanjin/FNS_INV_0086.do' + param, 900, 450, 'getFNS_INV_0086_2', '1,0', false, false, Row, Col, 0);
				break;
	
			case "btn_PaperIssue":
	
				if(validateForm(sheetObject2,formObject,"IBSAVE")){
					ComBtnDisable("btn_PaperIssue");
					ComBtnDisable("btn_GotoSend");
	
					formObject.email_flag.value = "N";
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);                 
				}
				break;
	
			case "btn_GotoSend":
				if(validateForm(sheetObjects[0],document.form,"")){
	
					ComBtnDisable("btn_PaperIssue");
					ComBtnDisable("btn_GotoSend");
					
					var ar_ofc_cd = formObject.ar_ofc_cd2.value;
					if (ar_ofc_cd == "DXBSC") {
						
						formObject.bl_nos.value = "'"+ formObject.frm_bl_src_no.value + "'";
						
						var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
						formObject.svr_id.value = arrStr2[7]; 			    
						formObject.ots_smry_cd.value = arrStr2[13]; 	
						formObject.inv_dup_flg.value = arrStr2[14]; 
						formObject.inv_mlt_bl_iss_flg.value = arrStr2[15]; 	
						
						var param = FormQueryString(formObject);
						ComOpenWindowCenter("FNS_INV_0110.do?"+param, "pop", 730, 400);
						//FNS_INV_0110 에서 issue ok 되면 호출 -  getFnsInv0110()
					}else{
						formObject.email_flag.value = "Y";
						doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
		
						var state = formObject.state.value;  
						var r_invs = formObject.inv_nos.value;  
						var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
						formObject.ar_ofc_cd2.value = arrStr2[1];	
					}
	
				} else {
					return;
				} 		
	
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
	
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
	
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );	
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}	
	
		initControl();
	
		initRdConfig(rdObjects[0]);
	
		ComBtnDisable("btn_GotoSend");
		ComBtnDisable("btn_PaperIssue");
		
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01); 	
		
		form.inv_no.focus();
		
	}
		
	function initRdConfig(rdObject){
		var Rdviewer = rdObject ;
		Rdviewer.style.height = 0;
		Rdviewer.style.width = 0;
	
		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
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
				style.height = 200;
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
	
				var HeadTitle1 = "|Seq.|CHG|Cur|Rate|Rated As|Per|Amount|Ex. Rate|Local Amount|";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	00,		daCenter,		true,			"ibflag");
				InitDataProperty(rowCnt,	cnt++,	dtSeq,					70,		daCenter,		true,		"chg_seq");
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	100,	daCenter,		true,			"chg_cd",						false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					80,		daCenter,		false,		"curr_cd",						false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daRight,		false,		"trf_rt_amt",						false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					100,	daRight,		false,		"rat_as_cntr_qty",					false,		"",		dfNullFloat,		2,		false);				
				InitDataProperty(rowCnt,	cnt++,	dtData,					80,		daCenter,		false,		"per_tp_cd",						false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					150,	daRight,		false,		"chg_amt",					false,		"",		dfNullFloat,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,					140,	daRight,		false,		"inv_xch_rt",					false,		"",		dfNullFloat,	7,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,				140,	daRight,		false,		"locl_amt",					false,		"Round(|chg_amt|*|inv_xch_rt|,2)",		dfNullFloat,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtHidden,				140,	daRight,		false,		"inv_ttl_locl_amt",					false,		"",		dfNone,	2,		false);
				
	
				CountPosition = 0;
				EditableColorDiff = false;
				WaitImageVisible = false; 
			}
			break;
	
		case "sheet2":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 0;
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
	
				var HeadTitle1 = "|inv_no|ar_if_no|ar_ofc_cd|bl_src_no|bkg_no|iss_dt|inv_ref_no|vvd|por_cd|pol_cd|pod_cd|del_cd|sail_arr_dt|svc_scp_cd|io_bnd_cd|act_cust_cnt_cd|act_cust_seq|cust_nm|rev_tp_cd|rev_src_cd|inv_cust_cnt_cd|inv_cust_seq|inv_cust_nm";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	00,		daCenter,		true,			"ibflag");
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daCenter,		true,			"inv_no",			false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daCenter,		true,			"ar_if_no",				false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	80,		daCenter,		true,			"ar_ofc_cd",			false,		"",		dfDateYmd,			0,		false);
	
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daCenter,		true,			"bl_src_no",						false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	90,		daCenter,		true,			"bkg_no",					false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	80,		daCenter,		true,			"iss_dt",						false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	60,		daCenter,		true,			"inv_ref_no",						false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	60,		daCenter,		true,			"vvd",						false,		"",		dfNone,					0,		false);
	
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	60,		daCenter,		true,			"por_cd",					false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	60,		daCenter,		true,			"pol_cd",					false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	50,		daCenter,		true,			"pod_cd",						false,		"",		dfNone,					0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"del_cd",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"sail_arr_dt",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"svc_scp_cd",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"io_bnd_cd",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"act_cust_cnt_cd",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"act_cust_seq",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"cust_nm",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"rev_tp_cd",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"rev_src_cd",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"inv_cust_cnt_cd",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"inv_cust_seq",					false,		"",		dfNone,		2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,				50,	daRight,		false,		"inv_cust_nm",					false,		"",		dfNone,		2,		false);
				
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
	
				formObj.ar_ofc_cd.text = ar_ofc_cd;
				formObj.ofc.value = ar_ofc_cd;
				form.ofc_cd.value = form.ofc.value;	
			}
		}
	
		ComOpenWait(false);
	
		break;
	
		case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)){
			
			ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("FNS_INV_0094_01GS.do" , FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
	
			if ( arrXml[0] != null)	{
				sheetObjects[1].LoadSearchXml(arrXml[0]); 	
			}
			if ( arrXml[1] != null)	{
				sheetObjects[0].LoadSearchXml(arrXml[1]); 	
			}
			
			if(ComGetEtcData(sXml,"TRANS_RESULT_KEY")=="F"){
				ComOpenWait(false);
				form.inv_no.select();
				return;
			}
	
			formObj.act_cust_cnt_cd.value="";
			formObj.act_cust_seq.value="";
			formObj.cust_lgl_eng_nm.value="";
			
			ComOpenWait(false);
		}
		break;
	
		case IBSAVE:        //저장
		if(validateForm(sheetObj,formObj,sAction)){
			ComOpenWait(true);
			
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("FNS_INV_0094_01GS.do", FormQueryString(formObj),"");
	
			ar_ofc_cd = document.form.ofc_cd.value;
	
			if(ar_ofc_cd == "SZPSC" || ar_ofc_cd == "XMNSC" || ar_ofc_cd == "CANSO"){
				ComBtnDisable("btn_PaperIssue");
			}else{
				ComBtnEnable("btn_PaperIssue");						
			}
	
			ComBtnEnable("btn_GotoSend");
			ComBtnDisable("btn_Retrieve");
			ComBtnDisable("btn_Save");
	
			formObj.inv_no.readOnly=true;
			formObj.act_cust_cnt_cd.readOnly=true;
			formObj.act_cust_seq.readOnly=true;
			formObj.inv_cust_cnt_cd.readOnly=true;
			formObj.inv_cust_seq.readOnly=true;
	
			formObj.inv_no.className = "input2";
			formObj.act_cust_cnt_cd.className = "input2";
			formObj.act_cust_seq.className = "input2";
			formObj.inv_cust_cnt_cd.className = "input2";
			formObj.inv_cust_seq.className = "input2";
			
			ComOpenWait(false);
		}
		break;
	
		case IBINSERT:      //입력
	
	
		formObj.bl_nos.value = "'"+ formObj.frm_bl_src_no.value + "'";
	
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		formObj.svr_id.value = arrStr2[7]; 			    
		formObj.ots_smry_cd.value = arrStr2[13]; 	
		formObj.inv_dup_flg.value = arrStr2[14]; 
		formObj.inv_mlt_bl_iss_flg.value = arrStr2[15]; 
	
	
		formObj.cust_cnt_cd.value = "";
		formObj.cust_seq.value = "";
	
		formObj.f_cmd.value = MULTI;
		var sXml = sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj)); 	
		var arrXml = sXml.split("|$$|");
		var backEndJobKey = ComGetEtcData(arrXml[0], "BackEndJobKey")
		if(backEndJobKey.length > 0) {
			formObj.backendjob_key.value = backEndJobKey;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			sheetObj.RequestTimeOut = 10000;
			timer = setInterval(getBackEndJobStatus, 3000);
		}
	
		break;
	
	
		case IBSEARCH_ASYNC10: // Number of copy invoice 조회
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		formObj.ar_ofc_cd2.value = arrStr2[1];
		formObj.f_cmd.value = SEARCH;
		var sXml = sheetObj.GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(formObj));
	
		formObj.copy_cnt.value = ComGetEtcData(sXml,"copy_cnt");
	
		var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
		formObj.print_nm.value = sStr;
		break;
		}
	}
	
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	
	}
	
	
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
		case 1:
			with (tabObj) {
	
				var cnt  = 0 ;
				InsertTab( cnt++ , "Single" , -1 );
				InsertTab( cnt++ , "Multi" , -1 );
	
			}
			break;
	
		}
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		switch(nItem) {
	
		case 0:	   				
			break;
	
		case 1:
			location.href = "/hanjin/FNS_INV_0094_02.do?pgmNo=FNS_INV_0094";	   			
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
	
			if( formObj.inv_no.value.trim() == "" || formObj.ofc_cd.value.trim() == "" ) {
				ComShowCodeMessage("INV00004");
				formObj.inv_no.focus();
				return;
			} 
	
			break;
			case IBSAVE:        //저장
			if( (formObj.act_cust_cnt_cd.value.trim() == "" || formObj.act_cust_seq.value.trim() == "") && 
					(formObj.inv_cust_cnt_cd.value.trim() == "" || formObj.inv_cust_seq.value.trim() == "") ) {
				ComShowCodeMessage("INV00004");
				formObj.act_cust_cnt_cd.focus();
				return;
			}
			break;
			}
		}     
	
		return true;
	}
	
	/**
	 * sheet1 retrieve 종료시 실행되는 function<br>
	 * sum관련 셀 설정
	 * <br><b>Example : </b>
	 * <pre>
	 *   sheet1_OnSearchEnd(sheetObjects[0],"");
	 * </pre>
	 * @param object sheetObj
	 * @param String ErrMsg
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			//ShowSubSum("curr_cd", "9", -1, false, false, 0, "per_tp_cd=Total;curr_cd=%s");
			CellValue(LastRow ,"chg_seq") = "";
			CellValue(LastRow ,"inv_xch_rt") = "Local Total";
			CellAlign(LastRow ,"inv_xch_rt") =daRight;
			CellValue(LastRow ,"locl_amt") = CellValue(1 ,"inv_ttl_locl_amt");
		}
	}
	
	/**
	 * sheet2 retrieve 종료시 실행되는 function<br>
	 * 그리드 행을 form에 세팅
	 * <br><b>Example : </b>
	 * <pre>
	 *   sheet1_OnSearchEnd(sheetObjects[0],"");
	 * </pre>
	 * @param object sheetObj
	 * @param String ErrMsg
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function sheet2_OnSearchEnd(sheetObj,ErrMsg){    	 
		IBS_CopyRowToForm(sheetObjects[1],document.form, 1,"frm_") ;  	    
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
	function getFNS_INV_0086_1(rowArray, row, col) {    	 
		var colArray = rowArray[0];	
		document.form.act_cust_cnt_cd.value = colArray[8];
		document.form.act_cust_seq.value = ComLpad(colArray[9], 6, '0');
		fn_act_cust_chg();
	}
	 
	 /**
	 * 팝업 (FNS_INV_0086) UI 처리 후 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    getFNS_INV_0086_2(rowArray, 1, 1);
	 * </pre>
	 * @param String rowArray
	 * @param number row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function getFNS_INV_0086_2(rowArray, row, col) {    	 
		var colArray = rowArray[0];	
		document.form.inv_cust_cnt_cd.value = colArray[8];
		document.form.inv_cust_seq.value = ComLpad(colArray[9], 6, '0');
		fn_inv_cust_chg();
	}
	
	/**
	 * Go to Send 클릭시 메일 팝업(FNS_INV_0034_02) 호출 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    open_email();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function openEmail() {
		var ar_ofc_cd = document.form.ar_ofc_cd2.value;
		if (ar_ofc_cd == "SZPSC" || ar_ofc_cd == "XMNSC" || ar_ofc_cd == "CANSO") {
			//     		ComOpenPopup('/hanjin/FNS_INV_0037.do?issueGubn=I', 1010, 610, '', '0,0'); 
			ComOpenWindowCenter("FNS_INV_0037.do?issueGubn=I", "pop", 1010, 750);
		} else {
			//     		ComOpenPopup('/hanjin/FNS_INV_0034_02.do?issueGubn=I', 1010, 610, '', '0,0');  
			ComOpenWindowCenter("FNS_INV_0034_02.do?issueGubn=I", "pop", 1010, 750);
		}
	}
	
	/**
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_act_cust_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_act_cust_chg(){
		fn_dueDate_chg();
		fn_cust_nm(); 
	}
	 
	
	/**
	 * inv_cust_cnt_cd, inv_cust_seq 변경시 실행되는 function<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    fn_inv_cust_chg();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_inv_cust_chg(){
		if(form.inv_cust_seq.value!=''){
			form.inv_cust_seq.value = ComLpad(form.inv_cust_seq.value.trim(), 6, "0");
	
			if( form.inv_cust_cnt_cd.value == form.frm_inv_cust_cnt_cd.value&&form.inv_cust_seq.value==form.frm_inv_cust_seq.value){
				ComShowCodeMessage("INV00031");
				form.inv_cust_cnt_cd.value="";
				form.inv_cust_seq.value="";
				form.inv_cust_lgl_eng_nm.value="";
				form.inv_cust_cnt_cd.focus();
				return;
			}
	
		}
	
	
		form.cust_cnt_cd.value = form.inv_cust_cnt_cd.value;
		form.cust_seq.value = form.inv_cust_seq.value;
		form.ofc_cd.value = form.ofc.value;
		
		//입력Validation 확인하기 + 마스크구분자 넣기
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "")&&(form.cust_seq.value.trim() != "000000")){
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
			delt_flg = ComGetEtcData(sXml,"delt_flg");
			if(delt_flg=='Y'){
				form.inv_cust_lgl_eng_nm.value="";
				form.inv_cust_seq.value="";
				form.cust_seq.value="";
				ComShowCodeMessage("INV00060");
				form.inv_cust_cnt_cd.focus();
				return;
			}
	
			if (cust_nm == undefined) {
				form.inv_cust_lgl_eng_nm.value="";
				form.inv_cust_seq.value="";
				ComShowCodeMessage("INV00008");
				form.inv_cust_cnt_cd.focus();
				return;   	    		  
			}else{
				if(sheetObjects[1].RowCount>0){
					sheetObjects[1].CellValue(1,"inv_cust_cnt_cd") = form.inv_cust_cnt_cd.value;
					sheetObjects[1].CellValue(1,"inv_cust_seq") = form.inv_cust_seq.value; 	     			  
				}  
	
				form.inv_cust_lgl_eng_nm.value=cust_nm;    
			}
		}
	}
	
	/**
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * fn_act_cust_chg() 에서 호출
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_cust_nm(){
		//입력Validation 확인하기 + 마스크구분자 넣기
		document.form.f_cmd.value = SEARCH03;
		var cust_nm = "";
		if ((form.cust_cnt_cd.value.trim() != "" )&&(form.cust_seq.value.trim() != "")&&(form.cust_seq.value.trim() != "000000")){
			var sXml = sheetObjects[0].GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
			cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
			delt_flg = ComGetEtcData(sXml,"delt_flg");
			if(delt_flg=='Y'){
				form.cust_lgl_eng_nm.value="";
				form.act_cust_seq.value="";
				form.cust_seq.value="";
				ComShowCodeMessage("INV00060");
				form.act_cust_cnt_cd.focus();
				return;
			}
	
			if (cust_nm == undefined) {
				form.cust_lgl_eng_nm.value="";
				form.act_cust_seq.value="";
				ComShowCodeMessage("INV00008");
				form.act_cust_cnt_cd.focus();
				return;   	    		  
			}else{
				if(sheetObjects[1].RowCount>0){
					sheetObjects[1].CellValue(1,"act_cust_cnt_cd") = form.act_cust_cnt_cd.value;
					sheetObjects[1].CellValue(1,"act_cust_seq") = form.act_cust_seq.value; 	     			  
				}  
	
				form.cust_lgl_eng_nm.value=cust_nm;    
			}
		}
	}   
	
	
	/**
	 * act_cust_cnt_cd, act_cust_seq 변경시 실행되는 function<br>
	 * fn_act_cust_chg() 에서 호출
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function fn_dueDate_chg(){
		if(form.act_cust_seq.value!=''){
			form.act_cust_seq.value = ComLpad(form.act_cust_seq.value.trim(), 6, "0");
	
			if( form.act_cust_cnt_cd.value == form.frm_act_cust_cnt_cd.value&&form.act_cust_seq.value==form.frm_act_cust_seq.value){
				ComShowCodeMessage("INV00031");
				form.act_cust_cnt_cd.value="";
				form.act_cust_seq.value="";
				form.cust_lgl_eng_nm.value="";
				form.act_cust_cnt_cd.focus();
				return;
			}
	
		}
	
	
		form.cust_cnt_cd.value = form.act_cust_cnt_cd.value;
		form.cust_seq.value = form.act_cust_seq.value;
		form.ofc_cd.value = form.ofc.value;
	}
	
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd_OnChange(document.form,'HAMSC','HAMSC');
	 * </pre>
	 * @param object comboObj
	 * @param string value
	 * @param string text
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	
	function ar_ofc_cd_OnChange(comboObj,value,text){ 
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		//sheetObjects[2].RemoveAll();	
	
		arrStr = value.split("^");
		document.form.ofc.value = arrStr[1];
		document.form.ofc_cd.value = arrStr[1];
		get_copy_cnt();
	}
	
	/**
	 * paper issue 관련 Number of copy invoice를 해당 office로 조회해서 값 세팅 <br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   get_copy_cnt();
	 * </pre>
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */	    
	function get_copy_cnt() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;		    
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC10);	    	
	
	}
	
	/**
	 * RD File 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     rdOpen(Rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn)
	 * </pre>
	 * @param {rdviewer} rdObject Rdviewer Object
	 * @param {String} inv_no Invoice number
	 * @param {String} line_num Description lile 수 
	 * @param {String} user_nm 사용자명
	 * @param {String} ofc_cd office code
	 * @param {String} logo logo 명
	 * @param {String} vvd vvd
	 * @param {String} port_cd port code
	 * @param {String} attach letter wording 첨부 flag
	 * @param {String} paperYn print, email 구분
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function rdOpen(Rdviewer, inv_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn){
	
		var rdFile = "";		
	
		if (ofc_cd == "HAMSC" || ofc_cd == "HAMRU") {
			rdFile = "FNS_INV_0503.mrd";
		} else if (ofc_cd == "GOASC") {
			rdFile = "FNS_INV_0504.mrd";
		} else if (ofc_cd == "ANRSO") {
			rdFile = "FNS_INV_0505.mrd";
		} else if (ofc_cd == "BUDSC") {
			rdFile = "FNS_INV_0506.mrd";
		} else if (ofc_cd == "RTMSC") {
			rdFile = "FNS_INV_0507.mrd";
		} else if (ofc_cd == "WRPSC") {
			rdFile = "FNS_INV_0508.mrd";
		} else if (ofc_cd == "PRGSC") {
			rdFile = "FNS_INV_0509.mrd";
		} else if (ofc_cd == "VLCSC") {
			rdFile = "FNS_INV_0510.mrd";
		} else if (ofc_cd == "SINSC") {
			rdFile = "FNS_INV_0511.mrd";
		} else if (ofc_cd == "PKGSC") {
			rdFile = "FNS_INV_0512.mrd";
		} else if (ofc_cd == "CMBSC") {
			rdFile = "FNS_INV_0513.mrd";
		} else if (ofc_cd == "BOMSC") {
			rdFile = "FNS_INV_0514.mrd";
		} else if (ofc_cd == "SYDSC") {
			rdFile = "FNS_INV_0515.mrd";
		} else if (ofc_cd == "SHASC" || ofc_cd == "SHARC") {
			rdFile = "FNS_INV_0516.mrd";
		} else if (ofc_cd == "HKGSC") {
			rdFile = "FNS_INV_0518.mrd";
		} else if (ofc_cd == "FXTSC" || ofc_cd == "LONBC1") {
			rdFile = "FNS_INV_0521.mrd";
		} else if (ofc_cd == "LEHSC") {
			rdFile = "FNS_INV_0522.mrd";
	//		} else if (ofc_cd == "SGNSC") {
	//		rdFile = "FNS_INV_0520.mrd";
		} else if (ofc_cd == "JKTSC") {
			rdFile = "FNS_INV_0527.mrd";
		} else if (ofc_cd == "DXBSC") {
			rdFile = "FNS_INV_0530.mrd";
		} else if (ofc_cd == "BKKSC") {	
			rdFile = "FNS_INV_0540.mrd";
		} else if (ofc_cd == "DACSC") {	
			rdFile = "FNS_INV_0541.mrd";
		} else if (ofc_cd == "SAOSC") {
			rdFile = "FNS_INV_0542.mrd";
		}					
	
		if (ofc_cd == "BOMSC" || ofc_cd == "SYDSC" || ofc_cd == "FXTSC" || ofc_cd == "LEHSC") {
			ofc_cd = document.form.login_ofc_cd.value;
		}
	
		rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type[] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
	
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";	
	
		// 열고자 하는 RD 파일을 지정한다.		
		Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
	
	}    
	
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
	function checkCustLeng(value){    	  
		if(value.length==2){
			form.act_cust_seq.focus(); 
		}
	}
	 
	 /**
	 * 선택된 탭의 cust_cnt_cd 자릿수 체크하여  cust_seq로 포커스 이동 시켜주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkCustLeng2('DE');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.10.06
	 */
	function checkCustLeng2(value){    	  
		if(value.length==2){
			form.inv_cust_seq.focus(); 
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
		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(form));
		var arrXml = sXml.split("|$$|");
		var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg")
		if(jobState == "3") {
			clearInterval(timer);
			getBackEndJobLoadFile();
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
		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0034_01GS.do", FormQueryString(form));
		//alert(sXml);
		var arrXml = sXml.split("|$$|");
		if(arrXml.length > 0) {
			//sheetObjects[0].LoadSearchXml(arrXml[0]);
			form.backendjob_key.value = "";
	
			var sStr = ComGetEtcData(sXml,"inv_nos");	
			//alert(sStr);
	
	//		if (sStr == "") {
	//		ComShowCodeMessage("INV00095");
	//		return;
	//		}	
	
			var sStr2 = sStr.split("&");
	
			var arrStr = sStr2[0].split("|");
	
			if (arrStr.length > 1) {
				form.f_inv.value = arrStr[0];	
				form.t_inv.value = arrStr[arrStr.length - 2];
				form.tot_inv_cnt.value = ComAddComma2(arrStr.length - 1, "#,###");
	
			} 
	
			var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
	
			var r_invs = arrStr[0];  
			/*
				if (sStr2[1] != "") {
					ComShowCodeMessage("INV00096", sStr2[1]);
				} else if (r_invs == "") {
					ComShowCodeMessage("INV00097");
				}
			 */
			if (r_invs == "") {
				ComShowCodeMessage("INV00097");
				form.f_inv.value = "";
				form.t_inv.value = "";
				form.tot_inv_cnt.value = "";
				return false;
			}
	
			if (state == "S" && r_invs != "") {	 						
				//alert(r_invs);
				var arrStr2 = form.ar_ofc_cd.Code.split("^");
				form.ar_ofc_cd2.value = arrStr2[1];	                    
				var v_f_inv = form.f_inv.value;
				var v_t_inv = form.t_inv.value;
				var arrStr3 = sStr2[0].split("|");
				var v_copy_cnt = form.copy_cnt.value;  
	
	
				//alert(form.email_flag.value);
				if (form.email_flag.value == "N") {
					rdObjects[0].SetAppendReport(1);
					for(var i=0; i<arrStr3.length -1; i++){
						//alert(arrStr3[i]);
						rdOpen(rdObjects[0], arrStr3[i], 15, form.user_nm.value, form.ar_ofc_cd2.value, "ORIGINAL", "", "", "N", "Y");
						for(var j=0; j<v_copy_cnt; j++) {  						
							rdOpen(rdObjects[0], arrStr3[i], 15, form.user_nm.value, form.ar_ofc_cd2.value, "COPY", "", "", "N", "Y");
						}
	
					}  
	
					rdObjects[0].SetAppendReport(0); 
					//프린트세팅
					var print_nm = form.print_nm.value;
					if(print_nm != ""){
						rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
					}
					rdObjects[0].CMPrint (); //인쇄 시작
				} else {
					openEmail();
				}
	
			} 
	
		}
	}
	
	function keyEnterRetreive(e){
		if(e.keyCode == '13') {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
	
	 /**
	  * DXBSC 일 경우, FNS_INV_0110 팝업화면을 호출 후, ISSUE OK 되면 호출되는 함수 <br>
	  * <br><b>Example :</b>
	  * @param
	  * @return
	  * @author 정휘택
	  * @version 2009.10.20
	  */
	 function getFnsInv0110(){
		 document.form.email_flag.value = "Y";

		 doActionIBSheet(sheetObjects[0],document.form,IBINSERT);

		 var state = document.form.state.value;  
		 var r_invs = document.form.inv_nos.value;  
		 var arrStr2 = document.form.ar_ofc_cd.Code.split("^");
		 document.form.ar_ofc_cd2.value = arrStr2[1];	
	 }
/* 개발자 작업  끝 */