/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9200.js
*@FileTitle  : Vol. Accumulate Method
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/14
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;

/** Event handler processing by button click event */
document.onclick = processButtonClick;

/** Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var sheetObject = sheetObjects[2];
    var formObject = document.form;
    
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;

            case "btn_new":
                formObject.reset();
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                var opener_obj = window.dialogArguments;
                if (!opener_obj) var opener_obj = parent;
                document.form.vndr_seq.value = opener_obj.document.form.vndr_seq.value;
                document.form.ctrt_ofc_cd.value = opener_obj.document.form.ctrt_ofc_cd.value;
                document.form.vndr_lgl_eng_nm.value = opener_obj.document.form.vndr_seq_name.value;
                break;

            case "btns_calendar1":
                var cal = new ComCalendar(); //calendarPopup();
                cal.select(formObject.accm_fm_dt, 'yyyy-MM-dd');
                break;

            case "btns_calendar2":
                var cal = new ComCalendar(); //calendarPopup();
                cal.select(formObject.accm_to_dt, 'yyyy-MM-dd');
                break;

            case "btng_rowadd":
                doActionIBSheet(sheetObject, formObject, IBINSERT);
                break;

            case "btn_delete":
                doActionIBSheet(sheetObject, formObject, IBDELETE);
                break;

            case "btng_save":
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;

            case "btn_ok":
                //ComShowMessage("btn_ok button click");
                ComClosePopup();
                break;

            case "btn_close":
                ComClosePopup();
                break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('TES21025');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list.<br>
 * adding process for list in case of needing batch processing with other items.<br>
 * defining list on the top of source.<br>
 * @param{ibsheet}	sheet_obj	Sheet Object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet.<br>
 * implementing onLoad event handler in body tag.<br>
 * adding first-served functions after loading screen..<br>
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    sheetObjects[0].SetVisible(1);
    sheetObjects[1].SetVisible(1);
    
    /// form value initiate
    with(document.form) {
        /**
            vndr_seq.value="103787"; /// from Opener
            ctrt_ofc_cd.value="TPEBB"; /// Contract Office /// from Opener
            vndr_lgl_eng_nm.value="Asia Pacific Container Terminal"; /// Contract Office Name  /// from Opener
            accm_fm_dt.value="2006-09-14"; ///  /// from Opener
            accm_to_dt.value="2006-09-15"; /// /// from Opener
			 **/
        var opener_obj = window.dialogArguments;
        if (!opener_obj) var opener_obj = parent;
        vndr_seq.value = opener_obj.document.form.vndr_seq.value;
        ctrt_ofc_cd.value = opener_obj.document.form.ctrt_ofc_cd.value;
        vndr_lgl_eng_nm.value = opener_obj.vndr_seq_name.value;
    }
    
    doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
    
    var yd_cd = opener_obj.document.form.yd_cd.value;
    var yd_cd_name = opener_obj.document.form.yd_cd_name.value;
    var exist_gb = "";
    
    for (i = 0; i < sheetObjects[2].RowCount(); i++) {
        if (sheetObjects[2].GetCellValue(i + 1, "3yd_cd") == yd_cd) {
            exist_gb = "Y";
        }
    }
    
    if (exist_gb != "Y") {
        var Row = sheetObjects[2].DataInsert(-1);
        sheetObjects[2].SetCellValue(Row, "3yd_cd", yd_cd);
        sheetObjects[2].SetCellValue(Row, "3yd_nm", yd_cd_name);
    }
}

/**
 * setting sheet initial values and header.<br>
 * param : sheetObj ==> , sheetNo ==>  .<br>
 * adding case as numbers of counting sheets.<br>
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{int,String}	sheetNo		Sheet No
 */
