/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019_01.js
*@FileTitle  : RFA Proposal Inquiry - Special Note 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/

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
 * @class ESM_PRI_2019_01 : Business Script for ESM_PRI_2019_01
 */
    function ESM_PRI_2019_01() {
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
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	var sChgCdVisiable="";
	var delTotal=false;//flag for deleting last row of DETAIL
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
     * @version 2009.10.28
     */
	function processButtonClick(){
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
    * @return void
    * @author 
    * @version 2009.05.17
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			//Modify Environment Setting Function's name
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//Add Environment Setting Function
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		resizeSheet();
        loadSts=true;
		parent.loadTabPage();
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
    * @version 2009.05.22
    */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|dp_seq|Title|note_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq" + "|1|2|3";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq" },
			             {Type:"Text",      Hidden:0,  Width:700,  Align:"Left",    ColMerge:0,   SaveName:"note_tit_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetWaitImageVisible(0);
	              SetAutoRowHeight(0);
	              SetSheetHeight(120);
		      }
			 break;
			 
             case "sheet2":
            	    with(sheetObj){
		               var HeadTitle1="|Sel.|Seq.|Contents|EFF Date|EXP Date|Source|Status|Accepted|Accepted" +
		               "|1|2|3|4|5|6|7|8|9|10";
		               var HeadTitle2="|Sel.|Seq.|Contents|EFF Date|EXP Date|Source|Status|By|On" +
		               "|1|2|3|4|5|6|7|8|9|10";
		               var headCount=ComCountHeadTitle(HeadTitle1);
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"},
		                               { Text:HeadTitle2, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
		                      {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                      {Type:"Text",      Hidden:0,  Width:510,  Align:"Left",    ColMerge:1,   SaveName:"note_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
		                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:270,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dp_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"note_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"note_ctnt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"note_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prop_no" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"note_conv_mapg_id" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"note_conv_flg" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq" } ];
		               InitColumns(cols);
		               SetEditable(0);
		               SetWaitImageVisible(0);
		               SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
		               SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
		               //SetAutoRowHeight(0);
		               SetShowButtonImage(0);
		               SetSheetHeight(150);
             		}
                 break;
                 
         	case "sheet3":
         	    with(sheetObj){
		              var HeadTitle="|Sel.|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
		              "|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +
		              "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:48,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		                     {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                     {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnl_tz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		                     {Type:"Combo",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
		                     {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
		                     {Type:"Combo",     Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_vsl_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_voy_no" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_dir_cd" },
		                     {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" } ];
		              InitColumns(cols);
		              SetEditable(0);
//		              SetCountPosition(0);//hidingTotal
		              SetWaitImageVisible(0);
		              SetColProperty("bkg_soc_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
		              SetColProperty("bkg_dir_call_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
		              SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
		              SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
		              SetColProperty("bkg_hngr_bar_tp_cd", {ComboText:bkgHngrBarTpCdComboText, ComboCode:bkgHngrBarTpCdComboValue} );
		              SetColProperty("bkg_cnl_tz_cd", {ComboText:bkgCnlTzCdComboText, ComboCode:bkgCnlTzCdComboValue} );
		              SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
		              SetShowButtonImage(2);
		              resizeSheet(); //SetSheetHeight(204);
              	}
            break;
         }
     }
	
	function resizeSheet() {
	    ComResizeSheet(sheetObjects[2]);
	}
    /**
     * Calling function in case of clicking SHEET's ROW<br>
     * Retrieving child-sheet by selected row<br>
     * <br><b>Example :</b>
     * <pre>
     *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
     * </pre>
     * @param {ibsheet} sheetM Mandatory HTMLtag(Object) Object
     * @param {ibsheet} sheetD Mandatory HTMLtag(Object) Object
     * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
     * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
     * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
     * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
     * @param {string} appendRow Mandatory SHEET Row Add Option
     * @return void
     * @author 
     * @version 2009.05.19
     */
	function doRowChange(sheetM, sheetD, sheetC, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (OldRow != NewRow) {
			formObj.note_seq.value=sheetM.GetCellValue(adjNewRow, "note_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
		}
	}
   /**
    * Calling function in case of clicking Special Note's MASTER SHEET<br>
    * Retrieving Detail by MASTER SHEET's ROW <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetM Mandatory IBSheet Object
    * @param {ibsheet} sheetD Mandatory IBSheet Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @return void
    * @author 
    * @version 2009.07.15
    */ 
    function doRowChangeConversion(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (OldRow != NewRow) {				
			formObj.note_seq.value=sheetM.GetCellValue(NewRow, "note_seq");
			formObj.note_ctnt_seq.value=sheetM.GetCellValue(NewRow, "note_ctnt_seq");
			formObj.note_conv_mapg_id.value=sheetM.GetCellValue(NewRow, "note_conv_mapg_id");
			doActionIBSheet(sheetD,document.form,IBSEARCH_ASYNC01);
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
    * @version 2009.05.22
    */
  	function doActionIBSheet(sheetObj, formObj, sAction) {
  		try {
	  		sheetObj.ShowDebugMsg(false);
	  		switch (sAction) {
	  			case IBSEARCH: // retrieving
	  				ComOpenWait(true);
		  			for (var i=0; i < sheetObjects.length; i++) {
						sheetObjects[i].RemoveAll();
					}
					formObj.f_cmd.value=SEARCH01;
					sheetObj.DoSearch("ESM_PRI_2019_01GS.do", FormQueryString(formObj) );
	  				break;
	  			case IBSEARCHAPPEND: // Retrieving
	  				ComOpenWait(true);
	  				formObj.f_cmd.value=SEARCH02;
	  				sheetObj.DoSearch("ESM_PRI_2019_01GS.do", FormQueryString(formObj) );
	  				break;
	  			case IBSEARCH_ASYNC01: // Retrieving
	  				ComOpenWait(true);
		 			formObj.f_cmd.value=SEARCH13;
		 			sheetObj.DoSearch("ESM_PRI_2019_01GS.do", FormQueryString(formObj) );
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
      * Calling function in case of Onclick event <br>
      * Highlighting selected row<br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
      * @param {int} Row mandatory Onclick ,Cell's Row Index
      * @param {int} Col mandatory Onclick ,Cell's Column Index
      * @param {string} Value Mandatory Value
      * @return void
      * @author 
      * @version 2009.05.19
      */	
  	 function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObjects[0], sheetObjects[1],  sheetObjects[2],OldRow, NewRow, OldCol, NewCol, false);
	 }
     /**
      * calling function in case of OnSelectCell event <br>
      * when row focus changed, retrieve again. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
      * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
      * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
      * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
      * @return void
      * @author 
      * @version 2009.07.15
      */ 
  	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	doRowChangeConversion(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
  	}
    /**
     * Calling function in case of Onclick event <br>
     * Showing memopad for address inputting<br>
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
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
 	    //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
 	    var colname=sheetObj.ColSaveName(Col);
      	switch(colname)
      	{
      		case "note_ctnt":
	    		//ComShowMemoPad(sheetObj, Row, Col, true, 350);
      			var memoColWidth = 	sheetObj.GetColWidth("note_ctnt") +
						    		sheetObj.GetColWidth("eff_dt") +
						    		sheetObj.GetColWidth("exp_dt") +
						    		sheetObj.GetColWidth("src_info_cd") +
						    		sheetObj.GetColWidth("prc_prog_sts_cd") +
						    		sheetObj.GetColWidth("acpt_usr_nm");
      			ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 15);
	    		break;      	
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
     * @version 2009.04.17
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		case IBSEARCHAPPEND: // Retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		}
		 return true;
	}
	 /**
	  * Calling function in case of clicking tabl on parent screen <br>
	  * It shows screen and process retrieve <br>
	  * <br><b>Example :</b>
	  * <pre>
	  * tabLoadSheet("ACE", "1")
	  * </pre>
	  * @param {string} sPropNo Mandatory prop_no 
	  * @param {string} sAmdtSeq Mandatory amdt_seq 
	  * @param {string} sSvcScpCd Mandatory svc_scp_cd 
	  * @return void
	  * @author 
	  * @version 2009.05.21
	  */ 
	 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd) {
	 	var formObject=document.form;
	 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
	 		formObject.prop_no.value=sPropNo;
	 		formObject.amdt_seq.value=sAmdtSeq;
	 		formObject.svc_scp_cd.value=sSvcScpCd;
	 		doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
	 	}
	 }
	/**
     * Function to clear control of tab screen on parent <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.05.20
     */ 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
	}
	var enableFlag=true;
	/**
     * Calling function from main<br>
     * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from Main screen
     * @return void
     * @author 
     * @version 2009.04.17
     */
	function tabEnableSheet(flag) {
		enableFlag=flag;
	}
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		if(sheetObj.RowCount()==0){
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
		}
 	}
	
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		if(sheetObj.RowCount()==0){
			doActionIBSheet(sheetObjects[2],document.form,IBSEARCHAPPEND);
		}
 	}
 	/**
 	 * Calling Function in case of OnSearchEnd event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj mandatory IBSheet Object
 	 * @param {string} ErrMsg mandatory from server
 	 * @return void
 	 * @author 
 	 * @version 2009.05.20
 	 */ 
 	function sheet3_OnSearchEnd(sheetObj, errMsg){ 		
 		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	 		//Setting color in case of state code at route.
	 		setStateColor(sheetObj, i);
	 		//Setting color in case of Rule Code
	 		//setChargeRuleColor(sheetObj, i);
 		}
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
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
 			&& chgRuleDefCd != "RAC" ) {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",0);
 		} else {
 			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",sCodeColor);
 		} 
 	}
	var loadSts=false;
  	/**
     * Calling function from main<br>
     *  <br>
     * <br><b>Example :</b>
     * <pre>
     *loadFinishCheck()
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.19
     */
	 function loadFinishCheck(){
	     return loadSts;
	 } 
