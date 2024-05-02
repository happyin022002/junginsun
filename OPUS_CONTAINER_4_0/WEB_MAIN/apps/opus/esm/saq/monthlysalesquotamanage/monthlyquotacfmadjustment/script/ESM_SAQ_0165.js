/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0165.jsp
*@FileTitle  : QTA Editing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
     * @extends
     * @class ESM_SAQ_0165 : business script for ESM_SAQ_0165
     */
   function ESM_SAQ_0165() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject  = setSheetObject;
    	this.loadPage        = loadPage;
    	this.initSheet       = initSheet;
    	this.initControl     = initControl;
    	this.doActionIBSheet = doActionIBSheet;
    	this.setTabObject    = setTabObject;
    	this.validateForm    = validateForm;
    }
	var sheetObjects    = new Array();
	var sheetCnt        = 0;
	var isParentRefresh = false;
	var pWindow         = "";
	var lod_col         = 19;
	var grs_rpb_col     = 20;
	var rpb_col         = 21;
	var cm_col         = 22;
	var cmpb_col         = 23;
	var rmrk_col        = 48;
	var pol_col         = 0;
	var pod_col         = 0;
	var userCheck       = "";

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var formObj=document.form;
    var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
    if(ComGetBtnDisable(srcName)) return false;
	//var srcObj=window.event.srcElement;
	var srcObj=ComGetEvent();
   // if(srcObj.GetEnable()!= undefined && !srcObj.GetEnable()) return;
    switch(srcName) {
    	case "btn_retrieve": // retrieve
    		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    		break;
		case "btn_templatedownload":
			if(sheetObjects[0].RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				doActionIBSheet(sheetObjects[0],formObj,IBDOWNEXCEL);
			}

			break;
		case "btn_excelupload":
			doActionIBSheet(sheetObjects[0],formObj,IBLOADEXCEL);
			break;
		case "btn_save":
            // 버튼 클릭시 Save 버튼 비활성화
			doActionIBSheet(sheetObjects[0],formObj,IBSAVE);
			break;
    	case "btn_close":
    	    close();
    	    break;
    	case "btng_laneadd": // Office Add 화면 팝업 by Y.S.CHOI 2008.05.26
            officeAdd("L");
	        break;
    	case "btng_officeadd": // Office Add 화면 팝업 by Y.S.CHOI 2008.04.28
            officeAdd("O");
	        break;
    } // end switch
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	optionSetting();
   	var formObj=document.form;
    for(var i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
   	setRlseYearMonthObject(formObj.bse_yr, formObj.bse_qtr_cd);
   	changeVersion();
   	setTrade();
	ComBtnDisable("btn_save");
	ComBtnDisable("btng_laneadd");
	ComBtnDisable("btng_officeadd");
//    document.form.bse_yr.focus();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
		case 1:
		case 2:
		    with(sheetObj){
	        var formObj=document.form;
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
	        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	        var HeadTitle ;
	        HeadTitle="|Seq|Ver. No|Year|Quarter|T/Q|Trade|Bound|Sub Trade|Lane|VVD|VVD\nGroup|Month|Week|Supply|Regional\nOffice|Regional\nGroup|Area\nDirector|Unit|Volume|G.Rev|GRPB|CM|CPB|CMPB|opfit_uc_amt|full_stvg_uc_amt|full_trsp_uc_amt|mty_stvg_uc_amt|mty_trsp_uc_amt|cntr_fx_uc_amt|chss_fx_uc_amt|agn_comm_ut_amt|biz_act_uc_amt|slt_mgmt_uc_amt|own_vol_act_uc_amt|stp_uc_amt|eq_hld_uc_amt|eq_repo_uc_amt|eq_sim_uc_amt|conv_dir_cd|misc_rev_amt|Cust Group Id|add_tp_cd|Remark";
	        var headers = [ { Text:HeadTitle, Align:"Center"}];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rn",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mqta_rlse_ver_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_yr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bse_qtr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"qta_tgt_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dir_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lane_grp",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_wk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bsa",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rgn_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rhq_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"aq_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"unit",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"lod_qty",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"grs_rev",             KeyField:0,   CalcLogic:"|lod_qty|*|grs_rpb_rev|",Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"grs_rpb_rev",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cm",           		KeyField:0,   CalcLogic:"|lod_qty|*|grs_rpb_rev|-|lod_qty|*|cm_uc_amt|",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cm_uc_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },	             
	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cm_amt",              KeyField:0,   CalcLogic:"|grs_rpb_rev|-|cm_uc_amt|",Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"opfit_uc_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"full_stvg_uc_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"full_trsp_uc_amt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mty_stvg_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"mty_trsp_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cntr_fx_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"chss_fx_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agn_comm_ut_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"biz_act_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slt_mgmt_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"own_vol_act_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"stp_uc_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"eq_hld_uc_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"eq_repo_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"eq_sim_uc_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"conv_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"misc_rev_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:5,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_grp_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"add_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:500,  Align:"Left",    ColMerge:0,   SaveName:"remark",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

	      InitColumns(cols);
	      SetEditable(1);
	      if (sheetNo == 1) resizeSheet();
	      else SetSheetHeight(395);
	      setRowColor(sheetObj, lod_col, rpb_col, cmpb_col);
	      }
		break;
    }
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0], 120);
}

