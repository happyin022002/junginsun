/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3012.js
*@FileTitle  : TRI GRI Calculation - Route Point Select 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class Commodity Group : business script for Commodity Group  
 */
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
            	doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSAVE);
            	ComPopUpReturnValue("O");
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
			      var HeadTitle="|Sel.|Seq.|trf_pfx_cd|trf_no|GRI Group Seq.|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|Trans Mode";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetShowButtonImage(2);
			      SetSheetHeight(140);
				}
			break;
		case 2: // sheet1 init
		    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|trf_pfx_cd|trf_no|GRI Group Seq.|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_no",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:370,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetShowButtonImage(2);
			      SetSheetHeight(140);
	      		}
			break;
		case 3: // sheet1 init
		    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|trf_pfx_cd|trf_no|GRI Group Seq.|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_no",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:370,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetShowButtonImage(2);
			      SetSheetHeight(140);
				}
			break;
		case 4: // sheet1 init
		    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|trf_pfx_cd|trf_no|GRI Group Seq.|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|Trans Mode";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
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
				var param="&cd=" + Value;
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
				var param="&cd=" + Value;
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
 	
 	function SheetObject(sheet, row, col, rtnVal){
 		this.sheet = sheet;
 		this.row = row;
 		this.col = col;
 		this.rtnVal = rtnVal;
 	}
 	var _tmp_sheetObject;
 	
	/**
	 * calling function when occurring OnPopupClick Event <br>
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
		if (colName == "rout_pnt_loc_def_cd") {
			if (sheetObj.GetCellEditable(Row, "rout_pnt_loc_def_cd")) {
				var sUrl="ESM_PRI_4026.do?" + FormQueryString(document.form);
				sUrl += "&func=callback4026";
				sUrl += "&group_cmd=" + PRI_SP_SCP + "&location_cmd=LC&loc_tp_cd=" + sheetObj.GetCellValue(Row, "rout_pnt_loc_tp_cd");
				
				//2014.12.10
				//3th popup 
				//ComOpenPopup을 사용하면 일반 popup창이 두개가 뜨면서 window name 이 겹쳐 이전 팝업창이 사라지게됨
	            ComOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 290, false);
			}
		}
	}
		
	/**
	 * calling function when occurring OnPopupClick Event <br>
	 */
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
		if (colName == "rout_via_port_def_cd") {
			if (sheetObj.GetCellEditable(Row, "rout_via_port_def_cd")) {
	            var sUrl="ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&func=callback4026_2";
	            sUrl += "&group_cmd(" + PRI_SP_SCP + "&location_cmd=LC&loc_tp_cd=" + sheetObj.GetCellValue(Row, "rout_via_port_tp_cd");
	            
	            //2014.12.10
				//3th popup 
				//ComOpenPopup을 사용하면 일반 popup창이 두개가 뜨면서 window name 이 겹쳐 이전 팝업창이 사라지게됨
	            ComOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 320, false);
	            
			}
		}
	}
	
	function callback4026(rtnVal) {
		if (rtnVal != null){
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "rout_pnt_loc_def_cd", rtnVal.cd, 0);
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "rout_pnt_loc_def_nm", rtnVal.nm, 0);
			if (rtnVal.cd.length ==  2) {
				_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "rout_pnt_loc_tp_cd","C", 0);
			} else if (rtnVal.cd.length == 5) {
				_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "rout_pnt_loc_tp_cd","L", 0);
			}
		}
	}
	
	function callback4026_2(rtnVal) {
		if (rtnVal != null){
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "rout_via_port_def_cd", rtnVal.cd, 0);
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "rout_via_port_def_nm", rtnVal.nm, 0);
			if (rtnVal.cd.length == 2) {
				_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "rout_via_port_tp_cd","C", 0);
			} else if (rtnVal.cd.length == 5) {
				_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "rout_via_port_tp_cd","L", 0);
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
        	var suppresWait = $(ComGetEvent()).attr('suppressWait');
            if (ComGetEvent() == null || suppresWait != "Y") {
                ComOpenWait(true);
            }
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            for (var a=0; a <= 3; a++) {
	            	if (a == 0 || a == 3) {
	            		sheetObjects[a].ColumnSort("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd", "ASC", "ASC|ASC", true);
	            	} else if (a == 1 || a == 2) {
	            		sheetObjects[a].ColumnSort("rout_via_port_tp_cd|rout_via_port_def_cd", "ASC", "ASC|ASC", true);
	            	}
	            	var sXml=ComPriSheet2Xml(sheetObjects[a]);
					opener.setSheetXml(sXml, a + 3);
	            }

	            break; 
			case IBCLEAR: 
				var sXml="";
				//common - type
				sheetObjects[0].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE1[1], ComboCode: LOCATION_TYPE1[0]} );
				sheetObjects[1].SetColProperty("rout_via_port_tp_cd", {ComboText:LOCATION_TYPE1[1], ComboCode: LOCATION_TYPE1[0]} );
				sheetObjects[2].SetColProperty("rout_via_port_tp_cd", {ComboText:LOCATION_TYPE1[1], ComboCode: LOCATION_TYPE1[0]} );
				sheetObjects[3].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE1[1], ComboCode: LOCATION_TYPE1[0]} );
				//common term
				formObj.f_cmd.value=SEARCH19;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
				setIBCombo(sheetObjects[0], sXml, "rcv_de_term_cd", true, 0);
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
				setIBCombo(sheetObjects[3], sXml, "rcv_de_term_cd", true, 0);
				//common trans mode
				formObj.f_cmd.value=SEARCH19;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				setIBCombo(sheetObjects[0], sXml, "prc_trsp_mod_cd", true, 0);
				setIBCombo(sheetObjects[3], sXml, "prc_trsp_mod_cd", true, 0);
				break;
			case IBSEARCH: // retrieving parent sheet
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            for (var a=0; a <= 3; a++) {
					var sXml=opener.getSheetXml(a + 3);
					sheetObjects[a].LoadSearchData(sXml,{Sync:1} );
	            	if (a == 0 || a == 3) {
	            		sheetObjects[a].ColumnSort("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd", "ASC", "ASC|ASC", true);
	            	} else if (a == 1 || a == 2) {
	            		sheetObjects[a].ColumnSort("rout_via_port_tp_cd|rout_via_port_def_cd", "ASC", "ASC|ASC", true);
	            	}
	            }
	         	break; 	
			case IBINSERT: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
		        var idx=sheetObj.DataInsert();
	            sheetObj.SetCellValue(idx, "trf_pfx_cd",formObj.trf_pfx_cd.value);
	            sheetObj.SetCellValue(idx, "trf_no",formObj.trf_no.value);
	            sheetObj.SetCellValue(idx, "gri_grp_seq",formObj.gri_grp_seq.value);
	            sheetObj.SetCellValue(idx, "org_dest_tp_cd",curOrgDestType);
	            if (curPntViaType == "P") {
	            	sheetObj.SetCellValue(idx, "gri_rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "gri_rout_pnt_seq"))+ 1);
	            } else if (curPntViaType == "V") {
	            	sheetObj.SetCellValue(idx, "gri_rout_via_seq",parseInt(ComPriGetMax(sheetObj, "gri_rout_via_seq"))+ 1);
	            }
	            sheetObj.SelectCell(idx, 9, false);
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
        	if (formObj.trf_pfx_cd.value == "" || formObj.trf_no.value == "") {
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
        		dupRow=sheetObj.ColValueDup("rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd|prc_trsp_mod_cd", false);
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
        	if (formObj.trf_pfx_cd.value == "" || formObj.trf_no.value == "") {
                return false;
            }
            return true;
            break;
        case IBDELETE: // Delete
        	if (formObj.trf_pfx_cd.value == "" || formObj.trf_no.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
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