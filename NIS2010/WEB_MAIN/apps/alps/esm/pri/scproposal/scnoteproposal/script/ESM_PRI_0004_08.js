/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0004_08.js
*@FileTitle : S/C Proposal Standard Note - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.04 최성민
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
     * @class ESM_PRI_0004_08 : ESM_PRI_0004_08 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0004_08() {
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
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;

	 // G/L COPY 체크유무
	 var copyFlg = true;
	 
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
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
			}
		}catch(e) {
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
	function setSheetObject(sheet_obj){
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

		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}

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
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {

			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 120;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Seq.|dp_seq|note_seq|Title";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		50,   daCenter,  	false,	"seq");
					InitDataProperty(0, cnt++ , dtHidden,		30,   daCenter,  	false,	"dp_seq");
					InitDataProperty(0, cnt++ , dtHidden,  		100,   	daCenter,  	false,	"note_seq");
					InitDataProperty(0, cnt++ , dtData,     	800,   daLeft,		false,	"note_tit_nm",		false,	"",	dfNone,	0,	false,	false);

					AutoRowHeight = false;
 					WaitImageVisible = false;
				}
				break;

			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 170;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Seq.|dp_seq|note_seq|Content|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);


					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,  	50,   	daCenter,  	false,	"seq");
					InitDataProperty(0, cnt++ , dtHidden,		30,     daCenter,  	false,	"dp_seq");
					InitDataProperty(0, cnt++ , dtHidden,  		100,   	daCenter,  	false,	"note_seq");
					InitDataProperty(0, cnt++ , dtData, 		400,   	daLeft, 	false,	"note_ctnt",		false,	"",	dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false,	"eff_dt",			false,	"",	dfDateYmd, 	0,     false,       false);

					InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false, 	"exp_dt",			false,	"",	dfDateYmd, 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,     	80,		daCenter,  	false,	"src_info_cd",   	false,	"",	dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,   		80,   	daCenter,  	false, 	"prc_prog_sts_cd",	false,	"",	dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	130,	daLeft,  	false,	"acpt_usr_nm",		false,	"", dfNone, 	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	70,		daCenter,  	false,	"acpt_dt",			false,	"", dfDateYmd, 	0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,  		10,   	daCenter,  	false, 	"n1st_cmnc_amdt_seq");

	                InitDataCombo(0, "src_info_cd", srcInfoCdComboText, srcInfoCdComboValue, "", "NW");            
	                InitDataCombo(0, "prc_prog_sts_cd", prcProgStsCdComboText, prcProgStsCdComboValue, "", "I");
	                
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
    * @author 최성민
    * @version 2009.05.22
    */
    	function doActionIBSheet(sheetObj, formObj, sAction) {
    		try {
	    		sheetObj.ShowDebugMsg = false;
	    		switch (sAction) {
	    			case IBSEARCH: // 조회	
	
	      				ComOpenWait(true);
	    				formObj.f_cmd.value = SEARCH01;    			    
	    			    var sParam = FormQueryString(formObj);
	    			    sParam += "&prc_cust_tp_cd="+parent.getCustTypeCode();
	    			    var sXml = sheetObj.GetSearchXml("ESM_PRI_0004_08GS.do", sParam);    				
	    				var arrData = ComPriXml2Array(sXml, "note_ref_yr|note_nm|cust_tp_desc");
	    	       	  	
	 					if (arrData != null){
	 						formObj.note_ref_yr.value 		= arrData[0][0];
	 						formObj.note_nm.value 			= arrData[0][1];
	 						formObj.cust_tp_desc.value 		= arrData[0][2]; 						
	 					} else {
	 						formObj.note_ref_yr.value 		= "";
	 						formObj.note_nm.value 			= "";
	 						formObj.cust_tp_desc.value 		= "";
	 					}
	 				
	    				formObj.f_cmd.value = SEARCH02;
	    				formObj.note_tp_cd.value = "T";
	    				sheetObj.DoSearch("ESM_PRI_0004_08GS.do" , FormQueryString(formObj));
	      				ComOpenWait(false);
	    				break;
	    				
	    			case IBSEARCHAPPEND: // 조회
	      				ComOpenWait(true);
	    				formObj.f_cmd.value = SEARCH03;
	    				sheetObj.DoSearch("ESM_PRI_0004_08GS.do" , FormQueryString(formObj));
	      				ComOpenWait(false);
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
    	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, appendRow) {
    		var formObj = document.form;
    		
    		if (OldRow != NewRow) {    			
				formObj.note_seq.value = sheetM.CellValue(NewRow, "note_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
    		}
    	}
    	
	     /**
	      * 오브젝트 인스턴스가 생성 완료될때 발생하는 Event <br>
	      * <br><b>Example :</b>
	      * <pre>
	      *
	      * </pre>
	      * @param {ibsheet} sheetObj 필수 IBSheet Object
	      * @return 없음
	      * @author 최성민
	      * @version 2009.08.04
	      */
	      function sheet2_OnLoadFinish_backup(sheetObj) {   
	          doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
	      }
	      
	      
	   /**
	    * SHEET의 OnClick 이벤트를 호출되는 function <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *	
	    * </pre>
	    * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
	    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	    * @param {string} Value 필수 cell 값
	    * @return 없음
	    * @author 최성민
	    * @version 2009.05.19
	    */
		function sheet1_OnClick(sheetObj, Row, Col, Value)  {
			var colName = sheetObj.ColSaveName(Col);
	     	switch(colName)
	     	{
	 	    	case "note_tit_nm":
	    			ComShowMemoPad(sheetObj, Row, Col, true, 915); 	
	 	    		break;
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
	     * @param {int} OldRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	     * @param {int} OldCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	     * @param {int} NewRow 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	     * @param {int} NewCol 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	     * @return 없음
	     * @author 최성민
	     * @version 2009.05.19
	     */	
		function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
			doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, false);
		}
		
	    /**
	     * OnClick 이벤트 발생시 호출되는 function <br>
	     * 주소입력시 메모장을 화면에 표시한다. <br>
	     * <br><b>Example :</b>
	     * <pre>
	     *
	     * </pre>
	     * @param {ibsheet} sheetObj 필수 IBSheet Object
	     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
	     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
	     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
	     * @return 없음
	     * @author 최성민
	     * @version 2009.06.18
	     */  	           
	     function sheet2_OnClick(sheetObj, Row, Col, Value) {
		    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
		    var colname = sheetObj.ColSaveName(Col);  	 
		    var amdtSeq = document.form.amdt_seq.value;
		    var eff_dt = document.form.eff_dt.value;
		    
	     	switch(colname)
	     	{
	 	    	case "note_ctnt":
	 	    		sheetObj.CellEditable(Row,"note_ctnt") = false;
	    			ComShowMemoPad(sheetObj, Row, Col, true, 400); 	
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
	  			formObject.req_usr_flg.value = sIsReqUsr ;
	  			formObject.apro_usr_flg.value = sIsAproUsr ;	
	 			formObject.dur_dup_flg.value = sDurDupFlg ;
	  			copyFlg = true;

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
	  		copyFlg = true;
	  		sheetObjects[0].RemoveAll();
	  		sheetObjects[1].RemoveAll();
	  		
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
	  	}
    
	/* 개발자 작업  끝 */