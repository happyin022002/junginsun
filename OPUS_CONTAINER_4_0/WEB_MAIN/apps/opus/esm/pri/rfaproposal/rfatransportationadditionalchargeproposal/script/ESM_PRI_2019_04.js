/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019_04.js
*@FileTitle  : RFA Proposal Origin/Destination Arbitrary Charge Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
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
 * @class ESM_PRI_2019_04 : Business Script for ESM_PRI_2019_04
 */
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
	var CONFIRM_ORG_GLINE=false; // Whether guideline copied
	var CONFIRM_DEST_GLINE=false; // Whether guideline copied
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
     * @version 2009.10.19
     */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    				break;
    			case "btn_downexcel":
    				if (sheetObject1.RowCount() < 1){//no data
   	        	     ComShowCodeMessage("COM132501");
   	        	    } else{
   	        	    	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL); 
   	        	    }
    				break;
              } // end switch
     	} catch(e) {
     		if( e == "[object Error]") {
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
     * @version 2009.10.19
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
     * @return void
     * @author 
     * @version 2009.10.19
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		//Modify Environment Setting Function's name
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//Add Environment Setting Function
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	resizeSheet();
    	pageOnLoadFinish();
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
     * @version 2009.10.19
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch (sheetID) {
    		case "sheet1":
    		    with(sheetObj){
	    	      var HeadTitle="Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base\nPort|Actual\nCustomer|cust_nm|Per|CGO\nType|Cur.|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|seq|Note|Accept Staff/Team|Accept Date";
	    	      var headCount=ComCountHeadTitle(HeadTitle);
	    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	    	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	      InitHeaders(headers, info);
	    	      var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	    	             {Type:"Text",     Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"rout_pnt_loc_def_cd" },
	    	             {Type:"Text",     Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"rout_pnt_loc_def_nm" },
	    	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_trsp_mod_cd" },
	    	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcv_de_term_cd" },
	    	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	    	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	    	             {Type:"Text",     Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bse_port_def_cd" },
	    	             {Type:"Text",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd" },
	    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_nm" },
	    	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd" },
	    	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd" },
	    	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
	    	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"prop_frt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	    	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"coffr_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	    	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fnl_frt_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
	    	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd" },
	    	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd" },
	    	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd" },
	    	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_cd" },
	    	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"note_dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"add_chg_note_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	    	             {Type:"Text", 		Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"acpt_usr_nm" },
	    	             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" } ];
	    	      InitColumns(cols);
	    	      SetEditable(0);
	    	      SetWaitImageVisible(0);
	    	      SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
	    	      SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
	    	      SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
	    	      SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
	    	      SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
	    	      SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
	    	      //SetAutoRowHeight(0);
	    	      resizeSheet(); //SetSheetHeight(290);
	    	      }
    		break;
    	}
    }
    
	function resizeSheet() {
	    ComResizeSheet(sheetObjects[0]);
	}
    /**
	 * Loading HTML control's event on page dynamically<br>
	 * <br><b>Example :</b>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.10.19
	 */
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="/";
 		// Process Axon Event No.1, Event Catch 
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	/**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.19
     */
	function obj_click(){
		var formObject=document.form;
		if (event.srcElement.name == "org_dest_tp_cd") {
     		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
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
     * @version 2009.10.19
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	     	case IBSEARCH:
	     		ComOpenWait(true);	
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		formObj.f_cmd.value=SEARCH01;
	     		sheetObj.DoSearch("ESM_PRI_2019_04GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
	     		break;
	     		
			case IBSEARCH_ASYNC02: // Retrieving font type 
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2019_04GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
				break;	
				
			case IBSEARCH_ASYNC03: //
				formObj.f_cmd.value=SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02070";
				} else {
					formObj.cd.value="CD02071";
				}
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
				
			case IBSEARCH_ASYNC04:
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2019_04GS.do", FormQueryString(formObj));
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
				
			case IBSEARCH_ASYNC05:
				formObj.f_cmd.value=COMMAND28;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObj,sXml,"cust_cnt_cd",true,0,"","",true);
				break;
				
			case IBDOWNEXCEL:
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
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
     * @version 2009.10.19
     */
     function sheet1_OnSearchEnd(sheetObj, errMsg)  {
   		if (errMsg == "") {
   			var formObj=document.form;
  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC02);
  		}
    } 
     /**
      * It calls when OnClick event triggered on sheet1 <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
      * @param {int} Row mandatory Onclick ,Cell's Row Index
      * @param {int} Col mandatory Onclick ,Cell's Column Index
      * @param {string} Value Mandatory Value
      * @returns void
      * @author 
      * @version 20015.10.29
      */
 	function sheet1_OnClick(sheetObj, Row, Col, Value) {
 		//Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
 		var colname=sheetObj.ColSaveName(Col);
 		switch (colname) {
 			case "add_chg_note_ctnt":
 				ComShowMemoPad(sheetObj, Row, Col, true, null, null, null,1);
 				break;
                 break;
 		}
 	}
    /**
     * Calling function in case of OnMouseMove event<br>
     * Show the Tool Tip. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {int} Button Mandatory Mouse Button 1:Left, 2:Right
     * @param {int} Shift Mandatory Shift key pressed : 1, Ctrl key pressed : 2, ETC : 0
     * @param (Long) X Mandatory X 
     * @param (Long) Y Mandatory Y 
     * @return void
     * @author 
     * @version 2009.10.19
     */ 
    function sheet1_OnMouseMove(Button, Shift, X, Y) {
    	var sheetObj=sheetObjects[0];
    	if(sheetObj.MouseRow()> 1 && sheetObj.MouseCol()== 8) {
    	} else {
    	}
    }
 	/**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	initControl();
    	parent.loadTabPage();
    }
    /**
     * Getting org_dest_tp_cd's value<br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 
     * @version 2009.10.19
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}
	/**
     * Calling function in case of clicking tabl on parent screen <br>
     * It shows screen and process retrieve <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabLoadSheet("SHA090012", "1", "ACE")
     * </pre>
     * @param {string} sPropNo Mandatory prop_no 
     * @param {string} sAmdtSeq Mandatory amdt_seq 
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @return void
     * @author 
     * @version 2009.10.19
     */ 		    	
 	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd) {
		var formObj=document.form;
		if(formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd) {
			formObj.prop_no.value=sPropNo;
			formObj.amdt_seq.value=sAmdtSeq;
			formObj.svc_scp_cd.value=sSvcScpCd;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC04); // Setting Radio Button Default
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03); //Term
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}
	/**
     * Function to clear control of tab screen on parent <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.19
     */ 		 
 	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		sheetObjects[0].RemoveAll();
	}
	var enableFlag=true;
	/**
     * Calling function from main<br>
     * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from Main screen
     * @return void
     * @author 
     * @version 2009.10.19
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;	
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
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
     * @return void
     * @author 
     * @version 2009.10.19
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH: // retrieving			
				if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}
				return true;
 				break;
		}
		return true;
	}
	/**
	 *  changing font's color of TYPE RADIO button <br>
     * 1) Blue : ALL ACCEPT<br>
     * 2) Red : Amendment<br>
     * <br><b>Example :</b>
     * <pre>
     * 		setTypeFontStyle(sXml);
     * </pre>
     * @param {object} sXml Mandatory Xml Object
     * @return void
     * @author 
     * @version 2009.10.19
     */
	function setTypeFontStyle(sXml) {
    	var arrDesc=ComPriXml2Array(sXml, "org_font_style|dest_font_style");
 		if (arrDesc != null && arrDesc.length > 0) {
 			if(arrDesc[0][0] == "blue" || arrDesc[0][0] == "red" || arrDesc[0][0] == "bold") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 			} else {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="";
 			}
 			if(arrDesc[0][1] == "blue" || arrDesc[0][1] == "red" || arrDesc[0][1] == "bold") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 			} else {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="";
 			}
 		}
	}
