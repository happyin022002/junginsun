/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6005_02.js
*@FileTitle : S/C Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
* 1.0 Creation
* 2013.04.22 전윤주 [CHM-201324292] SC Commodity validation 대상 추가
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
     * @class ESM_PRI_6005_02 : ESM_PRI_6005_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_6005_02() {
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
	
	var tabLoad = new Array();
	tabLoad[0] = 0;
	tabLoad[1] = 0;
	
	//현재 이벤트를 저장                                                                                                                                                                                                       
	var eventStatus = "";  
	 
	//현재 선택한  sheet1의 bse_seq                                                                                                                                                                                            
	var selectedGrpCmdtSeq = -1;                                                                                                                                                                                              
	                                                                                                                                                                                                                           
	//현재 선택한  sheet2의 cmpb_seq                                                                                                                                                                                         
	var selectedGrpCmdtDtlSeq = -1; 
	
	// 2013-04-22 전윤주 [CHM-201324292] SC Commodity validation 대상 추가
	var block_cmdt_list = "000000/000002/000004/000005/000010/000017/961900/989200/989201";
	var block_cmdt = block_cmdt_list.split("/");
	
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
	
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
		
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
					
//				case "btn_copy":
//					doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC01);
//					break;
		
				case "btn_rowadd1":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
					
				case "btn_rowadd2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					break;
		
				case "btn_delete1":
					if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02)){
						doActionIBSheet(sheetObjects[0],document.form,IBDELETE);			
					}
					break;
					
				case "btn_delete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
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
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
	
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		var iWidth = window.document.body.clientWidth;
	        
//        if(iWidth > 1024) {
        	sheetColResize();
