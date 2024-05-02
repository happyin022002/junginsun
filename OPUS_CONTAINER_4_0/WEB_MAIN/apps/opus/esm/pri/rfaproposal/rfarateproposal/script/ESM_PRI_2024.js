/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_PRI_2024.js
*@FileTitle : RFA Proposal Creation - Rate (Route Note)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
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
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
    var eventToken=false;
    var sChgCdVisiable="";
    var dataChanged = false;
    var doRowAmend_idx = "-1";
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
		var sheetObject2=sheetObjects[1];
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
			case "btn_amend":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC11);
				break;
			case "btn_amendcancel":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC12);
				break;
			case "btn_accept":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC13);
				break;
			case "btn_acceptcancel":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC14);
				break;
			case "btn_ok":
				if (formObject.prc_prop_sts_cd.value == "I" || formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
				} else {
					ComClosePopup(); 
				}
				
				break;
			case "btn_close":
				if (formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
				} else {
					ComClosePopup(); 
				}
				break;
			case "btn_rowadd3":
				if(validateFormConversion(sheetObject2,formObject,COMMAND10)) {
					doActionIBSheet(sheetObject2,formObject,COMMAND10);
				}
				break;
			case "btn_copy":
				if(validateFormConversion(sheetObject2,formObject,COMMAND11)) {
					doActionIBSheet(sheetObject2,formObject,COMMAND11);
				}
				break;
			case "btn_paste":
				if(validateFormConversion(sheetObject2,formObject,COMMAND12)) {
					doActionIBSheet(sheetObject2,formObject,COMMAND12);
				}
				break;
			case "btn_rowadd3":
				if(validateFormConversion(sheetObject2,formObject,IBINSERT)) {
					doActionIBSheet(sheetObject2,formObject,IBINSERT);
				}
				break;
			case "btn_rowcopy":
				if(validateFormConversion(sheetObject2,formObject,IBCOPYROW)) {
					doActionIBSheet(sheetObject2,formObject,IBCOPYROW);
				}
				break;
			case "btn_delete3":
				if(validateFormConversion(sheetObject2,formObject,COMMAND13)) {
					doActionIBSheet(sheetObject2,formObject,COMMAND13);
				}
				break;
				//2015.06.19
			case "btn_autoword":
				var sheetObj = sheetObjects[1];
				if(sheetObj.RowCount() > 0) {
					var sPreNote = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_ctnt");
					var sAutoNote = makeAutoNote(sheetObjects[1], chargeRuleCdComboText, chargeRuleCdComboValue, sPreNote);
					var sNoteCtntLen = ComGetLenByByte(sAutoNote);
					if(sNoteCtntLen != undefined && sNoteCtntLen > 4000){
						ComShowCodeMessage("PRI00307", "Content(4000)");
		 				return false;
					}
					document.form.ta_note_ctnt.value = sAutoNote;
					sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "note_ctnt",document.form.ta_note_ctnt.value);
			        sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "note_ctnt_tooltip",document.form.ta_note_ctnt.value);
					
					
				}
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
		axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
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
        	enableButton("btn_copy");
        	enableButton("btn_paste");
        	enableButton("btn_rowadd3");
        	enableButton("btn_rowcopy");
        	enableButton("btn_delete3");
        	enableButton("btn_autoword");
        	sheetObjects[1].SetEditable(1);
    	} else {
    		disableButton("btn_add");
    		disableButton("btn_delete");
    		disableButton("btn_amend");
    		disableButton("btn_amendcancel");
    		disableButton("btn_copy");
    		disableButton("btn_paste");
    		disableButton("btn_rowadd3");
    		disableButton("btn_rowcopy");
    		disableButton("btn_delete3");
    		disableButton("btn_autoword");
    		sheetObjects[1].SetEditable(0);
    	}
    	if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q") {
        	enableButton("btn_accept");
        	enableButton("btn_acceptcancel");
    	} else {
            disableButton("btn_accept");
            disableButton("btn_acceptcancel");
    	}
    	if ((!bIsReqUsr && !bIsAproUsr) || opener.isCMDTGroupDeleted()) {
    		for (i=1; i < sheetObjects.length; i++) {
    			sheetObjects[i].SetEditable(0);
    		}
    	}
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        eventToken=true;
	}
	/**
	 * Handling Onbeforedeactivate event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_deactivate()
	 * </pre>
	 * @param  void
	 * @return void
	 * @author 
	 * @version 2009.04.17
	 */
	function obj_deactivate(){
		if (ComChkObjValid(ComGetEvent())) {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			    case "ta_note_ctnt":
			        sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "note_ctnt",document.form.ta_note_ctnt.value);
			        sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "note_ctnt_tooltip",document.form.ta_note_ctnt.value);
			        break;
			}
			return true;
		} else {
			return false;
		}
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
				var HeadTitle="|Sel.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|rout_seq|rout_note_seq|Content|Conversion|Conversion|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|prev_note_conv_mapg_id";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:470,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,  EditLen:4000},
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prev_note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetCountPosition();
				SetSheetHeight(82);
				SetEditable(1);
	            SetShowButtonImage(2);
	            SetAutoRowHeight(0);
	            SetColHidden("chk",1);
	      	}
			break;
        case 2:      //t1sheet1 init
            with(sheetObj){
        		var HeadTitle="|Sel.|Code|Application|Application\nEffective|Application\nExpires|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
        		"|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +
        		"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23";
        		var headCount=ComCountHeadTitle(HeadTitle);
        		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight:250, ComboMaxHeight:346 } );
 
        		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        		var headers = [ { Text:HeadTitle, Align:"Center"} ];
        		InitHeaders(headers, info);

        		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                 {Type:"Combo", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                 {Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
                 {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnl_tz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
                 {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"PopupEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                 {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
                 {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_vsl_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_voy_no" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_dir_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_cnt_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_cnt_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_cnt_cd" },
                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_cnt_cd" } ];
           
        		InitColumns(cols);
        		resizeSheet(); //SetSheetHeight(170);
        		SetEditable(1);
        		SetShowButtonImage(2);//ShowspopupimagewhenGetEditable()
        		SetImageList(0,"img/btns_calendar.gif");
                SetColProperty("bkg_soc_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
                SetColProperty("bkg_dir_call_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
                SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
                SetColProperty("bkg_prc_cgo_tp_cd", {ComboText:bkgPrcCgoTpCdComboText, ComboCode:bkgPrcCgoTpCdComboValue} );
                SetColProperty("rt_op_cd", {ComboText:rtOpCdComboText, ComboCode:rtOpCdComboValue} );
                SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
                SetColProperty("bkg_hngr_bar_tp_cd", {ComboText:bkgHngrBarTpCdComboText, ComboCode:bkgHngrBarTpCdComboValue} );
                SetColProperty("bkg_rat_ut_cd", {ComboText:bkgRatUtCdComboText, ComboCode:bkgRatUtCdComboValue} );
                SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
                SetColProperty("chg_rule_def_cd", {ComboText:chargeRuleCdComboText, ComboCode:chargeRuleCdComboValue} );
                SetColProperty("bkg_cnl_tz_cd", {ComboText:bkgCnlTzCdComboText, ComboCode:bkgCnlTzCdComboValue} );
                SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
                sChgCdVisiable=chargeRuleCdComboText;    //Default loading value
                
                SetColProperty(0 ,"chg_rule_def_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
                SetColProperty(0 ,"bkg_imdg_clss_cd" , {AcceptKeys:"N|[.]"});
                SetColProperty(0 ,"bkg_cmdt_def_cd" , {AcceptKeys:"E|[1234567890]"});
                SetColProperty(0 ,"bkg_por_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
                SetColProperty(0 ,"bkg_pol_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
                SetColProperty(0 ,"bkg_pod_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
                SetColProperty(0 ,"bkg_del_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
                SetColProperty(0 ,"bkg_ts_port_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
                SetColProperty(0 ,"bkg_slan_cd" , {AcceptKeys:"E", InputCaseSensitive:1});
                SetColProperty(0 ,"bkg_vvd_cd" , {AcceptKeys:"E|[1234567890]"});
                SetColProperty(0 ,"bkg_yd_cd" , {AcceptKeys:"E|[1234567890]"});
          	}
	     	break;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[1]);
	}
	
	function ComPriSheetFilter(sheetObj, sCol, sValue, bSelectLast) {
        if (sheetObj == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
            return;
        }
        var arrCol=sCol.split("|");
        var arrValue=sValue.split("|");
        var firstRow=-1;
        var sHiddenRow="";
        var sShowRow="";
        
        //SetRowHidden이 잠시 정상처리되지 않아서 임시로 모든 행을 보이도록 처리함-ib_khlee
        for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
        	sShowRow += i +"|";
        }
        sheetObj.SetRowHidden(sShowRow,0);
        
        for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
        	if (sheetObj.GetRowStatus(i) == "D")  sheetObj.SetRowHidden(i, 1);
            var doHide=0;
            for (var j=0; j < arrCol.length; j++) {
            	if (sheetObj.GetCellValue(i, arrCol[j]) != arrValue[j]) {
            		sHiddenRow += i +"|";
                    doHide=1;
                    break;
                }
            }
            if (doHide==0 && (bSelectLast || firstRow == -1)) {
                firstRow=i;
            }
            //sheetObj.SetRowHidden(i,doHide);
        }
        
        if (sHiddenRow!="") sheetObj.SetRowHidden(sHiddenRow,1);


        if (firstRow > 0 && sheetObj.GetSelectRow()!=firstRow) {
            sheetObj.SetSelectRow(firstRow);
        }
    }

	
	/**
	 * calling function in case of OnSelectCell event <br>
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
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;
		if (OldRow != NewRow) {
			var noteCtnt=sheetObj.GetSelectRow()<= 0 || sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D" || sheetObj.GetRowHidden(sheetObj.GetSelectRow()) ? "" : sheetObj.GetCellValue(NewRow, "note_ctnt");
			var noteConvMapgId=sheetObj.GetSelectRow()<= 0 || sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D" || sheetObj.GetRowHidden(sheetObj.GetSelectRow()) ? "XXX" : sheetObj.GetCellValue(NewRow, "note_conv_mapg_id");
			ComPriSheetFilter(sheetObjects[1], "note_conv_mapg_id", noteConvMapgId);
			formObj.ta_note_ctnt.value=noteCtnt;
			if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I"
				&& sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") == formObj.amdt_seq.value
				&& sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
				&& sheetObj.GetCellValue(sheetObj.GetSelectRow(), "src_info_cd") != "AD"
				&& sheetObj.GetRowHidden(sheetObj.GetSelectRow()) != true) {
				document.form.ta_note_ctnt.readOnly=false;
				sheetObjects[1].SetEditable(1);
				for (var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
					if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "src_info_cd") == "AM") {
		 				sheetObjects[1].SetCellEditable(i, "chg_rule_def_cd",0);
		 			} else {
		 				sheetObjects[1].SetCellEditable(i, "chg_rule_def_cd",1);
		 			}
					disableColumnValidation(sheetObjects[1], i, 2, sheetObjects[1].GetCellValue(i,"chg_rule_def_cd"));
			 		//Setting color in case of state code at route.
			 		setStateColor(sheetObjects[1], i);
			 		//Setting color in case of Rule Code
			 		//setChargeRuleColor(sheetObjects[1], i);
		 		}
			} else {
				document.form.ta_note_ctnt.readOnly=true;
				sheetObjects[1].SetEditable(0);
			}
			buttonControlConv();
		} else {
			//2014.09.11
			buttonControlConv();
		}
		//sheetObjects[1].RenderSheet(1);
		if(dataChanged){
			for (var i=sheetObjects[1].LastRow(); sheetObjects[1].RowCount()> 0 && i >= sheetObjects[1].HeaderRows(); i--) {
        		if (sheetObjects[1].GetRowStatus(i) == "D") {
        			continue;
        		}
        		if (sheetObjects[1].GetCellValue(i, "note_conv_mapg_id") == sheetObj.GetCellValue(doRowAmend_idx, "note_conv_mapg_id")) {
        			if (sheetObjects[1].GetCellValue(i, "eff_dt") < formObj.eff_dt.value) {
        				sheetObjects[1].SetCellValue(i, "eff_dt",formObj.eff_dt.value,0);        		
        			}
        			if (sheetObjects[1].GetCellValue(i, "exp_dt") > formObj.exp_dt.value) {
        				sheetObjects[1].SetCellValue(i, "exp_dt",formObj.exp_dt.value,0);        				
        			}
        		}
        	}
			var noteCtnt=sheetObj.GetSelectRow()<= 0 || sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D" || sheetObj.GetRowHidden(sheetObj.GetSelectRow()) ? "" : sheetObj.GetCellValue(NewRow, "note_ctnt");
			var noteConvMapgId=sheetObj.GetSelectRow()<= 0 || sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D" || sheetObj.GetRowHidden(sheetObj.GetSelectRow()) ? "XXX" : sheetObj.GetCellValue(NewRow, "note_conv_mapg_id");
			ComPriSheetFilter(sheetObjects[1], "note_conv_mapg_id", noteConvMapgId);
		}
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
            /*if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }*/
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
	        	var idx=opener.doRowAmend(sheetObj, "AM");
	        	sheetObj.SetCellValue(idx - 1, "note_conv_mapg_id",sheetObj.GetCellValue(idx - 1, "prev_note_conv_mapg_id"),0);
	        	sheetObj.SetRowStatus(idx - 1,"R");
	        	for (var i=sheetObjects[1].LastRow(); sheetObjects[1].RowCount()> 0 && i >= sheetObjects[1].HeaderRows(); i--) {
	        		if (sheetObjects[1].GetRowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[1].GetCellValue(i, "note_conv_rule_cd") == "APP") {
	        			continue;
	        		}
	        		if (sheetObjects[1].GetCellValue(i, "note_conv_mapg_id") == sheetObj.GetCellValue(idx, "note_conv_mapg_id")) {
	        			if (sheetObjects[1].GetCellValue(i, "exp_dt") < formObj.eff_dt.value) {
	        				sheetObjects[1].SetRowHidden(i,1);
	        				sheetObjects[1].SetRowStatus(i,"D");
	        			}
	        			if (sheetObjects[1].GetCellValue(i, "eff_dt") > formObj.exp_dt.value) {
	        				sheetObjects[1].SetRowHidden(i,1);
	        				sheetObjects[1].SetRowStatus(i,"D");
	        			}
	        		}
	        	}
	        	for (var i=sheetObjects[1].LastRow(); sheetObjects[1].RowCount()> 0 && i >= sheetObjects[1].HeaderRows(); i--) {
	        		if (sheetObjects[1].GetRowStatus(i) == "D") {
	        			continue;
	        		}
	        		doRowAmend_idx = idx;
	        		if (sheetObjects[1].GetCellValue(i, "note_conv_mapg_id") == sheetObj.GetCellValue(doRowAmend_idx, "note_conv_mapg_id")) {
	        			if (sheetObjects[1].GetCellValue(i, "eff_dt") < formObj.eff_dt.value) {
	        				sheetObjects[1].SetCellValue(i, "eff_dt",formObj.eff_dt.value,0);
	        				dataChanged = true;
	        			}
	        			if (sheetObjects[1].GetCellValue(i, "exp_dt") > formObj.exp_dt.value) {
	        				sheetObjects[1].SetCellValue(i, "exp_dt",formObj.exp_dt.value,0);
	        				dataChanged = true;
	        			}
	        		}
	        	}
	        	setSheetStyle(sheetObj, idx - 1);
	        	setSheetStyle(sheetObj, idx);
	        	sheet1_OnSelectCell(sheetObj, idx - 1, sheetObj.GetSelectCol(), idx, sheetObj.GetSelectCol());
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
	        	var newNoteConvMapgId=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "note_conv_mapg_id");
	        	var prevNoteConvMapgId=sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, "note_conv_mapg_id");
	        	var idx=opener.doRowAmendCancel(sheetObj);
	        	sheetObj.SetCellValue(idx, "note_conv_mapg_id",newNoteConvMapgId,0);
	        	for (var i=sheetObjects[1].LastRow(); sheetObjects[1].RowCount()> 0 && i >= sheetObjects[1].HeaderRows(); i--) {
	        		if (sheetObjects[1].GetRowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[1].GetCellValue(i, "note_conv_mapg_id") == newNoteConvMapgId) {
	    				sheetObjects[1].SetRowHidden(i,1);
	    				sheetObjects[1].SetRowStatus(i,"D");
	        		}
	        	}
	        	for (var i=sheetObjects[1].LastRow(); sheetObjects[1].RowCount()> 0 && i >= sheetObjects[1].HeaderRows(); i--) {
	        		if (sheetObjects[1].GetRowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[1].GetCellValue(i, "note_conv_mapg_id") == prevNoteConvMapgId) {
	        			sheetObjects[1].SelectCell(i, 0);
	        			var copiedIdx=sheetObjects[1].DataCopy();
	        			sheetObjects[1].SetCellValue(copiedIdx, "note_conv_mapg_id",newNoteConvMapgId,0);
	        			sheetObjects[1].SetCellValue(copiedIdx, "amdt_seq",formObj.amdt_seq.value,0);
	        			/*
	        			// 2009-12-02
						if (sheetObjects[1].GetCellValue(copiedIdx, "exp_dt") == formObj.pre_exp_dt.value) {
	        				sheetObjects[1].SetCellValue(copiedIdx, "exp_dt",formObj.exp_dt.value,0);
	        			}
	        			*/
	        			// 2010-08-04
	        			// NOTE has to include main duration information of previous sequence.
	        			if (sheetObjects[1].GetCellValue(copiedIdx, "exp_dt") == formObj.before_exp_dt.value) {
	        				sheetObjects[1].SetCellValue(copiedIdx, "exp_dt",formObj.exp_dt.value,0);
	        			}
	        		}
	        		dataChanged = false;
	        	}
	        	setSheetStyle(sheetObj, idx);
	        	sheetObj.SetSelectRow(idx);
	        	sheet1_OnSelectCell(sheetObj, idx - 1, sheetObj.GetSelectCol(), idx, sheetObj.GetSelectCol());
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
	            sParam += "&" + sSheetParam;
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2024GS.do", sParam);
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
	            sParam += "&" + sSheetParam;
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2024GS.do", sParam);
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
	            sheetObj.ColumnSort("rout_note_seq|amdt_seq", "ASC", "ASC|ASC", true);
	        	var sXml="";
				sXml=ComPriSheet2Xml(sheetObj);
				opener.setSheetXml(sXml, 11);
				sXml=ComPriSheet2Xml(sheetObjects[1]);
				opener.setSheetXml(sXml, 15);
//	            window.returnValue="O";
	            //2014.09.16 modify
	            //ComClosePopup(); 
	            ComPopUpReturnValue("O"); 
				if (exTransaction) {
					//2014.09.16 modify
					//opener.restylingPagePostTr();
					opener.restylingPagePostTr();
				}
				 
				//2015.06.19
				opener.doSaveRouteNote();
				
	            break; 
			case IBSEARCH: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            var sXml="";
			    //sheetObjects[1].RenderSheet(0);
	            // NOTE CONVERSION RULE
				var sCd=sheetObjects[1].GetComboInfo(0,"chg_rule_def_cd","Code");
				var sNm=sheetObjects[1].GetComboInfo(0,"chg_rule_def_cd","Text");
				sXml=opener.getSheetXml(15);
				var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd");			
				if (arrData != null && arrData.length > 0) {
					for(var i=0; i<arrData.length; i++){						
						if (sCd.indexOf(arrData[i][0]) < 0) {
							sCd += "|" + arrData[i][0];
							sNm += "|" + arrData[i][0];
						}
					}					
					sheetObjects[1].SetColProperty(2, {ComboText:sNm , ComboCode:sCd} );
				}			
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				for (var i=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()> 0 && i <= sheetObjects[1].LastRow(); i++) {
					if (sheetObjects[1].GetRowStatus(i) == "D") {
			    		sheetObjects[1].SetRowHidden(i,1);
			    	}
				}
				sXml=opener.getSheetXml(11);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.ColumnSort("rout_note_seq|amdt_seq", "ASC", "ASC|ASC", true);
				setSheetStyle(sheetObj, -1);
				sheetObjects[0].SetSelectRow(sheetObjects[0].LastRow());
				sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol());
	         	break;
			case IBINSERT:
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            formObj.f_cmd.value=COMMAND38;
	            var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
	            if (sysGuid == null || sysGuid.length < 16) {
	            	return false;
	            }
		        var idx=sheetObj.DataInsert();
	            sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	            sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	            sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
	            sheetObj.SetCellValue(idx, "rout_seq",formObj.rout_seq.value);
	            sheetObj.SetCellValue(idx, "rout_note_seq",parseInt(ComPriGetMax(sheetObj, "rout_note_seq"))+ 1);
	            sheetObj.SetCellValue(idx, "note_conv_mapg_id",sysGuid);
	            sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
	            sheetObj.SetCellValue(idx, "prc_prog_sts_nm","Initial");
	            sheetObj.SetCellValue(idx, "src_info_cd","NW");
	            sheetObj.SetCellValue(idx, "src_info_nm","New");
	            sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
	            sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
	            setSheetStyle(sheetObj, idx);
	            sheet1_OnSelectCell(sheetObj, idx - 1, sheetObj.GetSelectCol(), idx, sheetObj.GetSelectCol());
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
	            	for (var j=sheetObjects[1].LastRow(); sheetObjects[1].RowCount()> 0 && j >= sheetObjects[1].HeaderRows(); j--) {
	            		if (sheetObjects[1].GetRowStatus(j) == "D") {
	            			continue;
	            		}
	            		if (sheetObjects[1].GetCellValue(j, "note_conv_mapg_id") == sheetObj.GetCellValue(arrCheckedRows[i], "note_conv_mapg_id")) {
	        				sheetObjects[1].SetRowHidden(j,1);
	        				sheetObjects[1].SetRowStatus(j,"D");
	            		}
	            	}
	            	if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            		sheetObj.SetSelectRow(arrCheckedRows[i]);
	               		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","0",0);
	               		idx=opener.doRowAmend(sheetObj, "AD");
	               		sheetObj.SetCellValue(idx - 1, "note_conv_mapg_id",sheetObj.GetCellValue(idx, "prev_note_conv_mapg_id"),0);
	                	sheetObj.SetRowStatus(idx - 1,"R");
	                	setSheetStyle(sheetObj, idx - 1);
	                	setSheetStyle(sheetObj, idx);
	            	} else {
	            		sheetObj.SetRowHidden(arrCheckedRows[i],1);
	            		sheetObj.SetRowStatus(arrCheckedRows[i],"D");
	            	}
	        	}
	        	sheet1_OnSelectCell(sheetObj, -1, sheetObj.GetSelectCol(), idx, sheetObj.GetSelectCol());
				break;
			case COMMAND10: //insert
				
				var rowcnt = formObj.txt_rowcnt.value;
				if(rowcnt == undefined || rowcnt == "") {
					rowcnt = 1;
				} else if (rowcnt == 0) {
					return;
				} else if (rowcnt > 20) {
					return;
				}
				
				for(var i = 0; i < rowcnt; i++) {
					
					var idx=sheetObj.DataInsert();
					sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value,0);
					sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value,0);
					sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
					sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
					sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
					sheetObj.SetCellValue(idx, "note_conv_mapg_id",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"note_conv_mapg_id"),0);
					sheetObj.SetCellValue(idx, "note_conv_tp_cd","R",0);
					sheetObj.SetCellValue(idx, "note_conv_seq",parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1,0);
					sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
					sheetObj.SetEditable(1);
					//in case that Code have default value
					defaultColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
					//Editable Setting
					disableColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
					updateNoteConvChecked();
				
				}
				
				break;
			case COMMAND11: //COPY
				var iCheckRow=sheetObj.FindCheckedRow("chk");
				// Except hidden data when delete process
				var arrRow=iCheckRow.split("|");			
				for (var idx=0; idx<arrRow.length-1; idx++){ 
					if(sheetObj.GetRowHidden(arrRow[idx])) {
						var rowStatus=sheetObj.GetRowStatus(arrRow[idx]);
						sheetObj.SetCellValue(arrRow[idx], "chk","0",0);
						sheetObj.SetRowStatus(arrRow[idx],rowStatus);
					}
				}
				// Copy it?
				if((ComShowCodeConfirm("PRI00012")) ) {
					if(iCheckRow != "") {
						comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
					}
					formObj.f_cmd.value=MULTI12;
					sheetObj.DoSave("ESM_PRI_2024GS.do", FormQueryString(formObj), -1, false);
					//sheetObj.CheckAll2("chk") = "0";
				}				
				break;
			case COMMAND12: //PASTE			
				//Paste it?
				if((ComShowCodeConfirm("PRI00016")) ) {
					// NOTE CONVERSION RULE
					var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			//////////////////////////////////////////////////////////////					
					formObj.f_cmd.value=SEARCH14;
					var sXml=sheetObj.GetSearchData("ESM_PRI_2024GS.do", FormQueryString(formObj));
					var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd"); 
			      	if(arrData != null && arrData.length > 0) {
			      		//After add to ComboBox list, Call InitDataCombo
			      		for(var i=0; i<arrData.length; i++){						
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}					
						sheetObj.SetColProperty(2, {ComboText:sNm, ComboCode:sCd} );
						//////////////////////////////////////						
			      		sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
			      		//Setting default after loading SHEET
			      		var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
			      		var arrRow=ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
			      		if(arrRow != null && arrRow.length > 0) {  
			      			for(var i=0; i<arrRow.length; i++) {
			      				sheetObj.SetRowStatus(arrRow[i], "I");
				      			sheetObj.SetCellValue(arrRow[i], "note_conv_seq",maxSeq + i,0);
				      			sheetObj.SetCellValue(arrRow[i], "note_conv_mapg_id",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"note_conv_mapg_id"),0);
				      			sheetObj.SetCellValue(arrRow[i], "svc_scp_cd",formObj.svc_scp_cd.value,0);
				      			sheetObj.SetCellValue(arrRow[i], "prop_no",formObj.prop_no.value,0);
								sheetObj.SetCellValue(arrRow[i], "amdt_seq",formObj.amdt_seq.value,0);
				      			sheetObj.SetCellValue(arrRow[i], "note_conv_tp_cd","R",0);
				      			//sheetObj.CellValue2(arrRow[i], "exp_dt") 			= formObj.exp_dt.value;						
								//sheetObj.CellValue2(arrRow[i], "eff_dt") 			= formObj.eff_dt.value;								
			      			}
			      		}
			      	} else {
			      		ComShowCodeMessage("PRI00328");
			      	}
				}
				updateNoteConvChecked();
				break;
			case IBCOPYROW:
				copySheetData(sheetObj);
				updateNoteConvChecked();
				break;
			case COMMAND13: // Delete
				var iCheckRow=sheetObj.FindCheckedRow("chk");
				if(iCheckRow == ""){
					sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
				}
				iCheckRow=sheetObj.FindCheckedRow("chk");
				// Except hidden data when delete process
				var arrRow=iCheckRow.split("|");			
				for (var idx=0; idx<arrRow.length-1; idx++){ 
					if(sheetObj.GetRowHidden(arrRow[idx])) {
						var rowStatus=sheetObj.GetRowStatus(arrRow[idx]);
						sheetObj.SetCellValue(arrRow[idx], "chk","0",0);
						sheetObj.SetRowStatus(arrRow[idx],rowStatus);
					}
				}
				if(iCheckRow != "") {
					deleteRowCheck(sheetObj, "chk");
				}
				updateNoteConvChecked();
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
        	if (opener.isRouteGroupDeleted()) {
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
        	if (opener.isRouteGroupDeleted()) {
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
        case IBSEARCH: // retrieving
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        case IBSAVE: // Saving
            if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
                return false;
            }
			/* CONVERSION - START */
	        if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
	            return false;
	        }	
        	var effDt=formObj.eff_dt.value;
	     	var amdtSeq=formObj.amdt_seq.value;
	     	if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "amdt_seq") == amdtSeq
	     			&& sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "n1st_cmnc_amdt_seq") == amdtSeq) {
				if(!checkDuration(sheetObjects[1])) {
	   				return false;
	   			}
			}
	     	//NOTE_CTNT : check length
 			if (sheetObjects[0].IsDataModified()) {
 				for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
 					if(sheetObjects[0].GetRowStatus(i) == "I" || sheetObjects[0].GetRowStatus(i) == "U") {
 						var sNoteCtnt = sheetObjects[0].GetCellValue(i, "note_ctnt");
 						var sNoteCtntLen = ComGetLenByByte(sNoteCtnt);
 						if(sNoteCtntLen != undefined && sNoteCtntLen > 4000){
 							ComShowCodeMessage("PRI00307", "Content(4000)");
 							sheetObjects[0].SelectCell(i, "note_ctnt");
 			 				return false;
 						}
 					}
 				}
 			}
   			for(var i = sheetObjects[1].HeaderRows(); getValidRowCount(sheetObjects[1]) > 0 && i <= sheetObjects[1].LastRow(); i++) {
   				if(!sheetObjects[1].GetRowHidden(i)) {
	   				if(!checkMandatoryValidation(sheetObjects[1], i)) {
	 					return false;
	 				}
   				}
   			}
			if (sheetObjects[1].IsDataModified()) {
				for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
					if(sheetObjects[1].GetCellValue(i, "bkg_vvd_cd") != ""  && sheetObjects[1].GetCellValue(i, "bkg_vvd_cd").length != 9 && sheetObjects[1].GetRowStatus(i) != "D") {
		 				sheetObjects[1].SelectCell(i, "bkg_vvd_cd");
		 				ComShowCodeMessage("PRI01065", "VVD", "9");
		 				return false;
		 			}
					
					var minCgoWgt = sheetObjects[1].GetCellValue(i, "bkg_min_cgo_wgt");
					var maxCgoWgt = sheetObjects[1].GetCellValue(i, "bkg_max_cgo_wgt");
					if(sheetObjects[1].GetRowStatus(i) != "D" && minCgoWgt != "" && minCgoWgt > 999.999) {
						ComShowCodeMessage("PRI00336", 'Weight(Ton<=)', '999.999');
						sheetObjects[1].SelectCell(i, "bkg_min_cgo_wgt");
						return false;
					}
					if(sheetObjects[1].GetRowStatus(i) != "D" && maxCgoWgt != "" && maxCgoWgt > 999.999) {

						ComShowCodeMessage("PRI00336", 'Weight(<Ton)', '999.999');
						sheetObjects[1].SelectCell(i, "bkg_max_cgo_wgt");
						return false;
					}
		 		}
				//Duplicate Check
				if(!validateDupCheck(sheetObjects[1])) {
					 return false;
				}
			}
			/* CONVERSION - END */
            return true;
            break;
        case IBINSERT: // Row Add
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (opener.isRouteGroupDeleted()) {
        		return false;
        	}
        	if (sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (getValidRowCount(sheetObj) > 0) {
        		return false;
        	}
            return true;
            break;
        case IBCOPYROW: // Row Copy
	    	if (opener.isRouteGroupDeleted()) {
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
        	if (opener.isRouteGroupDeleted()) {
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
        	return true;
            break;
        }
    }
    function updateNoteConvChecked() {
    	var noteConvMapgId=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_conv_mapg_id");
    	var prevGetRowStatus=sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow());
    	for (var i=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()> 0 && i <= sheetObjects[1].LastRow(); i++) {
    		if (sheetObjects[1].GetCellValue(i, "note_conv_mapg_id") == noteConvMapgId && sheetObjects[1].GetRowStatus(i) != "D") {
    			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "note_conv_mapg_id_chk","1");
    			sheetObjects[0].SetRowStatus(sheetObjects[0].GetSelectRow(),prevGetRowStatus);
    			return;
    		}
    	}
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "note_conv_mapg_id_chk","0");
		sheetObjects[0].SetRowStatus(sheetObjects[0].GetSelectRow(),prevGetRowStatus);
		return;
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
    	if (sheetObj.RowCount()<= 0) {
    		return;
    	}
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
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    		&& document.form.prc_prop_sts_cd.value == "I"
    			&& sheetObj.GetCellValue(idx, "src_info_cd") != "AD") {
	        	document.form.ta_note_ctnt.readOnly=false;
		} else {
        	document.form.ta_note_ctnt.readOnly=true;
		}
    	if (sheetObj.GetCellValue(idx, "amdt_seq") == document.form.amdt_seq.value) {
    		// true
    	} else {
    		// false
    	}
    }
