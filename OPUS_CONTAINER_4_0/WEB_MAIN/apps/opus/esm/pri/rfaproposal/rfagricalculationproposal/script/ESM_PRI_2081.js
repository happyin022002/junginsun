/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2081.js
*@FileTitle  : GRI Calculation - Commodity/Actual Customer Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
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
     * @class Commodity Group :business script for Commodity Group 
     */
    function ESM_PRI_2081() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var beforeIndex=-1;
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
            	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;
			case "btn_close":
				ComClosePopup(); 
				break;
			case "cmdtActcustTp":
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
        if (document.form.cmdt_actcust_tp_cd.value == "C") {
        	document.form.cmdtActcustTp[0].checked=true;
        } else if (document.form.cmdt_actcust_tp_cd.value == "A") {
        	document.form.cmdtActcustTp[1].checked=true;
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
		
		    var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|GRI Group Seq.|cmdt_seq|CMDT Type|Commodity Code|Description|";
		    var headCount=ComCountHeadTitle(HeadTitle);
		
		    SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    InitHeaders(headers, info);
		
		    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		     {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
		     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		     {Type:"PopupEdit", Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		     {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		     
		    InitColumns(cols);
		
		    SetEditable(1);
		    SetCountPosition(0);
		    //conversion of function[check again]CLT                 InitDataValid(0, "prc_cmdt_def_cd", vtEngUpOther, "0123456789");
		    SetColProperty(0 ,"prc_cmdt_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		    SetShowButtonImage(2);
		    SetSheetHeight(140);
		    }
		    break;
        case 2: // sheet1 init
        	
			    with(sheetObj){
			
			var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|GRI Group Seq.|act_cust_seq|Customer Code|Customer Code|Actual Customer Name";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			 
			InitColumns(cols);
			
			SetEditable(1);
			SetCountPosition(0);
			//conversion of function[check again]CLT 				InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);   // Uppercase characters Only
			//conversion of function[check again]CLT 				InitDataValid(0, "cust_seq", vtNumericOnly);    // Numeric characters Only
			SetColProperty(0 ,"cust_cnt_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
			SetColProperty(0 ,"cust_seq" , {AcceptKeys:"N"});
			SetShowButtonImage(2);
			SetSheetHeight(140);
			}
			break;

		}
	}
	/**
	 * Calling Function in case of OnBeforeCheck event <br>
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
	function sheet1_OnBeforeCheck(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
        	if (sheetObj.GetCellValue(Row, colName) == "0") {
//        		sheetObj.CheckAll(colName,0);
        		sheetObj.GetCellValue(Row, colName, "1")
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
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "prc_cmdt_def_cd") {
			if (Value.length == 6) {
				formObj.f_cmd.value=SEARCH08;
				var param="&cd=" + Value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "prc_cmdt_tp_cd","C",0);
 					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
		    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 5) {
				formObj.f_cmd.value=SEARCH10;
				var param="&cd=" + Value + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "prc_cmdt_tp_cd","G",0);
 					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
		    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value=COMMAND29;
				var param="&cd=" + Value;
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm",arrData[1],0);
 					sheetObj.SetCellValue(Row, "prc_cmdt_tp_cd","R",0);
				} else {
					sheetObj.SetCellValue(Row, "prc_cmdt_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
		    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "prc_cmdt_def_nm","",0);
	    		sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
	    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
	    		return false;
			}
		} else if (colName == "prc_cmdt_tp_cd") {
			sheetObj.SetCellValue(Row, "prc_cmdt_def_nm","",0);
    		sheetObj.SetCellValue(Row, "prc_cmdt_def_cd","",0);
    		sheetObj.SelectCell(Row, "prc_cmdt_def_cd", false);
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
		if (colName == "cust_cnt_cd" || colName == "cust_seq") {
			if (sheetObj.GetCellValue(Row, "cust_cnt_cd") == ""
				|| sheetObj.GetCellValue(Row, "cust_seq") == "") {
				return false;
			}
			formObj.f_cmd.value=COMMAND07;
			var param="&etc1=" + sheetObj.GetCellValue(Row, "cust_cnt_cd") + "&etc2=" + sheetObj.GetCellValue(Row, "cust_seq")+"&etc3=Y";
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				if (sheetObj.GetCellValue(Row, "cust_seq").length > 0 && sheetObj.GetCellValue(Row, "cust_seq").length < 6){
					sheetObj.SetCellValue(Row, "cust_seq",ComLpad(sheetObj.GetCellValue(Row, "cust_seq"), 6, "0"),0);
	 	    	}
				sheetObj.SetCellValue(Row, "cust_lgl_eng_nm",arrData[1],0);
			} else {
				sheetObj.SetCellValue(Row, "cust_lgl_eng_nm","",0);
	    		sheetObj.SetCellValue(Row, "cust_cnt_cd","",0);
	    		sheetObj.SetCellValue(Row, "cust_seq","",0);
	    		sheetObj.SelectCell(Row, "cust_seq", false);
	    		return false;
			}
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
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "prc_cmdt_def_cd") {
			if (sheetObj.GetCellEditable(Row, "prc_cmdt_def_cd")) {
				var sUrl="/opuscntr/ESM_PRI_4027.do?" + FormQueryString(document.form);
				sUrl += "&grp_cd=" + PRI_RP_SCP + "&commodity_cmd=CRG&prc_cmdt_tp_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_cmdt_tp_cd") + "&multi_yn=Y";
				sUrl +="&func=findCommodity";
				
				//2014.12.10
				//3th popup 
				//ComOpenPopup을 사용하면 일반 popup창이 두개가 뜨면서 window name 이 겹쳐 이전 팝업창이 사라지게됨
	            ComOpenWindowCenter(sUrl, "ESM_PRI_4027", 700, 295, false);
			}
		}
	}
	function findCommodity(rtnVal) {
		for (var i=0; i < rtnVal.length; i++) {
			if (i == 0) {
				sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "prc_cmdt_def_cd",rtnVal[i].cd,0);
				sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "prc_cmdt_def_nm",rtnVal[i].nm,0);
				if (rtnVal[i].cd.length == 5) {
					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "prc_cmdt_tp_cd","G",0);
				} else if (rtnVal[i].cd.length == 4) {
					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "prc_cmdt_tp_cd","R",0);
				} else if (rtnVal[i].cd.length == 6) {
					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "prc_cmdt_tp_cd","C",0);
				}
			} else {
				var idx=sheetObjects[0].DataInsert();
	            sheetObjects[0].SetCellValue(idx, "prop_no",formObj.prop_no.value);
	            sheetObjects[0].SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	            sheetObjects[0].SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
				sheetObjects[0].SetCellValue(idx, "gri_grp_seq",formObj.gri_grp_seq.value);
				sheetObjects[0].SetCellValue(idx, "cmdt_seq",parseInt(ComPriGetMax(sheetObjects[0], "cmdt_seq")) + 1);
				sheetObjects[0].SetCellValue(idx, "prc_cmdt_def_cd",rtnVal[i].cd,0);
				sheetObjects[0].SetCellValue(idx, "prc_cmdt_def_nm",rtnVal[i].nm,0);
				if (rtnVal[i].cd.length == 5) {
					sheetObjects[0].SetCellValue(idx, "prc_cmdt_tp_cd","G",0);
				} else if (rtnVal[i].cd.length == 4) {
					sheetObjects[0].SetCellValue(idx, "prc_cmdt_tp_cd","R",0);
				} else if (rtnVal[i].cd.length == 6) {
					sheetObjects[0].SetCellValue(idx, "prc_cmdt_tp_cd","C",0);
				}
			}
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
		if (colName == "cust_seq") {
			if (sheetObj.GetCellEditable(Row, "cust_seq")) {
	            var sUrl="/opuscntr/ESM_PRI_4014_POP.do?" + FormQueryString(document.form);
	            sUrl += "&is_popup=true&nmd_cust_flg=Y&cust_cnt_cd="+sheetObj.GetCellValue(Row, "cust_cnt_cd")+"&cust_seq="+sheetObj.GetCellValue(Row, "cust_seq");
	            sUrl +="&func=findCustomer";
				
				//2014.12.10
				//3th popup 
				//ComOpenPopup을 사용하면 일반 popup창이 두개가 뜨면서 window name 이 겹쳐 이전 팝업창이 사라지게됨
	            ComOpenWindowCenter(sUrl, "ESM_PRI_4027", 640, 465, false);
			}
		}
	}
	function findCustomer(rtnVal) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cust_cnt_cd",rtnVal.custCntCd,0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cust_seq",ComLpad(rtnVal.custSeq, 6, "0"),0);
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "cust_lgl_eng_nm",rtnVal.custNm,0);
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
	            for (var i = sheetObjects[0].HeaderRows(); sheetObjects[0].RowCount() > 0 && i <= sheetObjects[0].LastRow(); i++) {
	        		var n1stOrdRef;
	        		if (sheetObjects[0].GetCellValue(i, "prc_cmdt_tp_cd") == "G") {
	        			n1stOrdRef=1;
	        		} else if (sheetObjects[0].GetCellValue(i, "prc_cmdt_tp_cd") == "R") {
	        			n1stOrdRef=2;
	        		} else if (sheetObjects[0].GetCellValue(i, "prc_cmdt_tp_cd") == "C") {
	        			n1stOrdRef=3;
	        		} else {
	        			n1stOrdRef=99;
	        		}
	        		var prevStatus=sheetObjects[0].GetRowStatus(i);
	        		sheetObjects[0].SetCellValue(i, "n1st_ord_ref",n1stOrdRef,0);
	        		sheetObjects[0].SetRowStatus(i,prevStatus);
	            }
	        	sheetObjects[0].ColumnSort("n1st_ord_ref|prc_cmdt_def_cd", "ASC", "ASC|ASC", true);
				var sXml=ComPriSheet2Xml(sheetObjects[0]);
				opener.setSheetXml(sXml, 2);
				sXml=ComPriSheet2Xml(sheetObjects[1]);
				opener.setSheetXml(sXml, 3);
				ComPopUpReturnValue("O");
	            break; 
			case IBSEARCH: // retrieving
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
				var sXml=window.parent.getSheetXml(2);
				sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
	            for (var i = sheetObjects[0].HeaderRows(); sheetObjects[0].RowCount() > 0 && i <= sheetObjects[0].LastRow(); i++) {
	        		var n1stOrdRef;
	        		if (sheetObjects[0].GetCellValue(i, "prc_cmdt_tp_cd") == "G") {
	        			n1stOrdRef=1;
	        		} else if (sheetObjects[0].GetCellValue(i, "prc_cmdt_tp_cd") == "R") {
	        			n1stOrdRef=2;
	        		} else if (sheetObjects[0].GetCellValue(i, "prc_cmdt_tp_cd") == "C") {
	        			n1stOrdRef=3;
	        		} else {
	        			n1stOrdRef=99;
	        		}
	        		var prevStatus=sheetObjects[0].GetRowStatus(i);
	        		sheetObjects[0].SetCellValue(i, "n1st_ord_ref",n1stOrdRef,0);
	        		sheetObjects[0].SetRowStatus(i,prevStatus);
	            }
				sheetObjects[0].ColumnSort("n1st_ord_ref|prc_cmdt_def_cd", "ASC", "ASC|ASC", true);
				sXml=window.parent.getSheetXml(3);
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
	         	break;
			case IBCLEAR: // Retrieving when loading
				sheetObj.SetColProperty("prc_cmdt_tp_cd", {ComboText:COMODITY_TYPE3[1] , ComboCode:COMODITY_TYPE3[0]} );
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
				if (sheetObj.id == "sheet1") {
		            sheetObj.SetCellValue(idx, "cmdt_seq",parseInt(ComPriGetMax(sheetObj, "cmdt_seq"))+ 1);
		            sheetObj.SelectCell(idx, "prc_cmdt_def_cd", false);
				} else if (sheetObj.id == "sheet2") {
		            sheetObj.SetCellValue(idx, "act_cust_seq",parseInt(ComPriGetMax(sheetObj, "act_cust_seq"))+ 1);
		            sheetObj.SelectCell(idx, "cust_cnt_cd", false);
				}
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
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
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
        	if (sheetObj.id == "sheet1") {
        		dupRow=sheetObj.ColValueDup("prc_cmdt_def_cd", false);
        	} else if (sheetObj.id == "sheet2") {
        		dupRow=sheetObj.ColValueDup("cust_cnt_cd|cust_seq", false);
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
				document.form.cmdtActcustTp[beforeIndex].checked=true;
				return false;
			}
		    var objs=document.all.item("sheetLayer");
		    document.form.cmdtActcustTp[curIndex].focus();
		    objs[curIndex].style.display="inline";
		    if (beforeIndex >= 0) {
				objs[beforeIndex].style.display="none";
		    }
		    beforeIndex=curIndex;
		}
	}
    function getRtPnt() {
        for (var i=0; i < document.form.cmdtActcustTp.length; i++) {
            if (document.form.cmdtActcustTp[i].checked) {
                return document.form.cmdtActcustTp[i].value;
            }
        }
    }
