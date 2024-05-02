/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3005.js
*@FileTitle  : Tariff Fomula Rule Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
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
     * @class ESM_PRI_3005 : Business Script for ESM_PRI_3005
     */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	//Visible item list in combo
	var sChgCdVisiable="";
	// Note Conversion type Code
	var NOTE_CONV_TP_CD="F";	//Formula NOTE
	// Copy 
	var isCopy=false;		
	// Privilege of Author
	var AUTH_YN="0";
	var selectedGlineSeq=null;
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
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			
			switch (srcName) {
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCREATE);
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
				case "btn_rowdelete":
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
				case "btn_confirm":
					if(validateForm(sheetObject1,formObject,MODIFY01)) {
						doActionIBSheet(sheetObject1,formObject,MODIFY01);
					}
					break;
				case "btn_confirmcancel":
					if(validateForm(sheetObject1,formObject,MODIFY02)) {
						doActionIBSheet(sheetObject1,formObject,MODIFY02);
					}
					break;
				case "btn_delete":
					if(validateForm(sheetObject1,formObject,MODIFY03)) {
						doActionIBSheet(sheetObject1,formObject,MODIFY03);
					}
					break;
				case "btn_copy":
					if(validateForm(sheetObject1,formObject,MODIFY04)) {
						doActionIBSheet(sheetObject1,formObject,MODIFY04);
					}
					break;
	            case "btns_calendar": //Calendar Button
	    			if (comboObjects[0].GetSelectCode()== "") {
	    				ComShowCodeMessage('PRI08002');
	    				return false;
	    			}
	                var cal=new ComCalendarFromTo('novalidaterform');
	                //cal.select(formObject.eff_dt_hidden, formObject.exp_dt, 'yyyy-MM-dd');
	                cal.select(formObject.note_seq_text, formObject.exp_dt, 'yyyy-MM-dd');
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
	*     setComboObject(comboObj);
	* </pre>
	* @param {ibcombo} combo_obj Mandatory IBCombo Object
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
		axon_event.addListenerForm('focus', 'obj_activate',   document.form);			//beforeactivate
		axon_event.addListenerForm('blur',  'obj_deactivate', document.form);
		axon_event.addListener('keyup', 'exp_dt_OnKeyup', "exp_dt");
		toggleButtons("CLEAR");
	    ComPriTextCode2ComboItem(srchTrfCdComboValue, srchTrfCdComboText, getComboObject(comboObjects, 'srch_trf_cd') ,"|","\t" );
	    srch_trf_cd.InsertItem(0, "","");
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
		var sheetID=sheetObj.id;
     	switch(sheetID) {
         	case "sheet1":
				with(sheetObj){
					var HeadTitle="|Sel.|Code|Actual\nEffective Date|Actual\nExpiration Date|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" + "|Pay Term|Commodity|US SVC Mode|POR|POL|POD|DEL" + "|Receiving\nTerm|Delivery\nTerm" + "|Type|Per\n(in Tariff)|Cargo Type\n(in Tariff)" + "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19";
					var headCount=ComCountHeadTitle(HeadTitle);
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"DummyCheck",Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
					 {Type:"Combo", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_usa_svc_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 },
					 {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 },
					 {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 },
					 {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"E", InputCaseSensitive:1 },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rule_appl_chg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"conv_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"conv_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"tri_prop_no" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_cnt_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_cnt_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_cnt_cd" },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_cnt_cd" } ];
					   
					InitColumns(cols);
					resizeSheet(); //SetSheetHeight(250);
					SetEditable(1);
					SetImageList(0,"img/btns_calendar.gif");
					SetWaitImageVisible(0);
					SetColProperty(0 ,"bkg_por_def_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
					SetColProperty(0 ,"bkg_pol_def_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
					SetColProperty(0 ,"bkg_pod_def_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
					SetColProperty(0 ,"bkg_del_def_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
					SetColProperty("rule_appl_chg_tp_cd", {ComboText:ruleApplChgTpCdComboText, ComboCode:ruleApplChgTpCdComboValue} );
					SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
					SetColProperty("bkg_prc_cgo_tp_cd", {ComboText:bkgPrcCgoTpCdComboText, ComboCode:bkgPrcCgoTpCdComboValue} );
					SetColProperty("rt_op_cd", {ComboText:rtOpCdComboText, ComboCode:rtOpCdComboValue} );
					SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
					SetColProperty("bkg_usa_svc_mod_cd", {ComboText:bkgUsaSvcModCdComboText, ComboCode:bkgUsaSvcModCdComboValue} );
					SetColProperty("bkg_rat_ut_cd", {ComboText:bkgRatUtCdComboText, ComboCode:bkgRatUtCdComboValue} );
					SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
					SetColProperty("conv_rat_ut_cd", {ComboText:convRatUtCdComboText, ComboCode:convRatUtCdComboValue} );
					SetColProperty("conv_prc_cgo_tp_cd", {ComboText:convPrcCgoTpCdComboText, ComboCode:convPrcCgoTpCdComboValue} );
					SetColProperty("bkg_rcv_term_cd", {ComboText:bkgRcvTermCdComboText, ComboCode:bkgRcvTermCdComboValue} );
					SetColProperty("bkg_de_term_cd", {ComboText:bkgDeTermCdComboText, ComboCode:bkgDeTermCdComboValue} );
					SetShowButtonImage(2);
				}
              	break;
     	}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
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
		with(comboObj) {
			comboObj.SetMultiSelect(false);
			comboObj.SetMaxSelect(true);
			SetUseAutoComplete(true);
			switch(comboObj.options.id) {
				case "srch_trf_cd":
					SetDropHeight(260);
					SetMaxLength(8);
					ValidChar(2,3);
				    break;
				case "note_seq":
					SetDropHeight(260);
					SetUseEdit(true);
					SetColWidth(0, "80");
					SetColWidth(1, "100");
					SetColWidth(2, "0");
					break;
			}
			
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
 		try {
	 		sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {
				case IBSEARCH_ASYNC01: // When Service Scope selected, retrieve Duration
					formObj.f_cmd.value=SEARCH02;
					var sXml=sheetObj.GetSearchData("ESM_PRI_3005GS.do", FormQueryString(formObj));
					
					//sheetObj.RemoveAll();
					comboObjects[1].RemoveAll();
					comboObjects[1].InsertItem(0, "||", "X");
					comboObjects[1].SetSelectIndex(0);
					ComPriXml2ComboItem(sXml, note_seq, "note_seq", "eff_dt|exp_dt|eff_dt", false);
	 				//initCombo(note_seq, 1);
					// Check whether authority information is exist on SERVICE SCOPE 
					AUTH_YN=ComGetEtcData(sXml,"AUTH_YN");
					if(AUTH_YN > 0){
						toggleButtons("NEW");
					} else {
						toggleButtons("CLEAR");
					}
					break;
				case IBSEARCH_ASYNC02: // Setting Info after Duration select 
	  				ComOpenWait(true);
					formObj.f_cmd.value=SEARCH02;
					var sParam=FormQueryString(formObj);
					sParam += "&note_seq=" + selectedGlineSeq;
					var sXml=sheetObj.GetSearchData("ESM_PRI_3005GS.do", sParam);
					var arrData=ComPriXml2Array(sXml, "note_conv_mapg_id|cfm_flg");
					formObj.note_conv_mapg_id.value=arrData[0][0];
		 			formObj.cfm_flg.value=arrData[0][1];	
		 			getConfirmName(arrData[0][1]);	
		 	 		doActionIBSheet(sheetObj, document.form, IBSEARCH);
					break;
	 			case IBSEARCH: // retrieving
	  				ComOpenWait(true);
		 			// NOTE CONVERSION RULE
					var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			////////////////////////////////////////////////////////////////////////////////	
		 			formObj.f_cmd.value=SEARCH01;
		 			var sXml=sheetObj.GetSearchData("ESM_PRI_3005GS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd");			
					if (arrData != null && arrData.length > 0) {
						for(var i=0; i<arrData.length; i++){						
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}					
						sheetObj.SetColProperty(2, {ComboText:sNm , ComboCode:sCd} );
					}
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					isCopy=false;
	 				break;
	 			case IBCREATE: // New
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					comboObjects[0].SetSelectCode('-1',false);
					formObj.srch_trf_nm.value="";
					comboObjects[1].RemoveAll();
					sheetObj.RemoveAll();
					toggleButtons("CLEAR");
					break;
	 			case IBSAVE: // Save
		 			if(isCopy) {
			 			if (!ComShowCodeConfirm('PRI00012')) {
							return false;
						}
		  				ComOpenWait(true);			
		 				// Creation
		 				if(comboObjects[1].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "X"){
		 					formObj.note_conv_mapg_id.value=getSYSGUID();
		 				}
	 					for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	 						sheetObj.SetCellValue(i, "note_conv_mapg_id",formObj.note_conv_mapg_id.value,0);
	 						sheetObj.SetCellValue(i, "trf_pfx_cd",formObj.trf_pfx_cd.value,0);
	 						sheetObj.SetCellValue(i, "trf_no",formObj.trf_no.value,0);
	 						if(sheetObj.GetRowStatus(i) != "D") {
	 							sheetObj.SetRowStatus(i,"I");
	 						}
	 					}
		 				formObj.f_cmd.value=MULTI02;
		 				var sParam=FormQueryString(formObj);
		 				var sParamSheet=sheetObj.GetSaveString();
		  				if (sParamSheet != "") {
		  					sParam += "&" + ComPriSetPrifix(sParamSheet, "sheet1_");
		  				}
		 			} else {
		 				if (!ComPriConfirmSave()) {
							return false;
						}
		  				ComOpenWait(true);
		 				// Create Mapping ID
		 				if(comboObjects[1].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "X"){
		 					formObj.note_conv_mapg_id.value=getSYSGUID();	 						 					
		 					for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		 						sheetObj.SetCellValue(i, "note_conv_mapg_id",formObj.note_conv_mapg_id.value,0);
		 					}
		 				}
		 				formObj.f_cmd.value=MULTI01;
		 				var sParam=FormQueryString(formObj);
						sParam += "&note_seq=" + comboObjects[1].GetSelectCode();
		 				var sParamSheet=sheetObj.GetSaveString();
		  				if (sParamSheet != "") {
		  					sParam += "&" + ComPriSetPrifix(sParamSheet, "sheet1_");
		  				}
		 			}
		 			var sXml=sheetObj.GetSaveData("ESM_PRI_3005GS.do", sParam);
		 			sheetObj.LoadSaveData(sXml);
	 				isCopy=false; // Initialization
	 				if (sXml.indexOf("ERROR") >= 0) {
	 					return false;
	 				}
	 				var prevEffDt=comboObjects[1].GetSelectText();
	 				note_seq.SetSelectCode("");//Set blank, To get duration List
	 				formObj.f_cmd.value=SEARCH02;
	 				sXml=sheetObj.GetSearchData("ESM_PRI_3005GS.do", FormQueryString(formObj));
	 				ComPriXml2ComboItem(sXml, note_seq, "note_seq", "eff_dt|exp_dt|eff_dt");
	 				// Initialize note_seq combo
	 				initCombo(note_seq, 1);
	 				comboObjects[1].InsertItem(0, "||", "X");
	 				var code=comboObjects[1].FindItem(prevEffDt, 0, false);
	 				if (code == null || code == "" || code == "X") {
	 					comboObjects[1].SetSelectIndex(0);
	 				} else {
	 					note_seq.SetSelectCode(code);//onChange event triggered
	 				}
	 				break;
	 			case IBINSERT: // Row Add
					var idx=sheetObj.DataInsert();
		  			sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value,0);
					sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value,0);
					sheetObj.SetCellValue(idx, "trf_pfx_cd",formObj.trf_pfx_cd.value,0);
					sheetObj.SetCellValue(idx, "tri_prop_no",formObj.tri_prop_no.value,0);
					sheetObj.SetCellValue(idx, "trf_no",formObj.trf_no.value,0);
					sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
					sheetObj.SetCellValue(idx, "note_conv_mapg_id",formObj.note_conv_mapg_id.value,0);
					sheetObj.SetCellValue(idx, "note_conv_tp_cd",NOTE_CONV_TP_CD,0);
					sheetObj.SetCellValue(idx, "note_conv_seq",parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1,0);
					//in case that Code have default value
					defaultColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
					//Editable Setting
					disableColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
					sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
	 				break; 				
				case IBCOPYROW:
					copySheetData(sheetObj);
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
				case MODIFY01: // Confirm	
					if (!ComPriConfirmConfirm()) {
						return false;
					}
	  				ComOpenWait(true);
					formObj.f_cmd.value=MODIFY01;
					var sParam=FormQueryString(formObj);
					sParam += "&note_seq=" + selectedGlineSeq;
					var sXml=sheetObj.GetSaveData("ESM_PRI_3005GS.do", sParam);
					sheetObj.LoadSaveData(sXml);
					getConfirmName("Y");
					doActionIBSheet(sheetObj,document.form,IBSEARCH);
					break;
				case MODIFY02: // Cancel Confirm				
					if (!ComPriConfirmCancelConfirm()) {
						return false;
					}
	  				ComOpenWait(true);
					formObj.f_cmd.value=MODIFY02;
					var sParam=FormQueryString(formObj);
					sParam += "&note_seq=" + selectedGlineSeq;
					var sXml=sheetObj.GetSaveData("ESM_PRI_3005GS.do", sParam);
					sheetObj.LoadSaveData(sXml);
					getConfirmName("N");
					doActionIBSheet(sheetObj,document.form,IBSEARCH);
					break;
				case MODIFY03: // Delete
					if (!ComPriConfirmDeleteAll()) {
						return false;
					}
	  				ComOpenWait(true);
					formObj.f_cmd.value=MODIFY03;
					var sParam=FormQueryString(formObj);
					sParam += "&note_seq=" + comboObjects[1].GetSelectCode();
					var sXml=sheetObj.GetSaveData("ESM_PRI_3005GS.do", sParam);
					sheetObj.LoadSaveData(sXml);
					comboObjects[1].RemoveAll();
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
					break;
				case MODIFY04: // Copy
					isCopy=true;
					selectedGlineSeq=null;
					if(formObj.cfm_flg.value == "Y") {
						for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
							sheetObj.SetRowEditable(i,1);
							disableColumnValidation(sheetObj, i, "", sheetObj.GetCellValue(i,"chg_rule_def_cd"));
				 		}
					}
					note_seq.SetSelectCode("X", false);
					formObj.exp_dt.value="";
					formObj.cfm_flg.value="";
					formObj.cfm_flg_nm.value="";	
					toggleButtons("COPY");
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
     * Calling Function in case of OnChange event <br>
     * showing Description<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.06.25
     */  
 	function sheet1_OnChange(sheetObj, Row, Col, Value) {
     	var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		var effDt=formObj.eff_dt.value;
 		var expDt=formObj.exp_dt.value;
 		switch(colName)
     	{
 			case "chg_rule_def_cd":		
 				if (Value != null && Value != "" && Value.length == 3) {
 					//Handling DEFAULT data
 					defaultColumnValidation(sheetObj, Row, Col, Value);
 					//handling column disable
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
 							sheetObj.SetColProperty("chg_rule_def_cd", {ComboText:sText, ComboCode:sCode} );
 							//ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value); 							
 						} else {
 							sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
 						}
 					}
 					insertChargeRuleType(sheetObj, Row);
 				} else {
 					sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
 				}
 				// defining Rule & Charge Code color
 				//setChargeRuleColor(sheetObj, Row);
 				break;
 			case "eff_dt":	
 				effDt=ComGetDateAdd(effDt, "D", 0, "");
 				if(expDt != "") {
 					expDt=ComGetDateAdd(expDt, "D", 0, "");
 				}
 				if(sheetObj.GetCellValue(Row, "eff_dt") < effDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
 					sheetObj.SelectCell(Row,"eff_dt");
 				}
 				if(sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt") && sheetObj.GetCellValue(Row, "exp_dt") != "" ){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
 					sheetObj.SelectCell(Row,"eff_dt");
 				}
 				break;
 			case "exp_dt":	
 				effDt=ComGetDateAdd(effDt, "D", 0, "");
 				if(expDt != "") {
 					expDt=ComGetDateAdd(expDt, "D", 0, "");
 				}
 				if(sheetObj.GetCellValue(Row, "exp_dt") > expDt && sheetObj.GetCellValue(Row, "exp_dt") != "" ) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.SetCellValue(Row, "exp_dt",expDt,0);
 					sheetObj.SelectCell(Row,"exp_dt");
 				}
 				if(sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt")  && sheetObj.GetCellValue(Row, "exp_dt") != ""){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.SetCellValue(Row, "exp_dt",expDt,0);
 					sheetObj.SelectCell(Row,"exp_dt");
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
 			case "bkg_cmdt_def_cd":	
 				if (Value.length > 0) {
	    			formObj.f_cmd.value=SEARCH08;
	    			//Puting '0' in front of COMMODITY CODE
	    			formObj.cd.value=ComLpad(Value, 6, "0");
	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != "") {
  						sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd",Value,0);
  						//it's commodity code in case of 6 digits
						sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","C",0);
  					}else{
	  					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
	  					sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
  					}
 				} else {
 					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd", "", 0);
 					sheetObj.SetCellValue(Row,"bkg_cmdt_tp_cd", "", 0);
 					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
 				}
 	    		break;
 			case "bkg_por_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value=COMMAND24;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
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
   					sheetObj.SelectCell(Row, "bkg_por_def_cd") ;
 	    		}
 	    		sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",0);
 	    		break;	
 			case "bkg_pol_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value=COMMAND24;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
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
 	    		sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",0);
 	    		break;	
 			case "bkg_pod_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value=COMMAND24;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
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
 	    		sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",0);
 	    		break;	
 			case "bkg_del_def_cd":	    		
 	    		if (Value.length > 1){
 	    			formObj.f_cmd.value=COMMAND24;
 	    			formObj.cd.value=Value;
 	    			var sParam=FormQueryString(formObj);
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
 	    		sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",0);
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
 	    		} else if(chgRuleDefCd == "NOT") {
 	    			if (Value != "I" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","I",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 	    			}
 	    		} else if(chgRuleDefCd == "APP") {
 	    			if (Value != "S" && Value != "N"){ 	   
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 						sheetObj.SetCellValue(Row, "curr_cd","",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
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
 	    			} else {
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
 	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 	    			}
 	    		}
 	    		break;
 			case "rt_op_cd":
 				var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 				var rtApplTpCd=sheetObj.GetCellValue(Row, "rt_appl_tp_cd");
 				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 					&& chgRuleDefCd != "ADD" && chgRuleDefCd != "ARB" && chgRuleDefCd != "NOT"
 	 				&& chgRuleDefCd != "RAC" ) {
 					if( rtApplTpCd == "F") {
 			    		if(Value == ">" || Value == "<" ) {
 			    			ComShowCodeMessage("PRI00326");
 			    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 			    			sheetObj.SelectCell(Row, "rt_op_cd");
 			    		}
 		    		}
 				} else if(chgRuleDefCd == "RAR") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 				} else if(chgRuleDefCd == "RAP") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 	    		} else if(chgRuleDefCd == "DOR") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
 	    		} else if(chgRuleDefCd == "TYP") {
 					if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
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
	 				if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOK"){
	 					ComShowCodeMessage("PRI01074","USD, EUR, GBP, INR, NOK");
	 					sheetObj.SetCellValue(Row, "curr_cd","USD",0);
	 					sheetObj.SelectCell(Row, "curr_cd");
	 	    		}
 				}
 	    		break;
     	}
 	}
  	/**
  	 * Setting route's type code to route <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * 
  	 * </pre>
  	 * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {int} Len Mandatory ,Cell's Value Length
  	 * @return void
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
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","G",0);
 		    	}
 		    	break;
 			case "bkg_pol_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","G",0);
 		    	} 
 		    	break;
 			case "bkg_pod_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","G",0);
 		    	} 
 		    	break;
 			case "bkg_del_def_cd":		
 		    	if(Len == 5) {
 		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","L",0);
 		    	} else if(Len == 2) {
 		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","C",0);
 		    	} else if(Len == 3) {
 		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","R",0);
 		    	} else if(Len == 4) {
 		    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","G",0);
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
 	 * @param {ibsheet} sheetObj mandatory IBSheet Object
 	 * @return void
 	 * @author 
 	 * @version 2009.07.15
 	 */ 
     function checkDuration(sheetObj) {
 		var formObj=document.form;
 		var rowCount=sheetObj.RowCount();
 		var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, ""); 		
 		var expDt=formObj.exp_dt.value;
 		if(expDt != "") {
 			expDt=ComGetDateAdd(expDt, "D", 0, "");
 		}
 		if(rowCount > 0){
 			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
 				if (sheetObj.GetRowStatus(i) == "D") {
					continue;
				}
 				if(sheetObj.GetCellValue(i, "eff_dt") < effDt) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.SetCellValue(i, "eff_dt",effDt,0);
 					sheetObj.SelectCell(i, "eff_dt");
 					return false;
 				}
 				if(sheetObj.GetCellValue(i, "eff_dt") > sheetObj.GetCellValue(i, "exp_dt")  && sheetObj.GetCellValue(i, "exp_dt") != ""){
 					ComShowCodeMessage("PRI00306");
 					sheetObj.SetCellValue(i, "eff_dt",effDt,0);
 					sheetObj.SetCellValue(i, "exp_dt",expDt,0);
 					sheetObj.SelectCell(i, "eff_dt");
 					return false;
 				}
 				if((expDt != "")  &&  ((sheetObj.GetCellValue(i, "exp_dt") > expDt) || (sheetObj.GetCellValue(i, "exp_dt") == ""))) {
 					ComShowCodeMessage("PRI08016");
 					sheetObj.SetCellValue(i, "exp_dt",expDt,0);
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
 	function validateForm(sheetObj, formObj, sAction) {
 		switch (sAction) {
 		case IBSEARCH: // retrieving
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			break;
		case IBCREATE: // New
			break;
   		case IBSAVE:
   			if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
				return false;
			}
   			if (!ComChkValid(formObj)) {
 				return false;
 			}
 			if (comboObjects[0].GetSelectCode()== "") {
 				return false;
 			}
 			if (formObj.eff_dt.value == "") {
 				return false;
 			}
 			/*
 			if (formObj.exp_dt.value == "") {
 				return false;
 			}
 			*/
 			if (formObj.cfm_flg.value.toUpperCase() == "Y") {
 				return false;
 			}
 			if (formObj.eff_dt.value > formObj.exp_dt.value && formObj.exp_dt.value != "") {
 				ComShowCodeMessage('PRI00305', '[Duration]');
 				return false;
 			}
   			if(!checkDuration(sheetObj)) {
   				return false;
   			}
	   		for(var i = sheetObj.HeaderRows; getValidRowCount(sheetObj) > 0 && i <= sheetObj.LastRow; i++) {
	  	 		//Excluding deleted data
	   			if(sheetObj.GetRowStatus(i) == "D") {
	  	 			continue;
	  	 		}
	   			if(!checkMandatoryValidation(sheetObj, i)) {
	   				return false;
	   			}
	   		}
   			if (sheetObj.IsDataModified()) {
				//Duplicate Check
				if(!validateDupCheck(sheetObj)) {
					 return false;
				}
			}
 			break;
   		case IBCOPYROW:
   			/*if(!checkDuration(sheetObj)) {
   				return false;
   			}
   			*/
   			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectText()== "") {
 				return false;
 			}
   			if (formObj.cfm_flg.value.toUpperCase() == "Y") {
				return false;
			}
   			if(sheetObj.RowCount()> 0) {
   				//mandatory check
 				if(!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
 					return false;
 				}
   			}
 			break;
   		case IBINSERT:
   			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectText()== "") {
 				return false;
 			}
 			if (formObj.cfm_flg.value.toUpperCase() == "Y") {
				return false;
			}
   			if(sheetObj.RowCount()> 0) {
   				//mandatory check
 				if(!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
 					return false;
 				}
   			}
 			break;	  			
 		case MODIFY01: // Confirm
 			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
 				return false;
 			}
 			if (formObj.cfm_flg.value.toUpperCase() == "Y") {
 				return false;
 			}		
 			break;
 		case MODIFY02: // Cancel Confirm
 			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
 				return false;
 			}
 			if (formObj.cfm_flg.value.toUpperCase() != "Y") {
 				return false;
 			}
 			break;
 		case MODIFY03: // Delete
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
 			if (formObj.cfm_flg.value.toUpperCase() == "Y") {
				return false;
			}
			break;
 		case IBDELETE: // Row Delete
 			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectText()== "") {
 				return false;
 			}
 			if (formObj.cfm_flg.value.toUpperCase() == "Y") {
 				return false;
 			}
 			break;
 		case MODIFY04: // Copy
 			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
 				return false;
 			}
 			break;
 		}
 		return true;
 	}
 	/**
 	 * Checking duplication of SHEET ROW <br>
 	 * Validating in case of same preiod between eff_dt and exp_dt eventhough other item is same <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * validateDupCheck(sheetObj)
 	 * </pre>
 	 * @param {ibsheet} sheetObj mandatory IBSheet Object
 	 * @return boolean
 	 * @author 
 	 * @version 2009.05.20
 	 */ 
 	function validateDupCheck(sheetObj) {
 		var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|rule_appl_chg_tp_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
 		 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_usa_svc_mod_cd|bkg_por_def_cd|bkg_pol_def_cd" +
 		 		"|bkg_pod_def_cd|bkg_del_def_cd|bkg_rcv_term_cd|bkg_de_term_cd" +
 		 		"|bkg_por_tp_cd|bkg_pol_tp_cd|bkg_pod_tp_cd|bkg_del_tp_cd", false, true);
 		if (rowM != "") {
 			var rowDup=rowM.replace("|", ","); 			
 			//All Duplicated Row
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
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_usa_svc_mod_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_por_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pol_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pod_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_del_def_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_rcv_term_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_de_term_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_por_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pol_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pod_tp_cd");
				dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_del_tp_cd");
 				for(var j=0; j<rowArr.length; j++) {
					temValue=sheetObj.GetCellValue(rowArr[j], "chg_rule_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "rule_appl_chg_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_rat_ut_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_prc_cgo_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_imdg_clss_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_cmdt_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_usa_svc_mod_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_por_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pol_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pod_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_del_def_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_rcv_term_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_de_term_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_por_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pol_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pod_tp_cd");
					temValue += sheetObj.GetCellValue(rowArr[j], "bkg_del_tp_cd");
 					if(i != j) {
	 					if(dupValue == temValue) {
	 						firstEffDt=sheetObj.GetCellValue(rowArr[i], "eff_dt");
	 						firstExpDt=sheetObj.GetCellValue(rowArr[i], "exp_dt");
	 						if(firstExpDt == "") {
	 							firstExpDt="99991231";
	 						}
	 						SecondEffDt=sheetObj.GetCellValue(rowArr[j], "eff_dt");
	 						SecondExpDt=sheetObj.GetCellValue(rowArr[j], "exp_dt");
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
 		var formObj=document.form;
 		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
 			var prevStatus=sheetObj.GetRowStatus(i);
 			if(sheetObj.GetCellValue(i,"exp_dt") == "99991231") {
 				sheetObj.SetCellValue(i,"exp_dt","",0);
 			}
 			if(formObj.cfm_flg.value == "Y" || AUTH_YN < 1) {
 				sheetObj.SetRowEditable(i,0);
 			} else {
 				disableColumnValidation(sheetObj, i, "", sheetObj.GetCellValue(i,"chg_rule_def_cd"));
 			}
			sheetObj.SetRowStatus(i,prevStatus);
  			// State color
  			setStateColor(sheetObj, i);
  			// defining Rule & Charge Code color
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
 	function SheetObject(sheet, row, col, rtnVal){
 		this.sheet = sheet;
 		this.row = row;
 		this.col = col;
 		this.rtnVal = rtnVal;
 	}
 	var _tmp_sheetObject;
 	function callback4027(rtnVal){
 		var sheetObj = _tmp_sheetObject.sheet;
 		var Row = _tmp_sheetObject.row;
 		var Col = _tmp_sheetObject.col;
 		
 		if (rtnVal != null){
			sheetObj.SetCellValue(Row, Col,rtnVal.cd,0);
			//it's commodity code in case of 6 digits
			sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd",rtnVal.tp,0);
		}
 	}
 	function callback4026_1(rtnVal){
 		var sheetObj = _tmp_sheetObject.sheet;
 		var Row = _tmp_sheetObject.row;
 		var Col = _tmp_sheetObject.col;
 		var pinkColor="#FFC0CB";
 		if (rtnVal != null){
			sheetObj.SetCellValue(Row, "bkg_por_def_cd",rtnVal.cd,0);
			sheetObj.SetCellValue(Row, "bkg_por_tp_cd",rtnVal.tp,0);
			// Pink as background color in case of State
			if(rtnVal.tp == "T"){
  				sheetObj.SetCellValue(Row, "bkg_por_cnt_cd",rtnVal.cnt_cd,0);
				sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",pinkColor);
			} else {
				sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",0);
			}
		}
 	}
 	
 	function callback4026_2(rtnVal){
 		var sheetObj = _tmp_sheetObject.sheet;
 		var Row = _tmp_sheetObject.row;
 		var Col = _tmp_sheetObject.col;
 		var pinkColor="#FFC0CB";
 		if (rtnVal != null){
			sheetObj.SetCellValue(Row, "bkg_pol_def_cd",rtnVal.cd,0);
			sheetObj.SetCellValue(Row, "bkg_pol_tp_cd",rtnVal.tp,0);
			// Pink as background color in case of State
			if(rtnVal.tp == "T"){
  				sheetObj.SetCellValue(Row, "bkg_pol_cnt_cd",rtnVal.cnt_cd,0);
				sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",pinkColor);
			} else {
				sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",0);
			}
		}
 	}
 	
 	function callback4026_3(rtnVal){
 		var sheetObj = _tmp_sheetObject.sheet;
 		var Row = _tmp_sheetObject.row;
 		var Col = _tmp_sheetObject.col;
 		var pinkColor="#FFC0CB";
 		if (rtnVal != null){
			sheetObj.SetCellValue(Row, "bkg_pod_def_cd",rtnVal.cd,0);
			sheetObj.SetCellValue(Row, "bkg_pod_tp_cd",rtnVal.tp,0);
			// Pink as background color in case of State
			if(rtnVal.tp == "T"){
  				sheetObj.SetCellValue(Row, "bkg_pod_cnt_cd",rtnVal.cnt_cd,0);
				sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",pinkColor);
			} else {
				sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",0);
			}
		}
 	}
 	
 	function callback4026_4(rtnVal){
 		var sheetObj = _tmp_sheetObject.sheet;
 		var Row = _tmp_sheetObject.row;
 		var Col = _tmp_sheetObject.col;
 		var pinkColor="#FFC0CB";
 		if (rtnVal != null){
			sheetObj.SetCellValue(Row, "bkg_del_def_cd",rtnVal.cd,0);
			sheetObj.SetCellValue(Row, "bkg_del_tp_cd",rtnVal.tp,0);
			// Pink as background color in case of State
			if(rtnVal.tp == "T"){
  				sheetObj.SetCellValue(Row, "bkg_del_cnt_cd",rtnVal.cnt_cd,0);
				sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",pinkColor);
			} else {
				sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",0);
			}
		}
 	}
 	 /**
      * Calling function in case of Onclick event <br>
      * calling calendar  DIV <br>
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
   	    		var sUrl="/opuscntr/ESM_PRI_4027.do?"
   	   	    		sUrl += "commodity_cmd=C";
   	    		_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
   	  			ComOpenPopup(sUrl, 700, 345, "callback4027", "0,1", true);
   	  			break;
   	    	case "bkg_por_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&location_cmd=LTCR";
 	  			_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
 	  			ComOpenPopup(sUrl, 700, 310, "callback4026_1", "0,1", true);
   				break;
   	    	case "bkg_pol_def_cd":
 	  			var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&location_cmd=LTCR";
 	  			_tmp_sheetObject = new SheetObject(sheetObj, Row, Col); 	
 	  			ComOpenPopup(sUrl, 700, 310, "callback4026_2", "0,1", true);
   				break;
   	    	case "bkg_pod_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&location_cmd=LTCR";
 	  			_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
 	  			ComOpenPopup(sUrl, 700, 310, "callback4026_3", "0,1", true);
   				break;
   	    	case "bkg_del_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&location_cmd=LTCR";
 	  			_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
 	  			ComOpenPopup(sUrl, 700, 310, "callback4026_4", "0,1", true);
   				break;
       	}    	 
      }   
      /**
       * Checking editable item by selected code<br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	disableColumnValidation(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj mandatory IBSheet Object
       * @param {int} Row mandatory Onclick ,Cell's Row Index
       * @param {int} Col Mandatory OnClick ,Cell's Column Index 
       * @param {str} Value without Value Mandatory Format when saving 
       * @return void
       * @author 
       * @version 2009.07.02
       */           
      function disableColumnValidation(sheetObj, Row, Col, Value) {
    	initColumnEditable(sheetObj, Row, Col, Value);
 		switch(Value)
     	{
     		case "APP":	
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
     			sheetObj.SetCellEditable(Row, "bkg_rat_ut_cd",0);
     			//sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= false;
     			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
     			sheetObj.SetCellEditable(Row, "curr_cd",0);
     			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
     			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
     			sheetObj.SetCellEditable(Row, "bkg_cmdt_def_cd",0);
     			sheetObj.SetCellEditable(Row, "bkg_usa_svc_mod_cd",0);
     			sheetObj.SetCellEditable(Row, "bkg_por_def_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_pol_def_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_pod_def_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_del_def_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_rcv_term_cd",0);
				sheetObj.SetCellEditable(Row, "bkg_de_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				break;
     		case "NOT":	
     			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
     			sheetObj.SetCellEditable(Row, "curr_cd",0);
     			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
     			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				break;
     		case "RAS":	
     			sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
     			sheetObj.SetCellEditable(Row, "curr_cd",0);
     			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
     			sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
				break;
 			case "ARB":	
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
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
 				break;
 			case "RAR":
 				sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
 				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
 				break;
 			case "RAP":
 				sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
 				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
 				break;
 			case "DOR":
 				sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
 				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
				sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",0);
				sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",0);
 				break;
 			case "RAC":	
				sheetObj.SetCellEditable(Row, "rule_appl_chg_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
 				sheetObj.SetCellEditable(Row, "curr_cd",0);
 				sheetObj.SetCellEditable(Row, "pay_term_cd",0);
				break;
 			default:  //SURCHARGE 								
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
        * Initializing Editable property for visible item on SHEET<br>
        * 
        * <br><b>Example :</b>
        * <pre>
        *	initColumnEditable(sheetObj, Row, Col, Value);
        * </pre>
        * @param {ibsheet} sheetObj mandatory IBSheet Object
        * @param {int} Row mandatory Onclick ,Cell's Row Index
        * @param {int} Col Mandatory OnClick ,Cell's Column Index 
        * @param {str} Value without Value Mandatory Format when saving 
        * @return void
        * @author 
        * @version 2009.07.02
        */           
       function initColumnEditable(sheetObj, Row, Col, Value) {    	   
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
			sheetObj.SetCellEditable(Row, "bkg_por_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_pol_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_pod_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_del_def_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_rcv_term_cd",1);
			sheetObj.SetCellEditable(Row, "bkg_de_term_cd",1);
			sheetObj.SetCellEditable(Row, "conv_rat_ut_cd",1);
			sheetObj.SetCellEditable(Row, "conv_prc_cgo_tp_cd",1);
   	}
    /**
     * Checking mandatory column by selected code type<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	checkMandatoryValidation(sheetObj, Row);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @return void
     * @author 
     * @version 2009.07.02
     */ 	
  	function checkMandatoryValidation(sheetObj, Row) {
  		var rowCount=sheetObj.RowCount();
  		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "RAC" ) {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001 && (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F")) {
 				// In case of Application is Fixed Amount or Adjust option, Amount Column is Mandatory (7/21)
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
	 			// In case that application is fixed amount or adjust amount when inputting SURCHARGE CODE
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
 				/*} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} 
 		} else if (chgRuleDefCd == "NOT") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			}  			
 		} else if (chgRuleDefCd == "RAS") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001) {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} 
 		} else if (chgRuleDefCd == "ARB") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
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
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
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
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
 			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
 				ComShowCodeMessage("PRI00316","Per");
 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
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
 		} else if (chgRuleDefCd == "RAR") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
// 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "" ) {
// 				ComShowCodeMessage("PRI00316","Amount");
// 				sheetObj.SelectCell(Row, "frt_rt_amt");
// 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_por_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_pol_def_cd") == ""
 				&& sheetObj.GetCellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_del_def_cd") == "") {
 				//Mandatory input -POR, POL,POD,DEL 				 				
 				ComShowCodeMessage("PRI01052","POR, POL, POD, DEL");
 				sheetObj.SelectCell(Row, "bkg_por_def_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAP") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
// 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
// 				ComShowCodeMessage("PRI00316","Amount");
// 				sheetObj.SelectCell(Row, "frt_rt_amt");
// 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_cmdt_def_cd") == "") {
 				ComShowCodeMessage("PRI00316","Commodity");
 				sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "DOR") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
// 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
// 				ComShowCodeMessage("PRI00316","Amount");
// 				sheetObj.SelectCell(Row, "frt_rt_amt");
// 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_rcv_term_cd") == "" && sheetObj.GetCellValue(Row, "bkg_de_term_cd") == "") {
 				ComShowCodeMessage("PRI00334","Receiving Term","Delivery Term");
 				sheetObj.SelectCell(Row, "bkg_rcv_term_cd");
 				return false;
 			}
 		} else if (chgRuleDefCd == "RAC") {
 			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
 				/*	} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;*/
 			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
// 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
// 				ComShowCodeMessage("PRI00316","Amount");
// 				sheetObj.SelectCell(Row, "frt_rt_amt");
// 				return false;
 			} else if(sheetObj.GetCellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Cargo Type");
 				sheetObj.SelectCell(Row, "bkg_prc_cgo_tp_cd");
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
      * Setting default at column by selected code type<br>
      * 
      * <br><b>Example :</b>
      * <pre>
      *	defaultColumnValidation(sheetObj, Row, Col, Value);
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} Row mandatory Onclick ,Cell's Row Index
      * @param {int} Col Mandatory OnClick ,Cell's Column Index 
      * @param {str} Value without Value Mandatory Format when saving 
      * @return void
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
 			case "NOT":
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","I",0);
 				break;
 			case "RAS":
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				break;
 			case "RAR":
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				break;
 			case "RAP":
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				break;
 			case "DOR":
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
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
   * Initializing data<br>
   * 
   * <br><b>Example :</b>
   * <pre>
   *	initColumnValue(sheetObj, Row);
   * </pre>
   * @param {ibsheet} sheetObj mandatory IBSheet Object
   * @param {int} Row mandatory Onclick ,Cell's Row Index
   * @return void
   * @author 
   * @version 2009.07.02
   */ 	
   	function initColumnValue(sheetObj, Row) {
     	  sheetObj.SetCellValue(Row, "rule_appl_chg_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "rt_appl_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "rt_op_cd","",0);
     	  sheetObj.SetCellValue(Row, "curr_cd","",0);
     	  sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
     	  sheetObj.SetCellValue(Row, "pay_term_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_rat_ut_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_prc_cgo_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_cmdt_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_usa_svc_mod_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_por_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_por_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_pol_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_pod_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_del_tp_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_del_def_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_rcv_term_cd","",0);
     	  sheetObj.SetCellValue(Row, "bkg_de_term_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_rat_ut_cd","",0);
     	  sheetObj.SetCellValue(Row, "conv_prc_cgo_tp_cd","",0);
   	}
    /**
     * Multi-copying SHEET ROW<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	copySheetData(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2010.03.23
     */	
 	function copySheetData(sheetObj) {
  		//Setting default after loading SHEET
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
      			// State color
      			setStateColor(sheetObj, idx);
      			// defining Rule & Charge Code color
      			//setChargeRuleColor(sheetObj, idx);
      			maxSeq++;
 			}
 		}
 	}
 	/**
      * Seperating logic by selected CHARGE RULE TYPE<br>
      * RULE code : CHG_RULE_TP_CD=C ,Registering to NOTE_CONV_RULE_CD <br>
      * CHARGE code : CHG_RULE_TP_CD=R ,Registering to NOTE_CONV_CHG_CD <br>      
      * <br><b>Example :</b>
      * <pre>
      *	insertChargeRuleType(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} Row mandatory Onclick ,Cell's Row Index
      * @return void
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
   * Using RULE & SURCHARGE CODE, Implement Code COMBOBOX <br>
   * <br><b>Example :</b>
   * <pre>
   *	insertChargeRuleType(sheetObj);
   * </pre>
   * @param {ibsheet} sheetObj mandatory IBSheet Object
   * @param {form} formObj Mandatory form Object
   * @return void
   * @author 
   * @version 2009.07.02
   */
   	function initComboChargeRuleCode(sheetObj, formObj) {   		
   		var sCd="";
   		var sNm="";
   		formObj.f_cmd.value=SEARCH03;
   		var tXml=sheetObj.GetSearchData("ESM_PRI_3005GS.do", FormQueryString(formObj));
   		var arrData=ComPriXml2ComboString(tXml, "cd", "nm");
   		if (arrData != null){
   		    var arrCode=arrData[0].split("|");
   		    var arrName=arrData[1].split("|");
   		    var conData="";
   		    for(i=0; i < arrName.length;i++){
   		        if(i==0){
   		            arrName[i]=arrCode[i]+"\t"+arrName[i];
   		        }else{
   		            arrName[i]="|"+arrCode[i]+"\t"+arrName[i];
   		        }
   		        conData=conData.concat(arrName[i]);
   		    }
   		    arrData[1]=conData;
   			sCd=" |" + arrData[0];
   			sNm=" |" + arrData[1];
   		} else {
   			sCd=" |";
   			sNm=" |";
   		}
   		sChgCdVisiable=sNm;
   		sheetObj.SetColProperty(2, {ComboText:sNm, ComboCode:sCd} );
   	}
   	/**
   	 * handling OnBeforeActivate event<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *     obj_activate()
   	 * </pre>
   	 * @param  void
   	 * @return void
   	 * @author 
   	 * @version 2009.04.17
   	 */
   	function obj_activate() {
   		var formObject=document.form;
   	    var srcName=ComGetEvent("name");
   	    if (srcName == "exp_dt" && formObject.eff_dt_hidden.value != "") {
   	   	//if (srcName == "exp_dt" && formObject.exp_dt.value != "" && formObject.eff_dt_hidden.value != "") {
   	    	var effDt=formObject.eff_dt_hidden.value;
   	    	var expDt=formObject.exp_dt.value;
   	    	formObject.eff_dt.value=formObject.eff_dt_hidden.value;
       		comboObjects[1].SetText(selectedGlineSeq, 0, effDt); 
   			comboObjects[1].SetText(selectedGlineSeq, 1, expDt);
   			comboObjects[1].SetText(selectedGlineSeq, 2, effDt);
   			formObject.eff_dt_hidden.value="";
   	    	//ComClearSeparator (event.srcElement);
   	    	//modifyConversionEffDt (effDt);
   	    	//modifyConversionExpDt (expDt);
   	    }
   	}
   	/**
   	 * Handling Onbeforedeactivate event<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *     obj_deactivate()
   	 * </pre>
   	 * @param  void
   	 * @return void
   	 * @author 
   	 * @version 2009.04.17
   	 */
   	function obj_deactivate() {
   	    ComChkObjValid(event.srcElement);
   	}
   	/**
   	 * Calling Function in case of OnChange event <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
   	 * @param {int} code Mandatory Onclick 
   	 * @param {int} text Mandatory 
   	 * @return void
   	 * @author 
   	 * @version 2009.05.01
   	 */
   	function srch_trf_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
   		var formObj=document.form;
   		var arrText=NewTxt.split("|");
   		if (arrText != null && arrText.length > 0) {
   			formObj.srch_trf_nm.value=comboObj.GetText(NewCod, 1);
   			formObj.srch_trf_cd_text.value = srch_trf_cd.GetText(NewCod, 0);
			var srchTrfCd=comboObj.GetText(NewCod, 0);
			var code = srch_trf_cd.GetSelectCode();
			var arr=code.split("-");				
			formObj.trf_pfx_cd.value=arr[0];
			formObj.trf_no.value=arr[1];
			//CODE
 			initComboChargeRuleCode(sheetObjects[0], formObj); 
 			selectedGlineSeq=null;
 			if(!isCopy) {
 				note_seq.SetSelectCode("");//Set blank, To get duration List
 				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
 			} else {
 				note_seq_OnChange(note_seq,0,'','',1, "X", "");
 			}
   		}
   	}
   /*	
   	function srch_trf_cd_OnKeyUp(comboObj, KeyCode, Shift) {
   		var svcScpCdTxt=comboObj.GetSelectText();
   		if (svcScpCdTxt.length > 3) {
   			document.form.svc_scp_nm.focus();
   		}
   	}
   	*/
   	/**
   	 * calling function in case of OnClear event <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
   	 * @return void
   	 * @author 
   	 * @version 2009.05.01
   	 */
   	function srch_trf_cd_OnClear(comboObj) {
   		var formObject=document.form;
   		formObject.srch_trf_nm.value="";
   		srch_trf_cd.SetSelectIndex(-1);
   	}
   	/**
   	 * event in case of losting IBMulti Combo's focus<br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *    ssrch_trf_cd_OnBlur(comboObj);
   	 * </pre>
   	 * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
   	 * @return void
   	 * @author 
   	 * @version 2009.05.01
   	 */
   	function srch_trf_cd_OnBlur(srch_trf_cd) {
   		var formObj=document.form;
   		var code=srch_trf_cd.FindItem(srch_trf_cd.GetSelectCode(), 0, false);
   		if (code != null && code != "" && code != "-1") {
   	   		var arr=code.split("-");				
   			formObj.trf_pfx_cd.value=arr[0];
   			formObj.trf_no.value=arr[1];
   			var text=srch_trf_cd.GetText(code, 1);
   			if (text != null && text != "" && text != formObj.srch_trf_nm.value) {
   				formObj.srch_trf_nm.value=srch_trf_cd.GetText(code, 1);
   				//CODE
   	 			initComboChargeRuleCode(sheetObjects[0], formObj); 
   	 			selectedGlineSeq=null;
   	 			if(!isCopy) {
   	 				note_seq.SetSelectCode("");//Set blank, To get duration List
   	 				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
   	 			} else {
   	 				note_seq_OnChange(comboObjects[1], "X", "");
   	 			}
   			}
   		}
   	}
 	/**
 	 * Calling Function in case of OnChange event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
 	 * @param {int} code Mandatory Onclick 
 	 * @param {int} text Mandatory 
 	 * @return void
 	 * @author 
 	 * @version 2009.05.01
 	 */
 	function note_seq_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
 		
 		//note_seq_OnClear(comboObj);
 		
 		var selEffDt=comboObj.GetSelectText();
 		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
 			return false;
 		}
 		
 		if (ComIsDate(selEffDt)) {
 			var formObj=document.form;
 			if(NewCod != "") { //select
 				formObj.eff_dt.value=comboObj.GetText(NewCod, 0);
				formObj.exp_dt.value=comboObj.GetText(NewCod, 1);
				formObj.exp_dt_hidden.value=comboObj.GetText(NewCod, 1);
						
				// After Retrieve INFOdata, Setting FORM
		 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);

 			} else { //manual input
 				selEffDt=selEffDt.replace(/-/gi, "");
 	 			selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
 	 			document.form.eff_dt.value=selEffDt; 		
 	 			document.form.eff_dt_hidden.value=selEffDt; 		
 	 			
 	 			var nIdx = comboObj.FindItem(selEffDt, 0, true);
				if( nIdx == -1) {
					comboObj.InsertItem(comboObj.GetItemCount(), document.form.eff_dt.value, "");
					comboObj.SetSelectIndex(comboObj.GetItemCount()-1, false);
				} else {
					comboObj.SetSelectIndex(nIdx, false);
				}
 			}
 		} else {
			ComShowCodeMessage("COM12134", "Effective Date");
			return false;
		}
 	}
 	/**
 	 * calling function in case of OnClear event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
 	 * @return void
 	 * @author 
 	 * @version 2009.05.01
 	 */
 	function note_seq_OnClear(comboObj) {
 		var formObj=document.form;
 		formObj.eff_dt.value="";
 		formObj.exp_dt.value="";
 		formObj.cfm_flg.value="";
 		formObj.cfm_flg_nm.value="";
 		formObj.note_conv_mapg_id.value="";
 		sheetObjects[0].RemoveAll();
 		
 	}
 	/**
 	 * Calling funciton of OnKeyUp event<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
 	 * @param   {Integer} KeyCode Mandatory ASCII code value
 	 * @param {Integer} Shift Mandatory , 1:Shift, 2:Ctrl, 0 :other
 	 * @return void
 	 * @author 
 	 * @version 2009.05.01
 	 */
// 	function note_seq_OnKeyUp(comboObj, KeyCode, Shift) {
// 		var selEffDt=comboObj.GetSelectText();
// 		var formObj=document.form;
// 		if (selEffDt.search(/[^0-9]/gi) >= 0) {
// 			selEffDt=selEffDt.replace(/[^0-9]/gi, "");
// 			comboObj.SetText(selectedGlineSeq, 2, selEffDt); 			
// 		}
// 		modifyConversionEffDt (selEffDt);
// 		if (selEffDt.length == 8) {
// 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
// 			document.form.exp_dt.focus();
// 		}
// 	}
 	/**
	 * When key press and released on object. This event trigger.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *   
	 * </pre>
	 * @param  void
	 * @return void
	 * @author 
	 * @version 2009.12.07
	 */
   	function exp_dt_OnKeyup () {
   		var formObj=document.form;
 		var expDt=formObj.exp_dt.value;
 		if (expDt.search(/[^0-9]/gi) >= 0) {
 			expDt=expDt.replace(/[^0-9]/gi, "");	
 		}
 		modifyConversionExpDt (expDt);
   	}
 	/**
 	 * calling function in case of OnFocus event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
 	 * @return void
 	 * @author 
 	 * @version 2009.05.01
 	 */
// 	function note_seq_OnFocus(comboObj) {
// 		var selEffDt=comboObj.GetSelectText();
// 		if (selEffDt != null && selEffDt != "") {
// 			selEffDt=selEffDt.replace(/-/gi, "");
// 			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
// 		}
// 	}
 	/**
 	 * event in case of losting IBMulti Combo's focus<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *    note_seq_OnBlur(comboObj);
 	 * </pre>
 	 * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
 	 * @return void
 	 * @author 
 	 * @version 2009.05.01
 	 */
// 	function note_seq_OnBlur(comboObj) {
// 		var selEffDt=comboObj.GetSelectText();
// 		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
// 			return false;
// 		}
// 		if (ComIsDate(selEffDt)) {
// 			selEffDt=selEffDt.replace(/-/gi, "");
// 			selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
// 			document.form.eff_dt.value=selEffDt; 			
// 			comboObj.SetText(selectedGlineSeq, 2, selEffDt); 
// 		} else {
// 			ComShowCodeMessage("COM12134", "Effective Date");
// 			//note_seq.focus();
// 			return false;
// 		}
// 		comboObj.SetColWidth(2, "0");
// 	}
  /**
	* Setting the eff_dt of sheet using eff_dt of main duration.<br>
	* <br><b>Example :</b>
	* <pre>
	* modifyConversionEffDt (effDt);
	* </pre>
	* @param {string} effDt Mandatory form object
	* @return void
	* @author 
	* @version 2009.08.13
	*/       
  	function modifyConversionEffDt (effDt) {
  		var formObj=document.form;
  		var cfmFlg=formObj.cfm_flg.value;
  		var bEffDt=formObj.eff_dt.value;
  		if (bEffDt.search(/[^0-9]/gi) >= 0) {
  			bEffDt=bEffDt.replace(/[^0-9]/gi, "");		
 		}
  		if (effDt.search(/[^0-9]/gi) >= 0) {
  			effDt=effDt.replace(/[^0-9]/gi, "");		
 		}
  		if (cfmFlg != "Y" && effDt.length == 8) {
 	 		for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
  				if(!isCopy){
  					if(bEffDt == sheetObjects[0].GetCellValue(i, "eff_dt")) {
 	 					sheetObjects[0].SetCellValue(i, "eff_dt",effDt,0);
  					} else if(effDt > sheetObjects[0].GetCellValue(i, "eff_dt")) {
 	 					sheetObjects[0].SetCellValue(i, "eff_dt",effDt,0);
 	 				}
  				} else if(isCopy){
 	 				sheetObjects[0].SetCellValue(i, "eff_dt",effDt,0);
  				}
 	 		}
  		}
  	}
   /**
	* Setting the exp_dt of sheet using exp_dt of main duration.<br>
	* <br><b>Example :</b>
	* <pre>
	* modifyConversionExpDt (expDt);
	* </pre>
	* @param {string} expDt Mandatory form object
	* @return void
	* @author 
	* @version 2009.08.13
	*/    
  	function modifyConversionExpDt (expDt) {
  		var formObj=document.form;
  		var cfmFlg=formObj.cfm_flg.value;
 		var bExpDt=formObj.exp_dt_hidden.value; 
  		if (bExpDt.search(/[^0-9]/gi) >= 0) {
  			bExpDt=bExpDt.replace(/[^0-9]/gi, "");		
 		}
  		if (expDt.search(/[^0-9]/gi) >= 0) {
  			expDt=expDt.replace(/[^0-9]/gi, "");		
 		}
  		if (cfmFlg != "Y" && expDt.length == 8) { 
 	 		for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
 	 			if(!isCopy){
 	 				if(bExpDt == sheetObjects[0].GetCellValue(i, "exp_dt")) {
 	 					sheetObjects[0].SetCellValue(i, "exp_dt",expDt,0);
 	 				} else if(expDt < sheetObjects[0].GetCellValue(i, "exp_dt")) {
 	 					sheetObjects[0].SetCellValue(i, "exp_dt",expDt,0);
 	 				}
 		 		} else if(isCopy){
 		 			sheetObjects[0].SetCellValue(i, "exp_dt",expDt,0);
  				}
 	 		}
 	 		// Save Current EXP_DT to exp_dt_hidden
 	 		formObj.exp_dt_hidden.value=expDt;
  		}	 
  	}
  /**
    * Return SYS_GUID() value <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param  void
    * @return sValue EtcData
    * @author 
    * @version 2009.08.13
    */       
    function getSYSGUID() {
    	var formObj=document.form;
    	formObj.f_cmd.value=COMMAND38;
    	var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
		var sValue=ComGetEtcData(sXml,"SYS_GUID");
		return sValue;
    }
   /**
    * Change Confirmation Flag to Flag Name. <br>
    * <br><b>Example :</b>
    * <pre>
    * getConfirmName(flg);
    * </pre>
    * @param {string} flg Confirmation Flag 
    * @return void
    * @author 
    * @version 2009.08.13
    */  	    
    function getConfirmName(flg) {
    	var formObj=document.form;
		if(flg == "Y"){
			formObj.cfm_flg_nm.value="Yes";
			formObj.cfm_flg.value="Y";
			if(AUTH_YN > 0){
				toggleButtons("CONF_YES");
			} else {
				toggleButtons("READONLY");
			}
		} else if(flg == "N"){
			formObj.cfm_flg_nm.value="No";
			formObj.cfm_flg.value="N";
			if(AUTH_YN > 0){
				toggleButtons("CONF_NO");
			} else {
				toggleButtons("READONLY");
			}
		} else {
			formObj.cfm_flg_nm.value="";
			formObj.cfm_flg.value="";
			if(AUTH_YN > 0){
				toggleButtons("NEW");
			} else {
				toggleButtons("READONLY");
			}
		}
    }
 	/**
 	 * Controlling all buttons as enable/Disable<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * </pre>
 	 * @param {string} mode Mandatory,user mode or authority
 	 * @author 
 	 * @version 2009.05.01
 	 */
 	function toggleButtons(mode) {
 		switch (mode) {
 		case "CLEAR":
 			ComBtnDisable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnDisable("btn_save");
 			ComBtnDisable("btn_confirm");
 			ComBtnDisable("btn_confirmcancel");
 			ComBtnDisable("btn_delete");
 			ComBtnDisable("btn_copy");
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowcopy");
 			ComBtnDisable("btn_rowdelete");
 			break;
 		case "INIT":
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_save");
 			ComBtnEnable("btn_confirm");
 			ComBtnEnable("btn_confirmcancel");
 			ComBtnEnable("btn_delete");
 			ComBtnEnable("btn_copy");
 			ComBtnEnable("btn_rowadd");
 			ComBtnEnable("btn_rowcopy");
 			ComBtnEnable("btn_rowdelete");
 			break;
 		case "NEW":
 			ComBtnDisable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_save");
 			ComBtnDisable("btn_confirm");
 			ComBtnDisable("btn_confirmcancel");
 			ComBtnDisable("btn_delete");
 			ComBtnDisable("btn_copy");
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowcopy");
 			ComBtnDisable("btn_rowdelete");
 			break;
 		case "CONF_YES":
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnDisable("btn_save");
 			ComBtnDisable("btn_confirm");
 			ComBtnEnable("btn_confirmcancel");
 			ComBtnDisable("btn_delete");
 			ComBtnEnable("btn_copy");
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowcopy");
 			ComBtnDisable("btn_rowdelete");
 			break;
 		case "CONF_NO":
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_save");
 			ComBtnEnable("btn_confirm");
 			ComBtnDisable("btn_confirmcancel");
 			ComBtnEnable("btn_delete");
 			ComBtnEnable("btn_copy");
 			ComBtnEnable("btn_rowadd");
 			ComBtnEnable("btn_rowcopy");
 			ComBtnEnable("btn_rowdelete");
 			break;
 		case "COPY":
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_save");
 			ComBtnDisable("btn_confirm");
 			ComBtnDisable("btn_confirmcancel");
 			ComBtnDisable("btn_delete");
 			ComBtnDisable("btn_copy");
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowcopy");
 			ComBtnDisable("btn_rowdelete"); 
 			break;
 		case "READONLY":
 			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnDisable("btn_save");
 			ComBtnDisable("btn_confirm");
 			ComBtnDisable("btn_confirmcancel");
 			ComBtnDisable("btn_delete");
 			ComBtnDisable("btn_copy");
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowcopy");
 			ComBtnDisable("btn_rowdelete"); 			
 			break;
 		}
 	}