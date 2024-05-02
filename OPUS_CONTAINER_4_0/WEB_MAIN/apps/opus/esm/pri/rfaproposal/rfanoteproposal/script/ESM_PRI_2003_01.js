/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003_01.js
*@FileTitle  : Proposal & Amendment Creation - Special Note 
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
 * @class ESM_PRI_2003_01 : business script for ESM_PRI_2003_01
 */
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	var sChgCdVisiable="";
	var amendFlag=false; 
	//----------------------------------
	//2015.06.09
	var chargeRuleCdComboText  = "";
	var chargeRuleCdComboValue  = "";
	//----------------------------------
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
     * @version 2009.10.28
     */
	function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_acceptall":
					if(validateForm(sheetObject2,formObject,MODIFY01)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY01);
					}
					break;
				case "btn_cancelall":
					if(validateForm(sheetObject2,formObject,MODIFY02)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY02);
					}
					break;
				case "btn_rowadd1":
					if(validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;
				case "btn_rowadd2":
					if(validateForm(sheetObject2,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject2,formObject,IBINSERT);
					}
					break;
				case "btn_delete1":
					if(validateForm(sheetObject1,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;
				case "btn_delete2":
					if(validateForm(sheetObject2,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject2,formObject,IBDELETE);
					}
					break;
				case "btn_amend":
					if(validateForm(sheetObject2,formObject,COMMAND01)) {
						doActionIBSheet(sheetObject2,formObject,COMMAND01);
					}
					break;
				case "btn_amendcancel":
					if(validateForm(sheetObject2,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject2,formObject,COMMAND02);
					}
					break;
				case "btn_accept":
					if(validateForm(sheetObject2,formObject,MODIFY03)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY03);
					}
					break;	
				case "btn_acceptcancel":
					if(validateForm(sheetObject2,formObject,MODIFY04)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY04);
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
						sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_ctnt",sAutoNote);
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
    * adding process for list in case of needing batch processing with other items <br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setSheetObject(sheetObj);
    * </pre>
    * @param {ibsheet} sheet_obj Mandatory IBSheet Object
    * @return N/A
    * @author 
    * @version 2009.10.28
    */
	function setSheetObject(sheet_obj){
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
    * @version 2009.05.17
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		resizeSheet();
		
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		buttonControl();
		parent.loadTabPage();
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
    * @version 2009.05.22
    */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|dp_seq|Title|note_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq" + "|1|2|3|4";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",              KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
			             {Type:"Text",      Hidden:0,  Width:700,  Align:"Left",    ColMerge:0,   SaveName:"note_tit_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dp_fix_flg" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetWaitImageVisible(0);
			      SetAutoRowHeight(0);
			      SetSheetHeight(119);
		      }
			 break;
			 
             case "sheet2":
            	    with(sheetObj){
		               var HeadTitle="|Sel.|Seq.|Contents|EFF Date|EXP Date|Source|Status" + "|1|2|3|4|5|6|7|8|9|10|11|12|13|14";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                      {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                      {Type:"Text",      Hidden:0, Width:550,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,  EditLen:4000},
		                      {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",                  KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_ctnt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_flg" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prev_note_conv_mapg_id" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"temp_note_conv_mapg_id" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bef_eff_dt" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bef_exp_dt" } ];
		               InitColumns(cols);
		               SetEditable(1);
		               SetWaitImageVisible(0);
		               SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
		               SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
		               //SetAutoRowHeight(0);
		               SetShowButtonImage(2);
		               SetSheetHeight(119);
             		}
                 break;
                 
         	case "sheet3":
         	    with(sheetObj){
		              var HeadTitle="|Sel.|Code|Application|Application\nEffective|Application\nExpires|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" + "|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +  "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"DummyCheck",Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
		                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date", 		Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date", 		Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                     {Type:"PopupEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnl_tz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
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
		              SetEditable(1);
		              SetImageList(0,"img/btns_calendar.gif");
		              SetWaitImageVisible(0);
		              SetColProperty("bkg_soc_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
		              SetColProperty("bkg_dir_call_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
		              SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
		              SetColProperty("bkg_prc_cgo_tp_cd", {ComboText:bkgPrcCgoTpCdComboText, ComboCode:bkgPrcCgoTpCdComboValue} );
		              SetColProperty("rt_op_cd", {ComboText:rtOpCdComboText, ComboCode:rtOpCdComboValue} );
		              SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
		              SetColProperty("bkg_hngr_bar_tp_cd", {ComboText:bkgHngrBarTpCdComboText, ComboCode:bkgHngrBarTpCdComboValue} );
		              SetColProperty("bkg_rat_ut_cd", {ComboText:bkgRatUtCdComboText, ComboCode:bkgRatUtCdComboValue} );
		              SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
		              SetColProperty(0 ,"bkg_por_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
		              SetColProperty(0 ,"bkg_pol_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
		              SetColProperty(0 ,"bkg_pod_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
		              SetColProperty(0 ,"bkg_del_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
		              SetColProperty(0 ,"bkg_ts_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
		              SetColProperty("bkg_cnl_tz_cd", {ComboText:bkgCnlTzCdComboText, ComboCode:bkgCnlTzCdComboValue} );
		              SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
		              SetShowButtonImage(2);
		              resizeSheet(); //SetSheetHeight(195);
         			}
              	break;
         }
     }
	
	function resizeSheet() {
	    ComResizeSheet(sheetObjects[2]);
	}
	
	
	var isFiredNested=false;
	var supressConfirm=false;
	/**
    * Calling function in case of clicking sheet's row<br>
    * Retrieving child-sheet by selected row. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,Process Flag contant variable
	 * @returns bool <br>
	 *          true  : Valid<br>
	 *          false : inValid
	 * @author 
	 * @version 2009.05.01
	 */
    function doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj=document.form;
        if (!isFiredNested && (OldRow != NewRow)) {
        	if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
            	&& (sheetObjects[0].IsDataModified())) {
            	isFiredNested=true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                if (validateForm(sheetObjects[0], document.form, IBSAVE)) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                	isFiredNested=true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested=false;
                	}
                } else {
                	isFiredNested=true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    return -1;
                }
            }
        	if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D" && (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified())) {
                isFiredNested=true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                var rslt=false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm=true;
                    var rslt=doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                    supressConfirm=false;
                }
                if (rslt) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested=true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested=false;
                	}
                } else {
                    isFiredNested=true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                	return -1;
                }
            }
            if (sAction == IBINSERT) {
                isFiredNested=true;
                var idx=sheetObjects[0].DataInsert();
                isFiredNested=false;
                return idx;
            } else if (sAction == IBCOPYROW) {
                isFiredNested=true;
                var idx=sheetObjects[0].DataCopy();
                isFiredNested=false;
                return idx;
            } else {
            	formObj.note_seq.value=sheetObjects[0].GetCellValue(NewRow, "note_seq");
				doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
            }
        }
    }
	/**
    * Calling function in case of clicking sheet's row<br>
    * Retrieving child-sheet by selected row. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory Process Flag contant variable
	 * @returns bool <br>
	 *          true  : Valid<br>
	 *          false : Invalid
	 * @author 
	 * @version 2009.05.01
	 */
    function doRowChange2(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj=document.form;
        var adjNewRow=NewRow;
        if (!isFiredNested && (OldRow != NewRow) && !amendFlag) {
        	if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D"
            	&& (sheetObjects[1].IsDataModified()&& sheetObjects[2].IsDataModified())) {
                isFiredNested=true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                var rslt=false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm=true;
                    adjNewRow = Math.max(NewRow - sheetObjects[1].RowCount("D"), sheetObjects[1].HeaderRows());
                    rslt=doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                    supressConfirm=false;
                }
                if (rslt) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested=true;
	                    sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
	                    isFiredNested=false;
                	}
                } else {
                    isFiredNested=true;
                    sheetObjects[1].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                	return -1;
                }
            }
            if (sAction == IBINSERT) {
                isFiredNested=true;
                var idx=sheetObjects[1].DataInsert();
                isFiredNested=false;
                return idx;
            } else if (sAction == IBCOPYROW) {
                isFiredNested=true;
                var idx=sheetObjects[1].DataCopy();
                isFiredNested=false;
                return idx;
            } else {
                LoadingComplete=false;
				formObj.note_seq.value=sheetObjects[1].GetCellValue(NewRow, "note_seq");
				formObj.note_ctnt_seq.value=sheetObjects[1].GetCellValue(NewRow, "note_ctnt_seq");
				formObj.note_conv_mapg_id.value=sheetObjects[1].GetCellValue(NewRow, "note_conv_mapg_id");
				doActionIBSheet(sheetObjects[2],document.form,IBSEARCH_ASYNC01);
                LoadingComplete=true;
            }
        }
    }
   /**
    * Calling function in case of clicking sheet's row<br>
    * Retrieving child-sheet by selected row. <br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetM Mandatory HTML TAG(Object) Object
    * @param {ibsheet} sheetD Mandatory HTML TAG(Object) Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @param {string} appendRow Mandatory ,Appendable
    * @return N/A
    * @author 
    * @version 2009.05.19
    */
	function doRowChange(sheetM, sheetD, sheetC, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested=true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (sheetD.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				var rslt=false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm=true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
					var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm=false;
				}
				if (rslt) {
					isFiredNested=true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (sheetC.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				var rslt=false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm=true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
					var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm=false;
				}
				if (rslt) {
					isFiredNested=true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (appendRow) {
				isFiredNested=true;
				var idx=sheetM.DataInsert();
				isFiredNested=false;
				return idx;
			} else {
				formObj.note_seq.value=sheetM.GetCellValue(adjNewRow, "note_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
		}
	}
   /**
    * Calling function in case of clicking Special Note Detail sheet's row<br>
    * Retrieving child-sheet by selected row. <br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetM Mandatory HTML TAG(Object) Object
    * @param {ibsheet} sheetD Mandatory HTML TAG(Object) Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @param {string} appendRow Mandatory ,Appendable
    * @return N/A
    * @author 
    * @version 2009.05.19
    */    
    function doRowChangeConversion(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetD.IsDataModified()&& !amendFlag) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				var rslt=false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm=true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
					var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm=false;
				}
				if (rslt) {
					isFiredNested=true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (appendRow) {
				isFiredNested=true;
				var idx=sheetM.DataInsert();
				isFiredNested=false;
				return idx;
			} else {
				formObj.note_seq.value=sheetM.GetCellValue(NewRow, "note_seq");
				formObj.note_ctnt_seq.value=sheetM.GetCellValue(NewRow, "note_ctnt_seq");
				formObj.note_conv_mapg_id.value=sheetM.GetCellValue(NewRow, "note_conv_mapg_id");
				doActionIBSheet(sheetD,document.form,IBSEARCH_ASYNC01);
			}
		}
	}
    /**
    * Handling Sheet's process <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj Mandatory html form object
    * @param {int} sAction Mandatory ,Process flag constant variable
    * @return N/A
    * @author 
    * @version 2009.05.22
    */
  	function doActionIBSheet(sheetObj, formObj, sAction) {
  		try {
	  		sheetObj.ShowDebugMsg(false);
	  		switch (sAction) {
	  			case IBCLEAR: // when loading 
	  				//CODE
		 			initComboChargeRuleCode(sheetObj, formObj); 				
	  				break;
	  			case IBSEARCH: 
	  				ComOpenWait(true);
		  			for (var i=0; i < sheetObjects.length; i++) {
						sheetObjects[i].RemoveAll();
					}
					formObj.f_cmd.value=SEARCH01;
					sheetObj.DoSearch("ESM_PRI_2003_01GS.do", FormQueryString(formObj) );
	  				break;
	  			case IBSEARCHAPPEND: 
	  				ComOpenWait(true);
	  				formObj.f_cmd.value=SEARCH02;
	  				var sXml=sheetObj.GetSearchData("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
	  				sheetObj.LoadSearchData(sXml,{Sync:0} );
	  				break;
	  			case IBSEARCH_ASYNC01: 
	  				ComOpenWait(true);
		 			// NOTE CONVERSION RULE
					var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
					var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
		 			////////////////////////////////////////////////////////////////////////////////	
		 			formObj.f_cmd.value=SEARCH13;
		 			var sXml=sheetObj.GetSearchData("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
					var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd");			
					if (arrData != null && arrData.length > 0) {
						for(var i=0; i<arrData.length; i++){						
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}
						//-----------------------
						//2015.06.22
						chargeRuleCdComboText = sNm;
						chargeRuleCdComboValue = sCd;
						//-----------------------
						sheetObj.SetColProperty(2, {ComboText:sNm, ComboCode: sCd} );
					}
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					break;
	  			case IBSAVE: 
					if(!validateForm(sheetObjects[0],formObj,IBSAVE)) {
						return false;
					}
	  				if (!supressConfirm && !ComPriConfirmSave()) {
	  					return false;
	  				}
	  				ComOpenWait(true);
	  			    var amdtSeq=formObj.amdt_seq.value;
	  			    var tRow=sheetObjects[0].FindStatusRow("I|D");
	  			    var tStatus=tRow.split(";");
	  			    //if(tStatus.length-1 > 0) {
	  			    if(tStatus.length > 0) {
				    	//SEQ-1의 DP_SEQ MAX값 
		  			    formObj.f_cmd.value=SEARCH03;
		  				var sXml="";
		  				for (var i=0, n=10 ; i < n ; i++) {
		  					sXml=sheetObj.GetSearchData("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
		  					if(sXml != "") {
		  						break;
		  					}
		  				}
		  				var maxDpSeq=parseInt(ComGetEtcData(sXml,"TITLE_MAX_DP_SEQ"),10);
						for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
							if(sheetObjects[0].GetCellValue(i, "dp_fix_flg") != "Y" && sheetObjects[0].GetRowStatus(i) != "D") {
								maxDpSeq++;
								sheetObjects[0].SetCellValue(i, "dp_seq",maxDpSeq,0);
							}
			  			}
	  			    }
	  			    var cRow=sheetObjects[1].FindStatusRow("I|D");
				    var cStatus=cRow.split(";");
				    //if(cStatus.length-1 > 0) {
				    if(cStatus.length > 0) {
				    	//SEQ-1's DP_SEQ MAX value
		  			    formObj.f_cmd.value=SEARCH04;
		  			    formObj.note_seq.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_seq");
		  			    var sXml="";
		  				for (var i=0, n=10 ; i < n ; i++) {
		  					sXml=sheetObj.GetSearchData("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
		  					if(sXml != "") {
		  						break;
		  					}
		  				}
		  				var maxDtlDpSeq=parseInt(ComGetEtcData(sXml,"CONTENT_MAX_DP_SEQ"),10);
						for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
							if(sheetObjects[1].GetCellValue(i, "prev_note_conv_mapg_id") == "" && sheetObjects[1].GetRowStatus(i) != "D") {
								maxDtlDpSeq++;
								sheetObjects[1].SetCellValue(i, "dp_seq",maxDtlDpSeq,0);
							}
			  			}
				    }
	  				formObj.f_cmd.value=MULTI01;
	  				var sParam=FormQueryString(formObj);
	  				var sParamSheet1=sheetObjects[0].GetSaveString();
	  				if (sParamSheet1 != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	  				}
	  				var sParamSheet2=sheetObjects[1].GetSaveString();
	  				if (sParamSheet2 != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	  				}
	  				var sParamSheet3=sheetObjects[2].GetSaveString();
	  				if (sParamSheet3 != "") {
	  					sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
	  				}
	  				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_01GS.do", sParam);
	  				sheetObjects[2].LoadSaveData(sXml);
	  				sXml=ComDeleteMsg(sXml);
	  				sheetObjects[1].LoadSaveData(sXml);
	  				sXml=ComDeleteMsg(sXml);
	  				sheetObjects[0].LoadSaveData(sXml);
	  				formObj.master_del_chk.value="N";
	  				formObj.amend_func.value="";
	  				if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
	  					return false;
	  				} else {
	  					return true;
	  				}
	  				break;
	  			case IBINSERT: // Row Add
					var eff_dt=formObj.eff_dt.value;
					var exp_dt=formObj.exp_dt.value;
					var amdt_seq=formObj.amdt_seq.value;
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					formObj.master_del_chk.value="N";
					if (sheetObj.id == "sheet1") {
						var idx=doRowChange1(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBINSERT);
						if (idx < 0) {
							return false;
						}
						sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
						sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
						sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value,0);
						sheetObj.SetCellValue(idx, "note_seq",parseInt(ComPriGetMax(sheetObj, "note_seq")) + 1,0);
						sheetObj.SetCellValue(idx, "note_tp_cd",formObj.note_tp_cd.value,0);
						sheetObj.SelectCell(idx, "note_tit_nm");
						sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
						sheetObjects[1].RemoveAll();
						sheetObjects[2].RemoveAll();
					}
					if (sheetObj.id == "sheet2") {
						if(sheetObjects[0].RowCount()==0){
							ComShowCodeMessage("PRI01004");
							return;							
						}
						if(sheetObj.SearchRows()!=0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!= amdt_seq ){
							ComShowCodeMessage("PRI00313");
						 	return;
						}		
						var idx=doRowChange2(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBINSERT);
		                if (idx < 0) {
		                    return false;
		                }
						if(amdt_seq == 0){	
							sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
							sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
							sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
							sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
							sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value,0);
							sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
							sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
							var note_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_seq");
							sheetObj.SetCellValue(idx, "note_seq",note_seq,0);
							sheetObj.SetCellValue(idx, "note_ctnt_seq",parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1,0);
							sheetObj.SetCellValue(idx, "note_tp_cd",formObj.note_tp_cd.value,0);
							sheetObj.SetCellValue(idx, "note_conv_mapg_id",getSYSGUID(),0);
							sheetObj.SelectCell(idx, "note_ctnt");
							sheetObj.SetCellBackColor(idx,"note_ctnt","#FFFFFF");
						}else{
							sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
							sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
							sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
							sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
							sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value,0);
							sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
							sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
							var note_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_seq");
							sheetObj.SetCellValue(idx, "note_seq",note_seq,0);
							sheetObj.SetCellValue(idx, "note_ctnt_seq",parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1,0);
							sheetObj.SetCellValue(idx, "note_tp_cd",formObj.note_tp_cd.value,0);
							sheetObj.SetCellValue(idx, "note_conv_mapg_id",getSYSGUID(),0);
							sheetObj.SelectCell(idx, "note_ctnt");
							sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
							sheetObj.SetCellBackColor(idx,"note_ctnt","#FFFFFF");
						}
						sheetObjects[2].RemoveAll();
						//MASTER color
						manageMasterColor(sheetObjects[0], sheetObjects[1]);
						//Conversion button control
						sheetObjects[2].SetEditable(1);
						buttonControlConv();
		    			//highlighting
					}
					/* CONVERSION - START */
					if (sheetObj.id == "sheet3") {
						
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
							sheetObj.SetCellValue(idx, "note_conv_tp_cd","P",0);//Proposal Special Note
							sheetObj.SetCellValue(idx, "note_conv_seq",parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1,0);
							sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
							//setting note_conv_flg 
							setNoteConvFlg(sheetObj);
							//in case of existing default value in code
							defaultColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
							//Setting Editable
							disableColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
						
						}
						
					}
					/* CONVERSION - END */
	  				break;
				case IBDELETE: // Delete
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}				
					var amdt_seq=formObj.amdt_seq.value;
					var eff_dt=formObj.eff_dt.value;
					var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}	
					chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					if (sheetObj.id == "sheet1") {
						if(amdt_seq=="0"){
							if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
								sheetObjects[1].RemoveAll();
								sheetObjects[2].RemoveAll();
							}
				        	//var delCnt=deleteRowCheck(sheetObj, "chk");
							var delCnt=deleteRowCheck(sheetObj, "chk", false, true);
							if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
								sheetObjects[1].RemoveAll();
								sheetObjects[2].RemoveAll();
							}
						} else {
							for(var i=0;i < chkArr.length;i++){
								//src_info_cd in MASTER is not "NW". it means that amended data exists
								if(sheetObj.GetCellValue(chkArr[i], "src_info_cd") != "NW") {
									sheetObj.SetCellValue(chkArr[i], "src_info_cd","AD",0);
									sheetObj.SetCellValue(chkArr[i], "prc_prog_sts_cd","I",0);
									sheetObj.SetCellValue(chkArr[i], "eff_dt",eff_dt,0);
									sheetObj.SetCellValue(chkArr[i], "chk","0",0);
									sheetObj.SetRowStatus(chkArr[i],"U");
									sheetObj.SetCellFont("FontStrike", chkArr[i], 1, chkArr[i], sheetObj.LastCol(), true);
									sheetObj.SetCellFont("FontColor", chkArr[i], 1, chkArr[i], sheetObj.LastCol(),"#FF0000");
								}
							}
							// Cancelling amended data
							sheetObjects[1].CheckAll("chk","1",0);
							var chkArrDtl=ComPriSheetCheckedRows(sheetObjects[1], "chk");
							for(var i=0; chkArrDtl != null && i<chkArrDtl.length;i++){
								if(sheetObjects[1].GetCellValue(Number(chkArrDtl[i]),"n1st_cmnc_amdt_seq") == amdt_seq && (sheetObjects[1].GetCellValue(Number(chkArrDtl[i]),"src_info_cd") == "AM" )){
									sheetObjects[1].SetCellValue(Number(chkArrDtl[i])-1, "temp_note_conv_mapg_id",sheetObjects[1].GetCellValue(Number(chkArrDtl[i]), "note_conv_mapg_id"),0);
									sheetObjects[1].SetCellValue(Number(chkArrDtl[i])-1, "bef_eff_dt",sheetObjects[1].GetCellValue(Number(chkArrDtl[i]), "bef_eff_dt"),0);
									sheetObjects[1].SetCellValue(Number(chkArrDtl[i])-1, "bef_exp_dt",sheetObjects[1].GetCellValue(Number(chkArrDtl[i]), "bef_exp_dt"),0);
			  						comSheetAmendCancelRow(sheetObjects[1],formObj,Number(chkArrDtl[i]),"M", "note_ctnt");
			  						sheetObjects[1].SetCellValue(Number(chkArrDtl[i])-1, "note_conv_mapg_id",sheetObjects[1].GetCellValue(Number(chkArrDtl[i])-1, "temp_note_conv_mapg_id"),0);
			  						sheetObjects[1].SetCellEditable(Number(chkArrDtl[i])-1, "chk",1);
			  					}
						    }
							//sheetObjects[1].CheckAll("chk","1",0);
							
							var chkArrDtl=ComPriSheetCheckedRows(sheetObjects[1], "chk");
							var sRow=0;
						    for(var i=0;chkArrDtl != null && i<chkArrDtl.length;i++){
						    	amendFlag=true;
						    	if(sheetObjects[1].GetCellValue(Number(chkArrDtl[i])+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
						    		//AMEND DELETE
									comSheetAmendRow(sheetObjects[1],formObj,Number(chkArrDtl[i])+sRow,"D","note_ctnt");
						    		sRow++;	
						    	} else if(sheetObjects[1].GetCellValue(Number(chkArrDtl[i])+sRow,"n1st_cmnc_amdt_seq")==amdt_seq && (sheetObjects[1].GetCellValue(Number(chkArrDtl[i])+sRow,"src_info_cd") == "AD" )) {
									sheetObjects[1].SetCellValue(Number(chkArrDtl[i])+Number(sRow), "chk","0",0);
								}
						    	amendFlag=false;
						    }
						    //deleteRowCheck(sheetObjects[1], "chk");
						    deleteRowCheck(sheetObjects[1], "chk", false, true);
						    //Selecting other rows automatically after deleting
						    if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
								sheetObjects[1].RemoveAll();
								sheetObjects[2].RemoveAll();
							}				
						    //var delCnt=deleteRowCheck(sheetObj, "chk");
				        	var delCnt=deleteRowCheck(sheetObj, "chk", false, true);			        	
				        	if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
								sheetObjects[1].RemoveAll();
								sheetObjects[2].RemoveAll();
							}
						}
						formObj.master_del_chk.value="Y";						
					} else if (sheetObj.id == "sheet2") {
						if(amdt_seq=="0"){
						    //Selecting other rows automatically after deleting
							if (sheetObj.id == "sheet2" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
								sheetObjects[2].RemoveAll();
							}
				        	//var delCnt=deleteRowCheck(sheetObj, "chk");
							var delCnt=deleteRowCheck(sheetObj, "chk", false, true);
				        	if (delCnt > 0 && sheetObj.id == "sheet2" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
								sheetObjects[2].RemoveAll();
							}
						} else {
							for(var i=0;i < chkArr.length;i++){
								if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq ||(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq && (sheetObj.GetCellValue(chkArr[i],"src_info_cd") =="AM" || sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AD"))){
									ComShowCodeMessage("PRI00313");
									return;
								}
							}
							var sRow=0;
							for(var i=0;i < chkArr.length;i++){
								if(sheetObj.GetCellValue(Number(chkArr[i])+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
									amendFlag=true;
									//AMEND DELETE
									comSheetAmendRow(sheetObj,formObj,Number(chkArr[i])+sRow,"D","note_ctnt");
						    		sRow++;	
						    		amendFlag=false;
								}
							}
							//Selecting other rows automatically after deleting
							if (sheetObj.id == "sheet2" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
								sheetObjects[2].RemoveAll();
							}
				        	//var delCnt=deleteRowCheck(sheetObj, "chk");
							var delCnt=deleteRowCheck(sheetObj, "chk", false, true);
				        	if (delCnt > 0 && sheetObj.id == "sheet2" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
								sheetObjects[2].RemoveAll();
							}
						}
						formObj.master_del_chk.value="N";
					}
					//Checking in case of deleting all rows of DETAIL
					if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
						if(ComShowCodeConfirm('PRI00020')){
			  				ComOpenWait(true);
			  				//Un-Checking checked data on MASTER
							sheetObjects[0].CheckAll("chk",0,0);
							sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "chk","1",0);
							if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
							//var delCnt=deleteRowCheck(sheetObjects[0], "chk");
							var delCnt=deleteRowCheck(sheetObjects[0], "chk", false, true);
							if (delCnt > 0 && sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) == "D") {
								sheetObjects[1].RemoveAll();
							}
						}
					}
					//Conversion Delete 
					manageConvButton (sAction);
					//MASTER color changing
					manageMasterColor(sheetObjects[0], sheetObjects[1]);
					break;
					
	  			case MODIFY01: // Accept All
		  			if(ComShowCodeConfirm("PRI01015")) {	  				
		  				var amdtSeq=formObj.amdt_seq.value;
		  				//Changing current sheet's status
		  				comChangeValue(sheetObj, "prc_prog_sts_cd", "A", "prc_prog_sts_cd|n1st_cmnc_amdt_seq", "I|"+amdtSeq);
		  				ComOpenWait(true);
		  				formObj.f_cmd.value=MULTI02;
		  				var sParam=FormQueryString(formObj);
		  				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_01GS.do", sParam);
		  				sheetObj.LoadSaveData(sXml);
					}
	  				break;
	  			case MODIFY02: // Cancel All
		  			if(ComShowCodeConfirm("PRI01010")) {
		  				var amdtSeq=formObj.amdt_seq.value;
		  				//Changing current sheet's status
		  				comChangeValue(sheetObj, "prc_prog_sts_cd", "I", "prc_prog_sts_cd|n1st_cmnc_amdt_seq", "A|"+amdtSeq);
		  				ComOpenWait(true);
		  				formObj.f_cmd.value=MULTI03;
		  				var sParam=FormQueryString(formObj);
		  				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_01GS.do", sParam);
		  				sheetObj.LoadSaveData(sXml);
					}
	  				break;			
	  			case MODIFY03: // Accept
		  			if(ComShowCodeConfirm("PRI00008")) {
		  				formObj.f_cmd.value=MULTI04;
		  				comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2003_01GS.do");
		  			}
	   				break;	
	  			case MODIFY04: // Accept Cancel
	  				if(ComShowCodeConfirm("PRI00009")) {	
	  					formObj.f_cmd.value=MULTI05;
		  				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2003_01GS.do");
	  				}
	  				break;			
	  			case COMMAND01: // Amend
	  				//It should amend after saving in case of modified conversion data
	  				if(sheetObjects[2].IsDataModified()){
	  					if (ComShowCodeConfirm("PRI00006")) {
	  	                    supressConfirm=true;
	  	                    var rslt=doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
	  	                    supressConfirm=false;
	  	                    if(!rslt) {
	  	                    	return false;
	  	                    }
	  	                } else {
	  	                	return false;
	  	                }
	  				}
	  				amendFlag=true;
	  				ComOpenWait(true);
	  				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
	  				if(chkArr.length > 0){
	  					if(chkArr.length > 1){					
	  						ComShowCodeMessage("PRI00310");
	  					}else{
	  						var trueYN=comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","note_ctnt");
	  						if(trueYN) {
		  						//Changing Master color
		  						manageMasterColor(sheetObjects[0], sheetObjects[1]);
		  						//Deleting Conversion
		  						manageConvButton (sAction);
	  						}
	  					}
	  				}else{
	  					var trueYN=comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M","note_ctnt");
	  					if(trueYN) {
							//Changing Master color
							manageMasterColor(sheetObjects[0], sheetObjects[1]);
							//Deleting Conversion
							manageConvButton (sAction);
	  					}
	  				}
	  				sheetObj.SelectCell(sheetObj.GetSelectRow(), "note_ctnt", false);
	  				amendFlag=false;
	  				break;			
	  			case COMMAND02: // Amend Cancel
	  				amendFlag=true;
	  				ComOpenWait(true);
	  				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
	  				if(chkArr.length > 0){
	  					if(chkArr.length > 1){					
	  						ComShowCodeMessage("PRI00310");
	  					}else{
	  						var cStatus=sheetObj.GetRowStatus(sheetObj.GetSelectRow()-1);
							sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "temp_note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "note_conv_mapg_id"),0);
							sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "bef_eff_dt",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bef_eff_dt"),0);
							sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "bef_exp_dt",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bef_exp_dt"),0);
	  						sheetObj.SetRowStatus(sheetObj.GetSelectRow()-1,cStatus);
	  						//2. AMEND CANCEL 
	  						var trueYN=comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "note_ctnt");
	  						if(trueYN) {
		  						//Changing Master color
		  						manageMasterColor(sheetObjects[0], sheetObjects[1]);
		  						//3. Rollback of CONTENT's MAPPING ID
		  						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "temp_note_conv_mapg_id"),0);
		  						//4. Conversion Delete & update
		  						manageConvButton (sAction);
								sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"U");
	  						}
	  					}
	  				}else{ 
	  					var cStatus=sheetObj.GetRowStatus(sheetObj.GetSelectRow()-1);
						sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "temp_note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "note_conv_mapg_id"),0);
						sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "bef_eff_dt",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bef_eff_dt"),0);
						sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "bef_exp_dt",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bef_exp_dt"),0);
  						sheetObj.SetRowStatus(sheetObj.GetSelectRow()-1,cStatus);
						var trueYN=comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "note_ctnt");
	  					if(trueYN) {
							//Changing Master color
							manageMasterColor(sheetObjects[0], sheetObjects[1]);						
							//Rollback of CONTENT's MAPPING ID				
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), "note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "temp_note_conv_mapg_id"),0);
							//Conversion Delete & update
							manageConvButton (sAction);
							sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"U");
	  					}
	  				}
	  				amendFlag=false;
	  				break;	
	  			case COMMAND11: //COPY
					var iCheckRow=sheetObj.FindCheckedRow("chk");
					if((ComShowCodeConfirm("PRI00012")) ) {			
						if(iCheckRow != "") {
							comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
						}
		  				ComOpenWait(true);
						formObj.f_cmd.value=MULTI12;
						sheetObj.DoSave("ESM_PRI_2003_01GS.do", FormQueryString(formObj), -1, false);
						//sheetObj.CheckAll2("chk") = "0";
					}
					break;
	  			case COMMAND12: //PASTE			
					if((ComShowCodeConfirm("PRI00016")) ) {
		  				ComOpenWait(true);
						// NOTE CONVERSION RULE
						var sCd=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Code");
						var sNm=sheetObj.GetComboInfo(0,"chg_rule_def_cd","Text");
						formObj.f_cmd.value=SEARCH14;
						var sXml=sheetObj.GetSearchData("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
						var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd"); 
				      	if(arrData != null && arrData.length > 0) {
				      		//Calling InitDataCombo  after adding in combolist
				      		for(var i=0; i<arrData.length; i++){						
								if (sCd.indexOf(arrData[i][0]) < 0) {
									sCd += "|" + arrData[i][0];
									sNm += "|" + arrData[i][0];
								}
							}					
							sheetObj.SetColProperty(2, {ComboText:sNm, ComboCode: sCd} );
				      		sheetObj.LoadSearchData(sXml,{Append:1 , Sync:0} );
				      		//Setting default after loading sheet
				      		var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
				      		var arrRow=ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
				      		if(arrRow != null && arrRow.length > 0) {  
				      			for(var i=0; i<arrRow.length; i++) {
					      			sheetObj.SetRowStatus(arrRow[i],"I");
					      			sheetObj.SetCellValue(arrRow[i], "note_conv_seq",maxSeq + i,0);
					      			sheetObj.SetCellValue(arrRow[i], "note_conv_mapg_id",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"note_conv_mapg_id"),0);
					      			sheetObj.SetCellValue(arrRow[i], "svc_scp_cd",formObj.svc_scp_cd.value,0);
					      			sheetObj.SetCellValue(arrRow[i], "prop_no",formObj.prop_no.value,0);
									sheetObj.SetCellValue(arrRow[i], "amdt_seq",formObj.amdt_seq.value,0);
					      			sheetObj.SetCellValue(arrRow[i], "note_conv_tp_cd","P",0);//Proposal Special Note
				      			}
				      		}
				      	} else {
				      		ComShowCodeMessage("PRI00328");
				      	}
					}
					break;
	  			case IBCOPYROW:
					copySheetData(sheetObj);
					break;
	  			case COMMAND13: // Delete
					var iCheckRow=sheetObj.FindCheckedRow("chk");
					if(iCheckRow == ""){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}
					iCheckRow=sheetObj.FindCheckedRow("chk");
					if(iCheckRow != "") {
						deleteRowCheck(sheetObj, "chk");
					}
					//setting note_conv_flg 
					setNoteConvFlg(sheetObj);
					break;
	  		}
  		}catch(e){
  			if (e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
  			} else {
  				ComShowMessage(e.message);
  			}
  		}finally {
  			 ComOpenWait(false);
  		}
  	}
    /**
     * 1. Managing mapping ID when AMEND, AMEND CANCEL, DELETE <br>
     * 2. Controlling CONVERSION button.<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {int} sAction Mandatory Button Action
     * @return N/A
     * @author 
     * @version 2009.06.22
     */ 
  	 function manageConvButton (sAction) {
  		var sheetObj=sheetObjects[1];
  		var formObj=document.form;
		var amdtSeq=formObj.amdt_seq.value;
		var effDt=formObj.eff_dt.value;
		var expDt=formObj.exp_dt.value;
		var ibFlag=sheetObj.GetRowStatus(sheetObj.GetSelectRow());
		//sAction
		formObj.amend_func.value=sAction;
		if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") == amdtSeq) {
			if(sAction == COMMAND01 && amdtSeq == sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
				var cStatus=sheetObj.GetRowStatus(sheetObj.GetSelectRow()-1);
				sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow()-1, "prev_note_conv_mapg_id"),0);
				sheetObj.SetRowStatus(sheetObj.GetSelectRow()-1,cStatus);
				if(getValidRowCount(sheetObjects[2]) > 0) {
					for(var i=sheetObjects[2].HeaderRows(); i <= sheetObjects[2].LastRow(); i++) {
						sheetObjects[2].SetRowEditable(i,1);
						//Changing EFF_DT, EXP_DT when requesting AMEND
						//1. conversion.eff_dt < amend.eff_dt -> amend.eff_dt change
						//2. conversion.eff_dt > amend.eff_dt -> as it is
						//3. conversion.eff_dt > amend.exp_dt -> deleting
						//4. conversion.exp_dt < amend.eff_dt -> deleting
						if(sheetObjects[2].GetCellValue(i, "eff_dt") < effDt) {
							sheetObjects[2].SetCellValue(i, "eff_dt",effDt,0);
						} 
						if(sheetObjects[2].GetCellValue(i, "exp_dt") > expDt) {
							sheetObjects[2].SetCellValue(i, "exp_dt",expDt,0);
						}
						if(sheetObjects[2].GetCellValue(i, "eff_dt") > expDt) {
							sheetObjects[2].SetRowHidden(i,1);
							sheetObjects[2].SetRowStatus(i,"D");
						}
						if(sheetObjects[2].GetCellValue(i, "exp_dt") < effDt) {
							sheetObjects[2].SetRowHidden(i,1);
							sheetObjects[2].SetRowStatus(i,"D");
						}
						disableColumnValidation(sheetObjects[2], i, 2, sheetObjects[2].GetCellValue(i,"chg_rule_def_cd"));
				 		setStateColor(sheetObjects[2], i);
					}
				}
				ComBtnEnable("btn_copy");
				ComBtnEnable("btn_paste");
				ComBtnEnable("btn_rowadd3");
				ComBtnEnable("btn_rowcopy");
				ComBtnEnable("btn_delete3");
				ComBtnEnable("btn_autoword");
			} else if(sAction == COMMAND02 && amdtSeq != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
				sheetObjects[2].RemoveAll();
	 			// NOTE CONVERSION RULE
				var sCd=sheetObjects[2].GetComboInfo(0,"chg_rule_def_cd","Code");
				var sNm=sheetObjects[2].GetComboInfo(0,"chg_rule_def_cd","Text");
				//Getting previous SEQ's Conversion
	 			formObj.f_cmd.value=SEARCH13;
	 			//previous MAPPING ID
	 			formObj.note_conv_mapg_id.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prev_note_conv_mapg_id");
	 			var sXml=sheetObjects[2].GetSearchData("ESM_PRI_2003_01GS.do", FormQueryString(formObj));
				var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd");			
				if (arrData != null && arrData.length > 0) {
					for(var i=0; i<arrData.length; i++){						
						if (sCd.indexOf(arrData[i][0]) < 0) {
							sCd += "|" + arrData[i][0];
							sNm += "|" + arrData[i][0];
						}
					}					
					sheetObjects[2].SetColProperty(2, {ComboText:sNm, ComboCode: sCd} );
				}			
				sheetObjects[2].LoadSearchData(sXml,{Sync:0} );
				//EFF_DT before amending CONTENT
				var oldEffDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"eff_dt");
				//EXP_DT before amending CONTENT
				var oldExpDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"exp_dt");
				//previous SEQ's EFF_DT
				var befEffDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"bef_eff_dt");
				//previous SEQ's EXP_DT
				var befExpDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"bef_exp_dt");
				//Setting to delete current seq's conversion
				formObj.note_ctnt_seq.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "note_ctnt_seq");
				if(getValidRowCount(sheetObjects[2]) > 0) {
					for(var i=sheetObjects[2].HeaderRows(); i <= sheetObjects[2].LastRow(); i++) {
						sheetObjects[2].SetRowEditable(i,0);
						sheetObjects[2].SetRowStatus(i,"I");
						//Changing MAPPING ID to current
						//Chaning SEQ to current
						//Chaning EFF_DT, EXP_DT to current
						sheetObjects[2].SetCellValue(i, "note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "temp_note_conv_mapg_id"),0);
						sheetObjects[2].SetCellValue(i, "amdt_seq",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq"),0);
						if(sheetObjects[2].GetCellValue(i, "eff_dt") == befEffDt) {
							sheetObjects[2].SetCellValue(i, "eff_dt",oldEffDt,0);
						}
						if(sheetObjects[2].GetCellValue(i, "exp_dt") == befExpDt) {
							sheetObjects[2].SetCellValue(i, "exp_dt",oldExpDt,0);
						}
						if(sheetObjects[2].GetCellValue(i, "eff_dt") < oldEffDt) {
							sheetObjects[2].SetCellValue(i, "eff_dt",oldEffDt,0);
						} 
						if(sheetObjects[2].GetCellValue(i, "exp_dt") > oldExpDt) {
							sheetObjects[2].SetCellValue(i, "exp_dt",oldExpDt,0);
						}
				 		setStateColor(sheetObjects[2], i);
				 		//setChargeRuleColor(sheetObjects[2], i);
					}
				}
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd3");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete3");
				ComBtnDisable("btn_autoword");
			}  else if(sAction == IBDELETE && amdtSeq == sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq") && (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "src_info_cd") == "AD")) {
				var cStatus=sheetObj.GetRowStatus(sheetObj.GetSelectRow()-1);
				sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow()-1, "prev_note_conv_mapg_id"),0);
				sheetObj.SetRowStatus(sheetObj.GetSelectRow()-1,cStatus);
				sheetObjects[2].RemoveAll();
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd3");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete3");
				ComBtnDisable("btn_autoword");
			} else if(sAction == IBDELETE && amdtSeq != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
				//Row-1 Data will be selected if deleting added content data in current seq
				for(var i = sheetObjects[2].HeaderRows(); getValidRowCount(sheetObjects[2]) > 0 && i <= sheetObjects[2].LastRow(); i++) {
					sheetObjects[2].SetRowEditable(i,0);
			 		setStateColor(sheetObjects[2], i);
			 		//setChargeRuleColor(sheetObjects[2], i);
				}
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd3");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete3");
				ComBtnDisable("btn_autoword");
			} else if(ibFlag == "D" ) {
				sheetObjects[2].RemoveAll();
			}
		}
  	 }
     /**
      * Calling function in case of OnSelectCell event <br>
      * Highlighting selected row of sheet <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
      * @param {int} Row Mandatory Onclick ,Cell's Row Index
      * @param {int} Col Mandatory Onclick ,Cell's Column Index
      * @param {string} Value Mandatory ,Cell's Value
      * @return N/A
      * @author 
      * @version 2009.05.19
      */		
  	 function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if (OldRow != NewRow) {
			//하이라이트 처리
			//changeSelectBackColor4Master(sheetObj, document.form);
		}
		doRowChange1(OldRow, NewRow, OldCol, NewCol);
	}
     /**
      * Calling function in case of OnSelectCell event <br>
      * Highlighting selected row of sheet <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
      * @param {int} Row Mandatory Onclick ,Cell's Row Index
      * @param {int} Col Mandatory Onclick ,Cell's Column Index
      * @param {string} Value Mandatory ,Cell's Value
      * @return N/A
      * @author 
      * @version 2009.05.19
      */	
      function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if (OldRow != NewRow) {
			//changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    	doRowChange2(OldRow, NewRow, OldCol, NewCol);
  	}
  /**
   * Calling function in case of OnBeforeCheck event <br>
   * Controlling all check control of sheet1<br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
   * @param {int} Row Mandatory Onclick ,Cell's Row Index
   * @param {int} Col Mandatory Onclick ,Cell's Column Index
   * @return N/A
   * @author 
   * @version 2009.05.19
   */ 	
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 3), 0, Row, Col);
		}
	}
   /**
    * Calling function in case of OnBeforeCheck event <br>
    * Controlling all check control of sheet2 <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.19
    */	
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 3), 1, Row, Col);
		}
	}
    /**
     * Calling function in case of OnBeforeCheck event <br>
     * Controlling all check control of sheet2 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
    * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.05.19
     */	
	function sheet3_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 3), 2, Row, Col);
		}
	}
    /**
     * Calling function in case of OnClick event <br>
     * Displaying memo pad when saving address<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value Mandatory
     * @return N/A
     * @author 
     * @version 2009.06.18
     */
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
 	   //MemoPad editable : true
 	    var formObj=document.form;
 	    var colname=sheetObj.ColSaveName(Col);
 	    var amdtSeq=formObj.amdt_seq.value;
 	    var propStsCd=formObj.prop_sts_cd.value;
      	switch(colname)
      	{
      		case "note_ctnt":
	    		sheetObj.SetCellEditable(Row,"note_ctnt",0);
	    		if(propStsCd == "I"){
		    		if (amdtSeq == 0){
		    			sheetObj.SetCellBackColor(Row,"note_ctnt","#FFFFFF");
		    			readOnly=false; 	    			
		    		}
		    		else if(sheetObj.GetCellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq){
		    			if (sheetObj.GetCellValue(Row , "src_info_cd") != "AD"){
							if (propStsCd =="I"){
								readOnly=false;
								sheetObj.SetCellBackColor(Row,"note_ctnt","#FFFFFF");
							}else{
								readOnly=true;
								sheetObj.SetCellBackColor(Row,"note_ctnt",-1);
							}						
						}else{// Prohibiting from modifying in case of src_info_cd=AD
							readOnly=true;
							sheetObj.SetCellBackColor(Row,"note_ctnt",-1);
						}
					}else{
						readOnly=true;
						sheetObj.SetCellBackColor(Row,"note_ctnt",-1);
					}
	    		} else {
	    			readOnly=true;
	    			sheetObj.SetCellBackColor(Row,"note_ctnt",-1);
	    		}
	    		//ComShowMemoPad(sheetObj, Row, Col, readOnly, 550);
	    		var memoColWidth = 	sheetObj.GetColWidth("note_ctnt") +
						    		sheetObj.GetColWidth("eff_dt") +
						    		sheetObj.GetColWidth("exp_dt") +
						    		sheetObj.GetColWidth("src_info_cd") +
						    		sheetObj.GetColWidth("src_info_cd");
	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 15);
	    		break;      	
      	}
	}  
    /**
 	     * Calling function in case of OnSaveEnd Event <br>
 	     * Displaying Save confirmation message in case of sucessful saving <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory from server
     * @return N/A
     * @author 
     * @version 2009.06.22
     */ 		
   	function sheet2_OnSaveEnd(sheetObj, Code, Msg)  {
    	 var formObj=document.form;
    	 parent.comUpdateProposalStatusSummary("32", formObj.svc_scp_cd.value);
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
      * @param {int} sAction Mandatory ,Process flag constant variable
      * @returns bool <br>
      *          true  : Valid<br>
      *          false : Invalid
      * @author 
      * @version 2009.04.17
      */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: 
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()|| sheetObjects[2].IsDataModified()) {
				ComShowCodeMessage("PRI01057");
				return false;
			}
			break;
		case IBSEARCHAPPEND: 
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		case IBSAVE: 
			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()&& !sheetObjects[2].IsDataModified()) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
			if (sheetObjects[0].IsDataModified()&& ComTrim(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_tit_nm") == "")) {
				ComShowCodeMessage("PRI00316", "Title");
				return false;
			}
			//if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
			if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetRowHidden(1)) != "D"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
					ComShowCodeMessage("PRI00319", "Special Note");
				return false;
			}			
			if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[2].IsDataModified()&& sheetObjects[2].GetSaveString() == "") {
				return false;
			}
			var rowM=ComPriAmendDupCheck(sheetObjects[0], "note_tit_nm", formObj.amdt_seq.value);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
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
			/* CONVERSION - START */
	     	var amdtSeq=formObj.amdt_seq.value;
	     	if(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "amdt_seq")  == amdtSeq && sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq")== amdtSeq) {
				if(!checkDuration(sheetObjects[2])) {
	   				return false;
	   			}
			}
   			for(var i = sheetObjects[2].HeaderRows(); getValidRowCount(sheetObjects[2]) > 0 && i <= sheetObjects[2].LastRow(); i++) {
   				if(sheetObjects[2].GetRowStatus(i) == "D") {
	  	 			continue;
	  	 		}
   				if(!checkMandatoryValidation(sheetObjects[2], i)) {
 					return false;
 				}
   			}
   			if (sheetObjects[2].IsDataModified()) {
				for(var i=sheetObjects[2].HeaderRows(); i <= sheetObjects[2].LastRow(); i++) {
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
				//duplication check
				if(!validateDupCheck(sheetObjects[2])) {
					 return false;
				}
			}
   			/* CONVERSION - END */
			break;
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} 
			if (sheetObj.id == "sheet2" && getValidRowCount(sheetObjects[0]) == 0) {
				ComShowCodeMessage("PRI01004");
				return false;					
			}
			if (sheetObj.id == "sheet3" && getValidRowCount(sheetObjects[1]) == 0) {
				ComShowCodeMessage("PRI01004");
				return false;					
			}
			break;
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} 
			if (getValidRowCount(sheetObj) == 0) {
				return false;					
			}
			break;
		case MODIFY01: // Accept All
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;
  		case MODIFY02: // Cancel
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;	
		case MODIFY03: // Accept
			// selected row list
			var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
				}
			}
			break;
		case MODIFY04: // Accept cancel
			// selected row list
			var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "I") {
					ComShowCodeMessage("PRI01038");
					return false;
				}
			}
			break;	
  		case COMMAND01: // Amend	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
  		case COMMAND02: // Amend Cancel	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		}
		 return true;
	}
    /**
    * handling process for input validation <br>
    * <br><b>Example :</b>
    * <pre>
    *     if (validateFormConversion(sheetObj,document.form,IBSAVE)) {
    *     }
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj Mandatory html form object
    * @param {int} sAction Mandatory ,Process flag constant variable
    * @returns bool <br>
      *          true  : Valid<br>
      *          false : Invalid
    * @author 
    * @version 2009.04.17
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
	   		case IBINSERT:
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
	 		case COMMAND13:
				if (getValidRowCount(sheetObj) == 0) {
					return false;					
				}
	 			break;
 		}
 		return true;
 	}
  	/**
     * function to check SHEET ROW's duplication <br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * validateDupCheck(sheetObj)
  	 * </pre>
  	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
  	 * @return boolean
  	 * @author 
  	 * @version 2009.05.20
  	 */ 
  	function validateDupCheck(sheetObj) {
  		var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd" +
			 		"|bkg_imdg_clss_cd|bkg_cmdt_def_cd|bkg_por_def_cd|bkg_pol_def_cd|bkg_pod_def_cd|bkg_del_def_cd" +
			 		"|bkg_slan_cd|bkg_cnl_tz_cd|bkg_vvd_cd|bkg_soc_flg|bkg_dir_call_flg|bkg_ts_port_def_cd|bkg_min_cgo_wgt|bkg_max_cgo_wgt|bkg_hngr_bar_tp_cd|bkg_esvc_tp_cd", false, true);
  		if (rowM != "") {
  			var rowDup=rowM.replace("|", ","); 			
 			//all duplicated row
 			var rowArr=rowDup.split(",");
  			var dupValue="";
  			var temValue="";						
  			var firstEffDt="";
  			var firstExpDt="";						
  			var SecondEffDt="";
  			var SecondExpDt="";
 			var hrows=sheetObj.HeaderRows();
  			for(var i=0; i<rowArr.length; i++) {
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
  				for(var j=0; j<rowArr.length; j++) {
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
  					if(i != j) {
	  					if(dupValue == temValue) {
							firstEffDt=sheetObj.GetCellValue(rowArr[i], "eff_dt");
							firstExpDt=sheetObj.GetCellValue(rowArr[i], "exp_dt");
							SecondEffDt=sheetObj.GetCellValue(rowArr[j], "eff_dt");
							SecondExpDt=sheetObj.GetCellValue(rowArr[j], "exp_dt");
	  						if(firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
	  							ComShowCodeMessage("PRI00303", "Sheet3", Number(rowArr[j])+1-hrows);
	  						     return false;
	  			 			}
	  			 			if(firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
	  			 				ComShowCodeMessage("PRI00303", "Sheet3", Number(rowArr[j])+1-hrows);
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
     * Calling function in case of clicking tabl on parent screen <br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo Mandatory prop_no 
     * @param {string} sAmdtSeq Mandatory amdt_seq 
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sPreAmdtSeq Mandatory pre_amdt_seq 
     * @param {string} sPropStsCd Mandatory pro_sts_cd 
     * @param {string} sEffDt Mandatory eff_dt 
     * @param {string} sExpDt Mandatory exp_dt 
     * @param {string} sPreExpDt Mandatory pre_exp_dt 
     * @return N/A
     * @author 
     * @version 2009.05.21
     */ 
	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg) {
		var formObject=document.form;
		if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
			formObject.prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
			formObject.prop_no.value=sPropNo;
			formObject.amdt_seq.value=sAmdtSeq;
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.pre_amdt_seq.value=sPreAmdtSeq; 
			formObject.prop_sts_cd.value=sPropStsCd; 
			formObject.eff_dt.value=sEffDt;
			formObject.exp_dt.value=sExpDt;			
			formObject.pre_exp_dt.value=sPreExpDt ;
			formObject.req_usr_flg.value=sIsReqUsr ;
			formObject.apro_usr_flg.value=sIsAproUsr ;	
//			formObject.dur_dup_flg.value = sDurDupFlg ;
			formObject.dur_dup_flg.value="Y" ;
			buttonControl();
	        doActionIBSheet(sheetObjects[2],document.form,IBCLEAR);
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
//			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH);
//			doActionIBSheet(sheetObjects[2], document.form,IBSEARCH);
		}
	}
	/**
     * Clearing tab screen's controls<br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.05.20
     */ 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		formObject.pre_amdt_seq.value="";
		formObject.prop_sts_cd.value="";
		formObject.eff_dt.value="";
		formObject.exp_dt.value="";			
		formObject.pre_exp_dt.value="";
		formObject.req_usr_flg.value="";
		formObject.apro_usr_flg.value="";
		formObject.dur_dup_flg.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		buttonControl("CLEAR");
	}
	var enableFlag=true;
	/**
     * calling funciton from main <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from main screen
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		sheetObjects[1].SetEditable(flag);
	}
    /**
    * Function to change color according to detail's source code<br>
    * 
    * <br><b>Example :</b>
    * <pre>
    * manageMasterColor(sheetM, sheetD);
    * </pre>
    * @param {object} IBSheet  
    * @param {object} IBSheet
    * @return N/A
    * @author 
    * @version 2009.06.10
    */ 	
    function manageMasterColor(sheetM, sheetD) {
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetD);
    	var formObj=document.form;
    	var amdt_seq=formObj.amdt_seq.value;
		//AMEND 
		var amend_check=false;
		//ALL AMEND DELETE
		var amend_delete_check=false;
		try {
  			if(row_count > 0){
  				amend_delete_check=true;
	  			for(var i=1 ; i <= row_count; i++){
	  				if(sheetD.GetCellValue(i,"amdt_seq") == amdt_seq && amdt_seq != "0") {
	  					if(sheetD.GetCellValue(i,"src_info_cd") !="AD") {
  							amend_delete_check=false;
	  	  				}
	  					if(sheetD.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdt_seq) {
	  	  					amend_check=true;
	  	  				}
  					}
	  			}
	  			if(amdt_seq == "0"){
	  				amend_delete_check=false;
	  			}
	  			if(amend_delete_check) {
	  				sheetM.SetCellFont("FontStrike", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(), true);
	  				sheetM.SetCellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(),"#FF0000");
	  			} else if(amend_check){
	  				sheetM.SetCellFont("FontStrike", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(), false);
	  				sheetM.SetCellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(),"#FF0000");
	  			} else {
	  				sheetM.SetCellFont("FontStrike", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(), false);
	  				sheetM.SetCellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(),"#000000");
	  			}
  			}
		}catch(e) {}
	} 
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj=document.form;
		var propStsCd=formObj.prop_sts_cd.value;
		formObj.master_del_chk.value="N";
		formObj.amend_func.value="";
		for(var i=1; i<=sheetObj.RowCount(); i++ ) {
			if(sheetObj.GetCellValue(i,"amdt_seq") > 0) {
				if(sheetObj.GetCellValue(i,"src_info_cd") == 'AD') {
					sheetObj.SetCellFont("FontStrike", i, "chk", i, sheetObj.LastCol(),1);
					sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
					//sheetObj.RowEditable(i) = false;
				} else if(sheetObj.GetCellValue(i,"src_info_cd") == 'AM' || sheetObj.GetCellValue(i,"src_info_cd") == 'NW') {
					sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
				}					
			}				
			if(propStsCd != "I") {
				sheetObj.SetCellEditable(i,"note_tit_nm",0);
			}
		}
		
		
	}
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */ 
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		 var formObj=document.form;
		 var amdtSeq=formObj.amdt_seq.value;	     
		 manageGetCellEditable(sheetObj);
		 if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != amdtSeq){
			 sheetObj.SelectCell(sheetObj.GetSelectRow()+1, sheetObj.GetSelectCol());
		 }
		 
	}
 	/**
 	 * Calling Function in case of OnSearchEnd event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 	 * @param {string} ErrMsg Mandatory ,message from server
 	 * @return N/A
 	 * @author 
 	 * @version 2009.05.20
 	 */ 
 	function sheet3_OnSearchEnd(sheetObj, errMsg){
 		if(errMsg == "") {
	 		var formObj=document.form;
	     	var amdtSeq=formObj.amdt_seq.value;
	     	var propStsCd=formObj.prop_sts_cd.value;
	     	var n1stCmncAmdtSeq=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq");
	     	for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	     		if(propStsCd == "I" && n1stCmncAmdtSeq == amdtSeq ) {
	     			disableColumnValidation(sheetObj, i, 2, sheetObj.GetCellValue(i,"chg_rule_def_cd"));
	     		} else {
	     			sheetObj.SetRowEditable(i,0);
	     		}
		 		setStateColor(sheetObj, i);
	 		}
			buttonControlConv();
			
			
 		}
 	}
   /**
    * Calling Function in case of OnChange event  <br>
    * showing Validation and description in case of selecting Multi ComboBox<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory ,Cell's Value
    * @return N/A
    * @author 
    * @version 2009.06.25
    */  
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
    	var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		switch(colName)
    	{
			case "chg_rule_def_cd":		
				if (Value != null && Value != "" && Value.length == 3) {
					defaultColumnValidation(sheetObj, Row, Col, Value);
					disableColumnValidation(sheetObj, Row, Col, Value);
					var sCode=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
					var sText=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
					//-----------------------
					//2015.06.09
					chargeRuleCdComboText = sText;
					chargeRuleCdComboValue = sCode;
					//-----------------------
					if (sCode.indexOf(Value) < 0) {
						formObj.f_cmd.value=COMMAND09;
						sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
						var arrData=ComPriXml2Array(sXml, "cd|nm");
						if (arrData != null && arrData.length > 0) {
							sCode += "|" + Value;
							sText += "|" + Value;
							sheetObj.SetColProperty("chg_rule_def_cd", {ComboText:sText, ComboCode: sCode} );
							ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
						} else {
							sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
						}
					}
					insertChargeRuleType(sheetObj, Row);
				} else {
					sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
				}
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
						//sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd")="";
						sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
						//sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd")="";
						sheetObj.SetCellValue(Row,"bkg_cmdt_tp_cd","",0);
						sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
					}
				} else if (Value.length == 6) {
	    			formObj.f_cmd.value=SEARCH08;
	    			formObj.cd.value=ComLpad(Value, 6, "0");
	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 					if (arrData[1] != "") {
 						sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd",Value,0);
						sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","C",0);
 					}else{
	  					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
	  					sheetObj.SetCellValue(Row, "bkg_cmdt_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"bkg_cmdt_def_cd");
 					}
				} else {
					//sheetObj.Cellvalue2(Row,"bkg_cmdt_def_cd")="";
					sheetObj.SetCellValue(Row,"bkg_cmdt_def_cd","",0);
					//sheetObj.Cellvalue2(Row,"bkg_cmdt_tp_cd")="";
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
 	    			} else {
 	    				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 	    				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
 						sheetObj.SetCellEditable(Row, "curr_cd",0);
 						sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 	    				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
 	    				sheetObj.SetCellValue(Row, "curr_cd","",0);
 	    				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 						sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
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
						//Diable "direct call" in case of existing data in T/S PORT
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
			case "bkg_yd_cd":
				checkTerminalCode(sheetObj, Row, Value);
	    		break;
    	}
	}
	 /**
     * Calling funciton in case of OnClick event <br>
     * Calling calendar DIV. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index
     * @param {str} Value Mandatory 
     * @return N/A
     * @author 
     * @version 2009.06.18
     */
     function sheet3_OnPopupClick(sheetObj, Row, Col, Value) {
 	    var colname=sheetObj.ColSaveName(Col);
 	    var formObj=document.form;
 	    var pinkColor="#FFC0CB";
      	switch(colname)
      	{
  	    	case "bkg_cmdt_def_cd":
  	    		var sUrl="/opuscntr/ESM_PRI_4027.do?"
  	   	    		sUrl += "commodity_cmd=CG";
  	   	    		sUrl += "&grp_cd="+PRI_RP_SCP;
  	   	    		sUrl += "&prop_no="+formObj.prop_no.value;
  	   	    		sUrl += "&amdt_seq="+formObj.amdt_seq.value;
  	   	    		sUrl += "&svc_scp_cd="+formObj.svc_scp_cd.value;
  	   	    	ComOpenPopup(sUrl, 700, 345, "findBkgCmdtDefCd", "1,0", true);
  	  			break;
  	    	case "bkg_por_def_cd":	
  	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";
	  			ComOpenPopup(sUrl, 700, 325, "findBkgPorDefCd", "1,0", true);
  				break;
  	    	case "bkg_pol_def_cd":
	  			var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";
	  			ComOpenPopup(sUrl, 700, 325, "findBkgPolDefCd", "1,0", true);
  				break;
  	    	case "bkg_pod_def_cd":	
  	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";
	  			ComOpenPopup(sUrl, 700, 325, "findBkgPodDefCd", "1,0", true);
  				break;
  	    	case "bkg_del_def_cd":	
  	    		var sUrl="/opuscntr/ESM_PRI_4026.do?" + FormQueryString(document.form);
	  			sUrl += "&group_cmd=" + PRI_RP_SCP;
	  			sUrl += "&location_cmd=LGTCR";
	  			ComOpenPopup(sUrl, 700, 340, "findBkgDelDefCd", "1,0", true);
  				break;
  	    	case "bkg_ts_port_def_cd":	
  				var sUrl="/opuscntr/ESM_PRI_4026.do?";
  				var sParam="&location_cmd=L";
  				ComOpenPopup(sUrl, 730, 360, "findBkgTsPortDefCd", "1,0", true);
  				break;	
  	    	case "bkg_slan_cd":	
  				var sUrl="/opuscntr/ESM_PRI_4012.do?" + FormQueryString(document.form);
  				ComOpenPopup(sUrl, 480, 380, "findBkgSlanCd", "1,0", true);
  				break;		
  	    	case "bkg_vvd_cd":	
  				var sUrl="/opuscntr/ESM_PRI_4013.do?" + FormQueryString(document.form);
  				ComOpenPopup(sUrl, 480, 380, "findBkgVvdCd", "1,0", true);
  				break;
  	    	case "bkg_yd_cd":
  	    		var bkgYdCd=sheetObj.GetCellValue(Row, Col);
  				var display='0,0,1,1,1,1,1,1,1,1,1,1';
  				var param='?mode=yard&node_cd='+bkgYdCd;
  				ComPriOpenPopup('/opuscntr/COM_ENS_061.do' + param, 780, 530, 'callBackTerminalCode', display, true);
  				break;
      	}    	 
     } 
     
     function findBkgCmdtDefCd(rtnVal) {    	 
		if (rtnVal != null){			
			sheet3.SetCellValue(sheet3.GetSelectRow(), sheet3.GetSelectCol(),rtnVal.cd,0);
			sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_cmdt_tp_cd",rtnVal.tp,0);
		}
     }
     
     function findBkgPorDefCd(rtnVal){    	 
		if (rtnVal != null){			
			sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_por_def_cd",rtnVal.cd,0);
			sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_por_tp_cd",rtnVal.tp,0);
			if(rtnVal.tp == "T"){  				
				sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_por_cnt_cd",rtnVal.cnt_cd,0);
				sheet3.SetCellBackColor(sheet3.GetSelectRow(),"bkg_por_def_cd",pinkColor);
			} else {				
				sheet3.SetCellBackColor(sheet3.GetSelectRow(),"bkg_por_def_cd",0);
			}
		}
     }
     
     function findBkgPolDefCd(rtnVal) {
		if (rtnVal != null){			
			sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_pol_def_cd",rtnVal.cd,0);
			sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_pol_tp_cd",rtnVal.tp,0);
			//Setting PINK in BG in case of State 
			if(rtnVal.tp == "T"){  				
				sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_pol_cnt_cd",rtnVal.cnt_cd,0);
				sheet3.SetCellBackColor(sheet3.GetSelectRow(),"bkg_pol_def_cd",pinkColor);
			} else {				
				sheet3.SetCellBackColor(sheet3.GetSelectRow(),"bkg_pol_def_cd",0);
			}
		}
     }
     
     function findBkgPodDefCd(rtnVal) {
		if (rtnVal != null){				
			sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_pod_def_cd",rtnVal.cd,0);
			sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_pod_tp_cd",rtnVal.tp,0);
			//Setting PINK in BG in case of State 
			if(rtnVal.tp == "T"){	  				
				sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_pod_cnt_cd",rtnVal.cnt_cd,0);
				sheet3.SetCellBackColor(sheet3.GetSelectRow(),"bkg_pod_def_cd",pinkColor);
			} else {
				sheet3.SetCellBackColor(sheet3.GetSelectRow(),"bkg_pod_def_cd",0);
			}
		}
     }
     
     function findBkgDelDefCd(rtnVal) {		 
		if (rtnVal != null){				
			sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_del_def_cd",rtnVal.cd,0);
			sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_del_tp_cd",rtnVal.tp,0);
			//Setting PINK in BG in case of State 
			if(rtnVal.tp == "T"){	  				
				sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_del_cnt_cd",rtnVal.cnt_cd,0);
				sheet3.SetCellBackColor(sheet3.GetSelectRow(),"bkg_del_def_cd",pinkColor);
			} else {					
				sheet3.SetCellBackColor(sheet3.GetSelectRow(),"bkg_del_def_cd",0);
			}
			
		}
     }
          
     function findBkgTsPortDefCd(rtnVal){
    	 if (rtnVal != null){
    		 sheet3.SetCellValue(sheet3.GetSelectRow(), sheet3.GetSelectCol(),rtnVal.cd,0);
    		 sheet3.SetCellValue(sheet3.GetSelectRow(), "bkg_ts_port_tp_cd",rtnVal.tp,0);  					
		}
     }
     
     function findBkgSlanCd(rtnVal) {
    	 if (rtnVal != null){
    		sheet3.SetCellValue(sheet3.GetSelectRow(), sheet3.GetSelectCol(),rtnVal.toString(),0);  					
		}
     }
     
     function findBkgVvdCd(rtnVal) {
    	 if (rtnVal != null){
    		 sheet3.SetCellValue(sheet3.GetSelectRow(), sheet3.GetSelectCol(),rtnVal.toString(),0);
    		 sheet3.SelectCell(sheet3.GetSelectRow(), sheet3.GetSelectCol());
		}
     }     
     
 	/**
 	 * Calling function when closing popup screen for retrieving Terminal Code<br>
 	 * Showing code from popup <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {String} locTp Mandatory location 
 	 * @param {array} rArray code value array
 	 * @return N/A
 	 * @author 
 	 * @version 2010.04.23
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
     * validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkTerminalCode(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTML tag object
     * @param {int} Row Mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory ,Cell's Value
     * @return N/A
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
     * Function to coltrol editable of sheet's cell<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     * 	manageCellEditable (sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
     function manageGetCellEditable(sheetObj) {
    	 var formObj=document.form;
    	 var amdtSeq=formObj.amdt_seq.value;
    	 var reqUsrFlg=formObj.req_usr_flg.value;
    	 var aproUsrFlg=formObj.apro_usr_flg.value;
    	 var propStsCd=formObj.prop_sts_cd.value;
    	 for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
    		 if(amdtSeq > 0) {  		 
       		  	// diable if AMDT_SEQ is different
    			 if(sheetObj.GetCellValue(i,"amdt_seq") != amdtSeq){
    				sheetObj.SetCellFont("FontStrike", i, "chk", i, sheetObj.LastCol(),1);
       		  		sheetObj.SetRowEditable(i,0);
       		  	}
    			 if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq){
    				 sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
					sheetObj.SetCellBackColor(i,"note_ctnt","#FFFFFF");
    			 } else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq){
					sheetObj.SetCellBackColor(i,"note_ctnt",-1);
       		  	}
    		 } else {
    			 sheetObj.SetCellBackColor(i,"note_ctnt","#FFFFFF");
    		 }
    		 if(propStsCd != "I") {
    			 sheetObj.SetCellBackColor(i,"note_ctnt",-1);
    		 }
    	 }
     }
  	  /**
      * Implementating code combo by RULE CODE and surcharge code <br>
      * <br><b>Example :</b>
      * <pre>
      *	insertChargeRuleType(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {form} formObj Mandatory form Object
      * @return N/A
      * @author 
      * @version 2009.07.02
      */
	function initComboChargeRuleCode(sheetObj, formObj) {
		// NOTE CONVERSION RULE
		var sCd="";
		var sNm="";
		formObj.f_cmd.value=COMMAND19;
		//agreement type(etc1)  	- S: S/C - R: RFA
		var tXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=R&etc2=P");
		var arrData=ComPriXml2ComboString(tXml, "cd", "nm");
		if (arrData != null){
		    var arrCode=arrData[0].split("|");
		    var arrName=arrData[1].split("|");
		    var conData="";
		    for(i=0; i < arrName.length;i++){
		        if(i==0){
		            arrName[i]=arrCode[i]+"\t"+arrName[i];
		        }else{
		            arrName[i]="|"+arrCode[i]+"\t"+arrName[i];
		        }
		        conData=conData.concat(arrName[i]);
		    }
		    arrData[1]=conData;
		}
		if (arrData != null){
			sCd="|" + arrData[0];
			sNm="|" + arrData[1];			        
		} else {
			sCd="|";
			sNm="|";
		}
		// SURCHARGE
		formObj.f_cmd.value=COMMAND12;
		tXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
		arrData=ComPriXml2ComboString(tXml, "cd", "nm");
		if (arrData != null){
		    var arrCode=arrData[0].split("|");
		    var arrName=arrData[1].split("|");
		    var conData="";
		    for(i=0; i < arrName.length;i++){
		        if(i==0){
		            arrName[i]=arrCode[i]+"\t"+arrName[i];
		        }else{
		            arrName[i]="|"+arrCode[i]+"\t"+arrName[i];
		        }
		        conData=conData.concat(arrName[i]);
		    }
		    arrData[1]=conData;
		}
		if (arrData != null){
			sCd += ("|" + arrData[0]);
			sNm += ("|" + arrData[1]);			        
		}
		sChgCdVisiable=sNm;
		sheetObj.SetColProperty(2, {ComboText:sNm, ComboCode: sCd} );
	}
 	/**
 	 * Setting route's type code when inputting data in route<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @param {int} Len Mandatory ,Cell's Value Length
 	 * @return N/A
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
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @return N/A
	 * @author 
	 * @version 2009.07.15
	 */ 
    function checkDuration(sheetObj) {
		var formObj=document.form;
		var rowCount = getValidRowCount(sheetObj);
		var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
		var expDt=ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
		if(rowCount > 0){
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				if (sheetObj.GetRowStatus(i) == "D") {
					continue;
				}
				if(sheetObj.GetCellValue(i, "eff_dt") < effDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.SetCellValue(i, "eff_dt",effDt,0);
					sheetObj.SelectCell(i, "eff_dt");
					return false;
				}
				if(sheetObj.GetCellValue(i, "eff_dt") > sheetObj.GetCellValue(i, "exp_dt") ){
					ComShowCodeMessage("PRI00306");
					sheetObj.SetCellValue(i, "eff_dt",effDt,0);
					sheetObj.SetCellValue(i, "exp_dt",expDt,0);
					sheetObj.SelectCell(i, "eff_dt");
					return false;
				}
				if(sheetObj.GetCellValue(i, "exp_dt") > expDt) {
					ComShowCodeMessage("PRI08016");
					sheetObj.SetCellValue(i, "exp_dt",expDt,0);
					sheetObj.SelectCell(i, "exp_dt");
					return false;
				}
			}
		}
		return true;
    }
  	/**
  	 * Defing color in case of state code in Route<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setStateColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object'sRow Index
  	 * @return N/A
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
  	 * Defining color in case of Rule Code<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 * setChargeRuleColor(sheetObj, Row);
  	 * </pre>
  	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory IBSheet Object's Row Index
  	 * @return N/A
  	 * @author 
  	 * @version 2009.07.09
  	 */ 
 	function setChargeRuleColor(sheetObj, Row) {
 		// Rule & Charge Code 
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
       * Checking editable item by code value when seleting code item<br>
       * 
       * <br><b>Example :</b>
       * <pre>
       *	disableColumnValidation(sheetObj, Row, Col, Value);
       * </pre>
       * @param {ibsheet} sheetObj Mandatory IBSheet Object
       * @param {int} Row Mandatory OnClick ,Cell's Row Index
       * @param {int} Col Mandatory OnClick ,Cell's Column Index 
       * @param {str} Value Mandatory 
       * @return N/A
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
 				if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
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
 				if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="S" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="I" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="N" ) {
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
        * resetting editable of visible item on sheet<br>
        * 
        * <br><b>Example :</b>
        * <pre>
        *	initColumnEditable(sheetObj, Row, Col, Value);
        * </pre>
        * @param {ibsheet} sheetObj Mandatory IBSheet Object
        * @param {int} Row Mandatory OnClick ,Cell's Row Index
        * @param {int} Col Mandatory OnClick ,Cell's Column Index
        * @param {str} Value Mandatory 
        * @return N/A
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
     * Checking Mandatory column by code type when seleting code item<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	checkMandatoryValidation(sheetObj, Row);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @return N/A
     * @author 
     * @version 2009.07.02
     */ 	
  	function checkMandatoryValidation(sheetObj, Row) {
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
	 			//In case of  Fixed amount or adjust , when inputing SURCHARGE CODE
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
 			} else if(sheetObj.GetCellValue(Row, "bkg_por_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_pol_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_del_def_cd") == "") {
 				//Mandatory , one of POR, POL,POD,DEL			 				
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
      * Setting default value on column by code type when seleting code item<br>
      * 
      * <br><b>Example :</b>
      * <pre>
      *	defaultColumnValidation(sheetObj, Row, Col, Value);
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {int} Row Mandatory OnClick ,Cell's Row Index
      * @param {int} Col Mandatory OnClick ,Cell's Column Index
      * @param {str} Value Mandatory 
      * @return N/A
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
 				break;
 			default:
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 				break;
     	}
  	}
  /**
   * Initializing Data<br>
   * 
   * <br><b>Example :</b>
   * <pre>
   *	initColumnValue(sheetObj, Row);
   * </pre>
   * @param {ibsheet} sheetObj Mandatory IBSheet Object
   * @param {int} Row Mandatory OnClick ,Cell's Row Index
   * @return N/A
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
     * Multi-Copying SHEET ROW<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *	copySheetData(sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2010.03.23
     */	
 	function copySheetData(sheetObj) {
  		//Setting default after loading sheet
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
      			// Rule & Charge Code color
      			//setChargeRuleColor(sheetObj, idx);
      			maxSeq++;
 			}
 		}
 	}
 	/**
      * Seperating data by charge rule type when selecting CODE COMBO <br>
      * <br><b>Example :</b>
      * <pre>
      *	insertChargeRuleType(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {int} Row Mandatory OnClick ,Cell's Row Index
      * @return N/A
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
    * Returning SYS_GUID() value <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param N/A
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
     * Setting NOTE CONVERSION FLAG <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.08.13
     */ 
    function setNoteConvFlg(sheetObj) {
    	var convFlg=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_conv_flg");
    	var rowCount = getValidRowCount(sheetObj);
    	if(rowCount > 0) {
    		if(convFlg == "N") {
    			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_conv_flg","Y");
    		}
    	} else {
    		if(convFlg == "Y") {
    			sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "note_conv_flg","N");
    		}
    	}
    }
	/**
     * Controling button authority <br>
     * <br><b>Example :</b>
     * <pre>
     * buttonControl(mode)
     * </pre>
     * @param {string} mode Mandatory ,user mode or authority
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
  	function buttonControl(mode){
 		var formObj=document.form;
 		var req_usr_flg=formObj.req_usr_flg.value;
 		var apro_usr_flg=formObj.apro_usr_flg.value; 		
 		var amdt_seq=formObj.amdt_seq.value;
 		var sts=formObj.prop_sts_cd.value;
 		var row_cnt=sheetObjects[0].RowCount();
 		try{		
 				ComBtnDisable("btn_retrieve");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_acceptall");
				ComBtnDisable("btn_cancelall");
				ComBtnDisable("btn_rowadd1");
				ComBtnDisable("btn_delete1");
				ComBtnDisable("btn_rowadd2");
				ComBtnDisable("btn_delete2");
				hiddenButton("btn_amend");
				hiddenButton("btn_amendcancel");
				ComBtnDisable("btn_accept");
				ComBtnDisable("btn_acceptcancel");
				ComBtnDisable("btn_copy");
				ComBtnDisable("btn_paste");
				ComBtnDisable("btn_rowadd3");
				ComBtnDisable("btn_rowcopy");
				ComBtnDisable("btn_delete3");
				ComBtnDisable("btn_autoword");
				if(mode == "CLEAR") {
					return;
				}
 			switch(sts) {
 				case 'I':   // Initial
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
 						ComBtnEnable("btn_save");
 						ComBtnEnable("btn_rowadd1");
 						ComBtnEnable("btn_delete1");
 						ComBtnEnable("btn_rowadd2");
 						ComBtnEnable("btn_delete2");
 						ComBtnEnable("btn_amend");
 						ComBtnEnable("btn_amendcancel");
 						if(amdt_seq > 0){
 							showButton("btn_amend");
 							showButton("btn_amendcancel");
 						}
 						ComBtnEnable("btn_copy");
 						ComBtnEnable("btn_paste");
 						ComBtnEnable("btn_rowadd3");
 						ComBtnEnable("btn_rowcopy");
 						ComBtnEnable("btn_delete3");
 						ComBtnEnable("btn_autoword");
 					}				
 					break;
 				case 'Q':   // Requested
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg == "true" ){
 						ComBtnEnable("btn_acceptall");
 						ComBtnEnable("btn_cancelall");
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 					}
 					break;
 				case 'R':   // Returned
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 					}				
 					break;
 				case 'A':   // Approved
 	 				ComBtnEnable("btn_retrieve");
 				case 'F':   // Filed
 	 				ComBtnEnable("btn_retrieve");
 				case 'C':   // Cancled
 	 				ComBtnEnable("btn_retrieve");
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
 	/**
      * Controling button authority <br>
      * <br><b>Example :</b>
      * <pre>
      * buttonControlConv()
      * </pre>
      * @param N/A
      * @return N/A
      * @author 
      * @version 2009.04.17
      */
   	function buttonControlConv(){
  		var formObj=document.form;
  		var req_usr_flg=formObj.req_usr_flg.value;
  		var apro_usr_flg=formObj.apro_usr_flg.value; 
  		var sts=formObj.prop_sts_cd.value;
      	var amdtSeq=formObj.amdt_seq.value;
  		try{
  			switch(sts) {
  				case 'I':   // Initial
  					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
  						if(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "amdt_seq") != amdtSeq || (sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "amdt_seq")  == amdtSeq && sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq")!= amdtSeq)) {
  								ComBtnDisable("btn_copy");
  								ComBtnDisable("btn_paste");
  								ComBtnDisable("btn_rowadd3");
  								ComBtnDisable("btn_rowcopy");
  								ComBtnDisable("btn_delete3");
  								ComBtnDisable("btn_autoword");
  						} else {
  								ComBtnEnable("btn_copy");
  								ComBtnEnable("btn_paste");
  								ComBtnEnable("btn_rowadd3");
  								ComBtnEnable("btn_rowcopy");
  								ComBtnEnable("btn_delete3");
  								ComBtnEnable("btn_autoword");
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