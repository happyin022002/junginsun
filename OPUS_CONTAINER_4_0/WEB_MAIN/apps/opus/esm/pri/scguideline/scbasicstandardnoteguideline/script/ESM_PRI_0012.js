/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0012.js
*@FileTitle : Standard Note Conversion Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.23 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 
   /**
     * @
     * @author 
     */

    /**
     * @extends 
     * @class ESM_PRI_0012 : Business Script for ESM_PRI_0012
     */
    
	// common global variables
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	var tabLoad = new Array();
	tabLoad[0]= 0;
	tabLoad[1]= 0;
	
	var sChgCdVisiable = "";

	// Event handler processing by button click event */
	document.onclick = processButtonClick;

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
         

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        
        /*******************************************************/
        var formObject = document.form;

		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    		
			switch (srcName) {
				case "btn_retrieve":					
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);					
					break;
		
				case "btn_close":
					ComClosePopup(); 
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
		sheetObjects[sheetCnt++] = sheet_obj;
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

		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		  
		sheetObjects[0].WaitImageVisible = false;  
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
        sheetObjects[0].WaitImageVisible = true;   
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

		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {

			case "sheet1":
				with (sheetObj) {
								
					var HeadTitle = "|Sel.|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Per|Cargo\nType|IMDG\nClass" +
					"|Cur.|Cal.|Amount|POR|POL|POD|DEL|Commodity|Commodity\nGroup" +
					"|Receiving\nTerm|Delivery\nTerm|US SVC Mode|Pay Term|Type|Per\n(in S/C)|Cargo Type\n(in S/C)" +
					"|1|2|3|4|5|6|7|8|9|10|11|12|13";
					
            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:6, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [                
            		 {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"ibflag" },
            		 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  	ColMerge:0,   SaveName:"chk" },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"chg_rule_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",    ColMerge:0,   SaveName:"eff_dt",          		KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",    ColMerge:0,   SaveName:"exp_dt",          		KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Combo",     Hidden:0,  Width:85,  Align:"Center",    ColMerge:0,   SaveName:"rt_appl_tp_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_rat_ut_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_imdg_clss_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"curr_cd",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		                 
            		 {Type:"Combo",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"rt_op_cd",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Right",    ColMerge:0,   SaveName:"frt_rt_amt",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_por_def_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_pol_def_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_pod_def_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_del_def_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_cmdt_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Combo",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_scg_grp_cmdt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Combo",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_rcv_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Combo",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_de_term_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 	            		 
            		 {Type:"Combo",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"bkg_usa_svc_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Combo",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"pay_term_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Combo",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"rule_appl_chg_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"conv_rat_ut_cd",          	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            		 {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",    ColMerge:0,   SaveName:"conv_prc_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	            		 
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"note_conv_mapg_id" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"note_conv_seq" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"svc_scp_cd" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"chg_rule_tp_cd" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"note_conv_chg_cd" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"note_conv_rule_cd" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_por_tp_cd" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
            		
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"bkg_del_tp_cd" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"note_hdr_seq" },
            		 {Type:"Text",    Hidden:1, Width:30,   Align:"Center",  	ColMerge:0,   SaveName:"note_conv_tp_cd" }		             
		             ];
				
            		
            		InitColumns(cols);

            		 InitDataCombo(0, "rule_appl_chg_tp_cd", ruleApplChgTpCdComboText, ruleApplChgTpCdComboValue);
                     InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);            
                     InitDataCombo(0, "rt_op_cd", rtOpCdComboText, rtOpCdComboValue);
                     InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);
                     InitDataCombo(0, "bkg_usa_svc_mod_cd", bkgUsaSvcModCdComboText, bkgUsaSvcModCdComboValue);
                     InitDataCombo(0, "bkg_rcv_term_cd", bkgRcvTermCdComboText, bkgRcvTermCdComboValue);
                     InitDataCombo(0, "bkg_de_term_cd", bkgDeTermCdComboText, bkgDeTermCdComboValue);
                     InitDataCombo(0, "bkg_scg_grp_cmdt_cd", bkgScgGrpCmdtCdComboText, bkgScgGrpCmdtCdComboValue);                      
                   
                     
            		SetEditable(1);
            		//nosupport[checkagain]CLTUnEditableColor="#000000";
            		SetWaitImageVisible(0);
                    SetShowButtonImage(2);
                    SetColHidden("del_chk",1);
                    //SetAutoRowHeight(0);
                    SetSheetHeight(228);
                    
				}
				break;
         }
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
  	function doActionIBSheet(sheetObj, formObj, sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch (sAction) {
  			case IBSEARCH: // retrieving
  					formObj.f_cmd.value = SEARCH01;
					ComOpenWait(true);
					sheetObj.DoSearch("ESM_PRI_0012GS.do", FormQueryString(formObj) );					
					ComOpenWait(false);
  				break;  		
  		}
  	}
  	
  
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {string} ErrMsg mandatory from server
	 * @return void
	 * @author 
	 * @version 2009.05.20
	 */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		
		 for(var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
 			var prevStatus = sheetObj.RowStatus(i);
 			if(sheetObj.GetCellValue(i,"exp_dt") == "99991231") {
 				sheetObj.SetCellValue(i,"exp_dt","", 0);
 			}
			sheetObj.RowStatus(i) = prevStatus; 
			

	 		//Setting color in case of state code at route.
	 		setStateColor(sheetObj, i);
			
	 		//Setting color in case of Rule Code
	 		//setChargeRuleColor(sheetObj, i);
 		}
	}
      
  	/**
  	 * Setting color in case of status code at Route<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setStateColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object's Row Index
  	 * @return void
  	 * @author 
  	 * @version 2009.07.09
  	 */ 
 	function setStateColor(sheetObj, Row) {
 		// State color
 		var pinkColor = sheetObj.RgbColor(255,192,203);
 		
		if(sheetObj.GetCellValue(Row, "bkg_por_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_por_def_cd", pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "bkg_pol_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd", pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "bkg_pod_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd", pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "bkg_del_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_del_def_cd", pinkColor);
 		}
		
		if(sheetObj.GetCellValue(Row, "conv_org_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_org_loc_def_cd", pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_org_via_loc_def_cd", pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_dest_via_loc_def_cd", pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "conv_dest_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_dest_loc_def_cd", pinkColor);
 		} 		
 	
 	}
 	
  	/**
  	 * Setting color in case of status code at Route<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setChargeRuleColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object's Row Index
  	 * @return void
  	 * @author 
  	 * @version 2009.07.09
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// defining Rule & Charge Code color
 		var sCodeColor = sheetObj.RgbColor(255,200,200);
 		var chgRuleDefCd = sheetObj.GetCellValue(Row, "chg_rule_def_cd");
	 		
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "RAC" ) {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd", 0);
 		} else {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd", sCodeColor);
 		} 
 	}
  
	 