function initSheet(sheetObj, sheetNo) {
	var isSheetNoPrefix=true; 
	var prefix="";
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
				if ( isSheetNoPrefix ) { 
					prefix=sheetNo.toString(); 
				}
				
				var HeadTitle="Del.|STS|Seq.|Yard|Yard Name";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",         KeyField:0,   CalcLogic:"" },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"accm_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ctrt_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"accm_fm_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"accm_to_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_accm_ut_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
							
				InitColumns(cols);
				
				SetEditable(1);
				SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
			}
		break;
		
		case 2:      //sheet2 init
			with(sheetObj){
				if ( isSheetNoPrefix ) { 
					prefix=sheetNo.toString(); 
				}
				
				var HeadTitle="ibflag.|STS|vndr_seq|accm_cost_seq|lgs_cost_cd";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",        KeyField:0,   CalcLogic:"" },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:10 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"accm_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"accm_cost_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"lgs_cost_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
			}
		break;
		
		case 3:      //sheet3 init
			with(sheetObj){
				if ( isSheetNoPrefix ) { 
					prefix=sheetNo.toString(); 
				}
				
				var HeadTitle="Del.|STS|Seq.|Yard|Yard Name";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delflag",      KeyField:0,   CalcLogic:"" },
					{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",       KeyField:0,   CalcLogic:"" },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"accm_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
					{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
					{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				resizeSheet();//SetSheetHeight(ComGetSheetHeight(sheetObj, 8));
			}
		break;
	}    
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[2]);
}

/**
 * handling sheet process. <br>
 * @param {ibsheet}  	sheetObj	Sheet Object
 * @param {String}  	formObj		Form Object
 * @param {String}  	sAction		Action Command
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH;
            var sXml = sheetObj.GetSearchData("ESD_TES_9200GS.do", tesFrmQryStr(formObj)); //ComShowMessage(sXml);
            sheetObj.LoadSearchData(sXml, { Sync: 1 });
            var sxml0 = sheetObj.GetEtcData("sxml0"); // ComShowMessage(sxml0);
            var sxml1 = sheetObj.GetEtcData("sxml1"); // ComShowMessage(sxml1);
            var sxml2 = sheetObj.GetEtcData("sxml2"); // ComShowMessage(sxml2);
            sheetObj.RemoveEtcData();
            sheetObjects[0].LoadSearchData(sxml0, { Sync: 1 });
            sheetObjects[1].LoadSearchData(sxml1, { Sync: 1 });
            sheetObjects[2].LoadSearchData(sxml2, { Sync: 1 });
            sXml = null;
            sxml0 = null;
            sxml1 = null;
            sxml2 = null;
            break;

        case IBSAVE: //Save
            if (ComIsNull(formObj.ctrt_ofc_cd.value)) {
                ComShowCodeMessage('TES10023'); // Please enter Contract Office.
                formObj.ctrt_ofc_cd.focus();
                return false;
            }
            
            if (ComIsNull(formObj.vndr_lgl_eng_nm.value)) {
                ComShowCodeMessage('TES10022'); // Please enter Service Provider.
                formObj.vndr_lgl_eng_nm.focus();
                return false;
            }
            
            if (ComIsNull(formObj.accm_fm_dt.value)) {
                ComShowCodeMessage('TES10122'); // Please enter Period.
                formObj.accm_fm_dt.focus();
                return false;
            }
            
            if (ComIsNull(formObj.accm_to_dt.value)) {
                ComShowCodeMessage('TES10122'); // Please enter Period.
                formObj.accm_to_dt.focus();
                return false;
            }
            
            var element;
            var checkCount = 0;
            var numOfEle = formObj.elements.length;
            var eleTp = "checkbox";
            
            for (var i = 0; i < numOfEle; i++) {
                if (formObj.elements[i].type == eleTp) {
                    if (formObj.elements[i].checked == true) {
                        checkCount++;
                    }
                }
            }
            
            if (checkCount == 0) {
                ComShowCodeMessage('TES10123'); // Please check Cost Code For Volume Accumulate.
                return false;
            }
            
            formObj.f_cmd.value = MULTI;
            doActionSaveAll(sheetObj, formObj, sAction);
            break;

        case IBINSERT:
            var sRow = sheetObj.DataInsert(-1);
            break;

        case IBDELETE:
            formObj.f_cmd.value = REMOVE;
            var sXml = sheetObjects[0].GetSaveData("ESD_TES_9200GS.do", tesFrmQryStr(formObj));
            sheetObj.LoadSaveData(sXml, true);
            var sxml0 = sheetObj.GetEtcData("sxml0"); // ComShowMessage(sxml0);
            var sxml1 = sheetObj.GetEtcData("sxml1"); // ComShowMessage(sxml1);
            var sxml2 = sheetObj.GetEtcData("sxml2"); // ComShowMessage(sxml2);
            sheetObj.RemoveEtcData();
            sheetObjects[0].LoadSearchData(sxml0, { Sync: 1 });
            sheetObjects[1].LoadSearchData(sxml1, { Sync: 1 });
            sheetObjects[2].LoadSearchData(sxml2, { Sync: 1 });
            sXml = null;
            sxml0 = null;
            sxml1 = null;
            sxml2 = null;
            break;
    }
}

/**
 * handling sheet process. <br>
 * @param {ibsheet}  	sheetObj	Sheet Object
 * @param {String}  	formObj		Form Object
 * @param {String}  	sAction		Action Command
 */
