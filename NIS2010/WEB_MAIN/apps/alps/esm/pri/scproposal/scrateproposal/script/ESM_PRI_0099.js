﻿﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0099.js
*@FileTitle : Rate Creation - Excel Import(Horizontal)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.07.31 박성수
* 1.0 Creation
* 2010.11.10 송호진  [CHM-201006982-01] SC의 Excel load기능 사용시 actual customer data 처리 방법 수정 요청 관련 수정
* 2013.03.11 전윤주 [CHM-201323464] FRC Surcharge 추가
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0099() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업 */

	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var bIsReqUsr = false;
    var bIsAproUsr = false;
    var timerID = "";
    var jobKey = "";
    
    var isOViaMandatory = false;
    var isDViaMandatory = false;
    var isDirCallVisible = false;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	
		var sheetObject1 = sheetObjects[0];
	
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
	
			switch (srcName) {
			
			case "btn_template":
				downform.submit();
				break;
			
			case "btn_openfile":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
				break;
	
			case "btn_check":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObject1, document.form, IBSAVE);
				break;
	
			case "btn_close":
				window.close();
				break;
	
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/**
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj 필수 IBSheet Object
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function setSheetObject(sheet_obj) {
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage();
	 * </pre>
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			sheetObjects[i].WaitImageVisible = false;
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		bIsReqUsr = document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
		bIsAproUsr = document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;
		
		toggleButtons("INIT");
		
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20);
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,1);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
	
		switch (sheetNo) {
			case 1: // sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 440;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
		
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
	                var HeadTitle1 = "|CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|D.Call|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|FRC(USD)|FRC(USD)|FRC(USD)|FRC(USD)|FRC(USD)|FRC(USD)";
	                var HeadTitle2 = "|CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|Y/N|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC";
	                var headCount = ComCountHeadTitle(HeadTitle2);
	
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	    
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false, false)
	        
	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, false);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
	                InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "cmdt_dp_seq",              false, "", dfNullInteger, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData,  60, daCenter,false, "prc_cmdt_def_cd",          false, "", dfNone, 0, true, true, 6);
	                InitDataProperty(0, cnt++, dtData, 130, daLeft,  false, "prc_cmdt_def_nm",          false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData,  70, daCenter,false, "cust_seq",                 false, "", dfNone, 0, true, true, 8);
	                InitDataProperty(0, cnt++, dtData, 130, daLeft,  false, "cust_lgl_eng_nm",          false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData,  50, daCenter, true, "rout_dp_seq",              false, "", dfNullInteger, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData,  60, daCenter,false, "org_rout_pnt_loc_def_cd",  false, "", dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData, 130, daLeft,  false, "org_rout_pnt_loc_def_nm",  false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtCombo, 80, daCenter,false, "org_rcv_de_term_nm",       false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtCombo, 90, daCenter,false, "org_prc_trsp_mod_nm",      false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData,  60, daCenter,false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData,  60, daCenter,false, "dest_rout_via_port_def_cd",false, "", dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData,  60, daCenter,false, "dest_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData, 130, daLeft,  false, "dest_rout_pnt_loc_def_nm", false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtCombo, 80, daCenter,false, "dest_rcv_de_term_nm",      false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtCombo, 90, daCenter,false, "dest_prc_trsp_mod_nm",     false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtCombo, 50, daCenter,false, "dir_call_flg",             false, "", dfNone, 0, true, true);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry20",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry40hc",             false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_dry45",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rf40hc",              false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "rate_rd40hc",              false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry20",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry40",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry40hc",              false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_dry45",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_rf40hc",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "buc_rd40hc",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry20",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry40",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry40hc",              false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_dry45",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_rf40hc",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "ifc_rd40hc",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry20",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry40",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry40hc",              false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_dry45",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_rf40hc",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "psc_rd40hc",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "frc_dry20",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "frc_dry40",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "frc_dry40hc",              false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "frc_dry45",                false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "frc_rf40hc",               false, "", dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 100, daRight, false, "frc_rd40hc",               false, "", dfNullFloat, 2, true, true, 9);
	
	                ShowButtonImage = 2;
	                ToolTipOption = "balloon:true;width:1000;icon:3;title:Load Excel";
	                InitDataCombo(0, "dir_call_flg", "|Y|N", "|Y|N");
	                InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther, "0123456789");
	                InitDataValid(0, "cust_seq", vtEngUpOther, "0123456789");
	                InitDataValid(0, "org_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
	                InitDataValid(0, "org_rout_via_port_def_cd", vtEngUpOther, "0123456789");
	                InitDataValid(0, "dest_rout_via_port_def_cd", vtEngUpOther, "0123456789");
	                InitDataValid(0, "dest_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
	                
	                /*
	                if (document.form.gen_spcl_rt_tp_cd.value == "G") {
	                	ColHidden("cust_lgl_eng_nm") = true;
	                	ColWidth("prc_cmdt_def_nm") =  160;
	                	ColWidth("cnote_ctnt") =  150;
	                }
	                */
				}
				break;

	        case 2:  // hidden
		        with (sheetObj) {
		            // 높이 설정
	//              style.height = 182;
		            // 전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            // 전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		            // 전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            var HeadTitle = "status";
		            var headCount = ComCountHeadTitle(HeadTitle);
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 1, 1, 6, 100);
		
		            // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, true, true, false,false)
		
		            // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            // 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHiddenStatus,30,  daCenter,   false,  "ibflag");
		
		            Visible = false;
		        }
		        break;
		}
	}
	
	function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
		if (!isClear && KeyCode == 9) {
			while (true) {
				Col++;
				if (Col > sheetObj.LastCol) {
					Row++;
					Col = 1;
				}
				if (Row > sheetObj.LastRow) {
					Row = sheetObj.HeaderRows;
				}
				if (sheetObj.CellBackColor(Row, Col) == sheetObj.RgbColor(255,0,0)) {
					sheetObj.SelectCell(Row, Col, false);
					break;
				}
			}
		}
	}

	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "prc_cmdt_def_cd") {
			if (Value.length == 6) {
				formObj.f_cmd.value = SEARCH08;
				var param = "&cd=" + Value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
		    		sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
		    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH10;
				var param = "&cd=" + Value + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
		    		sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
		    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
	    		sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
	    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
	    		return false;
			}
		} else if (colName == "cust_seq") {
			if (Value.length > 2 && Value.length <= 8) {
				Value = Value.substring(0, 2) + ComLpad(Value.substring(2, 8), 6, "0");
				sheetObj.CellValue2(Row, Col) = Value;
				
				formObj.f_cmd.value = COMMAND07;
				var param = "&etc1=" + Value.substring(0, 2) + "&etc2=" + Value.substring(2, 8);
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = "";
		    		sheetObj.CellValue2(Row, "cust_seq") = "";
		    		sheetObj.SelectCell(Row, "cust_seq", false);
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = "";
	    		sheetObj.CellValue2(Row, "cust_seq") = "";
	    		sheetObj.SelectCell(Row, "cust_seq", false);
	    		return false;
			}
		} else if (colName == "org_rout_pnt_loc_def_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value = SEARCH17;
				var param = "&cd=" + Value + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
	    		sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
	    		sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
	    		return false;
			}
		} else if (colName == "dest_rout_pnt_loc_def_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value = SEARCH17;
				var param = "&cd=" + Value + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
	    		sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
	    		sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
	    		return false;
			}
		}
	}
	
	/**
	 * OnDblClick 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "prc_cmdt_def_nm") {
            var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
            sUrl += "&grp_cd=" + PRI_SP_SCP + "&commodity_cmd=CG&prc_cmdt_tp_cd=C";
            sUrl += "&prc_cmdt_def_nm=" + sheetObj.CellValue(Row, Col);

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 320, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = rtnVal.cd;
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = rtnVal.nm;
			}
		} else if (colName == "cust_lgl_eng_nm") {
            var sUrl = "/hanjin/ESM_PRI_4014.do?" + FormQueryString(document.form);
            sUrl += "&is_popup=true&nmd_cust_flg=N&cust_nm=" + sheetObj.CellValue(Row, Col);
            
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4014", 640, 460, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "cust_seq") = rtnVal.custCntCd + ComLpad(rtnVal.custSeq, 6, "0");
				sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = rtnVal.custNm;
			}
		} else if (colName == "org_rout_pnt_loc_def_nm") {
            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
            sUrl += "&group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&loc_tp_cd=L";
            sUrl += "&loc_def_nm=" + sheetObj.CellValue(Row, Col);

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = rtnVal.cd;
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = rtnVal.nm;
			}
		} else if (colName == "dest_rout_pnt_loc_def_nm") {
            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
            sUrl += "&group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&loc_tp_cd=L";
            sUrl += "&loc_def_nm=" + sheetObj.CellValue(Row, Col);

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = rtnVal.cd;
				sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = rtnVal.nm;
			}
		}
	}
	
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
				ComOpenWait(true);
			}
			
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
			
	        case IBSEARCH_ASYNC20: // PRI_SVC_SCP_PPT_MAPG 조회
	            var sXml = "";  
	            
	            isOViaMandatory = false;
	            isDViaMandatory = false;
	            isDirCallVisible = false;
				
				formObj.f_cmd.value = COMMAND17;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
				var arrTemp = ComPriXml2Array(sXml, "cd|nm");
				if (arrTemp != null && arrTemp.length > 0) {
					for (var i = 0; i < arrTemp.length; i++) {
						var pptCd = arrTemp[i][1];
						if (pptCd == "SOVA") {
							isOViaMandatory = true;
						} else if (pptCd == "SDVA") {
							isDViaMandatory = true;
						} else if (pptCd == "SDRC") {
							isDirCallVisible = true;
						}
					}
				}
				
	            break;
	            
			case IBSEARCH_ASYNC02: // Open
				var strFilePath = sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
				if (strFilePath != "<USER_CANCEL>") {
					var sFileNm = strFilePath.substring(0, strFilePath.lastIndexOf("."));
					if (sFileNm.substring(sFileNm.length - 1, sFileNm.length) == "V") {
						ComShowCodeMessage("PRI01117");
						return;
					}
					
					sheetObj.LoadExcel(-1, 1, strFilePath, -1, -1, "", false, false, "");
				}
				if (sheetObj.RowCount > 0) {
					toggleButtons("LOAD");
					
					for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
						var custSeq = sheetObj.CellValue(i, "cust_seq");
						if (custSeq != null && custSeq.length > 2 && custSeq.length < 8) {
							custSeq = custSeq.substring(0, 2) + ComLpad(custSeq.substring(2, 8), 6, "0");
							sheetObj.CellValue2(i, "cust_seq") = custSeq;
						}
					}
				} else {
					toggleButtons("INIT");
				}
	            
	         	break;
			
			case IBSEARCH_ASYNC01: // Check
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            
	         	break;	
			
	        case IBSAVE: // Save
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
        	
            if (!ComPriConfirmSave()) {
            	return false;
            }
            
            // Nike... 여기저기 많이도 팔아치우는가 보다...
            if (formObj.prop_no.value == "PDX090072M") {
	            formObj.f_cmd.value = MODIFY01;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
	            
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_0099GS.do", sParam);
	            jobKey = ComGetEtcData(sXml, "JOB_KEY");
	            
				if (sXml.indexOf("ERROR") >= 0) {
					sheetObj.LoadSaveXml(sXml);
					return false;
				} else if (jobKey == null || jobKey == "" || jobKey == undefined || jobKey.length <= 0) {
					ComShowCodeMessage("PRI00201");
					return false;
				} else {
					timerID = setInterval(getJobStatus, 2000);
				}
            } else {
                formObj.f_cmd.value = MODIFY02;
                var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
                
                var sXml = sheetObj.GetSaveXml("ESM_PRI_0099GS.do", sParam);
                sheetObj.LoadSaveXml(sXml);
                
    			if (sXml.indexOf("ERROR") >= 0) {
    				return false;
    			}
                
                opener.saveCurRowPos();
                opener.reloadPagePostTr();
                
                ComPriSaveCompleted();
                
                window.close();
            }

            break;
	            
	        case IBCLEAR: // 화면 로딩시 
	            var sXml = ""; 
	            
				//공통 Term Origin
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02138");
				setIBCombo(sheetObj, sXml, "org_rcv_de_term_nm", true, 0);
	
				//공통 Term Destination
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02139");
				setIBCombo(sheetObj, sXml, "dest_rcv_de_term_nm", true, 0);
				
				//공통  Trans. Mode
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				setIBCombo(sheetObj, sXml, "org_prc_trsp_mod_nm", true, 0);
				setIBCombo(sheetObj, sXml, "dest_prc_trsp_mod_nm", true, 0);
	            
	            break;
		
			}
		
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	if (sAction == IBSAVE) {
        		return;
        	}
        	ComOpenWait(false);
        }
	}
	 
	function getJobStatus() {
		var jobStatus = null;
		
		form.f_cmd.value = SEARCHLIST18;
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(form) + "&key=" + jobKey);
		jobStatus = ComGetEtcData(sXml, "JB_STS_FLG");
		
		if (jobStatus == "3") {
			clearInterval(timerID);
			
            opener.saveCurRowPos();
            opener.reloadPagePostTr();
            
            ComPriSaveCompleted();
            
            window.close();
		} else if (jobStatus == "4") {
			clearInterval(timerID);
			
			ComShowCodeMessage("PRI00201");
			return false;
		}
	}
	
	var isClear = true;

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 박성수
     * @version 2009.08.27
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH_ASYNC01: // Check
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	
        	isClear = true;
        	
        	var prevCmdtRow = sheetObj.HeaderRows;
        	var prevRouteRow = sheetObj.HeaderRows;
        	var prevRouteRowOPnt = sheetObj.HeaderRows;
        	var prevRouteRowOVia = sheetObj.HeaderRows;
        	var prevRouteRowDVia = sheetObj.HeaderRows;
        	var prevRouteRowDPnt = sheetObj.HeaderRows;
        	var prevRouteRowRate = sheetObj.HeaderRows;

        	var chkMdtryCmdt = true;
        	var chkMdtryOrgPnt = true;
        	var chkMdtryOrgVia = true;
        	var chkMdtryDestVia = true;
        	var chkMdtryDestPnt = true;
            var sheetObject2 = sheetObjects[1];

            var cmdtCode = null;
            var cmdtDesc = null;

            var custCode = null;
            var custDesc = null;

            var orgPntCode = null;
            var orgPntDesc = null;
            var orgPntTerm = null;
            var orgPntTrans = null;

            var orgViaCode = null;

            var destViaCode = null;

            var destPntCode = null;
            var destPntDesc = null;
            var destPntTerm = null;
            var destPntTrans = null;

            var dCallFlg = null;

            var rateDry20   = 0;
            var rateDry40   = 0;
            var rateDry40hc = 0;
            var rateDry45   = 0;
            var rateRf40hc  = 0;
            var rateRd40hc  = 0;

            var bucDry20   = 0;
            var bucDry40   = 0;
            var bucDry40hc = 0;
            var bucDry45   = 0;
            var bucRf40hc  = 0;
            var bucRd40hc  = 0;

            var ifcDry20   = 0;
            var ifcDry40   = 0;
            var ifcDry40hc = 0;
            var ifcDry45   = 0;
            var ifcRf40hc  = 0;
            var ifcRd40hc  = 0;

            var pscDry20   = 0;
            var pscDry40   = 0;
            var pscDry40hc = 0;
            var pscDry45   = 0;
            var pscRf40hc  = 0;
            var pscRd40hc  = 0;
            
            var frcDry20   = 0;
            var frcDry40   = 0;
            var frcDry40hc = 0;
            var frcDry45   = 0;
            var frcRf40hc  = 0;
            var frcRd40hc  = 0;

            var genSpclRtTpCd = formObj.gen_spcl_rt_tp_cd.value;
            
            ComOpenWait(true);
            clearTooltip();
        	
        	for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {
        		// Commodity Group Mendatory Check.
        		if (sheetObj.CellValue(i, "cmdt_dp_seq") != "") {
        			if (!chkMdtryCmdt) {
        				add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
        				isClear = false;
        				prevCmdtRow = i;
        			} else {
        				chkMdtryCmdt = false;
        				prevCmdtRow = i;
        			}
        		} else if (i == sheetObj.HeaderRows) {
                	add2Tooltip(prevCmdtRow, "cmdt_dp_seq", ComGetMsg("PRI00316", "CMDT Seq"));
                	isClear = false;
                    prevCmdtRow = i;                    
                }
        		
        		// Commodity Check.
        		cmdtCode = sheetObj.CellValue(i, "prc_cmdt_def_cd");
        		cmdtDesc = sheetObj.CellValue(i, "prc_cmdt_def_nm");

                if (cmdtCode != "" || cmdtDesc != "") {
                    chkMdtryCmdt = true;
                    if (cmdtCode != "") {

//                        if (cmdtCode.length == 6) {
//                            formObj.f_cmd.value = SEARCH08;
//                            var param = "&cd=" + cmdtCode;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
//                                isClear = false;
//                            }
//                        } else if (cmdtCode.length == 5) {
//                            formObj.f_cmd.value = SEARCH10;
//                            var param = "&cd=" + cmdtCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        }
//                        else {
                        if (cmdtCode.length != 5 && cmdtCode.length != 6) {
                            add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00314", "5 or 6"));
                            isClear = false;
                        }
                    }
                    if (cmdtCode == "" && cmdtDesc != "") {
                        add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
                        isClear = false;
                    }
                }
        		
        		
        		// Actual Customer Check.
        		custCode = sheetObj.CellValue(i, "cust_seq");
        		custDesc = sheetObj.CellValue(i, "cust_lgl_eng_nm");
//				General Rate 에서는 Actual Customer 값이 입력되어서는 안된다. 2010.11.09 - HJSONG                 
                if (genSpclRtTpCd == 'G' && ( custCode != "" || custDesc != "" ) ) {
                	ComShowCodeMessage ("PRI01136");
                	isClear = false;
                	break;
                }
                     		
                if (custCode != "") {
//                    if (custCode.length > 2 && custCode.length <= 8) {
//                        custCode = custCode.substring(0, 2) + ComLpad(custCode.substring(2, 8), 6, "0");
//                        sheetObj.CellValue2(i, "cust_seq") = custCode;
//
//                        formObj.f_cmd.value = COMMAND07;
//                        var param = "&etc1=" + custCode.substring(0, 2) + "&etc2=" + custCode.substring(2, 8);
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "cust_seq", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else {
                    if (custCode.length <= 2 || custCode.length > 8) {
                        add2Tooltip(i, "cust_seq", ComGetMsg("PRI00315"));
                        isClear = false;
                    }
                } else if (custCode == "" && custDesc != "") {
                    add2Tooltip(i, "cust_seq", ComGetMsg("PRI00335", "Customer Code"));
                    isClear = false;
                }
        		
        		// Origin Point Mendatory Check.
        		if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
        			if (!chkMdtryOrgPnt) {
        				add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
        				isClear = false;
                        prevRouteRowOPnt = i;
        			} else {
        				chkMdtryOrgPnt = false;
        				prevRouteRowOPnt = i;
        			}
        		} else if (sheetObj.CellValue(i, "cmdt_dp_seq") != "") {
                	add2Tooltip(prevRouteRowOPnt, "rout_dp_seq", ComGetMsg("PRI00316", "Route Seq"));
                	isClear = false;
                    prevRouteRowOPnt = i;
                }
        		
        		// Origin Point Check.
        		orgPntCode = sheetObj.CellValue(i, "org_rout_pnt_loc_def_cd");
        		orgPntDesc = sheetObj.CellValue(i, "org_rout_pnt_loc_def_nm");
        		orgPntTerm = sheetObj.CellValue(i, "org_rcv_de_term_nm");
        		orgPntTrans = sheetObj.CellValue(i, "org_prc_trsp_mod_nm");

                if (orgPntCode != "" || orgPntDesc != "" || orgPntTerm != "" || sheetObj.CellText(i, "org_rcv_de_term_nm").trim() != ""
                    || orgPntTrans != "" || sheetObj.CellText(i, "org_prc_trsp_mod_nm").trim() != "") {
                    chkMdtryOrgPnt = true;

                    if (orgPntCode != "") {
//                        if (orgPntCode.length == 5) {
//                            formObj.f_cmd.value = SEARCH05;
//                            var param = "&cd=" + orgPntCode;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else if (orgPntCode.length == 4) {
//                            formObj.f_cmd.value = SEARCH17;
//                            var param = "&cd=" + orgPntCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else {
                        if (orgPntCode.length != 4 && orgPntCode.length != 5) {
                            add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                            isClear = false;
                        }
                    } else {
                        add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Origin Code"));
                        isClear = false;
                    }

                    if (orgPntTerm == "" && sheetObj.CellText(i, "org_rcv_de_term_nm").trim() != "") {
                        add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00315"));
                        isClear = false;
                    }

                    if (orgPntTrans == "" && sheetObj.CellText(i, "org_prc_trsp_mod_nm").trim() != "") {
                        add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
                        isClear = false;
                    }
                }
                
        		// Origin Via Mendatory Check.
        		if (isOViaMandatory && sheetObj.CellValue(i, "rout_dp_seq") != "") {
        			if (!chkMdtryOrgVia) {
        				add2Tooltip(prevRouteRowOVia, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
        				isClear = false;
                        prevRouteRowOVia = i;
        			} else {
        				chkMdtryOrgVia = false;
        				prevRouteRowOVia = i;
        			}
        		}
        		
        		// Origin Via Check.
        		orgViaCode = sheetObj.CellValue(i, "org_rout_via_port_def_cd");
                if (orgViaCode != "") {
                    chkMdtryOrgVia = true;

//                    if (orgViaCode.length == 5) {
//                        formObj.f_cmd.value = SEARCH05;
//                        var param = "&cd=" + orgViaCode;
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else if (orgViaCode.length == 4) {
//                        formObj.f_cmd.value = SEARCH17;
//                        var param = "&cd=" + orgViaCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else {
                    if (orgViaCode.length != 4 && orgViaCode.length != 5) {
                        add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                        isClear = false;
                    }
                }
        		
        		// Destination Via Mendatory Check.
        		if (isDViaMandatory && sheetObj.CellValue(i, "rout_dp_seq") != "") {
        			if (!chkMdtryDestVia) {
        				add2Tooltip(prevRouteRowDVia, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
        				isClear = false;
                        prevRouteRowDVia = i;
        			} else {
        				chkMdtryDestVia = false;
        				prevRouteRowDVia = i;
        			}
        		}
        		
        		// Destination Via Check.
        		destViaCode = sheetObj.CellValue(i, "dest_rout_via_port_def_cd");
                if (destViaCode != "") {
                    chkMdtryDestVia = true;

//                    if (destViaCode.length == 5) {
//                        formObj.f_cmd.value = SEARCH05;
//                        var param = "&cd=" + destViaCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else if (destViaCode.length == 4) {
//                        formObj.f_cmd.value = SEARCH17;
//                        var param = "&cd=" + destViaCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else {
                    if (destViaCode.length != 4 && destViaCode.length != 5) {
                        add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                        isClear = false;
                    }
                }
        		
        		// Destination Point Mendatory Check.
        		if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
        			if (!chkMdtryDestPnt) {
        				add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
        				isClear = false;
                        prevRouteRowDPnt = i;
        			} else {
        				chkMdtryDestPnt = false;
        				prevRouteRowDPnt = i;
        			}
        		}
        		
        		// Destination Point Check.
        		destPntCode = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_cd");
        		destPntDesc = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_nm");
        		destPntTerm = sheetObj.CellValue(i, "dest_rcv_de_term_nm");
        		destPntTrans = sheetObj.CellValue(i, "dest_prc_trsp_mod_nm");
                if (destPntCode != "" || destPntDesc != "" || destPntTerm != "" || sheetObj.CellText(i, "dest_rcv_de_term_nm").trim() != ""
                    || destPntTrans != "" || sheetObj.CellText(i, "dest_prc_trsp_mod_nm").trim() != "") {
                    chkMdtryDestPnt = true;
                    if (destPntCode != "") {

//                        if (destPntCode.length == 5) {
//                            formObj.f_cmd.value = SEARCH05;
//                            var param = "&cd=" + destPntCode;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else if (destPntCode.length == 4) {
//                            formObj.f_cmd.value = SEARCH17;
//                            var param = "&cd=" + destPntCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else {
                        if (destPntCode.length != 4 && destPntCode.length != 5) {
                            add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
                            isClear = false;
                        }
                    } else {
                        add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Destination Code"));
                        isClear = false;
                    }

                    if (destPntTerm == "" && sheetObj.CellText(i, "dest_rcv_de_term_nm").trim() != "") {
                        add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00315"));
                        isClear = false;
                    }

                    if (destPntTrans == "" && sheetObj.CellText(i, "dest_prc_trsp_mod_nm").trim() != "") {
                        add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
                        isClear = false;
                    }
                }
        		
        		// D/Call Check.
        		dCallFlg = sheetObj.CellValue(i, "dir_call_flg");
        		if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
        			if (dCallFlg == "" && sheetObj.CellText(i, "dir_call_flg").trim() != "") {
        				add2Tooltip(i, "dir_call_flg", ComGetMsg("PRI00315"));
        				isClear = false;
        			}
        		}
        		
        		// Rate & Surcharge Check.
                rateDry20 = sheetObj.CellValue(i, "rate_dry20");
                rateDry40 = sheetObj.CellValue(i, "rate_dry40");
                rateDry40hc = sheetObj.CellValue(i, "rate_dry40hc");
                rateDry45 = sheetObj.CellValue(i, "rate_dry45");
                rateRf40hc = sheetObj.CellValue(i, "rate_rf40hc");
                rateRd40hc = sheetObj.CellValue(i, "rate_rd40hc");
                
                bucDry20 = sheetObj.CellValue(i, "buc_dry20");
                bucDry40 = sheetObj.CellValue(i, "buc_dry40");
                bucDry40hc = sheetObj.CellValue(i, "buc_dry40hc");
                bucDry45 = sheetObj.CellValue(i, "buc_dry45");
                bucRf40hc = sheetObj.CellValue(i, "buc_rf40hc");
                bucRd40hc = sheetObj.CellValue(i, "buc_rd40hc");
                
                ifcDry20 = sheetObj.CellValue(i, "ifc_dry20");
                ifcDry40 = sheetObj.CellValue(i, "ifc_dry40");
                ifcDry40hc = sheetObj.CellValue(i, "ifc_dry40hc");
                ifcDry45 = sheetObj.CellValue(i, "ifc_dry45");
                ifcRf40hc = sheetObj.CellValue(i, "ifc_rf40hc");
                ifcRd40hc = sheetObj.CellValue(i, "ifc_rd40hc");
                
                pscDry20 = sheetObj.CellValue(i, "psc_dry20");
                pscDry40 = sheetObj.CellValue(i, "psc_dry40");
                pscDry40hc = sheetObj.CellValue(i, "psc_dry40hc");
                pscDry45 = sheetObj.CellValue(i, "psc_dry45");
                pscRf40hc = sheetObj.CellValue(i, "psc_rf40hc");
                pscRd40hc = sheetObj.CellValue(i, "psc_rd40hc");
                
                frcDry20 = sheetObj.CellValue(i, "frc_dry20");
                frcDry40 = sheetObj.CellValue(i, "frc_dry40");
                frcDry40hc = sheetObj.CellValue(i, "frc_dry40hc");
                frcDry45 = sheetObj.CellValue(i, "frc_dry45");
                frcRf40hc = sheetObj.CellValue(i, "frc_rf40hc");
                frcRd40hc = sheetObj.CellValue(i, "frc_rd40hc");
                
        		// Rate Mendatory Check.
        		if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
        			prevRouteRowRate = i;
        			
//                    var rateDry20 = sheetObj.CellValue(i, "rate_dry20");
//                    var rateDry40 = sheetObj.CellValue(i, "rate_dry40");
//                    var rateDry40hc = sheetObj.CellValue(i, "rate_dry40hc");
//                    var rateDry45 = sheetObj.CellValue(i, "rate_dry45");
//                    var rateRf40hc = sheetObj.CellValue(i, "rate_rf40hc");
//                    var rateRd40hc = sheetObj.CellValue(i, "rate_rd40hc");
                    
                    if (rateDry20 == "" && rateDry40 == "" && rateDry40hc == "" && rateDry45 == "" && rateRf40hc == "" && rateRd40hc == "") {
        				add2Tooltip(prevRouteRowRate, "rate_dry20", ComGetMsg("PRI00316", "Rate"));
        				add2Tooltip(prevRouteRowRate, "rate_dry40", ComGetMsg("PRI00316", "Rate"));
        				add2Tooltip(prevRouteRowRate, "rate_dry40hc", ComGetMsg("PRI00316", "Rate"));
        				add2Tooltip(prevRouteRowRate, "rate_dry45", ComGetMsg("PRI00316", "Rate"));
        				add2Tooltip(prevRouteRowRate, "rate_rf40hc", ComGetMsg("PRI00316", "Rate"));
        				add2Tooltip(prevRouteRowRate, "rate_rd40hc", ComGetMsg("PRI00316", "Rate"));
        				isClear = false;
                    }
        		}
                
                if (rateDry20 != "") {
                    if (rateDry20 != "" && parseFloat(rateDry20) <= 0.00) {
                        add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00321", "Rate", "0"));
                        isClear = false;
                    } else if (rateDry20 != "" && parseFloat(rateDry20) >= 9999999.99) {
                        add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                        isClear = false;
                    }
                    if (bucDry20 != "" && parseFloat(bucDry20) <= 0.00) {
                        add2Tooltip(i, "buc_dry20", ComGetMsg("PRI00321", "BUC", "0"));
                        isClear = false;
                    } else if (bucDry20 != "" && parseFloat(bucDry20) >= 9999999.99) {
                        add2Tooltip(i, "buc_dry20", ComGetMsg("PRI00336", "BUC", "9999999.99"));
                        isClear = false;
                    }
                    if (ifcDry20 != "" && parseFloat(ifcDry20) <= 0.00) {
                        add2Tooltip(i, "ifc_dry20", ComGetMsg("PRI00321", "IFC", "0"));
                        isClear = false;
                    } else if (ifcDry20 != "" && parseFloat(ifcDry20) >= 9999999.99) {
                        add2Tooltip(i, "ifc_dry20", ComGetMsg("PRI00336", "IFC", "9999999.99"));
                        isClear = false;
                    }
                    if (pscDry20 != "" && parseFloat(pscDry20) <= 0.00) {
                        add2Tooltip(i, "psc_dry20", ComGetMsg("PRI00321", "PSC", "0"));
                        isClear = false;
                    } else if (pscDry20 != "" && parseFloat(pscDry20) >= 9999999.99) {
                        add2Tooltip(i, "psc_dry20", ComGetMsg("PRI00336", "PSC", "9999999.99"));
                        isClear = false;
                    }
                    if (frcDry20 != "" && parseFloat(frcDry20) <= 0.00) {
                        add2Tooltip(i, "frc_dry20", ComGetMsg("PRI00321", "FRC", "0"));
                        isClear = false;
                    } else if (frcDry20 != "" && parseFloat(pscDry20) >= 9999999.99) {
                        add2Tooltip(i, "frc_dry20", ComGetMsg("PRI00336", "FRC", "9999999.99"));
                        isClear = false;
                    }
                } else {
                    if (bucDry20 != "") {
                        add2Tooltip(i, "buc_dry20", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (ifcDry20 != "") {
                        add2Tooltip(i, "ifc_dry20", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (pscDry20 != "") {
                        add2Tooltip(i, "psc_dry20", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (frcDry20 != "") {
                        add2Tooltip(i, "frc_dry20", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                }
                
                if (rateDry40 != "") {
                    if (rateDry40 != "" && parseFloat(rateDry40) <= 0.00) {
                        add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00321", "Rate", "0"));
                        isClear = false;
                    } else if (rateDry40 != "" && parseFloat(rateDry40) >= 9999999.99) {
                        add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                        isClear = false;
                    }
                    if (bucDry40 != "" && parseFloat(bucDry40) <= 0.00) {
                        add2Tooltip(i, "buc_dry40", ComGetMsg("PRI00321", "BUC", "0"));
                        isClear = false;
                    } else if (bucDry40 != "" && parseFloat(bucDry40) >= 9999999.99) {
                        add2Tooltip(i, "buc_dry40", ComGetMsg("PRI00336", "BUC", "9999999.99"));
                        isClear = false;
                    }
                    if (ifcDry40 != "" && parseFloat(ifcDry40) <= 0.00) {
                        add2Tooltip(i, "ifc_dry40", ComGetMsg("PRI00321", "IFC", "0"));
                        isClear = false;
                    } else if (ifcDry40 != "" && parseFloat(ifcDry40) >= 9999999.99) {
                        add2Tooltip(i, "ifc_dry40", ComGetMsg("PRI00336", "IFC", "9999999.99"));
                        isClear = false;
                    }
                    if (pscDry40 != "" && parseFloat(pscDry40) <= 0.00) {
                        add2Tooltip(i, "psc_dry40", ComGetMsg("PRI00321", "PSC", "0"));
                        isClear = false;
                    } else if (pscDry40 != "" && parseFloat(pscDry40) >= 9999999.99) {
                        add2Tooltip(i, "psc_dry40", ComGetMsg("PRI00336", "PSC", "9999999.99"));
                        isClear = false;
                    }
                    if (frcDry40 != "" && parseFloat(frcDry40) <= 0.00) {
                        add2Tooltip(i, "frc_dry40", ComGetMsg("PRI00321", "FRC", "0"));
                        isClear = false;
                    } else if (frcDry40 != "" && parseFloat(frcDry40) >= 9999999.99) {
                        add2Tooltip(i, "frc_dry40", ComGetMsg("PRI00336", "FRC", "9999999.99"));
                        isClear = false;
                    }
                } else {
                    if (bucDry40 != "") {
                        add2Tooltip(i, "buc_dry40", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (ifcDry40 != "") {
                        add2Tooltip(i, "ifc_dry40", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (pscDry40 != "") {
                        add2Tooltip(i, "psc_dry40", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (frcDry40 != "") {
                        add2Tooltip(i, "frc_dry40", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                }
                
                if (rateDry40hc != "") {
                    if (rateDry40hc != "" && parseFloat(rateDry40hc) <= 0.00) {
                        add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00321", "Rate", "0"));
                        isClear = false;
                    } else if (rateDry40hc != "" && parseFloat(rateDry40hc) >= 9999999.99) {
                        add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                        isClear = false;
                    }
                    if (bucDry40hc != "" && parseFloat(bucDry40hc) <= 0.00) {
                        add2Tooltip(i, "buc_dry40hc", ComGetMsg("PRI00321", "BUC", "0"));
                        isClear = false;
                    } else if (bucDry40hc != "" && parseFloat(bucDry40hc) >= 9999999.99) {
                        add2Tooltip(i, "buc_dry40hc", ComGetMsg("PRI00336", "BUC", "9999999.99"));
                        isClear = false;
                    }
                    if (ifcDry40hc != "" && parseFloat(ifcDry40hc) <= 0.00) {
                        add2Tooltip(i, "ifc_dry40hc", ComGetMsg("PRI00321", "IFC", "0"));
                        isClear = false;
                    } else if (ifcDry40hc != "" && parseFloat(ifcDry40hc) >= 9999999.99) {
                        add2Tooltip(i, "ifc_dry40hc", ComGetMsg("PRI00336", "IFC", "9999999.99"));
                        isClear = false;
                    }
                    if (pscDry40hc != "" && parseFloat(pscDry40hc) <= 0.00) {
                        add2Tooltip(i, "psc_dry40hc", ComGetMsg("PRI00321", "PSC", "0"));
                        isClear = false;
                    } else if (pscDry40hc != "" && parseFloat(pscDry40hc) >= 9999999.99) {
                        add2Tooltip(i, "psc_dry40hc", ComGetMsg("PRI00336", "PSC", "9999999.99"));
                        isClear = false;
                    }
                    if (frcDry40hc != "" && parseFloat(frcDry40hc) <= 0.00) {
                        add2Tooltip(i, "frc_dry40hc", ComGetMsg("PRI00321", "FRC", "0"));
                        isClear = false;
                    } else if (frcDry40hc != "" && parseFloat(frcDry40hc) >= 9999999.99) {
                        add2Tooltip(i, "frc_dry40hc", ComGetMsg("PRI00336", "FRC", "9999999.99"));
                        isClear = false;
                    }
                } else {
                    if (bucDry40hc != "") {
                        add2Tooltip(i, "buc_dry40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (ifcDry40hc != "") {
                        add2Tooltip(i, "ifc_dry40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (pscDry40hc != "") {
                        add2Tooltip(i, "psc_dry40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (frcDry40hc != "") {
                        add2Tooltip(i, "frc_dry40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                }
                
                if (rateDry45 != "") {
                    if (rateDry45 != "" && parseFloat(rateDry45) <= 0.00) {
                        add2Tooltip(i, "rate_dry45", ComGetMsg("PRI00321", "Rate", "0"));
                        isClear = false;
                    } else if (rateDry45 != "" && parseFloat(rateDry45) >= 9999999.99) {
                        add2Tooltip(i, "rate_dry45", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                        isClear = false;
                    }
                    if (bucDry45 != "" && parseFloat(bucDry45) <= 0.00) {
                        add2Tooltip(i, "buc_dry45", ComGetMsg("PRI00321", "BUC", "0"));
                        isClear = false;
                    } else if (bucDry45 != "" && parseFloat(bucDry45) >= 9999999.99) {
                        add2Tooltip(i, "buc_dry45", ComGetMsg("PRI00336", "BUC", "9999999.99"));
                        isClear = false;
                    }
                    if (ifcDry45 != "" && parseFloat(ifcDry45) <= 0.00) {
                        add2Tooltip(i, "ifc_dry45", ComGetMsg("PRI00321", "IFC", "0"));
                        isClear = false;
                    } else if (ifcDry45 != "" && parseFloat(ifcDry45) >= 9999999.99) {
                        add2Tooltip(i, "ifc_dry45", ComGetMsg("PRI00336", "IFC", "9999999.99"));
                        isClear = false;
                    }
                    if (pscDry45 != "" && parseFloat(pscDry45) <= 0.00) {
                        add2Tooltip(i, "psc_dry45", ComGetMsg("PRI00321", "PSC", "0"));
                        isClear = false;
                    } else if (pscDry45 != "" && parseFloat(pscDry45) >= 9999999.99) {
                        add2Tooltip(i, "psc_dry45", ComGetMsg("PRI00336", "PSC", "9999999.99"));
                        isClear = false;
                    }
                    if (frcDry45 != "" && parseFloat(frcDry45) <= 0.00) {
                        add2Tooltip(i, "frc_dry45", ComGetMsg("PRI00321", "FRC", "0"));
                        isClear = false;
                    } else if (frcDry45 != "" && parseFloat(frcDry45) >= 9999999.99) {
                        add2Tooltip(i, "frc_dry45", ComGetMsg("PRI00336", "FRC", "9999999.99"));
                        isClear = false;
                    }
                } else {
                    if (bucDry45 != "") {
                        add2Tooltip(i, "buc_dry45", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (ifcDry45 != "") {
                        add2Tooltip(i, "ifc_dry45", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (pscDry45 != "") {
                        add2Tooltip(i, "psc_dry45", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (frcDry45 != "") {
                        add2Tooltip(i, "frc_dry45", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                }
                
                if (rateRf40hc != "") {
                    if (rateRf40hc != "" && parseFloat(rateRf40hc) <= 0.00) {
                        add2Tooltip(i, "rate_rf40hc", ComGetMsg("PRI00321", "Rate", "0"));
                        isClear = false;
                    } else if (rateRf40hc != "" && parseFloat(rateRf40hc) >= 9999999.99) {
                        add2Tooltip(i, "rate_rf40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                        isClear = false;
                    }
                    if (bucRf40hc != "" && parseFloat(bucRf40hc) <= 0.00) {
                        add2Tooltip(i, "buc_rf40hc", ComGetMsg("PRI00321", "BUC", "0"));
                        isClear = false;
                    } else if (bucRf40hc != "" && parseFloat(bucRf40hc) >= 9999999.99) {
                        add2Tooltip(i, "buc_rf40hc", ComGetMsg("PRI00336", "BUC", "9999999.99"));
                        isClear = false;
                    }
                    if (ifcRf40hc != "" && parseFloat(ifcRf40hc) <= 0.00) {
                        add2Tooltip(i, "ifc_rf40hc", ComGetMsg("PRI00321", "IFC", "0"));
                        isClear = false;
                    } else if (ifcRf40hc != "" && parseFloat(ifcRf40hc) >= 9999999.99) {
                        add2Tooltip(i, "ifc_rf40hc", ComGetMsg("PRI00336", "IFC", "9999999.99"));
                        isClear = false;
                    }
                    if (pscRf40hc != "" && parseFloat(pscRf40hc) <= 0.00) {
                        add2Tooltip(i, "psc_rf40hc", ComGetMsg("PRI00321", "PSC", "0"));
                        isClear = false;
                    } else if (pscRf40hc != "" && parseFloat(pscRf40hc) >= 9999999.99) {
                        add2Tooltip(i, "psc_rf40hc", ComGetMsg("PRI00336", "PSC", "9999999.99"));
                        isClear = false;
                    }
                    if (frcRf40hc != "" && parseFloat(frcRf40hc) <= 0.00) {
                        add2Tooltip(i, "frc_rf40hc", ComGetMsg("PRI00321", "FRC", "0"));
                        isClear = false;
                    } else if (frcRf40hc != "" && parseFloat(frcRf40hc) >= 9999999.99) {
                        add2Tooltip(i, "frc_rf40hc", ComGetMsg("PRI00336", "FRC", "9999999.99"));
                        isClear = false;
                    }
                } else {
                    if (bucRf40hc != "") {
                        add2Tooltip(i, "buc_rf40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (ifcRf40hc != "") {
                        add2Tooltip(i, "ifc_rf40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (pscRf40hc != "") {
                        add2Tooltip(i, "psc_rf40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (frcRf40hc != "") {
                        add2Tooltip(i, "frc_rf40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                }
                
                if (rateRd40hc != "") {
                    if (rateRd40hc != "" && parseFloat(rateRd40hc) <= 0.00) {
                        add2Tooltip(i, "rate_rd40hc", ComGetMsg("PRI00321", "Rate", "0"));
                        isClear = false;
                    } else if (rateRd40hc != "" && parseFloat(rateRd40hc) >= 9999999.99) {
                        add2Tooltip(i, "rate_rd40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
                        isClear = false;
                    }
                    if (bucRd40hc != "" && parseFloat(bucRd40hc) <= 0.00) {
                        add2Tooltip(i, "buc_rd40hc", ComGetMsg("PRI00321", "BUC", "0"));
                        isClear = false;
                    } else if (bucRd40hc != "" && parseFloat(bucRd40hc) >= 9999999.99) {
                        add2Tooltip(i, "buc_rd40hc", ComGetMsg("PRI00336", "BUC", "9999999.99"));
                        isClear = false;
                    }
                    if (ifcRd40hc != "" && parseFloat(ifcRd40hc) <= 0.00) {
                        add2Tooltip(i, "ifc_rd40hc", ComGetMsg("PRI00321", "IFC", "0"));
                        isClear = false;
                    } else if (ifcRd40hc != "" && parseFloat(ifcRd40hc) >= 9999999.99) {
                        add2Tooltip(i, "ifc_rd40hc", ComGetMsg("PRI00336", "IFC", "9999999.99"));
                        isClear = false;
                    }
                    if (pscRd40hc != "" && parseFloat(pscRd40hc) <= 0.00) {
                        add2Tooltip(i, "psc_rd40hc", ComGetMsg("PRI00321", "PSC", "0"));
                        isClear = false;
                    } else if (pscRd40hc != "" && parseFloat(pscRd40hc) >= 9999999.99) {
                        add2Tooltip(i, "psc_rd40hc", ComGetMsg("PRI00336", "PSC", "9999999.99"));
                        isClear = false;
                    }
                    if (frcRd40hc != "" && parseFloat(frcRd40hc) <= 0.00) {
                        add2Tooltip(i, "frc_rd40hc", ComGetMsg("PRI00321", "FRC", "0"));
                        isClear = false;
                    } else if (frcRd40hc != "" && parseFloat(frcRd40hc) >= 9999999.99) {
                        add2Tooltip(i, "frc_rd40hc", ComGetMsg("PRI00336", "FRC", "9999999.99"));
                        isClear = false;
                    }
                } else {
                    if (bucRd40hc != "") {
                        add2Tooltip(i, "buc_rd40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (ifcRd40hc != "") {
                        add2Tooltip(i, "ifc_rd40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (pscRd40hc != "") {
                        add2Tooltip(i, "psc_rd40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                    if (frcRd40hc != "") {
                        add2Tooltip(i, "frc_rd40hc", ComGetMsg("PRI00335", "Rate"));
                        isClear = false;
                    }
                }                    
        	}
			if (!chkMdtryCmdt) {
				add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
				isClear = false;
			}
			if (!chkMdtryOrgPnt) {
				add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
				isClear = false;
			}
			if (isOViaMandatory && !chkMdtryOrgVia) {
				add2Tooltip(prevRouteRowOVia, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
				isClear = false;
			}
			if (isDViaMandatory && !chkMdtryDestVia) {
				add2Tooltip(prevRouteRowDVia, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
				isClear = false;
			}
			if (!chkMdtryDestPnt) {
				add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
				isClear = false;
			}
			
            formObj.f_cmd.value = SEARCH01;
            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
            var sXml = sheetObject2.GetSearchXml("ESM_PRI_0099GS.do", sParam);
            var arrErr = ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
            
            if (arrErr != null && arrErr.length > 0) {
            	isClear = false;
            	var msg = ComGetMsg("PRI00315");
            	for (var i = 0; i < arrErr.length; i++) {
            		add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows, arrErr[i][1], msg);
            	}
            }
            ComOpenWait(false);
            document.body.scroll = "no";

        	if (isClear) {
	        	toggleButtons("CHECK");
	            return true;
        	} else {
	        	toggleButtons("LOAD");
	            return false;
        	}
            break;
            
        case IBSAVE: // 저장
//            if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
//                return false;
//            }
        	
            return true;
            break;
        }
    }

//    function validateForm(sheetObj, formObj, sAction) {
//        switch (sAction) {
//        case IBSEARCH_ASYNC01: // Check
//            if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
//                return false;
//            }
//            if (sheetObj.RowCount <= 0) {
//                return false;
//            }
//            if (formObj.prc_prop_sts_cd.value != "I") {
//                return false;
//            }
//            
//            isClear = true;
//            
//            var prevCmdtRow = sheetObj.HeaderRows;
//            var prevRouteRow = sheetObj.HeaderRows;
//            var prevRouteRowOPnt = sheetObj.HeaderRows;
//            var prevRouteRowOVia = sheetObj.HeaderRows;
//            var prevRouteRowDVia = sheetObj.HeaderRows;
//            var prevRouteRowDPnt = sheetObj.HeaderRows;
//            var prevRouteRowRate = sheetObj.HeaderRows;
//
//            var chkMdtryCmdt = true;
//            var chkMdtryOrgPnt = true;
//            var chkMdtryOrgVia = true;
//            var chkMdtryDestVia = true;
//            var chkMdtryDestPnt = true;
//            var sheetObject2 = sheetObjects[1];
//
//            ComOpenWait(true);
//            clearTooltip();
//            
//            for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {
//                // Commodity Group Mendatory Check.
//                if (sheetObj.CellValue(i, "cmdt_dp_seq") != "") {
//                    if (!chkMdtryCmdt) {
//                        add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
//                        isClear = false;
//                        prevCmdtRow = i;
//                    } else {
//                        chkMdtryCmdt = false;
//                        prevCmdtRow = i;
//                    }
//                }
//                
//                // Commodity Check.
//                var cmdtCode = sheetObj.CellValue(i, "prc_cmdt_def_cd");
//                var cmdtDesc = sheetObj.CellValue(i, "prc_cmdt_def_nm");
//
//                if (cmdtCode != "" || cmdtDesc != "") {
//                    chkMdtryCmdt = true;
//                    if (cmdtCode != "") {
//
//                        if (cmdtCode.length == 6) {
//                            formObj.f_cmd.value = SEARCH08;
//                            var param = "&cd=" + cmdtCode;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
//                                isClear = false;
//                            }
//                        } else if (cmdtCode.length == 5) {
//                            formObj.f_cmd.value = SEARCH10;
//                            var param = "&cd=" + cmdtCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        }
//                        else {
//                            add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00314", "5 or 6"));
//                            isClear = false;
//                        }
//                    }
//                    if (cmdtCode == "" && cmdtDesc != "") {
//                        add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
//                        isClear = false;
//                    }
//                }
//                
//                
//                // Actual Customer Check.
//                var custCode = sheetObj.CellValue(i, "cust_seq");
//                var custDesc = sheetObj.CellValue(i, "cust_lgl_eng_nm");
//                if (custCode != "") {
//                    if (custCode.length > 2 && custCode.length <= 8) {
//                        custCode = custCode.substring(0, 2) + ComLpad(custCode.substring(2, 8), 6, "0");
//                        sheetObj.CellValue2(i, "cust_seq") = custCode;
//
//                        formObj.f_cmd.value = COMMAND07;
//                        var param = "&etc1=" + custCode.substring(0, 2) + "&etc2=" + custCode.substring(2, 8);
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "cust_seq", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else {
//                        add2Tooltip(i, "cust_seq", ComGetMsg("PRI00315"));
//                        isClear = false;
//                    }
//                } else if (custCode == "" && custDesc != "") {
//                    add2Tooltip(i, "cust_seq", ComGetMsg("PRI00335", "Customer Code"));
//                    isClear = false;
//                }
//                
//                // Origin Point Mendatory Check.
//                if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
//                    if (!chkMdtryOrgPnt) {
//                        add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
//                        isClear = false;
//                        prevRouteRowOPnt = i;
//                    } else {
//                        chkMdtryOrgPnt = false;
//                        prevRouteRowOPnt = i;
//                    }
//                }
//                
//                // Origin Point Check.
//                var orgPntCode = sheetObj.CellValue(i, "org_rout_pnt_loc_def_cd");
//                var orgPntDesc = sheetObj.CellValue(i, "org_rout_pnt_loc_def_nm");
//                var orgPntTerm = sheetObj.CellValue(i, "org_rcv_de_term_nm");
//                var orgPntTrans = sheetObj.CellValue(i, "org_prc_trsp_mod_nm");
//
//                if (orgPntCode != "" || orgPntDesc != "" || orgPntTerm != "" || sheetObj.CellText(i, "org_rcv_de_term_nm").trim() != ""
//                    || orgPntTrans != "" || sheetObj.CellText(i, "org_prc_trsp_mod_nm").trim() != "") {
//                    chkMdtryOrgPnt = true;
//
//                    if (orgPntCode != "") {
//                        if (orgPntCode.length == 5) {
//                            formObj.f_cmd.value = SEARCH05;
//                            var param = "&cd=" + orgPntCode;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else if (orgPntCode.length == 4) {
//                            formObj.f_cmd.value = SEARCH17;
//                            var param = "&cd=" + orgPntCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else {
//                            add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
//                            isClear = false;
//                        }
//                    } else {
//                        add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Origin Code"));
//                        isClear = false;
//                    }
//
//                    if (orgPntTerm == "" && sheetObj.CellText(i, "org_rcv_de_term_nm").trim() != "") {
//                        add2Tooltip(i, "org_rcv_de_term_nm", ComGetMsg("PRI00315"));
//                        isClear = false;
//                    }
//
//                    if (orgPntTrans == "" && sheetObj.CellText(i, "org_prc_trsp_mod_nm").trim() != "") {
//                        add2Tooltip(i, "org_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
//                        isClear = false;
//                    }
//                }
//                
//                // Origin Via Mendatory Check.
//                if (isOViaMandatory && sheetObj.CellValue(i, "rout_dp_seq") != "") {
//                    if (!chkMdtryOrgVia) {
//                        add2Tooltip(prevRouteRowOVia, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
//                        isClear = false;
//                        prevRouteRowOVia = i;
//                    } else {
//                        chkMdtryOrgVia = false;
//                        prevRouteRowOVia = i;
//                    }
//                }
//                
//                // Origin Via Check.
//                var orgViaCode = sheetObj.CellValue(i, "org_rout_via_port_def_cd");
//                if (orgViaCode != "") {
//                    chkMdtryOrgVia = true;
//
//                    if (orgViaCode.length == 5) {
//                        formObj.f_cmd.value = SEARCH05;
//                        var param = "&cd=" + orgViaCode;
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else if (orgViaCode.length == 4) {
//                        formObj.f_cmd.value = SEARCH17;
//                        var param = "&cd=" + orgViaCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else {
//                        add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
//                        isClear = false;
//                    }
//                }
//                
//                // Destination Via Mendatory Check.
//                if (isDViaMandatory && sheetObj.CellValue(i, "rout_dp_seq") != "") {
//                    if (!chkMdtryDestVia) {
//                        add2Tooltip(prevRouteRowDVia, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
//                        isClear = false;
//                        prevRouteRowDVia = i;
//                    } else {
//                        chkMdtryDestVia = false;
//                        prevRouteRowDVia = i;
//                    }
//                }
//                
//                // Destination Via Check.
//                var destViaCode = sheetObj.CellValue(i, "dest_rout_via_port_def_cd");
//                if (destViaCode != "") {
//                    chkMdtryDestVia = true;
//
//                    if (destViaCode.length == 5) {
//                        formObj.f_cmd.value = SEARCH05;
//                        var param = "&cd=" + destViaCode + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=D";
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else if (destViaCode.length == 4) {
//                        formObj.f_cmd.value = SEARCH17;
//                        var param = "&cd=" + destViaCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                        var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//
//                        if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
//                            isClear = false;
//                        }
//                    } else {
//                        add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00314", "4 or 5"));
//                        isClear = false;
//                    }
//                }
//                
//                // Destination Point Mendatory Check.
//                if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
//                    if (!chkMdtryDestPnt) {
//                        add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
//                        isClear = false;
//                        prevRouteRowDPnt = i;
//                    } else {
//                        chkMdtryDestPnt = false;
//                        prevRouteRowDPnt = i;
//                    }
//                }
//                
//                // Destination Point Check.
//                var destPntCode = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_cd");
//                var destPntDesc = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_nm");
//                var destPntTerm = sheetObj.CellValue(i, "dest_rcv_de_term_nm");
//                var destPntTrans = sheetObj.CellValue(i, "dest_prc_trsp_mod_nm");
//                if (destPntCode != "" || destPntDesc != "" || destPntTerm != "" || sheetObj.CellText(i, "dest_rcv_de_term_nm").trim() != ""
//                    || destPntTrans != "" || sheetObj.CellText(i, "dest_prc_trsp_mod_nm").trim() != "") {
//                    chkMdtryDestPnt = true;
//                    if (destPntCode != "") {
//
//                        if (destPntCode.length == 5) {
//                            formObj.f_cmd.value = SEARCH05;
//                            var param = "&cd=" + destPntCode;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else if (destPntCode.length == 4) {
//                            formObj.f_cmd.value = SEARCH17;
//                            var param = "&cd=" + destPntCode + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
//                            var sXml = sheetObject2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
//
//                            if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
//                                isClear = false;
//                            }
//                        } else {
//                            add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "4 or 5"));
//                            isClear = false;
//                        }
//                    } else {
//                        add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00335", "Destination Code"));
//                        isClear = false;
//                    }
//
//                    if (destPntTerm == "" && sheetObj.CellText(i, "dest_rcv_de_term_nm").trim() != "") {
//                        add2Tooltip(i, "dest_rcv_de_term_nm", ComGetMsg("PRI00315"));
//                        isClear = false;
//                    }
//
//                    if (destPntTrans == "" && sheetObj.CellText(i, "dest_prc_trsp_mod_nm").trim() != "") {
//                        add2Tooltip(i, "dest_prc_trsp_mod_nm", ComGetMsg("PRI00315"));
//                        isClear = false;
//                    }
//                }
//                
//                // D/Call Check.
//                var dCallFlg = sheetObj.CellValue(i, "dir_call_flg");
//                if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
//                    if (dCallFlg == "" && sheetObj.CellText(i, "dir_call_flg").trim() != "") {
//                        add2Tooltip(i, "dir_call_flg", ComGetMsg("PRI00315"));
//                        isClear = false;
//                    }
//                }
//                
//                // Rate & Surcharge Check.
//                var rateDry20 = sheetObj.CellValue(i, "rate_dry20");
//                var rateDry40 = sheetObj.CellValue(i, "rate_dry40");
//                var rateDry40hc = sheetObj.CellValue(i, "rate_dry40hc");
//                var rateDry45 = sheetObj.CellValue(i, "rate_dry45");
//                var rateRf40hc = sheetObj.CellValue(i, "rate_rf40hc");
//                var rateRd40hc = sheetObj.CellValue(i, "rate_rd40hc");
//                
//                var bucDry20 = sheetObj.CellValue(i, "buc_dry20");
//                var bucDry40 = sheetObj.CellValue(i, "buc_dry40");
//                var bucDry40hc = sheetObj.CellValue(i, "buc_dry40hc");
//                var bucDry45 = sheetObj.CellValue(i, "buc_dry45");
//                var bucRf40hc = sheetObj.CellValue(i, "buc_rf40hc");
//                var bucRd40hc = sheetObj.CellValue(i, "buc_rd40hc");
//                
//                var ifcDry20 = sheetObj.CellValue(i, "ifc_dry20");
//                var ifcDry40 = sheetObj.CellValue(i, "ifc_dry40");
//                var ifcDry40hc = sheetObj.CellValue(i, "ifc_dry40hc");
//                var ifcDry45 = sheetObj.CellValue(i, "ifc_dry45");
//                var ifcRf40hc = sheetObj.CellValue(i, "ifc_rf40hc");
//                var ifcRd40hc = sheetObj.CellValue(i, "ifc_rd40hc");
//                
//                var pscDry20 = sheetObj.CellValue(i, "psc_dry20");
//                var pscDry40 = sheetObj.CellValue(i, "psc_dry40");
//                var pscDry40hc = sheetObj.CellValue(i, "psc_dry40hc");
//                var pscDry45 = sheetObj.CellValue(i, "psc_dry45");
//                var pscRf40hc = sheetObj.CellValue(i, "psc_rf40hc");
//                var pscRd40hc = sheetObj.CellValue(i, "psc_rd40hc");
//                
//                // Rate Mendatory Check.
//                if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
//                    prevRouteRowRate = i;
//                    
//                    var rateDry20 = sheetObj.CellValue(i, "rate_dry20");
//                    var rateDry40 = sheetObj.CellValue(i, "rate_dry40");
//                    var rateDry40hc = sheetObj.CellValue(i, "rate_dry40hc");
//                    var rateDry45 = sheetObj.CellValue(i, "rate_dry45");
//                    var rateRf40hc = sheetObj.CellValue(i, "rate_rf40hc");
//                    var rateRd40hc = sheetObj.CellValue(i, "rate_rd40hc");
//                    
//                    if (rateDry20 == "" && rateDry40 == "" && rateDry40hc == "" && rateDry45 == "" && rateRf40hc == "" && rateRd40hc == "") {
//                        add2Tooltip(prevRouteRowRate, "rate_dry20", ComGetMsg("PRI00316", "Rate"));
//                        add2Tooltip(prevRouteRowRate, "rate_dry40", ComGetMsg("PRI00316", "Rate"));
//                        add2Tooltip(prevRouteRowRate, "rate_dry40hc", ComGetMsg("PRI00316", "Rate"));
//                        add2Tooltip(prevRouteRowRate, "rate_dry45", ComGetMsg("PRI00316", "Rate"));
//                        add2Tooltip(prevRouteRowRate, "rate_rf40hc", ComGetMsg("PRI00316", "Rate"));
//                        add2Tooltip(prevRouteRowRate, "rate_rd40hc", ComGetMsg("PRI00316", "Rate"));
//                        isClear = false;
//                    }
//                }
//                
//                if (rateDry20 != "") {
//                    if (rateDry20 != "" && parseFloat(rateDry20) <= 0.00) {
//                        add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00321", "Rate", "0"));
//                        isClear = false;
//                    } else if (rateDry20 != "" && parseFloat(rateDry20) >= 9999999.99) {
//                        add2Tooltip(i, "rate_dry20", ComGetMsg("PRI00336", "Rate", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (bucDry20 != "" && parseFloat(bucDry20) <= 0.00) {
//                        add2Tooltip(i, "buc_dry20", ComGetMsg("PRI00321", "BUC", "0"));
//                        isClear = false;
//                    } else if (bucDry20 != "" && parseFloat(bucDry20) >= 9999999.99) {
//                        add2Tooltip(i, "buc_dry20", ComGetMsg("PRI00336", "BUC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (ifcDry20 != "" && parseFloat(ifcDry20) <= 0.00) {
//                        add2Tooltip(i, "ifc_dry20", ComGetMsg("PRI00321", "IFC", "0"));
//                        isClear = false;
//                    } else if (ifcDry20 != "" && parseFloat(ifcDry20) >= 9999999.99) {
//                        add2Tooltip(i, "ifc_dry20", ComGetMsg("PRI00336", "IFC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (pscDry20 != "" && parseFloat(pscDry20) <= 0.00) {
//                        add2Tooltip(i, "psc_dry20", ComGetMsg("PRI00321", "PSC", "0"));
//                        isClear = false;
//                    } else if (pscDry20 != "" && parseFloat(pscDry20) >= 9999999.99) {
//                        add2Tooltip(i, "psc_dry20", ComGetMsg("PRI00336", "PSC", "9999999.99"));
//                        isClear = false;
//                    }
//                } else {
//                    if (bucDry20 != "") {
//                        add2Tooltip(i, "buc_dry20", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (ifcDry20 != "") {
//                        add2Tooltip(i, "ifc_dry20", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (pscDry20 != "") {
//                        add2Tooltip(i, "psc_dry20", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                }
//                
//                if (rateDry40 != "") {
//                    if (rateDry40 != "" && parseFloat(rateDry40) <= 0.00) {
//                        add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00321", "Rate", "0"));
//                        isClear = false;
//                    } else if (rateDry40 != "" && parseFloat(rateDry40) >= 9999999.99) {
//                        add2Tooltip(i, "rate_dry40", ComGetMsg("PRI00336", "Rate", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (bucDry40 != "" && parseFloat(bucDry40) <= 0.00) {
//                        add2Tooltip(i, "buc_dry40", ComGetMsg("PRI00321", "BUC", "0"));
//                        isClear = false;
//                    } else if (bucDry40 != "" && parseFloat(bucDry40) >= 9999999.99) {
//                        add2Tooltip(i, "buc_dry40", ComGetMsg("PRI00336", "BUC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (ifcDry40 != "" && parseFloat(ifcDry40) <= 0.00) {
//                        add2Tooltip(i, "ifc_dry40", ComGetMsg("PRI00321", "IFC", "0"));
//                        isClear = false;
//                    } else if (ifcDry40 != "" && parseFloat(ifcDry40) >= 9999999.99) {
//                        add2Tooltip(i, "ifc_dry40", ComGetMsg("PRI00336", "IFC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (pscDry40 != "" && parseFloat(pscDry40) <= 0.00) {
//                        add2Tooltip(i, "psc_dry40", ComGetMsg("PRI00321", "PSC", "0"));
//                        isClear = false;
//                    } else if (pscDry40 != "" && parseFloat(pscDry40) >= 9999999.99) {
//                        add2Tooltip(i, "psc_dry40", ComGetMsg("PRI00336", "PSC", "9999999.99"));
//                        isClear = false;
//                    }
//                } else {
//                    if (bucDry40 != "") {
//                        add2Tooltip(i, "buc_dry40", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (ifcDry40 != "") {
//                        add2Tooltip(i, "ifc_dry40", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (pscDry40 != "") {
//                        add2Tooltip(i, "psc_dry40", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                }
//                
//                if (rateDry40hc != "") {
//                    if (rateDry40hc != "" && parseFloat(rateDry40hc) <= 0.00) {
//                        add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00321", "Rate", "0"));
//                        isClear = false;
//                    } else if (rateDry40hc != "" && parseFloat(rateDry40hc) >= 9999999.99) {
//                        add2Tooltip(i, "rate_dry40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (bucDry40hc != "" && parseFloat(bucDry40hc) <= 0.00) {
//                        add2Tooltip(i, "buc_dry40hc", ComGetMsg("PRI00321", "BUC", "0"));
//                        isClear = false;
//                    } else if (bucDry40hc != "" && parseFloat(bucDry40hc) >= 9999999.99) {
//                        add2Tooltip(i, "buc_dry40hc", ComGetMsg("PRI00336", "BUC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (ifcDry40hc != "" && parseFloat(ifcDry40hc) <= 0.00) {
//                        add2Tooltip(i, "ifc_dry40hc", ComGetMsg("PRI00321", "IFC", "0"));
//                        isClear = false;
//                    } else if (ifcDry40hc != "" && parseFloat(ifcDry40hc) >= 9999999.99) {
//                        add2Tooltip(i, "ifc_dry40hc", ComGetMsg("PRI00336", "IFC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (pscDry40hc != "" && parseFloat(pscDry40hc) <= 0.00) {
//                        add2Tooltip(i, "psc_dry40hc", ComGetMsg("PRI00321", "PSC", "0"));
//                        isClear = false;
//                    } else if (pscDry40hc != "" && parseFloat(pscDry40hc) >= 9999999.99) {
//                        add2Tooltip(i, "psc_dry40hc", ComGetMsg("PRI00336", "PSC", "9999999.99"));
//                        isClear = false;
//                    }
//                } else {
//                    if (bucDry40hc != "") {
//                        add2Tooltip(i, "buc_dry40hc", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (ifcDry40hc != "") {
//                        add2Tooltip(i, "ifc_dry40hc", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (pscDry40hc != "") {
//                        add2Tooltip(i, "psc_dry40hc", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                }
//                
//                if (rateDry45 != "") {
//                    if (rateDry45 != "" && parseFloat(rateDry45) <= 0.00) {
//                        add2Tooltip(i, "rate_dry45", ComGetMsg("PRI00321", "Rate", "0"));
//                        isClear = false;
//                    } else if (rateDry45 != "" && parseFloat(rateDry45) >= 9999999.99) {
//                        add2Tooltip(i, "rate_dry45", ComGetMsg("PRI00336", "Rate", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (bucDry45 != "" && parseFloat(bucDry45) <= 0.00) {
//                        add2Tooltip(i, "buc_dry45", ComGetMsg("PRI00321", "BUC", "0"));
//                        isClear = false;
//                    } else if (bucDry45 != "" && parseFloat(bucDry45) >= 9999999.99) {
//                        add2Tooltip(i, "buc_dry45", ComGetMsg("PRI00336", "BUC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (ifcDry45 != "" && parseFloat(ifcDry45) <= 0.00) {
//                        add2Tooltip(i, "ifc_dry45", ComGetMsg("PRI00321", "IFC", "0"));
//                        isClear = false;
//                    } else if (ifcDry45 != "" && parseFloat(ifcDry45) >= 9999999.99) {
//                        add2Tooltip(i, "ifc_dry45", ComGetMsg("PRI00336", "IFC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (pscDry45 != "" && parseFloat(pscDry45) <= 0.00) {
//                        add2Tooltip(i, "psc_dry45", ComGetMsg("PRI00321", "PSC", "0"));
//                        isClear = false;
//                    } else if (pscDry45 != "" && parseFloat(pscDry45) >= 9999999.99) {
//                        add2Tooltip(i, "psc_dry45", ComGetMsg("PRI00336", "PSC", "9999999.99"));
//                        isClear = false;
//                    }
//                } else {
//                    if (bucDry45 != "") {
//                        add2Tooltip(i, "buc_dry45", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (ifcDry45 != "") {
//                        add2Tooltip(i, "ifc_dry45", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (pscDry45 != "") {
//                        add2Tooltip(i, "psc_dry45", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                }
//                
//                if (rateRf40hc != "") {
//                    if (rateRf40hc != "" && parseFloat(rateRf40hc) <= 0.00) {
//                        add2Tooltip(i, "rate_rf40hc", ComGetMsg("PRI00321", "Rate", "0"));
//                        isClear = false;
//                    } else if (rateRf40hc != "" && parseFloat(rateRf40hc) >= 9999999.99) {
//                        add2Tooltip(i, "rate_rf40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (bucRf40hc != "" && parseFloat(bucRf40hc) <= 0.00) {
//                        add2Tooltip(i, "buc_rf40hc", ComGetMsg("PRI00321", "BUC", "0"));
//                        isClear = false;
//                    } else if (bucRf40hc != "" && parseFloat(bucRf40hc) >= 9999999.99) {
//                        add2Tooltip(i, "buc_rf40hc", ComGetMsg("PRI00336", "BUC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (ifcRf40hc != "" && parseFloat(ifcRf40hc) <= 0.00) {
//                        add2Tooltip(i, "ifc_rf40hc", ComGetMsg("PRI00321", "IFC", "0"));
//                        isClear = false;
//                    } else if (ifcRf40hc != "" && parseFloat(ifcRf40hc) >= 9999999.99) {
//                        add2Tooltip(i, "ifc_rf40hc", ComGetMsg("PRI00336", "IFC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (pscRf40hc != "" && parseFloat(pscRf40hc) <= 0.00) {
//                        add2Tooltip(i, "psc_rf40hc", ComGetMsg("PRI00321", "PSC", "0"));
//                        isClear = false;
//                    } else if (pscRf40hc != "" && parseFloat(pscRf40hc) >= 9999999.99) {
//                        add2Tooltip(i, "psc_rf40hc", ComGetMsg("PRI00336", "PSC", "9999999.99"));
//                        isClear = false;
//                    }
//                } else {
//                    if (bucRf40hc != "") {
//                        add2Tooltip(i, "buc_rf40hc", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (ifcRf40hc != "") {
//                        add2Tooltip(i, "ifc_rf40hc", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (pscRf40hc != "") {
//                        add2Tooltip(i, "psc_rf40hc", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                }
//                
//                if (rateRd40hc != "") {
//                    if (rateRd40hc != "" && parseFloat(rateRd40hc) <= 0.00) {
//                        add2Tooltip(i, "rate_rd40hc", ComGetMsg("PRI00321", "Rate", "0"));
//                        isClear = false;
//                    } else if (rateRd40hc != "" && parseFloat(rateRd40hc) >= 9999999.99) {
//                        add2Tooltip(i, "rate_rd40hc", ComGetMsg("PRI00336", "Rate", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (bucRd40hc != "" && parseFloat(bucRd40hc) <= 0.00) {
//                        add2Tooltip(i, "buc_rd40hc", ComGetMsg("PRI00321", "BUC", "0"));
//                        isClear = false;
//                    } else if (bucRd40hc != "" && parseFloat(bucRd40hc) >= 9999999.99) {
//                        add2Tooltip(i, "buc_rd40hc", ComGetMsg("PRI00336", "BUC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (ifcRd40hc != "" && parseFloat(ifcRd40hc) <= 0.00) {
//                        add2Tooltip(i, "ifc_rd40hc", ComGetMsg("PRI00321", "IFC", "0"));
//                        isClear = false;
//                    } else if (ifcRd40hc != "" && parseFloat(ifcRd40hc) >= 9999999.99) {
//                        add2Tooltip(i, "ifc_rd40hc", ComGetMsg("PRI00336", "IFC", "9999999.99"));
//                        isClear = false;
//                    }
//                    if (pscRd40hc != "" && parseFloat(pscRd40hc) <= 0.00) {
//                        add2Tooltip(i, "psc_rd40hc", ComGetMsg("PRI00321", "PSC", "0"));
//                        isClear = false;
//                    } else if (pscRd40hc != "" && parseFloat(pscRd40hc) >= 9999999.99) {
//                        add2Tooltip(i, "psc_rd40hc", ComGetMsg("PRI00336", "PSC", "9999999.99"));
//                        isClear = false;
//                    }
//                } else {
//                    if (bucRd40hc != "") {
//                        add2Tooltip(i, "buc_rd40hc", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (ifcRd40hc != "") {
//                        add2Tooltip(i, "ifc_rd40hc", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                    if (pscRd40hc != "") {
//                        add2Tooltip(i, "psc_rd40hc", ComGetMsg("PRI00335", "Rate"));
//                        isClear = false;
//                    }
//                }                    
//            }
//            if (!chkMdtryCmdt) {
//                add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
//                isClear = false;
//            }
//            if (!chkMdtryOrgPnt) {
//                add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
//                isClear = false;
//            }
//            if (isOViaMandatory && !chkMdtryOrgVia) {
//                add2Tooltip(prevRouteRowOVia, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
//                isClear = false;
//            }
//            if (isDViaMandatory && !chkMdtryDestVia) {
//                add2Tooltip(prevRouteRowDVia, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
//                isClear = false;
//            }
//            if (!chkMdtryDestPnt) {
//                add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
//                isClear = false;
//            }
//            
//            formObj.f_cmd.value = SEARCH01;
//            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
//            var sXml = sheetObject2.GetSearchXml("ESM_PRI_0099GS.do", sParam);
//            var arrErr = ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
//            
//            if (arrErr != null && arrErr.length > 0) {
//                isClear = false;
//                var msg = ComGetMsg("PRI00315");
//                for (var i = 0; i < arrErr.length; i++) {
//                    add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows, arrErr[i][1], msg);
//                }
//            }
//            ComOpenWait(false);
//            document.body.scroll = "no";
//
//            if (isClear) {
//                toggleButtons("CHECK");
//                return true;
//            } else {
//                toggleButtons("LOAD");
//                return false;
//            }
//            break;
//            
//        case IBSAVE: // 저장
//            if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
//                return false;
//            }
//            
//            return true;
//            break;
//        }
//    }

    
    
    function clearTooltip() {
    	var sheetObj = sheetObjects[0];
        var n = sheetObj.HeaderRows+sheetObj.RowCount;
        var m = sheetObj.LastCol;
        var i = sheetObj.HeaderRows;
        var j = 0;
        for (i = sheetObj.HeaderRows ; i < n; i++) {
            for (j = 0 ; j <= m ; j++) {
                if (sheetObj.ToolTipText(i, j) != "") {
                    sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
                    sheetObj.ToolTipText(i, j) = "";
                }
            }
        }
//    	for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i < sheetObj.LastRow; i++) {
//    		for (var j = 0; j < sheetObj.LastCol; j++) {
//    			sheetObj.CellBackColor(i, j) = sheetObj.EditableColor ;
//    			sheetObj.ToolTipText(i, j) = "";
//    		}
//    	}
    }
    
    function add2Tooltip(row, col, msg) {
    	var sheetObj = sheetObjects[0];

    	sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,0,0);
    	sheetObj.ToolTipText(row, col) +="\n- " +  msg;
    }
	
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode 필수 사용자 권한이나 모드
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function toggleButtons(step) {
        switch (step) {
        case "INIT":
        	ComBtnEnable("btn_openfile");
            ComBtnDisable("btn_check");
            ComBtnDisable("btn_save");
            break;
        case "LOAD":
        	ComBtnEnable("btn_openfile");
        	ComBtnEnable("btn_check");
            ComBtnDisable("btn_save");
            break;
        case "CHECK":
        	ComBtnEnable("btn_openfile");
        	ComBtnEnable("btn_check");
        	ComBtnEnable("btn_save");
            break;
        }
    }