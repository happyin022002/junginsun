/*=========================================================
* * 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_06.js
*@FileTitle  :  S/C Proposal & Amendment   GOH Creation/amendment Screen
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04

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
     * @class ESM_PRI_0003_06 : Business Script for ESM_PRI_0003_06
     */
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var CONFIRM_GLINE=false; // Whether guideline copied
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
     * @version 2009.05.26
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
    			case "btn_glinecopy":
   	  				confirmGuidelineCopy(sheetObject1, document.form);
    				break;
    			case "btn_rowadd":	//Row Add
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
     * @version 2009.05.26
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
     * @version 2009.05.26
     */
    function loadPage() {
    	
    	for(i=0;i<sheetObjects.length;i++){
    		//Modify Environment Setting Function's name
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		//Add Environment Setting Function
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	resizeSheet(); //
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
     * @version 2009.05.26
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch (sheetID) {
    		case "sheet1":
    		    with(sheetObj){
    	        
    	      var HeadTitle="|Sel.|Seq.|Type|Point|Description|Bar Type|Per|Currency|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status||||||per_type";

    	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1, ComboMaxHeight:170 } );

    	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
    	      InitHeaders(headers, info);

    	      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    	             {Type:"DummyCheck", 	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
    	             {Type:"Seq",       	Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
    	             {Type:"Combo",     	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"PopupEdit", 	Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:5 },
    	             {Type:"Text",      	Hidden:0, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Combo",     	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_hngr_bar_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Combo",     	Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Combo",     	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Float",     	Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
    	             {Type:"Float",     	Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
    	             {Type:"Float",     	Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Date",      	Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Date",      	Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Combo",     	Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Combo",     	Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"goh_chg_seq" },
    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"per_type" } ];
    	       
    	      InitColumns(cols);

    	      SetEditable(1);
    	      SetWaitImageVisible(0);
    	      SetColProperty("prc_hngr_bar_tp_cd", {ComboText:prcHngrBarTpCdText, ComboCode:prcHngrBarTpCdValue} );
    	      SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
    	      SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
    	      SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
    	      SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
    	      SetColProperty(0 ,"rout_pnt_loc_def_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
    	      
    	      //SetAutoRowHeight(0);
    	      resizeSheet(); //SetSheetHeight(280);
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
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @returns void
     * @author 
     * @version 2009.05.26
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var colName=sheetObj.ColSaveName(Col);
    	var formObj=document.form;

 		if (colName == "rout_pnt_loc_def_cd") { //Point
 			var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd="+ PRI_SP_SCP +"&location_cmd=LC&loc_tp_cd="+sheetObj.GetCellValue(Row, "rout_pnt_loc_tp_cd")+"&prop_no="+ formObj.prop_no.value +"&amdt_seq="+ formObj.amdt_seq.value +"&svc_scp_cd="+ formObj.svc_scp_cd.value;
 			ComOpenPopup(sUrl, 700, 310, "callBack_RoutPntLocDefCd", "none", true);
 		} 
    }
    
    function callBack_RoutPntLocDefCd(rtnVal) {
    	var sheetObj=sheet1;	
    	if (rtnVal != null){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "rout_pnt_loc_def_nm",rtnVal.nm,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "rout_pnt_loc_tp_cd",rtnVal.tp,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "rout_pnt_loc_def_cd",rtnVal.cd,1);
		}
    }
    /**
     * calling function in case of OnSelectCell event <br>
     * Displaying different highlight color at Amend Row<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory, ,current selected cell's Row Index
     * @param {int} NewCol Mandatory, ,current selected cell's Column Index
     * @return void
     * @author 
     * @version 2009.05.26
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }
    /**
	 * Calling funciton in case of OnChange event on sheet1<br>
	 * when selecting multi comboBox, showing description and retrieveing validation <br>
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
	 * @version 2009.05.26
	 */   
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		switch(sName) {
			case "rout_pnt_loc_def_cd":
				checkLocationCode(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd');
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
		} 
		var propStsCd=formObj.prop_sts_cd.value;
		var amdt_seq=formObj.amdt_seq.value;
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
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {string} ErrMsg mandatory from server
	 * @return void
	 * @author 
	 * @version 2009.05.26
	 */
  	function sheet1_OnSearchEnd(sheetObj, errMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
  			var formObj=document.form;
  			var propStsCd=formObj.prop_sts_cd.value;
  			var rCnt=sheetObj.RowCount();
  			if(formObj.f_cmd.value == SEARCH01) {
	  			setSheetDisplay(sheetObj);
	  			buttonControl();
  			}
 		}
 	} 
  	
  	/**
     * retrive data after saving <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {Object} Form Object
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} result after save
     * @return void
     * @author 
     * @version 2014.12.26
     */
  	function searchAfterSave(formObj, sheetObj, sXml) {
  		if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
  			ComPriSaveCompleted();
			var formObj=document.form;
			setSheetDisplay(sheetObj);
			setProposalStatusSummary(formObj);
			if(formObj.f_cmd.value == MULTI02) { // After copying guideline, Retrieve again
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				ComShowCodeMessage('PRI01017');
			}
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
     * @version 2009.05.26
     */  
    function pageOnLoadFinish() {
    	buttonControl();
    	sheetObjects[0].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE1[1] , ComboCode:LOCATION_TYPE1[0]} );
     	parent.loadTabPage();
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
     * @version 2009.05.26
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
	     	case IBSEARCH:  //Retrieve
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		formObj.f_cmd.value=SEARCH01;
	     		sheetObj.DoSearch("ESM_PRI_0003_06GS.do", FormQueryString(formObj), {Sync:2} );
				ComOpenWait(false);
	     		break;
	     	case IBSAVE:    // Save
	     		ComOpenWait(true);
	     		if(!enableFlag || !validateForm(sheetObj,formObj,sAction)) {
	     			ComOpenWait(false);
	     			return false;
	     		}
	     		formObj.f_cmd.value=MULTI01;
	     		var sParam=FormQueryString(formObj);
				var sParamSheet1=sheetObj.GetSaveString();
				sParam += "&" + sParamSheet1;
				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_06GS.do", sParam);
				//sheetObj.LoadSaveData(sXml);
				searchAfterSave(formObj, sheetObj, sXml);
				ComOpenWait(false);
				doActionIBSheet( sheetObj , formObj , IBSEARCH );
	     		break;
	     	case IBSEARCH_ASYNC01: //Guideline copy
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,document.form,sAction)) {
	     			ComOpenWait(false);
	     			return false;
				}
	     		formObj.f_cmd.value=SEARCH02;
	     		var sXml=sheetObj.GetSearchData("ESM_PRI_0003_06GS.do", FormQueryString(formObj));
	     		//sheetObj.LoadSaveData(sXml);
				if(ComGetEtcData(sXml, "FLAG") == "Y") {
		     		formObj.f_cmd.value=MULTI02;
		     		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_06GS.do", FormQueryString(formObj));
		     		//sheetObj.LoadSaveData(sXml);
		     		searchAfterSave(formObj, sheetObj, sXml);
		     		
	     		}
	     		ComOpenWait(false);
				break;		
			case IBINSERT:	//Row Add
				if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				var amdt_seq=formObj.amdt_seq.value;
				var idx=sheetObj.DataInsert();
				sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
				sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
				sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq);
				sheetObj.SetCellValue(idx, "goh_chg_seq",parseInt(ComPriGetMax(sheetObj, "goh_chg_seq")) + 1);
				sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
				sheetObj.SetCellValue(idx, "src_info_cd","NW");
				sheetObj.SetCellValue(idx, "curr_cd","USD");
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
				setGetRowEditable(sheetObj, idx, true, "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|prc_hngr_bar_tp_cd|rat_ut_cd|curr_cd|prop_frt_rt_amt");
				sheetObj.SetCellValue(idx, "chk",0);
				sheetObj.SetCellValue(idx, "goh_chg_seq",parseInt(ComPriGetMax(sheetObj, "goh_chg_seq")) + 1);
				sheetObj.SetCellValue(idx, "coffr_frt_rt_amt","");
				sheetObj.SetCellValue(idx, "fnl_frt_rt_amt","");
				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq);
				sheetObj.SetCellValue(idx, "src_info_cd","NW");
				sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
				if(amdt_seq != 0) {
					sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
				}
				break;
			case IBDELETE: // Delete
				if(!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				var amdt_seq=formObj.amdt_seq.value;
				if(amdt_seq == "0") {
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
					if(chkArr.length > 0){
						for(var i=0;i < chkArr.length;i++){
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
						for(var j=0;j < chkArr.length;j++){
							if(sheetObj.GetCellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq") != amdt_seq) {
								amendRow(sheetObj, formObj, chkArr[j]+sRow, "D");		
								sRow++;								
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
									|| sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd") !="I"	) {
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
				//2015.05.21 ADD
				setProposalStatusSummary(formObj);
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
				//2015.05.21 ADD
				setProposalStatusSummary(formObj);
				ComOpenWait(false);
				break;
			case COMMAND01:	//Amend
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0){
					if(chkArr.length > 1){					
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
				if(chkArr.length > 0){
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					} else {
						amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M");
					}
				} else { 
					amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M");
				}
				break;					
		}
	}
	/**
     * Validating location code  <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.05.26
     */ 
	function checkLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		var formObj=document.form;
		var locCd=sheetObj.GetCellValue(Row, cellDefCdNm).toUpperCase();
		sheetObj.SetCellValue(Row, cellDefCdNm, locCd, 0);
		// Location
		if(locCd.length == 5) {
			
//			formObj.f_cmd.value=SEARCH05; 	    			
//			formObj.cd.value=locCd;
//			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
//			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
//			if(arrDesc != null && arrDesc.length > 0) {
//				sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
//				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm",arrDesc[0][1],0);
//			} else {	
//				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
//				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
//				sheetObj.SelectCell(Row, cellDefCdNm);
//			}

			formObj.f_cmd.value=COMMAND31; 	    			
			formObj.cd.value=locCd;
			var sParam=FormQueryString(formObj)+"&etc1=B";
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
			if(arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm",arrData[0][1],0);
			} else {	
				ComShowCodeMessage("PRI01137");
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
				sheetObj.SelectCell(Row, cellDefCdNm, 0);
			}
			
		} 
		// Country
		else if(locCd.length == 2) {
// 			formObj.f_cmd.value=SEARCH07;
// 			formObj.cd.value=locCd;  	  
// 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
//			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
//			if(arrData[1] != "") {
//				sheetObj.SetCellValue(Row, cellTpCdNm, "C");
//				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm",arrData[1],0);
//			} else {				 
//				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
//				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
//				sheetObj.SetCellValue(Row,cellTpCdNm,"");
//				sheetObj.SelectCell(Row, cellDefCdNm);
//			}
			
			
			formObj.f_cmd.value=COMMAND32;
 			formObj.cd.value=locCd;  	  
 			var sParam=FormQueryString(formObj)+"&etc2=B&etc1="+cellTpCdNm;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm");
			if(arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, cellTpCdNm,"C" ,0);
				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm",arrData[0][1],0);
			} else {	
				ComShowCodeMessage("PRI01139", "Country");
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
				sheetObj.SelectCell(Row, cellDefCdNm, 0);
			}
		
			
 		} else {
 			
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			sheetObj.SelectCell(Row, cellDefCdNm, 0);
 		}
	}
	/**
     * Re-setting location code <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.05.26
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.SetCellValue(Row, cellTpCdNm,"",0);
		sheetObj.SetCellValue(Row, cellDefCdNm,"",0);
	}
	/**
     * Check whether guideline copied. <br>
     * <br><b>Example :</b>
     * <pre>
     *    confirmGuidelineCopy(sheetObjects[0], formObj, orgDestTpCd)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {object} formObj Mandatory Form Object
     * @param {string} orgDestTpCd Mandatory origin, destination separate code
     * @return void
     * @author 
     * @version 2009.05.18
     */ 
	function confirmGuidelineCopy(sheetObj, formObj) {
		if(ComShowCodeConfirm('PRI01006')) {
			doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
		}
		CONFIRM_GLINE=true;
	}
	/**
     * setting sheet's attribute function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.05.26
     */
	function setSheetDisplay(sheetObj) {
		var formObj=document.form;
		var amdtSeq=formObj.amdt_seq.value;
		var effDt=formObj.eff_dt.value;
		var propStsCd=formObj.prop_sts_cd.value;
		var aproUsrFlg=form.apro_usr_flg.value;
		var lgcyIfFlg=form.lgcy_if_flg.value;
		var sColNames="rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rout_pnt_loc_def_nm|prc_hngr_bar_tp_cd|rat_ut_cd|curr_cd|prop_frt_rt_amt";
		var rCnt=sheetObj.RowCount();
		if(amdtSeq == 0) {
			for(var i=1; i<=rCnt; i++) {
				if(propStsCd == "I") { //Initial
					if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "I") {
						sheetObj.SetRowEditable(i,0);
					}else{
						if(sheetObj.GetCellValue(i, "via_port_def_cd") != "") {
							sheetObj.SetCellEditable(i, "dir_call_flg",0);
						} else if(sheetObj.GetCellValue(i, "dir_call_flg") == "1") {
							sheetObj.SetCellEditable(i, "via_port_def_cd",0);
						}
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
			if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq) { // Only Amended row is GetEditable()
				//sheetObj.RowEditable(i) = false;
				setGetRowEditable(sheetObj, i, false, sColNames);
				continue;
			}
			if(lgcyIfFlg != "Y") {
				sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
			}
			if(sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
				setGetRowEditable(sheetObj, i, false, sColNames);
				continue;
			}
			if(propStsCd == "I") { //Initial
				if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") != "I") {
					sheetObj.SetRowEditable(i,0);
				}
				continue;
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
	}
	/**
     * Setting editable for specific columns<br>
     * <br><b>Example :</b>
     * <pre>
     *    setRowEditable(sheetObj, i, false, "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (int) Row Mandatory selected Row Index
     * @param (boolean) isEdit Mandatory editablt
     * @param (String) sColNames Mandatory editable setting column name list
     * @return void
     * @author 
     * @version 2009.05.26
     */
	function setGetRowEditable(sheetObj, Row, isEdit, sColNames) {
		var arrColNames=sColNames.split("|");
		var colCnt=arrColNames.length;
		for(i=0; i<=colCnt; i++) {
			sheetObj.SetCellEditable(Row, arrColNames[i],isEdit);
		}
	}
	/**
     * Accepting checked row or selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.26
     */
 	function acceptRows(sheetObj,formObj) {
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
 		for(var i=0; i<chkArr.length; i++) { // showing error message in case of already accepted item
 			// It's previous amendment. 
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
  			//alert(trgtArr[i]+"|"+prcProgStsCd);
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
   			/////////// Input Per_type
  			if (sheetObj.GetCellValue(trgtArr[i], "rat_ut_cd")==""){
  				sheetObj.SetCellValue(trgtArr[i], "rat_ut_cd",sheetObj.GetCellValue(trgtArr[i], "per_type"),0);
   			}  			
  		}
  		/*var sParam=FormQueryString(formObj);
  		sheetObj.DoSave(sUrl, FormQueryString(formObj), -1, false);*/
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
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_06GS.do", sParam);
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
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.26
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
 			if(propStsCd == "Q") { //Input proposal amount into final in case of request 
 				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt"),0);//Approving Sales.Rep's amount
 			}
 			if(propStsCd == "R") { //in case of return status, Input C/Offer amount into final
 				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt"),0);//Approving Counter Offer's amount
 			}
 			sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","A");//Modifying Accept
   			/////////// Input Per_type
 			if (sheetObj.GetCellValue(trgtArr[i], "rat_ut_cd")==""){
 				sheetObj.SetCellValue(trgtArr[i], "rat_ut_cd",sheetObj.GetCellValue(trgtArr[i], "per_type"),0);
   			}   			
 		}
 		/*var sParam=FormQueryString(formObj);
 		sheetObj.DoSave(sUrl, sParam, -1, false);*/
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
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_06GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
 		return true;
 	}
 	/**
     * Canceling acceptance of checked row or selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.26
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
  			// At previous amendment, this row got approved
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
   			/////////// Input Per_type
  			if (sheetObj.GetCellValue(trgtArr[i], "rat_ut_cd")==""){
  				sheetObj.SetCellValue(trgtArr[i], "rat_ut_cd",sheetObj.GetCellValue(trgtArr[i], "per_type"),0);
   			}  	  			
  		}
		/*var sParam=FormQueryString(formObj);
		sheetObj.DoSave(sUrl, sParam, -1, false);*/
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
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_06GS.do", sParam);
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
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.26
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
  			} else { //Resetting final and rollbacking to Return status in case of existing Counter Offer amount
  				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","R");
 				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
  			}
   			/////////// Input Per_type
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
		var sXml=sheetObj.GetSaveData("ESM_PRI_0003_06GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
 		return true;
  	}
  	/**
     * Amending selected row <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendRow(sheetObjects[0], document.form, Row, "M")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory  Whether amend or delete amend
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.26
     */
	function amendRow(sheetObj, formObj, sRow, sAction) {
		var prop_no=formObj.prop_no.value;
		var amdt_seq=formObj.amdt_seq.value;
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var pre_exp_dt=formObj.pre_exp_dt.value;
		var dur_dup_flg=formObj.dur_dup_flg.value;
		var sColNames="rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rout_pnt_loc_def_nm|prc_hngr_bar_tp_cd|rat_ut_cd|curr_cd|prop_frt_rt_amt"
		//Removing check
		sheetObj.SetCellValue(sRow, "chk",0);
		// except already amended row
		if(sheetObj.GetCellValue(sRow,"amdt_seq") != amdt_seq || sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq") == amdt_seq) {
			ComShowCodeMessage("PRI01011");		
		 	return false;
		}
		// Setting sRow to set base row for DataCopy/ Insert
		sheetObj.SetSelectRow(sRow);
		var amdRow=sheetObj.DataCopy();      // new row
		var preRow=amdRow-1;                     // old row
		sheetObj.SetCellValue(amdRow,"coffr_frt_rt_amt","",0);
		sheetObj.SetCellValue(amdRow,"fnl_frt_rt_amt","",0);
		sheetObj.SetCellValue(amdRow,"eff_dt",eff_dt,0);
		sheetObj.SetCellValue(amdRow,"n1st_cmnc_amdt_seq",amdt_seq,0);
		sheetObj.SetCellValue(amdRow,"prc_prog_sts_cd","I",0);
//		sheetObj.CellValue2(amdRow, "ibflag") = "U";
		sheetObj.SetRowStatus(amdRow,"U");
		if(sAction == "M") { //Amend
			sheetObj.SetCellValue(amdRow, "src_info_cd","AM",0);
			sheetObj.SetCellValue(amdRow, "prop_frt_rt_amt",0,0);//initializing Proposal Rate to 0
			setGetRowEditable(sheetObj, amdRow, true, "chk|"+sColNames); //Madking Amend Row be able to modify
		} else if(sAction == "D") { //Delete Amend
			sheetObj.SetCellValue(amdRow, "src_info_cd","AD",0);
			/////////// Input Per_type when per_type is not exist in comboBox
			sheetObj.SetCellValue(amdRow, "rat_ut_cd",sheetObj.GetCellValue(amdRow, "per_type"),0);
			setGetRowEditable(sheetObj, amdRow, true, "chk"); //Changing editable for chk item
		}
		sheetObj.SetCellFont("FontColor", amdRow, 1, amdRow, sheetObj.LastCol(),"#FF0000");
		sheetObj.SetCellFont("FontStrike", preRow, 1, preRow, sheetObj.LastCol(), true);
		sheetObj.SetCellValue(preRow,"amdt_seq",pre_amdt_seq,0);
		if(dur_dup_flg == "Y") {
			sheetObj.SetCellValue(preRow,"exp_dt",pre_exp_dt,0);
		}
		sheetObj.SetRowStatus(preRow,"R");
		setGetRowEditable(sheetObj, preRow, false, "chk|"+sColNames);
		changeSelectBackColor(sheetObj, sheetObj.GetCellValue(amdRow, "n1st_cmnc_amdt_seq"), amdt_seq);
		return true;
	}
	/**
     * Canceling amendment of selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendCancelRow(sheetObjects[0], document.form, Row, "M")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory  Whether amend or delete amend
     * @param (string) sCols Mandatory column index
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.26
     */
	function amendCancelRow(sheetObj, formObj, sRow, sAction) {
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var amdt_seq=formObj.amdt_seq.value;
		var dur_dup_flg=formObj.dur_dup_flg.value;
		sheetObj.SetCellValue(sRow,"chk",0);
		// handling in case of  n1st_cmnc_amdt_seq == amdt_seq in A/M/D
		if(sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq") != amdt_seq
				|| (sheetObj.GetCellValue(sRow,"src_info_cd") != "AD"
					&& sheetObj.GetCellValue(sRow,"src_info_cd") != "AM")
					||	sheetObj.GetCellValue(sRow,"prc_prog_sts_cd")!= "I") {
			ComShowCodeMessage("PRI00313");		
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
		///////////////When PER_TYPE deleted, Input
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
     * Calling function in case of clicking tabl on parent screen <br>
     * It shows screen and process retrieve <br>
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
     * @version 2009.05.26
     */
 	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
		var formObj=document.form;
		if(formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd || formObj.pre_amdt_seq.value != sPreAmdtSeq ||
			formObj.prop_sts_cd.value != sPropStsCd || formObj.eff_dt.value != sEffDt || formObj.pre_exp_dt.value != sPreExpDt || formObj.exp_dt.value != sExpDt) {
			formObj.prop_no.value=sPropNo;
			formObj.svc_scp_cd.value=sSvcScpCd;
			formObj.amdt_seq.value=sAmdtSeq;
			formObj.pre_amdt_seq.value=sPreAmdtSeq;
			formObj.prop_sts_cd.value=sPropStsCd;
			formObj.eff_dt.value=sEffDt;
			formObj.exp_dt.value=sExpDt;
			formObj.pre_exp_dt.value=sPreExpDt;
			formObj.req_usr_flg.value=sIsReqUsr;
			formObj.apro_usr_flg.value=sIsAproUsr;
			formObj.dur_dup_flg.value=sDurDupFlg;
			formObj.lgcy_if_flg.value=sLgcyIfFlg;
			CONFIRM_GLINE=false;
			buttonControl();
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
  			var rCnt=sheetObjects[0].RowCount();
  			if(!CONFIRM_GLINE && rCnt == 0 && sPropStsCd == "I" && (sIsAproUsr || sIsReqUsr)) {
  				confirmGuidelineCopy(sheetObjects[0], formObj);
  			}
		}
	}
 	/**
     * Function to clear control of tab screen on parent <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.05.26
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
     * @version 2009.05.26
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;	
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
     * Controlling button's authority<br>
     * controlling buttons <br>
     * <br><b>Example :</b>
     * <pre>
     * 		buttonControl()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.05.26
     */
     function buttonControl(){
  		var formObj=document.form;
  		var req_usr_flg=formObj.req_usr_flg.value;
  		var apro_usr_flg=formObj.apro_usr_flg.value;
  		var amdt_seq=formObj.amdt_seq.value;
  		var sts=formObj.prop_sts_cd.value;
  		var rCnt=sheetObjects[0].RowCount();
  		try {			
  			ComBtnEnable("btn_Retrieve");
 			ComBtnDisable("btn_save");
 			ComBtnDisable("btn_acceptall");
 			ComBtnDisable("btn_cancelall");
			ComBtnDisable("btn_glinecopy");
 			ComBtnDisable("btn_rowadd");
 			ComBtnDisable("btn_rowcopy");
 			ComBtnDisable("btn_delete");
 			ComBtnDisable("btn_accept");
 			ComBtnDisable("btn_acceptcancel");
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
  					if(apro_usr_flg == "true" || req_usr_flg == "true" ) {
  						ComBtnEnable("btn_save");
  						if(rCnt == 0) {
  							ComBtnEnable("btn_glinecopy");
  						}
  						ComBtnEnable("btn_rowadd");
  						ComBtnEnable("btn_rowcopy");
  						ComBtnEnable("btn_delete");
  						ComBtnEnable("btn_amend");
  						ComBtnEnable("btn_amendcancel");
  					}				
  					break;
  				case 'Q':   // Requested
  					if(apro_usr_flg == "true" ) {
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
  				case 'P':   // Approved
  				case 'F':   // Filed
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
    /**
     * Modifying Proposal status<br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {object} formObj Mandatory Form Object
     * @return void
     * @author 
     * @version 2009.05.26
     */ 
    function setProposalStatusSummary(formObj) {
    	parent.comUpdateProposalStatusSummary("16", formObj.svc_scp_cd.value);
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
     * @version 2009.05.26
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH: // retrieving			
				if(formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}
				return true;
 				break;
  			case IBSAVE: // Saving
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
	  			if(amdtSeq == 0) {
					var rowM=sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rat_ut_cd|prc_hngr_bar_tp_cd|rat_ut_cd|curr_cd", false);
					if(rowM >= 0) {
						 ComShowCodeMessage("PRI00303", "Sheet1", rowM);
					     return false;
				    }	    		
	  			} else {
	  				var dupRow=ComPriAmendDupCheck(sheetObjects[0], "amdt_seq|rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rat_ut_cd|prc_hngr_bar_tp_cd|rat_ut_cd|curr_cd", amdtSeq);
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
    			if(enableFlag == false) {
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
		}
		return true;
	}
