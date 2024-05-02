/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EES_DOD_0005.js
 *@FileTitle : Drop Off Tariff Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.02
 *@LastModifier : YOON, Yong-Sang
 *@LastVersion : 1.0
 * 2015.11.02 YOON, Yong-Sang
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2000.00.00
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
	 * @class ees_dod_0005 : ees_dod_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_dod_0005() {
		this.processButtonClick = processButtonClick;
		this.setSheetObject     = setSheetObject;
		this.loadPage           = loadPage;
		this.initSheet          = initSheet;
		this.initControl        = initControl;
		this.doActionIBSheet    = doActionIBSheet;
		this.setTabObject       = setTabObject;
		this.validateForm       = validateForm;
	}

	/* 개발자 작업 */
	
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt     = 0;
	var beforetab  = 1;
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt     = 0;
	
	var comboObjects = new Array();
	var comboCnt     = 0;
	  
	var prefix1 = "sheet1_";
	var prefix2 = "sheet2_";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var sheetObj1 = sheetObjects[0]; // t1sheet1
		var sheetObj2 = sheetObjects[1]; // t2sheet1
		
		var tabObj    = tabObjects[0];
		var comboObj  = comboObjects[0];

		var formObj   = document.form;
		
		var selTabIdx = tabObj.SelectedIndex;
	
		/** **************************************************** */
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {	
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH, SEARCHLIST01, selTabIdx);
					break;
