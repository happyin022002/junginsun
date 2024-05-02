/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ui_pri_0027.js
 *@FileTitle: S/C Proposal Rate - Route Point
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/25/08
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
//    function ESM_PRI_0027() {
//    	this.processButtonClick		= tprocessButtonClick;
//    	this.setSheetObject 		= setSheetObject;
//    	this.loadPage 				= loadPage;
//    	this.initSheet 				= initSheet;
//    	this.initControl            = initControl;
//    	this.doActionIBSheet 		= doActionIBSheet;
//    	this.setTabObject 			= setTabObject;
//    	this.validateForm 			= validateForm;
//    }
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
	
//다음의 화면들에서 호출됨
//ESM_PRI_0003_08
	
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
					ComPopUpReturnValue("O");
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
        if (document.form.amdt_seq.value == "0") {
        	hiddenButton("btn_amend");
        	hiddenButton("btn_amendcancel");
        } else {
        	showButton("btn_amend");
        	showButton("btn_amendcancel");
        }
    	if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I") {
        	enableButton("btn_add");
        	enableButton("btn_delete");
        	enableButton("btn_amend");
        	enableButton("btn_amendcancel");
    	} else {
    		disableButton("btn_add");
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
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {
		        var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Zip Code|Zip Code|Term|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
	
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
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"loc_grd_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_grd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		               {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
		        SetEditable(1);
		        SetSheetHeight(210);
		        SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
				SetColProperty(0 ,"loc_grd_cnt_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"loc_grd_cd" , {AcceptKeys:"N"});
		        SetShowButtonImage(2);
			}
			break;
		case 2: // sheet1 init
			with (sheetObj) {
		        
		        var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
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
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
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
		        SetEditable(1);
		        SetSheetHeight(210);
		        SetColProperty(0 , "rout_via_port_def_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		        SetShowButtonImage(2);
			}
			break;
		case 3: // sheet1 init
			with (sheetObj) {
	        
		        var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
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
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
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
		        SetEditable(1);
		        SetSheetHeight(210);
		        SetColProperty(0 , "rout_via_port_def_cd", {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		        SetShowButtonImage(2);
		    	
			}
			break;
		case 4: // sheet1 init
			with (sheetObj) {
	       
		        var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|org_dest_tp_cd|rout_pnt_seq|Location Type|Location Code|Description|Zip Code|Zip Code|Term|Trans Mode|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|1st ord|2nd ord";
	
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
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		               {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"loc_grd_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"loc_grd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
		               {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
		        SetEditable(1);
		        SetSheetHeight(210);
		        SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
				SetColProperty(0 ,"loc_grd_cnt_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"loc_grd_cd" , {AcceptKeys:"N"});
				SetShowButtonImage(2);
			}
			break;
		}
	}
	/**
	 * calling function when occurring OnSelectCell Event <br>
	 */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
    }
	/**
	 * calling function when occurring OnSelectCell Event <br>
	 */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
    }
	/**
	 * calling function when occurring OnSelectCell Event <br>
	 */
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
    }
	/**
	 * calling function when occurring OnSelectCell Event <br>
	 */
    function sheet4_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
    }
	/**
	 * calling function when occurring OnChange Event <br>
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "rout_pnt_loc_def_cd") {
			if (Value.length == 5) {
				//formObj.f_cmd.value=SEARCH05;
				//var param="&cd=" + Value;
                //var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				
				formObj.f_cmd.value=COMMAND31;
				var sOriDesGbCd=curOrgDestType;
				var sParam=FormQueryString(formObj)+"&cd=" + Value+"&etc1="+sOriDesGbCd;
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","L",0);
 					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm",arrData[1],0);
				} else {
					ComShowCodeMessage("PRI01137");
					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
		    		sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		return false;
				}
			} else if (Value.length == 4) {
				formObj.f_cmd.value=SEARCH17;
				var param="&cd=" + Value + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","G",0);
 					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm",arrData[1],0);
				} else {
					sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
		    		sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
		    		ComShowCodeMessage("PRI00315");
		    		return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
	    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
	    		sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
	    		sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd", false);
	    		ComShowCodeMessage("PRI00314", "4 or 5");
	    		return false;
			}
		} else if (colName == "rout_pnt_loc_tp_cd") {
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_nm","",0);
    		sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
//    		sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
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

				
//				formObj.f_cmd.value=COMMAND31;
//				var sOriDesGbCd=curOrgDestType;
//				var sParam=FormQueryString(formObj)+"&cd=" + Value+"&etc1="+sOriDesGbCd;
//				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
//				
//				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
//				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
//					sheetObj.SetCellValue(Row, "rout_via_port_tp_cd","L",0);
// 					sheetObj.SetCellValue(Row, "rout_via_port_def_nm",arrData[1],0);
//				} else {
//					ComShowCodeMessage("PRI01137");
//					sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
//		    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
//		    		sheetObj.SetCellValue(Row, "rout_via_port_tp_cd","",0);
//		    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
//		    		return false;
//				}
				
				//2015.08.13 
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
		    		//ComShowCodeMessage("PRI00315");
		    		return false;
				}
	
			} else if (Value.length == 4) {
				formObj.f_cmd.value=SEARCH17;
				var param="&cd=" + Value + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					sheetObj.SetCellValue(Row, "rout_via_port_tp_cd","G",0);
 					sheetObj.SetCellValue(Row, "rout_via_port_def_nm",arrData[1],0);
				} else {
					ComShowCodeMessage("PRI01137");
					sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
		    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
		    		sheetObj.SetCellValue(Row, "rout_via_port_tp_cd","",0);
		    		sheetObj.SelectCell(Row, "rout_via_port_def_cd", false);
		    		return false;
				}
			} else {
				ComShowCodeMessage("PRI01137");
				sheetObj.SetCellValue(Row, "rout_via_port_def_nm","",0);
	    		sheetObj.SetCellValue(Row, "rout_via_port_def_cd","",0);
	    		sheetObj.SetCellValue(Row, "rout_via_port_tp_cd","",0);
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
	var popupRow1 = 0;
	var popupSheetObj1;
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		popupRow1=Row;
		popupSheetObj1=sheetObj;
		if (colName == "rout_pnt_loc_def_cd") {
			if (sheetObj.GetCellEditable(Row, "rout_pnt_loc_def_cd")) {
	            var sUrl="ESM_PRI_4026.do?" + FormQueryString(document.form);
	            sUrl += "&group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&loc_tp_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rout_pnt_loc_tp_cd");
				ComOpenPopup(sUrl, 700, 290, "sheet1_returnVal", "1,0", false);
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
			//팝업으로 return 받는 data가 scope에 해당하지 않을 경우 			 
			if (popupSheetObj1.GetCellValue(popupRow1, "rout_pnt_loc_def_cd") == ""){
				popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_def_nm","",0);
			    popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_def_cd","",0);			 
			    popupSheetObj1.SetCellValue(popupRow1, "rout_pnt_loc_tp_cd","",0);
			}
		}
	}
	/**
	 * calling function when occurring OnPopupClick Event <br>
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
	            sUrl += "&group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&loc_tp_cd=" + sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rout_via_port_tp_cd");
				ComOpenPopup(sUrl, 700, 325, "sheet2_returnVal", "1,0", false);
			}
		}
	}
	
	function sheet2_returnVal(rtnVal) {
		if (rtnVal != null){
			popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_def_cd", rtnVal.cd, 1);
			popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_def_nm",rtnVal.nm, 1);
			if (rtnVal.cd.length == 4) {
				popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_tp_cd","G", 1);
			} else if (rtnVal.cd.length == 5) {
				popupSheetObj2.SetCellValue(popupRow2, "rout_via_port_tp_cd","L", 1);
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
			ComOpenWait(true);
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
    				formObj.f_cmd.value=SEARCH17;
    				var param="&cd=" + oldGrpCd + "&nm=proposal" + "&etc1=" + formObj.prop_no.value + "&etc2=" + formObj.amdt_seq.value + "&etc3=" + formObj.svc_scp_cd.value;
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
	            var sXml=sheetObj.GetSaveData("ESM_PRI_0027GS.do", sParam);
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
	            var sXml=sheetObj.GetSaveData("ESM_PRI_0027GS.do", sParam);
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
		            sheetObjects[a].ColumnSort("n1st_ord_ref|n2nd_ord_ref|cmdt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
					var sXml=ComPriSheet2Xml(sheetObjects[a]);
					opener.setSheetXml(sXml, a + 6);
	            }
	            if (exTransaction) {
					opener.restylingPagePostTr();
				}
	            break; 
			case IBCLEAR: 
				var sXml="";
				//common - type
//				sheetObjects[0].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE2[1] ,LOCATION_TYPE2[0], ComboCode:"",""} );
//				sheetObjects[1].SetColProperty("rout_via_port_tp_cd", {ComboText:LOCATION_TYPE2[1] ,LOCATION_TYPE2[0], ComboCode:"",""} );
//				sheetObjects[2].SetColProperty("rout_via_port_tp_cd", {ComboText:LOCATION_TYPE2[1] ,LOCATION_TYPE2[0], ComboCode:"",""} );
//				sheetObjects[3].SetColProperty("rout_pnt_loc_tp_cd", {ComboText:LOCATION_TYPE2[1] ,LOCATION_TYPE2[0], ComboCode:"",""} );
				sheetObjects[0].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);		
				sheetObjects[1].InitDataCombo(0,"rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[2].InitDataCombo(0,"rout_via_port_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				sheetObjects[3].InitDataCombo(0,"rout_pnt_loc_tp_cd", LOCATION_TYPE2[1], LOCATION_TYPE2[0], " ", " ", 0);
				//common term
				formObj.f_cmd.value=SEARCH19;
 				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02138");
				setIBCombo(sheetObjects[0], sXml, "rcv_de_term_cd", true, 0);
 				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02139");
				setIBCombo(sheetObjects[3], sXml, "rcv_de_term_cd", true, 0);
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
	            	
	            	var sXml = opener.getSheetXml(a + 6);
					sheetObjects[a].LoadSearchData(sXml,{Sync:1} );
					sheetObjects[a].ColumnSort("n1st_ord_ref|n2nd_ord_ref|cmdt_seq|amdt_seq", "ASC", "ASC|ASC|ASC|ASC", true);
					setSheetStyle(sheetObjects[a], -1);
	            }
	         	break; 	
			case IBINSERT:  
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	        	if (opener.isRouteGroupDeleted()) {
	        		opener.reloadSw=true;
	        	}

	        	var rowCnt = sheetObj.RowCount();
				var idx=sheetObj.DataInsert(rowCnt+1);
	            sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	            sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	            sheetObj.SetCellValue(idx, "gen_spcl_rt_tp_cd",formObj.gen_spcl_rt_tp_cd.value);
	            sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
	            sheetObj.SetCellValue(idx, "org_dest_tp_cd",curOrgDestType);
	            sheetObj.SetCellValue(idx, "rout_seq",formObj.rout_seq.value);
	            if (curPntViaType == "P") {
	            	sheetObj.SetCellValue(idx, "rout_pnt_seq",parseInt(ComPriGetMax(sheetObj, "rout_pnt_seq"))+ 1);
	            	sheetObj.SetCellValue(idx, "rcv_de_term_cd","Y");
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
	            sheetObj.SelectCell(idx, 12, false);
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
	 * checking validation process of inputed form data <br>
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
        	if (opener.isCMDTGroupDeleted()) {
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
        	if (sheetObj.GetCellValue(curRow, "prc_prog_sts_cd") != "I") {
        		ComShowCodeMessage("PRI01037");
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
        		arrCheckedRows=sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
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
        		arrCheckedRows=sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
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
        case IBSEARCH: // retrieve
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        case IBSAVE: // save
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
        case IBSEARCH_ASYNC15: // radio button Validation 
            if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
                return false;
            }
        	var dupRow=-1;
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
        		dupRow=ComPriAmendDupCheck(sheetObj, "rout_pnt_loc_tp_cd|rout_pnt_loc_def_cd|loc_grd_cnt_cd|loc_grd_cd|rcv_de_term_cd|prc_trsp_mod_cd", formObj.amdt_seq.value);
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
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows=new Array();
        	if (sCheckedRows== "") {
        		arrCheckedRows.push(sheetObj.GetSelectRow());
        	} else { 
        		arrCheckedRows=sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
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
				if (formObj.amdt_seq.value == sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") && sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "I") {
	        		ComShowCodeMessage("PRI01037");
	        		return false;
	        	}
        	}
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
            	setLineEnable(sheetObj, i);
            }
        } else {
        	opener.setLineStyle(sheetObj, idx);
        	setLineEnable(sheetObj, idx);
        }
    }
	/**
	 * setting editable or not all rows, column by row after retrieving on sheet <br>
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    			&& document.form.prc_prop_sts_cd.value == "I"
    			&& sheetObj.GetCellValue(idx, "prc_prog_sts_cd") == "I"
    			&& sheetObj.GetCellValue(idx, "src_info_cd") != "AD") {
        	if (sheetObj.id == "sheet1" || sheetObj.id == "sheet4") {
	        	sheetObj.SetCellEditable(idx, "rout_pnt_loc_tp_cd",1);
	        	sheetObj.SetCellEditable(idx, "rout_pnt_loc_def_cd",1);
	        	sheetObj.SetCellEditable(idx, "loc_grd_cnt_cd",1);
	        	sheetObj.SetCellEditable(idx, "loc_grd_cd",1);
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
	        	sheetObj.SetCellEditable(idx, "loc_grd_cnt_cd",0);
	        	sheetObj.SetCellEditable(idx, "loc_grd_cd",0);
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
