﻿﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2022.js
*@FileTitle  : RFA Proposal Creation - Rate (Commodity Note)
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
     * @class Commodity Group : business script for Commodity Group  
     */
	// global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
    var eventToken=false;
    var sChgCdVisiable="";
    var dataChanged = false;
    var doRowAmend_idx = "-1";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_add":
				doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
				break;
			case "btn_delete":
				doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
				break;
			case "btn_amend":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC11);
				break;
			case "btn_amendcancel":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC12);
				break;
			case "btn_accept":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC13);
				break;
			case "btn_acceptcancel":
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC14);
				break;
			case "btn_ok":
				if (formObject.prc_prop_sts_cd.value == "I" || formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
				} else {
					ComClosePopup(); 
				}
				break;
			case "btn_close":
				if (formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
				} else {
					ComClosePopup(); 
				}
				break;
			case "btn_rowadd3":
				if(validateFormConversion(sheetObject3,formObject,COMMAND10)) {
					doActionIBSheet(sheetObject3,formObject,COMMAND10);
				}
				break;
			case "btn_copy":
				if(validateFormConversion(sheetObject3,formObject,COMMAND11)) {
					doActionIBSheet(sheetObject3,formObject,COMMAND11);
				}
				break;
			case "btn_paste":
				if(validateFormConversion(sheetObject3,formObject,COMMAND12)) {
					doActionIBSheet(sheetObject3,formObject,COMMAND12);
				}
				break;
			case "btn_rowadd3":
				if(validateFormConversion(sheetObject3,formObject,IBINSERT)) {
					doActionIBSheet(sheetObject3,formObject,IBINSERT);
				}
				break;
			case "btn_rowcopy":
				if(validateFormConversion(sheetObject3,formObject,IBCOPYROW)) {
					doActionIBSheet(sheetObject3,formObject,IBCOPYROW);
				}
				break;
			case "btn_delete3":
				if(validateFormConversion(sheetObject3,formObject,COMMAND13)) {
					doActionIBSheet(sheetObject3,formObject,COMMAND13);
				}
				break;
			//2015.06.19
			case "btn_autoword":
				var sheetObj = sheetObjects[2];
				if(sheetObj.RowCount() > 0) {
					var sPreNote = sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt");
					var sAutoNote = makeAutoNote(sheetObj, chargeRuleCdComboText, chargeRuleCdComboValue, sPreNote);	
					var sNoteCtntLen = ComGetLenByByte(sAutoNote);
					if(sNoteCtntLen != undefined && sNoteCtntLen > 4000){
						ComShowCodeMessage("PRI00307", "Content(4000)");
		 				return false;
					}
					formObject.ta_note_ctnt.value = sAutoNote;
					sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt", sAutoNote);
			        sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt_tooltip", sAutoNote);
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
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListener('change', 'ta_note_ctnt_OnChange', 'ta_note_ctnt');
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
        	sheetObjects[2].SetEditable(1);
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
    		sheetObjects[2].SetEditable(0);
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
	 * handling Onbeforedeactivate events <br>
	 */
	function obj_deactivate(){
		if (ComChkObjValid(ComGetEvent())) {
			var srcName=ComGetEvent("name");
			return true;
		} else {
			return false;
		}
	}
	/**
	 * calling event when changing note data <br>
	 */
	function ta_note_ctnt_OnChange(){
        sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt",document.form.ta_note_ctnt.value);
        sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt_tooltip",document.form.ta_note_ctnt.value);
        //2014.09.18
//        sheet2_OnClick(sheetObjects[1], sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol());
	 }
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
        case 1:  // Grid 1
            with(sheetObj){
           
          if (location.hostname != "")
          var HeadTitle="|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Commodity Group|Actual Customer|1|2|3|4";
          var headCount=ComCountHeadTitle(HeadTitle);

          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:450,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ac_cnt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
           
          InitColumns(cols);
          SetSheetHeight(115);
          SetEditable(0);
          SetEllipsis(1);
          SetShowButtonImage(2);
          }


            break;
		case 2: // sheet1 init
		    with(sheetObj){
	      
	      if (location.hostname != "")
	      var HeadTitle="|Sel.|prop_no|amdt_seq|svc_scp_cd|cmdt_hdr_seq|cmdt_note_seq|Content|Conversion|Conversion|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|prev_note_conv_mapg_id";
	      var headCount=ComCountHeadTitle(HeadTitle);

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1, VScrollMode:1 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
	      SetSheetHeight(110);
	      SetEditable(1);
	      SetShowButtonImage(2);
	      SetAutoRowHeight(0);
	      SetColHidden("chk",1);
	      }
			break;
        case 3:      //t1sheet1 init
            with(sheetObj){
        	      var HeadTitle="|Sel.|Code|Application|Application\nEffective|Application\nExpires|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
        	      "|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +
        	      "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23";
        	      var headCount=ComCountHeadTitle(HeadTitle);
  
        	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:6, DataRowMerge:1, ComboMaxHeight:393 } );

        	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
        	      InitHeaders(headers, info);

        	      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
        	             {Type:"DummyCheck",Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
        	             {Type:"Combo", 	Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Date", 		Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Date", 		Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Float",     Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   	 PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
        	             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
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
        	             {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
        	             {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
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
	    		resizeSheet(); //SetSheetHeight(160);
	    		SetEditable(1);
	    		SetImageList(0,"img/btns_calendar.gif");
	    		sChgCdVisiable=chargeRuleCdComboText;
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
              	SetColProperty(0 ,"chg_rule_def_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
              	SetColProperty(0 ,"bkg_imdg_clss_cd" , {AcceptKeys:"N|[.]"});		
              	SetColProperty(0 ,"bkg_cmdt_def_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
              	SetColProperty(0 ,"bkg_por_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
              	SetColProperty(0 ,"bkg_pol_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
              	SetColProperty(0 ,"bkg_pod_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
              	SetColProperty(0 ,"bkg_del_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
              	SetColProperty(0 ,"bkg_ts_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
              	SetColProperty(0 ,"bkg_slan_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
              	SetColProperty(0 ,"bkg_vvd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              	SetColProperty(0 ,"bkg_yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	 	SetShowButtonImage(2);// showing pop-up image when editable
        	      //no support[check again]CLT 		 		PopupButtonImage(0, "eff_dt")=0;
        	      //no support[check again]CLT 		 		PopupButtonImage(0, "exp_dt")=0;
        	      }


         	break;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[2]);
	}
	
	
	function sheet1_OnClick(sheetObj, Row, Col, Val)  {
		var formObj=document.form;
		var cmdtHdrSeq=sheetObj.GetCellValue(Row, "cmdt_hdr_seq");
		if (cmdtHdrSeq <= 0) cmdtHdrSeq = "XXX";
		formObj.cmdt_hdr_seq.value=cmdtHdrSeq;
		

		ComPriSheetFilter(sheetObjects[1], "cmdt_hdr_seq", cmdtHdrSeq, true);
		//sheet2_OnSelectCell(sheetObjects[1], -1, -1, sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol());
		sheet2_OnClick(sheetObjects[1], sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol());
	}
	
	var isRowBack=false;
	/**
	 * calling function when occurring OnSelectCell Event <br>
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;
		if (OldRow != NewRow) {
			if (isRowBack) {
				isRowBack=false;
				return;
			}
            if (!validateForm(sheetObjects[1], document.form, IBSAVE)) {
            	isRowBack=true;
            	sheetObj.SelectCell(OldRow, OldCol, false);
                return false;
            }

		}
		//sheetObjects[1].RenderSheet(1);
		//sheetObjects[2].RenderSheet(1);
	}
	
	function sheet2_OnClick(sheetObj, Row, Col, Val)  {
		var formObj=document.form;
		
		var sXml=opener.getSheetXml(14);			
		sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
		
		if(dataChanged){
			for (var i=sheetObjects[2].LastRow(); sheetObjects[2].RowCount()> 0 && i >= sheetObjects[2].HeaderRows(); i--) {
        		if (sheetObjects[2].GetRowStatus(i) == "D") {
        			continue;
        		}
        		if (sheetObjects[2].GetCellValue(i, "note_conv_mapg_id") == sheetObjects[1].GetCellValue(doRowAmend_idx, "note_conv_mapg_id")) {
        			if (sheetObjects[2].GetCellValue(i, "eff_dt") < formObj.eff_dt.value) {
        				sheetObjects[2].SetCellValue(i, "eff_dt",formObj.eff_dt.value,0);
        			}
        			if (sheetObjects[2].GetCellValue(i, "exp_dt") > formObj.exp_dt.value) {
        				sheetObjects[2].SetCellValue(i, "exp_dt",formObj.exp_dt.value,0);
        			}
        		}
        	}
		}   
		
		var rowIdx = sheetObj.GetSelectRow();
		var noteCtnt=(rowIdx<= 0 || sheetObj.GetRowStatus(rowIdx) == "D" || sheetObj.GetRowHidden(rowIdx)) ? "" : sheetObj.GetCellValue(rowIdx, "note_ctnt");
		var noteConvMapgId=(rowIdx<= 0 || sheetObj.GetRowStatus(rowIdx) == "D" || sheetObj.GetRowHidden(rowIdx)) ? "XXX" : sheetObj.GetCellValue(rowIdx, "note_conv_mapg_id");
		
		ComPriSheetFilter(sheetObjects[2], "note_conv_mapg_id", noteConvMapgId, true);
		
//		if(sheetObj.GetCellValue(rowIdx, "src_info_cd") == "AD"){
//			var pre = sheetObj.GetCellValue(Row, "prev_note_conv_mapg_id");
//			ComPriSheetFilter(sheetObjects[2], "note_conv_mapg_id", pre, true);
//		} else {
//			ComPriSheetFilter(sheetObjects[2], "note_conv_mapg_id", noteConvMapgId, true);
//		}
		
		formObj.ta_note_ctnt.value=noteCtnt;
		buttonControlConv();
		
		var rowCnt = sheetObjects[2].RowCount();
		var strStatus = sheetObj.GetCellValue(rowIdx, "src_info_cd");
		setSheet2Status(sheetObj);
		
	}

	
	/*
	 * set the status of sheet3(Conversion) according to the info of sheet2's row
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object (sheet2)
	 */
	function setSheet2Status(sheetObj){
		var formObj=document.form;
		if ((bIsReqUsr || bIsAproUsr) && formObj.prc_prop_sts_cd.value == "I"
			&& sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") == formObj.amdt_seq.value
			&& sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
			&& sheetObj.GetCellValue(sheetObj.GetSelectRow(), "src_info_cd") != "AD"
			&& sheetObj.GetRowHidden(sheetObj.GetSelectRow()) != true) {
			
			formObj.ta_note_ctnt.readOnly=false;
			sheetObjects[2].SetEditable(1);
			var sIdx = sheetObjects[2].HeaderRows();
			var eIdx = sheetObjects[2].LastRow();
			for (var i=sIdx; i <= eIdx; i++) {
				if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "src_info_cd") == "AM") {
	 				sheetObjects[2].SetCellEditable(i, "chg_rule_def_cd",0);
	 			} else {
	 				sheetObjects[2].SetCellEditable(i, "chg_rule_def_cd",1);
	 			}
				disableColumnValidation(sheetObjects[2], i, 2, sheetObjects[2].GetCellValue(i,"chg_rule_def_cd"));
      			// State color classification
      			setStateColor(sheetObjects[2], i);
      			// Rule & Charge Code color classification
      			//setChargeRuleColor(sheetObjects[2], i);
	 		}
		} else {
			formObj.ta_note_ctnt.readOnly=true;
			sheetObjects[2].SetEditable(0);
		}

	}
	
	/**
	 * calling function when occurring OnSelectCell Event <br>
	 */
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;

		if (OldRow != NewRow) {
			setSheet2Status(sheetObj);
		} 
		
		
	}
	/**
	 * Handling sheet process <br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var suppresWait = $(ComGetEvent()).attr('suppressWait');
        try {
            if (ComGetEvent() == null || ComGetEvent() == null || ComGetEvent().suppresWait != "Y") {
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
	        	var idx=opener.doRowAmend(sheetObj, "AM");
	        	sheetObj.SetCellValue(idx - 1, "note_conv_mapg_id",sheetObj.GetCellValue(idx - 1, "prev_note_conv_mapg_id"),0);
	        	sheetObj.SetRowStatus(idx - 1,"R");
	        	for (var i=sheetObjects[2].LastRow(); sheetObjects[2].RowCount()> 0 && i >= sheetObjects[2].HeaderRows(); i--) {
	        		if (sheetObjects[2].GetRowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[2].GetCellValue(i, "note_conv_rule_cd") == "APP") {
	        			continue;
	        		}
	        		doRowAmend_idx = idx;
	        		if (sheetObjects[2].GetCellValue(i, "note_conv_mapg_id") == sheetObj.GetCellValue(idx, "note_conv_mapg_id")) {
	        			if (sheetObjects[2].GetCellValue(i, "exp_dt") < formObj.eff_dt.value) {
	        				sheetObjects[2].SetRowHidden(i,1);
	        				sheetObjects[2].SetRowStatus(i,"D");
	        			}
	        			if (sheetObjects[2].GetCellValue(i, "eff_dt") > formObj.exp_dt.value) {
	        				sheetObjects[2].SetRowHidden(i,1);
	        				sheetObjects[2].SetRowStatus(i,"D");
	        			}
	        		}
	        	}
	        	for (var i=sheetObjects[2].LastRow(); sheetObjects[2].RowCount()> 0 && i >= sheetObjects[2].HeaderRows(); i--) {
	        		if (sheetObjects[2].GetRowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[2].GetCellValue(i, "note_conv_mapg_id") == sheetObj.GetCellValue(idx, "note_conv_mapg_id")) {
	        			if (sheetObjects[2].GetCellValue(i, "eff_dt") < formObj.eff_dt.value) {
	        				sheetObjects[2].SetCellValue(i, "eff_dt",formObj.eff_dt.value,0);
	        				dataChanged = true;
	        			}
	        			if (sheetObjects[2].GetCellValue(i, "exp_dt") > formObj.exp_dt.value) {
	        				sheetObjects[2].SetCellValue(i, "exp_dt",formObj.exp_dt.value,0);
	        				dataChanged = true;
	        			}
	        		}
	        	}
	        	setSheetStyle(sheetObj, idx - 1);
	        	setSheetStyle(sheetObj, idx);
	        	//sheet2_OnSelectCell(sheetObj, idx - 1, sheetObj.GetSelectCol(), idx, sheetObj.GetSelectCol);
	        	sheet2_OnClick(sheetObjects[1], idx, sheetObj.GetSelectCol());
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
	        	var srcInfoCd = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "src_info_cd");
	        	var strStatus = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "ibflag");
	        	var newNoteConvMapgId=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "note_conv_mapg_id");
	        	var prevNoteConvMapgId=sheetObj.GetCellValue(sheetObj.GetSelectRow()- 1, "note_conv_mapg_id");
	        	var idx=opener.doRowAmendCancel(sheetObj);
	        	sheetObj.SetCellValue(idx, "note_conv_mapg_id",newNoteConvMapgId,0);
	        	for (var i=sheetObjects[2].LastRow(); sheetObjects[2].RowCount()> 0 && i >= sheetObjects[2].HeaderRows(); i--) {
	        		if (sheetObjects[2].GetRowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[2].GetCellValue(i, "note_conv_mapg_id") == newNoteConvMapgId) {
	    				sheetObjects[2].SetRowHidden(i,1);
	    				sheetObjects[2].SetRowStatus(i,"D");
	        		}
	        	}
	        	for (var i=sheetObjects[2].LastRow(); sheetObjects[2].RowCount()> 0 && i >= sheetObjects[2].HeaderRows(); i--) {
	        		if (sheetObjects[2].GetRowStatus(i) == "D") {
	        			continue;
	        		}
	        		if (sheetObjects[2].GetCellValue(i, "note_conv_mapg_id") == prevNoteConvMapgId) {
	        			sheetObjects[2].SelectCell(i, 0);
	        			var copiedIdx=sheetObjects[2].DataCopy();
	        			sheetObjects[2].SetCellValue(copiedIdx, "note_conv_mapg_id",newNoteConvMapgId,0);
	        			sheetObjects[2].SetCellValue(copiedIdx, "amdt_seq",formObj.amdt_seq.value,0);
	        			// 2009-12-02
	        			// 2010-08-04 note must have previous seq. MAIN-DURATION info
	        			if (sheetObjects[2].GetCellValue(copiedIdx, "exp_dt") == formObj.before_exp_dt.value) {
	        				sheetObjects[2].SetCellValue(copiedIdx, "exp_dt",formObj.exp_dt.value,0);
	        			}
	        			dataChanged = false;
	        		}
	        	}
	        	setSheetStyle(sheetObj, idx);
	        	sheetObj.SetSelectRow(idx);
	        	
	        	sheet2_OnClick(sheetObjects[1], idx, sheetObj.GetSelectCol());

	            break;
	        case IBSEARCH_ASYNC13: // Accept
	        	if (getCntForNotHiddenChkedRows(sheetObj) <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00008")) {
	            	return false;
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
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2022GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, false, "chk");
	            setCheckAllSheet(sheetObj,0);
	            setSheetStyle(sheetObj, -1);
	            exTransaction=true;
	            opener.updateSummary();
	            ComShowCodeMessage("PRI00108");
	            break;
	        case IBSEARCH_ASYNC14: // Accept Cancel
	        	if (getCntForNotHiddenChkedRows(sheetObj) <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00009")) {
	            	return false;
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
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2022GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, false, "chk");
	            setCheckAllSheet(sheetObj,0);
	            setSheetStyle(sheetObj, -1);
	            exTransaction=true;
	            opener.updateSummary();
	            ComShowCodeMessage("PRI00109");
	            break;
	        case IBSAVE: // OK

	        	var rowIdx = sheetObjects[1].GetSelectRow();
	        	var rowIdx_key_ad = findAmendRowIdxSheet2Key(rowIdx);
	        	//when the selection row status is amend(AD) 
	        	//skip validateForm function
	        	if(rowIdx_key_ad >= 1){
	        		if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
		                return false;
		            }
	        	} else {
	        		if (!validateForm(sheetObj,document.form,sAction)) {
		                return false;
		            }
			     	var amdtSeq=formObj.amdt_seq.value;
			     	if (sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") == amdtSeq) {
			     		if (!checkDuration(sheetObjects[2])) {
			   				return false;
			   			}
						
					}
					//checking when row focus changes - because prohibiting error data transfer 
		   			for(var i = sheetObjects[2].HeaderRows(); getValidRowCount(sheetObjects[2]) > 0 && i <= sheetObjects[2].LastRow(); i++) {
		   				if(!sheetObjects[2].GetRowHidden(i)) {
			   				if(!checkMandatoryValidation(sheetObjects[2], i)) {
			 					return false;
			 				}
		   				}
		   			}
	        	}
	     			
	            
	            
	        	sheetObj.ColumnSort("cmdt_hdr_seq|cmdt_note_seq|amdt_seq", "ASC", "ASC|ASC|ASC", true);
	        	
	        	var sXml="";
				sXml=ComPriSheet2Xml(sheetObjects[1]);
				opener.setSheetXml(sXml, 5);
				sXml=ComPriSheet2Xml(sheetObjects[2]);
				opener.setSheetXml(sXml, 14);
				ComPopUpReturnValue("O"); 
				//opener.setReturnValue("O");
				if (exTransaction) {
					parent.restylingPagePostTr();
				}
				
				//2015.06.19
				opener.doSaveCommdityNote();
	        	
	            break; 
			case IBSEARCH: // retrieving from parent sheet
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            var sXml="";
	            //sheetObjects[2].RenderSheet(0);
	            // NOTE CONVERSION RULE
				var sCd=sheetObjects[2].GetComboInfo(0,"chg_rule_def_cd","Code");
				var sNm=sheetObjects[2].GetComboInfo(0,"chg_rule_def_cd","Text");
				sXml=opener.getSheetXml(0);
				sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
				setHdrLineStyle(sheetObjects[0]);
				//sheetObjects[0].SetSelectRow(formObj.select_row.value);
				//sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol());
				
				//sheetObjects[1].RenderSheet(0);
				sXml=opener.getSheetXml(5);
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				//<DEVELOPER CAUTION>DO NEVER SORT
				//sheetObjects[1].ColumnSort("cmdt_hdr_seq|cmdt_note_seq|amdt_seq", "ASC", "ASC|ASC|ASC", true);
				setSheetStyle(sheetObjects[1], -1);
				
				sXml=opener.getSheetXml(14);
				var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd");			
				if (arrData != null && arrData.length > 0) {
					for(var i=0; i<arrData.length; i++){						
						if (sCd.indexOf(arrData[i][0]) < 0) {
							sCd += "|" + arrData[i][0];
							sNm += "|" + arrData[i][0];
						}
					}					
					sheetObjects[2].SetColProperty(2, {ComboText:sNm , ComboCode:sCd} );
				}			
				sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
				for (var i=sheetObjects[2].HeaderRows(); sheetObjects[2].RowCount()> 0 && i <= sheetObjects[2].LastRow(); i++) {
					if (sheetObjects[2].GetRowStatus(i) == "D") {
			    		sheetObjects[2].SetRowHidden(i,1);
			    	}
				}

				sheetObjects[0].SetSelectRow(formObj.select_row.value);
				sheet1_OnClick(sheetObjects[0], -1, sheetObjects[0].GetSelectCol());
				
	         	break; 	
			case IBINSERT: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            formObj.f_cmd.value=COMMAND38;
 	            var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
	            if (sysGuid == null || sysGuid.length < 16) {
	            	return false;
	            }
		        var idx=sheetObj.DataInsert();
	            sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	            sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	            sheetObj.SetCellValue(idx, "cmdt_hdr_seq",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cmdt_hdr_seq"));
	            sheetObj.SetCellValue(idx, "cmdt_note_seq",parseInt(ComPriGetMax(sheetObj, "cmdt_note_seq"))+ 1);
	            sheetObj.SetCellValue(idx, "note_conv_mapg_id",sysGuid);
	            sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
	            sheetObj.SetCellValue(idx, "prc_prog_sts_nm","Initial");
	            sheetObj.SetCellValue(idx, "src_info_cd","NW");
	            sheetObj.SetCellValue(idx, "src_info_nm","New");
	            sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
	            sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
	            setSheetStyle(sheetObj, idx);
	            sheet2_OnSelectCell(sheetObj, idx - 1, sheetObj.GetSelectCol(), idx, sheetObj.GetSelectCol());
	            document.form.ta_note_ctnt.value="";
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
	            	for (var j=sheetObjects[2].LastRow(); sheetObjects[2].RowCount()> 0 && j >= sheetObjects[2].HeaderRows(); j--) {
	            		if (sheetObjects[2].GetRowStatus(j) == "D") {
	            			continue;
	            		}
	            		if (sheetObjects[2].GetCellValue(j, "note_conv_mapg_id") == sheetObj.GetCellValue(arrCheckedRows[i], "note_conv_mapg_id")) {
	        				sheetObjects[2].SetRowHidden(j,1);
	        				//sheetObjects[2].SetRowStatus(j,"D");
	            		}
	            	}
	            	if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            		sheetObj.SetSelectRow(arrCheckedRows[i]);
	               		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","0",0);
	               		var idx=opener.doRowAmend(sheetObj, "AD");
	               		sheetObj.SetCellValue(idx - 1, "note_conv_mapg_id",sheetObj.GetCellValue(idx, "prev_note_conv_mapg_id"),0);
	                	sheetObj.SetRowStatus(idx - 1,"R");
	                	setSheetStyle(sheetObj, idx - 1);
	                	setSheetStyle(sheetObj, idx);
	            	} else {
	            		sheetObj.SetRowHidden(arrCheckedRows[i],1);
	            		sheetObj.SetRowStatus(arrCheckedRows[i],"D");
	            	}
	        	}
	        	//sheet2_OnSelectCell(sheetObj, -1, sheetObj.GetSelectCol(), idx, sheetObj.GetSelectCol);
	        	sheet2_OnClick(sheetObj, idx, sheetObjects[0].GetSelectCol());
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
					sheetObj.SetCellValue(idx, "note_conv_mapg_id",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_conv_mapg_id"),0);
					sheetObj.SetCellValue(idx, "note_conv_tp_cd","C",0);
					sheetObj.SetCellValue(idx, "note_conv_seq",parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1,0);
					sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
					sheetObj.SetEditable(1);
					//applying when code's default value exist
					defaultColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
					//setting Editable
					disableColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
					updateNoteConvChecked();
				
				}
				
				break;
			case COMMAND11: //COPY
				var iCheckRow=sheetObj.FindCheckedRow("chk");
				var arrRow=iCheckRow.split("|");			
				for (var idx=0; idx<arrRow.length-1; idx++){ 
					if(sheetObj.GetRowHidden(arrRow[idx])) {
						var rowStatus=sheetObj.GetRowStatus(arrRow[idx]);
						sheetObj.SetCellValue(arrRow[idx], "chk","0",0);
						sheetObj.SetRowStatus(arrRow[idx],rowStatus);
					}
				}
				if((ComShowCodeConfirm("PRI00012")) ) {
					if(iCheckRow != "") {
						comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
					}
					formObj.f_cmd.value=MULTI12;
					sheetObj.DoSave("ESM_PRI_2022GS.do", FormQueryString(formObj), -1, false);
					//sheetObj.CheckAll2("chk") = "0";
				}			
				break;
			case COMMAND12: //PASTE			
				if((ComShowCodeConfirm("PRI00016")) ) {
					// NOTE CONVERSION RULE
					var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			//////////////////////////////////////////////////////////////					
					formObj.f_cmd.value=SEARCH14;
 					var sXml=sheetObj.GetSearchData("ESM_PRI_2022GS.do", FormQueryString(formObj));
					var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd"); 
			      	if(arrData != null && arrData.length > 0) {
			      		//calling InitDataCombo after adding combolist
			      		for(var i=0; i<arrData.length; i++){						
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}					
						sheetObj.SetColProperty(2, {ComboText:sNm , ComboCode:sCd} );
						//////////////////////////////////////						
			      		sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
			      		var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
			      		var arrRow=ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
			      		if(arrRow != null && arrRow.length > 0) {  
			      			for(var i=0; i<arrRow.length; i++) {
			      				sheetObj.SetRowStatus(arrRow[i], "I");
				      			sheetObj.SetCellValue(arrRow[i], "note_conv_seq",maxSeq + i,0);
				      			sheetObj.SetCellValue(arrRow[i], "note_conv_mapg_id",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_conv_mapg_id"),0);
				      			sheetObj.SetCellValue(arrRow[i], "svc_scp_cd",formObj.svc_scp_cd.value,0);
				      			sheetObj.SetCellValue(arrRow[i], "prop_no",formObj.prop_no.value,0);
								sheetObj.SetCellValue(arrRow[i], "amdt_seq",formObj.amdt_seq.value,0);
				      			sheetObj.SetCellValue(arrRow[i], "note_conv_tp_cd","C",0);
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
	 * the checked row's count not to be hidden
	 */
	function getCntForNotHiddenChkedRows(sheetObj){
		var rValue = 0;
		if(sheetObj.RowCount() == 0) return rValue;
		var stIdx = sheetObj.HeaderRows();
		var etIdx = sheetObj.LastRow();
		for(var i = stIdx; i <= etIdx; i++){
			var chkVal = sheetObj.GetCellValue(i, "chk");
			if(!sheetObj.GetRowHidden(i) && chkVal == 1) {
				rValue++;
			}
		}
		
		return rValue;
	}
	
	/**
	 * check or uncheck about sheet(include hidden row)
	 */
	function setCheckAllSheet(sheetObj, checked){
		if(sheetObj.RowCount() == 0) return;
		var stIdx = sheetObj.HeaderRows();
		var etIdx = sheetObj.LastRow();
		for(var i = stIdx; i <= etIdx; i++){
			sheetObj.SetCellValue(i, "chk", checked, 1);
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
        		if(sheetObj.GetRowHidden(arrCheckedRows[i])) continue;
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
        		if(sheetObj.GetRowHidden(arrCheckedRows[i])) continue;
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
        	
        	var rowIdx = sheetObjects[1].GetSelectRow();
        	var rowIdx_key_ad = findAmendRowIdxSheet2Key(rowIdx);
        	//if the selection row status is amend(AD) 
        	if(rowIdx_key_ad >= 1){
        		//skip validation
        		return true;
        	}
     			
            if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
                return false;
            }
			/* CONVERSION - START */
	        if (sheetObjects[2].IsDataModified()&& sheetObjects[2].GetSaveString() == "") {
	            return false;
	        }	

	        //NOTE_CTNT : check length
	        if (sheetObjects[1].IsDataModified()) {
	        	for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
	        		if(sheetObjects[1].GetRowStatus(i) == "I" || sheetObjects[1].GetRowStatus(i) == "U") {
	        			var sNoteCtnt = sheetObjects[1].GetCellValue(i, "note_ctnt");
	        			var sNoteCtntLen = ComGetLenByByte(sNoteCtnt);
	        			if(sNoteCtntLen != undefined && sNoteCtntLen > 4000){
	        				ComShowCodeMessage("PRI00307", "Content(4000)");
	        				sheetObjects[1].SelectCell(i, "note_ctnt");
	         				return false;
	        			}
	        		}
	        	}
	        }
			if (sheetObjects[2].IsDataModified()) {
				for (var i=sheetObjects[2].HeaderRows(); i <= sheetObjects[2].LastRow(); i++) {
					if(sheetObjects[2].GetCellValue(i, "bkg_vvd_cd") != ""  && sheetObjects[2].GetCellValue(i, "bkg_vvd_cd").length != 9 && sheetObjects[2].GetRowStatus(i) != "D") {
		 				sheetObjects[2].SelectCell(i, "bkg_vvd_cd");
		 				ComShowCodeMessage("PRI01065", "VVD", "9");
		 				return false;
		 			}
					
					var minCgoWgt = sheetObjects[2].GetCellValue(i, "bkg_min_cgo_wgt");
					var maxCgoWgt = sheetObjects[2].GetCellValue(i, "bkg_max_cgo_wgt");
					if(sheetObjects[2].GetRowStatus(i) != "D" && minCgoWgt != "" && minCgoWgt > 999.999) {
						ComShowCodeMessage("PRI00336", 'Weight(Ton<=)', '999.999');
						sheetObjects[2].SelectCell(i, "bkg_min_cgo_wgt");
						return false;
					}
					if(sheetObjects[2].GetRowStatus(i) != "D" && maxCgoWgt != "" && maxCgoWgt > 999.999) {

						ComShowCodeMessage("PRI00336", 'Weight(<Ton)', '999.999');
						sheetObjects[2].SelectCell(i, "bkg_max_cgo_wgt");
						return false;
					}
		 		}
				if (!validateDupCheck(sheetObjects[2])) {
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
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	//if (sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
        	if (sheetObjects[0].RowCount()> 0 && sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	var cmdtHdrSeq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cmdt_hdr_seq");
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	if (sheetObj.GetCellValue(i, "amdt_seq") == formObj.amdt_seq.value
            			&& sheetObj.GetCellValue(i, "cmdt_hdr_seq") == cmdtHdrSeq
            			&& sheetObj.GetRowStatus(i) != "D") {
                    return false;
                }
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
    	var noteConvMapgId=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_conv_mapg_id");
    	var prevGetRowStatus=sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow());
    	for (var i=sheetObjects[2].HeaderRows(); sheetObjects[2].RowCount()> 0 && i <= sheetObjects[2].LastRow(); i++) {
    		if (sheetObjects[2].GetCellValue(i, "note_conv_mapg_id") == noteConvMapgId && sheetObjects[2].GetRowStatus(i) != "D") {
    			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_conv_mapg_id_chk","1");
    			sheetObjects[1].SetRowStatus(sheetObjects[1].GetSelectRow(),prevGetRowStatus);
    			return;
    		}
    	}
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_conv_mapg_id_chk","0");
		sheetObjects[1].SetRowStatus(sheetObjects[1].GetSelectRow(),prevGetRowStatus);
		return;
    }
	/**
	 * setting style function, after retrieving<br>
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
	 * setting editable or not all rows, column by row after retrieving on sheet <br>
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
    function setHdrLineStyle(sheetObj) {
		for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetRowStatus(i) == "D") {
				sheetObj.SetRowHidden(i,1);
			}
	    	if (document.form.amdt_seq.value == "0") {
	    		continue;
	    	}
	    	if (parseInt(sheetObj.GetCellValue(i, "nd_cnt")) == 0) {
 				sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(),1);
			} else {
 				sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(),0);
			}
	    	if (parseInt(sheetObj.GetCellValue(i, "na_cnt")) > 0) {
 				sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
			} else {
 				sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#000000");
			}
		}
    }
	/**
	 * calling event when occurring OnBeforeCheck event <br>
	 */
 	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
	/**
	 * calling event when occurring OnBeforeCheck event <br>
	 */
	function sheet3_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}
	/**
	 * checking validation process of inputed form data <br>
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
 	 * checking sheet's row duplication <br>
 	 * in case of EFF_DT = EXP_DT only<br>
 	 */ 
 	function validateDupCheck(sheetObj) {
 		var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
			 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_por_def_cd|bkg_pol_def_cd|bkg_pod_def_cd|bkg_del_def_cd" +
			 		"|bkg_slan_cd|bkg_cnl_tz_cd|bkg_vvd_cd|bkg_soc_flg|bkg_dir_call_flg|bkg_ts_port_def_cd|bkg_min_cgo_wgt|bkg_max_cgo_wgt|bkg_hngr_bar_tp_cd|bkg_esvc_tp_cd|note_conv_mapg_id", false, true);
 		if (rowM != "") {
 			var rowDup=rowM.replace("|", ","); 			
			//all duplicate rows
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
     * calling function when occurring OnChange Event <br>
     * when selecting multi comboBox, showing description <br>
     */  
 	function sheet3_OnChange(sheetObj, Row, Col, Value) {
     	var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		switch(colName)
     	{
 			case "chg_rule_def_cd":		
 				if (Value != null && Value != "" && Value.length == 3) {
 					//setting default data
 					defaultColumnValidation(sheetObj, Row, Col, Value);
 					//setting column disable
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
 							sheetObj.SetColProperty("chg_rule_def_cd", {ComboText:sText , ComboCode:sCode} );
 							ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
 						} else {
 							sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
 						}
 					}
 					insertChargeRuleType(sheetObj, Row);
 				} else {
 					sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
 				}
 				// Rule & Charge Code color classification
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
 	    			//adding '0' in front of COMMODITY CODE
 	    			formObj.cd.value=ComLpad(Value, 6, "0");
  	  				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
 	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != "") {
  						sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd",Value,0);
  						//COMMODITY CODE in case of 6 length
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
      * calling function when occurring OnClick Event <br>
      * calling calendar DIV <br>
      */
      function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
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
   	   	    	
//   	   	    //2014.09.15 delete
//   	   	    	var rtnVal=ComPriOpenWindowCenter(sUrl, "ESM_PRI_4027", 600, 300, true);
//   	  			if (rtnVal != null){
//   	  				sheetObj.SetCellValue(Row, Col,rtnVal.cd,0);
//   	  				//COMMODITY CODE in case of 6 length
//   	  				sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd",rtnVal.tp,0);
//   	  			}
   	  			
   	  			//2014.09.15
   	  			ComOpenPopup(sUrl, 700, 345, "setReturnValue", "1,0,1,1,1,1,1", true);
   	  			
   	  			break;
   	    	case "bkg_por_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			
//   	   	    //2014.09.15 delete	  			
// 	  			var rtnVal=ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
// 	  			if (rtnVal != null){
// 	  				sheetObj.SetCellValue(Row, "bkg_por_def_cd",rtnVal.cd,0);
// 	  				sheetObj.SetCellValue(Row, "bkg_por_tp_cd",rtnVal.tp,0);
// 	  				//setting pick background color in case of State
// 	  				if(rtnVal.tp == "T"){
// 	 	  				sheetObj.SetCellValue(Row, "bkg_por_cnt_cd",rtnVal.cnt_cd,0);
// 	  					sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",pinkColor);
// 	  				} else {
// 	  					sheetObj.SetCellBackColor(Row,"bkg_por_def_cd",0);
// 	  				}
// 	  			}
       	
       		//2014.09.15
 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
 	  			
   				break;
   	    	case "bkg_pol_def_cd":
 	  			var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";

//   	   	    //2014.09.15 delete 	  			
// 	  			var rtnVal=ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
// 	  			if (rtnVal != null){
// 	  				sheetObj.SetCellValue(Row, "bkg_pol_def_cd",rtnVal.cd,0);
// 	  				sheetObj.SetCellValue(Row, "bkg_pol_tp_cd",rtnVal.tp,0);
// 	  				//setting pick background color in case of State
// 	  				if(rtnVal.tp == "T"){
// 	 	  				sheetObj.SetCellValue(Row, "bkg_pol_cnt_cd",rtnVal.cnt_cd,0);
// 	  					sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",pinkColor);
// 	  				} else {
// 	  					sheetObj.SetCellBackColor(Row,"bkg_pol_def_cd",0);
// 	  				}
// 	  			}
 	  			
 	  			//2014.09.15
 	 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
 	 			
   				break;
   	    	case "bkg_pod_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			
//   	   	    //2014.09.15 delete 	  			
// 	  			var rtnVal=ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
// 	  			if (rtnVal != null){
// 	  				sheetObj.SetCellValue(Row, "bkg_pod_def_cd",rtnVal.cd,0);
// 	  				sheetObj.SetCellValue(Row, "bkg_pod_tp_cd",rtnVal.tp,0);
// 	  				//setting pick background color in case of State
// 	  				if(rtnVal.tp == "T"){
// 	 	  				sheetObj.SetCellValue(Row, "bkg_pod_cnt_cd",rtnVal.cnt_cd,0);
// 	  					sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",pinkColor);
// 	  				} else {
// 	  					sheetObj.SetCellBackColor(Row,"bkg_pod_def_cd",0);
// 	  				}
// 	  			}
 	  			
 	  			//2014.09.15
 	 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
   				
 	 			break;
   	    	case "bkg_del_def_cd":	
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
 	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
 	  			sUrl += "&location_cmd=LGTCR";
 	  			
//   	   	    //2014.09.15 delete 	  			
// 	  			var rtnVal=ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026", 700, 325, true);
// 	  			if (rtnVal != null){
// 	  				sheetObj.SetCellValue(Row, "bkg_del_def_cd",rtnVal.cd,0);
// 	  				sheetObj.SetCellValue(Row, "bkg_del_tp_cd",rtnVal.tp,0);
// 	  				//setting pick background color in case of State
// 	  				if(rtnVal.tp == "T"){
// 	 	  				sheetObj.SetCellValue(Row, "bkg_del_cnt_cd",rtnVal.cnt_cd,0);
// 	  					sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",pinkColor);
// 	  				} else {
// 	  					sheetObj.SetCellBackColor(Row,"bkg_del_def_cd",0);
// 	  				}
// 	  			}
 	  			
 	  			//2014.09.15
 	 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
 	 			
   				break;
   	    	case "bkg_ts_port_def_cd":	
   				var sUrl="/opuscntr/ESM_PRI_4026.do?";
   				var sParam="&location_cmd=L";
   				//2014.09.15
   	 			ComOpenPopup(sUrl, 700, 310, "setReturnValue", "1,0,1,1,1,1,1", true);
   	 			
   				break;	
   	    	case "bkg_slan_cd":	
   				var sUrl="/opuscntr/ESM_PRI_4012.do?" + FormQueryString(document.form);
   				//2014.09.15
   	 			ComOpenPopup(sUrl, 480, 380, "setReturnValue", "0,1,1,1,1,1,1", true);
   	 			
   				break;		
   	    	case "bkg_vvd_cd":	
   				var sUrl="/opuscntr/ESM_PRI_4013.do?" + FormQueryString(document.form);
   				//2014.09.15
   	 			ComOpenPopup(sUrl, 415, 380, "setReturnValue", "0,1,1,1,1,1,1", true);
   	 			
   				break;	
  	    	case "bkg_yd_cd":
  	    		var bkgYdCd=sheetObj.GetCellValue(Row, Col);
  				var display='0,0,1,1,1,1,1,1,1,1,1,1';
  				var param='?mode=yard&node_cd='+bkgYdCd;
  				//calling comon pop-up
  				ComPriOpenPopup('/opuscntr/COM_ENS_061.do' + param, 780, 530, 'callBackTerminalCode', display, true);
  				break;
       	}    	 
      }
     
      /**
       * set Info accoriding to Popup return value <br>
       * callback function of Popup
       * 2014.09.15 NYK
       */ 
     function setReturnValue(rtnVal) {
    	 var sheetObj = sheetObjects[2];
    	 var Row = sheetObj.GetSelectRow();
    	 var Col = sheetObj.GetSelectCol();
		 var sSaveName = sheetObj.GetCellProperty(Row, Col, "SaveName");
		 switch(sSaveName) {
		 
		 	case "bkg_cmdt_def_cd":
  			
	  			if (rtnVal != null){
	  				sheetObj.SetCellValue(Row, Col,rtnVal.cd,0);
	  				//COMMODITY CODE in case of 6 length
	  				sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd",rtnVal.tp,0);
	  			}
  			
  			break;
	    	case "bkg_por_def_cd":	

	  			if (rtnVal != null){
	  				sheetObj.SetCellValue(Row, "bkg_por_def_cd",rtnVal.cd,0);
	  				sheetObj.SetCellValue(Row, "bkg_por_tp_cd",rtnVal.tp,0);
	  				//setting pick background color in case of State
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
	  				//setting pick background color in case of State
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
	  				//setting pick background color in case of State
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
	  				//setting pick background color in case of State
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
   	 * calling function when closing Terminal Code retrieving pop-up<br>
   	 * showing code got from pop-up <br>
   	 */
   	function callBackTerminalCode(rowArray){
   		 var colArray=rowArray[0];
   	     if(rowArray != null) {
   	    	 sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "bkg_yd_cd",colArray[3]);
   	     } else {
   	    	 sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "bkg_yd_cd","");
   	     }
   	}
  	/**
       * bkg_yd_cd's validation check function <br>
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
 	 * setting ROUTE's TYPE CODE when adding ROUTE data <br>
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
	 */ 
    function checkDuration(sheetObj) {
		var formObj=document.form;
		for (var a=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()> 0 && a <= sheetObjects[1].LastRow(); a++) {
			if (sheetObjects[1].GetRowHidden(a) == true) {
				continue;
			}
			if (sheetObjects[1].GetCellValue(a, "amdt_seq") != formObj.amdt_seq.value) {
				continue;
			}
			if (sheetObjects[1].GetCellValue(a, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
				continue;
			}
			var noteConvMapgId=sheetObjects[1].GetCellValue(a, "note_conv_mapg_id");
			for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
				if (sheetObj.GetCellValue(i, "note_conv_mapg_id") == noteConvMapgId) {
					if (sheetObj.GetRowStatus(i) == "D" || sheetObj.GetRowHidden(i)) {
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
  	 * setting color in case of state code in Route <br>
  	 */ 
 	function setStateColor(sheetObj, Row) {
 		// State color classification
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
  	 * setting color function in case of Code is Rule code <br>
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// Rule & Charge Code color classification
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
       * checking function when selecting code item <br>
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
        * initializing sheet's editable or not <br>
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
         * checking mandatory column when selection CODE <br>
         */ 	
      	function checkMandatoryValidation(sheetObj, Row) {
        	if (!eventToken) {
        		return true;
        	}
      		var rowCount=sheetObj.RowCount();
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
    	 			// when inputting SURCHARGE CODE , in case of APPLICATION is FIXED AMOUNT or ADJUST
    	 			// setting mandatory BKG SOURCE's PER  - 2009.11.09
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
          * setting column default when selecting code <br>
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
       * initializing data function <br>
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
         * mutiple copying sheet's row <br>
         */	
     	function copySheetData(sheetObj) {
      		//setting default value after sheet loading
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
          			// State color classification
          			setStateColor(sheetObj, idx);
          			// Rule & Charge Code color classification
          			//setChargeRuleColor(sheetObj, idx);
          			maxSeq++;
     			}
     		}
     	}
     	/**
          * setting data by CHARGE RULE TYPE when selecting CODE COMBO <br>
          * when selecting RULE code, CHG_RULE_TP_CD:C and register NOTE_CONV_RULE_CD code value   <br>
          * when selecting CHARGE code, CHG_RULE_TP_CD:R and register NOTE_CONV_CHG_CD  <br>
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
        * returning SYS_GUID() value function <br>
        */       
        function getSYSGUID() {
        	var formObj=document.form;
        	formObj.f_cmd.value=COMMAND38;
     		var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
    		var sValue=ComGetEtcData(sXml,"SYS_GUID");
    		return sValue;
        }	
     /**
      * button authority control function <br>
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
  						var masterRow=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cmdt_hdr_seq");
  						var detailRow=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "cmdt_hdr_seq");
  						if( (masterRow != detailRow)
  								|| sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "amdt_seq") != amdtSeq
  								|| sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "src_info_cd") == "AD"
  								|| sheetObjects[1].GetRowHidden(sheetObjects[1].GetSelectRow()) == true
  								|| (sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "amdt_seq")  == amdtSeq
  										&& sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "eff_dt")!= effDt)) {
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
	
	function findAmendRowIdxSheet2Key(Row){
		var sheetObj = sheet2;
		var cmdtHdrSeq = sheetObj.GetCellValue(Row,"cmdt_hdr_seq");
		var cmdtNoteSeq = sheetObj.GetCellValue(Row,"cmdt_note_seq");
		var key = cmdtHdrSeq + "_" + cmdtNoteSeq;
		var rtnKeyRowIdx = -9;
		var sIdx = sheetObj.HeaderRows();
		var eIdx = sheetObj.LastRow();
		for(var i = eIdx; i >= sIdx; i--){
			var t_rowHdn = sheetObj.GetRowHidden(i);
			var t_cmdtHdrSeq = sheetObj.GetCellValue(i,"cmdt_hdr_seq");
			var t_cmdtNoteSeq = sheetObj.GetCellValue(i,"cmdt_note_seq");
			var t_key = t_cmdtHdrSeq + "_" + t_cmdtNoteSeq;
			var t_srcInfoCd = sheetObj.GetCellValue(i,"src_info_cd");
			if(t_rowHdn == 0 && key == t_key && t_srcInfoCd == "AD"){
				rtnKeyRowIdx = i;
				break;
			}
		}
		return rtnKeyRowIdx;
	}