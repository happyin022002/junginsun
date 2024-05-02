/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0040.js
*@FileTitle  :  Target VVD/Supply Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESM_SAQ_0040 :  business script for ESM_SAQ_0040
 */
var sheetObjects = new Array();
var comObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var currentTabIndex = 1;
var saveParams = "";
var msgArr = new Array();
var btn_name = ""; //DownExcel에서 사용하기 위해서

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[1];
    var sheetObject1 = sheetObjects[0];
    var formObject = document.form;
    try {
        btn_name = srcName;
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_confirm":
                doActionIBSheet(sheetObjects[2], formObject, MODIFY01);
                break;
            case "btn_cancelconfirmation":
                doActionIBSheet(sheetObjects[2], formObject, MODIFY02);
                break;
            case "btn_skdcopy":
                doActionIBSheet(sheetObjects[2], formObject, MODIFY05);
                break;
                // case "btn_cancelskdcopy":
                //      	doActionIBSheet(sheetObjects[2],formObject,MODIFY04);
                //     break;
            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;
            case "btn_save":
                if (!ComIsBtnEnable("btng_edit")) {
                    ComShowMessage(getMsg("SAQ90137"));
                    return;
                }
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;
            case "btn_new":
                if (checkModifiedSheet(sheetObject)) {
                    if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                        return;
                    }
                }
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                formObject.reset();
                setEditable();
                break;
            case "btn_downexcel":
                doActionIBSheet(sheetObjects[currentTabIndex], formObject, IBDOWNEXCEL);
                break;
            case "btng_edit":
                setEditable(true);
                break;
            case "btng_disable":
                openFilterDisablePopup(sheetObject, 1, 0, 552, 60, 3);
                break;
            case "btng_ok":
                var existsEmpty = false;
                var rows = sheetObject.FindCheckedRow("row_sel");
                rows = rows.split("|");
                for (var i = 0; i < rows.length; i++) {
                    if (sheetObject.GetCellValue(rows[i] * 1, "e_bsa_grp_cd") == "") {
                        existsEmpty = true;
                        break;
                    }
                }
                if (existsEmpty) {
                    ComShowMessage(getMsg("SAQ90126", "Group Code"));
                    break;
                }
                for (var i = 0; i < rows.length; i++) {
                    sheetObject.SetCellValue(rows[i] * 1, "sprt_grp_cd", sheetObject.GetCellValue(rows[i] * 1, "e_sprt_grp_cd"), 0);
                    sheetObject.SetCellValue(rows[i] * 1, "bsa_grp_cd", sheetObject.GetCellValue(rows[i] * 1, "e_bsa_grp_cd"), 0);
                    sheetObject.SetCellValue(rows[i] * 1, "group", sheetObject.GetCellValue(rows[i] * 1, "e_sprt_grp_cd") + sheetObject.GetCellValue(rows[i] * 1, "e_bsa_grp_cd"), 0);
                }
                //reset group no.
                //reGrouping();
                setEditable(false);
                break;
            case "btng_cancel":
                var rows = sheetObject.FindCheckedRow("row_sel");
                rows = rows.split("|");
                for (var i = 0; i < rows.length; i++) {
                    sheetObject.SetCellValue(rows[i] * 1, "e_sprt_grp_cd", sheetObject.GetCellValue(rows[i] * 1, "sprt_grp_cd"), 0);
                    sheetObject.SetCellValue(rows[i] * 1, "e_bsa_grp_cd", sheetObject.GetCellValue(rows[i] * 1, "bsa_grp_cd"), 0);
                }
                setEditable(false);
                break;
            case "btng_update":
                ComShowMessage(getMsg("SAQ90134"));
                ComOpenWaitCallFunc("update");
                break;
            case "btng_skd":
                var classId = "COM_ENS_0B1";
                var curRow = sheetObjects[currentTabIndex].GetSelectRow();
                var tempVVD = "";

                if (currentTabIndex == 0) {
                    tempVVD = sheetObjects[currentTabIndex].GetCellValue(curRow, "p_vvd");
                } else {
                    tempVVD = sheetObjects[currentTabIndex].GetCellValue(curRow, "vvd");
                }

                var param = "?vvd_cd=" + tempVVD + "&classId=" + classId;
                ComOpenPopup("/opuscntr/" + classId + ".do" + param, 620, 450, "", "0,0,1,1,1,1,1,1,1,1", false);
                break;
        } // end switch 
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage("COM12111");
        } else {
            ComShowMessage(e.message);
        }
    }
}

function update() {
    reloadDestoyFilter();
    var sheetObject = sheetObjects[1];
    var sheetObject1 = sheetObjects[0];
    var row1 = 0;
    var row2 = 0;
    while ((row2 = sheetObject1.FindText("status", "U", row2 + 1)) > 0) {
        row1 = sheetObject.FindText("seq", sheetObject1.GetCellValue(row2, "gseq"));
        if (row1 > 0) {
            copyInfoToGroup(row1, row2);
        }
    }
    row2 = 0;
    while ((row2 = sheetObject1.FindText("status", "D", row2 + 1)) > 0) {
        row1 = sheetObject.FindText("seq", sheetObject1.GetCellValue(row2, "gseq"));
        if (row1 > 0) {
            var status = sheetObject.GetRowStatus(row1);
            sheetObject.SetRowStatus(row1, "D");
            if (status != "I") {
                sheetObject.SetRowHidden(row1, 1);
            }
        }
    }
    row2 = 0;
    while ((row2 = sheetObject1.FindText("status", "I", row2 + 1)) > 0) {
        row1 = sheetObject.DataInsert(-1);
        if (row1 > 0) {
            copyInfoToGroup(row1, row2);
            sheetObject1.SetCellValue(row2, "gseq", sheetObject.GetCellValue(row1, "seq"), 0);
            sheetObject1.SetCellValue(row2, "status", "U", 0);
        }
    }
    row2 = 0;
    while ((row2 = sheetObject1.FindText("status", "M", row2 + 1)) > 0) {
        row1 = sheetObject.FindText("seq", sheetObject1.GetCellValue(row2, "gseq"));
        if (row1 > 0) {
            var status = sheetObject.GetRowStatus(row1);
            sheetObject.SetRowStatus(row1, "D");
            if (status != "I") {
                sheetObject.SetRowHidden(row1, 1);
            }
        }
        row1 = sheetObject.DataInsert(-1);
        if (row1 > 0) {
            copyInfoToGroup(row1, row2);
            sheetObject1.SetCellValue(row2, "gseq", sheetObject.GetCellValue(row1, "seq"), 0);
            sheetObject1.SetCellValue(row2, "status", "U", 0);
        }
    }
    sheetObject.ColumnSort("trd_cd|dir_cd|sub_trd_cd|rlane_cd|week_key|lst_lodg_port_etd_dt", "ASC", "", true);
    //reset group no.
    reGrouping();
    ComBtnEnable("btng_edit");
    tabObjects[0].SetSelectedIndex(1);
    reloadBSAFilter();
}

function setEditable(edit) {
    var sheetObj = sheetObjects[1];
    if (edit != undefined && sheetObj.CheckedRows("row_sel") == 0) {
        sheetObj.RenderSheet(1);
        return;
    }
    if (edit == undefined) {
        edit = false;
    }
    //sheetObj.Redraw = false;
    sheetObj.SetColHidden("row_sel", edit);
    sheetObj.SetColHidden("e_sprt_grp_cd", !edit);
    sheetObj.SetColHidden("e_bsa_grp_cd", !edit);
    frow = 0;
    // 		var rows=sheetObj.GetRangeText("R|I|U", "row_sel");
    // 		rows=rows.split(";");
    // 		for(var i=0 ; i < rows.length ; i++){
    // 			var vals=rows[i].split("=");
    // 			if(vals[1] == "0" &&  filterValidation2(sheetObj,vals[0]*1,edit) == true ){
    // 				sheetObj.SetRowHidden(vals[0]*1,edit);
    // 			}
    // 			else{
    // 				sheetObj.SetCellEditable(vals[0]*1, "upd_rmk",edit);
    // 				if( sheetObj.GetCellValue(vals[0]*1, "e_sprt_grp_cd") == "A" ){
    // 					//sheetObj.CellEditable(vals[0]*1, "e_bsa_grp_cd") = false;
    //     				sheetObj.SetCellEditable(vals[0]*1, "e_bsa_grp_cd",1);
    // 				}else{
    // 				    sheetObj.SetCellEditable(vals[0]*1, "e_bsa_grp_cd",1);
    // 				}
    // 			}
    // 		}
    for (var i = sheetObj.HeaderRows(); i < sheetObj.RowCount() + sheetObj.HeaderRows(); i++) {
        if (sheetObj.GetCellValue(i, "row_sel") == 0 && filterValidation2(sheetObj, i, edit) == true) {
            sheetObj.SetRowHidden(i, edit);
        } else {
            sheetObj.SetCellEditable(i, "upd_rmk", edit);
            if (sheetObj.GetCellValue(i, "e_sprt_grp_cd") == "A") {
                sheetObj.SetCellEditable(i, "e_bsa_grp_cd", 1);
            } else {
                sheetObj.SetCellEditable(i, "e_bsa_grp_cd", 1);
            }
        }
    }

    if (edit) {
        ComBtnDisable("btng_edit");
        ComBtnEnable("btng_ok");
        ComBtnEnable("btng_cancel");
    } else {
        ComBtnEnable("btng_edit");
        ComBtnDisable("btng_ok");
        ComBtnDisable("btng_cancel");
    }
    //sheetObj.Redraw = true;
}

