/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3006.js
*@FileTitle  : Tariff Fomula Rule Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var selectedGlineSeq=null;
	//Event handler processing by button click event
	document.onclick=processButtonClick;
	
	/**
     * Event handler processing by button name  <br>
     */
	function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			
			switch (srcName) {
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
  /**
	* registering IBSheet Object as list <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
  /**
	* registering IBCombo Object as list <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	
   /**
    * Initializing and setting Sheet basics <br>
    * Setting body tag's onLoad event handler <br>
    * Adding pre-handling function after loading screen on the browser  <br>
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	    //initializing IBMultiCombo
	    for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
	    ComPriTextCode2ComboItem(srchTrfCdComboValue, srchTrfCdComboText, getComboObject(comboObjects, 'srch_trf_cd') ,"|","\t" );
	    
	    //2014.10.27(OPUS_NYK_CR_663)
	    var strTrfCd = document.form.trf_cd.value;
	    if(strTrfCd != undefined && strTrfCd != null && strTrfCd != "" && strTrfCd != "null") {
	    	srch_trf_cd.SetSelectCode(strTrfCd,false);
	    	var comboObj = srch_trf_cd;
	    	var strTrfTxt = comboObj.GetText(comboObj.FindItem(strTrfCd, 0), 1);
	    	srch_trf_cd_OnChange(comboObj, null, null, null, comboObj.FindItem(strTrfCd, 0), strTrfCd+"|"+strTrfTxt, strTrfCd);

	    }
	}
	
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
     	switch(sheetID) {
         	case "sheet1":
         	    with(sheetObj){
         			
         			var HeadTitle="|Sel.|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
         		    				"|Pay Term|Commodity|US SVC Mode|POR|POL|POD|DEL" +
         		    				"|Receiving\nTerm|Delivery\nTerm" +
         		    				"|Type|Per\n(in Tariff)|Cargo Type\n(in Tariff)" +
         		    				"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19";
         		    var headCount=ComCountHeadTitle(HeadTitle);

         		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:6, DataRowMerge:1 } );

         		    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
         		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
         		    InitHeaders(headers, info);

         		    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
         		           {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
         		           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:10 },
         		           {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
         		           {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
         		           {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_usa_svc_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
         		           {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
         		           {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
         		           {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
         		           {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rule_appl_chg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"conv_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"tri_prop_no" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_cnt_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_cnt_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_cnt_cd" },
         		           {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_cnt_cd" } ];
         		     
         		    InitColumns(cols);

         		    SetEditable(0);
         		                                        SetCountPosition(0);
         		    SetImageList(0,"img/btns_calendar.gif");
         		    SetWaitImageVisible(0);
         		    SetShowButtonImage(2);
         		    SetColProperty("rule_appl_chg_tp_cd", {ComboText:ruleApplChgTpCdComboText, ComboCode:ruleApplChgTpCdComboValue} );
         			SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
         			SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
         			SetColProperty("bkg_usa_svc_mod_cd", {ComboText:bkgUsaSvcModCdComboText, ComboCode:bkgUsaSvcModCdComboValue} );
         			SetColProperty("bkg_rcv_term_cd", {ComboText:bkgRcvTermCdComboText, ComboCode:bkgRcvTermCdComboValue} );
         			SetColProperty("bkg_de_term_cd", {ComboText:bkgDeTermCdComboText, ComboCode:bkgDeTermCdComboValue} );
         		      
         			resizeSheet();//SetSheetHeight(250);
                }
                break;
     	}
	}
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    }
	
   /**
    * initializing IBCOMBO <br>
    */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "srch_trf_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxLength(8);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	ValidChar(2,3);
	            }
	            break;
	        case "note_seq":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(0);
					SetColWidth(0, "130");
					SetColWidth(1, "130");
					SetColWidth(2, "0");
	            }
	            break
	    }
	}
	
      /**
       * Handling sheet process <br>
       */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
 			sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {
				case IBSEARCH_ASYNC01: // retrieving Duration when selecting Service Scope
					formObj.f_cmd.value=SEARCH02;
//parameter changed[check again]CLT
					var sXml=sheetObj.GetSearchData("ESM_PRI_3006GS.do", FormQueryString(formObj));
					comboObjects[1].RemoveAll();
					sheetObj.RemoveAll();
					ComPriXml2ComboItem(sXml, note_seq, "note_seq", "eff_dt|exp_dt|eff_dt", false);					
					break;
				case IBSEARCH_ASYNC02: // setting INFO after selecting Duration
	  				ComOpenWait(true);
					formObj.f_cmd.value=SEARCH02;
//parameter changed[check again]CLT
					var sXml=sheetObj.GetSearchData("ESM_PRI_3006GS.do", FormQueryString(formObj));
					var arrData=ComPriXml2Array(sXml, "note_conv_mapg_id|cfm_flg");
					formObj.note_conv_mapg_id.value=arrData[0][0];
		 			formObj.cfm_flg.value=arrData[0][1];	 			
		 			getConfirmName(arrData[0][1]);	
		 	 		doActionIBSheet(sheetObj, document.form, IBSEARCH);
					break;
	 			case IBSEARCH: // retrieve
	  				ComOpenWait(true);
		 			// NOTE CONVERSION RULE
					var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			formObj.f_cmd.value=SEARCH01;
//parameter changed[check again]CLT
		 			var sXml=sheetObj.GetSearchData("ESM_PRI_3006GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
	 				break;
	 		}
 		}catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e.message);
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
 		case IBSEARCH: // retrieve
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			break;
 		}
 		return true;
 	}
 	
 	/**
	 * calling function when occurring OnSearchEnd Event <br>
	 */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj=document.form;
 		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
 			var prevStatus=sheetObj.GetRowStatus(i);
 			if(sheetObj.GetCellValue(i,"exp_dt") == "99991231") {
 				sheetObj.SetCellValue(i,"exp_dt","",0);
 			}
			sheetObj.SetRowStatus(i,prevStatus);
	 		// setting color in case of state code in Route
	 		setStateColor(sheetObj, i);
	 		// setting color in case of Rule Code
	 		//setChargeRuleColor(sheetObj, i);
 		}
	}
	
  	/**
  	 * setting color in case of state code in Route<br>
  	 */ 
 	function setStateColor(sheetObj, Row) {
 		var pinkColor="#FFC0CB";
 		if(sheetObj.GetCellValue(Row, "bkg_por_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "bkg_pol_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "bkg_pod_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "bkg_del_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "conv_org_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_org_loc_def_cd",pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_org_via_loc_def_cd",pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_dest_via_loc_def_cd",pinkColor);
 		}
		if(sheetObj.GetCellValue(Row, "conv_dest_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_dest_loc_def_cd",pinkColor);
 		} 		
 	}
 	
  	/**
  	 * setting color in case of Code is Rule Code <br>
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		var sCodeColor="#FFC8C8";
 		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "RAC" ) {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",0);
 		} else {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",sCodeColor);
 		} 
 	}
 	
   	/**
   	 * calling function when occurring OnChange Event <br>
   	 */
 	function srch_trf_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, text, code) {
	
		var formObj=document.form;
   		var arrText=text.split("|");
   		if (arrText != null && arrText.length > 0) {
   			if(code != "") {
   				formObj.srch_trf_nm.value=comboObj.GetText(code, 1);
   				var arr=code.split("-");				
   				formObj.trf_pfx_cd.value=arr[0];
   				formObj.trf_no.value=arr[1];
   				selectedGlineSeq=null;			
   				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
   			} else {
   				formObj.srch_trf_nm.value="";
   			}
   			
   		}
	}
	
   	function srch_trf_cd_OnClear(comboObj) {
   		var formObject=document.form;
   		formObject.srch_trf_nm.value="";
   		comboObj.SetSelectIndex(-1);
   	}
   	
   	/**
  	 * calling event when focus out<br>
  	 */
