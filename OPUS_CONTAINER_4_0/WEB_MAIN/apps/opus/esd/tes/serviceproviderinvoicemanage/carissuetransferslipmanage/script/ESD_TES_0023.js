/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0023.js
*@FileTitle : Marine Terminal Invoice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var asaDetailFlg = "";

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;

            case "btn_new":
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                formObject.reset();
                break;

            case "btn_vndr":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3);
                // radio PopUp  
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 666, 515, 'getVender', dispaly);
                } else {
                    ComShowMessage(ComGetMsg('TES10004'));
                    return;
                }
                break;

            case "btng_detail":
                retrieve_detail();
                break;

            case "btns_calendar1":
                var cal = new ComCalendar();
                cal.select(formObject.inv_cfm_dt, 'yyyy-MM-dd');
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES21025'));
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * retrieve detail Invoice data
 */
function retrieve_detail() {
    if (sheetObjects[0].GetSelectRow() == 0) {
        ComShowMessage(ComGetMsg('TES25017'))
        return false;
    }

    if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 0) == -1 || sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 1) == -1 ||
        sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 2) == -1 || sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 3) == -1) {
        ComShowMessage(ComGetMsg('TES25017'));
        return false;

    }

    var inv_cfm_dt = document.form.inv_cfm_dt.value;
    var vndr_seq = (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 2) == -1 ? "" : sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 2));
    var vndr_seq_name = encodeURI((sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 3)) == -1 ? "" : (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 3)));
    var cnt_inv = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 4);
    var curr_cd = (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 5) == -1 ? "" : sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 5));
    var total_amt = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 6);
    var iss_dt = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 7);
    var rcv_dt = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 8);
    var gen_pay_term_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 9);
    var gen_pay_term_desc = (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 10) == -1 ? "" : sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 10));
    var payment_due_dt = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 11);
    var pay_term_tp_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 12);
    var ASANOGB = getElementValue(document.form, 'radio', 'asanogb');
    var pay_group_cd = getElementValue(document.form, 'radio', 'pay_group_cd');
    var cost_ofc_cd = (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 1) == -1 ? "" : sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 1));
    var detailUrl = "ESD_TES_0024.do?pgmNo=ESD_TES_0024&parentPgmNo=ESD_TES_M001&inv_cfm_dt=" + inv_cfm_dt +
        "&vndr_seq=" + vndr_seq +
        "&vndr_seq_name=" + vndr_seq_name +
        "&cnt_inv=" + cnt_inv +
        "&curr_cd=" + curr_cd +
        "&total_amt=" + total_amt +
        "&iss_dt=" + iss_dt +
        "&rcv_dt=" + rcv_dt +
        "&gen_pay_term_cd=" + gen_pay_term_cd +
        "&gen_pay_term_desc=" + gen_pay_term_desc +
        "&payment_due_dt=" + payment_due_dt +
        "&pay_term_tp_cd=" + pay_term_tp_cd +
        //"&asanogb="+ASANOGB; 
        "&cost_ofc_cd=" + cost_ofc_cd +
        "&asanogb=" + ASANOGB +
        "&pay_group_cd=" + (pay_group_cd != undefined && pay_group_cd != null ? pay_group_cd : '') +
        "&sysCommUiTitle=CSR Creation(Detail)&sysCommUiNavigation=TML S/O > Invoice > CSR Creation(Detail)";
    location.href = detailUrl;
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {ibsheet}	sheet_obj   sheet object
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
    document.form.f_cmd.value = SEARCH01;
    document.form.sel_ofc_cd.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 1);
    sheetObjects[1].DoSearch("ESD_TES_0023GS.do", tesFrmQryStr(document.form));
}

/**
 * setting sheet initial values and header
 * param : sheetObj ==> , sheetNo ==>  
 * adding case as numbers of counting sheets
 * @param {ibsheet} sheetObj 	==> , 
 * @param {int} 	sheetNo 	==>  
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
			
				var HeadTitle="SEQ|Cost Office|S/P Code|S/P Name|No of Invoice|Invoice Currency|Total Amount" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"vndr_seq_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_inv",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"total_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"iss_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"gen_pay_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"gen_pay_term_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"payment_due_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:0,   SaveName:"pay_term_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(0);
				//no support[check again]CLT style.height=GetSheetHeight(13);
				
				// SetSheetHeight(ComGetSheetHeight(sheetObj, 13));
				resizeSheet();
			}
		break;
		
		case 2:      //sheet1 init
			with(sheetObj){
			
				var HeadTitle="" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"inv_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(0);
				//no support[check again]CLT style.height=GetSheetHeight(13);
				// SetSheetHeight(ComGetSheetHeight(sheetObj, 13));
				resizeSheet();
			}
		break;
	}
}

/**
 * handling sheet process
 * 
 * @param	{ibsheet} 	sheetObj	sheet object
 * @param 	{form}		formObj		form object
 * @param 	{String}	sAction		Action value
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCHLIST01;
            sheetObj.DoSearch("ESD_TES_0023GS.do", tesFrmQryStr(formObj));
            break;
    }
}

/**
 * MInimize click event
 * @param {Strig}	nItem			
 */
