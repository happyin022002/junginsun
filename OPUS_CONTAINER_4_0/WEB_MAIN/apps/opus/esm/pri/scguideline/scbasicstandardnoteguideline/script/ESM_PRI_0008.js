/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0008.js
*@FileTitle  : Standard Note Conversion Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/16
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0008 : business script for ESM_PRI_0008 
     */
    function ESM_PRI_0008() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// Common Global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	var sChgCdVisiable="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.10.28
     */
	function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_copy":
					if(validateForm(sheetObject1,formObject,COMMAND01)) {
						doActionIBSheet(sheetObject1,formObject,COMMAND01);
					}
					break;
				case "btn_paste":
					if(validateForm(sheetObject1,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject1,formObject,COMMAND02);
					}
					break;
				case "btn_rowadd":
					if(validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;
				case "btn_rowcopy":
					if(validateForm(sheetObject1,formObject,IBCOPYROW)) {
						doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					}
					break;
				case "btn_delete":
					if(validateForm(sheetObject1,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;
				case "btn_save":
					if(validateForm(sheetObject1,formObject,IBSAVE)) {
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					}
					break;
				case "btn_close":
					var rowCount = sheetObject1.RowCount();
					if(rowCount > 0) {
						ComPopUpReturnValue("1");
					} else {
						ComPopUpReturnValue("0");
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
	    * <br><b>Example :</b>
	    * <pre>
	    *     setSheetObject(sheetObj);
	    * </pre>
	    * @param {ibsheet} sheet_obj Mandatory IBSheet Object
	    * @return N/A
	    * @author 
	    * @version 2009.10.28
	    */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
   /**
    * initializing sheet <br>
    * implementing onLoad event handler in body tag <br>
    * adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return N/A
    * @author 
    * @version 2009.05.17
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
	}

    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
		   case "sheet1":
			   with(sheetObj){
	
	           var HeadTitle =  "|Sel.|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Per|Cargo\nType|IMDG\nClass" +
				"|Cur.|Cal.|Amount|POR|POL|POD|DEL|Commodity|Commodity\nGroup" +
				"|Receiving\nTerm|Delivery\nTerm|US SVC Mode|Pay Term|Type|Per\n(in S/C)|Cargo Type\n(in S/C)" +
				"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17";
				
	           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1, ComboMaxHeight:150 } );

	           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	           var headers = [ { Text:HeadTitle, Align:"Center"} ];
	           InitHeaders(headers, info);

	           var cols = [ {Type:"Status",    	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                        {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                        {Type:"Combo", 		Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chg_rule_def_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"PopupEdit", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"PopupEdit", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"rt_appl_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_rat_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_prc_cgo_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Text",      	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bkg_imdg_clss_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	                        {Type:"Combo",     	Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rt_op_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Float",     	Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
	                        {Type:"PopupEdit", 	Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"bkg_por_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5  },
	                        {Type:"PopupEdit", 	Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"bkg_pol_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5  },
	                        {Type:"PopupEdit", 	Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"bkg_pod_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5  },
	                        {Type:"PopupEdit", 	Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"bkg_del_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5  },
	                        {Type:"PopupEdit", 	Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cmdt_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6  },
	                        {Type:"Combo",     	Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_scg_grp_cmdt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_usa_svc_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pay_term_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"rule_appl_chg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"conv_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Combo",     	Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"conv_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                        {Type:"Text",     	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_cnt_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_cnt_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_cnt_cd" },
	                        {Type:"Text",      	Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_cnt_cd" } ];
       		
	           InitColumns(cols);
			     
	           SetColProperty("rule_appl_chg_tp_cd", {ComboText:ruleApplChgTpCdComboText, ComboCode:ruleApplChgTpCdComboValue} );
	           SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
	           SetColProperty("bkg_prc_cgo_tp_cd", {ComboText:bkgPrcCgoTpCdComboText, ComboCode:bkgPrcCgoTpCdComboValue} );
	           SetColProperty("rt_op_cd", {ComboText:rtOpCdComboText, ComboCode:rtOpCdComboValue} );
	           SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
	           SetColProperty("bkg_usa_svc_mod_cd", {ComboText:bkgUsaSvcModCdComboText, ComboCode:bkgUsaSvcModCdComboValue} );
	           SetColProperty("bkg_rcv_term_cd", {ComboText:bkgRcvTermCdComboText, ComboCode:bkgRcvTermCdComboValue} );
	           SetColProperty("bkg_de_term_cd", {ComboText:bkgDeTermCdComboText, ComboCode:bkgDeTermCdComboValue} );
	           SetColProperty("conv_prc_cgo_tp_cd", {ComboText:convPrcCgoTpCdComboText, ComboCode:convPrcCgoTpCdComboValue} );
	           SetColProperty("bkg_rat_ut_cd", {ComboText:bkgRatUtCdComboText, ComboCode:bkgRatUtCdComboValue} );
	           SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
	           SetColProperty("conv_rat_ut_cd", {ComboText:convRatUtCdComboText, ComboCode:convRatUtCdComboValue} );
	           SetColProperty("bkg_scg_grp_cmdt_cd", {ComboText:bkgScgGrpCmdtCdComboText, ComboCode:bkgScgGrpCmdtCdComboValue} );
	           SetColProperty("chg_rule_def_cd", {ComboText:chargeRuleCdComboText, ComboCode:chargeRuleCdComboValue} );
			  

		     sChgCdVisiable=chargeRuleCdComboText;
		     
		     SetColProperty(0 ,"chg_rule_def_cd" 	, {AcceptKeys:"E" , InputCaseSensitive:1});		
		     SetColProperty(0 ,"bkg_imdg_clss_cd" 	, {AcceptKeys:"N|[.]"});		
		     SetColProperty(0 ,"bkg_cmdt_def_cd" 	, {AcceptKeys:"N"});		
		     SetColProperty(0 ,"bkg_por_def_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		     SetColProperty(0 ,"bkg_pol_def_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		     SetColProperty(0 ,"bkg_pod_def_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		     SetColProperty(0 ,"bkg_del_def_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
		     
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
    * Handling Sheet's process <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj Mandatory html form object
    * @param {int} sAction Mandatory ,process constant variable
    * @return N/A
    * @author 
    * @version 2009.05.22
    */
  	function doActionIBSheet(sheetObj, formObj, sAction) {
  		try {
	  		sheetObj.ShowDebugMsg(false);
	  		switch (sAction) {
	  			case IBSEARCH: 
	  				ComOpenWait(true);
		  			// NOTE CONVERSION RULE
					var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
					formObj.f_cmd.value=SEARCH01;					
	  				var sXml=sheetObj.GetSearchData("ESM_PRI_0008GS.do", FormQueryString(formObj));	  				
	  				var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd");			
	  				if (arrData != null && arrData.length > 0) {
						for(var i=0; i<arrData.length; i++){						
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}
//						sheetObj.RenderSheet(0);
						sheetObj.LoadSaveData(sXml,{Sync:0} );
//						ssheetObj.RenderSheet(1);
						sheetObj.SetColProperty(2, {ComboText:sNm , ComboCode:sCd} );
					}

	  				break;
	  			case IBSAVE: 
		  			if((ComShowCodeConfirm("PRI00001")) ) {			  			
		  				ComOpenWait(true);
			  			formObj.f_cmd.value=MULTI01;
		  				var sParam=FormQueryString(formObj);
		  				var sParamSheet=sheetObj.GetSaveString();
		  				if (sParamSheet != "") {
		  					sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
		  				}		  	
		  				var sXml=sheetObj.GetSaveData("ESM_PRI_0008GS.do", sParam);
		  				sheetObj.LoadSaveData(sXml, {Sync:1});
						//Setting main's Conversion Flag
//						var obj=new Object();
//						if(sheetObj.RowCount() > 0){
//							obj.note_conv_flg="1";	
//						} else {
//							obj.note_conv_flg="0";	
//						}
		  			}
	  				break;
	  			case IBINSERT: // Row Add
					var idx=sheetObj.DataInsert();
		  			sheetObj.SetCellValue(idx, "exp_dt","",0);//STANDARD NOTE  DEFAULT :  99991231
					sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value,0);
					sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
					sheetObj.SetCellValue(idx, "note_hdr_seq",formObj.note_hdr_seq.value,0);
					sheetObj.SetCellValue(idx, "note_conv_mapg_id",formObj.note_conv_mapg_id.value,0);
					sheetObj.SetCellValue(idx, "note_conv_tp_cd","T",0);//(Guideline Standard Note)
					sheetObj.SetCellValue(idx, "note_conv_seq",parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1,0);
					sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
					//applying in case exiting default value in code
					defaultColumnValidation(sheetObj, idx, "chg_rule_def_cd", sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
					//Editable
					disableColumnValidation(sheetObj, idx, "chg_rule_def_cd", sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
	  				break;
				case IBDELETE: // Delete
					var iCheckRow=sheetObj.FindCheckedRow("chk");
					if(iCheckRow == ""){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}
					iCheckRow=sheetObj.FindCheckedRow("chk");
					if(iCheckRow != "") {
						deleteRowCheck(sheetObj, "chk");
					}
					break;
				case IBCOPYROW:
					copySheetData(sheetObj);
					break;
				case COMMAND01: //COPY
					var iCheckRow=sheetObj.FindCheckedRow("chk");
					if((ComShowCodeConfirm("PRI00012")) ) {
						if(iCheckRow != "") {
							comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
						}
		  				ComOpenWait(true);
			  			formObj.f_cmd.value=MULTI02;
		  				var sParam=FormQueryString(formObj);
		  				var sParamSheet=sheetObj.GetSaveString();
		  				if (sParamSheet != "") {
		  					sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
		  				}		  				
 		  				var sXml=sheetObj.GetSaveData("ESM_PRI_0008GS.do", sParam);
 		  				sheetObj.LoadSaveData(sXml);
					}
					break;
				case COMMAND02: //PASTE
					if((ComShowCodeConfirm("PRI00016")) ) {
		  				ComOpenWait(true);
						// NOTE CONVERSION RULE
						var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
						var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
						formObj.f_cmd.value=SEARCH02;
 						var sXml=sheetObj.GetSearchData("ESM_PRI_0008GS.do", FormQueryString(formObj));
						var arrData=ComPriXml2Array(sXml, "note_conv_seq"); 
				      	if(arrData != null && arrData.length > 0) {
				      		//Calling InitDataCombo after adding to combo list
				      		for(var i=0; i<arrData.length; i++){						
								if (sCd.indexOf(arrData[i][0]) < 0) {
									sCd += "|" + arrData[i][0];
									sNm += "|" + arrData[i][0];
								}
							}					
							sheetObj.SetColProperty(2, {ComboText:sNm , ComboCode:sCd} );
							//////////////////////////////////////	
				      		sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
				      		//Setting default after loading sheet
				      		var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
				      		var arrRow=ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
				      		if(arrRow != null && arrRow.length > 0) {  
				      			for(var i=0; i<arrRow.length; i++) {
					      			sheetObj.SetRowStatus(arrRow[i],"I");
					      			sheetObj.SetCellValue(arrRow[i], "note_conv_seq",maxSeq + i,0);
					      			sheetObj.SetCellValue(arrRow[i], "note_conv_mapg_id",formObj.note_conv_mapg_id.value,0);
					      			sheetObj.SetCellValue(arrRow[i], "svc_scp_cd",formObj.svc_scp_cd.value,0);
					      			sheetObj.SetCellValue(arrRow[i], "note_hdr_seq",formObj.note_hdr_seq.value,0);
					      			sheetObj.SetCellValue(arrRow[i], "note_conv_tp_cd","T",0);//(Guideline Standard Note)
				      			}
				      		}
				      	} else {
				      		ComShowCodeMessage("PRI00328");
				      	}
					}
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
    * Calling function in case of Onchange Event <br>
    * Showing description when selecting Multi ComboBox <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory ,Cell's Value
    * @return N/A
    * @author 
    * @version 2009.06.25
    */  
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		switch(colName)
    	{
			case "chg_rule_def_cd":		
				if (Value != null && Value != "" && Value.length == 3) {
					//Handling default data
					defaultColumnValidation(sheetObj, Row, Col, Value);
					disableColumnValidation(sheetObj, Row, Col, Value);
					var sCode=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
					var sText=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
					if (sCode.indexOf(Value) < 0) {
						formObj.f_cmd.value=COMMAND09;
 						sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
						var arrData=ComPriXml2Array(sXml, "cd|nm");
						if (arrData != null && arrData.length > 0) {
							sCode += "|" + Value;
							sText += "|" + Value;
							sheetObj.SetColProperty("chg_rule_def_cd", {ComboText:sText , ComboCode:sCode} );
							ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
						} else {
							sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
						}
					}
					insertChargeRuleType(sheetObj, Row);
				} else {
					sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
				}
 				// Rule & Charge Code color
 				//setChargeRuleColor(sheetObj, Row);
				break;
			case "eff_dt":	
				var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
				var expDt=ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
				if(sheetObj.GetCellValue(Row, "eff_dt") < effDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
					sheetObj.SelectCell(Row,"eff_dt");
				}
				if(sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt")  && (sheetObj.GetCellValue(Row, "exp_dt") != "")){
					ComShowCodeMessage("PRI00306");
					sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
					sheetObj.SelectCell(Row,"eff_dt");
				}
				break;
			case "exp_dt":	
				var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
				var expDt=ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
				if(sheetObj.GetCellValue(Row, "exp_dt") > expDt && sheetObj.GetCellValue(Row, "exp_dt") != "99991231") {
					ComShowCodeMessage("PRI08016");
					sheetObj.SetCellValue(Row, "exp_dt",getExpDtNull(),0);
					sheetObj.SelectCell(Row,"exp_dt");
				}
				if(sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt") && (sheetObj.GetCellValue(Row, "exp_dt") != "")){
					ComShowCodeMessage("PRI00306");
					sheetObj.SetCellValue(Row, "exp_dt",getExpDtNull(),0);
					sheetObj.SelectCell(Row,"exp_dt");
				}
				break;
			case "bkg_cmdt_def_cd":	    		
	    		if (Value.length > 0){
	    			formObj.f_cmd.value=SEARCH08;
	    			formObj.cd.value=ComLpad(Value, 6, "0");
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != ""){
  						sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd",ComLpad(Value, 6, "0"),0);
						sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","C",0);
  					}else{
	  					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
	  					sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.SetCellValue(Row, "bkg_cmdt_def_cd","",0);
  					sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
  					sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
	    		}
	    		break;
			case "bkg_por_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value=COMMAND24;
	    			formObj.cd.value=Value;
	    			var sParam=FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_SG;
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
	  				if(Value == "EAST" || Value == "WEST" ) {
						sheetObj.SetCellValue(Row,"bkg_por_def_cd",Value,0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
						sheetObj.SetCellValue(Row, "bkg_por_def_cd",arrData[0],0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
  					}else{
	  					sheetObj.SetCellValue(Row,"bkg_por_def_cd","",0);
	  					sheetObj.SetCellValue(Row,"bkg_por_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"bkg_por_def_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.SetCellValue(Row, "bkg_por_def_cd","",0);
  					sheetObj.SetCellValue(Row, "bkg_por_tp_cd","",0);
  					sheetObj.SelectCell(Row, "bkg_por_def_cd");
	    		}
	    		sheetObj.SetCellBackColor(Row,"bkg_por_def_cd", 0);
	    		break;	
			case "bkg_pol_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value=COMMAND24;
	    			formObj.cd.value=Value;
	    			var sParam=FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_SG;
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
	  				if(Value == "EAST" || Value == "WEST" ) {
						sheetObj.SetCellValue(Row,"bkg_pol_def_cd",Value,0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
						sheetObj.SetCellValue(Row, "bkg_pol_def_cd",arrData[0],0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
  					}else{
	  					sheetObj.SetCellValue(Row,"bkg_pol_def_cd","",0);
	  					sheetObj.SetCellValue(Row,"bkg_pol_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"bkg_pol_def_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.SetCellValue(Row, "bkg_pol_def_cd","",0);
  					sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","",0);
  					sheetObj.SelectCell(Row, "bkg_pol_def_cd");
	    		}
	    		sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd", 0);
	    		break;	
			case "bkg_pod_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value=COMMAND24;
	    			formObj.cd.value=Value;
	    			var sParam=FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_SG;
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
	  				if(Value == "EAST" || Value == "WEST" ) {
						sheetObj.SetCellValue(Row,"bkg_pod_def_cd",Value,0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
						sheetObj.SetCellValue(Row, "bkg_pod_def_cd",arrData[0],0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
  					}else{
	  					sheetObj.SetCellValue(Row,"bkg_pod_def_cd","",0);
	  					sheetObj.SetCellValue(Row,"bkg_pod_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"bkg_pod_def_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.SetCellValue(Row, "bkg_pod_def_cd","",0);
  					sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","",0);
  					sheetObj.SelectCell(Row, "bkg_pod_def_cd");
	    		}
	    		sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd", 0);
	    		break;	
			case "bkg_del_def_cd":	    		
	    		if (Value.length > 1){
	    			formObj.f_cmd.value=COMMAND24;
	    			formObj.cd.value=Value;
	    			var sParam=FormQueryString(formObj);
	    			sParam += "&etc1="+PRI_SG;
 	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
	  				if(Value == "EAST" || Value == "WEST" ) {
						sheetObj.SetCellValue(Row,"bkg_del_def_cd",Value,0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
					} else if (arrData != null && arrData.length > 0) {
						sheetObj.SetCellValue(Row, "bkg_del_def_cd",arrData[0],0);
						getLocationTypeCode(sheetObj, Row, Col, Value.length);
  					}else{
	  					sheetObj.SetCellValue(Row,"bkg_del_def_cd","",0);
	  					sheetObj.SetCellValue(Row,"bkg_del_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"bkg_del_def_cd");
  					}	  				
	    		}else{	 	
  					sheetObj.SetCellValue(Row, "bkg_del_def_cd","",0);
  					sheetObj.SetCellValue(Row, "bkg_del_tp_cd","",0);
  					sheetObj.SelectCell(Row, "bkg_del_def_cd");
	    		}
	    		sheetObj.SetCellBackColor(Row,"bkg_del_def_cd", 0);
	    		break;	
			case "rt_appl_tp_cd":	
				var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
				var rtOpCd=sheetObj.GetCellValue(Row, "rt_op_cd");
				if(Value == "A" || Value == "F") {
 					sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 					sheetObj.SetCellValue(Row, "curr_cd","USD",0);
 					sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 					sheetObj.SetCellEditable(Row, "rt_op_cd",1);
					sheetObj.SetCellEditable(Row, "curr_cd",1);
					sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 				} else {
 					sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 					sheetObj.SetCellValue(Row, "curr_cd","",0);
 					sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 					sheetObj.SetCellEditable(Row, "curr_cd",0);
 					sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 				}
				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
			 		&& chgRuleDefCd != "RAC" ) {
 					if( Value == "F") {
 						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 					}
 					if( Value == "A") {
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 					}
	    		} else if(chgRuleDefCd == "ADD" || chgRuleDefCd == "ARB") {
	    			if (Value == "I" || Value == "A"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 	    			} else if (Value == "S" || Value == "N"){
 						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 					} else {
 						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",1);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 						sheetObj.SetCellValue(Row, "curr_cd","USD",0);
 						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 					}
 	    		} else if(chgRuleDefCd == "TYP") {
 	    			if (Value == "A"){ 	    	    				
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 						sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
 	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 	    			} else if (Value == "N"){ 	    	    				
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 	    			} else {
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
 	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 	    			}
 	    		} 
	    		break;
			case "rt_op_cd":
				var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
				var rtApplTpCd=sheetObj.GetCellValue(Row, "rt_appl_tp_cd");
				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
			 		&& chgRuleDefCd != "RAC" ) {
					if( rtApplTpCd == "F") {
			    		if(Value == ">" || Value == "<" ) {
			    			ComShowCodeMessage("PRI00326");
			    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
			    			sheetObj.SelectCell(Row, "rt_op_cd");
			    		}
		    		}
				} else if(chgRuleDefCd == "TYP") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 	    		}
	    		break;	
			case "bkg_prc_cgo_tp_cd": 	
				var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
				if(chgRuleDefCd == "APP"){
					if(Value != "DG") {
						ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
						sheetObj.SetCellValue(Row, "bkg_prc_cgo_tp_cd","",0);
					}
				}
				if(Value == "DG") {
					sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",1);
				} else {
					sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",0);
					sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
				}
				break;	
			case "bkg_imdg_clss_cd":
 				if (Value.length > 0){
 	    			formObj.f_cmd.value=COMMAND30;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 	  				if (arrData != null && arrData.length > 0) {
 						sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd",arrData[0],0);
   					}else{
 	  					sheetObj.SetCellValue(Row,"bkg_imdg_clss_cd","",0);
 	  					sheetObj.SelectCell(Row,"bkg_imdg_clss_cd");
   					}	  				
 	    		}else{	 	
   					sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
   					sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");
 	    		}
 	    		break;
			case "curr_cd":
				var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 				if(chgRuleDefCd == "ARB" || chgRuleDefCd == "ADD"){
	 				if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOR"){
	 					ComShowCodeMessage("PRI01074","USD, EUR, GBP, INR, NOR");
	 					sheetObj.SetCellValue(Row, "curr_cd","USD",0);
	 					sheetObj.SelectCell(Row, "curr_cd");
	 	    		}
 				}
 	    		break;
    	}
	}
  	/**
 	 * Setting route's type code when inputting route's item<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory Onclick ,Cell's Column Index
     * @param {int} Len Mandatory ,Cell's Value Length
 	 * @return N/A
 	 * @author 
 	 * @version 2009.07.15
 	 */ 
    function getLocationTypeCode(sheetObj, Row, Col, Len) {
    	var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		switch(colName)
    	{
			case "bkg_por_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","L",0);
		    	} else if(Len == 2) {
		    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","C",0);
		    	} else if(Len == 3) {
		    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","R",0);
		    	} 
		    	break;
			case "bkg_pol_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","L",0);
		    	} else if(Len == 2) {
		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","C",0);
		    	} else if(Len == 3) {
		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","R",0);
		    	} 
		    	break;
			case "bkg_pod_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","L",0);
		    	} else if(Len == 2) {
		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","C",0);
		    	} else if(Len == 3) {
		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","R",0);
		    	} 
		    	break;
			case "bkg_del_def_cd":		
		    	if(Len == 5) {
		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","L",0);
		    	} else if(Len == 2) {
		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","C",0);
		    	} else if(Len == 3) {
		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","R",0);
		    	} 
		    	break;
    	}
    }
 	/**
	 * Duration's Validation function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @return N/A
	 * @author 
	 * @version 2009.07.15
	 */
    function checkDuration(sheetObj) {
		var formObj=document.form;
		var rowCount = sheetObj.RowCount();
		var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
		var expDt=ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
		if(rowCount > 0){
			for(var i=1; i<=rowCount; i++) {
				if (sheetObj.GetRowStatus(i) == "D") {
					continue;
				}
				if(sheetObj.GetCellValue(i, "eff_dt") < effDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.SetCellValue(i, "eff_dt",effDt,0);
					sheetObj.SelectCell(i, "eff_dt");
					return false;
				}
				if(sheetObj.GetCellValue(i, "eff_dt") > sheetObj.GetCellValue(i, "exp_dt")  && (sheetObj.GetCellValue(i, "exp_dt") != "")){
					ComShowCodeMessage("PRI00306");
					sheetObj.SetCellValue(i, "eff_dt",effDt,0);
					sheetObj.SetCellValue(i, "exp_dt",getExpDtNull(),0);
					sheetObj.SelectCell(i, "eff_dt");
					return false;
				}
				if(sheetObj.GetCellValue(i, "exp_dt") > expDt && sheetObj.GetCellValue(i, "exp_dt") != "99991231") {
					ComShowCodeMessage("PRI08016");
					sheetObj.SetCellValue(i, "exp_dt",getExpDtNull(),0);
					sheetObj.SelectCell(i, "exp_dt");
					return false;
				}
			}
		}
		return true;
    }
     /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,process constant variable
     * @returns bool <br>
     *          true  : Valid<br>
     *          false : Invalid
     * @author 
     * @version 2009.04.17
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
  		case IBSAVE:
			if (!sheetObj.IsDataModified()) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
  			if(!checkDuration(sheetObj)) {
   				return false;
   			}
  			if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
				return false;
			}
	  		for(var i = sheetObj.HeaderRows(); getValidRowCount(sheetObj) > 0 && i <= sheetObj.LastRow(); i++) {
	  	 		//Don't check in case of deleted data
	  			if(sheetObj.GetRowStatus(i) == "D") {
	  	 			continue;
	  	 		}
	  			if(!checkMandatoryValidation(sheetObj, i)) {
	  				return false;
	  			}
	  		}
  			if (sheetObj.IsDataModified()) {
				//duplication check
				if(!validateDupCheck(sheetObj)) {
					 return false;
				}
			}
			break;
  		case IBCOPYROW:
  			if(!checkDuration(sheetObj)) {
   				return false;
   			}
  			if(sheetObj.RowCount() > 0) {
  				//mandatory check
				if(!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
 					return false;
 				}
  			}
			break;
  		case IBINSERT:
  			if(sheetObj.RowCount() > 0) {
  				//mandatory check
				if(!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
 					return false;
 				}
  			}
			break;	  			
		case COMMAND01:
			var iCheckRow=sheetObj.FindCheckedRow("chk");
			if(iCheckRow == "") {
				ComShowCodeMessage("PRI00327");
				return false;
			}
			break;
		case COMMAND02:
			break;
		}
		return true;
	}
 	/**
 	 * function to check SHEET ROW's duplication <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * validateDupCheck(sheetObj)
 	 * </pre>
 	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 	 * @return boolean
 	 * @author 
 	 * @version 2009.05.20
 	 */ 
 	function validateDupCheck(sheetObj) {
 		var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|rule_appl_chg_tp_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
			 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_scg_grp_cmdt_cd|bkg_usa_svc_mod_cd|bkg_rcv_term_cd|bkg_de_term_cd" +
			 		"|bkg_por_def_cd|bkg_pol_def_cd|bkg_pod_def_cd|bkg_del_def_cd", false, true);
 		if (rowM != "") {
 			var rowDup=rowM.replace("|", ","); 			
 			//all duplicated row
 			var rowArr=rowDup.split(",");
 			var dupValue="";
 			var temValue="";						
 			var firstEffDt="";
 			var firstExpDt="";						
 			var SecondEffDt="";
 			var SecondExpDt="";
 			var hrows=sheetObj.HeaderRows();
 			for(var i=0; i<rowArr.length; i++) {
 				dupValue=sheetObj.GetCellValue(rowArr[i], "chg_rule_def_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "rule_appl_chg_tp_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_rat_ut_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_prc_cgo_tp_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_imdg_clss_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_cmdt_def_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_scg_grp_cmdt_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_usa_svc_mod_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_rcv_term_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_de_term_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_por_def_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pol_def_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pod_def_cd");
 				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_del_def_cd");
 				for(var j=0; j<rowArr.length; j++) {
 					temValue=sheetObj.GetCellValue(rowArr[j], "chg_rule_def_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "rule_appl_chg_tp_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_rat_ut_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_prc_cgo_tp_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_imdg_clss_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_cmdt_def_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_scg_grp_cmdt_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_usa_svc_mod_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_rcv_term_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_de_term_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_por_def_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pol_def_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pod_def_cd");
 					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_del_def_cd");
 					if(i != j) {
	 					if(dupValue == temValue) {
	 						firstEffDt=sheetObj.GetCellValue(rowArr[i], "eff_dt");
	 						firstExpDt=sheetObj.GetCellValue(rowArr[i], "exp_dt");
	 						SecondEffDt=sheetObj.GetCellValue(rowArr[j], "eff_dt");
	 						SecondExpDt=sheetObj.GetCellValue(rowArr[j], "exp_dt");
	 						if(firstExpDt == "") {
	 							firstExpDt="99991231";
	 						}
	 						if(SecondExpDt == "") {
	 							SecondExpDt="99991231";
	 						}
	 						if(firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
	 							ComShowCodeMessage("PRI00303", "Sheet", Number(rowArr[j])+1-hrows);
	 						     return false;
	 			 			}
	 			 			if(firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
	 			 				ComShowCodeMessage("PRI00303", "Sheet", Number(rowArr[j])+1-hrows);
	 						     return false;
	 			 			}
	 					} //if
 					} //if
 				} //for
 			} //for
 		} //if
 		return true;
 	}
	/**
	 * calling function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */ 
	function sheet1_OnSaveEnd(sheetObj, code, errMsg){
		if(errMsg == "") {
	 		var formObj=document.form;
	 		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	 			if(sheetObj.GetCellValue(i,"exp_dt") == "99991231") {
	 				var prevStatus=sheetObj.GetRowStatus(i);
	 				sheetObj.SetCellValue(i,"exp_dt","",0);
					sheetObj.SetRowStatus(i,prevStatus);
	 			}
	 			disableColumnValidation(sheetObj, i, "", sheetObj.GetCellValue(i,"chg_rule_def_cd"));
		 		//Setting state color
		 		setStateColor(sheetObj, i);
		 		//setting color to Rule Code
		 		//setChargeRuleColor(sheetObj, i);
	 		}
 		}
	}
	 /**
     * Calling function in case of OnClick event <br>
     * Calling calendar DIV<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index
     * @param {str} Value Mandatory
     * @return N/A
     * @author 
     * @version 2009.06.18
     */
     function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
 	    var colname=sheetObj.ColSaveName(Col);
 	    var formObj=document.form;
 	    var pinkColor="#FFC0CB";
      	switch(colname)
      	{
  	    	case "eff_dt":
  	    		cal=new ComCalendarGrid();
  	    		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
  	    		break;
  	    	case "exp_dt":
  	    		cal=new ComCalendarGrid();
  	    		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
  	    		break;
  	    	case "bkg_cmdt_def_cd":	
  	  			var sUrl="/opuscntr/ESM_PRI_4027.do?commodity_cmd=C";
  	  			ComOpenPopup(sUrl, 700, 330, "findCommodity", "1,0,1,1,1,1,1", false);
  	  			break;
  	    	case "bkg_por_def_cd":	
  				var sUrl="/opuscntr/ESM_PRI_4026.do?";
  				var sParam="&location_cmd=LTCR";
  				ComOpenPopup(sUrl+sParam, 700, 310, "findLocation_por", "1,0,1,1,1,1,1", false);
  				break;
  	    	case "bkg_pol_def_cd":	
  				var sUrl="/opuscntr/ESM_PRI_4026.do?";
  				var sParam="&location_cmd=LTCR";
  				ComOpenPopup(sUrl+sParam, 700, 310, "findLocation_pol", "1,0,1,1,1,1,1", false);
  				break;
  	    	case "bkg_pod_def_cd":	
  				var sUrl="/opuscntr/ESM_PRI_4026.do?";
  				var sParam="&location_cmd=LTCR";
  				ComOpenPopup(sUrl+sParam, 700, 310, "findLocation_pod", "1,0,1,1,1,1,1", false);
  				break;
  	    	case "bkg_del_def_cd":	
  				var sUrl="/opuscntr/ESM_PRI_4026.do?";
  				var sParam="&location_cmd=LTCR";
  				ComOpenPopup(sUrl+sParam, 700, 310, "findLocation_del", "1,0,1,1,1,1,1", false);
  				break;
      	}    	 
     }
     
     function findCommodity(rtnVal) {
    	 sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
    	 sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_cmdt_tp_cd",'C',0);
     }
     
     function findLocation_por(rtnVal) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_por_tp_cd",rtnVal.tp,0);
			//setting pink color to background in case of State
			if(rtnVal.tp == "T"){
  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_por_cnt_cd",rtnVal.cnt_cd,0);
				sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_por_def_cd",pinkColor);
			} else {
				sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_por_def_cd",0);
			}
    }
     function findLocation_pol(rtnVal) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pol_tp_cd",rtnVal.tp,0);
		//setting pink color to background in case of State
		if(rtnVal.tp == "T"){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pol_cnt_cd",rtnVal.cnt_cd,0);
			sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_pol_def_cd",pinkColor);
		} else {
			sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_pol_def_cd",0);
		}
     }
     function findLocation_pod(rtnVal) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pod_tp_cd",rtnVal.tp,0);
		//setting pink color to background in case of State
		if(rtnVal.tp == "T"){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_pod_cnt_cd",rtnVal.cnt_cd,0);
			sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_pod_def_cd",pinkColor);
		} else {
			sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_pod_def_cd",0);
		}
     }
     function findLocation_del(rtnVal) {
    	 sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_del_tp_cd",rtnVal.tp,0);
		//setting pink color to background in case of State
		if(rtnVal.tp == "T"){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bkg_del_cnt_cd",rtnVal.cnt_cd,0);
			sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_del_def_cd",pinkColor);
		} else {
			sheetObj.SetCellBackColor(sheetObj.GetSelectRow(),"bkg_del_def_cd",0);
		}
     }
     /**
      * CODE항목 Selection시 CODE값에 따라 수정가능한 항목을 체크하는 function <br>
      * 
      * <br><b>Example :</b>
      * <pre>
      *	disableColumnValidation(sheetObj, Row, Col, Value);
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {int} Row Mandatory OnClick ,Cell's Row Index
      * @param {int} Col Mandatory OnClick ,Cell's Column Index 변경된 값
      * @param {str} Value Mandatory Format이 적용되지 않은 저장 시 사용되는 값 
      * @return N/A
      * @author 
      * @version 2009.07.02
      */           
     function disableColumnValidation(sheetObj, Row, Col, Value) {
    	initColumnEditable(sheetObj, Row, Col, Value);
		switch(Value)
    	{
			case "ARB":	
				//sheetObj.CellEditable(Row, "rt_op_cd") 			= false;
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S"
					|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I"
						|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
					sheetObj.SetCellEditable(Row, "curr_cd",0);
					sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
					sheetObj.SetCellEditable(Row, "curr_cd",0);
				}
				break;
			case "ADD":
				//sheetObj.CellEditable(Row, "rt_op_cd") 			= false;
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S"
					|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I"
						|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
					sheetObj.SetCellEditable(Row, "curr_cd",0);
					sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
					sheetObj.SetCellEditable(Row, "curr_cd",0);
				}
				break;
			case "TYP":
				//sheetObj.CellEditable(Row, "rt_appl_tp_cd") 		= false;
				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",1);
				//sheetObj.CellEditable(Row, "conv_prc_cgo_tp_cd") 	= true;			
				break;
 			case "RAC":	
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
				break;
			default:
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S"
					|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I"
						|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
					sheetObj.SetCellEditable(Row, "curr_cd",0);
					sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
					sheetObj.SetCellEditable(Row, "curr_cd",0);
				}
				break;
    	}
 	}
      /**
       * SHEET에 보이는 항목들을 EDITABLE 초기화하는 function <br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	initColumnEditable(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj Mandatory IBSheet Object
       * @param {int} Row Mandatory OnClick ,Cell's Row Index
       * @param {int} Col Mandatory OnClick ,Cell's Column Index 변경된 값
       * @param {str} Value Mandatory Format이 적용되지 않은 저장 시 사용되는 값 
       * @return N/A
       * @author 
       * @version 2009.07.02
       */           
      function initColumnEditable(sheetObj, Row, Col, Value) {
   	   	//sheetObj.RowEditable(Row) = true;
   	   	sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_rat_ut_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_prc_cgo_tp_cd",1);
   	   	sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",1);
   	   	if(sheetObj.GetCellValue(Row, "bkg_prc_cgo_tp_cd") == "DG") {
	   		sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",1);
	   	} else {
	   		sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",0);
	   	}
		sheetObj.SetCellEditable(Row, "rt_op_cd",1);
		sheetObj.SetCellEditable(Row, "curr_cd",1);
		sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
		sheetObj.SetCellEditable(Row, "pay_term_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_cmdt_def_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_usa_svc_mod_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_rcv_term_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_de_term_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_por_def_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_pol_def_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_pod_def_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_del_def_cd",1);
		sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",1);
		sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",1);
  	}
   /**
    * CODE항목 Selection시 CODE TYPE에 따라 Mandatory 컬럼을 체크하는 function <br>
    * 
    * <br><b>Example :</b>
    * <pre>
    *	checkMandatoryValidation(sheetObj, Row);
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory OnClick ,Cell's Row Index
    * @return N/A
    * @author 
    * @version 2009.07.02
    */ 	
 	function checkMandatoryValidation(sheetObj, Row) {
 		var rowCount = sheetObj.RowCount(); 		
 		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
	 		&& chgRuleDefCd != "RAC" ) {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			}  else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001 && (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F")) {
 				//Application 이 Fixed Amount, Adjust 로 지정될 경우는 Amount 가 Mandatory입력항목 지정.(7/21)
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
	 			// SURCHARGE CODE 입력시, APPLICATION이 FIXED AMOUNT 또는 ADJUST 일 경우
	 			// BKG SOURCE부분의 PER를 Mandatory 입력 항목 변경 요청 - 2009.11.09
				if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
 			}
		} else if (chgRuleDefCd == "APP") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} 
		} else if (chgRuleDefCd == "ARB") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "ADD") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} 
 		} else if (chgRuleDefCd == "TYP") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
 				ComShowCodeMessage("PRI00316","Per");
 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rule_appl_chg_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Type");
 				sheetObj.SelectCell(Row, "rule_appl_chg_tp_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "conv_rat_ut_cd") == "") {
 				ComShowCodeMessage("PRI00316","Per (in S/C)"); 
 				sheetObj.SelectCell(Row, "conv_rat_ut_cd");
 				return false;
 			}
		} else if (chgRuleDefCd == "RAC") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cargo Type");
 				sheetObj.SelectCell(Row, "bkg_prc_cgo_tp_cd");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "" ) {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "conv_prc_cgo_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cargo Type (in S/C)"); 
 				sheetObj.SelectCell(Row, "conv_prc_cgo_tp_cd");
 				return false;
 			}
 		} 
		return true;
 	}
    /**
     * CODE항목 Selection시 CODE TYPE에 따라 컬럼항목 DEFAULT 처리하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	defaultColumnValidation(sheetObj, Row, Col, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 변경된 값
     * @param {str} Value Mandatory Format이 적용되지 않은 저장 시 사용되는 값 
     * @return N/A
     * @author 
     * @version 2009.07.02
     */ 	
 	function defaultColumnValidation(sheetObj, Row, Col, Value) {
    	initColumnValue(sheetObj, Row);
		switch(Value)
    	{	
			case "TYP":
				sheetObj.SetCellValue(Row, "curr_cd","",0);
				sheetObj.SetCellValue(Row, "bkg_rat_ut_cd","D4",0);
				sheetObj.SetCellValue(Row, "conv_rat_ut_cd","D4",0);
				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
				sheetObj.SetCellValue(Row, "rule_appl_chg_tp_cd","O",0);
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
				break;
			case "ARB":
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 				break;
 			case "ADD":
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 				break;
 			case "RAC":
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				break;
			default:
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 				break;
    	}
 	}
     /**
      * 데이터를 초기화하는 function <br>
      * 
      * <br><b>Example :</b>
      * <pre>
      *	defaultColumnValidation(sheetObj, Row, Col, Value);
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {int} Row Mandatory OnClick ,Cell's Row Index
      * @return N/A
      * @author 
      * @version 2009.07.02
      */ 	
  	function initColumnValue(sheetObj, Row) { 	 		
    	 sheetObj.SetCellValue(Row, "rule_appl_chg_tp_cd","",0);
     	 sheetObj.SetCellValue(Row, "rt_appl_tp_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_rat_ut_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_prc_cgo_tp_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
     	 sheetObj.SetCellValue(Row, "curr_cd","",0);
     	 sheetObj.SetCellValue(Row, "rt_op_cd","",0);
     	 sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
     	 sheetObj.SetCellValue(Row, "pay_term_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_cmdt_def_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_scg_grp_cmdt_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_usa_svc_mod_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_rcv_term_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_de_term_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_por_def_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_pol_def_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_pod_def_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_del_def_cd","",0);
     	 sheetObj.SetCellValue(Row, "conv_rat_ut_cd","",0);
     	 sheetObj.SetCellValue(Row, "conv_prc_cgo_tp_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_por_tp_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_del_tp_cd","",0);
  	}
    /**
     * SHEET ROW를 멀티 복사하는 function <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	copySheetData(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2010.03.23
     */	
 	function copySheetData(sheetObj) {
  		//SHEET를 LOAD한 후에 기본 값을 세팅한다.
  		var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;  
  		var sCheckRow=sheetObj.FindCheckedRow("chk");
		if(sCheckRow == ""){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
		}
		sCheckRow=sheetObj.FindCheckedRow("chk");
 		var aCheckArr=ComRtrim(sCheckRow, '|').split("|");
 		if(aCheckArr != null && aCheckArr.length > 0) {
 			for(var i=aCheckArr.length-1; i>=0; i--) {
 				sheetObj.SetSelectRow(aCheckArr[i]);
 				var idx=sheetObj.DataCopy();
      			sheetObj.SetCellValue(idx, "note_conv_seq",maxSeq,0);
      			sheetObj.SetCellValue(idx, "chk",0,0);
      			// State 색 구분
      			setStateColor(sheetObj, idx);
      			// Rule & Charge Code 색 구분
      			//setChargeRuleColor(sheetObj, idx);
      			maxSeq++;
 			}
 		}
 	}
	/**
     * CODE COMBO Selection시 CHARGE RULE TYPE에 따라 데이터를 분기하는 function <br>
     * RULE코드를 Selection하면 CHG_RULE_TP_CD:C 이고 NOTE_CONV_RULE_CD에 코드값등록  <br>
     * CHARGE코드를 Selection하면 CHG_RULE_TP_CD:R 이고 NOTE_CONV_CHG_CD에 코드값등록  <br>
     * <br><b>Example :</b>
     * <pre>
     *	insertChargeRuleType(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @return N/A
     * @author 
     * @version 2009.07.02
     */	
	function insertChargeRuleType(sheetObj, Row) {
		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
	 		&& chgRuleDefCd != "RAC" ) {
			//CHARGE
			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","C",0);
			sheetObj.SetCellValue(Row, "note_conv_chg_cd",chgRuleDefCd,0);
			sheetObj.SetCellValue(Row, "note_conv_rule_cd","",0);
		} else {
			//RULE
			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","R",0);
			sheetObj.SetCellValue(Row, "note_conv_rule_cd",chgRuleDefCd,0);
			sheetObj.SetCellValue(Row, "note_conv_chg_cd","",0);
		}
	}
  	/**
  	 * Route 에 State 코드일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setStateColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object 의 Row Index
  	 * @return N/A
  	 * @author 
  	 * @version 2009.07.09
  	 */ 
 	function setStateColor(sheetObj, Row) {
 		// State 색 구분
 		var pinkColor="#FFC0CB";
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
  	 * Code 가 Rule Code 일 경우에는 색상을 지정하는 function <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setChargeRuleColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object 의 Row Index
  	 * @return N/A
  	 * @author 
  	 * @version 2009.07.09
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// Rule & Charge Code 색 구분
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
   	 function getExpDtNull() {
   		 var formObj=document.form;
   		 var expDt=formObj.exp_dt.value;
   		 if(expDt == "9999-12-31" || expDt == "99991231") {
   			expDt="";
   		 }
   		 return expDt;
   	 }
