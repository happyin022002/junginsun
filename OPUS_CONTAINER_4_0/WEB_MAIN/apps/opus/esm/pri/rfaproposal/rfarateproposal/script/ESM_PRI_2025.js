/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_2025.js
*@FileTitle : RFA Proposal Creation - Rate (Route Point)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group :business script for Commodity Group 
     */
	// Common Global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
    var beforeIndex=-1;
    var curPntViaType="";
    var curOrgDestType="";
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
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBINSERT);
				break;
			case "btn_copy":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBCOPYROW);
				break;
			case "btn_delete":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], formObject, IBDELETE);
				break;
			case "btn_amend":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSEARCH_ASYNC11);
				break;
			case "btn_amendcancel":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSEARCH_ASYNC12);
				break;
			case "btn_accept":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSEARCH_ASYNC13);
				break;
			case "btn_acceptcancel":
				doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSEARCH_ASYNC14);
				break;
			case "btn_ok":
				if (formObject.prc_prop_sts_cd.value == "I" || formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSAVE);
				} else {
					ComClosePopup(); 
				}
				break;
			case "btn_close":
				if (formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[parseInt(getRtPnt())], document.form, IBSAVE);
				} else {
					ComClosePopup(); 
				}
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
        if (document.form.amdt_seq.value == "0") {
        	hiddenButton("btn_amend");
        	hiddenButton("btn_amendcancel");
        } else {
        	showButton("btn_amend");
        	showButton("btn_amendcancel");
        }
    	if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I") {
        	enableButton("btn_add");
        	enableButton("btn_copy");
        	enableButton("btn_delete");
        	enableButton("btn_amend");
        	enableButton("btn_amendcancel");
    	} else {
    		disableButton("btn_add");
    		disableButton("btn_copy");
    		disableButton("btn_delete");
    		disableButton("btn_amend");
    		disableButton("btn_amendcancel");
    	}
    	if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q") {
        	enableButton("btn_accept");
        	enableButton("btn_acceptcancel");
    	} else {
            disableButton("btn_accept");
            disableButton("btn_acceptcancel");
    	}
    	if ((!bIsReqUsr && !bIsAproUsr) || opener.isCMDTGroupDeleted()) {
    		for (i=0; i < sheetObjects.length; i++) {
    			sheetObjects[i].SetEditable(0);
    		}
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
		case 1: // sheet1
		    with(sheetObj){
				var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"N|E", InputCaseSensitive:1 },
	             {Type:"Text",      Hidden:0, Width:240,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetSheetHeight(140);
				SetEditable(1);
	            SetShowButtonImage(2);
	            
	      	}
			break;
		case 2: // sheet2
		    with(sheetObj){
				var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 , AcceptKeys:"N|E", InputCaseSensitive:1},
	             {Type:"Text",      Hidden:0,  Width:370,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetSheetHeight(140);
				SetEditable(1);
	            SetShowButtonImage(2);
	            
	      	}
			break;
		case 3: // sheet3
		    with(sheetObj){
				var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"N|E", InputCaseSensitive:1 },
	             {Type:"Text",      Hidden:0,  Width:370,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetSheetHeight(140);
				SetEditable(1);
	            SetShowButtonImage(2);
	            
	      	}
			break;
		case 4: // sheet4
		    with(sheetObj){
				var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"N|E", InputCaseSensitive:1 },
	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:10,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:10,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:10,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:10,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetSheetHeight(140);
				SetEditable(1);
	            SetShowButtonImage(2);
	            
	      	}
			break;
		}
	}
	/**
	 * Calling function in case of OnSelectCell event <br>
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
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    }
	/**
	 * Calling function in case of OnSelectCell event <br>
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
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    }
	/**
	 * Calling function in case of OnSelectCell event <br>
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
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    }
	/**
	 * Calling function in case of OnSelectCell event <br>
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
    function sheet4_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
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
		    		//ComShowCodeMessage("PRI00315");
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
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
	    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
	    		//ComShowCodeMessage("PRI00314", "4 or 5");
	    		return false;
			}
		} else if (colName == "rout_pnt_loc_tp_cd") {
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
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
		    		//ComShowCodeMessage("PRI00315");
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
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
	    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
	    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
	    		//ComShowCodeMessage("PRI00314", "4 or 5");
	    		return false;
			}
		} else if (colName == "rout_via_port_tp_cd") {
			sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
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
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		sheet2_OnChange(sheetObj, Row, Col, Value)
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
	function sheet4_OnChange(sheetObj, Row, Col, Value) {
		sheet1_OnChange(sheetObj, Row, Col, Value)
	}
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
	var popupRow1 = 0;
	var popupSheetObj1;
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		popupRow1=Row;
		popupSheetObj1=sheetObj;
		var formObj=document.form;
		if (colName == "rout_pnt_loc_def_cd") {
			if (sheetObj.GetCellEditable(Row, "rout_pnt_loc_def_cd")) {
	            var sUrl="ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=" + sheetObj.GetCellValue(Row, "rout_pnt_loc_tp_cd") + "&org_dest_cd=" + formObj.org_dest_tp_cd.value;
	            ComOpenPopup(sUrl, 700, 290, "sheet1_returnVal", "1,0,1,1,1,1,1", false);
			}
		}
	}
	
	function sheet1_returnVal(rtnVal) {
		if (rtnVal != null){
			popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_def_cd",rtnVal.cd,1);
			popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_def_nm",rtnVal.nm,1);
			if (rtnVal.cd.length == 4) {
				popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_tp_cd","G",1);
			} else if (rtnVal.cd.length == 5) {
				popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_tp_cd","L",1);
			}
		}
	}
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
	var popupRow2 = 0;
	var popupSheetObj2;
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		popupRow2=Row;
		popupSheetObj2=sheetObj;
		if (colName == "rout_via_port_def_cd") {
			if (sheetObj.GetCellEditable(Row, "rout_via_port_def_cd")) {
	            var sUrl="ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_RP_SCP + "&location_cmd=LG&loc_tp_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rout_via_port_tp_cd");
//				var rtnVal=ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
	            ComOpenPopup(sUrl, 700, 325, "sheet2_returnVal", "1,0,1,1,1,1,1", false);
			}
		}
	}
	
	function sheet2_returnVal(rtnVal) {
		if (rtnVal != null){
			popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_def_cd",rtnVal.cd,1);
			popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_def_nm",rtnVal.nm,1);
			if (rtnVal.cd.length == 4) {
				popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_tp_cd","G",1);
			} else if (rtnVal.cd.length == 5) {
				popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_tp_cd","L",1);
			}
		}
	}
	
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
	function sheet3_OnPopupClick(sheetObj, Row, Col) {
		sheet2_OnPopupClick(sheetObj, Row, Col);
	}
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
	function sheet4_OnPopupClick(sheetObj, Row, Col) {
		sheet1_OnPopupClick(sheetObj, Row, Col);
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
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
//            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
//                ComOpenWait(true);
//            }
        	var objEvt = ComGetEvent();
        	if (window.event == null || window.event.srcElement == null || $(objEvt).attr('suppressWait')!= "Y") {
        		ComOpenWait(true);
        	}
	        sheetObj.ShowDebugMsg(false);
			switch (sAction) {
	        case IBSEARCH_ASYNC11: // Amend
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            var checkedCnt=sheetObj.CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObj.SetSelectRow(curRow);
	        		sheetObj.SetCellValue(curRow, "chk","0",0);
	        	}
	        	if (opener.isRouteGroupDeleted()) {
	        		opener.reloadSw=true;
	        	}
	        	var idx=opener.doRowAmend(sheetObj, "AM");
	        	setSheetStyle(sheetObj, idx - 1);
	        	setSheetStyle(sheetObj, idx);
	            break;
	        case IBSEARCH_ASYNC12: // Amend Cancel
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            var checkedCnt=sheetObj.CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObj.SetSelectRow(curRow);
	        		sheetObj.SetCellValue(curRow, "chk","0",0);
	        	}
	    		var oldRow=sheetObj.GetSelectRow()- 1;
	    		var tpColNm="";
	    		var defColNm="";
	        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        		tpColNm="rout_pnt_loc_tp_cd";
	        		defColNm="rout_pnt_loc_def_cd";
	        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        		tpColNm="rout_via_port_tp_cd";
	        		defColNm="rout_via_port_def_cd";
	        	}
	        	if (sheetObj.GetCellValue(oldRow, tpColNm) == "G") {
	        		var oldGrpCd=sheetObj.GetCellValue(oldRow, defColNm);
					formObj.f_cmd.value=SEARCH11;
					var param="&cd=" + oldGrpCd + "&nm=rpscp" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value + "&etc4=";
					var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
					var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
					if (arrData == null || arrData.length <= 0 || arrData[1] == "") {
						ComShowCodeMessage("PRI01127", "LOC Group");
						return false;
					}
	    		}
	        	if (opener.isRouteGroupDeleted()) {
	        		opener.reloadSw=true;
	        	}
	        	var idx=opener.doRowAmendCancel(sheetObj);
	        	setSheetStyle(sheetObj, idx);
	            break;
	        case IBSEARCH_ASYNC13: // Accept
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00008")) {
	            	return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	        		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_cd","A");
	        		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_nm","Accepted");
	        	}
	            formObj.f_cmd.value=MODIFY01;
	            var sParam=FormQueryString(formObj);
	    		var sSheetParam=sheetObj.GetSaveString(false, false, "chk");
	            if (sSheetParam == "") {
	                return false;
	            }
	            sParam += "&" + ComPriSetPrifix(sSheetParam, sheetObj.id + "_");
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2025GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, false, "chk");
	            sheetObj.CheckAll("chk",0,1);
	            setSheetStyle(sheetObj, -1);
	            exTransaction=true;
	            opener.updateSummary();
	            ComShowCodeMessage("PRI00108");
	            break;
	        case IBSEARCH_ASYNC14: // Accept Cancel
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00009")) {
	            	return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	        		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_cd","I");
	        		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_nm","Initial");
	        	}
	            formObj.f_cmd.value=MODIFY02;
	            var sParam=FormQueryString(formObj);
	    		var sSheetParam=sheetObj.GetSaveString(false, false, "chk");
	            if (sSheetParam == "") {
	                return false;
	            }
	            sParam += "&" + ComPriSetPrifix(sSheetParam, sheetObj.id + "_");
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2025GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, false, "chk");
	            sheetObj.CheckAll("chk",0,1);
	            setSheetStyle(sheetObj, -1);
	            exTransaction=true;
	            opener.updateSummary();
	            ComShowCodeMessage("PRI00109");
	            break;
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            for (var a=0; a <= 3; a++) {
	            	var tpColNm;
	            	var defColNm;
	            	if (a == 0 || a == 3) {
	            		tpColNm="rout_pnt_loc_tp_cd";
	            		defColNm="rout_pnt_loc_def_cd";
	            	} else if (a == 1 || a == 2) {
	            		tpColNm="rout_via_port_tp_cd";
	            		defColNm="rout_via_port_def_cd";
	            	}
		            for (var i=sheetObjects[a].HeaderRows(); sheetObjects[a].RowCount()> 0 && i <= sheetObjects[a].LastRow(); i++) {
		            	if (sheetObjects[a].GetCellValue(i, "n1st_ord_ref") == "" || sheetObjects[a].GetCellValue(i, "n2nd_ord_ref") == "") {
		            		var n1stOrdRef;
		            		if (sheetObjects[a].GetCellValue(i, tpColNm) == "G") {
		            			n1stOrdRef=1;
		            		} else if (sheetObjects[a].GetCellValue(i, tpColNm) == "L") {
		            			n1stOrdRef=2;
		            		} else {
		            			n1stOrdRef=99;
		            		}
		            		sheetObjects[a].SetCellValue(i, "n1st_ord_ref",n1stOrdRef,0);
		            		sheetObjects[a].SetCellValue(i, "n2nd_ord_ref",sheetObjects[a].GetCellValue(i, defColNm),0);
		            	}
		            }
		            if(a == 0 || a == 3) {
		            	sheetObjects[a].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_pnt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
		            } else if (a == 1 || a == 2) {
		            	sheetObjects[a].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_via_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
		            }
					var sXml=ComPriSheet2Xml(sheetObjects[a]);
					opener.setSheetXml(sXml, a + 6);
	            }
	            ComPopUpReturnValue("O");
				if (exTransaction) {
					opener.restylingPagePostTr();
				}
	            break; 
			case IBCLEAR: 
				var sXml="";
				//Common - type
				sheetObjects[0].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE2[1], ComboCode:LOCATION_TYPE2[0]} );
				sheetObjects[1].SetColProperty("rout_via_port_tp_cd", {ComboText:LOCATION_TYPE2[1], ComboCode:LOCATION_TYPE2[0]} );
				sheetObjects[2].SetColProperty("rout_via_port_tp_cd", {ComboText:LOCATION_TYPE2[1], ComboCode:LOCATION_TYPE2[0]} );
				sheetObjects[3].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE2[1], ComboCode:LOCATION_TYPE2[0]} );
				//Common term
				formObj.f_cmd.value=SEARCH19;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
				setIBCombo(sheetObjects[0], sXml, "rcv_de_term_cd", false, 0, "Y");
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
				setIBCombo(sheetObjects[3], sXml, "rcv_de_term_cd", false, 0, "Y");
				//Common trans mode
				formObj.f_cmd.value=SEARCH19;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				setIBCombo(sheetObjects[0], sXml, "prc_trsp_mod_cd", true, 0);
				setIBCombo(sheetObjects[3], sXml, "prc_trsp_mod_cd", true, 0);
				break;
			case IBSEARCH: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            /*
	            for (var a=0; a <= 3; a++) {
					var sXml=opener.getSheetXml(a + 6);
					sheetObjects[a].LoadSearchData(sXml,{Sync:1} );
					sheetObjects[a].ColumnSort("n1st_ord_ref|n2nd_ord_ref|cmdt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
					setSheetStyle(sheetObjects[a], -1);
	            }
	            */
	            //Term in ORIGIN, DESTINATION is mandatory.So include in sorting
	            var sXml6=opener.getSheetXml(6);
	            sheetObjects[0].LoadSearchData(sXml6,{Sync:1} );
	            sheetObjects[0].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_pnt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[0], -1);
	            var sXml7=opener.getSheetXml(7);
	            sheetObjects[1].LoadSearchData(sXml7,{Sync:1} );
	            sheetObjects[1].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_via_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[1], -1);
	            var sXml8=opener.getSheetXml(8);
	            sheetObjects[2].LoadSearchData(sXml8,{Sync:1} );
	            sheetObjects[2].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_via_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[2], -1);
	            var sXml9=opener.getSheetXml(9);
	            sheetObjects[3].LoadSearchData(sXml9,{Sync:1} );
	            sheetObjects[3].ColumnSort("n1st_ord_ref|n2nd_ord_ref|rout_pnt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
	            setSheetStyle(sheetObjects[3], -1);
	         	break; 	
			case IBINSERT: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	        	if (opener.isRouteGroupDeleted()) {
	        		opener.reloadSw=true;
	        	}
		        var idx=sheetObj.DataInsert();
	            sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	            sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	            sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
	            sheetObj.SetCellValue(idx, "org_dest_tp_cd",curOrgDestType);
	            sheetObj.SetCellValue(idx, "rout_seq",formObj.rout_seq.value);
	            if (curPntViaType == "P") {
	            	sheetObj.SetCellValue(idx, "rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1);
	            } else if (curPntViaType == "V") {
	            	sheetObj.SetCellValue(idx, "rout_via_seq",parseInt(ComPriGetMax(sheetObj, "rout_via_seq"))+ 1);
	            }
	            sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
	            sheetObj.SetCellValue(idx, "prc_prog_sts_nm","Initial");
	            sheetObj.SetCellValue(idx, "src_info_cd","NW");
	            sheetObj.SetCellValue(idx, "src_info_nm","New");
	            sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
	            sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
	            setSheetStyle(sheetObj, idx);
	            if (curPntViaType == "P") {
	            	sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd", false);
	            } else if (curPntViaType == "V") {
	            	sheetObj.SelectCell(idx, "rout_via_port_def_cd", false);
	            }
				break;
			case IBCOPYROW: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	        	if (opener.isRouteGroupDeleted()) {
	        		opener.reloadSw=true;
	        	}
		        var idx=sheetObj.DataCopy();
	            if (curPntViaType == "P") {
	            	sheetObj.SetCellValue(idx, "rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1);
	            } else if (curPntViaType == "V") {
	            	sheetObj.SetCellValue(idx, "rout_via_seq",parseInt(ComPriGetMax(sheetObj, "rout_via_seq"))+ 1);
	            }
	            sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
	            sheetObj.SetCellValue(idx, "prc_prog_sts_nm","Initial");
	            sheetObj.SetCellValue(idx, "src_info_cd","NW");
	            sheetObj.SetCellValue(idx, "src_info_nm","New");
	            sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
	            sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
	            setSheetStyle(sheetObj, idx);
	            if (curPntViaType == "P") {
	            	sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd", false);
	            } else if (curPntViaType == "V") {
	            	sheetObj.SelectCell(idx, "rout_via_port_def_cd", false);
	            }
				break;
			case IBDELETE: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
	        	var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=arrCheckedRows.length - 1; i >= 0; i--) {
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            		sheetObj.SetSelectRow(arrCheckedRows[i]);
	               		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","0",0);
	               		var idx=opener.doRowAmend(sheetObj, "AD");
	                	setSheetStyle(sheetObj, idx - 1);
	                	setSheetStyle(sheetObj, idx);
	            	}
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
        case IBSEARCH_ASYNC11: // Amend
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	var checkedCnt=sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow=-1;
        	if (checkedCnt == 1) {
        		 curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow=sheetObj.GetSelectRow();
        	}
        	if (sheetObj.GetCellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01011");
        		return false;
        	}
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	var routCmdtHdr = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cmdt_hdr_seq");
        	if (opener.isCmdtGroupDeleted4Route(false, routCmdtHdr)) {
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC12: // Amend Cancel
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	var routCmdtHdr = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cmdt_hdr_seq");
        	if (opener.isCmdtGroupDeleted4Route(false, routCmdtHdr)) {
        		return false;
        	}
        	var checkedCnt=sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow=-1;
        	if (checkedCnt == 1) {
        		 curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow=sheetObj.GetSelectRow();
        	}
        	if (sheetObj.GetCellValue(curRow, "src_info_cd") != "AM" && sheetObj.GetCellValue(curRow, "src_info_cd") != "AD") {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01012");
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC13: // Accept
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "Q") {
        		return false;
        	}
        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows=new Array();
        	if (sCheckedRows== "") {
        		arrCheckedRows.push(sheetObj.GetSelectRow());
        	} else { 
        		arrCheckedRows=sCheckedRows.split("|");
        	}
        	for (var i=0; i < arrCheckedRows.length; i++) {
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
        		}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
            		ComShowCodeMessage("PRI00313");
            		return false;
            	}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
            return true;
            break;
        case IBSEARCH_ASYNC14: // Accept Cancel
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (!bIsAproUsr || formObj.prc_prop_sts_cd.value != "Q") {
        		return false;
        	}
        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows=new Array();
        	if (sCheckedRows== "") {
        		arrCheckedRows.push(sheetObj.GetSelectRow());
        	} else { 
        		arrCheckedRows=sCheckedRows.split("|");
        	}
        	for (var i=0; i < arrCheckedRows.length; i++) {
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "A") {
					ComShowCodeMessage("PRI01038");
					return false;
        		}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
            return true;
            break;
        case IBSEARCH: 
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        case IBSAVE: 
        	if (!validateForm(sheetObjects[beforeIndex], document.form, IBSEARCH_ASYNC15)) {
        		return false;
        	}
        	/*
            if (getAmendValidRowCount(sheetObjects[0], formObj.amdt_seq.value) <= 0) {
            	ComShowCodeMessage("PRI00316", "Origin");
                return false;
            }
            if (formObj.svc_scp_cd.value == "TPE"
            	&& getAmendValidRowCount(sheetObjects[1], formObj.amdt_seq.value) <= 0) {
            	ComShowCodeMessage("PRI00316", "Origin Via");
                return false;
            }
            if (formObj.svc_scp_cd.value == "TPE"
            	&& getAmendValidRowCount(sheetObjects[2], formObj.amdt_seq.value) <= 0) {
            	ComShowCodeMessage("PRI00316", "Destination Via");
                return false;
            }
            if (getAmendValidRowCount(sheetObjects[3], formObj.amdt_seq.value) <= 0) {
            	ComShowCodeMessage("PRI00316", "Destination");
                return false;
            }
            */
            return true;
            break;
        case IBSEARCH_ASYNC15: // Validation in case of moving radio button
            if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
                return false;
            }
        	var dupRow=-1;
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
        		dupRow=ComPriAmendDupCheck(sheetObj, "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|rcv_de_term_cd|prc_trsp_mod_cd", formObj.amdt_seq.value);
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
        		dupRow=ComPriAmendDupCheck(sheetObj, "rout_via_port_tp_cd|rout_via_port_def_cd", formObj.amdt_seq.value);
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
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	var routCmdtHdr = opener.sheetObjects[1].GetCellValue(opener.sheetObjects[1].GetSelectRow(), "cmdt_hdr_seq");
        	if (opener.isCmdtGroupDeleted4Route(false, routCmdtHdr)) {
        		return false;
        	}
        	if (sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
            return true;
            break;
        case IBCOPYROW: // Row Add
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	var routCmdtHdr = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cmdt_hdr_seq");
        	if (opener.isCmdtGroupDeleted4Route(false, routCmdtHdr)) {
        		return false;
        	}
            if (sheetObj.RowCount()<= 0 || sheetObj.GetSelectRow()<= 0) {
                return false;
            }
            if (sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
            return true;
            break;
        case IBDELETE: // Delete
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows=new Array();
        	if (sCheckedRows== "") {
        		arrCheckedRows.push(sheetObj.GetSelectRow());
        	} else { 
        		arrCheckedRows=sCheckedRows.split("|");
        	}
        	for (var i=0; i < arrCheckedRows.length; i++) {
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
            		ComShowCodeMessage("PRI00313");
            		return false;
            	}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "NW"
        			&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "GC"
        				&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "GM"
        					&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "PC"
        						&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "PM"
        							&& sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	var routCmdtHdr = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cmdt_hdr_seq");
        	if (opener.isCmdtGroupDeleted4Route(false, routCmdtHdr)) {
        		return false;
        	}
        	return true;
            break;
        }
    }
	/**
	 * Setting color,styles after retrieving <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} idx .Handling selected row if selected. if not, handling all rows
	 * @author 
	 * @version 2009.05.01
	 */
    function setSheetStyle(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	opener.setLineStyle(sheetObj, i);
            	setLineEnable(sheetObj, i);
            }
        } else {
        	opener.setLineStyle(sheetObj, idx);
        	setLineEnable(sheetObj, idx);
        }
    }
	/**
	 * make all row or each column by row Enable/Disable after retrieving<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} idx Handling selected row if selected. if not, handling all rows
	 * @author 
	 * @version 2009.05.01
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    		&& document.form.prc_prop_sts_cd.value == "I"
    			&& sheetObj.GetCellValue(idx, "src_info_cd") != "AD") {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        	sheetObj.SetCellEditable(idx, "rout_pnt_loc_tp_cd",1);
	        	sheetObj.SetCellEditable(idx, "rout_pnt_loc_def_cd",1);
	        	sheetObj.SetCellEditable(idx, "rcv_de_term_cd",1);
	        	sheetObj.SetCellEditable(idx, "prc_trsp_mod_cd",1);
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.SetCellEditable(idx, "rout_via_port_tp_cd",1);
	        	sheetObj.SetCellEditable(idx, "rout_via_port_def_cd",1);
        	}
		} else {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        	sheetObj.SetCellEditable(idx, "rout_pnt_loc_tp_cd",0);
	        	sheetObj.SetCellEditable(idx, "rout_pnt_loc_def_cd",0);
	        	sheetObj.SetCellEditable(idx, "rcv_de_term_cd",0);
	        	sheetObj.SetCellEditable(idx, "prc_trsp_mod_cd",0);
        	} else if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3") {
	        	sheetObj.SetCellEditable(idx, "rout_via_port_tp_cd",0);
	        	sheetObj.SetCellEditable(idx, "rout_via_port_def_cd",0);
        	}
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
		    //document.form.rt_pnt[curIndex].select();
		    ComSetFocus(document.form.rt_pnt[curIndex]);
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
