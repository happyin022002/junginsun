/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_05.js
*@FileTitle  :  S/C Proposal Origin/Destination IHC Charge-Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0003_05 : business script for ESM_PRI_0003_05 
     */
    // Common Global Variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				buttonControl();
    				break;
    			case "btn_save":
    				doActionIBSheet(sheetObject1, formObject, IBSAVE);
    				buttonControl();
    				break;
    			case "btn_acceptall":
    				doActionIBSheet(sheetObject1,document.form,MODIFY03);
    				break;
    			case "btn_cancelall":
    				doActionIBSheet(sheetObject1,document.form,MODIFY04);
    				break;
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    				break;
    			case "btn_loadexcel":
    				doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
    				break;
    			case "btn_rowadd":
    				doActionIBSheet(sheetObject1,formObject,IBINSERT);
    				break;
    			case "btn_rowcopy":
    				doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
    				break;
    			case "btn_delete":
    				doActionIBSheet(sheetObject1,formObject,IBDELETE);
    				break;
    			case "btn_amend":
    				doActionIBSheet(sheetObject1,document.form,COMMAND01);
    				break;
    			case "btn_amendcancel":
    				doActionIBSheet(sheetObject1,document.form,COMMAND02);
    				break;
    			case "btn_accept":
    				doActionIBSheet(sheetObject1,document.form,MODIFY01);
    				break;
    			case "btn_acceptcancel":
    				doActionIBSheet(sheetObject1,document.form,MODIFY02);
    				break;
              }
     	} catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
    }
    /**
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet</b>
     * implementing onLoad event handler in body tag</b>
     * adding first-served functions after loading screen.</b>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	resizeSheet();
    	pageOnLoadFinish();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object ,Serial no for Tag's ID
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch (sheetID) {
    		case "sheet1":
    		    with(sheetObj){
		    	        
		    	      var HeadTitle="state|Sel.|Seq.|Point|Description|Zip Code|Zip Code|Trans Mode|Term|Base Port|Per|Cargo Type|Currency|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|prop_no|amdt_seq||||||||per_type";
		    	      var headCount=ComCountHeadTitle(HeadTitle);
		    	      (headCount, 11, 0, true);
		
		    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		    	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    	      InitHeaders(headers, info);
		
		    	      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		    	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		    	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		    	             {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E" },
		    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:0,  Width:25,   Align:"Left",    ColMerge:0,   SaveName:"loc_grd_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		    	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:0,   SaveName:"loc_grd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		    	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"PopupEdit", Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E"   },
		    	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		    	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		    	             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"coffr_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		    	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_seq" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
		    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"per_type" } ];
		    	       
		    	      InitColumns(cols);
		
		    	      SetWaitImageVisible(0);
		    	      SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
		    	      SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
		    	      SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
		    	      SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
		    	      SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
		    	      SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
		    	      //SetAutoRowHeight(0);
		    	      resizeSheet(); //SetSheetHeight(280);
    	      }


    			break;
    		case "sheet2":
    		    with(sheetObj){
	    	      SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
	    	      var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
	    	      var headers = [ { Text:"", Align:"Center"} ];
	    	      InitHeaders(headers, info);
	    	      var cols = [{Type:"Text", Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" }];    	       
	    	      InitColumns(cols);
	    	      SetVisible(0);
    		} 
               break;	
    	}
    }
    
    function resizeSheet() {
 	 	ComResizeSheet(sheetObjects[0]);
 	 }
    
    /**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML tag(Object)
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory ,Cell's Value
     * @returns N/A
     * @author 
     * @version 2009.05.22
     */
    function tmp_object(sheet, row){
  		this.row = row;
  		this.sheet = sheet;
  	}
  	var G_TMP_OBJECT;
  	
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var colName=sheetObj.ColSaveName(Col);
    	var formObj=document.form;
    	var tpCd="";
    	G_TMP_OBJECT = new tmp_object(sheetObj, Row);
    	
 		if (colName == "rout_pnt_loc_def_cd") { //Point
 			var sUrl="ESM_PRI_4026.do?group_cmd="+ PRI_SP_SCP +"&location_cmd=L&prop_no="+ formObj.prop_no.value +"&amdt_seq="+ formObj.amdt_seq.value +"&svc_scp_cd="+ formObj.svc_scp_cd.value;
 			ComOpenPopup(sUrl, 700, 310, "rout_pnt_loc_def_cd_returnVal", "1,0", true);
 			
 		} else if (colName == "bse_port_def_cd") { //Base Point
 			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&prop_no="+ formObj.prop_no.value +"&amdt_seq="+ formObj.amdt_seq.value +"&svc_scp_cd="+ formObj.svc_scp_cd.value;
 			ComOpenPopup(sUrl, 700, 310, "bse_port_def_cd_returnVal", "1,0", true);
 		}
    }
    
    function rout_pnt_loc_def_cd_returnVal(rtnVal) {
    	var sheetObj = G_TMP_OBJECT.sheet;
    	if (rtnVal != null){
				sheetObj.SetCellValue(G_TMP_OBJECT.row, "rout_pnt_loc_def_cd", rtnVal.cd,0);
				sheetObj.SetCellValue(G_TMP_OBJECT.row, "rout_pnt_loc_def_nm",rtnVal.nm,0);
				if (rtnVal.cd.length == 5){ //SEtting Location Type
					tpCd="L";
				}
				sheetObj.SetCellValue(G_TMP_OBJECT.row,"rout_pnt_loc_tp_cd",tpCd ,0);
			}
    }
    
    function bse_port_def_cd_returnVal(rtnVal) {
    	var sheetObj = G_TMP_OBJECT.sheet;
    	if (rtnVal != null  && checkBasePort(sheetObj, G_TMP_OBJECT.row, rtnVal.cd)){
				sheetObj.SetCellValue(G_TMP_OBJECT.row, "bse_port_def_cd", rtnVal.cd, 0);
				if(rtnVal.cd.length == 5) { //Modifying Location Type
					tpCd="L";
				} else if(rtnVal.cd.length == 4) { //Modifying Location Type
					tpCd="G";
				}
				sheetObj.SetCellValue(G_TMP_OBJECT.row,"bse_port_tp_cd",tpCd ,0);
			}
    }
    /**
     * Calling Function in case of OnSelectCell event <br>
     * Displaying different color for Amended row's Highlight <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory, ,current selected cell's Row Index
     * @param {int} NewCol Mandatory, ,current selected cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.05.22
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }
    /**
	 * Calling funciton in case of OnChange event on sheet1<br>
	 * showing Validation and description in case of selecting Multi ComboBox<br>
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
	 * @version 2009.05.22
	 */   
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var amdt_seq=formObj.amdt_seq.value;
		switch(sName) {
			case "rout_pnt_loc_def_cd":
				if(!checkRoutePointLocation(sheetObj, Row, Value)) {
					return;
				}
				checkLocationCode(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false);
				break;
			case "rcv_de_term_cd": //Term
				setTermCode(sheetObj, Row, Value);
				break;
			case "bse_port_def_cd":
if(sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && !checkBasePort(sheetObj, Row, Value)) { //Comparing with point
					 return;
				}
				checkLocationCode(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true);
 	    		break;
			case "rat_ut_cd":
				checkPerType(sheetObj, Row, Value);
				break;
			case "prc_cgo_tp_cd":
				checkCargoType(sheetObj, Row, Value);
				break;
			case "prop_frt_rt_amt":
//				if(Value < 0) {
//					ComShowMessage("Negative number is inputted. Please check again.");
//				}
				break;
			case "coffr_frt_rt_amt":
//				if(Value < 0) {
//					ComShowMessage("Negative number is inputted. Please check again.");
//				}
if(sheetObj.GetCellValue(Row, "prop_frt_rt_amt") == Value) {
					ComShowCodeMessage('PRI01044');
					sheetObj.SetCellValue(Row, "coffr_frt_rt_amt","",0);
					sheetObj.SelectCell(Row, "coffr_frt_rt_amt");
					return;
				}
				if(ComNullToZero(Value) == 0) {
					sheetObj.SetCellValue(Row, "prc_prog_sts_cd","I",0);//Modifying to Initial
				} else {
					sheetObj.SetCellValue(Row, "prc_prog_sts_cd","R",0);//Modifying to Return
				}
				break;
			case "loc_grd_cnt_cd":
				Value=Value.toUpperCase();
    			sheetObj.SetCellValue(Row,"loc_grd_cnt_cd",Value,0);
			break;
		}
		var propStsCd=formObj.prop_sts_cd.value;
		if(amdt_seq == 0 && propStsCd == 'I') {
if (sheetObj.GetCellValue(Row, "src_info_cd") == "PC") {
				sheetObj.SetCellValue(Row, "src_info_cd","PM",0);
} else if (sheetObj.GetCellValue(Row, "src_info_cd") == "GC") {
				sheetObj.SetCellValue(Row, "src_info_cd","GM",0);
			}
		}
    }
    /**
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.22
	 */
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
		 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
  			var formObj=document.form;
			setSheetDisplay(sheetObj);