/*
 * rhqAdjSheet setting header title
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
    // disabled save button
   	ComBtnDisable("btn_save");
	switch(sAction) {
		case IBSEARCH:      // retrieve
            if(!validateForm(rhqAdjSheet,formObj,sAction)){
            	break;
            }
            ComOpenWait(true);
//            rhqAdjSheet.redraw=false;
		    formObj.f_cmd.value=SEARCHLIST;
//		    rhqAdjSheet.DoSearch("ESM_SAQ_0165GS.do", saqFormString(formObj) );
		    var sXml = rhqAdjSheet.GetSearchData("ESM_SAQ_0165GS.do ", saqFormString(formObj));
		    if (sXml != "") rhqAdjSheet.LoadSearchData(sXml,{Sync:1} );
		    if (sXml != "") rhqAdjSheet_campare.LoadSearchData(sXml,{Sync:1} );

		    // setting row color[editor:yellow]
		    setRowColor(rhqAdjSheet, lod_col, rpb_col, cmpb_col);
		    colorSetting();
		    ComOpenWait(false);
			document.form.msg.value="";
//			rhqAdjSheet.redraw=true;
    		// Lane, Office Add button control
    		addButton();
			break;
	    case IBDOWNEXCEL:  //excel download
			selectDownExcelMethod(rhqAdjSheet);
			break;
		case IBLOADEXCEL:                  // upload excel
    		// Message Reset
            document.form.msg.value="";
            // sheet 데이터 삭제 후 업로드
		    rhqAdjSheet.RemoveAll();
		    rhqAdjSheet.LoadExcel({ Mode:"HeaderMatch"});
//    	    sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:""});
			break;
		case IBSAVE:                      // SAVE
		    formObj.f_cmd.value=MODIFY01;
            sheetObj.DoSave("ESM_SAQ_0165GS.do", saqFormString(formObj), "ibflag", false);
            ComBtnDisable("btn_save");
            document.form.msg.value="Save successfully.\n"+"====================================================================================\n";
		    break;
	}
}

/**
 * Down Excel 팝업창 이후 값을 받아서 타입을 리턴함
 *
 * excelType
 * AY - 전체 데이터를 Format 적용해서 down 받는 경우
 * DY - 화면에 보이는 데로 Format 적용해서 down 받는 경우
 * AN - 전체 데이터를 Format 적용하지 않고 down 받는 경우
 * DN - 화면에 보이는 데로 Format 적용하지 않고 down 받는 경우
 */
	function callBackExcelMethod(excelType){
	var sheetObj = sheetObjects[0];
	DownExcel(sheetObj, excelType);
}

