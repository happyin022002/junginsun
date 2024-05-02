/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_4034.js
*@FileTitle : Percent Base CHG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.02 송호진
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
     * @class ESM_PRI_4034 : ESM_PRI_4034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */

    function ESM_PRI_4034() {
    	this.processButtonClick				= tprocessButtonClick;
    	this.setSheetObject 					= setSheetObject;
    	this.loadPage 							= loadPage;
    	this.initSheet 							= initSheet;
    	this.initControl           			 	= initControl;
    	this.doActionIBSheet 				= doActionIBSheet;
    	this.validateForm 					= validateForm;
        this.sheet1_OnChange 				= sheet1_OnChange;
    }  	

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var now_select_sheet1 = 0 ;
	var max_pct_bse_cd = 0 ;
		
	//Event handler processing by button click event */
	document.onclick = processButtonClick;

   /**
    * Initializing and setting Sheet basics <br>
    * Setting body tag's onLoad event handler <br>
    * Adding pre-handling function after loading screen on the browser  <br>
    */
	function loadPage() {
    	initControl();
		for (i = 0; i < sheetObjects.length; i++) {			
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);			
			ComEndConfigSheet(sheetObjects[i]);	
		}
		doActionIBSheet(sheetObjects[0], document.form , SEARCH01);
	}
	
	
	/**
     * Event handler processing by button name  <br>
     */
	function processButtonClick(){       

        var sheetObject1 = sheetObjects[0];    
        var sheetObject2 = sheetObjects[1];       
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch (srcName) {
				case "btn_save": 
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
					
				case "btn_edit":
					// 편집하여 수정 할 수 있도록 버튼을 활성화 시킨다.
			    	ComBtnEnable("btn_rowadd1");
			    	ComBtnEnable("btn_rowdelete1");
			    	ComBtnEnable("btn_rowadd2");
			    	ComBtnEnable("btn_rowdelete2");
			    	ComBtnEnable("btn_loadExcel");
			    	 
			    	// 기간 중복체크를 위해 검색 기능을 막는다
					formObject.acs_dt.value = "";
					formObject.acs_dt.className = "input2";
					formObject.acs_dt.disabled = "disabled";
					document.all.edit_td.style.display = "none";
					document.all.save_td.style.display = "inline";
					
					doActionIBSheet(sheetObject1, formObject, SEARCH01);
					
					break;
					
				case "btn_retrieve": 
				case "btn_new":	
	 	     		if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {    			
	 	     			if (ComShowCodeConfirm("PRI00006")) {
	 	     				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
	 	     				return false;
		 	     		}
	 	     		}
	 	     		doActionIBSheet(sheetObject1, formObject, SEARCH01);
					break;

		        case "btns_calendar1": //달력버튼
		            var cal = new ComCalendar();                
		            cal.select(formObject.acs_dt, 'yyyy-MM-dd');
		            break;
		            
				case "btn_rowadd1":
	                doActionIBSheet(sheetObject1, formObject,IBINSERT);
					break;
					
				case "btn_rowdelete1": 
					doActionIBSheet(sheetObject1, formObject, IBDELETE);					
					break;		
					
				case "btn_rowadd2":
	                doActionIBSheet(sheetObject2, formObject,	MODIFY01);
					break;
					
				case "btn_rowdelete2": 
					doActionIBSheet(sheetObject2, formObject, IBDELETE);					
					break;	
					
				case "btn_downExcel":
					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_loadExcel":
					doActionIBSheet(sheetObject2,formObject,IBLOADEXCEL);
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
    * handling Axon event<br>
    */    
     function initControl() {
    	 ComBtnDisable("btn_rowadd1");
    	 ComBtnDisable("btn_rowdelete1");
    	 ComBtnDisable("btn_rowadd2");
    	 ComBtnDisable("btn_rowdelete2");
    	 ComBtnDisable("btn_loadExcel");
    	 
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        //axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);            
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form	); 	
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
     } 
	
    /**
      * OnKeyPress event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_keypress()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */ 
    function obj_keypress() {
	    switch (event.srcElement.dataformat) {
	        case "ymd":
	         	ComKeyOnlyNumber(event.srcElement, "-");
	         	break;
	        default:
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
     * @author 공백진
     * @version 2009.04.17
     */  
    function obj_deactivate() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	var sheetObj1 = sheetObjects[0];
    	var eleName = event.srcElement.name;
		
    	switch (eleName) {
	    	case "acs_dt":
	    		ComChkObjValid(event.srcElement);
	    		break;
    	}
    }

	/**
	* OnBeforeActivate   event를 처리한다. <br>
	* <br><b>Example :</b>
	* <pre>
	*     obj_activate()
	* </pre>
	* @param 없음
	* @return 없음
	* @author 공백진
	* @version 2009.04.17
	*/     
	function obj_activate() {
	    var formObj = document.form;
	    var srcName = event.srcElement.getAttribute("name");
	    ComClearSeparator (event.srcElement);
	}
	
  /**
	* registering IBSheet Object as list <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
	* registering IBCombo Object as list  <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}	 


    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;
     	switch(sheetID) {
     	case "sheet1":
     		with (sheetObj) {
                 // setting height
                 style.height = 400;
                 //setting width
                 SheetWidth = mainTable.clientWidth;

                 // setting Host information[HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 // Merge type  [optional, Default msNone]
                 MergeSheet = msHeaderOnly;

                // setting total editable or not [optional, Default false]
                 Editable = true;

                 // setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 20, 100);

                 var HeadTitle = "ibflag|Sel.|Base Code|DP Seq.|Description|pri_scg_prf_use_yn|MAX_PCT_BSE_CD";

                 var headCount = ComCountHeadTitle(HeadTitle);

                 // setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 //  setting function handling header
                 InitHeadMode(true, true, true, true, false	,false);

                 // setting Header row information [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] ///     
                 InitHeadRow(0, HeadTitle, true);

                 //data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, 	dtHiddenStatus, 		30, 		daCenter, 	false, 	 "ibflag");    
                 InitDataProperty(0, cnt++, 	dtDummyCheck,   		45,  		daCenter, 	false, 	 "chk");
                 InitDataProperty(0, cnt++, 	dtHidden, 				100, 		daCenter, 	false, 	 "pct_bse_cd", 	  true,  	"", 	dfNone,   0, 	false, 	true );                                
                 InitDataProperty(0, cnt++ , 	dtData,					70,		    daCenter,	false,	 "dp_seq", 	      true,     "",     dfNone,   0,    true,   true,   5   );
                 InitDataProperty(0, cnt++ , 	dtData,					320,		daLeft,		false,	 "patt_desc", 	  true,  	"", 	dfNone,   0, 	true, 	true,	100 );   
                 InitDataProperty(0, cnt++ , 	dtHidden,				80,			daLeft,		false,	 "pri_scg_prf_use_yn");
                 InitDataProperty(0, cnt++ , 	dtHidden,				80,			daLeft,		false,	 "max_pct_bse_cd");
                 
                 InitDataValid ( 0, "dp_seq", vtNumericOnly );
                 WaitImageVisible = false;   		
     		}
          	break;
          	
     	case "sheet2":
     		with (sheetObj) {
                 // setting height
                 style.height = 400;
                 //setting width
                 SheetWidth = mainTable.clientWidth;

                 // setting Host information[HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 // Merge type  [optional, Default msNone]
                 MergeSheet = msHeaderOnly;

                // setting total editable or not [optional, Default false]
                 Editable = true;

                 // setting Row information [HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 20, 100);

                 var HeadTitle = "ibflag|Sel.|Base Code|CHG Code|CHG Name|Effective date|Expiration date|pct_bse_chg_seq";

                 var headCount = ComCountHeadTitle(HeadTitle);

                 // setting Column information [COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 //  setting function handling header
                 InitHeadMode(false, true, true, true, false,false);

                 // setting Header row information [ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] /// 
                 InitHeadRow(0, HeadTitle, true);

                 //data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, 	dtHiddenStatus, 		30, 		daCenter, 	false, 	 "ibflag"); 
                 InitDataProperty(0, cnt++, 	dtDummyCheck,   		45,  		daCenter, 	false,   "chk");
                 InitDataProperty(0, cnt++ , 	dtHidden,				100,		daCenter,	false,		 "pct_bse_cd",	true,    "",    dfNone,   0 ,   false,  false);
                 InitDataProperty(0, cnt++ , 	dtCombo,				80,		daCenter,	false,		 "chg_cd" ,	    true,    "",    dfNone,   0 ,   false,  true);
                 InitDataProperty(0, cnt++ , 	dtData,				    140,		daLeft,		false,		 "chg_nm" ,     false,   "",    dfNone,   0 ,   false,  false);
                 InitDataProperty(0, cnt++ , 	dtData,				    100,		daCenter,		false,		 "eff_dt" ,		false,   "",    dfUserFormat2,   0 ,   true,  true);
                 InitDataProperty(0, cnt++ , 	dtData,				    110,		daCenter,		false,		 "exp_dt" ,	false,   "",    dfUserFormat2,   0 ,   true,  true);
                 InitDataProperty(0, cnt++ , 	dtHidden,				80,		daLeft	,		false,		 "pct_bse_chg_seq");
                 
                 InitUserFormat2(0, "eff_dt", "####-##-##", "-|:" );
                 InitUserFormat2(0, "exp_dt", "####-##-##", "-|:" );
                 
                 InitDataCombo(0, "chg_cd", scgCdText, scgCdValue);  //chg_cd combo
                 
                 WaitImageVisible = false;   		
     		}
          	break;
     	}
	}

  
  /**
   * Handling sheet process <br>
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
	   try {
	 		sheetObj.ShowDebugMsg = false;
	 		switch (sAction) {																		
		 		
		 		case SEARCH01: 	 			
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			ComOpenWait(true);	 			
		 			formObj.f_cmd.value = SEARCH01;
		 			
		 			sheetObjects[1].RemoveAll();
		 			var sXml = sheetObj.GetSearchXml("ESM_PRI_4034GS.do", FormQueryString(formObj));
		 			sheetObj.LoadSearchXml(sXml);				
		 			max_pct_bse_cd = sheetObj.CellValue( 1 , "max_pct_bse_cd") ;
	 		 		break;		 				 		
		 		
		 		case IBINSERT: // Row Add 1	
	                var idx = doRowChange(sheetObj, sheetObjects[1], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, true);
	                if (idx < 0) {
	                    return false;
	                }
		 			with (sheetObjects[0]) { 
			 			var nowRow = SelectRow;
			 			sheetObj.CellValue(idx, "pct_bse_cd") = parseInt(max_pct_bse_cd) + 1 ;
			 			sheetObj.CellValue(idx, "dp_seq") 	 = parseInt(max_pct_bse_cd) + 1 ;
			 			sheetObj.CellValue(idx, "pri_scg_prf_use_yn") 	 = "N";
			 			sheetObj.CellEditable(idx, "pct_bse_cd") = false ;
			 			max_pct_bse_cd = parseInt(max_pct_bse_cd) + 1
			 			now_select_sheet1 = idx;
			 			sheetObjects[1].RemoveAll();
		 			}
		 			break; 
		 			
		 		case MODIFY01: // Row Add 2		 		
		 			with (sheetObjects[1]) { 
			 			var nowRow = SelectRow;
			 			maxRow = DataInsert(-1);
			 			sheetObj.CellValue(maxRow, "pct_bse_cd") = sheetObjects[0].CellValue( now_select_sheet1 , "pct_bse_cd");
			 			sheetObj.CellEditable(maxRow, "chg_cd") = true ; 
		 			}
		 			break; 	
	
		 		case IBDELETE:      		 			
		 			var chkArr = ComPriSheetCheckedRows(sheetObj, "chk");
		 			for(i=0 ; i<chkArr.length ; i++){
		 				if(sheetObj.CellValue( chkArr[i] , "pri_scg_prf_use_yn") == "Y"){
		 					ComShowCodeMessage("PRI01022");
							return false;
		 				}else{
		 					sheetObj.CellValue( chkArr[i] , "ibflag") = "D";
		 					sheetObj.RowHidden( chkArr[i] ) = true; 
		 					if ( sheetObj.id == "sheet1" )sheetObjects[1].RemoveAll();
		 				}
		 			}
	 		 		break;			
		 			
		 		case IBSAVE: 		
		 			if (!validateForm(sheetObj,document.form,sAction)) {		 				
						return false;
					} 					
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
					if (sheetObjects[0].IsDataModified && sParamSheet1 == "") {
					    return;
					}
					
                    var sParamSheet2 = sheetObjects[1].GetSaveString(true);
					if (sheetObjects[1].IsDataModified && sParamSheet2 == "") {
					    return;
					}

		 			formObj.f_cmd.value = MULTI;	
		 			var sParam = FormQueryString(formObj);
			 		if( sParamSheet1 != "" ){
						sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
					}
			 		if( sParamSheet2 != "" ){
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
					ComOpenWait(true);
		 			var sXml = sheetObj.GetSaveXml("ESM_PRI_4034GS.do", sParam);	
		 			
		 			var sav = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		     	   if(sav != "F" ){
		     		   sheetObjects[1].Redraw = false;
		     		   sheetObjects[1].RemoveAll();
					   doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		     		   sheetObjects[1].Redraw = true;
		       	   }
		 			sheetObj.LoadSaveXml(sXml);
		 			break;			 							    
		 			
	        	case IBDOWNEXCEL:
					sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "chk|seq");
					break;
					
	        	case IBLOADEXCEL:
	        		sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", true);
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
     * checking validation process of inputed form data <br>
     */
 	function validateForm(sheetObj, formObj, sAction) {
    	 
    	 switch (sAction) {     	 		 
	    	 case IBSAVE:        
	            var dupRow1 = sheetObj.ColValueDup("patt_desc");   
	            var dupRow2 = sheetObj.ColValueDup("dp_seq");
	            var dupRow3 = sheetObjects[1].ColValueDup("chg_cd");
	            var sheet1_row_count = sheetObj.RowCount ;
	            var sheet2_row_count = sheetObjects[1].RowCount ;
	            var sheetObj1 = sheetObjects[1];
          
 	     		if (sheetObjects[0].IsDataModified == false && sheetObjects[1].IsDataModified == false) {
	                ComShowCodeMessage("PRI00301");
 	     			return false;
 	     		}
 	     		
 	     		var currentRowStatus = sheetObjects[0].RowStatus(sheetObjects[0].SelectRow);
 	     		if ( ( currentRowStatus != "D" ) &&
 	     			 ( sheetObjects[1].RowCount == 0 ||  sheetObjects[1].RowCount == sheetObjects[1].RowCount("D") ) ) {
 	     			ComShowCodeMessage("PRI00319", "Percent Base Code");
 	     			return false;
 	     		}
 	     			

	            if (dupRow1>0) {  
	            	sheetObj.SelectRow = dupRow1;
	                ComShowCodeMessage("PRI00342","Description");
	                ComSetFocus(sheetObj.ColValueDupRows("patt_desc"));	
	                return false;
	            }
	            
	            if (dupRow2>0) {
	            	sheetObj.SelectRow = dupRow2;
	                ComShowCodeMessage("PRI00342","DP Seq.");
	                ComSetFocus(sheetObj.ColValueDupRows("dp_seq"));	
	                return false;
	            }
	            
//	            if (dupRow3>0) {
//	            	sheetObjects[1].SelectRow = dupRow3;
//	                ComShowCodeMessage("PRI00342","CHG Code");
//	                ComSetFocus(sheetObjects[1].ColValueDupRows("chg_cd"));
//	                return false;
//	            }	            

	            for(var i = 0 ; i < sheet1_row_count+1 ; i++ ){
	            	if(ComTrimAll(sheetObjects[0].CellValue( i , "patt_desc")) == ""){              	
	            		ComShowCodeMessage("PRI00316","Description"); 
	            		return false;
	            	}else if(ComTrimAll(sheetObjects[0].CellValue( i , "dp_seq")) == ""){    
	            		ComShowCodeMessage("PRI00316","DP Seq."); 
	            		return false;	            		
	            	}
	            }
	            
	            for(var i = 1 ; i < sheet1_row_count+1 ; i++ ){
	            	if(!ComIsNumber(sheetObjects[0].CellValue( i , "dp_seq"))){   
	            		ComShowCodeMessage("PRI00311"); 
	            		return false;
	            	}
	            }	            
	            
	            // duration check
	            var chkDupDt = false;
	            
	            // date check
	            for(var i=1; i < sheet2_row_count+1; i++) {
	            	// 기간 뒤바뀜 체크
	            	if(ComChkPeriod(sheetObj1.CellValue(i,"eff_dt"), sheetObj1.CellValue(i,"exp_dt")) < 1)  {
	            		ComShowCodeMessage("PRI00306");
	            		return false;
	            	}
	            	
	            	for(var j = i+1; j < sheet2_row_count+1; j++) {
	            		if(sheetObj1.CellValue( i , "chg_cd") == sheetObj1.CellValue( j , "chg_cd") && (sheetObj1.CellValue(i,"ibflag") != "D" && sheetObj1.CellValue(j,"ibflag") != "D") ) {
	            			// 기간 겹침 체크
	            			if( sheetObj1.CellValue(i,"eff_dt") <= sheetObj1.CellValue(j,"eff_dt") && sheetObj1.CellValue(i,"exp_dt") >= sheetObj1.CellValue(j,"eff_dt") ||
	            					sheetObj1.CellValue(i,"eff_dt") <= sheetObj1.CellValue(j,"exp_dt") && sheetObj1.CellValue(i,"exp_dt") >= sheetObj1.CellValue(j,"exp_dt") ) {
	            				
	            				sheetObj1.CellFontColor(j, "eff_dt") = sheetObj1.RgbColor(255, 0, 0);
	            				sheetObj1.CellFontColor(j, "exp_dt") = sheetObj1.RgbColor(255, 0, 0);
	            				
	            				chkDupDt = true;
	            			}
	            		}
	            	}
	            	
	            	// excel Load일 경우 필수값 입력
	            	if( sheetObj1.CellValue(i, "pct_bse_cd") == "" ) {
	            		sheetObj1.CellValue(i, "pct_bse_cd") = sheetObjects[0].CellValue( now_select_sheet1 , "pct_bse_cd");
	            	}
	            	
	            }
	            
	            // duration message
	            if(chkDupDt) {
	            	ComShowCodeMessage("PRI00304");
	            	return false;
	            }
	            
		    	break;
		    	
    	 }
 		return true;
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
         doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
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
      *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
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
                 var idx = sheetM.DataInsert(-1);
                 isFiredNested = false;
                 return idx;
             } else {  
            	 
            	sheetD.RemoveAll();	 	
      			var formObj = document.form;
      			formObj.f_cmd.value = SEARCH02;

      			var param = "f_cmd="           + formObj.f_cmd.value + "&acs_dt=" + formObj.acs_dt.value
      					  + "&pct_bse_cd="     + sheetM.CellValue(NewRow, "pct_bse_cd");
      			
      			now_select_sheet1 = NewRow ;
                try {
      			  	ComOpenWait(true);
      			  	var sXml = sheetD.GetSearchXml("ESM_PRI_4034GS.do", param);
      			    sheetD.LoadSearchXml(sXml);	
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
         }
     }
     
  	 
     /**
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
 	 */
 	function sheet2_OnComboChange(sheetObj, Row, Col, Code, Text){
 		var form = document.form;
 	    var colName = sheetObj.ColSaveName(Col);
 		switch(colName) {
 			case "chg_cd": 
 				var arr = Text.split ( "\t");
 				sheetObj.CellValue2 ( Row, "chg_nm" ) = arr[1];
 				break;
 		
 		}
 	}	  
 	 
  	 
     /**
     * OnChange 이벤트 발생시 호출되는 function <br>
 	 */
 	function sheet2_OnChange(sheetObj, Row, Col, Value){
 		var form = document.form;
 	    var colName = sheetObj.ColSaveName(Col);
 		switch(colName) {
 			case "chg_cd": 
 				var sText = sheetObj.GetComboInfo ( Row, Col, "Text" );
 				var idx = sheetObj.GetComboInfo ( Row, Col, "SelectedIndex" );
 				var arrText = sText.split("|");
 				if ( idx > 0 ) {
 					sheet2_OnComboChange ( sheetObj, Row, Col, Value, arrText[idx] );
 				}
 				break;
 				
 			case "eff_dt":
 			case "exp_dt":
 				sheetObj.CellValue( Row , "ibflag") = "I";
 				break;
 		
 		}
 	}	   	   	  	