//        }
	}
	
	
	/**
     * LoadFinish 이벤트 시 발생한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
    function sheet2_OnLoadFinish(sheetObj) {
	   	sheetObj.WaitImageVisible = false; 
	   	toggleButtons("CLEAR");
		parent.loadTabPage();
//	   	sheetObj.WaitImageVisible = true; 
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
		switch (sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 260;
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
					InitColumnInfo(9, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "|Sel.|Seq.|qttn_no|qttn_ver_no|Group Commodity Seq.|Group Code|Description|src_info_cd";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_ver_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_cmdt_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_grp_cmdt_cd", true, "", dfEngUpKey, 0, false, false, 4, true);
					InitDataProperty(0, cnt++, dtData, 200, daLeft, false, "prc_grp_cmdt_desc", true, "", dfEngKey, 0, true, true, 100);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "src_info_cd", true, "", dfNone, 0, false, false);
					
					InitDataValid(0, "prc_grp_cmdt_cd", vtEngUpOnly);
					ShowButtonImage = 2;
					
//					MessageText("UserMsg17") = " " + ComGetMsg("PRI00317");
					
					InitDataValid(0, "prc_grp_cmdt_desc", vtEngOther, PRI_VALID_CHAR);
					WaitImageVisible = false;
				}
				break;
				
			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 260;
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
					InitColumnInfo(12, 0, 0, true);
		
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)
		
					var HeadTitle = "|Sel.|Seq.|qttn_no|qttn_ver_no|Group Commodity Seq.|Group Commodity Detail Seq.|type code|CMDT Code|Description|src_info_cd|Source";
		
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
					// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
					// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
					// SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
					InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
					InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "qttn_ver_no", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_cmdt_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "grp_cmdt_dtl_seq", true, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_cmdt_tp_cd", true, "", dfEngUpKey, 0, false, false);
					InitDataProperty(0, cnt++, dtPopupEdit, 100, daCenter, false, "prc_cmdt_def_cd", true, "", dfEngKey, 0, true, true, 6, true);
					InitDataProperty(0, cnt++, dtData,		200,	daLeft,	  true,	  "prc_cmdt_def_nm",	false,	"",	dfNone,	0, true,  true);	
					InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", false, "", dfEngKey, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "src_info_nm", false, "", dfEngKey, 0, false, false);
					
					InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther,"0123456789");	// 영대문자,숫자만 입력
					InitDataValid(0, "prc_cmdt_def_nm", vtEngUpOnly);
					
					PopupImage  =  "img/btns_search.gif";
					ShowButtonImage = 1;
					
					MessageText("UserMsg17") = " " + ComGetMsg("PRI00318");
					WaitImageVisible = false;
				}
				break;

			case "sheet3":
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
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnBeforeCheck(sheetObj, Row, Col);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row 
     * @param {String} Col 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
	
	/**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet2_OnBeforeCheck(sheetObj, Row, Col);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row 
     * @param {String} Col 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName = sheetObj.ColSaveName(Col);

		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}
	
	/**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if(!isFiredNested) {
   		    selectedGrpCmdtSeq = sheetObj.CellValue(NewRow,"grp_cmdt_seq");
   		    doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
 		}
	}
	
	
	/**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
     function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
   	      if(eventStatus != "IBSAVE")
   		      selectedGrpCmdtDtlSeq = sheetObj.CellValue(NewRow,"grp_cmdt_dtl_seq");   	  
     }
	
	
	/**
     * sheet에서 값이 바뀐 경우 발생한다. <br>
     * src_info_cd 값을 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 
     * @param {int} Col 
     * @param {String} Value 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		
		if(sheetObj.CellValue(Row, "src_info_cd") == "GC") {
			sheetObj.CellValue2(Row, "src_info_cd") = "GM";
		} else {
			sheetObj.CellValue2(Row, "src_info_cd") = "NW"
		}
		
	}
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	 * @return 없음
	 * @author 이승준
	 * @version 2009.04.17
	 */  	
	 function sheet2_OnChange(sheetObj, Row, Col, Value)
	 {
	 	var colname = sheetObj.ColSaveName(Col);  
	 	var formObj = document.form
	 	switch(colname)
	 	{
	    	case "prc_cmdt_def_cd":	    		
	    		if (Value.length==6){
	    			formObj.f_cmd.value = SEARCH08;
	    			formObj.cd.value = Value;

	  				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
	  				
	  				if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])){
						sheetObj.CellValue2(Row,"prc_cmdt_def_nm") = arrData[1];
						sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = "C" ;
						
						if(sheetObj.CellValue(Row, "src_info_cd") == "GC") {
							sheetObj.CellValue2(Row, "src_info_cd") = "GM";
						} else {
							sheetObj.CellValue2(Row, "src_info_cd") = "NW"
						}
						
					}else{
						sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = "";
	  					sheetObj.CellValue2(Row,"prc_cmdt_def_cd") = "";
	  					//ComShowCodeMessage("PRI00315");
	  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
					}	  				
	    		}else{	  
	    			sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = "";	
	    			sheetObj.CellValue2(Row,"prc_cmdt_def_nm") = "";	    		
					sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = "";	
					//ComShowCodeMessage("PRI00315");
					sheetObj.SelectCell(Row, "prc_cmdt_def_cd")  				
	    		}	    	

	    		// 2011-04-04 서미진 [CHM-201109785] TPE Scope, BCO S/C 일 경우 특정 CMDTY 에 대해서 system 으로 차단
				// 2013-04-22 [CHM-201324292] Scope 추가 TPW TAE ASE TAW ASW MME MMW SAN SAS 
				if(( parent.comboObjects[2].Code=="TPE" ||parent.comboObjects[2].Code=="TPW" 
	  			   ||parent.comboObjects[2].Code=="TAE" ||parent.comboObjects[2].Code=="ASE"
			       ||parent.comboObjects[2].Code=="TAW" ||parent.comboObjects[2].Code=="ASW"
			       ||parent.comboObjects[2].Code=="MME" ||parent.comboObjects[2].Code=="MMW"
			       ||parent.comboObjects[2].Code=="SAN" ||parent.comboObjects[2].Code=="SAS")
					
					&& parent.comboObjects[3].Code =="I"){
					for( var i = 0; i <block_cmdt.length ; i++ ){
						if(sheetObj.CellValue(Row,"prc_cmdt_def_cd") == block_cmdt[i]){
	    					ComShowCodeMessage("PRI00357");
	    					sheetObj.CellValue2(Row,"prc_cmdt_def_cd") ="";  
	    					sheetObj.CellValue(Row,"prc_cmdt_def_nm") ="";  
	    					sheetObj.SelectCell(Row, "prc_cmdt_def_cd");
	    					return false;
						}
					}
				}    		
	    		break;
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
	 * @author 이승준
	 * @version 2009.05.07
	 */  	      	 
	function sheet2_OnPopupClick(sheetObj, Row, Col)
	{
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var tpCd = "C";
		
		if (colName == "prc_cmdt_def_cd"){
			var sUrl = "/hanjin/ESM_PRI_4027.do?grp_cd="+ PRI_SG+"&commodity_cmd=C";
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 304, true);
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;			

				sheetObj.CellValue2(Row,"prc_cmdt_tp_cd") = tpCd ;
			}
		}
	}
	
	
	var isFiredNested = false;
	var supressConfirm = false;
	/**
     * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
     * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
     * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @param {String} sAction
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj = document.form;
		var adjNewRow = ComGetValidRow(sheetM,"grp_cmdt_seq",selectedGrpCmdtSeq);
		
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
//			else {
				if (appendRow) {
					isFiredNested = true;
					var idx = sheetM.DataInsert();
					selectedGrpCmdtSeq = sheetM.CellValue(sheetM.SelectRow,"grp_cmdt_seq");
					isFiredNested = false;
					return idx;
				} else {
					formObj.grp_cmdt_seq.value = sheetM.CellValue(adjNewRow, "grp_cmdt_seq");
					doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
					adjNewRow = ComGetValidRow(sheetD,"grp_cmdt_dtl_seq",selectedGrpCmdtDtlSeq);
					sheetD.SelectCell(adjNewRow,0,false);
				}
//			}
			
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
			case IBSEARCH: // 조회
				if (validateForm(sheetObj,document.form,sAction)) {
					
					try {
						for (var i = 0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
							sheetObjects[i].WaitImageVisible = false;
						}
						
						ComOpenWait(true);
						
						
						formObj.f_cmd.value = SEARCH01;
						sheetObj.DoSearch("ESM_PRI_6005_02GS.do" , FormQueryString(formObj));
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
				} 
				break;
				
			case IBSEARCHAPPEND: // 조회
				if (validateForm(sheetObj,document.form,sAction)) {
					
					try {
						sheetObjects[1].WaitImageVisible = false;
						ComOpenWait(true);
						formObj.f_cmd.value = SEARCH02;
						sheetObj.DoSearch("ESM_PRI_6005_02GS.do" , FormQueryString(formObj));
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
						
					toggleButtons("INIT");
				}
				break;
		
			case IBSAVE: // 저장
				if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				
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
				
				eventStatus = "IBSAVE";
				
				try {
					ComOpenWait(true);
					var sXml = sheetObj.GetSaveXml("ESM_PRI_6005_02GS.do", sParam);
					sheetObjects[1].LoadSaveXml(sXml);
					sheetObjects[0].LoadSaveXml(sXml);
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
				
				if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
					return false;
				} else {
//					if (getValidRowCount(sheetObjects[1]) <= 0) {
//						doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol, sheetObjects[0].SelectCol, false);
//					}
					
					parent.setTabStyle();
					ComPriSaveCompleted();
		
					
					isFiredNested = true;
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					isFiredNested = false;	
					
					var validRow = ComGetValidRow(sheetObjects[0],"grp_cmdt_seq",selectedGrpCmdtSeq);
			 		
			 		if(validRow != -1 && validRow != 1) {
			 			sheetObjects[0].SelectCell(validRow,0,false);
			 		} else {
			 			formObj.grp_cmdt_seq.value = sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"grp_cmdt_seq");
		 				doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
		 				validRow = ComGetValidRow(sheetObjects[1],"grp_cmdt_dtl_seq",selectedGrpCmdtDtlSeq);
		 				sheetObjects[1].SelectCell(validRow,0,false);
			 		}
 					
			 		eventStatus = "";
					
					
					return true;
				}
				break;
			
			case IBINSERT: // Row Add
				if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				
				if (sheetObj.id == "sheet1") {
					var idx = doRowChange(sheetObj, sheetObjects[1], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, true);
					if (idx < 0) {
						return false;
					}

					sheetObj.CellValue(idx, "qttn_no") = formObj.qttn_no.value;
					sheetObj.CellValue(idx, "qttn_ver_no") = formObj.qttn_ver_no.value;
					sheetObjects[1].RemoveAll();
					sheetObj.CellValue(idx, "grp_cmdt_seq") = parseInt(ComPriGetMax(sheetObj, "grp_cmdt_seq")) + 1;
//					sheetObj.CellValue(idx, "grp_cmdt_seq") = "";
					
					
					//맥스 채번 후 코드 세팅
					maxCode = (parseInt(groupCodeGetMax(sheetObj, "prc_grp_cmdt_cd")) + 1)+"";
//						var grpSeq = maxCode;
						
					if (maxCode.length < 4){
						for(i=0;i<6-maxCode.length;i++){
							maxCode = "0" + maxCode;								
						}
					}
						
					sheetObj.CellValue2(idx,"prc_grp_cmdt_cd")= "G"+ maxCode;
					sheetObj.CellValue2(idx,"prc_grp_cmdt_desc")= "Group "+ maxCode;
					
					sheetObj.SelectCell(idx, "prc_grp_cmdt_cd", false);
					
				}
				if (sheetObj.id == "sheet2") {
					var idx = sheetObj.DataInsert();
					sheetObj.CellValue(idx, "qttn_no") = formObj.qttn_no.value;
					sheetObj.CellValue(idx, "qttn_ver_no") = formObj.qttn_ver_no.value;
					var grp_loc_seq = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "grp_cmdt_seq");
					sheetObj.CellValue(idx, "grp_cmdt_seq") = grp_loc_seq;
					sheetObj.CellValue(idx, "grp_cmdt_dtl_seq") = parseInt(ComPriGetMax(sheetObj, "grp_cmdt_dtl_seq")) + 1;
//					sheetObj.CellValue(idx, "grp_cmdt_dtl_seq") = "";
					
					sheetObj.SelectCell(idx, "prc_cmdt_def_cd", false);
				}
				break;
				
			case IBDELETE: // Delete
				if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	        	

	        	if (sheetObj.id == "sheet1" && sheetObj.CellValue(sheetObj.SelectRow, "chk") == "1") {
					sheetObjects[1].RemoveAll();
				}
				
	        	var delCnt = deleteRowCheck(sheetObj, "chk");
				if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.RowStatus(sheetObj.SelectRow) == "D") {
					sheetObjects[1].RemoveAll();
				}
	        	
				break;
				
				
			case IBSEARCH_ASYNC02: // 조회 - Group 삭제시 rate 사용여부 확인
//				if (validateForm(sheetObj,document.form,sAction)) {
				//rate 사용여부 체크 start
	        	if (sheetObj.id == "sheet1") {
	        		
	        		//공통 Source
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
			    	
					if(chkArr.length == 0){
						sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
					}	
					chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
					
					//ROW ADD후 저장하지 않고 DELETE처리시 적용
					for(var i=0; i < chkArr.length; i++){
						if(sheetObj.CellValue(chkArr[i], "ibflag") == "I") {
							sheetObj.CellValue2(chkArr[i], "chk")= "0";
							
						}	
					}
					
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
					
					if(chkArr == "" || chkArr == null){
						return true;
					}

					
					var sParam = "f_cmd="+SEARCH03+"&"+sheetObj.GetSaveString(false, false, "chk");

		             var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_6005_02GS.do", sParam);
		             var arrErr = ComPriXml2Array(sXml, "etc1|etc2|cd|nm");
		            
		             if (arrErr != null && arrErr.length > 0) {
		            	 
		            	 var txt = "";
		            	 for (var i = 0; i < arrErr.length; i++) {
		            		 	if(i==0) txt += "\n[RATE]\n";
								txt += arrErr[i][2];
								if(i < arrErr.length-1) txt += ", ";
								if(i%5 == 0 && i > 0) txt += "\n";
				    	 }
		            	 
		            	 ComShowCodeMessage("PRI08019", txt);
		            	 
		            	 return false;
		             }
				}
	        	//rate 사용여부 체크 end
//				}	
				return true;
				break;	
				
				
//			case IBSEARCH_ASYNC01: // GLINE COPY
//				if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
//					return false;
//				}
//				
//				if (!ComShowCodeConfirm('PRI03006')) return;
//				
//				formObj.f_cmd.value = MULTI02;
//
//				var sParam = FormQueryString(formObj);
//				
//				var prcCustTpCd = parent.document.form.estm_mqc_qty.value;
//				if(ComIsEmpty(parent.document.form.estm_mqc_qty.value)) {
//					prcCustTpCd = "0";
//				}
//				
//				sParam += "&prc_cust_tp_cd="+parent.getPrcCustTpCd();
//				sParam += "&estm_mqc_qty="+prcCustTpCd;
//				
//				var sXml = sheetObj.GetSaveXml("ESM_PRI_6005_02GS.do", sParam);
//				sheetObj.LoadSaveXml(sXml);
//				
//				ComPriSaveCompleted();
//				
//				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//				
//				break;
				
//			case IBSEARCH_ASYNC02: // GLINE 존재여부
////				if (validateForm(sheetObj,document.form,sAction)) {
//					formObj.f_cmd.value = SEARCH03;
//					
//					var sParam = FormQueryString(formObj);
//					
//					var prcCustTpCd = parent.document.form.estm_mqc_qty.value;
//					if(ComIsEmpty(parent.document.form.estm_mqc_qty.value)) {
//						prcCustTpCd = "0";
//					}
//					
//					sParam += "&prc_cust_tp_cd="+parent.getPrcCustTpCd();
//					sParam += "&estm_mqc_qty="+prcCustTpCd;
//					
//					var sXml = sheetObj.GetSearchXml("ESM_PRI_6005GS.do", sParam);
//					
//					
//					var arrTabCnt = ComPriXml2Array(sXml, "cmdt_tpw_chk|cmdt_chk");
//					if (arrTabCnt != null && arrTabCnt.length > 0) {
//						if(formObj.svc_scp_cd.value == "TPW") {
//							formObj.grp_cmdt_cnt.value = arrTabCnt[0][0];
//						} else {
//							formObj.grp_cmdt_cnt.value = arrTabCnt[0][1];
//						}
//							
//						
//					}
////				}
//				break;	
				
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
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이승준
     * @version 2009.04.17
     */
	function validateForm(sheetObj, formObj, sAction) {
		var qttn_sts_cd  = parent.document.form.qttn_sts_cd.value;
		
		switch (sAction) {
		case IBSEARCH: // 조회
			if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
				return false;
			} else {
				return true;
			}
			break;
			
		case IBSEARCHAPPEND: // 조회
			if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
				return false;
			} else {
				return true;
			}
			break;
	
		case IBSAVE: // 저장
			
			if(qttn_sts_cd == 'P') return false;
			
			if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
			
				if (!isDeleted(sheetObjects[0]) && getValidRowCount(sheetObjects[1]) <= 0) {
					ComShowCodeMessage("PRI00319", "CMDT Group");
					return false;
				}
				
				if (sheetObjects[0].IsDataModified && sheetObjects[0].GetSaveString() == "") {
					return false;
				}
				
				if (sheetObjects[1].IsDataModified && sheetObjects[1].GetSaveString() == "") {
					return false;
				}
				
				var rowM = sheetObjects[0].ColValueDup("qttn_no|qttn_ver_no|prc_grp_cmdt_cd", false);
				if (rowM >= 0) {
					ComShowCodeMessage("PRI00303", "Sheet1", rowM);
					return false;
				}
				
				var rowD = sheetObjects[1].ColValueDup("qttn_no|qttn_ver_no|grp_cmdt_seq|prc_cmdt_def_cd", false);
				if (rowD >= 0) {
					ComShowCodeMessage("PRI00303", "Sheet2", rowD);
					return false;
				}
			
			} else {
				ComShowCodeMessage("PRI00301");
				return false;
			}
			
			return true;
			break;
			

		case IBINSERT: // Row Add
			if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
				return false;
			}
			if (sheetObj.id == "sheet2") {
				if (sheetObjects[0].RowCount <= 0 || sheetObjects[0].SelectRow <= 0) {
					return false;
				}
			}
			
			if(qttn_sts_cd == 'P') return false;
			
			return true;
			break;
			
		case IBDELETE: // Delete
			if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
				return false;
			} 
			
			if(qttn_sts_cd == 'P') return false;
			
			return true;
			break;
		
		
