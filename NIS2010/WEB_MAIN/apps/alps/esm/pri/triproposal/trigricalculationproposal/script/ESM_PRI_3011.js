/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3011.js
*@FileTitle : TRI GRI Calculation - Commodity Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.10 박성수
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
    function ESM_PRI_3011() {
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
			
			case "btn_add":
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
	
			case "btn_delete":
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
				break;
	
            case "btn_ok":
            	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
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
		
		if (document.form.gri_appl_flg.value == "Y") {
			for (var i = 0; i < sheetObjects.length; i++) {
				sheetObjects[i].Editable = false;
			}
    		disableButton("btn_add");
    		disableButton("btn_delete");
    		disableButton("btn_ok");
		}

        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
				style.height = 120;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);
	
				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "|Sel.|Seq.|trf_pfx_cd|trf_no|GRI Group Seq.|cmdt_seq|Commodity Code|Description";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false, false)
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
				// SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
				InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "Seq");
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "trf_pfx_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "trf_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "gri_grp_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtPopupEdit, 120, daCenter, false, "cmdt_cd", true, "", dfNone, 0, true, true, 6);
                InitDataProperty(0, cnt++, dtData, 250, daLeft, false, "cmdt_nm", true, "", dfNone, 0, false, false);
	
				InitDataValid(0, "cmdt_cd", vtEngUpOther, "0123456789");	// 영대문자,숫자만 입력
                ShowButtonImage = 2;

			}
			break;
	
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
		
		if (colName == "cmdt_cd") {
			if (Value.length == 6) {
				formObj.f_cmd.value = SEARCH08;
				var param = "&cd=" + Value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "cmdt_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "cmdt_nm") = "";
		    		sheetObj.CellValue2(Row, "cmdt_cd") = "";
		    		sheetObj.SelectCell(Row, "cmdt_cd", false);
		    		
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, "cmdt_nm") = "";
	    		sheetObj.CellValue2(Row, "cmdt_cd") = "";
	    		sheetObj.SelectCell(Row, "cmdt_cd", false);
	    		
	    		return false;
			}
		}
	}
	
	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
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
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "cmdt_cd") {
			if (sheetObj.CellEditable(Row, "cmdt_cd")) {
				var sUrl = "/hanjin/ESM_PRI_4027.do?" + FormQueryString(document.form);
				sUrl += "&grp_cd=" + PRI_SP_SCP + "&commodity_cmd=CR&prc_cmdt_tp_cd=C&multi_yn=Y";
	
				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 320, true);
	
				if (rtnVal != null && rtnVal.length > 0) {
					for (var i = 0; i < rtnVal.length; i++) {
						if (i == 0) {
							sheetObj.CellValue2(Row, "cmdt_cd") = rtnVal[i].cd;
							sheetObj.CellValue2(Row, "cmdt_nm") = rtnVal[i].nm;
						} else {
							var idx = sheetObj.DataInsert();
	
							sheetObj.CellValue(idx, "trf_pfx_cd") = formObj.trf_pfx_cd.value;
							sheetObj.CellValue(idx, "trf_no") = formObj.trf_no.value;
							sheetObj.CellValue(idx, "gri_grp_seq") = formObj.gri_grp_seq.value;
							sheetObj.CellValue(idx, "cmdt_seq") = parseInt(ComPriGetMax(sheetObj, "cmdt_seq")) + 1;
							sheetObj.CellValue2(idx, "cmdt_cd") = rtnVal[i].cd;
							sheetObj.CellValue2(idx, "cmdt_nm") = rtnVal[i].nm;
						}
					}
				}
			}
		}
	}
	
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * 
	 * @param {ibsheet}
	 *            sheetObj 필수 IBSheet Object
	 * @param {form}
	 *            formObj 필수 html form object
	 * @param {int}
	 *            sAction 필수 프로세스 플래그 상수
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
			
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	        	sheetObj.ColumnSort("cmdt_cd", "ASC", "ASC", true);
	        	
				var sXml = ComPriSheet2Xml(sheetObj);
				dialogArguments.setSheetXml(sXml, 2);
	
	            window.returnValue = "O";
	            window.close();
	            
	            break; 
				
			case IBSEARCH: // parent sheet에서 조회
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
				var sXml = dialogArguments.getSheetXml(2);
				sheetObj.LoadSearchXml(sXml);
				
				sheetObj.ColumnSort("cmdt_cd", "ASC", "ASC", true);
				
	         	break; 	
		
			case IBINSERT: // 입력
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
		        var idx = sheetObj.DataInsert();		
	 			
	            sheetObj.CellValue(idx, "trf_pfx_cd") = formObj.trf_pfx_cd.value;
	            sheetObj.CellValue(idx, "trf_no") = formObj.trf_no.value;
	            sheetObj.CellValue(idx, "gri_grp_seq") = formObj.gri_grp_seq.value;
	            sheetObj.CellValue(idx, "cmdt_seq") = parseInt(ComPriGetMax(sheetObj, "cmdt_seq"))+ 1;
	            
	            sheetObj.SelectCell(idx, "cmdt_cd", false);
			
				break;
		
			case IBDELETE: // 삭제
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	            
	        	deleteRowCheck(sheetObj, "chk");
				
				break;
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }
	}
	
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
	 * @version 2009.05.01
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
            
        case IBSEARCH: // 조회
        	if (formObj.trf_pfx_cd.value == "" || formObj.trf_no.value == "") {
                return false;
            }
        	
            return true;
            break;
    
        case IBSAVE: // 저장
        	if (formObj.trf_pfx_cd.value == "" || formObj.trf_no.value == "") {
                return false;
            }
            if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
                return false;
            }

        	var dupRow = sheetObj.ColValueDup("cmdt_cd", false);
        	if (dupRow >= 0) {
        		sheetObj.SelectRow = dupRow;
				ComShowCodeMessage("PRI00302");
				return false;
        	}
        	
            return true;
            break;
    
        case IBINSERT: // Row Add
        	if (formObj.trf_pfx_cd.value == "" || formObj.trf_no.value == "") {
                return false;
            }
            
            return true;
            break;
    
        case IBDELETE: // Delete
        	if (formObj.trf_pfx_cd.value == "" || formObj.trf_no.value == "") {
                return false;
            }
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	
        	return true;
            break;
        }
    }