/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comObjects[comboCnt++] = combo_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    optionSetting();
    var sheetResizeFull = true;
    var objs = document.all.tabLayer;

    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        if (i < 2) objs[i].style.display = "Inline";
        initSheet(sheetObjects[i], i + 1);
        if (i < 2) objs[i].style.display = "none";
        ComEndConfigSheet(sheetObjects[i]);
    }

    resizeSheet();

    for (k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
    }

    ComBtnDisable("btng_edit");
    ComBtnDisable("btng_ok");
    ComBtnDisable("btng_cancel");
    //document.form.btn_cancelskdcopy.style.display = "none";
    //document.getElementById("btn_cancelskdcopy").hidden = true;
    var formObj = document.form;
    setYearMonthObject(formObj.year, formObj.quarter);
    trade.SetSelectCode("AES");
    formObj.bound.value = "E";
    // 		formObj.unit.value =1;
    document.form.year.focus();
    trade.ValidChar(2, 1); //영어대문자,숫자포함 도움말 ValidChar 참고


}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:    
			with (sheetObj) {
				var HeadTitle1="Trade|Bound|SubTrade|Lane|Previous|Previous|Previous|Previous|Previous|Updated|Updated|Updated|Updated|Org|Org|Org|Org|Org|Group|Group|Group||||||||||";
				var HeadTitle2="Trade|Bound|SubTrade|Lane|Group|Month|Week|VVD|Supply|Month|Week|VVD|Supply|Quarter|Week|VVD|Supply|Supply|Group|Group|MAX|BSE YR|Quarter|V|V|D|TGT YR|LLP|Ioc|VVD SEQ|Status|SEQ|Key";
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 , ImgWidth:10, ImgHeight:10},
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"p_group",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"p_bse_mon",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"p_bse_wk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"p_vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"p_fnl_bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"u_bse_mon",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"u_bse_wk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"u_vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"u_fnl_bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_wk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Int",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"v_fnl_bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Int",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"fnl_bsa_capa",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sprt_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bsa_grp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"grp_max",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_yr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_qtr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tgt_yr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lst_lodg_port_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vvd_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"status",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gseq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"key",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lst_lodg_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",     Hidden:1,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"week_key",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
				InitColumns(cols);
				SetEditable(0);
				SetImageList(0,ICO_FILTER);
				//		    	     SetRangeBackColor(1, 4, 1, 12,"#777777"); 
				
				SetFocusEditMode(default_edit_mode);
				SetCellImage(0, "rlane_cd",0);
				SetCellImage(1, "p_fnl_bsa_capa",0);
				//	                 SetSheetHeight(460);
			
			}
			break;
			
		case 2:      //sheet1 init
			with (sheetObj) {
				var HeadTitle="Trade\n|Bound|SubTrade|Lane|Group|Year|Month|Week|VVD|Supply| Supply ||Group|Group| Group | Group |Group|Group|Remarks|Disable|BSE YR|Quarter|V| V |D|LLP|ioc|VVD SEQ|Flg|Key|SEQ";
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var strGrp1="A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z";
				var strGrp2="";
				
				for(var i=1 ; i <= 99 ; i++){
					strGrp2 += "|"+(i<10?"0":"")+i;
				}
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0, 	Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30, ImgWidth:10, ImgHeight:10 },
				
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"group",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tgt_yr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bse_mon",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bse_wk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Int",       Hidden:0, 	Width:90,   Align:"Right",   ColMerge:0,   SaveName:"v_fnl_bsa_capa",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",       Hidden:1,  Width:80,  Align:"Right",   ColMerge:0,   SaveName:"fnl_bsa_capa",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"row_sel",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"e_sprt_grp_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30, ComboText:strGrp1, ComboCode:strGrp1},
				{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"e_bsa_grp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30, ComboText:strGrp2, ComboCode:strGrp2},
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sprt_grp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bsa_grp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"b_sprt_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"b_bsa_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"upd_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delt_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, ComboText:"Y|N", ComboCode:"Y|N"},
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_yr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bse_qtr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lst_lodg_port_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vvd_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Status",     Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"key",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lst_lodg_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				{Type:"Text",      Hidden:1,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"week_key",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
				
				InitColumns(cols);	
				SetEditable(1);
				SetImageList(0,ICO_FILTER);
				SetCellImage(0, "rlane_cd",0);
				SetCellImage(0, "v_fnl_bsa_capa",0);
				SetColHidden("e_sprt_grp_cd",1);
				SetColHidden("e_bsa_grp_cd",1);
				SetColHidden("seq",1);
				SetFocusEditMode(default_edit_mode);
				//	                 SetSheetHeight(460);
			}
			break;   
		             
		case 3:     //sheet4 init
			with (sheetObj) {
				var HeadTitle="";
				SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
				{Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
				
				InitColumns(cols);	
				SetEditable(0);
				SetFocusEditMode(default_edit_mode);
				SetSheetHeight(100);
			}
			break;
		} 
}

function resizeSheet() {
    for (i = 0; i < sheetObjects.length - 1; i++) { //Hidden sheet가 마지막에 있음(그래서 제외)
        ComResizeSheet(sheetObjects[i], 50);
    }
}

