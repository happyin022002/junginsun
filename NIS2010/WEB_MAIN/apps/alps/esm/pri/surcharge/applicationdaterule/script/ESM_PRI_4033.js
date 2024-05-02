/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_4033.js
 *@FileTitle : Application Date Rule Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.07.07
 *@LastModifier : 김민아
 *@LastVersion : 1.0
 * 2011.07.07 김민아
 * 1.0 Creation
=========================================================
* History
2011.07.07 김민아 [CHM-201112030-01] Application Date Rule Creation 시스템 개발 요청 (Pricing)
                                                                      추가요건 - 조회 조건으로 access date 추가. Duration 중복 조건에 포함하여 그 날짜가 포함관계에 있으면 중복으로 처리.
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
	 * @class ESM_PRI_4033 : ESM_PRI_4033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_PRI_4033() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.doActionIBSheet = doActionIBSheet;
		this.validateForm = validateForm;
	}
	
	/* 개발자 작업 */
	
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
	document.onclick = processButtonClick;
	
	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김민아
     * @version 2011.07.07
     */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		
		/** **************************************************** */
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
				case "btn_save":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
					break;
					
				case "btn_copy":
					doActionIBSheet(sheetObjects[0], formObject, IBCOPYROW);
					break;
					
				case "btn_add":
					doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
					break;
		
				case "btn_delete":
					doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
					break;
		
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[0], formObject, IBDOWNEXCEL);
					break;
					
				case "btns_calendar": //달력버튼
		            var cal = new ComCalendar();                
		            cal.select(formObject.eff_dt, 'yyyy-MM-dd');
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
     * @author 김민아
     * @version 2011.07.07
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
     * @author 김민아
     * @version 2011.07.07
     */
	function loadPage() {
	
		for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
	
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		document.form.eff_dt.focus();
		
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
     * @author 김민아
     * @version 2011.07.07
     */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetid = sheetObj.id;
	
		switch (sheetid) {
	           
			case "sheet1":
				with (sheetObj) {
					
					// 높이 설정
					style.height = 450;
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
					InitRowInfo(1, 1, 1, 100);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					
					var HeadTitle = "|scg_aply_dt_rule_seq|Scope|POR Type|POR|POL Type|POL|POD Type|POD|DEL Type|DEL|App.\nRule|Effective\nDate|Expiration\nDate|Updated\nStaff|Updated\nDate|Remark(s)";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN,
					// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 10, daCenter, false, "ibflag");
					
					InitDataProperty(0, cnt++, dtHidden,	20, daCenter, true, "scg_aply_dt_rule_seq",	false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtComboEdit, 45, daCenter, true, "svc_scp_cd", 			false, "", dfEngUpKey,	0, false, false, 3);
					InitDataProperty(0, cnt++, dtComboEdit, 69, daCenter, true, "por_tp_cd",  			false, "", dfNone, 		0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit,	62, daCenter, true, "por_def_cd", 			false, "", dfEngUpKey,	0, false, false, 5);
					InitDataProperty(0, cnt++, dtComboEdit, 69, daCenter, true, "pol_tp_cd",  			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit,	62, daCenter, true, "pol_def_cd", 			false, "", dfEngUpKey,	0, false, false, 5);
					InitDataProperty(0, cnt++, dtComboEdit, 69, daCenter, true, "pod_tp_cd",  			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit,	62, daCenter, true, "pod_def_cd", 			false, "", dfEngUpKey,	0, false, false, 5);
					InitDataProperty(0, cnt++, dtComboEdit, 69, daCenter, true, "del_tp_cd",  			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit,	62, daCenter, true, "del_def_cd", 			false, "", dfEngUpKey,	0, false, false, 5);
					InitDataProperty(0, cnt++, dtComboEdit,	45, daCenter, true, "aply_dt_rule_tp_cd", 	true,  "", dfEngUpKey,	0, false, false, 3);
					InitDataProperty(0, cnt++, dtPopupEditFormat,	80, daCenter, true, "eff_dt", 				true,  "", dfDateYmd,	0, true, true);
					InitDataProperty(0, cnt++, dtPopupEditFormat,	80, daCenter, true, "exp_dt", 				false, "", dfDateYmd,	0, true, true);
					InitDataProperty(0, cnt++, dtData, 		70, daCenter, true, "upd_usr_id", 			false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData, 		70, daCenter, true, "upd_dt", 				false, "", dfNone,		0, false, false);
					InitDataProperty(0, cnt++, dtData, 		60, daLeft,   true, "aply_dt_rmk",			false, "", dfNone,		0, true, true, 1000);
					
					InitDataValid(0, "svc_scp_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, "por_def_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, "pol_def_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, "pod_def_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, "del_def_cd", vtEngUpOther, "0123456789");
					InitDataValid(0, "aply_dt_rule_tp_cd", vtEngUpOnly);
					
					InitDataCombo(0, "svc_scp_cd", svcScpCdText, svcScpCdValue);
					InitDataCombo(0, "por_tp_cd", tpCdText, tpCdValue);
					InitDataCombo(0, "pol_tp_cd", tpCdText, tpCdValue);
					InitDataCombo(0, "pod_tp_cd", tpCdText, tpCdValue);
					InitDataCombo(0, "del_tp_cd", tpCdText, tpCdValue);
					InitDataCombo(0, "aply_dt_rule_tp_cd", applDtRuleText, applDtRuleValue);
					
					ImageList(0) = "img/btns_calendar.gif";
					PopupButtonImage(0, "eff_dt") = 0;
					PopupButtonImage(0, "exp_dt") = 0;
					
					AutoRowHeight = false;
					WaitImageVisible = false;
					
//					//영역 다중 선택 가능 여부 설정하기
//	                MultiSelection = false;
//	                 
//	                //MultiSelection=false 이면 1개의 행만 선택 가능 
//	                SelectionMode = smSelectionRow; //1
				}
				break;
				
			case "sheet2":
				with (sheetObj) {
					
					/*// 높이 설정
					style.height = 250;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					*/
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 1, 100);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
					
					var HeadTitle = "scg_aply_dt_rule_seq|Scope|POR|POL|POD|DEL|App.\nRule|Effective\nDate|Expiration\nDate";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN,
					// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					InitDataProperty(0, cnt++, dtData,	20, daCenter, true, "scg_aply_dt_rule_seq",	false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++, dtData, 	45, daCenter, true, "svc_scp_cd", 			false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++, dtData,	62, daCenter, true, "por_def_cd", 			false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++, dtData,	62, daCenter, true, "pol_def_cd", 			false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++, dtData,	62, daCenter, true, "pod_def_cd", 			false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++, dtData,	62, daCenter, true, "del_def_cd", 			false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++, dtData,	45, daCenter, true, "aply_dt_rule_tp_cd", 	false, "", dfNone,	0, false, false);
					InitDataProperty(0, cnt++, dtData,	80, daCenter, true, "eff_dt", 				false, "", dfDateYmd,	0, false, false);
					InitDataProperty(0, cnt++, dtData,	80, daCenter, true, "exp_dt", 				false, "", dfDateYmd,	0, false, false);
					
					AutoRowHeight = false;
					WaitImageVisible = false;
				}
				break;
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
     * @author 김민아
     * @version 2011.07.07
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		try{
			switch (sAction) {

			case IBSEARCH:
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
  				ComOpenWait(true); //->waiting->start
  				formObj.f_cmd.value = SEARCH01;
  				sheetObj.DoSearch("ESM_PRI_4033GS.do", FormQueryString(formObj));
  				ComOpenWait(false); //->waiting->End
				break;
				
			case IBSEARCH_ASYNC01:
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH02;
				var sParamSheet = sheetObj.GetSaveString(false);
				sheetObjects[1].DoSearch("ESM_PRI_4033GS.do", "f_cmd=" + formObj.f_cmd.value + "&" + sParamSheet);
				ComOpenWait(false);
				break;
				
			case IBSAVE:
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESM_PRI_4033GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
				break;
				
			case IBDELETE:
				var selRow = sheetObj.SelectRow;
				if(sheetObj.CellValue(selRow, "scg_aply_dt_rule_seq") == ""){
					sheetObj.RowDelete(selRow, false);
					setDelBtnSts(sheetObj, selRow);
					setCopyBtnSts(sheetObj);
				}
				break;
				
			case IBINSERT: //입력
				var idx = sheetObj.DataInsert();
				setCellEdit(sheetObj, idx);
				sheetObj.SelectCell(idx, "svc_scp_cd", false);
				
				setCopyBtnSts(sheetObj);
				break;
		
			case IBCOPYROW: // Row Copy
				var newIdx = sheetObj.DataCopy();
				if(newIdx > 0) {
					sheetObj.CellValue2(newIdx, "scg_aply_dt_rule_seq") = "";
					sheetObj.CellValue2(newIdx, "upd_usr_id") = "";
					sheetObj.CellValue2(newIdx, "upd_dt") = "";
					sheetObj.CellValue2(newIdx, "aply_dt_rmk") = "";
					
					setCellEdit(sheetObj, newIdx);
					setCellColor(sheetObj, newIdx);
					
					sheetObj.SelectCell(newIdx, "svc_scp_cd", false);
				}
				break;
		
			case IBDOWNEXCEL: //download excel
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "scg_aply_dt_rule_seq");
				break;
			}			
			
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	if (sAction == IBINSERT || sAction == IBCOPYROW || sAction == IBDELETE
        			|| sAction == IBDOWNEXCEL ) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
	}
	
	/**
      * OnClick 이벤트 발생시 호출되는 function <br>
      * Location Inquiry 를 호출한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
      * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
      * @return 없음
      * @author 김민아
      * @version 2011.07.11
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		
		switch(colName)
		{
	    	case "eff_dt":
   	    		cal = new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
   	    	break;
   	    	case "exp_dt":
   	    		cal = new ComCalendarGrid();
   	    		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
   	    	break;
			case "por_def_cd":
			case "pol_def_cd":
			case "pod_def_cd":
			case "del_def_cd":
				var sUrl = "/hanjin/ESM_PRI_4026.do?" + "location_cmd=LCRSO";
				var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
 	  			if (rtnVal != null){
 	  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, Col-1) = rtnVal.tp;
 	  			}
 	  		break;
 	  		
				
		}
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * Scope Duration,Request Office,Scope을 변경할 경우 Validation 을 처리한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.11
	 */
	    function sheet1_OnChange(sheetObj, Row, Col, Value)
	    {
	        var colName = sheetObj.ColSaveName(Col);
	        var formObj = document.form;
	          
	        switch(colName)
	        {
            case "svc_scp_cd":
            	var idx   = sheetObj.GetComboInfo(Row, "svc_scp_cd", "SelectedIndex");
            	if (idx == -1){
            		sheetObj.CellValue2(Row, "svc_scp_cd") = "";
            	}
            break;
            
            case "aply_dt_rule_tp_cd":
            	var idx   = sheetObj.GetComboInfo(Row, "aply_dt_rule_tp_cd", "SelectedIndex");
            	if (idx == -1){
            		sheetObj.CellValue2(Row, "aply_dt_rule_tp_cd") = "";
            	}
            break;
            
            case "por_def_cd":
            case "pol_def_cd":
            case "pod_def_cd":
            case "del_def_cd":
            	if(Value != null && Value != ""){
	            	formObj.f_cmd.value = COMMAND01;
	            	formObj.cd.value = sheetObj.CellValue(Row, Col);
	            	var sXml = sheetObj.GetSearchXml("ESM_PRI_4033GS.do", FormQueryString(formObj));
	            	var arrData = ComPriXml2ComboString(sXml, "cd", "etc1");
	            	if(arrData != null && arrData.length > 0){
	            		sheetObj.CellValue2(Row, Col) = arrData[0];
	            		sheetObj.CellValue2(Row, Col-1) = arrData[1];
	            	} else{
	            		sheetObj.CellValue2(Row, Col) = "";
	            		sheetObj.CellValue2(Row, Col-1) = "";
	            		sheetObj.SelectCell(Row, Col);
	            	}
            	} else{
            		sheetObj.CellValue2(Row, Col) = "";
            		sheetObj.CellValue2(Row, Col-1) = "";
            	}
            break;
            
            case "eff_dt":
				checkDatePeriod(sheetObj, Row, "eff_dt");
				break;
				
			case "exp_dt":
				checkDatePeriod(sheetObj, Row, "exp_dt");
				break;
            
	        }
	    }
	    
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * 클릭시 Status가 I 인 것만 Delete 버튼을 활성화한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *	
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
	 * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
	 * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
	 * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */  
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {  
		if(OldRow != NewRow){
			setDelBtnSts(sheetObj, NewRow);
			changeSelectBackColor4Rate(sheetObj);
		}
	}
	
	/**
	 * sheet1 OnSaveEnd 이벤트 발생시 호출되는 function <br>
	 * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
	}
	
	/**
 	 * sheet1 OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * 조회완료 후 정상이면 저장완료 메세지를 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setCopyBtnSts(sheetObj);
	}
	
	/**
 	 * sheet2 OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * 조회완료 후 정상이면 저장완료 메세지를 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount == 0){
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
		}else{
			ComShowCodeMessage("PRI00302");
			setColTxtColor(sheetObjects[0]);
			setRowColor(sheetObjects[0]);
			var dupRow = new Array();
			var idx = 0;
			for(i=1 ; i<=sheetObjects[1].RowCount ; i++){
				for(j=1 ; j<=sheetObjects[0].RowCount ; j++){
					if(sheetObjects[1].CellValue(i, "svc_scp_cd") == sheetObjects[0].CellValue(j, "svc_scp_cd") &&
					   sheetObjects[1].CellValue(i, "por_def_cd") == sheetObjects[0].CellValue(j, "por_def_cd") &&
					   sheetObjects[1].CellValue(i, "pol_def_cd") == sheetObjects[0].CellValue(j, "pol_def_cd") &&
					   sheetObjects[1].CellValue(i, "pod_def_cd") == sheetObjects[0].CellValue(j, "pod_def_cd") &&
					   sheetObjects[1].CellValue(i, "del_def_cd") == sheetObjects[0].CellValue(j, "del_def_cd")){
						
						var tempExpDt0 = sheetObjects[0].CellValue(j, "exp_dt")==""? "99991231" : sheetObjects[0].CellValue(j, "exp_dt");
						var tempExpDt1 = sheetObjects[1].CellValue(i, "exp_dt")==""? "99991231" : sheetObjects[1].CellValue(i, "exp_dt");
						
						if((sheetObjects[1].CellValue(i, "eff_dt") > sheetObjects[0].CellValue(j, "eff_dt") &&
						    sheetObjects[1].CellValue(i, "eff_dt") <= tempExpDt0) ||
						   (sheetObjects[1].CellValue(i, "eff_dt") <= sheetObjects[0].CellValue(j, "eff_dt") &&
						    tempExpDt1 >= sheetObjects[0].CellValue(j, "eff_dt"))){
							dupRow[idx] = j;
							idx++;
						}
					}
				}
			}
			for(i=0 ; i<dupRow.length ; i++){
				sheetObjects[0].RowFontColor(dupRow[i]) = sheetObjects[0].RgbColor(255,0,0);
				changeSelectBackColor4Rate(sheetObjects[0]);
			}
		}
		
	}
	
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김민아
  	 * @version 2011.07.20
	 **/
	function initControl() {
		//** Date 구분자 **/
//		DATE_SEPARATOR = "/";
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	}
	
    /**
  	 * OnBeforeActivate event를 처리한다. <br>
  	 * <br>
  	 * <b>Example :</b>
  	 * 
  	 * <pre>
  	 * obj_activate()
  	 * </pre>
  	 * 
  	 * @param 없음
  	 * @return 없음
  	 * @author 김민아
  	 * @version 2011.07.20
  	 */
  	function obj_activate() {
  		var formObj = document.form;
  	    var srcName = event.srcElement.getAttribute("name");
  	    
  	    if(srcName == "eff_dt") {
  	    	formObj.eff_dt.value = formObj.eff_dt.value.replace(RegExp(/-/ig), "");
  	    }
  	}
  	
  	/**
  	 * Onbeforedeactivate  event를 처리한다. <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *     obj_deactivate()
  	 * </pre>
  	 * @param 없음
  	 * @return 없음
  	 * @author 김민아
  	 * @version 2011.07.20
  	 */
  	function obj_deactivate() {
  		var formObj = document.form;
  	    var srcName = event.srcElement.getAttribute("name");
  	    
  	    if(srcName == "eff_dt") {
  	    	var sEffDt = formObj.eff_dt.value;
  	    	if (sEffDt.length >= 8) {
  	    		formObj.eff_dt.value = sEffDt.substring(0, 4) + "-" + sEffDt.substring(4, 6) + "-" + sEffDt.substring(6, 8);
  	    	}
  	    } 
  	}
	
	/**
	 * eff_dt와 exp_dt의 Validation을 확인하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {String} colName 필수 Onclick 이벤트가 발생한 해당 셀의 Column Name
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function checkDatePeriod(sheetObj, Row, colName) {
		var effDt = sheetObj.CellValue(Row, "eff_dt");
		var expDt = sheetObj.CellValue(Row, "exp_dt");
		
		if(ComIsNull(effDt) || ComIsNull(expDt)) {
			return;
		}
		
		if(ComChkPeriod(sheetObj.CellValue(Row, "eff_dt"), sheetObj.CellValue(Row, "exp_dt")) < 1) {
			ComShowCodeMessage('PRI00306');
			sheetObj.CellValue2(Row, colName) = "";
			sheetObj.SelectCell(Row, colName);
		}
	}
	
	/**
	 * row color 를 기본으로 셋팅하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function setRowColor(sheetObj) {
		sheetObj.ColBackColor("svc_scp_cd") = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("por_tp_cd")  = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("por_def_cd") = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("pol_tp_cd")  = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("pol_def_cd") = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("pod_tp_cd")  = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("pod_def_cd") = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("del_tp_cd")  = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("del_def_cd") = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("aply_dt_rule_tp_cd") = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("eff_dt") = sheetObj.RgbColor(0,0,0);
		sheetObj.ColBackColor("exp_dt") = sheetObj.RgbColor(0,0,0);
		sheetObj.ColBackColor("upd_usr_id")  = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("upd_dt")      = sheetObj.RgbColor(239,240,243);
		sheetObj.ColBackColor("aply_dt_rmk") = sheetObj.RgbColor(0,0,0);
		for(i=1 ; i<=sheetObj.RowCount ; i++){
			if(sheetObj.RowStatus(i) == "I"){
				setCellColor(sheetObj, i);
			}
		}
	}
	
	/**
	 * column text color 를 기본으로 셋팅하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function setColTxtColor(sheetObj) {
		for(i=0 ; i<= sheetObj.LastCol ; i++){
			sheetObj.ColFontColor(i) = sheetObj.RgbColor(0,0,0);
		}
	}
	
	/**
	 * 일정 컬럼에 cell edit 속성을 주는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 해당 셀의 Row Index
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function setCellEdit(sheetObj, idx) {
		sheetObj.CellEditable(idx, "svc_scp_cd") = true;
		sheetObj.CellEditable(idx, "por_def_cd") = true;
		sheetObj.CellEditable(idx, "pol_def_cd") = true;
		sheetObj.CellEditable(idx, "pod_def_cd") = true;
		sheetObj.CellEditable(idx, "del_def_cd") = true;
		sheetObj.CellEditable(idx, "aply_dt_rule_tp_cd") = true;
	}
	
	/**
	 * 일정 컬럼에 cell color 를 지정하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 해당 셀의 Row Index
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function setCellColor(sheetObj, idx) {
		sheetObj.CellBackColor(idx, "svc_scp_cd") = sheetObj.RgbColor(0,0,0);
		sheetObj.CellBackColor(idx, "por_def_cd") = sheetObj.RgbColor(0,0,0);
		sheetObj.CellBackColor(idx, "pol_def_cd") = sheetObj.RgbColor(0,0,0);
		sheetObj.CellBackColor(idx, "pod_def_cd") = sheetObj.RgbColor(0,0,0);
		sheetObj.CellBackColor(idx, "del_def_cd") = sheetObj.RgbColor(0,0,0);
		sheetObj.CellBackColor(idx, "aply_dt_rule_tp_cd") = sheetObj.RgbColor(0,0,0);
	}
	
	/**
	 * 일정 컬럼에 cell color 를 지정하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 해당 셀의 Row Index
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function setDelBtnSts(sheetObj, idx) {
		if(sheetObj.RowCount < idx){
			idx = idx -1 ;
		}
		if(sheetObj.RowStatus(idx) == "I"){
			ComBtnEnable("btn_delete");
		}else{
			ComBtnDisable("btn_delete");
		}
	}
	
	/**
	 * 일정 컬럼에 cell color 를 지정하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 해당 셀의 Row Index
	 * @return 없음
	 * @author 김민아
	 * @version 2011.07.07
	 */
	function setCopyBtnSts(sheetObj) {
		if(sheetObj.RowCount == 0){
			ComBtnDisable("btn_copy");
		}else{
			ComBtnEnable("btn_copy");
		}
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @return 없음
     * @author 김민아
     * @version 2011.07.07
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case IBSEARCH:
				// 포맷  체크
				if(formObj.eff_dt.value != "" && !ComIsDate(formObj.eff_dt.value)){
					ComShowCodeMessage("PRI00322","Access Date");
	            	formObj.eff_dt.focus();
	            	return false;
				}
			break;
			case IBSEARCH_ASYNC01:	//SAVE
				
				//1. 수정된자료가 없다.
	            if(!sheetObj.IsDataModified){
	                ComShowCodeMessage('PRI00301'); //There is no data to save.
	                return false;
	            }
				//2. 필수 데이터 체크
	            for(i=1 ; i<=sheetObj.RowCount ; i++){
//	            	
//	            	if(sheetObj.CellValue(i, "svc_scp_cd")=="" && sheetObj.CellValue(i, "por_def_cd")=="" &&
//		            	sheetObj.CellValue(i, "pol_def_cd")=="" && sheetObj.CellValue(i, "pod_def_cd")=="" &&
//		            	sheetObj.CellValue(i, "del_def_cd")==""){
//	            		if(sheetObj.RowStatus(i) != "D"){
//	            			ComShowCodeMessage('PRI01001'); //Mandatory items are needed.
//	            			sheetObj.SelectCell(i, "svc_scp_cd");
//	            			return false;
//	            		}
//	            	}
	            	if(sheetObj.CellValue(i, "aply_dt_rule_tp_cd")==""){
	            		if(sheetObj.RowStatus(i) != "D"){
	            			ComShowCodeMessage("PRI00316", "App. Rule"); //Mandatory items are needed.
	            			sheetObj.SelectCell(i, "aply_dt_rule_tp_cd");
	            			return false;
	            		}
	            	}
	            	if(sheetObj.CellValue(i, "eff_dt")=="" ){
		            	if(sheetObj.RowStatus(i) != "D"){
		            		ComShowCodeMessage("PRI00316", "Effective Date"); //Mandatory items are needed.
		            		sheetObj.SelectCell(i, "eff_dt");
		            		return false;
		            	}
		            }
	            }
			break;
		}
	 	return true;
	}
	
	/* 개발자 작업  끝 */