// 			setProposalStatusSummary(formObj);
 			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
 		}
 	}   
 	/**
     * Calling function in case of OnSaveEnd event <br>
     * showing message in case of succesful saving<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2009.05.20
     */
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			var formObj=document.form;
			setSheetDisplay(sheetObj);
			setProposalStatusSummary(formObj);
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
		}	
 	}
    /**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns N/A
     * @author 
     * @version 2009.05.22
     */  
    function pageOnLoadFinish() {
    	initControl();
     	buttonControl();
     	parent.loadTabPage();
    }
 	/**
	 * Loading HTML control's event on page dynamically<br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return N/A
     * @author 
     * @version 2009.05.22
	 **/
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="/";
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	/**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function obj_click(){
		var sheetObject1=sheetObjects[0];
		var formObj=document.form;
		if (event.srcElement.name == "org_dest_tp_cd") {
			if(sheetObjects[0].IsDataModified()) { //in case of modifying
				if(ComShowCodeConfirm('PRI00006')) { 
					if(!doActionIBSheet(sheetObjects[0], formObj, MODIFY05)) {
						returnRadioButton();
						return;
					}
				} else {
					returnRadioButton();
					return;
				}
			}
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}
	}
	/**
     * Handling sheet's processes <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process Flag constant variable
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
        try{
    		switch(sAction) {	     	
	     	case IBSEARCH:
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		formObj.f_cmd.value=SEARCH01;
	     		sheetObj.DoSearch("ESM_PRI_0003_05GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
	     		break;
			case IBSEARCH_ASYNC02: // Setting font style
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_05GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
				break;		
			case IBSEARCH_ASYNC03:
				formObj.f_cmd.value=SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02138";
				} else {
					formObj.cd.value="CD02139";
				}
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
			case IBSEARCH_ASYNC04: //Retrieving row count of Ori, Dest data
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_05GS.do", FormQueryString(formObj));
				var arrDesc=ComPriXml2Array(sXml, "org_all_cnt|dest_all_cnt");
				if (arrDesc != null && arrDesc.length > 0) {
		 			if(arrDesc[0][0] > 0) {
		 				formObj.org_dest_tp_cd[0].checked=true;
		 				CONFIRM_ORG_GLINE=true;
		 			} else if(arrDesc[0][1] > 0) {
		 				formObj.org_dest_tp_cd[1].checked=true;
		 				CONFIRM_DEST_GLINE=true;
		 			} else {
		 				formObj.org_dest_tp_cd[0].checked=true;
		 			}
				}
				break;
	     	case IBSAVE:
	     		ComOpenWait(true);
	     		if(!enableFlag || !validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		formObj.f_cmd.value=MULTI01;
	     		var sParam=FormQueryString(formObj);
				var sParamSheet1=sheetObj.GetSaveString();
				sParam=sParamSheet1 + "&" + sParam;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_05GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				ComOpenWait(false);
				doActionIBSheet(sheetObj , formObj , IBSEARCH);
	     		break;
			case IBINSERT:	//Row Add
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				var amdt_seq=formObj.amdt_seq.value;
				var idx=sheetObj.DataInsert();
				sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
				sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
				sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq);
				sheetObj.SetCellValue(idx, "add_chg_tp_cd",formObj.add_chg_tp_cd.value);
				sheetObj.SetCellValue(idx, "org_dest_tp_cd",ComGetObjValue(formObj.org_dest_tp_cd));
				sheetObj.SetCellValue(idx, "add_chg_seq",parseInt(ComPriGetMax(sheetObj, "add_chg_seq")) + 1);
				sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
				sheetObj.SetCellValue(idx, "src_info_cd","NW");
				sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
				if(amdt_seq > 0) {
					sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
				}
				sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
				break;
			case IBCOPYROW: // Row Copy
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				var amdt_seq=formObj.amdt_seq.value;
				var idx=sheetObj.DataCopy();
				if(idx == 0) return false;
				setGetRowEditable(sheetObj, idx, true, "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt");
				sheetObj.SetCellValue(idx, "chk",0);
				sheetObj.SetCellValue(idx, "add_chg_seq",parseInt(ComPriGetMax(sheetObj, "add_chg_seq")) + 1);
				sheetObj.SetCellValue(idx, "coffr_frt_rt_amt","");
				sheetObj.SetCellValue(idx, "fnl_frt_rt_amt","");
				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq);
				sheetObj.SetCellValue(idx, "src_info_cd","NW");//New
				sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");//Initial
				if(amdt_seq != 0) {
					sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
//					changeSelectBackColor(sheetObj, sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
				}
				break;
			case IBDELETE: // Delete
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				var amdt_seq=formObj.amdt_seq.value;
				if (amdt_seq == "0") {
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length == 0) {
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk",1,0);
						if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd")!="I"){
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk",0,0);
							ComShowCodeMessage("PRI01002");
							return;
						}
					}else{
						for(var i=0;i < chkArr.length;i++){							
							if (sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd")!="I"){
								ComShowCodeMessage("PRI01002");
								return;
							}
						}
					}
					deleteRowCheck(sheetObj, "chk");
				} else {
					var eff_dt=formObj.eff_dt.value;
					var amdt_seq=formObj.amdt_seq.value;
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length > 0) {
						for(i=0; i<chkArr.length; i++) {
							//showing error message because cancelling amend is possible in case of data with amend status
							if(sheetObj.GetCellValue(chkArr[i],"amdt_seq") != amdt_seq) {
								ComShowCodeMessage("PRI01002");
								return;
							}
							if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq") == amdt_seq) {
							if(sheetObj.GetCellValue(chkArr[i],"src_info_cd") == "AM"
							|| sheetObj.GetCellValue(chkArr[i],"src_info_cd") == "AD"
							|| sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd") != "I") {
									ComShowCodeMessage("PRI01002");
									return;
								}
							}
						}
						var sRow=0;
						for(j=0; j<chkArr.length; j++) {
							//if not inputted data
							if(sheetObj.GetCellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq") != amdt_seq) {
								amendRow(sheetObj, formObj, chkArr[j]+sRow, "D");		
								sRow++; //Increasing row by deleting amendment
							}
						}
						deleteRowCheck(sheetObj, "chk");
					} else {
if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq") != amdt_seq) {
							ComShowCodeMessage("PRI01002");
							return;
						}
if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") == amdt_seq) {
if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"src_info_cd") == "AM"
|| sheetObj.GetCellValue(sheetObj.GetSelectRow(),"src_info_cd") == "AD"
|| sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd") !="I") {
								ComShowCodeMessage("PRI01002");
								return;
							}	
						}
if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") == amdt_seq) {
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk",1);
							deleteRowCheck(sheetObj,"chk");							
						} else {
							amendRow(sheetObj, formObj, sheetObj.GetSelectRow(), "D");
						}
					}					
				}
				break;			
//				if(!validateForm(sheetObj,document.form,sAction)) {
//					return false;
//				}
//			
//				var amdt_seq = formObj.amdt_seq.value;
//				if (amdt_seq == "0") {
//					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
//					if(chkArr.length == 0) {
//						sheetObj.CellValue2(sheetObj.SelectRow, "chk") = 1;
//					}
//					deleteRowCheck(sheetObj, "chk");
//				} else {
//					var eff_dt = formObj.eff_dt.value;
//					var amdt_seq = formObj.amdt_seq.value;
//					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
//					
//					if(chkArr.length > 0) {
//						for(i=0; i<chkArr.length; i++) {
//							//showing error message because cancelling amend is possible in case of data with amend status
//							if(sheetObj.CellValue(chkArr[i],"amdt_seq") != amdt_seq) {
//								ComShowCodeMessage("PRI01002");
//								return;
//							}
//							if(sheetObj.CellValue(chkArr[i],"n1st_cmnc_amdt_seq") == amdt_seq) {
//								if(sheetObj.CellValue(chkArr[i],"src_info_cd") == "AM" || sheetObj.CellValue(chkArr[i],"src_info_cd") == "AD") {
//									ComShowCodeMessage("PRI01002");
//									return;
//								}
//							}
//						}
//						var sRow = 0;
//						for(j=0; j<chkArr.length; j++) {
//							//if not inputted data
//							if(sheetObj.CellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq") != amdt_seq) {
//								amendRow(sheetObj, formObj, chkArr[j]+sRow, "D");		
//								sRow++; //Increasing row by deleting amendment			
//							}
//						}
//						deleteRowCheck(sheetObj, "chk");
//					} else {
//						if(sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq") != amdt_seq) {
//							ComShowCodeMessage("PRI01002");
//							return;
//						}
//						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq") == amdt_seq) {
//							if(sheetObj.CellValue(sheetObj.SelectRow,"src_info_cd") == "AM" || sheetObj.CellValue(sheetObj.SelectRow,"src_info_cd") == "AD") { 
//								ComShowCodeMessage("PRI01002");
//								return;
//							}	
//						}
//						if(sheetObj.CellValue(sheetObj.SelectRow,"n1st_cmnc_amdt_seq") == amdt_seq) {
//							sheetObj.CellValue(sheetObj.SelectRow,"chk") = 1;
//							deleteRowCheck(sheetObj,"chk");							
//						} else {
//							amendRow(sheetObj, formObj, sheetObj.SelectRow, "D");
//						}
//					}					
//				}
//				break;
			case MODIFY01:	//Accept
				ComOpenWait(true);
				if(!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI03;
				acceptRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
			case MODIFY02:	//Accept Cancel
				ComOpenWait(true);
				if(!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI04;
				acceptCancelRows(sheetObjects[0],document.form);
				ComOpenWait(false);
				break;
			case MODIFY03:	//Accept All
				ComOpenWait(true);
				if(!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI05;
				acceptAllRows(sheetObjects[0],document.form);
				ComOpenWait(false);
				break;
			case MODIFY04:	//Cancel All
				ComOpenWait(true);
				if(!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI06;
				acceptCancelAllRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
			case MODIFY05:
				ComOpenWait(true);	
				if(!enableFlag || !validateForm(sheetObj,formObj,sAction)) {
	     			if(formObj.org_dest_tp_cd[0].checked) {
						formObj.org_dest_tp_cd[1].checked=true;
					} else if(formObj.org_dest_tp_cd[1].checked) {
						formObj.org_dest_tp_cd[0].checked=true;
					}
	     			ComOpenWait(false);
	     			return false;
	     		}
				var sParamSheet=sheetObj.GetSaveString()+"&f_cmd="+MULTI01;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_05GS.do", sParamSheet);
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
	     		break;
			case COMMAND01:	//Amend
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0) {
					if(chkArr.length > 1) {					
						ComShowCodeMessage("PRI00310");
					} else {
						amendRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M");
					}
				} else { 
					amendRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M");
				}
				break;
			case COMMAND02: // Amend Cancel
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0) {
					if(chkArr.length > 1) {					
						ComShowCodeMessage("PRI00310");
					} else {
						amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M");
					}
				} else { 
					amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M");
				}
				break;					
			case IBDOWNEXCEL: //download excel
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, KeyFieldMark:0 });
				break;
			case IBLOADEXCEL:      //upload excel
				if (!validateForm(sheetObj, document.form, sAction)) {
					return false;
				}
		    	var propNO=formObj.prop_no.value;
		    	var amdtSeq=formObj.amdt_seq.value;
		    	var svcScpCd=formObj.svc_scp_cd.value;
		    	var orgDestTpCd=getOrgDestTpCd();
		    	var effDt=formObj.eff_dt.value;
				var sUrl="/opuscntr/ESM_PRI_0068.do?prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd+"&org_dest_tp_cd="+orgDestTpCd+"&eff_dt="+effDt;
				ComOpenPopup(sUrl, 1000, 400, "", "1,0", false);
				break;
    		}        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
        	if (sAction == IBSEARCH_ASYNC02 || sAction == IBSEARCH_ASYNC03 || sAction == IBSEARCH_ASYNC04
        			|| sAction == IBINSERT || sAction == IBCOPYROW || sAction == IBDELETE
        			|| sAction == COMMAND01 || sAction == COMMAND02 || sAction == IBDOWNEXCEL
        			|| sAction == IBLOADEXCEL ) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
	}
	/**
     *Accepting checked row or selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     * 		true  : SUCCESS
     * 		false : error
     * @author 
     * @version 2009.05.22
     */
 	function acceptRows(sheetObj,formObj) {
     	var propStsCd=formObj.prop_sts_cd.value;
 		var effDt=formObj.eff_dt.value;
 		var amdtSeq=formObj.amdt_seq.value;
 		var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
 		if(chkArr.length == 0) {
 			// selected row is previous
if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") != amdtSeq) {
 				ComShowCodeMessage("PRI00313");
 				return false;
 			}
 			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
 			chkArr[0]=sheetObj.GetSelectRow();
 		}
 		for(var i=0; i<chkArr.length; i++) { // showing error message in case of already accepted item
 			// 이전회차이다. 
if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq") != amdtSeq) {
 				ComShowCodeMessage("PRI00313");
 				comChangeValue(sheetObj, "chk", "0", "chk", "1");
 				return false;
 			}