//		case IBSEARCH_ASYNC01: // GLINE COPY
//			if (formObj.qttn_no.value == "" || formObj.qttn_ver_no.value == "") {
//				return false;
//			}
//			
//			if(sheetObjects[0].SearchRows != 0) {
//				return false;
//			}
//			
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
//			
//			if(formObj.grp_cmdt_cnt.value == '0') {
//				ComShowCodeMessage("PRI00331", "Copy");
//				return false;
//			}
//			
//			return true;
//			break;
		}
	}
	

	
	
	/**
    * 주어진 컬럼의 Max값 구하기 <br>
    *
    * @param {object} sheetObj 필수, IBSheet Object.
    * @param {string} sCol 필수, Max값을 구할 컬럼명(Savename).
    * @return int Max값
    * @author 이승준
    * @version 2009.04.22
    */
	function groupCodeGetMax(sheetObj, sCol) {

       var max = 0;

       for (var i = 0; i <= sheetObj.RowCount; i++) {
    	   if (parseInt(sheetObj.CellValue(i, sCol).substr(1,4),10) > max) {
        	   max = parseInt(sheetObj.CellValue(i, sCol).substr(1,4),10);
           }
       }
       return max;
   }	
	   
   /**
    * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     toggleButtons(mode)
    * </pre>
    * @param {String} mode    
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
   function toggleButtons(mode) {
		
		var qttn_sts_cd  = parent.document.form.qttn_sts_cd.value;
		//권한
    	var auth = parent.document.form.authCode.value;
    	
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_rowadd1");
			ComBtnDisable("btn_delete1");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_delete2");
			break;
		case "INIT":
			if(validateForm(sheetObjects[0],document.form,IBSEARCH)) {
				ComBtnEnable("btn_retrieve");
			} else {
				ComBtnDisable("btn_retrieve");
			}	
			if(qttn_sts_cd == 'N' && validateForm(sheetObjects[0],document.form,IBSEARCH)) {
				if(auth == "S" || auth == "A") {
					ComBtnEnable("btn_save");
					ComBtnEnable("btn_rowadd1");
					ComBtnEnable("btn_delete1");
					ComBtnEnable("btn_rowadd2");
					ComBtnEnable("btn_delete2");
					sheetControl(true);
				} else {
					ComBtnDisable("btn_save");
					ComBtnDisable("btn_rowadd1");
					ComBtnDisable("btn_delete1");
					ComBtnDisable("btn_rowadd2");
					ComBtnDisable("btn_delete2");
					sheetControl(false);
				}
			} else {
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_rowadd1");
				ComBtnDisable("btn_delete1");
				ComBtnDisable("btn_rowadd2");
				ComBtnDisable("btn_delete2");
				sheetControl(false);
			}
			break;
		case "READONLY":
			if(validateForm(sheetObjects[0],document.form,IBSEARCH)) {
				ComBtnEnable("btn_retrieve");
			} else {
				ComBtnDisable("btn_retrieve");
			}	
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_rowadd1");
			ComBtnDisable("btn_delete1");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_delete2");
			sheetControl(false);
			break;
		}
	}
	
   
   /**
    * IBSheet의 Cell을  컨폼 여부에 따라 활성,비활성화 한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    sheetControl(mode);
    * </pre>
    * @param   {boolean} flag 필수          
    * @return 없음
    * @author 이승준
    * @version 2009.04.17
    */   
    function sheetControl(flag) {
	     	var sheetObj1 = sheetObjects[0];
	     	var sheetObj2 = sheetObjects[1];
	     	
			for (var i = 1; i <= sheetObj1.RowCount;i++) {
				sheetObj1.CellEditable(i, "chk") = flag;
//				sheetObj1.CellEditable(i, "prc_grp_cmdt_cd") = flag;
				sheetObj1.CellEditable(i, "prc_grp_cmdt_desc") = flag;
		    }
			
			for (var i = 1; i <= sheetObj2.RowCount;i++) {
				sheetObj2.CellEditable(i, "chk") = flag;
				sheetObj2.CellEditable(i, "prc_cmdt_def_cd") = flag;
				sheetObj2.CellEditable(i, "prc_cmdt_def_nm") = flag;
			}

    }  
   
	
   /**
    * 메인화면에서 호출한다.<br>
    * 메인화면에서 탭화면을 활성화시킨다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, isAproUsr)
    * </pre>
    * @param {String} qttn_no   	
    * @param {String} qttn_ver_no 
    * @param {String} svc_scp_cd 
    * @param {String} eff_dt 
    * @param {String} exp_dt 
    * @param {boolean} isAproUsr  권한이 있는지 여부
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function tabLoadSheet(qttn_no, qttn_ver_no, svc_scp_cd, eff_dt, exp_dt, isAproUsr) {
		var formObject = document.form;

		if (formObject.qttn_no.value != qttn_no || formObject.qttn_ver_no.value != qttn_ver_no || sheetObjects[0].RowCount <= 0) {
			formObject.qttn_no.value = qttn_no;
			formObject.qttn_ver_no.value = qttn_ver_no;
			formObject.svc_scp_cd.value = svc_scp_cd;
			formObject.eff_dt.value = eff_dt;
			formObject.exp_dt.value = exp_dt;
			
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			
			toggleButtons("INIT");
			
		}
	}
	
	/**
    * 메인화면에서 호출한다.<br>
    * 메인화면에서 탭화면을 초기화시킨다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     tabClearSheet()
    * </pre>
    * @param 없음 
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.reset();
		
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		
		toggleButtons("CLEAR");
	}
	
	var enableFlag = true;
	/**
    * 메인화면에서 호출한다.<br>
    * 메인화면에서 탭화면을 입력 조회 또는 조회만 할 수 있도록 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *     tabEnableSheet(flag)
    * </pre>
    * @param {boolean} flag	true; 입력,조회 false : 조회 
    * @return 없음
    * @author 이승준
    * @version 2009.06.10
    */
	function tabEnableSheet(flag) {
		
		toggleButtons("INIT");
		
	}
	
	
	/**
 	 * window가 resize 시 sheet col width를 재조정한다.<br>
 	 * <br><b>Example :</b>
     * <pre>
     *    onResize="cellWidthResize();"
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheetColResize() {
 	
 		var sheetObj2 = sheetObjects[1];
		sheetObj2.FitColWidth("0|7.5|7|0|0|0|0|0|20|45|0|20");
  		
 	}

	/* 개발자 작업  끝 */