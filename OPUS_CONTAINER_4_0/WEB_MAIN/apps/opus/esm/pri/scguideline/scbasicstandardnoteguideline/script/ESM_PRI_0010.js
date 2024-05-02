/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0010.js
*@FileTitle  : Standard Note Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

 	// common global variables
 	var tabObjects=new Array();
 	var tabCnt=0 ;
 	var beforetab=1;
 	var sheetObjects=new Array();
 	var sheetCnt=0;
 	var comboObjects=new Array();
 	var comboCnt=0;
 	var errMsg="";
 	// Save Current Event
 	var eventStatus="";
 	var eventStatus2="";
 	var selectedGlineSeq="";
 	// Event handler processing by button click event */
 	document.onclick=processButtonClick;
	
 	/**
	  * Event handler processing by button name  <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return void
	  * @author 
	  * @version 2009.10.28
	  */
 	function processButtonClick(){
 		var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
    		
             switch(srcName) {
               case "btn_retrieve":
            	    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
	 				break;
				case "btns_calendar": //Calendar Button
   	    			if (comboObjects[0].GetSelectCode()== "") {
   	    				ComShowCodeMessage('PRI08002');
   	    				return false;
   	    			}
   	    			var cal=new ComCalendarFromTo();
   	                cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
   	                break;		
             } // end switch
     	}catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
     	}
 	}
  
 	/**
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.10.28
    */
 	function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
 	
    /**
     * registering IBCombo Object as list</b>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(sheetObj);
     * </pre>
     * @param {ibcombo} sheet_obj Mandatory IBCombo Object
     * @return void
     * @author 
     * @version 2009.10.28
     */    
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
 	
    /**
      * initializing sheet <br>
      * implementing onLoad event handler in body tag <br>
      * adding first-served functions after loading screen. <br>
      * <br><b>Example :</b>
      * <pre>
      *     loadPage();
      * </pre>
      * @return void
      * @author 
      * @version 2009.05.17
      */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    	    //Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
    	//Initializing IBMultiCombo
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    } 	   
 	    //SERVICE SCOPE
 	    ComPriTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'));
 	    //CUSTOMER TYPE
 	    ComPriTextCode2ComboItem(prcCustTpCdComboValue, prcCustTpCdComboText, getComboObject(comboObjects, 'prc_cust_tp_cd'));
 	    comboObjects[3].InsertItem(0,'','');
 	    //axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
 	    axon_event.addListenerFormat('blur', 'obj_deactivate', document.form);
 	    var formObj=document.form;
 	    formObj.note_ref_yr.focus();
    }
     
     /**
       * Implement activate event handler of body tag <br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_activate();
       * </pre>
       * @return void
       * @author 
       * @version 2009.05.17
       */     
    function obj_activate() {
    	var formObject=document.form;
    	var srcName=ComGetEvent("name");
  	    var comboObj=comboObjects[1];
  	    ComClearSeparator (ComGetEvent());
  	    if (srcName == "exp_dt") {
  	        var eff_dt=formObject.eff_dt.value;
  	    	if (eff_dt != null && eff_dt != "") {
  	    		// When you input code by hand, There is no proper value.
	  	  		var text=comboObj.GetText(eff_dt, 1);
//parameter changed[check again]CLT
	  	  		var code=comboObj.FindItem(setDash(eff_dt), 0, false);
	  	  		// Prevent All of OnBlur event triggered
	  	  		if (ComIsEmpty(text)) {
	  	  			// Insert when all column's value is not the same except exp date
//parameter changed[check again]CLT
	  	  			var code2=comboObj.FindItem(setDash(eff_dt), 0, false);
	  	  			// Insert the date inputted
	  	  			if(code2 == -1) {
	  	  				//combo item insert
	  	  				comboObj.InsertItem(-1,setDash(eff_dt) + "|||", setDash(eff_dt));
	  	  				comboObj.SetSelectCode(setDash(eff_dt),false);
	  	  				formObject.eff_dt.value=setDash(eff_dt);
	  	  				formObject.exp_dt.value=setDash(formObject.exp_dt.value);	  
	  	  			
	  	  			} 	  	  			
	  	  		}
	  	  		// Not input directly, auto search or select
	  	  		else {
	  	  			if(!isDateIBCombo(comboObj)) return;
	  	  			comboObj.SetSelectText(setDash(eff_dt),false);
  	  				formObject.exp_dt.value=setDash(formObject.exp_dt.value);	  
		  		}
  	    	}	
  	    }
    }
    
    /**
     * Implement deactivate event handler of body tag <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_activate();
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.17
     */     
  	function obj_deactivate() {
  	    ComChkObjValid(event.srcElement);
  	}
  	
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.05.22
     */
  	function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet0":      //hidden 
	            with (sheetObj) {
            		sheetObj.SetVisible(false);
	            }
	            break; 
            case "sheet1":      //t1sheet1 init)
            	with(sheetObj){
            	    var HeadTitle="|Sel.|Del Check|Seq.|Title|dp_seq|note_hdr_seq|note_seq|prc_cust_tp_cd|svc_scp_cd|note_tit_nm";

            	 	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	 	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	 	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 	InitHeaders(headers, info);

            	 	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            	 	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
            	 	             {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
            	 	             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"Seq",   Sort:0 },
            	 	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"note_tit_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	 	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	 	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	 	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	 	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	 	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
            	 	InitColumns(cols);

            	 	SetEditable(0);
               		SetWaitImageVisible(0);
                    SetColHidden("del_chk",1);
                    SetSheetHeight(280);
             	}
                break;
            case "sheet2":      //t1sheet1 init
                with(sheetObj){
            		var HeadTitle="|Sel.|Del Seq|Seq.|Content|Creation Staff/Team|Creation Date|Conversion|Conversion|dp_seq|note_hdr_seq|note_seq|note_ctnt_seq|prc_cust_tp_cd|svc_scp_cd|";

            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            		             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
            		             {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
            		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",   Sort:0 },
            		             {Type:"Text",      Hidden:0,  Width:500,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:0,  Width:210,  Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Popup",     Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"conversion_pop",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dp_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" } ];
               
            		InitColumns(cols);

            		SetEditable(1);
            		//nosupport[checkagain]CLTUnEditableColor="#000000";
            		SetWaitImageVisible(0);
                    //SetShowButtonImage(2);
                    SetColHidden("del_chk",1);
                    SetAutoRowHeight(0);
                    SetSheetHeight(180);
            	}
            	break; 
        }
  	}
  	
  	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
  	     sheetObj.ReNumberSeq();    
  	}
  	
  	function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
  	     sheetObj.ReNumberSeq();    
  	}
  	
    /**
      * Calling function in case of Onclick event <br>
      * Highlighting selected row<br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
      * @param {int} Row mandatory Onclick ,Cell's Row Index
      * @param {int} Col mandatory Onclick ,Cell's Column Index
      * @param {string} Value Mandatory Value
      * @return void
      * @author 
      * @version 2009.05.19
      */	
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
	}
  	
    /**
     * Calling function in case of clicking SHEET's ROW<br>
     * Retrieving child-sheet by selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
     * </pre>
     * @param {ibsheet} sheetM Mandatory HTMLtag(Object) Object
     * @param {ibsheet} sheetD Mandatory HTMLtag(Object) Object
     * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
     * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
     * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
     * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
     * @param {string} appendRow Mandatory SHEET Row Add Option
     * @return void
     * @author 
     * @version 2009.05.19
     */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (OldRow != NewRow) {			
			formObj.note_seq.value=sheetM.GetCellValue(adjNewRow, "note_seq");
			if(formObj.note_seq.value == "undefined" || ComIsEmpty(formObj.note_seq.value)) {
				formObj.note_seq.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_seq");
            }
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
		}
		//memopad
		showMemoPad(sheetM, NewRow, NewCol);
	}
	
    /**
    * Handling sheet's processes <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {form} formObj mandatory html form object
    * @param {int} sAction mandatory,Constant Variable
    * @return void
    * @author 
    * @version 2009.05.22
    */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		try {
			sheetObj.ShowDebugMsg(false);
	        switch(sAction) {
		    	case IBCREATE: // When Service Scope selected, retrieve Duration
		    		formObj.f_cmd.value=SEARCH05;
//parameter changed[check again]CLT 			 			
		    		var sXml=sheetObj.GetSearchData("ESM_PRI_0010GS.do", FormQueryString(formObj));
		    		
			 		ComPriXml2ComboItem(sXml, gline_seq, "gline_seq", "eff_dt|exp_dt|eff_dt");
			 		
			 		break;	
		        case IBSEARCH:      //Retrieving
		        	if (validateForm(sheetObj, formObj, sAction)) {
		        		ComOpenWait(true);
		        		if ( sheetObj.id == "sheet0") {
		        			formObj.f_cmd.value=SEARCH01;    
		        			var sXml=sheetObj.GetSearchData("ESM_PRI_0010GS.do", FormQueryString(formObj));
			       			var arrData=ComPriXml2Array(sXml, "note_hdr_seq|prc_cust_tp_cd|cfm_flg|note_nm|note_ref_yr|eff_dt|exp_dt|svc_scp_cd");
			       			if (arrData != null && arrData.length > 0) {
		       					formObj.note_hdr_seq.value=arrData[0][0];
		       					formObj.note_ref_yr.value=arrData[0][4];
		       					comboObjects[3].SetSelectCode(arrData[0][1]);
		       					comboObjects[2].SetSelectCode(arrData[0][0]);
		       					formObj.svc_scp_cd_hidden.value=arrData[0][7];
		       					formObj.note_nm_hidden.value=arrData[0][3];
		       					formObj.note_ref_yr_hidden.value=arrData[0][4];
		       					formObj.eff_dt_hidden.value=arrData[0][5];
		       					formObj.exp_dt_hidden.value=arrData[0][6];
		       					formObj.prc_cust_tp_cd_hidden.value=arrData[0][1];
		       					// Duration
		       					comboObjects[1].SetSelectCode(arrData[0][5],false);
		       					formObj.exp_dt.value=arrData[0][6];
			       			} else {
		       					formObj.note_hdr_seq.value="";
		       					formObj.note_nm.value="";
		       					formObj.svc_scp_cd_hidden.value="";
		       					formObj.note_nm_hidden.value="";
		       					formObj.note_ref_yr_hidden.value="";
		       					formObj.eff_dt_hidden.value="";
		       					formObj.exp_dt_hidden.value="";
		       					formObj.prc_cust_tp_cd_hidden.value="";
			       			}
			       		}
			            else if ( sheetObj.id == "sheet1") {
							formObj.f_cmd.value=SEARCH02;
							for (var i=0; i < sheetObjects.length; i++) {
								sheetObjects[i].RemoveAll();
							}							  
							sheetObj.DoSearch("ESM_PRI_0010GS.do", FormQueryString(formObj) );
			            }		
			            else if ( sheetObj.id == "sheet2") {
			            	formObj.f_cmd.value=SEARCH03;  
			            	sheetObj.DoSearch("ESM_PRI_0010GS.do", FormQueryString(formObj) );
			            }
						ComOpenWait(false);
		        	}	   
		        	break;
				case IBSEARCH_ASYNC05:        //NOTE_NM COMBO SEARCH
					if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
						formObj.f_cmd.value=SEARCH01;
		           	    // Clear it. New key value
		           	    formObj.note_hdr_seq.value="";
	    				formObj.note_nm.value="";
	    				formObj.prc_cust_tp_cd_hidden.value="";
	    				var sXml=sheetObj.GetSearchData("ESM_PRI_0010GS.do", FormQueryString(formObj));
				 		ComPriXml2ComboItem(sXml, note_nm_cd, "note_hdr_seq", "note_nm");
				 		note_nm_cd.SetSelectIndex("-1");
				 		break;	
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
     * setting intial combo value <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo's Serial No
     * @return void
     * @author 
     * @version 2009.07.15
     */ 
	function initCombo(comboObj, comboNo) {
		switch(comboObj.options.id) {
 	        case "svc_scp_cd":
 	            var i=0;
 	            with(comboObj) {
 	            	SetDropHeight(260);
	            	SetMultiSelect(false);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(true);
	            	ValidChar(2);
	                SetMaxLength(3);
 	            }
 	            break;
 	        case "gline_seq":
 	        	var i=0;
	            with(comboObj) {
	            	SetDropHeight(260);
		            SetMultiSelect(0);
		            SetMaxSelect(1);
		            SetUseAutoComplete(0);		            
		            // add 2014.07.28
		            setComnoBySlineSeq(comboObj);
	            }
	            break;
 	        case "note_nm_cd":
	            var i=0;
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(false);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(false);
	            }
	            break;      
 	        case "prc_cust_tp_cd":
	            var i=0;
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(false);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(false);
	            	SetEnable(false);
	            }
	            break;     
	    }
	}
     
	function setComnoBySlineSeq(comboObj) {
		 with(comboObj) { 
                SetColWidth(0, "80");
                SetColWidth(1, "100");
                SetColWidth(2, "0");
	       }
	}
	
	
	/**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *        handling logic
     *     }
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.04.17
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBCREATE: // When Service Scope selected
				if ( sheetObj.id == "sheet0") {
					if (ComIsEmpty(formObj.note_ref_yr.value)) {
		 				ComPriInputValueFailed("input","year",formObj.note_ref_yr);
		 				return false;
		 			}
	    		} else if( sheetObj.id == "sheet1") {
	    		    if (ComIsEmpty(formObj.note_ref_yr.value)) {
		 				ComPriInputValueFailed("i","year",formObj.note_ref_yr);
		 				return false;
		 			}
	    			if (ComIsEmpty(comboObjects[0].GetSelectText())) {
	 	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
	 					return false;
	 				}
	    		}
	    		return true;
	 			break;
	 		case IBSEARCH: // retrieving
	 			if ( sheetObj.id == "sheet0") {
	 				if (ComIsEmpty(formObj.note_ref_yr.value)) {
	 					ComPriInputValueFailed("input","year",formObj.note_ref_yr);
		 				return false;
		 			 }	
		 			if (ComIsEmpty(comboObjects[0].GetSelectText())) {
		 				ComShowCodeMessage('PRI08002');
		 				return false;
		 			}	 			
	 			} else if ( sheetObj.id == "sheet1") {	
	 				if (ComIsEmpty(formObj.note_ref_yr.value)) {
	 					ComPriInputValueFailed("input","year",formObj.note_ref_yr);
		 				return false;
		 			}	
	 				if (ComIsEmpty(comboObjects[0].GetSelectText())) {
	 					ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
						return false;
					}
		 			if (ComIsEmpty(comboObjects[1].GetSelectText())) {
		 				ComPriInputValueFailed("input","Duration",comboObjects[1]);
		 				return false;
					}
		 			if (ComIsEmpty(formObj.exp_dt.value)) {
		 				ComPriInputValueFailed("input","Duration",formObj.exp_dt);
						return false;
					}
		 			if (ComIsEmpty(comboObjects[2].GetSelectText())) {
		 				ComPriInputValueFailed("select","Standard Note",comboObjects[2]);
		 				return false;
					}
	 			}
				return true;
	 			break;	 	
        }
        return true;
    }
	
    /**
     * Calling OnChange Event on service scope <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBCombo Object
     * @param {string} code Mandatory IBCombo Code
     * @param {string} text Mandatory IBCombo Code Name
     * @returns void
     * @author 
     * @version 2009.04.17
    */
	function svc_scp_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
  		if(comboObjects[0].GetItemCount() > 0 && comboObjects[0].GetSelectIndex() != "-1") {
 	 		if (validateForm(sheetObjects[0],document.form,IBCREATE)) {
 				var formObj=document.form;
 				var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);
 				if (code != -1) {
 					var text=comboObj.GetText(code, 1);
 					if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
 						formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
 						searchConditionReset(formObj,"1");
 						if(eventStatus != "IBCOPY")	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
 						formObj.svc_scp_nm.focus();
 					}
 				}
 	 		} else {
 	 			comboObjects[0].SetSelectIndex("-1");
 	  		}
  		}	
 	}
	
    /**
     * Calling OnClear Event on service scope <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBCombo Object
     * @returns void
     * @author 
     * @version 2009.04.17
     */
  	function svc_scp_cd_OnClear(comboObj) {
		var formObject=document.form;
		formObject.svc_scp_nm.value="";
		comboObj.SetSelectIndex(-1,false);
	}
  	
    /**
     * In case of IBCombo, This function check the Date <br>
     * <br><b>Example :</b>
     * <pre>
     *     isDateIBCombo(comboObj);
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBCombo Object
     * @returns boolean
     * @author 
     * @version 2009.04.17
     */
    function isDateIBCombo(comboObj) {
  		if(ComIsEmpty(comboObj.GetSelectText())) return;
	  	if(!ComIsDate(comboObj.GetSelectText())) {
	  		ComPriDateFormatFailed("Effective Date");
			comboObj.SetSelectText("",false);
			comboObj.focus();
			return false;
		}
	  	return true;
    }
    
    /**
     * Calling OnChange Event on gline_seq <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBCombo Object
     * @param {string} code Mandatory IBCombo Code
     * @param {string} text Mandatory IBCombo Code Name
     * @returns void
     * @author 
     * @version 2009.04.17
    */
   	function gline_seq_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code){
   		
   		var formObj=document.form;
		selectedGlineSeq=code;	
		
		 setComnoBySlineSeq(comboObj);
		
		if (code == "" || text == "") {
			return;
		}
		var effText=comboObj.GetText(code, 0);
		var expText=comboObj.GetText(code, 1);
		formObj.eff_dt.value=effText;
		formObj.exp_dt.value=expText;
		formObj.exp_dt_hidden_select.value=expText;
		if (code == null || code == "" || code == "X") {
			return true;
		}
		
		 setNoteNmCd();    
		
	}
    
     
    /**
     * when onFocus event triggered on exp_dt, Setting the value to hidden column <br>
     * <br><b>Example :</b>
     * <pre>
     *     setExpDtBefore();
     * </pre>
     * @returns void
     * @author 
     * @version 2009.04.17
    */
    function setExpDtBefore(){
   		var formObj=document.form;
   		formObj.exp_dt_before.value=setDash(formObj.exp_dt.value);
   	}
    
    /**
     * calling function in case of onBlur event on exp_dt <br>
     * <br><b>Example :</b>
     * <pre>
     *     setNoteNmCd();
     * </pre>
     * @returns boolean
     * @author 
     * @version 2009.04.17
    */
    function setNoteNmCd() {
 		var formObj=document.form;
 		if(eventStatus == "IBCOPY") return;
 		// Input begin Date
 		if(ComIsEmpty(formObj.note_hdr_seq.value)) {
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
 			formObj.exp_dt_hidden_select.value=""; 	 		
 	 		return;
 		}
 		// When eff_dt combobox is selected 
 		if(!ComIsEmpty(formObj.exp_dt_hidden_select.value) ) {
 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
 			formObj.exp_dt_hidden_select.value=""; 	 		
 	 		return;
 		}
	}
    
    /**
     * It calls when note_nm_cd is changed <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {ibcombo} comboObj Mandatory IBCombo Object
     * @param {string} code Mandatory IBCombo Code
     * @param {string} text Mandatory IBCombo Code Name
     * @returns void
     * @author 
     * @version 2009.04.17
     */
    function note_nm_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
 		var formObj=document.form;
 		if(eventStatus != "IBCOPY") {
	 		if(comboObjects[2].GetItemCount () > 0 && comboObjects[2].GetSelectIndex()!= "-1") {
	 			if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
	 				formObj.eff_dt.value=setDash(formObj.eff_dt.value);
	 				formObj.exp_dt.value=setDash(formObj.exp_dt.value);
	 				// Setting key value of note_nm_cd
					formObj.note_hdr_seq.value=code;
					// Setting Text value of note_nm_cd
					formObj.note_nm.value=getNoteNmTxt(code);
			 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			 		if(eventStatus != "IBSAVE")
			 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	 			} 
	 		}	
 		}	
	}
    
   /**
     * Reset Whole objects in screen <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {form} formObj Mandatory form Object
     * @returns void
     * @author 
     * @version 2009.04.17
     */
 	function removeAll2(formObj) {
 		comboObjects[0].SetSelectIndex("-1");
 		comboObjects[1].SetSelectIndex("-1");
 		comboObjects[1].RemoveAll();
 		comboObjects[2].SetSelectIndex("-1");
 		comboObjects[2].RemoveAll();
 		comboObjects[3].SetSelectIndex("-1");
 		formObj.reset();
 		sheetObjects[1].RemoveAll();
 		sheetObjects[2].RemoveAll();
 		eventStatus=""
	}
 	
    /**
     * Reset Whole objects in screen <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @param {form} formObj Mandatory form Object
     * @returns void
     * @author 
     * @version 2009.04.17
     */
 	function removeAll(formObj) {
 		if (checkModified(formObj)) {
 			if (ComShowCodeConfirm("PRI00006")) {
 				supressConfirm=true;
 				doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 				supressConfirm=false;
 			} else {
 				comboObjects[0].SetSelectIndex("-1");
 		 		comboObjects[1].SetSelectIndex("-1");
 		 		comboObjects[1].RemoveAll();
 		 		comboObjects[2].SetSelectIndex("-1");
 		 		comboObjects[2].RemoveAll();
 		 		comboObjects[3].SetSelectIndex("-1");
 		 		formObj.reset();
 		 		sheetObjects[1].RemoveAll();
 		 		sheetObjects[2].RemoveAll();
 			}
 		} else {	
 			comboObjects[0].SetSelectIndex("-1");
 	 		comboObjects[1].SetSelectIndex("-1");
 	 		comboObjects[1].RemoveAll();
 	 		comboObjects[2].SetSelectIndex("-1");
 	 		comboObjects[2].RemoveAll();
 	 		comboObjects[3].SetSelectIndex("-1");
 	 		formObj.reset();
 	 		sheetObjects[1].RemoveAll();
 	 		sheetObjects[2].RemoveAll();
 		}
 		eventStatus=""
	}
 	
    /**
     * Reset the search condition. <br>
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,"1");
     * </pre>
     * @param {form} formObj Mandatory form Object
     * @param {String} Value for Classification Mandatory 
     * @returns void
     * @author 
     * @version 2009.04.17
     */
 	function searchConditionReset(formObj,gubun) {
 		if(eventStatus == "IBCOPY") return;
 		//sc change
 		if(gubun == "1") {
	 		comboObjects[1].SetSelectIndex("-1");
	 		comboObjects[1].RemoveAll();
	 		formObj.eff_dt.value="";
	 		formObj.exp_dt.value="";
	 		comboObjects[2].SetSelectIndex("-1");
	 		comboObjects[2].RemoveAll();
	 		comboObjects[3].SetSelectIndex("-1");
	 		formObj.note_nm.value="";
	 		sheetObjects[1].RemoveAll();
	 		sheetObjects[2].RemoveAll();
 		} 
 		//eff_dt change
 		else if(gubun == "2") {	
 			comboObjects[2].SetSelectIndex("-1");
	 		comboObjects[2].RemoveAll();
	 		comboObjects[3].SetSelectIndex("-1");
	 		formObj.note_nm.value="";
	 		sheetObjects[1].RemoveAll();
	 		sheetObjects[2].RemoveAll();
 		}
	}
 	
    /**
     * After copying current search condition to hidden column, Reset search condition.<br>
     * <br><b>Example :</b>
     * <pre>
     *     removeCopy(formObj);
     * </pre>
     * @param {form} formObj Mandatory form Object
     * @returns void
     * @author 
     * @version 2009.04.17
     */
 	function removeCopy(formObj) {
 		if (eventStatus == "IBCOPY") {
			return false;
		}
 		var svc_scp_cd_beforeCopy=comboObjects[0].GetSelectCode();
 		var prc_cust_tp_cd_beforeCopy=comboObjects[2].GetSelectCode();
 		var note_hdr_seq_beforeCopy=formObj.note_hdr_seq.value;
 		comboObjects[0].SetSelectIndex("-1");
 		comboObjects[1].SetSelectIndex("-1");
 		comboObjects[1].RemoveAll();
 		comboObjects[2].SetSelectIndex("-1");
 		comboObjects[2].RemoveAll();
 		comboObjects[3].SetSelectIndex("-1");
 		formObj.reset();
 		formObj.svc_scp_cd_copy.value=svc_scp_cd_beforeCopy;
 		formObj.prc_cust_tp_cd_copy.value=prc_cust_tp_cd_beforeCopy;
 		formObj.note_hdr_seq_copy.value=note_hdr_seq_beforeCopy;
 		formObj.note_hdr_seq.value=note_hdr_seq_beforeCopy;
 		formObj.note_ref_yr.focus();
 	}
 	
   /**
    * Return the value of svc_scp_cd <br>
    * <br><b>Example :</b>
    * <pre>
    *     getSvcScpCd();
    * </pre>
    * @returns String
    * @author 
    * @version 2009.04.17
    */
    function getSvcScpCd() {
		return comboObjects[0].GetSelectCode();
	}
	
  /**
    * Return value of gline_seq <br>
    * <br><b>Example :</b>
    * <pre>
    *     getGlineSeq();
    * </pre>
    * @returns String
    * @author 
    * @version 2009.04.17
    */
	function getGlineSeq() {
		return comboObjects[1].GetSelectCode();
	}
	
  /**
    * Return value of note_nm_cd  <br>
    * <br><b>Example :</b>
    * <pre>
    *     getNoteNmCd();
    * </pre>
    * @returns String
    * @author 
    * @version 2009.04.17
    */
	function getNoteNmCd() {
   		return comboObjects[2].GetSelectCode();
   	}
	
    /**
     * Return value of note_nm_txt <br>
     * <br><b>Example :</b>
     * <pre>
     *     getNoteNmTxt();
     * </pre>
     * @returns String
     * @author 
     * @version 2009.04.17
     */
	function getNoteNmTxt() {
   		//return comboObjects[2].GetText(code,0);
    	 return comboObjects[2].GetSelectText();
   	}
	
    /**
    * Return value of cust_type_cd <br>
    * <br><b>Example :</b>
    * <pre>
    *     getCustTypeCd();
    * </pre>
    * @returns String
    * @author 
    * @version 2009.04.17
    */
	function getCustTypeCd() {
  		return comboObjects[3].GetSelectCode();
  	}
	
    /**
    * Returns value of eff_dt. <br>
    * <br><b>Example :</b>
    * <pre>
    *     getEffDt();
    * </pre>
    * @returns String
    * @author 
    * @version 2009.04.17
    */
	function getEffDt() {
		return document.form.eff_dt.value;
	}
	
    /**
    * Return value of exp_dt <br>
    * <br><b>Example :</b>
    * <pre>
    *     getExpDt();
    * </pre>
    * @returns String
    * @author 
    * @version 2009.04.17
    */
	function getExpDt() {
		return document.form.exp_dt.value;
	}
	
    /**
    * Return True when was modified<br>
    * <br><b>Example :</b>
    * <pre>
    *     checkModified(formObj);
    * </pre>
    * @returns boolean
    * @author 
    * @version 2009.04.17
    */
 	function checkModified(formObj) {
 		isModified=false;
		if (formObj.note_ref_yr.value != formObj.note_ref_yr_hidden.value 
    		|| formObj.exp_dt.value != formObj.exp_dt_hidden.value
    		|| getGlineSeq() != formObj.eff_dt_hidden.value 
    		|| getNoteNmTxt() != formObj.note_nm_hidden.value
    		|| getSvcScpCd() != formObj.svc_scp_cd_hidden.value
    		|| getCustTypeCd() != formObj.prc_cust_tp_cd_hidden.value 
    		|| sheetObjects[1].IsDataModified()
    		|| sheetObjects[2].IsDataModified()) {
			isModified=true;
		}
 		return isModified;
 	}
 	
 	/**
     * Insert dash (-) to Date column <br>
     * <br><b>Example :</b>
     * <pre>
     *      setDash(comboObject)
     * </pre>
     * @param {string} Date comboObject
     * @return string
     * @author 
     * @version 2009.05.18
     */
	function setDashIBCombo(obj) {
	   if(obj.GetSelectText()== "" || obj.GetSelectText().length == 0) return;
	   var date=obj.GetSelectText().replace(/-/g, "");
	   if(!ComIsNumber(date,'0123456789')) {
			ComShowCodeMessage('PRI00311');
			obj.SetSelectText("",false);
			return;
		}
	   var str="";
	   for(var i=0; i<date.length; i++) {
		   if(i == 4 || i == 6) {
			  str += "-" + date.substring(i,i+1);
		   } 
		   else {
			  str += date.substring(i,i+1);
		   }
	   }
	   obj.SetSelectText(str,false);
	}
	
	/**
     * Insert dash (-) to Date column <br>
     * <br><b>Example :</b>
     * <pre>
     *      setDash(date)
     * </pre>
     * @param {string} Date Value of input box
     * @return string
     * @author 
     * @version 2009.05.18
     */
	function setDash(value) {
	    if(value == "" || value.length == 0) return;
	    var date=ComTrimAll(value).replace(/-/g, ""); 
	    var str="";
	    for(var i=0; i<date.length; i++) {
		    if(i == 4 || i == 6) {
			    str += "-" + date.substring(i,i+1);
		    } 
		    else {
			    str += date.substring(i,i+1);
		    }
	    }
	    return str;
    }
	
	/**
     * Remove dash (-) from Date column <br>
     * <br><b>Example :</b>
     * <pre>
     *      removeDash(date)
     * </pre>
     * @param {string} Date Value of input box
     * @return string
     * @author 
     * @version 2009.05.18
     */
	function removeDash(date) {
	   if(date == "" || date.length == 0) return;
	   date=date.replace(/-/g, ""); 
	   return date;
	}
	
 	/**
      * Depend on MODE, it controls button <br>
      * <br><b>Example :</b>
      * <pre>
      *     toggleButtons(mode);
      * </pre>
      * @param {string} mode MODE
      * @return void
      * @author 
      * @version 2009.05.18
      */
	function toggleButtons(mode) {
		switch (mode) {
		case "CONF_YES":
			enableButton("btn_retrieve");
			enableButton("btn_new");
			disableButton("btn_save");
			disableButton("btn_confirm");
			enableButton("btn_cancel");
			disableButton("btn_delete3");
			enableButton("btn_copy");
			break;
		case "CONF_NO":
			enableButton("btn_retrieve");
			enableButton("btn_new");
			enableButton("btn_save");
			enableButton("btn_confirm");
			disableButton("btn_cancel");
			enableButton("btn_delete3");
			enableButton("btn_copy");
			break;
		case "IBCOPY":
			enableButton("btn_retrieve");
			enableButton("btn_new");
			enableButton("btn_save");
			disableButton("btn_confirm");
			disableButton("btn_cancel");
			disableButton("btn_delete3");
			disableButton("btn_copy");
			break;	
		case "CONV":
			enableButton("btn_save");
			break;	
		}
	}
	
 	/**
     * When sate the data, set the dp_seq <br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.05.18
     */
 	function setDpSeq(sheetObj)  {
 		if(!sheetObj.IsDataModified()) return;
 		for(var i=1; i<=sheetObj.RowCount(); i++) {
 			sheetObj.SetCellValue(i, "dp_seq",i,0);
 			if(sheetObj.GetRowStatus(i) == "R") {
 				sheetObj.SetRowStatus(i,"U");
 			}
 		}
 	}
 	
 	/**
     * Setting duration when OnKeyPress event triggered on Year<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchDuration();
     * </pre>
     * @return boolean
     * @author 
     * @version 2009.05.18
     */
 	function searchDuration() {
 		if(ComIsEmpty(document.form.note_ref_yr)) return;
 		if(!ComIsNumber(document.form.note_ref_yr,'0123456789')) {
 			ComShowCodeMessage('PRI00311');
 			document.form.note_ref_yr.value="";
 			return;
 		}
 		var formObj=document.form;
 		var length=document.form.note_ref_yr.value.length;
 		if(eventStatus == "IBCOPY") return;
 		if(length == 4) {
 			var note_ref_year=formObj.note_ref_yr.value;
 			if(!ComIsEmpty(formObj.note_hdr_seq.value)) {
	 			if (note_ref_year != formObj.eff_dt.value.substr(0,4) && note_ref_year != formObj.exp_dt.value.substr(0,4)) {
	 				ComShowCodeMessage('PRI00323');
	 				formObj.note_ref_yr.value=formObj.note_ref_yr_hidden.value;
	 				formObj.note_ref_yr.focus();
					return false;
				}
 			}
 		}
	}
 	
 	/**
     * Calling function in case of Onclick event <br>
     * Showing memopad for address inputting<br>
     * <br><b>Example :</b>
     * <pre>
     *		ShowMemoPad
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving 
     * @return void
     * @author 
     * @version 2009.06.03
     */  	           
     function showMemoPad(sheetObj, Row, Col) {
    	var colname=sheetObj.ColSaveName(Col);
     	switch(colname)
     	{
 	    	case "note_tit_nm":
 	    		ComShowMemoPad(sheetObj,Row,Col,true,932,200);
 	    		break;
     	}    	 
    }
     
 	 /**
     * Calling function in case of Onclick event <br>
     * Showing memopad for address inputting<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving 
     * @return void
     * @author 
     * @version 2009.06.03
     */  	           
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
	    //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
	    var colname=sheetObj.ColSaveName(Col);
     	switch(colname)
     	{
 	    	case "note_ctnt":
 	    		ComShowMemoPad(sheetObj,Row,Col,true,750,200);
 	    		break;
     	}    	 
    }
     
     /**
      * Calling function in case of OnPopupClick event<br>
      * Open Standard Note Conversion PopUp. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
      * @param {int} Col Mandatory OnPopupClick 'Cell's Column Index
      * @return void
      * @author 
      * @version 2009.05.07
      */ 
  	function sheet2_OnPopupClick(sheetObj, Row, Col) {
  		var colName=sheetObj.ColSaveName(Col);
  		var formObj=document.form;
  		var effDt=formObj.eff_dt.value;
  		var expDt=formObj.exp_dt.value;
  		if (colName == "conversion_pop") {
  			if(!ComIsNull(sheetObj.GetCellValue(Row, "note_conv_mapg_id")))	{
	  			var sParam="";
	  			sParam += "svc_scp_cd=" + getSvcScpCd();
	  			sParam += "&note_conv_mapg_id=" + sheetObj.GetCellValue(Row, "note_conv_mapg_id");
	  			sParam += "&prc_ctrt_tp_cd=" + getCustTypeCd();
	  			sParam += "&note_hdr_seq=" + sheetObj.GetCellValue(Row, "note_hdr_seq");
	  			sParam += "&note_ctnt=" + encodeURIComponent(sheetObj.GetCellValue( Row, "note_ctnt"));
	  			sParam += "&eff_dt=" + effDt;
	  			sParam += "&exp_dt=" + expDt;
	  			var sUrl="ESM_PRI_0012.do?"+sParam;
	  			ComOpenPopup(sUrl, 850, 480, 'conversion_returnVal', '1,0,1,1,1', true);
	  			
  			} else {
  				ComShowCodeMessage("PRI08015");
  			}
  		}
  	}
  	
  	function conversion_returnVal(rtnVal) {
  		if (rtnVal != null) {
			sheetObj.SetCellValue(Row, "note_conv_flg", rtnVal.note_conv_flg,0);
			eventStatus2="CONV";
			toggleButtons("CONV");
		}
  	}
  	
