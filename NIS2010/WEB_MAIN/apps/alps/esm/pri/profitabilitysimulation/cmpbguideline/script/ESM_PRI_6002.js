﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6002.js
*@FileTitle : Rate Creation - Excel Import(Vertical)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.10.15 이승준
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6002() {
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
	  * @author 이승준
	  * @version 2009.04.17
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
			
			case "btn_openfile":
				var strFilePath = sheetObject1.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
				if (strFilePath != "<USER_CANCEL>") {
					sheetObject1.LoadExcel(-1, 1, strFilePath, -1, -1, "", false, false, "");
				}
				if (sheetObject1.RowCount > 0) {
					toggleButtons("LOAD");
				} else {
					toggleButtons("INIT");
				}
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
				
			case "btn_Template":
				downform.submit();
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
     * @author 이승준
     * @version 2009.04.17
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
     * @author 이승준
     * @version 2009.04.17
     */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		toggleButtons("INIT");
		
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
     * @author 이승준
     * @version 2009.04.17
     */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		
	    switch(sheetID) {
	    
	    case "sheet1": // sheet1 init
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
				
                var HeadTitle1 = "|Seq.|SVC Lane|Commodity|Commodity|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Per|Cargo\nType|Cur.|CMPB\nGuideline|MQC\n(Min.)|MQC\n(Max.)";
                var HeadTitle2 = "|Seq.|SVC Lane|Code|Description|Code|Description|Term|Code|Code|Code|Description|Term|Per|Cargo\nType|Cur.|CMPB\nGuideline|MQC\n(Min.)|MQC\n(Max.)";
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
                InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "rout_dp_seq", false, "", dfNullInteger, 0, true, true, 5);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "vsl_slan_cd", false, "", dfNone, 0, true, true, 3);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "prc_cmdt_def_cd", false, "", dfNone, 0, true, true, 6);
                InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "prc_cmdt_def_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "org_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true, 5);
                InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "org_rout_pnt_loc_def_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo, 80, daCenter, false, "org_rcv_de_term_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true, 5);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "dest_rout_pnt_loc_def_cd", false, "", dfNone, 0, true, true, 5);
                InitDataProperty(0, cnt++, dtData, 130, daLeft, false, "dest_rout_pnt_loc_def_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo, 80, daCenter, false, "dest_rcv_de_term_nm", false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "rat_ut_cd", false, "", dfNone, 0, true, true, 2);
                InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true, "prc_cgo_tp_cd", false, "", dfNone, 0, true, true, 2);
                InitDataProperty(0, cnt++, dtCombo, 50, daCenter, true, "curr_cd", false, "", dfNullFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 100, daRight, true, "cmpb_amt", false, "", dfNullFloat, 2, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 100, daRight, true, "mqc_rng_fm_qty", false, "", dfNullInteger, 0, true, true, 9);
                InitDataProperty(0, cnt++, dtData, 100, daRight, true, "mqc_rng_to_qty", false, "", dfNullInteger, 0, true, true, 9);

                ShowButtonImage = 2;
                ToolTipOption = "balloon:true;width:1000;icon:3;title:Load Excel";
                
                InitDataValid(0, "vsl_slan_cd",	vtEngUpOnly);		// 영문대문자만 입력
                InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther, "0123456789");
                InitDataValid(0, "org_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
                InitDataValid(0, "org_rout_via_port_def_cd", vtEngUpOther, "0123456789");
                InitDataValid(0, "dest_rout_via_port_def_cd", vtEngUpOther, "0123456789");
                InitDataValid(0, "dest_rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");
                SelectHighLight = false;
                FrozenCols = 3;
                WaitImageVisible = false;
                
                /*
                if (document.form.gen_spcl_rt_tp_cd.value == "G") {
                	ColHidden("cust_lgl_eng_nm") = true;
                	ColWidth("prc_cmdt_def_nm") =  160;
                	ColWidth("cnote_ctnt") =  150;
                }
                */
			}
			break;
			
	    case "sheet2":      //hidden 
	       	 with (sheetObj) {
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "status";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					
					Visible = false;
					WaitImageVisible = false;
				 }
	       	 break;
			
		}
	}
	
	/**
     * OnKeyUp event를 처리한다. <br>
     * cell의 색이 빨간 색인 경우 cell을 선택한다.
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift)
     * </pre>
     * @param {sheetObj} sheetObj
     * @param {int} Row
     * @param {int} Col
     * @param {String} KeyCode
     * @param {int} Shift
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */   
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
     * OnChange event를 처리한다. <br>
     * sheet의 값이 바뀐 경우 유효한 값인지 확인한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnChange(sheetObj, Row, Col, Value)
     * </pre>
     * @param {sheetObj} sheetObj
     * @param {int} Row
     * @param {int} Col
     * @param {String} Value
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */   
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "vsl_slan_cd") {
			//SVC Lane
			if (Value.length == 3) {
				formObj.f_cmd.value = COMMAND26;
                var param = "&cd=" + Value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[0] != "") {
 					sheetObj.CellValue2(Row, "vsl_slan_cd") = arrData[0];
				} else {
					sheetObj.CellValue2(Row, "vsl_slan_cd") = "";
		    		sheetObj.SelectCell(Row, "vsl_slan_cd", false);
		    		return false;
				}
			}
		
		} else if (colName == "prc_cgo_tp_cd") {
            if (Value == "AK") {
            	var validPerClass = "A,F,O,Q,S,P";
                var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
                if (validPerClass.indexOf(perClass) < 0) {
                    ComShowCodeMessage("PRI08003");
                    sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
                }
            }
            
		} else if (colName == "rat_ut_cd") {
        	var validPerClass = "A,F,O,Q,S,P";
            var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
            if (perClass == "") {
            	return;
            }
            if (perClass == "D") {
            	sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "DR"
            } else if (perClass == "R") {
            	sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "RF"
            } else if (validPerClass.indexOf(perClass) >= 0) {
            	sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "AK"
            } else {
            	if (sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK") {
	                ComShowCodeMessage("PRI08003");
	                sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
            	}
            }
            
		} else if (colName == "prc_cmdt_def_cd") {
			//cmdt
			if (Value.length == 6) {
				formObj.f_cmd.value = SEARCH08;
				var param = "&cd=" + Value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
		    		sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
		    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
		    		return false;
				}
			//group cmdt
			} else if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH10;
				var param = "&cd=" + Value + "&nm=cmpb" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value + "&etc3=" + formObj.gline_seq.value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = "";
		    		sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";
		    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
		    		return false;
				}
			//rep cmdt
			} else if (Value.length == 4) {
				formObj.f_cmd.value = COMMAND29;
				var param = "&cd=" + Value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
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
		} else if (colName == "org_rout_pnt_loc_def_cd") {
			//location
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
		    		return false;
				}
			//location group	
			} else if (Value.length == 4) {
				formObj.f_cmd.value = SEARCH11;
				var param = "&cd=" + Value + "&nm=cmpb" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value + "&etc3=" + formObj.gline_seq.value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
		    		return false;
				}
			//region	
			} else if (Value.length == 3) {
				formObj.f_cmd.value = COMMAND08;
				var param = "&cd=" + Value ;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "org_rout_pnt_loc_def_cd", false);
		    		return false;
				}	
			//country	
			} else if (Value.length == 2) {
				formObj.f_cmd.value = SEARCH07;
				var param = "&cd=" + Value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
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
			//location
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
		    		return false;
				}
			//location group	
			} else if (Value.length == 4) {
				formObj.f_cmd.value = SEARCH11;
				var param = "&cd=" + Value + "&nm=cmpb" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value + "&etc3=" + formObj.gline_seq.value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
		    		return false;
				}
			//region	
			} else if (Value.length == 3) {
				formObj.f_cmd.value = COMMAND08;
				var param = "&cd=" + Value ;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_nm") = "";
		    		sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = "";
		    		sheetObj.SelectCell(Row, "dest_rout_pnt_loc_def_cd", false);
		    		return false;
				}	
			//country	
			} else if (Value.length == 2) {
				formObj.f_cmd.value = SEARCH07;
				var param = "&cd=" + Value;
				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
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
     * OnDblClick event를 처리한다. <br>
     * 더블클릭시 해당 팝업을 호춣한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnDblClick(sheetObj, Row, Col)
     * </pre>
     * @param {sheetObj} sheetObj
     * @param {int} Row
     * @param {int} Col
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
//		if (colName == "vsl_slan_cd") {
//			var sUrl = "/hanjin/ESM_PRI_6039.do?svc_scp_cd=" + getSvcScpCd() + "&cre_ofc_cd=" + formObj.cre_ofc_cd.value + 
//			"&gline_seq=" + formObj.gline_seq.value + "&prs_cust_tp_cd=" + getPrsCustTpCd() + "&svc_scp_nm=" + formObj.svc_scp_nm.value;
//	        
//			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6039", 600, 450, true);
//			if (rtnVal != null){
//				sheetObj.CellValue2(Row, "vsl_slan_cd") = rtnVal.cd;
//			}
//		} 
//		else 
		if (colName == "prc_cmdt_def_nm") {
            var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
            sUrl += "&grp_cd=" + PRI_CMPB + "&commodity_cmd=CRG&prc_cmdt_tp_cd=C";
            sUrl += "&prc_cmdt_def_nm=" + sheetObj.CellValue(Row, Col);

			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = rtnVal.cd;
				sheetObj.CellValue2(Row, "prc_cmdt_def_nm") = rtnVal.nm;
			}
		} else if (colName == "org_rout_pnt_loc_def_nm") {
            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
            sUrl += "&group_cmd=" + PRI_CMPB + "&location_cmd=LGCR&loc_tp_cd=L";
            sUrl += "&loc_def_nm=" + sheetObj.CellValue(Row, Col);
            
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = rtnVal.cd;
				sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_nm") = rtnVal.nm;
			}
		} else if (colName == "dest_rout_pnt_loc_def_nm") {
			 var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_CMPB + "&location_cmd=LGCR&loc_tp_cd=L";
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
     * @author 이승준
     * @version 2009.04.17
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		
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
            
            try {
            	sheetObjects[0].WaitImageVisible = false;
            	ComOpenWait(true);
            
	            formObj.f_cmd.value = MODIFY01;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
	            
	            var sXml = sheetObj.GetSaveXml("ESM_PRI_6002GS.do", sParam);
	            sheetObj.LoadSaveXml(sXml);
	            
	            ComOpenWait(false);

            } catch (e) {
	            if (e == "[object Error]") {
	                ComShowMessage(OBJECT_ERROR);
	            } else {
	                ComShowMessage(e);
	            }
	       } finally {
	    	   ComOpenWait(false);
	       }    
            
			if (sXml.indexOf("ERROR") >= 0) {
				return false;
			}
            
            ComPriSaveCompleted();
            
            dialogArguments.reSearch();
            
            window.close();
            
            break;
            
        case IBCLEAR: // 화면 로딩시 
            sheetObj.WaitImageVisible = false;
            var sXml = ""; 
            var arrTemp = new Array();
            
            // per combo
            formObj.f_cmd.value = SEARCH03;
            sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
            setIBCombo(sheetObj, sXml, "rat_ut_cd", true, 0);
            
            //공통 cargo
            formObj.f_cmd.value = SEARCH19;
            sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02202");
            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", true, 0);
            
			//공통 Term Origin
			formObj.f_cmd.value = SEARCH19;
			sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02138");
			setIBCombo(sheetObj, sXml, "org_rcv_de_term_nm", true, 0);

			//공통 Term Destination
			formObj.f_cmd.value = SEARCH19;
			sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02139");
			setIBCombo(sheetObj, sXml, "dest_rcv_de_term_nm", true, 0);
			
			//공통 CUR
			formObj.f_cmd.value = SEARCH06;
            sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
            setIBCombo(sheetObj, sXml, "curr_cd", true, 0);
			
			sheetObj.WaitImageVisible = true;
            break;
	
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
     * @author 이승준
     * @version 2009.08.27
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH_ASYNC01: // Check
        	if (formObj.svc_scp_cd.value == "" || formObj.cre_ofc_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            }
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	
        	isClear = true;
        	
        	var prevSvcLaneRow   = sheetObj.HeaderRows;
        	var prevCmdtRow 	 = sheetObj.HeaderRows;
        	var prevRouteRowOPnt = sheetObj.HeaderRows;
        	var prevRouteRowOVia = sheetObj.HeaderRows;
        	var prevRouteRowDVia = sheetObj.HeaderRows;
        	var prevRouteRowDPnt = sheetObj.HeaderRows;
        	var prevRouteRowRate = sheetObj.HeaderRows;

        	var chkMdtrySvcLane = true;
        	var chkMdtryCmdt = true;
        	var chkMdtryOrgPnt = true;
        	var chkMdtryOrgVia = true;
        	var chkMdtryDestVia = true;
        	var chkMdtryDestPnt = true;
        	var chkMdtryRate = true;
        	
        	try {
        	
	        	ComOpenWait(true);
			  	
	        	clearTooltip();
	        	
	        	for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {
	        		// Commodity Group Mendatory Check.
	//        		if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
	//        			if (!chkMdtrySvcLane) {
	//        				add2Tooltip(prevSvcLaneRow, "vsl_slan_cd", ComGetMsg("PRI00316", "SVC Lane"));
	//        				isClear = false;
	//                        prevCmdtRow = i;
	//        			} else {
	//        				chkMdtryCmdt = false;
	//        				prevCmdtRow = i;
	//        			}
	//        		}
	        		
	//        		if(i == 3) break;
	        		
	        		// SVC Lane Check.
	        		var vsl_slan_cd = sheetObj.CellValue(i, "vsl_slan_cd");
	        		if (vsl_slan_cd != "") {
	        			chkMdtrySvcLane = true;	
	                    if (vsl_slan_cd.length == 3) {
	//                        formObj.f_cmd.value = COMMAND26;
	//                        var param = "&cd=" + vsl_slan_cd;
	//        				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//        				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//        				
	//                        if (arrData == null || arrData.length <= 0) {
	//                            add2Tooltip(i, "vsl_slan_cd", ComGetMsg("PRI00335", "SVC Lane"));
	//                            isClear = false;
	//                        }
	        				
	                    } else {
	                        add2Tooltip(i, "vsl_slan_cd", ComGetMsg("PRI00314", "SVC Lane"));
	                        isClear = false;
	                    }
	                } 
	//        		else {
	//                    add2Tooltip(i, "vsl_slan_cd", ComGetMsg("PRI00335", "SVC Lane"));
	//                    isClear = false;
	//                }
	        		
	        		
	        		// Commodity Check.
	        		var cmdtCode = sheetObj.CellValue(i, "prc_cmdt_def_cd");
	        		var cmdtDesc = sheetObj.CellValue(i, "prc_cmdt_def_nm");
	        		if (cmdtCode != "" || cmdtDesc != "") {
	                    chkMdtryCmdt = true;
	                    if (cmdtCode != "") {
	            			if (cmdtCode.length == 6) {
	//            				formObj.f_cmd.value = SEARCH08;
	//            				var param = "&cd=" + cmdtCode;
	//            				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//            				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
	//                                isClear = false;
	//                            }
	            			} else if (cmdtCode.length == 5) {
	//            				formObj.f_cmd.value = SEARCH10;
	//            				var param = "&cd=" + cmdtCode + "&nm=cmpb" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value + "&etc3=" + formObj.gline_seq.value;
	//            				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//            				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }
	            			} else if (cmdtCode.length == 4) {
	//            				formObj.f_cmd.value = COMMAND29;
	//            				var param = "&cd=" + cmdtCode;
	//            				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//            				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }    
	            			} else {
	                            add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00314", "4 ~ 6"));
	                            isClear = false;
	            			}
	                    }
	                    else if (cmdtCode == "" && cmdtDesc != "") {
	                        add2Tooltip(i, "prc_cmdt_def_cd", ComGetMsg("PRI00335", "Commodity Code"));
	                        isClear = false;
	                    }
	        		}
	        		
	        		
	        		// Origin Point Check.
	        		var orgPntCode = sheetObj.CellValue(i, "org_rout_pnt_loc_def_cd");
	        		var orgPntDesc = sheetObj.CellValue(i, "org_rout_pnt_loc_def_nm");
	        		var orgPntTerm = sheetObj.CellValue(i, "org_rcv_de_term_nm");
	        		
	                if (orgPntCode != "" || orgPntDesc != "" || orgPntTerm != "" || sheetObj.CellText(i, "org_rcv_de_term_nm").trim() != "") {
	                    chkMdtryOrgPnt = true;
	
	                    if (orgPntCode != "") {
	                        if (orgPntCode.length == 5) {
	//                            formObj.f_cmd.value = SEARCH05;
	//                            var param = "&cd=" + orgPntCode;
	//                            var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }
	                        } else if (orgPntCode.length == 4) {
	//                        	formObj.f_cmd.value = SEARCH11;
	//                        	var param = "&cd=" + orgPntCode + "&nm=cmpb" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value + "&etc3=" + formObj.gline_seq.value;
	//                            var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }
	                        } else if (orgPntCode.length == 3) {
	//                        	formObj.f_cmd.value = COMMAND08;
	//                        	var param = "&cd=" + orgPntCode ;
	//                        	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }    
	                        } else if (orgPntCode.length == 2) {
	//                        	formObj.f_cmd.value = SEARCH07;
	//                        	var param = "&cd=" + orgPntCode;
	//                        	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }        
	                        } else {
	                            add2Tooltip(i, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "2 ~ 5"));
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
	
	                }
	                
	                
	        		// Origin Via Check.
	        		var orgViaCode = sheetObj.CellValue(i, "org_rout_via_port_def_cd");
	
	                if (orgViaCode != "") {
	                    chkMdtryOrgVia = true;
	
	                    if (orgViaCode.length == 5) {
	//                        formObj.f_cmd.value = SEARCH05;
	//                        var param = "&cd=" + orgViaCode;
	//                        var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                        if (arrData == null || arrData.length <= 0) {
	//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
	//                            isClear = false;
	//                        }
	                    } else if (orgViaCode.length == 4) {
	//                    	formObj.f_cmd.value = SEARCH11;
	//                    	var param = "&cd=" + orgViaCode + "&nm=cmpb" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value + "&etc3=" + formObj.gline_seq.value;
	//                    	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                        if (arrData == null || arrData.length <= 0) {
	//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
	//                            isClear = false;
	//                        }
	                    } else if (orgViaCode.length == 3) {
	//                    	formObj.f_cmd.value = COMMAND08;
	//                    	var param = "&cd=" + orgViaCode ;
	//                    	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                        if (arrData == null || arrData.length <= 0) {
	//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
	//                            isClear = false;
	//                        }
	                    } else if (orgViaCode.length == 2) {
	//                    	formObj.f_cmd.value = SEARCH07;
	//                    	var param = "&cd=" + orgViaCode;
	//                    	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                        if (arrData == null || arrData.length <= 0) {
	//                            add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00315"));
	//                            isClear = false;
	//                        }    
	                    } else {
	                        add2Tooltip(i, "org_rout_via_port_def_cd", ComGetMsg("PRI00314", "2 ~ 5"));
	                        isClear = false;
	                    }
	                }
	                
	        		// Destination Via Check.
	        		var destViaCode = sheetObj.CellValue(i, "dest_rout_via_port_def_cd");
	                if (destViaCode != "") {
	                    chkMdtryDestVia = true;
	                    
	                    if (destViaCode.length == 5) {
	//                        formObj.f_cmd.value = SEARCH05;
	//                        var param = "&cd=" + destViaCode;
	//                        var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                        if (arrData == null || arrData.length <= 0) {
	//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
	//                            isClear = false;
	//                        }
	                    } else if (destViaCode.length == 4) {
	//                    	formObj.f_cmd.value = SEARCH11;
	//                    	var param = "&cd=" + destViaCode + "&nm=cmpb" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value + "&etc3=" + formObj.gline_seq.value;
	//                    	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                        
	//                        if (arrData == null || arrData.length <= 0) {
	//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
	//                            isClear = false;
	//                        }
	                    } else if (destViaCode.length == 3) {
	//                    	formObj.f_cmd.value = COMMAND08;
	//                    	var param = "&cd=" + destViaCode ;
	//                    	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                        
	//                        if (arrData == null || arrData.length <= 0) {
	//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
	//                            isClear = false;
	//                        }
	                    } else if (destViaCode.length == 2) {
	//                    	formObj.f_cmd.value = SEARCH07;
	//                    	var param = "&cd=" + destViaCode;
	//                    	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                        
	//                        if (arrData == null || arrData.length <= 0) {
	//                            add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00315"));
	//                            isClear = false;
	//                        }
	                    } else {
	                        add2Tooltip(i, "dest_rout_via_port_def_cd", ComGetMsg("PRI00314", "2 ~ 5"));
	                        isClear = false;
	                    }
	                }
	                
	
	        		// Destination Point Check.
	        		var destPntCode = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_cd");
	        		var destPntDesc = sheetObj.CellValue(i, "dest_rout_pnt_loc_def_nm");
	        		var destPntTerm = sheetObj.CellValue(i, "dest_rcv_de_term_nm");
	        		
	                if (destPntCode != "" || destPntDesc != "" || destPntTerm != "" || sheetObj.CellText(i, "dest_rcv_de_term_nm").trim() != "") {
	                    chkMdtryDestPnt = true;
	                    if (destPntCode != "") {
	                    	
	                        if (destPntCode.length == 5) {
	//                            formObj.f_cmd.value = SEARCH05;
	//                            var param = "&cd=" + destPntCode;
	//                            var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }
	                        } else if (destPntCode.length == 4) {
	//                        	formObj.f_cmd.value = SEARCH11;
	//                        	var param = "&cd=" + destPntCode + "&nm=cmpb" + "&etc1=" + formObj.svc_scp_cd.value + "&etc2=" + formObj.cre_ofc_cd.value + "&etc3=" + formObj.gline_seq.value;
	//                        	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }
	                        } else if (destPntCode.length == 3) {
	                        	
	//                        	formObj.f_cmd.value = COMMAND08;
	//                        	var param = "&cd=" + destPntCode;
	//                        	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	////                            alert("arrData : " + arrData.length)
	////                            alert("arrData[1] : " + arrData[1])
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }
	                        } else if (destPntCode.length == 2) {
	//                        	formObj.f_cmd.value = SEARCH07;
	//                        	var param = "&cd=" + destPntCode;
	//                        	var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
	//                            var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	//                            
	//                            if (arrData == null || arrData.length <= 0) {
	//                                add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00315"));
	//                                isClear = false;
	//                            }
	                        } else {
	                            add2Tooltip(i, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00314", "2 ~ 5"));
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
	
	                }
	        		
	        		// Rate Mendatory Check.
	        		if (sheetObj.CellValue(i, "rout_dp_seq") != "") {
	        			if (!chkMdtryRate) {
	//        				add2Tooltip(prevRouteRowRate, "rat_ut_cd", ComGetMsg("PRI00316", "Rate"));
	//        				add2Tooltip(prevRouteRowRate, "prc_cgo_tp_cd", ComGetMsg("PRI00316", "Rate"));
	        				add2Tooltip(prevRouteRowRate, "curr_cd", ComGetMsg("PRI00316", "Rate"));
	        				add2Tooltip(prevRouteRowRate, "cmpb_amt", ComGetMsg("PRI00316", "Rate"));
	        				add2Tooltip(prevRouteRowRate, "mqc_rng_fm_qty", ComGetMsg("PRI00316", "Rate"));
	        				add2Tooltip(prevRouteRowRate, "mqc_rng_to_qty", ComGetMsg("PRI00316", "Rate"));
	        				isClear = false;
	                        prevRouteRowRate = i;
	        			} else {
	        				chkMdtryRate = false;
	        				prevRouteRowRate = i;
	        			}
	        		}
	        		
	        		// Rate Check.
	                var perTypeCode = sheetObj.CellValue(i, "rat_ut_cd");
	                var cargoTypeCode = sheetObj.CellValue(i, "prc_cgo_tp_cd");
	                var currCd = sheetObj.CellValue(i, "curr_cd");
	                var cmpbAmt = sheetObj.CellValue(i, "cmpb_amt");
	                var fmQty = sheetObj.CellValue(i, "mqc_rng_fm_qty");
	                var toQty = sheetObj.CellValue(i, "mqc_rng_to_qty");
	                
	        		if (perTypeCode != "" || cargoTypeCode != "" || currCd != "" || cmpbAmt != "" || fmQty != "" || toQty != "") {
	        		    chkMdtryRate = true;
	//        			if (perTypeCode == "") {
	//        				add2Tooltip(i, "rat_ut_cd", ComGetMsg("PRI00335", "PER"));
	//        				isClear = false;
	//        			}
	//        			
	//        			if (cargoTypeCode == "") {
	//        				add2Tooltip(i, "prc_cgo_tp_cd", ComGetMsg("PRI00335", "Cargo Type"));
	//        				isClear = false;
	//        			}
	        			
	        			if (perTypeCode != "" && cargoTypeCode != "") {
	        				
	    	            	var validPerClass = "A,F,O,Q,S,P";
	    	                var perClass = perTypeCode.charAt(0);
	    	                if (validPerClass.indexOf(perClass) > 0 && cargoTypeCode != "AK") {
	            				add2Tooltip(i, "prc_cgo_tp_cd", ComGetMsg("PRI08003"));
	            				isClear = false;
	    	                }
	        	            
	        				
	        	            if (cargoTypeCode == "AK") {
	        	            	var perClass = perTypeCode.charAt(0);
	        	                if (validPerClass.indexOf(perClass) < 0) {
	                				add2Tooltip(i, "prc_cgo_tp_cd", ComGetMsg("PRI08003"));
	                				isClear = false;
	        	                }
	        	            }
	        			}
	        			
	        			if (currCd == "") {
	        				add2Tooltip(i, "curr_cd", ComGetMsg("PRI00335", "Curr."));
	        				isClear = false;
	        			}
	        			
	        			if (cmpbAmt == "") {
	        				add2Tooltip(i, "cmpb_amt", ComGetMsg("PRI00335", "Rate"));
	        				isClear = false;
	//        			} else if (cmpbAmt != "" && parseFloat(cmpbAmt) < 0.00) {
	//        				add2Tooltip(i, "cmpb_amt", ComGetMsg("PRI00321", "Rate", "0"));
	//        				isClear = false;
	        			} else if (cmpbAmt != "" && parseFloat(cmpbAmt) > 9999999.99) {
	        				add2Tooltip(i, "cmpb_amt", ComGetMsg("PRI00336", "Rate", "9999999.99"));
	        				isClear = false;
	        			} 
	
	        			if (fmQty == "") {
	        				add2Tooltip(i, "mqc_rng_fm_qty", ComGetMsg("PRI00335", "MQC(Min.)"));
	        				isClear = false;
	        			} else if (fmQty != "" && parseInt(fmQty) < 0) {
	        				add2Tooltip(i, "mqc_rng_fm_qty", ComGetMsg("PRI00321", "MQC(Min.)", "0"));
	        				isClear = false;
	        			} else if (fmQty != "" && parseInt(fmQty) > 999999) {
	        				add2Tooltip(i, "mqc_rng_fm_qty", ComGetMsg("PRI00336", "MQC(Min.)", "999999"));
	        				isClear = false;
	        			}
	        			if (toQty == "") {
	        				add2Tooltip(i, "mqc_rng_to_qty", ComGetMsg("PRI00335", "MQC(Max.)"));
	        				isClear = false;
	        			} else if (toQty != "" && parseInt(toQty) < 0) {
	        				add2Tooltip(i, "mqc_rng_to_qty", ComGetMsg("PRI00321", "MQC(Max.)", "0"));
	        				isClear = false;
	        			} else if (toQty != "" && parseInt(toQty) > 999999) {
	        				add2Tooltip(i, "mqc_rng_to_qty", ComGetMsg("PRI00336", "MQC(Max.)", "999999"));
	        				isClear = false;
	        			}
	        		}
	        		
	        		
	        	}
	//			if (!chkMdtryCmdt) {
	//				add2Tooltip(prevCmdtRow, "prc_cmdt_def_cd", ComGetMsg("PRI00316", "Commodity Group"));
	//				isClear = false;
	//			}
	//			if (!chkMdtryOrgPnt) {
	//				add2Tooltip(prevRouteRowOPnt, "org_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Origin Point"));
	//				isClear = false;
	//			}
	//			if (isOViaMandatory && !chkMdtryOrgVia) {
	//				add2Tooltip(prevRouteRowOVia, "org_rout_via_port_def_cd", ComGetMsg("PRI00316", "Origin Via"));
	//				isClear = false;
	//			}
	//			if (isDViaMandatory && !chkMdtryDestVia) {
	//				add2Tooltip(prevRouteRowDVia, "dest_rout_via_port_def_cd", ComGetMsg("PRI00316", "Destination Via"));
	//				isClear = false;
	//			}
	//			if (!chkMdtryDestPnt) {
	//				add2Tooltip(prevRouteRowDPnt, "dest_rout_pnt_loc_def_cd", ComGetMsg("PRI00316", "Destination Point"));
	//				isClear = false;
	//			}
				if (!chkMdtryRate) {
	//				add2Tooltip(prevRouteRowRate, "rat_ut_cd", ComGetMsg("PRI00316", "Rate"));
	//				add2Tooltip(prevRouteRowRate, "prc_cgo_tp_cd", ComGetMsg("PRI00316", "Rate"));
					add2Tooltip(prevRouteRowRate, "curr_cd", ComGetMsg("PRI00316", "Rate"));
					add2Tooltip(prevRouteRowRate, "cmpb_amt", ComGetMsg("PRI00316", "Rate"));
					add2Tooltip(prevRouteRowRate, "mqc_rng_fm_qty", ComGetMsg("PRI00316", "Rate"));
					add2Tooltip(prevRouteRowRate, "mqc_rng_to_qty", ComGetMsg("PRI00316", "Rate"));
					isClear = false;
				}
				
	            formObj.f_cmd.value = SEARCH01;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
	            var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_6002GS.do", sParam);
	            var arrErr = ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
	            
	            if (arrErr != null && arrErr.length > 0) {
	            	isClear = false;
	            	var msg = ComGetMsg("PRI00315");
	            	for (var i = 0; i < arrErr.length; i++) {
	            		add2Tooltip(parseInt(arrErr[i][0]) + sheetObj.HeaderRows, arrErr[i][1], msg);
	            	}
	            }
            
	            ComOpenWait(false);
            
        	} catch (e) {
	            if (e == "[object Error]") {
	                ComShowMessage(OBJECT_ERROR);
	            } else {
	                ComShowMessage(e);
	            }
	       } finally {
	    	   ComOpenWait(false);
	       }
	       
	       
			document.body.scroll = "no";
        	
        	if (isClear) {
	        	toggleButtons("CHECK");
	            return true;
        	} else {
	        	toggleButtons("LOAD");
	        	selectCheckedCell();
	            return false;
        	}
            break;
            
        case IBSAVE: // 저장
            if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
                return false;
            }
        	
            return true;
            break;
        }
    }
    
    
 
    
    /**
     * tooltip을 제거한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     clearTooltip()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function clearTooltip() {
    	var sheetObj = sheetObjects[0];
    	
    	for (var i = sheetObj.HeaderRows, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {
    		for (var j = 0; j <= sheetObj.LastCol; j++) {
    			sheetObj.CellBackColor(i, j) = sheetObj.EditableColor ;
    			sheetObj.ToolTipText(i, j) = "";
    			
    			//공백문자를 제거한다.
    			if(ComIsEmpty(sheetObj.CellValue(i, j))) {
    				sheetObj.CellValue(i, j) = "";
    			}
    		}
    	}
    }
    
    /**
     * tooltip을 생성한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     add2Tooltip(row, col, msg)
     * </pre>
     * @param {int} row
     * @param {int} col
     * @param {String} msg 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function add2Tooltip(row, col, msg) {
    	var sheetObj = sheetObjects[0];

    	sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,0,0);
    	sheetObj.ToolTipText(row, col) +="\n- " +  msg;
    }
    
  
    /**
     * ckeck 후 check 된 컬럼을 찾아 선택한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     clearTooltip()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function selectCheckedCell() {
    	var sheetObj = sheetObjects[0];
    	
    	for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i < sheetObj.LastRow; i++) {
    		for (var j = 0; j <= sheetObj.LastCol; j++) {
    			if(sheetObj.ToolTipText(i, j) != "") {
    				sheetObj.SelectCell(i, j);
    				return;
    			}
    		}
    	}
    }
    
	
    /**
     * 버튼을 활성화 또는 비활성화한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(step)
     * </pre>
     * @param {String} step 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function toggleButtons(step) {
        switch (step) {
        case "INIT":
        	enableButton("btn_openfile");
            disableButton("btn_check");
            disableButton("btn_save");
            break;
        case "LOAD":
        	enableButton("btn_openfile");
        	enableButton("btn_check");
            disableButton("btn_save");
            break;
        case "CHECK":
        	enableButton("btn_openfile");
        	enableButton("btn_check");
        	enableButton("btn_save");
            break;
        }
    }