function Minimize(nItem) {
    var objs = document.all.item("showMin");
    if (nItem == "1") {
        objs.style.display = "none";
        //no support[check again]CLT sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(20);
        sheetObjects[0].SetSheetHeight(ComGetSheetHeight(sheetObj, 20));
        sheetObjects[0].GetSheetHeight(20);
        sheetObjects[0].focus();
        //no support[check again]CLT 					sheetObjects[0].ViewRows=20;
    } else {
        objs.style.display = "inline";
        //no support[check again]CLT 	    sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(10);
        sheetObjects[0].SetSheetHeight(ComGetSheetHeight(sheetObj, 10));
        sheetObjects[0].focus();
        //no support[check again]CLT 					sheetObjects[0].ViewRows=10;
    }
}

/** 
 * sheet1 dubble click event
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @return
 */
function sheet1_OnDblClick(sheetObj, row, col) {
    retrieve_detail(sheetObj);
}

/**
 * sheet1 search end event
 * @param {ibsheet}	sheetObj	IBsheet object
 * @param {String}	errMsg		err message
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, code, errMsg) {
    if (errMsg != null) {
        ComShowMessage(errMsg);
    }
}

/**
 * sheet2 search end event
 * @param {ibsheet}	sheetObj	IBsheet object
 * @param {String}	errMsg		err message
 * @return
 */
function sheet2_OnSearchEnd(sheetObj, code, errMsg) {
    if (errMsg != null) {
        ComShowMessage(errMsg);
    }
    
    asaDetailFlg = "";
    var so_if_cd = sheetObj.GetEtcData("so_if_cd");
    var inv_ofc_cd = document.form.inv_ofc_cd.value;
    inv_ofc_cd = inv_ofc_cd != undefined && inv_ofc_cd != null ? inv_ofc_cd : '';
    
    if (inv_ofc_cd == 'SZPBB' || inv_ofc_cd == 'CANBS') {
        document.form.asanogb[0].disabled = false;
        document.form.asanogb[0].checked = true;
        document.form.asanogb[1].disabled = true;
        document.form.pay_group_cd[0].checked = true;
        document.form.pay_group_cd[0].disabled = false;
        document.form.pay_group_cd[1].disabled = false;
    } else {
        if (so_if_cd == "O") {
            document.form.asanogb[0].disabled = true;
            document.form.asanogb[1].checked = true;
            document.form.asanogb[1].disabled = false;
        }
    }
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * Check number
 * @param {Object}	obj		object	
 * @return	
 */
function isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
}

/**
 * 
 * @param {Object}	obj		object	
 * @return
 */
function isNum1(obj) {
    if (!ComIsNumber(obj, "-")) {
        obj.value = '';
    }
}

/**
 * check date
 * 
 * @param {Object}	obj		object	
 * @return
 */
function isDate1(obj) {
    if (!ComIsDate(obj)) {
        obj.value = '';
    }
}

/**
 *  getting Vender info
 *  @param(rowArray)
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    document.all.vndr_seq.value = colArray[2];
    document.all.vndr_seq_name.value = colArray[4];
}

/**
 * getting element count
 * 
 * @param {form} 	formObject		form object
 * @param {String}	eleTp			element type
 * @param {String}	eleNm			element name
 * @return
 */
function getElementCnt(formObject, eleTp, eleNm) {
    var cnt = 0;
    var element;
    var numOfEle = formObject.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm) {
            cnt++;
        }
    }
    return cnt;
}

/**
 * getting element value
 * 
 * @param {form} 	formObject		form object
 * @param {String}	eleTp			element type
 * @param {String}	eleNm			element name
 * @return
 */
function getElementValue(formObject, eleTp, eleNm) {
    var element;
    var numOfEle = formObject.elements.length;
    for (var i = 0; i < numOfEle; i++) {
        if (formObject.elements[i].type == eleTp && formObject.elements[i].name == eleNm) {
            if (formObject.elements[i].checked == true) {
                var ele_value = formObject.elements[i].value;
                break;
            }
        }
    }
    return ele_value;
}

/**
 *  validate vendor code
 */
function validateVendorCode() {
    var formObj = document.form;
    if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '') {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        return false;
    }
    if ((formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '') || formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim()) {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';

        var sRtnVal = getVndrSeqNm("vndr_seq_name");
        if (sRtnVal == "Y") {
            formObj.is_valid_vndr_seq.value = sRtnVal;
            formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
        }

        //tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVendorCode');
    }
}

/**
 *	check vendor code 
 */
function checkValidVendorCode() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.is_valid_vndr_seq.value != undefined && formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value.trim() != '') {
        tmp = formObj.is_valid_vndr_seq.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y') {
                formObj.vndr_seq_name.value = (tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
            } else {
                formObj.is_valid_vndr_seq.value = '';
                formObj.vndr_seq_hidden.value = '';
                //formObj.vndr_seq.value = '';
                formObj.vndr_seq_name.value = '';
                ComShowMessage(ComGetMsg('TES10067'));
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            //formObj.vndr_seq.value = '';
            formObj.vndr_seq_name.value = '';
            ComShowMessage(ComGetMsg('TES10067'));
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        //formObj.vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        ComShowMessage(ComGetMsg('TES10067'));
    }
}

/**
 * check cnt code 
 * 
 * @param cnt_cd
 * @return
 */
function checkCntCd(cnt_cd) {
    if (cnt_cd == "") {
        ComShowMessage(ComGetMsg('TES25018'));
        return false;
    }
}

/**
 * check enter key 
 */
function enter() {
    if (event.keyCode == 13) {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}

// UI 표준화관련 하단 여백 설정
function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
    ComResizeSheet(sheetObjects[1]);
}