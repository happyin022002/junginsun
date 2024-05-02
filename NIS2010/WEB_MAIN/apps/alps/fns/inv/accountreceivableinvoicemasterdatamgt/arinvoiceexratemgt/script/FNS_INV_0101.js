/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0101.js
*@FileTitle : VVD Ex.Rate Creation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.07.07 김세일
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
	 * @class fns_inv_0101 : fns_inv_0101 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function fns_inv_0101() {
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
	var ROWMARK = "|";
	var FIELDMARK = "=";
	var retrieveFlg = 0;  
	
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
			case "Row_Add":
				if (retrieveFlg == 1) {
					var idx = sheetObject1.DataInsert(-1);
					for(i=0;i<formObject.bnd_cd.length;i++){
						if(formObject.bnd_cd[i].checked){
							bndCd = formObject.bnd_cd[i].value;
						}		 					
					}
					sheetObject1.CellValue2(idx,"io_bnd_cd") = bndCd;	 					
					sheetObject1.CellValue2(idx,"ar_ofc_cd") = formObject.ofc_cd.value;
					sheetObject1.CellValue2(idx,"xch_rt_tp_cd") = "V";
					sheetObject1.CellValue2(idx,"locl_curr_cd") =formObject.locl_curr_cd.value;
					sheetObject1.CellValue2(idx,"io_bnd_cd") = bndCd;	
					sheetObject1.CellValue2(idx,"vvd_cd") =formObject.vvd_cd.value;
					sheetObject1.CellValue2(idx,"vsl_cd") =formObject.vvd_cd.value.substring(0,4);
					sheetObject1.CellValue2(idx,"skd_voy_no") =formObject.vvd_cd.value.substring(4,8);
					sheetObject1.CellValue2(idx,"skd_dir_cd") =formObject.vvd_cd.value.substring(8,9);
	
					formObject.f_cmd.value = SEARCH07;
					formObject.vvd.value=formObject.vvd_cd.value;
					formObject.bnd.value=bndCd;
					formObject.port.value=sheetObject1.CellValue(idx,"port_cd");
	
					var sXml = sheetObject1.GetSearchXml("INVCommonGS.do", FormQueryString(formObject));
	
					var sStr = ComGetEtcData(sXml,"sail_arr_dt");	 					
					sheetObject1.CellValue2(idx,"etda_dt") =sStr;
				}	
				break; 
	
			case "btn2_Row_Copy":
				if (sheetObject1.RowCount > 0) {
					var idx = sheetObject1.DataCopy();
					for(i=0;i<formObject.bnd_cd.length;i++){
						if(formObject.bnd_cd[i].checked){
							bndCd = formObject.bnd_cd[i].value;
						}		 					
					}
					sheetObject1.CellValue2(idx,"io_bnd_cd") = bndCd;
					sheetObject1.CellValue2(idx,"ar_ofc_cd") = formObject.ofc_cd.value;
					sheetObject1.CellValue2(idx,"xch_rt_tp_cd") = "V";
	
				}
				break;
	
			case "btn2_Row_Delete":
				if (retrieveFlg == 1&& sheetObject1.RowCount > 0) {
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
				}
				break; 
	
			case "btn2_Down_Excel":
				sheetObject1.Down2Excel(1,false,false,true,'','',false,false,'',false,"DelChk");
				break;
	
			case "btn2_Load_Excel":
				sheetObject1.LoadExcel();
				break;
	
			case "btn1_Retrieve":
				retrieveFlg = 1;
				doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break; 
	
			case "btn1_New":
				retrieveFlg == 0;
				formObject.vvd.value = "";
				formObject.vvd_cd.value = "";
				formObject.bnd_cd[0].checked = true;
				formObject.bnd.value = "";
				formObject.svc_scp_cd.text = "ALL";
				formObject.vps_port_cd.text = "ALL";
				ComBtnDisable("btn_downexcel");
				sheetObject1.RemoveAll();
				doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC01); 	
				break;
	
			case "btn1_Save":
				if (retrieveFlg == 1) {
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
				}
				break;
	
			case "btn1_Close":
				alert(srcName);
				break;
			case "btn_downexcel":
				ComOpenWait(true);
				sheetObject1.SpeedDown2Excel(-1,false,false,'','',false,false,'',false,false,'',false,'',true);
				ComOpenWait(false);
				break;
			case "btn_print":
				if (sheetObject1.RowCount == 0) {
					ComShowCodeMessage("INV00095");
					return false;
				}
				rdOpen();
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
		initRdConfig(rdObjects[0]);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 	
		
		ComBtnDisable("btn_downexcel");
		
		document.form.vvd_cd.focus();
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
		switch(sheetObj.id) {
		case "sheet1":      //sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 402;
	
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);
	
			//var HeadTitle1 = "|Sel.|VVD|Port|ETD|Scope|Bound|Cur.|Ex. Rate|Updated By|Updated Date||||||||";
			var HeadTitle1 = "|VVD|Port|ETD|Scope|Bound|Cur.|Ex. Rate|Updated By|Updated Date|||||||||";
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	
			//데이터속성   [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,		DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtData,			150,	daCenter,	true,		"vvd_cd",			true,      "",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtComboEdit,	80,	daCenter,	true,		"port_cd",			true,      "",				dfNone,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"etda_dt",			false,		"",				dfDateYmd,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,		80,	daCenter,	true,		"svc_scp_cd",			true,		"",				dfNone,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtCombo,		80,	daCenter,	true,		"io_bnd_cd",			true,      "",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtCombo,		80,	daCenter,	true,		"chg_curr_cd",				true,      "",				dfNone,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,			140,	daRight,	true,		"inv_xch_rts",			true,		"",				dfNullFloat,		6,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			140,	daCenter,	true,		"upd_usr_id",			false,      "",				dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			0,		daCenter,	true,		"upd_dt",			false,      "",				dfDateYmd,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	true,		"inv_xch_rt",			true,		"",				dfNullFloat,		6,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,		"ivs_xch_rt",			true,		"",				dfNullFloat,		6,			true,		true);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"skd_voy_no");
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"skd_dir_cd");
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"vsl_cd");
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"locl_curr_cd");
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"ar_ofc_cd");
			InitDataProperty(0, cnt++ , dtHidden,  		0,    daCenter,  true,    "xch_rt_tp_cd");
			InitDataProperty(0, cnt++ , dtHidden,  		0,    daCenter,  true,    "pre_inv_xch_rt");
			CountPosition = 0;
			InitDataCombo(0, "chg_curr_cd", "USD", "USD");
			InitDataCombo(0, "svc_scp_cd", "AEW|TPW", "AEW|TPW");
			InitDataCombo(0, "port_cd", "DEHAM|NLRTM|GBFXT|USOAK", "DEHAM|NLRTM|GBFXT|USOAK");
			InitDataCombo(0, "io_bnd_cd", "I/B|O/B", "I|O");
	
			InitDataValid(0, "port_cd", vtEngUpOther, "0123456789"); 
			InitComboNoMatchText(true);
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
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("FNS_INV_0101GS.do", FormQueryString(formObj));
		
			//===========office list =======================//
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
					formObj.ar_ofc_cd2.value = ar_ofc_cd;
					formObj.ofc_cd.value = ar_ofc_cd;
					formObj.svr_id.value = arrStr2[7];
		
					formObj.locl_curr_cd.value = arrStr2[4];
					formObj.xch_rt_rvs_flg.value = arrStr2[8];
				}
			}
		
			//	        	form.xch_rt_rvs_flg.value = "N";
			//===========office list =======================//
		
			//================== scope list ===============//
			var scpStr = ComGetEtcData(sXml,"svc_scp_cd");
			var scpStr2 = ComGetEtcData(sXml,"svc_scp_cd")+"|KOJ";
			var arrScpStr = scpStr2.split("|");
		
			MakeComboObject(formObj.svc_scp_cd, arrScpStr);
			formObj.svc_scp_cd.text = "ALL";
		
			//================== scope list ===============//
		
			//====== currInfo combo list ====================//
			var comboValues = ComGetEtcData(sXml, "currInfo");	
			addCellComboItem(sheetObjects[0],comboValues,"chg_curr_cd",false);						
			//====== currInfo combo list ====================//
		
			//====== scope combo list ====================//
			addCellComboItem(sheetObjects[0],scpStr2,"svc_scp_cd",false);						
			//====== scope combo list ====================//
			ComOpenWait(false);
			break;    
		
			case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH02;
		
				sheetObj.DoSearch("FNS_INV_0101GS.do",FormQueryString(formObj));
				ComOpenWait(false);
		
			}  
			break;
		
			case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("FNS_INV_0101GS.do",FormQueryString(formObj)+ "&"+ ComSetPrifix(sheetObj.GetSaveString(),"sheet1_"),-1,false);
				ComOpenWait(false);
				
				ComBtnEnable("btn_downexcel");
			}
			break;
		
			case IBDELETE:      // 입력
			idx = sheetObj.SelectRow; 
			searchARInvoiceExist(sheetObj,idx);    
			
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
			case IBSEARCH: // 조회시 확인
			if (!ComChkValid(formObj)) return false;
			break;
			case IBSAVE:        //저장
			for (var i=1; i<=sheetObjects[0].RowCount; i++) {
				if(sheetObjects[0].CellValue(i,"ibflag")=="U"){
	
					if (sheetObjects[0].CellText(i,"pre_inv_xch_rt").trim() != ""&&sheetObjects[0].CellText(i,"pre_inv_xch_rt").trim() != "0"){
						if (!ComShowCodeConfirm("INV00126")){
							return false;
						}else{
							return true;
						}
					}
	
				}
	
			}
			break;
			}
	
			return true;
		}
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
	 * @version 2009.10.08
	 */         
	function MakeComboObject2(cmbObj, arrStr) {
		cmbObj.DropHeight = 190;
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var arOfcValue = arrStr2[1];
			cmbObj.InsertItem(i-1, arOfcValue, arrStr[i]);
		}
	}      
	
	
	/**
	 * 그리드내 콤보필드에 데이터를 추가해준다.
	 */		
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
		var arrStr2;
	
	
	
		if (colName == 'chg_curr_cd') {
			if (comboValues != undefined) {
				comboItems = comboValues.split(ROWMARK);
	
				for (var i = 1 ; i < comboItems.length ; i++) {
					arrStr2 = comboItems[i].split("^");
					comboItem = comboItems[i].split(FIELDMARK);
					if ((arrStr2[0] != "")&&(arrStr2[0] != form.locl_curr_cd.value)) {
						comboTxt += arrStr2[0];
						comboVal += arrStr2[0];
					}
					if(arrStr2[0] != form.locl_curr_cd.value){
						if (i < comboItems.length-1) {
							comboTxt += ROWMARK;
							comboVal += ROWMARK;
						}
					}
				}
	
			}
		} else {
			if (comboValues != undefined) {
				comboItems = comboValues.split(ROWMARK);
				for (var i = 1 ; i < comboItems.length ; i++) {
					comboItem = comboItems[i].split(FIELDMARK);
	
					if ((comboItem[0] != "")&&(comboItem[0] != form.locl_curr_cd.value)) {
						comboTxt += comboItem[0];
						comboVal += comboItem[0];
					}
					if (i < comboItems.length-1) {
	
						comboTxt += ROWMARK;
						comboVal += ROWMARK;
					}
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
	 * currency 변경시 description 처리
	 */
	//function sheet1_OnChange(sheetObj,Row,col,sValue){
	//if(sheetObj.ColSaveName(col) == "chg_curr_cd")
	//{
	//var chgCurr = sheetObj.CellValue(Row,"chg_curr_cd").split("^");
	//var chgCurrCd = chgCurr[0];
	//var chgCurNm = chgCurr[1];
	//sheetObj.CellText(Row,"chg_curr_cd") = chgCurrCd;
	//sheetObj.CellText(Row,"curr_nm") = chgCurNm;
	//}
	
	//}
	
	/**
	 * Vps Port CD 입력시 값세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     vps_port_cd_OnBlur(form.ar_ofc_cd);
	 * </pre>
	 * @param object cmbObj
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function vps_port_cd_OnBlur(comboObj){
		if(comboObj.Text!=''){
			upperText = comboObj.Text.toUpperCase();
			var itemindex = comboObj.FindIndex ( upperText, 0);
			if(itemindex==-1){
				comboObj.Text2 ="ALL";
			}else{
				comboObj.Text2 = upperText;
			}
		}
	}
	
	/**
	 * Sheet retrieve 종료시 Sheet산 Col Copy<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSearchEnd(sheetObjects[0],'');
	 * </pre>
	 * @param object sheetObj
	 * @param string ErrMsg
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){      		
		sheetObj.Copy2SheetCol(sheetObj,"inv_xch_rt","inv_xch_rts") 
		sheetObj.Copy2SheetCol(sheetObj,"inv_xch_rt","pre_inv_xch_rt") 
	}
	
	/**
	 * Sheet Save 종료시 Sheet Retrieve<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnSaveEnd(sheetObjects[0],'');
	 * </pre>
	 * @param object sheetObj
	 * @param string ErrMsg
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){      		
		retrieveFlg = 1;
		doActionIBSheet(sheetObject1,document.form,IBSEARCH);
	}
	
	
	/**
	 * Sheet 변경시 경리환율 체크<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     sheet1_OnChange(sheetObjects[0],1,1);
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @param number col
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function sheet1_OnChange(sheetObj,Row,col){
	
	
		var effDt = ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
	
		if (sheetObj.ColSaveName(col) == "inv_xch_rts") {
	
			document.form2.f_cmd.value = SEARCH03;
			document.form2.curr_cd.value = sheetObj.CellValue(Row,"chg_curr_cd");
			document.form2.locl_curr_cd.value = document.form.locl_curr_cd.value
			document.form2.vvd_cd.value = sheetObj.CellValue(Row,"vvd_cd");
			document.form2.port_cd.value = sheetObj.CellValue(Row,"port_cd");
			document.form2.io_bnd_cd.value = sheetObj.CellValue(Row,"io_bnd_cd");
			var sXml = sheetObj.GetSearchXml("FNS_INV_0101GS.do", FormQueryString(document.form2));
			var usd_locl_xch_rt = ComGetEtcData(sXml,"usd_locl_xch_rt");
			if(usd_locl_xch_rt ==""){
				ComShowCodeMessage("INV00001");
				sheetObj.CellValue2(Row,"inv_xch_rts")=sheetObj.CellValue(Row,"inv_xch_rt");
				sheetObj.SelectCell(Row,"inv_xch_rts");
				return;
			}else if(usd_locl_xch_rt =="saDt") {
				ComShowCodeMessage("INV00007");
				sheetObj.CellValue2(Row,"inv_xch_rts")=sheetObj.CellValue(Row,"inv_xch_rt");
				sheetObj.SelectCell(Row,"inv_xch_rts");
				return;
			}else { 					
				var sValue = sheetObj.CellValue(Row,"inv_xch_rts");
				var valRate = sValue/usd_locl_xch_rt;
				var ivs_rate = 1/sValue;
				ivs_rate = ComRound(ivs_rate, 4);
	
				//2010.01.13 역환율 계산 없앰 이상희과장
				/*
				if (form.xch_rt_rvs_flg.value=='Y') {
					if((ivs_rate > 1.5) ||((ivs_rate < 0.5))) {
 	    	        	ComShowCodeMessage("INV00016");
 	    	        	sheetObj.CellValue2(Row,"inv_xch_rts")=sheetObj.CellValue(Row,"inv_xch_rt");
 	    	        	sheetObj.SelectCell(Row,"inv_xch_rts");
 	    	        	return;
 	    	        }
				}else{
				 */
				if((valRate > 1.5) ||((valRate < 0.5))) {
					ComShowCodeMessage("INV00016");
					sheetObj.CellValue2(Row,"inv_xch_rts")=sheetObj.CellValue(Row,"inv_xch_rt");
					sheetObj.SelectCell(Row,"inv_xch_rts");
					return;
				}
				//}
	
			}
	
			//var ivs_rate = 1/sValue;
			//ivs_rate = ComRound(ivs_rate, 4);
			sheetObj.CellValue(Row,"ivs_xch_rts") = ivs_rate;
	
			//2010.01.13 역환율 계산 없앰 이상희과장
			/*
			if (form.xch_rt_rvs_flg.value=='Y') {
				sheetObj.CellValue(Row,"inv_xch_rt") = ivs_rate;
				sheetObj.CellValue(Row,"ivs_xch_rt") = sValue;
			} else {
			 */
			sheetObj.CellValue(Row,"inv_xch_rt") = sValue;
			sheetObj.CellValue(Row,"ivs_xch_rt") = ivs_rate;	
			//}
	
		}else if(sheetObj.ColSaveName(col) == "port_cd"){
			
			if(sheetObj.CellValue(Row,"vvd_cd").substring(0,4)!='CFDR'&&sheetObj.CellValue(Row,"vvd_cd").substring(0,4)!='USAC'){
				document.form.f_cmd.value = SEARCH07;
				document.form.vvd.value=sheetObj.CellValue(Row,"vvd_cd");
				document.form.bnd.value=sheetObj.CellValue(Row,"io_bnd_cd");
				document.form.port.value=sheetObj.CellValue(Row,"port_cd");
		
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(document.form));
		
				var sStr = ComGetEtcData(sXml,"sail_arr_dt");
						
				if(sStr==""&&sheetObj.CellValue(Row,"port_cd")!=""){
					ComShowCodeMessage("INV00050");
					sheetObj.CellValue(Row,"port_cd") = "";
					document.form.port.value = "";
					return;
				}else{
					sheetObj.CellValue2(Row,"etda_dt") =sStr;
				}
			}
		}
	
	}
	
	/**
	 * 삭제시 경리환율 존재여부 체크<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *     searchARInvoiceExist(sheetObjects[0],1);
	 * </pre>
	 * @param object sheetObj
	 * @param number Row
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */
	function searchARInvoiceExist(sheetObj,Row){  
	
		document.form2.f_cmd.value = REMOVE;
		document.form2.chg_curr_cd.value = sheetObj.CellValue(Row,"chg_curr_cd");
		document.form2.locl_curr_cd.value = document.form.locl_curr_cd.value
		document.form2.vsl_cd.value = sheetObj.CellValue(Row,"vsl_cd");
		document.form2.skd_voy_no.value = sheetObj.CellValue(Row,"skd_voy_no");
		document.form2.skd_dir_cd.value = sheetObj.CellValue(Row,"skd_dir_cd");
		document.form2.port_cd.value = sheetObj.CellValue(Row,"port_cd");
		document.form2.io_bnd_cd.value = sheetObj.CellValue(Row,"io_bnd_cd");
		document.form2.svc_scp_cd.value = sheetObj.CellValue(Row,"svc_scp_cd");
		var sXml = sheetObj.GetSearchXml("FNS_INV_0101GS.do", FormQueryString(document.form2));
		var chkCnt = ComGetEtcData(sXml,"cnt");
		if(sheetObj.RowStatus(Row)=="I"){
			sheetObj.RowHidden(Row)= true;		//2.행 숨기기
			sheetObj.RowStatus(Row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
		}else{
			if(chkCnt =="0"){				
				if (!ComShowCodeConfirm("INV00028")) return;
				sheetObj.RowHidden(Row)= true;		//2.행 숨기기
				sheetObj.RowStatus(Row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
			}else {
				ComShowCodeMessage("INV00037");
				return;
			}
		}
	
	}
	
	/**
	 * 콤보박스 ar_ofc_cd 데이터 변경시 실행되는 function<br>
	 * 해당 office세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   ar_ofc_cd_OnChange(document.form,'HAMBB','HAMBB');
	 * </pre>
	 * @param object comboObj
	 * @param string value
	 * @param string text
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */		  
	function ar_ofc_cd_OnChange(comboObj,value,text) {
		var arrStr = comboObj.Code.split("^");
		document.form.ar_ofc_cd2.value = arrStr[1];
		document.form.ofc_cd.value = arrStr[1];
		document.form.locl_curr_cd.value = arrStr[4];
		document.form.svr_id.value = arrStr[7];
		form.xch_rt_rvs_flg.value = arrStr[8];
		sheetObjects[0].RemoveAll();
	
		document.form.vps_port_cd.RemoveAll();
	
		document.form.f_cmd.value = SEARCH01;
		var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0101GS.do", FormQueryString(document.form));
	
		var portStr = ComGetEtcData(sXml,"portList");
		var arrPortStr = portStr.split("|");
	
		MakeComboObject(document.form.vps_port_cd, arrPortStr);
		document.form.vps_port_cd.text = "ALL";   
	
		//====== port combo list ====================//
		addCellComboItem(sheetObjects[0],portStr,"port_cd",false);
	
	}
	
	/**
	 * 옵션에 따라 헤더 재 세팅<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *   changeHeaderName('I');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.10.08
	 */		 
	function changeHeaderName(value){
		sheetObjects[0].RemoveAll();
	
		if(value=='I'){
			sheetObjects[0].InitHeadRow(0, "|VVD|Port|ETA|Scope|Bound|Cur.|Ex. Rate|Updated By|Updated Date||||||||");
		}else{
			sheetObjects[0].InitHeadRow(0, "|VVD|Port|ETD|Scope|Bound|Cur.|Ex. Rate|Updated By|Updated Date||||||||");
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
	
	function MakeComboObject(cmbObj, arrStr) {
		//IBMultiCombo초기화
		for (var i = 0; i < arrStr.length;i++ ) {
			cmbObj.InsertItem(i, arrStr[i], arrStr[i]);
		}
		cmbObj.DropHeight = 190;
	}
	
	/**
     * RD Object 초기화 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initRdConfig(rdObject)
     * </pre>
     * @param {rdviewer} rdObject Rdviewer Object
     * @return 없음
     * @author 정휘택
     * @version 2009.10.20
     */ 
    function initRdConfig(rdObject){
	     var Rdviewer = rdObject;
	     Rdviewer.style.height = 0;
	     Rdviewer.style.width = 0;
	    
	     Rdviewer.AutoAdjust = true;
	     Rdviewer.ViewShowMode(0);
	    
		 Rdviewer.setbackgroundcolor(128,128,128);
		 Rdviewer.SetPageLineColor(128,128,128);
	 }
    
    /**
	 * print화면 오픈
	 * @param vvd VVD
	 * @param pod POD
	 * @param del DEL
	 * @param bl BL No.
	 */
	function rdOpen() {
		var sXml = "";
		var form = document.form;
		var sheet_obj1 = document.sheet1;
		var io_bnd_cd = "";
		if(form.bnd_cd[0].checked == true){
			io_bnd_cd = "O/B";
		}else{
			io_bnd_cd = "I/B";
		}
		
		sXml = "<?xml version='1.0' ?><SHEET>";
		sXml += RD_GetDataSearchXml(sheet_obj1, 1);
		sXml += "<ETC>";
		sXml += "<ar_ofc_cd>" + form.ar_ofc_cd.Text + "</ar_ofc_cd>"
		sXml += "<locl_curr_cd>" + form.locl_curr_cd.value + "</locl_curr_cd>"
		sXml += "<vvd_cd>" + form.vvd_cd.value + "</vvd_cd>"
		sXml += "<port_cd>" + form.vps_port_cd.Text + "</port_cd>"
		sXml += "<svc_scp_cd>" + form.svc_scp_cd.Text + "</svc_scp_cd>"
		sXml += "<io_bnd_cd>" + io_bnd_cd + "</io_bnd_cd>"		
		sXml += "</ETC>";
		sXml += "</SHEET>";

		rdObjects[0].SetRData(sXml);
		
		var rdFile = "FNS_INV_0101.mrd";		
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemasterdatamgt/arinvoiceexratemgt/report/";
			
		rdObjects[0].FileOpen(RD_path + rdUrl + rdFile, RDServer + "/rpagenuminit [1] /riprnmargin /rwait");
		//rdObjects[0].FileOpen("http://localhost:7001/hanjin/" + rdUrl + rdFile, RDServer + "/rpagenuminit [1] /riprnmargin /rwait");		
		rdObjects[0].CMPrint ();
	}
/* 개발자 작업  끝 */