function doActionSaveAll(sheetObj, formObj, sAction) {
    var temp;
    var headerInfoArr;
    var dataArr;
    var prefix = "";
    /// sheetObjects[0] --------------
    headerInfoArr = "STS|vndr_seq|accm_seq|ctrt_ofc_cd|accm_fm_dt|accm_to_dt|tml_accm_ut_cd".split("|");
    dataArr = new Array(headerInfoArr.length);
    prefix = "1";
    dataArr[1] = formObj.vndr_seq.value.trim();
    dataArr[2] = "1";
    dataArr[3] = formObj.ctrt_ofc_cd.value;
    dataArr[4] = ComReplaceStr(formObj.accm_fm_dt.value, '-', '');
    dataArr[5] = ComReplaceStr(formObj.accm_to_dt.value, '-', '');
    dataArr[6] = ComGetObjValue(formObj.tml_accm_ut_cd);
    if (dataArr[1].length <= 0) {
        ComShowCodeMessage('COM12114', 'Vendor Information');
        return;
    }
    if (dataArr[3].length <= 4) {
        ComShowCodeMessage('COM12114', 'Contract Office');
        return;
    }
    //        if ( !isDate(dataArr[4]) ) { ComShowCodeMessage('COM12114','Period Start'); return; }
    //        if ( !isDate(dataArr[5]) ) { ComShowCodeMessage('COM12114','Period End'); return; }
    if (dataArr[6].length != 1) {
        ComShowCodeMessage('COM12114', 'UOM');
        return;
    }
    if (sheetObjects[0].GetTotalRows() <= 0) {
        sheetObjects[0].DataInsert(-1);
        sheetObjects[0].SetCellValue(1, prefix + "vndr_seq", dataArr[1]);
        sheetObjects[0].SetCellValue(1, prefix + "accm_seq", dataArr[2]);
    }
    sheetObjects[0].SetCellValue(1, prefix + "ctrt_ofc_cd", dataArr[3]);
    sheetObjects[0].SetCellValue(1, prefix + "accm_fm_dt", dataArr[4]);
    sheetObjects[0].SetCellValue(1, prefix + "accm_to_dt", dataArr[5]);
    sheetObjects[0].SetCellValue(1, prefix + "tml_accm_ut_cd", dataArr[6]);
    /// sheetObjects[1] --------------
    prefix = "2";
    var baseInfoArr = "SVLDFL|SVLDMT|SVLDTS|TPNDFL|TPNDMT|TPNDTS|CGCUFL|CGCUMT|TMNDFL|TMNDMT|TMNDTS|SVLDTM|TPNDTM".split("|");
    dataArr = new Array(baseInfoArr.length); /// checkbox=> sheet grid
    for (var i = 0; i < dataArr.length; i++) {
        eval("dataArr[i]=formObj." + baseInfoArr[i] + ".checked;");
    }
    var nowRowNum = 0;
    sheetObjects[1].RemoveAll();
    for (var i = 0; i < dataArr.length; i++) {
        if (!dataArr[i]) {
            continue;
        }
        sheetObjects[1].DataInsert(-1);
        nowRowNum++;
        sheetObjects[1].SetCellValue(nowRowNum, prefix + "vndr_seq", formObj.vndr_seq.value.trim());
        sheetObjects[1].SetCellValue(nowRowNum, prefix + "accm_seq", "1");
        //sheetObjects[1].CellValue(nowRowNum, prefix+"accm_cost_seq") = i+1;
        sheetObjects[1].SetCellValue(nowRowNum, prefix + "lgs_cost_cd", baseInfoArr[i]);
    }
    /// sheetObjects[2] --------------
    prefix = "3";
    for (var i = 1; i <= sheetObjects[2].RowCount(); i++) {
        if (sheetObjects[2].GetCellValue(i, prefix + "ibflag") != "I" &&
            sheetObjects[2].GetCellValue(i, prefix + "ibflag") != "U") {
            continue;
        }
        temp = sheetObjects[2].GetCellValue(i, prefix + "yd_cd");
        temp = temp.trim();
        if (temp == null || temp.length == 0) {
            ComShowCodeMessage('COM12114', 'Yard Code');
            //mySheet.SelectCell(Row, Col, [EditMode], [EditModeText])
            sheetObjects[2].SelectCell(i, prefix + "yd_cd", true, "");
            return;
        }
    }
    var params = new Array();
    params[0] = sheetObjects[0].GetSaveString(false, false);
    params[1] = sheetObjects[1].GetSaveString(false, false);
    params[2] = sheetObjects[2].GetSaveString(false, false);
    params[3] = tesFrmQryStr(formObj);
    var savexml = sheetObjects[0].GetSaveData("ESD_TES_9200GS.do", ComGetAryJoin(params, "&"));
    sheetObj.LoadSaveData(savexml, true);
    var sxml0 = sheetObj.GetEtcData("sxml0"); // ComShowMessage(sxml0);
    var sxml1 = sheetObj.GetEtcData("sxml1"); // ComShowMessage(sxml1);
    var sxml2 = sheetObj.GetEtcData("sxml2"); // ComShowMessage(sxml2);
    sheetObj.RemoveEtcData();
    sheetObjects[0].LoadSearchData(sxml0, { Sync: 1 });
    sheetObjects[1].LoadSearchData(sxml1, { Sync: 1 });
    sheetObjects[2].LoadSearchData(sxml2, { Sync: 1 });
}