function setTrade() {
	var obj=document.form;
	var params="ofcCd="      + document.form.ofcCd.value
	         + "&userCheck=XX";  // + userCheck;
	getSelectCodeList(document.form.trd_cd, "SaqMonthlyQuotaTrd", params, true,  new Option('', ''));
}
function year_OnChange(){
	changeVersion()();
	setTrade();
}
function quarter_OnChange(){
	changeVersion();
	setTrade();
}
function changeVersion(){
    var obj=document.form;
    if (obj.bse_yr.value == '' || obj.bse_qtr_cd.value == '') return;
	var params="year="     + obj.bse_yr.value
				+ "&quarter=" + obj.bse_qtr_cd.value;
	var rtn=getCodeList("SaqMonthlyQuotaRlseVersion", params);
	document.form.mqtaRlseVerNo.value=rtn[1].substring(0,6);
}
function qta_tgt_OnChange(rb_qta_tgt_cd) {
    var obj=document.form;
    obj.qtaTgtCd.value=rb_qta_tgt_cd.value;
    ComBtnDisable("btn_save");
    ComBtnDisable("btng_laneadd");
    ComBtnDisable("btng_officeadd");
	rlane_cd_change();
}
function addButton(){
    var formObj=document.form;
    var tgt_cd=formObj.qtaTgtCd.value;
    var ofc_cd=formObj.ofcCd.value;
	ComBtnEnable("btng_laneadd");
	ComBtnEnable("btng_officeadd");
}
// rhqAdjSheet rlane_cd setting
function rlane_cd_change() {
    var formObj=document.form;
    var objRlane=formObj.rlane_cd;
	var params="&mqta_rlse_ver_no=" + formObj.mqtaRlseVerNo.value
	           + "&bse_yr="           + formObj.bse_yr.value
	           + "&bse_qtr_cd="       + formObj.bse_qtr_cd.value
	           + "&qta_tgt_cd="       + formObj.qtaTgtCd.value
	           + "&trd_cd="           + formObj.trd_cd.value
	           + "&dir_cd="           + formObj.dir_cd.value;
	getSelectCodeList(objRlane, "SaqMonCfmQtaRhqLane", params, true, new Option('', ''));
}
// Setting [cm_uc_amt, ra_cm_uc_amt, ra_opfit_uc_amt BackColor]
function colorSetting() {
    var formObj=document.form;
    if(formObj.trd_cd.value == "IAS" || formObj.trd_cd.value == "EMS") {
	    var row=0;
	    var cnt=0;
	    while(1){
	        row=sheetObjects[0].FindText("add_tp_cd", "O", row+1)
	        if(row != -1){
	            // Head Title
	            sheetObjects[0].SetRangeBackColor(0, lod_col+4, 0, lod_col+4,"#FFFF00");
	            // Row
    	        sheetObjects[0].SetRangeBackColor(row, lod_col+4, row, lod_col+4,"#FFFF00");// cm_uc_amt
    	        cnt++;
	        } else {
	            row=0;
    	        break;
	        }
	    }
	    while(1){
	        row=sheetObjects[0].FindText("add_tp_cd", "L", row+1)
	        if(row != -1){
	            // Head Title
	            sheetObjects[0].SetRangeBackColor(0, lod_col+4, 0, lod_col+4,"#FFFF00");
	            // Row
    	        sheetObjects[0].SetRangeBackColor(row, lod_col+4, row, lod_col+4,"#FFFF00");// cm_uc_amt
    	        cnt++;
	        } else {
	            row=0;
    	        break;
	        }
	    }
	    if(cnt == 0){
	        // Head Title
    	    sheetObjects[0].SetRangeBackColor(0, lod_col+4, 0, lod_col+4,"#FFCC33");
	    }
	} else {
	    // Head Title
	    sheetObjects[0].SetRangeBackColor(0, lod_col+4, 0, lod_col+4,"#FFCC33");
	    // Row
	    sheetObjects[0].SetRangeBackColor(1, lod_col+4, sheetObjects[0].lastRow, lod_col+4,"#EFEBEF");
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction){
		case IBSEARCH:
			if(formObj.trd_cd.value == ""){
				ComShowMessage(getMsg("SAQ90126", "Trade"));
//				formObj.trd_cd.focus();
				return false;
			}
			if(formObj.dir_cd.value == ""){
				ComShowMessage(getMsg("SAQ90126", "Bound"));
//				formObj.dir_cd.focus();
				return false;
			}
			if(formObj.mqtaRlseVerNo.value == ""){
				ComShowMessage(getMsg("SAQ90126", "Release Version"));
				return false;
			}
			break;
	}
	return true;
}
/**
 * rhqAdjSheet_OnLoadExcel Event
 */
