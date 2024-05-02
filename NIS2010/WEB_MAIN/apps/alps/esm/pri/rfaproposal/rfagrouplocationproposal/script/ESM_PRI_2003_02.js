/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2003_02.js
*@FileTitle : RFA Proposal Creation - Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.08.10 최성민
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
     * @class ESM_PRI_2003_02 : ESM_PRI_2003_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2003_02() {
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
	
	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 최성민
     * @version 2009.10.28
     */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
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
					if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02)){
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
					if(validateForm(sheetObject2,formObject,MODIFY03)) {
						doActionIBSheet(sheetObjects[1],document.form,MODIFY03);
						applyMasterStyle(sheetObjects[1]);
					}
					break;	
					
				case "btn_acceptcancel":
					if(validateForm(sheetObject2,formObject,MODIFY04)) {
						doActionIBSheet(sheetObjects[1],document.form,MODIFY04);
						applyMasterStyle(sheetObjects[1]);										
						break;
					}
			
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
    * @author 최성민
    * @version 2009.10.28
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
    * @author 최성민
    * @version 2009.05.17
    */
	function loadPage() {

		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		buttonControl();
        parent.loadTabPage();
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
    * @author 최성민
    * @version 2009.05.22
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
					
					var HeadTitle = "|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Ori/Dst|Group Code|Description|prc_prog_sts_cd|src_info_cd";
					
					var headCount = ComCountHeadTitle(HeadTitle);
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false);		
					
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
					InitDataProperty(0, cnt++, dtCombo, 		70, daCenter, 	false, "org_dest_tp_cd",	true, "", dfNone, 		0, true, 	true);
					InitDataProperty(0, cnt++, dtData, 			90, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, false, false, 4, true);
					InitDataProperty(0, cnt++, dtData, 			120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, false, false, 100);
					InitDataProperty(0, cnt++, dtHidden, 		20, daLeft, false, "prc_prog_sts_cd", true, "", dfEngKey, 0, true, true, 100);
					InitDataProperty(0, cnt++, dtHidden, 		20, daLeft, false, "src_info_cd", true, "", dfEngKey, 0, true, true, 100);
				
	                InitDataCombo(0, "org_dest_tp_cd", orgDestTpCdComboText, orgDestTpCdComboValue); 
	                
					InitDataValid(0, "prc_grp_loc_cd", vtEngUpOther, "1234567890");
					ShowButtonImage = 2;
					// ScrollBar = 2;
                    WaitImageVisible = false;
		
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

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false)
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					var HeadTitle = "|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Group Location Detail Seq.|" +
							"Location Code|Description|EFF Date|EXP Date|Source|Status|n1st_cmnc_amdt_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);
					
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 	40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 		40, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);					
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "grp_loc_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "grp_loc_dtl_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit, 	110, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, false, 5, true);
					InitDataProperty(0, cnt++, dtData, 			170, daLeft, false, "loc_nm", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			70, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			70, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");

	                InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue, "", "NW");            
	                InitDataCombo(0, "prc_prog_sts_cd", prcProgStsCdComboText, prcProgStsCdComboValue, "", "I");

					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					InitDataValid(0, "loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 					
					ShowButtonImage = 2;
					//ScrollBar = 0;
                    WaitImageVisible = false;
		
				}
				break;
				
			case "sheet3":
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
		
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					var HeadTitle = "|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Group Location Detail Seq.|" +
							"Location Code|Description|EFF Date|EXP Date|Source|Status|n1st_cmnc_amdt_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);
					
					InitColumnInfo(headCount, 0, 0, true);
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 	40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 		40, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "prop_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "amdt_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "svc_scp_cd", true, "", dfNone, 0, false, false);					
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "grp_loc_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, false, "grp_loc_dtl_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit, 	110, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, false, 5, true);
					InitDataProperty(0, cnt++, dtData, 			170, daLeft, false, "loc_nm", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			70, daCenter, false, "eff_dt", false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 			70, daCenter, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, false, "src_info_cd", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 		60, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");
					
					//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					InitDataValid(0, "loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
					ShowButtonImage = 2;
					//ScrollBar = 0;
                    WaitImageVisible = false;
		
				}
				break;

		}
	}
     
    /**
     * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
     * sheet1의 전체체크를 컨트롤한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @return 없음
     * @author 최성민
     * @version 2009.05.19
     */		
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
     /**
      * OnBeforeCheck 이벤트 발생시 호출되는 function <br>
      * sheet2의 전체체크를 컨트롤한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
      * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @return 없음
      * @author 최성민
      * @version 2009.05.19
      */		
  	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName = sheetObj.ColSaveName(Col);

  		if (colName == "chk") {
  			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
  		}
  	}
  	
    /**
    * OnClick 이벤트 발생시 호출되는 function <br>
    * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
    */		
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if (OldRow != NewRow) {
			//하이라이트 처리
			changeSelectBackColor4Master(sheetObj, document.form);
		}
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
    * OnChange 이벤트 발생시 호출되는 function <br>
    * COMMBO에 없는 코드를 입력할 경우 서버를 검색해서 데이터가 존재하면 코드값을 화면에 출력하는 function  <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
    * @return 없음
    * @author 최성민
    * @version 2009.04.17
    */  
	function sheet1_OnChange(sheetObj, Row, Col, Value) {

    	var colname = sheetObj.ColSaveName(Col);  
    	var formObj = document.form
    	
		if (colname == "prc_grp_loc_cd") {
					
    		if (Value.length != 4){
    			sheetObj.CellValue2(Row, "prc_grp_loc_cd") = "";
				sheetObj.SelectCell(Row, "prc_grp_loc_cd", false);
				return false;
    		}
    		
    		//Rate, Arbitrary 화면에서 사용중이면 수정불가 
    		formObj.f_cmd.value = SEARCH03;
    		var sParam = FormQueryString(formObj);
    		sParam += "&prc_grp_loc_cd=" + sheetObj.CellSearchValue(Row, "prc_grp_loc_cd");
    		sParam += "&ibflag=U"; // BC함수가 배열로 sheet 파라미터를 받기 때문에 사용함.

			var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_02GS.do", sParam);
			var arrDesc = ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
			var rsltCnt = ComPriGetRowCountFromXML(sXml);
    		
			if(rsltCnt > 0){
				var txt = "";
				var desc = "";				
				for(var i=0;i<arrDesc.length;i++){
					if(desc!=arrDesc[i][0]){
						txt += "\n["+arrDesc[i][0]+"] : \n   ";
					}
					txt += "-" + arrDesc[i][1]+" ";
					desc = arrDesc[i][0];
				}

				sheetObj.CellValue2(Row, "prc_grp_loc_cd") = sheetObj.CellSearchValue(Row, "prc_grp_loc_cd");
				sheetObj.SelectCell(Row, "prc_grp_loc_cd", false);
				ComShowCodeMessage("PRI08019", txt);	
				return false;
			}
	
			sheetObj.SelectCell(Row, Col+1);
    	}
	}
    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * COMMBO에 없는 코드를 입력할 경우 서버를 검색해서 데이터가 존재하면 코드값을 화면에 출력하는 function  <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */  	
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		var amdt_seq = formObj.amdt_seq.value;
		var sts = sheetObj.CellValue(Row, "src_info_cd");
		if (sName == "loc_cd") {
			if (Value.length == 5) {		
				formObj.f_cmd.value = COMMAND31;
				var sParam = FormQueryString(formObj);
				sParam += "&cd="+Value;
				sParam += "&etc1="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd");
				
				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
				var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObjects[1].CellValue2(Row, "loc_nm") = arrDesc[0][1];
					
					if(sts=="PC"){
						sheetObj.CellValue2(Row, "src_info_cd") = "PM";
					}else if(sts=="GC"){
						sheetObj.CellValue2(Row, "src_info_cd") = "GM";
					}
					
				} else {
					ComShowCodeMessage("PRI01099", Value, sheetObjects[0].CellText(sheetObjects[0].SelectRow, "org_dest_tp_cd"));
					sheetObj.CellValue2(Row, "loc_cd") = "";
					sheetObj.CellValue2(Row, "loc_nm") = "";
					sheetObj.SelectCell(Row, "loc_cd");	
					return false;
				}
			} else {
				sheetObj.CellValue2(Row, "loc_cd") = "";
				sheetObj.CellValue2(Row, "loc_nm") = "";
				sheetObj.SelectCell(Row, "loc_cd");				
				return false;
			}
		}		
	}
	

	var isFiredNested = false;
	var supressConfirm = false;
   /**
    * SHEET의 ROW을 클릭할때 호출되는 function <br>
    * sheet의 Row를 선택하면 해당 Row를 해당하는 자식SHEET를 조회한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetM 필수 HTML태그(Object) 오브젝트
    * @param {ibsheet} sheetD 필수 HTML태그(Object) 오브젝트
    * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @param {string} appendRow 필수 SHEET Row 추가 유무
    * @return 없음
    * @author 최성민
    * @version 2009.05.19
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
					//master 가 수정되었을 경우 저장을 먼저 선행해야함.(ori/dst)때문
					if(sheetM.RowStatus(OldRow) == "U") {
						var rslt = false;
						if (ComShowCodeConfirm("PRI00006")) {
							supressConfirm = true;
							rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
							supressConfirm = false;
						}
						
						if (rslt) {
							isFiredNested = true;
							sheetM.SelectCell(NewRow, NewCol, false);
							isFiredNested = false;
						} else {
							isFiredNested = true;
							sheetM.SelectCell(OldRow, OldCol, false);
							isFiredNested = false;
							return -1;
						}
												
					} else {
						isFiredNested = true;
						sheetM.SelectCell(NewRow, NewCol, false);
						isFiredNested = false;
					}
					
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
    * @author 최성민
    * @version 2009.05.22
    */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
				case IBSEARCH: // 조회
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}

	  				ComOpenWait(true);
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch("ESM_PRI_2003_02GS.do" , FormQueryString(formObj));
					buttonControl();
					break;
					
				case IBSEARCHAPPEND: // 조회
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value = SEARCH02;
						sheetObj.DoSearch("ESM_PRI_2003_02GS.do" , FormQueryString(formObj));
					}
					break;

				case IBSEARCH_ASYNC01: // ORI/DEST코드 VALIDATION 
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}

					formObj.f_cmd.value = MULTI07;
					var sParam = FormQueryString(formObj);					
			 		var sParamSheet = sheetObjects[1].GetSaveString(true);
					if (sParamSheet != "") {
						sParam = ComPriSetPrifix(sParamSheet, "sheet1_loc_check_") + "&" + sParam;
						sParam = sParam + "&sheet1_loc_check_org_dest_tp_cd="+sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd");
				 		sParam = sParam + "&sheet1_loc_check_org_dest_tp_nm="+sheetObjects[0].CellText(sheetObjects[0].SelectRow, "org_dest_tp_cd");
					}
									
					var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_02GS.do", sParam);
					var sValue = ComGetEtcData(sXml, "ORI_DST_CHECK");
					
					if(sValue != ""){
						ComShowCodeMessage("PRI01099", sValue, sheetObjects[0].CellText(sheetObjects[0].SelectRow, "org_dest_tp_cd"));
						return false;
					} else {
						return true;
					}
					break;		
					
				case IBSEARCH_ASYNC02: // 조회 - Group 삭제시 rate 사용여부 확인
					if (validateForm(sheetObj,document.form,sAction)) {
				    	//공통 Source
						var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
				    	
						if(chkArr.length == 0){
							sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
						}	
						chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
						
						//ROW ADD후 저장하지 않고 DELETE처리시 적용
						for(var i=0; i < chkArr.length; i++){
							if(sheetObj.RowStatus(chkArr[i]) == "I") {
								sheetObj.CellValue2(chkArr[i], "chk")= "0";
								
							}	
						}
						
						chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
											
						if(chkArr == "" || chkArr == null){
							return true;
						}
						
						var sParam = "f_cmd="+SEARCH03+"&" + sheetObj.GetSaveString(false, false, "chk");
						var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_02GS.do", sParam);
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
	
				case IBSEARCH_ASYNC03: // 저장 - Group 전체가 지워졌을 경우 validation ( 사용중 Group 삭제 불가 )
					if (validateForm(sheetObj,document.form,sAction)) {
			   			var amdt_seq = formObj.amdt_seq.value;
		   	
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
												
							var sXml = sheetObj.GetSearchXml("ESM_PRI_2003_02GS.do", sParam);
							var arrDesc = ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
							var rsltCnt = ComPriGetRowCountFromXML(sXml);
							
							var txt = "";
							var desc = "";
							
							if(rsltCnt <= 0){
								return false;
							}
													
							for(var i=0; i<arrDesc.length; i++){
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
					
				case IBSAVE: // 저장
	
					isFiredNested = false;
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					
					// ORI/DEST 체크
					if(!doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01)) {
						return false;
					}
					
					if (!supressConfirm && !ComPriConfirmSave()) {
						return false;
					}
					
	  				ComOpenWait(true);
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
										
					var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_02GS.do", sParam);
											
					isFiredNested = true;
					sheetObjects[0].LoadSaveXml(sXml);
					sXml = ComDeleteMsg(sXml);
					sheetObjects[1].LoadSaveXml(sXml);
					isFiredNested = false;
					
					if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
						return false;
					} else {
						if(isGrpDel){
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						}
					}
			
					buttonControl();
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
							sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
							sheetObj.CellValue2(idx, "src_info_cd") = "NW";
							sheetObjects[1].RemoveAll();
							sheetObj.CellValue2(idx, "grp_loc_seq") = parseInt(ComPriGetMax(sheetObj, "grp_loc_seq")) + 1;
							sheetObj.CellValue2(idx, "org_dest_tp_cd") = "";
							sheetObj.SelectCell(idx, "org_dest_tp_cd", false);
							
							formObj.grp_loc_seq.value = parseInt(ComPriGetMax(sheetObj, "grp_loc_seq")) + 1;
						}else if (sheetObj.id == "sheet2") {
							if(sheetObjects[0].RowCount==0){
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
							sheetObj.CellValue2(idx, "eff_dt") = eff_dt;
							sheetObj.CellValue2(idx, "exp_dt") = exp_dt;						
							sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
							sheetObj.CellValue2(idx, "src_info_cd") = "NW";
							sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = amdt_seq;
							
							var grp_loc_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_loc_seq");
							sheetObj.CellValue2(idx, "grp_loc_seq") = grp_loc_seq;
							sheetObj.CellValue2(idx, "grp_loc_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq")) + 1;
			    			sheetObj.SelectCell(idx, "loc_cd");
			    			
			    			//하이라이트처리
							changeSelectBackColor(sheetObj, sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
							
						}
						
						
						if(amdt_seq != 0){
							sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);								
						}
						
					}
					break;
					
				case IBDELETE: // Delete
					if(!validateForm(sheetObj, formObj, IBDELETE)) {
						return false;
					}
						
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
								if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
									sheetObjects[1].RemoveAll();
								}
								
					        	var delCnt = deleteRowCheck(sheetObj, "chk");
								if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
									sheetObjects[1].RemoveAll();
								}
							}
							deleteRowCheck(sheetObj, "chk");
						}
					}else{
						if (sheetObj.id == "sheet1") {
							isGrpDel = true;
							
							for(j=0;j < chkArr.length;j++){							
								sheetObj.CellFont("FontStrikethru", chkArr[j], 1, chkArr[j], sheetObj.LastCol)=true;
								sheetObj.CellFont("FontColor", chkArr[j], 1, chkArr[j], sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
								if(sheetObj.CellValue(chkArr[j],"src_info_cd")!= "NW"){
									sheetObj.RowStatus(chkArr[j])="D";
									sheetObj.CellValue2(chkArr[j],"chk")= "0";
								}							
							}
													
							
							var row = 0;
							sheetObjects[1].CheckAll2("chk") = "1";
							var chkArrDtl = ComPriSheetFilterRows(sheetObjects[1], "chk", "1");
						    for(i=0;i<chkArrDtl.length;i++){
						    	if(sheetObjects[1].CellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq&&sheetObjects[1].RowStatus(chkArrDtl[i])!="I"){
	   								comSheetAmendCancelRow(sheetObjects[1],formObj,chkArrDtl[i],"A", "loc_cd");
	   							}else if(sheetObjects[1].CellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq&&sheetObjects[1].RowStatus(chkArrDtl[i])=="I"){
									sheetObjects[1].RowStatus(chkArr[i])="D";
									sheetObjects[1].RowEditable(chkArr[i])=false;
									sheetObjects[1].RowHidden(chkArr[i]) = true;
	  							}
						    }
					    
						    sheetObjects[1].CheckAll2("chk") = "1";
							if(sheetObjects[1].RowCount>0){
							    doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
							}
							
							
							if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
	
				        	var delCnt = deleteRowCheck(sheetObj, "chk");
							if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
								sheetObjects[1].RemoveAll();
							}
							
						}else{
							for(i=0;i < chkArr.length;i++){
								if(sheetObj.CellValue(chkArr[i],"amdt_seq")!=amdt_seq||(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq&&
								(sheetObj.CellValue(chkArr[i],"src_info_cd")!="NW"&&sheetObj.CellValue(chkArr[i],"src_info_cd")!="GC"&&sheetObj.CellValue(chkArr[i],"src_info_cd")!="GM"))){
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
					

					//DETAIL의 모든 ROW를 삭제할경우 체크
					if (!isGrpDel && sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
						if(ComShowCodeConfirm('PRI00021')){
			  				ComOpenWait(true);
			  				//MASTER에 체크되어 있는 데이터를 언체크한다.
							sheetObjects[0].CheckAll2("chk") = 0;
							//ARB, RATE화면에서 사용중인지 체크한다. 사용중이면 재조회
							if(!doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02)){
								formObj.grp_loc_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_loc_seq");
								doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
								return false;
							} else {
								isGrpDel = true;
								
								if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "chk") == "1") {
									sheetObjects[1].RemoveAll();
								}
								
								var delCnt = deleteRowCheck(sheetObjects[0], "chk");

								if (delCnt > 0 && sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) == "D") {
									sheetObjects[1].RemoveAll();
								}
							}
						}
					}
					
					/*
					if(!isGrpDel && getValidRowCount(sheetObjects[1]) <= 0 && ComShowCodeConfirm('PRI00021')){
	
						if(sheetObjects[0].RowStatus(sheetObjects[0].SelectRow)!="I"){
							sheetObjects[0].RowHidden(sheetObjects[0].SelectRow) = true;							
						}
						sheetObjects[0].RowStatus(sheetObjects[0].SelectRow) = "D";
	
						isGrpDel = true;
					}
					
					else {
						formObj.grp_loc_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_loc_seq");
						doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
					}
					*/
					break;
					
				case IBCOPYROW: // Guideline Copy
					formObj.f_cmd.value = MULTI06;
	
					var sParam = FormQueryString(formObj);
					if (!supressConfirm && !ComShowCodeConfirm("PRI03006")) {
						return false;
					}

	  				ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_02GS.do", sParam);
									
					formObj.f_cmd.value = SEARCH02;				
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					
					sheetObjects[1].LoadSaveXml(sXml);
					break;	
				
				case MODIFY01: // Accept All

					if(!validateForm(sheetObj, formObj, MODIFY01)) {
						return false;
					}
						
					if (!supressConfirm && !ComShowCodeConfirm('PRI01015')) {
						return false;
					}	

	  				ComOpenWait(true);
					formObj.f_cmd.value = MULTI02;
					var sParam = FormQueryString(formObj);
					
					var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_02GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);

					if(ComGetEtcData(sXml,"result")!="OK"){
						return;
					}
					
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				
				case MODIFY02: // Cancel All

					if(!validateForm(sheetObj, formObj, MODIFY01)) {
						return false;
					}
					
					if (!supressConfirm && !ComShowCodeConfirm('PRI01010')) {
						return false;
					}			

	  				ComOpenWait(true);
					formObj.f_cmd.value = MULTI03;
					var sParam = FormQueryString(formObj);
		
					var sXml = sheetObj.GetSaveXml("ESM_PRI_2003_02GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);

					if(ComGetEtcData(sXml,"result")!="OK"){
						return;
					}
	
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;			
	
				case MODIFY03: // Accept
				
					if (!supressConfirm && !ComShowCodeConfirm('PRI00008')) {
						return false;
					}			
					formObj.f_cmd.value = MULTI04;
					comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2003_02GS.do");				
					break;	
					
				case MODIFY04: // Accept Cancel
				
					if (!supressConfirm && !ComShowCodeConfirm('PRI00009')) {
						return false;
					}						
					formObj.f_cmd.value = MULTI05;
					comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2003_02GS.do");							
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
					sheetObj.SelectCell(sheetObj.SelectRow, "loc_cd");
					
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
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}finally {
			 ComOpenWait(false);
		}
	}
	

    /**
    * OnPopupClick 이벤트 발생시 호출되는 function <br>
    * Location PopUp을 호출한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 최성민
    * @version 2009.05.07
    */ 	 	 
 	function sheet2_OnPopupClick(sheetObj, Row, Col)
 	{
 		var colName = sheetObj.ColSaveName(Col);
 		var formObj = document.form;
 		var sts     = formObj.prop_sts_cd.value;
 		
       	switch(colName)
       	{
   	    	case "loc_cd":
   	    		var sUrl = "/hanjin/ESM_PRI_4026.do?";
   	 			sUrl += "group_cmd=" + PRI_RP_SCP ;
   	 			sUrl += "&location_cmd=L";
   	 			sUrl += "&svc_scp_cd=" + formObj.svc_scp_cd.value;
   	 			sUrl += "&prop_no=" + formObj.prop_no.value;
   	 			sUrl += "&amdt_seq=" + formObj.amdt_seq.value;
   	 			sUrl += "&org_dest_cd="+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd");
   	 			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
   	 			if (rtnVal != null){
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
    * @author 최성민
    * @version 2009.04.17
    */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
			
		case IBSEARCHAPPEND: // 조회
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
			
		case IBSEARCH_ASYNC01: // 조회
			break;
			
		case IBSEARCH_ASYNC02: // 조회
			break;		
		
		case IBSEARCH_ASYNC03: // 조회
			break;		
			
		case IBSAVE: // 저장

			if (!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified) {
				ComShowCodeMessage("PRI00301");
				return false;
			}

			if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd") == ""){
				ComShowCodeMessage("PRI01098");
				return false;
			}
		
			if (!isGrpDel&&sheetObjects[1].RowCount <= 0) {
   				ComShowCodeMessage("PRI00319", "Location Group");
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
			if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			
			if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			
			var rowM = ComPriAmendDupCheck(sheetObjects[0], "prc_grp_loc_cd", formObj.amdt_seq.value);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
				return false;
			}

			var rowD = ComPriAmendDupCheck(sheetObjects[1], "amdt_seq|grp_loc_seq|loc_cd", formObj.amdt_seq.value);
			if (rowD >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet2", rowD);
				return false;
			}
			
			break;
			
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
		
			if (sheetObj.id == "sheet2") {				
				if (getValidRowCount(sheetObjects[0]) == 0) {
					ComShowCodeMessage("PRI01004");
					return false;					
				}
				
				if(sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd") == ""){
					ComShowCodeMessage("PRI01098");
					return false;
				}
			}
		
			break;
			
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			
			if (getValidRowCount(sheetObj) == 0) {
				return false;					
			}
			
			break;
			
		case MODIFY01: // Accept All
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}

  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;
			
  		case MODIFY02: // Cancel
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}

  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;	
			
		case MODIFY03: // Accept
		
			// 선택된 ROW 리스트/////////////////////////////////
			var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
		
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.CellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
			
				if(sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
				}
			}
			break;
			
		case MODIFY04: // Accept cancel
			// 선택된 ROW 리스트/////////////////////////////////
			var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.CellValue(sheetObj.SelectRow, "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
			}	
			chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
		
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.CellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
		
				if(sheetObj.CellValue(chkArr[i], "prc_prog_sts_cd") == "I") {
					ComShowCodeMessage("PRI01038");
					return false;
				}
			}
			break;	
		}

		return true;
	}
 	/**
    * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
    * 화면이 보여지며 조회를 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    * tabLoadSheet("ACE", "1")
    * </pre>
    * @param {string} sPropNo 필수 prop_no 값
    * @param {string} sAmdtSeq 필수 amdt_seq 값
    * @param {string} sSvcScpCd 필수 svc_scp_cd 값
    * @param {string} sPreAmdtSeq 필수 pre_amdt_seq 값
    * @param {string} sPropStsCd 필수 pro_sts_cd 값
    * @param {string} sEffDt 필수 eff_dt 값
    * @param {string} sExpDt 필수 exp_dt 값
    * @param {string} sPreExpDt 필수 pre_exp_dt 값
    * @return 없음
    * @author 최성민
    * @version 2009.05.21
    */
	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg) {
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
			formObject.req_usr_flg.value = sIsReqUsr;
			formObject.apro_usr_flg.value = sIsAproUsr ;	
//			formObject.dur_dup_flg.value = sDurDupFlg ;
			formObject.dur_dup_flg.value = "Y" ;	
	        askOnce = true;
	        
			buttonControl();

			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}
	/**
    * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
    * <br><b>Example :</b>
    * <pre>
    * tabClearSheet()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 최성민
    * @version 2009.05.20
    */		
	function tabClearSheet() {
		var formObject = document.form;

		formObject.prop_no.value = "";
		formObject.amdt_seq.value = "";
		formObject.svc_scp_cd.value = "";
		formObject.pre_amdt_seq.value = "";
		formObject.prop_sts_cd.value = "";
		formObject.eff_dt.value = "";
		formObject.exp_dt.value = "";			
		formObject.pre_exp_dt.value = "";
		formObject.req_usr_flg.value = "";
		formObject.apro_usr_flg.value = "";
		formObject.dur_dup_flg.value = "";
		
        askOnce = true;
        
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		buttonControl("CLEAR");
	}
	
	var enableFlag = true;

	/**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */		
	function tabEnableSheet(flag) {
		var formObject = document.form;
		
		enableFlag = flag;
		
		sheetObjects[0].Editable = flag;
		sheetObjects[1].Editable = flag;
	}

	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.20
	 */ 
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		var amdt_seq = document.form.amdt_seq.value;
		var pre_exp_dt = document.form.pre_exp_dt.value;
		var sts = document.form.prop_sts_cd.value;
		if(sts=="I"){
			if(amdt_seq==0){
				sheetObj.InitDataProperty(0, 8, dtPopupEdit, 110, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, true, true, 5, true);
			}else{
				sheetObj.InitDataProperty(0, 8, dtPopupEdit, 110, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, true, 5, true);				
			}
		}else{
			sheetObj.InitDataProperty(0, 8, dtPopupEdit, 110, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, false, 5, true);			
		}

		if(amdt_seq!=0){
			for(i=1 ; i < sheetObj.Rows; i++){
				if(sheetObj.CellValue(i,"amdt_seq") != amdt_seq){ 
					sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol)=true;
					sheetObj.RowEditable(i) = false;						
				}
				else if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
					sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
					if(sts == "I"&&sheetObj.CellValue(i,"src_info_cd")!="AD"){
						sheetObj.CellEditable(i,"loc_cd") = true;						
					}
				}
			}
		}
	}
	
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
	 * @return 없음
	 * @author 최성민
	 * @version 2009.05.20
	 */ 	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj = document.form;
		var rCnt = sheetObj.RowCount;
		var amdt_seq = formObj.amdt_seq.value;
		var sts = formObj.prop_sts_cd.value;
	
		for(i=1;i<=rCnt;i++){
			if(amdt_seq!=0){
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
		//하이라이트 처리
		changeSelectBackColor4Master(sheetObj, formObj);
	
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

		var rowCnt = ComPriSheetFilterRows(sheetObj, "prc_prog_sts_cd", "A");
		var newCnt = ComPriSheetFilterRows(sheetObj, "src_info_cd|n1st_cmnc_amdt_seq", "NW|"+amdt_seq);
		var ndlCnt = ComPriSheetFilterRows(sheetObj, "src_info_cd|ibflag", "NW|D");
		var amdCnt = ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq);
		var delCnt = ComPriSheetFilterRows(sheetObj, "src_info_cd|amdt_seq", "AD|"+amdt_seq);
		var actCnt = ComPriSheetFilterRows(sheetObj, "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|A");

		var grp_sts = amdCnt.length == ndlCnt.length ? false : true;
		var grp_flg = rowCnt.length + newCnt.length - ndlCnt.length == delCnt.length ? true : false;
		var grp_act = amdCnt.length == actCnt.length ? true : false ;
		if(delCnt.length==0) grp_flg = false;

		sheetObjects[0].CellFont("FontColor", sheetObjects[0].SelectRow, 1, sheetObjects[0].SelectRow, sheetObjects[0].LastCol) = sheetObjects[0].RgbColor(0,0,0) ;
		if(amdt_seq!=0){
			sheetObjects[0].CellFont("FontColor", sheetObjects[0].SelectRow, 1, sheetObjects[0].SelectRow, sheetObjects[0].LastCol)= grp_sts ? sheetObjects[0].RgbColor(255,0,0) : sheetObjects[0].RgbColor(0,0,0);
			sheetObjects[0].CellFont("FontStrikethru", sheetObjects[0].SelectRow, 1, sheetObjects[0].SelectRow, sheetObjects[0].LastCol) = grp_flg;
		}

		//하이라이트 처리
		changeSelectBackColor4Master(sheetObjects[0], formObj);
	}
	
	/**
    * 버튼 권한 컨트롤 function <br>
    * 버튼을 제어한다. <br>
    * <br><b>Example :</b>
    * <pre>
    * buttonControl(mode)
    * </pre>
    * @param {string} mode 필수 사용자 권한이나 모드
    * @return 없음
    * @author 최성민
    * @version 2009.04.17
    */		
	function buttonControl(mode){
		var formObj = document.form;
		var req_usr_flg = formObj.req_usr_flg.value;
		var apro_usr_flg = formObj.apro_usr_flg.value;
		var amdt_seq = formObj.amdt_seq.value;
		var sts = formObj.prop_sts_cd.value;
		var row_cnt = sheetObjects[0].RowCount;
		try{
			sheetObjects[0].Editable = false;
			sheetObjects[1].Editable = false;
			ComBtnDisable("btn_retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_acceptall");
			ComBtnDisable("btn_cancelall");
			ComBtnDisable("btn_glinecopy");
			ComBtnDisable("btn_rowadd1");
			ComBtnDisable("btn_delete1");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_delete2");
			ComBtnDisable("btn_amend");
			ComBtnDisable("btn_amendcancel");
			ComBtnDisable("btn_accept");
			ComBtnDisable("btn_acceptcancel");
			
			showButton("btn_amendcancel");
			showButton("btn_amend");
			
			if(amdt_seq==0){
				hiddenButton("btn_amendcancel");
				hiddenButton("btn_amend");
			}
			sheetObjects[0].InitDataProperty(0, 7, dtCombo, 70, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, false);
			sheetObjects[0].InitDataProperty(0, 8, dtData, 90, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, false, false, 4, true);
			sheetObjects[0].InitDataProperty(0, 9, dtData, 120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, false, false, 100);
			sheetObjects[1].InitDataProperty(0, 8, dtPopupEdit, 110, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, false, 5, true);							

			if(mode == "CLEAR") {
				return;
			}
			
			switch(sts) {
				case 'I':   // Initial
					ComBtnEnable("btn_retrieve");
					if(req_usr_flg=="true"||apro_usr_flg=="true"){
						sheetObjects[0].Editable = true;
						sheetObjects[1].Editable = true;	
						if(amdt_seq==0){
							sheetObjects[0].InitDataProperty(0, 7, dtCombo, 70, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, true, true);
							sheetObjects[0].InitDataProperty(0, 8, dtData, 90, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, true, true, 4, true);
							sheetObjects[0].InitDataProperty(0, 9, dtData, 120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, true, true, 100);
							sheetObjects[1].InitDataProperty(0, 8, dtPopupEdit, 110, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, true, true, 5, true);							
						}else{
							sheetObjects[0].InitDataProperty(0, 7, dtCombo, 70, daCenter, false, "org_dest_tp_cd", true, "", dfNone, 0, false, true);
							sheetObjects[0].InitDataProperty(0, 8, dtData, 90, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, false, true, 4, true);
							sheetObjects[0].InitDataProperty(0, 9, dtData, 120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, false, true, 100);							
							sheetObjects[1].InitDataProperty(0, 8, dtPopupEdit, 110, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, true, 5, true);
						}
						ComBtnEnable("btn_save");					
						ComBtnEnable("btn_rowadd1");
						ComBtnEnable("btn_delete1");
						ComBtnEnable("btn_rowadd2");
						ComBtnEnable("btn_delete2");
						ComBtnEnable("btn_amend");
						ComBtnEnable("btn_amendcancel");	
						if(row_cnt==0){
							ComBtnEnable("btn_glinecopy");
						}else{
							ComBtnDisable("btn_glinecopy");
						}						
					}
					break;
					
				case 'Q':   // Requested
					ComBtnEnable("btn_retrieve");
					if(apro_usr_flg=="true"){
						
						sheetObjects[0].Editable = true;
						sheetObjects[1].Editable = true;							
						ComBtnEnable("btn_acceptall");
						ComBtnEnable("btn_cancelall");
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					}
					break;
					
				case 'R':   // Returned
					ComBtnEnable("btn_retrieve");
					if(req_usr_flg=="true"||apro_usr_flg=="true"){
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					}				
					break;
					
				case 'A':   // Approved
					ComBtnEnable("btn_retrieve");
				case 'F':   // Filed
					ComBtnEnable("btn_retrieve");
				case 'C':   // Cancled
					ComBtnEnable("btn_retrieve");
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
    * OnSaveEnd 이벤트 발생시 호출되는 function <br>
    * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
    * @return 없음
    * @author 최성민
    * @version 2009.06.22
    */ 		
  	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
  		var formObj = document.form;
  		//Main 의 Amendment Summary 관련 function
   	 	parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
	}

	/* 개발자 작업 끝 */