//				case "btn_Retrieve2":
//					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH, SEARCHLIST01, prefix2);
//					break;									
				case "btn_New": 
				case "btn_New2":
					ComResetAll();
					comboObj.RemoveAll();				
					//초기 포커스 위치
					ComSetFocus(formObj.s_cnt_cd);	
					if(selTabIdx == 0){
						document.form.s_trf_div_cd.value = "G";
					} else {
						document.form.s_trf_div_cd.value = "S";
					}
					
					break;	
				case "btn_Excel":
					sheetObjects[selTabIdx].ExcelPrint = "";
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBDOWNEXCEL);
					break;
				case "btn_rowcopy":			
					var s1Row = 13;
				case "btn_rowcopy2":
					var s2Row = 18;
					var pRow = s1Row == undefined ? s2Row : s1Row;
					var selRow = sheetObjects[selTabIdx].SelectRow;
					var sRow = sheetObjects[selTabIdx].FindCheckedRow(2);
					var arrRow = sRow.split("|");
					if (arrRow.length != 2) {						
						ComShowCodeMessage("DOD00013");
					} else { 
						var rowId = sheetObjects[selTabIdx].DataInsert();		
						for(var i=3;i<=pRow;i++){
							sheetObjects[selTabIdx].CellValue2(rowId, i) = sheetObjects[selTabIdx].CellValue(selRow, i);
						}
						var prefix = selTabIdx;
						if(prefix == "0"){
							prefix = prefix1;
						} else {
							prefix = prefix2;
						}
						sheetObjects[selTabIdx].CellValue2(rowId, prefix + "drp_off_chg_trf_div_cd") = (prefix.indexOf("1")>-1?"G":"S");
						sheetObjects[selTabIdx].CellValue2(rowId, prefix + "drp_off_chg_trf_eff_dt") = ComGetDateAdd(null, "D", +1);
						sheetObjects[selTabIdx].CellValue2(rowId, prefix + "drp_off_chg_trf_exp_dt") = "9999-12-31";						
						sheetObjects[selTabIdx].CellValue2(rowId, prefix + "drp_off_chg_trf_seq") = "";
						
					}
					
					break;
				case "btn_rowadd":
					doActionIBSheet(sheetObjects[selTabIdx] ,formObj, IBINSERT, "", prefix1);
					break;
				case "btn_rowadd2":
					doActionIBSheet(sheetObjects[selTabIdx] ,formObj, IBINSERT, "", prefix2);
					break;					
				case "btn_Delete":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBDELETE, "", prefix1);
					break;
				case "btn_Delete2":
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBDELETE, "", prefix2);
					break;
				case "btn_expire":
					var sRow = sheetObjects[selTabIdx].FindCheckedRow(prefix1 + "del_chk");
					var arrRow = sRow.split("|");
					if (arrRow.length != 2) {
 	 			       	ComShowCodeMessage("DOD00013");
					} else {
						doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH_ASYNC01, COMMAND01, prefix1);
					}										
					break;
				case "btn_expire2":										
					var sRow = sheetObjects[selTabIdx].FindCheckedRow(prefix2 + "del_chk");
					var arrRow = sRow.split("|");
					if (arrRow.length != 2) {
 	 			       	ComShowCodeMessage("DOD00013");
					} else {
						doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSEARCH_ASYNC01, COMMAND02, prefix2);
					}										
					break;
				case "btn_Save":
					duplicate_validation(sheetObjects[selTabIdx], formObj, prefix1, SEARCH01);
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE, MULTI01, prefix1);					
					break;
				case "btn_Save2":
					duplicate_validation(sheetObjects[selTabIdx], formObj, prefix2, SEARCH02);
					doActionIBSheet(sheetObjects[selTabIdx], formObj, IBSAVE, MULTI02, prefix2);					
					break;
				case "btn_Calendar":
					var cal = new ComCalendarFromTo();
					cal.select(formObj.s_frm_eff_dt, formObj.s_to_eff_dt, 'yyyy-MM-dd');
					break;
				case 'btn_customer':
					popCustomer('setCustomerPop');
					break;
			}
		} catch (e) {
			if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
		}
	}
	
	function duplicate_validation(sheetObj, formObj, prefix, fCmd){
		formObj.f_cmd.value = fCmd;
		sheetObj.DoRowSearch("EES_DOD_0005GS.do", ComGetSaveString(sheetObj) +"&"+ FormQueryString(formObj) +"&"+ComGetPrefixParam(prefix));
			
	}
	
	/**
	 * customer popup
	 */
	function popCustomer(callbackfunc){
		ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, callbackfunc, '1,0,1,1,1,1,1,1');
	}

	/**
	 * customer 팝업에서 값 가져오기
	 */
	function setCustomerPop(rowArray){
		var formObj = document.form;
		if(rowArray.length>0){
			formObj.s_cust_cd.value = rowArray[0][3];
			formObj.s_cust_nm.value = rowArray[0][4];
		}

	}
	
	/** 
     * t2sheet1 팝업연결 선택시 발생하는 t2sheet1_OnPopupClick 이벤트핸들러 <br>>
     * 
     */
 	function t2sheet1_OnPopupClick(sheetObj, Row, Col) {

 		var form  = document.form;
			var sName      = sheetObj.ColSaveName(Col);
			switch(sName) {
 			case prefix2 + "spcl_cust_cnt_seq":
 				popCustomerSheet(sheetObj, Row, Col);	
 				break;
			}
 	}
 	
	/**
	 *  Customer Code 공통 팝업 오픈(sheet)
	 */
	function popCustomerSheet(sheetObj, Row, Col ){
		ComOpenPopup('/hanjin/COM_ENS_041.do', 770, 470, 'setCustPopSheet', '1,0,1,1,1,1,1,1', true, true, Row, Col, 1);

	}


	function setCustPopSheet(rowArray, Row, Col, sheetIdx) {
		if(rowArray.length>0){
			sheetObjects[sheetIdx].CellValue2(Row, prefix2 + "spcl_cust_cnt_seq") = rowArray[0][3];
			sheetObjects[sheetIdx].CellValue2(Row, prefix2 + "spcl_cust_nm") = rowArray[0][4];
		}
	}
	
	/**
	 * cust_cd 에서 포커스를 떠날시
	 * 숫자를 자동으로 앞에 0을 넣어 6자리로 만들기
	 * @param obj
	 * @return
	 */
	function fncCustSeqBlur(obj){
	    var orgV = obj.value;
	    if(orgV.length < 1){
	        obj.value = "";
	    }else{
	        obj.value = fncSeqTo6(orgV);
	    }
	}
	/**
	 * cust_cd의 seq에 0을 넣어 6자리로 만들기
	 * @param str
	 * @return
	 */
	function fncSeqTo6(str){
	    var retStr = str.substring(0, 2);
	    str = str.substring(2);
	    var currentObjLen = str.length;
	    for(var i=0;i<6-currentObjLen;i++){
	        retStr += "0";
	    }
	    return retStr + str;
	}
	
	/**
	 * IBSheet 개체 Cell의 입력값을 onchange 이벤트 발생시에 대문자로 변환하는 함수
	 * @param : sheet object
	 * @param : Row
	 * @param : Col
	 */	
	function _sheet_onchange() { /// sheetObj, Row, Col
		var argv = _sheet_onchange.arguments;
		var argc = argv.length; 
		var sheetObj = argv[0];
		if ( argc > 0 && sheetObj!=undefined && sheetObj!=null ) {
			var Row = argv[1];
			var Col = argv[2];
			if ( Row!=undefined && Row!=null && Row >=0 && Col!=undefined && Col!=null && Col >=0 ) {				
				if ( sheetObj.ReadDataProperty(0, sheetObj.ColSaveName(Col), dpDataType)  == dtData ) {
					sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, Col).toUpperCase();
				}
			}
		}
		argv = null;
	}

	
	function pointAutoMove(val) {
		if ( val.length == 8  ) {
			document.form.s_frm_eff_dt.focus();
		}
	}	
	
	function t1sheet1_OnChange(sheetObj,Row,Col,Value) {
		//_sheet_onchange( sheetObj,Row,Col,Value );
		var colname = sheetObj.ColSaveName(Col);
		switch (colname) {
		case prefix1 + "del_chk":			
			if(Value == "1" && 0 < Number(sheetObj.CellValue(Row, prefix1 + "chg_cnt"))){
				ComBtnDisable("btn_Delete");
			} else {
				var disCnt = 0;
				for(var i=1;i<=sheetObj.RowCount; i++ ){  						
					if( "1" == sheetObj.CellValue(i, Col)){
						disCnt++;
					}
				}
				if(disCnt == 0){
					ComBtnEnable("btn_Delete");
				}
				
			}
			
			var exCnt = 0;
			for(var i=1;i<=sheetObj.RowCount; i++ ){  						
				if( "1" == sheetObj.CellValue(i, Col)){
					exCnt++;
				}
			}
			if(Value == "1" && exCnt == 1 && "C" == sheetObj.CellValue(Row, prefix1 + "drp_off_chg_trf_cfm_flg")){
				ComBtnEnable("btn_expire");
			} else {
				if(exCnt > 1 || exCnt == 0){
					ComBtnDisable("btn_expire");
				}
			}
			break;			
		case prefix1 + "drp_off_chg_trf_eff_dt":
			if(Number(Value) < Number(ComGetNowInfo("ymd").replace(/\/|\-|\./g, ""))){
				ComShowMessage("Effective Date should be later than Today");
				sheetObj.CellValue2(Row, Col) = ComGetNowInfo("ymd");
 				sheetObj.SelectCell(Row, Col);
			}
			break;
		case prefix1 + "cntr_tpsz_cd":
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH07, "TP/SZ Code");
			break;
		case prefix1 + "cntr_rtn_loc_cd":	
//			var cntCd =  sheetObj.CellValue(Row, prefix1 + "drp_off_chg_trf_cnt_cd");
//			if(cntCd == undefined || cntCd == null || cntCd.trim() == ""){
//				ComShowCodeMessage('DOD00011');
//				sheetObj.SelectCell(Row, prefix1 + "drp_off_chg_trf_cnt_cd");
//				return;
//			}
			if(Value.trim() == ""){
				return;
			}
			var cntCd = Value.substr(0,2).toUpperCase();
			sheetObj.CellValue2(Row, prefix1 + "drp_off_chg_trf_cnt_cd") = cntCd;
			
			var param = "f_cmd=" + SEARCH03 + "&s_cnt_cd=" + cntCd.toUpperCase() + "&s_rtn_loc_cd=" + Value;
			var sXml = sheetObjects[1].GetSaveXml("EES_DOD_0005GS.do", param);
			
			var conti = ComGetEtcData(sXml, "conti");
			var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			
			if(result == "S"){
				if(conti == null || conti == undefined || conti == "") {				
					ComShowMessage("There's no input another continent.");
					sheetObj.CellValue2(Row, Col) = "";
	 				sheetObj.SelectCell(Row, Col);
	 				break;
				}
			}
			
			setDivCombo(sheetObj,Row, prefix1);
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH08, "RTN-Location");
			
			
			break;
		case prefix1 + "drp_off_chg_trf_cnt_cd":
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH11, "Country Code");
			break;
		case prefix1 + "del_cd":
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH08, "Location Code");
			break;
		case prefix1 + "cntr_rtn_yd_sfx_cd":
			Value = Value.trim();
			if(Value == "" || Value == "ALL"){
				return false;
			}
			var rtnLoc = sheetObj.CellValue( Row, Col -1 );
			
			Value = rtnLoc != "" ? rtnLoc.trim() + Value : "";
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH09, "Yard Code");
			break;
		}	
	
	}
	
	function chkValidateSheets(sheetObj, Row, Col, Value, fCmd, label){
		if(Value.trim() == ""){
			return;
		}
		var param = "f_cmd=" + fCmd + "&s_value=" + Value.toUpperCase();
		var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
		
		var count = ComGetEtcData(sXml, "count");
		var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		
		if(result == "S"){
			if(parseInt(count) == 0) {				
				ComShowMessage(ComGetMsg("COM12114", label));
				sheetObj.CellValue2(Row, Col) = "";
 				sheetObj.SelectCell(Row, Col);
			}

			//RFA_NO, SC_NO VALIDATION 성공시 해당 Customer List를 가져와서 Combo Box를 만듬
			if(parseInt(count) > 0 && (fCmd == SEARCH05 || fCmd == SEARCH06)) {
				var param2 = "f_cmd=" + SEARCH04 + "&sc_no=" + sheetObj.CellValue(Row, prefix2 + "sc_no") + "&rfa_no=" + sheetObj.CellValue(Row, prefix2 + "rfa_no");

				var sXml = sheetObjects[2].GetSaveXml("EES_DOD_0005GS.do", param2);
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
				if(result == "S"){
					sheetObj.CellComboItem (Row, prefix2 + "spcl_cust_nm", ComGetEtcData(sXml, "name"), ComGetEtcData(sXml, "code"), 0);
					sheetObj.CellValue2(Row, prefix2 + "cust_nm") = ComGetEtcData(sXml, "cust_nm");
				}

			}
		}
	}
	
	function t2sheet1_OnChange(sheetObj,Row,Col,Value) {
		//_sheet_onchange( sheetObj,Row,Col,Value );
		var colname = sheetObj.ColSaveName(Col);
		switch (colname) {
		case prefix2 + "del_chk":
			var disCnt = 0;
			if(Value == "1" && 0 < Number(sheetObj.CellValue(Row, prefix2 + "chg_cnt"))){
				ComBtnDisable("btn_Delete2");
			} else {
				
				for(var i=1;i<=sheetObj.RowCount; i++ ){  						
					if( "1" == sheetObj.CellValue(i, Col)){
						disCnt++;
					}
				}
				if(disCnt == 0){
					ComBtnEnable("btn_Delete2");
				}
				
			}
			var exCnt = 0;
			for(var i=1;i<=sheetObj.RowCount; i++ ){  						
				if( "1" == sheetObj.CellValue(i, Col)){
					exCnt++;
				}
			}
			if(Value == "1" && exCnt == 1 && "C" == sheetObj.CellValue(Row, prefix2 + "drp_off_chg_trf_cfm_flg")){
				ComBtnEnable("btn_expire2");
			} else {
				if(exCnt > 1 || exCnt == 0){
					ComBtnDisable("btn_expire2");
				}
			}
			break;		
		case prefix2 + "drp_off_chg_trf_eff_dt":
			if(Number(Value) < Number(ComGetNowInfo("ymd").replace(/\/|\-|\./g, ""))){
				ComShowMessage("Effective Date should be later than Today");
				sheetObj.CellValue2(Row, Col) = ComGetNowInfo("ymd");
 				sheetObj.SelectCell(Row, Col);
			}
			break;
		case prefix2 + "rfa_no":
			if(Value.trim() == ""){
				sheetObj.CellValue2(Row, prefix2 + "spcl_cust_nm") = "";
				sheetObj.CellValue2(Row, prefix2 + "spcl_cust_cnt_seq") = ""; 
			}
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH05, "RFA No.");
			break;
		case prefix2 + "sc_no":
			if(Value.trim() == ""){
				sheetObj.CellValue2(Row, prefix2 + "spcl_cust_nm") = "";
				sheetObj.CellValue2(Row, prefix2 + "spcl_cust_cnt_seq") = ""; 
			}
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH06, "S/C No.");
			break;
		case prefix2 + "cntr_tpsz_cd":
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH07, "TP/SZ Code");
			break;
		case prefix2 + "cntr_rtn_loc_cd":
