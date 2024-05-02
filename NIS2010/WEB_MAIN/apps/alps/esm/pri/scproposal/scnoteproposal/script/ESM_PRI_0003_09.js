/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003_09.js
*@FileTitle : S/C Proposal Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.04 최성민
* 1.0 Creation
* 2013.12.12 전윤주 [CHM-201328120] standard note delete amend 기능 추가 - amend seq. 1 이후에도 delete amend 후 G/L copy 가 가능하도록 수정
*                     버튼 컨트롤 로직 추가
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
     * @class ESM_PRI_0003_09 : ESM_PRI_0003_09 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0003_09() {
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

			switch(srcName) {
				case "btn_glinecopy":
					if(validateForm(sheetObject1,formObject,IBCOPYROW)) {
						doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					}
					break;
				case "btn_delete":
					if(validateForm(sheetObject1,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;
				case "btn_deletecancel":
					if(validateForm(sheetObject1,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject1,formObject,COMMAND02);
					}
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

					var HeadTitle = "|Seq.|Title|1|2|3|4|5|6|7|8|9|10";
                    var headCount = ComCountHeadTitle(HeadTitle);
                    
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		50,   	daCenter,  	false,	"seq");
					InitDataProperty(0, cnt++ , dtData,     	800,   	daLeft,		false,	"note_tit_nm",		false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		40,   	daCenter,  	false,	"dp_seq");
					InitDataProperty(0, cnt++ , dtHidden,  		40,   	daCenter,  	false,	"note_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "src_info_cd");    
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "prc_prog_sts_cd");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "n1st_cmnc_amdt_seq");
	                InitDataProperty(0, cnt++ , dtHidden,  	 	40, 	daCenter,  	false,  "dp_fix_flg");
	                
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

					var HeadTitle = "|Seq.|Content|EFF Date|EXP Date|Source|Status|1|2|3|4|5|6|7|8";
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
					InitDataProperty(0, cnt++ , dtData, 		550,   	daLeft, 	false,	"note_ctnt",		false,	"",	dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false,	"eff_dt",			false,	"",	dfDateYmd, 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	false, 	"exp_dt",			false,	"",	dfDateYmd, 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,     	80,		daCenter,  	false,	"src_info_cd",   	false,	"",	dfNone,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,   		80,   	daCenter,  	false, 	"prc_prog_sts_cd",	false,	"",	dfNone,		0,     false,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,  		100,   	daCenter,  	false, 	"n1st_cmnc_amdt_seq");
					InitDataProperty(0, cnt++ , dtHidden,		100,    daCenter,  	false,	"dp_seq");
					InitDataProperty(0, cnt++ , dtHidden,  		100,   	daCenter,  	false,	"note_seq");
 					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_ctnt_seq");
					InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "note_tp_cd");
					InitDataProperty(0, cnt++ , dtHidden,     	40, 	daCenter,  	false,  "svc_scp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "prop_no");    
	                InitDataProperty(0, cnt++ , dtHidden,    	40, 	daCenter,  	false,  "amdt_seq");	                
	                
	                
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
	    			    var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_09GS.do", sParam);    				
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
	    				sheetObj.DoSearch("ESM_PRI_0003_09GS.do" , FormQueryString(formObj));
	    				break;
	    				
	    			case IBSEARCHAPPEND: // 조회
	      				ComOpenWait(true);
	    				formObj.f_cmd.value = SEARCH03;
	    				sheetObj.DoSearch("ESM_PRI_0003_09GS.do" , FormQueryString(formObj));
	    				break;
	    				
	    			case IBDELETE: // Delete
	    				var amdtSeq = formObj.amdt_seq.value;
	    				
	    				if(!ComShowCodeConfirm('PRI00005')){
	    					return false;
	    				}
	    				
	      				ComOpenWait(true);
	      				// DELETE후 데이터가 없을때를 위해 설정
	    				copyFlg = false;
	    				
		  				formObj.f_cmd.value = REMOVELIST;
		  				var sParam = FormQueryString(formObj);	
		  				//전체 AMEND DELETE
		  				sParam += "&src_info_cd=AD";
		  				sParam += "&prc_prog_sts_cd=I";
		  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_09GS.do", sParam);
		  				
	  		    		formObj.note_ref_yr.value = "";
	  		    		formObj.note_nm.value = "";
	  		    		formObj.cust_tp_desc.value = ""; 		    		

		  				//저장후 조회
	  		    		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		  		    			  	
		  				sheetObj.LoadSaveXml(sXml);
	    				break;
	
	      			case COMMAND02: // Amend Cancel
	
	    				if(!ComShowCodeConfirm('PRI01046')){
	    					return false;
	    				}
	    				
	    				ComOpenWait(true);
		  				formObj.f_cmd.value = MODIFY02;
		  				var sParam = FormQueryString(formObj);
		  				//전체 AMEND DELETE CANCEL  				
		  				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_09GS.do", sParam);
		  				
		  				//저장후 조회
	    				formObj.f_cmd.value = SEARCH02;
	    				sheetObj.DoSearch("ESM_PRI_0003_09GS.do" , FormQueryString(formObj));
		  		    			  		    	
		  				sheetObj.LoadSaveXml(sXml);
	      				break;
	      				
	      				
	    			case IBCOPYROW: // Guideline Copy
	    				
	    				var amdtSeq = formObj.amdt_seq.value;
	    			
	    				copyFlg = false; 	    				
						if (amdtSeq == 0 && ComShowCodeConfirm("PRI01006")) {  //카피문구삽입
		      				ComOpenWait(true);
	        				formObj.f_cmd.value = MULTI;
	        				var sParam = FormQueryString(formObj);
	        				sParam += "&prc_cust_tp_cd="+parent.comboObjects[2].Code;
	
	        				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_09GS.do", sParam);
	        				        				
	        				formObj.f_cmd.value = SEARCH01;
							doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							
							sheetObj.LoadSaveXml(sXml); 
						} else if (amdtSeq >= 1 && ComShowCodeConfirm("PRI01152")) {
							ComOpenWait(true);
	        				formObj.f_cmd.value = MULTI;
	        				var sParam = FormQueryString(formObj);
	        				sParam += "&prc_cust_tp_cd="+parent.comboObjects[2].Code;
	
	        				var sXml = sheetObj.GetSaveXml("ESM_PRI_0003_09GS.do", sParam);
	        				        				
	        				formObj.f_cmd.value = SEARCH01;
							doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							
							sheetObj.LoadSaveXml(sXml);							
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
        * OnClick 이벤트 발생시 호출되는 function <br>
        * sheet의 Row를 선택하면 해당 Row를 하이라이트처리한다. <br>
        * <br><b>Example :</b>
        * <pre>
        *
        * </pre>
        * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
        * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
        * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
        * @param {String} Value 필수 Cell 값
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
	    			ComShowMemoPad(sheetObj, Row, Col, true, 550); 	
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
	  		
	  		case IBCOPYROW: //g/l copy
		  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
					return false;
				} 
	  		
	  			if(getAmendValidRowCount(sheetObjects[0], formObj.amdt_seq.value) > 0) {
	  				return false;
	  			}
	  			break;

	  		case IBDELETE:
		  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
					return false;
				} 
		  		
		  		for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
		  			if(sheetObj.CellFont("FontStrikethru", i, "seq")) {
		  				return false;
		  			}
		  		}
		  		
	  			break;

	  		case COMMAND02: //DELETE CANCEL
		  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
					return false;
				} 

		  		for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
		  			if(!sheetObj.CellFont("FontStrikethru", i, "seq")) {
		  				//ComShowCodeMessage("PRI00352");
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
	 			formObject.lgcy_if_flg .value = sLgcyIfFlg ;
	  			copyFlg = true;
	  			
	  			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
	  			buttonControl();
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
 			formObject.lgcy_if_flg .value = "";
 			formObject.dur_dup_flg.value = "";

	  		formObject.note_ref_yr.value 		= "";
	  		formObject.note_nm.value 			= "";
	  		formObject.cust_tp_desc.value 		= "";
				
	  		copyFlg = true;
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
	  		enableFlag = flag;
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
  		var req_usr_flg = formObj.req_usr_flg.value;
  		var apro_usr_flg = formObj.apro_usr_flg.value;
		var sts = formObj.prop_sts_cd.value;
		var row_count = sheetObj.RowCount;
   	 	var sLgcyIfFlg	= formObj.lgcy_if_flg.value;
   		
   		if (errMsg == "") {
   			// GUIDELINE COPY
			if(copyFlg  && sts == "I" && row_count < 1 && (apro_usr_flg=="true" || req_usr_flg=="true" )) {
				doActionIBSheet(sheetObj,formObj,IBCOPYROW);
			} else {
				for(var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
					if(sheetObj.CellValue(i,"amdt_seq") > 0 && sLgcyIfFlg != "Y") {
						if(sheetObj.CellValue(i,"src_info_cd") == 'AD') {
							sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol)=true;
							sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
						} else if(sheetObj.CellValue(i,"src_info_cd") == 'AM' || sheetObj.CellValue(i,"src_info_cd") == 'NW') {
							sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
						}
					}			
				}
				
				//하이라이트 처리
				changeSelectBackColor4Master(sheetObj, formObj);
			}
   		}
   		buttonControl();
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
		 manageCellEditable (sheetObj);
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
   	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	var formObj = document.form;    	
		//Main 의 Amendment Summary 관련 function
		parent.comUpdateProposalStatusSummary("31", formObj.svc_scp_cd.value);
	}
   	
	/**
     * SHEET의 CELL 수정권한을 제어하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     * 	manageCellEditable (sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2009.04.17
     */
     function manageCellEditable (sheetObj) {
	  		
    	 var formObj 		= document.form;
    	 var amdtSeq 		= formObj.amdt_seq.value;
    	 var sLgcyIfFlg		= formObj.lgcy_if_flg.value;

    	 for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {    		     		 
    		  // AMDT_SEQ가 다르면 DISABLE
    		  if(sheetObj.CellValue(i,"amdt_seq") != amdtSeq){ 
    			  sheetObj.CellFont("FontStrikethru", i, 1, i, sheetObj.LastCol)=true;
    		  }
			 	    		  
    		  if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && amdtSeq > 0 && sLgcyIfFlg != "Y"){
    			  	sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
    		  }
    	 }
     }
   	 
   	 
	/**
      * 버튼 권한 컨트롤 function <br>
      * 버튼을 제어한다. <br>
      * <br><b>Example :</b>
      * <pre>
      * buttonControl(mode)
      * </pre>
      * @param  {string} mode 필수 사용자 권한이나 모드
      * @return 없음
      * @author 최성민
      * @version 2009.04.17
      */
      function buttonControl(mode){ 
    	  	var formObj = document.form;
    	  	var sts = formObj.prop_sts_cd.value;
			var row_cnt1 = sheetObjects[0].RowCount; //amend가 0 번일 때 sheet에 data가 1개도 없는 경우 구별
			var row_cnt2 = getAmendValidRowCount(sheetObjects[0], formObj.amdt_seq.value); //1회차 이후 amend delete 한 data만 존재하는 경우
			var req_usr_flg = formObj.req_usr_flg.value;
	 		var apro_usr_flg = formObj.apro_usr_flg.value;
	 		var amdt_seq = formObj.amdt_seq.value;
 			
 			try{
 				ComBtnDisable("btn_glinecopy");
 				ComBtnDisable("btn_delete");
 				hiddenButton("btn_deletecancel");
 				
				if(amdt_seq > 0){
					showButton("btn_deletecancel");
					ComBtnDisable("btn_deletecancel");
				}

				if(mode == "CLEAR") {
					return;
				}
				
 				switch(sts) { 				
 					case 'I':   // Initial	
 						if(req_usr_flg=="true"||apro_usr_flg=="true"){
							if(row_cnt1==0){//sheet에 data가 1개도 없는 경우 G/L copy 가능
								ComBtnEnable("btn_glinecopy");
								ComBtnDisable("btn_delete");
								ComBtnDisable("btn_deletecancel");
							} else if(row_cnt2==0) {//amend delete 한 data만 있는 경우 G/L Copy 가능
								ComBtnEnable("btn_glinecopy");
								ComBtnDisable("btn_delete");
								ComBtnEnable("btn_deletecancel");
							} else if(row_cnt1> row_cnt2  ) {//Delete amend와 신규 I/F한 G/L이 동시에 존재하면 모든 버튼 Block 
								ComBtnDisable("btn_glinecopy");
								ComBtnDisable("btn_delete");
								ComBtnDisable("btn_deletecancel");
							} else {
								ComBtnDisable("btn_glinecopy");
								ComBtnEnable("btn_delete");
								ComBtnEnable("btn_deletecancel");
							}
 						}
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
     
	/* 개발자 작업  끝 */