///===== event function ====================================

/**
 * sheet1 Sheet search end event <br>
 * @param {ibsheet}  	sheetObj	IBSheet Object
 * @param {String}  	ErrMsg		Error Message
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) { /// sheet --> form
    if (ErrMsg <= 0) {
        var formObj = document.form;
        if (sheetObjects[0].GetTotalRows() == 1) {
            var headerInfoArr;
            var prefix = "1";
            /// sheetObjects[0] --------------
            headerInfoArr = "STS|vndr_seq|accm_seq|ctrt_ofc_cd|accm_fm_dt|accm_to_dt|tml_accm_ut_cd".split("|");
            prefix = "1";
            formObj.ctrt_ofc_cd.value = sheetObjects[0].GetCellValue(1, prefix + "ctrt_ofc_cd");
            formObj.accm_fm_dt.value = sheetObjects[0].GetCellValue(1, prefix + "accm_fm_dt");
            ComAddSeparator(formObj.accm_fm_dt, "ymd");
            formObj.accm_to_dt.value = sheetObjects[0].GetCellValue(1, prefix + "accm_to_dt");
            ComAddSeparator(formObj.accm_to_dt, "ymd");
            if (sheetObjects[0].GetCellValue(1, prefix + "tml_accm_ut_cd") == "T") {
                formObj.tml_accm_ut_cd[0].checked = true;
            } else {
                formObj.tml_accm_ut_cd[1].checked = true;
            }
        } else {
            formObj.accm_fm_dt.value = '';
            formObj.accm_to_dt.value = '';
            formObj.tml_accm_ut_cd[0].checked = true;
        }
    }
}

/**
 * sheet2 Sheet search end event <br>
 * @param {ibsheet}  	sheetObj	IBSheet Object
 * @param {String}  	ErrMsg		Error Object
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) { /// sheet --> form
    if (ErrMsg <= 0) {
        var formObj = document.form;
        var headerInfoArr;
        var dataArr;
        var prefix = "2";
        var temp;
        /// sheetObjects[1] --------------
        //headerInfoArr = "STS|vndr_seq|accm_seq|accm_cost_seq|lgs_cost_cd".split("|");
        var baseInfoArr = "SVLDFL|SVLDMT|SVLDTS|TPNDFL|TPNDMT|TPNDTS|CGCUFL|CGCUMT|TMNDFL|TMNDMT|TMNDTS|SVLDTM|TPNDTM".split("|");
        dataArr = new Array(baseInfoArr.length); /// checkbox=> sheet grid
        for (var i = 0; i < baseInfoArr.length; i++) {
            if (sheetObj.FindText(prefix + 'lgs_cost_cd', baseInfoArr[i]) == -1) {
                eval("formObj." + baseInfoArr[i] + ".checked=false;");
            } else {
                eval("formObj." + baseInfoArr[i] + ".checked=true;");
            }
        }
    }
}

/**
 * sheet1 Sheet save end event <br>
 * @param {ibsheet}  	sheetObj	IBSheet Object
 * @param {String}  	ErrMsg		Error Object
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if (ErrMsg != null || ErrMsg.length == 0) {
        //loadPage();
    } else {
        ComShowMessage(ErrMsg);
    }
}

/**
 * validation check Yard Code <br>
 **/