var searchCond = "";
//handling sheet1 process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            ComOpenWait(true);
            formObj.f_cmd.value = SEARCHLIST;
            searchCond = saqFormString(formObj);
            var rtn = sheetObj.GetSearchData("ESM_SAQ_0040GS.do", searchCond);
            var xmls = rtn.split("+");
            sheetObjects[1].LoadSearchData(xmls[0], {
                Sync: 1
            });

            if (sheetObjects[1].RowCount() > 0) {
                ComBtnEnable("btng_edit");
            } else {
                ComBtnDisable("btng_edit");
            }
            //btnImgEnable("btng_edit", sheetObjects[1].RowCount > 0);
            sheetObjects[0].LoadSearchData(xmls[1], {
                Sync: 1
            });
            var rowCount = sheetObjects[1].RowCount();
            var srow1 = sheetObjects[1].HeaderRows();
            var erow1 = rowCount + srow1;
            var row1 = srow1;
            var srow2 = sheetObjects[0].HeaderRows();
            var erow2 = sheetObjects[0].RowCount() + srow2;
            var row2 = srow2;
            var oldLane = "";
            var lane = "";
            var bsaArr = null;
            var bsa_max = -1;
            var week1 = "";
            var week2 = "";
            var grayColor = "#E1E1E1";
            var redColor = "#FFC8C8";
            var vvd1 = "";
            var vvd2 = "";
            var bsa1 = "";
            var bsa2 = "";
            var frow = 0;
            var isNew = false;
            var laneMax = new Array();
            var tgt_vvd_sts_cd = "X";
            diffenentCount = 0;
            //confirm, cancel confirm, copy등에 사용할 파라메터 저장
            saveParams = saqFormString(formObj);
            //debugMath.log.checked = true;
            if (rowCount == 0) {
                isNew = true;
                ComShowMessage(getMsg("SAQ90132"));
                row2 = 0;
                oldLane = "";
                while ((row2 = sheetObjects[0].FindText("bsa_grp_cd", "00", row2 + 1)) > 0) {
                    lane = sheetObjects[0].GetCellValue(row2, "rlane_cd");
                    var bsa = sheetObjects[0].GetCellValue(row2, "fnl_bsa_capa");
                    if (lane != oldLane) {
                        bsaArr = new Array();
                        bsa_max = sheetObjects[0].GetCellValue(row2, "grp_max") * 1;
                    }
                    var status = sheetObjects[0].GetCellValue(row2, "status");
                    if (bsaArr[bsa] == undefined) {
                        bsa_max += 1;
                        bsaArr[bsa] = bsa_max;
                    }
                    var grp = (bsaArr[bsa] < 10 ? "0" : "") + bsaArr[bsa];
                    sheetObjects[0].SetCellValue(row2, "bsa_grp_cd", grp);
                    oldLane = lane;
                }
                for (row2 = srow2; row2 < erow2; row2++) {
                    row1 = sheetObjects[1].DataInsert(-1);
                    copyInfoToGroup(row1, row2);
                }
                rowCount = sheetObjects[1].RowCount();
                srow1 = sheetObjects[1].HeaderRows();
                erow1 = rowCount + srow1;
                row1 = srow1;
            } else {
                tgt_vvd_sts_cd = sheetObjects[1].GetEtcData("tgt_vvd_sts_cd");
            }
            // Setting R in case COA exist.                 
            // Setting D in case COA doesn't exist/
            for (row1 = srow1; row1 < erow1; row1++) {
                row2 = sheetObjects[0].FindText("key", sheetObjects[1].GetCellValue(row1, "key"));
                if (row2 > 0) {
                    sheetObjects[0].SetCellValue(row2, "p_group", sheetObjects[1].GetCellValue(row1, "group"), 0);
                    sheetObjects[0].SetCellValue(row2, "p_bse_mon", sheetObjects[1].GetCellValue(row1, "bse_mon"), 0);
                    sheetObjects[0].SetCellValue(row2, "p_bse_wk", sheetObjects[1].GetCellValue(row1, "bse_wk"), 0);
                    sheetObjects[0].SetCellValue(row2, "p_vvd", sheetObjects[1].GetCellValue(row1, "vvd"), 0);
                    sheetObjects[0].SetCellValue(row2, "p_fnl_bsa_capa", sheetObjects[1].GetCellValue(row1, "v_fnl_bsa_capa"), 0);
                    sheetObjects[0].SetCellValue(row2, "lst_lodg_port_etd_dt", sheetObjects[1].GetCellValue(row1, "lst_lodg_port_etd_dt"), 0);
                    sheetObjects[0].SetCellValue(row2, "lst_lodg_port_cd", sheetObjects[1].GetCellValue(row1, "lst_lodg_port_cd"), 0);
                    sheetObjects[0].SetCellValue(row2, "key", sheetObjects[1].GetCellValue(row1, "key"), 0);
                    sheetObjects[0].SetCellValue(row2, "week_key", sheetObjects[1].GetCellValue(row1, "week_key"), 0);
                    sheetObjects[0].SetCellValue(row2, "gseq", sheetObjects[1].GetCellValue(row1, "seq"), 0);
                    sheetObjects[0].SetCellValue(row2, "status", "R", 0);
                } else {
                    row2 = sheetObjects[0].DataInsert(-1);
                    sheetObjects[0].SetCellValue(row2, "trd_cd", sheetObjects[1].GetCellValue(row1, "trd_cd"), 0);
                    sheetObjects[0].SetCellValue(row2, "dir_cd", sheetObjects[1].GetCellValue(row1, "dir_cd"), 0);
                    sheetObjects[0].SetCellValue(row2, "sub_trd_cd", sheetObjects[1].GetCellValue(row1, "sub_trd_cd"), 0);
                    sheetObjects[0].SetCellValue(row2, "rlane_cd", sheetObjects[1].GetCellValue(row1, "rlane_cd"), 0);
                    sheetObjects[0].SetCellValue(row2, "p_group", sheetObjects[1].GetCellValue(row1, "group"), 0);
                    sheetObjects[0].SetCellValue(row2, "p_bse_mon", sheetObjects[1].GetCellValue(row1, "bse_mon"), 0);
                    sheetObjects[0].SetCellValue(row2, "p_bse_wk", sheetObjects[1].GetCellValue(row1, "bse_wk"), 0);
                    sheetObjects[0].SetCellValue(row2, "p_vvd", sheetObjects[1].GetCellValue(row1, "vvd"), 0);
                    sheetObjects[0].SetCellValue(row2, "p_fnl_bsa_capa", sheetObjects[1].GetCellValue(row1, "v_fnl_bsa_capa"), 0);
                    sheetObjects[0].SetCellValue(row2, "lst_lodg_port_etd_dt", sheetObjects[1].GetCellValue(row1, "lst_lodg_port_etd_dt"), 0);
                    sheetObjects[0].SetCellValue(row2, "lst_lodg_port_cd", sheetObjects[1].GetCellValue(row1, "lst_lodg_port_cd"), 0);
                    sheetObjects[0].SetCellValue(row2, "key", sheetObjects[1].GetCellValue(row1, "key"), 0);
                    sheetObjects[0].SetCellValue(row2, "week_key", sheetObjects[1].GetCellValue(row1, "week_key"), 0);
                    sheetObjects[0].SetCellValue(row2, "gseq", sheetObjects[1].GetCellValue(row1, "seq"), 0);
                    sheetObjects[0].SetCellValue(row2, "bse_yr", sheetObjects[1].GetCellValue(row1, "bse_yr"), 0);
                    sheetObjects[0].SetCellValue(row2, "bse_qtr_cd", sheetObjects[1].GetCellValue(row1, "bse_qtr_cd"), 0);
                    sheetObjects[0].SetCellValue(row2, "vsl_cd", sheetObjects[1].GetCellValue(row1, "vsl_cd"), 0);
                    sheetObjects[0].SetCellValue(row2, "skd_voy_no", sheetObjects[1].GetCellValue(row1, "skd_voy_no"), 0);
                    sheetObjects[0].SetCellValue(row2, "skd_dir_cd", sheetObjects[1].GetCellValue(row1, "skd_dir_cd"), 0);
                    sheetObjects[0].SetCellValue(row2, "status", "D", 0);
                }
                checkDifference(row2, grayColor, redColor);
            }
            // 정렬을 한다.
            sheetObjects[0].ColumnSort("trd_cd|dir_cd|sub_trd_cd|rlane_cd", "ASC", "", true);
            sheetObjects[1].ColumnSort("trd_cd|dir_cd|sub_trd_cd|rlane_cd", "ASC", "", true);
            frow = 0;
            //selecting in case SAQ and COA are different.
            while ((frow = sheetObjects[0].FindText("status", "I", frow + 1)) > 0) {
                checkDifference(frow, grayColor, redColor);
            }

            // D,I가 같이 일어 날경우 이는 VVD의 Update처럼 보여줘야 한다. 이를 담당 하고
            // status 는 M으로 한다. 
            processMixStatus(sheetObjects[0], sheetObjects[1]);
            //                 sheetObjects[0].ColumnSort("trd_cd|dir_cd|sub_trd_cd|rlane_cd|week_key|lst_lodg_port_etd_dt","ASC","",true);
            row2 = 0;
            oldLane = "";
            // Setting bsa_rp_cd in case BSA_GRP_CD doesn't exist.
            while ((row2 = sheetObjects[0].FindText("bsa_grp_cd", "00", row2 + 1)) > 0) {
                lane = sheetObjects[0].GetCellValue(row2, "rlane_cd");
                var bsa = sheetObjects[0].GetCellValue(row2, "fnl_bsa_capa");
                if (lane != oldLane) {
                    bsaArr = new Array();
                    bsa_max = sheetObjects[0].GetCellValue(row2, "grp_max") * 1;
                }
                var status = sheetObjects[0].GetCellValue(row2, "status");
                if (status == "I" || status == "U") {
                    if (bsaArr[bsa] == undefined) {
                        bsa_max += 1;
                        bsaArr[bsa] = bsa_max;
                    }
                    var grp = (bsaArr[bsa] < 10 ? "0" : "") + bsaArr[bsa];
                    sheetObjects[0].SetCellValue(row2, "bsa_grp_cd", grp);
                }
                oldLane = lane;
            }
            ////////////////////////////////////////////////////////
            // reset group number
            /*
 	            if(!isNew){
 	                Math.log("isNew ")
     	            reGrouping();
 	            }  */
            ////////////////////////////////////////////////////////
            sheetObjects[1].SetTopRow(0);
            sheetObjects[0].SetTopRow(0);
            sheetObjects[1].SetSelectRow(1);
            sheetObjects[0].SetSelectRow(2);
            if (diffenentCount > 0) {
                ComShowMessage(getMsg("SAQ90133"));
            }
            if (diffenentCount > 0) {
                ComBtnDisable("btng_edit");
            }
            // delt_flg에 따른 font변경
            row2 = 0;
            while ((row2 = sheetObjects[1].FindText("delt_flg", "Y", row2 + 1)) > 0) {
                disableDeltCell(sheetObj, row2);
            }
            //changing status code.
            document.form.status_code.value = tgt_vvd_sts_cd;
            sheetSearchEnd();
            if (formObj.trade.value == "" || formObj.bound.value == "") {
                disableAllButton();
            } else {
                if (document.form.status_code.value != "N") {
                    ComBtnEnable("btng_disable");
                    setEditable();
                }
            }

            if ("Y" == sheetObjects[1].GetEtcData("SAVEYN")) {
                ComBtnDisable("btn_save");
            }

            break;
        case IBSAVE:
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = MULTI;
            ComOpenWait(true);
            var rtn = doSaveSheet(sheetObj, "ESM_SAQ_0040GS2.do", saqFormString(formObj));
            ComOpenWait(false);
            break;
        case MODIFY01: //Confirm
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            sheetObj.DataInsert(-1);
            formObj.f_cmd.value = MODIFY01;
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            ComOpenWait(true);
            var rtn = doSaveSheet(sheetObj, "ESM_SAQ_0040GS2.do", saveParams);
            ComOpenWait(false);
            break;
        case MODIFY02: //Cancel Confirm
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            sheetObj.DataInsert(-1);
            formObj.f_cmd.value = MODIFY02;
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            ComOpenWait(true);
            var rtn = doSaveSheet(sheetObj, "ESM_SAQ_0040GS2.do", saveParams);
            ComOpenWait(false);
            break;
        case MODIFY03: //Notify
            sheetObj.DataInsert(-1);
            formObj.f_cmd.value = MODIFY03;
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            ComOpenWait(true);
            var rtn = doSaveSheet(sheetObj, "ESM_SAQ_0040GS2.do", saveParams);
            ComOpenWait(false);
            break;
        case MODIFY04: //Cancel SKD Copy
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            sheetObj.DataInsert(-1);
            formObj.f_cmd.value = MODIFY04;
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            ComOpenWait(true);
            var rtn = doSaveSheet(sheetObj, "ESM_SAQ_0040GS2.do", saveParams);
            ComOpenWait(false);
            break;

        case MODIFY05: //Notify
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            ComOpenWait(true);
            //retrieving Trade/Bound
            saveParams = replaceParams(saveParams, "f_cmd", MODIFY05);
            var rtn = sheetObj.GetSearchData("ESM_SAQ_0040GS2.do", saveParams);
            sheetObj.LoadSearchData(rtn, {
                Sync: 1
            });
            var msgList = sheetObj.GetEtcData("message");
            if (msgList != "") {
                msgArr = new Array();
                var tmpArr = "";
                var idx = 0;
                if (msgList.constructor == String) {
                    msgArr = getStringToArray(msgList, 1024);
                } else {
                    idx = 0;
                    for (var msgIdx = 0; msgIdx < msgList.length; msgIdx++) {
                        tmpArr = getStringToArray(msgList[msgIdx], 1024);
                        for (var i = 0; i < tmpArr.length; i++) {
                            msgArr[idx] = tmpArr[i];
                            idx++;
                        }
                        msgArr[idx] = "\r\n\r\n";
                        idx++;
                    }
                }
                ComOpenPopup("ESM_SAQ_MSG.do?windowType=" + 1 + "&fontColor=" + "black" + "&fontWeight=&btnFlg=" + true, "500", "400", "notifyPopUp", "1,0", true);
            } else {
                doActionIBSheet(sheetObj, formObj, MODIFY03);
                //          			return false;
            }
            //                 showMsgWindow(sheetObj.GetEtcData("message"),"1","500","400","","",sheetObj.GetEtcData("cfm_flg"));
            ComOpenWait(false);
            break;

        case IBDOWNEXCEL: //excel download
            selectDownExcelMethod(sheetObj);
            break;
    }
}

