/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003_04.js
*@FileTitle  : RFA Proposal Origin/Destination Arbitrary Charge Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESM_PRI_2003_04 : business script for ESM_PRI_2003_04
 */
    // Common Global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var selctRowCount = 0;
	var CONFIRM_ORG_GLINE=false; // guideline copy 
	var CONFIRM_DEST_GLINE=false; // guideline copy 
    // Event handler processing by button click event
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.07.30
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
    			case "btn_glinecopy":
    				var orgDestTpCd=getOrgDestTpCd();
   	  				confirmGuidelineCopy(sheetObject1, document.form, orgDestTpCd);
    				break;
    			case "btn_downexcel":
    				if (sheetObject1.RowCount() < 1){//no data
   	        	     ComShowCodeMessage("COM132501");
   	        	    } else{
   	        	    	doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
   	        	    }
    				break;
    			case "btn_loadexcel":
//    				if (sheetObject1.RowCount() < 1){//no data
//      	        	     ComShowCodeMessage("COM132501");
//      	        	    } else{
      	        	    	doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
//      	        	    }
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
     			ComShowCodeMessage(e);
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
     * @version 2009.07.30
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
     * @version 2009.07.30
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
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch (sheetID) {
    		case "sheet1":
    		    with(sheetObj){
	    	      var HeadTitle="state|FontType|Sel.|Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base\nPort|Actual\nCustomer|Customer Name|Per|CGO\nType|Cur.|Proposal|C.Offer|Final|EFF Date|EXP Date|Source|Status|seq|Note|note_ctnt_text||||||||pre_note_dp_seq|PER_TYPE";
	    	      var headCount=ComCountHeadTitle(HeadTitle);
	    	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	    	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	    	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	    	      InitHeaders(headers, info);
	    	      var cols = [ {Type:"Status",	Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	    	                   {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tmp_type" },
	    	             {Type:"DummyCheck",	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	    	             {Type:"Seq",       	Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	    	             {Type:"PopupEdit", 	Hidden:0, Width:57,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	    	             {Type:"Text",      	Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Combo",     	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Combo",     	Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Float",     	Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	    	             {Type:"Float",     	Hidden:0, Width:55,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	    	             {Type:"PopupEdit", 	Hidden:0, Width:57,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	    	             {Type:"Combo",     	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Text",      	Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_nm" },
	    	             {Type:"Combo",     	Hidden:0, Width:38,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Combo",     	Hidden:0, Width:38,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	    	             {Type:"Combo",     	Hidden:0, Width:43,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,  DefaultValue:"USD" },
	    	             {Type:"Float",     	Hidden:0, Width:100,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	    	             {Type:"Float",     	Hidden:0, Width:68,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
	    	             {Type:"Float",     	Hidden:0, Width:68,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Date",      	Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Date",      	Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Combo",     	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Combo",     	Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      	Hidden:0, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"note_dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	    	             {Type:"Text",      	Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"add_chg_note_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      	Hidden:1, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_text",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_tp_cd" },
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_seq" },
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" } ,
	    	             {Type:"Text",      	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pre_note_dp_seq" },
	    	             {Type:"Text",          Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"per_type" }
	    	             ];
	    	      InitColumns(cols);
	    	      SetEditable(1);
	    	      SetWaitImageVisible(0);
	    	      SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
	    	      SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
	    	      SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
	    	      SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
	    	      SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
	    	      SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
	    	      SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	    	      SetColProperty(0 ,"bse_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	    	      SetColProperty(0 ,"note_dp_seq" , {AcceptKeys:"[1234567890]"});
	    	      
//	    	      SetAutoRowHeight(0);
	    	      resizeSheet(); //SetSheetHeight(260);
    	      }
    		break;
    		
    		case "sheet2":
//    			with (sheetObj) {
//                InitRowInfo( 1, 1, 3, 100);
//                (1, 0, 0, true);
//                InitHeadRow(0, "", true);
//    			}
    		break;
    	}
    }
    
    function resizeSheet() {
	    ComResizeSheet(sheetObjects[0]);
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
     * @version 2015.10.29
     */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var colname=sheetObj.ColSaveName(Col);
		var propStsCd=formObj.prop_sts_cd.value;
		var amdtSeq=formObj.amdt_seq.value;
		switch (colname) {
			case "add_chg_note_ctnt":
				if(propStsCd == "I" && sheetObj.GetCellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq && sheetObj.GetCellValue(Row, "src_info_cd") != "AD") {
					if (sheetObj.GetCellValue(Row, "prc_prog_sts_cd") == "I"){
						ComShowMemoPad(sheetObj, Row, Col, false, null, null, 1000,1);
					}else{
						ComShowMemoPad(sheetObj, Row, Col, true, null, null, null,1);
					}
				} else {
					ComShowMemoPad(sheetObj, Row, Col, true, null, null, null,1);
				}
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
	 * Calling function in case of OnSelectCell event <br>
     * Setting different hightlight color of Amend Row<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, previous Selected Cell's Row Index
     * @param {int} OldCol Mandatory, previous Selected Cell's Column Index
     * @param {int} NewRow Mandatory, current Selected Cell's Row Index
     * @param {int} NewCol Mandatory, current Selected Cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.07.30
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
        }
    }
        
    /**
     * Calling funciton in case of OnBeforeEdit event <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.05.20
     */ 
    function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
    	var colName=sheetObjects[0].ColSaveName(Col);
    	if (colName == "cust_cnt_cd") { //Actual Customer
    		doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC05);
    	}
    }
    function tmp_object(sheet, row, col){
    	this.sheet = sheet;
		this.row = row;		
		this.col = col;
	}
	var G_TMP_OBJECT;
    /**
	 * sheet1 Calling function in case of OnPopupClick event <br>
	 * Calling popup screen <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.07.30
	 */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var colName=sheetObj.ColSaveName(Col);
    	var formObj=document.form;
    	var propNO=sheetObj.GetCellValue(Row, "prop_no");
    	var amdtSeq=sheetObj.GetCellValue(Row, "amdt_seq");
    	var svcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
    	var tpCd="";
 		if (colName == "rout_pnt_loc_def_cd") { //Point
 			var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd="+ PRI_RP_SCP +"&location_cmd=L&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
 			G_TMP_OBJECT = new tmp_object(sheetObj, Row, Col);
 			ComOpenPopup(sUrl, 700, 310, "callback4026", "1,0,1,1,1,1,1", true);
 			
 		} else if (colName == "bse_port_def_cd") { //Base Point
 			var sUrl="/opuscntr/ESM_PRI_4026.do?group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
 			G_TMP_OBJECT = new tmp_object(sheetObj, Row, Col);
 			ComOpenPopup(sUrl, 700, 310, "callback4026_2", "1,0,1,1,1,1,1", true);
 			
 		} 
    }
    
    function callback4026(rtnVal){
    	var sheetObj = G_TMP_OBJECT.sheet;
    	var Row = G_TMP_OBJECT.row;
    	var Col = G_TMP_OBJECT.col;
    	if(rtnVal != null){
    		if(!checkRoutePointLocation(sheetObj, Row, rtnVal.cd)){
    			return;
    		}
    		sheetObj.SetCellValue(Row, Col,rtnVal.cd,0);
			sheetObj.SetCellValue(Row, Col + 1,rtnVal.nm,0);
			if (rtnVal.cd.length == 5){ //Setting Location Type=
				tpCd="L";
			}
			sheetObj.SetCellValue(Row,"rout_pnt_loc_tp_cd",tpCd ,0);
    	}
    }
    
    function callback4026_2(rtnVal){
    	var sheetObj = G_TMP_OBJECT.sheet;
    	var Row = G_TMP_OBJECT.row;
    	var Col = G_TMP_OBJECT.col;
    	if(rtnVal != null){
    		if(!checkBasePort(sheetObj, Row, rtnVal.cd)){
    			return;
    		}
    		sheetObj.SetCellValue(Row, Col,rtnVal.cd,0);
			if(rtnVal.cd.length == 5) {
				tpCd="L";
			} else if(rtnVal.cd.length == 4) {
				tpCd="G";
			}
			sheetObj.SetCellValue(Row,"bse_port_tp_cd",tpCd ,0);
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
	 * @version 2009.05.19
	 */  	    
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var amdt_seq=formObj.amdt_seq.value;
		switch(sName) {
			case "rout_pnt_loc_def_cd": //point
				if(!checkRoutePointLocation(sheetObj, Row, Value)) {
					return;
				}
				checkLocationCode(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false);
				break;
				
			case "rcv_de_term_cd": //Term
				setTermCode(sheetObj, Row, Value);
				break;
				
			case "bse_port_def_cd": //base port
				if(!checkBasePort(sheetObj, Row, Value)) { //point와 비교
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
				//checkRateAmount(Value);
				break;
				
			case "coffr_frt_rt_amt":
				//checkRateAmount(Value);
				if(sheetObj.GetCellValue(Row, "prop_frt_rt_amt") == Value) {
					ComShowCodeMessage('PRI01044');
					sheetObj.SetCellValue(Row, "coffr_frt_rt_amt","",0);
					sheetObj.SelectCell(Row, "coffr_frt_rt_amt");
					return;
				}
				if(ComNullToZero(Value) == 0) {
					sheetObj.SetCellValue(Row, "prc_prog_sts_cd","I",0);//Changing to Initial
				} else {
					sheetObj.SetCellValue(Row, "prc_prog_sts_cd","R",0);//Changing to Initial
				}
				break;
		}
		var propStsCd=formObj.prop_sts_cd.value;
		if(amdt_seq == 0 && propStsCd == 'I') {
			if(sName != "note_dp_seq"){
				if (sheetObj.GetCellValue(Row, "src_info_cd") == "PC") {
					sheetObj.SetCellValue(Row, "src_info_cd","PM",0);
				} else if (sheetObj.GetCellValue(Row, "src_info_cd") == "GC") {
					sheetObj.SetCellValue(Row, "src_info_cd","GM",0);
				}
			}
		}
    }
	/**
     * function to checking validation of location code<br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm Selected Cell's tp code
     * @param (string) cellDefCdNm Selected Cell's def code
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function checkLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj=document.form;
		var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
		// Location
		if (locCd.length == 5 && isLoc) {
			formObj.f_cmd.value=SEARCH05; 	    			
			formObj.cd.value=locCd;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
				if (cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm",arrDesc[0][1],0);
				}
			} else {	
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				if (cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
				}
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		} 
		// Group Location
		else if (locCd.length == 4 && isGrpLoc) {
			formObj.f_cmd.value=COMMAND24;
			formObj.cd.value=locCd;
			var sParam=FormQueryString(formObj);
			sParam += "&etc1="+PRI_RP_SCP;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","G",0);
			} else {
				sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			if (cellDefCdNm == "rout_pnt_loc_def_cd") {
				sheetObj.SetCellValue(Row,"rout_pnt_loc_def_nm","",0);
			}
			sheetObj.SelectCell(Row, cellDefCdNm);
 		}
	}
	/**
     * Resetting location code<br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm Selected Cell's tp code
     * @param (string) cellDefCdNm Selected Cell's def code
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.SetCellValue(Row, cellTpCdNm,"",0);
		sheetObj.SetCellValue(Row, cellDefCdNm,"",0);
	}
	/**
	 * Loading HTML control's event in page dynamically. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return N/A
     * @author 
     * @version 2009.07.30
	 */
 	function initControl() {
 		//** Date delimitor **/
 		DATE_SEPARATOR="/";
 		axon_event.addListenerForm('click', 'obj_click', form);  
 	}
 	/**
     * Calling function in case of OnClick event <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function obj_click(){
		var formObj=document.form;
		if (ComGetEvent("name") == "org_dest_tp_cd") {
			if(sheetObjects[0].IsDataModified()) {
				if(ComShowCodeConfirm('PRI00006')) {
					if(doActionIBSheet(sheetObjects[0], formObj, MODIFY05)==false){
						if(formObj.org_dest_tp_cd[0].checked) {
							formObj.org_dest_tp_cd[1].checked=true;
						} else if(formObj.org_dest_tp_cd[1].checked) {
							formObj.org_dest_tp_cd[0].checked=true;
						}
						return;
					}
				}else {
					if(formObj.org_dest_tp_cd[0].checked) {
						formObj.org_dest_tp_cd[1].checked=true;
					} else if(formObj.org_dest_tp_cd[1].checked) {
						formObj.org_dest_tp_cd[0].checked=true;
					}
					return;
				}
			}
     		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03); //Term
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			buttonControl();
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
     * @version 2009.07.30
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
	     		//[Strike Font]-----------------------------------------
	     		if(sheetObj.RowCount() > 0){
	     			var sIdx = sheetObj.HeaderRows();
		     		var eIdx = sheetObj.LastRow();
		     		//init FontStrike
		     		for(var j = sIdx; j < eIdx; j++){
						var sVal = sheetObj.GetCellValue(j, "tmp_type");
						if(sVal == "S" || sVal == "C"){
							sheetObj.SetRowEditable(i, 1);
						}
					}
		     		sheetObj.SetCellFont("FontStrike", sIdx,0,eIdx,sheetObj.LastCol(),0);
	     		}
	     		isAllReadyUse = false;
	     		//[Strike Font]-----------------------------------------
	     		formObj.f_cmd.value=SEARCH01;
	     		sheetObj.DoSearch("ESM_PRI_2003_04GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
				break;
				
	     	case IBSEARCH_ASYNC01: //Guideline copy
	     		ComOpenWait(true);
	     		if(!validateForm(sheetObj,document.form,sAction)) {
	     			ComOpenWait(false);
	     			return false;
				}
		     	formObj.f_cmd.value=SEARCH02;
		     	var sXml=sheetObj.GetSearchData("ESM_PRI_2003_04GS.do", FormQueryString(formObj));
		     	sheetObj.LoadSaveData(sXml);
	     		if(ComGetEtcData(sXml, "FLAG") == "Y") {
			     	formObj.f_cmd.value=MULTI02;
					//sXml=sheetObj.GetSaveXml("ESM_PRI_2003_04GS.do", FormQueryString(formObj));
			     	sXml=sheetObj.GetSaveData("ESM_PRI_2003_04GS.do", FormQueryString(formObj));
					sheetObj.LoadSaveData(sXml);
	     		}
	     		ComOpenWait(false);
				break;		
				
			case IBSEARCH_ASYNC02: // Retrieving font type
				formObj.f_cmd.value=SEARCH03;
				//var sXml=sheetObj.GetSaveXml("ESM_PRI_2003_04GS.do", FormQueryString(formObj));
				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_04GS.do", FormQueryString(formObj));
				setTypeFontStyle(sXml);
				break;		
				
			case IBSEARCH_ASYNC03:
//				formObj.f_cmd.value=SEARCH19;
//				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
//					formObj.cd.value="CD02070";
//				} else {
//					formObj.cd.value="CD02071";
//				}
//				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
//				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					sheetObjects[0].SetColProperty("rcv_de_term_cd", {ComboText:orgRcvDeTermCdText, ComboCode:orgRcvDeTermCdValue} );
				} else {
					sheetObjects[0].SetColProperty("rcv_de_term_cd", {ComboText:destRcvDeTermCdext, ComboCode:destRcvDeTermCdValue} );
				}
				break;
				
			case IBSEARCH_ASYNC04:
				formObj.f_cmd.value=SEARCH03;
				//var sXml=sheetObj.GetSaveXml("ESM_PRI_2003_04GS.do", FormQueryString(formObj));
				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_04GS.do", FormQueryString(formObj));
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
				
			case IBSEARCH_ASYNC05: //Actual Customer
				formObj.f_cmd.value=SEARCHLIST15;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"cust_cnt_cd",true,0,"","",true);
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
				sParam += "&" + sParamSheet1;
				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_04GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
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
				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
				sheetObj.SetCellValue(idx, "add_chg_tp_cd","A");
				sheetObj.SetCellValue(idx, "org_dest_tp_cd",ComGetObjValue(formObj.org_dest_tp_cd));
				sheetObj.SetCellValue(idx, "add_chg_seq",parseInt(ComPriGetMax(sheetObj, "add_chg_seq")) + 1);
				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
				sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
				sheetObj.SetCellValue(idx, "src_info_cd","NW");
				sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
				if(amdt_seq > 0) {
					sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
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
				setGetRowEditable(sheetObj, idx, true, "rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt|note_dp_seq");
				sheetObj.SetCellValue(idx, "chk",0);
				sheetObj.SetCellValue(idx, "add_chg_seq",parseInt(ComPriGetMax(sheetObj, "add_chg_seq")) + 1);
				sheetObj.SetCellValue(idx, "coffr_frt_rt_amt","");
				sheetObj.SetCellValue(idx, "fnl_frt_rt_amt","");
				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
				sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
				sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq);
				sheetObj.SetCellValue(idx, "src_info_cd","NW");
				sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
				sheetObj.SetCellValue(idx, "pre_note_dp_seq","");
				if(amdt_seq != 0) {
					sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
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
					}
					deleteRowCheck(sheetObj, "chk");
				} else {
					var eff_dt=formObj.eff_dt.value;
					var amdt_seq=formObj.amdt_seq.value;
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length > 0) {
						for(i=0;i < chkArr.length;i++){
							if(sheetObj.GetCellValue(chkArr[i],"amdt_seq") != amdt_seq) {
								ComShowCodeMessage("PRI01002");
								return;
							}
							if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq") == amdt_seq) {
								if(sheetObj.GetCellValue(chkArr[i],"src_info_cd") == "AM" || sheetObj.GetCellValue(chkArr[i],"src_info_cd") == "AD") {
									ComShowCodeMessage("PRI01002");
									return;
								}
								deleteRowCheck(sheetObj, "chk");
								return;
							}
						}
						var sRow=0;
						amendRow(sheetObj, document.form, "D");
								
					} else {
						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq") != amdt_seq) {
							ComShowCodeMessage("PRI01002");
							return;
						}
						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") == amdt_seq) {
							if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"src_info_cd") == "AM" || sheetObj.GetCellValue(sheetObj.GetSelectRow(),"src_info_cd") == "AD") {
								ComShowCodeMessage("PRI01002");
								return;
							}	
						}
						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") == amdt_seq) {
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk",1);
							deleteRowCheck(sheetObj,"chk");		
						} else {
//							amendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"D","rout_pnt_loc_def_cd|rout_pnt_loc_def_nm|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|" +
//							"cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt|coffr_frt_rt_amt|fnl_frt_rt_amt");
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk", 1);
							amendRow(sheetObj, formObj, "D");
						}
					}					
				}
				break;
			case MODIFY01:	//Accept
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI03;
				acceptRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
			case MODIFY02:	//Accept Cancel
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI04;
				acceptCancelRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
			case MODIFY03:	//Accept All
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=MULTI05;
				acceptAllRows(sheetObjects[0], document.form);
				ComOpenWait(false);
				break;
			case MODIFY04:	//Cancel All
				ComOpenWait(true);
				if (!validateForm(sheetObj, document.form, sAction)) {
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
	     			ComOpenWait(false);
	     			return false;
	     		}
				var sParamSheet=sheetObj.GetSaveString()+"&f_cmd="+MULTI01;
				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_04GS.do", sParamSheet);
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
	     		break;
	     		
			case COMMAND01:	//Amend
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
				if(chkArr.length > 0){
					amendRow(sheetObj, document.form, "M");
				} else {
					sheetObj.SetCellValue(sheetObjects[0].GetSelectRow(), "chk", 1);
					amendRow(sheetObj, document.form, "M");
				}
				break;
				
			case COMMAND02: // Amend Cancel
				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
				if(chkArr.length > 0){
					if(chkArr.length > 1){					
						ComShowCodeMessage("PRI00310");
					} else{
						amendCancelRow(sheetObjects[0], document.form, chkArr[0], "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|" +
							"min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt");
					}
				} else{ 
					amendCancelRow(sheetObjects[0], document.form, sheetObjects[0].GetSelectRow(), "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|" +
						"min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt");
				}
				break;		
				
			case IBDOWNEXCEL:
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				break;
				
			case IBLOADEXCEL:      //upload excel
				var formObj=document.form;
		    	var propNO=formObj.prop_no.value;
		    	var amdtSeq=formObj.amdt_seq.value;
		    	var svcScpCd=formObj.svc_scp_cd.value;
		    	var orgDestTpCd=getOrgDestTpCd();
		    	var addChgTpCd="A";
		    	var effDt=formObj.eff_dt.value;
				var sUrl="/opuscntr/ESM_PRI_2050.do?";
				sUrl += "prop_no="+propNO;
				sUrl += "&amdt_seq="+amdtSeq;
				sUrl += "&svc_scp_cd="+svcScpCd;
				sUrl += "&org_dest_tp_cd="+orgDestTpCd;
				sUrl += "&add_chg_tp_cd="+addChgTpCd;
				sUrl += "&n1st_cmnc_amdt_seq="+amdtSeq;				
				ComOpenPopup(sUrl, 1200, 425, "", "1,0,1,1,1,1,1", false);
				break;
	    }
	}
	
	var isAllReadyUse = false;
	
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
     function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg)  {
    	 
    	 if(isAllReadyUse){
    		 if(selctRowCount != 0){
        		 sheetObj.SetSelectRow(selctRowCount,0);
            	 selctRowCount= 0;
        	 }
    		 return;
    	 }
    	 if(sheetObj.RowCount() > 0 && sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
  			setSheetDisplay(sheetObj);
  			isAllReadyUse = true;
  			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
  			buttonControl();
  		 }
    	 if(sheetObj.RowCount() > 0 && document.form.f_cmd.value == SEARCH03){
        	 sheetObj.CheckAll("chk", 0, 0);
        	 
    	 }
  	}   
 	/**
     * Calling function in case of OnSaveEnd Event <br>
     * Displaying Save confirmation message in case of sucessful saving <br>
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
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			var formObj=document.form;
			setSheetDisplay(sheetObj);
			setProposalStatusSummary(formObj);
			if(formObj.f_cmd.value == MULTI02) { //Retrieving after copying guideline copy
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				ComShowCodeMessage('PRI01017');
			}
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
			buttonControl();
		}
	}
 	/**
     * when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns N/A
     * @author 
     * @version 2009.05.20
     */ 
    function pageOnLoadFinish() {
    	initControl();
    	buttonControl();
     	parent.loadTabPage();
    }
    /**
     * Accepting selected row or checked row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptRows(sheetObjects[0], document.form )
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory
     * @return boolean
     * 		true  : Success
     * 		false : Error
     * @author 
     * @version 2009.05.20
     */
    function acceptRows(sheetObj,formObj) {
      	var propStsCd=formObj.prop_sts_cd.value;
  		var effDt=formObj.eff_dt.value;
  		var amdtSeq=formObj.amdt_seq.value;
  		var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
  		if(chkArr.length == 0) {
  			// Selected row has previous sequence
  			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") != amdtSeq) {
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
  			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
  			chkArr[0]=sheetObj.GetSelectRow();
  		}
  		for (var i=0; i<chkArr.length; i++) { // Displaying error message in case of accepted item in checked rows
  			// previous sequence
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
   			if(prcProgStsCd == "A") { // Excluding Accept
   				continue;
   			}
   			if(propStsCd == "Q") { //Setting proposal amount to final in case of request status
   				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt"),0);//Approving Sales.Rep's amount
   			}
   			if(propStsCd == "R") { //Setting Counter Offer  amount to final in case of Return status   
   				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt"),0);//Approving Counter Offer's amount
   			}
   			sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","A");//Accept
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
		var sXml=sheetObj.GetSaveData("ESM_PRI_2003_04GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
   		comChangeValue(sheetObj, "chk", "0", "chk", "1");
   		return true;
  	}
    /**
     * Accepting target to be accepted all<br>
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
     * @version 2009.07.30
     */
  	function acceptAllRows(sheetObj, formObj) {
      	var amdtSeq=formObj.amdt_seq.value;
  		var effDt=formObj.eff_dt.value;
  		var propStsCd=formObj.prop_sts_cd.value;
  		var trgtArr=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdtSeq+"|"+amdtSeq);
  		if(trgtArr.length == 0) { // No more accepting target
  			ComShowCodeMessage("PRI00331", "Accept");
 			return false;
  		}
  		for(var i=trgtArr.length-1; i>=0; i--) {
  			if(sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd") == "A" || sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd") == "R") { //Excluding Accept ,Return
  				trgtArr.splice(i, 1);
  			}
  		}
  		if(trgtArr.length == 0) { // already accepted all
  			ComShowCodeMessage("PRI00329");
 			return false;
  		}
  		var rCnt=trgtArr.length;
  		for(var i=0; i<rCnt; i++) {
  			if(propStsCd == "Q") { ////Setting proposal amount to final in case of request status  
  				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt"),0);//Approving Sales.Rep's amount
  			}
  			if(propStsCd == "R") { ////Setting  Counter Offer amount to final in case of Return status  
  				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt"),0);//Approving Counter Offer's amount
  			}
  			sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","A");//Accept
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
		var sXml=sheetObj.GetSaveData("ESM_PRI_2003_04GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
  		return true;
  	}
  	/**
     * Accept cancel selected or checked row <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	acceptCancelRows(sheetObjects[0], document.form)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @return boolean
     * 		true  : success
     * 		false : error
     * @author 
     * @version 2009.07.30
     */
   	function acceptCancelRows(sheetObj, formObj) {
      	var propStsCd=formObj.prop_sts_cd.value;
   		var effDt=formObj.eff_dt.value;
   		var amdtSeq=formObj.amdt_seq.value;
   		var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
   		if(chkArr.length == 0) {
   			// Selected row is previous sequence
   			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq") != amdtSeq) {
  				ComShowCodeMessage("PRI00313");
  				return false;
  			}
   			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
   			chkArr[0]=sheetObj.GetSelectRow();
   		}
   		for(var i=0; i<chkArr.length; i++) { //Error message in case of not accepted status in checked rows
   			// accepted row before
   			if(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq") != amdtSeq) {
   				sheetObj.SetCellValue(chkArr[i], "chk","0",0);
   				ComShowCodeMessage("PRI00313");
   				return false;
   			}
   			// Not Accept
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
   			if(ComNullToZero(cofferFrtRtAmt) == 0) { //Setting to initial in case of no Counter Offer amount,Re-setting final
   				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","I");
   				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
   			} else { //Setting to Return in case of Counter Offer amount,Re-setting final
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
		var sXml=sheetObj.GetSaveData("ESM_PRI_2003_04GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
		comChangeValue(sheetObj, "chk", "0", "chk", "1");
   		return true;
   	}
   	/**
     * Cancelling acceptance of all accepted row<br>
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
     * @version 2009.07.30
     */   	
   	function acceptCancelAllRows(sheetObj, formObj){
   		var amdtSeq=formObj.amdt_seq.value;
   		var effDt=formObj.eff_dt.value;
   		// releasing checked row
   		comChangeValue(sheetObj, "chk", "0");
   		var trgtArr=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdtSeq+"|"+amdtSeq);
   		if(trgtArr.length == 0) {
   			ComShowCodeMessage("PRI00330"); //no row related to current amd seq
  			return false;
   		}
   		for(var i=trgtArr.length-1; i>=0; i--) {
   			if(sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd") != "A") {
  				trgtArr.splice(i, 1);
  			}
  		}
  		if (trgtArr.length == 0) { //no accepted data
  			ComShowCodeMessage("PRI00330");
 			return false;
  		}
   		for (var i=0; i<trgtArr.length; i++) {
   			var prcProgStsCd=sheetObj.GetCellValue(trgtArr[i], "prc_prog_sts_cd");
   			var propFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "prop_frt_rt_amt");
   			var cofferFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "coffr_frt_rt_amt");
   			var fnlFrtRtAmt=sheetObj.GetCellValue(trgtArr[i], "fnl_frt_rt_amt");
   			if(prcProgStsCd != "A") { //excluding not Accepted
   				continue;
   			}
   			if (ComNullToZero(cofferFrtRtAmt) == 0) { //Setting to initial in case of no Counter Offer amount,Re-setting final
   				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","I");
   				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
   			} else {  //Setting to Return in case of Counter Offer amount,Re-setting final
   				sheetObj.SetCellValue(trgtArr[i], "prc_prog_sts_cd","R");
  				sheetObj.SetCellValue(trgtArr[i], "fnl_frt_rt_amt","");
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
		var sXml=sheetObj.GetSaveData("ESM_PRI_2003_04GS.do", sParam);
		sheetObj.LoadSaveData(sXml);
  		return true;
   	}   	
    
   	/**
     * Amending selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendRow(sheetObjects[0], document.form, Row, "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory
     * @param (string) sCols Mandatory column index
     * @return boolean
     * 		true  : success
     * 		false : error
     * @author 
     * @version 2009.07.30
     */
   	function amendRow(sheetObj, formObj, sAction){
		//[Strike Font s]-----------------------------------------
		var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
		//[Strike Font e]-----------------------------------------
		var cntHeaderRows = sheetObj.HeaderRows();
		if(sAction == "M"){
			var sRow = sheetObj.GetSelectRow();
			var amdt_seq = formObj.amdt_seq.value;
			if(sheetObj.GetCellValue(sRow,"amdt_seq") != amdt_seq || sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq") == amdt_seq){
				ComShowCodeMessage("PRI01011");
				return;
			}
		}
		var sheetOrgData = sheetObj.ExportData({Type:"json"}).data;
        var sheetChgData = new Array();
        selctRowCount = 0;
        for(var j=0, maxlen = sheetOrgData.length; j < maxlen; j++){
        	var sheetDataObj = new Object();
            if(sheetOrgData[j].chk == 1){
                var sheetDataArr = amendRowDetail(sheetObj,formObj, sheetOrgData[j], sAction, "rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd" + 
                		"|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt|note_dp_seq");
                sheetChgData.push(sheetDataArr[0]);
                sheetChgData.push(sheetDataArr[1]);
            }else{
            	sheetChgData.push(sheetOrgData[j]);
                
            }
        }
        //[Strike Font s]-----------------------------------------
        if(sAction == "M" || sAction == "D"){
        	selctRowCount = getLastIndexChk(sheetObj, chkArr)+chkArr.length;
        }
        //[Strike Font e]-----------------------------------------
        isAllReadyUse = false;
        var sheetLoadData = new Object();
        sheetLoadData["data"] = sheetChgData;
        sheetObj.LoadSearchData(sheetLoadData);

	}
	
	/**
	 * get Max Row Index in the check's rows
	 */
	function getLastIndexChk(sheetObj, chkArr){
		var result = 0;
		if(chkArr != null && chkArr.length > 0){
			var maxVal = sheetObj.HeaderRows();
			for(var i = 0; i < chkArr.length; i++){
				var tmpVal = parseInt(chkArr[i]);
				if(tmpVal > maxVal){
					maxVal = tmpVal;
				}
			}
			result = maxVal;
		}
		
		return result;
	}
    
	/**
     * Amending selected row <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendRowDetail(sheetObjects[0], document.form, Row, "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory  Whether amend or delete amend
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.05.18
     */
	function amendRowDetail(sheetObj, formObj, sRow, sAction) {
		var prop_no=formObj.prop_no.value;
		var amdt_seq=formObj.amdt_seq.value;
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var pre_exp_dt=formObj.pre_exp_dt.value;
		var dur_dup_flg=formObj.dur_dup_flg.value;
		var sColNames="rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd" + "|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt|note_dp_seq";
		var newObj = new Object();
		var preObj = new Object();
		jQuery.extend(newObj, sRow);
		jQuery.extend(preObj, sRow);
		
		//[Strike Font]-----------------------------------------
        newObj["tmp_type"] = "C";
        //[Strike Font]-----------------------------------------
		
		newObj["coffr_frt_rt_amt"] = "";
        newObj["fnl_frt_rt_amt"] = "";
        newObj["eff_dt"] = eff_dt;
        newObj["n1st_cmnc_amdt_seq"] = amdt_seq;
        newObj["prc_prog_sts_cd"] = "I";
        newObj["ibflag"] = "U";  
	        
        if(sAction == "M") { //Amend
            newObj["src_info_cd"] = "AM";
            newObj["prop_frt_rt_amt"] = 0;
            newObj["add_chg_note_ctnt#BackColor"] = "#FFFFFF";
            
            preObj["chk#Edit"] = "0";
            var editCellInfo = sColNames.split("|");
            for(var ii=0; ii<editCellInfo.length; ii++){
                newObj[editCellInfo[ii] + "#Edit"] = "1";
            }
        } else if(sAction == "D") { //Delete Amend
            newObj["src_info_cd"] = "AD";
            newObj["rat_ut_cd"] = newObj["per_type"];
            newObj["chk#Edit"] = "1";
        }
        
        newObj["FontColor"] = "#FF0000";  //빨간색 설정
        for(ii = 0; ii < sheetObj.LastCol(); ii++){
            preObj[sheet1.ColSaveName(ii) + "#FontStrike"] = "1";
        }
        preObj["amdt_seq"] = pre_amdt_seq;
        if(dur_dup_flg == "Y") {
            preObj["exp_dt"] = pre_exp_dt;            
        }
        preObj["ibflag"] = "R";
        
        preObj["chk"] = "0";
        preObj["chk#Edit"] = "0";
        var editCellInfo = sColNames.split("|");
        for(var ii=0; ii<editCellInfo.length; ii++){
            preObj[editCellInfo[ii] + "#Edit"] = "0";
        }  
        
        //[Strike Font]-----------------------------------------
        preObj["tmp_type"] = "S";
        //[Strike Font]-----------------------------------------
        
        
        return [preObj, newObj];
	}
    
	/**
     *  amend cancel selected row <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	amendCancelRow(sheetObjects[0], document.form, Row, "M", "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {object} formObj Mandatory 
     * @param (int) sRow Mandatory row index
     * @param (string) sAction Mandatory 
     * @return boolean
     * 		true  : success
     * 		false : error
     * @author 
     * @version 2009.07.30
     */
	function amendCancelRow(sheetObj, formObj, sRow, sAction) {
		var eff_dt=formObj.eff_dt.value;
		var exp_dt=formObj.exp_dt.value;
		var pre_amdt_seq=formObj.pre_amdt_seq.value;
		var amdt_seq=formObj.amdt_seq.value;
		var dur_dup_flg=formObj.dur_dup_flg.value;
		sheetObj.SetCellValue(sRow,"chk",0);
		// 	 n1st_cmnc_amdt_seq == amdt_seq for A/M/D 
		if(sheetObj.GetCellValue(sRow,"n1st_cmnc_amdt_seq") != amdt_seq || (sheetObj.GetCellValue(sRow,"src_info_cd") != "AD" && sheetObj.GetCellValue(sRow,"src_info_cd") != "AM")) {
			ComShowCodeMessage("PRI00313");		
		 	return false;
		}
		//checking whether group location is valid or not when cancelling  DELETE AMEND
		if(sheetObj.GetCellValue(sRow, "src_info_cd") == "AD" && !checkGroupLocationExist(sheetObj, formObj, sRow)) {
			ComShowCodeMessage("PRI01127", "[LOC Group]");
			return false;
		}
		var preRow=sRow-1;
		var amdRow=sRow;
		sheetObj.SetCellFont("FontStrike", preRow, 1, preRow, sheetObj.LastCol(),0);
		sheetObj.SetCellFont("FontItalic", preRow, 1, preRow, sheetObj.LastCol(),0);
		//[Strike Font]-----------------------------------------
		sheetObj.SetCellValue(preRow, "tmp_type", "", 0);
		//[Strike Font]-----------------------------------------
		sheetObj.SetCellValue(preRow,"amdt_seq",sheetObj.GetCellValue(amdRow,"amdt_seq"),0);
		if(dur_dup_flg=="Y"){
        	sheetObj.SetCellValue(preRow,"exp_dt",exp_dt,0);
        }
		// When PER_TYPE code is deleted, Input the per_type.
		if (sheetObj.GetCellValue(preRow, "rat_ut_cd") == ""){
			sheetObj.SetCellValue(preRow, "rat_ut_cd",sheetObj.GetCellValue(preRow, "per_type") ,0);
		}
		if(sheetObj.CellSearchValue(amdRow, "amdt_seq") != unescape("%00")) {
			sheetObj.SetRowStatus(preRow,"U");
		}
		sheetObj.RowDelete(amdRow, false);
		return true;
	}
    /**
     * checking whether group location<br>
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
     		formObj.f_cmd.value=COMMAND24;
     		formObj.cd.value=sheetObj.GetCellValue(sRow, "bse_port_def_cd");
     		var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+PRI_RP_SCP);
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if(arrData == null || arrData == "") {
				return false;
			}
      	}
      	return true;
    }
	/**
     * Checking validation of rout_pnt_loc_tp_cd<br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkRoutePointLocation(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.07.30
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
     *  Checking validation of Rate <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkRateAmount(sheetObj, Row, Col, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
     * @param {int} Col Mandatory ,Cell's Column Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.07.30
     */ 
	function checkRateAmount(Value) {
		 if(Value < 0) {
			ComShowMessage("Negative number is inputted. Please check again.");
		 }
	}
	/**
     *  Checking validation of rcv_de_term_cd <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setTermCode(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function setTermCode(sheetObj, Row, Value) {
		if(sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == sheetObj.GetCellValue(Row, "bse_port_def_cd")) {
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
		}
	}
	/**
     *  Checking validation of bse_port_def_cd <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkBasePort(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function checkBasePort(sheetObj, Row, Value) {
		if (sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			ComShowCodeMessage('PRI01020');
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
			sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	/**
     *  Checking validation of prc_cgo_tp_cd <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkPerType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function checkPerType(sheetObj, Row, Value) {
		var validPerClass="A,F,O,Q,S,P";
		if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
        	ComShowCodeMessage("PRI08003");
    		sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
        }
	}
	/**
     *  Checking validation of rat_ut_cd <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory ,Cell's Row Index
	 * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
     * @author 
     * @version 2009.07.30
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
     * Checking whether copying guideline copy <br>
     * <br><b>Example :</b>
     * <pre>
     *    confirmGuidelineCopy(sheetObjects[0], formObj, orgDestTpCd)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
     * @param {object} formObj Mandatory Form Object
     * @param {string} orgDestTpCd Mandatory origin, destination 
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function confirmGuidelineCopy(sheetObj, formObj, orgDestTpCd) {
		if(ComShowCodeConfirm('PRI01009')) {
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
		}
		if(orgDestTpCd == "O") {
			CONFIRM_ORG_GLINE=true;
		} else if(orgDestTpCd == "D") {
			CONFIRM_DEST_GLINE=true;
		}
	}
	/**
     * Setting sheet's property <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function setSheetDisplay(sheetObj) {
		
		//extract json object from sheet
		var sheetOrgData = sheetObj.ExportData({Type:"json"}).data;
		if(sheetOrgData == undefined || sheetOrgData == null || sheetOrgData.length == 0) return;
				
		var formObj=document.form;
		var amdtSeq=formObj.amdt_seq.value;
		var effDt=formObj.eff_dt.value;
		var propStsCd=formObj.prop_sts_cd.value;
		var aproUsrFlg=form.apro_usr_flg.value;
		var reqUsrFlg=formObj.req_usr_flg.value;
		var rCnt=sheetObj.RowCount();
		var sFontStrikeColNames = "chk|seq|rout_pnt_loc_def_cd|rout_pnt_loc_def_nm|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd|prop_frt_rt_amt|coffr_frt_rt_amt|fnl_frt_rt_amt|eff_dt|exp_dt|src_info_cd|prc_prog_sts_cd|note_dp_seq|add_chg_note_ctnt";
		var sFontStrikeColArray = sFontStrikeColNames.split("|");
		var sColNames="rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd" +
				"|prc_cmdt_def_cd|curr_cd|note_dp_seq";
		var sRequstDisableColNames = sColNames+"|prop_frt_rt_amt";
		var sRequstDisableColArray = sRequstDisableColNames.split("|");
		var sReturnDisableColNames = sColNames+"|coffr_frt_rt_amt";
		var sReturnDisableColArray = sReturnDisableColNames.split("|");
		var sStrikeTargetColNames = "chk|"+sColNames+"|prop_frt_rt_amt";
		var sStrikeTargetColArray = sStrikeTargetColNames.split("|");
		var sNotAmendTargetColNames = sColNames+"|prop_frt_rt_amt";
		var sNotAmendTargetColArray = sNotAmendTargetColNames.split("|");
		
		var resultSheetObj = new Array();

		var sIdx = sheetObj.HeaderRows();
		var eIdx = sheetObj.LastRow();
		var cLastIdx = sheetObj.LastCol();
		var disableColorTxt = sheetObj.GetEditableColorDiff(1);
		var enableColorTxt = "#FFFFFF";
		var redColorTxt = "#FF0000";
		
		//[amdt_seq = 0 start]--------------------
		if(amdtSeq == 0) {
			for(var i=sIdx; i<=eIdx; i++) {
				var jsonIdx = i - sIdx;
				
				//temparay row object
				var tmpRowSheetObj = new Object();
				tmpRowSheetObj = sheetOrgData[jsonIdx];
				
				var r_prc_prog_sts_cd = tmpRowSheetObj["prc_prog_sts_cd"];
				if(propStsCd == "I") { //Initial
					if(r_prc_prog_sts_cd != "I") {
						makeJsonRowEdit(tmpRowSheetObj, sFontStrikeColArray, "0");
						tmpRowSheetObj["add_chg_note_ctnt#BackColor"] = disableColorTxt;
					}else{
						tmpRowSheetObj["add_chg_note_ctnt#BackColor"] = enableColorTxt;
					}
				} else if(propStsCd == "Q") { //Request
					makeJsonRowEdit(tmpRowSheetObj, sRequstDisableColArray, "0");
					if(r_prc_prog_sts_cd != "A" && aproUsrFlg == "true") { //Possible to input C/Offer in case of only approver
						tmpRowSheetObj["coffr_frt_rt_amt#Edit"] = "1";
					} else {
						tmpRowSheetObj["coffr_frt_rt_amt#Edit"] = "0";
					}		
				} else if(propStsCd == "R") { //Return
					makeJsonRowEdit(tmpRowSheetObj, sReturnDisableColArray, "0");
					if(reqUsrFlg == "true" && (r_prc_prog_sts_cd == "I" || r_prc_prog_sts_cd == "R")) {
						tmpRowSheetObj["prop_frt_rt_amt#Edit"] = "1";
					} else {
						tmpRowSheetObj["prop_frt_rt_amt#Edit"] = "0";
					}
				} else {
					makeJsonRowEdit(tmpRowSheetObj, sFontStrikeColArray, "0");
				}
				
				resultSheetObj.push(tmpRowSheetObj);
			}
			
			//bind to the sheet with object
			var sheetLoadData = new Object();
	        sheetLoadData["data"] = resultSheetObj;
	        sheetObj.LoadSearchData(sheetLoadData);
			
			return;
		}
		//[amdt_seq = 0 end]--------------------
		
		//[amdt_seq > 0 start]--------------------
		for(var i=sIdx; i<=eIdx; i++) {
			var jsonIdx = i - sIdx;
			
			//temparay row object
			var tmpRowSheetObj = new Object();
			tmpRowSheetObj = sheetOrgData[jsonIdx];
			
			//compare variable
			var t_amdt_seq = tmpRowSheetObj["amdt_seq"];
			var t_src_info_cd = tmpRowSheetObj["src_info_cd"];
			var t_prc_prog_sts_cd = tmpRowSheetObj["prc_prog_sts_cd"];
			var t_n1st_cmnc_amdt_seq = tmpRowSheetObj["n1st_cmnc_amdt_seq"];
			
			if(t_amdt_seq != amdtSeq) { //Strike previous sequence and not editable
				makeJsonRowFontStrike(tmpRowSheetObj,sFontStrikeColArray,"1");
				
				//[Strike Font]-----------------------------------------
				tmpRowSheetObj["tmp_type"] = "S";
				var sCmd = formObj.f_cmd.value;
				if(sCmd == SEARCH01){
					tmpRowSheetObj["ibflag"] = "";
				}
				//[Strike Font]-----------------------------------------
				makeJsonRowEdit(tmpRowSheetObj, sStrikeTargetColArray, "0");
				resultSheetObj.push(tmpRowSheetObj);
				continue;
			}
			if(t_n1st_cmnc_amdt_seq != amdtSeq) { //not editable for not amended row
				makeJsonRowEdit(tmpRowSheetObj, sNotAmendTargetColArray, "0");
				resultSheetObj.push(tmpRowSheetObj);
				continue;
			}
			tmpRowSheetObj["FontColor"] = redColorTxt; 
			
			//[Strike Font]-----------------------------------------
			tmpRowSheetObj["tmp_type"] = "C";
			tmpRowSheetObj["chk"] = "0";
			var sCmd = formObj.f_cmd.value;
			if(sCmd == SEARCH01){
				tmpRowSheetObj["ibflag"] = "";
			}
			//[Strike Font]-----------------------------------------
			if(t_src_info_cd == "AD") {
				makeJsonRowEdit(tmpRowSheetObj, sNotAmendTargetColArray, "0");
				resultSheetObj.push(tmpRowSheetObj);
				continue;
			}
			if(propStsCd == "I") { //Initial
				if(t_prc_prog_sts_cd != "I") {
					makeJsonRowEdit(tmpRowSheetObj, sFontStrikeColArray, "0");
					tmpRowSheetObj["add_chg_note_ctnt#BackColor"] = disableColorTxt;
				}else{
					tmpRowSheetObj["add_chg_note_ctnt#BackColor"] = enableColorTxt;
				}
			} else if(propStsCd == "Q") { //Request
				makeJsonRowEdit(tmpRowSheetObj, sNotAmendTargetColArray, "0");
				if(t_prc_prog_sts_cd != "A" && aproUsrFlg == "true") { //Possible to input C/Offer in case of only approver
					tmpRowSheetObj["coffr_frt_rt_amt#Edit"] = "1";
				} else {
					tmpRowSheetObj["coffr_frt_rt_amt#Edit"] = "0";
				}	
			} else if(propStsCd == "R") { //Return
				makeJsonRowEdit(tmpRowSheetObj, sNotAmendTargetColArray, "0");
				if(reqUsrFlg == "true" && (t_prc_prog_sts_cd == "I" || t_prc_prog_sts_cd == "R")) {
					tmpRowSheetObj["prop_frt_rt_amt#Edit"] = "1";
				} else {
					tmpRowSheetObj["prop_frt_rt_amt#Edit"] = "0";
				}
			} else if(propStsCd == "A") { 
				makeJsonRowEdit(tmpRowSheetObj, sFontStrikeColArray, "0");
			}
			
			resultSheetObj.push(tmpRowSheetObj);
		}
		
		//bind to the sheet with object
		var sheetLoadData = new Object();
        sheetLoadData["data"] = resultSheetObj;
        sheetObj.LoadSearchData(sheetLoadData);
        
        //[amdt_seq > 0 end]--------------------
		
	}
	
	/**
	 * set Row Editable with json
	 * @param {Object} Row Data Info's json
	 * @param {Array} Colums Info Array
	 * @param {String} editable(1) / uneditable(0)
	 */
	function makeJsonRowEdit(rowObj, paramArray, isEditable){
		if(paramArray != undefined && paramArray != null && paramArray.length > 0){
			for(var i = 0; i < paramArray.length; i++){
				rowObj[paramArray[i] + "#Edit"] = isEditable;
	        }
		}
	}
	
	/**
	 * set Cell Font Strike with json
	 * @param {Object} Row Data Info's json
	 * @param {Array} Colums Info Array
	 * @param {String} is FontStrike(1) / is not FontStrike(0)
	 */
	function makeJsonRowFontStrike(rowObj, paramArray, isStrike){
		if(paramArray != undefined && paramArray != null && paramArray.length > 0){
			for(var i = 0; i < paramArray.length; i++){
				rowObj[paramArray[i] + "#FontStrike"] = isStrike;
	        }
		}
	}
	
	
	/**
     * Setting note_dp_seq <br>
     * <br><b>Example :</b>
     * <pre>
     *    setNoteDefSeq(sheetObj, formObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @return void
     * @version 2015.10.29
     */
 	function setNoteDefSeq(sheetObj, formObj) {
 		var amdtSeq=formObj.amdt_seq.value;
 		var rCnt=sheetObj.LastRow();
 		if(amdtSeq == 0) {
 			var noteDpSeq=1;
 			for(var i=1; i<=rCnt; i++) {
 				if(sheetObj.GetCellValue(i, "add_chg_note_ctnt") == "") {
 					sheetObj.SetCellValue(i, "note_dp_seq","");
 					continue;
 				}
 				if(sheetObj.GetCellValue(i, "ibflag") != "D") {
 					sheetObj.SetCellValue(i, "note_dp_seq",noteDpSeq++);
 				}
 			}
 		} else {
 			var noteDpSeq=parseInt(getNoteDefSeqMax(sheetObj))+1;
 			for(var i=1; i<=rCnt; i++) {
 				if(sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq) {
 					if((sheetObj.GetCellValue(i, "add_chg_note_ctnt") == "" || sheetObj.GetCellValue(i, "ibflag") == "D")
 							&& sheetObj.GetCellValue(i, "pre_note_dp_seq") == "") {
 						sheetObj.SetCellValue(i, "note_dp_seq","");
 						continue;
 					} 					
 					// When Note Seq is delivered from previous Amend Seq
 					if(sheetObj.GetCellValue(i, "pre_note_dp_seq") != ""){
 						continue;
 					}
/* 					if(sheetObj.GetCellValue(i, "prc_prog_sts_cd") == "I"
 						&& sheetObj.GetCellValue(i, "note_dp_seq") != ""
 							&& sheetObj.GetCellValue(i, "ibflag") =="U") {
 						continue;
 					}*/
 					if(sheetObj.GetCellValue(i, "ibflag") != "D") {
 						sheetObj.SetCellValue(i, "note_dp_seq",noteDpSeq++);
 					}
 				}
 			}
 		}
 	} 
 	/**
     * Calculate Maximum value of previous amendment sequence's max_note_seq column <br>
     *
     * @param {object} sheetObj Mandatory, IBSheet Object.
     * @return int Max
     * @author 
     * @version 2009.05.18
     */
    function getNoteDefSeqMax(sheetObj) {
    	var formObj=document.form;
    	var amdtSeq=formObj.amdt_seq.value;
        var max=0;
        for(var i=sheetObj.HeaderRows(); sheetObj.RowCount()>0 && i<=sheetObj.LastRow(); i++) {
        	if(sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") != amdtSeq && ComParseInt(sheetObj.GetCellValue(i, "note_dp_seq")) > max) {
        		max=sheetObj.GetCellValue(i, "note_dp_seq");
            }
        }
        return max;
    }
	/**
     * Setting editable for row's specific column<br>
     * <br><b>Example :</b>
     * <pre>
     *    setRowEditable(sheetObj, i, false, "rout_pnt_loc_def_cd|prc_trsp_mod_cd")
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
     * @param (int) Row Mandatory Selected Row Index
     * @param (boolean) isEdit Mandatory editable
     * @param (String) sColNames Mandatory editable column name list
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function setGetRowEditable(sheetObj, Row, isEdit, sColNames) {
		var arrColNames=sColNames.split("|");
		var colCnt=arrColNames.length;
		for(i=0; i<=colCnt; i++) {
			sheetObj.SetCellEditable(Row, arrColNames[i],isEdit);
		}
	}
    /**
     * Getting org_dest_tp_cd's value <br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 
     * @version 2009.07.30
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}
	/**
     * Calling function in case of clicking tab on parent screen <br>
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
     * @version 2009.07.30
     */
 	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg) {
    	var formObj=document.form;
 		if (formObj.prop_no.value != sPropNo || formObj.amdt_seq.value != sAmdtSeq || formObj.svc_scp_cd.value != sSvcScpCd || formObj.pre_amdt_seq.value != sPreAmdtSeq ||
 			formObj.prop_sts_cd.value != sPropStsCd || formObj.eff_dt.value != sEffDt || formObj.pre_exp_dt.value != sPreExpDt || formObj.exp_dt.value != sExpDt) {
 			formObj.prop_no.value=sPropNo;
 			formObj.amdt_seq.value=sAmdtSeq;
 			formObj.svc_scp_cd.value=sSvcScpCd;
 			formObj.pre_amdt_seq.value=sPreAmdtSeq;
 			formObj.prop_sts_cd.value=sPropStsCd; 
 			formObj.eff_dt.value=sEffDt;
 			formObj.exp_dt.value=sExpDt;
 			formObj.pre_exp_dt.value=sPreExpDt;
 			formObj.req_usr_flg.value=sIsReqUsr;
			formObj.apro_usr_flg.value=sIsAproUsr;
			formObj.dur_dup_flg.value=sDurDupFlg;
 			CONFIRM_ORG_GLINE=false;
 			CONFIRM_DEST_GLINE=false;
 			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC05);
 			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC04); //Setting Radio Button Default
 			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH_ASYNC03); //Term
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			buttonControl();
 		}
	}
 	/**
     * Clearing controls of tab screen on parent screen <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.07.30
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
     * Calling from main<br>
     * if Confirmation=YES,Disable to add,modify,delete. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from main.
     * @return N/A
     * @author 
     * @version 2009.07.30
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
     * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @param (string) sAction Mandatory 
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH: // retrieve	
				if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
 					ComShowCodeMessage('PRI08001');
 					return false;
 				}
				if ( sheetObj.IsDataModified()){
	            	if ( ComShowCodeConfirm("PRI00010") ) {
	            		return true;
	            	}else {
	            		return false;
	            	}									
				}
				return true;
 				break;
  			case IBSAVE:
	  			var amdtSeq=formObj.amdt_seq.value;
	  			if(!validateArbNoteSeq(sheetObj, amdtSeq)){
					return false;
				}
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
					var rowM=sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|cust_cnt_cd|curr_cd|add_chg_note_ctnt", false);
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", rowM);
						return false;
					}
				} else {
					var dupRow=ComPriAmendDupCheck(sheetObjects[0], "amdt_seq|rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|cust_cnt_cd|curr_cd|add_chg_note_ctnt", amdtSeq);
					if(dupRow >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", dupRow);
						return false;
					}
				}
				// Checking Proposal amount
				for(var i=sheetObj.GetTopRow(); i<=sheetObj.LastRow(); i++) {
					var sNoteVal = sheetObj.GetCellValue(i, "add_chg_note_ctnt");
					if(!validCheckLength(sNoteVal)) {
						ComShowCodeMessage("PRI00336", "Note", "1000");
						return false;
					}
				}
				for(var i=1; i<=sheetObj.LastRow(); i++){
					if(sheetObj.GetCellValue(i, "add_chg_tp_cd")=="I" && sheetObj.GetCellValue(i, "rcv_de_term_cd")!="D"){
						sheetObj.SetCellValue(i, "add_chg_tp_cd", "A");
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
    			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
				var checkedRows=sheetObj.FindCheckedRow( "chk" );
//				if ( checkedRows.length > 1 ) {
//					checkedRows=checkedRows.substr(0, checkedRows.length - 1);
//				}
				var checkedRowArr=checkedRows.split("|"); 
				if ( checkedRows == "" || checkedRowArr.length != 1 ) {
					ComShowCodeMessage('PRI00310');	
					return false;
				} else {
					sheetObj.selectRow=checkedRowArr[0];
				}
				if(sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != form.amdt_seq.value) {
					ComShowCodeMessage("PRI01002");		
					return false;
				}
    			return true;
    			break;
    			
    		case IBDELETE: // Delete
    			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if(!enableFlag) {
    				return false;
    			}
    			return true;
    			break;
    			
    		case IBSEARCH_ASYNC01: //Guideline Copy
    			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
    				return false;
    			}
    			if (sheetObj.RowCount()> 0) {
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
	  			if(!validateArbNoteSeq(sheetObj, amdtSeq)){
					return false;
				}
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
				if(amdtSeq == 0) {
					var rowM=sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|cust_cnt_cd|curr_cd|note_dp_seq|add_chg_note_ctnt", false);
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", rowM);
						return false;
					}
				} else {
					var dupRow=ComPriAmendDupCheck(sheetObjects[0], "amdt_seq|rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|cust_cnt_cd|rat_ut_cd|prc_cgo_tp_cd|cust_cnt_cd|curr_cd|note_dp_seq|add_chg_note_ctnt", amdtSeq);
					if(dupRow >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", dupRow);
						return false;
					}
				}
				// checking Proposal amount
				for(var i=sheetObj.GetTopRow(); i<=sheetObj.LastRow(); i++) {
					if(sheetObj.GetCellValue(i, "prop_frt_rt_amt") == "" && sheetObj.GetCellValue(i, "prop_frt_rt_amt") != "0") {
						ComShowCodeMessage("PRI08010", i, 'proposal rate');
						return false;
					}
				}
				return true;
				break;	
		}
		return true;
	}
	/**
	 * Check Length by bite<br>
	 * @param Value
	 * @returns {Boolean}
	 */
	function validCheckLength(Value) {
    	var rVal = ComChkLenByByte(Value, 1000);
		if(rVal == -1 || rVal == 0) {
			return false;
		}
		return true;
    }
	/**
	   * Setting TYPE RADIO button's font color <br>
     * 1) Blue : ALL ACCEPT <br>
     * 2) Red : Amended<br>
     * <br><b>Example :</b>
     * <pre>
     * 		setTypeFontStyle(sXml);
     * </pre>
     * @param {object} sXml Mandatory Xml Object
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
	function setTypeFontStyle(sXml) {
    	var arrDesc=ComPriXml2Array(sXml, "org_font_style|dest_font_style");
 		if (arrDesc != null && arrDesc.length > 0) {
 			if(arrDesc[0][0] == "blue") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd1").style.color="blue";
 			} else if(arrDesc[0][0] == "red") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd1").style.color="red";
 			} else if(arrDesc[0][0] == "bold") {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd1").style.color="black";
 			} else {
 				document.getElementById("org_dest_tp_cd1").style.fontWeight="";
 				document.getElementById("org_dest_tp_cd1").style.color="black";
 			}
 			if(arrDesc[0][1] == "blue") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd2").style.color="blue";
 			} else if(arrDesc[0][1] == "red") {
 				document.getElementById("org_dest_tp_cd2").style.fontWeight="bold";
 				document.getElementById("org_dest_tp_cd2").style.color="red";
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
     * Changing Proposal status <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {object} formObj Mandatory Form Object
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
    function setProposalStatusSummary(formObj) {
    	var orgDestTpCd=getOrgDestTpCd();
    	if(orgDestTpCd == "O") {
    		parent.comUpdateProposalStatusSummary("51", formObj.svc_scp_cd.value);
		} else if(orgDestTpCd == "D") {
			parent.comUpdateProposalStatusSummary("52", formObj.svc_scp_cd.value);
		}
    }
    /**
     *Calling funcion after closing excel popup screen<br>
     * <br><b>Example :</b>
     * <pre>
     *    reloadExcelCopy()
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.07.30
     */
    function reloadExcelCopy() {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * Controlling authority of button<br>
     * <br><b>Example :</b>
     * <pre>
     * 		buttonControl()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.07.30
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
 			ComBtnDisable("btn_amend");
 			ComBtnDisable("btn_amendcancel");
 			ComBtnDisable("btn_accept");
 			ComBtnDisable("btn_acceptcancel");
 			ComBtnDisable("btn_gricalc");
 			ComBtnEnable("btn_downexcel");
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
  					if(apro_usr_flg == "true" || req_usr_flg == "true" ) {
 						ComBtnEnable("btn_save");
 						if(rCnt == 0) {
 							ComBtnEnable("btn_glinecopy");
 						}
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
  					if(req_usr_flg == "true") {
 						ComBtnEnable("btn_save");
 					}
  					ComBtnDisable("btn_amend");
  					ComBtnDisable("btn_amendcancel");
  					break;
  					
  				case 'A':   // Approved
  					break;
  					
  				case 'F':   // Filed
  					break;
  					
  				case 'C':   // Canceled
  					break;		
  			}	
  		} catch (e) {
  			if (e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
  			} else {
  				ComShowMessage(e.message);
  			}
  		}
  	}
    
    /**
     * validate on saving arbitrary note sequence and content
     * 1. Check case with same note sequence but different note content : Hardstop <br>
     * 2. Check case with different note sequence but same note content : Give warning & option to synchronize sequence <br>
     *
     * @author NYK
     * @version 2016.08.02
     */
	   function validateArbNoteSeq(sheetObj, amdtSeq){
		   	var rCnt = sheetObj.RowCount();
		   	if(sheetObj.GetSaveString() == ""){
				return false;
			}
		   	// validate on case of (1) empty note seq (2) zero note seq (3) note seq starting with 0
			for(var i=1; i<=rCnt; i++) {
				if(sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq) {
					if(sheetObj.GetCellValue(i, "add_chg_note_ctnt") == "") {
						if(sheetObj.GetCellValue(i, "note_dp_seq") != ""){
							sheetObj.SetCellValue(i, "note_dp_seq","");
							continue;						
						}
					}else{
						if(sheetObj.GetCellValue(i, "ibflag") != "D") {
							if(sheetObj.GetCellValue(i, "note_dp_seq") == ""){
								sheetObj.SelectCell(i, "note_dp_seq");
								ComShowCodeMessage('PRI01042', "note sequence");
								return false;
							}
							if(sheetObj.GetCellValue(i, "note_dp_seq") == "0"){
								sheetObj.SelectCell(i, "note_dp_seq");
								ComShowCodeMessage('PRI01042', "note sequence more than 0");
								return false;
							}
							if(sheetObj.GetCellValue(i, "note_dp_seq").length > 1 && sheetObj.GetCellValue(i, "note_dp_seq").substring(0, 1) == "0"){
								sheetObj.SelectCell(i, "note_dp_seq");
								ComShowCodeMessage('PRI01042', "valid number on note sequence");
								return false;
							}
						}
					}
				}
			}
	   	var amdCtntArr = new Array();
	   	if(rCnt == 0 || rCnt == sheetObj.RowCount("D")){
	   		return true;
	   	}
	   	// validate on the case where same note seq but different content is entered
	   	var seqDupChk = findArbNoteDupRow(sheetObj, "note_dp_seq", amdtSeq);
	   	if(seqDupChk != undefined){
	   		var rtnVal = getNoteSeqDuplicated(sheetObj, seqDupChk, amdtSeq);
	       	if(typeof rtnVal == "string"){
	       		sheetObj.SelectCell(rtnVal, "note_dp_seq", false);
	       		ComShowCodeMessage('PRI02023', rtnVal);
	       		return false;
	       	}
	   	}
	   	// validate on the case where same content but different note seq is entered
	   	var ibFlag = "";
	   	// duplicated content check is based on only text, not considering empty space on it
    	for(var i=1; i<=sheetObj.RowCount(); i++){
    		ibFlag = sheetObj.GetCellValue(i, "ibflag");
    		sheetObj.SetCellValue(i, "note_ctnt_text", sheetObj.GetCellValue(i, "add_chg_note_ctnt").replace(/\s/gi, ''));
      		sheetObj.SetCellValue(i, "ibflag", ibFlag);
      	}
	   	var ctntDupChk = findArbNoteDupRow(sheetObj, "note_ctnt_text", amdtSeq);
	   	if(ctntDupChk != undefined){
	   		if(!setNoteSeqSynchronized(sheetObj, ctntDupChk, amdtSeq)){
	       		return false;
	       	}
	   	}
	   	return true;
	    }
   
	   /**
	    * Check note seq / content's duplication and Return duplicated rows as array <br>
	    *
	    * @author NYK
	    * @version 2016.08.02
	    */
	   function findArbNoteDupRow(sheetObj, checkStr, amdtSeq){
			 var dupArr = sheetObj.ColValueDupRows(checkStr, false, true).split("|");
			 if(dupArr[0] == undefined || dupArr[0] == ""){
				 return;
			 }
			 var dupArrFirst = dupArr[0].split(",");
			 var dupArrRest = dupArr[1].split(",");
			 var dupArrFinal = new Array();
			 var rtnArrFinal = new Array();
			 var finalArrCnt = 0;
			 // logic to find duplicated row number including first base(reference) row in terms of checkStr parameter
			 for(var k=0; k<dupArrFirst.length; k++){
				 dupArrFinal[finalArrCnt] = dupArrFirst[k];
				 for(var l=0; l<dupArrRest.length; l++){
					 if(sheetObj.GetCellValue(parseInt(dupArrFirst[k]), checkStr) == sheetObj.GetCellValue(parseInt(dupArrRest[l]), checkStr)){
						dupArrFinal[finalArrCnt] += "|" + dupArrRest[l];
					 }
				 }
				 finalArrCnt++;
			 }
			 // exclude empty string case in row duplication check
			 for(var i=0; i<dupArrFinal.length; i++){
				 if(sheetObj.GetCellValue(dupArrFinal[i][0], checkStr) == ""){
					 dupArrFinal.splice(i, 1);
					 break;
				 }
			 }
			 // return duplication row array
			 for(var j=0; j<dupArrFinal.length; j++){
				 rtnArrFinal[j] = dupArrFinal[j].split("|");
			 }
			 return rtnArrFinal;
	}
	   
	   /**
	    * After finding duplicated note content with same note sequence, return the first row index of those are duplicated. <br>
	     *
	     * @author NYK
	     * @version 2016.08.02
	    */
	   function getNoteSeqDuplicated(sheetObj, seqDupChk, amdtSeq) {
	   	var seqDupArr = new Array();
	   	var seqInitialDupArr = new Array();
	   	var seqRestDupArr = new Array();
	   	var wrongCnt = 0;
	   	var rtnDupRow = "";
	   	var rtnDupCtnt = "";
	   	for(var i=0; i<seqDupChk.length; i++){
	   		if(seqDupChk[i].length <= 1){
	   			continue;
	   		}else{
	   			seqDupArr.length = 0;
	   			seqInitialDupArr.length = 0;
	   			seqRestDupArr.length = 0;
	   			// consider note sequence made in last amendment as target of exisiting note sequences for comparison
	   			for(var j=0; j<seqDupChk[i].length; j++){
	   				if(sheetObj.GetCellValue(seqDupChk[i][j], "n1st_cmnc_amdt_seq") == amdtSeq){
	   					seqInitialDupArr.push(seqDupChk[i][j]);
	   				}else{
	   					seqRestDupArr.push(seqDupChk[i][j]);
	   				}
	   				seqDupArr.push(sheetObj.GetCellValue(seqDupChk[i][j], "add_chg_note_ctnt"));
	   			}
	   		}
	   		// return note sequence that is different to other note sequence with same content
    		// duplicated content check is based on only text, not considering empty space on it
	   		for(var k=0; k<seqDupArr.length; k++){
	   			for(var h=k+1; h<seqDupArr.length; h++){
    				if(seqDupArr[k].replace(/\s/gi, '') != seqDupArr[h].replace(/\s/gi, '')){
    					wrongCnt++;
    					if(seqRestDupArr.length == 0){
    						rtnDupCtnt = sheetObj.GetCellValue(seqInitialDupArr[0], "add_chg_note_ctnt");
    					}else{
    						rtnDupCtnt = sheetObj.GetCellValue(seqRestDupArr[0], "add_chg_note_ctnt");
    					}
    					for(var l=0; l<seqInitialDupArr.length; l++){
    						if(sheetObj.GetCellValue(seqInitialDupArr[l], "add_chg_note_ctnt").replace(/\s/gi, '') != rtnDupCtnt.replace(/\s/gi, '')){
    							rtnDupRow = seqInitialDupArr[l];
    							break;
    						}
    					}
    					break;
    				}
    			}
	   			break;
	   		}
	   		if(wrongCnt > 0){
	   			return rtnDupRow;
	   		}
	   	}
	   	return true;
	   }
	   
	   /**
	    * Synchronize note sequence equally based on same content <br>
	     *
	     * @author NYK
	     * @version 2016.08.02
	    */
	   function setNoteSeqSynchronized(sheetObj, ctntDupArr, amdtSeq) {
	   	var syncArr = new Array();
	   	var allSyncCnt = 0;
	   	var syncChkArr = new Array();
	   	var syncChkCnt = 0;
	   	// auto match logic is only applied to inserted/updated rows when saving
	   	for(var m=0; m<ctntDupArr.length; m++){
	   		for(var n=0; n<ctntDupArr[m].length; n++){
	   			if(sheetObj.GetCellValue(ctntDupArr[m][n], "src_info_cd") != "AD" && sheetObj.GetCellValue(ctntDupArr[m][n], "n1st_cmnc_amdt_seq") == amdtSeq
	   				&& (sheetObj.GetCellValue(ctntDupArr[m][n], "ibflag") == "I" || sheetObj.GetCellValue(ctntDupArr[m][n], "ibflag") == "U")){
	   				syncChkCnt++;
	   			}
	   		}
	   		if(syncChkCnt>0){
	   			syncChkArr.push("Y");
	   		}else{
	   			syncChkArr.push("N");
	   		}
	   		syncChkCnt = 0;
	   	}
	   	var ctntDupArrCpy = new Array();
	   	for(var o=0; o<ctntDupArr.length; o++){
	   		if(syncChkArr[o].split(":")[0] == "Y"){
	   			ctntDupArrCpy.push(ctntDupArr[o]);
	   		}
	   	}
	   	ctntDupArr = ctntDupArrCpy;
	   	// Find minimum value on same note sequence rows
	   	for(var i=0; i<ctntDupArr.length; i++){
	   		var eachSyncCnt = 0;
	   		var minValArr = new Array();
	   		minValArr[0] = ctntDupArr[i];
	   		minValArr[1] = new Array();
	   		var tmpMinArr = new Array();
	   		for(j=0; j<ctntDupArr[i].length; j++){
	   			minValArr[1].push(sheetObj.GetCellValue(ctntDupArr[i][j], "note_dp_seq"));
	   			if(amdtSeq>0 && (sheetObj.GetCellValue(ctntDupArr[i][j], "n1st_cmnc_amdt_seq") == amdtSeq)){
	   				continue;
	   			}
	   			tmpMinArr.push(sheetObj.GetCellValue(ctntDupArr[i][j], "note_dp_seq"));
	   		}
	   		if(tmpMinArr[0] == undefined){
	   			minValArr[2] = Math.min.apply(Math, minValArr[1]);
	   		}else{
	   			minValArr[2] = Math.min.apply(Math, tmpMinArr);
	   		}
	       	// check whether same content is inputted with different sequence
	   		for(var k=0; k<minValArr[1].length; k++){
	   			for(var h=k+1; h<minValArr[1].length; h++){
	   				if(minValArr[1][k] != minValArr[1][h]){
	   					eachSyncCnt++;
	   				}
	   			}
	   		}
	   		if(eachSyncCnt > 0){
	   			syncArr.push(minValArr);
	   			allSyncCnt++;
				}
	   	}
	   	// Show soft warning(option) to synchronize note sequence based on content
	   	if(allSyncCnt>0){
	   		if(ComShowCodeConfirm('PRI02024')){
	   			for(var i=0; i<syncArr.length; i++){
	   				for(var j=0; j<syncArr[i][0].length; j++){
	   					if(sheetObj.GetCellValue(syncArr[i][0][j], "n1st_cmnc_amdt_seq") != amdtSeq){
	   						continue;
	   					}
	   					var rowStatus = sheetObj.GetRowStatus(syncArr[i][0][j]);
	   					if(sheetObj.GetCellValue(syncArr[i][0][j], "ibflag") == "I" || sheetObj.GetCellValue(syncArr[i][0][j], "ibflag") == "U"){
	   						sheetObj.SetCellValue(syncArr[i][0][j], "note_dp_seq", syncArr[i][2]);
	   					}
	   					if(rowStatus == "R"){
	   						sheetObj.SetRowStatus(syncArr[i][0][j], "U");
	   					}else{
	   						sheetObj.SetRowStatus(syncArr[i][0][j], rowStatus);
	   					}
	   				}
	       		}
	   		}
		}
	   	 return true;
	   }
   
    