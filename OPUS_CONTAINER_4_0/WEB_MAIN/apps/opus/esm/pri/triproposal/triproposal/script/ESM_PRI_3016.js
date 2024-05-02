/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3016.js
*@FileTitle  : TRI Creation & Amendment - Route Point
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group :business script for Commodity Group 
     */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var beforeIndex=-1;
    var curPntViaType="";
    var curOrgDestType="";
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
	 * @version 2009.05.01
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
				if (bIsReqUsr
			    		&& document.form.amdt_seq.value == "0"
			    		&& document.form.prop_sts_cd.value == "I") {
					doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSAVE);
				} else {
					ComClosePopup(); 
				}
				break;
			case "btn_Close":
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
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj mandatory IBSheet Object
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function setSheetObject(sheet_obj) {
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
	 * @version 2009.05.01
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
//    	if (bIsReqUsr&& document.form.prop_sts_cd.value == "I" && document.form.amdt_seq.value == "0") {
//        	enableButton("btn_add");
//        	enableButton("btn_delete");
//    	} else {
//    		disableButton("btn_add");
//    		disableButton("btn_delete");
//    	}
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
	 * adding case as numbers of counting sheets  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,1);
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} sheetNo mandatory IBSheet Object Serial No
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
	       
	      var HeadTitle="|Sel.|Seq.|tri_prop_no|org_dest_tp_cd|rout_pnt_seq|Location Code|Description|Term|Trans Mode";
	      var headCount=ComCountHeadTitle(HeadTitle);

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_prop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E" },
	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetColProperty(0 ,"rout_pnt_loc_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});

	      SetEditable(1);
	            SetShowButtonImage(2);
	            SetSheetHeight(140);
	      }


			break;
		case 2: // sheet1 init
		    with(sheetObj){
	       
	      var HeadTitle="|Sel.|Seq.|tri_prop_no|org_dest_tp_cd|rout_via_seq|Location Code|Description";
	      var headCount=ComCountHeadTitle(HeadTitle);

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_prop_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E" },
	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);
	      SetColProperty(0 ,"rout_via_port_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});

	      SetEditable(1);
	            SetShowButtonImage(2);
	            SetSheetHeight(140);
	      }


			break;
		case 3: // sheet1 init
		    with(sheetObj){
	        
	      if (location.hostname != "")
	      var HeadTitle="|Sel.|Seq.|tri_prop_no|org_dest_tp_cd|rout_via_seq|Location Code|Description";
	      var headCount=ComCountHeadTitle(HeadTitle);
	      (headCount, 0, 0, true);

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_prop_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E" },
	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);
	      SetColProperty(0 ,"rout_via_port_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});

	      SetEditable(1);
	            SetShowButtonImage(2);
	            SetSheetHeight(140);
	      }
			break;
		case 4: // sheet1 init
		    with(sheetObj){
	       
	      var HeadTitle="|Sel.|Seq.|tri_prop_no|org_dest_tp_cd|rout_pnt_seq|Location Code|Description|Term|Trans Mode";
	      var headCount=ComCountHeadTitle(HeadTitle);

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_prop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1, AcceptKeys:"E" },
	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);
	      SetColProperty(0 ,"rout_pnt_loc_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});

	      SetEditable(1);
	            SetShowButtonImage(2);
	            SetSheetHeight(140);
	      }


			break;
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
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "rout_pnt_loc_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value=SEARCH05;
				var param="&cd=" + Value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.SetCellValue(Row, "rout_pnt_loc_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_pnt_loc_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_cd", false);
		    		return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "rout_pnt_loc_nm","",0);
	    		sheetObj.SetCellValue(Row, "rout_pnt_loc_cd","",0);
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_cd", false);
	    		return false;
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
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "rout_via_port_cd") {
			if (Value.length == 5) {
				formObj.f_cmd.value=SEARCH05;
				var param="&cd=" + Value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.SetCellValue(Row, "rout_via_port_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "rout_via_port_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_via_port_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_via_port_cd", false);
		    		return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "rout_via_port_nm","",0);
	    		sheetObj.SetCellValue(Row, "rout_via_port_cd","",0);
	    		sheetObj.SelectCell(Row, "rout_via_port_cd", false);
	    		return false;
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
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		sheet2_OnChange(sheetObj, Row, Col, Value)
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
	function sheet4_OnChange(sheetObj, Row, Col, Value) {
		sheet1_OnChange(sheetObj, Row, Col, Value)
	}
	/**
	 * Calling function in case of OnPopupClick event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function tmp_object(sheet, row){
		this.row = row;
		this.sheet = sheet;
	}
	var G_TMP_OBJECT;
	
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "rout_pnt_loc_cd") {
			if (sheetObj.GetCellEditable(Row, "rout_pnt_loc_cd")) {
	            var sUrl="ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_SP_SCP + "&location_cmd=L&loc_tp_cd=L";
	            sUrl += "&func=callback4026";
	            G_TMP_OBJECT = new tmp_object(sheetObj, Row);
	            ComOpenPopup(sUrl, 700, 310, "callback4026", "1,0", false);
			}
		}
	}
	
	function callback4026(rtnVal){
		var sheetObj = G_TMP_OBJECT.sheet;
		if (rtnVal != null){
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "rout_pnt_loc_cd",rtnVal.cd,0);
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "rout_pnt_loc_nm",rtnVal.nm,0);
		}
	}
	/**
	 * Calling function in case of OnPopupClick event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "rout_via_port_cd") {
			if (sheetObj.GetCellEditable(Row, "rout_via_port_cd")) {
	            var sUrl="ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_SP_SCP + "&location_cmd=L&loc_tp_cd=L";
	            sUrl += "&func=callback4026_2";
	            G_TMP_OBJECT = new tmp_object(sheetObj, Row);
//	            var rtnVal=ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, false);
	            ComOpenPopup(sUrl, 700, 325, "callback4026_2", "1,0,1,1,1,1,1", false);
			}
		}
	}
	function callback4026_2(rtnVal){
		var sheetObj = G_TMP_OBJECT.sheet;
		if (rtnVal != null){
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "rout_via_port_cd",rtnVal.cd,0);
			sheetObj.SetCellValue(G_TMP_OBJECT.row, "rout_via_port_nm",rtnVal.nm,0);
		}
	}
	
	/**
	 * Calling function in case of OnPopupClick event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet3_OnPopupClick(sheetObj, Row, Col) {
		sheet2_OnPopupClick(sheetObj, Row, Col);
	}
	/**
	 * Calling function in case of OnPopupClick event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet4_OnPopupClick(sheetObj, Row, Col) {
		sheet1_OnPopupClick(sheetObj, Row, Col);
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
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction, obj) {
        try {
           
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            for (var a=0; a <= 3; a++) {
	            	if (a == 0 || a == 3) {
	            		sheetObjects[a].ColumnSort("rout_pnt_loc_cd|rcv_de_term_cd|prc_trsp_mod_cd", "ASC", "ASC|ASC|ASC", true);
	            	} else if (a == 1 || a == 2) {
	            		sheetObjects[a].ColumnSort("rout_via_port_cd", "ASC", "ASC", true);
	            	}
					var sXml=ComPriSheet2Xml(sheetObjects[a]);
					opener.sheetObjects[a+2].LoadSearchData( sXml,{Sync:1} );
	            }
	        	ComClosePopup();
	            break; 
			case IBCLEAR: // Retrieving when loading
				var sXml="";
				// Common term
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
			case IBSEARCH: 
				  if (!validateForm(sheetObj,document.form,sAction)) {
		                return false;
		            }
		            for (var a=0; a <= 3; a++) {
						var sXml=opener.getSheetXml(a + 2);
						sheetObjects[a].LoadSearchData(sXml,{Sync:1} );
		            	if (a == 0 || a == 3) {
		            		sheetObjects[a].ColumnSort("rout_pnt_loc_cd", "ASC", "ASC", true);
		            	} else if (a == 1 || a == 2) {
		            		sheetObjects[a].ColumnSort("rout_via_port_cd", "ASC", "ASC", true);
		            	}
						setSheetStyle(sheetObjects[a], -1);
		            }
		         	break; 	

			case IBINSERT:
				if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
	                 ComOpenWait(true);
	             }
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
		        var idx=sheetObj.DataInsert();
	            sheetObj.SetCellValue(idx, "tri_prop_no",formObj.tri_prop_no.value);
	            sheetObj.SetCellValue(idx, "org_dest_tp_cd",curOrgDestType);
	            if (curPntViaType == "P") {
	            	sheetObj.SetCellValue(idx, "rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1);
	            } else if (curPntViaType == "V") {
	            	sheetObj.SetCellValue(idx, "rout_via_seq",parseInt(ComPriGetMax(sheetObj, "rout_via_seq"))+ 1);
	            }
	            setSheetStyle(sheetObj, idx);
	            sheetObj.SelectCell(idx, 6, false);
				break;
			case IBDELETE: 
				if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
	                 ComOpenWait(true);
	             }
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
	 * @version 2009.05.01
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH: // retrieving
        	return true;
            break;
        case IBSAVE: // Saving
        	if (!validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC15: // when radio button modified, Validation check
            if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
                return false;
            }
        	var dupRow=-1;
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
        		dupRow=sheetObj.ColValueDup("rout_pnt_loc_cd|rcv_de_term_cd|prc_trsp_mod_cd", false);
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
        		dupRow=sheetObj.ColValueDup("rout_via_port_cd", false);
        	}
        	if (dupRow >= 0) {
        		sheetObj.SetSelectRow(dupRow);
				ComShowCodeMessage("PRI00302");
				return false;
        	}
            return true;
            break;
        case IBINSERT: // Row Add
//        	if (formObj.tri_prop_no.value == "") {
//                return false;
//            }
        	if (formObj.prop_sts_cd.value != "I") {
        		return false;
        	}
            return true;
            break;
        case IBDELETE: // Delete
//        	if (formObj.tri_prop_no.value == "") {
//                return false;
//            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prop_sts_cd.value != "I") {
        		return false;
        	}
        	return true;
            break;
        }
    }
	/**
	 * SEtting style after retrieving<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} idx selection ,handling selected row.If not selected, handling all data
	 * @author 
	 * @version 2009.05.01
	 */
    function setSheetStyle(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
if (sheetObj.GetRowStatus(i) == "D") {
            		sheetObj.SetRowHidden(i,1);
            	}
            	setLineEnable(sheetObj, i);
            }
        } else {
        	setLineEnable(sheetObj, idx);
        }
    }
	/**
	 * Enable/Diable to each column or all row's column after retrieving<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} idx selection ,handling selected row.If not selected, handling all data
	 * @author 
	 * @version 2009.05.01
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	console.log("bIsReqUsr : " + bIsReqUsr);
    	console.log("document.form.amdt_seq.value : " + document.form.amdt_seq.value);
    	console.log("document.form.prop_sts_cd.value : " + document.form.prop_sts_cd.value);
    	console.log("document.form.tri_no.value : " + document.form.tri_no.value);
    	
    	if (bIsReqUsr
	    		&& document.form.amdt_seq.value == "0"
	    		&& document.form.prop_sts_cd.value == "I"
	    		&& document.form.tri_no.value == "") {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        	sheetObj.SetCellEditable(idx, "rout_pnt_loc_cd",1);
	        	sheetObj.SetCellEditable(idx, "rcv_de_term_cd",1);
	        	sheetObj.SetCellEditable(idx, "prc_trsp_mod_cd",1);
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.SetCellEditable(idx, "rout_via_port_cd",1);
        	}
        	enableButton("btn_add");
        	enableButton("btn_delete");
		} else {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        	sheetObj.SetCellEditable(idx, "rout_pnt_loc_cd",0);
	        	sheetObj.SetCellEditable(idx, "rcv_de_term_cd",0);
	        	sheetObj.SetCellEditable(idx, "prc_trsp_mod_cd",0);
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.SetCellEditable(idx, "rout_via_port_cd",0);
        	}
        	disableButton("btn_add");
        	disableButton("btn_delete");
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
		    var objs=document.all.item("sheetLayer");
		    //document.form.rt_pnt[curIndex].focus();
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