if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd") == "A") {
 				ComShowCodeMessage("PRI01037");
 				comChangeValue(sheetObj, "chk", "0", "chk", "1");
 				return false;
 			}
 		}
 		var trgtArr=ComPriSheetFilterRows(sheetObj, "chk|n1st_cmnc_amdt_seq", "1|"+amdtSeq);
  		if(trgtArr.length == 0) {
  			ComShowCodeMessage("PRI00301");
 			return false;
  		}
  		for(var i=0; i<trgtArr.length; i++) {
var prcProgStsCd=sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd");
  			if(prcProgStsCd == "A") { // Except Accept
  				continue;
  			}
  			if(propStsCd == "Q") { //Input proposal amount into final in case of request
sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt"),0);//Approving Sales.Rep's amount
  			}
  			if(propStsCd == "R") { //in case of return status, Input C/Offer amount into final
sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt"),0);//Approving Counter Offer's amount
  			}
  			sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","A");//Modifying Accept
if (sheetObj.GetCellValue(trgtArr[i], "rat_ut_cd")==""){
sheetObj.SetCellValue(trgtArr[i], "rat_ut_cd",sheetObj.GetCellValue(trgtArr[i], "per_type"),0);
   			}   			
  		}
  		var sParam=FormQueryString(formObj);
		var sParamSheet=sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow=sheetObj.GetTopRow();
			var lastRow=sheetObj.LastRow();
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}
		sParam=sParam + "&" + sParamSheet;
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_05GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
  		comChangeValue(sheetObj, "chk", "0", "chk", "1");
  		return true;
 	}
 	/**
     * Accepting all accept targest <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptAllRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     * 		true  : success
     * 		false : error
     * @author 
     * @version 2009.05.22
     */
 	function acceptAllRows(sheetObj, formObj) {
     	var amdtSeq=formObj.amdt_seq.value;
 		var effDt=formObj.eff_dt.value;
 		var propStsCd=formObj.prop_sts_cd.value;
 		var trgtArr=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdtSeq+"|"+amdtSeq);
 		if(trgtArr.length == 0) { // no target for accept
 			ComShowCodeMessage("PRI00331", "Accept");
			return false;
 		}
 		for(var i=trgtArr.length-1; i>=0; i--) {
if(sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd") == "A") { //Except Accept
 				trgtArr.splice(i, 1);
 			}
 		}
 		if(trgtArr.length == 0) { // already accepted
 			ComShowCodeMessage("PRI00329");
			return false;
 		}
 		var rCnt=trgtArr.length;
 		for(var i=0; i<rCnt; i++) {
 			if(propStsCd == "Q") { //in case of request status , inputting proposal amount into final
 				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt"),0);//Approving Sales.Rep's amount
 			}
 			if(propStsCd == "R") { //in case of return status , inputting Counter Offer  amount into final
 				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt"),0);//Approving Counter Offer's amount
 			}
 			sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","A");//Accept로 변경
   			///////////Per_type입력
		if (sheetObj.GetCellValue(trgtArr[i], "rat_ut_cd")==""){
			sheetObj.SetCellValue(trgtArr[i], "rat_ut_cd",sheetObj.GetCellValue(trgtArr[i], "per_type"),0);
   			}  			
 		}
 		var sParam=FormQueryString(formObj);
		var sParamSheet=sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow=sheetObj.GetTopRow();
			var lastRow=sheetObj.LastRow();
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}
		sParam=sParam + "&" + sParamSheet;
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_05GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
 		return true;
 	}
 	/**
     * Canceling acceptance of checked row or selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory
     * @return boolean
     * 		true  : sucess
     * 		false : error
     * @author 
     * @version 2009.05.22
     */
  	function acceptCancelRows(sheetObj, formObj) {
     	var propStsCd=formObj.prop_sts_cd.value;
  		var effDt=formObj.eff_dt.value;
  		var amdtSeq=formObj.amdt_seq.value;
  		var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
  		if(chkArr.length == 0) {
  			// selected row is previous one
if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") != amdtSeq) {
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
  			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
  			chkArr[0]=sheetObj.GetSelectRow();
  		}
  		for(var i=0; i<chkArr.length; i++) { //error message in case of not accepted status
if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq") != amdtSeq) {
  				sheetObj.SetCellValue(chkArr[i], "chk","0",0);
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
  			// not accepted
		if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd") != "A") {
				sheetObj.SetCellValue(chkArr[i], "chk","0",0);
				ComShowCodeMessage("PRI01038");
				return false;
			}
  		}
  		var trgtArr=ComPriSheetFilterRows(sheetObj, "chk|n1st_cmnc_amdt_seq", "1|"+amdtSeq+"|"+effDt);
		if(trgtArr.length == 0) {
			ComShowCodeMessage("PRI00301");
			return false;
		}
		for(var i=0; i<trgtArr.length; i++) {
		var prcProgStsCd=sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd");
		var propFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt");
		var cofferFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt");
		var fnlFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "fnl_frt_rt_amt");
  			if(ComNullToZero(cofferFrtRtAmt) == 0) { //Resetting final and rollbacking to initial status in case of no Counter Offer amount
  				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","I");
  				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
  			} else { //Resetting final and rollbacking to Return status in case of existing Counter Offer amount
  				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","R");
 				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
  			}
		if (sheetObj.GetCellValue(trgtArr[i], "rat_ut_cd")==""){
			sheetObj.SetCellValue(trgtArr[i], "rat_ut_cd",sheetObj.GetCellValue(trgtArr[i], "per_type"),0);
   			}   			
  		}
		var sParam=FormQueryString(formObj);
		var sParamSheet=sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow=sheetObj.GetTopRow();
			var lastRow=sheetObj.LastRow();
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}
		sParam=sParam + "&" + sParamSheet;
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_05GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
		comChangeValue(sheetObj, "chk", "0", "chk", "1");	
  		return true;
  	}
  	/**
     * Cancelling acceptance with accepted all rows<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelAllRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory
     * @return boolean
     * 		true  : success
     * 		false : error
     * @author 
     * @version 2009.05.22
     */	
  	function acceptCancelAllRows(sheetObj, formObj){
  		var amdtSeq=formObj.amdt_seq.value;
  		var effDt=formObj.eff_dt.value;
  		// Unchecking checked Row
  		comChangeValue(sheetObj, "chk", "0");
  		// Searcing row index to cancel Accept
  		var trgtArr=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdtSeq+"|"+amdtSeq);
  		if(trgtArr.length == 0) {
  			ComShowCodeMessage("PRI00330"); //no row with current Amdt seq
 			return false;
  		}
  		for(var i=trgtArr.length-1; i>=0; i--) {
			if(sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd") != "A") { //except Accept
 				trgtArr.splice(i, 1);
 			}
 		}
 		if(trgtArr.length == 0) { //no accepted data
 			ComShowCodeMessage("PRI00330");
			return false;
 		}
  		for(var i=0; i<trgtArr.length; i++) {
		var prcProgStsCd=sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd");
		var propFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt");
		var cofferFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt");
		var fnlFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "fnl_frt_rt_amt");
  			if(prcProgStsCd != "A") { //for only accept
  				continue;
  			}
  			if(ComNullToZero(cofferFrtRtAmt) == 0) { //Resetting final and rollbacking to initial status in case of no Counter Offer amount
  				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","I");
  				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
  			} else { //Resetting final and rollbacking to Return status in case of Counter Offer amount
  				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","R");
 				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
  			}

		if (sheetObj.GetCellValue(trgtArr[i], "rat_ut_cd")==""){
			sheetObj.SetCellValue(trgtArr[i], "rat_ut_cd",sheetObj.GetCellValue(trgtArr[i], "per_type"),0);
   			}   			
  		}
  		var sParam=FormQueryString(formObj);
		var sParamSheet=sheetObj.GetSaveString(false);
		if(sParamSheet == "") {
			var topRow=sheetObj.GetTopRow();
			var lastRow=sheetObj.LastRow();
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("fnl_frt_rt_amt"));
				sheetObj.ReturnCellData(i, sheetObj.SaveNameCol("prc_prog_sts_cd"));
			}
			return false;
		}
		sParam=sParam + "&" + sParamSheet;
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_05GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
 		return true;
  	}
  	/**
     * Amending selected row <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendRow(sheetObjects[0], document.form, Row, "M")
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory ,amend or delete amend 
     * @return boolean
     * 		true  : success
     * 		false : error
     * @author 
     * @version 2009.05.22
     */
	function amendRow(sheetObj, formObj, sRow, sAction) {
		var prop_no=formObj.prop_no.value;
		var amdt_seq=formObj.amdt_seq.value;
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var pre_exp_dt=formObj.pre_exp_dt.value;
		var dur_dup_flg=formObj.dur_dup_flg.value;
		var sColNames="rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|" +
		"bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt"
		sheetObj.SetCellValue(sRow,"chk",0);
		// except already amended row
		if(sheetObj.GetCellValue(sRow,"amdt_seq") != amdt_seq || sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq") == amdt_seq) {
			ComShowCodeMessage("PRI01011");		
		 	return false;
		}
		// Setting sRow to set base row for DataCopy/ Insert
		sheetObj.SetSelectRow(sRow);
		var amdRow=sheetObj.DataCopy();	   // new row
		var preRow=amdRow-1;  				   // old row
		sheetObj.SetCellValue(amdRow,"coffr_frt_rt_amt","",0);
		sheetObj.SetCellValue(amdRow,"fnl_frt_rt_amt","",0);
		sheetObj.SetCellValue(amdRow,"eff_dt",eff_dt,0);
		sheetObj.SetCellValue(amdRow,"n1st_cmnc_amdt_seq",amdt_seq,0);
		sheetObj.SetCellValue(amdRow,"prc_prog_sts_cd","I",0);
//		sheetObj.CellValue2(amdRow,"ibflag") = "U";
		sheetObj.SetRowStatus(amdRow,"U");
		if(sAction == "M") { //Amend
			sheetObj.SetCellValue(amdRow, "src_info_cd","AM",0);
			sheetObj.SetCellValue(amdRow, "prop_frt_rt_amt",0,0);//initializing Proposal Rate to 0
			setGetRowEditable(sheetObj, amdRow, true, "chk|"+sColNames); //Madking Amend Row be able to modify
		} else if(sAction == "D") { //Delete Amend
			sheetObj.SetCellValue(amdRow, "src_info_cd","AD",0);
			sheetObj.SetCellValue(amdRow, "rat_ut_cd",sheetObj.GetCellValue(amdRow, "per_type"),0);
			setGetRowEditable(sheetObj, amdRow, true, "chk"); //Changing editable for chk item
		}
		sheetObj.SetCellFont("FontColor", amdRow, 1, amdRow, sheetObj.LastCol(),"#FF0000");
		sheetObj.SetCellFont("FontStrike", preRow, 1, preRow, sheetObj.LastCol(), true);
		sheetObj.SetCellValue(preRow,"amdt_seq",pre_amdt_seq,0);
		if(dur_dup_flg=="Y") {
			sheetObj.SetCellValue(preRow,"exp_dt",pre_exp_dt,0);
		}
//		sheetObj.CellValue2(preRow,"ibflag") = "R";
		sheetObj.SetRowStatus(preRow,"R");
		setGetRowEditable(sheetObj, preRow, false, "chk|"+sColNames);
//		 changeSelectBackColor(sheetObj, sheetObj.GetCellValue(amdRow, "n1st_cmnc_amdt_seq"), amdt_seq);
		return true;
	}
	/**
     * Canceling amendment of selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendCancelRow(sheetObjects[0], document.form, Row, "M")
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory, amend, delete amend 
     * @return boolean
     * 		true  : success
     * 		false : error
     * @author 
     * @version 2009.05.22
     */
	function amendCancelRow(sheetObj, formObj, sRow, sAction) {
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var amdt_seq=formObj.amdt_seq.value;
		var dur_dup_flg=formObj.dur_dup_flg.value;
		sheetObj.SetCellValue(sRow,"chk",0);
		// 	handling A/M/D equally in case of n1st_cmnc_amdt_seq == amdt_seq
		if(sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq") != amdt_seq
				|| (sheetObj.GetCellValue(sRow,"src_info_cd") != "AD"
					&& sheetObj.GetCellValue(sRow,"src_info_cd") != "AM")
					||	sheetObj.GetCellValue(sRow,"prc_prog_sts_cd")!= "I") {
			ComShowCodeMessage("PRI00313");		
		 	return false;
		}
		// Checking whether group location is valid or not when canceling DELETEd AMENDment
		if(sheetObj.GetCellValue(sRow, "src_info_cd") == "AD" && !checkGroupLocationExist(sheetObj, formObj, sRow)) {
			ComShowCodeMessage("PRI01127", "[LOC Group]");
			return false;
		}
		var preRow=sRow-1;
		var amdRow=sRow;
		sheetObj.SetCellFont("FontStrike", preRow, 1, preRow, sheetObj.LastCol(), false);
		sheetObj.SetCellFont("FontItalic", preRow, 1, preRow, sheetObj.LastCol(),0);
		sheetObj.SetCellValue(preRow,"amdt_seq",sheetObj.GetCellValue(amdRow,"amdt_seq"),0);
		sheetObj.SetCellEditable(preRow, "chk",1);
		if(dur_dup_flg == "Y") {
			sheetObj.SetCellValue(preRow,"exp_dt",exp_dt,0);
		}
		if (sheetObj.GetCellValue(preRow, "rat_ut_cd") == ""){
			sheetObj.SetCellValue(preRow, "rat_ut_cd",sheetObj.GetCellValue(preRow, "per_type"));
		}		
		if(sheetObj.CellSearchValue(amdRow, "amdt_seq") != unescape("%00")) {
			sheetObj.SetRowStatus(preRow,"U");
		}
		sheetObj.RowDelete(amdRow, false);
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(preRow, "n1st_cmnc_amdt_seq"), amdt_seq);
		return true;
	}
    /**
     * Function to check whether Group Location is valid <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkGroupLocationExist(sheetObj, formObj, sRow)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param {int} sRow Mandatory ,Cell's Row Index
     * @return N/A
     * @author 
     * @version 2009.05.18
     */ 
    function checkGroupLocationExist(sheetObj, formObj, sRow) {
    	if(sheetObj.GetCellValue(sRow, "bse_port_tp_cd") == "G") {
    		formObj.f_cmd.value=SEARCH17;
    		formObj.cd.value=sheetObj.GetCellValue(sRow, "bse_port_def_cd");
 			var param="&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
 			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 			if(arrData[1] == "") {
 				return false;
 			}
     	}
     	return true;
    }
	/**
     *Function to check whether rout_pnt_loc_tp_cd is valid<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkRoutePointLocation(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function checkRoutePointLocation(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
if (sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "bse_port_def_cd") == Value) {
			ComShowCodeMessage('PRI01078');
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
			sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
			sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
			return false;
		}
		return true;
	}
	/**
     * Function to check whether rcv_de_term_cd is valid<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setTermCode(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function setTermCode(sheetObj, Row, Value) {
if(sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == sheetObj.GetCellValue(Row, "bse_port_def_cd")) {
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
		}
	}
	/**
     * Function to check whether bse_port_def_cd is valid <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkBasePort(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function checkBasePort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
if(sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			ComShowCodeMessage('PRI01020');
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
			sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	/**
     *Function to check whether prc_cgo_tp_cd is valid  <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkPerType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
     function checkPerType(sheetObj, Row, Value) {
 		var validPerClass="A,F,O,Q,S,P";
if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
         	ComShowCodeMessage("PRI08003");
     		sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
         }
 	}
	/**
     *Function to check whether  rat_ut_cd is valid  <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function checkCargoType(sheetObj, Row, Value) {
		var validPerClass="A,F,O,Q,S,P";
var ratUtCd=sheetObj.GetCellValue(Row, "rat_ut_cd");
        if (Value == "AK" && ( ComIsNull(ratUtCd) || validPerClass.indexOf(ratUtCd.charAt(0)) < 0 )) {
             ComShowCodeMessage("PRI08003");
             sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
        }
 	}
	/**
     * function to set sheet's property<br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
 	function setSheetDisplay(sheetObj) {
 		var formObj=document.form;
 		var amdtSeq=formObj.amdt_seq.value;
 		var effDt=formObj.eff_dt.value;
 		var propStsCd=formObj.prop_sts_cd.value;
 		var aproUsrFlg=form.apro_usr_flg.value;
 		var lgcyIfFlg=form.lgcy_if_flg.value;
 		var sColNames="rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt";
 		var rCnt=sheetObj.RowCount();
 		if(amdtSeq == 0) {
 			for(var i=1; i<=rCnt; i++) {
 				if(propStsCd == "I") { //Initial
if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "I") {
 						sheetObj.SetRowEditable(i,0);
 					}else{
 						sheetObj.SetRowEditable(i,1);
 					}
 				} else if(propStsCd == "Q") { //Request
 					setGetRowEditable(sheetObj, i, false, sColNames);
if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "A" && aproUsrFlg == "true") { //Possible to input c/offer amount in case of approver
 						sheetObj.SetCellEditable(i, "coffr_frt_rt_amt",1);
 					} else {
 						sheetObj.SetCellEditable(i, "coffr_frt_rt_amt",0);
 					}	
 				} else if(propStsCd == "R") { //Return
 					sheetObj.SetRowEditable(i,0);
 				} else {
 					sheetObj.SetRowEditable(i,0);
 				}
 			}
 			return;
 		}
 		for(var i=1 ; i<=rCnt; i++) {
 			if(sheetObj.GetCellValue(i,"amdt_seq") != amdtSeq) { //editable=false
 				sheetObj.SetCellFont("FontStrike", i, "chk", i, "prc_prog_sts_cd", true);
 				//sheetObj.RowEditable(i) = false;
 				setGetRowEditable(sheetObj, i, false, "chk|"+sColNames);
 				continue;
 			}
 			if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq) { //Editable   false : not amended row, true : checked row
 				setGetRowEditable(sheetObj, i, false, sColNames);
 				continue;
 			}
 			if(lgcyIfFlg != "Y") {
 				sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
 			}
// 			if(sheetObj.CellValue(i, "src_info_cd") == "AD"
// 				&& sheetObj.CellValue(i, "prc_prog_sts_cd")!= "I" ) {
// 				setRowEditable(sheetObj, i, false, sColNames);
// 				alert(1)
// 				continue;
// 			}
 			if(sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
 				setGetRowEditable(sheetObj, i, false, sColNames);
 				continue;
 			}	
 			if(propStsCd == "I") { //Initial
 				if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "I") {
 					sheetObj.SetRowEditable(i,0);
 				}else{
 					sheetObj.SetRowEditable(i,1);
 				} 				
 				continue;
 			} else if(propStsCd == "Q") { //Request
 				setGetRowEditable(sheetObj, i, false, sColNames);
 				if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "A"
 					&& aproUsrFlg == "true"
 						&& sheetObj.GetCellValue(i, "src_info_cd") != "AD"	) { //Possible to input c/offer amount in case of approver
 					sheetObj.SetCellEditable(i, "coffr_frt_rt_amt",1);
 				} else {
 					sheetObj.SetCellEditable(i, "coffr_frt_rt_amt",0);
 				}	
 			} else if(propStsCd == "R") { //Return
 				sheetObj.SetRowEditable(i,0);
 			} else {
 				sheetObj.SetRowEditable(i,0);
 			}
 		}
 	}     
//	function setSheetDisplay(sheetObj) {
//		var formObj = document.form;
//		var amdtSeq = formObj.amdt_seq.value;
//		var effDt = formObj.eff_dt.value;
//		var propStsCd = formObj.prop_sts_cd.value;
//		var aproUsrFlg = form.apro_usr_flg.value;
//		var lgcyIfFlg = form.lgcy_if_flg.value;
//		var sColNames = "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt";
//		var rCnt = sheetObj.RowCount;
//		
//		if(amdtSeq == 0) {
//			for(var i=1; i<=rCnt; i++) {
//				if(propStsCd == "I") { //Initial
//					sheetObj.RowEditable(i) = true;
//				} else if(propStsCd == "Q") { //Request
//					setRowEditable(sheetObj, i, false, sColNames);
//					if(sheetObj.CellValue(i, "prc_prog_sts_cd") != "A" && aproUsrFlg == "true") { //Possible to input c/offer amount in case of approver
//						sheetObj.CellEditable(i, "coffr_frt_rt_amt") = true;
//					} else {
//						sheetObj.CellEditable(i, "coffr_frt_rt_amt") = false;
//					}	
//				} else if(propStsCd == "R") { //Return
//					sheetObj.RowEditable(i) = false;
//				} else {
//					sheetObj.RowEditable(i) = false;
//				}
//			}
//			return;
//		}
//		
//		for(var i=1 ; i<=rCnt; i++) {
//			if(sheetObj.CellValue(i,"amdt_seq") != amdtSeq) { //not editable
//				sheetObj.CellFont("FontStrike", i, "chk", i, "prc_prog_sts_cd", true);
//				//sheetObj.RowEditable(i) = false;
//				setRowEditable(sheetObj, i, false, "chk|"+sColNames);
//				continue;
//			}
//			if(sheetObj.CellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq) { ///Editable   false : not amended row, true : checked row
//				setRowEditable(sheetObj, i, false, sColNames);
//				continue;
//			}
//			if(lgcyIfFlg != "Y") {
//				sheetObj.CellFont("FontColor", i, "chk", i, sheetObj.LastCol) = "#FF0000"; //
//			}
//			if(sheetObj.CellValue(i, "src_info_cd") == "AD") {
//				setRowEditable(sheetObj, i, false, sColNames);
//				continue;
//			}
//			
//			if(propStsCd == "I") { //Initial
//				continue;
//			} else if(propStsCd == "Q") { //Request
//				setRowEditable(sheetObj, i, false, sColNames);
//				if(sheetObj.CellValue(i, "prc_prog_sts_cd") != "A" && aproUsrFlg == "true") { //Possible to input c/offer amount in case of approver
//					sheetObj.CellEditable(i, "coffr_frt_rt_amt") = true;
//				} else {
//					sheetObj.CellEditable(i, "coffr_frt_rt_amt") = false;
//				}	
//			} else if(propStsCd == "R") { //Return
//				sheetObj.RowEditable(i) = false;
//			} else {
//				sheetObj.RowEditable(i) = false;
//			}
//		}
//	}
	/**
     * Setting editable for specific columns<br>
     * <br><b>Example :</b>
     * <pre>
     *    setRowEditable(sheetObj, i, false, "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (int) Row Mandatory selection한 Row Index
     * @param (boolean) isEdit Mandatory editablt
     * @param (String) sColNames Mandatory editable setting column name list
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function setGetRowEditable(sheetObj, Row, isEdit, sColNames) {
		var arrColNames=sColNames.split("|");
		var colCnt=arrColNames.length;
		for(i=0; i<=colCnt; i++) {
			sheetObj.SetCellEditable(Row, arrColNames[i],isEdit);
		}
	}
	/**
     * Getting org_dest_tp_cd's value<br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 
     * @version 2009.05.22
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}
	/**
     * Calling function in case of clicking tabl on parent screen <br>
     * <br><b>Example :</b>
     * <pre>
     *		tabLoadSheet("ACE", "1", "ACE", 0, "I", "20090101", "20091230", "20090601", "true", "true")
     * </pre>
     * @param {string} sPropNo Mandatory prop_no
     * @param {string} sAmdtSeq Mandatory amdt_seq
     * @param {string} sSvcScpCd Mandatory svc_scp_cd
     * @param {string} sPreAmdtSeq Mandatory pre_amdt_seq
     * @param {string} sPropStsCd Mandatory pro_sts_cd
     * @param {string} sEffDt Mandatory eff_dt
     * @param {string} sExpDt Mandatory exp_dt
     * @param {string} sPreExpDt Mandatory pre_exp_dt
     * @param (string) sIsReqUsr Mandatory req_usr_flg
     * @param (string) sIsAproUsr Mandatory apro_usr_flg
     * @param (string) sDurDupFlg Mandatory dur_dup_flg
     * @return (String)
     * @author 
     * @version 2009.05.22
     */
 	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
		var formObj=document.form;
		if(formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd || formObj.pre_amdt_seq.value != sPreAmdtSeq ||
			formObj.prop_sts_cd.value != sPropStsCd || formObj.eff_dt.value != sEffDt || formObj.pre_exp_dt.value != sPreExpDt || formObj.exp_dt.value != sExpDt) {
			formObj.prop_no.value=sPropNo;
			formObj.amdt_seq.value=sAmdtSeq;
			formObj.svc_scp_cd.value=sSvcScpCd;
			formObj.pre_amdt_seq.value=sPreAmdtSeq;
			formObj.prop_sts_cd.value=sPropStsCd;
			formObj.eff_dt.value=sEffDt;
			formObj.exp_dt.value=sExpDt;
			formObj.pre_exp_dt.value=sPreExpDt;
			formObj.req_usr_flg.value=sIsReqUsr ;
			formObj.apro_usr_flg.value=sIsAproUsr;
	 		formObj.dur_dup_flg.value=sDurDupFlg ;
			formObj.lgcy_if_flg.value=sLgcyIfFlg;
			buttonControl();
			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC04); //setting Radio Button Default
			if(sSvcScpCd == "TAE") {
 				formObj.org_dest_tp_cd[0].disabled=true;
 				formObj.org_dest_tp_cd[1].checked=true;
 			} else {
 				formObj.org_dest_tp_cd[0].disabled=false;
 			}
			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC03); //setting Term
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}
 	/**
     * Clearing tab screen's controls<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		formObject.pre_amdt_seq.value="";
		formObject.eff_dt.value="";
		formObject.exp_dt.value="";
		formObject.pre_exp_dt.value="";
		sheetObjects[0].RemoveAll();
	}     
	var enableFlag=true;
	/**
     * calling funciton from main <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from main screen
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;	
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
     * Validating location code  <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return N/A
     * @author 
     * @version 2009.05.22
     */ 
	function checkLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj=document.form;
		var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
		// Location
		if(locCd.length == 5 && isLoc) {
			formObj.f_cmd.value=SEARCH05; 	    			
			formObj.cd.value=locCd;
			 var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if(arrDesc != null && arrDesc.length > 0) {
				sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
				if(cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm",arrDesc[0][1],0);
				}
			}else{	
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				if(cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
				}
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		} 
		// Group Location
		else if(locCd.length == 4 && isGrpLoc) {
 			formObj.f_cmd.value=SEARCH17;
 			formObj.cd.value=locCd;
 			var param="&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if(arrData[1] != "") {
				sheetObj.SetCellValue(Row, cellTpCdNm, "G", 0);
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row,cellDefCdNm);
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			if(cellDefCdNm == "rout_pnt_loc_def_cd") {
				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
			}
			sheetObj.SelectCell(Row, cellDefCdNm);
 		}
	}
	/**
     * Re-setting location code <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.SetCellValue(Row, cellTpCdNm,"",0);
		sheetObj.SetCellValue(Row, cellDefCdNm,"",0);
	}
	/**
	 *  changing font's color of TYPE RADIO button <br>
     * 1) Blue : ALL ACCEPT<br>
     * 2) Red : AMEND<br>
     * <br><b>Example :</b>
     * <pre>
     * 		setTypeFontStyle(sXml);
     * </pre>
     * @param {object} sXml Mandatory Xml Object
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
     function setTypeFontStyle(sXml) {
     	var arrDesc=ComPriXml2Array(sXml, "org_font_style|dest_font_style");
     	var lgcyIfFlg=form.lgcy_if_flg.value;
 		if (arrDesc != null && arrDesc.length > 0) {
 			if(arrDesc[0][0] == "blue") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color="blue";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color="black";
 				}
 			} else if(arrDesc[0][0] == "red") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd1").style.color="red";
 				} else {
 					document.getElementById("org_dest_tp_cd1").style.color="black";
 				}
 			} else if(arrDesc[0][0] == "bold") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd1").style.color="black";
 			} else {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="";
 				document.getElementById("org_dest_tp_cd1").style.color="black";
 			}
 			if(arrDesc[0][1] == "blue") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color="blue";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color="black";
 				}
 			} else if(arrDesc[0][1] == "red") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				if(lgcyIfFlg != "Y") {
 					document.getElementById("org_dest_tp_cd2").style.color="red";
 				} else {
 					document.getElementById("org_dest_tp_cd2").style.color="black";
 				}
 			} else if(arrDesc[0][1] == "bold") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd2").style.color="black";
 			} else {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="";
 				document.getElementById("org_dest_tp_cd2").style.color="black";
 			}
 		}
     }
	/**
     * Modifying Proposal status<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {object} formObj Mandatory Form Object
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
    function setProposalStatusSummary(formObj) {
    	var orgDestTpCd=getOrgDestTpCd();
    	if(orgDestTpCd == "O") {
 			parent.comUpdateProposalStatusSummary("61", formObj.svc_scp_cd.value);
 		} else if(orgDestTpCd == "D") {
 			parent.comUpdateProposalStatusSummary("62", formObj.svc_scp_cd.value);
 		}
    }
    /**
     * Calling function after closing excel popup <br>
     * <br><b>Example :</b>
     * <pre>
     *    reloadExcelCopy()
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.05.22
     */ 
    function reloadExcelCopy() {
    	var formObj=document.form;
    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    	setProposalStatusSummary(formObj); //excel
    }
    /**
     * function to check validaion of Zip code <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkZipCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return N/A
     * @author 
     * @version 2009.05.22
     */ 
    function checkZipCode(sheetObj) {
    	var rCnt=sheetObj.RowCount();
    	for(var i=1; i<=rCnt; i++) {
if(ComIsNull(sheetObj.GetCellValue(i, "loc_grd_cnt_cd")) != ComIsNull(sheetObj.GetCellValue(i, "loc_grd_cd"))) {
    			ComShowCodeMessage('PRI01065','Zip Code','10');
    			return false;
    		}
    	}
    	return true;
    }
    /**
     * Changking org_dest_tp_cd's checked status<br>
     * <br><b>Example :</b>
     * <pre>
     *    returnRadioButton()
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.05.22
     */  
    function returnRadioButton() {
    	var formObj=document.form;
    	if(formObj.org_dest_tp_cd[0].checked) {
			formObj.org_dest_tp_cd[1].checked=true;
		} else if(formObj.org_dest_tp_cd[1].checked) {
			formObj.org_dest_tp_cd[0].checked=true;
		}
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @param (string) sAction Mandatory 
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH: //	
				if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}
				return true;
 				break;
  			case IBSAVE: // 
  				var amdtSeq=formObj.amdt_seq.value;
	  			if(!ComShowCodeConfirm('PRI00001')) {
	     			return false;
	     		}
	  			if(!sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage("PRI00301");
					return false;
				}
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
  				if(!checkZipCode(sheetObjects[0])) {
  					return false;
  				}
  				if(amdtSeq == 0) {
					var rowM=sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", false);
					if(rowM >= 0) {
						 ComShowCodeMessage("PRI00303", "Sheet", rowM);
					     return false;
				    }	    		
  				} else {
  					var dupRow=ComPriAmendDupCheck(sheetObjects[0], "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", amdtSeq);
  					if(dupRow >= 0) {
  						ComShowCodeMessage("PRI00303", "Sheet", dupRow);
  						return false;
  					}
  				}
  			    // Checking Proposal amount
				for(var i=sheetObj.GetTopRow(); i<=sheetObj.LastRow(); i++) {
					if(sheetObj.GetCellValue(i, "prop_frt_rt_amt") == 0) {
						ComShowCodeMessage("PRI08010", i, 'proposal rate');
						return false;
					}
				}
				return true;
				break;
    		case IBINSERT: // Row Add
    			if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if(sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != form.amdt_seq.value) {
    				ComShowCodeMessage("PRI01002");		
    				return false;
    			}						
    			return true;
    			break;
    		case IBCOPYROW: // Row Copy
    			if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if(sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != form.amdt_seq.value) {
					ComShowCodeMessage("PRI01002");		
					return false;
				}
    			return true;
    			break;
    		case IBDELETE: // Delete
    			if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			return true;
    			break;
    		case IBSEARCH_ASYNC01: //Guideline Copy
    			if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if(sheetObj.RowCount()> 0) {
    				ComShowCodeMessage("PRI01005");
    				return false;
    			}
    			return true;
    			break;
    		case MODIFY01:	//Accept
	    		if(!ComShowCodeConfirm('PRI00008')) {
					return false;
				}
				return true;
				break;
			case MODIFY02:	//Accept Cancel
	    		if(!ComShowCodeConfirm('PRI00009')) {
					return false;
				}
				return true;
				break;
			case MODIFY03: //Accept All
	    		if(!ComShowCodeConfirm('PRI01015')) {
					return false;
				}
				return true;
				break;
			case MODIFY04: //Cancel
	    		if(!ComShowCodeConfirm('PRI01010')) {
					return false;
				}
				return true;
				break;
			case MODIFY05: // Radio Button Click Save
				var amdtSeq=formObj.amdt_seq.value;
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
				if(!checkZipCode(sheetObjects[0])) {
					return false;
				}
				if(amdtSeq == 0) {
					var rowM=sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", false);
					if(rowM >= 0) {
						 ComShowCodeMessage("PRI00303", "Sheet", rowM);
					     return false;
				    }	    		
				} else {
					var dupRow=ComPriAmendDupCheck(sheetObjects[0], "rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|loc_grd_cnt_cd|loc_grd_cd|prc_trsp_mod_cd|rcv_de_term_cd|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd", amdtSeq);
					if(dupRow >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", dupRow);
						return false;
					}
				}
			   // Checking Proposal amount
				for(var i=sheetObj.GetTopRow(); i<=sheetObj.LastRow(); i++) {
					if(sheetObj.GetCellValue(i, "prop_frt_rt_amt") == 0) {
						ComShowCodeMessage("PRI08010", i, 'proposal rate');
						return false;
					}
				}
				return true;
				break;
			case IBLOADEXCEL:
				if(sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage('PRI01057');
					return false;
				}
				return true;
				break;
		}
		return true;
	}
	/**
     * controlling button <br>
     * <br><b>Example :</b>
     * <pre>
     * 		buttonControl()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.05.22
     */
  	function buttonControl(){
 		var formObj=document.form;
 		var req_usr_flg=formObj.req_usr_flg.value;
 		var apro_usr_flg=formObj.apro_usr_flg.value;
 		var amdt_seq=formObj.amdt_seq.value;
 		var sts=formObj.prop_sts_cd.value;
 		var row_cnt=sheetObjects[0].RowCount();
 		try {			
 			ComBtnEnable("btn_Retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_acceptall");
			ComBtnDisable("btn_cancelall");
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowcopy");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_accept");
			ComBtnDisable("btn_acceptcancel");
			ComBtnDisable("btn_downexcel");
			ComBtnDisable("btn_loadexcel");
			if(amdt_seq > 0){
				showButton("btn_amend");
				showButton("btn_amendcancel");
				ComBtnDisable("btn_amendcancel");
				ComBtnDisable("btn_amend");
			} else {
				hiddenButton("btn_amend");
				hiddenButton("btn_amendcancel");
			}
 			switch (sts) {
 				case 'I':   // Initial
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
 						ComBtnEnable("btn_save");
 						ComBtnEnable("btn_downexcel");
 						ComBtnEnable("btn_loadexcel");
 						ComBtnEnable("btn_rowadd");
 						ComBtnEnable("btn_rowcopy");
 						ComBtnEnable("btn_delete");
 						ComBtnEnable("btn_amend");
 						ComBtnEnable("btn_amendcancel");
 					}				
 					break;
 				case 'Q':   // Requested
 					if(apro_usr_flg == "true" ){
 						ComBtnEnable("btn_save");
 						ComBtnEnable("btn_acceptall");
 						ComBtnEnable("btn_cancelall");
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 						ComBtnDisable("btn_amend");
						ComBtnDisable("btn_amendcancel");
 					}
 					break;
 				case 'R':   // Returned
 				if(apro_usr_flg == "true") {
						ComBtnEnable("btn_acceptall");
						ComBtnEnable("btn_cancelall");
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					} else if(req_usr_flg == "true") {
						ComBtnEnable("btn_acceptall");
						ComBtnEnable("btn_accept");
					}
 					ComBtnDisable("btn_amend");
 					ComBtnDisable("btn_amendcancel");
 					break;
 				case 'A':   // Approved
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ) {
						ComBtnEnable("btn_downexcel");
					}
 				case 'F':   // Filed
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ) {
						ComBtnEnable("btn_downexcel");
					}
 				case 'C':   // Canceled
 					break;		
 			}	
 		} catch (e) {
 			if(e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e.message);
 			}
 		}
 	}
