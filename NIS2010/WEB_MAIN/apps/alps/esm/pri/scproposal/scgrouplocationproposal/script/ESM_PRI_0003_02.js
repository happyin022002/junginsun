/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_02.js
*@FileTitle : S/C Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.06 변영주
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
     * @class ESM_PRI_0003_02 : ESM_PRI_0003_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0003_02() {
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
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
    var askOnce = true;
    var isGrpDel = false;
	
	var tabLoad = new Array();
	tabLoad[0] = 0;
	tabLoad[1] = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
		
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);						
					break;
					
				case "btn_acceptall":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY01);
					break;
					
				case "btn_cancelall":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY02);
					break;
					
				case "btn_glinecopy":
					doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
					break;
					
				case "btn_rowadd1":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
					
				case "btn_rowadd2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					applyMasterStyle(sheetObjects[1]);										
					break;
		
				case "btn_delete1":
					if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02) &&
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05)){
						doActionIBSheet(sheetObjects[0],document.form,IBDELETE);						
					}
					break;
					
				case "btn_delete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
					applyMasterStyle(sheetObjects[1]);					
					break;
					
				case "btn_amend":
					doActionIBSheet(sheetObjects[1],document.form,COMMAND01);
					applyMasterStyle(sheetObjects[1]);					
					break;
					
				case "btn_amendcancel":
					doActionIBSheet(sheetObjects[1],document.form,COMMAND02);
					applyMasterStyle(sheetObjects[1]);										
					break;
					
				case "btn_accept":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY03);
					applyMasterStyle(sheetObjects[1]);										
					break;	
					
				case "btn_acceptcancel":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY04);
					applyMasterStyle(sheetObjects[1]);										
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
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
	 * 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
	 * 추가한다
	 */
	function loadPage() {

		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
        buttonControl();		
        parent.loadTabPage();
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
	 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch (sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 300;
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
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false)
					var HeadTitle = "|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Group Code|Description|prc_prog_sts_cd|src_info_cd|n1st_cmnc_amdt_seq";
					var headCount = ComCountHeadTitle(HeadTitle);		
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);					
					
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck,   	40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 		40, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 		40, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		40, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		40, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		40, daLeft, false, "grp_loc_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			100, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, false, false, 4, true);
					InitDataProperty(0, cnt++, dtData, 			120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, false, false, 100);
					InitDataProperty(0, cnt++, dtHidden, 		20, daLeft, false, "prc_prog_sts_cd", true, "", dfEngKey, 0, true, true, 100);
					InitDataProperty(0, cnt++, dtHidden, 		20, daLeft, false, "src_info_cd", false, "", dfEngKey, 0, true, true, 100);
					InitDataProperty(0, cnt++, dtHidden, 		20, daLeft, false, "n1st_cmnc_amdt_seq", false, "", dfEngKey, 0, true, true, 100);
				
					InitDataValid(0, "prc_grp_loc_cd", vtEngUpOnly);
					ShowButtonImage = 2;
				}
				break;
				
			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 300;
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
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					var HeadTitle = "|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Group Location Detail Seq.|Location Code|Description|EFF Date|EFF SEQ|EXP Date|Source|Status";
                    var headCount = ComCountHeadTitle(HeadTitle);
					
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false)
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 	40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 		30, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);					
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "grp_loc_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "grp_loc_dtl_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit, 	110, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, false, 5, true);
					InitDataProperty(0, cnt++, dtData, 			150, daLeft, false, "loc_nm", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			60, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		60, daCenter, false, "n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			60, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 		50, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
					
					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				InitDataValid(0, "loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

					ShowButtonImage = 2;
				}
				break;

		}
	}
	
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);
		var sts = document.form.prop_sts_cd.value;
		var val = sheetObj.CellValue(Row, Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
	
    /**
     * Sheet상에서 특정 cell 이 선택되었을 경우의 이벤트를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) ;
     * </pre>
     * @return 없음
     * @author 변영주
     * @version 2009.05.17
     */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);    	 
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
	
     /**
      * OnSelectCell 이벤트 발생시 호출되는 function <br>
      * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {ibsheet} sheetObj 필수, IBSheet Object
      * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
      * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
      * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
      * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
      * @return 없음
      * @author 문동규
      * @version 2009.04.17
      */         
     function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
         if (OldRow != NewRow) {
             changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
         }
     }       
     
    /**
    * Sheet상에서 특정 cell 의 value 가 변경되었을 경우의 이벤트를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet2_OnChange(sheetObj, Row, Col, Value);
    * </pre>
    * @return 없음
    * @author 변영주
    * @version 2009.05.17
    */	
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		var amdt_seq = formObj.amdt_seq.value;
		var sts = sheetObj.CellValue(Row, "src_info_cd");
		if (sName == "loc_cd") {
			formObj.f_cmd.value = SEARCH05;
			var sParam = FormQueryString(formObj) + "&" + "cd=" + Value;
			
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if(arrDesc==null){
				sheetObj.CellValue2(Row,"loc_nm")="";
				sheetObj.CellValue2(Row,Col)="";
				sheetObj.SelectCell(Row,Col,true);
				return;				
			}
			sheetObj.CellValue2(Row, "loc_nm") = arrDesc[0][1];
			
			if(sts=="PC"){
				sheetObj.CellValue2(Row, "src_info_cd") = "PM";
			}else if(sts=="GC"){
				sheetObj.CellValue2(Row, "src_info_cd") = "GM";
			}
		}
	}
	

	var isFiredNested = false;
	var supressConfirm = false;
    /**
	    * Sheet상에서 특정 cell 의 Focus가 변경되었을 경우에 row 가 바뀌었을 경우 호출. <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *     doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
	    * </pre>
	    * @return 없음
	    * @author 변영주
	    * @version 2009.05.17
	    */		
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = NewRow;
		
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested = true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			if (sheetD.IsDataModified) {
				isFiredNested = true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested = false;
				
				var rslt = false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm = true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
					var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm = false;
				}
				if (rslt) {
					isFiredNested = true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested = false;
				} else {
					isFiredNested = true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested = false;
					return -1;
				}
			}
			
			if (appendRow) {
				isFiredNested = true;
				var idx = sheetM.DataInsert();
				isFiredNested = false;
				return idx;
			} else {
				formObj.grp_loc_seq.value = sheetM.CellValue(adjNewRow, "grp_loc_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
		}
	}
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try{	
			if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
				ComOpenWait(true);
			}			
			sheetObj.ShowDebugMsg = false;
			sheetObj.WaitImageVisible = false;
			switch (sAction) {
				case IBSEARCH: // 조회
	//				if ((sheetObjects[0].IsDataModified||sheetObjects[1].IsDataModified)&&ComShowCodeConfirm("PRI00006")) {
	//					supressConfirm = true;
	//					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	//					supressConfirm = false;
	//				}
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESM_PRI_0003_02GS.do" , FormQueryString(formObj));
					buttonControl();
					break;
					
				case IBSEARCHAPPEND: // 조회
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value = SEARCH02;
						sheetObj.DoSearch("ESM_PRI_0003_02GS.do" , FormQueryString(formObj));
					}
					break;
	
				case IBSEARCH_ASYNC01: // 조회
					if (validateForm(sheetObj,document.form,sAction)) {
	
				    	//공통 Source
						formObj.f_cmd.value = SEARCH19;
						var sParam = FormQueryString(formObj)+"&cd=CD02064";	
						sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
						setIBCombo(sheetObj,sXml,"src_info_cd", false, 0, "NW");
	
						//공통 Status
						formObj.f_cmd.value = SEARCH19;
						sParam = FormQueryString(formObj)+"&cd=CD01719";	
						sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
						setIBCombo(sheetObj,sXml,"prc_prog_sts_cd", false, 0, "I");
						var arrData = ComPriXml2ComboString(sXml, "cd", "nm");	
	
					}
				break;				
				
				case IBSEARCH_ASYNC02: // 조회 - Group 삭제시 rate 사용여부 확인
					if (validateForm(sheetObj,document.form,sAction)) {
				    	//공통 Source
						var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
				    	
						if(chkArr.length == 0){
							sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
						}						
						var sParam = "f_cmd="+SEARCH03+"&" + sheetObj.GetSaveString(false, false, "chk");
						var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_02GS.do", sParam);
						var arrDesc = ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
						var rsltCnt = ComPriGetRowCountFromXML(sXml);
						
						var txt = "";
						var desc = "";
						
						if(rsltCnt <= 0){
							return true;
						}
						for(i=0;i<arrDesc.length;i++){
							if(desc!=arrDesc[i][0]){
								txt += "\n["+arrDesc[i][0]+"] : \n   ";
							}
							txt += "-" + arrDesc[i][1]+" ";
							desc = arrDesc[i][0];
						}
	
						ComShowCodeMessage("PRI08019", txt);	
						return false;
					}
					return true;
					break;		
					
				case IBSEARCH_ASYNC05: // 조회 - Group 삭제시 detail Accepted 여부
					if (validateForm(sheetObj,document.form,sAction)) {
				    	//공통 Source
						var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
				    	
						if(chkArr.length == 0){
							sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
						}						
						var sParam = "f_cmd="+SEARCH04+"&" + sheetObj.GetSaveString(false, false, "chk");
						var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_02GS.do", sParam);
						var arrDesc = ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
						var rsltCnt = ComPriGetRowCountFromXML(sXml);
						
						var txt = "";
						var desc = "";
	
						if(rsltCnt <= 0){
							return true;
						}
						for(i=0;i<arrDesc.length;i++){
							if(desc!=arrDesc[i][0]){
								txt += "\n["+arrDesc[i][0]+"] : \n   ";
							}
							txt += "-" + arrDesc[i][1]+" ";
							desc = arrDesc[i][0];
						}
	
						ComShowCodeMessage("PRI01132", txt);	
						return false;
					}
					return true;
					break;						
	
				case IBSEARCH_ASYNC03: // 저장 - Group 전체가 지워졌을 경우 validation ( 사용중 Group 삭제 불가 )
					if (validateForm(sheetObj,document.form,sAction)) {
			   			var amdt_seq = formObj.amdt_seq.value;
			   			var eff_dt = formObj.eff_dt.value;
		   	
						var rowCnt = sheetObjects[1].RowCount - ComPriSheetFilterRows(sheetObjects[1], "n1st_cmnc_amdt_seq", amdt_seq).length;
						var newCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length -
									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
						var ndlCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length -
									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length -
									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
						var delCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;	
						
			   			if (rowCnt + newCnt - ndlCnt - delCnt == 0) {
							var sParam = "f_cmd="+SEARCH03+"&ibflag=R"
														+"&prop_no="+sheetObjects[0].CellValue(sheetObj.SelectRow,"prop_no")
														+"&amdt_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"amdt_seq")
														+"&svc_scp_cd="+sheetObjects[0].CellValue(sheetObj.SelectRow,"svc_scp_cd")
														+"&grp_loc_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"grp_loc_seq");
												
							var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_02GS.do", sParam);
							var arrDesc = ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
							var rsltCnt = ComPriGetRowCountFromXML(sXml);
							
							var txt = "";
							var desc = "";
							
							if(rsltCnt <= 0){
								return false;
							}
							for(i=0;i<arrDesc.length;i++){
								if(desc!=arrDesc[i][0]){
									txt += "\n["+arrDesc[i][0]+"] : \n   ";
								}
								txt += "-" + arrDesc[i][1]+" ";
								desc = arrDesc[i][0];
							}
	
							ComShowCodeMessage("PRI08019", txt);	
							return true;						
							
						}	
					}
					return false;
					break;					

