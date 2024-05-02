/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9190.js
*@FileTitle : Total Amount List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var err_flag = false;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var sheetObject = sheetObjects[0];

    var formObject = document.form;

    try {
        var srcName = window.event.srcElement.getAttribute("name");

        switch (srcName) {

            case "btng_rowadd":
                var Row = sheetObject.DataInsert(-1);
                break;

            case "btn_ok":
                //setParentRvisSheet(sheetObject,formObject,formObject.rh_vol_qty.value);
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                if (err_flag == false) {
                    ComClosePopup();
                }
                break;

            case "btn_close":
                ComClosePopup();
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {ibsheet}	sheet_obj	IBsheet object
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
    var sheetObject = sheetObjects[0];
    var formObject = document.form;

    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }

    doActionIBSheet(sheetObject, formObject, IBSEARCH);
}

/**
 * setting sheet initial values and header
 * @param {ibsheet} sheetObj ==> 
 * @param {int}		sheetNo ==>  
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

    switch(sheetNo) {
         case 1:      //sheet init
            with (sheetObj) {
                /*// setting height
                style.height = 260;

                // setting width
                SheetWidth = mainTable.clientWidth;

                //setting Host information[mandatory][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //Kind of Merge [Option, Default msNone]
                MergeSheet = msHeaderOnly;

               //Edit [Option, Default false]
                Editable = true;

                //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 100);

                //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(10, 0, 0, true);

                // setting function handling header
				InitHeadMode(true, true, false, true, false, false);

                var HeadTitle = "STS|Del.|Seq.|CNTR No.|Caused CNTR|Reason Code";

                //Header information [mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //Data attribute  [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,  30,    daCenter,  true,    "ibflag");
                InitDataProperty(0, cnt++, dtCheckBox,     	30,    daCenter,  true,    "rvis_ind_flg"   );
                InitDataProperty(0, cnt++, dtSeq		,       30,    daCenter,  true,    ""   							,        false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "rvis_cntr_no"					,        false,          "",       dfNone,    0,     true,       true);
                InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "rvis_cuz_cntr_no"	,        false,          "",       dfNone,    0,     true ,       true );

				InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "rvis_rhnd_rsn_cd"			,        false,          "",       dfNone,    0,     true ,       true );
                InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_tml_so_dtl_seq"			,        false,          "",       dfNone,    0,     false ,       false );
                InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_tml_so_rvis_list_seq"			,        false,          "",       dfNone,    0,     false ,       false );
                InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_lgs_cost_cd"			,        false,          "",       dfNone,    0,     false ,       false );
                InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_page_rows"			,        false,          "",       dfNone,    0,     false ,       false );*/
        	 
        	 var HeadTitle="STS|Del.|Seq.|Rate|CNTR No.|Caused CNTR|Reason Code";

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                    {Type:"CheckBox",  Hidden:0,	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rvis_ind_flg" },
                    {Type:"Seq",       	Hidden:0, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      	Hidden:0,  	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_no",               		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Float",      	Hidden:0,  	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_rt",           					KeyField:0,   CalcLogic:"",   Format:"Float",      PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      	Hidden:0,  	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cuz_cntr_no",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      	Hidden:0,  	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_rhnd_rsn_cd",           	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                    {Type:"Text",      	Hidden:1, 	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_so_dtl_seq",        	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      	Hidden:1, 	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_so_rvis_list_seq",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                    {Type:"Text",      	Hidden:1, 	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_lgs_cost_cd",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);

             SetEditable(1);
             resizeSheet();//SetSheetHeight(260);

           }
            break;
    }
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}



