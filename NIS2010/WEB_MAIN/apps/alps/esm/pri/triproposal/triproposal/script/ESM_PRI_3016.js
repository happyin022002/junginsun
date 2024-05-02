/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_3016.js
*@FileTitle : TRI Creation & Amendment - Route Point
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.06.10 박성수
* 1.0 Creation
=========================================================
* History
* 2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
    function ESM_PRI_3016() {
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
    
    var beforeIndex = -1;
    
    var curPntViaType = "";
    var curOrgDestType = "";
	
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
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBINSERT);
				break;
	
			case "btn_delete":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBDELETE);
				break;
	
			case "btn_ok":
				if (bIsReqUsr
			    		&& document.form.amdt_seq.value == "0"
			    		&& document.form.prop_sts_cd.value == "I") {
					doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSAVE);
				} else {
					window.close();
				}
				break;
	
			case "btn_close":
				window.close();
				break;
				
			case "rt_pnt":
				rtPntOnClick();
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
        
    	if (bIsReqUsr
    			&& document.form.prop_sts_cd.value == "I"
    			&& document.form.amdt_seq.value == "0") {
        	enableButton("btn_add");
        	enableButton("btn_delete");
    	} else {
    		disableButton("btn_add");
    		disableButton("btn_delete");
    	}
		
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); 
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        
        if (document.form.org_dest_tp_cd.value == "O" && document.form.pnt_via_tp_cd.value == "P") {
        	document.form.rt_pnt[0].checked = true;
        } else if (document.form.org_dest_tp_cd.value == "O" && document.form.pnt_via_tp_cd.value == "V") {
        	document.form.rt_pnt[1].checked = true;
        } else if (document.form.org_dest_tp_cd.value == "D" && document.form.pnt_via_tp_cd.value == "V") {
        	document.form.rt_pnt[2].checked = true;
        } else if (document.form.org_dest_tp_cd.value == "D" && document.form.pnt_via_tp_cd.value == "P") {
        	document.form.rt_pnt[3].checked = true;
        }
        rtPntOnClick();
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
				style.height = 140;
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
				
				var HeadTitle = "|Sel.|Seq.|tri_prop_no|org_dest_tp_cd|rout_pnt_seq|Location Code|Description|Term|Trans Mode";
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
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "tri_prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_pnt_loc_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 180, daLeft, false, "rout_pnt_loc_nm", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "rcv_de_term_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo, 75, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, true, true);
	
				//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
				InitDataValid(0, "rout_pnt_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

                ShowButtonImage = 2;

			}
			break;
			
		case 2: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 140;
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
				
				var HeadTitle = "|Sel.|Seq.|tri_prop_no|org_dest_tp_cd|rout_via_seq|Location Code|Description";
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
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "tri_prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_via_port_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 180, daLeft, false, "rout_via_port_nm", true, "", dfNone, 0, false, false);
	
				//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
				InitDataValid(0, "rout_via_port_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

                ShowButtonImage = 2;

			}
			break;
			
		case 3: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 140;
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
				
				var HeadTitle = "|Sel.|Seq.|tri_prop_no|org_dest_tp_cd|rout_via_seq|Location Code|Description";
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
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "tri_prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_via_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_via_port_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 180, daLeft, false, "rout_via_port_nm", true, "", dfNone, 0, false, false);
	
				//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
				InitDataValid(0, "rout_via_port_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

                ShowButtonImage = 2;

			}
			break;
			
		case 4: // sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 140;
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
				
				var HeadTitle = "|Sel.|Seq.|tri_prop_no|org_dest_tp_cd|rout_pnt_seq|Location Code|Description|Term|Trans Mode";
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
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "tri_prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_pnt_seq", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "rout_pnt_loc_cd", true, "", dfNone, 0, true, true, 5);
				InitDataProperty(0, cnt++, dtData, 180, daLeft, false, "rout_pnt_loc_nm", true, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtCombo, 60, daCenter, false, "rcv_de_term_cd", true, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtCombo, 75, daCenter, false, "prc_trsp_mod_cd", false, "", dfNone, 0, true, true);
	
				//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
				InitDataValid(0, "rout_pnt_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

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
		
		if (colName == "rout_pnt_loc_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "rout_pnt_loc_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "rout_pnt_loc_nm") = "";
		    		sheetObj.CellValue2(Row, "rout_pnt_loc_cd") = "";
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_cd", false);
		    		
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, "rout_pnt_loc_nm") = "";
	    		sheetObj.CellValue2(Row, "rout_pnt_loc_cd") = "";
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_cd", false);
	    		
	    		return false;
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
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "rout_via_port_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value = SEARCH05;
				var param = "&cd=" + Value;
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.CellValue2(Row, "rout_via_port_nm") = arrData[1];
				} else {
					sheetObj.CellValue2(Row, "rout_via_port_nm") = "";
		    		sheetObj.CellValue2(Row, "rout_via_port_cd") = "";
		    		sheetObj.SelectCell(Row, "rout_via_port_cd", false);
		    		
		    		return false;
				}
			} else {
				sheetObj.CellValue2(Row, "rout_via_port_nm") = "";
	    		sheetObj.CellValue2(Row, "rout_via_port_cd") = "";
	    		sheetObj.SelectCell(Row, "rout_via_port_cd", false);
	    		
	    		return false;
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
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		sheet2_OnChange(sheetObj, Row, Col, Value)
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
	function sheet4_OnChange(sheetObj, Row, Col, Value) {
		sheet1_OnChange(sheetObj, Row, Col, Value)
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
		
		if (colName == "rout_pnt_loc_cd") {
			if (sheetObj.CellEditable(Row, "rout_pnt_loc_cd")) {
	            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_SP_SCP + "&location_cmd=L&loc_tp_cd=L";

				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
				if (rtnVal != null){
					sheetObj.CellValue2(Row, "rout_pnt_loc_cd") = rtnVal.cd;
					sheetObj.CellValue2(Row, "rout_pnt_loc_nm") = rtnVal.nm;
				}
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
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "rout_via_port_cd") {
			if (sheetObj.CellEditable(Row, "rout_via_port_cd")) {
	            var sUrl = "/hanjin/ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_SP_SCP + "&location_cmd=L&loc_tp_cd=L";

				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
				if (rtnVal != null){
					sheetObj.CellValue2(Row, "rout_via_port_cd") = rtnVal.cd;
					sheetObj.CellValue2(Row, "rout_via_port_nm") = rtnVal.nm;
				}
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
	function sheet3_OnPopupClick(sheetObj, Row, Col) {
		sheet2_OnPopupClick(sheetObj, Row, Col);
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
	function sheet4_OnPopupClick(sheetObj, Row, Col) {
		sheet1_OnPopupClick(sheetObj, Row, Col);
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
			
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            for (var a = 0; a <= 3; a++) {
	            	if (a == 0 || a == 3) {
	            		sheetObjects[a].ColumnSort("rout_pnt_loc_cd|rcv_de_term_cd|prc_trsp_mod_cd", "ASC", "ASC|ASC|ASC", true);
	            	} else if (a == 1 || a == 2) {
	            		sheetObjects[a].ColumnSort("rout_via_port_cd", "ASC", "ASC", true);
	            	}
		        	
					var sXml = ComPriSheet2Xml(sheetObjects[a]);
					dialogArguments.setSheetXml(sXml, a + 2);
	            }
				
	            window.returnValue = "O";
	            window.close();
	            
	            break; 
	            
			case IBCLEAR: // 로딩시 코드조회
				var sXml = "";
	 			
				//공통 term
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
				setIBCombo(sheetObjects[0], sXml, "rcv_de_term_cd", true, 0);
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
				setIBCombo(sheetObjects[3], sXml, "rcv_de_term_cd", true, 0);
				
				//공통 trans mode
				formObj.f_cmd.value = SEARCH19;
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				setIBCombo(sheetObjects[0], sXml, "prc_trsp_mod_cd", true, 0);
				setIBCombo(sheetObjects[3], sXml, "prc_trsp_mod_cd", true, 0);
		
				break;
				
			case IBSEARCH: // parent sheet에서 조회
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            for (var a = 0; a <= 3; a++) {
					var sXml = dialogArguments.getSheetXml(a + 2);
					sheetObjects[a].LoadSearchXml(sXml);
					
	            	if (a == 0 || a == 3) {
	            		sheetObjects[a].ColumnSort("rout_pnt_loc_cd", "ASC", "ASC", true);
	            	} else if (a == 1 || a == 2) {
	            		sheetObjects[a].ColumnSort("rout_via_port_cd", "ASC", "ASC", true);
	            	}
					
					setSheetStyle(sheetObjects[a], -1);
	            }
	            
	         	break; 	
		
			case IBINSERT: // 입력
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
		        var idx = sheetObj.DataInsert();
	 			
	            sheetObj.CellValue(idx, "tri_prop_no") = formObj.tri_prop_no.value;
	            sheetObj.CellValue(idx, "org_dest_tp_cd") = curOrgDestType;
	            if (curPntViaType == "P") {
	            	sheetObj.CellValue(idx, "rout_pnt_seq") = parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1;
	            } else if (curPntViaType == "V") {
	            	sheetObj.CellValue(idx, "rout_via_seq") = parseInt(ComPriGetMax(sheetObj, "rout_via_seq"))+ 1;
	            }
	            
	            setSheetStyle(sheetObj, idx);
	            
	            sheetObj.SelectCell(idx, 6, false);
			
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
        	
        	return true;
            break;
    
        case IBSAVE: // 저장
        	if (!validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
        		return false;
        	}
        	
            return true;
            break;
            
        case IBSEARCH_ASYNC15: // 라디오버튼 이동시 Validation
            if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
                return false;
            }

        	var dupRow = -1;
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
        		dupRow = sheetObj.ColValueDup("rout_pnt_loc_cd|rcv_de_term_cd|prc_trsp_mod_cd", false);
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
        		dupRow = sheetObj.ColValueDup("rout_via_port_cd", false);
        	}
        	if (dupRow >= 0) {
        		sheetObj.SelectRow = dupRow;
				ComShowCodeMessage("PRI00302");
				return false;
        	}
        	
            return true;
            break;
    
        case IBINSERT: // Row Add
//        	if (formObj.tri_prop_no.value == "") {
//                return false;
//            }
        	if (formObj.prop_sts_cd.value != "I") {
        		return false;
        	}
            
            return true;
            break;
    
        case IBDELETE: // Delete
//        	if (formObj.tri_prop_no.value == "") {
//                return false;
//            }
        	if (sheetObj.RowCount <= 0) {
        		return false;
        	}
        	if (formObj.prop_sts_cd.value != "I") {
        		return false;
        	}
        	
        	return true;
            break;
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
            	if (sheetObj.RowStatus(i) == "D") {
            		sheetObj.RowHidden(i) = true;
            	}
            	setLineEnable(sheetObj, i);
            }
        } else {
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
    	
    	if (bIsReqUsr
	    		&& document.form.amdt_seq.value == "0"
	    		&& document.form.prop_sts_cd.value == "I"
	    		&& document.form.tri_no.value == "") {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_cd") = true;
	        	sheetObj.CellEditable(idx, "rcv_de_term_cd") = true;
	        	sheetObj.CellEditable(idx, "prc_trsp_mod_cd") = true;
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.CellEditable(idx, "rout_via_port_cd") = true;
        	}
        	enableButton("btn_add");
        	enableButton("btn_delete");
		} else {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        	sheetObj.CellEditable(idx, "rout_pnt_loc_cd") = false;
	        	sheetObj.CellEditable(idx, "rcv_de_term_cd") = false;
	        	sheetObj.CellEditable(idx, "prc_trsp_mod_cd") = false;
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.CellEditable(idx, "rout_via_port_cd") = false;
        	}
        	disableButton("btn_add");
        	disableButton("btn_delete");
		}
    }
    
	function rtPntOnClick() {
		var curIndex = parseInt(getRtPnt());
		
		if (beforeIndex != curIndex) {
			if (beforeIndex >= 0 && !validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
				document.form.rt_pnt[beforeIndex].checked = true;
				return false;
			}
			
			if (curIndex == 0) {
				curPntViaType = "P";
			    curOrgDestType = "O";
			} else if (curIndex == 1) {
				curPntViaType = "V";
			    curOrgDestType = "O";
			} else if (curIndex == 2) {
				curPntViaType = "V";
			    curOrgDestType = "D";
			} else if (curIndex == 3) {
				curPntViaType = "P";
			    curOrgDestType = "D";
			}
			
		    var objs = document.all.item("sheetLayer");
		    
		    document.form.rt_pnt[curIndex].focus();
		    objs[curIndex].style.display = "inline";
		    if (beforeIndex >= 0) {
				objs[beforeIndex].style.display = "none";
		    }
			
		    beforeIndex = curIndex;
		}
	}
	
    function getRtPnt() {
        for (var i = 0; i < document.form.rt_pnt.length; i++) {
            if (document.form.rt_pnt[i].checked) {
                return document.form.rt_pnt[i].value;
            }
        }
    }