//			var cntCd =  sheetObj.CellValue(Row, prefix2 + "drp_off_chg_trf_cnt_cd");
//			if(cntCd == undefined || cntCd == null || cntCd.trim() == ""){
//				ComShowCodeMessage('DOD00011');
//				sheetObj.SelectCell(Row, prefix2 + "drp_off_chg_trf_cnt_cd");
//				return;
//			}
			if(Value.trim() == ""){
				return;
			}
			var cntCd = Value.substr(0,2).toUpperCase();
			sheetObj.CellValue2(Row, prefix2 + "drp_off_chg_trf_cnt_cd") = cntCd;
			var param = "f_cmd=" + SEARCH03 + "&s_cnt_cd=" + cntCd.toUpperCase() + "&s_rtn_loc_cd=" + Value;
			var sXml = sheetObjects[1].GetSaveXml("EES_DOD_0005GS.do", param);
			
			var conti = ComGetEtcData(sXml, "conti");
			var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
			
			if(result == "S"){
				if(conti == null || conti == undefined || conti == "") {				
					ComShowMessage("There's no input another continent.");
					sheetObj.CellValue2(Row, Col) = "";
	 				sheetObj.SelectCell(Row, Col);
	 				break;
				}
			}
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH08, "RTN-Location");
			setDivCombo(sheetObj,Row, prefix2);
			break;
		case prefix2 + "drp_off_chg_trf_cnt_cd":
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH11, "Country Code");
			break;
		case prefix2 + "del_cd":
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH08, "Location Code");
			break;
		case prefix2 + "cntr_rtn_loc_cd":
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH08, "Location Code");
			break;
		case prefix2 + "cntr_rtn_yd_sfx_cd":
			Value = Value.trim();
			if(Value == "" || Value == "ALL"){
				return false;
			}
			var rtnLoc = sheetObj.CellValue( Row, Col -1 );
			
			Value = rtnLoc != "" ? rtnLoc.trim() + Value : "";
			chkValidateSheets(sheetObj, Row, Col, Value, SEARCH09, "Yard Code");
			break;
		case prefix2 + "spcl_cust_nm":
			sheetObj.CellValue2(Row, prefix2 + "spcl_cust_cnt_seq") = Value
			break;
		}	
	
	}

	/**
     * t1sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t1sheet1_OnClick(sheetObj, Row, Col, Val) {
     	with(sheetObj) {
     		switch(Col){
     			case SaveNameCol(prefix1 + "cntr_rtn_yd_sfx_cd"):
     				setDivCombo(sheetObj,Row, prefix1);    			
     				break;
     			case SaveNameCol(prefix1 + "del_chk"):     				
     				break;
     			case SaveNameCol(prefix1 + "atch_file_lnk_cnt"):
     				if(sheetObj.CellValue(Row, prefix1 + "drp_off_chg_trf_seq") == ''){
     					return; // 생성된 tariff가 없으면 파일첨부할 수 없음.
     				}
     			
    				dodFileUploadPopUp(sheetObj, Row, "TRF", "Y", prefix1);
    				break;
     		}
//     		if(CellValue(Row, prefix1 + "drp_off_chg_trf_cfm_flg") == "C"){
//     			RowEditable(Row) = false;
//     		}
     	}
    }
    
    /**
     * t2sheet1 OnClick Event 처리
     * param : sheetObj ==> 시트오브젝트, 변경한 Row ==> Row, 변경한 Col ==> Col
     * 
     */
    function t2sheet1_OnClick(sheetObj, Row, Col, Val) {
     	with(sheetObj) {
     		switch(Col){
     			case SaveNameCol(prefix2 + "cntr_rtn_yd_sfx_cd"):
     				setDivCombo(sheetObj,Row, prefix2);    			
     				break;
     			case SaveNameCol(prefix2 + "del_chk"):     				
     				break;
     			case SaveNameCol(prefix2 + "spcl_cust_nm"):
     				if(sheetObj.CellEditable(Row, prefix2 + "spcl_cust_nm")){
         				var param2 = "f_cmd=" + SEARCH04 + "&sc_no=" + sheetObj.CellValue(Row, prefix2 + "sc_no") + "&rfa_no=" + sheetObj.CellValue(Row, prefix2 + "rfa_no");
         				var sXml = sheetObjects[2].GetSaveXml("EES_DOD_0005GS.do", param2);
         				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
         				if(result == "S"){
         					sheetObj.CellComboItem (Row, prefix2 + "spcl_cust_nm", ComGetEtcData(sXml, "name"), ComGetEtcData(sXml, "code"), 0);
         					sheetObj.CellValue2(Row, prefix2 + "cust_nm") = ComGetEtcData(sXml, "cust_nm");
         				}
     				}
     				break;
     				
     			case SaveNameCol(prefix2 + "atch_file_lnk_cnt"):
     				if(sheetObj.CellValue(Row, prefix2 + "drp_off_chg_trf_seq") == ''){
     					return; // 생성된 tariff가 없으면 파일첨부할 수 없음.
     				}
     			
    				dodFileUploadPopUp(sheetObj, Row, "TRF", "Y", prefix2);
    				break;
     		}
//     		if(CellValue(Row, prefix1 + "drp_off_chg_trf_cfm_flg") == "C"){
//     			RowEditable(Row) = false;
//     		}
     	}
    }

	/** 
	 * Div 시트콤보 설정
	 * Component,Repair 시트콤보 변경시 Div 조회
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 */
	function setDivCombo(sheetObj,Row, prefix) {
		var locCd		= sheetObj.CellValue(Row, prefix + "cntr_rtn_loc_cd");							
		if(locCd != "") {				
			sheetObj.WaitImageVisible  = false;					
			var formObj = document.form;			 	 	       
			var yardList = getYardList(sheetObj, formObj, locCd);
			yardList = "ALL|" + yardList;
			sheetObj.CellComboItem (Row, prefix + "cntr_rtn_yd_sfx_cd", yardList, yardList);
			sheetObj.WaitImageVisible  = true;					
		}
	}
	
	/**
     * Sheet1 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     * 
     */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj   = document.form;
		
		var tabObj    = tabObjects[0];
		var selTabIdx = tabObj.SelectedIndex;
	}
	
    /**
     * Sheet2 OnSearchEnd Event 처리
     * param : sheetObj ==> 시트오브젝트, ErrMsg ==> 결과 Message
     */
 	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		var tabObj    = tabObjects[0];
		var selTabIdx = tabObj.SelectedIndex;
		
 		with (sheetObj) {
			if(RowCount > 0) {
				
			} else {
				
			}
 		}
 	}
 
	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {	
		sheetObjects[sheetCnt++] = sheet_obj;	
	}

	/**
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {	
		comboObjects[comboCnt++] = combo_obj;	
	}

	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++] = tab_obj;
	}
	 
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
			case 1:
				with (tabObj) {
					var cnt = 0;
					InsertTab(cnt++, "Region/Country", -1);
					InsertTab(cnt++, "Special Customer", -1);
				}
				break;
		}
	}
	
	// IE7 support for querySelectorAll. Supports multiple / grouped selectors and the attribute selector with a "for" attribute. http://www.codecouch.com/
	(function(d, s) {
		d=document, s=d.createStyleSheet();
		d.querySelectorAll = function(r, c, i, j, a) {
			a=d.all, c=[], r = r.replace(/\[for\b/gi, '[htmlFor').split(',');
			for (i=r.length; i--;) {
				s.addRule(r[i], 'k:v');
				for (j=a.length; j--;) a[j].currentStyle.k && c.push(a[j]);
				s.removeRule(0);
			}
			return c;
		}
	})()
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj, nItem) {		
		ComResetAll();
		comboObjects[0].RemoveAll();				
		//초기 포커스 위치
		ComSetFocus(document.form.s_cnt_cd);	
		if(nItem == 0){
			document.form.s_trf_div_cd.value = "G";
		} else {
			document.form.s_trf_div_cd.value = "S";
		}
		document.form.s_yd_sfx_cd.InsertItem(0 , 'ALL','');
		document.form.s_yd_sfx_cd.Index = 0;
		document.form.s_yd_sfx_cd.UserCode = true;
		
		
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		// --------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
		// ------------------------------------------------------//
		beforetab = nItem;
		
		var styleName = "visible";
		document.form.s_trf_div_cd.value = "S";
		if(nItem == 0){
			styleName = "hidden";
			document.form.s_trf_div_cd.value = "G";
		}		
		var spcLayers = document.querySelectorAll(".spcLayer"),
	    i = 0,
	    l = spcLayers.length;
		for (i; i < l; i++) {
			spcLayers[i].style.visibility = styleName;
		}
		
	}

	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {	
		//IBMultiCombo초기화
		for ( var k = 0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		
		//IBTab 초기화
		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
		//IBSheet 초기화
		for (i = 0; i < sheetObjects.length; i++) {	
			ComConfigSheet(sheetObjects[i]);	
			initSheet(sheetObjects[i], i + 1);	
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		//Axon Event Listener 등록
		initControl();		
		//초기 포커스 위치
		ComSetFocus(document.form.vsl_cd);
		ComBtnDisable("btn_expire");
		ComBtnDisable("btn_expire2");
	}
	 
	/**
	 * IBCOMBO 초기화. <br>
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "s_rtn_loc_cd":
				with (comboObj) {
					BackColor       = "#CCFFFF";
					DropHeight      = 230;
					MultiSelect     = false;
					MaxSelect       = 1;
					UseAutoComplete = true;					
				}
				break;
		}
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 **/
	function initControl() {
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 			 
    	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm  ("keyup",    'obj_keyup',    form);
		axon_event.addListenerForm  ('change',   'obj_change',   form);
		axon_event.addListenerFormat('blur',     'obj_blur',     form);	
		axon_event.addListener      ('keydown',  'ComKeyEnter', 'form');
		
		var sheetObj = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		sheetObj.WaitImageVisible  = false;					
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH;
		var currXml = sheetObj.GetSearchXml("COM_ENS_N13GS.do", FormQueryString(formObj));
		sheetObj.WaitImageVisible  = true;
		var rtnArr = ComXml2ComboString(currXml, "curr_cd", "curr_cd");
		sheetObj.InitDataCombo(0, prefix1 +"curr_cd", rtnArr[0], rtnArr[1]);
		sheetObj2.InitDataCombo(0, prefix2 +"curr_cd", rtnArr[0], rtnArr[1]);
	}

	/**
	 * 필수 입력후 자동 다음 포커스 OnKeyUp 이벤트 처리 <br>
	 **/
	function obj_keyup() {
		 if(event.keyCode != 9) obj_nextfocus(event.srcElement);
	}

	//인자로 받은 HTML태그(Object)의 다음 HTML태그(Object)로 포커스를 이동
	function obj_nextfocus(obj) {
		var formObj = document.form;
		
		var objMaxLength = obj.getAttribute("maxlength");
		var objValue     = obj.getAttribute("value");
		
		if (ComChkLen(objValue, objMaxLength) == 2) {			
			ComSetNextFocus(obj);		
		} 
	}

	/**
	 * 업무 자바스크립트 OnFocusOut 이벤트 처리 <br>
	 **/
	function obj_blur() {
		var formObj  = document.form;
		
		with (event.srcElement) {	
			switch (name) {	
				case "":
							
					
					break;
					
				default:
					break;
			}
		}
	}
		
	function obj_deactivate(){
		var f = document.form.s_frm_eff_dt;
		var t = document.form.s_to_eff_dt;
		sVal1 = f.value.replace(/\/|\-|\./g, "");
		sVal2 = t.value.replace(/\/|\-|\./g, "");		
		switch (event.srcElement.dataformat) {
		case "ymd":
			if (sVal1.length > 0 && !ComIsDate(sVal1) && event.srcElement.name == 's_frm_eff_dt') {
				event.srcElement.value = "";
				ComShowCodeMessage("DOD00019", "YYYYMMDD");
				event.srcElement.focus();
				event.srcElement.select();
				enterSwitch = false;
				return false;
			}			
			if (sVal2.length > 0 && !ComIsDate(sVal2) && event.srcElement.name == 's_to_eff_dt') {				
				event.srcElement.value = "";
				ComShowCodeMessage("DOD00019", "YYYYMMDD");
				event.srcElement.focus();
				event.srcElement.select();
				enterSwitch = false;
				return false;
			}
			break;
		}
	}
	
	/**
	 * 조회조건 입력시 Validation <br>
	 **/
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
			case "engup":
				switch (event.srcElement.name) {
					case "s_rtn_loc_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('uppernum');
						break;					
					case "s_cnt_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('uppernum');
						break;
					case "s_cust_cd":
						//영문대문자 입력하기
						ComKeyOnlyAlphabet('uppernum');
						break;
				}
				break;
			case "ymd":
				var f = event.srcElement.value;
				if(f.value != null){
					sVal1 = f.value.replace(/\/|\-|\./g, "");		
					if(sVal1.length > 0 && !ComIsNumber(sVal1)){
						event.srcElement.focus();
						event.srcElement.select();
						enterSwitch = false;
						return false;
					}
				}
				
				break;
			
			default:
				//공통기준:영문, 숫자만을 인식
				ComKeyOnlyAlphabet("num");
				break;
		}
	}

	/**
	 * Object  데이터 수정시. <br>
	 **/
	function obj_change() {
		var formObj  = document.form;		
		var obj = event.srcElement;
		with (event.srcElement) {
			switch (name) {				
				case "s_rtn_loc_cd":
					if(obj.value.trim() == ""){
						return;
					}
					var comObj = document.form.s_yd_sfx_cd;					
					var formObj = document.form;
					var lvobj = doSepRemove(obj.value.toUpperCase(), " ");
					
					var param = "f_cmd=" + SEARCH08 + "&s_value=" + obj.value;
					var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
					var count = ComGetEtcData(sXml, "count");
					var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if(result == "S"){
						if(parseInt(count) == 0) {
							ComShowMessage(ComGetMsg("COM12114", "RTN-Location"));
							comObj.RemoveAll();
							obj.value = "";
							obj.focus();							
						} else {							
							obj.value = lvobj;
							if( lvobj == "" ) {
								obj.value = "";
								comObj.RemoveAll();
								return false;
							}
							if( !doengnumcheck(lvobj) ) {
								obj.value = "";
								comObj.RemoveAll();
								obj.focus();
								return false;
							}			
							formObj.TRSP_SO_EQ_KIND.value = "";		
							lvViaNode = getYardCombo(comObj, sheetObjects[0], formObj, lvobj); 
							comObj.focus();			
						}
					}
					
							
					break;
				case "s_cnt_cd":
					if(obj.value.trim() == ""){
						return;
					}
					var param = "f_cmd=" + SEARCH11 + "&s_value=" + obj.value;
					var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
					var count = ComGetEtcData(sXml, "count");
					var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if(result == "S"){
						if(parseInt(count) == 0) {
							obj.value = "";
							obj.focus();
							ComShowMessage(ComGetMsg("COM12114", "Country Code"));
						}
					}
					break;
				case "s_cust_cd":
					fncCustSeqBlur(obj);
					if(obj.value.trim() == ""){
						return;
					}
					
					var param = "f_cmd="+SEARCH+"&cust_cd="+ obj.value.substr(0,2).toUpperCase() +"&cust="+ obj.value.substr(2);
					var sXml = sheetObjects[1].GetSearchXml("COM_ENS_041GS.do", param);
					var rtnArr = ComXml2ComboString(sXml, "cust_cd", "cust_nm");
					if(rtnArr != null && rtnArr.length > 1){
						obj.value = rtnArr[0];
						formObj.s_cust_nm.value = rtnArr[1];
					} else {
						ComShowMessage(ComGetMsg("COM12114", "Customer Code"));
						obj.value = "";
						formObj.s_cust_nm.value = "";
						obj.focus();
					}
			
					break;
					
			}
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
	
		switch (sheetNo) {
			case 1: // t1sheet1 init
				with (sheetObj) {
					//높이 설정
					style.height = GetSheetHeight(18);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 1, 100);
	
					var HeadTitle1 = "|SEQ||seq|Effective|Expire|exp_flg|Country|BKG-POD|RTN-Location|Yard|Origin|TP/SZ|CUR|Amount|Exemption|Request ID|Request DT|CNFM ID|CNFM DT|Status|File|Remark|div_cd|chg_cnt|";
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					//InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix1 + "ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 		30, 	daCenter, 	false, 	prefix1 + "SEQ", 		false, "", dfNone, 		0, false, false);				
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	false, 	prefix1 + "del_chk", 			false, 	"", dfNone, 	0, true,  true, 1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "drp_off_chg_trf_seq");
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix1 + "drp_off_chg_trf_eff_dt", 			false, "", dfDateYmd, 		0, true, true);	
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix1 + "drp_off_chg_trf_exp_dt", 			false, "", dfDateYmd, 		0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix1 + "drp_off_chg_trf_exp_flg", 		false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 			65, 	daCenter, 	false, 	prefix1 + "drp_off_chg_trf_cnt_cd", 			false, "", dfNone, 		0, true, true, 2);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	false, 	prefix1 + "del_cd", 			false, "", dfNone, 		0, true, true, 5);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix1 + "cntr_rtn_loc_cd", 			false, "", dfNone, 		0, true, true, 5);
					InitDataProperty(0, cnt++, dtComboEdit, 	65, 	daCenter, 	false, 	prefix1 + "cntr_rtn_yd_sfx_cd", 		false, "", dfNone, 		0, true, true, 2);
					InitDataProperty(0, cnt++, dtCombo, 		65, 	daCenter, 	false, 	prefix1 + "pol_conti_cd", 	false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	false, 	prefix1 + "cntr_tpsz_cd", 		false, "", dfNone, 		0, true, true, 2);
					InitDataProperty(0, cnt++, dtCombo, 		50, 	daCenter, 	false, 	prefix1 + "curr_cd", 			false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			100, 	daRight, 	false, 	prefix1 + "drp_off_chg_trf_amt",				false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtCheckBox, 		100, 	daCenter, 	false, 	prefix1 + "drp_off_chg_trf_expt_flg", 		false, "", dfNone, 		0, true, true, -1, false, true, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix1 + "upd_usr_id", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, 	daRight, 	false, 	prefix1 + "upd_dt", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix1 + "drp_off_chg_trf_cfm_usr_id", 		false, "", dfNone, 		0, false, false);										
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix1 + "drp_off_chg_trf_cfm_dt", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	false, 	prefix1 + "drp_off_chg_trf_cfm_flg", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit,     60,	daCenter,  	false,	prefix1 + "atch_file_lnk_cnt", 	false,          "",      dfInteger,  0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 			300, 	daLeft,	false, 	prefix1 + "drp_off_chg_trf_rmk", 		false, "", dfNone, 		0, true, true, 1000);
					InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter,	false, 	prefix1 + "drp_off_chg_trf_div_cd", 		false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter,	false, 	prefix1 + "chg_cnt", 		false, "", dfNone, 		0, true, true);
					
					InitDataProperty(0, cnt++, dtHidden,        40,	daCenter,  	false,	prefix1 + "atch_file_lnk_id",	 	false,          "",      dfNone,     0,     false,      false);
					
					ShowButtonImage = 2;
					