//  	function srch_trf_cd_OnBlur(comboObj) {
//  		var formObj=document.form;
//  		var code=comboObj.GetText(comboObj.FindItem(comboObj.GetSelectCode(), 0), 0);
//  		
//  		if (code != null && code != "") {
//  	   		var arr=code.split("-");				
//  			formObj.trf_pfx_cd.value=arr[0];
//  			formObj.trf_no.value=arr[1];
//  			var text=comboObj.GetText(code, 1);
//  			if (text != null && text != "" && text != formObj.srch_trf_nm.value) {
//  				formObj.srch_trf_nm.value=comboObj.GetText(code, 1);
//  	 			selectedGlineSeq=null;
//  	 			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
//  			}
//  		}
//  	}
  	
 	/**
 	 * calling function when occurring OnChange Event <br>
 	 */
 	function note_seq_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, text, code) {
 		var formObj=document.form;
 		selectedGlineSeq=code;
 		if (code == "" || text == "") {
 			return;
 		}
 		var effText=comboObj.GetText(code, 0);
 		var expText=comboObj.GetText(code, 1);
 		formObj.eff_dt.value=effText;
 		formObj.exp_dt.value=expText;
 		if (code == null || code == "" || code == "X") {
 			return true;
 		}
 		//  setting FORM after retrieving INFO
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
 	}
 	
 	/**
 	 * calling event when occurring OnClear event <br>
 	 */
 	function note_seq_OnClear(comboObj) {
 		var formObj=document.form;
 		note_seq.SetSelectCode(-1);
 		formObj.eff_dt.value="";
 		formObj.exp_dt.value="";
 		formObj.cfm_flg.value="";
 		formObj.cfm_flg_nm.value="";
 	}
 	
 	/**
 	 * calling event when occurring OnKeyUp event <br>
 	 */
 	function note_seq_OnKeyUp(comboObj, KeyCode, Shift) {
 		var selEffDt=comboObj.GetSelectText();
 		if (selEffDt.search(/[^0-9]/gi) >= 0) {
 			selEffDt=selEffDt.replace(/[^0-9]/gi, "");
 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
 		}
 		if (selEffDt.length == 8) {
 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
 			document.form.exp_dt.focus();
 		}
 	}
 	
 	/**
 	 * calling event when occurring OnFocus event <br>
 	 */
 	function note_seq_OnFocus(comboObj) {
 		var selEffDt=comboObj.GetSelectText();
 		if (selEffDt != null && selEffDt != "") {
 			selEffDt=selEffDt.replace(/-/gi, "");
 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
 		}
 	}
 	
 	/**
 	 * calling event when focus out<br>
 	 */
 	function note_seq_OnBlur(comboObj) {
 		var selEffDt=comboObj.GetSelectText();
 		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
 			return false;
 		} 		
 		if (ComIsDate(selEffDt)) {
 			selEffDt=selEffDt.replace(/-/gi, "");
 			selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
 			document.form.eff_dt.value=selEffDt;
 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
 		} else {
 			ComShowCodeMessage("COM12134", "Effective Date");
 			document.form.note_seq.focus();
 			return false;
 		}
 	}
 	
   /**
    * changing flag name to Confirmation Flag value <br>
    */  	    
    function getConfirmName(flg) {
    	var formObj=document.form;
		if(flg == "Y"){
			formObj.cfm_flg_nm.value="Yes";
			formObj.cfm_flg.value="Y";
		} else if(flg == "N"){
			formObj.cfm_flg_nm.value="No";
			formObj.cfm_flg.value="N";
		} else {
			formObj.cfm_flg_nm.value="";
			formObj.cfm_flg.value="";
		}
    }