//				case IBSEARCH_ASYNC06: // 저장 - Group 삭제시 detail Accepted 여부
//					if (validateForm(sheetObj,document.form,sAction)) {
//			   			var amdt_seq = formObj.amdt_seq.value;
//			   			var eff_dt = formObj.eff_dt.value;
//		   	
//						var rowCnt = sheetObjects[1].RowCount - ComPriSheetFilterRows(sheetObjects[1], "n1st_cmnc_amdt_seq", amdt_seq).length;
//						var newCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
//									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length -
//									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
//						var ndlCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length -
//									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length -
//									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
//						var delCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;	
//						
//			   			if (rowCnt + newCnt - ndlCnt - delCnt == 0) {
//							var sParam = "f_cmd="+SEARCH04+"&ibflag=R"
//														+"&prop_no="+sheetObjects[0].CellValue(sheetObj.SelectRow,"prop_no")
//														+"&amdt_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"amdt_seq")
//														+"&svc_scp_cd="+sheetObjects[0].CellValue(sheetObj.SelectRow,"svc_scp_cd")
//														+"&grp_loc_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"grp_loc_seq");
//												
//							var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_02GS.do", sParam);
//							var arrDesc = ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
//							var rsltCnt = ComPriGetRowCountFromXML(sXml);
//							
//							var txt = "";
//							var desc = "";
//							
//							if(rsltCnt <= 0){
//								return false;
//							}
//							for(i=0;i<arrDesc.length;i++){
//								if(desc!=arrDesc[i][0]){
//									txt += "\n["+arrDesc[i][0]+"] : \n   ";
//								}
//								txt += "-" + arrDesc[i][1]+" ";
//								desc = arrDesc[i][0];
//							}
//	
//							ComShowCodeMessage("PRI01132", txt);	
//							return true;						
//							
//						}	
//					}
//					return false;
//					break;	
//					
				case IBSEARCH_ASYNC04: // Group Code 가 변경되었을 경우 validation ( 사용중 Group 변경 불가 )
					if (validateForm(sheetObj,document.form,sAction)) {
			   			var amdt_seq = formObj.amdt_seq.value;
			   			var eff_dt = formObj.eff_dt.value;
	
						var sParam = "f_cmd="+SEARCH03+"&ibflag=R"
													+"&prop_no="+sheetObjects[0].CellValue(sheetObj.SelectRow,"prop_no")
													+"&amdt_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"amdt_seq")
													+"&svc_scp_cd="+sheetObjects[0].CellValue(sheetObj.SelectRow,"svc_scp_cd")
													+"&grp_loc_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"grp_loc_seq");
											
						var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_02GS.do", sParam);
						var arrDesc = ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
						var rsltCnt = ComPriGetRowCountFromXML(sXml);
						
						var txt = "";
						var desc = "";
						
						if(rsltCnt <= 0){
							return "OK";
						}else{
							txt += "\n["+arrDesc[0][0]+"] : \n-" + arrDesc[0][1]+" ";
							ComShowCodeMessage("PRI08019", txt);							
							return arrDesc[0][1];
						}
					}
				
				case IBSEARCH_ASYNC07: // Group Code 가 변경되었을 경우 detail Accepted 여부
				if (validateForm(sheetObj,document.form,sAction)) {
		   			var amdt_seq = formObj.amdt_seq.value;
		   			var eff_dt = formObj.eff_dt.value;

					var sParam = "f_cmd="+SEARCH04+"&ibflag=R"
												+"&prop_no="+sheetObjects[0].CellValue(sheetObj.SelectRow,"prop_no")
												+"&amdt_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"amdt_seq")
												+"&svc_scp_cd="+sheetObjects[0].CellValue(sheetObj.SelectRow,"svc_scp_cd")
												+"&grp_loc_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"grp_loc_seq");
										
					var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_02GS.do", sParam);
					var arrDesc = ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
					var rsltCnt = ComPriGetRowCountFromXML(sXml);
					
					var txt = "";
					var desc = "";
					
					if(rsltCnt <= 0){
						return "OK";
					}else{
						txt += "\n["+arrDesc[0][0]+"] : \n-" + arrDesc[0][1]+" ";
						ComShowCodeMessage("PRI01132", txt);							
						return arrDesc[0][1];
					}
				}
				
				case IBSAVE: // 저장
	
					isFiredNested = false;
	
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
//					comChangeValue(sheetObjects[1], "ibflag", "R", "amdt_seq", formObj.pre_amdt_seq.value);
		
					formObj.f_cmd.value = MULTI01;
					var sParam = FormQueryString(formObj);
	
					var sParamSheet1 = sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
					}
					var sParamSheet2 = sheetObjects[1].GetSaveString();
					if (sParamSheet2 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
					if (!supressConfirm && !ComPriConfirmSave()) {
						return false;
					}

					var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_02GS.do", sParam);
									
					isFiredNested = true;
					sheetObjects[0].LoadSaveXml(sXml);
					sheetObjects[1].LoadSaveXml(sXml);
					isFiredNested = false;
		
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
		
					if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
						return false;
					} else {
						ComPriSaveCompleted();
						if(isGrpDel){
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						}
					}
					
					buttonControl();
					return true;				
					break;
					
				case IBINSERT: // Row Add
					var prop_no      = formObj.prop_no.value;
					var amdt_seq     = formObj.amdt_seq.value; 
					var svc_scp_cd   = formObj.svc_scp_cd.value;
					var eff_dt 		 = formObj.eff_dt.value;
					var exp_dt 		 = formObj.exp_dt.value;
			
					if (enableFlag && validateForm(sheetObj,document.form,sAction)) {
						if (sheetObj.id == "sheet1") {
							var idx = doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.SelectRow, sheetObj.SelectCol, sheetObj.SelectCol, true);						
							if (idx < 0) {
								return false;
							}
							sheetObj.CellValue2(idx, "prop_no") = prop_no;				
							sheetObj.CellValue2(idx, "amdt_seq") = amdt_seq;
							sheetObj.CellValue2(idx, "svc_scp_cd") = svc_scp_cd;
							sheetObj.CellValue2(idx, "grp_loc_seq") = parseInt(ComPriGetMax(sheetObj, "grp_loc_seq")) + 1;
							sheetObj.CellValue2(idx, "src_info_cd") = "NW";
							sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
							changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);							
							sheetObj.SelectCell(idx, "prc_grp_loc_cd");
							sheetObjects[1].RemoveAll();						
						}else if (sheetObj.id == "sheet2") {
							if(sheetObjects[0].RowCount==0||sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"ibflag")=="D"){
								ComShowCodeMessage("PRI01004");
								return;							
							}
							var amdt_seq = formObj.amdt_seq.value;
							
							// insert Amend 중 Amend pair 사이에 끼어들게 되는 경우를 제외							
							if(sheetObj.SearchRows!=0 && sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq")!= amdt_seq ){	
								ComShowCodeMessage("PRI01002");		
							 	return;
							}							
							
							var idx = sheetObj.DataInsert();	   // 신규 row			
							sheetObj.CellValue2(idx, "prop_no") = prop_no;						
							sheetObj.CellValue2(idx, "amdt_seq") = amdt_seq;
							sheetObj.CellValue2(idx, "svc_scp_cd") = svc_scp_cd;
							sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
							sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
							sheetObj.CellValue2(idx, "exp_dt") = exp_dt;						
							sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
							sheetObj.CellValue2(idx, "src_info_cd") = "NW";
							
							changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), amdt_seq);
							
							var grp_loc_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_loc_seq");
							sheetObj.CellValue2(idx, "grp_loc_seq") = grp_loc_seq;
							sheetObj.CellValue2(idx, "grp_loc_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq")) + 1;
			    			sheetObj.SelectCell(idx, "loc_cd");
						}
						
						
						if(amdt_seq != 0){
							sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);								
						}
						
					}
					break;
					
				case IBDELETE: // Delete
					var amdt_seq = formObj.amdt_seq.value;
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length == 0){
						sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
					}	
					chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
					
					if(amdt_seq=="0"){
						if (enableFlag && validateForm(sheetObj,document.form,sAction)) {
							if (sheetObj.id == "sheet1") {
								isGrpDel = true;							
								sheetObjects[1].RemoveAll();
							}else{
								for(i=0;i < chkArr.length;i++){
									if(sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="I"){
										ComShowCodeMessage("PRI01002");
										return;
									}
								}
							}				
							deleteRowCheck(sheetObj, "chk");
						}					
					}else{
						var eff_dt = formObj.eff_dt.value;
						var amdt_seq = formObj.amdt_seq.value;
						if (sheetObj.id == "sheet1") {
							isGrpDel = true;
							for(j=0;j < chkArr.length;j++){
								sheetObj.CellFont("FontStrikethru", chkArr[j], 1, chkArr[j], sheetObj.LastCol)=true;
								sheetObj.CellFont("FontColor", chkArr[j], 1, chkArr[j], sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
								if(sheetObj.CellValue(chkArr[j],"src_info_cd")!="NW"&&sheetObj.CellValue(chkArr[j],"ibflag")!="I"){
									sheetObj.RowStatus(chkArr[j]) ="D";	
									sheetObj.CellValue(chkArr[j],"chk")="0";
									sheetObj.CellValue(chkArr[j],"n1st_cmnc_amdt_seq")= amdt_seq;										
								}
							}
			
							deleteRowCheck(sheetObj, "chk");
							changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), amdt_seq);
							if(sheetObj.CellValue(sheetObj.SelectRow,"ibflag")=="D"){
								
								var row = 0;
								sheetObjects[1].CheckAll2("chk") = "1";
								var chkArrDtl = ComPriSheetFilterRows(sheetObjects[1], "chk", "1");
							    for(i=0;i<chkArrDtl.length;i++){
							    	if(sheetObjects[1].CellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq&&sheetObjects[1].CellValue(chkArrDtl[i],"ibflag")!="I"){
		   								comSheetAmendCancelRow(sheetObjects[1],formObj,chkArrDtl[i],"A", "loc_cd");
		   							}else if(sheetObjects[1].CellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq&&sheetObjects[1].CellValue(chkArrDtl[i],"ibflag")=="I"){
										sheetObjects[1].RowStatus(chkArr[i]) ="D";
										sheetObjects[1].RowEditable(chkArr[i])=false;
										sheetObjects[1].RowHidden(chkArr[i]) = true;	   								
		  							}
							    }

							    sheetObjects[1].CheckAll2("chk") = "1";
							    comChangeValue(sheetObjects[1], "chk", "0", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", formObj.amdt_seq.value+"|"+"A");							    
								if(sheetObjects[1].RowCount>0){
								    doActionIBSheet(sheetObjects[1],document.form,IBDELETE);							
								}								
							}
							
						}else{
							for(i=0;i < chkArr.length;i++){
								if(sheetObj.CellValue(chkArr[i],"amdt_seq")!=amdt_seq||(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq&&
										(sheetObj.CellValue(chkArr[i],"src_info_cd")=="AM" || sheetObj.CellValue(chkArr[i],"src_info_cd")=="AD" || sheetObj.CellValue(chkArr[i],"prc_prog_sts_cd")!="I"))){
									ComShowCodeMessage("PRI01002");
									return;
								}
							}

							var sRow = 0;
							for(j=0;j < chkArr.length;j++){
								if(sheetObj.CellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
									comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D","loc_cd");		
									sRow++;								
								}
	
							}
							deleteRowCheck(sheetObj, "chk");	
						}				
					}
					
					if(!isGrpDel && getValidRowCount(sheetObjects[1])==0 && ComShowCodeConfirm('PRI00021')){
	
						if(sheetObjects[0].RowStatus(sheetObjects[0].SelectRow)!="I"){
							sheetObjects[0].RowHidden(sheetObjects[0].SelectRow) = true;							
						}
						sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) = "D";
						isGrpDel = true;
					}	
					
					break;
					
				case IBCOPYROW: // Guideline Copy
					formObj.f_cmd.value = MULTI06;
	
					var sParam = FormQueryString(formObj);
					if (!supressConfirm && !ComShowCodeConfirm("PRI01006")) {
						return false;
					}
	
					var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_02GS.do", sParam);
					
					formObj.f_cmd.value = SEARCH02;
					
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	
		    		if (sheetObjects[0].RowCount <= 0) {
		    			ComShowCodeMessage("PRI01016");
		    		} else {
		    			ComShowCodeMessage("PRI01017");
		    		}
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);					    		
					break;	
				
				case MODIFY01: // Accept All
	
					if (!supressConfirm && !ComShowCodeConfirm('PRI01015')) {
						return false;
					}	
	
					formObj.f_cmd.value = MULTI02;
					var sParam = FormQueryString(formObj);
					
					var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_02GS.do", sParam);
					if(ComGetEtcData(sXml,"result")!="OK"){
						ComShowCodeMessage("PRI00329");
						return;
					}
					
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
					ComShowCodeMessage("PRI00108");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case MODIFY02: // Cancel All
				
					if (!supressConfirm && !ComShowCodeConfirm('PRI01010')) {
						return false;
					}			
				
					formObj.f_cmd.value = MULTI03;
					var sParam = FormQueryString(formObj);
		
					var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_02GS.do", sParam);
					if(ComGetEtcData(sXml,"result")!="OK"){
						ComShowCodeMessage("PRI00330");
						return;
					}
					
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
					ComShowCodeMessage("PRI00109");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;			
	
				case MODIFY03: // Accept
				
					if (!supressConfirm && !ComShowCodeConfirm('PRI00008')) {
						return false;
					}			
					formObj.f_cmd.value = MULTI04;
					var rtn = comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0003_02GS.do");
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
					if(rtn){
						ComShowCodeMessage("PRI00108");
					}
					break;	
					
				case MODIFY04: // Accept Cancel
				
					if (!supressConfirm && !ComShowCodeConfirm('PRI00009')) {
						return false;
					}						
					formObj.f_cmd.value = MULTI05;
					var rtn = comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0003_02GS.do");
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);				
					if(rtn){
						ComShowCodeMessage("PRI00109");
					}				
					break;			
					
				case COMMAND01: // Amend
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","loc_cd");						
						}
					}else{ 
						comSheetAmendRow(sheetObj,formObj,sheetObj.SelectRow,"M","loc_cd");					
					}
					break;		
				
				case COMMAND02: // Amend Cancel
				
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "loc_cd");						
						}
					}else{ 
						comSheetAmendCancelRow(sheetObj,formObj,sheetObj.SelectRow,"M", "loc_cd");					
					}
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
	    	sheetObj.WaitImageVisible = true;
	    }
	}

    /**
    * Sheet상에서 특정 Popup 기능이 설정된 Cell 에서 popup 이벤트가 발생했을 경우 호출
    * . <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet2_OnPopupClick(sheetObj, Row, Col);
    * </pre>
    * @return 없음
    * @author 변영주
    * @version 2009.05.17
    */	 	 
 	function sheet2_OnPopupClick(sheetObj, Row, Col)
 	{
 		var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		var sts     = formObj.prop_sts_cd.value;
 		
       	switch(colName)
       	{
   	    	case "loc_cd":
   	    		var locationCmd = "L";
   	    		var loc_cd = sheetObj.CellValue(Row, Col);
   	    		var sts = sheetObj.CellValue(Row, "src_info_cd");
 	  	  		var sUrl = "/hanjin/ESM_PRI_4026.do?location_cmd=" + locationCmd;
 	  			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
 	  			if (rtnVal != null&&loc_cd!=rtnVal.cd){
 	  				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
 	  				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;
 	  				if(sts=="PC"){
 	  					sheetObj.CellValue2(Row, "src_info_cd") = "PM";
 	  				}else if(sts=="GC"){
 	  					sheetObj.CellValue2(Row, "src_info_cd") = "GM";
 	  				}
 	  			}
   	    		break;
       	}
 	}   	
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		var amdt_seq = formObj.amdt_seq.value;		 
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBSEARCHAPPEND: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBSEARCH_ASYNC01: // 조회
			return true;
			break;
			
		case IBSEARCH_ASYNC02: // 조회
			return true;
			break;		
		
		case IBSEARCH_ASYNC03: // 조회
			return true;
			break;		

		case IBSEARCH_ASYNC04: // 조회
			return true;
			break;		
			
		case IBSEARCH_ASYNC05: // 조회
			return true;
			break;		
	