function rhqAdjSheet_OnLoadExcel(sheetObj, result, code, msg) {
    if(isExceedMaxRow(msg))return; //2014-04-22 공통 요청사항(10,000 Row 제어)
    var sheetObj     = sheetObjects[0];
    var formObj      = document.form;
    var tgt_cd       = formObj.qtaTgtCd.value;
    var ofc_cd       = formObj.ofcCd.value;
    var inclPortFlag = "N"; // disabled POL/POD

    // Sorting Seq
    rhqAdjSheet.ColumnSort("rn", "ASC");
    rhqAdjSheet_campare.ColumnSort("rn", "ASC");

    // setting row color[editor:yellow]
    //setRowColor(sheetObj, lod_col, rpb_col, cmpb_col);
    colorSetting();

    // validation check
    chkValidation(rhqAdjSheet, rhqAdjSheet_campare, formObj, lod_col, grs_rpb_col, rpb_col, rmrk_col, pol_col, pod_col, inclPortFlag, "Y", cmpb_col, cm_col);
}

function chkValidation2(sheetObj1, sheetObj2){
    var row=0;
    var chk_cnt=0;
    var rtn=true;
    if(document.form.trd_cd.value != "IAS" && document.form.trd_cd.value != "EMS") {
        return false;
    }
    for ( row=1; row <= sheetObj1.lastRow; row++ ) {
        for ( col=lod_col+4; col <= lod_col+8; col += 2) {
			chkItem1=sheetObj1.GetCellValue(row, col);
			chkItem2=sheetObj2.GetCellValue(row, col);
			chkItem3=sheetObj2.GetCellValue(row, rmrk_col-1 );    // add_tp_cd
            if ( chkItem3 == "O" || chkItem3 == "L" ) {
                if( chkItem1 != chkItem2 ){
                    sheetObj1.SetRangeBackColor(row, col, row, col,"#FFC864");
                    sheetObj1.SetCellValue(row,0,"U",0);
                    sheetObj1.SetCellValue(row,rmrk_col-1,chkItem3,0);
                } else {
                    sheetObj1.SetRangeBackColor(row, col, row, col,"#FFFF00");// Orange
                }
            }
        }
    }
    return rtn;
}
/**
 * OnSaveEnd Event
 */
function rhqAdjSheet_OnSaveEnd(sheetObj, errMsg) {
    var formObj=document.form;
    doActionIBSheet(sheetObj,formObj,IBSEARCH);
}
//Office Add Pop-up
function officeAdd(add_tp_cd){
    var formObj  =document.form;
    var width    =800;
    var height   =630;
	var params="mqtaRlseVerNo="    + formObj.mqtaRlseVerNo.value
	            + "&org_cd="          + formObj.ofcCd.value
				+ "&bse_yr="          + formObj.bse_yr.value
				+ "&bse_qtr_cd="      + formObj.bse_qtr_cd.value
				+ "&qtaTgtCd="        + formObj.qtaTgtCd.value
				+ "&trd_cd="          + formObj.trd_cd.value
				+ "&dir_cd="          + formObj.dir_cd.value
				+ "&rlane_cd="        + formObj.rlane_cd.value
				+ "&add_tp_cd="       + add_tp_cd;

	ComOpenPopup("ESM_SAQ_0167.do?"+params, width, height, "callbackPopup", "0,0", true);
}

function callbackPopup(value){
    if(value == "OK"){
         doActionIBSheet(rhqAdjSheet,document.form,IBSEARCH);
    }
}
function optionSetting() {
	SaqSearchOptionYear("bse_yr");
	SaqSearchOptionQuarter("bse_qtr_cd");
	SaqSearchOptionBound("dir_cd", false);
}

