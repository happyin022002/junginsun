/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2050.js
*@FileTitle  : RFA Proposal Creation - Arbitrary[Load Excel]
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
 * @class ESM_PRI_2050 : Business Script for ESM_PRI_2050
 */
function ESM_PRI_2050() {
	this.processButtonClick=processButtonClick;
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
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array(); 
var sheetCnt=0;
var errFlg=false; 
var checkFlg = false;
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name  <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * processButtonClick();
 * </pre>
 * 
 * @return void
 * @author 
 * @version 2009.07.30
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
		case "btn_save":
			if (validateForm(sheetObject1, formObject, IBSAVE)) {
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			}
			break;
		case "btn_check":
			if (validateForm(sheetObject1, formObject, IBSEARCH)) {
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			}
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		case "btn_file":
			//sheetObjects[0].LoadExcel(-1);
 			sheetObjects[0].LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false});
			break;
		case "btn_Template":
		    downform.submit();
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
 * @version 2009.05.20
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
 * @version 2009.05.17
 */
function loadPage() {
	
	if (!opener) opener = window.dialogArguments;
	if (!opener) opener = window.opener;
	if (!opener) opener = parent;
	
	for (i=0; i < sheetObjects.length; i++) {
		//Modify Environment Setting Function's name
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// Add Environment Setting Function 
		ComEndConfigSheet(sheetObjects[i]);
	}
	buttonControl("INIT");
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
 * @version 2009.05.17
 */
function initSheet(sheetObj, sheetNo) {
	var formOrg=document.form;
	var cnt=0;
	switch (sheetNo) {

    case 1: //sheet1 init
        with(sheetObj){

    	         var HeadTitle="|Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base\nPort|Actual\nCustomer|Per|CGO\nType|Cur.|Proposal|seq|Note";
    	         HeadTitle += "|1|2|3|4|5|6|7|8|9|10|11|12";
    	         var headCount=ComCountHeadTitle(HeadTitle);

    	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

    	         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	         var headers = [ { Text:HeadTitle, Align:"Center"} ];
    	         InitHeaders(headers, info);

    	         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    	             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"add_chg_seq" },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
    	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"rout_pnt_loc_def_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:40 },
    	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",    ColMerge:1,   SaveName:"prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
    	             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
    	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:"prop_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
    	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"note_dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
    	             {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"add_chg_note_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq" },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prop_no" },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd" },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"add_chg_tp_cd" },
    	             {Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
    	             {Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"bse_port_tp_cd" },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd" },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq" },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_cd" },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd" },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_dt" } ];
    	          
    	         InitColumns(cols);
    	         SetColProperty("rcv_de_term_cd", {ComboText:rcvDeTermCdComboText, ComboCode:rcvDeTermCdComboValue} );
    	         SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdComboText, ComboCode:prcTrspModCdComboValue} );
    	         SetColProperty("rat_ut_cd", {ComboText:ratUtCdComboText, ComboCode:ratUtCdComboValue} );
    	         SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdComboText, ComboCode:prcCgoTpCdComboValue} );
    	         SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
    	         SetColProperty("cust_def_cd", {ComboText:custDefCdComboText, ComboCode:custDefCdComboValue} );

    	         SetEditable(1);
    	         SetWaitImageVisible(0);
    	         SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
    	         SetColProperty(0 ,"bse_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
    	         SetColProperty(0 ,"note_dp_seq" , {AcceptKeys:"[1234567890]"});
    	         
    	         SetShowButtonImage(2);
    	         resizeSheet(); //  SetSheetHeight(240);
    	         }
    	         break;

    case 2: //Column VALIDATION - Use it for Database Query
		with (sheetObj) {

		var HeadTitle="|Seq.|Point|Description|Trans Mode|Term|Weight(Ton<=)|Weight(<Ton)|Base Port|Actual Customer|Per|Cargo Type|Currency|Proposal|Note";
		HeadTitle += "|1|2|3|4|5|6|7|8|9|10|11|12";
		var headCount=ComCountHeadTitle(HeadTitle);
		
		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
		
		var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		var headers = [ { Text:HeadTitle, Align:"Center"} ];
		InitHeaders(headers, info);
		
		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"add_chg_seq" },
		{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rout_pnt_loc_def_cd" },
		{Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"rout_pnt_loc_def_desc" },
		{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"prc_trsp_mod_cd" },
		{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"rcv_de_term_cd" },
		{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt" },
		{Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt" },
		{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_port_def_cd" },
		{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_def_cd" },
		{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd" },
		{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"prc_cgo_tp_cd" },
		{Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
		{Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"prop_frt_rt_amt" },
		{Type:"Text",      Hidden:1, Width:200,   Align:"left",   ColMerge:1,   SaveName:"add_chg_note_ctnt" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prop_no" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"add_chg_tp_cd" },
		{Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
		{Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"bse_port_tp_cd" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_cd" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd" },
		{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_dt" } ];
		
		InitColumns(cols);
		
		SetEditable(0);
		SetWaitImageVisible(0);
		//SetSheetHeight(160);
		SetVisible(0);
		}
			break;

    case 3: // Note Sequence and Content Validation
		with (sheetObj) {

        var HeadTitle="|Type|Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base\nPort|Actual\nCustomer|Per|CGO\nType|Cur.|Proposal|seq|Note|Note Text";
        HeadTitle += "|1|2|3|4|5|6|7|8|9|10|11|12";
        var headCount=ComCountHeadTitle(HeadTitle);

        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        InitHeaders(headers, info);

        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
            {Type:"Type",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"type" },
            {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"add_chg_seq" },
            {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"rout_pnt_loc_def_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:40 },
            {Type:"Text",     Hidden:0, Width:80,   Align:"Center",    ColMerge:1,   SaveName:"prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            {Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
            {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
            {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            {Type:"Text",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            {Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            {Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            {Type:"Text",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:"prop_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"note_dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            {Type:"Text",      Hidden:0, Width:330,  Align:"Left",    ColMerge:0,   SaveName:"add_chg_note_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_text",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq" },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prop_no" },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd" },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"add_chg_tp_cd" },
            {Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
            {Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"bse_port_tp_cd" },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd" },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq" },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_cd" },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd" },
            {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_dt" } ];
         
        InitColumns(cols);
        SetEditable(0);
        SetWaitImageVisible(0);
        SetShowButtonImage(2);
        SetSheetHeight(240);
        SetVisible(0);
        }
		break;

	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
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
 * @version 2009.04.17
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colname=sheetObj.ColSaveName(Col);
	var formObj=document.form
	switch (colname) {
	case "rout_pnt_loc_def_cd":
		if (Value.length == 5) {
			if(sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "bse_port_def_cd") == Value){
				ComShowCodeMessage('PRI01078');
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
				sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
				sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
				break;
			}
			formObj.f_cmd.value=SEARCH05;
			formObj.cd.value=sheetObj.GetCellValue(Row, Col);
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do",
					FormQueryString(formObj));
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_desc",arrData[0][1],0);
				sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","L",0);
			} else {
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_desc","",0);
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
				sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
				sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
			}
		} else {
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_desc","",0);
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
			sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
			sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
		}
		break;
	case "bse_port_def_cd":
		if (Value.length == 5) {
			if(Value == sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") && sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D") {
				ComShowCodeMessage('PRI01020');
				sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
				sheetObj.SelectCell(Row, "bse_port_def_cd");
				break;
			}
			formObj.f_cmd.value=SEARCH05;
			formObj.cd.value=Value;
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do",
					FormQueryString(formObj));
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","L",0);
			} else {
				sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
		} else if(Value.length == 4) {
			formObj.f_cmd.value=COMMAND24;
			formObj.cd.value=Value;
			var sParam=FormQueryString(formObj);
			sParam += "&etc1="+PRI_RP_SCP;
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","G",0);
			} else {
				sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
		} else {
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
			sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
			sheetObj.SelectCell(Row, "bse_port_def_cd");
		}
		break;
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
 * @version 2009.05.17
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		switch (sAction) {
			case IBSEARCH: 	
  				ComOpenWait(true);
				formObj.f_cmd.value=MULTI02;
				var sParam=FormQueryString(formObj);
				var sParamSheet1=sheetObj.GetSaveString(true);
				sParam += "&" + sParamSheet1;
 				var sXml=sheetObj.GetSearchData("ESM_PRI_2050GS.do", sParam);
 				var tempXml = sXml.split("|$$|");
 				var arbNoteCheckArr = new Array();
 	  			if(tempXml.length > 1){
 	  				arbNoteCheckArr = ComPriXml2Array(tempXml[1], "note_dp_seq|add_chg_note_ctnt");
 	  			}
 	  			if(tempXml.length > 0){
 	  				sheetObjects[1].LoadSearchData(tempXml[0],{Sync:1} );
 	  				checkValidationAllData(sheetObjects[1], arbNoteCheckArr);
 	  			}
				// Error Data makes Red
				
				break;
			case IBSAVE: // Save
				if(errFlg) {
					buttonControl("FAIL");
					makeSheetEditable(sheetObjects[0]);
					return false;
				}
				if((ComShowCodeConfirm("PRI00001")) ) {	
	  				ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("ESM_PRI_2050GS.do", FormQueryString(formObj), -1, false);
				}
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
	case IBSEARCH: // Check
		if (!sheetObjects[0].IsDataModified()) {
			ComShowCodeMessage("PRI00312");
			return false;
		}
		break;
	case IBSAVE: // Saving
		if(ComGetBtnDisable("btn_save")) return false;
		if (sheetObjects[0].IsDataModified()) {
			//checking of duplicate with existing data
			sheetObjects[1].RemoveAll();
			var sXml=ComPriSheet2Xml(sheetObjects[0])
			sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
			formObj.f_cmd.value=SEARCH01;
 			sXml=sheetObj.GetSearchData("ESM_PRI_2019_04GS.do", FormQueryString(formObj));
			sheetObjects[1].LoadSearchData(sXml,{Append:1 , Sync:1} );
			var rowM = sheetObjects[1].ColValueDupRows("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|" +
					"bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|min_cgo_wgt|max_cgo_wgt|cust_def_cd|amdt_seq|add_chg_note_ctnt", false, true);
			if (rowM != "") {
				var rowDup=rowM.split("|");
				ComShowCodeMessage("PRI00303", "Sheet", rowDup[0]);
				// Process to modifying duplication data
				buttonControl("FAIL");
				makeSheetEditable(sheetObjects[0]);
				checkFlg = true;
				return false;
			}
		}
		break;
	}
	return true;
}
/**
 * calling function when occurring OnSaveEnd event <br>
 * Showing saving confirmation message <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {string} ErrMsg mandatory from server
 * @return void
 * @author 
 * @version 2009.05.17
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var psheetObj=opener.sheetObjects[0];
	var pformObj=opener.document.form;
	opener.setProposalStatusSummary(pformObj);
	opener.doActionIBSheet(psheetObj, pformObj, IBSEARCH);
	ComClosePopup(); 
}
/**
 * calling function when occurring LoadExcel event <br> 
 * @author 
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @return void
 * @author 
 * @version 2009.06.25
 */
function sheet1_OnLoadExcel(sheetObj, result, code,msg) {
	if(isExceedMaxRow(msg))return;
	var formObj=document.form;
	if (sheetObj.RowCount() > 0) {
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			//Mandatory Code Data Set
			sheetObj.SetCellValue(i, "svc_scp_cd",formObj.svc_scp_cd.value,0);
			sheetObj.SetCellValue(i, "amdt_seq",formObj.amdt_seq.value,0);
			sheetObj.SetCellValue(i, "prop_no",formObj.prop_no.value,0);
			sheetObj.SetCellValue(i, "add_chg_tp_cd",formObj.add_chg_tp_cd.value,0);
			sheetObj.SetCellValue(i, "org_dest_tp_cd",formObj.org_dest_tp_cd.value,0);
			sheetObj.SetCellValue(i, "n1st_cmnc_dt",formObj.n1st_cmnc_dt.value,0);
		}
		makeSheetEditable(sheetObj);
		checkFlg = true;
	}
	buttonControl("LOAD");
}

/**
 * It calls when OnClick event triggered on sheet1 <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
 * @param {int} Row mandatory Onclick ,Cell's Row Index
 * @param {int} Col mandatory Onclick ,Cell's Column Index
 * @param {string} Value Mandatory Value
 * @returns void
 * @author 
 * @version 2009.05.18
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	//Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
	var formObj=document.form;
	var colname=sheetObj.ColSaveName(Col);
	switch (colname) {
		case "add_chg_note_ctnt":
			if(checkFlg){
				ComShowMemoPad(sheetObj, Row, Col, false, null, null, null,1); // Editable
			}else{
				if(Value=="" || Value==null){
					return false;
				}
				ComShowMemoPad(sheetObj, Row, Col, true, null, null, null,1); // Disabled
			}
			break;
	}
}

/**
 * The function calls after Check button event. When Error Data exists, make BGColor of Sheet red.<br>
 *
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @return void
 * @author NYK (Modifier)
 * @version 2016.08.02
 */
function checkValidationAllData(sheetObj, arbNoteCheckArr) {
		var check=0;
		// Setting color to Error Cell (Red)
		var color="#FF0000";
		// Initialize Color - White
		var basecolor="#FFFFFF"; 
		for (var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
			sheetObjects[0].SetRowBackColor(i,0);
		}
		sheetObjects[2].RemoveAll();
		var sXml=ComPriSheet2Xml(sheetObjects[0]);
  		ComPriXml2Sheet(sheetObjects[2], sXml);
  		// Arb Note sequence and content validation
  	  	if(!validateArbNoteSeq(sheetObjects[2], arbNoteCheckArr)){
  	  		check++;
		}
  	  	if(check == 0){
  	  	// Sheet Data validation
  	  	check += validateSheetData(sheetObjects[0], color, basecolor);
  	  	// DB data validation
  	  	check += checkDBCodeExist(sheetObj, color);
  	  	}
		if (check > 0) {
			errFlg=true;
			checkFlg = true;
			buttonControl("FAIL");
		} else {
			errFlg=false;
			checkFlg = false;
  			sheetObjects[0].SetEditable(0);
  			for(var i=1; i<=sheetObjects[0].LastRow(); i++){
  				for(var j=1; j<=sheetObjects[0].LastCol(); j++){
  					sheetObjects[0].SetCellBackColor(i, j,"#EFF0F3");
  				}
  			}
			//Process All Cell make Read-Only
			sheetObjects[0].SetEditable(0);
			buttonControl("SUCCEED");
		}
}

/**
 * Make sheet as Editable mode <br>
 *
 * @param {object} sheetObj Mandatory, IBSheet Object.
 * @return void
 * @author 
 * @version 2016.01.06
 */
function makeSheetEditable(sheetObj){	
	sheetObj.SetEditable(1);
	sheetObj.SetRangeBackColor(1,0,sheetObj.LastRow(),sheetObj.LastCol(),"#FFFFFF"); 
	for(var i=1; i<=sheetObj.LastCol(); i++){
		var colName = sheetObj.ColSaveName(i);
		if(colName == "add_chg_seq"||colName == "rout_pnt_loc_def_desc"){  // Seq and Desc and seq(Note) disabled
			sheetObj.SetColEditable(i, 0);	
			sheetObj.SetRangeBackColor(1,i,sheetObj.LastRow(),i,"EFF0F3");  // make Note disabled for using MemoPad 
		}else if(colName == "add_chg_note_ctnt"){
			sheetObj.SetColEditable(i, 0);	
		}							
	}
}


 /**
  * calling Event when keyboard press data cell <br> 
  * <br><b>Example :</b>
  * <pre>
  * 
  * </pre>
  * @param {ibsheet} sheetObj mandatory IBSheet Object
  * @param {Long} Row mandatory , Row Index of cell that event triggered
  * @param {Long} Col mandatory , Column Index of cell that event triggered
  * @param   {Integer} KeyCode Mandatory ASCII code value
  * @param {Integer} Shift Mandatory , 1:Shift, 2:Ctrl, 0 :other
  * @return void
  * @author 
  * @version 2009.05.20
  */ 
  function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
      if (errFlg && KeyCode == 9) {
    	  var i = sheetObj.HeaderRows();
    	  var icnt = sheetObj.LastRow();
    	  var jcnt = sheetObj.LastCol();
    	  for(; i <= icnt;i++) {
    		  for(; j <= jcnt;j++) {
    			  if (sheetObj.GetCellBackColor(i, j) == "#FF0000") {
    				  sheetObj.SelectCell(i, j, false);
    				  break;
    			  }
    		  }
    	  }
      }
  }
  /**
   * Calling function in case of OnMouseMove event<br>
   * Show the Tool Tip. <br>
   * <br><b>Example :</b>
   * <pre>
   * 
   * </pre>
   * @param {int} Button Mandatory Mouse Button 1:Left, 2:Right
   * @param {int} Shift Mandatory Shift key pressed : 1, Ctrl key pressed : 2, ETC : 0
   * @param (Long) X Mandatory X 
   * @param (Long) Y Mandatory Y 
   * @return void
   * @author 
   * @version 2010.01.26
   */ 
function sheet1_OnMouseMove(Button, Shift, X, Y) {
	var sheetObj=sheetObjects[0];
	var sRow=sheetObj.MouseRow();
	var sCol=sheetObj.MouseCol();
	var sText=sheetObj.GetComboInfo(sRow, sCol, "Text");
	if(sText != undefined && sText.length > 0){
		var arrText=sText.split("|");
		if (sRow > 0 && sCol == 9) {
			var sIdx=sheetObj.GetComboInfo(sRow, sCol, "SelectedIndex");
	 		sheetObj.MouseToolTipText=arrText[sIdx].split("\t")[1];
		}
	}
	
}
/**
 * Check the validation rules on objects in windows <br>
 * Return the check value when violate the validation rule. <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {object} color Mandatory IBSheet RgbColor
 * @return check
 * @author 
 * @version 2009.06.25
 */
function validateSheetData(sheetObj, color, basecolor) {
	var check=0;
	for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		if (sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd").length != 5) {
			sheetObj.SetCellBackColor(i, "rout_pnt_loc_def_cd", color);
			check++;
		} else {
			sheetObj.SetCellBackColor(i, "rout_pnt_loc_def_cd", basecolor);
		}
		if (sheetObj.GetCellValue(i, "prc_trsp_mod_cd") == ""
				&& ComTrim(sheetObj.GetCellText(i, "prc_trsp_mod_cd")) != "") {
			sheetObj.SetCellBackColor(i, "prc_trsp_mod_cd", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "prc_trsp_mod_cd", basecolor);
		}
		if (sheetObj.GetCellValue(i, "rcv_de_term_cd") == "") {
			sheetObj.SetCellBackColor(i, "rcv_de_term_cd", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "rcv_de_term_cd", basecolor);
		}
		if (sheetObj.GetCellValue(i, "min_cgo_wgt") != "" && sheetObj.GetCellValue(i, "min_cgo_wgt") > 99.99) {
			sheetObj.SetCellBackColor(i, "min_cgo_wgt", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "min_cgo_wgt", basecolor);
		}
		if (sheetObj.GetCellValue(i, "max_cgo_wgt") != "" && sheetObj.GetCellValue(i, "max_cgo_wgt") > 99.99) {
			sheetObj.SetCellBackColor(i, "max_cgo_wgt", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "max_cgo_wgt", basecolor);
		}
		if (sheetObj.GetCellValue(i, "bse_port_def_cd") == "") {
			sheetObj.SetCellBackColor(i, "bse_port_def_cd", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "bse_port_def_cd", basecolor);
		}
		if (sheetObj.GetCellValue(i, "cust_def_cd") == ""
				&& ComTrim(sheetObj.GetCellText(i, "cust_def_cd")) != "") {
			sheetObj.SetCellBackColor(i, "cust_def_cd", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "cust_def_cd", basecolor);
		}
		if (sheetObj.GetCellValue(i, "rat_ut_cd") == "") {
			sheetObj.SetCellBackColor(i, "rat_ut_cd", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "rat_ut_cd", basecolor);
		}
		if (sheetObj.GetCellValue(i, "prc_cgo_tp_cd") == ""
				&& ComTrim(sheetObj.GetCellText(i, "prc_cgo_tp_cd")) != "") {
			sheetObj.SetCellBackColor(i, "prc_cgo_tp_cd", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "prc_cgo_tp_cd", basecolor);
		}
		if (sheetObj.GetCellValue(i, "curr_cd") == "") {
			sheetObj.SetCellBackColor(i, "curr_cd", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "curr_cd", basecolor);
		}
		if (sheetObj.GetCellValue(i, "prop_frt_rt_amt") != "" && sheetObj.GetCellValue(i, "prop_frt_rt_amt").length > 10) {
			sheetObj.SetCellBackColor(i, "prop_frt_rt_amt", color);
			check++;
		}else {
			sheetObj.SetCellBackColor(i, "prop_frt_rt_amt", basecolor);
		}
		// When Term is not  Door, b.port and point is the same code.  It needs validation check.
		if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != "D"
			&& (sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd") == sheetObj.GetCellValue(i, "bse_port_def_cd"))) {
			sheetObj.SetCellBackColor(i, "rcv_de_term_cd", color);
			sheetObj.SetCellBackColor(i, "rout_pnt_loc_def_cd", color);
			sheetObj.SetCellBackColor(i, "bse_port_def_cd", color);
			check++;
		}
	}
	return check;
}
/**
 * validation function of excel file loading <br>
 * existing error data, changed color <br>
 * <br><b>Example :</b>
 * <pre>
 * 		checkDBCodeExist(sheetObj, formObj);
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {object} color Mandatory IBSheet RgbColor
 * @return check
 * @author 
 * @version 2009.05.17
 */
function checkDBCodeExist(sheetObj, color) {
	var check=0;
	var arbSeq=0;
	var custDefCd="";
	for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		arbSeq=sheetObjects[0].GetCellValue(i, "add_chg_seq");
		if (sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd") == "0") {
			sheetObjects[0].SetCellBackColor(arbSeq, "rout_pnt_loc_def_cd", color);
			check++;
		} else {
			sheetObjects[0].SetCellValue(arbSeq, "rout_pnt_loc_tp_cd","L",0);
		}
		if (sheetObj.GetCellValue(i, "bse_port_def_cd") == "0") {
			sheetObjects[0].SetCellBackColor(arbSeq, "bse_port_def_cd", color);
			check++;
		} else {
			if (sheetObjects[0].GetCellValue(arbSeq, "bse_port_def_cd").length == 4) {
				sheetObjects[0].SetCellValue(arbSeq, "bse_port_tp_cd","G",0);
			} else if (sheetObjects[0].GetCellValue(arbSeq, "bse_port_def_cd").length == 5) {
				sheetObjects[0].SetCellValue(arbSeq, "bse_port_tp_cd","L",0);
			}
		}
	}
	return check;
}

/**
  * Controlling button's authority<br>
  * controlling buttons <br>
  * <br><b>Example :</b>
  * <pre>
  * buttonControl()
  * </pre>
  * @param  void
  * @return void
  * @author 
  * @version 2009.07.31
  */
function buttonControl(valChck){
	var formObj=document.form;
	var rowCount = sheetObjects[0].RowCount();
	try{
		ComBtnDisable("btn_file");
		ComBtnDisable("btn_check");
		ComBtnDisable("btn_save");
		ComBtnEnable("btn_close");
		switch(valChck) {
			case "SUCCEED":
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_file");
				ComBtnDisable("btn_check");
				break;
			case "FAIL":
				ComBtnEnable("btn_file");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				break;
			case "LOAD":
				ComBtnEnable("btn_file");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				break;
			case "INIT":
				ComBtnEnable("btn_file");
				ComBtnDisable("btn_check");
				ComBtnDisable("btn_save");
				break;
		}	
	} catch (e) {}
}

/**
 * Check Length by bite<br>
 * @param Value
 * @returns {Boolean}
 */
function validCheckLength(Value) {
	var rVal = ComChkLenByByte(Value, 1000);
	if(rVal == -1 || rVal == 0) {
		return false;
	}
	return true;
}

/**
 * validate on saving arbitrary note sequence and content
 * 1. Check case with same note sequence but different note content : Hardstop <br>
 * 2. Check case with different note sequence but same note content : Give warning & option to synchronize sequence <br>
 *
 * @author NYK
 * @version 2016.08.02
 */
	  function validateArbNoteSeq(sheetObj, existingDupArr){
		  var loadLastRow = sheetObjects[0].LastRow();
		  var baseColor="#FFFFFF";
		  var validColor="#FF0000";
		  // UI data are set to "P" Type
		  if(existingDupArr != undefined){
			  for(var i=1; i<=existingDupArr.length; i++){
				  sheetObj.DataInsert(-1);
				  sheetObj.SetCellValue(loadLastRow+i, "type", "P");
				  sheetObj.SetCellValue(loadLastRow+i, "note_dp_seq", existingDupArr[i-1][0]);
				  sheetObj.SetCellValue(loadLastRow+i, "add_chg_note_ctnt", existingDupArr[i-1][1]);
			  }
		  }
		  // Load Excel data are set to "C" Type
		  for(var i=1; i<=loadLastRow; i++){
			  sheetObj.SetCellValue(i, "type", "C");
		  }
		  var validRowCnt = 0;
		  var rCnt = sheetObj.RowCount();
		  for(var i=1; i<=sheetObjects[0].RowCount(); i++){
			  sheetObjects[0].SetCellBackColor(i, "note_dp_seq", baseColor);
		  }
		  // validate on case of (1) empty note seq (2) zero note seq (3) note seq starting with 0
			for(var i=1; i<=rCnt; i++) {
				if(sheetObj.GetCellValue(i, "type") == "C") {
					if(sheetObj.GetCellValue(i, "add_chg_note_ctnt") == "") {
						if(sheetObj.GetCellValue(i, "note_dp_seq") != ""){
							sheetObjects[0].SetCellValue(i, "note_dp_seq","");
							sheetObj.SetCellValue(i, "note_dp_seq","");
							continue;						
						}
					}else{
						if(sheetObj.GetCellValue(i, "ibflag") != "D") {
							if(sheetObj.GetCellValue(i, "note_dp_seq") == ""){
								sheetObjects[0].SetCellBackColor(i, "note_dp_seq", validColor);
								sheetObjects[0].SelectCell(i, "note_dp_seq");
								ComShowCodeMessage('PRI01042', "note sequence");
								return false;
							}
							if(sheetObj.GetCellValue(i, "note_dp_seq") == "0"){
								sheetObjects[0].SetCellBackColor(i, "note_dp_seq", validColor);
								sheetObjects[0].SelectCell(i, "note_dp_seq");
								ComShowCodeMessage('PRI01042', "note sequence more than 0");
								return false;
							}
							if(sheetObj.GetCellValue(i, "note_dp_seq").length > 1 && sheetObj.GetCellValue(i, "note_dp_seq").substring(0, 1) == "0"){
								sheetObjects[0].SetCellBackColor(i, "note_dp_seq", validColor);
								sheetObjects[0].SelectCell(i, "note_dp_seq");
								ComShowCodeMessage('PRI01042', "valid number on note sequence");
								return false;
							}
						}
					}
					sheetObjects[0].SetCellBackColor(i, "note_dp_seq", baseColor);
					if(sheetObj.GetCellValue(i, "note_dp_seq") == ""){
						validRowCnt++;
					}
				}
			}
	  	if(rCnt == 0){
	  		return true;
	  	}
	  	// exception logic in the case where any of note data aren't entered
	  	if(validRowCnt == sheetObjects[0].RowCount()){
	  		return true;
	  	}
	  	// validate on a case of same Sequence but different Content
	  	var seqDupChk = findArbNoteDupRow(sheetObj, "note_dp_seq");
	  	if(seqDupChk != undefined){
	  		var rtnVal = getNoteSeqDuplicated(sheetObj, seqDupChk);
	      	if(typeof rtnVal == "string"){
	      		sheetObjects[0].SetCellBackColor(rtnVal, "note_dp_seq", validColor);
	      		sheetObjects[0].SelectCell(rtnVal, "note_dp_seq");
	      		ComShowCodeMessage('PRI02023', rtnVal);
	      		return false;
	      	}
	  	}
	  	// validate on a case of same Content but different Sequence
	  	for(var i=1; i<=sheetObj.RowCount(); i++){
	  		sheetObj.SetCellValue(i, "note_ctnt_text", sheetObj.GetCellValue(i, "add_chg_note_ctnt").replace(/\s/gi, ''));
	  	}
	  	var ctntDupChk = findArbNoteDupRow(sheetObj, "note_ctnt_text");
	  	if(ctntDupChk != undefined){
	  		if(!setNoteSeqSynchronized(sheetObj, ctntDupChk)){
	      		return false;
	      	}
	  	}
	  	return true;
	   }

	  /**
	   * Check note seq / content's duplication and Return duplicated rows as array <br>
	   *
	   * @author NYK
	   * @version 2016.08.02
	   */
	  function findArbNoteDupRow(sheetObj, checkStr){
		 var dupArr = sheetObj.ColValueDupRows(checkStr, false, true).split("|");
		 if(dupArr[0] == undefined || dupArr[0] == ""){
			 return;
		 }
		 var dupArrFirst = dupArr[0].split(",");
		 var dupArrRest = dupArr[1].split(",");
		 var dupArrFinal = new Array();
		 var rtnArrFinal = new Array();
		 var finalArrCnt = 0;
		 // logic to find duplicated row number including first base(reference) row in terms of checkStr parameter
		 for(var k=0; k<dupArrFirst.length; k++){
			 dupArrFinal[finalArrCnt] = dupArrFirst[k];
			 for(var l=0; l<dupArrRest.length; l++){
				 if(sheetObj.GetCellValue(parseInt(dupArrFirst[k]), checkStr) == sheetObj.GetCellValue(parseInt(dupArrRest[l]), checkStr)){
					dupArrFinal[finalArrCnt] += "|" + dupArrRest[l];
				 }
			 }
			 finalArrCnt++;
		 }
		 // exclude empty string case in row duplication check
		 for(var i=0; i<dupArrFinal.length; i++){
			 if(sheetObj.GetCellValue(dupArrFinal[i][0], checkStr) == ""){
				 dupArrFinal.splice(i, 1);
				 break;
			 }
		 }
		 // return duplication row array
		 for(var j=0; j<dupArrFinal.length; j++){
			 rtnArrFinal[j] = dupArrFinal[j].split("|");
		 }
		 return rtnArrFinal;
	}
	  
	  /**
	   * After finding duplicated note content with same note sequence, return the first row index of those are duplicated. <br>
	    *
	    * @author NYK
	    * @version 2016.08.02
	   */
	  function getNoteSeqDuplicated(sheetObj, seqDupChk) {
	  	var seqDupArr = new Array();
	  	var seqInitialDupArr = new Array();
	  	var seqRestDupArr = new Array();
	  	var wrongCnt = 0;
	  	var rtnDupRow = "";
	  	var rtnDupCtnt = "";
	  	for(var i=0; i<seqDupChk.length; i++){
	  		if(seqDupChk[i].length <= 1){
	  			continue;
	  		}else{
	  			// consider note sequences made in UI tab as target of exisiting note sequences for comparison
	  			seqDupArr.length = 0;
	  			seqInitialDupArr.length = 0;
	  			seqRestDupArr.length = 0;
	  			for(var j=0; j<seqDupChk[i].length; j++){
	  				if(sheetObj.GetCellValue(seqDupChk[i][j], "type") == "C"){
						seqInitialDupArr.push(seqDupChk[i][j]);
					}else{
						seqRestDupArr.push(seqDupChk[i][j]);
					}
	  				seqDupArr.push(sheetObj.GetCellValue(seqDupChk[i][j], "add_chg_note_ctnt"));
	  			}
	  		}
	  		// return note sequence that is different to other note sequence with same content
    		// duplicated content check is based on only text, not considering empty space on it
	  		for(var k=0; k<seqDupArr.length; k++){
    			for(var h=k+1; h<seqDupArr.length; h++){
    				if(seqDupArr[k].replace(/\s/gi, '') != seqDupArr[h].replace(/\s/gi, '')){
    					wrongCnt++;
    					if(seqRestDupArr.length == 0){
    						rtnDupCtnt = sheetObj.GetCellValue(seqInitialDupArr[0], "add_chg_note_ctnt");
    					}else{
    						rtnDupCtnt = sheetObj.GetCellValue(seqRestDupArr[0], "add_chg_note_ctnt");
    					}
    					for(var l=0; l<seqInitialDupArr.length; l++){
    						if(sheetObj.GetCellValue(seqInitialDupArr[l], "add_chg_note_ctnt").replace(/\s/gi, '') != rtnDupCtnt.replace(/\s/gi, '')){
    							rtnDupRow = seqInitialDupArr[l];
    							break;
    						}
    					}
    					break;
    				}
    			}
    			break;
    		}
	  		if(wrongCnt > 0){
	  			return rtnDupRow;
	  		}
	  	}
	  	return true;
	  }
	  
	  /**
	   * Synchronize note sequence equally based on same content <br>
	    *
	    * @author NYK
	    * @version 2016.08.02
	   */
	  function setNoteSeqSynchronized(sheetObj, ctntDupArr) {
	  	var syncArr = new Array();
	  	var allSyncCnt = 0;
	  	var rCnt = sheetObj.RowCount();
	  	// Find minimum value on same note sequence rows
	  	for(var i=0; i<ctntDupArr.length; i++){
	  		var eachSyncCnt = 0;
	  		var minValArr = new Array();
	  		minValArr[0] = ctntDupArr[i];
	  		minValArr[1] = new Array();
	  		var tmpMinArr = new Array();
	  		for(j=0; j<ctntDupArr[i].length; j++){
	  			minValArr[1].push(sheetObj.GetCellValue(ctntDupArr[i][j], "note_dp_seq"));
	  			if(sheetObj.GetCellValue(ctntDupArr[i][j], "type") == "C"){
	  				continue;
	  			}
	  			tmpMinArr.push(sheetObj.GetCellValue(ctntDupArr[i][j], "note_dp_seq"));
	  		}
	  		if(tmpMinArr[0] == undefined){
	  			minValArr[2] = Math.min.apply(Math, minValArr[1]);
	  		}else{
	  			minValArr[2] = Math.min.apply(Math, tmpMinArr);
	  		}
	      	// Check whether same content is inputted with different sequence
	  		if(tmpMinArr[0] != undefined){
	  			for(var k=0; k<minValArr[1].length; k++){
	  				if(sheetObj.GetCellValue(minValArr[0][k], "type") == "C"){
	  					if(sheetObj.GetCellValue(minValArr[0][k], "note_dp_seq") != minValArr[2]){
		  					eachSyncCnt++;
		  				}
	  				}
	  			}
	  		}else{
	  			for(var k=0; k<minValArr[1].length; k++){
		  			for(var h=k+1; h<minValArr[1].length; h++){
		  				if(minValArr[1][k] != minValArr[1][h]){
		  					eachSyncCnt++;
		  				}
		  			}
		  		}
	  		}
	  		if(eachSyncCnt > 0){
	  			syncArr.push(minValArr);
	  			allSyncCnt++;
				}
	  	}
	  	// Show soft warning(option) to synchronize note sequence based on content
	  	if(allSyncCnt>0){
	     		if(ComShowCodeConfirm('PRI02024')){
	     			for(var i=0; i<syncArr.length; i++){
	     				for(var j=0; j<syncArr[i][0].length; j++){
	     					if(sheetObj.GetCellValue(syncArr[i][0][j], "type") == "P"){
	     						continue;
	     					}
	     					sheetObjects[0].SetCellValue(syncArr[i][0][j], "note_dp_seq", syncArr[i][2]);
	     				}
	         		}
	     		}
	  		}
	  	 return true;
	  }
