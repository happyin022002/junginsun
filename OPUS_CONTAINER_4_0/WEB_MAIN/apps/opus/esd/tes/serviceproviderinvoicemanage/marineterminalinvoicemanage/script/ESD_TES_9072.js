/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9072.js
*@FileTitle  : Revised Volume Popup-On-Dock Rail Charge Invoice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/02
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var sheetObj = sheetObjects[0];
    var formObj = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btng_rowadd":
                var Row = sheetObj.DataInsert(-1);
                sheetObj.SetCellValue(Row, "rvis_ind_flg", 1);
                sheetObj.SetCellValue(Row, "rvis_lgs_cost_cd", formObj.lgs_cost_cd.value);
                sheetObj.SetCellValue(Row, "rvis_vsl_cd", formObj.vvd.value.substring(0, 4));
                sheetObj.SetCellValue(Row, "rvis_skd_voy_no", formObj.vvd.value.substring(4, 8));
                sheetObj.SetCellValue(Row, "rvis_skd_dir_cd", formObj.vvd.value.substring(8, 9));
                sheetObj.SetCellValue(Row, "rvis_cntr_tpsz_cd", formObj.cntr_tpsz_cd.value);
                sheetObj.SetCellValue(Row, "rvis_cntr_sty_cd", formObj.cntr_sty_cd.value);
                sheetObj.SetCellValue(Row, "rvis_tml_inv_tp_cd", 'TM');
                sheetObj.SetCellValue(Row, "rvis_calc_cost_grp_cd", 'TM');
                sheetObj.SetCellValue(Row, "rvis_tml_rvis_tp_cd", 'V');
                sheetObj.SetCellValue(Row, "rvis_calc_tp_cd", 'M');
                sheetObj.SetCellValue(Row, "ctrt_rt", formObj.ctrt_rt.value);
                break;
            case "btn_close":
                ComClosePopup();
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('TES21506');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    var formObj = document.form;
    //alert(formObj.calc_tp_cd.value);
    //doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && formObj.calc_tp_cd.value == 'A') {
        //자동MODE
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    } else if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && formObj.calc_tp_cd.value == 'M') {
        sheetObjects[0].SetColHidden("ctrt_rt", "1");
        //수동MODE
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj ==> , sheetNo ==>  
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet init
			with(sheetObj){
			
				var HeadTitle="STS|Seq.|cntr Seq.|dtl Seq.|rvis Seq.||Cost Code|Rate|CNTR No.|TP|F/M|INV TP|CALC GROUP|RVIS TP|Booking No|bkg_no_split|vsl_cd|skd_voy_no|skd_dir_cd";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tml_so_cntr_list_seq" },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_so_dtl_seq" },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_so_rvis_list_seq" },
							{Type:"CheckBox",  Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rvis_ind_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
							{Type:"Float",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_rt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0	},							
							{Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_tpsz_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_sty_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_inv_tp_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_calc_cost_grp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_rvis_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_calc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				resizeSheet();//SetSheetHeight(260);
				//InitDataValid(0, "rvis_lgs_cost_cd"	, vtEngUpOnly);
				//InitDataValid(0, "rvis_cntr_no"		, vtEngUpOther, "0123456789");
				//InitDataValid(0, "rvis_bkg_no"		, vtEngUpOther, "0123456789");
				SetColProperty(0 ,"rvis_lgs_cost_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"rvis_cntr_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
				SetColProperty(0 ,"rvis_bkg_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			}
		break;
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH01;
            var searchXml = sheetObj.GetSearchData("ESD_TES_9072GS.do", tesFrmQryStr(formObj));
            sheetObj.RemoveAll();
            sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            break;
        case IBSEARCH_ASYNC01: //Retrieve
            formObj.f_cmd.value = SEARCH02;
            var searchXml = sheetObj.GetSearchData("ESD_TES_9072GS.do", tesFrmQryStr(formObj));
            if (searchXml != "") sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            break;
    }
}

function sheet_OnSearchEnd(sheetObj) {
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        sheetObj.SetCellValue(i, "ctrt_rt", document.form.ctrt_rt.value);
    }
}