// handling sheet process
/**
 * @param {ibsheet}	sheetObj	IBsheet object
 * @param {form}	formObj		form object
 * @param {String}	sAction		Action value
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;

    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH;
            var searchXml = sheetObj.GetSearchData("ESD_TES_9190GS.do", tesFrmQryStr(formObj));
            sheetObj.RemoveAll();
            sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            break;

        case IBSAVE:
            for (var i = sheetObjects[0].HeaderRows(); i < sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount(); i++) {
                //sheetObjects[0].RowFontColor(i) = sheetObjects[0].RgbColor(0, 0, 0);
                //sheetObjects[0].SetRowFontColor(arr_rows[i],"#FF0000");
            }

            err_flag = false;
            var Rows;
            Rows = sheetObj.ColValueDupRows("rvis_cntr_no");
            var arr_rows = Rows.split(',');
            for (var i = 0; arr_rows != '' && i < arr_rows.length; i++) {
                sheetObj.RowFontColor(arr_rows[i]) = sheetObj.RgbColor(255, 0, 0);
                err_flag = true;
                // sheetObj.CellValue(arr_rows[i],"remark") = 'Duplicate';
            }

            if (err_flag == true) {
                ComShowMessage("Please check the column in red.");
                return false;
            }

            formObj.f_cmd.value = MODIFY;
            formObj.rvis_vol_qty.value = getRVISQty();
            var param = sheetObj.GetSaveString();
            var saveXml = sheetObj.GetSaveData("ESD_TES_9190GS.do", param + '&' + tesFrmQryStr(formObj));
            sheetObj.LoadSaveData(saveXml, true);
            break;

    }
}

/**
 * save end event 
 * 
 * @param {ibsheet} sheetObj
 * @return
 */
function sheet_OnSaveEnd(sheetObj) {
    //alert(document.form.opener_row.value + '  /  ' + getRVISQty());
    var opener_obj;
    opener_obj = window.dialogArguments;
    if (!opener_obj) opener_obj = window.opener; //이 코드 추가할것
    if (!opener_obj) opener_obj = parent; //이 코드 추가할것
    opener_obj.t3sheet1.SetCellValue(document.form.opener_row.value, 'rvis_vol_qty', getRVISQty());
    //window.dialogArguments.document.t3sheet1.SetCellValue(document.form.opener_row.value,'rvis_vol_qty',getRVISQty());
}

function sheet_OnSearchEnd(sheetObj) {
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        sheetObj.SetCellValue(i, "ctrt_rt", document.form.ctrt_rt.value);
    }
}

/**
 * 
 * @param {ibsheet}	sheet	IBSheet Object
 * @param {int}		row		row index
 * @param {int}		col		col index
 * @return
 */
function sheet_OnChange(sheet, row, col) {
    var formObj = document.form;
    if (sheet.RowCount > 0) {
        if (sheet.ColSaveName(col) == "rvis_ind_flg") {
            if (sheet.CellSearchValue(row, 'rvis_ind_flg') != sheet.GetCellValue(row, 'rvis_ind_flg')) {
                if (sheet.GetCellValue(row, 'rvis_tml_so_rvis_list_seq') == null || sheet.GetCellValue(row, 'rvis_tml_so_rvis_list_seq') == '') {
                    //						sheet.CellValue(row,'ibflag') = "I";
                    sheet.SetRowStatus(row, "I");
                } else {
                    //						sheet.CellValue(row,'ibflag') = "U";
                    sheet.SetRowStatus(row, "U");
                }
            }
        }
    }
}

/**
 * get rvis count
 *  
 * @return
 */
function getRVISQty() {
    var sheetObj = sheetObjects[0];
    var qty = 0;
    var opener_obj;
    opener_obj = window.dialogArguments;
    if (!opener_obj) opener_obj = window.opener; //이 코드 추가할것
    if (!opener_obj) opener_obj = parent; //이 코드 추가할것
    var cntr_tpsz = opener_obj.t3sheet1.GetCellValue(document.form.opener_row.value, "cntr_tpsz_cd");
    //var cntr_tpsz=document.form.cntr_tpsz_cd.value;

    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'rvis_ind_flg') == 1) {
            qty = parseInt(qty) + 1;
        }
    }

    if (document.form.vol_tr_ut_cd.value == 'T') {
        if (cntr_tpsz == 'D4') {
            return parseFloat(qty) * 2;
        } else if (cntr_tpsz == 'D7') {
            return parseFloat(qty) * 2.25;
        } else if (cntr_tpsz == 'D8') {
            return parseFloat(qty) * 2.4;
        } else if (cntr_tpsz == 'D9') {
            return parseFloat(qty) * 2.4;
        } else if (cntr_tpsz == 'DW') {
            return parseFloat(qty) * 2.65;
        } else if (cntr_tpsz == 'DX') {
            return parseFloat(qty) * 2.25;
        } else {
            return qty;
        }
    }
    return qty;
}