function callBackExcelMethod(excelType) {
    var sheetObj = sheetObjects[currentTabIndex];
    if (sheetObj.RowCount() < 1) { //no data
        ComShowCodeMessage("COM132501");
        return;
    }
    DownExcel(sheetObj, excelType);
}

function notifyPopUp(rtnVal) {
    var sheetObj = sheetObjects[2];
    var formObj = document.form;
    if (rtnVal == true) {
        doActionIBSheet(sheetObj, formObj, MODIFY03);
    } else {
        return false;
    }
}

function processMixStatus(sheetObj1, sheetObj2) {
    var row1 = 0;
    var week_row = 0;
    var week_key = "";
    var sts = "";
    while ((row1 = sheetObj1.FindText("status", "D", row1 + 1)) > 0) {
        week_key = sheetObj1.GetCellValue(row1, "week_key");
        // Math.log("week_key="+week_key)
        while ((week_row = sheetObj1.FindText("week_key", week_key, week_row + 1)) > 0) {
            sts = sheetObj1.GetCellValue(week_row, "status");
            if (sts == "I") {
                copyDeleteToInsert(sheetObj1, week_row, row1);
                sheetObj1.SetCellValue(week_row, "status", "M", 0);
                sheetObj1.RowDelete(row1, false);
                row1--;
                break;
            }
        }
    }
}

function copyDeleteToInsert(sheetObj1, row1, row2) {
    sheetObj1.SetCellValue(row1, "p_group", sheetObj1.GetCellValue(row2, "p_group"), 0);
    sheetObj1.SetCellValue(row1, "p_bse_mon", sheetObj1.GetCellValue(row2, "p_bse_mon"), 0);
    sheetObj1.SetCellValue(row1, "p_bse_wk", sheetObj1.GetCellValue(row2, "p_bse_wk"), 0);
    sheetObj1.SetCellValue(row1, "p_vvd", sheetObj1.GetCellValue(row2, "p_vvd"), 0);
    sheetObj1.SetCellValue(row1, "p_fnl_bsa_capa", sheetObj1.GetCellValue(row2, "p_fnl_bsa_capa"), 0);
    sheetObj1.SetCellValue(row1, "gseq", sheetObj1.GetCellValue(row2, "gseq"), 0);
    sheetObj1.SetCellValue(row1, "vvd_seq", sheetObj1.GetCellValue(row2, "vvd_seq"), 0);
}

function replaceParams(params, paramName, paramValue) {
    var idx1 = params.indexOf(paramName + "=");
    var idx2 = params.indexOf("&", idx1);
    if (idx2 < 0) {
        idx2 = params.length;
    }
    var v = paramName.length + 1;
    var startStr = params.substring(0, idx1 + v);
    var endStr = params.substring(idx2, params.length);
    var value = startStr + paramValue + endStr;
    return value;
}