//					HighLightAfterSort = 1;// 소트 이후 기존에 선택하고 있던 데이터를 찾아감.
					InitViewFormat(0, prefix1 +"drp_off_chg_trf_eff_dt", "yyyy-mm-dd");
					InitViewFormat(0, prefix1 +"drp_off_chg_trf_exp_dt", "yyyy-mm-dd");
					InitDataCombo(0, prefix1 +"pol_conti_cd", " |Asia|America|Europe|Africa", " |A|M|E|F");
					
					InitDataValid(0, prefix1 + "drp_off_chg_trf_cnt_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix1 + "del_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix1 + "cntr_rtn_loc_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix1 + "cntr_rtn_yd_sfx_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix1 + "cntr_tpsz_cd", vtEngUpOther, "0123456789");
				}
				break;
	
			case 2: // sheet2 init
				with (sheetObj) {
					//높이 설정
					style.height = GetSheetHeight(18);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 1, 100);
	
					var HeadTitle1 = "|SEQ||seq|Effective|Expire|exp_flg|Country|BKG-POD|RTN-Location|Yard|Origin|TP/SZ|RFA No.|S/C No.|Customer|A/Customer Code|Customer Name|Exemption|CUR|Special Tariff|Request ID|Request DT|CNFM ID|CNFM DT|Status|File|Remark|div_cd|chg_cnt|";
					var headCount = ComCountHeadTitle(HeadTitle1);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					//InitHeadRow(1, HeadTitle2, true);
					
					//데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, 	daCenter, 	false, 	prefix2 + "ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 		30, 	daCenter, 	false, 	prefix2 + "SEQ", 		false, "", dfNone, 		0, false, false);				
					InitDataProperty(0, cnt++, dtCheckBox, 		30, 	daCenter, 	false, 	prefix2 + "del_chk", 			false, 	"", dfNone, 	0, true,  true, 1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "drp_off_chg_trf_seq");
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix2 + "drp_off_chg_trf_eff_dt", 			false, "", dfDateYmd, 		0, true, true);	
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix2 + "drp_off_chg_trf_exp_dt", 			false, "", dfDateYmd, 		0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		50, 	daCenter, 	false, 	prefix2 + "drp_off_chg_trf_exp_flg", 		false, "", dfNone, 		0, false, false, -1, false, false, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		65, 	daCenter, 	false, 	prefix2 + "drp_off_chg_trf_cnt_cd", 			false, "", dfNone, 		0, true, true, 2);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	false, 	prefix2 + "del_cd", 			false, "", dfNone, 		0, true, true, 5);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix2 + "cntr_rtn_loc_cd", 			false, "", dfNone, 		0, true, true, 5);
					InitDataProperty(0, cnt++, dtComboEdit, 	65, 	daCenter, 	false, 	prefix2 + "cntr_rtn_yd_sfx_cd", 		false, "", dfNone, 		0, true, true, 2);
					InitDataProperty(0, cnt++, dtCombo, 		65, 	daCenter, 	false, 	prefix2 + "pol_conti_cd", 	false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, 	false, 	prefix2 + "cntr_tpsz_cd", 		false, "", dfNone, 		0, true, true, 2);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix2 + "rfa_no", 			false, "", dfNone, 		0, true, true, 11);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix2 + "sc_no", 			false, "", dfNone, 		0, true, true, 20);
					//InitDataProperty(0, cnt++, dtCombo, 		50, 	daCenter, 	false, 	prefix2 + "curr_cd", 			false, "", dfNone, 		0, true, true);
					//InitDataProperty(0, cnt++, dtData, 			100, 	daRight, 	false, 	prefix2 + "drp_off_chg_trf_amt",				false, "", dfFloat, 1, true, true);
					
					InitDataProperty(0, cnt++, dtData, 			180, 	daLeft, 	false, 	prefix2 + "cust_nm", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 		180, 	daLeft, 	false, 	prefix2 + "spcl_cust_nm", 			false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter, 	false, 	prefix2 + "spcl_cust_cnt_seq", 			false, "", dfNone, 		0, true, true, 8);
					InitDataProperty(0, cnt++, dtCheckBox, 		100, 	daCenter, 	false, 	prefix2 + "drp_off_chg_trf_expt_flg", 		false, "", dfNone, 		0, true, true, -1, false, true, false, false);
					InitDataProperty(0, cnt++, dtCombo, 		50, 	daCenter, 	false, 	prefix2 + "curr_cd", 			false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtData, 			100, 	daRight, 	false, 	prefix2 + "drp_off_chg_trf_amt",				false, "", dfFloat, 2, true, true);
					
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix2 + "upd_usr_id", 			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, 	daRight, 	false, 	prefix2 + "upd_dt", 		false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix2 + "drp_off_chg_trf_cfm_usr_id", 		false, "", dfNone, 		0, false, false);										
					InitDataProperty(0, cnt++, dtData, 			100, 	daCenter, 	false, 	prefix2 + "drp_off_chg_trf_cfm_dt", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, 	false, 	prefix2 + "drp_off_chg_trf_cfm_flg", 		false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit,     60,	daCenter,  	false,	prefix2 + "atch_file_lnk_cnt", 	false,          "",      dfInteger,  0,     false,      false);
					InitDataProperty(0, cnt++, dtData, 			300, 	daLeft,	false, 	prefix2 + "drp_off_chg_trf_rmk", 		false, "", dfNone, 		0, true, true, 1000);
					InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter,	false, 	prefix2 + "drp_off_chg_trf_div_cd", 		false, "", dfNone, 		0, true, true);
					InitDataProperty(0, cnt++, dtHidden,		100, 	daCenter,	false, 	prefix2 + "chg_cnt", 		false, "", dfNone, 		0, true, true);
					
					InitDataProperty(0, cnt++, dtHidden,        40,	daCenter,  	false,	prefix1 + "atch_file_lnk_id",	 	false,          "",      dfNone,     0,     false,      false);
					
					ShowButtonImage = 2;
					
