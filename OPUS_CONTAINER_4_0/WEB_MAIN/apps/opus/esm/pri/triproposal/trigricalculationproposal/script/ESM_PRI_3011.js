/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3011.js
*@FileTitle  : TRI GRI Calculation - Commodity Select 
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
 * @class Commodity Group :business script for Commodity Group
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return N/A
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
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
			case "btn_delete":
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
				break;
            case "btn_ok":
            	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;
			case "btn_close":
				ComClosePopup(); 
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
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj Mandatory IBSheet Object
	 * @return N/A
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
	 * @return N/A
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
		if (document.form.gri_appl_flg.value == "Y") {
			for (var i=0; i < sheetObjects.length; i++) {
				sheetObjects[i].SetEditable(0);
			}
    		disableButton("btn_add");
    		disableButton("btn_delete");
    		disableButton("btn_ok");
		}
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
		      var HeadTitle="|Sel.|Seq.|trf_pfx_cd|trf_no|GRI Group Seq.|cmdt_seq|Commodity Code|Description";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"trf_no",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetShowButtonImage(2);
		      SetSheetHeight(120);
	      	}
			break;
		}
	}
	/**
	 * Calling function in case of Onchange Event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
	 * @param {int} code Mandatory
	 * @param {int} text Mandatory
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "cmdt_cd") {
			if (Value.length == 6) {
				formObj.f_cmd.value=SEARCH08;
				var param="&cd=" + Value;
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.SetCellValue(Row, "cmdt_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "cmdt_nm","",0);
		    		sheetObj.SetCellValue(Row, "cmdt_cd","",0);
		    		sheetObj.SelectCell(Row, "cmdt_cd", false);
		    		return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "cmdt_nm","",0);
	    		sheetObj.SetCellValue(Row, "cmdt_cd","",0);
	    		sheetObj.SelectCell(Row, "cmdt_cd", false);
	    		return false;
			}
		}
	}
	
	function SheetObject(sheet, row, col, rtnVal){
 		this.sheet = sheet;
 		this.row = row;
 		this.col = col;
 		this.rtnVal = rtnVal;
 	}
 	var _tmp_sheetObject;
	
	/**
	 * Calling function in case of OnPopupClick event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "cmdt_cd") {
			if (sheetObj.GetCellEditable(Row, "cmdt_cd")) {
				var sUrl="/opuscntr/ESM_PRI_4027.do?" + FormQueryString(document.form);
				sUrl += "&grp_cd=" + PRI_SP_SCP + "&commodity_cmd=CR&prc_cmdt_tp_cd=C&multi_yn=Y&func=callback4027";
				
				//2014.12.10
				//3th popup 
				//ComOpenPopup을 사용하면 일반 popup창이 두개가 뜨면서 window name 이 겹쳐 이전 팝업창이 사라지게됨
	            ComOpenWindowCenter(sUrl, "ESM_PRI_4027", 700, 320, false);
				_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
			}
		}
	}
	function callback4027(rtnVal){
		var sheetObj = _tmp_sheetObject.sheet;
		var Row = _tmp_sheetObject.row;
		
		if (rtnVal != null && rtnVal.length > 0) {
			for (var i=0; i < rtnVal.length; i++) {
				if (i == 0) {
					sheetObj.SetCellValue(Row, "cmdt_cd",rtnVal[i].cd,0);
					sheetObj.SetCellValue(Row, "cmdt_nm",rtnVal[i].nm,0);
				} else {
					var idx=sheetObj.DataInsert();
					sheetObj.SetCellValue(idx, "trf_pfx_cd",formObj.trf_pfx_cd.value);
					sheetObj.SetCellValue(idx, "trf_no",formObj.trf_no.value);
					sheetObj.SetCellValue(idx, "gri_grp_seq",formObj.gri_grp_seq.value);
					sheetObj.SetCellValue(idx, "cmdt_seq",parseInt(ComPriGetMax(sheetObj, "cmdt_seq")) + 1);
					sheetObj.SetCellValue(idx, "cmdt_cd",rtnVal[i].cd,0);
					sheetObj.SetCellValue(idx, "cmdt_nm",rtnVal[i].nm,0);
				}
			}
		}
	}
	/**
	 * Handling Sheet's process <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * 
	 * @param {ibsheet}
	 *            sheetObj Mandatory IBSheet Object
	 * @param {form}
	 *            formObj Mandatory html form object
	 * @param {int}
	 *            sAction Mandatory ,process constant variable
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
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
	        	sheetObj.ColumnSort("cmdt_cd", "ASC", "ASC", true);
				var sXml=ComPriSheet2Xml(sheetObj);
				opener.setSheetXml(sXml, 2);
	            ComPopUpReturnValue("O");
	            break; 
			case IBSEARCH: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
				var sXml= opener.getSheetXml(2);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.ColumnSort("cmdt_cd", "ASC", "ASC", true);
	         	break; 	
			case IBINSERT: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
		        var idx=sheetObj.DataInsert();
	            sheetObj.SetCellValue(idx, "trf_pfx_cd",formObj.trf_pfx_cd.value);
	            sheetObj.SetCellValue(idx, "trf_no",formObj.trf_no.value);
	            sheetObj.SetCellValue(idx, "gri_grp_seq",formObj.gri_grp_seq.value);
	            sheetObj.SetCellValue(idx, "cmdt_seq",parseInt(ComPriGetMax(sheetObj, "cmdt_seq"))+ 1);
	            sheetObj.SelectCell(idx, "cmdt_cd", false);
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
	 * handling process for input validation <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,process constant variable
	 * @returns bool <br>
	 *          true  : Valid<br>
	 *          false : Invalid
	 * @author 
	 * @version 2009.05.01
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH: 
        	if (formObj.trf_pfx_cd.value == "" || formObj.trf_no.value == "") {
                return false;
            }
            return true;
            break;
        case IBSAVE: 
        	if (formObj.trf_pfx_cd.value == "" || formObj.trf_no.value == "") {
                return false;
            }
            if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
                return false;
            }
        	var dupRow=sheetObj.ColValueDup("cmdt_cd", false);
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