//		case IBSEARCH_ASYNC06: // 조회
//			return true;
//			break;		
	
		case IBSEARCH_ASYNC07: // 조회
			return true;
			break;				
					
		case IBSAVE: // 저장

			if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}	
			
   			if (sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) != "D"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
   				ComShowCodeMessage("PRI00319", "Location Group");
				return false;
			}			
   			
			if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03)){
				return false;				
			}
			
//			if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06)){
//				return false;				
//			}			
   			
			if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			
			if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
				return false;
			}

			var rowM = ComPriAmendDupCheck(sheetObjects[0], "prc_grp_loc_cd", amdt_seq);
//			var rowM = sheetObjects[0].ColValueDup("prc_grp_loc_cd",false);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
				return false;
			}
			
			var rowD = ComPriAmendDupCheck(sheetObjects[1], "amdt_seq|grp_loc_seq|loc_cd", amdt_seq);
//			var rowD = sheetObjects[1].ColValueDup("amdt_seq|grp_loc_seq|loc_cd",false);
			if (rowD >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet2", rowD);
				return false;
			}
			
			return true;
			break;
			
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		}
	}

	    /**
	    * 페이지가 최초로 조회될 때의 초기값을 정의, parent 로부터 변수 수신
	    * . <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *     tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg);
	    * </pre>
	    * @return 없음
	    * @author 변영주
	    * @version 2009.05.17
	    */		 
	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
		var formObject = document.form;
		if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
			formObject.prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
			formObject.prop_no.value = sPropNo;
			formObject.amdt_seq.value = sAmdtSeq;
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.pre_amdt_seq.value = sPreAmdtSeq;
			formObject.prop_sts_cd.value = sPropStsCd; 
			formObject.eff_dt.value = sEffDt;
			formObject.exp_dt.value = sExpDt;			
			formObject.pre_exp_dt.value = sPreExpDt ;
			formObject.req_usr_flg.value = sIsReqUsr ;
			formObject.apro_usr_flg.value = sIsAproUsr ;	
			formObject.dur_dup_flg.value = sDurDupFlg ;
			formObject.lgcy_if_flg.value = sLgcyIfFlg ;
	        askOnce = true;
	        
			buttonControl();
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}
	
    /**
	    * 페이지가 내의 변수들과 sheet 를 초기화함
	    * . <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *     tabClearSheet();
	    * </pre>
	    * @return 없음
	    * @author 변영주
	    * @version 2009.05.17
	    */		
	function tabClearSheet() {
		var formObject = document.form;

		formObject.prop_no.value = "";
		formObject.amdt_seq.value = "";
		formObject.svc_scp_cd.value = "";
		
        askOnce = true;
        
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}
	
	var enableFlag = true;

	
    /**
	    * 페이지 내의 sheet 들의 속성을 변경
	    * . <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *     tabEnableSheet(flag);
	    * </pre>
	    * @return 없음
	    * @author 변영주
	    * @version 2009.05.17
	    */		
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;
		
		sheetObjects[0].Editable = flag;
		sheetObjects[1].Editable = flag;
	}

    /**
    * sheet 조회가 일어났을 경우에 조회 이벤트 후에 실행
    * . <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet2_OnSearchEnd(sheetObj, errMsg);
    * </pre>
    * @return 없음
    * @author 변영주
    * @version 2009.05.17
    */	
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		var amdt_seq = document.form.amdt_seq.value;
		var eff_dt = document.form.eff_dt.value;
		var sts = document.form.prop_sts_cd.value;
		if(sts=="I"){
			if(amdt_seq==0){
				sheetObj.InitDataProperty(0, 8, dtPopupEdit, 120, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, true, true, 5, true);
			}else{
				sheetObj.InitDataProperty(0, 8, dtPopupEdit, 120, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, true, 5, true);				
			}
		}else{
			sheetObj.InitDataProperty(0, 8, dtPopupEdit, 120, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, false, 5, true);			
		}

		var amdt_seq = document.form.amdt_seq.value;
		var pre_exp_dt = document.form.pre_exp_dt.value;
		var lgcy_if_flg = document.form.lgcy_if_flg.value;
		
		if(amdt_seq!=0 && lgcy_if_flg != "Y"){
			for(i=1 ; i < sheetObj.Rows; i++){
				if(sheetObj.CellValue(i,"amdt_seq") != amdt_seq){ 
					sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol)=true;
					sheetObj.RowEditable(i) = false;						
				}
				else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
					sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
					if(sts == "I"&&sheetObj.CellValue(i,"src_info_cd")!="AD"&&sheetObj.CellValue(i,"prc_prog_sts_cd")=="I"){
						sheetObj.CellEditable(i,"loc_cd") = true;						
					}
				}
			}
		}
	}
	
    /**
    * sheet 조회가 일어났을 경우에 조회 이벤트 후에 실행
    * . <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet1_OnSearchEnd(sheetObj, errMsg);
    * </pre>
    * @return 없음
    * @author 변영주
    * @version 2009.05.17
    */		
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var rCnt = sheetObj.RowCount;
		var formObj = document.form;				
		var amdt_seq = formObj.amdt_seq.value;
		var lgcy_if_flg = formObj.lgcy_if_flg.value;		
		var req_usr_flg = formObj.req_usr_flg.value;
		var apro_usr_flg = formObj.apro_usr_flg.value;		
		var sts = document.form.prop_sts_cd.value;
		if(sts == "I" && rCnt < 1 && (req_usr_flg=="true"||apro_usr_flg=="true")) {
			if(askOnce&&ComShowCodeConfirm('PRI01006')) {
		        askOnce = false;
				supressConfirm = true;
				doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
				supressConfirm = false;
			}
	        askOnce = false;
		}
		

		for(i=1;i<=rCnt;i++){
			if(amdt_seq!=0 && lgcy_if_flg != "Y"){
				if(sheetObj.CellValue(i,"src_info_cd")=="AD"){
					sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol)=true;
				}
				if(sheetObj.CellValue(i,"src_info_cd")=="AM"||sheetObj.CellValue(i,"src_info_cd")=="AD"||sheetObj.CellValue(i,"src_info_cd")=="NW"){
					sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);				
				}
				if(sheetObj.CellValue(i,"src_info_cd")=="NW"){
					sheetObj.CellEditable(i,"prc_grp_loc_cd") = true;
					sheetObj.CellEditable(i,"prc_grp_loc_desc") = true;
				}				
			}
		}
	
		isGrpDel = false;
		isFiredNested = false;
	}	
	
	/**
	* Master Detail 관계에서 Master 의 Style 을 정의함
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     applyMasterStyle(sheetObj);
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/			
	function applyMasterStyle(sheetObj){
		var formObj = document.form;
		var amdt_seq = formObj.amdt_seq.value;
		var eff_dt = formObj.eff_dt.value;
		
		var amdCnt = ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length;
		var rowCnt = sheetObj.RowCount - ComPriSheetFilterRows(sheetObj, "n1st_cmnc_amdt_seq", amdt_seq).length;
		var newCnt = ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
		var ndlCnt = ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
		var delCnt = ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;
		
		var grp_sts = amdCnt > 0 ? true : false;
		var grp_flg = rowCnt + newCnt - ndlCnt - delCnt == 0 ? true : false;
		if(delCnt.length==0) grp_flg = false;

		sheetObjects[0].CellFont("FontColor", sheetObjects[0].SelectRow, 1, sheetObjects[0].SelectRow, sheetObjects[0].LastCol) = sheetObjects[0].RgbColor(0,0,0) ;
		if(amdt_seq!=0){
			sheetObjects[0].CellFont("FontColor", sheetObjects[0].SelectRow, 1, sheetObjects[0].SelectRow, sheetObjects[0].LastCol)= grp_sts ? sheetObjects[0].RgbColor(255,0,0) : sheetObjects[0].RgbColor(0,0,0);
			sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "n1st_cmnc_amdt_seq") = grp_sts ? document.form.amdt_seq.value : document.form.pre_amdt_seq.value;
			changeSelectBackColor(sheetObjects[0], sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
			if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "src_info_cd")!="NW"){
				sheetObjects[0].CellFont("FontStrikethru", sheetObjects[0].SelectRow, 1, sheetObjects[0].SelectRow, sheetObjects[0].LastCol) = grp_flg;				
			}
			sheetObjects[0].CellValue2(sheetObjects[0].SelectRow, "ibflag") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ibflag")== "I" ? "I" : "R";
		}
	}
	
	/**
	* Status 에 따라 버튼의 활성화를 조절
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     buttonControl();
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/				
	function buttonControl(){
		var formObj = document.form;
		var req_usr_flg = formObj.req_usr_flg.value;
		var apro_usr_flg = formObj.apro_usr_flg.value;
		var amdt_seq = formObj.amdt_seq.value;
		var sts = formObj.prop_sts_cd.value;
		var row_cnt = sheetObjects[0].RowCount;
		try{
			sheetObjects[0].Editable = false;
			sheetObjects[1].Editable = false;
			enableButton("btn_retrieve");
			disableButton("btn_save");
			disableButton("btn_acceptall");
			disableButton("btn_cancelall");
			disableButton("btn_glinecopy");
			disableButton("btn_rowadd1");
			disableButton("btn_delete1");
			disableButton("btn_rowadd2");
			disableButton("btn_delete2");
			disableButton("btn_amend");
			disableButton("btn_amendcancel");
			disableButton("btn_accept");
			disableButton("btn_acceptcancel");
			
			showButton("btn_amendcancel");
			showButton("btn_amend");
			
			if(amdt_seq==0){
				hiddenButton("btn_amendcancel");
				hiddenButton("btn_amend");
			}

			sheetObjects[0].InitDataProperty(0, 7, dtData, 100, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, false, false, 4, true);
			sheetObjects[0].InitDataProperty(0, 8, dtData, 120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, false, false, 100);
			sheetObjects[1].InitDataProperty(0, 8, dtPopupEdit, 120, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, false, 5, true);							
			
			switch(sts) {
				case 'I':   // Initial
					if(req_usr_flg=="true"||apro_usr_flg=="true"){
						sheetObjects[0].Editable = true;
						sheetObjects[1].Editable = true;	
						if(amdt_seq==0){
							sheetObjects[0].InitDataProperty(0, 7, dtData, 100, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, true, true, 4, true);
							sheetObjects[0].InitDataProperty(0, 8, dtData, 120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, true, true, 100);
							sheetObjects[1].InitDataProperty(0, 8, dtPopupEdit, 120, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, true, true, 5, true);							
						}else{
							sheetObjects[0].InitDataProperty(0, 7, dtData, 100, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, false, true, 4, true);
							sheetObjects[0].InitDataProperty(0, 8, dtData, 120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, false, true, 100);							
							sheetObjects[1].InitDataProperty(0, 8, dtPopupEdit, 120, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, true, 5, true);
						}
						enableButton("btn_save");					
						enableButton("btn_rowadd1");
						enableButton("btn_delete1");
						enableButton("btn_rowadd2");
						enableButton("btn_delete2");
						enableButton("btn_amend");
						enableButton("btn_amendcancel");	
						if(row_cnt==0){
							enableButton("btn_glinecopy");
						}else{
							disableButton("btn_glinecopy");
						}						
					}
					break;
					
				case 'Q':   // Requested

					if(apro_usr_flg=="true"){
						
						sheetObjects[0].Editable = true;
						sheetObjects[1].Editable = true;							
						enableButton("btn_acceptall");
						enableButton("btn_cancelall");
						enableButton("btn_accept");
						enableButton("btn_acceptcancel");
					}
					break;
					
				case 'R':   // Returned
					if(req_usr_flg=="true"||apro_usr_flg=="true"){
						enableButton("btn_accept");
						enableButton("btn_acceptcancel");
					}				
					break;
					
				case 'P':   // Approved
				case 'F':   // Filed
				case 'C':   // Cancled
					break;		
			}	
			
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

	/**
	* 대상 sheet 의 Cell 의 값이 변경되었을 경우 호출
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     sheet1_OnChange(sheetObj, Row, Col, Value) ;
	* </pre>
	* @return 없음
	* @author 변영주
	* @version 2009.05.17
	*/		
	function sheet1_OnChange(sheetObj, Row, Col, Value) {

    	var colname = sheetObj.ColSaveName(Col);  
    	var formObj = document.form
    	switch(colname)
    	{
	    	case "prc_grp_loc_cd":	    	
	    		var code = doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
	    		var code2 = doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC07);
	    		if(code!="OK" && code2!="OK"){
		    		sheetObj.CellValue2(Row,"prc_grp_loc_cd") = code;
	    			sheetObj.SelectCell(Row, Col);		    		
	    			return;
	    		}	    		
	    		if (Value.length==4){
	    			sheetObj.SelectCell(Row, Col+1);
	    		}else{	   
	    			sheetObj.CellValue2(Row,"prc_grp_loc_cd") = "";	    		
  					sheetObj.CellValue2(Row, "prc_grp_loc_desc") = "";	    	
  					sheetObj.SelectCell(Row, "prc_grp_loc_cd")  				
	    		}
	    		break;
	    	
    	}
		
	}		
	
	/* 개발자 작업 끝 */