//					HighLightAfterSort = 1;// 소트 이후 기존에 선택하고 있던 데이터를 찾아감.
					InitViewFormat(0, prefix2 +"drp_off_chg_trf_eff_dt", "yyyy-mm-dd");
					InitViewFormat(0, prefix2 +"drp_off_chg_trf_exp_dt", "yyyy-mm-dd");
					InitDataCombo(0, prefix2 +"pol_conti_cd", " |Asia|America|Europe|Africa", " |A|M|E|F");
					
					InitDataValid(0, prefix2 + "drp_off_chg_trf_cnt_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix2 + "del_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix2 + "cntr_rtn_loc_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix2 + "cntr_rtn_yd_sfx_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix2 + "cntr_tpsz_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix2 + "spcl_cust_cnt_seq", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix2 + "rfa_no", vtEngUpOther, "0123456789");
					InitDataValid(0, prefix2 + "sc_no", vtEngUpOther, "0123456789");
				}
				break;
		}
	}
	
 	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */ 
 	function t1sheet1_OnValidation(sheetObj, Row, Col, Value){
 		if(document.form.f_cmd.value == SEARCH01 || document.form.f_cmd.value == SEARCH02 ){
 			return false;
 		}
 		
 		with(sheetObj) {
			var sName = ColSaveName(Col);
	 		switch(sName.replace(prefix1, "")){
		 		case "cntr_tpsz_cd":	 			
		 		case "drp_off_chg_trf_cnt_cd":
		 		case "cntr_rtn_yd_sfx_cd":
		 		case "pol_conti_cd":
		 		//case "del_cd":
		 		case "cntr_rtn_loc_cd":
			 			if(Value == "" && CellValue(Row, 0) != "D"){			 				
			 				ComShowCodeMessage('DOD00011');
			 				ValidateFail = true; 
			 				SelectCell(Row, Col);			        		
			 			}
			 			break;
		 		case "drp_off_chg_trf_expt_flg":
		 			if(Value == "0" && Number(CellValue(Row, Col - 1)) <= 0 && CellValue(Row, 0) != "D"){
		 				ComShowCodeMessage('DOD00020');
		 				ValidateFail = true; 
		 				SelectCell(Row, Col - 1);
		 			}
		 			break;
		 		case "drp_off_chg_trf_seq":
		 			var seq = sheetObj.EtcData('DUP_SEQ');
	 				if(seq != undefined && seq != 'null' && seq.length > 0 && CellValue(Row, 0) != "D"){
	 					var dupRow = -1;
	 					var dupSeq = -1;
	 					for(var i=1;i<=sheetObj.RowCount; i++ ){  						
	 						if( seq == sheetObj.CellValue(i, prefix1 + "drp_off_chg_trf_seq")){
	 							dupSeq = seq;
	 							dupRow = i;						
	 							break;
	 						}
	 					}
	 					if(dupRow != -1){
	 						for(var i=1;i<=sheetObj.RowCount; i++ ){
		 						if( "" == sheetObj.CellValue(i, prefix1 + "drp_off_chg_trf_seq") && 
		 							(sheetObj.CellValue(i, prefix1 + "drp_off_chg_trf_amt") == sheetObj.CellValue(dupRow, prefix1 + "drp_off_chg_trf_amt")) ){
		 							ComShowMessage("Duplication occurred.");
									sheetObj.ValidateFail = true;
									sheetObj.SelectCell(i, prefix1 + "drp_off_chg_trf_amt");
		 						}
		 					}
	 					}							 
//	 					ComShowMessage("Duplication occurred.");
//	 					sheetObj.ValidateFail = true; 
//						sheetObj.SelectCell(Row, prefix1 + "drp_off_chg_trf_amt");	
	 				}
	 				break;
	 		}    		  			
 		}
 	} 
 	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */ 
 	function t2sheet1_OnValidation(sheetObj, Row, Col, Value){
 		if(document.form.f_cmd.value == SEARCH01 || document.form.f_cmd.value == SEARCH02 ){
 			return false;
 		}
 		with(sheetObj) { 			
 			var sName      = ColSaveName(Col);
	 		switch(sName.replace(prefix2, "")){ 		
		 		case "cntr_tpsz_cd":	 			
		 		case "drp_off_chg_trf_cnt_cd":
		 		case "cntr_rtn_yd_sfx_cd":
		 		case "pol_conti_cd":
		 		//case "del_cd":
		 		case "cntr_rtn_loc_cd":
			 			if(Value == "" && Value != "ALL" && CellValue(Row, 0) != "D"){			 				
			 				ComShowCodeMessage('DOD00011');
			 				ValidateFail = true;
			        		SelectCell(Row, Col);
			 			}
			 			break;
		 		case "rfa_no":
		 			if(Value == "" && CellValue(Row, prefix2 + "sc_no") == "" && CellValue(Row, 0) != "D"){
		 				ComShowCodeMessage('DOD00010');
		 				ValidateFail = true;
		        		SelectCell(Row, Col)
		 			}	 			
		 			break;		 		 		
	 			case "drp_off_chg_trf_expt_flg":
		 			if(Value == "0" && Number(CellValue(Row, Col + 2)) <= 0 && CellValue(Row, 0) != "D"){
		 				ComShowCodeMessage('DOD00020');
		 				ValidateFail = true;
		 				SelectCell(Row, Col + 2);	 				
		 				
		 			}
		 			break;
	 			case "drp_off_chg_trf_seq":
		 			var seq = sheetObj.EtcData('DUP_SEQ');
	 				if(seq != undefined && seq != 'null' && seq.length > 0 && CellValue(Row, 0) != "D"){
	 					var dupRow = -1;
	 					var dupSeq = -1;
	 					for(var i=1;i<=sheetObj.RowCount; i++ ){  						
	 						if( seq == sheetObj.CellValue(i, prefix2 + "drp_off_chg_trf_seq")){
	 							dupSeq = seq;
	 							dupRow = i;						
	 							break;
	 						}
	 					}
	 					if(dupRow != -1){
	 						for(var i=1;i<=sheetObj.RowCount; i++ ){
		 						if( "" == sheetObj.CellValue(i, prefix2 + "drp_off_chg_trf_seq") && 
		 							(sheetObj.CellValue(i, prefix2 + "drp_off_chg_trf_amt") == sheetObj.CellValue(dupRow, prefix2 + "drp_off_chg_trf_amt")) ){
		 							ComShowMessage("Duplication occurred.");
									sheetObj.ValidateFail = true;
									sheetObj.SelectCell(i, prefix2 + "drp_off_chg_trf_amt");
		 						}
		 					}
	 					}
	 				}
	 				break;
	 		}   
 		}
 	} 
	 	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, fCmd, prefix) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBINSERT:
				var Row = sheetObj.DataInsert(-1);		      
				sheetObj.CellValue(Row, prefix + "drp_off_chg_trf_eff_dt") = ComGetDateAdd(null, "D", +1);
				sheetObj.CellValue(Row, prefix + "drp_off_chg_trf_exp_dt") = "9999-12-31";
				sheetObj.CellValue(Row, prefix + "drp_off_chg_trf_div_cd") = (prefix.indexOf("1")>-1?"G":"S");				
				break;
			case IBSEARCH: // Retrieve
				if (validateForm(sheetObj, formObj, sAction)) {
					if(prefix == "0"){
						prefix = prefix1;
					} else {
						prefix = prefix2;
					}
					formObj.f_cmd.value = fCmd;					
					var sXml = sheetObj.GetSearchXml("EES_DOD_0005GS.do", FormQueryString(formObj) +"&"+ComGetPrefixParam(prefix));
					var arrXml = sXml.split("|$$|");
					
					var arrCt = arrXml.length;
					if (arrXml != null && arrCt > 0) {						
						sheetObj.LoadSearchXml(arrXml[0]);						
					}
				}
	
				break;	
			case IBDELETE :
				ComRowHideDelete(sheetObj, prefix + "del_chk");
				break;
			case IBSEARCH_ASYNC01:
				formObj.f_cmd.value = fCmd;
  				sheetObj.DoSave("EES_DOD_0005GS.do", FormQueryString(formObj) +"&"+ComGetPrefixParam(prefix));
  				break;
			case IBSEARCH_ASYNC02:
				break;
			case IBSAVE: // Save				
				formObj.f_cmd.value = fCmd;
  				sheetObj.DoSave("EES_DOD_0005GS.do", FormQueryString(formObj) +"&"+ComGetPrefixParam(prefix));
  				
  				break;
			case IBDOWNEXCEL:
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	
    /** 
    * sheet위를 마우스 포인터가 이동할경우 자동 호출됨 
    * <br><b>Example :</b>
    * <pre>
    * </pre>
    * @param {object} sheetObj 필수, sheet Object
    * @param {int} shift 필수, Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
    * @param {int} x 필수, X 좌표
    * @param {int} y 필수, Y 좌표
    * @return 없음
    */   
 	function t1sheet1_OnMouseMove(sheetObj, button, shift, x, y){
 		with(sheetObj){

 			if(ColSaveName(MouseCol) == prefix1 + "atch_file_lnk_cnt") {
 				sheetObj.MousePointer = "Hand";
 			} else {
 				MousePointer = "Default";
 			} 	
 		}
 	}
 	
 	function t2sheet1_OnMouseMove(sheetObj, button, shift, x, y){
 		with(sheetObj){

 			if(ColSaveName(MouseCol) == prefix2 + "atch_file_lnk_cnt") {
 				sheetObj.MousePointer = "Hand";
 			} else {
 				MousePointer = "Default";
 			} 	
 		}
 	}
 	
	/*******************************************************************************
	 * Validation 시작 *
	 ******************************************************************************/
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
	
		case IBSEARCH:
			//폼 개체 안에 모든 컨트롤의 Validation을 확인
			if (!ComChkValid(formObj, true, false, false)) return false;
	    	
			break;
		case IBSAVE:
			
			break;
		}
	
		return true;
	}

/* 개발자 작업 끝 */