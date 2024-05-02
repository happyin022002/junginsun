/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_vsk_0010.js
*@FileTitle  : Lane Information Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_vsk_0010 : business script for vop_vsk_0010
     */
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var marrPrefix=new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_");
var marrTabTitle=new Array("Not Select Lane", "Main Lane", "CKY Lane", "Intra Asia Lane", "Other Lane");
var objFocusSheet=null;
var strFocusVal="";
var strFocusPrefix="";
var marrFleetType=new Array("M", "C", "O", "I");

	var opener; // MODAL창에서 부모창 호출
	if (!opener) {
		opener = window.dialogArguments;
	}
	if (!opener) {
		opener = parent;
	}

	// Event handler processing by button click event
	document.onclick = processButtonClick;

	// Event handler processing by button name
	function processButtonClick() {
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		var sheetObject5 = sheetObjects[4]; 
		var sheetObject6 = sheetObjects[5];
		var sheetObject7 = sheetObjects[6];         

		var formObject = document.form;

		try {
			var srcName = ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;  
			switch (srcName) {
			case "btn_Retrieve" :
				doActionIBSheet(document.form, IBSEARCH);
				break;
			case "btn_close" :
				ComClosePopup();
				break;
			case "btn_ok" :
				doActionIBSheet(document.form, IBSAVE);
				break;
			case "btns_add" :
				sheet_closs(sheetObject1, objFocusSheet, sheetObject1.GetSelectRow(), "sheet1_", strFocusPrefix, strFocusVal);
				break;
			case "btns_del" :
				sheet_closs(objFocusSheet, sheetObject1, objFocusSheet.GetSelectRow(), strFocusPrefix, "sheet1_", "");
				break;
			case "vsl_svc_tp_cd":
				//doActionIBSheet2(formObject, IBSEARCH);
				doActionIBSheet(document.form, IBSEARCH);
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * Event when clicking Tab
     * activating selected tab items
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setComboObject(combo_obj){
	   comboObjects[comboCnt++]=combo_obj;
	}

	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (var i=0; i<sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();
		doActionIBSheet(document.form, IBSEARCH);
    }

    /**
    * registering initial event 
    */
    function initControl() {
//		axon_event.addListenerForm  ('blur',			'obj_deactivate',	form);
        axon_event.addListenerFormat('focus',			'obj_focus',		form);
//        axon_event.addListenerFormat('keypress',        'obj_keypress', 	form);
		sheetObjects[0].SetWaitImageVisible(0);
		document.form.f_cmd.value=SEARCH;
		var arr=new Array("", "", "");
 		var sXml=sheetObjects[0].GetSearchData("VOP_VSK_0007GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam(arr));
		var arrXml=sXml.split("|$$|");
/*
		if(arrXml.length > 0){
			marrFleetType=ComOPFXml2Array(arrXml[1], "val");
		}
		sheetObjects[0].SetWaitImageVisible(1);
*/
    }
    function dateFormat(n, digits) {
    	var zero='';
    	n=n.toString();
    	if (n.length < digits) {
    		for (i=0; i < digits - n.length; i++)
    	    zero += '0';
    	}
    	return zero + n;
    }
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        with(sheetObj){
            
          var HeadTitle1="|No|No|Lane Code|Lane Name|vskd_flet_grp_cd|vsl_svc_tp_cd";
          var headCount=ComCountHeadTitle(HeadTitle1);
          (headCount, 0, 0, true);
          var prefix="sheet" + sheetNo + "_";

          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle1, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_slan_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"vskd_flet_grp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_svc_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);
          SetSheetHeight(495);
          if(sheetNo == 1){
          }else if(sheetNo == 2){
          SetSheetHeight(100);
          }else{
          SetSheetHeight(100);
          }
          SetEditable(1);
                }


	}

	function doActionIBSheet(formObj, sAction) {
		switch (sAction) {
		case IBSEARCH : // Retrieve
			
			sheetObjects[0].SetColHidden("sheet1_Seq", 0)
			sheetObjects[0].SetColHidden("sheet1_no", 1)
			
			var arrPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_");
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObjects[0].GetSearchData("VOP_VSK_0702GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 3) {
				for (var cnt=0; cnt<arrXml.length; cnt++) {
					sheetObjects[cnt].SetWaitImageVisible(0);
					sheetObjects[cnt].LoadSearchData(arrXml[cnt], {Sync:1});
				}
			}
			focusSheet(sheetObjects[1], 1);
			break;
		case IBSAVE : // Save.
			formObj.f_cmd.value = MULTI;
			var sParam = ComGetSaveString(sheetObjects);
			if (sParam == "") return;
			sParam += "&" + FormQueryString(formObj);
			var sXml = sheetObjects[0].GetSaveData("VOP_VSK_0702GS.do", sParam);
			if (sXml.indexOf("OK") > -1) {
				sheetObjects[0].LoadSaveData(sXml);
				opener.doActionIBSheet(opener.beforetab, opener.document.form, IBSEARCH);
				ComClosePopup();
			} else {
				sheetObjects[0].LoadSaveData(sXml);
			}
			break;
		}
	}

    function doActionIBSheet2(formObj, sAction) {
		for(var cnt=sheetObjects[0].HeaderRows(); cnt <= sheetObjects[0].LastRow(); cnt++){
			if(formObj.vsl_svc_tp_cd[1].checked && sheetObjects[0].GetCellValue(cnt, "sheet1_vsl_svc_tp_cd") == "O"){
				sheetObjects[0].SetRowHidden(cnt,1);
			}else if(formObj.vsl_svc_tp_cd[2].checked && sheetObjects[0].GetCellValue(cnt, "sheet1_vsl_svc_tp_cd") != "O"){
				sheetObjects[0].SetRowHidden(cnt,1);
			}else{
				sheetObjects[0].SetRowHidden(cnt,0);
			}
		}
		sheetObjects[0].SelectCell(1, 1);
	}
    /**
     * handling process for input validation
     */
    function validateForm(formObj,sAction){
        return true;
    }
	function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y){
		focusSheet(sheetObj, 1);
	}
	function sheet3_OnMouseDown(sheetObj, Button, Shift, X, Y){
		focusSheet(sheetObj, 2);
	}
	function sheet4_OnMouseDown(sheetObj, Button, Shift, X, Y){
		focusSheet(sheetObj, 3);
	}
	function sheet5_OnMouseDown(sheetObj, Button, Shift, X, Y){
		focusSheet(sheetObj, 4);
	}
	function sheet1_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, objFocusSheet, Row, "sheet1_", strFocusPrefix, strFocusVal);
	}
	function sheet2_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, sheetObjects[0], Row, strFocusPrefix, "sheet1_", "");
	}
	function sheet3_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, sheetObjects[0], Row, strFocusPrefix, "sheet1_", "");
	}
	function sheet4_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, sheetObjects[0], Row, strFocusPrefix, "sheet1_", "");
	}
	function sheet5_OnDblClick(sheetObj, Row, Col){
		sheet_closs(sheetObj, sheetObjects[0], Row, strFocusPrefix, "sheet1_", "");
	}
	function focusSheet(sheetObj, idx){
		strFocusVal=marrFleetType[idx - 1];
		strFocusPrefix=marrPrefix[idx];
		objFocusSheet=sheetObj;
		for(var cnt=1; cnt < 5; cnt++){
			if(idx == cnt){
				document.all.item("sheetHelp" + cnt).bgColor="#E9E9E9";
				sheetObjects[cnt].SetHeaderBackColor("#6600CC");
			}else{
				document.all.item("sheetHelp" + cnt).bgColor="#F3F2F8";
				sheetObjects[cnt].SetHeaderBackColor("#27415d");
			}
		}
	}
	function sheet_closs(sheetOrg, sheetCopy, Row, prefixOrg, prefixCopy, vskdFletGrpCd){
		try {
			if(parseInt(sheetOrg.RowCount()) < 1){
				return;
			}
			var vsl_slan_cd=sheetOrg.GetCellValue(Row, prefixOrg + "vsl_slan_cd");
			var vsl_slan_nm=sheetOrg.GetCellValue(Row, prefixOrg + "vsl_slan_nm");
			var vsl_svc_tp_cd=sheetOrg.GetCellValue(Row, prefixOrg + "vsl_svc_tp_cd");
			sheetOrg.RowDelete(Row, false);

			var rc = sheetOrg.RowCount();
			sheetOrg.SetColHidden(prefixOrg +"Seq", 1)
			for(i=1;i<=rc;i++){
				sheetOrg.SetCellValue(i, prefixOrg + "no", i, 0)
			}
			sheetOrg.SetColHidden(prefixOrg +"no", 0)
			
			var insRow=sheetCopy.DataInsert(-1);
			sheetCopy.SetCellValue(insRow, prefixCopy + "vsl_slan_cd",vsl_slan_cd);
			sheetCopy.SetCellValue(insRow, prefixCopy + "vsl_slan_nm",vsl_slan_nm);
			sheetCopy.SetCellValue(insRow, prefixCopy + "vskd_flet_grp_cd",vskdFletGrpCd);
			sheetCopy.SetCellValue(insRow, prefixCopy + "vsl_svc_tp_cd",vsl_svc_tp_cd);
			sheetCopy.SetRowBackColor(insRow,"#C0C0C0");
			if(prefixCopy == "sheet1_" && document.form.vsl_svc_tp_cd[1].checked && vsl_svc_tp_cd == "O"){
				sheetCopy.SetRowHidden(insRow,1);
			}else if(prefixCopy == "sheet1_" && document.form.vsl_svc_tp_cd[2].checked && vsl_svc_tp_cd != "O"){
				sheetCopy.SetRowHidden(insRow,1);
			}else{
				sheetCopy.SetRowHidden(insRow,0);
				
				var rc = sheetCopy.RowCount();
				for(i=1;i<=rc;i++){
					sheetCopy.SetCellValue(i, prefixCopy + "no", i, 0)
				}
				
			}
		}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
	}