/**
 * Check the validation rules on value of objects in windows
 */
function validateFormConversion(sheetObj, formObj, sAction) {
	switch (sAction) { 		
   		case IBCOPYROW:
   			if(!checkDuration(sheetObj)) {
   				return false;
   			}
   			if(sheetObj.RowCount()> 0) {
   				//mandatory check
 				if(!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
 					return false;
 				}
   			}
 			break;
   		case COMMAND10:
   			if(sheetObj.RowCount()> 0) {
   				//mandatory check
 				if(!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
 					return false;
 				}
   			}
 			break;	  			
 		case COMMAND11:
 			var iCheckRow=sheetObj.FindCheckedRow("chk");
 			if(iCheckRow == "") {
 				ComShowCodeMessage("PRI00327");
 				return false;
 			}	 							
 			break;
 		case COMMAND12:
 			break;
	}
	return true;
}
/**
 * Checking duplication of SHEET ROW <br>
 * Validating in case of same preiod between eff_dt and exp_dt eventhough other item is same <br>
 * <br><b>Example :</b>
 * <pre>
 * validateDupCheck(sheetObj)
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @return boolean
 * @author 
 * @version 2009.05.20
 */ 
function validateDupCheck(sheetObj) {
	var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
		 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_por_def_cd|bkg_pol_def_cd|bkg_pod_def_cd|bkg_del_def_cd" +
		 		"|bkg_slan_cd|bkg_cnl_tz_cd|bkg_vvd_cd|bkg_soc_flg|bkg_dir_call_flg|bkg_ts_port_def_cd|bkg_min_cgo_wgt|bkg_max_cgo_wgt|bkg_hngr_bar_tp_cd|bkg_esvc_tp_cd|note_conv_mapg_id", false, true);
	if (rowM != "") {
		var rowDup=rowM.replace("|", ","); 			
		//All Duplicated Row
		var rowArr=rowDup.split(",");
		var dupValue="";
		var temValue="";						
		var firstEffDt="";
		var firstExpDt="";						
		var SecondEffDt="";
		var SecondExpDt="";
		var hrows=sheetObj.HeaderRows();
		for(var i=0; i<rowArr.length; i++) {
			if (sheetObj.GetRowHidden(rowArr[i])) {
				continue;
			}
			dupValue=sheetObj.GetCellValue(rowArr[i], "chg_rule_def_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_rat_ut_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_prc_cgo_tp_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_imdg_clss_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_cmdt_def_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pod_def_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_del_def_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_por_def_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_pol_def_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_slan_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_cnl_tz_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_vvd_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_soc_flg");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_dir_call_flg");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_ts_port_def_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_min_cgo_wgt");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_max_cgo_wgt");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_hngr_bar_tp_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_esvc_tp_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "note_conv_mapg_id");
			for(var j=0; j<rowArr.length; j++) {
 				if (sheetObj.GetRowHidden(rowArr[j])) {
 					continue;
 				}
			temValue=sheetObj.GetCellValue(rowArr[j], "chg_rule_def_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_rat_ut_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_prc_cgo_tp_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_imdg_clss_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_cmdt_def_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pod_def_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_del_def_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_por_def_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_pol_def_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_slan_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_cnl_tz_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_vvd_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_soc_flg");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_dir_call_flg");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_ts_port_def_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_min_cgo_wgt");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_max_cgo_wgt");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_hngr_bar_tp_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "bkg_esvc_tp_cd");
			temValue += sheetObj.GetCellValue(rowArr[j], "note_conv_mapg_id");
				if(i != j) {
  					if(dupValue == temValue) {
						firstEffDt=sheetObj.GetCellValue(rowArr[i], "eff_dt");
						firstExpDt=sheetObj.GetCellValue(rowArr[i], "exp_dt");
						SecondEffDt=sheetObj.GetCellValue(rowArr[j], "eff_dt");
						SecondExpDt=sheetObj.GetCellValue(rowArr[j], "exp_dt");
  						if(firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
  							ComShowCodeMessage("PRI00303", "Sheet", Number(rowArr[j])+1-hrows);
  						     return false;
  			 			}
  			 			if(firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
  			 				ComShowCodeMessage("PRI00303", "Sheet", Number(rowArr[j])+1-hrows);
  						     return false;
  			 			}
  					} //if
				} //if
			} //for
		} //for
	} //if
	return true;
}
 /**
  * Calling Function in case of OnChange event <br>
  * showing Description<br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param {ibsheet} sheetObj mandatory IBSheet Object
  * @param {int} Row mandatory Onclick ,Cell's Row Index
  * @param {int} Col mandatory Onclick ,Cell's Column Index
  * @param {string} Value Mandatory Value
  * @return void
  * @author 
  * @version 2009.06.25
  */  