function reGrouping() {
    //         var row2 = 0;
    //         while((row2 = sheetObjects[0].FindText("grp_max", "00", row2 + 1)) > 0){
    //             Math.log("row2="+row2);
    //         	var lane = sheetObjects[0].CellValue(row2, "rlane_cd");
    //         	var bsa = sheetObjects[0].CellValue(row2, "fnl_bsa_capa");
    //         	var gseq = sheetObjects[0].CellValue(row2, "gseq");
    //         	var oldLane;
    //         	if(lane != oldLane){
    //         		var bsaArr = new Array();
    //        			var bsa_max = sheetObjects[0].CellValue(row2, "grp_max")*1;
    //         	}
    //         	var status = sheetObjects[0].CellValue(row2, "status");
    //         	//if(status == "R"){
    //         	   	var r = sheetObjects[1].FindText("seq", gseq);
    //         	    if( sheetObjects[1].CellValue(r, "sprt_grp_cd") == "A" ){
    //         	        bsa = sheetObjects[1].CellValue(r, "fnl_bsa_capa");
    //                 	if(bsaArr[bsa] == undefined){
    //                 		bsa_max += 1;
    //                 		bsaArr[bsa] = bsa_max;
    //                 	}
    //                 	var grp = (bsaArr[bsa]<10?"0":"") + bsaArr[bsa];
    //                 	
    //                 	Math.log("r=========>"+r+",gseq="+gseq+",bsa="+bsa+",grp="+grp+",bsaArr[bsa]="+bsaArr[bsa]);
    //             	    sheetObjects[0].CellValue(row2, "bsa_grp_cd") = grp;
    //                 	sheetObjects[1].CellValue2(r, "bsa_grp_cd") = grp;
    //                 	sheetObjects[1].CellValue2(r, "e_bsa_grp_cd") = grp;
    //                 	sheetObjects[1].CellValue2(r, "b_bsa_grp_cd") = grp;
    //                 	sheetObjects[1].CellValue2(r, "group") = "A"+ grp;
    //             	}
    //         	//}
    //         	oldLane = lane;
    //         }    
    var RowCount = sheetObjects[1].RowCount();
    var srow1 = sheetObjects[1].HeaderRows();
    var erow1 = RowCount + srow1;
    var row1 = srow1;
    for (row1 = srow1; row1 < erow1; row1++) {
        var row2 = sheetObjects[0].FindText("key", sheetObjects[1].GetCellValue(row1, "key"));
        if (row2 > 0 && (sheetObjects[1].GetCellValue(row1, "group") != sheetObjects[0].GetCellValue(row2, "sprt_grp_cd") + sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"))) {
            sheetObjects[1].SetCellValue(row1, "group", sheetObjects[0].GetCellValue(row2, "sprt_grp_cd") + sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"), 0);
            sheetObjects[1].SetCellValue(row1, "sprt_grp_cd", sheetObjects[0].GetCellValue(row2, "sprt_grp_cd"), 0);
            sheetObjects[1].SetCellValue(row1, "bsa_grp_cd", sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"), 0);
            sheetObjects[1].SetCellValue(row1, "e_sprt_grp_cd", sheetObjects[0].GetCellValue(row2, "sprt_grp_cd"), 0);
            sheetObjects[1].SetCellValue(row1, "e_bsa_grp_cd", sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"), 0);
        }
    }
}

function copyInfoToGroup(row1, row2) {
    sheetObjects[1].SetCellValue(row1, "trd_cd", sheetObjects[0].GetCellValue(row2, "trd_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "dir_cd", sheetObjects[0].GetCellValue(row2, "dir_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "sub_trd_cd", sheetObjects[0].GetCellValue(row2, "sub_trd_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "rlane_cd", sheetObjects[0].GetCellValue(row2, "rlane_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "group", sheetObjects[0].GetCellValue(row2, "sprt_grp_cd") + sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "tgt_yr", sheetObjects[0].GetCellValue(row2, "tgt_yr"), 0);
    sheetObjects[1].SetCellValue(row1, "bse_mon", sheetObjects[0].GetCellValue(row2, "bse_mon"), 0);
    sheetObjects[1].SetCellValue(row1, "bse_wk", sheetObjects[0].GetCellValue(row2, "bse_wk"), 0);
    sheetObjects[1].SetCellValue(row1, "vvd", sheetObjects[0].GetCellValue(row2, "vvd"), 0);
    sheetObjects[1].SetCellValue(row1, "v_fnl_bsa_capa", sheetObjects[0].GetCellValue(row2, "v_fnl_bsa_capa"), 0);
    sheetObjects[1].SetCellValue(row1, "fnl_bsa_capa", sheetObjects[0].GetCellValue(row2, "fnl_bsa_capa"), 0);
    //sheetObjects[1].CellValue2(row1, "e_sprt_grp_cd") = sheetObjects[0].CellValue(row2, "sprt_grp_cd");
    //sheetObjects[1].CellValue2(row1, "e_bsa_grp_cd") = sheetObjects[0].CellValue(row2, "bsa_grp_cd");
    sheetObjects[1].SetCellValue(row1, "e_sprt_grp_cd", sheetObjects[0].GetCellValue(row2, "sprt_grp_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "e_bsa_grp_cd", sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "sprt_grp_cd", sheetObjects[0].GetCellValue(row2, "sprt_grp_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "bsa_grp_cd", sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "b_sprt_grp_cd", sheetObjects[0].GetCellValue(row2, "sprt_grp_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "b_bsa_grp_cd", sheetObjects[0].GetCellValue(row2, "bsa_grp_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "bse_yr", sheetObjects[0].GetCellValue(row2, "bse_yr"), 0);
    sheetObjects[1].SetCellValue(row1, "bse_qtr_cd", sheetObjects[0].GetCellValue(row2, "bse_qtr_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "vsl_cd", sheetObjects[0].GetCellValue(row2, "vsl_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "skd_voy_no", sheetObjects[0].GetCellValue(row2, "skd_voy_no"), 0);
    sheetObjects[1].SetCellValue(row1, "skd_dir_cd", sheetObjects[0].GetCellValue(row2, "skd_dir_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "lst_lodg_port_etd_dt", sheetObjects[0].GetCellValue(row2, "lst_lodg_port_etd_dt"), 0);
    sheetObjects[1].SetCellValue(row1, "lst_lodg_port_cd", sheetObjects[0].GetCellValue(row2, "lst_lodg_port_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "ioc_cd", sheetObjects[0].GetCellValue(row2, "ioc_cd"), 0);
    sheetObjects[1].SetCellValue(row1, "vvd_seq", sheetObjects[0].GetCellValue(row2, "vvd_seq"), 0);
    sheetObjects[1].SetCellValue(row1, "key", sheetObjects[0].GetCellValue(row2, "key"), 0);
    sheetObjects[1].SetCellValue(row1, "week_key", sheetObjects[0].GetCellValue(row2, "week_key"), 0);
    sheetObjects[1].SetCellValue(row1, "delt_flg", "N", 0);

    // 		sheetObjects[1].SetMergeCell(1, 0, sheetObjects[1].RowCount(), 1);
    // 		sheetObjects[1].SetMergeCell(1, 1, sheetObjects[1].RowCount(), 1);
    // 		sheetObjects[1].SetMergeCell(1, 2, sheetObjects[1].RowCount(), 1);
    // 		sheetObjects[1].SetMergeCell(1, 3, sheetObjects[1].RowCount(), 1);

}

var diffenentCount = 0;

function checkDifference(row, grayColor, redColor) {
    var vvd1 = sheetObjects[0].GetCellValue(row, "p_vvd");
    var vvd2 = sheetObjects[0].GetCellValue(row, "vvd");
    if (vvd1 == vvd2) {
        var bsa1 = sheetObjects[0].GetCellValue(row, "p_fnl_bsa_capa");
        var bsa2 = sheetObjects[0].GetCellValue(row, "v_fnl_bsa_capa");
        if (bsa1 != bsa2) {
            sheetObjects[0].SetRangeBackColor(row, 4, row, 12, grayColor);
            sheetObjects[0].SetRangeBackColor(row, 12, row, 12, redColor);
            sheetObjects[0].SetCellValue(row, "u_bse_mon", sheetObjects[0].GetCellValue(row, "bse_mon"), 0);
            sheetObjects[0].SetCellValue(row, "u_bse_wk", sheetObjects[0].GetCellValue(row, "bse_wk"), 0);
            sheetObjects[0].SetCellValue(row, "u_vvd", sheetObjects[0].GetCellValue(row, "vvd"), 0);
            sheetObjects[0].SetCellValue(row, "u_fnl_bsa_capa", sheetObjects[0].GetCellValue(row, "v_fnl_bsa_capa"), 0);
            if (sheetObjects[0].GetCellValue(row, "status") == "R") {
                sheetObjects[0].SetCellValue(row, "status", "U", 0);
            }
            diffenentCount += 1;
        }
    } else {
        sheetObjects[0].SetRangeBackColor(row, 4, row, 12, grayColor);
        sheetObjects[0].SetRangeBackColor(row, 11, row, 11, redColor);
        sheetObjects[0].SetCellValue(row, "u_bse_mon", sheetObjects[0].GetCellValue(row, "bse_mon"), 0);
        sheetObjects[0].SetCellValue(row, "u_bse_wk", sheetObjects[0].GetCellValue(row, "bse_wk"), 0);
        sheetObjects[0].SetCellValue(row, "u_vvd", sheetObjects[0].GetCellValue(row, "vvd"), 0);
        sheetObjects[0].SetCellValue(row, "u_fnl_bsa_capa", sheetObjects[0].GetCellValue(row, "v_fnl_bsa_capa"), 0);
        if (sheetObjects[0].GetCellValue(row, "status") == "R") {
            sheetObjects[0].SetCellValue(row, "status", "U", 0);
        }
        diffenentCount += 1;
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            var cnt = 0;
            tabObj.InsertItem("Information", "");
            tabObj.InsertItem("VVD Group", "");
            break;
    }
    tabObj.SetSelectedIndex(0);
}

/**
 * Event when clicking Tab
 * activating selected tab items
 */
var b = 0;

function tab1_OnChange(tabObj, nItem) {
    //var formObj = document.form;
    var objs = document.all.tabLayer;
    var beforetab = currentTabIndex;
    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";
    //--------------- important --------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
    //------------------------------------------------------//
    currentTabIndex = nItem;
    changeMandatoryMark();
    resizeSheet();

}

function changeMandatoryMark() {
    return;
    if (currentTabIndex == 2) {
        document.getElementByName("trade").className = "input1";
        document.getElementById("bound").className = "input1";
    } else {
        document.getElementById("trade").className = "input1_1";
        document.getElementById("bound").className = "input1_1";
    }
}

var selectedGetCellValue = "";

function sheet1_OnSelectCell(sheetObj, oldRow, oldCol, newRow, newCol) {
    selectedGetCellValue = sheetObj.GetCellValue(newRow, newCol);
}

function sheet1_OnChange(sheetObj, row, col, val) {
    var oldValue = selectedGetCellValue;
    switch (sheetObj.ColSaveName(col)) {
        case "e_sprt_grp_cd":
            //     		if(val == "A"){
            //     			if(sheetObj.CellValue(row, "b_sprt_grp_cd") == "A"){
            // 	    			sheetObj.CellValue2(row, "e_bsa_grp_cd") = sheetObj.CellValue(row, "b_bsa_grp_cd");
            //     			}
            //     			else{
            //     				var frow = sheetObjects[0].FindText("gseq", sheetObj.CellValue(row, "seq"));
            //     				if(frow > 0){
            //     				    if( sheetObjects[0].CellValue(frow, "bsa_grp_cd") == "00" ){
            //     				        sheetObj.CellValue2(row, "sprt_grp_cd") = "A";
            //     				       reGrouping();
            //     				    }else{
            //     					   sheetObj.CellValue2(row, "e_bsa_grp_cd") = sheetObjects[0].CellValue(frow, "bsa_grp_cd");
            //     				    }
            //     				}
            //     			}
            //     			//sheetObj.CellEditable(row, "e_bsa_grp_cd") = false;
            //     			sheetObj.CellEditable(row, "e_bsa_grp_cd") = true;
            //     		}
            //     		else{
            //     			sheetObj.CellEditable(row, "e_bsa_grp_cd") = true;
            //    			sheetObj.CellValue2(row, "e_bsa_grp_cd") = "";
            //
            //     		}
            sheetObj.SetCellEditable(row, "e_bsa_grp_cd", 1);
            sheetObj.SetCellValue(row, "e_bsa_grp_cd", "", 0);
            break;
        case "e_bsa_grp_cd":
            var grp_cd1 = sheetObj.GetCellValue(row, "e_sprt_grp_cd");
            var grp_cd2 = sheetObj.GetCellValue(row, "e_bsa_grp_cd");
            if (grp_cd2 == "") {
                break;
            }
            var bsa = sheetObj.GetCellValue(row, "fnl_bsa_capa");
            var key = sheetObj.GetCellValue(row, "rlane_cd");
            var frow = 0;
            while ((frow = sheetObj.FindText("rlane_cd", key, frow + 1)) > 0) {
                if (frow == row) {
                    continue;
                }
                if (sheetObj.GetCellValue(frow, "fnl_bsa_capa") != bsa &&
                    sheetObj.GetCellValue(frow, "e_sprt_grp_cd") == grp_cd1 &&
                    sheetObj.GetCellValue(frow, "e_bsa_grp_cd") == grp_cd2) {
                    ComShowMessage(getMsg("SAQ90135"));
                    sheetObj.SetCellValue(row, col, oldValue, 0);
                    sheetObj.focus();
                    sheetObj.SelectCell(row, col);
                    break;
                }
                //     			if(sheetObj.CellValue(frow, "fnl_bsa_capa") == bsa && 
                //     					sheetObj.CellValue(frow, "e_sprt_grp_cd") == grp_cd1 && 
                //     					sheetObj.CellValue(frow, "e_bsa_grp_cd") == grp_cd2){
                //     				ComShowMessage(getMsg("SAQ90136"));
                //     				break;
                //     			}
            }
            /*
     		var formObj=document.form;
     		var param=searchCond;
     		var pos1=param.indexOf("f_cmd=0&");
     		param="f_cmd="+SEARCHLIST01+"&" + param.substring(0, pos1) + param.substring(pos1 + 8);
			param += "&subTrade="+sheetObj.GetCellValue(row, "sub_trd_cd");
			param += "&lane="+sheetObj.GetCellValue(row, "rlane_cd");
			param += "&vvd="+sheetObj.GetCellValue(row, "vvd");
			param += "&group="+sheetObj.GetCellValue(row, "e_sprt_grp_cd")+sheetObj.GetCellValue(row, "e_bsa_grp_cd");
     		Math.log(param);
			//method change[check again]CLT      		sheetObjects[2].DoSearch("ESM_SAQ_0040GS2.do", param );
 			if(sheetObjects[2].RowCount()> 0){
 				if(sheetObjects[2].RowCount()> 1 || sheetObjects[2].FindText(0, bsa) < 0){
     				ComShowMessage(getMsg("SAQ90135"));
     				sheetObj.SetCellValue(row, col,oldValue,0);
     				sheetObj.focus();
     				sheetObj.SelectCell(row, col);
 				}
 				else{
     				ComShowMessage(getMsg("SAQ90136"));
     				sheetObj.SetCellValue(row, col,oldValue,0);
     				sheetObj.focus();
     				sheetObj.SelectCell(row, col);
 				}
 			}
 			*/
            break;
        case "delt_flg":
            disableDeltCell(sheetObj, row);
            break;
    }
}


//Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {}

function lane_OnBlur(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    var finded = comboObj.FindItem(comboObj.GetSelectText(), 2);
    comboObj.SetSelectCode(finded);
}

function disableDeltCell(sheetObj, row) {
    var val = sheetObj.GetCellValue(row, "delt_flg");
    var isItalic = "";
    var color = "";
    if (val == "Y") {
        color = "#C0C0C0";
        isItalic = true;
    } else {
        color = "#2A3848";
        isItalic = false;
    }
    sheetObj.SetCellFont("FontItalic", row, "group", row, "upd_rmk", isItalic);
    sheetObj.SetCellFont("FontStrike", row, "group", row, "upd_rmk", isItalic);
    sheetObj.SetCellFontColor(row, "group", color);
    sheetObj.SetCellFontColor(row, "tgt_yr", color);
    sheetObj.SetCellFontColor(row, "bse_mon", color);
    sheetObj.SetCellFontColor(row, "bse_wk", color);
    sheetObj.SetCellFontColor(row, "vvd", color);
    sheetObj.SetCellFontColor(row, "v_fnl_bsa_capa", color);
    sheetObj.SetCellFontColor(row, "e_sprt_grp_cd", color);
    sheetObj.SetCellFontColor(row, "e_bsa_grp_cd", color);
    sheetObj.SetCellFontColor(row, "upd_rmk", color);
}

function disableDeltCell2(sheetObj, row, val) {
    var isItalic = "";
    var color = "";
    if (val == "Y") {
        sheetObj.SetCellValue(row, "delt_flg", "Y", 0);
        color = "#C0C0C0";
        isItalic = true;
    } else {
        sheetObj.SetCellValue(row, "delt_flg", "N", 0);
        color = "#2A3848";
        isItalic = false;
    }
    sheetObj.SetCellFont("FontItalic", row, "group", row, "upd_rmk", isItalic);
    sheetObj.SetCellFont("FontStrike", row, "group", row, "upd_rmk", isItalic);
    sheetObj.SetCellFontColor(row, "group", color);
    sheetObj.SetCellFontColor(row, "tgt_yr", color);
    sheetObj.SetCellFontColor(row, "bse_mon", color);
    sheetObj.SetCellFontColor(row, "bse_wk", color);
    sheetObj.SetCellFontColor(row, "vvd", color);
    sheetObj.SetCellFontColor(row, "v_fnl_bsa_capa", color);
    sheetObj.SetCellFontColor(row, "e_sprt_grp_cd", color);
    sheetObj.SetCellFontColor(row, "e_bsa_grp_cd", color);
    sheetObj.SetCellFontColor(row, "upd_rmk", color);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
        case IBSAVE:
            for (var i = sheetObj.HeaderRows(); i < sheetObj.RowCount() + sheetObj.HeaderRows(); i++) {
                if (sheetObj.GetCellValue(i, "v_fnl_bsa_capa") == 0 && sheetObj.GetCellValue(i, "v_fnl_bsa_capa") == "" && sheetObj.GetCellValue(i, "delt_flg") == "N") {
                    ComShowMessage(getMsg("SAQ90119", "Supply"));
                    return false;
                }
            }

        case MODIFY01:
        case MODIFY02:
        case MODIFY03:
            if (sheetObjects[0].RowCount() == 0) {
                ComShowMessage(getMsg("SAQ90154"));
                return false;
            }
            break;
    }
    return true;
}

function openFilterPopup(sheetObj, button, shift, x, y, idx) {
    with(sheetObj) {
            var row = MouseRow();
            var col = MouseCol();
            var popupWidth = 200;
            var popupHeight = 200;
            if (row < HeaderRows() && row > -1) {
                var colName = ColSaveName(col);
                var html = null;
                var objName = "";
                if (colName == "rlane_cd") {
                    objName = "LANE_" + idx;
                    popupWidth = 300;
                } else if ((idx == 1 && colName == "p_fnl_bsa_capa") || (idx == 2 && colName == "v_fnl_bsa_capa")) {
                    objName = "BSA_" + idx;
                }
                // Math.log("x="+x+",y="+y)
                var divObj = document.getElementById("DIV__" + objName + "__DIV");
                openDynamicDragPopup(divObj, x, y, popupWidth, popupHeight, sheetObj);
            }
        } // end with	    
}

/**
 * Event when clicking Sheet Header
 */
function sheet2_OnMouseDown(sheetObj, button, shift, x, y) {
    openFilterPopup(sheetObj, button, shift, x, y, 1);
}

/**
 * Event when clicking Sheet Header
 */
function sheet1_OnMouseDown(sheetObj, button, shift, x, y) {
    openFilterPopup(sheetObj, button, shift, x, y, 2);
}

function sheetSearchEnd() {
    ComOpenWait(false);
    changeButtonStatus(document.form.status_code.value);
    reloadLANEFilter();
    reloadBSAFilter();
}

function reloadDestoyFilter() {
    var obj = eval("BSA2_INPUT");
    if (obj.length != undefined) {
        for (var i = 0; i < obj.length; i++) {
            if (obj[i].checked == false) {
                obj[i].checked = true;
            }
        }
    } else {
        if (obj.checked == false) {
            obj[i].checked = true;
        }
    }
    processPopupOK("BSA_2", "BSA2_INPUT");
}

function reloadBSAFilter() {
    var data1 = getFilterBSAData(sheetObjects[0], "p_fnl_bsa_capa", "ASC");
    var data2 = getFilterBSAData(sheetObjects[1], "v_fnl_bsa_capa", "ASC");
    initCheckListDragPopup(data1, "BSA_1", "BSA1_INPUT", "BSA", "Select", "sheetName='sheet2' colName='p_fnl_bsa_capa' ", true);
    initCheckListDragPopup(data2, "BSA_2", "BSA2_INPUT", "BSA", "Select", "sheetName='sheet1' colName='v_fnl_bsa_capa' ", true);
}

function reloadLANEFilter() {
    var data1 = getFilterLANEData(sheetObjects[0]);
    var data2 = getFilterLANEData(sheetObjects[1]);
    var data3 = getFilterLANEData(sheetObjects[1]);
    initCheckListDragPopup2(data1, "LANE_1", "LANE1_INPUT", "Sub Trade", "Lane", "Select", "sheetName='sheet2' colName='rlane_cd' ", true);
    initCheckListDragPopup2(data2, "LANE_2", "LANE2_INPUT", "Sub Trade", "Lane", "Select", "sheetName='sheet1' colName='rlane_cd' ", true);
    initCheckListDragPopup3(data3, "LANE_3", "LANE3_INPUT", "Sub Trade", "Lane", "Select", document.form.bound.value, "sheetName='sheet1' colName='rlane_cd' ", true);
}

function processPreCheck(sheetObj, row, colName) {
    if (sheetObj == sheetObjects[0]) {
        return true;
    } else if (sheetObj == sheetObjects[1]) {
        if (sheetObj.GetRowStatus(row) == "D") {
            return false;
        } else {
            return true;
        }
    }
}

function getFilterBSAData(sheetObj, colName, order) {
    var dataObj = processSortValue(sheetObj, colName, order);
    var data = "";
    var arrData = dataObj.arrData;
    for (var i = 0; i < arrData.length; i++) {
        data += display_Money("" + arrData[i]) + "|";
    }
    if (dataObj.hasNullData == true) {
        data = "|" + data;
    }
    return data;
}

/**
 * Lane 데이터를 필터링한다.
 * 
 * sheet 데이터가 하단에 Add 되기 때문에 정렬이 맞지 않아서 필터테이터 생성에 문제가 발생하여 변경
 * 
 * @param sheetObj
 * @returns {String}
 */
function getFilterLANEData(sheetObj) {
    var data = "";
    var sName = "";
    var rName = "";
    var rtnValue = "";
    var arrAq = "";
    var arrOfc = "";
    var firstColName = "sub_trd_cd";
    var secondColName = "rlane_cd";

    for (i = 2; i <= sheetObj.LastRow(); i++) {
        sName = sheetObj.GetCellValue(i, firstColName);
        rName = sheetObj.GetCellValue(i, secondColName);

        if (arrAq.indexOf(sName) < 0) {
            if (arrAq != "") rtnValue = rtnValue + "&";
            rtnValue = rtnValue + sName + ";";
            arrAq = arrAq + "|" + sName;
        }
        if (arrOfc.indexOf(sName + rName) < 0) {
            var arrSub = arrAq.split("|");
            var startCol = 0;

            if (arrSub[arrSub.length - 1] == sName) {
                rtnValue = rtnValue + rName + "|";
            } else {
                for (j = 0; j < arrSub.length; j++) {
                    if (arrSub[j] == sName) {
                        startCol = rtnValue.indexOf(sName) + sName.length + 1;
                        break;
                    }
                }
                rtnValue = rtnValue.substring(0, startCol) + rName + "|" + rtnValue.substring(startCol);
            }
            arrOfc = arrOfc + "|" + sName + rName;
        }
    }

    data = rtnValue;
    return data;
}

//     function getFilterLANEData(sheetObj){
//        var data="";
// 		var sRow=0;
// 		var rRow=0;
// 		var arr=new Array();
// 		arr[0]=sheetObj.GetCellValue(sheetObj.HeaderRows(),"sub_trd_cd");
// 		arr[arr[0]]=new Array();
// 		arr[arr[0]][0]=sheetObj.GetCellValue(sheetObj.HeaderRows(),"rlane_cd");
// 		var sName="";
// 		var rName="";		
// 		for(i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++){
// 			sName=sheetObj.GetCellValue(i,"sub_trd_cd");
// 			rName=sheetObj.GetCellValue(i,"rlane_cd");
// 			if(arr[sRow]!=sName){
// 				rRow=0;
// 				sRow++;
// 				arr[sRow]=sName;
// 				arr[sName]=new Array();
// 				arr[sName][0]=rName;
// 			}
// 			if(arr[sName][rRow]!= rName){	
// 				rRow++
// 				arr[sName][rRow]=rName;
// 			}
// 		}
// 		for(i=0;i<arr.length;i++){
// 			if (i!=0){
// 				data += "&";
// 			}
// 			data += arr[i]+";";
// 			for(j=0;j<arr[arr[i]].length;j++){
// 				data += arr[arr[i]][j]+"|";
// 				rRow++;
// 			}
// 		}
//         return data;
//     }    

function processSortValue(sheetObj, colName, order) {
    var end = sheetObj.LastRow();
    var vl = "";
    var data = "|";
    var len = 0;
    var returnData = new Object();
    returnData.arrData = new Array();
    returnData.hasNullData = false;
    for (var i = sheetObj.HeaderRows(); i <= end; i++) {
        vl = "" + sheetObj.GetCellValue(i, colName);
        if (processPreCheck(sheetObj, i, colName) == true && data.indexOf("|" + vl + "|") < 0 && vl != "") {
            data += vl + "|";
        } else if (vl == "") {
            returnData.hasNullData = true;
        }
    }
    if (data.length > 1) {
        data = data.substring(1, data.length - 1);
        var arrData = data.split("|");
        returnData.arrData = processSortData(arrData, 0, arrData.length - 1);
    }
    return returnData;
}

function processSortData(arrData, left, right, txt) {
    var pivot = parseInt(arrData[left]);
    //         alert(pivot);
    Math.log(txt + "=START=pivot=" + pivot + ",left=" + left + ",right=" + right);
    Math.log(txt + "=START=arrData=" + arrData);
    var goLeft = left;
    var goRight = right + 1;
    if (right < left) {
        return arrData;
    }
    while (goLeft <= goRight) {
        do {
            goLeft++;
        } while (goLeft < arrData.length && parseInt(arrData[goLeft]) < pivot);
        do {
            goRight--;
        } while (goRight >= 0 && parseInt(arrData[goRight]) > pivot);
        if (goLeft < goRight) {
            var tmp = arrData[goLeft];
            arrData[goLeft] = arrData[goRight];
            arrData[goRight] = tmp;
            // Math.log("swap1 : left="+goLeft+"("+tmp+"),right="+goRight +"("+arrData[goLeft]+") ");
        }
    }
    if (goRight < left || goRight > right) {
        return arrData;
    }
    var tmp = parseInt(arrData[goRight]); //pivot data
    arrData[goRight] = arrData[left];
    arrData[left] = tmp;
    arrData = processSortData(arrData, goRight + 1, right, "RIGHT");
    arrData = processSortData(arrData, left, goRight - 1, "LEFT");
    return arrData;
}

//     function processSortData2(arrData,left,right,txt){
//         var pivot = parseInt(arrData[left]);
//         Math.log(txt+"=START = pivot="+pivot+",left="+left+",right="+right);
//         Math.log(txt+"=START = arrData="+arrData);
//         var goLeft = left;
//         var goRight = right;
//         if( goRight < left ){
//             return arrData;
//         }        
//         while(goLeft <= goRight){
//             while( goLeft < arrData.length ){
//                 if( parseInt(arrData[goLeft]) > pivot ){
//                     break;
//                 }
//                 goLeft++;
//             }
//             while( goRight >= 0 ){
//                 if( parseInt(arrData[goRight]) < pivot ){
//                     break;
//                 }
//                 goRight--;
//             }        
//             if( goLeft < goRight){
//                 var tmp = arrData[goLeft] ;
//                 arrData[goLeft] = arrData[goRight];
//                 arrData[goRight] = tmp;        
//                 Math.log("swap1 : left="+goLeft+"("+tmp+"),right="+goRight +"("+arrData[goLeft]+") ");
//             }      
//         }
// 
//         if( goRight < left || goRight > right){
//             return arrData;
//         }      
//         var tmp = parseInt(arrData[goRight]) ; //pivot data
//         arrData[goRight] = arrData[left];
//         arrData[left] = tmp;   
//
//         Math.log("swap2 : left="+goLeft+"("+arrData[left]+"),right="+goRight+"("+tmp+")");
//         Math.log(txt+"=END   = arrData="+arrData);
//         Math.log(txt+"=END = pivot="+pivot+",left="+left+",goRight="+goRight);
//              
//         arrData  = processSortData2(arrData,goRight+1,right,"RIGHT");  
//         arrData  = processSortData2(arrData,left,goRight-1,"LEFT");   
//         return arrData;
//     }
//     function processSortedValue(sheetObj,colName,order){
//         Math.log("processSortedValue1")
//         var end = sheetObj.LastRow;
//         var bsa = 0;
//         var nodeObj = new Object() ;
//         nodeObj.preObj = null;
//         nodeObj.nextObj = null;
//         nodeObj.value = -1;        
//         var arrValue = new Array();
//         var bsaStr= "|";
//         Math.log("processSortedValue2")
//
//         for(var i = sheetObj.HeaderRows ; i < end ; i++){
//             bsa = sheetObj.CellValue(i,colName);
//             nodeObj = setNodeValue(nodeObj,bsa)
//         }
//         return nodeObj;
//     }
//     function setNodeValue(nodeObj,value){
//         Math.log("setNodeValue1")
//         
//         var returnObj;
//         if( nodeObj.value == bsa ){
//             returnObj = nodeObj;
//         }else if( parseInt(nodeObj.value) == -1 ){
//             nodeObj.value = bsa;   
//             returnObj = nodeObj;
//         }else if( parseInt(nodeObj.value) > parseInt(bsa) ){
//             if( nodeObj.preObj == null ){
//                 var obj = new Object();
//                 obj.value = bsa;
//                 obj.preObj = null;
//                 obj.nextObj = nodeObj;
//                 nodeObj.preObj = obj;
//                 returnObj = obj;
//             }else{
//                 nodeObj = setNodeValue(nodeObj.preObj,bsa);
//                 returnObj = nodeObj;
//             }
//         }else if( parseInt(nodeObj.value) < parseInt(bsa) ){
//             if( nodeObj.nextObj == null ){
//                 var obj = new Object();
//                 obj.value = bsa;
//                 obj.nextObj = null;
//                 obj.preObj = nodeObj;
//                 nodeObj.nextObj = obj;
//                 returnObj = obj;
//             }else{
//                 nodeObj = setNodeValue(nodeObj.nextObj,bsa);
//                 returnObj = nodeObj;
//             }            
//         }
//         Math.log("setNodeValue-end")
//         return returnObj;        
//     }

function sheet1_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
    if (sheetObj.GetEtcData("status") == "OK") {
        document.form.status_code.value = sheetObj.GetEtcData("tgt_vvd_sts_cd");
        changeButtonStatus(document.form.status_code.value);
    }
}

function sheet4_OnSaveEnd(sheetObj, errMsg) {
    ComOpenWait(false);
    if (sheetObj.GetEtcData("status") == "OK") {
        document.form.status_code.value = sheetObj.GetEtcData("tgt_vvd_sts_cd");
        changeButtonStatus(document.form.status_code.value);
    }
}

function disableAllButton() {
    ComBtnDisable("btn_save");
    ComBtnDisable("btng_edit");
    ComBtnDisable("btng_update");
    ComBtnDisable("btn_confirm");
    ComBtnDisable("btn_cancelconfirmation");
    ComBtnDisable("btn_skdcopy");
    ComBtnDisable("btng_disable");
}

function changeButtonStatus(sts) {
    disableAllButton();
    if (sts == "" || sts == "X") { // only save
        ComBtnEnable("btn_save");
        ComBtnEnable("btng_update");
        ComBtnEnable("btng_edit");
        ComBtnEnable("btng_disable");
    } else if (sts == "0") { // only Save,Confirm
        ComBtnEnable("btn_save");
        ComBtnEnable("btng_edit");
        ComBtnEnable("btng_update");
        ComBtnEnable("btn_confirm");
        ComBtnEnable("btng_disable");
    } else if (sts == "C") { // only  Cancel Confirm, Copy
        ComBtnEnable("btn_cancelconfirmation");
        ComBtnEnable("btn_skdcopy");
    } else if (sts == "N") { // only Cancel, Copy
        // ComBtnEnable("btn_cancelskdcopy");
    }
}

//function for filter-popup 
function processPopupOK(objName, inputObjName, html) {
    var divObj = eval(objName);
    var inputObj = eval(inputObjName);
    var inputObjects = new Array();
    var idx = objName.split("_")[1];
    if (idx == "1") {
        inputObjects[0] = parseCheckBoxStr(eval("LANE1_INPUT"), true, "  :true|");
        inputObjects[1] = parseCheckBoxStr(eval("BSA1_INPUT"), true, "  :true|");
    } else {
        inputObjects[0] = parseCheckBoxStr(eval("LANE2_INPUT"), true, "  :true|");
        inputObjects[1] = parseCheckBoxStr(eval("BSA2_INPUT"), true, "  :true|");
        inputObjects[2] = parseCheckBoxStr(eval("LANE3_INPUT"), true, "  :true|");
    }
    if (inputObj.length != undefined) {
        for (var i = 0; i < inputObj.length; i++) {
            processHideRow(divObj, inputObj[i], inputObjects, idx);
        }
    } else {
        processHideRow(divObj, inputObj, inputObjects, idx);
    }
}

function parseCheckBoxStr(obj, isAll, option) {
    var str = "";
    if (isAll == undefined) {
        isAll = true;
    }
    if (option == undefined) {
        option = "";
    }
    if (obj.length != undefined) {
        for (var i = 0; i < obj.length; i++) {
            if (isAll == false) {
                if (obj[i].checked) {
                    str += obj[i].value + ":" + obj[i].checked + "|";
                }
            } else {
                str += obj[i].value + ":" + obj[i].checked + "|";
            }
        }
    } else {
        if (isAll == false) {
            if (obj.checked) {
                str += obj.value + ":" + obj.checked + "|";
            }
        } else {
            str += obj.value + ":" + obj.checked + "|";
        }
    }
    str += option;
    return str;
}

function processHideRow(divObj, inputObj, inputObjects, idx) {
    if (inputObj.id == "LANE3_INPUT") {
        // Loading 후 처음 Filter를 사용할때 oldValue를 인식하지 못하여 undefined가 나와서 이렬경우 True를 설정해 주었음
        if (inputObj.oldValue == undefined) inputObj.oldValue = false;
        if ((inputObj.checked && (inputObj.oldValue == "false" || inputObj.oldValue == false)) || (!inputObj.checked && (inputObj.oldValue == "true" || inputObj.oldValue == true))) {
            var sheetObj = document.getElementById(divObj.getAttribute('sheetName')); //divObj.sheetName ==> divObj.getAttribute('sheetName')  
            var colName = divObj.getAttribute('colName'); //colName ==> divObj.getAttribute('sheetName')
            //var sheetObj=document.getElementById(divObj.sheetName);     
            //var colName=divObj.colName;
            var cols = new Array();
            var values = new Array();
            //Disable
            if (inputObj.checked == true) {
                cols[0] = colName;
                values[0] = inputObj.value;
                var filterCnt = processFilterSheeetDisabletByLane(sheetObjects[1], cols, values, inputObjects, true, idx);
            } else {
                cols[0] = colName;
                values[0] = inputObj.value;
                var filterCnt = processFilterSheeetDisabletByLane(sheetObjects[1], cols, values, inputObjects, false, idx);
            }
            inputObj.oldValue = inputObj.checked;
        }
    } else {
        // Loading 후 처음 Filter를 사용할때 oldValue를 인식하지 못하여 undefined가 나와서 이렬경우 True를 설정해 주었음
        if (inputObj.oldValue == undefined) inputObj.oldValue = true;
        if ((inputObj.checked && (inputObj.oldValue == "false" || inputObj.oldValue == false)) || (!inputObj.checked && (inputObj.oldValue == "true" || inputObj.oldValue == true))) {
            var sheetObj = document.getElementById(divObj.getAttribute('sheetName')); //divObj.sheetName ==> divObj.getAttribute('sheetName')  
            // 탭 선택에 따른 쉬트 선택
            if (currentTabIndex == 0) {
                sheetObj = sheetObjects[0];
            } else {
                sheetObj = sheetObjects[1];
            }
            var colName = divObj.getAttribute('colName'); //colName ==> divObj.getAttribute('sheetName')
            //var sheetObj=document.getElementById(divObj.sheetName);     
            //var colName=divObj.colName;
            var cols = new Array();
            var values = new Array();
            //show.
            if (inputObj.checked == true) {
                cols[0] = colName;
                values[0] = inputObj.value;
                var filterCnt = processFilterSheet0040(sheetObj, cols, values, inputObjects, true, idx);
                //hide.
            } else if (inputObj.checked == false) {
                cols[0] = colName;
                values[0] = inputObj.value;
                var filterCnt = processFilterSheet0040(sheetObj, cols, values, inputObjects, false, idx);
            }
            inputObj.oldValue = inputObj.checked;
        }
    }
}

function processFilterSheet0040(sheetObj, cols, oriValues, inputObjects, isDisplay, idx) {
    //Math.log("processFilterSheet0040 : sheetObj="+sheetObj+",cols="+cols+", oriValues="+oriValues+",inputObjects="+inputObjects+", isDisplay="+isDisplay);
    //Math.log("processFilterSheet0040 : cols.length=" + cols.length);
    var filterCnt = 0;
    sheetObj.ReDraw = false;
    var selRow = 0;
    var flg;
    for (var i = 0; i <= sheetObj.LastRow(); i++) {
        flg = false;
        for (var j = 0; j < cols.length; j++) {
            selRow = sheetObj.FindText(cols[j], oriValues[j], selRow);
            if (selRow < 0) { // not exists.
                break;
            }
        }
        if (selRow >= 0) {
            i = selRow;
            selRow++;
            for (var j = 0; j < cols.length; j++) {
                if (oriValues[j] != sheetObj.GetCellText(i, cols[(j)])) {
                    flg = true;
                    break;
                }
            }
            if (flg == false) {
                if (isDisplay == true) {
                    if (filterValidation(sheetObj, i, cols, inputObjects, idx)) {
                        sheetObj.SetRowHidden(i, !isDisplay);
                    }
                } else {
                    sheetObj.SetRowHidden(i, !isDisplay);
                }
            }
        } else {
            //        	 sheetObj.SetRowHidden(i,!isDisplay);
            break;
        }
    }
    sheetObj.ReDraw = true;
    return filterCnt;
}

function processFilterSheeetDisabletByLane(sheetObj, cols, oriValues, inputObjects, isDisplay, idx) {
    // Math.log("processFilterSheeetDisabletByLane : sheetObj="+sheetObj+",cols="+cols+", oriValues="+oriValues+",inputObjects="+inputObjects+", isDisplay="+isDisplay);
    // Math.log("processFilterSheeetDisabletByLane : cols.length=" + cols.length);
    var filterCnt = 0;
    sheetObj.ReDraw = false;
    var selRow = 0;
    var flg;
    for (var i = 0; i <= sheetObj.LastRow(); i++) {
        flg = false;
        for (var j = 0; j < cols.length; j++) {
            selRow = sheetObj.FindText(cols[j], oriValues[j], selRow);
            if (selRow < 0) { //찾는 값이 없다..
                break;
            }
        }
        if (selRow >= 0) {
            i = selRow;
            selRow++;
            for (var j = 0; j < cols.length; j++) {
                if (oriValues[j] != sheetObj.GetCellText(i, cols[(j)])) {
                    flg = true;
                    break;
                }
            }
            if (flg == false) {
                if (isDisplay == true) {
                    if (filterValidation(sheetObj, i, cols, inputObjects, idx)) {
                        disableDeltCell2(sheetObj, i, "Y");
                    }
                } else {
                    disableDeltCell2(sheetObj, i, "N");
                }
            }
        } else {
            break;
        }
    }
    sheetObj.ReDraw = true;
    return filterCnt;
}

/**
 * handling process for input validation 
 */
function filterValidation(sheetObj, row, cols, inputObjects, idx) {
    var retValue = false;
    var bsa_capa = "";
    if (idx == 1) {
        bsa_capa = "p_fnl_bsa_capa";
    } else {
        bsa_capa = "v_fnl_bsa_capa";
    }
    if (cols[0] == "rlane_cd") {
        if (inputObjects[1].indexOf((sheetObj.GetCellText(row, bsa_capa) + ":true|")) >= 0 && processPreCheck(sheetObj, row, cols[0]) == true) {
            retValue = true;
        }
    } else if (cols[0] == bsa_capa) {
        if (inputObjects[0].indexOf((sheetObj.GetCellText(row, "rlane_cd") + ":true|")) >= 0 && processPreCheck(sheetObj, row, cols[0]) == true) {
            retValue = true;
        }
    }
    // Math.log("filterValidation] cols=" + cols + " retValue=" + retValue);
    return retValue;
}

/*
 * handling process for input validation
 */
function filterValidation2(sheetObj, row, edit) {
    var retValue = false;
    var bsa_capa = "";
    var inputObjects = new Array();
    if (sheetObj == sheetObjects[0]) {
        inputObjects[0] = parseCheckBoxStr(eval("LANE1_INPUT"), true, "  :true|");
        inputObjects[1] = parseCheckBoxStr(eval("BSA1_INPUT"), true, "  :true|");
        bsa_capa = "p_fnl_bsa_capa";
    } else {
        inputObjects[0] = parseCheckBoxStr(eval("LANE2_INPUT"), true, "  :true|");
        inputObjects[1] = parseCheckBoxStr(eval("BSA2_INPUT"), true, "  :true|");
        inputObjects[2] = parseCheckBoxStr(eval("LANE3_INPUT"), true, "  :true|");
        bsa_capa = "v_fnl_bsa_capa";
    }
    if (edit == false) {
        if (inputObjects[1].indexOf((sheetObj.GetCellText(row, bsa_capa) + ":true|")) >= 0 && inputObjects[0].indexOf((sheetObj.GetCellText(row, "rlane_cd") + ":true|")) >= 0) {
            retValue = true;
        }
    } else {
        retValue = true;
    }
    if (retValue == false) {
        Math.log(sheetObj.GetCellValue(row, bsa_capa) + "," + sheetObj.GetCellValue(row, "rlane_cd"))
    }
    return retValue;
}

function openFilterDisablePopup(sheetObj, button, shift, x, y, idx) {
    with(sheetObj) {
        var popupWidth = 200;
        var popupHeight = 200;
        var objName = "";
        objName = "LANE_" + idx;
        popupWidth = 300;
        var divObj = document.getElementById("DIV__" + objName + "__DIV");
        var evtobj = window.event ? window.event : e;
        var tempX = event.clientX + document.body.scrollLeft;
        var tempY = event.clientY + document.body.scrollTop;
        //        openDynamicDragPopup(divObj,x,y,popupWidth,popupHeight,sheetObj);
        //        openDynamicDragPopup(divObj,evtobj.offsetX+1100,evtobj.offsetY+200,popupWidth,popupHeight,sheetObj);
        openDynamicDragPopup(divObj, tempX, tempY, popupWidth, popupHeight, sheetObj);
    }
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("quarter");
    SaqSearchOptionTrade("trade");
    SaqSearchOptionComCode("status_code", "CD01216", true, "X| ");
    SaqSearchOptionBound("bound");
    SaqSearchOptionComCode("unit", "CD00897", false);
}

function callBackReturnString(rtnValue) {
    return rtnValue;
}