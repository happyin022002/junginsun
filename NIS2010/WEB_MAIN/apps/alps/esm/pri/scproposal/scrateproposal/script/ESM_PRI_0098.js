/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0098.js
*@FileTitle : S/C Proposal General/Special Rate - Route Note Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.23 박성수
* 1.0 Creation
* 2013.10.16 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
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
    function ESM_PRI_0098() {
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
    
    var sChgCdVisiable = "";
	
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
		
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); 
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
				style.height = 124;
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
				
				var HeadTitle = "|Seq.|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|rout_note_seq|Item|Surcharge|Content|Conversion|Conversion|Conversion|note_chg_tp_cd|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept Staff/Team|Accept Date|Accept User|ord";
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
				InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "svc_scp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cmdt_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_seq", false, "", dfNone, 0, false, false);   
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rout_note_seq", false, "", dfNone, 0, false, false);                
                InitDataProperty(0, cnt++, dtCombo, 70, daCenter, false, "note_clss_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtComboEdit, 65, daCenter, false, "chg_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 240, daLeft, false, "note_ctnt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "note_conv_mapg_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtCheckBox, 55, daCenter, false, "note_conv_mapg_id_chk", false, "", dfNone, 0, false, false, -1, false, true, "", false);
				InitDataProperty(0, cnt++, dtPopup, 20, daCenter, false, "note_conv_mapg_id_pop", false, "", dfNone, 0, true, true);				
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "note_chg_tp_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "src_info_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "prc_prog_sts_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 120, daLeft, false, "acpt_usr_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "acpt_dt", false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "acpt_usr_id", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "n1st_ord_ref", false, "", dfNone, 0, false, false);
	
				InitDataValid(0, "chg_cd", vtEngUpOnly);	// 영문대문자만 입력
				InitDataValid(0, "note_ctnt", vtEngOnly);	// 영문만 입력
                ShowButtonImage = 2;
                UnEditableColor = RgbColor(255, 255, 255);
                AutoRowHeight = false;

			}
			break;
	
		}
	}
	
	/**
	 * OnClick 이벤트 발생시 호출되는 function <br>
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
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		
		if (colName == "note_ctnt") {
			ComShowMemoPad(sheetObj, Row, Col, true, sheetObj.ColWidth(Col), parseInt(sheetObj.DataRowHeight) * 4);
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
	             
			case IBCLEAR: // 로딩시 코드조회
	            // Item
	            formObj.f_cmd.value = SEARCH19;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01711");
	            setIBCombo(sheetObj, sXml, "note_clss_cd", true, 0);
				
				break;
	            
			case IBSEARCH: // parent sheet에서 조회
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            
	            // Scope에 없는 Surcharge코드일 경우 Manual로 삽입해준다.
	            var arrSurcharge = dialogArguments.getSurchargeList(11);
				var sCd = " |";
				var sNm = " |";
	            
				formObj.f_cmd.value = COMMAND12;
				sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
				var arrData = ComPriXml2ComboString(sXml, "cd", "cd");
				if (arrData != null && arrData.length > 1) {
					sCd += arrData[0];
					sNm += arrData[1];
				}
				sChgCdVisiable = sNm;
				
				for (var i = 0; arrSurcharge != null && i < arrSurcharge.length; i++) {
					if (sCd.indexOf(arrSurcharge[i]) < 0) {
						sCd += "|" + arrSurcharge[i];
						sNm += "|" + arrSurcharge[i];
					}
				}
				
				sheetObj.InitDataCombo(0, "chg_cd", sNm, sCd, "", "", 0, "", "", sChgCdVisiable);
	            
				var sXml = dialogArguments.getSheetXml(11);
				sheetObj.LoadSearchXml(sXml);
				
				//sheetObj.ColumnSort("n1st_ord_ref|amdt_seq", "ASC", "ASC|ASC", true);
				
				//setSheetStyle(sheetObj, -1);
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
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
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
            	dialogArguments.setLineStyle(sheetObj, i);
            }
        } else {
        	dialogArguments.setLineStyle(sheetObj, idx);
        }
    }
    
	/**
	 * Sheet Data를 XML형태로 넘겨받는다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet번호
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function getSheetXml(sheetNo) {
    	var sXml = ComPriSheet2Xml(sheetObjects[sheetNo]);
        return sXml;
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
		
		if (colName == "note_conv_mapg_id_pop") {	
			if(!ComIsNull(sheetObj.CellValue(Row, "note_conv_mapg_id")))	{
				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "D") {
					//var sUrl = "/hanjin/EES_DMT_2001.do?" + FormQueryString(document.form);
		            //sUrl += "&note_clss_cd=" + sheetObj.CellValue(Row, "note_clss_cd");
		            //var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_2001", 1010, 700, true);
		            var sUrl = "/hanjin/EES_DMT_2001.do?" + FormQueryString(document.form);
		            sUrl += "&note_clss_cd=" + sheetObj.CellValue(Row, "note_clss_cd") + "&caller=2007";
		            ComOpenPopup(sUrl, 1024, 700, "findCustomer", "1,0,1,1,1,1,1", true);
				}else if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "note_clss_cd") == "C") { //[CHM-201327107] CHSS 노트 항목 추가
					ComOpenPopup('EES_CGM_1209.do?prop_no=' + formObj.prop_no.value, 1024, 580, '', '1,0,1,1,1,1,1', true);		
				}else {
					var sParam = "";
					sParam += "svc_scp_cd=" + formObj.svc_scp_cd.value;
					sParam += "&prop_no=" + formObj.prop_no.value;
					sParam += "&amdt_seq=" + formObj.amdt_seq.value;
					sParam += "&note_conv_mapg_id=" + sheetObj.CellValue(Row, "note_conv_mapg_id");
					sParam += "&rout_seq=" + sheetObj.CellValue( Row, "rout_seq");
					sParam += "&rout_note_seq=" + sheetObj.CellValue( Row, "rout_note_seq");
					sParam += "&note_tp_cd=" + sheetObj.CellValue( Row, "gen_spcl_rt_tp_cd");
					sParam += "&eff_dt=" + sheetObj.CellValue( Row, "eff_dt");
					sParam += "&exp_dt=" + sheetObj.CellValue( Row, "exp_dt");
					sParam += "&master_seq=" + sheetObjects[0].SelectRow;
															
					var sUrl = "/hanjin/ESM_PRI_0052.do?"+sParam;			
					var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_0052", 1020, 585, true);
		      
					if (rtnVal != null) {
						//CONVERSION 화면에서 선택ROW가 변동가능하기 때문에 FOR문절 사용
						for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
							if(sheetObj.CellValue(i, "rout_seq") == rtnVal.master_seq 
									&& sheetObj.CellValue(i, "rout_note_seq") == rtnVal.detail_seq
  									&& sheetObj.CellValue(i, "amdt_seq") == rtnVal.amdt_seq ) {
								sheetObj.CellValue(i, "note_conv_mapg_id_chk") = rtnVal.note_conv_flg;
								sheetObj.CellValue(i, "note_chg_tp_cd") = rtnVal.note_chg_tp_cd;
							}
						}
					}
				}
			} else {
				ComShowCodeMessage("PRI08015");
			}
		}
		
	}

    
    