/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0094.js
*@FileTitle : Direct Call Amend Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.12 박성수
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
    function ESM_PRI_0094() {
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
    
    var exTransaction = false;
	
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
				
			case "btn_amend":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC11);
				break;

			case "btn_amendcancel":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC12);
				break;
	
			case "btn_accept":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC13);
				break;
	
			case "btn_acceptcancel":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC14);
				break;
	
			case "btn_ok":
				if (formObject.prc_prop_sts_cd.value == "I" || formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
				} else {
					window.close();
				}
				break;
	
			case "btn_close":
				if (formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
				} else {
					window.close();
				}
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
		
        if (document.form.amdt_seq.value == "0") {
        	hiddenButton("btn_amend");
        	hiddenButton("btn_amendcancel");
        } else {
        	showButton("btn_amend");
        	showButton("btn_amendcancel");
        }
        
    	if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I") {
        	enableButton("btn_amend");
        	enableButton("btn_amendcancel");
    	} else {
    		disableButton("btn_amend");
    		disableButton("btn_amendcancel");
    	}
    	if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q") {
        	enableButton("btn_accept");
        	enableButton("btn_acceptcancel");
    	} else {
            disableButton("btn_accept");
            disableButton("btn_acceptcancel");
    	}
    	
    	if ((!bIsReqUsr && !bIsAproUsr) || dialogArguments.isCMDTGroupDeleted()) {
    		for (i = 0; i < sheetObjects.length; i++) {
    			sheetObjects[i].Editable = false;
    		}
    	}
		
		//doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); 
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
				style.height = 80;
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
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle = "|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|Direct Call|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User";
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
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_no", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "amdt_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "gen_spcl_rt_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 80, daCenter, false, "dir_call_flg", true, "", dfNone, 0, true, true, 2);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
	
				InitDataCombo(0, "dir_call_flg", "Y|N/A", "Y|N");
                ShowButtonImage = 2;

			}
			break;
	
		}
	}
	
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
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
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
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
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
		
        case IBSEARCH_ASYNC11: // Amend
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
        	
        	var idx = dialogArguments.doRowAmend(sheetObj, "AM");
        	// Amend시 Flag를 반대상태로 변경하여 Amemd하고 ReadOnly로 고정. 2009-07-02.
        	sheetObj.CellValue(idx, "dir_call_flg") = sheetObj.CellValue(idx, "dir_call_flg") == "Y" ? "N" : "Y";
        	
        	setSheetStyle(sheetObj, idx - 1);
        	setSheetStyle(sheetObj, idx);
        	            
            break;
        case IBSEARCH_ASYNC12: // Amend Cancel
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
        	
        	var idx = dialogArguments.doRowAmendCancel(sheetObj);
        	setSheetStyle(sheetObj, idx);
            
            break;
        case IBSEARCH_ASYNC13: // Accept
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
            
            if (!ComShowCodeConfirm("PRI00008")) {
            	return false;
            }
            
        	sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") = "A";
        	sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_nm") = "Accepted";
            
            formObj.f_cmd.value = MODIFY01;
            var sParam = FormQueryString(formObj);
    		var sSheetParam = sheetObj.GetSaveString();
            if (sSheetParam == "") {
                return false;
            }
            sParam += "&" + sSheetParam;
    
            var sXml = sheetObj.GetSaveXml("ESM_PRI_0094GS.do", sParam);
            sheetObj.LoadSaveXml(sXml);
            
            setSheetStyle(sheetObj, -1);
            
            exTransaction = true;
            dialogArguments.updateSummary();
            
            ComShowCodeMessage("PRI00108");
            break;
        case IBSEARCH_ASYNC14: // Accept Cancel
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
            
            if (!ComShowCodeConfirm("PRI00009")) {
            	return false;
            }
            
        	if (sheetObj.CheckedRows("chk") <= 0) {
        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
        	}
            
    		sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") = "I";
    		sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_nm") = "Initial";
            
            formObj.f_cmd.value = MODIFY02;
            var sParam = FormQueryString(formObj);
    		var sSheetParam = sheetObj.GetSaveString();
            if (sSheetParam == "") {
                return false;
            }
            sParam += "&" + sSheetParam;
    
            var sXml = sheetObj.GetSaveXml("ESM_PRI_0094GS.do", sParam);
            sheetObj.LoadSaveXml(sXml);
            
            setSheetStyle(sheetObj, -1);
            
            exTransaction = true;
            dialogArguments.updateSummary();
            
            ComShowCodeMessage("PRI00109");
            break;
        case IBSAVE: // OK
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
            
        	sheetObj.ColumnSort("amdt_seq", "ASC", "ASC", true);
        	
			var sXml = ComPriSheet2Xml(sheetObj);
			dialogArguments.setSheetXml(sXml, 10);
			
            window.returnValue = "O";
            window.close();
            
			if (exTransaction) {
				dialogArguments.restylingPagePostTr();
			}
            
            break; 
            
		case IBSEARCH: // parent sheet에서 조회
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
            
			var sXml = dialogArguments.getSheetXml(10);
			sheetObj.LoadSearchXml(sXml);
			
			sheetObj.ColumnSort("amdt_seq", "ASC", "ASC", true);
			
			setSheetStyle(sheetObj, -1);
         	break;
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
        try {
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
            
	        switch (sAction) {
	        case IBSEARCH_ASYNC11: // Amend
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount <= 0) {
	        		return false;
	        	}
	        	if (formObj.prc_prop_sts_cd.value != "I") {
	        		return false;
	        	}
	        	if (dialogArguments.isRouteGroupDeleted()) {
	        		return false;
	        	}
	        	
	        	if (sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI01011");
	        		return false;
	        	}
	        	
	            return true;
	            break;
	            
	        case IBSEARCH_ASYNC12: // Amend Cancel
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount <= 0) {
	        		return false;
	        	}
	        	if (formObj.prc_prop_sts_cd.value != "I") {
	        		return false;
	        	}
	        	if (dialogArguments.isRouteGroupDeleted()) {
	        		return false;
	        	}
	        	
	        	if (sheetObj.CellValue(sheetObj.SelectRow, "src_info_cd") != "AM" && sheetObj.CellValue(sheetObj.SelectRow, "src_info_cd") != "AD") {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI01012");
	        		return false;
	        	}
	        	if (sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") != "I") {
	        		ComShowCodeMessage("PRI01037");
	        		return false;
	        	}
	        	
	            return true;
	            break;
	            
	        case IBSEARCH_ASYNC13: // Accept
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount <= 0) {
	        		return false;
	        	}
	        	if (formObj.prc_prop_sts_cd.value != "Q") {
	        		return false;
	        	}
	        	
	    		if (sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
	    		}
	        	if (sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
				if (sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
	        	
	            return true;
	            break;
	            
	        case IBSEARCH_ASYNC14: // Accept Cancel
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount <= 0) {
	        		return false;
	        	}
	        	if (!bIsAproUsr || formObj.prc_prop_sts_cd.value != "Q") {
	        		return false;
	        	}
	        	
	    		if (sheetObj.CellValue(sheetObj.SelectRow, "prc_prog_sts_cd") != "A") {
					ComShowCodeMessage("PRI01038");
					return false;
	    		}
				if (sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq") != formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if (sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
	        	
	            return true;
	            break;
	            
	        case IBSEARCH: // 조회
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            } else {
	                return true;
	            }
	            break;
	    
	        case IBSAVE: // 저장
	            if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
	                return false;
	            }
	        	
	            return true;
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
	 * Sheet에서 조회 후, 색상이나 Strike등의 스타일을 처리하는 함수.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheetStyle(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	dialogArguments.setLineStyle(sheetObj, i);
            	setLineEnable(sheetObj, i);
            }
        } else {
        	dialogArguments.setLineStyle(sheetObj, idx);
        	setLineEnable(sheetObj, idx);
        }
    }
    
	/**
	 * Sheet에서 조회 후, Row별 각 컬럼이나 전체 Row의 Enable/Disable을 처리<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	
    	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    		&& document.form.prc_prop_sts_cd.value == "I"
        	&& sheetObj.CellValue(idx, "prc_prog_sts_cd") == "I"
    		&& sheetObj.CellValue(idx, "src_info_cd") != "AM"
    		&& sheetObj.CellValue(idx, "src_info_cd") != "AD") {
	        //sheetObj.CellEditable(idx, "dir_call_flg") = true;
    		// Amend시 Flag를 반대상태로 변경하여 Amemd하고 ReadOnly로 고정. 2009-07-02.
    		sheetObj.CellEditable(idx, "dir_call_flg") = true;
		} else {
        	sheetObj.CellEditable(idx, "dir_call_flg") = false;
		}
    }