function validateYardCode() {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        return false;
    }
    if ((formObj.yd_cd_hidden.value == null || formObj.yd_cd_hidden.value.trim() == '') || formObj.yd_cd.value.trim() != formObj.yd_cd_hidden.value.trim()) {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        tes_getInputValue('is_valid_yd_cd', SEARCH05, 'yd_cd', 'checkValidYardCode');
    }
}

/**
 * Yard Code  Validate Check. <br>
 **/
function checkValidYardCode() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.is_valid_yd_cd.value != undefined && formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value.trim() != '') {
        tmp = formObj.is_valid_yd_cd.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value == 'Y') {
                //formObj.yd_cd_name.value = (tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
                formObj.yd_cd_hidden.value = formObj.yd_cd.value;
                sheetObjects[2].SetCellValue(document.form.row_num.value, 4, (tmp[2] != undefined && tmp[2] != null ? tmp[2] : ''));
            } else {
                formObj.is_valid_yd_cd.value = '';
                formObj.yd_cd_hidden.value = '';
                formObj.yd_cd_name.value = '';
                sheetObjects[2].SetCellValue(document.form.row_num.value, 3, "");
                ComShowCodeMessage('TES10066');
            }
        } else {
            formObj.is_valid_yd_cd.value = '';
            formObj.yd_cd_hidden.value = '';
            formObj.yd_cd_name.value = '';
            sheetObjects[2].SetCellValue(document.form.row_num.value, 3, "");
            ComShowCodeMessage('TES10066');
        }
    } else {
        formObj.is_valid_yd_cd.value = '';
        formObj.yd_cd_hidden.value = '';
        formObj.yd_cd_name.value = '';
        sheetObjects[2].SetCellValue(document.form.row_num.value, 3, "");
        ComShowCodeMessage('TES10066');
    }
}

/**
 * sheet3 Sheet change event <br>
 * @param {ibsheet}  	Sheet	IBSheet Object
 * @param {int,String}	Row		Sheet Row Index/Save Name
 * @param {int,String}	Col		Sheet Column Index/Save Name
 * @param {String}  	Value	Value
 */
function sheet3_OnChange(Sheet, Row, Col, Value) {
    if (Col == 3 && Value != "") {
        document.form.yd_cd.value = Value;
        document.form.row_num.value = Row;
        validateYardCode();
    }
}

/**
 * Input Check. <br>
 * @param {Object}  	obj		Check Object
 */
function chkInput(obj) {
    if (obj.maxLength < getStrLen(obj.value)) {
        obj.value = ''; //substring(obj.value,0,obj.maxLength);
        obj.focus();
        return false;
    }
}

/**
 * @param {Object}	obj    Text Object
 **/
function isNum1(obj) {
    if (!ComIsNumber(obj, '-')) {
        obj.value = '';
    }
}