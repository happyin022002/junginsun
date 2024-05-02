/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2027.js
*@FileTitle  : RFA Proposal Inquiry - Rate (Route Point)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
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
	// global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
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
			with (sheetObj) {
//		        if (location.hostname != "")
		        var HeadTitle="|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
		        var headCount=ComCountHeadTitle(HeadTitle);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		        var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		               {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
	
		        SetEditable(0);
		        SetSheetHeight(140);
		        SetShowButtonImage(0);
			}
			break;
		case 2: // sheet1 init
			with (sheetObj) {
	        
//		        if (location.hostname != "")
		        var HeadTitle="|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source Code|Source|Status Code|Status|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
		        var headCount=ComCountHeadTitle(HeadTitle);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		        var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		               {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
		        SetEditable(0);
		        SetSheetHeight(140);
		        SetShowButtonImage(0);
			}
			break;
		case 3: // sheet1 init
			with (sheetObj) {
//	            if (location.hostname != "")
	            var HeadTitle="|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source Code|Source|Status Code|Status|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
	            var headCount=ComCountHeadTitle(HeadTitle);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						       {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
						       {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						       {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             
	            InitColumns(cols);
	
	            SetEditable(0);
	            SetSheetHeight(140);
	            SetShowButtonImage(0);
			}
			break;
		case 4: // sheet1 init
			with (sheetObj) {
//		        if (location.hostname != "")
		        var HeadTitle="|Seq.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Term|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
		        var headCount=ComCountHeadTitle(HeadTitle);
	
		        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
		        var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		        var headers = [ { Text:HeadTitle, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		               {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		               {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
		        SetEditable(0);
		        SetSheetHeight(140);
		        SetShowButtonImage(0);
			}
			break;
		}
	}
	/**
	 * Handling sheet process <br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
			switch (sAction) {
			case IBCLEAR: //  retrieving code when loading
				var sXml="";
				//common - type
				sheetObjects[0].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);		
				sheetObjects[1].InitDataCombo(0,"rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[2].InitDataCombo(0,"rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[3].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				//common term
				formObj.f_cmd.value=SEARCH19;
 				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
				setIBCombo(sheetObjects[0], sXml, "rcv_de_term_cd", false, 0, "Y");
 				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
				setIBCombo(sheetObjects[3], sXml, "rcv_de_term_cd", false, 0, "Y");
				//common trans mode
				formObj.f_cmd.value=SEARCH19;
 				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				setIBCombo(sheetObjects[0], sXml, "prc_trsp_mod_cd", true, 0);
				setIBCombo(sheetObjects[3], sXml, "prc_trsp_mod_cd", true, 0);
				break;
			case IBSEARCH: // retrieving from parent sheet
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            for (var a=0; a <= 3; a++) {
					var sXml=opener.getSheetXml(a + 6);
					sheetObjects[a].LoadSearchData(sXml,{Sync:1} );
					//sheetObjects[a].ColumnSort("n1st_ord_ref|n2nd_ord_ref|cmdt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
					//setSheetStyle(sheetObjects[a], -1);
	            }
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
            } else {
                return true;
            }
            break;
        case IBSEARCH_ASYNC15: // radio button Validation
            return true;
            break;
        }
    }
	/**
	 * setting style function, after retrieving<br>
	 */
    function setSheetStyle(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	opener.setLineStyle(sheetObj, i);
            }
        } else {
        	opener.setLineStyle(sheetObj, idx);
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
