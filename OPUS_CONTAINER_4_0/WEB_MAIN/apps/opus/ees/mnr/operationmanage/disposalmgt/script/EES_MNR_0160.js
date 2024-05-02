/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0160.js
*@FileTitle  : Disposal Sold Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
 Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0160 : ees_mnr_0160 - Defining a script used by screen
	 */
	/* ********* General Functions ************* */
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var currCd=null;
	var partAmt=null;
	var dispUtTpCd=null;
	var dispQty=null;
	var dispTrkrNm=null;
	var dispUtPrc=null;
	var dispRsnCd=null;
	var invAmt=null;
	var file_seq=null;
	var rcvInvSeq=null;
	var mnrPrnrCntCd=null;
	var mnrPrnrSeq=null;
	var creUsrId=null;
	var creDt=null;
	var sXml_1="";
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		var obj = event.target || event.srcElement;
			   if ($(obj).prop('disabled')) {
			 return;
			 }
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,0);
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,1);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[1],document.form,IBSAVE);
					break;
				//Opening calendar
				case "apro_dt_cal":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.apro_dt_fr, formObject.apro_dt_to, 'yyyy-MM-dd');
					break;
				//Multi inserting
				case "disp_no_multi":
				    rep_Multiful_inquiry("disp_no");
					break;
				//Multi inserting
				case "eq_no_multi":
					rep_Multiful_inquiry("eq_no");
					break;
				//Buyer PopUp
				case "buyer_no_popup":
					ComOpenPopup('COM_ENS_041.do', 770, 510, 'setBuyer', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;
				case "btn_LoadExcel":
					doActionIBSheet(sheetObjects[1],document.form,IBLOADEXCEL);
					break;
				case "btn_DownExcel":
					if(sheetObjects[1].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
						}
					break;
				//Doc Send
				case "btn_DocSend":
					doActionIBSheet(sheetObjects[0],formObject,"DOCSEND");
					break;
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	// Setting button
    	MnrWaitControl(true);
    	// Initializing IBMultiCombo
    	for ( var k=0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	// IBInitializing sheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Axon Initializing event
		initControl();
		//Initializing screen
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }
  	/**
     * Initializing IBCombo
     * @param	{IBCombo}	comboObj	Object for initialized IBCombo
     * @param	{Number}	comboNo		Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form;
	    switch(comboNo) {
	    	case 1:
	            with (comboObj) {
	    			SetColAlign(0, "left");
	    			SetDropHeight(44);
			    }
	     }
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
    /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
		              var HeadTitle1="|Seq.|Disposal No.|Appoval DT|Buyer Code|Buyer Name|Sold Q'ty|Pending Q'ty|Total Q'ty";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              (headCount + 5, 3, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"apro_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"buyer_code",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"buyer_name",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"sold_qty",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pending_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"total_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"eq_knd_cd" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"mnr_prnr_cnt_cd" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"mnr_prnr_seq" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"fax_no" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_eml" } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
//		              SetSheetHeight(360);
		              resizeSheet( sheetObj );
                }
		        break;
		    case "sheet2":
		        with(sheetObj){
			      var HeadTitle1="|Sel|Seq|EQ No|TP/SZ|Release No|P/Up Yard|Sold DT|Inv No|Charge Code|Remark(s)";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount + 23, 0, 0, true);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk"},
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"disp_rlse_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"disp_yd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
			             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"disp_sold_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",    ColMerge:1, SaveName:"chg_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_disp_dtl_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4000 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Right",   ColMerge:1,   SaveName:"part_amt" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"disp_no" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"disp_dtl_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"disp_ut_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"disp_qty" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"disp_trkr_nm" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"disp_ut_prc" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"disp_rsn_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inv_amt" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"file_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"rcv_inv_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_cnt_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"cre_dt" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"disp_sold_dt_flg" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"disp_rlse_no_flg" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"old_eq_no" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"old_eq_tpsz_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"old_eq_disp_yd_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"old_sold_dt" }
			              ];
			       
			      		InitColumns(cols);
	
			      		SetEditable(1);
			            SetShowButtonImage(2);
//				        SetSheetHeight(360);
			            resizeSheet( sheetObj );
		      }
		      break;
        }
    }
    /**
	 * Defining event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form);
	//    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form);
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);
    }
	/**
	 * Assigning array of IBCombo object
	 * @param    {IBCombo}	combo_obj        Registered as an array IBCombo Object
	 */
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * Onblur event handling <br>
     **/
    function obj_blur(){
		ComChkObjValid(ComGetEvent());
	}
	/**
     * OnFocus event handling <br>
     **/
    function obj_focus(){
    	ComClearSeparator(ComGetEvent());
    }
    
    
	/**
	 * OnChange event handling <br>
	 * @return
	 */
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "buyer_code":
					setCustomerName();
				   	break;
			}
	    }
	}
    /**
     * Event handling of Onchange of combo
     * @param comboObj
     * @param Index_Code
     * @param Text
     * @return
     */
    function comboStt_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		// Initializing all sheet
		for (i=0; i < sheetObjects.length; i++) {
			sheetObjects[i].RemoveAll();
		}
        if(oldIndex == 0) {
    		document.getElementById("iBtn_DocSend").style.display="inline";
        } else {
        	document.getElementById("iBtn_DocSend").style.display="none";
        }
        document.form.status.value = comboObj.GetSelectCode();
        setBtnDocSend();
    }
	/**
	 * Event handling of OnSelectedCell of sheet1
	 * @param	{Sheet}			sheetObj	Used sheet object
	 * @param	{Long}			OldRow		Selected Cell of Row Index
	 * @param	{Long/String}	OldCol		Selected Cell of Column Index or SaveName
	 * @param	{Long}			NewRow		To select cell Row Index
	 * @param	{Long/String}	NewCol		To select cell Column Index or SaveName
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        var formObject=document.form;
		formObject.selected_disp_no.value=sheetObj.GetCellValue(NewRow, "disp_no");
		formObject.selected_mnr_prnr_cnt_cd.value=sheetObj.GetCellValue(NewRow, "mnr_prnr_cnt_cd");
		formObject.selected_mnr_prnr_seq.value=sheetObj.GetCellValue(NewRow, "mnr_prnr_seq");
        doActionIBSheet(sheetObjects[1],formObject,IBSEARCH_ASYNC01, 1);
	}
	/**
	 * Setting after retrieving
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		setBtnDocSend();
		if(sheetObj.RowCount()==0){
			sheetObjects[1].RemoveAll();
		}
	}
	/**
	 * Event handling of OnSearchEnd of sheet2
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		if(sheetObj.RowCount()> 0) {
			//Setting (EQ No, Sel) and Sold DT
			for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
				//Sel (Relative inv_no)
				var invNo=sheetObj.GetCellValue(i, "inv_no");
				var chgCd=sheetObj.GetCellValue(i, "chg_cd");
				if((invNo != "" && invNo != null)||(chgCd == "EQS")) {
					sheetObj.SetCellEditable(i, "del_chk", 1);
					sheetObj.SetCellEditable(i, "eq_no", 0);
					sheetObj.SetCellEditable(i, "disp_rlse_no", 0);
					sheetObj.SetCellEditable(i, "disp_yd_cd", 0);
					
					if(sheetObj.GetCellValue(i, "disp_sold_dt") == "" || sheetObj.GetCellValue(i, "disp_sold_dt") == null){
						sheetObj.SetCellEditable(i, "disp_sold_dt", 1);
					}else{
						sheetObj.SetCellEditable(i, "disp_sold_dt", 0);
					}
					sheetObj.SetCellEditable(i, "mnr_disp_dtl_rmk", 0);
				} else {
					sheetObj.SetCellEditable(i, "del_chk",0);
				}
			}
			currCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "curr_cd");
			partAmt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "part_amt");
			dispUtTpCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "disp_ut_tp_cd");
			dispQty=sheetObj.GetCellValue(sheetObj.HeaderRows(), "disp_qty");
			dispTrkrNm=sheetObj.GetCellValue(sheetObj.HeaderRows(), "disp_trkr_nm");
			dispUtPrc=sheetObj.GetCellValue(sheetObj.HeaderRows(), "disp_ut_prc");
			dispRsnCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "disp_rsn_cd");
			invAmt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "inv_amt");
			rcvInvSeq=sheetObj.GetCellValue(sheetObj.HeaderRows(), "rcv_inv_seq");
			mnrPrnrCntCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "mnr_prnr_cnt_cd");
			mnrPrnrSeq=sheetObj.GetCellValue(sheetObj.HeaderRows(), "mnr_prnr_seq");
			creUsrId=sheetObj.GetCellValue(sheetObj.HeaderRows(), "cre_usr_id");
			creDt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "cre_dt");
			//ReleaseNo creating and setting
			setReleaseNo(sheetObj);
		}
		setBtnLoadExcel(); //Load Excel Setting button
	}
	/**
	 * Event handling of OnChange of sheet2
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet2_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
			//EQ No
			if(colname == 'eq_no') {
				if(Value!="" && Value!=null){
					setEqNoInfo(sheetObj,Row,Col);
				} else {
					setEqNoClear(sheetObj,Row);
				}
			}
			//P/Up Yard
			else if(colname == 'disp_yd_cd') {
				if(Value!="" && Value!=null) {
					checkPUpYardCd(sheetObj,Row,Col);
				}
			}
		}
	}
	/**
	 * Event handling of OnPopupClick of sheet2
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet2_OnPopupClick(sheetObj,Row,Col){
        if (sheetObj.ColSaveName(Col) != "disp_sold_dt") return;
        var cal=new ComCalendarGrid();
        cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
	/**
	 * Showing result message after saving
	 * @param	{IBSheet}	sheetObj	target object
	 * @param	{String}	ErrMsg
	 */
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00023");
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,0);
			var mnrPrnrCntCd=ComGetEtcData(sXml_1,"mnr_prnr_cnt_cd");
			var mnrPrnrSeq=ComGetEtcData(sXml_1,"mnr_prnr_seq");
			for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
				if(sheetObj.GetCellValue(i,"mnr_prnr_cnt_cd") == mnrPrnrCntCd && sheetObj.GetCellValue(i,"mnr_prnr_seq") == mnrPrnrSeq){
					//FOCUS
					sheetObj.SelectCell(i, 1);
					//DETAIL Retrieving
					document.form.f_cmd.value=SEARCH01;
					var sXml=sheetObjects[1].GetSearchData("EES_MNR_0160GS.do", FormQueryString(document.form));
					sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
				}
			}
		}
		else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
    /**
     * Sheet related process processing
     *
     * @param {IBSheet}sheetObj Used sheet object
     * @param {Form}formObj Used form object
     * @param {Number}sAction Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	    	// Initializing
	    	case IBCLEAR:
	    		sheetObj.WaitImageVisible = false;
	    		MnrWaitControl(true);
	    		// Initializing all sheet
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    		// Only Loading
	    		if (sActionIdx == 0) {
	    			//Initializing combo data of Condition part 
	    			for ( var i=0; i < comboObjects.length; i++) {
	    				comboObjects[i].RemoveAll();
	    			}
					//Retrieving combo data(Status)
					var sCondition=new Array (
						new Array("MnrGenCd","CD00063", "COMMON"), 	//Status
						new Array("MnrGenCd","","CUSTOM9")		//EQ Type
					)
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
	    			// Setting combo
	    			for ( var i=0; i < comboList.length; i++) {
	    				if (comboList[i] != null) {
							for(var j=0; j < comboList[i].length;j++){
								var tempText=comboList[i][j].split("|");
								//Status
		    					if(i==0) {
		    						comboStt.InsertItem(j, tempText[1], tempText[0]);
		    						comboStt.SetSelectIndex(0);
		    					}
		    					//EQ Type
		    					else if(i==1) {
		    						eq_knd_cd.InsertItem(j, tempText[1], tempText[0]);
		    						eq_knd_cd.SetSelectIndex(0);
		    						eq_knd_cd.SetDropHeight(65);
		    					}
							}
	    				}
	    			}
	    		}
	    		// Value setting of initialize
//	    		formObj.comboStt.focus();
	    		comboStt.SetSelectCode("I");//Status(I:R/O Issue, S:R/O Send)
	    		eq_knd_cd.SetSelectCode("U");//EQ Type
	    		formObj.apro_dt_fr.value=ComGetDateAdd(ComGetNowInfo("ymd"), "M", -2);	//Approval Period From
	    		formObj.apro_dt_to.value=ComGetNowInfo("ymd");							//Approval Period To
	    		formObj.disp_no.value="";											//Disporal No
	    		formObj.eq_no.value="";											//EQ No
	    		formObj.buyer_code.value="";											//Buyer Code
	    		formObj.buyer_name.value="";											//Buyer Name
	    		formObj.mnr_prnr_cnt_cd.value="";	 										//Buyer Code(hidden code 1)
	    		formObj.mnr_prnr_seq.value="";
				formObj.selected_mnr_prnr_cnt_cd.value="";									//Buyer Code(hidden code 1)
	    		formObj.selected_mnr_prnr_seq.value="";									//Buyer Code(hidden code 2)
	    		MnrWaitControl(false);
	    		sheetObj.SetWaitImageVisible(1);
	    		setBtnLoadExcel();		//Setting activated of load excel button
	    		setBtnDocSend();		//Setting activated of doc send button
	    		break;
    		//Retrieving(Master)
			case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					sheetObjects[0].SetWaitImageVisible(1);
//					sheetObjects[1].SetWaitImageVisible(1);
					var sXml=sheetObj.GetSearchData("EES_MNR_0160GS.do", FormQueryString(formObj));
					//sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
//					sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
//					sheetObjects[1].WaitImageVisible = false;
					sheetObjects[0].WaitImageVisible = false;
				}
				break;
			//Retrieving(Detail)
			case IBSEARCH_ASYNC01:
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.SetWaitImageVisible(1);
					formObj.f_cmd.value=SEARCH01;
					var sXml=sheetObj.GetSearchData("EES_MNR_0160GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObj.WaitImageVisible = false;
				}
				break;
			//Saving
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
					//Changing status and setting disp_sold_dt_flag before save
					for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
						if(sheetObjects[1].GetRowStatus(i) == "R") {
							sheetObjects[1].SetRowStatus(i,"U");
						}
						//Setting disp_sold_dt_flag
						var dispSoldDtFlg=sheetObjects[1].GetCellValue(i, "disp_sold_dt_flg");
						var dispSoldDt=sheetObjects[1].GetCellValue(i, "disp_sold_dt");
						if(dispSoldDtFlg=="D") {
							if(dispSoldDt!="" && dispSoldDt!=null) {
								sheetObjects[1].SetCellValue(i, "disp_sold_dt_flg","Y");
							}
						}
						if(dispSoldDtFlg=="E") {
							if(dispSoldDt=="" || dispSoldDt==null) {
								sheetObjects[1].SetCellValue(i, "disp_sold_dt_flg","N");
							} else {
								var eqNo=sheetObjects[1].GetCellValue(i, "eq_no");
								var oldEqNo=sheetObjects[1].GetCellValue(i, "old_eq_no");
								if(oldEqNo!=eqNo){
									sheetObjects[1].SetCellValue(i, "disp_sold_dt_flg","U");
								}
							}
						}
					}
					formObj.f_cmd.value=MULTI;
					var sParam=sheetObjects[1].GetSaveString(true, true);
					if(sParam == "" && sheetObjects[1].IsDataModified()){
						return;
					}
					sParam=ComSetPrifix(sParam,"dispDtl_");
					sParam += "&" + FormQueryString(formObj);
					var sXml=sheetObjects[1].GetSaveData("EES_MNR_0160GS.do", sParam);
//					sheetObj.LoadSaveData(sXml);
					
					if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S") {
						ComShowCodeMessage("MNR00023");
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,0);
						var mnrPrnrCntCd=ComGetEtcData(sXml,"mnr_prnr_cnt_cd");
						var mnrPrnrSeq=ComGetEtcData(sXml,"mnr_prnr_seq");
						for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
							if(sheetObj.GetCellValue(i,"mnr_prnr_cnt_cd") == mnrPrnrCntCd && sheetObj.GetCellValue(i,"mnr_prnr_seq") == mnrPrnrSeq){
								//FOCUS
								sheetObj.SelectCell(i, 1);
								//DETAIL Retrieving
								document.form.f_cmd.value=SEARCH01;
								var sXml=sheetObjects[1].GetSearchData("EES_MNR_0160GS.do", FormQueryString(document.form));
								sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
							}
						}
					}
					else {
						ComShowCodeMessage("MNR00008", MnrComGetErrMsg1(sXml));
					}
					
				}
				break;
	        //Load Excel
			case IBLOADEXCEL:
				if(validateForm(sheetObj,formObj,sAction)) {
					var insCnt=getInsCnt();
					ComOpenPopup('/opuscntr/EES_MNR_0221.do?insCnt='+insCnt, 500, 430, 'setEES_MNR_221', '0,1,1,1,1,1,1,1,1,1,1,1');
				}
				break;
		    //Doc Send
        	case "DOCSEND":
        		if(validateForm(sheetObj,formObj,sAction)) {
        			var dispNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "disp_no");  		//Disposal No
        			var userNm=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "buyer_name");		//Buyer Name
        			var mnrPrnrCntCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "mnr_prnr_cnt_cd");	//mnr_prnr_cnt_cd
        			var mnrPrnrSeq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "mnr_prnr_seq");		//mnr_prnr_seq
        			var faxNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "fax_no");			//fax_no
        			var mnrPrnrEml=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "mnr_prnr_eml");		//mnr_prnr_eml
        			ComOpenPopup('/opuscntr/EES_MNR_0235.do?disp_no='+dispNo+'&user_nm='+userNm+'&mnr_prnr_cnt_cd='+mnrPrnrCntCd+'&mnr_prnr_seq='+mnrPrnrSeq+'&fax_no='+faxNo+'&mnr_prnr_eml='+mnrPrnrEml, 900, 600, '', '0,1,1,1,1,1,1,1', true);
        		}
        		break;
        }
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		// Retrieving
    		if (sAction == IBSEARCH) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {
    				return false;
    			}
    		}
    		// In case of saving
    		else if (sAction == IBSAVE) {
				//Checking grid row data
				if(sheetObjects[1].RowCount()< 1) {return false;}
				if(!sheetObjects[1].IsDataModified()) {return false;}
				var chkRows=sheetObjects[1].FindCheckedRow("del_chk");
				var arrChkRows=chkRows.split("|");
 				if(arrChkRows.length >= 1 && ComIsEmpty(arrChkRows[0])){
 					ComShowCodeMessage("MNR00024");	 					
 					return false;
 				}
				//Checking duplicate
				var Row=sheetObjects[1].ColValueDup("eq_no");
				if(Row>0){
					ComShowCodeMessage("MNR00006",(Row) + " row ");
					sheetObjects[1].SelectCell(Row, "eq_no", true);
					return false;
				}
				for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
					var eqNo=sheetObjects[1].GetCellValue(i, "eq_no");		//EQ No
					var dispRlseNo=sheetObjects[1].GetCellValue(i, "disp_rlse_no");	//Release No
					var dispSoldDt=sheetObjects[1].GetCellValue(i, "disp_sold_dt");	//Sold DT
					var chk = sheetObjects[1].GetCellValue(i, "del_chk");
					
					if(eqNo=="" || eqNo==null) {
						if(chk == 1){
							if(dispRlseNo!="" && dispRlseNo!=null) {
								ComShowCodeMessage("MNR00294", "Release No");
								sheetObjects[1].SelectCell(i, "eq_no");
								return false;
							}
							if(dispSoldDt!="" && dispSoldDt!=null) {
								ComShowCodeMessage("MNR00294", "Sold DT");
								sheetObjects[1].SelectCell(i, "eq_no");
								return false;
							}
						}
					} else {
						if(chk == 1){
							var dispYdCd=sheetObjects[1].GetCellValue(i, "disp_yd_cd");
							if(dispYdCd.length < 7) {
								ComShowCodeMessage("MNR00332");
								sheetObjects[1].SelectCell(i, "disp_yd_cd");
								return false;
							}
							var dispSoldDt=sheetObjects[1].GetCellValue(i, "disp_sold_dt");	//Sold DT
							if(dispSoldDt=="" || dispSoldDt==null) {
								ComShowCodeMessage("MNR00005", "Sold DT");
								sheetObjects[1].SelectCell(i, "disp_sold_dt");
								return false;
							}
						}
					}
				}
    		}
    		// Load Excel
    		else if (sAction == IBLOADEXCEL) {
    			var insCnt=getInsCnt();
				if(insCnt == 0) {
					ComShowCodeMessage("MNR00265");
					return false;
				}
    		}
    		else if (sAction == "DOCSEND") {
    			if(sheetObjects[0].RowCount()<1) {
    				return false;
    			}
    		}
        }
        return true;
    }
/* ********* User Functions ************* */
	/**
	 * (Customer) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 */
    function setBuyer(aryPopupData) {
    	if ( aryPopupData.length > 0 ) {
    		var formObj=document.form;
    		var custCd=aryPopupData[0][3];
    		var custNm=aryPopupData[0][4];
    		var mnrPrnrCntCd=custCd.substring(0,2);
    		var mnrPrnrSeq=custCd.substring(2);
    		formObj.buyer_code.value=custCd;
    		formObj.buyer_name.value=custNm;
    		formObj.mnr_prnr_cnt_cd.value=mnrPrnrCntCd;
    		formObj.mnr_prnr_seq.value=mnrPrnrSeq;
    	}
    }
    /**
	 * rep_Multiful_inquiry : Processing the returned data
	 * @param	{Array}		rowArray	Retruned array
	 * @param	{String}	return_val	Retruned form element name
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj=document.form;
 		var tempText="";
 		//Initializing
		eval("document.form." + return_val + ".value='';");
 		for(var i=0; i<rowArray.length; i++) {
 			tempText +=  rowArray[i] + ',';
 		}
 		//Removing last comma
 		tempText=MnrDelLastDelim(tempText);
 		eval("document.form." + return_val + ".value='" + tempText + "';");
 	}
	/**
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		var dispUtTpCd=sheetObj.GetCellValue(Row, "disp_ut_tp_cd");		//Sale Type(E:Unit Sale, Q:Bulk Sale)
		//Checking existed EQ NumberRetrieving
		var rqstEqNo=sheetObj.GetCellValue(Row, "eq_no");  									//EQ No
		var eqKndCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "eq_knd_cd");	//EQ Type
		var dispNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "disp_no");		//Disposal No
		var eqTpszCd=sheetObj.GetCellValue(Row,"eq_tpsz_cd");  								//TP/SZ
		if(dispUtTpCd=="E") {	//Sale Type(Unit Sale)
			var retArray=MnrGeneralCodeCheck(sheetObj,"DSPEQN",rqstEqNo + "," + eqKndCd + "," + dispNo);
		} else {				//Sale Type(Bulk Sale)
			var retArray=MnrGeneralCodeCheck(sheetObj,"DSPEQN",rqstEqNo + "," + eqKndCd + "," + dispNo + "," +eqTpszCd);
		}
		if(retArray == null){
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");
			setEqNoClear(sheetObj,Row,dispUtTpCd);
			return;
		} else {
			var tempText=retArray[0].split("|");
			if(tempText[1] != 'OK'){
				ComShowCodeMessage("MNR00302",tempText[0]);
				setEqNoClear(sheetObj,Row,dispUtTpCd);
				return;
			}
		}
		if(dispUtTpCd=="E") {
			var formObj=document.form;
			var totalLossDate=ComGetNowInfo("ymd");
			var sCostType="";
			if(eqKndCd == "U"){
				sCostType="MRDRRC";
			} else if(eqKndCd == "G"){
				sCostType="MRGSRC";
			} else {
				sCostType="MRZSRC";
			}
			var sXml=MnrComEqGenInfoSearch(sheetObj,eqKndCd,rqstEqNo,totalLossDate,sCostType);
			var retArr=MnrXmlToArray(sXml);
			//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
			if(retArr == null){
				setEqNoClear(sheetObj,Row,dispUtTpCd);
				return;
			}
			sheetObj.SetCellValue(Row, "eq_tpsz_cd",retArr[0][31],0);//TP/SZ
		}
		sheetObj.SetCellValue(Row, "disp_rlse_no",getReleaseNo(sheetObj,Row),0);//Release No
	}
	/**
	 * @param sheetObj
	 * @param Row
	 * @return
	 */
	function setEqNoClear(sheetObj,Row,dispUtTpCd) {
		sheetObj.SetCellValue(Row, "eq_no","",0);//EQ No
		//Unit Sale
		if(dispUtTpCd=="E") {
			sheetObj.ReturnCellData(Row, "eq_tpsz_cd");		//TP/SZ
		}
		sheetObj.SetCellValue(Row, "disp_rlse_no","",0);//Release No
		sheetObj.SetCellValue(Row, "disp_sold_dt","",0);//Sold DT
	}
	/**
	 * @param sheetObj
	 * @return
	 */
	function getReleaseNo(sheetObj,Row){
		document.form.f_cmd.value=SEARCH02;
		var sXml=sheetObj.GetSearchData("EES_MNR_0160GS.do", FormQueryString(document.form));
		var maxDispRlseNoSuffix=parseInt(ComGetEtcData(sXml, "dispRlseNo"),10);
        var dispRlseNoPrefix=currOfcCd + ComReplaceStr(ComGetNowInfo("ymd"), "-", "");
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			var rowStatus=sheetObj.GetRowStatus(i);
			if(rowStatus!="D" && i!=Row) {
				var rowDispRlseNo=sheetObj.GetCellValue(i, "disp_rlse_no");
				if(rowDispRlseNo!="" && rowDispRlseNo!=null) {
					var rowDispRlseNoPrefix=rowDispRlseNo.substring(0, rowDispRlseNo.indexOf("-"));
					if(rowDispRlseNoPrefix==dispRlseNoPrefix) {
						var rowDispRlseNoSuffix=parseInt(rowDispRlseNo.substring(rowDispRlseNo.length-3),10);
						if(maxDispRlseNoSuffix < rowDispRlseNoSuffix) {
							maxDispRlseNoSuffix=rowDispRlseNoSuffix;
						}
					}
				}
			}
		}
		var newDispRlseNoSuffix=maxDispRlseNoSuffix + 1;
		var dispRlseNo=dispRlseNoPrefix + '-' + ComLpad((newDispRlseNoSuffix + ''),3,"0");;
		return dispRlseNo;
	}
    /**
     * @param sheetObj
     * @return
     */
	function setReleaseNo(sheetObj) {
		document.form.f_cmd.value=SEARCH02;
		var sXml=sheetObj.GetSearchData("EES_MNR_0160GS.do", FormQueryString(document.form));
		var maxDispRlseNoSuffix=ComGetEtcData(sXml, "dispRlseNo");
		maxDispRlseNoSuffix=parseInt(maxDispRlseNoSuffix,10);
		var dispRlseNoFlgCnt=0;
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++){
			var dispRlseNoFlg=sheetObj.GetCellValue(i, "disp_rlse_no_flg");
			if(dispRlseNoFlg=="Y") {
				dispRlseNoFlgCnt++;
				var newDispRlseNoSuffix=maxDispRlseNoSuffix + dispRlseNoFlgCnt;
				newDispRlseNoSuffix=ComLpad((newDispRlseNoSuffix + ''),3,"0");
				var dispRlseNo=currOfcCd + ComReplaceStr(ComGetNowInfo("ymd"), "-", "") + '-' + newDispRlseNoSuffix;
				sheetObj.SetCellValue(i, "disp_rlse_no",dispRlseNo);
			}
		}
	}
	/**
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function checkPUpYardCd(sheetObj,Row,Col) {
		var dispYdCd=sheetObj.GetCellValue(Row, "disp_yd_cd");
		var retArray=MnrGeneralCodeCheck(sheetObj,"SLDYARD",dispYdCd);
		if(retArray == null){
			ComShowCodeMessage("MNR00165",dispYdCd,"YARD");
			sheetObj.ReturnCellData(Row, "disp_yd_cd");
			sheetObj.SelectCell(Row, "disp_yd_cd");
		}
	}
	/**
	 * In case of saving Checking grid row data
	 */
	function checkIsDetailRow(){
		var cnt=0;
		for (var i=1; i<6; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}
		return true;
	}
	/**
	 * Processing of returned value of pop-up screen (EES_MNR_0221)
	 */
	function setEES_MNR_221(aryPopupData){
    	 var formObj=document.form;
    	 var eqNos=new Array();
    	 var pUpYards=new Array();
    	 var dispSoldDt=new Array();
		 for(var i=0; i<aryPopupData.length; i++) {
			 eqNos[i]=aryPopupData[i][4];
			 pUpYards[i]=aryPopupData[i][5];
			 dispSoldDt[i]=aryPopupData[i][6];
		 }
		 var insCnt=0;
		 for(var j=sheetObjects[1].HeaderRows(); j<=sheetObjects[1].LastRow(); j++) {
			 var eqNo=sheetObjects[1].GetCellValue(j, "eq_no");
			 if(eqNo == "" || eqNo == null) {
				 if(eqNos[insCnt] !="" && eqNos[insCnt] != null) {
					 sheetObjects[1].SetCellValue(j, "eq_no",eqNos[insCnt]);
					 sheetObjects[1].SetCellValue(j, "disp_yd_cd",pUpYards[insCnt]);
					 if(dispSoldDt[insCnt] !="" && dispSoldDt[insCnt] !=null) {
						 sheetObjects[1].SetCellValue(j, "disp_sold_dt",dispSoldDt[insCnt]);
					 } else {
						 sheetObjects[1].SetCellValue(j, "disp_sold_dt",ComGetNowInfo("ymd"));
					 }
					 insCnt++;
				 }
			 }
		 }
	}
	/**
	 * @return int insCnt
	 */
    function getInsCnt() {
		var insCnt=0;
		for(var i=sheetObjects[1].HeaderRows(); i<=sheetObjects[1].LastRow(); i++) {
			var eqNo=sheetObjects[1].GetCellValue(i, "eq_no");
			if(eqNo=="" || eqNo==null) {
				insCnt++;
			}
		}
		return insCnt;
    }
    /**
     * Setting load-excel button status
     * @return
     */
    function setBtnLoadExcel() {
    	var rowCnt=sheetObjects[1].RowCount();
    	var eqNoNullCnt=getInsCnt();
    	if(rowCnt>0 && eqNoNullCnt>0) {
    		ComBtnEnable("btn_LoadExcel");
    	} else {
    		ComBtnDisable("btn_LoadExcel");
    	}
    }
    /**
     * Setting Doc send button status
     * @return
     */
    function setBtnDocSend() {
    	var status=comboStt.GetSelectCode();
    	//alert(status);
    	var rowCnt=sheetObjects[0].RowCount();
    	if(status=="S" && rowCnt>0) {
    		ComBtnEnable("btn_DocSend");
    	} else {
    		ComBtnDisable("btn_DocSend");
    	}
    }
    /**
     * Retrieving Condition part Buyer at inserting Buyer
     * @return
     */
	function setCustomerName(){
		MnrWaitControl(true);
		sheetObjects[0].SetEnable(0);
		var formObj=document.form;
		var custCd=formObj.buyer_code.value;
		var mnrPrnrCntCd=custCd.substring(0,2);
		var mnrPrnrSeq=custCd.substring(2);
		mnrPrnrSeq=ComLpad(mnrPrnrSeq, 6, "0");
		formObj.buyer_code.value=mnrPrnrCntCd + mnrPrnrSeq;
		var	sXml=MnrComCustomerInfoSearch(sheetObjects[0],mnrPrnrCntCd,mnrPrnrSeq);
		var arrResult=MnrXmlToArray(sXml);
		if(arrResult != null){
       		formObj.buyer_name.value=arrResult[0][10];
       		formObj.mnr_prnr_cnt_cd.value=mnrPrnrCntCd;
       		formObj.mnr_prnr_seq.value=mnrPrnrSeq;
		} else {
			ComShowCodeMessage("MNR00121");
			formObj.buyer_code.value="";
       		formObj.buyer_name.value="";
       		formObj.mnr_prnr_cnt_cd.value="";
       		formObj.mnr_prnr_seq.value="";
		}
		sheetObjects[0].SetEnable(1);
		MnrWaitControl(false);
	}