function sheet2_OnChange(sheetObj, Row, Col, Value) {
  	var colName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
	switch(colName)
  	{
		case "chg_rule_def_cd":		
			if (Value != null && Value != "" && Value.length == 3) {
				//Handling DEFAULT data
				defaultColumnValidation(sheetObj, Row, Col, Value);
				//handling column disable
				disableColumnValidation(sheetObj, Row, Col, Value);
				var sCode=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
				var sText=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
				if (sCode.indexOf(Value) < 0) {
					formObj.f_cmd.value=COMMAND09;
					sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
					var arrData=ComPriXml2Array(sXml, "cd|nm");
					if (arrData != null && arrData.length > 0) {
						sCode += "|" + Value;
						sText += "|" + Value;
						sheetObj.SetColProperty("chg_rule_def_cd", {ComboText:sText, ComboCode:sCode} );
						ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
					} else {
						sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
					}
				}
				insertChargeRuleType(sheetObj, Row);
			} else {
				sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
			}
			// defining Rule & Charge Code color
			//setChargeRuleColor(sheetObj, Row);
			break;
		case "eff_dt":	
			var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
			var expDt=ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
			if(sheetObj.GetCellValue(Row, "eff_dt") < effDt) {
				ComShowCodeMessage("PRI08016");
				sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
				sheetObj.SelectCell(Row,"eff_dt");
			}
			if(sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt") ){
				ComShowCodeMessage("PRI00306");
				sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
				sheetObj.SelectCell(Row,"eff_dt");
			}
			break;
		case "exp_dt":	
			var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
			var expDt=ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
			if(sheetObj.GetCellValue(Row, "exp_dt") > expDt) {
				ComShowCodeMessage("PRI08016");
				sheetObj.SetCellValue(Row, "exp_dt",expDt,0);
				sheetObj.SelectCell(Row,"exp_dt");
			}
			if(sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt") ){
				ComShowCodeMessage("PRI00306");
				sheetObj.SetCellValue(Row, "exp_dt",expDt,0);
				sheetObj.SelectCell(Row,"exp_dt");
			}
			break;
		case "bkg_prc_cgo_tp_cd": 	
			var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
			if(chgRuleDefCd == "APP"){
				if(Value != "DG") {
					ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
					sheetObj.SetCellValue(Row, "bkg_prc_cgo_tp_cd","",0);
				}
			}
			if(Value == "DG") {
				sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",1);
			} else {
				sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",0);
				sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
			}
			break;	
		case "bkg_cmdt_def_cd":	
			if (Value.length == 5) { //Group Commodity
				var propNo=formObj.prop_no.value;
				var amdtSeq=formObj.amdt_seq.value;
				var svcScpCd=formObj.svc_scp_cd.value;
				formObj.f_cmd.value=SEARCH10;
				formObj.cd.value=Value;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=rpscp");
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if(arrData[1] != ""){
					sheetObj.SetCellValue(Row, "bkg_cmdt_def_cd",Value,0);
					sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd",'G',0);
				} else {
					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
					sheetObj.SetCellValue(Row,"bkg_cmdt_tp_cd","",0);
					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
				}
			} else if (Value.length == 6) {
    			formObj.f_cmd.value=SEARCH08;
    			//Puting '0' in front of COMMODITY CODE
    			formObj.cd.value=ComLpad(Value, 6, "0");
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData[1] != "") {
					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd",Value,0);
					//it's commodity code in case of 6 digits
					sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","C",0);
				}else{
  					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
  					sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
  					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
				}
			} else {
				sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
				sheetObj.SetCellValue(Row,"bkg_cmdt_tp_cd","",0);
				sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
			}
    		break;
		case "bkg_por_def_cd":	    		
    		if (Value.length > 1){
    			formObj.f_cmd.value=COMMAND24;
    			formObj.cd.value=Value;
    			var sParam=FormQueryString(formObj);
    			sParam += "&etc1="+PRI_RP_SCP;
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  				if (arrData != null && arrData.length > 0) {
					sheetObj.SetCellValue(Row, "bkg_por_def_cd",arrData[0],0);
					getLocationTypeCode(sheetObj, Row, Col, Value.length);
					}else{
  					sheetObj.SetCellValue(Row,"bkg_por_def_cd","",0);
  					sheetObj.SetCellValue(Row,"bkg_por_tp_cd","",0);
  					sheetObj.SelectCell(Row,"bkg_por_def_cd");
					}	  				
    		}else{	 	
					sheetObj.SetCellValue(Row, "bkg_por_def_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_por_tp_cd","",0);
					sheetObj.SelectCell(Row, "bkg_por_def_cd") ;
    		}
    		sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",0);
    		break;	
		case "bkg_pol_def_cd":	    		
    		if (Value.length > 1){
    			formObj.f_cmd.value=COMMAND24;
    			formObj.cd.value=Value;
    			var sParam=FormQueryString(formObj);
    			sParam += "&etc1="+PRI_RP_SCP;
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  				if (arrData != null && arrData.length > 0) {
					sheetObj.SetCellValue(Row, "bkg_pol_def_cd",arrData[0],0);
					getLocationTypeCode(sheetObj, Row, Col, Value.length);
					}else{
  					sheetObj.SetCellValue(Row,"bkg_pol_def_cd","",0);
  					sheetObj.SetCellValue(Row,"bkg_pol_tp_cd","",0);
  					sheetObj.SelectCell(Row,"bkg_pol_def_cd");
					}	  				
    		}else{	 	
					sheetObj.SetCellValue(Row, "bkg_pol_def_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","",0);
					sheetObj.SelectCell(Row, "bkg_pol_def_cd");
    		}
    		sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",0);
    		break;	
		case "bkg_pod_def_cd":	    		
    		if (Value.length > 1){
    			formObj.f_cmd.value=COMMAND24;
    			formObj.cd.value=Value;
    			var sParam=FormQueryString(formObj);
    			sParam += "&etc1="+PRI_RP_SCP;
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  				if (arrData != null && arrData.length > 0) {
					sheetObj.SetCellValue(Row, "bkg_pod_def_cd",arrData[0],0);
					getLocationTypeCode(sheetObj, Row, Col, Value.length);
					}else{
  					sheetObj.SetCellValue(Row,"bkg_pod_def_cd","",0);
  					sheetObj.SetCellValue(Row,"bkg_pod_tp_cd","",0);
  					sheetObj.SelectCell(Row,"bkg_pod_def_cd");
					}	  				
    		}else{	 	
					sheetObj.SetCellValue(Row, "bkg_pod_def_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","",0);
					sheetObj.SelectCell(Row, "bkg_pod_def_cd");
    		}
    		sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",0);
    		break;	
		case "bkg_del_def_cd":	    		
    		if (Value.length > 1){
    			formObj.f_cmd.value=COMMAND24;
    			formObj.cd.value=Value;
    			var sParam=FormQueryString(formObj);
    			sParam += "&etc1="+PRI_RP_SCP;
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  				if (arrData != null && arrData.length > 0) {
					sheetObj.SetCellValue(Row, "bkg_del_def_cd",arrData[0],0);
					getLocationTypeCode(sheetObj, Row, Col, Value.length);
					}else{
  					sheetObj.SetCellValue(Row,"bkg_del_def_cd","",0);
  					sheetObj.SetCellValue(Row,"bkg_del_tp_cd","",0);
  					sheetObj.SelectCell(Row,"bkg_del_def_cd");
					}	  				
    		}else{	 	
					sheetObj.SetCellValue(Row, "bkg_del_def_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_del_tp_cd","",0);
					sheetObj.SelectCell(Row, "bkg_del_def_cd");
    		}
    		sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",0);
    		break;	
		case "rt_appl_tp_cd":	
			var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
			var rtOpCd=sheetObj.GetCellValue(Row, "rt_op_cd");
			if(Value == "A" || Value == "F") {
					sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
					sheetObj.SetCellValue(Row, "curr_cd","USD",0);
					sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
					sheetObj.SetCellEditable(Row, "rt_op_cd",1);
					sheetObj.SetCellEditable(Row, "curr_cd",1);
					sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
				} else {
					sheetObj.SetCellValue(Row, "rt_op_cd","",0);
					sheetObj.SetCellValue(Row, "curr_cd","",0);
					sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
					sheetObj.SetCellEditable(Row, "curr_cd",0);
					sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
				}
				if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
					&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
					&& chgRuleDefCd != "ARB" && chgRuleDefCd != "NOT"
					&& chgRuleDefCd != "RAC" ) {
					if( Value == "F") {
						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
					}
					if( Value == "A") {
						sheetObj.SetCellValue(Row, "curr_cd","",0);
						sheetObj.SetCellEditable(Row, "curr_cd",0);
					}
	    		} else if(chgRuleDefCd == "ARB") {
	    			if (Value == "I" || Value == "A"){ 	   
	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
	    				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
						sheetObj.SetCellEditable(Row, "curr_cd",0);
						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
	    			} else if (Value == "S" || Value == "N"){
						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
						sheetObj.SetCellEditable(Row, "curr_cd",0);
						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
						sheetObj.SetCellValue(Row, "curr_cd","",0);
						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
					} else {
						sheetObj.SetCellEditable(Row, "rt_op_cd",0);
						sheetObj.SetCellEditable(Row, "curr_cd",1);
						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
						sheetObj.SetCellValue(Row, "curr_cd","USD",0);
						sheetObj.SetCellValue(Row, "rt_op_cd","",0);
						sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
					}
	    		} else if(chgRuleDefCd == "NOT") {
	    			if (Value != "I" && Value != "N"){ 	   
	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","I",0);
	    				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
						sheetObj.SetCellValue(Row, "curr_cd","",0);
						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
						sheetObj.SetCellEditable(Row, "curr_cd",0);
						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
	    			}
	    		} else if(chgRuleDefCd == "APP") {
	    			if (Value != "S" && Value != "N"){ 	   
	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
	    				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
						sheetObj.SetCellValue(Row, "curr_cd","",0);
						sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
						sheetObj.SetCellEditable(Row, "curr_cd",0);
						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
	    			}
	    		} else if(chgRuleDefCd == "TYP") {
	    			if (Value == "A"){ 	    	    				
	    				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
						sheetObj.SetCellEditable(Row, "curr_cd",0);
						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
						sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
	    				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
	    			} else if (Value == "N"){ 	    	    				
	    				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
						sheetObj.SetCellEditable(Row, "curr_cd",0);
						sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
						sheetObj.SetCellValue(Row, "curr_cd","",0);
						sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
	    			} else {
	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
	    				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
						sheetObj.SetCellEditable(Row, "curr_cd",0);
						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
	    				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
	    			}
	    		}
    		break;
		case "rt_op_cd":
			var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
			var rtApplTpCd=sheetObj.GetCellValue(Row, "rt_appl_tp_cd");
			if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
				&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
				&& chgRuleDefCd != "ARB" && chgRuleDefCd != "NOT") {
				if( rtApplTpCd == "F") {
		    		if(Value == ">" || Value == "<" ) {
		    			ComShowCodeMessage("PRI00326");
		    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		    			sheetObj.SelectCell(Row, "rt_op_cd");
		    		}
	    		}
			} else if(chgRuleDefCd == "RAR") {
				if(Value == ">" || Value == "<" ) {
	    			ComShowCodeMessage("PRI00326");
	    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
	    			sheetObj.SelectCell(Row, "rt_op_cd");
	    		}
			} else if(chgRuleDefCd == "RAP") {
				if(Value == ">" || Value == "<" ) {
	    			ComShowCodeMessage("PRI00326");
	    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
	    			sheetObj.SelectCell(Row, "rt_op_cd");
	    		}
    		} else if(chgRuleDefCd == "DOR") {
				if(Value == ">" || Value == "<" ) {
	    			ComShowCodeMessage("PRI00326");
	    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
	    			sheetObj.SelectCell(Row, "rt_op_cd");
	    		}
    		} else if(chgRuleDefCd == "TYP") {
				if(Value == ">" || Value == "<" ) {
	    			ComShowCodeMessage("PRI00326");
	    			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
	    			sheetObj.SelectCell(Row, "rt_op_cd");
	    		}
    		}
    		break;	
		case "bkg_ts_port_def_cd":	    		
    		if (Value.length == 5){
    			formObj.f_cmd.value=COMMAND24;
    			formObj.cd.value=Value;
    			var sParam=FormQueryString(formObj);
    			sParam += "&etc1="+PRI_RP_SCP;
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  				if (arrData != null && arrData.length > 0) {
					sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd",arrData[0],0);
					sheetObj.SetCellValue(Row,"bkg_ts_port_tp_cd","L",0);
					//Deactivating direct call if existing data in T/S PORT
					sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",0);
				}else{
  					sheetObj.SetCellValue(Row,"bkg_ts_port_def_cd","",0);
  					sheetObj.SetCellValue(Row,"bkg_ts_port_tp_cd","",0);
  					sheetObj.SelectCell(Row,"bkg_ts_port_def_cd");
  					sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",1);
					}	  				
    		}else{	 	
					sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
					sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");
					sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",1);
    		}
    		sheetObj.SetCellBackColor(Row,"bkg_ts_port_def_cd",0);
    		break;	
		case "bkg_dir_call_flg":
    		if (Value == "Y"){
    			sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
    			sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
    			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",0);
    		} else {
    			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",1);
    		}
    		break;	
		case "bkg_slan_cd":
			if (Value.length == 3){
    			formObj.f_cmd.value=COMMAND26;
    			formObj.cd.value=Value;
    			var sParam=FormQueryString(formObj);
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  				if (arrData != null && arrData.length > 0) {
					sheetObj.SetCellValue(Row, "bkg_slan_cd",arrData[0],0);
					}else{
  					sheetObj.SetCellValue(Row,"bkg_slan_cd","",0);
  					sheetObj.SelectCell(Row,"bkg_slan_cd");
					}	  				
    		}else{	 	
					sheetObj.SetCellValue(Row, "bkg_slan_cd","",0);
					sheetObj.SelectCell(Row, "bkg_slan_cd");
    		}
    		break;
		case "bkg_vvd_cd":
			if (Value.length == 9){
				var vslCd=Value.substring(0,4);
				var skdVoyNo=Value.substring(4,8);
				var skdDirCd=Value.substring(8,9);
    			var sParam="f_cmd="+COMMAND27;
    			sParam += "&cd="+vslCd;
    			sParam += "&etc1="+skdVoyNo;
    			sParam += "&etc2="+skdDirCd;
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  				if (arrData != null && arrData.length > 0) {
  					sheetObj.SetCellValue(Row, "bkg_vvd_cd",arrData[0],0);
					sheetObj.SetCellValue(Row, "bkg_vsl_cd",vslCd,0);
					sheetObj.SetCellValue(Row, "bkg_skd_voy_no",skdVoyNo,0);
					sheetObj.SetCellValue(Row, "bkg_skd_dir_cd",skdDirCd,0);
					}else{
					sheetObj.SetCellValue(Row, "bkg_vvd_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_vsl_cd","",0);
					sheetObj.SetCellValue(Row, "bkg_skd_voy_no","",0);
					sheetObj.SetCellValue(Row, "bkg_skd_dir_cd","",0);
						sheetObj.SelectCell(Row, "bkg_vvd_cd");
					}
    		} else{	
    			sheetObj.SetCellValue(Row, "bkg_vvd_cd","",0);
				sheetObj.SetCellValue(Row, "bkg_vsl_cd","",0);
				sheetObj.SetCellValue(Row, "bkg_skd_voy_no","",0);
				sheetObj.SetCellValue(Row, "bkg_skd_dir_cd","",0);
    			sheetObj.SelectCell(Row, "bkg_vvd_cd");
    		}
    		break;
		case "bkg_imdg_clss_cd":
			if (Value.length > 0){
    			formObj.f_cmd.value=COMMAND30;
    			formObj.cd.value=Value;
    			var sParam=FormQueryString(formObj);
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  				if (arrData != null && arrData.length > 0) {
					sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd",arrData[0],0);
					}else{
  					sheetObj.SetCellValue(Row,"bkg_imdg_clss_cd","",0);
  					sheetObj.SelectCell(Row,"bkg_imdg_clss_cd");
					}	  				
    		}else{	 	
					sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
					sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");
    		}
    		break;
		case "curr_cd":
			var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
			if(chgRuleDefCd == "ARB"){
 				if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOK"){
 					ComShowCodeMessage("PRI01074","USD, EUR, GBP, INR, NOK");
 					sheetObj.SetCellValue(Row, "curr_cd","USD",0);
 					sheetObj.SelectCell(Row, "curr_cd");
 	    		}
			}
    		break;
  	}
}
 /**
   * Calling function in case of Onclick event <br>
   * calling calendar  DIV <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibsheet} sheetObj mandatory IBSheet Object
   * @param {int} Row mandatory Onclick ,Cell's Row Index
   * @param {int} Col Mandatory OnClick ,Cell's Column Index 
   * @param {str} Value without Value Mandatory Format when saving 
   * @return void
   * @author 
   * @version 2009.06.18
   */
   function sheet2_OnPopupClick(sheetObj, Row, Col, Value) {
    var colname=sheetObj.ColSaveName(Col);
    var formObj=document.form;
    var pinkColor="#FFC0CB";
    	switch(colname)
    	{
	    	case "eff_dt":
	    		cal=new ComCalendarGrid();
	    		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
	    		break;
	    	case "exp_dt":
	    		cal=new ComCalendarGrid();
	    		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
	    		break;
	    	case "bkg_cmdt_def_cd":
	    		var sUrl="/opuscntr/ESM_PRI_4027.do?"
	   	    		sUrl += "commodity_cmd=CG";
	   	    		sUrl += "&grp_cd="+PRI_RP_SCP;
	   	    		sUrl += "&prop_no="+formObj.prop_no.value;
	   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
	   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;

	  			//2014.09.16
   	  			ComOpenPopup(sUrl, 700, 345, "setReturnValue", "1,0,1,1,1,1,1", true);
	  			
	  			break;
	    	case "bkg_por_def_cd":	
	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";
	  			
	  			//2014.09.16
	 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
	  			
				break;
	    	case "bkg_pol_def_cd":
	  			var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";

 	  			//2014.09.16
 	 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
	  			
	  			
				break;
	    	case "bkg_pod_def_cd":	
	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";
	  			
	  			//2014.09.16
 	 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
	  			
				break;
	    	case "bkg_del_def_cd":	
	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";
	  			
	  			//2014.09.16
 	 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
	  			
				break;
	    	case "bkg_ts_port_def_cd":	
				var sUrl="/opuscntr/ESM_PRI_4026.do?";
				var sParam="&location_cmd=L";
				
				//2014.09.16
   	 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
				
				break;	
	    	case "bkg_slan_cd":	
				var sUrl="/opuscntr/ESM_PRI_4012.do?" + FormQueryString(document.form);
				//2014.09.16
   	 			ComOpenPopup(sUrl, 480, 380, "setReturnValue", "0,1,1,1,1,1,1", true);
				
				break;		
	    	case "bkg_vvd_cd":	
				var sUrl="/opuscntr/ESM_PRI_4013.do?" + FormQueryString(document.form);
				
				//2014.09.16
   	 			ComOpenPopup(sUrl, 415, 380, "setReturnValue", "0,1,1,1,1,1,1", true);
				
				break;	
  	    	case "bkg_yd_cd":
  	    		var bkgYdCd=sheetObj.GetCellValue(Row, Col);
  				var display='0,0,1,1,1,1,1,1,1,1,1,1';
  				var param='?mode=yard&node_cd='+bkgYdCd;
  				// Common Use Popup Calling
  				ComPriOpenPopup('/opuscntr/COM_ENS_061.do' + param, 780, 530, 'callBackTerminalCode', display, true);
  				break;
    	}    	 
   } 
   
   
   /**
    * set Info accoriding to Popup return value <br>
    * callback function of Popup
    * 2014.09.16 NYK
    */ 
   function setReturnValue(rtnVal) {
		var sheetObj = sheetObjects[1];
		var Row = sheetObj.GetSelectRow();
		var Col = sheetObj.GetSelectCol();
	  
		var sSaveName = sheetObj.GetCellProperty(Row, Col, "SaveName");
		switch(sSaveName)
    	{

	    	case "bkg_cmdt_def_cd":

	  			if (rtnVal != null){
	  				sheetObj.SetCellValue(Row, Col,rtnVal.cd,0);
	  				//it's commodity code in case of 6 digits
	  				sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd",rtnVal.tp,0);
	  			}
   	 			
	  			break;
	    	case "bkg_por_def_cd":	

	  			if (rtnVal != null){
	  				sheetObj.SetCellValue(Row, "bkg_por_def_cd",rtnVal.cd,0);
	  				sheetObj.SetCellValue(Row, "bkg_por_tp_cd",rtnVal.tp,0);
	  				// Pink as background color in case of State
	  				if(rtnVal.tp == "T"){
		 	  			sheetObj.SetCellValue(Row, "bkg_por_cnt_cd",rtnVal.cnt_cd,0);
	  					sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",pinkColor);
	  				} else {
	  					sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",0);
	  				}
	  			}
	  			
				break;
	    	case "bkg_pol_def_cd":

	  			if (rtnVal != null){
	  				sheetObj.SetCellValue(Row, "bkg_pol_def_cd",rtnVal.cd,0);
	  				sheetObj.SetCellValue(Row, "bkg_pol_tp_cd",rtnVal.tp,0);
	  				// Pink as background color in case of State
	  				if(rtnVal.tp == "T"){
		 	  			sheetObj.SetCellValue(Row, "bkg_pol_cnt_cd",rtnVal.cnt_cd,0);
	  					sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",pinkColor);
	  				} else {
	  					sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",0);
	  				}
	  			}
	  			
				break;
	    	case "bkg_pod_def_cd":	

	  			if (rtnVal != null){
	  				sheetObj.SetCellValue(Row, "bkg_pod_def_cd",rtnVal.cd,0);
	  				sheetObj.SetCellValue(Row, "bkg_pod_tp_cd",rtnVal.tp,0);
	  				// Pink as background color in case of State
	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.SetCellValue(Row, "bkg_pod_cnt_cd",rtnVal.cnt_cd,0);
	  					sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",pinkColor);
	  				} else {
	  					sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",0);
	  				}
	  			}
	  			
				break;
	    	case "bkg_del_def_cd":	

	  			if (rtnVal != null){
	  				sheetObj.SetCellValue(Row, "bkg_del_def_cd",rtnVal.cd,0);
	  				sheetObj.SetCellValue(Row, "bkg_del_tp_cd",rtnVal.tp,0);
	  				// Pink as background color in case of State
	  				if(rtnVal.tp == "T"){
 	 	  				sheetObj.SetCellValue(Row, "bkg_del_cnt_cd",rtnVal.cnt_cd,0);
	  					sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",pinkColor);
	  				} else {
	  					sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",0);
	  				}
	  			}
	  			
				break;
	    	case "bkg_ts_port_def_cd":	

				if (rtnVal != null){
					sheetObj.SetCellValue(Row, Col,rtnVal.cd,0);
					sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd",rtnVal.tp,0);
				}

				break;	
	    	case "bkg_slan_cd":	

				if (rtnVal != null){
					sheetObj.SetCellValue(Row, Col,rtnVal.toString(),0);
				}

				break;		
	    	case "bkg_vvd_cd":	
	    		
				if (rtnVal != null){
					sheetObj.SetCellValue(Row, Col,rtnVal.toString(),0);
					sheetObj.SelectCell(Row, Col);
				}
				
				break;	


    	}
   }
   
   
	/**
	 * Calling function when Terminal Code popup is closed. <br>
	 * Display the code from popup. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {String} locTp Mandatory location classification (Not Use)
	 * @param {array} rArray Code Value array
	 * @return void
	 * @author 
	 * @version 2010.04.23
	 */
	function callBackTerminalCode(rowArray){
		 var colArray=rowArray[0];
	     if(rowArray != null) {
	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "bkg_yd_cd",colArray[3]);
	     } else {
	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "bkg_yd_cd","");
	     }
	}
	/**
    * Validation Check of bkg_yd_cd <br>
    * <br><b>Example :</b>
    * <pre>
    *    checkTerminalCode(sheetObj, Row, Value);
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
    * @param {int} Row mandatory Onclick ,Cell's Row Index
    * @param {string} Value Mandatory Value
    * @return void
    * @author 
    * @version 2010.04.23
    */ 
	function checkTerminalCode(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return;
		}
		var formObj=document.form;
		if (Value.length == 7) {
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObjects[0].GetSearchData("COM_ENS_061GS.do" , FormQueryString(formObj)+"&node_cd="+Value);
			var arrDesc=ComPriXml2Array(sXml, "yd_cd");
			if(arrDesc == null || arrDesc.length < 1) {
				sheetObj.SetCellValue(Row, "bkg_yd_cd","",0);
			}
		} else {
			sheetObj.SetCellValue(Row, "bkg_yd_cd","",0);
		}
	}
  	/**
 * Setting route's type code to route <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {int} Row mandatory Onclick ,Cell's Row Index
 * @param {int} Col mandatory Onclick ,Cell's Column Index
 * @param {int} Len Mandatory ,Cell's Value Length
 * @return void
 * @author 
 * @version 2009.07.15
 */ 
 function getLocationTypeCode(sheetObj, Row, Col, Len) {
 	var colName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
	switch(colName)
 	{
		case "bkg_por_def_cd":		
	    	if(Len == 5) {
	    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","L",0);
	    	} else if(Len == 2) {
	    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","C",0);
	    	} else if(Len == 3) {
	    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","R",0);
	    	} else if(Len == 4) {
	    		sheetObj.SetCellValue(Row, "bkg_por_tp_cd","G",0);
	    	}
	    	break;
		case "bkg_pol_def_cd":		
	    	if(Len == 5) {
	    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","L",0);
	    	} else if(Len == 2) {
	    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","C",0);
	    	} else if(Len == 3) {
	    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","R",0);
	    	} else if(Len == 4) {
	    		sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","G",0);
	    	} 
	    	break;
		case "bkg_pod_def_cd":		
	    	if(Len == 5) {
	    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","L",0);
	    	} else if(Len == 2) {
	    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","C",0);
	    	} else if(Len == 3) {
	    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","R",0);
	    	} else if(Len == 4) {
	    		sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","G",0);
	    	} 
	    	break;
		case "bkg_del_def_cd":		
	    	if(Len == 5) {
	    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","L",0);
	    	} else if(Len == 2) {
	    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","C",0);
	    	} else if(Len == 3) {
	    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","R",0);
	    	} else if(Len == 4) {
	    		sheetObj.SetCellValue(Row, "bkg_del_tp_cd","G",0);
	    	} 
	    	break;		    
 	}
 }
	/**
	 * Duration's Validation function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @return void
	 * @author 
	 * @version 2009.07.15
	 */ 
 	function checkDuration(sheetObj) {
		var formObj=document.form;
		for (var a=sheetObjects[0].HeaderRows(); sheetObjects[0].RowCount()> 0 && a <= sheetObjects[0].LastRow(); a++) {
			if (sheetObjects[0].GetRowHidden(a) == true) {
				continue;
			}
			if (sheetObjects[0].GetCellValue(a, "amdt_seq") != formObj.amdt_seq.value) {
				continue;
			}
			if (sheetObjects[0].GetCellValue(a, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
				continue;
			}
			var noteConvMapgId=sheetObjects[0].GetCellValue(a, "note_conv_mapg_id");
			for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
				if (sheetObj.GetCellValue(i, "note_conv_mapg_id") == noteConvMapgId) {
					if (sheetObj.GetRowStatus(i) == "D") {
						continue;
					}
					if (sheetObj.GetCellValue(i, "eff_dt") < formObj.eff_dt.value) {
						ComShowCodeMessage("PRI08016");
						sheetObj.SelectCell(i, "eff_dt", false);
						return false;
					}
					if (sheetObj.GetCellValue(i, "eff_dt") > sheetObj.GetCellValue(i, "exp_dt")) {
						ComShowCodeMessage("PRI00306");
						sheetObj.SelectCell(i, "eff_dt", false);
						return false;
					}
					if (sheetObj.GetCellValue(i, "exp_dt") > formObj.exp_dt.value) {
						ComShowCodeMessage("PRI08016");
						sheetObj.SelectCell(i, "exp_dt", false);
						return false;
					}
				}
			}
		}
		return true;
 	}
  	/**
  	 * Setting color in case of status code at Route<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setStateColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object's Row Index
  	 * @return void
  	 * @author 
  	 * @version 2009.07.09
  	 */ 
 	function setStateColor(sheetObj, Row) {
 		// State color
 		var pinkColor="#FFC0CB";
 		if(sheetObj.GetCellValue(Row, "bkg_por_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "bkg_pol_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "bkg_pod_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "bkg_del_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "conv_org_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_org_loc_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "conv_org_via_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_org_via_loc_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "conv_dest_via_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_dest_via_loc_def_cd",pinkColor);
 		}
 		if(sheetObj.GetCellValue(Row, "conv_dest_loc_tp_cd") == "T") {
 			sheetObj.SetCellBackColor(Row,"conv_dest_loc_def_cd",pinkColor);
 		} 		
 	}
  	/**
  	 * Setting color in case of status code at Route<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setChargeRuleColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object's Row Index
  	 * @return void
  	 * @author 
  	 * @version 2009.07.09
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// defining Rule & Charge Code color
 		var sCodeColor="#FFC8C8";
 		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "RAC" ) {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",0);
 		} else {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",sCodeColor);
 		} 
 	}
   /**
    * Checking editable item by selected code<br>
    * 
    * <br><b>Example :</b>
    * <pre>
    *	disableColumnValidation(sheetObj, Row, Col, Value);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory OnClick ,Cell's Column Index 
    * @param {str} Value without Value Mandatory Format when saving 
    * @return void
    * @author 
    * @version 2009.07.02
    */           
   function disableColumnValidation(sheetObj, Row, Col, Value) {
 	initColumnEditable(sheetObj, Row, Col, Value);
	switch(Value)
  	{
  		case "APP":	
  			sheetObj.SetCellEditable(Row, "bkg_rat_ut_cd",0);
  			//sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") 		= false;
  			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
  			sheetObj.SetCellEditable(Row, "curr_cd",0);
  			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
  			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
  			sheetObj.SetCellEditable(Row, "bkg_cmdt_def_cd",0);
  			sheetObj.SetCellEditable(Row, "bkg_por_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_pol_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_pod_def_cd",0);
			sheetObj.SetCellEditable(Row, "bkg_del_def_cd",0);
			break;
  		case "NOT":	
  			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
  			sheetObj.SetCellEditable(Row, "curr_cd",0);
  			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
  			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
			break;
  		case "RAS":	
  			sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
  			sheetObj.SetCellEditable(Row, "curr_cd",0);
  			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
			break;
		case "ARB":	
			//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
			if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S"
				|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I"
					|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
			}
			break;
		case "TYP":
			//sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
			sheetObj.SetCellEditable(Row, "curr_cd",0);
			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
			break;
		case "RAR":
			sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
			sheetObj.SetCellEditable(Row, "curr_cd",0);
			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
			break;
		case "RAP":
			sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
			sheetObj.SetCellEditable(Row, "curr_cd",0);
			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
			break;
		case "DOR":
			sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
			sheetObj.SetCellEditable(Row, "curr_cd",0);
			sheetObj.SetCellEditable(Row, "pay_term_cd",0);
			break;
		default:  //SURCHARGE 												
			if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S"
				|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I"
					|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
			} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
			} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
				sheetObj.SetCellEditable(Row, "curr_cd",0);
			}
			break;
  	}
}
    /**
     * Initializing Editable property for visible item on SHEET<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	initColumnEditable(sheetObj, Row, Col, Value);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving 
     * @return void
     * @author 
     * @version 2009.07.02
     */           
    function initColumnEditable(sheetObj, Row, Col, Value) {    	   
 	   	sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",1);
   	   	sheetObj.SetCellEditable(Row, "bkg_rat_ut_cd",1);
   	   	sheetObj.SetCellEditable(Row, "bkg_prc_cgo_tp_cd",1);
   	   	if(sheetObj.GetCellValue(Row, "bkg_prc_cgo_tp_cd") == "DG") {
   	   		sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",1);
   	   	} else {
   	   		sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",0);
   	   	}
		sheetObj.SetCellEditable(Row, "rt_op_cd",1);
		sheetObj.SetCellEditable(Row, "curr_cd",1);
		sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
		sheetObj.SetCellEditable(Row, "pay_term_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_cmdt_def_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_por_def_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_pol_def_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_pod_def_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_del_def_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_slan_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_cnl_tz_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_vvd_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_soc_flg",1);
		sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",1);
		if(sheetObj.GetCellValue(Row, "bkg_ts_port_def_cd") != "") {
			sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",0);
		} else {
			sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",1);
		}
		if(sheetObj.GetCellValue(Row, "bkg_dir_call_flg") == "Y") {
			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",0);
		} else {
			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",1);
		}	
		sheetObj.SetCellEditable(Row, "bkg_yd_cd",1);
		sheetObj.SetCellEditable(Row, "bkg_esvc_tp_cd",1);
     }
     /**
      * Checking mandatory column by selected code type<br>
      * 
      * <br><b>Example :</b>
      * <pre>
      *	checkMandatoryValidation(sheetObj, Row);
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} Row mandatory Onclick ,Cell's Row Index
      * @return void
      * @author 
      * @version 2009.07.02
      */ 	
   	function checkMandatoryValidation(sheetObj, Row) {
      	if (!eventToken) {
    		return true;
    	}
   		var RowCount=sheetObj.RowCount();
   		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
  		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
  			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
  			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "NOT") {
  			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
  				ComShowCodeMessage("PRI00316","Effective Date");
  				sheetObj.SelectCell(Row, "eff_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
  				ComShowCodeMessage("PRI00316","Expiration Date");
  				sheetObj.SelectCell(Row, "exp_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
  				ComShowCodeMessage("PRI00316","Application");
  				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
  				return false;
 			} else if(sheetObj.GetCellValue(Row, "curr_cd") == "") {
  				if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F"){
					ComShowCodeMessage("PRI00316","Currency");
	 				sheetObj.SelectCell(Row, "curr_cd");
	 				return false;
				}
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001 && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") != "0" && sheetObj.GetCellValue(Row, "frt_rt_amt") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F") {
 	 			ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
	 			// In case that application is fixed amount or adjust amount when inputting SURCHARGE CODE
  				if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
 			}
		} else if (chgRuleDefCd == "APP") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
 				ComShowCodeMessage("PRI00316","Effective Date");
 				sheetObj.SelectCell(Row, "eff_dt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
 				ComShowCodeMessage("PRI00316","Expiration Date");
 				sheetObj.SelectCell(Row, "exp_dt");
 				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
 			} 
  		} else if (chgRuleDefCd == "NOT") {
  			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
  				ComShowCodeMessage("PRI00316","Effective Date");
  				sheetObj.SelectCell(Row, "eff_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
  				ComShowCodeMessage("PRI00316","Expiration Date");
  				sheetObj.SelectCell(Row, "exp_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
  				ComShowCodeMessage("PRI00316","Application");
  				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
  				return false;
  			}  			
  		} else if (chgRuleDefCd == "RAS") {
  			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
  				ComShowCodeMessage("PRI00316","Effective Date");
  				sheetObj.SelectCell(Row, "eff_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
  				ComShowCodeMessage("PRI00316","Expiration Date");
  				sheetObj.SelectCell(Row, "exp_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
  				ComShowCodeMessage("PRI00316","Cal.");
  				sheetObj.SelectCell(Row, "rt_op_cd");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001) {
  				ComShowCodeMessage("PRI00316","Amount");
  				sheetObj.SelectCell(Row, "frt_rt_amt");
  				return false;
  			} 
  		} else if (chgRuleDefCd == "ARB") {
  			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
  				ComShowCodeMessage("PRI00316","Effective Date");
  				sheetObj.SelectCell(Row, "eff_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
  				ComShowCodeMessage("PRI00316","Expiration Date");
  				sheetObj.SelectCell(Row, "exp_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
  				ComShowCodeMessage("PRI00316","Application");
  				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
  				return false;
  			}
  		} else if (chgRuleDefCd == "TYP") {
  			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
  				ComShowCodeMessage("PRI00316","Effective Date");
  				sheetObj.SelectCell(Row, "eff_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
  				ComShowCodeMessage("PRI00316","Expiration Date");
  				sheetObj.SelectCell(Row, "exp_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
 				ComShowCodeMessage("PRI00316","Application");
 				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
 				return false;
  			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Cal.");
 				sheetObj.SelectCell(Row, "rt_op_cd");
 				return false;
 			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
 				ComShowCodeMessage("PRI00316","Amount");
 				sheetObj.SelectCell(Row, "frt_rt_amt");
 				return false;
  			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "" && sheetObj.GetCellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
  				ComShowCodeMessage("PRI00325","Per","Cargo Type");
  				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
  				return false;
  			}
  		} else if (chgRuleDefCd == "RAR") {
  			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
  				ComShowCodeMessage("PRI00316","Effective Date");
  				sheetObj.SelectCell(Row, "eff_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
  				ComShowCodeMessage("PRI00316","Expiration Date");
  				sheetObj.SelectCell(Row, "exp_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
  				ComShowCodeMessage("PRI00316","Cal.");
  				sheetObj.SelectCell(Row, "rt_op_cd");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
  				ComShowCodeMessage("PRI00316","Amount");
  				sheetObj.SelectCell(Row, "frt_rt_amt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "bkg_por_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_pol_def_cd") == ""
  				&& sheetObj.GetCellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_del_def_cd") == "") {
  				//Mandatory input -POR, POL,POD,DEL 				 				
  				ComShowCodeMessage("PRI01052","POR, POL, POD, DEL");
  				sheetObj.SelectCell(Row, "bkg_por_def_cd");
  				return false;
  			}
  		} else if (chgRuleDefCd == "RAP") {
  			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
  				ComShowCodeMessage("PRI00316","Effective Date");
  				sheetObj.SelectCell(Row, "eff_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
  				ComShowCodeMessage("PRI00316","Expiration Date");
  				sheetObj.SelectCell(Row, "exp_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
  				ComShowCodeMessage("PRI00316","Cal.");
  				sheetObj.SelectCell(Row, "rt_op_cd");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
  				ComShowCodeMessage("PRI00316","Amount");
  				sheetObj.SelectCell(Row, "frt_rt_amt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "bkg_cmdt_def_cd") == "") {
  				ComShowCodeMessage("PRI00316","Commodity");
  				sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
  				return false;
  			}
  		} else if (chgRuleDefCd == "DOR") {
  			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
  				ComShowCodeMessage("PRI00316","Effective Date");
  				sheetObj.SelectCell(Row, "eff_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
  				ComShowCodeMessage("PRI00316","Expiration Date");
  				sheetObj.SelectCell(Row, "exp_dt");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
  				ComShowCodeMessage("PRI00316","Cal.");
  				sheetObj.SelectCell(Row, "rt_op_cd");
  				return false;
  			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
  				ComShowCodeMessage("PRI00316","Amount");
  				sheetObj.SelectCell(Row, "frt_rt_amt");
  				return false;
  			}
  		} 
  		return true;
   	}
      /**
       * Setting default at column by selected code type<br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	defaultColumnValidation(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj mandatory IBSheet Object
       * @param {int} Row mandatory Onclick ,Cell's Row Index
       * @param {int} Col Mandatory OnClick ,Cell's Column Index 
       * @param {str} Value without Value Mandatory Format when saving 
       * @return void
       * @author 
       * @version 2009.07.02
       */ 	
   	function defaultColumnValidation(sheetObj, Row, Col, Value) {
     	initColumnValue(sheetObj, Row);
  		switch(Value)
      	{	
  			case "TYP":
  				sheetObj.SetCellValue(Row, "curr_cd","",0);
  				sheetObj.SetCellValue(Row, "bkg_rat_ut_cd","D4",0);
  				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
  				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
  				break;
  			case "NOT":
  				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","I",0);
  				break;
  			case "RAS":
  				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
  				break;
  			case "RAR":
  				sheetObj.SetCellValue(Row, "curr_cd","",0);
  				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
  				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
  				break;
  			case "RAP":
  				sheetObj.SetCellValue(Row, "curr_cd","",0);
  				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
  				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
  				break;
  			case "DOR":
  				sheetObj.SetCellValue(Row, "curr_cd","",0);
  				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
  				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
  				break;
  			case "ARB":
  				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
  				//sheetObj.CellValue2(Row, "curr_cd") 			= "USD";
  				//sheetObj.CellValue2(Row, "rt_op_cd") 			= "+";
  				//sheetObj.CellValue2(Row, "frt_rt_amt") 			= "0";
  				break;
  			default:
  				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
  				break;
      	}
   	}
   /**
    * Initializing data<br>
    * 
    * <br><b>Example :</b>
    * <pre>
    *	initColumnValue(sheetObj, Row);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row mandatory Onclick ,Cell's Row Index
    * @return void
    * @author 
    * @version 2009.07.02
    */ 	
    	function initColumnValue(sheetObj, Row) {
      	  sheetObj.SetCellValue(Row, "rt_appl_tp_cd","",0);
      	  sheetObj.SetCellValue(Row, "rt_op_cd","",0);
      	  sheetObj.SetCellValue(Row, "curr_cd","",0);
      	  sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
      	  sheetObj.SetCellValue(Row, "pay_term_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_rat_ut_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_prc_cgo_tp_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_cmdt_def_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_por_tp_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_por_def_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_pol_tp_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_pol_def_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_pod_tp_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_pod_def_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_del_tp_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_del_def_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_slan_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_vsl_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_skd_voy_no","",0);
      	  sheetObj.SetCellValue(Row, "bkg_skd_dir_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_soc_flg","",0);
      	  sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_dir_call_flg","",0);
      	  sheetObj.SetCellValue(Row, "bkg_cnl_tz_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_vvd_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_hngr_bar_tp_cd","",0);
      	  sheetObj.SetCellValue(Row, "bkg_min_cgo_wgt","",0);
      	  sheetObj.SetCellValue(Row, "bkg_max_cgo_wgt","",0);
     	  sheetObj.SetCellValue(Row, "bkg_yd_cd","",0);
     	 sheetObj.SetCellValue(Row, "bkg_esvc_tp_cd","",0);
    	}
        /**
         * Multi-copying SHEET ROW<br>
         * 
         * <br><b>Example :</b>
         * <pre>
         *	copySheetData(sheetObj);
         * </pre>
         * @param {ibsheet} sheetObj mandatory IBSheet Object
         * @return void
         * @author 
         * @version 2010.03.23
         */	
     	function copySheetData(sheetObj) {
      		//Setting default after loading SHEET
      		var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;  
      		var sCheckRow=sheetObj.FindCheckedRow("chk");
    		if(sCheckRow == ""){
    			sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
    		}
    		sCheckRow=sheetObj.FindCheckedRow("chk");
     		var aCheckArr=ComRtrim(sCheckRow, '|').split("|");
     		if(aCheckArr != null && aCheckArr.length > 0) {
     			for(var i=aCheckArr.length-1; i>=0; i--) {
     				sheetObj.SetSelectRow(aCheckArr[i]);
     				var idx=sheetObj.DataCopy();
          			sheetObj.SetCellValue(idx, "note_conv_seq",maxSeq,0);
          			sheetObj.SetCellValue(idx, "chk",0,0);
          			// State color
          			setStateColor(sheetObj, idx);
          			// defining Rule & Charge Code color
          			//setChargeRuleColor(sheetObj, idx);
          			maxSeq++;
     			}
     		}
     	}
  	/**
       * Seperating logic by selected CHARGE RULE TYPE<br>
       * RULE code : CHG_RULE_TP_CD=C ,Registering to NOTE_CONV_RULE_CD <br>
       * CHARGE code : CHG_RULE_TP_CD=R ,Registering to NOTE_CONV_CHG_CD <br>      
       * <br><b>Example :</b>
       * <pre>
       *	insertChargeRuleType(sheetObj);
       * </pre>
       * @param {ibsheet} sheetObj mandatory IBSheet Object
       * @param {int} Row mandatory Onclick ,Cell's Row Index
       * @return void
       * @author 
       * @version 2009.07.02
       */	
  	function insertChargeRuleType(sheetObj, Row) {
  		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
  		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
  			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
  			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "NOT") {
  			//CHARGE
  			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","C",0);
  			sheetObj.SetCellValue(Row, "note_conv_chg_cd",chgRuleDefCd,0);
  			sheetObj.SetCellValue(Row, "note_conv_rule_cd","",0);
  		} else {
  			//RULE
  			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","R",0);
  			sheetObj.SetCellValue(Row, "note_conv_rule_cd",chgRuleDefCd,0);
  			sheetObj.SetCellValue(Row, "note_conv_chg_cd","",0);
  		}
  	}
   /**
     * Return SYS_GUID() value <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param  void
     * @return sValue EtcData
     * @author 
     * @version 2009.08.13
     */       
     function getSYSGUID() {
     	var formObj=document.form;
     	formObj.f_cmd.value=COMMAND38;
     	var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
 		var sValue=ComGetEtcData(sXml,"SYS_GUID");
 		return sValue;
     }	
     /**
      * Controlling button's authority<br>
      * controlling buttons <br>
      * <br><b>Example :</b>
      * <pre>
      * buttonControlConv()
      * </pre>
      * @param  void
      * @return void
      * @author 
      * @version 2009.04.17
      */
  	function buttonControlConv(){
  		var formObj=document.form;
		var req_usr_flg=formObj.is_req_usr.value;
		var apro_usr_flg=formObj.is_apro_usr.value; 
		var expDt=formObj.exp_dt.value;
		var effDt=formObj.eff_dt.value;
    	var amdtSeq=formObj.amdt_seq.value;
    	var sts=formObj.prc_prop_sts_cd.value;
		try{
			switch(sts) {
				case 'I':   // Initial
					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
						if( sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "amdt_seq") != amdtSeq
								|| sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "src_info_cd") == "AD"
  	  							|| sheetObjects[0].GetRowHidden(sheetObjects[0].GetSelectRow()) == true
  	  							|| (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "amdt_seq")  == amdtSeq
  	  									&& sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "eff_dt")!= effDt)) {
								disableButton("btn_copy");
								disableButton("btn_paste");
								disableButton("btn_rowadd3");
								disableButton("btn_rowcopy");
								disableButton("btn_delete3");
								disableButton("btn_autoword");
						} else {
								enableButton("btn_copy");
								enableButton("btn_paste");
								enableButton("btn_rowadd3");
								enableButton("btn_rowcopy");
								enableButton("btn_delete3");
								enableButton("btn_autoword");
						}
					}				
					break;  				
			}	
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
    			} else {
    				ComShowMessage(e.message);
    			}
    		}
    	}
  	
  	
  	