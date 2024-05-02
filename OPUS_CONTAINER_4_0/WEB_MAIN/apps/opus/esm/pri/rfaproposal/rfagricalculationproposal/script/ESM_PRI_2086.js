/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2086.js
*@FileTitle  : GRI Calculation - Route Point Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group : business script for Commodity Group 
     */
    function ESM_PRI_2086() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var beforeIndex=-1;
    var curPntViaType="";
    var curOrgDestType="";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_add":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBINSERT);
				break;
			case "btn_delete":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBDELETE);
				break;
            case "btn_ok":
            	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;
			case "btn_close":
				ComClosePopup(); 
				break;
			case "rt_pnt":
				rtPntOnClick();
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Initializing and setting Sheet basics <br>
	 * Setting body tag's onLoad event handler <br>
	 * Adding pre-handling function after loading screen on the browser  <br>
	 */
	function loadPage() {
		
		if (!opener) opener = window.dialogArguments;
    	if (!opener) opener = window.opener;
    	if (!opener) opener = parent;
    	
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
			ComEndConfigSheet(sheetObjects[i]);
		}
		bIsReqUsr=document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
		bIsAproUsr=document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;
		if (document.form.gri_appl_flg.value == "Y") {
			for (var i=0; i < sheetObjects.length; i++) {
				sheetObjects[i].SetEditable(0);
			}
    		disableButton("btn_add");
    		disableButton("btn_delete");
    		disableButton("btn_ok");
		}
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); 
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        if (document.form.org_dest_tp_cd.value == "O" && document.form.pnt_via_tp_cd.value == "P") {
        	document.form.rt_pnt[0].checked=true;
        } else if (document.form.org_dest_tp_cd.value == "O" && document.form.pnt_via_tp_cd.value == "V") {
        	document.form.rt_pnt[1].checked=true;
        } else if (document.form.org_dest_tp_cd.value == "D" && document.form.pnt_via_tp_cd.value == "V") {
        	document.form.rt_pnt[2].checked=true;
        } else if (document.form.org_dest_tp_cd.value == "D" && document.form.pnt_via_tp_cd.value == "P") {
        	document.form.rt_pnt[3].checked=true;
        }
        rtPntOnClick();
	}
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
        case 1: // sheet1 init
        with(sheetObj){

			    var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|GRI Group Seq.|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|";
			    var headCount=ComCountHeadTitle(HeadTitle);
			
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
			
			    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			     {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			     {Type:"Text",      Hidden:0, Width:230,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			     
			    InitColumns(cols);
			
			    SetEditable(1);
			    //conversion of function[check again]CLT 				InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");	// capital, number only
			    SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			    SetShowButtonImage(2);
			    SetSheetHeight(140);
			    }
			    break;
        case 2: // sheet1 init
			    with(sheetObj){
			
			var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|GRI Group Seq.|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			 {Type:"Text",      Hidden:0,  Width:370,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			 
			InitColumns(cols);
			
			SetEditable(1);
			//conversion of function[check again]CLT 				InitDataValid(0, "rout_via_port_def_cd", vtEngUpOther, "0123456789");	// capital, number only
			SetColProperty(0 ,"rout_via_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			SetShowButtonImage(2);
			SetSheetHeight(140);
			}
			break;
        case 3: // sheet1 init
			with(sheetObj){
			
			var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|GRI Group Seq.|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			{Type:"Text",      Hidden:0,  Width:370,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			//conversion of function[check again]CLT 				InitDataValid(0, "rout_via_port_def_cd", vtEngUpOther, "0123456789");	// capital, number only
			SetColProperty(0 ,"rout_via_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			SetShowButtonImage(2);
			SetSheetHeight(140);
			}
			break;

        case 4: // sheet1 init
			with(sheetObj){
			
			var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|GRI Group Seq.|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			{Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			//conversion of function[check again]CLT 				InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");	// capital, number only
			SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			SetShowButtonImage(2);
			SetSheetHeight(140);
			}
			break;

		}
	}
	/**
	 * calling function when occurring OnChange Event <br>
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "rout_pnt_loc_def_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value=SEARCH05;
				var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=" + formObj.org_dest_tp_cd.value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","L",0);
 					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value=SEARCH11;
				var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=" + formObj.org_dest_tp_cd.value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","G",0);
 					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 2) {
				formObj.f_cmd.value=SEARCH07;
				var param="&cd=" + Value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "nm", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","C",0);
 					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
	    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
	    		return false;
			}
		} else if (colName == "rout_pnt_loc_tp_cd") {
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		}
	}
	/**
	 * calling function when occurring OnChange Event <br>
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "rout_via_port_def_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value=SEARCH05;
				var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "rout_via_port_tp_cd","L",0);
 					sheetObj.SetCellValue(Row, "rout_via_port_def_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value=SEARCH11;
				var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "rout_via_port_tp_cd","G",0);
 					sheetObj.SetCellValue(Row, "rout_via_port_def_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 2) {
				formObj.f_cmd.value=SEARCH07;
				var param="&cd=" + Value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "nm", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "rout_via_port_tp_cd","C",0);
 					sheetObj.SetCellValue(Row, "rout_via_port_def_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
		    		return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
	    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
	    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
	    		return false;
			}
		} else if (colName == "rout_via_port_tp_cd") {
			sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
		}
	}
	/**
	 * calling function when occurring OnChange Event <br>
	 */
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		sheet2_OnChange(sheetObj, Row, Col, Value)
	}
	/**
	 * calling function when occurring OnChange Event <br>
	 */
	function sheet4_OnChange(sheetObj, Row, Col, Value) {
		sheet1_OnChange(sheetObj, Row, Col, Value)
	}
	/**
	 * calling function when occurring OnPopupClick Event <br>
	 */
	var popupRow1=0;
	var popupSheetObj1;
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		popupRow1=Row;
		popupSheetObj1=sheetObj;
		if (colName == "rout_pnt_loc_def_cd") {
			if (sheetObj.GetCellEditable(Row, "rout_pnt_loc_def_cd")) {
				var sUrl="ESM_PRI_4026.do?" + FormQueryString(document.form);
				sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LGC&loc_tp_cd=" + sheetObj.GetCellValue(sheetObj.SetSelectRow, "rout_pnt_loc_tp_cd") + "&org_dest_cd=" + formObj.org_dest_tp_cd.value + "&multi_yn=Y";
				sUrl +="&func=sheet1_returnVal";
				
				//2014.12.10
				//3th popup 
				//ComOpenPopup을 사용하면 일반 popup창이 두개가 뜨면서 window name 이 겹쳐 이전 팝업창이 사라지게됨
	            ComOpenWindowCenter(sUrl, "ESM_PRI_4027",  700, 310, false);
			}
		}
	}
	function sheet1_returnVal(rtnVal) {
		var formObj=document.form;
		if (rtnVal != null && rtnVal.length > 0) {
			for ( var i=0; i < rtnVal.length; i++) {
				if (i == 0) {
					popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_def_cd", rtnVal[i].cd);
					popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_def_nm", rtnVal[i].nm);
					if (rtnVal[i].cd.length == 2) {
						popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_tp_cd", "C");
					} else if (rtnVal[i].cd.length == 4) {
						popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_tp_cd", "G");
					} else if (rtnVal[i].cd.length == 5) {
						popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_tp_cd", "L");
					}
				} else {
					var idx=popupSheetObj1.DataInsert();
					popupSheetObj1.SetCellValue(idx, "prop_no", formObj.prop_no.value);
					popupSheetObj1.SetCellValue(idx, "amdt_seq", formObj.amdt_seq.value);
					popupSheetObj1.SetCellValue(idx, "svc_scp_cd", formObj.svc_scp_cd.value);
					popupSheetObj1.SetCellValue(idx, "gri_grp_seq", formObj.gri_grp_seq.value);
					popupSheetObj1.SetCellValue(idx, "org_dest_tp_cd", curOrgDestType);
					if (curPntViaType == "P") {
						popupSheetObj1.SetCellValue(idx, "gri_rout_pnt_seq", parseInt(ComPriGetMax(sheetObj, "gri_rout_pnt_seq")) + 1);
					} else if (curPntViaType == "V") {
						popupSheetObj1.SetCellValue(idx, "gri_rout_via_seq", parseInt(ComPriGetMax(sheetObj, "gri_rout_via_seq")) + 1);
					}
					popupSheetObj1.SetCellValue(idx, "rout_pnt_loc_def_cd", rtnVal[i].cd);
					popupSheetObj1.SetCellValue(idx, "rout_pnt_loc_def_nm", rtnVal[i].nm);
					if (rtnVal[i].cd.length == 2) {
						popupSheetObj1.SetCellValue(idx, "rout_pnt_loc_tp_cd", "C");
					} else if (rtnVal[i].cd.length == 4) {
						popupSheetObj1.SetCellValue(idx, "rout_pnt_loc_tp_cd", "G");
					} else if (rtnVal[i].cd.length == 5) {
						popupSheetObj1.SetCellValue(idx, "rout_pnt_loc_tp_cd", "L");
					}
				}
			}
		}
	}
	/**
	 * calling function when occurring OnPopupClick Event <br>
	 */
	var popupRow2=0;
	var popupSheetObj2;
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		popupRow2=Row;
		popupSheetObj2=sheetObj;
		if (colName == "rout_via_port_def_cd") {
			if (sheetObj.GetCellEditable(Row, "rout_via_port_def_cd")) {
	            var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LGC&loc_tp_cd=" + sheetObj.GetCellValue(sheetObj.SetSelectRow, "rout_via_port_tp_cd")+"&multi_yn=Y";
	            sUrl +="&func=sheet2_returnVal";
				
				//2014.12.10
				//3th popup 
				//ComOpenPopup을 사용하면 일반 popup창이 두개가 뜨면서 window name 이 겹쳐 이전 팝업창이 사라지게됨
	            ComOpenWindowCenter(sUrl, "ESM_PRI_4027",  700, 325, false);
			}
		}
	}
	function sheet2_returnVal(rtnVal) {
		var formObj=document.form;
		if (rtnVal != null && rtnVal.length > 0) {
			for ( var i=0; i < rtnVal.length; i++) {
				if (i == 0) {
					popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_def_cd", rtnVal[i].cd, 1);
					popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_def_nm", rtnVal[i].nm, 1) ;
					if (rtnVal[i].cd.length == 2) {
						popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_tp_cd", "C", 1);
					} else if (rtnVal[i].cd.length == 4) {
						popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_tp_cd", "G", 1);
					} else if (rtnVal[i].cd.length == 5) {
						popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_tp_cd", "L", 1);
					}
				} else {
					var idx=popupSheetObj2.DataInsert();
					popupSheetObj2.SetCellValue(idx, "prop_no", formObj.prop_no.value);
					popupSheetObj2.SetCellValue(idx, "amdt_seq", formObj.amdt_seq.value);
					popupSheetObj2.SetCellValue(idx, "svc_scp_cd", formObj.svc_scp_cd.value);
					popupSheetObj2.SetCellValue(idx, "gri_grp_seq", formObj.gri_grp_seq.value);
					popupSheetObj2.SetCellValue(idx, "org_dest_tp_cd", curOrgDestType);
					if (curPntViaType == "P") {
						popupSheetObj2.SetCellValue(idx, "gri_rout_pnt_seq", parseInt(ComPriGetMax(sheetObj, "gri_rout_pnt_seq")) + 1);
					} else if (curPntViaType == "V") {
						popupSheetObj2.SetCellValue(idx, "gri_rout_via_seq", parseInt(ComPriGetMax(sheetObj, "gri_rout_via_seq")) + 1);
					}
					popupSheetObj2.SetCellValue(idx, "rout_via_port_def_cd", rtnVal[i].cd);
					popupSheetObj2.SetCellValue(idx, "rout_via_port_def_nm", rtnVal[i].nm);
					if (rtnVal[i].cd.length == 2) {
						popupSheetObj2.SetCellValue(idx, "rout_via_port_tp_cd", "C");
					} else if (rtnVal[i].cd.length == 4) {
						popupSheetObj2.SetCellValue(Row, "rout_via_port_tp_cd", "G");
					} else if (rtnVal[i].cd.length == 5) {
						popupSheetObj2.SetCellValue(idx, "rout_via_port_tp_cd", "L");
					}
				}
			}
		}
	}
	/**
	 * calling function when occurring OnPopupClick Event <br>
	 */
	function sheet3_OnPopupClick(sheetObj, Row, Col) {
		sheet2_OnPopupClick(sheetObj, Row, Col);
	}
	/**
	 * calling function when occurring OnPopupClick Event <br>
	 */
	function sheet4_OnPopupClick(sheetObj, Row, Col) {
		sheet1_OnPopupClick(sheetObj, Row, Col);
	}
	/**
	 * Handling sheet process <br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
//            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
//                ComOpenWait(true);
//            }
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            for (var a=0; a <= 3; a++) {
	            	if (a == 0 || a == 3) {
	    	            for (var i = sheetObjects[a].HeaderRows(); sheetObjects[a].RowCount() > 0 && i <= sheetObjects[a].LastRow(); i++) {
		            		var n1stOrdRef;
		            		if (sheetObjects[a].GetCellValue(i, "rout_pnt_loc_tp_cd") == "C") {
		            			n1stOrdRef=1;
		            		} else if (sheetObjects[a].GetCellValue(i, "rout_pnt_loc_tp_cd") == "G") {
		            			n1stOrdRef=2;
		            		} else if (sheetObjects[a].GetCellValue(i, "rout_pnt_loc_tp_cd") == "L") {
		            			n1stOrdRef=3;
		            		} else {
		            			n1stOrdRef=99;
		            		}
		            		var prevStatus=sheetObjects[a].GetRowStatus(i);
		            		sheetObjects[a].SetCellValue(i, "n1st_ord_ref",n1stOrdRef,0);
		            		sheetObjects[a].SetRowStatus(i,prevStatus);
	    	            }
	            		sheetObjects[a].ColumnSort("n1st_ord_ref|rout_pnt_loc_def_cd", "ASC", "ASC|ASC", true);
	            	} else if (a == 1 || a == 2) {
	    	            for (var i = sheetObjects[a].HeaderRows(); sheetObjects[a].RowCount() > 0 && i <= sheetObjects[a].LastRow(); i++) {
		            		var n1stOrdRef;
		            		if (sheetObjects[a].GetCellValue(i, "rout_via_port_tp_cd") == "C") {
		            			n1stOrdRef=1;
		            		} else if (sheetObjects[a].GetCellValue(i, "rout_via_port_tp_cd") == "G") {
		            			n1stOrdRef=2;
		            		} else if (sheetObjects[a].GetCellValue(i, "rout_via_port_tp_cd") == "L") {
		            			n1stOrdRef=3;
		            		} else {
		            			n1stOrdRef=99;
		            		}
		            		var prevStatus=sheetObjects[a].GetRowStatus(i);
		            		sheetObjects[a].SetCellValue(i, "n1st_ord_ref",n1stOrdRef,0);
		            		sheetObjects[a].SetRowStatus(i,prevStatus);
	    	            }
	            		sheetObjects[a].ColumnSort("n1st_ord_ref|rout_via_port_def_cd", "ASC", "ASC|ASC", true);
	            	}
					var sXml=ComPriSheet2Xml(sheetObjects[a]);
					window.parent.setSheetXml(sXml, a + 4);
	            }
	            ComPopUpReturnValue("O");
	            break; 
			case IBCLEAR: // retrieving code when loading
				var sXml="";
				//comon - type
				sheetObjects[0].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE4[1] , ComboCode:LOCATION_TYPE4[0]} );
				sheetObjects[1].SetColProperty("rout_via_port_tp_cd", {ComboText:LOCATION_TYPE4[1] , ComboCode:LOCATION_TYPE4[0]} );
				sheetObjects[2].SetColProperty("rout_via_port_tp_cd", {ComboText:LOCATION_TYPE4[1] , ComboCode:LOCATION_TYPE4[0]} );
				sheetObjects[3].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE4[1] , ComboCode:LOCATION_TYPE4[0]} );
				//comon term
				formObj.f_cmd.value=SEARCH19;
 				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02138");
				setIBCombo(sheetObjects[0], sXml, "rcv_de_term_cd", true, 0);
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02139");
				setIBCombo(sheetObjects[3], sXml, "rcv_de_term_cd", true, 0);
				break;
			case IBSEARCH: // retrieving from parent sheet
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            for (var a=0; a <= 3; a++) {
					var sXml=window.parent.getSheetXml(a + 4);
					sheetObjects[a].LoadSearchData(sXml,{Sync:1} );
	            	if (a == 0 || a == 3) {
	    	            for (var i = sheetObjects[a].HeaderRows(); sheetObjects[a].RowCount() > 0 && i <= sheetObjects[a].LastRow(); i++) {
		            		var n1stOrdRef;
		            		if (sheetObjects[a].GetCellValue(i, "rout_pnt_loc_tp_cd") == "C") {
		            			n1stOrdRef=1;
		            		} else if (sheetObjects[a].GetCellValue(i, "rout_pnt_loc_tp_cd") == "G") {
		            			n1stOrdRef=2;
		            		} else if (sheetObjects[a].GetCellValue(i, "rout_pnt_loc_tp_cd") == "L") {
		            			n1stOrdRef=3;
		            		} else {
		            			n1stOrdRef=99;
		            		}
		            		var prevStatus=sheetObjects[a].GetRowStatus(i);
		            		sheetObjects[a].SetCellValue(i, "n1st_ord_ref",n1stOrdRef,0);
		            		sheetObjects[a].SetRowStatus(i,prevStatus);
	    	            }
	            		sheetObjects[a].ColumnSort("n1st_ord_ref|rout_pnt_loc_def_cd", "ASC", "ASC|ASC", true);
	            	} else if (a == 1 || a == 2) {
	    	            for (var i = sheetObjects[a].HeaderRows(); sheetObjects[a].RowCount() > 0 && i <= sheetObjects[a].LastRow(); i++) {
		            		var n1stOrdRef;
		            		if (sheetObjects[a].GetCellValue(i, "rout_via_port_tp_cd") == "C") {
		            			n1stOrdRef=1;
		            		} else if (sheetObjects[a].GetCellValue(i, "rout_via_port_tp_cd") == "G") {
		            			n1stOrdRef=2;
		            		} else if (sheetObjects[a].GetCellValue(i, "rout_via_port_tp_cd") == "L") {
		            			n1stOrdRef=3;
		            		} else {
		            			n1stOrdRef=99;
		            		}
		            		var prevStatus=sheetObjects[a].GetRowStatus(i);
		            		sheetObjects[a].SetCellValue(i, "n1st_ord_ref",n1stOrdRef,0);
		            		sheetObjects[a].SetRowStatus(i,prevStatus);
	    	            }
	            		sheetObjects[a].ColumnSort("n1st_ord_ref|rout_via_port_def_cd", "ASC", "ASC|ASC", true);
	            	}
	            }
	         	break; 	
			case IBINSERT: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
		        var idx=sheetObj.DataInsert();
	            sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	            sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	            sheetObj.SetCellValue(idx, "gri_grp_seq",formObj.gri_grp_seq.value);
	            sheetObj.SetCellValue(idx, "org_dest_tp_cd",curOrgDestType);
	            if (curPntViaType == "P") {
	            	sheetObj.SetCellValue(idx, "gri_rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "gri_rout_pnt_seq"))+ 1);
	            } else if (curPntViaType == "V") {
	            	sheetObj.SetCellValue(idx, "gri_rout_via_seq",parseInt(ComPriGetMax(sheetObj, "gri_rout_via_seq"))+ 1);
	            }
	            sheetObj.SelectCell(idx, 10, false);
				break;
			case IBDELETE: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	        	deleteRowCheck(sheetObj, "chk");
				break;
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {
        	ComOpenWait(false);
        }
	}
	/**
	 * checking validation process of inputed form data <br>
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH: // retrieve
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
            return true;
            break;
        case IBSAVE: // save
        	if (!validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC15: // radio button Validation
            if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
                return false;
            }
        	var dupRow=-1;
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
        		dupRow=sheetObj.ColValueDup("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd", false);
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
        		dupRow=sheetObj.ColValueDup("rout_via_port_tp_cd|rout_via_port_def_cd", false);
        	}
        	if (dupRow >= 0) {
        		sheetObj.SetSelectRow(dupRow);
				ComShowCodeMessage("PRI00302");
				return false;
        	}
            return true;
            break;
        case IBINSERT: // Row Add
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
            return true;
            break;
        case IBDELETE: // Delete
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount() <= 0) {
        		return false;
        	}
        	return true;
            break;
        }
    }
	function rtPntOnClick() {
		var curIndex=parseInt(getRtPnt());
		if (beforeIndex != curIndex) {
			if (beforeIndex >= 0 && !validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
				document.form.rt_pnt[beforeIndex].checked=true;
				return false;
			}
			if (curIndex == 0) {
				curPntViaType="P";
			    curOrgDestType="O";
			} else if (curIndex == 1) {
				curPntViaType="V";
			    curOrgDestType="O";
			} else if (curIndex == 2) {
				curPntViaType="V";
			    curOrgDestType="D";
			} else if (curIndex == 3) {
				curPntViaType="P";
			    curOrgDestType="D";
			}
			document.form.org_dest_tp_cd.value=curOrgDestType;
			document.form.pnt_via_tp_cd.value=curPntViaType;
		    var objs=document.all.item("sheetLayer");
		    document.form.rt_pnt[curIndex].focus();
		    objs[curIndex].style.display="inline";
		    if (beforeIndex >= 0) {
				objs[beforeIndex].style.display="none";
		    }
		    beforeIndex=curIndex;
		}
	}
    function getRtPnt() {
        for (var i=0; i < document.form.rt_pnt.length; i++) {
            if (document.form.rt_pnt[i].checked) {
                return document.form.rt_pnt[i].value;
            }
        }
    }
